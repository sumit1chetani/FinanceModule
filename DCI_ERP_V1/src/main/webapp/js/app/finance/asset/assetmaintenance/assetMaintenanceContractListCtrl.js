define([ 'hospital/asset/asset' ], function(module) {

'use strict';

    module.registerController('assetmaintenanceContractListCtrl', function($scope,$state,$http,$location,ngDialog,logger) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;

        $scope.numPages=0
        $scope.isUpload=true;

        $scope.add = function(){
            $state.go("app.hospital.asset.maintenancecontract.add");
        };
        
        
        $scope.getAsstMaintContract = function() {
            $http.get('hospital/asset/assetmaintenanceContract/list').success(function(data) {
                if (data.success) {
                    $scope.rowCollection = data.alAssetMaintenaceContractBeans;
               } else {
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

       $scope.getAsstMaintContract();
        
      

       $scope.editRow = function(amcId) {
           $state.go('app.hospital.asset.maintenancecontract.edit',({ amcNo: amcId}));
       }
       
       $scope.viewRow = function(amcId) {
           $state.go('app.hospital.asset.amcapproval.view',({ amcNo: amcId,id:1}));
       }
       $scope.deleteRow=function(amcId,index){
           
           var myURL = 'hospital/asset/assetmaintenanceContract/delete';
           $http({
               method : 'post',
               url : myURL,
               data : amcId,
           }).success(function(data) {
               if (data == true) {
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
       
    });
    
});