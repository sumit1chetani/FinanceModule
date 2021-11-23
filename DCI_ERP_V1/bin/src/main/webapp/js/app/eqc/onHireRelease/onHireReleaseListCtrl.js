'use strict';

app.controller('onHireReleaseListCtrl', function($scope, $rootScope, $http, $location, logger, utilsService, ngDialog, $state,sharedProperties,$window,$stateParams) {

    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    
    $scope.getList=function(){
        $http.get($stateParams.tenantid+'/api/onhireReleaseOrder/list').success(function(datas) {
            console.log(datas);
            $scope.rowCollection = datas;
        	
            }).error(function(datas) {
        });
        };
        $scope.getList();
        
    $scope.add = function() {
        $state.go('app.eqc.onHireRelease.add',{tenantid:$stateParams.tenantid});
    };
    
    $scope.editCro = function(aNo  ){
    	$location.url($stateParams.tenantid+'/trade/onHireRelease/add?aNo='+aNo);
    	}
 // Redirecting Page For Edit Functionality
    $scope.editRow = function(releaseRefno) {
    	debugger
        $location.url($stateParams.tenantid+'/trade/onHireRelease/edit?releaseRefno='+releaseRefno);
    };
    
    $scope.View = function(releaseRefno) {
        $location.url($stateParams.tenantid+'/trade/onHireRelease/view?releaseRefno='+releaseRefno);
    };
   
//    $scope.editRow = function(rowid) {   
//    	
//    	$location.url($stateParams.tenantid+'/master/containersize/edit?rowid='+rowid);    
//     }
//    
    $scope.deleteRow = function(releaseRefno) {
        ngDialog.openConfirm().then(function() {
        
            var url = $stateParams.tenantid+'/api/onhireReleaseOrder/delete?releaseRefno=' + releaseRefno;
            $http.get(url).success(function(result){
                if (result.isSuccess ==  true) {
                    logger.logSuccess("Deleted Successfully");
                    $state.reload();
               } else {
                    logger.logError("You Can't Delete this Record, Related Data Exist! ");
                }
            }).error(function(result) {
                logger.logError("Error Please Try Again");
            });
        }, function(reason) {
            console.log('Modal promise rejected. Reason: ', reason);
        });
    };
    
    //Excel Export	
  	 $scope.exportExcel = function(){
  		  var flag = false;
  	   	 $http.post($stateParams.tenantid+'/api/onhireReleaseOrder/ExportExcel').success(function(response) {

  	                if(response.success){
  	                    debugger;
  	                    $("#onHireExport").bind('click', function() {
  	                    	
  	                    });
  	                    $('#onHireExport').simulateClick('click');
  	                    logger.logSuccess("Exported successfully!");
  	                }else{
  	                    logger.logError("Failed to export");
  	                }
  	                
  	            }).error(function(response) {
  	                logger.logError("Error Please Try Again");
  	            });
//    	  }
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