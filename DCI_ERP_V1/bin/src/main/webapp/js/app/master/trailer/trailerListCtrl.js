'use strict';

app.controller('trailerListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
  
    $scope.add = function() {
        $state.go('app.truck.trailer.add',{tenantid:$stateParams.tenantid});

    };
    $scope.getList=function(){
    $http.get($stateParams.tenantid+'/trailer/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas.list;
    	
        }).error(function(datas) {
    });
    };
  $scope.deleteRow = function(rowid) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/trailer/delete';
            $http({
                method : 'post',
                url : myURL,
                data : rowid,
            }).success(function(data) {
                if (data == true) {                    
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
                } else {
                    logger.logError("Unable to delete Record!");
                }
            }).error(function(data) {
                logger.logSuccess("Error in Delete!");
            });
        });

    };
    
    
    

    
    $scope.getList();
    $scope.editRow = function(rowid) {   
	$location.url($stateParams.tenantid+'/trailer/edit?rowid='+rowid);       

     }
    $scope.view = function(rowid) {   
    	$location.url($stateParams.tenantid+'/trailer/view?rowid='+rowid);       

         }
   
    
});