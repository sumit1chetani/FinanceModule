'use strict';
app.controller('trucktrailerListCtrl', function($scope, ngDialog,$rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
    
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
	    $scope.add = function() {
	        $state.go('app.truck.trucktrailer.add',{tenantid:$stateParams.tenantid});
	    };
	    $scope.getList=function(){
	        $http.get($stateParams.tenantid+'/trucktrailermapping/list').success(function(datas) {
	            console.log(datas);
	            $scope.rowCollection = datas.list;
	        	
	            }).error(function(datas) {
	        });
	        };   
	       
	        $scope.trucktrailermodel = {
	                
	                truckId:'',
	                trailerId:'',
	                truckName:'',
	                trailerName:'',
	              
	                  fromDate:'',
	                  toDate:'',
	              
	                trucktrailerId:''
	                
	                	
	             };
	          $scope.deleteRow = function(rowid) {
	            	
	                ngDialog.openConfirm().then(function() {
	                    var myURL = $stateParams.tenantid+'/trucktrailermapping/delete';
	                    $http({
	                        method : 'post',
	                        url : myURL,
	                        data : rowid,
	                    }).success(function(data) {
	                        if (data == true) {                    
	                            logger.logSuccess("Deleted Successfully");
	                            $state.reload();
	                        } else {
	                            logger.logError("Error in deleting Record!");
	                        }
	                    }).error(function(data) {
	                        logger.logSuccess("Error in Delete!");
	                    });
	                });

	            };
	         
	            $scope.getList();
	            $scope.editRow = function(rowid) {    	
	            	$location.url($stateParams.tenantid+'/trucktrailer/edit?rowid='+rowid);       
	             }
	            
	            $scope.view = function(rowid) {
	            	$location.url($stateParams.tenantid+'/trucktrailer/view?rowid='+rowid); 
	             }
	                  

	       
});