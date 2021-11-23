'use strict';

app.controller('damageRecordListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.damageRecordDtl=[];
	$scope.containerSizelist = [];
	$scope.locationList = [];
	$scope.containerTypeList = [];
	$scope.containerNoList = [];
	$scope.damageStatusList = [];
	$scope.damageCodeList = [];
	$scope.repairProcessList = [];
	$scope.containerNoList = [];
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/api/damageRecordType/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
    $scope.add = function() {
        $state.go('app.eqs.damageRecord.damageRecordAdd',{tenantid:$stateParams.tenantid});
    };
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(damageHdrId) {
    	debugger
    	$location.url($stateParams.tenantid + '/damageRecord/damageRecordedit?damageHdrId='+damageHdrId);
       // $location.url('/damageRecord/damageRecordedit?damageHdrId='+damageHdrId);
    };

    $scope.deleteRow = function(damageRecordDtlPrimary) {
    	debugger
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/damageRecordType/delete?damageRecordDtlPrimary=' + damageRecordDtlPrimary;
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