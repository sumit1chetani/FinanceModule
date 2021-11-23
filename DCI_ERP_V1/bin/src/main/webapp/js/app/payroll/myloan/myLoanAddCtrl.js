//define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
    
    //module.registerController('myLoanAddCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope)  {
   	app.controller('myLoanAddCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {
   
           
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
                    loanTypeName:'',
                    departmentId:'',
                    isEdit:false      
             };
            
            
            var loanId = $location.search().loanId;
            if (loanId == undefined) {
                $scope.loantype.isEdit = false;
            } else {
                 console.log("Coming inside else function");
                $http.post('payroll/payroll/loanentry/edit', loanId).success(function(result) {
                    $scope.loantype.isEdit = true;
                        console.log("Resultant Value");
                        console.log(result);
                        if(result.loanEntryListById!=null && result.loanEntryListById!=undefined){
                            $scope.loantype.employeeId=result.loanEntryListById[0].employeeId;  
                            $scope.loantype.employeeName=result.loanEntryListById[0].employeeName; 
                            $scope.loantype.loanId=result.loanEntryListById[0].loanId; 
                            $scope.loantype.loanTypeId=result.loanEntryListById[0].loanTypeId; 
                            $scope.loantype.amount=result.loanEntryListById[0].amount; 
                            $scope.loantype.numberOfInstalments=result.loanEntryListById[0].numberOfInstalments; 
                            $scope.loantype.interestRate=result.loanEntryListById[0].interestRate; 
                            $scope.loantype.deductionAmount=result.loanEntryListById[0].deductionAmount; 
                            $scope.loantype.loanTypeName=result.loanEntryListById[0].loanTypeName; 
                            $scope.loantype.flatOrDiminishing=result.loanEntryListById[0].flatOrDiminishing; 
                            $scope.loantype.deductFromDisplay=result.loanEntryListById[0].deductFromDisplay; 
                            $scope.loantype.status=result.loanEntryListById[0].status; 
                            if($scope.loantype.flatOrDiminishing==1){
                                $scope.loantype.flatOrDiminishing="Flat";
                            }else{
                                if($scope.loantype.flatOrDiminishing==2){
                                    $scope.loantype.flatOrDiminishing="Diminishing";
                                }
                            }if($scope.loantype.status==1){
                                $scope.loantype.status="Pending";
                            }if($scope.loantype.status==2){
                                    $scope.loantype.status="Approved";
                            }if($scope.loantype.status==3){
                                    $scope.loantype.status="Rejected";
                            }if($scope.loantype.status==4){
                                    $scope.loantype.status="Closed";
                            }
                            $scope.getEMICalculation();
                        }
                      

                }).error(function(data) {

                });
            }
            
            $scope.cancel =function(){
                
                $state.go('app.payroll.payroll.myloan.list');
            };
              
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
               };
               

            
            
           
      });

    
