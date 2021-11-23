//define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

    app.controller('itemCategoryAddCtrl', function($scope, $state, $http, $filter, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isEdit = false;
        $scope.deletedIds = [];
        $scope.deletedDepreciationIds = [];
        $scope.rowCollectionItem = [];
        $scope.displayedCollectionItem = [];
        $scope.globalparentCategoryList = [];

        $scope.itemCategoryObj = {
            categoryName : '',
            categoryTypeId : '',
            parentCategory : '',
            salesTaxesId : '',
            incomeAccountId : '',
            purchaseTaxesId : '',
            expenseAccountId : '',
            itemCategoryId : '',
            categoryTypeName : '',
            parentCategoryName : '',
            purchaseTaxesName : '',
            salesTaxesName : '',
            expenseAccountName : '',
            incomeAccountName : '',
            parentCategoryId : '',
            qualityCheck : 'N',
            itemCategoryAccountId : '',
            grnAttributeId : '',
            batchNo : 'N',
            mrp : 'N',
            expiryDate : 'N',
            manufactureDetails : 'N',
            propertyDetailList : []
        };

        $scope.itemPropertiesObj = {
            propertyTypeId : '',
            propName : '',
            propLength : '',
            propValue : '',
            defaultValSingleDropProp : '',
            manditory : 'N',
            dateName : '',
            lengthValue : '',
            decimalValue : '',
            defaultsValue : '',
            defaultValueList : '',
            typeId : '',
            typeName : '',
            isSelected : 'N',
            itemCategoryPropertyId : ''
        };

        $scope.categoryList = [];
        $scope.parentCategoryList = [];
        $scope.salesList = [];
        $scope.incomeAccountList = [];
        $scope.purchaseList = [];
        $scope.expenseAccountList = [];

        $scope.cancelItem = function() {
            $state.go('app.finance.inventory.manageitemcategory.list');
        };

        $http.get('hospital/inventory/manageitemcategory/getCategoryList').success(function(datas) {
            $scope.categoryList = datas.categoryList;
        });

        $http.get('hospital/inventory/manageitemcategory/getParentCategoryList').success(function(datas) {
            $scope.globalparentCategoryList = datas.parentCategoryList;
        });

        $http.get('hospital/inventory/manageitemcategory/getSalesList').success(function(datas) {
            $scope.salesList = datas.salesList;
        });

        $http.get('hospital/inventory/manageitemcategory/getPurchaseList').success(function(datas) {
            $scope.purchaseList = datas.purchaseList;
        });

        $http.get('hospital/inventory/manageitemcategory/getIncomeAccountList').success(function(datas) {
            $scope.incomeAccountList = datas.incomeAccountList;
        });

        $http.get('hospital/inventory/manageitemcategory/getExpenseAccountList').success(function(datas) {
            $scope.expenseAccountList = datas.expenseAccountList;
        });

        $scope.itemCategory = {
            accounts : []
        };

        $scope.cancelProperty = function() {
            ngDialog.close();
        };

        $scope.chkAll = false;
        $scope.checkAll = function(rowCollection, checkBox) {

            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollectionItem, function(value, key) {
                value.isSelected = $scope.chkAll;
            });
        };

        $scope.oncheckAsset = function() {
            var categoryType = $("#categoryTypeId option:selected").text();
            if (categoryType === "Asset") {
                var obj = $filter('filter')($scope.globalparentCategoryList, {
                    defName : categoryType
                });
                $scope.parentCategoryList = obj;
            } else {
                var obj = $filter('filter')($scope.globalparentCategoryList, {
                    defName : '!' + "Asset"
                });
                $scope.parentCategoryList = obj;
            }
        }

        $scope.removePropertyRow = function() {
            $scope.tableRow = [];
            for (var i = 0; i < $scope.rowCollectionItem.length; i++) {
                if ($scope.rowCollectionItem[i].isSelected) {
                    $scope.deletedIds.push({
                        "propName" : $scope.rowCollectionItem[i].propName,
                        "propertyTypeName" : $scope.rowCollectionItem[i].propertyTypeName,
                        "itemCategoryPropertyId" : $scope.rowCollectionItem[i].itemCategoryPropertyId
                    });
                } else {
                    $scope.tableRow.push($scope.rowCollectionItem[i]);

                }
            }
            $scope.rowCollectionItem = $scope.tableRow
        };

        $scope.checkCatgeoryName = function(categoryName) {

            $http.get('hospital/inventory/manageitemcategory/checkCategoryName?categoryName=' + categoryName).success(function(datas) {

                if (datas != 0) {
                    logger.logError('Category Name Already Exist!');
                    $scope.itemCategoryObj.categoryName = '';
                }

            }).error(function(datas) {
            });

        }

        $scope.$watch('itemCategoryObj.parentCategoryId', function(newValue, oldValue) {
            var parentCategoryId = newValue;

            if (parentCategoryId != "") {

                var myURL = 'hospital/inventory/manageitemcategory/getGrnAttributeList?parentCategoryId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : parentCategoryId,
                }).success(function(result) {

                    if (result.grnAttributeList[0].batchNo == "t") {
                        $scope.itemCategoryObj.batchNo = 'Y';
                    } else {
                        $scope.itemCategoryObj.batchNo = 'N';
                    }

                    if (result.grnAttributeList[0].mrp == "t") {
                        $scope.itemCategoryObj.mrp = 'Y';
                    } else {
                        $scope.itemCategoryObj.mrp = 'N';
                    }

                    if (result.grnAttributeList[0].expiryDate == "t") {
                        $scope.itemCategoryObj.expiryDate = 'Y';
                    } else {
                        $scope.itemCategoryObj.expiryDate = 'N';
                    }

                    if (result.grnAttributeList[0].manufactureDetails == "t") {
                        $scope.itemCategoryObj.manufactureDetails = 'Y';
                    } else {
                        $scope.itemCategoryObj.manufactureDetails = 'N';
                    }

                });

            } else {
                $scope.itemCategoryObj.batchNo = 'N';
                $scope.itemCategoryObj.manufactureDetails = 'N';
                $scope.itemCategoryObj.expiryDate = 'N';
                $scope.itemCategoryObj.mrp = 'N';
            }
        });

        $scope.reset = function(itemCategoryAddForm) {
            $scope.itemCategoryObj.categoryName = '';
            $scope.itemCategoryObj.categoryTypeId = '';
            $scope.itemCategoryObj.parentCategoryId = '';
            $scope.itemCategoryObj.salesTaxesId = '', $scope.itemCategoryObj.incomeAccountId = '', $scope.itemCategoryObj.purchaseTaxesId = '', $scope.itemCategoryObj.expenseAccountId = '', $scope.itemCategoryObj.qualityCheck = 'N', $scope.itemCategoryObj.batchNo = 'Y', $scope.itemCategoryObj.mrp = 'Y', $scope.itemCategoryObj.expiryDate = 'Y', $scope.itemCategoryObj.manufactureDetails = 'Y',

            $scope.rowCollectionItem = []
        };

        $scope.validate = function(itemCategoryAddForm, itemCategoryObj, itemDetail) {
            if (new validationService().checkFormValidity($scope.itemCategoryAddForm)) {
                
                    $scope.save(itemCategoryAddForm, itemCategoryObj, itemDetail);
                
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.itemCategoryAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function(itemCategoryAddForm, itemCategoryObj, itemDetail) {
            var itemPropertiesDetail = $scope.rowCollectionItem;
            $scope.itemCategoryObj.propertyDetailList = itemPropertiesDetail;

            if (itemPropertiesDetail.length > 0) {
                $http.post('hospital/inventory/manageitemcategory/add', itemCategoryObj).success(function(result) {
                    if (result == true) {
                        logger.logSuccess("Saved Successfully!");
                        $state.go('app.finance.inventory.manageitemcategory.list');
                    } else {
                        logger.logError("Not Saved!");
                    }
                });

            } else {
                logger.logError("Please Add Atleast One Item Properties!");
            }

        };

        $scope.addNewRow = function() {
            $scope.callDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/itemcategory/itemCategoryAddItem',
                controller : $controller('itemCategoryAddItemCtrl', {
                    $scope : $scope,
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
            });
        };

        $scope.getListValue = function(data) {
            var isExists = 0;
            var isChecked = false;
            var data;
            angular.forEach(data, function(value, key) {
                if (value.select == true) {
                    isChecked = true;
                }
            });

            if (isChecked) {
                var length = data.length;
                for (var i = 0; i < data.length; i++) {
                    if (data[i].select) {
                        data[i].select = false;
                        angular.forEach($scope.rowCollectionItem, function(value, key) {
                            if (value.propName == data[i].propName && value.propertyTypeName == data[i].propertyTypeName) {
                                isExists = 1;
                            }
                        });

                        if (isExists == 1) {
                            logger.logError("Selected Property Name and Property Type Already Exists!");
                        } else {
                            $scope.rowCollectionItem.push(data[i]);
                            ngDialog.close();
                        }

                    }
                }

            } else {
                logger.logError("Please Select Atleast One Row!");
            }

        };

    });

    app.controller('itemCategoryAddItemCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.propertyList = [];

        $scope.cancelReq = function() {
            ngDialog.close();
        };

        $scope.chkAll = false;
        $scope.checkAllProperty = function(rowCollection, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollection, function(value, key) {
                value.select = $scope.chkAll;
            });
        };

        $http.get('hospital/inventory/manageitemcategory/getPropertyList').success(function(datas) {
            $scope.propertyList = datas.propertyList;
        });

        $scope.getItemPropertiesList = function(propertyTypeId) {
            var url = 'hospital/inventory/manageitemcategory/getItemPropertiesDetail?propertyTypeId=' + propertyTypeId;
            $http.get(url).success(function(data) {
                if (data) {
                    $scope.rowCollection = data;
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

    });

    app.controller('itemCategoryEditCtrl', function($scope, $filter, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $stateParams, validationService) {

        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages = 0;
        $scope.isEdit = true;
        $scope.itemCategoryOldName = '';
        $scope.rowCollectionItem = [];
        $scope.displayedCollectionItem = [];
        $scope.globalparentCategoryList = [];

        var itemCategoryId = $stateParams.itemCategoryId;

        $scope.itemCategoryObj = {
            categoryName : '',
            categoryTypeId : '',
            parentCategory : '',
            salesTaxesId : '',
            incomeAccountId : '',
            purchaseTaxesId : '',
            expenseAccountId : '',
            itemCategoryId : '',
            categoryTypeName : '',
            parentCategoryName : '',
            purchaseTaxesName : '',
            salesTaxesName : '',
            expenseAccountName : '',
            incomeAccountName : '',
            parentCategoryId : '',
            qualityCheck : 'N',
            itemCategoryAccountId : '',
            grnAttributeId : '',
            batchNo : 'N',
            mrp : 'N',
            expiryDate : 'N',
            manufactureDetails : 'N',
            propertyDetailList : []
        };

        $scope.itemPropertiesObj = {
            propertyTypeId : '',
            propName : '',
            propLength : '',
            propValue : '',
            defaultValSingleDropProp : '',
            manditory : 'N',
            dateName : '',
            lengthValue : '',
            decimalValue : '',
            defaultsValue : '',
            defaultValueList : '',
            typeId : '',
            typeName : '',
            isSelected : 'N',
            itemCategoryPropertyId : ''
        };

        $scope.categoryList = [];
        $scope.parentCategoryList = [];
        $scope.salesList = [];
        $scope.incomeAccountList = [];
        $scope.purchaseList = [];
        $scope.expenseAccountList = [];
        $scope.deletedIds = [];

        $scope.chkAll = false;
        $scope.checkAll = function(rowCollection, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }
            angular.forEach($scope.rowCollectionItem, function(value, key) {
                value.isSelected = $scope.chkAll;
            });
        };

        $scope.removePropertyRow = function() {
            $scope.tableRow = [];
            for (var i = 0; i < $scope.rowCollectionItem.length; i++) {
                if ($scope.rowCollectionItem[i].isSelected) {
                    $scope.deletedIds.push({
                        "propName" : $scope.rowCollectionItem[i].propName,
                        "propertyTypeName" : $scope.rowCollectionItem[i].propertyTypeName,
                        "itemCategoryPropertyId" : $scope.rowCollectionItem[i].itemCategoryPropertyId
                    });
                } else {
                    $scope.tableRow.push($scope.rowCollectionItem[i]);

                }
            }
            $scope.rowCollectionItem = $scope.tableRow
        };

        $scope.oncheckAsset = function() {
            var categoryType = $("#categoryTypeId option:selected").text();
            if (categoryType === "Asset") {
                var obj = $filter('filter')($scope.globalparentCategoryList, {
                    defName : categoryType
                });
                $scope.parentCategoryList = obj;
            } else {
                var obj = $filter('filter')($scope.globalparentCategoryList, {
                    defName : '!' + "Asset"
                });
                $scope.parentCategoryList = obj;
            }
        }

        $scope.cancelItem = function() {
            $state.go('app.finance.inventory.manageitemcategory.list');
        };

        $http.get('hospital/inventory/manageitemcategory/getCategoryList').success(function(datas) {
            $scope.categoryList = datas.categoryList;
        });

        $http.get('hospital/inventory/manageitemcategory/getParentCategoryList').success(function(datas) {
            $scope.globalparentCategoryList = datas.parentCategoryList;

        });

        $http.get('hospital/inventory/manageitemcategory/getSalesList').success(function(datas) {
            $scope.salesList = datas.salesList;
        });

        $http.get('hospital/inventory/manageitemcategory/getPurchaseList').success(function(datas) {
            $scope.purchaseList = datas.purchaseList;
        });

        $http.get('hospital/inventory/manageitemcategory/getIncomeAccountList').success(function(datas) {
            $scope.incomeAccountList = datas.incomeAccountList;
        });

        $http.get('hospital/inventory/manageitemcategory/getExpenseAccountList').success(function(datas) {
            $scope.expenseAccountList = datas.expenseAccountList;
        });

        $scope.itemCategory = {
            accounts : []
        };

        $scope.cancelProperty = function() {
            ngDialog.close();
        };

        var url = 'hospital/inventory/manageitemcategory/getItemCategoryEditList?itemCategoryId=' + itemCategoryId;
        $http.get(url).success(function(result) {
            $scope.itemCategoryOldName = result.categoryName;
            $scope.itemCategoryObj.categoryName = result.categoryName;

            $scope.itemCategoryObj.categoryTypeId = result.categoryTypeId;
            $scope.itemCategoryObj.salesTaxesId = result.salesTaxesId;
            $scope.itemCategoryObj.incomeAccountId = result.incomeAccountId;
            $scope.itemCategoryObj.purchaseTaxesId = result.purchaseTaxesId;
            $scope.itemCategoryObj.expenseAccountId = result.expenseAccountId;
            $scope.itemCategoryObj.itemCategoryId = result.itemCategoryId;
            $scope.itemCategoryObj.parentCategoryId = result.parentCategoryId;
            $scope.itemCategoryObj.itemCategoryAccountId = result.itemCategoryAccountId;
            $scope.itemCategoryObj.grnAttributeId = result.grnAttributeId;
            $scope.rowCollectionItem = result.manageItemPropertiesList;

            if (result.qualityCheck == "true") {
                $scope.itemCategoryObj.qualityCheck = 'Y';
            } else {
                $scope.itemCategoryObj.qualityCheck = 'N';
            }

            if (result.batchNo == "true") {
                $scope.itemCategoryObj.batchNo = 'Y';
            } else {
                $scope.itemCategoryObj.batchNo = 'N';
            }

            if (result.mrp == "true") {
                $scope.itemCategoryObj.mrp = 'Y';
            } else {
                $scope.itemCategoryObj.mrp = 'N';
            }

            if (result.expiryDate == "true") {
                $scope.itemCategoryObj.expiryDate = 'Y';
            } else {
                $scope.itemCategoryObj.expiryDate = 'N';
            }

            if (result.manufactureDetails == "true") {
                $scope.itemCategoryObj.manufactureDetails = 'Y';
            } else {
                $scope.itemCategoryObj.manufactureDetails = 'N';
            }
            $scope.oncheckAsset();

        }).error(function(result) {
            logger.logError("Error Please Try Again");
        });

        $scope.reset = function(itemCategoryAddForm) {
            var url = 'hospital/inventory/manageitemcategory/getItemCategoryEditList?itemCategoryId=' + itemCategoryId;
            $http.get(url).success(function(result) {

                $scope.itemCategoryObj.categoryName = result.categoryName;
                $scope.itemCategoryObj.categoryTypeId = result.categoryTypeId;
                $scope.itemCategoryObj.salesTaxesId = result.salesTaxesId;
                $scope.itemCategoryObj.incomeAccountId = result.incomeAccountId;
                $scope.itemCategoryObj.purchaseTaxesId = result.purchaseTaxesId;
                $scope.itemCategoryObj.expenseAccountId = result.expenseAccountId;
                $scope.itemCategoryObj.itemCategoryId = result.itemCategoryId;
                $scope.itemCategoryObj.parentCategoryId = result.parentCategoryId;
                $scope.itemCategoryObj.itemCategoryAccountId = result.itemCategoryAccountId;
                $scope.rowCollectionItem = result.manageItemPropertiesList;
                $scope.itemCategoryObj.grnAttributeId = result.grnAttributeId;

                if (result.qualityCheck == "true") {
                    $scope.itemCategoryObj.qualityCheck = 'Y';
                } else {
                    $scope.itemCategoryObj.qualityCheck = 'N';
                }

                if (result.batchNo == "true") {
                    $scope.itemCategoryObj.batchNo = 'Y';
                } else {
                    $scope.itemCategoryObj.batchNo = 'N';
                }

                if (result.mrp == "true") {
                    $scope.itemCategoryObj.mrp = 'Y';
                } else {
                    $scope.itemCategoryObj.mrp = 'N';
                }

                if (result.expiryDate == "true") {
                    $scope.itemCategoryObj.expiryDate = 'Y';
                } else {
                    $scope.itemCategoryObj.expiryDate = 'N';
                }

                if (result.manufactureDetails == "true") {
                    $scope.itemCategoryObj.manufactureDetails = 'Y';
                } else {
                    $scope.itemCategoryObj.manufactureDetails = 'N';
                }

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        };

        $scope.addNewRow = function() {
            $scope.callDialog($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/itemcategory/itemCategoryAddItem',
                controller : $controller('itemCategoryAddItemCtrl', {
                    $scope : $scope,
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
            });
        };

        $scope.getListValue = function(data) {

            var isExists = 0;
            var isChecked = false;
            var data;
            angular.forEach(data, function(value, key) {
                if (value.select == true) {
                    isChecked = true;
                }
            });

            if (isChecked) {
                var length = data.length;
                for (var i = 0; i < data.length; i++) {
                    if (data[i].select) {
                        data[i].select = false;
                        angular.forEach($scope.rowCollectionItem, function(value, key) {
                            if (value.propName == data[i].propName && value.propertyTypeName == data[i].propertyTypeName) {
                                isExists = 1;
                            }
                        });

                        if (isExists == 1) {
                            logger.logError("Selected Property Name and Property Type Already Exists!");
                        } else {
                            $scope.rowCollectionItem.push(data[i]);
                            ngDialog.close();
                        }

                    }
                }

            } else {
                logger.logError("Please Select Atleast One Row!");
            }

        };

        $scope.validate = function(itemCategoryAddForm, itemCategoryObj, itemDetail) {
            if (new validationService().checkFormValidity($scope.itemCategoryAddForm)) {
                if ($scope.isEdit) {
                    $scope.update(itemCategoryAddForm, itemCategoryObj, itemDetail);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.itemCategoryAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.checkCatgeoryName = function(categoryName) {
            var categoryName = categoryName;
            $scope.itemCategoryObj.categoryName = categoryName;
            if (categoryName != $scope.itemCategoryOldName) {
                $http.get('hospital/inventory/manageitemcategory/checkCategoryName?categoryName=' + categoryName).success(function(datas) {
                    if (datas != 0) {
                        logger.logError('Category Name Already Exist!');
                        $scope.itemCategoryObj.categoryName = $scope.itemCategoryOldName;
                    }

                }).error(function(datas) {
                });
            }

        }

        $scope.update = function(itemCategoryAddForm, itemCategoryObj) {

            var itemPropertiesDetail = $scope.rowCollectionItem;
            $scope.itemCategoryObj.propertyDetailList = itemPropertiesDetail;
            $scope.itemCategoryObj.deletedIds = $scope.deletedIds;
            if (itemPropertiesDetail.length > 0) {

                $http.post('hospital/inventory/manageitemcategory/update', itemCategoryObj).success(function(result) {
                    if (result == true) {
                        logger.logSuccess("Updated Successfully!");
                        $state.go('app.finance.inventory.manageitemcategory.list');
                    } else {
                        logger.logError("Not Updated!");
                    }
                });

            } else {
                logger.logError("Please Add Atleast One Item Properties!");
            }

        };

        $scope.$watch('itemCategoryObj.parentCategoryId', function(newValue, oldValue) {
            var parentCategoryId = newValue;

            if (parentCategoryId != "") {

                var myURL = 'hospital/inventory/manageitemcategory/getGrnAttributeList?parentCategoryId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : parentCategoryId,
                }).success(function(result) {

                    if (result.grnAttributeList[0].batchNo == "t") {
                        $scope.itemCategoryObj.batchNo = 'Y';
                    } else {
                        $scope.itemCategoryObj.batchNo = 'N';
                    }

                    if (result.grnAttributeList[0].mrp == "t") {
                        $scope.itemCategoryObj.mrp = 'Y';
                    } else {
                        $scope.itemCategoryObj.mrp = 'N';
                    }

                    if (result.grnAttributeList[0].expiryDate == "t") {
                        $scope.itemCategoryObj.expiryDate = 'Y';
                    } else {
                        $scope.itemCategoryObj.expiryDate = 'N';
                    }

                    if (result.grnAttributeList[0].manufactureDetails == "t") {
                        $scope.itemCategoryObj.manufactureDetails = 'Y';
                    } else {
                        $scope.itemCategoryObj.manufactureDetails = 'N';
                    }

                });

            } else {
                $scope.itemCategoryObj.batchNo = 'N';
                $scope.itemCategoryObj.manufactureDetails = 'N';
                $scope.itemCategoryObj.expiryDate = 'N';
                $scope.itemCategoryObj.mrp = 'N';
            }
        });

    });

//});