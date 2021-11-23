//define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';

    app.controller('manageLocationListCtrl', function($scope, $state,$stateParams, $http, $location, ngDialog, logger) {

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.numPages = 0;

        $scope.editRow = function(manageLocationList) {
            $location.url($stateParams.tenantid +'/finance/asset/managelocation/edit?locationId=' + manageLocationList.locationId);
        };

        $scope.getList = function() {

            $http.get("his/inventory/settings/managelocation/list").success(function(response) {
                $scope.rowCollection = response.manageLocationList;
            });
        };
        $scope.getList();

        $scope.deleteRow = function(locationId, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'his/inventory/settings/managelocation/delete?locationId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : locationId,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.go("app.finance.asset.manage.managelocation.list");
                    } else {
                        logger.logError("Unable to Delete Manage Location!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });

        };

        $scope.add = function() {
            $state.go("app.finance.asset.manage.managelocation.add");
        };

        $scope.chkAll = false;
        $scope.checkAll = function(rowCollection, checkBox) {
            if (checkBox) {
                $scope.chkAll = true;
            } else {
                $scope.chkAll = false;
            }

            angular.forEach($scope.rowCollection, function(location) {
                location.select = $scope.chkAll;
            });

        };

        $scope.chkSelected = false;
        $scope.checkSelected = function(chkLocation, locationId) {
            if (chkLocation == true) {
                /*
                 * angular.forEach($scope.rowCollection, function (location) {
                 * if(locationId==location.locationId){ location.select = true;
                 * }else{ location.select = false; } });
                 */
                location.select = true;
            } else {
                /*
                 * angular.forEach($scope.rowCollection, function (location) {
                 * location.select = false; });
                 */
                location.select = false;
            }
        };

        // Multi Delete Functionality
        $scope.deleteSelected = function() {
            var isDelete = false;
            angular.forEach($scope.rowCollection, function(location) {
                if (location.select == true) {
                    isDelete = true;
                }
            });

            if (isDelete == false) {
                logger.logError("Please Select Atleast One Row!");
            } else {
                ngDialog.openConfirm().then(function() {
                    $http.post('his/inventory/settings/managelocation/multiDelete', $scope.rowCollection).success(function(data) {
                        if (data.message != "") {
                            var tableData = $scope.rowCollection;
                            logger.logSuccess(data.message);
                            $state.go("app.finance.asset.manage.managelocation.list");
                            $scope.getList();
                        } else {
                            logger.logError("Unable to Delete Manage Location!");
                        }
                    }).error(function(result) {
                    });
                });
            }
        };

    });

//});