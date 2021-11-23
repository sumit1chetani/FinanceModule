app.service("recievableService",function($http,$q){
    
    this.getMloList = function(){
        var mloList = $q.defer();
        $http.get('report/recievableondate/getMloList').success(function(data) {
        
            mloList.resolve(data);
        
        }).error(function(data) {
        
            mloList.reject("Failed to get Customer(Mlo) List");
        
        });
        return mloList.promise;
    }
    this.getYearList = function(){
         var yearList = [];
        
         var currentYear = new Date().getFullYear();
         var minYear = 2008;
         var difference = this.getYears(currentYear,minYear);
         yearList = difference;
         yearList.push(minYear);
         
         return yearList;
    }
    this.getYears = function(val1,val2){
        var diff =  Math.abs(val1 - val2);
        var lists = [];
        for(var i=0 ; i<diff;i++)
        {
            lists.push(val1--);    
        }
        return lists;
    }
    this.viewReport = function(slot_id,mlo1,year1){
        var reportList = $q.defer();
        $http.get('report/recievableondate/getViewReport',{params:{slotId:slot_id,mlo:mlo1,year:year1}
        }).success(function(data) {
            reportList.resolve(data);
        }).error(function(data) {
        
            reportList.reject("Failed to get Customer(Mlo) List");
        
        });
        return reportList.promise;
    }
});

app.controller('ssfreportCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal,
        $location, $filter, utilsService,recievableService) {
   $scope.mloList=[];
   $scope.slotList=[];
   $scope.mlo = [];
   $scope.slotssf = [];
   $scope.isShow = false;
   $scope.isRecordExsist = false;
   
    $scope.dataList = recievableService.getMloList();
    $scope.dataList.then(function(mloLIsts){
        $scope.dataList = mloLIsts;
        $scope.mloList=$scope.dataList.mloList;
        $scope.slotList=$scope.dataList.slotList;
    });
    
    $scope.yearList = recievableService.getYearList();
    
    $scope.ssf ={
            slotId:'',
            mloShortName : '',
            year : new Date().getFullYear()
    }
    $scope.viewReport = function(){
        $scope.isShow = false;
        $scope.isRecordExsist = false;
        $scope.report=recievableService.viewReport($scope.ssf.slotId,$scope.ssf.mloShortName,$scope.ssf.year);
        $scope.report.then(function(data){
         if(data.length > 0 && data.length == 4){
                   $scope.report=data;
                   $scope.mlo[0] = ($scope.report[0]);
                   $scope.mlo[1] = ($scope.report[1]); 
                   $scope.slotssf[0] = ($scope.report[2]);
                   $scope.slotssf[1] = ($scope.report[3]);
           
                   $scope.isShow = true;
           }
           else {
                   $scope.isShow = false;
                   $scope.isRecordExsist = true;
           }
           });
    }
});