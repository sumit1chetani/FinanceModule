'use strict';
app.controller('truckdriverListCtrl', function($scope, ngDialog,$rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
    
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
	    $scope.add = function() {
	        $state.go('app.truck.truckdriver.add',{tenantid:$stateParams.tenantid});
	    };
	    $scope.getList=function(){
	        $http.get($stateParams.tenantid+'/truckdrivermapping/list').success(function(datas) {
	            console.log(datas);
	            $scope.rowCollection = datas.list;
	        	
	            }).error(function(datas) {
	        });
	        };   
	       
	        $scope.truckdrivermodel = {
	                
	                truckId:'',
	                driverId:'',
	                driverName:'',
	   

	                  fromDate:'',
	                  toDate:'',
	              
	                truckdriverId:''
	                
	                	
	             };
	          $scope.deleteRow = function(rowid) {
	            	
	                ngDialog.openConfirm().then(function() {
	                    var myURL = $stateParams.tenantid+'/truckdrivermapping/delete';
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
	            	debugger
	            	$http.get($stateParams.tenantid+'/truckdrivermapping/checkEdit?driverMappingId='+rowid).success(function(datas) {
	            		$location.url($stateParams.tenantid+'/truckdriver/edit?rowid='+rowid);

	            	/*	if(!datas){
	            		$location.url($stateParams.tenantid+'/truckdriver/edit?rowid='+rowid);
	            		}
	            		else{
	                        logger.logError("Not Allowed to Edit ,Trip Started!");
	            		}*/
	    	            })
	            	
	            	
	            	
	             }
	            
	            $scope.view = function(rowid) {
	            	$location.url($stateParams.tenantid+'/truckdriver/view?rowid='+rowid); 
	             }
	                  

	       
});