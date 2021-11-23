
    'use strict';
   	app.controller('withHoldViewCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

   // module.registerController('withHoldViewCtrl', function($scope,$filter,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
  
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
        
        $scope.withhold.fromMonth=mm.toString();;
        $scope.withhold.fromYear= yyyy.toString();

        
      /*  
        $scope.mncheck=function(){
            if(today2.substring(0,1)=="0"){
                $scope.withhold.fromMonth=today2.substring(1,2);
            }else{
                $scope.withhold.fromMonth=mm;
            }
            
       
        };
        $scope.mncheck();*/
        
        
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
        
        
        
    
    
    
});

