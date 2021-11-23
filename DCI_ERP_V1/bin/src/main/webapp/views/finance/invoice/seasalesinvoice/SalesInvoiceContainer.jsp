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
							<div class="col-sm-12 col-md-4 col-lg-4">
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
							</div>
							
							

						</div>
						<div class="table-responsive clear">
							<table class="table table-striped b-t b-light">
								<thead>
									<tr>
<th colspan=1 class="width_1"><label class="i-checks m-b-none"> <input
												type="checkbox" ng-model="purchaseInvoiceData.selectBox1" ng-click="selectAll1(purchaseInvoiceData.purchaseInvoiceDetail1)"><i></i></label></th>
										
										<th colspan="1" class="width_9 text-center">Container No<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_7 text-center">Size Type<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_12 text-center">Cargo Description <span style="color: red;"></span>
								</th>
								<th colspan="1" class="width_7 text-center">No of Package<span
									style="color: red;"></span></th>
							
								<th colspan="1" class="width_7 text-center">Net Weight<span
									style="color: red;"></span></th>
								<th colspan="1" class="width_7 text-center">Gross Weight<span
									style="color: red;"></span></th>
									
										<th colspan="1" class="width_7 text-center">UOM<span
									style="color: red;"></span>
								</th>
								
								<th colspan="1" class="width_7 text-center">Measurement<span
									style="color: red;"></span></th>
									<th colspan="1" class="width_7 text-center">Status<span
									style="color: red;"></span></th>


									</tr>
								</thead>
								<tbody
							ng-repeat="(trIndex1, jobOrderTrackingDtl) in purchaseInvoiceData.purchaseInvoiceDetail1"
							class="bookingDtlCls"  ng-controller="jobtableCtrl">
							<tr>
								<td ng-if="jobOrderTrackingDtl.selected==false"><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="jobOrderTrackingDtl.select1" > <i></i></label></td>
										<td ng-if="jobOrderTrackingDtl.selected==true"><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="jobOrderTrackingDtl.select1" disabled="true"> <i></i></label></td>
								<!--<td class="text-center">{{trIndex1+1}}</td>-->
								
								<td>
								
								<input  ng-if=joborder.mode=="5" type="text" id="containerNo{{trIndex1}}"
									class="form-control input-sm " maxlength="11"
									ng-model="jobOrderTrackingDtl.containerNo"
									name="containerNo{{trIndex1}}" form-name='jobOrderForm'
									friendly-name="{{ 'Row-' + (trIndex1+1) + 'containerNo'}}" disabled="true">
									
										<selectivity ng-if=joborder.mode!="5" list="containerNoList"
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
								<td><textarea  type="text" class="form-control input-sm"
															name="cargoDescription{{trIndex1}}" id="cargoDescription{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.cargoDescription" disabled="true">
															</textarea></td>
									

                              <td><input type="text"
									class="form-control input-sm text-right"
									id="noOfPcs{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.noOfPackage"
									name="noOfPackage{{trIndex1}}" ng-change="noOfPcs()" disabled="true"></td>


								<td><input type="number"
									class="form-control input-sm text-right"
									id="netWeight{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.netWeight" 
									name="netWeight{{trIndex1}}" friendly-name="netWeight{{trIndex1}} "
									 ng-change="noOfNet()" form-name="jobOrderForm" disabled="true"></td>

								<td><input type="number"
									class="form-control input-sm text-right"
									id="grossWeight{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.grossWeight"
									name="length{{trIndex1}}" ng-change="noOfGross()" disabled="true"></td>
									
								<td class=""><selectivity list="uomList"
										property="jobOrderTrackingDtl.uom" id="uom"
										ng-model="jobOrderTrackingDtl.uom" name="uom{{trIndex}}"
										validation="required"
										friendly-name="{{ 'Row-' + (trIndex+1) + '(uom)'}}"
										form-name="jobOrderForm" disabled="true"></selectivity></td>

								
									<td><input type="number"
									class="form-control input-sm text-right"
									id="measurement{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.measurement"
									name="measurement{{trIndex1}}" disabled="true"></td>
									
									<td><input type="text"
									class="form-control input-sm text-right"
									id="status{{trIndex1}}"
									ng-model="jobOrderTrackingDtl.status"
									name="status{{trIndex1}}" disabled="true"></td>
								
								<!--<td><textarea  type="text" class="form-control input-sm"
															name="remarks{{trIndex1}}" id="remarks{{trIndex1}}" 
															class="custom-scroll width_250 resize-none" rows="3"
															ng-model="jobOrderTrackingDtl.remarks">
															</textarea></td>-->
									
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
								
							</div>
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="content">
										<div class="form-actions">
											<div class="row">
												<div class="row">
			<div class="col-md-12" align="center">
								<button class="btn btn-success" ng-click="apply(purchaseInvoiceForm,purchaseInvoiceData1)" type="button">Apply</button>
				
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