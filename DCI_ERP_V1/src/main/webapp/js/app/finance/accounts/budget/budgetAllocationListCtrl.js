//define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    app.controller('budgetAllocationListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.getBudgetListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/budget/allocationList';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.pushListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lBudgetAllocationBean)) {
                $scope.showEmptyLabel = true;
            } else {
                $scope.rowCollection = $scope.rowCollection.concat(data.lBudgetAllocationBean);
            }
        };

        $scope.getBudgetListUtil();

        $scope.add = function() {
            $state.go("app.hospital.accounts.budgetAllocation.add");
        };

        $scope.editAllocation = function(allocationId) {
            $location.url('/hospital/accounts/budgetAllocation/add?allocationId=' + allocationId);
        };

        $scope.viewAllocation = function(allocationId) {
            $location.url('/hospital/accounts/budgetAllocation/view?allocationId=' + allocationId);
        };

        $scope.deleteAllocation = function(collections, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/budget/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : collections,
                }).success(function(data) {
                    if (data.success) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });
        };

    });

    app.controller('budgetApprovalListCtrl', function($scope,$stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, utilsService) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        $scope.isDelete = true;
        $scope.isAdd = true;

        $scope.getBudgetListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/budget/allocationList';
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.pushListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.pushListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lBudgetAllocationBean)) {
                $scope.showEmptyLabel = true;
            } else {
                $scope.rowCollection = $scope.rowCollection.concat(data.lBudgetAllocationBean);
            }
        };

        $scope.getBudgetListUtil();

        $scope.editAllocation = function(allocationId) {
            $location.url($stateParams.tenantid+'/hospital/accounts/approval/add?allocationId=' + allocationId);
        };

        $scope.viewAllocation = function(allocationId) {
            $location.url($stateParams.tenantid+'/hospital/accounts/budgetAllocation/view?allocationId=' + allocationId);
        };

        $scope.deleteAllocation = function(collections, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'app/budget/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : collections,
                }).success(function(data) {
                    if (data.success) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });
        };

    });

//});