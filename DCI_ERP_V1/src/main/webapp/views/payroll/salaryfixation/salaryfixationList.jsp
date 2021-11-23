<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="salaryFixnationTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-0">
		<br>
		<form class="form-horizontal" name="salaryfixationListForm"
								role="form">
								<div class="row">
									<fieldset>
										<div class="col-sm-12 col-md-12 col-lg-12 ">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-5 control-label"> Organization <span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<!-- <selectivity list=companyList
															property="employeePaycomponenet.companyId"
															ng-model="employeePaycomponenet.companyId" id="companyId"
															name="companyId" form-name="salaryfixationListForm"
															validation="required" friendly-name="Hospital Name"
															ng-if="companyList.length > 1"> </selectivity>
														<input type="text" class="form-control input-sm"
															ng-model="employeePaycomponenet.companyName"
															message-id="companyId" validation="required"
															friendly-name="Hospital Name" name="Hospital Name"
															ng-if="companyList.length == 1" readonly> -->
																<selectivity list="companyList"
										property="employeePaycomponenet.companyId" id="companyId"
										object="companyId"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label"> Branch <span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<selectivity list=branchList
															property="employeePaycomponenet.branchId"
															ng-model="employeePaycomponenet.branchId" id="branchId"
															name="branchId" form-name=salaryfixationListForm
															validation="required" friendly-name="Branch Name"
															ng-if="branchList.length > 1"> </selectivity>
														<input type="text" class="form-control input-sm"
															ng-model="employeePaycomponenet.branchName"
															message-id="branchId" data-validator="required"
															data-valid-method="submit" name="Hospital Name"
															ng-if="branchList.length == 1 || branchList.length == 0 "
															readonly>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-5 control-label"> Department </label>
													<div class="col-md-5">
														<selectivity list="departmentList"
															property="employeePaycomponenet.departmentId"
															id="Department Name" name="Department Name"
															data-ng-model="employeePaycomponenet.departmentId"
															form-name="salaryfixationListForm" validation="required"
															friendly-name="Department"> </selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label"> Employee</label>
													<div class="col-md-5">
														<selectivity list="employeeList"
															property="employeePaycomponenet.employeeId"
															id="employeeId" name="employeeId"
															data-ng-model="employeePaycomponenet.employeeId"
															form-name="salaryfixationListForm" validation="required"
															friendly-name="Employee"> </selectivity>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="row">
												<label class="col-md-5 control-label"> </label>
												<div class="col-md-5">
													<button class="btn btn-success" type="button"
														data-ng-click="submit(salaryfixationListForm,employeePaycomponenet)"
														class="btn btn-success">Show</button>
													<button class="btn btn-success" type="button"
														data-ng-click="fileUpload()" class="btn btn-success">
														Import</button>
													<div id="btnRowDivId"></div>
												</div>
											</div>
										</div>
									</fieldset>
								</div>
							</form>

							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">
								<div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
								</div>
								<!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
										    <!-- <th st-sort="department">Department Id</th> -->
											<th st-sort="departmentName">Department Name</th>
											<!-- <th st-sort="employeee">Employee Id</th> -->
											<th st-sort="employeeName">Employee Name</th>
											<th st-sort="fromdate">From Date</th>
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
											<!-- <th st-sort="payComponentName">Other Deduction</th> -->
											<!-- <th st-sort="payComponentName">Net Pay</th> -->
											<th st-sort="">Action</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<%-- <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="employee in displayedCollection">
							<!-- <td data-cs-select="employee" class="text-center"></td> -->
							
							
							<td class="sorting" st-sort="empId"><a ng-click="view(employee)">
								
								<security:authorize access="hasRole('${form_code}_${view}')"> 
								 <span tooltip="{{employee.empId}}" class="tool-tip-span font-blue">{{employee.empId}}</span>
								 </security:authorize>
								  </a></td>
							
							<td class="sorting width_15" st-sort="firstName">{{employee.firstName}}</td>
							<td class="sorting width_15" st-sort="branchName">{{employee.branchName}}</td>
							<td class="sorting width_15" st-sort="departmentCode">{{employee.departmentCode}}</td>
							<td class="sorting width_15" st-sort="dob">{{employee.dob}}</td>
							<td class="sorting width_15" st-sort="doj">{{employee.doj}}</td>
							<td class="sorting width_15" st-sort="designationName">{{employee.designationName}}</td>
							<td class=" td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span><i class="fa  fa-pencil text-success text"
										data-ng-click="editRow(employee.empId)"></i> </span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(employee.empId)"></i>
									</span>
								</security:authorize></td>
										</tr>	 --%>
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="empPayComList in displayedCollection">
											<td>{{empPayComList.departmentName}}</td>
											<td>{{empPayComList.employeeName}}</td>
											<td>{{empPayComList.fromdate}}</td>
											<td>{{empPayComList.BASIC}}</td>
											<td>{{empPayComList.DA}}</td>
											<td>{{empPayComList.HRA}}</td>											
											<td>{{empPayComList.CONVE}}</td>
											<td>{{empPayComList.SPL}}</td>
											<td>{{empPayComList.CONS}}</td>
											<td>{{empPayComList.OTEAR}}</td>										
											<td>{{empPayComList.GROSS}}</td>
											<td>{{empPayComList.MEDIC}}</td>
											<td>{{empPayComList.PFSEL}}</td>
											<td>{{empPayComList.WF}}</td>
											<td class=" td-actions text-center" ><security:authorize
													access="hasRole('${form_code}_${modify}')" >
													<span> <i
														
														class="fa  fa-pencil text-success text"
														data-ng-click="editRow(empPayComList.employeeId,empPayComList.fromdate)"></i>
													</span>
													<!-- <span> <i
														 
														class="fa  fa-pencil text-success text" 
														data-ng-click="editRow(empPayComList.departmentId,empPayComList.employeeId,empPayComList.fromdate)"></i>
													</span>  -->  <!-- ng-if="empPayComList.fromdate==employeePaycomponenet.largeDateValue" -->
												</security:authorize> <security:authorize
													access="hasRole('${form_code}_${delete}')">
												<span> <i
													
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(empPayComList.employeeId,empPayComList.fromdate)"></i>
													</span>
														<span> <i    class="fa  fa-eye text-success text-center" ng-if="empPayComList.checkALreadyCreated == false"
														data-ng-click="viewRow(empPayComList.employeeId,empPayComList.fromdate)"></i>
													</span>
												</security:authorize></td>
										</tr>
									</tbody>
								</table>
								<div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div>
							</div>
							<br>
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">

										<!-- <button data-ng-if="loplist.isEdit" class="btn btn-success"
											type="button" data-ng-click="updateLOPList()"
											class="btn btn-success">Update</button> -->
											<!-- <button data-ng-if="employeePaycomponenet.isEdit" class="btn btn-success" type="button"
														data-ng-click="exportExcel(displayedCollection)" id="sPdfExport" href=""
														download="EmployeeCheckupData.xls"
														class="btn btn-success">Export</button> -->
														<!-- <span class="padding-left-10" 
														ng-click="exportExcel(displayedCollection)"
														data-ng-if="employeePaycomponenet.isEdit"> <a id="Export" href=""
														download
														class="btn btn-success btn-sm"> Export </a>
													</span> --> 
													 <button class="btn btn-primary" data-ng-click="exportExcel(displayedCollection)">
										<span class="fa fa-file-excel-o"> </span> Export to Excel <a
											id="Export" stype="display:none"
											href="filePath/Sample_Employee_Salary_Upload_File.xlsx"
											download="Sample_Employee_Salary_Upload_File.xlsx"></a>
								</button>

									</div>

								</div>


							</div>
						</div>

					</div>
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>


<script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
 <button class="btn btn-info" type="button" ng-click="exportSampleExcel()">DownloadSample</button>
   <button class="btn btn-info" type="button" ng-click="uploadSalary()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
	<div id="btnRowDivIdsamp"> </div>
	</div>
  </div>
 </script>

