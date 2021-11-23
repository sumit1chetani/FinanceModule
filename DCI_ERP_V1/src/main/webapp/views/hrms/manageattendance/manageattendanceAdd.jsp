<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="attendanceAddForm"
								role="form" ng-submit="#" novalidate>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
										<fieldset>
											<div class="col-sm-6 col-md-6 col-lg-6">

												 <div class="form-group">
													<label class="col-md-5 control-label">Company Name<span
														style="color: red;"></span></label> <input type="hidden"
														value="${form_code}" id="formCode" />
													<div class="col-md-5">

														<selectivity list="companyList"
															ng-if="!AttendanceMasterData.isEdit"
															property="AttendanceMasterData.hospitalName"
															id="hospitalName" name="company Name"
															friendly-name="Hospital Name"
															ng-model="AttendanceMasterData.hospitalName" >
														</selectivity>
														<selectivity list="companyList"
															ng-if="AttendanceMasterData.isEdit"
															property="AttendanceMasterData.hospitalName"
															id="hospitalName" name="hospitalName"
															friendly-name="Hospital Name"
															ng-model="AttendanceMasterData.hospitalName"
															> </selectivity>


													</div>
												</div>




												<div class="form-group">
													<label class="col-md-5 control-label">Attendance</label>
													<div class="col-md-5 control-label-left"
														ng-init="attendance='single'">
														<label class="radio-inline"><input type="radio"
															name="Attendance"
															class="ng-pristine ng-untouched ng-valid" value="single"
															ng-model="attendance"><label class="col-md-5 control-label">single</label> </label>
													</div>
												</div>
												<div class="form-group"
											>
													<div class="col-md-5 col-md-offset-5 control-label-left"
														ng-init="attendance='single'">
														<label class="radio-inline"> <input type="radio"
															name="Attendance"
															class="ng-pristine ng-untouched ng-valid"
															value="multiple" ng-model="attendance"> <label class="col-md-5 control-label">Multiple</label></label>
													</div>
												</div>



											
												
												
												     
								<div class="form-group">
									<label class="col-md-5 control-label">In Time<span
										style="color: red;"> *</span></label>
									<div class="col-md-5 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="inTime" name="inTime" 
           ng-model="AttendanceMasterData.inTime" validation="required" friendly-name="inTime"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>

												<div class="form-group ">
													<label class="col-md-5 control-label">Department</label>
													<div class="col-md-5">
														<selectivity list="departmentList"
															ng-if="!AttendanceMasterData.isEdit"
															property="AttendanceMasterData.departmentId"
															id="departmentId" name="departmentId"
															friendly-name="Department Name"
															ng-model="AttendanceMasterData.departmentId">
														</selectivity>

														<input ng-if="AttendanceMasterData.isEdit" type="text"
															class="form-control"
															ng-model="AttendanceMasterData.departmentCode" readonly>

													</div>
												</div>


												<div class="form-group">
													<label class="col-md-5 control-label">Shift In Time</label>
													<div class="col-md-5">
														<div class="dropdown">
															<a class="dropdown-toggle" id="shiftinTimeValidate"
																role="button" data-toggle="dropdown" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="hh:mm" name="Shift In Time"
																		id="shiftinTime"
																		data-ng-model="AttendanceMasterData.shiftInTime"
																		disabled><span class="input-group-addon"><i
																		class="glyphicon glyphicon-time"></i></span>
																</div>
															</a>
																		</div>
													</div>
												</div>

											</div>


											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-5 control-label">Branch<span
														style="color: red;"></span></label>
													<div class="col-md-5">
														<selectivity list="branchList"
															ng-if="!AttendanceMasterData.isEdit"
															property="AttendanceMasterData.branchName"
															id="branchName" name="branchName"
															friendly-name="Branch Name"
															ng-model="AttendanceMasterData.branchName">
														</selectivity>
														<selectivity list="branchList"
															ng-if="AttendanceMasterData.isEdit"
															property="AttendanceMasterData.branchName"
															id="branchName" name="branchName"
															friendly-name="Branch Name"
															ng-model="AttendanceMasterData.branchName"
															disabled="true"> </selectivity>

													</div>
												</div>

											
												
												      <div class="form-group" >
					             	<label class="col-md-5 control-label">Attendance
														Date From </label>
					             	   <div class="col-md-5">
					             	   <ng-bs3-datepicker data-ng-model="AttendanceMasterData.attendanceDate"
										id="attendanceDate" name="attendanceDate" form-name="attendanceDate" friendly-name="attendanceDate"
										validation="required" />
					               			
					             	</div>
					          </div>
					          

												
												
												 <div class="form-group">
										<div ng-show="attendance=='multiple'">
												 
					             	<label class="col-md-5 control-label">TO Date </label>
					             	   <div class="col-md-5">
					             	    <ng-bs3-datepicker data-ng-model="AttendanceMasterData.toDate"
										id="toDate" name="toDate" form-name="toDate" friendly-name="toDate"
										validation="required" />
					               				</div>
					           				</div>
					             	</div>
											
												
												
																	     
								<div class="form-group">
									<label class="col-md-5 control-label">Out Time<span
										style="color: red;"> *</span></label>
									<div class="col-md-5 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="outTime" name="outTime" 
           ng-model="AttendanceMasterData.outTime" validation="required" friendly-name="outTime"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>
</div>
									</div>
												<div class="form-group">
													<label class="col-md-5 control-label">Shift<span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-5">
														<selectivity ng-if="!AttendanceMasterData.isEdit"
															list="shiftList" property="AttendanceMasterData.shiftId"
															id="shiftId" ng-model="AttendanceMasterData.shiftId"
															name="shiftId" form-name="attendanceAddForm"
															validation="required" friendly-name="Shift Name"></selectivity>

														<input ng-if="AttendanceMasterData.isEdit" type="text"
															class="form-control"
															ng-model="AttendanceMasterData.shiftName" readonly>


														

													</div>
												</div>


												<div class="form-group">
													<label class="col-md-5 control-label">Shift Out
														Time</label>
													<div class="col-md-5">
														<div class="dropdown">
															<a class="dropdown-toggle" id="shiftoutTimeValidate"
																role="button" data-toggle="dropdown" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="hh:mm" name="Shift Out Time"
																		id="shiftOutTime"
																		data-ng-model="AttendanceMasterData.shiftOutTime"
																		disabled><span class="input-group-addon"><i
																		class="glyphicon glyphicon-time"></i></span>
																</div>
															</a>
														
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
											<button type="button" class="btn btn-success"
												ng-if="!AttendanceMasterData.isEdit"
												ng-click="submit(attendanceAddForm,AttendanceMasterData)">
												<i class="fa fa-save"></i> Save
											</button>
											<button class="btn btn-success" type="button"
												ng-if="AttendanceMasterData.isEdit" class="btn btn-success"
												ng-click="update(attendanceAddForm,AttendanceMasterData)">
												<i class="fa fa-save"></i> Update
											</button>

											<button class="btn btn-info" type="button"
												data-ng-click="reset(attendanceAddForm)">
												<i class="fa fa-undo"></i> Reset
											</button>
											<button class="btn btn-danger" type="button"
												data-ng-click="cancel();">
												<i class="fa fa-close"></i> Cancel
											</button>
										</div>
									</div>
								</div>
								<div class="col-sm-12 col-md-12 col-lg-12">
									<label class="col-md-7 col-md-offset-3 control-label-left"><span
										style="color: red;">*</span>Attendanace For Employee</label>
								</div>
							</form>
						</div>
						<!-- end widget content -->
					</div>
	</div>
</div>
