<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<div style="width: 30%;position: absolute;margin-top: -33px;margin-left: 78%;">
				<label style="color:#e25d5d;float: left;">Quick Links &nbsp;&nbsp; </label>
				  <select ng-change="quickLinkMethd(qukLinkVal)" style=" width: 100px;" ng-init="qukLinkVal='Select'" ng-model="qukLinkVal">
				 <option value="Select">Select</option>
				  <option value="Job Order">Job Order</option>
				  <option value="HBL">HBL</option>
				  <option value="MBL">MBL</option>
				  <option value="Sales Invoice">Sales Invoice</option>
		  		  <option value="Purchase Invoice">Purchase Invoice</option>
				</select>
				</div>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="purchaseInvoiceForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Job No <span
											style="color: red;"></span>
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control" name="JobNo"
												ng-model="purchaseInvoiceData.jobNo" disabled> </>
										</div>

									</div>
									<div class="form-group " >
									<label class="col-md-5 control-label">Sales Invoice
										No <span style="color: red"></span>
									</label>
									<div class="col-md-7" >
									<input type="text" class="form-control" name="JobNo"
												ng-model="purchaseInvoiceData.purchaseInvoiceNo" disabled> </>
										
									</div>
								</div>
								<!-- <div class="form-group">
									<label class="col-md-5 control-label"> MBL No </label>

									<div class="col-md-7">
										<input type="text" class="form-control" name="mbl"
											ng-model="purchaseInvoiceData.mbl" disabled> </>
									</div>
								</div> -->
								<div class="form-group">
										<label class="col-md-5 control-label"> Origin </label>

										<div class="col-md-7">
											<input type="text" class="form-control" name="Origin"
												ng-model="purchaseInvoiceData.origin" disabled> </>
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-5 control-label">Sailed Date</label>

										<div class="col-md-7">
											<ng-bs3-datepicker ng-model="purchaseInvoiceData.sailedDate"
												id="sailed" name="sailedDate"
												form-name="purchaseInvoiceForm" disabled />
										</div>
									</div>
								 <div class="form-group">
									<label class="col-md-5 control-label">Show Container </label>
									<div class="col-md-7">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												class="checkbox style-0" name="container"
												ng-model="purchaseInvoiceData.container"
												ng-true-value="true" ng-false-value="false" disabled>
												<i></i>
											</label>
										</div>
									</div>
								</div>
								
								
									
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Remarks</label>
										<div class="col-md-7">
											<textarea rows="2" cols="4"
												class="form-control resize-vertical" name="remarks"
												ng-model="purchaseInvoiceData.remarks" disabled>
           									</textarea>
										</div>
									</div>
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Party <span
											style="color: red;"></span>
										</label>
										<!-- <div class="col-md-7">
											<input type="text" class="form-control input-sm" ng-model="purchaseInvoiceData.partyInvoiceNo"
											name="Party Invoice No" validation="required" friendly-name="Party Invoice No" ng-blur="checkPartyInv(purchaseInvoiceData.partyInvoiceNo)">
										</div> -->

										<div class="col-md-7">
											<input type="text" class="form-control" name="Party"
												ng-model="purchaseInvoiceData.party" disabled> </>
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Invoice
											Date <span style="color: red;"></span>
										</label>
										<div class="col-md-7">
											<ng-bs3-datepicker
												ng-model="purchaseInvoiceData.purchaseInvoiceDate"
												id="puchaseInvoiceDate" name="puchaseInvoiceDate"
												form-name="purchaseInvoiceForm"
												data-ng-change="checkDatesCL(purchaseInvoiceData.puchaseInvoiceDate)"
												friendly-name="PurchaseInvoice Date" validation="required"
												disabled />

										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> POL <span
											style="color: red;"></span>
										</label>

										<div class="col-md-7">
											<input type="text" class="form-control" name="pol"
												ng-model="purchaseInvoiceData.polName" disabled> </>
										</div>
									</div>
									
									
									<div class="form-group">
										<label class="col-md-5 control-label"> Destination </label>

										<div class="col-md-7">
											<input type="text" class="form-control" name="destination"
												ng-model="purchaseInvoiceData.destination" disabled>
											</>
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-5 control-label">Arrival Date</label>

										<div class="col-md-7">
											<ng-bs3-datepicker
												ng-model="purchaseInvoiceData.arrivalDate" id="arrival"
												name="arrivalDate" form-name="purchaseInvoiceForm"
												disabled />
										</div>
									</div>
									
									<div class="form-group">
									<label class="col-md-5 control-label">Show Shipper </label>
									<div class="col-md-7">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												class="checkbox style-0" name="shipper"
												ng-model="purchaseInvoiceData.shipper" ng-true-value="true"
												ng-false-value="false" disabled> <i></i>
											</label>
										</div>
									</div>
								</div>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Narration</label>
										<div class="col-md-7">
											<textarea rows="2" cols="4"
												class="form-control resize-vertical" name="narration"
												ng-model="purchaseInvoiceData.narration" disabled>
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
								<div class="form-group" style="padding-bottom: 28px">
									<label class="col-md-5 control-label"> 
									</label>
									<div class="col-md-7">
										
									</div>
								</div>
                                <!-- <div class="form-group">
										<label class="col-md-5 control-label"> HBL No </label>

										<div class="col-md-7">
											<input type="text" class="form-control" name="hbl"
												ng-model="purchaseInvoiceData.hbl" disabled> </>
										</div>
									</div> -->
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Due
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<ng-bs3-datepicker
												data-ng-model="purchaseInvoiceData.dueDate1"
												id="dueDate1" name="dueDate1"
												form-name="purchaseInvoiceForm"
												friendly-name="Due Date"  />

										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> POD <span
											style="color: red;"></span>
										</label>

										<div class="col-md-7">
											<input type="text" class="form-control" name="pod"
												ng-model="purchaseInvoiceData.podName" disabled> </>
										</div>

									</div>
								<div class="form-group">
									<label class="col-md-5 control-label"> Vessel/Voyage <span
										style="color: red;"></span>
									</label>

									<div class="col-md-7">
										<input type="text" class="form-control" name="vessel"
											ng-model="purchaseInvoiceData.vessel" disabled> </>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label"> Bank <span
										style="color: red;"></span>
									</label>

									<div class="col-md-7">
										<input type="text" class="form-control" name="bank"
											ng-model="purchaseInvoiceData.bank" disabled> </>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-5 control-label">Show Consignee </label>
									<div class="col-md-7">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												class="checkbox style-0" name="consignee"
												ng-model="purchaseInvoiceData.consignee"
												ng-true-value="true" ng-false-value="false" disabled>
												<i></i>
											</label>
										</div>
									</div>
								</div>
								
								<!-- <div class="form-group">
								<label class="col-md-5 control-label">Invoice</label>
								<div class="col-md-7">
									<selectivity list="invoiceList" name="Invoice Type"
										property="purchaseInvoiceData.invoiceType" ng-true-value="true"
										ng-model="purchaseInvoiceData.invoiceType" friendly-name="Invoice Type"
										></selectivity>
								</div>
							</div> -->
							</div>

						</div>
						<div class="table-responsive clear">
							<table class="table table-striped b-t b-light">
								<thead>
									<tr>

										<th colspan=1 class="width_13 text-center">Charge Heads<span
											style="color: red;"></span></th>

										<th colspan=1 class="width_8 text-center">Unit<span
											style="color: red;"></span></th>
											<th colspan=1 class="width_8 text-center">Container Type<span
											style="color: red;"></span></th>
											<th colspan=1 class="width_8 text-center">Commodity<span
											style="color: red;"></span></th>
										<th colspan=1 class="width_8 text-center">Qty<span
											style="color: red;"></span></th>
										<th colspan=1 class=" width_8 text-center">Rate<span
											style="color: red;"></span></th>
										<th colspan=1 class=" width_8 text-center">Currency<span
											style="color: red;"></span></th>
										<th colspan=1 class=" width_8 text-center">Ex-Rate<span
											style="color: red;"></span></th>
										<th colspan=1 class=" width_8 text-center">Amount<span
											style="color: red;"></span></th>

										<th colspan=1 class=" width_8 text-center">Tax Amount<span
											style="color: red;"></span></th>
<th colspan=1 class="width_8 text-center"><span
											style="color: red;"></span></th>

									</tr>
								</thead>
								<tbody
									ng-repeat="(trIndex, row) in purchaseInvoiceData.purchaseInvoiceDetail"
									ng-controller="purinvtableCtrl">
									<tr>

										<td>

											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="accountHeadCode{{trIndex}}"
														ng-model="row.accountHeadCode" name="accountHeadCode"
														disabled>
												</div>
											</div>

										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="unit{{trIndex}}" ng-model="row.unit" name="unit"
														validation="required"
														friendly-name="{{ 'Row' + $index + '(Unit)'}}" disabled>
												</div>
											</div>
										</td>
<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-left"
														id="conType{{trIndex}}" ng-model="row.conType" name="conType"
														validation="required"
														friendly-name="{{ 'Row' + $index + 'conType'}}" disabled>
												</div>
											</div>
										</td>
										<td>
										    <div class="row">
												<div class="col-xs-12">
													<selectivity list="commodityList"
											property="row.commodity" id="commodity{{trIndex}}"
											ng-model="row.commodity"
											name="commodity{{trIndex}}" disabled="true"></selectivity>
												</div>
											</div></td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="qty{{trIndex}}" ng-model="row.qty" name="qty"
														validation="required"
														friendly-name="{{ 'Row' + $index + '(QTY)'}}" disabled>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="rate{{trIndex}}" ng-model="row.rate" name="rate"
														validation="required"
														friendly-name="{{ 'Row' + $index + '(Rate)'}}" disabled>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="currency{{trIndex}}" ng-model="row.currency"
														name="currency" validation="required"
														friendly-name="{{ 'Row' + $index + '(currency)'}}"
														disabled>
												</div>

											</div>
										</td>

										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"
														name="exchangeRate" validation="required"
														friendly-name="{{ 'Row' + $index + '(exchangeRate)'}}"
														disabled>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="amount{{trIndex}}" ng-model="row.amount" name="amount"
														validation="required"
														friendly-name="{{ 'Row' + $index + '(Amount)'}}" disabled>
												</div>
											</div>
										</td>

										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="taxAmount{{trIndex}}" ng-model="row.taxAmount"
														name="taxAmount" validation="required"
														friendly-name="{{ 'Row' + $index + '(Tax Amount)'}}"
														disabled>
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<span>{{row.taxExemption}}</span></div>
											</div>
										</td>
									</tr>


								</tbody>
							</table>


							<div class="col-md-12">
								<div class="form-group" style="float: right;">
									<label class="col-md-6 control-label">Total Invoice Amount</label>

									<div class="col-md-6">
										<input type="text" class="form-control input-sm text-right"
											ng-model="purchaseInvoiceData.totalAmount" readonly
											name="totalAmount" placeholder="0.0">
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
												ng-model="purchaseInvoiceData.invoiceAmount" readonly 
												placeholder="0.0">
										</div>

									</div>
							</div>
<div class="col-md-12" >
								
									<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Grand Total</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="purchaseInvoiceData.grandTotal" readonly name="BC Total"
												placeholder="0.0">
										</div>

									</div>
									<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Round Off Total </label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="purchaseInvoiceData.roundOff" readonly name="BC Total"
												placeholder="0.0">
										</div>

									</div>
								</div> 

							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="content">
										<div class="form-actions">
											<div class="row">
												<button class="btn btn-danger" class="btn btn-success" type="button"
													ng-click="cancel()">
													<i class="fa fa-close"></i> Back
												</button>
												<security:authorize access="hasRole('F5580_${print}')">
												
												<button class="btn btn-success"
													ng-click="printPurchaseInvoice(purchaseInvoiceData.purchaseInvoiceSno)">
													<i class="fa fa-save"></i> Print Other Currency
												</button>
												</security:authorize>
												<security:authorize access="hasRole('F5580_${print}')">
												
												<!-- <button class="btn btn-success"
													ng-click="printPurchaseInvoiceSgd(purchaseInvoiceData.purchaseInvoiceSno)">
													<i class="fa fa-save"></i> Print SGD
												</button> -->
												</security:authorize>
<%-- 												<security:authorize access="hasRole('F5580_${print}')">
 --%><!-- 												ng-click="printPurchaseInvoicelocal(purchaseInvoiceData.purchaseInvoiceSno)"
 -->												
 <button class="btn btn-success"	ng-click="printPurchaseInvoicelocal(purchaseInvoiceData.purchaseInvoiceSno)"	>
													<i class="fa fa-save"></i> Print INR
												</button>
                                               <!-- <button class="btn btn-info" class="btn btn-success"
													 ng-click="deleteInvoice(purchaseInvoiceData.purchaseInvoiceSno)">
													<i class="fa fa-close"></i>Cancel Invoice
												</button> -->
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