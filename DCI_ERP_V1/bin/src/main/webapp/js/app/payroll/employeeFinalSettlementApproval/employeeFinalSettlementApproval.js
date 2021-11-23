'use strict';
//module.registerController('employeeFinalSettlementApprovalCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
  
	app.controller('employeeFinalSettlementApprovalCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

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
    
    $scope.employeeFinalSettlement = {
            departmentId:'',
            companyId:'',
            companyName:'',
            branchName:'',
            departmentName:'',
            branchId:'',
            amount:'',
            employeeName:'',
            employeeId:'',
            monthYear:'',
            createdDate:'',
            isEdit:false , 
            isOnLoad : false,
            tables:[],
            detailbean:[]
     };
    
    
    $scope.date = '';
    
    $scope.isList=false;
    
    $scope.totalCredit=0;
    $scope.totalDebit=0;
    $scope.grandTotal=0;
    
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();

    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }

    var today = dd + '/' + mm + '/' + yyyy;
    $scope.date = today;
    
        $scope.submit = function(employeeFinalSettlementForm){
            if (new validationService().checkFormValidity(employeeFinalSettlementForm)){
                $scope.getListValue($scope.employeeFinalSettlement.employeeId);
            }else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew(employeeFinalSettlementForm.$validationSummary),5000, 'trustedHtml');
            }
        }
        
        $scope.getListValue=function(employeeId){
            var resultbean={
                    employeeId:employeeId
             }
            $http.post("payroll/payroll/finalsettlement/list",resultbean).success(function(datas) {
                if(datas.fullFinalSettlementList.length > 0){
                    $scope.isList=true;
                    $scope.employeeFinalSettlement.tables=[];
                    $scope.totalDebit=0;
                    $scope.totalCredit=0;
                    $scope.grandTotal=0;
                    $scope.loadTable();
                    $scope.employeeFinalSettlement.tables[0].storeTableRow=datas.fullFinalSettlementList[0].detailList;
                    if(datas.fullFinalSettlementList[0].status=="Approved"){
                            $scope.isList=false;
                     }
                   
                    $scope.calculateTotal();
                }else{
                    $scope.employeeFinalSettlement.tables=[];
                    logger.logError("No Records Found");
                    $scope.isList=false;
                  
                }
                
              })
           
        }
        
        
        $scope.isNaNCheck = function(value){
            if(isNaN(value)){
                value=0;
            }
            return value;
        }
        $scope.calculateTotal = function(){
            $scope.totalDebit=0;
            $scope.totalCredit=0;
            $scope.grandTotal=0;
            angular.forEach( $scope.employeeFinalSettlement.tables[0].storeTableRow, function(value, index) {
                $scope.totalCredit= Number($scope.totalCredit)+Number($scope.isNaNCheck(value.credit));
                $scope.totalDebit=Number($scope.totalDebit)+Number($scope.isNaNCheck(value.debit));
                $scope.totalCredit=$scope.totalCredit.toFixed(2);
                $scope.totalDebit=$scope.totalDebit.toFixed(2);
            });
            $scope.grandTotal=Number($scope.totalCredit)-Number($scope.totalDebit);
            $scope.grandTotal=$scope.grandTotal.toFixed(2);
            
        }
        
        
        $scope.save = function(employeeFinalSettlementForm){
            if (new validationService().checkFormValidity(employeeFinalSettlementForm)){
               var resultbean={
                       employeeId:$scope.employeeFinalSettlement.employeeId,
                       approvedDate:$scope.date,
                       detailList:$scope.employeeFinalSettlement.tables[0].storeTableRow
               }
               $http.post("payroll/payroll/finalsettlement/approve",resultbean).success(function(datas) {
                   if(datas==true){
                       $scope.getListValue($scope.employeeFinalSettlement.employeeId);
                       logger.logSuccess("Record Saved Successfully")
                   }else{
                       logger.logError("Error Please Try again later!")
                   }
                   
                 })
           }else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew(employeeFinalSettlementForm.$validationSummary),5000, 'trustedHtml');
            }
          
          
    }
    
  
    
    $scope.getCompanyList = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
              $scope.companyList = datas.companyList;
              
              if ($scope.companyList.length == 1) {
                  $scope.employeeFinalSettlement.companyId = $scope.companyList[0].id;
                  $scope.employeeFinalSettlement.companyName = $scope.companyList[0].companyName;
              }
          })
    }
    
    $scope.$watch('employeeFinalSettlement.companyId', function(newValue, oldValue) {
        var companyId = newValue;
        if($scope.employeeFinalSettlement.companyId != '' && $scope.employeeFinalSettlement.isOnLoad == false){
            $scope.employeeFinalSettlement.branchId='';
            $scope.employeeFinalSettlement.branchName='';
        }
            
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                if($scope.branchList.length==1){
                    $scope.employeeFinalSettlement.branchId=$scope.branchList[0].id;
                    $scope.employeeFinalSettlement.branchName=$scope.branchList[0].text;
                }
                $scope.employeeFinalSettlement.isOnLoad=false;
                $scope.employeeFinalSettlement.departmentId='';
                $scope.departmentList=[];
                $scope.employeeList=[];
            })
    
    });
    
    $scope.getBranchList = function(companyId,branchID){
        $http.post("payroll/payroll/payrollgeneration/getBranchList",companyId).success(function(datas) {
                $scope.branchList = datas.branchList;
                $scope.employeeFinalSettlement.branchId=branchID;
                $scope.departmentList=[];
                $scope.employeeList=[];
                $scope.employeeFinalSettlement.departmentId='';
                $scope.employeeFinalSettlement.employeeId='';
                
            })
      }
   
    $scope.$watch('employeeFinalSettlement.branchId', function(newValue, oldValue) {
        var branchId = newValue;
        $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
               $scope.departmentList = datas.departmentList;
               $scope.employeeFinalSettlement.departmentId='';
               $scope.employeeList=[];
        })
     
    });
  
    $scope.getDepartment = function(branchId){
       
       $http.post("payroll/payroll/payrollgeneration/getDepartmentList",branchId).success(function(datas) {
              $scope.departmentList = datas.departmentList;
              $scope.employeeFinalSettlement.departmentId='';
              $scope.employeeFinalSettlement.employeeId='';
              $scope.employeeList=[];
       })
    }
    
   
    $scope.getEmployeeDetails = function(){
        
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              $scope.getCompanyList();
              $scope.employeeFinalSettlement.isOnLoad=true;
              $scope.employeeFinalSettlement.companyId=datas.companyId;
              $scope.employeeFinalSettlement.companyName=datas.companyName;
              $scope.getBranchList($scope.employeeFinalSettlement.companyId,datas.branchId);
              $scope.employeeFinalSettlement.branchName=datas.branchName;
              $scope.getDepartment(datas.branchId);
              
          })
    }
    
    
    $scope.getEmployeeList = function(departmentId){
        var resultBean={
                branchId:$scope.employeeFinalSettlement.branchId,
                dept:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              $scope.employeeList = datas.employeeList;
              $scope.employeeFinalSettlement.employeeId='';
          })
    }
    
    $scope.getEmployeeDetails();
   
    $scope.$watch('employeeFinalSettlement.departmentId', function(newValue, oldValue) {
        var departmentId = newValue;
        var branchId =  $scope.employeeFinalSettlement.branchId;
        var resultBean={
                branchId:branchId,
                dept:departmentId
                };
        $http.post("payroll/payroll/payrollgeneration/getEmployeeList",resultBean).success(function(datas) {
              $scope.employeeList = datas.employeeList;
              $scope.employeeFinalSettlement.employeeId='';
          })
     
    });
    
     //load table
     $scope.loadTable = function() {
         var table = {};

         table.storeTableRow = [ {
             slNo : 1,
             credit:'',
             debit:'',
             description:''
         } ];
         
         $scope.employeeFinalSettlement.tables.push(table);
     }
    
     
     
     $scope.addRow = function(tables) {
         var len = tables.storeTableRow.length+1;
         var table ={
                 slNo : len,
                 credit:'',
                 debit:'',
                 description:''

             } ;

         tables.storeTableRow.push(table);

     };

     //remove Row
     $scope.removeRow = function(table) {
         $scope.tablerow = [];
         
         angular.forEach(table.storeTableRow, function(storeTableRow, index) {
            if (storeTableRow.isselect == false || storeTableRow.isselect==undefined || storeTableRow.isselect=="") {
                 $scope.tablerow.push(storeTableRow);
             }else {
                 
             }
         });
         table.storeTableRow = $scope.tablerow;
     };


    
});