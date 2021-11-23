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
	/*  border-left: 0px solid  !important;
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

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div>
			<input type="hidden" value="${form_code}" id="form_code_id">
			<div class="panel-body">
				<form name="jobOrderForm" class="form-horizontal" novalidate>
					<div class="row book-widget-row">
					
					
					<div class="col-sm-12 " align="center">
						
							
							<div class="form-group col-md-12 col-lg-12" ng-if="isEdit" >
									<label for="inputPassword" class="control-label col-md-5">Job No 
									</label>
									<div class="col-md-2" >
										<input type="text" class="form-control input-sm text-left"
											ng-model="joborder.jobNo" name="jobNo" maxlength=50 disabled
											form-name='jobOrderForm' friendly-name="jobNo">
									</div>
								</div>
							
								</div>
								
						<div class="col-sm-12 ">
							<fieldset>
							
							<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Mode <span style="color: red;">*</span>
									</label>
									<div class="col-md-7" >
										<selectivity list="modeList" ng-model="joborder.mode"
											property="joborder.mode" name="mode" disabled="true"
											validation="required" friendly-name=Mode
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Job Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.jobDate" disabled											name="jobDate" form-name="jobOrderForm"
											friendly-name="Job Date" validation="required" />
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Service <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="servicePartnerTypelist" ng-model="joborder.service"
											property="joborder.service" name="service" disabled="true"
											validation="required" friendly-name=SERVICE
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Branch <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="branchList" ng-model="joborder.branch" disabled="true"
											property="joborder.branch" name="branch"
											validation="required" friendly-name=BRANCH
											form-name="jobOrderForm"></selectivity>
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
										<selectivity list="customerList" ng-model="joborder.customer" disabled="true"
											property="joborder.customer" name="customer" id="customer"
											validation="required" friendly-name="Customer"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Shipper <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" ng-model="joborder.shipper" disabled="true"
											property="joborder.shipper" name="shipper"
											validation="required" friendly-name="Shipper"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>

								
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Consignee <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.consignee" disabled="true"
											ng-model="joborder.consignee" name="consignee" validation="required"
											friendly-name="Consignee" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Term <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="TermList" property="joborder.term" disabled="true"
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
									<label class="col-md-5 control-label"> AOL <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aol" disabled="true"
											ng-model="joborder.aol" name="aol" validation="required"
											friendly-name="Aol" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> AOD <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.aod" disabled="true"
											ng-model="joborder.aod" name="aod" validation="required"
											friendly-name="AOD" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> ORIGIN <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.origin" disabled="true"
											ng-model="joborder.origin" name="origin" validation="required"
											friendly-name="Origin" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> DESTINATION <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="joborder.destination" disabled="true"
											ng-model="joborder.destination" name="destination" validation="required"
											friendly-name="Destination" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
									</fieldset>
								</div>
								</div>
								<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
							
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Commodity <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right" disabled="true"
											ng-model="joborder.commodity" name="commodity" maxlength=50
											form-name='jobOrderForm' friendly-name="Commodity">
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Job Status <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="jobStatusList" property="joborder.jobStatus" disabled="true"
											ng-model="joborder.jobStatus" name="jobStatus" validation="required"
											friendly-name="job Status" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Currency <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="currencylist" property="joborder.currency" disabled="true"
											ng-model="joborder.currency" name="currency" validation="required"
											friendly-name="Currency" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Quotation 
									</label>
									<div class="col-md-6" style="padding-right:4px;width:48%">
										<selectivity list="quotationList" ng-model="joborder.quotationNo" disabled="true"
											property="joborder.quotationNo" class="quoLiCls" name="quotationNo"
											 friendly-name="quotationNo"
											form-name="jobOrderForm"></selectivity>
											</div>
										<!-- 	<div class="col-md-1" style="padding-left: 1px;">
											<button id="quoIconId"  class="btn btn-success" style="padding: 2px 7px;margin-top: 7px;color: #ffffff;background-color: #27b6af;" 
											ng-click="showHideQuotation()" >
											<span class="fa fa-bolt"></span>
     										</button>
								</div> -->
								</div>
								
								 
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
										<selectivity list="salesTypeList" property="joborder.salesType" disabled="true"
											ng-model="joborder.salesType" name="salesType" validation="required"
											friendly-name="Sales Type" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Person <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="employeeList" property="joborder.salesPerson" disabled="true"
											ng-model="joborder.salesPerson" name="salesPerson" validation="required"
											friendly-name="Sales Person" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Nominated By <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.nominatedBy" disabled="true"
											ng-model="joborder.nominatedBy" name="nominatedBy" validation="required"
											friendly-name="Nominated By" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Vendor <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.vendor" disabled="true"
											ng-model="joborder.vendor" name="vendor" validation="required"
											friendly-name="Vendor" form-name="jobOrderForm"></selectivity>
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
											ng-model="joborder.carrier" name="carrier" disabled
											form-name='jobOrderForm' friendly-name="Carrier">
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">  Flight No <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="joborder.flightNo" name="flightNo" disabled="true"
											form-name='jobOrderForm' friendly-name="Flight No">
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Flight Date <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="joborder.flightDate"
											name="flightDate" form-name="jobOrderForm" disabled
											friendly-name="Flight Date" validation="required" />
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Ex rate(USD) <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
									<input type="text" class="form-control input-sm text-right" disabled
											ng-model="joborder.exRate" name="exRate" 	validation="required|integer"
											form-name='jobOrderForm' friendly-name="Ex Rate">
									</div>
								</div>
								
								 
							</fieldset>
						</div>
					</div>
					
					<div class="row book-widget-row">
						<div class="col-sm-12 ">
							<fieldset>
							
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Customs Broker <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="joborder.customsBroker" disabled="true"
											ng-model="joborder.customsBroker" name="customsBroker" validation="required"
											friendly-name="Customs Broker" form-name="jobOrderForm"></selectivity>
									</div>
								</div>
						 
							</fieldset>
						</div>
					</div>
				 
					<br>
					<br>
					<br>
					<!--<div align="right" >
						<button class="btn btn-success" ng-if="isEdit && joborder.quotationNo != '' && joborder.quotationNo != null && joborder.bookingStatus != 'D'" 
							ng-click="createTrip(joborder.bookingDate,joborder.lolId,joborder.lodId)">
							<i class="fa fa-save"> </i>Create Trip
						</button>
					</div>






					 <div class="row quotationClass" ng-show="showQuotation">
						<div class="col-md-12" style="padding: 0% 7% 0% 7%;">
							<div class="panel panel-default">
								<div class="panel-heading" style="height: 37px;">
									<h3 class="panel-title" style="margin-top: 8px;">Quotation
										Details</h3>
									<div class="actions pull-right quoView">
										 <i	 class="fa fa-minus"></i>
										 <i data-fullscreen-widget class="fa fa-expand"></i> 
									</div>
								</div>

								<div class="panel panel-default panel-default-list quoHideDiv">
									<div class="panel-body padding-0">
										<div class="table-responsive " style="background-color: #e1d3d3">
											<div class="panel-body">
												<table class="table table-striped  b-light" >
													<tbody>
													<tr class="customHead" style="background-color: lightblue">
														    <th class="width_6 subTable-brs">Quotation No</th>
														    <th class="width_6 subTable-brs">Quotation DT</th>
															<th class="width_6 subTable-brs">Customer</th>
															<th class="width_6 subTable-brs">Quotation Type</th>
															<th class="width_6 subTable-brs">LOL</th>
															<th class="width_6 subTable-brs">LOD</th>
															<th class="width_6 subTable-brs">Valid From</th>
															<th class="width_6 subTable-brs">Valid Till</th>
															<th class="width_6 subTable-brs">Currency</th>
														</tr>
													      <tr style="background-color: lightblue">
															<td class="width_6 subTable-brs">{{quotationView.quoNo}}</td>
															<td class="width_6 subTable-brs">{{quotationView.quoDate}}</td>
															<td class="width_6 subTable-brs">{{quotationView.customer}}</td>
															<td class="width_6 subTable-brs">{{quotationView.quoType}}</td>
															<td class="width_6 subTable-brs">{{quotationView.lol}}</td>
															<td class="width_6 subTable-brs">{{quotationView.lod}}</td>
															<td class="width_6 subTable-brs">{{quotationView.valFrom}}</td>
															<td class="width_6 subTable-brs">{{quotationView.valTo}}</td>
															<td class="width_6 subTable-brs">{{quotationView.currency}}</td>
															
														</tr>
													</tbody>
												</table>
												<br/>
											</div>
										</div>

									</div>
								</div>

							</div>
						</div>
					</div> -->






					<div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_1"></th>
									<th colspan=1 class="width_2 text-center">S.No</th>
									<th colspan=1 class="width_13 text-center">Charge Heads<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_8 text-center">Units<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_13 text-center">Transaction
										type<span style="color: red;">*</span>
									</th>
									<th colspan=1 class="width_8 text-center">Quantity<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_9 text-center">Rate<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_9 text-center">Currency<span
										style="color: red;">*</span></th>
									<th colspan=1 class="width_8 text-center">Ex rate<span
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
							  <tbody ng-repeat="(trIndex, jobOrderDtl) in joborder.joborderDtl"
								class="bookingDtlCls">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="jobOrderDtl.select"><i></i></label></td>
									<td class="text-center">{{trIndex+1}}</td>
									<td>
									 
										<selectivity list="chargeHeadList" property="jobOrderDtl.chargeHead" id="chargeHeads{{trIndex}}" 
										disabled="true"	ng-model="jobOrderDtl.chargeHead" name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}" form-name="jobOrderDtlForm"></selectivity>
									</td>

									<td>
									 
										<selectivity list="UnitList" property="jobOrderDtl.unit" id="unit"
									disabled="true"		ng-model="jobOrderDtl.unit" name="unit{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}" form-name="jobOrderForm"></selectivity>
									</td>

									 <td>
									 
										<selectivity list="transactionTypeList" property="jobOrderDtl.transactionType"   id="transactionType{{trIndex}}" 
										disabled="true"	ng-model="jobOrderDtl.transactionType" name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									 
									 
									<td><input type="text" id="qty{{trIndex}}" disabled
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.quantity" name="quantity{{trIndex}}" 
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}">
									</td>
									
									<td><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}" disabled
										ng-model="jobOrderDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}">
									</td>
									
									 <td>
									 
										<selectivity list="currencylist" property="jobOrderDtl.currency" id="currency{{trIndex}}" disabled="true"
											ng-model="jobOrderDtl.currency" name="currency{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									
										<td><input type="text"
										class="form-control input-sm text-right" id="exRate{{trIndex}}" disabled
										ng-model="jobOrderDtl.exRate" name="exRate{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}">
									</td>
									
										<td><input type="text" disabled
										class="form-control input-sm text-right"
										ng-model="jobOrderDtl.amount" name="amount{{trIndex}}"
										validation="required|integer" form-name='jobOrderForm'
										maxlength="3" id="amount{{trIndex}}"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}">
									</td>
									
										 <td>
									 
										<selectivity list="PaymentMethodList" property="jobOrderDtl.paymentMode" id="paymentMethod{{trIndex}}" disabled="true"
											ng-model="jobOrderDtl.paymentMode" name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									
										 <td>
									 
										<selectivity list="customerList" property="jobOrderDtl.buySellParty" id="buySell{{trIndex}}" disabled="true"
											ng-model="jobOrderDtl.buySellParty" name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}" form-name="jobOrderForm"></selectivity>
									</td>
									
										<td>
										
<!-- 										<input type="text" -->
<!-- 										class="form-control input-sm text-right" -->
<!-- 										ng-model="jobOrderDtl.status" name="status{{trIndex}}" -->
<!-- 										validation="required|integer" form-name='jobOrderForm' -->
<!-- 										maxlength="3" -->
<!-- 										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}"> -->
										
										
										<selectivity list="jobDetailStatusList" property="jobOrderDtl.status" id="status{{trIndex}}" disabled="true"
											ng-model="jobOrderDtl.status" name="status{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(status)'}}" form-name="jobOrderForm"></selectivity>
										
									</td>
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
				</form>
				<!-- <div class="panel panel-default panel-default-form" ng-if="isEdit">
					<div class="panel-heading panel-heading-form font-bold">
						<label
							style="color: white; font-size: 17px; margin-left: 47%; margin-top: 15px;">Trip
							Details</label>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="col-md-6"></div>
							<div class="wrapper-md">
								<div class="panel panel-default panel-default-list"
									st-table="displayedCollection1" st-safe-src="rowCollection1">
									<div class="panel-body float-left padding-0"
										style="width: 100%;">
										<div class="table-responsive ">
											<table
												class="table table-striped table-hover dataTable no-footer">
												<thead class="dataTables-Main-Head">
													<tr>
														<th class="sorting" st-sort="conType">Trip No</th>
														<th class="sorting" st-sort="conType">Trip Start Date</th>
														<th class="sorting" st-sort="lolName">LOL</th>
														<th class="sorting" st-sort="lolName">ETD</th>
														<th class="sorting" st-sort="lodName">LOD</th>
														<th class="sorting" st-sort="lolName">ETA</th>
														<th class="sorting" st-sort="conType">Con.Quantity</th>
														<th class="sorting" st-sort="conType">Container No</th>


													</tr>
												</thead>
												<tbody class="dataTables-Main-Body">
													<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
														ng-repeat="summary in SummaryList">
														<td>{{summary.tripNo}}</td>
														<td>{{summary.tripStartDate}}</td>
														<td>{{summary.lolName}}</td>
														<td>{{summary.etd}}</td>
														<td>{{summary.lodName}}</td>
														<td>{{summary.eta}}</td>
														<td>{{summary.conType}}</td>
														<td>{{summary.containerNo}}</td>

													</tr>
													<tr x-ng-show="showEmptyLabel">
														<td colspan="6" class="text-center">No Records Found</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div> -->
			</div>
		</div>
	</div>
</div>
