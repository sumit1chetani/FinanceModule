define([ 'hospital/accounts/accounts' ], function(module) {

    'use strict';
    module.registerController('salesorderListCtrl', function($scope, $rootScope, $http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state) {

        $scope.pageCounters = [ 10, 25, 50, 100 ];

        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.initial = {};
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.add = function() {
            $state.go("app.hospital.accounts.salesorder.add");
        }

        $scope.editRow = function(collections) {

            if (collections.status == "Pending") {
                $location.path("/hospital/accounts/salesorder/edit/" + collections.salesOrderId);
            } else {
                logger.logError("Cannot Edit Issued Record!");
            }

        }

        $scope.getSalesOrderList = function() {
            $http.get('app/salesorder/list').success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.salesOrderBeanList);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        $scope.getSalesOrderList();

        $scope.deleteSalesOrder = function(collections, index) {
            if (collections.status == "Pending") {
                ngDialog.openConfirm().then(function() {
                    $http.get('app/salesorder/delete?salesOrderId=' + collections.salesOrderId).success(function(data) {
                        if (data.success == true) {
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
            } else {
                logger.logError("Cannot Delete Issued Record!");
            }

        };

    });
});