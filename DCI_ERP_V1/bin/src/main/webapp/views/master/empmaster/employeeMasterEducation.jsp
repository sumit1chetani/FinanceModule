<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="educationForm" novalidate
				method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Qualification <span
									style="color: red;">*</span>
								</label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="Qualification" maxlength="50"
										ng-model="EmployeeMasterDataEdu.qualification"
										data-message-id="qualification" validation="required"
										friendly-name="Qualification">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label">Percentage</label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm" maxlength="5"
										friendly-name="Percentage"
										ng-keyup="validatePercentage(EmployeeMasterDataEdu.percentage)"
										name="Percentage" ng-model="EmployeeMasterDataEdu.percentage"
										ng-pattern-restrict="^[0-9.]*$" placeholder="0.0"
										style="text-align: right">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Specialization <span
									style="color: red;">*</span>
								</label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="specialization" maxlength="50"
										ng-model="EmployeeMasterDataEdu.specialization"
										data-message-id="specialization" validation="required"
										friendly-name="Specialization">
								</div>
							</div>


							<!-- <div class="form-group">
												<label class="col-md-4 control-label">Type Of Course<span
													style="color: red;"></span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Percentage"
														ng-model="EmployeeMasterDataEdu.courseType">
												</div>
											</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Institution <span
									style="color: red;"></span></label>

								<div class="col-md-5 inputGroupContainer">
									<input type="text" class="form-control input-sm"
										name="Institution" maxlength="50"
										ng-model="EmployeeMasterDataEdu.institution">
								</div>
							</div>


							<div class="form-group ">
								<label class="col-md-4 control-label">Year Of Passing</label>
								<div class="col-md-5">
									<select class="form-control journalVoucher-textBox"
										name="Year Of Passing" ng-options="c for c in yearList"
										friendly-name="Year Of Passing"
										ng-model="EmployeeMasterDataEdu.yearPassed">
									</select>
								</div>
							</div>
						</fieldset>
					</div>
				</div>

				<div class="row" align="center">
					<div class="col-md-12">
						<button class="btn btn-success" type="button"
							data-ng-click="validateEducation(EmployeeMasterDataEdu,educationForm)"
							data-ng-if="!ispop1Edit">
							<i class="fa fa-save"></i> Save
						</button>
						<button class="btn btn-success" type="button"
							data-ng-click="validateEducation(EmployeeMasterDataEdu,educationForm);"
							data-ng-if="ispop1Edit == true">
							<i class="fa fa-save"></i> Update
						</button>
						<button class="btn btn-info" type="button" data-ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button>

						<button class="btn btn-danger" type="button"
							data-ng-click="cancelEmployeeEducation();">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>

			</form>
		</div>
	</div>
</div>


