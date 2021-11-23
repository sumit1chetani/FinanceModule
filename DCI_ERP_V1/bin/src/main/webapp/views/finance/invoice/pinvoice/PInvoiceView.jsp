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
			<form name="purchaseInvoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<input type="hidden" ng-model="purchaseinvoice.ExchangeRateFrom"
						id="ExchangeRateFrom" /> <input type="hidden"
						ng-model="purchaseinvoice.ExchangeRateTo" id="ExchangeRateTo" /> <input
						type="hidden" ng-model="purchaseinvoice.currencyValue"
						id="currencyValue" /> <input type="hidden"
						ng-model="purchaseinvoice.fraction" id="fraction" />

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Company</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="bank"
												ng-model="purchaseinvoice.branchName" disabled> 
											<!-- <input type="text" class="form-control" name="mawb"
												ng-model="purchaseinvoice.companyName" disabled> </> -->
										
									</div>
									
								</div>
							</div>
                            
							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Invoice
										Date
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="purchaseinvoice.invoiceDate"
											id="invoiceDate" name="invoiceDate"
											form-name="purchaseInvoiceForm"
											data-ng-change="checkDatesCL(purchaseinvoice.invoiceDate)"
											friendly-name="Invoice Date" validation="required" disabled/>
										
									</div>
								</div>
							</div>

							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Invoice No</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="invoiceNo"
												ng-model="purchaseinvoice.invoiceNo" disabled> </>
									</div>
									
								</div>
							</div>
						</fieldset>
					</div>

					
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Supplier</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="customer"
												ng-model="purchaseinvoice.customerName" disabled> 
                                	</div>
								</div>
							</div>


							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Party Invoice no. 
									</label>
									<div class="col-md-7">
									<input type="text" class="form-control input-sm" ng-model="purchaseinvoice.partyInvNo"
										name="Party Invoice No." disabled>
										<!-- <input type="text" class="form-control" name="bank"
												ng-model="purchaseinvoice.bank" disabled>  -->
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Currency</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="currencyHdr"
												ng-model="purchaseinvoice.currencyName" disabled>
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
											ng-model="purchaseinvoice.remarks" disabled>
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
										ng-model="purchaseinvoice.narration" disabled>
           									</textarea>
           									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Ex-Rate <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
									<input type="text" class="form-control input-sm" ng-model="purchaseinvoice.exchangeRate" 
										name="exchangeRate"  friendly-name="Ex-Rate" disabled>
										
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vendor Invoice Date <span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
									<input type="text" class="form-control input-sm" ng-model="purchaseinvoice.vendorInvoiceDate" 
										name="vendorInvoiceDate"  friendly-name="Ex-Rate" disabled>
										
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
										<th colspan=1 class="width_12 text-center">Company</th> 
										<th colspan=1 class="width_13 text-center">Acct Heads</th> 
										<th colspan=1 class="width_8 text-center">SAC No</th>
										<th colspan=1 class=" width_8 text-center">Currency<span style="color: red;"></span></th>
										<th colspan=1 class=" width_8 text-center">Ex-Rate<span style="color: red;"></span></th>
										<th colspan=1 class=" width_8 text-center">TC Amount <span style="color: red;"></span></th>
										<th colspan=1 class=" width_8 text-center">BC Amount <span style="color: red;"></span></th>
										
									   
							</tr>
						</thead>

						<tbody ng-repeat="(trIndex, row) in purchaseinvoice.gidtl" ng-controller="GItableCtrl">
							<tr>
										
										<td>
										    <div class="row">
												<div class="col-xs-12">        
											  <input type="text" class="form-control" name="company{{trIndex}}"
												ng-model="row.company" disabled>
												</div>
											</div></td>
										<td>
										    <div class="row">
												<div class="col-xs-12">        
											  <input type="text" class="form-control" name="chargeHead{{trIndex}}"
												ng-model="row.chargeHeadName" disabled>
												</div>
											</div></td>
											<td>
											<div class="row">
												<div class="col-xs-9" ng-if="row.sacNo!=0">
											               <input type="text" class="form-control" name="sacNo{{trIndex}}"
												ng-model="row.sacNo" disabled>
												</div>
												<div class="col-xs-9" ng-if="row.sacNo==0">
											               <input type="text" class="form-control" name="sacNo{{trIndex}}"
												 disabled>
												</div>
												<div class="col-xs-3 pull-left" ng-if="row.checked">
												<label class="line-height-30 cursor-pointer"
													
													data-ng-click="showContainerPopupView(trIndex,row)">
													<i class="fa fa-expand"></i>
												</label>
											</div>
											</div>
										</td>	
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="amount{{trIndex}}" ng-model="row.currencyName"
														name="amount" 
														friendly-name="{{ 'Row' + $index + '(Amount)'}}" disabled>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"
														name="exchangeRate"  disabled>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="rate{{trIndex}}" ng-model="row.rate"
														name="rate"  disabled>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="amount{{trIndex}}" ng-model="row.amount1"
														name="amount" disabled>
												</div>
											</div>
										</td>
								
										<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="taxAmount{{trIndex}}" ng-model="row.taxAmount"
														name="taxAmount" 
														friendly-name="{{ 'Row' + $index + '(Tax Amount)'}}" disabled>
												</div>
											</div>
										</td> -->
									</tr>
									
									
									<tr ng-hide="igst">

										<td style="text-align: right;">
										    <!-- <div class="row">
												<div class="col-xs-12"> -->
													{{row.igstsh}}
												<!-- </div>
											</div> -->
											</td>
											<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="igstnam{{trIndex}}" ng-model="row.igstnam"
														name="igstnam" disabled>
												</div>
											</div>
										</td>	 -->
										<td style="text-align: right;">
											<!-- <div class="row">
												<div class="col-xs-12"> -->
												{{row.igstper}}
													<!-- <input type="text" class="form-control input-sm text-right"
														id="igstper{{trIndex}}" ng-model="row.igstper"
														 form-name="purchaseInvoiceForm" disabled> -->
												<!-- </div>
											</div> -->
										</td>
								
										<td style="text-align: right;">
											<!-- <div class="row">
												<div class="col-xs-12"> -->
												{{row.igstamt1}}
												<!-- </div>
											</div> -->
										</td>

									</tr>
									
									<!-- CGST -->
									<tr ng-hide="cgst">

										<td style="text-align: right;">
										    <!-- <div class="row">
												<div class="col-xs-12"> -->
													{{row.cgstsh}}
												<!-- </div>
											</div> -->
											</td>
											<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="cgstnam{{trIndex}}" ng-model="row.cgstnam"
														name="igstnam" disabled>
												</div>
											</div>
										</td> -->	
										<td style="text-align: right;">
											<!-- <div class="row">
												<div class="col-xs-12"> -->
												{{row.cgstper}}
													<!-- <input type="text" class="form-control input-sm text-right"
														id="cgstper{{trIndex}}" ng-model="row.cgstper"
														 form-name="purchaseInvoiceForm" disabled> -->
												<!-- </div>
											</div> -->
										</td>
								
										<td style="text-align: right;">
											<!-- <div class="row">
												<div class="col-xs-12"> -->
												{{row.cgstamt1}}
												<!-- </div>
											</div> -->
										</td>

									</tr>
									
									<!-- SGST -->
									<tr ng-hide="sgst">

										<td style="text-align: right;">
										    <!-- <div class="row">
												<div class="col-xs-12"> -->
													{{row.sgstsh}}
												<!-- </div>
											</div> -->
											</td>
											<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="sgstnam{{trIndex}}" ng-model="row.sgstnam"
														name="sgstnam" disabled>
												</div>
											</div>
										</td>	 -->
										<td style="text-align: right;">
										<!-- 	<div class="row">
												<div class="col-xs-12"> -->
												{{row.sgstper}}
													<!-- <input type="text" class="form-control input-sm text-right"
														id="sgstper{{trIndex}}" ng-model="row.sgstper"
														 form-name="purchaseInvoiceForm" disabled> -->
												<!-- </div>
											</div> -->
										</td>
								
										<td style="text-align: right;">
											<!-- <div class="row">
												<div class="col-xs-12"> -->
												{{row.sgstamt1}}
												<!-- </div>
											</div> -->
										</td>

									</tr>
									
									
									

						</tbody>

					</table>

					<div class="col-md-12">
									<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total </label>

										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="purchaseinvoice.totalAmount1" readonly
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
								ng-click="printGeneralPurchaseInvoiceDiv(purchaseinvoice.invoiceNo)"
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
