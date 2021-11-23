'use strict';

app.controller('roundTripreportListCtrl', function($scope, $timeout, $stateParams,sharedProperties,toaster,
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
	
	$scope.blList = [];
	$scope.containerList = [];
	$scope.containerTypeList =[];
	$scope.containerNoList =[];

    $scope.roundTripReport = {
    		   slno : '',
    		   containerNo : '',
    		   containerType : '',
    		   cycle : '',
    		   onhPort : '',
    		   onhdate : '',
    		   rtsDate:'',
    		   elrDate:'',
    		   onbDate :'',
    		   onbVoyage: '',
    		   dischargePort : '',
    		   dischargeDate : '',
    		   ofdDate : '',
    		   erDate : '',
    		   emptyPort:'',
    		   totalDays:'',
    		   rounTrip :'',
    		   containerNum: '',
    		   fpod:'',
			   
			   
			  
    }
    
    //Grid List
    $scope.getList = function() {
        $http.post($stateParams.tenantid+'/api/roundTripNewReport/list',$scope.roundTripReport).success(function(datas) {
            $scope.rowCollection = datas;
            })
    };
        $scope.getList();
        
        $scope.searchList =[];
        $http.get($stateParams.tenantid+'/app/commonUtility/getPort').success(function(datas) {
            $scope.porthdrList =[];
            
            angular.forEach(datas.commonUtilityBean, function(bean, idx) {
                $scope.porthdrList.push(bean.id);
            });
            
            $timeout(function() {
                $('#pol_id').multiselect('deselectAll', false);
                $('#pol_id').multiselect('updateButtonText');
                $("#pol_id").multiselect('rebuild');
            
            }, 2, false);
                        
        }).error(function(data) {

        });

        $("#pol_id").multiselect({
            maxHeight: 200,   
            includeSelectAllOption: true,
            enableCaseInsensitiveFiltering: true,
            disableIfEmpty: true,
            onDropdownHide: function (event) {
                
            }
          });
  
        
        $scope.fpodList = [];
      //Search
	      $scope.getSearch = function(roundTripReport){
	    	/*  if($scope.fpod!=undefined){
	              $scope.roundTripReport.fpod =$scope.fpod.toString().split(",").join("','");
	           }*/
	        	 $http.post($stateParams.tenantid+'/api/roundTripNewReport/searchonhireDtl', $scope.roundTripReport).success(function(response) {
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
	    	  /*}else{
					logger.logError("Select Container Number...!");
				}*/
	         }
	         
	      $scope.check = false;
	      
	      //Search
	      $scope.getRefresh = function(){
	    	  $scope.check = true;
	        	 $http.post($stateParams.tenantid+'/api/roundTripNewReport/refreshTables', $scope.roundTripReport).success(function(response) {
	                 if(response.success = true){
	                	 $scope.rowCollection=response.searchList;
	                	 logger.logSuccess("Refreshed Successfully...!!!!!")
	                	 $scope.check = false;
	                 }
	                 else
	                     {
	                	 logger.logError("No Records Found");
	                	 $scope.check =false;
	                     
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

		   $scope.reset = function(roundTripReportForm) {
			   $scope.roundTripReport = {
		    		   slno : '',
		    		   containerNo : '',
		    		   containerType : '',
		    		   cycle : '',
		    		   onhPort : '',
		    		   onhdate : '',
		    		   rtsDate:'',
		    		   elrDate:'',
		    		   onbDate :'',
		    		   onbVoyage: '',
		    		   dischargePort : '',
		    		   dischargeDate : '',
		    		   ofdDate : '',
		    		   erDate : '',
		    		   emptyPort:'',
		    		   totalDays:'',
		    		   rounTrip :'',
		    		   containerNum: '',
		    		   fpod:'',
					   
					   
					  
		    };
			   $scope.fpodList = [];
      	    	
		        $scope.getList();

      	    }
		   
		    //Excel Export	
		  	 $scope.exportExcel = function(){
		  	   	 $http.post($stateParams.tenantid+'/api/roundTripNewReport/ExportExcel', $scope.roundTripReport).success(function(response) {

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


   

