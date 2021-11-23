<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div class="panel panel-default panel-default-form">
					<%@include file="/views/templates/panel-header-form.jsp"%>
					<div class="panel-body">
						<div class="widget-body">
							<form class="form-horizontal" name="experianceForm" novalidate
								method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="form-group">
												<label class="col-md-4 control-label">Organization
													Name <span style="color: red;">*</span>
												</label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Organization Name" validation="required"
														friendly-name="Organization Name" maxlength="50"
														ng-model="EmployeeMasterDataEx.organization" disabled>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Years Of
													Experience <span style="color: red;">*</span>
												</label>


												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Year of Experience in Experience"
														ng-model="EmployeeMasterDataEx.experienceYear"
														placeholder="0.0" style="text-align: right"
														data-message-id="experienceYear" validation="required"
														friendly-name="Years of Experience"
														ng-pattern-restrict="^[0-9.]*$" disabled>
												</div>
											</div>
											<!-- <div class="form-group">
												<label class="col-md-4 control-label">FROM</label>
												<div class="col-md-5">
													<ng-bs3-datepicker
														data-ng-model="EmployeeMasterDataEx.exFrom" id="dob"
														name="dob" form-name="toForm" friendly-name="dob" />

												</div>
											</div> -->
											<!-- <div class="form-group">
												<label class="col-md-4 control-label">TO</label>
												<div class="col-md-5">
													<div class='input-group date datetimepick'>
														<ng-bs3-datepicker
															data-ng-model="EmployeeMasterDataEx.exTo" id="exTo"
															name="exTo" form-name="toForm" friendly-name="exTo" />
													</div>
												</div>
											</div> -->
											<div class="form-group">
												<label class="col-md-4 control-label">Designation <span
													style="color: red;"></span></label>
												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Designation" maxlength="50"
														ng-model="EmployeeMasterDataEx.expDesisnation" disabled>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Contact Name <span
													style="color: red;"></span>
												</label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="contactname" maxlength="30"
														ng-model="EmployeeMasterDataEx.contactname" disabled>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Contact No <span
													style="color: red;"></span>
												</label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="contactno" ng-model="EmployeeMasterDataEx.contactno"
														maxlength="30" ng-pattern-restrict="^[0-9.]*$" disabled>
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label">Remarks<span
													style="color: red;"></span></label>
												<div class="col-md-5">
													<textarea ng-model="EmployeeMasterDataEx.expRemarks"
														name="Remarks" class="form-control input-sm resize-none"
														rows="2" disabled>
	         										</textarea>
												</div>
											</div>
										</fieldset>
									</div>
								</div>

								<div class="row" align="center">
									<div class="col-md-12">
										
										<button class="btn btn-danger" type="button"
											data-ng-click="cancelEmployeeExperiance();">
											<i class="fa fa-close"></i> Cancel
										</button>
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