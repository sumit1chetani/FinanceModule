//define([ 'payroll/payroll/payroll' ], function(module) {
'use strict';
	app.controller('monthlyPayrollReportCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

//module.registerController('monthlyPayrollReportCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.departmentList=[];
    $scope.employeeList=[];
    $scope.itemsByPage = 10;
    $scope.isEdit = false;
    $scope.isDisplay= true;
    $scope.isAuthorized=false;
    
    $scope.payrollreport = {
            payComponentName:'',
            amount:'',
            BASIC:'',
            HRA:'',
            DA:'',
            CONVE:'',
            MEDIC:'',
            PFCOM:'',
            PFSEL:'',
            PT:'',
            TDS:'',
            departmentId:'',
            employeeId:'',
            branchId:'',
            companyName:'',
            companyId:'',
            monthYear:'',
            month:'',
            year:'',
            isEdit:false ,
            isOnLoad : false
     };
    $scope.payRollList=[];
    
    $http.get("payroll/payroll/payrollgeneration/getEmployees").success(function(data) {
        $scope.employeeList = data.employeeList;
    });
    
    $scope.getCompanyList = function(){
    	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
				+ 'F0384').success(
		function(datas) {  
      //  $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
              console.log("getCompanyList");
              $scope.companyList = datas;
              if ($scope.companyList.length >= 1) {
                  $scope.payrollreport.companyId = $scope.companyList[0].id;
                  $scope.payrollreport.companyName = $scope.companyList[0].companyName;
              }
              
              console.log(datas);
          })
    }
    
    $scope.$watch('payrollreport.companyId', function(newValue, oldValue) {
        var companyId = newValue;
        if($scope.payrollreport.companyId != '' && $scope.payrollreport.isOnLoad == false){
            $scope.payrollreport.branchId='';
            $scope.payrollreport.branchName='';
        }
           
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
            console.log("getBranchList");
            $scope.branchList = datas.branchList;
            if(datas.branchList.length == 1){
                $scope.payrollreport.branchId=datas.branchList[0].id;
                $scope.payrollreport.branchName=datas.branchList[0].text;
            }
            $scope.payrollreport.isOnLoad=false;
            $scope.payrollreport.departmentId='';
            $scope.departmentList=[];
//            $scope.employeeList=[];
            console.log($scope.branchList);
        })
      });
    
    $scope.getBranchList = function(companyId,branchID){
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                console.log("getBranchList");
                $scope.branchList = datas.branchList;
                console.log(branchID);
                $scope.payrollreport.branchId=branchID;
                $scope.departmentList=[];
//                $scope.employeeList=[];
                console.log($scope.branchList);
            })
      }
   
    
    $scope.$watch('payrollreport.branchId', function(newValue, oldValue) {
        var branchId = newValue;
        $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
            console.log("LoginUseDepartmentList");
            console.log(datas);
            $scope.departmentList = datas.departmentList;
            $scope.payrollreport.departmentId='';
//            $scope.employeeList=[];
     })
     
    });
    
    
    $scope.getDepartment = function(branchId){
        console.log("branchID");
       $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
              console.log("LoginUseDepartmentList");
              console.log(datas);
              $scope.departmentList = datas.departmentList;
              $scope.payrollreport.departmentId='';
//              $scope.employeeList=[];
       })
    }
    
    $scope.getEmployeeDetails = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              console.log("LoginUser");
              console.log(datas);
              $scope.getCompanyList();
              $scope.payrollreport.isOnLoad = true;
              $scope.payrollreport.companyId=datas.companyId;
              $scope.payrollreport.companyName=datas.companyName;
              $scope.payrollreport.branchId=datas.branchId;
              $scope.payrollreport.branchName=datas.branchName;
              //$scope.getBranchList($scope.payrollreport.companyId,datas.branchId);
              $scope.getDepartment(datas.branchId);
              
              
          });
    }
    
    $scope.getEmployeeDetails();
    
    $scope.getEmployeeList = function(departmentId){
        console.log("Department ID:"+departmentId);
        console.log("Branch ID:"+$scope.payrollreport.branchId);
        var resultBean={
                branchId:$scope.payrollreport.branchId,
                dept:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              console.log("LoginUseEmployeeList");
              $scope.employeeList = datas.employeeList;
              $scope.payrollreport.employeeId='';
              console.log(datas);
          })
    }
    
    $scope.$watch('payrollreport.departmentId', function(newValue, oldValue) {
        var departmentId = newValue;
        var branchId =  $scope.payrollreport.branchId;
        console.log("Department ID:"+departmentId);
        console.log("Branch ID:"+branchId);
        var resultBean={
                branchId:branchId,
                dept:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              console.log("LoginUseEmployeeList");
              $scope.employeeList = datas.employeeList;
              $scope.payrollreport.employeeId='';
              console.log(datas);
          })
     
    });
    
    $scope.getPayrollList=function(payrollReportForm){
      if (new validationService().checkFormValidity(payrollReportForm)) {
        var employeeId = $scope.payrollreport.employeeId;
        console.log("Employee ID:"+employeeId);
        var resultBean = {
                employeeId : employeeId
            }
        $http.post("payroll/payroll/payrollreport/monthlyreport",resultBean).success(function(response) {
           console.log("Inside List");
            //console.log(response);
            if(response.monthlyPayRollList!=null && response.monthlyPayRollList!="" && response.monthlyPayRollList!=undefined){
                console.log("monthlyPayRollList");
                console.log(response.monthlyPayRollList);
                $scope.rowCollection =response.monthlyPayRollList;
            }else{
                $scope.rowCollection=[];
            }
        }).error(function(data) {
            console.log(datas);
        });
        
        }else {
            toaster.pop('error', "Please fill the required fields",
                    logger.getErrorHtmlNew(payrollReportForm.$validationSummary),5000, 'trustedHtml');
        }
    }
       // $scope.getPayrollList(); 
});




