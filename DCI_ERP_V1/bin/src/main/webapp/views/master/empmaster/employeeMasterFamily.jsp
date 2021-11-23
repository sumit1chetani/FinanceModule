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
			<article class="col-sm-12">
			<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="familyForm">
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
													<label class="col-md-2 control-label"><b>Members
															Details</b> <span style="color: red;"></span></label>
												</div>
												<div class="col-sm-6 col-md-6 col-lg-6">
													<div class="form-group">
														<label class="col-md-4 control-label">Relative
															Name<span style="color: red;">*</span>
														</label>
														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																name="Family Name"
																ng-model="EmployeeMasterDataFam.relativeName"
																data-message-id="relativeName" validation="required"
																maxlength="50" friendly-name="Relative Name"
																form-name="familyForm">
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">Gender<span
															style="color: red;">*</span></label>
														<div class="col-md-5">
															<select class="form-control journalVoucher-textBox"
																name="Gender in Family"
																ng-model="EmployeeMasterDataFam.sex"
																data-message-id="sex" validation="required"
																friendly-name="Gender">
																<option value="">--Select--</option>
																<option value="Male">Male</option>
																<option value="Female">Female</option>
															</select>
														</div>
													</div>

						<!-- 							<div class="form-group">
														<label class="col-md-4 control-label">DOB</label>
														<div class="col-md-5 inputGroupContainer">
															<ng-bs3-datepicker
																data-ng-model="EmployeeMasterDataFam.dependentDob"
																id="dependentDob" name="dependentDob" form-name="toForm"
																friendly-name="dependentDob" />

														</div>
													</div> -->

													<div class="form-group">
														<label class="col-md-4 control-label">Upload Photo</label>
														<div class="col-md-5 inputGroupContainer">
															<div class="input-group">
																<img src="{{EmployeeMasterDataFam.dependentPhotoUrl}}"
																	class="thumb-image1" style="width: 200px;">
																<div id="dependent-image-holder">
																	<!-- <img id="depImg" src="" alt="" style="width: 200px;">  -->
																</div>
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
																name="Relationship With Employee" maxlength="20"
																ng-model="EmployeeMasterDataFam.relationToEmployee">
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-4 control-label">Aadhar No</label>
														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																 friendly-name="Aadhar No"
																name="aadharno1"
																ng-model="EmployeeMasterDataFam.aadharno1"
																form-name="familyForm" maxlength="30"
																data-message-id="aadharno1"
																ng-pattern-restrict="^[0-9.]*$">
														</div>

													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">MOBILE NO<span
															style="color: red;"></span>
														</label>
														<div class="col-md-5 inputGroupContainer">
															<input type="text" class="form-control input-sm"
																name="mobileno"
																ng-model="EmployeeMasterDataFam.mobileno" maxlength="20"
																ng-pattern-restrict="^[0-9.]*$">
														</div>
													</div>


													<div class="form-group">
														<label class="col-md-4 control-label"> Dependent
															On Employee <span style="color: red;"></span>
														</label>
														<div class="radio radio-inline">
															<label class="i-checks"> <input type="radio"
																class="" name="dependentOnEmployee" ng-value="true"
																ng-model="EmployeeMasterDataFam.dependentOnEmployee">
																<i></i> Yes
															</label>
														</div>
														<div class="radio radio-inline">
															<label class="i-checks"> <input type="radio"
																class="" name="dependentOnEmployee" ng-value="false"
																ng-model="EmployeeMasterDataFam.dependentOnEmployee">
																<i></i> No
															</label>
														</div>
													</div>


												</div>
											</fieldset>
											<br>

										</fieldset>
										<br>
									</div>

								</div>

								<div class="row" align="center">
									<div class="col-md-12">

										<button class="btn btn-success" type="button"
											ng-if="!ispopEdit"
											ng-click="validateFamily(EmployeeMasterDataFam,familyForm)"
											class="btn btn-success">
											<i class="fa fa-save"></i> Save
										</button>
										<button class="btn btn-success" type="button"
											ng-if="ispopEdit" class="btn btn-success"
											ng-click="validateFamily(EmployeeMasterDataFam,familyForm)">
											<i class="fa fa-save"></i> Update
										</button>
										<button type="reset" class="btn btn-info" ng-if="!ispopEdit" type="button"
											ng-click="resetEmpFamily()">
											<i class="fa fa-undo"></i> Reset
										</button>
										<button class="btn btn-danger" type="reset"
											class="btn btn-success" ng-click="cancelEmployeeFamily()">
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
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>