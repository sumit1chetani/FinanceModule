//define([ 'hospital/accounts/accounts' ], function(module) {
  //  'use strict';
    app.controller('paymentInformationAdd', function($scope, $state, $http, ngDialog, logger, $stateParams, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.dataLoopCount = 0;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.companyList = [];

        $scope.pmtTypeList = [ {
            id : 'bank',
            text : 'Bank'
        }, {
            id : 'cash',
            text : 'Cash'
        } ]
        $scope.dataList = [];
        $scope.bankAccountList = [];
        $scope.cashAccountList = [];
        $scope.cbpdtlAcctHeadList = [];
        $scope.subAccountCodeList = [];
        $scope.currencyList = [];
        $scope.voyageList = [];
        $scope.vesselList = [];
        $scope.sectorList = [];
        $scope.pmtOrderNoList = [];
        $scope.paidToList = [];
        $scope.validated = false;
        $scope.edit = false;
        $scope.loadDropDownDetails = function() {

            $http.get( $stateParams.tenantid+'/app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            });           

        }

        $scope.loadDropDownDetails();
        
        
        
        
        $scope.exportExcel = function(){

            $http.post('app/paymentInformation/ExportExcel', $scope.paymentInformationData).success(function(response) {
                if(response){
                    debugger;
                    $("#pendingExport").bind('click', function() {
                    });
                    $('#pendingExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
                
            }).error(function(response) {
                logger.logError("Error Please Try Again");
            });

            }


        $.fn.simulateClick = function() {
        return this.each(function() {
            if ('createEvent' in document) {
                var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                this.dispatchEvent(evt);
            } else {
                this.click(); // IE
            }
        });
        }
        
        
     

   // })
        
	        
        /*

        $scope.paymentinformationexcel=function(){  
            console.log("payment ") 
              console.log() 

        $http.post('app/paymentInformation/ExportExcel', $scope.paymentInformationData).success(function(data) {
                  

            logger.logSuccess("Exported successfully.");
                       $('#paymentexportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/PayementInformation.xlsx" download="PayementInformation.xlsx"></a>');
                       $("#tbExcelExport").bind('click', function() {
                       });
                       $('#tbExcelExport').simulateClick('click');

                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
                         $.fn.simulateClick = function() {
                        return this.each(function() {
                            if ('createEvent' in document) {
                                var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                                evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                                this.dispatchEvent(evt);
                            } else {
                                this.click(); // IE
                            }
                        });
                    }

              
          }*/

        $scope.cancel = function() {
            $state.go('app.finance.accounts.paymentInformation.list');
        };

        $scope.paymentInformationData = {
            fromDate : '',
            toDate : '',
            supplier : '',
            poTcamt : '',
            poBcamt : '',
            paymentOrderNo : '',
            paymentOrderDate : '',
            supplierName : '',
            companyCode : 'C0002',
            detailBeans : []
        }

        $scope.isEdit = false;

        var paymentOrderNo = $location.search().paymentOrderNo;
        if (paymentOrderNo != undefined && paymentOrderNo != null) {
            $scope.isEdit = true;
            var resultBean = {
                paymentOrderNo : paymentOrderNo
            }
            $http.post('app/paymentInformation/edit', resultBean).success(function(datas) {
                $scope.paymentInformationData = datas;
                $scope.paymentInformationData.paymentOrderNo = datas.paymentOrderNo;
                $scope.paymentInformationData.paymentOrderDate = datas.paymentOrderDate;
                $scope.paymentInformationData.supplierName = datas.supplierName;
                $scope.paymentInformationData.poTcamt = datas.poTcamt;
                $scope.paymentInformationData.poBcamt = datas.poBcamt;
            }).error(function(datas) {
            });

        } else {
            $scope.isEdit = false;
        }

        $scope.date = '';

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; // January is 0!
        var yyyy = today.getFullYear();

        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        var today = dd + '/' + mm + '/' + yyyy;
        $scope.date = today;
        $scope.paymentInformationData.fromDate = $scope.date;
        $scope.paymentInformationData.toDate = $scope.date;

        $scope.$watch('paymentInformationData.toDate', function(newValue, oldValue) {
            if (newValue != "" && newValue != undefined && newValue != '') {
                if ($scope.paymentInformationData.fromDate != undefined && $scope.paymentInformationData.fromDate != '' && $scope.paymentInformationData.fromDate != "") {
                    var fromDate = $scope.paymentInformationData.fromDate;
                    var toDate = newValue;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    if (fromDate > toDate) {
                        logger.logError("To Date should be greater than the from date");
                        $scope.paymentInformationData.toDate = '';
                    }
                }

            }

        });

        $scope.$watch('paymentInformationData.fromDate', function(newValue, oldValue) {
            if (newValue != "" && newValue != undefined && newValue != '') {
                if ($scope.paymentInformationData.toDate != undefined && $scope.paymentInformationData.toDate != '' && $scope.paymentInformationData.toDate != "") {
                    var fromDate = $scope.paymentInformationData.toDate;
                    var toDate = newValue;
                    fromDate = fromDate.split("/");
                    fromDate = new Date(fromDate[2], fromDate[1] - 1, fromDate[0]);
                    toDate = toDate.split("/");
                    toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
                    if (fromDate < toDate) {
                        logger.logError("From Date should be lesser than the to date");
                        $scope.paymentInformationData.fromDate = '';
                    }
                }

            }

        });

        $scope.calculateTotal = function() {
            $scope.paymentInformationData.poTcamt = 0;
            $scope.paymentInformationData.poBcamt = 0;
            angular.forEach($scope.paymentInformationData.detailBeans, function(value, index) {
                $scope.paymentInformationData.poTcamt = Number($scope.paymentInformationData.poTcamt) + Number($scope.isNaNCheck(value.payableTcAmt));
                $scope.paymentInformationData.poBcamt = Number($scope.paymentInformationData.poBcamt) + Number($scope.isNaNCheck(value.payableBcAmt));
                $scope.paymentInformationData.poTcamt = $scope.paymentInformationData.poTcamt.toFixed(2);
                $scope.paymentInformationData.poBcamt = $scope.paymentInformationData.poBcamt.toFixed(2);
            });

        }

        $scope.calculateTotalBC = function() {
            $scope.paymentInformationData.poTcamt = 0;
            $scope.paymentInformationData.poBcamt = 0;
            angular.forEach($scope.paymentInformationData.detailBeans, function(value, index) {
                value.payableTcAmt = Number($scope.isNaNCheck(value.payableBcAmt)) * +Number($scope.isNaNCheck(value.exchangeRate))
                $scope.paymentInformationData.poTcamt = Number($scope.paymentInformationData.poTcamt) + Number($scope.isNaNCheck(value.payableTcAmt));
                $scope.paymentInformationData.poBcamt = Number($scope.paymentInformationData.poBcamt) + Number($scope.isNaNCheck(value.payableBcAmt));
                $scope.paymentInformationData.poTcamt = $scope.paymentInformationData.poTcamt.toFixed(2);
                $scope.paymentInformationData.poBcamt = $scope.paymentInformationData.poBcamt.toFixed(2);
            });

        }

        $scope.calculateSelectedTotal = function() {
            $scope.paymentInformationData.poTcamt = 0;
            $scope.paymentInformationData.poBcamt = 0;
            angular.forEach($scope.paymentInformationData.detailBeans, function(value, index) {
                if (value.select == true) {
                    $scope.paymentInformationData.poTcamt = Number($scope.paymentInformationData.poTcamt) + Number($scope.isNaNCheck(value.payableTcAmt));
                    $scope.paymentInformationData.poBcamt = Number($scope.paymentInformationData.poBcamt) + Number($scope.isNaNCheck(value.payableBcAmt));
                    $scope.paymentInformationData.poTcamt = $scope.paymentInformationData.poTcamt.toFixed(2);
                    $scope.paymentInformationData.poBcamt = $scope.paymentInformationData.poBcamt.toFixed(2);

                }

            });

        }

        $scope.validate = function(cashBankPaymentForm) {
            if (new validationService().checkFormValidity(cashBankPaymentForm)) {
                var resultbean = {
                    fromDate : $scope.paymentInformationData.fromDate,
                    toDate : $scope.paymentInformationData.toDate,
                    supplier : $scope.paymentInformationData.supplier,
                    companyCode : $scope.paymentInformationData.companyCode,
                }
                $http.post('app/paymentInformation/list', resultbean).success(function(datas) {
                    $scope.paymentInformationData.detailBeans = datas.informationDtlBeanslist;
                    angular.forEach($scope.paymentInformationData.detailBeans, function(value, key) {
                        value.invTcAmt = (value.invBcAmt * value.exchangeRate).toFixed(3);
                        value.payableBcAmt = value.bcBalanceAmt;
                        value.payableTcAmt = (value.bcBalanceAmt * value.exchangeRate).toFixed(3);

                    });
                    $scope.calculateTotal();
                }).error(function(datas) {
                });
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(cashBankPaymentForm.$validationSummary), 5000, 'trustedHtml');
            }
        }
        $scope.isNaNCheck = function(value) {
            if (isNaN(value)) {
                value = 0;
            }
            return value;
        }

        $scope.save = function() {
            $scope.paymentInformationData.detailBeans = $scope.paymentInformationData.detailBeans;
            $scope.paymentInformationData.paymentOrderDate = $scope.date;
            $scope.calculateSelectedTotal();
            var isValid = false;
            angular.forEach($scope.paymentInformationData.detailBeans, function(row) {
                if (row.select == true) {
                    isValid = true;
                }
            });
            if (isValid) {
                var isValid1 = true;
                angular.forEach($scope.paymentInformationData.detailBeans, function(row) {
                    if (row.payableBcAmt > row.bcBalanceAmt) {
                        isValid1 = false;
                    }
                });
                if (isValid1) {
                    $http.post('app/paymentInformation/save', $scope.paymentInformationData).success(function(datas) {
                        $scope.paymentInformationData.paymentInformationDtlArr = datas.informationDtlBeanslist;
                        if (datas) {
                            logger.logSuccess("Record Saved Successfully");
                            $state.go('app.finance.accounts.paymentInformation.list');
                        } else {
                            logger.logError("Not Saved");
                        }

                    }).error(function(datas) {
                    });
                } else {
                    logger.logError("Pay Amount should be less than or equval to Payable  Amount")
                }

            } else {
                logger.logError("Please Select At least one item");
            }
        }

        $scope.update = function() {
            $scope.paymentInformationData.detailBeans = $scope.paymentInformationData.detailBeans;
            var isValid = true;
            angular.forEach($scope.paymentInformationData.detailBeans, function(value, row) {
                if (value.payableBcAmt > value.payableAmt) {
                    isValid = false;
                }
            });
            if (isValid) {
                $http.post('app/paymentInformation/update', $scope.paymentInformationData).success(function(datas) {
                    $scope.paymentInformationData.paymentInformationDtlArr = datas.informationDtlBeanslist;
                    if (datas) {
                        logger.logSuccess("Record Updated Successfully");
                        $state.go('app.finance.accounts.paymentInformation.list');
                    } else {
                        logger.logError("Not Updated");
                    }

                }).error(function(datas) {
                });
            } else {
                logger.logError("Amount Should not exceed");
            }
        }

        $http.get(   $stateParams.tenantid+'/app/commonUtility/getSupplierList').success(function(datas) {
            $scope.supplierList = datas;
        }).error(function(datas) {
        });

   // })
});