<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%> --%>

<div class="row  m-n">
  <div class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold">
		<ol class="breadcrumb inline-block padding-left-10">
    <li>
      <a style="color: black;">Finance</a>
    </li>
    <li>
      <a style="color: black;">Invoice</a>
    </li>
    <li>
     <a style="color: black;">Freight Invoice</a>
    </li>
    <li>
     <a style="color: black;">View</a>
    </li>
   </ol>
   </div>
   </div>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="invoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Invoice No.</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label"><b>{{invoiceData.invoiceNo}}</b></label>
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">BL No.</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{invoiceData.blNo}}</label>
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
											disabled friendly-name="Bill Date" />
									</div>
								</div>
							</div>
							
							
							
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.customerName}}</label>
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking No. </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.bookingNo}}</label>
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel/Voyage</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{invoiceData.voyageName}}</label>
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
								<a
									href="#/mbk/seaQuotation/view?QuotHdId={{invoiceData.quotationNo}}" target="_blank">
											<label class="control-label"><span tooltip="{{invoiceData.quotation}}"
										class="tool-tip-span font-blue" 
										ng-bind="invoiceData.quotation"></span></label>
								</a>
									
								
									</div>
								</div>
							</div>
						
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Port </label>
									<div class="col-md-7">
									<label class="col-md-5 control-label">{{invoiceData.pol}}</label>
										
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Freight Term </label>
									<div class="col-md-7">
									<label class="col-md-5 control-label">{{invoiceData.freightTypeName}}</label>
										
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
										<label class="control-label">{{invoiceData.agentNameview}}</label>
									</div>
								</div>
							</div>
									<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Created By</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.createdBy}}</label>
									</div>
								</div>
							</div>
									<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Created Date</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.createddt}}</label>
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
								<th colspan=1 class="width_10 text-center">Curr</th>
								<th colspan=1 class="width_10 text-center">Rate/unit</th>
								<th colspan=1 class="width_10 text-center">Ex.Rt</th>
								<th colspan=1 class="width_10 text-center">Amount ({{invoiceData.currency}})</th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in invoiceData.chargesDetails track by trIndex">
							<tr>
								<td></td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.containerNo}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.containerTypeName}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.chargeTypeName}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.quantity}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.currency}}</label>
										</div>
									</div>
								</td>
								
								
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.rate}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.exchangeRate}}</label>
										</div>
									</div>
								</td>
								
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12" ng-if="row1.exchangeRate >0 && row1.exchangeRate !=null">
											<label class="control-label">{{row1.tcAmount}}</label>
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
						<div class="col-md-4">
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5">Total Amount ({{invoiceData.currency}})
								</label>
								<div class="col-md-7">
<!-- 									<label class="control-label">{{subtotal}}</label> -->
																		<input type="text" class="form-control input-sm text-right"
																			data-ng-model="invoiceData.grandTotal" id="total" name="total"
																			disabled />
								</div>
							</div>
						</div>
<!-- 						<div class="col-md-4"> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label class="col-md-5 control-label">Grand Total </label> -->
<!-- 								<div class="col-md-7"> -->
<!-- 									<label class="control-label">{{subtotal}}</label> -->
<!-- 																		<input type="text" class="form-control input-sm text-right" -->
<!-- 																			ng-model="invoiceData.grandTotal" disabled name=" grandTotal" -->
<!-- 																			id="grandTotal" /> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</fieldset>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<button class="btn btn-success" type="button"
						ng-click="printInvoice()">
						<i class="fa fa-print"></i> Print
					</button>
					<button class="btn btn-danger" ng-click="cancel()" type="button">
						<i class="fa fa-close"></i> Cancel
					</button>
				</div>
			</div>
		</div>
	</div>
</div>