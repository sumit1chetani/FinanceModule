<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div role="content">
						<div class="widget-body">
							<div class="dataTables_wrapper for-inline dt-bootstrap no-footer ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
							<form class="form-horizontal" name="leaveReqAddForm" role="form" >
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
										<fieldset>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Number
													 
												</label>
												<div class="col-md-5">
<!-- 				             							<select class="form-control input-sm" ng-model="leaveRequestObj.empId" ng-change="employeeChange(leaveRequestObj.empId)" -->
<!-- 				             							ng-options="emp.empId as emp.empName for emp in getEmployeeList" id="employeeId"> -->
<!-- 															<option value="">Select</option> -->
<!-- 														</select> -->
														<input type="text" class="form-control input-sm" name="empId" ng-model="leaveRequestObj.empId"
				             							  readonly>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"><%-- <spring:message code="label.companyName"></spring:message> --%>
													Organization Name
												</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="company" ng-model="leaveRequestObj.company"
				             							  readonly>
				             							  <!-- <select type="text" class="form-control input-sm" name="company" ng-model="leaveRequestObj.company"
				             							  disabled>
				             							   <option value="">IA</option>
				             							  </select> -->
				             							 
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Department
													
												</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="department" ng-model="leaveRequestObj.department"
				             							  readonly>
												</div>
											</div>
											<div class="form-group" id="radionId">
												<label class="col-md-5 control-label">Type
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5 radio radio-inline"" ng-init="leaveRequestObj.leaveRadio=false">
												
												<div class="radio radio-inline">
          											<label class="i-checks">
           											<input checked type="radio" name="leave" ng_model="leaveRequestObj.leaveRadio" id="leaveRadio" ng-value="false" ng-click=leavechange()>
         											  <i></i>
        						 							 Leave
          											</label>
        									 
        									 <label class="i-checks">
           											<input  checked type="radio" name="leave" ng_model="leaveRequestObj.leaveRadio" id="holidayRadio" ng-value="true"  ng-click= holiday()>
         											  <i></i>
        						 							Holiday Leave
          											</label>
        									 
        									 
        									 </div>
												
												
												
													
													
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												
												<label class="col-md-5 control-label">Employee Name
													
												</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="employeeName" ng-model="leaveRequestObj.empName"
				             							  readonly>
<!-- 														<select class="form-control input-sm" ng-model="leaveRequestObj.empId"> -->
<!-- 															<option value="">Select</option> -->
<!-- 														</select>  -->
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Branch
													 
												</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="branch" ng-model="leaveRequestObj.branch"
				             							 readonly>
												</div>
											</div>
										<!-- 	<div class="form-group">
												<label class="col-md-5 control-label">Grade
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
													<input type="text" class="form-control input-sm" name="grade" ng-model="leaveRequestObj.grade"
				             							  readonly>
												</div>
											</div> -->
											<%-- <div class="form-group">
												<label class="col-md-5 control-label"><spring:message code="label.year"></spring:message>
													
												</label>
												<div class="col-md-5">
						           					<select class="form-control" ng-model="leaveRequestObj.year" ng-options="year for year in years">
										   				 <option value="">--Select--</option>
													</select>
												</div>
											</div> --%>
										</div>
										</fieldset> 
									</div>
								</div>
								<div class="row">
									
								<table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info" ng-show="leaveRequestObj.leaveRadio===false">
							         <thead class="dataTables-Main-Head">
							          <tr>
							           <th class="sorting width_8" st-sort="leaveName">Leave Name</th>
							           <th class="sorting width_8" st-sort="PreviousYear">Previous Year</th>
							           <th class="sorting width_8" st-sort="CurrentYear">Current Year</th>
							           <th class="sorting width_8" st-sort="leaveAvailable">Leave Available</th>
							           <th class="sorting width_8" st-sort="leaveAvailed">Leave Availed</th>
							           <th class="sorting width_8" st-sort="leaveBalance">Leave Balance</th>
							           <th class="sorting width_8" st-sort="select">Select</th>
							          </tr>
							         </thead>
							         <tbody>
							          <tr ng-repeat="row in leaveList" >
							         	  <td style="text-align: left"><input type="text" ng-model="row.shortName"  readonly/> </td>
							         	      <td style="text-align: left"><input type="text" ng-model="row.previousYear" readonly/> </td>
							         	          <td style="text-align: left"><input type="text" ng-model="row.currentYear" readonly/> </td>
							         	    <td style="text-align: left"><input type="text" ng-model="row.allowedLeave" readonly/> </td>
							         	      <td style="text-align: left"><input type="text" ng-model="row.consumed" readonly /> </td>
							         	        <td style="text-align: left"><input type="text" ng-model="row.balance" readonly /> </td>
							         	<!--  <td><input ng-checked="true" type="radio"name="select" ng-value="row.shortName" ng-model="$leaveRequestObj.selectedPerson"  ></td> -->
							         	<!-- <td ng-hide><input type="text"  ng-model="row.selctRow"></td> -->
							         	<!-- <td><input type="radio" name="selected" ng-model="row.select" ng-value="$index" ng-focus=modify($index,leaveList) ></td> -->
							         	<td> <div class="radio radio-inline">
          											
        									 
        									 <label class="i-checks">
           											<input type="checkbox" name="selected" ng-model="row.select" ng-value="$index" ng-click=modify($index,leaveList) >
         											  <i></i>
        						 					
          											</label>
        									 
        									 
        									 </div></td>
							         
							   
							         
							         </tr>
							          
							          
							         </tbody>
							     </table>
							     
							     <table id="dt_basic" class="table width_100 table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info" ng-show="leaveRequestObj.leaveRadio===true">
							         <thead class="dataTables-Main-Head">
							          <tr>
							         
							           <th class="sorting width_18 text-center" st-sort="holidayWorked">House Worked</th>
							            <th class="sorting width_18 text-center" st-sort="holidayWorked">hours worked</th>
							           <th class="sorting width_15 text-center" st-sort="reason">Reason</th>
							         
							           <th class="sorting width_15 text-center" st-sort="cmt">Comment</th>
							           <th class="sorting width_10 text-center" st-sort="select">Select</th>
							          </tr>
							         </thead>
							         <tbody>
							       <tr ng-repeat="row in holidayList" >
							         	
							         	 <td style="text-align: center"><input type="text" ng-model="row.holidayWorked" readonly/> </td>
							         	 <td style="text-align: center"><input type="text" ng-model="row.hoursWorked" readonly/> </td>
							         	<td style="text-align: center"><input type="text" ng-model="row.reason" readonly/> </td>
							         	<td style="text-align: center"><input type="text" ng-model="row.comments" readonly/> </td>
							         	<td><div class="radio radio-inline">
          									     									 
        									 <label class="i-checks">
           											<input type="checkbox" name="selected" ng-model="row.select" ng-value="$index" ng-click=holidaymodify($index,holidayList)>
         											  <i></i>
        						 					
          											</label>
        									         </div></td>
							         </tr>
							           
							           
							         </tbody>
							     </table>
							     </div>
							     <div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
										<div class="col-sm-3 col-md-3 col-lg-3">
											<div class="form-group">
												<label class="col-md-6 control-label">Leave Request Form<span style="color: red;">*</span>
												</label>
												<div class="col-md-6">
						           					<select class="form-control" ng-model="leaveRequestObj.halfFrom" ng-change="change(leaveRequestObj)" name="halfFrom" 
						           						validation="required"  friendly-name="Half From" form-name="leaveReqAddForm" style="width: 122%;">
										   				 <option value="">--Select--</option>
										   				 <option value="1">First Half</option>
   												 				<option value="2">Second Half</option>
													</select>
												</div>
											</div>
										</div>
										<div class="col-sm-3 col-md-3 col-lg-3">
											<div class="form-group padding-left-0">
												<label class="col-md-2 control-label">Of
												</label>
												<div class="col-md-8">
										               <div class='input-group date datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="fromDate" role="button"
																data-toggle="dropdown" data-target="#" href="#" >
																<div class="input-group">
																	<td class=" width_10"><ng-bs3-datepicker
										 data-ng-model="leaveRequestObj.fromDate"
										id="fromDate{{trIndex}}" name="fromDate{{trIndex}}"
										data-ng-change="selectDate(leaveRequestObj.fromDate)"
										friendly-name="From date" validation="required" /></td>
																	<!-- <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="fromDate" 
																	
																		data-ng-model="leaveRequestObj.fromDate" id="fromDate" ng-change="selectDate(leaveRequestObj.fromDate)" ><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span> -->
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker  id="fromDate" data-ng-model="leaveRequestObj.fromDate" data-on-set-time="leaveRequestObj.fromDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#fromDate',startView:'day', minView:'day'}" ng-change="selectDate(leaveRequestObj.fromDate)"  />
															</ul>
														</div>
													</div>
										       </div>
											</div>
										</div>
										<div class="col-sm-3 col-md-3 col-lg-3">
											<div class="form-group padding-left-0">
												<label class="col-md-5 control-label">To
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-6">
						           					<select class="form-control" ng-model="leaveRequestObj.halfTo" ng-change="change(leaveRequestObj)"  
						           						name="halfTo" validation="required"  friendly-name="Half To"  form-name="leaveReqAddForm" style="width: 122%;">
										   				 <option value="">--Select--</option>
										   				 <option value="1">First Half</option>
   												 		 <option value="2">Second Half</option>
													</select>
												</div>
											</div>
										</div>
										<div class="col-sm-3 col-md-3 col-lg-3 padding-right-15">
											<div class="form-group">
												<label class="col-md-2 control-label">Of
	
												</label>
												<div class="col-md-8">
														<div class="dropdown">
															<a class="dropdown-toggle" id="toDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																<td class=" width_10"><ng-bs3-datepicker
										 data-ng-model="leaveRequestObj.toDate"
										id="toDate{{trIndex}}" name="toDate{{trIndex}}"
										data-ng-change="selectDate(leaveRequestObj.toDate)"
										friendly-name="To date" validation="required" /></td>
																	<!-- <input type="text" class="form-control" placeholder="dd/mm/yyyy" name="toDate" 
																	
																		data-ng-model="leaveRequestObj.toDate" ng-bind="leaveRequestObj.toDate"  ><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span> -->
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="leaveRequestObj.toDate" data-on-set-time="leaveRequestObj.toDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													
                                       <!--   <input type="text" class="form-control" ng-model="leaveRequestObj.toDate" placeholder="dd/mm/yyyy" id="date"> -->
												</div>
											</div>
										</div>
										<br><br><br><br><br><br><br>
										</fieldset>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 padding-right-30" >
										<div class="col-sm-1 col-md-1 col-lg-1"></div>
										<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-5 control-label">Number Of Days
														 <span style="color: red;">*</span>
													</label>
													<div class="col-md-6">
														<input type="text" class="form-control input-sm" name="noOfDays"
					             							 ng-model="leaveRequestObj.noOfDays" readonly ng-focus="dateValidate(leaveRequestObj)"; >
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">Address During
														
													</label>
													<div class="col-md-6" style="border:0px solid red">
									<textarea class="form-control input-sm" name="leaveAddress" id="leaveAddress" maxlength="150" ng-model="leaveRequestObj.leaveAddress"
									style="resize: none"></textarea>         
						         </div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">Applied On
														
													</label>
													<div class="col-md-6">
														        <div class="dropdown">
															<a class="dropdown-toggle" id="appliedOn" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="appliedOn" 
																	
																		data-ng-model="leaveRequestObj.appliedOn" disabled><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="leaveRequestObj.appliedOn"
																	data-datetimepicker-config="{ dropdownSelector: '#appliedOn',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
												
											</div>
											<div class="col-sm-6 col-md-6 col-lg-6 ">
												<div class="form-group">
													<label class="col-md-5 control-label">Reason For Leave
													</label>
													<div class="col-md-6" style="border:0px solid red">
									<textarea class="form-control input-sm" name="Reason For Leave" id="Reason For Leave" maxlength="150" data-ng-model="leaveRequestObj.leaveReason" 
									style="resize: none"></textarea>         
						         </div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">Phone Number
													</label>
													<div class="col-md-6">
														<input type="text" class="form-control input-sm" name="leavePhone" 
					             							 ng-model="leaveRequestObj.leavePhone" maxLength="10" phonenumbers-only>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">Mobile Number
														 
													</label>
													<div class="col-md-6">
														<input type="text" class="form-control input-sm" name="Mobile Number" 
					             						 ng-model="leaveRequestObj.leaveMobile" maxLength="10" phonenumbers-only>
													</div>
												</div>
											</div>
										</fieldset>
										</div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
										<!-- 	<button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="add" data-ng-if="!leaveRequestObj.isEdit" ng-click="submit(leaveReqAddForm)">
									            <i class="fa fa-save"></i>
									            Save
									           </button> -->
									          <button class="btn btn-success"  type="button" data-ng-click="update(leaveReqAddForm)"
																					>
									        <i class="fa fa-save"></i>
									       Update
									       </button>
											<button class="btn btn-info" type="button"
												class="btn btn-success" ng-click="reset(leaveRequestObj)">
												<i class="fa fa-refresh"></i> Reset
											</button>
											<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
								            	<i class="fa fa-close"></i>
								           		Cancel
								           </button>
										</div>
									</div>
								</div>
							</form>
							</div>
						</div>
						<!-- end widget content -->
					</div>
						</form>
					</div>
	</div>
</div>

