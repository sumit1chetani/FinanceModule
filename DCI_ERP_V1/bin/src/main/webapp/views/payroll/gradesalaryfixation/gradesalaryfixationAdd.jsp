<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
			<div role="content">
						<div class="widget-body">
						<br>
							<form class="form-horizontal" name="gradesalaryFixation"
								role="form" method="post" novalidate>
								<div class="row">
									<fieldset>
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="col-sm-4 col-md-4 col-lg-4">
												<div class="form-group">
													<label class="col-md-5 control-label"> Organization
													</label>
													<div class="col-md-7" ng-if="!gradePaycomponenet.isEdit">
														<selectivity list="companyList"
															property="gradePaycomponenet.companyId" id="companyId"
															ng-model="gradePaycomponenet.companyId" name="companyId"
															form-name="gradesalaryFixation"
															ng-if="companyList.length > 1" validation="required"
															friendly-name="Hospital"> </selectivity>
														<input type="text" class="form-control input-sm"
															ng-model="gradePaycomponenet.companyName"
															message-id="companyId" name="Hospital Name"
															ng-if="companyList.length ==1" readonly>
													</div>
													<div class="col-md-7" ng-if="gradePaycomponenet.isEdit">
														<selectivity list="companyList"
															property="gradePaycomponenet.companyId" id="companyId"
															ng-model="gradePaycomponenet.companyId" name="companyId"
															form-name="gradesalaryFixation"
															ng-if="companyList.length > 1" validation="required"
															friendly-name="Hospital"> </selectivity>
														<input type="text" class="form-control input-sm"
															ng-model="gradePaycomponenet.companyName"
															message-id="companyId" name="Hospital Name"
															ng-if="companyList.length ==1" readonly>
													</div>

												</div>

											</div>
											<div class="col-sm-4 col-md-4 col-lg-4">
												<div class="form-group">
													<label class="col-md-5 control-label"> Grade <span
														style="color: red;">*</span></label>
													<div class="col-md-7">
														<selectivity list="gradeList"
															property="gradePaycomponenet.gradeId" id="gradeId"
															name="gradeId" ng-if="!gradePaycomponenet.isEdit"
															ng-model="gradePaycomponenet.gradeId"
															validation="required" friendly-name="Grade"
															form-name="gradesalaryFixation"> </selectivity>

														<input type="text" class="form-control input-sm"
															ng-if="gradePaycomponenet.isEdit"
															ng-model="gradePaycomponenet.gradeName" readonly>

													</div>
												</div>
											</div>
											<div class="col-sm-4 col-md-4 col-lg-4">
												<div class="form-group">
													<label class="col-md-5 control-label">From Date<span
														style="color: red;">*</span></label>
													<div class="col-md-7">
														<div class='input-group date datetimepick'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="fromdate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="From Date"
																			validation="required" friendly-name="From Date"
																			id="startDate"
																			data-ng-model="gradePaycomponenet.fromdate"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="gradePaycomponenet.fromdate"
																		data-on-set-time="gradePaycomponenet.fromdate = onDateSet(newDate); onFrmDateChg(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#fromdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</fieldset>
								</div>
								<div class="row">
									<fieldset>
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-8 control-label"> Earnings </label>
												</div>
												<div class="form-group" ng-repeat="earnings in earningList"
													style="padding-left: 122px;">
													<div class="col-md-3">
														<label class="i-checks ng-binding"> <input checked
															type="checkbox" name="leave"
															ng-click="checkingEarningValue(earnings.payComponentId,gradePaycomponenet.totalEarnings)"
															ng-model="earnings.select" id="payId{{$index}}"
															ng-click="holiday()" ng-true-value="'YES'"
															ng-false-value="'NO'"
															class="ng-pristine ng-untouched ng-valid"> <i></i>{{earnings.payComponentName}}
														</label>
													</div>
													<div class="col-md-6">
														<input type="text" class="form-control input-sm"
															maxLength="7"
															data-ng-change="getValue(earnings.payComponentId,earnings.earningValue)"
															id="performanceId{{earnings.id}}"
															data-ng-if="earnings.payComponentId!='DA'"
															data-ng-model="earnings.earningValue" required
															ng-pattern-restrict="^[0-9.]*$">
															<!-- data-ng-if="earnings.percentageAppliedOn==null" -->
															 <input
															type="text" class="form-control input-sm" maxLength="7"
															data-ng-change="getValue(earnings.payComponentId,earnings.earningValue)"
															id="performanceId{{earnings.id}}"
															data-ng-if="earnings.payComponentId=='DA'"
															data-ng-model="earnings.earningValue" required disabled
															ng-pattern-restrict="^[0-9.]*$">
															<!-- data-ng-if="earnings.percentageAppliedOn!=null" -->
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-8 control-label"> Deduction </label>
												</div>
												<div ng-repeat="deduct in deductionList" class="form-group"
													style="padding-left: 122px;">
													<div class="col-md-3">
														<label class="i-checks ng-binding"> <input checked
															type="checkbox" ng_model="deduct.select"
															ng-click="checkingDeductionValue(deduct.payComponentId,gradePaycomponenet.totalEarnings)"
															ng-true-value="'YES'" ng-false-value="'NO'"
															class="ng-pristine ng-untouched ng-valid"> <i></i>{{deduct.payComponentName}}
														</label>
													</div>
													<div class="col-md-6">
														<input type="text" class="form-control input-sm"
															maxLength="7" data-ng-model="deduct.deductionValue"
															data-ng-if="deduct.percentageAppliedOn!=null"
															data-ng-change="getdeductionValue(deduct.payComponentId,deduct.deductionValue)"
															id="deductId{{deduct.id}}"
															ng-pattern-restrict="^[0-9.]*$" disabled> <input
															type="text" class="form-control input-sm" maxLength="7"
															data-ng-model="deduct.deductionValue"
															data-ng-if="deduct.percentageAppliedOn==null"
															id="deductId{{deduct.id}}"
															ng-pattern-restrict="^[0-9.]*$"
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
												<label class="col-md-5 control-label">Gross Pay <span
													style="color: red;">*</span></label>
												<div class="col-md-5">
													<input type="number" class="form-control input-sm"
														name="gross pay"
														data-ng-model="gradePaycomponenet.totalEarnings"
														validation="required" friendly-name="Gross Pay" disabled>
												</div>
												<!--    <div class="col-md-3">
             <button class="btn btn-success" type="button"
              data-ng-click="fixEarningCalculation(gradePaycomponenet.totalEarnings)"
              style="width: 50%;">Fix it</button>
            </div> -->
											</div>
											<!-- <div class="col-md-6">
												<label class="col-md-5 control-label">Net Pay </label>
												<div class="col-md-5">
													<input type="number" class="form-control input-sm"
														data-ng-model="gradePaycomponenet.totalDeductions"
														required disabled>
												</div>
												  <div class="col-md-3">
             <button class="btn btn-success" type="button"
              data-ng-click="fixNetSalaryCalculation(gradePaycomponenet.totalDeductions)"
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
												data-ng-if="!gradePaycomponenet.isEdit"
												data-ng-click="submit(gradePaycomponenet,gradesalaryFixation)">
												<i class="fa fa-save"></i>Save
									</button>
											<button class="btn btn-success" type="button"
												data-ng-if="gradePaycomponenet.isEdit"
												data-ng-click="update(gradePaycomponenet,gradesalaryFixation)">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-info ng-scope" type="button"
												class="btn btn-success"
												data-ng-if="!gradePaycomponenet.isEdit" ng-click="reset()">
												<i class="fa fa-undo"></i>Reset
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i> Cancel</button>
											<button class="btn btn-success" type="button"
												class="btn btn-success" ng-click="applySalary()"
												ng-if="gradePaycomponenet.isEdit">Apply to Grade
												Employees</button>
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