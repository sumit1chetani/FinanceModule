
    'use strict';
    
   // module.registerController('WithholdReportCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
       	app.controller('WithholdReportCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {
  
        $scope.dataLoopCount = 0;
        $scope.offsetCount = 0;
        $scope.limitCount = 1000;
        $scope.updatedData = [];
        $scope.rowCollection = [];
        $scope.displayedCollection = [];
        $scope.itemsByPage = 10;
        $scope.isDisplay=true;
        $scope.loanDeductionList=[];
        
        $scope.advance = {
                designation:'',
                month:'',
                year:'',
                loanId:'',
                monthYear:'',
                amount:0,
                loanTypeId:'',
                loanTypeName:'',
                employeeId:'',
                employeeName:'',
                deductionAmount:0,
                narration:'',
                status:'pending',
         };
        
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
        console.log(today);
        $scope.chektoday=today1;
        
        $scope.advance.month=mm;
        $scope.advance.year= yyyy.toString();
        
        
        
        $scope.expor = false;
        
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
        
        var Status = [ {
            id : 'pending',
            text : 'Pending'
        }, {
            id : 'completed',
            text : 'Completed'
       
        }]
        
       
      $scope.statusList = Status;
        
        
        //year list 
        
        //year list 
        $http.get("payroll/payroll/withhold/yearList").success(function(result) {
           
            
            $scope.yearList = result.yearList;
          
        });
        
   
          
        
        $scope.on = function(){
            
            var monthYear = $scope.advance.month + $scope.advance.year;
            
            if(monthYear !=undefined && monthYear != null && monthYear != ''){
            
            var currentDate = new Date();
            currentDate = ('0' + (Number(currentDate.getMonth()) + 1)) + currentDate.getFullYear();

                var month = monthYear.substring(0, 2);
                var year = monthYear.substring(2, 6);
                var dummy = new Date(year, month - 1);
                var today = new Date();
        
//                if(dummy >= today){
//                    $scope.advance.month = '';
//                    $scope.advance.year = '';
//                    $scope.rowCollection = '';
//                    $scope.expor = false;
//                  logger.logError("Month and Year should be greater than or equal to Current date");
//          }else{
              
              var resultbean = {
                      monthYear :$scope.advance.month + $scope.advance.year,
                      status:$scope.advance.status,
                      fromMonth:$scope.advance.month,
                      fromYear:$scope.advance.year,
              }
              
              $http.post("payroll/payroll/withhold/withholdReport",resultbean)
              .success(function(response) {
                  if(response.withholdAddList != ''){
                      $scope.rowCollection = response.withholdAddList;
                      $scope.expor = true;

                  }else{
                      logger.logError("Record not found");
                      $scope.rowCollection = '';
                      $scope.expor = false;
                  }
              });
              
          

          }else {
              logger.logError("Please select Month and Year");
          }

          };
          $scope.on();
        
        
        $scope.submit = function(){
            
          var monthYear = $scope.advance.month + $scope.advance.year;
          
          if(monthYear !=undefined && monthYear != null && monthYear != ''){
          
          var currentDate = new Date();
          currentDate = ('0' + (Number(currentDate.getMonth()) + 1)) + currentDate.getFullYear();

              var month = monthYear.substring(0, 2);
              var year = monthYear.substring(2, 6);
              var dummy = new Date(year, month - 1);
              var today = new Date();
      
//              if(dummy >= today){
//                  $scope.advance.month = '';
//                  $scope.advance.year = '';
//                  $scope.rowCollection = '';
//                  $scope.expor = false;
//                logger.logError("Month and Year should be greater than or equal to Current date");
//        }else{
            
            var resultbean = {
                    monthYear :$scope.advance.month + $scope.advance.year,
                    status:$scope.advance.status,
                    fromMonth:$scope.advance.month,
                    fromYear:$scope.advance.year,
            }
            
            $http.post("payroll/payroll/withhold/withholdReport",resultbean)
            .success(function(response) {
                if(response.withholdAddList != ''){
                    $scope.rowCollection = response.withholdAddList;
                    $scope.expor = true;

                }else{
                    logger.logError("Record not found");
                    $scope.rowCollection = '';
                    $scope.expor = false;
                }
            });
            
        

        }else {
            logger.logError("Please select Month and Year");
        }
          
          
          
                
                
           

        }
        
        $.fn.simulateClick = function() {
            return this.each(function() {
                if ('createEvent' in document) {
                    var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                    evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                    this.dispatchEvent(evt);
                } else {
                    this.click(); // IE
                }
            });
        }
        
        $scope.exportExcel = function() {

                var resultBean = {
                    monthYear :  $scope.advance.month +  $scope.advance.year,
                    status:$scope.advance.status,  fromMonth:$scope.advance.month,
                    fromYear:$scope.advance.year,
                }

                console.log("exportResultBean");
                console.log(resultBean);
                $http.post('payroll/payroll/withhold/exportExcel', resultBean).success(function(data) {

                    console.log("export report");
                    console.log(data);
                    if (data.success == true) {

                        logger.logSuccess("File Exported Successfully");
                        $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Withhold.xls" class="control-label" download="Withhold.xls"></a>');
                        $("#captainMsglink").bind('click', function() {
                        });
                        $('#captainMsglink').simulateClick('click');
                    } else {

                        logger.logError("Error Please Try Again");

                    }
                }).error(function(data) {
                });

        };
        
    
    
});