'use strict';

app.controller('commodityListnewCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 75;
  
    $scope.add = function() {
    	 $state.go('app.master.commoditynewdesc.add',{tenantid:$stateParams.tenantid});
    };
    $scope.getList=function(){
    $http.get($stateParams.tenantid+'/api/commoditynew/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas;
    	
        }).error(function(datas) {
    });
    };
    
    $scope.deleteRow = function(rowid) {
        	
            ngDialog.openConfirm().then(function() {
                var url = $stateParams.tenantid+'/api/commoditynew/delete?commodityCode=' + rowid;
                 $http.get(url).success(function(data) {
                    if (data == true) {                    
                        logger.logSuccess("Deleted Successfully");
                        $state.reload();
                    } else {
                        logger.logError("Error in Delete");
                    }
                }).error(function(data) {
                    logger.logError("Error in deleting Record!");
                });
            });

        };
        $scope.view = function(commodityCode) {
        	$location.url($stateParams.tenantid+'/master/commoditynew/view?commodityCode='+commodityCode); 
         }
        
  //Redirecting Page For Edit Functionality
$scope.editRow = function(rowid) {   
    	
    	$location.url($stateParams.tenantid+'/master/commoditynew/edit?commodityCode='+rowid);    
     }
    $scope.getList();
    
 
  
});


