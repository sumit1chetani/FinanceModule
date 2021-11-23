<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="row book-widget-row" style="padding-bottom: 12px;">
						<form class="form-horizontal" name="hrmanageAttendanceForm">
							<!-- Form field start -->
							<div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
									<div class="col-sm-4 col-md-4 col-lg-4">
										<div class="form-group">
											<label class="col-md-5 control-label"> Year</label>
											<div class="col-md-7">
													<!--  <input type="text" disabled class="form-control input-sm"
														ng-model="hrmanageAttendance.acadamicYear"> -->
														
														<selectivity list="academicYearList" disabled="isShow"
														property="hrmanageAttendance.acadamicYear" 
														ng-model="hrmanageAttendance.acadamicYear" name="Academic Year"
														form-name="hrmanageAttendanceForm" 
														friendly-name="Year"></selectivity>
														 
											</div>
										</div>
										
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
										<div class="form-group">
											<label class="col-md-5 control-label">Department</label>
											<div class="col-md-7">
												<selectivity list="departmentList"
													property="hrmanageAttendance.departmentId" 
													id="departmentId"  disabled="isShow"
													ng-model="hrmanageAttendance.departmentId" 
													name="departmentId" form-name="hrmanageAttendanceForm"
													validation="required" friendly-name="Department"></selectivity>
											</div>
										</div>
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">

										<!-- <div class="form-group">
											<label class="col-md-5 control-label">Attendance Date</label>
											<div class="col-md-7" >
												<div class='input-group date datetimepick col-md-12'>
													<div class="dropdown">
														<a data-toggle="dropdown" class="dropdown-toggle"
															id="attendanceDate" role="button" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"  
																friendly-name="Date" ng-disabled="isShow"
																	placeholder="dd/mm/yyyy" name="attendanceDate" validation="required"
																	data-ng-model="hrmanageAttendance.attendanceDate"> <span
																	class="input-group-addon"> <i
																	class="glyphicon glyphicon-calendar"></i>
																</span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="hrmanageAttendance.attendanceDate"
																data-on-set-time="hrmanageAttendance.attendanceDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#attendanceDate',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
										</div> -->
										
										
										  
          <div class="form-group">
								<label class="col-md-5 control-label">Attendance Date<span
									style="color: red;">*</span></label>

								<div class="col-md-7">
									<ng-bs3-datepicker data-ng-model="hrmanageAttendance.attendanceDate"
										id="attendanceDate" name="attendanceDate" form-name="attendanceDate" friendly-name="attendanceDate"
										validation="required" />
								</div>
							</div>
										<div>
									
								</div>
								
				
							</div>
							<br>
							<div class="form-group">
									<label class="col-md-5 control-label"></label>
									<div class="col-md-7">
										<button ng-click="viewList()" class="btn btn-sm btn-primary"
											tooltip="View List" type="button" ng-disabled="isShow">
											View List</button>
									</div>
								</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<%@taglib uri="http://www.springframework.org/tags"
							prefix="spring"%>
						<%@ taglib prefix="security"
							uri="http://www.springframework.org/security/tags"%>
						<div id="content">
							<!-- widget grid -->
							<section id="widget-grid" data-widget-grid>
								<div class="row">
									<article class="col-sm-12">
										<div data-jarvis-widget id="standard-datatable-widget">
											<div role="content">
												<div class="widget-body no-padding">
													<div
														class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
														st-table="displayedCollection" 
														 data-st-safe-src="hrmanageAttendance.lHrManageAttendanceEmployee">
														<div class="dt-toolbar">
															<table id="dt_basic"
																class="table table-striped table-bordered table-hover dataTable no-footer"
																role="grid" aria-describedby="dt_basic_info">
																<thead class="dataTables-Main-Head">
																	<tr>
																		<th class="sorting width_1">Employee Id</th>
																		<th class="sorting width_2">Employee Name</th>
																		<th class="sorting width_5"><label
																			class="i-checks m-b-none"> <input
																				type="checkbox" ng-model="checkFull"
																				ng-click="makeTrue()"> <i></i>
																		</label>Attendance</th>
																		
																		
																		<th class="sorting width_5"><label
																			class="i-checks m-b-none"> <input
																				type="checkbox" ng-model="checkFull1"
																				ng-click="makeTrue1()"> <i></i>
																		</label>On Duty</th>
																		
																			
																		<th class="sorting width_3">Remarks</th>
																	</tr>
																</thead>
																<tbody class="dataTables-Main-Body">
																	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																		data-ng-repeat="hrmanageAttendanceList in displayedCollection">
																		<td>{{hrmanageAttendanceList.employeeId}}</td>
																		<td>{{hrmanageAttendanceList.firstName}}</td>
																		
																		<td><div class="checkbox">
																				<label class="i-checks"><input
																					type="checkbox"
																					ng-model='hrmanageAttendanceList.attendance'><i></i></label>
																			</div></td>
																		<td><div class="checkbox">
																				<label class="i-checks"><input
																					type="checkbox"
																					ng-model='hrmanageAttendanceList.onDuty'><i></i></label>
																			</div></td>


																		<td><div class="col-md-12">
																				<input type="text" class="form-control input-sm"
																					id="remarks"
																					ng-model="hrmanageAttendanceList.remarks"
																					friendly-name="Remarks" name="Remarks">
																			</div></td>

																	</tr>
																</tbody>
															</table>
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
					</div>
				</div>
				<!-- Smart Table -->
				<!-- Form field end -->
				<!-- Button Action Div Start-->
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="submit"
								data-ng-click="validate(hrmanageAttendance,hrmanageAttendanceForm,hrmanageAttendanceList)"
								data-ng-if="!isEdit">
								<i class="fa fa-save"></i>
								Save
							</button>
							<button class="btn btn-success" type="submit"
								data-ng-click="updateManageAtten(hrmanageAttendance,hrmanageAttendanceForm,hrmanageAttendanceList)"
								data-ng-if="isEdit">
								<i class="fa fa-save"></i>
							Update
							</button>
							<button class="btn btn-info ng-scope" type="button"
								class="btn btn-success" ng-click="reset()">
								<i class="fa fa-undo"></i>
								Reset
							</button>
							<button class="btn btn-danger" type="button"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i>
							Cancel
							</button>
						</div>
					</div>
				</div>
				<!-- Button Action Div End-->
				</form>
				<!-- Form end -->
		</div>
	</div>
</div>
