define([ 'hospital/inventory/inventory' ], function(module) {

    'use strict';
    module.registerController('inventoryListBelowROLCtrl', function($scope, $state, $http, ngDialog, logger, $location, 
            $controller, $injector, sharedProperties, toaster, $rootScope,utilsService) {

        $scope.dataLoopCount = 0;
        $scope.from = 0;
        $scope.to = 100;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.isUpload = true;
        
        $scope.getInventoryListUtil = function(limit, offset) {
            var start = new Date().getTime();
            var url = 'app/inventoryRprt/invlistBelowROL';
            $http.get(url).success(function(data) {
                console.log("data::::::::::getInventoryListUtil:::::::::");
                console.log(data);
                if (data.success == true) {
                    $scope.pushInventoryListUtil(data);
                    $scope.dataLoopCount++;
                } else {
                    if ($scope.dataLoopCount == 0) {
                        $scope.showEmptyLabel = true;
                    }
                    logger.logError("Error Please Try Again");
                }
                var end = new Date().getTime();
                var time = end - start;
                console.log('Execution time: ' + time);
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });

        };
        $scope.pushInventoryListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.inventoryMasterList)) {

                $scope.showEmptyLabel = true;

            } else {

                $scope.rowCollection = $scope.rowCollection.concat(data.inventoryMasterList);

            }
        };

        $scope.getInventoryListUtil();
        
    });

});