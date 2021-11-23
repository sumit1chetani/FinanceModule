define([ 'hospital/inventory/inventory' ], function(module) {

'use strict';

    module.registerController('itemWiseVendorListCtrl', function($scope,$state,$http,$location,ngDialog,logger) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.numPages=0

        $scope.add = function(){
            $state.go("app.hospital.inventory.itemwisevendor.add");
        };
        
        $scope.getList = function(){
            $http.get('hospital/inventory/manageitem/list').success(function(data) {
                if (data.success) {
                    $scope.rowCollection = data.itemList;
               } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };
        
        $scope.getList();
        
        $scope.editRow = function(itemId){
            $state.go('app.hospital.inventory.itemwisevendor.edit',{ itemId:itemId });
        }
        
        $scope.deleteRow = function(itemId, index) {
            ngDialog.openConfirm().then(function() {
                var myURL = 'hospital/inventory/itemwisevendormapping/delete?itemId';
                $http({
                    method : 'post',
                    url : myURL,
                    data : itemId,
                }).success(function(data) {
                    if (data == true) {
                        var tableData = $scope.rowCollection;
                        $scope.rowCollection.splice(index, 1);
                        logger.logSuccess("Deleted successfully");
                        $state.reload();
                    } else {
                        logger.logError("Unable to Delete Item Wise Vendor Mapping!");
                    }
                }).error(function(data) {
                    logger.logError("Unable to Delete!");
                });
            });

        };
        
    });
    
});