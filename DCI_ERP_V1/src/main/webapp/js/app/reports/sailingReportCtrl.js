'use strict';
app.controller('sailingsReportCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter) {

    $('#fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime:false
    });
    
    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime:false
    });
    
    $('#toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime:false
    });
    
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime:false
    });
    
    
    $('#tb_week').datetimepicker({
        format : 'DD/MM/YYYY',
        calendarWeeks: true
    });

    $scope.sailingsReport = {
            companyCode: '',
            fromDate: '',
            toDate: '',
            voyage: '',
            pol: '',
            pod: '',
            sectorName: '',
            sailingDate: '',
            thirdPartyOrSsf: '',
            activityType: '',
            vesselOperator: '',
            year : '',
            week:''
    };
    var temp = angular.copy($scope.sailingsReport);
       
    var date = new Date();
    var year = date.getFullYear();
    $scope.yearList = [];
    $scope.year = year.toString();
    $scope.years = year.toString();
    
    $scope.getYearList = function(){
        var yearList = [];
        for(var i=0;i<3;i++){
            var currentYear = Number(moment().format("YYYY"));
            var obj = {id:(currentYear-i).toString(),text:(currentYear-i).toString()};
            yearList.push(obj);
        }
        return yearList;
    }
    $scope.yearList = $scope.getYearList();
    
    /*$scope.yearList = [ 
    {
        id : '2017',
        text : '2017'
    },
    {
        id : '2016',
        text : '2016'
    }, {
        id : '2015',
        text : '2015'
    },]*/
    
    $scope.weekList = [ {
        id : '01',
        text : '01'
    }, {
        id : '02',
        text : '02'
    }, {
        id : '03',
        text : '03'
    }, {
        id : '04',
        text : '04'
    }, {
        id : '05',
        text : '05'
    }, {
        id : '06',
        text : '06'
    }, {
        id : '07',
        text : '07'
    }, {
        id : '08',
        text : '08'
    }, {
        id : '09',
        text : '09'
    }, {
        id : '10',
        text : '10'
    }, {
        id : '11',
        text : '11'
    }, {
        id : '12',
        text : '12'
    }, {
        id : '13',
        text : '13'
    },{
        id : '14',
        text : '14'
    },{
        id : '15',
        text : '15'
    },{
        id : '16',
        text : '16'
    },{
        id : '17',
        text : '17'
    },{
        id : '18',
        text : '18'
    },{
        id : '19',
        text : '19'
    },{
        id : '21',
        text : '21'
    },{
        id : '22',
        text : '22'
    },{
        id : '23',
        text : '23'
    },{
        id : '24',
        text : '24'
    },{
        id : '25',
        text : '25'
    },{
        id : '26',
        text : '26'
    },{
        id : '27',
        text : '27'
    },{
        id : '28',
        text : '28'
    },{
        id : '29',
        text : '29'
    },{
        id : '30',
        text : '30'
    },{
        id : '31',
        text : '31'
    },{
        id : '32',
        text : '32'
    },{
        id : '33',
        text : '33'
    },{
        id : '34',
        text : '34'
    },{
        id : '35',
        text : '35'
    },{
        id : '36',
        text : '36'
    },{
        id : '37',
        text : '37'
    },{
        id : '38',
        text : '38'
    },{
        id : '39',
        text : '39'
    },{
        id : '40',
        text : '40'
    },{
        id : '41',
        text : '42'
    },{
        id : '43',
        text : '43'
    },{
        id : '44',
        text : '44'
    },{
        id : '45',
        text : '45'
    },{
        id : '46',
        text : '46'
    },{
        id : '47',
        text : '47'
    },{
        id : '48',
        text : '48'
    },{
        id : '49',
        text : '49'
    },{
        id : '50',
        text : '50'
    },{
        id : '51',
        text : '51'
    },{
        id : '52',
        text : '52'
    },];
    
    $scope.formreset = function() {
        $scope.sailingsReport = {};
    };
    $scope.pageCounters = [ 10,15, 25, 50, 75, 100, 125,150 ];
    $scope.index=[];
    $scope.checked = [];
    var index="";
    $scope.itemsByPage = 10;
    $scope.hideUploadIcon=true;
    $scope.hideDeleteIcon=true;
    
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];

    $scope.subGroupList = [];
    $scope.companyList = [];
    
    $scope.getDropDownList = function() {
      
        
        $http.get('app/sailingsreport/getCompanyList').success(function(data) {
            $scope.companyList = data;
        }).error(function(data) {
        });
    };
    
    $scope.getDropDownList();
    
    $scope.viewTrialBalanceReport = function(){
        debugger;
        $scope.rowCollection =[];
        $scope.sailingsReport.fromDate = $('#fromDate').val();
        $scope.sailingsReport.toDate = $('#toDate').val();
        //$scope.sailingsReport.week = $('#week').val(); 
       
        if((($scope.sailingsReport.fromDate != '' ) || ($scope.sailingsReport.year != '')) && $scope.sailingsReport.companyCode !=''){
            $http.post('app/sailingsreport/getSailingReports', $scope.sailingsReport).success(function(data) {
                console.log(data);
                if (data.success == true) {
                    $scope.rowCollection = $scope.rowCollection.concat(data.sailingsReportList);
                    if(data.sailingsReportList.length==0){
                        logger.logError("No Records Found!...");
                    }
                }else{
                    logger.logError("Some errors occured.Please try again!...");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if($scope.sailingsReport.companyCode ==null || $scope.sailingsReport.companyCode ==undefined ||$scope.sailingsReport.companyCode ==''){
                logger.logError("Please select Company");
            }
            /*if($scope.sailingsReport.fromDate==null || $scope.sailingsReport.fromDate==undefined || $scope.sailingsReport.fromDate==''){
                if($scope.sailingsReport.year!=null || $scope.sailingsReport.year!=undefined || $scope.sailingsReport.year!='')
                    logger.logError("Please select any one Date (OR) Year");
                else
                    logger.logError("Please select From Date");
            }
            if($scope.sailingsReport.toDate==null || $scope.sailingsReport.toDate==undefined || $scope.sailingsReport.toDate==''){
                if($scope.sailingsReport.year!=null || $scope.sailingsReport.year!=undefined || $scope.sailingsReport.year!='')
                    logger.logError("Please select any one Date (OR) Year");
                else
                    logger.logError("Please select To Date");
            }
            if($scope.sailingsReport.year==null || $scope.sailingsReport.year==undefined || $scope.sailingsReport.year==''){
                if($scope.sailingsReport.fromDate!=null || $scope.sailingsReport.fromDate!=undefined || $scope.sailingsReport.fromDate!='')
                    logger.logError("Please select any one Date (OR) Year");
                else
                    logger.logError("Please select Year");
            }
            if($scope.sailingsReport.week==null || $scope.sailingsReport.week==undefined || $scope.sailingsReport.week==''){
                if($scope.sailingsReport.year!=null || $scope.sailingsReport.year!=undefined || $scope.sailingsReport.year!='')
                    logger.logError("Please select any one Date (OR) Year");
                else
                    logger.logError("Please select Week");
            }*/
            else {
                var ifDateRange=true,ifWeek=true;
                if($scope.sailingsReport.fromDate==null || $scope.sailingsReport.fromDate==undefined || $scope.sailingsReport.fromDate==''){
                    ifDateRange=false;
                    
                }else if(ifDateRange){
                    if($scope.sailingsReport.toDate==null || $scope.sailingsReport.toDate==undefined || $scope.sailingsReport.toDate=='') {                
                    
                    }
                }
                if($scope.sailingsReport.week==null || $scope.sailingsReport.week==undefined || $scope.sailingsReport.week==''){
                    ifWeek=false;
                }
                if(!ifDateRange && !ifWeek){
                    logger.logError("Please select any one From Date and To Date (OR) Year and Week");
                }
            }
                
        }
    };
    
    $scope.exportTBExcel = function(){
        $scope.sailingsReport.fromDate = $('#fromDate').val();
        $scope.sailingsReport.toDate = $('#toDate').val();
        //$scope.sailingsReport.week = $('#week').val();       
        if((($scope.sailingsReport.fromDate != '' ) || ($scope.sailingsReport.year !='')) && $scope.sailingsReport.companyCode !=''){
            
            $http.post('app/sailingsreport/excelExport', $scope.sailingsReport).success(function(data) {
                console.log(data);
                if (data.success == true) {
                    $("#sailingExport").bind('click', function() {
                    });
                    $('#sailingExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to Export!..");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }else{
            if($scope.sailingsReport.companyCode ==null || $scope.sailingsReport.companyCode ==undefined ||$scope.sailingsReport.companyCode ==''){
                logger.logError("Please select Company");
            }else {
                var ifDateRange=true,ifWeek=true;
                if($scope.sailingsReport.fromDate==null || $scope.sailingsReport.fromDate==undefined || $scope.sailingsReport.fromDate==''){
                    ifDateRange=false;
                    
                }else if(ifDateRange){
                    if($scope.sailingsReport.toDate==null || $scope.sailingsReport.toDate==undefined || $scope.sailingsReport.toDate=='') {                
                    
                    }
                }
                if($scope.sailingsReport.week==null || $scope.sailingsReport.week==undefined || $scope.sailingsReport.week==''){
                    ifWeek=false;
                }
                if(!ifDateRange && !ifWeek){
                    logger.logError("Please select any one From Date (OR) Week");
                }
            }
                
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
    
   
    
});

/*

function doSubmit(){
var sysdates=new Date();
        var Formula="";         
        var companyCode = document.forms[0].company.value;      
        var fromMonth = parseInt(document.forms[0].selectMonth1.value) + 1;
        var toMonth = parseInt(document.forms[0].selectMonth2.value) + 1;
        
        var fromDate = document.forms[0].selectYear1.value +
            "/" + fromMonth +
            "/" + document.forms[0].selectDay1.value;                       
    
        var toDate = document.forms[0].selectYear2.value +
            "/" + toMonth +
            "/" + document.forms[0].selectDay2.value;   
            
        if((fromDate==sysdates.getYear()+'/1/0') && (toDate==sysdates.getYear()+'/1/0')){
            document.reportForm.ReportName.value="Sailings";
            document.reportForm.submit(); 
        }

        if(fromDate!=sysdates.getYear()+'/1/0'){
                Formula+=" {LOADING.SAILING_DT} >= cdate('"+fromDate+"')";
        }
        
        if(toDate!=sysdates.getYear()+'/1/0'){
        if(Formula!=""){
                Formula=Formula+" and"
            }
            Formula+=" {LOADING.SAILING_DT} <= cdate('"+toDate+"')";
        }
        if(companyCode != "C"){
            
        Formula+=" and  {LOADING.COMPANY_CODE }= \'"+document.forms[0].company.value+"\'";
        }   
                
        //alert(Formula);
        document.reportForm.operation.value=Formula;
        document.reportForm.ReportName.value="Sailings";
        document.reportForm.submit(); 
    
    }

*/