define([ 'payroll/tds/tds' ], function(module) {
'use strict';
module.registerController('employeeTdsGenerationCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
  
   
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isEdit = false;
    $scope.isDisplay= true;
    $scope.isAuthorized=false;
    $scope.isAdd=true;
    $scope.isDelete=true;
    $scope.isUpload=true;
    
    $scope.tdsGeneration = {
            departmentId:'',
            companyId:'',
            companyName:'',
            branchName:'',
            departmentName:'',
            branchId:'',
            amount:'',
            employeeName:'',
            employeeId:'',
            companyId:'',
            monthYear:'',
            isEdit:false  
     };
    
        $scope.submit = function(){
            var isvalid=true;
            var errorString="";
            if($scope.tdsGeneration.companyId==null || $scope.tdsGeneration.companyId==undefined || $scope.tdsGeneration.companyId==''){
                errorString="Company Id is Requried!!!!";
                isvalid=false;
                
            } if($scope.tdsGeneration.monthYear==null || $scope.tdsGeneration.monthYear==undefined || $scope.tdsGeneration.monthYear==''){
                errorString=errorString+"\n"+"Month Year Id is Requried!!!!";
                isvalid=false;
                
            }  if($scope.tdsGeneration.branchId==null || $scope.tdsGeneration.branchId==undefined || $scope.tdsGeneration.branchId==''){
                $scope.tdsGeneration.branchId=null;
            }  if($scope.tdsGeneration.departmentId==null || $scope.tdsGeneration.departmentId==undefined || $scope.tdsGeneration.departmentId==''){
                $scope.tdsGeneration.departmentId=null;
            }  if($scope.tdsGeneration.employeeId==null || $scope.tdsGeneration.employeeId==undefined || $scope.tdsGeneration.employeeId==''){
                $scope.tdsGeneration.employeeId=null;
            }
            if(isvalid){
                var resultbean={
                        companyId:$scope.tdsGeneration.companyId,
                        branchId:$scope.tdsGeneration.branchId,
                        departmentId:$scope.tdsGeneration.departmentId,
                        employeeId:$scope.tdsGeneration.employeeId,
                        monthYear:$scope.tdsGeneration.monthYear
                            
                }
                console.log("resultbean");
                console.log(resultbean);
             $http.post("payroll/tds/tdsDeclaration/generationlist",resultbean).success(function(datas) {
                   console.log("getCompanyList");
                   $scope.rowCollection=datas.tdsDeclarationList;
                   $scope.tdsGeneration.isEdit=true;
                   console.log(datas);
               })
            }else{
                logger.logError(errorString);
            }
            
          
    }
    
     $scope.updateTdsGenerationList=function(){
         
            console.log("Updated Values");
            if($scope.rowCollection.length>0){

               angular.forEach($scope.rowCollection, function(value, key) {
                   value.monthYear=$scope.tdsGeneration.monthYear;
                 
               });
               console.log($scope.rowCollection);
                $http.post("payroll/tds/tdsDeclaration/generationsave", $scope.rowCollection).success(function(result) {
                    if (result == false) {
                    }else{
                        logger.logSuccess("Employee TDS Declaration List Updated successfully");
                        $scope.submit();
                    }
                    
                })  
            }
        };    
    
    
    $scope.getCompanyList = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
              console.log("getCompanyList");
              $scope.companyList = datas.companyList;
              console.log(datas);
          })
    }
    
    $scope.getBranchList = function(companyId,branchID){
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.branchList = datas.branchList;
                console.log(branchID);
                $scope.tdsGeneration.branchId=branchID;
                $scope.departmentList=[];
                $scope.employeeList=[];
                $scope.tdsGeneration.departmentId='';
                $scope.tdsGeneration.employeeId='';
                console.log($scope.branchList);
            })
      }
   
    
  
    $scope.getDepartment = function(branchId){
        console.log("branchID"+branchId);
       $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
              console.log("LoginUseDepartmentList");
              console.log(datas);
              $scope.departmentList = datas.departmentList;
              $scope.tdsGeneration.departmentId='';
              $scope.tdsGeneration.employeeId='';
              $scope.employeeList=[];
       })
    }
    
  
    $scope.getEmployeeDetails = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              console.log("LoginUser");
              console.log(datas);
              $scope.getCompanyList();
              $scope.tdsGeneration.companyId=datas.companyId;
              $scope.tdsGeneration.companyName=datas.companyName;
              $scope.getBranchList($scope.tdsGeneration.companyId,datas.branchId);
              $scope.getDepartment(datas.branchId);
              
          })
    }
    
    
    $scope.getEmployeeList = function(departmentId){
        console.log("Department ID:"+departmentId);
        console.log("Branch ID:"+$scope.tdsGeneration.branchId);
        var resultBean={
                branchId:$scope.tdsGeneration.branchId,
                departmentId:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              console.log("LoginUseEmployeeList");
              $scope.employeeList = datas.employeeList;
              $scope.tdsGeneration.employeeId='';
              console.log(datas);
          })
    }
    
    $scope.getEmployeeDetails();

    
    $scope.getMonthYearList = function(){
      
         $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
               console.log("MonthYearList");
               $scope.monthYearList = datas.monthYearList;
               console.log(datas);
           })
     }
     
     $scope.getMonthYearList();

})
    
});