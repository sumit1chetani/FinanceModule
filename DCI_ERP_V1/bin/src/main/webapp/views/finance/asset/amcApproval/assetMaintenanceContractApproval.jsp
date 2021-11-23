<style>
#AssetTrackDetails thead tr:first-child {
	color: ###3# !important;
	position: absolute !important;
}

#AssetTrackDetails tbody tr:first-child td {
	padding-top: 35px !important;
}
.spantextIndent{
  line-height: 30px;
  display: inline-block;
  text-indent: 74px;
  margin-left: -70px;

}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
<section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
						<form class="form-horizontal" name="assetmaintenaceContractApprovalForm">
							<!-- Form field start -->
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12 ">
									<fieldset>
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4 control-label">Maintenance
													Contract No. </label>
												<div class="col-md-7 padding-top-6">
													{{assetMaintenanceApprovalObj.assetMaintenanceContractNo}}</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Vendor <span
													style="color: red;">*</span></label>
												<div class="col-md-7 padding-top-6">
													<selectivity list="CustomerList"
														property="assetMaintenanceApprovalObj.entityId" disabled=true></selectivity>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label"> Vendor
													Address</label>
												<div class="col-md-7">
													<div class="col-md-12 no-padding">
														<textarea class="text-left form-control input-sm" rows="2"
															cols="15" style="resize: none"
															ng-model="assetMaintenanceApprovalObj.vendorAddres" readonly> </textarea>
													</div>
													<div class="col-md-12 no-padding">
														<div class="col-md-5 no-padding padding-top-5">
															<input type="text" class="form-control input-sm"
																placeholder="city"
																ng-model="assetMaintenanceApprovalObj.vendorCity" readonly>
														</div>
														<div
															class="col-md-4 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm"
																placeholder="zip"
																ng-model="assetMaintenanceApprovalObj.vendorZip" readonly>
														</div>
														<div
															class="col-md-3 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm"
																placeholder="state"
																ng-model="assetMaintenanceApprovalObj.vendorState" readonly>
														</div>
													</div>
													<div class="col-md-12 no-padding padding-top-5">
														<input type="text" class="form-control input-sm"
															placeholder="country"
															ng-model="assetMaintenanceApprovalObj.vendorCountry" readonly>
													</div>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Item <span
													style="color: red;">*</span></label>
												<div class="col-md-7 padding-top-6">
													{{assetMaintenanceApprovalObj.itemName}}
													<selectivity list="ItemList"
														property="assetMaintenanceApprovalObj.itemId" disabled=true></selectivity>
												</div>

											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Start Date</label>
												<div class="col-md-7 padding-top-6">
													{{assetMaintenanceApprovalObj.startDate}}</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Maintenance
													Tye </label>
												<div class="col-md-7 padding-top-6">
													<selectivity list="maintenanceList" name="maintenanceId"
														property="assetMaintenanceApprovalObj.maintenanceId" disabled=true></selectivity>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-md-4 control-label">Approved By <span
													style="color: red;">*</span></label>
												<div class="col-md-7" data-ng-if="!isView">
													<selectivity list="employeeList"
													property="assetMaintenanceApprovalObj.assetApprovedBy" id="assetApprovedBy"
													name="assetApprovedBy" form-name="assetmaintenaceContractApprovalForm"
													validation="required" friendly-name="Vendor"
													ng-model="assetMaintenanceApprovalObj.assetApprovedBy"></selectivity>
												
												</div>
												<div class="col-md-7" data-ng-if="isView">
													<selectivity list="employeeList"
													property="assetMaintenanceApprovalObj.assetApprovedBy"  disabled=true
													></selectivity>
												
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label"> Status </label>
												<div class="col-md-7" data-ng-if="!isView">
													<select class="form-control input-sm"
														ng-model="assetMaintenanceApprovalObj.statusId" name="statusId"
														validation="required" friendly-name="Status" id="statusId"
														ng-options="obj.defTableId as obj.value for obj in StatusList">
													<option value="" selected="selected">Select</option>
													</select>
												</div>
												<div class="col-md-7" data-ng-if="isView">
													<select class="form-control input-sm"
														ng-model="assetMaintenanceApprovalObj.statusId" 
														ng-options="obj.defTableId as obj.value for obj in StatusList" disabled>
													<option value="" selected="selected">Select</option>
													</select>
												</div>
											</div>

										</div>

										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4 control-label">Contract Date

												</label>
												<div class="col-md-7 padding-top-6">
													{{assetMaintenanceApprovalObj.assetMaintenanceDate}}</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Agreed By</label>
												<div class="col-md-7 padding-top-6">
													<selectivity list="employeeList" name="verifyId"
														property="assetMaintenanceApprovalObj.verifyId" disabled=true></selectivity>

												</div>
											</div>
											<div class="form-group padding-top-5">
												<label class="col-md-4 control-label"> Job Title </label>
												<div class="col-md-7 padding-top-6">
													{{assetMaintenanceApprovalObj.jobTitle}}</div>
											</div>
											<div class="form-group padding-top-5">
												<label class="col-md-4 control-label">Contact Person

												</label>
												<div class="col-md-7 padding-top-6">
													{{assetMaintenanceApprovalObj.contactPerson}}</div>
											</div>
											<div class="form-group padding-top-5">
												<label class="col-md-4 control-label">Contact No.</label>
												<div class="col-md-7 padding-top-6">
													{{assetMaintenanceApprovalObj.contactNo}}</div>
											</div>
											<div class="form-group  padding-top-5">
												<label class="col-md-4 control-label">Item Category
												</label>
												<div class="col-md-7 padding-top-6">
													{{assetMaintenanceApprovalObj.itemCategoryId}}</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">End Date <spring:message
														code="label.asterisk.symbol"></spring:message>
												</label>
												<div class="col-md-7 padding-top-6">
													{{assetMaintenanceApprovalObj.endDate}}</div>
											</div>
											<div class="form-group padding-top-5">
												<label class="col-md-4 control-label">Document Name
												</label>
												<div class="col-md-7  padding-top-6">
													{{assetMaintenanceApprovalObj.docName}}</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">File Upload</label>
												<div class="col-md-7  padding-top-6" data-ng-if="!isUpload">
													<a href="{{assetMaintenanceApprovalObj.url}}"><button
															class="btn btn-success" type="button">File
															download</button></a>
												</div>

											</div>
											

										</div>
									</fieldset>
								</div>
							</div>
							<div id="AssetTrackDetails">
								<div class="" data-st-table="displayedCollection"
									data-st-safe-src="rowCollection"
									>
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>
												<th class="width_1 table-heading text-center"><label
													class="i-checks m-b-none"> <input type="checkbox">
														<i></i>
												</label></th>
												<th class="table-heading width_7">Asset Track No</th>
												<th class="table-heading width_7">Asset Name</th>
												<th class="table-heading width_7">Serial No</th>
												<th class="table-heading width_7">Asset Location</th>
												<th class="table-heading width_7">Responsible</th>
												<th class="table-heading width_7">Asset User</th>
											</tr>
										</thead>
										<tbody>
											<tr data-ng-class="trIndex % 2 == 0? 'even' : 'odd'"
												data-ng-repeat="(trIndex, row) in displayedCollection">
												<td class="width_1"><label class="i-checks m-b-none"><input
														type="checkbox" data-ng-model="row.assetTrackConfirm"
														ng-change=onCount(row.assetTrackConfirm)> <i></i></label></td>


												<td>{{row.assettrackNo}}</td>
												<td>{{row.assettrackName}}</td>
												<td>{{row.serialNo}}</td>
												<td>{{row.asstlocation}}</td>
												<td>{{row.resAsset}}</td>
												<td>{{row.user}}</td>

											</tr>
										</tbody>

									</table>
								</div>

								<div class="row padding-top-15">

									<div class=".col-md-4 .col-md-offset-4">
										<div class="form-group">
											<label class="col-md-8 control-label"> Quantity </label>
											<div class="col-md-2">

												<input type="text" class="form-control input-sm text-right"
													data-ng-model="assetMaintenanceApprovalObj.quantity" id="quantity"
													name="quantity" validation="required"
													friendly-name="Quantity" readonly>
											</div>

										</div>
										<div class="form-group">
											<label class="col-md-6 control-label"> Amount</label>
											<div class="col-md-2">

												<input type="text" class="form-control input-sm text-right" style="width: 110px; float:left;"
													data-ng-model="assetMaintenanceApprovalObj.amount" id="amount"
													name="amount" readonly>
													<span class="spantextIndent">(Each)</span>
											</div>
											<div class="col-md-2">

												<input type="text" class="form-control input-sm text-right"
													data-ng-model="assetMaintenanceApprovalObj.subAmount"
													id="subAmount" name="subAmount" placeholder="0.00" readonly>
											</div>


										</div>
									</div>
									<div class=".col-md-4 .col-md-offset-4">
										<div class="form-group">
											<label class="col-md-6 control-label">Tax </label>
											<div class="col-md-2">
												<selectivity list="taxList"
													property="assetMaintenanceApprovalObj.taxId" disabled=true></selectivity>

											</div>
											<div class="col-md-2">

												<input type="text" class="form-control input-sm text-right"
													data-ng-model="assetMaintenanceApprovalObj.taxAmount"
													id="taxAmount" readonly>
											</div>

										</div>
										<div class="form-group" data-ng-hide="subTax">
											<label class="col-md-6 control-label">SubTax </label>
											<div class="col-md-2">

												<input type="text" class="form-control input-sm"
													data-ng-model="assetMaintenanceApprovalObj.subtax" id="subtax"
													readonly>

											</div>
											<div class="col-md-2">

												<input type="text" class="form-control input-sm text-right"
													data-ng-model="assetMaintenanceApprovalObj.subtaxAmount"
													id="subtaxAmount" readonly>
											</div>

										</div>
									</div>
									<div class=".col-md-4 .col-md-offset-4">
										<div class="form-group">
											<label class="col-md-8 control-label">Total</label>
											<div class="col-md-2">

												<input type="text" class="form-control input-sm text-right"
													data-ng-model="assetMaintenanceApprovalObj.totalAmount"
													id="totalAmount" readonly>
											</div>

										</div>
									</div>


								</div>
							</div>


							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button" data-ng-if="!isView"
											class="btn btn-success"
											data-ng-click="submit(assetMaintenanceApprovalObj)">
											<i class="fa fa-save"></i> Confirm Approve
										</button>
										<button class="btn btn-danger" type="button"
											class="btn btn-success" data-ng-click="cancel();">
											<i class="fa fa-close"></i> Back To List
										</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				</div>
			</article>
		</div>
	</section>
</div>

