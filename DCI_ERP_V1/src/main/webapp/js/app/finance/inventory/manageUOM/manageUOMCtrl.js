//define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';

    app.controller('UOMCategoryCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.rowCollection = [];
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.isEdit = false;

        $scope.uomcategory = {
            uomId : '',
            uomcategoryId : '',
            uomcategoryName : '',
            uomcategoryDesc : '',
            status : ''
        }

        $scope.reset = function() {
            $scope.uomcategory.uomcategoryName = '';
            $scope.uomcategory.uomcategoryDesc = '';
            $scope.uomcategory.status = '';
        }

        $scope.add = function() {
            $state.go("app.finance.inventory.uomcategory.add");
        }

        $scope.cancel = function() {
            $state.go('app.finance.inventory.uomcategory.list');
        }

        $scope.editRow = function(uomId) {
            $state.go('app.finance.inventory.uomcategory.edit', {
                uomId : uomId
            });
        }

        $scope.getUomCategoryList = function() {
            $http.get('app/hospital/inventory/UOMCategory/list').success(function(response) {
                $scope.rowCollection = response.uomcategoryList;
            });
        }
        $scope.getUomCategoryList();

        $scope.deleteRow = function(id, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/hospital/inventory/UOMCategory/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : id,
                }).success(function(data) {
                    if (data.success == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted Successfully");
                        $state.reload();
                    } else {
                        logger.logError("Unable to Delete Uom Category!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });

        };

        $scope.checkCategoryName = function(uomcategoryName) {
            debugger;
            $http.get('app/hospital/inventory/UOMCategory/checkCategoryName?uomcategoryName=' + uomcategoryName).success(function(datas) {
                if (datas != 0) {
                    logger.logError('Category Name Already Exist!');
                    $scope.uomcategory.uomcategoryName = '';
                }

            }).error(function(datas) {
            });

        }

        $scope.getAutoGenarateNumber = function() {
            $http.get('app/hospital/inventory/UOMCategory/getAutoGenarateNumber').success(function(response) {
                $scope.uomcategory.uomcategoryId = response.uomcategoryId;
            });
        }
        $scope.getAutoGenarateNumber();

        $scope.submit = function(UOMCategory, uomcategory) {
            if (new validationService().checkFormValidity(UOMCategory)) {
                $scope.save(uomcategory);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.UOMCategory.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.save = function(uomcategory) {
            var jsonData = {
                'uomcategoryData' : uomcategory,
            }
            $http.post('app/hospital/inventory/UOMCategory/save', jsonData).success(function(data) {
                if (data) {
                    logger.logSuccess("UOM Category Successfully Added!");
                    $state.go('app.finance.inventory.uomcategory.list');

                } else {
                    logger.logError("Error Not Saved!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Savedd!");
            });

        }

    });

    app.controller('UOMCategoryEditCtrl', function($scope, $state, $stateParams, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService) {

        $scope.isEdit = true;
        var uomId = parseInt($stateParams.uomId);

        $scope.uomcategory = {
            uomId : '',
            uomcategoryId : '',
            uomcategoryName : '',
            uomcategoryDesc : '',
            status : ''
        }

        $scope.uomCategoryOldName = '';

        $scope.cancel = function() {
            $state.go('app.finance.inventory.uomcategory.list');
        }

        var url = 'app/hospital/inventory/UOMCategory/uomCategoryEditList?uomId=' + uomId;
        $http.get(url).success(function(result) {
            $scope.uomcategory.uomId = result.uomId;
            $scope.uomcategory.uomcategoryId = result.uomcategoryId;
            $scope.uomcategory.uomcategoryName = result.uomcategoryName;
            $scope.uomcategory.uomcategoryDesc = result.uomcategoryDesc;
            $scope.uomcategory.status = result.status;
        });

        $scope.reset = function() {
            var url = 'app/hospital/inventory/UOMCategory/uomCategoryEditList?uomId=' + uomId;
            $http.get(url).success(function(result) {
                $scope.uomcategory.uomId = result.uomId;
                $scope.uomcategory.uomcategoryId = result.uomcategoryId;
                $scope.uomcategory.uomcategoryName = result.uomcategoryName;
                $scope.uomcategory.uomcategoryDesc = result.uomcategoryDesc;
                $scope.uomcategory.status = result.status;
                $scope.uomCategoryOldName = result.uomcategoryName;
            });
        };

        $scope.checkCategoryName = function(uomcategoryName) {
            var categoryName = categoryName;
            $scope.uomcategory.uomcategoryName = categoryName;
            if (categoryName != $scope.uomCategoryOldName) {
                $http.get('app/hospital/inventory/UOMCategory/checkCategoryName?uomcategoryName=' + uomcategoryName).success(function(datas) {
                    if (datas != 0) {
                        logger.logError('Category Name Already Exist!');
                        $scope.itemCategoryObj.categoryName = $scope.itemCategoryOldName;
                    }
                }).error(function(datas) {
                });
            }

        }

        $scope.submit = function(UOMCategory, uomcategory) {
            if (new validationService().checkFormValidity(UOMCategory)) {
                $scope.update(uomcategory);
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.UOMCategory.$validationSummary), 5000, 'trustedHtml');
            }
        };

        $scope.update = function(uomcategory) {
            var jsonData = {
                'uomcategoryData' : uomcategory,
            }
            $http.post('app/hospital/inventory/UOMCategory/update', jsonData).success(function(data) {
                if (data) {
                    logger.logSuccess("UOM Category Successfully Updated!");
                    $state.go('app.finance.inventory.uomcategory.list');

                } else {
                    logger.logError("Error Not Updated!");
                }
            }).error(function(data) {
                logger.logSuccess("Error Not Updated!");
            });

        }

    });

//});