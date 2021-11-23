'use strict';
app.controller('averageRateCtrl', function($scope, $rootScope, $http, $location, $timeout,logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
    $scope.rowCollection=[];
    
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 1000;
    
    $scope.pageCounters = [10, 20, 25, 50, 100, 500, 1000 ];
    
    $scope.loadingAvgReport={      
        id:'',
        text:'',
        week:'',
        month:'',
        toDate:'',
        year:'',
        pol : '',
        pod : '',
        lpol:[],
        lpod:[],
        polISO:'',
        podISO:'',
        slot:'',
        subSlot : '',
        lfpod : [],
        fpod : '',
        fpodISO : '',
        customerName:'',
        sectorId : '',
        totalTeus:0,
        avgTeus:0,
        totalWeight:0,
        teusList:[]
    }
    
    $http.get('app/commonUtility/getPortList').success(function(datas) {
        $scope.polList = datas;
        $scope.podList = datas;
        $scope.potList =datas;
    });
    
    $scope.checkMonthReport = function(){
        $scope.isWeek=false;
        $scope.loadingAvgReport.toDate=  $('#toDate').val();
        $http.post('app/loadingAvg/list',$scope.loadingAvgReport).success(function(datas) {
            console.log("Loding avg list");
            console.log(datas);
            $scope.monthlyAvgListList= datas;
            $scope.rowCollection=   datas.loadingAvgList;
            //$scope.listSize=$scope.monthlyAvgListList.monthList.length;
        }).error(function(datas) {
        });
    }
    
    $scope.viewWeekReport=function(){
        if(($scope.loadingAvgReport.lpol == "")&&
                ($scope.loadingAvgReport.lpod == "")&&
                ($scope.loadingAvgReport.polISO == "")&&
                ($scope.loadingAvgReport.podISO == "")&&
                ($scope.loadingAvgReport.toDate == "")&&
                ($scope.loadingAvgReport.slot == "")&&
                ($scope.loadingAvgReport.subSlot == "")&&
                ($scope.loadingAvgReport.sectorId == "")&&
                ($scope.loadingAvgReport.lfpod == ""))
                 $scope.checkWeekReport();
       else{
                 if(($scope.loadingAvgReport.lpol != "")&&($scope.loadingAvgReport.polISO != ""))
                     logger.logError("Please select either POL or POL ISO Code");
                 else{
                     if(($scope.loadingAvgReport.lpod != "")&&($scope.loadingAvgReport.podISO != ""))
                         logger.logError("Please select either POD or POD ISO Code");
                     else{
                         if(($scope.loadingAvgReport.lfpod != "")&&($scope.loadingAvgReport.fpodISO != ""))
                             logger.logError("Please select either FPOD or FPOD ISO Code");
                         else
                             $scope.checkWeekReport();
                     }
                 }
          }
    }
    
    $scope.checkWeekReport = function(){
        $scope.isWeek=true;
        $scope.loadingAvgReport.toDate=  $('#toDate').val();
        $http.post('app/loadingAvg/weeklyList',$scope.loadingAvgReport).success(function(datas) {
           console.log("Loding avg list");
           console.log(datas);
           $scope.monthlyAvgListList= datas;
           $scope.rowCollection=  datas.loadingAvgList;
           //$scope.listSize=$scope.monthlyAvgListList.monthList.length;
       }).error(function(datas) {
       });
    }
    
    
    $scope.monthlyExcelExport=function(){
        if(($scope.loadingAvgReport.lpol == "")&&
                ($scope.loadingAvgReport.lpod == "")&&
                ($scope.loadingAvgReport.polISO == "")&&
                ($scope.loadingAvgReport.podISO == "")&&
                ($scope.loadingAvgReport.toDate == "")&&
                ($scope.loadingAvgReport.slot == "")&&
                ($scope.loadingAvgReport.subSlot == "")&&
                ($scope.loadingAvgReport.sectorId == "")&&
                ($scope.loadingAvgReport.lfpod == ""))
                 $scope.checkMonthlyExcel();
        else{
            if(($scope.loadingAvgReport.lpol != "")&&($scope.loadingAvgReport.polISO != ""))
                logger.logError("Please select either POL or POL ISO Code");
            else{
                if(($scope.loadingAvgReport.lpod != "")&&($scope.loadingAvgReport.podISO != ""))
                    logger.logError("Please select either POD or POD ISO Code");
                else{
                    if(($scope.loadingAvgReport.lfpod != "")&&($scope.loadingAvgReport.fpodISO != ""))
                        logger.logError("Please select either FPOD or FPOD ISO Code");
                    else
                         $scope.checkMonthlyExcel();
                    }
                }
           }
    }
    
    $scope.checkMonthlyExcel = function(){
        $scope.loadingAvgReport.toDate=  $('#toDate').val();
        angular.forEach($scope.portISOList, function(value, key) {
            if ($scope.loadingAvgReport.polISO === value.id) {
                $scope.loadingAvgReport.polISOText = value.text;
            }
            if ($scope.loadingAvgReport.podISO === value.id) {
                $scope.loadingAvgReport.podISOText = value.text;
            }
            if ($scope.loadingAvgReport.fpodISO === value.id) {
                $scope.loadingAvgReport.fpodISOText = value.text;
            }
        });
        
        angular.forEach($scope.slotList, function(value, key) {
            if ($scope.loadingAvgReport.slot === value.id) {
                $scope.loadingAvgReport.slotText = value.text;
            }
        });
        angular.forEach($scope.subSlotList, function(value, key) {
            if ($scope.loadingAvgReport.subSlot === value.id) {
                $scope.loadingAvgReport.subSlotText = value.text;
            }
        });
        angular.forEach($scope.serviceList, function(value, key) {
            if ($scope.loadingAvgReport.sectorId === value.id) {
                $scope.loadingAvgReport.serviceText = value.text;
            }
        });
        $http.post('app/loadingAvg/monthlyExcelExport',$scope.loadingAvgReport).success(function(datas) {
           console.log("Loding avg list");
           console.log(datas);
           $("#monthlyExcelLink").bind('click', function() {
           });
           $('#monthlyExcelLink').simulateClick('click');
           logger.logSuccess("Exported successfully!");
       }).error(function(datas) {
       });
    }
    
    $scope.weeklyExcelExport=function(){
        if(($scope.loadingAvgReport.lpol == "")&&
                ($scope.loadingAvgReport.lpod == "")&&
                ($scope.loadingAvgReport.polISO == "")&&
                ($scope.loadingAvgReport.podISO == "")&&
                ($scope.loadingAvgReport.toDate == "")&&
                ($scope.loadingAvgReport.slot == "")&&
                ($scope.loadingAvgReport.subSlot == "")&&
                ($scope.loadingAvgReport.sectorId == "")&&
                ($scope.loadingAvgReport.lfpod == ""))
                 $scope.checkWeekExcel();
        else{
            if(($scope.loadingAvgReport.lpol != "")&&($scope.loadingAvgReport.polISO != ""))
                logger.logError("Please select either POL or POL ISO Code");
            else{
                if(($scope.loadingAvgReport.lpod != "")&&($scope.loadingAvgReport.podISO != ""))
                    logger.logError("Please select either POD or POD ISO Code");
                else{
                    if(($scope.loadingAvgReport.lfpod != "")&&($scope.loadingAvgReport.fpodISO != ""))
                        logger.logError("Please select either FPOD or FPOD ISO Code");
                    else
                         $scope.checkWeekExcel();
                 }
            }
          }
    }
 
    $scope.checkWeekExcel = function(){
        $scope.loadingAvgReport.toDate=  $('#toDate').val();
        angular.forEach($scope.portISOList, function(value, key) {
            if ($scope.loadingAvgReport.polISO === value.id) {
                $scope.loadingAvgReport.polISOText = value.text;
            }
            if ($scope.loadingAvgReport.podISO === value.id) {
                $scope.loadingAvgReport.podISOText = value.text;
            }
            if ($scope.loadingAvgReport.fpodISO === value.id) {
                $scope.loadingAvgReport.fpodISOText = value.text;
            }
        });
        
        angular.forEach($scope.slotList, function(value, key) {
            if ($scope.loadingAvgReport.slot === value.id) {
                $scope.loadingAvgReport.slotText = value.text;
            }
        });
        angular.forEach($scope.subSlotList, function(value, key) {
            if ($scope.loadingAvgReport.subSlot === value.id) {
                $scope.loadingAvgReport.subSlotText = value.text;
            }
        });
        angular.forEach($scope.serviceList, function(value, key) {
            if ($scope.loadingAvgReport.sectorId === value.id) {
                $scope.loadingAvgReport.serviceText = value.text;
            }
        });
        $http.post('app/loadingAvg/weeklyExcelExport',$scope.loadingAvgReport).success(function(datas) {
           console.log("Loding avg list");
           console.log(datas);
           $("#weeklyExcelLink").bind('click', function() {
           });
           $('#weeklyExcelLink').simulateClick('click');
           logger.logSuccess("Exported successfully!");
       }).error(function(datas) {
       });
    }
    
    $('.datetimepick').datetimepicker({
        format : 'DD/MM/YYYY',
        calendarWeeks: true
    });
  
       
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
   
    var d = new Date();
    var currentYear = d.getFullYear();
    
    $scope.polList = [];
    $scope.podList = [];
    
        $http.get('app/commonUtility/getPortList').success(function(datas) {
            $scope.polList = datas;
            $scope.podList = datas;
            $scope.potList =datas;
            //pol list
            $timeout(function() { // You might need this timeout to be sure its run after DOM render.      
                $("#pol").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      console.log(element);
                       var ct=""; 
                       if($scope.polList.length>0){   
                           $scope.loadingAvgReport.pol ='';
                          angular.forEach($scope.loadingAvgReport.lpol, function (item, key) {
                              if(ct==""){
                                  ct = "'"+item.id+"'";
                              }else{
                                  ct +=",'"+ item.id+"'";
                              }       
                              $scope.loadingAvgReport.pol = ct;
                          });
                       }
                    
                       else{
                           $scope.polList = [];
                           $scope.polList = 'Select';
                       }
                    }
                });
                $("#pol").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
            }, 2, false); 
            
            //pod list
            $timeout(function() { // You might need this timeout to be sure its run after DOM render.      
                $("#pod").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      console.log(element);
                       var ct=""; 
                       if($scope.podList.length>0){   
                           $scope.loadingAvgReport.pod ='';
                          angular.forEach($scope.loadingAvgReport.lpod, function (item, key) {
                              if(ct==""){
                                  ct = "'"+item.id+"'";
                              }else{
                                  ct +=",'"+ item.id+"'";
                              }       
                              $scope.loadingAvgReport.pod = ct;
                          });
                       }
                    
                       else{
                           $scope.podList = [];
                           $scope.podList = 'Select';
                       }
                    }
                });
                $("#pod").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
            }, 2, false); 
            
            //fpod list
            $timeout(function() { // You might need this timeout to be sure its run after DOM render.      
                $("#fpod").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      console.log(element);
                       var ct=""; 
                       if($scope.potList.length>0){   
                           $scope.loadingAvgReport.fpod ='';
                          angular.forEach($scope.loadingAvgReport.lfpod, function (item, key) {
                              if(ct==""){
                                  ct = "'"+item.id+"'";
                              }else{
                                  ct +=",'"+ item.id+"'";
                              }       
                              $scope.loadingAvgReport.fpod = ct;
                          });
                       }
                    
                       else{
                           $scope.potList = [];
                           $scope.potList = 'Select';
                       }
                    }
                });
                $("#fpod").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
            }, 2, false); 
            
        }).error(function(datas) {
        });
    
    $scope.getPortISOList= function() {
        $http.get('app/commonUtility/getPortISO_portList').success(function(datas) {
            $scope.portISOList = datas;
        }).error(function(datas) {
        });
    }
    
    $scope.subSlotList = [];
    $scope.potList = [];
    $scope.serviceList = [];
    $scope.getDropdownvalue = function() {
        
        $scope.getPortISOList();
        $http.get('app/weekReport/getYear').success(function(datas) {
            console.log("year list");
            console.log(datas);
            $scope.yearList = datas.yearList;
            $scope.loadingAvgReport.year=currentYear;
        }).error(function(data) {
        });
        
        $http.get('app/freightmanifest/slot').success(function(datas) {
            $scope.slotList = datas;
        }).error(function(data) {
        });
        
        $http.get('app/freightmanifest/subSlot').success(function(datas) {
            $scope.subSlotList = datas;
        }).error(function(data) {
        });
        
        /*$http.get('transhipment/summary/getPot').success(function(datas) {
            $scope.potList =datas.potList; 
            console.log("fpod list")
            console.log($scope.potList)
       });*/
        
        $http.get('app/agencyTariff/service').success(function(datas) {
            $scope.serviceList = datas.avgServiceList;
        }).error(function(data) {
        }); 
        
        $scope.weekList=[];
        for(var i=1;i<=52;i++){
            var week={};
            if(i<10){
            week.id='0'+i;
            }else{
                week.id=''+i;
            }
            week.text=''+i;
            $scope.weekList.push(week);
        }
        
        $scope.monthList=[];
        debugger;
        var month={};
        month.id=1;
        month.text='Janaury';
        $scope.monthList.push(month);
        
        month={};
        month.id=2;
        month.text='February';
        $scope.monthList.push(month);
        
        month={};
        month.id=3;
        month.text='March';
        $scope.monthList.push(month);
        
        month={};
        month.id=4;
        month.text='April';
        $scope.monthList.push(month);
        
        month={};
        month.id=5;
        month.text='May';
        $scope.monthList.push(month);
        
        month={};
        month.id=6;
        month.text='June';
        $scope.monthList.push(month);
        
        month={};
        month.id=7;
        month.text='July';
        $scope.monthList.push(month);
        
        month={};
        month.id=8;
        month.text='August';
        $scope.monthList.push(month);
        
        month={};
        month.id=9;
        month.text='September';
        $scope.monthList.push(month);
        
        month={};
        month.id=10;
        month.text='October';
        $scope.monthList.push(month);
        
        month={};
        month.id=11;
        month.text='November';
        $scope.monthList.push(month);
        
        month={};
        month.id=12;
        month.text='December';
        $scope.monthList.push(month);
        
       /* $scope.yearList=[];
        for(var i=2010;i<=2025;i++){
            var year={};
            year.id=i;
            year.text=''+i;
            $scope.yearList.push(year);
        }*/
        console.log($scope.weekList);
    }
    $scope.getDropdownvalue();
    
    
});


app.controller('averageRevenueCtrl', function($scope, $rootScope, $http, $location, $timeout,logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
    $scope.rowCollection=[];
    
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 1000;
    
    $scope.pageCounters = [10, 20, 25, 50, 100, 500, 1000 ];
    
    $scope.loadingAvgReport={      
        id:'',
        text:'',
        week:'',
        month:'',
        toDate:'',
        year:'',
        pol : '',
        pod : '',
        lpol:[],
        lpod:[],
        polISO:'',
        podISO:'',
        slot:'',
        subSlot : '',
        lfpod : [],
        fpod : '',
        fpodISO : '',
        customerName:'',
        sectorId : '',
        totalTeus:0,
        avgTeus:0,
        totalWeight:0,
        teusList:[]
    }
    
    $http.get('app/commonUtility/getPortList').success(function(datas) {
        $scope.polList = datas;
        $scope.podList = datas;
        $scope.potList =datas;
    });
    
    $scope.checkMonthReport = function(){
        $scope.isWeek=false;
        $scope.loadingAvgReport.toDate=  $('#toDate').val();
        $http.post('app/loadingAvg/list',$scope.loadingAvgReport).success(function(datas) {
            console.log("Loding avg list");
            console.log(datas);
            $scope.monthlyAvgListList= datas;
            $scope.rowCollection=   datas.loadingAvgList;
            //$scope.listSize=$scope.monthlyAvgListList.monthList.length;
        }).error(function(datas) {
        });
    }
    
    $scope.viewWeekReport=function(){
        if(($scope.loadingAvgReport.lpol == "")&&
                ($scope.loadingAvgReport.lpod == "")&&
                ($scope.loadingAvgReport.polISO == "")&&
                ($scope.loadingAvgReport.podISO == "")&&
                ($scope.loadingAvgReport.toDate == "")&&
                ($scope.loadingAvgReport.slot == "")&&
                ($scope.loadingAvgReport.subSlot == "")&&
                ($scope.loadingAvgReport.sectorId == "")&&
                ($scope.loadingAvgReport.lfpod == ""))
                 $scope.checkWeekReport();
       else{
                 if(($scope.loadingAvgReport.lpol != "")&&($scope.loadingAvgReport.polISO != ""))
                     logger.logError("Please select either POL or POL ISO Code");
                 else{
                     if(($scope.loadingAvgReport.lpod != "")&&($scope.loadingAvgReport.podISO != ""))
                         logger.logError("Please select either POD or POD ISO Code");
                     else{
                         if(($scope.loadingAvgReport.lfpod != "")&&($scope.loadingAvgReport.fpodISO != ""))
                             logger.logError("Please select either FPOD or FPOD ISO Code");
                         else
                             $scope.checkWeekReport();
                     }
                 }
          }
    }
    
    $scope.checkWeekReport = function(){
        $scope.isWeek=true;
        $scope.loadingAvgReport.toDate=  $('#toDate').val();
        $http.post('app/loadingAvg/weeklyList',$scope.loadingAvgReport).success(function(datas) {
           console.log("Loding avg list");
           console.log(datas);
           $scope.monthlyAvgListList= datas;
           $scope.rowCollection=  datas.loadingAvgList;
           //$scope.listSize=$scope.monthlyAvgListList.monthList.length;
       }).error(function(datas) {
       });
    }
    
    
    $scope.monthlyExcelExport=function(){
        if(($scope.loadingAvgReport.lpol == "")&&
                ($scope.loadingAvgReport.lpod == "")&&
                ($scope.loadingAvgReport.polISO == "")&&
                ($scope.loadingAvgReport.podISO == "")&&
                ($scope.loadingAvgReport.toDate == "")&&
                ($scope.loadingAvgReport.slot == "")&&
                ($scope.loadingAvgReport.subSlot == "")&&
                ($scope.loadingAvgReport.sectorId == "")&&
                ($scope.loadingAvgReport.lfpod == ""))
                 $scope.checkMonthlyExcel();
        else{
            if(($scope.loadingAvgReport.lpol != "")&&($scope.loadingAvgReport.polISO != ""))
                logger.logError("Please select either POL or POL ISO Code");
            else{
                if(($scope.loadingAvgReport.lpod != "")&&($scope.loadingAvgReport.podISO != ""))
                    logger.logError("Please select either POD or POD ISO Code");
                else{
                    if(($scope.loadingAvgReport.lfpod != "")&&($scope.loadingAvgReport.fpodISO != ""))
                        logger.logError("Please select either FPOD or FPOD ISO Code");
                    else
                         $scope.checkMonthlyExcel();
                    }
                }
           }
    }
    
    $scope.checkMonthlyExcel = function(){
        $scope.loadingAvgReport.toDate=  $('#toDate').val();
        angular.forEach($scope.portISOList, function(value, key) {
            if ($scope.loadingAvgReport.polISO === value.id) {
                $scope.loadingAvgReport.polISOText = value.text;
            }
            if ($scope.loadingAvgReport.podISO === value.id) {
                $scope.loadingAvgReport.podISOText = value.text;
            }
            if ($scope.loadingAvgReport.fpodISO === value.id) {
                $scope.loadingAvgReport.fpodISOText = value.text;
            }
        });
        
        angular.forEach($scope.slotList, function(value, key) {
            if ($scope.loadingAvgReport.slot === value.id) {
                $scope.loadingAvgReport.slotText = value.text;
            }
        });
        angular.forEach($scope.subSlotList, function(value, key) {
            if ($scope.loadingAvgReport.subSlot === value.id) {
                $scope.loadingAvgReport.subSlotText = value.text;
            }
        });
        angular.forEach($scope.serviceList, function(value, key) {
            if ($scope.loadingAvgReport.sectorId === value.id) {
                $scope.loadingAvgReport.serviceText = value.text;
            }
        });
        $http.post('app/loadingAvg/monthlyExcelExport',$scope.loadingAvgReport).success(function(datas) {
           console.log("Loding avg list");
           console.log(datas);
           $("#monthlyExcelLink").bind('click', function() {
           });
           $('#monthlyExcelLink').simulateClick('click');
           logger.logSuccess("Exported successfully!");
       }).error(function(datas) {
       });
    }
    
    $scope.weeklyExcelExport=function(){
        if(($scope.loadingAvgReport.lpol == "")&&
                ($scope.loadingAvgReport.lpod == "")&&
                ($scope.loadingAvgReport.polISO == "")&&
                ($scope.loadingAvgReport.podISO == "")&&
                ($scope.loadingAvgReport.toDate == "")&&
                ($scope.loadingAvgReport.slot == "")&&
                ($scope.loadingAvgReport.subSlot == "")&&
                ($scope.loadingAvgReport.sectorId == "")&&
                ($scope.loadingAvgReport.lfpod == ""))
                 $scope.checkWeekExcel();
        else{
            if(($scope.loadingAvgReport.lpol != "")&&($scope.loadingAvgReport.polISO != ""))
                logger.logError("Please select either POL or POL ISO Code");
            else{
                if(($scope.loadingAvgReport.lpod != "")&&($scope.loadingAvgReport.podISO != ""))
                    logger.logError("Please select either POD or POD ISO Code");
                else{
                    if(($scope.loadingAvgReport.lfpod != "")&&($scope.loadingAvgReport.fpodISO != ""))
                        logger.logError("Please select either FPOD or FPOD ISO Code");
                    else
                         $scope.checkWeekExcel();
                 }
            }
          }
    }
 
    $scope.checkWeekExcel = function(){
        $scope.loadingAvgReport.toDate=  $('#toDate').val();
        angular.forEach($scope.portISOList, function(value, key) {
            if ($scope.loadingAvgReport.polISO === value.id) {
                $scope.loadingAvgReport.polISOText = value.text;
            }
            if ($scope.loadingAvgReport.podISO === value.id) {
                $scope.loadingAvgReport.podISOText = value.text;
            }
            if ($scope.loadingAvgReport.fpodISO === value.id) {
                $scope.loadingAvgReport.fpodISOText = value.text;
            }
        });
        
        angular.forEach($scope.slotList, function(value, key) {
            if ($scope.loadingAvgReport.slot === value.id) {
                $scope.loadingAvgReport.slotText = value.text;
            }
        });
        angular.forEach($scope.subSlotList, function(value, key) {
            if ($scope.loadingAvgReport.subSlot === value.id) {
                $scope.loadingAvgReport.subSlotText = value.text;
            }
        });
        angular.forEach($scope.serviceList, function(value, key) {
            if ($scope.loadingAvgReport.sectorId === value.id) {
                $scope.loadingAvgReport.serviceText = value.text;
            }
        });
        $http.post('app/loadingAvg/weeklyExcelExport',$scope.loadingAvgReport).success(function(datas) {
           console.log("Loding avg list");
           console.log(datas);
           $("#weeklyExcelLink").bind('click', function() {
           });
           $('#weeklyExcelLink').simulateClick('click');
           logger.logSuccess("Exported successfully!");
       }).error(function(datas) {
       });
    }
    
    $('.datetimepick').datetimepicker({
        format : 'DD/MM/YYYY',
        calendarWeeks: true
    });
  
       
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
   
    var d = new Date();
    var currentYear = d.getFullYear();
    
    $scope.polList = [];
    $scope.podList = [];
    
        $http.get('app/commonUtility/getPortList').success(function(datas) {
            $scope.polList = datas;
            $scope.podList = datas;
            $scope.potList =datas;
            //pol list
            $timeout(function() { // You might need this timeout to be sure its run after DOM render.      
                $("#pol").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      console.log(element);
                       var ct=""; 
                       if($scope.polList.length>0){   
                           $scope.loadingAvgReport.pol ='';
                          angular.forEach($scope.loadingAvgReport.lpol, function (item, key) {
                              if(ct==""){
                                  ct = "'"+item.id+"'";
                              }else{
                                  ct +=",'"+ item.id+"'";
                              }       
                              $scope.loadingAvgReport.pol = ct;
                          });
                       }
                    
                       else{
                           $scope.polList = [];
                           $scope.polList = 'Select';
                       }
                    }
                });
                $("#pol").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
            }, 2, false); 
            
            //pod list
            $timeout(function() { // You might need this timeout to be sure its run after DOM render.      
                $("#pod").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      console.log(element);
                       var ct=""; 
                       if($scope.podList.length>0){   
                           $scope.loadingAvgReport.pod ='';
                          angular.forEach($scope.loadingAvgReport.lpod, function (item, key) {
                              if(ct==""){
                                  ct = "'"+item.id+"'";
                              }else{
                                  ct +=",'"+ item.id+"'";
                              }       
                              $scope.loadingAvgReport.pod = ct;
                          });
                       }
                    
                       else{
                           $scope.podList = [];
                           $scope.podList = 'Select';
                       }
                    }
                });
                $("#pod").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
            }, 2, false); 
            
            //fpod list
            $timeout(function() { // You might need this timeout to be sure its run after DOM render.      
                $("#fpod").multiselect({
                    maxHeight: 200,
                    includeSelectAllOption: true,
                    selectAllText: 'Select All',
                    enableFiltering: true,
                    enableCaseInsensitiveFiltering: true,
                    filterPlaceholder: 'Search',
                    onChange: function(element, checked) {
                      console.log(element);
                       var ct=""; 
                       if($scope.potList.length>0){   
                           $scope.loadingAvgReport.fpod ='';
                          angular.forEach($scope.loadingAvgReport.lfpod, function (item, key) {
                              if(ct==""){
                                  ct = "'"+item.id+"'";
                              }else{
                                  ct +=",'"+ item.id+"'";
                              }       
                              $scope.loadingAvgReport.fpod = ct;
                          });
                       }
                    
                       else{
                           $scope.potList = [];
                           $scope.potList = 'Select';
                       }
                    }
                });
                $("#fpod").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
            }, 2, false); 
            
        }).error(function(datas) {
        });
    
    $scope.getPortISOList= function() {
        $http.get('app/commonUtility/getPortISO_portList').success(function(datas) {
            $scope.portISOList = datas;
        }).error(function(datas) {
        });
    }
    
    $scope.subSlotList = [];
    $scope.potList = [];
    $scope.serviceList = [];
    $scope.getDropdownvalue = function() {
        
        $scope.getPortISOList();
        $http.get('app/weekReport/getYear').success(function(datas) {
            console.log("year list");
            console.log(datas);
            $scope.yearList = datas.yearList;
            $scope.loadingAvgReport.year=currentYear;
        }).error(function(data) {
        });
        
        $http.get('app/freightmanifest/slot').success(function(datas) {
            $scope.slotList = datas;
        }).error(function(data) {
        });
        
        $http.get('app/freightmanifest/subSlot').success(function(datas) {
            $scope.subSlotList = datas;
        }).error(function(data) {
        });
        
        /*$http.get('transhipment/summary/getPot').success(function(datas) {
            $scope.potList =datas.potList; 
            console.log("fpod list")
            console.log($scope.potList)
       });*/
        
        $http.get('app/agencyTariff/service').success(function(datas) {
            $scope.serviceList = datas.avgServiceList;
        }).error(function(data) {
        }); 
        
        $scope.weekList=[];
        for(var i=1;i<=52;i++){
            var week={};
            if(i<10){
            week.id='0'+i;
            }else{
                week.id=''+i;
            }
            week.text=''+i;
            $scope.weekList.push(week);
        }
        
        $scope.monthList=[];
        debugger;
        var month={};
        month.id=1;
        month.text='Janaury';
        $scope.monthList.push(month);
        
        month={};
        month.id=2;
        month.text='February';
        $scope.monthList.push(month);
        
        month={};
        month.id=3;
        month.text='March';
        $scope.monthList.push(month);
        
        month={};
        month.id=4;
        month.text='April';
        $scope.monthList.push(month);
        
        month={};
        month.id=5;
        month.text='May';
        $scope.monthList.push(month);
        
        month={};
        month.id=6;
        month.text='June';
        $scope.monthList.push(month);
        
        month={};
        month.id=7;
        month.text='July';
        $scope.monthList.push(month);
        
        month={};
        month.id=8;
        month.text='August';
        $scope.monthList.push(month);
        
        month={};
        month.id=9;
        month.text='September';
        $scope.monthList.push(month);
        
        month={};
        month.id=10;
        month.text='October';
        $scope.monthList.push(month);
        
        month={};
        month.id=11;
        month.text='November';
        $scope.monthList.push(month);
        
        month={};
        month.id=12;
        month.text='December';
        $scope.monthList.push(month);
        
       /* $scope.yearList=[];
        for(var i=2010;i<=2025;i++){
            var year={};
            year.id=i;
            year.text=''+i;
            $scope.yearList.push(year);
        }*/
        console.log($scope.weekList);
    }
    $scope.getDropdownvalue();
    
    
});

