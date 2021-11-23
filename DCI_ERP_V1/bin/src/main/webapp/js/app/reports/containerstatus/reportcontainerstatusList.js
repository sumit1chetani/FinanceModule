'use strict';
app.controller('containerstatusList', function($templateCache,$timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService,$stateParams) {


    $scope.containerReport = {
    		
            containerNo : '',
            containerStatus : '',
            containerId:'',
            containerType:'',
            statusDate:'',
            status:'',
            statusDef:'',
            depot:''
        };
    $scope.formreset = function() {
        $scope.inwardmanifestReport = {};
    };

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.depotList=[];
    
    
    
    
  
    $http.post($stateParams.tenantid+'/api/report/containerNo').success(function(data) {
	      	
  		$scope.containerNoList=data;
  		        		
  });
    
    $http.post($stateParams.tenantid+'/api/report/containerStatusDropDown').success(function(data) {
      	
		 $scope.containerstatusList = data;
  		        		
  });
    
    $http.post($stateParams.tenantid+'/api/report/containerTypeDropDown').success(function(data) {
      	
		 $scope.containerTypeList = data;
 		        		
 });
    
    
    $http.post($stateParams.tenantid+'/app/commonUtility/getPort').success(function(data) {
		 $scope.depotList = data.commonUtilityBean;
});
    
    $scope.getList = function() {
    $http.post($stateParams.tenantid+'/api/report/list').success(function(data) {
      	
		 $scope.rowCollection = data;
 		        		
 });
    };
    $scope.getList();
	        

		
    $scope.getSearch = function() {
    	 
    	   $http.post($stateParams.tenantid+'/api/report/getListData',$scope.containerReport).success(function(data) {
               console.log("data" + data);
           		 $scope.rowCollection = data;
              
           }).error(function(result) {
               console.log("data" + data);
           });
    	   
     
        
        
    };
    $scope.reset = function(containerReport) {
    
    	$scope.containerReport = {
        		
                containerNo : '',
                containerStatus : '',
                containerId:'',
                containerType:'',
                statusDate:'',
                status:'',
                depot:''
                
            };
    	
        $scope.getList();

    }

        });




