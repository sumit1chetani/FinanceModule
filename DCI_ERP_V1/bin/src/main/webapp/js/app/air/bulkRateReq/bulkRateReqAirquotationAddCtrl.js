'use strict';
app.controller('bulkRateReqAirquotationAddCtrl', function($scope, $timeout, $stateParams,
		sharedProperties, toaster, $filter, $rootScope, $http, $location,
		logger, $state, ngDialog, $controller, $injector) {
	$scope.quotationTypeList = [];
	$scope.customerList = [];
	$scope.portList = [];
	$scope.currencyList = [];
	$scope.createQuote = false;

	var bookingDate = $stateParams.bookingDate;
	var mloCode = $stateParams.mloCode;
	var lolId = $stateParams.lolId;
	var lodId = $stateParams.lodId;
	var bookingId = parseInt($stateParams.bookingId);

	$scope.quotation = {
		service : '',
		aol : '',
		origin : '',
		customer : '',
		salesPerson : '',
		vendor : '',
		flightNo : '',
		attention : '',
		quotationDate : '',
		branch : '',
		aod : '',
		destination : '',
		shipper : '',
		salesType : '',
		carrier : '',
		flightDate : '',
		termConditions : '',
		mode : '',
		currency : '',
		term : '',
		commodity : '',
		consignee : '',
		nominatedBy : '',
		validityDate : '',
		remarks : '',
		quotationDtl : [ {
			id : 0,
			chargeHeads : '',
			unit : '',
			currency : '',
			qty : '',
			rate : '',
			paymentMethod : '',
			transactionType : '',
			buySell : '',
			note : ''
		} ]
	}

	$scope.checkundefined = function(value) {
		var invalid = false;
		if (value == undefined || value == 'undefined' || value == null
				|| value == 'null' || value == '') {
			invalid = true;
		}
		return invalid;

	}

	$scope.addslab = function(row, index) {
		$scope.max = Math.max.apply(Math, row.weightslab.map(function(item) {
			return item.wid;
		}));
		var len = row.weightslab.length - 1;
		$scope.max = $scope.max + 1;
		var json = {
			wid : $scope.max,
			fromweight : row.weightslab[len].toweight + 1,
			toweight : row.weightslab[len].toweight + 2,
			charges : []
		}
		row.weightslab.push(json);
		len = row.weightslab.length - 1;
		$timeout(function() {
			hideActivePapers(row.id + "" + $scope.max, []);
		}, 1000);
	}
	$scope.addRow = function() {

		$scope.max = Math.max.apply(Math, $scope.quotation.quotationDtl
				.map(function(item) {
					return item.id;
				}));
		$scope.max = $scope.max + 1;
		var chargedata = {
			id : $scope.max,
			chargeHeads : '',
			unit : '',
			currency : '',
			qty : '',
			rate : '',
			currencyList : angular.copy($scope.currencylist),
			paymentMethod : '',
			transactionType : '',
			buySell : '',
			note : ''
		};

		$scope.quotation.quotationDtl.push(chargedata);
		var len = $scope.quotation.quotationDtl.length - 1;
		$timeout(function() {
			hideActivePapers($scope.max + "0", []);
		}, 1000);
	}
	$scope.removeRow = function() {
		$scope.tablerow = [];
		angular.forEach($scope.quotation.quotationDtl, function(row, index) {
			var check = row.select;
			console.log(index);
			if (check == undefined || check == "") {
				$scope.tablerow.push(row);
			} else {

			}
		});
		$scope.quotation.quotationDtl = $scope.tablerow;
	};

	$scope.doubleshowTable = function(wtIndex, trIndex) {

		var n = $("#handsondiv" + trIndex + wtIndex).css("display");

		if (n == 'none') {
			$("#handsondiv" + trIndex + wtIndex).css("display", "block");
			$scope.addindex = trIndex + "" + wtIndex;
		} else if (n == 'block') {
			$("#handsondiv" + trIndex + wtIndex).css("display", "none");

		}

	}

	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1;

	var yyyy = today.getFullYear();
	if (dd < 10) {
		dd = '0' + dd
	}
	if (mm < 10) {
		mm = '0' + mm
	}
	var today = dd + '/' + mm + '/' + yyyy;
	$scope.quotation.dataOfIssues = today;
	$scope.modeList = [];
	$scope.getQuotationType = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "AIR";
		$scope.modeList.push(data);
		// data = {};
		// data["id"] = "2";
		// data["text"] = "SEA";
		// $scope.modeList.push(data);
	}

	$scope.salesTypeList = [];
	$scope.getSalesType = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "CROSS TRADE";
		$scope.salesTypeList.push(data);
		data = {};
		data["id"] = "2";
		data["text"] = "LOCAL";
		$scope.salesTypeList.push(data);
		data = {};
		data["id"] = "3";
		data["text"] = "NOMINATED";
		$scope.salesTypeList.push(data);

	}
	$scope.getSalesType();
	$scope.transactionTypeList = [];

	$scope.getTransactionType = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "BUY";
		$scope.transactionTypeList.push(data);
		data = {};
		data["id"] = "2";
		data["text"] = "SELL";
		$scope.transactionTypeList.push(data);

	}
	$scope.getTransactionType();

	$scope.PaymentMethodList = [];
	$scope.getpaymentMethod = function() {
		var data = {};
		data["id"] = "1";
		data["text"] = "PREAPID TO COLLECT";
		$scope.PaymentMethodList.push(data);
		// data = {};
		// data["id"] = "2";
		// data["text"] = "SELL";
		// $scope.PaymentMethodList.push(data);

	}
	$scope.getpaymentMethod();

	$scope.chargeList = [];
	$scope.dropdown = function() {
		$scope.getQuotationType();
		$http.post(
				$stateParams.tenantid + '/app/bulkRateReqAirquotation/getServicePartner')
				.success(function(datas) {
					debugger
					$scope.customerList = datas.commonUtilityBean;

				}).error(function(data) {

				});
		$http.get($stateParams.tenantid + '/app/bulkRateReqAirquotation/getiataList')
				.success(function(datas) {
					debugger
					$scope.portList = datas.commonUtilityBean;

				}).error(function(data) {

				});
		$http.get($stateParams.tenantid + '/app/bulkRateReqAirquotation/getBranch')
				.success(function(datas) {
					$scope.branchList = datas.commonUtilityBean;

				}).error(function(data) {

				});
		$http.get($stateParams.tenantid + '/app/airquotation/getCurrencyList')
				.success(
						function(datas) {
							$scope.currencylist = angular
									.copy(datas.commonUtilityBean);
						}).error(function(data) {

				});

		$http.get(
				$stateParams.tenantid
						+ '/app/bulkRateReqAirquotation/getServicePartnerType').success(
				function(datas) {
					$scope.servicePartnerTypelist = angular
							.copy(datas.commonUtilityBean);
				}).error(function(data) {

		});

		$http.get($stateParams.tenantid + '/app/bulkRateReqAirquotation/getEmployeeList')
				.success(function(datas) {
					$scope.employeeList = datas.commonUtilityBean;

				}).error(function(data) {

				});

		$http.get($stateParams.tenantid + '/app/bulkRateReqAirquotation/getChargeHeads')
				.success(function(datas) {
					$scope.chargeHeadList = datas.commonUtilityBean;

				}).error(function(data) {

				});

		$http.get($stateParams.tenantid + '/app/bulkRateReqAirquotation/getTerms')
				.success(function(datas) {
					$scope.TermList = datas.commonUtilityBean;

				}).error(function(data) {

				});

		$http.get($stateParams.tenantid + '/app/seaquotation/getUnitList')
				.success(function(datas) {
					debugger
					$scope.UnitList = datas.commonUtilityBean;

				}).error(function(data) {

				});

	}
	$scope.editdata = function(quotation) {

		$scope.getQuotationType();
		$http.post(
				$stateParams.tenantid + '/app/bulkRateReqAirquotation/getServicePartner')
				.success(function(datas) {
					debugger
					$scope.customerList = datas.commonUtilityBean;

				}).error(function(data) {

				});
	}

	$scope.edit = false;
	if (!$scope.checkundefined($location.search().quotation)) {
		$scope.editdata($location.search().quotation);
		$scope.edit = true;

	} else {
		$scope.edit = false;
		$scope.dropdown();
	}

	$scope.changecolor = function(id) {
		$('#' + id + ' .selectivityId').find('input')
				.css("border-color", "red");
		;

	}
	$scope.clearcolor = function(id) {
		$('#' + id + ' .selectivityId').find('input').css("border-color",
				"#e8dddd");
		;

	}

	$scope.checkValidation = function() {

		var alertmsg = "<ui><h4>Please fill the required fields</h4>";
		var msg = "";
		if ($scope.checkundefined($scope.quotation.customer)) {
			msg = msg + "<li>CUSTOMER :Field is required.</li>";
			$scope.changecolor('customer_id');
		} else {
			$scope.clearcolor('customer_id');
		}

		angular.forEach($scope.quotation.quotationDtl, function(chargesDetail,
				index) {
			if ($scope.checkundefined(chargesDetail.chargeHeads)) {
				msg = msg + "<li>Row :" + (index + 1)
						+ "# Charge Heads :Field is required.</li>";
				$scope.changecolor('chargeHeads' + index);
			} else {
				$scope.clearcolor('chargeHeads' + index);
			}
			if ($scope.checkundefined(chargesDetail.unit)) {
				msg = msg + "<li>Row :" + (index + 1)
						+ "# LOD :Field is required.</li>";
				$scope.changecolor('unit' + index);
			} else {
				$scope.clearcolor('unit' + index);
			}
			if ($scope.checkundefined(chargesDetail.currency)) {
				msg = msg + "<li>Row :" + (index + 1)
						+ "# CURRENCY :Field is required.</li>";
				$scope.changecolor('currency' + index);
			} else {
				$scope.clearcolor('currency' + index);
			}
			if ($scope.checkundefined(chargesDetail.qty)) {
				msg = msg + "<li>Row :" + (index + 1)
						+ "# VALID FROM :Field is required.</li>";
				$scope.changecolor('qty' + index);
				$('#qty' + index).find('input').css("border-color", "red");

			} else {
				$('#qty' + index).find('input').css("border-color", "#e8dddd");
			}
			if ($scope.checkundefined(chargesDetail.rate)) {
				msg = msg + "<li>Row :" + (index + 1)
						+ "# Rate :Field is required.</li>";
			}
			if ($scope.checkundefined(chargesDetail.paymentMethod)) {
				msg = msg + "<li>Row :" + (index + 1)
						+ "# Payment Method :Field is required.</li>";
			}
			if ($scope.checkundefined(chargesDetail.currency)) {
				msg = msg + "<li>Row :" + (index + 1)
						+ "# Currency :Field is required.</li>";
			}
			if ($scope.checkundefined(chargesDetail.transactionType)) {
				msg = msg + "<li>Row :" + (index + 1)
						+ "# Transaction Type :Field is required.</li>";
			}
			if ($scope.checkundefined(chargesDetail.buySell)) {
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
	$scope.submit = function() {
		console.log($scope.quotation);
		var msg = $scope.checkValidation();
		if (!$scope.checkundefined(msg)) {
			logger.logError(msg);
		} else {
			// if($scope.createQuote){
			// $scope.quotation.createQuoteByBooking = true;
			// }
			// if(($scope.quotation.quotationDocUrl!=null)&&($scope.quotation.quotationDocUrl!=undefined)&&($scope.quotation.quotationDocUrl!="")){
			$http.post($stateParams.tenantid + '/app/bulkRateReqAirquotation/save',
					$scope.quotation).success(function(datas) {
				debugger
				if (datas.success == true) {
					logger.logSuccess(datas.message);
					$state.go('app.air.bulkRateReq.list', {
						tenantid : $stateParams.tenantid
					});
					if ($scope.createQuote) {
						// $state.go('app.salesmarketing.booking.list',{tenantid:$stateParams.tenantid});
					} else {
						// $state.go('app.sales.quotation.list',{tenantid:$stateParams.tenantid});
					}

				} else {
					logger.logError(datas.message);
				}
			}).error(function(data) {
				logger.logError("Please try again");
			});
			// }
			// else {
			// logger.logError('Please Upload File');
			//
			// }
		}

	}
	$scope.cancel = function() {
		$state.go('app.air.bulkRateReq.list', {
			tenantid : $stateParams.tenantid
		});
	}

});
app.controller('quotationtableCtrl', function($scope, $http, $filter, logger,
		$stateParams) {

});

app
		.controller(
				'bulkRateReqAirquotationEditCtrl',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector) {
					$scope.quotationTypeList = [];
					$scope.customerList = [];
					$scope.portList = [];
					$scope.currencyList = [];
					$scope.createQuote = false;

					var QuotHdId = parseInt($location.search().QuotHdId);

					$scope.quotation = {
						service : '',
						aol : '',
						origin : '',
						customer : '',
						salesPerson : '',
						vendor : '',
						flightNo : '',
						attention : '',
						quotationDate : '',
						branch : '',
						aod : '',
						destination : '',
						shipper : '',
						salesType : '',
						carrier : '',
						flightDate : '',
						termConditions : '',
						mode : '',
						currency : '',
						term : '',
						commodity : '',
						consignee : '',
						nominatedBy : '',
						validityDate : '',
						remarks : '',
						quotationId : '',
						quotationDtl : [ {
							id : 0,
							chargeHeads : '',
							quotationId : '',
							quotationDtlId : '',
							unit : '',
							currency : '',
							qty : '',
							rate : '',
							paymentMethod : '',
							transactionType : '',
							buySell : '',
							note : ''
						} ]
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

					$scope.addslab = function(row, index) {
						$scope.max = Math.max.apply(Math, row.weightslab
								.map(function(item) {
									return item.wid;
								}));
						var len = row.weightslab.length - 1;
						$scope.max = $scope.max + 1;
						var json = {
							wid : $scope.max,
							fromweight : row.weightslab[len].toweight + 1,
							toweight : row.weightslab[len].toweight + 2,
							charges : []
						}
						row.weightslab.push(json);
						len = row.weightslab.length - 1;
						$timeout(function() {
							hideActivePapers(row.id + "" + $scope.max, []);
						}, 1000);
					}
					$scope.addRow = function() {

						$scope.max = Math.max.apply(Math,
								$scope.quotation.quotationDtl
										.map(function(item) {
											return item.id;
										}));
						$scope.max = $scope.max + 1;
						var chargedata = {
							id : $scope.max,
							chargeHeads : '',
							unit : '',
							currency : '',
							qty : '',
							rate : '',
							currencyList : angular.copy($scope.currencylist),
							paymentMethod : '',
							transactionType : '',
							buySell : '',
							note : ''
						};

						$scope.quotation.quotationDtl.push(chargedata);
						var len = $scope.quotation.quotationDtl.length - 1;
						$timeout(function() {
							hideActivePapers($scope.max + "0", []);
						}, 1000);
					}
					$scope.removeRow = function() {
						$scope.tablerow = [];
						angular.forEach($scope.quotation.quotationDtl,
								function(row, index) {
									var check = row.select;
									console.log(index);
									if (check == undefined || check == "") {
										$scope.tablerow.push(row);
									} else {

									}
								});
						$scope.quotation.quotationDtl = $scope.tablerow;
					};

					$scope.doubleshowTable = function(wtIndex, trIndex) {

						var n = $("#handsondiv" + trIndex + wtIndex).css(
								"display");

						if (n == 'none') {
							$("#handsondiv" + trIndex + wtIndex).css("display",
									"block");
							$scope.addindex = trIndex + "" + wtIndex;
						} else if (n == 'block') {
							$("#handsondiv" + trIndex + wtIndex).css("display",
									"none");

						}

					}

					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth() + 1;

					var yyyy = today.getFullYear();
					if (dd < 10) {
						dd = '0' + dd
					}
					if (mm < 10) {
						mm = '0' + mm
					}
					var today = dd + '/' + mm + '/' + yyyy;
					$scope.quotation.dataOfIssues = today;
					$scope.modeList = [];
					$scope.getQuotationType = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "AIR";
						$scope.modeList.push(data);
						// data = {};
						// data["id"] = "2";
						// data["text"] = "SEA";
						// $scope.modeList.push(data);
					}

					$scope.salesTypeList = [];
					$scope.getSalesType = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "CROSS TRADE";
						$scope.salesTypeList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "LOCAL";
						$scope.salesTypeList.push(data);
						data = {};
						data["id"] = "3";
						data["text"] = "NOMINATED";
						$scope.salesTypeList.push(data);

					}
					$scope.getSalesType();
					$scope.transactionTypeList = [];

					$scope.getTransactionType = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "BUY";
						$scope.transactionTypeList.push(data);
						data = {};
						data["id"] = "2";
						data["text"] = "SELL";
						$scope.transactionTypeList.push(data);

					}
					$scope.getTransactionType();

					$scope.PaymentMethodList = [];
					$scope.getpaymentMethod = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "PREAPID TO COLLECT";
						$scope.PaymentMethodList.push(data);
						// data = {};
						// data["id"] = "2";
						// data["text"] = "SELL";
						// $scope.PaymentMethodList.push(data);

					}
					$scope.getpaymentMethod();

					$scope.chargeList = [];
					$scope.dropdown = function() {
						$scope.getQuotationType();
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
					$scope.editdata = function(quotation) {

						$scope.getQuotationType();
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

					$scope.checkValidation = function() {

						var alertmsg = "<ui><h4>Please fill the required fields</h4>";
						var msg = "";
						if ($scope.checkundefined($scope.quotation.customer)) {
							msg = msg + "<li>CUSTOMER :Field is required.</li>";
							$scope.changecolor('customer_id');
						} else {
							$scope.clearcolor('customer_id');
						}

						angular
								.forEach(
										$scope.quotation.quotationDtl,
										function(chargesDetail, index) {
											if ($scope
													.checkundefined(chargesDetail.chargeHeads)) {
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
														+ "# LOD :Field is required.</li>";
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
													.checkundefined(chargesDetail.qty)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# VALID FROM :Field is required.</li>";
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
													.checkundefined(chargesDetail.paymentMethod)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Payment Method :Field is required.</li>";
											}
											if ($scope
													.checkundefined(chargesDetail.currency)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Currency :Field is required.</li>";
											}
											if ($scope
													.checkundefined(chargesDetail.transactionType)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
														+ "# Transaction Type :Field is required.</li>";
											}
											if ($scope
													.checkundefined(chargesDetail.buySell)) {
												msg = msg
														+ "<li>Row :"
														+ (index + 1)
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
					$scope.edit = false;
					
					if (QuotHdId != '' && QuotHdId != undefined) {
						$scope.edit = true;
						$scope.dropdown();
						$http
								.post(
										$stateParams.tenantid
												+ '/app/airquotation/edit',
										QuotHdId)
								.success(
										function(data) {
											debugger
											$scope.quotation = data.lQuotationBean[0];
											$scope.quotation.service = data.lQuotationBean[0].service
													.toString();
											$scope.quotation.branch = data.lQuotationBean[0].branch
													.toString();
											$scope.quotation.mode = data.lQuotationBean[0].mode
													.toString();
											$scope.quotation.aol = data.lQuotationBean[0].aol
													.toString();
											$scope.quotation.aod = data.lQuotationBean[0].aod
													.toString();
											$scope.quotation.term = data.lQuotationBean[0].term
													.toString();
											$scope.quotation.origin = data.lQuotationBean[0].origin
													.toString();
											$scope.quotation.destination = data.lQuotationBean[0].destination
													.toString();
											$scope.quotation.customer = data.lQuotationBean[0].customer
													.toString();
											$scope.quotation.shipper = data.lQuotationBean[0].shipper
													.toString();
											$scope.quotation.consignee = data.lQuotationBean[0].consignee
													.toString();
											$scope.quotation.nominatedBy = data.lQuotationBean[0].nominatedBy
													.toString();
											$scope.quotation.vendor = data.lQuotationBean[0].vendor
													.toString();
											$scope.quotation.currency = data.lQuotationBean[0].currency
													.toString();
											$scope.quotation.salesType = data.lQuotationBean[0].salesType
													.toString();

											for (var i = 0; i < $scope.quotation.quotationDtl.length; i++) {
												$scope.quotation.quotationDtl[i].chargeHeads = $scope.quotation.quotationDtl[i].chargeHeads
														.toString();
												$scope.quotation.quotationDtl[i].unit = $scope.quotation.quotationDtl[i].unit
														.toString();
												$scope.quotation.quotationDtl[i].currency = $scope.quotation.quotationDtl[i].currency
														.toString();
												$scope.quotation.quotationDtl[i].paymentMethod = $scope.quotation.quotationDtl[i].paymentMethod
														.toString();
												$scope.quotation.quotationDtl[i].transactionType = $scope.quotation.quotationDtl[i].transactionType
														.toString();
												$scope.quotation.quotationDtl[i].buySell = $scope.quotation.quotationDtl[i].buySell
														.toString();
											}

										});

					}

					$scope.submitupdate = function() {
						console.log($scope.quotation);
						var msg = $scope.checkValidation();
						if (!$scope.checkundefined(msg)) {
							logger.logError(msg);
						} else {
							$http.post($stateParams.tenantid + '/app/airquotation/update',
									$scope.quotation).success(function(datas) {
								debugger
								if (datas.success == true) {
									logger.logSuccess(datas.message);
									$state.go('app.air.bulkRateReq.list', {
										tenantid : $stateParams.tenantid
									});
									if ($scope.createQuote) {
										// $state.go('app.salesmarketing.booking.list',{tenantid:$stateParams.tenantid});
									} else {
										// $state.go('app.sales.quotation.list',{tenantid:$stateParams.tenantid});
									}

								} else {
									logger.logError(datas.message);
								}
							}).error(function(data) {
								logger.logError("Please try again");
							});
						}

					}
					$scope.cancel = function() {
						$state.go('app.air.bulkRateReq.list', {
							tenantid : $stateParams.tenantid
						});
					}

				});
