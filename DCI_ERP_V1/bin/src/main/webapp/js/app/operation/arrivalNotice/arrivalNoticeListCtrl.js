/*'use strict';*/
app .controller(
				'arrivalNoticeListCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {

				    $scope.dataLoopCount = 0;
				    $scope.offsetCount = 0;
				    $scope.limitCount = 1000;
				    $scope.updatedData = [];
//				    $scope.rowCollection = [];
//				    $scope.displayedCollection = [];
				    $scope.itemsByPage = 10;
					$scope.rowCollection = [];
					$scope.displayedCollection = [];

					$scope.vesselList = [];
					$scope.voyageList = [];
					 $scope.blList=[];


					$scope.discharge = {
							vessel : '',
							voyage : '',
							blNo : '',
							disVoyage:'',
							port:'',
							checkAll:''
					};

					
				

					 $scope.modeList=[];
					 $scope.carrierList=[];
					    
						$scope.getQuotationType = function() {
						    var  data = {};
						    data["id"] = "1";
						    data["text"] = "SEA COASTAL";
						    $scope.modeList.push(data);
						    //$scope.quotation.mode='1';
						    data = {};
						    data["id"] = "2";
						    data["text"] = "SEA FOREIGN";
						    $scope.modeList.push(data);
						    data = {};
						    data["id"] = "3";
						    data["text"] = "TRUCK";
						    $scope.modeList.push(data);
						    data = {};
						    data["id"] = "4";
						    data["text"] = "LINER";
							$scope.modeList.push(data);
							 data = {};
						    data["id"] = "5";
						    data["text"] = "FORWARDING";
						    $scope.modeList.push(data);
						}
						$scope.getQuotationType();
						
						
						$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
							debugger
						    $scope.carrierList = datas.commonUtilityBean;	    
					        //$scope.transList = datas.lCommonUtilityBean;	    

						}).error(function(data) {

						});
						
					
					//vessel
					
				 
					$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
						$scope.vesselList = data; 
					
					});
					
					 $scope.$watch('discharge.vessel', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
									$scope.voyageList = data;
									$scope.fpodList =[];
					    	  });
					      }
					    });
					 
					 debugger
					 $scope.$watch('[discharge.voyage,discharge.port]', function(newValue, oldValue) {
					     if($scope.discharge.voyage != null && $scope.discharge.voyage != '' && $scope.discharge.voyage != undefined 
							        && $scope.discharge.port != null && $scope.discharge.port != '' && $scope.discharge.port != undefined ){
					    	  
					    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getBLlistByVoyage?voyage='+$scope.discharge.voyage+'&pod='+$scope.discharge.port+'&mode='+$scope.discharge.mode+'&carrier='+$scope.discharge.carrier).success(function(data) {
									$scope.blList = data;
					    	  });
	
					    	 
					      }
					    });

		    	/*	  $http.get($stateParams.tenantid+ '/app/commonUtility/getPortDepot').success(function(data) {
							$scope.fpodList = data.commonUtilityBean;
				
						});*/
		    		  
		    			 $scope.$watch('discharge.voyage', function(newValue, oldValue) {
						      if(newValue!=null && newValue!=undefined && newValue != ''){
						    	  
						    		$scope.fpodList =[];
				
						    	  $scope.discharge.disVoyage = $scope.discharge.voyage;
								  
 						      }
						    });
		    			 
		    			 
				    	
				    	  
				    	  /*
			    			 $scope.$watch('discharge.disVoyage', function(newValue, oldValue) {
							      if(newValue!=null && newValue!=undefined && newValue != ''){
							    	  
							    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPodListByVoyage',newValue).success(function(data) {
										$scope.fpodList = data;
						    	  });
 									  
	 						      }
							    });
			    			 */
			    			 
			    			 $scope.$watch('discharge.disVoyage', function(newValue, oldValue) {
			    			      if(newValue!=null && newValue!=undefined && newValue != ''){
			    			    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPortListByVoyage',newValue).success(function(data) {
			    							$scope.fpodList = data;
			    			    	  });
			    			      }
			    			    });
			    			 
			    			 
		    			 
		    			 $scope.$watchCollection('[discharge.disVoyage,discharge.port]', function(newValue, oldValue) {
							 if($scope.discharge.disVoyage != null && $scope.discharge.disVoyage != '' && $scope.discharge.disVoyage != undefined 
								        && $scope.discharge.port != null && $scope.discharge.port != '' && $scope.discharge.port != undefined
								      
							
							 ){
								 
								 $http.post($stateParams.tenantid+ '/app/booking/getSailing?voyage='+$scope.discharge.disVoyage+'&pol='+$scope.discharge.port).success(function(data) {
									// $scope.discharge.eta	 = data.etasailDate;
  									
						    	  });
								 
							 }
						 });
		    	
		    		  
			    	 		 
					 $scope.printArrival = function(){
						 
						 if($scope.discharge.vessel !="" && $scope.discharge.vessel != null && $scope.discharge.vessel !=undefined ){
						        if($scope.discharge.voyage !="" && $scope.discharge.voyage !=null && $scope.discharge.voyage != undefined){
						        	if($scope.discharge.disVoyage !="" && $scope.discharge.disVoyage != null && $scope.discharge.disVoyage != undefined){
						        			
						        		if($scope.discharge.port !="" && $scope.discharge.port != null && $scope.discharge.port != undefined){
						        			
						        	if($scope.discharge.blNo !="" && $scope.discharge.blNo != null && $scope.discharge.blNo != undefined){
						        		/*if($scope.discharge.eta !="" && $scope.discharge.eta != null && $scope.discharge.eta != undefined){*/
						        		
						        		var blNo = $scope.discharge.blNo;
						        		//$scope.discharge.eta = $scope.discharge.eta;
				     	  
				     	 $http .post( $stateParams.tenantid + '/api/vesselArrival/saveArrivalNotice', $scope.discharge) .success(function(data) {
				     		 if(data.message!=null && data.message!=''){
			                	 logger.logError(data.message);

		                   }else	if (data.success == true) {
									if( $scope.discharge.mode=='4'){
										  var url = $stateParams.tenantid+'/api/vesselArrival/CargoPrintLiner?blNo='+blNo+'&pod='+$scope.discharge.port+'&voyage='+$scope.discharge.voyage+'&disVoy='+$scope.discharge.disVoyage+'&mode='+$scope.discharge.mode;
							     			var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
							     	      wnd.print();
									}else{
							      	  var url = $stateParams.tenantid+'/api/vesselArrival/CargoPrint?blNo='+blNo+'&pod='+$scope.discharge.port+'&voyage='+$scope.discharge.voyage+'&disVoy='+$scope.discharge.disVoyage;
						     			var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						     	      wnd.print();
									}
									
								} else {
									if (data.message != null && data.message != '') {
										logger.logError(data.message)
									} else {
										logger.logError("Cannot be saved. Please try again");
 									}
								}
							});	
						        		/*}
						        		 else{
								        	  
								                logger.logError("ETA date is not updated for the selected Port");
							        	}*/
				 
						    	}
						        else{
					        	  
						                logger.logError("Please select Bl No");
					        	}
						        	
						        	}else{
						        		
							        	logger.logError("Please select Port");

						        	}
						        	
						        	
						        }else{
						        	logger.logError("Please select Discharge Voyage");
						        	
						        }
						        		
					      }
					        else{
 					                logger.logError("Please select Voyage");
					        }
					      }
					         else{
					            logger.logError("Please select  Vessel");
					        }
 
				     }
				
					 
			
					 
					 
					 
					   $scope.sendMailPrint = function(blNo) {
						   
							 if($scope.discharge.vessel !="" && $scope.discharge.vessel != null && $scope.discharge.vessel !=undefined ){
							        if($scope.discharge.voyage !="" && $scope.discharge.voyage !=null && $scope.discharge.voyage != undefined){
							        	if($scope.discharge.disVoyage !="" && $scope.discharge.disVoyage != null && $scope.discharge.disVoyage != undefined){
							        			
							        		if($scope.discharge.port !="" && $scope.discharge.port != null && $scope.discharge.port != undefined){
							        			
							        	if($scope.discharge.blNo !="" && $scope.discharge.blNo != null && $scope.discharge.blNo != undefined){
					     	  
							        		/*if($scope.discharge.eta !="" && $scope.discharge.eta != null && $scope.discharge.eta != undefined){*/
						   
						   $http .post( $stateParams.tenantid + '/api/vesselArrival/saveArrivalNotice', $scope.discharge) .success(function(data) {
						if (data.success == true) {
					
						   
						   $http.get($stateParams.tenantid+'/api/vesselArrival/sendMailPrint?blNo='+blNo+'&pod='+$scope.discharge.port+'&voyage='+$scope.discharge.voyage+'&disVoy='+$scope.discharge.disVoyage).success(function(datas) {
							   if(datas.success==true){
								   logger.logSuccess(datas.message);
							   }else{
								   logger.logError(datas.message);
							   }
						   });
						   
						   
						
								} else {
									if (data.message != null && data.message != '') {
										logger.logError(data.message)
									} else {
										logger.logError("Cannot be saved. Please try again");
 									}
								}
							});	
							        		/*}
							        		 else{
									        	  
									                logger.logError("ETA date is not updated for the selected Port");
								        	}*/
							        	}
								        else{
							        	  
								                logger.logError("Please select Bl No");
							        	}
								        	
								        	}else{
								        		
									        	logger.logError("Please select Port");

								        	}
								        	
								        	
								        }else{
								        	logger.logError("Please select Discharge Voyage");
								        	
								        }
								        		
							      }
							        else{
		 					                logger.logError("Please select Voyage");
							        }
							      }
							         else{
							            logger.logError("Please select  Vessel");
							        }
		 
					      
					};
					 
					 
					
					  
					 
					 
					 
					 
					 
					 
					 
					 
					
					$scope.reset = function() {
						$scope.deleteIds = [];
						if ($scope.isEdit == true) {
							$scope.editBooking(bookingNo);
						} else {
							$scope.bookingData = {
									vessel : '',
									voyage : '',
									blNo : '',
									disVoyage:'',
									port:''
								};
						}
					}

					
	
					//cancel
					
					$scope.cancel = function() {
						$state.go('app.operation.discharge.list', {
							tenantid : $stateParams.tenantid
						});
					}

					
				$scope.search = function(bean){

					 if($scope.discharge.vessel !="" && $scope.discharge.vessel != null && $scope.discharge.vessel !=undefined ){
					        if($scope.discharge.voyage !="" && $scope.discharge.voyage !=null && $scope.discharge.voyage != undefined){
					        	if($scope.discharge.disVoyage !="" && $scope.discharge.disVoyage != null && $scope.discharge.disVoyage != undefined){
					        			
					        		if($scope.discharge.port !="" && $scope.discharge.port != null && $scope.discharge.port != undefined){
					        			
					  $http.post($stateParams.tenantid+'/api/vesselArrival/blList',bean).success(function(datas) {
						   if(datas.success==true){
							   $scope.listbl = datas.blList;
//							   logger.logSuccess(datas.message);
						   }else{
							   logger.logError("No Data !");
							   $scope.listbl  = [];
						   }
					});
}else{
						        		
							        	logger.logError("Please select Port");

						        	}
						        	
						        	
						        }else{
						        	logger.logError("Please select Discharge Voyage");
						        	
						        }
						        		
					      }
					        else{
 					                logger.logError("Please select Voyage");
					        }
					      }
					         else{
					            logger.logError("Please select  Vessel");
					        }
				} 
//					 
					$scope.sendBulkMail = function(){
						var port  = $scope.discharge.port;
						var insertFlag = true;
						$scope.dischargeNew = {
								vessel : '',
								voyage : '',
								blNo : '',
								disVoyage:'',
								port:'',
								checkAll:''
						};

						var mailList = [];
						if($scope.listbl.length > 0){
							angular.forEach($scope.listbl,function(row,index){
								if(row.select){
									row.pod = port;
									mailList.push(row);		
									$scope.dischargeNew.vessel = $scope.discharge.vessel ;
									$scope.dischargeNew.voyage = $scope.discharge.voyage ;
									$scope.dischargeNew.blNo =row.blno ;
									$scope.dischargeNew.disVoyage = $scope.discharge.disVoyage ;
									$scope.dischargeNew.port = $scope.discharge.port ;
									   $http .post( $stateParams.tenantid + '/api/vesselArrival/saveArrivalNotice',$scope.dischargeNew) .success(function(data) {
									if (data.success == true) {
										
									}else{
										insertFlag = false;
									}
									   });
								}
							})
							if(mailList.length > 0){
							if(insertFlag){
						  $http.post($stateParams.tenantid+'/api/vesselArrival/sendBulkMailPrint',mailList).success(function(datas) {
							   if(datas.success==true){
								   logger.logSuccess(datas.message);
							   }else{
								   logger.logError(datas.message);
							   }
						});
					}else{
						 logger.logError("Cannot be saved. Please try again!");
					}
						}else{
							 logger.logError("Please Select any BL!");
						}
					}
					} 
					

					$scope.checkAll = function(){ 

						angular.forEach($scope.listbl, function(chargesDetail, index) { 
						if($scope.discharge.checkAll==true){

						chargesDetail.select=true;

						}else{

						chargesDetail.select=false;

						}



						});
						}

					
				});
