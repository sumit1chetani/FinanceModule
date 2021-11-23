//define([ 'hospital/accounts/accounts' ], function(module) {
  //  'use strict';
    app.controller('manageCostCenterListCtrl', function($scope,$stateParams, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.isDelete = true;
        $scope.isUpload = true;

        $scope.getList = function() {

            $http.get("hospital/accounts/manageCostCenter/list").success(function(response) {
                $scope.rowCollection = response.manageCostCenterList;
            });
        }
        $scope.getList();

        $scope.editRow = function(costCenterId) {

            $location.url($stateParams.tenantid+'/hospital/accounts/manageCostCenter/edit?costCenterId=' + costCenterId);
        }

        $scope.cancel = function() {
            $state.go('app.finance.accounts.manageCostCenter.list');
        };
        $scope.add = function() {
            $state.go('app.finance.accounts.manageCostCenter.add');
        };

        $scope.deleteRow = function(costCenterId) {

            ngDialog.openConfirm().then(function() {
                $http.post("hospital/accounts/manageCostCenter/delete", costCenterId).success(function(response) {
                    logger.logSuccess("Deleted Successfully!");
                    $scope.getList();
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

    })
//});