<script>


</script>
<style>
.con-ele input {
	height: 30px;
}

.bookingDtlCls {
	border-bottom: 2px solid #23b7e5 !important;
	border-top: 2px solid #23b7e5 !important;
	/*  border-left: 1px solid #23b7e5 !important;
    border-right: 1px solid #23b7e5 !important; */
}

tbody::before {
	content: '';
	display: block;
	height: 15px;
	/*  border-left: 0px solid  !imNSA-NHAVA SHEVA, INDIA	portant;
   border-right: 1px solid #23b7e5 !important;
       width: 100%; */
}

<
style>a:hover {
	color: black;
}
.panel .actions {
    right: 8%;
  }
.subTable-brs {
  padding: 8px !important;
}

</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div>
			<input type="hidden" value="${form_code}" id="form_code_id">
			<div class="panel-body">
				<form name="jobOrderForm" class="form-horizontal" novalidate>
					<div class="row book-widget-row" >
				<div class="form-group col-md-12 col-lg-12" ng-if="edit" align="center">
								<label class="col-md-5 control-label" style="padding-top: 0px;">Job No <span
									style="color: red">*</span></label>
								<div class="col-md-7" align="left">
									<label>{{joborder.jobNo}}</label>
								</div>
								</div>
								</div>
								<br>
								<br>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
							
							<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="col-md-5 control-label">Mode <span style="color: red">*</span>
								</label>
								<div class="col-md-7">

									<selectivity list="modeList"
										property="joborder.mode" id="mode"
										name="mode" ng-model="quotation.mode"
										object="mode" friendly-name="mode"
										validation="required" form-name="jobOrderForm"
										disabled></selectivity>



								</div>
								</div>
								
								
								
								
								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Job Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.jobDate"
											name="jobDate" form-name="jobOrderForm"
											friendly-name="Job Date" validation="required" />
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Service <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="servicePartnerTypelist" ng-model="joborder.service"
											property="joborder.service" name="service"
											validation="required" friendly-name=SERVICE
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Branch <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="branchList" ng-model="joborder.branch"
											property="joborder.branch" name="branch"
											validation="required" friendly-name=BRANCH
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								</fieldset>
								</div>
								</div>
							<div class="row book-widget-row">
						<div class="col-sm-12 ">
						<fieldset>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Customer <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" ng-model="joborder.customer"
											property="joborder.customer" name="customer" id="customer"
											validation="required" friendly-name="Customer"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Shipper <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" ng-model="joborder.shipper"
											property="joborder.shipper" name="shipper"
											validation="required" friendly-name="Shipper"
											form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>

								
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Consignee <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.consignee"
											ng-model="joborder.consignee" name="consignee" validation="required"
											friendly-name="Consignee" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Term <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="TermList" property="joborder.term"
											ng-model="joborder.term" name="term" validation="required"
											friendly-name="Term" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								</fieldset>
								</div>
								</div>
								
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
							
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> POL<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aol"
											ng-model="joborder.aol" name="aol" validation="required"
											friendly-name="Aol" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> POD <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aod"
											ng-model="joborder.aod" name="aod" validation="required"
											friendly-name="AOD" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> ORIGIN <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.origin"
											ng-model="joborder.origin" name="origin" validation="required"
											friendly-name="Origin" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> DESTINATION<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.destination"
											ng-model="joborder.destination" name="destination" validation="required"
											friendly-name="Destination" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
									</fieldset>
								</div>
								</div>
								<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
							
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Commodity<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.commodity" name="commodity"
											form-name='jobOrderForm' friendly-name="Commodity" disabled="true">
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Job Status <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="jobStatusList" property="joborder.jobStatus"
											ng-model="joborder.jobStatus" name="jobStatus" validation="required"
											friendly-name="job Status" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Currency <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="currencylist" property="joborder.currency"
											ng-model="joborder.currency" name="currency" validation="required"
											friendly-name="Currency" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Quotation 
									</label>
									<div class="col-md-6" style="padding-right:4px;width:48%">
										<selectivity list="quotationList" ng-model="joborder.quotationNo"
											property="joborder.quotationNo" class="quoLiCls" name="quotationNo"
											 friendly-name="quotationNo" 
											
											form-name="jobOrderForm"></selectivity>
											<!-- <selectivity list="quotationList" ng-model="joborder.quotationNo"
											property="joborder.quotationNo" class="quoLiCls" name="quotationNo"
											 friendly-name="quotationNo" ng-if="!edit"
											form-name="jobOrderForm"></selectivity> -->
											</div>
										<!-- 	<div class="col-md-1" style="padding-left: 1px;">
											<button id="quoIconId"  class="btn btn-success" style="padding: 2px 7px;margin-top: 7px;color: #ffffff;background-color: #27b6af;" 
											ng-click="showHideQuotation()" >
											<span class="fa fa-bolt"></span>
     										</button>
								</div> -->
								</div>
								
								<!--  		<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Quotation 
									</label>
									<div class="col-md-6" style="padding-right:4px;width:48%">
										
											</div>
											<div class="col-md-1" style="padding-left: 1px;">
											<button id="quoIconId"  class="btn btn-success" style="padding: 2px 7px;margin-top: 7px;color: #ffffff;background-color: #27b6af;" 
											ng-click="showHideQuotation()" >
											<span class="fa fa-bolt"></span>
     										</button>
								</div>
								</div> -->
							</fieldset>
						</div>
					</div>
						<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
							
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Type <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="salesTypeList" property="joborder.salesType"
											ng-model="joborder.salesType" name="salesType" validation="required"
											friendly-name="Sales Type" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Person <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="employeeList" property="joborder.salesPerson"
											ng-model="joborder.salesPerson" name="salesPerson" validation="required"
											friendly-name="Sales Person" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Nominated By<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.nominatedBy"
											ng-model="joborder.nominatedBy" name="nominatedBy" validation="required"
											friendly-name="Nominated By" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Vendor <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.vendor"
											ng-model="joborder.vendor" name="vendor" validation="required"
											friendly-name="Vendor" form-name="jobOrderForm" disabled="true"></selectivity>
									</div>
								</div>
								
								 
							</fieldset>
						</div>
					</div>
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
							
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Carrier <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.carrier" name="carrier"
											form-name='jobOrderForm' friendly-name="Carrier" disabled="true">
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Vessel/Voyage<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.flightNo" name="flightNo"
											form-name='jobOrderForm' friendly-name="Flight No">
									</div>
								</div>
								
								<!-- <div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Flight Date <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.flightDate"
											name="flightDate" form-name="jobOrderForm"
											friendly-name="Flight Date" validation="required" />
									</div>
								</div> -->
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">Ex rate(USD) <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
									<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.exRate" name="exRate" 	validation="required|integer"
											form-name='jobOrderForm' friendly-name="Ex Rate">
									</div>
								</div>
									<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Customs Broker
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.customsBroker"
											ng-model="joborder.customsBroker" name="customsBroker" 
											friendly-name="Customs Broker" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								 
							</fieldset>
						</div>
					</div>
					
		<!-- 			<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
							
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Customs Broker <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.customsBroker"
											ng-model="joborder.customsBroker" name="customsBroker" validation="required"
											friendly-name="Customs Broker" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
						 
							</fieldset>
						</div>
					</div> -->
				 
					<br>
					<br>
					<br>







					<div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_1"></th>
									<th colspan=1 class="width_5 text-center">S.No</th>
									<th colspan=1 class="width_13 text-center">Charge Heads<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_13 text-center">Units<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_13 text-center">Transaction
										type<span style="color: red;">*</span>
									</th>
									<th colspan=1 class="width_13 text-center">Quantity<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Rate<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Currency<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Ex rate<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Amount<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Payment Mode<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Buy/Sell Party<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Status<span
										style="color: red;">*</span></th>
								</tr>
							</thead>
							  <tbody ng-repeat="(trIndex, jobOrderDtl) in joborder.joborderDtl" ng-controller="jobtableCtrl"
								class="bookingDtlCls">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select"><i></i></label></td>
									<td class="text-center">{{trIndex+1}}</td>
									<td class="text-center">
									 
										<selectivity list="chargeHeadList" property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}" 
											ng-model="jobOrderDtl.chargeHead" name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}" form-name="jobOrderDtlForm"></selectivity>
									</td>

									<td class="text-center">
									 
										<selectivity list="UnitList" property="jobOrderDtl.unit" id="unit"
											ng-model="jobOrderDtl.unit" name="unit{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}" form-name="jobOrderForm"></selectivity>
									</td>

									 <td class="text-center">
									 
										<selectivity list="transactionTypeList" property="jobOrderDtl.transactionType"   id="transactionType{{trIndex}}" 
											ng-model="jobOrderDtl.transactionType" name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}" form-name="jobOrderForm" ></selectivity>
									</td>
									 
									 
									<td class="text-center"><input type="text" id="qty{{trIndex}}"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}" 
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3"  ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}" ng-change="ratevalues()">
									</td>
									
									<td class="text-center"><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}" 
									
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}" ng-change="ratevalues()">
									</td>
									
									 <td class="text-center">
									 
										<selectivity list="currencylist" property="jobOrderDtl.currency" id="currency{{trIndex}}"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									
										<td class="text-center"><input type="text"
										class="form-control input-sm text-right" id="exRate{{trIndex}}"
										ng-model="jobOrderDtl.exRate" name="exRate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'  ng-change="ratevalues()"
										maxlength="3"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}">
									</td>
									
										<td class="text-center"><input type="text"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3" id="amount{{trIndex}}"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}"   ng-change="ratevalues1()" readonly>
									</td>
									
										 <td class="text-center">
									 
										<selectivity list="PaymentMethodList" property="jobOrderDtl.paymentMode" id="paymentMethod{{trIndex}}"
											ng-model="jobOrderDtl.paymentMode" name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									
										 <td class="text-center">
									 
										<selectivity list="customerList" property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty" name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									 <td class="text-center">
									 
										<selectivity list="jobStatusList1" property="jobOrderDtl.jobStatus1" id="jobStatus1{{trIndex}}"
											ng-model="jobOrderDtl.jobStatus1" name="jobStatus1{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(jobStatus1)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									
								
								
								</tr>
								 
							</tbody>  
						</table>
						<div class="padding-right-5">
							<div class="col-md-4">
								<button ng-click="addRow()" class="btn btn-sm btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button>
								<button ng-click="removeRow()"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div>
						</div>
					</div>
					<!-- <div class="col-md-8">
									<div class="form-group">
											<div class="col-md-7">
											
											
									<label>{{joborder.sell1}}</label>
									<label>{{joborder.buy1}}</label>
									<label>{{joborder.total}}</label>
								</div>

									</div>
								</div> -->
			
					
					<%-- <div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body padding-0">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="sorting" st-sort="customFields">Custom Field</th>
						<th class="sorting" st-sort="field Type">Field Type</th>
							
							<th class="sorting" st-sort="Input Type">Input Type</th>
						
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="booking in displayedCollection">
							<!-- <td class=""><label class="i-checks m-b-none"> <input
									type="checkbox" name="post[]" data-ng-model="objItem.isSelect">
									<i></i>
							</label></td> -->

							<td><a data-ng-click="viewJob(booking.jobId)">  <security:authorize access="hasRole('${form_code}_${view}')"><span class="tool-tip-span font-blue">{{booking.jobNo}}</span></security:authorize></a> </td>
							<td><a data-ng-click="viewJob(booking.jobNo)">  <security:authorize access="hasRole('${form_code}_${view}')"><span class="tool-tip-span font-blue">{{booking.jobNo}}</span></security:authorize></a> </td>
									
							
							<td>{{booking.jobDt}}</td>
							<td>{{booking.custName}}</td>
							<td>{{booking.aolName}}</td>
							<td>{{booking.aodName}}</td>
							<td>{{booking.orgnName}}</td>
							<td>{{booking.destinationName}}</td>
							<td>{{booking.createdBy}}</td>
							<td>{{booking.createdDate}}</td>
							<td>{{booking.modifedBy}}</td>
							<td>{{booking.modifiedDate}}</td>
							 
							
						</tr>
						
					</tbody>
				</table>
			</div>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="content">
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-info" type="searchs" ng-click="search()">
												<i class="fa fa-undo"></i> Search
											</button>

											<button class="btn btn-info" type="reset" ng-click="reset()">
												<i class="fa fa-undo"></i> Reset
											</button>


											

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				<div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_1"></th>
									<th colspan=1 class="width_5 text-center">Container No</th>
									<th colspan=1 class="width_13 text-center">Size Type</th>
									<th colspan=1 class="width_13 text-center">Cargo Description</th>
									<th colspan=1 class="width_13 text-center">No of packages
										type
									</th>
									<th colspan=1 class="width_13 text-center">UOM</th>
									<th colspan=1 class="width_10 text-center">Net Weight</th>
									<th colspan=1 class="width_10 text-center">Gross Weight</th>
									<th colspan=1 class="width_10 text-center">Measure Ment</th>
									<th colspan=1 class="width_10 text-center">Remarks</th>
									
								</tr>
							</thead>
							  <tbody ng-repeat="(trIndex, jobOrderDtl1) in joborder.joborderDtl1"
								class="bookingDtlCls">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl1.select"><i></i></label></td>
									<td class="text-center">{{trIndex+1}}</td>
									<td class="text-center">
									 
										<selectivity list="chargeHeadList" property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}" 
											ng-model="jobOrderDtl.chargeHead" name="chargeHead{{trIndex}}" 
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}" form-name="jobOrderDtlForm"></selectivity>
									</td>

									<td class="text-center">
									 
										<selectivity list="UnitList" property="jobOrderDtl.unit" id="unit"
											ng-model="jobOrderDtl.unit" name="unit{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}" form-name="jobOrderForm"></selectivity>
									</td>

									 <td class="text-center">
									 
										<selectivity list="transactionTypeList" property="jobOrderDtl.transactionType"   id="transactionType{{trIndex}}" 
											ng-model="jobOrderDtl.transactionType" name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									 
									 
									<td class="text-center"><input type="text" id="qty{{trIndex}}"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}" 
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}">
									</td>
									
									<td class="text-center"><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}">
									</td>
									
									 <td class="text-center">
									 
										<selectivity list="currencylist" property="jobOrderDtl.currency" id="currency{{trIndex}}"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									
										<td class="text-center"><input type="text"
										class="form-control input-sm text-right" id="exRate{{trIndex}}"
										ng-model="jobOrderDtl.exRate" name="exRate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}">
									</td>
									
										<td class="text-center"><input type="text"
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3" id="amount{{trIndex}}"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}">
									</td>
									
										 <td class="text-center">
									 
										<selectivity list="PaymentMethodList" property="jobOrderDtl.paymentMode" id="paymentMethod{{trIndex}}"
											ng-model="jobOrderDtl.paymentMode" name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									
										 <td class="text-center">
									 
										<selectivity list="customerList" property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="jobOrderDtl.buySellParty" name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									 <td class="text-center">
									 
										<selectivity list="jobStatusList1" property="jobOrderDtl.jobStatus1" id="jobStatus1{{trIndex}}"
											ng-model="jobOrderDtl.jobStatus1" name="jobStatus1{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(jobStatus1)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									
								
								
								</tr>
								 
							</tbody>  
						</table>
						<div class="padding-right-5">
							<div class="col-md-4">
								<button ng-click="addRow()" class="btn btn-sm btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button>
								<button ng-click="removeRow()"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div>
						</div>
					</div>
			
			<footer class="panel-footer">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>
</div> --%>
					
					
				</form>
	<!-- 			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="form-group">
					<div class="content">
								<div class="form-actions">
									<div class="row">
											<label class="col-md-6 control-label"> Amount</label>
										

												<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="assetMaintenanceApprovalObj.amount" id="amount"
													name="amount" readonly>
													
														<label class="col-md-6 control-label"> Amount</label>
										
														
														<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="assetMaintenanceApprovalObj.amount" id="amount"
													name="amount" readonly>
													
													<label class="col-md-6 control-label"> Amount</label>
														
														<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="assetMaintenanceApprovalObj.amount" id="amount"
													name="amount" readonly>
												
										
										

</div>
										</div>
											</div>
										</div>
										</div>
											</div> -->
											
											
													<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="content">
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											
										 
									<label class="col-md-6 control-label">Buying  Amount</label>
										

									<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="joborder.buy1" id="buy1"
													name="buy1" readonly>													
										
</div>
									<div class="col-md-12">
											
										 
									<label class="col-md-6 control-label">Selling Amount</label>
										

												<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="joborder.sell1" id="sell1"
													name="sell1" readonly>													
										

											

									</div>
										<div class="col-md-12">
											
										 
									<label class="col-md-6 control-label"> Total Amount</label>
										

												<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="joborder.total" id="total"
													name="amount" readonly>													
										

											

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="content">
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" ng-if="!edit"
												ng-click="saveBooking(jobOrderForm)">
												<i class="fa fa-save"></i> Save
											</button>
							
										 	<!-- <button class="btn btn-success"  ng-if="edit"
												ng-click="printRoutingOrder(joborder.jobId)">
												<i class="fa fa-print"></i> Print - Routing Order
											</button>
											<button class="btn btn-success"  ng-if="edit"
												ng-click="JobSheet(joborder.jobId)">
												<i class="fa fa-print"></i> Print -JobSheet
											</button> -->
											
											<button class="btn btn-success"  ng-if="edit"
										ng-click="printPrealertSea(joborder.jobId)">
												<i class="fa fa-print"></i> Print - Pre-Alert
											</button>
																						
											<button class="btn btn-success"
												ng-click="submitupdate(jobOrderForm,joborder)" ng-if="edit">
												<i class="fa fa-save"></i> Update
											</button>

											<button class="btn btn-info" type="reset" ng-click="reset()">
												<i class="fa fa-undo"></i> Reset
											</button>


											<button class="btn btn-danger" type="reset"
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i> Cancel
											</button>

									</div>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
</div>
