'use strict';

app.controller('inventoryglanceListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
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
    
    
	
    $scope.onhireReport = {
    		
    		containerType:'',
    		leaseType:'',
    		depot:''
	
    }
    
    $scope.leaseTypelist = [{
		id : 'LL',
		text : 'LL - Long Term Lease'
	},{
		id : 'SL',
		text : 'SL - Short Term Lease'
	}];
    
    
    $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
		   $scope.conTypeList=datas.getcontypelist;
		   
	
	}).error(function(datas) {

	});
    
    
    $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
		$scope.portList = data;
  });
    
    
    
    $scope. stocksummary = {
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
			fcd20:'',
			fcd40:'',
			rtc20:'',
			rtc40:'',
			mtr20:'',
			mtr40:'',
			mts20:'',
			mts40:'',
			rfs20:'',
			rfs40:''

    }
    
    
    
    //Grid List
    $scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/inventoryGlance/listpage',$scope.stocksummary).success(function(datas) {
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();
        
        $scope.searchList =[];


  
        

      //Search
	      $scope.getSearch = function(){
	        	
	        	 $http.post($stateParams.tenantid+'/api/inventoryGlance/searchDtl', $scope.stocksummary).success(function(response) {
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
		  	   	 $http.post($stateParams.tenantid+'/api/inventoryGlance/ExportExcel', $scope.stocksummary).success(function(response) {

		  	                if(response){
		  	                    debugger;
		  	                    $("#stocksummary").bind('click', function() {
		  	                    });
		  	                    $('#stocksummary').simulateClick('click');
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
    
   /* //Grid List
    $scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/inventoryglance/list',$scope.inventoryGlance).success(function(datas) {
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();
        
        $scope.searchList =[];

        $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
  		  $scope.customerList=datas.getcustomerlist;
  		  $scope.conTypeList=datas.getcontypelist;
  		   $scope.depotList=datas.getportlist;
  		  $scope.depotList=datas.polList;
  		   $scope.conNoList=datas.getcontainer;
  		   $scope.quotation.gateOutNo1=datas.maxGateOutNo;
  		}).error(function(datas) {

  		});

  
        

      //Search
	      $scope.getSearch = function(){
	        	
	        	 $http.post($stateParams.tenantid+'/api/onhireReport/searchonhireDtl', $scope.inventoryGlance).success(function(response) {
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
	         
		   
		   // Conatier Type
		
		   $http.post($stateParams.tenantid+'/api/report/containerTypeDropDown').success(function(data) {
		      	
				 $scope.containerTypeList = data;
		 		        		
		 });

		   
		   
		    //Excel Export	
		  	 $scope.exportExcel = function(){
		  	   	 $http.post($stateParams.tenantid+'/api/inventoryGlance/ExportExcel', $scope.onhireReport).success(function(response) {

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
		  	 $scope.reset = function(onhireReport) {
		  		  $scope.onhireReport = {
		  	    		
		  	    		containerType:'',
		  	    		leaseType:'',
		  	    		depot:''
		  		
		  	    }
		  		  $scope.leaseTypelist =[];

        	    }*/

	});


   

