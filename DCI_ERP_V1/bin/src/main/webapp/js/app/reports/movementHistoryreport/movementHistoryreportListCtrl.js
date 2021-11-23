'use strict';

app.controller('movementReportCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
		$filter, $rootScope, $http, $location, logger, $state, ngDialog,$controller,$injector) {
	 $scope.dummy = '';
	 $scope.dummy1 = '';
	 $scope.dummy2 = '';
	 $scope.dummy3 = '';


    $scope.dataLoopCount = 0;
    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.updatedData = [];
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 10;
    
    $scope.vesselList = [];
	$scope.voyageList = [];
	$scope.polList = [];
	$scope.podList = [];
	$scope.blList = [];
	$scope.containerList = [];
	$scope.containerTypeList =[];
	$scope.containerNoList =[];

    $scope. movementReport = {
			vessel : '',
			voyage : '',
			pol : '',
			pod : '',
			blNo : '',
			containerNo:'',
			containerType:'',
			containerTypeList:'',
			dateFrom:'',
			dateTo:'',
			onhireLocation:'',
			currentstatus:'',
				
				cnType:'',
	           impblNo:'',
              discdate:'',
                 fclOut:'',
           mtIn:'',
	          mtOut:'',
	          exportblNo:'',
	          discdate:'',
	          fcdDate:'',
	          rtcDate:'',
	 expIn:'',
	vesselex:'',
	 voyageex:'',
	 loaddate:'',
	podts:'',
	 fpod:'',
	 expbl:''
    }
    
    //Grid List
    $scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/movementReport/list',$scope.movementReport).success(function(datas) {
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();
        
        $scope.searchList =[];


        $http.post($stateParams.tenantid+'/app/commonUtility/getPort').success(function(data) {
   		 $scope.depotList = data.commonUtilityBean;
   });
     
        

      //Search
	      $scope.getSearch = function(){
	        	
	        	 $http.post($stateParams.tenantid+'/api/movementReport/searchonhireDtl', $scope.movementReport).success(function(response) {
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
	         
		  //Conatiner list
		   $http.post($stateParams.tenantid+'/api/report/containerNo').success(function(data) {
		      	
		  		$scope.containerNoList=data;
		  		        		
		  });
		   
		   // Conatier Type
		
		   $http.post($stateParams.tenantid+'/api/report/containerTypeDropDown').success(function(data) {
		      	
				 $scope.containerTypeList = data;
		 		        		
		 });

		   
		   
		    //Excel Export	
		  	 $scope.exportExcel = function(){
		  	   	 $http.post($stateParams.tenantid+'/api/movementReport/ExportExcel', $scope.movementReport).success(function(response) {

		  	                if(response){
		  	                    debugger;
		  	                    $("#movementExport").bind('click', function() {
		  	                    });
		  	                    $('#movementExport').simulateClick('click');
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
		  	  
		  	  
		 //pol

		    	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
						$scope.polList = data;
		    	  });
		 //pod
		    	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
						$scope.podList = data;
		    	  });
		
		    	  $scope.reset = function(containerReport) {
		    		  $scope. movementReport = {
		    					vessel : '',
		    					voyage : '',
		    					pol : '',
		    					pod : '',
		    					blNo : '',
		    					containerNo:'',
		    					containerType:'',
		    					containerTypeList:'',
		    					dateFrom:'',
		    					dateTo:'',
		    					onhireLocation:'',
		    					currentstatus:'',
		    						
		    						cnType:'',
		    			           impblNo:'',
		    		              discdate:'',
		    		                 fclOut:'',
		    		           mtIn:'',
		    			          mtOut:'',
		    			          exportblNo:'',
		    			          discdate:'',
		    			          fcdDate:'',
		    			          rtcDate:'',
		    			 expIn:'',
		    			vesselex:'',
		    			 voyageex:'',
		    			 loaddate:'',
		    			podts:'',
		    			 fpod:'',
		    			 expbl:''
		    		    };
	          	    	
	          	        $scope.getList();

	          	    }
    
});


   

