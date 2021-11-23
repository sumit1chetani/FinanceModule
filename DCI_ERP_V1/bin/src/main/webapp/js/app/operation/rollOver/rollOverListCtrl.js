'use strict';
app.controller('rollOverListCtrl', function($scope, $timeout,
		$stateParams, sharedProperties, toaster, $filter, $rootScope, $http,
		$location, logger, $state, ngDialog, $controller, $injector,validationService) {
	$scope.quotationTypeList = [];
	$scope.customerDropList = [];
	$scope.consigneeDropList = [];
	$scope.shipmentList = [];
	$scope.nominatedDropList = [];
	$scope.vendorDropList = [];
	$scope.serviceParnrDropList = [];
	$scope.portList = [];
	$scope.portlist = [];
	$scope.currencyList = [];
	$scope.vesselList = [];
	$scope.voyageList = [];
	$scope.createQuote = false;
	$scope.fromVoyageShipmentCheck = false;
	$scope.toVoyageShipmentCheck = false;

	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId = parseInt($stateParams.bookingId);

	

	
	   $scope.shiftBookingSearchData = {
			voyageId:'',
			vesselCode:'',
			pol:'',
			pod:'',
			vesselCodeTo:'',
			voyageIdTo:'',
			polTo:'',
			podTo:'',
		    fpodTo:'',
   		    fpod:'',
   		    portgateinDate: null,
   		    cutoffDate: null
   		 
	    };

 
  
	
	// VESSEL LIST
	$http.get($stateParams.tenantid+ '/api/vesselArrival/getVesselList').success(function(data) {
		$scope.vesselList = data;
	});



	 //Vessel based voyage
	 $scope.$watch('shiftBookingSearchData.vesselCode', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
	    		  $scope.voyageList = data;
	    		   
	    	  });
	      }
	    });
	 
	 
	//Vessel based voyageTo 
	 $scope.$watch('shiftBookingSearchData.vesselCodeTo', function(newValue, oldValue) {
	      if(newValue!=null && newValue!=undefined && newValue != ''){
	    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
	    		  $scope.voyageListTo = data;
	    		   
	    	  });
	      }
	    });
	 

		 
	// From Voyage based Ports
		$scope.$watch('shiftBookingSearchData.voyageId',function(newValue, oldValue) {
			if(newValue!=null && newValue!=undefined && newValue!=""){
			    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
							$scope.polList = data;
				    		  
			    	  });
			    	  
			    	 /* $http.post($stateParams.tenantid+ '/api/shiftBooking/getPortListByVoyage',newValue).success(function(data) {
							$scope.podListFromBook = data;
				    		  
			    	  });*/
			}
		});

	 

		// To Voyage based ports
		$scope.$watch('shiftBookingSearchData.voyageIdTo',function(newValue, oldValue) {
			if(newValue!=null && newValue!=undefined && newValue!=""){
		     
			   $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
							$scope.polListTo = data;
			    		  
			   });
			    	  
			   /* $http.post($stateParams.tenantid+ '/api/shiftBooking/getPortListByVoyage',newValue).success(function(data) {
							$scope.podListToBook = data;
			     });*/
			}
		});


		 $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
			  $scope.fpodList=datas.getportlist;
		}).error(function(datas) {

		});
 	        
	        /*$http.get($stateParams.tenantid+'/app/portactivity/portlist').success(function(datas) {
	            $scope.fpodList = datas;
	        }).error(function(datas) {
	        });*/


	        $scope.$watchCollection('[shiftBookingSearchData.voyageId,shiftBookingSearchData.pol]', function(newValue, oldValue) {
				 if($scope.shiftBookingSearchData.voyageId != null && $scope.shiftBookingSearchData.voyageId != '' && $scope.shiftBookingSearchData.voyageId != undefined 
					        && $scope.shiftBookingSearchData.pol != null && $scope.shiftBookingSearchData.pol != '' && $scope.shiftBookingSearchData.pol != undefined){ 
					 $http.post($stateParams.tenantid+'/api/shiftBooking/searchonshiftDtl', $scope.shiftBookingSearchData).success(function(response) {
				           	if(response.searchList.length==0){
				           	} else {
				                  $scope.rowCollection=response.searchList;
				                     
				            }
				             }); 
					 $http.post($stateParams.tenantid+ '/api/shiftBooking/getShipmentStatus?vessel='+$scope.shiftBookingSearchData.vesselCode+'&voyage='+$scope.shiftBookingSearchData.voyageId+'&pol='+$scope.shiftBookingSearchData.pol).success(function(data) {
						 $scope.fromVoyageShipmentCheck = data;
						 if (data) {
				    		  logger.logError("Vessel sailed for the mentioned From Voyage and From POL!");
						 }
			    	  });
					 
				 }
			 });
	        
	        $scope.$watchCollection('[shiftBookingSearchData.voyageIdTo,shiftBookingSearchData.polTo]', function(newValue, oldValue) {
				 if($scope.shiftBookingSearchData.voyageIdTo != null && $scope.shiftBookingSearchData.voyageIdTo != '' && $scope.shiftBookingSearchData.voyageIdTo != undefined 
					        && $scope.shiftBookingSearchData.polTo != null && $scope.shiftBookingSearchData.polTo != '' && $scope.shiftBookingSearchData.polTo != undefined){
					 $http.post($stateParams.tenantid+ '/app/booking/getSailing?voyage='+$scope.shiftBookingSearchData.voyageIdTo+'&pol='+$scope.shiftBookingSearchData.polTo).success(function(data) {
						 $scope.shiftBookingSearchData.etasailDate	 = data.etasailDate;
						 $scope.shiftBookingSearchData.etdsailDate	 = data.etdsailDate;
						 $scope.shiftBookingSearchData.cutoffDate	 = data.cutoffDate;
						
			    	  });
					 $http.post($stateParams.tenantid+ '/api/shiftBooking/getShipmentStatus?vessel='+$scope.shiftBookingSearchData.vesselCodeTo+'&voyage='+$scope.shiftBookingSearchData.voyageIdTo+'&pol='+$scope.shiftBookingSearchData.polTo).success(function(data) {
						 $scope.toVoyageShipmentCheck = data;
						 if (data) {
				    		  logger.logError("Vessel sailed for the mentioned To Voyage and To POL!");
						 }
			    	  });
					 
				 }
			 });
	    
	  
	
  
                //+++++++++++++++++++++++++++++++++++++++++++++++++++===================================//

	    //Grid List
	    $scope.getList = function() {
	        $http.post($stateParams.tenantid+'/api/shiftBooking/list',$scope.shiftBookingSearchData).success(function(datas) {
	            $scope.rowCollection = datas;
	            })
	    };
	    $scope.getList();
		
	        
	        
	        $scope.searchList =[];
	        $scope.rowCollection=[];
	        
	      //Search
		      $scope.getSearchList = function(){

		    	  if( $scope.shiftBookingSearchData.vesselCode !='' ){
			    	  if($scope.shiftBookingSearchData.voyageId !='' ){
				    	  if($scope.shiftBookingSearchData.pol !='' ){
					    	  if($scope.shiftBookingSearchData.pod !='' ){
					    		 
		        	 $http.post($stateParams.tenantid+'/api/shiftBooking/searchonshiftDtl', $scope.shiftBookingSearchData).success(function(response) {
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
			    	  
					   }else{
			    		  logger.logError("Please select From POD..!");
			    	  }
				    	  
			    	  }else{
			    		  logger.logError("Please select From POL..!");
			    	  }
				    	  
			    	  }else{
			    		  logger.logError("Please select From Voyage..!");
			    	  }
		       	  
		    	     }else{
		    		  logger.logError("Please select From Vessel..!");
		    	     }
		          
		         }
		      
		      //reset
		      
		      $scope.reset = function() {

		   	   $scope.shiftBookingSearchData = {
		   			voyageId:'',
		   			vesselCode:'',
		   			pol:'',
		   			pod:'',
		   			vesselCodeTo:'',
		   			voyageIdTo:'',
		   			polTo:'',
		   			podTo:'',
		   		    fpodTo:'',
		   		    fpod:'',
		   		    portgateinDate: null,
		    		cutoffDate: null
		    			
		   	    };		
		   	$scope.getList();
		   	   };
		   	    
		   	    //Check box multiselect
		   	   $scope.multiSelect = function(obj) {

		           angular.forEach(obj, function(row, index) {
		               if (row.select) {
		                   row.select = false;
		               } else {
		                   row.select = true;
		               }
		           });

		       };

		      //roll over submit
		      
		      $scope.dotShiftBooking = function(objHdr, row,sailingsReportForm) {
		          var shiftBookingDtl = $filter('filter')($scope.rowCollection, { select:  true });
		          
		          if(shiftBookingDtl.length >0){
		        	 
			    		  if (new validationService()
							.checkFormValidity(sailingsReportForm)) {	

			    		  	  $scope.rolloverList=[];
					          var shiftBookingDtl = $filter('filter')($scope.rowCollection, { select:  true });
					          console.log("shiftBookingDtl**********8");
					          $scope.rolloverList=shiftBookingDtl;
					         
					          $scope.check=false;
					          $scope.pendingcheck=false;
					          $scope.completecheck=false;
					     

				        	  
			        		  var pod =$scope.shiftBookingSearchData.pod.split("-");
			        		  var podTo =$scope.shiftBookingSearchData.podTo.split("-");
			        		  var fpod =$scope.shiftBookingSearchData.fpod.split("-");
			        		  var fpodTo =$scope.shiftBookingSearchData.fpodTo.split("-");

				        		 
				        		  
				        		  if(pod[0] == podTo [0] && fpod [0] ==fpodTo [0]){
				        		  $scope.check=true;
				        		 // break;
				        		  }
				        	  
				        	    if($scope.check== true)
					        	  {
					        	  if ($scope.fromVoyageShipmentCheck== false) {
						        	  if ($scope.toVoyageShipmentCheck== false) {
					        		  
					        		  $scope.shiftBookingSearchData.amount=0;
						  				$scope.shiftBookingSearchData.costType='';
						  				$scope.shiftBookingSearchData.payer='';
						  				$scope.shiftBookingSearchData.currency='';
						  				$scope.shiftBookingSearchData.volume=0;
						  				
					        		  var obj={
												bean : $scope.shiftBookingSearchData,
												rolloverList:$scope.rolloverList
										};
					        		
					        	
 							          $http.post($stateParams.tenantid+'/api/shiftBooking/doshift',obj).success(function(data) {
											console.log(data);
											if(data.success==true){
 											    logger.logSuccess("Bookings shifted Successfully for booking:" );
											   $state.reload();
											  	ngDialog.close();
												
										     //   $scope.getList();
										   

											}else{
					                            logger.logError("Bookings not shifted!");

											
											}
							            })
						        	  
					        	  } else {
			                            logger.logError("Vessel sailed for the mentioned To Voyage and To POL. Roll Over could not be done!");
					        	  }
						        		  
					        	  } else {
			                            logger.logError("Vessel sailed for the mentioned From Voyage and From POL. Roll Over could not be done!");
					        	  }
					         
					        		  
					        	  }
					        	  
					        	 
					          else{
			                      logger.logError("Please select Same Pod and Fpod for booking:" );

					          }
					          
				        	  
				        	  
				          
				      
 				     
					          
			    		  } else {
			  		    		
				    			toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(sailingsReportForm.$validationSummary),5000, 'trustedHtml');
				    								}
			    		  
			    	  
		      }else{
                  logger.logError("Please select atleast One Booking...!");

		      }
		          
		      

};
		      

		      
		    	  $scope.rollOver = function (rollOverPopUpForm){

		    			  
		    		  
		    	  if (new validationService()
		    	  					.checkFormValidity(rollOverPopUpForm)) {	

		    	 
		    	  $scope.rolloverList=[];
		          var shiftBookingDtl = $filter('filter')($scope.rowCollection, { select:  true });
		          console.log("shiftBookingDtl**********8");
		          $scope.rolloverList=shiftBookingDtl;
		         
		          $scope.check=false;
		          $scope.pendingcheck=false;
		          $scope.completecheck=false;
		/*       if($scope.shiftBookingSearchData.pol == $scope.shiftBookingSearchData.polTo &&
		        		  $scope.shiftBookingSearchData.pod==$scope.shiftBookingSearchData.podTo){
		          */
		          if($scope.rolloverList.length>0)
		        	  {
		        	  var pol =$scope.shiftBookingSearchData.pol.split("-");
	        		  var polTo =$scope.shiftBookingSearchData.polTo.split("-");
	        		  var pod =$scope.shiftBookingSearchData.pod.split("-");
	        		  var podTo =$scope.shiftBookingSearchData.podTo.split("-");
	        		  var fpod =$scope.shiftBookingSearchData.fpod.split("-");
	        		  var fpodTo =$scope.shiftBookingSearchData.fpodTo.split("-");

		         
		        		  
		        		 
		        		  
		        		  if(pol[0] == polTo[0] &&
				        	pod[0] == podTo [0] &&
				            fpod [0] ==fpodTo [0]
				        		  ){
		        		  $scope.check=true;
		        		 // break;
		        		  }
		        	  
 		        	  
		        	    if($scope.check== true)
			        	  {
			        		  var obj={
										bean : $scope.shiftBookingSearchData,
										rolloverList:$scope.rolloverList
								};
			        		
					       
					          $http.post($stateParams.tenantid+'/api/shiftBooking/doshift',obj).success(function(data) {
									console.log(data);
									if(data.success==true){
									    logger.logSuccess("Bookings shifted Successfully for booking:");
									   $state.reload();
									  	ngDialog.close();
										
								     //   $scope.getList();
								   

									}else{
			                            logger.logError("Bookings not shifted!");

									
									}
					            })
				        	  
				        	  
			         
			        		  
			        	  }
			        	  
			        	 
			          else{
	                      logger.logError("Please select Same Pol ,Pod and Fpod for booking:" +bookingno);

			          }
			          
		        	  
		        	  
		          
		      }
		      else
		    	  {
       		   logger.logError("Atleast select one row");

		    	  }

		    	  }
		    	  
		    	  else {
		    	  		    		
		    	  	toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew(rollOverPopUpForm.$validationSummary),5000, 'trustedHtml');
		    	  	}
		       
		      };
		  	$scope.cancelDoPop = function(){
				ngDialog.close();
			}

});
