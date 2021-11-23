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
			<form name="invoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					

					<div class="col-sm-12">
						<fieldset>

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
								<label class="col-md-5 control-label">Consignee Name</label>
									<div class="col-md-7">
							 <!-- <input class="form-control" type="text" placeholder="" class="form-control input-sm" id="consigName"
								friendly-name="Consignee Name" ng-model="invoiceData.consigName" name="consigName" form-name="blForm" 
								
								typeahead="ac.text as ac.text for ac in consigneeList| filter:$viewValue |limitTo:50 "
							    typeahead-min-length='1'
								typeahead-input-formatter="fetchSelectedConsigneeName($model,invoiceData)"
								validation="required" 
								> -->
								
								<selectivity list="consigneeList"
											ng-model="invoiceData.consigneeCode" friendly-name="Consignee Name"
											property="invoiceData.consigneeCode" id="consigName" disabled="value"
											name="consigName" form-name="blForm"></selectivity>
											
													<div>
								<button ng-click="consigneeAdd()" class="btn btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus " aria-hidden="true"></i>
								</button>
							</div>
									</div>
									
								</div>
							</div>
								
							


						</fieldset>
					</div>
 <div class="col-sm-12">
						<fieldset>

							<div class="col-md-4" ng-if="invoiceData.invLocation=='IN'">
<div class="form-group">
<label class="col-md-5 control-label">HBL #</label>
<div class="col-md-7">

<input type="text" class="form-control input-sm text-right"
ng-model="invoiceData.hbl"
name=" hbl" id="hbl"
friendly-name="hbl" />
</div>
</div>
</div>
		

							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5"></label>
									<div class="col-md-7">
										

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
								<label class="col-md-5 control-label"></label>
									<div class="col-md-7">
							 <!-- <input class="form-control" type="text" placeholder="" class="form-control input-sm" id="consigName"
								friendly-name="Consignee Name" ng-model="invoiceData.consigName" name="consigName" form-name="blForm" 
								
								typeahead="ac.text as ac.text for ac in consigneeList| filter:$viewValue |limitTo:50 "
							    typeahead-min-length='1'
								typeahead-input-formatter="fetchSelectedConsigneeName($model,invoiceData)"
								validation="required" 
								> -->
								
											
													<div>
								
							</div>
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
									<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Port </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.pod" disabled name="pod"
											id="pol" friendly-name="pod" />
									</div>
								</div>
							</div>
							
								<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer Tax Number</label>
									<div class="col-md-7">
									
										<input type="text" class="form-control input-sm text-right"
											ng-model="invoiceData.custaxnum" 
											name=" custaxnum" id="custaxnum"
											friendly-name="custaxnum"   />
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Consignee Details <span style="color: red;">*</span> </label>
									<div class="col-md-7">
									
									<textarea  type="text" class="form-control input-sm"
															name="consignee" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="invoiceData.consignee" disabled>
															</textarea>
															
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
<!-- 										<label class="control-label">{{invoiceData.quotation}}</label> -->
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
									<label class="col-md-5 control-label">Agent Name</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.agentName}}</label>
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
							
							<div class="col-md-4"  ng-if="details">
								<div class="form-group">
									<label class="col-md-5 control-label">De-Stuffing Type </label>
									<div class="col-md-7">
								<selectivity list="checktypeList" property="invoiceData.stufftype" 
												ng-model="invoiceData.stufftype" id="test" object="stufftype"></selectivity>
									
									
									</div>
								</div>
							</div> 
						</fieldset>
					</div>
				</div>

				<div class="table-responsive clear">
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
								<th colspan=1 class="width_13 text-center">Type Of Charge</th>
								<th colspan=1 class="width_10 text-center">Quantity</th>
										<th colspan=1 class="width_10 text-center">Currency</th>
								<th colspan=1 class="width_10 text-center">Rate</th>
										<th colspan=1 class="width_10 text-center">Ex.Rate</th>
								<th colspan=1 class="width_10 text-center">Amount</th>
								<th colspan=1 class="width_10 text-center">Amount({{invoiceData.currency}})</th>
				
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in invoiceData.chargesDetails track by trIndex">
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
					<!-- /padding-right-5 - /AddOrRmvebtn -->
				</div>
				<div class="col-sm-12">
					<fieldset>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"> </label>
								<div class="col-md-7"></div>
							</div>
						</div>


<!-- 						<div class="col-md-4"> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="inputPassword" class="control-label col-md-5">Total Amount-USD -->
<!-- 								</label> -->
<!-- 								<div class="col-md-7"> -->
<!-- 									<input type="text" class="form-control input-sm text-right" -->
<!-- 										data-ng-model="invoiceData.total" id="total" name="total" -->
<!-- 										disabled /> -->

<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
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
				<!-- sub table Ends -->
			</form>
		</div>
		
 <div style="color: #0000FF	;font-weight: 900;float:left;">
  <p><span style="color:red;font-weight: bolder;">Note:</span></p>
 <p><span style="color:red;font-weight: bolder;">Additional Charges For Quote:</span>&nbsp;&nbsp;This will include the additional charge for all linked Bookings</p>
 <p><span style="color:red;font-weight: bolder;">Additional Charges For BL:</span>&nbsp;&nbsp;This will include  the additional charge only for the current Booking/BL</p>
 

							</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-12">
				
		
				 
				  <button class="btn btn-success" type="button"
					 ng-click="showaddchargespopup(invoiceData)">
						<i class="fa fa-plus" ></i> Additional Charges For Quote
					</button> 
				
					
				 <button class="btn btn-success" type="button"
					 ng-click="showaddchargesbookpopup(invoiceData)">
						<i class="fa fa-plus" ></i> Additional Charges For BL
					</button> 
				
				
				
				<button class="btn btn-success" type="button"
						ng-click="printpreviewInvoice(invoiceForm)">
						<i class="fa fa-print"></i> Print Preview
					</button>
					
					<button class="btn btn-success" type="button"
							id="invoicesave" ng-if="!invoiceData.isEdit" ng-click="save(invoiceForm)">
						<i class="fa fa-save"></i> Save
					</button>
					
					<button class="btn btn-danger" ng-click="cancel()" type="button">
						<i class="fa fa-close"></i> Cancel
					</button>
				</div>
			</div>
		</div>
	</div>
</div>
