///define([ 'hospital/accounts/accounts' ], function(module) {

   // 'use strict';
    app.controller('cashBankReceiptListCtrl', function($scope, $state,$stateParams, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.initial = {};
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.receiptCode = '';

        $scope.objCBReceipt = {
                cbReceiptDate:''
        }
        /**
         * get Receipt List
         * ***************************************************************
         */
        $scope.getCBRcptList = function(limit, offset) {
            var start = new Date().getTime();

            var url = 'app/cashbankreceipt/cbrList?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushCBReceiptListUtil(data);
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

        $scope.pushCBReceiptListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lCashbankReceiptListBean)) {
                $scope.showEmptyLabel = true;
            } else {
                $scope.rowCollection = data.lCashbankReceiptListBean;
            }
        };

        $scope.getCBRcptList();

        $scope.add = function() {
            $state.go("app.finance.accounts.paymentreceipt.add");
        };
        $scope.editCBRcptRow = function(voucherNo) {
            $location.path($stateParams.tenantid +"/hospital/accounts/paymentreceipt/edit/" + voucherNo);
        };
        /**
         * delete CB Rcpt Row
         * *******************************************************
         */
        $scope.deleteCBRcptRow = function(voucherNo, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/cashbankreceipt/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : voucherNo,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });
        };

        /**
         * Copy Receipt ****************************
         */
        $scope.copyReceipt = function() {
            if ($scope.receiptCode == "" || $scope.receiptCode == undefined) {
                logger.logError("Please Select Receipt Voucher");
            } else {
                $location.path("/transaction/cashbankreceipt/copy/" + $scope.receiptCode);
            }

        }

        /**
         * Reverse Receipt ****************************
         */
        $scope.reverseConfirm = function() {
            if ($scope.receiptCode == "" || $scope.receiptCode == undefined) {
                logger.logError("Please select Receipt Voucher");
            } else {

                if($scope.objCBReceipt.cbReceiptDate != null && $scope.objCBReceipt.cbReceiptDate != "" && 
                        $scope.objCBReceipt.cbReceiptDate != ""){
//                $scope.receiptCode.createdDate = $scope.objCBReceipt.cbReceiptDate;
                $http.get('app/cashbankreceipt/reverseReceipt?receiptVoucherNo='+ $scope.receiptCode+'&createdDate='+$scope.objCBReceipt.cbReceiptDate).success(function(datas) {
                    if (datas.success == true) {
                        logger.logSuccess(datas.sErrorMessage);
                        ngDialog.close();   
                        $scope.getCBRcptList();
                    } else {
                        logger.logError(datas.sErrorMessage);
                    }
                }).error(function(datas) {
                });
            }else{
                logger.logError("Please select Receipt Date!");

            }
            }
        }
        
        $scope.reverseReceipt = function() {

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

            $scope.objCBReceipt.cbReceiptDate = today1;
            $scope.screenNames = "receipt";
            if($scope.receiptCode =="" || $scope.receiptCode ==undefined){
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
        $scope.printReceiptVoucherDiv = function(voucherNo) {
            var url = 'app/cashbankreceipt/print?voucherNo=' + voucherNo;
            var wnd = window.open(url, 'Title', 'width=500,height=700,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
            
            /* var wnd = window.open(url, 'HISERP', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
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
            }*/
        }
        
        $scope.printReceiptVoucherDivoff = function(voucherNo) {
            var url = 'app/cashbankreceipt/printoff?voucherNo=' + voucherNo;
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
        
      /*  $scope.payerReceipt = function(voucherNo) {
        	alert ("sumit chetani")
            var url = 'app/cashbankreceipt/print?voucherNo=' + voucherNo;
            var wnd = window.open(url, 'Title', 'width=500,height=700,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }*/
        
        $scope.payerReceipt = function(voucherNo) {
            var url = 'app/cashbankreceipt/payerReceipt?voucherNo=' + voucherNo;
            var wnd = window.open(url, 'Title', 'width=500,height=700,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();
        }
        

        $scope.viewCBRcptRow = function(objCashBankRCptListItem) {
            $location.url($stateParams.tenantid+'/hospital/accounts/paymentreceipt/view/' + objCashBankRCptListItem.id);
        }
   // });

});