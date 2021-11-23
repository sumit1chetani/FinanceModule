app.controller('assetCategoryListCtrl', function($scope,$state,$http,$location,ngDialog,$stateParams,logger) {
    
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isUpload = true;

    $scope.numPages=0;

    $scope.add = function(){
        $state.go("app.finance.asset.manage.assetCategory.add");
    };
    
    
    

    $scope.getList = function(){
        $http.get($stateParams.tenantid+'/app/assetCategory/list').success(function(response) {
            console.log(response.lAssetCategoryList);
            $scope.rowCollection = response.lAssetCategoryList;
        });
    };
    
    $scope.getList();
    
    $scope.editRow = function(assetCategoryId){
    	
    	$location.url($stateParams.tenantid+'/finance/asset/assetCategory/edit?assetCategoryId='+assetCategoryId);       
    }
    
   
    
 $scope.deleteRow = function(assetCategoryId) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/assetCategory/delete';
            $http({
                method : 'post',
                url : myURL,
                data : assetCategoryId,
            }).success(function(data) {
                if (data) {                    
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
    
    
    
//    
//    $scope.chkAll=false;
//    $scope.checkAll = function (rowCollection,checkBox) {
//        if (checkBox) {
//            $scope.chkAll=true;
//        } else {
//            $scope.chkAll = false;
//        }
//        
//        angular.forEach($scope.rowCollection, function (asset) {
//            asset.select = $scope.chkAll;
//        });
//        
//    };
//    
//    $scope.chkSelected=false;
//    $scope.checkSelected = function (chkAsset,assetCategoryId) {
//        if(chkAsset==true){
//            /*angular.forEach($scope.rowCollection, function (asset) {
//                if(assetCategoryId==asset.assetCategoryId){
//                    asset.select = true;
//                }else{
//                    asset.select = false;
//                }
//            });*/
//            asset.select = true;
//        }else{
//            /*angular.forEach($scope.rowCollection, function (asset) {
//                 asset.select = false;
//            });*/
//            asset.select = false;
//        }
//    };
//    
//  //Multi Delete Functionality
//    $scope.deleteSelected = function(){
//        var isDelete = false;
//        angular.forEach($scope.rowCollection, function (asset) {
//            if(asset.select==true){
//                isDelete = true;
//            }
//        });
//        
//        if(isDelete==false){
//            logger.logError("Please Select Atleast One Row!");
//        }else{
//            ngDialog.openConfirm().then(function() {
//                $http.post('hospital/asset/assetCategory/multiDelete', $scope.rowCollection).success(function(data) {
//                    if (data.message!="") {
//                        var tableData = $scope.rowCollection;
//                        logger.logSuccess(data.message);
//                        $state.go("app.hospital.asset.assetCategory.list");
//                        $scope.getList();
//                    }else {
//                        logger.logError("Unable to Delete Asset Category!");
//                    } 
//                }).error(function(result) {
//                    console.log("data" + result);
//                });
//                
//            });
//        }
//    };
});