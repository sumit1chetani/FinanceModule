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
													<select class="form-control"
														name="maintenanceType"
														data-ng-model="assetMaintenanceSchedule.maintenanceType"
														data-ng-options="obj.id as obj.text for obj in maintenaceList">
														<option value="" selected="selected">Select</option>
													</select>
															
												</div>
											</div>
											<div class="form-group">
											<label class="col-md-6 control-label"></label>
													<div class="radio radio-inline">
														<label class="i-checks"> <input type="radio"
															class="radiobox style-0" data-ng_model="assetMaintenanceSchedule.usage"
															value="1"> <i></i> Period
														</label>
													</div>
													<div class="radio  radio-inline">
														<label class="i-checks"> <input type="radio"
															class="radiobox style-0" data-ng_model="assetMaintenanceSchedule.usage"
															value="2"> <i></i> Utilization
														</label>
													</div>
											</div>
											<div class="form-group" data-ng-show="assetMaintenanceSchedule.usage==1">
												<label class="col-md-6 text-right">Frequency</label>
												<div class="col-md-4">
													<input type="text" data-ng-model="assetMaintenanceSchedule.days"
														class="form-control input-sm">
												</div>
												<div class="col-md-1">
													<label class="control-label"> Days</label>
												</div>
											</div>
											<div class="form-group" data-ng-show="assetMaintenanceSchedule.usage==2">
												<label class="col-md-6 text-right">Frequency</label>
												<div class="col-md-4">
													<input type="text" data-ng-model="assetMaintenanceSchedule.frequency"
														class="form-control input-sm">
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-6 control-label" style="padding-top: 28px;"> Start Date </label>
												<div class="col-md-5">
													<div class='input-group date datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="startDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy"
																		name="Maintenance Schedule Date"
																		data-ng-model="assetMaintenanceSchedule.maintenanceScheduleDate"
																		style="width: 116px;"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="assetMaintenanceSchedule.maintenanceScheduleDate"
																	data-on-set-time="assetMaintenanceSchedule.maintenanceScheduleDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#startDate',startView:'day', minView:'day'}" />
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
											<button class="btn btn-success" type="button"
												 data-ng-click="saveAssetTrackMaintenaceDetails(assetMaintenanceSchedule)"
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