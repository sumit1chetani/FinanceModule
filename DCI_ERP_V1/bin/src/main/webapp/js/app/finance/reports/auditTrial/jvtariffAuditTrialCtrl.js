
    'use strict';
    app.factory('QUOTATION', function($http, $q, logger) {
        var QUOTATION = new Object();
        QUOTATION.getCustomerList = function(){
            var serviceData=$q.defer();
            $http.post($stateParams.tenantid+'/report/auditTrial/quotation/employeeList').success(function(resultBean){
                if (resultBean.success = true) {
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
            $http.post($stateParams.tenantid+'/report/auditTrial/quotation/jvTariffList', obj).success(function(resultBean) {
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
   app.controller('JvtariffAuditTrialCtrl', function($scope, $timeout,$rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService, QUOTATION, $state, sharedProperties,$stateParams) {
        $scope.customerList=[];
        $scope.quotationList=[];
        $scope.rowCollection = [];
        $scope.quotation = {           
                customerCode : '',
                fromDate : '',
                toDate:'',
                type:''
        };
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
            
            $scope.tempList = QUOTATION.getQuotationList($scope.quotation);
            $scope.tempList.then(function(data) {
                console.log(data)
                $scope.quotationList=data.quotationList;
                $scope.rowCollection = [];
                $scope.rowCollection = $scope.rowCollection.concat($scope.quotationList);
            })
        }
        
        $scope.exportData = function(contInvoice) {
            if($scope.employee != null && $scope.employee != '' && $scope.employee != undefined){
                $scope.quotation.customerCode = $scope.employee.join("','");
            }
            var d = new Date();
            var n = d.getMinutes();
            var s = d.getSeconds();
            var mon=Number(d.getMonth())+1;
            var day=d.getDate();
            var yr=d.getFullYear();
            var ms=d.getMilliseconds();
            
            $scope.quotation.validFrom = $('#validFrom').val();
            $scope.quotation.validTo = $('#validTo').val();
            
            $scope.filename="JvTariffAuditReport"+day+""+mon+""+yr+""+n+""+s+""+ms+".xls";
            
            $scope.quotation.filename="JvTariffAuditReport"+day+""+mon+""+yr+""+n+""+s+""+ms;
            $http.post($stateParams.tenantid+'/report/auditTrial/quotation/jVviewExcel',$scope.quotation).success(function(data) {
                $('#exportXl').remove();
                $('.excel').append('<div id="exportXl"></div>');
                        var file='<a id="tbExcelExport" stype="display:none" href="filePath/'+$scope.filename+'" download="'+$scope.filename+'"></a>'
                    
                       $('#exportXl').append(file);
                $("#tbExcelExport").bind('click', function () {
                  //  alert('clicked');
                    
                 });
                $('#tbExcelExport').simulateClick('click');
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
    
    