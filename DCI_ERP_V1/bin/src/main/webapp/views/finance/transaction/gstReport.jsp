<style>
.table>tbody+tbody {
	border-top: none;
}

.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #6c986c;
}

.nav-justified>li, .nav-tabs.nav-justified>li:active {
	background-color: #fff;
}

.nav-tabs>li.active {
	background-color: #fff;
	border: 1px solid #375785;
}

.tab-head {
	background: dodgerblue !important;
	color: black;
}

.tabOwnCss>ul>li>a {
	height: 78px;
	color: #fff;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}

.nav>li>a:hover, .nav>li>a:focus {
	background-color: rgba(5, 120, 144, 0.16);
}

.txtAlgRt {
	text-align: right;
}

.paddRt0px {
	padding-right: 3px !important;
}

.txtAlgn_paddLft {
	text-align: right !important;
	padding-right: 5px !important;
}

.gstRptHdCls>.table>thead>tr>th {
	vertical-align: middle;
}

.maibTabOwnCss>ul>li>a {
	height: 41px;
	color: #fff;
}

.credit-Note-gst-frozonTableDiv {
	width: 300px;
	overflow-x: scroll;
	margin-left: 50px;
	overflow-y: visible;
	padding-bottom: 1px;
}

.credit-Note-gst-td {
	padding: 0 40px;
}

.paddingTop45 {
	padding-top: 45px;
}
.mainTabOwnCss > .nav-justified>li{
	background-color: #9a9593;
}
.subTabOwnCss > .nav-justified>li {
	background-color: #6c986c;
}
.tab-pane{
 min-height: 300px;
}
.paddngLftRiht10{
  padding-left: 10px !important;
  padding-right: 10px !important;
}
.paddngLftRiht5{
  padding-left: 5px !important;
  padding-right: 5px !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form "
		st-table="prcInvList1" st-safe-src="prcInvList">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">

		<tabset justified="true" class=".tab-head mainTabOwnCss"> <!-- GST Report -->
		<tab heading="{{mainMenuTab[0].title}}" >
		<div class="panel-body">
			<div class="">
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<div class="col-sm-12 form-horizontal" >
							<div class="form-group" ng-init="select.category='month'">
								<label class="col-md-5 control-label" style="text-align: right;">Search
									Type<span style="color: red;">*</span>
								</label>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="category" value="month" ng-model="select.category">
										<i></i> By Month
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
										name="category" value="quarter" ng-model="select.category">
										<i></i> By Quarter
									</label>
								</div>
							</div>
						</div>
						<div class="col-sm-12 form-horizontal">
							<label class="col-md-5 control-label" style="text-align: right;">Select
								Year - Month<span style="color: red;">*</span>
							</label>
							<div class="col-sm-2" style="margin-left: 0%">
								<selectivity list="yL" ng-model="select.year"
									form-name="gstRptForm" property="select.year" name="Year"
									friendly-name="Year"></selectivity>
							</div>
							<div class="col-sm-1" style="width: 10px;">-</div>
							<div class="col-sm-2" ng-show="shwMonth">
								<selectivity list="monList" ng-model="select.monItem"
									form-name="gstRptForm" property="select.monItem"
									name="Month List" friendly-name="Month"></selectivity>
							</div>

							<div class="col-sm-2" ng-show="shwQuarter">
								<selectivity list="qtrList" ng-model="select.qtrItem"
									form-name="gstRptForm" property="select.qtrItem" name="Quarter"
									friendly-name="Quarter"></selectivity>
							</div>
							
						</div>
						<div class="col-sm-1" style="width: 10px;">-</div>
						<div class="col-sm-12 form-horizontal">
							<label class="col-md-5 control-label" style="text-align: right;">Branch<span style="color: red;">*</span>
							</label>
							<div class="col-sm-2" style="margin-left: 0%">
								<selectivity list="branchList"
										property="select.branch" id="branch"
										name="branch" ng-model="select.branch"
										object="branch" friendly-name="Branch"
										validation="required" form-name="Quarter"></selectivity>
							</div>
						
						</div>
						
					</div>
				</div>
				
				<div class="" style="margin-left: 39%; margin-top: 1%;">
					<div class="form-group">
						<button class="btn btn-success" type="button"
							ng-click="getTabListValue()">
							<i class="fa fa-search"></i> Search
						</button>

						<button class="btn btn-info" type="reset" ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button>
						<!-- 
						<button class="btn btn-info" ng-click="getB2BTab()">
							<i class="fa fa-undo"></i>Tab Test
						</button>
						
						<button class="btn btn-info" ng-click="getGST()">
							<i class="fa fa-undo"></i>GST Test
						</button> -->

						<%--  <security:authorize access="hasRole('${form_code}_${export}')"> --%>

						<button class="btn btn-primary" ng-click="exportExcel()">
							<i class="fa fa-download"> </i> Export Excel
						</button>
						<%-- </security:authorize> --%>

						<a id="gstExport" href="" download=""></a>
					</div>
				</div>
			</div>
			<tabset justified="true" class=".tab-head tabOwnCss"> <tab
				heading="{{tabs[0].title}}">
			<div class="panel-body">
				<form class="form-horizontal" novalidate name="gstRptForm">

					<div style="width: 100%; float: left;">
						<div class="panel panel-default panel-default-form"
							ng-show="gstRptList.length > 0">
							<div class="panel-heading panel-heading-form font-bold"
								style="color: #fff">GST Report Summary</div>
						</div>
						<div class="col-sm-12" ng-show="gstRptList.length > 0"
							style="overflow: auto;">
							<table class="table table-striped  b-light table-fixed">
								<thead>
									<tr>
										<th class="width_6 subTable-brs sorting" st-sort="prcInvNoTcd">GSTIN/UIN
											OF RECIPIENT</th>
										<th class="width_6 subTable-brs sorting" st-sort="prcInvNoTcd">PURCHASE
											INVOICE NO</th>
										<th class="width_6 subTable-brs sorting" st-sort="vendorName">VENDOR</th>
										<th class="width_8 subTable-brs sorting" st-sort="vendorName">INVOICE
											DATE</th>
										<th class="width_6 subTable-brs sorting"
											st-sort="prcInvcAmount">INVOICE</th>
										<th class="width_6 subTable-brs sorting" st-sort="prcCGSTVal">CGST</th>
										<th class="width_6 subTable-brs sorting" st-sort="prcSGSTVal">SGST</th>
										<th class="width_6 subTable-brs sorting" st-sort="prcIGSTVal">IGST</th>
										<th class="width_6 subTable-brs sorting" st-sort="prcInvNoTcd">GSTIN/UIN
											OF RECIPIENT</th>
										<th class="width_6 subTable-brs sorting" st-sort="salInvNoTcd">SALES
											INVOICE NO</th>
										<th class="width_6 subTable-brs sorting" st-sort="custName">CUSTOMER</th>
										<th class="width_6 subTable-brs sorting" st-sort="vendorName">INVOICE
											DATE</th>
										<th class="width_6 subTable-brs sorting"
											st-sort="salInvcAmount">INVOICE</th>
										<th class="width_6 subTable-brs sorting" st-sort="salCGSTVal">CGST</th>
										<th class="width_6 subTable-brs sorting" st-sort="salSGSTVal">SGST</th>
										<th class="width_6 subTable-brs sorting" st-sort="salIGSTVal">IGST</th>
									</tr>
								</thead>
								<tbody>
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
										<td class="width_6 subTable-brs bold">Total Input</td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totPInvc
											| number}}</td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totPcGst
											| number}}</td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totPsGst
											| number}}</td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totPiGst
											| number}}</td>
										<td class="width_6 subTable-brs bold">Total Output</td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totSInvc
											| number}}</td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totScGst
											| number}}</td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totSsGst
											| number}}</td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totSiGst
											| number}}</td>
									</tr>
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
										<td class="width_6 subTable-brs bold">Opening</td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold">Input Utilised</td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs txtAlgn_paddLft">{{totl.totPcGst
											| number}}</td>
										<td class="width_6 subTable-brs txtAlgn_paddLft">{{totl.totPsGst
											| number}}</td>
										<td class="width_6 subTable-brs txtAlgn_paddLft">{{totl.totPiGst
											| number}}</td>
									</tr>
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
										<td class="width_6 subTable-brs" colspan="8"></td>
										<td class="width_6 subTable-brs bold">Net Payable</td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold"></td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.payCGst
											| number}}</td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.paySGst
											| number}}</td>
										<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.payIGst
											| number}}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>


					<div style="width: 100%; float: left; padding-top: 3%;">
						<div class="panel panel-default panel-default-form"
							style="float: left; width: 100%;">
							<div class="panel-heading panel-heading-form font-bold"
								style="color: #fff">GST Report Details</div>
						</div>
						<div class="">
							<div class="panel panel-default panel-default-list">
								<div class="padding-0">
									<div class="">
										<div class="">
											<div class="col-sm-12"
												style="height: 500px; overflow-y: scroll;">
												<table class="table table-striped  b-light table-fixed">
													<thead>
														<tr>
															<th class="width_10 subTable-brs" colspan="8"
																style="text-align: center;">PURCHASE</th>
															<th class="width_10 subTable-brs" colspan="8"
																style="text-align: center;">SALES</th>
														</tr>
														<tr>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">GSTIN/UIN OF RECIPIENT</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">PURCHASE INVOICE NO</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="vendorName">VENDOR</th>
															<th class="width_10 subTable-brs sorting"
																st-sort="vendorName">INVOICE DATE</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvcAmount">INVOICE</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcCGSTVal">CGST</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcSGSTVal">SGST</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcIGSTVal">IGST</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">GSTIN/UIN OF RECIPIENT</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="salInvNoTcd">SALES INVOICE NO</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="custName">CUSTOMER</th>
															<th class="width_10 subTable-brs sorting"
																st-sort="vendorName">INVOICE DATE</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="salInvcAmount">INVOICE</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="salCGSTVal">CGST</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="salSGSTVal">SGST</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="salIGSTVal">IGST</th>
														</tr>
													</thead>
													<tbody>
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-repeat="prInv in gstRptList">
															<td class="width_6 subTable-brs">{{prInv.seaPrcInvGstnNo}}{{prInv.airPrcInvGstnNo}} {{prInv.genPurInvGstnNo}} </td>
															<td class="width_6 subTable-brs">{{prInv.seaPrcInvNoTcd}}{{prInv.airPrcInvNoTcd}} {{prInv.genPurInvNoTcd}} </td>
															<td class="width_6 subTable-brs">{{prInv.seaPrcVendorName}}{{prInv.airPrcVendorName}} {{prInv.genPurCustName}} </td>
															<td class="width_10 subTable-brs">{{prInv.seaPrcInvDate}}{{prInv.airPrcInvDate}} {{prInv.genPurInvDate}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{prInv.seaPrcInvAmount}}{{prInv.airPrcInvAmount}} {{prInv.genPurInvAmount}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{prInv.seaPrcInvCGST}}{{prInv.airPrcInvCGST}} {{prInv.genPurInvCGST}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{prInv.seaPrcInvSGST}}{{prInv.airPrcInvSGST}}{{prInv.genPurInvSGST}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{prInv.seaPrcInvIGST}}{{prInv.airPrcInvIGST}} {{prInv.genPurInvIGST}}</td>

															<td class="width_6 subTable-brs">{{prInv.seaSalInvGstnNo}}{{prInv.airSalInvGstnNo}}  {{prInv.genInvGstnNo}}  </td>
															<td class="width_6 subTable-brs">{{prInv.seaSalInvNoTcd}}{{prInv.airSalInvNoTcd}}  {{prInv.genInvNoTcd}}</td>
															<td class="width_6 subTable-brs">{{prInv.seaSalCustName}}{{prInv.airSalCustName}} {{prInv.genCustName}}</td>
															<td class="width_10 subTable-brs">{{prInv.seaSalInvDate}}{{prInv.airSalInvDate}} {{prInv.genInvDate}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{prInv.seaSalInvAmount}}{{prInv.airSalInvAmount}} {{prInv.genInvAmount}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{prInv.seaSalInvCGST}}{{prInv.airSalInvCGST}}{{prInv.genInvCGST}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{prInv.seaSalInvSGST}}{{prInv.airSalInvSGST}} {{prInv.genInvSGST}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{prInv.seaSalInvIGST}}{{prInv.airSalInvIGST}} {{prInv.genInvIGST}}</td>
														</tr>
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-show="gstRptList.length > 0">
															<td class="width_6 subTable-brs bold">Total Input</td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_10 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totPInvc
																| number}}</td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totPcGst
																| number}}</td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totPsGst
																| number}}</td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totPiGst
																| number}}</td>
															<td class="width_6 subTable-brs bold">Total Output</td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_10 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totSInvc
																| number}}</td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totScGst
																| number}}</td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totSsGst
																| number}}</td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.totSiGst
																| number}}</td>
														</tr>
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-show="gstRptList.length > 0">
															<td class="width_6 subTable-brs bold">Opening</td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_10 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold">Input Utilised</td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_10 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{totl.totPcGst
																| number}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{totl.totPsGst
																| number}}</td>
															<td class="width_6 subTable-brs txtAlgn_paddLft">{{totl.totPiGst
																| number}}</td>
														</tr>
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-show="gstRptList.length > 0">
															<td class="width_6 subTable-brs" colspan="8"></td>
															<td class="width_6 subTable-brs bold">Net Payable</td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold"></td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.payCGst
																| number}}</td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.paySGst
																| number}}</td>
															<td class="width_6 subTable-brs bold txtAlgn_paddLft">{{totl.payIGst
																| number}}</td>
														</tr>
													</tbody>
												</table>
											</div>



										</div>
									</div>

								</div>
							</div>
						</div>
					</div>

				</form>
			</div>
			</tab> <tab heading="{{tabs[1].title}}" active="tabs[1].active">
			<div class="panel-body">
				<form class="form-horizontal" name="b2bForm" novalidate>
					<div style="width: 100%; float: left; padding-top: 3%;">
						<div class="panel panel-default panel-default-form"
							style="float: left; width: 100%;">
							<div class="panel-heading panel-heading-form font-bold"
								style="color: #fff">{{tabs[1].title}}</div>
						</div>
						<div class="">
							<div class="panel panel-default panel-default-list">
								<div class="padding-0">
									<div class="">
										<div class="">
											<div class="col-sm-12"
												style="height: 500px; overflow-y: scroll;">
												<table class="table table-striped  b-light table-fixed">
													<thead>
														<tr>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">GSTIN/UIN of Recipient</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Invoice Number</th>
															<th class="width_6 subTable-brs sorting"
																style="width: 10%" st-sort="vendorName">Invoice
																date</th>
															<th class="width_8 subTable-brs sorting"
																st-sort="vendorName">Invoice Value</th>
															<th class="width_6 subTable-brs sorting"
																style="width: 15%" st-sort="prcInvcAmount">Place Of
																Supply</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcCGSTVal">Reverse Charge</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcSGSTVal">Invoice Type</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcIGSTVal">E-Commerce GSTIN</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Rate</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="salInvNoTcd">Taxable Value</th>
														</tr>
													</thead>
													<tbody>
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-repeat="prInv in b2bGSTList">
															<td class="width_6 subTable-brs">{{prInv.invGstnNo}}</td>
															<td class="width_6 subTable-brs">{{prInv.invNoTcd}}</td>
															<td class="width_6 subTable-brs">{{prInv.invDate}}</td>
															<td class="width_8 subTable-brs txtAlgRt paddRt0px">{{prInv.invAmount}}</td>
															<td class="width_6 subTable-brs">{{prInv.supplyState}}</td>
															<td class="width_6 subTable-brs">N</td>
															<td class="width_6 subTable-brs">Regular</td>
															<td class="width_6 subTable-brs">{{prInv.eCommrsGSTIN}}</td>
															<td class="width_6 subTable-brs txtAlgRt paddRt0px">{{prInv.taxPercntg}}</td>
															<td class="width_6 subTable-brs txtAlgRt paddRt0px">{{prInv.invTxbleVal}}</td>
														</tr>

													</tbody>
												</table>
											</div>



										</div>
									</div>

								</div>
							</div>
						</div>
					</div>

				</form>
			</div>

			</tab> <tab heading="{{tabs[2].title}}" active="tabs[2].active">
			<form class="form-horizontal" name="b2clForm" novalidate>

				<div style="width: 100%; float: left; padding-top: 3%;">
					<div class="panel panel-default panel-default-form"
						style="float: left; width: 100%;">
						<div class="panel-heading panel-heading-form font-bold"
							style="color: #fff">{{tabs[2].title}}</div>
					</div>
					<div class="">
						<div class="panel panel-default panel-default-list">
							<div class="padding-0">
								<div class="">
									<div class="">


										<div class="col-sm-12"
											style="height: 500px; overflow-y: scroll;">
											<table class="table table-striped  b-light table-fixed">
												<thead>
													<tr>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Invoice Number</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Invoice date</th>
														<th class="width_6 subTable-brs sorting"
															style="width: 10%" st-sort="vendorName">Invoice
															Value</th>
														<th class="width_8 subTable-brs sorting"
															st-sort="vendorName">Place Of Supply</th>
														<th class="width_6 subTable-brs sorting"
															style="width: 15%" st-sort="prcInvcAmount">Rate</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="salInvNoTcd">Taxable Value</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="custName">E-Commerce GSTIN</th>
													</tr>
												</thead>
												<tbody>
													<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
														ng-repeat="prInv in b2clGSTList">
														<td class="width_6 subTable-brs">{{prInv.invNoTcd}}</td>
														<td class="width_6 subTable-brs">{{prInv.invDate}}</td>
														<td class="width_6 subTable-brs txtAlgRt paddRt0px">{{prInv.invAmount}}</td>
														<td class="width_8 subTable-brs">{{prInv.supplyState}}</td>
														<td class="width_6 subTable-brs txtAlgRt paddRt0px">{{prInv.taxPercntg}}</td>
														<td class="width_6 subTable-brs txtAlgRt paddRt0px">{{prInv.invTxbleVal}}</td>
														<td class="width_6 subTable-brs">{{prInv.eCommrsGSTIN}}</td>

													</tr>

												</tbody>
											</table>
										</div>



									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

			</form>
			</tab> <tab heading="{{tabs[3].title}}" active="tabs[3].active">
			<form class="form-horizontal" name="b2cusForm" novalidate>
				<div style="width: 100%; float: left; padding-top: 3%;">
					<div class="panel panel-default panel-default-form"
						style="float: left; width: 100%;">
						<div class="panel-heading panel-heading-form font-bold"
							style="color: #fff">{{tabs[3].title}}</div>
					</div>
					<div class="">
						<div class="panel panel-default panel-default-list">
							<div class="padding-0">
								<div class="">
									<div class="">


										<div class="col-sm-12"
											style="height: 500px; overflow-y: scroll;">
											<table class="table table-striped  b-light table-fixed">
												<thead>
													<tr>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Type</th>
														<th class="width_8 subTable-brs sorting"
															st-sort="vendorName">Place Of Supply</th>
														<th class="width_6 subTable-brs sorting"
															style="width: 15%" st-sort="prcInvcAmount">Rate</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="salInvNoTcd">Taxable Value</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="custName">Cess Amount</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="custName">E-Commerce GSTIN</th>
													</tr>
												</thead>
												<tbody>
													<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
														ng-repeat="prInv in b2bGSTListXXXX">
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_8 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
													</tr>

												</tbody>
											</table>
										</div>



									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

			</form>
			</tab> <tab heading="{{tabs[4].title}}" active="tabs[4].active">
			<form class="form-horizontal" name="expForm" novalidate>
				<div style="width: 100%; float: left; padding-top: 3%;">
					<div class="panel panel-default panel-default-form"
						style="float: left; width: 100%;">
						<div class="panel-heading panel-heading-form font-bold"
							style="color: #fff">{{tabs[4].title}}</div>
					</div>
					<div class="">
						<div class="panel panel-default panel-default-list">
							<div class="padding-0">
								<div class="">
									<div class="">


										<div class="col-sm-12"
											style="height: 500px; overflow-y: scroll;">
											<table class="table table-striped  b-light table-fixed">
												<thead>
													<tr>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Export Type</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Invoice Number</th>
														<th class="width_6 subTable-brs sorting"
															style="width: 10%" st-sort="vendorName">Invoice date</th>
														<th class="width_8 subTable-brs sorting"
															st-sort="vendorName">Invoice Value</th>
														<th class="width_6 subTable-brs sorting"
															style="width: 15%" st-sort="prcInvcAmount">Port Code</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcCGSTVal">Shipping Bill Number</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcSGSTVal">Shipping Bill Date</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcIGSTVal">Rate</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Taxable Value</th>
													</tr>
												</thead>
												<tbody>
													<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
														ng-repeat="exp in exprtGSTList">
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs">{{exp.invNoTcd}}</td>
														<td class="width_6 subTable-brs">{{exp.invDate}}</td>
														<td class="width_6 subTable-brs txtAlgRt">{{exp.invAmount}}</td>
														<td class="width_6 subTable-brs">{{exp.pol}}{{exp.pol!=null?'
															- ':''}}{{exp.pod}} {{exp.aol}}{{exp.aol!=null?' -
															':''}}{{exp.aod}}</td>
														<td class="width_6 subTable-brs">{{exp.jobNoTcd}}</td>
														<td class="width_6 subTable-brs">{{exp.jobDate}}</td>
														<td class="width_6 subTable-brs txtAlgRt">0.00</td>
														<td class="width_6 subTable-brs txtAlgRt">{{exp.invAmount}}</td>
													</tr>

												</tbody>
											</table>
										</div>



									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

			</form>
			</tab> <tab heading="{{tabs[5].title}}" active="tabs[5].active">
			<form class="form-horizontal" name="advnRecvForm" novalidate>
				<div style="width: 100%; float: left; padding-top: 3%;">
					<div class="panel panel-default panel-default-form"
						style="float: left; width: 100%;">
						<div class="panel-heading panel-heading-form font-bold"
							style="color: #fff">{{tabs[5].title}}</div>
					</div>
					<div class="">
						<div class="panel panel-default panel-default-list">
							<div class="padding-0">
								<div class="">
									<div class="">


										<div class="col-sm-12"
											style="height: 500px; overflow-y: scroll;">
											<table class="table table-striped  b-light table-fixed">
												<thead>
													<tr>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcCGSTVal">Place Of Supply</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcIGSTVal">Rate</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Gross Advance Received</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcSGSTVal">Cess Amount</th>
													</tr>
												</thead>
												<tbody>
													<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
														ng-repeat="prInv in b2bGSTListxxx">
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
														<td class="width_6 subTable-brs"></td>
													</tr>

												</tbody>
											</table>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[6].title}}" active="tabs[6].active">
			<form class="form-horizontal" name="nilExpForm" novalidate>

				<div style="width: 100%; float: left; padding-top: 3%;">
					<div class="panel panel-default panel-default-form"
						style="float: left; width: 100%;">
						<div class="panel-heading panel-heading-form font-bold"
							style="color: #fff">{{tabs[6].title}}</div>
					</div>
					<div class="">
						<div class="panel panel-default panel-default-list">
							<div class="padding-0">
								<div class="">
									<div class="">
										<div class="col-sm-12"
											style="height: 500px; overflow-y: scroll;">
											<table class="table table-striped  b-light table-fixed">
												<thead>
													<tr>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcCGSTVal">Description</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcIGSTVal">Nil Rated Supplies</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Exempted (other than nil
															rated/non GST supply )</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcSGSTVal">Non-GST supplies</th>
													</tr>
												</thead>
												<tbody>
													<tr data-ng-class="odd">
														<td class="width_6 subTable-brs">Inter-State supplies
															to registered persons</td>
														<td class="width_6 subTable-brs">0</td>
														<td class="width_6 subTable-brs txtAlgRt">{{interStateVal!=null?interStateVal:0 | number:2}}</td>
														<td class="width_6 subTable-brs">0</td>
													</tr>
													<tr data-ng-class="even">
														<td class="width_6 subTable-brs">Intra-State supplies
															to registered persons</td>
														<td class="width_6 subTable-brs">0</td>
														<td class="width_6 subTable-brs txtAlgRt">{{intraStateVal!=null?intraStateVal:0 | number:2}}</td>
														<td class="width_6 subTable-brs">0</td>
													</tr>
													<tr data-ng-class="odd">
														<td class="width_6 subTable-brs">Inter-State supplies
															to unregistered persons</td>
														<td class="width_6 subTable-brs">0</td>
														<td class="width_6 subTable-brs txtAlgRt">0</td>
														<td class="width_6 subTable-brs">0</td>
													</tr>
													<tr data-ng-class="even">
														<td class="width_6 subTable-brs">Intra-State supplies
															to unregistered persons</td>
														<td class="width_6 subTable-brs">0</td>
														<td class="width_6 subTable-brs txtAlgRt">0</td>
														<td class="width_6 subTable-brs">0</td>
													</tr>

												</tbody>
											</table>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[7].title}}" active="tabs[7].active">
			<form class="form-horizontal" name="hsnForm" novalidate>
				<div style="width: 100%; float: left; padding-top: 3%;">
					<div class="panel panel-default panel-default-form"
						style="float: left; width: 100%;">
						<div class="panel-heading panel-heading-form font-bold"
							style="color: #fff">{{tabs[7].title}}</div>
					</div>
					<div class="">
						<div class="panel panel-default panel-default-list">
							<div class="padding-0">
								<div class="">
									<div class="">


										<div class="col-sm-12"
											style="height: 500px; overflow-y: scroll;">
											<table class="table table-striped  b-light table-fixed">
												<thead>
													<tr>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">HSN</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Description</th>
														<th class="width_6 subTable-brs sorting"
															style="width: 10%" st-sort="vendorName">UQC</th>
														<th class="width_8 subTable-brs sorting"
															st-sort="vendorName">Total Quantity</th>
														<th class="width_6 subTable-brs sorting"
															style="width: 15%" st-sort="prcInvcAmount">Total
															Value</th>
																		<th class="width_6 subTable-brs sorting"
															st-sort="prcCGSTVal">Non-Taxable Value</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcCGSTVal">Taxable Value</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcSGSTVal">Integrated Tax Amount</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcIGSTVal">Central Tax Amount</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="salInvNoTcd">State/UT Tax Amount</th>
													</tr>
												</thead>
												<tbody>
													<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
														ng-repeat="prInv in hsnList">
														<td class="width_6 subTable-brs">{{prInv.hsnNo}}</td>
														<td class="width_6 subTable-brs">{{prInv.description}}</td>
														<td class="width_6 subTable-brs">OTH-OTHERS</td>
														<td class="width_6 subTable-brs txtAlgRt">0.00</td>
														<!-- {{prInv.quantity}} -->
														<td class="width_6 subTable-brs txtAlgRt">{{prInv.invAmount}}</td>
															<td class="width_6 subTable-brs txtAlgRt">{{prInv.nonTxbleVal}}</td>
														<td class="width_6 subTable-brs txtAlgRt">{{prInv.invTxbleVal}}</td>
														<td class="width_6 subTable-brs txtAlgRt">{{prInv.seaSalInvIGST}}</td>
														<td class="width_6 subTable-brs txtAlgRt">{{prInv.seaSalInvCGST}}</td>
														<td class="width_6 subTable-brs txtAlgRt">{{prInv.seaSalInvSGST}}</td>
													</tr>

												</tbody>
											</table>
										</div>



									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</form>
			</tab> <tab heading="{{tabs[8].title}}" active="tabs[8].active">
			<form class="form-horizontal" name="taxPrdForm" novalidate>
				<div style="width: 100%; float: left; padding-top: 3%;">
					<div class="panel panel-default panel-default-form"
						style="float: left; width: 100%;">
						<div class="panel-heading panel-heading-form font-bold"
							style="color: #fff">{{tabs[8].title}}</div>
					</div>
					<div class="">
						<div class="panel panel-default panel-default-list">
							<div class="padding-0">
								<div class="">
									<div class="">
										<div class="col-sm-12"
											style="height: 500px; overflow-y: scroll;">
											<table class="table table-striped  b-light table-fixed">
												<thead>
													<tr>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcCGSTVal">Nature of Document</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcIGSTVal">Sr. No. From</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcInvNoTcd">Sr. No. To</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcSGSTVal">Total Number</th>
														<th class="width_6 subTable-brs sorting"
															st-sort="prcSGSTVal">Cancelled</th>
													</tr>
												</thead>
												<tbody>
													<tr data-ng-class="odd">
														<td class="width_6 subTable-brs">Invoice for outward
															supply</td>
														<td class="width_6 subTable-brs">{{invInSupply[1]}}</td>
														<td class="width_6 subTable-brs">{{invInSupply[2]}}</td>
														<td class="width_6 subTable-brs txtAlgRt">{{invInSupply[3]}}</td>
														<td class="width_6 subTable-brs txtAlgRt">0</td>
													</tr>
													<tr data-ng-class="odd">
														<td class="width_6 subTable-brs">Invoice for inward
															supply from unregistered person</td>
														<td class="width_6 subTable-brs">{{invOutSupply[1]}}</td>
														<td class="width_6 subTable-brs">{{invOutSupply[2]}}</td>
														<td class="width_6 subTable-brs txtAlgRt">{{invOutSupply[3]}}</td>
														<td class="width_6 subTable-brs txtAlgRt">0</td>
													</tr>
													<tr data-ng-class="odd">
														<td class="width_6 subTable-brs">Credit Note</td>
														<td class="width_6 subTable-brs">{{creditNt[1]}}</td>
														<td class="width_6 subTable-brs">{{creditNt[2]}}</td>
														<td class="width_6 subTable-brs txtAlgRt">{{creditNt[3]}}</td>
														<td class="width_6 subTable-brs txtAlgRt">0</td>
													</tr>
													<tr data-ng-class="odd">
														<td class="width_6 subTable-brs">Debit Note</td>
														<td class="width_6 subTable-brs">{{debitNt[1]}}</td>
														<td class="width_6 subTable-brs">{{debitNt[2]}}</td>
														<td class="width_6 subTable-brs txtAlgRt">{{debitNt[3]}}</td>
														<td class="width_6 subTable-brs txtAlgRt">0</td>
													</tr>

												</tbody>
											</table>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</form>
			</tab> 
			<tab heading="CDNR" >
			<div class="panel-body">
				<form class="form-horizontal" name="b2bForm" novalidate>
					<div style="width: 100%; float: left; padding-top: 3%;">
						<div class="panel panel-default panel-default-form"
							style="float: left; width: 100%;">
							<div class="panel-heading panel-heading-form font-bold"
								style="color: #fff">CDNR</div>
						</div>
						<div class="">
							<div class="panel panel-default panel-default-list">
								<div class="padding-0">
									<div class="">
										<div class="">
											<div class="col-sm-12"
												style="height: 500px; overflow-y: scroll;">
												<table class="table table-striped  b-light table-fixed">
													<thead>
														<tr>
														<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">GSTIN/UIN of Recipient</th>
																<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Invoice/Advance Receipt Number</th>
																<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Invoice/Advance Receipt date</th>
																<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Note/Refund Voucher Number</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Note/Refund Voucher date</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Document Type</th>
															<th class="width_6 subTable-brs sorting"
																style="width: 10%" st-sort="vendorName">Reason For Issuing document</th>
															<th class="width_8 subTable-brs sorting"
																st-sort="vendorName">Note/Refund Voucher Value</th>
															<th class="width_6 subTable-brs sorting"
																style="width: 15%" st-sort="prcInvcAmount">Rate</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcCGSTVal">Taxable Value</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcSGSTVal">Cess Amount</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcIGSTVal">Pre GST</th>
															
														</tr>
													</thead>
													<tbody>
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-repeat="CDNR in exprtTabCDNRList">
															<td class="width_6 subTable-brs">{{CDNR.invGstnNo}}</td>
															<td class="width_6 subTable-brs">{{CDNR.creditNoteInvoiceNo}}</td>
															<td class="width_6 subTable-brs">{{CDNR.invDate}}</td>
															<td class="width_6 subTable-brs">{{CDNR.creditNoteNo}}</td>
															<td class="width_6 subTable-brs">{{CDNR.creditNoteDate}}</td>
															<td class="width_6 subTable-brs"></td>
															<td class="width_6 subTable-brs">{{CDNR.creditNoteNarration}}</td>
															<td class="width_8 subTable-brs txtAlgRt paddRt0px">{{CDNR.creditNoteAmount}}</td>
															<td class="width_6 subTable-brs">0</td>
															<td class="width_6 subTable-brs">{{CDNR.creditNoteAmount}}</td>
															<td class="width_6 subTable-brs"></td>
															<td class="width_6 subTable-brs"></td>
																
														</tr>

													</tbody>
												</table>
											</div>



										</div>
									</div>

								</div>
							</div>
						</div>
					</div>

				</form>
			</div>

			</tab>
			<tab heading="CDNUR" >
			<div class="panel-body">
				<form class="form-horizontal" name="b2bForm" novalidate>
					<div style="width: 100%; float: left; padding-top: 3%;">
						<div class="panel panel-default panel-default-form"
							style="float: left; width: 100%;">
							<div class="panel-heading panel-heading-form font-bold"
								style="color: #fff">CDNUR</div>
						</div>
						<div class="">
							<div class="panel panel-default panel-default-list">
								<div class="padding-0">
									<div class="">
										<div class="">
											<div class="col-sm-12"
												style="height: 500px; overflow-y: scroll;">
												<table class="table table-striped  b-light table-fixed">
													<thead>
														<tr>
														<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">UR Type</th>
																<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Note/Refund Voucher Number</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Note/Refund Voucher date</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Document Type</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Invoice/Advance Receipt Number</th>
																<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Invoice/Advance Receipt date</th>
															
															<th class="width_6 subTable-brs sorting"
																style="width: 10%" st-sort="vendorName">Reason For Issuing document</th>
															<th class="width_8 subTable-brs sorting"
																st-sort="vendorName">Note/Refund Voucher Value</th>
															<th class="width_6 subTable-brs sorting"
																style="width: 15%" st-sort="prcInvcAmount">Rate</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcCGSTVal">Taxable Value</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcSGSTVal">Cess Amount</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcIGSTVal">Pre GST</th>
															
														</tr>
													</thead>
													<tbody>
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-repeat="CDNUR in exprtTabCDNURList">
															<td class="width_6 subTable-brs"></td>
															<td class="width_6 subTable-brs">{{CDNUR.creditNoteNo}}</td>
															<td class="width_6 subTable-brs">{{CDNUR.creditNoteDate}}</td>
															<td class="width_6 subTable-brs"></td>
															<td class="width_6 subTable-brs">{{CDNUR.creditNoteInvoiceNo}}</td>
															<td class="width_6 subTable-brs">{{CDNUR.invDate}}</td>
															<td class="width_6 subTable-brs">{{CDNUR.creditNoteNarration}}</td>
															<td class="width_8 subTable-brs txtAlgRt paddRt0px">{{CDNUR.creditNoteAmount}}</td>
															<td class="width_6 subTable-brs">0</td>
															<td class="width_6 subTable-brs">{{CDNUR.creditNoteAmount}}</td>
															<td class="width_6 subTable-brs"></td>
															<td class="width_6 subTable-brs"></td>
																
														</tr>

													</tbody>
												</table>
											</div>



										</div>
									</div>

								</div>
							</div>
						</div>
					</div>

				</form>
			</div>

			</tab>
			
			<tab heading="ATADJ" >
			<div class="panel-body">
				<form class="form-horizontal" name="b2bForm" novalidate>
					<div style="width: 100%; float: left; padding-top: 3%;">
						<div class="panel panel-default panel-default-form"
							style="float: left; width: 100%;">
							<div class="panel-heading panel-heading-form font-bold"
								style="color: #fff">ATADJ</div>
						</div>
						<div class="">
							<div class="panel panel-default panel-default-list">
								<div class="padding-0">
									<div class="">
										<div class="">
											<div class="col-sm-12"
												style="height: 500px; overflow-y: scroll;">
												<table class="table table-striped  b-light table-fixed">
													<thead>
														<tr>
														<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Place Of Supply</th>
																<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Rate</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Gross Advance Adjusted</th>
															<th class="width_6 subTable-brs sorting"
																st-sort="prcInvNoTcd">Cess Amount</th>
															
															
														
															
														</tr>
													</thead>
													<tbody>
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															ng-repeat="ATADJ in exprtTabCDNRList">
															<td class="width_6 subTable-brs"></td>
															<td class="width_6 subTable-brs"></td>
															<td class="width_6 subTable-brs"></td>
															<td class="width_6 subTable-brs"></td>
															
															</tr>

													</tbody>
												</table>
											</div>



										</div>
									</div>

								</div>
							</div>
						</div>
					</div>

				</form>
			</div>

			</tab></tabset>

		</div>
		</tab> <!-- Debit Note Register --> <tab heading="Debit Note Register" >
		<div class="panel-body">
			<div class="">
				<div class="row book-widget-row">
					<div class="col-sm-12" >
						<div class="col-sm-10 form-horizontal form-group">
							<label class="col-md-5 control-label" style="text-align: right;">From Date<span style="color: red;">*</span>
							</label>
							<div class="col-sm-2" style="margin-left: 0%">
								<ng-bs3-datepicker data-ng-model="select.year1"
										id="year1" name="year1" form-name="gstRptForm" friendly-name="Month" style="border-color:#e5dcdb" 
										autocomplete="off" />
								<!-- <selectivity list="yL" ng-model="select.year1"
									form-name="gstRptForm" property="select.year1" name="Year"
									friendly-name="Year"></selectivity> -->
							</div>
							<div class="col-sm-1" style="text-align: right;">To Date<span style="color: red;">*</span></div>
							<div class="col-sm-2" >
							<ng-bs3-datepicker data-ng-model="select.monItem1"
										id="monItem1" name="monItem1" form-name="gstRptForm" friendly-name="Month" style="border-color:#e5dcdb" 
										autocomplete="off" />
							<!-- 	<selectivity list="monList" ng-model="select.monItem1"
									form-name="gstRptForm" property="select.monItem1"
									name="Month List" friendly-name="Month"></selectivity> -->
							</div>

							<!-- <div class="col-sm-2" ng-show="shwQuarter1">
								<selectivity list="qtrList" ng-model="select.qtrItem"
									form-name="gstRptForm" property="select.qtrItem" name="Quarter"
									friendly-name="Quarter"></selectivity>
							</div> -->
						</div>
						<div class="col-sm-10 form-horizontal form-group">
							<label class="col-md-5 control-label" style="text-align: right;">Branch
							<span style="color: red;">*</span>
							</label>
							<div class="col-sm-2" style="margin-left: 0%">
								<selectivity list="branchList"
										property="select.branch" id="branch"
										name="branch" ng-model="select.branch"
										object="branch" friendly-name="Branch"
										validation="required" form-name="Quarter"></selectivity>
							</div>
							
						</div>
					</div>
				</div>
				<div class="" style="margin-left: 36%; margin-top: 1%;">
					<div class="form-group">
						<button class="btn btn-success" type="button" ng-click="getCreditNoteRegister('NOTEXPORT')">
							<i class="fa fa-search"></i> Search
						</button>

						<button class="btn btn-info" type="reset" ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button>

						 <button class="btn btn-primary"ng-click="getCreditNoteRegister('EXPORT')" >
							<i class="fa fa-download"> </i>  Export Excel
						</button> 

						<a id="creditNotegstExportId" href="" download=""></a>
					</div>
				</div>
			</div>
		</div>
		<tabset justified="true" class=".tab-head subTabOwnCss"> <tab
			heading="{{creditNoteMenu[0].title}}">
		<div class="panel-body">
		
		            <div class="table-responsive " style="height: 500px;" ng-show="crditNtGSTHdr.length>0">
						<table
							class="table table-striped table-hover dataTable no-footer">
							<thead class="dataTables-Main-Head">
								<tr >
									<th class="width_6 subTable-brs" ng-repeat="itr in crditNtGSTHdr"
										>{{itr.title}}</th>
									<th class="width_6 subTable-brs"
										>Input CGST 2.5%</th>
									<th class="width_6 subTable-brs" 
										>Input SGST 2.5%</th>
									<th class="width_6 subTable-brs" 
										>Input CGST 9%</th>
									<th class="width_6 subTable-brs" 
										>Input SGST 9%</th>
										<th class="width_6 subTable-brs" 
										>Input CGST 14%</th>
									<th class="width_6 subTable-brs" 
										>Input SGST 14%</th>
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="DeliveryOrder in crditNtRegGST">
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10 "
										><span>{{DeliveryOrder.date}}</span>
		
									</td>
									<td class="width_10 subTable-brs padding-number-align text-center paddngLftRiht10 "
										><span>{{DeliveryOrder.particulars}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.voucherRef}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.gstnin}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.grossTotal}}</span>
									</td>
									<!--  <td class="width_6 padding-number-align text-center" ng-repeat="dynVal2 in DeliveryOrder.dynamicHdVal"
										><span >{{dynVal2.title}}</span>
									</td>  -->
									<td class="width_6 padding-number-align text-center subTable-brs" ng-repeat="dynVal2 in DeliveryOrder.dynamicHdVal"> 
									 <div ng-repeat="(key, value) in dynVal2">
									  {{value[1]}}
									</div>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.inpCGST25==0.00? '' : DeliveryOrder.inpCGST25}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.inpSGST25==0.00? '' : DeliveryOrder.inpSGST25}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.inpCGST9==0.00? '' : DeliveryOrder.inpCGST9}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.inpSGST9==0.00? '' : DeliveryOrder.inpSGST9}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.inpCGST14==0.00? '' : DeliveryOrder.inpCGST14}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.inpSGST14==0.00? '' : DeliveryOrder.inpSGST14}}</span>
									</td>
								</tr>
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
								<td class="width_6 subTable-brs padding-number-align text-center " colspan="4"
										><span>Grand Total</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{crditNtRegGST[0].grandTotal | number:2}}</span>
								</td>
								<td class="width_6 padding-number-align text-center subTable-brs" ng-repeat="grdTtl1 in credNtAllres.crdtNtGSTGrandTotal  track by $index"> 
								  {{grdTtl1 | number:2}}
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpCGST25GrndTtl | number:2}}</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpSGST25GrndTtl | number:2}}</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpCGST9GrndTtl | number:2}}</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpSGST9GrndTtl | number:2}}</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpCGST14GrndTtl | number:2}}</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpSGST14GrndTtl | number:2}}</span>
								</td>
								</tr>
							</tbody>
						</table>
							</div>
		
		
		</div>
		</tab> <tab
			heading="{{creditNoteMenu[1].title}}">
		<div class="panel-body">
			<form class="form-horizontal" novalidate name="crditNoteGstForm">

				<div style="width: 100%; float: left;">
					
					
					<div class="table-responsive " style="height: 500px;" ng-show="crditNtIGSTHdr.length>0">
						<table
							class="table table-striped table-hover dataTable no-footer">
							<thead class="dataTables-Main-Head">
								<tr >
									<th class="width_6 subTable-brs" ng-repeat="itr in crditNtIGSTHdr"
										>{{itr.title}}</th>
									<th class="width_6 subTable-brs" 
									>Input IGST 5%</th>
									<th class="width_6 subTable-brs" 
									>Input IGST 12%</th>
									<th class="width_6 subTable-brs" 
									>Input IGST 18%</th>
									<th class="width_6 subTable-brs" 
									>Input IGST 28%</th>
									
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="DeliveryOrder in crditNtRegIGST">
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.date}}</span>
		
									</td>
									<td class="width_10 subTable-brs padding-number-align text-center paddngLftRiht5"
										><span>{{DeliveryOrder.particulars}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.voucherRef}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.gstnin}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.grossTotal | number:2}}</span>
									</td>
									<!--  <td class="width_6 padding-number-align text-center" ng-repeat="dynVal2 in DeliveryOrder.dynamicHdVal"
										><span >{{dynVal2.title}}</span>
									</td>  -->
									<td class="width_6 padding-number-align text-center subTable-brs" ng-repeat="dynVal2 in DeliveryOrder.dynamicHdVal"> 
									  <div ng-repeat="(key, value) in dynVal2">
									  {{value[1]}}
									  </div>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center ">
										<span>{{DeliveryOrder.inpIGST5==0.00? '' : DeliveryOrder.inpIGST5}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.inpIGST12==0.00? '' : DeliveryOrder.inpIGST12}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.inpIGST18==0.00? '' : DeliveryOrder.inpIGST18}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.inpIGST28==0.00? '' : DeliveryOrder.inpIGST28}}</span>
									</td>
								</tr>
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
								<td class="width_6 subTable-brs padding-number-align text-center " colspan="4"
										><span>Grand Total</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{crditNtRegIGST[0].grandTotal  | number:2}}</span>
								</td>
								<td class="width_6 padding-number-align text-center subTable-brs" ng-repeat="grdTtl2 in credNtAllres.crdtNtIGSTGrandTotal  track by $index"> 
								  {{grdTtl2 | number:2}}
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpIGST5GrndTtl | number:2}}</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpIGST12GrndTtl | number:2}}</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpIGST18GrndTtl | number:2}}</span>
								</td>
								<td class="width_6 subTable-brs padding-number-align text-center"
										><span>{{credNtAllres.inpIGST28GrndTtl | number:2}}</span>
								</td>
								</tr>
							</tbody>
						</table>
							</div>

				</div>
			</form>
		</div>
		</tab> </tabset> </tab> <!-- Credit Note Register --> <tab
			heading="Credit Note Register" >
		<div class="panel-body">
			<div class="">
				<div class="row book-widget-row">
					<div class="col-sm-10" ng-init="select.category2='month'">
						<div class="col-sm-12 form-horizontal form-group">
							<label class="col-md-5 control-label" style="text-align: right;">From Date<span style="color: red;">*</span>
							</label>
						<div class="col-sm-2" style="margin-left: 0%">
								<ng-bs3-datepicker data-ng-model="select.year2"
										id="year2" name="year2" form-name="gstRptForm" friendly-name="Month" style="border-color:#e5dcdb" 
										autocomplete="off" />
								<!-- <selectivity list="yL" ng-model="select.year1"
									form-name="gstRptForm" property="select.year1" name="Year"
									friendly-name="Year"></selectivity> -->
							</div>
							<div class="col-sm-1" style="text-align: right;">To Date<span style="color: red;">*</span></div>
							<div class="col-sm-2" >
							<ng-bs3-datepicker data-ng-model="select.monItem2"
										id="monItem2" name="monItem2" form-name="gstRptForm" friendly-name="Month" style="border-color:#e5dcdb" 
										autocomplete="off" />
							<!-- 	<selectivity list="monList" ng-model="select.monItem1"
									form-name="gstRptForm" property="select.monItem1"
									name="Month List" friendly-name="Month"></selectivity> -->
							</div>

						<!-- 	<div class="col-sm-2" ng-show="shwQuarter2">
								<selectivity list="qtrList" ng-model="select.qtrItem2"
									form-name="gstRptForm" property="select.qtrItem2" name="Quarter"
									friendly-name="Quarter"></selectivity>
							</div> -->
						</div>
					</div>
					<div class="col-sm-10 form-horizontal form-group">
							<label class="col-md-5 control-label" style="text-align: right;">Branch
							<span style="color: red;">*</span>
							</label>
							<div class="col-sm-2" style="margin-left: 0%">
								<selectivity list="branchList"
										property="select.branch" id="branch"
										name="branch" ng-model="select.branch"
										object="branch" friendly-name="Branch"
										validation="required" form-name="Quarter"></selectivity>
							</div>
							
						</div>
				</div>
				<div class="" style="margin-left: 36%; margin-top: 1%;">
					<div class="form-group">
						<button class="btn btn-success" type="button" ng-click="getDebitNoteRegister()">
							<i class="fa fa-search"></i> Search
						</button>

						<button class="btn btn-info" type="reset" ng-click="reset2()">
							<i class="fa fa-undo"></i> Reset
						</button>

						<button class="btn btn-primary" ng-click="debitNoteExport()">
							<i class="fa fa-download"> </i> Export Excel
						</button>

						<a id="debitNoteGstExportId" href="" download=""></a>
					</div>
				</div>
			</div>
		</div>
		<tabset justified="true" class=".tab-head subTabOwnCss"> <tab
			heading="{{debitNoteMenu[0].title}}">
		<div class="panel-body">
			<form class="form-horizontal" novalidate name="debitNoteGstForm">

				<div style="width: 100%; float: left;">
					
					<div class="table-responsive " style="height: 500px;" ng-show="dbtNtGSTHdr.length >0">
						<table
							class="table table-striped table-hover dataTable no-footer">
							<thead class="dataTables-Main-Head">
								<tr >
									<th class="width_6 subTable-brs" ng-repeat="itr in dbtNtGSTHdr"
										>{{itr.title}}</th>
										<th class="width_6 subTable-brs" 
										>Output CGST 2.5%</th>
										<th class="width_6 subTable-brs"
										>Output SGST 2.5%</th>
										<th class="width_6 subTable-brs" 
										>Output CGST 9%</th>
										<th class="width_6 subTable-brs" 
										>Output SGST 9%</th>
										<th class="width_6 subTable-brs" 
										>Output CGST 14%</th>
										<th class="width_6 subTable-brs" 
										>Output SGST 14%</th>
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="DeliveryOrder in dbtNtRegGST">
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.date}}</span>
		
									</td>
									<td class="width_10 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.particulars}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.voucherRef}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.gstnin}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.grossTotal}}</span>
									</td>
									<!--  <td class="width_6 padding-number-align text-center" ng-repeat="dynVal2 in DeliveryOrder.dynamicHdVal"
										><span >{{dynVal2.title}}</span>
									</td>  -->
									<td class="width_6 padding-number-align text-center subTable-brs" ng-repeat="dynVal2 in DeliveryOrder.dynamicHdVal"> 
									 <div ng-repeat="(key, value) in dynVal2">
									 {{value[1]}}
									</div>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.outCGST25==0.00? '' : DeliveryOrder.outCGST25}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.outSGST25==0.00? '' : DeliveryOrder.outSGST25}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.outCGST9==0.00? '' : DeliveryOrder.outCGST9}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.outSGST9==0.00? '' : DeliveryOrder.outSGST9}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.outCGST14==0.00? '' : DeliveryOrder.outCGST14}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.outSGST14==0.00? '' : DeliveryOrder.outSGST14}}</span>
									</td>
								</tr>
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
									<td class="width_6 subTable-brs padding-number-align text-center " colspan="4"
											><span>Grand Total</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtRegGST[0].grandTotal | number:2}}</span>
									</td>
									<td class="width_6 padding-number-align text-center subTable-brs" ng-repeat="grdTtl3 in dbtNtAllres.dbtNtGSTGrandTotal  track by $index"> 
									  {{grdTtl3 | number:2}}
									</td>
									 <td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtAllres.outCGST25GrndTtl | number:2}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtAllres.outSGST25GrndTtl | number:2}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtAllres.outGST9GrndTtl  | number:2}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtAllres.outGST9GrndTtl  | number:2}}</span>
									</td> 
									<td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtAllres.outGST14GrndTtl  | number:2}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtAllres.outGST14GrndTtl  | number:2}}</span>
									</td> 
									</tr>
							</tbody>
						</table>
							</div>
					
					
				</div>
			</form>
		</div>
		</tab> <tab heading="{{debitNoteMenu[1].title}}">
		<div class="panel-body">
			<form class="form-horizontal" novalidate name="debitNoteIGstForm">

				<div style="width: 100%; float: left;">
					
					<div class="table-responsive " style="height: 500px;" ng-show="dbtNtIGSTHdr.length >0">
						<table
							class="table table-striped table-hover dataTable no-footer">
							<thead class="dataTables-Main-Head">
								<tr >
									<th class="width_6 subTable-brs" ng-repeat="itr in dbtNtIGSTHdr"
										>{{itr.title}}</th>
									<th class="width_6 subTable-brs" 
										>Output IGST 5%</th>
									<th class="width_6 subTable-brs"
									>Output IGST 18%</th>
									<th class="width_6 subTable-brs"
									>Output IGST 28%</th>
									<!-- <th class="width_6 subTable-brs"
									>NET 5%</th>
									<th class="width_6 subTable-brs"
									>IGST 5%</th>
									<th class="width_6 subTable-brs"
									>NET 18%</th>
									<th class="width_6 subTable-brs"
									>IGST 18%</th>
									<th class="width_6 subTable-brs"
									>DIFF</th> -->
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="DeliveryOrder in dbtNtRegIGST">
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.date}}</span>
		
									</td>
									<td class="width_10 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.particulars}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.voucherRef}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center paddngLftRiht10"
										><span>{{DeliveryOrder.gstnin}}</span>
		
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.grossTotal}}</span>
									</td>
									<!--  <td class="width_6 padding-number-align text-center" ng-repeat="dynVal2 in DeliveryOrder.dynamicHdVal"
										><span >{{dynVal2.title}}</span>
									</td>  -->
									<td class="width_6 padding-number-align text-center subTable-brs" ng-repeat="dynVal2 in DeliveryOrder.dynamicHdVal"> 
									 <div ng-repeat="(key, value) in dynVal2">
									  {{value[1]}}
									</div>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.outIGST5==0.00? '' : DeliveryOrder.outIGST5}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.outIGST18==0.00? '' : DeliveryOrder.outIGST18}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span>{{DeliveryOrder.outIGST28==0.00? '' : DeliveryOrder.outIGST28}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td>
								</tr>
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
									<td class="width_6 subTable-brs padding-number-align text-center " colspan="4"
											><span>Grand Total</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtRegIGST[0].grandTotal | number:2}}</span>
									</td>
									<td class="width_6 padding-number-align text-center subTable-brs" ng-repeat="grdTtl4 in dbtNtAllres.dbtNtIGSTGrandTotal  track by $index"> 
									  {{grdTtl4 | number:2}}
									</td>
									 <td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtAllres.outCGST5GrndTtl | number:2}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtAllres.outSGST18GrndTtl | number:2}}</span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center"
											><span>{{dbtNtAllres.outSGST28GrndTtl | number:2}}</span>
									</td>
									<!-- <td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td>
									<td class="width_6 subTable-brs padding-number-align text-center "
										><span></span>
									</td> -->
									</tr>
							</tbody>
						</table>
							</div>


				</div>
			</form>
		</div>
		</tab> </tabset> </tab> </tabset>
	</div>
</div>
