//define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
    
   	app.controller('myLoanCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {
   // module.registerController('myLoanCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
    
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
                status:'1',
                month:'',
                year:'',
                departmentId:'',
                isEdit:false      
         };
        
        
        var loginemployeeId;
        
        $scope.getEmployeeDetails = function(){
            
            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                  console.log("LoginUser");
                  console.log(datas);
                  loginemployeeId= datas.loginUserEmpId;
                  $scope.getList();
             })
             
            
        }
        $scope.getEmployeeDetails();
        
        $scope.getList = function(){
           var resultbean={
                   status:$scope.loantype.status,
                   employeeId:loginemployeeId
           } 
           console.log("resultbean");
           console.log(resultbean);
           
          $http.post("payroll/payroll/loanentry/emploanentry",resultbean)
            .success(function(response) {
                console.log("response");
                console.log(response);
                console.log(response.loanEntryList);
                $scope.rowCollection = response.employeeLoanEntry;
            });
        };
        
        
        
       
     
        $scope.showList = function(status){
            
            var resultbean={
                    status:$scope.loantype.status,
                    employeeId:loginemployeeId
            } 
            console.log("resultbean");
            console.log(resultbean);
            
            $http.post("payroll/payroll/loanentry/emploanentry",resultbean)
              .success(function(response) {
                  console.log("response");
                  console.log(response);
                  console.log(response.loanEntryList);
                  $scope.rowCollection = response.employeeLoanEntry;
              });
          };
        
        
        
        
        $scope.add = function(loanid){
           
            $location.url('/payroll/payroll/myloan/view?loanId=' + loanid);
        };
        
        
        
       
    });
    
