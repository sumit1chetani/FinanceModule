//define([ 'payroll/payroll/payroll' ], function(module) {

    'use strict';
    
    //module.registerController('advanceReportCtrl', function($scope,$state,$http,ngDialog, logger,$location,$controller,$injector, sharedProperties, toaster,$rootScope,validationService)  {
   	app.controller('advanceReportCtrl', function($stateParams,$scope, $state, $http, ngDialog, logger, $location, $controller, $injector, sharedProperties, toaster, $rootScope, validationService,utilsService, $window,$timeout) {

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
                narration:''
         };
        
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
        
        var year = [ {
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
        }]
        
       
       // $scope.yearList = year;
        
 /* $http.get("payroll/payroll/withhold/yearList").success(function(result) {
           
            
      $scope.yearList = result.yearList;
          
        });*/
        
 $scope.yearList = [  
            
            {
                id : '2020',
                text : '2020'
            },
            
            {
                id : '2021',
                text : '2021'
            },
            {
                id : '2022',
                text : '2022'
            },
            
            {
                id : '2023',
                text : '2023'
            },
            {
                id : '2024',
                text : '2024'
            },
            {
                id : '2025',
                text : '2025'
            }
            
            ];
        
        
        
        
        
        $scope.submit = function(){
            
          var monthYear = $scope.advance.month + $scope.advance.year;
          
          if(monthYear !=undefined && monthYear != null && monthYear != ''){
          
          var currentDate = new Date();
          currentDate = ('0' + (Number(currentDate.getMonth()) + 1)) + currentDate.getFullYear();

              var month = monthYear.substring(0, 2);
              var year = monthYear.substring(2, 6);
              var dummy = new Date(year, month - 1);
              var today = new Date();
      
              if(dummy > today){
                  $scope.advance.month = '';
                  $scope.advance.year = '';
                  $scope.rowCollection = '';
                  $scope.expor = false;
                logger.logError("Month and Year should be lesser than or equal to Current date");
        }else{
            
            var resultbean = {
                    monthYear :$scope.advance.month + $scope.advance.year,
            }
            
            $http.post("payroll/payroll/advance/advanceReport",resultbean)
            .success(function(response) {
                if(response.advanceAddList != ''){
                    $scope.rowCollection = response.advanceAddList;
                    $scope.expor = true;

                }else{
                    logger.logError("Record not found");
                    $scope.rowCollection = '';
                    $scope.expor = false;
                }
            });
            
        }

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
                    monthYear :  $scope.advance.month +  $scope.advance.year
                }

                console.log("exportResultBean");
                console.log(resultBean);
                $http.post('payroll/payroll/advance/exportExcel', resultBean).success(function(data) {

                    console.log("export report");
                    console.log(data);
                    if (data.success == true) {

                        logger.logSuccess("File Exported Successfully");
                        $('#btnRowDivId').append('<a id="captainMsglink" href="tempdoc/Advance.xls" class="control-label" download="Advance.xls"></a>');
                        $("#captainMsglink").bind('click', function() {
                        });
                        $('#captainMsglink').simulateClick('click');
                    } else {

                        logger.logError("Error Please Try Again");

                    }
                }).error(function(data) {
                });

        };
        
   // });
    
});