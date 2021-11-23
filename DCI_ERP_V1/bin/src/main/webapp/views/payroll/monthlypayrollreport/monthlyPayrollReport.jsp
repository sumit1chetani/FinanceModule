<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
	<%@include file="/views/templates/panel-header-form.jsp"%>		
	
  <div class="panel-body">
					<form name="payrollReportForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
									<div class="col-sm-12 col-md-12 col-lg-12">


										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-6">
													<!-- <input type="text" class="form-control"
								              	name="kmc"
								                data-ng-model="payrollreport.companyName" readonly >
			                       	 	 -->
												<!-- 	<selectivity list="companyList"
														property="payrollreport.companyId" id="companyId"
														ng-model="payrollreport.companyId" name="companyId"
														disabled form-name="payrollReportForm"
														ng-if="companyList.length > 1" validation="required"
														friendly-name="Hospital"> </selectivity>
												 -->	<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrollreport.companyId" ng-options="master.companyId as master.companyName for master in companyList"
														  ng-change="getBranchList(payrollreport.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" data-valid-method="submit" ng-if="!isAuthorized" disabled >
													        <option value=""> --Select--</option>
													        </select> -->
													<!-- <selectivity list="companyList" property="payrollreport.companyId" 
										                id="companyId" ng-model="payrollreport.companyId"
										               name="companyId" ng-if="isAuthorized" disabled  form-name="payrollReportForm"
										               validation="required" friendly-name="Hospital">
										               </selectivity>	 -->
													<!-- <input type="text" class="form-control input-sm"
														ng-model="payrollreport.companyName"
														message-id="companyId" name="Hospital Name"
														ng-if="companyList.length == 1" readonly>
												 -->	<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrollreport.companyId" ng-options="master.companyId as master.companyName for master in companyList"
														  ng-change="getBranchList(payrollreport.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" ng-if="isAuthorized" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
													         <selectivity list="companyList"
										property="payrollreport.companyId" id="companyId"
										object="companyId"></selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> Department 
												</label>
												<div class="col-md-6">
													<selectivity list="departmentList"
														property="payrollreport.departmentId" id="departmentId"
														ng-model="payrollreport.departmentId" name="departmentId"
														form-name="payrollReportForm"
														friendly-name="Department"> </selectivity>
													<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrollreport.departmentId" ng-options="master.departmentId as master.departmentName for master in departmentList"
												   ng-change="getEmployeeList(payrollreport.departmentId)"  name="Department Name" data-validator="required" data-message-id="departmentId" data-valid-method="submit">
											        <option value=""> --Select--</option>
											    </select> -->
												</div>
											</div>



										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-6" ng-if="branchList.length > 1">
													<!-- <input type="text" class="form-control"
								              	name="kmc"
								                data-ng-model="payrollreport.companyName" readonly> -->
													<selectivity list="branchList"
														property="payrollreport.branchId" id="branchId"
														ng-model="payrollreport.branchId" name="branchId"
														form-name="payrollReportForm" validation="required"
														friendly-name="Branch"> </selectivity>
												</div>
												<div class="col-md-6"
													ng-if="branchList.length == 1 || branchList.length == 0">
													<input type="text" class="form-control input-sm"
														ng-model="payrollreport.branchName" message-id="branchId"
														name="Hospital Name" readonly>
													<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrollreport.branchId" ng-options="master.branchId as master.branchName for master in branchList"
														  ng-change="getDepartment(payrollreport.branchId)"   name="Branch Id" data-validator="required" data-message-id="branchId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Name
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-6">
													<selectivity list="employeeList"
														property="payrollreport.employeeId" id="employeeId"
														ng-model="payrollreport.employeeId" name="employeeId"
														form-name="payrollReportForm" validation="required"
														friendly-name="Employee Name"> </selectivity>
													<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrollreport.employeeId" ng-options="master.employeeId as master.employeeName for master in employeeList"
														  ng-change="getEmployeeName(payrollreport.employeeId)"   name="Employee No" data-validator="required" data-message-id="employeeId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
												</div>
											</div>
											
											
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="form-group">
											<div class="row">
												<label class="col-md-5 control-label"> </label>
												<div class="col-md-5">
													<button class="btn btn-success" type="button"
														data-ng-click="getPayrollList(payrollReportForm)"
														class="btn btn-success">Show Payroll List</button>

												</div>
											</div>
										</div>
									</div>
								</div>
							</form>
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">

	<%-- 							<div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
								</div> --%>
								<!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="width_13  st-sort="monthYear">Month</th>
											<th class="width_13   st-sort="employeeId">Employee ID</th>
											<th  class="width_20  st-sort="employeeName">Employee Name</th>
											<th class="width_10 st-sort="BASIC">BASIC</th>
											<th  class="width_10  st-sort="DA">DA</th>
											<th  class="width_10  st-sort="HRA">HRA</th>
											<th class="width_10  st-sort="CONVE">CONVE</th>
											<th  class="width_10  st-sort="SPL">SPL</th>
											<th  class="width_10  st-sort="CONS">CONS</th>
											<th  class="width_15  st-sort="OTEAR">Other Earnings</th>
											<th class="width_12  st-sort="GROSS">Gross Pay</th>
											<th class="width_10  st-sort="MEDIC">MEDIC</th>
											<th class="width_10  st-sort="PFSEL">PFSEL</th>
											<th class="width_10  st-sort="WF">WF</th>
											<th class="width_10  st-sort="PT">PT</th>
											<th class="width_10  st-sort="TDS">Tax</th>
											<th class="width_10  st-sort="Tele">Tele</th>
											<th class="width_10  st-sort="US">US</th>
											<th class="width_10  st-sort="AD">AD</th>
											<th class="width_15  st-sort="TR1">Train.Fee</th>
											<th class="width_10  st-sort="OTD">Others</th>
											<!-- <th st-sort="OTDED">Other Deduction</th> -->
											<th class="width_10"st-sort="NET">Net Pay</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="payRollList in displayedCollection">

											<td>{{payRollList.monthYear}}</td>
											<td>{{payRollList.employeeId}}</td>
											<td>{{payRollList.employeeName}}</td>
											<td>{{payRollList.BASIC}}</td>
											<td>{{payRollList.DA}}</td>
											<td>{{payRollList.HRA}}</td>
											<td>{{payRollList.CONVE}}</td>
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
									<footer class="panel-footer panel-footer-list">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>
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