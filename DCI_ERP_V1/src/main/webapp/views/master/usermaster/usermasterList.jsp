<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection"  st-persist="usermasterTable" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-10">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table
					class="table table-striped b-t b-light table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>
							<!-- <th class="width_1 text-center table-heading">
								            <label class="i-checks m-b-none">
								             <input type="checkbox">
								             <i></i>
								            </label>
								           </th> -->
						
							<th class="sorting width_10" st-sort="empId">User
								ID</th>
							<th class="sorting width_15" st-sort="firstName">User
								Name</th>
							<th class="sorting width_10" st-sort="branchName">Branch</th>
							<th class="sorting width_20" st-sort="departmentName">Department</th>
							<th class="sorting width_15" st-sort="dob1">DOB</th>
							<th class="sorting width_15" st-sort="doj1">DOJ</th>
								<th class="sorting width_15" st-sort="emailId">Email</th>
							<th class="sorting width_25" st-sort="designationName">Designation</th>
							<th class="sorting width_25" st-sort="vendor">Agent/Employee</th>
							<th class="sorting width_25" st-sort="userlocation">User Location</th>
							<th class="sorting width_25" st-sort="status">Active</th>
							<th class="width_5 text-center table-heading">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="employee in displayedCollection">
							<!-- <td data-cs-select="employee" class="text-center"></td> -->
							
							
							<td class="sorting"><security:authorize access="hasRole('${form_code}_${view}')"> 
							<a ng-click="view(employee.empId)">
								<span tooltip="{{employee.empId}}" class="tool-tip-span font-blue">{{employee.empId}}</span>
								 </a></security:authorize>
								  </td>
							
							<td class="sorting">{{employee.firstName}}</td>
							<td class="sorting">{{employee.branchName}}</td>
							<td class="sorting">{{employee.departmentName}}</td>
							<td class="sorting">{{employee.dob}}</td>
							<td class="sorting">{{employee.doj}}</td>
							<td class="sorting">{{employee.emailId}}</td>
							<td class="sorting">{{employee.designationName}}</td>
							<td class="sorting">{{employee.vendor}}</td>
							<td class="sorting">{{employee.userlocation}}</td>
							<td class="sorting">{{employee.status}}</td>
							<td class=" td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span><i class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(employee.empId)"></i> </span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(employee.empId)"></i>
									</span>
								</security:authorize></td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>
</div>