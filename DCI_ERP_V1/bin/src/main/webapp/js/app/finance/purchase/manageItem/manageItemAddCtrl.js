define([ 'hospital/purchase/purchase', 'jqGrid' ], function(module, app) {

    'use strict';
    module.registerController('manageItemAddCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, ManageItemService, validationService, $filter) {
        $scope.manageItemObjValidate = {
            isEdit : true
        }
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isDisplay = true;

        $scope.manageItemObj = {
            itemTypeId : '',
            itemCode : '',
            itemName : '',
            itemDescription : '',
            itemCategoryId : '',
            saleable : false,
            purchaseable : false,
            requestable : true,
            purchaseId : '',
            uomId : '',
            reorderLevel : '',
            minQuantity : '',
            maxQuantity : '',
            costingId : '',
            warranty : '',
            costPrice : '',
            leadTime : '',
            inventoryValuationId : '',
            issueId : '',
            id : '',
            typeinput : '',
            labelName : '',
            defaultvalue : '',
            attributevalue : '',
            attributeId : '',
            itemSpecificationId : '',
            isMrp : false,
            isBatch : false,
            isExpiry : false,
            isManfactureDetails : false,
            specificationList : [],
            tables : []
        };

        $scope.tables = [];
        $scope.loadTable = function() {
            var table = {};
            table.row = [ {
                tableId : '',
                entityId : '',
                vendorItemName : '',
                vendorItemCode : '',
                vendorMinimumQuantity : '',
                vendorUom : '',
                pricingType : '',
                vendorLeadTime : '',

            } ];
            $scope.manageItemObj.tables.push(table);
        }

        $scope.loadTable();

        $scope.addRow = function(tables) {
            var table = {
                tableId : '',
                entityId : '',
                vendorItemName : '',
                vendorItemCode : '',
                vendorMinimumQuantity : '',
                vendorUom : '',
                pricingType : '',
                vendorLeadTime : '',

            };

            tables.row.push(table);
        }

        $scope.cancelItem = function() {
            $state.go("app.hospital.purchase.manageitem.list");
        };

        $scope.removeRowForm = function(table) {
            $scope.tablerow = [];
            if (table.row.length > 1) {
                angular.forEach(table.row, function(row, index) {

                    var check = row.tableId;
                    if (check == undefined || check == "") {
                        $scope.tablerow.push(row);
                    } else {

                    }

                });
                table.row = $scope.tablerow;
            } else {
                logger.logError("Minimum 1!");

            }

        }
        $scope.onchangeItemCategoryList = function(itemTypeId) {
            // For Only Asset
                if(itemTypeId !== null){
            if (itemTypeId === 15) {
                var obj = $filter('filter')($scope.globalcategoryList, {
                    itemCategorytype : itemTypeId
                });
                $scope.categoryList = obj;
            } else {
                var obj = $filter('filter')($scope.globalcategoryList, {
                    itemCategorytype : '!' + 15
                });
                $scope.categoryList = obj;
            }
            }else{
                $scope.categoryList=$scope.globalcategoryList
            }
        }

        ManageItemService.dropDownList().then(function(result) {
            $scope.globalcategoryList = result.data.itemCategoryList;
            $scope.categoryList = result.data.itemCategoryList;
            $scope.uomList = result.data.uomList;
            $scope.entityList = result.data.entityList;
        });

        ManageItemService.defList().then(function(result) {
            $scope.costingList = result.data.costingList;
            $scope.inventoryValuvationList = result.data.inventoryValuvationList;
            $scope.issueList = result.data.issueList;
            $scope.itemCategoryList = result.data.itemCategoryList;
            $scope.itemTypeList = result.data.itemTypeList;
            $scope.pricingTypeList = result.data.pricingTypeList;
            $scope.purchaseList = result.data.purchaseList;
        });

        
        $scope.$watch('manageItemObj.itemCategoryId', function(newValue, oldValue) {
            if(newValue != ""){
                $scope.getSpecification(newValue)
           }
        });
        
        $scope.getSpecification = function(itemCategoryId) {

            $http.get("hospital/inventory/manageitem/attributeDetails?itemCategoryId=" + itemCategoryId).success(function(response) {
                if (response.success == true) {
                    var data = response.specificationList;
                    $scope.specificationDetails = [];
                    $scope.manageItemObj.specificationList = [];
                    angular.forEach(data, function(specificationDetails, index) {
                        $scope.specificationDetails.push(specificationDetails);
                        $scope.specificationDetails[index].defaultvalue = specificationDetails.defaultvalue.split(",");
                        var atri = {
                            attributeId : specificationDetails.id,
                            attributevalue : ''
                        }
                        $scope.manageItemObj.specificationList.push(atri);
                    });
                }
            });
            $http.get("hospital/inventory/manageitem/grnattributeDetails?itemCategoryId=" + itemCategoryId).success(function(response) {
                if(response.length>0){
                    $scope.manageItemObj.isMrp = response[0].isMrp;
                    $scope.manageItemObj.isBatch = response[0].isBatch;
                    $scope.manageItemObj.isExpiry = response[0].isExpiry;
                    $scope.manageItemObj.isManfactureDetails = response[0].isManfactureDetails;
                }

            });

        };

        $scope.submit = function(manageItemAddForm, manageItemObj) {
            if (new validationService().checkFormValidity($scope.manageItemAddForm)) {
                $scope.save(manageItemObj);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.manageItemAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function(manageItemObj) {
            var objWholeData = {
                'itemTypeId' : manageItemObj.itemTypeId,
                'itemCode' : manageItemObj.itemCode,
                'itemName' : manageItemObj.itemName,
                'itemDescription' : manageItemObj.itemDescription,
                'itemCategoryId' : manageItemObj.itemCategoryId,
                'isSaleable' : manageItemObj.saleable,
                'isPurchaseable' : manageItemObj.purchaseable,
                'isRequestable' : manageItemObj.requestable,
                'purchaseId' : manageItemObj.purchaseId,
                'uomId' : manageItemObj.uomId,
                'reorderLevel' : manageItemObj.reorderLevel,
                'minQuantity' : manageItemObj.minQuantity,
                'maxQuantity' : manageItemObj.maxQuantity,
                'costingId' : manageItemObj.costingId,
                'warranty' : manageItemObj.warranty,
                'costPrice' : manageItemObj.costPrice,
                'leadTime' : manageItemObj.leadTime,
                'isMrp' : manageItemObj.isMrp,
                'isBatch' : manageItemObj.isBatch,
                'isExpiry' : manageItemObj.isExpiry,
                'isManfactureDetails' : manageItemObj.isManfactureDetails,
                'inventoryValuationId' : manageItemObj.inventoryValuationId,
                'issueId' : manageItemObj.issueId,
                'lmanageitemvendor' : manageItemObj.tables[0].row,
                'specificationList' : manageItemObj.specificationList
            };
            
            if(manageItemObj.saleable==false && manageItemObj.purchaseable==false){
                logger.logError("Please Select Either Saleable or Purchaseable!");
            }else{
                var myURL = 'hospital/inventory/manageitem/save';
                $http({
                    url : myURL,
                    data : objWholeData,
                    method : 'post',
                    dataType : 'json',
                    headers : {
                        'Accept' : 'application/json',
                        'Content-Type' : 'application/json'
                    }

                }).success(function(data) {
                    if (data) {
                        logger.logSuccess("Item Saved successfully!");
                        $state.go("app.hospital.purchase.manageitem.list");
                    } else {
                        logger.logError("Item Not Saved!");
                    }
                }).error(function(data) {
                    logger.logError("Error Not Saved!");
                });
            }

        };
        $scope.outgoing = true;
        $scope.InventoryNone1 = false;
        $scope.InventoryNone = true;

    });

    module.registerController('manageItemEditCtrl', function($scope, $stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, ManageItemService) {

        $scope.outgoing = true;
        var itemCode = $stateParams.itemId;
        $scope.manageItemObj = {
            itemId : '',
            itemTypeId : '',
            itemCode : '',
            itemName : '',
            itemDescription : '',
            itemCategoryId : '',
            saleable : true,
            purchaseable : true,
            requestable : true,
            purchaseId : '',
            uomId : '',
            reorderLevel : '',
            minQuantity : '',
            maxQuantity : '',
            costingId : '',
            warranty : '',
            costPrice : '',
            leadTime : '',
            inventoryValuationId : '',
            issueId : '',
            id : '',
            typeinput : '',
            labelName : '',
            defaultvalue : '',
            attributevalue : '',
            attributeId : '',
            itemSpecificationId : '',
            rdoDays : '',
            isMrp : false,
            isBatch : false,
            isExpiry : false,
            isManfactureDetails : false,
            specificationList : [],
            tables : [],
            deleteIds : []
        };
        $scope.manageItemObj.tables = [ {
            row : []
        } ];

        $scope.addRow = function(tables) {
            var table = {
                tableId : '',
                entityId : '',
                vendorItemName : '',
                vendorItemCode : '',
                vendorMinimumQuantity : '',
                vendorUom : '',
                pricingType : '',
                vendorLeadTime : '',
                vendorId : 0
            };

            tables.row.push(table);
        }

        $scope.manageItemObjValidate = {
            isEdit : false
        }
        $scope.cancelItem = function() {
            $state.go("app.hospital.purchase.manageitem.list");
        };

        $scope.removeRowForm = function(table) {
            $scope.tablerow = [];
            angular.forEach(table.row, function(row, index) {
                var check = row.tableId;
                if (check == undefined || check == "") {
                    $scope.tablerow.push(row);
                } else {
                    if (row.vendorId > 0) {
                        $scope.manageItemObj.deleteIds.push(row.vendorId);
                    }
                }

            });
            table.row = $scope.tablerow;

        }

        ManageItemService.dropDownList().then(function(result) {
            $scope.globalcategoryList = result.data.itemCategoryList;
            $scope.categoryList = result.data.itemCategoryList;
            $scope.uomList = result.data.uomList;
            $scope.entityList = result.data.entityList;
        });

        ManageItemService.defList().then(function(result) {
            $scope.costingList = result.data.costingList;
            $scope.inventoryValuvationList = result.data.inventoryValuvationList;
            $scope.issueList = result.data.issueList;
            $scope.itemCategoryList = result.data.itemCategoryList;
            $scope.itemTypeList = result.data.itemTypeList;
            $scope.pricingTypeList = result.data.pricingTypeList;
            $scope.purchaseList = result.data.purchaseList;
        });
       
        $scope.onchangeItemCategoryList = function(itemTypeId) {
            // For Only Asset
            console.log($scope.globalcategoryList);
            if (itemTypeId === 15) {
                var obj = $filter('filter')($scope.globalcategoryList, {
                    itemCategorytype : itemTypeId
                });
                $scope.categoryList = obj;
            } else {
                var obj = $filter('filter')($scope.globalcategoryList, {
                    itemCategorytype : '!' + 15
                });
                $scope.categoryList = obj;
            }
        }

        $scope.$watch('manageItemObj.itemCategoryId', function(newValue, oldValue) {
            if(newValue != ""){
                $scope.getSpecification(itemCategoryId)
           }
        });
        $scope.getSpecification = function(itemCategoryId) {
            if(itemCategoryId > 0){
            $http.get("hospital/inventory/manageitem/attributeDetails?itemCategoryId=" + itemCategoryId).success(function(response) {
                if (response.success == true) {
                    var data = response.specificationList;
                    $scope.specificationDetails = [];
                    $scope.manageItemObj.specificationList = [];
                    angular.forEach(data, function(specificationDetails, index) {
                        $scope.specificationDetails.push(specificationDetails);
                        $scope.specificationDetails[index].defaultvalue = specificationDetails.defaultvalue.split(",");
                        var atri = {
                            attributeId : specificationDetails.id,
                            attributevalue : ''
                        }
                        $scope.manageItemObj.specificationList.push(atri);
                    });
                }
            });
            }

        };

        $scope.getEditManageItemList = function(itemCode) {
            var url = 'hospital/inventory/manageitem/getManageItemEditList?ItemCode=' + itemCode;
            $http.get(url).success(function(result) {
                $scope.manageItemObj.itemId = result.itemList[0].itemId;
                $scope.manageItemObj.itemTypeId = result.itemList[0].itemTypeId;
                if ($scope.manageItemObj.itemTypeId === 16) {
                    $scope.consumPattern = true;
                    $scope.manageItemObj.rdoDays = 30;
                    $scope.getItemConsumptionReport(itemCode, $scope.manageItemObj.rdoDays);
                }

                $scope.manageItemObj.itemCode = result.itemList[0].itemCode;
                $scope.manageItemObj.itemName = result.itemList[0].itemName;
                $scope.manageItemObj.itemDescription = result.itemList[0].itemDescription;
                $scope.manageItemObj.itemCategoryId = result.itemList[0].itemCategoryId;
                $scope.manageItemObj.saleable = result.itemList[0].saleable;
                $scope.manageItemObj.purchaseable = result.itemList[0].purchaseable;
                $scope.manageItemObj.requestable = result.itemList[0].requestable;
                $scope.manageItemObj.purchaseId = result.itemList[0].purchaseId;
                $scope.manageItemObj.uomId = result.itemList[0].uomId;

                $scope.manageItemObj.reorderLevel = result.itemList[0].reorderLevel;
                $scope.manageItemObj.minQuantity = result.itemList[0].minQuantity;
                $scope.manageItemObj.maxQuantity = result.itemList[0].maxQuantity;
                $scope.manageItemObj.costingId = result.itemList[0].costingId;
                $scope.manageItemObj.warranty = result.itemList[0].warranty;
                $scope.manageItemObj.costPrice = result.itemList[0].costPrice.toFixed(2);
                $scope.manageItemObj.leadTime = result.itemList[0].leadTime;
                $scope.manageItemObj.inventoryValuationId = result.itemList[0].inventoryValuationId;
                $scope.manageItemObj.issueId = result.itemList[0].issueId;

                $scope.manageItemObj.isMrp = result.itemList[0].isMrp
                $scope.manageItemObj.isBatch = result.itemList[0].isBatch
                $scope.manageItemObj.isExpiry = result.itemList[0].isExpiry
                $scope.manageItemObj.isManfactureDetails = result.itemList[0].isManfactureDetails

                $scope.manageItemObj.tables[0].row = result.itemvendorList;
                $scope.manageItemObj.specificationList = result.itemspecificationList;
                $scope.getSpecification($scope.manageItemObj.itemCategoryId);

                $scope.rowCollection1 = result.listItemLocation;
                if (result.listItemLocation === null) {
                    $scope.InventoryNone1 = false;
                    $scope.InventoryNone = true;

                } else if (result.listItemLocation.length > 0) {
                    $scope.InventoryNone1 = true;
                    $scope.InventoryNone = false;
                    $scope.createGrid(result.listItemLocation);
                }

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }
        $scope.getEditManageItemList(itemCode);

        $scope.reloadGrid = function(data) {
            $('#grid').setGridParam({
                data : data,
                rowNum : data.length
            }).trigger('reloadGrid');
        };

        $scope.getSubGridList = function(item, location, subgridDivId) {
            $http.get('app/inventoryRprt/inventroySubList?item=' + item + '&location=' + location).success(function(data) {
                var subgridTableId = subgridDivId + "_t";
                $("#" + subgridTableId).setGridParam({
                    data : data.inventorySubList,
                    rowNum : data.inventorySubList.length
                }).trigger('reloadGrid');
            });
        };

        $scope.createGrid = function(inventoryList) {
            $("#grid").jqGrid({
                data : inventoryList,
                datatype : "local",
                autowidth : true,
                autoheight : true,
                rowList : [ 5, 10, 20 ],
                gridview : true,
                sortname : 'invdate',
                viewrecords : true,
                sortorder : 'desc',
                multiselect : false,
                multiboxonly : false,
                colNames : [ 'Item Id', 'Item Name', 'Item Desc', 'Location Id', 'Location', 'Quantity' ],
                colModel : [ {
                    name : 'itemId',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : true
                }, {
                    name : 'itemName',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'itemDesc',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'locationId',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : true
                }, {
                    name : 'locationName',
                    width : 250,
                    align : "left",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }, {
                    name : 'qty',
                    width : 250,
                    align : "right",
                    searchoptions : {
                        sopt : [ 'cn' ]
                    },
                    hidden : false
                }

                ],
                loadOnce : true,
                pager : '#inventorypage',
                height : '100%',
                rowNum : 10,
                subGrid : true,
                subGridOptions : {
                    "plusicon" : 'fa fa-plus-circle',
                    "minusicon" : 'fa fa-minus-circle'

                },
                subGridRowExpanded : function(subgridDivId, rowId) {

                    var rowData = $('#grid').jqGrid('getRowData', rowId);
                    $scope.getSubGridList(rowData.itemId, rowData.locationId, subgridDivId);
                    var subgridTableId = subgridDivId + "_t";
                    var pager_child_id = "p_" + subgridTableId;
                    $("#" + subgridDivId).html("<table id='" + subgridTableId + "'></table><div id='" + pager_child_id + "' class='scroll'></div>");
                    $("#" + subgridTableId).jqGrid({
                        datatype : 'local',
                        data : "",
                        colNames : [ 'ledger Id', 'Date', 'Doc. Type', 'Doc. Ref', 'Src. Location', 'Dst. Location', 'InQty', 'OutQty' ],
                        autowidth : true,
                        colModel : [ {
                            name : 'ledgerId',
                            index : 'storageId',
                            width : 100,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            },
                            hidden : true
                        }, {
                            name : 'inventoryDate',
                            index : 'inventoryDate',
                            width : 80,
                            searchoptions : {
                                sopt : [ 'cn' ]
                            },
                            hidden : false
                        }, {
                            name : 'docType',
                            index : 'docType',
                            width : 150,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'refDoc',
                            index : 'refDoc',
                            width : 150,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'srcLocation',
                            index : 'srcLocation',
                            width : 150,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            },
                            hidden : true
                        }, {
                            name : 'dstLocation',
                            index : 'dstLocation',
                            width : 150,
                            align : "left",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            },
                            hidden : true
                        }, {
                            name : 'inQty',
                            index : 'inQty',
                            width : 80,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        }, {
                            name : 'outQty',
                            index : 'outQty',
                            width : 80,
                            align : "right",
                            searchoptions : {
                                sopt : [ 'cn' ]
                            }
                        } ],
                        autoheight : true,
                        height : '100%',
                        /* pager: pager_child_id, */
                        sortname : 'num',
                        sortorder : "asc",
                    });

                    // $("#"+subgridTableId).jqGrid('navGrid','#'+pager_child_id,{edit:false,add:false,del:false,search:false,refresh:false});

                }
            });
            $("#grid").jqGrid('navGrid', '#inventorypage', {
                edit : false,
                add : false,
                del : false,
                search : false,
                refresh : false
            });

            $("#grid").jqGrid('filterToolbar', {
                searchOperators : true,
                searchOnEnter : false
            });
            $("#grid").jqGrid('navButtonAdd', "#inventorypage", {
                caption : "",
                title : "Show/Hide Search box",
                buttonicon : 'ui-icon icon-thumb-tack',
                onClickButton : function() {
                    var myGrid = $('#grid');
                    myGrid[0].toggleToolbar();
                }
            });
            $("#grid")[0].toggleToolbar();
        };

        $scope.update = function(manageItemObj) {
            var objWholeData = {
                'itemId' : manageItemObj.itemId,
                'itemTypeId' : manageItemObj.itemTypeId,
                'itemCode' : manageItemObj.itemCode,
                'itemName' : manageItemObj.itemName,
                'itemDescription' : manageItemObj.itemDescription,
                'itemCategoryId' : manageItemObj.itemCategoryId,
                'isSaleable' : manageItemObj.saleable,
                'isPurchaseable' : manageItemObj.purchaseable,
                'isRequestable' : manageItemObj.requestable,
                'purchaseId' : manageItemObj.purchaseId,
                'uomId' : manageItemObj.uomId,
                'reorderLevel' : manageItemObj.reorderLevel,
                'minQuantity' : manageItemObj.minQuantity,
                'maxQuantity' : manageItemObj.maxQuantity,
                'costingId' : manageItemObj.costingId,
                'warranty' : manageItemObj.warranty,
                'costPrice' : manageItemObj.costPrice,
                'leadTime' : manageItemObj.leadTime,
                'inventoryValuationId' : manageItemObj.inventoryValuationId,
                'issueId' : manageItemObj.issueId,
                'ldeleteIds' : manageItemObj.deleteIds,
                'isMrp' : manageItemObj.isMrp,
                'isBatch' : manageItemObj.isBatch,
                'isExpiry' : manageItemObj.isExpiry,
                'isManfactureDetails' : manageItemObj.isManfactureDetails,
                'lmanageitemvendor' : manageItemObj.tables[0].row,
                'specificationList' : manageItemObj.specificationList
            };
            
            if(manageItemObj.saleable==false && manageItemObj.purchaseable==false){
                logger.logError("Please Select Either Saleable or Purchaseable!");
            }else{
                var myURL = 'hospital/inventory/manageitem/update';
                $http({
                    url : myURL,
                    data : objWholeData,
                    method : 'post',
                    dataType : 'json',
                    headers : {
                        'Accept' : 'application/json',
                        'Content-Type' : 'application/json'
                    }

                }).success(function(data) {
                    if (data) {
                        logger.logSuccess("Item Updated successfully!");
                        $state.go("app.hospital.purchase.manageitem.list");
                    } else {
                        logger.logError("Item Not Updated!");
                    }
                }).error(function(data) {
                    logger.logError("Error Not Updated!");
                });
            }

        };

        //Line Chart for Items
        $scope.onValueChange = function(value) {
            $scope.getItemConsumptionReport(itemCode, value);
        }

        $scope.getItemConsumptionReport = function(itemCode, rdoDays) {
            var itm;
            rdoDays = rdoDays - 1;
            $scope.itemMasterlist = [];
            $scope.itemDatelist = [];
            $scope.itemMaxlist = [];
            $scope.itemMinlist = [];
            $scope.itemAvglist = [];
            if ($scope.manageItemObj.itemId != undefined && $scope.manageItemObj.itemId != '') {
                itm = $scope.manageItemObj.itemId;
            }

            $http.get('hospital/inventory/manageitem/itemconsumptionList?itm=' + itm + '&rdoDays=' + rdoDays).success(function(response) {

                console.log("getConsumptionReport :::::::::::::::::");
                console.log(response);

                angular.forEach(response.itemConsumptionMasterList, function(value, index) {
                    $scope.itemMasterlist.push(value.qty);
                    $scope.itemDatelist.push(value.docDate);
                });
                angular.forEach(response.itemConsumptionMax, function(value, index) {
                    for (var i = 0; i <= rdoDays; i++) {
                        // maxQty = $scope.datelist[i];
                        $scope.itemMaxlist.push(value.maxQty);
                    }
                });
                angular.forEach(response.itemConsumptionMin, function(value, index) {
                    for (var i = 0; i <= rdoDays; i++) {
                        // minQty = $scope.datelist[i];
                        $scope.itemMinlist.push(value.minQty);
                    }
                });
                angular.forEach(response.itemConsumptionAvg, function(value, index) {
                    for (var i = 0; i <= rdoDays; i++) {
                        // avgQty = $scope.datelist[i];
                        $scope.itemAvglist.push(value.avgQty);
                    }
                });

                // Basic Line Chart
                $scope.chartConfig = {
                    title : {
                        text : 'Consumption Pattern',
                        x : -20
                    // centers
                    },
                    xAxis : {
                        title : {
                            text : 'Monthly Consumption'
                        },

                        categories : $scope.itemDatelist
                    },
                    yAxis : {
                        title : {
                            text : 'Item Quantity(Qty)'
                        },
                        plotLines : [ {
                            value : 0,
                            width : 0.1,
                            color : '#808080'
                        } ]
                    },
                    tooltip : {
                        valueSuffix : 'Qty'
                    },
                    legend : {
                        layout : 'vertical',
                        align : 'right',
                        verticalAlign : 'middle',
                        borderWidth : 0
                    },
                    series : [ {
                        name : 'Minimum',
                        showInLegend: true, 
                        connectNulls: true,
                        data : $scope.itemMinlist
                    }, {
                        name : 'Maximum',
                        showInLegend: true, 
                        connectNulls: true,
                        data : $scope.itemMaxlist
                    }, {
                        name : 'Average',
                        showInLegend: true, 
                        connectNulls: true,
                        data : $scope.itemAvglist
                    }, {
                        name : 'Rate of Consumption',
                        showInLegend: true, 
                        connectNulls: true,
                        data : $scope.itemMasterlist
                    } ]
                }

            }).error(function(response) {
            });
        };

    });

    //$scope.consumPattern
    module.registerFactory('ManageItemService', function($http) {

        return {
            dropDownList : function() {
                return $http.get('hospital/inventory/manageitem/dropDownList').then(function(result) {
                    return result;
                });
            },
            defList : function() {
                return $http.get('hospital/inventory/manageitem/defList').then(function(result) {
                    return result;
                });
            }
        }

    });

});
