<style>
.custom-col-md-6 {
	padding-right: 0px;
	padding-left: 0px;
}

.custom-col-md-3 {
	padding-right: 25px;
}
</style>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="generalInvoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<input type="hidden" ng-model="generalinvoice.ExchangeRateFrom"
						id="ExchangeRateFrom" /> <input type="hidden"
						ng-model="generalinvoice.ExchangeRateTo" id="ExchangeRateTo" /> <input
						type="hidden" ng-model="generalinvoice.currencyValue"
						id="currencyValue" /> <input type="hidden"
						ng-model="generalinvoice.fraction" id="fraction" />

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Company<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity  list="companyList"
											property="generalinvoice.companyCode" name="companyCode"
											ng-model="generalinvoice.companyCode" validation="required"
											friendly-name="Company" form-name="generalInvoiceForm"></selectivity>
									</div>
									
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Invoice
										Date<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="generalinvoice.invoiceDt"
											id="invoiceDt" name="invoiceDt" 
											form-name="generalInvoiceForm"
											data-ng-change="checkDatesCL(generalinvoice.invoiceDt)"
											friendly-name="Invoice Date" validation="required" />
										
									</div>
								</div>
							</div>
<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Currency<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="currencyList"
											property="generalinvoice.currencyHdr" id="currencyHdr"
											name="currencyHdr" ng-model="generalinvoice.currencyHdr"
											validation="required" friendly-name="currency"
											form-name="generalInvoiceForm"></selectivity>
                                	</div>
								</div>
							</div>
							
							<!-- <div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Mode<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity  list="modeList"
											property="generalinvoice.mode" name="mode"
											ng-model="generalinvoice.mode" validation="required"
											friendly-name="Mode" form-name="generalInvoiceForm"></selectivity>
									</div>
									
								</div>
							</div> -->
						</fieldset>
					</div>

					
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="customerList"
											property="generalinvoice.customer" id="customer"
											name="customer" ng-model="generalinvoice.customer"
											validation="required" friendly-name="Customer"
											form-name="generalInvoiceForm"></selectivity>
                                	</div>
								</div>
							</div>


							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Branch <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="branchList"
											ng-model="generalinvoice.bank" validation="required" friendly-name="Branch"
											property="generalinvoice.bank" id="Branch"
											 name="Branch" form-name="generalInvoiceForm"></selectivity>
									</div>
								</div>
							</div>
							
									<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Bank <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="bank1List"
											ng-model="generalinvoice.bankCode" validation="required" friendly-name="Bank"
											property="generalinvoice.bankCode" id="Bank"
											 name="Bank" form-name="generalInvoiceForm"></selectivity>
									</div>
								</div>
							</div>
							
							
							
							
						</fieldset>
					</div>

					
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks</label>
									<div class="col-md-7">
										<textarea rows="2" cols="4"
											class="form-control resize-vertical" name="remarks"
											ng-model="generalinvoice.remarks">
           									</textarea>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Narration </label>
									<div class="col-md-7">
									<textarea rows="2" cols="4"
										class="form-control resize-vertical" name="narration"
										ng-model="generalinvoice.narration">
           									</textarea>
           									</div>
								</div>
							</div>
							<!-- <div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Job Related</label>
									<div class="col-md-7">
										<input type="checkbox" name="triprelated" id="tripRelated"
											ng-model="generalinvoice.tripRelated">

									</div>
								</div>
							</div> -->
						</fieldset>
					</div>
					<!-- <div class="col-sm-12">
						<fieldset>
							
							<div class="col-md-4" ng-if="generalinvoice.tripRelated && generalinvoice.mode==1 ">
								<div class="form-group">
									<label class="col-md-5 control-label">Job<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="jobOrderList"
											property="generalinvoice.jobOrderNo" id="jobOrderNo"
											name="jobOrderNo" ng-model="generalinvoice.jobOrderNo"
											validation="required" friendly-name="jobOrderNo"
											form-name="generalInvoiceForm"></selectivity>


									</div>
								</div>
							</div>

                            <div class="col-md-4" ng-if="generalinvoice.tripRelated && generalinvoice.mode==1">
								<div class="form-group">
									<label class="col-md-5 control-label">POL</label>
									<div class="col-md-7">
											<selectivity list="PorthdrList" property="generalinvoice.Pol"
											id="Pol"></selectivity>
										<input type="text" class="form-control input-sm" id="pol"
											name="pol" disabled="disabled" ng-model="generalinvoice.pol" />

									</div>
								</div>
							</div>
							<div class="col-md-4" ng-if="generalinvoice.tripRelated && generalinvoice.mode==1 ">
								<div class="form-group">
									<label class="col-md-5 control-label">POD</label>
									<div class="col-md-7">
												<selectivity list="PorthdrList" property="generalinvoice.Pod"
											id="Pod"></selectivity>
										<input type="text" class="form-control input-sm" id="pod"
											name="pod" disabled="disabled" ng-model="generalinvoice.pod" />

									</div>
								</div>
							</div>

						</fieldset>
					</div> -->
					
					<!-- <div class="col-sm-12">
						<fieldset>
							
							<div class="col-md-4" ng-if="generalinvoice.tripRelated && generalinvoice.mode==2 ">
								<div class="form-group">
									<label class="col-md-5 control-label">Job<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="seaJobOrderList"
											property="generalinvoice.airJobOrderNo" id="airJobOrderNo"
											name="airJobOrderNo" ng-model="generalinvoice.airJobOrderNo"
											validation="required" friendly-name="JobOrderNo"
											form-name="generalInvoiceForm"></selectivity>


									</div>
								</div>
							</div>

                           <div class="col-md-4" ng-if="generalinvoice.tripRelated && generalinvoice.mode==2">
								<div class="form-group">
									<label class="col-md-5 control-label">AOL</label>
									<div class="col-md-7">
											<selectivity list="PorthdrList" property="generalinvoice.Pol"
											id="Pol"></selectivity>
										<input type="text" class="form-control input-sm" id="aol"
											name="aol" disabled="disabled" ng-model="generalinvoice.aol" />

									</div>
								</div>
							</div>
							<div class="col-md-4" ng-if="generalinvoice.tripRelated && generalinvoice.mode==2 ">
								<div class="form-group">
									<label class="col-md-5 control-label">AOD</label>
									<div class="col-md-7">
												<selectivity list="PorthdrList" property="generalinvoice.Pod"
											id="Pod"></selectivity>
										<input type="text" class="form-control input-sm" id="aod"
											name="aod" disabled="disabled" ng-model="generalinvoice.aod" />



									</div>
								</div>
							</div>

							


						</fieldset>
					</div> -->
				</div>


				<div class="table-responsive">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
										
										<th colspan=1 class="width_13 text-center">Charge Heads<span
										style="color: red;">*</span></th>
                                        <th colspan=1 class="width_8 text-center">SAC No</th>
										<th colspan=1 class="width_8 text-center">Unit<span
										style="color: red;">*</span></th>
										<th colspan=1 class="width_8 text-center">Qty<span
										style="color: red;">*</span></th>
										<th colspan=1 class=" width_8 text-center">Currency<span
										style="color: red;">*</span></th>
										<th colspan=1 class=" width_8 text-center">Ex-Rate<span
										style="color: red;">*</span></th>
										<th colspan=1 class=" width_8 text-center">Rate<span
										style="color: red;">*</span></th>
										<th colspan=1 class=" width_8 text-center">Amount</th>
									    <th colspan=1 class=" width_8 text-center">Tax Type</th>
										<th colspan=1 class=" width_8 text-center">Tax Amount</th>
							</tr>
						</thead>

						<tbody ng-repeat="(trIndex, row) in generalinvoice.GIDtl" ng-controller="GItableCtrl">
							<tr>
										<td><label class="i-checks m-b-none"> <input
												type="checkbox" ng-model="row.select"><i></i></label></td>

										<td>
										    <div class="row">
												<div class="col-xs-12">
													
											    <selectivity list="chargeHeadGenList"
											             ng-model="row.chargeHead"
											                  property="row.chargeHead" id="chargeHead{{trIndex}}" 
											              object="chargeHead" name="chargeHead{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Charge Heads)'}}" form-name="generalInvoiceForm"></selectivity>
												</div>
											</div></td>
											<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="sacNo{{trIndex}}" ng-model="row.sacNo"
														name="sacNo" disabled>
												</div>
											</div>
										</td>	
										<td>
											<div class="row">
												<div class="col-xs-12">
													<selectivity list="unitList"
											             ng-model="row.unit"
											                  property="row.unit" id="unit{{trIndex}} "
											              object="unit" name="unit{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Unit)'}}" form-name="generalInvoiceForm"></selectivity>
												</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="qty{{trIndex}}" ng-model="row.qty"
														name="qty" validation="required"
														ng-keyup="calculateAmount(generalinvoice.customer,generalinvoice.bank,row.chargeHead,row.qty,row.exchangeRate,row.rate,$index,row)"
														friendly-name="{{ 'Row' + $index + '(Qty)'}}" form-name="generalInvoiceForm">
												</div>
											</div>
										</td>
												
										<td>
											<div class="row">
												<div class="col-xs-12">
													<selectivity list="currencyList"
											             ng-model="row.currencyDtl" 
											                  property="row.currencyDtl" id="currencyDtl{{trIndex}}"
											              object="currencyDtl" name="currencyDtl{{trIndex}}" validation="required"
														friendly-name="{{ 'Row' + $index + '(Currency)'}}" form-name="generalInvoiceForm"></selectivity>
												</div>
											</div>
										</td>

										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"
														name="exchangeRate" validation="required" ng-keyup="calculateAmount(generalinvoice.customer,generalinvoice.bank,row.chargeHead,row.qty,row.exchangeRate,row.rate,$index,row)"
														friendly-name="{{ 'Row' + $index + '(Ex-Rate)'}}" form-name="generalInvoiceForm">
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="rate{{trIndex}}" ng-model="row.rate"
														name="rate" step="0.01" validation="required" form-name="generalInvoiceForm"
									                    ng-keyup="calculateAmount(generalinvoice.customer,generalinvoice.bank,row.chargeHead,row.qty,row.exchangeRate,row.rate,$index,row)"
														friendly-name="{{ 'Row' + $index + '(Rate)'}}" >
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="amount{{trIndex}}" ng-model="row.amount"
														name="amount" 
														friendly-name="{{ 'Row' + $index + '(Amount)'}}" disabled>
												</div>
											</div>
										</td>
								<td>
											<div class="row">
												<div class="col-xs-12" align="center">
													<button type="button" ng-click="showTax(generalinvoice.customer,generalinvoice.bank,row.chargeHead)">View
												    </button>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="taxAmount{{trIndex}}" ng-model="row.taxAmount"
														name="taxAmount" 
														friendly-name="{{ 'Row' + $index + '(Tax Amount)'}}" disabled>
												</div>
											</div>
										</td>
									</tr>
									
									<tr>
										<td colspan="12">
									<div class="col-sm-12">
										<!-- Attributes list -->
										
										<div class="col-sm-2 padding-top-5" ng-if="generalinvoice.mode==1 && row.isHBL">
											<label class="col-md-4 control-label"> HBL </label>
											<div class="col-md-8">
												<selectivity list="hblList" property="row.hbl" ng-model="row.hbl"
													id="hbl{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="generalinvoice.mode==1 && row.isMBL">
											<label class="col-md-4 control-label" > MBL </label>
											<div class="col-md-8">
												<selectivity list="mblList" property="row.mbl"
													id="voyageCode{{trIndex}}" ng-model="row.mbl"
													 name="mbl{{trIndex}}" >
												</selectivity>
											</div>


										</div>
										<div class="col-sm-2 padding-top-5" ng-if="generalinvoice.mode==2 && row.isHAWB">
											<label class="col-md-5 control-label"> HAWB </label>
											<div class="col-md-7">
												<selectivity list="hawbList" property="row.hawb"
													id="hawb{{trIndex}}" ng-model="row.hawb"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="generalinvoice.mode==2 && row.isMAWB">
											<label class="col-md-5 control-label"> MAWB </label>
											<div class="col-md-7">
												<selectivity list="mawbList" property="row.mawb"
													id="mawb{{trIndex}}" ng-model="row.mawb"
													name="mawb{{trIndex}}">
												</selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="generalinvoice.mode==2 && row.isFlightNo">
											<label class="col-md-5 control-label"> Flight No </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													ng-model="row.flightNo" name="flightNo{{trIndex}}" >
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="generalinvoice.mode==1 && row.isVessel">
											<label class="col-md-5 control-label"> Vessel & Voyage </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
														ng-model="row.vessel"
														name="vessel{{trIndex}}">
											</div>
										</div>	
										<div class="col-sm-2 padding-top-5" ng-if="generalinvoice.mode==1 && row.isContainerNo">
											<label class="col-md-5 control-label"> Container No </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
														ng-model="row.containerNo"
														name="containerNo{{trIndex}}">
											</div>
										</div>
										</div>
								</td>
										
									</tr>

						</tbody>

					</table>
                  <br><br><br><br><br><br><br>
					<div class="padding-right-5">
						<div class="col-md-4">
							<button ng-click="addRow(generalinvoice.GIDtl)"
								class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
								type="button">
								<i class="fa fa-plus"></i>
							</button>
							<button ng-click="removeRow(generalinvoice.GIDtl)"
								class="btn btn-sm btn-danger" type="button" tooltip="Delete">
								<i class="fa  fa-trash-o"></i>
							</button>
						</div>
						<div class="col-md-8" >
									<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total </label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="generalinvoice.totalAmount" readonly 
												placeholder="0.0">
										</div>

									</div>
								</div>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!generalinvoice.isEdit"
								ng-click="onSubmit(generalInvoiceForm,generalinvoice)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button"
								ng-if="generalinvoice.isEdit"
								ng-click="onSubmit(generalInvoiceForm,generalinvoice)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>
	</div>
</div>
