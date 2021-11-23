
    'use strict';
   	app.controller('advanceAddCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

    //module.registerController('advanceAddCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
        
        $scope.advance = {
                advanceCode:'',
                employee:'',
                employeeName:'',
                employeeCode:'',
                designation:'',
                joinDate:'',
                workingYear:'',
                description:'',  
                amount:0,
                disbursementDate:'',
                openingBalance:0,
                installmentPaid:0,
                recoverytype:'',
                installmentAmount:0,
                month:'',
                year:'',
                startDate:'',
                numberOfInstallments:'',
                isEdit:false ,
                balanceAmount:''
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
        }, {
            id : '2019',
            text : '2019'
        },
        {
            id : '2020',
            text : '2020'
        }
        ]
        
       
     
        //year list 
        $http.get("payroll/payroll/withhold/yearList").success(function(result) {
            $scope.yearList = result.yearList;
        })
     //   $scope.yearList = year;
        
        var recovery = [ {
            id : '1',
            text : 'Monthly'
        }, {
            id : '2',
            text : 'Quarterly'
        }, {
            id : '3',
            text : 'Half Yearly'
        }, {
            id : '4',
            text : 'Yearly'
        },]
        
        
        $scope.emp = [ {
            id : 'text',
            text : '---select Employee---'
        }]
        
        
        
        $scope.recoveryList = recovery;
        $scope.employeeList = [];
        
        $http.get("payroll/payroll/advance/employeeList").success(function(result) {
            if( $scope.advance.isEdit == false){
            
            $scope.employeeList=$scope.emp;
            for(var i=0;i<result.employeeList.length;i++){

                $scope.employeeList.push(result.employeeList[i]);
            

            }
            $scope.advance.employee='text';
            }else{
                $scope.employeeList=result.employeeList;
            }
                
            
            
        })
        
   
        
        
/*        var currentDate = new Date();
        currentDate = ('0' + currentDate.getDate()).slice(-2) + "/" + ('0' + (Number(currentDate.getMonth()) + 1)).slice(-2) + "/" + currentDate.getFullYear();
//        $scope.advance.disbursementdate = currentDate;
        
        $scope.$watch('advance.disbursementdate', function(newValue, oldValue) {
            var newValue = $scope.advance.disbursementdate;
            var date = newValue.substring(0, 2);
            var month = newValue.substring(3, 5);
            var year = newValue.substring(6, 10);
            var newValue = new Date(year, month - 1, date);
            var today = new Date();
    
            if(newValue > today){
                $scope.advance.disbursementdate = '';
              logger.logError("Date Cannot be greater than Current Date");
      }

         })*/
        
        $scope.isEdit = false;
        $scope.diminishingEMIList=[];
        
        var advanceCode = $location.search().advanceCode;
        if (advanceCode == undefined) {
            $scope.advance.isEdit = false;
        } else {
             console.log("Coming inside else function");
            $http.get('payroll/payroll/advance/advanceEdit?advanceCode='+ advanceCode).success(function(result) {
                debugger
                   
                        $scope.advance.isEdit = true;
                   //    $scope.advance.balanceAmountReturn=result.advanceList[0].balanceAmountReturn;  
                        $scope.advance.advanceCode=result.advanceList[0].advanceCode;  
                        $scope.advance.employee=result.advanceList[0].employee;  
                        $scope.advance.description=result.advanceList[0].description; 
                        $scope.advance.amount=result.advanceList[0].amount; 
                        $scope.advance.disbursementDate=result.advanceList[0].disbursementDate; 
                        $scope.advance.openingBalance=result.advanceList[0].openingBalance; 
                        $scope.advance.installmentPaid=result.advanceList[0].installmentPaid; 
                        $scope.advance.recoverytype=result.advanceList[0].recoverytype; 
                        $scope.advance.installmentAmount=result.advanceList[0].installmentAmount; 
                        $scope.advance.deductFrom=result.advanceList[0].deductFrom; 
                        $scope.advance.month=result.advanceList[0].deductFrom.substring(5, 7); /*(0, 2)*/
                        $scope.advance.year=result.advanceList[0].deductFrom.substring(0, 4); /*(2, 6)*/
                        $scope.advance.numberOfInstallments=result.advanceList[0].numberOfInstallments; 
                        $scope.advance.balanceAmount=result.advanceList[0].balanceAmountReturn.toString();; 
                    
            }).error(function(data) {

            });
        }
        
        $scope.cancel =function(){
            $state.go('app.payroll.advance.list');
        };
          
        $scope.openBalance = function(){
            if(parseInt($scope.advance.openingBalance) > parseInt($scope.advance.amount)){
                logger.logError("Open Balance should be lesser than or equal to Advance Amount");    

                $scope.advance.openingBalance = '';
            }
        }
        
        $scope.submit=function(advanceForm){
            debugger;
            if (new validationService().checkFormValidity(advanceForm)) {
                var isvalid=true;
                var dateObj = new Date();
                var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
                var day = dateObj.getUTCDate();
                var cur_year = dateObj.getUTCFullYear();
                var cur_mnth=cur_month-1;
                $scope.advance.status=0;
                var saveData = $scope.advance;
                var resultBean={                       
                        employee:$scope.advance.employee,
                        description:$scope.advance.description,  
                        amount:$scope.advance.amount,
                        disbursementDate:$scope.advance.disbursementDate,
                        openingBalance:$scope.advance.openingBalance,
                        installmentPaid:$scope.advance.installmentPaid,
                        recoverytype:$scope.advance.recoverytype,
                        installmentAmount:$scope.advance.installmentAmount,
                        deductFrom:$scope.advance.month + $scope.advance.year,
                        numberOfInstallments:$scope.advance.numberOfInstallments,
                }
                console.log("resultBean")
                 console.log(resultBean);
                if((Number($scope.advance.year)==cur_year) && (Number($scope.advance.month) < cur_mnth)){
                    isvalid=false;
                    logger.logError("Please Select Month and Year Should be greater than or equal to the current or before Month and Year");    
                }else{
                    if(isvalid){
                    $http.post("payroll/payroll/advance/addAdvance", resultBean).success(function(result) {
                        console.log("Result From DAO IMPL");
                        console.log(result);
                    if (result == false) {
                        logger.logError("Unable to add Advance ");  
                    }else{ 
                        logger.logSuccess("Advance has been added successfully");   
                        $state.go('app.payroll.advance.list');
                    }
                    });
                    }
                }
               
            }else {
                toaster.pop('error', "Please fill the required fields",
                        logger.getErrorHtmlNew(advanceForm.$validationSummary),5000, 'trustedHtml');
            }
        }
        
      
        
        $scope.reset=function(){
            if(advanceCode == undefined || advanceCode == null){
                
                $scope.advance = {
                        advanceCode:'',
                        employee:'',
                        employeeName:'',
                        employeeCode:'',
                        designation:'',
                        joinDate:'',
                        workingYear:'',
                        description:'',  
                        amount:0,
                        disbursementDate:'',
                        openingBalance:0,
                        installmentPaid:'',
                        recoverytype:'',
                        installmentAmount:0,
                        month:'',
                        year:'',
                        startDate:'',
                        numberOfInstallments:'',
                        isEdit:false      
                 };
                  
            }else{
                $http.get('payroll/payroll/advance/advanceEdit?advanceCode='+ advanceCode).success(function(result) {
                    
                    $scope.advance.advanceCode=result.advanceList[0].advanceCode;  
                    $scope.advance.employee=result.advanceList[0].employee;  
                    $scope.advance.description=result.advanceList[0].description; 
                    $scope.advance.amount=result.advanceList[0].amount; 
                    $scope.advance.disbursementDate=result.advanceList[0].disbursementDate; 
                    $scope.advance.openingBalance=result.advanceList[0].openingBalance; 
                    $scope.advance.installmentPaid=result.advanceList[0].installmentPaid; 
                    $scope.advance.recoverytype=result.advanceList[0].recoverytype; 
                    $scope.advance.installmentAmount=result.advanceList[0].installmentAmount; 
                    $scope.advance.deductFrom=result.advanceList[0].deductFrom; 
                    $scope.advance.month=result.advanceList[0].deductFrom.substring(0, 2); 
                    $scope.advance.year=result.advanceList[0].deductFrom.substring(2, 6); 
                    $scope.advance.numberOfInstallments=result.advanceList[0].numberOfInstallments; 
                
        })
            }
              
        }

      $scope.update = function(advanceForm) {
      debugger;
      if (new validationService().checkFormValidity(advanceForm)) {
          if($scope.advance.isEdit ==true){
              var isvalid=true;
              var dateObj = new Date();
              var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
              var day = dateObj.getUTCDate();
              var cur_year = dateObj.getUTCFullYear()-1;
              var cur_mnth=cur_month-1;

              var saveData = $scope.advance;
              var resultBean={
                      advanceCode:$scope.advance.advanceCode,
                      employee:$scope.advance.employee,
                      description:$scope.advance.description,  
                      amount:$scope.advance.amount,
                      disbursementDate:$scope.advance.disbursementDate,
                      openingBalance:$scope.advance.openingBalance,
                      installmentPaid:$scope.advance.installmentPaid,
                      recoverytype:$scope.advance.recoverytype,
                      installmentAmount:$scope.advance.installmentAmount,
                      deductFrom:$scope.advance.month + $scope.advance.year,
                      numberOfInstallments:$scope.advance.numberOfInstallments,
              }
              if((Number($scope.advance.year)==cur_year) && (Number($scope.advance.month) < cur_month)){
            //  if((Number($scope.advance.year)>= cur_year) && (Number($scope.advance.month) >= cur_month)){
                  isvalid=false;
                  logger.logError("Please Select Month and Year Should be greater than or equal to the current Month and Year");    
              }
              else{
               if(isvalid){
                $http.post('payroll/payroll/advance/updateAdvance', resultBean).success(function(result) {

                if (result == false) {
                    logger.logError("Unable to Update Record");    
                }else{ 
                    logger.logSuccess("Advance has been updated successfully");   
                    $state.go('app.payroll.advance.list');
                } 
            });
            }   
            }
          }   
          
      }else {
          toaster.pop('error', "Please fill the required fields",
                  logger.getErrorHtmlNew(advanceForm.$validationSummary),5000, 'trustedHtml');
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

    
