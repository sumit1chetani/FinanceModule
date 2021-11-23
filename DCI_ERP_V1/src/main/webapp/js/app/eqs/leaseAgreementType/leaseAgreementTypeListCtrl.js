'use strict';

app.controller('leaseAgreementTypeListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    //list
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/app/commonUtility/getLeaseAggTypeList').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas.LeaseAggTypeList;
        
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
     // Redirecting Page For Add 
    $scope.add = function() {
        $state.go('app.eqs.leaseAgreementType.leaseAgreementTypeAdd',{tenantid:$stateParams.tenantid});
    };
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(type) {
    	debugger
        $location.url($stateParams.tenantid+'/eqs/leaseAgreementType/Edit?type='+type);
    };
   
   //delete
    $scope.deleteRow = function(type) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/leaseAgreement/delete?type=' + type;
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