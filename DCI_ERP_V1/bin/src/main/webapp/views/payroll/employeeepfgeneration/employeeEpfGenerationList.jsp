

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>

	<div class="panel panel-default panel-default-list" st-persist="empEPFGenerationTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<br>
			<form class="form-horizontal" name="employeeepfgeneration"
				role="form">
				<div class="row">


									<div class="col-sm-12 col-md-12 col-lg-12 ">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-5">
												<!-- 	<selectivity list=companyList
														property="epfGeneration.companyId"
														ng-model="epfGeneration.companyId" id="companyId"
														name="companyId" form-name="employeeepfgeneration"
														validation="required" friendly-name="Hospital Name"
														ng-if="companyList.length > 1"></selectivity>

													<input type="text" class="form-control input-sm"
														ng-model="epfGeneration.companyName"
														message-id="companyId" data-validator="required"
														data-valid-method="submit" name="Hospital Name"
														ng-if="companyList.length == 1 || companyList.length == 0"
														readonly> -->
														 <selectivity list="companyList"
										property="epfGeneration.companyId" id="companyId"
										object="companyId"></selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> Branch <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-5">

													<selectivity list=branchList
														property="epfGeneration.branchId"
														ng-model="epfGeneration.branchId" id="branchId"
														name="branchId" form-name="employeeepfgeneration"
														validation="required" friendly-name="Branch Name"
														ng-if="branchList.length > 1"></selectivity>

													<input type="text" class="form-control input-sm"
														ng-model="epfGeneration.branchName" message-id="branchId"
														data-validator="required" data-valid-method="submit"
														name="Hospital Name"
														ng-if="branchList.length == 1 || branchList.length == 0"
														readonly>
												</div>
											</div>

										</div>


										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label"> Department </label>
												<div class="col-md-5">

													<selectivity list=departmentList
														property="epfGeneration.departmentId"
														ng-model="epfGeneration.departmentId" id="departmentId"
														name="departmentId" form-name="employeeepfgeneration"></selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Month And Year
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
													<!-- <select  class="form-control journalVoucher-textBox"ng-model="epfGeneration.monthYear" ng-options="master.monthYear as master.monthValue for master in monthYearList"
														  name="Employee No" data-validator="required" data-message-id="monthYear" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
													<selectivity list=monthYearList
														property="epfGeneration.monthYear"
														ng-model="epfGeneration.monthYear" id="monthYear"
														name="monthYear" form-name="employeeepfgeneration"
														validation="required" friendly-name="Month Year"></selectivity>
												</div>
											</div>

										</div>

										<div class="form-group">
											<div class="row">
												<label class="col-md-5 control-label"> </label>
												<div class="col-md-5">
													<button class="btn btn-success" type="button"
														data-ng-click="submit(employeeepfgeneration)">
														Submit</button>
												</div>

											</div>
										</div>
									</div>
								</div>
							</form>
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">
								<!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
								
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<tr>
										<th class="sorting width_10" st-sort="employeeId">Employee
											Id</th>
										<th class="sorting width_10" st-sort="employeeName">Employee
											Name</th>
										<th class="sorting width_10" st-sort="epfNo">UAN No</th>
									<!-- 	<th class="sorting width_10" st-sort="amount">EPF No</th> -->
										<th class="sorting width_10" st-sort="salary">Salary</th>
										<th class="sorting width_10" st-sort="epfWages">EPF Wages</th>
										<th class="sorting width_10" st-sort="epfEmployer">E.EE'S EPF 12%</th>
										<!-- <th class="sorting width_10" st-sort="amount">EPF
											Employee</th> -->
										<th class="sorting width_8" st-sort="eps">E.ER'S EPS 8.33%</th>
										<th class="sorting width_8" st-sort="epf">E.ER'S EPF 3.67%</th>
										<!-- <th class="sorting width_8" st-sort="amount">EDLI .50%</th> -->
										<!-- <th class="sorting width_13" st-sort="amount">Admin
											Charges .65%</th> -->
									</tr>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="epfGeneration in displayedCollection">
											<td>{{epfGeneration.employeeId}}</td>
											<td>{{epfGeneration.employeeName}}</td>
											<td>{{epfGeneration.epfNo}}</td>
											<td>{{epfGeneration.salary}}</td>
											<td>{{epfGeneration.epfWages}}</td>
<!-- 											<td>{{epfGeneration.epfSelf}}</td> -->
											<td>{{epfGeneration.epfEmployer}}</td>       <!-- This is for EPF Self -->
											<td>{{epfGeneration.eps}}</td>
											<td>{{epfGeneration.epf}}</td>
											<!-- <td>{{epfGeneration.edli}}</td> -->
											<!-- <td>{{epfGeneration.admc}}</td> -->
										</tr>
									</tbody>
								</table>
								  <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
							</div>
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
									<!-- 	<button class="btn btn-success" class="btn btn-success"
											type="button" data-ng-model="add"
											ng-click="exportXl(employeeepfgeneration)">
											<i class="fa fa-save"></i> Export
										</button> -->
										
											<!-- <button class="btn btn-primary" type="button" data-ng-click="exportXl(employeeepfgeneration)"   >
								        <span class="fa fa-file-excel-o"></span> Export Excel
								         <a id="Export" stype="display:none"
											href="filePath/Employeeepdf.xls" download="EmployeeEPF.xls"></a>	
											</button>	 -->
											
												 <button class="btn btn-primary" type="button" data-ng-click="exportXl(employeeepfgeneration)"   >
								        <span class="fa fa-file-excel-o"></span> Export Excel
								         <a id="Export" stype="display:none"
											href="filePath/Employeeepdf.xls" download="Employeeepdf.xls"></a>																						
								       </button>
								
										<div id="btnRowDivId"></div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>