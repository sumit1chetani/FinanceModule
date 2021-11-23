'use strict';
app.controller('loadingAvgReportCtrl', function($scope, $rootScope, $http, $location, $timeout,logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
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
        fromDate:'',
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
    $scope.isWeek=false;
    $scope.monthlyAvgListList={     
            monthList:[],
            loadingAvgReportBeanList:[]
    }
    $scope.reset=function(){
        $scope.loadingAvgReport={
                id:'',
                text:'',
                week:'',
                month:'',
                fromDate:'',
                toDate:'',
                year:'',
                pol:'',
                pod:'',
                polIso:'',
                podIso:'',
                slot:'',
                customerName:'',
                totalTeus:0,
                avgTeus:0,
                totalWeight:0,
                teusList:[]
        }
       // $('#toDate').val('');
        $scope.loadingAvgReport.year=currentYear;
    }
    $scope.viewMonthReport=function(){
        if(($scope.loadingAvgReport.lpol == "")&&
           ($scope.loadingAvgReport.lpod == "")&&
           ($scope.loadingAvgReport.polISO == "")&&
           ($scope.loadingAvgReport.podISO == "")&&
           ($scope.loadingAvgReport.fromDate == "")&&
           ($scope.loadingAvgReport.toDate == "")&&
           ($scope.loadingAvgReport.slot == "")&&
           ($scope.loadingAvgReport.subSlot == "")&&
           ($scope.loadingAvgReport.sectorId == "")&&
           ($scope.loadingAvgReport.lfpod == ""))
            $scope.checkMonthReport();
        else{
            if(($scope.loadingAvgReport.lpol != "")&&($scope.loadingAvgReport.polISO != ""))
                logger.logError("Please select either POL or POL ISO Code");
            else{
                if(($scope.loadingAvgReport.lpod != "")&&($scope.loadingAvgReport.podISO != "")){
                    logger.logError("Please select either POD or POD ISO Code");
                }else{
                    if(($scope.loadingAvgReport.lfpod != "")&&($scope.loadingAvgReport.fpodISO != ""))
                        logger.logError("Please select either FPOD or FPOD ISO Code");
                    else
                        $scope.checkMonthReport();
                }
            }
        }
    }
    
    $scope.checkMonthReport = function(){
        $scope.isWeek=false;
        $scope.loadingAvgReport.fromDate=  $('#fromDate').val();
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
                ($scope.loadingAvgReport.fromDate == "")&&
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
        $scope.loadingAvgReport.fromDate=  $('#fromDate').val();
        $scope.loadingAvgReport.toDate=  $('#toDate').val();
        $http.post('app/loadingAvg/weeklyList',$scope.loadingAvgReport).success(function(datas) {
           console.log("Loding avg list");
           console.log(datas);
           $scope.monthlyAvgListList= datas;
           $scope.rowCollection=  datas.loadingAvgList;
           //$scope.rowCollection=  datas.weekList;
           //$scope.listSize=$scope.monthlyAvgListList.monthList.length;
       }).error(function(datas) {
       });
    }
    
    
    $scope.monthlyExcelExport=function(){
        if(($scope.loadingAvgReport.lpol == "")&&
                ($scope.loadingAvgReport.lpod == "")&&
                ($scope.loadingAvgReport.polISO == "")&&
                ($scope.loadingAvgReport.podISO == "")&&
                ($scope.loadingAvgReport.fromDate == "")&&
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
        $scope.loadingAvgReport.fromDate=  $('#fromDate').val();
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
                ($scope.loadingAvgReport.fromDate == "")&&
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
        $scope.loadingAvgReport.fromDate=  $('#fromDate').val();
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
    
    $('#tb_fromDate').datetimepicker({
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


app.controller('loadingAvgReportCtrlView', function($scope,$sce, $rootScope, $http, $location, logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
    $scope.rowCollection=[];
    var sharedObject=sharedProperties.getObject();
    $scope.rowCollection=sharedObject;
    $scope.loadingAvgReport={
            companyCode:'',
            selectedDate:'',
            vesselCode:'',
            vesselName:'',
            week:'',
            fromDate:'',
            toDate:'',
            COMPLETION_DATE:'',
            SECTOR_ID:'',
            VOYAGE_ID:'',
            THIRD_PARTY:'',
            PERFORMED:'',
            PROFORMA:'',
            PORT_ROTATION:'',
            TEUS:'',
            Revenue:'',
            cost:'',
            profitLoss:'',
            companyName:'',
            id:'',
            text:'',
            year:''
            
    }
    
    $scope.exportVoyageCosting = function(voyageNo) {
       /* var url = 'voyageCosting/exportExcel?voyage=' + voyageNo +'&revenueParam=TRUE' ;
        $http.get(url).success(function(data) {
            console.log(data);
            if (data.success == true) {
                logger.logSuccess("Report Exported successfully!");
                $('#divLikId').append('<a id="voyageCostingExcel" stype="display:none" href="filePath/VoyageCosting.xlsx" download="VoyageCosting.xlsx"></a>');
                $("#voyageCostingExcel").bind('click', function() {
                 });
                 $('#voyageCostingExcel').simulateClick('click');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });*/
        
        $scope.filePath="filePath/VoyageCosting-"+voyageNo+".xlsx";
        $scope.fileName="VoyageCosting-"+voyageNo+".xlsx";
        var url = 'voyageCosting/exportExcel?voyage=' + voyageNo+'&revenueParam=TRUE' ;
        $http.get(url).success(function(data) {
            console.log(data);
            console.log(data.fileName);
            if (data.success == true) {
              //  $scope.voyageCosting.fileName=data.fileName;
                
              //  $scope.voyageCosting.filePath="filePath/VoyageCosting-"+$scope.voyageCosting.voyageNo+".xlsx";
                logger.logSuccess("Report Exported successfully!");
                $("#voyCostXLExport").bind('click', function() {
                });
                $('#voyCostXLExport').simulateClick('click');
              // $('#exportXl').append('<a id="voyCostXLExport" stype="display:none" href="filePath/'+data.fileName+' download="'+data.fileName+'"></a>');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    
    
    $scope.loadingAvgReport.companyCode=$stateParams.companyCode;
    $scope.loadingAvgReport.fromDate=$stateParams.fromDate;
    $scope.loadingAvgReport.toDate=$stateParams.toDate;
    $scope.loadingAvgReport.week=$stateParams.week;
    $scope.loadingAvgReport.year=$stateParams.year;
 //   $scope.loadingAvgReport.selectedDate=$stateParams.selectedDate.replace(/-/g, "/");   
    console.log("view week");
    console.log($scope.loadingAvgReport);
    $scope.viewWeekReport=function(){
        var url = 'app/weekReport/list';
        $http.post('app/weekReport/list',$scope.loadingAvgReport).success(function(data) {
            if (data.success == true) {
                $scope.rowCollection=data.lWeeklyPerformanceBean;
                $scope.loadingAvgReport=data.weeklyPerformanceBean;
                $scope.setTotals1();
              //  sharedProperties.setObject($scope.rowCollection);
             //   $state.go('app.operations.vesselreport.weeklyperformaceView');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    $scope.viewWeekReport();
    
    $scope.pdfReport=function(){
 //       $scope.loadingAvgReport.selectedDate=$stateParams.selectedDate.replace(/-/g, "/");   
        $scope.loadingAvgReport1={};
        $scope.loadingAvgReport1= angular.copy($scope.loadingAvgReport);
        $scope.loadingAvgReport1.companyCode=$stateParams.companyCode;
        $scope.loadingAvgReport1.fromDate=$stateParams.fromDate;
        $scope.loadingAvgReport1.toDate=$stateParams.toDate;
        $scope.loadingAvgReport1.week=$stateParams.week;
        $scope.loadingAvgReport1.year=$stateParams.year;
        
        
        var url = 'app/weekReport/viewPdf';
        $http.post('app/weekReport/viewPdf',$scope.loadingAvgReport1).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Export successfully!");
                $('#divLikId').append('<a id="tbPdfExport" stype="display:none" href="filePath/WeeklyPerformance.pdf" download="WeeklyPerformance.pdf"></a>');
                $("#tbPdfExport").bind('click', function() {
                 });
                 $('#tbPdfExport').simulateClick('click');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    $scope.excelReport=function(){
        $scope.loadingAvgReport1={};
        $scope.loadingAvgReport1= angular.copy($scope.loadingAvgReport);
  //      $scope.loadingAvgReport.selectedDate=$stateParams.selectedDate.replace(/-/g, "/");   
        $scope.loadingAvgReport1.companyCode=$stateParams.companyCode;
        $scope.loadingAvgReport1.fromDate=$stateParams.fromDate;
        $scope.loadingAvgReport1.toDate=$stateParams.toDate;
        $scope.loadingAvgReport1.week=$stateParams.week;
        $scope.loadingAvgReport1.year=$stateParams.year;
        
        $scope.wprFilePath="filePath/WeeklyPerformance-"+$scope.loadingAvgReport1.week+".xls";
        $scope.wprFileName="WeeklyPerformance-"+$scope.loadingAvgReport1.week+".xls";
        
        var url = 'app/weekReport/viewExcel';
        $http.post('app/weekReport/viewExcel',$scope.loadingAvgReport1).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Export successfully!");
                $('#divLikId').append('<a id="wprExcelExport" stype="display:none" href="filePath/WeeklyPerformance-01.xls" download="WeeklyPerformance-01.xls"></a>');
                $("#wprExcelExport").bind('click', function() {
                 });
                 $('#wprExcelExport').simulateClick('click');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    console.log("weeklyPerformanceCtrlView");
  /*  
    $scope.totalTeus=0.0;
    $scope.result = [];
    $scope.prevCompany = '';
    $scope.setTotals = function(item,indx){
      //  console.log("total teus #"+indx);
      //  console.log(item);
        if (item){
        if($scope.prevCompany==item.companyCode && indx>0){
            $scope.totalTeus += parseFloat(item.TEUS);
            angular.copy( $scope.total+indx,$scope.totalTeus);
            console.log($scope.total+indx);
            $scope.result.push($scope.totalTeus);
        }
        else{
            $scope.totalTeus=0.0;
        }
      //  $scope.prevCompany=item.companyCode;
        }
    }
    var i=0;
    $scope.getTotal = function(indx){
        debugger;
        angular.copy( $scope.total.indx,$scope.result1[i]);
      console.log($scope.total.indx);
        i=i+1;
     //  $scope.tot=$sce.trustAsHtml("<span>"+{{val}}+"</span>");
        return"";
    }*/

    
    $scope.resultLength =0;
   
    $scope.totalProformaList = [];
    $scope.totalPerformedList = [];
    $scope.totalTeusList = [];
    $scope.totalRevenueList = [];
    $scope.totalCostList = [];
    $scope.totalPlList = [];
    
    $scope.gTotalProforma = 0;
    $scope.gTotalPerformed =0;
    $scope.gTotalTeus = 0;
    $scope.gTotalRevenue = 0;
    $scope.gTotalCost = 0;
    $scope.gTotalPl = 0;
    
    $scope.setTotals1 = function(){
      var totalProforma=0;
      var totalPerformed=0;
      var totalTeus=0;
      var totalRevenue=0;
      var totalCost=0;
      var totalPl=0;
      var gtProforma=0;
      var gtPerformed=0;
      var gtTeus=0;
      var gtRevenue=0;
      var gtCost=0;
      var gtPl=0;
      $scope.resultLength=$scope.rowCollection.length;
      console.log($scope.rowCollection.length);
        for (var i = 0; i <$scope.rowCollection.length; i++) {
           var weeklyObj=$scope.rowCollection[i];  
           console.log("i="+i);
          if(i==0){
              totalProforma += parseFloat(weeklyObj.PROFORMA);
              totalPerformed += parseFloat(weeklyObj.PERFORMED);              
              totalTeus += parseFloat(weeklyObj.TEUS);
              totalRevenue += parseFloat(weeklyObj.Revenue);
              totalCost += parseFloat(weeklyObj.cost);
              totalPl += parseFloat(weeklyObj.profitLoss);
              $scope.totalProformaList.push(0);
              $scope.totalPerformedList.push(0);
              $scope.totalTeusList.push(0);
              $scope.totalRevenueList.push(0);
              $scope.totalCostList.push(0);
              $scope.totalPlList.push(0);      
             
          }if(i>0 ){
              var weeklyObj1=$scope.rowCollection[i];  
              console.log($scope.prevCompany+"="+weeklyObj1.companyCode );
              if($scope.prevCompany!=weeklyObj1.companyCode ){             
               $scope.totalProformaList.push(totalProforma.toFixed(2));
               $scope.totalPerformedList.push(totalPerformed.toFixed(2));
               $scope.totalTeusList.push(totalTeus);
               $scope.totalRevenueList.push(Math.round(totalRevenue));
               $scope.totalCostList.push(Math.round(totalCost));
               $scope.totalPlList.push(Math.round(totalPl));            
               
               totalProforma=0;
               totalPerformed=0;
                totalTeus=0;
               totalRevenue=0;
               totalCost=0;
               totalPl=0;
              totalProforma += parseFloat(weeklyObj.PROFORMA);
              totalPerformed += parseFloat(weeklyObj.PERFORMED);              
              totalTeus += parseFloat(weeklyObj.TEUS);
              totalRevenue += parseFloat(weeklyObj.Revenue);
              totalCost += parseFloat(weeklyObj.cost);
              totalPl += parseFloat(weeklyObj.profitLoss);
              }
              else{
                  $scope.totalProformaList.push(0);
                  $scope.totalPerformedList.push(0);
                  $scope.totalTeusList.push(0);
                  $scope.totalRevenueList.push(0);
                  $scope.totalCostList.push(0);
                  $scope.totalPlList.push(0);      
                  totalProforma += parseFloat(weeklyObj.PROFORMA);
                  totalPerformed += parseFloat(weeklyObj.PERFORMED);              
                  totalTeus += parseFloat(weeklyObj.TEUS);
                  totalRevenue += parseFloat(weeklyObj.Revenue);
                  totalCost += parseFloat(weeklyObj.cost);
                  totalPl += parseFloat(weeklyObj.profitLoss);
                  
                  console.log($scope.totalTeus);
                 
              }
           }
           
           $scope.prevCompany=weeklyObj.companyCode;
           
           
           gtProforma+=parseFloat(weeklyObj.PROFORMA);
           gtPerformed+=parseFloat(weeklyObj.PERFORMED);      
           gtTeus+=parseFloat(weeklyObj.TEUS);
           gtRevenue+=parseFloat(weeklyObj.Revenue);
           gtCost+=parseFloat(weeklyObj.cost);
           gtPl+=parseFloat(weeklyObj.profitLoss);
        }
        $scope.gTotalProforma = gtProforma.toFixed(2);
        $scope.gTotalPerformed = gtPerformed.toFixed(2);
        $scope.gTotalTeus =  gtTeus;
        $scope.gTotalRevenue =  Math.round(gtRevenue);
        $scope.gTotalCost =  Math.round(gtCost);
        $scope.gTotalPl =  Math.round(gtPl);
        
        $scope.totalProformaList.push(totalProforma.toFixed(2));
        $scope.totalPerformedList.push(totalPerformed.toFixed(2));
        $scope.totalTeusList.push(totalTeus);
        $scope.totalRevenueList.push(Math.round(totalRevenue));
        $scope.totalCostList.push(Math.round(totalCost));
        $scope.totalPlList.push(Math.round(totalPl));            
        console.log("total teus #");
        console.log($scope.totalProformaList);
    }
    
    $scope.cancel = function() {
        $location.path("/operations/vesselreport/weeklyperformace");
    };
});




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
/*
app.filter('wpTotal', function () {
    
       return function (data,key,indx,indx1) {    
           if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
               return 0;
           }
         //  console.log(data);
           var prevIndx=0;
       //  console.log(company1+"="+company2);
           var sum = 0;
           console.log(prevIndx+"="+indx1);
           for (var i = prevIndx; i<indx1; i++) {
               var j=(i+1);
              
              // if(data[i]['companyCode']=="")
                  
                   if(data[i][key]!=null && data[i][key]!="" && data[i][key]!=undefined && data[i][key]!='NaN' && data[i][key]!="-"){
                       console.log(data[i][key]);
                       sum += parseInt(data[i][key]);
                   }
           }          
           prevIndx=indx1;
           console.log("sum="+sum);
           return sum;
       };
   });*/

