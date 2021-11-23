'use strict';

app.controller('vehicleCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
    $scope.add = function() {
        $state.go('app.master.general.vehiclemenu.vehiclesubmenuadd',{tenantid:$stateParams.tenantid});
    };
    $scope.add = function() {
        $state.go('app.master.general.vehiclemenu.vehiclesubmenuadd',{tenantid:$stateParams.tenantid});
    };
    $scope.getList=function(){
    $http.get($stateParams.tenantid+'/vehicle/list').success(function(datas) {
        console.log(datas);
        $scope.displayedCollection = datas.list;
    	
        }).error(function(datas) {
    });
    };
  $scope.deleteRow = function(rowid) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/vehicle/delete';
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
                logger.logSuccess("Error in Delete!");ss
            });
        });

    };

    $scope.getList();
    $scope.editRow = function(rowid) {    
  
    	$location.url($stateParams.tenantid+'/master/general/vehicle/add?rowid='+rowid);       
     }
    
});