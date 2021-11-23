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
			<form class="form-horizontal" name="balanceSheetsearchForm">
				<div class="row">
					<!-- <div class="col-sm-12 col-md-4 col-lg-4">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label"> Company
								<span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<selectivity list="companyList" property="balanceSheet.company" id="company" object="companyCode"></selectivity>
							</div>
						</div>
					</fieldset>
				</div> -->
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<input type="hidden" id="companyCode" value="${user.companyCode}">
							<div class="form-group">
								<label class="col-md-5 control-label"> Organization <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">

									<selectivity list="companyList" ng-model="balanceSheet.company"
										property="balanceSheet.company" id="company" object="company"
										name="organization"></selectivity>

									<!--  <select id="txtCompanyCode" multiple="multiple" name="multiselect[]" ng-model="companyCodes"
											 ng-options="option.id as option.text for option in companyList" data-dropdownmultiselect>    
											   <option data-ng-repeat="option in companyList" value="{{getOptionId(option)}}" 
											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
											</select> -->
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5">To
									Date <span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<div class="input-group input-append date" id="bs_fromDate">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="balanceSheet.fromDate"
											name="fromDate" id="fromDate"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<a id="BSExport" stype="display:none"
					href="filePath/BalanceSheet.xls" download="BalanceSheet.xls"></a>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">


							<security:authorize access="hasRole('${form_code}_${view}')">
								<button class="btn btn-success" type="button"
									class="btn btn-success"
									data-ng-click="generateBalanceSheetReportNewVer(balanceSheet.company)">
									Generate Report</button>
							</security:authorize>

							

							<security:authorize access="hasRole('${form_code}_${export}')">
								<button class="btn btn-primary" ng-click="exportVEExcel()">
									<i class="fa fa-download"></i>Export Excel



								</button>
							</security:authorize>




						</div>
					</div>
				</div>

				<br>
				<div class="span12">

					<div
						class="main_head  bold toggleBlock-currsor text-center fontSize16 ">
						BALANCE SHEET <span ng-if="comName !=''">-</span> {{comName}}
					</div>
			<!-- <table class="table table-striped table-hover data-table no-footer"	
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="text-center width_50"
									style="background: #8C8CB5 !important;">Current Liablities
								</th>
								<th style="background: #8C8CB5 !important;"></th>
							</tr>
							<tr>
								<th class="text-center width_50"
									style="background: #8C8CB5 !important;">Non-Current Assets</th>
								<th style="background: #8C8CB5 !important;"></th>
							</tr>
						</thead>
					</table> -->
					<!-- <table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('vsl-record')">
								<th class=" width_50">Vessels and Equipment - ( A )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dVesselEquipment
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="vsl-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lVesselEquipment">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table> -->
					<!-- <table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('invs-record')">
								<th class=" width_50">Investment - ( B )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dInvestment
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="invs-record">
							<tr ng-repeat="(trIndex, row) in balanceSheetList.lInvestment">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>

					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr class="main_head">
								<th class="text-center width_50 "
									style="background: #D37878 !important">TOTAL C= A+B</th>
								<th class="text-center width_50 text-right"
									style="background: #D37878 !important">{{balanceSheetList.dVesselEquipment
									+ balanceSheetList.dInvestment | number:2}}</th>
							</tr>
						</thead>
					</table> -->
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="text-center width_50"
									style="background: #8C8CB5 !important;">Current Assets</th>
								<th style="background: #8C8CB5 !important;"></th>
							</tr>
						</thead>
					</table>

					<!-- <table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('invn-record')">
								<th class=" width_50">Inventories - ( D )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dInventories
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="invn-record">
							<tr ng-repeat="(trIndex, row) in balanceSheetList.lInventories">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table> -->

					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('arp-record')">
								<th class=" width_50">Bank Accounts - ( A )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dAccountReceivable
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="arp-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lAccountReceivable">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>

					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('bbc-record')">
								<th class=" width_50">Cash In Hand - ( B )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dCashBalances
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="bbc-record">
							<tr ng-repeat="(trIndex, row) in balanceSheetList.lCashBalances">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>

					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('dep-record')">
								<th class=" width_50">Deposits - ( C )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dDepositsBalances
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="dep-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lDepositsBalances">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('loa-record')">
								<th class=" width_50">Loans & Advances - ( D )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dLoanBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="loa-record">
							<tr ng-repeat="(trIndex, row) in balanceSheetList.lLoanBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('fix-record')">
								<th class=" width_50">Fixed Assets - ( E )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dFixedBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="fix-record">
							<tr ng-repeat="(trIndex, row) in balanceSheetList.lFixedBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('mis-record')">
								<th class=" width_50">Misc. Expenses ( F )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dMiscBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="mis-record">
							<tr ng-repeat="(trIndex, row) in balanceSheetList.lMiscBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('sun-record')">
								<th class=" width_50">Sundry Debtors - ( G )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dSundryBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="sun-record">
							<tr ng-repeat="(trIndex, row) in balanceSheetList.lSundryBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>

					<!-- <table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr class="main_head">
								<th class="text-center width_50 "
									style="background: #D37878 !important">TOTAL G= D+E+F</th>
								<th class="text-center width_50 text-right"
									style="background: #D37878 !important">{{(balanceSheetList.dInventories
									+ balanceSheetList.dAccountReceivable +
									balanceSheetList.dBankAndCashBalances) | number:2}}</th>
							</tr>
						</thead>
					</table> -->

					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr class="main_head">
								<th class="text-center width_50 "
									style="background: #D37878 !important">Total Assets (A + B
									+ C + D + E + F + G)</th>
								<th class="text-center width_50 text-right"
									style="background: #D37878 !important">{{(balanceSheetList.dAccountReceivable
									+
									balanceSheetList.dCashBalances)+(balanceSheetList.dDepositsBalances
									+ balanceSheetList.dLoanBalance +
									balanceSheetList.dFixedBalance+balanceSheetList.dMiscBalance +
									balanceSheetList.dSundryBalance) | number:2}}</th>
							</tr>
						</thead>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="text-center width_50"
									style="background: #8C8CB5 !important;">Current
									Liabilities</th>
								<th style="background: #8C8CB5 !important;"></th>
							</tr>
						</thead>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('unl-record')">
								<th class=" width_50">Unsecured Loans - ( H )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dUnsecuredBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="unl-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lUnsecuredBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('pro-record')">
								<th class=" width_50">Provisions - ( I )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dProvisionsBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="pro-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lProvisionsBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('tax-record')">
								<th class=" width_50">Tax Deducted at Source - ( J )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dTaxDeductedBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="tax-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lTaxDeductedBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('prov-record')">
								<th class=" width_50">Provident Fund - ( K )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dProvidentBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="prov-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lProvidentBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('res-record')">
								<th class=" width_50">Reserves & Surplus - ( L )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dReservesBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="res-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lReservesBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('sunc-record')">
								<th class=" width_50">Sundry Creditors - ( M )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dSundryCreditorsBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="sunc-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lSundryCreditorsBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('oth-record')">
								<th class=" width_50">Other Payables - ( N )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dOTHERPAYABLESBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="oth-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lOTHERPAYABLESBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('secl-record')">
								<th class=" width_50">Secured Loans - ( O )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dSecuredLoansBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="secl-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lSecuredLoansBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('icom-record')">
								<th class=" width_50">Inter Company - ( P )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dINTERCOMPANYBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="icom-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lINTERCOMPANYBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('gst-record')">
								<th class=" width_50">GST - ( Q )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dGSTBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="gst-record">
							<tr ng-repeat="(trIndex, row) in balanceSheetList.lGSTBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr ng-click="toggleBlock('advb-record')">
								<th class=" width_50">Advances - ( R )</th>
								<th class="text-center width_50 text-right">{{balanceSheetList.dADVANCESBalance
									| number:2}}</th>
							</tr>
						</thead>
						<tbody id="advb-record">
							<tr
								ng-repeat="(trIndex, row) in balanceSheetList.lADVANCESBalance">
								<td class="sorting ">{{row.accountHeadName}}</td>
								<td class="sorting text-right">{{row.amount | number:2}}</td>

							</tr>
						</tbody>
					</table>
					<table class="table table-striped table-hover data-table no-footer"
						ng-if="viewHor">
						<thead class="dataTables-Main-Head">
							<tr class="main_head">
								<th class="text-center width_50 "
									style="background: #D37878 !important">Total Liabilities
									(H + I + J + K + L + M + N + O + P + Q + R)</th>
								<th class="text-center width_50 text-right"
									style="background: #D37878 !important">{{(balanceSheetList.dUnsecuredBalance
									+
									balanceSheetList.dProvisionsBalance)+(balanceSheetList.dTaxDeductedBalance
									+ balanceSheetList.dProvidentBalance +
									balanceSheetList.dReservesBalance+balanceSheetList.dSundryCreditorsBalance
									+ balanceSheetList.dOTHERPAYABLESBalance +
									balanceSheetList.dSecuredLoansBalance +
									balanceSheetList.dINTERCOMPANYBalance +
									balanceSheetList.dGSTBalance +
									balanceSheetList.dADVANCESBalance) | number:2}}</th>
							</tr>
						</thead>
					</table>
					<br> <br>
					<table ng-if="viewVer" width=80% align="center" border="1"
						cellpadding="10" cellSpacing="0" style="margin-left: 125px;">
						<tr style="background: #375785 !important;color: #FFF;">
							<!-- <td class="width_10" align="center" style="font-size: 11px;"><b>Group Code</b></td> -->
							<td colspan="2" class="width_50" align="left" height="40"
								style="font-size: 11px;"><center>
									<font size="2" face="arial"><b>LIABLITIES</b></font>
								</center></td>

							<td colspan="2" class="width_50" align="left" height="40"
								style="font-size: 11px;"><center>
									<font size="2" face="arial"><b>ASSETS</b></font>
								</center></td>
						</tr>
						<tr style="background: #375785 !important;color: #FFF;">
							<!-- <td class="width_10" align="center" style="font-size: 11px;"><b>Group Code</b></td> -->
							<td class="width_30" align="left" height="40"
								style="font-size: 11px;"><center>
									<font size="2" face="arial"><b>PARTICULARS</b></font>
								</center></td>
							<td class="width_10" align="left" height="40"
								style="font-size: 11px;"><center>
									<font size="2" face="arial"><b>AMOUNT</b></font>
								</center></td>
							<td class="width_30" align="left" height="40"
								style="font-size: 11px;"><center>
									<font size="2" face="arial"><b>PARTICULARS</b></font>
								</center></td>
							<td class="width_10" align="left" height="40"
								style="font-size: 11px;"><center>
									<font size="2" face="arial"><b>AMOUNT</b></font>
								</center></td>
						</tr>

						<tr>


							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <b ng-click="Click('CAPITAL ACCOUNTS')" style="cursor: pointer">CAPITAL ACCOUNT</b></td>

							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp <b>{{balanceSheetList.capitalAccount
									| number:2}}</b></td>

							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('FIXED ASSETS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span "><b> FIXED ASSETS</b></span>
									</security:authorize></a> </font></td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp <b>{{balanceSheetList.tfixedasset
									| number:2}}</b></td>


						</tr>

						<tr>



							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('RESERVES & SURPLUS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">2010-RESERVES & SURPLUS</span>
									</security:authorize></a>

							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.reverseSurplus
								| number:2}}</td>


							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('COMPUTER')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span ">
											{{balanceSheetList.computerName}}</span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tcomputer
								| number:2}}</td>

						</tr>
						<tr>



							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a><span tooltip="test"
								style="color: black" data-toggle="tooltip"
								title="Click to here view ledger" class="tool-tip-span " ng-click="Click('SHARE CAPITAL')" class="tool-tip-span">2010-SHARE
									CAPITAL</span></a> <%-- <a ng-click="Click('SHARE CAPITAL')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										
									</security:authorize></a> --%>


							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp {{balanceSheetList.shareCapital | number:2}}</td>
							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('FURNITURE & FIXTURES')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{balanceSheetList.furniturefixturesName}}</span>
									</security:authorize></a>



							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp
								{{balanceSheetList.tfurniture | number:2}}</td>
						</tr>

						<tr>



							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <b> LOANS (LIABILITY)</b></font></td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp <b>{{balanceSheetList.tloanliab
									| number:2}}</b></td>
							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('OFFICE EQUIPMENT')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span ">
											{{balanceSheetList.officeequipmentName}}</span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tofc |
								number:2}}</td>
						</tr>

						<tr>
				


							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('SECURED LOANS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{balanceSheetList.securedloansName}}</span>
									</security:authorize></a>

							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tsecuredloans
								| number:2}}</td>
								
											<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('SOFTWARE')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span ">
											{{balanceSheetList.softwareName}} </span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tsoftware
								| number:2}}</td>
						</tr>


						<tr>
					

							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('UNSECURED LOANS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span ">
											{{balanceSheetList.unsecuredloansName}}</span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tunsecuredloans
								| number:2}}</td>
										<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('SOFTWARE IGST')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span ">{{balanceSheetList.softwareigstName}}</span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tsoftwareigst
								| number:2}}</td>
						</tr>







						<tr>
							


							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <%-- <a ng-click="Click('ADV RECD FROM TRANSCAB TRADERS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										
									</security:authorize></a>  --%> <a><span tooltip="test"
								style="color: black" data-toggle="tooltip"
								title="Click to here view ledger" class="tool-tip-span" ng-click="Click('ADVANCE FROM MIT-MOL CONVEYORS PVT LTD')">
									ADVANCE FROM MIT-MOL CONVEYORS PVT LTD</span></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp {{balanceSheetList.advanceFromMit |
								number:2}}</td>
								
									<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('OFFICE PREMISES')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span ">{{balanceSheetList.ofcpremname}}</span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.ofcprem
								| number:2}}</td>
								
								
								
							


						</tr>

						<tr>


							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <b> CURRENT LIABILITIES</b></font></td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp <b>
									{{balanceSheetList.tcurrentlia | number:2}}</b></td>
									
										<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <b> CURRENT ASSETS</b></font></td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp <b>{{balanceSheetList.tcurrentasset
									| number:2}}</b></td>
																
						</tr>
						<tr>


							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('DUTIES & TAXES')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">{{balanceSheetList.dutiestaxesName}}</span>
									</security:authorize></a>

							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tduties |
								number:2}}</td>
								<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('DEPOSITS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span ">
											{{balanceSheetList.depositsName}}</span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tdeposit |
								number:2}}</td>
														
						</tr>

						<tr>
							


							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('PROVISIONS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">
											{{balanceSheetList.provisionsName}} </span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tprovisions
								| number:2}}</td>
								
									<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('LOANS & ADVANCES')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span ">
											{{balanceSheetList.loansadvancesName}} </span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tloanadv |
								number:2}}</td>
								
						</tr>




						<tr>
							

							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('SUNDRY CREDITORS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">
											{{balanceSheetList.sundrycreditorsName}} </span>
									</security:authorize></a>


							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tsundrycredit
								| number:2}}</td>
								
								<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('SUNDRY DEBTORS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">
										
										

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">
											{{balanceSheetList.sundrydebtorsName}}</span>
									</security:authorize></a>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tsundrydebtors
								| number:2}}</td>
								


						</tr>


						<tr>
	

							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <%-- <a ng-click="Click('ADV. AGAINST PORT DEPOSIT')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										
									</security:authorize></a> --%> <a><span tooltip="test"
								style="color: black" data-toggle="tooltip"
								title="Click to here view ledger" class="tool-tip-span" ng-click="Click('GST OUTPUT')" >
									{{balanceSheetList.outputgstliab}}</span></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tgst
								| number:2}}</td>
								
								<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('CASH IN HAND')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">
											{{balanceSheetList.cashinhandName}} </span>
									</security:authorize></a>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tcash |
								number:2}}</td>
								
								
								
														


						</tr>

						<tr>




							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <%-- <a ng-click="Click('AUDIT FEES PAYABLE')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										
									</security:authorize></a> --%> <span tooltip="test"
								style="color: black" data-toggle="tooltip"
								title="Click to here view ledger" class="tool-tip-span">
									AUDIT FEES PAYABLE </span>
							</td>
							
                          <td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp {{ 0 | number:2}}</td>

<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('BANK ACCOUNTS')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">
											{{balanceSheetList.bankaccountsName}}</span>
									</security:authorize></a>
							</td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tbank |
								number:2}}</td>

                        

								
					
						</tr>

						<tr>



							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a><span tooltip="test"
								style="color: black" data-toggle="tooltip"
								title="Click to here view ledger" class="tool-tip-span" ng-click="Click('DEFERRED TAX(LIABILITY)')">20070001-DEFERRED TAX(LIABILITY)
								</span></a> <%-- <a ng-click="Click('DEFERRED TAX')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										
									</security:authorize></a --%>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tdeferredtax
								| number:2}}</td>
								
								 <td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('GST INPUT')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span">
											{{balanceSheetList.inputgstasset}}
							 </span>
									</security:authorize></a>


                           </td>


							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.dgst |
								number:2}}</td>
								
								
					    
								
					</tr>

						<tr>
										
					     <td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a ><span tooltip="test"
								style="color: black" data-toggle="tooltip" 
								title="Click to here view ledger" class="tool-tip-span">2009-MLWF (PROVIDENT FUND)</span> </a>
							
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.providentFund | number:2}}</td>
								
								 <td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a ng-click="Click('MISC. EXPENSES')"><span tooltip="test"
								style="color: black" data-toggle="tooltip" 
								title="Click to here view ledger" class="tool-tip-span">1015-MISC. EXPENSES	</span> </a>
							
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{balanceSheetList.tmiscexp | number:2}}</td>
								
							
						


						</tr>
				
						<tr>
<!-- 						  <td class="width_30" align="left" height="20" -->
<!-- 								style="font-size: 11px;">&nbsp <a><span tooltip="test" -->
<!-- 								style="color: black" data-toggle="tooltip"  -->
<!-- 								title="Click to here view ledger" class="tool-tip-span">2013-OPENING BALANCE TRANSFER ENTRIES</span> </a> -->
							
<!-- 							<td class="width_30" align="right" height="20" -->
<!-- 								style="font-size: 11px;">&nbsp{{balanceSheetList.openingTransEntries}}</td> -->
<!-- <td></td> -->
<!-- <td></td> -->

 <td class="width_30" align="left" height="20"  
								style="font-size: 11px;">&nbsp <a><span tooltip="test"  
								style="color: black" data-toggle="tooltip" 
								title="Click to here view ledger" class="tool-tip-span" ng-click="Click('OTHER PAYABLES')">OTHERS</span> </a>  
							
 							<td class="width_20" align="right" height="20"
 								style="font-size: 11px;">&nbsp{{balanceSheetList.dothers | number:2}}</td> 
 								
 									<%-- <td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('INTER COMPANY')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span "><b>BRANCH / DIVISIONS</b></span>
									</security:authorize></a>



							</td> --%>
							<!-- <td class="width_20" align="right" height="20"
								style="font-size: 11px;"
								ng-if="balanceSheetList.dINTERCOMPANYBalance != ''">&nbsp<b>{{balanceSheetList.dINTERCOMPANYBalance
									| number:2}}</b></td>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;"
								ng-if="balanceSheetList.dINTERCOMPANYBalance == 0">&nbsp<b>{{0
									| number:2}}</b></td> -->
							
							<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <b> PROFIT & LOSS A/C</b>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="check==1">&nbsp<b>  {{-(balanceSheetList.currentperiodearning)
									| number:2}}</b></td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="check==2">&nbsp<b>  {{-(balanceSheetList.currentperiodearning)
									| number:2}}</b></td>

						</tr>

						<%-- <tr>
<!-- 						<td></td> -->
<!-- 						<td></td> -->
 <td></td> 
 <td></td> 

<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('INTER COMPANY MANAGING ACCOUNTS - MUM')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span "> 20080001 - INTER COMPANY
											MANAGING ACCOUNTS - MUM</span>
									</security:authorize></a>


							</td>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="checked1 == 1">&nbsp{{
								mumamount | number:2}}</td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="checked1 != 1">&nbsp{{0 | number:2}}</td>
				

							
							
						</tr>
						<tr>
<!-- 						<td></td> -->
<!-- 							<td></td> -->
<td></td>
<td></td>
						
<!-- 				 <td class="width_30" align="left" height="20"  -->
<!-- 								style="font-size: 11px;">&nbsp <a><span tooltip="test"  -->
<!-- 								style="color: black" data-toggle="tooltip"   -->
<!-- 								title="Click to here view ledger" class="tool-tip-span">OTHERS</span> </a>  -->
							
<!-- 							<td class="width_30" align="right" height="20" -->
<!-- 								style="font-size: 11px;">&nbsp{{balanceSheetList.dothers}}</td>  -->
<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('INTER COMPANY MANAGING ACCOUNTS - AMD')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span "> 20080003 - INTER COMPANY
											MANAGING ACCOUNTS - AMD</span>
									</security:authorize></a>

							</td>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="checked2 == 2">&nbsp{{amdamount
								| number:2}}</td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="checked2 != 2">&nbsp{{0}}</td>

							

						</tr>
						<tr>
						<td ></td>
						<td ></td>
						<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('INTER COMPANY MANAGING ACCOUNTS - DEL')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span "> 20080005 - INTER COMPANY
											MANAGING ACCOUNTS - DEL</span>
									</security:authorize></a>



							</td>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="checked3 == 3">&nbsp{{delamount
								| number:2}}</td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="checked3 != 3">&nbsp{{0}}</td>
							
						</tr>
						<tr>
						<td ></td>
						<td ></td>
						
						<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('INTER COMPANY MANAGING ACCOUNTS - LUD')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span "> 20080006 - INTER COMPANY
											MANAGING ACCOUNTS - LUD</span>
									</security:authorize></a>


							</td>

							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="checked4 == 4">&nbsp{{ludmumamount
								| number:2}}</td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="checked4 != 4">&nbsp{{0}}</td>
						
							

						</tr>
						<tr>
						<td ></td>
						<td ></td>
						
						<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('INTER COMPANY MANAGING ACCOUNTS - MUN')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span "> 20080007 - INTER COMPANY
											MANAGING ACCOUNTS - MUN</span>
									</security:authorize></a>



							</td>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="checked5 == 5">&nbsp{{munmumamount
								| number:2}}</td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="checked5 != 5">&nbsp{{0}}</td>
							

						</tr>
						<tr>
						<td ></td>
						<td ></td>
						
						<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('INTER COMPANY MANAGING ACCOUNTS - PUN')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span "> 20080008 - INTER COMPANY
											MANAGING ACCOUNTS - PUNE</span>
									</security:authorize></a>


							</td>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="checked6 == 6">&nbsp{{punemumamount
								| number:2}}</td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="checked6 != 6">&nbsp{{0}}</td>
							  

						</tr>
						<tr>
						<td ></td>
						<td ></td>
						
						<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <a
								ng-click="Click('INTER COMPANY MANAGING ACCOUNTS - CHN')"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="test" style="color: black"
											data-toggle="tooltip" title="Click to here view ledger"
											class="tool-tip-span "> 20080009 -INTER COMPANY
											MANAGING ACCOUNTS - CHN</span>
									</security:authorize></a>


							</td>
							
							
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="checked7 == 7">&nbsp{{hoamount
								| number:2}}</td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="checked7 != 7">&nbsp{{0}}</td>
							

						</tr> --%>
						<!-- <tr>
						<td ></td>
						<td ></td>
						
						<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp <b> PROFIT & LOSS A/C</b>
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="check==1">&nbsp<b>  {{-(balanceSheetList.currentperiodearning)
									| number:2}}</b></td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="check==2">&nbsp<b>  {{-(balanceSheetList.currentperiodearning)
									| number:2}}</b></td>
							

						</tr> -->
						<tr>
						<td ></td>
						<td ></td>
						<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp OPENING BALANCE
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;">&nbsp{{openingBalance| number:2 }}</td>
							

						</tr>
						
							<tr>
						<td ></td>
						<td ></td>
						<td class="width_30" align="left" height="20"
								style="font-size: 11px;">&nbsp CURRENT PERIOD
							<td class="width_20" align="right" height="20"
								style="font-size: 11px;" ng-if="check==1">
								&nbsp{{ -(balanceSheetList.currentperiodearning + balanceSheetList.openingTransEntries)
									| number:2}}</td>
							<td class="width_30" align="right" height="20"
								style="font-size: 11px;" ng-if="check==2">
								&nbsp{{ -(balanceSheetList.currentperiodearning + balanceSheetList.openingTransEntries)
									| number:2}}</td>

						</tr>


						<tr>
						<tbody id="sales-record">


						</tbody>
						<tr>
					
							<td class="width_10" align="left" height="30"
								style="background: #D37878 !important" style="font-size: 11px;"><font
								size="2" face="arial"><b>&nbsp SUBTOTAL FOR
										LIABILITIES</b></font></td>
							<td class="text-center width_20 text-right"
								style="background: #D37878 !important"><b>{{-totalone  |
									number:2}}&nbsp</b></td>
											<td class="width_10" align="left" height="30"
								style="background: #D37878 !important" style="font-size: 11px;"><font
								size="2" face="arial"><b>&nbspSUBTOTAL FOR ASSET</b></font></td>

							<td class="text-center width_20 text-right"
								style="background: #D37878 !important" align="right"
								ng-if="check==1"><b>
								{{balanceSheetList.tfixedasset + balanceSheetList.tcurrentasset
							         + balanceSheetList.dINTERCOMPANYBalance - balanceSheetList.currentperiodearning
							          | number:2}}&nbsp </b></td>
<!-- 								{{-totalone | number:2}}&nbsp </b></td> -->
							<td class="text-center width_20 text-right"
								style="background: #D37878 !important" align="right"
								ng-if="check==2"><b>
								
								{{balanceSheetList.tfixedasset + balanceSheetList.tcurrentasset
							         + balanceSheetList.dINTERCOMPANYBalance - balanceSheetList.currentperiodearning
							          | number:2}}&nbsp </b></td>
<!-- 								{{-totalone | number:2}}&nbsp </b></td> -->
							<td class="text-center width_20 text-right"
								style="background: #D37878 !important" align="right"
								ng-if="check==3"><b>{{0 | number:2}}&nbsp </b></td>



						</tr>

						<!-- <tr>
							<td colspan="2" class="width_10" align="right" height="40"
								style="font-size: 11px;"><center>
									<font size="2" face="arial"><b>GRAND TOTAL</b></font>
								</center></td>
							<td colspan="2" class="text-center width_50 text-right"><b>{{balanceSheetList.dReservesBalance + balanceSheetList.tloanliab
							 + balanceSheetList.tcurrentlia	+ balanceSheetList.tcurrentasset
							+ balanceSheetList.tfixedasset 	+ balanceSheetList.tmiscexp  | number:2}}&nbsp</b></td>
						</tr> -->

					</table>

				</div>
			</form>
		</div>
	</div>
</div>
