
    'use strict';
    app.factory('QUOTATION', function($http, $q, logger,$stateParams) {
        var QUOTATION = new Object();
        QUOTATION.getCustomerList = function(){
            var serviceData=$q.defer();
            $http.post($stateParams.tenantid+'/report/auditTrial/quotation/employeeList').success(function(resultBean){
                if (resultBean.success == true) {
                    serviceData.resolve(resultBean);
                } else {
                    logger.logError("Error Please Try Again");
                } 
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            return serviceData.promise;
        }
        QUOTATION.getQuotationList = function(obj){
            var quotationData=$q.defer();
            $http.post($stateParams.tenantid+'/report/auditTrial/quotation/quotationList', obj).success(function(resultBean) {
            if (resultBean.success = true) {
                quotationData.resolve(resultBean);
            } else {
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        return quotationData.promise;
    }
        return QUOTATION;

    })
   app.controller('quotationAuditTrialCtrl', function($scope, $timeout,$rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService, QUOTATION, $state, sharedProperties,$stateParams) {
        $scope.customerList=[];
        $scope.quotationList=[];
        $scope.rowCollection = [];
        $scope.quotation = {           
                customerCode : '',
                fromDate : '',
                toDate:'',
                type:'',
                mode:'1',
        };
        
        $scope.modeList = [ {
			id : '1',
			text : 'Sea'
		}, {
			id : '2',
			text : 'Air'
		} ];
        $("#employee").multiselect({
            maxHeight : 200,
            includeSelectAllOption : true,
            enableCaseInsensitiveFiltering : true,
            disableIfEmpty : true,
            onDropdownHide : function(event) {

            }
        });
        $("#multiselect-button").addClass("width_100 input-sm line-height-5");
        $scope.getCustomerList = function() {
            $scope.tempList = QUOTATION.getCustomerList();
            $scope.tempList.then(function(data) {
                console.log(data)
                $scope.customerList = data.employeeList;
                $timeout(function() {
                    $('#employee').multiselect('deselectAll', false);
                    $('#employee').multiselect('updateButtonText');
                    $("#employee").multiselect('rebuild');

                }, 2, false);
            })
        }
        $scope.getCustomerList();
        
        $scope.search=function(){
            $scope.rowCollection = [];
            if($scope.employee != null && $scope.employee != '' && $scope.employee != undefined){
                $scope.quotation.customerCode = $scope.employee.join("','");
            }
            if($scope.quotation.mode != null && $scope.quotation.mode != '' && $scope.quotation.mode != undefined){
            $scope.tempList = QUOTATION.getQuotationList($scope.quotation);
            $scope.tempList.then(function(data) {
                console.log(data)
                $scope.quotationList=data.quotationList;
                $scope.rowCollection = [];
                $scope.rowCollection = $scope.rowCollection.concat($scope.quotationList);               
            })
            } else{
            	logger.logError("Please Select Mode");
            }
        }
        
        $scope.exportData = function(contInvoice) {
            if($scope.employee != null && $scope.employee != '' && $scope.employee != undefined){
                $scope.quotation.customerCode = $scope.employee.join("','");
            }
            if($scope.quotation.mode != null && $scope.quotation.mode != '' && $scope.quotation.mode != undefined){
            $http.post($stateParams.tenantid+'/report/auditTrial/quotation/viewExcel',$scope.quotation).success(function(data) {
                $("#tbPdfExport").bind('click', function () {
                  //  alert('clicked');
                    
                 });
                $('#tbPdfExport').simulateClick('click');
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            } else{
            	logger.logError("Please Select Mode");
            }
          
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
    
    