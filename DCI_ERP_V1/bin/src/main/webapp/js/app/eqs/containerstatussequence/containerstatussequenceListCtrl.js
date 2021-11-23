'use strict';

app.controller('containerstatussequenceListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.containerstatussequenceDtl=[];
	$scope.containerSizelist = [];
	$scope.locationList = [];
	$scope.containerTypeList = [];
	$scope.sequenceList = [];
	$scope.directionList = [];
	$scope.containerstatussequenceCodeList = [];
	$scope.repairProcessList = [];
	$scope.sequenceList = [];
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/api/containerstatussequence/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
    $scope.add = function() {
        $state.go('app.eqs.containerstatussequence.containerstatussequenceadd',{tenantid:$stateParams.tenantid});
    };
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(sequence) {
    	$location.url($stateParams.tenantid + '/containerstatussequence/containerstatussequenceedit?sequence='+sequence);
        //$location.url('/containerstatussequence/containerstatussequenceedit?sequence='+sequence);
    };

    $scope.deleteRow = function(sequence) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/containerstatussequence/delete?sequence=' + sequence;
            $http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted successfully");
                    $state.reload();
               } else {
                    logger.logError("Error in Delete ");
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };

   
});