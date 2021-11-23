<style>
.custom-col-md-6 {
	padding-right: 0px;
	padding-left: 0px;
}

.custom-col-md-3 {
	padding-right: 25px;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
									<label class="col-md-5 control-label">Company</label>
									<div class="col-md-7">
										
											<input type="text" class="form-control" name="mawb"
												ng-model="generalinvoice.companyName" disabled> </>
										
									</div>
									
								</div>
							</div>
                            
							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Invoice
										Date
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="generalinvoice.invoiceDate"
											id="invoiceDate" name="invoiceDate"
											form-name="generalInvoiceForm"
											data-ng-change="checkDatesCL(generalinvoice.invoiceDate)"
											friendly-name="Invoice Date" validation="required" disabled/>
										
									</div>
								</div>
							</div>

							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Invoice No</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="invoiceNo"
												ng-model="generalinvoice.invoiceNo" disabled> </>
									</div>
									
								</div>
							</div>
						</fieldset>
					</div>

					
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="customer"
												ng-model="generalinvoice.customerName" disabled> 
                                	</div>
								</div>
							</div>


							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Branch 
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="bank"
												ng-model="generalinvoice.bank" disabled> 
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Currency</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="currencyHdr"
												ng-model="generalinvoice.currencyName" disabled>
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
											ng-model="generalinvoice.remarks" disabled>
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
										ng-model="generalinvoice.narration" disabled>
           									</textarea>
           									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Bank</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="bankCode"
												ng-model="generalinvoice.bankCode" disabled>
                                	</div>
								</div>
							</div>
							
						</fieldset>
					</div>
					<!-- <div class="col-sm-12">
						<fieldset>
							
							<div class="col-md-4" ng-if="generalinvoice.mode==1 ">
								<div class="form-group">
									<label class="col-md-5 control-label">Job</label>
									<div class="col-md-7">
                                         <input type="text" class="form-control" name="jobOrderNo"
												ng-model="generalinvoice.jobOrder" disabled>

									</div>
								</div>
							</div>

                            <div class="col-md-4" ng-if="generalinvoice.mode==1">
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
							<div class="col-md-4" ng-if="generalinvoice.mode==1 ">
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
							
							<div class="col-md-4" ng-if="generalinvoice.mode==2 ">
								<div class="form-group">
									<label class="col-md-5 control-label">Job</label>
									<div class="col-md-7">
										
                                          <input type="text" class="form-control" name="airJobOrderNo"
												ng-model="generalinvoice.airJobOrder" disabled>

									</div>
								</div>
							</div>

                           <div class="col-md-4" ng-if="generalinvoice.mode==2">
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
							<div class="col-md-4" ng-if="generalinvoice.mode==2 ">
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
										<th colspan=1 class="width_13 text-center">Charge Heads</th> 
										<th colspan=1 class="width_8 text-center">SAC No</th>
										<th colspan=1 class="width_8 text-center">Unit</th>
										<th colspan=1 class="width_8 text-center">Qty</th>
										<th colspan=1 class=" width_8 text-center">Currency</th>
										<th colspan=1 class=" width_8 text-center">Ex-Rate</th>
										<th colspan=1 class=" width_8 text-center">Rate</th>
										<th colspan=1 class=" width_8 text-center">Amount</th>
									    <th colspan=1 class=" width_8 text-center">Tax Amount</th>
							</tr>
						</thead>

						<tbody ng-repeat="(trIndex, row) in generalinvoice.giDtl" ng-controller="GItableCtrl">
							<tr>
										

										<td>
										    <div class="row">
												<div class="col-xs-12">        
											  <input type="text" class="form-control" name="chargeHead{{trIndex}}"
												ng-model="row.chargeHeadName" disabled>
												</div>
											</div></td>
											<td>
											<div class="row">
												<div class="col-xs-12" ng-if="row.sacNo!=0">
											               <input type="text" class="form-control" name="sacNo{{trIndex}}"
												ng-model="row.sacNo" disabled>
												</div>
												<div class="col-xs-12" ng-if="row.sacNo==0">
											               <input type="text" class="form-control" name="sacNo{{trIndex}}"
												 disabled>
												</div>
											</div>
										</td>	
										<td>
											<div class="row">
												<div class="col-xs-12">
											               <input type="text" class="form-control" name="unit{{trIndex}}"
												ng-model="row.unit" disabled>
												</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="qty{{trIndex}}" ng-model="row.qty"
														name="qty" 
														friendly-name="{{ 'Row' + $index + '(QTY)'}}" disabled>
												</div>
											</div>
										</td>
												
										<td>
											<div class="row">
												<div class="col-xs-12">
										    <input type="text" class="form-control" name="currencyDtl{{trIndex}}"
												ng-model="row.currencyName" disabled>
												</div>
											</div>
										</td>

										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"
														name="exchangeRate" 
														friendly-name="{{ 'Row' + $index + '(Exchange Rate)'}}" disabled >
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
								
														<input type="text" class="form-control" name="rate{{trIndex}}"
												         ng-model="row.rate" disabled>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="amount{{trIndex}}" ng-model="row.amount1"
														name="amount" 
														friendly-name="{{ 'Row' + $index + '(Amount)'}}" disabled>
												</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="taxAmount{{trIndex}}" ng-model="row.taxAmount1"
														name="taxAmount" 
														friendly-name="{{ 'Row' + $index + '(Tax Amount)'}}" disabled>
												</div>
											</div>
										</td>
									</tr>

						</tbody>

					</table>

					<div class="col-md-12">
									<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total </label>

										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="generalinvoice.totalAmount1" readonly
												name="totalAmount" placeholder="0.0">
										</div>

									</div>
								</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" ng-if="generalInvoiceTable!=true"
								ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
							 <security:authorize access="hasRole('F0191_${print}')">
							<button class="btn btn-success" ng-if="generalInvoiceTable!=true"
								ng-click="printGeneralInvoiceDiv(generalinvoice.invoiceNo)"
								type="button">Print</button>
								</security:authorize>
							<button class="btn btn-danger" ng-if="generalInvoiceTable==true"
								ng-click="cancel1()" type="button">
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
