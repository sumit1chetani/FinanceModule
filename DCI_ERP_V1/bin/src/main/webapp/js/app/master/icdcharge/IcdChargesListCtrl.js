/**
 * 
 *//**
 * 
 */

'use strict';

app.controller('IcdChargesListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/api/icdcharges/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
    $scope.add = function() {
        $state.go('app.master.icdcharge.add',{tenantid:$stateParams.tenantid});
    };
    
    $scope.editRow = function(icdNo) {
    	debugger
        $location.url($stateParams.tenantid+'/master/icdcharge/edit?icdNo='+icdNo);
    };
   

    
    $scope.deleteRow = function(icdNo) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/icdcharges/delete?icdNo=' + icdNo;
            $http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted successfully");
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