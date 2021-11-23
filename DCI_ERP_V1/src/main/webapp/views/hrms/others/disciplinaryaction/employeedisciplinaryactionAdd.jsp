<!-- #MAIN CONTENT -->
<div id="content">
	<!-- widget grid -->
	<section widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="disciplinaryActionForm"
								role="form" ng-submit="#" novalidate>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">

										<fieldset>
											<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-6 control-label">Organization Name <span
														style="color: red;">*</span><span style="color: red;"></span></label>
														<input type="hidden"
														value="${form_code}" id="formCode" /></input>
													<div class="col-md-6 inputGroupContainer">
														<selectivity list="hospitalList"
															property="disciplinaryData.hospitalId" id="hospitalId" disabled ="disable"
															name="hospitalId" friendly-name="Hospital Name" form-name="disciplinaryActionForm"
															ng-model="disciplinaryData.hospitalId" validation="required"> </selectivity>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-6 control-label">Branch <span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-6">
														<selectivity list="branchList"
															property="disciplinaryData.branchId" id="branchId"
															name="branchId" friendly-name="Branch Name" form-name="disciplinaryActionForm"
															ng-model="disciplinaryData.branchId" validation="required"> </selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-6 control-label">Department <span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-6">
														<selectivity list="departmentList"
															property="disciplinaryData.departmentId"
															id="departmentId" name="departmentId"
															friendly-name="Department Name" form-name="disciplinaryActionForm"
															ng-model="disciplinaryData.departmentId" validation="required"> </selectivity>
													</div>
												</div>

											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-3 control-label">Designation<span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-6">
														<selectivity list="designationList"
															property="disciplinaryData.designationId" id="designationId"
															name="designationId" friendly-name="Designation" form-name="disciplinaryActionForm"
															ng-model="disciplinaryData.designationId" validation="required"> </selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Grade <span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-6">
														<selectivity list="gradeList"
															property="disciplinaryData.gradeId" id="gradeId" name="gradeId"
															friendly-name="Grade" form-name="disciplinaryActionForm" ng-model="disciplinaryData.gradeId" validation="required">
														</selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Employee Name<span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-6">
														<selectivity list="employeeList"
															property="disciplinaryData.employeeId" id="employeeId" name="employeeId"
															friendly-name="Employee Name" form-name="disciplinaryActionForm"
															ng-model="disciplinaryData.employeeId" validation="required"> </selectivity>
													</div>
												</div>
											</div>

										</fieldset>
									</div>
									<div
										class="col-sm-8 col-md-8 col-lg-8 col-md-offset-3 panel-body">
										<label class="radio-inline col-md-2"> <input
											type="radio" name="proceedings" validation="required"
											class="ng-pristine ng-untouched ng-valid" value="suspend" friendly-name="Proceedings" form-name="disciplinaryActionForm"
											ng-model="disciplinaryData.proceedings">Suspended 
										</label> <label class="radio-inline col-md-2"> <input
											type="radio" name="proceedings" validation="required"
											class="ng-pristine ng-untouched ng-valid" value="warn"  friendly-name="Proceedings" form-name="disciplinaryActionForm"
											ng-model="disciplinaryData.proceedings">Warning
										</label>
									</div>
									<div class="col-sm-12 col-md-12 col-lg-12"
										ng-if="disciplinaryData.proceedings=='suspend'">
										<div class="form-group">
											<label class="col-md-2 control-label">Suspended From<span
														style="color: red;">*</span><span style="color: red;"></span></label>
											<div class="col-md-2">
												<div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="validityFrom" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" 
																	friendly-name="Suspend From"
																	ng-model="disciplinaryData.suspendFrom"
																	property="disciplinaryData.suspendFrom" form-name="disciplinaryActionForm"
																	name="suspendFrom" id="suspendFrom" validation="required"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="disciplinaryData.suspendFrom"
																data-on-set-time="disciplinaryData.suspendFrom = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#suspendFrom',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
											<label class="col-md-2 control-label">Suspended To<span
														style="color: red;">*</span><span style="color: red;"></span></label>
											<div class="col-md-2">
												<div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="validityFrom" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" 
																	friendly-name="Suspend To"
																	ng-model="disciplinaryData.suspendTo" form-name="disciplinaryActionForm"
																	property="disciplinaryData.suspendTo" name="suspendTo" validation="required"
																	id="suspendTo"><span class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="disciplinaryData.suspendTo"
																data-on-set-time="disciplinaryData.suspendTo = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#suspendFrom',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
											<label class="col-md-1 control-label">No Of Days<span
														style="color: red;">*</span><span style="color: red;"></span></label>
											<div class="col-md-2">
												<input type="text" class="form-control input-sm"
													ng-model="disciplinaryData.suspendedDays" friendly-name="No Of Days" form-name="disciplinaryActionForm"
													property="disciplinaryData.suspendedDays"
													name="suspendedDays" id="suspendedDays" validation="required"/>
											</div>
										</div>
									</div>
									<div class="col-sm-12 col-md-11 col-lg-11 margin-left-6-2"
										ng-if="disciplinaryData.proceedings=='warn'">
										<div class="form-group">
											<label class="col-md-3 control-label">Issue Warning<span
														style="color: red;">*</span><span style="color: red;"></span></label>
											<div class="col-md-5">
												<textarea id="reason" rows="3" cols="35"
													class="form-control input-sm" style="resize: none"
													ng-model="disciplinaryData.issueWarning" friendly-name="Issue Warning" form-name="disciplinaryActionForm"
													property="disciplinaryData.issueWarning"
													name="issueWarning" id="issueWarning" validation="required"></textarea>
											</div>
										</div>
									</div>
									<div class="col-sm-12 col-md-11 col-lg-11 margin-left-6-2">
										<div class="form-group">
											<label class="col-md-3 control-label">Reason <span
														style="color: red;">*</span><span style="color: red;"></span></label>
											<div class="col-md-5">
												<textarea id="reason" rows="3" cols="35"
													class="form-control input-sm" style="resize: none"
													ng-model="disciplinaryData.reason" form-name="disciplinaryActionForm"
													property="disciplinaryData.reason" name="reason"
													id="reason" validation="required" friendly-name="Reason"></textarea>
											</div>
										</div>
									</div>
									<div class="col-sm-12 col-md-12 col-lg-12">
										<label class="col-md-8 col-md-offset-2 control-label-left"><span
											style="color: red;">*</span>This is only for Recording
											Information, Please do change using appropiate form for grade
											and salary change.</label>
									</div>
									<input type="hidden" class="form-control input-sm"
													ng-model="disciplinaryData.disciplinary_proceedings_sk"
													property="disciplinaryData.disciplinary_proceedings_sk"
													name="disciplinary_proceedings_sk" id="disciplinary_proceedings_sk"/>

								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button" ng-if="!disciplinaryObj.edit"
												class="btn btn-success"
												data-ng-click="submit(disciplinaryActionForm,disciplinaryData)">
												<i class="fa fa-save"></i> Save
											</button>
											<button class="btn btn-success" type="button" ng-if="disciplinaryObj.edit"
												class="btn btn-success" data-ng-click="submit(disciplinaryActionForm,disciplinaryData)">
												<i class="fa fa-undo"></i> Update
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i> Cancel
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