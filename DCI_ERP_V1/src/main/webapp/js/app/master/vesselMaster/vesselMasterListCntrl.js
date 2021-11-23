'use strict';

app.controller('vesselListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 75;
    
    
    $scope.getlist=function(){
        $http.get($stateParams.tenantid+'/api/vesselmaster/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getlist();
        
    $scope.add = function() {
        $state.go('app.master.vesselmaster.add',{tenantid:$stateParams.tenantid});
    };
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(vesselID) {
    	debugger
        $location.url($stateParams.tenantid+'/master/vesselmaster/edit?vesselID='+vesselID);
    };
   
   $scope.view = function(vesselID) {   
    	
    	$location.url($stateParams.tenantid+'/master/vesselmaster/view?vesselID='+vesselID);    
     }
    
    $scope.deleteRow = function(vesselID) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/vesselmaster/delete?vesselID=' + vesselID;
            $http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
               } else {
                    logger.logError("You Can't Delete this Record, Related Data Exist! ");
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };

   
});