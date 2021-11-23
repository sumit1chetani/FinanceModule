'use strict';
app
		.controller(
				'deliverOrderListCtrl',
				function($scope, $timeout, $stateParams, sharedProperties,
						toaster, $filter, $rootScope, $http, $location, logger,
						$state, ngDialog, $controller, $injector,
						validationService) {
					$scope.deliveryorder = {
						rowId : '',
						blNo : '',
						mrn : '',
						container : '',
						arrivalDate : '',
						vessel : '',
						shippingAgent : '',
						doNumber : '',
						rotationNumber : '',
						consignee : '',
						voyage : '',
						clearencePort : '',
						remarks : '',
						currenctDate : '',
						dischargePort : '',
						agentdo : '',
						totQty : '',
						totWt : '',
						doimport : '',
						reexport : '',
						transit : '',
						tempadmission : '',
						dfsa : '',
						fz : '',
						cdrcash : '',
						cdr : '',
						deposit : '',
						credit : '',
						stang : '',
						bankg : '',
						other : '',
						doNumber : '',
						doaddress : '',
						packageType : '',
						quantity : '',
						weigth : '',
						volume : '',
						goods : '',
						doAddress : '',
						doto : '',
						deliverDtl : [],
						doVaildDate : ''

					}

					$scope.discharge = {
						mode : '',
						carrier : ''

					};
					$scope.modeList = [];
					$scope.carrierList = [];

					$scope.getQuotationType = function() {
						var data = {};
						data["id"] = "1";
						data["text"] = "SEA COASTAL";
						$scope.modeList.push(data);
						// $scope.quotation.mode='1';
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

					$http.get(
							$stateParams.tenantid
									+ '/app/commonUtility/getcarrierList')
							.success(function(datas) {
								debugger
								$scope.carrierList = datas.commonUtilityBean;
								// $scope.transList = datas.lCommonUtilityBean;

							}).error(function(data) {

							});
					$scope.search = function(bean) {

						if ($scope.discharge.mode != ""
								&& $scope.discharge.mode != null
								&& $scope.discharge.mode != undefined) {
							$http
									.post(
											$stateParams.tenantid
													+ '/app/deiveryorder/filterList',
											bean)
									.success(
											function(response) {
												if (response.success == true) {
													$scope.rowCollection = response.getlist;
													angular
															.forEach(
																	$scope.rowCollection,
																	function(
																			row,
																			index) {

																		if (row.mode != null
																				&& row.mode != '') {

																			if (row.mode == 1) {
																				row.mode = "SEA COASTAL";
																			} else if (row.mode == 2) {
																				row.mode = "SEA FOREIGN";
																			} else if (row.mode == 3) {
																				row.mode = "TRUCK";
																			} else if (row.mode == 4) {
																				row.mode = "LINER";
																			} else if (row.mode == 5) {
																				row.mode = "FORWARDING";
																			}
																		}
																	})
													// logger.logSuccess(datas.message);
												} else {
													logger
															.logError("No Data !");
													$scope.rowCollection = [];
												}
											});
						}
					}
					//					 
					$scope.displayCollection = [];
					$scope.rowCollection = [];

					$scope.add = function() {
						$state.go('app.operation.deliverOrder.add', {
							tenantid : $stateParams.tenantid
						});
					};

					$scope.getList = function() {

						$http.get(
								$stateParams.tenantid
										+ '/app/deiveryorder/list').success(
								function(response) {
									$scope.rowCollection = response.getlist; angular.forEach($scope.rowCollection, function(row, index) { 

										if(row.mode != null && row.mode != ''){
											 
										    if(row.mode==1){
												row.mode = "SEA COASTAL";
									    }else  if(row.mode==2){
												row.mode = "SEA FOREIGN";
									    }else  if(row.mode==3){
												row.mode = "TRUCK";
									    }else  if(row.mode==4){
												row.mode = "LINER";
										}
										else  if(row.mode==5){
												row.mode = "FORWARDING";
									    }
									}
										})
								});

					}
					$scope.getList();

					$scope.editRow = function(rowId) {
						$location
								.url($stateParams.tenantid
										+ '/operation/deliverOrder/edit?rowId='
										+ rowId);
					}

					$scope.viewRow = function(rowId) {
						$location
								.url($stateParams.tenantid
										+ '/operation/deliverOrder/view?rowId='
										+ rowId);
					}

					// update
					$scope.print = function(deliveryorder) {

						// if(deliveryorder.receiptDate!=null &&
						// deliveryorder.receiptDate!='' &&
						// deliveryorder.amount!=null &&
						// deliveryorder.amount!=''){
						$scope.deliveryorder.rowId = deliveryorder.rowId;

						var rowId = $scope.deliveryorder.rowId;

						/*
						 * var url =
						 * $stateParams.tenantid+'/app/deiveryorder/deliveryorderPrint?doNumber=' +
						 * rowId; var wnd = window.open(url, 'Simatech',
						 * 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						 * wnd.print();
						 */

						var url = $stateParams.tenantid
								+ '/app/deiveryorder/deliveryorderPrint?doNumber='
								+ rowId;
						var wnd = window
								.open(
										url,
										'Simatech',
										'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						wnd.print();
						/*
						 * }else{ $scope.deliveryorder.rowId =
						 * deliveryorder.rowId; ngDialog.open({ template :
						 * '/views/documentation/deliverOrder/do_popup', scope :
						 * $scope, // closeByEscape: true });
						 * 
						 * $timeout(function() {
						 * $("#receiptDateId").datetimepicker({ minDate :
						 * "01/01/2016", format : 'DD/MM/YYYY', pickTime : false
						 * }); }, 1000);
						 * 
						 * $("#receiptDateId").on( "dp.change", function(e) {
						 * $scope.deliveryorder.receiptDate = $(
						 * '#receiptDateId').val(); }); }
						 */

					};

					/*
					 * $scope.doPrint = function (deliveryorderForm,
					 * deliveryorder){
					 * 
					 * var url =
					 * $stateParams.tenantid+'/app/deiveryorder/deliveryorderPrint?doNumber=' +
					 * deliveryorder.rowId; var wnd = window.open(url,
					 * 'Simatech',
					 * 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
					 * wnd.print(); }
					 */

					$scope.updateDoPop = function(doPopUpForm) {
						if (new validationService()
								.checkFormValidity(doPopUpForm)) {
							$http
									.post(
											$stateParams.tenantid
													+ '/app/deiveryorder/updatePop',
											$scope.deliveryorder)
									.success(
											function(response) {
												if (response.success == true) {
													logger
															.logSuccess("Updated Succesfully!");

													var url = $stateParams.tenantid
															+ '/app/deiveryorder/deliveryorderPrint?doNumber='
															+ $scope.deliveryorder.rowId;
													var wnd = window
															.open(
																	url,
																	'Simatech',
																	'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
													ngDialog.close();
													wnd.print();

													/*
													 * var url =
													 * $stateParams.tenantid+'/app/deiveryorder/printdo?rowId=' +
													 * $scope.deliveryorder.rowId;
													 * var wnd =
													 * window.open(url,
													 * 'Simatech',
													 * 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
													 * ngDialog.close();
													 * wnd.print();
													 */
													$scope.getList();

												} else {
													logger
															.logError("Unable to save!");
												}
											});
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew(doPopUpForm.$validationSummary),
											5000, 'trustedHtml');
						}
					}

					$scope.cancelDoPop = function() {
						$scope.deliveryorder.amount = 0;
						$scope.deliveryorder.receiptDate = '';
						$scope.deliveryorder.chequeNo = '';
						$scope.deliveryorder.paymentRemarks = '';
						ngDialog.close();
					}

					$scope.doRevalidation = function(data) {
						debugger;
						var blNo = data.blNo;
						var consignee = data.consignee;
						var port = data.dischargePort;
						ngDialog
								.open({
									scope : $scope,
									template : '/views/documentation/deliverOrder/deliveryOrderRevalidation.jsp',
									controller : $controller(
											'DORevalidationCtrl', {
												$scope : $scope,
												$rootScope : $rootScope,
												blNo : blNo,
												consignee : consignee,
												pod : port

											}),
									className : 'ngdialog-theme-plain',
									showClose : false,
									closeByDocument : false,
									closeByEscape : false,
									preCloseCallback : $scope.getList
								});

					}

					$scope.detentionInvoice = function(data) {

						debugger;
						var blNo = data.blNo;
						var consignee = data.consignee;
						var port = data.dischargePort;
						var doid = data.rowId;
						ngDialog
								.open({
									scope : $scope,
									template : '/views/documentation/deliverOrder/deliveryOrderdetention.jsp',
									controller : $controller('DetentionCtrl', {
										$scope : $scope,
										$rootScope : $rootScope,
										blNo : blNo,
										consignee : consignee,
										pod : port,
										doid : doid

									}),
									className : 'ngdialog-theme-plain',
									showClose : false,
									closeByDocument : false,
									closeByEscape : false,
									preCloseCallback : $scope.getList
								});

					}
				});

app
		.controller(
				'DORevalidationCtrl',
				function($scope, blNo, consignee, pod, $timeout, $stateParams,
						sharedProperties, toaster, $filter, $rootScope, $http,
						$location, logger, $state, ngDialog, $controller,
						$injector, validationService) {

					$scope.deliveryorder = {
						custtax : '',
						invoiceDate : '',
						blNo : blNo,
						detentionType : '',
						chargeType : '',
						doValidation : '',
						pod : pod,
						consignee : consignee,

					}

					$scope.detailList = {
						containerNumber : '',
						containerType : '',
						dischargeDate : '',
						gateinDate : '',
						returnDate : '',
						billNo : '',
						estimatesTotal : '',
					}

					$scope.cancelDoPop = function() {

						ngDialog.close();
					}

					$scope.revalidation = function() {

						if ($scope.deliveryorder.invoiceDate != ""
								&& $scope.deliveryorder.invoiceDate != null) {
							$http
									.post(
											$stateParams.tenantid
													+ '/app/deiveryorder/doRevalidation',
											$scope.deliveryorder)
									.success(
											function(response) {
												if (response.invoiceCount == 0) {
													$scope.deliveryorder.doValidation = 'yes';

													$http
															.post(
																	$stateParams.tenantid
																			+ '/app/deiveryorder/doRevalidation',
																	$scope.deliveryorder)
															.success(
																	function(
																			response) {
																		if (response.isSuccess == true) {
																			logger
																					.logSuccess(response.message);
																			ngDialog
																					.close();
																		} else {
																			logger
																					.logError(response.message);
																		}
																	})
															.error(
																	function(
																			data) {
																		logger
																				.logError("Error Please Try Again");
																	});

												} else {

													$scope.deliveryorder.detentionType = 'import';
													$scope.deliveryorder.chargeType = 'detention';
													$http
															.post(
																	$stateParams.tenantid
																			+ '/app/detection/searchDetail',
																	$scope.deliveryorder)
															.success(
																	function(
																			data) {
																		if (data) {
																			debugger;
																			$scope.deliveryorder.tariff = 'SC0006';

																			$scope.bean = $scope.deliveryorder;

																			if (data.detectionDetail.length > 0) {
																				$scope.generate = data.detectionDetail;
																				$scope.detailList = data.detectionDetail;
																				$scope.deliveryorder.doValidation = 'yes';

																				var obj = {
																					bean : $scope.deliveryorder,
																					generateList : $scope.detailList,
																					chargeType : 'detention'
																				};
																				$rootScope.list = $scope.detailList;
																				$rootScope.bean = $scope.deliveryorder;
																				ngDialog
																						.close();
																				$location
																						.url($stateParams.tenantid
																								+ '/invoice/detectioninvoice/view?obj='
																								+ obj);

																			} else {
																				logger
																						.logError("No data found!");

																			}
																		}

																	})
															.error(
																	function(
																			data) {
																		logger
																				.logError("Error Please Try Again");
																	});

												}
											});
						} else {
							logger
									.logError("Please select DO Extension date!!!");

						}

					}

				});

app
		.controller(
				'DetentionCtrl',
				function($scope, blNo, consignee, pod, doid, $timeout,
						$stateParams, sharedProperties, toaster, $filter,
						$rootScope, $http, $location, logger, $state, ngDialog,
						$controller, $injector, validationService) {

					$scope.deliveryorder = {
						custtax : '',
						invoiceDate : '',
						blNo : blNo,
						detentionType : '',
						chargeType : '',
						doValidation : '',
						pod : pod,
						consignee : consignee,
						doId : doid

					}

					$scope.detailList = {
						containerNumber : '',
						containerType : '',
						dischargeDate : '',
						gateinDate : '',
						returnDate : '',
						billNo : '',
						estimatesTotal : '',
						doVailddate : ''
					}
					$scope.doList = [];

					$scope.cancelDoPop = function() {

						ngDialog.close();
					}
					if ($scope.deliveryorder.doId != ""
							&& $scope.deliveryorder.doId != null) {

						$http.post(
								$stateParams.tenantid
										+ '/app/deiveryorder/edit?rowId='
										+ $scope.deliveryorder.doId).success(
								function(result) {

									if (result.success == false) {
										logger.logError("Please Try Again");
									} else {

										console.log(result);
										$scope.deliveryorder = result;
										if (result.deliverDtl.length > 0) {
											$scope.doList = result.deliverDtl;
										}

									}

								}).error(function(data) {

						});

					}

					$scope.detention = function() {

						if ($scope.deliveryorder.invoiceDate != ""
								&& $scope.deliveryorder.invoiceDate != null) {
							$scope.deliveryorder.detentionType = 'import';
							$scope.deliveryorder.chargeType = 'docharges';
							$http
									.post(
											$stateParams.tenantid
													+ '/app/detection/searchDetail',
											$scope.deliveryorder)
									.success(
											function(data) {
												if (data) {
													debugger;
													$scope.deliveryorder.tariff = 'SC0006';

													$scope.bean = $scope.deliveryorder;

													if (data.detectionDetail.length > 0) {
														$scope.generate = data.detectionDetail;
														$scope.detailList = data.detectionDetail;
														for (var i = 0; i < $scope.doList.length; i++) {
															for (var j = i + 1; j < $scope.detailList.length; j++) {
																if ($scope.doList[i].container == $scope.detailList[j].containerId) {
																	$scope.detailList[j].doVailddate = $scope.doList[i].doValiddate;
																}
															}
														}

														var obj = {
															bean : $scope.deliveryorder,
															generateList : $scope.detailList,
															chargeType : 'detention'
														};
														$rootScope.list = $scope.detailList;
														$rootScope.bean = $scope.deliveryorder;
														ngDialog.close();
														$location
																.url($stateParams.tenantid
																		+ '/invoice/detectioninvoice/view?obj='
																		+ obj);

													} else {
														logger
																.logError("No data found!");

													}
												}

											})
									.error(
											function(data) {
												logger
														.logError("Error Please Try Again");
											});

						} else {
							logger.logError("Please select Invoice Date!!!");

						}

					}

				});