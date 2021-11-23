'use strict';
app
		.controller(
				'intraCompanyAccountsRecordsController',
				function($scope, $rootScope, $http, logger, $log, ngDialog,
						$modal, $window, $location, $filter, $timeout,
						$stateParams) {
					$scope.icar = {
						fromDate : '',
						toDate : '',
						company : '',
						companyName : '',
						intraCompany : '',
						transactionNo : '',
						transactionDate : '',
						creditAmount : '',
						debitAmount : '',
						subAccountName : '',
						narration : '',
						refNo : '',
						selectAllCheckBox : '',
						slNo:''
					}

					$scope.selectAll = function(value) {
						// $scope.emptyDeliveryOwner.containerList1=[];
						if (value == true) {
							angular
									.forEach(
											$scope.displayedCollection,
											function(value, key) {
												$scope.displayedCollection[key].check = true;
											})
						} else {
							angular
									.forEach(
											$scope.displayedCollection,
											function(value, key) {
												$scope.displayedCollection[key].check = false;
											})
						}
					}
					$scope.rflag =true;
					$scope.malaysia = false;
					$scope.viewHor = false;
					$scope.viewVer = true;
					var companyCode = $("#companyCode").val();

					if (companyCode == 'C0001') {
						$scope.icar.companyName = 'MUM';
					} else if (companyCode == 'C0002') {
						$scope.icar.companyName = 'SIN';
					} else if (companyCode == 'C0003') {
						$scope.icar.companyName = 'AMD';
					} else if (companyCode == 'C0005') {
						$scope.icar.companyName = 'DEL';
					} else if (companyCode == 'C0006') {
						$scope.icar.companyName = 'LUD';
					} else if (companyCode == 'C0007') {
						$scope.icar.companyName = 'MUN';
					} else if (companyCode == 'C0008') {
						$scope.icar.companyName = 'PUN';
					}

					$('#icar_fromDate').datetimepicker({
						format : 'DD/MM/YYYY',
						pickTime : false
					});

					$('#icar_toDate').datetimepicker({
						format : 'DD/MM/YYYY',
						pickTime : false
					});

					if (companyCode == 'C0017') {
						$scope.malaysia = true;
					} else {
						$scope.malaysia = false;
					}

					$scope.toggleBlock = function(blockId) {
						$('#' + blockId).slideToggle(10);
					}
					// $("div[id$='Block']").slideToggle(10);

					$("#txtCompanyCode").multiselect({
						maxHeight : 200,
						includeSelectAllOption : true,
						disableIfEmpty : true,
						enableCaseInsensitiveFiltering : true,
						onDropdownHide : function(event) {

						}
					});

					$scope.view = function(jvNumber) {
						debugger

						if (jvNumber.contains("BP")) {
							// $scope.printPaymentVoucherDiv =
							// function(jvNumber) {
							var url = $stateParams.tenantid
									+ '/app/cashbankPayment/print?cbVoucherNo='
									+ jvNumber;
							var wnd = window
									.open(
											url,
											'Shipping',
											'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
							wnd.print();
							// }

						} else if (jvNumber.contains("BR")) {
							// $scope.printReceiptVoucherDiv =
							// function(jvNumber){
							var url = $stateParams.tenantid
									+ '/app/cashbankreceipt/print?voucherNo='
									+ jvNumber;
							var wnd = window
									.open(
											url,
											'Shipping',
											'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
							wnd.print();

							// }
						}

						else if (jvNumber.contains("JV")) {
							// $scope.printJournalVoucherDiv =
							// function(jvNumber){
							var url = $stateParams.tenantid
									+ '/app/journalVoucher/print?journalNo='
									+ jvNumber;
							// var wnd = window.open(url, 'Shipping',
							// 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
							var wnd = window
									.open(
											url,
											'Shipping',
											'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
							wnd.print();
							// }
						}
					}

					console.log($('#form_code_id').val());
					$http
							.get(
									$stateParams.tenantid
											+ '/app/usermaster/getCompanyList?formCode='
											+ $('#form_code_id').val())
							.success(
									function(datas) {
										debugger;
										$scope.companyList = datas;
										/*
										 * var data = {}; data["id"] = "All";
										 * data["text"] = "ALL";
										 * $scope.companyList.push(data);
										 */
										console.log("company")
										console.log($scope.companyList)
										var foundItemDest = $filter('filter')(
												$scope.companyList, {
													baseCompany : 1
												})[0];
										// $scope.icar.company =
										// foundItemDest.id;
									}).error(function(datas) {
							});

					$http
							.get(
									$stateParams.tenantid
											+ '/app/iCompAcctsRecords/intraCompanyList')
							.success(function(datas) {
								debugger;
								// alert("hi");

								$scope.intraCompanyList = datas;

							}).error(function(datas) {
							});

					$scope.getList = function() {

						$scope.icar.fromDate = $('#fromDate').val();
						$scope.icar.toDate = $('#toDate').val();

						/*
						 * if ($scope.icar.fromDate == null ||
						 * $scope.icar.fromDate == "") {
						 * 
						 * logger.logError("Please select from date"); }
						 * 
						 * else if ($scope.icar.toDate == null ||
						 * $scope.icar.toDate == "") {
						 * 
						 * logger.logError("Please select to date"); } else
						 */if ($scope.icar.company == null
								|| $scope.icar.company == "") {

							logger.logError("Please select Company");

						} else if ($scope.icar.intraCompany == null
								|| $scope.icar.intraCompany == "") {

							logger.logError("Please select Intra Company");

						}

						else {
							var url = "app/iCompAcctsRecords/list";
							$http.post(
									$stateParams.tenantid
											+ '/app/iCompAcctsRecords/list',
									$scope.icar).success(function(data) {
								if (data.length > 0) {
									console.log("estimates list");
									console.log(data.estimatesList)
									$scope.rowCollection = data;
									$scope.rflag  =true;
									if (data.length == 0) {
										logger.logError("No Records Found!!");
									}

								} else {
									logger.logError("No Records Found!!");
								}
							}).error(function(data) {
								logger.logError("Error Please Try Again");
							});
						}

					};

					$scope.save = function() {

						$scope.icar.checkList = [];
						var voyage = '';
						var len = $scope.rowCollection.length;

						for (var i = 0; i < len; i++) {
							var rowData = $scope.rowCollection[i];

							if (typeof rowData.check == "undefined") {
								rowData["check"] = false;
							}
							if (rowData.check == true) {

								var leng = 1;
							}

						}

						if (leng > 0) {
							for (var i = 0; i < len; i++) {

								var rowData = $scope.rowCollection[i];
								if (typeof rowData.check == "undefined") {
									rowData["check"] = false;
								}
								if (rowData.check == true) {

									$scope.icar.checkList.push(rowData);
								}

							}

							$scope.update = function() {

								$http
										.post(
												$stateParams.tenantid
														+ '/app/iCompAcctsRecords/save',
												$scope.icar)
										.success(
												function(result) {

													if (result.success == true) {
														logger
																.logSuccess("Saved Successfully");
														$scope.getList();
														$state.reload();

													} else {
														logger
																.logError("Unable to Save!");
														return false;
													}

												});

							}
							$scope.update();

						} else {
							logger.logError("Please select atleast one row");
						}

					}

					$scope.reset = function() {
						$scope.icar = {
							fromDate : '',
							toDate : '',
							company : '',
							companyName : '',
							intraCompany : '',
							transactionNo : '',
							transactionDate : '',
							creditAmount : '',
							debitAmount : ''
						};
					}

					$scope.viewRecords = function() {

						$scope.icar.fromDate = $('#fromDate').val();
						$scope.icar.toDate = $('#toDate').val();

					/*	if ($scope.icar.fromDate == null
								|| $scope.icar.fromDate == "") {

							logger.logError("Please select from date");
						}

						else if ($scope.icar.toDate == null
								|| $scope.icar.toDate == "") {

							logger.logError("Please select to date");
						} else
*/
						if ($scope.icar.company == null
								|| $scope.icar.company == "") {

							logger.logError("Please select Company");

						} else if ($scope.icar.intraCompany == null
								|| $scope.icar.intraCompany == "") {

							logger.logError("Please select Intra Company");

						}

						else {
							var url = "app/iCompAcctsRecords/viewRecords";
							$http.post(
									$stateParams.tenantid
											+ '/app/iCompAcctsRecords/viewRecords',
									$scope.icar).success(function(data) {
								if (data.length > 0) {
									console.log("estimates list");
									console.log(data.estimatesList)
									$scope.rowCollection = data;
									$scope.rflag  =false;
									if (data.length == 0) {
										logger.logError("No Records Found!!");
									}

								} else {
									logger.logError("No Records Found!!");
								}
							}).error(function(data) {
								logger.logError("Error Please Try Again");
							});
						}

					};

				});
