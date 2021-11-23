define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
    
    module.registerController('myReimbursementCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
    
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
        
        
        $scope.reimbursementApproval= {
                departmentId:'',
                reimbursementTypeId:'',
                reimbusementName:'',
                currencyName:'',
                currencyCode:'',
                branchId:'',
                companyId:'',
                companyName:'',
                branchName:'',
                employeeId:'',
                employeeName:'',
                paymentMode:'',
                amount:'',
                departmentName:'',
                status:'1',
                description:'',
                requestedby:'',
                requesteddate:'',
                reimbursementId:'',
                approvalempId:'',
                approvedDate:'',
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
                   status:$scope.reimbursementApproval.status,
                   approvalempId:loginemployeeId
           } 
           console.log("resultbean");
           console.log(resultbean);
           
          $http.post("payroll/payroll/reimbursementreq/approvallist",resultbean)
            .success(function(response) {
                console.log("response");
                console.log(response);
                console.log(response.reimbursementList);
                $scope.rowCollection = response.reimbursementList;
            });
        };
        
       
        $scope.showList = function(status){
            
            var resultbean={
                    status:$scope.reimbursementApproval.status,
                    approvalempId:loginemployeeId
            } 
            console.log("resultbean");
            console.log(resultbean);
            
            $http.post("payroll/payroll/reimbursementreq/approvallist",resultbean)
              .success(function(response) {
                  console.log("response");
                  console.log(response);
                  console.log(response.reimbursementList);
                  $scope.rowCollection = response.reimbursementList;
              });
          };
        
        
        
          $scope.add = function(reimbursementId){
              
              $location.url('/payroll/payroll/myreimbursement/view?reimbursementId=' + reimbursementId);
          };
          
     
        
        
       
    });
    
})