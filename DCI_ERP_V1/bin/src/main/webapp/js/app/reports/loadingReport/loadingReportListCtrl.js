'use strict';

app.controller('loadingReportCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
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

    $scope.loadingReportBean = {
    		year:'2019'
			  
    }
    
   

    
    $scope.yearList = [{
		id:'2019',
		text:'2019'
	},{
		id:'2020',
		text:'2020'
	}
	,{
		id:'2021',
		text:'2021'
	}
	,{
		id:'2022',
		text:'2022'
	}
	,{
		id:'2023',
		text:'2023'
	}
	,{
		id:'2024',
		text:'2024'
	}
	,{
		id:'2025',
		text:'2025'
	}];
    //Grid List
    $scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/blissuedreport/doList',$scope.loadingReport).success(function(datas) {
        	
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();
        
        $scope.searchList =[];


  
        

      //Search
	      $scope.getSearch = function(){
	        	
	        	 $http.post($stateParams.tenantid+'/api/blissuedreport/SearchDOList', $scope.loadingReport).success(function(response) {
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
	         


		   
		   //pol

	    	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
					$scope.polList = data;
	    	  });


		   $scope.reset = function(blissuedreportForm) {
			   $scope.loadingReport = {
			    		port:''
			    }
      	    	
		        $scope.getList();

      	    }
		   
		    //Excel Export	by Monthly
		  	 $scope.exportExcel = function(){
		  	   	 $http.post($stateParams.tenantid+'/app/laodingReports/ExportExcel', $scope.loadingReportBean).success(function(response) {

		  	                if(response){
		  	                    debugger;
		  	                    $("#DOReport").bind('click', function() {
		  	                    });
		  	                    $('#DOReport').simulateClick('click');
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
		  	  
		  	  
		  	//Excel Export by Weekly	
			  	 $scope.exportExcel2 = function(){
			  	   	 $http.post($stateParams.tenantid+'/app/laodingReports/ExportExcelByWeekly', $scope.loadingReportBean).success(function(response) {

			  	                if(response){
			  	                    debugger;
			  	                    $("#weekReport").bind('click', function() {
			  	                    });
			  	                    $('#weekReport').simulateClick('click');
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


   

