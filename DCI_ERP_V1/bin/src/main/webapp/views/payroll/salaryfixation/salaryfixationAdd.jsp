<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div role="content">
			<div class="widget-body">
				<form class="form-horizontal" name="salaryFixation" role="form"
					method="post" novalidate>
					<div class="row">
						<fieldset>
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="col-sm-6 col-md-6 col-lg-6">
									<div class="form-group">
										<label class="col-md-5 control-label"> Organization <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-5" ng-if="!employeePaycomponenet.isEdit">
											<!-- <selectivity list="companyList"
												property="employeePaycomponenet.companyId" id="companyId"
												ng-model="employeePaycomponenet.companyId" name="companyId"
												form-name="salaryFixation" ng-if="companyList.length > 1"
												validation="required" friendly-name="Company">
											</selectivity>
											<input type="text" class="form-control input-sm"
												ng-model="employeePaycomponenet.companyName"
												message-id="companyName" name="Company Name"
												ng-if="companyList.length ==1" readonly> -->
											<selectivity list="companyList"
												property="employeePaycomponenet.companyId" id="companyId"
												ng-model="employeePaycomponenet.companyId" name="companyId"
												form-name="salaryFixation" 
												validation="required" friendly-name="Company">
											</selectivity>	
										</div>
										<div class="col-md-5" ng-if="employeePaycomponenet.isEdit">
											<!--   <selectivity list="companyList" property="employeePaycomponenet.companyId" 
										                id="companyId" ng-model="employeePaycomponenet.companyId"
										               name="companyId" form-name="salaryFixation" ng-if="companyList.length > 1"
										               validation="required" friendly-name="Hospital" disabled="true">
										               </selectivity> -->
											<input type="text" class="form-control input-sm"
												ng-model="employeePaycomponenet.companyName"
												message-id="companyName" name="Company Name" readonly>

										</div>
									</div>

									<div class="form-group">
										<label class="col-md-5 control-label">Branch <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-5"
											data-ng-if="!employeePaycomponenet.isEdit">
											<selectivity list="branchList"
												property="employeePaycomponenet.branchId" id="Branch Id"
												name="Branch Id" ng-if="branchList.length > 1"
												data-ng-model="employeePaycomponenet.branchId"
												form-name="salaryFixation" validation="required"
												friendly-name="Branch"></selectivity>
											<input type="text" class="form-control input-sm"
												ng-model="employeePaycomponenet.branchName"
												message-id="branchId" name="Hospital Name"
												ng-if="branchList.length == 1 ||branchList.length == 0 "
												readonly>
										</div>
										<div class="col-md-5"
											data-ng-if="employeePaycomponenet.isEdit">
											<!-- <selectivity list="branchList" property="employeePaycomponenet.branchId" id="Branch Id"
               name="Branch Id" ng-if="branchList.length > 1"   disabled="true"
               form-name="salaryFixation" validation="required" data-ng-model="employeePaycomponenet.branchId"
               friendly-name="Branch">  </selectivity> -->
											<input type="text" class="form-control input-sm"
												ng-model="employeePaycomponenet.branchName"
												message-id="branchName" name="Branch Name" readonly>


										</div>
									</div>
										<div class="form-group">
										<label class="col-md-5 control-label">From Date<span
											style="color: red;">*</span></label>
										<div class="col-md-5">
											<div class="input-group input-append date">
												<input type="text" class="form-control input-sm"
													validation="required" id="startDate" name="From Date"
													ng-model="employeePaycomponenet.fromdate"
													friendly-name="From Date"
													data-on-set-time="employeePaycomponenet.fromdate = onDateSet(newDate); onFrmDateChg(newDate)" />
												<span class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span>
											</div>

											<!-- <div class="input-group input-append date" id="in_date">
															<ng-bs3-datepicker data-ng-model="employeePaycomponenet.fromdate" data-on-set-time="employeePaycomponenet.fromdate = onDateSet(newDate); onFrmDateChg(newDate)"
															date-format="DD/MM/YYYY" id="startDate" name="Start Date" 
															validation="required" friendly-name="Date"/>
														</div> -->
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-8 control-label"> Earnings </label>
									</div>
									<div class="form-group" ng-if="isEdit">
										<label class="col-md-4 control-label"> Arrears </label>
										<div class="col-md-5">
											<div class="checkbox">
												<label> <input type="checkbox"
													class="checkbox style-0" id="arrears"
													ng-model="employeePaycomponenet.arrears" name="arrears"
													data-ng-true-value="true" data-ng-false-value="false">
													<span></span>
												</label>
											</div>
										</div>
									</div>


									<div id="myDIV" class="form-group"
										ng-if="employeePaycomponenet.isEdit">
										<label class="col-md-5 control-label">Arrears From
											Date</label>
										<div class="col-md-5">
											<ng-bs3-datepicker
												data-ng-model="employeePaycomponenet.arrearsStartDate"
												id="arrearsStartDate" name="arrearsStartDate"
												ng-click="checkDateExist(employeePaycomponenet.arrearsStartDate)"
												data-on-set-time="employeePaycomponenet.arrearsStartDate = onDateSet(newDate); onFrmDatdeChg(newDate)"
												friendly-name="Arrears From Date" />
										</div>
									</div>
									<!--   <div class="form-group" ng-if="employeePaycomponenet.arrearsStartDate!= null">
												<label  class="text-danger" class="col-md-5 control-label"> Arrears Amount Added From the Month of  
														<b>{{employeePaycomponenet.arrearsStartDate}}</b>
													</label></div> -->
									<div class="form-group" ng-repeat="earnings in earningList"
										style="padding-left: 122px;">
										<div class="col-md-3">
											<label class="i-checks ng-binding"> <input checked
												type="checkbox" name="leave"
												ng-click="checkingEarningValue(earnings.payComponentId,employeePaycomponenet.totalEarnings)"
												ng-model="earnings.select" id="payId{{$index}}"
												ng-click="holiday()" ng-true-value="'YES'"
												ng-false-value="'NO'"
												class="ng-pristine ng-untouched ng-valid"> <i></i>{{earnings.payComponentName}}
											</label>
										</div>
										<div class="col-md-7">
											<!-- <input type="text" maxLength="7"
															class="form-control input-sm"
															id="performanceId{{earnings.id}}"
															data-ng-if="earnings.payComponentId!='DA' && earnings.payComponentId!='ARR'"
															data-ng-model="earnings.earningValue"
															ng-pattern-restrict="^[0-9.]*$" required>
														<input type="text" maxLength="7" 
															class="form-control input-sm"
															data-ng-change="getValue(earnings.payComponentId,earnings.earningValue)"
															id="performanceId{{earnings.id}}"
															data-ng-if="earnings.payComponentId=='DA' "
															data-ng-model="earnings.earningValue"
															ng-pattern-restrict="^[0-9.]*$" required> -->
											<input type="text" maxLength="7"
												class="form-control input-sm"
												data-ng-change="getValue(earnings.payComponentId,earnings.earningValue)"
												id="performanceId{{earnings.id}}"
												data-ng-model="earnings.earningValue"
												ng-pattern-restrict="^[0-9.]*$" required>
											<!-- data-ng-if="earnings.percentageAppliedOn!=null" -->
										</div>
									</div>

								</div>
								<div class="col-sm-6 col-md-6 col-lg-6">
									<div class="form-group">
										<label class="col-md-5 control-label"> Department <span
											style="color: red;">*</span></label>
										<div class="col-md-5">
											<selectivity list="departmentList"
												property="employeePaycomponenet.departmentId"
												id="Department Name" name="Department Name"
												data-ng-if="!employeePaycomponenet.isEdit"
												ng-model="employeePaycomponenet.departmentId"
												validation="required" friendly-name="Department"
												form-name="salaryFixation"> </selectivity>
											<input type="text" class="form-control input-sm"
												ng-model="employeePaycomponenet.departmentName"
												message-id="departmentName"
												data-ng-if="employeePaycomponenet.isEdit"
												name="Department Name" readonly>
											<!-- <selectivity list="departmentList" property="employeePaycomponenet.departmentId" id="Department Name"
               name="Department Name" data-ng-if="employeePaycomponenet.isEdit" disabled="true" ng-model="employeePaycomponenet.departmentId"
               validation="required" friendly-name="Department" form-name="salaryFixation">
              </selectivity> -->

										</div>

									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Employee Name <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-5">
											<selectivity list="employeeList"
												property="employeePaycomponenet.employeeId" id="employee"
												name="employee" data-ng-if="!employeePaycomponenet.isEdit"
												form-name="salaryFixation" validation="required"
												data-ng-model="employeePaycomponenet.employeeId"
												friendly-name="Employee Name"> </selectivity>
											<input type="text" class="form-control input-sm"
												ng-model="employeePaycomponenet.employeeName"
												message-id="employeeName"
												data-ng-if="employeePaycomponenet.isEdit"
												name="Employee Name" readonly>

											<!--  <selectivity list="employeeList" property="employeePaycomponenet.employeeId" id="employee"
               name="employee" data-ng-if="employeePaycomponenet.isEdit" disabled="true"
               form-name="salaryFixation" validation="required" data-ng-model="employeePaycomponenet.employeeId"
               friendly-name="Employee Name">
              </selectivity> -->

										</div>
										<div class="col-md-5"></div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> </label>
										<div class="col-md-6">
											<div class='input-group date datetimepick'>
												<div class="dropdown"></div>
											</div>
										</div>
									</div>
									<div class="form-group" style="margin-top: 6%;">
										<label class="col-md-8 control-label"> Deduction </label>
									</div>
									<div ng-repeat="deduct in deductionList" class="form-group"
										style="padding-left: 122px;">
										<div class="col-md-3" ng-if="deduct.payComponentId!='LOPAM'">
											<label class="i-checks ng-binding"> <input checked
												type="checkbox" ng_model="deduct.select"
												ng-click="checkingDeductionValue(deduct.payComponentId,employeePaycomponenet.totalEarnings)"
												ng-true-value="'YES'" ng-false-value="'NO'"
												class="ng-pristine ng-untouched ng-valid"> <i></i>{{deduct.payComponentName}}
											</label>
										</div>
										<div class="col-md-6" ng-if="deduct.payComponentId!='LOPAM'">
											<input type="text" class="form-control input-sm"
												maxLength="7" ng-pattern-restrict="^[0-9.]*$"
												data-ng-model="deduct.deductionValue"
												data-ng-if="deduct.percentageAppliedOn!=null && deduct.percentageAppliedOn!=''"
												data-ng-change="getdeductionValue(deduct.payComponentId,deduct.deductionValue)"
												id="deductId{{deduct.id}}" disabled> <input
												type="text" class="form-control input-sm" maxLength="7"
												ng-pattern-restrict="^[0-9.]*$"
												data-ng-model="deduct.deductionValue"
												data-ng-if="deduct.percentageAppliedOn==null || deduct.percentageAppliedOn==''"
												data-ng-change="getdeductionValue(deduct.payComponentId,deduct.deductionValue)"
												id="deductId{{deduct.id}}"
												ng-hide="deduct.payComponentId=='PTS' && deduct.payComponentId=='LOPAM'">
										</div>
									</div>

								</div>



							</div>
						</fieldset>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="col-md-6">
									<label class="col-md-5 control-label">Gross Pay<span
										style="color: red;">*</span></label>
									<div class="col-md-4">
										<input type="number" class="form-control input-sm"
											name="gross pay"
											data-ng-model="employeePaycomponenet.totalEarnings"
											validation="required" friendly-name="Gross Pay" disabled>
									</div>
									<!--  <div class="col-md-3">
             <button class="btn btn-success" type="button"
              data-ng-click="fixEarningCalculation(employeePaycomponenet.totalEarnings)"
              style="width: 50%;">Fix it</button>
            </div> -->
								</div>
								<!-- <div class="col-md-6">
												<label class="col-md-5 control-label">Net Pay </label>
												<div class="col-md-4">
													<input type="number" class="form-control input-sm"
														data-ng-model="employeePaycomponenet.totalDeductions"
														disabled>
												</div>
												  <div class="col-md-3">
             <button class="btn btn-success" type="button"
              data-ng-click="fixNetSalaryCalculation(employeePaycomponenet.totalDeductions)"
              style="width: 50%;">Fix it</button>
            </div>
											</div> -->
							</div>
						</div>
					</div>

					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" type="button"
									ng-if="!employeePaycomponenet.isEdit"
									ng-click="submit(employeePaycomponenet,salaryFixation)">
									<i class="fa fa-save"></i>Save
								</button>
								<button class="btn btn-success" type="button"
									ng-if="employeePaycomponenet.isEdit"
									ng-click="update(employeePaycomponenet,salaryFixation)">
									<i class="fa fa-save"></i> Update
								</button>
								<button class="btn btn-info ng-scope" type="button"
									class="btn btn-success" ng-click="reset()"
									ng-if="!employeePaycomponenet.isEdit">
									<i class="fa fa-undo"></i>Reset
								</button>
								<button class="btn btn-danger" type="button"
									class="btn btn-success" ng-click="cancel()">
									<i class="fa fa-close"></i>Cancel
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
