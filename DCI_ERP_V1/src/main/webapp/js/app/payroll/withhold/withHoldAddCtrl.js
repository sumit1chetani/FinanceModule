
    'use strict';
   	app.controller('withHoldAddCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

   // module.registerController('withHoldAddCtrl', function($scope,$filter,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
        
        $scope.withhold = {
                
                employee:'',
withholdDate   :'',
fromMonth:'',
fromYear:'',
tillMonth:'',
tillYear:'',   
withHoldCode:'',
ischeck:false,

               
         };
        
        
      //now date 
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; // January is 0!
        var yyyy = today.getFullYear();
        var time = today.getHours() + ":" + today.getMinutes()
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }

        $scope.withhold.withholdDate = dd + '/' + mm + '/'
                + yyyy +time;


        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;

        var yyyy = today.getFullYear();
        var time = today.getHours() + ":" + today.getMinutes()
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        } 
        var today1 = dd + '/' + mm + '/' + yyyy ;
        var today2 =  mm + '/' + yyyy ;

        $scope.withhold.withholdDate = today1;
        console.log(today);
        $scope.chektoday=today1;
        $scope.chtoday=today2;

  /*      $scope.mncheck=function(){
            if(today2.substring(0,1)=="0"){
                $scope.withhold.fromMonth=today2.substring(1,2);
            }else{
                $scope.withhold.fromMonth=mm;
            }
            
       
        };
        $scope.mncheck();*/
        
        $scope.withhold.fromMonth=mm.toString();
        
        
        $scope.withhold.fromYear= yyyy.toString();

        
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
        
        $scope.year = [ {
            id : 'emp',
            text : '---select Employee---'
        }]
        
    //to year watch   
        $scope.$watch('withhold.tillYear', function(newValue, oldValue) {
            if($scope.withhold.tillYear != null && $scope.withhold.toyea != ''){ 
            var dateObj = new Date();
            var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
            var day = dateObj.getUTCDate();
            var cur_year = dateObj.getUTCFullYear();
            if(newValue!= null && newValue!=''){
           
                if((Number(newValue) < cur_year)){                    
                    logger.logError(" Year Should be greater than or equal to the current  Year"); 
             /*   $scope.withhold.tillYear='';
                    $scope.withhold.tillMonth='';*/
          } 
                
                
            if($scope.withhold.fromYear!= null && $scope.withhold.fromYear!=''){

                if((Number(newValue)< $scope.withhold.fromYear)){
                    logger.logError(" Withold Till Should be greater than or equal to  Withold From");  
             //   $scope.withhold.tillYear='';
              // $scope.withhold.tillMonth='';
                    

                }
                     }else{
                         logger.logError(" Select the Withhold From, Month and Year first");   
                //   $scope.withhold.tillYear='';
                         
                     }  
             
        }  
            }
         });
        
        
//        $scope.yearList = year;
        

        $scope.employeelist = [];
        $scope.yearList = [];

        var emp =[];
        $http.get("payroll/payroll/withhold/employeeList").success(function(result) {
            if( $scope.isEdit == false){
            $scope.employeelist=$scope.year;
            for(var i=0;i<result.employeeList.length;i++){

                $scope.employeelist.push(result.employeeList[i]);
            

            }
            $scope.withhold.employee='emp';
            }
            else{
                $scope.employeelist=result.employeeList;
            }
        })
        
        
        
        //year list 
        $http.get("payroll/payroll/withhold/yearList").success(function(result) {
            $scope.yearList = result.yearList;
        })
        
// to check employee withold  

           $scope.$watch('withhold.employee', function(newValue, oldValue) {

               
               if( $scope.isEdit == false){
    if($scope.withhold.employee!= null && $scope.withhold.employee!=''){
        
        $http.get('payroll/payroll/withhold/employeeCheck?employee='+newValue ).success(function(response) {
            console.log(response);
            
            $scope.date1= response.withholdList[0].withholdTo; 

                  if($scope.date1!=null){
        if($scope.chtoday<=$scope.date1){
            logger.logError("Selected Employee is under Withhold"); 
            $scope.withhold.employee='';
        }}else{
            logger.logError(" Employee is already "); 

            $scope.withhold.employee='';
        }
         
                
    });
            }
    }
    

          
      
           });
        
        
        
        
        
        $scope.$watch('withhold.fromMonth', function(newValue, oldValue) {
            var dateObj = new Date();
            var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
            var day = dateObj.getUTCDate();
            var cur_year = dateObj.getUTCFullYear();
            
    if($scope.withhold.fromMonth!= null && $scope.withhold.fromMonth!='' ){
            if((Number(newValue) < cur_month)){
              
                logger.logError("  From Month Should be greater than or equal to the current Month");    
                /*$scope.withhold.fromMonth='';
*/
            }
            }

         });
        
        
   
        
   
        
     //validation for  with hold to month 
        
        $scope.$watch('withhold.tillMonth', function(newValue, oldValue) {
            var dateObj = new Date();
            var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
            var day = dateObj.getUTCDate();
            var cur_year = dateObj.getUTCFullYear();
            
    if($scope.withhold.tillMonth!= null && $scope.withhold.tillMonth!='' ){
        
            if((Number(newValue) < cur_month)){
              
                logger.logError("  Till Month Should be greater than or equal to the current Month");    
               /* $scope.withhold.tillMonth='';*/


            }
            if($scope.withhold.fromMonth!= null && $scope.withhold.fromMonth!=''){

               
                     }else{
                         logger.logError(" Select the Withhold From, Month and Year first");   
/*                         $scope.withhold.tillMonth='';
*/                         
                     }
            
            }

         });
        

        
       
        
      
        
        
       $scope.isEdit = false;
        $scope.diminishingEMIList=[];
        
//        $scope.ischeck=false;
        
       var Check=$location.search().check;
    var withHoldCode = $location.search().withHoldCode;
        if (withHoldCode == undefined) {
            $scope.isEdit = false;
        } else {
             console.log("Coming inside else function");
            $http.get('payroll/payroll/withhold/withholdEdit?withHoldCode='+ withHoldCode).success(function(result) {
                   console.log(result);
                        $scope.isEdit = true;
                        if(Check=='true'){
$scope.withhold.ischeck=true;                        }
                        else{
                            $scope.withhold.ischeck=false;
                        }
                        
             
                        
                        $scope.withhold.withHoldCode=result.withholdList[0].withHoldCode;  
                        $scope.withhold.employee=result.withholdList[0].employee;  
                       
                        $scope.withhold.withholdDate=result.withholdList[0].withholdDate; 
                      
                      //  $scope.withhold.withholdFrom=result.withholdList[0].withholdFrom; 
                      //  $scope.withhold.withholdTo=result.withholdList[0].withholdTo; 

                        $scope.withhold.fromMonth=result.withholdList[0].fromMonth.toString(); /*(0, 2)*/
                        $scope.withhold.fromYear=result.withholdList[0].fromYear.toString(); /*(2, 6)*/
                        $scope.withhold.tillMonth=result.withholdList[0].tillMonth.toString(); /*(0, 2)*/
                        $scope.withhold.tillYear=result.withholdList[0].tillYear.toString(); /*(2, 6)*/
                      
                    
            }).error(function(data) {

            });
        }
        
        $scope.cancel =function(){
            $state.go('app.payroll.withhold.list');
        };
          
       /* $scope.openBalance = function(){
            if(parseInt($scope.advance.openingBalance) > parseInt($scope.advance.amount)){
                logger.logError("Open Balance should be lesser than or equal to Advance Amount");    

                $scope.advance.openingBalance = '';
            }
        }*/
        
        $scope.submit=function(advanceForm){
            debugger;
            if (new validationService().checkFormValidity(advanceForm)) {
                var isvalid=true;
                var dateObj = new Date();
                var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
                var day = dateObj.getUTCDate();
                var cur_year = dateObj.getUTCFullYear();
          
                var saveData = $scope.withhold;
                var resultBean={                       
                        employee:$scope.withhold.employee,
                       
                        withholdDate:$scope.withhold.withholdDate,
                        
                        withholdFrom:$scope.withhold.fromMonth + $scope.withhold.fromYear,
                        withholdTo:$scope.withhold.tillMonth + $scope.withhold.tillYear,
                        fromMonth:$scope.withhold.fromMonth,
                            fromYear: $scope.withhold.fromYear,
                                tillMonth:$scope.withhold.tillMonth,
                                    tillYear:$scope.withhold.tillYear,

                }
                
                
                console.log("resultBean")
                 console.log(resultBean);
                if($scope.withhold.tillYear!="" && $scope.withhold.tillMonth!=""){
                if((Number($scope.withhold.tillYear))==(Number($scope.withhold.fromYear))){
                if((Number($scope.withhold.tillMonth))< (Number($scope.withhold.fromMonth))){           
                    isvalid=false;
                    logger.logError("Till Month  Should be greater than or equal than From  Month ");    
                    /*$scope.withhold.tillMonth='';*/
                }else {
                    if(isvalid){
                    $http.post("payroll/payroll/withhold/addwithhold", resultBean).success(function(result) {
                        console.log("Result From DAO IMPL");
                        console.log(result);
                    if (result == false) {
                        logger.logError("Unable to Update WithHold ");  
                    }else{ 
                        logger.logSuccess("WithHold List has been added successfully");   
                        $state.go('app.payroll.withhold.list');
                    }
                    });
                    }
                }}
                else if((Number($scope.withhold.tillYear))>(Number($scope.withhold.fromYear))){
                    if(isvalid){
                        $http.post("payroll/payroll/withhold/addwithhold", resultBean).success(function(result) {
                            console.log("Result From DAO IMPL");
                            console.log(result);
                        if (result == false) {
                            logger.logError("Unable to Update WithHold ");  
                        }else{ 
                            logger.logSuccess("WithHold List has been added successfully");   
                            $state.go('app.payroll.withhold.list');
                        }
                        });
                        }
                    
                }
                else{
                    logger.logError(" Till Year Should be greater than or equal to  From Year");    
                   /* $scope.withhold.tillYear='';*/

                    
                }
            }else{
                if(isvalid){
                    $http.post("payroll/payroll/withhold/addwithhold", resultBean).success(function(result) {
                        console.log("Result From DAO IMPL");
                        console.log(result);
                    if (result == false) {
                        logger.logError("Unable to Update WithHold ");  
                    }else{ 
                        logger.logSuccess("WithHold List has been added successfully");   
                        $state.go('app.payroll.withhold.list');
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
            if(withHoldCode == undefined ||withHoldCode == null){
                
                $scope.withhold = {
                        
                        employee:'',
        withholdDate   :'',
        fromMonth:'',
        fromYear:'',
        tillMonth:'',
        tillYear:'',            
                       
                 };
                  
            }else{
                $http.get('payroll/payroll/withhold/withholdEdit?withHoldCode='+ withHoldCode).success(function(result) {
                    
                    $scope.isEdit = true;
                    $scope.withhold.withHoldCode=result.withholdList[0].withHoldCode;  

                    $scope.withhold.employee=result.withholdList[0].employee;  
                   
                    $scope.withhold.withholdDate=result.withholdList[0].withholdDate; 
                  
                  //  $scope.withhold.withholdFrom=result.withholdList[0].withholdFrom; 
                   // $scope.withhold.withholdTo=result.withholdList[0].withholdTo; 

                    $scope.withhold.fromMonth=result.withholdList[0].fromMonth.toString(); /*(0, 2)*/
                    $scope.withhold.fromYear=result.withholdList[0].fromYear.toString(); /*(2, 6)*/
                    $scope.withhold.tillMonth=result.withholdList[0].tillMonth.toString(); /*(0, 2)*/
                    $scope.withhold.tillYear=result.withholdList[0].tillYear.toString(); /*(2, 6)*/
                  
                
        })
            }
              
        }

      $scope.update = function(advanceForm) {
      debugger;
      if (new validationService().checkFormValidity(advanceForm)) {
          if($scope.isEdit ==true){
              var isvalid=true;
              var dateObj = new Date();
              var cur_month = dateObj.getUTCMonth() + 1; //months from 1-12
              var day = dateObj.getUTCDate();
              var cur_year = dateObj.getUTCFullYear();

              var saveData = $scope.withhold;
              var resultBean={
                      employee:$scope.withhold.employee,
                      withHoldCode:$scope.withhold.withHoldCode,
                      
                      withholdDate:$scope.withhold.withholdDate,
                      
                      withholdFrom:$scope.withhold.fromMonth + $scope.withhold.fromYear,
                      withholdTo:$scope.withhold.tillMonth + $scope.withhold.tillYear,
                      fromMonth:$scope.withhold.fromMonth,
                      fromYear: $scope.withhold.fromYear,
                          tillMonth:$scope.withhold.tillMonth,
                              tillYear:$scope.withhold.tillYear,
              }
              if($scope.withhold.tillYear!="" && $scope.withhold.tillMonth!=""){
                  
              if((Number($scope.withhold.tillYear))==(Number($scope.withhold.fromYear))){
                  if((Number($scope.withhold.tillMonth))< (Number($scope.withhold.fromMonth))){ 
                      isvalid=false;
                      logger.logError("Till Month  Should be greater than or equal to From  Month ");    
              }
              else{
               if(isvalid){
                $http.post('payroll/payroll/withhold/updatewithhold', resultBean).success(function(result) {

                if (result == false) {
                    logger.logError("Unable to Update Record");    
                }else{ 
                    logger.logSuccess("With Hold List  has been updated successfully");   
                    $state.go('app.payroll.withhold.list');
                } 
            });
            }   
            }}
              else if((Number($scope.withhold.tillYear))>(Number($scope.withhold.fromYear))){
                  if(isvalid){
                      $http.post('payroll/payroll/withhold/updatewithhold', resultBean).success(function(result) {

                      if (result == false) {
                          logger.logError("Unable to Update Record");    
                      }else{ 
                          logger.logSuccess("With Hold List  has been updated successfully");   
                          $state.go('app.payroll.withhold.list');
                      } 
                  });
                  } 
                  
              }else{
                logger.logError(" Till Year Should be greater than or equal to  From Year");    
                $scope.withhold.tillYear='';

                
            }
          } else{
              if(isvalid){
                  $http.post('payroll/payroll/withhold/updatewithhold', resultBean).success(function(result) {

                  if (result == false) {
                      logger.logError("Unable to Update Record");    
                  }else{ 
                      logger.logSuccess("With Hold List  has been updated successfully");   
                      $state.go('app.payroll.withhold.list');
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
    
    module.registerDirective('phonenumbersOnly', function(logger){        return {
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

    






