<style>
.field_set {
	border-color: #606060;
	border-style: solid;
}

.setBorder {
	border-style: solid;
	border-width: 1px;
}

a:link {
	color: #200000;
	padding-left: 15px;
}

a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="assetmaintenaceScheduleForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-md-6 ">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label">Item <span
														style="color: red;">*</span></label>
													<div class="col-md-7">
														<selectivity list="ItemList"
															property="assetMaintenanceObj.itemId" 
															
															data-ng-model="assetMaintenanceObj.itemId"
															name="validatedBy" form-name = "assetmaintenaceScheduleForm" 
	        												validation="required" friendly-name="Item"
															name="itemId"></selectivity>
													</div>
												</div>
											</fieldset>
										</div>
										<div class="col-md-6 ">
											<fieldset>
												<div class="form-group ">
													<label class="col-md-3 control-label">Item Category
													</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															data-ng-model="assetMaintenanceObj.itemCategoryId"
															readonly>
													</div>
												</div>
											</fieldset>
										</div>

										<div class="col-sm-12 col-md-12 col-lg-12">
											<br>
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														data-st-table="displayedCollection"
														data-st-safe-src="assetMaintenanceObj.assetTrackList[0]">
														<div class="padding-left-10 padding-top-5"
															id="AddOrRmveMeritbtn">
															<button ng-click="addNew1()"
																class="btn btn-sm btn-primary" tooltip="Add"
																ng-disabled="" type="button">
																<i class="fa fa-plus"></i>
															</button>
															<button ng-click="removeAssetRow()"
																class="btn btn-sm btn-danger" type="button"
																tooltip="Delete">
																<i class="fa  fa-trash-o"></i>
															</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_1 table-heading text-center"><label
																		class="i-checks m-b-none"> <input
																			type="checkbox"> <i></i>
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
																<tr data-ng-if="objAssetRequistion.assetTrackConfirm"
																	data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	data-ng-repeat="objAssetRequistion in displayedCollection">

																	<td><label class="i-checks m-b-none"><input
																			type="checkbox"
																			data-ng-model="objAssetRequistion.assetTrackConfirm">
																			<i></i></label></td>
																	<td>{{objAssetRequistion.assettrackNo}}</td>
																	<td>{{objAssetRequistion.assettrackName}}</td>
																	<td>{{objAssetRequistion.serialNo}}</td>
																	<td>{{objAssetRequistion.asstlocation}}</td>
																	<td>{{objAssetRequistion.resAsset}}</td>
																	<td>{{objAssetRequistion.user}}</td>
																</tr>
															</tbody>
															<tbody>
															</tbody>
														</table>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<br>
										</div>

										<div class="col-sm-12 col-md-12 col-lg-12">
											<br>
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all">
														<div class="padding-left-10 padding-top-5"
															id="AddOrRmveMeritbtn">
															<button ng-click="addNew()()"
																class="btn btn-sm btn-primary" tooltip="Add"
																ng-disabled="" type="button">
																<i class="fa fa-plus"></i>
															</button>
															<button ng-click="removeAssetRow()"
																class="btn btn-sm btn-danger" type="button"
																tooltip="Delete">
																<i class="fa  fa-trash-o"></i>
															</button>
														</div>
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_1 text-center table-heading"></th>
																	<th class="sorting width_10">Maintenance Type</th>
																	<th class="sorting width_10">Schedule Date</th>
																	<th class="sorting width_10">Usage</th>
																	<th class="sorting width_10">Frequency</th>

																</tr>
															</thead>
															<tbody>
																<tr
																	data-ng-repeat="propDtl in assetMaintenanceObj.assetMaintenaceProp">
																	<td><label class="i-checks m-b-none"> <input
																			type="checkbox"
																			data-ng-model="tableSelection[$index]"
																			id="section$index"><i></i></label></td>

																	<td>{{propDtl.maintenanceName}}</td>
																	<td>{{propDtl.maintenanceScheduleDate}}</td>
																	<td><span data-ng-if="propDtl.usage == 1">Period</span><span
																		data-ng-if="propDtl.usage == 2">Utillization</span></td>
																	<td><span data-ng-if="propDtl.usage == 1">{{propDtl.days}}</span><span
																		data-ng-if="propDtl.usage == 2">{{propDtl.frequency}}</span></td>

																</tr>
															</tbody>
														</table>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<br>
										</div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												data-ng-click="submit(assetMaintenanceObj)"
												data-ng-if="!isEdit">
												<i class="fa fa-save"></i>
												<spring:message code="label.save"></spring:message>
											</button>

											<button class="btn btn-success" type="button"
												data-ng-click="update(assetmaintenaceScheduleForm);"
												data-ng-if="isEdit == true">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>

											<button class="btn btn-info" type="button"
												data-ng-click="reset(assetmaintenaceScheduleForm)">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>

											<button class="btn btn-danger" type="button"
												data-ng-click="cancel();">
												<i class="fa fa-close"></i>
												<spring:message code="label.cancel"></spring:message>
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