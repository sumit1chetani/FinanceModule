app.controller('gateInAddCtrl',function($scope,  $http, $location, logger,ngDialog, utilsService, $state, sharedProperties,
						$window, $stateParams,$rootScope, toaster, validationService,$controller) {
	
					$scope.containerDtl = [];
					$scope.containerDtlsoc = [];
					$scope.isEdit = false;
					$scope.modeList=[];
					$scope.gateIn = {
						gateInNo : '',
						gateOutNo : '',carrier:'',mode:'',
						depot : '',
						bookingNo : '',tripNo:'',vessel:'',voyage:'',
						customer : '',
						returnDate : '',
						createdBy: '',
						createdOn : '',
						modifiedBy: '',
			          modifiedOn: '',
						returnDate:'',

						type: 'Export',
						service : 'COC',
						doNo :'',
				
						containerDtl : [],
					   containerDtlsoc: []

					}
					
					if($rootScope.doType=="Import"){
						$scope.gateIn.type = 'Import';
					}else{
						$scope.gateIn.type = 'Export' ;
					}
					
					$scope.saveButtonDisble = false;
					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1; // January is 0!
					var yyyy = today.getFullYear();
					var HH = today.getHours();
					var MM = today.getMinutes();
					if (dd < 10) {
						dd = '0' + dd
					}
					if (mm < 10) {
						mm = '0' + mm
					}
					if (HH < 10) {
						HH = '0' + HH
					}
					if (MM < 10) {
						MM = '0' + MM
					}

					$scope.gateIn.returnDate = dd + '/' + mm + '/'+ yyyy+ ' ' + HH+':'+ MM;

					 $('#returnDate').datetimepicker({
						 format : 'DD/MM/YYYY HH:mm'
						 })
					
					$scope.ContainerDtl = {
						containerType : "",
						containerNo : "",
						sealNo : "",
						returnDate:'',
						emptyOrLoad : true,
						line: "",
						select : false
					}
					
					$scope.containerDtlsoc = {
							containerType : "",
							containerNo : "",
							sealNo : "",
							returnDate:'',
							emptyOrLoad : "",
							line: "",
							select : false
						}
					
					$scope.typeList=[

						{ id: 'Export', text: 'Export' },
						{ id: 'Import', text: 'Import' }

						]
				 
					$scope.addRow = function() {

						$scope.max = Math.max.apply(Math, $scope.gateIn.containerDtl
								.map(function(item) {
									return item.id;
								}));
						$scope.max = $scope.max + 1;
						var chargedata = {
								containerType : "",
								containerNo : "",
								sealNo : "",
								returnDate:'',

								emptyOrLoad : "",
								
								line: "",
								select : false
								
						};

						$scope.gateIn.containerDtl.push(chargedata);
						var len = $scope.gateIn.containerDtl.length - 1;
						$timeout(function() {
							hideActivePapers($scope.max + "0", []);
						}, 1000);
						
						/*$scope.hide=true;*/
						
				}
					 $scope.$watchCollection('gateIn.mode', function(newValue, oldValue) {
					        if (newValue != '' && newValue != undefined) {
					        	if($scope.gateIn.type=='Export'){
					    $http.get($stateParams.tenantid+'/api/outWard/getBookingList_modeCarrier_gatein?carrier='+$scope.gateIn.carrier+'&mode='+newValue).success(function(datas) {
					        $scope.bookingNoList = datas;
					    });
					        }
					        	else if ($scope.gateIn.type=='Import'){
					        		$http.post($stateParams.tenantid+'/api/voyageClosing/getDOList',$scope.gateIn).success(function(datas) {
										
										  $scope.doNoList=datas.doNoList;
										 
										
									}).error(function(datas) {

									});
					        	}
					        }else{
					        	 $scope.bookingNoList = [];
					        	 $scope.doNoList=[];
					        }
					    })
					    
					    $scope.$watchCollection('gateIn.carrier', function(newValue, oldValue) {
					        if (newValue != '' && newValue != undefined) {
					        	if($scope.gateIn.type=='Export'){
					    $http.get($stateParams.tenantid+'/api/outWard/getBookingList_modeCarrier_gatein?carrier='+newValue+'&mode='+$scope.gateIn.mode).success(function(datas) {
					        $scope.bookingNoList = datas;
					    });
					        	}else if ($scope.gateIn.type=='Import'){
					        		$http.post($stateParams.tenantid+'/api/voyageClosing/getDOList',$scope.gateIn).success(function(datas) {
										
										  $scope.doNoList=datas.doNoList;
										 
										
									}).error(function(datas) {

									});
					        	}
					        }else{
					        	 $scope.bookingNoList = [];
					        	 $scope.doNoList=[];
					        }
					    })
					    $http.get($stateParams.tenantid+'/app/commonUtility/getcarrierList').success(function(datas) {
		debugger
	    $scope.carrierList = datas.commonUtilityBean;	    
        //$scope.transList = datas.lCommonUtilityBean;	    

	}).error(function(data) {

	});
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
							    data["text"] = "FREIGHT FORWARDINTG";
							     $scope.modeList.push(data);
							// data = {};
							// data["id"] = "2";
							// data["text"] = "SEA";
							// $scope.modeList.push(data);
						}
						$scope.getQuotationType();
					  $scope.selectall= function(selection){
					      	angular.forEach($scope.gateIn.containerDtl,function(value,key) {
					      		debugger;
					      		if( selection)
					      		value.emptyOrLoad=true;
					      		else{
					      			value.emptyOrLoad=false;
					      		}
					  });
					      }
					  

			 $scope.selectallRec = function(selection) {
						angular.forEach($scope.gateIn.containerDtl, function(
								value, key) {
							debugger;
							if (selection)
								value.select = true;
							else {
								value.select = false;
							}
						});
					}
					  
					$scope.removeRow = function() {
						$scope.tablerow = [];
						for (var index = 0 ; index < 1; index++) {
						angular.forEach($scope.gateIn.containerDtl,function(row, index) {
									var check = row.select;
														
									if (check == undefined || check == "" ) {
										$scope.tablerow.push(row);
									} else if(index > 0){
										$scope.gateIn.containerDtl = $scope.tablerow;

									}
								});
						}
					};
					
					$scope.addRow1 = function() {

						$scope.max = Math.max.apply(Math, $scope.gateIn.containerDtlsoc
								.map(function(item) {
									return item.id;
								}));
						$scope.max = $scope.max + 1;
						var chargedata = {
								containerType : "",
								containerNo : "",
								sealNo : "",
								emptyOrLoad : "",
								line: "",
								select : false
						};

						$scope.gateIn.containerDtlsoc.push(chargedata);
						var len = $scope.gateIn.containerDtlsoc.length - 1;
						$timeout(function() {
							hideActivePapers($scope.max + "0", []);
						}, 1000);
						
					
						
				}
					
	  $scope.apply = function(detailDate){
							for(var i=0;i<$scope.gateIn.containerDtl.length;i++){
								$scope.gateIn.containerDtl[i].returnDate = detailDate;

							}
						
						}
					
					$http.post($stateParams.tenantid+'/app/gateOut/gettripNoList').success(function(datas) {
						  $scope.tripNoList=datas;
						 		}).error(function(datas) {

						});
					$scope.removeRow1 = function(){
						var count =0;
						ngDialog.openConfirm().then(function() {
							if($scope.isEdit==false){
								var tmpDelList = [];
								
								for(var i=$scope.gateIn.containerDtlsoc.length-1;i>=0;i--){
									if($scope.gateIn.containerDtlsoc[i].select==true){
										count++;
										tmpDelList.push($scope.gateIn.containerDtlsoc[i]);
										$scope.gateIn.containerDtlsoc.splice(i, 1);
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
								for(var i=$scope.gateIn.containerDtlsoc.length-1;i>=0;i--){
									if($scope.gateIn.containerDtlsoc[i].select==true){
										count++;
										tmpDelList.push($scope.gateIn.containerDtlsoc[i]);
//										$scope.bookingData.boxData.splice(i, 1);
									}
								}
					/*		for(var i =0;i<tmpDelList.length;i++){
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
							}*/
							if(delCheck==true){
								for(var i=$scope.gateIn.containerDtlsoc.length-1;i>=0;i--){
									if($scope.gateIn.containerDtlsoc[i].select==true){
										count++;
										$scope.gateIn.containerDtlsoc.splice(i, 1);
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

					
					
					$scope.getdropdown = function() {
					$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
					
						 // $scope.customerList=datas.getcustomerlist;
						// $scope.depotList=datas.polList;
						  $scope.gateOutList=datas.gateOutList;
						  $scope.containerTypeList=datas.getcontypelist;
						  $scope.containerNoList=datas.getcontainer;
						  $scope.gateIn.gateInNoMaxCnt=datas.maxGateInNo;
						
					}).error(function(datas) {

					});
				  }
					/*$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
					    $scope.depotList = datas.commonUtilityBean;	    

					}).error(function(data) {

					});*/

					$http.get($stateParams.tenantid+'/app/gateOut/getiataList').success(function(datas) {
					    $scope.depotList = datas;	    

					}).error(function(data) {

					});
					
					//customerDropdown
					$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
						debugger
						 $scope.customerList = datas.customerList;
					}).error(function(data) {

					});
					/*$http.get($stateParams.tenantid+ '/app/commonUtility/getshipConsigneeList').success(function(data1) {
						$scope.customerList = data1;
					});*/
				   
				  $scope.getdropdown();
			 
		
				  
					$scope.getBookingNo = function() {
						debugger
						$http.post($stateParams.tenantid+'/api/voyageClosing/getDropdown').success(function(datas) {
						

							 /* $scope.voyageList=datas.voyageList;*/
							  $scope.depotListSOC=datas.depotList;
							 // $scope.bookingNoList=datas.bookingNoList;
							 //// $scope.doNoList=datas.doNoList;
							 
							
						}).error(function(datas) {

						});
					  }

					 $scope.getBookingNo();
					 
						$scope.$watch('gateIn.bookingNo', function(newValue,
								oldValue) {

							if (newValue != '' && newValue != undefined) {

								console.log("inside the voyage",newValue);
								 $http.post($stateParams.tenantid+'/app/onBoard/getgatoutNo?vesselCode='+newValue).success(function(data) {
							        	if(data.success){
							        		console.log("data",data);
							        		$scope.voyagelist=data.voyageList;
							        	}else{
							        		logger.logError("Unable to fetch data");
							        	}
							        });

							}
						});
						$scope.isEdit = false;

					
					$scope.save = function(gateInForm,gateIn) {
						if (new validationService().checkFormValidity($scope.gateInForm)) {
							
						var selectCheck=false;	
						$scope.saveButtonDisble = true;
						var tmpDelList = [];
					   angular.forEach($scope.gateIn.containerDtl, function(chargesDetail, index) {  
						   if(chargesDetail.select){
							   selectCheck=true;	
							   
						   }
					        
					    });
						if(selectCheck){
							for(var i=$scope.gateIn.containerDtl.length-1;i>=0;i--){
								if($scope.gateIn.containerDtl[i].select==true){
									tmpDelList.push($scope.gateIn.containerDtl[i]);
								}
							}
							
							$scope.gateIn.containerDtl = tmpDelList;
 								          var chk=true;
 								          var checkNull = true;
								          if($scope.gateIn.containerDtl.length>0){
								     	 for(var i=0;i< $scope.gateIn.containerDtl.length;i++){
								     		 if (checkNull) {
								     		if($scope.gateIn.containerDtl[i].returnDate == null || $scope.gateIn.containerDtl[i].returnDate == '' ){
								     			 logger.logError("Row ("+(i+1)+") Gate In Date Should not be Empty");
								     			 $scope.saveButtonDisble = false;
								     			 checkNull = false;
								     		}/*else{
								     			 var pastsevenDay = new Date();

								 	            var startDate=pastsevenDay.getDate()+"/"+(pastsevenDay.getMonth()+1)+"/"+pastsevenDay.getFullYear();
								 	            var dayBeforeNineDays=moment().subtract(7, 'days').format('DD/MM/YYYY');
								 	            startDate=dayBeforeNineDays;
								 	            
								 	        	var pastsevenDay = startDate;
								 	        	 var t = moment($scope.gateIn.containerDtl[i].returnDate,"DD/MM/YYYY").isSameOrBefore(moment(pastsevenDay, 'DD/MM/YYYY'));
								 	             if(t == true){
									     			checkNull = false;
								 	            	logger.logError("Row ("+(i+1)+") Gate In Date should be within past seven days from current date");
									     			 $scope.saveButtonDisble = false;
								 	             } else {
									     			checkNull = true;
									     		}
								     		}*/
								     		 
								     		/*if(checkNull){
								         	 var t = moment($scope.gateIn.containerDtl[i].previousStatusDate,"DD/MM/YYYY HH:mm").isSameOrBefore(moment($scope.gateIn.containerDtl[i].returnDate, 'DD/MM/YYYY HH:mm'));
								             if(t == false){
								             logger.logError("Row ("+(i+1)+") Gate In Date Should be Greater than Previous Status Date !!!  The Previous Status Date is: "+$scope.gateIn.containerDtl[i].previousStatusDate+"");
								             $scope.saveButtonDisble = false;
								             chk=false;
								             }
								     	 }*/
								     	 }
								     	 }
								          }
								          
										
								             if(checkNull && chk){
								            	 $scope.saveButtonDisble = true;
								            	 debugger;
						$http.post($stateParams.tenantid+'/api/gateIn/save',gateIn).success(function(data) {
						console.log("data" + data);
						if (data.isSuccess) {
						logger.logSuccess("Saved Successfully!");
						$scope.saveButtonDisble = true;
						$state.go('app.operation.gateIn.list');
						if(data.isSISuccess){
							logger.logSuccess("Shipping Instruction is Created Successfully..! The Job No "+data.gJobNo);
						}
						if(data.isBLSuccess){
							logger.logSuccess("BL is Created Successfully..! The BL No is "+data.gBlNo);
						}
						} else {
						logger.logError(data.message);
						$scope.saveButtonDisble = false;
						}
						}).error(function(result) {
							 $scope.saveButtonDisble = false;
						//console.log("data" + data);
						});
								             }
										     	
					          
						}else{
							logger.logError("Please select Container to proceed Gate IN");
							$scope.saveButtonDisble = false;
						}
						} else {
						toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.gateInForm.$validationSummary), 555000, 'trustedHtml');
						$scope.saveButtonDisble = false;
						}};
					
					
						var gNo = $location.search().gNo;
						if (gNo == undefined) {

						} else {
							$scope.gateIn.gateOutNo=gNo;
						}
						// Fetch Values
						$scope.isEdit = false;
						var gateInNo = $location.search().gateInNo;
						if (gateInNo == undefined) {

						} else {
							  $http.get($stateParams.tenantid+ '/api/gateIn/getCustomereditDropdown?gateInNo=' +gateInNo).success(function(data1) {
									console.log(data1);
									$scope.customerList1 = data1;
							  
								});
							$http.get($stateParams.tenantid+ '/api/gateIn/edit?gateInNo='+ gateInNo).success(function(result) {

												$scope.isEdit = true;
												$scope.gateIn = result;
												// $scope.gateIn = result.customer;
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
						if (gNo == undefined) {

						} else {
							 $scope.selectall(true);
						}
						$scope.update = function(gateInForm,
								gateIn) {
							debugger;
							if (new validationService()
									.checkFormValidity($scope.gateInForm)) {
								$scope.gateIn.gateInNo = $location
										.search().gateInNo;

								$http
										.post(
												$stateParams.tenantid
														+ '/api/gateIn/update',
												$scope.gateIn)
										.success(
												function(result) {
													if (result) {
														logger
																.logSuccess("Updated Successfully!");
														$state
																.go(
																		'app.operation.gateIn.list',
																		{
																			tenantid : $stateParams.tenantid
																		});
													} else {
														logger
																.logError("Error in Update");
													}
												}).error(function(data) {
											console.log("data" + data);
										});

							} else {
								toaster.pop('error',"Please fill the required fields",logger.getErrorHtmlNew($scope.gateInForm.$validationSummary),555000, 'trustedHtml');
							}
						};
						
					
					// cancel fn
					
					$scope.cancel = function() {
						$state.go('app.operation.gateIn.list', {
							tenantid : $stateParams.tenantid
						});
					};
					
				
					$scope.$watch('gateIn.gateOutNo', function(newValue, oldValue) {
						if($scope.isEdit==false){
				        if (newValue != '' && newValue != undefined) {
				        	$scope.gateInNo=newValue;
				        	$http.post($stateParams.tenantid+'/api/gateIn/getcustomerdetail?gateInNo='+$scope.gateInNo).success(function(datas) {
				        		
				        		
				        		if(datas.isSuccess){
				        		
				        		$scope.gateIn.customer=datas.customer;
				        		$scope.gateIn.bookingNo=datas.bookingNo;
				        		$scope.depotList = datas.depotListbasedonGateout;
				        		$scope.gateIn.depot=datas.depot;
				        	/*	$scope.gateIn.type=datas.type;*/
				        		$scope.gateIn.doNo=datas.doNo;
				        		$scope.gateIn.vessel=datas.vessel;
			        		      $scope.gateIn.voyage=datas.voyage;
				        		$scope.gateIn.containerDtl=datas.containerDtl;
				        		/*for(var i=0;i<$scope.gateIn.containerDtl.length;i++){
				        			$scope.gateIn.containerDtl[i].returnDate=dd + '/' + mm + '/'+ yyyy+ ' ' + HH+':'+ MM;
				        		}*/
				        		  $scope.selectall(true);
				        		  }
				        	else{
			        			
			        			
			        			logger.logError(newValue+" "+datas.message);	
			        			
			        		}
				    		}).error(function(datas) {

				    		});
				        } 
						}
				    });
					
					
					// For Booking No
					
					
					$scope.$watch('gateIn.bookingNo', function(newValue, oldValue) {
						if($scope.isEdit==false){
				        if (newValue != '' && newValue != undefined) {
				        	$scope.gateInNo=newValue;
				        	$http.post($stateParams.tenantid+'/api/gateIn/getBookingDetail?gateInNo='+$scope.gateInNo).success(function(datas) {
				        		
				        		if(datas.isSuccess){
				        		
				        			/*  $scope.gateIn.bookingNoList=datas.bookingNoList;*/
				        		      $scope.gateIn.customer=datas.customer;
				        		     
				        		
				        	}
				        	else{
			            			logger.logError(newValue+" "+datas.message);	
			        			
			        		}
				    		}).error(function(datas) {

				    		});
				        } 
						}
				    });
				
					
					// For DO No
					

					$scope.$watch('gateIn.doNo', function(newValue, oldValue) {
						if($scope.isEdit==false){
				        if (newValue != '' && newValue != undefined) {
				        	$scope.gateInNo=newValue;
				        	$http.post($stateParams.tenantid+'/api/gateIn/getDoNo?gateInNo='+$scope.gateInNo).success(function(datas) {
				        		
				        		if(datas.isSuccess){
				        		
				        			/*  $scope.gateIn.doNoList=datas.doNoList;*/
				        		      $scope.gateIn.customer=datas.customer.toString();
				        		      $scope.gateIn.depot=datas.depot;
				        		      $scope.gateIn.containerDtl=datas.containerDtl;
				        		      $scope.gateIn.vessel=datas.vessel;
				        		      $scope.gateIn.voyage=datas.voyage;

				        	}
				        	else{
			            			logger.logError(newValue+" "+datas.message);	
			        			
			        		}
				    		}).error(function(datas) {

				    		});
				        } 
						}
				    });

					// reset
					$scope.reset = function(gateIn) {
						if (gateInNo == undefined) {
							
							$scope.gateIn = {
									gateInNo : '',
									gateOutNo : '',
									depot : '',
									bookingNo : '',
									customer : '',
									returnDate : '',
							
									containerDtl : [],
								   containerDtlsoc: []

								}
							
						} else {
							$http.get($stateParams.tenantid+  '/api/gateIn/edit?gateInNo='+ gateInNo).success(function(result) {

												if (result.isEdit == false) {
													logger.logError("Please Try Again");
												} else {
													$scope.isEdit = true;
													$scope.gateIn = result;
													/*$scope.gateIn.customer = result.customer;*/
											
												}
											}).error(function(data) {
										console.log("data" + data);
									});
						}
					}
					
					//Export Excel
					
					
					$scope.excelexport=function(gateInNo){
						
						debugger
						$http.post($stateParams.tenantid+'/api/gateIn/excelexport?gateInNo='+gateInNo).success(function(datas){
							
							debugger;
				            $("#gateInExport").bind('click', function() {
				            });
				            $('#gateInExport').simulateClick('click');
				            logger.logSuccess("Exported Successfully!");
				       /* }else{
				            logger.logError("Failed to export");
				        }*/
				     }).error(function(result) {
				         console.log("data" + result);
						});


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
					}
			
				});
app.controller('gateEmptyReturnCtrl',function($scope,  $http, $location, logger,ngDialog, utilsService, $state, sharedProperties,
		$window, $stateParams,$rootScope, toaster, validationService,$controller) {

	$scope.containerDtl = [];
	$scope.containerDtlsoc = [];
	$scope.isEdit = false;

	$scope.gateIn = {
		gateInNo : '',
		gateOutNo : '',
		depot : '',
		bookingNo : '',
		customer : '',
		returnDate : '',
		createdBy: '',
		createdOn : '',
		modifiedBy: '',
      modifiedOn: '',
		returnDate:'',

		type: 'Empty Return',
		service : 'COC',
		doNo :'',

		containerDtl : [],
	   containerDtlsoc: []

	}
	
	
	
	$scope.saveButtonDisble = false;
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; // January is 0!
	var yyyy = today.getFullYear();
	var HH = today.getHours();
	var MM = today.getMinutes();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}
	if (HH < 10) {
		HH = '0' + HH
	}
	if (MM < 10) {
		MM = '0' + MM
	}

	$scope.gateIn.returnDate = dd + '/' + mm + '/'+ yyyy+ ' ' + HH+':'+ MM;

	 $('#returnDate').datetimepicker({
		 format : 'DD/MM/YYYY HH:mm'
		 })
	
	$scope.ContainerDtl = {
		containerType : "",
		containerNo : "",
		sealNo : "",
		returnDate:'',
		emptyOrLoad : true,
		line: "",
		select : false
	}
	
	$scope.containerDtlsoc = {
			containerType : "",
			containerNo : "",
			sealNo : "",
			returnDate:'',
			emptyOrLoad : "",
			line: "",
			select : false
		}
	
	$scope.typeList=[

		{ id: 'Export', text: 'Export' },
		{ id: 'Import', text: 'Import' },
		{ id: 'Empty Return', text: 'Empty Return' },

		]
 
	$scope.addRow = function() {

		$scope.max = Math.max.apply(Math, $scope.gateIn.containerDtl
				.map(function(item) {
					return item.id;
				}));
		$scope.max = $scope.max + 1;
		var chargedata = {
				containerType : "",
				containerNo : "",
				sealNo : "",
				returnDate:'',

				emptyOrLoad : "",
				
				line: "",
				select : false
				
		};

		$scope.gateIn.containerDtl.push(chargedata);
		var len = $scope.gateIn.containerDtl.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
		
		/*$scope.hide=true;*/
		
}
	
	
	  
	  
	$scope.removeRow = function() {
		$scope.tablerow = [];
		for (var index = 0 ; index < 1; index++) {
		angular.forEach($scope.gateIn.containerDtl,function(row, index) {
					var check = row.select;
										
					if (check == undefined || check == "" ) {
						$scope.tablerow.push(row);
					} else if(index > 0){
						$scope.gateIn.containerDtl = $scope.tablerow;

					}
				});
		}
	};
	
	$scope.addRow1 = function() {

		$scope.max = Math.max.apply(Math, $scope.gateIn.containerDtlsoc
				.map(function(item) {
					return item.id;
				}));
		$scope.max = $scope.max + 1;
		var chargedata = {
				containerType : "",
				containerNo : "",
				sealNo : "",
				emptyOrLoad : "",
				line: "",
				select : false
		};

		$scope.gateIn.containerDtlsoc.push(chargedata);
		var len = $scope.gateIn.containerDtlsoc.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
		
	
		
}

	$scope.removeRow1 = function(){
		var count =0;
		ngDialog.openConfirm().then(function() {
			if($scope.isEdit==false){
				var tmpDelList = [];
				
				for(var i=$scope.gateIn.containerDtlsoc.length-1;i>=0;i--){
					if($scope.gateIn.containerDtlsoc[i].select==true){
						count++;
						tmpDelList.push($scope.gateIn.containerDtlsoc[i]);
						$scope.gateIn.containerDtlsoc.splice(i, 1);
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
				for(var i=$scope.gateIn.containerDtlsoc.length-1;i>=0;i--){
					if($scope.gateIn.containerDtlsoc[i].select==true){
						count++;
						tmpDelList.push($scope.gateIn.containerDtlsoc[i]);
//						$scope.bookingData.boxData.splice(i, 1);
					}
				}
			if(delCheck==true){
				for(var i=$scope.gateIn.containerDtlsoc.length-1;i>=0;i--){
					if($scope.gateIn.containerDtlsoc[i].select==true){
						count++;
						$scope.gateIn.containerDtlsoc.splice(i, 1);
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

	
	
	$scope.getdropdown = function() {
	$http.post($stateParams.tenantid+'/app/quotation/getShipment').success(function(datas) {
	
		 // $scope.customerList=datas.getcustomerlist;
		 //$scope.depotList=datas.polList;
		  $scope.gateOutList=datas.gateOutList;
		  $scope.containerTypeList=datas.getcontypelist;
		  $scope.containerNoList=datas.getcontainer;
		  $scope.gateIn.gateInNoMaxCnt=datas.maxGateInNo;
		
	}).error(function(datas) {

	});
  }
	$http.get($stateParams.tenantid+'/app/seaquotation/getiataList').success(function(datas) {
	    $scope.depotList = datas.commonUtilityBean;	    

	}).error(function(data) {

	});
	
	
	
	//customerDropdown
	$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
		debugger
		 $scope.customerList = datas.customerList;
	}).error(function(data) {

	});
	
	/*$http.get($stateParams.tenantid+ '/app/commonUtility/getshipConsigneeList').success(function(data1) {
		$scope.customerList = data1;
	});*/
   
  $scope.getdropdown();


  
	$scope.getBookingNo = function() {
		debugger
		$http.post($stateParams.tenantid+'/api/voyageClosing/getDropdown').success(function(datas) {
		

			 /* $scope.voyageList=datas.voyageList;*/
			  $scope.depotListSOC=datas.depotList;
			  $scope.bookingNoList=datas.bookingNoList;
			////  $scope.doNoList=datas.doNoList;
			 
			
		}).error(function(datas) {

		});
	  }

	 $scope.getBookingNo();
	
	$scope.saveEmptyReturn = function(gateInForm,gateIn) {
		if (new validationService().checkFormValidity($scope.gateInForm)) {
			
		var selectCheck=false;	
		$scope.saveButtonDisble = true;
		var tmpDelList = [];
	   angular.forEach($scope.gateIn.containerDtl, function(chargesDetail, index) {  
		   if(chargesDetail.select){
			   selectCheck=true;	
			   
		   }
	        
	    });
		if(selectCheck){
			for(var i=$scope.gateIn.containerDtl.length-1;i>=0;i--){
				if($scope.gateIn.containerDtl[i].select==true){
					tmpDelList.push($scope.gateIn.containerDtl[i]);
				}
			}
			
			$scope.gateIn.containerDtl = tmpDelList;
					          var chk=true;
					          var checkNull = true;
				          if($scope.gateIn.containerDtl.length>0){
				     	 for(var i=0;i< $scope.gateIn.containerDtl.length;i++){
				     		 
				     		if($scope.gateIn.containerDtl[i].returnDate == null || $scope.gateIn.containerDtl[i].returnDate == '' ){
				     			 logger.logError("Row ("+(i+1)+") Gate In Date Should be Empty");
				     			 $scope.saveButtonDisble = false;
				     			 var checkNull = false;
				     		}else{
				     			 var checkNull = true;
				     		}
				     		 
				     		/*if(checkNull){
				         	 var t = moment($scope.gateIn.containerDtl[i].previousStatusDate,"DD/MM/YYYY HH:mm").isSameOrBefore(moment($scope.gateIn.containerDtl[i].returnDate, 'DD/MM/YYYY HH:mm'));
				             if(t == false){
				             logger.logError("Row ("+(i+1)+") Gate In Date Should be Greater than Previous Status Date !!!  The Previous Status Date is: "+$scope.gateIn.containerDtl[i].previousStatusDate+"");
				             $scope.saveButtonDisble = false;
				             chk=false;
				             }
				     	 }*/
				     	 }
				          }
				          
						
				             if(chk){
				            	 $scope.saveButtonDisble = true;
				            	 debugger;
		$http.post($stateParams.tenantid+'/api/gateIn/save',gateIn).success(function(data) {
		console.log("data" + data);
		if (data.isSuccess) {
		logger.logSuccess("Saved Successfully!");
		$scope.saveButtonDisble = true;
		$state.go('app.operation.gateIn.list');
		} else {
		logger.logError(data.message);
		$scope.saveButtonDisble = false;
		}
		}).error(function(result) {
			 $scope.saveButtonDisble = false;
		//console.log("data" + data);
		});
				             }
						     	
	          
		}else{
			logger.logError("Please select Container to proceed Gate IN");
			$scope.saveButtonDisble = false;
		}
		} else {
		toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.gateInForm.$validationSummary), 555000, 'trustedHtml');
		$scope.saveButtonDisble = false;
		}};
	
	
		var gNo = $location.search().gNo;
		if (gNo == undefined) {

		} else {
			$scope.gateIn.gateOutNo=gNo;
		}
		// Fetch Values
		$scope.isEdit = false;
		var gateInNo = $location.search().gateInNo;
		if (gateInNo == undefined) {

		} else {
			  $http.get($stateParams.tenantid+ '/api/gateIn/getCustomereditDropdown?gateInNo=' +gateInNo).success(function(data1) {
					console.log(data1);
					$scope.customerList1 = data1;
			  
				});
			$http.get($stateParams.tenantid+ '/api/gateIn/edit?gateInNo='+ gateInNo).success(function(result) {

								$scope.isEdit = true;
								$scope.gateIn = result;
								// $scope.gateIn = result.customer;
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
		if (gNo == undefined) {

		} else {
			 $scope.selectall(true);
		}
		
	
	// cancel fn
	
	$scope.cancel = function() {
		$state.go('app.operation.gateIn.list', {
			tenantid : $stateParams.tenantid
		});
	};
	

	$scope.$watch('gateIn.gateOutNo', function(newValue, oldValue) {
		if($scope.isEdit==false){
        if (newValue != '' && newValue != undefined) {
        	$scope.gateInNo=newValue;
        	$http.post($stateParams.tenantid+'/api/gateIn/getcustomerdetail?gateInNo='+$scope.gateInNo).success(function(datas) {
        		
        		
        		if(datas.isSuccess){
        		
        		$scope.gateIn.customer=datas.customer;
        		$scope.gateIn.bookingNo=datas.bookingNo;
        		$scope.depotList = datas.depotListbasedonGateout;
        		$scope.gateIn.depot=datas.depot;
        	/*	$scope.gateIn.type=datas.type;*/
        		$scope.gateIn.doNo=datas.doNo;
        		$scope.gateIn.vessel=datas.vessel;
  		      $scope.gateIn.voyage=datas.voyage;
        		$scope.gateIn.containerDtl=datas.containerDtl;
        		/*for(var i=0;i<$scope.gateIn.containerDtl.length;i++){
        			$scope.gateIn.containerDtl[i].returnDate=dd + '/' + mm + '/'+ yyyy+ ' ' + HH+':'+ MM;
        		}*/
        		  $scope.selectall(true);
        		  }
        	else{
    			
    			
    			logger.logError(newValue+" "+datas.message);	
    			
    		}
    		}).error(function(datas) {

    		});
        } 
		}
    });
	
	
	// For Booking No
	
	
	$scope.$watch('gateIn.bookingNo', function(newValue, oldValue) {
		if($scope.isEdit==false){
        if (newValue != '' && newValue != undefined) {
        	$scope.gateInNo=newValue;
        	$http.post($stateParams.tenantid+'/api/gateIn/getBookingDetail?gateInNo='+$scope.gateInNo).success(function(datas) {
        		
        		if(datas.isSuccess){
        		
        			/*  $scope.gateIn.bookingNoList=datas.bookingNoList;*/
        		      $scope.gateIn.customer=datas.customer;
        		     
        		
        	}
        	else{
        			logger.logError(newValue+" "+datas.message);	
    			
    		}
    		}).error(function(datas) {

    		});
        } 
		}
    });

	
	// For DO No
	

	$scope.$watch('gateIn.doNo', function(newValue, oldValue) {
		if($scope.isEdit==false){
        if (newValue != '' && newValue != undefined) {
        	$scope.gateInNo=newValue;
        	$http.post($stateParams.tenantid+'/api/gateIn/getDoNo?gateInNo='+$scope.gateInNo).success(function(datas) {
        		
        		if(datas.isSuccess){
        		
        			/*  $scope.gateIn.doNoList=datas.doNoList;*/
        		      $scope.gateIn.customer=datas.customer.toString();
        		      $scope.gateIn.depot=datas.depot;
        		      $scope.gateIn.vessel=datas.vessel;
        		      $scope.gateIn.voyage=datas.voyage;
        		      $scope.gateIn.containerDtl=datas.containerDtl;
        		
        	}
        	else{
        			logger.logError(newValue+" "+datas.message);	
    			
    		}
    		}).error(function(datas) {

    		});
        } 
		}
    });

	// reset
	$scope.reset = function(gateIn) {
		if (gateInNo == undefined) {
			
			$scope.gateIn = {
					gateInNo : '',
					gateOutNo : '',
					depot : '',
					bookingNo : '',
					customer : '',
					returnDate : '',
			
					containerDtl : [],
				   containerDtlsoc: []

				}
			
		} else {
			$http.get($stateParams.tenantid+  '/api/gateIn/edit?gateInNo='+ gateInNo).success(function(result) {

								if (result.isEdit == false) {
									logger.logError("Please Try Again");
								} else {
									$scope.isEdit = true;
									$scope.gateIn = result;
									/*$scope.gateIn.customer = result.customer;*/
							
								}
							}).error(function(data) {
						console.log("data" + data);
					});
		}
	}

});
 


