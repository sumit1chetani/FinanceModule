'use strict';
app.controller('emptyreportlistCtrl',function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	
	
	$scope.itemsByPage = 10;
	
	
	$scope.vesselList = [];
	$scope.voyageList = [];
	$scope.polList = [];
	$scope.podList = [];
	
	$scope.empty = {
			
			vessel : '',
			voyage : '',
			pol : '',
			pod : '',	
			fromDate: '',
			toDate: '',
			
		
	};
  //vessel
	
	$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
		$scope.vesselList = data;
	});
//port
	
	$http.get($stateParams.tenantid+ '/app/commonUtility/getPortList').success(function(data) {
		$scope.podList = data;
	});

	$http.get($stateParams.tenantid+ '/app/commonUtility/getPortList').success(function(data) {
		$scope.polList = data;
	});

	 $scope.$watch('empty.vessel', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
					$scope.voyageList = data;
	    	  });
	      }
	    });
	 
	 
	 
	 $('#fromDate').datetimepicker({
		 format : 'DD/MM/YYYY'
		 })
		 
   $('#toDate').datetimepicker({
		 format : 'DD/MM/YYYY'
		 })
		 

	 $scope.$watchCollection('[empty.fromDate,empty.toDate]',function(newValue, oldValue) {
		if (newValue.length>0) {
			var fromDate = $scope.empty.fromDate;
			var toDate = $scope.empty.toDate;
			fromDate = fromDate.split("/");
			fromDate = new Date(fromDate[2],fromDate[1] - 1, fromDate[0]);
			toDate = toDate.split("/");
			toDate = new Date(toDate[2], toDate[1] - 1, toDate[0]);
			if (toDate < fromDate) {
				logger.logError("From Date should be lesser than To Date!");
				 $scope.empty.toDate = "";
			}
		}
	});
		//view Detail 
		 
		  $scope.viewDetail = function(){
		            $http.post($stateParams.tenantid+'/api/empty/viewDetail', $scope.empty).success(function(data) {
		                if(data){
		                   
		                   if(data.success==true && data.emptyReportBean.length>0){
			                 logger.logSuccess("Details Fetched!");
		                	 $scope.rowCollection = data.emptyReportBean;
			                    detailList = data.emptyReportBean
			                    console.log($scope.rowCollection);

		                   }else{
			                	 logger.logError("Details Not Available");s
			                	 $scope.rowCollection= [];
			                	 
			                }
		                }
		                
		            });
		            
		        
			};

		 
				 
				 

			 
   
	 
	 $scope.excelexport = function() {
		 debugger
		 $http.post($stateParams.tenantid+'/api/empty/excelexport', $scope.empty).success(function(result) {
			// if(response){
                   debugger;
                   $("#emptyExport").bind('click', function() {
                   });
                   $('#emptyExport').simulateClick('click');
                   logger.logSuccess("Exported successfully!");
              /* }else{
                   logger.logError("Failed to export");
               }*/
	     }).error(function(result) {
	         console.log("data" + result);
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