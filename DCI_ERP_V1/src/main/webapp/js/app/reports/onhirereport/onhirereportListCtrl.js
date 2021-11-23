'use strict';

app.controller('onHirereportCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
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
		


    $scope. onhireReport = {
			vessel : '',
			voyage : '',
			pol : '',
			pod : '',
			blNo : '',
			containerNo:'',
			containerType:'',
			dateFrom:'',
			dateTo:'',
			onhireLocation:'',
			currentstatus:''
    }
    
    //Grid List
    $scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/onhireReport/list',$scope.onhireReport).success(function(datas) {
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();
        
        $scope.searchList =[];


  
        

      //Search
	      $scope.getSearch = function(){
	        	
	        	 $http.post($stateParams.tenantid+'/api/onhireReport/searchonhireDtl', $scope.onhireReport).success(function(response) {
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
		   
		   
		   $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
				   $scope.conTypeList=datas.getcontypelist;
				   
			
			}).error(function(datas) {

			});
		   
		   // Conatier Type
		
		 /*  $http.post($stateParams.tenantid+'/api/report/containerTypeDropDown').success(function(data) {
		      	
				 $scope.containerTypeList = data;
		 		        		
		 });*/

		   
		   
		    //Excel Export	
		  	 $scope.exportExcel = function(){
		  	   	 $http.post($stateParams.tenantid+'/api/onhireReport/ExportExcel', $scope.onhireReport).success(function(response) {

		  	                if(response){
		  	                    debugger;
		  	                    $("#onhireExport").bind('click', function() {
		  	                    });
		  	                    $('#onhireExport').simulateClick('click');
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
		    		   $scope. onhireReport = {
		    					vessel : '',
		    					voyage : '',
		    					pol : '',
		    					pod : '',
		    					blNo : '',
		    					containerNo:'',
		    					containerType:'',
		    					dateFrom:'',
		    					dateTo:'',
		    					onhireLocation:'',
		    					currentstatus:''
		    		    }
	          	    	
	          	        $scope.getList();
	      
	          	    }
    
});


   

