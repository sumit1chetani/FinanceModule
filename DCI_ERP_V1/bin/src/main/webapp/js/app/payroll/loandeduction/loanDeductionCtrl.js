//define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
    
    //module.registerController('loanDeductionCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
   	app.controller('loanDeductionCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay=true;
        $scope.loanDeductionList=[];
        
        $scope.deduction = {
                month:'',
                year:'',
                loanId:'',
                monthYear:'',
                amount:0,
                loanTypeId:'',
                loanTypeName:'',
                employeeId:'',
                employeeName:'',
                deductionAmount:0  
         };
        
        var temp = [ {
            id : '01',
            text : 'January'
        }, {
            id : '02',
            text : 'February'
        }, {
            id : '03',
            text : 'March'
        }, {
            id : '04',
            text : 'April'
        }, {
            id : '05',
            text : 'May'
        }, {
            id : '06',
            text : 'June'
        }, {
            id : '07',
            text : 'July'
        }, {
            id : '08',
            text : 'August'
        }, {
            id : '09',
            text : 'September'
        }, {
            id : '10',
            text : 'October'
        }, {
            id : '11',
            text : 'November'
        }, {
            id : '12',
            text : 'December'
        }, ]
     
        $scope.getFinancialYear = function(){
            
            $http.get("payroll/tds/ptslab/financialYear").success(function(datas) {
                  console.log("financialYear");
                  console.log(datas);
                  $scope.financialYearList = datas.financialYearList;
                 
              })
        }
        
        $scope.getFinancialYear();
        
 $scope.getMonthYearList = function(){
            
            $http.get("payroll/payroll/payrollgeneration/getMonthYearList").success(function(datas) {
                  console.log("MonthYearList");
                  $scope.monthYear = datas.monthYearList;
                  console.log(datas);
              })
        }
        
        $scope.getMonthYearList();
        
        $scope.monthList = temp;
        
        $scope.deduction.isDeducted=false;
        $scope.deduction.isTobededucted=false;
        
        $scope.chkAll=false;
        $scope.checkAll = function (rowCollection,checkBox) {
            if (checkBox) {
                $scope.chkAll=true;
            } else {
                $scope.chkAll = false;
            }
            
            angular.forEach($scope.rowCollection, function (loanlist) {
                loanlist.checkbox = $scope.chkAll;
            });
            
        };
        
        $scope.$watch('deduction.monthYear', function(newValue, oldValue) {
            var monthYear = newValue;   
            
            console.log("Month Year:"+ monthYear);
            if(monthYear!="" && monthYear!=null){
                $http.post("payroll/payroll/loanrepayment/todeductedlist", monthYear)
                .success(function(response) {
                    console.log("getTobeDeductedList");
                  //  console.log(response);
                    console.log(response.loanTobeDeductedList);
                    if(response.loanTobeDeductedList.length>0){
                        $scope.rowCollection = response.loanTobeDeductedList;
                        $scope.loanDeductionList = response.loanTobeDeductedList;
                        $scope.deduction.monthYr=response.loanTobeDeductedList[0].monthYear; 
                        $scope.deduction.isDeducted=false;
                        $scope.deduction.isTobededucted=true;
                    }else{
                        $scope.rowCollection=[];
                        $scope.deduction.isDeducted=false;
                        $scope.deduction.isTobededucted=false;   
                    }
                   
                });    
            }
            
            
        });
        
        $scope.getDeductedList = function(vesselMasterForm){
          //  if (new validationService().checkFormValidity($scope.vesselMasterForm)) {
            var isvalid=true;
          //  $scope.deduction.monthYear=$scope.deduction.month+$scope.deduction.year;
            console.log("Month Year:"+ $scope.deduction.monthYear);
            $http.post("payroll/payroll/loanrepayment/deductedlist", $scope.deduction.monthYear)
            .success(function(response) {
                console.log("Coming inside getDeductedList");
                console.log(response);
                console.log(response.loanDeductedList);
                if(response.loanDeductedList.length>0){
                    $scope.rowCollection = response.loanDeductedList;
                    $scope.deduction.monthYr=response.loanDeductedList[0].monthYear;
                    $scope.deduction.isTobededucted=false; 
                    $scope.deduction.isDeducted=true;
                }else{
                    $scope.deduction.isTobededucted=false; 
                    $scope.deduction.isDeducted=false;  
                    $scope.rowCollection=[];
                }
               
            });
          /*   }else {
                 toaster.pop('error', "Please fill the required fields", 
                         logger.getErrorHtmlNew($scope.vesselMasterForm.$validationSummary), 555000, 'trustedHtml');
             } */
            }
        
        
        
        $scope.getTobeDeductedList = function(vesselMasterForm){
           // if (new validationService().checkFormValidity($scope.vesselMasterForm)) {
            var isvalid=true;
                // $scope.deduction.monthYear=$scope.deduction.month+$scope.deduction.year;
                 console.log("Month Year:"+ $scope.deduction.monthYear);
                 $http.post("payroll/payroll/loanrepayment/todeductedlist", $scope.deduction.monthYear)
                 .success(function(response) {
                     console.log("getTobeDeductedList11111111");
                   //  console.log(response);
                     console.log(response.loanTobeDeductedList);
                     if(response.loanTobeDeductedList.length>0){
                         $scope.rowCollection = response.loanTobeDeductedList;
                         $scope.loanDeductionList = response.loanTobeDeductedList;
                         $scope.deduction.monthYr=response.loanTobeDeductedList[0].monthYear; 
                         $scope.deduction.isDeducted=false;
                         $scope.deduction.isTobededucted=true;
                     }else{
                         $scope.rowCollection=[];
                         $scope.deduction.isDeducted=false;
                         $scope.deduction.isTobededucted=false;   
                     }
                    
                 });
           /*  } else {
                 toaster.pop('error', "Please fill the required fields", 
                         logger.getErrorHtmlNew($scope.vesselMasterForm.$validationSummary), 555000, 'trustedHtml');
             }  */
            }
           
        
        $scope.deductLoan=function(){
        console.log("Inside Loan Deduction List");    
        console.log( $scope.loanDeductionList);
        $scope.loanDeductionListChecked=[];
        angular.forEach($scope.loanDeductionList, function(value, key){
            if(value.checkbox==true){
                $scope.loanDeductionListChecked.push({
                    amount:value.amount,
                    currentEmiNo:value.currentEmiNo,
                    deductionAmount:value.deductionAmount,
                    employeeId:value.employeeId,
                    employeeName:value.employeeName,
                    loanId:value.loanId,
                    loanTypeId:value.loanTypeId,
                    monthYear:value.monthYear,
                    totalEmi:value.totalEmi
                    });     
            }

        });
        console.log("Inside Loan Deduction List - Checked");    
        console.log( $scope.loanDeductionListChecked);
        
       if($scope.loanDeductionListChecked.length>0){
        $http.post("payroll/payroll/loanrepayment/deductloan",$scope.loanDeductionListChecked).success(function(response) {
            if (response == false) {
                logger.logError("Sorry some error occurred!");   
            }else{
                console.log("response is");
                console.log(response);
                logger.logSuccess("Loan Amount has been deducted");
                
                $scope.getTobeDeductedList();
                $scope.chkAll=false;
                
              //  $scope.getDeductedList();
                //$location.url('/payroll/payroll/employeebonus/list');
            }

        });
        } else{
            logger.logError("Please check the checkbox employees loan has to be deducted!");     
        } 
        }
        
        $scope.editRow=function(loanId){
            $location.url('/payroll/payroll/loanapproval/edit?loanId=' + loanId);
        };
        
        
        
    //});
    
});