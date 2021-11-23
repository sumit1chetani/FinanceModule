/*define([ 'hospital/inventory/inventory' ], function(module) {
    'use strict';
    module.registerController('stockTransferReceiveCtrl', function($scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope) {*/
    
    app.controller('stockTransferReceiveCtrl', function($scope, $state, $window, $rootScope, $location, $http, logger, $log, ngDialog, $modal, utilsService) {
    
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;
        $scope.isDelete = true;

        $scope.add = function() {
            $state.go('app.finance.inventory.stockTransferReceive.add');
        }

        $scope.viewRow = function(receivedId) {

            $location.url('hospital/inventory/stockTransferReceive/view?receivedId=' + receivedId);
        };

        $scope.getList = function() {
            var url = 'hospital/inventory/transferReceive/getList?transferType=stock&limit=' + $scope.limitCount + '&offset=' + $scope.offsetCount;
            $http.get(url).success(function(data) {
                if (data.success == true) {
                    $scope.rowCollection = data.transferBeanList;
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            $scope.offsetCount = $scope.offsetCount + $scope.limitCount;

        }
        $scope.getList();

    });
