
app.controller('monthEndReportCtrl', function($templateCache, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,$timeout) {

    $scope.chartData="";
    $scope.chartHeaderData="";
    $scope.chartData1="";
    $scope.chartHeaderData1="";
    $scope.yearList=[];
    $scope.monthList=[];
    $scope.vesselList=[];
    $scope.report={
            year : new Date().getFullYear().toString().substr(-2),
            month:[],
            vessel : []
    }
    
    $http.get('app/monthendreport/filterList').success(function(response) {
        console.log(response);
        if (response!=null && response!=undefined ) {
            $scope.yearList = response.yearList;
            $scope.monthList = response.monthList;
            $scope.vesselList = response.vesselList;
            
            $timeout(function() {
                $('#month').multiselect('deselectAll', false);
                $('#month').multiselect('updateButtonText');
                $("#month").multiselect('rebuild');
            }, 2, false);
            
            $timeout(function() {
                $('#vessel').multiselect('deselectAll', false);
                $('#vessel').multiselect('updateButtonText');
                $("#vessel").multiselect('rebuild');
            }, 2, false);
        } else {
            logger.logError('Something went wrong!');
        }
    })
    
     $("#month").multiselect({
        maxHeight : 200,
        includeSelectAllOption : true,
        disableIfEmpty : true,
    });
    $(".multiselect").addClass("width_100 input-sm line-height-5");
    
    $("#vessel").multiselect({
        maxHeight : 200,
        includeSelectAllOption : true,
        disableIfEmpty : true,
    });
    $(".multiselect").addClass("width_100 input-sm line-height-5");
    
    $scope.buildChart = function(){
    Highcharts.chart('container', {
       
        chart: {
            renderTo: "container",
            type: "column",
            borderWidth: 5,
            borderColor: '#e8eaeb',
            borderRadius: 0,
            backgroundColor: '#f7f7f7'
        },
        title: {
            style: {
                'fontSize': '1em'
            },
            useHTML: true,
            x: -27,
            y: 8,
            text: ' '
        },
        yAxis: [{ // Primary yAxis
            labels: {
                format: '{value}',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            },
            title: {
                text: 'Rate',
                style: {
                    color: Highcharts.getOptions().colors[0]
                }
            }
        }],
        series: $scope.chartData,
        xAxis: {
            categories: $scope.chartHeaderData
        }
    });
    }
    
    $scope.buildCharttwo= function(){

        Highcharts.chart('container1', {
           
            chart: {
                renderTo: "container1",
                type: "column",
                borderWidth: 5,
                borderColor: '#e8eaeb',
                borderRadius: 0,
                backgroundColor: '#f7f7f7'
            },
            title: {
                style: {
                    'fontSize': '1em'
                },
                useHTML: true,
                x: -27,
                y: 8,
                text: ' '
            },
            yAxis: [{ // Primary yAxis
                labels: {
                    format: '{value}',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
                },
                title: {
                    text: 'Rate',
                    style: {
                        color: Highcharts.getOptions().colors[0]
                    }
                }
            }],
            series: $scope.chartData1,
            xAxis: {
                categories: $scope.chartHeaderData1
            }
        });
        
    }
    
    
    $scope.$watch('report.year', function(newValue, oldValue) {
        if (newValue != '' && newValue !=undefined) {
            $scope.fetchChart();
        }
    })
    
      $scope.$watch('report.month', function(newValue, oldValue) {
//            if (newValue != '' && newValue !=undefined) {
                $scope.fetchChart();
//            }
        })
        
        $scope.$watch('report.vessel', function(newValue, oldValue) {
//            if ((newValue != '' && newValue !=undefined) || (newValue.length==0 && ) ) {
                $scope.fetchChart();
//            }
        })
        $scope.hdrList=[];
        $scope.fetchChart = function(){
        $http.post('app/monthendreport/firstChart',$scope.report).success(function(response) {
            console.log(response);
            if (response.success) {
                $scope.chartData = response.highChartColumnBeanList;
                $scope.chartHeaderData = response.headerList;
                $scope.buildChart();
                $scope.fetchDataCharttwo();
                $scope.hdrList = [];
                for(var index in $scope.chartHeaderData){
                    $scope.hdrList.push('HFO');
                    $scope.hdrList.push('CYL');
                    $scope.hdrList.push('SPEED');
                }
            } else {
                logger.logError('Something went wrong.!');
            }
        })
        
        
    }
        
        $scope.fetchDataCharttwo = function(){
            $http.post('app/monthendreport/SecondChart',$scope.report).success(function(response) {
                console.log(response);
                if (response.success) {
                    $scope.chartData1 = response.highChartColumnBeanList;
                    $scope.chartHeaderData1 = response.headerList;
                    $scope.buildCharttwo();
                    $scope.hdrList1 = [];
                    for(var index in $scope.chartHeaderData1){
                        $scope.hdrList1.push('AEO LO');
                        $scope.hdrList1.push('AE R.Hrs');
                    }
                } else {
                    logger.logError('Something went wrong.!');
                }
            })
            
            
        }
        
 });
