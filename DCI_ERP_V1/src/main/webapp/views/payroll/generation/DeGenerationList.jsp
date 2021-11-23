

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<!-- <style>/* 
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;} */
table{ table-layout: fixed; width: 70%; }


</style> -->

 <div class="panel panel-default panel-default-list" st-persist="deGenerationTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
  <div class="panel-body float-left padding-0" style="width: 100%;">
  <br>
  <form class="form-horizontal" name="payrolldegenerationform"
								role="form">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">


										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<!-- <selectivity list=companyList
														property="payrolldegeneration.companyId"
														ng-model="payrolldegeneration.companyId" id="companyId"
														name="companyId" form-name="payrolldegenerationform"
														validation="required" friendly-name="Hospital Name"
														ng-if="companyList.length > 1"></selectivity>

													<input type="text" class="form-control input-sm"
														ng-model="payrolldegeneration.companyName"
														message-id="companyId" data-validator="required"
														data-valid-method="submit" name="Hospital Name"
														ng-if="companyList.length == 1" readonly>
											 --> <selectivity list="companyList"
										property="payrolldegeneration.companyId" id="companyId"
										object="companyId"></selectivity>	</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Name

												</label>
												<div class="col-md-7">
													<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrolldegeneration.employeeId" ng-options="master.employeeId as master.employeeName for master in employeeList"
														  ng-change="getEmployeeName(payrolldegeneration.employeeId)"   name="Employee No" data-validator="required" data-message-id="employeeId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
													<selectivity list=employeeList
														property="payrolldegeneration.employeeId"
														ng-model="payrolldegeneration.employeeId" id="employeeId"
														name="employeeId" form-name="payrolldegenerationform"></selectivity>
												</div>
											</div>


										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrolldegeneration.branchId" ng-options="master.branchId as master.branchName for master in branchList"
														  ng-change="getDepartment(payrolldegeneration.branchId)"   name="Branch Id" data-validator="required" data-message-id="branchId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
													<selectivity list=branchList
														property="payrolldegeneration.branchId"
														ng-model="payrolldegeneration.branchId" id="branchId"
														name="branchId" form-name="payrolldegenerationform"
														validation="required" friendly-name="Branch Name"
														ng-if="branchList.length > 1"></selectivity>
													<input type="text" class="form-control input-sm"
														ng-model="payrolldegeneration.branchName"
														message-id="branchId" data-validator="required"
														data-valid-method="submit" name="Branch Name"
														ng-if="branchList.length == 1 || branchList.length == 0 "
														readonly>

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Month And Year
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<!-- <select  class="form-control journalVoucher-textBox"ng-model="payrolldegeneration.monthYear" ng-options="master.monthYear as master.monthValue for master in monthYearList"
												 data-validator="required" data-message-id="monthYear" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
													<selectivity list=monthYearList
														property="payrolldegeneration.monthYear"
														ng-model="payrolldegeneration.monthYear" id="monthYear"
														name="monthYear" form-name="payrolldegenerationform"
														validation="required" friendly-name="Month Year"></selectivity>
												</div>

											</div>


										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Department </label>
												<div class="col-md-7">
													<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrolldegeneration.departmentId" ng-options="master.departmentId as master.departmentName for master in departmentList"
												  ng-change="getEmployeeList(payrolldegeneration.departmentId)"  name="Department Name" data-validator="required" data-message-id="departmentId" data-valid-method="submit">
											        <option value=""> --Select--</option>
											    </select> -->
													<selectivity list=departmentList
														property="payrolldegeneration.departmentId"
														ng-model="payrolldegeneration.departmentId"
														id="departmentId" name="departmentId"
														form-name="payrolldegenerationform"></selectivity>

												</div>
											</div>

										</div>

									</div>
								</div>
								<div class="form-group">
									<div class="row">
										<label class="col-md-5 control-label"> </label>
										<div class="col-md-5">
											<button class="btn btn-success" type="button"
												data-ng-click="getSalaryList(payrolldegenerationform)"
												class="btn btn-success">Show</button>

										</div>
									</div>
								</div>

							</form>
							<br><br><br>
							<div class="row" data-ng-if="payrolldegeneration.isGenerate">
								<div class="col-sm-12 col-md-12 col-lg-12 panel-body">
									<label>Payroll has been generated for the following
										employees for the selected month and year </label>
								</div>
							</div>
							<br><br>

							<div data-ng-if="payrolldegeneration.isGenerate">
								<div
									class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
									st-table="displayedCollection" st-safe-src="rowCollection"
									data-ng-if="payrolldegeneration.isGenerate">

									<div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
									</div>

									<!--   <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>
												<th st-sort="employeeId">Employee ID</th>
												<th st-sort="employeeName">Employee Name</th>
												<th st-sort="BASIC">BASIC</th>
												<th st-sort="DA">DA</th>
												<th st-sort="HRA">HRA</th>
												<th st-sort="CONVE">CONVE</th>
												<!-- <th st-sort="payComponentName">PFCOM</th> -->
												<th st-sort="SPL">SPL</th>
												<th st-sort="CONS">CONS</th>
												<th st-sort="OTEAR">Other Earnings</th>
												<th st-sort="GROSS">Gross Pay</th>
												<th st-sort="MEDIC">MEDIC</th>
												<th st-sort="PFSEL">PFSEL</th>
												<th st-sort="WF">WF</th>
												<th st-sort="PT">PT</th>
												<th st-sort="TDS">Tax</th>
												<th st-sort="Tele">Tele</th>
												<th st-sort="US">US</th>
												<th st-sort="AD">AD</th>
												<th st-sort="TR1">Train.Fee</th>
												<th st-sort="OTD">Others</th>
												<!-- <th st-sort="payComponentName">Other Deduction</th> -->
												<th st-sort="NET">Net Pay</th>

											</tr>
										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="payRollList in displayedCollection">
												<td>{{payRollList.employeeId}}</td>
												<td>{{payRollList.employeeName}}</td>
												<td>{{payRollList.BASIC}}</td>
												<td>{{payRollList.DA}}</td>
												<td>{{payRollList.HRA}}</td>
												<td>{{payRollList.CONVE}}</td>
												<!-- <td>{{empPayComList.PFCOM}}</td> -->
												<td>{{payRollList.SPL}}</td>
												<td>{{payRollList.CONS}}</td>
												<td>{{payRollList.OTEAR}}</td>
												<td>{{payRollList.GROSS}}</td>
												<td>{{payRollList.MEDIC}}</td>
												<td>{{payRollList.PFSEL}}</td>
												<td>{{payRollList.WF}}</td>
												<td>{{payRollList.PT}}</td>
												<td>{{payRollList.TDS}}</td>
												<td>{{payRollList.Tele}}</td>
												<td>{{payRollList.US}}</td>
												<td>{{payRollList.AD}}</td>
												<td>{{payRollList.TR1}}</td>
												<td>{{payRollList.OTD}}</td>
												<!-- <td>{{payRollList.OTDED}}</td> -->
												<td>{{payRollList.NET}}</td>
											</tr>
										</tbody>

									</table>
									<div class="dt-toolbar-footer"
										data-smart-include="views/layout/toolbar-footer.tpl"></div>
								</div>
							</div>

						</div>
						<div class="row">
							<label class="col-md-5 control-label"> </label>
							<div class="col-md-5">
								<button data-ng-if="payrolldegeneration.isDeGenerate"
									class="btn btn-success" type="button"
									data-ng-click="degenerate()" class="btn btn-success">
									DeGenerate</button>

							</div>
						</div>
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