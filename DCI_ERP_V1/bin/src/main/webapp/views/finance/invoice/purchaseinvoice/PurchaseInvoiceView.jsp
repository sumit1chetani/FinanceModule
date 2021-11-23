<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="breadcrumb-wrapper ng-scope">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<div style="width: 30%;position: absolute;margin-top: -33px;margin-left: 78%;">
				<label style="color:#e25d5d;float: left;">Quick Links &nbsp;&nbsp; </label>
				  <select ng-change="quickLinkMethd(qukLinkVal)" style=" width: 100px;" ng-init="qukLinkVal='Select'" ng-model="qukLinkVal">
				 <option value="Select">Select</option>
				  <option value="Job Order">Job Order</option>
				  <option value="HAWB">HAWB</option>
				  <option value="MAWB">MAWB</option>
				  <option value="Delivery Order">Delivery Order</option>
		  		  <option value="Sales Invoice">Sales Invoice</option>
				</select>
				</div>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="purchaseInvoiceForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
								<label class="col-md-5 control-label ">JobOrder No: </label> 
								<div class="col-md-7"> 
								<label class=""><a data-ng-click="viewQuotation(purchaseInvoiceData.jbid)">  <span class="tool-tip-span font-blue"> {{purchaseInvoiceData.jobNo}}</span></a></label> 
								</div>
								</div>
									<div class="form-group ">
									<label class="col-md-5 control-label">Purchase Invoice
										No <span style="color: red"></span>
									</label>
									<div class="col-md-7">
									<input type="text" class="form-control" name="purchaseInvoiceNo"
												ng-model="purchaseInvoiceData.purchaseInvoiceNo" disabled> </>
										
									</div>
								</div>
									
									<div class="form-group">
										<label class="col-md-5 control-label"> Customer <span
											style="color: red;"></span>
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control" name="Customer"
												ng-model="purchaseInvoiceData.customer" disabled> </>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> AOL <span
											style="color: red;"></span>
										</label>
									
										<div class="col-md-7">
											<input type="text" class="form-control" name="aol"
												ng-model="purchaseInvoiceData.aolName" disabled> </>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Origin </label>
									
										<div class="col-md-7">
											<input type="text" class="form-control" name="Origin"
												ng-model="purchaseInvoiceData.origin" disabled> </>
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Flight
											No </label>

										<div class="col-md-7">
											<input type="text" class="form-control" name="flightNo"
												ng-model="purchaseInvoiceData.flightNo" disabled> </>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label">Arrival Date</label>

										<div class="col-md-7">
											<ng-bs3-datepicker ng-model="purchaseInvoiceData.arrivalDate"
												id="arrival" name="arrivalDate"
												form-name="purchaseInvoiceForm" disabled />
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
												friendly-name="PurchaseInvoice Date" validation="required" disabled/>

										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">Reference
											No <span style="color: red;"></span>
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
												ng-model="purchaseInvoiceData.reference" disabled> </>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-md-5 control-label"> AOD <span
											style="color: red;"></span>
										</label>
									
										<div class="col-md-7">
											<input type="text" class="form-control" name="aod"
												ng-model="purchaseInvoiceData.aodName" disabled> </>
										</div>
										
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Destination </label>
									
										<div class="col-md-7">
											<input type="text" class="form-control" name="destination"
												ng-model="purchaseInvoiceData.destination" disabled> </>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label">Flight Date</label>

										<div class="col-md-7">
											<ng-bs3-datepicker ng-model="purchaseInvoiceData.flightDate"
												id="flight" name="flightDate"
												form-name="purchaseInvoiceForm" disabled />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label">Departure Date</label>

										<div class="col-md-7">
											<ng-bs3-datepicker
												ng-model="purchaseInvoiceData.depatureDate"
												id="departure" name="departureDate"
												form-name="purchaseInvoiceForm" disabled/>
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
									<label class="col-md-5 control-label">Show Consignee </label>
									<div class="col-md-7">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												class="checkbox style-0" name="consignee"
												ng-model="purchaseInvoiceData.consignee" ng-true-value="true"
												ng-false-value="false" disabled> <i></i>
											</label>
										</div>
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
								<!-- <div class="form-group">
										<label class="col-md-5 control-label"> HAWB No </label>
										
										<div class="col-md-7">
											<input type="text" class="form-control" name="hawb"
												ng-model="purchaseInvoiceData.hawbNo" disabled> </>
										</div>
									</div>  -->
								<!--  <div class="form-group">
									<label class="col-md-5 control-label"> MAWB No </label>
									
									<div class="col-md-7">
											<input type="text" class="form-control" name="mawb"
												ng-model="purchaseInvoiceData.mawbNo" disabled> </>
										</div>
								</div>  -->
								<div class="form-group">
										<label class="col-md-5 control-label">Vendor Invoice Date</label>

										<div class="col-md-7">
											<ng-bs3-datepicker
												ng-model="purchaseInvoiceData.vendorInvoiceDate"
												id="departure" name="vendorInvoiceDate"
												form-name="purchaseInvoiceForm" disabled/>
										</div>
									</div>

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
														id="accountHeadCode{{trIndex}}" ng-model="row.accountHeadCode" name="accountHeadCode"
													 disabled>
												</div>
											</div>
										
												</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="unit{{trIndex}}" ng-model="row.unitName" name="unit"
														validation="required"
														friendly-name="{{ 'Row' + $index + '(Unit)'}}" disabled>
												</div>
											</div>
										</td>

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
														id="currency{{trIndex}}" ng-model="row.currency" name="currency"
														validation="required"
														friendly-name="{{ 'Row' + $index + '(currency)'}}" disabled>
												</div>

											</div>
										</td>

										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate" name="exchangeRate"
														validation="required"
														friendly-name="{{ 'Row' + $index + '(exchangeRate)'}}" disabled>
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
														friendly-name="{{ 'Row' + $index + '(Tax Amount)'}}" disabled>
												</div>
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
										<label class="col-md-6 control-label"> Total Amount</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="purchaseInvoiceData.invoiceAmount" readonly name="BC Total"
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
													ng-if="purchaseTable==false" ng-click="cancel()">
													<i class="fa fa-close"></i> Back
												</button>
												 <security:authorize access="hasRole('F5589_${print}')">
												<button class="btn btn-success" ng-if="purchaseTable==false"
													ng-click="printPurchaseInvoice(purchaseInvoiceData.purchaseInvoiceSno)">
													<i class="fa fa-print"></i> Print USD
												</button>
												</security:authorize>
												<%-- <security:authorize access="hasRole('F5589_${print}')">
												<button class="btn btn-success" ng-if="purchaseTable==false"
													ng-click="printPurchaseInvoiceSgd(purchaseInvoiceData.purchaseInvoiceSno)">
													<i class="fa fa-print"></i> Print SGD
												</button>
												</security:authorize> --%>
												<security:authorize access="hasRole('F5589_${print}')">
												<button class="btn btn-success" ng-if="purchaseTable==false"
													ng-click="printPurchaseInvoicelocal(purchaseInvoiceData.purchaseInvoiceSno)">
													<i class="fa fa-print"></i>Print INR
												</button>
												</security:authorize>
												<button class="btn btn-danger" ng-if="purchaseTable==true" type="button"
													ng-click="cancel1()">
													<i class="fa fa-close"></i> Cancel
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