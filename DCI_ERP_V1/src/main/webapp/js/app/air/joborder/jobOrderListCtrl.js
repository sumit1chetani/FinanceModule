'use strict';
app
		.controller(
				'joborderlistctrl',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector) {
					$scope.itemsByPage = 10;
//					$scope.defaultCurrency = 0;
//					$scope.toCurrency=0;
//					$scope.fromCurrency=0;
				    $scope.joborder = {
				    		branch:'',
				    		status1:''
				    	
				       
				    };
				    $scope.jobStatusList=[];
					$scope.getStatus = function() {
					    var  data = {};
					    data["id"] = "1";
					    data["text"] = "OPEN";
					    $scope.jobStatusList.push(data);
					    data = {};
					    data["id"] = "2";
					    data["text"] = "CLOSED";
					    $scope.jobStatusList.push(data);  
					    
					}
					$scope.getStatus();
					

					$scope.dropdown=function(){
									debugger;
									$http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
										debugger
									
										$scope.branchList = datas.branchSelectivityList;
									    $scope.portList = datas.portSelectivityList;
									}).error(function(data) {

									});
					}
								
								$scope.dropdown();
					$scope.showExcelButton=false;
				    $http.post($stateParams.tenantid + '/app/dashboard/checkWhichUser').success(function(data) {
						if (data[1].userId=='E0001'|| data[1].userId=='A0001') {
							$scope.showExcelButton=true;
						}

					}).error(function(data) {
						logger.logError("Error Please Try Again");
					});
					
					$scope.getBookingList = function() {
						$http
								.post(
										$stateParams.tenantid
												+ '/app/jobOrderAir/list')
								.success(function(data) {
									$scope.rowCollection = data.lJobOrderBean;
								});
					};
					$scope.getBookingList();
					$scope.deleteJob = function(jobNo) {
						ngDialog
								.openConfirm()
								.then(
										function() {
											$http
													.post(
															$stateParams.tenantid
																	+ '/app/jobOrderAir/delete',
															jobNo)
													.success(
															function(data) {
																if (data.success = true) {
																	logger
																			.logSuccess('Job Order Deleted Successfully.')
																	$scope
																			.getBookingList();
																} else {
																	if (data.message != null
																			&& data.message != '') {
																		logger
																				.logError(data.message)
																	} else {
																		logger
																				.logError("Can't delete. Please try again.");
																	}
																}
															});
										});
					};
					$scope.add = function() {
						debugger;
						$state.go('app.air.joborder.add', {
							tenantid : $stateParams.tenantid
						});
					};

					$scope.editJob = function(jobId) {
						debugger
						$scope.modeType=2;
					        $http.get($stateParams.tenantid+'/jobOrderMonthClose/getJobDate?mode=' + $scope.modeType +'&jobId='+ jobId).success(function(datas) {
					            if(datas){
					                logger.logError("Job Order Closed Pls Contact IT Support");
				                 }else{
				                	 $location.url($stateParams.tenantid + '/jobOrderAir/edit?rowid=' + jobId);
				                 }
					        })
						
					}
					$scope.print = function(rowid) {
						
						var test = parseInt(rowid);
						var url = $stateParams.tenantid
								+ '/app/jobOrderAir/print?rowid=' + rowid
						var wnd = window
								.open(
										url,
										'Athena',
										'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						wnd.print();

					};
					// $scope.editBooking = function(rowid) {
					// debugger
					// $location.url($stateParams.tenantid+'/jobOrderSea/edit?rowid='+rowid);
					//			
					// }

					$scope.viewJob = function(jobId) {
						$location.url($stateParams.tenantid
								+ '/jobOrderAir/view?rowid=' + jobId);
					}
					$scope.viewQuotation = function(quotationNo) {
						debugger
							$location.url($stateParams.tenantid+'/airQuotation/view?QuotHdId='+quotationNo);
						
					}
					
					
					var quickLinkIdList = $location.search().quickLinkIdList;
				    $scope.newQukLinkList=[];
				    $scope.qlt=[];
				    if(quickLinkIdList!='' && quickLinkIdList != undefined){
				    	$http.post($stateParams.tenantid+'/app/jobOrderAir/list').success(function(data) {
							$scope.rowCollection = data.lJobOrderBean;
				            if($scope.rowCollection !=null && $scope.rowCollection.length>0 ){
				            	angular.forEach($scope.rowCollection, function(value, key) {
				            		angular.forEach($scope.qlt, function(value1, key1) {
				                		if(value.jobId==value1){
				                			$scope.newQukLinkList.push(value);
				                		}
				                	})
				            	})
				            	$scope.rowCollection=[];
				            	$scope.rowCollection=$scope.newQukLinkList;
				            }
				            }).error(function(datas) {
				        });
				        
				     }
					

				 // excel export
				    
				    $scope.excel = function() {
				        if($scope.joborder.branch !=''){
				        	
						$http.post($stateParams.tenantid + '/app/jobOrderAir/generateExcel',$scope.joborder).success(function(data) {
							if (data.success == true) {
								
							$scope.debitNoteFileUrl = data.filePath.split("/");
							$scope.actualLength=$scope.debitNoteFileUrl.length;
							$scope.fileLength=$scope.actualLength - 1;
				            $scope.downloadFile = $scope.debitNoteFileUrl[$scope.fileLength];
				            console.log($scope.downloadFile)
							logger.logSuccess("Exported successfully!");
							 $('#exportXl').attr('href','filePath/' +$scope.downloadFile);
						    $("#exportXl").bind('click', function() {
						   });
						   $('#exportXl').simulateClick('click');
						  
						   } else {
								logger.logError("Failed to Export!..");
							}

						}).error(function(data) {
							logger.logError("Error Please Try Again");
						});
				  
		        }	else{
				      logger.logError("Please select  Branch");
				  }
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
				});

app
		.controller(
				'joborderAddctrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {
					$scope.customerList = [];
					$scope.shipperList = [];
					$scope.consigneeList = [];
					$scope.AolList = [];
					$scope.AodList = [];
					$scope.commodityList = [];
					$scope.isEdit = false;
					$scope.jobOrderDtlList = [];
					$scope.tempType = '';
//					$scope.defaultCurrency = 0;
//					$scope.toCurrency=0;
//					$scope.fromCurrency=0;
					debugger;
					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1; // January is 0!
					var yyyy = today.getFullYear();
					if (dd < 10) {
						dd = '0' + dd
					}
					if (mm < 10) {
						mm = '0' + mm
					}

					 var todate = dd + '/' + mm + '/' + yyyy;
					 var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
					$scope.joborder = {
						service : '',
						jobDate :todate,
						branch : '',
						customer : '',
						shipper : '',
						consignee : '',
						term : '',
						aol : '',
						aod : '',
						origin : '',
						destination : '',
						commodity : '',
						jobStatus : '1',
						currency : '',
						quotationNo : '',
						quotationnum:'',
						salesType : '',
						salesPerson : '',
						nominatedBy : '',
						vendor : '',
						carrier : '',
						flightNo : '',
						flightDate : '',
						exRate : '',
						customsBroker : '',
						mode : '2',
						pickupDate:'',
						stuffingDate:'',
						createdDt:'',
						customsCompletionsDate:'',
						etaDestinationDate:'',
						etaOriginDate:'',
						workOrder:'',
						remarks1:'',
						totPieces:'',
						totNetWeight:'',
						totGrossWeight:'',
						totamt:'',
						trackship1:'',
						trackship2:'',
						joborderDtl : [ {
							joborderDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '1',
							quantity : '',
							rate : '',
							currency : '',
							exRate : '',
							amount : '0',
							
							buySellParty : '',
							status : '1'
						} ],
						joborderTracking : {
							 jobTrackingId : '',
							 jobId : '',
							 totalPcs : '',
							 totalGrosssWeight : '',
						     totalAmount : '',
							 totalNetWeight : '',
							
						},
						joborderTrackingDtl : [{
							select : '',
							commodity : '',
							descriptionGoods : '',
							uom : '',
							length : '0',
							width : '0',
							height : '0',
							noOfPieces : '0',
							netWeight : '0',
							grossWeight : '0',
							chargeableWeight: '0',
							rate: '0',
							amount : '0',
							remarks : ''
						}]
					}
					
					
					$scope.addRowTracking = function() {
						var jobOrderTrackingDtl = {
								select : '',
								commodity : '',
								descriptionGoods : '',
								uom : '',
								length : '0',
								width : '0',
								height : '0',
								noOfPieces : '0',
								netWeight : '0',
								grossWeight : '0',
								chargeableWeight: '0',
								rate: '0',
								amount : '0',
								remarks : ''
						}
						$scope.joborder.joborderTrackingDtl.push(jobOrderTrackingDtl);
					};
					
					$scope.$watchCollection('[joborder.jobDate]',function(newValue, oldValue) {
						if ($scope.joborder.jobDate != '') {
							var frmDate = todate;
							var toDate = $scope.joborder.jobDate;
							var splitarray = new Array();
							splitarray = frmDate.split(" ");
							var date = splitarray[0];
							var time = splitarray[1];
							frmDate = date.split("/");
							frmDate = new Date(frmDate[2],
									frmDate[1] - 1, frmDate[0]);
							toDate = toDate.split("/");
							toDate = new Date(toDate[2],
									toDate[1] - 1, toDate[0]);
							if (toDate >frmDate) {
								logger.logError("Job Date should be less or equal to current date");
								$scope.joborder.jobDate = todate;
							}
						}
					});  

				    $scope.checkDatesCL = function(jobDate){
				        var res = $scope.joborder.jobDate.split("/");
				        $http.get($stateParams.tenantid+'/app/cashbankreceipt/getloggedcompany?closingDate='
				        		+$scope.joborder.jobDate).success(function(datas) {
				            if(datas){
				                logger.logError("Account closed for year "+ res[2]);
				                $scope.joborder.jobDate = todate;
				            }
				        })
				    }

			
					$scope.ratevalues1 = function() {
						if ($scope.joborder.joborderDtl.length != null
								|| $scope.joborder.joborderDtl.length != undefined
								|| $scope.joborder.joborderDtl.length != ""
								|| $scope.joborder.joborderDtl.length != '') {
							for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {
								if (($scope.joborder.joborderDtl[i].transactionType != null)
										|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
										|| ($scope.joborder.joborderDtl[i].transactionType != "")
										|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
									if ($scope.joborder.joborderDtl[i].transactionType == "1") {
										buy1 = parseFloat(buy1)
												+ parseFloat($scope.joborder.joborderDtl[i].amount);
										console.log("i:" + i + " buy1:" + buy1);
									} else {
										if ($scope.joborder.joborderDtl[i].transactionType == "2") {
											sell1 = parseFloat(sell1)
													+ parseFloat($scope.joborder.joborderDtl[i].amount);

										}
									}
								}
							}
							total = parseFloat(sell1) - parseFloat(buy1);

							console.log("total" + total + " sell1:" + sell1);
						}

						$scope.joborder.sell1 = sell1;
						$scope.joborder.buy1 = buy1;
						$scope.joborder.total = total;
					}
		
					
					
					
					$scope
					.$watch(
							'joborder.salesType',
							function(newValue, oldValue) {

								if (newValue != ''
										&& newValue != undefined) {

									if(newValue == '3'){
										$scope.employeeList = [ {
									        id : 'E0040',
									        text : 'E0040-NOMINATED'
									    }]
									}
									else{
										$http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
											 $scope.employeeList = datas.commonUtilityBean;
										    
										}).error(function(data) {

										});
									}
												

												
										
									
								}
							});
					
					$scope.noOfPcs = function() {
						var noOfPcs=0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].noOfPieces==""){
								$scope.joborder.joborderTrackingDtl[i].noOfPieces=0;
								noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPieces)+noOfPcs;
								$scope.joborder.joborderTracking.totalPcs=noOfPcs;
							}
							else{
								noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPieces)+noOfPcs;
								$scope.joborder.joborderTracking.totalPcs=noOfPcs;
							}
							
							
						}
					}
					$scope.noOfNet = function() {
						var noOfNet=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].netWeight==""){
								$scope.joborder.joborderTrackingDtl[i].netWeight=0.0;
								noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
								$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
							}
							else{
								noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
								$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
							}
							
							
						}
					}
					$scope.noOfGross = function() {
						var noOfGross=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].grossWeight==""){
								$scope.joborder.joborderTrackingDtl[i].grossWeight=0.0;
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							else{
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							
							
						}
					}
					$scope.cargoCal = function() {
						var amt=0.0;
						var totAmt=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].chargeableWeight=="" && $scope.joborder.joborderTrackingDtl[i].rate==""){
								$scope.joborder.joborderTrackingDtl[i].chargeableWeight=0.0;
								$scope.joborder.joborderTrackingDtl[i].rate==0.0;
								amt=parseFloat($scope.joborder.joborderTrackingDtl[i].chargeableWeight)*parseFloat($scope.joborder.joborderTrackingDtl[i].rate);
								$scope.joborder.joborderTrackingDtl[i].amount=amt;
								totAmt=parseFloat($scope.joborder.joborderTrackingDtl[i].amount)+totAmt;
								$scope.joborder.joborderTracking.totalAmount=totAmt;
							}
							else{
								amt=parseFloat($scope.joborder.joborderTrackingDtl[i].chargeableWeight)*parseFloat($scope.joborder.joborderTrackingDtl[i].rate);
								$scope.joborder.joborderTrackingDtl[i].amount=amt;
								totAmt=parseFloat($scope.joborder.joborderTrackingDtl[i].amount)+totAmt;
								$scope.joborder.joborderTracking.totalAmount=totAmt;	
							}
								
							
						}
					}
					
					
					
					$scope.modeList = [];
					$scope.modeType = function() {
						var data = {};
						data["id"] = "2";
						data["text"] = "AIR";
						$scope.modeList.push(data);
						$scope.joborder.mode = $scope.modeList[0].id

					}
					$scope.modeType();

					$scope.salesTypeList = [];
					// $scope.getSalesType = function() {
					// var data = {};
					// data["id"] = "1";
					// data["text"] = "CROSS TRADE";
					// $scope.salesTypeList.push(data);
					// data = {};
					// data["id"] = "2";
					// data["text"] = "LOCAL";
					// $scope.salesTypeList.push(data);
					// data = {};
					// data["id"] = "3";
					// data["text"] = "NOMINATED";
					// $scope.salesTypeList.push(data);
					//					    
					//					  
					// }
					// $scope.getSalesType();
					$scope.transactionTypeList = [];

					// $scope.getTransactionType = function() {
					// var data = {};
					// data["id"] = "1";
					// data["text"] = "BUY";
					// $scope.transactionTypeList.push(data);
					// data = {};
					// data["id"] = "2";
					// data["text"] = "SELL";
					// $scope.transactionTypeList.push(data);
					//					    
					// }
					// $scope.getTransactionType();

					$scope.jobStatusList = [];
					$scope.getjobStatus = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "OPEN";
						$scope.jobStatusList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "CLOSED";
						$scope.jobStatusList.push(data);

					}
					$scope.getjobStatus();

					//$scope.PaymentMethodList = [];
					// $scope.getpaymentMethod = function() {
					// var data = {};
					// data["id"] = "1";
					// data["text"] = "PREAPID TO COLLECT";
					// $scope.PaymentMethodList.push(data);
					//					  
					// }
					// $scope.getpaymentMethod();

					$scope.jobDetailStatusList = [];
					$scope.getjobStatus = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "PENDING";
						$scope.jobDetailStatusList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "INVOICED";
						$scope.jobDetailStatusList.push(data);
						data = {};
						data["id"] = "3";
						data["text"] = "DRAFT";
						$scope.jobDetailStatusList.push(data);

					}
					$scope.getjobStatus();

					// $scope.getQuotationType();
					$scope.dropdown = function() {
						debugger;
						$http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
							debugger
						  //  $scope.quotationList = datas.quotationList;	
							$scope.customerList = datas.customerSelectivityList;
							$scope.consigneeDropList = datas.consigneeSelectivityList;
							$scope.shipperDropList = datas.shipperSelectivityList;
							$scope.nominatedDropList = datas.nominatedSelectivityList;
							$scope.vendorDropList = datas.vendorSelectivityList;
							$scope.serviceParnrDropList=datas.serviceParnrSelectivityList;
							$scope.customerBuyList = datas.buyServiceList;
							$scope.customerSellList = datas.sellServiceList;
							$scope.salesTypeList = datas.salesSelectivityList;
							$scope.employeeList = datas.employeeSelectivityList;
							$scope.servicePartnerTypelist = datas.serviceSelectivityList;
							//$scope.PaymentMethodList = datas.paymentSelectivityList;
							$scope.transactionTypeList = datas.transactionSelectivityList;
							$scope.chargeHeadList = datas.airChargeHeadSelectivityList;
							$scope.TermList = datas.termsSelectivityList;
							$scope.UnitList = datas.unitSelectivityList;
							$scope.uomList = datas.uomList;	 
							$scope.sizeTypeList = datas.sizeTypeSelectivityList;
							$scope.commodityList = datas.commoditySelectivityList;	
							$scope.currencylist= datas.currecnySelectivityList;
							$scope.branchList = datas.branchSelectivityList;
						    $scope.portList = datas.airPortSelectivityList;
						}).error(function(data) {

						});
						
						/*$http
						.post(
								$stateParams.tenantid
										+ '/app/airquotation/getServicePartner')
						.success(
								function(datas) {
									debugger
									$scope.customerList = datas.commonUtilityBean;

								}).error(function(data) {

						});
						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getiataList')
								.success(function(datas) {
									debugger
									$scope.portList = datas.commonUtilityBean;

								}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getBranch')
								.success(
										function(datas) {
											$scope.branchList = datas.commonUtilityBean;

										}).error(function(data) {

								});
						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getCurrencyList')
								.success(
										function(datas) {
											$scope.currencylist = angular
													.copy(datas.commonUtilityBean);
										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getServiceList')
								.success(
										function(datas) {
											$scope.servicePartnerTypelist = angular
													.copy(datas.commonUtilityBean);
										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getEmployeeList')
								.success(
										function(datas) {
											$scope.employeeList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getSalesList')
								.success(
										function(datas) {
											$scope.salesTypeList = datas.commonUtilityBean;

										}).error(function(data) {

								});
						
						$http.get($stateParams.tenantid+'/app/airquotation/getcommodity').success(function(datas) {
							
						    $scope.commodityList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getServiceList')
								.success(
										function(datas) {
											$scope.servicePartnerTypelist = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getPaymentList')
								.success(
										function(datas) {
											$scope.PaymentMethodList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getTransactionList')
								.success(
										function(datas) {
											$scope.transactionTypeList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getChargeHeads')
								.success(
										function(datas) {
											$scope.chargeHeadList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getTerms')
								.success(function(datas) {
									$scope.TermList = datas.commonUtilityBean;

								}).error(function(data) {

								});

						$http.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getUnitList')
								.success(function(datas) {
									$scope.UnitList = datas.commonUtilityBean;

								}).error(function(data) {

								});
						
						
						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getuomList')
								.success(function(datas) {
									$scope.uomList = datas.commonUtilityBean;

								}).error(function(data) {

								});
						

						$http.get(
								$stateParams.tenantid
										+ '/app/jobOrderAir/dropDownList')
								.success(function(datas) {
									debugger
									$scope.customerBuyList = datas.buyServiceList;
									$scope.customerSellList = datas.sellServiceList;
								}).error(function(data) {

								});*/
					}

					$scope.dropdown();

					$scope.quotationList = [];
					$scope.checkValidation = function() {

						var alertmsg = "<ui><h4>Please fill the required fields</h4>";
						var msg = "";
						if ($scope.checkundefined($scope.joborder.customer)) {
							msg = msg + "<li>CUSTOMER :Field is required.</li>";
							$scope.changecolor('customer_id');
						} else {
							$scope.clearcolor('customer_id');
						}
						if ($scope.checkundefined($scope.joborder.jobDate)) {
							msg = msg + "<li>JobDate :Field is required.</li>";
							$scope.changecolor('jobDate');
						} else {
							$scope.clearcolor('jobDate');
						}
						if ($scope.checkundefined($scope.joborder.shipper)) {
							msg = msg + "<li>Shipper :Field is required.</li>";
							$scope.changecolor('shipper');
						} else {
							$scope.clearcolor('shipper');
						}
						if ($scope.checkundefined($scope.joborder.service)) {
							msg = msg + "<li>Service :Field is required.</li>";
							$scope.changecolor('service');
						} else {
							$scope.clearcolor('service');
						}
						if ($scope.checkundefined($scope.joborder.branch)) {
							msg = msg + "<li>Branch :Field is required.</li>";
							$scope.changecolor('branch');
						} else {
							$scope.clearcolor('branch');
						}
						if ($scope.checkundefined($scope.joborder.customer)) {
							msg = msg + "<li>Customer :Field is required.</li>";
							$scope.changecolor('customer');
						} else {
							$scope.clearcolor('customer');
						}
						if ($scope.checkundefined($scope.joborder.term)) {
							msg = msg + "<li>Term :Field is required.</li>";
							$scope.changecolor('term');
						} else {
							$scope.clearcolor('term');
						}
						if ($scope.checkundefined($scope.joborder.destination)) {
							msg = msg + "<li>Destination :Field is required.</li>";
							$scope.changecolor('destination');
						} else {
							$scope.clearcolor('destination');
						}
						if ($scope.checkundefined($scope.joborder.aol)) {
							msg = msg + "<li>AOL:Field is required.</li>";
							$scope.changecolor('aol');
						} else {
							$scope.clearcolor('aol');
						}
						if ($scope.checkundefined($scope.joborder.aod)) {
							msg = msg + "<li>AOD:Field is required.</li>";
							$scope.changecolor('aod');
						} else {
							$scope.clearcolor('aod');
						}
						if ($scope.checkundefined($scope.joborder.origin)) {
							msg = msg + "<li>Origin:Field is required.</li>";
							$scope.changecolor('origin');
						} else {
							$scope.clearcolor('origin');
						}
						if ($scope.checkundefined($scope.joborder.quotationNo)) {
							msg = msg + "<li>QuotationNo:Field is required.</li>";
							$scope.changecolor('quotationNo');
						} else {
							$scope.clearcolor('quotationNo');
						}
						/*if ($scope.checkundefined($scope.joborder.commodity)) {
							msg = msg + "<li>Commodity:Field is required.</li>";
							$scope.changecolor('commodity');
						} else {
							$scope.clearcolor('commodity');
						}*/
						
						if ($scope.checkundefined($scope.joborder.currency)) {
							msg = msg + "<li>Currency:Field is required.</li>";
							$scope.changecolor('currency');
						} else {
							$scope.clearcolor('currency');
						}
						if ($scope.checkundefined($scope.joborder.exRate)) {
							msg = msg + "<li>ExRate:Field is required.</li>";
							$scope.changecolor('exRate');
						} else {
							$scope.clearcolor('exRate');
						}
						if ($scope.checkundefined($scope.joborder.salesType)) {
							msg = msg + "<li>salesType:Field is required.</li>";
							$scope.changecolor('salesType');
						} else {
							$scope.clearcolor('salesType');
						}
						if ($scope.checkundefined($scope.joborder.salesPerson)) {
							msg = msg + "<li>SalesPerson:Field is required.</li>";
							$scope.changecolor('salesPerson');
						} else {
							$scope.clearcolor('salesPerson');
						}
						/*if ($scope.checkundefined($scope.joborder.nominatedBy)) {
							msg = msg + "<li>nominatedBy:Field is required.</li>";
							$scope.changecolor('NominatedBy');
						} else {
							$scope.clearcolor('nominatedBy');
						}*/
						/*
						if ($scope.checkundefined($scope.joborder.carrier)) {
							msg = msg + "<li>Carrier:Field is required.</li>";
							$scope.changecolor('carrier');
						} else {
							$scope.clearcolor('carrier');
						}*/
						if ($scope.checkundefined($scope.joborder.flightNo)) {
							msg = msg + "<li>FlightNo:Field is required.</li>";
							$scope.changecolor('flightNo');
						} else {
							$scope.clearcolor('flightNo');
						}
						if ($scope.checkundefined($scope.joborder.flightDate)) {
							msg = msg + "<li>FlightDate:Field is required.</li>";
							$scope.changecolor('flightDate');
						} else {
							$scope.clearcolor('flightDate');
						}
						
						
						if ($scope.checkundefined($scope.joborder.vendor)) {
							msg = msg + "<li>Vendor:Field is required.</li>";
							$scope.changecolor('vendor');
						} else {
							$scope.clearcolor('vendor');
						}
						
						
						/*if ($scope.checkundefined($scope.joborder.customsBroker)) {
							msg = msg + "<li>CustomsBroker:Field is required.</li>";
							$scope.changecolor('customsBroker');
						} else {
							$scope.clearcolor('customsBroker');
						}*/
						
						angular
								.forEach(
										$scope.joborder.joborderDtl,
										function(chargesDetail, index) {
											debugger
											if ($scope
													.checkundefined(chargesDetail.chargeHead)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Charge Heads :Field is required.</li>";
												$scope
														.changecolor('chargeHeads'
																+ index);
											} else {
												$scope.clearcolor('chargeHeads'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.unit)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Unit :Field is required.</li>";
												$scope.changecolor('unit'
														+ index);
											} else {
												$scope.clearcolor('unit'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.currency)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# CURRENCY :Field is required.</li>";
												$scope.changecolor('currency'
														+ index);
											} else {
												$scope.clearcolor('currency'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.quantity)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Quantity :Field is required.</li>";
												$scope.changecolor('quantity'
														+ index);
												
											} else {
												$scope.changecolor('quantity'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.rate)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Rate :Field is required.</li>";
												$scope
												.changecolor('rate'
														+ index);
											}
											else {
												$scope.clearcolor('rate'
														+ index);
											}
										
											if ($scope
													.checkundefined(chargesDetail.transactionType)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
												$scope
												.changecolor('transactionTypes'
														+ index);
											}else {
												$scope.clearcolor('transactionTypes'
														+ index);
											}
											
											if ($scope
													.checkundefined(chargesDetail.buySellParty)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Buy Sell:Field is required.</li>";
												$scope
												.changecolor('buySellPartys'
														+ index);
											}
											else {
												$scope.clearcolor('buySellPartys'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.amount)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Amount:Field is required.</li>";
												$scope
												.changecolor('amount'
														+ index);
											}
											else {
												$scope.clearcolor('amount'
														+ index);
											}

											if ($scope
													.checkundefined(chargesDetail.exRate)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Exchange Rate:Field is required.</li>";
												$scope
												.changecolor('exRate'
														+ index);
											}
											else {
												$scope.clearcolor('exRate'
														+ index);
											}

											if ($scope
													.checkundefined(chargesDetail.transactionType)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
												$scope
												.changecolor('transactionTypes'
														+ index);
											}
											else {
												$scope.clearcolor('transactionTypes'
														+ index);
											}

											if ($scope
													.checkundefined(chargesDetail.status)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Status :Field is required.</li>";
												$scope
												.changecolor('status'
														+ index);
											}
											else {
												$scope.clearcolor('status'
														+ index);
											}
											
										

										});
						
						/*angular.forEach($scope.joborder.joborderTrackingDtl, function(TrackingDtl,
								index) {
							debugger
							if ($scope.checkundefined(TrackingDtl.commodity)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Commodity :Field is required.</li>";
								$scope.changecolor('Commodity' + index);
							} else {
								$scope.clearcolor('Commodity' + index);
							}
							if ($scope.checkundefined(TrackingDtl.descriptionGoods)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# DescriptionGoods :Field is required.</li>";
								$scope.changecolor('descriptionGoods' + index);
							} else {
								$scope.clearcolor('descriptionGoods' + index);
							}
							if ($scope.checkundefined(TrackingDtl.uom)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# LWH UOM :Field is required.</li>";
								$scope.changecolor('uom' + index);
							} else {
								$scope.clearcolor('uom' + index);
							}
							if ($scope.checkundefined(TrackingDtl.noOfPieces)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# NoOfPieces :Field is required.</li>";
								$scope.changecolor('noOfPieces' + index);
							} else {
								$scope.clearcolor('noOfPieces' + index);
							}
							if ($scope.checkundefined(TrackingDtl.netWeight)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# NetWeight :Field is required.</li>";
								$scope.changecolor('netWeight' + index);
							} else {
								$scope.clearcolor('netWeight' + index);
							}
							if ($scope.checkundefined(TrackingDtl.grossWeight)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# GrossWeight :Field is required.</li>";
								$scope.changecolor('GrossWeight' + index);
							} else {
								$scope.clearcolor('GrossWeight' + index);
							}
							if ($scope.checkundefined(TrackingDtl.amount)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Amount :Field is required.</li>";
								$scope.changecolor('Amount' + index);
							} else {
								$scope.clearcolor('Amount' + index);
							}
							

						});*/
						alertmsg = alertmsg + msg + "</ui>";
						if ($scope.checkundefined(msg)) {
							return '';
						} else {
							return alertmsg;
						}

					}

					$scope.checkundefined = function(value) {
						var invalid = false;
						if (value == undefined || value == 'undefined'
								|| value == null || value == 'null'
								|| value == '') {
							invalid = true;
						}
						return invalid;

					}

					$scope.changecolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "red");
						;

					}
					$scope.clearcolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "#e8dddd");
						;

					}
					$scope.isEdit = false;
					$scope.addRow = function() {
						var jobOrderDtl = {
							joborderDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '1',
							quantity : '',
							rate : '',
							currency : '',
							exRate : '1',
							amount : '0',
						
							buySellParty : '',
							status : '1'
						}
						$scope.joborder.joborderDtl.push(jobOrderDtl);
					};

					$scope.deleteIds = [];
					$scope.removeRow = function() {
						if($scope.joborder.joborderDtl.length>1){
						var len = $scope.joborder.joborderDtl.length;
						for (var index = len - 1; index < len; index--) {
							if ($scope.joborder.joborderDtl[index].select == true) {
								if ($scope.joborder.joborderDtl[index].jobDtlId != null
										&& $scope.joborder.joborderDtl[index].jobDtlId > 0) {
									$scope.deleteIds
											.push($scope.joborder.joborderDtl[index].jobDtlId);
								}
								$scope.joborder.joborderDtl.splice(index, 1);
								$scope.ratevalues();
							}
						}
						}
						else{
							logger.logError("Atleast one row required");
						}
					};
					
					$scope.removeRowTracking = function() {
						var len = $scope.joborder.joborderTrackingDtl.length;
						for (var index = len - 1; index < len; index--) {
							if ($scope.joborder.joborderTrackingDtl[index].select == true) {
								
								$scope.joborder.joborderTrackingDtl.splice(index, 1);
							}
						}
					};
					
					$scope.ratevalues = function() {
						var buy1 = 0;
						var sell = 0;
						var sell1 = 0;
						var amount = 0;

						var total = 0;
						if ($scope.joborder.joborderDtl.length != null
								|| $scope.joborder.joborderDtl.length != undefined
								|| $scope.joborder.joborderDtl.length != ""
								|| $scope.joborder.joborderDtl.length != '') {
							{
								for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {

									var amount1 = [];
									var amount = [];
									if (($scope.joborder.joborderDtl[i].transactionType != null)
											|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
											|| ($scope.joborder.joborderDtl[i].transactionType != "")
											|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
										if ($scope.joborder.joborderDtl[i].transactionType == "1") {

											if (($scope.joborder.joborderDtl[i].quantity != null
													|| $scope.joborder.joborderDtl[i].quantity != undefined
													|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
													&& ($scope.joborder.joborderDtl[i].rate != null
															|| $scope.joborder.joborderDtl[i].rate != undefined
															|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
													&& ($scope.joborder.joborderDtl[i].exRate != null
															|| $scope.joborder.joborderDtl[i].exRate == undefined
															|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
												amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
														* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
												$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

												buy1 = parseFloat(buy1)
														+ parseFloat($scope.joborder.joborderDtl[i].amount);
												console.log("i:" + i + " buy1:"
														+ buy1);

											}
										}

										else {
											if ($scope.joborder.joborderDtl[i].transactionType == "2") {

												if (($scope.joborder.joborderDtl[i].quantity != null
														|| $scope.joborder.joborderDtl[i].quantity != undefined
														|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
														&& ($scope.joborder.joborderDtl[i].rate != null
																|| $scope.joborder.joborderDtl[i].rate != undefined
																|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
														&& ($scope.joborder.joborderDtl[i].exRate != null
																|| $scope.joborder.joborderDtl[i].exRate == undefined
																|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
													amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
															* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
													$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

													sell1 = parseFloat(sell1)
															+ parseFloat($scope.joborder.joborderDtl[i].amount);
													console
															.log("i:" + i
																	+ " sell1:"
																	+ sell1);
												}
											}
										}

									}

									$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]).toFixed(2);

								}
								total = parseFloat(sell1) - parseFloat(buy1);

								console
										.log("total" + total + " sell1:"
												+ sell1);

							}
						}
						$scope.joborder.sell1 = sell1.toFixed(2);
						$scope.joborder.buy1 = buy1.toFixed(2);
						$scope.joborder.total = total.toFixed(2);

					}
					
					$scope.$watch('joborder.jobStatus', function(newValue,
							oldValue) {
						if (newValue != '' && newValue != undefined) {
							if(newValue==2)
								{
								$scope.Add=false;
							
								}else{
									$scope.Add=true;
									
								}
						}
						
					});
					
					$scope.$watch('joborder.jobDate', function(newValue,
							oldValue) {
						if (newValue != '' && newValue != undefined) {
						    
						    $http
							.post(
									$stateParams.tenantid
											+ '/app/jobOrderAir/getQuotationList',
										newValue)
							.success(
									function(data) {
										debugger
										$scope.quotationList = data.quotationList;
										
									});
						}
						
					});
					 var defaultCurrency = '';
					 var  fromCurrency='';
					 var toCurrency='';
					 
						$scope.$watch('joborder.currency', function(newValue,
								oldValue) {
							if (newValue != '' && newValue != undefined) {
							    
							    $http
								.get(
										$stateParams.tenantid
												+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
								.success(
										function(data) {
											debugger
//											if(!$scope.isEdit){
//												$scope.joborder.exRate = data.defaultCurrency;
//											}
											
											defaultCurrency = data.defaultCurrency;
											fromCurrency=data.fromCurrency;
											toCurrency=data.toCurrency;
											$scope.checkExRate();
										});
							}
							
						});
						
						$scope.checkExRate = function(){
							if($scope.joborder.exRate >= fromCurrency && $scope.joborder.exRate <= toCurrency){
								
							}
							else{
								logger.logError("Exchange Rate Between "+fromCurrency+ " and " +toCurrency);
								$scope.joborder.exRate ='';
							}
						}

						

					$scope
							.$watch(
									'joborder.quotationNo',
									function(newValue, oldValue) {

										if (newValue != ''
												&& newValue != undefined) {

											$http
													.post(
															$stateParams.tenantid
																	+ '/app/airquotation/edit',
															parseInt(newValue))
													.success(
															function(data) {
																debugger

																if (data.lQuotationBean[0].salesPerson != null
																		&& data.lQuotationBean[0].salesPerson != '') {
																	$scope.joborder.salesPerson = data.lQuotationBean[0].salesPerson
																			.toString();
																}
																if (data.lQuotationBean[0].carrier != null
																		&& data.lQuotationBean[0].carrier != '') {
																	$scope.joborder.carrier = data.lQuotationBean[0].carrier
																			.toString();
																}
																if (data.lQuotationBean[0].flightNo != null
																		&& data.lQuotationBean[0].flightNo != '') {
																	$scope.joborder.flightNo = data.lQuotationBean[0].flightNo;
																}

																if (data.lQuotationBean[0].flightDate != null
																		&& data.lQuotationBean[0].flightDate != '') {
																	$scope.joborder.flightDate = data.lQuotationBean[0].flightDate;
																}

																if (data.lQuotationBean[0].service != null
																		&& data.lQuotationBean[0].service != '') {
																	$scope.joborder.service = data.lQuotationBean[0].service
																			.toString();
																}
																if (data.lQuotationBean[0].commodity != null
																		&& data.lQuotationBean[0].commodity != '') {
																	$scope.joborder.commodity = data.lQuotationBean[0].commodity;
																}

																if (data.lQuotationBean[0].branch != null
																		&& data.lQuotationBean[0].branch != '') {
																	$scope.joborder.branch = data.lQuotationBean[0].branch
																			.toString();
																}
																if (data.lQuotationBean[0].mode != null
																		&& data.lQuotationBean[0].mode != '') {
																	$scope.joborder.mode = data.lQuotationBean[0].mode
																			.toString();
																}
																if (data.lQuotationBean[0].aol != null
																		&& data.lQuotationBean[0].aol != '') {
																	$scope.joborder.aol = data.lQuotationBean[0].aol
																			.toString();
																}
																if (data.lQuotationBean[0].aod != null
																		&& data.lQuotationBean[0].aod != '') {
																	$scope.joborder.aod = data.lQuotationBean[0].aod
																			.toString();
																}
																if (data.lQuotationBean[0].term != null
																		&& data.lQuotationBean[0].term != '') {
																	$scope.joborder.term = data.lQuotationBean[0].term
																			.toString();
																}
																if (data.lQuotationBean[0].origin != null
																		&& data.lQuotationBean[0].origin != '') {
																	$scope.joborder.origin = data.lQuotationBean[0].origin
																			.toString();
																}
																if (data.lQuotationBean[0].destination != null
																		&& data.lQuotationBean[0].destination != '') {
																	$scope.joborder.destination = data.lQuotationBean[0].destination
																			.toString();
																}
																if (data.lQuotationBean[0].customer != null
																		&& data.lQuotationBean[0].customer != '') {
																	$scope.joborder.customer = data.lQuotationBean[0].customer
																			.toString();
																}
																if (data.lQuotationBean[0].shipper != null
																		&& data.lQuotationBean[0].shipper != '') {
																	$scope.joborder.shipper = data.lQuotationBean[0].shipper
																			.toString();
																}
																if (data.lQuotationBean[0].consignee != null
																		&& data.lQuotationBean[0].consignee != '') {
																	$scope.joborder.consignee = data.lQuotationBean[0].consignee
																			.toString();
																}
																if (data.lQuotationBean[0].nominatedBy != null
																		&& data.lQuotationBean[0].nominatedBy != '') {
																	$scope.joborder.nominatedBy = data.lQuotationBean[0].nominatedBy
																			.toString();
																}
																if (data.lQuotationBean[0].vendor != null
																		&& data.lQuotationBean[0].vendor != '') {
																	$scope.joborder.vendor = data.lQuotationBean[0].vendor
																			.toString();
																}
																if (data.lQuotationBean[0].currency != null
																		&& data.lQuotationBean[0].currency != '') {
																	$scope.joborder.currency = data.lQuotationBean[0].currency
																			.toString();
																}
																if (data.lQuotationBean[0].salesType != null
																		&& data.lQuotationBean[0].salesType != '') {
																	$scope.joborder.salesType = data.lQuotationBean[0].salesType
																			.toString();
																}
																$scope.joborder.joborderDtl = data.lQuotationBean[0].quotationDtl;
																for (var i = 0; i < $scope.joborder.joborderDtl.length; i++) {
																	$scope.joborder.joborderDtl[i].chargeHead = $scope.joborder.joborderDtl[i].chargeHeads
																			.toString();
																	$scope.joborder.joborderDtl[i].unit = $scope.joborder.joborderDtl[i].unit
																			.toString();
																	$scope.joborder.joborderDtl[i].currency = $scope.joborder.joborderDtl[i].currency
																			.toString();																
																	$scope.joborder.joborderDtl[i].transactionType = $scope.joborder.joborderDtl[i].transactionType
																			.toString();
																	$scope.joborder.joborderDtl[i].buySellParty = $scope.joborder.joborderDtl[i].buySell
																			.toString();
																	$scope.joborder.joborderDtl[i].quantity = $scope.joborder.joborderDtl[i].qty;
																	$scope.joborder.joborderDtl[i].exRate = '1';
																	$scope.joborder.joborderDtl[i].status='1';
																	$scope.ratevalues();
																}

															});
										}
									})

					$scope.hdrData = $scope.joborder;
					$scope.dtlData = $scope.jobOrderDtl;
					$scope.reset = function() {
						$scope.modeList = [];
						$scope.modeType = function() {
							var data = {};
							data["id"] = "2";
							data["text"] = "AIR";
							$scope.modeList.push(data);
							$scope.joborder.mode = $scope.modeList[0].id

						}
						$scope.modeType();
						/*$scope.joborder = $scope.hdrData;
						$scope.jobOrderDtl = $scope.dtlData;*/
						$scope.	joborder.service='',
							
							$scope.	joborder.branch='',
							$scope.	joborder.customer='',
							$scope.	joborder.shipper='',
							$scope.	joborder.consignee = '',
							$scope.	joborder.term = '',
							$scope.	joborder.aol='',
							$scope.	joborder.aod ='',
							$scope.	joborder.origin='',
							$scope.	joborder.destination='',
							$scope.	joborder.commodity='',
							$scope.	joborder.jobStatus='',
							$scope.	joborder.currency='',
							$scope.	joborder.quotationNo='',
							$scope.	joborder.salesType='',
							$scope.	joborder.salesPerson='',
							$scope.joborder.nominatedBy='',
							$scope.	joborder.vendor='',
							$scope.	joborder.carrier='',
							$scope.	joborder.flightNo='',
							$scope.	joborder.flightDate='',
							$scope.	joborder.exRate='',
							$scope.	joborder.customsBroker='',
							$scope.	joborder.jbId ='',
							$scope.	joborder.aodName='',
							$scope.	joborder.aolName='',
							$scope.	joborder.destinationName ='',
							$scope.	joborder.custName ='' ,
							$scope.	joborder.orgnName ='',
							$scope.	joborder.mode='2',
							$scope.	joborder.truckship1='',
							$scope.	joborder.truckship2='',
					
						$scope.	joborder.buy1='',
						$scope.	joborder.sell1 ='',
						$scope.	joborder.buy='',
						$scope.	joborder.sell='',
							$scope.	joborder.joborderDtl=[ {
								joborderDtlId : '',
								chargeHead : '',
								unit : '',
								transactionType : '1',
								quantity : '',
								rate : '',
								currency : '',
								exRate : '',
								amount : '0',								
								buySellParty : '',
								status : ''
							} ]
							
						
					};

					$scope.cancel = function() {
						$state.go('app.air.joborder.list', {
							tenantid : $stateParams.tenantid
						});
					}

					

					$scope.saveJob = function() {
						console.log($scope.joborder);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							if($scope.joborder.joborderDtl.length>0){
								if($scope.joborder.joborderTrackingDtl.length>0){
									var temp=$scope.joborder.remarks1;
									if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
									$scope.joborder.remarks1= todate+' '+time+ '     ' +  '     ' + temp  ;
									}
							$http.post(
									$stateParams.tenantid
											+ '/app/jobOrderAir/save',
									$scope.joborder).success(function(datas) {
								debugger
								if (datas.success == true) {
									logger.logSuccess(datas.message);
									$location.url($stateParams.tenantid
											+ '/jobOrderAir/edit?rowid=' + datas.jobId);
									if ($scope.createQuote) {
									} else {
									}

								} else {
									logger.logError(datas.message);
								}
							}).error(function(data) {
								logger.logError("Please try again");
							});
							
								}else{
									logger.logError("Atleast One Row Required in Cargo Details");
								}
							}
							else{
								logger.logError("Atleast One Row Required");
							}
						}

					}

			

					/*$scope.print1 = function(rowid) {
						rowid = 4852;
						var test = parseInt(rowid);
						var url = $stateParams.tenantid
								+ '/app/jobOrderAir/print1?rowid=' + rowid
						var wnd = window
								.open(
										url,
										'HISERP',
										'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						wnd.print();

					};*/

				});

app
		.controller(
				'joborderEditctrl',
				function($scope, $timeout, $stateParams, $filter, $rootScope,
						$http, $location, logger, utilsService, $state,
						sharedProperties, $window, ngDialog, $interval,
						validationService, toaster, $controller, $injector) {
					$scope.customerList = [];
					$scope.shipperList = [];
					$scope.consigneeList = [];
					$scope.AolList = [];
					$scope.AodList = [];
					$scope.commodityList = [];
					$scope.isEdit = false;
					$scope.jobOrderDtlList = [];
					$scope.tempType = '';
					debugger;
					$scope.joborder = {
						service : '',
						jobDate : '',
						branch : '',
						customer : '',
						shipper : '',
						consignee : '',
						term : '',
						aol : '',
						aod : '',
						origin : '',
						destination : '',
						commodity : '',
						jobStatus : '',
						currency : '',
						quotationNo : '',
						quotationnum:'',
						salesType : '',
						salesPerson : '',
						nominatedBy : '',
						vendor : '',
						carrier : '',
						flightNo : '',
						flightDate : '',
						exRate : '',
						customsBroker : '',
						mode : '',
						remarks1:'',
						tempremarks:'',
						truckship1:'',
						truckship2:'',
						joborderDtl : [ {
							joborderDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '1',
							quantity : '',
							rate : '',
							currency : '',
							exRate : '',
							amount : '0',						
							buySellParty : '',
							status : ''
						} ],
						joborderTracking : {
							 jobTrackingId : '',
							 jobId : '',
							 totalPcs : '',
							 totalGrosssWeight : '',
						     totalAmount : '',
							 totalNetWeight : '',
							
						},
						joborderTrackingDtl : [{
							select : '',
							commodity : '',
							descriptionGoods : '',
							uom : '',
							length : '0',
							width : '0',
							height : '0',
							noOfPieces : '0',
							netWeight : '0',
							grossWeight : '0',
							chargeableWeight: '0',
							rate: '0',
							amount : '0',
							remarks : ''
						   
						}]
					}
//					$scope.defaultCurrency = 0;
//					$scope.fromCurrency=0;
//					$scope.toCurrency=0;
					$scope.addRowTracking = function() {
						var jobOrderTrackingDtl = {
								select : '',
								commodity : '',
								descriptionGoods : '',
								uom : '',
								length : '0',
								width : '0',
								height : '0',
								noOfPieces : '0',
								netWeight : '0',
								grossWeight : '0',
								chargeableWeight: '0',
								rate: '0',
								amount : '0',
								remarks : ''
								
						}
						$scope.joborder.joborderTrackingDtl.push(jobOrderTrackingDtl);
					};
					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1; // January is 0!
					var yyyy = today.getFullYear();
					if (dd < 10) {
						dd = '0' + dd
					}
					if (mm < 10) {
						mm = '0' + mm
					}

					 var todate = dd + '/' + mm + '/' + yyyy;
					 
					 var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
					 
					/* $scope.jobOrderDtl = {} */

					// $scope.isQuot=false;
					 var defaultCurrency = '';
					 var  fromCurrency='';
					 var toCurrency='';
					 
					 var userid=$('#tempw').val();
					 
					 $scope.$watch('joborder.jobStatus', function(newValue,
								oldValue) {
							if (newValue != '' && newValue != undefined) {
								if(newValue==2 && (userid == 'A0001' || userid == 'E0003'))
									{
									$scope.Add=false;
									$scope.disable=true;
									
									$scope.unique = true
									}else if(newValue==2 && userid != 'A0001' && userid != 'E0003')
									{
										$scope.Add=false;
										$scope.disable=true;
										
										$scope.unique = false;
										var noOfDays=0;
										if ($scope.joborder.jobDate!='' && todate!='') {
											noOfDays = moment(todate, 'DD/MM/YYYY').diff(moment($scope.joborder.jobDate, 'DD/MM/YYYY'), 'days');
										}
										if (noOfDays < 90) {
										$scope.trackDtl=false;	
										$scope.trackDtlAdd=true;
										}
										else{
										$scope.trackDtl=true;	
										$scope.trackDtlAdd=false;
										}
										}
									else{
										$scope.Add=true;
										$scope.disable=false;
										$scope.trackDtl=false;	
										$scope.trackDtlAdd=true;
									}
							}
							
						});
					
						$scope.$watch('joborder.currency', function(newValue,
								oldValue) {
							if (newValue != '' && newValue != undefined) {
							    
							    $http
								.get(
										$stateParams.tenantid
												+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
								.success(
										function(data) {
											debugger
//											if(!$scope.isEdit){
//												$scope.joborder.exRate = data.defaultCurrency;
//											}
											
											defaultCurrency = data.defaultCurrency;
											fromCurrency=data.fromCurrency;
											toCurrency=data.toCurrency;
											
										});
							}
							
						});
						
						$scope.checkExRate = function(){
							if($scope.joborder.exRate >= fromCurrency && $scope.joborder.exRate <= toCurrency){
								
							}
							else{
								logger.logError("Exchange Rate Between "+fromCurrency+ " and " +toCurrency);
								$scope.joborder.exRate ='';
							}
						}

						
						
					$scope.removeRowTracking = function() {
						var len = $scope.joborder.joborderTrackingDtl.length;
						for (var index = len - 1; index < len; index--) {
							if ($scope.joborder.joborderTrackingDtl[index].select == true) {
								
								$scope.joborder.joborderTrackingDtl.splice(index, 1);
							}
						}
					};
					$scope.jobId = parseInt($location.search().rowid);

					$scope.ratevalues1 = function() {
						if ($scope.joborder.joborderDtl.length != null
								|| $scope.joborder.joborderDtl.length != undefined
								|| $scope.joborder.joborderDtl.length != ""
								|| $scope.joborder.joborderDtl.length != '') {
							for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {
								if (($scope.joborder.joborderDtl[i].transactionType != null)
										|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
										|| ($scope.joborder.joborderDtl[i].transactionType != "")
										|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
									if ($scope.joborder.joborderDtl[i].transactionType == "1") {
										buy1 = parseFloat(buy1)
												+ parseFloat($scope.joborder.joborderDtl[i].amount);
										console.log("i:" + i + " buy1:" + buy1);
									} else {
										if ($scope.joborder.joborderDtl[i].transactionType == "2") {
											sell1 = parseFloat(sell1)
													+ parseFloat($scope.joborder.joborderDtl[i].amount);

										}
									}
								}
							}
							total = parseFloat(buy1) - parseFloat(sell1);

							console.log("total" + total + " sell1:" + sell1);
						}

						$scope.joborder.sell1 = sell1;
						$scope.joborder.buy1 = buy1;
						$scope.joborder.total = total;
					}
					
					

					$scope
					.$watch(
							'joborder.salesType',
							function(newValue, oldValue) {

								if (newValue != ''
										&& newValue != undefined) {

									if(newValue == '3'){
										$scope.employeeList = [ {
									        id : 'E0040',
									        text : 'E0040-NOMINATED'
									    }]
									}
									else{
										$http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
											 $scope.employeeList = datas.commonUtilityBean;
										    
										}).error(function(data) {

										});
									}
								
								}
							});
					
					
					/*$http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
						 $scope.employeeList = datas.commonUtilityBean;
					    
					}).error(function(data) {

					});*/
					
					$scope.ratevalues = function() {
						var buy1 = 0;
						var sell = 0;
						var sell1 = 0;
						var amount = 0;

						var total = 0;
						if ($scope.joborder.joborderDtl.length != null
								|| $scope.joborder.joborderDtl.length != undefined
								|| $scope.joborder.joborderDtl.length != ""
								|| $scope.joborder.joborderDtl.length != '') {
							{
								for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {

									var amount1 = [];
									var amount = [];
									if (($scope.joborder.joborderDtl[i].transactionType != null)
											|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
											|| ($scope.joborder.joborderDtl[i].transactionType != "")
											|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
										if ($scope.joborder.joborderDtl[i].transactionType == "1") {

											if (($scope.joborder.joborderDtl[i].quantity != null
													|| $scope.joborder.joborderDtl[i].quantity != undefined
													|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
													&& ($scope.joborder.joborderDtl[i].rate != null
															|| $scope.joborder.joborderDtl[i].rate != undefined
															|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
													&& ($scope.joborder.joborderDtl[i].exRate != null
															|| $scope.joborder.joborderDtl[i].exRate == undefined
															|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
												amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
														* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
												$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

												buy1 = parseFloat(buy1)
														+ parseFloat($scope.joborder.joborderDtl[i].amount);
												console.log("i:" + i + " buy1:"
														+ buy1);

											}
										}

										else {
											if ($scope.joborder.joborderDtl[i].transactionType == "2") {

												if (($scope.joborder.joborderDtl[i].quantity != null
														|| $scope.joborder.joborderDtl[i].quantity != undefined
														|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
														&& ($scope.joborder.joborderDtl[i].rate != null
																|| $scope.joborder.joborderDtl[i].rate != undefined
																|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
														&& ($scope.joborder.joborderDtl[i].exRate != null
																|| $scope.joborder.joborderDtl[i].exRate == undefined
																|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
													amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
															* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
													$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

													sell1 = parseFloat(sell1)
															+ parseFloat($scope.joborder.joborderDtl[i].amount);
													console
															.log("i:" + i
																	+ " sell1:"
																	+ sell1);
												}
											}
										}

									}

									$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]).toFixed(2);

								}
								total = parseFloat(sell1) - parseFloat(buy1);

								console
										.log("total" + total + " sell1:"
												+ sell1);

							}
						}
						$scope.joborder.sell1 = sell1.toFixed(2);
						$scope.joborder.buy1 = buy1.toFixed(2);
						$scope.joborder.total = total.toFixed(2);

					}
					
					$scope.CheckExRateDtl = function(currecny,index){
						alert('Test');
						if (currecny != '' && currecny != undefined) {
					    
					    $http
						.get(
								$stateParams.tenantid
										+ '/app/currency/getExchangeRate?currencyId='+parseInt(currecny))
						.success(
								function(data) {
									debugger
									/*if(!$scope.isEdit){
										$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
									}*/
									
									defaultCurrency1 = data.defaultCurrency;
									fromCurrency1=data.fromCurrency;
									toCurrency1=data.toCurrency;
									$scope.checkExRate($scope.joborder.joborderDtl[index].exRate,index);
								});
					}
						$scope.ratevalues();
					}
					$scope.noOfPcs = function() {
						var noOfPcs=0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].noOfPieces==""){
								$scope.joborder.joborderTrackingDtl[i].noOfPieces=0;
								noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPieces)+noOfPcs;
								$scope.joborder.joborderTracking.totalPcs=noOfPcs;
							}
							else{
								noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPieces)+noOfPcs;
								$scope.joborder.joborderTracking.totalPcs=noOfPcs;
							}
							
							
						}
					}
					$scope.noOfNet = function() {
						var noOfNet=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].netWeight==""){
								$scope.joborder.joborderTrackingDtl[i].netWeight=0.0;
								noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
								$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
							}
							else{
								noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
								$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
							}
							
							
						}
					}
					$scope.noOfGross = function() {
						var noOfGross=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].grossWeight==""){
								$scope.joborder.joborderTrackingDtl[i].grossWeight=0.0;
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							else{
								noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
								$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
							}
							
							
						}
					}
					$scope.cargoCal = function() {
						var amt=0.0;
						var totAmt=0.0;
						for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
							if($scope.joborder.joborderTrackingDtl[i].chargeableWeight=="" && $scope.joborder.joborderTrackingDtl[i].rate==""){
								$scope.joborder.joborderTrackingDtl[i].chargeableWeight=0.0;
								$scope.joborder.joborderTrackingDtl[i].rate==0.0;
								amt=parseFloat($scope.joborder.joborderTrackingDtl[i].chargeableWeight)*parseFloat($scope.joborder.joborderTrackingDtl[i].rate);
								$scope.joborder.joborderTrackingDtl[i].amount=amt;
								totAmt=parseFloat($scope.joborder.joborderTrackingDtl[i].amount)+totAmt;
								$scope.joborder.joborderTracking.totalAmount=totAmt;
							}
							else{
								amt=parseFloat($scope.joborder.joborderTrackingDtl[i].chargeableWeight)*parseFloat($scope.joborder.joborderTrackingDtl[i].rate);
								$scope.joborder.joborderTrackingDtl[i].amount=amt;
								totAmt=parseFloat($scope.joborder.joborderTrackingDtl[i].amount)+totAmt;
								$scope.joborder.joborderTracking.totalAmount=totAmt;	
							}
								
							
						}
					}
					$scope.modeList = [];
					$scope.modeType = function() {
						var data = {};
						data["id"] = "2";
						data["text"] = "AIR";
						$scope.modeList.push(data);
						$scope.joborder.mode = $scope.modeList[0].id

					}
					$scope.modeType();

					$scope.submitupdate = function() {
					}

					$scope.salesTypeList = [];
					
					$scope.transactionTypeList = [];

					
					$scope.jobStatusList = [];
					$scope.getjobStatus = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "OPEN";
						$scope.jobStatusList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "CLOSED";
						$scope.jobStatusList.push(data);

					}
					$scope.getjobStatus();

					//$scope.PaymentMethodList = [];
					// $scope.getpaymentMethod = function() {
					// var data = {};
					// data["id"] = "1";
					// data["text"] = "PREAPID TO COLLECT";
					// $scope.PaymentMethodList.push(data);
					//			  
					// }
					// $scope.getpaymentMethod();

					$scope.jobDetailStatusList = [];
					$scope.getjobStatus = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "PENDING";
						$scope.jobDetailStatusList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "INVOICED";
						$scope.jobDetailStatusList.push(data);
						data = {};
						data["id"] = "3";
						data["text"] = "DRAFT";
						$scope.jobDetailStatusList.push(data);

					}
					$scope.getjobStatus();
					
					$scope.viewJob = function(jobId) {
						$location.url($stateParams.tenantid
								+ '/jobOrderAir/view?rowid=' + jobId);
					}
					
					$scope.viewQuotation = function(quotationNo) {
						debugger
							$location.url($stateParams.tenantid+'/airQuotation/view?QuotHdId='+quotationNo);
						
					}

					// $scope.getQuotationType();
					$scope.dropdown = function() {
						debugger;
						$http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
							debugger
						  //  $scope.quotationList = datas.quotationList;	
							$scope.customerList = datas.customerSelectivityList;
							$scope.consigneeDropList = datas.consigneeSelectivityList;
							$scope.shipperDropList = datas.shipperSelectivityList;
							$scope.nominatedDropList = datas.nominatedSelectivityList;
							$scope.vendorDropList = datas.vendorSelectivityList;
							$scope.serviceParnrDropList=datas.serviceParnrSelectivityList;
							$scope.customerBuyList = datas.buyServiceList;
							$scope.customerSellList = datas.sellServiceList;
							$scope.salesTypeList = datas.salesSelectivityList;
							$scope.employeeList = datas.employeeSelectivityList;
							$scope.servicePartnerTypelist = datas.serviceSelectivityList;
							//$scope.PaymentMethodList = datas.paymentSelectivityList;
							$scope.transactionTypeList = datas.transactionSelectivityList;
							$scope.chargeHeadList = datas.airChargeHeadSelectivityList;
							$scope.TermList = datas.termsSelectivityList;
							$scope.UnitList = datas.unitSelectivityList;
							$scope.uomList = datas.uomList;	 
							$scope.sizeTypeList = datas.sizeTypeSelectivityList;
							$scope.commodityList = datas.commoditySelectivityList;	
							$scope.currencylist= datas.currecnySelectivityList;
							$scope.branchList = datas.branchSelectivityList;
						    $scope.portList = datas.airPortSelectivityList;
						}).error(function(data) {

						});
						/*$http
								.post(
										$stateParams.tenantid
												+ '/app/airquotation/getServicePartner')
								.success(
										function(datas) {
											debugger
											$scope.customerList = datas.commonUtilityBean;
											$scope.printUpdatesRouting();
										}).error(function(data) {

								});
						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getiataList')
								.success(function(datas) {
									debugger
									$scope.portList = datas.commonUtilityBean;
									$scope.printUpdatesRouting();
								}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getBranch')
								.success(
										function(datas) {
											$scope.branchList = datas.commonUtilityBean;

										}).error(function(data) {

								});
						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getCurrencyList')
								.success(
										function(datas) {
											$scope.currencylist = angular
													.copy(datas.commonUtilityBean);
										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getServiceList')
								.success(
										function(datas) {
											$scope.servicePartnerTypelist = angular
													.copy(datas.commonUtilityBean);
										}).error(function(data) {

								});

						

						$http.get(
								$stateParams.tenantid
										+ '/app/jobOrderAir/dropDownList1')
								.success(function(datas) {
									debugger
								//	$scope.quotationList = datas.quotationList;

								}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getSalesList')
								.success(
										function(datas) {
											$scope.salesTypeList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getServiceList')
								.success(
										function(datas) {
											$scope.servicePartnerTypelist = datas.commonUtilityBean;

										}).error(function(data) {

								});

						
						$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
							
						    $scope.commodityList = datas.commonUtilityBean;	    

						}).error(function(data) {

						});
						
						
						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getPaymentList')
								.success(
										function(datas) {
											$scope.PaymentMethodList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getTransactionList')
								.success(
										function(datas) {
											$scope.transactionTypeList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getChargeHeads')
								.success(
										function(datas) {
											$scope.chargeHeadList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getTerms')
								.success(function(datas) {
									$scope.TermList = datas.commonUtilityBean;
									$scope.printUpdatesRouting();
								}).error(function(data) {

								});

						$http.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getUnitList')
								.success(function(datas) {
									$scope.UnitList = datas.commonUtilityBean;

								}).error(function(data) {

								});
						

						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getuomList')
								.success(function(datas) {
									$scope.uomList = datas.commonUtilityBean;

								}).error(function(data) {

								});*/
					}

					$scope.dropdown();

					$scope.checkValidation = function() {

						var alertmsg = "<ui><h4>Please fill the required fields</h4>";
						var msg = "";
						if ($scope.checkundefined($scope.joborder.customer)) {
							msg = msg + "<li>Customer :Field is required.</li>";
							$scope.changecolor('customer_id');
						} else {
							$scope.clearcolor('customer_id');
						}
						if ($scope.checkundefined($scope.joborder.jobDate)) {
							msg = msg + "<li>JobDate :Field is required.</li>";
							$scope.changecolor('jobDate');
						} else {
							$scope.clearcolor('jobDate');
						}
						if ($scope.checkundefined($scope.joborder.shipper)) {
							msg = msg + "<li>Shipper :Field is required.</li>";
							$scope.changecolor('shipper');
						} else {
							$scope.clearcolor('shipper');
						}
						if ($scope.checkundefined($scope.joborder.service)) {
							msg = msg + "<li>Service :Field is required.</li>";
							$scope.changecolor('service');
						} else {
							$scope.clearcolor('service');
						}
						if ($scope.checkundefined($scope.joborder.branch)) {
							msg = msg + "<li>Branch :Field is required.</li>";
							$scope.changecolor('branch');
						} else {
							$scope.clearcolor('branch');
						}
						
						if ($scope.checkundefined($scope.joborder.term)) {
							msg = msg + "<li>Term :Field is required.</li>";
							$scope.changecolor('term');
						} else {
							$scope.clearcolor('term');
						}
						if ($scope.checkundefined($scope.joborder.destination)) {
							msg = msg + "<li>Destination :Field is required.</li>";
							$scope.changecolor('destination');
						} else {
							$scope.clearcolor('destination');
						}
						if ($scope.checkundefined($scope.joborder.aol)) {
							msg = msg + "<li>AOL:Field is required.</li>";
							$scope.changecolor('aol');
						} else {
							$scope.clearcolor('aol');
						}
						if ($scope.checkundefined($scope.joborder.aod)) {
							msg = msg + "<li>AOD:Field is required.</li>";
							$scope.changecolor('aod');
						} else {
							$scope.clearcolor('aod');
						}
						if ($scope.checkundefined($scope.joborder.origin)) {
							msg = msg + "<li>Origin:Field is required.</li>";
							$scope.changecolor('origin');
						} else {
							$scope.clearcolor('origin');
						}
						if ($scope.checkundefined($scope.joborder.quotationNo)) {
							msg = msg + "<li>QuotationNo:Field is required.</li>";
							$scope.changecolor('quotationNo');
						} else {
							$scope.clearcolor('quotationNo');
						}
						
						
						if ($scope.checkundefined($scope.joborder.currency)) {
							msg = msg + "<li>Currency:Field is required.</li>";
							$scope.changecolor('currency');
						} else {
							$scope.clearcolor('currency');
						}
						if ($scope.checkundefined($scope.joborder.exRate)) {
							msg = msg + "<li>ExRate:Field is required.</li>";
							$scope.changecolor('exRate');
						} else {
							$scope.clearcolor('exRate');
						}
						if ($scope.checkundefined($scope.joborder.salesType)) {
							msg = msg + "<li>salesType:Field is required.</li>";
							$scope.changecolor('salesType');
						} else {
							$scope.clearcolor('salesType');
						}
						if ($scope.checkundefined($scope.joborder.salesPerson)) {
							msg = msg + "<li>SalesPerson:Field is required.</li>";
							$scope.changecolor('salesPerson');
						} else {
							$scope.clearcolor('salesPerson');
						}
						
						if ($scope.checkundefined($scope.joborder.flightNo)) {
							msg = msg + "<li>FlightNo:Field is required.</li>";
							$scope.changecolor('flightNo');
						} else {
							$scope.clearcolor('flightNo');
						}
						if ($scope.checkundefined($scope.joborder.flightDate)) {
							msg = msg + "<li>FlightDate:Field is required.</li>";
							$scope.changecolor('flightDate');
						} else {
							$scope.clearcolor('flightDate');
						}
						
						
						if ($scope.checkundefined($scope.joborder.vendor)) {
							msg = msg + "<li>Vendor:Field is required.</li>";
							$scope.changecolor('vendor');
						} else {
							$scope.clearcolor('vendor');
						}
						angular
								.forEach(
										$scope.joborder.joborderDtl,
										function(chargesDetail, index) {
											debugger
											if ($scope
													.checkundefined(chargesDetail.chargeHead)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Charge Heads :Field is required.</li>";
												$scope
														.changecolor('chargeHeads'
																+ index);
											} else {
												$scope.clearcolor('chargeHeads'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.unit)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
												$scope.changecolor('transactionTypes'
														+ index);
											} else {
												$scope.clearcolor('transactionTypes'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.buySellParty)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Buy Sell:Field is required.</li>";
												$scope.changecolor('buySellPartys'
														+ index);
											} else {
												$scope.clearcolor('buySellPartys'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.amount)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Amount:Field is required.</li>";
												$scope.changecolor('amount'
														+ index);
											} else {
												$scope.clearcolor('amount'
														+ index);
											}

											if ($scope
													.checkundefined(chargesDetail.exRate)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Exchange Rate:Field is required.</li>";
												$scope.changecolor('exRate'
														+ index);
											} else {
												$scope.clearcolor('exRate'
														+ index);
											}

											if ($scope
													.checkundefined(chargesDetail.transactionType)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
												$scope.changecolor('transactionTypes'
														+ index);
											} else {
												$scope.clearcolor('transactionTypes'
														+ index);
											}

											if ($scope
													.checkundefined(chargesDetail.status)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Status :Field is required.</li>";
												$scope.changecolor('status'
														+ index);
											} else {
												$scope.clearcolor('status'
														+ index);
											}
											/*angular.forEach($scope.joborder.joborderTrackingDtl, function(TrackingDtl,
													index) {
												debugger
												if ($scope.checkundefined(TrackingDtl.commodity)) {
													msg = msg + "<li>Row :" + (index + 1)
															+ "# Commodity :Field is required.</li>";
													$scope.changecolor('Commodity' + index);
												} else {
													$scope.clearcolor('Commodity' + index);
												}
												if ($scope.checkundefined(TrackingDtl.descriptionGoods)) {
													msg = msg + "<li>Row :" + (index + 1)
															+ "# DescriptionGoods :Field is required.</li>";
													$scope.changecolor('descriptionGoods' + index);
												} else {
													$scope.clearcolor('descriptionGoods' + index);
												}
												if ($scope.checkundefined(TrackingDtl.uom)) {
													msg = msg + "<li>Row :" + (index + 1)
															+ "# LWH UOM :Field is required.</li>";
													$scope.changecolor('uom' + index);
												} else {
													$scope.clearcolor('uom' + index);
												}
												if ($scope.checkundefined(TrackingDtl.noOfPieces)) {
													msg = msg + "<li>Row :" + (index + 1)
															+ "# NoOfPieces :Field is required.</li>";
													$scope.changecolor('noOfPieces' + index);
												} else {
													$scope.clearcolor('noOfPieces' + index);
												}
												if ($scope.checkundefined(TrackingDtl.netWeight)) {
													msg = msg + "<li>Row :" + (index + 1)
															+ "# NetWeight :Field is required.</li>";
													$scope.changecolor('netWeight' + index);
												} else {
													$scope.clearcolor('netWeight' + index);
												}
												if ($scope.checkundefined(TrackingDtl.grossWeight)) {
													msg = msg + "<li>Row :" + (index + 1)
															+ "# GrossWeight :Field is required.</li>";
													$scope.changecolor('GrossWeight' + index);
												} else {
													$scope.clearcolor('GrossWeight' + index);
												}
												if ($scope.checkundefined(TrackingDtl.amount)) {
													msg = msg + "<li>Row :" + (index + 1)
															+ "# Amount :Field is required.</li>";
													$scope.changecolor('Amount' + index);
												} else {
													$scope.clearcolor('Amount' + index);
												}
												

											});*/
											$scope.print = function(rowid) {
												var test = parseInt(rowid);
												var url = $stateParams.tenantid
														+ '/app/jobOrderAir/print?rowid='
														+ test
												var wnd = window
														.open(
																url,
																'Athena',
																'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
												wnd.print();

											};

											$scope.print1 = function(rowid) {
												rowid = 4852;
												var test = parseInt(rowid);
												var url = $stateParams.tenantid
														+ '/app/jobOrderAir/print1?rowid='
														+ rowid
												var wnd = window
														.open(
																url,
																'Athena',
																'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
												wnd.print();

											};

										});
						alertmsg = alertmsg + msg + "</ui>";
						if ($scope.checkundefined(msg)) {
							return '';
						} else {
							return alertmsg;
						}

					}

					$scope.checkundefined = function(value) {
						var invalid = false;
						if (value == undefined || value == 'undefined'
								|| value == null || value == 'null'
								|| value == '') {
							invalid = true;
						}
						return invalid;

					}

					$scope.changecolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "red");
						;

					}
					$scope.clearcolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "#e8dddd");
						;

					}

					$scope.isEdit = false;
					
					$scope.edit=function(){

					if ($scope.jobId != '' && $scope.jobId != undefined) {
						$scope.isEdit = true;

						$scope.dropdown();

						$http
								.post(
										$stateParams.tenantid
												+ '/app/jobOrderAir/edit',
												$scope.jobId)
								.success(
										function(data) {
											debugger
											$scope.joborder = data.lJobOrderBean[0];
											if(data.lJobOrderBean[0].remarks!='' && data.lJobOrderBean[0].remarks!=null){
												$scope.joborder.tempremarks=data.lJobOrderBean[0].remarks1.
												toString();
											}
											
											$scope.joborder.quotationnum = data.lJobOrderBean[0].quotationnum.toString();
											$scope.joborder.remarks1="";
											if(data.lJobOrderBean[0].service!='' &&  data.lJobOrderBean[0].service!=null)
												{
												$scope.joborder.service = data.lJobOrderBean[0].service
												.toString();
												}
											if(data.lJobOrderBean[0].branch!=''&& data.lJobOrderBean[0].branch!=null)
												{
											$scope.joborder.branch = data.lJobOrderBean[0].branch
													.toString();
												}
											if(data.lJobOrderBean[0].mode!=''&&data.lJobOrderBean[0].mode!=null)
												{
											$scope.joborder.mode = data.lJobOrderBean[0].mode
													.toString();
												}
											$scope.joborder.jobDate = data.lJobOrderBean[0].jobDate;
											if(data.lJobOrderBean[0].aol!=''&& data.lJobOrderBean[0].aol!=null)
												{
											$scope.joborder.aol = data.lJobOrderBean[0].aol
													.toString();
												}
											if(data.lJobOrderBean[0].aod!='' && data.lJobOrderBean[0].aod!=null)
												{
											$scope.joborder.aod = data.lJobOrderBean[0].aod
													.toString();
												}
											if(data.lJobOrderBean[0].term!=''&& data.lJobOrderBean[0].term!=null){
											$scope.joborder.term = data.lJobOrderBean[0].term
													.toString();
											}
											if(data.lJobOrderBean[0].origin!='' && data.lJobOrderBean[0].origin!=null)
												{
											$scope.joborder.origin = data.lJobOrderBean[0].origin
													.toString();
												}
											if(data.lJobOrderBean[0].destination!=''&&data.lJobOrderBean[0].destination!=null)
												{
											$scope.joborder.destination = data.lJobOrderBean[0].destination
													.toString();
												}
											if(data.lJobOrderBean[0].customer!=''&& data.lJobOrderBean[0].customer!=null)
												{
											$scope.joborder.customer = data.lJobOrderBean[0].customer
													.toString();
												}
											if(data.lJobOrderBean[0].shipper!='' && data.lJobOrderBean[0].shipper!=null)
												{
												$scope.joborder.shipper = data.lJobOrderBean[0].shipper
													.toString();
												}
											if(data.lJobOrderBean[0].consignee!='' && data.lJobOrderBean[0].consignee!=null)
												{
											$scope.joborder.consignee = data.lJobOrderBean[0].consignee
													.toString();
												}
											if (data.lJobOrderBean[0].nominatedBy != null
													&& data.lJobOrderBean[0].nominatedBy != '') {
											$scope.joborder.nominatedBy = data.lJobOrderBean[0].nominatedBy
													.toString();
											}
											if(data.lJobOrderBean[0].vendor!=''&& data.lJobOrderBean[0].vendor!=null){
											$scope.joborder.vendor = data.lJobOrderBean[0].vendor
													.toString();
											}if(data.lJobOrderBean[0].currency!=''&& data.lJobOrderBean[0].currency!=null)
												{
											$scope.joborder.currency = data.lJobOrderBean[0].currency
													.toString();
												}
											if (data.lJobOrderBean[0].customsBroker != null
													&& data.lJobOrderBean[0].customsBroker != '') {
											$scope.joborder.customsBroker = data.lJobOrderBean[0].customsBroker
													.toString();
											}
											$scope.joborder.quotationNo = data.lJobOrderBean[0].quotationNo;
											// $scope.joborder.currency =
											// data.lJobOrderBean[0].currency;
											if(data.lJobOrderBean[0].salesType!=''&&data.lJobOrderBean[0].salesType!=null)
												{
											$scope.joborder.salesType = data.lJobOrderBean[0].salesType
													.toString();
												}

											for (var i = 0; i < $scope.joborder.joborderDtl.length; i++) {
												$scope.joborder.joborderDtl[i].chargeHead = $scope.joborder.joborderDtl[i].chargeHead
														.toString();
												$scope.joborder.joborderDtl[i].unit = $scope.joborder.joborderDtl[i].unit
														.toString();
												$scope.joborder.joborderDtl[i].currency = $scope.joborder.joborderDtl[i].currency
														.toString();											
												$scope.joborder.joborderDtl[i].transactionType = $scope.joborder.joborderDtl[i].transactionType
														.toString();
												$scope.joborder.joborderDtl[i].buySellParty = $scope.joborder.joborderDtl[i].buySellParty
														.toString();
												$scope.joborder.joborderDtl[i].amount = $scope.joborder.joborderDtl[i].amount;
												$scope.joborder.joborderDtl[i].rate = $scope.joborder.joborderDtl[i].rate;

												$scope.joborder.joborderDtl[i].status = $scope.joborder.joborderDtl[i].status
														.toString();
												$scope.joborder.joborderDtl[i].exRate = $scope.joborder.joborderDtl[i].exRate;

											}
											$scope.joborder.joborderTracking = data.lJobOrderBean[0].joborderTracking;
											$scope.joborder.joborderTrackingDtl = data.lJobOrderBean[0].joborderTrackingDtl;
											for (var i = 0; i < $scope.joborder.joborderTrackingDtl.length; i++) {
												$scope.joborder.joborderTrackingDtl[i].uom = $scope.joborder.joborderTrackingDtl[i].uom.toString();	
												
												}
											

										});

					}
					}
					$scope.edit();
					
					
					$scope.$watch('joborder.jobDate', function(newValue, oldValue) {

						if(newValue!='' && newValue!=undefined){
						//	/app/jobOrderSea/quickLinkView?category='+qulkVal+'&jobId='+jobId
					$http.get($stateParams.tenantid+'/app/jobOrderAir/getDateChange?date='+oldValue+'&jobId='+$scope.jobId+'&mode='+$scope.joborder.mode).success(function(datas) {
						console.log(datas);	
						//$scope.serviceParnrDropList=datas.serviceParnrList;
						if(datas.success){
						logger.logError("Already Invoice Raised For this Job No");
						$scope.joborder.jobDate='';
						}
						}).error(function(data) {

						});

						}
						});
					
					$scope.addRow = function() {
						var jobOrderDtl = {
							joborderDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '1',
							quantity : '',
							rate : '',
							currency : '',
							exRate : '1',
							amount : '0',						
							buySellParty : '',
							status : '1'
						}
						$scope.joborder.joborderDtl.push(jobOrderDtl);
					};

					$scope.deleteIds = [];
					$scope.removeRow = function() {
						if($scope.joborder.joborderDtl.length>1){
						var len = $scope.joborder.joborderDtl.length;
						for (var index = len - 1; index < len; index--) {
							if ($scope.joborder.joborderDtl[index].select == true) {
								if ($scope.joborder.joborderDtl[index].jobDtlId != null
										&& $scope.joborder.joborderDtl[index].jobDtlId > 0) {
									$scope.deleteIds
											.push($scope.joborder.joborderDtl[index].jobDtlId);
								}
								$scope.joborder.joborderDtl.splice(index, 1);
								$scope.ratevalues();
							}
						}
						}else{
							logger.logError("Atleast one row required");
						}
					};

					$scope.hdrData = $scope.joborder;
					$scope.dtlData = $scope.jobOrderDtl;
					

					$scope.cancel = function() {
						$state.go('app.air.joborder.list', {
							tenantid : $stateParams.tenantid
						});
					}

					/*$scope
							.$watch(
									'joborder.quotationNo',
									function(newValue, oldValue) {

										if (newValue != ''
												&& newValue != undefined) {

											$http
													.post(
															$stateParams.tenantid
																	+ '/app/airquotation/edit',
															parseInt(newValue))
													.success(
															function(data) {
																debugger
																// $scope.joborder
																// =
																// data.lQuotationBean[0];
																if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ""){
																	$scope.joborder.service = data.lQuotationBean[0].service
																	.toString();	
																}
																if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ""){
			
																$scope.joborder.branch = data.lQuotationBean[0].branch
																		.toString();
																}
																if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != ""){
																$scope.joborder.mode = data.lQuotationBean[0].mode
																		.toString();
																}
																if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ""){
																$scope.joborder.aol = data.lQuotationBean[0].aol
																		.toString();
																}
																if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ""){
																$scope.joborder.aod = data.lQuotationBean[0].aod
																		.toString();
																}
																if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ""){

																$scope.joborder.term = data.lQuotationBean[0].term
																.toString();
																}
																if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ""){
																$scope.joborder.origin = data.lQuotationBean[0].origin
																		.toString();
																}
																if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ""){
																$scope.joborder.destination = data.lQuotationBean[0].destination
																		.toString();
																}
																if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ""){
																$scope.joborder.customer = data.lQuotationBean[0].customer
																		.toString();
																}
																if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ""){
																$scope.joborder.shipper = data.lQuotationBean[0].shipper
																		.toString();
																}
																if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ""){
																$scope.joborder.consignee = data.lQuotationBean[0].consignee
																		.toString();
																}
																
																if (data.lQuotationBean[0].nominatedBy != null
																		&& data.lQuotationBean[0].nominatedBy != '') {
																	$scope.joborder.nominatedBy = data.lQuotationBean[0].nominatedBy
																			.toString();
																}
																if (data.lQuotationBean[0].vendor != null
																		&& data.lQuotationBean[0].vendor != '') {
																	$scope.joborder.vendor = data.lQuotationBean[0].vendor
																			.toString();
																}
																if (data.lQuotationBean[0].currency != null
																		&& data.lQuotationBean[0].currency != '') {
																	$scope.joborder.currency = data.lQuotationBean[0].currency
																			.toString();
																}
																if (data.lQuotationBean[0].salesType != null
																		&& data.lQuotationBean[0].salesType != '') {
																	$scope.joborder.salesType = data.lQuotationBean[0].salesType
																			.toString();
																}

																for (var i = 0; i < data.lQuotationBean[0].quotationDtl.length; i++) {
																	$scope.joborder.joborderDtl[i].chargeHeads = data.lQuotationBean[0].quotationDtl[i].chargeHeads
																			.toString();
																	$scope.joborder.joborderDtl[i].unit = data.lQuotationBean[0].quotationDtl[i].unit
																			.toString();
																	$scope.joborder.joborderDtl[i].currency = data.lQuotationBean[0].quotationDtl[i].currency
																			.toString();
																	$scope.joborder.joborderDtl[i].paymentMethod = data.lQuotationBean[0].quotationDtl[i].paymentMethod
																			.toString();
																	$scope.joborder.joborderDtl[i].transactionType = data.lQuotationBean[0].quotationDtl[i].transactionType
																			.toString();
																	$scope.joborder.joborderDtl[i].buySell = data.lQuotationBean[0].quotationDtl[i].buySell
																			.toString();
																}

															});
										}
									})*/

					// $scope
					// .$watchCollection(
					// '[
					// joborder.aol,joborder.aod,joborder.jobDate,joborder.customer]',
					// function(newValue, oldValue) {
					// debugger;
					// if ($scope.joborder.aol != ""
					// && $scope.joborder.aol != undefined
					// && $scope.joborder.aod != ""
					// && $scope.joborder.aod != undefined
					// && $scope.joborder.jobDate != ""
					// && $scope.joborder.jobDate != undefined) {
					// $http
					// .get(
					// $stateParams.tenantid
					// + '/app/jobOrderAir/getQuotation?fromLocation='
					// + $scope.joborder.aol
					// + '&toLocation='
					// + $scope.joborder.aod
					// + '&jobDate='
					// + $scope.joborder.jobDate
					// + '&customer='
					// + $scope.joborder.customer)
					// .success(
					// function(datas) {
					// debugger;
					// console
					// .log(datas.commonUtilityBean);
					// $scope.quotationList = datas.commonUtilityBean;
					//
					// });
					// }
					// });
									$scope.printRoutingOrder = function(){
				        debugger	
				        
				        var jobId = parseInt($location.search().rowid);
				        var url = $stateParams.tenantid+'/app/jobOrderSea/printRoutingOrder1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					$scope.prtShpprName=''
					$scope.prtShpprAddress='';
					$scope.prtConsignName=''
					$scope.prtPrtOfLoading=''
				    $scope.prtTotlPices='';
					$scope.prtTotlNetWt=''
					$scope.prtTotlGrsWt=''
					$scope.prtcommdty=''
					$scope.prtTems=''
					$scope.prtremarks='';
					
					
					$scope.printUpdatesRouting=function(){
						
						

						angular.forEach($scope.customerList, function(value, key) {
							if($scope.joborder.shipper==value.id)
								$scope.prtShpprName=value.text;
						})
						if($scope.joborder.shpprAddrss1!=null){
							$scope.prtShpprAddress=$scope.joborder.shpprAddrss1;
						}
						if($scope.joborder.shpprAddrss2!=null){
							$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss2;
						}
						if($scope.joborder.shpprAddrss3!=null){
							$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss3;
						}
						if($scope.joborder.shpprAddrss4!=null){
							$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss4;
						}
						
						angular.forEach($scope.customerList, function(value, key) {
							if($scope.joborder.consignee==value.id)
								$scope.prtConsignName=value.text;
						})
						
						angular.forEach($scope.portList, function(value, key) {
							if($scope.joborder.aol==value.id)
								$scope.prtPrtOfLoading=value.text;
						})
						
						angular.forEach($scope.TermList, function(value, key) {
							if($scope.joborder.term==value.id)
								$scope.prtTems=value.text;
						})
						
						angular.forEach($scope.portList, function(value, key) {
							if($scope.joborder.aod==value.id)
								$scope.prtPrtOfDischrg=value.text;
						})
						
						$scope.prtTotlPices =$scope.joborder.joborderTracking.totalPcs
						$scope.prtTotlNetWt=$scope.joborder.joborderTracking.totalNetWeight
						$scope.prtTotlGrsWt=$scope.joborder.joborderTracking.totalGrosssWeight
						$scope.prtcommdty=$scope.joborder.commodity;
						$scope.prtremarks=$scope.joborder.remarks1
						
						//$scope.prtShpprAddress=$scope.joborder.shpprAddrss1+" "+$scope.joborder.shpprAddrss2+" "+$scope.joborder.shpprAddrss3+" "+$scope.joborder.shpprAddrss4==null?"":$scope.joborder.shpprAddrss4;

					      
					
						
					}
					
					
					$scope.printRoutingOrder1 = function(){
						var printContents = document.getElementById('printableContent').innerHTML;
					  	  var popupWin = window.open('', '_blank', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
					  	  popupWin.document.open();
					  	  popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="style.css" />'+
					  			  '<style>table{font-size:12px;}body{font-family: "Open Sans";}table, th, td {border: 1px solid black;border-collapse: collapse;}'+
					  			  'table>thead>tr>th{background-color:#34b7e8;}</style>'+
					  			  '</head><body onload="window.print()">' + printContents + '</body></html>');
					  	  popupWin.document.close();
					    
					}
					
					$scope.jobSheet = function(jobId){
				        debugger
				        var url = $stateParams.tenantid+'/app/jobOrderSea/jobDetailOrder1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					
					$scope.printPrealertAir= function(jobId){
				        debugger
				        
				        var url = $stateParams.tenantid+'/app/jobOrderSea/printPreAlert1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					var jobId = $location.search().jobId;

					if (jobId != null && jobId != undefined) {

						$http
								.post(
										$stateParams.tenantid
												+ '/app/jobOrderAir/edit',
										jobId).success(function(data) {
								});

					}

					$scope.updateJob = function() {
						$scope.invoice = false;
						$scope.pending = false;
						
						for(var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
							{
							if($scope.joborder.joborderDtl[i].status == "2" )
								{
								$scope.invoice = true;
								}else{
									$scope.pending = true;
								}
							}
						console.log($scope.joborder);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							if($scope.joborder.joborderDtl.length>0){
								if( $scope.Add==true  )
									{
									if($scope.joborder.joborderTrackingDtl.length>0){
										
										var temp=$scope.joborder.tempremarks;
										if(temp!=null){
											 var localValue=temp+'\n '+todate+' '+time  ;
										}else{
											var localValue ="";
										}
										if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
										$scope.joborder.remarks1=localValue +  $scope.joborder.remarks1;
										
										}
										$scope.joborder.deleteIds	=$scope.deleteIds;
								$http.post(
										$stateParams.tenantid
												+ '/app/jobOrderAir/update',
										$scope.joborder).success(function(datas) {
									debugger
									if (datas.success == true) {
										logger.logSuccess(datas.message);
										
										$location.url($stateParams.tenantid
												+ '/jobOrderAir/edit?rowid=' + datas.jobId);
										$scope.edit();
									} else {
										logger.logError(datas.message);
									}
								}).error(function(data) {
									logger.logError("Please try again");
								});
									}else{
										logger.logError("Atleast One Row Required in Cargo Details");
									}
									}
								else if($scope.pending == false && $scope.Add==false)
									{

									if($scope.joborder.joborderTrackingDtl.length>0){
										
										var temp=$scope.joborder.tempremarks;
										if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
										$scope.joborder.remarks1=temp+'\n '+todate+' '+time+ '     ' +  '     ' +  $scope.joborder.remarks1;
										
										}
								$http.post(
										$stateParams.tenantid
												+ '/app/jobOrderAir/update',
										$scope.joborder).success(function(datas) {
									debugger
									if (datas.success == true) {
										logger.logSuccess(datas.message);
										
										$location.url($stateParams.tenantid
												+ '/jobOrderAir/edit?rowid=' + datas.jobId);
										$scope.edit();
									} else {
										logger.logError(datas.message);
									}
								}).error(function(data) {
									logger.logError("Please try again");
								});
									}else{
										logger.logError("Atleast One Row Required in Cargo Details");
									}
									
									
									}
								else if($scope.pending == true && $scope.Add==false){
									logger.logError(" Some invoices are Pending / Draft.");
								}
								
							}
							else{
								logger.logError("Atleast One Row Required");
							}
							
						}

					}
					$scope.reset = function() {
						
						$scope.edit();

					$scope.joborder = $scope.hdrData;
					$scope.jobOrderDtl = $scope.dtlData;
					$scope.modeType();

					
				};
				$scope.print = function(rowid) {
					
					var test = parseInt(rowid);
					var url = $stateParams.tenantid
							+ '/app/jobOrderAir/print?rowid=' + rowid
					var wnd = window
							.open(
									url,
									'Athena',
									'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
					wnd.print();

				};
				
				
				$scope.qukLinkVal='';
				$scope.quickLinkMethd=function(jobId,qulkVal){
					if(qulkVal!='Select'){
						if(jobId!='' && jobId!=undefined){
					$http.post($stateParams.tenantid + '/app/jobOrderAir/quickLinkView?category='+qulkVal+'&jobId='+jobId).success(function(datas) {
								if(datas.quickLinkId!=null){
									var rowid=datas.quickLinkId;
									if(qulkVal=="HAWB"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/hbw/edit?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+'/hbw/view?rowid='+rowid, '_blank');
										}else{
											$state.go('app.air.hbw.add',{tenantid:$stateParams.tenantid});
											//logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="MAWB"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/mabw/edit?rowid='+rowid); 
											//$window.open('#'+$stateParams.tenantid+'/mabw/view?rowid='+rowid,'_blank');
										}else{
											$state.go('app.air.mabw.add',{tenantid:$stateParams.tenantid});
											//logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Delivery Order"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/airdeliveryorder/edit?rowid='+rowid);
											//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/view?rowid='+rowid,'_blank');
										}else{
											$state.go('app.air.deliveryorder.add',{tenantid:$stateParams.tenantid});
											//logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Sales Invoice"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/invoice/salesinvoice/salesInvoiceView/'+rowid);
											//$window.open('#'+$stateParams.tenantid+"/invoice/salesinvoice/salesInvoiceView/"+rowid,'_blank');
										}else{
											$state.go('app.finance.salesinvoice-add',{tenantid:$stateParams.tenantid});
											//logger.logError("There is no "+qulkVal);
										}
									}else if(qulkVal=="Purchase Invoice"){
										if(rowid!=0){
											$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceView/'+rowid);
											//$window.open('#'+$stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');
										}else{
											$state.go('app.finance.purchaseinvoice-add',{tenantid:$stateParams.tenantid});
											//logger.logError("There is no "+qulkVal);
										}
									}
								} else if(datas.quickLinkIdList!=null){
									var quickLinkIdList=datas.quickLinkIdList
									if(qulkVal=="HAWB"){
										$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="MAWB"){
										$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Delivery Order"){
										$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Sales Invoice"){ 
										$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}else if(qulkVal=="Purchase Invoice"){
										$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}
									
								}
								else if (datas.quickLinkId == null)
								{
									if(qulkVal=="HAWB"){
										$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="MAWB"){
										$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Delivery Order"){
										$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
									}else if(qulkVal=="Sales Invoice"){ 
										$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}else if(qulkVal=="Purchase Invoice"){
										$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
										//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
									}
									
								}
								
								
					})
					}else{
						logger.logError("There is no Job No.");
					}
				}
				}
				 $scope.remarks = function(accountHeadCode,jobNo){
			           
		               if(accountHeadCode !=""){
		                   ngDialog.open({
		                       scope : $scope,
		                       template : 'views/air/remarkslist',
		                       controller : $controller('remarksCtrl', {
		                           $scope : $scope,
		                           purchaseObject : $scope.purchaseInvoiceData,
		                           accountHeadCode:accountHeadCode,
		                           jobNo:jobNo
		                       }),
		                       className : 'ngdialog-theme-plain',
		                       showClose : false,
		                       closeByDocument : false,
		                       closeByEscape : false,
		                       preCloseCallback : $scope.getList
		                   });
		               }else{
		                   logger.logError("");
		               }
		              
		           
		               
		       }

				});


app
.controller(
		'joborderViewCtrlNew1',
		function($scope, $timeout, $stateParams, $filter, $rootScope,
				$http, $location, logger, utilsService, $state,
				sharedProperties, $window, ngDialog, $interval,
				validationService, toaster, $controller, $injector) {
			$scope.customerList = [];
			$scope.shipperList = [];
			$scope.consigneeList = [];
			$scope.AolList = [];
			$scope.AodList = [];
			$scope.commodityList = [];
			$scope.isEdit = false;
			$scope.jobOrderDtlList = [];
			$scope.tempType = '';
			debugger;
			$scope.joborder = {
				service : '',
				jobDate : '',
				branch : '',
				customer : '',
				shipper : '',
				consignee : '',
				term : '',
				aol : '',
				aod : '',
				origin : '',
				destination : '',
				commodity : '',
				jobStatus : '',
				currency : '',
				quotationNo : '',
				quotationnum:'',
				salesType : '',
				salesPerson : '',
				nominatedBy : '',
				vendor : '',
				carrier : '',
				flightNo : '',
				flightDate : '',
				exRate : '',
				customsBroker : '',
				mode : '',
				remarks1:'',
				tempremarks:'',
				truckship1:'',
				truckship2:'',
				joborderDtl : [ {
					joborderDtlId : '',
					chargeHead : '',
					unit : '',
					transactionType : '1',
					quantity : '',
					rate : '',
					currency : '',
					exRate : '',
					amount : '0',				
					buySellParty : '',
					status : ''
				} ],
				joborderTracking : {
					 jobTrackingId : '',
					 jobId : '',
					 totalPcs : '',
					 totalGrosssWeight : '',
				     totalAmount : '',
					 totalNetWeight : '',
					
				},
				joborderTrackingDtl : [{
					select : '',
					commodity : '',
					descriptionGoods : '',
					uom : '',
					length : '0',
					width : '0',
					height : '0',
					noOfPieces : '0',
					netWeight : '0',
					grossWeight : '0',
					chargeableWeight: '0',
					rate: '0',
					amount : '0',
					remarks : ''
				   
				}]
			}
//			$scope.defaultCurrency = 0;
//			$scope.fromCurrency=0;
//			$scope.toCurrency=0;
			$scope.addRowTracking = function() {
				var jobOrderTrackingDtl = {
						select : '',
						commodity : '',
						descriptionGoods : '',
						uom : '',
						length : '0',
						width : '0',
						height : '0',
						noOfPieces : '0',
						netWeight : '0',
						grossWeight : '0',
						chargeableWeight: '0',
						rate: '0',
						amount : '0',
						remarks : ''
						
				}
				$scope.joborder.joborderTrackingDtl.push(jobOrderTrackingDtl);
			};
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1; // January is 0!
			var yyyy = today.getFullYear();
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}

			 var todate = dd + '/' + mm + '/' + yyyy;
			 
			 var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
			 
			/* $scope.jobOrderDtl = {} */

			// $scope.isQuot=false;
			 var defaultCurrency = '';
			 var  fromCurrency='';
			 var toCurrency='';
			 
			 var userid=$('#tempw').val();
			 
			 $scope.$watch('joborder.jobStatus', function(newValue,
						oldValue) {
					if (newValue != '' && newValue != undefined) {
						if(newValue==2 && (userid == 'A0001' || userid == 'E0003'))
							{
							$scope.Add=false;
							$scope.disable=true;
							
							$scope.unique = true
							}else if(newValue==2 && userid != 'A0001' && userid != 'E0003')
							{
								$scope.Add=false;
								$scope.disable=true;
								
								$scope.unique = false;
								var noOfDays=0;
								if ($scope.joborder.jobDate!='' && todate!='') {
									noOfDays = moment(todate, 'DD/MM/YYYY').diff(moment($scope.joborder.jobDate, 'DD/MM/YYYY'), 'days');
								}
								if (noOfDays < 90) {
								$scope.trackDtl=false;	
								$scope.trackDtlAdd=true;
								}
								else{
								$scope.trackDtl=true;	
								$scope.trackDtlAdd=false;
								}
								}
							else{
								$scope.Add=true;
								$scope.disable=false;
								$scope.trackDtl=false;	
								$scope.trackDtlAdd=true;
							}
					}
					
				});
			 
				$scope.$watch('joborder.currency', function(newValue,
						oldValue) {
					if (newValue != '' && newValue != undefined) {
					    
					    $http
						.get(
								$stateParams.tenantid
										+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
						.success(
								function(data) {
									debugger
//									if(!$scope.isEdit){
//										$scope.joborder.exRate = data.defaultCurrency;
//									}
									
									defaultCurrency = data.defaultCurrency;
									fromCurrency=data.fromCurrency;
									toCurrency=data.toCurrency;
									
								});
					}
					
				});
				
				$scope.checkExRate = function(){
					if($scope.joborder.exRate >= fromCurrency && $scope.joborder.exRate <= toCurrency){
						
					}
					else{
						logger.logError("Exchange Rate Between "+fromCurrency+ " and " +toCurrency);
						$scope.joborder.exRate ='';
					}
				}

				
				
			$scope.removeRowTracking = function() {
				var len = $scope.joborder.joborderTrackingDtl.length;
				for (var index = len - 1; index < len; index--) {
					if ($scope.joborder.joborderTrackingDtl[index].select == true) {
						
						$scope.joborder.joborderTrackingDtl.splice(index, 1);
					}
				}
			};
			$scope.jobId = parseInt($location.search().rowid);

			$scope.ratevalues1 = function() {
				if ($scope.joborder.joborderDtl.length != null
						|| $scope.joborder.joborderDtl.length != undefined
						|| $scope.joborder.joborderDtl.length != ""
						|| $scope.joborder.joborderDtl.length != '') {
					for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {
						if (($scope.joborder.joborderDtl[i].transactionType != null)
								|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
								|| ($scope.joborder.joborderDtl[i].transactionType != "")
								|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
							if ($scope.joborder.joborderDtl[i].transactionType == "1") {
								buy1 = parseFloat(buy1)
										+ parseFloat($scope.joborder.joborderDtl[i].amount);
								console.log("i:" + i + " buy1:" + buy1);
							} else {
								if ($scope.joborder.joborderDtl[i].transactionType == "2") {
									sell1 = parseFloat(sell1)
											+ parseFloat($scope.joborder.joborderDtl[i].amount);

								}
							}
						}
					}
					total = parseFloat(buy1) - parseFloat(sell1);

					console.log("total" + total + " sell1:" + sell1);
				}

				$scope.joborder.sell1 = sell1;
				$scope.joborder.buy1 = buy1;
				$scope.joborder.total = total;
			}
			
			

			$scope
			.$watch(
					'joborder.salesType',
					function(newValue, oldValue) {

						if (newValue != ''
								&& newValue != undefined) {

							if(newValue == '3'){
								$scope.employeeList = [ {
							        id : 'E0040',
							        text : 'E0040-NOMINATED'
							    }]
							}
							else{
								$http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
									 $scope.employeeList = datas.commonUtilityBean;
								    
								}).error(function(data) {

								});
							}
						
						}
					});
			
			
			/*$http.get($stateParams.tenantid+'/app/airquotation/getEmployeeList').success(function(datas) {
				 $scope.employeeList = datas.commonUtilityBean;
			    
			}).error(function(data) {

			});*/
			
			$scope.ratevalues = function() {
				var buy1 = 0;
				var sell = 0;
				var sell1 = 0;
				var amount = 0;

				var total = 0;
				if ($scope.joborder.joborderDtl.length != null
						|| $scope.joborder.joborderDtl.length != undefined
						|| $scope.joborder.joborderDtl.length != ""
						|| $scope.joborder.joborderDtl.length != '') {
					{
						for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {

							var amount1 = [];
							var amount = [];
							if (($scope.joborder.joborderDtl[i].transactionType != null)
									|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
									|| ($scope.joborder.joborderDtl[i].transactionType != "")
									|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
								if ($scope.joborder.joborderDtl[i].transactionType == "1") {

									if (($scope.joborder.joborderDtl[i].quantity != null
											|| $scope.joborder.joborderDtl[i].quantity != undefined
											|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
											&& ($scope.joborder.joborderDtl[i].rate != null
													|| $scope.joborder.joborderDtl[i].rate != undefined
													|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
											&& ($scope.joborder.joborderDtl[i].exRate != null
													|| $scope.joborder.joborderDtl[i].exRate == undefined
													|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
										amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
												* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
										$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

										buy1 = parseFloat(buy1)
												+ parseFloat($scope.joborder.joborderDtl[i].amount);
										console.log("i:" + i + " buy1:"
												+ buy1);

									}
								}

								else {
									if ($scope.joborder.joborderDtl[i].transactionType == "2") {

										if (($scope.joborder.joborderDtl[i].quantity != null
												|| $scope.joborder.joborderDtl[i].quantity != undefined
												|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
												&& ($scope.joborder.joborderDtl[i].rate != null
														|| $scope.joborder.joborderDtl[i].rate != undefined
														|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
												&& ($scope.joborder.joborderDtl[i].exRate != null
														|| $scope.joborder.joborderDtl[i].exRate == undefined
														|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
											amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
													* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
											$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

											sell1 = parseFloat(sell1)
													+ parseFloat($scope.joborder.joborderDtl[i].amount);
											console
													.log("i:" + i
															+ " sell1:"
															+ sell1);
										}
									}
								}

							}

							$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]).toFixed(2);

						}
						total = parseFloat(sell1) - parseFloat(buy1);

						console
								.log("total" + total + " sell1:"
										+ sell1);

					}
				}
				$scope.joborder.sell1 = sell1.toFixed(2);
				$scope.joborder.buy1 = buy1.toFixed(2);
				$scope.joborder.total = total.toFixed(2);

			}
			
			$scope.CheckExRateDtl = function(currecny,index){
				alert('Test');
				if (currecny != '' && currecny != undefined) {
			    
			    $http
				.get(
						$stateParams.tenantid
								+ '/app/currency/getExchangeRate?currencyId='+parseInt(currecny))
				.success(
						function(data) {
							debugger
							/*if(!$scope.isEdit){
								$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
							}*/
							
							defaultCurrency1 = data.defaultCurrency;
							fromCurrency1=data.fromCurrency;
							toCurrency1=data.toCurrency;
							$scope.checkExRate($scope.joborder.joborderDtl[index].exRate,index);
						});
			}
				$scope.ratevalues();
			}
			$scope.noOfPcs = function() {
				var noOfPcs=0;
				for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
					if($scope.joborder.joborderTrackingDtl[i].noOfPieces==""){
						$scope.joborder.joborderTrackingDtl[i].noOfPieces=0;
						noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPieces)+noOfPcs;
						$scope.joborder.joborderTracking.totalPcs=noOfPcs;
					}
					else{
						noOfPcs=parseInt($scope.joborder.joborderTrackingDtl[i].noOfPieces)+noOfPcs;
						$scope.joborder.joborderTracking.totalPcs=noOfPcs;
					}
					
					
				}
			}
			$scope.noOfNet = function() {
				var noOfNet=0.0;
				for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
					if($scope.joborder.joborderTrackingDtl[i].netWeight==""){
						$scope.joborder.joborderTrackingDtl[i].netWeight=0.0;
						noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
						$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
					}
					else{
						noOfNet=parseFloat($scope.joborder.joborderTrackingDtl[i].netWeight)+noOfNet;
						$scope.joborder.joborderTracking.totalNetWeight=noOfNet;
					}
					
					
				}
			}
			$scope.noOfGross = function() {
				var noOfGross=0.0;
				for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
					if($scope.joborder.joborderTrackingDtl[i].grossWeight==""){
						$scope.joborder.joborderTrackingDtl[i].grossWeight=0.0;
						noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
						$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
					}
					else{
						noOfGross=parseFloat($scope.joborder.joborderTrackingDtl[i].grossWeight)+noOfGross;
						$scope.joborder.joborderTracking.totalGrosssWeight=noOfGross;
					}
					
					
				}
			}
			$scope.cargoCal = function() {
				var amt=0.0;
				var totAmt=0.0;
				for (var i = 0; i <= $scope.joborder.joborderTrackingDtl.length; i++) {
					if($scope.joborder.joborderTrackingDtl[i].chargeableWeight=="" && $scope.joborder.joborderTrackingDtl[i].rate==""){
						$scope.joborder.joborderTrackingDtl[i].chargeableWeight=0.0;
						$scope.joborder.joborderTrackingDtl[i].rate==0.0;
						amt=parseFloat($scope.joborder.joborderTrackingDtl[i].chargeableWeight)*parseFloat($scope.joborder.joborderTrackingDtl[i].rate);
						$scope.joborder.joborderTrackingDtl[i].amount=amt;
						totAmt=parseFloat($scope.joborder.joborderTrackingDtl[i].amount)+totAmt;
						$scope.joborder.joborderTracking.totalAmount=totAmt;
					}
					else{
						amt=parseFloat($scope.joborder.joborderTrackingDtl[i].chargeableWeight)*parseFloat($scope.joborder.joborderTrackingDtl[i].rate);
						$scope.joborder.joborderTrackingDtl[i].amount=amt;
						totAmt=parseFloat($scope.joborder.joborderTrackingDtl[i].amount)+totAmt;
						$scope.joborder.joborderTracking.totalAmount=totAmt;	
					}
						
					
				}
			}
			$scope.modeList = [];
			$scope.modeType = function() {
				var data = {};
				data["id"] = "2";
				data["text"] = "AIR";
				$scope.modeList.push(data);
				$scope.joborder.mode = $scope.modeList[0].id

			}
			$scope.modeType();

			$scope.submitupdate = function() {
			}

			$scope.salesTypeList = [];
			
			$scope.transactionTypeList = [];

			
			$scope.jobStatusList = [];
			$scope.getjobStatus = function() {
				var data = {};
				data["id"] = "1";
				data["text"] = "OPEN";
				$scope.jobStatusList.push(data);
				data = {};
				data["id"] = "2";
				data["text"] = "CLOSED";
				$scope.jobStatusList.push(data);

			}
			$scope.getjobStatus();

			//$scope.PaymentMethodList = [];
			// $scope.getpaymentMethod = function() {
			// var data = {};
			// data["id"] = "1";
			// data["text"] = "PREAPID TO COLLECT";
			// $scope.PaymentMethodList.push(data);
			//			  
			// }
			// $scope.getpaymentMethod();

			$scope.jobDetailStatusList = [];
			$scope.getjobStatus = function() {
				var data = {};
				data["id"] = "1";
				data["text"] = "PENDING";
				$scope.jobDetailStatusList.push(data);
				data = {};
				data["id"] = "2";
				data["text"] = "INVOICED";
				$scope.jobDetailStatusList.push(data);
				data = {};
				data["id"] = "3";
				data["text"] = "DRAFT";
				$scope.jobDetailStatusList.push(data);

			}
			$scope.getjobStatus();
			
			$scope.viewJob = function(jobId) {
				$location.url($stateParams.tenantid
						+ '/jobOrderAir/view?rowid=' + jobId);
			}
			
			$scope.viewQuotation = function(quotationNo) {
				debugger
					$location.url($stateParams.tenantid+'/airQuotation/view?QuotHdId='+quotationNo);
				
			}

			// $scope.getQuotationType();
			$scope.dropdown = function() {
				debugger;
				
				$http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
					debugger
				  //  $scope.quotationList = datas.quotationList;	
					$scope.customerList = datas.customerSelectivityList;
					$scope.consigneeDropList = datas.consigneeSelectivityList;
					$scope.shipperDropList = datas.shipperSelectivityList;
					$scope.nominatedDropList = datas.nominatedSelectivityList;
					$scope.vendorDropList = datas.vendorSelectivityList;
					$scope.serviceParnrDropList=datas.serviceParnrSelectivityList;
					$scope.customerBuyList = datas.buyServiceList;
					$scope.customerSellList = datas.sellServiceList;
					$scope.salesTypeList = datas.salesSelectivityList;
					$scope.employeeList = datas.employeeSelectivityList;
					$scope.servicePartnerTypelist = datas.serviceSelectivityList;
					//$scope.PaymentMethodList = datas.paymentSelectivityList;
					$scope.transactionTypeList = datas.transactionSelectivityList;
					$scope.chargeHeadList = datas.airChargeHeadSelectivityList;
					$scope.TermList = datas.termsSelectivityList;
					$scope.UnitList = datas.unitSelectivityList;
					$scope.uomList = datas.uomList;	 
					$scope.sizeTypeList = datas.sizeTypeSelectivityList;
					$scope.commodityList = datas.commoditySelectivityList;	
					$scope.currencylist= datas.currecnySelectivityList;
					$scope.branchList = datas.branchSelectivityList;
				    $scope.portList = datas.airPortSelectivityList;
				}).error(function(data) {

				});
				
				/*$http
						.post(
								$stateParams.tenantid
										+ '/app/airquotation/getServicePartner')
						.success(
								function(datas) {
									debugger
									$scope.customerList = datas.commonUtilityBean;
									$scope.printUpdatesRouting();
								}).error(function(data) {

						});
				$http.get(
						$stateParams.tenantid
								+ '/app/airquotation/getiataList')
						.success(function(datas) {
							debugger
							$scope.portList = datas.commonUtilityBean;
							$scope.printUpdatesRouting();
						}).error(function(data) {

						});

				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getBranch')
						.success(
								function(datas) {
									$scope.branchList = datas.commonUtilityBean;

								}).error(function(data) {

						});
				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getCurrencyList')
						.success(
								function(datas) {
									$scope.currencylist = angular
											.copy(datas.commonUtilityBean);
								}).error(function(data) {

						});

				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getServiceList')
						.success(
								function(datas) {
									$scope.servicePartnerTypelist = angular
											.copy(datas.commonUtilityBean);
								}).error(function(data) {

						});

				

				$http.get(
						$stateParams.tenantid
								+ '/app/jobOrderAir/dropDownList1')
						.success(function(datas) {
							debugger
						//	$scope.quotationList = datas.quotationList;

						}).error(function(data) {

						});

				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getSalesList')
						.success(
								function(datas) {
									$scope.salesTypeList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getServiceList')
						.success(
								function(datas) {
									$scope.servicePartnerTypelist = datas.commonUtilityBean;

								}).error(function(data) {

						});

				
				$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
					
				    $scope.commodityList = datas.commonUtilityBean;	    

				}).error(function(data) {

				});
				
				
				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getPaymentList')
						.success(
								function(datas) {
									$scope.PaymentMethodList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getTransactionList')
						.success(
								function(datas) {
									$scope.transactionTypeList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getChargeHeads')
						.success(
								function(datas) {
									$scope.chargeHeadList = datas.commonUtilityBean;

								}).error(function(data) {

						});

				$http.get(
						$stateParams.tenantid
								+ '/app/airquotation/getTerms')
						.success(function(datas) {
							$scope.TermList = datas.commonUtilityBean;
							$scope.printUpdatesRouting();
						}).error(function(data) {

						});

				$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getUnitList')
						.success(function(datas) {
							$scope.UnitList = datas.commonUtilityBean;

						}).error(function(data) {

						});
				

				$http.get(
						$stateParams.tenantid
								+ '/app/airquotation/getuomList')
						.success(function(datas) {
							$scope.uomList = datas.commonUtilityBean;

						}).error(function(data) {

						});*/
			}

			$scope.dropdown();

			$scope.checkValidation = function() {

				var alertmsg = "<ui><h4>Please fill the required fields</h4>";
				var msg = "";
				if ($scope.checkundefined($scope.joborder.customer)) {
					msg = msg + "<li>CUSTOMER :Field is required.</li>";
					$scope.changecolor('customer_id');
				} else {
					$scope.clearcolor('customer_id');
				}

				angular
						.forEach(
								$scope.joborder.joborderDtl,
								function(chargesDetail, index) {
									debugger
									if ($scope
											.checkundefined(chargesDetail.chargeHead)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Charge Heads :Field is required.</li>";
										$scope
												.changecolor('chargeHeads'
														+ index);
									} else {
										$scope.clearcolor('chargeHeads'
												+ index);
									}
									if ($scope
											.checkundefined(chargesDetail.unit)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Unit :Field is required.</li>";
										$scope.changecolor('unit'
												+ index);
									} else {
										$scope.clearcolor('unit'
												+ index);
									}
									if ($scope
											.checkundefined(chargesDetail.currency)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# CURRENCY :Field is required.</li>";
										$scope.changecolor('currency'
												+ index);
									} else {
										$scope.clearcolor('currency'
												+ index);
									}
									if ($scope
											.checkundefined(chargesDetail.quantity)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Quantity :Field is required.</li>";
										$scope.changecolor('quantity'
												+ index);
										$('#quantity' + index).find('input')
												.css("border-color",
														"red");

									} else {
										$('#qty' + index).find('input')
												.css("border-color",
														"#e8dddd");
									}
									if ($scope
											.checkundefined(chargesDetail.rate)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Rate :Field is required.</li>";
										$scope.changecolor('rate'
												+ index);
									} else {
										$scope.clearcolor('rate'
												+ index);
									}
							
									if ($scope
											.checkundefined(chargesDetail.transactionType)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Transaction Type :Field is required.</li>";
										$scope.changecolor('transactionTypes'
												+ index);
									} else {
										$scope.clearcolor('transactionTypes'
												+ index);
									}
									if ($scope
											.checkundefined(chargesDetail.buySellParty)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Buy Sell:Field is required.</li>";
										$scope.changecolor('buySellPartys'
												+ index);
									} else {
										$scope.clearcolor('buySellPartys'
												+ index);
									}
									if ($scope
											.checkundefined(chargesDetail.amount)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Amount:Field is required.</li>";
										$scope.changecolor('amount'
												+ index);
									} else {
										$scope.clearcolor('amount'
												+ index);
									}

									if ($scope
											.checkundefined(chargesDetail.exRate)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Exchange Rate:Field is required.</li>";
										$scope.changecolor('exRate'
												+ index);
									} else {
										$scope.clearcolor('exRate'
												+ index);
									}

									if ($scope
											.checkundefined(chargesDetail.transactionType)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Transaction Type :Field is required.</li>";
										$scope.changecolor('transactionTypes'
												+ index);
									} else {
										$scope.clearcolor('transactionTypes'
												+ index);
									}

									if ($scope
											.checkundefined(chargesDetail.status)) {
										msg = msg
												+ "<li>Row :"
												+ (index + 1)
												+ "# Status :Field is required.</li>";
										$scope.changecolor('status'
												+ index);
									} else {
										$scope.clearcolor('status'
												+ index);
									}
									/*angular.forEach($scope.joborder.joborderTrackingDtl, function(TrackingDtl,
											index) {
										debugger
										if ($scope.checkundefined(TrackingDtl.commodity)) {
											msg = msg + "<li>Row :" + (index + 1)
													+ "# Commodity :Field is required.</li>";
											$scope.changecolor('Commodity' + index);
										} else {
											$scope.clearcolor('Commodity' + index);
										}
										if ($scope.checkundefined(TrackingDtl.descriptionGoods)) {
											msg = msg + "<li>Row :" + (index + 1)
													+ "# DescriptionGoods :Field is required.</li>";
											$scope.changecolor('descriptionGoods' + index);
										} else {
											$scope.clearcolor('descriptionGoods' + index);
										}
										if ($scope.checkundefined(TrackingDtl.uom)) {
											msg = msg + "<li>Row :" + (index + 1)
													+ "# LWH UOM :Field is required.</li>";
											$scope.changecolor('uom' + index);
										} else {
											$scope.clearcolor('uom' + index);
										}
										if ($scope.checkundefined(TrackingDtl.noOfPieces)) {
											msg = msg + "<li>Row :" + (index + 1)
													+ "# NoOfPieces :Field is required.</li>";
											$scope.changecolor('noOfPieces' + index);
										} else {
											$scope.clearcolor('noOfPieces' + index);
										}
										if ($scope.checkundefined(TrackingDtl.netWeight)) {
											msg = msg + "<li>Row :" + (index + 1)
													+ "# NetWeight :Field is required.</li>";
											$scope.changecolor('netWeight' + index);
										} else {
											$scope.clearcolor('netWeight' + index);
										}
										if ($scope.checkundefined(TrackingDtl.grossWeight)) {
											msg = msg + "<li>Row :" + (index + 1)
													+ "# GrossWeight :Field is required.</li>";
											$scope.changecolor('GrossWeight' + index);
										} else {
											$scope.clearcolor('GrossWeight' + index);
										}
										if ($scope.checkundefined(TrackingDtl.amount)) {
											msg = msg + "<li>Row :" + (index + 1)
													+ "# Amount :Field is required.</li>";
											$scope.changecolor('Amount' + index);
										} else {
											$scope.clearcolor('Amount' + index);
										}
										

									});*/
									$scope.print = function(rowid) {
										var test = parseInt(rowid);
										var url = $stateParams.tenantid
												+ '/app/jobOrderAir/print?rowid='
												+ test
										var wnd = window
												.open(
														url,
														'Athena',
														'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
										wnd.print();

									};

									$scope.print1 = function(rowid) {
										rowid = 4852;
										var test = parseInt(rowid);
										var url = $stateParams.tenantid
												+ '/app/jobOrderAir/print1?rowid='
												+ rowid
										var wnd = window
												.open(
														url,
														'Athena',
														'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
										wnd.print();

									};

								});
				alertmsg = alertmsg + msg + "</ui>";
				if ($scope.checkundefined(msg)) {
					return '';
				} else {
					return alertmsg;
				}

			}

			$scope.checkundefined = function(value) {
				var invalid = false;
				if (value == undefined || value == 'undefined'
						|| value == null || value == 'null'
						|| value == '') {
					invalid = true;
				}
				return invalid;

			}

			$scope.changecolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "red");
				;

			}
			$scope.clearcolor = function(id) {
				$('#' + id + ' .selectivityId').find('input').css(
						"border-color", "#e8dddd");
				;

			}

			$scope.isEdit = false;
			
			$scope.view=function(){

			if ($scope.jobId != '' && $scope.jobId != undefined) {
				$scope.isEdit = true;

				$scope.dropdown();

				$http
						.post(
								$stateParams.tenantid
										+ '/app/jobOrderAir/view',
										$scope.jobId)
						.success(
								function(data) {
									debugger
									$scope.joborder = data.lJobOrderBean[0];
									if(data.lJobOrderBean[0].remarks!='' && data.lJobOrderBean[0].remarks!=null){
										$scope.joborder.tempremarks=data.lJobOrderBean[0].remarks1.
										toString();
									}
									
									$scope.joborder.quotationnum = data.lJobOrderBean[0].quotationnum.toString();
									$scope.joborder.remarks1="";
									if(data.lJobOrderBean[0].service!='' &&  data.lJobOrderBean[0].service!=null)
										{
										$scope.joborder.service = data.lJobOrderBean[0].service
										.toString();
										}
									if(data.lJobOrderBean[0].branch!=''&& data.lJobOrderBean[0].branch!=null)
										{
									$scope.joborder.branch = data.lJobOrderBean[0].branch
											.toString();
										}
									if(data.lJobOrderBean[0].mode!=''&&data.lJobOrderBean[0].mode!=null)
										{
									$scope.joborder.mode = data.lJobOrderBean[0].mode
											.toString();
										}
									$scope.joborder.jobDate = data.lJobOrderBean[0].jobDate;
									if(data.lJobOrderBean[0].aol!=''&& data.lJobOrderBean[0].aol!=null)
										{
									$scope.joborder.aol = data.lJobOrderBean[0].aol
											.toString();
										}
									if(data.lJobOrderBean[0].aod!='' && data.lJobOrderBean[0].aod!=null)
										{
									$scope.joborder.aod = data.lJobOrderBean[0].aod
											.toString();
										}
									if(data.lJobOrderBean[0].term!=''&& data.lJobOrderBean[0].term!=null){
									$scope.joborder.term = data.lJobOrderBean[0].term
											.toString();
									}
									if(data.lJobOrderBean[0].origin!='' && data.lJobOrderBean[0].origin!=null)
										{
									$scope.joborder.origin = data.lJobOrderBean[0].origin
											.toString();
										}
									if(data.lJobOrderBean[0].destination!=''&&data.lJobOrderBean[0].destination!=null)
										{
									$scope.joborder.destination = data.lJobOrderBean[0].destination
											.toString();
										}
									if(data.lJobOrderBean[0].customer!=''&& data.lJobOrderBean[0].customer!=null)
										{
									$scope.joborder.customer = data.lJobOrderBean[0].customer
											.toString();
										}
									if(data.lJobOrderBean[0].shipper!='' && data.lJobOrderBean[0].shipper!=null)
										{
										$scope.joborder.shipper = data.lJobOrderBean[0].shipper
											.toString();
										}
									if(data.lJobOrderBean[0].consignee!='' && data.lJobOrderBean[0].consignee!=null)
										{
									$scope.joborder.consignee = data.lJobOrderBean[0].consignee
											.toString();
										}
									if (data.lJobOrderBean[0].nominatedBy != null
											&& data.lJobOrderBean[0].nominatedBy != '') {
									$scope.joborder.nominatedBy = data.lJobOrderBean[0].nominatedBy
											.toString();
									}
									if(data.lJobOrderBean[0].vendor!=''&& data.lJobOrderBean[0].vendor!=null){
									$scope.joborder.vendor = data.lJobOrderBean[0].vendor
											.toString();
									}if(data.lJobOrderBean[0].currency!=''&& data.lJobOrderBean[0].currency!=null)
										{
									$scope.joborder.currency = data.lJobOrderBean[0].currency
											.toString();
										}
									if (data.lJobOrderBean[0].customsBroker != null
											&& data.lJobOrderBean[0].customsBroker != '') {
									$scope.joborder.customsBroker = data.lJobOrderBean[0].customsBroker
											.toString();
									}
									$scope.joborder.quotationNo = data.lJobOrderBean[0].quotationNo;
									// $scope.joborder.currency =
									// data.lJobOrderBean[0].currency;
									if(data.lJobOrderBean[0].salesType!=''&&data.lJobOrderBean[0].salesType!=null)
										{
									$scope.joborder.salesType = data.lJobOrderBean[0].salesType
											.toString();
										}

									for (var i = 0; i < $scope.joborder.joborderDtl.length; i++) {
										$scope.joborder.joborderDtl[i].chargeHead = $scope.joborder.joborderDtl[i].chargeHead
												.toString();
										$scope.joborder.joborderDtl[i].unit = $scope.joborder.joborderDtl[i].unit
												.toString();
										$scope.joborder.joborderDtl[i].currency = $scope.joborder.joborderDtl[i].currency
												.toString();										
										$scope.joborder.joborderDtl[i].transactionType = $scope.joborder.joborderDtl[i].transactionType
												.toString();
										$scope.joborder.joborderDtl[i].buySellParty = $scope.joborder.joborderDtl[i].buySellParty
												.toString();
										$scope.joborder.joborderDtl[i].amount = $scope.joborder.joborderDtl[i].amount;
										$scope.joborder.joborderDtl[i].rate = $scope.joborder.joborderDtl[i].rate;

										$scope.joborder.joborderDtl[i].status = $scope.joborder.joborderDtl[i].status
												.toString();
										$scope.joborder.joborderDtl[i].exRate = $scope.joborder.joborderDtl[i].exRate;

									}
									$scope.joborder.joborderTracking = data.lJobOrderBean[0].joborderTracking;
									$scope.joborder.joborderTrackingDtl = data.lJobOrderBean[0].joborderTrackingDtl;
									$scope.joborder.joborderTrackingDtl[0].uom = data.lJobOrderBean[0].joborderTrackingDtl[0].uom.toString();
									

								});

			}
			}
			$scope.view();
			
			
			
			
			$scope.addRow = function() {
				var jobOrderDtl = {
					joborderDtlId : '',
					chargeHead : '',
					unit : '',
					transactionType : '1',
					quantity : '',
					rate : '',
					currency : '',
					exRate : '1',
					amount : '0',				
					buySellParty : '',
					status : '1'
				}
				$scope.joborder.joborderDtl.push(jobOrderDtl);
			};

			$scope.deleteIds = [];
			$scope.removeRow = function() {
				if($scope.joborder.joborderDtl.length>1){
				var len = $scope.joborder.joborderDtl.length;
				for (var index = len - 1; index < len; index--) {
					if ($scope.joborder.joborderDtl[index].select == true) {
						if ($scope.joborder.joborderDtl[index].jobDtlId != null
								&& $scope.joborder.joborderDtl[index].jobDtlId > 0) {
							$scope.deleteIds
									.push($scope.joborder.joborderDtl[index].jobDtlId);
						}
						$scope.joborder.joborderDtl.splice(index, 1);
						$scope.ratevalues();
					}
				}
				}else{
					logger.logError("Atleast one row required");
				}
			};

			$scope.hdrData = $scope.joborder;
			$scope.dtlData = $scope.jobOrderDtl;
			

			$scope.cancel = function() {
				$state.go('app.air.joborder.list', {
					tenantid : $stateParams.tenantid
				});
			}

			/*$scope
					.$watch(
							'joborder.quotationNo',
							function(newValue, oldValue) {

								if (newValue != ''
										&& newValue != undefined) {

									$http
											.post(
													$stateParams.tenantid
															+ '/app/airquotation/edit',
													parseInt(newValue))
											.success(
													function(data) {
														debugger
														// $scope.joborder
														// =
														// data.lQuotationBean[0];
														if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ""){
															$scope.joborder.service = data.lQuotationBean[0].service
															.toString();	
														}
														if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ""){
	
														$scope.joborder.branch = data.lQuotationBean[0].branch
																.toString();
														}
														if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != ""){
														$scope.joborder.mode = data.lQuotationBean[0].mode
																.toString();
														}
														if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ""){
														$scope.joborder.aol = data.lQuotationBean[0].aol
																.toString();
														}
														if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ""){
														$scope.joborder.aod = data.lQuotationBean[0].aod
																.toString();
														}
														if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ""){

														$scope.joborder.term = data.lQuotationBean[0].term
														.toString();
														}
														if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ""){
														$scope.joborder.origin = data.lQuotationBean[0].origin
																.toString();
														}
														if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ""){
														$scope.joborder.destination = data.lQuotationBean[0].destination
																.toString();
														}
														if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ""){
														$scope.joborder.customer = data.lQuotationBean[0].customer
																.toString();
														}
														if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ""){
														$scope.joborder.shipper = data.lQuotationBean[0].shipper
																.toString();
														}
														if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ""){
														$scope.joborder.consignee = data.lQuotationBean[0].consignee
																.toString();
														}
														
														if (data.lQuotationBean[0].nominatedBy != null
																&& data.lQuotationBean[0].nominatedBy != '') {
															$scope.joborder.nominatedBy = data.lQuotationBean[0].nominatedBy
																	.toString();
														}
														if (data.lQuotationBean[0].vendor != null
																&& data.lQuotationBean[0].vendor != '') {
															$scope.joborder.vendor = data.lQuotationBean[0].vendor
																	.toString();
														}
														if (data.lQuotationBean[0].currency != null
																&& data.lQuotationBean[0].currency != '') {
															$scope.joborder.currency = data.lQuotationBean[0].currency
																	.toString();
														}
														if (data.lQuotationBean[0].salesType != null
																&& data.lQuotationBean[0].salesType != '') {
															$scope.joborder.salesType = data.lQuotationBean[0].salesType
																	.toString();
														}

														for (var i = 0; i < data.lQuotationBean[0].quotationDtl.length; i++) {
															$scope.joborder.joborderDtl[i].chargeHeads = data.lQuotationBean[0].quotationDtl[i].chargeHeads
																	.toString();
															$scope.joborder.joborderDtl[i].unit = data.lQuotationBean[0].quotationDtl[i].unit
																	.toString();
															$scope.joborder.joborderDtl[i].currency = data.lQuotationBean[0].quotationDtl[i].currency
																	.toString();
															$scope.joborder.joborderDtl[i].paymentMethod = data.lQuotationBean[0].quotationDtl[i].paymentMethod
																	.toString();
															$scope.joborder.joborderDtl[i].transactionType = data.lQuotationBean[0].quotationDtl[i].transactionType
																	.toString();
															$scope.joborder.joborderDtl[i].buySell = data.lQuotationBean[0].quotationDtl[i].buySell
																	.toString();
														}

													});
								}
							})*/

			// $scope
			// .$watchCollection(
			// '[
			// joborder.aol,joborder.aod,joborder.jobDate,joborder.customer]',
			// function(newValue, oldValue) {
			// debugger;
			// if ($scope.joborder.aol != ""
			// && $scope.joborder.aol != undefined
			// && $scope.joborder.aod != ""
			// && $scope.joborder.aod != undefined
			// && $scope.joborder.jobDate != ""
			// && $scope.joborder.jobDate != undefined) {
			// $http
			// .get(
			// $stateParams.tenantid
			// + '/app/jobOrderAir/getQuotation?fromLocation='
			// + $scope.joborder.aol
			// + '&toLocation='
			// + $scope.joborder.aod
			// + '&jobDate='
			// + $scope.joborder.jobDate
			// + '&customer='
			// + $scope.joborder.customer)
			// .success(
			// function(datas) {
			// debugger;
			// console
			// .log(datas.commonUtilityBean);
			// $scope.quotationList = datas.commonUtilityBean;
			//
			// });
			// }
			// });
							$scope.printRoutingOrder = function(){
		        debugger	
		        
		        var jobId = parseInt($location.search().rowid);
		        var url = $stateParams.tenantid+'/app/jobOrderSea/printRoutingOrder1?jobId=' + jobId;
		        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();   
		     }
			$scope.prtShpprName=''
			$scope.prtShpprAddress='';
			$scope.prtConsignName=''
			$scope.prtPrtOfLoading=''
		    $scope.prtTotlPices='';
			$scope.prtTotlNetWt=''
			$scope.prtTotlGrsWt=''
			$scope.prtcommdty=''
			$scope.prtTems=''
			$scope.prtremarks='';
			
			
			$scope.printUpdatesRouting=function(){
				
				

				angular.forEach($scope.customerList, function(value, key) {
					if($scope.joborder.shipper==value.id)
						$scope.prtShpprName=value.text;
				})
				if($scope.joborder.shpprAddrss1!=null){
					$scope.prtShpprAddress=$scope.joborder.shpprAddrss1;
				}
				if($scope.joborder.shpprAddrss2!=null){
					$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss2;
				}
				if($scope.joborder.shpprAddrss3!=null){
					$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss3;
				}
				if($scope.joborder.shpprAddrss4!=null){
					$scope.prtShpprAddress=$scope.prtShpprAddress+$scope.joborder.shpprAddrss4;
				}
				
				angular.forEach($scope.customerList, function(value, key) {
					if($scope.joborder.consignee==value.id)
						$scope.prtConsignName=value.text;
				})
				
				angular.forEach($scope.portList, function(value, key) {
					if($scope.joborder.aol==value.id)
						$scope.prtPrtOfLoading=value.text;
				})
				
				angular.forEach($scope.TermList, function(value, key) {
					if($scope.joborder.term==value.id)
						$scope.prtTems=value.text;
				})
				
				angular.forEach($scope.portList, function(value, key) {
					if($scope.joborder.aod==value.id)
						$scope.prtPrtOfDischrg=value.text;
				})
				
				$scope.prtTotlPices =$scope.joborder.joborderTracking.totalPcs
				$scope.prtTotlNetWt=$scope.joborder.joborderTracking.totalNetWeight
				$scope.prtTotlGrsWt=$scope.joborder.joborderTracking.totalGrosssWeight
				$scope.prtcommdty=$scope.joborder.commodity;
				$scope.prtremarks=$scope.joborder.remarks1
				
				//$scope.prtShpprAddress=$scope.joborder.shpprAddrss1+" "+$scope.joborder.shpprAddrss2+" "+$scope.joborder.shpprAddrss3+" "+$scope.joborder.shpprAddrss4==null?"":$scope.joborder.shpprAddrss4;

			      
			
				
			}
			
			
			$scope.printRoutingOrder1 = function(){
				var printContents = document.getElementById('printableContent').innerHTML;
			  	  var popupWin = window.open('', '_blank', 'height=700,width=850,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			  	  popupWin.document.open();
			  	  popupWin.document.write('<html><head><link rel="stylesheet" type="text/css" href="style.css" />'+
			  			  '<style>table{font-size:12px;}body{font-family: "Open Sans";}table, th, td {border: 1px solid black;border-collapse: collapse;}'+
			  			  'table>thead>tr>th{background-color:#34b7e8;}</style>'+
			  			  '</head><body onload="window.print()">' + printContents + '</body></html>');
			  	  popupWin.document.close();
			    
			}
			
			$scope.jobSheet = function(jobId){
		        debugger
		        var url = $stateParams.tenantid+'/app/jobOrderSea/jobDetailOrder1?jobId=' + jobId;
		        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();   
		     }
			
			$scope.printPrealertAir= function(jobId){
		        debugger
		        
		        var url = $stateParams.tenantid+'/app/jobOrderSea/printPreAlert1?jobId=' + jobId;
		        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
		        wnd.print();   
		     }
			var jobId = $location.search().jobId;

			if (jobId != null && jobId != undefined) {

				$http
						.post(
								$stateParams.tenantid
										+ '/app/jobOrderAir/edit',
								jobId).success(function(data) {
						});

			}

			$scope.updateJob = function() {
				$scope.invoice = false;
				$scope.pending = false;
				
				for(var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
					{
					if($scope.joborder.joborderDtl[i].status == "2" )
						{
						$scope.invoice = true;
						}else{
							$scope.pending = true;
						}
					}
				console.log($scope.joborder);
				var msg = $scope.checkValidation();
				if (!$scope.checkundefined(msg)) {
					logger.logError(msg);
				} else {
					if($scope.joborder.joborderDtl.length>0){
						if( $scope.Add==true  )
							{
							if($scope.joborder.joborderTrackingDtl.length>0){
								
								var temp=$scope.joborder.tempremarks;
								if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
								$scope.joborder.remarks1=temp+'\n '+todate+' '+time+ '     ' +  '     ' +  $scope.joborder.remarks1;
								
								}
								$scope.joborder.deleteIds	=$scope.deleteIds;
						$http.post(
								$stateParams.tenantid
										+ '/app/jobOrderAir/update',
								$scope.joborder).success(function(datas) {
							debugger
							if (datas.success == true) {
								logger.logSuccess(datas.message);
								
								$location.url($stateParams.tenantid
										+ '/jobOrderAir/edit?rowid=' + datas.jobId);
								$scope.edit();
							} else {
								logger.logError(datas.message);
							}
						}).error(function(data) {
							logger.logError("Please try again");
						});
							}else{
								logger.logError("Atleast One Row Required in Cargo Details");
							}
							}
						else if($scope.pending == false && $scope.Add==false)
							{

							if($scope.joborder.joborderTrackingDtl.length>0){
								
								var temp=$scope.joborder.tempremarks;
								if($scope.joborder.remarks1!=null&&$scope.joborder.remarks1!=""){
								$scope.joborder.remarks1=temp+'\n '+todate+' '+time+ '     ' +  '     ' +  $scope.joborder.remarks1;
								
								}
						$http.post(
								$stateParams.tenantid
										+ '/app/jobOrderAir/update',
								$scope.joborder).success(function(datas) {
							debugger
							if (datas.success == true) {
								logger.logSuccess(datas.message);
								
								$location.url($stateParams.tenantid
										+ '/jobOrderAir/edit?rowid=' + datas.jobId);
								$scope.edit();
							} else {
								logger.logError(datas.message);
							}
						}).error(function(data) {
							logger.logError("Please try again");
						});
							}else{
								logger.logError("Atleast One Row Required in Cargo Details");
							}
							
							
							}
						else if($scope.pending == true && $scope.Add==false){
							logger.logError(" Some invoices are Pending / Draft.");
						}
						
					}
					else{
						logger.logError("Atleast One Row Required");
					}
					
				}

			}
			$scope.reset = function() {
				
				$scope.edit();

			$scope.joborder = $scope.hdrData;
			$scope.jobOrderDtl = $scope.dtlData;
			$scope.modeType();

			
		};
		$scope.print = function(rowid) {
			
			var test = parseInt(rowid);
			var url = $stateParams.tenantid
					+ '/app/jobOrderAir/print?rowid=' + rowid
			var wnd = window
					.open(
							url,
							'Athena',
							'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
			wnd.print();

		};
		
		
		$scope.qukLinkVal='';
		$scope.quickLinkMethd=function(jobId,qulkVal){
			if(qulkVal!='Select'){
				if(jobId!='' && jobId!=undefined){
			$http.post($stateParams.tenantid + '/app/jobOrderAir/quickLinkView?category='+qulkVal+'&jobId='+jobId).success(function(datas) {
						if(datas.quickLinkId!=null){
							var rowid=datas.quickLinkId;
							if(qulkVal=="HAWB"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/hbw/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/hbw/view?rowid='+rowid, '_blank');
								}else{
									$state.go('app.air.hbw.add',{tenantid:$stateParams.tenantid});
									//logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="MAWB"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/mabw/edit?rowid='+rowid); 
									//$window.open('#'+$stateParams.tenantid+'/mabw/view?rowid='+rowid,'_blank');
								}else{
									$state.go('app.air.mabw.add',{tenantid:$stateParams.tenantid});
									//logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="Delivery Order"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/airdeliveryorder/edit?rowid='+rowid);
									//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/view?rowid='+rowid,'_blank');
								}else{
									$state.go('app.air.deliveryorder.add',{tenantid:$stateParams.tenantid});
									//logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="Sales Invoice"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/invoice/salesinvoice/salesInvoiceView/'+rowid);
									//$window.open('#'+$stateParams.tenantid+"/invoice/salesinvoice/salesInvoiceView/"+rowid,'_blank');
								}else{
									$state.go('app.finance.salesinvoice-add',{tenantid:$stateParams.tenantid});
									//logger.logError("There is no "+qulkVal);
								}
							}else if(qulkVal=="Purchase Invoice"){
								if(rowid!=0){
									$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceView/'+rowid);
									//$window.open('#'+$stateParams.tenantid+"/invoice/purchaseinvoice/PurchaseInvoiceView/"+rowid,'_blank');
								}else{
									$state.go('app.finance.purchaseinvoice-add',{tenantid:$stateParams.tenantid});
									//logger.logError("There is no "+qulkVal);
								}
							}
						} else if(datas.quickLinkIdList!=null){
							var quickLinkIdList=datas.quickLinkIdList
							if(qulkVal=="HAWB"){
								$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="MAWB"){
								$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Delivery Order"){
								$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Sales Invoice"){ 
								$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}else if(qulkVal=="Purchase Invoice"){
								$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}
							
						}
						else if (datas.quickLinkId == null)
						{
							if(qulkVal=="HAWB"){
								$location.url($stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/hbw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="MAWB"){
								$location.url($stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/mabw/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Delivery Order"){
								$location.url($stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/airdeliveryorder/list?quickLinkIdList='+quickLinkIdList, '_blank');
							}else if(qulkVal=="Sales Invoice"){ 
								$location.url($stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/salesinvoice/SalesInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}else if(qulkVal=="Purchase Invoice"){
								$location.url($stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList);
								//$window.open('#'+$stateParams.tenantid+'/invoice/purchaseinvoice/PurchaseInvoiceList?quickLinkIdList='+quickLinkIdList,'_blank');
							}
							
						}
						
						
			})
			}else{
				logger.logError("There is no Job No.");
			}
		}
		}
		 $scope.remarks = function(accountHeadCode,jobNo){
	           
               if(accountHeadCode !=""){
                   ngDialog.open({
                       scope : $scope,
                       template : 'views/air/remarkslist',
                       controller : $controller('remarksCtrl', {
                           $scope : $scope,
                           purchaseObject : $scope.purchaseInvoiceData,
                           accountHeadCode:accountHeadCode,
                           jobNo:jobNo
                       }),
                       className : 'ngdialog-theme-plain',
                       showClose : false,
                       closeByDocument : false,
                       closeByEscape : false,
                       preCloseCallback : $scope.getList
                   });
               }else{
                   logger.logError("");
               }
              
           
               
       }

		});




app.controller('remarksCtrl', function($scope, $rootScope,sharedProperties, 
        logger,$http,$filter, $location,$stateParams, validationService, toaster, $window,purchaseObject,ngDialog, $timeout,accountHeadCode,jobNo) {
    
	
             console.log($scope.joborder.tempremarks);
             $scope.cancelng = function(){
     	        // $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        ngDialog.close();
     	        if(purchaseObject.purInvDueDateDtls.length>0){
     	            
     	        }else{
     	            $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        }
     	    }
	
});

app
		.controller(
				'jobOrderViewCtrl',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector) {
					$scope.customerList = [];
					$scope.shipperList = [];
					$scope.consigneeList = [];
					$scope.AolList = [];
					$scope.AodList = [];
					$scope.commodityList = [];
					$scope.isEdit = false;
					$scope.jobOrderDtlList = [];
					$scope.tempType = '';
					debugger;
					$scope.joborder = {
						service : '',
						jobDate : '',
						branch : '',
						customer : '',
						shipper : '',
						consignee : '',
						term : '',
						aol : '',
						aod : '',
						origin : '',
						destination : '',
						commodity : '',
						jobStatus : '',
						currency : '',
						quotationNo : '',
						quotationnum:'',
						salesType : '',
						salesPerson : '',
						nominatedBy : '',
						vendor : '',
						carrier : '',
						flightNo : '',
						flightDate : '',
						exRate : '',
						customsBroker : '',
						mode : '',pickupDate:'',
						stuffingDate:'',
						createdDt:'',
						sailingDate:'',
						customsCompletionsDate:'',
						etaDestinationDate:'',
						salesDate:'',
						purchaseInvoice:'',
						purchaseDate:'',
						salesInvoice:'',
						etaOriginDate:'',
						truckship1:'',
						truckship2:'',
						joborderDtl : [ {
							joborderDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '1',
							quantity : '',
							rate : '',
							currency : '',
							exRate : '',
							amount : '0',							
							buySellParty : '',
							status : '',
							color : ''
						} ]
					}

					/* $scope.jobOrderDtl = {} */

					// $scope.isQuot=false;
					var jobId = parseInt($location.search().rowid);

					$scope.ratevalues1 = function() {
						if ($scope.joborder.joborderDtl.length != null
								|| $scope.joborder.joborderDtl.length != undefined
								|| $scope.joborder.joborderDtl.length != ""
								|| $scope.joborder.joborderDtl.length != '') {
							for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {
								if (($scope.joborder.joborderDtl[i].transactionType != null)
										|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
										|| ($scope.joborder.joborderDtl[i].transactionType != "")
										|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
									if ($scope.joborder.joborderDtl[i].transactionType == "1") {
										buy1 = parseInt(buy1)
												+ parseInt($scope.joborder.joborderDtl[i].amount);
										console.log("i:" + i + " buy1:" + buy1);
									} else {
										if ($scope.joborder.joborderDtl[i].transactionType == "2") {
											sell1 = parseInt(sell1)
													+ parseInt($scope.joborder.joborderDtl[i].amount);

										}
									}
								}
							}
							total = parseInt(sell1) - parseInt(buy1);

							console.log("total" + total + " sell1:" + sell1);
						}

						$scope.joborder.sell1 = sell1;
						$scope.joborder.buy1 = buy1;
						$scope.joborder.total = total;
					}

					$scope.ratevalues = function() {
						var buy1 = 0;
						var sell = 0;
						var sell1 = 0;
						var amount = 0;

						var total = 0;
						if ($scope.joborder.joborderDtl.length != null
								|| $scope.joborder.joborderDtl.length != undefined
								|| $scope.joborder.joborderDtl.length != ""
								|| $scope.joborder.joborderDtl.length != '') {
							{
								for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {

									var amount1 = [];
									var amount = [];
									if (($scope.joborder.joborderDtl[i].transactionType != null)
											|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
											|| ($scope.joborder.joborderDtl[i].transactionType != "")
											|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
										if ($scope.joborder.joborderDtl[i].transactionType == "1") {

											if (($scope.joborder.joborderDtl[i].quantity != null
													|| $scope.joborder.joborderDtl[i].quantity != undefined
													|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
													&& ($scope.joborder.joborderDtl[i].rate != null
															|| $scope.joborder.joborderDtl[i].rate != undefined
															|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
													&& ($scope.joborder.joborderDtl[i].exRate != null
															|| $scope.joborder.joborderDtl[i].exRate == undefined
															|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
												amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
														* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
												$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

												buy1 = parseFloat(buy1)
														+ parseFloat($scope.joborder.joborderDtl[i].amount);
												console.log("i:" + i + " buy1:"
														+ buy1);

											}
										}

										else {
											if ($scope.joborder.joborderDtl[i].transactionType == "2") {

												if (($scope.joborder.joborderDtl[i].quantity != null
														|| $scope.joborder.joborderDtl[i].quantity != undefined
														|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
														&& ($scope.joborder.joborderDtl[i].rate != null
																|| $scope.joborder.joborderDtl[i].rate != undefined
																|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
														&& ($scope.joborder.joborderDtl[i].exRate != null
																|| $scope.joborder.joborderDtl[i].exRate == undefined
																|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
													amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
															* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
													$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

													sell1 = parseFloat(sell1)
															+ parseFloat($scope.joborder.joborderDtl[i].amount);
													console
															.log("i:" + i
																	+ " sell1:"
																	+ sell1);
												}
											}
										}

									}

									$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]).toFixed(2);

								}
								total = parseFloat(sell1) - parseFloat(buy1);

								console
										.log("total" + total + " sell1:"
												+ sell1);

							}
						}
						$scope.joborder.sell1 = sell1.toFixed(2);
						$scope.joborder.buy1 = buy1.toFixed(2);
						$scope.joborder.total = total.toFixed(2);

					}
					
					$scope.modeList = [];
					$scope.modeType = function() {
						var data = {};
						data["id"] = "2";
						data["text"] = "AIR";
						$scope.modeList.push(data);
						$scope.joborder.mode = $scope.modeList[0].id

					}
					$scope.modeType();

					$scope.submitupdate = function() {
					}

					$scope.salesTypeList = [];
					// $scope.getSalesType = function() {
					// var data = {};
					// data["id"] = "1";
					// data["text"] = "CROSS TRADE";
					// $scope.salesTypeList.push(data);
					// data = {};
					// data["id"] = "2";
					// data["text"] = "LOCAL";
					// $scope.salesTypeList.push(data);
					// data = {};
					// data["id"] = "3";
					// data["text"] = "NOMINATED";
					// $scope.salesTypeList.push(data);
					//					    
					//					  
					// }
					// $scope.getSalesType();
					$scope.transactionTypeList = [];

					// $scope.getTransactionType = function() {
					// var data = {};
					// data["id"] = "1";
					// data["text"] = "BUY";
					// $scope.transactionTypeList.push(data);
					// data = {};
					// data["id"] = "2";
					// data["text"] = "SELL";
					// $scope.transactionTypeList.push(data);
					//					    
					// }
					// $scope.getTransactionType();

					$scope.jobStatusList = [];
					$scope.getjobStatus = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "PENDING";
						$scope.jobStatusList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "CLOSED";
						$scope.jobStatusList.push(data);

					}
					$scope.getjobStatus();

					//$scope.PaymentMethodList = [];
					// $scope.getpaymentMethod = function() {
					// var data = {};
					// data["id"] = "1";
					// data["text"] = "PREAPID TO COLLECT";
					// $scope.PaymentMethodList.push(data);
					//					  
					// }
					// $scope.getpaymentMethod();

					$scope.jobDetailStatusList = [];
					$scope.getjobStatus = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "PENDING";
						$scope.jobDetailStatusList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "INVOICED";
						$scope.jobDetailStatusList.push(data);
						data = {};
						data["id"] = "3";
						data["text"] = "DRAFT";
						$scope.jobDetailStatusList.push(data);

					}
					$scope.getjobStatus();
					
					$scope.$watch('joborder.jobStatus', function(newValue,
							oldValue) {
						if (newValue != '' && newValue != undefined) {
							if(newValue==2)
								{
								$scope.Add=false;
								}else{
									$scope.Add=true;
								}
						}
						
					});

					// $scope.getQuotationType();
					$scope.dropdown = function() {
						debugger;
						$http.get($stateParams.tenantid+'/app/jobOrderSea/dropDownList').success(function(datas) {
							debugger
						  //  $scope.quotationList = datas.quotationList;	
							$scope.customerList = datas.customerSelectivityList;
							$scope.consigneeDropList = datas.consigneeSelectivityList;
							$scope.shipperDropList = datas.shipperSelectivityList;
							$scope.nominatedDropList = datas.nominatedSelectivityList;
							$scope.vendorDropList = datas.vendorSelectivityList;
							$scope.serviceParnrDropList=datas.serviceParnrSelectivityList;
							$scope.customerBuyList = datas.buyServiceList;
							$scope.customerSellList = datas.sellServiceList;
							$scope.salesTypeList = datas.salesSelectivityList;
							$scope.employeeList = datas.employeeSelectivityList;
							$scope.servicePartnerTypelist = datas.serviceSelectivityList;
						//	$scope.PaymentMethodList = datas.paymentSelectivityList;
							$scope.transactionTypeList = datas.transactionSelectivityList;
							$scope.chargeHeadList = datas.airChargeHeadSelectivityList;
							$scope.TermList = datas.termsSelectivityList;
							$scope.UnitList = datas.unitSelectivityList;
							$scope.uomList = datas.uomList;	 
							$scope.sizeTypeList = datas.sizeTypeSelectivityList;
							$scope.commodityList = datas.commoditySelectivityList;	
							$scope.currencylist= datas.currecnySelectivityList;
							$scope.branchList = datas.branchSelectivityList;
						    $scope.portList = datas.airPortSelectivityList;
						}).error(function(data) {

						});
						
						/*$http
								.post(
										$stateParams.tenantid
												+ '/app/airquotation/getServicePartner')
								.success(
										function(datas) {
											debugger
											$scope.customerList = datas.commonUtilityBean;

										}).error(function(data) {

								});
						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getiataList')
								.success(function(datas) {
									debugger
									$scope.portList = datas.commonUtilityBean;

								}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getBranch')
								.success(
										function(datas) {
											$scope.branchList = datas.commonUtilityBean;

										}).error(function(data) {

								});
						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getCurrencyList')
								.success(
										function(datas) {
											$scope.currencylist = angular
													.copy(datas.commonUtilityBean);
										}).error(function(data) {

								});

						$http
						.get(
								$stateParams.tenantid
										+ '/app/airquotation/getServiceList')
						.success(
								function(datas) {
									$scope.servicePartnerTypelist = datas.commonUtilityBean;

								}).error(function(data) {

						});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getEmployeeList')
								.success(
										function(datas) {
											$scope.employeeList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http.get(
								$stateParams.tenantid
										+ '/app/jobOrderAir/dropDownList1')
								.success(function(datas) {
									debugger
								//	$scope.quotationList = datas.quotationList;

								}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getSalesList')
								.success(
										function(datas) {
											$scope.salesTypeList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getServiceList')
								.success(
										function(datas) {
											$scope.servicePartnerTypelist = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getPaymentList')
								.success(
										function(datas) {
											$scope.PaymentMethodList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getTransactionList')
								.success(
										function(datas) {
											$scope.transactionTypeList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/airquotation/getChargeHeads')
								.success(
										function(datas) {
											$scope.chargeHeadList = datas.commonUtilityBean;

										}).error(function(data) {

								});

						$http.get(
								$stateParams.tenantid
										+ '/app/airquotation/getTerms')
								.success(function(datas) {
									$scope.TermList = datas.commonUtilityBean;

								}).error(function(data) {

								});

						$http.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getUnitList')
								.success(function(datas) {
									$scope.UnitList = datas.commonUtilityBean;

								}).error(function(data) {

								});*/
					}

					$scope.dropdown();

					$scope.checkValidation = function() {

						var alertmsg = "<ui><h4>Please fill the required fields</h4>";
						var msg = "";
						if ($scope.checkundefined($scope.joborder.customer)) {
							msg = msg + "<li>CUSTOMER :Field is required.</li>";
							$scope.changecolor('customer_id');
						} else {
							$scope.clearcolor('customer_id');
						}
						if ($scope.checkundefined($scope.joborder.jobDate)) {
							msg = msg + "<li>JobDate :Field is required.</li>";
							$scope.changecolor('jobDate');
						} else {
							$scope.clearcolor('jobDate');
						}
						if ($scope.checkundefined($scope.joborder.shipper)) {
							msg = msg + "<li>Shipper :Field is required.</li>";
							$scope.changecolor('shipper');
						} else {
							$scope.clearcolor('shipper');
						}
						if ($scope.checkundefined($scope.joborder.service)) {
							msg = msg + "<li>Service :Field is required.</li>";
							$scope.changecolor('service');
						} else {
							$scope.clearcolor('service');
						}
						if ($scope.checkundefined($scope.joborder.branch)) {
							msg = msg + "<li>Branch :Field is required.</li>";
							$scope.changecolor('branch');
						} else {
							$scope.clearcolor('branch');
						}
						if ($scope.checkundefined($scope.joborder.customer)) {
							msg = msg + "<li>Customer :Field is required.</li>";
							$scope.changecolor('customer');
						} else {
							$scope.clearcolor('customer');
						}
						if ($scope.checkundefined($scope.joborder.term)) {
							msg = msg + "<li>Term :Field is required.</li>";
							$scope.changecolor('term');
						} else {
							$scope.clearcolor('term');
						}
						if ($scope.checkundefined($scope.joborder.destination)) {
							msg = msg + "<li>Destination :Field is required.</li>";
							$scope.changecolor('destination');
						} else {
							$scope.clearcolor('destination');
						}
						if ($scope.checkundefined($scope.joborder.aol)) {
							msg = msg + "<li>AOL:Field is required.</li>";
							$scope.changecolor('aol');
						} else {
							$scope.clearcolor('aol');
						}
						if ($scope.checkundefined($scope.joborder.aod)) {
							msg = msg + "<li>AOD:Field is required.</li>";
							$scope.changecolor('aod');
						} else {
							$scope.clearcolor('aod');
						}
						if ($scope.checkundefined($scope.joborder.origin)) {
							msg = msg + "<li>Origin:Field is required.</li>";
							$scope.changecolor('origin');
						} else {
							$scope.clearcolor('origin');
						}
						if ($scope.checkundefined($scope.joborder.quotationNo)) {
							msg = msg + "<li>QuotationNo:Field is required.</li>";
							$scope.changecolor('quotationNo');
						} else {
							$scope.clearcolor('quotationNo');
						}
						
						
						if ($scope.checkundefined($scope.joborder.currency)) {
							msg = msg + "<li>Currency:Field is required.</li>";
							$scope.changecolor('currency');
						} else {
							$scope.clearcolor('currency');
						}
						if ($scope.checkundefined($scope.joborder.exRate)) {
							msg = msg + "<li>ExRate:Field is required.</li>";
							$scope.changecolor('exRate');
						} else {
							$scope.clearcolor('exRate');
						}
						if ($scope.checkundefined($scope.joborder.salesType)) {
							msg = msg + "<li>salesType:Field is required.</li>";
							$scope.changecolor('salesType');
						} else {
							$scope.clearcolor('salesType');
						}
						if ($scope.checkundefined($scope.joborder.salesPerson)) {
							msg = msg + "<li>SalesPerson:Field is required.</li>";
							$scope.changecolor('salesPerson');
						} else {
							$scope.clearcolor('salesPerson');
						}
						
						if ($scope.checkundefined($scope.joborder.flightNo)) {
							msg = msg + "<li>FlightNo:Field is required.</li>";
							$scope.changecolor('flightNo');
						} else {
							$scope.clearcolor('flightNo');
						}
						if ($scope.checkundefined($scope.joborder.flightDate)) {
							msg = msg + "<li>FlightDate:Field is required.</li>";
							$scope.changecolor('flightDate');
						} else {
							$scope.clearcolor('flightDate');
						}
						
						
						if ($scope.checkundefined($scope.joborder.vendor)) {
							msg = msg + "<li>Vendor:Field is required.</li>";
							$scope.changecolor('vendor');
						} else {
							$scope.clearcolor('vendor');
						}

						angular
								.forEach(
										$scope.joborder.joborderDtl,
										function(chargesDetail, index) {
											debugger
											if ($scope
													.checkundefined(chargesDetail.chargeHead)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Charge Heads :Field is required.</li>";
												$scope
														.changecolor('chargeHeads'
																+ index);
											} else {
												$scope.clearcolor('chargeHeads'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.unit)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Unit :Field is required.</li>";
												$scope.changecolor('unit'
														+ index);
											} else {
												$scope.clearcolor('unit'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.currency)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# CURRENCY :Field is required.</li>";
												$scope.changecolor('currency'
														+ index);
											} else {
												$scope.clearcolor('currency'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.quantity)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "#Quantity :Field is required.</li>";
												$scope.changecolor('quantity'
														+ index);
												$('#quantity' + index).find('input')
														.css("border-color",
																"red");

											} else {
												$('#qty' + index).find('input')
														.css("border-color",
																"#e8dddd");
											}
											if ($scope
													.checkundefined(chargesDetail.rate)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Rate :Field is required.</li>";
												$scope.changecolor('rate'
														+ index);
											} else {
												$scope.clearcolor('rate'
														+ index);
											}
											
											if ($scope
													.checkundefined(chargesDetail.transactionType)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
												$scope.changecolor('transactionTypes'
														+ index);
											} else {
												$scope.clearcolor('transactionTypes'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.buySellParty)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Buy Sell:Field is required.</li>";
												$scope.changecolor('buySellPartys'
														+ index);
											} else {
												$scope.clearcolor('buySellPartys'
														+ index);
											}
											if ($scope
													.checkundefined(chargesDetail.amount)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Amount:Field is required.</li>";
												$scope.changecolor('amount'
														+ index);
											} else {
												$scope.clearcolor('amount'
														+ index);
											}

											if ($scope
													.checkundefined(chargesDetail.exRate)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Exchange Rate:Field is required.</li>";
												$scope.changecolor('exRate'
														+ index);
											} else {
												$scope.clearcolor('exRate'
														+ index);
											}

											if ($scope
													.checkundefined(chargesDetail.transactionType)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
												$scope.changecolor('transactionTypes'
														+ index);
											} else {
												$scope.clearcolor('transactionTypes'
														+ index);
											}


											if ($scope
													.checkundefined(chargesDetail.status)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Status :Field is required.</li>";
												$scope.changecolor('status'
														+ index);
											} else {
												$scope.clearcolor('status'
														+ index);
											}

											$scope.print = function(rowid) {
												var test = parseInt(rowid);
												var url = $stateParams.tenantid
														+ '/app/jobOrderAir/print?rowid='
														+ test
												var wnd = window
														.open(
																url,
																'Athena',
																'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
												wnd.print();

											};

											$scope.print1 = function(rowid) {
												rowid = 4852;
												var test = parseInt(rowid);
												var url = $stateParams.tenantid
														+ '/app/jobOrderAir/print1?rowid='
														+ rowid
												var wnd = window
														.open(
																url,
																'Athena',
																'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
												wnd.print();

											};

										});
						alertmsg = alertmsg + msg + "</ui>";
						if ($scope.checkundefined(msg)) {
							return '';
						} else {
							return alertmsg;
						}

					}

					$scope.checkundefined = function(value) {
						var invalid = false;
						if (value == undefined || value == 'undefined'
								|| value == null || value == 'null'
								|| value == '') {
							invalid = true;
						}
						return invalid;

					}

					$scope.changecolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "red");
						;

					}
					$scope.clearcolor = function(id) {
						$('#' + id + ' .selectivityId').find('input').css(
								"border-color", "#e8dddd");
						;

					}

					$scope.isEdit = false;

					if (jobId != '' && jobId != undefined) {
						$scope.isEdit = true;

						$scope.dropdown();

						$http
								.post(
										$stateParams.tenantid
										+ '/app/jobOrderAir/viewair',
										jobId)
								.success(
										function(data) {
											debugger
											$scope.joborder = data.lJobOrderBean[0];
											$scope.joborder.service = data.lJobOrderBean[0].service
													.toString();
											$scope.joborder.branch = data.lJobOrderBean[0].branch
													.toString();
											$scope.joborder.mode = data.lJobOrderBean[0].mode
													.toString();
											$scope.joborder.jobDate = data.lJobOrderBean[0].jobDate;
											$scope.joborder.aol = data.lJobOrderBean[0].aol
													.toString();
											$scope.joborder.aod = data.lJobOrderBean[0].aod
													.toString();
											$scope.joborder.term = data.lJobOrderBean[0].term
													.toString();
											$scope.joborder.origin = data.lJobOrderBean[0].origin
													.toString();
											$scope.joborder.destination = data.lJobOrderBean[0].destination
													.toString();
											$scope.joborder.customer = data.lJobOrderBean[0].customer
													.toString();
											$scope.joborder.shipper = data.lJobOrderBean[0].shipper
													.toString();
											$scope.joborder.consignee = data.lJobOrderBean[0].consignee
													.toString();
											if (data.lJobOrderBean.nominatedBy != null
													&& data.data.lJobOrderBean.nominatedBy != '') {
											$scope.joborder.nominatedBy = data.lJobOrderBean[0].nominatedBy
													.toString();
											}
											$scope.joborder.vendor = data.lJobOrderBean[0].vendor
													.toString();
											$scope.joborder.currency = data.lJobOrderBean[0].currency
													.toString();
											if (data.lJobOrderBean[0].customsBroker != null
													&& data.data.lJobOrderBean[0].customsBroker != '') {
											$scope.joborder.customsBroker = data.lJobOrderBean[0].customsBroker
													.toString();
											}
											$scope.joborder.quotationnum = data.lJobOrderBean[0].quotationnum
													.toString();
											//$scope.joborder.currency = data.lJobOrderBean[0].currency;

											$scope.joborder.salesType = data.lJobOrderBean[0].salesType
													.toString();

											for (var i = 0; i < $scope.joborder.joborderDtl.length; i++) {
												$scope.joborder.joborderDtl[i].chargeHead = $scope.joborder.joborderDtl[i].chargeHead
														.toString();
												$scope.joborder.joborderDtl[i].unit = $scope.joborder.joborderDtl[i].unit
														.toString();
												$scope.joborder.joborderDtl[i].currency = $scope.joborder.joborderDtl[i].currency
														.toString();
											
												$scope.joborder.joborderDtl[i].transactionType = $scope.joborder.joborderDtl[i].transactionType
														.toString();
												$scope.joborder.joborderDtl[i].buySellParty = $scope.joborder.joborderDtl[i].buySellParty
														.toString();
												$scope.joborder.joborderDtl[i].amount = $scope.joborder.joborderDtl[i].amount;
												$scope.joborder.joborderDtl[i].rate = $scope.joborder.joborderDtl[i].rate;

												$scope.joborder.joborderDtl[i].status = $scope.joborder.joborderDtl[i].status
														.toString();
												$scope.joborder.joborderDtl[i].exRate = $scope.joborder.joborderDtl[i].exRate;
												 $scope.joborder.joborderDtl[i].color = $scope.joborder.joborderDtl[i].color;
											}

										});

					}

					$scope.addRow = function() {
						var jobOrderDtl = {
							joborderDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '1',
							quantity : '',
							rate : '',
							currency : '',
							exRate : '',
							amount : '0',						
							buySellParty : '',
							status : '1'
						}
						$scope.joborder.joborderDtl.push(jobOrderDtl);
					};

					$scope.deleteIds = [];
					$scope.removeRow = function() {
						var len = $scope.joborder.joborderDtl.length;
						for (var index = len - 1; index < len; index--) {
							if ($scope.joborder.joborderDtl[index].select == true) {
								if ($scope.joborder.joborderDtl[index].joborderDtlId != null
										&& $scope.joborder.joborderDtl[index].joborderDtlId > 0) {
									$scope.deleteIds
											.push($scope.joborder.joborderDtl[index].joborderDtlId);
								}
								$scope.joborder.joborderDtl.splice(index, 1);
								$scope.ratevalues();
							}
						}
					};

					$scope.hdrData = $scope.joborder;
					$scope.dtlData = $scope.jobOrderDtl;
					$scope.reset = function() {
						$scope.joborder = $scope.hdrData;
						$scope.jobOrderDtl = $scope.dtlData;
					};

					$scope.cancel = function() {
						$state.go('app.air.joborder.list', {
							tenantid : $stateParams.tenantid
						});
					}
					
					
					var jobId = $location.search().jobId;

					if (jobId != null && jobId != undefined) {

						$http
								.post(
										$stateParams.tenantid
												+ '/app/jobOrderAir/edit',
										jobId)
								.success(
										function(data) {
											debugger
											$scope.joborder = data.lJobOrderBean[0];
											$scope.joborder.service = data.lJobOrderBean[0].service
													.toString();
											$scope.joborder.branch = data.lJobOrderBean[0].branch
													.toString();
											$scope.joborder.mode = data.lJobOrderBean[0].mode
													.toString();
											$scope.joborder.jobDate = data.lJobOrderBean[0].jobDate;
											$scope.joborder.aol = data.lJobOrderBean[0].aol
													.toString();
											$scope.joborder.aod = data.lJobOrderBean[0].aod
													.toString();
											$scope.joborder.term = data.lJobOrderBean[0].term
													.toString();
											$scope.joborder.origin = data.lJobOrderBean[0].origin
													.toString();
											$scope.joborder.destination = data.lJobOrderBean[0].destination
													.toString();
											$scope.joborder.customer = data.lJobOrderBean[0].customer
													.toString();
											$scope.joborder.shipper = data.lJobOrderBean[0].shipper
													.toString();
											$scope.joborder.consignee = data.lJobOrderBean[0].consignee
													.toString();
											$scope.joborder.nominatedBy = data.lJobOrderBean[0].nominatedBy
													.toString();
											$scope.joborder.vendor = data.lJobOrderBean[0].vendor
													.toString();
											$scope.joborder.currency = data.lJobOrderBean[0].currency
													.toString();
											$scope.joborder.customsBroker = data.lJobOrderBean[0].customsBroker
													.toString();
											$scope.joborder.quotationNo = data.lJobOrderBean[0].quotationNo
													.toString();
											//$scope.joborder.currency = data.lJobOrderBean[0].currency;

											$scope.joborder.salesType = data.lJobOrderBean[0].salesType
													.toString();

											for (var i = 0; i < $scope.joborder.joborderDtl.length; i++) {
												$scope.joborder.joborderDtl[i].chargeHead = $scope.joborder.joborderDtl[i].chargeHead
														.toString();
												$scope.joborder.joborderDtl[i].unit = $scope.joborder.joborderDtl[i].unit
														.toString();
												$scope.joborder.joborderDtl[i].currency = $scope.joborder.joborderDtl[i].currency
														.toString();
											
												$scope.joborder.joborderDtl[i].transactionType = $scope.joborder.joborderDtl[i].transactionType
														.toString();
												$scope.joborder.joborderDtl[i].buySellParty = $scope.joborder.joborderDtl[i].buySellParty
														.toString();
												$scope.joborder.joborderDtl[i].amount = $scope.joborder.joborderDtl[i].amount;
												$scope.joborder.joborderDtl[i].rate = $scope.joborder.joborderDtl[i].rate;

												$scope.joborder.joborderDtl[i].status = $scope.joborder.joborderDtl[i].status
														.toString();
												$scope.joborder.joborderDtl[i].exRate = $scope.joborder.joborderDtl[i].exRate;

											}

										});

				}
					$scope.printRoutingOrder = function(){
				        debugger
				        var url = $stateParams.tenantid+'/app/jobOrderSea/printRoutingOrder1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					
					
					$scope.printPrealertAir= function(jobId){
				        debugger
				        var url = $stateParams.tenantid+'/app/jobOrderSea/printPreAlert1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					$scope.joborder.jobId=jobId;
					$scope.updateJob = function() {
						console.log($scope.joborder);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							
							$http.post(
									$stateParams.tenantid
											+ '/app/jobOrderAir/update',
									$scope.joborder).success(function(datas) {
								debugger
								if (datas.success == true) {
									logger.logSuccess(datas.message);
									
									$state.go('app.air.joborder.list', {
										tenantid : $stateParams.tenantid
									});
									$scope.edit();
								} else {
									logger.logError(datas.message);
								}
							}).error(function(data) {
								logger.logError("Please try again");
							});
						}

					}

				});

app.controller('jobtableCtrl', function($scope,$http, $filter,logger,$stateParams,$location){
	$scope.tenant =  $stateParams.tenantid;

	var jobId =   parseInt($location.search().rowid) ;
	   if(jobId != '' && jobId != null){
		   $scope.isEdit=true;
	   }
	   else{
		   $scope.isEdit=false;
	   }
	   
	   var defaultCurrency1 = '';
		 var  fromCurrency1='';
		 var toCurrency1='';
	    
	    $scope.$watch('joborder.joborderDtl[trIndex].currency', function(newValue, oldValue) {
			if (newValue != '' && newValue != undefined) {
			    
			    $http
				.get(
						$stateParams.tenantid
								+ '/app/currency/getExchangeRate?currencyId='+parseInt(newValue))
				.success(
						function(data) {
							debugger
							if(!$scope.isEdit){
								$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
							}
							
							defaultCurrency1 = data.defaultCurrency;
							fromCurrency1=data.fromCurrency;
							toCurrency1=data.toCurrency;
							$scope.checkExRate($scope.joborder.joborderDtl[$scope.trIndex].exRate,$scope.trIndex);
							
						});
			}
			
		});
		
		$scope.checkExRate = function(exRate,trIndex){
			if(exRate >= fromCurrency1 && exRate <= toCurrency1){
				
			}
			else{
				logger.logError("Exchange Rate Between "+fromCurrency1+ " and " +toCurrency1);
				$scope.joborder.joborderDtl[trIndex].exRate ='';
			}
		}

		$scope.CheckExRateDtl = function(currecny,index){
			if (currecny != '' && currecny != undefined) {
		    
		    $http
			.get(
					$stateParams.tenantid
							+ '/app/currency/getExchangeRate?currencyId='+parseInt(currecny))
			.success(
					function(data) {
						debugger
						/*if(!$scope.isEdit){
							$scope.joborder.joborderDtl[$scope.trIndex].exRate = data.defaultCurrency;
						}*/
						
						defaultCurrency1 = data.defaultCurrency;
						fromCurrency1=data.fromCurrency;
						toCurrency1=data.toCurrency;
						$scope.checkExRate($scope.joborder.joborderDtl[index].exRate,index);
						$scope.ratevalues();
					});
		}
			
		}
		 $scope.$watch('joborder.joborderDtl[trIndex].transactionType', function(newValue, oldValue) {
			   debugger;
			        if (newValue != '' && newValue != undefined) {
			        	
						var buy1 =0;
						var sell=0;
						var sell1 =0;
						var amount =0;

						var total =0; 
				    	if($scope.joborder.joborderDtl.length != null ||$scope.joborder.joborderDtl.length != undefined ||$scope.joborder.joborderDtl.length != "" ||$scope.joborder.joborderDtl.length != ''){
			{
			for( var i=0;i<=$scope.joborder.joborderDtl.length-1;i++)
			{


			var amount1=[];
			var amount=[];
			if(($scope.joborder.joborderDtl[i].transactionType != null ) || ($scope.joborder.joborderDtl[i].transactionType != undefined ) ||($scope.joborder.joborderDtl[i].transactionType != "" ) ||($scope.joborder.joborderDtl[i].transactionType != '' ))
			{
			if($scope.joborder.joborderDtl[i].transactionType =="1")
			{
				
				if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
				{
				amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
				$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

				

				buy1=parseFloat(buy1)+parseFloat($scope.joborder.joborderDtl[i].amount);
				console.log("i:"+i+" buy1:"+buy1);
				
				}
			}	

			else {
				if($scope.joborder.joborderDtl[i].transactionType =="2")
				{
								
								if(($scope.joborder.joborderDtl[i].quantity  != null || $scope.joborder.joborderDtl[i].quantity != undefined ||$scope.joborder.joborderDtl[i].quantity !="" ||$scope.joborder.joborderDtl[i].quantity != '') &&  ($scope.joborder.joborderDtl[i].rate  != null || $scope.joborder.joborderDtl[i].rate != undefined ||$scope.joborder.joborderDtl[i].rate != " " ||$scope.joborder.joborderDtl[i].rate != '') && ($scope.joborder.joborderDtl[i].exRate  != null || $scope.joborder.joborderDtl[i].exRate == undefined ||$scope.joborder.joborderDtl[i].exRate !="" ||$scope.joborder.joborderDtl[i].exRate != '') )
								{
								amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity)) * parseFloat(($scope.joborder.joborderDtl[i].rate))*parseFloat(($scope.joborder.joborderDtl[i].exRate)));
								$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]);

								sell1=parseFloat(sell1)+parseFloat($scope.joborder.joborderDtl[i].amount);
								console.log("i:"+i+" sell1:"+sell1);
								}
				}	
			}




			}

			$scope.joborder.joborderDtl[i].amount=parseFloat(amount1[i]).toFixed(2);


			}
			total =parseFloat(sell1)-parseFloat(buy1);

			console.log("total"+total+" sell1:"+sell1);	


			}
				    	}
				    	$scope.joborder.sell1=sell1.toFixed(2);
						$scope.joborder.buy1=buy1.toFixed(2);
						$scope.joborder.total=total.toFixed(2);
						
						
						var id = newValue;
						/*$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
							console.log(datas);				
							 $scope.serviceParnrDropList=datas.serviceParnrList;
						  
						}).error(function(data) {

						});*/
						
			        
			        }  
			        });
		
		$scope.ratevalues = function() {
			var buy1 = 0;
			var sell = 0;
			var sell1 = 0;
			var amount = 0;

			var total = 0;
			if ($scope.joborder.joborderDtl.length != null
					|| $scope.joborder.joborderDtl.length != undefined
					|| $scope.joborder.joborderDtl.length != ""
					|| $scope.joborder.joborderDtl.length != '') {
				{
					for (var i = 0; i <= $scope.joborder.joborderDtl.length - 1; i++) {

						var amount1 = [];
						var amount = [];
						if (($scope.joborder.joborderDtl[i].transactionType != null)
								|| ($scope.joborder.joborderDtl[i].transactionType != undefined)
								|| ($scope.joborder.joborderDtl[i].transactionType != "")
								|| ($scope.joborder.joborderDtl[i].transactionType != '')) {
							if ($scope.joborder.joborderDtl[i].transactionType == "1") {

								if (($scope.joborder.joborderDtl[i].quantity != null
										|| $scope.joborder.joborderDtl[i].quantity != undefined
										|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
										&& ($scope.joborder.joborderDtl[i].rate != null
												|| $scope.joborder.joborderDtl[i].rate != undefined
												|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
										&& ($scope.joborder.joborderDtl[i].exRate != null
												|| $scope.joborder.joborderDtl[i].exRate == undefined
												|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
									amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
											* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
									$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

									buy1 = parseFloat(buy1)
											+ parseFloat($scope.joborder.joborderDtl[i].amount);
									console.log("i:" + i + " buy1:"
											+ buy1);

								}
							}

							else {
								if ($scope.joborder.joborderDtl[i].transactionType == "2") {

									if (($scope.joborder.joborderDtl[i].quantity != null
											|| $scope.joborder.joborderDtl[i].quantity != undefined
											|| $scope.joborder.joborderDtl[i].quantity != "" || $scope.joborder.joborderDtl[i].quantity != '')
											&& ($scope.joborder.joborderDtl[i].rate != null
													|| $scope.joborder.joborderDtl[i].rate != undefined
													|| $scope.joborder.joborderDtl[i].rate != " " || $scope.joborder.joborderDtl[i].rate != '')
											&& ($scope.joborder.joborderDtl[i].exRate != null
													|| $scope.joborder.joborderDtl[i].exRate == undefined
													|| $scope.joborder.joborderDtl[i].exRate != "" || $scope.joborder.joborderDtl[i].exRate != '')) {
										amount1[i] = (parseFloat(($scope.joborder.joborderDtl[i].quantity))
												* parseFloat(($scope.joborder.joborderDtl[i].rate)) * parseFloat(($scope.joborder.joborderDtl[i].exRate)));
										$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]);

										sell1 = parseFloat(sell1)
												+ parseFloat($scope.joborder.joborderDtl[i].amount);
										console
												.log("i:" + i
														+ " sell1:"
														+ sell1);
									}
								}
							}

						}

						$scope.joborder.joborderDtl[i].amount = parseFloat(amount1[i]).toFixed(2);

					}
					total = parseFloat(sell1) - parseFloat(buy1);

					console
							.log("total" + total + " sell1:"
									+ sell1);

				}
			}
			$scope.joborder.sell1 = sell1.toFixed(2);
			$scope.joborder.buy1 = buy1.toFixed(2);
			$scope.joborder.total = total.toFixed(2);

		}
	
		
		/*$http.get(
				$stateParams.tenantid
						+ '/app/jobOrderAir/dropDownList')
				.success(function(datas) {
					debugger
					$scope.customerBuyList = datas.buyServiceList;
					$scope.customerSellList = datas.sellServiceList;
				}).error(function(data) {

				});*/
		
		  /*$scope.$watch('joborder.joborderDtl[trIndex].transactionType', function(newValue, oldValue) {
			   debugger;
			        if (newValue != '' && newValue != undefined) {
			        	var id = newValue;
						$http.get($stateParams.tenantid+'/app/seaquotation/getServicePartnerListid?id='+ id).success(function(datas) {
							console.log(datas);				
							 $scope.customerList=datas.serviceParnrList;
						  
						}).error(function(data) {

						});
			        }
		  });*/

    
    });