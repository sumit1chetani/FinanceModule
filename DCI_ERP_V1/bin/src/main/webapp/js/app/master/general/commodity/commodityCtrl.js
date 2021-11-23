'use strict';

app.controller('commodityListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    
	    $scope.itemsByPage = 10;
	    
	    
    $scope.add = function() {
        $state.go('app.truck.general.commodity.add',{tenantid:$stateParams.tenantid});
    };
    

    
    $scope.getList=function(){
    $http.get($stateParams.tenantid+'/commodity/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas.list;
    	
        }).error(function(datas) {
    });
    };
    $scope.getList();

    
    
    $scope.editRow = function(commodityId) {    
    	  
    	$location.url($stateParams.tenantid+'/commodity/edit?commodityId='+commodityId);       
     }
    
    
  $scope.deleteRow = function(commodityId) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/commodity/delete';
            $http({
                method : 'post',
                url : myURL,
                data : commodityId,
            }).success(function(data) {
                if (data == true) {                    
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
                } else {
                    logger.logError("Cannot be delete,Because related data Exist");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        });

    };
   
    
    
});


app.controller('commodityAddCtrl', function($scope,toaster, $rootScope, $http, $location,validationService, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

	    
        $scope.isEdit=false
        
        
        
       $scope.commodity = {
        		
        		commodityName : '',
        		shortName : '',
        		description : '',
        		status : ''
        		
        }
        
	    $scope.validate = function(commodity, commodityForm) {

			if (new validationService().checkFormValidity(commodityForm)) {
				if (!$scope.isEdit) {
					$scope.save(commodity);
				} else {
					$scope.update(commodity);
				}
			} else {
				toaster.pop('error', "Please fill the required fields", logger
						.getErrorHtmlNew(commodityForm.$validationSummary), 5000,
						'trustedHtml');
			}
		};
		
		
		

		$scope.save = function() {

			$http.post($stateParams.tenantid + '/commodity/save',
					$scope.commodity).success(function(result) {

					if (result.shortNameErrorMessage == false) {

						if (result.success == true) {

							logger.logSuccess("Saved Successfully!");
							$state.go("app.truck.general.commodity.list", {
								tenantid : $stateParams.tenantid
							});

						} else {
							logger.logError("Error in Save");
						}

					} else {
						logger.logError("Short Name already Exist");
					}

			});
		}

		var editId = $location.search().commodityId;

		$scope.getEdit = function() {

			if (editId) {
				$scope.isEdit = true;
				$http.post($stateParams.tenantid + '/commodity/edit', editId)
						.success(function(result) {

							$scope.commodity.commodityId = result.commodityId

							$scope.commodity.commodityName = result.commodityName
							$scope.commodity.shortName = result.shortName
							
							$scope.commodity.description = result.description
							$scope.commodity.status = result.status
							

						});
			}
		}
		$scope.getEdit();

		$scope.update = function(commodityForm) {

			$http.post($stateParams.tenantid + '/commodity/update',
					$scope.commodity).success(function(response) {

					if (response.shortNameErrorMessage == false) {

						if (response.success == true) {

							logger.logSuccess("Updated Succesfully!");
							$state.go("app.truck.general.commodity.list", {
								tenantid : $stateParams.tenantid
							});

						} else {
							logger.logError("Error in Update");
						}

					} else {
						logger.logError("Short Name already Exist");
					}

			});

		};
		
		

		$scope.reset = function(commodityForm) {
			
			if(isEdit == true)
				{
				$scope.getEdit()
				}
			else{
				$scope.commodity.commodityName = '';
				$scope.commodity.shortName = '';
				$scope.commodity.description = '';
				$scope.commodity.status = '';
			}

		}


		$scope.cancel = function() {
			$state.go("app.truck.general.commodity.list", {
				tenantid : $stateParams.tenantid
			});
		}
   

   

});