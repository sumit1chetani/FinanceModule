app.controller('assetCategoryAddCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, 
        sharedProperties, toaster,$rootScope,validationService ,$stateParams) {
        
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.numPages=0;
        $scope.isEdit = false;
        $scope.assetApprDetailList = [];
        
        $scope.rowCollectionItem =[];
        $scope.displayedCollectionItem = [];
        
        $scope.rowCollectionAppreciation = [];
        $scope.displayedCollectionAppreciation = [];
        
        $scope.assetCategoryObj={
        		assetCategoryName:'',
        		assetCategoryId:''
        };
      
        
        $scope.cancelAsset = function(){
            $state.go('app.finance.asset.manage.assetCategory.list',{tenantid:$stateParams.tenantid});
        };
        
     
        
        
        $scope.validate =  function(assetCategoryAddForm,assetCategoryObj) {

    		if (new validationService().checkFormValidity(assetCategoryAddForm)) {
    			if (!$scope.isEdit) {
    				$scope.save(assetCategoryObj,assetCategoryAddForm);
    			} else {
    				$scope.update(assetCategoryObj,assetCategoryAddForm);
    			}
    		} else {
    			toaster.pop('error', "Please fill the required fields", logger
    					.getErrorHtmlNew(assetCategoryAddForm.$validationSummary), 5000,
    					'trustedHtml');
    		}
    	};
    
        $scope.save = function(assetCategoryObj) {
         
        $http.post($stateParams.tenantid+'/app/assetCategory/save',  $scope.assetCategoryObj).success(function(result) {
            if (result) {
                logger.logSuccess("Saved successfully!");
                $state.go('app.finance.asset.manage.assetCategory.list');
            } else {
                logger.logError("Not Saved!");
                    }
        });
        }
        
        
        var editId = $location.search().assetCategoryId;

    	$scope.getEdit = function() {

    		if (editId) {
    			$scope.isEdit = true;
    			$http.post($stateParams.tenantid + '/app/assetCategory/edit',
    					editId).success(function(result) {
    						
    						$scope.assetCategoryObj.assetCategoryName=result.assetCategoryName;
    						$scope.assetCategoryObj.assetCategoryId=result.assetCategoryId;

    			});
    		}
    	}
    	$scope.getEdit();
        
    	
    	
    	  $scope.reset = function() {
    		  
    		  if($scope.isEdit == true){
    			  
    			  $scope.getEdit();
    			  
    		  }
    		  else{
    			  
    				$scope.assetCategoryObj.assetCategoryName= '';
    			  
    		  }
    		  
    	  }
     
        $scope.update = function() {
            
            $http.post($stateParams.tenantid+'/app/assetCategory/update',  $scope.assetCategoryObj).success(function(result) {
                if (result) {
                    logger.logSuccess("Saved successfully!");
                    $state.go('app.finance.asset.manage.assetCategory.list');
                } else {
                    logger.logError("Not Saved!");
                        }
            });
            }
        
        
        
});       
