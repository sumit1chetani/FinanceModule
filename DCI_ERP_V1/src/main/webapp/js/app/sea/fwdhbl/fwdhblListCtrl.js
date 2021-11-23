'use strict';

app.controller('fwdhblListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
        utilsService,$state,sharedProperties,$window,validationService,toaster,$stateParams) {
	    $scope.dataLoopCount = 0;
	    $scope.offsetCount = 0;
	    $scope.limitCount = 1000;
	    $scope.updatedData = [];
	    $scope.rowCollection = [];
	    $scope.displayedCollection = [];
	    $scope.itemsByPage = 10;
	   
	    $('.rounded').val($rootScope.hblListCtrl);
    $scope.add = function() {
    	$rootScope.hblListCtrl=$('.rounded').val();
    	 $state.go('app.sea.fwdhbl.add',{tenantid:$stateParams.tenantid});
    };
    $scope.getList=function(){
    $http.post($stateParams.tenantid+'/app/master/fwdhbl/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas.lHblBean;
    	
        }).error(function(datas) {
    });
    };
    $scope.getList();
    
      $scope.deleteRow = function(rowid) {
        	
            ngDialog.openConfirm().then(function() {
                var myURL = $stateParams.tenantid+'/app/master/fwdhbl/delete?hblId='+rowid;
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
    	$rootScope.hblListCtrl=$('.rounded').val();
    	$location.url($stateParams.tenantid+'/fwdhbl/edit?rowid='+rowid);       
     }
    
    $scope.viewRow = function(rowid) {
    	$rootScope.hblListCtrl=$('.rounded').val();
    	$location.url($stateParams.tenantid+'/fwdhbl/view?rowid='+rowid); 
     }
    
    var quickLinkIdList = $location.search().quickLinkIdList;
    $scope.newQukLinkList=[];
    $scope.qlt=[];
    if(quickLinkIdList!='' && quickLinkIdList != undefined){
    	 $scope.qlt=quickLinkIdList.split(',');
        $http.post($stateParams.tenantid+'/app/master/fwdhbl/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas.lHblBean;
            if($scope.rowCollection !=null && $scope.rowCollection.length>0 ){
            	angular.forEach($scope.rowCollection, function(value, key) {
            		angular.forEach($scope.qlt, function(value1, key1) {
                		if(value.hblNo==value1){
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


