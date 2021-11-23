'use strict';
app.controller('reportBuilderCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService) {
    
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
    
    
    $scope.portList=[];
    $scope.voyageList=[];
    $scope.vesselList=[];
    $scope.customerList=[];
    $scope.slotList=[];
    $scope.serviceList=[];
    $scope.locationList=[];
    $scope.activityList=[];
    $scope.limitList=[];
    $scope.costcenterList=[];
    $scope.groupByList=[];
    $scope.messageHeaderList = [];
    $scope.reportBuilder={
            vessel:'',
            voyage:'',
            customer:'',
            slotact:'',
            pod:'',
            pol:'',
            pot:'',
            service:'',
            location:'',
            toDate:'',
            fromDate:'',
            activity:'',
            topnum:'',
            groupBy:'',
            costCenter:'',
            headerList:[],
            groupHeaderList:[]
            
    }
    $('#validFromDate').datetimepicker({
        format : 'DD/MM/YYYY'
    })
    $('#validToDate').datetimepicker({
        format : 'DD/MM/YYYY'
    })
    $scope.$watch('reportBuilder.vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $http.post('app/reportBuilder/getVoyageData', newValue).success(function(datas) {
                $scope.voyageList = datas.lReportBuilderBean;
              
            }).error(function(data) {

            });
        } else {

        }

    });
    
    $scope.viewReport = function() {
        
        $scope.reportBuilder.fromDate = $('#fromDate').val();
        $scope.reportBuilder.toDate = $('#toDate').val();
        if($scope.reportBuilder.customer==''&& $scope.reportBuilder.vessel=='' && $scope.reportBuilder.voyage=='' && $scope.reportBuilder.pol=='' && $scope.reportBuilder.pod=='' && $scope.reportBuilder.pot=='' 
            && $scope.reportBuilder.slotact=='' && $scope.reportBuilder.service=='' &&  $scope.reportBuilder.fromDate =='' && $scope.reportBuilder.toDate=='' && $scope.reportBuilder.activity=='' && $scope.reportBuilder.location==''){
            logger.logError("Please select any one of the above search conditions");
        }else{
                var groupHeaderSelectedList= $filter('filter')($scope.messageHeaderList1, { visible: true}, true);
                var headerSelectedList= $filter('filter')($scope.messageHeaderList, { visible: true}, true);
                $scope.reportBuilder.groupHeaderList=groupHeaderSelectedList;
                $scope.reportBuilder.headerList=headerSelectedList;
                console.log($scope.reportBuilder);
                $http.post('app/reportBuilder/viewReport', $scope.reportBuilder).success(function(datas) {
                    console.log(datas.lReportBuilderBean);
                    if(datas.success==true && datas.lReportBuilderBean.length>0){
                        $scope.rowCollection =[];
                        $scope.rowCollection = datas.lReportBuilderBean;
                    }else{
                        $scope.rowCollection =[];
                        logger.logError("No Records Found!...");
                    }
                }).error(function(data) {
        
                });
        }
             
    };
    
    $scope.exportSalesReportExcel = function(){
        
        
        $scope.reportBuilder.fromDate = $('#fromDate').val();
        $scope.reportBuilder.toDate = $('#toDate').val();
        if($scope.reportBuilder.customer==''&& $scope.reportBuilder.vessel=='' && $scope.reportBuilder.voyage=='' && $scope.reportBuilder.pol=='' && $scope.reportBuilder.pod=='' && $scope.reportBuilder.pot=='' 
            && $scope.reportBuilder.slotact=='' && $scope.reportBuilder.service=='' &&  $scope.reportBuilder.fromDate =='' && $scope.reportBuilder.toDate=='' && $scope.reportBuilder.activity=='' && $scope.reportBuilder.location==''){
            logger.logError("Please select any one of the above search conditions");
        }else{
                var groupHeaderSelectedList= $filter('filter')($scope.messageHeaderList1, { visible: true}, true);
                var headerSelectedList= $filter('filter')($scope.messageHeaderList, { visible: true}, true);
                $scope.reportBuilder.groupHeaderList=groupHeaderSelectedList;
                $scope.reportBuilder.headerList=headerSelectedList;
                console.log($scope.reportBuilder);
                $http.post('app/reportBuilder/excelExport', $scope.reportBuilder).success(function(data) {
                    console.log("report builder export excel");
                    if (data.success == true) {
                        $("#salesReportExportLink").bind('click', function() {
                        });
                        $('#salesReportExportLink').simulateClick('click');
                        logger.logSuccess("Exported successfully!");
                    }else{
                        logger.logError("Failed to Export!..");
                    }
                }).error(function(data) {
        
                });
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
    $scope.dropdown=function(){
        var data=["10","20","50","100"]
        
        var groupdata=["slotact","vessel","voyage","customer","service"];
        
        for(var i=0;i<data.length;i++){
            var json={};
            json["id"]=data[i];
            json["text"]=data[i];
            $scope.limitList.push(json)
        }
        for(var i=0;i<groupdata.length;i++){
            var json={};
            json["id"]=groupdata[i];
            json["text"]=groupdata[i];
            $scope.groupByList.push(json)
        }
        
        $http.get('app/reportBuilder/getVesselData?formCode='+$('#form_code_id').val()).success(function(datas) {
            console.log(datas);
            $scope.vesselList = datas.lReportBuilderBean;        
            $scope.messageHeaderList  = datas.headerList;
            $scope.messageHeaderList1  = datas.groupHeaderList;
        }).error(function(data) {

        });
        
        $http.get('app/reportBuilder/getLocationData').success(function(datas) {
            $scope.locationList = datas.lReportBuilderBean;           
        }).error(function(data) {

        });
        
        $http.get('app/reportBuilder/getActivityData').success(function(datas) {
            $scope.activityList = datas.lReportBuilderBean;           
        }).error(function(data) {

        });
        $http.get('app/reportBuilder/getPortData').success(function(datas) {
            $scope.portList = datas.lReportBuilderBean;           
        }).error(function(data) {

        });
       
        $http.get('app/reportBuilder/getServiceData').success(function(datas) {
            $scope.serviceList = datas.lReportBuilderBean;           
        }).error(function(data) {

        });
        
        $http.get('app/reportBuilder/getSlotData').success(function(datas) {
            $scope.slotList = datas.lReportBuilderBean;           
        }).error(function(data) {

        });
        
        $http.get('app/reportBuilder/getCustomerData').success(function(datas) {
            $scope.customerList = datas.lReportBuilderBean;           
        }).error(function(data) {

        });
        
        }
    
    $scope.selectedVisibility = [];
    $scope.getSelectedColumn = function(index) {
        
console.log("getSelectedColumn");
        var value = $scope.messageHeaderList.indexOf(index);
        var indexExsists = $scope.selectedVisibility.indexOf(index);
        if (indexExsists == -1) {
            $scope.selectedVisibility.push(value);
        }
     
    };
    
    
    $scope.onDropComplete = function(index, obj, evt) {
        console.log("onDropComplete");
        debugger;
        var otherIndex = $scope.messageHeaderList.indexOf(obj);

        if (index != undefined &&  otherIndex>-1) {
            $scope.messageHeaderList.splice(otherIndex, 1);            
            $scope.messageHeaderList.splice(index, 0, obj);
        }

        else if (index = "undefined" && otherIndex>-1) {
            $scope.messageHeaderList.splice(otherIndex, 1);
            $scope.messageHeaderList.splice($scope.messageHeaderList.length, 0, obj);
        }
    
        
    };
    
    $scope.dropdown();
    
    
    
    
    
    
    $scope.selectedVisibility1 = [];
    $scope.getSelectedColumn1 = function(index) {
        console.log("getSelectedColumn1");
        var value = $scope.messageHeaderList1.indexOf(index);
        var indexExsists = $scope.selectedVisibility1.indexOf(index);
        if (indexExsists == -1) {
            $scope.selectedVisibility1.push(value);
        }
     
    };
    
    
    $scope.onDropComplete1 = function(index, obj, evt) {
        var otherIndex = $scope.messageHeaderList1.indexOf(obj);
        console.log("onDropComplete1");
        if (index != undefined &&  otherIndex>-1) {
            $scope.messageHeaderList1.splice(otherIndex, 1);            
            $scope.messageHeaderList1.splice(index, 0, obj);
        }

        else if (index = "undefined" &&  otherIndex>-1) {
            $scope.messageHeaderList1.splice(otherIndex, 1);
            $scope.messageHeaderList1.splice($scope.messageHeaderList1.length, 0, obj);
        }
    
        
    };
    
    
    $scope.selectall = true;
    $scope.selectAll = function(value){
        for(var index in $scope.messageHeaderList){
            console.log($scope.messageHeaderList[index])
            var colum = $scope.messageHeaderList[index];
            if(colum.isDefault == false){
                if(value == true){
                    colum.visible = true;
                }else{
                    colum.visible = false;
                }
            }
        }
            
    }
    $scope.selectallGroup = true;
    $scope.selectAllGroup = function(value){
        for(var index in $scope.messageHeaderList1){
            console.log($scope.messageHeaderList1[index])
            var colum = $scope.messageHeaderList1[index];
            if(colum.isDefault == false){
                if(value == true){
                    colum.visible = true;
                }else{
                    colum.visible = false;
                }
            }
        }
            
    }
});

 