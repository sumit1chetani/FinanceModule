'use strict';
app.controller('guidelinevaluesListCtrl', function($scope, ngDialog,$rootScope, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
    
	 $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
	 /*   $scope.add = function() {
	        $state.go('truckdriver.add',{tenantid:$stateParams.tenantid});
	    };
	    $scope.getList=function(){
	        $http.get($stateParams.tenantid+'/truckdrivermapping/list').success(function(datas) {
	            console.log(datas);
	            $scope.displayedCollection = datas.list;
	        	
	            }).error(function(datas) {
	        });
	        }; */  
	       
	        $scope.guidelinevalues = {
	           

		locationId : '',
		locationName : '',
		fromLocation : '',
		toLocation : '',
		breakevenRate : '',
		breakevenMielage : '',
		breakevenNoOfDays : '',
	                	
	             };
	        $scope.add = function() {
	       	 $state.go('app.master.guidelinevaluesAdd');
	       };
	    
	        
		        $scope.getList=function(){
			        $http.get($stateParams.tenantid+'/guidelinevalues/list').success(function(datas) {
		                console.log(datas);
		                $scope.rowCollection = datas.list;
		            	
		                }).error(function(datas) {
		            });
		            };
		            $scope.getList();
		           /* $scope.editRow = function(rowid) {    
		      		  
		            	$location.url($stateParams.tenantid+'/schedule/add?rowid='+rowid.scheduleId);       
		             }*/
	   
		            $scope.editRow = function(rowid){
		            	$location.url($stateParams.tenantid+'/guidelinevalues/add?rowid=' + rowid.guidelinevaluesId);
		            }
	    	
		            
		            
		            
		            $scope.deleteRow = function(rowid) {
		            	
		                ngDialog.openConfirm().then(function() {
		                    var myURL = $stateParams.tenantid+'/guidelinevalues/delete';
		                    $http({
		                        method : 'post',
		                        url : myURL,
		                        data : rowid.guidelinevaluesId,
		                    }).success(function(data) {
		                        if (data == true) {                    
		                            logger.logSuccess("Deleted Successfully");
		                            $state.reload();
		                        } else {
		                            logger.logError("Error in deleting Record!");
		                        }
		                    }).error(function(data) {
		                        logger.logSuccess("Error in Delete!");ss
		                    });
		                });

		            };       
		            
		            
		            
		        /*    $scope.view = function(rowid) {
		            	$location.url($stateParams.tenantid+'/guidelinevalues/view?rowid='+rowid); 
		             }
		                 
		            */
		            
		            
		            $scope.view = function(rowid){
		            	$location.url($stateParams.tenantid+'/guidelinevalues/view?viewId=' + rowid.guidelinevaluesId);
		            }
		                   
		            
		            
		            
		            
	        
	                  

	       
});