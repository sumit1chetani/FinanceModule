'use strict';
app.controller('weeklyPerformanceCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog, utilsService, $state, sharedProperties, $window, $stateParams) {
    $scope.rowCollection = [];
    $scope.weeklyPerformanceReport = {
        companyCode : 'C0001',
        selectedDate : '',
        fromDate : '',
        toDate : '',
        year : '',
        week : ''

    }
    
    $scope.vesselist=[];
    $scope.voyagelist=[];

    var formCode='F0079';

    $scope.voyagesFlag = 'A';
    $scope.tpFlag = 'V';
    
  /*  $http.post($stateParams.tenantid+'/portCosting/vessel', formCode).success(function(data) {
        $scope.vesselist = data.vesselList;
    });*/
    


 /*
    $http.get($stateParams.tenantid+'/app/commonUtility/getVesselList').success(function(datas) {
        $scope.vesselist = datas;
    }).error(function(datas) {
    });
*/
    
    
    //vessel
	
	$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselist = data;
	});
	

    $scope.voyagelist=[];
    $http.get($stateParams.tenantid+'/app/commonUtility/getVoyageList').success(function(datas) {
        $scope.voyagelist = datas;
    }).error(function(datas) {
    });


	/* $scope.$watch('weeklyPerformanceReport.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyagelist = data;
	    	  });
	      }
	    });*/
	 
	 
/*    $scope.$watch('weeklyPerformanceReport.vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        	
   $http.get($stateParams.tenantid+'/app/commonUtility/voyageList?vesselCode='+ $scope.weeklyPerformanceReport.vessel.id).success(function(datas) {

   // $http.get($stateParams.tenantid+'/app/commonUtility/voyageList?vesselCode=' + $scope.weeklyPerformanceReport.vessel.id).success(function(data) {
        $scope.voyagelist = data;  
    });
        }
    });*/
    
    
    $scope.exportExcel = function(){
        if($scope.weeklyPerformanceReport.voyage != '' && $scope.weeklyPerformanceReport.voyage != undefined){
            $http.get($stateParams.tenantid+'/app/weekReport/exportExcel?voyage='+$scope.weeklyPerformanceReport.voyage+'&company='+$scope.weeklyPerformanceReport.companyCode).success(function(data) {
                logger.logSuccess("Report Exported successfully!");
                $("#newRevCostExcelExport").bind('click', function() {
                });
                $('#newRevCostExcelExport').simulateClick('click');
            })

        }
        else{
            logger.logError("Please select the voyage!");
        }
    }
    
    $scope.reset = function() {
        $scope.weeklyPerformanceReport = {
            companyCode : 'C0000',
            selectedDate : '',
            fromDate : '',
            toDate : '',
            year : '',
            week : ''

        }
        $('#fromDate').val('');
        $('#toDate').val('');
        $scope.weeklyPerformanceReport.year = currentYear;
    }
    $scope.viewWeekReport = function() {
    	if((($('#fromDate').val() != '') && ($('#toDate').val() != '')) || (($('#year').val() != '') && ($('#week').val() != ''))  ){
        if ($('#fromDate').val() != '') {
            var fromDate = $('#fromDate').val().replace(/\//g, "-");
            $scope.weeklyPerformanceReport.fromDate = fromDate;
        }
        if ($('#toDate').val() != '') {
            var toDate = $('#toDate').val().replace(/\//g, "-");
            $scope.weeklyPerformanceReport.toDate = toDate;
        }

        $state.go('app.reports.vesselreport.weeklyperformaceView', {
            companyCode : $scope.weeklyPerformanceReport.companyCode,
            fromDate : $scope.weeklyPerformanceReport.fromDate,
            toDate : $scope.weeklyPerformanceReport.toDate,
            week : $scope.weeklyPerformanceReport.week,
            year : $scope.weeklyPerformanceReport.year,
            type : $scope.voyagesFlag,
            tpFlag : $scope.tpFlag
        });
        
    }else{
    	
    	logger.logError("Please select Date range or Week");
    	
    }
    }

    $scope.viewWeekReportConsolidated = function() {
        if ($('#fromDate').val() != '') {
            var fromDate = $('#fromDate').val().replace(/\//g, "-");
            $scope.weeklyPerformanceReport.fromDate = fromDate;
        }
        if ($('#toDate').val() != '') {
            var toDate = $('#toDate').val().replace(/\//g, "-");
            $scope.weeklyPerformanceReport.toDate = toDate;
        }

        $state.go('app.operations.vesselreport.weeklyperformaceView', {
            companyCode : $scope.weeklyPerformanceReport.companyCode,
            fromDate : $scope.weeklyPerformanceReport.fromDate,
            toDate : $scope.weeklyPerformanceReport.toDate,
            week : $scope.weeklyPerformanceReport.week,
            year : $scope.weeklyPerformanceReport.year,
            type : $scope.voyagesFlag,
            tpFlag : 'N'
        });
    }
    
    $('.datetimepick').datetimepicker({
        format : 'DD/MM/YYYY',
        calendarWeeks : true
    });

    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    });

    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime : false
    });

    var d = new Date();
    var currentYear = d.getFullYear();
    $scope.weekList = [];
    $scope.yearList = [];

    $scope.getDropdownvalue = function() {
       
      
   
        for (var j = 2015; j <= 2019; j++) {
            var year = {};
                year.id = j;
                year.text =''+j;
            $scope.yearList.push(year);
        }
        

   
        for (var i = 1; i <= 52; i++) {
            var week = {};
            if (i < 10) {
                week.id = '0' + i;
            } else {
                week.id = '' + i;
            }
            week.text = '' + i;
            $scope.weekList.push(week);
        }

        /*
         * $scope.yearList=[]; for(var i=2010;i<=2025;i++){ var year={};
         * year.id=i; year.text=''+i; $scope.yearList.push(year); }
         */
        console.log($scope.weekList);
    }
    $scope.getDropdownvalue();
    
  
    
	$scope.companyList=[
		 
		  { id: 'C0001', text: 'FREE SEAS' }
		
		
	]
	
	$scope.viewWeekReport = function() {
		
		if((($('#fromDate').val() != '') && ($('#toDate').val() != '')) || (($scope.weeklyPerformanceReport.year != '') && ($scope.weeklyPerformanceReport.week != ''))  ){
		
        if ($('#fromDate').val() != '') {
            var fromDate = $('#fromDate').val().replace(/\//g, "-");
            $scope.weeklyPerformanceReport.fromDate = fromDate;
        }
        if ($('#toDate').val() != '') {
            var toDate = $('#toDate').val().replace(/\//g, "-");
            $scope.weeklyPerformanceReport.toDate = toDate;
        }

        $state.go('app.reports.vesselreport.weeklyperformaceView', {
            companyCode : $scope.weeklyPerformanceReport.companyCode,
            fromDate : $scope.weeklyPerformanceReport.fromDate,
            toDate : $scope.weeklyPerformanceReport.toDate,
            week : $scope.weeklyPerformanceReport.week,
            year : $scope.weeklyPerformanceReport.year
    
        });
    }
        else{
        	
          	logger.logError("Please select Date range or Week");
        	
        }
	
}


});

app.controller('weeklyPerformanceCtrlView', function($scope, $sce, $rootScope, $http, $location, logger, ngDialog, utilsService, $state, sharedProperties, $window, $stateParams) {
    $scope.rowCollection = [];
    var sharedObject = sharedProperties.getObject();
    $scope.rowCollection = sharedObject;
    var department = $("#department").val();
    var userId = $("#userId").val();
    $scope.wpUserId=$("#userId").val();
    $scope.isReview = false;
    $scope.enableReview = false;
    $scope.FinanceSaveButton = false;
    $scope.OpsSaveButton = false;
    $scope.FinalSaveButton = false;
    
    $scope.weeklyPerformanceReport = {
        companyCode : '',
        selectedDate : '',
        vesselCode : '',
        vesselName : '',
        week : '',
        fromDate : '',
        toDate : '',
        COMPLETION_DATE : '',
        SECTOR_ID : '',
        VOYAGE_ID : '',
        THIRD_PARTY : '',
        PERFORMED : '',
        PROFORMA : '',
        PORT_ROTATION : '',
        TEUS : '',
        Revenue : '',
        cost : '',
        profitLoss : '',
        companyName : '',
        id : '',
        text : '',
        year : '',
        vesselOptr : '',
        operType:'',
        voyage:''

    }
    
    $scope.exportExcelWPR = function(voyageNo){
        if(voyageNo != undefined){
            $http.get($stateParams.tenantid+'/app/weekReport/exportExcel?voyage='+voyageNo+'&company='+$stateParams.companyCode).success(function(data) {
                logger.logSuccess("Report Exported successfully!");
                $("#newRevCostExcelExport").bind('click', function() {
                });
                $('#newRevCostExcelExport').simulateClick('click');
            })

        }
        else{
            logger.logError("Please select the voyage!");
        }
    }

    $scope.exportRevenue = function(voyageNo) {
        $scope.weeklyPerformanceReport1 = {};
        $scope.weeklyPerformanceReport1 = angular.copy($scope.weeklyPerformanceReport);
        // $scope.weeklyPerformanceReport.selectedDate=$stateParams.selectedDate.replace(/-/g,
        // "/");
        $scope.weeklyPerformanceReport1.companyCode = $stateParams.companyCode;
        $scope.weeklyPerformanceReport1.fromDate = $stateParams.fromDate;
        $scope.weeklyPerformanceReport1.toDate = $stateParams.toDate;
        $scope.weeklyPerformanceReport1.week = $stateParams.week;
        $scope.weeklyPerformanceReport1.year = $stateParams.year;
        $scope.weeklyPerformanceReport1.type = $stateParams.type;
        $scope.weeklyPerformanceReport1.operType="revenue";
        $scope.weeklyPerformanceReport1.voyage=voyageNo;
        $scope.revFilePath = "filePath/Revenue-" + $scope.weeklyPerformanceReport1.week + ".xls";
        $scope.revFileName = "Revenue-" + $scope.weeklyPerformanceReport1.week + ".xls";

       
        $http.post($stateParams.tenantid+'/app/weekReport/viewRevCostExcel', $scope.weeklyPerformanceReport1).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Exported successfully!");
                $("#revExcelExport").bind('click', function() {
                });
                $('#revExcelExport').simulateClick('click');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    
    
    $scope.viewRevenue = function(voyageNo) {       
      /*  $state.go('app.operations.vesselreport.weeklyperfRevCost', {
            companyCode : $stateParams.companyCode,
            fromDate : $stateParams.fromDate,
            toDate : $stateParams.toDate,
            week : $stateParams.week,
            year : $stateParams.year,
            voyage:voyageNo,
            operType:"revenue"
        });*/
        
        $scope.url="#/operations/vesselreport/weeklyperfRevCost/"+$stateParams.companyCode+"/"+$stateParams.fromDate+"/"+$stateParams.toDate+"/"+$stateParams.week+
        "/"+$stateParams.year+"/"+voyageNo+"/revenue";
    }
   
    $scope.exportCost = function(voyageNo) {
        $scope.weeklyPerformanceReport1 = {};
        $scope.weeklyPerformanceReport1 = angular.copy($scope.weeklyPerformanceReport);
        // $scope.weeklyPerformanceReport.selectedDate=$stateParams.selectedDate.replace(/-/g,
        // "/");
        $scope.weeklyPerformanceReport1.companyCode = $stateParams.companyCode;
        $scope.weeklyPerformanceReport1.fromDate = $stateParams.fromDate;
        $scope.weeklyPerformanceReport1.toDate = $stateParams.toDate;
        $scope.weeklyPerformanceReport1.week = $stateParams.week;
        $scope.weeklyPerformanceReport1.year = $stateParams.year;
        $scope.weeklyPerformanceReport1.operType="cost";
        $scope.weeklyPerformanceReport1.voyage=voyageNo;
        $scope.costFilePath = "filePath/Cost-" + $scope.weeklyPerformanceReport1.week + ".xls";
        $scope.costFileName = "Cost-" + $scope.weeklyPerformanceReport1.week + ".xls";

       
        $http.post($stateParams.tenantid+'/app/weekReport/viewRevCostExcel', $scope.weeklyPerformanceReport1).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Exported successfully!");
                $("#costExcelExport").bind('click', function() {
                });
                $('#costExcelExport').simulateClick('click');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    
    $scope.viewCost = function(voyageNo) {       
      /*  $state.go('app.operations.vesselreport.weeklyperfRevCost', {
            companyCode : $stateParams.companyCode,
            fromDate : $stateParams.fromDate,
            toDate : $stateParams.toDate,
            week : $stateParams.week,
            year : $stateParams.year,
            voyage:voyageNo,
            operType:"cost"
        });*/
        $scope.url="#/operations/vesselreport/weeklyperfRevCost/"+$stateParams.companyCode+"/"+$stateParams.fromDate+"/"+$stateParams.toDate+"/"+$stateParams.week+
        "/"+$stateParams.year+"/"+voyageNo+"/cost";
    }
    $scope.exportTeus = function(weekObj) {
        $scope.weeklyPerformanceReport1 = {};
        $scope.weeklyPerformanceReport1 = angular.copy($scope.weeklyPerformanceReport);
        // $scope.weeklyPerformanceReport.selectedDate=$stateParams.selectedDate.replace(/-/g,
        // "/");
        $scope.weeklyPerformanceReport1.companyCode = $stateParams.companyCode;
        $scope.weeklyPerformanceReport1.fromDate = $stateParams.fromDate;
        $scope.weeklyPerformanceReport1.toDate = $stateParams.toDate;
        $scope.weeklyPerformanceReport1.week = $stateParams.week;
        $scope.weeklyPerformanceReport1.year = $stateParams.year;
        $scope.weeklyPerformanceReport1.operType=weekObj.operType;
        $scope.weeklyPerformanceReport1.voyage=weekObj.VOYAGE_ID;
        $scope.weeklyPerformanceReport1.vesselOptr=weekObj.vesselOptr;
      //  alert(weekObj.THIRD_PARTY+" "+weekObj.vesselOptr);
        $scope.teusFilePath = "filePath/WPR_Teus_Week-" + $scope.weeklyPerformanceReport1.week + ".xlsx";
        $scope.teusFileName = "WPR_Teus_Week-" + $scope.weeklyPerformanceReport1.week + ".xlsx";

       
        $http.post($stateParams.tenantid+'/app/weekReport/teusExcelExport', $scope.weeklyPerformanceReport1).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Exported successfully!");
                $("#teusExcelExport").bind('click', function() {
                });
                $('#teusExcelExport').simulateClick('click');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    $scope.viewTeus = function(weekObj) {       
      
          $scope.url="#/operations/vesselreport/weeklyperfTeus/"+$stateParams.companyCode+"/"+
          $stateParams.fromDate+"/"+$stateParams.toDate+"/"+$stateParams.week+
          "/"+$stateParams.year+"/"+weekObj.VOYAGE_ID+"/"+weekObj.THIRD_PARTY+"/"+weekObj.vesselOptr;
      }
    
    $scope.exportVoyageCosting = function(voyageNo) {
        /*
         * var url = 'voyageCosting/exportExcel?voyage=' + voyageNo
         * +'&revenueParam=TRUE' ; $http.get(url).success(function(data) {
         * console.log(data); if (data.success == true) {
         * logger.logSuccess("Report Exported successfully!");
         * $('#divLikId').append('<a id="voyageCostingExcel"
         * stype="display:none" href="filePath/VoyageCosting.xlsx"
         * download="VoyageCosting.xlsx"></a>');
         * $("#voyageCostingExcel").bind('click', function() { });
         * $('#voyageCostingExcel').simulateClick('click'); }
         * }).error(function(data) { logger.logError("Error Please Try Again");
         * });
         */

        $scope.filePath = "filePath/VoyageCosting-" + voyageNo + ".xlsx";
        $scope.fileName = "VoyageCosting-" + voyageNo + ".xlsx";
        var url = $stateParams.tenantid+'/voyageCosting/exportExcel?voyage=' + voyageNo + '&revenueParam=TRUE';
        $http.get(url).success(function(data) {
            console.log(data);
            console.log(data.fileName);
            if (data.success == true) {
                // $scope.voyageCosting.fileName=data.fileName;

                // $scope.voyageCosting.filePath="filePath/VoyageCosting-"+$scope.voyageCosting.voyageNo+".xlsx";
                logger.logSuccess("Report Exported successfully!");
                $("#voyCostXLExport").bind('click', function() {
                });
                $('#voyCostXLExport').simulateClick('click');
                // $('#exportXl').append('<a id="voyCostXLExport"
                // stype="display:none" href="filePath/'+data.fileName+'
                // download="'+data.fileName+'"></a>');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }

    $scope.weeklyPerformanceReport.companyCode = $stateParams.companyCode;
    $scope.weeklyPerformanceReport.fromDate = $stateParams.fromDate;
    $scope.weeklyPerformanceReport.toDate = $stateParams.toDate;
    $scope.weeklyPerformanceReport.week = $stateParams.week;
    $scope.weeklyPerformanceReport.year = $stateParams.year;
    $scope.weeklyPerformanceReport.type = $stateParams.type;
    $scope.weeklyPerformanceReport.tpFlag = $stateParams.tpFlag;
    // $scope.weeklyPerformanceReport.selectedDate=$stateParams.selectedDate.replace(/-/g,
    // "/");
    console.log("view week");
    console.log($scope.weeklyPerformanceReport);
    
    $scope.viewWeekReport = function() {
        var url =  $stateParams.tenantid+'/app/weekReport/list';
        $http.post($stateParams.tenantid+'/app/weekReport/list', $scope.weeklyPerformanceReport).success(function(data) {
            if (!data.success) {
                $scope.rowCollection = data.tpWeeklyPerformanceBean;
                
 
                
                      $scope.tottues=data.tottues;
                      $scope.totrev=data.totrev;
                      $scope.totcost=data.totcost;
                      $scope.totpnl=data.totpnl;
                      
                      $scope.weeklyPerformanceReport.fromDate = data.fromDate;
                      $scope.weeklyPerformanceReport.toDate = data.toDate;
            
    /*            if(data.finReviewSaved && $scope.isDatewise==false){*/
                    $scope.FinanceSaveButton=false;
                /*}else{
                    if(data.finReviewSaved==false && userId=='E108' && $scope.isDatewise==false){
                        $scope.FinanceSaveButton=true;
                    }
                }*/
              /*  if(data.opsReviewSaved && $scope.isDatewise==false){
                    $scope.OpsSaveButton=false;
                }else{
                    if(data.opsReviewSaved==false && (userId=='E402'|| userId=='E180') && $scope.isDatewise==false){
                        $scope.OpsSaveButton=true;
                    }
                }
                if(data.finalReviewSaved && $scope.isDatewise==false){
                    $scope.FinalSaveButton=false;
                }else{
                    if(data.finalReviewSaved==false && userId=='E046' && $scope.isDatewise==false){
                        $scope.FinalSaveButton=true;
                    }
                }*/
                // sharedProperties.setObject($scope.rowCollection);
                // $state.go('app.operations.vesselreport.weeklyperformaceView');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    $scope.viewWeekReport();

    $scope.pdfReport = function() {
        // $scope.weeklyPerformanceReport.selectedDate=$stateParams.selectedDate.replace(/-/g,
        // "/");
        $scope.weeklyPerformanceReport1 = {};
        $scope.weeklyPerformanceReport1 = angular.copy($scope.weeklyPerformanceReport);
        $scope.weeklyPerformanceReport1.companyCode = $stateParams.companyCode;
        $scope.weeklyPerformanceReport1.fromDate = $stateParams.fromDate;
        $scope.weeklyPerformanceReport1.toDate = $stateParams.toDate;
        $scope.weeklyPerformanceReport1.week = $stateParams.week;
        $scope.weeklyPerformanceReport1.year = $stateParams.year;
        $scope.weeklyPerformanceReport1.type = $stateParams.type;
        $scope.weeklyPerformanceReport1.tpFlag = $stateParams.tpFlag;

        var url =  $stateParams.tenantid+'/app/weekReport/viewPdf';
        $http.post($stateParams.tenantid+'/app/weekReport/viewPdf', $scope.weeklyPerformanceReport1).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Exported successfully!");
               /* $('#divLikId').append('<a id="tbPdfExport" stype="display:none" href="filePath/WeeklyPerformance.pdf" download="WeeklyPerformance.pdf"></a>');*/
                $("#tbPdfExport").bind('click', function() {
                });
                $('#tbPdfExport').simulateClick('click');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    
    $scope.refreshReport = function() {
        // $scope.weeklyPerformanceReport.selectedDate=$stateParams.selectedDate.replace(/-/g,
        // "/");
        $scope.weeklyPerformanceReport1 = {};
        $scope.weeklyPerformanceReport1 = angular.copy($scope.weeklyPerformanceReport);
        $scope.weeklyPerformanceReport1.companyCode = $stateParams.companyCode;
        $scope.weeklyPerformanceReport1.fromDate = $stateParams.fromDate;
        $scope.weeklyPerformanceReport1.toDate = $stateParams.toDate;
        $scope.weeklyPerformanceReport1.week = $stateParams.week;
        $scope.weeklyPerformanceReport1.year = $stateParams.year;
        $scope.weeklyPerformanceReport1.type = $stateParams.type;
        $scope.weeklyPerformanceReport1.tpFlag = $stateParams.tpFlag;

       
        $http.post($stateParams.tenantid+'/app/weekReport/refresh', $scope.weeklyPerformanceReport1).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Refreshed Successfully!");
                $state.reload();
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    
    $scope.excelReport = function() {
        $scope.weeklyPerformanceReport1 = {};
        $scope.weeklyPerformanceReport1 = angular.copy($scope.weeklyPerformanceReport);
        // $scope.weeklyPerformanceReport.selectedDate=$stateParams.selectedDate.replace(/-/g,
        // "/");
        $scope.weeklyPerformanceReport1.companyCode = $stateParams.companyCode;
        $scope.weeklyPerformanceReport1.fromDate = $stateParams.fromDate;
        $scope.weeklyPerformanceReport1.toDate = $stateParams.toDate;
        $scope.weeklyPerformanceReport1.week = $stateParams.week;
        $scope.weeklyPerformanceReport1.year = $stateParams.year;
       
        $scope.wprFilePath = "filePath/WeeklyPerformanceReport.xls";
        $scope.wprFileName = "WeeklyPerformanceReport.xls";

        var url =  $stateParams.tenantid+'/app/weekReport/viewExcel';
        $http.post($stateParams.tenantid+'/app/weekReport/viewExcel', $scope.weeklyPerformanceReport1).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Exported successfully!");
              /*  $('#divLikId').append('<a id="wprExcelExport" stype="display:none" href="'+data.path+'WeeklyPerformanceReport.xls" download="WeeklyPerformanceReport.xls"></a>');*/
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
     * $scope.totalTeus=0.0; $scope.result = []; $scope.prevCompany = '';
     * $scope.setTotals = function(item,indx){ // console.log("total teus
     * #"+indx); // console.log(item); if (item){
     * if($scope.prevCompany==item.companyCode && indx>0){ $scope.totalTeus +=
     * parseFloat(item.TEUS); angular.copy( $scope.total+indx,$scope.totalTeus);
     * console.log($scope.total+indx); $scope.result.push($scope.totalTeus); }
     * else{ $scope.totalTeus=0.0; } // $scope.prevCompany=item.companyCode; } }
     * var i=0; $scope.getTotal = function(indx){ debugger; angular.copy(
     * $scope.total.indx,$scope.result1[i]); console.log($scope.total.indx);
     * i=i+1; // $scope.tot=$sce.trustAsHtml("<span>"+{{val}}+"</span>");
     * return""; }
     */

    $scope.resultLength = 0;

    $scope.totalProformaList = [];
    $scope.totalPerformedList = [];
    $scope.totalTeusList = [];
    $scope.totalRevenueList = [];
    $scope.totalCostList = [];
    $scope.totalPlList = [];
    $scope.totalPCList = [];
    $scope.totalTCList = [];

    $scope.gTotalProforma = 0;
    $scope.gTotalPerformed = 0;
    $scope.gTotalTeus = 0;
    $scope.gTotalRevenue = 0;
    $scope.gTotalCost = 0;
    $scope.gTotalPR = 0;
    $scope.gTotalPC = 0;
    $scope.gTotalCR = 0;
    $scope.gTotalCC = 0;
    $scope.gTotalTR = 0;
    $scope.gTotalTC = 0;
    $scope.gTotalPl = 0;
    $scope.setTotals1 = function() {
        var totalProforma = 0;
        var totalPerformed = 0;
        var totalTeus = 0;
        var totalRevenue = 0;
        var totalCost = 0;
        var totalPR = 0;
        var totalPC=0;
        var totalCR=0;//currRevenue
        var totalCC=0;//currCost
        var totalTR=0;
        var totalTC=0;
        var totalPl = 0;
        
        var gtProforma = 0;
        var gtPerformed = 0;
        var gtTeus = 0;
        var gtRevenue = 0;
        var gtCost = 0;
        var gtPR = 0;
        var gtPC = 0;
        var gtCR = 0;
        var gtCC = 0;
        var gtTR = 0;
        var gtTC = 0;
        var gtPl = 0;
        $scope.resultLength = $scope.rowCollection.length;
        console.log($scope.rowCollection.length);
        for (var i = 0; i < $scope.rowCollection.length; i++) {
            var weeklyObj = $scope.rowCollection[i];
            console.log("i=" + i);
            if (i == 0) {
                totalProforma += parseFloat(weeklyObj.PROFORMA);
                totalPerformed += parseFloat(weeklyObj.PERFORMED);
                totalTeus += parseFloat(weeklyObj.TEUS);
                totalRevenue += parseFloat(weeklyObj.Revenue);
                totalCost += parseFloat(weeklyObj.cost);
                totalPR += parseFloat(weeklyObj.provisionalRevenue);
                totalPC += parseFloat(weeklyObj.provisionalCost);
                totalCR += parseFloat(weeklyObj.currRevenue);
                totalCC += parseFloat(weeklyObj.currCost);
                totalTR += parseFloat(weeklyObj.totalRevenue);
                totalTC += parseFloat(weeklyObj.totalCost);
                totalPl += parseFloat(weeklyObj.profitLoss);
                $scope.totalProformaList.push(0);
                $scope.totalPerformedList.push(0);
                $scope.totalTeusList.push(0);
                $scope.totalRevenueList.push(0);
                $scope.totalCostList.push(0);
                $scope.totalPlList.push(0);
                $scope.totalPCList.push(0);
                $scope.totalTCList.push(0);
            }
            if (i > 0) {
                var weeklyObj1 = $scope.rowCollection[i];
                console.log($scope.prevCompany + "=" + weeklyObj1.companyCode);
                if ($scope.prevCompany != weeklyObj1.companyCode) {
                    $scope.totalProformaList.push(totalProforma.toFixed(2));
                    $scope.totalPerformedList.push(totalPerformed.toFixed(2));
                    $scope.totalTeusList.push(totalTeus);
                    $scope.totalRevenueList.push(Math.round(totalRevenue));
                    $scope.totalCostList.push(Math.round(totalCost));
                    $scope.totalPlList.push(Math.round(totalPl));
                    $scope.totalPCList.push(Math.round(totalPC));
                    $scope.totalTCList.push(Math.round(totalTC));
                    totalProforma = 0;
                    totalPerformed = 0;
                    totalTeus = 0;
                    totalRevenue = 0;
                    totalCost = 0;
                    totalPl = 0;
                    totalPC = 0;
                    totalTC = 0;
                    totalProforma += parseFloat(weeklyObj.PROFORMA);
                    totalPerformed += parseFloat(weeklyObj.PERFORMED);
                    totalTeus += parseFloat(weeklyObj.TEUS);
                    totalRevenue += parseFloat(weeklyObj.Revenue);
                    totalCost += parseFloat(weeklyObj.cost);
                    totalPl += parseFloat(weeklyObj.profitLoss);
                    totalPC += parseFloat(weeklyObj.provisionalCost);
                    totalTC += parseFloat(weeklyObj.totalCost);
                } else {
                    $scope.totalProformaList.push(0);
                    $scope.totalPerformedList.push(0);
                    $scope.totalTeusList.push(0);
                    $scope.totalRevenueList.push(0);
                    $scope.totalCostList.push(0);
                    $scope.totalPlList.push(0);
                    $scope.totalPCList.push(0);
                    $scope.totalTCList.push(0);
                    totalProforma += parseFloat(weeklyObj.PROFORMA);
                    totalPerformed += parseFloat(weeklyObj.PERFORMED);
                    totalTeus += parseFloat(weeklyObj.TEUS);
                    totalRevenue += parseFloat(weeklyObj.Revenue);
                    totalCost += parseFloat(weeklyObj.cost);
                    totalPl += parseFloat(weeklyObj.profitLoss);
                     totalPC += parseFloat(weeklyObj.provisionalCost);
                    totalTC += parseFloat(weeklyObj.totalCost);
                    console.log($scope.totalTeus);

                }
            }

            $scope.prevCompany = weeklyObj.companyCode;

            gtProforma += parseFloat(weeklyObj.PROFORMA);
            gtPerformed += parseFloat(weeklyObj.PERFORMED);
            gtTeus += parseFloat(weeklyObj.TEUS);
            gtRevenue += parseFloat(weeklyObj.Revenue);
            gtCost += parseFloat(weeklyObj.cost);
            gtPR += parseFloat(weeklyObj.provisionalRevenue);
            gtPC += parseFloat(weeklyObj.provisionalCost);
            gtCR += parseFloat(weeklyObj.currRevenue);
            gtCC += parseFloat(weeklyObj.currCost);
            gtTR += parseFloat(weeklyObj.totalRevenue);
            gtTC += parseFloat(weeklyObj.totalCost);
            gtPl += parseFloat(weeklyObj.profitLoss);
        }
        
        for (var i = 0; i < $scope.rowCollection1.length; i++) {
            var weeklyObj = $scope.rowCollection1[i];
            console.log("i=" + i);
            if (i == 0) {
                totalProforma += parseFloat(weeklyObj.PROFORMA);
                totalPerformed += parseFloat(weeklyObj.PERFORMED);
                totalTeus += parseFloat(weeklyObj.TEUS);
                totalRevenue += parseFloat(weeklyObj.Revenue);
                totalCost += parseFloat(weeklyObj.cost);
                totalPl += parseFloat(weeklyObj.profitLoss);
                totalPC += parseFloat(weeklyObj.provisionalCost);
                totalTC += parseFloat(weeklyObj.totalCost);
                $scope.totalProformaList.push(0);
                $scope.totalPerformedList.push(0);
                $scope.totalTeusList.push(0);
                $scope.totalRevenueList.push(0);
                $scope.totalCostList.push(0);
                $scope.totalPlList.push(0);
                $scope.totalPCList.push(0);
                $scope.totalTCList.push(0);
            }
            if (i > 0) {
                var weeklyObj1 = $scope.rowCollection1[i];
                console.log($scope.prevCompany + "=" + weeklyObj1.companyCode);
                if ($scope.prevCompany != weeklyObj1.companyCode) {
                    $scope.totalProformaList.push(totalProforma.toFixed(2));
                    $scope.totalPerformedList.push(totalPerformed.toFixed(2));
                    $scope.totalTeusList.push(totalTeus);
                    $scope.totalRevenueList.push(Math.round(totalRevenue));
                    $scope.totalCostList.push(Math.round(totalCost));
                    $scope.totalPlList.push(Math.round(totalPl));
                    $scope.totalPCList.push(Math.round(totalPC));
                    $scope.totalTCList.push(Math.round(totalTC));
                    totalProforma = 0;
                    totalPerformed = 0;
                    totalTeus = 0;
                    totalRevenue = 0;
                    totalCost = 0;
                    totalPl = 0;
                    totalPC = 0;
                    totalProforma += parseFloat(weeklyObj.PROFORMA);
                    totalPerformed += parseFloat(weeklyObj.PERFORMED);
                    totalTeus += parseFloat(weeklyObj.TEUS);
                    totalRevenue += parseFloat(weeklyObj.Revenue);
                    totalCost += parseFloat(weeklyObj.cost);
                    totalPl += parseFloat(weeklyObj.profitLoss);
                    totalPC += parseFloat(weeklyObj.provisionalCost);
                    totalTC += parseFloat(weeklyObj.totalCost);
                } else {
                    $scope.totalProformaList.push(0);
                    $scope.totalPerformedList.push(0);
                    $scope.totalTeusList.push(0);
                    $scope.totalRevenueList.push(0);
                    $scope.totalCostList.push(0);
                    $scope.totalPlList.push(0);
                    $scope.totalPCList.push(0);
                    $scope.totalTCList.push(0);
                    totalProforma += parseFloat(weeklyObj.PROFORMA);
                    totalPerformed += parseFloat(weeklyObj.PERFORMED);
                    totalTeus += parseFloat(weeklyObj.TEUS);
                    totalRevenue += parseFloat(weeklyObj.Revenue);
                    totalCost += parseFloat(weeklyObj.cost);
                    totalPl += parseFloat(weeklyObj.profitLoss);
                    totalPC += parseFloat(weeklyObj.provisionalCost);
                    totalTC += parseFloat(weeklyObj.totalCost);

                    console.log($scope.totalTeus);

                }
            }

            $scope.prevCompany = weeklyObj.companyCode;

            gtProforma += parseFloat(weeklyObj.PROFORMA);
            gtPerformed += parseFloat(weeklyObj.PERFORMED);
            gtTeus += parseFloat(weeklyObj.TEUS);
            gtRevenue += parseFloat(weeklyObj.Revenue);
            gtCost += parseFloat(weeklyObj.cost);
            gtPR += parseFloat(weeklyObj.provisionalRevenue);
            gtPC += parseFloat(weeklyObj.provisionalCost);
            gtCR += parseFloat(weeklyObj.currRevenue);
            gtCC += parseFloat(weeklyObj.currCost);
            gtTR += parseFloat(weeklyObj.totalRevenue);
            gtTC += parseFloat(weeklyObj.totalCost);
            gtPl += parseFloat(weeklyObj.profitLoss);
        }
        
        $scope.gTotalProforma = gtProforma.toFixed(2);
        $scope.gTotalPerformed = gtPerformed.toFixed(2);
        $scope.gTotalTeus = gtTeus;
        $scope.gTotalRevenue = Math.round(gtRevenue);
        $scope.gTotalCost = Math.round(gtCost);
        $scope.gTotalPR = Math.round(gtPR);
        $scope.gTotalPC = Math.round(gtPC);
        $scope.gTotalCR = Math.round(gtCR);
        $scope.gTotalCC = Math.round(gtCC);
        $scope.gTotalTR = Math.round(gtTR);
        $scope.gTotalTC = Math.round(gtTC);
        $scope.gTotalPl = Math.round(gtPl);
        $scope.totalProformaList.push(totalProforma.toFixed(2));
        $scope.totalPerformedList.push(totalPerformed.toFixed(2));
        $scope.totalTeusList.push(totalTeus);
        $scope.totalRevenueList.push(Math.round(totalRevenue));
        $scope.totalCostList.push(Math.round(totalCost));
        $scope.totalPlList.push(Math.round(totalPl));
        $scope.totalPCList.push(Math.round(totalPC));
        $scope.totalTCList.push(Math.round(totalTC));
        console.log("total teus #");
        console.log($scope.totalProformaList);
    }

    $scope.cancel = function() {
    	$state.go('app.reports.vesselreport.weeklyperformace',{tenantid:$stateParams.tenantid});
    };
    
   $scope.saveReview = function(flag){
        
        $scope. resBean = {
                lWeeklyPerformanceBean : $scope.rowCollection,
                tpWeeklyPerformanceBean : $scope.rowCollection1,
                weeklyPerformanceBean : $scope.weeklyPerformanceReport,
                saveFlag : flag,
                tpFlag : $stateParams.tpFlag
        }
        
        $http.post($stateParams.tenantid+'/app/weekReport/saveWPRReview', $scope.resBean).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Saved Successfully!");
            }else{
                if(data.errors!=null && data.errors!=''){
                    logger.logError(data.errors);
                }else{
                    logger.logError("Error Please Try Again!");                    
                }
            }
            $state.reload();
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        
    }
    
    
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
 * app.filter('wpTotal', function () {
 * 
 * return function (data,key,indx,indx1) { if (typeof (data) === 'undefined' ||
 * typeof (key) === 'undefined') { return 0; } // console.log(data); var
 * prevIndx=0; // console.log(company1+"="+company2); var sum = 0;
 * console.log(prevIndx+"="+indx1); for (var i = prevIndx; i<indx1; i++) { var
 * j=(i+1);
 *  // if(data[i]['companyCode']=="")
 * 
 * if(data[i][key]!=null && data[i][key]!="" && data[i][key]!=undefined &&
 * data[i][key]!='NaN' && data[i][key]!="-"){ console.log(data[i][key]); sum +=
 * parseInt(data[i][key]); } } prevIndx=indx1; console.log("sum="+sum); return
 * sum; }; });
 */
app.controller('weeklyPerfTeusCtrl', function($scope, $sce, $rootScope, $http, $location, logger, ngDialog, utilsService, $state, sharedProperties, $window, $stateParams) {
    $scope.weeklyPerformanceReport = {
            companyCode : '',
            selectedDate : '',
            vesselCode : '',
            vesselName : '',
            week : '',
            fromDate : '',
            toDate : '',
            COMPLETION_DATE : '',
            SECTOR_ID : '',
            VOYAGE_ID : '',
            THIRD_PARTY : '',
            PERFORMED : '',
            PROFORMA : '',
            PORT_ROTATION : '',
            TEUS : '',
            Revenue : '',
            cost : '',
            profitLoss : '',
            companyName : '',
            id : '',
            text : '',
            year : '',
            vesselOptr : '',
            operType:'',
            voyage:''

        }
    $scope.viewTeus = function(weekObj) {
        $scope.freightManifestBean = {
                vesselId : '',
                vesselName : '',
                slotId : '',
                slotAc : '',
                subSlotCode:'',
                pol : '',
                pod : '',            
                sectorName : '',      
                mloId:'',
                sailingFromDate:'',
                sailingToDate:'',
                voucherFromDate:'',
                voucherToDate:'',
                voyageNo : '',
                sectorId : '',
                invoiceNo:'',
                quotation :'',
                polList:[],
                podList:[]
                
            };
        $scope.freightManifestBean.voyageNo=$stateParams.voyage;
        $scope.freightManifestBean.slotId="BA1000";
        
        if($stateParams.operType=='T' && $stateParams.vesselOptr!='YML'){
            $scope.freightManifestBean.sailingFromDate=$stateParams.fromDate;
            $scope.freightManifestBean.sailingToDate=$stateParams.toDate;
         }
    
        $http.post($stateParams.tenantid+'/app/freightmanifest/viewReport',$scope.freightManifestBean ).success(function(data) {
            console.log("data");
            console.log(data);
            if (data.success == true) {
                $scope.containerTypeList = data.containerList;
                $scope.containerQtyList =data.dynamicConList;
                $scope.loadingList =data.loadingList;
                $scope.listSize2 =data.listSize2;$stateParams
                $scope.portList =data.portList;
                 
            } else {
                if ($scope.dataLoopCount == 0) {
                    $scope.showEmptyLabel = true;
                }
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    $scope.viewTeus()
    $scope.exportTeus = function(weekObj) {
        $scope.weeklyPerformanceReport1 = {};
        $scope.weeklyPerformanceReport1 = angular.copy($scope.weeklyPerformanceReport);
        // $scope.weeklyPerformanceReport.selectedDate=$stateParams.selectedDate.replace(/-/g,
        // "/");
        $scope.weeklyPerformanceReport1.companyCode = $stateParams.companyCode;
        $scope.weeklyPerformanceReport1.fromDate = $stateParams.fromDate;
        $scope.weeklyPerformanceReport1.toDate = $stateParams.toDate;
        $scope.weeklyPerformanceReport1.week = $stateParams.week;
        $scope.weeklyPerformanceReport1.year = $stateParams.year;
        $scope.weeklyPerformanceReport1.operType=$stateParams.operType;
        $scope.weeklyPerformanceReport1.voyage=$stateParams.voyage;
        $scope.weeklyPerformanceReport1.vesselOptr=$stateParams.vesselOptr;
      //  alert(weekObj.THIRD_PARTY+" "+weekObj.vesselOptr);
        $scope.teusFilePath = "filePath/WPR_Teus_Week-" + $scope.weeklyPerformanceReport1.week + ".xlsx";
        $scope.teusFileName = "WPR_Teus_Week-" + $scope.weeklyPerformanceReport1.week + ".xlsx";

       
        $http.post($stateParams.tenantid+'/app/weekReport/teusExcelExport', $scope.weeklyPerformanceReport1).success(function(data) {
            if (data.success == true) {
                logger.logSuccess("Report Exported successfully!");
                $("#teusExcelExport").bind('click', function() {
                });
                $('#teusExcelExport').simulateClick('click');
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    $scope.cancel = function() {
        $location.path("/operations/vesselreport/weeklyperformace");
    };
});
app.controller('weeklyPerfRevCostCtrl', function($scope, $sce, $rootScope, $http, $location, logger, ngDialog, utilsService, $state, sharedProperties, $window, $stateParams) {
    
    $scope.weeklyPerformanceReport = {
            companyCode : '',
            selectedDate : '',
            vesselCode : '',
            vesselName : '',
            week : '',
            fromDate : '',
            toDate : '',
            COMPLETION_DATE : '',
            SECTOR_ID : '',
            VOYAGE_ID : '',
            THIRD_PARTY : '',
            PERFORMED : '',
            PROFORMA : '',
            PORT_ROTATION : '',
            TEUS : '',
            Revenue : '',
            cost : '',
            profitLoss : '',
            companyName : '',
            id : '',
            text : '',
            year : '',
            vesselOptr : '',
            operType:'',
            voyage:''

        }
    
$scope.viewRevenueCost = function(voyageNo) {
        $scope.weeklyPerformanceReport1 = {};
       
        $scope.weeklyPerformanceReport1.companyCode = $stateParams.companyCode;
        $scope.weeklyPerformanceReport1.fromDate = $stateParams.fromDate;
        $scope.weeklyPerformanceReport1.toDate = $stateParams.toDate;
        $scope.weeklyPerformanceReport1.week = $stateParams.week;
        $scope.weeklyPerformanceReport1.year = $stateParams.year;
        $scope.weeklyPerformanceReport1.operType=$stateParams.operType;
        $scope.weeklyPerformanceReport1.voyage=$stateParams.voyage;
       
        $('.LoadingIndicator').show();
        $http.post($stateParams.tenantid+'/app/weekReport/viewRevCost', $scope.weeklyPerformanceReport1).success(function(data) {
            if (data.success == true) {
             console.log(data);
             $scope.weeklyPerformanceBean=data.weeklyPerformanceBean;
             $('.LoadingIndicator').hide();
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
$scope.viewRevenueCost();
$scope.excelExport = function() {
    $scope.weeklyPerformanceReport1 = {};
    $scope.weeklyPerformanceReport1 = angular.copy($scope.weeklyPerformanceReport);
    // $scope.weeklyPerformanceReport.selectedDate=$stateParams.selectedDate.replace(/-/g,
    // "/");
    $scope.weeklyPerformanceReport1.companyCode = $stateParams.companyCode;
    $scope.weeklyPerformanceReport1.fromDate = $stateParams.fromDate;
    $scope.weeklyPerformanceReport1.toDate = $stateParams.toDate;
    $scope.weeklyPerformanceReport1.week = $stateParams.week;
    $scope.weeklyPerformanceReport1.year = $stateParams.year;
    $scope.weeklyPerformanceReport1.operType=$stateParams.operType;
    $scope.weeklyPerformanceReport1.voyage=$stateParams.voyage;
    $scope.revFilePath = "filePath/Revenue-" + $scope.weeklyPerformanceReport1.week + ".xls";
    $scope.revFileName = "Revenue-" + $scope.weeklyPerformanceReport1.week + ".xls";

    if($stateParams.operType=='cost'){
        $scope.costFilePath = "filePath/Cost-" + $scope.weeklyPerformanceReport1.week + ".xls";
        $scope.costFileName = "Cost-" + $scope.weeklyPerformanceReport1.week + ".xls";

    }
   
   
    $http.post($stateParams.tenantid+'/app/weekReport/viewRevCostExcel', $scope.weeklyPerformanceReport1).success(function(data) {
        if (data.success == true) {
            if($stateParams.operType=='cost'){
                logger.logSuccess("Report Exported successfully!");
                $("#costExcelExport").bind('click', function() {
                });
                $('#costExcelExport').simulateClick('click');
            }else{
                logger.logSuccess("Report Exported successfully!");
                $("#revExcelExport").bind('click', function() {
                });
                $('#revExcelExport').simulateClick('click');
            }
         
        }
    }).error(function(data) {
        logger.logError("Error Please Try Again");
    });
}
$scope.cancel = function() {
    $location.path("/operations/vesselreport/weeklyperformace");
};
});

app.controller('wprchangeCtrl', function($scope, $sce, $rootScope, $http, $location, logger, ngDialog, utilsService, $state, sharedProperties, $window, $stateParams) {
    console.log("waychctrl");
    $scope.$watch('rowCollection[$index].provisionalRevenue', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if($scope.rowCollection[$scope.$index].provisionalRevenue=='-'){
                newValue = '0';
            }
            if(oldValue=='-'){
                oldValue = '0';
            }
            $scope.rowCollection[$scope.$index].profitLoss=parseFloat($scope.rowCollection[$scope.$index].profitLoss)-oldValue+parseFloat(newValue);
            $scope.rowCollection[$scope.$index].totalRevenue=parseFloat($scope.rowCollection[$scope.$index].totalRevenue)-oldValue+parseFloat(newValue);
            if($scope.rowCollection[$scope.$index].changeRevComment==null || $scope.rowCollection[$scope.$index].changeRevComment=='' || $scope.rowCollection[$scope.$index].changeRevComment==undefined){
//                $scope.rowCollection[$scope.$index].changeRevComment = oldValue;
            }
            $scope.setTotals1();
        }
    });
    
    $scope.$watch('rowCollection[$index].provisionalCost', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue=='-'){
                newValue = '0';
            }
            if(oldValue=='-'){
                oldValue = '0';
            }
            $scope.rowCollection[$scope.$index].profitLoss=parseFloat($scope.rowCollection[$scope.$index].profitLoss)-oldValue+parseFloat(newValue);
            $scope.rowCollection[$scope.$index].totalCost=parseFloat($scope.rowCollection[$scope.$index].totalCost)-oldValue+parseFloat(newValue);
            if($scope.rowCollection[$scope.$index].changeCostComment==null || $scope.rowCollection[$scope.$index].changeCostComment=='' || $scope.rowCollection[$scope.$index].changeCostComment==undefined){
//                $scope.rowCollection[$scope.$index].changeCostComment = oldValue;
            }
            $scope.setTotals1();
        }
    });
    
});

app.controller('wprchangeTPCtrl', function($scope, $sce, $rootScope, $http, $location, logger, ngDialog, utilsService, $state, sharedProperties, $window, $stateParams) {
    console.log("waychTPctrl");
    $scope.$watch('rowCollection1[$index].provisionalRevenue', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue=='-'){
                newValue = '0';
            }
            if(oldValue=='-'){
                oldValue = '0';
            }
            $scope.rowCollection1[$scope.$index].profitLoss=parseFloat($scope.rowCollection1[$scope.$index].profitLoss)-oldValue+parseFloat(newValue);
            $scope.rowCollection1[$scope.$index].totalRevenue=parseFloat($scope.rowCollection1[$scope.$index].totalRevenue)-oldValue+parseFloat(newValue);
            if($scope.rowCollection1[$scope.$index].changeRevComment==null || $scope.rowCollection1[$scope.$index].changeRevComment=='' || $scope.rowCollection1[$scope.$index].changeRevComment==undefined){
//                $scope.rowCollection1[$scope.$index].changeRevComment = oldValue;
            }
            $scope.setTotals1();
        }
    });
    
    $scope.$watch('rowCollection1[$index].provisionalCost', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue=='-'){
                newValue = '0';
            }
            if(oldValue=='-'){
                oldValue = '0';
            }
            $scope.rowCollection1[$scope.$index].profitLoss=parseFloat($scope.rowCollection1[$scope.$index].profitLoss)-oldValue+parseFloat(newValue);
            $scope.rowCollection1[$scope.$index].totalCost=parseFloat($scope.rowCollection1[$scope.$index].totalCost)-oldValue+parseFloat(newValue);
            if($scope.rowCollection1[$scope.$index].changeCostComment==null || $scope.rowCollection1[$scope.$index].changeCostComment=='' || $scope.rowCollection1[$scope.$index].changeCostComment==undefined){
//                $scope.rowCollection1[$scope.$index].changeCostComment = oldValue;
            }
            $scope.setTotals1();
        }
    });
    
});

app.filter('sumByKeyRevCost', function () {
    return function (data, key) {
        if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
            return 0;
        }

        var sum = 0;
        for (var i = data.length - 1; i >= 0; i--) {
            sum += isNaN(parseFloat(data[i][key]))?0:parseFloat(data[i][key]);
        }

        return parseFloat(sum).toFixed(2);
    };
});

app.filter('sumByKey', function () {
//   alert("filer");
  return function (data, key) {    
      if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
          return 0;
      }
    
      var sum = 0;
      for (var i = data.length - 1; i >= 0; i--) {
          if(data[i][key]!=null && data[i][key]!="" && data[i][key]!=undefined && data[i][key]!='NaN' && data[i][key]!="-"){
          sum += parseInt(data[i][key]);
          }
      }          
      return sum;
  };
});

app.filter('sumByKeyAmount', function () {
    //   alert("filer");
       return function (data, key) {    
           if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
               return 0;
           }
         
           var sum = 0;
           for (var i = data.length - 1; i >= 0; i--) {
               if(data[i][key]!=null && data[i][key]!="" && data[i][key]!=undefined && data[i][key]!='NaN' && data[i][key]!="-"){
               sum += parseFloat(data[i][key]);
               }
           }   
           sum=(sum>0)?sum.toFixed(2):0;
           return sum;
       };
   });

app.filter('generalInvoiceTot', function () {
    //   alert("filer");
       return function (data, key,giamt) {    
           if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
               return 0;
           }
         console.log(giamt);
           var sum = 0;
           for (var i = data.length - 1; i >= 0; i--) {
               if(data[i][key]!=null && data[i][key]!="" && data[i][key]!=undefined && data[i][key]!='NaN' && data[i][key]!="-"){
               sum += parseFloat(data[i][key]);
               }
           }   
           sum=(sum>0)?sum.toFixed(2):0;
           sum=parseFloat(sum)+parseFloat(giamt);
           return sum;
       };
   });

app.filter('sumBySTKeyAmount', function () {
    //   alert("filer");
       return function (data, key,polId,podId) {    
           if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
               return 0;
           }
         
           var sum = 0;
           for (var i = data.length - 1; i >= 0; i--) {
               
               if(data[i]['polId']==polId && data[i]['podId']==podId)
                  
                   if(data[i][key]!=null && data[i][key]!="" && data[i][key]!=undefined && data[i][key]!='NaN' && data[i][key]!="-"){
                       //console.log("sum==="+data[i][key]+"="+(data[i][key]).length);
                       sum += parseFloat(data[i][key]);
                   }
           }   
           sum=(sum>0)?sum.toFixed(2):0;
           return sum;
       };
   });

app.filter('sumBySTKey', function () {
//   alert("filer");
  return function (data, key,polId,podId) {    
      if (typeof (data) === 'undefined' || typeof (key) === 'undefined') {
          return 0;
      }
    
      var sum = 0;
      for (var i = data.length - 1; i >= 0; i--) {
          
          if(data[i]['polId']==polId && data[i]['podId']==podId)
             
              if(data[i][key]!=null && data[i][key]!="" && data[i][key]!=undefined && data[i][key]!='NaN' && data[i][key]!="-"){
                  //console.log("sum==="+data[i][key]+"="+(data[i][key]).length);
                  sum += parseInt(data[i][key]);
              }
      }          
      return sum;
  };
});
app.filter('sumByArr', function () {
    //  alert("filer");
      return function (data,indx,indx1,polId,podId) {           
          if (typeof (data) === 'undefined') {
              return 0;
          }
      
          var sum = 0;           
          for (var i = 0; i <=indx1; i++) {
              if(data[i].polId==polId && data[i].podId==podId)
              sum = sum + parseInt(data[i].quantityList[indx]);
          }
                
          return sum;
      };
  });
    app.filter('sumByGTArr', function () {
   //   alert("filer");
      return function (data,indx) {           
          if (typeof (data) === 'undefined') {
              return 0;
          }
         var sum = 0;           
          for (var i = 0; i < data.length; i++) {
           //   console.log("grand total="+data[i].quantityList[indx]);
              sum = sum + parseInt(data[i].quantityList[indx]);
          }
                
          return sum;
      };
      
      
  });
    app.filter('sumByGTArr1', function () {
        //   alert("filer");
         return function (data,indx) {    
             console.log(indx);
            /*   if (typeof (data) === 'undefined') {
                   return 0;
               }
              var sum = 0;       
              console.log(data);
              for (var j = 0; j < data.length; j++) {
              var slotTot=data[j].slotTotal;
           //   console.log(j+"=="+indx);
               for (var i = 0; i < slotTot.length; i++) {
              //     console.log("grand total="+slotTot[indx]);
                   sum = sum +parseInt(slotTot[indx]);
               }
              }*/
                 var sum=0;    
               return sum;
           };
});
