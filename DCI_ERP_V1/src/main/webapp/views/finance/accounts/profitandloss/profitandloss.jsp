<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<head>
<style>
.main_head {
	/* background-color: #c3e3ef !important; */
	color: black;
	padding: 10px 15px;
	border-bottom: 1px solid transparent;
	border-radius: 2px 2px 0 0;
}

.solid {
	border-style: solid;
}

.data-table {
	margin-bottom: 7px !important;
}


.card{ background-color: #fff; border: 1px solid transparent; border-radius: 6px; }
.card > .card-link{ color: #333; }
.card > .card-link:hover{  text-decoration: none; }
.card > .card-link .card-img img{ border-radius: 6px 6px 0 0; }
.card .card-img{ position: relative; padding: 0; display: table; }
.card .card-img .card-caption{
  position: absolute;
  right: 0;
  bottom: 16px;
  left: 0;
}
.card .card-body{ display: table; width: 100%; padding: 12px; }
.card .card-header{ border-radius: 6px 6px 0 0; padding: 8px; }
.card .card-footer{ border-radius: 0 0 6px 6px; padding: 8px; }
.card .card-left{ position: relative; float: left; padding: 0 0 8px 0; }
.card .card-right{ position: relative; float: left; padding: 8px 0 0 0; }
.card .card-body h1:first-child,
.card .card-body h2:first-child,
.card .card-body h3:first-child, 
.card .card-body h4:first-child,
.card .card-body .h1,
.card .card-body .h2,
.card .card-body .h3, 
.card .card-body .h4{ margin-top: 0; }
.card .card-body .heading{ display: block;  }
.card .card-body .heading:last-child{ margin-bottom: 0; }

.card .card-body .lead{ text-align: center; }

@media( min-width: 768px ){
  .card .card-left{ float: left; padding: 0 8px 0 0; }
  .card .card-right{ float: left; padding: 0 0 0 8px; }
    
  .card .card-4-8 .card-left{ width: 33.33333333%; }
  .card .card-4-8 .card-right{ width: 66.66666667%; }

  .card .card-5-7 .card-left{ width: 41.66666667%; }
  .card .card-5-7 .card-right{ width: 58.33333333%; }
  
  .card .card-6-6 .card-left{ width: 50%; }
  .card .card-6-6 .card-right{ width: 50%; }
  
  .card .card-7-5 .card-left{ width: 58.33333333%; }
  .card .card-7-5 .card-right{ width: 41.66666667%; }
  
  .card .card-8-4 .card-left{ width: 66.66666667%; }
  .card .card-8-4 .card-right{ width: 33.33333333%; }
}

/* -- default theme ------ */
.card-default{ 
  border-color: #ddd;
  background-color: #fff;
  margin-bottom: 24px;
}
.card-default > .card-header,
.card-default > .card-footer{ color: #333; background-color: #ddd; }
.card-default > .card-header{ border-bottom: 1px solid #ddd; padding: 8px; }
.card-default > .card-footer{ border-top: 1px solid #ddd; padding: 8px; }
.card-default > .card-body{  }
.card-default > .card-img:first-child img{ border-radius: 6px 6px 0 0; }
.card-default > .card-left{ padding-right: 4px; }
.card-default > .card-right{ padding-left: 4px; }
.card-default p:last-child{ margin-bottom: 0; }
.card-default .card-caption { color: #fff; text-align: center; text-transform: uppercase; }

</style>


</head>
<security:authentication var="user" property="principal" />
<div>
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div class="panel panel-default panel-default-list"
					st-table="displayedCollection" st-safe-src="rowCollection">
					<%@include file="/views/templates/panel-header-form.jsp"%>
					<input type="hidden" value="${form_code}" id="form_code_id">
					<div class="panel panel-default">
						<div class="form-body form-horizontal">
							<div class="row container-fluid m-t-sm">
								<form name="trialBalanceForm" class="form-horizontal">
									<div class="row">
										<div class="col-sm-12 col-md-12 col-lg-12">
											<!-- <div class="col-sm-4 col-md-4 col-lg-4">
                                                    <fieldset>
                                                            <div class="form-group">
                                                                    <label class="col-md-5 control-label"> Company
                                                                            <span style="color: red;">*</span>
                                                                    </label>
                                                                    <div class="col-md-7">
                                                                            <selectivity list="companyList" property="pl.company" id="company" object="companyCode"></selectivity>
                                                                    </div>
                                                            </div>
                                                    </fieldset>
                                            </div> -->
											<div class="col-sm-12 col-md-3 col-lg-3">
												<fieldset>
													<div class="form-group">
														<label class="col-md-5 control-label">
															Organization <span style="color: red;">*</span>
														</label>
														<div class="col-md-7">
															<selectivity list="companyList" ng-model="pl.company"
																property="pl.company" id="company" object="company"
																name="organization"></selectivity>

															<!-- 											 <select id="txtCompanyCode" multiple="multiple" name="multiselect[]" ng-model="companyCodes"
                                                                                         ng-options="option.id as option.text for option in companyList" data-dropdownmultiselect>    
                                                                                           <option data-ng-repeat="option in companyList" value="{{getOptionId(option)}}" 
                                                                                           ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
                                                                                        </select> -->
														</div>
													</div>

												</fieldset>
											</div>

											<div class="col-sm-12 col-md-3 col-lg-3">
												<fieldset>
													<div class="form-group">
														<label class="col-md-5 control-label">Fund Type </label>
														<div class="col-md-7">
															<selectivity list="costList" id="costCenter"
																name="costCenter" form-name="trialBalanceForm"
																property="pl.costCenter" ng-model="pl.costCenter"
																friendly-name="Fund Type"></selectivity>
														</div>
													</div>
												</fieldset>
											</div>

											<div class="col-sm-12 col-md-3 col-lg-3">
												<input type="hidden" id="companyCode"
													value="${user.companyCode}">
												<fieldset>
													<div class="form-group">
														<label for="inputPassword" class="control-label col-md-5">From
															Date <span style="color: red;">*</span>
														</label>
														<!-- <div class="input-group input-append date" id="pl_fromDate">
                                                                <input type="text" class="form-control input-sm"
                                                                        placeholder="dd/mm/yyyy" ng-model="pl.fromDate"
                                                                        name="fromDate" id="fromDate"> <span
                                                                        class="input-group-addon add-on"> <span
                                                                        class="glyphicon glyphicon-calendar"></span>
                                                                </span>
                                                        </div> -->
														<div class="col-md-7">

															<ng-bs3-datepicker ng-disabled="createQuote"
																data-ng-model="pl.fromDate" id="fromDate"
																name="From  Date"
																data-ng-change="checkDatesCL(pl.fromDate)"
																friendly-name="From Date" validation="required" />

															<!-- <div class="dropdown">
                                                                    <a class="dropdown-toggle" id="tb_fromDate" role="button"
                                                                            data-toggle="dropdown" data-target="#" href="#">
                                                                            <div class="input-group">
                                                                                    <input type="text" class="form-control"
                                                                                            placeholder="dd/mm/yyyy" name="From Date" id="fromDate"
                                                                                            data-ng-model="pl.fromDate"> <span
                                                                                            class="input-group-addon"><i
                                                                                            class="glyphicon glyphicon-calendar"></i></span>
                                                                            </div>
                                                                    </a>
                                                                    <ul class="dropdown-menu" role="menu"
                                                                            aria-labelledby="dLabel">
                                                                            <datetimepicker data-ng-model="pl.fromDate"
                                                                                    data-on-set-time="pl.fromDate = onDateSet(newDate)"
                                                                                    data-datetimepicker-config="{ dropdownSelector: '#tb_fromDate',startView:'day', minView:'day'}" />
                                                                    </ul>
                                                            </div> -->




														</div>
														<!-- <div class='input-group date datetimepick' style="width: 69%;">
                                                <div class="dropdown">
                                                        <a class="dropdown-toggle" id="fromDate" role="button"
                                                                data-toggle="dropdown" data-target="#" href="#">
                                                                <div class="input-group">
                                                                        <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="fromDate"  id="fromDate"
                                                                                data-ng-model="pl.fromDate">
                                                                                <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
                                                                </div>
                                                        </a>
                                                        <ul class="dropdown-menu" role="menu"
                                                                aria-labelledby="dLabel">
                                                                <datetimepicker data-ng-model="pl.fromDate" data-on-set-time="pl.fromDate = onDateSet(newDate)"
                                                                        data-datetimepicker-config="{ dropdownSelector: '#tb_fromdate',startView:'day', minView:'day'}" />
                                                        </ul>
                                                </div>
                                        </div> -->
													</div>
												</fieldset>
											</div>
											<div class="col-sm-12 col-md-3 col-lg-3">
												<fieldset>
													<div class="form-group">
														<label for="inputPassword" class="control-label col-md-5">To
															Date <span style="color: red;">*</span>
														</label>
														<div class="col-md-7">
															<!-- <div class="input-group input-append date" id="pl_toDate">
                                                                    <input type="text" class="form-control input-sm"
                                                                            placeholder="dd/mm/yyyy" ng-model="pl.toDate" name="toDate"
                                                                            id="toDate"> <span class="input-group-addon add-on">
                                                                            <span class="glyphicon glyphicon-calendar"></span>
                                                                    </span>
                                                            </div> -->



															<ng-bs3-datepicker ng-disabled="createQuote"
																data-ng-model="pl.toDate" id="toDate" name="To Date"
																data-ng-change="checkDatesCL(pl.toDate)"
																friendly-name="To Date" validation="required" />

															<!-- <div class='input-group date datetimepick' style="width: 100%;">
                                                                    <div class="dropdown">
                                                                            <a class="dropdown-toggle" id="tb_toDate" role="button"
                                                                                    data-toggle="dropdown" data-target="#" href="#">
                                                                                    <div class="input-group">
                                                                                            <input type="text" class="form-control"
                                                                                                    placeholder="dd/mm/yyyy" name="From Date" id="toDate"
                                                                                                    data-ng-model="pl.toDate"> <span
                                                                                                    class="input-group-addon"><i
                                                                                                    class="glyphicon glyphicon-calendar"></i></span>
                                                                                    </div>
                                                                            </a>
                                                                            <ul class="dropdown-menu" role="menu"
                                                                                    aria-labelledby="dLabel">
                                                                                    <datetimepicker data-ng-model="pl.toDate"
                                                                                            data-on-set-time="pl.toDate = onDateSet(newDate)"
                                                                                            data-datetimepicker-config="{ dropdownSelector: '#tb_toDate',startView:'day', minView:'day'}" />
                                                                            </ul>
                                                                    </div>
                                                            </div> -->
														</div>
													</div>
												</fieldset>
											</div>
										</div>
									</div>

									<a id="PLExport" href="filePath/ProfitAndLoss.xls"
										download="ProfitAndLoss.xls"></a>

									<div class="form-actions">
										<div class="row">
											<div class="col-md-12 ">
												<%-- <security:authorize access="hasRole('${form_code}_${view}')">
                                                    <button class="btn btn-success"
                                                            ng-click="viewProfitLossNewhor(pl.company)">
                                                        <i class="fa fa-search"></i>View Horizontal Report
                                                    </button>
                                                </security:authorize> --%>

												<security:authorize access="hasRole('${form_code}_${view}')">
													<button class="btn btn-success" onclick="$('.rpt').removeClass('hidden')"
														ng-click="viewProfitLossNewVer(pl.company)">
														<i class="fa fa-search"></i>View Report
													</button>
													
												</security:authorize>

												<%-- 	<security:authorize access="hasRole('${form_code}_${export}')">
                                                    <button class="btn btn-primary" ng-click="exportPLExcelVer()">
                                                        <i class="fa fa-search"></i>Export Horizontal Excel
                                                    </button>
                                                </security:authorize> --%>

												<a id="exportBS" stype="display:none" href="{{filePath}}"
													download="ProfitAndLoss.xls"></a>


												<button class="btn btn-success fa fa-file-excel-o"
													class="btn btn-success" data-ng-click="exportPLExcel()">
													Excel export</button>


												<button class="btn btn-primary" ng-click="exportPDF()"
													type="button">
													<i class="fa fa-file-pdf-o"> </i> Export PDF<a
														id="exportPDF" href="filePath/Income and Expenditure.pdf"
														download="Income and Expenditure.pdf"></a>
												</button>


											</div>
										</div>
									</div>

									<!-- report start -->

									<!-- <div class="row">
                                   			 <div class="col-sm-12 col-md-12 col-lg-12 padding-top-10" id="jqgrid">
                                                    <table id="plReportGrid"></table>
                                                    <div id="plReportGridPage"></div>
                                             </div>	
                        			 	  </div>
                        			   -->
							 
								</form>
							</div>
							<!-- /panel-body -->
						</div>
						<!-- /panel-default -->
						</div>
						
						<!-- report start -->
						<div class="container-fluid ">
							<div class="col col-md-12 col-sm-12 col-lg-12"><br><br>
								<div class="col col-sm-8 col-md-8 col-lg-8 col-sm-offset-2 col-md-offset-2 col-lg-offset-2 card card-default rpt hidden ">
								
									<div class="text-center"><br>									  
		                      		  <div align="center"><img src="/img/MBKHelpVideos/Dental_Council_of_India_logo1.png" width="90"></div>
		                                <div class="   bold toggleBlock-currsor text-center  ">
		                                     <h1 style="color: black;">Dental Council Of India</h1>
		                                </div><b> Income & Expenditure for the Period from {{pl.fromDate }} to {{pl.toDate }}</b>
		                      		 </div><br><br>
		                       
		                     					<table class="table" ng-if="viewVer" style="font-style: normal;" >													
												<tbody id="sales-record">  													

												<%-- <tr style="border: none;">
													<th  colspan="2"  width="600"
														style="font-size: 13px;border: none;"><a
														ng-click="Click('DIRECT INCOMES')"> <security:authorize
																access="hasRole('${form_code}_${view}')">
																<span tooltip="test" style="color: black"
																	data-toggle="tooltip" title="Click to here view ledger"
																	class="tool-tip-span">SALES ACCOUNTS </span>
															</security:authorize></a></th>
												<!-- <th class=" text-right">{{profitLoss.dSalesRevenueTotal
                                                                | number:2}}</th> -->
												</tr>
											 
													<tr ng-repeat="(trIndex, row) in profitLoss.lSalesRevenue1">
														<td  width="600" align="left"  
															style="font-size: 10px; border:none;">&nbsp; <a
															ng-click="AccountClick(row.accountHeadName)"> <security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">{{row.accountHead}} </span>
																</security:authorize></a>

														</td>
														<td  width="600" align="right"  
															style="font-size: 10px;border:none;">{{row.amount| number:2}}
															&nbsp</td>
													</tr> --%>												 
													
													<tr data-toggle="collapse" data-target="#_dirincome">
														<th style="border: none;"><b> &emsp;&nbsp;Particulars</b></th>
														<!-- 12-04-2019	<th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal | number:2}}</th>-->
														<th style="border: none;" class="text-right"><b> Amount (INR) &emsp;&emsp;</b></th>
													</tr>
												
													<tr style="margin-top: -10px;"><th colspan="2"  ><br> &emsp;&nbsp;Income</th></tr>

													<tr style="border: none;margin-top: -10px;" data-toggle="collapse" data-target="#_{{row.accountHead}}">
														<th><a ng-click="Click('DIRECT INCOMES')">
																 <security:authorize access="hasRole('${form_code}_${view}')">
																	<span tooltip="test" style="color: black; font-weight: bold;" data-toggle="tooltip" title="Click to here view ledger" class="tool-tip-span"> &emsp;&nbsp;Direct Income </span>
																</security:authorize></a></th>
														<!-- 12-04-2019	<th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal | number:2}}</th>-->
														<td class="text-right"><b>{{(profitLoss.dSalesRevenueTotal)|number:2}} &emsp;&nbsp;</b></td>
													</tr>										
													
																										
													 <!-- <tr>
                                                                <th class="  ">GROSS PROFIT B/F </th>   B/f to c/f
                                                                <th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)|
                                                                        number:2}}</th>
                                                      </tr> -->							
													
													
													<%-- <tr>
													<th style="font-size: 15px; height: 40px;border:none;">
														<a ng-click="Click('INDIRECT INCOME')"> <security:authorize
																access="hasRole('${form_code}_${view}')">
																<span tooltip="test" style="color: black"
																	data-toggle="tooltip" title="Click to here view ledger"
																	class="tool-tip-span">Closing Stock </span>
															</security:authorize></a>
													</th>
													 
												</tr>
												
												<tbody id="sales-record">
													<tr ng-repeat="(trIndex, row) in profitLoss.lOtherIncome1">
														<td class="width_30" align="left" height="20"
															style="font-size: 10px;">&nbsp; <a
															ng-click="AccountClick(row.accountHeadName)"> <security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">{{row.accountHead}} </span>
																</security:authorize></a>
														</td>
														<td class="width_30" align="right" height="20"
															style="font-size: 10px;">{{row.amount| number:2}}
															&nbsp</td>
													</tr>
												</tbody>  --%>
												
												
												
												<!-- <tr>
												<td class="width_10" align="left" height="30"
                                                                style="background: #D37878 !important" style="font-size: 10px;"><font
                                                                size="2" face="arial"><b>&nbsp; TOTAL</b></font></td>
                                                        <td class="text-center width_15 text-left"
                                                                style="background: #D37878 !important"><b>{{(-profitLoss.dOtherIncome)| number:2 }}&nbsp;</b></td>
                                                        <td class="width_10" align="left" height="30"
                                                                style="background: #D37878 !important" style="font-size: 10px;"><font
                                                                size="2" face="arial"><b>&nbsp;TOTAL</b></font></td>
                                                        <td class="text-center width_15 text-right"
                                                                style="background: #D37878 !important"><b>{{((((profitLoss.dSalesRevenueTotal-(-profitLoss.dCostOfSalesTotal)))
                                                                        -
                                                                        (((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
                                                                        (-profitLoss.dcommunicationCost)
                                                                        +(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost) +
                                                                        (-profitLoss.dconveyencecost)) + dOtherIncome)
                                                                        ))+
                                                                        (((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
                                                                        (-profitLoss.dcommunicationCost)
                                                                        +(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost)+
                                                                        (-profitLoss.dconveyencecost)))+(((profitLoss.dSalesRevenueTotal)-(-profitLoss.dCostOfSalesTotal)))}}&nbsp</b></td>
                                                                                                
                                                <td class="text-center width_15 text-left"
                                                                style="background: #D37878 !important"><b>{{(-profitLoss.dOtherIncome)|
                                                                        number:2 }}&nbsp;</b></td>
											</tr> -->
											
											
											<%-- <tr>
														<th class="  " colspan="2"
															style="font-size: 15px; height: 40px;"><a
															ng-click="Click('DIRECT EXPENSES')"> <security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">OPENING STOCK </span>
																</security:authorize></a></th>

													</tr> 

													<tbody id="sales-record">

														<tr
															ng-repeat="(trIndex, row) in profitLoss.lOtherExpense1"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>



															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>
													<tr>
														<th class="  " colspan="2"
															style="font-size: 15px; height: 40px;"><a
															ng-click="Click('DIRECT EXPENSES')"> <security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">PURCHASE ACCOUNTS </span>
																</security:authorize></a></th>

													</tr>

													<tbody id="sales-record">

														<tr
															ng-repeat="(trIndex, row) in profitLoss.lOtherExpense2"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>



															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>--%>											
												

												</tbody>
										
												<!-- <tr><th class="  ">GROSS PROFIT C/F </th>  <th class="text-center   text-right">{{((-profitLoss.dCostOfSalesTotal)-profitLoss.dSalesRevenueTotal)|number:2}}</th> </tr> -->
												<!-- <tr>    <th class="text-center text-right">{{(profitLoss.dCostOfSalesTotal)|  number:2}}</th> </tr> -->
                                                                                                      
											</table>
											
											<div id="_{{row.accountHead}}" class="collapse" style="margin-top: -20px;">	
												 <table class="table">
												 	<tr ng-repeat="(trIndex, row) in profitLoss.lSalesRevenue"   >
														<td class="width_20 borderclass" style="border:none;" align="left"><a tooltip="test" style="color: black"
																		data-toggle="tooltip" title="Click to here view ledger"
																		class="tool-tip-span text-capitalize" ng-click="AccountClick(row.accountHeadName)">
															 <security:authorize access="hasRole('${form_code}_${view}')">  &nbsp;&nbsp;{{row.accountHead | lowercase}}
																</security:authorize></a>
														</td>
														<td class="width_6 borderclass" align="right">{{row.amount| number:2}}  &emsp;&nbsp;</td>
													</tr>
												 </table>
											 </div>
											 
											 <div  style="margin-top: -20px;">	
												 <table class="table" style="margin-top: -26px;">
												 	<tr data-toggle="collapse" data-target="#1_{{row.accountHead}}">
														<th>
															<a ng-click="Click('INDIRECT INCOME')"> <security:authorize
																	access="hasRole('${form_code}_${view}')">	
																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip" title="Click to here view ledger"
																		class="tool-tip-span"> &emsp;&nbsp;Indirect Income</span>
																</security:authorize></a>
														</th>
														<td class="text-right"><b>{{profitLoss.dOtherIncome|number:2}}</b> &emsp;&nbsp;&nbsp;&nbsp;</td>
													</tr> 
												 </table>
											 </div>
											 
											  <div id="1_{{row.accountHead}}"  class="collapse" style="margin-top: -20px;">	
												 <table class="table" style="margin-top: -26px;">												
													<tr ng-repeat="(trIndex, row) in profitLoss.lOtherIncome" >
														<td class="width_20 borderclass" align="left" height="20" >&nbsp; <a
															ng-click="AccountClick(row.accountHeadName)" tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger" class="tool-tip-span"> 
															<security:authorize access="hasRole('${form_code}_${view}')">{{row.accountHead}}</security:authorize></a>
														</td>
														<td class="width_6 borderclass" align="right" height="20"
															style="font-size: 13px;border:none;">{{row.amount| number:2}} &emsp;&nbsp;&nbsp;&nbsp;</td>
													</tr>
												 </table>
											 </div>
											 
											   <div style="margin-top: -20px;">	
												 <table class="table" style="margin-top: -26px;">												
													<tr>
													<th style="font-size: 13px;border-top : 1px solid;"> &emsp;&nbsp;Total</th>
													<td class="text-right" style="border-top : 1px solid ;"><b>{{((profitLoss.dSalesRevenueTotal)
														+(profitLoss.dOtherIncome)) | number:2}} </b>&emsp;&nbsp;&nbsp;&nbsp;</td>
												</tr>
												 </table>
											 </div>
											 
											 <!-- Income End -->
											 
											
											<!-- Expenditure Start -->
											<table class="table" style="margin-top: -26px;">												
												<tbody>
												<tr> 
													<th colspan="2" align="left" style="border:none;"><b> &emsp;&nbsp;Expenditure</b></th>
												</tr>
												
												<tr data-toggle="collapse" data-target="#2_{{row.accountHead}}">	
													<th colspan="2" ><a ng-click="Click('DIRECT EXPENSES')"> <security:authorize
																		access="hasRole('${form_code}_${view}')">
																		<span tooltip="test" style="color: black;"
																			data-toggle="tooltip" title="Click to here view ledger"
																			class="tool-tip-span"> &emsp;&nbsp;<b>Direct Expenses</b></span>
																	</security:authorize></a>
													</th>
													<td class="text-right income"><b>{{(-profitLoss.dCostOfSalesTotal) | number:2}}</b> &emsp;&nbsp;&nbsp;&nbsp;</td>
												</tr>	
																					
												 
												</tbody>												
											</table>
											
											 <div id="2_{{row.accountHead}}"  class="collapse" style="margin-top: -20px;">
												 <table class="table" style="margin-top: -26px;">
													<tr ng-repeat="(trIndex, row) in profitLoss.lOtherExpense" id="_{{row.accountHead}}" ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_20 borderclass" align="left" style="border:none;">&nbsp; <a ng-click="AccountClick(row.accountHeadNameAdmin)">
																	<security:authorize access="hasRole('${form_code}_${view}')">
																		<span tooltip="test" style="color: black" data-toggle="tooltip" class="text-capitalize"
																			title="Click to here view ledger" class="tool-tip-span">&nbsp;{{row.accountHead | lowercase}} </span>
																	</security:authorize></a>
															</td>
															<td class="width_6 borderclass" align="right">{{row.amountAdmin|number:2}} &emsp;&nbsp;&nbsp;</td>															
													</tr>	
												 </table>
											 </div>
											 
											 <div style="margin-top: -20px;">	
												 <table class="table" style="margin-top: -26px;">
													<tr>
														<th style="border-top : 1px solid ;"> &emsp;&nbsp;Total</th>
														<td style="border-top : 1px solid ;" class="text-right income"><b>{{(-profitLoss.dCostOfSalesTotal) | number:2}}</b>&emsp;&emsp;</td>
														</tr>
												 </table>
											 </div>
											 
											 <div>
											 <input type="hidden" id="income" value="{{(((profitLoss.dSalesRevenueTotal)+(profitLoss.dOtherIncome)))}}" >
														<input type="hidden" id="expence" value="{{((-profitLoss.dpersonalCost)+(-profitLoss.dsalesCost)+(-profitLoss.dtravellingcost)+(-profitLoss.dcommunicationCost)+(-profitLoss.dRentCost)+(-profitLoss.dAdminExpense)+(-profitLoss.dfinanceCost)+(-profitLoss.dconveyencecost)+(-profitLoss.dCostOfSalesTotal))}}" >
														<script>$(document).ready(function(){
															if($('#income').val()>$('#expence').val()){$('#remarks').html('<b>&emsp; Excess of Income Over Expenditure</b>');
															}else{$('#remarks').html('<b>&emsp; Excess of Expenditure Over Income</b>');}
														});</script>
											 	 <table class="table" ng-if="viewVer">
													<tr ng-if="pl.ntprofit > 0">
														<th id="remarks" class="pull-left" style="border:none;"></th>
														<td class="pull-right" style="border:none;"><span style=""> <b>{{(( -
															profitLoss.dpersonalCost) +( - profitLoss.dsalesCost) +(- profitLoss.dtravellingcost) + ( -
															profitLoss.dcommunicationCost) + ( -
															profitLoss.dRentCost) + (-profitLoss.dAdminExpense) +(- profitLoss.dfinanceCost) + ( -profitLoss.dconveyencecost) + (-profitLoss.dCostOfSalesTotal))-(((profitLoss.dSalesRevenueTotal)+(profitLoss.dOtherIncome)))}}.00 </span> 
														&emsp;&emsp;</b></td>
														<!-- <th class="text-center   text-right">{{(( -
															profitLoss.dpersonalCost) +( - profitLoss.dsalesCost) +(- profitLoss.dtravellingcost) + ( -
															profitLoss.dcommunicationCost) + ( -
															profitLoss.dRentCost) + (-profitLoss.dAdminExpense) +(- profitLoss.dfinanceCost) + ( -profitLoss.dconveyencecost) + (-profitLoss.dCostOfSalesTotal))
															-(((profitLoss.dSalesRevenueTotal)+(profitLoss.dOtherIncome)))}}.00</th> -->													
													<tr>
												</table>
											 </div>
											 
<!-- 
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>


												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>

												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>



												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>


												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>


												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>

												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>


												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>
												<table ng-if="viewVer" width=93% align="center"
													cellSpacing="0" style="margin-left: 0px;"></table>

												np 
												<table = ng-if="viewRight" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;"> -->



											<!--  on top		<tr>
														<th>Total</th>
														<th class="text-center   text-right">{{(-profitLoss.dCostOfSalesTotal)|
															number:2}}</th>
													</tr> -->


													<!-- 	<tr>
                <th class="  ">GROSS PROFIT C/O</th>
                <th class="text-center   text-right">{{((profitLoss.dCostOfSalesTotal)-profitLoss.dSalesRevenueTotal)|
                        number:2}}</th>
        </tr>
                                                      



												</table>  -->
												
												<!--np  -->
												<!-- nl -->

												<!-- <table = ng-if="viewLeft" width=93% align="center"  
                                                        cellpadding="10" cellSpacing="0" style="margin-left: 0px; ">
<tr>

        <th class="text-center   text-right" colspan="2">{{(profitLoss.dCostOfSalesTotal)
                                                                        | number:2}}</th>
        </tr>
</table> 
												<table = ng-if="viewLeft" width=93% align="center"
													cellpadding="10" cellSpacing="0"
													style="margin-left: 0px; margin-top: 15px">

													 <tr>
                                                                <th class="  "></th>
                                                                <th class="text-center   text-right">{{(((profitLoss.dSalesRevenueTotal)+(profitLoss.dSalesRevenueTotal))-(-profitLoss.dCostOfSalesTotal))|
                                                                        number:2}}</th>
                                                        </tr>
                                                        -->


													<!-- 
                                                                                                                <tr>
                                                                                                                        <th class="  ">GROSS PROFIT C/F </th>   c/o to b/f
                                                                                                                        <th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)|
                                                                                                                                number:2}}</th>
                                                                                                                </tr>
                                                        -->
													<!-- 	<tr>
                                                                                                                       <th class="  "></th>
                                                                                                                       <th class="text-center   text-right">{{(profitLoss.dSalesRevenueTotal)|
                                                                                                                               number:2}}</th>
                                                                                                               </tr> -->

													<!--     <tr ng-if="pl.ntprofit > 0">
                                       <th class="  ">Net Profit2 </th>  
                                       <th class="text-center   text-right">{{pl.ntprofit|
                                               number:2}}</th>
                               </tr> -->

													<!-- <tr ng-if="profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal) > 0">
                                                                <th class="  ">Net Profit2 </th>   c/o to b/f
                                                                <th class="text-center   text-right">{{profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)|
                                                                        number:2}}</th>
                                                        </tr> -->



												</table>

												<!-- nl -->
												<!-- <table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
 -->
											<%--	<table ng-if="viewVer" width=95% align="center"
													cellpadding="10" cellSpacing="0"
													style="margin-left: 0px; margin-top: 0px;">


													<tr>
														<th class="  " style="font-size: 13px; height: 40px;">INDIRECT
															EXPENSES</th>
														<th class="text-center   text-right"></th>




														<!-- 									{{((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
                                                                    (-profitLoss.dcommunicationCost)
                                                                    +(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost)) }} -->

													</tr>
													<tbody id="sales-record">

														<tr
															ng-repeat="(trIndex, row) in profitLoss.lindirectexpenses"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="center" height="20"
																style="font-size: 13px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>



															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 13px;">{{row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>



													<tr>
														<th class="  "><a ng-click="Click('TRAVELLING COST')">
																<security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">ANNUAL MAINTENANCE
																		CONTRACT </span>
																</security:authorize>
														</a></th>
														<th class="text-center   text-right">{{-profitLoss.dtravellingcost
															| number:2}}</th>
													</tr>

													<tbody id="sales-record">

														<tr
															ng-repeat="(trIndex, row) in profitLoss.lTravellingCostList"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>


															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{-row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>

													 <tr>
														<th class="  "><a
															ng-click="Click('SALES & BUSINESS PROMOTION COST')">
																<security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">FUNCTIONS & CELEBRATIONS
																	</span>
																</security:authorize>
														</a></th>
														<th class="text-center   text-right">{{-profitLoss.dsalesCost
															| number:2}}</th>
													</tr> 

													<tbody id="sales-record">

														<tr
															ng-repeat="(trIndex, row) in profitLoss.lSalesandBusinessList"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>


															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{-row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>

													<tr>
														<th class="  "><a ng-click="Click('PERSONNEL COST')">
																<security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">INSURANCE </span>
																</security:authorize>
														</a></th>
														<th class="text-center   text-right">{{-profitLoss.dpersonalCost
															| number:2}}</th>
													</tr>

													<tbody id="sales-record">

														<tr
															ng-repeat="(trIndex, row) in profitLoss.lPersonalCostList"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>
															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{-row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>
													<tr>
														<th class="  "><a ng-click="Click('FINANCE COST')">
																<security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">BANK CHARGES </span>
																</security:authorize>
														</a></th>
														<th class="text-center   text-right">{{-profitLoss.dfinanceCost
															| number:2}}</th>
													</tr>

													<tbody id="sales-record">

														<tr ng-repeat="(trIndex, row) in profitLoss.lFinanceCost"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>


															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{-row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>


													<tr>
														<th class="  "><a
															ng-click="Click('COMMUNICATION COST')"> <security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">DONATION EXPENSES </span>
																</security:authorize></a></th>
														<th class="text-center   text-right">{{-profitLoss.dcommunicationCost
															| number:2}}</th>
													</tr>

													<tbody id="sales-record">

														<tr
															ng-repeat="(trIndex, row) in profitLoss.lCommuncationCostList"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>



															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{-row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>

													<tr>
														<th class="  "><a
															ng-click="Click('ADMINISTRATIVE COST')"> <security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">ADMINISTRATIVE EXPENSES </span>
																</security:authorize></a></th>
														<th class="text-center   text-right">{{-profitLoss.dAdminExpense
															| number:2}}</th>
													</tr>

													<tbody id="sales-record">

														<tr ng-repeat="(trIndex, row) in profitLoss.lAdminExpense"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>



															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{-row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>




													<tr>
														<th class="  "><a ng-click="Click('CONVEYANCE COST')">
																<security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">TRANSPORT FEE </span>
																</security:authorize>
														</a></th>
														<th class="text-center   text-right">{{-profitLoss.dconveyencecost
															| number:2}}</th>
													</tr>

													<tbody id="sales-record">

														<tr
															ng-repeat="(trIndex, row) in profitLoss.lConveyenceCostList"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>


															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{-row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>

													</tbody>

													<tr>
														<th class="  "><a ng-click="Click('RENT COSTS')">
																<security:authorize
																	access="hasRole('${form_code}_${view}')">

																	<span tooltip="test" style="color: black"
																		data-toggle="tooltip"
																		title="Click to here view ledger"
																		class="tool-tip-span">REPAIRS AND MAINTENANCE </span>
																</security:authorize>
														</a></th>
														<th class="text-center   text-right">{{-profitLoss.dRentCost
															| number:2}}</th>



													</tr>



													<tbody id="sales-record">

														<tr ng-repeat="(trIndex, row) in profitLoss.lRentCostList"
															ng-if="row.accountHeadNameAdmin != '' && row.accountHeadNameAdmin != null">
															<td class="width_30" align="left" height="20"
																style="font-size: 10px;">&nbsp <a
																ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
																		access="hasRole('${form_code}_${view}')">

																		<span tooltip="test" style="color: black"
																			data-toggle="tooltip"
																			title="Click to here view ledger"
																			class="tool-tip-span">{{row.accountHead}} </span>
																	</security:authorize></a>



															</td>
															<td class="width_30" align="right" height="20"
																style="font-size: 10px;">{{-row.amountAdmin|
																number:2}} &nbsp</td>


														</tr>


													</tbody>

												</table>



												<table ng-if="viewVer" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;">


													<tr>
														<th class="  ">TOTAL-(D)</th>
														<th class="text-center   text-right">{{( -
															profitLoss.dpersonalCost) + ( - profitLoss.dsalesCost) +
															( - profitLoss.dtravellingcost) + ( -
															profitLoss.dcommunicationCost) + ( -
															profitLoss.dRentCost) + ( - profitLoss.dAdminExpense) + (
															- profitLoss.dfinanceCost) + ( -
															profitLoss.dconveyencecost) | number:2}}</th>

													</tr> 


													<tr>
														<th class="  ">TOTAL EXPENDITURE-(C+D)</th>
														<th class="text-center   text-right">{{( -
															profitLoss.dpersonalCost) + ( - profitLoss.dsalesCost) +
															( - profitLoss.dtravellingcost) + ( -
															profitLoss.dcommunicationCost) + ( -
															profitLoss.dRentCost) + ( - profitLoss.dAdminExpense) + (
															- profitLoss.dfinanceCost) + ( -
															profitLoss.dconveyencecost) +
															(-profitLoss.dCostOfSalesTotal) | number:2}}</th>													</tr>

												</table> --%>

												

<!-- 
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table>
												<table ng-if="viewVer" width=80% align="center"></table> 


												<table ng-if="viewRight" width=93% align="center"
													cellpadding="10" cellSpacing="0" style="margin-left: 0px;">-->

													<!-- 	 ntloss = amount-(totl+dOtherIncome);
                                        ntprof=dOtherIncome-(totl+amount); -->


													<!-- 
                                                                                                                <tr>
                                                                                                                        <th class="  ">Net Profit</th>
                                                                                                                        <th class="text-center   text-right">{{
                                                                                                                        ((-profitLoss.dOtherIncome))
                                                                                                                                -
                                                                                                                                ((((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
                                                                                                                                (-profitLoss.dcommunicationCost)
                                                                                                                                +(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost) +
                                                                                                                                (-profitLoss.dconveyencecost))  +  (-((-profitLoss.dCostOfSalesTotal)-profitLoss.dSalesRevenueTotal))))| number:2}}</th>
                                                                                                                </tr> 









												</table>-->
											</div>

											<!-- ngIf: viewRight -->

											<!-- ngIf: viewLeft -->

										</div>



									<!-- 	<div class="col-sm-12 col-md-12 col-lg-12"
											style="padding-top: 24px;">

											ngIf: viewRight

											ngIf: viewLeft
											<table ng-if="viewLeft" width="60%" align="center"
												cellpadding="10" cellspacing="0" style="margin: 15px;">

												<tbody>
													<tr>
														<td class="width_10" align="left" height="30" style=""><font
															size="2" face="arial"><b>&nbsp;TOTAL</b></font></td>
														<td class="text-center width_15 text-right" style=""><b
															class="ng-binding"><b>{{pl.total1| number:2
																	}}&nbsp;</b></td>
													</tr>
												</tbody>
											</table>
										</div> -->
		                        
								</div>
						</div>
						</div>
						<!--  report end -->
				
		</div>
		</article>
</div>
</section>
</div>
