'use strict';
app.controller('corgCustomerWiseCtrl', function($scope, $filter, $rootScope, $http, $location, logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams, $controller) {
    $scope.rowCollection=[];
    $scope.corgReport={
            companyCode:'C0000',
            selectedDate:'',           
            fromDate:'',
            toDate:'',
            year:'',
            fromWeek:'',
            toWeek:'',
            customerCode:'',
            mloCode : '',
            chartType : 'L',
            totalWeek : '0',
            from : 0,
            to : 0,
            isConsolidated : 'C'
            
    }
    
    $scope.mloList=[];
    $scope.corgList=[];
    $scope.isChart =false;
    $scope.isChart1 =false;
    $scope.weekEndDate='';
    $scope.cusCard={};
    $scope.chartView=false;
    $scope.lineIntialized=false;
    $scope.consolidated = false;
    
    $scope.pending = function(obj,from,to,consolidated){
        $scope.corgReport.from = from;
        $scope.corgReport.to = to;
        $scope.corgReport.week = obj.week;
        $scope.corgReport.isConsolidated = consolidated;
                    ngDialog.open({
                        scope : $scope,
                        template : 'views/reports/finance/corgCustomerView',
                        controller : $controller('custCardCtrl', {
                            $scope : $scope,
                            purchaseObject : $scope.corgReport
                        }),
                        className : 'ngdialog-theme-plain',
                        showClose : false,
                        closeByDocument : false,
                        closeByEscape : false,
                        preCloseCallback : $scope.getList
                    });
        }
     
    $scope.$watch('corgReport.customerCode', function(newValue, oldValue) {
        $scope.corgReport.payerName = '';
        if (newValue != '' && newValue != undefined) {
        angular.forEach($scope.customerList, function(value, indexs) {
            if(newValue == value.id){
                $scope.corgReport.payerName = value.text;
            }
        });
        }
    });
    
    var barChart='';
    // first chart
    $scope.viewCorgChart=function(){
        $scope.consolidated = false;
        $scope.isChart =true;
        $scope.isChart1 =false;
        $scope.remittanceData=[];
        $scope.invoicingData=[];
        $scope.weekListMap=[];
         $http.post($stateParams.tenantid+'/app/corgCustomerWise/viewCorgReportAsOnDate', $scope.corgReport).success(function(data) {
                if(data.success){
                    $scope.remittanceData=[];
                    $scope.invoicingData=[];
                    $scope.weekListMap=[];
                    angular.forEach(data.lCorgList,function(value,key){
                        $scope.weekListMap.push(value.week);
                        $scope.remittanceData.push(value.remittance);
                        $scope.invoicingData.push(value.invoicing);
                    });
                    //$scope.createBarChat();
                    $scope.checkChartType();
    }
         });
    }
    
    
    $scope.checkChartType = function(){
        if($scope.corgReport.chartType == 'L')
            $scope.lineChart();
        else
            $scope.barChart();
    }
    
    
        $scope.lineChart=function(){
            $scope.lineIntialized=true;
            var title="";
            if($scope.corgReport.mloName!=undefined &&  $scope.corgReport.mloName!=''){
                title = " Customer :" +$scope.corgReport.mloName;
            }
            if($scope.corgReport.payerName!=undefined &&  $scope.corgReport.payerName!=''){
                title = title+ "                    Payer :" +$scope.corgReport.payerName;
            }
            $('#corgBar').remove();
            console.log($scope.weekListMap);
           document.getElementById("chartContainer").innerHTML = '&nbsp;';
            document.getElementById("chartContainer").innerHTML = '<canvas id="corgBar"   height="400" width="1200"></canvas>';
                alert(0)
            var ctx = document.getElementById('corgBar').getContext('2d');
            var myChart = new Chart(ctx, {
              type: 'line',      
              options: {
                  title: {
                    display: true,
                    text: title,
                    position:'top'
                  },
                 
                  scales: {
                      yAxes: [{
                          ticks: {                              
                              min: 0,
                              
                          }
                      }]
                  },
                  pointDotRadius: 10

                },
              data: {
                  labels: $scope.weekListMap,
                  datasets: [
                      {
                          label: "Invoicing",
                          backgroundColor: "rgba(0,0,255,1)",
                          borderColor: "rgba(0,0,255,1)",
                          borderWidth : 1,
                          fill: false,
                          data: $scope.invoicingData
                      },
                      {
                          label: "Remittance",
                          backgroundColor: "rgba(165,42,42,1)",
                          borderColor: "rgba(165,42,42,1)",
                          borderWidth : 1,
                          fill: false,
                          data: $scope.remittanceData
                      }
                  ]
              }
            });
        }
        
        $scope.barChart=function(){
            $scope.lineIntialized=true;
            var title="";
            if($scope.corgReport.mloName!=undefined &&  $scope.corgReport.mloName!=''){
                title = " Customer :" +$scope.corgReport.mloName;
            }
            if($scope.corgReport.payerName!=undefined &&  $scope.corgReport.payerName!=''){
                title = title+ "                    Payer :" +$scope.corgReport.payerName;
            }
            console.log($scope.weekListMap);
            document.getElementById("chartContainer").innerHTML = '&nbsp;';
            document.getElementById("chartContainer").innerHTML = '<canvas id="corgBar"   height="400" width="1200"></canvas>';
                
            var ctx = document.getElementById('corgBar').getContext('2d');
            var myChart = new Chart(ctx, {
              type: 'bar',      
              options: {
                  title: {
                    display: true,
                    text: title,
                    position:'top'
                  },
                 
                  scales: {
                      yAxes: [{
                          ticks: {                              
                              min: 0,
                              
                          }
                      }]
                  },
                  pointDotRadius: 10

                },
              data: {
                  labels: $scope.weekListMap,
                  datasets: [
                      {
                          label: "Invoicing",
                          backgroundColor: "rgba(0,0,255,1)",
                         
                          data: $scope.invoicingData
                      },
                      {
                          label: "Remittance",
                          backgroundColor: "rgba(165,42,42,1)",
                          
                          data: $scope.remittanceData
                      }
                  ]
              }
            });
        }
        
    $scope.viewAgewiseChart=function(){
        $scope.consolidated = false;
        $scope.isChart =false;
        $scope.isChart1 =true;
        
        $http.post($stateParams.tenantid+'/app/corgCustomerWise/viewCorgReportAsOnDateWeekly', $scope.corgReport).success(function(data) {
        if (data.success) {
        console.log("final list");
        console.log(data)
            $scope.weekListAgeWise = [];
            $scope.lBelow30List = [];
            $scope.l30to45List = [];
            $scope.l45to60List = [];
            $scope.lAbove60List = [];
           // var data=$scope.custCard.wiseBean;
            $scope.weekListAgeWise =data.wiseBean.lWeekList;
            $scope.lBelow30List =data.wiseBean.lBelow30List;
            $scope.l30to45List =data.wiseBean.l3045List;
            $scope.l45to60List =data.wiseBean.l4560List;
            $scope.lAbove60List =data.wiseBean.lAbove60List;
            $scope.createSecondChat();
        }
    }).error(function(datas) {
        logger.logError("Error");
    });
    }
    
    //second chart
    $scope.createSecondChat = function() {

        var title="";
        if($scope.corgReport.mloName!=undefined &&  $scope.corgReport.mloName!=''){
            title = "<b> Customer</b> :" +$scope.corgReport.mloName +" ";
        }
        if($scope.corgReport.payerName!=undefined &&  $scope.corgReport.payerName!=''){
            title = title+ "<b>Payer</b> :" +$scope.corgReport.payerName+"";
        }
        var chart = {
            type : 'column'
        };
        var title = {
            text : title,
            style: { "color": "#333333", "fontSize": "12px" }
        };
        var xAxis = {

            categories : $scope.weekListAgeWise,

            title : {
                text : 'Weeks'
            },
            crosshair : true
        };
        var yAxis = {
            min : 0,
            title : {
                text : 'Outstandings'
            },
            stackLabels : {
                enabled : false,
                style : {
                    fontWeight : 'bold',
                    color : (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                }
            }
        };
        var legend = {
            align : 'right',
            x : -10,
            verticalAlign : 'top',
            y : 20,
            floating : true,
            backgroundColor : (Highcharts.theme && Highcharts.theme.background2) || 'white',
            borderColor : '#CCC',
            borderWidth : 1,
            shadow : false
        };
       
        var tooltip = {
            headerFormat : '<span style="font-size:10px"> Week {point.key}</span><table>',
            pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' + '<td style="padding:0"><b>{point.y:.1f} USD</b></td></tr>',
            footerFormat : '</table>',
            shared : true,
            useHTML : true
        };
        var plotOptions = {
            column : {
                stacking : 'normal',
                series: {
                    colorByPoint: true
                }
                
            }
        };
        var credits = {
            enabled : false
        };
        

        var series = [ {
            name : 'Above 60',
            data : $scope.lAbove60List,
            colorByPoint: false,
            color: '#FF0000'
        }, {
            name : '45-60',
            data : $scope.l45to60List,
            colorByPoint: false,
            color: '#FE9A2E'
        }, {
            name : '30-45',
            data : $scope.l30to45List,
            color: '#0000FF'
        }, {
            name : 'BELOW 30',
            data : $scope.lBelow30List,
            colorByPoint: false,
            color: '#74DF00'
        } ];

        var json = {};
        json.chart = chart;
        json.title = title;
        json.xAxis = xAxis;
        json.yAxis = yAxis;
        json.legend = legend;
        json.tooltip = tooltip;
        json.plotOptions = plotOptions;
        json.credits = credits;
        json.series = series;
        $('#secondChart').highcharts(json);

    };
    
    
    $scope.reset=function(){
        $scope.corgReport={
                companyCode:'C0000',
                selectedDate:'',           
                fromDate:'',
                toDate:'',
                year:'',
                fromWeek:'',
                toWeek:'',
                customerCode:''
                
        }
        $('#fromDate').val('');
        $('#toDate').val('');
        $scope.corgReport.year=currentYear;
    }
    
    $('.datetimepick').datetimepicker({
        format : 'DD/MM/YYYY',
        calendarWeeks: true
    });
  
    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
   
    var d = new Date();
    var currentYear = d.getFullYear();
    $scope.corgReport.year=currentYear;
    $scope.mloList = [];
    $scope.customerList = [];
    $scope.companyList=[];
    
    $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
       
       // $scope.companyList.push(obj);
        $scope.companyList = data;
        var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
        $scope.corgReport.companyCode=foundItemDest.id;
        
        
        
    });
    
    $scope.getDropdownvalue = function() {
        /*$scope.companyList=[];
        var obj={
                'id':'C0000',
                'text':'ALL'
        }
        $scope.companyList.push(obj);
        obj={
                'id':'C0001',
                'text':'DUBAI'
        }
        $scope.companyList.push(obj);
        obj={
                'id':'C0003',
                'text':'SINGAPORE'
        }
        $scope.companyList.push(obj);*/
        
        $scope.weekList=[];
        for(var i=1;i<=53;i++){
            var week={};
            if(i<10){
            week.id='0'+i;
            }else{
                week.id=''+i;
            }
            week.text=''+i;
            $scope.weekList.push(week);
        }
        
        $scope.yearList=[];
        for(var i=2015;i<=2020;i++){
            var year={};
            year.id=i;
            year.text=''+i;
            $scope.yearList.push(year);
        }
        console.log($scope.weekList);
        $scope.corgReport.week=$scope.corgReport.toWeek;
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.corgReport).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
                console.log(" $scope.weekEndDate");
                console.log( $scope.weekEndDate);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        
        $http.get($stateParams.tenantid+'/app/corgCustomerWise/getCustomerList').success(function(datas) {
            $scope.mloList = datas.mloList;
            }).error(function(datas) {
        }); 
        
        
        
        
    }
    $scope.getDropdownvalue();
    
    $scope.$watch('corgReport.mloCode', function(newValue, oldValue) {
        $scope.corgReport.payerName = '';
        $scope.corgReport.mloName = '';
        $scope.corgReport.customerCode = '';
        $scope.customerList = [];
        if (newValue != '' && newValue != undefined) {
            angular.forEach($scope.mloList, function(value, indexs) {
                if(newValue == value.id){
                    $scope.corgReport.mloName = value.text;
                }
            });
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/getPayerForCustomer', newValue).success(function(datas) {
                $scope.customerList = datas.payerList;
                }).error(function(datas) {
            });
        }
    });
    
    $scope.$watch('corgReport.toWeek', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.corgReport.week=$scope.corgReport.toWeek;
        $http.post('app/corg/getweekenddate', $scope.corgReport).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
                console.log( $scope.weekEndDate);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        }
    });
    
    $scope.$watch('corgReport.year', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.corgReport).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
                console.log( $scope.weekEndDate);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        }
    });
    
    $scope.$watch('[corgReport.companyCode,corgReport.customerCode,corgReport.year,corgReport.fromWeek,corgReport.toWeek]',
            function(newValue,oldValue){
        if(newValue != undefined && newValue != '' ){
           $scope.chartView=false;
        }
    })
       
    
    $scope.viewCorgReportAsOnDate = function() {
        $scope.consolidated = false;
        $scope.isChart =false;
        $scope.isChart1 =false;
        $scope.rowCollection=[];
      /*  if($scope.corgReport.customerCode !='' && $scope.corgReport.customerCode !=undefined){*/
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/viewCorgReportAsOnDateWeekly', $scope.corgReport).success(function(data) {
                if(data.success){
                    debugger;
                    $scope.custCard=data;
                    $scope.corgList=data.lCorgList;
                    $scope.rowCollection=data.lCorgList;
                }else{                    logger.logError("Error Please Try Again");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        /*}else{
            logger.logError("Please select payer");
        }*/
  }
    
    
    
    $scope.exportCorgReport = function() {
      
        $http.post($stateParams.tenantid+'/app/corgCustomerWise/generateExcel',$scope.corgReport).success(function(data) {
            if(data){
                debugger;
                $("#corgExport").bind('click', function() {
                });
                $('#corgExport').simulateClick('click');
                logger.logSuccess("Exported successfully!");
            }else{
                logger.logSuccess("Failed to export");
            }
            
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
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
    
    $scope.consolidatedView = function() {
        $scope.consolidated = true;
        $scope.isChart =false;
        $scope.isChart1 =false;
        $scope.rowCollection=[];
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/consolidatedView', $scope.corgReport).success(function(data) {
                if(data.success){
                    debugger;
                    $scope.custCard=data;
                    $scope.corgList=data.lCorgList;
                    $scope.rowCollection=data.lCorgList;
                }else{                    
                    logger.logError("Error Please Try Again");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        
  }
    
    
    
});

app.controller('custCardCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
    
    console.log("&&&&&&&&&&")
    console.log($scope.corgReport)
    
    $scope.rowCollection1=[];
    $http.post($stateParams.tenantid+'/app/corgCustomerWise/corgView', $scope.corgReport).success(function(data) {
        if(data.success){
            console.log("corgView")
            console.log(data)
            $scope.rowCollection1=data.lCorgList;
        }else{                    
            logger.logError("Error Please Try Again");
        }
        
    }).error(function(data) {
        logger.logError("Error Please Try Again");
    });
    
    $scope.cancelng = function(){
        ngDialog.close();
    }
    
});

app.controller('supplierCardCtrl', function($scope,$filter, $rootScope, $http, $location, logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
    $scope.rowCollection=[];
    
    $scope.corgReport={
            companyCode:'C0000',
            supplierCode : '',
            selectedDate:'',           
            fromDate:'',
            toDate:'',
            year:'',
            fromWeek:'',
            toWeek:'',
            customerCode:'',
            mloCode : '',
            chartType : 'L',
            totalWeek : '0'
            
    }
    
    $('.datetimepick').datetimepicker({
        format : 'DD/MM/YYYY',
        calendarWeeks: true
    });
  
    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
   
    var d = new Date();
    var currentYear = d.getFullYear();
    $scope.corgReport.year=currentYear;
    $scope.mloList = [];
    $scope.customerList = [];
    $scope.getDropdownvalue = function() {
        $scope.companyList=[];
        var obj={
                'id':'C0000',
                'text':'ALL'
        }
        $scope.companyList.push(obj);
        obj={
                'id':'C0001',
                'text':'DUBAI'
        }
        $scope.companyList.push(obj);
        obj={
                'id':'C0003',
                'text':'SINGAPORE'
        }
        $scope.companyList.push(obj);
        
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(datas) {
            debugger;           
            $scope.companyList = datas; 
           
            
            console.log("company")
            console.log($scope.companyList)
            var foundItemDest = $filter('filter')($scope.companyList, { baseCompany:  1 })[0];
            $scope.corgReport.companyCode=foundItemDest.id;
            
            /* 
            $timeout(function() {
                $('#txtCompanyCode').multiselect('deselectAll', false);
                $('#txtCompanyCode').multiselect('updateButtonText');
                $("#txtCompanyCode").multiselect('rebuild');
            
            }, 2, false);
            $("#multiselect-button").addClass("width_100 input-sm line-height-5");*/
            }).error(function(datas) {
        });

        
        $scope.weekList=[];
        for(var i=1;i<=53;i++){
            var week={};
            if(i<10){
            week.id='0'+i;
            }else{
                week.id=''+i;
            }
            week.text=''+i;
            $scope.weekList.push(week);
        }
        
        $scope.yearList=[];
        for(var i=2015;i<=2020;i++){
            var year={};
            year.id=i;
            year.text=''+i;
            $scope.yearList.push(year);
        }
        
        $http.get($stateParams.tenantid+'/app/commonUtility/getAccountCodeListSupplier').success(function(datas) {
            $scope.supplierList = datas;
            }).error(function(datas) {
        });
        
        console.log($scope.weekList);
        $scope.corgReport.week=$scope.corgReport.toWeek;
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.corgReport).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
                console.log(" $scope.weekEndDate");
                console.log( $scope.weekEndDate);
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        
    }
    $scope.getDropdownvalue();
    
    $scope.$watch('corgReport.toWeek', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.corgReport.week=$scope.corgReport.toWeek;
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.corgReport).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        }
    });
    
    $scope.$watch('corgReport.supplierCode', function(newValue, oldValue) {
        $scope.corgReport.supplierName = '';
        if (newValue != '' && newValue != undefined) {
        angular.forEach($scope.supplierList, function(value, indexs) {
            if(newValue == value.id){
                $scope.corgReport.supplierName = value.text;
            }
        });
        }
    });
    
    $scope.viewSupplierCard = function() {
        $scope.consolidated = false;
        $scope.isChart =false;
        $scope.isChart1 =false;
        $scope.rowCollection=[];
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/viewSupplierCard', $scope.corgReport).success(function(data) {
                if(data.success){
                    console.log("data")
                    console.log(data)
                    debugger;
                    $scope.custCard=data;
                    $scope.corgList=data.lCorgList;
                    $scope.rowCollection=data.lCorgList;
                }else{                    
                    logger.logError("Error Please Try Again");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
     
  }
    
    $scope.exportSupplierReport = function() {
        
        $http.post($stateParams.tenantid+'/app/corgCustomerWise/generateSupplierExcel',$scope.corgReport).success(function(data) {
            if(data){
                debugger;
                $("#supplierExport").bind('click', function() {
                });
                $('#supplierExport').simulateClick('click');
                logger.logSuccess("Exported successfully!");
            }else{
                logger.logSuccess("Failed to export");
            }
            
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
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

app.controller('rebillSummaryCtrl', function($scope, $rootScope, $http, $location, logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
    $scope.rowCollection=[];
    $scope.offsetCount = 0;
    $scope.limitCount = 10;
    $scope.itemsByPage = 10;
    $scope.corgReport={
            companyCode:'C0000',
            fromDate:'',
            toDate:'',
            year:'',
            fromWeek:'',
            toWeek:'',
            customerCode:'',
            mloCode : '',
            chartType : 'L',
            totalWeek : '0'
            
    }
    
    var temp = angular.copy($scope.corgReport);
    
    $scope.reset = function(){
        $scope.corgReport = temp;
        $scope.rowCollection = [];
    }
    
    $('.datetimepick').datetimepicker({
        format : 'DD/MM/YYYY',
        calendarWeeks: true
    });
  
    $('#tb_fromDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    $('#tb_toDate').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
   
    var d = new Date();
    var currentYear = d.getFullYear();
    $scope.corgReport.year=currentYear;
    $scope.mloList = [];
    $scope.customerList = [];
    $scope.getDropdownvalue = function() {
        $scope.companyList = [];
        $http.get($stateParams.tenantid+'/app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
            $scope.companyList = data;
            $scope.corgReport.companyCode = data[0].id;
        });
        
        $scope.weekList=[];
        for(var i=1;i<=53;i++){
            var week={};
            if(i<10){
            week.id='0'+i;
            }else{
                week.id=''+i;
            }
            week.text=''+i;
            $scope.weekList.push(week);
        }
        
        $scope.yearList=[];
        for(var i=2015;i<=2020;i++){
            var year={};
            year.id=i;
            year.text=''+i;
            $scope.yearList.push(year);
        }
        

        console.log($scope.weekList);
        $scope.corgReport.week=$scope.corgReport.toWeek;
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.corgReport).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
                console.log(" $scope.weekEndDate");
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        
    }
    $scope.getDropdownvalue();
    
    $scope.$watch('corgReport.toWeek', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.corgReport.week=$scope.corgReport.toWeek;
        $http.post($stateParams.tenantid+'/app/corg/getweekenddate', $scope.corgReport).success(function(data) {
            if(data.success){
                $scope.weekEndDate =data.weekEndDate;
            }else{
                logger.logError("Error Please Try Again");
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        }
    });

    $scope.viewSummary1 = true;
    $scope.viewDetails1 = false;
    $scope.viewSummary = function() {
        $scope.viewSummary1 = true;
        $scope.viewDetails1 = false;
        $scope.rowCollection=[];
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/viewSummary', $scope.corgReport).success(function(data) {
                if(data.success){
                    debugger;
                    $scope.custCard=data;
                    $scope.corgList=data.lCorgList;
                    $scope.rowCollection=data.lCorgList;
                }else{                    
                    logger.logError("Error Please Try Again");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
    }
    $scope.viewSummary();
    
    $scope.viewDetails = function() {
        $scope.viewSummary1 = false;
        $scope.viewDetails1 = true;
        $scope.rowCollection = [];
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/viewRebillSum', $scope.corgReport).success(function(data) {
                if(data.success){
                    debugger;
                    $scope.custCard=data;
                    $scope.corgList=data.lCorgList;
                    $scope.rowCollection=data.lCorgList;
                }else{                    
                    logger.logError("Error Please Try Again");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
    }
    
    $scope.exportSummary = function() {
        $http.post($stateParams.tenantid+'/app/corgCustomerWise/exportRebill',$scope.corgReport).success(function(data) {
            if(data){
                debugger;
                $("#summaryExcel").bind('click', function() {
                });
                $('#summaryExcel').simulateClick('click');
                logger.logSuccess("Exported successfully!");
            }else{
                logger.logSuccess("Failed to export");
            }
            
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
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
app.controller('CNRequestCtrl', function($templateCache,$state, $scope, $rootScope, $http, logger, $log, ngDialog, 
        $modal, $location, $sce, $filter, $timeout,utilsService,$compile,$stateParams) {
    $scope.rowCollection=[];
    $scope.offsetCount = 0;
    $scope.limitCount = 10;
    $scope.itemsByPage = 10;
    
    $scope.add = function() {
        $state.go('app.finance.transaction.CNRequest.add',{tenantid:$stateParams.tenantid});    
    };
     
    $http.post($stateParams.tenantid+'/app/corgCustomerWise/listCNInvoice').success(function(data) {
        if(data.success){
            $scope.rowCollection = data.lCorgList;
        }else{                    
            logger.logError("Error Please Try Again");
        }
        
    }).error(function(data) {
        logger.logError("Error Please Try Again");
    });
    
    $scope.rejectRow = function(cnReq){

        ngDialog.openConfirm({
            template :

            ' <div class="modal-header">CONFIRMATION</div> ' + '  <div class="row"> ' + '  <div class="col-lg-12"> ' + '   <div class="col-lg-12">   Do you want to reject the CN Request?    </div> ' + '   </div>  ' + '  </div> ' + '  <div class="modal-footer">' +

            '    <button class="btn btn-info" type="button" ng-click="confirm()">YES</button>' + '   <button class="btn btn-danger" ng-click="closeThisDialog()">NO</button>' + '  </div>',
            plain : true,
            scope : $scope
        }).then(function(value) { $http.post($stateParams.tenantid+'/app/corgCustomerWise/reject', cnReq).success(function(data) {

            if (data == true) {              
                logger.logSuccess("CN Rejected Successfully");
                $http.post($stateParams.tenantid+'/app/corgCustomerWise/listCNInvoice').success(function(data) {
                    if(data.success){
                        $scope.rowCollection = data.lCorgList;
                    }else{                    
                        logger.logError("Error Please Try Again");
                    }
                    
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            } else {
                logger.logError(data.message);
            }

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        });
    
    } 
    
    $scope.deleteRow = function(cnReq){

        ngDialog.openConfirm({
            template :

            ' <div class="modal-header">CONFIRMATION</div> ' + '  <div class="row"> ' + '  <div class="col-lg-12"> ' + '   <div class="col-lg-12">   Do you want to delete the CN Request?    </div> ' + '   </div>  ' + '  </div> ' + '  <div class="modal-footer">' +

            '    <button class="btn btn-info" type="button" ng-click="confirm()">YES</button>' + '   <button class="btn btn-danger" ng-click="closeThisDialog()">NO</button>' + '  </div>',
            plain : true,
            scope : $scope
        }).then(function(value) {
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/delete', cnReq).success(function(data) {

            if (data == true) {              
                logger.logSuccess("CN deleted Successfully");
                $http.post($stateParams.tenantid+'/app/corgCustomerWise/listCNInvoice').success(function(data) {
                    if(data.success){
                        $scope.rowCollection = data.lCorgList;
                    }else{                    
                        logger.logError("Error Please Try Again");
                    }
                    
                }).error(function(data) {
                    logger.logError("Error Please Try Again");
                });
            } else {
                logger.logError(data.message);
            }

        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        });
    
    } 
    $scope.view = function(cnReq){
        $location.path($stateParams.tenantid+'/reports/finance/CNRequestView/' + cnReq);
    }   
    
    $scope.approveRow = function(cnReq){
        $location.path($stateParams.tenantid+'/reports/finance/CNRequestApprove/' + cnReq);
    }   
    
    $scope.editRow = function(cnReq){
        $location.path($stateParams.tenantid+'/reports/finance/CNRequestEdit/' + cnReq);
    } 
    
});

app.controller('CNRequestAddCtrl', function($filter,$scope, $rootScope, $http, $location, logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
    $scope.rowCollection=[];
    $scope.offsetCount = 0;
    $scope.limitCount = 10;
    $scope.itemsByPage = 10;
    
    $scope.edit = false;
    
    $scope.userId = '';
    $http.post($stateParams.tenantid+'/app/dashboard/getUserObj').success(function(datas) {
        $scope.userId = datas.userId;
    }).error(function(datas) {
    });
    
    $scope.cnTypeList = [];
    $scope.cnTypeList = [{
            id : 'P',
            text : 'Partial CN'},
            {
             id : 'F',
             text : 'Full CN'
            }
    ];
    $scope.invoicedtlamount=0.0;
    $scope.dtldisabled=true;
    $scope.$watch('cnReq.cnType', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue=='F'){
                var amount=0.0;
                $scope.dtldisabled=true;
                angular.forEach($scope.invoicedtlamount, function(bean, idx) {
                    amount=amount+parseFloat(bean.tcamount);
                });
                $scope.cnReq.cnamount=amount;
                $scope.cnReq.credittables=angular.copy($scope.invoicedtlamount);
            }else  if(newValue=='P'){
                $scope.dtldisabled=false;
            }
        }
        
    });
    $scope.catCNList = [];
    $scope.catCNList = [{
                id : 'C',
                text : 'COD'
            },
            {
                 id : 'M',
                 text : 'INCORRECT MLO'
            },
            {
                id : 'P',
                text : 'INCORRECT PAYER'
            },
            {
                id : 'TI',
                text : 'INCORRECT TDR INPUT'
            },
            {
                id : 'DB',
                text : 'INCORRECT DF BILLING'
            },
            {
                id : 'RD',
                text : 'RATE DISPUTE'
            },
            {
                id : 'SE',
                text : 'SYSTEM ERROR'
            },
            {
                id : 'W',
                text : 'WAIVER'
            }
    ];
    
    $scope.invoiceNoList = [];
    
    $('#invoiceNo').selectivity({
        ajax : {
            url : $stateParams.tenantid+'/app/corgCustomerWise/listInvoice',
            dataType : 'json',
            minimumInputLength : 5,
            quietMillis : 250,
            params : function(term, offset) {
                return {
                    invoiceNo : term,
                    page : 1 + Math.floor(offset / 30)
                };
            },
            processItem : function(item) {
                return {
                    id : item.id,
                    text : item.text
                };
            },
            results : function(data, offset) {
                return {
                    results : data.lCorgList,
                    more : (offset + data.lCorgList.length > data.total_count)
                };
            }
        },
        allowClear : true,
        placeholder : ' ',
        showSearchInputInDropdown : false,
        templates : {
            resultItem : function(item) {
                return (
                '<div class="selectivity-result-item"  data-item-id="' + item.id + '">' + '<l>' + escape(item.text) + '</l>' + '</div>'
                        );
            }
        }
    });
    
    $('#invoice').selectivity({
        ajax : {
            url : $stateParams.tenantid+'/app/corgCustomerWise/listInvoice',
            dataType : 'json',
            minimumInputLength : 5,
            quietMillis : 250,
            params : function(term, offset) {
                return {
                    invoiceNo : term,
                    page : 1 + Math.floor(offset / 30)
                };
            },
            processItem : function(item) {
                return {
                    id : item.id,
                    text : item.text
                };
            },
            results : function(data, offset) {
                return {
                    results : data.lCorgList,
                    more : (offset + data.lCorgList.length > data.total_count)
                };
            }
        },
        allowClear : true,
        placeholder : ' ',
        showSearchInputInDropdown : false,
        templates : {
            resultItem : function(item) {
                return (
                '<div class="selectivity-result-item"  data-item-id="' + item.id + '">' + '<l>' + escape(item.text) + '</l>' + '</div>'
                        );
            }
        }
    });
    
    
    $scope.cnReq = {
            dateRaised : ''
    };
    
    $('#date_raised').datetimepicker({
        format : 'DD/MM/YYYY',
        pickTime: false
    });
    
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;

    var yyyy = today.getFullYear();
    if (dd < 10) { dd = '0' + dd }
    if (mm < 10) { mm = '0' + mm }
    var today = dd + '/' + mm + '/' + yyyy;
    $scope.cnReq.dateRaised = today;
    $http.get($stateParams.tenantid+'/app/commonUtility/getCrDtlAccountHeadData').success(function(datas) {
        $scope.crdtlAcctHeadList = datas.commonUtilityBean;
    }).error(function(data) {
    });
    
    $('#invoice').on('selectivity-selected', function(obj) {
        var invoice = obj.id;
        var url = $stateParams.tenantid+'/app/corgCustomerWise/viewInvoice?invoiceNo=' + invoice;
        $http.post(url).success(function(data) {
            if (data.success == true) {
                $scope.cnReq = data.lCorgList[0];
                $scope.cnReq.dateRaised = today;
                $scope.creditNoteDtlList(invoice);
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
        
    });
    $scope.bcamountCalculation= function(tcamount,index,row){
        
        // row.tcamount =parseFloat(tcamount);
         if($scope.cnReq.exchangeRate!=0 && $scope.cnReq.exchangeRate!="" && $scope.cnReq.exchangeRate!=undefined){
             var bcAmt = (parseFloat(tcamount) / $scope.cnReq.exchangeRate).toFixed(2);
             row.bcamount = bcAmt;            
         }
         else{
             $scope.cnReq.exchangeRate=1.0;
             var bcAmt = (parseFloat(tcamount) / $scope.cnReq.exchangeRate).toFixed(2);
             row.bcamount = bcAmt;           
         }

     }
    $scope.checkIsNaN = function(value){
        if(isNaN(value))
            value = 0
            
        return value;
    }
    $scope.tcamountCalculation= function(bcamount,index,row){
        if(row.tcamount!=undefined && row.tcamount!=0 && row.tcamount!=""){
            var tcamount = Number((parseFloat(row.tcamount)/parseFloat(bcamount)));
            $scope.cnReq.exchangeRate = parseFloat($scope.checkIsNaN(tcamount)).toFixed(3);
          
        }
        else if($scope.cnReq.exchangeRate != undefined && $scope.cnReq.exchangeRate !=0 &&  $scope.cnReq.exchangeRate !=""){
            var tcamount = Number((parseFloat(bcamount) * $scope.cnReq.exchangeRate));
            row.tcamount = parseFloat($scope.checkIsNaN(tcamount)).toFixed(3);
          
        }else{
            $scope.cnReq.exchangeRate = 1;
            var bcamount = Number((parseFloat(bcamount) * $scope.cnReq.exchangeRate));
            row.bcamount = parseFloat($scope.checkIsNaN(bcamount)).toFixed(3);
           
        }
       
    

    }
    
    $scope.creditNoteDtlList = function(invoiceNo){
        $http.get($stateParams.tenantid+'/app/creditNote/getCreditDtlFromInv?invoiceNo='+invoiceNo).success(function(datas) {
           if(datas.length>0){                 
               $scope.cnReq.credittables=datas;
               var amount=0.0;
               $scope.invoicedtlamount=angular.copy(datas);
               angular.forEach($scope.cnReq.credittables, function(bean, idx) {
                   amount=amount+parseFloat(bean.tcamount);
               });
               $scope.cnReq.cnamount=amount;
           }
        }).error(function(data) {
        });
        $http.get($stateParams.tenantid+'/app/corgCustomerWise/getInvoiceDetails?invoiceno='+invoiceNo).success(function(datas) {
            if(datas.length>0){      
                var invList=datas;
                $scope.cnReq.invoiceDate = invList[0].invoiceDate;
                $scope.cnReq.currencyCode = invList[0].currencyCode;
                $scope.cnReq.exchangeRate = invList[0].exgRate;
                $scope.cnReq.invoiceAmount = (invList[0].invoiceAmount).toFixed(2);
                
                
                
            }
         }).error(function(data) {
         });
        
        
     
  
}
    $scope.checkundefined = function(value) {
        var invalid = false;
        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
            invalid = true;
        }
        return invalid;

    }
    
    $scope.save = function() {
        $scope.cnReq.dateRaised = $('#dateRaised').val();
        $scope.cnReq.approval="Pending";
        var isvalid =true;
        var msg="";
        if ($scope.checkundefined($scope.cnReq.cnType)) {
            msg = msg + "<li>CN TYPE :Field is required.</li>";
            isvalid=false;
        }
        if ($scope.checkundefined($scope.cnReq.invoiceNo)) {
            msg = msg + "<li>INVOICE NO :Field is required.</li>";
            isvalid=false;
        }
       var amount=0.0;
        angular.forEach($scope.cnReq.credittables, function(bean, idx) {
            amount=amount+parseFloat(bean.tcamount);
        });        
        if($scope.cnReq.cnamount!=amount){
           msg= msg+"<li>CN amount "+$scope.cnReq.cnamount+" not matching with total amount of detail "+amount+"</li>"
           isvalid=false;
        }
        
        if(!isvalid){
            logger.logError(msg);
        }else{
     
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/save', $scope.cnReq).success(function(data) {
                if(data.success==true){
                    logger.logSuccess("Saved Successfully");
                    if ($scope.files.length > 0) {

                        angular.forEach($scope.files, function(files, index) {
                            var frmData = new FormData();
                            frmData.append("file", files);
                            frmData.append("quotation", data.code);
                            $.ajax({
                                type : "POST",
                                url : $stateParams.tenantid+"/app/quotation/saveuploadfile",
                                data : frmData,
                                contentType : false,
                                processData : false,
                                success : function(result) {
                                }
                            });
                        });

                    }

                    $state.go('app.finance.transaction.CNRequest.list',{tenantid:$stateParams.tenantid});    
                }else{                    
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
            
        }
    } 
    $scope.downloadNewFile = function(id) {
        $("#tbnewExport" + id).bind('click', function() {
            // alert('clicked');

        });
        $("#tbnewExport" + id).simulateClick('click');
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
    $scope.deleteuploadfiles = function(filename) {
        $scope.tempfiles = [];
        $scope.tempfilename = [];
        angular.forEach($scope.files, function(row, index) {
            if (filename != row.name) {
                $scope.tempfiles.push(row);
            }

        });

        angular.forEach($scope.cnReq.files, function(row, index) {
            if (filename != row.filename) {
                $scope.tempfilename.push(row);
            }

        });
        $scope.files = $scope.tempfiles;
        $scope.cnReq.files = $scope.tempfilename;

    }
    $scope.cancel = function(){
        $state.go('app.finance.transaction.CNRequest.list',{tenantid:$stateParams.tenantid});    
    }
    $rootScope.uploadFile = function(element) {
        $scope.excelfile = element.files[0];
    }
    $scope.files = [];
    $scope.cnReq.files = [];
    $scope.adduploadfiles = function() {
        var obj = []

        if ($scope.checkundefined($scope.excelfile)) {
            logger.logError("Please select the file");
        } else {
            obj = $filter('filter')($scope.cnReq.files, {
                filename : $scope.excelfile.name
            }, true);
        }

        if (obj != undefined && obj.length > 0) {
            logger.logError($scope.excelfile.name + " same file already added");
        } else {
            $scope.files.push($scope.excelfile);
            if($scope.checkundefined($scope.cnReq.files)){
                $scope.cnReq.files=[];
            } 
            $scope.cnReq.files.push({
                filename : $scope.excelfile.name,
                filepath : '',
                cnno : ''
            });

        }

    }
    $scope.checkundefined = function(value) {
        var invalid = false;
        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
            invalid = true;
        }
        return invalid;

    }
});
app.controller('CNRequestApproveCtrl', function($filter,$scope, $rootScope, $http, $location, logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {

    $scope.cnReq = {
            dateRaised : ''
    };
     
     $('#date_raised').datetimepicker({
         format : 'DD/MM/YYYY',
         pickTime: false
     });
     
     var today = new Date();
     var dd = today.getDate();
     var mm = today.getMonth() + 1;

     var yyyy = today.getFullYear();
     if (dd < 10) { dd = '0' + dd }
     if (mm < 10) { mm = '0' + mm }
     var today = dd + '/' + mm + '/' + yyyy;
     $scope.cnReq.dateRaised = today;
    
    $scope.cnTypeList = [];
    $scope.cnTypeList = [{
            id : 'P',
            text : 'Partial CN'},
            {
             id : 'F',
             text : 'Full CN'
            }
    ];
    $scope.userId = '';
    $http.post($stateParams.tenantid+'/app/dashboard/getUserObj').success(function(datas) {
        $scope.userId = datas.userId;
    }).error(function(datas) {
    });
    $scope.invoicedtlamount=0.0;
    $scope.dtldisabled=true;
    $scope.$watch('cnReq.cnType', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue=='F'){
                var amount=0.0;
                $scope.dtldisabled=true;
                angular.forEach($scope.invoicedtlamount, function(bean, idx) {
                    amount=amount+parseFloat(bean.tcamount);
                });
                $scope.cnReq.cnamount=amount;
                $scope.cnReq.credittables=angular.copy($scope.invoicedtlamount);
            }else  if(newValue=='P'){
                $scope.dtldisabled=false;
            }
        }
        
    });
    $scope.catCNList = [];
    $scope.catCNList = [{
                id : 'C',
                text : 'COD'
            },
            {
                 id : 'M',
                 text : 'INCORRECT MLO'
            },
            {
                id : 'P',
                text : 'INCORRECT PAYER'
            },
            {
                id : 'TI',
                text : 'INCORRECT TDR INPUT'
            },
            {
                id : 'DB',
                text : 'INCORRECT DF BILLING'
            },
            {
                id : 'RD',
                text : 'RATE DISPUTE'
            },
            {
                id : 'SE',
                text : 'SYSTEM ERROR'
            },
            {
                id : 'W',
                text : 'WAIVER'
            }
    ];
    
    $scope.invoiceNoList = [];
    
    var cnReq = $stateParams.cnReq;
    if(cnReq != undefined || cnReq != null || cnReq !=""){
        $scope.edit = true;
        var url = $stateParams.tenantid+'/app/corgCustomerWise/editCNInvoice?cnReq=' + cnReq;
        $http.post(url).success(function(data) {
            if (data.success == true) {
                $scope.cnReq = data.lCorgList[0];
                console.log("*************")
                console.log($scope.cnReq)
                 $scope.invoicedtlamount= angular.copy($scope.cnReq.credittables);
                $http.get($stateParams.tenantid+'/app/corgCustomerWise/getInvoiceDetails?invoiceno='+$scope.cnReq.invoiceNo).success(function(datas) {
                    if(datas.length>0){      
                        var invList=datas;
                        $scope.cnReq.invoiceDate = invList[0].invoiceDate;
                        $scope.cnReq.currencyCode = invList[0].currencyCode;
                        $scope.cnReq.exchangeRate = invList[0].exgRate;
                        $scope.cnReq.invoiceAmount = (invList[0].invoiceAmount).toFixed(2);
                        
                        
                        
                    }
                 }).error(function(data) {
                 });
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    $scope.downloadNewFile = function(id) {
        $("#tbnewExport" + id).bind('click', function() {
            // alert('clicked');

        });
        $("#tbnewExport" + id).simulateClick('click');
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
    $scope.approve = function() {
        $scope.cnReq.dateRaised = $('#dateRaised').val();
        $scope.cnReq.approval="Approved";
        var isvalid =true;
        var msg="";
        if ($scope.checkundefined($scope.cnReq.cnType)) {
            msg = msg + "<li>CN TYPE :Field is required.</li>";
            isvalid=false;
        }
        if ($scope.checkundefined($scope.cnReq.invoiceNo)) {
            msg = msg + "<li>INVOICE NO :Field is required.</li>";
            isvalid=false;
        }
       var amount=0.0;
        angular.forEach($scope.cnReq.credittables, function(bean, idx) {
            amount=amount+parseFloat(bean.tcamount);
        });        
        if($scope.cnReq.cnamount!=amount){
           msg= msg+"<li>CN amount "+$scope.cnReq.cnamount+" not matching with total amount of detail "+amount+"</li>"
           isvalid=false;
        }
        
        if(!isvalid){
            logger.logError(msg);
        }else{
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/approve', $scope.cnReq).success(function(data) {
                if(data){
                    if ($scope.files.length > 0) {

                        angular.forEach($scope.files, function(files, index) {
                            var frmData = new FormData();
                            frmData.append("file", files);
                            frmData.append("quotation", cnReq);
                            $.ajax({
                                type : "POST",
                                url : $stateParams.tenantid+"/app/Quotation/saveuploadfile",
                                data : frmData,
                                contentType : false,
                                processData : false,
                                success : function(result) {
                                }
                            });
                        });

                    }
                    logger.logSuccess("Approved Successfully");
                    $state.go('app.finance.transaction.CNRequest.listance.transaction.CNRequest',{tenantid:$stateParams.tenantid});    
                }else{                    
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
    } 
    
    $scope.cancel = function(){
        $state.go('app.finance.transaction.CNRequest.list',{tenantid:$stateParams.tenantid});    
    }
    $scope.deleteuploadfiles = function(filename) {
        $scope.tempfiles = [];
        $scope.tempfilename = [];
        angular.forEach($scope.files, function(row, index) {
            if (filename != row.name) {
                $scope.tempfiles.push(row);
            }

        });

        angular.forEach($scope.cnReq.files, function(row, index) {
            if (filename != row.filename) {
                $scope.tempfilename.push(row);
            }

        });
        $scope.files = $scope.tempfiles;
        $scope.cnReq.files = $scope.tempfilename;

    }
    
    $rootScope.uploadFile = function(element) {
        $scope.excelfile = element.files[0];
    }
    $scope.checkundefined = function(value) {
        var invalid = false;
        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
            invalid = true;
        }
        return invalid;

    }
    $scope.files = [];
    $scope.cnReq.files = [];
    $scope.adduploadfiles = function() {
        var obj = []

        if ($scope.checkundefined($scope.excelfile)) {
            logger.logError("Please select the file");
        } else {
            obj = $filter('filter')($scope.cnReq.files, {
                filename : $scope.excelfile.name
            }, true);
        }

        if (obj != undefined && obj.length > 0) {
            logger.logError($scope.excelfile.name + " same file already added");
        } else {
            $scope.files.push($scope.excelfile);
            if($scope.checkundefined($scope.cnReq.files)){
                $scope.cnReq.files=[];
            } 
                $scope.cnReq.files.push({
                    filename : $scope.excelfile.name,
                    filepath : '',
                    cnno : ''
                });
            
           

        }

    }
  
});
app.controller('CNRequestViewCtrl', function($filter,$scope, $rootScope, $http, $location, logger, ngDialog, utilsService,$state,sharedProperties,$window,$stateParams) {
    $scope.cnReq = {
            dateRaised : ''
    };
    $scope.userId = '';
    $http.post($stateParams.tenantid+'/app/dashboard/getUserObj').success(function(datas) {
        $scope.userId = datas.userId;
    }).error(function(datas) {
    });
    
     $('#date_raised').datetimepicker({
         format : 'DD/MM/YYYY',
         pickTime: false
     });
     
     var today = new Date();
     var dd = today.getDate();
     var mm = today.getMonth() + 1;

     var yyyy = today.getFullYear();
     if (dd < 10) { dd = '0' + dd }
     if (mm < 10) { mm = '0' + mm }
     var today = dd + '/' + mm + '/' + yyyy;
     $scope.cnReq.dateRaised = today;
    
    $scope.cnTypeList = [];
    $scope.cnTypeList = [{
            id : 'P',
            text : 'Partial CN'},
            {
             id : 'F',
             text : 'Full CN'
            }
    ];
    $scope.invoicedtlamount=0.0;
    $scope.dtldisabled=true;
    $scope.$watch('cnReq.cnType', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            if(newValue=='F'){
                var amount=0.0;
                $scope.dtldisabled=true;
                angular.forEach($scope.invoicedtlamount, function(bean, idx) {
                    amount=amount+parseFloat(bean.tcamount);
                });
                $scope.cnReq.cnamount=amount;
                $scope.cnReq.credittables=angular.copy($scope.invoicedtlamount);
            }else  if(newValue=='P'){
                $scope.dtldisabled=false;
            }
        }
        
    });
    $scope.catCNList = [];
    $scope.catCNList = [{
                id : 'C',
                text : 'COD'
            },
            {
                 id : 'M',
                 text : 'INCORRECT MLO'
            },
            {
                id : 'P',
                text : 'INCORRECT PAYER'
            },
            {
                id : 'TI',
                text : 'INCORRECT TDR INPUT'
            },
            {
                id : 'DB',
                text : 'INCORRECT DF BILLING'
            },
            {
                id : 'RD',
                text : 'RATE DISPUTE'
            },
            {
                id : 'SE',
                text : 'SYSTEM ERROR'
            },
            {
                id : 'W',
                text : 'WAIVER'
            }
    ];
    
    $scope.invoiceNoList = [];
    
    var cnReq = $stateParams.cnReq;
    if(cnReq != undefined || cnReq != null || cnReq !=""){
        $scope.edit = true;
        var url = $stateParams.tenantid+'/app/corgCustomerWise/editCNInvoice?cnReq=' + cnReq;
        $http.post(url).success(function(data) {
            if (data.success == true) {
                $scope.cnReq = data.lCorgList[0];
                console.log("*************")
                console.log($scope.cnReq);
                $scope.invoicedtlamount= angular.copy($scope.cnReq.credittables);
                $http.get($stateParams.tenantid+'/app/corgCustomerWise/getInvoiceDetails?invoiceno='+$scope.cnReq.invoiceNo).success(function(datas) {
                    if(datas.length>0){      
                        var invList=datas;
                        $scope.cnReq.invoiceDate = invList[0].invoiceDate;
                        $scope.cnReq.currencyCode = invList[0].currencyCode;
                        $scope.cnReq.exchangeRate = invList[0].exgRate;
                        $scope.cnReq.invoiceAmount = (invList[0].invoiceAmount).toFixed(2);
                        
                        
                        
                    }
                 }).error(function(data) {
                 });
            }
        }).error(function(data) {
            logger.logError("Error Please Try Again");
        });
    }
    $scope.downloadNewFile = function(id) {
        $("#tbnewExport" + id).bind('click', function() {
            // alert('clicked');

        });
        $("#tbnewExport" + id).simulateClick('click');
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
    $scope.update = function() {
        $scope.cnReq.dateRaised = $('#dateRaised').val();
        $scope.cnReq.approval="Pending";
        var isvalid =true;
        var msg="";
        if ($scope.checkundefined($scope.cnReq.cnType)) {
            msg = msg + "<li>CN TYPE :Field is required.</li>";
            isvalid=false;
        }
        if ($scope.checkundefined($scope.cnReq.invoiceNo)) {
            msg = msg + "<li>INVOICE NO :Field is required.</li>";
            isvalid=false;
        }
       var amount=0.0;
        angular.forEach($scope.cnReq.credittables, function(bean, idx) {
            amount=amount+parseFloat(bean.tcamount);
        });        
        if($scope.cnReq.cnamount!=amount){
           msg= msg+"<li>CN amount "+$scope.cnReq.cnamount+" not matching with total amount of detail "+amount+"</li>"
           isvalid=false;
        }
        
        if(!isvalid){
            logger.logError(msg);
        }else{
            $http.post($stateParams.tenantid+'/app/corgCustomerWise/update', $scope.cnReq).success(function(data) {
                if(data){
                    if ($scope.files.length > 0) {

                        angular.forEach($scope.files, function(files, index) {
                            var frmData = new FormData();
                            frmData.append("file", files);
                            frmData.append("quotation", cnReq);
                            $.ajax({
                                type : "POST",
                                url : $stateParams.tenantid+"/app/quotation/saveuploadfile",
                                data : frmData,
                                contentType : false,
                                processData : false,
                                success : function(result) {
                                }
                            });
                        });

                    }
                    logger.logSuccess("Updated Successfully");
                    $state.go('app.finance.transaction.CNRequest.list',{tenantid:$stateParams.tenantid});    
                }else{                    
                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
    } 
    
    $scope.cancel = function(){
        $state.go('app.finance.transaction.CNRequest.list',{tenantid:$stateParams.tenantid});    
    }
    $scope.deleteuploadfiles = function(filename) {
        $scope.tempfiles = [];
        $scope.tempfilename = [];
        angular.forEach($scope.files, function(row, index) {
            if (filename != row.name) {
                $scope.tempfiles.push(row);
            }

        });

        angular.forEach($scope.cnReq.files, function(row, index) {
            if (filename != row.filename) {
                $scope.tempfilename.push(row);
            }

        });
        $scope.files = $scope.tempfiles;
        $scope.cnReq.files = $scope.tempfilename;

    }
    
    $rootScope.uploadFile = function(element) {
        $scope.excelfile = element.files[0];
    }
    $scope.checkundefined = function(value) {
        var invalid = false;
        if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
            invalid = true;
        }
        return invalid;

    }
    $scope.files = [];
    $scope.cnReq.files = [];
    $scope.adduploadfiles = function() {
        var obj = []

        if ($scope.checkundefined($scope.excelfile)) {
            logger.logError("Please select the file");
        } else {
            obj = $filter('filter')($scope.cnReq.files, {
                filename : $scope.excelfile.name
            }, true);
        }

        if (obj != undefined && obj.length > 0) {
            logger.logError($scope.excelfile.name + " same file already added");
        } else {
            $scope.files.push($scope.excelfile);
            if($scope.checkundefined($scope.cnReq.files)){
                $scope.cnReq.files=[];
            } 
                $scope.cnReq.files.push({
                    filename : $scope.excelfile.name,
                    filepath : '',
                    cnno : ''
                });
            
           

        }

    }
});



app.controller('cnRequesttablectrl', function($scope,$http, $filter,logger){
    
    $scope.$watch('creditnoteAcctData.credittables[trIndex].crdtlAccountHead', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            
        }
    });
    
    
});





