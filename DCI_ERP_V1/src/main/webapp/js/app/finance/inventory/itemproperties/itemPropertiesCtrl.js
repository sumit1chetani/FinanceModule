//define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

    app.controller('itemPropertiesListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.numPages = 0;

        $scope.add = function() {
            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.getList = function() {
            $http.get("his/inventory/settings/itemproperties/list").success(function(response) {
                $scope.rowCollection = response.itemPropertiesBeanList;
            });
        };

        $scope.getList();

        $scope.editRow = function(itemPropertiesId) {
            $scope.callDialog($scope, itemPropertiesId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };

        $scope.callDialog = function($scope, itemPropertiesId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/itemproperties/itemPropertiesAdd',
                controller : $controller('itemPropertiesAddCtrl', {
                    $scope : $scope,
                    itemPropertiesId : itemPropertiesId,
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
        };

        $scope.deleteRow = function(itemPropertiesId, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'his/inventory/settings/itemproperties/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : itemPropertiesId,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Item Properties!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });

        };

    });

    app.controller('itemPropertiesAddCtrl', function($scope, $state, $http, ngDialog, itemPropertiesId, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.itemsByPage = 10;
        $scope.propertyList = [];
        $scope.typeList = [];

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
            typeName : ''
        };

        $http.get('hospital/inventory/manageitemcategory/getPropertyList').success(function(datas) {
            $scope.propertyList = datas.propertyList;
        });

        $http.get('his/inventory/settings/itemproperties/getTypeList').success(function(datas) {
            $scope.typeList = datas.typeList;
        });

        $scope.reset = function(itemPropertiesAddForm) {
            $scope.itemPropertiesObj.propertyTypeId = '';
            $scope.itemPropertiesObj.propName = '';
            $scope.itemPropertiesObj.propLength = '';
            $scope.itemPropertiesObj.propValue = '';
            $scope.itemPropertiesObj.defaultValSingleDropProp = '';
            $scope.itemPropertiesObj.manditory = 'N';

            $scope.itemPropertiesObj.dateName = '';
            $scope.itemPropertiesObj.lengthValue = '';
            $scope.itemPropertiesObj.defaultsValue = '';
            $scope.itemPropertiesObj.defaultValueList = '';
            $scope.itemPropertiesObj.decimalValue = '';
            $scope.itemPropertiesObj.typeId = '';
            $scope.itemPropertiesObj.typeName = '';
            $scope.getDefaultValues($scope.itemPropertiesObj.propertyTypeId);
        };

        $scope.getDefaultValues = function(propertyTypeId) {
            if (propertyTypeId == '75') {
                $("#lengthProp").show();
                $("#mandiVal").show();
                $("#defaultDropDownProp").hide();
                $("#valProp").hide();
                $("#dateDisplay").hide();
                $("#defaultProp").show();
                $("#nameProp").show();
                $("#nameNumProp").hide();
                $("#dateDefDisplay").hide();
                $("#numberDisplays").hide();
                $("#numberDisplay").hide();
                $("#decimalvalProp").hide();
                $("#decimalvalProps").hide();
                $("#decimalvalPropes").hide();
            } else if (propertyTypeId == '76') {
                $("#lengthProp").show();
                $("#mandiVal").show();
                $("#defaultDropDownProp").hide();
                $("#valProp").hide();
                $("#dateDisplay").hide();
                $("#defaultProp").show();
                $("#nameProp").show();
                $("#dateDefDisplay").hide();
                $("#numberDisplays").hide();
                $("#numberDisplay").hide();
                $("#decimalvalProp").hide();
                $("#nameNumProp").hide();
                $("#decimalvalProps").hide();
                $("#decimalvalPropes").hide();
            } else if (propertyTypeId == '77') {
                $("#valProp").show();
                $("#mandiVal").show();
                $("#defaultProp").hide();
                $("#lengthProp").hide();
                $("#dateDisplay").hide();
                $("#defaultDropDownProp").show();
                $("#nameProp").show();
                $("#nameNumProp").hide();
                $("#dateDefDisplay").hide();
                $("#numberDisplays").hide();
                $("#numberDisplay").hide();
                $("#decimalvalProp").hide();
                $("#decimalvalProps").hide();
                $("#decimalvalPropes").hide();
            } else if (propertyTypeId == '78') {
                $("#valProp").show();
                $("#mandiVal").show();
                $("#defaultProp").hide();
                $("#lengthProp").hide();
                $("#dateDisplay").hide();
                $("#defaultDropDownProp").show();
                $("#nameProp").show();
                $("#dateDefDisplay").hide();
                $("#nameNumProp").hide();
                $("#numberDisplays").hide();
                $("#numberDisplay").hide();
                $("#decimalvalProp").hide();
                $("#decimalvalProps").hide();
                $("#decimalvalPropes").hide();
            } else if (propertyTypeId == '79') {
                $("#valProp").show();
                $("#mandiVal").show();
                $("#defaultProp").hide();
                $("#lengthProp").hide();
                $("#dateDisplay").hide();
                $("#defaultDropDownProp").show();
                $("#nameProp").show();
                $("#dateDefDisplay").hide();
                $("#numberDisplays").hide();
                $("#numberDisplay").hide();
                $("#decimalvalProp").hide();
                $("#decimalvalProps").hide();
                $("#decimalvalPropes").hide();
                $("#nameNumProp").hide();
            } else if (propertyTypeId == '80') {
                $("#valProp").hide();
                $("#mandiVal").hide();
                $("#defaultProp").hide();
                $("#lengthProp").hide();
                $("#defaultDropDownProp").hide();
                $("#nameProp").hide();
                $("#nameProps").show();
                $("#dateDisplay").show();
                $("#nameNumProp").hide();
                $("#dateDefDisplay").show();
                $("#numberDisplays").hide();
                $("#numberDisplay").hide();
                $("#decimalvalProp").hide();
                $("#decimalvalProps").hide();
                $("#decimalvalPropes").hide();
            } else if (propertyTypeId == '81') {
                $("#valProp").hide();
                $("#mandiVal").hide();
                $("#defaultProp").hide();
                $("#lengthProp").hide();
                $("#dateDefDisplay").hide();
                $("#defaultDropDownProp").hide();
                $("#nameProp").hide();
                $("#dateDisplay").hide();
                $("#nameNumProp").show();
                $("#numberDisplays").show();
                $("#numberDisplay").show();
                $("#decimalvalProp").show();
                $("#decimalvalProps").show();
                $("#decimalvalPropes").show();
            } else if (propertyTypeId == 'null') {
                $("#valProp").hide();
                $("#lengthProp").hide();
                $("#mandiVal").hide();
                $("#defaultProp").hide();
                $("#nameProp").hide();
                $("#nameNumProp").hide();
                $("#defaultDropDownProp").hide();
                $("#dateDisplay").hide();
                $("#dateDefDisplay").hide();
                $("#numberDisplays").hide();
                $("#numberDisplay").hide();
                $("#decimalvalProp").hide();
                $("#decimalvalProps").hide();
                $("#decimalvalPropes").hide();

            } else {
                $("#valProp").hide();
                $("#lengthProp").hide();
                $("#mandiVal").hide();
                $("#defaultProp").hide();
                $("#nameProp").hide();
                $("#defaultDropDownProp").hide();
                $("#dateDisplay").hide();
                $("#dateDefDisplay").hide();
                $("#numberDisplays").hide();
                $("#numberDisplay").hide();
                $("#decimalvalProp").hide();
                $("#decimalvalProps").hide();
                $("#decimalvalPropes").hide();
                $("#nameNumProp").hide();

            }
        };

        $scope.cancel = function() {
            $state.go("app.finance.inventory.itemproperties.list");
            ngDialog.close();
        };

        if (itemPropertiesId != 0) {
            $scope.isEdit = true;

            var url = 'his/inventory/settings/itemproperties/edit?itemPropertiesId=' + itemPropertiesId;
            $http.get(url).success(function(result) {

                $scope.itemPropertiesObj.propertyTypeId = result.propertyTypeId;

                if ($scope.itemPropertiesObj.propertyTypeId == '75') {
                    $("#lengthProp").show();
                    $("#mandiVal").show();
                    $("#defaultDropDownProp").hide();
                    $("#valProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultProp").show();
                    $("#nameProp").show();
                    $("#nameNumProp").hide();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '76') {
                    $("#lengthProp").show();
                    $("#mandiVal").show();
                    $("#defaultDropDownProp").hide();
                    $("#valProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultProp").show();
                    $("#nameProp").show();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#nameNumProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '77') {
                    $("#valProp").show();
                    $("#mandiVal").show();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultDropDownProp").show();
                    $("#nameProp").show();
                    $("#nameNumProp").hide();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '78') {
                    $("#valProp").show();
                    $("#mandiVal").show();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultDropDownProp").show();
                    $("#nameProp").show();
                    $("#dateDefDisplay").hide();
                    $("#nameNumProp").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '79') {
                    $("#valProp").show();
                    $("#mandiVal").show();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultDropDownProp").show();
                    $("#nameProp").show();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                    $("#nameNumProp").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '80') {
                    $("#valProp").hide();
                    $("#mandiVal").hide();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#defaultDropDownProp").hide();
                    $("#nameProp").hide();
                    $("#nameProps").show();
                    $("#dateDisplay").show();
                    $("#nameNumProp").hide();
                    $("#dateDefDisplay").show();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '81') {
                    $("#valProp").hide();
                    $("#mandiVal").hide();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#dateDefDisplay").hide();
                    $("#defaultDropDownProp").hide();
                    $("#nameProp").hide();
                    $("#dateDisplay").hide();
                    $("#nameNumProp").show();
                    $("#numberDisplays").show();
                    $("#numberDisplay").show();
                    $("#decimalvalProp").show();
                    $("#decimalvalProps").show();
                    $("#decimalvalPropes").show();
                } else if ($scope.itemPropertiesObj.propertyTypeId == 'null') {
                    $("#valProp").hide();
                    $("#lengthProp").hide();
                    $("#mandiVal").hide();
                    $("#defaultProp").hide();
                    $("#nameProp").hide();
                    $("#nameNumProp").hide();
                    $("#defaultDropDownProp").hide();
                    $("#dateDisplay").hide();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();

                }

                $scope.itemPropertiesObj.propName = result.propName;
                $scope.itemPropertiesObj.propLength = result.propLength;
                $scope.itemPropertiesObj.propValue = result.propValue;
                $scope.itemPropertiesObj.manditory = result.manditory;
                $scope.itemPropertiesObj.dateName = result.dateName;
                $scope.itemPropertiesObj.lengthValue = result.lengthValue;
                $scope.itemPropertiesObj.decimalValue = result.decimalValue;
                $scope.itemPropertiesObj.defaultsValue = result.defaultsValue;
                $scope.itemPropertiesObj.typeId = result.typeId;
                $scope.itemPropertiesObj.typeName = result.typeName;
                $scope.itemPropertiesObj.itemPropertiesId = result.itemPropertiesId;

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        }
        ;

        $scope.reset = function(itemPropertiesAddForm) {
            $scope.isEdit = true;
            var url = 'his/inventory/settings/itemproperties/edit?itemPropertiesId=' + itemPropertiesId;
            $http.get(url).success(function(result) {
                $scope.itemPropertiesObj.propertyTypeId = result.propertyTypeId;
                if ($scope.itemPropertiesObj.propertyTypeId == '75') {
                    $("#lengthProp").show();
                    $("#mandiVal").show();
                    $("#defaultDropDownProp").hide();
                    $("#valProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultProp").show();
                    $("#nameProp").show();
                    $("#nameNumProp").hide();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '76') {
                    $("#lengthProp").show();
                    $("#mandiVal").show();
                    $("#defaultDropDownProp").hide();
                    $("#valProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultProp").show();
                    $("#nameProp").show();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#nameNumProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '77') {
                    $("#valProp").show();
                    $("#mandiVal").show();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultDropDownProp").show();
                    $("#nameProp").show();
                    $("#nameNumProp").hide();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '78') {
                    $("#valProp").show();
                    $("#mandiVal").show();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultDropDownProp").show();
                    $("#nameProp").show();
                    $("#dateDefDisplay").hide();
                    $("#nameNumProp").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '79') {
                    $("#valProp").show();
                    $("#mandiVal").show();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#dateDisplay").hide();
                    $("#defaultDropDownProp").show();
                    $("#nameProp").show();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                    $("#nameNumProp").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '80') {
                    $("#valProp").hide();
                    $("#mandiVal").hide();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#defaultDropDownProp").hide();
                    $("#nameProp").hide();
                    $("#nameProps").show();
                    $("#dateDisplay").show();
                    $("#nameNumProp").hide();
                    $("#dateDefDisplay").show();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();
                } else if ($scope.itemPropertiesObj.propertyTypeId == '81') {
                    $("#valProp").hide();
                    $("#mandiVal").hide();
                    $("#defaultProp").hide();
                    $("#lengthProp").hide();
                    $("#dateDefDisplay").hide();
                    $("#defaultDropDownProp").hide();
                    $("#nameProp").hide();
                    $("#dateDisplay").hide();
                    $("#nameNumProp").show();
                    $("#numberDisplays").show();
                    $("#numberDisplay").show();
                    $("#decimalvalProp").show();
                    $("#decimalvalProps").show();
                    $("#decimalvalPropes").show();
                } else if ($scope.itemPropertiesObj.propertyTypeId == 'null') {
                    $("#valProp").hide();
                    $("#lengthProp").hide();
                    $("#mandiVal").hide();
                    $("#defaultProp").hide();
                    $("#nameProp").hide();
                    $("#nameNumProp").hide();
                    $("#defaultDropDownProp").hide();
                    $("#dateDisplay").hide();
                    $("#dateDefDisplay").hide();
                    $("#numberDisplays").hide();
                    $("#numberDisplay").hide();
                    $("#decimalvalProp").hide();
                    $("#decimalvalProps").hide();
                    $("#decimalvalPropes").hide();

                }

                $scope.itemPropertiesObj.propName = result.propName;
                $scope.itemPropertiesObj.propLength = result.propLength;
                $scope.itemPropertiesObj.propValue = result.propValue;
                $scope.itemPropertiesObj.manditory = result.manditory;
                $scope.itemPropertiesObj.dateName = result.dateName;
                $scope.itemPropertiesObj.lengthValue = result.lengthValue;
                $scope.itemPropertiesObj.decimalValue = result.decimalValue;
                $scope.itemPropertiesObj.defaultsValue = result.defaultsValue;
                $scope.itemPropertiesObj.typeId = result.typeId;
                $scope.itemPropertiesObj.typeName = result.typeName;
                $scope.itemPropertiesObj.itemPropertiesId = result.itemPropertiesId;

            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });

        };

        $scope.validate = function(itemPropertiesAddForm, itemPropertiesObj) {
            if (new validationService().checkFormValidity(itemPropertiesAddForm)) {
                if (!$scope.isEdit) {
                    $scope.save(itemPropertiesObj, itemPropertiesAddForm);
                } else {
                    $scope.update(itemPropertiesObj, itemPropertiesAddForm);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(itemPropertiesAddForm.$validationSummary), 555000, 'trustedHtml');
            }
        };

        $scope.save = function(itemPropertiesObj, itemPropertiesAddForm) {
            var addRowData = $scope.itemPropertiesObj;
            $http.post("his/inventory/settings/itemproperties/add", $scope.itemPropertiesObj).success(function(response) {
                if (response) {
                    logger.logSuccess("Saved Successfully!");
                    ngDialog.close();
                    $state.go('app.finance.inventory.itemproperties.list');
                    $state.reload();
                } else {
                    logger.logError(response.message);
                }
            });
        }

        $scope.update = function(itemPropertiesObj, itemPropertiesAddForm) {
            var addRowData = $scope.itemPropertiesObj;
            $http.post("his/inventory/settings/itemproperties/update", $scope.itemPropertiesObj).success(function(response) {
                if (response) {
                    logger.logSuccess("Updated Successfully!");
                    ngDialog.close();
                    $state.go('app.finance.inventory.itemproperties.list');
                    $state.reload();
                } else {
                    logger.logError(response.message);
                }
            });
        }
    });

//});