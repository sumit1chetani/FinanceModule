<style>
table.dataTable thead .sorting:after {
	content: "";
}

select {
	-webkit-appearance: none;
	padding: 0;
	text-indent: 8px;
	padding: 0 !important;
}

.input-group-addon {
	display: none !important;
}

.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
	{
	background-color: white !important;
	border: 0px !important;
}
.select2-choices{
	background-color: transparent !important;
	border:0 !important;
}
.ui-select-match-item{
	background-color: transparent !important;
	border:0 !important;
}
.b-grey {
	border: 0px !important;
}
</style>

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		
		<div class="panel-body">
			<form class="form-horizontal" name="empmasterForm" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset ng-disabled="viewDisable">
							<div class="form-group" ng-if="empmasterValidateData.empIdEdit">
								<label class="control-label col-md-6 col-lg-6">Emp ID</label> 
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="empId"
										ng-model="empmasterData.empId">
										
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Employee Name</label>
								<div class="col-md-6" style="border: 0px solid red">
									<input type="text" class="form-control"
										ng-model="empmasterData.empName" maxlength="20" id="empName"
										validation="required" name="empName"
										friendly-name="Employee Name"
										typeahead="r.empName for r in empList | filter:$viewValue | limitTo:10"
										typeahead_min_length="1" />
								</div>
							</div>
							<div class="form-group" ng-if="!empmasterValidateData.pswdEdit">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Password</label> <label
									class="col-md-1 control-label"
									ng-if="empmasterValidateData.isEdit"></label>
								<div class="col-md-6">
									<input type="password" class="form-control text-left"
										ng-model="empmasterData.pswd" id="pswd" name="pswd"
										friendly-name="PassWord" validation="required"
										ng-if="! empmasterValidateData.isEdit" maxlength="50"
										name="pswd" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Date Of Birth</label>
								<div class="col-md-6">
									<ng-bs3-datepicker data-ng-model="empmasterData.dob" name="dob"
										id="dob" friendly-name="Date Of Birth" validation="required" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Date of Joining</label>
								<div class="col-md-6">
									<ng-bs3-datepicker data-ng-model="empmasterData.doj" name="doj"
										id="doj" friendly-name="Date Of Joining" validation="required" />
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Designation</label>
								<div class="col-md-6">
									<select class="form-control" ng-model="empmasterData.dsgn"
										ng-options="des.id as des.text for des in designationList">
										<option value=""></option>
									</select>
								</div>
							</div>


							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Department</label>
								<div class="col-md-6">
									<select class="form-control" ng-model="empmasterData.dept"
										ng-options="dept.id as dept.text for dept in departmentList">
										<option value=""></option>
									</select>
								</div>
							</div>



							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Mode Of Payment</label>
								<div class="col-md-6">
									<select class="form-control" ng-model="empmasterData.moPay">
										<option value="CE">Credit To Employee</option>
										<option value="TS">Transfer To SCB</option>
										<option value="C">Cash</option>
										<option value="TH">Transfer To HSBC</option>

									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Access Rights</label>

								<div class="col-md-6" ng-if="empmasterData.accessRights=='Y'">
									<input type="text" class="text-left form-control input-sm"
										value="Yes" name="accessRights">
								</div>
								<div class="col-md-6" ng-if="empmasterData.accessRights=='N'">
									<input type="text" class="text-left form-control input-sm"
										value="No" name="accessRights" validation="required"
										friendly-name="Designation Name">
								</div>


							</div>
						</fieldset>
					</div>


					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset ng-disabled="viewDisable">
							<div class="form-group">
								<label class="col-md-6 control-label">Probation Period
									From </label>
								<div class="col-md-6">
									<ng-bs3-datepicker data-ng-model="empmasterData.ppf" name="ppf"
										name="ppf" id="ppf" object="ppf" validation="required"
										friendly-name="Probation Period From" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 control-label">Probation Period
									To </label>
								<div class="col-md-6">
									<ng-bs3-datepicker data-ng-model="empmasterData.ppt" name="ppt"
										id="ppt" object="ppt" validation="required"
										friendly-name="Probation Period To" />
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Birth/Identification
									Mark</label>
								<div class="col-md-6">
									<textarea rows="1" cols="35" class="form-control text-left"
										ng-model="empmasterData.biMark" maxlength="20" name="biMark"
										style="resize: none"></textarea>
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Company</label>
								<div class="col-md-6">
									<select class="form-control" ng-model="empmasterData.company"
										ng-options="com.id as com.text for com in companyList">
										<option value=""></option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Blood Group</label>
								<div class="col-md-6">
									<select class="form-control" ng-model="empmasterData.bldGrp"
										name="bldGrp" required>
										<option value="A">A+</option>
										<option value="B">A-</option>
										<option value="C">A1+</option>
										<option value="D">A1-</option>
										<option value="E">A1B+</option>
										<option value="F">A1B-</option>
										<option value="G">A2+</option>
										<option value="H">A2-</option>
										<option value="I">A2B+</option>
										<option value="J">A2B-</option>
										<option value="K">AB+</option>
										<option value="L">AB-</option>
										<option value="M">B+</option>
										<option value="N">B-</option>
										<option value="O">O+</option>
										<option value="P">O-</option>
									</select>
								</div>
							</div>



							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Basic pay</label>
								<div class="col-md-6">
									<input type="text" class="form-control text-right"
										ng-model="empmasterData.bPay" maxlength="20"
										name="bPay" style="text-align: left" />
								</div>
							</div>

							<div class="form-group" id="leaveDate">
								<label class="col-md-6 control-label">Date Of Leave</label>
								<div class="col-md-6">
									<ng-bs3-datepicker data-ng-model="empmasterData.leaveDate"
										name="leaveDate" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Agent</label>

								<div class="col-md-6" ng-if="empmasterData.agent=='Y'">
									<input type="text" class="text-left form-control input-sm"
										value="Yes" name="agent" validation="required"
										friendly-name="Designation Name">
								</div>
								<div class="col-md-6" ng-if="empmasterData.agent=='N'">
									<input type="text" class="text-left form-control input-sm"
										value="No" name="agent" validation="required"
										friendly-name="Designation Name">
								</div>

								<div class="form-group" ng-show="empmasterData.agent == 'Y'">
						        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Port</label>
						        <div class="col-md-6">
						         <ui-select class="form-control" multiple ng-model="empmasterData.mulPort" theme="select2" ng-disabled="viewDisable" name="mulPort" style="width: 300px;"> <ui-select-match
						          placeholder="Select...">{{$item.portName}}</ui-select-match> <ui-select-choices repeat="r.portId as r in portList">{{r.portId}}</ui-select-choices> </ui-select>
						        </div>
						       </div>
							</div>
						</fieldset>
					</div>


					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset ng-disabled="viewDisable">
							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Bank Account
									Number</label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm text-right"
										ng-model="empmasterData.acNo" maxlength="50" name="acNo"
										style="text-align: left" />
								</div>
							</div>


							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Contact Number</label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm text-right"
										ng-model="empmasterData.contactNo" maxlength="50"
										name="contactNo" style="text-align: left" />
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Email Id</label>
								<div class="col-md-6">
									<input type="email" class="form-control input-sm"
										ng-model="empmasterData.emailId" maxlength="50" name="emailId" />
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Passport No</label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm"
										ng-model="empmasterData.passNo" maxlength="50" name="passNo" />
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Place Of Issue</label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm"
										ng-model="empmasterData.placeIssue" maxlength="50"
										name="placeIssue" />
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Contact Address</label>
								<div class="col-md-6">
									<textarea rows="1" cols="35" class="form-control input-sm text-left"
										ng-model="empmasterData.contactAddr" name="contactAddr"
										style="resize: none"></textarea>
								</div>
							</div>
							<div class="form-group" id="confDate">
								<label class="col-md-6 control-label">Date Of
									Confirmation</label><label class="col-md-1 control-label"></label>
								<div class="col-md-6">
									<!-- 								<input type="text" class="text-left form-control input-sm" -->
									<!-- 										data-ng-model="empmasterData.confDate" name="confDate" 	> -->
									<ng-bs3-datepicker data-ng-model="empmasterData.confDate"
										name="confDate" />
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword"
									class="control-label col-md-6 col-lg-6">Active</label>

								<div class="col-md-6" ng-if="empmasterData.isActive=='Y'">
									<input type="text" class="text-left form-control input-sm"
										value="Yes" name="isActive" style="padding-top: 5%"
										validation="required" friendly-name="Designation Name">
								</div>
								<div class="col-md-6" ng-if="empmasterData.isActive=='N'">
									<input type="text" class="text-left form-control input-sm"
										value="No" name="isActive" validation="required"
										friendly-name="Designation Name">
								</div>


							</div>
						</fieldset>
					</div>
				</div>
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
			</form>
		</div>
	</div>
</div>