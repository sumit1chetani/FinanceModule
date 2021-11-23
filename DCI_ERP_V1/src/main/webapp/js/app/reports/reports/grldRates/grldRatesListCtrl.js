'use strict';
app.controller('grldRatesListCtrl', function($scope,$stateParams, $rootScope, $http, $location, logger, $log, ngDialog, 
        $modal, utilsService, $window,$state,sharedProperties,$timeout) {

    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;

    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.emptyObject={};
    

    $scope.grldRateData={
    		
    		agent:'', 
    		orgin:'', 
            port:'',
            grldId:'',
           // portid:'',
            fromDate:'',
            toDate:'',  
            edit:true,           
            line:'',
            freightElement: '',
            serviceType:'',
            customer:'',
           // customerid :'', 
            containerType:'',
            stuffingStatus :'',
            currency :'',
            grldRateTableDetail:[]
              
    }
   
    
    $scope.add = function(){
        $state.go('app.reports.grldrates-add',{tenantid:$stateParams.tenantid});
    };
    
    $scope.getList = function() {
    	
    	 $http.post($stateParams.tenantid+'/api/grldrates/getGRLDList').success(function(data){
    		 console.log(data);
             $scope.rowCollection = data;  	 
    		 
    	    }).error(function(data){
    	        logger.logError("Error");
    	    });
    	 };

    $scope.getList();
    
    //Edit
    $scope.editedRow = function(grldId) { 
         $location.url($stateParams.tenantid+'/reports/grldrates/edit?grldId='+grldId);
   }  
    
    
 	$scope.deleteRow = function(grldId) {
		ngDialog.openConfirm().then(
				function() {
					$http
							.post(
									$stateParams.tenantid+ "/api/grldrates/delete",grldId).success(function(response) {
								if (response.success==true) {
									logger.logSuccess("Deleted Succesfully!");
							        $state.go('app.reports.grldrates.list');
								}
							}).error(function(response) {
								logger.logError("Error Please Try Again");
							});
				});
	};     
   
  

    
});