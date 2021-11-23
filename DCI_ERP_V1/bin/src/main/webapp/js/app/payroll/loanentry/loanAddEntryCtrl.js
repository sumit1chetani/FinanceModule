//define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
    
    //module.registerController('loanAddEntryCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
    app.controller('loanAddEntryCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

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
        var month = [ {
            id : '01',
            text : 'Jan'
        }, {
            id : '02',
            text : 'Feb'
        }, {
            id : '03',
            text : 'Mar'
        }, {
            id : '04',
            text : 'Apr'
        }, {
            id : '05',
            text : 'May'
        }, {
            id : '06',
            text : 'Jun'
        }, {
            id : '07',
            text : 'Jul'
        }, {
            id : '08',
            text : 'Aug'
        }, {
            id : '09',
            text : 'Sep'
        }, {
            id : '10',
            text : 'Oct'
        }, {
            id : '11',
            text : 'Nov'
        }, {
            id : '12',
            text : 'Dec'
        }, ]
     
     
    
    $scope.monthList = month;
        
        var year = [ {
            id : '2015',
            text : '2015'
        }, {
            id : '2016',
            text : '2016'
        }, {
            id : '2017',
            text : '2017'
        }, {
            id : '2018',
            text : '2018'
        },]
       
       // $scope.yearList = year;
        
        
        //YEAR LIST
        
        
        
        //year list 
        $http.get("payroll/payroll/withhold/yearList").success(function(result) {
            $scope.yearList = result.yearList;
        });
        
        
        $scope.isEdit = false;
        $scope.diminishingEMIList=[];
        
        var loanId = $location.search().loanId;
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
                        $scope.loantype.month=result.loanEntryListById[0].deductFrom.substring(0, 2); 
                        $scope.loantype.year=result.loanEntryListById[0].deductFrom.substring(2, 6); 
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
        
        $scope.cancel =function(){
            $state.go('app.payroll.loanEntry.list');
        };
          

        $scope.getEmployeeName = function(empId){ 
           var resultbean={
                   employeeId:empId
           }
           console.log("resultbean");
           console.log(resultbean);
            $http.post('payroll/payroll/loanentry/getEmployeeId', resultbean).success(function(result) {
            if ((result.loanentry.employeeName=='') || (result.loanentry.employeeName==undefined) || (result.loanentry.employeeName==null)) {
                $scope.loantype.employeeName='';
            } else {   
                $scope.loantype.employeeName = result.loanentry.employeeName;          
            }
        }).error(function(data) {

        });
        };
        
        $scope.getLoanTypeEntries = function(loanTypeId){  
            $http.post('payroll/payroll/loantype/loantypelistbyid', loanTypeId).success(function(result) {
            if ((result=='') || (result==undefined) || (result==null)) {
                logger.logError("Please Select Loan Type Id");
            } else {  
                if(result.loanTypeListById[0].flatOrDiminishing==1){
                    $scope.loantype.flatOrDiminishing = "Flat";   
                }else{
                    $scope.loantype.flatOrDiminishing = "Diminishing";   
                }
              // $scope.loantype.flatOrDiminishing = result.loanTypeListById[0].flatOrDiminishing;    
               $scope.loantype.interestRate = result.loanTypeListById[0].interestRate;   
               $scope.getEMICalculation();
            }
        }).error(function(data) {

        });
        };
        
        $scope.$watch('loantype.loanTypeId', function(newValue, oldValue) {
            var loanTypeId = newValue;
            $http.post('payroll/payroll/loantype/loantypelistbyid', loanTypeId).success(function(result) {
                if ((result=='') || (result==undefined) || (result==null)) {
                    logger.logError("Please Select Loan Type Id");
                } else {  
                    if(result.loanTypeListById[0].flatId==1){
                        $scope.loantype.flatOrDiminishing = "Flat";   
                    }else{
                        $scope.loantype.flatOrDiminishing = "Diminishing";   
                    }
                  // $scope.loantype.flatOrDiminishing = result.loanTypeListById[0].flatOrDiminishing;    
                   $scope.loantype.interestRate = result.loanTypeListById[0].interestRate;   
                   $scope.getEMICalculation();
                }
            }).error(function(data) {

            });
        });
        
        $scope.getEMICalculation=function(){
         console.log("Principal Amount"+$scope.loantype.amount);  
         console.log("Loan Interest Type"+$scope.loantype.flatOrDiminishing);  
         console.log("Interest Rate"+$scope.loantype.interestRate);  
         console.log("No of Month"+$scope.loantype.numberOfInstalments); 
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
         //console.log("TOT INTEREST:"+tot_interest);
         //console.log("PAYABLE:"+payable_amt);
        // console.log("MONTHLY PAYABLE:"+monthly_payable);
         $scope.loantype.totalInterest=Math.round(tot_interest);
         $scope.loantype.payable=Math.round(payable_amt);
         $scope.loantype.deductionAmount=Math.round(monthly_payable);
        } else{
            if($scope.loantype.flatOrDiminishing=='Diminishing'){
                if(N!=0 && N!=""&& N!=null && N!=undefined){
                    var r=Number(R/1200);
                    /*console.log("#####################");
                    console.log("P:"+P);
                    console.log("N:"+N);
                    console.log("R:"+R);
                    console.log("r:"+r);
                    console.log("#####################"); */
                    if(r==0){
                        var emi=0;
                        var emi=P/N;
                    }else{
                        var emi=Math.round(P*r*(Math.pow((1+r),N))/((Math.pow((1+r),N))-1));    
                    }
                   
                    
                    $scope.diminishingEMIList=[];
                    $scope.loantype.deductionAmount=emi;
                for(var i=1;i<=N;i++){
               
                var interest=Math.round(P*R/1200);
                var principal=emi-interest;
                var outstanding=P-principal;
             
                
               /* console.log("Month :"+i);
                console.log("EMI:"+emi);
                console.log("INTEREST:"+interest);
                console.log("PRINCIPAL:"+principal);
                console.log("OUT STANDING:"+outstanding);
                console.log("P VALUE:"+P);*/
                
                $scope.diminishingEMIList.push({"month":"Month-"+i,"amount":P,"emi":emi,"interest":interest,"principal":principal,"outStanding":outstanding});
                P=P-emi+interest;
                //console.log("*********************************************");
                }
               // console.log("Entire List of EMI");
                console.log($scope.diminishingEMIList);
                }
            }
        }
        }
        
        $scope.loanTypeList=[];
        $scope.getloanTypeList = function() {
            $http.get('payroll/payroll/loantype/loantypelist').success(function(response) {
                console.log("Loan Type List");
                console.log(response.activeLoanTypeList);
                $scope.loanTypeList = response.activeLoanTypeList;
            }).error(function(data) {

            });
        };
        $scope.getloanTypeList();
        
        $scope.submit=function(loanEntryForm){
            debugger;
            if (new validationService().checkFormValidity(loanEntryForm)) {
                var isvalid=true;
                var dateObj = new Date();
                var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
                var day = dateObj.getUTCDate();
                var cur_year = dateObj.getUTCFullYear();
                $scope.loantype.status=0;
                var saveData = $scope.loantype;
                var resultBean={
                        employeeId:$scope.loantype.employeeId,
                        loanTypeId:$scope.loantype.loanTypeId,
                        amount:$scope.loantype.amount,
                        numberOfInstalments:$scope.loantype.numberOfInstalments,
                        deductFrom:$scope.loantype.month+$scope.loantype.year,
                        deductionAmount:$scope.loantype.deductionAmount,
                        status:1
                }
                console.log("resultBean")
                 console.log(resultBean);
                if((Number($scope.loantype.year)==cur_year) && (Number($scope.loantype.month)<=cur_month)){
                    isvalid=false;
                    logger.logError("Please Select Month and Year Should be greater than the current Month and Year");    
                }else{
                    if(isvalid){
                    $http.post("payroll/payroll/loanentry/save", resultBean).success(function(result) {
                        console.log("Result From DAO IMPL");
                        console.log(result);
                    if (result == false) {
                        logger.logError("Loan entries are already exists for this employee");  
                        $state.go('app.payroll.payroll.loanEntry.list');
                    }else{ 
                        logger.logSuccess("Loan Entry has been added successfully");   
                        $state.go('app.payroll.payroll.loanEntry.list');
                    }
                    });
                    }
                }
               
            }else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew(loanEntryForm.$validationSummary),5000, 'trustedHtml');
            }
        }
        
        /*$scope.submit=function(loanEntryForm){
            if($scope.loantype.isEdit !=true){
                var isvalid=true;
                var dateObj = new Date();
                var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
                var day = dateObj.getUTCDate();
                var cur_year = dateObj.getUTCFullYear();
                console.log("Current Month:"+cur_month);
                console.log("Current Year:"+cur_year);
                $scope.loantype.status=0;
                console.log("Get DATA LOAN ENTRY:");
                console.log($scope.loantype);
                var saveData = $scope.loantype;
                var resultBean={
                        employeeId:$scope.loantype.employeeId,
                        loanTypeId:$scope.loantype.loanTypeId,
                        amount:$scope.loantype.amount,
                        numberOfInstalments:$scope.loantype.numberOfInstalments,
                        deductFrom:$scope.loantype.month+$scope.loantype.year,
                        deductionAmount:$scope.loantype.deductionAmount,
                        status:1
                }
                if(resultBean.employeeId=="" || resultBean.employeeId==null || resultBean.employeeId==undefined || $scope.loantype.employeeName==""){
                    isvalid=false;
                    logger.logError("Please Enter valid Employee Id");    
                }else if(resultBean.loanTypeId=="" || resultBean.loanTypeId==undefined ||resultBean.loanTypeId==null){
                    isvalid=false;
                    logger.logError("Please Select Loan Type");     
                }else if(resultBean.amount==0 ||resultBean.amount=="" ||resultBean.amount==null ||resultBean.amount==undefined || resultBean.amount<0){
                    isvalid=false;
                    logger.logError("Loan Amount should be greater than 0");     
                }else if(resultBean.numberOfInstalments==0 ||resultBean.numberOfInstalments=="" ||resultBean.numberOfInstalments==null ||resultBean.numberOfInstalments==undefined || resultBean.numberOfInstalments<0){
                    isvalid=false;
                    logger.logError("No. of installments should be greater than 0");     
                }else if($scope.loantype.month=="" ||$scope.loantype.month==null ||$scope.loantype.month==undefined){
                    isvalid=false;
                    logger.logError("Please Select Month");     
                }else if($scope.loantype.year=="" ||$scope.loantype.year==null ||$scope.loantype.year==undefined){
                    isvalid=false;
                    logger.logError("Please Select Year");     
                }else if((Number($scope.loantype.year)==cur_year) && (Number($scope.loantype.month)<=cur_month)){
                    isvalid=false;
                    logger.logError("Please Select Month and Year is greater than the current Month and Year");    
                }
                else{
                 if(isvalid){
                  console.log("Coming Inside Save function");   
                  $http.post("payroll/payroll/loanentry/save", resultBean).success(function(result) {
                      console.log("Result From DAO IMPL");
                      console.log(result);
                  if (result == false) {
                      logger.logError("Loan entries are already exists for this employee");  
                      $state.go('app.payroll.payroll.loanEntry.list');
                  }else{ 
                      logger.logSuccess("Loan Entry has been added successfully");   
                      $state.go('app.payroll.payroll.loanEntry.list');
                  } 
              });
              }   
              }
            }     
        }*/
        
        $scope.reset=function(){
            if(loanId == undefined || loanId == null){
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
                        isEdit:false      
                 };     
            }else{
                console.log("Coming Inside Edit");
                $scope.loantype.loanTypeId='';
                $scope.loantype.amount=0;
                $scope.loantype.flatOrDiminishing='';
                $scope.loantype.numberOfInstalments=0;
                $scope.loantype.interestRate=0;
                $scope.loantype.deductFrom='';
                $scope.loantype.deductionAmount=0;
                $scope.loantype.payable=0;
                $scope.loantype.status=1;
                $scope.loantype.month='';
                $scope.loantype.year='';
            }
              
        }

      $scope.update = function(loanEntryForm) {
      debugger;
      if (new validationService().checkFormValidity(loanEntryForm)) {
          if($scope.loantype.isEdit ==true){
              var isvalid=true;
              var dateObj = new Date();
              var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
              var day = dateObj.getUTCDate();
              var cur_year = dateObj.getUTCFullYear();
              console.log("Current Month:"+cur_month);
              console.log("Current Year:"+cur_year);
              $scope.loantype.status=0;
              console.log("Get DATA LOAN ENTRY:");
              console.log($scope.loantype);
              var saveData = $scope.loantype;
              var resultBean={
                      loanId:$scope.loantype.loanId,
                      employeeId:$scope.loantype.employeeId,
                      loanTypeId:$scope.loantype.loanTypeId,
                      amount:$scope.loantype.amount,
                      numberOfInstalments:$scope.loantype.numberOfInstalments,
                      deductFrom:$scope.loantype.month+$scope.loantype.year,
                      deductionAmount:$scope.loantype.deductionAmount,
                      status:1
              }
              if((Number($scope.loantype.year)==cur_year) && (Number($scope.loantype.month)<=cur_month)){
                  isvalid=false;
                  logger.logError("Please Select Month and Year Should be greater than the current Month and Year");    
              }
              else{
               if(isvalid){
                console.log("Coming Inside Update Function"); 
                $http.post('payroll/payroll/loanentry/update', resultBean).success(function(result) {
                    console.log("Result From DAO IMPL");
                    console.log(result);
                if (result == false) {
                    logger.logError("Sorry Some Error occurred");    
                }else{ 
                    logger.logSuccess("Loan Entry has been updated successfully");   
                    $state.go('app.payroll.loanEntry.list');
                } 
            });
            }   
            }
          }   
          
      }else {
          toaster.pop('error', "Please fill the required fields",
                  logger.getErrorHtmlNew(loanEntryForm.$validationSummary),5000, 'trustedHtml');
      }
      }
    });  
    
    module.registerDirective('phonenumbersOnly', function(logger){
        return {
          require: 'ngModel',
          link: function(scope, element, attrs, modelCtrl) {
             
            modelCtrl.$parsers.push(function (inputValue) {
                var inputValue=modelCtrl.$viewValue;
                if (inputValue == undefined) return '' 
               var transformedInput = inputValue.replace(/[^0-9]/g, ''); 
               if (transformedInput!=inputValue) {
                  modelCtrl.$setViewValue(transformedInput);
                  modelCtrl.$render();
               }else{
                  
               }         
    
               return transformedInput;  
            });
          }
        };
     });

    
