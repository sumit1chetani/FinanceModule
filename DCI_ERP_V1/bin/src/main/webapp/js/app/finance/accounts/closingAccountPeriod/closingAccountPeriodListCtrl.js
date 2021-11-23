//  define([ 'hospital/accounts/accounts' ], function(module) {
       
        'use strict';
        
app.controller('closingAccountPeriodListCtrl', function($scope,$stateParams, $rootScope, $http, $location, 
        logger, $log, ngDialog, $modal, utilsService, toaster,$window, $state, sharedProperties,validationService) {
  
    $scope.rowCollection=[];
    $scope.hideEditIcon=true;
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isUpload = true;
    $scope.isDelete = true;
    $scope.emptyObject = {};
    





$scope.closeact = {
    fromDate : '',
    toDate : '',
  
}

$scope.getList = function() {
    var url = 'hospital/accounts/closingPeriod/list';
    
    $http.get(url).success(function(data) {

        $scope.rowCollection  = data.lClosingAccount;
    }).error(function(data) {

        logger.logError("Please Try Again");
    });

}

$scope.getList();


$scope.add=function(){
 $state.go('app.finance.accounts.closingAccountPeriod.add',{tenantid:$stateParams.tenantid});  
 //  $location.path("controlscreen/accountingyearclose/add");
}

$scope.edit = function(chanda) {     
    console.log(chanda)
  /*  $state.go('app.finance.controlscreen.closingaccounts.add');*/
}
/*
 * $scope.edit = function(obj) {
 * 
 * $rootScope.editValue=edit; $state.go('app.commercial.bunkerRate.edit');
 * 
 * $location.url('/bunkerRate/edit?quotationId='+ obj.quotationId); }
 */

$scope.deleteRow = function(closingAccountCode) {
    
    ngDialog.openConfirm().then(function() {
        var url =  $stateParams.tenantid+'/app/closingAccount/delete?closingAccountCode=' + closingAccountCode;
       
        $http.get(url).success(function(result) {
            if (result) {
                logger.logSuccess("Data Deleted successfully");
                $state.reload();
            } else {
                logger.logError("Data Not Deleted ");

            }

        }).error(function(result) {
            logger.logError("Error Please Try Again");

        })
    }, function(reason) {
        console.log('Modal promise rejected. Reason: ', reason);
    });
    

 

}



 // });


  });

  