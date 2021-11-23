'use strict';

app.controller('hblListCtrl', function($scope, $rootScope,ngDialog, $http, $location, logger,
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
    	 $state.go('app.sea.hbl.add',{tenantid:$stateParams.tenantid});
    };
    $scope.getList=function(){
    $http.post($stateParams.tenantid+'/app/master/hbl/list').success(function(datas) {
        console.log(datas);
        $scope.rowCollection = datas.lHblBean;
    	
        }).error(function(datas) {
    });
    };
    $scope.getList();
    
      $scope.deleteRow = function(rowid) {
        	
            ngDialog.openConfirm().then(function() {
                var myURL = $stateParams.tenantid+'/app/master/hbl/delete?hblId='+rowid;
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
    	$location.url($stateParams.tenantid+'/hbl/edit?rowid='+rowid);       
     }
    
    $scope.viewRow = function(rowid) {
    	$rootScope.hblListCtrl=$('.rounded').val();
    	$location.url($stateParams.tenantid+'/hbl/view?rowid='+rowid); 
     }
    
    var quickLinkIdList = $location.search().quickLinkIdList;
    $scope.newQukLinkList=[];
    $scope.qlt=[];
    if(quickLinkIdList!='' && quickLinkIdList != undefined){
    	 $scope.qlt=quickLinkIdList.split(',');
        $http.post($stateParams.tenantid+'/app/master/hbl/list').success(function(datas) {
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
    
    
  //Excel Export	
	 $scope.exportExcel = function(){
		 
		/*if($scope.bookingReport.salesPersonId!='' && $scope.bookingReport.salesPersonId!=null){*/
	   	 $http.post($stateParams.tenantid+'/app/master/hbl/ExportExcel', $scope.bookingReport).success(function(response) {

	                if(response){
	                    debugger;
	                    $("#bookingreport").bind('click', function() {
	                    });
	                    $('#bookingreport').simulateClick('click');
	                    logger.logSuccess("Exported successfully!");
	                }else{
	                    logger.logError("Failed to export");
	                }
	                
	            }).error(function(response) {
	                logger.logError("Error Please Try Again");
	            });
		/*}else{
		  logger.logError("Pls select Sales Person");
	  }*/
	    
	    }
	    
	
	  $.fn.simulateClick = function() {
	        return this.each(function() {
	            if ('createEvent' in document) {
	                var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
	                evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
	                this.dispatchEvent(evt);
	            } else {
	                this.click(); // IE
	            }
	        });
	    }
    
    
            
   
});


