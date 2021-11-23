'use strict';

app.controller('citylistCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.add = function() {
        $state.go('app.master.city.add',{tenantid:$stateParams.tenantid});
    };
    
    
    $http.get($stateParams.tenantid+'/city/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas.list;
    	
        }).error(function(datas) {
    });
   
    
    $scope.editRow = function(rowid) {   
    	
    	$location.url($stateParams.tenantid+'/master/city/edit?rowid='+rowid);    
     }
    
$scope.deleteRow = function(rowid) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/city/delete';
            $http({
                method : 'post',
                url : myURL,
                data : rowid,
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
    
    $scope.view = function(rowid) {
    	$location.url($stateParams.tenantid+'/master/city/view?rowid='+rowid); 
     }
    
});