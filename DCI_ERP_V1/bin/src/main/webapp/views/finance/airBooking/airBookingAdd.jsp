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

<style>a:hover {
	color: black;
}
.panel .actions {
    right: 8%;
  }
.subTable-brs {
  padding: 8px !important;
}

.text-space{
padding-bottom: 10px;
}

</style>

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div>
			<input type="hidden" value="${form_code}" id="form_code_id">
			<div class="panel-body">
				<form name="bookingForm" class="form-horizontal" novalidate>
					<div class="row book-widget-row">
					
					
					<div class="col-sm-12 " align="center">
						
							
							<div class="form-group col-md-12 col-lg-12" ng-if="isEdit" >
									<label for="inputPassword" class="control-label col-md-5">Booking No 
									</label>
									<div class="col-md-2" >
										<input type="text" class="form-control input-sm text-left"
											ng-model="booking.bookingNo" name="bookingNo" maxlength=50 disabled
											form-name='bookingForm' friendly-name="bookingNo">
									</div>
								</div>
							
								</div>
								
						<div class="col-sm-12 ">
							<fieldset>
							
							<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Mode <span style="color: red;">*</span>
									</label>
									<div class="col-md-7" >
										<selectivity list="modeList" ng-model="booking.mode"
											property="booking.mode" name="mode"
											validation="required" friendly-name=Mode
											form-name="bookingForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label for="inputPassword" class="control-label col-md-5">Booking Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="booking.bookingDate"
											name="bookingDate" form-name="bookingForm"
											friendly-name="Booking Date" validation="required" />
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Service <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="servicePartnerTypelist" ng-model="booking.service"
											property="booking.service" name="service"
											validation="required" friendly-name=SERVICE
											form-name="bookingForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Branch <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="branchList" ng-model="booking.branch"
											property="booking.branch" name="branch"
											validation="required" friendly-name=BRANCH
											form-name="bookingForm"></selectivity>
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
										<selectivity list="customerList" ng-model="booking.customer"
											property="booking.customer" name="customer" id="customer"
											validation="required" friendly-name="Customer"
											form-name="bookingForm"></selectivity>
									</div>
								</div>
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Shipper <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" ng-model="booking.shipper"
											property="booking.shipper" name="shipper"
											validation="required" friendly-name="Shipper"
											form-name="bookingForm"></selectivity>
									</div>
								</div>

								
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Consignee <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="booking.consignee"
											ng-model="booking.consignee" name="consignee" validation="required"
											friendly-name="Consignee" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Term <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="TermList" property="booking.term"
											ng-model="booking.term" name="term" validation="required"
											friendly-name="Term" form-name="bookingForm"></selectivity>
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
										<selectivity list="portList" property="booking.aol"
											ng-model="booking.aol" name="aol" validation="required"
											friendly-name="Aol" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> AOD <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="booking.aod"
											ng-model="booking.aod" name="aod" validation="required"
											friendly-name="AOD" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> ORIGIN <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="booking.origin"
											ng-model="booking.origin" name="origin" validation="required"
											friendly-name="Origin" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> DESTINATION <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="portList" property="booking.destination"
											ng-model="booking.destination" name="destination" validation="required"
											friendly-name="Destination" form-name="bookingForm"></selectivity>
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
										<input type="text" class="form-control input-sm text-right"
											ng-model="booking.commodity" name="commodity" maxlength=50
											form-name='bookingForm' friendly-name="Commodity">
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Booking Status <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="bookingStatusList" property="booking.bookingStatus"
											ng-model="booking.bookingStatus" name="bookingStatus" validation="required"
											friendly-name="booking Status" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Currency <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="currencylist" property="booking.currency"
											ng-model="booking.currency" name="currency" validation="required"
											friendly-name="Currency" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Quotation 
									</label>
									<div class="col-md-6" style="padding-right:4px;width:48%">
										<selectivity list="quotationList" ng-model="booking.quotationNo"
											property="booking.quotationNo" class="quoLiCls" name="quotationNo"
											 friendly-name="quotationNo"
											form-name="bookingForm"></selectivity>
											</div>
										<!-- 	<div class="col-md-1" style="padding-left: 1px;">
											<button id="quoIconId"  class="btn btn-success" style="padding: 2px 7px;margin-top: 7px;color: #ffffff;background-color: #27b6af;" 
											ng-click="showHideQuotation()" >
											<span class="fa fa-bolt"></span>
     										</button>
								</div> -->
								</div>
								
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Work Order No <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="booking.workOrderNo" name="workOrderNo" 
											form-name='bookingForm' friendly-name="workOrderNo">
									</div>
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
										<selectivity list="salesTypeList" property="booking.salesType"
											ng-model="booking.salesType" name="salesType" validation="required"
											friendly-name="Sales Type" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Sales Person <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="employeeList" property="booking.salesPerson"
											ng-model="booking.salesPerson" name="salesPerson" validation="required"
											friendly-name="Sales Person" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Nominated By <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="booking.nominatedBy"
											ng-model="booking.nominatedBy" name="nominatedBy" validation="required"
											friendly-name="Nominated By" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Vendor <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="customerList" property="booking.vendor"
											ng-model="booking.vendor" name="vendor" validation="required"
											friendly-name="Vendor" form-name="bookingForm"></selectivity>
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
											ng-model="booking.carrier" name="carrier"
											form-name='bookingForm' friendly-name="Carrier">
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label">  Flight No <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="booking.flightNo" name="flightNo"
											form-name='bookingForm' friendly-name="Flight No">
									</div>
								</div>
								
								<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Flight Date <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="booking.flightDate"
											name="flightDate" form-name="bookingForm"
											friendly-name="Flight Date" validation="required" />
									</div>
								</div>
								
							<div class="form-group col-md-3 col-lg-3">
									<label class="col-md-5 control-label"> Ex rate(USD) <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
									<input type="text" class="form-control input-sm text-right"
											ng-model="booking.exRate" name="exRate" 	validation="required|integer"
											form-name='bookingForm' friendly-name="Ex Rate">
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
										<selectivity list="customerList" property="booking.customsBroker"
											ng-model="booking.customsBroker" name="customsBroker" validation="required"
											friendly-name="Customs Broker" form-name="bookingForm"></selectivity>
									</div>
								</div>
						 
							</fieldset>
						</div>
					</div>
				 
					<br>
					<br>
					<br>
					<!--<div align="right" >
						<button class="btn btn-success" ng-if="isEdit && booking.quotationNo != '' && booking.quotationNo != null && booking.bookingStatus != 'D'" 
							ng-click="createTrip(booking.bookingDate,booking.lolId,booking.lodId)">
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
									<th colspan="1" class="width_1"></th>
									<th colspan="1" class="width_3 text-center">S.No</th>
									<th colspan="1" class="width_15 text-center">Charge Heads<span style="color: red;">*</span></th>
									<th colspan="1" class="width_9 text-center">Units<span style="color: red;">*</span></th>
									<th colspan="1" class="width_8 text-center">Transaction
										type<span style="color: red;">*</span>
									</th>
									<th colspan="1" class="width_5 text-center">Quantity<span style="color: red;">*</span></th>
									<th colspan="1" class="width_6 text-center">Rate<span style="color: red;">*</span></th>
									<th colspan="1" class="width_10 text-center">Currency<span style="color: red;">*</span></th>
									<th colspan="1" class="width_6 text-center">Ex rate<span style="color: red;">*</span></th>
									<th colspan="1" class="width_7 text-center">Amount<span style="color: red;">*</span></th>
									<th colspan="1" class="width_10 text-center">Payment Mode<span style="color: red;">*</span></th>
									<th colspan="1" class="width_13 text-center">Buy/Sell Party<span style="color: red;">*</span></th>
									<th colspan="1" class="width_15 text-center">Status<span style="color: red;">*</span></th>
								</tr>
							</thead>
							  <tbody ng-repeat="(trIndex, bookingDtl) in booking.bookingDtl"
								class="bookingDtlCls">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="bookingDtl.select"><i></i></label></td>
									<td class="text-center">{{trIndex+1}}</td>
									<td>
									 
										<selectivity list="chargeHeadList" property="bookingDtl.chargeHead" id="chargeHeads{{trIndex}}" 
											ng-model="bookingDtl.chargeHead" name="chargeHead{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(ChargeHead)'}}" form-name="bookingDtlForm"></selectivity>
									</td>

									<td>
									 
										<selectivity list="UnitList" property="bookingDtl.unit" id="unit"
											ng-model="bookingDtl.unit" name="unit{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(unit)'}}" form-name="bookingForm"></selectivity>
									</td>

									 <td>
									 
										<selectivity list="transactionTypeList" property="bookingDtl.transactionType"   id="transactionType{{trIndex}}" 
											ng-model="bookingDtl.transactionType" name="transactionType{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(transactionType)'}}" form-name="bookingForm"></selectivity>
									</td>
									 
									 
									<td><input type="text" id="qty{{trIndex}}"
										class="form-control input-sm text-right"
										ng-model="bookingDtl.quantity" name="quantity{{trIndex}}" 
										validation="required|integer" form-name='bookingForm'
										maxlength="3" ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(Quantity)'}}">
									</td>
									
									<td><input type="text"
										class="form-control input-sm text-right" id="rate{{trIndex}}"
										ng-model="bookingDtl.rate" name="rate{{trIndex}}"
										validation="required|integer" form-name='bookingForm'
										 ng-change="ratevalues()"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(rate)'}}">
									</td>
									
									 <td>
									 
										<selectivity list="currencylist" property="bookingDtl.currency" id="currency{{trIndex}}"
											ng-model="bookingDtl.currency" name="currency{{trIndex}}" validation="required" 
											friendly-name="{{ 'Row-' + (trIndex+1) + '(currency)'}}" form-name="bookingForm"></selectivity>
									</td>
									
										<td><input type="text"
										class="form-control input-sm text-right" id="exRate{{trIndex}}"
										ng-model="bookingDtl.exRate" name="exRate{{trIndex}}"
										validation="required|integer" form-name='bookingForm' ng-change="ratevalues()"
										
										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}">
									</td>
									
										<td><input type="text"
										class="form-control input-sm text-right"
										ng-model="bookingDtl.amount" name="amount{{trIndex}}" ng-change="ratevalues1()
										validation="required|integer" form-name='bookingForm'
										 id="amount{{trIndex}}"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(amount)'}}">
									</td>
									
										 <td>
									 
										<selectivity list="PaymentMethodList" property="bookingDtl.paymentMode" id="paymentMethod{{trIndex}}"
											ng-model="bookingDtl.paymentMode" name="paymentMode{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(paymentMode)'}}" form-name="bookingForm"></selectivity>
									</td>
									
										 <td>
									 
										<selectivity list="customerList" property="bookingDtl.buySellParty" id="buySell{{trIndex}}"
											ng-model="bookingDtl.buySellParty" name="buySellParty{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(buySellParty)'}}" form-name="bookingForm"></selectivity>
									</td>
									
										<td>
										
<!-- 										<input type="text" -->
<!-- 										class="form-control input-sm text-right" -->
<!-- 										ng-model="bookingDtl.status" name="status{{trIndex}}" -->
<!-- 										validation="required|integer" form-name='bookingForm' -->
<!-- 										maxlength="3" -->
<!-- 										friendly-name="{{ 'Row-' + (trIndex+1) + '(exRate)'}}"> -->
										
										
										<selectivity list="bookingDetailStatusList" property="bookingDtl.status" id="status{{trIndex}}"
											ng-model="bookingDtl.status" name="status{{trIndex}}" validation="required"
											friendly-name="{{ 'Row-' + (trIndex+1) + '(status)'}}" form-name="bookingForm"></selectivity>
										
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
					
						
													<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="content">
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12 text-space">
											
										 
									<label class="col-md-6 control-label">BUYING  AMOUNT</label>
										

									<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="booking.buy1" id="buy1"
													name="buy1" readonly>													
										
</div>
<br>
									<div class="col-md-12 text-space">
											
										 
									<label class="col-md-6 control-label">SELLING AMOUNT</label>
										

												<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="booking.sell1" id="sell1"
													name="sell1" readonly>													
										

											

									</div>
									<br>
										<div class="col-md-12">
											
										 
									<label class="col-md-6 control-label"> TOTAL AMOUNT</label>
										

												<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="booking.total" id="total"
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
											<button class="btn btn-success" ng-if="!isEdit"
												ng-click="saveBooking(bookingForm)">
												<i class="fa fa-save"></i> Save
											</button>
											
												<!-- <button class="btn btn-success"  ng-if="isEdit"
												ng-click="printRoutingOrder(booking.bookingId)">
												<i class="fa fa-print"></i> Print - Routing Order
											</button>
											<button class="btn btn-success"  ng-if="isEdit"
												ng-click="bookingSheet(booking.bookingId)">
												<i class="fa fa-print"></i> Print - Booking Order
											</button> -->
										<button class="btn btn-success"  ng-if="isEdit"
										ng-click="printPrealertAir(booking.bookingId)">
												<i class="fa fa-print"></i> Print - Pre-Alert
											</button>
											<button class="btn btn-success"
												ng-click="updateBooking(bookingForm)" ng-if="isEdit">
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
				</form>
			</div>
		</div>
	</div>
</div>
