/**
 * 
 */
/**
 * 
 */
'use strict';
app.controller('containerHistoryListCtrl', function($templateCache,$timeout, $scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $sce, $filter,utilsService,$stateParams) {
    $scope.container = {
    		containerNo:'',
    		containerType:'',
    		fromDate:'',
    		toDate:''
       
    };
    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
 

    $scope.container = {
        containerNo : '',
        payload : '',

        pickupDate : '',
        partyName : '',
        serviceType: ''
    };
   

    $scope.getDropdownvalue = function() {
        
        $http.get($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
  		  $scope.conTypeList=datas.getcontypelist;
		   $scope.conNoList=datas.getcontainer;

        }).error(function(datas) {
        });

    }
    $scope.getDropdownvalue();
  

    $scope.getSearchList = function(){

		        	 $http.post($stateParams.tenantid+'/app/containerhistory/list', $scope.container).success(function(response) {
		              	
		              	console.log(response.searchList.length);
		              	if(response.searchList.length == 0){
		              		 logger.logError("No Records has been found");
		              		$scope.rowCollection=[];
		              	}else{
		              		 $scope.rowCollection = response.searchList;
		              	}
		              	
                
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        
        
 
 };
   

    
    //Excel Export	
	 $scope.exportExcel = function(){

	            $http.post($stateParams.tenantid+'/app/containerhistory/ExportExcel', $scope.container).success(function(response) {
	                if(response){
	                    debugger;
	                    $("#containerExport").bind('click', function() {
	                    });
	                    $('#containerExport').simulateClick('click');
	                    logger.logSuccess("Exported successfully!");
	                }else{
	                    logger.logError("Failed to export");
	                }
	                
	            }).error(function(response) {
	                logger.logError("Error Please Try Again");
	            });
	    
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

