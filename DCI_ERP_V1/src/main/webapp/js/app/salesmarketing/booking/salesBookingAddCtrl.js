'use strict';
app .controller('salebookingAddCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {
	$scope.pickupList =[];
					$scope.saveCount = 0;
					$scope.vesselList = [];
					$scope.quotationnoList = [];
					$scope.voyageList = [];
					$scope.polList = [];
					$scope.podList = [];
					$scope.mloList = [];
					$scope.agentList = [];
					$scope.payerList = [];
					$scope.lineList = [];
					$scope.containerList = [];
					$scope.modeList= [];
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
					/*$scope.freightList = [
					       {id: '1', text: 'Collect'},
					       {id: '2', text: 'Prepaid'},
					       {id: '3', text: 'Third Party Collect'},
					 ];*/
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
					
					
					/*$scope.cargoTypeList = [
					     {id: '1', text: 'COCO'},
					    {id: '2', text: 'Coir'}
					  ];
					*/
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
					    
					    
						//$scope.dropdown();
					    
					$scope.bookingData = {
						bookingId : '',
						bookingNo : '',pot:'',fpod:'',
						bookingDate : today,
						origin : '',
						vessel : '',picPoint:'',
						voyage : '',
						pol : '',
						cargoType : '',
						customer : '',
						customerName : '',
						pod : '',
						quotation : '',
						destination : '',
						//service : 'COC',
						payer : '',service:'1',
						line : '',
						agent : '',
						quotationDate : '',
						agentParty : '',
						leg:'1',
						pod1:'',
						shipper : '',
						consignee : '',
						fforwarder : '',
						notifyParty : '',
						facParty : '',
						irbParty : '',
						cha : '',
						stuffing : '',
						rLicd : '',
						rPol : '',commodityL:'',
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
						payerName:'',
						
						//						tsData : [],
						boxData : [],
//						jobData : [],
//						chrgData : [],
//						cntrData : []
						routingData : [],addchargeData:[],
						quotationDtl:[{id:0,chargeHeads:'',unit:'',currency:'',qty:'',rate:'',paymentMethod : '',transactionType : '',buySell : '',note : ''}],
						additionalChargesList:[{select:false,chargeType:'',currency:'',rate:'',chargeHeads:''}],
						frightTerms:'',
						bookingType:'1',
						othercharges:''

						
					};
					$scope.addAdditionalRow = function(){
						var tempBoxData = {
								quotationDtlId : '',
								surcharge : '',
								chargeType : '',
								uom : '',
								conType: '',
								addchrgcurrency: '',bookremarks:'',bookingRate:'',bookingqty:'',
								addchrgtax: '',
								rate: '',
								qty: '',
								remarks: '',
								hazardous : false,
								isOog : false
						}
						$scope.bookingData.addchargeData.push( tempBoxData);
					}
					$scope.removequoRow=function(){
						  var data=[];
						  angular.forEach($scope.bookingData.addchargeData, function(value,key){
						  if(value.select==undefined || value.select==false){
							  data.push(value);
						  }
						  })
						  $scope.bookingData.addchargeData=data;
					}
					 var bookingNo1 = $rootScope.bookingNo1;

					 $scope.specialEmployeeFlag = false;
			 		 $scope.userId=$('#empId').val();

			 		 if( $scope.userId == 'E0002'|| $scope.userId =='E0003'||  $scope.userId =='E0006' ||$scope.userId == 'E0001' || $scope.userId=='E0016' || $scope.userId=='E0110'){
			 			 $scope.specialEmployeeFlag = true;
			 		 }
			 		 
					$scope.tempaddit={
						chargeType : '',chargeHeads:'',
						currency : '',
						rate : ''
						
					}
					
					if(bookingNo1!=null && bookingNo1!=undefined){
					$http.post($stateParams.tenantid+ '/app/salesBooking/edit',bookingNo1).success(function(data) {
						$scope.bookingData = data.bookingBean;
						$scope.bookingData.addchargeData=data.lQuotationBean[0].addchargeData;
						angular.forEach($scope.bookingData.addchargeData, function(chargesDetail, index) { 
							chargesDetail.addchrgcurrency=chargesDetail.addchrgcurrency.toString();
						})
						$scope.bookingData.pot=data.bookingBean.pot.toString();
						$scope.bookingData.fpod=data.bookingBean.fpod.toString();
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
					
}
					$scope.boxtemp={

							cntrType:'',
							noOfBox:'',
							commodity:'',
							hazardous:false,
							isOog:false,
							isSoc:false
							
						}
					
					$scope.addRow = function() {
						   
						  var tmpee=angular.copy($scope.tempaddit);
							$scope.bookingData.additionalChargesList.push(tmpee);

					}
					
					
					$scope.addRow1 = function() {
						   
						  var tmpee=angular.copy($scope.boxtemp);
							$scope.bookingData.boxData.push(tmpee);

					}
				 
					$scope.getQuotationType = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "SEA COASTAL";
					    $scope.modeList.push(data);
					     //$scope.bookingData.mode='1';
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
						// data = {};
						// data["id"] = "2";
						// data["text"] = "SEA";
						// $scope.modeList.push(data);
					}
					
					$scope.dropdown=function(){
						$scope.getQuotationType();
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getTerms').success(function(datas) {
							 $scope.TermList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
							debugger
						   // $scope.portList1 = datas.commonUtilityBean;	    

						}).error(function(data) {

						});
						$http.get($stateParams.tenantid+'/app/seaquotation/getpicList').success(function(datas) {
							debugger
						    $scope.pickupList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});
						$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
							debugger
							 $scope.customerDropList = datas.customerList;
							 $scope.consigneeDropList = datas.consigneeList;
							 $scope.shipperDropList = datas.shipperList;
							 $scope.notifyPartyList= datas.shipperList;
							 $scope.nominatedDropList = datas.nominatedList;
							 $scope.vendorDropList = datas.vendorList;
							 $scope.mloList = datas.shipperList;
							 
							// $scope.serviceParnrDropList=datas.serviceParnrList;
						  
						  
						}).error(function(data) {

						});
						
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
							debugger
						    $scope.portList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});
						
						/*$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
							
						    $scope.commodityList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});*/
						$scope.getDropDownListprt = function() {
					        $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data){
					        	$scope.commodityList=data.commonUtilityBean;
					            
					            $timeout(function() { 
					                $("#commodityL").multiselect({
					                    maxHeight: 200,
					                    includeSelectAllOption: true,
					                    selectAllText: 'Select All',
					                    enableFiltering: true,
					                    enableCaseInsensitiveFiltering: true,
					                    filterPlaceholder: 'Search',
					                    onChange: function(element, checked) {
					                        debugger;
					                        var ct=""; 
					                      if($scope.commodityList.length>0){   
					                          $scope.bookingData.commodity ='';
					                         angular.forEach($scope.bookingData.commodityL, function (item, key) {
					                             if(ct==""){
					                                 ct = item.id;
					                             }else{
					                                 ct +=","+ item.id;
					                             }       
					                             $scope.bookingData.commodity = ct;
					                         });
					                      }else{
					                    	  $scope.bookingData.commodity = '';
					                      }
					                    }
					                  });
					                $("#commodityL").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
					                
					                }, 2, false);
					            
					            $timeout(function() { 
					                $("#commodityL").multiselect({
					                    maxHeight: 200,
					                    includeSelectAllOption: true,
					                    selectAllText: 'Select All',
					                    enableFiltering: true,
					                    enableCaseInsensitiveFiltering: true,
					                    filterPlaceholder: 'Search',
					                    onChange: function(element, checked) {
					                        debugger;
					                        var ct=""; 
					                      if($scope.commodityList.length>0){   
					                          $scope.bookingData.commodity ='';
					                         angular.forEach($scope.bookingData.commodityL, function (item, key) {
					                             if(ct==""){
					                                 ct = item.id;
					                             }else{
					                                 ct +=","+ item.id;
					                             }       
					                             $scope.bookingData.commodity = ct;
					                         });
					                      }else{
					                    	  $scope.bookingData.commodity = '';
					                      }
					                    }
					                  });
					                $("#commodityL").parent().find('.btn-group #multiselect-button').addClass('width_100 input-sm line-height-5'); 
					                
					                }, 2, false);
					        }).error(function(data) {
					        });

					    }
					    $scope.getDropDownListprt();
						
						
						/*$http.get($stateParams.tenantid+'/app/seaquotation/getBranch').success(function(datas) {
							 $scope.branchList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						*/
					    $http.post($stateParams.tenantid+'/app/hr/holiday/branchlist').success(function(data) {
					      	
				      		$scope.branchList=data;
				      		        		
				    	});
					    
					    
					    // cargo type List ..... 
						  $http.post($stateParams.tenantid+'/app/commonUtility/cargotype').success(function(data) {
							  	
								$scope.cargoType=data;
								        		
						});
						  $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
								debugger
							    $scope.carrierList = datas.commonUtilityBean;	    
					            //$scope.transList = datas.lCommonUtilityBean;	    

							}).error(function(data) {

							});
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getCurrencyList').success(function(datas) {	  
							$scope.currencylist= angular.copy(datas.commonUtilityBean);
						}).error(function(data) {

						});
						 
						$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {	  
							  $scope.conTypeList=datas.getcontypelist;
							  $scope.contractTypeList=datas.contractType;

						}).error(function(data) {

						});
						
						/*$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerType').success(function(datas) {	  
							$scope.servicePartnerTypelist= angular.copy(datas.commonUtilityBean);
						}).error(function(data) {

						});*/
						
						var serviceList = [ {
				            id : '1',
				            text : 'EXPORT'
				        }, {
				            id : '2',
				            text : 'IMPORT'
				        }]
						
						$scope.servicePartnerTypelist=serviceList;
						
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getEmployeeList').success(function(datas) {
							 $scope.employeeList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid + '/app/airquotation/getSalesList')
						.success(function(datas) {
							$scope.salesTypeList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						
						
					
					 
						var serviceList = [ {
				            id : '1',
				            text : 'EXPORT'
				        }, {
				            id : '2',
				            text : 'IMPORT'
				        }]
						
						$scope.servicePartnerTypelist=serviceList;
						
						$http.get($stateParams.tenantid + '/app/airquotation/getPaymentList')
						.success(function(datas) {
							$scope.PaymentMethodList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						
						$http.get($stateParams.tenantid + '/app/airquotation/getTransactionList')
						.success(function(datas) {
							$scope.transactionTypeList = datas.commonUtilityBean;

						}).error(function(data) {

						});
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getChargeHeads').success(function(datas) {
							 $scope.chargeHeadList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						
						
						$http.get($stateParams.tenantid+'/app/seaquotation/getTerms').success(function(datas) {
							 $scope.TermList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						$http.get($stateParams.tenantid+'/app/seaquotation/getpicList').success(function(datas) {
							debugger
						    $scope.pickupList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});
						$http.get($stateParams.tenantid+'/app/seaquotation/getUnitList').success(function(datas) {
							 $scope.UnitList = datas.commonUtilityBean;
						    
						}).error(function(data) {

						});
						
						
						
					}
					
					$scope.dropdown();
					
					
					
					$scope.removeRow = function() {
						$scope.tablerow = [];
						for (var index = 0 ; index < 1; index++) {
						angular.forEach($scope.bookingData.additionalChargesList,function(row, index) {
									var check = row.select;
									
									if (check == undefined || check == "" ) {
										$scope.tablerow.push(row);
									} else if(index > 0){
										$scope.bookingData.additionalChargesList = $scope.tablerow;

									}
								});
						}
						
 					};
 					
 					
 					$scope.removeRow1 = function() {
						$scope.tablerow = [];
						for (var index = 0 ; index < 1; index++) {
						angular.forEach($scope.bookingData.boxData,function(row, index) {
									var check = row.select;
									
									if (check == undefined || check == "" ) {
										$scope.tablerow.push(row);
									} else if(index > 0){
										$scope.bookingData.boxData = $scope.tablerow;

									}
								});
						}
						
 					};
					/* $scope.$watchCollection('[bookingData.carrier]', function(newValue, oldValue) {
						 if(newValue!=null && newValue!=''){
							 if($scope.bookingData.mode!=null && $scope.bookingData.mode!=''){
							 $http.get($stateParams.tenantid+ '/app/commonUtility/getQuoteApproveList1?carrier='+newValue+'&mode='+$scope.bookingData.mode).success(function(data) {
									$scope.quotationnoList = data;						
								}); 
						 }
						 }
					 });*/
					
					 $scope.$watch('bookingData.voyage', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPortListByVoyage',newValue).success(function(data) {
									$scope.portList1 = data;
					    	  });
					      }
					    });
					 $http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
							debugger
						    $scope.portList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});
		/*				 $scope.$watchCollection('[bookingData.mode]', function(newValue, oldValue) {
							 if(newValue!=null && newValue!=''){
								 $http.get($stateParams.tenantid+ '/app/commonUtility/getQuoteApproveList1?carrier='+$scope.bookingData.carrier+'&mode='+newValue).success(function(data) {
										$scope.quotationnoList = data;						
									}); 
							 
							 }
});*/
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
					 
					 $scope.$watchCollection('[bookingData.pol,bookingData.pod,bookingData.customer]', function(newValue, oldValue) {
						 if($scope.bookingData.pol != null && $scope.bookingData.pol != '' && $scope.bookingData.pol != undefined 
							        && $scope.bookingData.pod != null && $scope.bookingData.pod != '' && $scope.bookingData.pod != undefined
							        && $scope.bookingData.customer != null && $scope.bookingData.customer != '' && $scope.bookingData.customer != undefined
							   ){
							 
							 $http.get($stateParams.tenantid+ '/app/commonUtility/getQuoteApproveList_port?carrier='+$scope.bookingData.carrier+'&mode='+$scope.bookingData.mode+'&customer='+$scope.bookingData.customer+'&pol='+$scope.bookingData.pol+'&pod='+$scope.bookingData.pod).success(function(data) {
									$scope.quotationnoList = data;						
								}); 
							 
						 }
					 });
					 
					 /*$scope.$watchCollection('[bookingData.voyage,bookingData.voyage]', function(newValue, oldValue) {
						 if(newValue[0] != null && newValue[0] != '' && newValue[0] != undefined ){
		 if($scope.bookingData.quotationno != null && $scope.bookingData.quotationno != '' && $scope.bookingData.quotationno != undefined){
							  
							 $http.post($stateParams.tenantid+'/app/salesBooking/ETDcheck',$scope.bookingData).success(function(datas) {
							if(datas.line=='true'){

							}else if(datas.line=='false'){
								 logger.logError('Quotation Validity Expires Before ETD!');

								}
							    

							}).error(function(data) {

							});
					 }else{
						 logger.logError('Please Select Quotation No!');

						 }
					 }
						 
						
					 });*/
					 
		    		  $scope.legCheck = true;
					 /*$scope.$watch('bookingData.leg', function(newValue, oldValue) {
					      if($scope.bookingData.leg != null && $scope.bookingData.leg != '' && $scope.bookingData.leg != undefined ){
					    	  if($scope.bookingData.leg == '1'){
					    		  $scope.legCheck = true;	
					    		  $scope.bookingData.pod1 ='';
					    	  }else if($scope.bookingData.leg == '2'){
					    		  $scope.legCheck = true;	
					    		  $scope.bookingData.pod1 ='';
					    	  }else{
					    		  $scope.legCheck = false;
					    	
					    	  }
					    	  
					      }
					})*/
					 
                 /* $scope.$watch('bookingData.pod1', function(newValue, oldValue) {
					      if($scope.bookingData.pod1 != null && $scope.bookingData.pod1 != '' && $scope.bookingData.pod1 != undefined ){
					    	
					    		  if($scope.bookingData.pod == $scope.bookingData.pod1){
										 logger.logError('POD and POD1 should be different!');
										 $scope.bookingData.pod1 ='';
									 }else if ($scope.bookingData.pol == $scope.bookingData.pod1)
									 {
										 logger.logError('POL and POD1 should be different!');
										 $scope.bookingData.pod1 ='';
									 }else if ($scope.bookingData.destination == $scope.bookingData.pod1)
									 {
										 logger.logError('FPOD and POD1 should be different!');
										 $scope.bookingData.destination ='';
									 }
					    		  
					    	  
					    	  
					      }
					})*/
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
						$scope.polList = data.polList;
     					$scope.podList = data.polList;
					});
					
					
					
					
					
					 $http.post($stateParams.tenantid+'/app/detection/getTariffList').success(function(data) {
					      	
					  		$scope.tariffList=data; 
					  		        		
					     });
				
					 
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getPort').success(function(data) {
 						$scope.polList = data.commonUtilityBean;
      					$scope.podList = data.commonUtilityBean;
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
							//$scope.mloList= data;
							$scope.lineList=data;
							$scope.shipperList= data;
							$scope.consigneeList= data;
							$scope.fFrwdList= data;
							//$scope.notifyPartyList= data;
							$scope.FACPartyList= data;
							$scope.irbPartyList= data;
							$scope.CHAList= data;
							$scope.agentPartyList= data;
							$scope.rSwitchAgentList = data;
						}
					});
					
					
					/*$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
						debugger
						 $scope.customerDropList = datas.customerList;
						 $scope.consigneeDropList = datas.consigneeList;
						 $scope.shipperDropList = datas.shipperList;
						 $scope.nominatedDropList = datas.nominatedList;
						 $scope.vendorDropList = datas.vendorList;
						// $scope.serviceParnrDropList=datas.serviceParnrList;
					  
					  
					}).error(function(data) {

					});*/
					
//					$http.get($stateParams.tenantid+ '/app/salesBooking/getShipConsList').success(function(data) {
//						if(data!=null && data.length>0){
//							$scope.shipperList= data.autoList;
//							$scope.consigneeList= data.autoList;
//						}
//					});
					
					/*$http.get($stateParams.tenantid+ '/app/commonUtility/getCommodityList').success(function(data) {
						if(data!=null && data.length>0){
							$scope.commodityList= data;
						}
					});*/
					
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
						
						//$scope.mloList =[];
						$scope.shipperList= [];
						$scope.consigneeList= [];
						$scope.fFrwdList= [];
						//$scope.notifyPartyList= [];
						var obj ={
								"condition" : "select distinct unnest(ARRAY[customer,shipper,consignee,fforwarder,notify_party]) from booking where booking_no ='"+bookingNo+"'"
						}
						$http.post($stateParams.tenantid+ '/app/commonUtility/getCustomerListFilter',obj).success(function(data1) {
							console.log(data1);
							//$scope.mloList = data1;
							$scope.shipperList = data1;
							$scope.consigneeList = data1;
							$scope.fFrwdList = data1;
							//$scope.notifyPartyList = data1;
						});
						
						
						$http.post($stateParams.tenantid+ '/app/salesBooking/edit',bookingNo).success(function(data) {
							$scope.bookingData.addchargeData=data.bookingBean.addchargeData;
							angular.forEach($scope.bookingData.addchargeData, function(chargesDetail, index) { 
								chargesDetail.addchrgcurrency=chargesDetail.addchrgcurrency.toString();
							})
							$http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) { 
					              $scope.commodityList = data.commonUtilityBean;
					           	 $scope.compaccList = [];
					           	 var valArr = $scope.bookingData.commodity.split(',');
					           	 var i = 0, size = valArr.length;
					           	 for (i; i < size; i++) {
					           	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
					           	 angular.forEach($scope.commodityList, function(value, key) {
					           	 if (valArr[i] == value.id) {
					           	 $scope.compaccList.push(value);
					           	 }
					           	 });
					           	  
					           	 }
					             $scope.bookingData.commodityL = $scope.compaccList;

					           //	$scope.EmployeeMasterData.accessCat = $scope.compaccList;
					           	 $timeout(function() { 
					           		 $("#commodityL").multiselect('destroy');
					           	 $("#commodityL").multiselect({
					           	 maxHeight : 400,
					           	 includeSelectAllOption : true,
					           	 selectAllText : 'Select All',
					           	 enableFiltering : true,
					           	 enableCaseInsensitiveFiltering : true,
					           	 filterPlaceholder : 'Search',
					           	 numberDisplayed: 1,
					           	 });
					           	 }, 3, false);
					           	 $("#multiselect-button").addClass("width_100 input-sm line-height-5");
					           	 
					           	
					           	 
					           	 });
						
											$scope.bookingData = data.bookingBean;
											$scope.bookingData.pot=data.bookingBean.pot.toString();
											$scope.bookingData.fpod=data.bookingBean.fpod.toString();

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
					    	  $http.post($stateParams.tenantid+ '/app/salesBooking/getVoyListByVsl?pol='+$scope.bookingData.pol+'&pod='+$scope.bookingData.pod+'&ves='+newValue).success(function(data) {
									$scope.voyageList = data.voyList;
						    	  })
					      }
					    });
					 
					
					 
					 $http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
						  $scope.shipmentList=datas.getshipmentlist;
						  $scope.portList=datas.getportlist;
						 // $scope.customerDropList=datas.getcustomerlist;
						  $scope.currencyList=datas.getcurrencylist	;
						  $scope.conTypeList=datas.getcontypelist;
						   $scope.chargeTypeList=datas.getchargetypelist
						//logger.logSuccess('Mail Sent Successfully!')
					}).error(function(datas) {

					});
					 
					 
					/* $scope.$watch('bookingData.freight', function(newValue, oldValue) {
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
						 
					 })*/
					 
					  $scope.tempConType="";
					 
						$scope.addBoxData = function(containerType) {
							
							if($scope.tempConType.indexOf(containerType) == -1){
							
							  $scope.boxtemp={

										cntrType:containerType,
										noOfBox:'',
										commodity:'',
										hazardous:false,
										isOog:false,
										isSoc:false
										
									}															
							
							   var tmpee=angular.copy($scope.boxtemp);
								$scope.bookingData.boxData.push(tmpee);
								
								$scope.tempConType= $scope.tempConType+","+containerType;
						}
						}
							
						
						
						
					 $scope.quotationdetailtab = true;
					 
					 $scope.$watch('bookingData.quotationno', function(newValue, oldValue) {
						// if($scope.isEdit != true){
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  if($scope.isEdit != true){
									$scope.edit = true;
									$scope.dropdown();
									$http
											.post($stateParams.tenantid+ '/app/seaquotation/editForBooking',newValue)
											.success(
													function(data) {
														console.log(data);
														debugger
														//$scope.bookingData = data.lQuotationBean[0];
														//$scope.quotation.quotationFreeDaysDtl=data.lQuotationBean[0].quotationFreeDaysDtl[0];

													//	$scope.files=[];
														$scope.bookingData.addchargeData=data.lQuotationBean[0].addchargeData;
														angular.forEach($scope.bookingData.addchargeData, function(chargesDetail, index) { 
															chargesDetail.addchrgcurrency=chargesDetail.addchrgcurrency.toString();
														})
														if(data.lQuotationBean[0].commodity != null && data.lQuotationBean[0].commodity != ''){
															$scope.bookingData.commodity = data.lQuotationBean[0].commodity.toString();
														}
														if(data.lQuotationBean[0].picPoint != null && data.lQuotationBean[0].picPoint != ''){
															$scope.bookingData.picPoint = data.lQuotationBean[0].picPoint.toString();
														}
														
														if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ''){
															$scope.bookingData.service = data.lQuotationBean[0].service.toString();;
														}
														if(data.lQuotationBean[0].salesPerson != null && data.lQuotationBean[0].salesPerson != ''){
															$scope.bookingData.salesPerson = data.lQuotationBean[0].salesPerson.toString();;
														}
														if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ''){

														$scope.bookingData.branch = data.lQuotationBean[0].branch.toString();
														}
														if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != ''){

														$scope.bookingData.mode = data.lQuotationBean[0].mode.toString();
														}
														if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ''){

														$scope.bookingData.pol = data.lQuotationBean[0].aol.toString();
														}
														if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ''){

														$scope.bookingData.pod = data.lQuotationBean[0].aod
																.toString();
														}if(data.lQuotationBean[0].pot != null && data.lQuotationBean[0].pot != ''){

															$scope.bookingData.pot = data.lQuotationBean[0].pot
																	.toString();
															}if(data.lQuotationBean[0].fpod != null && data.lQuotationBean[0].fpod != ''){

																$scope.bookingData.fpod = data.lQuotationBean[0].fpod
																		.toString();
																}
														if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ''){

														$scope.bookingData.term = data.lQuotationBean[0].term
																.toString();
														}
														if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ''){

														$scope.bookingData.origin = data.lQuotationBean[0].origin
																.toString();
														}if(data.lQuotationBean[0].carrier != null && data.lQuotationBean[0].carrier != ''){

															$scope.bookingData.carrier = data.lQuotationBean[0].carrier
																	.toString();
															}
														if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ''){

														$scope.bookingData.destination = data.lQuotationBean[0].destination.toString();
														
														}
														if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ''){

														$scope.bookingData.customer = data.lQuotationBean[0].customer
																.toString();
														}
														if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ''){

														$scope.bookingData.shipper = data.lQuotationBean[0].shipper
																.toString();
														}
														if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ''){

														$scope.bookingData.consignee = data.lQuotationBean[0].consignee
																.toString();
														}
														if(data.lQuotationBean[0].nominatedBy != null && data.lQuotationBean[0].nominatedBy != ''){

														$scope.bookingData.nominatedBy = data.lQuotationBean[0].nominatedBy
																.toString();
														}
														if(data.lQuotationBean[0].vendor != null && data.lQuotationBean[0].vendor != ''){

														$scope.bookingData.vendor = data.lQuotationBean[0].vendor
																.toString();
														}
														if(data.lQuotationBean[0].currency != null && data.lQuotationBean[0].currency != ''){

														$scope.bookingData.currency = data.lQuotationBean[0].currency
																.toString();
														}
														
														if(data.lQuotationBean[0].contractType != null && data.lQuotationBean[0].contractType != ''){

															$scope.bookingData.contractType = data.lQuotationBean[0].contractType.toString();
															
														}
														
														if(data.lQuotationBean[0].salesType != null && data.lQuotationBean[0].salesType != ''){

														$scope.bookingData.salesType = data.lQuotationBean[0].salesType
																.toString();
														}
														if(data.lQuotationBean[0].cargoType != null && data.lQuotationBean[0].cargoType != ''){

															$scope.bookingData.cargoType = data.lQuotationBean[0].cargoType
																	.toString();
															}
														
														$scope.bookingData.boxData=[];
														  $scope.tempConType="";
														
														$scope.bookingData.quotationDtl=data.lQuotationBean[0].quotationDtl;

														for (var i = 0; i < $scope.bookingData.quotationDtl.length; i++) {
															$scope.bookingData.quotationDtl[i].chargeHeads = $scope.bookingData.quotationDtl[i].chargeHeads
																	.toString();
															$scope.bookingData.quotationDtl[i].unit = $scope.bookingData.quotationDtl[i].unit
																	.toString();
															$scope.bookingData.quotationDtl[i].currency = $scope.bookingData.quotationDtl[i].currency
																	.toString();
															
															$scope.bookingData.quotationDtl[i].conType = $scope.bookingData.quotationDtl[i].conType.toString();
															
															$scope.addBoxData($scope.bookingData.quotationDtl[i].conType.toString());
															
															$scope.bookingData.quotationDtl[i].qty = $scope.bookingData.quotationDtl[i].qty.toString();
															
															$scope.bookingData.quotationDtl[i].rate = $scope.bookingData.quotationDtl[i].rate.toString();
															
															$scope.bookingData.quotationDtl[i].note = $scope.bookingData.quotationDtl[i].note.toString();
															
															$scope.bookingData.quotationDtl[i].transactionType = $scope.bookingData.quotationDtl[i].transactionType
																	.toString();
															$scope.bookingData.quotationDtl[i].buySell = $scope.bookingData.quotationDtl[i].buySell
																	.toString();
														}
														
														
														$scope.bookingData.quotationFreeDaysDtl=data.lQuotationBean[0].quotationFreeDaysDtl;
														
														 
														 
														 /*bean.push($scope.quotation.files);*/
													//	$scope.bookingData.quotationFreeDaysDtl=data.lQuotationBean[0].quotationFreeDaysDtl;
														//rowCollectionNew=$scope.quotation.quotationFreeDaysDtl;
														 $http.post($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(data) { 
												              $scope.commodityList = data.commonUtilityBean;
												           	 $scope.compaccList = [];
												           	 var valArr = $scope.bookingData.commodity.split(',');
												           	 var i = 0, size = valArr.length;
												           	 for (i; i < size; i++) {
												           	// $("#port").find("option[label=" + valArr[i] + "]").prop("selected", "selected");
												           	 angular.forEach($scope.commodityList, function(value, key) {
												           	 if (valArr[i] == value.id) {
												           	 $scope.compaccList.push(value);
												           	 }
												           	 });
												           	  
												           	 }
												             $scope.bookingData.commodityL = $scope.compaccList;

												           //	$scope.EmployeeMasterData.accessCat = $scope.compaccList;
												           	 $timeout(function() { 
												           		 $("#commodityL").multiselect('destroy');
												           	 $("#commodityL").multiselect({
												           	 maxHeight : 400,
												           	 includeSelectAllOption : true,
												           	 selectAllText : 'Select All',
												           	 enableFiltering : true,
												           	 enableCaseInsensitiveFiltering : true,
												           	 filterPlaceholder : 'Search',
												           	 numberDisplayed: 1,
												           	 });
												           	 }, 3, false);
												           	 $("#multiselect-button").addClass("width_100 input-sm line-height-5");
												           	 
												           	
												           	 
												           	 });
													});
								    }
					    		   $http.post($stateParams.tenantid+'/app/seaquotation/editForBooking',newValue).success(function(datas) {
					    			   $scope.bookingData.quotationDtl=datas.lQuotationBean[0].quotationDtl;

										for (var i = 0; i < $scope.bookingData.quotationDtl.length; i++) {
											$scope.bookingData.quotationDtl[i].chargeHeads = $scope.bookingData.quotationDtl[i].chargeHeads
											.toString();
									$scope.bookingData.quotationDtl[i].unit = $scope.bookingData.quotationDtl[i].unit
											.toString();
									$scope.bookingData.quotationDtl[i].currency = $scope.bookingData.quotationDtl[i].currency
											.toString();
									
									$scope.bookingData.quotationDtl[i].conType = $scope.bookingData.quotationDtl[i].conType.toString();
									
									$scope.bookingData.quotationDtl[i].qty = $scope.bookingData.quotationDtl[i].qty.toString();
									
									$scope.bookingData.quotationDtl[i].rate = $scope.bookingData.quotationDtl[i].rate.toString();
									
									$scope.bookingData.quotationDtl[i].note = $scope.bookingData.quotationDtl[i].note.toString();
									
									$scope.bookingData.quotationDtl[i].transactionType = $scope.bookingData.quotationDtl[i].transactionType
											.toString();
									$scope.bookingData.quotationDtl[i].buySell = $scope.bookingData.quotationDtl[i].buySell
											.toString();
									
								}
										
										$scope.bookingData.quotationFreeDaysDtl=datas.lQuotationBean[0].quotationFreeDaysDtl;


 					    		
					    		}).error(function(datas) {

					    		});
					    	  
					      }else{
					    	  $scope.bookingData.quotationDate = '';
								$scope.bookingData.freeDays = 0;
					      }
					 
					    });
					 
				
					 
					 
					/* $scope.$watch('bookingData.customer', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  if($scope.isEdit != true)
					    	  $scope.bookingData.shipper=newValue
					      }
					    });*/
					 
					 
					
					 
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
									bookingNo : '',picPoint:'',
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
									//service : 'COC',
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
									rSwitchPort : '',addchargeData:[],
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
									bookingNo : '',picPoint:'',
									bookingDate : today,
									origin : '',
									vessel : '',
									voyage : '',
									pol : '',
									customer : '',
									customerName : '',pot:'',fpod:'',
									pod : '',
									quotation : '',
									destination : '',
									//service : 'COC',
									payer : '',
									line : '',
									leg:'',
									pod1:'',
									agent : '',
									quotationDate : '',
									agentParty : '',
									shipper : '',
									consignee : '',addchargeData:[],
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
					
					
					
					//select 
					$scope.selectallRec = function(selection) {
						angular.forEach($scope.bookingData.boxData, function(
								value, key) {
							debugger;
							if (selection)
								value.select = true;
							else {
								value.select = false;
							}
						});
					}
					
					
					//select2
					
					
					$scope.selectallRec1 = function(selection) {
						angular.forEach($scope.bookingData.quotationDtl, function(
								value, key) {
							debugger;
							if (selection)
								value.select = true;
							else {
								value.select = false;
							}
						});
					}
					
					
					
					//select3
					
					
					$scope.selectallRec3 = function(selection) {
						angular.forEach($scope.bookingData.additionalChargesList
							, function(
								value, key) {
							debugger;
							if (selection)
								value.select = true;
							else {
								value.select = false;
							}
						});
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
								$http.post($stateParams.tenantid+'/app/salesBooking/deleteDtl',tmpDelList[i].bookingDtlId).success(function(data) {
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
									$http.post($stateParams.tenantid+'/app/salesBooking/deleteBkRouting',tmpDelList[i].bookingRoutingId).success(function(data) {
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
							/*if(pod == rb.bookingBean.destination){
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
							}*/
							type =true;
							if(type){
								 $scope.check = true;
								 if(rb.bookingBean.voyage != null && rb.bookingBean.voyage != '' && rb.bookingBean.voyage != undefined && rb.bookingBean.quotationno != null && rb.bookingBean.quotationno != '' && rb.bookingBean.quotationno != undefined){
														  
														 $http.post($stateParams.tenantid+'/app/salesBooking/ETDcheck',$scope.bookingData).success(function(datas) {
														if(datas.line=='true'){

															var commodity='';
												        	angular.forEach(rb.bookingBean.commodityL, function(item, index) {
											                	if(commodity!=null && commodity!=''){
											                    	commodity=commodity+','+item.id;
										                      }else{
											                    	commodity=item.id;
											                	}
											                	
											                })
											                var l=1;var cond=true;var msg="";
											               rb.bookingBean.commodity=commodity;
												        	 angular.forEach(rb.bookingBean.addchargeData, function(val, index) {
													            	if(val.uom=='1'){
													            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
													            			
													            		}else{
																			msg=msg+"Local Charges Row "+l+" Container Type is Required! ";
													            			cond=false;
													            			
													            		}
													            	}l++;
													            })	
												if(cond==true){	            
								$http .post( $stateParams.tenantid + '/app/salesBooking/save', rb) .success(	function(data) {
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
								});	}else{
									logger.logError(msg);
								}
														}else if(datas.line=='false'){
															 logger.logError('Quotation Validity Expires Before ETD!');

															}else if(datas.line=='error'){
															 logger.logError('Port is not available in the Selected Voyage!');

															}
							})
								 }
						}}else{
							logger.logError("Already saved!");
							$scope.check = false;
						}
					}
					
					$scope.updateFinal = function(rb){
						$scope.check = true;
						var commodity='';
			        	angular.forEach(rb.bookingBean.commodityL, function(item, index) {
		                	if(commodity!=null && commodity!=''){
		                    	commodity=commodity+','+item.id;
	                      }else{
		                    	commodity=item.id;
		                	}
		                	
		                })
		               rb.bookingBean.commodity=commodity;
			        	var l=1;var cond=true;var msg="";
				        	 angular.forEach(rb.bookingBean.addchargeData, function(val, index) {
					            	if(val.uom=='1'){
					            		if(val.conType!=null && val.conType!='' &&val.conType!=undefined){
					            			
					            		}else{
											msg=msg+"Local Charges Row "+l+" Container Type is Required! ";
					            			cond=false;
					            			
					            		}
					            	}l++;
					            })	
				if(cond==true){	  
						$http .post( $stateParams.tenantid + '/app/salesBooking/update', rb) .success(	function(data) {
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
				}else{
					logger.logError(msg);
				}
					
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
					        if ($scope.checkundefined(chargesDetail.commodity)) {
					            msg = msg + "<li>Row :" + (index + 1) + "# commodity :Field is required.</li>";
					            $scope.changecolor('commodity'+index);
					        }else{
					        	$scope.clearcolor('commodity'+index);
					        }
					        
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
									
										$scope.updateFinal(rb);
									
								}else{
									
										$scope.saveFinal(rb);
									
									
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
						$state.go('app.salesmarketing.salebooking.list', {
							tenantid : $stateParams.tenantid
						});
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
				$http.post($stateParams.tenantid+'/app/salesBooking/getEta?vessel=' +newValue[0]+ '&voyage=' +newValue[1] +'&toPort=' +newValue[2]).success(function(data) {
					
					
						$scope.bookingData.routingData[trindex].eta = data.bookingBean.etadate;
				

					
					
					
				});
			}
		});

});

app.controller('quotationtableCtrl', function($scope, $http, $filter, logger,$stateParams) {
	 $scope.$watch('bookingData.quotationDtl[trIndex].transactionType', function(newValue, oldValue) {
		 var id = newValue;
		 debugger;
		 $http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			 
				if(newValue==1){
				 
				 $scope.serviceParnrDropList=datas.vendorMasterList;
			 }else if(newValue==2){
				 $scope.serviceParnrDropList=datas.serviceParnrList;

			 }
			}).error(function(data) {

			});
	  });
});

