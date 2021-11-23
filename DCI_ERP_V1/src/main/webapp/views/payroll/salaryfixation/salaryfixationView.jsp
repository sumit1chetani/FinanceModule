<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
	<!-- widget grid -->
	<section widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="salaryFixation" role="form"
								method="post" novalidate>
								<div class="row">
									<fieldset>
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-5 control-label"> Organization
														<span style="color: red;">*</span>
													</label>

													<!--  <selectivity list="companyList" property="employeePaycomponenet.companyId" 
               id="companyId" name="companyId" data-ng-if="!employeePaycomponenet.isEdit"> 
              </selectivity>
              <selectivity list="companyList" property="employeePaycomponenet.companyId"
               id="companyId" name="companyId" data-ng-if="employeePaycomponenet.isEdit" disabled> 
              </selectivity> -->
													<div class="col-md-5" ng-if="!employeePaycomponenet.isEdit">
														<selectivity list="companyList"
															property="employeePaycomponenet.companyId" id="companyId"
															ng-model="employeePaycomponenet.companyId"
															name="companyId" form-name="salaryFixation"
															ng-if="companyList.length > 1" validation="required"
															friendly-name="Hospital"> </selectivity>
														<input type="text" class="form-control input-sm"
															ng-model="employeePaycomponenet.companyName"
															message-id="companyId" name="Hospital Name"
															ng-if="companyList.length ==1" readonly>
													</div>
													<div class="col-md-5" ng-if="employeePaycomponenet.isEdit">
														<!--   <selectivity list="companyList" property="employeePaycomponenet.companyId" 
										                id="companyId" ng-model="employeePaycomponenet.companyId"
										               name="companyId" form-name="salaryFixation" ng-if="companyList.length > 1"
										               validation="required" friendly-name="Hospital" disabled="true">
										               </selectivity> -->
														<input type="text" class="form-control input-sm"
															ng-model="employeePaycomponenet.companyName"
															message-id="companyName" name="Hospital Name" readonly>

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
											<button class="btn btn-info ng-scope" type="button"
												class="btn btn-success" ng-click="reset()"
												data-ng-if="!employeePaycomponenet.isEdit">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label">From Date<span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<div class='input-group date datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="fromdate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="From Date" disabled
																			validation="required" friendly-name="From Date"
																			id="startDate"
																			data-ng-model="employeePaycomponenet.fromdate"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar" ></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker 	
																		data-ng-model="employeePaycomponenet.fromdate"
																		data-on-set-time="employeePaycomponenet.fromdate = onDateSet(newDate); onFrmDateChg(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#fromdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-8 control-label" > Earnings </label>
												</div>

												<div class="form-group" ng-repeat="earnings in earningList" readonly
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
														<input type="text" maxLength="7"
															class="form-control input-sm"
															data-ng-change="getValue(earnings.payComponentId,earnings.earningValue)"
															id="performanceId{{earnings.id}}"
															data-ng-if="earnings.payComponentId!='DA'"
															data-ng-model="earnings.earningValue"
															ng-pattern-restrict="^[0-9.]*$" required>
														<!-- data-ng-if="earnings.percentageAppliedOn==null"  -->
														<input type="text" class="form-control input-sm"
															maxLength="7"
															data-ng-change="getValue(earnings.payComponentId,earnings.earningValue)"
															id="performanceId{{earnings.id}}"
															data-ng-if="earnings.payComponentId=='DA'"
															data-ng-model="earnings.earningValue"
															ng-pattern-restrict="^[0-9.]*$" required disabled>
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
															property="employeePaycomponenet.departmentId" disabled
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
													<label class="col-md-5 control-label"> Employee Name
														<span style="color: red;">*</span>
													</label>
													<div class="col-md-5">
														<selectivity list="employeeList"
															property="employeePaycomponenet.employeeId" id="employee"
															name="employee"
															data-ng-if="!employeePaycomponenet.isEdit"
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
												<div ng-repeat="deduct in deductionList" class="form-group" disabled
													style="padding-left: 122px;">
													<div class="col-md-3">
														<label class="i-checks ng-binding"> <input checked
															type="checkbox" ng_model="deduct.select"
															ng-click="checkingDeductionValue(deduct.payComponentId,employeePaycomponenet.totalEarnings)"
															ng-true-value="'YES'" ng-false-value="'NO'"
															class="ng-pristine ng-untouched ng-valid"> <i></i>{{deduct.payComponentName}}
														</label>
													</div>
													<div class="col-md-6">
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
															id="deductId{{deduct.id}}"
															data-ng-change="getdeductionValue(deduct.payComponentId,deduct.deductionValue)">
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
											<button class="btn btn-danger" type="button"
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i>
												<spring:message code="label.cancel"></spring:message>
											</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- end widget content -->
				</div>
				<!-- end widget div -->
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>