'use strict';

app.controller('tdlListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
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

    $scope.tdlExport = {
    		shipmentTerm : '' ,
    		lineCode : '' ,
    		exVesselname : '' ,
    		agentVoyageno : '' ,
    		portCodeofDischarge : '' ,
    		eta : '' ,
    		exVesselrotationNo : '' ,
    		loadVesselname : '' ,
    		loadVesselrotationNo : '' ,
    		noOfinstallment : '' ,
    		stackUsage	: '' ,
    		mloLinecode	: '' ,
    		containerNo	: '' ,
    		checkDigit	: '' ,
    		isoCode	: '' ,
    		designation	: '' ,
    		sealNo : '' ,
    		originPort	: '' ,
    		loadPort : '' ,
    		pot	: '' ,
    		fpod : '' ,
    		totalWeighthundred : '' ,
    		imco : '' ,
    		uncode : '' ,
    		blNo : '' ,
    		shipperName	: '' ,
    		shipperAddress : '' ,
    		consigneeName : '' ,
    		consigneeAddress : '' ,
    		notify1Name	: '' ,
    		notifyAddress : '' ,
    		commodityDescription : '' ,
    		containerType : '' ,
    		cargoKg	: '' ,
    		remarks	: '' ,
    		fromDate :'',
    		toDate :''

    }
    
   /* //Grid List
    $scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/bookingReport/list',$scope.bookingReport).success(function(datas) {
        	var l=1;
        	for(var i=0;i<datas.length;i++){
        		
        		datas[i].slno=l;
        		l++;
        		
        	}
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();*/
        
        $scope.searchList =[];


  
        

      //Search
	      $scope.getSearch = function(){
	        	
	        	 $http.post($stateParams.tenantid+'/api/tdlExport/searchonhireDtl', $scope.tdlExport).success(function(response) {
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

		   $scope.reset = function(bookingReportForm) {
			   $scope.bookingReport = {
					   slno : '',
					   bookingNo : '',
					   issueDate : '',
					   customer : '',
					   pol : '',
					   fpod : '',
					   containertype20:'',
					   containertype40:'',
					   fromDate :'',
					   toDate: '',
						/*containerTypeList:'',
						dateFrom:'',
						dateTo:'',
						onhireLocation:'',
					    stocktype:'',*/
			    };
      	    	
		        $scope.getList();

      	    } 
		   
		    //Excel Export	
		   var count = 0;
		  	 $scope.exportExcel = function(){
		  		 
		  	//	if($scope.tdlExport.exVesselrotationNo!= undefined && $scope.tdlExport.exVesselrotationNo!=''){
		  			console.log('export')
		  	   	 $http.post($stateParams.tenantid+'/api/tdlExport/ExportExcel', $scope.tdlExport).success(function(response) {

		  	                if(response){
		  	                    debugger;
//		  	                  $timeout(function() {
		  	                    $("#tdlTS").bind('click', function() {
		  	                    });
		  	                $('#tdlTS').simulateClick('click');
		  	                
		  	                  
		  	                    
		  	                	$("#tdlImport").bind('click', function() {
		  	                    });
		  	                    $('#tdlImport').simulateClick('click');
		  	               
		  	          
		  	                    
		  	                  $("#tdlExport").bind('click', function() {
		  	                    });
		  	                    $('#tdlExport').simulateClick('click');
		  	                    
//		  	                  },30);
		  	              
		  	        	
		  	                  
		  	                    logger.logSuccess("Exported successfully!");
		  	                }else{
		  	                    logger.logError("Failed to export");
		  	                }
		  	                
		  	            }).error(function(response) {
		  	                logger.logError("Error Please Try Again");
		  	            });
		  		
		  	 		/*}else{
			        	logger.logError("Enter Rotation Number..!");
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
		  
		  	 
		  	  
		  	  
		  	  
		 //pol

		    	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
						$scope.polList = data;
		    	  });
		 //pod
		    	  $http.post($stateParams.tenantid+ '/api/containerBank/GetPortByVoyage').success(function(data) {
						$scope.podList = data;
		    	  });
		
        //customerlist
		    	  
		    	  $http.get($stateParams.tenantid+'/app/quotationsummary/customerlist').success(function(datas) {
		              $scope.customerList = datas;
		    	  });
    
});


   

