'use strict';

app.controller('thcReportCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {



    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;

    $scope.thcReport = {
    		fromDate :'',
    		toDate:''
			  
    };
    
   
    $scope.$watchCollection('[thcReport.fromDate,thcReport.toDate]',function(newValue, oldValue) {
		if (newValue.length>0) {
			var fromDate = $scope.thcReport.fromDate;
			var toDate = $scope.thcReport.toDate;
			fromDate = fromDate.split("/");
			fromDate = new Date(fromDate[2],fromDate[1] - 1, fromDate[0]);
			toDate = toDate.split("/");
			toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
			if (toDate < fromDate) {
				logger.logError("From Date should be lesser than To Date!");
				 $scope.thcReport.toDate = "";
			}
		}
	});

        

      //Search
	      $scope.viewDetail = function(){
	        	
	        	 $http.post($stateParams.tenantid+'/app/thcReport/searchList', $scope.thcReport).success(function(response) {
	           	console.log(response.searchList.length);

	                 if(response.searchList.length==0){
	                     logger.logError("No Records Found")
	                     $scope.rowCollection=[];
	                 
	                 }
	                 else
	                     {
	                     $scope.rowCollection=response.searchList;
	                     
	                     }
	             }); 
	          
	         }
	         

	      //Excel Export	
		  	 $scope.exportExcel = function(){
		  	   	 $http.post($stateParams.tenantid+'/app/thcReport/ExportExcel', $scope.thcReport).success(function(response) {

		  	                if(response){
		  	                    debugger;
		  	                    $("#thcReport").bind('click', function() {
		  	                    });
		  	                    $('#thcReport').simulateClick('click');
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


   

