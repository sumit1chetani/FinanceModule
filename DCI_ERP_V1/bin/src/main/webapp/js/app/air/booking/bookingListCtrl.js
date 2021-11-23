'use strict';
app.controller('airbookinglistctrl',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector) {
					$scope.itemsByPage = 10;
						$scope.add=false;
					$scope.getBookingList = function() {
						$http
								.post(
										$stateParams.tenantid
												+ '/app/bookingAir/list')
								.success(function(data) {
									$scope.rowCollection = data.lBookingBean;
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
																	+ '/app/bookingAir/delete',
															jobNo)
													.success(
															function(data) {
																if (data.success = true) {
																	logger
																			.logSuccess('Booking Deleted Successfully.')
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
						$state.go('app.air.booking.add', {
							tenantid : $stateParams.tenantid
						});
					};

					$scope.editJob = function(jobId) {

						$location.url($stateParams.tenantid
								+ '/bookingAir/edit?rowid=' + jobId);
					}
					$scope.print = function(rowid) {
						
						var test = parseInt(rowid);
						var url = $stateParams.tenantid
								+ '/app/bookingAir/print?rowid=' + rowid
						var wnd = window
								.open(
										url,
										'HISERP',
										'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						wnd.print();

					};
					// $scope.editBooking = function(rowid) {
					// debugger
					// $location.url($stateParams.tenantid+'/bookingSea/edit?rowid='+rowid);
					//			
					// }

					$scope.viewJob = function(jobId) {
						$location.url($stateParams.tenantid
								+ '/bookingAir/view?rowid=' + jobId);
					}

				});

app
		.controller(
				'bookingAddctrl',
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
					$scope.bookingDtlList = [];
					$scope.tempType = '';
					debugger;
					$scope.booking = {
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
						salesType : '',
						salesPerson : '',
						nominatedBy : '',
						carrier : '',
						exRate : '',
						customsBroker : '',
						mode : '',
						workOrderNo : '',
					
					}
			
					
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

					$scope.booking.jobDate = dd + '/' + mm + '/' + yyyy;


					$scope.modeList = [];
					$scope.modeType = function() {
						var data = {};
						data["id"] = "2";
						data["text"] = "AIR";
						$scope.modeList.push(data);
						$scope.booking.mode = $scope.modeList[0].id

					}
					$scope.modeType();

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

					$scope.PaymentMethodList = [];
					
					$scope.jobDetailStatusList = [];
					$scope.getjobStatus = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "PENDING";
						$scope.jobDetailStatusList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "CLOSED";
						$scope.jobDetailStatusList.push(data);

					}
					$scope.getjobStatus();

					
					$scope.dropdown = function() {
						debugger;
						$http
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
						$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
							
						    $scope.commodityList = datas.commonUtilityBean;	    

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
												+ '/app/airquotation/getServicePartnerType')
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
										+ '/app/bookingAir/dropDownList')
								.success(function(datas) {
									debugger
									$scope.quotationList = datas.quotationList;

								}).error(function(data) {

								});
					}

					$scope.dropdown();

					$scope.quotationList = [];
					$scope.checkValidation = function() {

						var alertmsg = "<ui><h4>Please fill the required fields</h4>";
						var msg = "";
						if ($scope.checkundefined($scope.booking.customer)) {
							msg = msg + "<li>CUSTOMER :Field is required.</li>";
							$scope.changecolor('customer_id');
						} else {
							$scope.clearcolor('customer_id');
						}
						
						if ($scope.checkundefined($scope.booking.branch)) {
							msg = msg + "<li>BRANCH :Field is required.</li>";
							$scope.changecolor('branch');
						} else {
							$scope.clearcolor('branch');
						}
						
						
						if ($scope.checkundefined($scope.booking.service)) {
							msg = msg + "<li>SERVICE :Field is required.</li>";
							$scope.changecolor('service');
						} else {
							$scope.clearcolor('service');
						}

						
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
					

					$scope.deleteIds = [];
					
					/*$scope
							.$watch(
									'booking.quotationNo',
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
																	$scope.booking.salesPerson = data.lQuotationBean[0].salesPerson
																			.toString();
																}
																if (data.lQuotationBean[0].carrier != null
																		&& data.lQuotationBean[0].carrier != '') {
																	$scope.booking.carrier = data.lQuotationBean[0].carrier
																			.toString();
																}
																if (data.lQuotationBean[0].flightNo != null
																		&& data.lQuotationBean[0].flightNo != '') {
																	$scope.booking.flightNo = data.lQuotationBean[0].flightNo;
																}

																if (data.lQuotationBean[0].flightDate != null
																		&& data.lQuotationBean[0].flightDate != '') {
																	$scope.booking.flightDate = data.lQuotationBean[0].flightDate;
																}

																if (data.lQuotationBean[0].service != null
																		&& data.lQuotationBean[0].service != '') {
																	$scope.booking.service = data.lQuotationBean[0].service
																			.toString();
																}
																if (data.lQuotationBean[0].commodity != null
																		&& data.lQuotationBean[0].commodity != '') {
																	$scope.booking.commodity = data.lQuotationBean[0].commodity;
																}

																if (data.lQuotationBean[0].branch != null
																		&& data.lQuotationBean[0].branch != '') {
																	$scope.booking.branch = data.lQuotationBean[0].branch
																			.toString();
																}
																if (data.lQuotationBean[0].mode != null
																		&& data.lQuotationBean[0].mode != '') {
																	$scope.booking.mode = data.lQuotationBean[0].mode
																			.toString();
																}
																if (data.lQuotationBean[0].aol != null
																		&& data.lQuotationBean[0].aol != '') {
																	$scope.booking.aol = data.lQuotationBean[0].aol
																			.toString();
																}
																if (data.lQuotationBean[0].aod != null
																		&& data.lQuotationBean[0].aod != '') {
																	$scope.booking.aod = data.lQuotationBean[0].aod
																			.toString();
																}
																if (data.lQuotationBean[0].term != null
																		&& data.lQuotationBean[0].term != '') {
																	$scope.booking.term = data.lQuotationBean[0].term
																			.toString();
																}
																if (data.lQuotationBean[0].term != null
																		&& data.lQuotationBean[0].term != '') {
																	$scope.booking.origin = data.lQuotationBean[0].origin
																			.toString();
																}
																if (data.lQuotationBean[0].destination != null
																		&& data.lQuotationBean[0].destination != '') {
																	$scope.booking.destination = data.lQuotationBean[0].destination
																			.toString();
																}
																if (data.lQuotationBean[0].customer != null
																		&& data.lQuotationBean[0].customer != '') {
																	$scope.booking.customer = data.lQuotationBean[0].customer
																			.toString();
																}
																if (data.lQuotationBean[0].shipper != null
																		&& data.lQuotationBean[0].shipper != '') {
																	$scope.booking.shipper = data.lQuotationBean[0].shipper
																			.toString();
																}
																if (data.lQuotationBean[0].consignee != null
																		&& data.lQuotationBean[0].consignee != '') {
																	$scope.booking.consignee = data.lQuotationBean[0].consignee
																			.toString();
																}
																if (data.lQuotationBean[0].nominatedBy != null
																		&& data.lQuotationBean[0].nominatedBy != '') {
																	$scope.booking.nominatedBy = data.lQuotationBean[0].nominatedBy
																			.toString();
																}
																if (data.lQuotationBean[0].vendor != null
																		&& data.lQuotationBean[0].vendor != '') {
																	$scope.booking.vendor = data.lQuotationBean[0].vendor
																			.toString();
																}
																if (data.lQuotationBean[0].currency != null
																		&& data.lQuotationBean[0].currency != '') {
																	$scope.booking.currency = data.lQuotationBean[0].currency
																			.toString();
																}
																if (data.lQuotationBean[0].salesType != null
																		&& data.lQuotationBean[0].salesType != '') {
																	$scope.booking.salesType = data.lQuotationBean[0].salesType
																			.toString();
																}
																$scope.booking.bookingDtl = data.lQuotationBean[0].quotationDtl;
																for (var i = 0; i < $scope.booking.bookingDtl.length; i++) {
																	$scope.booking.bookingDtl[i].chargeHead = $scope.booking.bookingDtl[i].chargeHeads
																			.toString();
																	$scope.booking.bookingDtl[i].unit = $scope.booking.bookingDtl[i].unit
																			.toString();
																	$scope.booking.bookingDtl[i].currency = $scope.booking.bookingDtl[i].currency
																			.toString();
																	$scope.booking.bookingDtl[i].paymentMode = $scope.booking.bookingDtl[i].paymentMethod
																			.toString();
																	$scope.booking.bookingDtl[i].transactionType = $scope.booking.bookingDtl[i].transactionType
																			.toString();
																	$scope.booking.bookingDtl[i].buySellParty = $scope.booking.bookingDtl[i].buySell
																			.toString();
																	$scope.booking.bookingDtl[i].quantity = $scope.booking.bookingDtl[i].qty;
																	$scope.booking.bookingDtl[i].exRate = $scope.booking.bookingDtl[i].exchangeRate;

																}

															});
										}
									})*/

					$scope.hdrData = $scope.booking;
					$scope.dtlData = $scope.bookingDtl;
					$scope.resetadd = function() {
						$scope.booking.service = '';
						$scope.booking.jobDate ='';
						$scope.booking.branch ='';
						$scope.booking.customer ='';
						$scope.booking.shipper ='';
						$scope.booking.consignee ='';
						$scope.booking.term ='';
						$scope.booking.aol ='';
						$scope.booking.aod ='';
						$scope.booking.origin ='';
						$scope.booking.destination ='';
						$scope.booking.commodity ='';
						$scope.booking.jobStatus ='';
						$scope.booking.currency ='';
						$scope.booking.quotationNo ='';
						$scope.booking.salesType ='';
						$scope.booking.salesPerson ='';
						$scope.booking.nominatedBy ='';
						$scope.booking.carrier ='';
						$scope.booking.exRate ='';
						$scope.booking.customsBroker ='';
						
						$scope.booking.workOrderNo ='';
					
					};

					$scope.cancel = function() {
						$state.go('app.air.booking.list', {
							tenantid : $stateParams.tenantid
						});
					}

					

					$scope.saveJob = function() {
						console.log($scope.booking);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							$http.post(
									$stateParams.tenantid
											+ '/app/bookingAir/save',
									$scope.booking).success(function(datas) {
								debugger
								if (datas.success == true) {
									logger.logSuccess(datas.message);
									$state.go('app.air.booking.list', {
										tenantid : $stateParams.tenantid
									});
									if ($scope.createQuote) {
									} else {
									}

								} else {
									logger.logError(datas.message);
								}
							}).error(function(data) {
								logger.logError("Please try again");
							});
						}

					}

			

					

				});

app
		.controller(
				'bookingEditctrl',
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
					$scope.bookingDtlList = [];
					$scope.tempType = '';
					debugger;
					$scope.booking = {
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
						salesType : '',
						salesPerson : '',
						nominatedBy : '',
						vendor : '',
						carrier : '',
						flightNo : '',
						flightDate : '',
						exRate : '',
						customsBroker : '',
						mode :'1',
						bookingDtl :[ {
							bookingDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '',
							quantity : '',
							rate : '',
							currency :'',
							exRate :'',
							amount : '0',
							paymentMode: '',
							buySellParty : '',
							jobStatus1:'',
								amount1 :'',
								note:''
					}] 
						
					}

					/* $scope.bookingDtl = {} */

					// $scope.isQuot=false;
					$scope.jobId = parseInt($location.search().rowid);
					
					$scope.addRow = function() {
						var bookingDtl = {
								bookingDtlId : '',
								chargeHead : '',
								unit : '',
								transactionType : '',
								quantity : '',
								rate : '',
								currency :'',
								exRate :'',
								amount : '0',
								paymentMode: '',
								buySellParty : '',
								jobStatus1:'',
									amount1 :'',
									note:''
						}
						$scope.booking.bookingDtl.push(bookingDtl);
					};

					$scope.deleteIds = [];
					$scope.removeRow = function() {
						var len = $scope.booking.bookingDtl.length;
						for (var index = len - 1; index < len; index--) {
							if ($scope.booking.bookingDtl[index].select == true) {
								if ($scope.booking.bookingDtl[index].bookingDtlId != null
										&& $scope.booking.bookingDtl[index].bookingDtlId > 0) {
									$scope.deleteIds
											.push($scope.booking.bookingDtl[index].bookingDtlId);
								}
								$scope.booking.bookingDtl.splice(index, 1);
							}
						}
					};


					$scope.modeList = [];
					$scope.modeType = function() {
						var data = {};
						data["id"] = "2";
						data["text"] = "AIR";
						$scope.modeList.push(data);
						$scope.booking.mode = $scope.modeList[0].id

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


					$scope.checkundefined = function(value) {
						var invalid = false;
						if (value == undefined || value == 'undefined'
								|| value == null || value == 'null'
								|| value == '') {
							invalid = true;
						}
						return invalid;

					}
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

					$scope.PaymentMethodList = [];
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
						data["text"] = "CLOSED";
						$scope.jobDetailStatusList.push(data);

					}
					$scope.getjobStatus();

					// $scope.getQuotationType();
					$scope.dropdown = function() {
						debugger;
						$http
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
												+ '/app/airquotation/getServicePartnerType')
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

						$http.get(
								$stateParams.tenantid
										+ '/app/bookingAir/dropDownList')
								.success(function(datas) {
									debugger
									$scope.quotationList = datas.quotationList;

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
						.post(
								$stateParams.tenantid
										+ '/app/seaquotation/getServicePartnerList')
						.success(
								function(datas) {
									debugger
									 $scope.serviceParnrDropList=datas.serviceParnrList;

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
						$http.get($stateParams.tenantid+'/app/seaquotation/getcommodity').success(function(datas) {
							
						    $scope.commodityList = datas.commonUtilityBean;	    

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
					}

					$scope.dropdown();

					$scope.checkValidation = function() {

						var alertmsg = "<ui><h4>Please fill the required fields</h4>";
						var msg = "";
						if ($scope.checkundefined($scope.booking.customer)) {
							msg = msg + "<li>CUSTOMER :Field is required.</li>";
							$scope.changecolor('customer_id');
						} else {
							$scope.clearcolor('customer_id');
						}
						if ($scope.checkundefined($scope.booking.service)) {
							msg = msg + "<li>SERVICE :Field is required.</li>";
							$scope.changecolor('bk_srvc_id');
						} else {
							$scope.clearcolor('bk_srvc_id');
						}
						
						if ($scope.checkundefined($scope.booking.branch)) {							
							msg = msg + "BRANCH :Field is required.";							
							$scope.changecolor('brnch_id');						
							} else {							
								$scope.clearcolor('brnch_id');						
								}
						if ($scope.checkundefined($scope.booking.mode)) {							
							msg = msg + "MODE :Field is required.";							
							$scope.changecolor('bk_md_id');						
							} else {							
								$scope.clearcolor('bk_md_id');						
								}
						if ($scope.checkundefined($scope.booking.jobDate)) {							
							msg = msg + "Booking Date :Field is required.";							
							$scope.changecolor('bk_dt');						
							} else {							
								$scope.clearcolor('bk_dt');						
								}
						if ($scope.checkundefined($scope.booking.jobDate)) {							
							msg = msg + "Booking Date :Field is required.";							
							$scope.changecolor('bk_dt');						
							} else {							
								$scope.clearcolor('bk_dt');						
								}
						if ($scope.checkundefined($scope.booking.aol)) {							
							msg = msg + "POL :Field is required.";							
							$scope.changecolor('pol_id');						
							} else {							
								$scope.clearcolor('pol_id');						
								}
						if ($scope.checkundefined($scope.booking.aod)) {							
							msg = msg + "POD :Field is required.";							
							$scope.changecolor('pod_id');						
							} else {							
								$scope.clearcolor('pod_id');						
								}
						if ($scope.checkundefined($scope.booking.currency)) {							
							msg = msg + "CURRENCY :Field is required.";							
							$scope.changecolor('brnch_crrncy_id');						
							} else {							
								$scope.clearcolor('brnch_crrncy_id');						
								}
						if ($scope.checkundefined($scope.booking.term)) {							
							msg = msg + "TERM :Field is required.";							
							$scope.changecolor('trm_id');						
							} else {							
								$scope.clearcolor('trm_id');						
								}
						if ($scope.checkundefined($scope.booking.salesType)) {							
							msg = msg + "SALES TYPE :Field is required.";							
							$scope.changecolor('sls_typ_id');						
							} else {							
								$scope.clearcolor('sls_typ_id');						
								}

						if ($scope.checkundefined($scope.booking.validityDate)) {							
							msg = msg + "Validity Date :Field is required.";							
							$scope.changecolor('vldty_dt');						
							} else {							
								$scope.clearcolor('vldty_dt');						
								}
						
						angular.forEach($scope.booking.bookingDtl, function(chargesDetail,
								index) {
							debugger
							if ($scope.checkundefined(chargesDetail.chargeHead)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Charge Heads :Field is required.</li>";
								$scope.changecolor('chargeHeads' + index);
							} else {
								$scope.clearcolor('chargeHeads' + index);
							}
							if ($scope.checkundefined(chargesDetail.unit)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Unit :Field is required.</li>";
								$scope.changecolor('unit' + index);
							} else {
								$scope.clearcolor('unit' + index);
							}
							if ($scope.checkundefined(chargesDetail.currency)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Currency :Field is required.</li>";
								$scope.changecolor('currency' + index);
							} else {
								$scope.clearcolor('currency' + index);
							}
							if ($scope.checkundefined(chargesDetail.quantity)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Quantity :Field is required.</li>";
								$scope.changecolor('qty' + index);
								$('#qty' + index).find('input').css("border-color", "red");

							} else {
								$('#qty' + index).find('input').css("border-color", "#e8dddd");
							}
							if ($scope.checkundefined(chargesDetail.rate)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Rate :Field is required.</li>";
							}
							if ($scope.checkundefined(chargesDetail.paymentMode)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Payment Method :Field is required.</li>";
							}
							if ($scope.checkundefined(chargesDetail.transactionType)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Transaction Type :Field is required.</li>";
							}
							if ($scope.checkundefined(chargesDetail.buySellParty)) {
								msg = msg + "<li>Row :" + (index + 1)
										+ "# Buy Sell:Field is required.</li>";
							}
						

							

						});
						alertmsg = alertmsg + msg + "</ui>";
						if ($scope.checkundefined(msg)) {
							return '';
						} else {
							return alertmsg;
						}

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
												+ '/app/bookingAir/edit',
										$scope.jobId)
								.success(
										function(data) {
											debugger
											$scope.booking = data.lBookingBean[0];
											$scope.booking.service = data.lBookingBean[0].service
											.toString();
									
									if(data.lBookingBean[0].branch !=null && data.lBookingBean[0].branch != '')
									{
									$scope.booking.branch = data.lBookingBean[0].branch
											.toString();
									
									}
									if(data.lBookingBean[0].mode !=null && data.lBookingBean[0].mode != '')
										{
									$scope.booking.mode = data.lBookingBean[0].mode
											.toString();
										}
									
									if(data.lBookingBean[0].customsBroker !=null && data.lBookingBean[0].customsBroker != '')
									{
								$scope.booking.customsBroker = data.lBookingBean[0].customsBroker
										.toString();
									}
									
									
									if(data.lBookingBean[0].jobDate !=null && data.lBookingBean[0].jobDate != '')
									{
									$scope.booking.jobDate = data.lBookingBean[0].jobDate;
									}
									
									if(data.lBookingBean[0].aol !=null && data.lBookingBean[0].aol != '')
									{
									$scope.booking.aol = data.lBookingBean[0].aol
											.toString();
									}
									
									if(data.lBookingBean[0].aod !=null && data.lBookingBean[0].aod != '')
									{
									$scope.booking.aod = data.lBookingBean[0].aod
											.toString();
									}
									
									if(data.lBookingBean[0].term !=null && data.lBookingBean[0].term != '')
									{
									$scope.booking.term = data.lBookingBean[0].term
											.toString();
									}
									
									if(data.lBookingBean[0].origin !=null && data.lBookingBean[0].origin != '')
									{
									$scope.booking.origin = data.lBookingBean[0].origin
											.toString();
									}
									
									if(data.lBookingBean[0].destination !=null && data.lBookingBean[0].destination != '')
									{
									$scope.booking.destination = data.lBookingBean[0].destination
											.toString();
									}
									
									if(data.lBookingBean[0].customer !=null && data.lBookingBean[0].customer != '')
									{
									$scope.booking.customer = data.lBookingBean[0].customer
											.toString();
									}
									
									if(data.lBookingBean[0].shipper !=null && data.lBookingBean[0].shipper != '')
									{
									$scope.booking.shipper = data.lBookingBean[0].shipper
											.toString();
									}
									
									if(data.lBookingBean[0].consignee !=null && data.lBookingBean[0].consignee != '')
									{
									$scope.booking.consignee = data.lBookingBean[0].consignee
											.toString();
									}
									
									if(data.lBookingBean[0].nominatedBy !=null && data.lBookingBean[0].nominatedBy != '')
									{
									$scope.booking.nominatedBy = data.lBookingBean[0].nominatedBy
											.toString();
									}
									
									if(data.lBookingBean[0].vendor !=null && data.lBookingBean[0].vendor != '')
									{
									$scope.booking.vendor = data.lBookingBean[0].vendor
											.toString();
									}
									
									if(data.lBookingBean[0].currency !=null && data.lBookingBean[0].currency != '')
									{
									$scope.booking.currency = data.lBookingBean[0].currency
											.toString();
									}
									
									if(data.lBookingBean[0].quotationNo !=null && data.lBookingBean[0].quotationNo != '')
									{
									$scope.booking.quotationNo = data.lBookingBean[0].quotationNo
											.toString();
									}
									// $scope.booking.currency =
									// data.lBookingBean[0].currency;

									if(data.lBookingBean[0].salesType !=null && data.lBookingBean[0].salesType != '')
									{
									$scope.booking.salesType = data.lBookingBean[0].salesType
											.toString();
									}
								
									if(data.lBookingBean[0].jobStatus !=null && data.lBookingBean[0].jobStatus != '')
									{
									$scope.booking.jobStatus = data.lBookingBean[0].jobStatus
											.toString();
									}
									
									for (var i = 0; i < $scope.booking.bookingDtl.length; i++) {/*
										$scope.booking.bookingDtl[i].chargeHead = $scope.booking.bookingDtl[i].chargeHead
												.toString();
										$scope.booking.bookingDtl[i].unit = $scope.booking.bookingDtl[i].unit
												.toString();
										$scope.booking.bookingDtl[i].currency = $scope.booking.bookingDtl[i].currency
												.toString();
										$scope.booking.bookingDtl[i].paymentMode= $scope.booking.bookingDtl[i].paymentMode
												.toString();
										$scope.booking.bookingDtl[i].transactionType = $scope.booking.bookingDtl[i].transactionType
												.toString();
										$scope.booking.bookingDtl[i].buySellParty = $scope.booking.bookingDtl[i].buySellParty
											.toString();
									
									$scope.booking.bookingDtl[i].jobStatus1 = $scope.booking.bookingDtl[i].jobStatus1
									.toString();
									*/}
									$scope.booking.jobId=$scope.jobId;
										});

					}
					}
					
				$scope.edit();

					/*  
				       $scope.onSubmit = function(purchaseInvoiceForm,purchaseInvoiceData) {
				           console.log($scope.purchaseInvoiceData);
				           // $scope.purchaseInvoiceData.puchaseInvoiceDate =
							// $('#purchase_invoice_date').val();
				           $scope.purchaseInvoiceData.partyInvoiceDate = $('#party_invoice_date').val();
				           $scope.purchaseInvoiceData.dueDate = $('#txtDueDate').val();
				           
				           if (new validationService().checkFormValidity($scope.purchaseInvoiceForm)) {
				               $scope.save();
				           } else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary), 5000, 'trustedHtml');
				           }
				       };*/
				       
				       
					$scope.saveAirQuotation=function(bookingForm,booking){
						$scope.edit();
						var msg=$scope.checkValidation();
						if(!$scope.checkundefined(msg)){
							logger.logError(msg);
						}else{
						
						 /*if (new validationService().checkFormValidity($scope.bookingForm))
							 {*/
				        if($scope.booking.bookingDtl.length>0){
				        	
				        
							$http.post($stateParams.tenantid+'/app/bookingAir/saveQuote',$scope.booking).success(function(datas) {
								debugger
								  if(datas.success==true){
									
									  logger.logSuccess(datas.message);
									  $state.go('app.air.booking.list',{tenantid:$stateParams.tenantid});
								        

								  }else{
									  logger.logError(datas.message);
								  }
								}).error(function(data) {
									logger.logError("Please try again");
								});
				        }else{
				        	logger.logError("Atleast One Row Required");
				        }
						}
						/* else {
				               toaster.pop('error', "Please fill the required fields", 
				                       logger.getErrorHtmlNew($scope.bookingForm.$validationSummary), 5000, 'trustedHtml');
				           }*/
					//}
					
						
				}
					
					/*$scope.saveAirQuotation=function(){
						//$scope.edit();
						var msg=$scope.checkValidation();
						if(!$scope.checkundefined(msg)){
							logger.logError(msg);
						}else{
				        if($scope.booking.bookingDtl.length>0){
				        	
				        
							$http.post($stateParams.tenantid+'/app/bookingAir/saveQuote',$scope.booking).success(function(datas) {
								debugger
								  if(datas.success==true){
									  if ($scope.files.length > 0) {

					                        angular.forEach($scope.files, function(files, index) {
					                        	
					                        	
					                            var quotationNo = datas.code;
					                            
					                            var frmData = new FormData();
					                            frmData.append("file", files);
					                            frmData.append("quotationNo", quotationNo);
					                           
					                            $.ajax({
					                                type : "POST",
					                                url : $stateParams.tenantid+"/app/seaquotation/saveuploadfile",
					                                data : frmData,
					                                contentType : false,
					                                processData : false,
					                                success : function(result) {
					                                }
					                            });
					                            
					                        });

					                    }
									  logger.logSuccess(datas.message);
									  $state.go('app.air.booking.list',{tenantid:$stateParams.tenantid});
								        

								  }else{
									  logger.logError(datas.message);
								  }
								}).error(function(data) {
									logger.logError("Please try again");
								});
				        }else{
				        	logger.logError("Atleast One Row Required");
				        }
						}
						
						
					}
*/
					

					
					/*$scope.resetedit = function() {
						$scope.edit();
						
						$scope.booking.mode ='1';
						
					};*/

					$scope.cancel = function() {
						$state.go('app.air.booking.list', {
							tenantid : $stateParams.tenantid
						});
					}

					/*$scope
							.$watch(
									'booking.quotationNo',
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
																// $scope.booking
																// =
																// data.lQuotationBean[0];
																if(data.lQuotationBean[0].service != null && data.lQuotationBean[0].service != ""){
																	$scope.booking.service = data.lQuotationBean[0].service
																	.toString();	
																}
																if(data.lQuotationBean[0].branch != null && data.lQuotationBean[0].branch != ""){
			
																$scope.booking.branch = data.lQuotationBean[0].branch
																		.toString();
																}
																if(data.lQuotationBean[0].mode != null && data.lQuotationBean[0].mode != ""){
																$scope.booking.mode = data.lQuotationBean[0].mode
																		.toString();
																}
																if(data.lQuotationBean[0].aol != null && data.lQuotationBean[0].aol != ""){
																$scope.booking.aol = data.lQuotationBean[0].aol
																		.toString();
																}
																if(data.lQuotationBean[0].aod != null && data.lQuotationBean[0].aod != ""){
																$scope.booking.aod = data.lQuotationBean[0].aod
																		.toString();
																}
																var jobId = parseInt($location.search().rowid);if(data.lQuotationBean[0].term != null && data.lQuotationBean[0].term != ""){

																$scope.booking.term = data.lQuotationBean[0].term
																.toString();
																}
																if(data.lQuotationBean[0].origin != null && data.lQuotationBean[0].origin != ""){
																$scope.booking.origin = data.lQuotationBean[0].origin
																		.toString();
																}
																if(data.lQuotationBean[0].destination != null && data.lQuotationBean[0].destination != ""){
																$scope.booking.destination = data.lQuotationBean[0].destination
																		.toString();
																}
																if(data.lQuotationBean[0].customer != null && data.lQuotationBean[0].customer != ""){
																$scope.booking.customer = data.lQuotationBean[0].customer
																		.toString();
																}
																if(data.lQuotationBean[0].shipper != null && data.lQuotationBean[0].shipper != ""){
																$scope.booking.shipper = data.lQuotationBean[0].shipper
																		.toString();
																}
																if(data.lQuotationBean[0].consignee != null && data.lQuotationBean[0].consignee != ""){
																$scope.booking.consignee = data.lQuotationBean[0].consignee
																		.toString();
																}
																
																if (data.lQuotationBean[0].nominatedBy != null
																		&& data.lQuotationBean[0].nominatedBy != '') {
																	$scope.booking.nominatedBy = data.lQuotationBean[0].nominatedBy
																			.toString();
																}
																if (data.lQuotationBean[0].vendor != null
																		&& data.lQuotationBean[0].vendor != '') {
																	$scope.booking.vendor = data.lQuotationBean[0].vendor
																			.toString();
																}
																if (data.lQuotationBean[0].currency != null
																		&& data.lQuotationBean[0].currency != '') {
																	$scope.booking.currency = data.lQuotationBean[0].currency
																			.toString();
																}
																if (data.lQuotationBean[0].salesType != null
																		&& data.lQuotationBean[0].salesType != '') {
																	$scope.booking.salesType = data.lQuotationBean[0].salesType
																			.toString();
																}

																for (var i = 0; i < data.lQuotationBean[0].quotationDtl.length; i++) {
																	$scope.booking.bookingDtl[i].chargeHeads = data.lQuotationBean[0].quotationDtl[i].chargeHeads
																			.toString();
																	$scope.booking.bookingDtl[i].unit = data.lQuotationBean[0].quotationDtl[i].unit
																			.toString();
																	$scope.booking.bookingDtl[i].currency = data.lQuotationBean[0].quotationDtl[i].currency
																			.toString();
																	$scope.booking.bookingDtl[i].paymentMethod = data.lQuotationBean[0].quotationDtl[i].paymentMethod
																			.toString();
																	$scope.booking.bookingDtl[i].transactionType = data.lQuotationBean[0].quotationDtl[i].transactionType
																			.toString();
																	$scope.booking.bookingDtl[i].buySell = data.lQuotationBean[0].quotationDtl[i].buySell
																			.toString();
																}

															});
										}
									})*/

					/*var jobId = parseInt($location.search().rowid);
									$scope.printRoutingOrder = function(){
				        debugger	
				        
				        
				        var url = $stateParams.tenantid+'/app/bookingSea/printRoutingOrder1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					$scope.jobSheet = function(jobId){
				        debugger
				        var url = $stateParams.tenantid+'/app/bookingSea/jobDetailOrder1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					
					$scope.printPrealertAir= function(jobId){
				        debugger
				        
				        var url = $stateParams.tenantid+'/app/bookingSea/printPreAlert1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }*/
					/*var jobId = $location.search().jobId;

					if (jobId != null && jobId != undefined) {
						var jobId = parseInt($location.search().rowid);
						$http
								.post(
										$stateParams.tenantid
												+ '/app/bookingAir/edit',
										jobId).success(function(data) {
								});

					}*/

					$scope.updateJob = function() {
						console.log($scope.booking);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							$http.post(
									$stateParams.tenantid
											+ '/app/bookingAir/update',
									$scope.booking).success(function(datas) {
								debugger
								if (datas.success == true) {
									logger.logSuccess(datas.message);
									$state.go('app.air.booking.list', {
										tenantid : $stateParams.tenantid
									});

								} else {
									logger.logError(datas.message);
								}
							}).error(function(data) {
								logger.logError("Please try again");
							});
						}

					}

				});

app
		.controller(
				'bookingViewCtrl',
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
					$scope.bookingDtlList = [];
					$scope.tempType = '';
					debugger;
					$scope.booking = {
						service : '',
						jobDate : '',
						branch : '',
						customer : '',
						shipper : '',
						consignee : '',
						term : '',
						aol : '',
						workOrderNo : '',
						aod : '',
						origin : '',
						destination : '',
						commodity : '',
						jobStatus : '',
						currency : '',
						quotationNo : '',
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
						bookingDtl : [ {
							bookingDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '',
							quantity : '',
							rate : '',
							currency : '',
							exRate : '',
							amount : '0',
							paymentMode : '',
							buySellParty : '',
							status : ''
						} ]
					}

					/* $scope.bookingDtl = {} */

					// $scope.isQuot=false;
					var jobId = parseInt($location.search().rowid);

					$scope.ratevalues1 = function() {
						if ($scope.booking.bookingDtl.length != null
								|| $scope.booking.bookingDtl.length != undefined
								|| $scope.booking.bookingDtl.length != ""
								|| $scope.booking.bookingDtl.length != '') {
							for (var i = 0; i <= $scope.booking.bookingDtl.length - 1; i++) {
								if (($scope.booking.bookingDtl[i].transactionType != null)
										|| ($scope.booking.bookingDtl[i].transactionType != undefined)
										|| ($scope.booking.bookingDtl[i].transactionType != "")
										|| ($scope.booking.bookingDtl[i].transactionType != '')) {
									if ($scope.booking.bookingDtl[i].transactionType == "1") {
										buy1 = parseInt(buy1)
												+ parseInt($scope.booking.bookingDtl[i].amount);
										console.log("i:" + i + " buy1:" + buy1);
									} else {
										if ($scope.booking.bookingDtl[i].transactionType == "2") {
											sell1 = parseInt(sell1)
													+ parseInt($scope.booking.bookingDtl[i].amount);

										}
									}
								}
							}
							total = parseInt(buy1) - parseInt(sell1);

							console.log("total" + total + " sell1:" + sell1);
						}

						$scope.booking.sell1 = sell1;
						$scope.booking.buy1 = buy1;
						$scope.booking.total = total;
					}

					$scope.ratevalues = function() {
						var buy1 = 0;
						var sell = 0;
						var sell1 = 0;
						var amount = 0;

						var total = 0;
						if ($scope.booking.bookingDtl.length != null
								|| $scope.booking.bookingDtl.length != undefined
								|| $scope.booking.bookingDtl.length != ""
								|| $scope.booking.bookingDtl.length != '') {
							{
								for (var i = 0; i <= $scope.booking.bookingDtl.length - 1; i++) {

									var amount1 = [];
									var amount = [];
									if (($scope.booking.bookingDtl[i].transactionType != null)
											|| ($scope.booking.bookingDtl[i].transactionType != undefined)
											|| ($scope.booking.bookingDtl[i].transactionType != "")
											|| ($scope.booking.bookingDtl[i].transactionType != '')) {
										if ($scope.booking.bookingDtl[i].transactionType == "1") {

											if (($scope.booking.bookingDtl[i].quantity != null
													|| $scope.booking.bookingDtl[i].quantity != undefined
													|| $scope.booking.bookingDtl[i].quantity != "" || $scope.booking.bookingDtl[i].quantity != '')
													&& ($scope.booking.bookingDtl[i].rate != null
															|| $scope.booking.bookingDtl[i].rate != undefined
															|| $scope.booking.bookingDtl[i].rate != " " || $scope.booking.bookingDtl[i].rate != '')
													&& ($scope.booking.bookingDtl[i].exRate != null
															|| $scope.booking.bookingDtl[i].exRate == undefined
															|| $scope.booking.bookingDtl[i].exRate != "" || $scope.booking.bookingDtl[i].exRate != '')) {
												amount1[i] = (parseInt(($scope.booking.bookingDtl[i].quantity))
														* parseInt(($scope.booking.bookingDtl[i].rate)) * parseInt(($scope.booking.bookingDtl[i].exRate)));
												$scope.booking.bookingDtl[i].amount = parseInt(amount1[i]);

												buy1 = parseInt(buy1)
														+ parseInt($scope.booking.bookingDtl[i].amount);
												console.log("i:" + i + " buy1:"
														+ buy1);

											}
										}

										else {
											if ($scope.booking.bookingDtl[i].transactionType == "2") {

												if (($scope.booking.bookingDtl[i].quantity != null
														|| $scope.booking.bookingDtl[i].quantity != undefined
														|| $scope.booking.bookingDtl[i].quantity != "" || $scope.booking.bookingDtl[i].quantity != '')
														&& ($scope.booking.bookingDtl[i].rate != null
																|| $scope.booking.bookingDtl[i].rate != undefined
																|| $scope.booking.bookingDtl[i].rate != " " || $scope.booking.bookingDtl[i].rate != '')
														&& ($scope.booking.bookingDtl[i].exRate != null
																|| $scope.booking.bookingDtl[i].exRate == undefined
																|| $scope.booking.bookingDtl[i].exRate != "" || $scope.booking.bookingDtl[i].exRate != '')) {
													amount1[i] = (parseInt(($scope.booking.bookingDtl[i].quantity))
															* parseInt(($scope.booking.bookingDtl[i].rate)) * parseInt(($scope.booking.bookingDtl[i].exRate)));
													$scope.booking.bookingDtl[i].amount = parseInt(amount1[i]);

													sell1 = parseInt(sell1)
															+ parseInt($scope.booking.bookingDtl[i].amount);
													console
															.log("i:" + i
																	+ " sell1:"
																	+ sell1);
												}
											}
										}

									}

									$scope.booking.bookingDtl[i].amount = parseInt(amount1[i]);

								}
								total = parseInt(buy1) - parseInt(sell1);

								console
										.log("total" + total + " sell1:"
												+ sell1);

							}
						}
						$scope.booking.sell1 = sell1;
						$scope.booking.buy1 = buy1;
						$scope.booking.total = total;

					}
					
					$scope.modeList = [];
					$scope.modeType = function() {
						var data = {};
						data["id"] = "2";
						data["text"] = "AIR";
						$scope.modeList.push(data);
						$scope.booking.mode = $scope.modeList[0].id

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
						data["text"] = "OPEN";
						$scope.jobStatusList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "CLOSED";
						$scope.jobStatusList.push(data);

					}
					$scope.getjobStatus();

					$scope.PaymentMethodList = [];
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
						data["text"] = "CLOSED";
						$scope.jobDetailStatusList.push(data);

					}
					$scope.getjobStatus();

					// $scope.getQuotationType();
					$scope.dropdown = function() {
						debugger;
						$http
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
												+ '/app/airquotation/getServicePartnerType')
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

						$http.get(
								$stateParams.tenantid
										+ '/app/bookingAir/dropDownList')
								.success(function(datas) {
									debugger
									$scope.quotationList = datas.quotationList;

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

								});
					}

					$scope.dropdown();

					$scope.checkValidation = function() {

						var alertmsg = "<ui><h4>Please fill the required fields</h4>";
						var msg = "";
						if ($scope.checkundefined($scope.booking.customer)) {
							msg = msg + "<li>CUSTOMER :Field is required.</li>";
							$scope.changecolor('customer_id');
						} else {
							$scope.clearcolor('customer_id');
						}

						angular
								.forEach(
										$scope.booking.bookingDtl,
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
												$scope.changecolor('qty'
														+ index);
												$('#qty' + index).find('input')
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
											}
											if ($scope
													.checkundefined(chargesDetail.paymentMode)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Payment Method :Field is required.</li>";
											}
											if ($scope
													.checkundefined(chargesDetail.transactionType)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
											}
											if ($scope
													.checkundefined(chargesDetail.buySellParty)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Buy Sell:Field is required.</li>";
											}
											if ($scope
													.checkundefined(chargesDetail.amount)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Amount:Field is required.</li>";
											}

											if ($scope
													.checkundefined(chargesDetail.exRate)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Exchange Rate:Field is required.</li>";
											}

											if ($scope
													.checkundefined(chargesDetail.transactionType)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
											}

											if ($scope
													.checkundefined(chargesDetail.status)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Status :Field is required.</li>";
											}

											$scope.print = function(rowid) {
												rowid = 1201;
												var test = parseInt(rowid);
												var url = $stateParams.tenantid
														+ '/app/bookingAir/print?rowid='
														+ rowid
												var wnd = window
														.open(
																url,
																'HISERP',
																'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
												wnd.print();

											};

											$scope.print1 = function(rowid) {
												rowid = 4852;
												var test = parseInt(rowid);
												var url = $stateParams.tenantid
														+ '/app/bookingAir/print1?rowid='
														+ rowid
												var wnd = window
														.open(
																url,
																'HISERP',
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
												+ '/app/bookingAir/edit',
										jobId)
								.success(
										function(data) {
											debugger
											$scope.booking = data.lBookingBean[0];
											$scope.booking.service = data.lBookingBean[0].service
													.toString();
											if(data.lBookingBean[0].branch !=null && data.lBookingBean[0].branch != '')
											{
											$scope.booking.branch = data.lBookingBean[0].branch
													.toString();
											
											}
											if(data.lBookingBean[0].mode !=null && data.lBookingBean[0].mode != '')
												{
											$scope.booking.mode = data.lBookingBean[0].mode
													.toString();
												}
											
											if(data.lBookingBean[0].jobDate !=null && data.lBookingBean[0].jobDate != '')
											{
											$scope.booking.jobDate = data.lBookingBean[0].jobDate;
											}
											
											if(data.lBookingBean[0].aol !=null && data.lBookingBean[0].aol != '')
											{
											$scope.booking.aol = data.lBookingBean[0].aol
													.toString();
											}
											
											if(data.lBookingBean[0].aod !=null && data.lBookingBean[0].aod != '')
											{
											$scope.booking.aod = data.lBookingBean[0].aod
													.toString();
											}
											
											if(data.lBookingBean[0].term !=null && data.lBookingBean[0].term != '')
											{
											$scope.booking.term = data.lBookingBean[0].term
													.toString();
											}
											
											if(data.lBookingBean[0].origin !=null && data.lBookingBean[0].origin != '')
											{
											$scope.booking.origin = data.lBookingBean[0].origin
													.toString();
											}
											
											if(data.lBookingBean[0].destination !=null && data.lBookingBean[0].destination != '')
											{
											$scope.booking.destination = data.lBookingBean[0].destination
													.toString();
											}
											
											if(data.lBookingBean[0].customer !=null && data.lBookingBean[0].customer != '')
											{
											$scope.booking.customer = data.lBookingBean[0].customer
													.toString();
											}
											
											if(data.lBookingBean[0].shipper !=null && data.lBookingBean[0].shipper != '')
											{
											$scope.booking.shipper = data.lBookingBean[0].shipper
													.toString();
											}
											
											if(data.lBookingBean[0].consignee !=null && data.lBookingBean[0].consignee != '')
											{
											$scope.booking.consignee = data.lBookingBean[0].consignee
													.toString();
											}
											
											if(data.lBookingBean[0].nominatedBy !=null && data.lBookingBean[0].nominatedBy != '')
											{
											$scope.booking.nominatedBy = data.lBookingBean[0].nominatedBy
													.toString();
											}
											
											if(data.lBookingBean[0].vendor !=null && data.lBookingBean[0].vendor != '')
											{
											$scope.booking.vendor = data.lBookingBean[0].vendor
													.toString();
											}
											
											if(data.lBookingBean[0].currency !=null && data.lBookingBean[0].currency != '')
											{
											$scope.booking.currency = data.lBookingBean[0].currency
													.toString();
											}
											
											if(data.lBookingBean[0].customsBroker !=null && data.lBookingBean[0].customsBroker != '')
											{
											$scope.booking.customsBroker = data.lBookingBean[0].customsBroker
													.toString();
											}
											
											if(data.lBookingBean[0].quotationNo !=null && data.lBookingBean[0].quotationNo != '')
											{
											$scope.booking.quotationNo = data.lBookingBean[0].quotationNo
													.toString();
											}
											// $scope.booking.currency =
											// data.lBookingBean[0].currency;

											if(data.lBookingBean[0].salesType !=null && data.lBookingBean[0].salesType != '')
											{
											$scope.booking.salesType = data.lBookingBean[0].salesType
													.toString();
											}

											for (var i = 0; i < $scope.booking.bookingDtl.length; i++) {
												$scope.booking.bookingDtl[i].chargeHead = $scope.booking.bookingDtl[i].chargeHead
														.toString();
												$scope.booking.bookingDtl[i].unit = $scope.booking.bookingDtl[i].unit
														.toString();
												$scope.booking.bookingDtl[i].currency = $scope.booking.bookingDtl[i].currency
														.toString();
												$scope.booking.bookingDtl[i].paymentMode = $scope.booking.bookingDtl[i].paymentMode
														.toString();
												$scope.booking.bookingDtl[i].transactionType = $scope.booking.bookingDtl[i].transactionType
														.toString();
												$scope.booking.bookingDtl[i].buySellParty = $scope.booking.bookingDtl[i].buySellParty
														.toString();
												$scope.booking.bookingDtl[i].amount = $scope.booking.bookingDtl[i].amount;
												$scope.booking.bookingDtl[i].rate = $scope.booking.bookingDtl[i].rate;

												$scope.booking.bookingDtl[i].status = $scope.booking.bookingDtl[i].status
														.toString();
												$scope.booking.bookingDtl[i].exRate = $scope.booking.bookingDtl[i].exRate;

											}

										});

					}
					

					$scope.addRow = function() {
						var bookingDtl = {
							bookingDtlId : '',
							chargeHead : '',
							unit : '',
							transactionType : '',
							quantity : '',
							rate : '',
							currency : '',
							exRate : '',
							amount : '0',
							paymentMode : '',
							buySellParty : '',
							status : ''
						}
						$scope.booking.bookingDtl.push(bookingDtl);
					};

					$scope.deleteIds = [];
					$scope.removeRow = function() {
						var len = $scope.booking.bookingDtl.length;
						for (var index = len - 1; index < len; index--) {
							if ($scope.booking.bookingDtl[index].select == true) {
								if ($scope.booking.bookingDtl[index].bookingDtlId != null
										&& $scope.booking.bookingDtl[index].bookingDtlId > 0) {
									$scope.deleteIds
											.push($scope.booking.bookingDtl[index].bookingDtlId);
								}
								$scope.booking.bookingDtl.splice(index, 1);
							}
						}
					};

					$scope.hdrData = $scope.booking;
					$scope.dtlData = $scope.bookingDtl;
					$scope.reset = function() {
						$scope.booking = $scope.hdrData;
						$scope.bookingDtl = $scope.dtlData;
					};

					$scope.cancel = function() {
						$state.go('app.air.booking.list', {
							tenantid : $stateParams.tenantid
						});
					}

					var jobId = $location.search().jobId;

					if (jobId != null && jobId != undefined) {

						$http
								.post(
										$stateParams.tenantid
												+ '/app/bookingAir/edit',
										jobId)
								.success(
										function(data) {
											debugger
											$scope.booking = data.lBookingBean[0];
											$scope.booking.service = data.lBookingBean[0].service
													.toString();
											if(data.lBookingBean[0].branch !=null && data.lBookingBean[0].branch != '')
											{
											$scope.booking.branch = data.lBookingBean[0].branch
													.toString();
											
											}
											if(data.lBookingBean[0].mode !=null && data.lBookingBean[0].mode != '')
												{
											$scope.booking.mode = data.lBookingBean[0].mode
													.toString();
												}
											
											if(data.lBookingBean[0].jobDate !=null && data.lBookingBean[0].jobDate != '')
											{
											$scope.booking.jobDate = data.lBookingBean[0].jobDate;
											}
											
											if(data.lBookingBean[0].aol !=null && data.lBookingBean[0].aol != '')
											{
											$scope.booking.aol = data.lBookingBean[0].aol
													.toString();
											}
											
											if(data.lBookingBean[0].aod !=null && data.lBookingBean[0].aod != '')
											{
											$scope.booking.aod = data.lBookingBean[0].aod
													.toString();
											}
											
											if(data.lBookingBean[0].term !=null && data.lBookingBean[0].term != '')
											{
											$scope.booking.term = data.lBookingBean[0].term
													.toString();
											}
											
											if(data.lBookingBean[0].origin !=null && data.lBookingBean[0].origin != '')
											{
											$scope.booking.origin = data.lBookingBean[0].origin
													.toString();
											}
											
											if(data.lBookingBean[0].destination !=null && data.lBookingBean[0].destination != '')
											{
											$scope.booking.destination = data.lBookingBean[0].destination
													.toString();
											}
											
											if(data.lBookingBean[0].customer !=null && data.lBookingBean[0].customer != '')
											{
											$scope.booking.customer = data.lBookingBean[0].customer
													.toString();
											}
											
											if(data.lBookingBean[0].shipper !=null && data.lBookingBean[0].shipper != '')
											{
											$scope.booking.shipper = data.lBookingBean[0].shipper
													.toString();
											}
											
											if(data.lBookingBean[0].consignee !=null && data.lBookingBean[0].consignee != '')
											{
											$scope.booking.consignee = data.lBookingBean[0].consignee
													.toString();
											}
											
											if(data.lBookingBean[0].nominatedBy !=null && data.lBookingBean[0].nominatedBy != '')
											{
											$scope.booking.nominatedBy = data.lBookingBean[0].nominatedBy
													.toString();
											}
											
											if(data.lBookingBean[0].vendor !=null && data.lBookingBean[0].vendor != '')
											{
											$scope.booking.vendor = data.lBookingBean[0].vendor
													.toString();
											}
											
											if(data.lBookingBean[0].currency !=null && data.lBookingBean[0].currency != '')
											{
											$scope.booking.currency = data.lBookingBean[0].currency
													.toString();
											}
											
											if(data.lBookingBean[0].customsBroker !=null && data.lBookingBean[0].customsBroker != '')
											{
											$scope.booking.customsBroker = data.lBookingBean[0].customsBroker
													.toString();
											}
											
											if(data.lBookingBean[0].quotationNo !=null && data.lBookingBean[0].quotationNo != '')
											{
											$scope.booking.quotationNo = data.lBookingBean[0].quotationNo
													.toString();
											}
											// $scope.booking.currency =
											// data.lBookingBean[0].currency;

											if(data.lBookingBean[0].salesType !=null && data.lBookingBean[0].salesType != '')
											{
											$scope.booking.salesType = data.lBookingBean[0].salesType
													.toString();
											}

											for (var i = 0; i < $scope.booking.bookingDtl.length; i++) {
												$scope.booking.bookingDtl[i].chargeHead = $scope.booking.bookingDtl[i].chargeHead
														.toString();
												$scope.booking.bookingDtl[i].unit = $scope.booking.bookingDtl[i].unit
														.toString();
												$scope.booking.bookingDtl[i].currency = $scope.booking.bookingDtl[i].currency
														.toString();
												$scope.booking.bookingDtl[i].paymentMode = $scope.booking.bookingDtl[i].paymentMode
														.toString();
												$scope.booking.bookingDtl[i].transactionType = $scope.booking.bookingDtl[i].transactionType
														.toString();
												$scope.booking.bookingDtl[i].buySellParty = $scope.booking.bookingDtl[i].buySellParty
														.toString();
												$scope.booking.bookingDtl[i].amount = $scope.booking.bookingDtl[i].amount;
												$scope.booking.bookingDtl[i].rate = $scope.booking.bookingDtl[i].rate;

												$scope.booking.bookingDtl[i].status = $scope.booking.bookingDtl[i].status
														.toString();
												$scope.booking.bookingDtl[i].exRate = $scope.booking.bookingDtl[i].exRate;

											}

										});

				}
					$scope.printRoutingOrder = function(){
				        debugger
				        var url = $stateParams.tenantid+'/app/bookingSea/printRoutingOrder1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					
					
					$scope.printPrealertAir= function(jobId){
				        debugger
				        var url = $stateParams.tenantid+'/app/bookingSea/printPreAlert1?jobId=' + jobId;
				        var wnd = $window.open(url, 'Athena', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
				        wnd.print();   
				     }
					$scope.booking.jobId=jobId;
					$scope.updateJob = function() {
						console.log($scope.booking);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							$http.post(
									$stateParams.tenantid
											+ '/app/bookingAir/update',
									$scope.booking).success(function(datas) {
								debugger
								if (datas.success == true) {
									logger.logSuccess(datas.message);
									$state.go('app.air.booking.list', {
										tenantid : $stateParams.tenantid
									});

								} else {
									logger.logError(datas.message);
								}
							}).error(function(data) {
								logger.logError("Please try again");
							});
						}

					}

				});
