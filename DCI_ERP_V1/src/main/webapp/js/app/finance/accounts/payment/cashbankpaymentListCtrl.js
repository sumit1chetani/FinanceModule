//define([ 'hospital/accounts/accounts' ], function(module) {

   // 'use strict';
    app.controller('CashBankPaymentListCtrl', function($scope, $state,$stateParams, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.paymentCode = '';

        var reversePaymentData = [];

        $scope.objCBPayment = {
                cbPaymenttDate:''
        }
        /**
         * get Payment List in list page
         * ********************************************************************
         */
        $scope.getCBPaymentListUtil = function() {
            var start = new Date().getTime();

            var url = 'app/cashbankPayment/cbplist?limit=' + $scope.limitCount + '&offset=' + $scope.limitCount;
            $http.get(url).success(function(data) {
                reversePaymentData = data;
                if (data.success == true) {
                    angular.forEach(data.lCashbankpaymentBean, function(value, key) {
                        if (value.reverseCb == "Y") {
                            value.reverseCb = "Y";
                        } else {
                            value.reverseCb = "N";
                        }
                    });

                    $scope.pushCBPaymentListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.pushCBPaymentListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lCashbankpaymentBean)) {
                $scope.showEmptyLabel = true;
            } else {
                $scope.rowCollection = data.lCashbankpaymentBean;
            }
        };
        $scope.getCBPaymentListUtil();

        $scope.add = function() {
            $state.go("app.finance.accounts.payment.add");
        };

        /**
         * Call Edit
         */
        $scope.viewCBPmtRow = function(voucherNo) {
          //  alert(5);
            $location.path($stateParams.tenantid +'/hospital/accounts/payment/view/' + voucherNo);
        }
        
        //View
        
        $scope.editCBPmtRow = function(voucherNo) {
            $location.path($stateParams.tenantid +'/hospital/accounts/payment/edit/' + voucherNo);

        }
        /**
         * Call Delete
         */
        $scope.deleteCBPmtRow = function(collections, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/cashbankPayment/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : collections.cbVoucherNo,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });
        };

        /**
         * copy Payment
         */
        $scope.copyPayment = function() {
            if ($scope.paymentCode == "" || $scope.paymentCode == undefined) {
                logger.logError("Please select payment");
            } else {
                $location.path("/transaction/cashbankPayment/copy/" + $scope.paymentCode);
            }

        }

        /**
         * reverse payment
         */
        $scope.reverseConfirm = function() {
            if ($scope.paymentCode == "" || $scope.paymentCode == undefined) {
                logger.logError("Please Select Voucher No!");
            } else {
                if($scope.objCBPayment.cbPaymenttDate != null && $scope.objCBPayment.cbPaymenttDate != "" && 
                        $scope.objCBPayment.cbPaymenttDate != ""){
//                $http.post('app/cashbankPayment/reversePayment', $scope.paymentCode).success(function(datas) {
                    $http.get('app/cashbankPayment/reversePayment?voucherNo='+ $scope.paymentCode
                            +'&createdDate='+$scope.objCBPayment.cbPaymenttDate).success(function(datas) {

                    if (datas.success == true) {
                        logger.logSuccess(datas.message);
                        ngDialog.close();   
                        $scope.getCBPaymentListUtil();
                    } else {
                        
                        logger.logError(datas.message);
                    }
                }).error(function(datas) {
                });
                }else{
                    logger.logError("Please Select Payment Date!");
 
                }
            }
        }
        

        $scope.reversePayment = function() {

            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1;

            var yyyy = today.getFullYear();
            var hh = today.getHours();

            var min = today.getMinutes();
            if (dd < 10) {
                dd = '0' + dd;
            }
            if (mm < 10) {
                mm = '0' + mm;
            }
            var today = dd + '/' + mm + '/' + yyyy+" "+hh+":"+min;
            var today1 = dd + '/' + mm + '/' + yyyy;

            $scope.objCBPayment.cbPaymenttDate =today1;
            $scope.screenNames = "payment";
            if($scope.paymentCode =="" || $scope.paymentCode ==undefined){
                logger.logError("Please select receipt Voucher");
            }else{         
                ngDialog.open({
                    template : 'views/finance/accounts/paymentreceipt/transactionCBRreverse',
                    scope :$scope
                });
            }
              
        };

        $scope.closeCBPReverseDialog = function() {
            ngDialog.close();    
        };
        /**
         * Receipt Print****************************
         */
        $scope.printPaymentVoucherDiv = function(voucherNo) {
            var url = 'app/cashbankPayment/print?cbVoucherNo=' + voucherNo;
            var wnd = window.open(url, 'HISERP', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            //wnd.print();
            if (wnd.print) {
                var done = false;
                if (wnd.document && wnd.document.readyState) {
                    var rs = wnd.document.readyState;
                    if ((rs === 'complete') || (rs === 'loaded')) {
                        done = true;
                        wnd.print();
                    }
                }
                if (!done) {
                    if (wnd.addEventListener) {
                        wnd.addEventListener('load', function() {
                            this.print();
                        });
                    } else {
                        wnd.onload = function() {
                            this.print();
                        };
                    }
                }
            }
        }
        
        //PRINT OFF
        $scope.printPaymentVoucherDivoff = function(voucherNo) {
            var url = 'app/cashbankPayment/printoff?cbVoucherNo=' + voucherNo;
            var wnd = window.open(url, 'HISERP', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            //wnd.print();
            if (wnd.print) {
                var done = false;
                if (wnd.document && wnd.document.readyState) {
                    var rs = wnd.document.readyState;
                    if ((rs === 'complete') || (rs === 'loaded')) {
                        done = true;
                        wnd.print();
                    }
                }
                if (!done) {
                    if (wnd.addEventListener) {
                        wnd.addEventListener('load', function() {
                            this.print();
                        });
                    } else {
                        wnd.onload = function() {
                            this.print();
                        };
                    }
                }
            }
        }

   // });

});