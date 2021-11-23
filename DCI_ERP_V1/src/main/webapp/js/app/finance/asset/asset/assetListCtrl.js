app.controller('assetListCtrl', function($scope,$state,$http,$stateParams, ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,utilsService) {
    
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages=0;
        $scope.isDisplay = false;
        $scope.isUpload=true;

        
        $scope.getAssetList = function() {
            debugger;
            
            $http.get($stateParams.tenantid+'/app/assetmaster/getAssetList').success(function(data) {
               if (data.success == true && !utilsService.isUndefinedOrNull(data.lAssetMasterBean)) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.lAssetMasterBean);
                    console.log($scope.rowCollection);
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        };

        $scope.getAssetList();
        
        debugger;
        $scope.add = function(){
            $state.go("app.finance.asset.manage.asset.add");
        };
        
        
        $scope.editRow=function(assetId)
        {
           // sharedProperties.setObject(row.id);
            $location.url($stateParams.tenantid+'/finance/asset/asset/edit?assetId='+assetId);
            

        }   
        
        
        $scope.deleteRow = function(assetId) {
        	
            ngDialog.openConfirm().then(function() {
                var myURL = $stateParams.tenantid+'/app/assetmaster/delete';
                $http({
                    method : 'post',
                    url : myURL,
                    data : assetId,
                }).success(function(data) {
                    if (data == true) {                    
                        logger.logSuccess("Deleted Successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in deleting Record!");
                    }
                }).error(function(data) {
                    logger.logSuccess("Error in Delete!");
                });
            });

        };
        
        
        
});