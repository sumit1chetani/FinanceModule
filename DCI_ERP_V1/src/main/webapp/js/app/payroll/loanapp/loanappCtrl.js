//define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
   	app.controller('loanappCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

   // module.registerController('loanappCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
     
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay=true;
        
        $scope.isAdd=true;
        $scope.isDelete=true;
        $scope.isUpload=true;
        
        $scope.loantype = {
                employeeId:'',
                employeeName:'',
                loanId:'',
                loanTypeId:'',
                amount:0,
                flatOrDiminishing:'',
                numberOfInstalments:0,
                interestRate:0,
                deductFrom:'',
                deductionAmount:0,
                totalInterest:0,
                payable:0,
                status:1,
                month:'',
                year:'',
                departmentId:'',
                isEdit:false      
         };
        
        
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
        
        
        $scope.showList = function(status){
          //  alert("title" + "\n" + "address" + "\n" + "address2" + "\n" + "address3" + "\n" + "address4");
            $http.post("payroll/payroll/loanentry/list",status)
              .success(function(response) {
                  console.log("response");
                  console.log(response);
                  console.log(response.loanEntryList);
                  $scope.rowCollection = response.loanEntryList;
              });
          };
        
        
        
        $scope.editRow=function(loanId){
            $location.url('/payroll/payroll/loanapproval/edit?loanId=' + loanId);
        };
        
        
        
    });
    
