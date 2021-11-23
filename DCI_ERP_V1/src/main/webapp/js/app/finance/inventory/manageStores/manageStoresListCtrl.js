//define([ 'hospital/inventory/inventory' ], function(module) {

'use strict';

    app.controller('manageStoresListCtrl', function($scope,$stateParams,$state,$http,$location,ngDialog,logger) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isUpload = true;

        $scope.numPages=0;
        
        $scope.editRow = function(manageStoresList) {
            $location.url($stateParams.tenantid +'/hospital/inventory/managestores/edit?locationId='+ manageStoresList.locationId);
        };

        $scope.getList = function() {
            $http.get("his/inventory/settings/managestores/list").success(function(response) {
                $scope.rowCollection = response.manageStoresList;
            });
        };
        
        $scope.getList();
        
        $scope.deleteRow = function(locationId,index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'his/inventory/settings/managestores/delete?locationId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : locationId,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.go("app.hospital.inventory.manageStores.list");
                    } else {
                        logger.logError("Unable to delete Manage Stores!");
                    }
                }).error(function(data) {
                    logger.logError("Error in Delete!");
                });
            });

        };

        $scope.add = function(){
            $state.go('app.finance.inventory.manageStores.add');
        };
    });
    
//});