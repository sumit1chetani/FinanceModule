define([ 'hospital/inventory/inventory' ], function(module) {

'use strict';

    module.registerController('wiseReorderLevelListCtrl', function($scope,$state,$http,$location,ngDialog,logger) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.numPages=0;
        $scope.isDisplay = false;
        $scope.isUpload=true;

        $scope.add = function(){
            $state.go("app.hospital.inventory.wiseReorderLevel.add");
        };
        
        $scope.getList = function() {
            $http.get('hospital/inventory/wiseReorderLevel/list').success(function(data) {
                if (data.success) {
                    $scope.rowCollection = data.itemWiseReorderLevelList;
               } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

       $scope.getList();

       $scope.editRow = function(objItemWiseReorderLevel) {
           $state.go('app.hospital.inventory.wiseReorderLevel.edit',({ itemId: objItemWiseReorderLevel.itemId}));
       }
       
       $scope.deleteRow = function(objItemWiseReorderLevel, index) {
           var itemId=objItemWiseReorderLevel.itemId;
           ngDialog.openConfirm().then(function() {
               var myURL = 'hospital/inventory/wiseReorderLevel/delete';
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
                       logger.logError("Unable To Delete Records!");
                   }
               }).error(function(data) {
                   logger.logError("Error in Delete!");
               });
           });

       };
       
    });
    
});