
<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 1024px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -50px;
}

div#dependVisa>ul {
	margin-top: -175% !important;
}
/*.top-pad{
	-webkit-animation-name: flipInX;
    -moz-animation-name: flipInX;
    -o-animation-name: flipInX;
    animation-name: flipInX;
    -webkit-animation-duration: .4s;
    -moz-animation-duration: .4s;
    -o-animation-duration: .4s;
    animation-duration: .4s;
    -webkit-animation-fill-mode: both;
    -moz-animation-fill-mode: both;
    -o-animation-fill-mode: both;
    animation-fill-mode: both;
    margin-top: -175% !important;
} */
select {
	-webkit-appearance: none;
	padding: 0;
	text-indent: 8px;
	padding: 0 !important;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			
				<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="empFamilyAddForm">
								<div class="row">
									<!--        <div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
							
										Smart Table
									</div>
									 -->
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>

											<fieldset class="field_set setBorder"
												style="margin-bottom: -14px;">
												<div class="form-group">
													<label class="col-md-2 control-label"><b>Dependent
															Details</b> <span style="color: red;"></span></label>
												</div>
												<div class="col-sm-6 col-md-6 col-lg-6">
													<div class="form-group">
														<label class="col-md-4 control-label">Relative
															Name<span style="color: red;"></span>
														</label>
														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																name="Family Name"
																ng-model="employeeFamilyList.relativeName">
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">Gender</label>
														<div class="col-md-5">
															<select class="form-control journalVoucher-textBox"
																name="Gender in Family"
																ng-model="employeeFamilyList.sex" data-message-id="sex"
																validation="required" friendly-name="Gender">
																<option value="">--Select--</option>
																<option value="Male">Male</option>
																<option value="Female">Female</option>
															</select>
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">DOB <span
															style="color: red;"></span></label>
														<div class="col-md-5 inputGroupContainer">

															<div class="input-group input-append date">
																<input type="text" class="form-control input-sm"
																	id="dependentDob" name="dependentDob"
																	form-name="toForm" ng-model="employeeFamilyList.dependentDob"
																	validation="required" friendly-name="dependentDob" />
																<span class="input-group-addon add-on"><span
																	class="glyphicon glyphicon-calendar"></span></span>
															</div>

														

														</div>

													</div>

													<div class="form-group">
														<label class="col-md-5 control-label">Upload Photo</label>
														<div class="col-md-5 inputGroupContainer">
															<div class="input-group">
																<div id="dependent-image-holder"></div>
																<input type="file" class="form-control"
																	name="uploadDependentPhoto"
																	ng-model="EmployeeMasterData.uploadDependentPhoto"
																	id="fileUpload"
																	onchange="angular.element(this).scope().uploadFile(this)"
																	accept=".png,.jpg,.jpeg" /> <br>
															</div>
															<br>
															<button class="btn btn" type="button"
																ng-click="uploadDependentProfile()">Upload</button>
														</div>
													</div>

												</div>

												<div class="col-sm-6 col-md-6 col-lg-6">

													<div class="form-group">
														<label class="col-md-4 control-label">Relationship<span
															style="color: red;"></span>
														</label>
														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																name="Relationship With Employee"
																ng-model="employeeFamilyList.relationToEmployee">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-4 control-label">Medical
															Entitlement </label>
														<div class="col-md-5">
															<textarea class="form-control"
																name="dependentMedicalEntitlement"
																ng-model="employeeFamilyList.dependentMedicalEntitlement"
																data-message-id="dependentMedicalEntitlement"
																friendly-name="Medical Entitlement"></textarea>
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label"> Dependent
															On Employee <span style="color: red;"></span>
														</label>
														<div class="radio radio-inline">
															<label class="i-checks"> <input type="radio"
																class="" name="dependentOnEmployee" ng-value="true"
																ng-model="employeeFamilyList.dependentOnEmployee">
																<i></i> Yes
															</label>
														</div>
														<div class="radio radio-inline">
															<label class="i-checks"> <input type="radio"
																class="" name="dependentOnEmployee" ng-value="false"
																ng-model="employeeFamilyList.dependentOnEmployee">
																<i></i> No
															</label>
														</div>
													</div>


												</div>
											</fieldset>
											<br>
											<fieldset class="field_set setBorder"
												style="margin-bottom: -14px;">
												<div class="form-group">
													<label class="col-md-2 control-label"><b>Passport
															Details</b> <span style="color: red;"></span></label>
												</div>
												<div class="col-sm-12 col-md-6">
													<div class="form-group">
														<label class="col-md-4 control-label">Passport No
															<span style="color: red;"></span>
														</label>

														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																name="passportNo"
																ng-model="employeeFamilyList.dependentPassportNo">
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">Issued Date<span
															style="color: red;"></span></label>
														<div class="col-md-5">
															<div class='input-group date datetimepick'>
																<div class="dropdown" style="margin-top: -15px;">
																	<a class="dropdown-toggle"
																		id="dependentPassportIssuedDate" role="button"
																		data-toggle="dropdown" data-target="#" href="#">
																		<div class="input-group">
																			<input type="text" class="form-control"
																				placeholder="dd/mm/yyyy"
																				name="dependentPassportIssuedDate"
																				data-ng-model="employeeFamilyList.dependentPassportIssuedDate"><span
																				class="input-group-addon"><i
																				class="glyphicon glyphicon-calendar"></i></span>
																		</div>
																	</a>
																	<ul class="dropdown-menu" role="menu"
																		aria-labelledby="dLabel">
																		<datetimepicker
																			data-ng-model="employeeFamilyList.dependentPassportIssuedDate"
																			data-on-set-time="employeeFamilyList.dependentPassportIssuedDate = onDateSet(newDate)"
																			data-datetimepicker-config="{ dropdownSelector: '#dependentPassportIssuedDate',startView:'day', minView:'day'}" />
																	</ul>
																</div>
															</div>
														</div>
													</div>
												</div>

												<div class="col-sm-12 col-md-6">
													<div class="form-group">
														<label class="col-md-4 control-label">Expiry Date<span
															style="color: red;"></span></label>
														<div class="col-md-5">
															<div class='input-group date datetimepick'>
																<div class="dropdown" style="margin-top: -15px;">
																	<a class="dropdown-toggle"
																		id="dependentPassportExpiryDate" role="button"
																		data-toggle="dropdown" data-target="#" href="#">
																		<div class="input-group">
																			<input type="text" class="form-control"
																				placeholder="dd/mm/yyyy" name="Expiry Date"
																				data-ng-model="employeeFamilyList.dependentPassportExpiryDate"><span
																				class="input-group-addon"><i
																				class="glyphicon glyphicon-calendar"></i></span>
																		</div>
																	</a>
																	<ul class="dropdown-menu" role="menu"
																		aria-labelledby="dLabel">
																		<datetimepicker
																			data-ng-model="employeeFamilyList.dependentPassportExpiryDate"
																			data-on-set-time="employeeFamilyList.dependentPassportExpiryDate = onDateSet(newDate)"
																			data-datetimepicker-config="{ dropdownSelector: '#dependentPassportExpiryDate',startView:'day', minView:'day'}" />
																	</ul>
																</div>
															</div>
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">Issued Place
															<span style="color: red;"></span>
														</label>

														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																name="dependentPassportIssuedPlace"
																ng-model="employeeFamilyList.dependentPassportIssuedPlace">
														</div>
													</div>
												</div>
											</fieldset>
											<br>

											<fieldset class="field_set setBorder"
												style="margin-bottom: -14px;">
												<div class="form-group">
													<label class="col-md-2 control-label"><b>VISA
															Details</b> <span style="color: red;"></span></label>
												</div>
												<div class="col-sm-12 col-md-6">
													<div class="form-group">
														<label class="col-md-4 control-label">VISA
															Reference Number <span style="color: red;"></span>
														</label>
														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																name="dependentVisaReferenceNumber"
																ng-model="employeeFamilyList.dependentVisaReferenceNumber">
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">VISA Type <span
															style="color: red;"></span></label>
														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																name="dependentVisaType"
																ng-model="employeeFamilyList.dependentVisaType">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-4 control-label">VISA Issued
															Date<span style="color: red;"></span>
														</label>
														<div class="col-md-5">
															<div class='input-group date datetimepick'>
																<div class="dropdown" style="margin-top: -15px;"
																	id="dependVisa">
																	<a class="dropdown-toggle" id="dependentVisaIssuedDate"
																		role="button" data-toggle="dropdown" data-target="#"
																		href="#">
																		<div class="input-group">
																			<input type="text" class="form-control"
																				placeholder="dd/mm/yyyy"
																				name="dependentVisaIssuedDate"
																				data-ng-model="employeeFamilyList.dependentVisaIssuedDate"><span
																				class="input-group-addon"><i
																				class="glyphicon glyphicon-calendar"></i></span>
																		</div>
																	</a>
																	<ul class="top-pad" role="menu"
																		aria-labelledby="dLabel">
																		<datetimepicker
																			data-ng-model="employeeFamilyList.dependentVisaIssuedDate"
																			data-on-set-time="employeeFamilyList.dependentVisaIssuedDate = onDateSet(newDate)"
																			data-datetimepicker-config="{ dropdownSelector: '#dependentVisaIssuedDate',startView:'day', minView:'day'}" />
																	</ul>
																</div>
															</div>
														</div>
													</div>

												</div>

												<div class="col-sm-12 col-md-6">
													<div class="form-group">
														<label class="col-md-4 control-label">VISA Expiry
															Date<span style="color: red;"></span>
														</label>

														<div class="col-md-5">
															<div class='input-group date datetimepick'>
																<div class="dropdown" style="margin-top: -15px;">
																	<a class="dropdown-toggle"
																		id="dependentVisaExpirationDate" role="button"
																		data-toggle="dropdown" data-target="#" href="#">
																		<div class="input-group">
																			<input type="text" class="form-control"
																				placeholder="dd/mm/yyyy"
																				name="dependentVisaExpirationDate"
																				data-ng-model="employeeFamilyList.dependentVisaExpirationDate"><span
																				class="input-group-addon"><i
																				class="glyphicon glyphicon-calendar"></i></span>
																		</div>
																	</a>
																	<ul class="dropdown-menu" role="menu"
																		aria-labelledby="dLabel">
																		<datetimepicker
																			data-ng-model="employeeFamilyList.dependentVisaExpirationDate"
																			data-on-set-time="employeeFamilyList.dependentVisaExpirationDate = onDateSet(newDate)"
																			data-datetimepicker-config="{ dropdownSelector: '#dependentVisaExpirationDate',startView:'day', minView:'day'}" />
																	</ul>
																</div>
															</div>
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">VISA Issued
															Place <span style="color: red;"></span>
														</label>

														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																name="dependentVisaIssuedPlace"
																ng-model="employeeFamilyList.dependentVisaIssuedPlace">
														</div>
													</div>
												</div>

											</fieldset>

										</fieldset>
										<br>
									</div>

								</div>
								<div class="row">
									<div class="col-md-12">

										<button class="btn btn-success" type="button"
											ng-if="!employeeFamilyList.isEdit"
											ng-click="saveEmpFamily(empFamilyAddForm)"
											class="btn btn-success">
											<i class="fa fa-save"></i> Save
										</button>
										<button class="btn btn-success" type="button"
											ng-if="employeeFamilyList.isEdit" class="btn btn-success"
											ng-click="updateEmpFamily(empFamilyAddForm)">
											<i class="fa fa-save"></i> Update
										</button>
										<button type="reset" class="btn btn-info"
											ng-if="!employeeFamilyList.isEdit"
											ng-click="resetEmpFamily()">
											<i class="fa fa-undo"></i> Reset
										</button>
										<button class="btn btn-danger" type="reset"
											class="btn btn-success" ng-click="empFamilycancel()">
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
			</div>
			<!-- WIDGET END -->
		</div>
		
	</section>
	
</div>