//define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
    
    //module.registerController('payrolldegenerationCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
   	app.controller('payrolldegenerationCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {
  
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.departmentList=[];
        $scope.employeeList=[];
        $scope.monthYearList=[];
        $scope.isDisplay=true;
        $scope.isAuthorized=false;
        
        $scope.payrolldegeneration = {
                employeeId:'',
                departmentId:'',
                branchId:'',
                companyId:'',
                monthYear:'',
                month:'',
                year:'',
                companyName:'',
                branchName:'',
                isGenerate:false,
                isDeGenerate:false,
                isOnLoad : false
                 
         };
        
        
        $scope.getCompanyList = function(){
        	    	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
        					+ 'F0376').success(
        			function(datas) {  
          //  $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
                  console.log("getCompanyList");
                  $scope.companyList = datas;
                  
                  if ($scope.companyList.length >= 1) {
                      $scope.payrolldegeneration.companyId = $scope.companyList[0].id;
                      $scope.payrolldegeneration.companyName = $scope.companyList[0].companyName;
                  }
                  
                  console.log(datas);
              })
        }
        
        
        $scope.$watch('payrolldegeneration.companyId', function(newValue, oldValue) {
            var companyId = newValue;
            if($scope.payrolldegeneration.companyId != '' && $scope.payrolldegeneration.isOnLoad == false){
                $scope.payrolldegeneration.branchId='';
                $scope.payrolldegeneration.branchName='';
            }
               
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                    console.log("getBranchList");
                    $scope.branchList = datas.branchList;
                    if($scope.branchList.length==1){
                        $scope.payrolldegeneration.branchId=$scope.branchList[0].id;
                        $scope.payrolldegeneration.branchName=$scope.branchList[0].text;
                    }
                    $scope.payrolldegeneration.isOnLoad = false;
                    $scope.payrolldegeneration.departmentId='';
                    $scope.departmentList=[];
                    $scope.employeeList=[];
                    console.log($scope.branchList);
                })
        
        });
        
        
        $scope.getBranchList = function(companyId,branchID){
            $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                    console.log("getBranchList");
                    $scope.branchList = datas.branchList;
                    console.log(branchID);
                    $scope.payrolldegeneration.branchId=branchID;
                    $scope.departmentList=[];
                    $scope.employeeList=[];
                    console.log(datas);
                })
          }
       
        
        
        
        $scope.$watch('payrolldegeneration.branchId', function(newValue, oldValue) {
            var branchId = newValue;
            $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                   console.log("LoginUseDepartmentList");
                   console.log(datas);
                   $scope.departmentList = datas.departmentList;
                   $scope.payrolldegeneration.departmentId='';
                   $scope.employeeList=[];
            })
         
        });
        
        $scope.getDepartment = function(branchId){
            console.log("branchID");
           $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
                  console.log("LoginUseDepartmentList");
                  console.log(datas);
                  $scope.departmentList = datas.departmentList;
                  $scope.payrolldegeneration.departmentId='';
                  $scope.employeeList=[];
           })
        }
        
        
        $scope.getEmployeeDetails = function(){
            
            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                  console.log("LoginUser");
                  console.log(datas);
                  $scope.getCompanyList();
                  $scope.payrolldegeneration.isOnLoad = true;
                  $scope.payrolldegeneration.companyId=datas.companyId;
                  $scope.getBranchList($scope.payrolldegeneration.companyId,datas.branchId);
                  $scope.payrolldegeneration.companyName=datas.companyName;
                  $scope.getDepartment(datas.branchId);
                  
              })
        }
        
        $scope.getEmployeeDetails();
        
        
        
        $scope.$watch('payrolldegeneration.departmentId', function(newValue, oldValue) {
            var dept = newValue;
            var branchId =  $scope.payrolldegeneration.branchId;
            console.log("Department ID:"+departmentId);
            console.log("Branch ID:"+branchId);
            var resultBean={
                    branchId:branchId,
                    dept:dept
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList");
                  $scope.employeeList = datas.employeeList;
                  $scope.payrolldegeneration.employeeId='';
                  console.log(datas);
              })
         
        });
      
        
        
        $scope.getEmployeeList = function(departmentId){
            console.log("Department ID:"+departmentId);
            console.log("Branch ID:"+$scope.payrolldegeneration.branchId);
            var resultBean={
                    branchId:$scope.payrolldegeneration.branchId,
                    dept:departmentId
                    };
            $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
                  console.log("LoginUseEmployeeList");
                  $scope.employeeList = datas.employeeList;
                  $scope.payrolldegeneration.employeeId='';
                  console.log(datas);
              })
        }
        
        $scope.getMonthYearList = function(){
            
            $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
                  console.log("MonthYearList");
                  $scope.monthYearList = datas.monthYearList;
                  console.log(datas);
              })
        }
        
        $scope.getMonthYearList();
        
        $scope.getSalaryList=function(payrolldegenerationform){ 
        if (new validationService().checkFormValidity(payrolldegenerationform)){
            console.log("Inside getSalaryList");
            $scope.payrolldegeneration.isGenerate=false;
            $scope.payrolldegeneration.isDeGenerate=false;
            var companyId = $scope.payrolldegeneration.companyId;
            var branchId = $scope.payrolldegeneration.branchId;
            var dept = $scope.payrolldegeneration.departmentId;
            if(dept==''){
            	dept=null;   
            }
            var employeeId = $scope.payrolldegeneration.employeeId;
            if(employeeId==''){
                employeeId=null;   
            }
            var monthYear = $scope.payrolldegeneration.monthYear;
            var resultBean = {
                    companyId : companyId,
                    branchId : branchId,
                    dept:dept,
                    monthYear:monthYear,
                    employeeId:employeeId
                }
          console.log("resultbean");
            console.log(resultBean);
           if(employeeId!=null){
            $http.post("payroll/payroll/payrollgeneration/payrolllistbyid",resultBean, { cache: false}).success(function(response) {
                console.log("With Employee Seleceted getSalaryList Response");
                console.log(response);
                if(response.payRollListByEmpId!=null && response.payRollListByEmpId!=""){
                     $scope.payrolldegeneration.isGenerate=true;
                     $scope.payrolldegeneration.isDeGenerate=true;
                     $scope.rowCollection=response.payRollListByEmpId;
                     
                 } else{
                     logger.logError("Payroll is not generated for your filtered employee details!");  
                 }
               }).error(function(data) {
                   console.log(datas);
               });
                }else{
                    $http.post("payroll/payroll/payrollreport/list",resultBean, { cache: false}).success(function(response) {
                        console.log("Without Employee Selected");
                        console.log(response);
                         //console.log(response.salaryList);
                         if(response.payRollList!=null && response.payRollList!=""){
                             $scope.payrolldegeneration.isGenerate=true;
                             $scope.payrolldegeneration.isDeGenerate=true;
                             $scope.rowCollection=response.payRollList;
                             
                         } else{
                             logger.logError("Payroll is not generated for your filtered employee details!");  
                         }
                       }).error(function(data) {
                           console.log(datas);
                       });    
                }
            }else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew(payrolldegenerationform.$validationSummary),5000, 'trustedHtml');
            }
        }
     
       // $scope.getSalaryList();
        
        $scope.degenerate =function(){
            console.log("degenerate");
            var companyId = $scope.payrolldegeneration.companyId;
            var branchId = $scope.payrolldegeneration.branchId;
            var dept = $scope.payrolldegeneration.departmentId;
            var employeeId = $scope.payrolldegeneration.employeeId;
            var monthYear = $scope.payrolldegeneration.monthYear;
            if(dept==''){
            	dept=null;  
            } if(employeeId==''){
                employeeId=null;   
            }
            var resultBean={
                    companyId:companyId,
                    branchId:branchId,
                    dept:dept,
                    employeeId:employeeId,
                    monthYear:monthYear
            }
            
            var resultBean1={
            		dept:dept,
                    employeeCode:employeeId,
                    monthYear:monthYear
            }
            
            if(monthYear!="" && monthYear!=undefined && monthYear!=null){
            $http.post("payroll/payroll/payrollgeneration/degenerate",resultBean).success(function(response) {
               console.log("response");
                console.log(response);
                //console.log(response.payrollList);
                $http.post("payroll/payroll/advance/advanceDegenerate",resultBean1).success(function(data1) {
                    if(data1.success==true){
                        
                    }
                }).error(function(data) {
                    console.log(datas);
                });
                if(response.payrollList!=null && response.payrollList!="" && response.salaryCreated==false && response.salaryExists==false){
                    //$scope.payrolldegeneration.isGenerate=true;
                    $scope.rowCollection=response.payrollList;
                    
                }if(response.success==true){
                    logger.logSuccess("Salary De-generated Successfully!");
                    $scope.payrolldegeneration.isGenerate=false;
                    $scope.payrolldegeneration.isDeGenerate=false;
                    $scope.rowCollection=[];
                    
                }
              }).error(function(data) {
                  console.log(datas);
              });
            }else{
                logger.logError("Month and Year Required!!!!");  
            }
          };
          
          $scope.cancel=function(){
              
              $state.go('app.payroll.payroll.genration.list');
          }
    });
    
