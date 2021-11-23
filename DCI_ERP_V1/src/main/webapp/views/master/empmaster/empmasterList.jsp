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
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-0">
			<div class="table-responsive ">
				<table
					class="table table-striped b-t b-light table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<!-- <th class="width_1 text-center table-heading">
								            <label class="i-checks m-b-none">
								             <input type="checkbox">
								             <i></i>
								            </label>
								           </th> -->
						
							<th class="sorting width_8" st-sort="empId">Employee
								ID</th>
							<th class="sorting width_15" st-sort="firstName">Employee
								Name</th>
							<th class="sorting width_10" st-sort="branchName">Branch</th>
							<th class="sorting width_20" st-sort="departmentCode">Department</th>
							<th class="sorting width_15" st-sort="dob">DOB</th>
							<th class="sorting width_15" st-sort="doj">DOJ</th>
							<th class="sorting width_25" st-sort="designationName">Designation</th>
							<th class="sorting width_25" st-sort="userLocation">User Location</th>
							<th class="sorting width_25" st-sort="status">Active</th>
							
							<th class="width_5 text-center table-heading">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
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
							<td class="sorting width_15" st-sort="userLocation">{{employee.userLocation}}</td>
							<td class="sorting width_15" st-sort="status">{{employee.status}}</td>
							
							<td class=" td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span><i class="fa  fa-pencil text-success text"
										data-ng-click="editRow(employee.empId)"></i> </span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(employee.empId)"></i>
									</span>
								</security:authorize></td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						</div>
					</div>
				</div>
		<!-- end widget content -->
	</div>
	</div>
	