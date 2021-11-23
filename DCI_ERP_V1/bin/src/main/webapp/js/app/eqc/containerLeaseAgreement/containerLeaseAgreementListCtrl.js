'use strict';

app.controller('containerLeaseAgreementListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/api/containerLeaseAgreementType/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
    $scope.add = function() {
        $state.go('app.eqc.containerLeaseAgreement.containerLeaseAgreementAdd',{tenantid:$stateParams.tenantid});
    };
    
    
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(agreementRefNo) {
    	debugger
        $location.url($stateParams.tenantid+'/trade/containerLeaseAgreement/Edit?agreementRefNo='+agreementRefNo);
    };

    $scope.deleteRow = function(agreementRefNo) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/containerLeaseAgreementType/delete?agreementRefNo=' + agreementRefNo;
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
    
    $scope.View = function(agreementRefNo) {
    	debugger
        $location.url($stateParams.tenantid+'/trade/containerLeaseAgreement/View?agreementRefNo='+agreementRefNo);
    };

   
});