/*'use strict';*/
app .controller(
				'dischargeAddCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {

					$scope.rowCollection = [];
					$scope.displayedCollection = [];

					$scope.vesselList = [];
					$scope.voyageList = [];
					$scope.terminalList = [];


					$scope.discharge = {
							vessel : '',
							voyage : '',
							port : '',
							terminal : '',
							arrivalDate : '',
							dischargeDate:'',
							detailDate:'',
							created_by: '',
				            created_date : '',
				          modified_by: '',
				       modified_date: '',
							detailList : [],count:[],
							mode:'',carrier:''
					
						
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
				
									
					
					//vessel
					
					$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
						$scope.vesselList = data;
					});
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
					    data["text"] = "Forwarding";
					    $scope.modeList.push(data);
					}
					$scope.getQuotationType();
					
					
					$http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
						debugger
					    $scope.carrierList = datas.commonUtilityBean;	    
				        //$scope.transList = datas.lCommonUtilityBean;	    

					}).error(function(data) {

					});
//                    //terminal
//					
//					$http.get($stateParams.tenantid+ '/app/commonUtility/getTerminal').success(function(data) {
//						$scope.terminalList = data.commonUtilityBean;
//					});
			

					$scope.selectall= function(selection){
				      	angular.forEach($scope.discharge.detailList,function(value,key) {
				      		debugger;
				      		if( selection)
				      		value.select1=true;
				      		else{
				      			value.select1=false;
				      		}
				  });
				      }
					
					$scope.selectall(true);
					
					$scope.selectallTransit= function(selectionTransit){
				      	angular.forEach($scope.discharge.detailList,function(value,key) {
				      		debugger;
				      		if( selectionTransit)
				      		value.isTransit=true;
				      		else{
				      			value.isTransit=false;
				      		}
				  });
				      }
					$scope.apply = function(detailDate){
						for(var i=0;i<$scope.discharge.detailList.length;i++){
		                	 $scope.discharge.detailList[i].dischargeStatusDate = detailDate;

						}
			               // 	 $scope.rowCollection.detailDate1 = detailDate;
					
					}
					
					 $scope.$watch('discharge.vessel', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
									$scope.voyageList = data;
					    	  });
					      }
					    });
					 
					 $scope.portList=[];
					 debugger
					 $scope.$watch('discharge.voyage', function(newValue, oldValue) {
						 if(!$scope.isEdit){
						 $scope.discharge.port="";
						 $scope.discharge.arrivalDate="";
						 }
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  
					    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPortListByVoyage',newValue).success(function(data) {
									$scope.portList = data;
					    	  });
					      }
					    });
					 
					 
					 
					 
					 //port-arrival date
					 $scope.$watch('discharge.port', function(newValue,
								oldValue) {
if ($scope.isEdit != true) {
							if (newValue != '' && newValue != undefined) {

								$http.post($stateParams.tenantid + '/api/discharge/portdropdown',$scope.discharge).success(
										function(datas) {
											$scope.port = datas; 
											$scope.discharge.arrivalDate = datas.dischargeBean.arrivalDate;
									$scope.terminalList = datas.listTerminalList;

										}).error(function(data) {
									logger.logError("Unable to fetch");
								});

							}}
						});
					 
					 $scope.$watch('[discharge.dischargeDate]', function(newValue,oldValue) {
							if (newValue != '' && newValue != undefined) {
								
								if($scope.discharge.port != '' && $scope.discharge.port != null && $scope.discharge.port !=undefined){
									
									if($scope.discharge.port.substring(0,2) == 'AE'){
										
										var today = new Date();
										var tomorrow = moment(today).add(2, 'days');
										var twoDays = new Date(tomorrow);
											var dd = twoDays.getDate();
											var mm = twoDays.getMonth() + 1; //January is 0!

											var yyyy = twoDays.getFullYear();
											if (dd < 10) {
											  dd = '0' + dd;
											} 
											if (mm < 10) {
											  mm = '0' + mm;
											} 
											var twoDayDate = dd + '/' + mm + '/' + yyyy;
											
											var dayDiff = moment(twoDayDate, "DD/MM/YYYY").diff(moment($scope.discharge.dischargeDate, "DD/MM/YYYY"),'day')
									        if ( dayDiff < 0 ) { 
									        	$scope.discharge.dischargeDate="";
									        	logger.logError("Discharge Date cannot be later than 2 days from today..!!");
									        }
										
									}else{
										var today = new Date();
 											var dd = today.getDate();
											var mm = today.getMonth() + 1; //January is 0!

											var yyyy = today.getFullYear();
											if (dd < 10) {
											  dd = '0' + dd;
											} 
											if (mm < 10) {
											  mm = '0' + mm;
											} 
											var twoDayDate = dd + '/' + mm + '/' + yyyy;
											
											var dayDiff = moment(twoDayDate, "DD/MM/YYYY").diff(moment($scope.discharge.dischargeDate, "DD/MM/YYYY"),'day')
									        if ( dayDiff < 0 ) { 
									        	$scope.discharge.dischargeDate="";
									        	logger.logError("Discharge Date cannot be later than  today..!!");
									        }
									}
								}else{
									logger.logError("Please select the Port..!!");
									$scope.discharge.dischargeDate="";
								}
							

							}
						});
					 
					 $scope.$watch('[discharge.detailDate]', function(newValue,oldValue) {
							if (newValue != '' && newValue != undefined) {
								
							if($scope.discharge.port != '' && $scope.discharge.port != null && $scope.discharge.port !=undefined){
									
									if($scope.discharge.port.substring(0,2) == 'AE'){
										
										var today = new Date();
										var tomorrow = moment(today).add(2, 'days');
										var twoDays = new Date(tomorrow);
											var dd = twoDays.getDate();
											var mm = twoDays.getMonth() + 1; //January is 0!

											var yyyy = twoDays.getFullYear();
											if (dd < 10) {
											  dd = '0' + dd;
											} 
											if (mm < 10) {
											  mm = '0' + mm;
											} 
											var twoDayDate = dd + '/' + mm + '/' + yyyy;
											
											var dayDiff = moment(twoDayDate, "DD/MM/YYYY").diff(moment($scope.discharge.detailDate, "DD/MM/YYYY"),'day')
									        if ( dayDiff < 0 ) { 
									        	$scope.discharge.detailDate="";
									        	logger.logError("Discharge Date cannot be later than 2 days from today..!!");
									        }
									
									}else{
										
										var today = new Date();
 											var dd = today.getDate();
											var mm = today.getMonth() + 1; //January is 0!

											var yyyy = today.getFullYear();
											if (dd < 10) {
											  dd = '0' + dd;
											} 
											if (mm < 10) {
											  mm = '0' + mm;
											} 
											var twoDayDate = dd + '/' + mm + '/' + yyyy;
											
											var dayDiff = moment(twoDayDate, "DD/MM/YYYY").diff(moment($scope.discharge.detailDate, "DD/MM/YYYY"),'day')
									        if ( dayDiff < 0 ) { 
									        	$scope.discharge.detailDate="";
									        	logger.logError("Discharge Date cannot be later than  today..!!");
									        }
										
										}
								
							}else{
								logger.logError("Please select the Port..!!");
								$scope.discharge.dischargeDate="";
							}
							

							}
						});
					 
					 app.controller('dischargetableCtrl', function($scope, $http, $filter, logger,	$stateParams) {
							$scope.$watchCollection('[discharge.detailList[trIndex].dischargeStatusDate]', function(newValue, oldValue) {
							 
								//alert("jhjhj");
								if($scope.discharge.detailList[$scope.$index].dischargeStatusDate != null && $scope.discharge.detailList[$scope.$index].dischargeStatusDate != '' ){
									var today = new Date();
									var tomorrow = moment(today).add(2, 'days');
									var twoDays = new Date(tomorrow);
									var dd = twoDays.getDate();
									var mm = twoDays.getMonth() + 1; //January is 0!

									var yyyy = today.getFullYear();
									if (dd < 10) {
									  dd = '0' + dd;
									} 
									if (mm < 10) {
									  mm = '0' + mm;
									} 
									var twoDayDate = dd + '/' + mm + '/' + yyyy; 
									noOfDays = moment(twoDayDate, 'DD/MM/YYYY').diff(moment($scope.discharge.detailList[$scope.$index].dischargeStatusDate, 'DD/MM/YYYY'), 'days');
									 if(noOfDays<0){
										 logger.logError("Discharge Date Cannot Be Greater Than the Current Date..!!");
										 $scope.discharge.detailList[$scope.$index].dischargeStatusDate = "";
									 }	 
								  
								}
							});
						});
					 
//					 
// $scope.removeCredRow = function() {
//	 $scope.detailList.disabled=true;	 
//					 }		 
//							
					 
						//save data
					$scope.saveData = function() {
								if (new validationService().checkFormValidity($scope.vessselArrivalForm)) {
									var selectstatus = false;
									var tmpDelList = [];
									for(var i=$scope.discharge.detailList.length-1;i>=0;i--){
										if($scope.discharge.detailList[i].select1==true){
											selectstatus = true;
											tmpDelList.push($scope.discharge.detailList[i]);
										}
									}
								$scope.rowCollection = tmpDelList;
								$scope.discharge.detailList;
								var obj={
										bean:$scope.discharge,
										detailList:$scope.rowCollection
								};
								
								if(selectstatus== false){
									
									logger.logError("Please select atleast one Row");
									
								}
								
								var test;
								for(var i=0;i<obj.detailList.length;i++){
									
									if(obj.detailList[i].dischargeStatusDate != null && obj.detailList[i].dischargeStatusDate != '' ){
										if(test == null && test == undefined){
											test = "true";
										}else{
											test = test + "," + "true";
										}
											
									}else{
										logger.logError("Row ("+obj.detailList[i].slno+") Please Fill the Discharge Status Date for Selected Container's !!!");
										$scope.check1 = false;
										if(test == null && test == undefined){
											test = "false";
										}else{
											test = test + "," + "false";
										}
									}
								}
									
								
								var check =  test.split(",").includes("false") ? false : true ;
									console.log(check);
									if(check == false){
									}else{
										var test1;
										for(var i=0;i<obj.detailList.length;i++){
									
											var frmDate = obj.detailList[i].previousStatusDate;
											var toDate = obj.detailList[i].dischargeStatusDate;
											var splitarray = new Array();
											var splitarray1 = new Array();
											splitarray = frmDate.split(" ");
											var date = splitarray[0];
											var time = splitarray[1];

											frmDate = date.split("/");
											frmDate = new Date(frmDate[2],frmDate[1] - 1, frmDate[0]);


											splitarray1 = toDate.split(" ");
											var date1 = splitarray1[0];
											var time1 = splitarray1[1];


											toDate = date1.split("/");
											toDate = new Date(toDate[2],toDate[1] - 1, toDate[0]);
											if (toDate  >= frmDate) {
												if(test1 == null && test1 == undefined){
													test1 = "true";
												}else{
													test1 = test1 + "," + "true";
												}											
											}else{
												logger.logError("Row ("+i+1+") Discharge Date Should be Greater than OnBoard Date !!!");
												$scope.check1 = false;
												if(test1 == null && test1 == undefined){
													test1 = "false";
												}else{
													test1 = test1 + "," + "false";
												}
											}											
										}
										var check1 =  test1.split(",").includes("false") ? false : true ;
										console.log(check1);
										if(check1 == false){
										
										}else{
											$scope.check1 = true;
								$http.post($stateParams.tenantid+'/api/discharge/saveDetail',obj).success(function(data) {
									console.log(data);
					                if(data.isSuccess==true){
					                	 logger.logSuccess("Discharge Successfully!");
					                	/* if(data.Successs==true){
						                	 logger.logSuccess("The BL data Imported Successfully for Nasir!");
					                	 }else{
					                		 logger.logError("The BL No. is already Exist for Nasir");
					                	 }*/
					                     $state.go("app.operation.discharge.list",{tenantid:$stateParams.tenantid});

					                }else{
					                	 logger.logError("Cannot Discharge");
					                	 $scope.check1 = false;
					                }
					            })
									}
									}
								}else {
									$scope.check1 = false;
						toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.vessselArrivalForm.$validationSummary), 555000, 'trustedHtml');
						}
							};
							
							$scope.update = function() {
								if (new validationService().checkFormValidity($scope.vessselArrivalForm)) {

//									
									
									var tmpDelList = [];
									for(var i=$scope.rowCollection.length-1;i>=0;i--){
										if($scope.rowCollection[i].select1==true){
											tmpDelList.push($scope.rowCollection[i]);
										}
									}
								$scope.rowCollection = tmpDelList;
								$scope.discharge.detailList;
								var obj={
										bean:$scope.discharge,
										detailList:$scope.rowCollection
								};
								var test;
								for(var i=0;i<obj.detailList.length;i++){
									
									if(obj.detailList[i].dischargeStatusDate != null && obj.detailList[i].dischargeStatusDate != '' ){
										if(test == null && test == undefined){
											test = "true";
										}else{
											test = test + "," + "true";
										}
											
									}else{
										logger.logError("Row ("+(i+1)+") Please  Fill the Discharge Status Date for Selected Container's !!!");
										$scope.check1 = false;
										if(test == null && test == undefined){
											test = "false";
										}else{
											test = test + "," + "false";
										}
									}
								}
								
								var check =  test.split(",").includes("false") ? false : true ;
									console.log(check);
									if(check == false){
									}else{
										$scope.check1 = true;
								$http.post($stateParams.tenantid+'/api/discharge/updateDetail',obj).success(function(data) {
									console.log(data);
					                if(data.isSuccess==true){
					                	 logger.logSuccess("Discharge Successfully!");
					                     $state.go("app.operation.discharge.list",{tenantid:$stateParams.tenantid});

					                }else{
					                	 logger.logError("Cannot Discharge");
					                	 $scope.check1 = false;
					                }
					            })
									}
									
								}else {
									$scope.check1 = false;
						toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.vessselArrivalForm.$validationSummary), 555000, 'trustedHtml');
						}
							};
							
							
					//view Detail 
					 
					  $scope.viewDetail = function(){
					        debugger;
					         if($scope.discharge.vessel !=''){
					        if($scope.discharge.voyage !=''){
					        	if($scope.discharge.port !=''){
					        			if($scope.discharge.arrivalDate !=''){
					        		
					        	
					        	
					            $http.post($stateParams.tenantid+'/api/discharge/viewDetail',$scope.discharge).success(function(data) {
					                if(data){
					                    debugger;
					                    if(data.message!=null && data.message!=''){
						                	 logger.logError(data.message);

					                   }else  if(data.success==true && data.dischargeDtl.length>0){
						                	 logger.logSuccess("Details Fetched!");
//						                	 $scope.rowCollection = data.dischargeDtl;
						                	 $scope.discharge.detailList = data.dischargeDtl;
							                    $scope.discharge.count= data.dischargeCountDtl;

						                	 $scope.selectall(true);

						                }else{
						                	 logger.logError("Container's are already discharged");
						                	 $scope.rowCollection= [];
						                	 
						                }
					                }
					                
					            }).error(function(data) {
					                logger.logError("Error Please Try Again");
					            });
					        }
					        		else{
							        	  if($scope.discharge.arrivalDate=='')
								                logger.logError("Please select Arrival Date");
							        	}	
					        
					        }
					        	else{
					        	  if($scope.discharge.port=='')
						                logger.logError("Please select Port");
					        	}
					      }
					        else{
					            if($scope.discharge.voyage=='')
					                logger.logError("Please select Voyage");
					        }
					      }
					         else{
					            logger.logError("Please select  Vessel");
					        }
					    };
					 
					    $('#arrivalDate').datetimepicker({
							 format : 'DD/MM/YYYY HH:mm'
							 })
							 $('#dischargeDate').datetimepicker({
							 format : 'DD/MM/YYYY HH:mm'
							 })
							 
							 $('#detailDate').datetimepicker({
								 format : 'DD/MM/YYYY HH:mm'
								 })
								 $('#dischargeStatusDate').datetimepicker({
								 format : 'DD/MM/YYYY HH:mm'
								 })


					$scope.reset = function() {
						$scope.deleteIds = [];
						if ($scope.isEdit == true) {
							$scope.editBooking(bookingNo);
						} else {
							$scope.bookingData = {
									vessel : '',
									voyage : '',
									port : '',
									terminalCode : '',
									arrivalDate : ''
									
								};
						}
					}

					
	
					//cancel
					
					$scope.cancel = function() {
						$state.go('app.operation.discharge.list', {
							tenantid : $stateParams.tenantid
						});
					}

					
					 $scope.isEdit=false;
					    
					
						 
					  var vesselArrivalId = $location.search().vesselArrivalId;
					  var isTransit =new Boolean();
					  isTransit =$location.search().isTransit;
					  

					  if(vesselArrivalId != null){
						  $scope.isEdit=true;
					      
						  $http.post($stateParams.tenantid+'/api/discharge/edit?vesselArrivalId=' +vesselArrivalId+'&isTransit='+isTransit).success(function(result) {
					          
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
					
					  
					  $scope.print = function(data){
							  
							  var blNo = '';
							  $scope.arrival=false;
							  
							  
						      var len = data.length;
						      for ( var i = 0; i < len; i++) {
						          var rowData = data[i];
						          if (typeof rowData.select1 == "undefined") {
						              rowData["select1"] = false;
						          }
						         
						      }
						      for(var i = 0; i < len; i++){
						    	  var rowData = data[i];
						    	  if (rowData.select1 == true) {
							          	blNo += rowData.blNumber + ',';
							          	$scope.arrival=true;
							          }
						    	  
						      }
						      if($scope.arrival==true){
						    	  var url = $stateParams.tenantid+'/api/vesselArrival/Print?blNo='+blNo;
									var wnd = window.open(url, 'Shipping', 'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
							      wnd.print();
						      }else{
						    	  logger.logError("Select Atleast One Row");
						      }
						     // var blNo='BL876155';
						      
								
							  
							
					  }
					 
					//=========================================================================================================
					//File upload

					$scope.fileUpload = function() {
						if ($scope.discharge.detailList.length > 0) {

							ngDialog.close();
							ngDialog.open({
								template : 'fileModal',
								scope : $scope
							});
						} else {
							logger .logError("Click on first show Button");
						}
						
					};
					
					$rootScope.uploadFile1 = function(element) {

						console.log("excel file");
						$scope.excelfile = element.files[0];
						console.log($scope.excelfile);
					}

					$rootScope.closeFileDialog = function() {
						ngDialog.close();
					};
					 

					$rootScope.uploadFile= function() {
						
						// loader.start();
						var excelfile = $scope.excelfile;
						var fileExtension = excelfile.name;
						var fName = [];
						fName = fileExtension.split(".");
						for (var i = 0; i < fName.length; i++) {
							if (fName[i] == "xls" || fName[i] == "xlsx") {
								var frmData = new FormData();
								frmData.append("file", excelfile);
								frmData.append("vessel", $scope.discharge.vessel);
								frmData.append("voyage", $scope.discharge.voyage);
								frmData.append("port", $scope.discharge.port);
								$.ajax({ type : "POST",
											url : $stateParams.tenantid+'/api/discharge/uploadfileFoeCon',
											data : frmData,
											contentType : false,
											processData : false,
											success : function(response) {
												// loader.complete();
												if (response.success) {
													if(response.containerDateList.length > 0 && $scope.discharge.detailList.length >0){
														 for(var i=0; i < response.containerDateList.length;i++){
															 for(var j=0; j < $scope.discharge.detailList.length;j++){
																 if($scope.discharge.detailList[j].containerNumber == response.containerDateList[i].containerNumber){
																	
																	 $scope.dt = $filter('date')(new Date(response.containerDateList[i].dischargeDate.split('-').join('/')), "dd/MM/yyyy hh:mm");
																	 
																	 $scope.discharge.detailList[i].dischargeStatusDate =$scope.dt; 
																	  
																	}
																 }									
														}
													} 
												 
													$scope.closeFileDialog();
												} else {  
													logger.logError(response.message);
													$scope.closeFileDialog();
					 							}
											}
										});
							}
						}
						
						
						
					}
					//Save file 

					
					
					//----------------------------------------------------------------------------------------------------
					
				});

//Arrival Notivce 



/* 'use strict'; */


