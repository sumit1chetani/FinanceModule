
    'use strict';
    app.factory('INVOICE', function($http, $q, logger,$stateParams) {
        var INVOICE = new Object();
        INVOICE.getInvoiceList = function(obj){
            var invoiceData=$q.defer();
            $http.post($stateParams.tenantid+'/report/auditTrial/singleInvoice/invoiceList', obj).success(function(resultBean) {
            if (resultBean.success = true) {
                invoiceData.resolve(resultBean);
            } else {
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        return invoiceData.promise;
    }
        return INVOICE;

    })
   app.controller('siAuditTrialCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService, INVOICE, $state, sharedProperties,$stateParams) {
        $scope.invoiceList=[];
        $scope.rowCollection = [];
        $scope.customerList=[];
        $scope.invoice = {   
                customerCode:'',
                fromDate : '',
                toDate:''
        };
        $scope.search=function(){
            $scope.rowCollection = [];
            $scope.tempList = INVOICE.getInvoiceList($scope.invoice);
            $scope.tempList.then(function(data) {
                console.log(data)
                $scope.invoiceList=data.singleInvoiceList;
                $scope.rowCollection = [];
                $scope.rowCollection = $scope.rowCollection.concat($scope.invoiceList);
                angular.forEach($scope.invoiceList,function(value,key){
                	if(value.vessel=='1'){
                		value.vessel = 'Sea';
                	}else if(value.vessel=='2'){
                		value.vessel = 'Air';
                	}
                });
            })
        }
        $scope.getCustomerList=function(){
            $http.post($stateParams.tenantid+'/report/auditTrial/singleInvoice/employeeList').success(function(data) {
               $scope.customerList=data.customerList;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
        $scope.getCustomerList();
        $scope.exportData = function(contInvoice) {
            $http.post($stateParams.tenantid+'/report/auditTrial/singleInvoice/viewExcel',$scope.invoice).success(function(data) {
                $("#tbPdfExport").bind('click', function () {
                  //  alert('clicked');
                    
                 });
                $('#tbPdfExport').simulateClick('click');
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
          
        }
        $.fn.simulateClick = function() {
            return this.each(function() {
        if('createEvent' in document) {
            var doc = this.ownerDocument,
                evt = doc.createEvent('MouseEvents');
            evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
            this.dispatchEvent(evt);
        } else {
            this.click(); // IE
        }
        });
        }
   });
    
    