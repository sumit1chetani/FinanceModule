<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />
<head>
<style>
.main_head {
	background-color: #7E7EB8 !important;
	color: white;
	padding: 10px 15px;
	border-bottom: 1px solid transparent;
	border-radius: 2px 2px 0 0;
}

.data-table {
	margin-bottom: 7px !important;
}
</style>


</head>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" name="profitLossSearchForm">
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
						<div class="col-sm-12 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> Company <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="companyList" ng-model="pl.company"
											property="pl.company" id="company" object="company"
											name="company"></selectivity>

										<!-- 											 <select id="txtCompanyCode" multiple="multiple" name="multiselect[]" ng-model="companyCodes"
											 ng-options="option.id as option.text for option in companyList" data-dropdownmultiselect>    
											   <option data-ng-repeat="option in companyList" value="{{getOptionId(option)}}" 
											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
											</select> -->
									</div>
								</div>
							</fieldset>
						</div>

						<div class="col-sm-4 col-md-4 col-lg-4">
							<input type="hidden" id="companyCode" value="${user.companyCode}">
							<fieldset>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">From
										Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<div class="input-group input-append date" id="pl_fromDate">
											<input type="text" class="form-control input-sm"
												placeholder="dd/mm/yyyy" ng-model="pl.fromDate"
												name="fromDate" id="fromDate"> <span
												class="input-group-addon add-on"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">To
										Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<div class="input-group input-append date" id="pl_toDate">
											<input type="text" class="form-control input-sm"
												placeholder="dd/mm/yyyy" ng-model="pl.toDate" name="toDate"
												id="toDate"> <span class="input-group-addon add-on">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
				</div>
				<a id="PLExport" stype="display:none"
					href="filePath/ProfitAndLoss.xls" download="ProfitAndLoss.xls"></a>
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
								<button class="btn btn-success"
									ng-click="viewProfitLossNewVer(pl.company)">
									<i class="fa fa-search"></i>View  Report
								</button>
							</security:authorize>

							<security:authorize access="hasRole('${form_code}_${export}')">
								<button class="btn btn-primary" ng-click="exportPLExcelVer()">
									<i class="fa fa-search"></i>Export Horizontal Excel
								</button>
							</security:authorize>

							<security:authorize access="hasRole('${form_code}_${export}')">
								<button class="btn btn-primary" ng-click="exportPLExcel()">
									<i class="fa fa-search"></i>Export Vertical Excel
								</button>
							</security:authorize>




						</div>
					</div>
				</div>
				<!-- <div class="row">
		       		<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10" id="jqgrid">
						<table id="plReportGrid"></table>
						<div id="plReportGridPage"></div>
					</div>	
		       </div> -->
				<div
					class="main_head  bold toggleBlock-currsor text-center fontSize16 ">
					PROFIT AND LOSS - {{pl.companyName}}</div>
				<table ng-if="viewHor"
					class="table table-striped table-hover data-table no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="text-center width_50"
								style="background: #8C8CB5 !important;">Particulars</th>
							<th class="text-center width_50" ng-if="!malaysia"
								style="background: #8C8CB5 !important;">Amount (USD)</th>
							<th class="text-center width_50" ng-if="malaysia"
								style="background: #8C8CB5 !important;">Amount (MYR)</th>
						</tr>
					</thead>
				</table>
				<table ng-if="viewHor"
					class="table table-striped table-hover data-table no-footer">
					<thead class="dataTables-Main-Head">
						<tr ng-click="toggleBlock('sales-record')">
							<th class=" width_50">Direct Incomes - ( A )</th>
							<th class="text-center width_50 text-right">{{profitLoss.dSalesRevenueTotal
								| number:2}}</th>
						</tr>
					</thead>
					<tbody id="sales-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lSalesRevenue">
							<td class="sorting ">{{row.accountHead}}</td>
							<td class="sorting text-right">{{row.amount | number:2}}</td>

						</tr>
					</tbody>
				</table>
				<table ng-if="viewHor"
					class="table table-striped table-hover data-table no-footer">
					<thead class="dataTables-Main-Head">
						<tr ng-click="toggleBlock('cos-record')">
							<th class=" width_50">Direct Expenses - ( B )</th>
							<th class="text-center width_50 text-right">{{profitLoss.dCostOfSalesTotal
								| number:2}}</th>
						</tr>
					</thead>
					<tbody id="cos-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lCostOfSales">
							<td class="sorting ">{{row.accountHead}}</td>
							<td class="sorting text-right">{{row.amount | number:2}}</td>

						</tr>
					</tbody>
				</table>

				<table ng-if="viewHor"
					class="table table-striped table-hover data-table no-footer">
					<thead class="dataTables-Main-Head">
						<tr class="main_head">
							<th class="text-center width_50 "
								style="background: #D37878 !important">Gross Profit : C=
								(A+B)</th>
							<th class="text-center width_50 text-right"
								style="background: #D37878 !important">{{profitLoss.dSalesRevenueTotal
								+ profitLoss.dCostOfSalesTotal | number:2}}</th>
						</tr>
					</thead>
				</table>

				<table ng-if="viewHor"
					class="table table-striped table-hover data-table no-footer">
					<thead class="dataTables-Main-Head">
						<tr ng-click="toggleBlock('ii-record')">
							<th class=" width_50">Indirect Income - ( D )</th>
							<th class="text-center width_50 text-right">{{profitLoss.dOtherIncome
								| number:2}}</th>
						</tr>
					</thead>
					<tbody id="ii-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lOtherIncome">
							<td class="sorting ">{{row.accountHead}}</td>
							<td class="sorting text-right">{{row.amount | number:2}}</td>

						</tr>
					</tbody>
				</table>
				<table ng-if="viewHor"
					class="table table-striped table-hover data-table no-footer">
					<thead class="dataTables-Main-Head">
						<tr ng-click="toggleBlock('ie-record')">
							<th class=" width_50">Indirect Expenses E =
								(IE1+IE2+IE3+IE4+IE5+IE6+IE7)</th>


							<th class="text-center width_50 text-right">{{(profitLoss.dTravellingCost
								+
								profitLoss.dSalesandBuss)+(profitLoss.dPersonalCost)+(profitLoss.dFinanceCost)+(profitLoss.dCommunctionExpense)+(profitLoss.dAdminExpense)+profitLoss.dRentCost
								| number:2}}</th>
						</tr>
					</thead>
					<!-- <tbody id="ie-record"> -->
					<tr ng-click="toggleBlock('ie1-record')">
						<th class=" width_50">Travelling Cost (IE1)</th>
						<th class="text-center width_50 text-right">{{profitLoss.dTravellingCost
							| number:2}}</th>
					</tr>
					<tbody id="ie1-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lTravellingCostList">

							<td class="sorting ">{{row.accountHead}}</td>
							<td class="sorting text-right">{{row.amount | number:2}}</td>

						</tr>
					</tbody>


					<tr ng-click="toggleBlock('ie2-record')">
						<th class=" width_50">Sales & Buisness Cost (IE2)</th>
						<th class="text-center width_50 text-right">{{profitLoss.dSalesandBuss
							| number:2}}</th>
					</tr>
					<tbody id="ie2-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lSalesandBusinessList">

							<td class="sorting ">{{row.accountHead}}</td>
							<td class="sorting text-right">{{row.amount | number:2}}</td>

						</tr>
					</tbody>

					<tr ng-click="toggleBlock('ie3-record')">
						<th class=" width_50">Personal Cost (IE3)</th>
						<th class="text-center width_50 text-right">{{profitLoss.dPersonalCost|
							number:2}}</th>
					</tr>
					<tbody id="ie3-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lPersonalCostList">

							<td class="sorting ">{{row.accountHead}}</td>
							<td class="sorting text-right">{{row.amount | number:2}}</td>

						</tr>
					</tbody>

					<tr ng-click="toggleBlock('ie4-record')">
						<th class=" width_50">Finance Cost (IE4)</th>
						<th class="text-center width_50 text-right">{{profitLoss.dFinanceCost|
							number:2}}</th>
					</tr>
					<tbody id="ie4-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lFinanceCost">

							<td class="sorting ">{{row.accountHeadNameAdmin}}</td>
							<td class="sorting text-right">{{row.amountAdmin |
								number:2}}</td>

						</tr>
					</tbody>


					<tr ng-click="toggleBlock('ie5-record')">
						<th class=" width_50">Communication Cost (IE5)</th>
						<th class="text-center width_50 text-right">{{profitLoss.dCommunctionExpense|
							number:2}}</th>
					</tr>
					<tbody id="ie5-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lCommuncationCostList">

							<td class="sorting ">{{row.accountHead}}</td>
							<td class="sorting text-right">{{row.amount | number:2}}</td>

						</tr>
					</tbody>
					<tr ng-click="toggleBlock('ie6-record')">
						<th class=" width_50">Administrative Cost (IE6)</th>
						<th class="text-center width_50 text-right">{{profitLoss.dAdminExpense|
							number:2}}</th>
					</tr>
					<tbody id="ie6-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lAdminExpense">

							<td class="sorting ">{{row.accountHead}}</td>
							<td class="sorting text-right">{{row.amount | number:2}}</td>

						</tr>
					</tbody>
					<tr ng-click="toggleBlock('ie7-record')">
						<th class=" width_50">Rent Cost (IE7)</th>
						<th class="text-center width_50 text-right">{{profitLoss.dRentCost|
							number:2}}</th>
					</tr>
					<tbody id="ie7-record">
						<tr ng-repeat="(trIndex, row) in profitLoss.lRentCostList">

							<td class="sorting ">{{row.accountHeadNameAdmin}}</td>
							<td class="sorting text-right">{{row.amountAdmin |
								number:2}}</td>

						</tr>
					</tbody>


					<!--   </tbody> -->
				</table>
				<table ng-if="viewHor"
					class="table table-striped table-hover data-table no-footer">
					<thead class="dataTables-Main-Head">
						<tr class="main_head">
							<th class="text-center width_50 "
								style="background: #D37878 !important;">Profit of The Year
								H =( C+D+E )</th>
							<th class="text-center width_50 text-right"
								style="background: #D37878 !important;">
								{{(profitLoss.dSalesRevenueTotal +
								profitLoss.dCostOfSalesTotal)+(profitLoss.dOtherIncome)+(profitLoss.dTravellingCost
								+
								profitLoss.dSalesandBuss)+(profitLoss.dPersonalCost)+(profitLoss.dFinanceCost)+
								(profitLoss.dCommunctionExpense)+(profitLoss.dAdminExpense)+(profitLoss.dRentCost)
								| number:2}}
					</thead>
				</table>
				<br> <br>
				<div class="col-sm-12 col-md-12 col-lg-12">
					
					<div class="col-sm-6 col-md-6 col-lg-6">

						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;">
							<tr style="background: #8C8CB5 !important;">
								<!-- <td class="width_10" align="center" style="font-size: 10px;"><b>Group Code</b></td> -->

								<td colspan="2" class="width_50" align="left" height="40"
									style="font-size: 10px;"><center>
										<font size="2" face="arial"><b>EXPENSES</b></font>
									</center></td>
							</tr>
							<tr style="background: #8C8CB5 !important;">
								<!-- <td class="width_10" align="center" style="font-size: 10px;"><b>Group Code</b></td> -->

								<td class="width_30" align="left" height="40"
									style="font-size: 10px;"><center>
										<font size="2" face="arial"><b>PARTICULARS</b></font>
									</center></td>
								<td class="width_30" align="left" height="40"
									style="font-size: 10px;"><center>
										<font size="2" face="arial"><b>AMOUNT</b></font>
									</center></td>
							</tr>

							<tr>
								<th class=" width_50" colspan="2"  style="font-size: 15px;  height: 40px;">
								<a ng-click="Click('DIRECT EXPENSES')"> <security:authorize
										access="hasRole('${form_code}_${view}')">
 
										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">DIRECT EXPENSES
											</span>
									</security:authorize></a>
								
								
								</th>
								
							</tr>

							<tbody id="sales-record">

								<tr ng-repeat="(trIndex, row) in profitLoss.lOtherExpense"
									ng-if="row.accountHeadNameAdmin !='' && row.accountHeadNameAdmin !=null">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										<a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										
										
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{row.amountAdmin | number:2}}
										&nbsp</td>


								</tr>

							</tbody>
						</table>




						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>


						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>

						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>



						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>


						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>


						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>

						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>


						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>
						<table ng-if="viewVer" width=95% align="center" cellSpacing="0"
							style="margin-left: 50px;"></table>

<!--np  -->
						<table = ng-if="viewRight" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;">

										
						
							<tr>
								<th class=" width_50"></th>
								<th class="text-center width_50 text-right">{{(-profitLoss.dCostOfSalesTotal)|
									number:2}}</th>
							</tr>
						
						
							<tr>
								<th class=" width_50">GROSS PROFIT C/O</th>
								<th class="text-center width_50 text-right">{{((profitLoss.dCostOfSalesTotal)-profitLoss.dSalesRevenueTotal)|
									number:2}}</th>
							</tr>



							

						</table>
<!--np  -->
<!-- nl -->

<table = ng-if="viewLeft" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px; ">
<tr>

	<th class="text-center width_50 text-right" colspan="2">{{(profitLoss.dCostOfSalesTotal)
									| number:2}}</th>
	</tr>
</table>
						<table = ng-if="viewLeft" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px; margin-top:15px">

							<!-- <tr>
								<th class=" width_50"></th>
								<th class="text-center width_50 text-right">{{(((profitLoss.dSalesRevenueTotal)+(profitLoss.dSalesRevenueTotal))-(-profitLoss.dCostOfSalesTotal))|
									number:2}}</th>
							</tr>
 -->

	

							<tr>
								<th class=" width_50">GROSS PROFIT C/F </th>  <!--  c/o to b/f -->
								<th class="text-center width_50 text-right">{{profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)|
									number:2}}</th>
							</tr>

							<tr>
								<th class=" width_50"></th>
								<th class="text-center width_50 text-right">{{(profitLoss.dSalesRevenueTotal)|
									number:2}}</th>
							</tr>
			 
			          <!--     <tr ng-if="pl.ntprofit > 0">
								<th class=" width_50">Net Profit2 </th>  
								<th class="text-center width_50 text-right">{{pl.ntprofit|
									number:2}}</th>
							</tr> -->

							<!-- <tr ng-if="profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal) > 0">
								<th class=" width_50">Net Profit2 </th>   c/o to b/f
								<th class="text-center width_50 text-right">{{profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)|
									number:2}}</th>
							</tr> -->

							

						</table>

<!-- nl -->
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>

						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px; margin-top: 10px;">


							<tr>
								<th class=" width_50" style="font-size: 15px;  height: 40px;">INDIRECT EXPENSES</th>
								<th class="text-center width_50 text-right"></th>




								<!-- 									{{((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
									(-profitLoss.dcommunicationCost)
									+(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost)) }} -->

							</tr>



							<tr>
								<th class=" width_50">
								<a ng-click="Click('TRAVELLING COST')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">TRAVELLING COST 
											</span>
									</security:authorize></a>
								
								
								</th>
								<th class="text-center width_50 text-right">{{-profitLoss.dtravellingcost
									| number:2}}</th>
							</tr>

							<tbody id="sales-record">

								<tr ng-repeat="(trIndex, row) in profitLoss.lTravellingCostList"
									ng-if="row.accountHeadNameAdmin !='' && row.accountHeadNameAdmin !=null">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										<a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{-row.amountAdmin | number:2}}
										&nbsp</td>


								</tr>

							</tbody>

							<tr>
								<th class=" width_50"> 
								
								<a ng-click="Click('SALES & BUSINESS PROMOTION COST')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">SALES & BUSINESS COST
											</span>
									</security:authorize></a>
								
								</th>
								<th class="text-center width_50 text-right">{{-profitLoss.dsalesCost
									| number:2}}</th>
							</tr>

							<tbody id="sales-record">

								<tr
									ng-repeat="(trIndex, row) in profitLoss.lSalesandBusinessList"
									ng-if="row.accountHeadNameAdmin !='' && row.accountHeadNameAdmin !=null">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										<a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{-row.amountAdmin | number:2}}
										&nbsp</td>


								</tr>

							</tbody>

							<tr>
								<th class=" width_50">
								
								<a ng-click="Click('PERSONNEL COST')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">PERSONEL COST 
											</span>
									</security:authorize></a>
								
								</th>
								<th class="text-center width_50 text-right">{{-profitLoss.dpersonalCost
									| number:2}}</th>
							</tr>

							<tbody id="sales-record">

								<tr ng-repeat="(trIndex, row) in profitLoss.lPersonalCostList"
									ng-if="row.accountHeadNameAdmin !='' && row.accountHeadNameAdmin !=null">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										
										<a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{-row.amountAdmin | number:2}}
										&nbsp</td>


								</tr>

							</tbody>
							<tr>
								<th class=" width_50"> 
								
								<a ng-click="Click('FINANCE COST')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">FINANCE COST
											</span>
									</security:authorize></a>
								
								</th>
								<th class="text-center width_50 text-right">{{-profitLoss.dfinanceCost
									| number:2}}</th>
							</tr>

							<tbody id="sales-record">

								<tr ng-repeat="(trIndex, row) in profitLoss.lFinanceCost"
									ng-if="row.accountHeadNameAdmin !='' && row.accountHeadNameAdmin !=null">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										<a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{-row.amountAdmin | number:2}}
										&nbsp</td>


								</tr>

							</tbody>


							<tr>
								<th class=" width_50">
								
								
								<a ng-click="Click('COMMUNICATION COST')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">COMMUNICATION COST
											</span>
									</security:authorize></a>
								
								 </th>
								<th class="text-center width_50 text-right">{{-profitLoss.dcommunicationCost
									| number:2}}</th>
							</tr>

							<tbody id="sales-record">

								<tr
									ng-repeat="(trIndex, row) in profitLoss.lCommuncationCostList"
									ng-if="row.accountHeadNameAdmin !='' && row.accountHeadNameAdmin !=null">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										<a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										
										
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{-row.amountAdmin | number:2}}
										&nbsp</td>


								</tr>

							</tbody>

							<tr>
								<th class=" width_50">  
								
								<a ng-click="Click('ADMINISTRATIVE COST')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">ADMINISTRATIVE COST
											</span>
									</security:authorize></a>
								</th>
								<th class="text-center width_50 text-right">{{-profitLoss.dAdminExpense
									| number:2}}</th>
							</tr>

							<tbody id="sales-record">

								<tr ng-repeat="(trIndex, row) in profitLoss.lAdminExpense"
									ng-if="row.accountHeadNameAdmin !='' && row.accountHeadNameAdmin !=null">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										<a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										
										
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{-row.amountAdmin | number:2}}
										&nbsp</td>


								</tr>

							</tbody>




							<tr>
								<th class=" width_50"> 
								
								<a ng-click="Click('CONVEYANCE COST')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">CONVEYANCE COST
											</span>
									</security:authorize></a>
								</th>
								<th class="text-center width_50 text-right">{{-profitLoss.dconveyencecost
									| number:2}}</th>
							</tr>

							<tbody id="sales-record">

								<tr ng-repeat="(trIndex, row) in profitLoss.lConveyenceCostList"
									ng-if="row.accountHeadNameAdmin !='' && row.accountHeadNameAdmin !=null">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										<a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{-row.amountAdmin | number:2}}
										&nbsp</td>


								</tr>

							</tbody>

							<tr>
								<th class=" width_50">
								<a ng-click="Click('RENT COSTS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">RENT COST 
											</span>
									</security:authorize></a>
								
								
								</th>
								<th class="text-center width_50 text-right">{{-profitLoss.dRentCost
									| number:2}}</th>
									
									
									
							</tr>
							
						

							<tbody id="sales-record">

								<tr ng-repeat="(trIndex, row) in profitLoss.lRentCostList"
									ng-if="row.accountHeadNameAdmin !='' && row.accountHeadNameAdmin !=null">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										<a ng-click="AccountClick(row.accountHeadNameAdmin)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										
										
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{-row.amountAdmin | number:2}}
										&nbsp</td>


								</tr>
									

							</tbody>

						</table>
						
						
						
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;">


							<tr>
								<th class=" width_50"></th>
								<th class="text-center width_50 text-right">{{(-profitLoss.dpersonalCost)+
									(-profitLoss.dsalesCost)+
									(-profitLoss.dtravellingcost)+(-profitLoss.dcommunicationCost)+
									(-profitLoss.dRentCost) + (-profitLoss.dAdminExpense) +
									(-profitLoss.dfinanceCost)+ (-profitLoss.dconveyencecost) |
									number:2}}</th>

							</tr>

						</table>
						
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px; margin-top:10px">
						<tr ng-if="pl.ntprofit > 0">
								<th class=" width_50">NET PROFIT</th>
								<th class="text-center width_50 text-right">{{pl.ntprofit | number:2}}
								</th>
							     </tr>
						</table>








						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>


						<table ng-if="viewRight" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 50px;">

							<!-- 	 ntloss = amount-(totl+dOtherIncome);
					ntprof=dOtherIncome-(totl+amount); -->


<!-- 
				 			<tr>
								<th class=" width_50">Net Profit</th>
								<th class="text-center width_50 text-right">{{
								((-profitLoss.dOtherIncome))
									-
									((((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
									(-profitLoss.dcommunicationCost)
									+(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost) +
									(-profitLoss.dconveyencecost))  +  (-((-profitLoss.dCostOfSalesTotal)-profitLoss.dSalesRevenueTotal))))| number:2}}</th>
							</tr> -->
							
							
	
							
							




						</table>

					</div>
					<div class="col-sm-6 col-md-6 col-lg-6">
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 10px;">
							<tr style="background: #8C8CB5 !important;">
								<!-- <td class="width_10" align="center" style="font-size: 10px;"><b>Group Code</b></td> -->
								<td colspan="2" class="width_50" align="left" height="40"
									style="font-size: 10px;"><center>
										<font size="2" face="arial"><b>INCOME</b></font>
									</center></td>

							</tr>
							<tr style="background: #8C8CB5 !important;">
								<!-- <td class="width_10" align="center" style="font-size: 10px;"><b>Group Code</b></td> -->
								<td class="width_30" align="left" height="40"
									style="font-size: 10px;"><center>
										<font size="2" face="arial"><b>PARTICULARS</b></font>
									</center></td>
								<td class="width_10" align="left" height="40"
									style="font-size: 10px;"><center>
										<font size="2" face="arial"><b>AMOUNT</b></font>
									</center></td>

							</tr>

							<tr>
								<th class=" width_50" colspan="2"  style="font-size: 15px;  height: 40px;"> 
								
								<a ng-click="Click('DIRECT INCOMES')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">DIRECT INCOMES
											</span>
									</security:authorize></a>
								
								</th>
							<!-- 12-04-2019	<th class="text-center width_50 text-right">{{profitLoss.dSalesRevenueTotal
									| number:2}}</th>-->
							</tr>
							<tbody id="sales-record">
								<tr ng-repeat="(trIndex, row) in profitLoss.lSalesRevenue">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp
										<a ng-click="AccountClick(row.accountHeadName)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										
										 </td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{row.amount | number:2}} &nbsp</td>
								</tr>

							</tbody>





						</table>

						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>

						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>

						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>


<!--np  -->
						<table ng-if="viewRight" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 10px;">


							<tr>
								<th class=" width_50">GROSS PROFIT C/F </th>
								<th class="text-center width_50 text-right">{{((-profitLoss.dCostOfSalesTotal)-profitLoss.dSalesRevenueTotal)|
									number:2}}</th>
							</tr>

							<tr>
								<th class=" width_50"></th>
								<th class="text-center width_50 text-right">{{(profitLoss.dCostOfSalesTotal)|
									number:2}}</th>
							</tr>

						</table>

<!--np  -->

<!--nl  -->

<table ng-if="viewLeft" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 10px;">
<tr>
								<th class=" width_50"></th>
								<th class="text-center width_50 text-right">{{(profitLoss.dSalesRevenueTotal)|
									number:2}}</th>
							</tr>
</table>
						<table ng-if="viewLeft" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 10px;     margin-top: 15px;">
							

							<tr>
								<th class=" width_50">GROSS PROFIT B/F </th>   <!-- B/f to c/f -->
								<th class="text-center width_50 text-right">{{profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)|
									number:2}}</th>
							</tr>





						</table>

<!--nl  -->


						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>
						<table  width=80% align="center" border="1"></table>




						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 10px; margin-top:10px">

							<tr>
								<th class=" width_50" style="font-size: 15px;  height: 40px;">
								
								<a ng-click="Click('INDIRECT INCOME')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">INDIRECT INCOMES 
											</span>
									</security:authorize></a>
								
								</th>
								<th class="text-center width_50 text-right"></th>
							</tr>
							<tbody id="sales-record">
								<tr ng-repeat="(trIndex, row) in profitLoss.lOtherIncome">
									<td class="width_30" align="left" height="20"
										style="font-size: 10px;">&nbsp 
										<a ng-click="AccountClick(row.accountHeadName)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black" data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{row.accountHead}}
											</span>
									</security:authorize></a>
										
										</td>
									<td class="width_30" align="right" height="20"
										style="font-size: 10px;">{{row.amount | number:2}} &nbsp</td>
								</tr>

							</tbody>




						</table>
						<table ng-if="viewVer" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 10px;">

							<tr>
								<th class=" width_50" style="font-size: 15px;">						
								
								
								</th>
								<th class="text-center width_50 text-right">{{profitLoss.dOtherIncome

									| number:2}}</th>
							</tr>
							</table>






						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>
						<table ng-if="viewVer" width=80% align="center" border="1"></table>


						<table ng-if="viewLeft" width=95% align="center" border="1"
							cellpadding="10" cellSpacing="0" style="margin-left: 10px; margin-top:10px">



                     <tr ng-if="pl.ntprofit < 0">
							<!--	<th class=" width_50" ng-if="pl.ntFlag==true">Net Profit</th>
								<th class=" width_50" ng-if="pl.ntFlag==false">Net Loss</th>
								<th class="text-center width_50 text-right">{{pl.ntloss| number:2}}</th>-->

								<th class=" width_50" >NET LOSS</th>
								<th class="text-center width_50 text-right">{{-pl.ntprofit| number:2}}</th>
							</tr>

							<%-- <tr ng-if="profitLoss.dSalesRevenueTotal-profitLoss.dCostOfSalesTotal < 0">
							<!--	<th class=" width_50" ng-if="pl.ntFlag==true">Net Profit</th>
								<th class=" width_50" ng-if="pl.ntFlag==false">Net Loss</th>
								<th class="text-center width_50 text-right">{{pl.ntloss| number:2}}</th>-->

								<th class=" width_50" >Net Loss1</th>
								<th class="text-center width_50 text-right">{{pl.ntloss| number:2}}</th>
							</tr> --%>

						</table>








					</div>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12"
					style="padding-top: 24px;">









					<table ng-if="viewRight" width=80% align="center" border="1"
						cellpadding="10" cellSpacing="0"
						style="margin-left: 138px; width: 88%;">




						<tr>
							<!-- <td class="width_10" align="left" height="30"
								style="background: #D37878 !important" style="font-size: 10px;"><font
								size="2" face="arial"><b>&nbsp TOTAL</b></font></td>
							<td class="text-center width_15 text-left"
								style="background: #D37878 !important"><b>{{(-profitLoss.dOtherIncome)|
									number:2 }}&nbsp</b></td>
							<td class="width_10" align="left" height="30"
								style="background: #D37878 !important" style="font-size: 10px;"><font
								size="2" face="arial"><b>&nbspTOTAL</b></font></td>
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
									number:2 }}&nbsp</b></td> -->
						</tr>


					</table>





					<table ng-if="viewLeft" width=80% align="center" border="1"
						cellpadding="10" cellSpacing="0"
						style="margin-left: 138px; width: 88%;">




						<tr>
							<%-- <td class="width_10" align="left" height="30"
								style="background: #D37878 !important" style="font-size: 10px;"><font
								size="2" face="arial"><b>&nbsp TOTAL</b></font></td>
							<td class="text-center width_15 text-left"
								style="background: #D37878 !important" ng-if="profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal) > 0 "><b>{{(((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
									(-profitLoss.dcommunicationCost)
									+(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost)+(-profitLoss.dconveyencecost)+profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal)))|
									number:2 }}&nbsp</b></td>
							<td class="text-center width_15 text-left"
								style="background: #D37878 !important" ng-if="profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal) < 0 "><b>{{(((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
									(-profitLoss.dcommunicationCost)
									+(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost)+(-profitLoss.dconveyencecost)))|
									number:2 }}&nbsp</b></td> --%>	
									
									
									<td class="width_10" align="left" height="30"
								style="background: #D37878 !important" style="font-size: 10px;"><font
								size="2" face="arial"><b>&nbsp TOTAL</b></font></td>
							<td class="text-center width_15 text-left"
								style="background: #D37878 !important"><b>{{pl.total1|
									number:2 }}&nbsp</b></td>
					<%-- 		<td class="text-center width_15 text-left"
								style="background: #D37878 !important" ng-if="profitLoss.dSalesRevenueTotal-(profitLoss.dCostOfSalesTotal) < 0 "><b>{{(((-profitLoss.dtravellingcost)+(-profitLoss.dsalesCost)+(-profitLoss.dpersonalCost)+(-profitLoss.dfinanceCost)+
									(-profitLoss.dcommunicationCost)
									+(-profitLoss.dAdminExpense)+(-profitLoss.dRentCost)+(-profitLoss.dconveyencecost)))|
									number:2 }}&nbsp</b></td>	 --%>	
										
									
						
						
						
						
						
							<td class="width_10" align="left" height="30"
								style="background: #D37878 !important" style="font-size: 10px;"><font
								size="2" face="arial"><b>&nbspTOTAL</b></font></td>
							<td class="text-center width_15 text-right"
								style="background: #D37878 !important"><b>{{pl.total2|
									number:2}}&nbsp</b></td>
									
							
						</tr>


					</table>
				</div>
			</form>
		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
</div>
<!-- /wrapper-md -->



