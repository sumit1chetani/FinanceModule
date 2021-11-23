//define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';
    app.controller('stockMovementAddCtrl', function($scope, $state, $stateParams,$http, ngDialog, $filter, logger, $location, $controller, validationService, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.companyList = [];
        $scope.destLocationList = [];
        $scope.StockTransfor = {
            rowCollection : [],
            // DtlList: [],
            transportType : '',
            stockId : '',
            availableQTY : '',
            requisition : '',
            sourceLocName : '',
            destLocName : '',
            serviceName : '',
            personName : '',

            companyId : '',
            deliveryMet : '66',
            issueSlip : '',
            issueType : '219',

        };
        $scope.displayedCollection = [];
        $scope.deletedIds = [];
        $scope.itemsByPage = 10;
        $scope.tableSelection = [];
        $scope.edit = false;

        $scope.rowCollectionBatch = [];
        $scope.displayedCollectionBatch = [];

        $scope.StockTransfer = {

            date : ''
        };

        $scope.date = '';

        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; // January is 0!
        var yyyy = today.getFullYear();
        $scope.resetValue = false;
        $scope.resetValueNew = false;
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        var today = dd + '/' + mm + '/' + yyyy;
        $scope.date = today;

        $scope.StockTransfor.date = $scope.date;
        $scope.StockTransfor.status = "Approved";
        // $scope.StockTransfor.requisition = $rootScope.purchaseRequisitionId;

        $scope.dropdownvalue = function() {

            $http.get("hospital/inventory/stocktransfer/getDropdownData").success(function(response) {
                if (response.success == true) {

                    $scope.LocationList = response.oStockTransferBean[0];
                    $scope.RequisitionList = response.oStockTransferBean[1];
                    $scope.Delivery = response.oStockTransferBean[2];
                    $scope.Transportation = response.oStockTransferBean[3];
                    $scope.StockTransfor.stockId = response.oStockTransferBean[4];

                    var prnumber = $rootScope.purchaseRequisitionId;
                    if (prnumber != "") {
                        $scope.StockTransfor.requisition = prnumber.toString();
                    }
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

            // $scope.PRnumber= function()
            // {

            // }
            // $scope.PRnumber();
            /*
             * $http.get('app/commonUtility/getCompanyList').success(function(datas) {
             * $scope.companyList = datas; }).error(function(datas) { });
             */

            $http.get( $stateParams.tenantid +'/app/commonUtility/getCompanyListPurchase').success(function(datas) {
                $scope.companyList = datas;
            }).error(function(datas) {
            });

            $http.get("app/inventory/consignmentIn/parentlocationlist").success(function(datas) {
                $scope.destinationList = datas;
            }).error(function(datas) {
            });

            $http.get('hospital/inventory/stocktransfer/IssueTypeList').success(function(datas) {
                $scope.issueList = datas;
            }).error(function(datas) {
            });

            $http.get('app/hospital/purchase/consignmentRequest/employeeList').success(function(datas) {

                $scope.employeeList = datas.employeeList;
            });
        }

        // new item List

        /*
         * $scope.getItemList123 = function(){
         * $http.get('app/hospital/purchase/consignmentRequest/employeeList').success(function(datas) {
         * $scope.ItemList = datas.itemList; }).error(function(datas) { }); }
         * $scope.getItemList123();
         */
        // ................
        $scope.reset = function() {
            $rootScope.purchaseRequisitionId = '';
            $scope.StockTransfor = {
                rowCollection : [],
                transportType : '',
                stockId : '',
                availableQTY : '',

                sourceLocName : '',
                destLocName : '',
                serviceName : '',
                personName : '',
                companyId : '',
                deliveryMet : '66',
                status : 'Approved',
                issueSlip : '',
                issueType : '219',

            };

            $scope.StockTransfor.date = $scope.date;
            $scope.dropdownvalue();
        }
        $scope.dropdownvalue();

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
            $scope.StockTransfor.companyId = obj[0].companyId;
            $http.post("hospital/inventory/stocktransfer/RequisitionItem", requisition).success(function(response) {
                if (response.success == true) {

                    angular.forEach(response.lStockTransferBean, function(value, index) {
                        if (value.pendingQuantity > 0) {
                            response.lStockTransferBean[index].quantity = 0;
                            response.lStockTransferBean[index].prquantity = value.pendingQuantity;
                            response.lStockTransferBean[index].availableQTY = value.availableQTY;

                        } else {
                            response.lStockTransferBean[index].quantity = 0;

                        }
                    });

                    $scope.ItemList = response.lStockTransferBean;
                    $scope.StockTransfor.rowCollection = [];
                    $scope.add();
                    $scope.assignValues($scope.ItemList);
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }

        $scope.$watch('StockTransfor.requisition', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.requistiononchange(newValue);
            } else {

                $scope.StockTransfor.requisitionDate = '';
                $scope.StockTransfor.requisitionBy = '';
                $scope.StockTransfor.sourceLoc = '';
                $scope.StockTransfor.destLoc = '';
                $scope.StockTransfor.sourceLocName = '';
                $scope.StockTransfor.destLocName = '';
                // $scope.add();
                $scope.ItemList = [];
                $scope.StockTransfor.rowCollection = [];

            }

        });

        $scope.assignValues = function(obj) {
            /*
             * var obj = $filter('filter')($scope.ItemList, { id : itemCode });
             */
            var i = 0;
            for (var i; i < obj.length; i++) {
                if (i >= 1) {
                    $scope.add();
                }
                $scope.StockTransfor.rowCollection[i].itemCode = obj[i].id;
                $scope.StockTransfor.rowCollection[i].requisitionNo = obj[i].requisitionNo;
                $scope.StockTransfor.rowCollection[i].itemDesc = obj[i].itemDesc;
                $scope.StockTransfor.rowCollection[i].uom = obj[i].uom;
                $scope.StockTransfor.rowCollection[i].prquantity = obj[i].prquantity;
                $scope.StockTransfor.rowCollection[i].availableQTY = obj[i].availableQTY;
                $scope.StockTransfor.rowCollection[i].quantity = 0;
                $scope.StockTransfor.rowCollection[i].originalQty = obj[i].originalQty;
                $scope.StockTransfor.rowCollection[i].reqDetailId = obj[i].reqDetailId;
                $scope.StockTransfor.rowCollection[i].batchNoExist = obj[i].batchNoExist;
            }
        }
        $scope.$watch('StockTransfor.transportType', function(newValue, oldValue) {
            if (newValue != undefined && newValue != '') {
                $scope.transportationonchange(newValue);
            }
        });
        $scope.materialIssueflag = true;
        $scope.$watch('StockTransfor.issueType', function(newValue, oldValue) {
            // alert(newValue);
            if (newValue == '219') {
                $scope.materialIssueflag = true;
                
                         } else if (newValue == '218') {
//                $scope.reset();
//                $scope.StockTransfor.issueType = '218';
                $scope.materialIssueflag = false;
                $scope.StockTransfor = {
                        rowCollection : [],
                        // DtlList: [],
                        transportType : '',
                        stockId : '',
                        availableQTY : '',
                        requisition : '',
                        sourceLocName : 5674,
                        destLocName : 5620,
                        serviceName : '',
                        personName : '',

                        companyId : '',
                        deliveryMet : '66',
                        issueSlip : '',
                        issueType : '218',
                        

                    };
                $scope.StockTransfor.date = $scope.date;
                $scope.StockTransfor.status = 'Approved';

                //                $scope.getItemList($scope.StockTransfor.destLocName);
            }

        });

        $scope.$watch('StockTransfor.companyId', function(newValue, oldValue) {

            $http.get('hospital/inventory/stocktransfer/getRequisitionListCompanyBased?companyId=' + newValue).success(function(datas) {
                $scope.RequisitionList = datas;
                
            });
        });
        
        $scope.$watchCollection('[StockTransfor.destLocName,StockTransfor.companyId]', function(newValue, oldValue) {
            // alert(newValue);
            //            if (newValue == '219') {
            //                $scope.materialIssueflag = true;
            //            } else 
            if ($scope.StockTransfor.issueType == '218') {
                //                $scope.reset();
                //                $scope.StockTransfor.issueType = '218';
                //                $scope.materialIssueflag = false;
                $scope.getItemList($scope.StockTransfor.destLocName,$scope.StockTransfor.companyId);
            }

        });
        $scope.add = function() {
            if ($scope.StockTransfor.issueType == '218') {
                if ($scope.StockTransfor.companyId != undefined && $scope.StockTransfor.companyId != null && $scope.StockTransfor.companyId != '') {

                if ($scope.StockTransfor.destLocName != undefined && $scope.StockTransfor.destLocName != null && $scope.StockTransfor.destLocName != '') {
                   
                        var len = $scope.StockTransfor.rowCollection.length;
                        var table = {
                            itemCode : '',
                            requisitionNo : '',
                            itemName : '',
                            uom : '',
                            prquantity : '',
                            availableQTY : '',
                            quantity : '',
                            reqDetailId : '',
                            disable : false,
                            batchDetails : [],
                            attributeBeans : []
                        }
                        $scope.StockTransfor.rowCollection.push(table);
                    } else {
                        logger.logError("Please Select Destination Location !! ");

                    }
                } else {
                    logger.logError("Please Select Organization Name!! ");

                }

            } else {
                var len = $scope.StockTransfor.rowCollection.length;
                var table = {
                    itemCode : '',
                    requisitionNo : '',
                    itemName : '',
                    uom : '',
                    prquantity : '',
                    availableQTY : '',
                    quantity : '',
                    reqDetailId : '',
                    disable : false,
                    batchDetails : [],
                    attributeBeans : []

                };
                $scope.StockTransfor.rowCollection.push(table);

            }
        }

        // $scope.getItemList123 = function(){
        // $http.get('app/hospital/purchase/consignmentRequest/employeeList').success(function(datas)
        // {
        // $scope.itemList = datas.itemList;
        // }).error(function(datas) {
        // });
        // }

        $scope.transportationonchange = function(transportType) {

            var obj = $filter('filter')($scope.Transportation, {
                id : transportType
            });
            // alert($('#type').val());
            if (obj[0].text == "By Person") {
                $('#personname').show();
                $('#servicename').hide();
            }
            if (obj[0].text == "Courier") {
                $('#servicename').show();
                $('#personname').hide();
            }
        }

        $scope.deleteRow = function() {
            for (var i = $scope.StockTransfor.rowCollection.length - 1; i >= 0; i--) {
                if ($scope.tableSelection[i]) {
                    $scope.StockTransfor.rowCollection.splice(i, 1);
                    delete $scope.tableSelection[i];
                    $scope.deletedIds.push($scope.StockTransfor.rowCollection[i]);
                }
            }
        };

        $scope.del = function() {
            for (var i = $scope.StockTransfor.rowCollection.length - 1; i >= 0; i--) {
                if ($scope.tableSelection[i]) {
                    $scope.StockTransfor.rowCollection.splice(i, 1);
                    delete $scope.tableSelection[i];
                }
            }
        };

        $scope.cancel1 = function() {
            $rootScope.purchaseRequisitionId = '';
            $state.go('app.inventory.stockmovement.list');
        };

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

        $scope.editRow = function() {
            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);

        }

        $scope.back = function() {
            $state.go('app.inventory.stockverification.add');
        }

        $scope.callDialog = function($scope, permissionrequestid, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/inventory/stockMovement/stockMovementPopUpAdd',
                controller : $controller('stockMovementAddCtrl', {
                    $scope : $scope,
                    permissionrequestid : permissionrequestid,
                    $http : $http,
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
        }

        $scope.cancel = function() {
            ngDialog.close();
            $state.go('app.inventory.stockmovement.add');

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
        var issueStatus = "";
        var requisitionId = "";
        $scope.save = function(ondutyrequestForm, StockTransfor) {
            var isQuantity = true;
            var batchValid = true;
            var flag = false;
            if (new validationService().checkFormValidity($scope.ondutyrequestForm)) {
                // if($scope.validateQty()){
                if ($scope.StockTransfor.rowCollection.length >= 1) {
                    angular.forEach($scope.StockTransfor.rowCollection, function(value, key) {
                        if ($scope.StockTransfor.rowCollection[key].quantity != 0 && $scope.StockTransfor.rowCollection[key].quantity > 0) {

                            var originalqty = value.originalQty;
                            var enteredqty = value.quantity;
                            if (enteredqty < originalqty) {
                                requisitionId = parseInt($scope.StockTransfor.requisition);
                                issueStatus = 213;
                            }
                            if (enteredqty == originalqty) {
                                requisitionId = parseInt($scope.StockTransfor.requisition);
                                issueStatus = 214;
                            }

                            if (value.quantity > 0) {
                            } else {
                                isQuantity = false;
                            }
                            /*
                             * if (value.batchNoExist == true) { if
                             * (value.batchDetails.length == 0) { batchValid =
                             * false } }
                             */
                            var batAttrbutList = [];
                            var BatchDetails = [];
                            var batchDetails = {
                                dtlItemId : value.itemCode,
                                batchItemName : value.itemName,
                                batchQty : '',
                                expiryDate : '',
                                lotNo : '',
                                transferQty : '',
                                manufactureDef : '',
                                mrp : '',
                                originalConvertedQty : ''
                            }
                            // var currentYear = d.getFullYear();
                            // batchDetails.push(value.dtlItemId)
                            // batchDetails.push(value.dtlItemName)
                            // batchDetails.push(date)
                            // batchDetails.push(lotNo)
                            // batchDetails.push(manufactureDef)
                            // batchDetails.push(mrp)
                            // batchDetails.push(originalConvertedQty)
                            BatchDetails.push(batchDetails);
                            // value.batchDtls = BatchDetails;
                            $scope.StockTransfor.rowCollection[key].batchDetails = BatchDetails;

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
                        } else {
                            flag = true;
                            ++key;
                            logger.logError(" Quantity should be greater then 0 in Row" + " " + key);

                        }
                    });
                    if (isQuantity == true) {
                        if (issueStatus != "" & requisitionId != "") {
                            $http.get("app/hospital/purchase/consignmentRequest/issueStatus?requisitionId=" + requisitionId + "&issueStatus=" + issueStatus).success(function(response) {
                                // if (response.success == true) {
                                // }
                            });
                        }
                        if (!flag) {
                            // if (batchValid == true) {
                            $http.post("hospital/inventory/stocktransfer/save", StockTransfor).success(function(response) {
                                if (response.success == true) {

                                    logger.logSuccess("Data Saved Successfully");
                                    $state.go('app.inventory.stockmovement.list');
                                }
                            }).error(function(result) {
                                logger.logError("Error Please Try Again");
                            });
                        }
                        // } else {
                        // logger.logError("Please Add Atleast One Batch
                        // Details!");
                        // }
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

        // / KITHCEN BASED ..............................................

        $scope.getItemList = function(destId,companyId) {
            if(destId != '' && destId != null && destId != undefined && companyId != ''  && companyId != null  && companyId != undefined )
                {
            $http.get('hospital/inventory/stocktransfer/ItemList?destId=' + destId+ '&companyId=' +companyId).success(function(datas) {
                $scope.ItemList = datas;
                $scope.itemListData = datas;
            }).error(function(datas) {
            });
                }
        }

        $scope.saveKitchenbased = function(ondutyrequestForm, StockTransfor) {

            var isQuantity = true;
            var batchValid = true;
            var flag = false;
            if (new validationService().checkFormValidity($scope.ondutyrequestForm)) {
                // if($scope.validateQty()){
                if ($scope.StockTransfor.rowCollection.length >= 1) {
                    angular.forEach($scope.StockTransfor.rowCollection, function(value, key) {
                        if ($scope.StockTransfor.rowCollection[key].quantity != 0 && $scope.StockTransfor.rowCollection[key].quantity > 0) {

                            var originalqty = value.originalQty;
                            var enteredqty = value.quantity;
                            if (enteredqty < originalqty) {
                                requisitionId = parseInt($scope.StockTransfor.requisition);
                                issueStatus = 213;
                            }
                            if (enteredqty == originalqty) {
                                requisitionId = parseInt($scope.StockTransfor.requisition);
                                issueStatus = 214;
                            }

                            if (value.quantity > 0) {
                            } else {
                                isQuantity = false;
                            }
                            /*
                             * if (value.batchNoExist == true) { if
                             * (value.batchDetails.length == 0) { batchValid =
                             * false } }
                             */
                            var batAttrbutList = [];
                            var BatchDetails = [];
                            var batchDetails = {
                                dtlItemId : value.itemCode,
                                batchItemName : value.itemName,
                                batchQty : '',
                                expiryDate : '',
                                lotNo : '',
                                transferQty : '',
                                manufactureDef : '',
                                mrp : '',
                                originalConvertedQty : ''
                            }
                            // var currentYear = d.getFullYear();
                            // batchDetails.push(value.dtlItemId)
                            // batchDetails.push(value.dtlItemName)
                            // batchDetails.push(date)
                            // batchDetails.push(lotNo)
                            // batchDetails.push(manufactureDef)
                            // batchDetails.push(mrp)
                            // batchDetails.push(originalConvertedQty)
                            BatchDetails.push(batchDetails);
                            // value.batchDtls = BatchDetails;
                            $scope.StockTransfor.rowCollection[key].batchDetails = BatchDetails;

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
                        } else {
                            flag = true;
                            ++key;
                            logger.logError(" Quantity should be greater then 0 in Row" + " " + key);

                        }
                    });
                    if (isQuantity == true) {
                        if (issueStatus != "" & requisitionId != "") {
                            $http.get("app/hospital/purchase/consignmentRequest/issueStatus?requisitionId=" + requisitionId + "&issueStatus=" + issueStatus).success(function(response) {
                                // if (response.success == true) {
                                // }
                            });
                        }
                        if (!flag) {
                            // if (batchValid == true) {
                            $http.post("hospital/inventory/stocktransfer/saveKitchenBase", StockTransfor).success(function(response) {
                                if (response.success == true) {

                                    logger.logSuccess("Data Saved Successfully");
                                    $state.go('app.inventory.stockmovement.list');
                                    //                                  $state.reload();
                                }
                            }).error(function(result) {
                                logger.logError("Error Please Try Again");
                            });
                        }
                        // } else {
                        // logger.logError("Please Add Atleast One Batch
                        // Details!");
                        // }
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

    });

    app.controller('stockTransferItemCtrlAdd', function($scope, $filter, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.itemCodeChange = function(itemCode, row) {
            var obj = $filter('filter')($scope.ItemList, {
                id : itemCode
            });

            $scope.StockTransfor.rowCollection[row].itemName = $scope.ItemList[row].itemName;
            $scope.StockTransfor.rowCollection[row].requisitionNo = $scope.ItemList[row].requisitionNo;
            $scope.StockTransfor.rowCollection[row].itemDesc = $scope.ItemList[row].itemDesc;
            $scope.StockTransfor.rowCollection[row].uom = $scope.ItemList[row].uom;
            $scope.StockTransfor.rowCollection[row].prquantity = $scope.ItemList[row].prquantity;
            $scope.StockTransfor.rowCollection[row].availableQTY = $scope.ItemList[row].availableQTY;

            $scope.StockTransfor.rowCollection[row].quantity = 0;
            $scope.StockTransfor.rowCollection[row].originalQty = $scope.ItemList[row].originalQty;
            $scope.StockTransfor.rowCollection[row].reqDetailId = $scope.ItemList[row].reqDetailId;
            $scope.StockTransfor.rowCollection[row].batchNoExist = $scope.ItemList[row].batchNoExist;

        }
        // ///////////////// for item based/
        /*
         * $scope.StockTransfordetails = function(itemId){
         * $scope.$watchCollection('[StockTransfor.itemCode,StockTransfor.destLocName,StockTransfor.companyId]',
         * function(newValue, oldVal) {
         * $http.get('hospital/inventory/stocktransfer/getDtlList?itemCode=' +
         * itemId + '&destLoc=' + $scope.StockTransfor.destLocName +
         * '&companyId=' + $scope.StockTransfor.companyId
         * ).success(function(datas) { $scope.DtlList =
         * datas.lStockTransferBean;
         * 
         * }); }); }
         */

        $scope.validateQuantity = function(quantity, originalQty, availableQty, index) {
            if (quantity > availableQty || quantity > originalQty) {
                logger.logError("Quantity Cannot be Increased!");
                $scope.StockTransfor.rowCollection[index].quantity = 0;
//                if (quantity > originalQty) {
//                    // if(availableQty)
//                    logger.logError("Quantity Cannot be Increased!");
//                    $scope.StockTransfor.rowCollection[index].quantity = 0;
//                }
            }

        }

        $scope.$watch('StockTransfor.rowCollection[trIndex].itemCode', function(newValue, oldValue) {

            if ($scope.StockTransfor.issueType == '218') {
                if (newValue != undefined && newValue != '') {
                    var length = $scope.StockTransfor.rowCollection.length;
                    for (var i = 0; i < length; i++) {
                        for (var j = 0; j < length; j++) {
                            if (i != j) {
                                if ($scope.StockTransfor.rowCollection[i].itemCode != undefined && $scope.StockTransfor.rowCollection[i].itemCode != null && $scope.StockTransfor.rowCollection[i].itemCode != '' && $scope.StockTransfor.rowCollection[j].itemCode != undefined && $scope.StockTransfor.rowCollection[j].itemCode != null && $scope.StockTransfor.rowCollection[j].itemCode != '') {
                                    if ($scope.StockTransfor.rowCollection[i].itemCode == $scope.StockTransfor.rowCollection[j].itemCode && $scope.StockTransfor.rowCollection[i].itemDesc == $scope.StockTransfor.rowCollection[j].itemDesc

                                    ) {
                                        logger.logError("Item already added");
                                        $scope.StockTransfor.rowCollection[$scope.$index].itemCode = '';
                                        return false;
                                    } else {
                                      
                                        // logger.logError("NO dublicate");
                                        // $scope.StockTransfordetails();
                                        // $scope.StockTransfordetails($scope.StockTransfor.rowCollection[i].itemCode);

                                    }
                                }

                            }
                        }
                    }
                    angular.forEach($scope.itemListData, function(value, index) {
                        if (value.id == newValue) {
                            $http.get("hospital/inventory/stocktransfer/getQtyFromStock?itemCode=" + value.id+ '&destId=' + $scope.StockTransfor.destLocName+ '&companyId=' +$scope.StockTransfor.companyId).success(function(response) {

                                //                                var pendingQuantity = response.pendingQuantity;
                                if(response.checkQuantity != 0){

                                    $scope.StockTransfor.rowCollection[$scope.$index].quantity = 0;
                                    $scope.StockTransfor.rowCollection[$scope.$index].itemDesc = value.description;
                                    if (response.pendingQuantity == 0) {
                                        $scope.StockTransfor.rowCollection[$scope.$index].prquantity = value.quantity ;
                                    } else {
                                        $scope.StockTransfor.rowCollection[$scope.$index].prquantity = response.checkQuantity;

                                    }
                                    $scope.StockTransfor.rowCollection[$scope.$index].availableQTY = response.availableQTY;
                                    //                               $scope.StockTransfor.rowCollection[$scope.$index].requisitionDetailId = value.requisitionDetailId;
                                    $scope.StockTransfor.rowCollection[$scope.$index].uom = value.uom;
                                    $scope.StockTransfor.rowCollection[$scope.$index].originalQty = value.originalQty;
                                    
 
                                }else{
                                    logger.logError("Item Already Issued");                                  


                                    $scope.StockTransfor.rowCollection[$scope.$index].quantity = 0;
                                    $scope.StockTransfor.rowCollection[$scope.$index].itemDesc = value.description;
                                    if (response.pendingQuantity == 0) {
                                        $scope.StockTransfor.rowCollection[$scope.$index].prquantity = 0;
                                    } else {
                                        $scope.StockTransfor.rowCollection[$scope.$index].prquantity = response.pendingQuantity;

                                    }
                                    $scope.StockTransfor.rowCollection[$scope.$index].availableQTY = response.availableQTY;
                                    //                               $scope.StockTransfor.rowCollection[$scope.$index].requisitionDetailId = value.requisitionDetailId;
                                    $scope.StockTransfor.rowCollection[$scope.$index].uom = value.uom;
 
                                
                                }
                            });
                            //                            $scope.StockTransfor.rowCollection[$scope.$index].quantity = value.quantity;

                        }
                    });
                } else {

                    $scope.StockTransfor.rowCollection[$scope.$index].itemName = ''
                    $scope.StockTransfor.rowCollection[$scope.$index].requisitionNo = ''
                    $scope.StockTransfor.rowCollection[$scope.$index].uom = '';
                    $scope.StockTransfor.rowCollection[$scope.$index].prquantity = '';
                    $scope.StockTransfor.rowCollection[$scope.$index].availableQTY = '';

                    $scope.StockTransfor.rowCollection[$scope.$index].quantity = '';
                    $scope.StockTransfor.rowCollection[$scope.$index].originalQty = '';
                    $scope.StockTransfor.rowCollection[$scope.$index].reqDetailId = '';
                    $scope.StockTransfor.rowCollection[$scope.$index].batchNoExist = false;
                }

            }
            // $scope.$watchCollection('[StockTransfor.rowCollection[trIndex].itemCode,StockTransfor.rowCollection[trIndex].itemDesc]',
            // function(newValue, oldValue) {
            else if (newValue != undefined && newValue != '') {
                var length = $scope.StockTransfor.rowCollection.length;
                for (var i = 0; i < length; i++) {
                    for (var j = 0; j < length; j++) {
                        if (i != j) {
                            if ($scope.StockTransfor.rowCollection[i].itemCode != undefined && $scope.StockTransfor.rowCollection[i].itemCode != null && $scope.StockTransfor.rowCollection[i].itemCode != '' && $scope.StockTransfor.rowCollection[j].itemCode != undefined && $scope.StockTransfor.rowCollection[j].itemCode != null && $scope.StockTransfor.rowCollection[j].itemCode != '') {
                                if ($scope.StockTransfor.rowCollection[i].itemCode == $scope.StockTransfor.rowCollection[j].itemCode && $scope.StockTransfor.rowCollection[i].itemDesc == $scope.StockTransfor.rowCollection[j].itemDesc

                                ) {
                                    logger.logError("Item already added");
                                    $scope.StockTransfor.rowCollection[$scope.$index].itemCode = '';
                                    return false;
                                } else {

                                    // logger.logError("NO dublicate");
                                    // $scope.StockTransfordetails();
                                    // $scope.StockTransfordetails($scope.StockTransfor.rowCollection[i].itemCode);

                                }
                            }

                        }
                    }
                }
                $scope.itemCodeChange(newValue, $scope.$index);

            } else {

                $scope.StockTransfor.rowCollection[$scope.$index].itemName = ''
                $scope.StockTransfor.rowCollection[$scope.$index].requisitionNo = ''
                $scope.StockTransfor.rowCollection[$scope.$index].uom = '';
                $scope.StockTransfor.rowCollection[$scope.$index].prquantity = '';
                $scope.StockTransfor.rowCollection[$scope.$index].availableQTY = '';

                $scope.StockTransfor.rowCollection[$scope.$index].quantity = '';
                $scope.StockTransfor.rowCollection[$scope.$index].originalQty = '';
                $scope.StockTransfor.rowCollection[$scope.$index].reqDetailId = '';
                $scope.StockTransfor.rowCollection[$scope.$index].batchNoExist = false;
            }

        });

        app.controller('stockMovementPopupCtrl', function($scope, $state, itemCode, rowId, $http, $location, sharedProperties, toaster, $injector, logger, ngDialog, $rootScope, $controller) {
            $http.get("hospital/inventory/stocktransfer/getBatchNoDetails?itemCode=" + itemCode + "&sourceLoc=" + $scope.StockTransfor.sourceLoc).success(function(response) {
                if (response.success == true) {
                    if ($scope.StockTransfor.rowCollection[rowId].batchDetails.length == 0) {
                        $scope.rowCollectionBatch = response.lStockTransferBatchBean;
                        angular.forEach($scope.rowCollectionBatch, function(value, key) {
                            value.transferQty = 0;
                        });
                    } else {
                        $scope.rowCollectionBatch = $scope.StockTransfor.rowCollection[rowId].batchDetails;
                    }
                } else {
                    logger.logError("This Item doesn't have any Batch No Details!");
                }

            });

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

            $scope.cancelBatch = function() {
                ngDialog.close();
            }

            $scope.fetchDetail = function(rowCollectionBatch) {

                var batchList = [];
                var flag = false;
                var transferQty = false;

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
                        if (totalQty <= transferQty) {
                            $scope.StockTransfor.rowCollection[rowId].batchDetails = batchList;
                            // $scope.StockTransfor.rowCollection[rowId].quantity
                            // = totalQty;
                            $scope.StockTransfor.rowCollection[rowId].quantity = 0;

                            ngDialog.close();
                            logger.logError("Transfer Quantity Should Not Exceed Requested Quantity");
                        }
                    }

                }

            }

        });

    });

    app.directive('phonenumbersOnly', function(logger) {
        return {
            require : 'ngModel',
            link : function(scope, element, attrs, modelCtrl) {

                modelCtrl.$parsers.push(function(inputValue) {
                    var inputValue = modelCtrl.$viewValue;
                    if (inputValue == undefined)
                        return ''
                    var transformedInput = inputValue.replace(/[^0-9]/g, '');
                    if (transformedInput != inputValue) {
                        modelCtrl.$setViewValue(transformedInput);
                        modelCtrl.$render();
                    } else {

                    }

                    return transformedInput;
                });
            }
        };
    });

//});