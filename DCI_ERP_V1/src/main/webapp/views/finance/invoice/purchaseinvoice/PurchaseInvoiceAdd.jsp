<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="breadcrumb-wrapper ng-scope">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="purchaseInvoiceForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Job No <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity  list="jobNoList"
												ng-model="purchaseInvoiceData.jobNo"
												property="purchaseInvoiceData.jobNo" id="job_no"
												object="jobNo" name="job_no" validation="required"
												friendly-name="jobNo" form-name="purchaseInvoiceForm"></selectivity>
										</div>
									
									</div>
									<div class="form-group " style="padding-bottom: 12px">
								<label class="col-md-5 control-label">Purchase Invoice No </label>
								<div class="col-md-7">
									<label>{{purchaseInvoiceData.quotationNo}}</label>
								</div>
								</div>
									
									
									<div class="form-group">
										<label class="col-md-5 control-label"> Customer <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="customerList" property="purchaseInvoiceData.customerId"
											ng-model="purchaseInvoiceData.customerId" name="customer" 
											form-name="purchaseInvoiceForm" disabled="true"></selectivity>
											
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> AOL <span
											style="color: red;">*</span>
										</label>
									
										<div class="col-md-7">
											<selectivity list="portList" property="purchaseInvoiceData.aolId"
											ng-model="purchaseInvoiceData.aolId" name="aol" 
											form-name="purchaseInvoiceForm" disabled="true"></selectivity>
											
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Origin </label>
									
										<div class="col-md-7">
											<selectivity list="portList" property="purchaseInvoiceData.originId"
											ng-model="purchaseInvoiceData.originId" name="Origin" 
											form-name="purchaseInvoiceForm" disabled="true"></selectivity>
											
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Flight
											No 
										</label>

										<div class="col-md-7">
											<input type="text" class="form-control" name="flightNo"
												ng-model="purchaseInvoiceData.flightNo" disabled> </>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label">Arrival Date</label>

										<div class="col-md-7">
											<ng-bs3-datepicker data-ng-model="purchaseInvoiceData.arrivalDate"
												id="arrival" name="arrivalDate" form-name="purchaseInvoiceForm"  />
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Remarks</label>
										<div class="col-md-7">
											<textarea rows="2" cols="4"
												class="form-control resize-vertical" name="remarks"
												ng-model="purchaseInvoiceData.remarks">
           									</textarea>
										</div>
									</div>
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Party <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											 <selectivity list="partyList"
												property="purchaseInvoiceData.partyNo"
												ng-model="purchaseInvoiceData.partyNo" id="party_id"
												name="party_id" object="party"  form-name="purchaseInvoiceForm" validation="required" friendly-name="Party"></selectivity> 
												
												<!-- <input type="text" class="form-control" name="party"
												ng-model="purchaseInvoiceData.party"  disabled> </> -->
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Reference
											No <span style="color: red;">*</span>
										</label>
										<!-- 	<div class="col-md-7">
             									<div class="input-group input-append date">
                									<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                									 ng-model="purchaseInvoiceData.partyInvoiceDate" name="Party Invoice Date" id="party_invoice_date"
                									 validation="required" friendly-name="Party Invoice Date">
                									 <span class="input-group-addon add-on">
                        								<span class="glyphicon glyphicon-calendar"></span>
                    								 </span>
		                     				     </div>
            								</div> -->
										<div class="col-md-7">
											<input type="text" class="form-control" name="Reference"
												ng-model="purchaseInvoiceData.reference" validation="required" friendly-name="Reference No"> </>
										</div>
									</div>
									  
									<div class="form-group">
										<label class="col-md-5 control-label"> AOD <span
											style="color: red;">*</span>
										</label>
									
										<div class="col-md-7">
											<selectivity list="portList" property="purchaseInvoiceData.aodId"
											ng-model="purchaseInvoiceData.aodId" name="aod" 
											form-name="purchaseInvoiceForm" disabled="true"></selectivity>
										</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Destination </label>
									
										<div class="col-md-7">
											<selectivity list="portList" property="purchaseInvoiceData.destinationId"
											ng-model="purchaseInvoiceData.destinationId" name="destination" 
											form-name="purchaseInvoiceForm" disabled="true"></selectivity>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label">Flight Date</label>

										<div class="col-md-7">
											<ng-bs3-datepicker ng-model="purchaseInvoiceData.flightDate"
												id="flight" name="flightDate"
												form-name="purchaseInvoiceForm" form-name="purchaseInvoiceForm" disabled />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label">Departure Date</label>

										<div class="col-md-7">
											<ng-bs3-datepicker data-ng-model="purchaseInvoiceData.departureDate"
												id="departure" name="departureDate" form-name="purchaseInvoiceForm"  />
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Narration<span
									style="color: red"></span></label>
										<div class="col-md-7">
											<textarea rows="2" cols="4"
												class="form-control resize-vertical" name="narration"
												ng-model="purchaseInvoiceData.narration"  friendly-name="Narration">
           									</textarea>
										</div>
									</div>
									<!-- <div class="form-group">
										<label class="col-md-5 control-label"> TC Amount
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm text-right" ng-model="purchaseInvoiceData.tcAmount"
												name="TC Amount" ng-keyup="amountLocalCalculation(purchaseInvoiceData.tcAmount)"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"  step="0.001" friendly-name="TC Amount" >
										</div>
									</div> -->
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
							
								
								 
                                 <div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Invoice
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<ng-bs3-datepicker
												data-ng-model="purchaseInvoiceData.puchaseInvoiceDate"
												id="puchaseInvoiceDate" name="puchaseInvoiceDate"
												form-name="purchaseInvoiceForm"
												data-ng-change="checkDatesCL(purchaseInvoiceData.puchaseInvoiceDate)"
												friendly-name="PurchaseInvoice Date" validation="required" />

										</div>
									</div>
								<div class="form-group">
									<label class="col-md-5 control-label">Show Shipper </label>
									<div class="col-md-7">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												class="checkbox style-0" name="shipper"
												ng-model="purchaseInvoiceData.shipper" ng-true-value="1"
												ng-false-value="0"> <i></i>
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label">Show Consignee </label>
									<div class="col-md-7">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												class="checkbox style-0" name="consignee"
												ng-model="purchaseInvoiceData.consignee" ng-true-value="1"
												ng-false-value="0"> <i></i>
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label"> Bank <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
									<selectivity list="bankList"
												property="purchaseInvoiceData.bankDtl"
												ng-model="purchaseInvoiceData.bankDtl" id="bank_id" validation="required"
												friendly-name="Bank"
												name="bank_id" object="bankDtl"  form-name="purchaseInvoiceForm"></selectivity>
											<!-- <input type="text" class="form-control" name="bank"
												ng-model="purchaseInvoiceData.bank" form-name="purchaseInvoiceForm" disabled> </> -->
										</div>
								</div>
                                 <!--  <div class="form-group">
										<label class="col-md-5 control-label"> HAWB No 
										</label>
										<div class="col-md-7">
											<selectivity list="hawbList"
												property="purchaseInvoiceData.hawb"
												ng-model="purchaseInvoiceData.hawb" id="hawb_id"
												name="hawb_id" object="hawb"  form-name="purchaseInvoiceForm"></selectivity>
										</div>
									</div> -->
								<!-- 	<div class="form-group">
									<label class="col-md-5 control-label"> MAWB No 
									</label>
										<div class="col-md-7">
										<selectivity list="mawbList"
											property="purchaseInvoiceData.mawb"
											ng-model="purchaseInvoiceData.mawb" id="mawb_id"
											name="mawb" object="mawb"  form-name="purchaseInvoiceForm"></selectivity>
									</div>
								</div>  -->
								 <div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Vendor Invoice
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<ng-bs3-datepicker
												data-ng-model="purchaseInvoiceData.vendorInvoiceDate"
												id="vendorInvoiceDate" name="vendorInvoiceDate"
												form-name="purchaseInvoiceForm"
											
												friendly-name="Vendor Invoice Date" validation="required" />

										</div>
									</div>
							</div>

						</div>
						<div class="table-responsive clear">
							<table class="table table-striped b-t b-light">
								<thead>
									<tr>
										<th colspan=1 class="width_1"><label class="i-checks m-b-none"> <input
												type="checkbox" ng-model="purchaseInvoiceData.selectBox" ng-click="selectAll(purchaseInvoiceData.purchaseInvoiceDetail)"><i></i></label></th>
										
										<th colspan=1 class="width_13 text-center">Charge Heads</th>

										<th colspan=1 class="width_8 text-center">Unit</th>
										<th colspan=1 class="width_8 text-center">Qty</th>
										<th colspan=1 class=" width_8 text-center">Rate</th>
										<th colspan=1 class=" width_8 text-center">Currency</th>
										<th colspan=1 class=" width_8 text-center">Ex-Rate</th>
										<th colspan=1 class=" width_8 text-center">Amount</th>
									    <th colspan=1 class=" width_8 text-center">Tax View</th>
									    <th colspan=1 class=" width_8 text-center">Tax Percentage</th>
										<th colspan=1 class=" width_8 text-center">Tax Amount</th>


									</tr>
								</thead>
								<tbody
									ng-repeat="(trIndex, row) in purchaseInvoiceData.purchaseInvoiceDetail"
									ng-controller="purinvtableCtrl">
									<tr>
										<td><label class="i-checks m-b-none"> <input
												type="checkbox" ng-model="row.select" ng-click="calAmt(purchaseInvoiceData.purchaseInvoiceDetail)"><i></i></label></td>

										<td>
										    <div class="row">
												<div class="col-xs-12">
													<selectivity list="chargeHeadList"
											property="row.chargeHeadId" id="chargeHeadId{{trIndex}}"
											ng-model="row.chargeHeadId"
											name="chargeHeadId{{trIndex}}" disabled="true"></selectivity>
												</div>
											</div></td>
												
										<td>
											<div class="row">
												<div class="col-xs-12">
													<selectivity list="UnitList"
											property="row.unitId" id="row.unitId"
											ng-model="row.unitId" name="unit{{trIndex}}"
											disabled="true"></selectivity>
												</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="qty{{trIndex}}" ng-model="row.qty"
														name="qty" 
														friendly-name="{{ 'Row' + $index + '(QTY)'}}" disabled>
												</div>
											</div>
										</td>
												<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="rate{{trIndex}}" ng-model="row.rate"
														name="rate" 
														friendly-name="{{ 'Row' + $index + '(Rate)'}}" disabled>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<selectivity list="currencylist"
											property="row.currencyId" id="currencyId{{trIndex}}"
											ng-model="row.currencyId" name="currencyId{{trIndex}}" disabled="true"></selectivity>
												</div>
											</div>
										</td>

										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"
														name="exchangeRate" 
														friendly-name="{{ 'Row' + $index + '(Exchange Rate)'}}" disabled>
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
													<button  type="button" ng-click="showTax(row.chargeHeadId,row.jobNo,purchaseInvoiceData.partyNo)">View
												    </button>
												</div>
											</div>
										</td>
								<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="taxPrct{{trIndex}}" ng-model="row.taxPrct"
														name="taxPrct" ng-keyup="calculateTaxAmt(row.taxPrct,row,purchaseInvoiceData.purchaseInvoiceDetail)"
														friendly-name="{{ 'Row' + $index + '(Tax Prct)'}}" >
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


								</tbody>
							</table>
							<div class="padding-right-5">
								<div class="col-md-4">
									<!-- <button
										ng-click="addRow(purchaseInvoiceData.purchaseInvoiceDetail)"
										class="btn btn-sm btn-info" tooltip="Add Row" type="button">
										<i class="fa fa-plus"></i>
									</button>
									<button
										ng-click="removeRow(purchaseInvoiceData.purchaseInvoiceDetail)"
										class="btn btn-sm btn-danger" type="button" tooltip="Delete">
										<i class="fa  fa-trash-o"></i>
									</button> -->
								</div>
								<div class="col-md-8" >
									<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total Invoice Amount</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="purchaseInvoiceData.totalAmount" readonly name="BC Total"
												placeholder="0.0">
										</div>

									</div>
									<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total Tax Amount</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="purchaseInvoiceData.totaltaxAmount" readonly name="BC Total"
												placeholder="0.0">
										</div>

									</div>
									<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total Amount</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="purchaseInvoiceData.invoiceAmount" readonly name="BC Total"
												placeholder="0.0">
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
													<!-- <button  class="btn btn-success"  type="button"
														 class="btn btn-success"
														ng-click="onSubmit(purchaseInvoiceForm,purchaseInvoiceData)">
														<i class="fa fa-save"></i> Save
													</button> -->
													
	                                                <button  class="btn btn-success" type="button" 
														 class="btn btn-success" ng-click="onSubmitDraft(purchaseInvoiceForm,purchaseInvoiceData)">
														<i class="fa fa-save"></i> Save as Draft
													</button>
													<button class="btn btn-danger" type="reset"
														class="btn btn-success" ng-click="cancel()">
														<i class="fa fa-close"></i> Back
													</button>
													<button class="btn btn-success" ng-if="!edit" type="button"
														ng-click="printUsdForm(purchaseInvoiceForm,purchaseInvoiceData)">
														<i class="fa fa-print"></i> Print Preview USD
													</button>
													<!-- <button class="btn btn-success" ng-if="!edit" type="button"
														ng-click="printSgdForm(purchaseInvoiceForm,purchaseInvoiceData)">
														<i class="fa fa-print"></i> Print Preview SGD
													</button> -->
													<button class="btn btn-success" ng-if="!edit" type="button"
														ng-click="printInrForm(purchaseInvoiceForm,purchaseInvoiceData)">
														<i class="fa fa-print"></i> Print Preview INR
													</button>
												</div>
											</div>
										</div>
										<!-- /form-actions -->
									</div>
								</div>
							</div>
						</div>
						<!-- /table-responsive -->
					</form>
				</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel-default -->
		</div>
	</div>
</div>