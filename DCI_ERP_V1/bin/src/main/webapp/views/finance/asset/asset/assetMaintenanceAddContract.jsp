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
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
						<div class="widget-toolbar">
							<!-- add: non-hidden - to disable auto hide -->
							<div>
								<span> <span class="button-icon" data-reset-widgets
									rel="tooltip"
									title="<spring:message code="title.widget.reset"></spring:message>"
									data-placement="bottom"> <i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>

					<div class="row book-widget-row" style="padding-bottom: 12px;"
						ng-init="init()">
						<form class="form-horizontal" name="assetmaintenaceContractForm"
							ng-submit="">

							<!-- Form field start -->
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12 ">
									<fieldset>
         							<div class="col-md-6">
										<div class="form-group">
											<label class="col-md-4 control-label">Maintenance
												Contract No. </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													ng-model="assetMaintenanceObj.assetMaintenanceContractNo"
													readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Vendor <span
												style="color: red;">*</span></label>
											<div class="col-md-7">
												<selectivity list="CustomerList"
													property="assetMaintenanceObj.entityId" id="entityId"
													name="entityId" form-name="assetmaintenaceContractForm"
													validation="required" friendly-name="Vendor"
													ng-model="assetMaintenanceObj.entityId"></selectivity>
											</div>
										</div>
										
										<div class="form-group">
												<label class="col-md-4 control-label"> Vendor
													Address</label>
												<div class="col-md-7">
													<div class="col-md-12 no-padding">
														<textarea class="text-left form-control input-sm" rows="2"
															cols="15" style="resize: none"
															ng-model="assetMaintenanceObj.vendorAddres" readonly> </textarea>
													</div>
													<div class="col-md-12 no-padding">
														<div class="col-md-5 no-padding padding-top-5">
															<input type="text" class="form-control input-sm"
															placeholder="city"
															ng-model="assetMaintenanceObj.vendorCity" readonly>
														</div>
														<div
															class="col-md-4 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm"
															placeholder="zip"
															ng-model="assetMaintenanceObj.vendorZip" readonly>
														</div>
														<div
															class="col-md-3 no-padding padding-left-5 padding-top-5">
															<input type="text" class="form-control input-sm"
															placeholder="state"
															ng-model="assetMaintenanceObj.vendorState" readonly>
														</div>
													</div>
													<div class="col-md-12 no-padding padding-top-5">
														<input type="text" class="form-control input-sm"
															placeholder="country"
															ng-model="assetMaintenanceObj.vendorCountry" readonly>
													</div>
												</div>
											</div>
										
										<div class="form-group">
											<label class="col-md-4 control-label">Item <span
												style="color: red;">*</span></label>
											<div class="col-md-7" data-ng-if="!isEdit">
												<selectivity list="ItemList"
													property="assetMaintenanceObj.itemId" id="itemId"
													ng-model="assetMaintenanceObj.itemId" name="itemId"
													form-name="assetmaintenaceContractForm"
													validation="required" friendly-name="Item"></selectivity>
											</div>
											<div class="col-md-7" data-ng-if="isEdit">
												<selectivity list="ItemList"
													property="assetMaintenanceObj.itemId" id="itemId"
													ng-model="assetMaintenanceObj.itemId" name="itemId"
													form-name="assetmaintenaceContractForm"
													validation="required" friendly-name="Item" disabled=true></selectivity>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Start Date <span
												style="color: red;">*</span></label>
											<div class="col-md-7">
												<div class='input-group date datetimepick col-md-12'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="startDate" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="startDate"
																	validation="date_euro_long|required"
																	friendly-name="Start Date"
																	data-ng-model="assetMaintenanceObj.startDate"><span
																	class="input-group-addon" ><i
																	class="glyphicon glyphicon-calendar"></i></span>


															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="assetMaintenanceObj.startDate"
																data-on-set-time="assetMaintenanceObj.startDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#startDate',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Maintenance Type
												<span style="color: red;">*</span>
											</label>
											<div class="col-md-7">
												<selectivity list="maintenanceList" name="maintenanceId"
													form-name="assetmaintenaceContractForm"
													validation="required" friendly-name="Maintenance Type"
													property="assetMaintenanceObj.maintenanceId"
													ng-model="assetMaintenanceObj.maintenanceId"
													id="maintenanceId"></selectivity>
											</div>
										</div>

									</div>
									
         						<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4 control-label">Contract Date
													<spring:message code="label.asterisk.symbol"></spring:message>
												</label>
												<div class="col-md-7">
													<div class='input-group date datetimepick col-md-12'>

														<div class="dropdown">
															<a class="dropdown-toggle" id="salesInvoicedate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="salesInvoicedate"
																		validation="date_euro_long|required"
																		friendly-name="End Date"
																		data-ng-model="assetMaintenanceObj.assetMaintenanceDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="assetMaintenanceObj.assetMaintenanceDate"
																	data-on-set-time="assetMaintenanceObj.assetMaintenanceDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#salesInvoicedate',startView:'day', minView:'day'}" />
															</ul>
														</div>
														</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Agreed By <span
													style="color: red;">*</span></label>
												<div class="col-md-7">
													<selectivity list="employeeList" name="verifyId"
														form-name="assetmaintenaceContractForm"
														validation="required" friendly-name="Agreed By"
														property="assetMaintenanceObj.verifyId"
														ng-model="assetMaintenanceObj.verifyId" id="verifyId"></selectivity>

												</div>
											</div>
											<div class="form-group padding-top-5">
												<label class="col-md-4 control-label"> Job Title </label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetMaintenanceObj.jobTitle" id="jobTitle"
														readonly>
												</div>
											</div>
											<div class="form-group padding-top-5">
												<label class="col-md-4 control-label">Contact Person
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetMaintenanceObj.contactPerson"
														id="contactPerson" name="contactPerson"
														validation="max_len:30|required"
														friendly-name="Contact Person">
												</div>
											</div>
											<div class="form-group padding-top-5">
												<label class="col-md-4 control-label">Contact No. <span
													style="color: red;">*</span></label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetMaintenanceObj.contactNo"
														id="contactNo" name="contactNo"
														validation="max_len:15|numeric|required"
														friendly-name="Contact Number">
												</div>
											</div>
											<div class="form-group  padding-top-5">
												<label class="col-md-4 control-label">Item Category
												</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetMaintenanceObj.itemCategoryId"
														readonly>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">End Date
													<spring:message code="label.asterisk.symbol"></spring:message>
												</label>
												<div class="col-md-7">
													<div class='input-group date datetimepick col-md-12'>

														<div class="dropdown">
															<a class="dropdown-toggle" id="endDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="endDate"
																		validation="date_euro_long|required"
																		friendly-name="End Date"
																		data-ng-model="assetMaintenanceObj.endDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="assetMaintenanceObj.endDate"
																	data-on-set-time="assetMaintenanceObj.endDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#endDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
														</div>
												</div>
											</div>
											<div class="form-group padding-top-5">
												<label class="col-md-4 control-label">Document Name
													
												</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														data-ng-model="assetMaintenanceObj.docName"
														
														>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">File Upload</label>
												<div class="col-md-7" data-ng-if="isUpload">
														<input type="file" class="form-control align-center"
															name="excelfile" 
															onchange="angular.element(this).scope().choosefile(this)"
															accept=".xls,.xlsx,.xlsm,.docx,.pdf" />
												</div>
													<div class="col-md-7" data-ng-if="!isUpload">
													<a 	href="{{assetMaintenanceObj.url}}" ><button
															class="btn btn-success" type="button"
															>File download</button></a>
															   <button class="btn btn-danger" type="button"
											 data-ng-click="cancelUpload();">
											<i class="fa fa-close"></i>
											
										</button>
												</div>
												
											</div>
											
									</div>
										</fieldset>
									</div>
								</div>
								<div id="AssetTrackDetails">
									<div
										class=""
										data-st-table="displayedCollection"
										data-st-safe-src="rowCollection" style=" height: 192px; overflow: auto;">
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
													<td  class="width_1"><label class="i-checks m-b-none"><input
															type="checkbox" data-ng-model="row.assetTrackConfirm" ng-change=onCount(row.assetTrackConfirm)>
															<i></i></label></td>


													<td class="width_7">{{row.assettrackNo}}</td>
													<td class="width_7">{{row.assettrackName}}</td>
													<td class="width_7">{{row.serialNo}}</td>
													<td class="width_7">{{row.asstlocation}}</td>
													<td class="width_7">{{row.resAsset}}</td>
													<td class="width_7">{{row.user}}</td>

												</tr>
												</tbody>
											
										</table>
									</div>
								
								<div class="row padding-top-20">
								
								<div class=".col-md-4 .col-md-offset-4">
											<div class="form-group">
													<label class="col-md-8 control-label"> Quantity <span style="color :red">*</span></label>
													<div class="col-md-2">

														<input type="text"
															class="form-control input-sm text-right"
															data-ng-model="assetMaintenanceObj.quantity" id="quantity" name="quantity"
															validation="required" friendly-name="Quantity"
															readonly >
													</div>

												</div><div class="form-group">
													 
													<label class="col-md-6 control-label"> Amount <span style="color :red">*</span></label>
													<div class="col-md-2">

														<input type="text" ng-keyup="onChangeNumber(assetMaintenanceObj.amount)"
															class="form-control input-sm text-right" style="width: 110px; float:left;"
															data-ng-model="assetMaintenanceObj.amount" id="amount" name="amount" ng-change="calculateSubAmount(assetMaintenanceObj.amount,assetMaintenanceObj.quantity)"
															validation="numeric|required" friendly-name="Amount"
															 >
															 <span class="spantextIndent">(Each)</span>
													</div>
													

													<div class="col-md-2">

														<input type="text"
															class="form-control input-sm text-right"
															data-ng-model="assetMaintenanceObj.subAmount" id="subAmount" name="subAmount"
															placeholder="0.00"readonly >
													</div>
													

												
								</div>
								<div class=".col-md-4 .col-md-offset-4">
									<div class="form-group">
										<label class="col-md-6 control-label">Tax <span
											style="color: red">*</span></label>
										<div class="col-md-2">
											<selectivity list="taxList"
												property="assetMaintenanceObj.taxId" id="taxId"
												ng-model="assetMaintenanceObj.taxId" name="taxId"
												form-name="assetmaintenaceContractForm"
												validation="required" friendly-name="Tax"></selectivity>

										</div>
										<div class="col-md-2">

											<input type="text" class="form-control input-sm text-right"
												data-ng-model="assetMaintenanceObj.taxAmount" id="taxAmount"
												readonly>
										</div>

									</div>
									<div class="form-group" data-ng-hide="subTax">
										<label class="col-md-6 control-label">SubTax <span
											style="color: red">*</span></label>
										<div class="col-md-2">

												<input type="text" class="form-control input-sm"
												data-ng-model="assetMaintenanceObj.subtax" id="subtax"
												readonly>

										</div>
										<div class="col-md-2">

											<input type="text" class="form-control input-sm text-right"
												data-ng-model="assetMaintenanceObj.subtaxAmount" id="subtaxAmount"
												readonly>
										</div>

									</div>
								</div>
								<div class=".col-md-4 .col-md-offset-4">
									<div class="form-group">
										<label class="col-md-8 control-label">Total</label>
										<div class="col-md-2">

											<input type="text" class="form-control input-sm text-right"
												data-ng-model="assetMaintenanceObj.totalAmount" id="totalAmount"
												readonly>
										</div>

									</div>
								</div>
								

							</div>
</div>
</div>
						
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button"
											class="btn btn-success"
											data-ng-click="submit(assetmaintenaceContractForm,assetMaintenanceObj,rowCollection)"
											data-ng-if="!isEdit">
											<i class="fa fa-save"></i>
											<spring:message code="label.save"></spring:message>
										</button>
										<button class="btn btn-success" type="button"
											class="btn btn-success" id="update"
											data-ng-click="submit(dassetmaintenaceContractForm,assetMaintenanceObj,rowCollection);"
											data-ng-if="isEdit">
											<i class="fa fa-save"></i>
											<spring:message code="label.update"></spring:message>
										</button>
										<button class="btn btn-info" type="button"
											class="btn btn-success"
											data-ng-click="reset(deliveryOrderForm);">
											<i class="fa fa-undo"></i>
											<spring:message code="label.reset"></spring:message>
										</button>
										<button class="btn btn-danger" type="button"
											class="btn btn-success" data-ng-click="cancel();">
											<i class="fa fa-close"></i>
											<spring:message code="label.cancel"></spring:message>
										</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>
													