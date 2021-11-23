'use strict';

app.controller('deliveryorderListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $('.rounded').val($rootScope.deliveryorderListCtrl);
    $scope.add = function() {
    	$rootScope.deliveryorderListCtrl=$('.rounded').val();
        $state.go('app.sea.deliveryorder.add');
    };
    
    
    $http.get($stateParams.tenantid+'/app/sea/deliveryOrder/list').success(function(datas) {
        $scope.rowCollection = datas.lHblBean;
    	
        }).error(function(datas) {
    });
   
    
    $scope.editRow = function(rowid) {   
    	$rootScope.deliveryorderListCtrl=$('.rounded').val();
    	$location.url($stateParams.tenantid+'/deliveryorder/edit?rowid='+rowid);    
     }
    
$scope.deleteRow = function(rowid) {
    	
        ngDialog.openConfirm().then(function() {
            var myURL = $stateParams.tenantid+'/app/sea/deliveryOrder/delete?hblId='+rowid;
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
    
    $scope.viewRow = function(rowid) {
    	$rootScope.deliveryorderListCtrl=$('.rounded').val();
    	$location.url($stateParams.tenantid+'/deliveryorder/view?rowid='+rowid); 
     }
    
    
    var quickLinkIdList = $location.search().quickLinkIdList;
    $scope.newQukLinkList=[];
    $scope.qlt=[];
    if(quickLinkIdList!='' && quickLinkIdList != undefined){
    	 $scope.qlt=quickLinkIdList.split(',');
    	 $http.get($stateParams.tenantid+'/app/sea/deliveryOrder/list').success(function(datas) {
    	        $scope.rowCollection = datas.lHblBean;
            if($scope.rowCollection !=null && $scope.rowCollection.length>0 ){
            	angular.forEach($scope.rowCollection, function(value, key) {
            		
            		angular.forEach($scope.qlt, function(value1, key1) {
                		if(value.doId==value1){
                			$scope.newQukLinkList.push(value);
                		}
                		
                	})
            	})
            	$scope.rowCollection=[];
            	$scope.rowCollection=$scope.newQukLinkList;
            }
        	
            }).error(function(datas) {
        });
        
     }
    
    
    
});