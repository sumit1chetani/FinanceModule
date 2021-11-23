'use strict';

app.controller('manageLocationListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    
	    $scope.itemsByPage = 10;
	    
	    
    $scope.add = function() {
        $state.go('app.truck.general.stopping.add',{tenantid:$stateParams.tenantid});
    };
    

    
    $scope.getList=function(){
    $http.get($stateParams.tenantid+'/locationmaster/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas.list;
    	
        }).error(function(datas) {
    });
    };
    $scope.getList();

    
    
    $scope.editRow = function(locationId) {    
    	  
    	$location.url($stateParams.tenantid+'/location/edit?locationId='+locationId);       
     }
    
    
  $scope.deleteRow = function(locationId) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/locationmaster/delete';
            $http({
                method : 'post',
                url : myURL,
                data : locationId,
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
   /* $scope.deleteRow = function(vehiclemodel) {
        ngDialog.openConfirm().then(function() {
            $http.post($stateParams.tenantid+'/vehicle/delete',vehiclemodel.vehicleId).success(function(response) {

               if(response == true){
                   logger.logSuccess("Deleted Succesfully!");
                   $state.go("app.master.general.vehiclemenu.vehiclesubmenu",{tenantid:$stateParams.tenantid});                
               }
            }).error(function(response) {
                logger.logError("Error Please Try Again");
            });
        });
    }; */
    
 
    
});