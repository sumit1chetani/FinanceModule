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
<div class="form-group ">
								<label class="col-md-5 control-label">Carrier <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="carrierList" ng-model="invoiceData.carrier"
										 property="invoiceData.carrier"
										id="carrier"  name="Carrier"
										friendly-name="Carrier" validation="required"
										form-name="invoiceForm"></selectivity>
								</div>
							</div></div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">BL No.<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="pendingBlList" property="invoiceData.blNo"
											id="blNo" name="blNo" ng-model="invoiceData.blNo"
											validation="required" friendly-name="BL No."
											form-name="invoiceForm"></selectivity>
									</div>
								</div>
							</div>


							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Bill
										Date </label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="invoiceData.billDate"
											id="billDate" name="billDate" form-name="invoiceForm"
											 friendly-name="Bill Date"   />

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer  </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.customerName" disabled
											name=" customerType" id="customerType"
											friendly-name="Customer"   />
									</div>
								</div>
							</div>


						</fieldset>
					</div>
					
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.vesselName" disabled name=" Vessel"
											id="Vessel" friendly-name="Vessel"   />
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.voyageName" disabled name=" Voyage"
											id="Voyage" friendly-name="Voyage"  />
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking No. </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.bookingNo" disabled name=" bookingNo"
											id="bookingNo" friendly-name="bookingNo" />
									</div>
								</div>
							</div>
									
						</fieldset>
					</div>
					
					<div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Port </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.pol" disabled name="pol"
											id="pol" friendly-name="pol" />
									</div>
								</div>
							</div>
							
								<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Freight Term </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.freightTypeName" disabled name="freightTypeName"
											id="freightTypeName" friendly-name="FreightTerm" />
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Invoice Currency </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.currency" disabled name="currency"
											id="currency" friendly-name="currency" />
									</div>
								</div>
							</div>
						</fieldset>
						</div>
						<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation No.</label>
									<div class="col-md-7">
									
									<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.quotation" disabled name="quotation"
											id="quotation" friendly-name="quotation" />
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Agent Name</label>
									<div class="col-md-7">
									<textarea  type="text" class="form-control input-sm"
															name="agentName" 
															class="custom-scroll width_250 resize-none" rows="2"
															ng-model="invoiceData.agentName" disabled>
															</textarea>
									
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Sailing Date</label>
									<div class="col-md-7">
									<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.sailDate" disabled name="sailDate"
											id="sailDate" friendly-name="sailDate" />
										
									</div>
								</div>
							</div>
							
							
								
							
						</fieldset>
					</div>
					
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">BL Type </label>
									<div class="col-md-7">
										<selectivity list="checktypeList" property="invoiceData.checktype"
												ng-model="invoiceData.checktype" id="checktype" object="checktype"></selectivity>
									
									</div>
								</div>
							</div>
							 <div class="col-md-4" ng-if="details">
								<div class="form-group">
									<label class="col-md-5 control-label">Terminal </label>
									<div class="col-md-7">
										<selectivity list="terminalList" property="invoiceData.terminalvar"
												ng-model="invoiceData.terminalvar" id="terminalvar" object="terminalvar"></selectivity>
									
									</div>
								</div>
							</div> 
						</fieldset>
					</div>
				</div>


				<div class="table-responsive">
					
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan="13" class="text-center">Container Type &
									Charges</th>
							</tr>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th colspan=1 class="width_13 text-center">Container No.</th>
								<th colspan=1 class="width_13 text-center">Container Type</th>
								<th colspan=1 class="width_13 text-center">Type of Charge</th>
								<th colspan=1 class="width_10 text-center">Quantity</th>
										<th colspan=1 class="width_10 text-center">Currency</th>
								<th colspan=1 class="width_10 text-center">Rate</th>
										<th colspan=1 class="width_10 text-center">Ex.Rate</th>
								<th colspan=1 class="width_10 text-center">Amount</th>
								<th colspan=1 class="width_10 text-center">Amount({{invoiceData.currency}})</th>
				
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in invoiceData.detailList track by trIndex">
							<tr>
								<td></td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="containerNo{{trIndex}}" disabled
												ng-model="row1.containerNo" name="containerNo{{trIndex}}"
												validation="required"
												friendly-name="{{ 'Row' + $index + '(container No)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="containerType{{trIndex}}" disabled
												ng-model="row1.containerTypeName"
												name="containerType{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="noOfBoxBx{{trIndex}}" disabled
												ng-model="row1.chargeTypeName" name="crgname{{trIndex}}"
												validation="required"
												friendly-name="{{ 'Row' + $index + '(No Of Box)'}}" />
										</div>
									</div>
								</td>

								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="quantity{{trIndex}}" disabled ng-model="row1.quantity"
												name="quantity{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(quantity)'}}" />
										</div>
									</div>
								</td>
								
								<td>
									
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="currency{{trIndex}}" disabled ng-model="row1.currency"
												name="currency{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + 'currency'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="rate{{trIndex}}" disabled ng-model="row1.rate"
												name="rate{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(Rate)'}}" />
										</div>
									</div>
								</td>
								
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="exchangeRate{{trIndex}}" disabled ng-model="row1.exchangeRate"
												name="exchangeRate{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(exchangeRate)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="quanrate{{trIndex}}" disabled ng-model="row1.quanrate"
												name="quanrate{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(Amount)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="tcAmount{{trIndex}}" disabled ng-model="row1.tcAmount"
												name="tcAmount{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" />
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					
                  
					<div class="col-sm-12">
					<fieldset>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"> </label>
								<div class="col-md-7"></div>
							</div>
						</div>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Total Amount ({{invoiceData.currency}})</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm text-right"
										ng-model="invoiceData.grandTotal" disabled name=" grandTotal"
										id="grandTotal" />
								</div>
							</div>
						</div>


					</fieldset>
				</div>
				</div>

				<div class="form-actions">
					<div class="row">
				<div class="col-md-12">
				<button class="btn btn-success" type="button"
					 ng-click="showaddchargespopup(invoiceData)">
						<i class="fa fa-plus" ></i> Additional Charges
					</button>
				<button class="btn btn-success" type="button"
						ng-click="printpreviewInvoice(invoiceForm)">
						<i class="fa fa-print"></i> Print Preview
					</button>
					
					<button class="btn btn-success" type="button"
						ng-if="!invoiceData.isEdit" ng-click="save(invoiceData)">
						<i class="fa fa-save"></i> Save
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
