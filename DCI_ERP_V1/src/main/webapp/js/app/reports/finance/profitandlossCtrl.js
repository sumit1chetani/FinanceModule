'use strict';
app
		.controller(
				'profitAndLossController',
				function($scope, $rootScope, $http, logger, $log, ngDialog,
						$modal, $window, $location, $filter, $timeout,
						$stateParams) {
					$scope.pl = {
						fromDate : '',
						toDate : '',
						company : '',
						companyName : '',
						ntloss : '',
						ntprofit:''
					}
					$scope.malaysia = false;
					$scope.viewHor = false;
					$scope.viewVer = true;
					var companyCode = $("#companyCode").val();

					if (companyCode == 'C0001') {
						$scope.pl.companyName = 'MUM';
					} else if (companyCode == 'C0002') {
						$scope.pl.companyName = 'SIN';
					} else if (companyCode == 'C0003') {
						$scope.pl.companyName = 'AMD';
					} else if (companyCode == 'C0005') {
						$scope.pl.companyName = 'DEL';
					} else if (companyCode == 'C0006') {
						$scope.pl.companyName = 'LUD';
					} else if (companyCode == 'C0007') {
						$scope.pl.companyName = 'MUN';
					} else if (companyCode == 'C0008') {
						$scope.pl.companyName = 'PUN';
					}

					$('#pl_fromDate').datetimepicker({
						format : 'DD/MM/YYYY',
						pickTime : false
					});

					$('#pl_toDate').datetimepicker({
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
										$scope.pl.company = foundItemDest.id;
									}).error(function(datas) {
							});

					/*
					 * $http.post( $stateParams.tenantid +
					 * '/app/profitloss/generatePLReportNewVer',
					 * $scope.pl).success(function(datas) { debugger;
					 * 
					 * $scope.profitLoss = datas; console.log(datas);
					 * 
					 * }).error(function(datas) { });
					 */

					$http
							.post(
									$stateParams.tenantid
											+ '/app/profitloss/generatePLReportNewHor',
									$scope.pl)
							.success(
									function(datas) {
										debugger;

										$scope.profitLoss = datas;

										if (datas.dSalesRevenueTotal > (-datas.dCostOfSalesTotal)) {
											$scope.viewLeft = true;
										} else {
											$scope.viewRight = true;
										}

										if (datas.dSalesRevenueTotal == 0
												&& datas.dCostOfSalesTotal == 0) {
											$scope.viewLeft = true;
										}

										if (datas.dotherExpense == undefined) {
											datas.dotherExpense = 0;

										}
										if (datas.dCommunicationCost == undefined) {
											datas.dCommunicationCost = 0;

										}

										var amoount = (-datas.dpersonalCost)
												+ (-datas.dsalesCost)
												+ (-datas.dtravellingcost)
												+ (-datas.dcommunicationCost)
												+ (-datas.dRentCost)
												+ (-datas.dAdminExpense)
												+ (-datas.dfinanceCost)
												+ (-datas.dconveyencecost);

										if (amoount > (-datas.dOtherIncome)) {
											$scope.viewLeft = true;
										} else if (amoount < (-datas.dOtherIncome)) {
											$scope.viewRight = true;
										} else {
											$scope.viewLeft = true;
										}

										var temp=-(((-datas.dtravellingcost)
												+ (-datas.dsalesCost)
												+ (-datas.dpersonalCost)
												+ (-datas.dfinanceCost)
												+ (-datas.dcommunicationCost)
												+ (-datas.dAdminExpense)
												+ (-datas.dRentCost) + (-datas.dconveyencecost)))
										
										var temp1 = (datas.dOtherIncome + (datas.dSalesRevenueTotal) - (datas.dCostOfSalesTotal));
										
										
										if(temp1>-temp){
											$scope.pl.ntFlag=true;
										}else{
											$scope.pl.ntFlag=false;
										}
										
										var ntloss = temp1+temp;
										
										
										
										
										
										
										/*var ntloss = (((datas.dtravellingcost)
												+ (datas.dsalesCost)
												+ (datas.dpersonalCost)
												+ (datas.dfinanceCost)
												+ (datas.dcommunicationCost)
												+ (datas.dAdminExpense)
												+ (datas.dRentCost) + (datas.dconveyencecost)) + (datas.dOtherIncome + (datas.dSalesRevenueTotal - (datas.dCostOfSalesTotal))))*/

									//	alert("Net Loss :" + ntloss);

										var string = ntloss.toString(); 
										var substring = "-";
										if (string.indexOf(substring) !== -1) {
											$scope.pl.ntloss = (-ntloss);
										} else {
											$scope.pl.ntloss = (ntloss);
										}

										//alert("Loss :" + $scop.pl.ntloss);

										
										
										var ntprofit =
											((-datas.dOtherIncome))-
											((((-datas.dtravellingcost)+(-datas.dsalesCost)+(-datas.dpersonalCost)+(-datas.dfinanceCost)+
											(-datas.dcommunicationCost)
											+(-datas.dAdminExpense)+(-datas.dRentCost) +
											(-datas.dconveyencecost))  +  (-((-datas.dCostOfSalesTotal)-datas.dSalesRevenueTotal))))
											
											
											var stringprft = ntprofit.toString(); 
											var substring = "-";
											if (stringprft.indexOf(substring) !== -1) {
												$scope.pl.ntprofit = (-ntprofit);
											} else {
												$scope.pl.ntprofit = (ntprofit);
											}

											
											/*if(datas.dtravellingcost>0){
											$scope.profitLoss.dtravellingcost=-datas.dtravellingcost;
											}if(datas.dcommunicationCost>0){
												$scope.profitLoss.dcommunicationCost=-datas.dcommunicationCost;
											}if(datas.dsalesCost>0){
												$scope.profitLoss.dsalesCost=-datas.dsalesCost;
											}if(datas.dpersonalCost>0){
												$scope.profitLoss.dpersonalCost=-datas.dpersonalCost;
											}if(datas.dfinanceCost>0){
												$scope.profitLoss.dfinanceCost=-datas.dfinanceCost;
											}if(datas.dAdminExpense>0){
												$scope.profitLoss.dAdminExpense=-datas.dAdminExpense;
											}if(datas.dconveyencecost>0){
												$scope.profitLoss.dconveyencecost=-datas.dconveyencecost;
											}if(datas.dRentCost>0){
												$scope.profitLoss.dRentCost=-datas.dRentCost;
											}*/
											
			
										console.log(datas);
									}).error(function(datas) {
							});

					$scope.viewProfitLoss = function() {
						$scope.pl.fromDate = $('#fromDate').val();
						$scope.pl.toDate = $('#toDate').val();

						$http.post(
								$stateParams.tenantid
										+ '/app/profitloss/generatePLReport',
								$scope.pl).success(function(datas) {
							debugger;
							$scope.populateProfitAndLossGrid(datas);
							console.log(datas);
						}).error(function(datas) {
						});
					}

					$scope.viewProfitLossNewVer = function(pl) {
						if(pl!='All'){
						$scope.viewVer = true;
						$scope.viewHor = false;
						$scope.pl.fromDate = $('#fromDate').val();
						$scope.pl.toDate = $('#toDate').val();

						if (pl == 'C0001') {
							$scope.pl.companyName = 'COK';
						} else if (pl == 'C0002') {
							$scope.pl.companyName = 'MBKGOA';
						} else if (pl == 'C0003') {
							$scope.pl.companyName = 'MBKTUT';
						}  else if (pl == 'C0004') {
							$scope.pl.companyName = 'MBKMUN';
						} else if (pl == 'C0005') {
							$scope.pl.companyName = 'IXE';
						} else if (pl == 'C0006') {
							$scope.pl.companyName = 'MBKMAA';
						} else if (pl == 'C0007') {
							$scope.pl.companyName = 'HZA';
						} else if (pl == 'C0008') {
							$scope.pl.companyName = 'PUN';
						}

						/*
						 * if($scope.companyCodes.length>0){
						 * $scope.pl.company=$scope.companyCodes.join(","); }
						 */
						$http
								.post(
										$stateParams.tenantid
												+ '/app/profitloss/generatePLReportNewHor',
										$scope.pl)
								.success(
										function(datas) {
											debugger;

											$scope.profitLoss = datas;

											if (datas.dSalesRevenueTotal > (-datas.dCostOfSalesTotal)) {
												$scope.viewLeft = true;
											} else {
												$scope.viewRight = true;
											}

											if (datas.dSalesRevenueTotal == 0
													&& datas.dCostOfSalesTotal == 0) {
												$scope.viewLeft = true;
											}

											if (datas.dotherExpense == undefined) {
												datas.dotherExpense = 0;

											}
											if (datas.dCommunicationCost == undefined) {
												datas.dCommunicationCost = 0;

											}

											var amoount = (-datas.dpersonalCost)
													+ (-datas.dsalesCost)
													+ (-datas.dtravellingcost)
													+ (-datas.dcommunicationCost)
													+ (-datas.dRentCost)
													+ (-datas.dAdminExpense)
													+ (-datas.dfinanceCost)
													+ (-datas.dconveyencecost);

											if (amoount > (-datas.dOtherIncome)) {
												$scope.viewLeft = true;
											} else if (amoount < (-datas.dOtherIncome)) {
												$scope.viewRight = true;
											} else {
												$scope.viewLeft = true;
											}
									
											var temp=-(((-datas.dtravellingcost)
													+ (-datas.dsalesCost)
													+ (-datas.dpersonalCost)
													+ (-datas.dfinanceCost)
													+ (-datas.dcommunicationCost)
													+ (-datas.dAdminExpense)
													+ (-datas.dRentCost) + (-datas.dconveyencecost)))
											
											var temp1 = (datas.dOtherIncome + (datas.dSalesRevenueTotal) - (datas.dCostOfSalesTotal));
											
											
											if(temp1>-temp){
												$scope.pl.ntFlag=true;
											}else{
												$scope.pl.ntFlag=false;
											}
											
											var ntloss = temp1+temp;

										//	alert("Net Loss :" + ntloss);

											var string = ntloss.toString(); 
											var substring = "-";
											if (string.indexOf(substring) !== -1) {
												$scope.pl.ntloss = (-ntloss);
											} else {
												$scope.pl.ntloss = (ntloss);
											}

											
											
											
											var ntprofit =
											((-datas.dOtherIncome))-
											((((-datas.dtravellingcost)+(-datas.dsalesCost)+(-datas.dpersonalCost)+(-datas.dfinanceCost)+
											(-datas.dcommunicationCost)
											+(-datas.dAdminExpense)+(-datas.dRentCost) +
											(-datas.dconveyencecost))  +  (-((-datas.dCostOfSalesTotal)-datas.dSalesRevenueTotal))))
											
											
											var stringprft = ntprofit.toString(); 
											var substring = "-";
											if (stringprft.indexOf(substring) !== -1) {
												$scope.pl.ntprofit = (-ntprofit);
											} else {
												$scope.pl.ntprofit = (ntprofit);
											}

											/*if(datas.dtravellingcost>0){
												$scope.profitLoss.dtravellingcost=-datas.dtravellingcost;
												}if(datas.dcommunicationCost>0){
													$scope.profitLoss.dcommunicationCost=-datas.dcommunicationCost;
												}if(datas.dsalesCost>0){
													$scope.profitLoss.dsalesCost=-datas.dsalesCost;
												}if(datas.dpersonalCost>0){
													$scope.profitLoss.dpersonalCost=-datas.dpersonalCost;
												}if(datas.dfinanceCost>0){
													$scope.profitLoss.dfinanceCost=-datas.dfinanceCost;
												}if(datas.dAdminExpense>0){
													$scope.profitLoss.dAdminExpense=-datas.dAdminExpense;
												}if(datas.dconveyencecost>0){
													$scope.profitLoss.dconveyencecost=-datas.dconveyencecost;
												}if(datas.dRentCost>0){
													$scope.profitLoss.dRentCost=-datas.dRentCost;
												}*/
											
											
											console.log(datas);
										}).error(function(datas) {
								});
					}else{
						$scope.profitLoss='';
						$scope.pl.companyName='';
						$scope.pl.ntprofit='';
					}}
					$scope.view = false;

					$scope.viewProfitLossNewhor = function(pl) {
						$scope.viewVer = false;
						$scope.viewHor = true;
						$scope.pl.fromDate = $('#fromDate').val();
						$scope.pl.toDate = $('#toDate').val();

						/*
						 * if($scope.companyCodes.length>0){
						 * $scope.pl.company=$scope.companyCodes.join(","); }
						 */
						$http
								.post(
										$stateParams.tenantid
												+ '/app/profitloss/generatePLReportNewVer',
										$scope.pl).success(function(datas) {
									debugger;

									$scope.profitLoss = datas;
									console.log(datas);

								}).error(function(datas) {
								});
					}

					$scope.exportPLExcel = function() {
						//$scope.pl.fromDate = $('#fromDate').val();
						//$scope.pl.toDate = $('#toDate').val();

						/*
						 * if($scope.companyCodes.length>0){
						 * $scope.pl.company=$scope.companyCodes.join(","); }
						 */

						$http.post(
								$stateParams.tenantid
										+ '/app/profitloss/exportPLExcel',
								$scope.pl).success(function(data) {
							if (data) {
								debugger;
								$("#PLExport").bind('click', function() {
								});
								$('#PLExport').simulateClick('click');
								logger.logSuccess("Exported successfully!");
							} else {
								logger.logSuccess("Failed to export");
							}
						}).error(function(datas) {
						});
					}

					$scope.exportPLExcelVer = function() {
						$scope.pl.fromDate = $('#fromDate').val();
						$scope.pl.toDate = $('#toDate').val();

						/*
						 * if($scope.companyCodes.length>0){
						 * $scope.pl.company=$scope.companyCodes.join(","); }
						 */

						$http.post(
								$stateParams.tenantid
										+ '/app/profitloss/exportPLExcelHor',
								$scope.pl).success(function(data) {
							if (data) {
								debugger;
								$("#PLExport").bind('click', function() {
								});
								$('#PLExport').simulateClick('click');
								logger.logSuccess("Exported successfully!");
							} else {
								logger.logSuccess("Failed to export");
							}
						}).error(function(datas) {
						});
					}

					$scope.printpandl = function() {
						$scope.pl.fromDate = $('#fromDate').val();
						$scope.pl.toDate = $('#toDate').val();
						// if($scope.staffLedger.fromDate!="" &&
						// $scope.staffLedger.toDate!=""){
						$http
								.post(
										$stateParams.tenantid
												+ '/app/profitloss/print',
										$scope.pl)
								.success(
										function(data) {
											var mywindow = window
													.open(
															'',
															'InterAfrica',
															'height=400,width=750,top=100,left=100,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
											mywindow.document.write(data);
											mywindow.document.close(); // necessary
											// for
											// IE >=
											// 10
											mywindow.focus(); // necessary for
											// IE >= 10
											mywindow.print();
										}).error(function(data) {
									logger.logError("Error Please Try Again");
								});
						// }
						/*
						 * else{ logger.logError("Please Select Date Range"); }
						 */

					}/*
						 * $scope.printpandl = function() { $scope.pl.fromDate =
						 * $('#fromDate').val(); $scope.pl.toDate =
						 * $('#toDate').val(); var url =
						 * $stateParams.tenantid+'/app/profitloss/print'; var
						 * wnd = $window.open(url, 'Shipping',
						 * 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
						 * wnd.print(); }
						 */

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

					/*
					 * $scope.populateProfitAndLossGrid = function(cListData){
					 * debugger; $("#plReportGrid").jqGrid({ data: cListData,
					 * datatype: "local", multiboxonly: true, autowidth: true,
					 * height: '100%', rowList: [10,20,30], multiselect: true,
					 * loadonce: true, gridview:true, colNames:['Group Head
					 * Code','Group Head Name','Debit','Credit'], colModel:[
					 * {name:'groupHeadCode',index:'groupHeadCode', width:350,
					 * align:"left",searchoptions:{sopt:['cn']}},
					 * {name:'groupHeadName',index:'groupHeadName', width:500,
					 * align:"left",searchoptions:{sopt:['cn']},hidden:false},
					 * {name:'debitAmount',index:'debitAmount', width:350,
					 * searchoptions:{sopt:['cn']},hidden:false},
					 * {name:'creditAmount',index:'creditAmount', width:350,
					 * searchoptions:{sopt:['cn']},hidden:false} ], pager:
					 * "#plReportGridPage", viewrecords: true, //caption:
					 * 'Income and Expenditure List', ignoreCase: true, subGrid: true,
					 * subGridOptions: { "plusicon" : 'ui-icon-plus',
					 * "minusicon" : 'ui-icon-minus' "openicon" : 'fa
					 * fa-plus-circle', "reloadOnExpand" : true },
					 * 
					 * 
					 * footerrow: true,
					 * 
					 * subGridRowExpanded: function(subgrid_id, row_id) { var
					 * subgrid_table_id, pager_id; subgrid_table_id =
					 * subgrid_id+"_t"; pager_id = "p_"+subgrid_table_id; var
					 * rowData = jQuery('#plReportGrid').jqGrid ('getRowData',
					 * row_id); console.log("rowData:::::::::::SUB
					 * GRID::::::::"); console.log(rowData);
					 * if(rowData.groupHeadCode == 'E')
					 * $scope.pl.groupHeadCode='600%' else
					 * $scope.pl.groupHeadCode='400%' $("#"+subgrid_id).html("<table
					 * id='"+subgrid_table_id+"' class='scroll'></table><div
					 * id='"+pager_id+"' class='scroll'></div>");
					 * $http.post($stateParams.tenantid+'/app/profitloss/generatePLReportDtl',$scope.pl).success(function(dtlData) {
					 * debugger; $("#"+subgrid_table_id).jqGrid({ datatype:
					 * "local", data: dtlData, colNames:['Sub group Code','Sub
					 * group Name','Debit','Credit'], colModel:[
					 * {name:'groupHeadCode',index:'groupHeadCode', width:50,
					 * align:"left",searchoptions:{sopt:['cn']}},
					 * {name:'groupHeadName',index:'groupHeadName', width:150,
					 * align:"left",searchoptions:{sopt:['cn']},hidden:false},
					 * {name:'debitAmount',index:'debitAmount', width:50,
					 * searchoptions:{sopt:['cn']},hidden:false},
					 * {name:'creditAmount',index:'creditAmount', width:50,
					 * searchoptions:{sopt:['cn']},hidden:false} ], autowidth:
					 * true, height: '100%', pager: pager_id, sortname: 'num',
					 * sortorder: "asc", subGrid: true, subGridOptions: {
					 * "plusicon" : 'ui-icon-plus', "minusicon" :
					 * 'ui-icon-minus' "openicon" : 'fa fa-plus-circle',
					 * "reloadOnExpand" : true },
					 * 
					 * subGridRowExpanded: function(subgridah_id, rowah_id) {
					 * debugger; var subgridah_table_id, pagerah_id;
					 * subgridah_table_id = subgridah_id+"_t"; pagerah_id =
					 * "p_"+subgridah_table_id; var rowData =
					 * jQuery('#'+subgrid_table_id).jqGrid ('getRowData',
					 * rowah_id); console.log("rowData:::::::::::AH SUB
					 * GRID::::::::"); console.log(rowData);
					 * $scope.pl.groupHeadCode=rowData.groupHeadCode;
					 * console.log($scope.pl); $("#"+subgridah_id).html("<table
					 * id='"+subgridah_table_id+"' class='scroll'></table><div
					 * id='"+pagerah_id+"' class='scroll'></div>");
					 * $http.post($stateParams.tenantid+'/app/profitloss/generatePLReportAHDtl',$scope.pl).success(function(dtlahData) {
					 * debugger; $("#"+subgridah_table_id).jqGrid({ datatype:
					 * "local", data: dtlahData, colNames:['Account Head
					 * Code','Account Head Name','Debit','Credit'], colModel:[
					 * {name:'groupHeadCode',index:'groupHeadCode', width:50,
					 * align:"left",searchoptions:{sopt:['cn']}},
					 * {name:'groupHeadName',index:'groupHeadName', width:150,
					 * align:"left",searchoptions:{sopt:['cn']},hidden:false},
					 * {name:'debitAmount',index:'debitAmount', width:50,
					 * searchoptions:{sopt:['cn']},hidden:false},
					 * {name:'creditAmount',index:'creditAmount', width:50,
					 * searchoptions:{sopt:['cn']},hidden:false} ], autowidth:
					 * true, height: '100%', pager: pager_id, sortname: 'num',
					 * sortorder: "asc", }); }).error(function(dtlData) { }); }
					 * });
					 * 
					 * 
					 * }).error(function(dtlData) { }); } }); }
					 */
					$scope.Click=function(id) 
			        {
			        	$rootScope.id=id;
			        	$scope.id=$rootScope.id;
			        	if($scope.pl.groupCode!=null&&$scope.pl.groupCode!=""&&$scope.pl.groupCode==undefined){
			        		$scope.groupCode=$scope.pl.groupCode;
			        	}
			        	if($scope.pl.company!=null&&$scope.pl.company!=""){
			        		$scope.companyId = $scope.pl.company;	
			        	}else{
			        		$scope.companyId="ALL";
			        	}
			        	if($scope.pl.fromDate!=null&&$scope.pl.fromDate!="")
			        		{
			        		$scope.fromDate =$scope.pl.fromDate;
			        		}
			        	else{
			        		$scope.fromDate="31/03/2018";
			        	}
			        	if($scope.pl.toDate!=null&&$scope.pl.toDate!=""&&$scope.pl.toDate!=undefined)
			        		{
			        		$scope.toDate = $scope.pl.toDate ;
			        		}else{
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
								 $scope.toDate=todate;
			        		}
			        //	$scope.subGroupCode = $rootScope.id;
			        	 var url = $stateParams.tenantid+'/app/subgroupacct/list2?subgroup=' + id ;
			             $http.get(url).success(function(data) {
			                 console.log("****datasubgroup***");
			                 console.log(data);
			                 $scope.subGroupCode=data.objSubGroupAccountBeanBean[0].grpHeadCode;
			                 $scope.pl.groupCode=data.objSubGroupAccountBeanBean[0].grpHeadCode;
			                 var url='/#/'+$stateParams.tenantid+ '/reports/finance/generalLedgersubgroup?companyId='+$scope.companyId+'&subGroupCode='+$scope.subGroupCode+'&groupCode='+$scope.groupCode+'&id='+$scope.id+'&fromDate='+$scope.fromDate+'&toDate='+$scope.toDate;
			                 window.open(url);
			             }).error(function(data) {
			                 logger.logError("Error Please Try Again");
			             });
			        
			        }
					
				//
					$scope.AccountClick=function(id) 
			        {
			        	$rootScope.id=id;
			        	var id1=id;
			        	var acccode = (id.split(' ')[0]);
			        	if($scope.pl.groupCode!=null&&$scope.pl.groupCode!=""&&$scope.pl.groupCode==undefined){
			        		$scope.groupCode=$scope.pl.groupCode;
			        	}
			        	if($scope.pl.company!=null&&$scope.pl.company!=""){
			        		$scope.companyId = $scope.pl.company;	
			        	}else{
			        		$scope.companyId="ALL";
			        	}
			        	if($scope.pl.fromDate!=null&&$scope.pl.fromDate!="")
			        		{
			        		$scope.fromDate =$scope.pl.fromDate;
			        		}
			        	else{
			        		$scope.fromDate="31/03/2018";
			        	}
			        	if($scope.pl.toDate!=null&&$scope.pl.toDate!=""&&$scope.pl.toDate!=undefined)
			        		{
			        		$scope.toDate = $scope.pl.toDate ;
			        		}else{
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
								 $scope.toDate=todate;
			        		}
			        	$scope.subGroupCode=acccode;
			        	$scope.groupCode=acccode;
			        
			        	var url='/#/'+$stateParams.tenantid+ '/reports/finance/generalLedgeraccountgroup?companyId='+$scope.companyId+'&subGroupCode='+$scope.subGroupCode+'&groupCode='+$scope.groupCode+'&id='+$scope.id+'&fromDate='+$scope.fromDate+'&toDate='+$scope.toDate;
		                 window.open(url);
			        	/* var url = $stateParams.tenantid+'/app/subgroupacct/list2?subgroup=' + id ;
			             $http.get(url).success(function(data) {
			                 console.log("****datasubgroup***");
			                 console.log(data);
			                 $scope.subGroupCode=data.objSubGroupAccountBeanBean[0].grpHeadCode;
			                 $scope.pl.groupCode=data.objSubGroupAccountBeanBean[0].grpHeadCode;
			                 
			             }).error(function(data) {
			                 logger.logError("Error Please Try Again");
			             });*/
			        
			        }
				});