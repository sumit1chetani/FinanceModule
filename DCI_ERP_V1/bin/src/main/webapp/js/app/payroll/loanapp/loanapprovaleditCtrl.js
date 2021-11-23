//define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';

   	app.controller('loanapprovaleditCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

    //module.registerController('loanapprovaleditCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
     
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay=true;
        
        
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
                status:'',
                month:'',
                year:'',
                deductFromDisplay:'',
                approvedOn:'',
                approvedBy:'',
                loanTypeName:'',
                departmentId:'',
                isEdit:false      
         };
        
        
        var loanId = $location.search().loanId;
        var employeeId;
        if (loanId == undefined) {
            $scope.loantype.isEdit = false;
        } else {
             console.log("Coming inside else function");
            $http.post('payroll/payroll/loanentry/edit', loanId).success(function(result) {
                    console.log("Resultant Value");
                    console.log(result);
                    if(result.loanEntryListById!=null && result.loanEntryListById!=undefined){
                        $scope.loantype.isEdit = true;
                        $scope.loantype.employeeId=result.loanEntryListById[0].employeeId;  
                        $scope.loantype.employeeName=result.loanEntryListById[0].employeeName; 
                        $scope.loantype.loanId=result.loanEntryListById[0].loanId; 
                        $scope.loantype.loanTypeId=result.loanEntryListById[0].loanTypeId; 
                        $scope.loantype.amount=result.loanEntryListById[0].amount; 
                        $scope.loantype.numberOfInstalments=result.loanEntryListById[0].numberOfInstalments; 
                        $scope.loantype.interestRate=result.loanEntryListById[0].interestRate; 
                        $scope.loantype.deductionAmount=result.loanEntryListById[0].deductionAmount; 
                        $scope.loantype.deductFrom=result.loanEntryListById[0].deductFrom; 
                        $scope.loantype.loanTypeName=result.loanEntryListById[0].loanTypeName; 
                        $scope.loantype.deductFromDisplay=result.loanEntryListById[0].deductFromDisplay; 
                        $scope.loantype.flatOrDiminishing=result.loanEntryListById[0].flatOrDiminishing; 
                        $scope.loantype.status=result.loanEntryListById[0].status; 
                        if($scope.loantype.flatOrDiminishing==1){
                            $scope.loantype.flatOrDiminishing="Flat";
                        }else{
                            if($scope.loantype.flatOrDiminishing==2){
                                $scope.loantype.flatOrDiminishing="Diminishing";
                            }
                        }
                        if(result.loanEntryListById[0].flatOrDiminishing==1){
                            $scope.loantype.flatOrDiminishing='Flat';
                        }else{
                            $scope.loantype.flatOrDiminishing='Diminishing';    
                        }
                        $scope.getEMICalculation();  
                    }
            }).error(function(data) {

            });
        }
        
        
        $scope.getEMICalculation=function(){
           
            var P=Number($scope.loantype.amount);
            var N=Number($scope.loantype.numberOfInstalments);
            var R=Number($scope.loantype.interestRate);
            if($scope.loantype.flatOrDiminishing=='Flat'){
            var tot_interest=Number(P*N*R/1200);
            var payable_amt=Number(P+tot_interest);
            var monthly_payable=0;
            if(N!=0 && N!=""&& N!=null && N!=undefined){
            monthly_payable = Number((P+tot_interest)/N); 
            }
         
            $scope.loantype.totalInterest=Math.round(tot_interest);
            $scope.loantype.payable=Math.round(payable_amt);
            $scope.loantype.deductionAmount=Math.round(monthly_payable);
           } else{
               if($scope.loantype.flatOrDiminishing=='Diminishing'){
                   if(N!=0 && N!=""&& N!=null && N!=undefined){
                       var r=Number(R/1200);
                     
                       if(r==0){
                           var emi=0;    
                       }else{
                           var emi=Math.round(P*r*(Math.pow((1+r),N))/((Math.pow((1+r),N))-1));    
                       }
                      
                       
                       $scope.diminishingEMIList=[];
                       $scope.loantype.deductionAmount=emi;
                   for(var i=1;i<=N;i++){
                  
                   var interest=Math.round(P*R/1200);
                   var principal=emi-interest;
                   var outstanding=P-principal;
                   $scope.diminishingEMIList.push({"month":"Month-"+i,"amount":P,"emi":emi,"interest":interest,"principal":principal,"outStanding":outstanding});
                   P=P-emi+interest;
                 
                   }
                
                   console.log($scope.diminishingEMIList);
                   }
               }
           }
           }
        $scope.cancel=function(){
            $state.go('app.payroll.payroll.loanapproval.list');
        };
        
        $scope.getEmployeeDetails = function(){
            
            $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
                  console.log("LoginUser");
                  console.log(datas);
                  employeeId= datas.loginUserEmpId;
             })
        }
        
        $scope.getEmployeeDetails();
        
        $scope.update = function() {
            var loanId= $scope.loantype.loanId;
            var today =new Date();
            var month = today.getMonth()+1;
            var currentDate=today.getDate()+"/"+month+"/"+today.getFullYear();
           
            var resultbean={
                    approvedOn:currentDate,
                    approvedBy:employeeId,
                    loanId:$scope.loantype.loanId,
                    status:$scope.loantype.status
            }
           
            console.log("update");
            console.log(resultbean);
            var updateData = resultbean;
            $http.post('payroll/payroll/loanentry/approvalupdate', updateData).success(function(result) {
                    console.log("resultupdate");
                    console.log(result);
                    if (result == false) {
                        
                    } else {
                        logger.logSuccess("reimbursement request updated successfully");
                        $state.go('app.payroll.payroll.loanapproval.list');
                    }
                });
           
        }   
        
        
    });
    
