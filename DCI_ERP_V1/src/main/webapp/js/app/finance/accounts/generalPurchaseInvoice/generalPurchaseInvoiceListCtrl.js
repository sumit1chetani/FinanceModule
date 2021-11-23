//define([ 'hospital/accounts/accounts' ], function(module) {

  //  'use strict';
    app.controller('generalPurchaseInvoiceListCtrl', function($scope,$stateParams , $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state, $window) {

        $scope.pageCounters = [ 14, 16, 17, 18, 150, 500, 1000 ];

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 14;
        $scope.initial = {};
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.getPurchaseInvoiceList = function() {

            $http.get('app/generalpurchaseinvoice/list?limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount).success(function(data) {
                if (data.success == true && !utilsService.isUndefinedOrNull(data.objPuInvHdrLstBean)) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.objPuInvHdrLstBean);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

        $scope.getPurchaseInvoiceList();

        // ** ********Add,Edit and Delete******** *//*
        $scope.add = function() {
           // $location.path("/hospital/accounts/generalPurchaseInvoice/add");
            $state.go('app.finance.accounts.generalpurchaseinvoice.add');


        };

        // Redirecting Page For Edit Functionality
        $scope.editRow = function(purchaseInvoiceNo, index) {
            var invoiceNo = purchaseInvoiceNo.toString();
            $location.path($stateParams.tenantid+'/hospital/accounts/generalPurchaseInvoiceEdit/' + invoiceNo);
        };

        // remove to the real data holder
        $scope.deleteRow = function(puchaseInvoiceNo, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/purchaseinvoice/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : puchaseInvoiceNo,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Purchase Invoice deleted successfully");
                    } else {
                        logger.logError("Error in deleting Purchase Invoice master!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete Purchase Invoice Master!");
                });
                console.log('Modal promise resolved. Value: ');
            }, function(reason) {
                console.log('Modal promise rejected. Reason: ', reason);
            });

        };
        // Print
     /*   $scope.printPIRow = function(puchaseInvoiceNo) {
            var url = 'app/generalpurchaseinvoice/exportPurchaseInvoicePdf?purchaseInvoiceNo=' + puchaseInvoiceNo;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $window.open('tempdoc/PurchaseInvoice.pdf', 'Title', 'width=600,height=700');
                } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }*/
        
        
        $scope.printPIRow = function(invoiceNo) {
            var url = 'app/generalpurchaseinvoice/print?cbVoucherNo=' + invoiceNo;
            var wnd = window.open(url, 'HISERP', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
            wnd.print();

        }
        $scope.fileUpload = function() {
            ngDialog.close();
            ngDialog.open({
                template : 'fileModal',
                scope : $scope
            });
        };
        $rootScope.uploadFile = function(element) {
            console.log("excel file");
            $scope.excelfile = element.files[0];
            console.log($scope.excelfile);
        };

        $rootScope.closeFileDialog = function() {
            ngDialog.close();
        };
        

        $rootScope.uploadPIN = function() {
            ngDialog.close();
            var excelfile = $scope.excelfile;
            var fileExtension = excelfile.name;
            var fName = [];
            fName = fileExtension.split(".");
            for (var i = 0; i < fName.length; i++) {
                if (fName[i] == "xls" || fName[i] == "xlsx") {
                    var frmData = new FormData();
                    frmData.append("file", excelfile);
                    $.ajax({
                        type : "POST",
                        url : "app/purchaseinvoice/uploadfile",
                        data : frmData,
                        contentType : false,
                        processData : false,
                        success : function(result) {
                            console.log("result");
                            console.log(result);
                            if (result.success) {
                                logger.logSuccess("File Uploaded Successfully");
                                $scope.rowCollection=[];
                                $scope.getPurchaseInvoiceList();
                            } else {
                                logger.logError(result.message);
                            }
                        }
                    });
                }
            }
        };
        
    });
//});