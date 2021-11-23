'use strict';

app.controller('containerOffHireListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/api/offhirereleaseorder/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
    $scope.add = function() {
        $state.go('app.eqs.containerOffHire.add',{tenantid:$stateParams.tenantid});
    };
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(offhireRefno) {
    	debugger
        $location.url($stateParams.tenantid+'/eqs/containerOffHire/edit?offhireRefno='+offhireRefno);
    };
   
//    $scope.editRow = function(rowid) {   
//    	
//    	$location.url($stateParams.tenantid+'/master/containersize/edit?rowid='+rowid);    
//     }
//    
    $scope.deleteRow = function(offhireRefno) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/offhirereleaseorder/delete?offhireRefno=' + offhireRefno;
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