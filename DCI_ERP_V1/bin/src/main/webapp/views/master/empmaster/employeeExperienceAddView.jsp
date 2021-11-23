
<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 450px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -100px;
}
</style>
<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div class="panel panel-default panel-default-form">
					<%@include file="/views/templates/panel-header-form.jsp"%>
					<div class="panel-body">
						<div class="widget-body">
							<form class="form-horizontal" name="employeeExperienceAddForm"
								novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-10 col-lg-10">
										<fieldset>


											<div class="form-group">
												<label class="col-md-6 control-label"> Organization
													Name <span style="color: red;">*</span>
													<div class="col-md-6">
														<input type="text"
															ng-model="employeeExperience.organization"
															name="organization" validation="required"
															friendly-name="Organization Name "
															data-message-id="organization" ng-if="!isEdit"
															form-name="employeeExperienceAddForm"> <input
															type="text" ng-model="employeeExperience.organization"
															name="organization" validation="required"
															friendly-name="Organization Name "
															data-message-id="organization" readonly ng-if="isEdit"
															form-name="employeeExperienceAddForm" disabled>
													</div>
											</div>

											<div class="form-group">
												<label class="col-md-6 control-label"> Designation
													Name <span style="color: red;">*</span>

													<div class="col-md-6">
														<input type="text"
															ng-model="employeeExperience.expDesisnation"
															name="expDesisnation"
															form-name="employeeExperienceAddForm"
															validation="required" friendly-name="Designation Name"
															data-message-id="expDesisnation" disabled>

													</div>
											</div>
											<div class="form-group">
												<label class="col-md-6 control-label">Total Salary</label>
												<div class="col-md-6">
													<input type="number" min="0"
														ng-model="employeeExperience.totalSalary"
														name="totalSalary" data-message-id="totalSalary"
														form-name="employeeExperienceAddForm" disabled>
												</div>
											</div>
											<!-- <div class="form-group">
												<label class="col-md-6 control-label"
													style="margin-top: 8px;">From Date <span
													style="color: red;">*</span>
													<div class="col-md-6" style="margin-top: -14px;">
														<div class='input-group date datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="fromDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="From Date"
																			form-name="employeeExperienceAddForm"
																			data-ng-model="employeeExperience.fromDate"
																			validation="required" friendly-name="From Date">
																		<span class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="employeeExperience.fromDate"
																		data-on-set-time="employeeExperience.fromDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#fromDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
											</div>
 -->
											<!-- <div class="form-group">
												<label class="col-md-6 control-label"
													style="margin-top: -11px;">To Date <span
													style="color: red;">*</span>
													<div class="col-md-6" style="margin-top: -33px;">

														<div class='input-group date datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="toDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="To Date"
																			form-name="employeeExperienceAddForm"
																			data-ng-model="employeeExperience.toDate"
																			validation="required" friendly-name="To Date">
																		<span class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="employeeExperience.toDate"
																		data-on-set-time="employeeExperience.toDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>



													</div>
											</div> -->
											<div class="form-group">
												<label class="col-md-6 control-label"> Remarks </label>
												<div class="col-md-6">
													<textarea class="text-left form-control input-sm" rows="2"
														cols="25" name="remarks" style="resize: none"
														ng-model="employeeExperience.expRemarks" disabled></textarea>
												</div>
											</div>

										</fieldset>
									</div>
								</div>
								<div class="row" align="center">
									<div class="col-md-12">
										
										<button class="btn btn-danger" type="button"
											class="btn btn-success" data-ng-click="empExpCancel();">
											<i class="fa fa-close"></i> Cancel
										</button>
									</div>
								</div>
								<!-- <div class="form-actions">
									<div class="row">
										<div class="col-md-11">
											 <label >
						        				<span style="color: red;">*</span>
						          					Attendence Should be available for requesting hoilday date
						          			 </label>
											<label >
						        				<span style="color: red;">*</span>
						          					Holiday Leave canbe added once the request saved and get approved in Holiday Working Approval 
						          			 </label>
											<label >
						        				<span style="color: red;">*</span>
						          					Saved onces can be viewed and requested in Leave Request
						          			 </label>
										</div>
									</div>
								</div> -->
							</form>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>
