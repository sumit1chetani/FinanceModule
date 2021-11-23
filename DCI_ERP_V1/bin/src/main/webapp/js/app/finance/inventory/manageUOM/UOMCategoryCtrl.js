//define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

    app.controller('manageUmCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.numPages = 0;
        $scope.getList = function() {
            $http.get("app/hospital/inventory/manageUOM/list").success(function(response) {
                $scope.rowCollection = response.manageUOMList;
            });
        };
        $scope.getList();

        $scope.add = function() {
            $scope.callDialog($scope, 0, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };
        $scope.editRow = function(manageUomData) {
            $scope.callDialog($scope, manageUomData.uomId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope);
        };
        $scope.deleteRow = function(manageUomData) {
            ngDialog.openConfirm().then(function() {
                $http.post("app/hospital/inventory/manageUOM/delete", manageUomData.uomId).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getList();
                    } else {
                        logger.logError("Unable to delete");
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

        $scope.callDialog = function($scope, uomId, $http, ngDialog, logger, $injector, sharedProperties, toaster, $rootScope, validationService) {
            ngDialog.open({
                scope : $scope,
                template : 'views/finance/inventory/manageUOM/manageUOMAdd',
                controller : $controller('manageUOMAddCtrl', {
                    $scope : $scope,
                    uomId : uomId,
                    $http : $http,
                    ngDialog : ngDialog,
                    logger : logger,
                    $injector : $injector,
                    sharedProperties : sharedProperties,
                    toaster : toaster,
                    $rootScope : $rootScope,

                }),
                className : 'ngdialog-theme-plain',
                showClose : false,
                closeByDocument : false,
                closeByEscape : false,
                preCloseCallback : $scope.getList
            });
        }
    });
    app.controller('manageUOMAddCtrl', function($scope, $http, ngDialog, logger, uomId, $injector, sharedProperties, toaster, validationService, $location, $rootScope) {

        $scope.isEdit = false;
        $scope.uomOldName = '';

        $scope.manageUomData = {
            uomId : '',
            uomName : '',
            uomDescription : '',
            uomCategoryId : ''
        };

        $scope.uomCategoryList = [];

        $http.get("app/hospital/inventory/manageUOM/uomCategList").success(function(datas) {
            $scope.uomCategoryList = datas.uomCategoryList;
        });

        $scope.checkUOMName = function(uomName) {
            if (!$scope.isEdit) {
                $http.get('app/hospital/inventory/manageUOM/checkUOMName?uomName=' + uomName).success(function(datas) {
                    if (datas != 0) {
                        logger.logError('UOM Already Exist!');
                        $scope.manageUomData.uomName = '';
                    }
                }).error(function(datas) {
                });
            } else {
                if (uomName != $scope.uomOldName) {
                    $http.get('app/hospital/inventory/manageUOM/checkUOMName?uomName=' + uomName).success(function(datas) {
                        if (datas != 0) {
                            logger.logError('UOM Already Exist!');
                            $scope.manageUomData.uomName = '';
                        }
                    }).error(function(datas) {
                    });
                }
            }
        };

        $scope.validate = function(ManageUoMForm) {
            if (new validationService().checkFormValidity(ManageUoMForm)) {
                if (!$scope.isEdit) {
                    $scope.save(ManageUoMForm);
                } else {
                    $scope.update(ManageUoMForm);
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew(ManageUoMForm.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.cancel = function() {
            ngDialog.close();
        };
        $scope.tempManageUomData = [];
        if (uomId != 0) {
            $scope.isEdit = true;
            $http.post("app/hospital/inventory/manageUOM/edit", uomId).success(function(response) {
                if (response.success == true) {

                    $scope.manageUomData.uomId = response.manageUOM.uomId;
                    $scope.manageUomData.uomName = response.manageUOM.uomName;
                    $scope.manageUomData.uomDescription = response.manageUOM.uomDescription;
                    $scope.uomOldName = response.manageUOM.uomName;

                    if (response.manageUOM.uomCategoryId == 0) {
                        $scope.manageUomData.uomCategoryId = '';
                    } else {
                        $scope.manageUomData.uomCategoryId = response.manageUOM.uomCategoryId;
                    }

                    $scope.tempManageUomData = response.manageUOM;
                }
            });
        }
        // Save
        $scope.save = function(manageUoMForm) {
            sharedProperties.clearObject();
            $http.post("app/hospital/inventory/manageUOM/save", $scope.manageUomData).success(function(response) {
                if (response) {
                    logger.logSuccess("Saved Successfully");
                    ngDialog.close();
                } else {
                    logger.logError("Not Saved!");
                }
            });
        };

        $scope.update = function(manageUoMForm) {
            sharedProperties.clearObject();
            $http.post("app/hospital/inventory/manageUOM/update", $scope.manageUomData).success(function(response) {
                if (response) {
                    logger.logSuccess("Updated Successfully!");
                    ngDialog.close();
                } else {
                    logger.logError("Not Updated!");
                }
            });
        };

        $scope.reset = function(manageUoMForm) {
            $scope.manageUomData = {
                uomId : '',
                uomName : '',
                uomDescription : '',
                uomCategoryId : ''
            }
        };
        $scope.resetEdit = function(manageUoMForm) {
            $http.post("app/hospital/inventory/manageUOM/edit", uomId).success(function(response) {
                if (response.success == true) {

                    $scope.manageUomData.uomName = response.manageUOM.uomName;
                    $scope.manageUomData.uomDescription = response.manageUOM.uomDescription;
                    $scope.uomOldName = response.manageUOM.uomName;

                    if (response.manageUOM.uomCategoryId == 0) {
                        $scope.manageUomData.uomCategoryId = '';
                    } else {
                        $scope.manageUomData.uomCategoryId = response.manageUOM.uomCategoryId;
                    }

                    $scope.tempManageUomData = response.manageUOM;
                }
            });
        };
    });
//});