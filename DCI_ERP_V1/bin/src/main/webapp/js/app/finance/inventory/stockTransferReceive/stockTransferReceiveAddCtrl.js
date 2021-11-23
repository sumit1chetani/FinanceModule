/*define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';
    module.registerController('stockTransferReceiveAddCtrl', function($scope, $state, $http, ngDialog, $filter, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {*/
    
    
     app.controller('stockTransferReceiveAddCtrl', function($scope, $state, $http, $location, sharedProperties,
           toaster,$injector,logger,ngDialog,$rootScope,$stateParams,$controller) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.ItemList = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.tableSelection = [];
        $scope.companyList = [];
        $scope.isEdit = false;

        $scope.stockReceive = {
            receivedDate : '',
            receivedNo : '',
            receivedId : '',
            transferId : '',
            transferNo : '',
            destLocId : '',
            destLocName : '',
            sourceLocId : '',
            sourceLocName : '',
            requestedBy : '',
            requestedDate : '',
            transferDate : '',
            companyId : '',
            companyName : '',
            transferDtls : []

        };

        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        if (month < 10) {
            month = "0" + month;
        }
        ;
        var day = d.getDate();
        $scope.date = day + "/" + month + "/" + year;
        $scope.stockReceive.receivedDate = $scope.date;

        $scope.stockTransferList = [];
        $scope.dropdownvalue = function() {
            $http.get("hospital/inventory/transferReceive/transferNolist?transType=stock").success(function(response) {
                $scope.stockTransferList = response;
            }).error(function(response) {
                logger.logError("Error Please Try Again");
            });
            $http.get('app/hospital/purchase/storeToStore/employeeList').success(function(datas) {
                $scope.stockReceive.receivedByCode = datas.userId;
            });

           /* $http.get('app/commonUtility/getCompanyList').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });*/
           /* $http.get('app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
                }).error(function(datas) {
            });*/
            
             $http.get($stateParams.tenantid + '/app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });
        }
        $scope.dropdownvalue();

        $scope.$watch('stockReceive.transferId', function(newValue, oldValue) {

            if (newValue != '' && newValue != undefined) {

                if ($scope.stockTransferList != undefined && $scope.stockTransferList.length != 0) {
                    $scope.transferOnchange(newValue);
                } else {
                    $scope.dropdownvalue();
                }

            }

        });

        $scope.receiveItemList = [];
        $scope.transferOnchange = function(transferId) {
            var obj = $filter('filter')($scope.stockTransferList, {
                id : transferId
            });

            $scope.stockReceive.transferNo = obj[0].transferNo;
            $scope.stockReceive.transferDate = obj[0].transferDate;
            $scope.stockReceive.sourceLocName = obj[0].sourceLocName;
            $scope.stockReceive.destLocName = obj[0].destLocName;
            $scope.stockReceive.sourceLocId = obj[0].sourceLocId;
            $scope.stockReceive.destLocId = obj[0].destLocId;
            $scope.stockReceive.requestedBy = obj[0].requestedBy;

            $http.post("hospital/inventory/transferReceive/receiveItem", transferId).success(function(response) {
                if (response.success == true) {
                    $scope.stockReceive.transferDtls = response.transferDetailBeanList;
                }

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }

      /*  $scope.getBatchDetails = function(rowId, itemCode) {
            var transferId = $scope.stockReceive.transferId;
            $scope.callDialogBatchNo($scope, $http, itemCode, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, transferId, rowId);
        };*/
/*
        $scope.callDialogBatchNo = function($scope, $http, itemCode, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, transferId, rowId) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/stockTransferReceive/stockTransferReceivePopupBatch',
                controller : $controller('stockTransferPopupCtrl', {
                    $scope : $scope,
                    $http : $http,
                    itemCode : itemCode,
                    transferId : transferId,
                    rowId : rowId,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });

            $http.get('app/grn/getItemAttributes?itemId=' + itemCode).success(function(result) {
                $scope.itemBatch = result.itemAttributes.itemBatch;
                $scope.itemExpDate = result.itemAttributes.itemExpDate;
                $scope.itemManufacture = result.itemAttributes.itemManufacture;
                $scope.itemMrp = result.itemAttributes.itemMrp;
            })
        }*/
/*
        $scope.getBatchViewDetails = function(rowId, itemCode) {
            var transferId = $scope.stockReceive.transferId;
            $scope.callDialogBatchViewNo($scope, $http, itemCode, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, transferId, rowId);
        };

        $scope.callDialogBatchViewNo = function($scope, $http, itemCode, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, transferId, rowId) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/stockTransferReceive/stockTransferReceivePopupBatchView',
                controller : $controller('stockMovementPopupViewCtrl', {
                    $scope : $scope,
                    $http : $http,
                    itemCode : itemCode,
                    transferId : transferId,
                    rowId : rowId,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope
                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });

            $http.get('app/grn/getItemAttributes?itemId=' + itemCode).success(function(result) {
                $scope.itemBatch = result.itemAttributes.itemBatch;
                $scope.itemExpDate = result.itemAttributes.itemExpDate;
                $scope.itemManufacture = result.itemAttributes.itemManufacture;
                $scope.itemMrp = result.itemAttributes.itemMrp;
            })
        }*/

        $scope.reset = function() {
            $scope.stockReceive = {
                receivedDate : '',
                receivedNo : '',
                receivedId : '',
                transferId : '',
                transferNo : '',
                destLocId : '',
                destLocName : '',
                sourceLocId : '',
                sourceLocName : '',
                requestedBy : '',
                requestedDate : '',
                transferDate : '',
                companyId : '',
                companyName : '',
                transferDtls : []

            };
            $scope.stockReceive.receivedDate = $scope.date;
            $scope.dropdownvalue();
        }

        $scope.cancel1 = function() {
            $state.go('app.finance.inventory.stockTransferReceive.list');
        };

        $scope.validateQty = function(stockReceive) {

            var msg = "", flag = true;
            for (var i = 0; i < $scope.stockReceive.transferDtls.length; i++) {

                var pendingquantity = stockReceive.transferDtls[i].pendingQty;
                var quantity = parseInt(stockReceive.transferDtls[i].receivedQty);
                if (quantity > pendingquantity) {
                    msg = "Receiving Qty should not exceed Pending Qty for Item : " + stockReceive.transferDtls[i].text;
                    flag = false;
                }

            }
            if (!flag) {
                logger.logError(msg);
            }
            return flag;
        }

        $scope.save = function(stockReceiveForm, stockReceive) {

            var flag = true;
           // var batchValid = true;
            if (new validationService().checkFormValidity($scope.stockReceiveForm)) {
                if ($scope.validateQty(stockReceive)) {
                    angular.forEach($scope.stockReceive.transferDtls, function(value, key) {
                        if (value.receivedQty <= 0 || value.transferQty <= 0) {
                            flag = false;
                        }
                        if (value.attributeBeans == null || value.attributeBeans == undefined || value.attributeBeans == '') {
                           /* if (value.isBatchNoExist == true) {
                                batchValid = false
                            }*/
                        } else {
                            if (value.attributeBeans.length == 0) {
                                /*if (value.isBatchNoExist == true) {
                                    batchValid = false
                                }*/
                            }
                            if (value.attributeBeans.length > 0) {
                               // var batchList = [];
                                angular.forEach(value.attributeBeans, function(value1, key1) {
                                    value1.originalConvertedQty = value1.receiveQty;
                                   /* if (value1.receiveQty > 0) {
                                        batchList.push(value1);
                                    }*/
                                });
                                value.attributeBeans /*= batchList*/;
                            }

                        }

                    });
                    if (flag == true ) {
                        $http.post("hospital/inventory/transferReceive/saveTransferRecive", stockReceive).success(function(response) {
                            if (response == true) {
                                logger.logSuccess("Data Saved Successfully");
                                $state.go('app.hospital.inventory.stockTransferReceive.list');
                            }
                        }).error(function(result) {
                            logger.logError("Error Please Try Again");
                        });
                    } else {
                        if (flag == false) {
                            logger.logError("Quantity should be greater than zero");
                        }
                        /*if (batchValid == false) {
                            logger.logError("Please Add Batch Details");
                        }*/

                    }

                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.stockReceiveForm.$validationSummary), 555000, 'trustedHtml');
            }
        }

        $scope.viewReceiveData = function() {

            $http.get("hospital/inventory/transferReceive/transferNolist?transType=stock").success(function(response) {

                $scope.transferList = response;

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
            $http.get('app/hospital/purchase/storeToStore/employeeList').success(function(datas) {

                $scope.stockReceive.receivedByCode = datas.userId;

            });

            $http.get('hospital/inventory/transferReceive/view?receivedId=' + receivedId).success(function(data) {
                $scope.edit = true;
                $scope.stockReceive = data;

                var obj = $filter('filter')($scope.transferList, {
                    id : data.transferId
                });

                $http.post("hospital/inventory/transferReceive/receiveItem", transferId).success(function(response) {

                    if (response.success == true) {
                        $scope.stockReceive.transferDtls = response.transferDetailBeanList;
                    }

                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });

                $scope.stockReceive.transferDtls = data.transferDtls;
                rowCount = $scope.stockReceive.transferDtls.length;

            }).error(function(data) {
            });

        }

        $scope.backToList = function() {
            $state.go('app.hospital.inventory.stockTransferReceive.list');
        };

        var rowCount = 0;
        var receivedId = $location.search().receivedId;

        if (receivedId == undefined || receivedId == null || receivedId == "") {
            $scope.edit = false;
            $scope.dropdownvalue();
        } else {
            $scope.edit = true;
            $scope.viewReceiveData();
        }

    })

    app.controller('stockTransferPopupCtrl', function($scope, $state, itemCode, transferId, rowId, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller) {

        $scope.rowCollectionBatch = [];
        $scope.displayedCollectionBatch = [];

        var resultbean = {
            stockTransferId : transferId,
            itemId : itemCode
        }

        if ($scope.stockReceive.transferDtls[rowId].attributeBeans != undefined && $scope.stockReceive.transferDtls[rowId].attributeBeans != null && $scope.stockReceive.transferDtls[rowId].attributeBeans != '') {
            if ($scope.stockReceive.transferDtls[rowId].attributeBeans.length == 0) {
                $http.post("hospital/inventory/transferReceive/getBatchDetail", resultbean).success(function(response) {
                    if (response.success == true) {
                        $scope.rowCollectionBatch = response.batchAttributeBeans;
                        angular.forEach($scope.rowCollectionBatch, function(value, key) {
                            value.receiveQty = 0;
                        });
                    } else {
                        logger.logError("This Item doesn't have any Batch No Details!");
                    }

                });
            } else {
               // $scope.rowCollectionBatch = $scope.stockReceive.transferDtls[rowId].attributeBeans;
            }

        } else {
            $http.post("hospital/inventory/transferReceive/getBatchDetail", resultbean).success(function(response) {
                if (response.success == true) {
                    $scope.rowCollectionBatch = response.batchAttributeBeans;
                    angular.forEach($scope.rowCollectionBatch, function(value, key) {
                        value.receiveQty = 0;
                    });
                } else {
                    logger.logError("This Item doesn't have any Batch No Details!");
                }

            });
        }

        $scope.checkQty = function(row) {
            if (row.receiveQty > row.batchQty) {
                row.receiveQty = row.batchQty
                logger.logError("Receive Quantity cannot be increased!");
            }
        }

        $scope.chkAll = false;
        /*$scope.checkBatchAll = function(checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollectionBatch, function(value, key) {
                value.select = $scope.chkAll;
            });
        };*/

        /*$scope.cancelBatch = function() {
            ngDialog.close();
        }*/

        $scope.fetchDetail = function(rowCollectionBatch) {

            //var batchList = [];
            var flag = false;

            var transferQty = 0;
            var totalQty = 0;
            angular.forEach($scope.stockReceive.transferDtls, function(value, key) {
                if (value.itemId == itemCode) {
                    transferQty = value.pendingQty;
                }
            });

            angular.forEach($scope.rowCollectionBatch, function(value, key) {
                if (value.select == true) {
                    flag = true;
                    totalQty = Number(totalQty) + Number(value.receiveQty);
                }
               // batchList.push(value);
            });

            if (flag == false) {
                logger.logError("Please Select Atleast One Batch Details!");
            } else {
                if (flag) {
                    if (totalQty <= transferQty) {
                        angular.forEach($scope.stockReceive.transferDtls, function(value, key) {
                            if (value.itemId == itemCode) {
                                value.receivedQty = totalQty;
                            }
                        });

                        //$scope.stockReceive.transferDtls[rowId].attributeBeans = batchList;
                        ngDialog.close();
                    } else {
                        logger.logError("Receive Quantity Should be less than or equval to Pending Quantity");
                    }
                }

            }

        }

    });

    app.controller('stockMovementPopupViewCtrl', function($scope, $state, itemCode, rowId, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller) {

        $scope.cancelBatch = function() {
            ngDialog.close();
        }

        angular.forEach($scope.stockReceive.transferDtls, function(itemCodeChange, index) {
            if (itemCodeChange.itemId == itemCode) {
                $scope.rowCollectionBatch = $scope.stockReceive.transferDtls[index].attributeBeans;
            }
      

    });

});