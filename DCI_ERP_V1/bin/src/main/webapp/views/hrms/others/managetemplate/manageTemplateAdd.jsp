<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- #MAIN CONTENT -->
<style>
#locationid>div>div {
	width: 305px !important;
	overflow: auto !important;
}

#locationid>div {
	max-width: 305px !important;
}

#locationid>div.selectivity-dropdown>div {
	overflow: auto !important;
}
</style>
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
							<div>
								<span> <span class="button-icon" data-placement="bottom"
									data-reset-widgets rel="tooltip"
									title="<spring:message code='title.widget.reset'></spring:message>">
										<i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="templateForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-3 col-lg-6 ">
											<fieldset>
												<div class="form-group">
													<label class="col-md-4 control-label">Template ID <spring:message
															code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="template_id" id="template_id"
															data-ng-model="template.template_id"
															form-name="templateForm" validation="required"
															friendly-name="Template ID" readonly>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Valid From <spring:message
															code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="fromDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="valid_from"
																			class="width_100" data-message-id="From Date"
																			validation="date_euro_long|required"
																			friendly-name="From Date"
																			data-ng-model="template.valid_from"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="template.valid_from"
																		data-on-set-time="template.valid_from = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#fromDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Designation
														<spring:message code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<select class="form-control journalVoucher-textBox"
															ng-model="template.designation" id="designation"
															name="designation"
															ng-options="emp.designation as emp.designationName for emp in designationList"
															name="Designation" data-message-id="designation"
															validation="required" friendly-name="Designation Name"
															validation="required">
															<option value="">Select</option>
														</select>
													</div>
												</div>

											</fieldset>
										</div>
										<div class="col-sm-6 col-md-3 col-lg-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-4 control-label">Template Name
														<spring:message code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="template_name" id="template_name"
															data-ng-model="template.template_name"
															form-name="templateForm" validation="required" maxlength="60"
															friendly-name="Template Name">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Valid To <spring:message
															code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="toDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="valid_to"
																			class="width_100" data-message-id="To Date"
																			validation="date_euro_long|required"
																			friendly-name="To Date"
																			data-ng-model="template.valid_to"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="template.valid_to"
																		data-on-set-time="template.valid_to = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Status<span
														style="color: red;">*</span></label>
													<div class="col-md-1">
														<div class="checkbox">
															<label> <input class="checkbox style-0"
																type="checkbox" data-ng-model="template.status"
																id="status" name="status"> <span></span></label>
														</div>
													</div>
												</div>
											</fieldset>
										</div>
									</div>
								</div>
								<div></div>

								<div class="col-sm-12 col-md-12 col-lg-12">
									<br>
									<div role="content">
										<div class="widget-body no-padding">
											<div
												class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
												data-st-table="displayedCollectionItem"
												data-st-safe-src="rowCollectionItem">
												<table id="dt_basic"
													class="table table-striped table-bordered table-hover dataTable no-footer"
													role="grid" aria-describedby="dt_basic_info">
													<thead class="dataTables-Main-Head">
														<tr>
															<th class="width_1 table-heading text-center"><label
																class="i-checks m-b-none"> <input
																	type="checkbox" ng-model="selectedAll"
																	ng-change="checkAll(displayedCollectionItem,selectedAll)">
																	<i style="left:-18px;"></i>
															</label></th>
															<th class="sorting width_14">Question ID</th>
															<th class="sorting width_6">Question Description</th>
														</tr>
													</thead>
													<tbody class="dataTables-Main-Body">
														<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
															
															ng-repeat="departmentCollections in displayedCollectionItem"
															>
															<td><label class="i-checks m-b-none"> <input
																	type="checkbox"
																	ng-model="departmentCollections.select"> <i></i>
															</label></td>
															<td>{{departmentCollections.question_id}}</td>
															<td>{{departmentCollections.question_desc}}</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
										<!-- end widget content -->
									</div>
								</div>

								<div class="padding-left-10 padding-top-5"
									id="AddOrRmveMeritbtn">
									<button ng-click="addQuestions()"
										class="btn btn-sm btn-primary" tooltip="Add" ng-disabled=""
										type="button">
										<i class="fa fa-plus"></i>
									</button>
									<button ng-click="removeQuestions()"
										class="btn btn-sm btn-danger" type="button" tooltip="Delete">
										<i class="fa  fa-trash-o"></i>
									</button>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12" id="NoView">
											<button class="btn btn-success" type="button"
												data-ng-if="!templateObj.edit"
												data-ng-click="submit(templateForm,template)">
												<i class="fa fa-save"></i>
												<spring:message code="label.save"></spring:message>
											</button>
											<button class="btn btn-success" type="button"
												data-ng-if="templateObj.edit"
												data-ng-click="submit(templateForm,template)">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>
											<button class="btn btn-info" type="button"
												data-ng-click="reset();">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel()">
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