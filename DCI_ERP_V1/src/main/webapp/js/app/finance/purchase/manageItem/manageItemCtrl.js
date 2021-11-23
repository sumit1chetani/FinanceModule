define([ 'hospital/purchase/purchase' ], function(module) {

'use strict';

    module.registerController('manageItemListCtrl', function($scope,$state,$http,$location,ngDialog,logger) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.numPages=0;
        $scope.isDisplay = false;
        $scope.isUpload=true;

        $scope.add = function(){
            $state.go("app.hospital.purchase.manageitem.add");
        };
        
        
        $scope.getManageItemList = function() {
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

       $scope.getManageItemList();

       $scope.editRow = function(manageItem) {
           $state.go('app.hospital.purchase.manageitem.edit',({ itemId: manageItem.itemId}));
       }
       
       
       $scope.deleteRow=function(manageItem,index){
           var itemId=manageItem.itemId;
           var myURL = 'hospital/inventory/manageitem/delete';
           $http({
               method : 'post',
               url : myURL,
               data : itemId,
           }).success(function(data) {
               if (data) {
                   var tableData = $scope.rowCollection;
                   $scope.rowCollection.splice(index, 1);
                   logger.logSuccess("Deleted successfully");
                   $state.reload();
               } else {
                   logger.logError("Error in delete!");
               }
           }).error(function(data) {
               logger.logSuccess("Error in Delete!");
           });
       }
       
       $scope.viewRow = function(manageItem) {
           $state.go('app.hospital.purchase.manageitem.view',({ itemId: manageItem.itemId}));
       }
       
    });
    
});