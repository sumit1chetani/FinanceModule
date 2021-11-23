/**
 * 
 */'use strict';

app.controller('leaseAgreementListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.add = function() {
        $state.go('app.eqs.leaseagreementtype.add',{tenantid:$stateParams.tenantid});
    };
    
    
    $http.get($stateParams.tenantid+'/api/lease/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas;
    	
        }).error(function(datas) {
    });
   
    
    $scope.editRow = function(rowid) {   
    	
    	$location.url($stateParams.tenantid+'/edit?code='+rowid);    
     }
    
$scope.deleteRow = function(rowid) {
    	
        ngDialog.openConfirm().then(function() {
            var url = $stateParams.tenantid+'/api/lease/delete?code=' + rowid;
             $http.get(url).success(function(data) {
                if (data == true) {                    
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
                } else {
                    logger.logError("Error in deleting Record!");
                }
            }).error(function(data) {
                logger.logError("Error in Delete");
            });
        });

    };
    
    $scope.view = function(rowid) {
    	$location.url($stateParams.tenantid+'/master/port/view?rowid='+rowid); 
     }
    
});