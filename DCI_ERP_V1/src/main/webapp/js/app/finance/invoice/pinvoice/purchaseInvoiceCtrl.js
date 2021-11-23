'use strict';
app
		.controller(
				'purchaseInvoiceCtrl',
				function($scope, $stateParams, $controller, $window,
						$rootScope, $location, $http, logger, $log, ngDialog,
						$modal, utilsService, $state) {

					$scope.dataLoopCount = 0;
					$scope.from = 0;
					$scope.to = 100;
					$scope.rowCollection = [];
					$scope.displayedCollection = [];
					$scope.itemsByPage = 10;
					$scope.offsetCount = 0;
					$scope.limitCount = 1000;
					
					$scope.currentURL = $location.protocol() + '://'
							+ $location.host() + ':' + $location.port() + "/#"
							+ $location.path();

					if (window.localStorage.getItem('giv_list') == $scope.currentURL) {
						alert('window ' + $scope.currentURL
								+ ' is already opened');

					} else {
						window.localStorage.setItem('giv', $scope.currentURL);
						window.localStorage.removeItem('giv');
					}

					$scope.getTranslationList = function() {
						$scope.dataLoopCount = 0;
						$scope.showEmptyLabel = false;
						$scope.from = 0;
						$scope.to = 100;
						$scope.rowCollection = [];
						$scope.GeneralInvoiceList = [];
						$scope.formcode = 'F5623';
						var url = $stateParams.tenantid
								+ '/app/generalpurchaseinvoice/list?limit='
								+ $scope.limitCount + '&offset='
								+ $scope.offsetCount + '&formCode='
								+ $scope.formcode;
						$http
								.get(url)
								.success(
										function(data) {
											console.log("data");
											console.log(data);
											if (data.success == true) {
												$scope.rowCollection = $scope.rowCollection
														.concat(data.lGeneralInvoiceList);
											}
										});
					};

					$scope.getTranslationList();

					$scope.add = function() {
						$state.go('app.finance.invoice.pinvoice-add', {
							tenantid : $stateParams.tenantid
						});
					};

					$scope.editRow = function(InvoiceNo) {
						$location
								.path($stateParams.tenantid
										+ '/invoice/pinvoice/PInvoiceEdit/'
										+ InvoiceNo);
					}

					$scope.deleteRow = function(InvoiceNo) {
						ngDialog.close();
						ngDialog.open({
							template : 'generalInvoiceDeleteModal',
							scope : $scope,
							controller : $controller('GIctrlDelete', {
								$scope : $scope,
								InvoiceNo : InvoiceNo
							})
						});
					};
					$scope.deleteRow1 = function(InvoiceNo) {
						ngDialog.close();
						ngDialog.open({
							template : 'generalInvoiceDeleteModal',
							scope : $scope,
							controller : $controller('GIctrlDelete1', {
								$scope : $scope,
								InvoiceNo : InvoiceNo
							})
						});
					};

					/**
					 * print
					 */
					$scope.printGeneralInvoiceDiv = function(invoiceNo) {
						var url = $stateParams.tenantid
								+ '/app/generalinvoice/print?invoiceNo='
								+ invoiceNo;
						var wnd = $window
								.open(
										url,
										'Shipping',
										'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						wnd.print();
					}

					$scope.view = function(invoiceNo) {
						$location
								.path($stateParams.tenantid
										+ '/invoice/pinvoice/PInvoiceView/'
										+ invoiceNo);
					}
					/**
					 * send mail
					 */
					$scope.sendMail = function(invoiceNo) {
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/sendMail?invoiceNo='
												+ invoiceNo)
								.success(
										function(data) {
											if (data == true) {
												logger
														.logSuccess("Mail sent successfully!");
											} else {
												logger
														.logError("Unable to send Email");
											}
										}).error(function(data) {
									console.log("data" + data);
								});

					}

					$scope.bulkPrint = function(giRowData) {
						var invoiceNos = '';
						var len = giRowData.length;
						for (var i = 0; i < len; i++) {
							var rowData = giRowData[i];
							if (typeof rowData.check == "undefined") {
								rowData["check"] = false;
							}
							if (rowData.check == true) {
								if (invoiceNos == "") {
									invoiceNos = rowData.invoiceNo;
								} else {
									invoiceNos += "," + rowData.invoiceNo;
								}
							}
						}
						var url = $stateParams.tenantid
								+ '/app/generalinvoice/bulkPrint?invoiceNos='
								+ invoiceNos;
						var wnd = window
								.open(
										url,
										'Shipping',
										'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						wnd.print();
					}

					$scope.verified = function(objTranslationItem) {
						$http
								.post(
										$stateParams.tenantid
												+ '/app/generalinvoice/toVerify',
										objTranslationItem)
								.success(
										function(result) {
											if (result) {
												objTranslationItem.verified = true;
												logger
														.logSuccess("General Invoice verified successfully");
												// $scope.getTranslationList();
											}
										});
					}

				});

app.controller('GIctrlDelete', function($scope, $http, ngDialog, logger,
		$location, InvoiceNo, $stateParams) {
	$scope.DeleteConfirm = function() {
		$http.get(
				$stateParams.tenantid + '/app/generalinvoice/delete?invoiceNo='
						+ InvoiceNo).success(
				function(data) {
					if (data == true) {
						logger.logSuccess("Deleted successfully!");
						$scope.rowCollection = $scope.rowCollection
								.filter(function(obj) {
									return obj.InvoiceNo !== InvoiceNo;
								});
						ngDialog.close();
					} else {
						logger.logError("Unable to Delete");
						ngDialog.close();
					}
				}).error(function(data) {
			console.log("data" + data);
		});

	}

	$scope.closeJVAccountDialog = function() {
		ngDialog.close();
	};
});

// General Purchase Invoice
app.controller('GIctrlDelete1', function($scope, $http, ngDialog, logger,
		$location, InvoiceNo, $stateParams) {
	$scope.DeleteConfirm = function() {
		$http.get(
				$stateParams.tenantid
						+ '/app/generalpurchaseinvoice/delete1?invoiceNo='
						+ InvoiceNo).success(
				function(data) {
					if (data == true) {
						logger.logSuccess("Deleted successfully!");
						$scope.rowCollection = $scope.rowCollection
								.filter(function(obj) {
									return obj.InvoiceNo !== InvoiceNo;
								});
						ngDialog.close();
					} else {
						logger.logError("Unable to Delete");
						ngDialog.close();
					}
				}).error(function(data) {
			console.log("data" + data);
		});

	}

	$scope.closeJVAccountDialog = function() {
		ngDialog.close();
	};
});

app
		.controller(
				'purchaseInvoiceCtrladd',
				function($scope, $window, $rootScope, $location, $filter,
						$http, logger, $log, ngDialog, $modal, utilsService,
						ListService, $stateParams, $timeout, validationService,
						toaster, $controller) {

					$scope.mloList = [];
					$scope.PorthdrList = [];
					$scope.voyagehdrList = [];
					$scope.chargeHeadList = [];
					$scope.unitList = [];
					$scope.bankList = [];
					$scope.currencyList = [];
					$scope.customerList = [];
					$scope.seaJobOrderList = [];
					$scope.cgst = true;
					$scope.igst = true;
					$scope.sgst = true;
					$scope.Edit = false;
					$scope.modeList = [ {
						id : '1',
						text : 'Sea'
					}, {
						id : '2',
						text : 'Air'
					} ];
					$scope.voyageList = [];
					$scope.vesselList = [];
					$scope.sectorList = [];
					$scope.purchaseinvoice = {
						companyCode : '',
						customer : '',
						invoiceDt : '',
						tripRelated : false,
						jobOrderNo : '',customer:'',
						pod : '',
						pol : '',
						bank : '',
						remarks : '',
						narration : '',vessel:'',voyage:'',
						currencyHdr : '1',
						totalAmount : '',
						aol : '',
						aod : '',
						airJobOrderNo : '',
						company : '',
						gidtl : [],
						partyInvNo : '',
						exRate : '',
						defaultCurrency : '',
						fromCurrency : '',
						toCurrency : ''

					}

					$scope.purchaseInvoiceDtlList = function() {
						var giRow = {
							select : '',
							chargeHead : '',
							unit : '',
							qty : '',
							rate : '',
							currencyDtl : '',totalAmount:'0',
							amount : '',
							exchangeRate : '',
							taxAmount : '0',
							amountTc : '',
							ttlPrct : '0',
							voyageCode : '',
							vesselCode : '',
							sectorCode : '',
							employeeCode : '',
							portCode : '',
							portSequence : '',
							departmentCode : '',
							agentCode : '',
							countryCode : '',
							customerCode : '',
							supplierCode : '',
							designationCode : '',
							costCenter : '',
							companyCode : '',
							quantityGO : '',
							quantityFO : '',
							assetCode : '',
							fromDate : '',
							toDate : '',
							isHBL : false,
							isMBL : false,
							isHAWB : false,
							isMAWB : false,
							isFlightNo : false,
							isVoyage : false,
							isVessel : false,
							isService : false,
							isEmployee : false,
							isPort : false,
							isDepartment : false,
							isAgent : false,
							isLocation : false,
							isCustomer : false,
							isSupplier : false,
							isDesignation : false,
							isCostCenter : false,
							isCompany : false,
							isQuantityGO : false,
							isQuantityFO : false,
							isPortSequence : false,
							isFromDate : false,
							isToDate : false,
							isContainerNo : false,
							sacNo : '',
							cgstPrct : '0',
							sgstPrct : '0',
							igstPrct : '0',
							gidtl1:[{
							select1 : '',
							containerNo : '',sizeType:'',jobNo:'',pol:'',pod:'',customer:'',amount:''
		
						}]
						};
						$scope.purchaseinvoice.gidtl.push(giRow);
					}
/*$scope.purchaseInvoiceDtlList1 = function() {
						var giRow = {
							select1 : '',
							containerNo : '',sizeType:'',jobNo:'',pol:'',pod:'',customer:'',amount:''
		
						};
						$scope.purchaseinvoice.gidtl.gidtl1.push(giRow);
					}   */

					$scope
							.$watch(
									'purchaseinvoice.currencyHdr',
									function(newValue, oldValue) {
										if (newValue != ''
												&& newValue != undefined) {

											$http
													.get(
															$stateParams.tenantid
																	+ '/app/currency/getExchangeRate?currencyId='
																	+ parseInt(newValue))
													.success(
															function(data) {
																debugger
																// if(!$scope.isEdit){
																// $scope.joborder.exRate
																// =
																// data.defaultCurrency;
																// }

																$scope.purchaseinvoice.defaultCurrency = data.defaultCurrency;
																$scope.purchaseinvoice.fromCurrency = data.fromCurrency;
																$scope.purchaseinvoice.toCurrency = data.toCurrency;
																$scope
																		.checkExRate();
															});
										}

									});
$http.get($stateParams.tenantid+ '/app/commonUtility/getVesselList').success(function(data) {
						$scope.vesselList = data;

					});
						
					 
					$scope.checkExRate = function() {
						if ($scope.purchaseinvoice.exRate >= $scope.purchaseinvoice.fromCurrency
								&& $scope.purchaseinvoice.exRate <= $scope.purchaseinvoice.toCurrency) {

						} else {
							logger.logError("Exchange Rate Between "
									+ $scope.purchaseinvoice.fromCurrency
									+ " and "
									+ $scope.purchaseinvoice.toCurrency);
							$scope.purchaseinvoice.exRate = '';
						}
					}

					$scope.currentURL = $location.protocol() + '://'
							+ $location.host() + ':' + $location.port() + "/#"
							+ $location.path();
					$scope.Edit = false;
					if (window.localStorage.getItem('giv') == $scope.currentURL) {
						alert('window ' + $scope.currentURL
								+ ' is already opened');
						// window.focus();
						// window.open($rootScope.currentURL,'_self').close();

						// window.close();
						// localStorage.removeItem('purchaseIv');
					} else {
						window.localStorage.setItem('giv', $scope.currentURL);
						// window.localStorage.removeItem('purchaseIv');
					}
					$(window).unload(function() {
						// debugger;
						// alert("INSIDE UNLOAD")
						localStorage.removeItem('giv');
					});

					$scope.cancel = function() {
						$location.path($stateParams.tenantid
								+ "/invoice/pinvoice/PInvoiceList");
					};

					app
							.service(
									"ListService",
									function($http, $q, $stateParams) {

										this.getCustomerList = function() {
											var customerList = $q.defer();
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/generalinvoice/getCustomerList')
													.success(
															function(data) {
																customerList
																		.resolve(data);
															})
													.error(
															function(data) {
																customerList
																		.reject("Failed to get Customer List");
															});
											return customerList.promise;
										}

										this.getCustomerListByVoyage = function(
												VoyageCode) {
											var customerList = $q.defer();
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/generalinvoice/getCustomerListByVoyage?VoyageCode='
																	+ VoyageCode)
													.success(
															function(data) {
																customerList
																		.resolve(data);
															})
													.error(
															function(data) {
																customerList
																		.reject("Failed to get Customer List");
															});
											return customerList.promise;
										}

										this.getMloList = function(
												customerCode, pol) {
											var mloList = $q.defer();
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/generalinvoice/getMloList?CustomerCode='
																	+ customerCode
																	+ '&pol='
																	+ pol)
													.success(function(data) {
														mloList.resolve(data);

													})
													.error(
															function(data) {

																mloList
																		.reject("Failed to get Customer List");

															});
											return mloList.promise;
										}

										this.getVesselList = function() {
											var voyageList = $q.defer();
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/generalinvoice/getVesselList')
													.success(
															function(data) {
																voyageList
																		.resolve(data);

															})
													.error(
															function(data) {

																voyageList
																		.reject("Failed to get Voyage Vessel List");

															});
											return voyageList.promise;
										}
										this.getVoyageList = function(
												vesselCode) {
											var voyageList = $q.defer();
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/generalinvoice/getVoyageList?vesselCode='
																	+ vesselCode)
													.success(
															function(data) {
																voyageList
																		.resolve(data);

															})
													.error(
															function(data) {

																voyageList
																		.reject("Failed to get Voyage Vessel List");

															});
											return voyageList.promise;
										}

										this.getCompanyCurrency = function(
												companyCode) {
											var voyageList = $q.defer();
											$http
													.get(
															'app/generalinvoice/getVoyageList?vesselCode='
																	+ vesselCode)
													.success(
															function(data) {
																voyageList
																		.resolve(data);

															})
													.error(
															function(data) {

																voyageList
																		.reject("Failed to get Voyage Vessel List");

															});
											return voyageList.promise;
										}

										this.getBlList = function(VoyageId,
												pol, customer) {
											var blList = $q.defer();
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/generalinvoice/getBlList?voyageCode='
																	+ VoyageId
																	+ '&pol='
																	+ pol
																	+ '&customer='
																	+ customer)
													.success(function(data) {
														blList.resolve(data);

													})
													.error(
															function(data) {

																blList
																		.reject("Failed to get Customer List");

															});
											return blList.promise;
										}

										this.getPortList = function(VoyageId) {

											var portList = $q.defer();
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/generalinvoice/getportList?voyageCode='
																	+ VoyageId)
													.success(function(data) {
														portList.resolve(data);

													})
													.error(
															function(data) {

																portList
																		.reject("Failed to get portList List");

															});
											return portList.promise;
										}

										this.getSubAccountList = function() {
											var subAccountList = $q.defer();
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/commonUtility/getSubAccountCodeList')
													.success(
															function(datas) {
																subAccountList
																		.resolve(datas.commonUtilityBean);
															})
													.error(
															function(data) {
																subAccountList
																		.reject("Failed to get Sub Account Code List");
															});
											return subAccountList.promise;
										}

										this.getAccountHeadList = function() {

											var accountHeadList = $q.defer();
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/generalinvoice/getAccountHeadList')
													.success(
															function(data) {
																accountHeadList
																		.resolve(data);

															})
													.error(
															function(data) {

																accountHeadList
																		.reject("Failed to get Account head List");

															});
											return accountHeadList.promise;
										}

										this.getDateInDDMMYYYY = function convert(
												str) {
											var date = new Date(str), mnth = ("0" + (date
													.getMonth() + 1)).slice(-2), day = ("0" + date
													.getDate()).slice(-2);
											return [ day, mnth,
													date.getFullYear() ]
													.join("-");
										}
									});
 $scope.showContainerPopup = function(selectedIndex,
							rowData) {
								//$scope.purchaseinvoice.gidtl[selectedIndex].gidtl=[];
								if($scope.purchaseinvoice.customer!='' && $scope.purchaseinvoice.customer!=undefined){
							ngDialog
									.open({
										scope : $scope,
										template : 'views/finance/invoice/pinvoice/containerPopup',
										controller : $controller(
												'containerDtlAddCtrl',
												{
													$scope : $scope,
													rowData : rowData,
													selectedRowId : selectedIndex
												}),
										className : 'ngdialog-theme-plain',
										showClose : false,
										closeByDocument : false,
										closeByEscape : false,
										preCloseCallback : $scope.getList
									});
						}else{
							logger.logError("Plese select supplier!...");
						}

					}
					
					$scope.onLoadDropdowns = function() {
						$scope.formcode = 'F5623';
						$http
								.get(
										$stateParams.tenantid
												+ '/app/usermaster/getCompanyList?formCode='
												+ $scope.formcode)
								.success(
										function(datas) {
											debugger;
											$scope.tempCompanyList = datas;
											$scope.companyList = datas;
											var foundItemDest = $filter(
													'filter')(
													$scope.companyList, {
														baseCompany : 1
													})[0];
											$scope.purchaseinvoice.companyCode = foundItemDest.id;
										}).error(function(datas) {
								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/commonUtility/getSubAccountCodeList')
								.success(
										function(datas) {

											$scope.customerList = datas.lCommonUtilityBean;

										}).error(function(datas) {
								});
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/dropDownList')
								.success(
										function(datas) {
											$scope.jobOrderList = datas.jobOrderList;
											$scope.seaJobOrderList = datas.seajobOrderList;
											$scope.bankList = datas.bankList;
											$scope.chargeHeadList = datas.chargeHeadList;
											$scope.unitList = datas.unitList;
											$scope.currencyList = datas.currencyList;
											// $scope.customerList =
											// datas.customerList;
											$scope.hblList = datas.hblList;
											$scope.mblList = datas.mblList;
											$scope.hawbList = datas.hawbList;
											$scope.mawbList = datas.mawbList;

										}).error(function(datas) {
								});

						$scope.company = [ {
							id : 'C0001',
							text : 'MBK.'
						} ];

						$scope.$watch('purchaseinvoice.bank', function(
								newValue, oldValue) {
							if (newValue != '' && newValue != undefined) {

								angular.forEach($scope.purchaseinvoice.gidtl,
										function(row, index) {

											row.company = newValue;

										});

							}
						});
						/*$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
							debugger
							 $scope.customerDropList = datas.customerList;
						})*/
 $scope.$watch('purchaseinvoice.vessel', function(newValue, oldValue) {
					      if(newValue!=null && newValue!=undefined && newValue != '' ){
					    	  $http.post($stateParams.tenantid+ '/app/commonUtility/getVoyageListByVessel',newValue).success(function(data) {
									$scope.voyageList = data;
					    	  });
					      }
					   
					    });
						$scope
								.$watch(
										'generalinvoice.jobOrderNo',
										function(newValue, oldValue) {
											if (newValue != ''
													&& newValue != undefined) {
												var cusCode = $scope.generalinvoice.CustomerName;
												$http
														.get(
																$stateParams.tenantid
																		+ '/app/generalinvoice/getjobOrderDetails?jobOrderNo='
																		+ newValue)
														.success(
																function(datas) {
																	console
																			.log("Trip Details ::::::::::::::");
																	console
																			.log(datas);

																	$scope.purchaseinvoice.pol = datas.pol;
																	$scope.purchaseinvoice.pod = datas.pod;

																	// $scope.customerinvoice.gidtl
																	// =
																	// datas.lGeneralInvoiceDtlList;

																})
														.error(function(datas) {
														});
											}
										});

						$scope
								.$watch(
										'purchaseinvoice.airJobOrderNo',
										function(newValue, oldValue) {
											if (newValue != ''
													&& newValue != undefined) {

												$http
														.get(
																$stateParams.tenantid
																		+ '/app/generalinvoice/getseajobOrderDetails?seajobOrderNo='
																		+ newValue)
														.success(
																function(datas) {

																	console
																			.log(datas);

																	$scope.purchaseinvoice.aol = datas.aol;
																	$scope.purchaseinvoice.aod = datas.aod;

																	// $scope.customerinvoice.gidtl
																	// =
																	// datas.lGeneralInvoiceDtlList;

																})
														.error(function(datas) {
														});
											}
										});

					};

					$scope.onLoadDropdowns();

					$('#invoice_date').datetimepicker({
						minDate : "01/01/2016",
						pickTime : false,
						format : 'DD/MM/YYYY'
					});

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
					$scope.purchaseinvoice.invoiceDt = today;

					$scope
							.$watchCollection(
									'[purchaseinvoice.invoiceDt]',
									function(newValue, oldValue) {
										if ($scope.purchaseinvoice.invoiceDt != '') {
											var frmDate = today;
											var toDate = $scope.purchaseinvoice.invoiceDt;
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
											if (toDate > frmDate) {
												logger
														.logError("Invoice Date should be less or equal to current date");
												$scope.purchaseinvoice.invoiceDt = "";
											}
										}
									});
					$scope.checkDatesCL = function(invoiceDt) {
						var res = $scope.purchaseinvoice.invoiceDt.split("/");
						$http
								.get(
										$stateParams.tenantid
												+ '/app/cashbankreceipt/getloggedcompany?closingDate='
												+ $scope.purchaseinvoice.invoiceDt)
								.success(
										function(datas) {
											if (datas) {
												logger
														.logError("Account closed for year "
																+ res[2]);
												$scope.purchaseinvoice.invoiceDt = today;
											}
										})
					}

					/*
					 * $scope.$watch('generalinvoice.gidtl[index].currencyDtl',
					 * function(newValue, oldValue) { if (newValue != '' &&
					 * newValue != undefined) { debugger;
					 * $http.get($stateParams.tenantid+
					 * '/app/generalinvoice/getexchangeRate?currency='+
					 * currencyName).success(function(datas) {
					 * $scope.generalinvoice.gidtl[$scope.$index].exchangeRate =
					 * datas.exchangeRt;
					 * 
					 * }).error(function(datas) { }); } });
					 */

					$scope.CheckExRateDtl = function(currecny, index, rowDtl) {
						if (currecny != '' && currecny != undefined) {

							$http
									.get(
											$stateParams.tenantid
													+ '/app/currency/getExchangeRate?currencyId='
													+ parseInt(currecny))
									.success(
											function(data) {
												debugger

												$scope.defaultCurrency1 = data.defaultCurrency;
												$scope.fromCurrency1 = data.fromCurrency;
												$scope.toCurrency1 = data.toCurrency;
												if (rowDtl.exchangeRate >= $scope.fromCurrency1
														&& rowDtl.exchangeRate <= $scope.toCurrency1) {

												} else {
													logger
															.logError("Exchange Rate Between "
																	+ $scope.fromCurrency1
																	+ " and "
																	+ $scope.toCurrency1);
													$scope.purchaseinvoice.gidtl[index].exchangeRate = '';
												}

											});
						}
					}

					debugger;
					var generalObj = angular.copy($scope.purchaseinvoice,
							generalObj);
					var listVariable = Object.keys(generalObj);

					$scope.onSubmit = function(purchaseInvoiceForm,
							purchaseinvoice) {
						if (new validationService()
								.checkFormValidity($scope.purchaseInvoiceForm)) {
							$scope.save();
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary),
											5000, 'trustedHtml');
						}
					};

					$scope.print = function(purchaseInvoiceForm,
							purchaseinvoice) {
						if (new validationService()
								.checkFormValidity($scope.purchaseInvoiceForm)) {
							$scope.printPreview();
						} else {
							toaster
									.pop(
											'error',
											"Please fill the required fields",
											logger
													.getErrorHtmlNew($scope.purchaseInvoiceForm.$validationSummary),
											5000, 'trustedHtml');
						}
					};

					$scope.display_limit = 50;

					$scope.increaseLimit = function() {
						if ($scope.display_limit < $scope.yearListVal.length) {
							$scope.display_limit += 50;
						}
					};

					$scope.save = function() {
						debugger;
						if ($scope.Edit != true) {
							
							$http
									.post(
											$stateParams.tenantid
													+ '/app/generalpurchaseinvoice/save',
											$scope.purchaseinvoice)
									.success(
											function(data) {
												if (data.success == true) {
													logger
															.logSuccess("Created successfully!");
													$location
															.path($stateParams.tenantid
																	+ "/invoice/pinvoice/PInvoiceList");
												} else {
													if (data.message != null
															&& data.message != '') {
														logger
																.logError(data.message);
													} else {
														logger
																.logError("Unable to Save");
													}
												}
											}).error(function(data) {
									});
						} else {
							$http
									.post(
											$stateParams.tenantid
													+ '/app/generalpurchaseinvoice/updateGeneralPurchaseInvoice',
											$scope.purchaseinvoice)
									.success(
											function(data) {
												if (data.success == true) {
													logger
															.logSuccess("Updated successfully!");
													$location
															.path($stateParams.tenantid
																	+ "/invoice/pinvoice/PInvoiceList");
												} else {
													if (data.message != null
															&& data.message != '') {
														logger
																.logError(data.message);
													} else {
														logger
																.logError("Unable to Update");
													}
												}
											}).error(function(data) {
									});
						}

					};

					$scope.printPreview = function() {
						$http
								.post(
										$stateParams.tenantid
												+ '/app/generalpurchaseinvoice/saveTemp',
										$scope.purchaseinvoice)
								.success(
										function(data) {
											if (data.success == true) {

												var url = $stateParams.tenantid
														+ '/app/generalpurchaseinvoice/printPreview?purInvNo='
														+ data.sino;
												var wnd = $window
														.open(
																url,
																'Shipping',
																'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
												wnd.print();
											} else {
												if (data.message != null
														&& data.message != '') {
													logger
															.logError(data.message);
												} else {
													logger
															.logError("Unable to Preview");
												}
											}
										}).error(function(data) {
								});
					};

					$scope.validateExchangeRate = function(purchaseinvoice) {
						debugger;
						var HdrLogErrMessage = "", DtlLogErrMessage = "", loggerMsg = "", isFlag = true;
						if (parseFloat(purchaseinvoice.ExchangeRate) < parseFloat(purchaseinvoice.fromCurrency)
								|| parseFloat(purchaseinvoice.ExchangeRate) > parseFloat(purchaseinvoice.toCurrency)) {
							HdrLogErrMessage = "Please Enter Exchange Rate Between "
									+ purchaseinvoice.fromCurrency
									+ " and "
									+ purchaseinvoice.toCurrency + "<br><br>";
							// generalinvoice.ExchangeRate=0;
							$scope.purchaseinvoice.ExchangeRate = '';
							isFlag = false;

						}
						var pinLength = purchaseinvoice.gidtl.length;
						if (pinLength > 0) {

							loggerMsg = HdrLogErrMessage;
							if (loggerMsg != "") {
								isFlag = false;
								$scope.logValidExgRateErrorMessage = loggerMsg;
							}
						}

						return isFlag;
					}

					$scope.getIndex = function(list, name) {
						var foundItem = $filter('filter')(list, {
							id : name
						}, true)[0];
						var index = list.indexOf(foundItem);
						return index;
					}

					$scope.purchaseInvoiceDtlList = function() {
						var giRow = {
							select : '',
							chargeHead : '',totalAmount:'0',
							unit : '',
							qty : '',
							rate : '',
							currencyDtl : '',
							amount : '',
							amountTc : '',
							taxAmount : '0',
							ttlPrct : '0',
							voyageCode : '',
							vesselCode : '',
							sectorCode : '',
							employeeCode : '',
							portCode : '',
							portSequence : '',
							departmentCode : '',
							agentCode : '',
							countryCode : '',
							customerCode : '',
							supplierCode : '',
							designationCode : '',
							costCenter : '',
							companyCode : '',
							quantityGO : '',
							quantityFO : '',
							assetCode : '',
							fromDate : '',
							toDate : '',
							isHBL : false,
							isMBL : false,
							isHAWB : false,
							isMAWB : false,
							isFlightNo : false,
							isVoyage : false,
							isVessel : false,
							isService : false,
							isEmployee : false,
							isPort : false,
							isDepartment : false,
							isAgent : false,
							isLocation : false,
							isCustomer : false,
							isSupplier : false,
							isDesignation : false,
							isCostCenter : false,
							isCompany : false,
							isQuantityGO : false,
							isQuantityFO : false,
							isPortSequence : false,
							isFromDate : false,
							isToDate : false,
							isContainerNo : false,
							cgstPrct : '0',
							sgstPrct : '0',
							igstPrct : '0'
						};
						$scope.purchaseinvoice.gidtl.push(giRow);
					}

					$scope.purchaseInvoiceDtlList();

					$scope.addRow = function(gitable) {
						var table = {
							select : '',
							company : $scope.purchaseinvoice.bank,
							chargeHead : '',
							unit : '',
							qty : '',
							rate : '',totalAmount:'0',
							currencyDtl : '',
							amount : '',
							amountTc : '',
							ttlPrct : '0',
							taxAmount : '0',
							voyageCode : '',
							vesselCode : '',
							sectorCode : '',
							employeeCode : '',
							portCode : '',
							portSequence : '',
							departmentCode : '',
							agentCode : '',
							countryCode : '',
							customerCode : '',
							supplierCode : '',
							designationCode : '',
							costCenter : '',
							companyCode : '',
							quantityGO : '',
							quantityFO : '',
							assetCode : '',
							fromDate : '',
							toDate : '',
							isHBL : false,
							isMBL : false,
							isHAWB : false,
							isMAWB : false,
							isFlightNo : false,
							isVoyage : false,
							isVessel : false,
							isService : false,
							isEmployee : false,
							isPort : false,
							isDepartment : false,
							isAgent : false,
							isLocation : false,
							isCustomer : false,
							isSupplier : false,
							isDesignation : false,
							isCostCenter : false,
							isCompany : false,
							isQuantityGO : false,
							isQuantityFO : false,
							isPortSequence : false,
							isFromDate : false,
							isToDate : false,
							isContainerNo : false,
						};

						gitable.push(table);
					};
					// removeRow
					$scope.removeRow = function(GItable) {
						debugger;
						$scope.tablerow = [];
						angular.forEach(GItable, function(row, index) {
							var check = row.select;
							if (check == undefined || check == "") {
								$scope.tablerow.push(row);
							} else {

							}
						});
						$scope.purchaseinvoice.gidtl = $scope.tablerow;
						$scope
								.calculateTotalAmount($scope.purchaseinvoice.gidtl);
					};

					// calculate based on Total %

					$scope.calculateAmountprct = function(prct, amount, index,
							row) {
						debugger;
						/*
						 * if (customer !=null && bank !=null && chargeHead !=
						 * null && qty !=null && exchangeRate!=null &&
						 * rate!=null ) {
						 */
						if (prct != null && amount != null) {

							if (prct == '0' || prct == '5' || prct == '12'
									|| prct == '18' || prct == '28') {
								// $http.get($stateParams.tenantid+
								// '/app/generalpurchaseinvoice/getTax?chargeHead='+
								// chargeHead + '&customer=' + customer +
								// '&bank=' + bank).success(function(datas) {
								var taxPrct = prct;
								// var
								// amt=parseFloat(qty)*parseFloat(exchangeRate)*parseFloat(rate);
								var amt = parseFloat(amount);
								var taxAmt = parseFloat(amt)
										* ((taxPrct) / 100);

								// $scope.purchaseinvoice.gidtl[index].amount =
								// parseFloat(amt).toFixed(2);
								$scope.purchaseinvoice.gidtl[index].taxAmount = parseFloat(
										taxAmt).toFixed(2);
								if ($rootScope.cgsttotal == false) {
									$scope.purchaseinvoice.gidtl[index].cgstamt = (parseFloat(taxAmt)
											.toFixed(2)) / 2;
									$scope.purchaseinvoice.gidtl[index].cgstper = (prct) / 2;
								}
								if ($rootScope.igsttotal == false) {
									$scope.purchaseinvoice.gidtl[index].igstamt = parseFloat(
											taxAmt).toFixed(2);
									$scope.purchaseinvoice.gidtl[index].igstper = prct;
								}
								if ($rootScope.sgsttotal == false) {
									$scope.purchaseinvoice.gidtl[index].sgstamt = (parseFloat(taxAmt)
											.toFixed(2)) / 2;
									$scope.purchaseinvoice.gidtl[index].sgstper = (prct) / 2;
									;
								}

								$scope
										.calculateTotalAmount($scope.purchaseinvoice.gidtl);
								/*
								 * }).error(function(datas) { });
								 */
							} else {
								$scope.purchaseinvoice.gidtl[index].ttlPrct = '';
								logger
										.logError("Please Enter Valid Tax % (5,12,18,28)");
							}
						}

					};

					// cal TC to BC
					$scope.calculateAmountTctoBc = function(customer, bank,
							chargeHead, tcAmt, exRate, index, row) {
						var bcAmt = tcAmt * exRate;
						$scope.purchaseinvoice.gidtl[index].amount = bcAmt
								.toFixed(2);
						$scope.calculateAmount(customer, bank, chargeHead,
								bcAmt, index, row);
					};

					// calamt
					// $scope.calculateAmount =
					// function(customer,bank,chargeHead,qty,exchangeRate,rate,
					// index, row) {
					$scope.calculateAmount = function(customer, bank,
							chargeHead, amount, index, row) {
						debugger;
						/*
						 * if (customer !=null && bank !=null && chargeHead !=
						 * null && qty !=null && exchangeRate!=null &&
						 * rate!=null ) {
						 */
						if (customer != null && bank != null
								&& chargeHead != null && amount != null) {
							$http
									.get(
											$stateParams.tenantid
													+ '/app/generalpurchaseinvoice/getTax?chargeHead='
													+ chargeHead + '&customer='
													+ customer + '&bank='
													+ bank)
									.success(
											function(datas) {
												var taxPrct = datas.taxPrct;
												// var
												// amt=parseFloat(qty)*parseFloat(exchangeRate)*parseFloat(rate);
												var amt = parseFloat(amount);
												var taxAmt = parseFloat(amt)
														* ((taxPrct) / 100);

												// $scope.purchaseinvoice.gidtl[index].amount
												// = parseFloat(amt).toFixed(2);
												$scope.purchaseinvoice.gidtl[index].taxAmount = parseFloat(
														taxAmt).toFixed(2);
												if ($rootScope.cgsttotal == false) {
													$scope.purchaseinvoice.gidtl[index].cgstamt = (parseFloat(taxAmt)
															.toFixed(2)) / 2;
												}
												if ($rootScope.igsttotal == false) {
													$scope.purchaseinvoice.gidtl[index].igstamt = parseFloat(
															taxAmt).toFixed(2);
												}
												if ($rootScope.sgsttotal == false) {
													$scope.purchaseinvoice.gidtl[index].sgstamt = (parseFloat(taxAmt)
															.toFixed(2)) / 2;
												}

												$scope
														.calculateTotalAmount($scope.purchaseinvoice.gidtl);
											}).error(function(datas) {
									});
						} /*
							 * else { logger.logError("Please fill required
							 * fields.."); }
							 */

					};

					$scope.calculateTotalAmount = function(tables) {
						debugger;
						var Total = 0.0;
						angular.forEach(tables, function(value, key) {
							Total = parseFloat(value.amount)
									+ parseFloat(value.taxAmount) + Total;
						});
						$scope.purchaseinvoice.totalAmount = Total.toFixed(2);
					};

					$scope.showTax = function(customer, bank, chargeHead) {

						if (chargeHead != "" && customer != "" && bank != "") {
							ngDialog
									.open({
										scope : $scope,
										template : 'views/finance/invoice/generalInvoice/generalInvoiceTaxView',
										controller : $controller(
												'InvoiceTaxCtrl',
												{
													$scope : $scope,
													purchaseObject : $scope.generalinvoice,
													customer : customer,
													bank : bank,
													chargeHead : chargeHead,

												}),
										className : 'ngdialog-theme-plain',
										showClose : false,
										closeByDocument : false,
										closeByEscape : false,
										preCloseCallback : $scope.getList
									});
						} else {
							logger
									.logError("Please select ChargeHead,Customer & Branch..");
						}

					}

					// fetch details for EDIT
					var invoiceNo = $stateParams.purchaseInvoiceNo;
					if (invoiceNo != undefined) {
						$scope.Edit = true;
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalpurchaseinvoice/getGeneralInvoiceEdit?invoiceNo='
												+ invoiceNo)
								.success(
										function(result) {
											console.log(result);
											$scope.purchaseinvoice = result;
											$scope.purchaseinvoice.bank = result.bank
													.toString();
											$scope.purchaseinvoice.customer = result.customer
													.toString();
											$scope.purchaseinvoice.currencyHdr = result.currencyHdr
													.toString();

											angular
													.forEach(
															$scope.purchaseinvoice.gidtl,
															function(value, key) {
																if (value.ttlPrct == null) {

																	value.ttlPrct = 0;
																}

																value.chargeHead = value.chargeHead
																		.toString();
																value.company = value.companyCode
																		.toString();
																value.currencyDtl = value.currencyDtl
																		.toString();

																if (value.cgstAmt != '0.0') {
																	$scope.cgst = false;
																	$rootScope.cgsttotal = false;
																	$scope.igst = true;
																	/* $scope.purchaseinvoice.gidtl[$scope.$index] */
																	value.cgstsh = 'CGST';
																	value.cgstnam = 'Central Goods and Service Tax';
																	value.cgstper = value.cgstPrct;
																	value.cgstamt = value.cgstAmt;

																}
																if (value.igstAmt != '0.0') {
																	$scope.igst = false;
																	$rootScope.igsttotal = false;
																	$scope.cgst = true;
																	$scope.sgst = false;
																	value.igstsh = 'IGST';
																	value.igstnam = 'Integrated Goods and Service Tax';
																	value.igstper = value.igstPrct;
																	value.igstamt = value.igstAmt;

																}
																if (value.sgstAmt != '0.0') {
																	$scope.sgst = false;
																	$rootScope.sgsttotal = false;
																	value.sgstsh = 'SGST';
																	value.sgstnam = 'State Goods and Service Tax';
																	value.sgstper = value.sgstPrct;
																	value.sgstamt = value.sgstAmt;

																}
															});
										}).error(function(result) {
									logger.logError("Error Please Try Again");
								});
					}

				});

app
		.controller(
				'InvoiceTaxCtrl',
				function($scope, $rootScope, sharedProperties, logger, $http,
						$filter, $location, $stateParams, validationService,
						toaster, $window, purchaseObject, ngDialog, $timeout,
						customer, bank, chargeHead) {
					$scope.rowCollection = [];

					$http
							.get(
									$stateParams.tenantid
											+ '/app/generalpurchaseinvoice/getTaxList?chargeHead='
											+ chargeHead + '&customer='
											+ customer + '&bank=' + bank)
							.success(
									function(response) {
										if (response.taxList.length != 0) {
											$scope.rowCollection = response.taxList;
										} else {
											logger
													.logError("There are no Tax Types defined for the seleted Charge Head..");
										}
									});

					$scope.cancelng = function() {
						// $scope.purchaseInvoiceData.purInvDueDateDtls = [];
						ngDialog.close();
						if (purchaseObject.purInvDueDateDtls.length > 0) {

						} else {
							$scope.purchaseInvoiceData.purInvDueDateDtls = [];
						}
					}
				});

app
		.controller(
				'purchaseInvoiceViewCtrl',
				function($scope, $window, $rootScope, $location, $filter,
						$http, logger, $log, ngDialog, $modal, utilsService,
						ListService, $stateParams, $timeout, validationService,
						toaster, $state,$controller) {

					$scope.purchaseinvoice = {
						companyCode : '',
						customer : '',
						invoiceDt : '',
						tripRelated : false,
						jobOrderNo : '',
						pod : '',
						pol : '',
						bank : '',
						remarks : '',
						narration : '',
						currencyHdr : '1',
						totalAmount : '',
						aol : '',
						aod : '',
						airJobOrderNo : '',
						company : '',
						gidtl : [],
						partyInvNo : '',
						exRate : ''
					}

					$scope.purchaseInvoiceDtlList = function() {
						var giRow = {
							select : '',
							chargeHead : '',
							unit : '',
							qty : '',
							rate : '',
							currencyDtl : '',totalAmount:'0',
							amount : '',
							taxAmount : '0',
							amountTc : '',
							ttlPrct : '0',
							voyageCode : '',
							vesselCode : '',
							sectorCode : '',
							employeeCode : '',
							portCode : '',
							portSequence : '',
							departmentCode : '',
							agentCode : '',
							countryCode : '',
							customerCode : '',
							supplierCode : '',
							designationCode : '',
							costCenter : '',
							companyCode : '',
							quantityGO : '',
							quantityFO : '',
							assetCode : '',
							fromDate : '',
							toDate : '',
							isHBL : false,
							isMBL : false,
							isHAWB : false,
							isMAWB : false,
							isFlightNo : false,
							isVoyage : false,
							isVessel : false,
							isService : false,
							isEmployee : false,
							isPort : false,
							isDepartment : false,
							isAgent : false,
							isLocation : false,
							isCustomer : false,
							isSupplier : false,
							isDesignation : false,
							isCostCenter : false,
							isCompany : false,
							isQuantityGO : false,
							isQuantityFO : false,
							isPortSequence : false,
							isFromDate : false,
							isToDate : false,
							isContainerNo : false,
							sacNo : '',
							cgstPrct : '0',
							sgstPrct : '0',
							igstPrct : '0'
						};
						$scope.purchaseinvoice.gidtl.push(giRow);
					}

				$scope.purchaseInvoiceDtlList();
                $scope.checking=false;
                $scope.customerList1=[];
				$scope.sizeTypeList=[];
				$scope.portList =[];
				$scope.containerNoList =[];
				$scope.purchaseinvoiceNew = {

           purchaseInvoiceDtlList :[ {
							select1 : '',
							containerNo : '',sizeType:'',jobNo:'',pol:'',pod:'',customer:'',amount:''
		
						}],
						totalAmount:''
					}   
				$scope.view=true;
					var invoiceNo = $stateParams.purchaseInvoiceNo;

					var url = $stateParams.tenantid
							+ '/app/generalpurchaseinvoice/getGeneralInvoiceView?invoiceNo='
							+ invoiceNo;
					$http
							.get(url)
							.success(
									function(result) {
										debugger;
										console.log(result);
										
										$scope.purchaseinvoice = result;
                           var tAmount=0;
										angular.forEach($scope.purchaseinvoice.gidtl,function(value, key) {
											if(value.gidtl1.length>0){
												angular.forEach(value.gidtl1,function(value1, key1) {
												tAmount=tAmount+value1.amount;
												})
												$scope.checking=false;
											}
											$scope.purchaseinvoiceNew.purchaseInvoiceDtlList=value.gidtl1;
															if (value.cgstAmt1 != '0.0') {
																$scope.cgst = false;
																$rootScope.cgsttotal = false;
																$scope.igst = true;
																// $scope.purchaseinvoice.gidtl[$scope.$index]
																value.cgstsh = 'CGST';
																value.cgstnam = 'Central Goods and Service Tax';
																value.cgstper = value.cgstPrct;
																value.cgstamt1 = value.cgstAmt1;
															}
															if (value.igstAmt1 != '0.0') {
																$scope.igst = false;
																$rootScope.igsttotal = false;
																$scope.cgst = true;
																$scope.sgst = true;
																value.igstsh = 'IGST';
																value.igstnam = 'Integrated Goods and Service Tax';
																value.igstper = value.igstPrct;
																value.igstamt1 = value.igstAmt1;
															}
															if (value.sgstAmt1 != '0.0') {
																$scope.sgst = false;
																$rootScope.sgsttotal = false;
																value.sgstsh = 'SGST';
																value.sgstnam = 'State Goods and Service Tax';
																value.sgstper = value.sgstPrct;
																value.sgstamt1 = value.sgstAmt1;
															}
                                                        value.totalAmount=tAmount;
														});
														
									}).error(function(result) {
								logger.logError("Error Please Try Again");
							});

					$scope.cancel1 = function() {
						$state.go('app.reports.finance.invoiceInformation', {
							tenantid : $stateParams.tenantid
						});
					};

					/**
					 * print
					 */
				$scope.showContainerPopupView = function(selectedIndex,
							rowData) {
							ngDialog
									.open({
										scope : $scope,
										template : 'views/finance/invoice/pinvoice/containerPopup',
										controller : $controller(
												'containerDtlAddCtrl1',
												{
													$scope : $scope,
													rowData : rowData,
													selectedRowId : selectedIndex
												}),
										className : 'ngdialog-theme-plain',
										showClose : false,
										closeByDocument : false,
										closeByEscape : false,
										preCloseCallback : $scope.getList
									});
						

					}
					
				
					$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			debugger
			 $scope.customerList1 = datas.customerList;
		}).error(function(data) {

		});

		$http.post(
							$stateParams.tenantid
									+ '/app/quotation/getShipment').success(
							function(datas) {

								$scope.sizeTypeList = datas.getcontypelist;
								$scope.containerNoList = datas.getcontainer;

							}).error(function(datas) {

					});
					$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getiataList')
						.success(function(datas) {
							debugger
							$scope.portList = datas.commonUtilityBean;

						}).error(function(data) {

						});
     	 $scope.cancelng = function(){
     	        // $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        ngDialog.close();
     	        if(purchaseObject.purInvDueDateDtls.length>0){
     	            
     	        }else{
     	            $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        }
     	    }
					$scope.printGeneralPurchaseInvoiceDiv = function(invoiceNo) {

						console.log("print invoice")
						var url = $stateParams.tenantid
								+ '/app/generalpurchaseinvoice/print?invoiceNo='
								+ invoiceNo;
						var wnd = $window
								.open(
										url,
										'Shipping',
										'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						wnd.print();
					}

					$scope.cancel = function() {
						$location.path($stateParams.tenantid
								+ "/invoice/pinvoice/PInvoiceList");
					};
				});

app
		.service(
				"ListService",
				function($http, $q, $stateParams) {

					this.getCustomerList = function() {
						var customerList = $q.defer();
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/getCustomerList')
								.success(function(data) {
									customerList.resolve(data);
								})
								.error(
										function(data) {
											customerList
													.reject("Failed to get Customer List");
										});
						return customerList.promise;
					}

					this.getCustomerListByVoyage = function(VoyageCode) {
						var customerList = $q.defer();
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/getCustomerListByVoyage?VoyageCode='
												+ VoyageCode)
								.success(function(data) {
									customerList.resolve(data);
								})
								.error(
										function(data) {
											customerList
													.reject("Failed to get Customer List");
										});
						return customerList.promise;
					}

					this.getMloList = function(customerCode, pol) {
						var mloList = $q.defer();
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/getMloList?CustomerCode='
												+ customerCode + '&pol=' + pol)
								.success(function(data) {
									mloList.resolve(data);

								})
								.error(
										function(data) {

											mloList
													.reject("Failed to get Customer List");

										});
						return mloList.promise;
					}

					this.getVesselList = function() {
						var voyageList = $q.defer();
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/getVesselList')
								.success(function(data) {
									voyageList.resolve(data);

								})
								.error(
										function(data) {

											voyageList
													.reject("Failed to get Voyage Vessel List");

										});
						return voyageList.promise;
					}
					this.getVoyageList = function(vesselCode) {
						var voyageList = $q.defer();
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/getVoyageList?vesselCode='
												+ vesselCode)
								.success(function(data) {
									voyageList.resolve(data);

								})
								.error(
										function(data) {

											voyageList
													.reject("Failed to get Voyage Vessel List");

										});
						return voyageList.promise;
					}

					this.getCompanyCurrency = function(companyCode) {
						var voyageList = $q.defer();
						$http
								.get(
										'app/generalinvoice/getVoyageList?vesselCode='
												+ vesselCode)
								.success(function(data) {
									voyageList.resolve(data);

								})
								.error(
										function(data) {

											voyageList
													.reject("Failed to get Voyage Vessel List");

										});
						return voyageList.promise;
					}

					this.getBlList = function(VoyageId, pol, customer) {
						var blList = $q.defer();
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/getBlList?voyageCode='
												+ VoyageId + '&pol=' + pol
												+ '&customer=' + customer)
								.success(function(data) {
									blList.resolve(data);

								})
								.error(
										function(data) {

											blList
													.reject("Failed to get Customer List");

										});
						return blList.promise;
					}

					this.getPortList = function(VoyageId) {

						var portList = $q.defer();
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/getportList?voyageCode='
												+ VoyageId)
								.success(function(data) {
									portList.resolve(data);

								})
								.error(
										function(data) {

											portList
													.reject("Failed to get portList List");

										});
						return portList.promise;
					}

					this.getSubAccountList = function() {
						var subAccountList = $q.defer();
						$http
								.get(
										$stateParams.tenantid
												+ '/app/commonUtility/getSubAccountCodeList')
								.success(
										function(datas) {
											subAccountList
													.resolve(datas.commonUtilityBean);
										})
								.error(
										function(data) {
											subAccountList
													.reject("Failed to get Sub Account Code List");
										});
						return subAccountList.promise;
					}

					this.getAccountHeadList = function() {

						var accountHeadList = $q.defer();
						$http
								.get(
										$stateParams.tenantid
												+ '/app/generalinvoice/getAccountHeadList')
								.success(function(data) {
									accountHeadList.resolve(data);

								})
								.error(
										function(data) {

											accountHeadList
													.reject("Failed to get Account head List");

										});
						return accountHeadList.promise;
					}

					this.getDateInDDMMYYYY = function convert(str) {
						var date = new Date(str), mnth = ("0" + (date
								.getMonth() + 1)).slice(-2), day = ("0" + date
								.getDate()).slice(-2);
						return [ day, mnth, date.getFullYear() ].join("-");
					}
				});

app
		.controller(
				'GItableCtrl',
				function($scope, $http, $filter, logger, $stateParams,
						$rootScope) {
					debugger;

					$scope.rowCollection1 = [];

					/*
					 * $scope.$watch('purchaseinvoice.gidtl[trIndex].currencyDtl',
					 * function(newValue, oldValue) {
					 * 
					 * if (newValue != '' && newValue != undefined) { debugger;
					 * $scope.purchaseinvoice.gidtl[$scope.$index].exchangeRate =
					 * ''; $scope.purchaseinvoice.gidtl[$scope.$index].rate =
					 * ''; $scope.purchaseinvoice.gidtl[$scope.$index].amount =
					 * '';
					 *  } });
					 */
$scope
							/*.$watchCollection(
									'purchaseinvoice.customer',function(newValue, oldValue) {
										if(newValue != ''	&& newValued != undefined && $scope.purchaseinvoice.customer!='' && $scope.purchaseinvoice.customer!=undefined){
										$scope.checking=true;
										}else{
											$scope.checking=false;
										}
										})*/
					$scope
							.$watch(
									'purchaseinvoice.gidtl[trIndex].chargeHead',
									function(newValue, oldValue) {
										if(newValue != ''
												&& newValue != undefined){
										$scope.checking=true;
										}else{
											$scope.checking=false;
										}
//var acctHead=newValue;
/*if(acctHead=='50000017' || acctHead=='40010014' ){
											$scope.checking=true;
										}else{
											$scope.checking=false;
										}*/
										console
												.log($scope.purchaseinvoice.gidtl);
										$http
												.get(
														$stateParams.tenantid
																+ '/app/generalpurchaseinvoice/getTaxList?chargeHead='
																+ newValue
																+ '&customer='
																+ $scope.purchaseinvoice.customer
																+ '&bank='
																+ $scope.purchaseinvoice.bank)
												.success(
														function(response) {
															debugger;

															angular
																	.forEach(
																			$scope.purchaseinvoice.gidtl,
																			function(
																					row,
																					index) {

																				if (row.taxAmount == ''
																						&& row.select == '') {

																					if (response.taxList.length != 0) {
																						var totalTax = 0;
																						angular
																								.forEach(
																										response.taxList,
																										function(
																												value,
																												key) {
																											if ('CGST' == value.pTaxShort) {
																												$scope.cgst = false;
																												$rootScope.cgsttotal = false;
																												$scope.igst = true;
																												$scope.purchaseinvoice.gidtl[$scope.$index].cgstsh = value.pTaxShort;
																												$scope.purchaseinvoice.gidtl[$scope.$index].cgstnam = value.pTaxName;
																												$scope.purchaseinvoice.gidtl[$scope.$index].cgstper = value.ptaxprct;
																												totalTax = totalTax
																														+ value.ptaxprct;
																											}
																											if ('IGST' == value.pTaxShort) {
																												$scope.igst = false;
																												$rootScope.igsttotal = false;
																												$scope.cgst = true;
																												$scope.sgst = true;
																												$scope.purchaseinvoice.gidtl[$scope.$index].igstsh = value.pTaxShort;
																												$scope.purchaseinvoice.gidtl[$scope.$index].igstnam = value.pTaxName;
																												$scope.purchaseinvoice.gidtl[$scope.$index].igstper = value.ptaxprct;
																												totalTax = totalTax
																														+ value.ptaxprct;
																											}
																											if ('SGST' == value.pTaxShort) {

																												$scope.sgst = false;
																												$rootScope.sgsttotal = false;
																												$scope.purchaseinvoice.gidtl[$scope.$index].sgstsh = value.pTaxShort;
																												$scope.purchaseinvoice.gidtl[$scope.$index].sgstnam = value.pTaxName;
																												$scope.purchaseinvoice.gidtl[$scope.$index].sgstper = value.ptaxprct;
																												totalTax = totalTax
																														+ value.ptaxprct;
																											}

																										});
																						$scope.purchaseinvoice.gidtl[$scope.$index].ttlPrct = totalTax;

																					} else {

																						/*
																						 * logger.logError("There
																						 * are
																						 * no
																						 * Tax
																						 * Types
																						 * defined
																						 * for
																						 * the
																						 * seleted
																						 * Account
																						 * Head..");
																						 */

																						$scope.cgst = true;
																						$scope.sgst = true;
																						$scope.igst = true;
																						$scope.purchaseinvoice.gidtl[$scope.$index].ttlPrct = 0;

																					}
																				}
																			});
														});

										if (newValue != ''
												&& newValue != undefined) {
											debugger;
											$http
													.get(
															$stateParams.tenantid
																	+ '/app/generalpurchaseinvoice/getSacNo?chargeHead='
																	+ newValue)
													.success(
															function(datas) {
																console
																		.log(datas);
																$scope.purchaseinvoice.gidtl[$scope.$index].sacNo = datas.sacNo;
																// $scope.purchaseinvoice.gidtl[$scope.$index].exchangeRate
																// = '1';

															}).error(
															function(datas) {
															});

											$http
													.get(
															$stateParams.tenantid
																	+ '/app/commonUtility/getAttributesList?accountCode='
																	+ newValue)
													.success(
															function(datas) {
																$scope.purchaseinvoice.gidtl[$scope.$index].attributeList = datas;

																$scope.purchaseinvoice.gidtl[$scope.$index].isHBL = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isMBL = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isHAWB = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isMAWB = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isFlightNo = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isVessel = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isContainerNo = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isVoyage = false;
																// $scope.purchaseinvoice.gidtl[$scope.$index].isVessel
																// = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isService = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isEmployee = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isPort = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isDepartment = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isAgent = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isLocation = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isCustomer = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isSupplier = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isDesignation = false;
																$scope.purchaseinvoice.gidtl[$scope.$index].isCostCenter = false;

																angular
																		.forEach(
																				$scope.purchaseinvoice.gidtl[$scope.$index].attributeList,
																				function(
																						row,
																						rowindex) {
																					if (row.attributeName == "HBL") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isHBL = true;
																					} else if (row.attributeName == "MBL") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isMBL = true;
																					} else if (row.attributeName == "HAWB") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isHAWB = true;
																					} else if (row.attributeName == "MAWB") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isMAWB = true;
																					} else if (row.attributeName == "Flight No") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isFlightNo = true;
																					} else if (row.attributeName == "Vessel & Voyage") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isVessel = true;
																					} else if (row.attributeName == "Container No") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isContainerNo = true;
																					} else if (row.attributeName == "Vessel") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isVessel = true;
																					} else if (row.attributeName == "Voyage") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isVoyage = true;
																					} else if (row.attributeName == "Service") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isService = true;
																					} else if (row.attributeName == "Port") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isPort = true;
																					} else if (row.attributeName == "Department") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isDepartment = true;
																					} else if (row.attributeName == "Employee") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isEmployee = true;
																					} else if (row.attributeName == "Agent") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isAgent = true;
																					} else if (row.attributeName == "Customer") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isCustomer = true;
																					} else if (row.attributeName == "Location") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isLocation = true;
																					} else if (row.attributeName == "Company") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isCompany = true;
																					} else if (row.attributeName == "Designation") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isDesignation = true;
																					} else if (row.attributeName == "Cost Center") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isCostCenter = true;
																					} else if (row.attributeName == "Supplier") {
																						$scope.purchaseinvoice.gidtl[$scope.$index].isSupplier = true;
																					}
																				});
															}).error(
															function(datas) {
															});
										}
										
									});
              /*$scope.$watch('purchaseinvoice.gidtl[trIndex].rate',function(newValue, oldValue) {
	alert(3);
	$scope.calculateAmountTctoBc( $scope.purchaseinvoice.gidtl[$scope.trIndex].customer,  $scope.purchaseinvoice.gidtl[$scope.trIndex].bank,
$scope.purchaseinvoice.gidtl[$scope.trIndex].chargeHead, $scope.purchaseinvoice.gidtl[$scope.trIndex].rate,  $scope.purchaseinvoice.gidtl[$scope.trIndex].exchangeRate, [$scope.index], $scope.purchaseinvoice) ;
										})*/
					$scope.getDropdownValues = function() {
						/*
						 * $http.get( $stateParams.tenantid
						 * +'/app/commonUtility/getJobOrderNo')
						 * .success(function(datas) { $scope.voyageList = datas;
						 * }).error(function(datas) { });
						 */
						$http.get(
								$stateParams.tenantid
										+ '/app/commonUtility/getVesselList')
								.success(function(data) {
									$scope.vesselList = data;

								});

						/*
						 * $http.get( $stateParams.tenantid
						 * +'/app/commonUtility/getMode')
						 * .success(function(datas) { $scope.vesselList = datas;
						 * }).error(function(datas) { });
						 */

						$http.get(
								$stateParams.tenantid
										+ '/app/commonUtility/getSectorList')
								.success(function(datas) {
									$scope.sectorList = datas;
								}).error(function(datas) {
								});

						$http.get(
								$stateParams.tenantid
										+ '/app/commonUtility/getEmployeeList')
								.success(function(datas) {
									$scope.employeeList = datas;
								}).error(function(datas) {
								});

						/*
						 * $http.get( $stateParams.tenantid +
						 * '/app/commonUtility/getLocation')
						 * .success(function(datas) { $scope.portList =
						 * datas.lCommonUtilityBean1; }).error(function(datas) {
						 * });
						 */
						$http.get(
								$stateParams.tenantid
										+ '/app/seaquotation/getiataList')
								.success(function(datas) {
									debugger
									$scope.portList = datas.commonUtilityBean;

								}).error(function(data) {

								});

						$http
								.get(
										$stateParams.tenantid
												+ '/app/commonUtility/getDepartmentList')
								.success(function(datas) {
									$scope.departmentList = datas;
								}).error(function(datas) {
								});

						$http.get(
								$stateParams.tenantid
										+ '/app/commonUtility/getAgentList')
								.success(function(datas) {
									$scope.agentList = datas;
								}).error(function(datas) {
								});

						$http.get(
								$stateParams.tenantid
										+ '/app/commonUtility/getCountryList')
								.success(function(datas) {
									$scope.countryList = datas;
								}).error(function(datas) {
								});

					/*	$http.get(
								$stateParams.tenantid
										+ '/app/commonUtility/getCustomerList')
								.success(function(datas) {
									$scope.customerList = datas;
								}).error(function(datas) {
								});*/

						$http
								.get(
										$stateParams.tenantid
												+ '/app/commonUtility/getDesignationList')
								.success(function(datas) {
									$scope.designationList = datas;
								}).error(function(datas) {
								});

						$http.get(
								$stateParams.tenantid
										+ '/app/commonUtility/getSupplierList')
								.success(function(datas) {
									$scope.supplierList = datas;
								}).error(function(datas) {
								});

					}
					$scope
							.$watch(
									'purchaseinvoice.gidtl[trIndex].vesselCode',
									function(newValue, oldValue) {
										if (newValue != null
												&& newValue != undefined
												&& newValue != '') {
											$http
													.post(
															$stateParams.tenantid
																	+ '/app/commonUtility/getVoyageListByVessel1',
															newValue)
													.success(
															function(data) {
																$scope.voyageList = data;
															});
										}
										/*
										 * if(newValue!=null &&
										 * newValue!=undefined && newValue != '' &&
										 * $scope.bookViaQt==true){
										 * $http.post($stateParams.tenantid+
										 * '/app/salesBooking/getVoyListByVsl?pol='+$scope.bookingData.pol+'&pod='+$scope.bookingData.pod+'&ves='+newValue).success(function(data) {
										 * $scope.voyageList = data.voyList; }) }
										 */
									});
					$scope.getDropdownValues();
					/*
					 * $scope.$watch('purchaseinvoice.gidtl[trIndex].currencyDtl',
					 * function(newValue, oldValue) {
					 * 
					 * if (newValue != '' && newValue != undefined) { debugger;
					 * $http.get($stateParams.tenantid+
					 * '/app/generalinvoice/getexchangeRate?currency='+
					 * newValue).success(function(datas) {
					 * $scope.purchaseinvoice.gidtl[$scope.$index].exchangeRate =
					 * datas.exchangeRt;
					 * 
					 * }).error(function(datas) { }); } });
					 */
				});
app.controller('GItableViewCtrl', function($scope, $http, $filter, logger,
		$stateParams) {

	/*
	 * $scope.$watch('generalinvoice.gidtl[trIndex].chargeHead',
	 * function(newValue, oldValue) { if (newValue != '' && newValue !=
	 * undefined) { debugger;
	 * $http.get($stateParams.tenantid+'/app/generalinvoice/getAttributesList?chargeHead='+newValue).success(function(datas) {
	 * $scope.generalinvoice.gidtl[$scope.$index].attributeList=datas;
	 * 
	 * 
	 * $scope.generalinvoice.gidtl[$scope.$index].isHBL=false;
	 * $scope.generalinvoice.gidtl[$scope.$index].isMBL=false;
	 * $scope.generalinvoice.gidtl[$scope.$index].isHAWB=false;
	 * $scope.generalinvoice.gidtl[$scope.$index].isMAWB=false;
	 * $scope.generalinvoice.gidtl[$scope.$index].isFlightNo=false;
	 * $scope.generalinvoice.gidtl[$scope.$index].isVessel=false;
	 * $scope.generalinvoice.gidtl[$scope.$index].isContainerNo=false;
	 * 
	 * 
	 * angular.forEach($scope.generalinvoice.gidtl[$scope.$index].attributeList,
	 * function(row, rowindex) { if(row.attributeName == "HBL"){
	 * $scope.generalinvoice.gidtl[$scope.$index].isHBL=true; }else
	 * if(row.attributeName == "MBL"){
	 * $scope.generalinvoice.gidtl[$scope.$index].isMBL=true; }else
	 * if(row.attributeName == "HAWB"){
	 * $scope.generalinvoice.gidtl[$scope.$index].isHAWB=true; }else
	 * if(row.attributeName == "MAWB"){
	 * $scope.generalinvoice.gidtl[$scope.$index].isMAWB=true; }else
	 * if(row.attributeName == "Flight No"){
	 * $scope.generalinvoice.gidtl[$scope.$index].isFlightNo=true; }else
	 * if(row.attributeName == "Vessel & Voyage"){
	 * $scope.generalinvoice.gidtl[$scope.$index].isVessel=true; }else
	 * if(row.attributeName == "Container No"){
	 * $scope.generalinvoice.gidtl[$scope.$index].isContainerNo=true; } });
	 * }).error(function(datas) { }); } });
	 */

});

app.controller('jobtableCtrl',function($scope, $http, $filter,$controller, logger, $rootScope, $stateParams) {
		$scope.$watch('purchaseinvoiceNew.purchaseInvoiceDtlList[trIndex].select1',function(newValue, oldValue) {
		var	condition=false;
							var totalAmount=0;
						angular.forEach($scope.purchaseinvoiceNew.purchaseInvoiceDtlList,function(row, index) {
								if(row.select1==true){
									condition=true;
									totalAmount=totalAmount+row.amount;
								}})	
								if(condition==true){
									$scope.purchaseinvoiceNew.totalAmount=totalAmount;	
								}else{
											$scope.purchaseinvoiceNew.totalAmount=0;	
											}			
						/*else{
							$scope.purchaseinvoice.gidtl[ $scope.trIndex].totalAmount=0;
						}*/
									})
	});
app.controller('containerDtlAddCtrl',function($scope, $http, $filter,$controller, logger, $rootScope, ngDialog, rowData,selectedRowId, $stateParams ) {
    	$scope.purchaseinvoice.accountHeadCode=rowData.chargeHead;

$scope.sizeTypeList=[];
$scope.portList=[];
$scope.containerNoList=[];
$scope.purchaseinvoice.selectBox1=false;
$scope.purchaseinvoice.checked=false;
$scope.view=false;
$scope.customerList1=[];
$scope.purchaseinvoiceNew=[];
$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			debugger
			 $scope.customerList1 = datas.customerList;
		}).error(function(data) {

		});
		$scope.purchaseinvoiceNew = {

           purchaseInvoiceDtlList :[ {
							select1 : '',
							containerNo : '',sizeType:'',jobNo:'',pol:'',pod:'',customer:'',amount:''
		
						}],
						totalAmount:''
					}   

		$http.post(
							$stateParams.tenantid
									+ '/app/quotation/getShipment').success(
							function(datas) {

								$scope.sizeTypeList = datas.getcontypelist;
								$scope.containerNoList = datas.getcontainer;

							}).error(function(datas) {

					});
				
		 	$scope.selectAll=function(gidtl1){
			if($scope.purchaseinvoice.selectBox1==true){
			angular.forEach($scope.purchaseinvoice.gidtl,function(row, index) {
				angular.forEach(row.gidtl1,function(row1, index) {
				row1.select1=true;			
											})})
											}
											else{
						angular.forEach($scope.purchaseinvoice.gidtl,	function(row, index) {
							angular.forEach(row.gidtl1,	function(row1, index) {
								row1.select1=false;			
											})})
											}
		}
					$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getiataList')
						.success(function(datas) {
							debugger
							$scope.portList = datas.commonUtilityBean;

						}).error(function(data) {

						});
					 $http.get($stateParams.tenantid + '/app/pinvoice/containerList?chargeHead='+$scope.purchaseinvoice.gidtl[selectedRowId].chargeHead+'&vessel='+$scope.purchaseinvoice.vessel+'&voyage='+$scope.purchaseinvoice.voyage+'&customer='+$scope.purchaseinvoice.customer)
			.success(
					function(data) {
					//	$scope.purchaseinvoiceNew=[];
						$scope.purchaseinvoiceNew.purchaseInvoiceDtlList=data.containerList;
					});
         $scope.apply=function(purchaseInvoiceForm,purchaseinvoiceNew){
	$scope.purchaseinvoice.gidtl[selectedRowId].rate= purchaseinvoiceNew.totalAmount;
	var table=[];
	angular.forEach(purchaseinvoiceNew.purchaseInvoiceDtlList,function(row, index) {
		if(row.select1==true){
		table.push(row);
		}
		})
		$scope.purchaseinvoice.gidtl[selectedRowId].gidtl1= table;

	 $scope.cancelng();
}

     	 $scope.cancelng = function(){
     	        // $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        ngDialog.close();
     	      /*  if(purchaseObject.purInvDueDateDtls.length>0){
     	            
     	        }else{
     	            $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        }*/
     	    }
     
  });
app.controller('containerDtlAddCtrl1',function($scope, $http, $filter,$controller, logger, $rootScope, ngDialog, rowData,selectedRowId, $stateParams ) {
    	$scope.purchaseinvoice.accountHeadCode=rowData.chargeHead;

$scope.sizeTypeList=[];
$scope.portList=[];
$scope.containerNoList=[];
$scope.purchaseinvoice.selectBox1=false;
$scope.purchaseinvoice.checked=false;
$scope.view=false;
$scope.customerList1=[];
$scope.purchaseinvoiceNew=[];
$scope.view=true;
$http.post($stateParams.tenantid+'/app/seaquotation/getServicePartnerList').success(function(datas) {
			debugger
			 $scope.customerList1 = datas.customerList;
		}).error(function(data) {

		});
		$scope.purchaseinvoiceNew = {

           purchaseInvoiceDtlList :[ {
							select1 : '',
							containerNo : '',sizeType:'',jobNo:'',pol:'',pod:'',customer:'',amount:''
		
						}],
						totalAmount:''
					}   

		$http.post(
							$stateParams.tenantid
									+ '/app/quotation/getShipment').success(
							function(datas) {

								$scope.sizeTypeList = datas.getcontypelist;
								$scope.containerNoList = datas.getcontainer;

							}).error(function(datas) {

					});
				
		 	$scope.selectAll=function(gidtl1){
			if($scope.purchaseinvoice.selectBox1==true){
			angular.forEach($scope.purchaseinvoice.gidtl,function(row, index) {
				angular.forEach(row.gidtl1,function(row1, index) {
				row1.select1=true;			
											})})
											}
											else{
						angular.forEach($scope.purchaseinvoice.gidtl,	function(row, index) {
							angular.forEach(row.gidtl1,	function(row1, index) {
								row1.select1=false;			
											})})
											}
		}
					$http.get(
						$stateParams.tenantid
								+ '/app/seaquotation/getiataList')
						.success(function(datas) {
							debugger
							$scope.portList = datas.commonUtilityBean;

						}).error(function(data) {

						});
					 $http.get($stateParams.tenantid + '/app/generalpurchaseinvoice/containerListView?chargeHead='+$scope.purchaseinvoice.gidtl[selectedRowId].chargeHead+'&invoiceNo='+$scope.purchaseinvoice.invoiceNo)
			.success(
					function(data) {
					//	$scope.purchaseinvoiceNew=[];
						$scope.purchaseinvoiceNew.purchaseInvoiceDtlList=data.gidtl1;
					});
         $scope.apply=function(purchaseInvoiceForm,purchaseinvoiceNew){
	$scope.purchaseinvoice.gidtl[selectedRowId].rate= purchaseinvoiceNew.totalAmount;
	var table=[];
	angular.forEach(purchaseinvoiceNew.purchaseInvoiceDtlList,function(row, index) {
		if(row.select1==true){
		table.push(row);
		}
		})
		$scope.purchaseinvoice.gidtl[selectedRowId].gidtl1= table;

	 $scope.cancelng();
}

     	 $scope.cancelng = function(){
     	        // $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        ngDialog.close();
     	      /*  if(purchaseObject.purInvDueDateDtls.length>0){
     	            
     	        }else{
     	            $scope.purchaseInvoiceData.purInvDueDateDtls = [];
     	        }*/
     	    }
     
  });