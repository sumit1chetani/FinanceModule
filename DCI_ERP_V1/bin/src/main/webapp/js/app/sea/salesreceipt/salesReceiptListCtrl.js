'use strict';

app.controller('salesreceiptListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
	    $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
	   
    $scope.add = function() {
    	 $state.go('app.sea.salesreceipt.add',{tenantid:$stateParams.tenantid});
    };
    $scope.getList=function(){
    $http.post($stateParams.tenantid+'/app/sea/salesreceipt/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas.lHblBean;
    	
        }).error(function(datas) {
    });
    };
    $scope.getList();
    
      $scope.deleteRow = function(rowid) {
        	
            ngDialog.openConfirm().then(function() {
                var myURL = $stateParams.tenantid+'/app/sea/salesreceipt/delete?servicePartnerId='+rowid;
                $http({
                    method : 'post',
                    url : myURL,
                    data : rowid,
                }).success(function(data) {
                    if (data.success == true) {                    
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
    	$location.url($stateParams.tenantid+'/salesreceipt/edit?rowid='+rowid);       
     }
    
    $scope.view = function(rowid) {
    	$location.url($stateParams.tenantid+'/salesreceipt/view?rowid='+rowid); 
     }
    
   
   


    
   
            
   
});


