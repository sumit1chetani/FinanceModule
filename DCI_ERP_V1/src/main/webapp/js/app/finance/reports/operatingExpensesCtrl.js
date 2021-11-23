'use strict';
app
		.controller(
				'operatingExpensesCtrl',
				function($stateParams, $templateCache, $scope, $timeout,
						$rootScope, $http, logger, $log, ngDialog, $modal,
						$location, $sce, $filter, utilsService) {
					$scope.operatingExp = {
						fromDate : '',
						toDate : '',
						type : 'VSL',
						formCode : '',
						accountNo : '',
						objGroupCodes : [],
						groupCode : '',
						pol : '',
						lpol : [],
						pod : '',
						lpod : [],
						vesselCode : '1',
					};
					$scope.dataLoopCount = 0;
					$scope.offsetCount = 0;
					$scope.limitCount = 1000;
					$scope.rowCollection = [];
					$scope.displayedCollection = [];
					$scope.itemsByPage = 100;
					$scope.subGroupList = [];
					$scope.companyList = [];
					$scope.groupHeadList = [];

					var formCode = $('#form_code_id').val();

					$scope.getDropDownList = function() {

						$http
								.post(
										$stateParams.tenantid
												+ '/analytical/operatingExpenses/getDropDownList',
										$scope.operatingExp)
								.success(
										function(data) {

											$scope.accoundHeadList = data.accountHeadList;
										}).error(function(data) {
								});

						$http.post(
								$stateParams.tenantid
										+ '/app/generalinvoice/dropDownList',
								$scope.operatingExp).success(function(data) {

							$scope.voyageList = data.jobOrderList;

						}).error(function(data) {
						});

						$scope.modeList = [ {
							id : '1',
							text : 'Sea'
						}, {
							id : '2',
							text : 'Air'
						} ];

						/*
						 * $http.get('app/usermaster/getCompanyList?formCode='+$('#form_code_id').val()).success(function(data) {
						 * console.log("operating") console.log(data)
						 * $scope.companyList=data;
						 * 
						 * }).error(function(data) { });
						 */
						$http
								.get(
										$stateParams.tenantid
												+ '/app/usermaster/getCompanyList?formCode='
												+ $('#form_code_id').val())
								.success(
										function(datas) {
											debugger;
											$scope.companyList = datas;

											console.log("company")
											console.log($scope.companyList)
											var foundItemDest = $filter(
													'filter')(
													$scope.companyList, {
														baseCompany : 1
													})[0];
											$scope.operatingExp.companyCode = foundItemDest.id;

											/*
											 * $timeout(function() {
											 * $('#txtCompanyCode').multiselect('deselectAll',
											 * false);
											 * $('#txtCompanyCode').multiselect('updateButtonText');
											 * $("#txtCompanyCode").multiselect('rebuild');
											 *  }, 2, false);
											 * $("#multiselect-button").addClass("width_100
											 * input-sm line-height-5");
											 */
										}).error(function(datas) {
								});
					};

					$scope.getDropDownList();

					$scope.search = function() {
						$scope.viewOpxReport();
					}
					$scope.$watch('operatingExp.type',
							function(newVal, oldVal) {
								$scope.operatingExp.vesselCode = '1';
								$scope.operatingExp.voyageId = '';
								$scope.operatingExp.serviceCode = '';
								$("#opExpensesGrid").jqGrid('clearGridData');
								$('#opExpensesGrid').jqGrid('footerData',
										'set', {
											accountName : 'Total',
											usdCredit : 0,
											usdDebit : 0
										});

							})

					$scope.viewOpxReport = function() {
						debugger;
						var isValid = true;
						/*
						 * if($scope.operatingExp.type =='VSL' &&
						 * utilsService.isUndefinedOrNull($scope.operatingExp.vesselCode)){
						 * logger.logError('Please select Truck');
						 * isValid=false; }else if($scope.operatingExp.type
						 * =='SER' &&
						 * utilsService.isUndefinedOrNull($scope.operatingExp.serviceCode)){
						 * logger.logError('Please select service');
						 * isValid=false; }else if($scope.operatingExp.type
						 * =='VOY' &&
						 * utilsService.isUndefinedOrNull($scope.operatingExp.voyageId)){
						 * logger.logError('Please select Trip'); isValid=false; }
						 */
						if (isValid) {
							if ($scope.operatingExp.groupCode == null
									|| $scope.operatingExp.groupCode == '') {
								$scope.operatingExp.groupCode = "'40%','50%','60%','70%','80%'";
							}
							$http
									.post(
											$stateParams.tenantid
													+ '/analytical/operatingExpenses/getMainReport',
											$scope.operatingExp)
									.success(
											function(data) {
												console.log(data);
												$("#opExpensesGrid").jqGrid(
														'clearGridData');
												$scope
														.OPExpensesGrid(data.mainReport);

											})
									.error(
											function(data) {
												logger
														.logError("Error Please Try Again");
											});
						}

					};

					$scope.exportExcel = function() {
						var isValid = true;
						/*
						 * if($scope.operatingExp.type =='VSL' &&
						 * utilsService.isUndefinedOrNull($scope.operatingExp.vesselCode)){
						 * logger.logError('Please select Truck');
						 * isValid=false; }else if($scope.operatingExp.type
						 * =='SER' &&
						 * utilsService.isUndefinedOrNull($scope.operatingExp.serviceCode)){
						 * logger.logError('Please select service');
						 * isValid=false; }else if($scope.operatingExp.type
						 * =='VOY' &&
						 * utilsService.isUndefinedOrNull($scope.operatingExp.voyageId)){
						 * logger.logError('Please select Trip'); isValid=false; }
						 */
						if (isValid) {
							$http
									.post(
											$stateParams.tenantid
													+ '/analytical/operatingExpenses/exportExcel',
											$scope.operatingExp)
									.success(
											function(data) {
												if (data.success) {
													debugger;
													$("#TBExport").bind(
															'click',
															function() {
															});
													$('#TBExport')
															.simulateClick(
																	'click');
													logger
															.logSuccess("Exported successfully!");
												} else {
													logger
															.logSuccess("Failed to export");
												}

											})
									.error(
											function(data) {
												logger
														.logError("Error Please Try Again");
											});
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

					$scope.OPExpensesGrid = function(sgListData) {
						debugger;
						var data = [];
						$("#opExpensesGrid")
								.jqGrid(
										{
											data : sgListData,
											datatype : "local",
											multiboxonly : true,
											autowidth : true,
											height : '100%',
											rowNum : 100,
											rowList : [ 100, 200, 300 ],
											multiselect : false,
											loadonce : true,
											gridview : true,
											colNames : [ 'Account Code',
													'Account Name',
													'USD Debit', 'USD Credit',
													'Balance' ],
											colModel : [ {
												name : 'accountNo',
												index : 'accountNo',
												width : 80,
												align : "left",
												searchoptions : {
													sopt : [ 'cn' ]
												},
												classes : 'level_class1'
											}, {
												name : 'accountName',
												index : 'accountName',
												width : 80,
												align : "left",
												searchoptions : {
													sopt : [ 'cn' ]
												},
												hidden : false,
												classes : 'level_class1'
											}, {
												name : 'usdDebit',
												index : 'usdDebit',
												width : 80,
												align : "right",
												searchoptions : {
													sopt : [ 'cn' ]
												},
												hidden : false,
												classes : 'level_class1'
											}, {
												name : 'usdCredit',
												index : 'usdCredit',
												width : 80,
												align : "right",
												searchoptions : {
													sopt : [ 'cn' ]
												},
												hidden : false,
												classes : 'level_class1'
											}, {
												name : 'balance',
												index : 'balance',
												width : 80,
												align : "right",
												searchoptions : {
													sopt : [ 'cn' ]
												},
												hidden : false,
												classes : 'level_class1'
											}, ],
											pager : "#opExpensesPage",
											viewrecords : true,
											ignoreCase : true,
											subGrid : true,
											footerrow : true,
											subGridOptions : {
												"plusicon" : 'ui-icon-plus',
												"minusicon" : 'ui-icon-minus'
											},
											loadComplete : function() {
												var $grid = $('#opExpensesGrid');
												var credit = $grid.jqGrid(
														'getCol', 'usdCredit',
														false, 'sum');
												var debit = $grid.jqGrid(
														'getCol', 'usdDebit',
														false, 'sum');
												credit = credit.toFixed(2);
												debit = debit.toFixed(2);
												var bal = debit - credit;
												$(this)
														.jqGrid(
																'footerData',
																'set',
																{
																	accountName : 'Total',
																	usdCredit : credit,
																	usdDebit : debit,
																	balance : bal
																			.toFixed(2)
																});

											},
											subGridRowExpanded : function(
													subgrid_id, row_id) {
												if($scope.operatingExp.vesselCode=='2'){
													var header = 'AOL';
													var header1 = 'AOD';
												}else{
													var header = 'POL';
													var header1 = 'POD';
												}
												debugger;
												var subgrid_table_id, pager_id;
												subgrid_table_id = subgrid_id
														+ "_t";
												pager_id = "p_"
														+ subgrid_table_id;
												var rowData = jQuery(
														'#opExpensesGrid')
														.jqGrid('getRowData',
																row_id);
												$scope.operatingExp.accountNo = rowData.accountNo;
												var Ahurl = '';
												$("#" + subgrid_id)
														.html(
																"<table id='"
																		+ subgrid_table_id
																		+ "' class='scroll'></table><div id='"
																		+ pager_id
																		+ "' class='scroll'></div>");
												$http
														.post(
																$stateParams.tenantid
																		+ '/analytical/operatingExpenses/getSubReport',
																$scope.operatingExp)
														.success(
																function(data) {
																	if (data.success) {
																		debugger;
																		var tbAHlevelDataList = data.subReport;
																		angular.forEach(tbAHlevelDataList,function(value,key){
																			if(value.vesselCode=='1'){
																				value.vesselCode = 'Sea';
																			}else if(value.vesselCode=='2'){
																				value.vesselCode = 'Air';
																			}
																			value.voyageId = value.voyageId.toString();
																		});
																		$(
																				"#"
																						+ subgrid_table_id)
																				.jqGrid(
																						{
																							datatype : "local",
																							data : tbAHlevelDataList,
																							colNames : [
																									'Voucher Date',
																									'Voucher No',
																									'Description',
																									"Customer Name",
																									'USD Debit',
																									'USD Cr',
																									'Mode',
																									'Job Order No.',
																									header,
																									header1 ],
																							colModel : [
																									{
																										name : 'voucherDate',
																										index : 'voucherDate',
																										width : 100,
																										align : "left",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										classes : 'level_class2'
																									},
																									{
																										name : 'voucherNo',
																										index : 'voucherNo',
																										width : 100,
																										align : "left",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										hidden : false,
																										classes : 'level_class2'
																									},
																									{
																										name : 'description',
																										index : 'description',
																										width : 400,
																										align : "left",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										hidden : false,
																										classes : 'level_class2'
																									},
																									{
																										name : 'payerName',
																										index : 'payerName',
																										width : 400,
																										align : "left",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										hidden : false,
																										classes : 'level_class2'
																									},
																									{
																										name : 'usdDebit',
																										index : 'usdDebit',
																										width : 80,
																										align : "right",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										hidden : false,
																										classes : 'level_class2'
																									},
																									{
																										name : 'usdCredit',
																										index : 'usdCredit',
																										width : 80,
																										align : "right",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										hidden : false,
																										classes : 'level_class2'
																									},
																									{
																										name : 'vesselCode',
																										index : 'vesselCode',
																										width : 100,
																										align : "left",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										hidden : false,
																										classes : 'level_class2'
																									},
																									{
																										name : 'voyageId',
																										index : 'voyageId',
																										width : 100,
																										align : "left",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										hidden : false,
																										classes : 'level_class2'
																									},
																									{
																										name : 'pol',
																										index : 'pol',
																										width : 100,
																										align : "left",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										hidden : false,
																										classes : 'level_class2'
																									},
																									{
																										name : 'pod',
																										index : 'pod',
																										width : 100,
																										align : "left",
																										searchoptions : {
																											sopt : [ 'cn' ]
																										},
																										hidden : false,
																										classes : 'level_class2'
																									}, ],
																							autowidth : true,
																							height : '100%',
																							pager : pager_id,
																							sortname : 'num',
																							sortorder : "asc",
																							// transaction
																							// level
																							subGrid : false,
																							subGridOptions : {
																								"plusicon" : 'ui-icon-plus',
																								"minusicon" : 'ui-icon-minus'
																							},

																						})
																				.jqGrid(
																						'setGridParam',
																						{
																							data : tbAHlevelDataList
																						})
																				.trigger(
																						"reloadGrid");
																	}

																})
														.error(
																function(
																		tbAHlevelDataList) {
																});
											}
										}).jqGrid('setGridParam', {
									data : sgListData
								}).trigger("reloadGrid");
						$("#opExpensesGrid").jqGrid('navGrid',
								'#opExpensesPage', {
									edit : false,
									add : false,
									del : false,
									search : false,
									refresh : false
								});

					}
					$http
							.get(
									$stateParams.tenantid
											+ '/analytical/operatingExpenses/getGroupHeadList')
							.success(
									function(data) {
										$scope.groupHeadList = data;

										$timeout(
												function() {
													var groupCodes = "";
													$("#txtGroupCode")
															.multiselect(
																	{
																		maxHeight : 400,
																		includeSelectAllOption : true,
																		selectAllText : 'Select All',
																		enableFiltering : true,
																		enableCaseInsensitiveFiltering : true,
																		filterPlaceholder : 'Search',
																		onChange : function(
																				element,
																				checked) {

																			if ($scope.operatingExp.objGroupCodes.length > 0) {
																				groupCodes = "";
																				angular
																						.forEach(
																								$scope.operatingExp.objGroupCodes,
																								function(
																										item,
																										key) {
																									if ($scope.operatingExp.objGroupCodes.length > 0) {

																										if ($scope.operatingExp.objGroupCodes[key] != undefined) {

																											var companyCode = item.id;

																											if (groupCodes == "") {
																												groupCodes = "'"
																														+ item.id
																														+ "%'";
																											} else {
																												groupCodes += ",'"
																														+ item.id
																														+ "%'";
																											}
																											$scope.operatingExp.groupCode = groupCodes;
																										}
																									}
																								});
																			} else {
																				$scope.operatingExp.groupCode = '';
																			}
																			console
																					.log($scope.generalLedger.groupCode);
																		}
																	});
													var incomeObj = $filter(
															'filter')
															(
																	$scope.groupHeadList,
																	{
																		id : '40'
																	}, true);
													var expObj = $filter(
															'filter')
															(
																	$scope.groupHeadList,
																	{
																		id : '60'
																	}, true);
													var cosObj = $filter(
															'filter')
															(
																	$scope.groupHeadList,
																	{
																		id : '50'
																	}, true);
													var orObj = $filter(
															'filter')
															(
																	$scope.groupHeadList,
																	{
																		id : '70'
																	}, true);
													var oepObj = $filter(
															'filter')
															(
																	$scope.groupHeadList,
																	{
																		id : '80'
																	}, true);
													$("#txtGroupCode")
															.parent()
															.find(
																	'.btn-group #multiselect-button')
															.addClass(
																	'width_100 input-sm line-height-5');
													$("#txtGroupCode")
															.find(
																	"option[label='"
																			+ incomeObj[0].text
																			+ "']")
															.prop("selected",
																	"selected");
													$("#txtGroupCode")
															.find(
																	"option[label='"
																			+ expObj[0].text
																			+ "']")
															.prop("selected",
																	"selected");
													$("#txtGroupCode")
															.find(
																	"option[label='"
																			+ cosObj[0].text
																			+ "']")
															.prop("selected",
																	"selected");
													$("#txtGroupCode")
															.find(
																	"option[label='"
																			+ orObj[0].text
																			+ "']")
															.prop("selected",
																	"selected");
													$("#txtGroupCode")
															.find(
																	"option[label='"
																			+ oepObj[0].text
																			+ "']")
															.prop("selected",
																	"selected");
													// $("#txtGroupCode").find("option").prop('selected','selected')
													groupCodes = "'40%','50%','60%','70%','80%'";
													$scope.operatingExp.groupCode = groupCodes;
													$("#txtGroupCode")
															.multiselect(
																	"refresh");
												}, 2, false);
									}).error(function(data) {
							});
					$scope.$watch('operatingExp.vesselCode',
							function(newVal, oldVal) {
						$http
						.get(
								$stateParams.tenantid
										+ '/analytical/operatingExpenses/add1?company=' +newVal)
						.success(
								function(datas) {
									$scope.podList = datas;
									$scope.polList = datas;

									$timeout(
											function() { // You might
															// need this
															// timeout to be
															// sure its run
															// after DOM
															// render.
												$("#pod")
														.multiselect(
																{
																	maxHeight : 200,
																	includeSelectAllOption : true,
																	selectAllText : 'Select All',
																	enableFiltering : true,
																	enableCaseInsensitiveFiltering : true,
																	filterPlaceholder : 'Search',
																	onChange : function(
																			element,
																			checked) {
																		console
																				.log(element);
																		var ct = "";
																		if ($scope.podList.length > 0) {
																			console
																					.log($scope.operatingExp.lpod);
																			$scope.operatingExp.pod = '';
																			angular
																					.forEach(
																							$scope.operatingExp.lpod,
																							function(
																									item,
																									key) {
																								console
																										.log("pod")
																								console
																										.log(item);
																								if (ct == "") {
																									ct = "'"
																											+ item.id
																											+ "'";
																								} else {
																									ct += ",'"
																											+ item.id
																											+ "'";
																								}
																								$scope.operatingExp.pod = ct;
																								console
																										.log("pod selected")
																								console
																										.log($scope.operatingExp.pod)
																							});
																		}

																		else {
																			$scope.podList = [];
																			$scope.podList = 'Select';
																		}
																	}
																});
												$("#pod")
														.parent()
														.find(
																'.btn-group #multiselect-button')
														.addClass(
																'width_100 input-sm line-height-5');
											}, 2, false);

									// pol list

									$timeout(
											function() { // You might
															// need this
															// timeout to be
															// sure its run
															// after DOM
															// render.
												$("#pol")
														.multiselect(
																{
																	maxHeight : 200,
																	includeSelectAllOption : true,
																	selectAllText : 'Select All',
																	enableFiltering : true,
																	enableCaseInsensitiveFiltering : true,
																	filterPlaceholder : 'Search',
																	onChange : function(
																			element,
																			checked) {
																		console
																				.log(element);
																		var ct = "";
																		if ($scope.polList.length > 0) {
																			console
																					.log($scope.operatingExp.lpol);
																			$scope.operatingExp.pol = '';
																			angular
																					.forEach(
																							$scope.operatingExp.lpol,
																							function(
																									item,
																									key) {
																								console
																										.log("pol")
																								console
																										.log(item);
																								if (ct == "") {
																									ct = "'"
																											+ item.id
																											+ "'";
																								} else {
																									ct += ",'"
																											+ item.id
																											+ "'";
																								}
																								$scope.operatingExp.pol = ct;
																								console
																										.log(" pol selected")
																								console
																										.log($scope.operatingExp.pol)
																							});
																		}

																		else {
																			$scope.polList = [];
																			$scope.polList = 'Select';
																		}
																	}
																});
												$("#pol")
														.parent()
														.find(
																'.btn-group #multiselect-button')
														.addClass(
																'width_100 input-sm line-height-5');
											}, 2, false);

								});


							})
					$http
							.get(
									$stateParams.tenantid
											+ '/analytical/operatingExpenses/add1?company=' + $scope.operatingExp.vesselCode)
							.success(
									function(datas) {
										$scope.podList = datas;
										$scope.polList = datas;

										$timeout(
												function() { // You might
																// need this
																// timeout to be
																// sure its run
																// after DOM
																// render.
													$("#pod")
															.multiselect(
																	{
																		maxHeight : 200,
																		includeSelectAllOption : true,
																		selectAllText : 'Select All',
																		enableFiltering : true,
																		enableCaseInsensitiveFiltering : true,
																		filterPlaceholder : 'Search',
																		onChange : function(
																				element,
																				checked) {
																			console
																					.log(element);
																			var ct = "";
																			if ($scope.podList.length > 0) {
																				console
																						.log($scope.operatingExp.lpod);
																				$scope.operatingExp.pod = '';
																				angular
																						.forEach(
																								$scope.operatingExp.lpod,
																								function(
																										item,
																										key) {
																									console
																											.log("pod")
																									console
																											.log(item);
																									if (ct == "") {
																										ct = "'"
																												+ item.id
																												+ "'";
																									} else {
																										ct += ",'"
																												+ item.id
																												+ "'";
																									}
																									$scope.operatingExp.pod = ct;
																									console
																											.log("pod selected")
																									console
																											.log($scope.operatingExp.pod)
																								});
																			}

																			else {
																				$scope.podList = [];
																				$scope.podList = 'Select';
																			}
																		}
																	});
													$("#pod")
															.parent()
															.find(
																	'.btn-group #multiselect-button')
															.addClass(
																	'width_100 input-sm line-height-5');
												}, 2, false);

										// pol list

										$timeout(
												function() { // You might
																// need this
																// timeout to be
																// sure its run
																// after DOM
																// render.
													$("#pol")
															.multiselect(
																	{
																		maxHeight : 200,
																		includeSelectAllOption : true,
																		selectAllText : 'Select All',
																		enableFiltering : true,
																		enableCaseInsensitiveFiltering : true,
																		filterPlaceholder : 'Search',
																		onChange : function(
																				element,
																				checked) {
																			console
																					.log(element);
																			var ct = "";
																			if ($scope.polList.length > 0) {
																				console
																						.log($scope.operatingExp.lpol);
																				$scope.operatingExp.pol = '';
																				angular
																						.forEach(
																								$scope.operatingExp.lpol,
																								function(
																										item,
																										key) {
																									console
																											.log("pol")
																									console
																											.log(item);
																									if (ct == "") {
																										ct = "'"
																												+ item.id
																												+ "'";
																									} else {
																										ct += ",'"
																												+ item.id
																												+ "'";
																									}
																									$scope.operatingExp.pol = ct;
																									console
																											.log(" pol selected")
																									console
																											.log($scope.operatingExp.pol)
																								});
																			}

																			else {
																				$scope.polList = [];
																				$scope.polList = 'Select';
																			}
																		}
																	});
													$("#pol")
															.parent()
															.find(
																	'.btn-group #multiselect-button')
															.addClass(
																	'width_100 input-sm line-height-5');
												}, 2, false);

									});

				});
