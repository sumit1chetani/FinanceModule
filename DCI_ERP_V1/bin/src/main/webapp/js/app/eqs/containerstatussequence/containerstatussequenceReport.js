/*'use strict';*/
app.controller('containerstatussequenceReportCtrl', function($scope, $timeout, $stateParams, $filter, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window, ngDialog,$interval) {

    $scope.hideAddIcon = true;
    $scope.hideUploadIcon = true;
    $scope.hideEditIcon = true;
    $scope.hideBreadcrumb = true;
    $scope.pageCounters = [ 10, 25, 50, 100, 500, 1000 ];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $('.LoadingIndicator').hide();
    $scope.containerstatussequenceReport={
            vessel :'',
            voyage:'',
            loadBusy:false,
            totLength : 0
    };
    
    $scope.podHeaderList=[];
    $scope.reportList=false;
    $scope.robHeaderList=[];
    $scope.containerstatussequenceReportVw=[];
    $scope.globalcontainerstatussequenceReportVw=[];
    
    
    $scope.headerConstanst=['TEU','WGT','MOVES','TEU','WGT','MOVES','TEU','WGT','MOVES','TEU','WGT','MOVES'];
    $scope.headerTypeConstanst=['Empty','LADEN','OOG'];
        
    $scope.getVesselList = function() {
        var formCode = $('#form_code_id').val();
        $http.post('portCosting/vessel', formCode).success(function(data) {
            $scope.vesselist = data.vesselList;
        });
    };
    
    $scope.$watch('containerstatussequenceReport.vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.getVoyage(newValue);
            $scope.containerstatussequenceReport.voyage = '';
        } 
    });
    
    $scope.getVesselList();

    $scope.getVoyage =function(vesselCode){
        var url = 'app/loadingSummary/voyageList?vesselCode=' + vesselCode;
        $http.get(url).then(function(result) {
            $scope.voyageList=result.data;
        });
    }
    //reportMap
    $scope.getcontainerstatussequenceReport =function(){
        $('.LoadingIndicator').show();
        $scope.podHeaderList=[];
        $scope.robHeaderList=[];
        $scope.containerstatussequenceReportVw=[];
        if($scope.containerstatussequenceReport.voyage !=''){
            var url = 'app/containerstatussequenceReport/reportMap?voyage=' + $scope.containerstatussequenceReport.voyage +"&fIndex=1&typeid=0";
            $http.post(url).success(function(data) {
                $('.LoadingIndicator').hide();
                $scope.podHeaderList=data.headerList;
                $scope.robHeaderList=data.robHeaderList;
                $scope.globalcontainerstatussequenceReportVw=data.lscontainerstatussequenceReport;
                $scope.containerstatussequenceReportVw=data.lscontainerstatussequenceReport;
                $scope.containerstatussequenceReport.totLength =data.totalMlo;
                $('#Total').show();
            });    
        }else{
            logger.log("Please Select Voyage!");
        }
    };
    
    $scope.reset=function(){
        $scope.podHeaderList=[];
        $scope.robHeaderList=[];
        $scope.containerstatussequenceReportVw=[];
        $scope.containerstatussequenceReport.voyage ="";
        $scope.containerstatussequenceReport.vessel ="";
    }
    
   /* $interval(function(){
        debugger
        if(id > 1){
            var j=id + 10 ;
            for(var i=id;i<j;i++){
                $scope.containerstatussequenceReportVw.push($scope.globalList[i]);
                id=i;
            }
        }
         
    },10000);*/
    
    
    $scope.viewRob = function() {
        if ($scope.robList.length > 0) {
            $scope.isRobView = true;
        } else {
            $scope.isRobView = false;
        }
    }
    
    $scope.toggleBlock = function(blockId) {
        $('#'+blockId).slideToggle(10);
    }
    $("div[id$='Block']").slideToggle(10);
    
   
    $scope.onLoad=false;
    $scope.loadMore = function() {
        if(!$scope.onLoad){
            if($scope.containerstatussequenceReportVw.length <= $scope.containerstatussequenceReport.totLength ){
                $scope.containerstatussequenceReport.loadBusy=true;
                $scope.onLoad =true;
                //$('.LoadingIndicator').show();
                if($scope.containerstatussequenceReport.voyage !=''){
                    var url = 'app/containerstatussequenceReport/reportMap?voyage=' + $scope.containerstatussequenceReport.voyage +"&fIndex="+$scope.containerstatussequenceReportVw.length+"&typeid=1";
                    $http.post(url).success(function(data) {
                     //   $('.LoadingIndicator').hide();
                        for(var i=0;i<data.lscontainerstatussequenceReport.length;i++){
                            $scope.containerstatussequenceReportVw.push(data.lscontainerstatussequenceReport[i]);    
                        }
                        $scope.onLoad =false;
                        $scope.containerstatussequenceReport.loadBusy=false;
                    });    
                }else{
                    logger.log("Please Select Voyage!");
                }
            }
        }
      };
        
});

app.filter('percentage', ['$filter', function($filter) {
    return function(input) {
        return $filter('number')(input*100);
    };
}]);