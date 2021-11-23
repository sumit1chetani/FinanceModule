

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-persist="paySlipReportTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body float-left padding-0" style="width: 100%;">
  
  <br>
  <form name="payslipReportForm" class="form-horizontal" novalidate>
   <div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<!-- <input type="text" class="form-control"
								              	name="kmc"
								               value="" data-ng-model="payslipgeneration.companyName"  readonly> -->
													<selectivity list="companyList"
														property="payslipgeneration.companyId"
														ng-model="payslipgeneration.companyId"
														ng-if="companyList.length > 1" name="Hospital"
														form-name="payslipReportForm" validation="required"
														friendly-name="Hospital"></selectivity>

													<input type="text" class="form-control input-sm"
														ng-model="payslipgeneration.companyName"
														message-id="companyId" data-validator="required"
														data-valid-method="submit" name="Hospital Name"
														ng-if="companyList.length == 1" readonly>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Name

												</label>
												<div class="col-md-7">
													<selectivity list="employeeList"
														property="payslipgeneration.employeeId"
														ng-model="payslipgeneration.employeeId"
														name="Employee Name" form-name="payslipReportForm"></selectivity>
												</div>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<!-- 			<input type="text" class="form-control"
								              	name="kmc"
								               value="" data-ng-model="payslipgeneration.branchName"  readonly> -->
													<selectivity list="branchList"
														property="payslipgeneration.branchId"
														ng-model="payslipgeneration.branchId" name="branchId"
														form-name="payslipReportForm" validation="required"
														friendly-name="Branch Name" ng-if="branchList.length > 1"></selectivity>

													<input type="text" class="form-control input-sm"
														ng-model="payslipgeneration.branchName"
														message-id="branchId" data-validator="required"
														data-valid-method="submit" name="Hospital Name"
														ng-if="branchList.length == 1 || branchList.length == 0 "
														readonly>

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Month <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<!-- <selectivity list="monthList"
														property="payslipgeneration.monthYear" id="monthYear"
														ng-model="payslipgeneration.monthYear" name="monthYear"
														form-name="payslipReportForm" validation="required"
														friendly-name="Month"> </selectivity> -->


													<select id="month" multiple="multiple" name="month"
														ng-model="payslipgeneration.lmonth"
														ng-options="option.text for option in monthList"
														data-dropdownmultiselect form-name="payslipReportForm"
														validation="required" friendly-name="Month">
														<option data-ng-repeat="option in monthList"
															value="{{getMonthId(option)}}"
															data-ng-bind-template="{{option.text}}"></option>
													</select>


													<!-- <select class="form-control" ng-model="payslipgeneration.month"
												name="Month" validation="required" friendly-name="Month" >
												<option value=""> --Select--</option>
						           					<option value="01">January</option>
										   				 <option value="02">February</option>
										   				 <option value="03">March</option>
										   				 <option value="04">April</option>
										   				 <option value="05">May</option>
										   				 <option value="06">June</option>
										   				 <option value="07">July</option>
										   				 <option value="08">August</option>
										   				 <option value="09">September</option>
										   				 <option value="10">October</option>
										   				 <option value="11">November</option>
										   				 <option value="12">December</option>
			                       	 				</select> -->
												</div>

											</div>

											<div class="form-group">
												<div class="inline-block;">
													<label class="col-md-5 control-label"> </label>
													<div class="col-md-5">
														<button class="btn btn-success" type="button"
															data-ng-click="save(payslipReportForm)"
															class="btn btn-success">Show</button>
														<!-- <button class="btn btn-success" type="button"
															data-ng-click="exportExcel()" class="btn btn-success">
															Export</button>
															
														 -->	
														 <button class="btn btn-primary" type="button" data-ng-click="exportExcel()"   >
								        <span class="fa fa-file-excel-o"></span> Export Excel
								         <a id="Export" stype="display:none"
											href="filePath/PayslipReport.xls" download="PayslipReport.xls"></a>																						
								       </button>
								
															
															
														<div id="btnRowDivId"></div>
													</div>
												</div>
											</div>

										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Department </label>
												<div class="col-md-7">
													<selectivity list="departmentList"
														property="payslipgeneration.departmentId"
														ng-model="payslipgeneration.departmentId"
														name="departmentId" form-name="payslipReportForm"></selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Year <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<selectivity list="paySlipYearList"
														property="payslipgeneration.year"
														ng-model="payslipgeneration.year" name="year"
														form-name="payslipReportForm" validation="required"
														friendly-name="Year"></selectivity>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div style="padding-left: 25%; margin-top: 3%;"
									ng-repeat="payslip in paySlipListDTO"
									ng-if="payslipgeneration.isGenerate">
									<table style="width: 70%;" class="table b-dark">
										<tbody>
											<tr class="b-l b-r b-b">
												<th colspan="2">Organization: <span style="">{{payslip.company
														| uppercase}}</span></th>
												<th colspan="2"></th>
												<!-- <th colspan="2">LOP AMOUNT: <span style="">{{payslip.lopAmount
														| uppercase}}</span></th> -->
											</tr>
											
											<tr class="b-l b-r b-b">
												<th colspan="2">EMPLOYEE ID: <span style="">{{payslip.empId
														| uppercase}}</span></th>
												<th colspan="2">LOP DAYS: <span style="">{{payslip.lopDays
														| uppercase}}</span></th>
											</tr>
											<tr class="b-l b-r b-b">
												<th colspan="2">EMPLOYEE NAME: <span style="">{{payslip.empName
														| uppercase}}</span></th>
												<th colspan="2"></th>
												<!-- <th colspan="2">LOP AMOUNT: <span style="">{{payslip.lopAmount
														| uppercase}}</span></th> -->
											</tr>
											<tr class="b-l b-r b-b">
												<th colspan="2">NUMBER OF LEAVES TAKEN: <span style="">{{payslip.employeeLeaveTaken}}</span></th>
												<th colspan="2"></th>
											</tr>
											<tr class="b-l b-r b-b">
												<th colspan="2">NUMBER OF LEAVES AVAILABLE: <span
													style="">{{payslip.employeeLeaveAvailable}}</span></th>
												<th colspan="2"></th>
											</tr>
											<tr class="b-l b-r b-b">
												<th colspan="2" class="text-center">EARNINGS</th>
												<th colspan="2" class="b-l text-center">DEDUCTIONS</th>
											</tr>
											<tr class="b-l b-r b-b">
												<td colspan="2">
													<table width="100%" class="table table-striped">
														<tr ng-repeat="earnings in payslip.earningsList">
															<td>{{earnings.paycomponentname}}</td>
															<td class="text-right">{{earnings.amount}}</td>
														</tr>
													</table>

												</td>
												<td colspan="2" class="b-l">
													<table width="100%" class="table table-striped">
														<tr ng-repeat="deduction in payslip.deductionsList">
															<td ng-if="deduction.payComponentId!='LOPAM'"
																ng-hide="deduction.amount==0">{{deduction.paycomponentname}}</td>
															<td ng-if="deduction.payComponentId=='LOPAM'"
																ng-hide="deduction.amount==0">LOP AMOUNT</td>
															<td class="text-right" ng-hide="deduction.amount==0">{{deduction.amount}}</td>
														</tr>
														<td ng-hide="payslip.lopAmount==0">LOP AMOUNT</td>
														<td class="text-right" ng-hide="payslip.lopAmount==0">{{payslip.lopAmount}}</td>
													</table>
												</td>
											</tr>
											<tr class="b-b b-l b-r">
												<!-- <th class="b-l text-left">GROSS PAY</th>
												<th class="b-l text-right" style="padding-right: 5%;">{{payslip.totalEarnings}}</th> -->
												<th class="b-l text-left">TOTAL EARNING</th>
												<th class="text-right">{{payslip.totalEarnings}}</th>
												<th class="b-l b-t text-left">TOTAL DEDUCTION</th>
												<th class="b-l text-right" style="padding-right: 5%;">{{payslip.totalDeductions}}</th>
											</tr>
											<tr class="b-b b-l b-r">
												<th class="b-l text-left"></th>
												<th class="text-right"></th>
												<th class="b-l b-t text-left">NET PAY</th>
												<th class="b-l text-right" style="padding-right: 5%;">{{(payslip.totalEarnings
													- payslip.totalDeductions)}}</th>
											</tr>
										</tbody>

									</table>
									<div class="form-actions">
										<div class="row">
											<div class="col-md-12">
												<button class="btn btn-dark" type="button"
													data-ng-click="printPaySlip(payslip.empId,payslip.departmentId)">
													<i class="fa fa-print"></i> Print
												</button>
												<button class="btn btn-primary" type="button"
													data-ng-click="emailPaySlip(payslip.empId,payslip.departmentId)">
													<i class="fa fa-envelope-o"></i> Email
												</button>
											</div>
										</div>
									</div>
								</div>

								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-primary" type="button"
												data-ng-click="bulkmail(payslip.empId,payslip.departmentId)">
												<i class="fa fa-envelope-o"></i> Bulk Mail
											</button>
										</div>
									</div>
								</div>
								<!-- <div ng-repeat ="payslip in paySlipListDTO" ng-if="payslipgeneration.isGenerate" >
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset >
									
										 <div class="col-sm-6 col-md-6 col-lg-6">
										 		<div>
												<div class="form-group" >
													<label class="col-md-5 control-label"> EmployeeID
													</label>
													<div class="col-md-5">
							 							<label class="col-md-5 control-label">{{payslip.empId}}
														</label>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-6 control-label"> Earnings
													</label>
												</div>
												</div>
												<div class="form-group" ng-repeat ="earnings in payslip.earningsList"> 
													<label class="col-md-5 control-label"> {{earnings.payComponentId}}
													</label>
													<div class="col-md-5">
							 							<label class="col-md-5 control-label">{{earnings.amount}}
														</label>
													</div>
												</div>
												<div class="form-group">
												<label class="col-md-5 control-label">Gross Pay
												</label>
												<div class="col-md-5">
						 							<label class="col-md-5 control-label">{{payslip.totalEarnings}}
													</label>
												</div>
											</div>
												</div>
											<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-4 control-label"> EmployeeName
												</label>
												<div class="col-md-5">
						 							<label class="col-md-8 control-label">{{payslip.empName}}
													</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-6 control-label"> Deduction
												</label>
											</div>
											<div class="form-group" ng-repeat ="deduction in payslip.deductionsList">
												<label class="col-md-5 control-label"> {{deduction.payComponentId}}
												</label>
												<div class="col-md-5">
						 							<label class="col-md-5 control-label">{{deduction.amount}}
													</label>
												</div>
												
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Net Pay
												</label>
												<div class="col-md-5">
						 							<label class="col-md-5 control-label">{{payslip.totalEarnings - payslip.totalDeductions}}
													</label>
												</div>
											</div>
											</div>
											</fieldset>
									</div>
										
									</div> -->

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