/*'use strict';*/
app .controller(
				'bookingToolCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,$timeout,
						validationService, toaster, $controller, $injector) {

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
							soc : false,
							frightTerms:'',
							bookingType:'1',
							othercharges:'',
							stuffingLocation:'',
							agentbrn:'',
							shipperCode:'',
							shipperNamee:'',
							cfAgentCode:'',	
							cfAgentName:'',
							haulierCode:'',
							haulierName:'',
							rotationNo:'',
							linecode:'',
							fportdDischarge:'',
							fportName:'',
							sportDischarge:'',
							sportName:'',
							finalDesti:'',
							finalPort:'',
							deliveyTerminal:'',
							exportReceive:'',
							expiryDate:'',
							mtyavailable:'',
						    orgin:'',
							cnNo :'',
							etdsailDate:'',
							cutoffDate:'',
							etasailDate:'',
							exchangeRate:'',
							currency:'',
							connectvoyage:'',
							connectvessel:'',
							isemptyRepo:'',
							emptyRepo:'',
							depot :'',
							crovalidDate:'',
							hsCode:'',
							boxData : [],
							addchargeData : [],
							routingData : [],
							containerDtlList:[],
						
					};
					
					
					$scope.fromBookingData = {
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
							soc : false,
							frightTerms:'',
							bookingType:'1',
							othercharges:'',
							stuffingLocation:'',
							agentbrn:'',
							shipperCode:'',
							shipperNamee:'',
							cfAgentCode:'',	
							cfAgentName:'',
							haulierCode:'',
							haulierName:'',
							rotationNo:'',
							linecode:'',
							fportdDischarge:'',
							fportName:'',
							sportDischarge:'',
							sportName:'',
							finalDesti:'',
							finalPort:'',
							deliveyTerminal:'',
							exportReceive:'',
							expiryDate:'',
							mtyavailable:'',
						    orgin:'',
							cnNo :'',
							etdsailDate:'',
							cutoffDate:'',
							etasailDate:'',
							exchangeRate:'',
							currency:'',
							connectvoyage:'',
							connectvessel:'',
							isemptyRepo:'',
							emptyRepo:'',
							depot :'',
							crovalidDate:'',
							hsCode:'',
							boxData : [],
							addchargeData : [],
							routingData : [],
							containerDtlList:[],
						
					};
					
					
					$scope.toBookingData = {
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
							soc : false,
							frightTerms:'',
							bookingType:'1',
							othercharges:'',
							stuffingLocation:'',
							agentbrn:'',
							shipperCode:'',
							shipperNamee:'',
							cfAgentCode:'',	
							cfAgentName:'',
							haulierCode:'',
							haulierName:'',
							rotationNo:'',
							linecode:'',
							fportdDischarge:'',
							fportName:'',
							sportDischarge:'',
							sportName:'',
							finalDesti:'',
							finalPort:'',
							deliveyTerminal:'',
							exportReceive:'',
							expiryDate:'',
							mtyavailable:'',
						    orgin:'',
							cnNo :'',
							etdsailDate:'',
							cutoffDate:'',
							etasailDate:'',
							exchangeRate:'',
							currency:'',
							connectvoyage:'',
							connectvessel:'',
							isemptyRepo:'',
							emptyRepo:'',
							depot :'',
							crovalidDate:'',
							hsCode:'',
							boxData : [],
							addchargeData : [],
							routingData : [],
							containerDtlList:[],
						
					};
					
					$scope.modeList=[];
					$scope.getQuotationType = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "SEA COASTAL";
					    $scope.modeList.push(data);
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
					
					
					
					 
					 
					
					$scope.addBxRow = function(){
						var tempBoxData = {
								bookingDtlId : '',
								cntrType : '',
								noOfBox : '',
								commodity : '',
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
								isOOG : false
						}
						$scope.bookingData.cntrData.push( tempCntrData);
					}
					
					
					$scope.addcntrList = function(){
						var cntrdtlList = {
								select:false,
								cntrNo : '',
								type : '',
								jobNo : '',
								bookingNo : '',
								containerNumber : '',
								gateOutNo :'',
								gateOutDtlid:'',
								croNo:''
								
						}
						$scope.bookingData.containerDtlList.push( cntrdtlList);
					}
					
					$scope.$watch('bookingData.mode', function(newValue, oldValue) {
						if (newValue != '' && newValue != undefined && newValue != null) {
							$scope.bookingNoList= [];
					$http.post($stateParams.tenantid+ '/app/bookingtool/getBookingNumberList',newValue).success(function(data) {
				//	$http.get($stateParams.tenantid+ '/app/bookingtool/getBookingNumberList').success(function(data) {
						if(data!=null && data.length>0){
							$scope.bookingNoList= data;
						}
					});
						}else{
							
							
							$scope.bookingNoList= [];
						}
					
					});
					
					$scope.$watch('fromBookingData.mode', function(newValue, oldValue) {
						if (newValue != '' && newValue != undefined && newValue != null) {
					
					$http.post($stateParams.tenantid+ '/app/bookingtool/getMergeBookingNumberList',newValue).success(function(data) {
					//$http.get($stateParams.tenantid+ '/app/bookingtool/getMergeBookingNumberList').success(function(data) {
						$scope.fromBookingNoList=[];
						if(data!=null && data.length>0){
							$scope.fromBookingNoList= data;
						}
					});
					
						}else{
							
							$scope.fromBookingNoList=[];
							
						}	
						
					
					});
					
					$scope.containerCount = true;
					$scope.searchBooking = function(bookingNumber) {
						if (bookingNumber != '' && bookingNumber != undefined && bookingNumber != null) {
							$http.post($stateParams.tenantid+ '/app/bookingtool/getvalues',bookingNumber).success(function(data) {
								if(data.success){
									$scope.bookingData = data.bookingBean;
									$scope.bookingData.containerDtlList = data.blContainerDatalist;
								
									if (data.blContainerDatalist.length == 0){
									$scope.containerCount = false;
								}else{
									$scope.containerCount = true;
								}
								}else{
									logger.logError(data.message);
								}
								
							});
						} else {
							logger.logError('Please Select the Booking Number!');
						}
						$scope.searchSrc = true;
					};
					
					
					
					$scope.$watch('fromBookingData.bookingNo', function(newValue, oldValue) {
						

						if (newValue != '' && newValue != undefined && newValue != null) {
							$http.post($stateParams.tenantid+ '/app/bookingtool/getvaluesFromBook',newValue).success(function(data) {
								if(data.success){
									
									$scope.fromBookingData = data.bookingBean;
									$scope.fromBookingData.containerDtlList = data.blContainerDatalist;
									$scope.toBookingNoList = data.bookingList;
								
								}else{
									logger.logError(data.message);
								}
								
							});
						} else {
							//logger.logError('Please Select the From Booking Number!');
						}
						
					});
					
					
					
					$scope.$watch('toBookingData.bookingNo', function(newValue, oldValue) {
						

						if (newValue != '' && newValue != undefined && newValue != null) {
							$http.post($stateParams.tenantid+ '/app/bookingtool/getvaluesToBook',newValue).success(function(data) {
								if(data.success){
									$scope.toBookingData = data.bookingBean;
									//$scope.toBookingNoList.containerDtlList = data.blContainerDatalist;
							
								}else{
									logger.logError(data.message);
								}
								
							});
						} else {
							//logger.logError('Please Select the To Booking Number!');
						}
						
					});
					
					
					  $scope.temp = {
							  bookingData :{},
							  selectContainerDtl : [],
							  unSelectContainerDtl : [],

				         };
					  $scope.bookingData;
					  $scope.tempShow=false;
						 
					  $scope.save = function(bookingtool) {
						  
							$scope.selectContainerDtl =[];
							$scope.unSelectContainerDtl = [];

							for(var i=$scope.bookingData.containerDtlList.length-1;i>=0;i--){
								if($scope.bookingData.containerDtlList[i].select ==false){
									$scope.temp.unSelectContainerDtl.push($scope.bookingData.containerDtlList[i]);
								}
							}
							
							for(var i=$scope.bookingData.containerDtlList.length-1;i>=0;i--){
								if($scope.bookingData.containerDtlList[i].select){
									$scope.temp.selectContainerDtl.push($scope.bookingData.containerDtlList[i]);
								}
							}
							
							if($scope.bookingData.containerDtlList.length > 1){
							if($scope.temp.selectContainerDtl.length > 0){
								
							var rb = {
									bookingToolbean : $scope.bookingData,
									selectContainerDtl : $scope.temp.selectContainerDtl,
									unSelectContainerDtl : $scope.temp.unSelectContainerDtl
							}
							$scope.check = true;
						$http.post($stateParams.tenantid+'/app/bookingtool/insert',rb).success(function(result) {
							console.log("result" + result);
							if (result.success) {
								$scope.tempList=result.autoList;
								logger.logSuccess(result.message);
								$scope.bookingData ={};
								  $scope.selectContainerDtl = [];
								  $scope.unSelectContainerDtl = [];
								  $scope.bookingData.containerDtlList = [];
 								$scope.tempShow=true;
								//  $timeout( function(){
									//  $scope.tempShow=false;
							       // }, 6000 );
								$scope.noCnfrm();
									  
							} else {
								logger.logError(result.message);
								 $scope.check = false;
								 
										  $scope.bookingData ={};
										  $scope.selectContainerDtl = [];
										  $scope.unSelectContainerDtl = [];
										  $scope.bookingData.containerDtlList = [];

							         
							}
						
						
						}).error(function(result) {
							console.log("data" + result);
						});
						
						}else{
							logger.logError('Please Select the Container Number to Split...!');
						}
					  }else{
							logger.logError('Cannot split, only one container in this booking');
						}
						
					
					}
					  
					  
					  $scope.merge = function(bookingtool) {

						  $scope.chk=false; 
						  
						  if (($scope.fromBookingData.bookingNo != '' && $scope.fromBookingData.bookingNo != undefined && $scope.fromBookingData.bookingNo != null) && 
								  ($scope.toBookingData.bookingNo != '' && $scope.toBookingData.bookingNo != undefined && $scope.toBookingData.bookingNo != null)) {
							  
							  $scope.chk=true; 
						  }
						
							if($scope.chk){
								
							var rb = {
									fromBookingNo:$scope.fromBookingData.bookingNo,
									toBookingNo:$scope.toBookingData.bookingNo
							}
							
						$http.post($stateParams.tenantid+'/app/bookingtool/merge',rb).success(function(result) {
							console.log("result" + result);
							if (result.success) {
								logger.logSuccess(result.message);
								  $scope.fromBookingData ={};
								  $scope.toBookingData ={};
								  $scope.fromBookingData.bookingNo ='';
								  $scope.toBookingData.bookingNo ='';
									  
							} else {
								logger.logError(result.message);
							}
						
						
						}).error(function(result) {
							console.log("data" + result);
						});
						
						}else{
							logger.logError('Please select the From Booking no. and To Booking no. to Merge...!');
						}
					
					}
					  
					    $scope.cancel = function() {
					        $location.path("{tenantid}/dashboard/dashboard");
					    };
					
					
					 
				});
 


