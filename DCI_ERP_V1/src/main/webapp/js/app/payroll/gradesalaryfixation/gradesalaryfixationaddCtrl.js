'use strict';
app.controller('gradesalaryfixationaddCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {
// $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.isAuthorized=false;
    
    $scope.gradePaycomponenet = {
            payComponentName:'',
            amount:'',
            fromdate:'',
            gradeId:'',
            gradeName:'',
            companyId:'',
            companyName:'',
            totalEarnings:'',
            totalDeductions:'',
            isEdit:false
    };
    
    var basic = 40/100;
    var da=20/100;
    var hra=20/100;
    var conv=10/100;
    var medic=10/100;
   
    
    $scope.isEdit = false;
    $scope.earningList=[];
    $scope.deductionList=[];
    $scope.earningDeductionMasterList=[];
    $scope.gradePaycomponenetList=[];
   
    var gradeId = $location.search().gradeId;
    var companyID = $location.search().companyId;
    var fromdate = $location.search().fromdate;
    
   
    $scope.getCompanyList = function(){
        //$http.get("payroll/payroll/payrollgeneration/getCompanyList").success(function(datas) {
    	$http.get($stateParams.tenantid	+ '/app/usermaster/getCompanyList?formCode='
						+ 'F0366')
		.success(
				function(datas) {
    	console.log("getCompanyList");
            $scope.companyList = datas;
            $scope.getEmployeeDetails();
            if(companyID!=undefined && companyID!=null && companyID!=''){
                $scope.gradePaycomponenet.companyId=companyID;
            }
           console.log(datas);
        })
    }

    
    $scope.$watch('gradePaycomponenet.companyId', function(newVal, oldVal) {
        if(newVal!="" && newVal!=undefined){
                $http.post("payroll/payroll/gradepay/getGradeList",newVal).success(function(datas) {
                    $scope.gradeList = datas.gradeList;
                 
            })
            }
     });
    
    $scope.getGradeList = function(companyId){
        $http.post("payroll/payroll/gradepay/getGradeList",companyId).success(function(datas) {
           $scope.gradeList = datas.gradeList;
           if(gradeId!=undefined && gradeId!='' && gradeId!=null){
               $scope.gradePaycomponenet.gradeId=gradeId;
           }
           
        });
    }
    
    $scope.getEmployeeDetails = function(){
        $http.get("payroll/payroll/payrollgeneration/getUserDetail").success(function(datas) {
              console.log("LoginUser");
              console.log(datas);
              if($scope.companyList.length == 1){
                  $scope.gradePaycomponenet.companyId=$scope.companyList[0].companyId;
                  $scope.gradePaycomponenet.companyName=$scope.companyList[0].companyName;
                  $scope.getGradeList($scope.companyList[0].companyId);
              }else{
                  if($scope.companyList.length > 1){
                      if(companyID==undefined || companyID=='' || companyID==null){
                        
                          $scope.gradePaycomponenet.companyId=datas.companyId;
                          $scope.gradePaycomponenet.companyName=datas.companyName;
                          $scope.getGradeList($scope.gradePayComponenet.companyId);
                      }else{
                          $scope.gradePaycomponenet.companyId=companyID;
                          $scope.getGradeList($scope.gradePayComponenet.companyId);
                      }
                  }
                  
             }
             
          })
    }
    
    $scope.getCompanyList();
    
 
    
    if (gradeId == undefined && fromdate == undefined) {
        $scope.gradePaycomponenet.isEdit = false;
    } else {
        if (fromdate!=undefined){ 
                var resultBean={
                        gradeId:gradeId,
                        fromdate:fromdate
                };
                $scope.gradePaycomponenet.isEdit = true;
               
               $http.post('payroll/payroll/gradepay/edit', resultBean).success(function(result) {
                   if (result.isEdit == false) {
                        logger.logError("Please Try Again");
                    } else {
                       if(result.gradePayComList!=null){
                               console.log("resultedit");
                                console.log(result);
                                $scope.gradePaycomponenet.gradeName=result.gradePayComList[0].gradeName;
                                $scope.gradePaycomponenet.gradeId=gradeId;
                                $scope.gradePaycomponenet.fromdate=fromdate;
                                var i=1;
                                angular.forEach(result.gradePayComList, function(value, key){
                                    if(value.payComponentType == "1"){
                                        $scope.earningList.push({"id":i,"select":"YES","payComponentId":value.payComponentId,"payComponentName":value.payComponentName,"value":value.value,"earningValue":value.amount,"percentageAppliedOn":value.percentageAppliedOn});
                                     }else if(value.payComponentType == "2"){
                                         $scope.deductionList.push({"id":i,"select":"YES","payComponentId":value.payComponentId,"payComponentName":value.payComponentName,"value":value.value,"deductionValue":value.amount,"percentageAppliedOn":value.percentageAppliedOn});
                                     }   
                                    i=i+1;   
                                 });
                               
                                $scope.calulateEarningsValue();
                                $scope.calulateDeductionValue();
                              
                        }
                    }
        
                }).error(function(data) {
        
                });
        }  
    }
  
   
    $scope.paycomponenetList=function(){
        $http.get("payroll/payroll/earningdeductionmaster/list")
        .success(function(response) {
            $scope.gradePaycomponenet.gradeId=gradeId;
            var i=1;
            angular.forEach(response.earningDeductionMasterList, function(value, key){
               if(value.payComponentType == "1"){
                   $scope.earningList.push({"id":i,"select":"YES","payComponentId":value.payComponentId,"payComponentName":value.payComponentName,"value":value.value,"earningValue":'',"percentageAppliedOn":value.percentageAppliedOn});
                }else  if(value.payComponentType == "2"){
                   $scope.deductionList.push({"id":i,"select":"YES","payComponentId":value.payComponentId,"payComponentName":value.payComponentName,"value":value.value,"deductionValue":'',"percentageAppliedOn":value.percentageAppliedOn});
                }   
                i=i+1;
            });
        });
    };
    
   
    
   if($scope.gradePaycomponenet.isEdit!=true && fromdate == undefined){
       $scope.paycomponenetList();
       
         
    }
    
  
   var currentdate = new Date();
   var date = "1";
   var month = currentdate.getMonth()+1;
   var year = currentdate.getFullYear();
   var currentDate= date + "/" + month + "/" + year;
   $scope.gradePaycomponenet.fromdate= currentDate;

   $scope.onFrmDateChg= function(firstDay){
       var month = firstDay.getMonth()+1;
       var year = firstDay.getFullYear();
       var date = "1";
       var currentDate= date + "/" + month + "/" + year;
        $scope.gradePaycomponenet.fromdate= currentDate;
        
    }
   
   $scope.getdeductionValue=function(paycomponenetId,earningValue){
        $scope.calulateEarningsValue();
        $scope.calulateDeductionValue();
        
   };

   $scope.getEarningValue=function(earningPayComponentId){
       var earningValue=0;
       angular.forEach($scope.earningList, function(value, key) {
           if(earningPayComponentId==value.payComponentId){
               if(value.earningValue!=undefined && value.earningValue!=null && value.earningValue!=''){
                   earningValue=value.earningValue;
               }
              
           }
       });
       return earningValue;
   }
   
  
  $scope.calulateEarningsValue=function(){
       var totalGrossPay =0;
       angular.forEach($scope.earningList, function(value, key) {
           if(value.earningValue!=undefined && value.earningValue!=null && value.earningValue!=''){
             totalGrossPay=Math.round(Number(totalGrossPay)+Number(value.earningValue));
           }
       });
           $scope.gradePaycomponenet.totalEarnings=totalGrossPay;
  
      
   }
   
   $scope.calulateDeductionValue=function(){
       var totaldeduct =0;
       angular.forEach($scope.deductionList, function(value, key) {
           if(value.deductionValue!=undefined && value.deductionValue!=null && value.deductionValue!=''){
               totaldeduct=Math.round(Number(totaldeduct)+Number(value.deductionValue));
           }
              
        
       });
       $scope.gradePaycomponenet.totalDeductions=Math.round(Number($scope.gradePaycomponenet.totalEarnings)-Number(totaldeduct));
   }
   
    $scope.percentageDeductionCalculation = function(paycomponenetId,earningValue){
        angular.forEach($scope.deductionList, function(value, key) {
            var percentageArray =[];
                 if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                     var percentageArray = value.percentageAppliedOn.split(",");
                 }
                 var totaldeductValue=0;
                 var totalEarningValue=0;
              
                 for(var i=0;i< percentageArray.length;i++){
                   var currentEarningValue=0;
                   currentEarningValue=$scope.getEarningValue(percentageArray[i]);
                   if(currentEarningValue!=undefined && currentEarningValue!=null && currentEarningValue!=''){
                       var deductionValue=value.value/100;
                       deductionValue = currentEarningValue*deductionValue;
                       deductionValue = Math.round(deductionValue);
                       totaldeductValue=totaldeductValue+deductionValue;
                       totalEarningValue=totalEarningValue+currentEarningValue;
                   }
                   
                 
                 }
                 if(value.payComponentId=="PFCOM" || value.payComponentId=="PFSEL"){
                     if(totalEarningValue >=15000){
                         totaldeductValue=1800;
                     }else{
                         if(totalEarningValue < 15000){
                             var percentageValue=value.value/100;
                             totaldeductValue=totalEarningValue*percentageValue;
                             totaldeductValue=Math.round(totaldeductValue);
                         }
                     }
                 }else if(value.payComponentId=="ESI"){
                     if(totalEarningValue > 15000){
                         totaldeductValue=0;
                     }else{
                         if(totalEarningValue <= 15000){
                             var percentageValue=1.75/100;
                             totaldeductValue=totalEarningValue*percentageValue;
                             totaldeductValue=Math.round(totaldeductValue);
                         }
                     }
                     
                 }else{
                     totaldeductValue=totaldeductValue;
                     totaldeductValue=Math.round(totaldeductValue);
                 }
            
            if(totaldeductValue!=undefined && totaldeductValue!=null && totaldeductValue!='' || totaldeductValue==0){
                if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                   if(value.select=="YES"){
                       value.deductionValue=totaldeductValue;
                   }
                    
                }
                
              
            }
       
         });
        
    }
   
    $scope.fixEarningPercentCalculation = function(paycomponenetId,earningValue){
            var percentageArray=[];
            angular.forEach($scope.earningList, function(value, key) {
                if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                     percentageArray = value.percentageAppliedOn.split(",");
                }
                var totalEarningValue=0;
                for(var i=0;i< percentageArray.length;i++){
                    var currentEarningValue=0;
                    currentEarningValue=$scope.getEarningValue(percentageArray[i]);
                    if(currentEarningValue!=undefined && currentEarningValue!=null && currentEarningValue!='' || currentEarningValue==0){
                      var earval=value.value/100;
                      earval = currentEarningValue*earval;
                      totalEarningValue=totalEarningValue+earval;
                      totalEarningValue=Math.round(totalEarningValue);
                      
                  }
                }
                console.log("TotalEarns"+totalEarningValue);
                if(totalEarningValue!=undefined && totalEarningValue!=null && totalEarningValue!='' || totalEarningValue==0){
                    if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                        if(value.select=="YES"){
                            value.earningValue=totalEarningValue;
                        }
                        
                    }
                }
             
               });
      }
    
    $scope.getValue=function(paycomponenetId,earningValue){
        $scope.fixEarningPercentCalculation(paycomponenetId,earningValue);
        $scope.percentageDeductionCalculation(paycomponenetId,earningValue); 
        $scope.calulateEarningsValue();
        $scope.calulateDeductionValue();
       
    };
    
    
    $scope.checkSingleIDBoxEarnsCalculation = function(earningID,percentagOn){
        var percentageArray=[];
        angular.forEach($scope.earningList, function(value, key) {
            if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                 percentageArray = value.percentageAppliedOn.split(",");
            }
            var totalEarningValue=0;
            for(var i=0;i< percentageArray.length;i++){
                var currentEarningValue=0;
                currentEarningValue=$scope.getEarningValue(percentageArray[i]);
                if(currentEarningValue!=undefined && currentEarningValue!=null && currentEarningValue!='' || currentEarningValue==0){
                  var earval=value.value/100;
                  earval = currentEarningValue*earval;
                  totalEarningValue=totalEarningValue+earval;
                  
              }
            }
           
            if(totalEarningValue!=undefined && totalEarningValue!=null && totalEarningValue!='' || totalEarningValue==0){
                if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                   if(earningID!=value.payComponentId){
                       if(value.select=="YES"){
                           value.earningValue=totalEarningValue;
                       }
                        
                    }
                }
            }
         
           });
        $scope.percentageDeductionCalculation(earningID,percentagOn); 
        $scope.calulateEarningsValue();
        $scope.calulateDeductionValue();
   }
    
    $scope.checkingEarningValue=function(earningValue,totalEarnings){
        angular.forEach($scope.earningList, function(value, key){
            if(value.payComponentId==earningValue){
                if(value.select=="YES"){
                    if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                     }else{
                        var id= "performanceId"+value.id;
                        document.getElementById(id).disabled = false;
                    }
                  $scope.getValue(value.payComponentId,value.earningValue);
               } if(value.select=="NO"){
                  value.earningValue=0;
                   if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                       value.earningValue=0;
                       $scope.checkSingleIDBoxEarnsCalculation(value.payComponentId,value.percentageAppliedOn);
                   }else{
                        var id= "performanceId"+value.id;
                        document.getElementById(id).disabled = true;
                       value.earningValue=0;
                       $scope.getValue(value.payComponentId,0);
                   }
               }
          
            }
        });
    }
    
    $scope.checkingDeductionValue=function(deductionValue,totalEarnings){
        angular.forEach($scope.deductionList, function(value, key){
            if(value.payComponentId==deductionValue){
                if(value.select=="YES"){
                  if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                       $scope.checkfixDeductionCalculation(deductionValue,value.percentageAppliedOn);
                    }else{
                        var id= "performanceId"+value.id;
                        document.getElementById(id).disabled = false;
                    }
              } if(value.select=="NO"){
                  if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                  }else{
                      var id= "performanceId"+value.id;
                      document.getElementById(id).disabled = true;
                  }
                    value.deductionValue=0;
                }
              $scope.calulateEarningsValue();
              $scope.calulateDeductionValue();
             }
        });
    }
    
    
    $scope.checkfixDeductionCalculation = function(deductionID,percentagOn){
        angular.forEach($scope.deductionList, function(value, key) {
            var percentageArray =[];
                 if(value.percentageAppliedOn!=null && value.percentageAppliedOn!=undefined && value.percentageAppliedOn!=''){
                     var percentageArray = value.percentageAppliedOn.split(",");
                 }
                 var totaldeductValue=0;
                 var totalEarningValue=0;
                for(var i=0;i< percentageArray.length;i++){
                    var currentEarningValue=0;
                   currentEarningValue=$scope.getEarningValue(percentageArray[i]);
                   if(currentEarningValue!=undefined && currentEarningValue!=null && currentEarningValue!=''){
                       var deductionValue=value.value/100;
                       deductionValue = currentEarningValue*deductionValue;
                       deductionValue = Math.round(deductionValue);
                       totaldeductValue=totaldeductValue+deductionValue;
                       totalEarningValue=totalEarningValue+currentEarningValue;
                   }
                 }
                if(value.payComponentId=="PFCOM" || value.payComponentId=="PFSEL"){
                     if(totalEarningValue >=15000){
                         totaldeductValue=1800;
                     }else{
                         if(totalEarningValue < 15000){
                             var percentageValue=value.value/100;
                             totaldeductValue=totalEarningValue*percentageValue;
                             totaldeductValue=Math.round(totaldeductValue);
                         }
                     }
                 }else if(value.payComponentId=="ESI"){
                     if(totalEarningValue > 15000){
                         totaldeductValue=0;
                     }else{
                         if(totalEarningValue <= 15000){
                             var percentageValue=1.75/100;
                             totaldeductValue=totalEarningValue*percentageValue;
                             totaldeductValue=Math.round(totaldeductValue);
                         }
                     }
                     
                 }else{
                     totaldeductValue=Math.round(totaldeductValue);
                   
                 }
                 if(totaldeductValue!=undefined && totaldeductValue!=null && totaldeductValue!=''){
                     if(deductionID==value.payComponentId){
                         if(value.select=="YES"){
                             value.deductionValue=totaldeductValue;
                         }
                      
                     }
                 }
        }); 
    
       
    }
    
    
       
    $scope.submit=function(gradePaycomponenet,gradesalaryFixation){
        if (new validationService().checkFormValidity(gradesalaryFixation)) {
        var isvalid=true;
        $scope.gradePaycomponenetList=[];
        $scope.iterateEarningObject();
        $scope.iterateDeductionObject();
        var saveData=$scope.gradePaycomponenetList;
        console.log("gradeComponentList");
        console.log($scope.gradePaycomponenetList);
        if($scope.gradePaycomponenet.isEdit!=true){

              if(isvalid){
                  var dateObj = new Date();
                  var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
                   $http.get("payroll/payroll/gradepay/getGradeMaxDate?gradeId="+ $scope.gradePaycomponenet.gradeId).success(function(result) {
                       console.log("new response is");
                       var startsDate = $('#startDate').val();
                       startsDate = startsDate.split("/");
                       var month=startsDate[1];
                       if(result.fromdate!=null){
                           var startDate = $('#startDate').val();
                           startDate = startDate.split("/");
                           startDate = new Date(startDate[2], startDate[1]-1, startDate[0]);
                           var showErrorDate=result.fromdate;
                           var endDate = result.fromdate.split("/");
                           endDate = new Date(endDate[2], endDate[1]-1, endDate[0]);
                           if (startDate > endDate){
                               $http.post("payroll/payroll/gradepay/save", saveData).success(function(result) {
                                   if (result == false) {
                                   }else{
                                      
                                       $location.url('/payroll/gradesalaryfixation/getList?gradeId=' + $scope.gradePaycomponenet.gradeId + '&companyId=' + $scope.gradePaycomponenet.companyId);
                                   }
                                   
                               })
                           }else{
                               logger.logError("From Date Should be greater than the " + showErrorDate);
                           }
                           
                       }else{
                           if(month < cur_month){
                               logger.logError("Please Select Month and  greater than the Previous Month ");    
                               
                            }else{
                           $http.post("payroll/payroll/gradepay/save", saveData).success(function(result) {
                               if (result == false) {
                               }else{
                                 
                                   $location.url('/payroll/gradesalaryfixation/getList?gradeId=' + $scope.gradePaycomponenet.gradeId + '&companyId=' + $scope.gradePaycomponenet.companyId);
                               }
                               
                           })
                            }
                       }        
                       console.log(result);
                        
                    })
                
              }
           }
         
        }else{
            toaster.pop('error', "Please fill the required fields", 
                    logger.getErrorHtmlNew(gradesalaryFixation.$validationSummary), 5000, 'trustedHtml');
        }
    }
    
    
    $scope.update=function(gradePaycomponenet,gradesalaryFixation){
        if (new validationService().checkFormValidity(gradesalaryFixation)) {
        var isvalid=true;
        $scope.gradePaycomponenetList=[];
        $scope.iterateEarningObject();
        $scope.iterateDeductionObject();
        var saveData=$scope.gradePaycomponenetList;
        console.log("updatedata");
        console.log(saveData);
       
            if(isvalid){
                
            $http.get("payroll/payroll/gradepay/getGradeMaxDate?gradeId="+ $scope.gradePaycomponenet.gradeId).success(function(result) {
                console.log("new response is");
                console.log(result.fromdate);
                if(result.fromdate!=null){
                    var startDate = $('#startDate').val();
                    startDate = startDate.split("/");
                    startDate = new Date(startDate[2], startDate[1], startDate[0]);
                    var showErrorDate = result.fromdate;
                    var endDate = result.fromdate.split("/");
                    endDate = new Date(endDate[2], endDate[1], endDate[0]);
                    if (startDate >= endDate){
                        $http.post("payroll/payroll/gradepay/update", saveData).success(function(result) {
                            if (result == false) {
                            }else{
                                 $location.url('/payroll/gradesalaryfixation/getList?gradeId=' + $scope.gradePaycomponenet.gradeId + '&companyId=' + $scope.gradePaycomponenet.companyId);
                            }
                            
                        });
                    }else{
                        logger.logError("From Date Should be greater than or equal to the " + showErrorDate);
                    }
              
            }else{
                $http.post("payroll/payroll/gradepay/update", saveData).success(function(result) {
                    if (result == false) {
                    }else{
                        $location.url('/payroll/gradesalaryfixation/getList?gradeId=' + $scope.gradePaycomponenet.employeeId + '&companyId=' + $scope.gradePaycomponenet.companyId);
                    }
                    
                })
            } 
                
                
          });
        }    
    }else{
        toaster.pop('error', "Please fill the required fields", 
                logger.getErrorHtmlNew(gradesalaryFixation.$validationSummary), 5000, 'trustedHtml');
    }
    
    }
    
    
    $scope.applySalary=function(){
       var resultBean={
                fromdate:$scope.gradePaycomponenet.fromdate,
                gradeId:$scope.gradePaycomponenet.gradeId
              
        };
        console.log("salaryapplyresultBean");
        console.log(resultBean);
        $http.post("payroll/payroll/gradepay/generateGradeSalary", resultBean).success(function(result) {
           console.log("response");
           console.log(result);
           if(result.salaryCreated==true && result.salaryExists==false){
               logger.logSuccess("Salary Created Successfully");
             
           }else{
               if(result.salaryCreated==false && result.salaryExists==true){
                   logger.logError("Salary Already Exists !!!");
               }
           }
           
        });
        
    }
    
    
    $scope.iterateDeductionObject=function(){
        var i=1;
        angular.forEach($scope.deductionList, function(value, key) {
            if(value.deductionValue==undefined || value.deductionValue=='' || value.deductionValue==0 || value.deductionValue==null){
                value.deductionValue=0;
            }
            $scope.gradePaycomponenetList.push({"id":i,"select":"YES","payComponentId":value.payComponentId,"amount":value.deductionValue,"fromdate":$scope.gradePaycomponenet.fromdate,"gradeId":$scope.gradePaycomponenet.gradeId});
            
        });
        i=i+1;
       
    }
    
    $scope.iterateEarningObject=function(){
        var i=1;
        angular.forEach($scope.earningList, function(value, key) {
            if(value.earningValue==undefined || value.earningValue=='' || value.earningValue==0 || value.earningValue==null){
                value.earningValue=0;
            }
           
                $scope.gradePaycomponenetList.push({"id":i,"select":"YES","payComponentId":value.payComponentId,"amount":value.earningValue,"fromdate":$scope.gradePaycomponenet.fromdate,"gradeId":$scope.gradePaycomponenet.gradeId});
            
        });
        i=i+1;
    }
    
    // Function to reset valkue
    
    $scope.resetDeductionList=function(){
        angular.forEach($scope.deductionList, function(value, key) {
            value.deductionValue='';
        });
       
    }
    
    $scope.resetEarningList=function(){
        angular.forEach($scope.earningList, function(value, key) {
            value.earningValue='';
        });
    
    }
    
    
    $scope.cancel=function(){
        $state.go('app.payroll.gradesalaryfixation.list');
    };
 
  
 // Function to change deduction value
   
    $scope.fixDeductionCalculation = function(paycomponenetId,earningValue){
        angular.forEach($scope.deductionList, function(value, key) {
            if(paycomponenetId==value.percentageAppliedOn){
                 var deductionValue=value.value/100;
                 deductionValue = earningValue*deductionValue;
                 deductionValue = Math.round(deductionValue);
                 value.deductionValue=deductionValue;
                
             }
         });
    
    }
    
  // Function to fix all the earning value
    
    $scope.fixEarningCalculation = function(totalEarningsValue){
        angular.forEach($scope.earningList, function(value, key) {
            if(value.payComponentId=="BASIC"){
                value.earningValue=Math.round(totalEarningsValue*basic);
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
            } if(value.payComponentId=="DA"){
                value.earningValue=Math.round(totalEarningsValue*da);
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
            } if(value.payComponentId=="HRA"){
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
                value.earningValue=Math.round(totalEarningsValue*hra);
            } if(value.payComponentId=="CONVE"){
                value.earningValue=Math.round(totalEarningsValue*conv);
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
            } if(value.payComponentId=="MEDIC"){
                value.earningValue=Math.round(totalEarningsValue*medic);
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
            }
        });
        
        $scope.calulateDeductionValue();
        
   };
    
  
    
    
 // Function to fix net pay value
    
    $scope.fixNetSalaryCalculation = function(totalSalary){
        
        var totalEarningsValue=totalSalary/0.904;
        console.log(totalEarningsValue);
        angular.forEach($scope.earningList, function(value, key) {
            if(value.payComponentId=="BASIC"){
                value.earningValue=Math.round(totalEarningsValue*basic);
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
            } if(value.payComponentId=="DA"){
                value.earningValue=Math.round(totalEarningsValue*da);
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
            } if(value.payComponentId=="HRA"){
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
                value.earningValue=Math.round(totalEarningsValue*hra);
            } if(value.payComponentId=="CONVE"){
                value.earningValue=Math.round(totalEarningsValue*conv);
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
            } if(value.payComponentId=="MEDIC"){
                value.earningValue=Math.round(totalEarningsValue*medic);
                $scope.fixDeductionCalculation(value.payComponentId,value.earningValue);
            }
        });
        
        $scope.calulateEarningsValue();
    };
    
    $scope.reset = function(earningDeductionForm) {
        if($scope.gradePaycomponenet.isEdit !=true){
            $scope.gradePaycomponenet.totalDeductions='';
            $scope.gradePaycomponenet.totalEarnings='';
            $scope.resetDeductionList();
            $scope.resetEarningList();
            
        }else{
            $scope.gradePaycomponenet.totalDeductions='';
            $scope.gradePaycomponenet.totalEarnings='';
            $scope.resetDeductionList();
            $scope.resetEarningList();
           
        }
    }
    
    



    
});