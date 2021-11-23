/**
 * 
 */'use strict';
app.controller('containercheckCtrl', function($templateCache,$timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService,$stateParams) {
   

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    $scope.vesselList = [];
 
 
 

    $scope.containerCheck = {
    		containerid:'',
    		 
    };
    
    //Search
    $scope.getSearchlist = function(){
      	
      	 $http.post($stateParams.tenantid+'/api/freedaysCheck/searchContainerCurrentStatus', $scope.containerCheck).success(function(response) {
         	console.log(response.searchList.length);

               if(response.searchList.length==0){
                   logger.logError("No Records Found")
                   $scope.rowCollection=[];
               
               }
               else
                   {
                   $scope.rowCollection=response.searchList;
                   
                   }
           }); 
        
       }
    $scope.getSearchlist();
   // $scope.getSearchlist();
	  //Conatiner list
	   $http.post($stateParams.tenantid+'/api/report/containerNo').success(function(data) {
	      	
	  		$scope.containerNoList=data;
	  		        		
	  });
    
	   

	    $scope.reset = function() {
	    	 $scope.containerCheck = {
	    	    		containerid:'',
	    	    		 
	    	    };
	    	 $scope.getSearchlist();
	    	 };

});

