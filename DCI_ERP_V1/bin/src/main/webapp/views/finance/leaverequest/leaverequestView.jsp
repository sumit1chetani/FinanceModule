<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>



		<div role="content">
			<div class="widget-body">
				<div
					class="dataTables_wrapper for-inline dt-bootstrap no-footer ui-corner-all"
					st-table="displayedCollection" st-safe-src="rowCollection">
					<form class="form-horizontal" name="leaveReqAddForm" role="form">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
								<fieldset>
									<div class="col-sm-6 col-md-6 col-lg-6">
										<div class="form-group">
											<label class="col-md-5 control-label">Employee No </label>
											<div class="col-md-6">
												<!-- 				             							<select class="form-control input-sm" ng-model="leaveRequestObj.empId" ng-change="employeeChange(leaveRequestObj.empId)" -->
												<!-- 				             							ng-options="emp.empId as emp.empName for emp in getEmployeeList" id="employeeId"> -->
												<!-- 															<option value="">Select</option> -->
												<!-- 														</select> -->
												<input type="text" class="form-control input-sm"
													name="empId" ng-model="leaveRequestObj.empId" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">Company Name </label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="company" ng-model="leaveRequestObj.company" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">Department</label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="department" ng-model="leaveRequestObj.department"
													readonly>
											</div>
										</div>
										<div class="form-group" id="radionId">
											<label class="col-md-5 control-label">Type</label>
											<div class="col-md-7" style="margin-top: 5px;">

												<div class="radio radio-inline"
													ng-init="leaveRequestObj.leaveRadio=1">
													<label class="i-checks"> <input checked
														type="radio" name="leave1"
														ng-model="leaveRequestObj.leaveRadio" id="leaveRadio"
														ng-value="1" ng-click=leavechange()> <i></i>Leave
													</label> <label class="i-checks col-md-offset-1"
														ng-if="leaveRequestObj.isEdit"> <input checked
														type="radio" name="leave2"
														ng-model="leaveRequestObj.leaveRadio" id="holidayRadio"
														ng-value="2" ng-click=holiday()> <i></i> CPL
													</label> <label class="i-checks col-md-offset-1"
														ng-if="!leaveRequestObj.isEdit"> <input checked
														type="radio" name="leave3"
														ng-model="leaveRequestObj.leaveRadio" id="clCpl"
														ng-value="3" ng-click=clCplChange()> <i></i> CL &
														CPL
													</label> <label class="i-checks col-md-offset-1"> <input
														type="radio" name="leave4"
														ng-model="leaveRequestObj.leaveRadio" id="isMl"
														ng-value="4"> <i></i> Medical
														Leave
													</label>
												</div>



											</div>

										</div>




									</div>
									<div class="col-sm-6 col-md-6 col-lg-6">
										<div class="form-group">

											<label class="col-md-4 control-label">Employee Name </label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="employeeName" ng-model="leaveRequestObj.empName"
													readonly>
												<!-- 														<select class="form-control input-sm" ng-model="leaveRequestObj.empId"> -->
												<!-- 															<option value="">Select</option> -->
												<!-- 														</select>  -->
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Branch </label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="branch" ng-model="leaveRequestObj.branch" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Grade </label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="grade" ng-model="leaveRequestObj.grade" readonly>
											</div>
										</div>
										<div class="form-group" ng-show="alternative">
											<label class="col-md-4 control-label">Alternative
												Employee </label>
											<div class="col-md-6">
												<selectivity list="alternativeList"
													property="leaveRequestObj.alternativeEmp"
													name="Alternative Employee"
													ng-model="leaveRequestObj.alternativeEmp"></selectivity>
												<!-- 						           					<select class="form-control" ng-model="leaveRequestObj.alternativeEmp" ng-options="emp.id as emp.text for emp in alternativeList"> -->
												<!-- 										   				 <option value="">--Select--</option> -->
												<!-- 													</select> -->
											</div>
										</div>
										<div class="form-group" ng-show="alternative">
											<label class="col-md-4 control-label"> If Any
												Alternative Duty Agreed </label>
											<div class="col-md-6" style="border: 0px solid red">
												<textarea class="form-control input-sm"
													name="Alternative Duty Agreed" id="dutyAgreed" rows="3"
													data-ng-model="leaveRequestObj.dutyAgreed"
													style="resize: none"></textarea>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-10 col-md-offset-1">
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info"
									ng-show="leaveRequestObj.leaveRadio===1 && leaveRequestObj.leaveRadio!=4">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="sorting width_10" st-sort="leaveName">Leave
												Name</th>
											<th class="sorting width_10" st-sort="leaveAvailable">Leave
												Available</th>
											<th class="sorting width_10" st-sort="leaveAvailed">Leave
												Availed</th>
											<th class="sorting width_10" st-sort="leaveBalance">Leave
												Balance</th>
											<th class="width_10" st-sort="select">Select</th>
										</tr>
									</thead>
									<tbody>
										<tr ng-repeat="row in leaveList"
											ng-hide="row.shortName == 'ML'">
											<td style="text-align: left"><input type="text"
												ng-model="row.shortName" readonly /></td>
											<td style="text-align: left"><input type="text"
												ng-model="row.allowedLeave" ng-if="row.shortName!='PL'"
												readonly /></td>
											<td style="text-align: left"><input type="text"
												ng-model="row.consumed" ng-if="row.shortName!='PL'" readonly /></td>
											<td style="text-align: left"><input type="text"
												ng-model="row.balance" ng-if="row.shortName!='PL'" readonly /></td>
											<td>
												<div class="radio radio-inline">
													<label class="i-checks"> <input type="radio"
														name="selected" ng-model="row.select" ng-value="$index"
														ng-focus=modify($index,leaveList)
														ng-disabled="editRequest"> <i></i>

													</label>
												</div>
											</td>
										</tr>
									</tbody>
								</table>


								<!-- Added By Kathir for ML Leave -->

								<table id="dt_basic"
									class="table width_100 table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info"
									style="overflow-y: auto; height: 20%"
									ng-show="leaveRequestObj.leaveRadio===4 || !leaveRequestObj.leaveRadio===1 || !leaveRequestObj.leaveRadio===2 || !leaveRequestObj.leaveRadio===3 ">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="sorting width_10" st-sort="leaveName">leave
												Name</th>
											<th class="sorting width_10" st-sort="leaveAvailable">Leave
												Available</th>
											<th class="sorting width_10" st-sort="leaveAvailed">Tentative
												Days</th>
											<th class="sorting width_10" st-sort="leaveBalance">Tentative
												Balance</th>
											<th class="width_10" st-sort="select" ng-hide="editRequest">Select</th>
										</tr>
									</thead>
									<tbody>
										<tr ng-repeat="row in leaveList"
											ng-show="row.shortName == 'ML'">
											<td style="text-align: left"><input type="text"
												ng-model="row.shortName" readonly /></td>
											<td style="text-align: left"><input type="text"
												ng-model="row.allowedLeave" readonly /></td>
											<td style="text-align: left"><input type="text"
												ng-model="row.consumed" readonly /></td>
											<td style="text-align: left"><input type="text"
												ng-model="row.balance" readonly /></td>
											<td ng-hide="editRequest">
												<div class="radio radio-inline">
													<label class="i-checks"> <input type="radio"
														name="selected" ng-model="row.select" ng-value="$index"
														ng-focus=modify($index,leaveList)> <i></i>
													</label>
												</div>
											</td>
										</tr>
									</tbody>
								</table>


								<div st-table="displayedCollection" st-safe-src="holidayList"
									ng-show="leaveRequestObj.leaveRadio===2">

									<table id="dt_basic"
										class="table width_100 table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info"
										style="overflow-y: auto; height: 20%">
										<thead class="dataTables-Main-Head">
											<tr>
												<th class="width_18 text-center">Leave Name</th>
												<th class="width_18 text-center">CPL Overall Count</th>
												<th class="width_18 text-center">Leave Limit per year</th>
												<th class="width_15 text-center">Leave Taken</th>
												<th class="width_15 text-center">Leave Balance</th>
											</tr>
										</thead>
										<tbody>
											<tr ng-repeat="holidayLeave in holidayLeaveList">
												<td style="text-align: center"><input type="text"
													ng-model="holidayLeave.leaveName" readonly /></td>
												<td style="text-align: center"><input type="text"
													ng-model="holidayLeave.allowedLeave" readonly /></td>
												<td style="text-align: center"><input type="text"
													value="20" readonly /></td>
												<td style="text-align: center"><input type="text"
													ng-model="holidayLeave.consumed" readonly /></td>
												<td style="text-align: center"><input type="text"
													ng-model="holidayLeave.balance" readonly /></td>
											</tr>
										</tbody>
									</table>
									<br>



								</div>

								<div ng-show="leaveRequestObj.leaveRadio===3">
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>
												<th class="sorting width_10" st-sort="leaveName">Leave
													Name</th>
												<th class="sorting width_10" st-sort="leaveAvailable">Leave
													Available</th>
												<th class="sorting width_10" st-sort="leaveAvailed">Leave
													Availed</th>
												<th class="sorting width_10" st-sort="leaveBalance">Leave
													Balance</th>
												<th class="width_10" st-sort="select" ng-hide="editRequest">Select</th>
											</tr>
										</thead>
										<tbody>
											<tr ng-repeat="row in clList">
												<td style="text-align: left"><input type="text"
													ng-model="row.shortName" readonly /></td>
												<td style="text-align: left"><input type="text"
													ng-model="row.allowedLeave" readonly /></td>
												<td style="text-align: left"><input type="text"
													ng-model="row.consumed" readonly /></td>
												<td style="text-align: left"><input type="text"
													ng-model="row.balance" readonly /></td>
												<!-- 							         	 <td><input ng-checked="true" type="radio"name="select" ng-value="row.shortName" ng-model="$leaveRequestObj.selectedPerson"  ></td> -->
												<!-- 							         	<td ng-hide><input type="text"  ng-model="row.selctRow"></td> -->
												<!-- 							         	<td><input type="radio" name="selected" ng-model="row.select" ng-value="$index" ng-focus=modify($index,leaveList) ></td> -->
												<td style="text-align: center">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0" ng-model="row.select"
															ng-change="clModify($index,clList)"> <span></span>
														</label>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12"
								ng-if="leaveRequestObj.leaveRadio===3">
								<!-- 							     <div class="col-md-12 col-md-12 col-lg-12"> -->
								<div class="col-md-6">
									<div class="form-group">
										<label class="col-md-5 control-label">CL From Date <span
											style="color: red;" ng-if="clLeave">*</span>
										</label>
										<div class="col-md-6">


											<ng-bs3-datepicker data-ng-model="leaveRequestObj.clFromDate"
												id="clFromDate" name="clFromDate"
												form-name="leaveReqAddForm" friendly-name="clFromDate"
												ng-disabled="!clLeave" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label">No. Of Days for
											CL </label>
										<div class="col-md-6">
											<input type="text" class="form-control input-sm"
												name="No. Of Days for CL"
												ng-model="leaveRequestObj.clLeaveDays" disabled>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="col-md-4 control-label">CL To Date <span
											style="color: red;" ng-if="clLeave">*</span>
										</label>
										<div class="col-md-6">


											<ng-bs3-datepicker data-ng-model="leaveRequestObj.clToDate"
												id="clToDate" name="clFromDate" form-name="leaveReqAddForm"
												friendly-name="clToDate" ng-disabled="!clLeave" />
										</div>
									</div>
								</div>
								<!-- 								 </div> -->
								<br>
							</div>
							<div class="col-md-10 col-md-offset-1">
								<div st-table="displayedCollection" st-safe-src="holidayList"
									ng-show="leaveRequestObj.leaveRadio===3">
									<table id="dt_basic"
										class="table width_100 table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info"
										style="overflow-y: auto; height: 20%">
										<thead class="dataTables-Main-Head">
											<tr>
												<th class="width_18 text-center">Leave Name</th>
												<th class="width_18 text-center">CPL Overall Count</th>
												<th class="width_18 text-center">Leave Limit per year</th>
												<th class="width_15 text-center">Leave Taken</th>
												<th class="width_15 text-center">Leave Balance</th>
												<th class="width_10 text-center">Select</th>
											</tr>
										</thead>
										<tbody>
											<tr ng-repeat="holidayLeave in holidayLeaveList">
												<td style="text-align: center"><input type="text"
													ng-model="holidayLeave.leaveName" readonly /></td>
												<td style="text-align: center"><input type="text"
													ng-model="holidayLeave.allowedLeave" readonly /></td>
												<td style="text-align: center"><input type="text"
													value="20" readonly /></td>
												<td style="text-align: center"><input type="text"
													ng-model="holidayLeave.consumed" readonly /></td>
												<td style="text-align: center"><input type="text"
													ng-model="holidayLeave.balance" readonly /></td>
												<td class="width_10 text-center">
													<div class="checkbox">
														<label> <input type="checkbox"
															ng-if="holidayLeave.balance > 0" class="checkbox style-0"
															ng-model="holidayLeave.select"
															ng-change="selectCpl(holidayLeaveList)"> <span></span>
														</label>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
									<br>


								</div>

							</div>
						</div>
						<div class="row" ng-hide="true">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<fieldset>
									<div class="col-sm-3 col-md-3 col-lg-3">
										<div class="form-group">
											<label class="col-md-6 control-label">Leave request
												Form<span style="color: red;">*</span>
											</label>
											<div class="col-md-6">
												<select class="form-control"
													ng-model="leaveRequestObj.halfFrom"
													ng-change="change(leaveRequestObj)" name="Half From"
													data-validator="required" data-valid-method="submit"
													data-message-id="HalfFrom" ng-disabled="editRequest">
													<option value="">--Select--</option>
													<option value="1">First Half</option>
													<option value="2">Second Half</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-3 col-md-3 col-lg-3"
										ng-if="!leaveRequestObj.isEdit">
										<div class="form-group padding-left-0">
											<label class="col-md-2 control-label">Of</label>
											<div class="col-md-8">
												<div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="fromDate" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="fromDate"
																	data-ng-model="leaveRequestObj.fromDate" id="fromDate"
																	ng-change="selectDate(leaveRequestObj.fromDate)"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker id="fromDate"
																data-ng-model="leaveRequestObj.fromDate"
																data-on-set-time="leaveRequestObj.fromDate = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#fromDate',startView:'day', minView:'day'}"
																ng-change="selectDate(leaveRequestObj.fromDate)" />
														</ul>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-3 col-md-3 col-lg-3"
										ng-if="leaveRequestObj.isEdit">
										<div class="form-group padding-left-0">
											<label class="col-md-2 control-label">Of </label>
											<div class="col-md-8">
												<div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="fromDate" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd/mm/yyyy" name="fromDate"
																	data-ng-model="leaveRequestObj.fromDate" id="fromDate"
																	ng-change="selectDate(leaveRequestObj.fromDate)"
																	ng-disabled="editRequest"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-3 col-md-3 col-lg-3">
										<div class="form-group padding-left-0">
											<label class="col-md-5 control-label">To<span
												style="color: red;">*</span>
											</label>
											<div class="col-md-6">
												<select class="form-control"
													ng-model="leaveRequestObj.halfTo"
													ng-change="change(leaveRequestObj)" name="HalfTo"
													data-message-id="HalfTo" data-validator="required"
													data-valid-method="submit" ng-disabled="editRequest">
													<option value="">--Select--</option>
													<option value="1">First Half</option>
													<option value="2">Second Half</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-3 col-md-3 col-lg-3 padding-right-15"
										ng-if="!leaveRequestObj.isEdit">
										<div class="form-group">
											<label class="col-md-2 control-label">Of </label>
											<div class="col-md-8">
												<div class="dropdown">
													<a class="dropdown-toggle" id="toDate" role="button"
														data-toggle="dropdown" data-target="#" href="#">
														<div class="input-group">
															<input type="text" class="form-control"
																placeholder="dd/mm/yyyy" name="toDate"
																data-ng-model="leaveRequestObj.toDate"
																ng-bind="leaveRequestObj.toDate"><span
																class="input-group-addon"><i
																class="glyphicon glyphicon-calendar"></i></span>
														</div>
													</a>
													<ul class="dropdown-menu" role="menu"
														aria-labelledby="dLabel">
														<datetimepicker data-ng-model="leaveRequestObj.toDate"
															data-on-set-time="leaveRequestObj.toDate = onDateSet(newDate)"
															data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
													</ul>
												</div>

												<!--   <input type="text" class="form-control" ng-model="leaveRequestObj.toDate" placeholder="dd/mm/yyyy" id="date"> -->
											</div>
										</div>
									</div>
									<div class="col-sm-3 col-md-3 col-lg-3 padding-right-15"
										ng-if="leaveRequestObj.isEdit">
										<div class="form-group">
											<label class="col-md-2 control-label">Of </label>
											<div class="col-md-8">
												<div class="dropdown">
													<a class="dropdown-toggle" id="toDate" role="button"
														data-toggle="dropdown" data-target="#" href="#">
														<div class="input-group">
															<input type="text" class="form-control"
																placeholder="dd/mm/yyyy" name="toDate"
																data-ng-model="leaveRequestObj.toDate"
																ng-bind="leaveRequestObj.toDate"
																ng-disabled="editRequest"><span
																class="input-group-addon"><i
																class="glyphicon glyphicon-calendar"></i></span>
														</div>
													</a>
												</div>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
							

								<fieldset>
									<div class="col-sm-6 col-md-6 col-lg-6">


										<div class="form-group">
											<label class="col-md-5 control-label">From</label>
											<div class="col-md-6">
												<select class="form-control"
													ng-model="leaveRequestObj.halfFrom"
													ng-change="change(leaveRequestObj)" name="Half From"
													data-valid-method="submit" data-message-id="HalfFrom"
													ng-disabled="editRequest">
													<option value="">--Select--</option>
													<option value="1">First Half</option>
													<option value="2">Second Half</option>
												</select>
											</div>
										</div>
										<div class="form-group" ng-if="leaveRequestObj.leaveRadio!=3">
											<label class="col-md-5 control-label"
												ng-if="leaveRequestObj.leaveRadio!=4">From Date<span
												style="color: red;">*</span>
											</label> <label class="col-md-5 control-label"
												ng-if="leaveRequestObj.leaveRadio===4 ">Tentative
												From<span style="color: red;">*</span>
											</label>
											<div class="col-md-6">

												<ng-bs3-datepicker data-ng-model="leaveRequestObj.fromDate"
													id="fromDate" name="fromDate" form-name="leaveReqAddForm"
													friendly-name="fromDate"
													ng-change="selectDate(leaveRequestObj.fromDate)"
													ng-disabled="editRequest" />
											</div>
										</div>
										<div class="form-group" ng-if="leaveRequestObj.leaveRadio==3">
											<label class="col-md-5 control-label">CPL From Date <span
												style="color: red;" ng-if="cplLeave">*</span>
											</label>
											<div class="col-md-6">
											
												<ng-bs3-datepicker
													data-ng-model="leaveRequestObj.cplFromDate"
													id="cplFromDate" name="cplFromDate"
													form-name="leaveReqAddForm" friendly-name="cplFromDate"
													ng-disabled="!cplLeave" />
											</div>
										</div>
										<div class="form-group" ng-if="leaveRequestObj.leaveRadio==3">
											<label class="col-md-5 control-label">No. Of Days for
												CPL </label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="No. Of Days for CPL"
													ng-model="leaveRequestObj.cplLeaveDays" disabled>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label"
												ng-if="leaveRequestObj.leaveRadio!=3">No of Days </label> <label
												class="col-md-5 control-label"
												ng-if="leaveRequestObj.leaveRadio==3">Total No. Of
												Days </label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="noOfDays" ng-model="leaveRequestObj.noOfDays"
													readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">Address During
											</label>
											<div class="col-md-6">
												<textarea class="form-control input-sm" name="leaveAddress"
													id="leaveAddress" maxlength="150"
													data-ng-model="leaveRequestObj.leaveAddress"
													style="resize: none" friendly-name="Address During Leave"
													form-name="leaveReqAddForm" readonly></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">Applied On</label>
											<div class="col-md-6">
												<div class="dropdown">
													<a class="dropdown-toggle" id="appliedOn" role="button"
														data-toggle="dropdown" data-target="#" href="#">
														<div class="input-group">
															<input type="text" class="form-control"
																placeholder="dd/mm/yyyy" name="appliedOn"
																data-ng-model="leaveRequestObj.appliedOn" disabled><span
																class="input-group-addon"><i
																class="glyphicon glyphicon-calendar"></i></span>
														</div>
													</a>
												</div>
											</div>
										</div>
									
									</div>
									<div class="col-sm-6 col-md-6 col-lg-6 ">
										<div class="form-group">
											<label class="col-md-4 control-label">To </label>
											<div class="col-md-6">
												<select class="form-control"
													ng-model="leaveRequestObj.halfTo"
													ng-change="change(leaveRequestObj)" name="HalfTo"
													data-message-id="HalfTo" data-valid-method="submit"
													ng-disabled="editRequest">
													<option value="">--Select--</option>
													<option value="1">First Half</option>
													<option value="2">Second Half</option>
												</select>
											</div>
										</div>
										<div class="form-group" ng-if="leaveRequestObj.leaveRadio!=3">
											<label class="col-md-4 control-label"
												ng-if="leaveRequestObj.leaveRadio!=4">To Date<span
												style="color: red;">*</span>
											</label> <label class="col-md-4 control-label"
												ng-if="leaveRequestObj.leaveRadio===4">Tentative To<span
												style="color: red;">*</span>
											</label>
											<div class="col-md-6">

												<ng-bs3-datepicker data-ng-model="leaveRequestObj.toDate"
													id="toDate" name="toDate" form-name="leaveReqAddForm"
													friendly-name="toDate" ng-disabled="editRequest" />
											</div>
										</div>
										<div class="form-group" ng-if="leaveRequestObj.leaveRadio==3">
											<label class="col-md-4 control-label">CPL To Date <span
												style="color: red;" ng-if="cplLeave">*</span>
											</label>
											<div class="col-md-6">
												

												<ng-bs3-datepicker data-ng-model="leaveRequestObj.cplToDate"
													id="toDate" name="cplToDate" form-name="leaveReqAddForm"
													friendly-name="cplToDate" ng-disabled="!cplLeave" />
											</div>
										</div>
										<div class="form-group" ng-if="leaveRequestObj.leaveRadio==3">
											<label class="col-md-4 control-label">No. Of Days for
												PL </label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="No. Of Days for PL"
													ng-model="leaveRequestObj.plLeaveDays" disabled>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Reason For
												Leave <span style="color: red;">*</span>
											</label>
											<div class="col-md-6">
												<textarea class="form-control input-sm"
													name="Reason For Leave" id="Reason For Leave"
													maxlength="150" data-ng-model="leaveRequestObj.leaveReason"
													style="resize: none" validation="required"
													friendly-name="Reason For Leave"
													form-name="leaveReqAddForm" readonly></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Contact No </label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="Contact Number" friendly-name="Contact Number"
													ng-model="leaveRequestObj.leavePhone"
													form-name="leaveReqAddForm" readonly>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Mobile No </label>
											<div class="col-md-6">
												<input type="text" class="form-control input-sm"
													name="Mobile Number" friendly-name="Mobile Number"
													form-name="leaveReqAddForm" id="leaveMobile"
													ng-model="leaveRequestObj.leaveMobile"
													form-name="leaveReqAddForm" readonly>
											</div>
										</div>
										

										<!-- <div class="form-group">
											<label for="inputPassword" class="col-md-4 control-label">Upload
												Document <span style="color: red;"></span>
											</label>
											<div class="col-md-6" style="border: 0px solid red">
												<input type="file" class="form-control" name="uploadRef"
													id="uploadRef"
													onchange="angular.element(this).scope().uploadDocLink(this)" />
											</div>

										</div> -->
										
											<div class="form-group" ng-if="leaveRequestObj.isEdit">
											<label for="inputPassword" class="col-md-4 control-label"> <span style="color: red;"></span>
											</label>
											

											<div class="col-md-5" style="border: 0px solid red"
												ng-if="leaveRequestObj.uploadRef!=''">
												<a
													ng-click="downloadNewFile(leaveRequestObj.uploadRef)"
													style="color: green">Download</a> <a id="tbnewExport"
													href="" download=""></a>
											</div>
											<div class="col-md-5" style="border: 0px solid red"
												ng-if="leaveRequestObj.uploadRef==''">
												<a style="color: red">No file uploaded</a>
											</div>

										</div>

									</div>
								</fieldset>
								<!-- 										</div> -->
							</div>
						</div>
					<!-- 	<div class="form-actions">
							<div class="row">
								<div class="col-md-12">
									
									
									<button class="btn btn-danger" type="button"
										class="btn btn-success" ng-click="cancel()">
										<i class="fa fa-close"></i> Cancel
									</button>
								</div>
							</div>
						</div> -->
					</form>
				</div>
			</div>
			<!-- end widget content -->
		</div>






















<div class="col-sm-12 col-md-12 col-lg-12" >
						
<fieldset class="col-sm-12 col-md-12 col-lg-12 b-a" >
 <legend class="width_25 b-none no-margin" style=" font-size: 12px;width: 14%;">APPROVAL WORKFLOW</legend>
<div class="panel-body float-left padding-0" style="width: 100%;">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead>
     <tr>

    		<tr>
						
								<th class="sorting width_10">Employee Name</th>
								<th class="sorting width_10">Step Name</th>
								<th class="sorting width_10">Approve Date</th>
								<th class="sorting width_10">Comments</th>
								
							</tr>
      </thead>
     <tbody class="dataTables-Main-Body">
   		<tr class="company" ng-repeat="letterRequest in leaveRequestObj.approvalList track by $index">
							
								<td>{{letterRequest.employeeName}}</td>
								<td>{{letterRequest.stepName}}</td> 
							    <td>{{letterRequest.approvedDate}}</td>
								<td>{{letterRequest.comments}}</td>
								
							</tr>
     </tbody>           
     
    </table>
   </div>
      
  </div>
								             </fieldset>
								             </div>


	</div>
</div>




<br>
<br>
<br>

<br>
<br>
<br>



	<div class="form-actions">
							<div class="row">
								<div class="col-md-12">
									
									
									<button class="btn btn-danger" type="button"
										class="btn btn-success" ng-click="cancel()">
										<i class="fa fa-close"></i> Cancel
									</button>
								</div>
							</div>
						</div>


<script type="text/ng-template" id="mlFile">
	<div class="modal-header"> File Upload</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-12">
					<input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadMLFile(this)"/>
				</div>
			</div> 
		</div>
		<div class="modal-footer">
			<button class="btn btn-info" type="button" ng-click="uploadML()">OK</button>
			<button class="btn btn-danger" ng-click="closeML()">Cancel</button>
		</div>
 </script>
