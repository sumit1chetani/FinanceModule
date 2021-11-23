'use strict';

app
		.controller(
				'balanceSheetController',
				function($templateCache, $scope, $rootScope, $http, logger,
						$log, ngDialog, $modal, $location, $sce, $filter,
						$timeout, $stateParams) {
					$scope.currencyCode = "";
					$scope.balanceSheet = {
						fromDate : '',
						company : '',
						groupHeadCode : ''
					}

					$scope.comName = "";
					$scope.viewHor = false;
					$scope.viewVer = true;
					$('#bs_fromDate').datetimepicker({
						format : 'DD/MM/YYYY',
						pickTime : false
					});
					debugger;
					$scope.toggleBlock = function(blockId) {
						$('#' + blockId).slideToggle(10);
					}

					var companyCode = $("#companyCode").val();
					if (companyCode == 'C0017') {
						$scope.currencyCode = "- (MYR)";
					} else {
						$scope.currencyCode = "";
					}

					$("#txtCompanyCode").multiselect({
						maxHeight : 200,
						includeSelectAllOption : true,
						disableIfEmpty : true,
						enableCaseInsensitiveFiltering : true,
						onDropdownHide : function(event) {

						}
					});

					$http
							.get(
									$stateParams.tenantid
											+ '/app/usermaster/getCompanyList?formCode='
											+ $('#form_code_id').val())
							.success(
									function(datas) {
										debugger;
										$scope.companyList = datas;
										var data = {};
										data["id"] = "All";
										data["text"] = "ALL";
										$scope.companyList.push(data);

										console.log("company")
										console.log($scope.companyList)
										var foundItemDest = $filter('filter')(
												$scope.companyList, {
													baseCompany : 1
												})[0];
										$scope.balanceSheet.company = foundItemDest.id;

									}).error(function(datas) {
							});

					$http
							.post(
									$stateParams.tenantid
											+ '/app/balanceSheet/generateBalanceSheetReportNewVer',
									$scope.balanceSheet)
							.success(
									function(datas) {

										$scope.balanceSheetList = datas;
										$scope.balancecompanyList = datas.lINTERCOMPANYBalance;
										console.log("List Date" + datas)
										console.log($scope.balanceSheetList);
										$scope.openingBalance = 0;
										$scope.one = $scope.balanceSheetList.tcurrentasset
												+ $scope.balanceSheetList.tfixedasset
												+ $scope.balanceSheetList.tmiscexp
												+ $scope.balanceSheetList.dINTERCOMPANYBalance
												+ $scope.openingBalance;

										$scope.two = $scope.balanceSheetList.capitalAccount
												+ $scope.balanceSheetList.tloanliab
												+ $scope.balanceSheetList.tcurrentlia;

										$scope.currentperiod = 0;
										$scope.check = 0;
										if ($scope.one > $scope.two) {
											$scope.currentperiod = $scope.one
													- $scope.two;
											$scope.totalone = $scope.balanceSheetList.tcurrentasset
													+ $scope.balanceSheetList.tfixedasset
													+ $scope.balanceSheetList.tmiscexp
													+ $scope.balanceSheetList.dINTERCOMPANYBalance
													+ $scope.openingBalance
													- $scope.currentperiod;
											$scope.check = 1;
										} else if ($scope.two > $scope.one) {
											$scope.currentperiod = $scope.two
													- $scope.one;
											$scope.totalone = $scope.balanceSheetList.tcurrentasset
													+ $scope.balanceSheetList.tfixedasset
													+ $scope.balanceSheetList.tmiscexp
													+ $scope.balanceSheetList.dINTERCOMPANYBalance
													+ $scope.openingBalance
													+ $scope.currentperiod;
											$scope.check = 2;
										} else if ($scope.one == 0
												&& $scope.two == 0) {
											$scope.check = 3;
										}
										$scope.mumamount = 0;
										$scope.amdamount = 0;
										$scope.delamount = 0;
										$scope.ludmumamount = 0;
										$scope.munmumamount = 0;
										$scope.punemumamount = 0;
										$scope.hoamount = 0;
										console.log($scope.balancecompanyList);
										debugger;

										for (var i = 0; i < datas.lINTERCOMPANYBalance.length; i++) {
											if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080001 - INTER COMPANY MANAGING ACCOUNTS - MUM") {
												$scope.checked1 = 1;
												$scope.mumamount = datas.lINTERCOMPANYBalance[i].amount;
											}
											if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080003 - INTER COMPANY MANAGING ACCOUNTS - AMD") {
												$scope.checked2 = 2;
												$scope.amdamount = datas.lINTERCOMPANYBalance[i].amount;
											}
											if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080004 - INTER COMPANY MANAGING ACCOUNTS - DEL") {
												$scope.checked3 = 3;
												$scope.delamount = datas.lINTERCOMPANYBalance[i].amount;
											}
											if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080005 - INTER COMPANY MANAGING ACCOUNTS - LUD") {
												$scope.checked4 = 4;
												$scope.ludmumamount = datas.lINTERCOMPANYBalance[i].amount;
											}
											if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080006 - INTER COMPANY MANAGING ACCOUNTS - MUN") {
												$scope.checked5 = 5;
												$scope.munmumamount = datas.lINTERCOMPANYBalance[i].amount;
											}
											if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080007 - INTER COMPANY MANAGING ACCOUNTS - PUN") {
												$scope.checked6 = 6;
												$scope.punemumamount = datas.lINTERCOMPANYBalance[i].amount;
											}
											if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080008 - INTER COMPANY MANAGING ACCOUNTS - CHN") {
												$scope.checked7 = 7;
												$scope.hoamount = datas.lINTERCOMPANYBalance[i].amount;
											}

										}

									}).error(function(datas) {
							});

				


					$scope.generateBalanceSheetReportNewVer = function(
							balanceSheet) {
						$scope.viewVer = true;
						$scope.viewHor = false;

						console.log($scope.balanceSheet.company);

						$scope.balanceSheet.fromDate = $('#fromDate').val();
						var date = $scope.balanceSheet.fromDate;

						$http
								.post(
										$stateParams.tenantid
												+ '/app/balanceSheet/generateBalanceSheetReportNewVer',
										$scope.balanceSheet)
								.success(
										function(datas) {
											$scope.balanceSheetList = datas;
											$scope.balancecompanyList = datas.lINTERCOMPANYBalance;
											console.log("List Date" + datas)
											console
													.log($scope.balanceSheetList);
											$scope.openingBalance = 0;
											$scope.one = $scope.balanceSheetList.tcurrentasset
													+ $scope.balanceSheetList.tfixedasset
													+ $scope.balanceSheetList.dINTERCOMPANYBalance
													+ $scope.openingBalance;

											$scope.two = $scope.balanceSheetList.capitalAccount
													+ $scope.balanceSheetList.tloanliab
													+ $scope.balanceSheetList.tcurrentlia;

											$scope.currentperiod = 0;
											$scope.check = 0;
											if ($scope.one > $scope.two) {
												$scope.currentperiod = $scope.one
														- $scope.two;
												$scope.totalone = $scope.balanceSheetList.tcurrentasset
														+ $scope.balanceSheetList.tfixedasset
														+ $scope.balanceSheetList.dINTERCOMPANYBalance
														+ $scope.openingBalance
														- $scope.currentperiod;
												$scope.check = 1;
											} else if ($scope.two > $scope.one) {
												$scope.currentperiod = $scope.two
														- $scope.one;
												$scope.totalone = $scope.balanceSheetList.tcurrentasset
														+ $scope.balanceSheetList.tfixedasset
														+ $scope.balanceSheetList.dINTERCOMPANYBalance
														+ $scope.openingBalance
														+ $scope.currentperiod;
												$scope.check = 2;
											} else if ($scope.one == 0
													&& $scope.two == 0) {
												$scope.check = 3;
											}

											$scope.mumamount = 0;
											$scope.amdamount = 0;
											$scope.delamount = 0;
											$scope.ludmumamount = 0;
											$scope.munmumamount = 0;
											$scope.punemumamount = 0;
											$scope.hoamount = 0;

											debugger;
											for (var i = 0; i < datas.lINTERCOMPANYBalance.length; i++) {
												if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080001 - INTER COMPANY MANAGING ACCOUNTS - MUM") {
													$scope.checked1 = 1;
													$scope.mumamount = datas.lINTERCOMPANYBalance[i].amount;
												}
												if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080003 - INTER COMPANY MANAGING ACCOUNTS - AMD") {
													$scope.checked2 = 2;
													$scope.amdamount = datas.lINTERCOMPANYBalance[i].amount;
												}
												if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080004 - INTER COMPANY MANAGING ACCOUNTS - DEL") {
													$scope.checked3 = 3;
													$scope.delamount = datas.lINTERCOMPANYBalance[i].amount;
												}
												if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080005 - INTER COMPANY MANAGING ACCOUNTS - LUD") {
													$scope.checked4 = 4;
													$scope.ludmumamount = datas.lINTERCOMPANYBalance[i].amount;
												}
												if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080006 - INTER COMPANY MANAGING ACCOUNTS - MUN") {
													$scope.checked5 = 5;
													$scope.munmumamount = datas.lINTERCOMPANYBalance[i].amount;
												}
												if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080007 - INTER COMPANY MANAGING ACCOUNTS - PUN") {
													$scope.checked6 = 6;
													$scope.punemumamount = datas.lINTERCOMPANYBalance[i].amount;
												}
												if (datas.lINTERCOMPANYBalance[i].accountHeadName == "20080008 - INTER COMPANY MANAGING ACCOUNTS - CHN") {
													$scope.checked7 = 7;
													$scope.hoamount = datas.lINTERCOMPANYBalance[i].amount;
												}

											}

											if (balanceSheet == "C0001") {
												$scope.comName = "MUM";
											} else if (balanceSheet == "C0002") {
												$scope.comName = "SIN";
											} else if (balanceSheet == "C0003") {
												$scope.comName = "AMD";
											} else if (balanceSheet == "C0005") {
												$scope.comName = "DEL";
											} else if (balanceSheet == "C0006") {
												$scope.comName = "LUD";
											} else if (balanceSheet == "C0007") {
												$scope.comName = "MUN";
											} else if (balanceSheet == "C0008") {
												$scope.comName = "PUN";
											}

										});

					}

					$scope.exportVEExcel = function() {
						$scope.balanceSheet.fromDate = $('#fromDate').val();

						console.log($scope.balanceSheet.company);
						if ($scope.balanceSheet.fromDate != ''
								&& $scope.company != undefined) {
							if ($scope.company.length > 0) {
								$scope.balanceSheet.company = $scope.companyCodes
										.join(",");
							}
							$http
									.post(
											$stateParams.tenantid
													+ '/app/balanceSheet/exportVEExcel',
											$scope.balanceSheet)
									.success(
											function(data) {
												if (data) {
													console
															.log('vertical excel'
																	+ data);
													debugger;
													$("#BSExport").bind(
															'click',
															function() {
															});
													$('#BSExport')
															.simulateClick(
																	'click');
													logger
															.logSuccess("Exported successfully!");
												} else {
													logger
															.logSuccess("Failed to export");
												}
											}).error(function(datas) {
									});
						} else {
							if ($scope.balanceSheet.fromDate == ''
									&& $scope.company == '')
								logger
										.logError("Please select Company and valid date range");
							else if ($scope.company == ''
									|| $scope.company == undefined)
								logger.logError("Please select Company");
							else if ($scope.balanceSheet.fromDate == '')
								logger
										.logError("Please select valid date range");
						}
					}

					$.fn.simulateClick = function() {
						return this.each(function() {
							if ('createEvent' in document) {
								var doc = this.ownerDocument, evt = doc
										.createEvent('MouseEvents');
								evt.initMouseEvent('click', true, true,
										doc.defaultView, 1, 0, 0, 0, 0, false,
										false, false, false, 0, null);
								this.dispatchEvent(evt);
							} else {
								this.click(); // IE
							}
						});
					}

					$scope.populateBalanceSheetGrid = function(data) {
						debugger;
						$("#masterBalanceGrid")
								.jqGrid(
										{
											data : data,
											datatype : "local",
											autowidth : true,
											autoheight : true,
											rowList : [ 5, 10, 20 ],
											gridview : true,
											multiselect : true,
											multiboxonly : false,
											colNames : [ 'Group Code',
													'Group Name', 'Balance' ],
											colModel : [ {
												name : 'groupHeadCode',
												index : 'groupHeadCode',
												width : 100,
												align : "left",
												sorttype : 'text',
												searchoptions : {
													sopt : [ 'cn' ]
												},
												resizable : false
											},// Added
											// for
											// avoid
											// resizing
											// the
											// grid.
											{
												name : 'groupHeadName',
												index : 'groupHeadName',
												width : 400,
												align : "left",
												searchoptions : {
													sopt : [ 'cn' ]
												},
												resizable : false,
												sorttype : 'text'
											}, {
												name : 'balance',
												index : 'balance',
												width : 250,
												align : "right",
												searchoptions : {
													sopt : [ 'cn' ]
												},
												resizable : false,
												sorttype : 'number'
											} ],
											loadOnce : true,
											pager : '#masterBalancePage',
											height : '100%',
											rowNum : 10,
											subGrid : true,
											subGridOptions : {
												"plusicon" : 'ui-icon-plus',
												"minusicon" : 'ui-icon-minus'
											},
											subGridRowExpanded : function(
													subgrid_id, row_id) {
												var subgrid_table_id, pager_id;
												subgrid_table_id = subgrid_id
														+ "_t";
												pager_id = "p_"
														+ subgrid_table_id;
												var rowData = jQuery(
														'#masterBalanceGrid')
														.jqGrid('getRowData',
																row_id);
												$("#" + subgrid_id)
														.html(
																"<table id='"
																		+ subgrid_table_id
																		+ "' class='scroll'></table><div id='"
																		+ pager_id
																		+ "' class='scroll'></div>");
												var mainCode;
												debugger;
												if (rowData.groupHeadCode == 'A')
													mainCode = '100%'
												else
													mainCode = '200%'
												$scope.balanceSheet.groupHeadCode = mainCode;

												var subdata = [];
												$http
														.post(
																$stateParams.tenantid
																		+ '/app/balanceSheet/generateBalanceSheetReportDtl',
																$scope.balanceSheet)
														.success(
																function(datas) {
																	debugger;
																	subdata = datas;

																	console
																			.log("data:::::::::::SUB GRID:::data:::::");
																	console
																			.log(subdata);
																	$(
																			"#"
																					+ subgrid_table_id)
																			.jqGrid(
																					{
																						datatype : "local",
																						data : subdata,
																						colNames : [
																								'Account Code',
																								'Account Name',
																								'Balance' ],
																						colModel : [
																								{
																									name : 'groupHeadCode',
																									index : 'groupHeadCode',
																									width : 100,
																									align : "left",
																									sorttype : 'text',
																									searchoptions : {
																										sopt : [ 'cn' ]
																									},
																									resizable : false
																								},// Added
																								// for
																								// avoid
																								// resizing
																								// the
																								// grid.
																								{
																									name : 'groupHeadName',
																									index : 'groupHeadName',
																									width : 400,
																									align : "left",
																									searchoptions : {
																										sopt : [ 'cn' ]
																									},
																									resizable : false,
																									sorttype : 'text'
																								},
																								{
																									name : 'balance',
																									index : 'balance',
																									width : 250,
																									align : "right",
																									searchoptions : {
																										sopt : [ 'cn' ]
																									},
																									resizable : false,
																									sorttype : 'number'
																								} ],
																						rowNum : 20,
																						autowidth : true,
																						autoheight : true,
																						pager : pager_id,
																						sortname : 'num',
																						sortorder : "asc",
																						height : '100%',
																						subGrid : true,
																						subGridOptions : {
																							"plusicon" : 'ui-icon-plus',
																							"minusicon" : 'ui-icon-minus'
																						},
																						subGridRowExpanded : function(
																								subgridah_id,
																								rowah_id) {
																							debugger;
																							var subgridah_table_id, pagerah_id;
																							subgridah_table_id = subgridah_id
																									+ "_t";
																							pager_id = "p_"
																									+ subgridah_table_id;
																							var rowData = jQuery(
																									'#'
																											+ subgrid_table_id)
																									.jqGrid(
																											'getRowData',
																											row_id);
																							$(
																									"#"
																											+ subgridah_id)
																									.html(
																											"<table id='"
																													+ subgridah_table_id
																													+ "' class='scroll'></table><div id='"
																													+ pagerah_id
																													+ "' class='scroll'></div>");

																							$scope.balanceSheet.groupHeadCode = rowData.groupHeadCode;

																							var ahdata = [];
																							$http
																									.post(
																											$stateParams.tenantid
																													+ '/app/balanceSheet/generateBalanceSheetReportAHDtl',
																											$scope.balanceSheet)
																									.success(
																											function(
																													datas) {
																												debugger;
																												ahdata = datas;

																												console
																														.log("data:::::::::::SUB GRID AH :::data:::::");
																												console
																														.log(ahdata);
																												$(
																														"#"
																																+ subgridah_table_id)
																														.jqGrid(
																																{
																																	datatype : "local",
																																	data : ahdata,
																																	colNames : [
																																			'Account Code',
																																			'Account Name',
																																			'Balance' ],
																																	colModel : [
																																			{
																																				name : 'groupHeadCode',
																																				index : 'groupHeadCode',
																																				width : 100,
																																				align : "left",
																																				sorttype : 'text',
																																				searchoptions : {
																																					sopt : [ 'cn' ]
																																				},
																																				resizable : false
																																			},// Added
																																			// for
																																			// avoid
																																			// resizing
																																			// the
																																			// grid.
																																			{
																																				name : 'groupHeadName',
																																				index : 'groupHeadName',
																																				width : 400,
																																				align : "left",
																																				searchoptions : {
																																					sopt : [ 'cn' ]
																																				},
																																				resizable : false,
																																				sorttype : 'text'
																																			},
																																			{
																																				name : 'balance',
																																				index : 'balance',
																																				width : 250,
																																				align : "right",
																																				searchoptions : {
																																					sopt : [ 'cn' ]
																																				},
																																				resizable : false,
																																				sorttype : 'number'
																																			} ],
																																	rowNum : 20,
																																	autowidth : true,
																																	autoheight : true,
																																	pager : pager_id,
																																	sortname : 'num',
																																	sortorder : "asc",
																																	height : '100%'
																																})
																														.jqGrid(
																																'setGridParam',
																																{
																																	data : ahdata
																																})
																														.trigger(
																																"reloadGrid");
																												$(
																														"#"
																																+ subgridah_table_id)
																														.jqGrid(
																																'navGrid',
																																"#"
																																		+ pagerah_id,
																																{
																																	edit : false,
																																	search : false,
																																	refresh : false,
																																	add : false,
																																	del : false
																																});

																											})
																									.error(
																											function(
																													datas) {
																											});

																						}

																					})
																			.jqGrid(
																					'setGridParam',
																					{
																						data : subdata
																					})
																			.trigger(
																					"reloadGrid");
																	$(
																			"#"
																					+ subgrid_table_id)
																			.jqGrid(
																					'navGrid',
																					"#"
																							+ pager_id,
																					{
																						edit : false,
																						search : false,
																						refresh : false,
																						add : false,
																						del : false
																					});

																})
														.error(function(datas) {
														});

											}
										});
						$("#masterBalanceGrid").jqGrid('navGrid',
								'#masterBalancePage', {
									edit : false,
									add : false,
									del : false,
									search : false,
									refresh : true
								});

					}

					$scope.Click = function(id) {
						debugger;
						$rootScope.id = id;
						$scope.id = $rootScope.id;
						if ($scope.balanceSheet.groupCode != null
								&& $scope.balanceSheet.groupCode != ""
								&& $scope.balanceSheet.groupCode == undefined) {
							$scope.groupCode = $scope.balanceSheet.groupCode;
						}
						if ($scope.balanceSheet.company != null
								&& $scope.balanceSheet.company != "") {
							$scope.companyId = $scope.balanceSheet.company;
						} else {
							$scope.companyId = "ALL";
						}
						if ($scope.balanceSheet.fromDate != null
								&& $scope.balanceSheet.fromDate != "") {
							$scope.toDate = $scope.balanceSheet.fromDate;
						} else {
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
							$scope.toDate = todate;

						}
						if ($scope.balanceSheet.toDate != null
								&& $scope.balanceSheet.toDate != ""
								&& scope.balanceSheet.toDate != undefined) {
							$scope.fromDate = $scope.balanceSheet.toDate;
						} else {
							$scope.fromDate = "31/03/2018";
						}

						var url = $stateParams.tenantid
								+ '/app/subgroupacct/list2?subgroup=' + id;
						$http
								.get(url)
								.success(
										function(data) {

											console.log(data);
											if (data.success == false) {
												logger
														.logError("Error Please Try Again");
											}
											$scope.subGroupCode = data.objSubGroupAccountBeanBean[0].subGroupCode;
											$scope.balanceSheet.groupCode = data.objSubGroupAccountBeanBean[0].grpHeadCode;
											var url = '/#/'
													+ $stateParams.tenantid
													+ '/reports/finance/generalLedgersubgroup?companyId='
													+ $scope.companyId
													+ '&subGroupCode='
													+ $scope.subGroupCode
													+ '&groupCode='
													+ $scope.balanceSheet.groupCode + '&id='
													+ $scope.id + '&fromDate='
													+ $scope.fromDate
													+ '&toDate='
													+ $scope.toDate;
											window.open(url);
										}).error(function(data) {
									logger.logError("Error Please Try Again");
								});

					}

				});
