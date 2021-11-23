/*'use strict';*/
app .controller(
				'vesselArrivalAddCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {

					$scope.vesselList = [];
					$scope.voyageList = [];
					$scope.terminalList = [];


					$scope.vesselArrival = {
							vessel : '',
							voyage : '',
							port : '',
							terminal : '',
							arrivalDate : '',
							mrnNo:'',
							detailList : [],count:[]
							
						
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
						

					//vessel
					
					$http.get($stateParams.tenantid+ '/api/vesselArrival/getVesselList').success(function(data) {
						$scope.vesselList = data;
												
					});
			
					
//					//terminal
//					
//					$http.get($stateParams.tenantid+ '/api/vesselArrival/getTerminalList').success(function(data) {
//						$scope.terminalList = data;
//					});
//			

					
					
					 $scope.$watch('vesselArrival.vessel', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	 
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
									if(data.length > 0)
					    		  {
					    		  $scope.voyageList = data;
					    		  
					    		  
					    		  }
									else{
										
										logger.logError("Voyage is not available for the given vessel");
										
									}
					    	  });
					    	  
					    	 
					      }
					    });
					 

					 
					 $scope.$watch('vesselArrival.voyage', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != ''){
					    	  $http.post($stateParams.tenantid+ '/api/vesselArrival/getPortListByVoyage',newValue).success(function(data) {
									$scope.portList = data;
					    	  });
					      }
					    });
					 
					/* $scope.$watch('[vesselArrival.arrivalDate]', function(newValue,oldValue) {
							if (newValue != '' && newValue != undefined) {
								
							if($scope.vesselArrival.port != '' && $scope.vesselArrival.port != null && $scope.vesselArrival.port !=undefined){
														
								if($scope.vesselArrival.port.substring(0,2) == 'AE'){
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
										
										var dayDiff = moment(twoDayDate, "DD/MM/YYYY").diff(moment($scope.vesselArrival.arrivalDate, "DD/MM/YYYY"),'day')
								        if ( dayDiff < 0 ) { 
								        	$scope.vesselArrival.arrivalDate="";
								        	logger.logError("Vessel Arrival Date cannot be later than 2 days from today..!!");
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
										
										var dayDiff = moment(twoDayDate, "DD/MM/YYYY").diff(moment($scope.vesselArrival.arrivalDate, "DD/MM/YYYY"),'day')
								        if ( dayDiff < 0 ) { 
								        	$scope.vesselArrival.arrivalDate="";
								        	logger.logError("Vessel Arrival Date cannot be later than today..!!");
								        }
									
								}
							
								
								
								
							}else{
								logger.logError("Please select the Port..!!");
								$scope.vesselArrival.arrivalDate="";
							}

							}
						});*/
					 
					//port-arrival date
					   $scope.$watchCollection('[vesselArrival.voyage,vesselArrival.port]', function(newValue, oldValue) {
						   debugger
					        if (newValue != '' && newValue != undefined) {
					        	if ($scope.isEdit == false) {
					           if($scope.vesselArrival.port != '' && $scope.vesselArrival.port != undefined
					        && $scope.vesselArrival.voyage != '' && $scope.vesselArrival.voyage != undefined){
					        	   
					        	   var ob = {
											voyage : $scope.vesselArrival.voyage,
											port	:$scope.vesselArrival.port
									}

					                $http.post($stateParams.tenantid+'/api/vesselArrival/getarrivaldate',ob).success(function(datas) {
					                	if(datas.vesselArrivalBean.success == true){
					                	//	if(datas.vesselArrivalBean.vesselSailingCount > 0){
							                    $scope.vesselArrival.arrivalDate=datas.vesselArrivalBean.arrivalDate;
							                    $scope.terminalList = datas.listTerminalList;
							                    console.log(datas);
					                		/*}else{
					                			logger.logError("Vessel Sailing Not Present For Previous Port..!!");	
					                		}*/
					                	}else{
					                		 logger.logError(datas.vesselArrivalBean.message);
					                	}
					                    }).error(function(datas) {
					                });   
					        }
					        	}  
					        }
					    });
					 

					 
					//view Detail 
					 
					  $scope.viewDetail = function(){
					        debugger;
					         if($scope.vesselArrival.vessel !=''){					        	 					        	  
					        	 if($scope.vesselArrival.voyage !=''){
					        		//hiddenshow
						        	   /* var vessel = $scope.vesselArrival.vessel;
						        	    var voyage = $scope.vesselArrival.voyage;
						    		  $http.get($stateParams.tenantid+ '/api/vesselArrival/hiddenshow?vessel=' 
						    				  +vessel 
						    				  + '&voyage='
												+ voyage)
												.success(function(datas) {
							    			console.log(datas);
							    			$scope.showArrival = datas;
							    	    }).error(function(datas) {
							    		});//end hiddenshow
*/						    		//if( datas== true){
					        		 if($scope.vesselArrival.port !=''){
					        			if($scope.vesselArrival.arrivalDate !=''){
					        				//if($scope.vesselArrival.mode !='' && $scope.vesselArrival.mode !=undefined){						        	
					            $http.post($stateParams.tenantid+'/api/vesselArrival/viewDetail',$scope.vesselArrival).success(function(data) {
					                if(data){
					                    debugger;
					                   
					                    if(data.success==true && data.loadedList.length>0){
						                	 logger.logSuccess("Details Fetched!");
						                	 $scope.rowCollection = data.loadedList;
							                    detailList = data.loadedList
							                    $scope.vesselArrival.count= data.contList;

							                    console.log($scope.rowCollection);
							                    $scope.showArrival =false;
							                    							                    
						                }else{
						                	//hiddenshow
							        	    var vessel = $scope.vesselArrival.vessel;
							        	    var voyage = $scope.vesselArrival.voyage;
							    		  $http.get($stateParams.tenantid+ '/api/vesselArrival/hiddenshow?vessel=' 
							    				  +vessel 
							    				  + '&voyage='
													+ voyage)
													.success(function(datas) {
								    			console.log(datas);
								    			$scope.showArrival = datas;
								    	    }).error(function(datas) {
								    		});//end hiddenshow
						                	
						                	 logger.logError("Details Not Available");
						                	 $scope.rowCollection= [];
						                	 
						                }
					                
					                    
					                }
					            }).error(function(data) {
					                logger.logError("Error Please Try Again");
					            });
					       /* }
					        				else{
										                logger.logError("Please select Mode");
					        				}*/
					        			}else{
							        	  if($scope.vesselArrival.arrivalDate=='')
								                logger.logError("Please select Arrival Date");
							        	}	
					        		
					        
					        }
						    		//}
					        	else{
					        	  if($scope.vesselArrival.port=='')
						                logger.logError("Please select Port");
					        	}
					      }
					        else{
					            if($scope.vesselArrival.voyage=='')
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
							 
					//save data
							 
						$scope.saveData = function(vessselArrivalForm,vesselArrival) {
					    	if (new validationService().checkFormValidity($scope.vessselArrivalForm)) {

						         if($scope.vesselArrival.vessel !=''){
						        if($scope.vesselArrival.voyage !=''){
						        	if($scope.vesselArrival.port !=''){
						        			if($scope.vesselArrival.arrivalDate !=''){
						        				
						        			
							var obj={
									bean:$scope.vesselArrival,
									detailList:$scope.rowCollection
							};
							$http.post($stateParams.tenantid+'/api/vesselArrival/saveDetail',obj).success(function(data) {
								console.log(data);
				                if(data.isSuccess==true){
				                	 logger.logSuccess("Saved Successfully!");
				                     $state.go("app.operation.vesselarrival.list",{tenantid:$stateParams.tenantid});

				                }else{
				                	 logger.logError(data.message);
				                }
				            })  
				            }	else{
									        	  if($scope.vesselArrival.arrivalDate=='')
										                logger.logError("Please select Arrival Date");
									        	}	
							        		
							        
							        }
							        	else{
							        	  if($scope.vesselArrival.port=='')
								                logger.logError("Please select Port");
							        	}
							      }
							        else{
							            if($scope.vesselArrival.voyage=='')
							                logger.logError("Please select Voyage");
							        }
							      }
							         else{
							            logger.logError("Please select  Vessel");
							        }
				            } else {
				                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.vessselArrivalForm.$validationSummary), 555000, 'trustedHtml');
				            }
						};
					    
						
						
						$scope.updateData = function(vessselArrivalForm,vesselArrival) {
							if (new validationService().checkFormValidity($scope.vessselArrivalForm)) {
							var obj={
									bean:$scope.vesselArrival,
									detailList:$scope.rowCollection
							};
							$http.post($stateParams.tenantid+'/api/vesselArrival/updateDetail',obj).success(function(data) {
								console.log(data);
				                if(data.isSuccess==true){
				                	 logger.logSuccess("Updated Successfully!");
				                     $state.go("app.operation.vesselarrival.list",{tenantid:$stateParams.tenantid});

				                }else{
				                	 logger.logError(data.message);
				                }
				            })
						} else {
			                toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.vessselArrivalForm.$validationSummary), 555000, 'trustedHtml');
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
									port : '',
									terminalCode : '',
									arrivalDate : ''
									
								};
						}
					}

					
	
					//cancel
					
					$scope.cancel = function() {
						$state.go('app.operation.vesselarrival.list', {
							tenantid : $stateParams.tenantid
						});
					}

					
					 $scope.isEdit=false;
					    
					
						 
					  var rowId = $location.search().rowId;
					  if(rowId != null){
						  $scope.isEdit=true;
					      
						  $http.post($stateParams.tenantid+'/api/vesselArrival/view?rowId=' +rowId).success(function(result) {
					          
					          if (result.isEdit == false) {
					              logger.logError("Please Try Again");
					          } else {
					              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
					              console.log(result);
					              $scope.vesselArrival = result;
					              $scope.rowCollection = result.detailList;
					             
					          }
					            
					         }).error(function(data) {

					         });
					  }
					  
					  
					  
					  
					  var rowId = $location.search().rowId1;
					  if(rowId != null){
						  $scope.isEdit=true;
					      
						  $http.post($stateParams.tenantid+'/api/vesselArrival/edit?rowId=' +rowId).success(function(result) {
					          
					          if (result.isEdit == false) {
					              logger.logError("Please Try Again");
					          } else {
					              console.log("result***************for edit*******");
					              console.log(result);
					              $scope.vesselArrival = result;
					              $scope.rowCollection = result.detailList;
					             
					          }
					            
					         }).error(function(data) {

					         });
					  }
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					
					 
				});






/*'use strict';*/
app .controller(
				'vesselArrivalviewCtrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {

					$scope.vesselList = [];
					$scope.voyageList = [];
					$scope.terminalList = [];


					$scope.vesselArrival = {
							vessel : '',
							voyage : '',
							port : '',
							terminal : '',
							created_by: '',
				            createdDate : '',
				          modified_by: '',
				       modified_date: '',
							arrivalDate : '',
							detailList : []
							
						
					};


	
					//cancel
					
					$scope.cancel = function() {
						$state.go('app.operation.vesselarrival.list', {
							tenantid : $stateParams.tenantid
						});
					}

					
					 $scope.isEdit=false;
					    
					
						 
					  var rowId = $location.search().rowId;
					  if(rowId != null){
						  $scope.isEdit=true;
					      
						  $http.post($stateParams.tenantid+'/api/vesselArrival/view?rowId=' +rowId).success(function(result) {
					          
					          if (result.isEdit == false) {
					              logger.logError("Please Try Again");
					          } else {
					              console.log("result***************for viewwwwwwwwwwwwwwwwww*******");
					              console.log(result);
					              $scope.vesselArrival = result;
					              $scope.rowCollection = result.detailList;
					              if($scope.vesselArrival.mode=='1'){
					            	  $scope.vesselArrival.mode="SEA COASTAL";
					              }else if($scope.vesselArrival.mode=='2'){
					            	  $scope.vesselArrival.mode="SEA FOREIGN";
					              }else if($scope.vesselArrival.mode=='3'){
					            	  $scope.vesselArrival.mode="TRUCK";
					              }else if($scope.vesselArrival.mode=='4'){
					            	  $scope.vesselArrival.mode="LINER";
					              }else if($scope.vesselArrival.mode=='5'){
					            	  $scope.vesselArrival.mode="Forwarding";
					              }
								    								
					          }
					            
					         }).error(function(data) {

					         });
					  }

				});
/* 'use strict'; */


