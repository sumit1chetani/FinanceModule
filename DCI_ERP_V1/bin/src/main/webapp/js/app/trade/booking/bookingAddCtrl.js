/*'use strict';*/
app .controller(
				'bookingAddCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {

					$scope.saveCount = 0;
					$scope.vesselList = [];
					$scope.voyageList = [];
					$scope.polList = [];
					$scope.podList = [];
					$scope.mloList = [];
					$scope.agentList = [];
					$scope.payerList = [];
					$scope.lineList = [];
					$scope.containerList = [];
					$scope.quotationList = [];
					$scope.destinationList = [];
					$scope.containerTypeList = [];
					$scope.agentPartyList = [];
					$scope.shipperList = [];
					$scope.consigneeList = [];
					$scope.fFrwdList = [];
					$scope.notifyPartyList = [];
					$scope.FACPartyList = [];
					$scope.irbPartyList = [];
					$scope.CHAList = [];
					$scope.stuffingList = [];
					$scope.licdList = 	$scope.mloList =[];
					$http.get($stateParams.tenantid+ '/app/commonUtility/getCustomerName').success(function(data1) {
						$scope.containerTypeList = data1.containerTypeList;
					});[];
					$scope.rPolList = [];
					$scope.rPodList = [];
					$scope.dicdList = [];
					$scope.fromPortList = [];
					$scope.toPortList = [];
					$scope.rVesselList = [];
					$scope.rVoyageList = [];
					$scope.rSwitchPortList = [];
					$scope.rSwitchAgentList = [];
					$scope.statusList = [{
						id:'Active',
						text:'Active'
					},{
						id:'Inactive',
						text:'Inactive'
					}];
					$scope.rThSlotList = [{
						id : 'Y',
						text : 'Y'
					},{
						id : 'N',
						text : 'N'
					}];
					$scope.commodityList = [];
					$scope.freightList = [
					       {id: '1', text: 'Collect'},
					       {id: '2', text: 'Prepaid'},
					       {id: '3', text: 'Third Party Collect'},
					 ];
					$scope.otherChargeList = [
									       {id: '1', text: 'Collect'},
									       {id: '2', text: 'Prepaid'},
									       {id: '3', text: 'Third Party Collect'},
									 ];
					
					$scope.bookingTypeList = [
					       {id: '1', text: 'Direct'},
					       {id: '2', text: 'T/S'}  
					 ];
					
					$scope.LegType = [
					       {id: '1', text: '1'},
					       {id: '2', text: '2'},
					       {id: '3', text: '3'}  
					 ];
					
					
					$scope.cargoTypeList = [
					     {id: '1', text: 'COCO'},
					    {id: '2', text: 'Coir'}
					  ];
					
					$scope.isEdit = false;
					$scope.bookViaQt = false;
					 var today = new Date();
					    var dd = today.getDate();
					    var mm = today.getMonth()+1;

					    var yyyy = today.getFullYear();
					    if(dd<10){
					        dd='0'+dd
					    } 
					    if(mm<10){
					        mm='0'+mm
					    } 
					    var today = dd+'/'+mm+'/'+yyyy;
					    
					$scope.bookingData = {
						bookingId : '',
						bookingNo : '',
						bookingDate : today,
						origin : '',
						vessel : '',
						voyage : '',
						pol : '',
						cargoType : '',
						customer : '',
						customerName : '',
						pod : '',
						quotation : '',
						destination : '',
						service : 'COC',
						payer : '',
						line : '',
						agent : '',
						quotationDate : '',
						agentParty : '',
						leg:'1',
						pod1:'',
						pod2:'',
						shipper : '',
						consignee : '',
						fforwarder : '',
						notifyParty : '',
						facParty : '',
						irbParty : '',
						cha : '',
						stuffing : '',
						rLicd : '',
						rPol : '',
						rPod : '',
						rDicd : '',
						rSwitchAgent : '',
						rSwitchPort : '',
						carriageBy : '',
						freeDays : 0,
						croStatus:'',
						remarks : '',
						otCharge : '',
						freight : '',
						value:'',
						check:'',
						allowOtherPorts:'',
						soc : false,
						special:'',
						detentionTariffType:'',
						
						//						tsData : [],
						boxData : [],
//						jobData : [],
//						chrgData : [],
//						cntrData : []
						routingData : [],
						quotationDtl:[],
						frightTerms:'',
						bookingType:'',
						othercharges:''

						
					};
					

					 $scope.$watchCollection('[bookingData.pol,bookingData.pod]', function(newValue, oldValue) {
						 if($scope.bookingData.pol != null && $scope.bookingData.pol != '' && $scope.bookingData.pol != undefined 
							        && $scope.bookingData.pod != null && $scope.bookingData.pod != '' && $scope.bookingData.pod != undefined
							   ){
							 
							 if($scope.bookingData.pol == $scope.bookingData.pod){
								 logger.logError('POL and POD should be different!');
								 $scope.bookingData.pol ='';
								 $scope.bookingData.pod ='';
							 }
							 
						 }
					 });
					 
					 
					 $scope.$watchCollection('[bookingData.pod,bookingData.destination]', function(newValue, oldValue) {
						 if($scope.bookingData.pod != null && $scope.bookingData.pod != '' && $scope.bookingData.pod != undefined 
							        && $scope.bookingData.destination != null && $scope.bookingData.destination != '' && $scope.bookingData.destination != undefined
							   ){
							 if(!$scope.isEdit){
								 var str = $scope.bookingData.pod;
								 var res = [] ;
								 var pod;
								 var podseq;
								 res = str.split("-");
								 pod = res[0];
								 podseq=[1];

							 if(pod == $scope.bookingData.destination){
 								 $scope.bookingData.bookingType ='1';
 							 }
							 else{
 								 $scope.bookingData.bookingType ='2';
 							 }
						 }
						 }
					 });
					 
		    		  $scope.legCheckpod1 = true;
		    		  $scope.legCheckpod2 = true;
					 $scope.$watch('bookingData.leg', function(newValue, oldValue) {
					      if($scope.bookingData.leg != null && $scope.bookingData.leg != '' && $scope.bookingData.leg != undefined ){
					    	  if($scope.bookingData.leg == '1'){
					    		  $scope.legCheckpod1 = true;
					    		  $scope.legCheckpod2 = true;
					    		  $scope.bookingData.pod1 ='';
					    		  $scope.bookingData.pod2 ='';
					    	  }else if($scope.bookingData.leg == '2'){
					    		  $scope.legCheckpod1 = false;
					    	  }else if($scope.bookingData.leg == '3'){
					    		  $scope.legCheckpod1 = false;
					    		  $scope.legCheckpod2 = false;
					    	  }
					    	  else{
					    		  $scope.legCheck = false;
					    	
					    	  }
					    	  
					      }
					})
					 
                  $scope.$watch('bookingData.pod1', function(newValue, oldValue) {
					      if($scope.bookingData.pod1 != null && $scope.bookingData.pod1 != '' && $scope.bookingData.pod1 != undefined ){
					    	  if($scope.bookingData.pod != null && $scope.bookingData.pod != '' && $scope.bookingData.pod != undefined ){
					    		  var str = $scope.bookingData.pod;
									 var res = [] ;
									 var pod;
									 var podseq;
									 res = str.split("-");
									 pod = res[0];
									 podseq=[1];
					    		  
					    	  }
					    	  
					    	  if($scope.bookingData.pol != null && $scope.bookingData.pol != '' && $scope.bookingData.pol != undefined ){
					    		  var str = $scope.bookingData.pol;
									 var res = [] ;
									 var pol;
									 var polseq;
									 res = str.split("-");
									 pol = res[0];
									 polseq=[1];
					    	  }
							 
								 
					    		  if(pod == $scope.bookingData.pod1){
										 logger.logError('POD and POD1 should be different!');
										 $scope.bookingData.pod1 ='';
									 }else if (pol == $scope.bookingData.pod1)
									 {
										 logger.logError('POL and POD1 should be different!');
										 $scope.bookingData.pod1 ='';
									 }else if ($scope.bookingData.destination == $scope.bookingData.pod1)
									 {
										 logger.logError('FPOD and POD1 should be different!');
										 $scope.bookingData.destination ='';
									 }else if ($scope.bookingData.pod2 == $scope.bookingData.pod1)
									 {
										 logger.logError('POD1 and POD2 should be different!');
										 $scope.bookingData.pod1 ='';
									 }
					    		  
					    	  
					    	  
					      }
					})
					
					
					 $scope.$watch('bookingData.pod2', function(newValue, oldValue) {
					      if($scope.bookingData.pod2 != null && $scope.bookingData.pod2 != '' && $scope.bookingData.pod2 != undefined ){
					    	  if($scope.bookingData.pod != null && $scope.bookingData.pod != '' && $scope.bookingData.pod != undefined ){
					    		  var str = $scope.bookingData.pod;
									 var res = [] ;
									 var pod;
									 var podseq;
									 res = str.split("-");
									 pod = res[0];
									 podseq=[1];
					    		  
					    	  }
					    	  
					    	  if($scope.bookingData.pol != null && $scope.bookingData.pol != '' && $scope.bookingData.pol != undefined ){
					    		  var str = $scope.bookingData.pol;
									 var res = [] ;
									 var pol;
									 var polseq;
									 res = str.split("-");
									 pol = res[0];
									 polseq=[1];
					    	  }
							 
					    	
					    		  if($scope.bookingData.pod1 == $scope.bookingData.pod2){
										 logger.logError('POD1 and POD2 should be different!');
										 $scope.bookingData.pod2 ='';
									 }else if (pol == $scope.bookingData.pod2)
									 {
										 logger.logError('POL and POD2 should be different!');
										 $scope.bookingData.pod2 ='';
									 }else if(pod == $scope.bookingData.pod2){
										 logger.logError('POD and POD2 should be different!');
										 $scope.bookingData.pod2 ='';
									 }else if ($scope.bookingData.destination == $scope.bookingData.pod2)
									 {
										 logger.logError('FPOD and POD2 should be different!');
										 $scope.bookingData.pod2 ='';
									 }
					      }
					})
					
					
					
					
					 $scope.$watch('bookingData.fpod', function(newValue, oldValue) {
					      if($scope.bookingData.fpod != null && $scope.bookingData.fpod != '' && $scope.bookingData.fpod != undefined ){
					    	 
					    	
					    		  if($scope.bookingData.pod1 == $scope.bookingData.fpod){
										 logger.logError('POD1 and FPOD should be different!');
										 $scope.bookingData.fpod ='';
									 }else if ($scope.bookingData.fpod == $scope.bookingData.pod2)
									 {
										 logger.logError('POD2 and FPOD should be different!');
										 $scope.bookingData.fpod ='';
									 } 
					      }
					})
  $http.post($stateParams.tenantid+'/app/commonUtility/getSpecialList').success(function(data) {
				  	
					$scope.SpecialList=data;
					        		
			});
			 
//					$scope.tempTsData = {
//							vessel : '',
//							voyage : '',
//							pol : '',
//							pod : '',
//							agent : '',
//							leg : ''
//					}
					
//					$scope.tempJobData = {
//							vessel : '',
//							voyage : '',
//							pol : '',
//							pod : '',
//							agent : '',
//							leg : ''
//					}
//					
//					$scope.tempChrgData = {
//							containerType : '',
//							chargeCode : '',
//							currency : '',
//							amount : '',
//							agent : '',
//							leg : ''
//					}
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
						$scope.vesselList = data;
//						$scope.voyageList = data.voyageList;
//						$scope.polList = data.polList;
//						$scope.podList = data.polList;
					});
					
					 $http.post($stateParams.tenantid+'/app/detection/getTariffList').success(function(data) {
					      	
					  		$scope.tariffList=data; 
					  		        		
					     });
				/*	$scope.$watch('bookingData.voyage', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoy',newValue).success(function(data) {
					    		  $scope.polList = data;
					    	  })
					    	  
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyNU',newValue).success(function(data11) {
					    		  $scope.podList = data11;
					    	  })
					      }
					})*/
					 $scope.$watch('bookingData.voyage', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data) {
					    		  $scope.polList = data;
					    	  })
					    	  
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getPortListByVoyage',newValue).success(function(data11) {
					    		  $scope.podList = data11;
					    	  })
					      }
					})
					 
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
//						$scope.polList = data.commonUtilityBean;
//						$scope.podList = data.commonUtilityBean;
						$scope.rPolList = data.commonUtilityBean;
						$scope.rPodList = data.commonUtilityBean;
						$scope.destinationList= data.commonUtilityBean;
						$scope.licdList = data.commonUtilityBean;
						$scope.dicdList = data.commonUtilityBean;
						$scope.fromPortList = data.commonUtilityBean;
						$scope.toPortList = data.commonUtilityBean;
						$scope.rSwitchPortList = data.commonUtilityBean;
					});
					
					$http.get($stateParams.tenantid+ '/api/billofLading/getContainerList').success(function(data) {
						if(data!=null && data!=undefined ){
							$scope.containerList = data;
						}
					});
					$http.get($stateParams.tenantid+ '/app/commonUtility/getCustomerList').success(function(data) {
						if(data!=null && data.length>0){
							$scope.mloList= data;
							$scope.lineList=data;
							$scope.shipperList= data;
							$scope.consigneeList= data;
							$scope.fFrwdList= data;
							$scope.notifyPartyList= data;
							$scope.FACPartyList= data;
							$scope.irbPartyList= data;
							$scope.CHAList= data;
							$scope.agentPartyList= data;
							$scope.rSwitchAgentList = data;
						}
					});
					
//					$http.get($stateParams.tenantid+ '/app/booking/getShipConsList').success(function(data) {
//						if(data!=null && data.length>0){
//							$scope.shipperList= data.autoList;
//							$scope.consigneeList= data.autoList;
//						}
//					});
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getCommodityList').success(function(data) {
						if(data!=null && data.length>0){
							$scope.commodityList= data;
						}
					});
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getVendorList').success(function(data) {
						if(data!=null && data.length>0){
							$scope.agentList= data;
						}
					});
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getContainerTypeList').success(function(data1) {
						$scope.containerTypeList = data1.containerTypeList;
					});
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getPayerList').success(function(data) {
						if(data!=null && data.length>0){
							$scope.payerList= data;
						}
					});
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getStuffingList').success(function(data) {
						if(data!=null && data.length>0){
							$scope.stuffingList= data;
						}
					});
					$scope.CROStatus=$location.search().croStatus;
					$scope.editBooking = function(bookingNo,croStatus) {
						
						$scope.mloList =[];
						$scope.shipperList= [];
						$scope.consigneeList= [];
						$scope.fFrwdList= [];
						$scope.notifyPartyList= [];
						var obj ={
								"condition" : "select distinct unnest(ARRAY[customer,shipper,consignee,fforwarder,notify_party]) from booking where booking_no ='"+bookingNo+"'"
						}
						$http.post($stateParams.tenantid+ '/app/commonUtility/getCustomerListFilter',obj).success(function(data1) {
							console.log(data1);
							$scope.mloList = data1;
							$scope.shipperList = data1;
							$scope.consigneeList = data1;
							$scope.fFrwdList = data1;
							$scope.notifyPartyList = data1;
						});
						
						
						$http.post($stateParams.tenantid+ '/app/booking/edit',bookingNo).success(function(data) {
											$scope.bookingData = data.bookingBean;
											if(data.bookingBean.freight=='1'){
												$scope.frightTerms="Collect";
											}else if(data.bookingBean.freight=='2')
												{
												$scope.frightTerms="Prepaid";
												}else if (data.bookingBean.freight=='3'){
													$scope.frightTerms="Third Party Collect";
												}else{
													$scope.frightTerms="";
												}
											
											if(data.bookingBean.otCharge=='1'){
												$scope.otherCharge="Collect";
											}else if(data.bookingBean.otCharge=='2')
												{
												$scope.otherCharge="Prepaid";
												}else if (data.bookingBean.otCharge=='3'){
													$scope.otherCharge="Third Party Collect";
												}else{
													$scope.otherCharge="";
												}
											if(data.bookingBean.bookingType=='1'){
												$scope.bookingType="Collect";
											}else if(data.bookingBean.bookingType=='2')
												{
												$scope.bookingType="Prepaid";
												}else if (data.bookingBean.bookingType=='3'){
													$scope.bookingType="Third Party Collect";
												}else{
													$scope.bookingType="";
												}
											
										//	$scope.bookingData.bokkingType:'',
										//	$scope.bookingData.othercharges:''
											if($scope.CROStatus == "Completed" ){
												$scope.value = true;
											}else if($scope.CROStatus == "Pending"){
												$scope.value = false;
											}
											if(data.bookingBean.allowOtherPorts == true){
												$scope.quotationdetailtab = false;
											}else{
												$scope.quotationdetailtab = true;

											}
						});
					};
					
					 $scope.$watch('bookingData.vessel', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != '' && $scope.bookViaQt==false){
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
									$scope.voyageList = data;
					    	  });
					      }
					      if(newValue!=null && newValue!=undefined && newValue != '' && $scope.bookViaQt==true){
					    	  $http.post($stateParams.tenantid+ '/app/booking/getVoyListByVsl?pol='+$scope.bookingData.pol+'&pod='+$scope.bookingData.pod+'&ves='+newValue).success(function(data) {
									$scope.voyageList = data.voyList;
						    	  })
					      }
					    });
					 
					 $scope.$watchCollection('[bookingData.vessel,bookingData.voyage,bookingData.pol]', function(newValue, oldValue) {
						 if($scope.bookingData.vessel != null && $scope.bookingData.vessel != '' && $scope.bookingData.vessel != undefined 
							        && $scope.bookingData.voyage != null && $scope.bookingData.voyage != '' && $scope.bookingData.voyage != undefined
							        && $scope.bookingData.pol != null && $scope.bookingData.pol != '' && $scope.bookingData.pol != undefined){
							 if($scope.isEdit != true){
							 $http.post($stateParams.tenantid+ '/app/booking/CheckETADate?vessel='+$scope.bookingData.vessel+'&voyage='+$scope.bookingData.voyage+'&pol='+$scope.bookingData.pol).success(function(data) {
							/*	if($scope.bookingData.bookingDate <= data.etadate){
									 $scope.check = false;
								}else{
									 $scope.check = true;
									 logger.logError('ETA Date Should be Greater than Booking Date !!');
								}*/
								 
								 if(data.checkvalue == true){
									 $scope.check = false;
								 }else{
									 $scope.check = true;
									 logger.logError('ETA Date should be greater than Booking Date !!');
								 }
								
					    	  });
						 }
						 }
					 });
					 
					 $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
						  $scope.shipmentList=datas.getshipmentlist;
						  $scope.portList=datas.getportlist;
						  $scope.customerDropList=datas.getcustomerlist;
						  $scope.currencyList=datas.getcurrencylist	;
						  $scope.conTypeList=datas.getcontypelist;
						   $scope.chargeTypeList=datas.getchargetypelist
						//logger.logSuccess('Mail Sent Successfully!')
					}).error(function(datas) {

					});
					 
					 
					 $scope.$watch('bookingData.freight', function(newValue, oldValue) {
						 if($scope.bookingData.freight != '' && 
								 $scope.bookingData.freight != undefined &&
								 $scope.bookingData.freight != null){
							 
							 if($scope.bookingData.freight == 2){
								 for(var k=0; k < $scope.bookingData.quotationDtl.length ; k++){
		    				$scope.bookingData.quotationDtl[k].payAt=$scope.bookingData.pol ;
 					    		 }		
					    			
							 }
							 else{
								 for(var k=0; k < $scope.bookingData.quotationDtl.length ; k++){
					    				$scope.bookingData.quotationDtl[k].payAt=$scope.bookingData.destination;
			 					    		 }
							 }
							 
						 }
						 
					 })
					 $scope.quotationdetailtab = true;
					 $scope.$watch('bookingData.quotation', function(newValue, oldValue) {
						// if($scope.isEdit != true){
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  if($scope.isEdit != true){
					    	  $http.post($stateParams.tenantid+ '/app/booking/getQuoteValid',newValue).success(function(dat) {
					    		  $scope.bookingData.quotationDate = angular.copy(dat.quoteBean.validTill);
									$scope.bookingData.freeDays = angular.copy(dat.quoteBean.freeDays);
									$scope.bookingData.freight= angular.copy(dat.quoteBean.freight);
									$scope.bookingData.otCharge= angular.copy(dat.quoteBean.otCharge);
									$scope.bookingData.soc=angular.copy(dat.quoteBean.soc);
									$scope.bookingData.detentionTariffType=angular.copy(dat.quoteBean.detentionTariffType);
									$scope.bookingData.allowOtherPorts=angular.copy(dat.quoteBean.allowOtherPorts);
									if(dat.quoteBean.origin!=null && dat.quoteBean.origin!=undefined && dat.quoteBean.origin!=''){
										$scope.bookingData.origin= angular.copy(dat.quoteBean.origin);										
									}
									if($scope.isEdit==false && dat.boxList!=null && dat.boxList!=undefined && dat.boxList!='' && dat.boxList.length>0){
										$scope.bookingData.boxData= angular.copy(dat.boxList);										
									}
									if($scope.bookingData.allowOtherPorts == true){
										$scope.quotationdetailtab = false;
									}else{
										$scope.quotationdetailtab = true;

									}
									if($scope.bookViaQt==true){
										$scope.bookingData.pol = angular.copy(dat.quoteBean.pol);
										$scope.bookingData.pod = angular.copy(dat.quoteBean.pod);
										$scope.bookingData.destination = angular.copy(dat.quoteBean.pod);
										$scope.bookingData.customer = angular.copy(dat.quoteBean.customer);
										$scope.bookingData.customerName = angular.copy(dat.quoteBean.customer1);
										
										$http.post($stateParams.tenantid+ '/app/booking/getVesselList?pol='+$scope.bookingData.pol+'&pod='+$scope.bookingData.pod).success(function(data) {
											$scope.vesselList = data.vesselList;
//											$scope.voyageList = data.voyList;
								    	  })
									}					    	  
					    	  });
					      }
					    		$http.post($stateParams.tenantid+'/app/quotation/edit',newValue).success(function(datas) {
					    			$scope.bookingData.quotationDtl=datas.lQuotationBean;
//					    			for(var k=0; k < $scope.bookingData.quotationDtl.length ; k++){
//					    				$scope.bookingData.quotationDtl[k].payAt=$scope.bookingData.pol ;
//	 					    		 }		
					    			
 					    		
					    		}).error(function(datas) {

					    		});
					    	  
					      }else{
					    	  $scope.bookingData.quotationDate = '';
								$scope.bookingData.freeDays = 0;
					      }
					 
					    });
					 
				
					 $scope.$watchCollection('[bookingData.pol,bookingData.pod,bookingData.customer,bookingData.pod,bookingData.destination]', function(newValue, oldValue) {
						 if($scope.bookingData.pol != null && $scope.bookingData.pol != '' && $scope.bookingData.pol != undefined 
							        && $scope.bookingData.pod != null && $scope.bookingData.pod != '' && $scope.bookingData.pod != undefined
							        && $scope.bookingData.customer != null && $scope.bookingData.customer != '' && $scope.bookingData.customer != undefined
							        
						 
						 ){
							   if($scope.isEdit != true){
							 $http.post($stateParams.tenantid+ '/app/booking/getQuote?pol='+$scope.bookingData.pol+'&pod='+$scope.bookingData.pod+'&mlo='+$scope.bookingData.customer+'&fpod='+$scope.bookingData.destination).success(function(data) {
								if(data!=null && data!=undefined && data.quoteList!=null && data.quoteList!=undefined && data.quoteList.length>0){
									 $scope.quotationList = data.quoteList;
								}else{
									 $scope.quotationList = [];
									 logger.logError("No quote available!");
								}
								
					    	  });
							   }else{
							 $http.post($stateParams.tenantid+ '/app/booking/getQuoteEdit?pol='+$scope.bookingData.pol+'&pod='+$scope.bookingData.pod+'&mlo='+$scope.bookingData.customer+'&fpod='+$scope.bookingData.destination+'&bookingNo='+$scope.bookingData.bookingNo).success(function(data) {
									if(data!=null && data!=undefined && data.quoteList!=null && data.quoteList!=undefined && data.quoteList.length>0){
										 $scope.quotationList = data.quoteList;
									}else{
										 $scope.quotationList = [];
										 logger.logError("No quote available!");
									}
									
						    	  });   
							   }
						 }
					 });
					 
					 $scope.$watch('bookingData.customer', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  if($scope.isEdit != true)
					    	  $scope.bookingData.shipper=newValue
					      }
					    });
					 
					var bookingNo = $location.search().bookingNo;
					var quotationNoCR = $location.search().quotationNoCR;
					if (bookingNo == null || bookingNo == undefined) {
						$scope.isEdit = false;
//						$scope.getOnloadList();
					} else {
						$scope.isEdit = true;
						$scope.editBooking(bookingNo);
					}
					
					if(quotationNoCR!=null && quotationNoCR!=undefined && quotationNoCR!=''){
						$scope.bookingData.quotation = angular.copy(quotationNoCR);
						$scope.bookViaQt = true;
					}
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
						$scope.rPodList = data.commonUtilityBean;
					});
					 
					$scope.reset = function() {
						$scope.deleteIds = [];
						if ($scope.isEdit == true) {
							$scope.editBooking(bookingNo);
						} else if($scope.bookViaQt == true){

							$scope.bookingData = {
									bookingId : '',
									bookingNo : '',
									bookingDate : today,
									origin : '',
									vessel : '',
									voyage : '',
									pol : '',
									customer : '',
									customerName : '',
									pod : '',
									quotation : '',
									destination : '',
									service : 'COC',
									payer : '',
									line : '',
									agent : '',
									quotationDate : '',
									agentParty : '',
									shipper : '',
									consignee : '',
									fforwarder : '',
									notifyParty : '',
									leg:'',
									pod1:'',
									facParty : '',
									irbParty : '',
									cha : '',
									stuffing : '',
									rLicd : '',
									rPol : '',
									rPod : '',
									rDicd : '',
									rSwitchAgent : '',
									rSwitchPort : '',
									carriageBy : '',
									freeDays : 0,
									remarks : '',
									otCharge : '',
									freight : '',
//									tsData : [],
									boxData : [],
//									jobData : [],
//									chrgData : [],
//									cntrData : []
									routingData : []
									
									
								};
						
							$scope.bookingData.quotation = angular.copy(quotationNoCR);
						}else {
							$scope.bookingData = {
									bookingId : '',
									bookingNo : '',
									bookingDate : today,
									origin : '',
									vessel : '',
									voyage : '',
									pol : '',
									customer : '',
									customerName : '',
									pod : '',
									quotation : '',
									destination : '',
									service : 'COC',
									payer : '',
									line : '',
									leg:'',
									pod1:'',
									agent : '',
									quotationDate : '',
									agentParty : '',
									shipper : '',
									consignee : '',
									fforwarder : '',
									notifyParty : '',
									facParty : '',
									irbParty : '',
									cha : '',
									stuffing : '',
									rLicd : '',
									rPol : '',
									rPod : '',
									rDicd : '',
									rSwitchAgent : '',
									rSwitchPort : '',
									carriageBy : '',
									freeDays : 0,
									remarks : '',
									otCharge : '',
									freight : '',
									soc : '',
									allowOtherPorts:'',
//									tsData : [],
									boxData : [],
//									jobData : [],
//									chrgData : [],
//									cntrData : []
									routingData : []
									
									
								};
						}
					}

//					$scope.addTsRow = function(){
//						$scope.bookingData.tsData.push( $scope.tempTsData);
//					}
					
					$scope.addBxRow = function(){
						var tempBoxData = {
								bookingDtlId : '',
								cntrType : '',
								noOfBox : '',
								commodity : '',
								hazardous : false,
								isOog : false,
								isSoc :false
						}
						$scope.bookingData.boxData.push( tempBoxData);
					}
					
					$scope.addBxRow();
					
					$scope.addRtRow = function(){
						var tempRtData = {
								bookingRoutingId : '',
								fromPort : '',
								toPort : '',
								throughSlot : '',
								vessel : '',
								voyage : '',
								eta : '',
								etd : '',
								status : '',
								rVesselList : $scope.vesselList,
								rVoyageList : []
						}
						$scope.bookingData.routingData.push( tempRtData);
					}
					
//					$scope.addCredRowJB = function(){
//						$scope.bookingData.jobData.push( $scope.tempJobData);
//					}
//					
//					$scope.addCredRowCh = function(){
//						$scope.bookingData.chrgData.push( $scope.tempChrgData);
//					}
					
					$scope.addCredRowCD = function(){
						var tempCntrData = {
								bookingCntrId : '',
								cntrType : '',
								cntrNo : '',
								sealNo : '',
								dropOffMode : '',
								isDG : false,
								isReefer : false,
								isFlexi : false,
								isOOG : false,
								isSoc :false
						}
						$scope.bookingData.cntrData.push( tempCntrData);
					}
					
					//////////////Delete ROW////////////////////////////
					
					$scope.removeBxRow = function(){
						var count =0;
						ngDialog.openConfirm().then(function() {
							if($scope.isEdit==false){
								var tmpDelList = [];
								
								for(var i=$scope.bookingData.boxData.length-1;i>=0;i--){
									if($scope.bookingData.boxData[i].select==true){
										count++;
										tmpDelList.push($scope.bookingData.boxData[i]);
										$scope.bookingData.boxData.splice(i, 1);
									}
								}
								if(count>0){
									logger.logSuccess('Deleted Successfully');	
								}else{
									logger.logError('Please select the row to delete!');
								}
							}else if($scope.isEdit==true){
								var delCheck =false;
								var tmpDelList = [];
								for(var i=$scope.bookingData.boxData.length-1;i>=0;i--){
									if($scope.bookingData.boxData[i].select==true){
										count++;
										tmpDelList.push($scope.bookingData.boxData[i]);
//										$scope.bookingData.boxData.splice(i, 1);
									}
								}
							for(var i =0;i<tmpDelList.length;i++){
								if(tmpDelList[i].bookingDtlId!=null && tmpDelList[i].bookingDtlId>0){
								$http.post($stateParams.tenantid+'/app/booking/deleteDtl',tmpDelList[i].bookingDtlId).success(function(data) {
						        	if(data.success){
//						        		logger.logSuccess('Deleted Successfully');
						        		delCheck =true;
						        	}else{
						        		logger.logError('Unable to delete');
						        	}
								})
								}
							}
							if(delCheck==true){
								for(var i=$scope.bookingData.boxData.length-1;i>=0;i--){
									if($scope.bookingData.boxData[i].select==true){
										count++;
										$scope.bookingData.boxData.splice(i, 1);
									}
								}
							}
							if(count>0 && delCheck==true){
								logger.logSuccess('Deleted Successfully');	
							}else if(count==0){
								logger.logError('Please select the row to delete!');
							}
							}
							})
					}

					
					$scope.removeRtRow = function(){
						
						ngDialog.openConfirm().then(function() {
							if($scope.isEdit==false){
								var tmpDelList = [];
								for(var i=$scope.bookingData.routingData.length-1;i>=0;i--){
									if($scope.bookingData.routingData[i].selectRt==true){
										tmpDelList.push($scope.bookingData.routingData[i]);
										$scope.bookingData.routingData.splice(i, 1);
									}
								}
								logger.logSuccess('Deleted Successfully');
							}else if($scope.isEdit==true){
								var tmpDelList = [];
								for(var i=$scope.bookingData.routingData.length-1;i>=0;i--){
									if($scope.bookingData.routingData[i].selectRt==true){
										tmpDelList.push($scope.bookingData.routingData[i]);
										$scope.bookingData.routingData.splice(i, 1);
									}
								}
								for(var i =0;i<tmpDelList.length;i++){
									if(tmpDelList[i].bookingRoutingId!=null && tmpDelList[i].bookingRoutingId>0){
									$http.post($stateParams.tenantid+'/app/booking/deleteBkRouting',tmpDelList[i].bookingRoutingId).success(function(data) {
							        	if(data.success){
							        		logger.logSuccess('Deleted Successfully');
							        	}else{
							        		logger.logError('Unable to delete');
							        	}
									})
									}
								}
							}
						})
					}
					///////////Delete ROW end//////////////////////////////////////
					
					$scope.saveFinal = function(rb){
						if($scope.saveCount==0){
							var type = false;
							 var str1 = rb.bookingBean.pod;
							 var res = [] ;
							 var pod;
							 var podseq;
							 res = str1.split("-");
							 pod = res[0];
							 podseq=[1];
							if(pod == rb.bookingBean.destination){
								if(rb.bookingBean.bookingType == 1){
									type =true;
								}else{
									logger.logError("Please Change the Booking Type as Direct");
									$scope.bookingData.bookingType='';
								}
							}
							else{
								if(rb.bookingBean.bookingType == 2){
									type =true;
								}else{
									logger.logError("Please Change the Booking Type as T/S");
									$scope.bookingData.bookingType='';
								}
							}
							if(type){
								 $scope.check = true;
								$http .post( $stateParams.tenantid + '/app/booking/save', rb) .success(	function(data) {
									if (data.success == true) {
										$scope.saveCount++;
										logger .logSuccess('Booking Saved Successfully!!!')
										$scope.cancel();
									} else {
										if (data.message != null && data.message != '') {
											logger.logError(data.message)
										} else {
											logger.logError("Cannot be saved. Please try again");
											$scope.check = false;
										}
									}
								});	
							}
							
						}else{
							logger.logError("Already saved!");
							$scope.check = false;
						}
					}
					
					$scope.updateFinal = function(rb){
						$scope.check = true;
						$http .post( $stateParams.tenantid + '/app/booking/update', rb) .success(	function(data) {
							if (data.success == true) {
								logger .logSuccess('Booking Updated Successfully!!!')
								$scope.cancel();
							} else {
								if (data.message != null && data.message != '') {
									logger.logError(data.message)
									$scope.check = false;
								} else {
									logger.logError("Cannot be saved. Please try again");
									$scope.check = false;
								}
							}
						});
					}
					  $scope.checkundefined = function(value) {
						    var invalid = false;
						    if (value == undefined || value == 'undefined' || value == null || value == 'null' || value == '') {
						        invalid = true;
						    }
						    return invalid;

						}

						$scope.changecolor = function(id) {
							$('#' + id + ' .selectivityId').find('input').css(
									"border-color", "red");
						}

						$scope.changecolor = function(id) {
							$('#' + id + ' .selectivityId').find('input').css(
									"border-color", "red");

						}
						$scope.clearcolor = function(id) {
							$('#' + id + ' .selectivityId').find('input').css(
									"border-color", "#e8dddd");

						}
						
						
					$scope.checkValidation = function() {

					    var alertmsg = "<ui><h4 backgroundcolor=green>Please fill the required fields</h4>";
					    var msg = "";
					 
					  	    angular.forEach($scope.bookingData.boxData, function(chargesDetail, index) {     
//					        
					       /* if ($scope.checkundefined(chargesDetail.commodity)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# commodity :Field is required.</li>";
					            $scope.changecolor('commodity'+index);
					        }else{
					        	$scope.clearcolor('commodity'+index);
					        }*/
					        
					    });
					    alertmsg = alertmsg + msg + "</ui>";
					    if ($scope.checkundefined(msg)) {
					        return '';
					    } else {
					        return alertmsg;
					    }

					}
					
					$scope.saveBooking = function(bookingForm) {
						if ($scope.isEdit == false){
							var msg=$scope.checkValidation();
						}
						if(!$scope.checkundefined(msg)){   
							logger.logError(msg);
						}else{
						if (new validationService() .checkFormValidity(bookingForm)) {
							if ($scope.bookingData.boxData != null && $scope.bookingData.boxData.length > 0) {
								var rb = {
										bookingBean : $scope.bookingData
								}
								console.log(rb);
								if($scope.isEdit){
									if($scope.bookingData.quotation==''){
										ngDialog.openConfirm({
								            template :

								            ' <div class="modal-header">CONFIRMATION</div> ' + '  <div class="row"> ' + '  <div class="col-lg-12"> ' + '   <div class="col-lg-12">   Do you want to continue without Quote?    </div> ' + '   </div>  ' + '  </div> ' + '  <div class="modal-footer">' +

								            '    <button class="btn btn-info" type="button" ng-click="confirm()">YES</button>' + '   <button class="btn btn-danger" ng-click="closeThisDialog()">NO</button>' + '  </div>',
								            plain : true,
								            scope : $scope
								        }).then(function(value) {
								        	$scope.updateFinal(rb);
								        })
									}else{
										$scope.updateFinal(rb);
									}
								}else{
									if($scope.bookingData.quotation==''){
										ngDialog.openConfirm({
								            template :

								            ' <div class="modal-header">CONFIRMATION</div> ' + '  <div class="row"> ' + '  <div class="col-lg-12"> ' + '   <div class="col-lg-12">   Do you want to continue without Quote?    </div> ' + '   </div>  ' + '  </div> ' + '  <div class="modal-footer">' +

								            '    <button class="btn btn-info" type="button" ng-click="confirm()">YES</button>' + '   <button class="btn btn-danger" ng-click="closeThisDialog()">NO</button>' + '  </div>',
								            plain : true,
								            scope : $scope
								        }).then(function(value) {
								        	$scope.saveFinal(rb);
								        })
									}else{
										$scope.saveFinal(rb);
									}
									
								}
								
							} else {
								logger.logError('Please provide container detail');
								}
						} else {
							toaster.pop( 'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew($scope.bookingForm.$validationSummary),
											5000, 'trustedHtml');
						}
						}
					}
					
					$scope.cancel = function() {
						$state.go('app.trade.booking.list', {
							tenantid : $stateParams.tenantid
						});
					}

					$scope.checkBookingCRO = function(){

						$scope.quotation={
								service:'',
								aol:'',
								origin:'',
								customer:'',
								salesPerson:'',
								vendor : '', 
								attention : '',
								quotationDate : '',
								branch : '',
								aod : '',
								destination : '',
								shipper : '',
								salesType : '',
								carrier : '',
								termConditions : '',
								mode : '1',
								currency : '',
								term : '',
								commodity : '',
								consignee : '',
								nominatedBy : '',
								validityDate : '',
								remarks : '',
								vessel :'',
								dimensionName:'',
								conNumber:'',
								containerreleaseCode:'',
								quotationDtl:[{id:0,conType:'',quantity:'',depot:'',allocDate:''}],
								sealDtl:[{id:0,sealNo:'',sealFrom:'',sealTo:'',count:''}]
						
						}

						
						
						
						
						
						
						
						
				 		var bookingNo = $location.search().bookingNo;
						$http.post($stateParams.tenantid+ '/app/booking/getCRO',bookingNo).success(function(datas) {
							$scope.quotation=datas.seaQuotationBean;
							$scope.quotation.bookingNo=datas.seaQuotationBean.bookingNo;
							$scope.quotation.quotationDtl=datas.lQuotationBean;
							$scope.quotation.sealDtl=datas.sealdtl;
						});
						
//
						
//						$scope.listTest =[];
//						  $scope.listTest = [
//						          		       {id: '1', text: 'Collect'},
//						         		       {id: '2', text: 'Prepaid'},
//						         		       {id: '3', text: 'Third Pary Collect'},
//						         		     ];
//						
//						$scope.listTest.push($scope.termsOfPayment);
						
						
						
						
						
//						$scope.checkBookingGate();
//						$scope.checkBookingShippingInstruction();
//						$scope.checkBookingBL()
					}	
				
					
					$scope.checkBookingGateDO = function(DOnum){
						$scope.checkBookingGateOutDO(DOnum);
					}
					
					$scope.checkBookingGateOutDO = function(DOnum){

						$scope.quotation={
								service:'',
								aol:'',
								origin:'',
								customer:'',
								salesPerson:'',
								vendor : '', 
								attention : '',
								quotationDate : '',
								branch : '',
								aod : '',
								destination : '',
								shipper : '',
								salesType : '',
								carrier : '',
								termConditions : '',
								mode : '1',
								currency : '',
								term : '',
								type : 'Export',
								consignee : '',
								nominatedBy : '',
								validityDate : '',
								remarks : '',
								vessel :'',
								dimensionName:'',
								quotationDtl:[{id:0,conType:'',quantity:'',depot:'',allocDate:''}],
								sealDtl:[{id:0,sealNo:'',sealFrom:'',sealTo:'',count:''}]
						
						}
						
						
//						var bookingNo = $location.search().bookingNo;
						$http.post($stateParams.tenantid+ '/app/booking/getGateOutDO', $scope.deliveryOrderNum).success(function(datas) {
							$scope.conNoList=datas.getcontainer;
							$scope.quotation=datas.seaQuotationBean;
							$scope.quotation.quotationDtl=datas.lQuotationBean;
						}).error(function(datas) {
						
													});	
	
						
					}
$scope.checkBookingGateInDO = function(Donum){
						

						var bookingNo = $location.search().bookingNo;

					$http.post($stateParams.tenantid+ '/app/booking/getGateInDO', $scope.deliveryOrderNum).success(function(result) {

						$scope.isEdit = true;
						$scope.gateIn = result;
						if($scope.gateIn){
							 
						}
						if (result.isEdit == false) {
							logger
									.logError("Please Try Again");
						} else {

						}
					}).error(function(data) {
				console.log("data" + data);
			});		
					
					
					}
					$scope.checkBookingGate	= function(){
						$scope.checkBookingGateOut();
					}
	// GATE OUT -----------------
					
					$scope.checkBookingGateOut = function(){

						$scope.quotation={
								service:'',
								aol:'',
								origin:'',
								customer:'',
								salesPerson:'',
								vendor : '', 
								attention : '',
								quotationDate : '',
								branch : '',
								aod : '',
								destination : '',
								shipper : '',
								salesType : '',
								carrier : '',
								termConditions : '',
								mode : '1',
								currency : '',
								term : '',
								type : 'Export',
								consignee : '',
								nominatedBy : '',
								validityDate : '',
								remarks : '',
								vessel :'',
								dimensionName:'',
								quotationDtl:[{id:0,conType:'',quantity:'',depot:'',allocDate:''}],
								sealDtl:[{id:0,sealNo:'',sealFrom:'',sealTo:'',count:''}]
						
						}
						
						
						var bookingNo = $location.search().bookingNo;
						$http.post($stateParams.tenantid+ '/app/booking/getGateOut',bookingNo).success(function(datas) {
							$scope.conNoList=datas.getcontainer;
							$scope.quotation=datas.seaQuotationBean;
							$scope.quotation.quotationDtl=datas.lQuotationBean;
						}).error(function(datas) {
						
													});	
	
						
					}


					
				//--------------------- END -------------
// GATE IN -----------------
					$scope.checkBookingGateIn = function(){
						

						var bookingNo = $location.search().bookingNo;

					$http.post($stateParams.tenantid+ '/app/booking/getGateIn', bookingNo).success(function(result) {

						$scope.isEdit = true;
						$scope.gateIn = result;
						if($scope.gateIn){
							 
						}
						if (result.isEdit == false) {
							logger
									.logError("Please Try Again");
						} else {

						}
					}).error(function(data) {
				console.log("data" + data);
			});		
					
					
					}	
					
					//--------------------- END -------------	
					
					$scope.checkBookingShippingInstruction = function(){	
						 //////////////////////////////////////////////////
						  
						  $scope.blNoData = {
								  blNo : '',
								  bookingNo : '',
								  issuePlace : '',
								  issueDate : '',
								  onBoard : '',
								  vslVoyage : '',
								  receiptAt : '',
								  pol : '',
								  pod : '',
								  pot : '',
								  fpod : '',
								  pod1:'',
								  disPol:'',
								  disPod:'',
								  disFpod:'',
								  disvessel:'',
								  disvoyage:'',
								  disPor:'',
								  terms : '',
								  noBls : 3,
								  ref : '',
								  mVoyage : '',
								  loadType : '',
								  service : '',
								  client : '',
								  jobNo : '',
								  agent : '',
								  remarks : '',
								  shipment : '',
								  status : '',
								  released : '',
								  messers : '',
								  shippers : '',
								  cnee : '',
								  notify1 : '',
								  notify2 : '',
								  forwarder : '' ,
								  shipperId : '',
								  cneeId : '',
								  notify1Id : '',
								  notify2Id : '',
								  forwarderId : '' ,
								  mainCom : '',
								  twgt: '',
								  gwgt : '',
								  nwgt : '',
								  cbm : '',
								  pkgs : '',
								  goods : '',
								  marks : '',
								  imcoCharge:'',
								  unCode :'',
								  deliveryAgent:'',
								  polSeq:'',
								  podSeq:'',
								  soc: false,
								  detentionTariffType:'',
								  addContainerStatus : true,
								  blcntrDtlList:[
									 { 
								 chargeList : []
									 }
								 ],
								 blpckDtlList : [{
									 packageList : [] 
								 }],
								 blCharges : [],
								 removeCntr : [],
								 removeCntrCharge : [],
								 removeCntrPckg : [],
								 removeCharge : []
								 
						    };
						  $scope.blNoData.blcntrDtlList = [];
							var bookingNo = $location.search().bookingNo;

//							$http.post($stateParams.tenantid+ '/app/booking/getGateIn', bookingNo).success(function(result) {
	  
						  
					 $http.post($stateParams.tenantid+'/app/booking/getShipMentOrder',bookingNo).success(function(result) {
				        	
			        	 var data = [{id : result.bookingNo, text : result.bookingNo}];
			        	 $scope.bookingList=data;
			             	$scope.blNoData=result;
			             	
			             	
			             	
			            	$scope.isEdit=true;
			            	  if($scope.isEdit){
			            			 $http.post($stateParams.tenantid+'/api/shipmentorder/getContainerListdrop',$scope.blNoData).success(function(datas) {
			         	 		        $scope.containerList = datas;
			         	 		    });
			            	  }
			            	  else{
			            			 $http.post($stateParams.tenantid+'/api/shipmentorder/getContainerListdrop',$scope.blNoData).success(function(datas) {
			         	 		        $scope.containerList = datas;
			         	 		    });
			            	  }
			            
			         }).error(function(data) {
			            console.log("data" + data);
			        });
					
					};
					
					$scope.checkOnBoard = function(voyage){

					    var onBoardNo = $stateParams.onBoardNo;
					    $scope.id = $stateParams.onBoardNo;
					    $scope.onBoard = {
								vessel : '',
								voyage : '',
								port : '',
								service : '',
								onBoardDate : '',
								slotOperator:'',
								containerDtl : [],
								count:[]
					    
							}
					   
					    $scope.slotList=[];
						 $http.post($stateParams.tenantid+'/app/booking/getOnBoardDetails',voyage).success(function(data) {

//					    $http.post($stateParams.tenantid+'/app/onBoard/getOnBoardDetails', onBoardNo).success(function(data) {
					        console.log(data);
					        $scope.onBoard.containerDtl=data.detailList
					        $scope.onBoard.vessel=data.detailList[0].vessel;
					        $scope.onBoard.voyage=data.detailList[0].voyage;
					        $scope.onBoard.port=data.detailList[0].port;
					        $scope.onBoard.onBoardDate=data.detailList[0].onBoardDate; 
					        $scope.onBoard.count = data.contList;
					        $scope.portfromonboard = data.detailList[0].port;

					    }).error(function(data) {
					        logger.logError("Error Please Try Again");
					    });

					     
					 
					 


					}
					
					$scope.checkDischarge = function(voyage,port){



						$scope.discharge = {
								vessel : '',
								voyage : '',
								port : '',
								terminal : '',
								arrivalDate : '',
								dischargeDate:'',
								detailDate:'',
								detailList : [],
						
							
						};

						$scope.detailList={
								bookingNum:'',
								blNumber:'',
								customerName:'',
								containerNumber:'',
								containerType:'',
								isTransit:'',
								dischargeStatusDate:'',
								 select1:false,
								 disabled:false
						}
					
								
						
						
						
						
						
						  $scope.isEdit=true;
//						 $http.post($stateParams.tenantid+'/app/booking/getOnBoardDetails',voyage).success(function(data) {

						  $http.get($stateParams.tenantid+'/app/booking/discharge?voyage=' +voyage+'&port='+port).success(function(result) {
					          
					          if (result.isEdit == false) {
					              logger.logError("Please Try Again");
					          } else {
					              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
					              console.log(result);
					              $scope.discharge = result;
					              $scope.rowCollection = result.detailList;
					              $scope.rowCollectionView = result.detailListforView;
					          }
					            
					         }).error(function(data) {

					         });
					  
						
					}
					
				$scope.checkdeliveryOrder = function(blNumber){


				    var onBoardNo = $stateParams.onBoardNo;
				    $scope.id = $stateParams.onBoardNo;
				    $scope.onBoard = {
							vessel : '',
							voyage : '',
							port : '',
							service : '',
							onBoardDate : '',
							slotOperator:'',
							containerDtl : [],
							count:[]
				    
						}
				   
				    $scope.slotList=[];
					 $http.post($stateParams.tenantid+'/app/booking/deiveryorder',blNumber).success(function(result) {
				          
				          if (result.success == false) {
				              logger.logError("Please Try Again");
				          } else {
				              
				              console.log(result);
				              $scope.deliveryorder = result;
				              $scope.deliveryOrderNum = result.doNumber;
				              
				              if(result.doimport == "true"){
				            	  $scope.deliveryorder.doimport = true;
				              }else {
				            	  $scope.deliveryorder.doimport = false;
				              }
				              
				              if(result.reexport == "true"){
				            	  $scope.deliveryorder.reexport = true;
				              }else {
				            	  $scope.deliveryorder.reexport = false;
				              }
				              
				              if(result.transit == "true"){
				            	  $scope.deliveryorder.transit = true;
				              }else {
				            	  $scope.deliveryorder.transit = false;
				              }
				              
				              if(result.tempadmission == "true"){
				            	  $scope.deliveryorder.tempadmission = true;
				              }else {
				            	  $scope.deliveryorder.tempadmission = false;
				              }
				              
				              if(result.dfsa == "true"){
				            	  $scope.deliveryorder.dfsa = true;
				              }else {
				            	  $scope.deliveryorder.dfsa = false;
				              }
				              
				              if(result.fz == "true"){
				            	  $scope.deliveryorder.fz = true;
				              }else {
				            	  $scope.deliveryorder.fz = false;
				              }
				              
				              
				              if(result.cdrcash == "true"){
				            	  $scope.deliveryorder.cdrcash = true;
				              }else {
				            	  $scope.deliveryorder.cdrcash = false;
				              }
				              
				              if(result.cdr == "true"){
				            	  $scope.deliveryorder.cdr = true;
				              }else {
				            	  $scope.deliveryorder.cdr = false;
				              }
				              
				              
				              if(result.deposit == "true"){
				            	  $scope.deliveryorder.deposit = true;
				              }else {
				            	  $scope.deliveryorder.deposit = false;
				              }
				              
				              if(result.credit == "true"){
				            	  $scope.deliveryorder.credit = true;
				              }else {
				            	  $scope.deliveryorder.credit = false;
				              }
				              
				              if(result.stang == "true"){
				            	  $scope.deliveryorder.stang = true;
				              }else {
				            	  $scope.deliveryorder.stang = false;
				              }
				              
				              if(result.bankg == "true"){
				            	  $scope.deliveryorder.bankg = true;
				              }else {
				            	  $scope.deliveryorder.bankg = false;
				              }
				              

				              if(result.other == "true"){
				            	  $scope.deliveryorder.other = true;
				              }else {
				            	  $scope.deliveryorder.other = false;
				              }
				              
				              if(result.fit == "true"){
				            	  $scope.deliveryorder.fit = true;
				              }else {
				            	  $scope.deliveryorder.fit = false;
				              }
				                
				             
				          }
				            
				         }).error(function(data) {
				        logger.logError("Error Please Try Again");
				    });

				}	
					
					
					
					
					
					
					$scope.checkBookingBL = function(){


						 $scope.rowCollectionFollowup=[];
						    $scope.referralList=[];
						    $scope.isEdit = false;
						   
						    $scope.tairDetailList =[];
							
						    $scope.blNoData = {
									  blNo : '',
									  jobNo : '',
									  issuePlace : '',
									  issueDate : '',
									  onBoard : '',
									  vslVoyage : '',
									  receiptAt : '',
									  pol : '',
									  pod : '',
									  pot : '',
									  fpod : '',
									  disPol:'',
									  disPod:'',
									  disFpod:'',
									  disvessel:'',
									  disvoyage:'',
									  disPor:'',
									  terms : '',
									  noBls : 3,
									  ref : '',
									  mVoyage : '',
									  loadType : '',
									  service : '',
									  client : '',
									  jobNo : '',
									  agent : '',
									  remarks : '',
									  shipment : '',
									  payer : '',
									  status : '',
									  released : '',
									  messers : '',
									  shippers : '',
									  deliveryAgent:'',
									  polSeq:'',
									  podSeq:'',
									  cnee : '',
									  notify1 : '',
									  notify2 : '',
									  forwarder : '' ,
									  maincom : 'SHIPPERS LOAD STOW AND COUNT',
									  twgt: '',
									  gwgt : '',
									  nwgt : '',
									  cbm : '',
									  pkgs : '',
									  goods : '',
									  marks : '',
									  shipperId : '',
									  cneeId : '',
									  notify1Id : '',
									  notify2Id : '',
									  forwarderId : '',
									  unCode:'',
									  imcoCharge:'',
									  otherblno:'',
									  blrelease:false,
									  rfs:false,
									  soc:false,
									  multimodel : false,
									  detentionTariff:true,
									  printstatus:false,
									  sailingstatus:false,
									  checkNetWgt:false,
									  blreleaseremeraks:'' ,
									  count:'',
									  rob:false,
									  robVessel:'',
									  robVoyage:'',
									  robFpod:'',
									  robPol:'',
									  detentionTariffType:'',
									  blcntrDtlrobPolrobPolList:[
										 { 
									 chargeList : []
										 }
									 ],
									 blpckDtlList : [{
										 packageList : [] 
									 }],
									 blCharges : [],
									 removeCntr : [],
									 removeCntrCharge : [],
									 removeCntrPckg : [],
									 removeCharge : []
									 
							    };
							  $scope.blNoData.removeCntr=[];
							  $scope.blNoData.removeCntrCharge=[];
							  $scope.blNoData.removeCntrPckg=[];

							    
							    		
						
						
						
						
						
						
						
						
						
						

							  $scope.termsOfPayment = [
							          		       {id: '1', text: 'Collect'},
							         		       {id: '2', text: 'Prepaid'},
							         		       {id: '3', text: 'Third Pary Collect'},
							         		     ];
							    $scope.load = [
							       {id: 'FCL', text: 'FCL'},
							       {id: 'LCL', text: 'LCL'},
							     ];
					 
							    $scope.jobno = [
							        {id:'',text:'---select---'},
							       {id: 'J001', text: 'J001'},
							       {id: 'J002', text: 'J002'},
							       {id: 'J003', text: 'J003'},
							     ];

							    $scope.statusList = [
					 		       {id: 'Hold', text: 'Hold'},
							     ];
							    
						
						
					 

						
						
						
				    	$scope.jobList=[];
				    	
				    	$scope.isEdit=true;
//				     	  $http.get($stateParams.tenantid+ '/api/outWard/getCustomereditDropdown?blNo=' +blNo).success(function(data1) {
//				     			console.log(data1);
//				     			$scope.customerList1 = data1;
//
//				     		});
				     		var bookingNo = $location.search().bookingNo;
				        $http.get($stateParams.tenantid+'/api/outWard/getBL?bookingNo=' +bookingNo).success(function(result) {
				        	if(result.blNo == null || result.blNo == ""){
			         			 logger.logError("BL not Allocated for your Booking No..!!");

				        	}
				        	$scope.BLnumber = result.blNo;
				        	$scope.voyage = result.vslVoyage;
				        	$scope.isEdit=true;
				        	if(result.goods != null && result.goods != ''){
				     			 var text5 =result.goods;
				                  text5 = text5.replace(/\r?<br>/g, '\n');
				                 result.goods=text5;
				     		}
				        	if(result.shipper != null && result.shipper != ''){
				    			 var text5 =result.shipper;
				                 text5 = text5.replace(/\r?<br>/g, '\n');
				                result.shipper=text5;
				    		}
				        	if(result.cnee != null && result.cnee != ''){
				   			 var text5 =result.cnee;
				                text5 = text5.replace(/\r?<br>/g, '\n');
				               result.cnee=text5;
				        	}
				        	if(result.notify1 != null && result.notify1 != ''){
				      			 var text5 =result.notify1;
				                   text5 = text5.replace(/\r?<br>/g, '\n');
				                  result.notify1=text5;
				           	}
				        	if(result.notify2 != null && result.notify2 != ''){
				      			 var text5 =result.notify2;
				                   text5 = text5.replace(/\r?<br>/g, '\n');
				                  result.notify2=text5;
				           	}
				        	if(result.forwarder != null && result.forwarder != ''){
				     			 var text5 =result.forwarder;
				                  text5 = text5.replace(/\r?<br>/g, '\n');
				                 result.forwarder=text5;
				          	}
				        	if(result.marks != null && result.marks != ''){
				     			 var text5 =result.marks;
				                  text5 = text5.replace(/\r?<br>/g, '\n');
				                 result.marks=text5;
				          	}
				        	$scope.blNoData.count=result.count;
				        	$scope.bltype=result.bltype;
				        	// alert("1 :"+result.printstatus +" 2:"+result.sailingstatus);
				        		if(result.userId !='E0019'&& result.userId !='E0021' && result.userId !='E0001'){
				        		  if (result.printstatus == true ) { 
				        			 $scope.isPrintLimitExceed = true;
				        			 logger.logError("NOTE: BL print count limit exceeded. Data cannot be modified..!!");
				        		  }else if (result.sailingstatus == true){
				        			  $scope.sailing = true;
				         			 logger.logError("NOTE: Date Range Exceeded From Vessel Sailing..!!");
				        		  }
				        	}
				        	$scope.jobList=[{id : result.jobNo, text : result.jobNo}];	
				        	if(result.terms == "1"){
					        	$scope.blNoData.terms = 'Collect';
				        	}else	if(result.terms == "2"){
					        	$scope.blNoData.terms = 'Prepaid';
				        	}else	if(result.terms == "3"){
					        	$scope.blNoData.terms = 'Third Pary Collect';
				        	}
				        	$scope.blNoData=result;
				             	for(var i=0; i < $scope.blNoData.blcntrDtlList.length;i++){
				             		$scope.blNoData.blcntrDtlList[i].cntrNo=result.blcntrDtlList[i].cntrNo.toString();
				             		$scope.blNoData.blcntrDtlList[i].type=result.blcntrDtlList[i].conType.toString();
				             	}
				            	
				         }).error(function(data) {
				            console.log("data" + data);
				        });
				    
					}		
				$scope.checkBookingFreightInv = function(){


					$scope.pendingBlList = [];
				    $scope.invoiceData = {
				   		 invoiceNo :'',
				   		 blNo : '',
				   		 billDate: '',
				   		 customer: '',
				   		 customerName: '',
				   		 agent : '',
				   		 agentName : '',
				   		 vessel: '',
				   		 vesselName: '',
				   		 voyage: '',
				   		 voyageName: '',
				   		 bookingNo: '',
				   		 total : 0,
				   		 grandTotal: 0,
				   		 quotation : '',
				  		 exchangeRate : 1.0,
				  		 currency : '',
				   		 chargesDetails : [],
				   		 detailList	: []
				    }
				    
					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1;

					var yyyy = today.getFullYear();
					if (dd < 10) {
						dd = '0' + dd;
					}
					if (mm < 10) {
						mm = '0' + mm;
					}
					var today = dd + '/' + mm + '/' + yyyy;
//					$scope.invoiceData.billDate = today;
					
//				    $http.get($stateParams.tenantid+'/app/invoice/pendingBlList').success(function(response) {
//				        $scope.pendingBlList = response.list;
//				    });
				    
					var invoiceNo = $scope.BLnumber;
					
					if(invoiceNo!=null && invoiceNo!=undefined && invoiceNo!=''){
//						  $http.post($stateParams.tenantid+ '/app/invoice/viewDetails',invoiceNo).success(function(data) {
								$http.post($stateParams.tenantid+ '/app/booking/getfreightInv', invoiceNo).success(function(data) {

				    		  if(data.success==true){
				    			  	$scope.invoiceData = data.invoiceBean;
									$scope.invoiceData.chargesDetails =  data.invoiceBean.detailList;
//									$scope.invoiceData.billDate = today;
				    		  }else{
				    			  logger.logError("Invoice Not Allocated...");
				    		  }
				    	  });
					}
				    
				 
				  
				        

				}	
					
				});

app.controller('routingtableCtrl', function($scope,$http, $filter,logger,$stateParams,$location){
	$scope.tenant =  $stateParams.tenantid;

	    $scope.$watch('bookingData.routingData[trIndex1].vessel', function(newValue, oldValue) {
			if (newValue != '' && newValue != undefined) {
			    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
							$scope.bookingData.routingData[$scope.trIndex1].rVoyageList = data;
			    	  });
			}
			
		});
		
	    
	    
		$scope.$watchCollection('[bookingData.routingData[trIndex1].vessel,bookingData.routingData[trIndex1].voyage,bookingData.routingData[trIndex1].toPort]',function(newValue, oldValue) {
			if (newValue[0] != '' && newValue[0] != undefined && newValue[1] != '' && newValue[1] != undefined && newValue[2] != '' && newValue[2] != undefined) {
				  
				console.log(newValue[0]);
				console.log(newValue[1]);
				console.log(newValue[2]);
				
				var trindex=$scope.trIndex1;
				$http.post($stateParams.tenantid+'/app/booking/getEta?vessel=' +newValue[0]+ '&voyage=' +newValue[1] +'&toPort=' +newValue[2]).success(function(data) {
					
					
						$scope.bookingData.routingData[trindex].eta = data.bookingBean.etadate;
				

					
					
					
				});
			}
		});

});
app.controller('quotationtableCtrl', function($scope, $http, $filter, logger,$stateParams) { 
	
	
});


