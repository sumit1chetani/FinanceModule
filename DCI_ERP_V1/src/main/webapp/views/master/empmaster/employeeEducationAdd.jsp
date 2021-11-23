
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
							<form class="form-horizontal" name="employeeEducationAddForm"
								novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-10 col-lg-10">
										<fieldset>


											<div class="form-group">
												<label class="col-md-6 control-label">Qualification
													<div class="col-md-6">
														<input type="text"
															ng-model="employeeEducation.qualification"
															name="qualification" validation="required"
															friendly-name="Qualification "
															data-message-id="qualification" ng-if="!isEdit"
															form-name="employeeEducationAddForm"> <input
															type="text" ng-model="employeeEducation.qualification"
															name="qualification" validation="required"
															friendly-name="Qualification"
															data-message-id="qualification" readonly ng-if="isEdit"
															form-name="employeeEducationAddForm">
													</div>
											</div>

											<div class="form-group">
												<label class="col-md-6 control-label">Institution</label>
												<div class="col-md-6">
													<input type="text" ng-model="employeeEducation.institution"
														name="institution" form-name="employeeEducationAddForm">

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-6 control-label">Course Type </label>
												<div class="col-md-5">

													<select class="form-control journalVoucher-textBox w-sm"
														name="courseType" ng-model="employeeEducation.courseType"
														form-name="employeeEducationAddForm">
														<option value="">--Select--</option>
														<option value="UG">UG</option>
														<option value="PG">PG</option>
													</select>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-6 control-label">Percentage</label>
												<div class="col-md-6">
													<input type="number" min="0"
														ng-model="employeeEducation.percentage" name="percentage"
														data-message-id="totalSalary"
														form-name="employeeEducationAddForm">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-6 control-label">Year of
													Passing</label>
												<div class="col-md-6">
													<input type="number" min="0"
														ng-model="employeeEducation.yearPassed" name="yearPassed"
														data-message-id="yearPassed"
														form-name="employeeEducationAddForm">
												</div>
											</div>


										</fieldset>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												data-ng-click="saveEducation(employeeEducationAddForm)"
												ng-if="!isEdit">Save</button>
											<button class="btn btn-success" type="button"
												data-ng-click="updateEducation(employeeEducationAddForm)"
												ng-if="isEdit">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success"
												data-ng-click="reset(employeeEducationAddForm)"
												ng-if="!isEdit">
												<i class="fa fa-refresh"></i> Reset
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="empEduCancel();">
												<i class="fa fa-close"></i> Cancel
											</button>
										</div>
									</div>
								</div>

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
