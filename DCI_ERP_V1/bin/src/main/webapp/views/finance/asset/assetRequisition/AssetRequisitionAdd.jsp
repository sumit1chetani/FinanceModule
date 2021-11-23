
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="assetRequisitionForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-md-6">
											<fieldset>
												<div class="form-group" data-ng-if="isEdit">
													<label class="col-md-3 control-label"> Asset
														Requisition No </label>
													<div class="col-md-7">

														<input type="text" class="form-control input-sm"
															ng-model="assetRequisitionObj.assetrequisitionNo"
															readonly>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Requisition
														Date</label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a data-toggle="dropdown" class="dropdown-toggle"
																	id="reqdate" role="button" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="assetDate"
																			data-ng-model="assetRequisitionObj.assetrequisitionDate" readonly>
																		<span class="input-group-addon"> <i
																			class="glyphicon glyphicon-calendar"></i>
																		</span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker 
																		data-ng-model="assetRequisitionObj.assetrequisitionDate"
																		data-on-set-time="assetRequisitionObj.assetrequisitionDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#reqdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Source
														Location <span style="color :red">*</span> </label>
													<div class="col-md-7">

														<selectivity list="destLocationList"
															property="assetRequisitionObj.sourceLocation"
															data-ng-model="assetRequisitionObj.sourceLocation"
															name="sourceLocation" form-name = "assetRequisitionForm" 
	        												validation="required" friendly-name="Source Location"
															id="sourceLocation"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Asset Item <span style="color :red">*</span> </label>
													<div class="col-md-7" data-ng-if="!isEdit">
														<selectivity list="ItemList" 
															property="assetRequisitionObj.itemId" 
															data-ng-model="assetRequisitionObj.itemId"
															name="itemId" form-name = "assetRequisitionForm" 
	        												validation="required" friendly-name="Asset Item"
															id="itemId"></selectivity>
													</div>
													<div class="col-md-7" data-ng-if="isEdit">
														<selectivity list="ItemList" 
															property="assetRequisitionObj.itemId" id="itemId"
															disabled=true></selectivity>
													</div>
												</div>
													<div class="form-group">
					        				<label class="col-md-3 control-label"> Hospital <spring:message
					              			code="label.asterisk.symbol"></spring:message></label>
					        				<div class="col-md-7">
						        				<selectivity list="companyList" property="assetRequisitionObj.companyId" id="companyId"
						        				ng-model="assetRequisitionObj.companyId" name="companyId" form-name = "assetRequisitionForm"
						        				validation="required" friendly-name="Hospital"></selectivity>
											</div>
										</div>

											</fieldset>
										</div>
										<div class="col-md-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label"> Requested By <span style="color :red">*</span>
													</label>
													<div class="col-md-7">
														<selectivity list="employeeList"
															property="assetRequisitionObj.employeeId" id="employeeId"
															data-ng-model="assetRequisitionObj.employeeId"
															name="employeeId" form-name = "assetRequisitionForm" 
	        												validation="required" friendly-name="Requested By"
															></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Destination Location<span style="color :red">*</span></label>
													<div class="col-md-7">

														<selectivity list="destLocationList"
															property="assetRequisitionObj.destinationLocation"
															data-ng-model="assetRequisitionObj.destinationLocation"
															name="destinationLocation" form-name = "assetRequisitionForm" 
	        										validation="required" friendly-name="Destination Location"
															id="destinationLocation"></selectivity>
													</div>
																
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Quantity <span style="color :red">*</span></label>
													<div class="col-md-7">

														<input type="text"
															class="form-control input-sm text-right"
															data-ng-model="assetRequisitionObj.quantity" id="quantity" name="quantity"
															validation="required" friendly-name="Quantity"
															readonly >
													</div>

												</div>
												<div class="form-group">
													<Label class="col-md-3 control-label">EDD  <span style="color :red">*</span></Label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a data-toggle="dropdown" class="dropdown-toggle"
																	id="edddate" role="button" data-target="#"
																	href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="assetDate"
																			data-ng-model="assetRequisitionObj.eddDate"
																			validation="required" friendly-name="EDD Date"
																			>
																		<span class="input-group-addon"> <i
																			class="glyphicon glyphicon-calendar"></i>
																		</span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="assetRequisitionObj.eddDate"
																		data-on-set-time="assetRequisitionObj.eddDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#edddate{{trIndex}}',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>

											</fieldset>
										</div>
									</div>
									
									<!-- <div class="col-sm-12 col-md-12 col-lg-12">
											<br>
											<div role="content">
												<div class="widget-body no-padding">
													<div class="" data-ng-repeat="(tIndex, table) in assetRequisitionObj.tables"> 
														<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_1 text-center table-heading"><label
																		class="i-checks m-b-none"> <input
																			type="checkbox"> <i></i>
																	</label></th>
																	<th class="sorting width_7" >Asset
																		Name</th>
																	<th class="sorting width_5" >Asset
																		Category</th>
																	<th class="sorting width_5" >UOM</th>
																	<th class="sorting width_5" >Quantity</th>
																	<th class="sorting width_5" >EDD</th>
																</tr>
															</thead>
															<tbody data-ng-repeat="(trIndex, row) in table.row">
																<tr>
																	<td><label class="i-checks m-b-none"> <input
																			type="checkbox" data-ng-model="row.tableId"><i></i></label></td>
																	<td class="padding-both-side-2"><selectivity
																			list="ItemList" property="row.itemId"
																			id="itemId{{trIndex}}"></selectivity></td>
																	<td class="padding-both-side-2"><input type="text"
																		class="form-control input-sm"
																		data-ng-model="row.itemCategoryName" readonly></td>
																	<td class="padding-both-side-2"><input type="text"
																		class="form-control input-sm"
																		data-ng-model="row.uomName" readonly></td>
																	<td class="padding-both-side-2"><input type="text"
																		class="form-control input-sm text-right"
																		data-ng-model="row.quantity"></td>
																	<td class="padding-both-side-2"><div
																			class='input-group date datetimepick col-md-12'>
																			<div class="dropdown">
																				<a data-toggle="dropdown" class="dropdown-toggle"
																					id="edddate{{trIndex}}" role="button" data-target="#" href="#">
																					<div class="input-group">
																						<input type="text" class="form-control"
																							placeholder="dd/mm/yyyy" name="assetDate"
																							data-ng-model="row.eddDate"> <span
																							class="input-group-addon"> <i
																							class="glyphicon glyphicon-calendar"></i>
																						</span>
																					</div>
																				</a>
																				<ul class="dropdown-menu" role="menu"
																					aria-labelledby="dLabel">
																					<datetimepicker data-ng-model="row.eddDate"
																						data-on-set-time="row.eddDate = onDateSet(newDate)"
																						data-datetimepicker-config="{ dropdownSelector: '#edddate{{trIndex}}',startView:'day', minView:'day'}" />
																				</ul>
																			</div>
																		</div></td>
																</tr>
															</tbody>
														</table>
													<button data-ng-click="addRow(table)" class="btn btn-primary"
										type="button">
										<i class="fa fa-plus"></i> 
									</button>
									<button data-ng-click="removeRowForm(table)"
										class="btn btn-danger" type="button">
										<i class="fa fa-trash-o"></i>
									</button>
													</div>
												</div>
												end widget content
											</div>
											<br>
											
										</div> -->
									<div class="col-sm-12 col-md-12 col-lg-12"
										id="AssetTrackDetails">
										<br>
										<div role="content">
											<div class="widget-body no-padding">
												<div class="" data-st-table="displayedCollection"
													data-st-safe-src="rowCollection"
													style="height: 192px; overflow: auto;">
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
															<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																ng-repeat="objAssetRequistion in displayedCollection">

																<td><label class="i-checks m-b-none"><input
																		data-ng-change="onCount(objAssetRequistion.assetTrackConfirm,objAssetRequistion)"
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

													</table>
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
												data-ng-click="submit(assetRequisitionObj,displayedCollection)"
												data-ng-if="!isEdit">
												<i class="fa fa-save"></i>
												<spring:message code="label.save"></spring:message>
											</button>
											<button class="btn btn-success" type="button"
												class="btn btn-success" id="update"
												data-ng-click="submit(assetRequisitionObj,displayedCollection);"
												data-ng-if="isEdit">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success"
												data-ng-click="reset(assetRequisitionForm);">
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
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>