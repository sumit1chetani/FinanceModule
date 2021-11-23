//define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';
    app.controller('stockMovementEditCtrl', function($scope, $state,$stateParams, $http, ngDialog, logger, $filter, $location, $controller, validationService, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.StockTransfor = {
            rowCollection : []
        };
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.tableSelection = [];
        $scope.edit = true;
        $scope.deletedIds = [];
        $rootScope.stockTransfer = 0;

        $scope.StockTransfor = {
            rowCollection : [],
            transportType : '',
            stockId : '',
            sourceLocName : '',
            destLocName : '',
            serviceName : '',
            personName : '',
            requisition : '',
            deliveryMet : '',
            companyId : '',
            companyName : '',
            status : '',
            issueType:''
        };

        $scope.rowCollectionBatch = [];
        $scope.displayedCollectionBatch = [];

        $scope.StockTransfer = {

            date : ''
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

        $scope.reset1 = function() {
            $http.get("hospital/inventory/stocktransfer/getDropdownData").success(function(response) {
                if (response.success == true) {
                    $http.get($stateParams.tenantid +'app/commonUtility/getCompanyList').success(function(datas) {
                        $scope.companyList = datas;
                    }).error(function(datas) {
                    });

                    $scope.LocationList = response.oStockTransferBean[0];
                    $scope.RequisitionList = response.oStockTransferBean[1];
                    $scope.Delivery = response.oStockTransferBean[2];
                    $scope.Transportation = response.oStockTransferBean[3];

                    $http.post("hospital/inventory/stocktransfer/editData", stockId).success(function(response) {
                        $scope.transfer = response.lStockTransferBean[0];

                        $scope.data = $scope.transfer;
                        $scope.StockTransfor.date = $scope.transfer.date
                        $scope.StockTransfor.requisition = $scope.transfer.requisition.toString();
                        $scope.StockTransfor.transportType = $scope.transfer.transportType.toString();
                        $scope.StockTransfor.deliveryMet = $scope.transfer.deliveryMet.toString();
                        $scope.StockTransfor.status = $scope.transfer.status;
                        $scope.status = $scope.transfer.status;
                        $scope.StockTransfor.serviceName = $scope.transfer.serviceName;
                        $scope.StockTransfor.personName = $scope.transfer.personName;
                        $scope.StockTransfor.issueSlip = $scope.transfer.issueSlip;
                        $scope.StockTransfor.issueTypeName = $scope.transfer.issueTypeName;
                        $scope.StockTransfor.issueType = $scope.transfer.issueType;                        
                        $scope.StockTransfor.stockId = $scope.transfer.stockId;
                        var obj = $filter('filter')($scope.RequisitionList, {
                            id : $scope.transfer.requisition
                        });
                        if( $scope.StockTransfor.issueType == 218 ){
//                            $scope.StockTransfor.requisitionDate = obj[0].reqDate;
//                            $scope.StockTransfor.requisitionBy = obj[0].reqBy;
//                            $scope.StockTransfor.sourceLoc = obj[0].sourceLoc;
//                            $scope.StockTransfor.destLoc = obj[0].destLoc;
                            $scope.StockTransfor.sourceLocName = $scope.transfer.sourceLocName;
                            $scope.StockTransfor.destLocName = $scope.transfer.destLocName;
                            $scope.StockTransfor.companyId = $scope.transfer.companyId;
                            $scope.StockTransfor.companyName = $scope.transfer.companyName;
                        }else{

                            $scope.StockTransfor.requisitionDate = obj[0].reqDate;
                            $scope.StockTransfor.requisitionBy = obj[0].reqBy;
                            $scope.StockTransfor.sourceLoc = obj[0].sourceLoc;
                            $scope.StockTransfor.destLoc = obj[0].destLoc;
                            $scope.StockTransfor.sourceLocName = obj[0].sourceLocName;
                            $scope.StockTransfor.destLocName = obj[0].destLocName;
                            $scope.StockTransfor.companyId = $scope.transfer.companyId;
                            $scope.StockTransfor.companyName = $scope.transfer.companyName;

                        }
                        $scope.ItemList = $scope.transfer.itemlist;
             //..................Kitchen Issue.............................//           
                        if( $scope.StockTransfor.issueType == 218 ){
                            $scope.ItemList = $scope.transfer.rowCollection;

                        }
                        $scope.transportationonchange($scope.transfer.transportType);
                        $scope.StockTransfor.rowCollection = [];
                        $rootScope.stockTransfer = 1;
                        $scope.deletedIds = [];

                        /*
                         * $http.post("hospital/inventory/stocktransfer/RequisitionItem",$scope.transfer.requisition).success(function(response) {
                         * if (response.success == true) {
                         * $scope.StockTransfor.rowCollection=$scope.transfer.rowCollection;
                         * angular.forEach($scope.transfer.rowCollection,
                         * function(itemCodeChange, index) {
                         * $scope.StockTransfor.rowCollection[index].quantity=$scope.transfer.rowCollection[index].quantity; }) }
                         * }).error(function(result) { logger.logError("Error
                         * Please Try Again"); });
                         */

                        $http.post("hospital/inventory/stocktransfer/RequisitionItem1", $scope.transfer.requisition).success(function(response) {
                            if (response.success == true) {
                                $scope.StockTransfor.rowCollection = $scope.transfer.rowCollection;
                                angular.forEach($scope.transfer.rowCollection, function(itemCodeChange, index) {
                                    $scope.StockTransfor.rowCollection[index].prquantity = $scope.transfer.rowCollection[index].prquantity;
                                    $scope.StockTransfor.rowCollection[index].quantity = $scope.transfer.rowCollection[index].quantity;
//                                    $scope.getRowBatchDeatils();

                                })
                            }
                        }).error(function(result) {
                            logger.logError("Error Please Try Again");
                        });

                        $scope.getRowBatchDeatils = function() {
                            angular.forEach($scope.StockTransfor.rowCollection, function(itemCodeChange1, index1) {
                                $http.post("hospital/inventory/stocktransfer/getBatchNoDetails?itemCode=" + itemCodeChange1.itemCode + "&sourceLoc=" + $scope.StockTransfor.sourceLoc).success(function(response) {
                                    if (response.success == true) {
                                        $scope.rowCollectionBatch = response.lStockTransferBatchBean;
                                        angular.forEach($scope.rowCollectionBatch, function(value, key) {
                                            var itemId = value.dtlItemId;
                                            var batchNo = value.lotNo
                                            var transferQty = 0;
                                            var batchList = [];
                                            batchList = itemCodeChange1.stockTransferBatchList;
                                            angular.forEach(batchList, function(value1, key1) {
                                                if (itemId == value1.dtlItemId && batchNo == value1.lotNo) {
                                                    transferQty = value1.transferQty;
                                                }
                                            });
                                            value.transferQty = transferQty

                                        });
                                        itemCodeChange1.batchDetails = $scope.rowCollectionBatch;
                                    } else {
                                        logger.logError("This Item doesn't have any Batch No Details!");
                                    }

                                });
                            });
                        }

                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }

        var stockId = $location.search().stockId;

        $http.get("hospital/inventory/stocktransfer/getDropdownData").success(function(response) {
            if (response.success == true) {
                $http.get($stateParams.tenantid +'app/commonUtility/getCompanyList').success(function(datas) {
                    $scope.companyList = datas;
                }).error(function(datas) {
                });

                $scope.LocationList = response.oStockTransferBean[0];
                $scope.RequisitionList = response.oStockTransferBean[1];
                $scope.Delivery = response.oStockTransferBean[2];
                $scope.Transportation = response.oStockTransferBean[3];

                $http.post("hospital/inventory/stocktransfer/editData", stockId).success(function(response) {
                    $scope.transfer = response.lStockTransferBean[0];

                    $scope.data = $scope.transfer;
                    $scope.StockTransfor.date = $scope.transfer.date
                    $scope.StockTransfor.requisition = $scope.transfer.requisition.toString();
                    $scope.StockTransfor.transportType = $scope.transfer.transportType.toString();
                    $scope.StockTransfor.deliveryMet = $scope.transfer.deliveryMet.toString();
                    $scope.StockTransfor.status = $scope.transfer.status;
                    $scope.status = $scope.transfer.status;
                    $scope.StockTransfor.serviceName = $scope.transfer.serviceName;
                    $scope.StockTransfor.personName = $scope.transfer.personName;
                    $scope.StockTransfor.issueSlip = $scope.transfer.issueSlip;            
                    $scope.StockTransfor.issueTypeName = $scope.transfer.issueTypeName;
                    $scope.StockTransfor.issueType = $scope.transfer.issueType; 
                    $scope.StockTransfor.stockId = $scope.transfer.stockId;
                    var obj = $filter('filter')($scope.RequisitionList, {
                        id : $scope.transfer.requisition
                    });
                    if( $scope.StockTransfor.issueType == 218 ){
//                      $scope.StockTransfor.requisitionDate = obj[0].reqDate;
//                      $scope.StockTransfor.requisitionBy = obj[0].reqBy;
//                      $scope.StockTransfor.sourceLoc = obj[0].sourceLoc;
//                      $scope.StockTransfor.destLoc = obj[0].destLoc;
                      $scope.StockTransfor.sourceLocName = $scope.transfer.sourceLocName;
                      $scope.StockTransfor.destLocName = $scope.transfer.destLocName;
                      $scope.StockTransfor.companyId = $scope.transfer.companyId;
                      $scope.StockTransfor.companyName = $scope.transfer.companyName;
                  }else{

                      $scope.StockTransfor.requisitionDate = obj[0].reqDate;
                      $scope.StockTransfor.requisitionBy = obj[0].reqBy;
                      $scope.StockTransfor.sourceLoc = obj[0].sourceLoc;
                      $scope.StockTransfor.destLoc = obj[0].destLoc;
                      $scope.StockTransfor.sourceLocName = obj[0].sourceLocName;
                      $scope.StockTransfor.destLocName = obj[0].destLocName;
                      $scope.StockTransfor.companyId = $scope.transfer.companyId;
                      $scope.StockTransfor.companyName = $scope.transfer.companyName;

                  }

                    $scope.ItemList = $scope.transfer.itemlist;
                    if( $scope.StockTransfor.issueType == 218 ){
                        $scope.ItemList = $scope.transfer.rowCollection;

                    }
                    $scope.transportationonchange($scope.transfer.transportType);
                    $scope.StockTransfor.rowCollection = [];

                    $rootScope.stockTransfer = 1;

                    /*
                     * $http.post("hospital/inventory/stocktransfer/RequisitionItem",$scope.transfer.requisition).success(function(response) {
                     * if (response.success == true) {
                     * $scope.StockTransfor.rowCollection=$scope.transfer.rowCollection;
                     * angular.forEach($scope.transfer.rowCollection,
                     * function(itemCodeChange, index) {
                     * $scope.StockTransfor.rowCollection[index].quantity=$scope.transfer.rowCollection[index].quantity; }) }
                     * }).error(function(result) { logger.logError("Error Please
                     * Try Again"); });
                     */

                    $http.post("hospital/inventory/stocktransfer/RequisitionItem1", $scope.transfer.requisition).success(function(response) {
                        if (response.success == true) {
                            $scope.StockTransfor.rowCollection = $scope.transfer.rowCollection;
                            angular.forEach($scope.transfer.rowCollection, function(itemCodeChange, index) {
                                $scope.StockTransfor.rowCollection[index].prquantity = $scope.transfer.rowCollection[index].prquantity;
                                $scope.StockTransfor.rowCollection[index].quantity = $scope.transfer.rowCollection[index].quantity;
//                                $scope.getRowBatchDeatils();

                            })
                        }
                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });

                    $scope.getRowBatchDeatils = function() {
                        angular.forEach($scope.StockTransfor.rowCollection, function(itemCodeChange1, index1) {
                            $http.post("hospital/inventory/stocktransfer/getBatchNoDetails?itemCode=" + itemCodeChange1.itemCode + "&sourceLoc=" + $scope.StockTransfor.sourceLoc).success(function(response) {
                                if (response.success == true) {
                                    $scope.rowCollectionBatch = response.lStockTransferBatchBean;
                                    angular.forEach($scope.rowCollectionBatch, function(value, key) {
                                        var itemId = value.dtlItemId;
                                        var batchNo = value.lotNo
                                        var transferQty = 0;
                                        var batchList = [];
                                        batchList = itemCodeChange1.stockTransferBatchList;
                                        angular.forEach(batchList, function(value1, key1) {
                                            if (itemId == value1.dtlItemId && batchNo == value1.lotNo) {
                                                transferQty = value1.transferQty;
                                            }
                                        });
                                        value.transferQty = transferQty

                                    });
                                    itemCodeChange1.batchDetails = $scope.rowCollectionBatch;
                                } else {
                                    logger.logError("This Item doesn't have any Batch No Details!");
                                }

                            });
                        });
                    }

                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            }
        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });

        $scope.requistiononchange = function(requisition) {
            var obj = $filter('filter')($scope.RequisitionList, {
                id : requisition
            });

            $scope.StockTransfor.requisitionDate = obj[0].reqDate;
            $scope.StockTransfor.requisitionBy = obj[0].reqBy;
            $scope.StockTransfor.sourceLoc = obj[0].sourceLoc;
            $scope.StockTransfor.destLoc = obj[0].destLoc;
            $scope.StockTransfor.sourceLocName = obj[0].sourceLocName;
            $scope.StockTransfor.destLocName = obj[0].destLocName;
            $scope.StockTransfor.sourceLoc = obj[0].sourceLoc;

            $http.post("hospital/inventory/stocktransfer/RequisitionItem1", requisition).success(function(response) {
                if (response.success == true) {

                    $scope.ItemList = response.lStockTransferBean;

                    // $scope.add();
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }
        
        $http.get('hospital/inventory/stocktransfer/IssueTypeList').success(function(datas) {
            $scope.issueList = datas;
            }).error(function(datas) {
        });
        $scope.itemCodeChange = function(itemCode, row) {

            var obj = $filter('filter')($scope.ItemList, {
                id : itemCode
            });

            row.itemName = obj[0].itemName;
            row.uom = obj[0].uom;
            row.prquantity = obj[0].prquantity;
            row.quantity = obj[0].quantity;
            row.itemCode = itemCode;
            row.reqDetailId = obj[0].reqDetailId;
        }
/*        $scope.itemCodeChangeKitchenEdit = function(itemCode, row) {

            var obj = $filter('filter')($scope.ItemList, {
                id : itemCode
            });
            

            row.itemName = obj[0].itemName;
            row.uom = obj[0].uom;
            row.prquantity = obj[0].prquantity;
            row.quantity = obj[0].quantity;
            row.itemCode = itemCode;
            row.reqDetailId = obj[0].reqDetailId;
        }*/
        $scope.itemEditCodeChange = function(itemCode, row) {

            var obj = $filter('filter')($scope.ItemList, {
                id : itemCode
            });

            row.itemName = obj[0].itemName;
            row.uom = obj[0].uom;
            row.itemCode = itemCode;
            row.reqDetailId = obj[0].reqDetailId;
        }

        $scope.add = function() {
            var len = $scope.StockTransfor.rowCollection.length;
            var table = {
                stockDtlId : 0,
                itemCode : '',
                itemName : '',
                uom : '',
                prquantity : '',
                quantity : '',
                reqDetailId : '',
                disable : false,
                stockTransferBatchList : []

            };
            $scope.StockTransfor.rowCollection.push(table);

        }

        $scope.getBatchDetails = function(rowId, itemCode) {
            $scope.callDialogBatchNo($scope, $http, itemCode, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId);
        };

        $scope.callDialogBatchNo = function($scope, $http, itemCode, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId) {
            ngDialog.open({
                scope : $scope,
                template : 'views/inventory/stockMovement/stockMovementPopupBatch',
                controller : $controller('stockMovementPopupCtrl', {
                    $scope : $scope,
                    $http : $http,
                    itemCode : itemCode,
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
        }

        $scope.getBatchDetailsView = function(rowId, itemCode) {
            $scope.callDialogBatchView($scope, $http, itemCode, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId);
        };

        $scope.callDialogBatchView = function($scope, $http, itemCode, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, rowId) {
            ngDialog.open({
                scope : $scope,
                template : 'views/inventory/stockMovement/stockMovementPopupBatchView',
                controller : $controller('stockMovementPopupViewCtrl', {
                    $scope : $scope,
                    $http : $http,
                    itemCode : itemCode,
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
        }

        $scope.transportationonchange = function(transportType) {

            var obj = $filter('filter')($scope.Transportation, {
                id : transportType
            });
            // alert($('#type').val());
            if (obj.length != 0) {

                if (obj[0].text == "By Person") {
                    $('#personname').show();
                    $('#servicename').hide();
                }
                if (obj[0].text == "Courier") {
                    $('#servicename').show();
                    $('#personname').hide();
                }

            }
        }

        $scope.deleteRow = function() {
            for (var i = $scope.StockTransfor.rowCollection.length - 1; i >= 0; i--) {
                if ($scope.tableSelection[i]) {
                    $scope.deletedIds.push($scope.StockTransfor.rowCollection[i]);
                    $scope.StockTransfor.rowCollection.splice(i, 1);
                    delete $scope.tableSelection[i];

                }
            }
        };

        $scope.cancel1 = function() {
            $scope.StockTransfer.issueType = "";
           
            $state.go('app.inventory.stockmovement.list');
    
        };

        $scope.itemchange = function() {
            // alert($('#itemcode').val());
            if ($('#itemcode').val() == "i001") {
                $('#itemname').val('Stethoscopes');
                $('#desc').val('used to hear sounds from movements within the body');
                $('#category').val('Instrument');
                $('#itemtype').val('Type1');
                $('#unit').val('mmHg');
            }
            if ($('#itemcode').val() == "i002") {
                $('#itemname').val(null);
                $('#desc').val(null);
                $('#category').val(null);
                $('#itemtype').val(null);
                $('#itemname').val('Thermometer');
                $('#desc').val('to record the body temperature');
                $('#category').val('Instrument');
                $('#itemtype').val('Type2');
            }
        }

        $scope.back = function() {
            $state.go('app.hospital.inventory.stockverification.add');
        }

        $scope.cancel = function() {
            ngDialog.close();
            $state.go('app.hospital.inventory.stockmovement.add');

        }

        $scope.validateQty = function() {
            var msg = "", flag = true;
            angular.forEach($scope.StockTransfor.rowCollection, function(value, index) {
                var itemId = value.itemCode, locnId = $scope.StockTransfor.sourceLoc, availQty = 0;
                $.ajax({
                    type : "POST",
                    url : "app/commonUtility/getStockAvailablity?itemId=" + itemId + "&locnId=" + locnId,
                    data : '',
                    async : false,
                    success : function(response) {
                        availQty = response.commonUtilityBean[0].stockQty;

                        if (parseInt(value.quantity) > parseInt(availQty)) {
                            msg = "Transfer Qty should not exceed " + availQty + " for Item : " + value.itemName;
                            flag = false;
                        }
                    }
                });

            });
            if (!flag) {
                logger.logError(msg);
            }
            return flag;
        }

        $scope.update = function(ondutyrequestForm, StockTransfor) {
            var isQuantity = true;
            var batchValid = true;
            if (new validationService().checkFormValidity($scope.ondutyrequestForm)) {
                // if($scope.validateQty()){
                if ($scope.StockTransfor.rowCollection.length >= 1) {
                    angular.forEach($scope.StockTransfor.rowCollection, function(value, key) {
                        if (value.quantity > 0) {
                        } else {
                            isQuantity = false;
                        }
                        if (value.batchDetails != undefined && value.batchDetails != null && value.batchDetails != '') {
                            if (value.batchDetails.length == 0) {
                                batchValid = false;
                            }
                        } else {
                            batchValid = false;
                        }
                        var batAttrbutList = [];
                        angular.forEach(value.batchDetails, function(batchValue, batchKey) {
                            var obj = {
                                itemId : '',
                                batchNo : '',
                                batchQty : '',
                                manufacturer : '',
                                mrpPrice : '',
                                expiryDate : ''
                            }
                            obj.batchNo = batchValue.lotNo;
                            obj.batchQty = batchValue.transferQty;
                            obj.manufacturer = batchValue.manufactureDef;
                            obj.mrpPrice = batchValue.mrp;
                            obj.itemId = batchValue.dtlItemId
                            if ($scope.itemExpDate == true) {
                                obj.expiryDate = batchValue.expiryDate;
                            } else {
                                if ($scope.itemExpDate == false) {
                                    obj.expiryDate = "";
                                }

                            }
                            obj.originalConvertedQty = batchValue.transferQty;
                            if (batchValue.transferQty > 0) {
                                batAttrbutList.push(obj);
                            }
                        });

                        value.attributeBeans = batAttrbutList;
                    });
                    if (isQuantity == true) {
//                        if (batchValid == true) {
                            StockTransfor.id = stockId;
                            StockTransfor.ldeltedIds = $scope.deletedIds;
                            $http.post("hospital/inventory/stocktransfer/update", StockTransfor).success(function(response) {
                                if (response.success == true) {
                                    logger.logSuccess("Data Saved Successfully");
                                    $state.go('app.hospital.inventory.stockmovement.list');
                                }
                            }).error(function(result) {
                                logger.logError("Error Please Try Again");
                            });
//                        } else {
//                            logger.logError("Please Add Atleast One Batch Details!");
//                        }
                    } else {
                        logger.logError("Quantity cannot be zero");
                    }
                } else {
                    logger.logError("Atleast one item should be present");
                }

                // }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.ondutyrequestForm.$validationSummary), 555000, 'trustedHtml');
            }

        }

        $scope.$watch('StockTransfor.requisition', function(newValue, oldValue) {
            $scope.StockTransfor.rowCollection = []
            if (newValue != undefined && newValue != '') {
                $scope.requistiononchange(newValue);
            } else {

                $scope.StockTransfor.requisitionDate = '';
                $scope.StockTransfor.requisitionBy = '';
                $scope.StockTransfor.sourceLoc = '';
                $scope.StockTransfor.destLoc = '';
                $scope.StockTransfor.sourceLocName = '';
                $scope.StockTransfor.destLocName = '';
                $scope.ItemList = [];
                $scope.StockTransfor.rowCollection = [];
            }

        });
        $scope.$watch('StockTransfor.transportType', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.transportationonchange(newValue);
            }
        });
        $scope.materialIssueflag = true;
        //..................Kitchen Issue.............................//
        $scope.$watch('StockTransfor.issueType', function(newValue, oldValue) {
            // alert(newValue);
            if (newValue == '219' || newValue == "Material Issue") {
                $scope.materialIssueflag = true;
            } else if (newValue == '218' ||  newValue == "Kitchen Issue") {
                $scope.StockTransfor.issueType = '218';
                $scope.materialIssueflag = false;
//                $scope.getItemList($scope.StockTransfor.destLocName);
            }

        });
    });

    app.controller('stockTransferItemCtrl', function($scope, $filter, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.itemCodeChange = function(itemCode, row) {
            var obj = $filter('filter')($scope.ItemList, {
                id : itemCode
            });

            $scope.StockTransfor.rowCollection[row].itemName = obj[0].itemName;
            $scope.StockTransfor.rowCollection[row].itemDesc = obj[0].itemDesc;
            $scope.StockTransfor.rowCollection[row].uom = obj[0].uom;

            if ($scope.StockTransfor.rowCollection[row].disable == false) {
                $scope.StockTransfor.rowCollection[row].quantity = obj[0].quantity;
                $scope.StockTransfor.rowCollection[row].prquantity = obj[0].prquantity;
                $scope.StockTransfor.rowCollection[row].originalQty = obj[0].originalQty;
            }

            $scope.StockTransfor.rowCollection[row].reqDetailId = obj[0].reqDetailId;
            $scope.StockTransfor.rowCollection[row].batchNoExist = obj[0].batchNoExist;
        }
        $scope.itemCodeChangeKitchenEdit = function(itemCode, row) {

            var obj = $filter('filter')($scope.ItemList, {
                id : itemCode
            });
           
                $scope.StockTransfor.rowCollection[row].itemName = obj[row].itemName;
                $scope.StockTransfor.rowCollection[row].itemDesc = obj[row].itemDesc;
                $scope.StockTransfor.rowCollection[row].uom = obj[0].uom;
                $scope.StockTransfor.rowCollection[row].requestNumber = obj[row].requestNumber;
//                alert(obj[row].requestNumber);
                if ($scope.StockTransfor.rowCollection[row].disable == false) {
                    $scope.StockTransfor.rowCollection[row].quantity = obj[row].quantity;
                    $scope.StockTransfor.rowCollection[row].prquantity = obj[row].prquantity;
                    $scope.StockTransfor.rowCollection[row].originalQty = obj[row].originalQty;
                }

                $scope.StockTransfor.rowCollection[row].reqDetailId = obj[row].reqDetailId;
                $scope.StockTransfor.rowCollection[row].batchNoExist = obj[row].batchNoExist;
            }
        $scope.validateQuantity = function(quantity, originalQty, index) {
            if (quantity > originalQty) {
                logger.logError("Quantity Cannot be Increased!");
                $scope.StockTransfor.rowCollection[index].quantity = originalQty;
            }
        }

        $scope.$watch('StockTransfor.rowCollection[trIndex].itemCode', function(newValue, oldValue) {
           if($scope.edit){
            if ($scope.StockTransfor.issueType == '218') {

                var length = $scope.StockTransfor.rowCollection.length;
           /*     for (var i = 0; i < length; i++) {
                    for (var j = 0; j < length; j++) {
                        if (i != j) {
                            if ($scope.StockTransfor.rowCollection[i].itemCode == $scope.StockTransfor.rowCollection[j].itemCode
                                    &&  $scope.StockTransfor.rowCollection[i].itemDesc == $scope.StockTransfor.rowCollection[j].itemDesc) {
                                logger.logError("Item already added");
                                $scope.StockTransfor.rowCollection[$scope.$index].itemCode = '';
                                return false;
                            }
                        }
                    }
                }*/
                
                $scope.itemCodeChangeKitchenEdit(newValue, $scope.$index);

            
            }else  if (newValue != undefined && newValue != '') {
                var length = $scope.StockTransfor.rowCollection.length;
                for (var i = 0; i < length; i++) {
                    for (var j = 0; j < length; j++) {
                        if (i != j) {
                            if ($scope.StockTransfor.rowCollection[i].itemCode == $scope.StockTransfor.rowCollection[j].itemCode
                                    &&  $scope.StockTransfor.rowCollection[i].itemDesc == $scope.StockTransfor.rowCollection[j].itemDesc) {
                                logger.logError("Item already added");
                                $scope.StockTransfor.rowCollection[$scope.$index].itemCode = '';
                                return false;
                            }
                        }
                    }
                }
                
                $scope.itemCodeChange(newValue, $scope.$index);

            } else {

                $scope.StockTransfor.rowCollection[$scope.$index].itemName = ''
                $scope.StockTransfor.rowCollection[$scope.$index].uom = '';
                $scope.StockTransfor.rowCollection[$scope.$index].prquantity = '';
                $scope.StockTransfor.rowCollection[$scope.$index].quantity = '';
                $scope.StockTransfor.rowCollection[$scope.$index].originalQty = '';
                $scope.StockTransfor.rowCollection[$scope.$index].reqDetailId = '';
                $scope.StockTransfor.rowCollection[$scope.$index].batchNoExist = false;
                $scope.StockTransfor.rowCollection[$scope.$index].disable = false;
            }
        }
        });

    });

    app.controller('stockMovementPopupCtrl', function($scope, $state, itemCode, rowId, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller) {

        $scope.checkQty = function(row) {
            if (row.transferQty > row.batchQty) {
                row.transferQty = row.batchQty
                logger.logError("Transfer Quantity should not be greater than the available Qty!");
            }
        }

        $scope.chkAll = false;
        $scope.checkBatchAll = function(checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollectionBatch, function(value, key) {
                value.select = $scope.chkAll;
            });
        };

        $scope.fetchDetail = function(rowCollectionBatch) {

            var batchList = [];
            var flag = false;

            var transferQty = 0;
            var totalQty = 0;
            angular.forEach($scope.StockTransfor.rowCollection, function(value, key) {
                if (value.itemCode == itemCode) {
                    transferQty = value.quantity;
                }
            });

            angular.forEach($scope.rowCollectionBatch, function(value, key) {
                if (value.select == true) {
                    flag = true;
                    totalQty = Number(totalQty) + Number(value.transferQty);
                }
                batchList.push(value);
            });

            if (flag == false) {
                logger.logError("Please Select Atleast One Batch Details!");
            } else {
                if (flag) {
                    if (totalQty == transferQty) {
                        $scope.StockTransfor.rowCollection[rowId].batchDetails = batchList;
                        ngDialog.close();
                    } else {
                        logger.logError("Quantity Should be Same");
                    }
                }

            }

        }

        $scope.stockMovementBatchdetail = [];
        $scope.cancelBatch = function() {
            ngDialog.close();
        }

        angular.forEach($scope.StockTransfor.rowCollection, function(itemCodeChange, index) {

            if ($scope.StockTransfor.rowCollection[rowId].batchDetails != undefined && $scope.StockTransfor.rowCollection[rowId].batchDetails != null && $scope.StockTransfor.rowCollection[rowId].batchDetails != '') {
                if ($scope.StockTransfor.rowCollection[rowId].batchDetails.length == 0) {
                    if (itemCodeChange.itemCode == itemCode) {
                        $scope.stockMovementBatchdetail = $scope.StockTransfor.rowCollection[index].stockTransferBatchList;
                    }

                    $http.post("hospital/inventory/stocktransfer/getBatchNoDetails?itemCode=" + itemCode + "&sourceLoc=" + $scope.StockTransfor.sourceLoc).success(function(response) {
                        if (response.success == true) {
                            $scope.rowCollectionBatch = response.lStockTransferBatchBean;
                            $scope.getTransferDetails();
                        } else {
                            logger.logError("This Item doesn't have any Batch No Details!");
                        }

                    });
                } else {
                    $scope.rowCollectionBatch = $scope.StockTransfor.rowCollection[rowId].batchDetails;
                }
            } else {
                if (itemCodeChange.itemCode == itemCode) {
                    $scope.stockMovementBatchdetail = $scope.StockTransfor.rowCollection[index].stockTransferBatchList;
                }

                $http.post("hospital/inventory/stocktransfer/getBatchNoDetails?itemCode=" + itemCode + "&sourceLoc=" + $scope.StockTransfor.sourceLoc).success(function(response) {
                    if (response.success == true) {
                        $scope.rowCollectionBatch = response.lStockTransferBatchBean;
                        $scope.getTransferDetails();
                    } else {
                        logger.logError("This Item doesn't have any Batch No Details!");
                    }

                });
            }

        })

        $scope.getTransferDetails = function() {

            angular.forEach($scope.rowCollectionBatch, function(value, key) {
                var itemId = value.dtlItemId;
                var batchNo = value.lotNo
                var transferQty = 0;

                angular.forEach($scope.stockMovementBatchdetail, function(value1, key1) {
                    if (itemId == value1.dtlItemId && batchNo == value1.lotNo) {
                        transferQty = value1.transferQty;
                    }
                });

                value.transferQty = transferQty
            });

        }

    });

    app.controller('stockMovementPopupViewCtrl', function($scope, $state, itemCode, rowId, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller) {

        $scope.cancelBatch = function() {
            ngDialog.close();
        }

        angular.forEach($scope.StockTransfor.rowCollection, function(itemCodeChange, index) {
            if (itemCodeChange.itemCode == itemCode) {
                $scope.rowCollectionBatch = $scope.StockTransfor.rowCollection[index].stockTransferBatchList;

            }

        });

    });

//});