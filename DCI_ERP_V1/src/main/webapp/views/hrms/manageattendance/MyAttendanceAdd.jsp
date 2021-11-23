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
						<span class="widget-icon">
						<i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="myAttendanceForm"
								>
								<div class="row">
								
								<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
										<fieldset>
										<div class="col-sm-6 col-md-6 col-lg-6">
											
											 <div class="form-group">
												<label class="col-md-5 control-label">Company Name
												<span
													style="color: red;"></span></label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="Hospital" ng-model="MyAttendanceMasterData.hospitalName" readonly>
												</div>
											</div><!-- <p>{{myAttendanceList.hospitalName}}</p> -->
											
											<div class="form-group ">
												<label class="col-md-5 control-label">Department
													</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="Department" ng-model="MyAttendanceMasterData.departmentCode" readonly>

												</div>
											</div>

												<div class="form-group ">
													<label class="col-md-5 control-label">Employee Name</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm"
															name="Employee Name"
															ng-model="MyAttendanceMasterData.employeeName" readonly>

													</div>
												</div>

												<!-- <div class="form-group " id="in">
													<label class="col-md-5 control-label">Shift In Time</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm" 
															name="In Time" ng-model="MyAttendanceMasterData.inTime"
															readonly>

													</div>
												</div> -->
												
												<div class="form-group">
											<label class="col-md-5 control-label" >Shift In Time</label>
						             		<div class="col-md-5">
								             	<div class="dropdown">
								               		<a class="dropdown-toggle" id="shiftinTimeValidate" role="button"
								               		
								                		data-toggle="dropdown" data-target="#" href="#">
										             <div class="input-group" >
										                 <input type="text" class="form-control" placeholder="hh:mm" name="Shift In Time" id="shiftinTime"										                 											                 	 
										                  	data-ng-model="MyAttendanceMasterData.inTime" disabled><span
										                  	class="input-group-addon"><i
										                  	class="glyphicon glyphicon-time"></i></span>
										             </div>
								               		</a>
<!-- 									               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel"> -->
<!-- 									                	<datetimepicker data-ng-model="MyAttendanceMasterData.inTime" data-on-set-time="MyAttendanceMasterData.inTime = onTimeSet(newDate)" -->
<!-- 									                 		data-datetimepicker-config="{ dropdownSelector: '#shiftinTimeValidate',startView:'hour', minView:'minute'}" /> -->
<!-- 									               </ul> -->
								            	</div>
						             		</div>											
											</div>
												
												
												<div class="form-group">	
													<div class="radio radio-inline col-md-offset-5" ng-init="attendance='single'">
														<label class="i-checks"> <input type="radio"
															class="radiobox style-0" id="Attendance"
															ng-model="attendance" value="single"
															checked="checked" name="Attendance"> <i></i>In Time
														</label>
													</div>
												</div>
												<div class="form-group" ng-if="attendance=='single'">
											<label class="col-md-5 control-label" > In Time</label>
						             		<div class="col-md-5">
								             	<div class="dropdown">
								               		<a class="dropdown-toggle" id="shiftmyinTimeValidate" role="button"
								               		
								                		data-toggle="dropdown" data-target="#" href="#">
										             <div class="input-group" >
										                 <input type="text" class="form-control" placeholder="hh:mm" name="Shift In Time" id="shiftmyinTime"										                 											                 	 
										                  	data-ng-model="MyAttendanceMasterData.myInTime" disabled><span
										                  	class="input-group-addon"><i
										                  	class="glyphicon glyphicon-time"></i></span>
										             </div>
								               		</a>
<!-- 									               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel"> -->
<!-- 									                	<datetimepicker data-ng-model="MyAttendanceMasterData.myInTime" data-on-set-time="MyAttendanceMasterData.myInTime = onTimeSet(newDate)" -->
<!-- 									                 		data-datetimepicker-config="{ dropdownSelector: '#shiftmyinTimeValidate',startView:'hour', minView:'minute'}" /> -->
<!-- 									               </ul> -->
								            	</div>
						             		</div>											
											</div>

											</div>

											<div class="col-sm-6 col-md-6 col-lg-6">

												<div class="form-group ">
													<label class="col-md-5 control-label">Branch</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm"
															name="Branch" ng-model="MyAttendanceMasterData.branchName"
															readonly>

													</div>
												</div>

												<div class="form-group ">
													<label class="col-md-5 control-label">Shift Name</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm"
															name="Shift" ng-model="MyAttendanceMasterData.shiftName"
															readonly>

													</div>
												</div>
												
												

												<!-- <div class="form-group ">
													<label class="col-md-5 control-label">Date</label>
													<div class="col-md-5">
														<input type="text" class="form-control input-sm"
															name="Date" ng-model="MyAttendanceMasterData.attendanceDate" readonly>

													</div>
												</div> -->
												
												<div class="form-group">
													<label class="col-md-5 control-label">Attendance Date</label>
													<div class="col-md-5">
														<div class='input-group date datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="attendanceDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="Attendance Date"
																			id="attendanceDate"
																			data-message-id="attendanceDate" data-validator="required" data-valid-method="submit"
																			data-ng-model="MyAttendanceMasterData.attendanceDate" disabled><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
<!-- 																<ul class="dropdown-menu" role="menu" -->
<!-- 																	aria-labelledby="dLabel"> -->
<!-- 																	<datetimepicker -->
<!-- 																		data-ng-model="MyAttendanceMasterData.attendanceDate" -->
<!-- 																		data-on-set-time="MyAttendanceMasterData.attendanceDate = onDateSet(newDate)" -->
<!-- 																		data-datetimepicker-config="{ dropdownSelector: '#attendanceDate',startView:'day', minView:'day'}" /> -->
<!-- 																</ul> -->
															</div>
														</div>
													</div>
												</div>

												
											<div class="form-group" >
											<label class="col-md-5 control-label" >Shift Out Time</label>
						             		<div class="col-md-5">
								             	<div class="dropdown">
								               		<a class="dropdown-toggle" id="shiftoutTimeValidate" role="button"
								               		
								                		data-toggle="dropdown" data-target="#" href="#">
										             <div class="input-group" >
										                 <input type="text" class="form-control" placeholder="hh:mm" name="Shift Out Time" id="shiftoutTime"										                 											                 	 
										                  	data-ng-model="MyAttendanceMasterData.outTime" disabled><span
										                  	class="input-group-addon"><i
										                  	class="glyphicon glyphicon-time"></i></span>
										             </div>
								               		</a>
<!-- 									               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel"> -->
<!-- 									                	<datetimepicker data-ng-model="MyAttendanceMasterData.outTime" data-on-set-time="MyAttendanceMasterData.outTime = onTimeSet(newDate)" -->
<!-- 									                 		data-datetimepicker-config="{ dropdownSelector: '#shiftoutTimeValidate',startView:'hour', minView:'minute'}" /> -->
<!-- 									               </ul> -->
								            	</div>
						             		</div>											
											</div>
												
												<div class="form-group">	
												<div class="radio radio-inline col-md-offset-5">
														<label class="i-checks"> <input type="radio"
															class="radiobox style-0" id="Attendance"
															ng-model="attendance" value="multiple"
															checked="checked" name="Attendance"> <i></i>Out Time
														</label>
													</div>
												</div>
												<div class="form-group" ng-if="attendance=='multiple'">
											<label class="col-md-5 control-label" > Out Time</label>
						             		<div class="col-md-5">
								             	<div class="dropdown">
								               		<a class="dropdown-toggle" id="shiftmyoutTimeValidate" role="button"
								               		
								                		data-toggle="dropdown" data-target="#" href="#">
										             <div class="input-group" >
										                 <input type="text" class="form-control" placeholder="hh:mm" name="Shift Out Time" id="shiftmyoutTime"										                 											                 	 
										                  	data-ng-model="MyAttendanceMasterData.myOutTime" disabled><span
										                  	class="input-group-addon"><i
										                  	class="glyphicon glyphicon-time"></i></span>
										             </div>
								               		</a>
<!-- 									               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel"> -->
<!-- 									                	<datetimepicker data-ng-model="MyAttendanceMasterData.myOutTime" data-on-set-time="MyAttendanceMasterData.myOutTime = onTimeSet(newDate)" -->
<!-- 									                 		data-datetimepicker-config="{ dropdownSelector: '#shiftmyOutTimeValidate',startView:'hour', minView:'minute'}" /> -->
<!-- 									               </ul> -->
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
											<button type="button" class="btn btn-success" ng-if="attendance=='single'" ng-disabled="MyAttendanceMasterData.checkIn!='' && MyAttendanceMasterData.checkOut!='' || MyAttendanceMasterData.checkIn!='' && MyAttendanceMasterData.checkOut==''"
												ng-click="submitIn(myAttendanceForm,MyAttendanceMasterData)">
												<i class="fa fa-save"></i> Save
											</button>
											<button type="button" class="btn btn-success" ng-if="attendance=='multiple'" ng-disabled="MyAttendanceMasterData.checkIn!='' && MyAttendanceMasterData.checkOut!=''"
												ng-click="submitOut(myAttendanceForm,MyAttendanceMasterData)">
												<i class="fa fa-save"></i> Save
											</button>
											<button class="btn btn-danger" type="button"
										data-ng-click="cancel();">
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
