//define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
   	app.controller('loanEntryCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

   // module.registerController('loanEntryCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
       
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDelete=true;
        $scope.isUpload=true;
        $scope.loantype = {
                
                employeeId:'',
                loanId:'',
                loanTypeId:'',
                amount:'',
                numberOfInstalments:'',
                deductFrom:'',
                deductionAmount:'',
                status:1,
                departmentId:'',
                employeeName:'',
                branchId:'',
                departmentName:'',
                isEdit:false
               
                 
         };
        
        console.log("Status:"+$scope.loantype.status);
        $scope.getList = function(status){
            $http.post("payroll/payroll/loanentry/list",status)
            .success(function(response) {
                console.log("Coming inside List");
                console.log(response);
                console.log(response.loanEntryList);
                $scope.rowCollection = response.loanEntryList;
            });
        };
        $scope.getList(Number($scope.loantype.status));
        
       
        $scope.editRow = function (loanId){
          $location.url($stateParams.tenantid+'/payroll/loanentry/edit?loanId='+loanId);
        }
        
        $scope.add =function(){
            
            $state.go('app.payroll.loanEntry.add');
          };
       
            
            $scope.deleteRow = function(loanId) {
                ngDialog.openConfirm().then(function() {
                    $http.post("payroll/payroll/loanentry/delete",loanId)
                    .success(function(response) {
                        console.log("result is");
                        console.log(response);
                       if(response == true){
                           logger.logSuccess("Deleted Successfully!");
                           $scope.getList(Number($scope.loantype.status));
                       }
                    }).error(function(result) {
                        logger.logError("Error Please Try Again");
                    });
                });
            };
            
           
    
    
});