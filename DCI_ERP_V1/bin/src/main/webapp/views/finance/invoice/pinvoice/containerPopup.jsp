<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
			<div class="panel panel-default panel-default-form">
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
				<style>

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
    width: 85%; 
    position: absolute;
    top: 20%;
    left: 7%;
    margin: 0 auto;
}
</style>
				
					<form name="purchaseInvoiceForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<!-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Shipper <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="shipperDropList"
												ng-model="purchaseInvoiceData.shipper1"
												property="purchaseInvoiceData.shipper1" id="shipper1"
												object="shipper1" name="shipper1"
												friendly-name="shipper1" form-name="purchaseInvoiceForm"></selectivity>
										</div>

									</div>
									
									
								</fieldset>
							</div> -->
							
							

						</div>
						<div class="table-responsive clear" 
							class="bookingDtlCls">
							<table class="table table-striped b-t b-light">
								<thead>
									<tr>
									<th colspan="1" class="width_9 text-center">Select All <!-- <input ng-if="purchaseinvoice.checked"
												type="checkbox" ng-model="purchaseinvoice.selectBox1" ng-click="selectAll(purchaseinvoice.gidtl1)" disabled="true"> -->
												<input ng-if="!view"
												type="checkbox" ng-model="purchaseinvoice.selectBox1" ng-click="selectAll(purchaseinvoice.gidtl1)"></th>
<!-- <th colspan=1 class="width_1"><label class="i-checks m-b-none">Select All<input
												type="checkbox" ng-model="purchaseinvoice.selectBox1" ng-click="selectAll(purchaseinvoice.gidtl1)"><i></i></label></th> -->
										
										<th colspan="1" class="width_9 text-center">Container No<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_7 text-center">Size Type<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_12 text-center">Job Number<span style="color: red;"></span>
								</th><th colspan="1" class="width_12 text-center">Customer<span style="color: red;"></span>
								</th>
								<th colspan="1" class="width_7 text-center">Pol<span
									style="color: red;"></span></th>
							
								<th colspan="1" class="width_7 text-center">Pod<span
									style="color: red;"></span></th>
									<th colspan="1" class="width_7 text-center">Rate<span
									style="color: red;"></span></th>
								

									</tr>
								</thead>
								<tbody >
								<!-- <tbody
							ng-repeat="(trIndex1, jobOrderTrackingDtl) in jobOrderTrackingDtl1.gidtl1"
							class="bookingDtlCls" ng-controller="jobtableCtrl" > -->
							<tr ng-repeat="(trIndex, jobOrderTrackingDtl) in purchaseinvoiceNew.purchaseInvoiceDtlList" ng-controller="jobtableCtrl">
								<td ng-if="!jobOrderTrackingDtl.checked"><label class="i-checks m-b-none"> <input 
										type="checkbox" ng-model="jobOrderTrackingDtl.select1" > 
										<i></i></label></td>
										
										<td ng-if="jobOrderTrackingDtl.checked"><label class="i-checks m-b-none">
										<input 
										type="checkbox" ng-model="jobOrderTrackingDtl.select1"  disabled="true"> <i></i></label></td>
										
								<!--<td class="text-center">{{trIndex1+1}}</td>-->
								
								<td>
								
										<selectivity  list="containerNoList"
												property="jobOrderTrackingDtl.containerNo" id="containerNo{{trIndex}}"
												data-ng-model="jobOrderTrackingDtl.containerNo"
												name="containerNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerNo)'}}"
												form-name="jobOrderForm" disabled="true"></selectivity>
								</td>
                                <td class=""><selectivity list="sizeTypeList"
										property="jobOrderTrackingDtl.sizeType" id="sizeType"
										ng-model="jobOrderTrackingDtl.sizeType" name="sizeType{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(sizeType)'}}"
										form-name="jobOrderForm" disabled="true"></selectivity></td>
								
									

                              <td><input type="text"
									class="form-control input-sm text-right"
									id="jobNo{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.jobNo"
									name="jobNo{{trIndex1}}" disabled="true" ></td>
<td><selectivity list="customerList1"
										property="jobOrderTrackingDtl.customer" id="customer"
										ng-model="jobOrderTrackingDtl.customer" name="customer{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(customer)'}}"
										form-name="jobOrderForm" disabled="true"></selectivity></td>

								<td><selectivity list="portList"
										property="jobOrderTrackingDtl.pol" id="pol"
										ng-model="jobOrderTrackingDtl.pol" name="pol{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(pol)'}}"
										form-name="jobOrderForm" disabled="true"></selectivity></td>

								<td><selectivity list="portList"
										property="jobOrderTrackingDtl.pod" id="pod"
										ng-model="jobOrderTrackingDtl.pod" name="pod{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(pod)'}}"
										form-name="jobOrderForm" disabled="true"></selectivity></td>
									
								
								<td><input type="text"
									class="form-control input-sm text-right"
									id="amount{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.amount"
									name="amount{{trIndex1}}" disabled="true" ></td>
								<!--<td><textarea  type="text" class="form-control input-sm"
															name="remarks{{trIndex1}}" id="remarks{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.remarks">
															</textarea></td>-->
															
															
									
									
							</tr>
							
									
								
							

						</tbody>
								
							</table>
							<div class="col-sm-12 col-md-4 col-lg-4" >
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4" ></div>
									<div class="col-sm-12 col-md-4 col-lg-4" >
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Total Amount <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<input type="text"
									class="form-control input-sm text-right"
									id="totalAmount"
									ng-model="purchaseinvoiceNew.totalAmount"
									name="totalAmount" disabled="true" >
										</div>

									</div>
									
									
								</fieldset>
							</div>
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
								
							</div>
							
							
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="content">
										<div class="form-actions">
											<div class="row">
												<div class="row">
			<div class="col-md-12" align="center">
								<button ng-if="!view" class="btn btn-success" ng-click="apply(purchaseInvoiceForm,purchaseinvoiceNew)" type="button">Apply</button>
				
				<button class="btn btn-danger" ng-click="cancelng()" type="button">Cancel</button>
 			</div>
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