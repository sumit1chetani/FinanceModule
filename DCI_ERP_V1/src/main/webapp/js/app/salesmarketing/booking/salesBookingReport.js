/*'use strict';*/
app.controller('bookingReportCtrl', function($scope, $timeout, $stateParams, $filter, $rootScope, $http, $location, logger, utilsService, $state, sharedProperties, $window, ngDialog,$interval) {

    $scope.hideAddIcon = true;
    $scope.hideUploadIcon = true;
    $scope.hideEditIcon = true;
    $scope.hideBreadcrumb = true;
    $scope.pageCounters = [ 10, 25, 50, 100, 500, 1000 ];
    $scope.itemsByPage = 10;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $('.LoadingIndicator').hide();
    $scope.bookingReport={
            vessel :'',
            voyage:'',
            loadBusy:false,
            totLength : 0
    };
    
    $scope.podHeaderList=[];
    $scope.reportList=false;
    $scope.robHeaderList=[];
    $scope.bookingReportVw=[];
    $scope.globalBookingReportVw=[];
    
    
    $scope.headerConstanst=['TEU','WGT','MOVES','TEU','WGT','MOVES','TEU','WGT','MOVES','TEU','WGT','MOVES'];
    $scope.headerTypeConstanst=['Empty','LADEN','OOG'];
        
    $scope.getVesselList = function() {
        var formCode = $('#form_code_id').val();
        $http.post('portCosting/vessel', formCode).success(function(data) {
            $scope.vesselist = data.vesselList;
        });
    };
    
    $scope.$watch('bookingReport.vessel', function(newValue, oldValue) {
        if (newValue != '' && newValue != undefined) {
            $scope.getVoyage(newValue);
            $scope.bookingReport.voyage = '';
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
    $scope.getBookingReport =function(){
        $('.LoadingIndicator').show();
        $scope.podHeaderList=[];
        $scope.robHeaderList=[];
        $scope.bookingReportVw=[];
        if($scope.bookingReport.voyage !=''){
            var url = 'app/bookingReport/reportMap?voyage=' + $scope.bookingReport.voyage +"&fIndex=1&typeid=0";
            $http.post(url).success(function(data) {
                $('.LoadingIndicator').hide();
                $scope.podHeaderList=data.headerList;
                $scope.robHeaderList=data.robHeaderList;
                $scope.globalBookingReportVw=data.lsBookingReport;
                $scope.bookingReportVw=data.lsBookingReport;
                $scope.bookingReport.totLength =data.totalMlo;
                $('#Total').show();
            });    
        }else{
            logger.log("Please Select Voyage!");
        }
    };
    
    $scope.reset=function(){
        $scope.podHeaderList=[];
        $scope.robHeaderList=[];
        $scope.bookingReportVw=[];
        $scope.bookingReport.voyage ="";
        $scope.bookingReport.vessel ="";
    }
    
   /* $interval(function(){
        debugger
        if(id > 1){
            var j=id + 10 ;
            for(var i=id;i<j;i++){
                $scope.bookingReportVw.push($scope.globalList[i]);
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
            if($scope.bookingReportVw.length <= $scope.bookingReport.totLength ){
                $scope.bookingReport.loadBusy=true;
                $scope.onLoad =true;
                //$('.LoadingIndicator').show();
                if($scope.bookingReport.voyage !=''){
                    var url = 'app/bookingReport/reportMap?voyage=' + $scope.bookingReport.voyage +"&fIndex="+$scope.bookingReportVw.length+"&typeid=1";
                    $http.post(url).success(function(data) {
                     //   $('.LoadingIndicator').hide();
                        for(var i=0;i<data.lsBookingReport.length;i++){
                            $scope.bookingReportVw.push(data.lsBookingReport[i]);    
                        }
                        $scope.onLoad =false;
                        $scope.bookingReport.loadBusy=false;
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