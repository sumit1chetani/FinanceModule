app.controller('vesselPerformanceCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,$timeout,validationService, toaster) {
    
    $scope.vesselPerf={
            fromDate : '',
            toDate : '',
            vesselCode : '',
            voyageCode : '',
            portCode : '',
            portISO : '',
            portCodeISO : ''
    }
    
    $scope.vesselList = [];
    $scope.voaygeList = [];
    $scope.rowCollection = [];
    
    $scope.dropDownList=function(){
        $http.post('app/operations/arrivalreport/vesselList').success(function(arrivalReportResultBean) {
            $scope.vesselList = arrivalReportResultBean.vesselList;
        }).error(function(data) {
            //logger.logError("Error Please Try Again");
        });
        
        
    };
    
    $scope.dropDownList();
    
    $scope.$watch('vesselPerf.vesselCode', function(newValue, oldValue) {
        $http.post('app/operations/arrivalreport/voyageList',$scope.vesselPerf).success(function(arrivalReportResultBean) {
            $scope.voaygeList = arrivalReportResultBean.voyageList;
        }).error(function(data) {
            //logger.logError("Error Please Try Again");
        });
    });
    
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; // January is 0!

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    var today = dd + '/' + mm + '/' + yyyy;
    
    $timeout(function() {
        $("#fromDate").datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime : false
        })
    }, 500);
    
    $timeout(function() {
        $("#toDate").datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime : false
        })
    }, 500);
    
    $scope.vesselPerf.fromDate = today;  
    $scope.vesselPerf.toDate = today; 
    
    $scope.polList = [];
    $http.get('app/commonUtility/getPortList').success(function(datas) {
        $scope.polList = datas;
    });
    
    $scope.portISOList = [];
    $http.get('app/commonUtility/getPortISO_portList').success(function(datas) {
        $scope.portISOList = datas;
    }).error(function(datas) {
    });

    $scope.$watch('vesselPerf.portISO',function(newValue,oldValue){
        $scope.vesselPerf.portCodeISO = '';
        if(newValue != '' && newValue != null){
            angular.forEach($scope.portISOList, function (item, key){
                if(newValue == item.id)
                    $scope.vesselPerf.portCodeISO = item.text;
                    
            });
        }
    });
    
    $scope.$watch('vesselPerf.vesselId',function(newValue,oldValue){
        if(newValue!=''&&newValue!=null){
            $scope.vesselPerfChartData();
        }
    });

    $scope.search = function(vesselPerfForm){
        $scope.vesselPerf.fromDate = $('#txtfromDate').val();
        $scope.vesselPerf.toDate = $('#txttoDate').val();
        if(($scope.vesselPerf.portCode != "")&&($scope.vesselPerf.portISO != ""))
            logger.logError("Please select either Port or Port ISO");
        else{
        //if (new validationService().checkFormValidity($scope.vesselPerfForm)) {
            $http.post('app/operations/arrivalreport/search',$scope.vesselPerf).success(function(arrivalReportResultBean) {
                console.log("&&&&&&&&&&&&&")
                console.log(arrivalReportResultBean)
                $scope.rowCollection = arrivalReportResultBean.searchList;
            }).error(function(data) {
                //logger.logError("Error Please Try Again");
            });
       /* }else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.vesselPerfForm.$validationSummary), 555000, 'trustedHtml');
        }*/
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
    
    $scope.exportExcel = function(){
        $scope.vesselPerf.fromDate = $('#txtfromDate').val();
        $scope.vesselPerf.toDate = $('#txttoDate').val();
        if(($scope.vesselPerf.portCode != "")&&($scope.vesselPerf.portISO != ""))
            logger.logError("Please select either Port or Port ISO");
        else{
        $http.post('app/operations/arrivalreport/exportExcel',$scope.vesselPerf).success(function(data) {
            if(data){
                debugger;
                $("#excel").bind('click', function() {
                });
                $('#excel').simulateClick('click');
                logger.logSuccess("Exported successfully!");
            }else{
                logger.logError("Failed to export");
            }
        });
        }
    }
    
    $scope.exportExcelForRef = function(){
        $scope.vesselPerf.fromDate = $('#txtfromDate').val();
        $scope.vesselPerf.toDate = $('#txttoDate').val();
        if(($scope.vesselPerf.portCode != "")&&($scope.vesselPerf.portISO != ""))
            logger.logError("Please select either Port or Port ISO");
        else{
            $http.post('app/operations/arrivalreport/exportExcelForRef',$scope.vesselPerf).success(function(data) {
                if(data){
                    debugger;
                    $("#excelForRef").bind('click', function() {
                    });
                    $('#excelForRef').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logError("Failed to export");
                }
            });
        }
    }
    
});
app.controller('voyagePerformanceCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService) {
    $scope.voyagePerf={
            vesselId:''
    };
    $scope.getVesselList=function(){
        var url='app/dashboard/getVesselList';
        $http.get(url).success(function(datas){
            $scope.lVesselList=datas.vesselList;
            if($scope.lVesselList.length > 0){
                $scope.voyagePerf.vesselId = $scope.lVesselList[0].id;
              }
        }).error(function(datas){
            logger.logError("Error");
        });
    };
    $scope.getVesselList();
    $scope.voyagePerfChartData=function(){
        var url='app/dashboard/voyMinMaxPerfChart?vesselId='+$scope.voyagePerf.vesselId;
        $http.get(url).success(function(datas){
            console.log(datas);
            $scope.createVoBarChart('voyageInProgressBar',datas.chartBean.chartLabel,datas.chartBean.chartMeasures);
        }).error(function(datas){
            logger.logError("Error");
        });
    
    };
    $scope.$watch('voyagePerf.vesselId',function(newValue,oldValue){
        if(newValue!=''&&newValue!=null){
            $scope.voyagePerfChartData();
        }
    });
    
    var vobarChart;
    $scope.voisIntialized = false;
    $scope.createVoBarChart = function(id, barLabel, barData){
       
        if(!$scope.voisIntialized){
            $scope.voisIntialized = true;
            var surveryInProgressBar=document.getElementById(id).getContext("2d");
            var gradient = surveryInProgressBar.createLinearGradient(0, 0, 0, 400);
            gradient.addColorStop(0, 'rgb(255,78,80)');   
            gradient.addColorStop(1, 'rgb(249,212,35)');
            var surveryInProgressBarData = {
                labels: barLabel,
                datasets: [
                    {
                        label: "Completed",
                        fillColor:gradient,
                        strokeColor: "rgba(111,166,215,1)",
                        highlightStroke: "rgba(111,166,215,1)",
                        data: barData
                    }
                ]
            };
            var surveryInProgressBar=document.getElementById(id).getContext("2d");
            vobarChart= new Chart(surveryInProgressBar).Bar(surveryInProgressBarData,{
            pointDotRadius: 10,
            scaleOverride:true,
            scaleStartValue:0,
            scaleStepWidth:10,
            scaleSteps:10
        });
      }else{
          vobarChart.destroy();
          $scope.voisIntialized = false;
          $scope.createVoBarChart(id,barLabel,barData);
      } 
    };
    
});
app.controller('vesselUtilizationCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService) {
    $scope.vesselUtil={
            vesselId:'',
            voyageId : '',
            slotId : ''
    };
    $scope.lVoyageList = [];
    $scope.lslotList=[];
    $scope.getVesselList=function(){
        var url='app/utilization/getVesselList';
        $http.get(url).success(function(datas){
            $scope.lVesselList=datas.vesselList;
            if($scope.lVesselList.length > 0){
                $scope.vesselUtil.vesselId = $scope.lVesselList[0].id;
              }
        }).error(function(datas){
            logger.logError("Error");
        });
        $http.get('app/utilization/slotList').success(function(result) {
            $scope.lslotList = result.slotList;
            console.log($scope.lslotList);
            $scope.vesselUtil.slotId='0';
        }).error(function(datas){
            logger.logError("Error");
        });
    };
    $scope.getVesselList();
    $scope.vPortList = [];
    $scope.tempVPortList =[];
    $scope.vesselCapacity="";
    $scope.vesselWeight="";
    $scope.vesselSector="";
    $scope.vesselPerfChartData=function(){
        var url='app/utilization/vesselPerfChartData?vesselId='+$scope.vesselUtil.vesselId+'&slotId='+$scope.vesselUtil.slotId;
        $http.get(url).success(function(datas){
            $scope.lVoyageList = datas.chartBean.chartLabel;
            $scope.vPortList = datas.chartBean.voyageList;
            $scope.tempVPortList = datas.chartBean.voyageList;
            $scope.vesselUtil.voyageId = $scope.vPortList[0].voyage;
            $scope.vesselCapacity=datas.chartBean.initVesselCapacity;
            $scope.vesselWeight=datas.chartBean.initVesselWeight;
            $scope.vesselSector=datas.chartBean.sector;
            $scope.utilizationGrid($scope.tempVPortList);
            $scope.createVBarChart('vesselUtilInProgressBar',datas.chartBean.chartLabel,datas.chartBean.chartMeasures);
            $scope.createPBarChart('portUtilInProgressBar',$scope.vPortList[0].portChartLabel,$scope.vPortList[0].portChartMeasures);
            
        }).error(function(datas){
            logger.logError("Error");
        });
    
    }
    $scope.$watch('vesselUtil.vesselId',function(newValue,oldValue){
        if(newValue!=''&&newValue!=null){
            $scope.vesselPerfChartData();
        }
    });
    
    $scope.$watch('vesselUtil.slotId',function(newValue,oldValue){
        if(newValue!=''&&newValue!=null){
            $scope.vesselPerfChartData();
        }
    });
    
    $scope.$watch('vesselUtil.voyageId',function(newValue,oldValue){
        if(newValue!=''&&newValue!=null){
            for(var index in $scope.vPortList){
                var voyageId = $scope.vPortList[index].voyage;
                if($scope.vesselUtil.voyageId == voyageId){
                    $scope.createPBarChart('portUtilInProgressBar',$scope.vPortList[index].portChartLabel,$scope.vPortList[index].portChartMeasures);
                    break;
                }
            }
        }
    });
    
    var vbarChart;
    $scope.visIntialized = false;
    $scope.createVBarChart = function(id, barLabel, barData){
        if(!$scope.visIntialized){
            $scope.visIntialized = true;
            var surveryInProgressBar=document.getElementById(id).getContext("2d");
            var gradient = surveryInProgressBar.createLinearGradient(0, 0, 0, 400);
            gradient.addColorStop(0, 'rgb(255,78,80)');   
            gradient.addColorStop(1, 'rgb(249,212,35)');
            var surveryInProgressBarData = {
                labels: barLabel,
                datasets: [
                    {
                        label: "Completed",
                        fillColor:gradient,
                        strokeColor: "rgba(111,166,215,1)",
                        highlightStroke: "rgba(111,166,215,1)",
                        data: barData
                    }
                ]
            };
            var surveryInProgressBar=document.getElementById(id).getContext("2d");
            vbarChart= new Chart(surveryInProgressBar).Bar(surveryInProgressBarData,{
            pointDotRadius: 10,
            scaleOverride:true,
            scaleStartValue:0,
            scaleStepWidth:10,
            scaleSteps:10
        });
      }else{
          vbarChart.destroy();
          $scope.visIntialized = false;
          $scope.createVBarChart(id,barLabel,barData);
      } 
    };
    
    var pbarChart;
    $scope.pisIntialized = false;
    $scope.createPBarChart = function(id, barLabel, barData){
        if(!$scope.pisIntialized){
            $scope.pisIntialized = true;
            var surveryInProgressBar=document.getElementById(id).getContext("2d");
            var gradient = surveryInProgressBar.createLinearGradient(0, 0, 0, 400);
            gradient.addColorStop(0, 'rgb(255,78,80)');   
            gradient.addColorStop(1, 'rgb(249,212,35)');
            var surveryInProgressBarData = {
                labels: barLabel,
                datasets: [
                    {
                        label: "Completed",
                        fillColor:gradient,
                        strokeColor: "rgba(111,166,215,1)",
                        highlightStroke: "rgba(111,166,215,1)",
                        data: barData
                    }
                ]
            };
            var surveryInProgressBar=document.getElementById(id).getContext("2d");
            pbarChart= new Chart(surveryInProgressBar).Bar(surveryInProgressBarData,{
            pointDotRadius: 10,
            scaleOverride:true,
            scaleStartValue:0,
            scaleStepWidth:10,
            scaleSteps:10
        });
      }else{
          pbarChart.destroy();
          $scope.pisIntialized = false;
          $scope.createPBarChart(id,barLabel,barData);
      } 
    };
    
    $scope.utilizationGrid = function(voyageList){
        var data=[];
        $("#vesselUtilGrid").jqGrid({
            data: voyageList,
            datatype: "local",
            multiboxonly: false,
            autowidth: true,
            height: '100%',
            width : '100%',
            rowList: [100,200,300],
            multiselect: false,
            gridview:true,
            colNames : [ 'Voyage', 'Vessel Capacity','Vessel Weight','Utilized(TEUs)','Utilized(Weight)','TEUs (%)' ,'Weight (%)','Allocated Capacity','Allocated Weight','Utilized(Alloc.TEUs) (%)','Utilized(Alloc.Weight) (%)'],
            colModel:[
                {name:'voyage',index:'voyage', width:80, align:"left"},
                {name:'vesselCapacity',index:'vesselCapacity', width:40, align:"right"},
                {name:'vesselWeight',index:'vesselWeight', width:40, align:"right"},
                {name:'teus',index:'teus', width:50,align:"right"},
                {name:'weight',index:'weight', width:50,align:"right"},
                {name:'percentage',index:'percentage', width:40,align:"right"},
                {name:'weightPercentage',index:'weightPercentage', width:40,align:"right"},
                {name:'allocatedVesselCapacity',index:'allocatedVesselCapacity', width:60,align:"right"},
                {name:'allocatedVesselWeight',index:'allocatedVesselWeight', width:60,align:"right"},
                {name:'allocatedVesselCapacityPerc',index:'allocatedVesselCapacityPerc', width:80,align:"right"},
                {name:'allocatedVesselWeightPerc',index:'allocatedVesselWeightPerc', width:70,align:"right"}
                ],
            viewrecords: true,
            ignoreCase: true,
            subGrid: true,
            subGridOptions: {
                "plusicon" : 'ui-icon-plus',
                "minusicon" : 'ui-icon-minus'
            },
            subGridRowExpanded: function(subgridid, row_id) {
                var subgrid_table_id, 
                subgrid_table_id = subgridid+"_t";
                     $("#"+subgridid).html("<table id='"+subgrid_table_id+"' class='scroll'></table>");
                     $("#"+subgrid_table_id).jqGrid({
                     datatype: "local",
                     data: $scope.tempVPortList[parseInt(row_id)-1].portList,
                     colNames:['Port','Port Sequence', 'TEUs','Weight', 'TEUs (%)','Weight (%)','Allocated TEUs (%)','Allocated Weight (%)','Port Loaded','Port Efficiency','Port Contribution'],
                     colModel:[
                            {name:'pol',index:'pol', width:80, align:"left"},
                            {name:'portSequence',index:'portSequence', width:80, align:"right"},
                            {name:'teus',index:'teus', width:80,align:"right"},
                            {name:'weight',index:'weight', width:80,align:"right"},
                            {name:'percentage',index:'percentage', width:80,align:"right"},
                            {name:'weightPercentage',index:'weightPercentage', width:80,align:"right"},
                            {name:'allocatedVesselCapacityPerc',index:'allocatedVesselCapacityPerc', width:140,align:"right"},
                            {name:'allocatedVesselWeightPerc',index:'allocatedVesselWeightPerc', width:140,align:"right"},
                            {name:'portLoaded',index:'portLoaded', width:140,align:"right"},
                            {name:'portEfficiency',index:'portEfficiency', width:140,align:"right"},
                            {name:'portContribution',index:'portContribution', width:140,align:"right"},
                            /*{name:'actions',index:'actions', width:200,align:"center"},*/
                        ],
                        height: '100%',
                    gridComplete: function(){
                        var ids = jQuery("#"+subgrid_table_id).jqGrid('getDataIDs');
                        for(var i=0;i < ids.length;i++){
                            var cl = ids[i];
                            be = "<div style='cursor:pointer;align:center;' title=\"Edit\" onclick="+editMethod("'"+cl+"'")+"><span class=\"ui-icon ui-icon-plus\"></span></div>";
                            $("#"+subgrid_table_id).jqGrid('setRowData',ids[i],{actions:be});
                        }
                    }
                }).jqGrid('setGridParam').trigger("reloadGrid");
             }
        }).jqGrid('setGridParam', { data : voyageList }).trigger("reloadGrid");
    };
    function editMethod(id){
        console.log("Bharath"+id);
    };
    
    $scope.excelExport="assets/excelDocument/"+$scope.vesselUtil.vesselId+"_utillizationReport.xlsx";
    $scope.excelExportFileName=$scope.vesselUtil.vesselId+"_utillizationReport.xlsx";
    
    $scope.exportExcel = function(){
            var url='app/utilization/utilizationExportExcel?obChartBean='+$scope.tempVPortList+'&vesselId='+$scope.vesselUtil.vesselId;
            $http.post(url).success(function(data) {
                if(data.success){
                    $("#VUExport").bind('click', function() {
                    });
                    $('#VUExport').simulateClick('click');
                    logger.logSuccess("Exported successfully!");
                }else{
                    logger.logSuccess("Failed to export");
                }
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
    };
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
    };
});