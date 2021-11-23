<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					<header class="ngdialog-header">
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<h2>Add Asset Schedule</h2>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="assetscheForm">
								<div class="row">
									<div class="col-sm-12 col-md-10 col-lg-10">
										<fieldset>
											<div class="form-group">
												<label class="col-md-6 control-label">Maintenance
													Type </label>
												<div class="col-md-6">
													<input type="text" data-ng-model="assetMaintenanceDetailPopupObj.maintenanceName"
														class="form-control input-sm" readonly>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-md-6 control-label">Worked By
													 </label>
												<div class="col-md-6">
													<input type="text" data-ng-model="assetMaintenanceDetailPopupObj.workedbY"
														class="form-control input-sm" >
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-md-6 control-label">Remarks
													 </label>
												<div class="col-md-6">
													<textarea class="form-control input-sm" rows="3" cols="4" data-ng-model="assetMaintenanceDetailPopupObj.remarks"></textarea>
													
												</div>
											</div>
											

											<div class="form-group">
												<label class="col-md-6 control-label" > Actual Date </label>
												<div class="col-md-5">
													<div class='input-group date datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="startDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy"
																		name="Maintenance Schedule Date"
																		data-ng-model="assetMaintenanceDetailPopupObj.actualDate"
																		style="width: 116px;"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="assetMaintenanceDetailPopupObj.actualDate"
																	data-on-set-time="assetMaintenanceDetailPopupObj.actualDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#startDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-6 control-label" > Next Schedule Date <span
														style="color: red;">*</span> </label>
												<div class="col-md-5">
													<div class='input-group date datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="nextstartDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy"
																		name="Maintenance Schedule Date"
																		data-ng-model="assetMaintenanceDetailPopupObj.nextScheduleDate"
																		style="width: 116px;"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="assetMaintenanceDetailPopupObj.nextScheduleDate"
																	data-on-set-time="assetMaintenanceDetailPopupObj.nextScheduleDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#nextstartDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
											
										</fieldset>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button" data-ng-if="view"
												 data-ng-click="save(assetMaintenanceDetailPopupObj)"
												class="btn btn-success">
												<i class="fa fa-save"></i>
												<spring:message code="label.save"></spring:message>
											</button>

											<button class="btn btn-danger" type="reset"
												class="btn btn-success" ng-click="ngcancel()">
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