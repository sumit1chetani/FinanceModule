define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';
    module.registerController('assetTransferListCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
       
        $scope.add = function() {
            $state.go('app.hospital.asset.assettransfer.add');
        }


        $scope.editRow = function(assetTransferId) {
            
            $state.go('app.hospital.asset.assettransfer.edit',({ 'assetTransferId': assetTransferId}));
        }
        
        $scope.viewRow = function(assetTransferId){
            $state.go('app.hospital.asset.assettransfer.view',({ 'assetTransferId': assetTransferId}));
        };

        $scope.getList = function() {
            $http.get("hospital/asset/assettransfer/getList").success(function(response) {
                $scope.rowCollection = response.assetTransferBeanl;
            });

        }
        $scope.getList();

        $scope.deleteRow = function(row) {
            ngDialog.openConfirm().then(function() {
                $http.post("hospital/asset/assettransfer/delete", row.id).success(function(response) {
                    if (response.success == true) {
                        logger.logSuccess("Deleted successfully!");
                        $scope.getList();
                    }
                }).error(function(result) {
                    logger.logError("Error Please Try Again");
                });
            });
        };

    });
});