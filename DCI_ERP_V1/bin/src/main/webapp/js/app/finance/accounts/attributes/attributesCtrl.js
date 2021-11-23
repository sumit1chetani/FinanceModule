//define([ 'hospital/accounts/accounts' ], function(module) {

   // 'use strict';

    app.controller('attributesListCtrl', function($scope, $state,$stateParams, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, $window) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isDelete = true;

        $scope.isUpload = true;
        $scope.getAttributesList = function() {
            var url = 'app/attributesNew/list';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = data.lAttributeList;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.getAttributesList();

        $scope.add = function() {
            $state.go('app.finance.accounts.attributes.add');
        };

        // Edit functionality
        $scope.editRow = function(collection) {
            $location.url($stateParams.tenantid+'/hospital/accounts/attributes/add?attribute=' + collection.attributeName);
        };

        // Delete functionality
        $scope.deleteRow = function(collection) {
            ngDialog.openConfirm().then(function() {
                $http.post("app/attributesNew/delete", collection.attributeName).success(function(response) {
                    if (response.success) {
                        logger.logSuccess("Deleted Successfully!");
                        $scope.getAttributesList();
                    } else
                        logger.logError("You can't delete this record,Deletion Failed");
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

    });

    app.controller('attributesAddCtrl', function($scope, $state, $http, $injector, $location, ngDialog, logger, sharedProperties, toaster, $rootScope, validationService) {

        $scope.isEdit = false;
        $scope.attribute = {
            attributeId : '',
            attributeName : '',
            attributeValue : ''
        }

        $scope.save = function() {
            if (new validationService().checkFormValidity($scope.attributeForm)) {
                if ($scope.isEdit == false) {
                    $http.post('app/attributesNew/save', $scope.attribute).success(function(data) {
                        if (data == true) {
                            logger.logSuccess("Created Successfully!");
                            $scope.cancel();
                        } else {
                            logger.logError("Attribute Name Already Exist");
                        }

                    }).error(function(data) {
                    });
                } else {
                    $http.post('app/attributesNew/update', $scope.attribute).success(function(data) {
                        if (data == true) {
                            logger.logSuccess("Updated Successfully!");
                            $scope.cancel();
                        } else {
                            logger.logError("Unable to Update");
                        }
                    }).error(function(data) {
                    });
                }
            } else {
                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.attributeForm.$validationSummary), 555000, 'trustedHtml');
            }
        }

        // cancel Functionality
        $scope.cancel = function() {
            $state.go('app.finance.accounts.attributes.list');
        };

        // Edit functionality
        var attribute = $location.search().attribute;
        if (attribute == undefined || attribute == null || attribute == "") {
            $scope.isEdit = false;
        } else {
            $scope.isEdit = true;
            $http.post("app/attributesNew/edit", attribute).success(function(response) {
                if (response) {
                    $scope.attribute = response.attributeEdit;
                }

            }).error(function(data) {
                logger.logError("Unable to fetch");
            });

        }

    //});
});