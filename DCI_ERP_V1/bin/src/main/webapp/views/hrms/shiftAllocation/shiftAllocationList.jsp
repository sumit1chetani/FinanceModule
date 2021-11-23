<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<!-- <div class="table-responsive "> -->
			<table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
<!--            <th class="width_1 text-center table-heading"><label class="i-checks m-b-none"> -->
<!--              <input type="checkbox"> <i></i> -->
<!--            </label></th> -->
           <th class="sorting width_12" st-sort="shiftSchemeName"><%-- <spring:message code="label.shiftSchemeName"></spring:message> --%>ShiftSchemeName</th>
           <th class="sorting width_10" st-sort="employeeName"><%-- <spring:message code="label."></spring:message> --%>EmployeeName</th>
           <th class="sorting width_8" st-sort="companyId"><%-- <spring:message code="label."></spring:message> --%>OrganizationId</th>
            <th class="sorting width_10" st-sort="companyName"><%-- <spring:message code="label.companyName"></spring:message> --%>OrganizationName</th>
           <th class="sorting width_10" st-sort="branchName"><%-- <spring:message code="label.branchName"></spring:message> --%>BranchName</th>
           <th class="sorting width_10" st-sort="departmentName"><%-- <spring:message code="label.departmentName"></spring:message> --%>DepartmentName</th>
           <th class="sorting width_12" st-sort="designationName"><%-- <spring:message code="label.designationName"></spring:message> --%>DesignationName</th>
           <th class="sorting width_8" st-sort="validFrom"><%-- <spring:message code="label.validFrom"></spring:message> --%>ValidFrom</th>
           <th class="sorting width_8" st-sort="validTo"><%-- <spring:message code="label.validTo"></spring:message> --%>ValidTo</th>
           <th class="width_5 text-center table-heading"><%-- <spring:message code="label.action"></spring:message> --%>Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objShiftAllocation in displayedCollection">
<!--           <td class="text-center" cs-select="objShiftAllocation"></td> -->
           <td>{{objShiftAllocation.schemeName}}</td>
           <td>{{objShiftAllocation.employeeName}}</td>
           <td>{{objShiftAllocation.companyId}}</td>
           <td>{{objShiftAllocation.companyName}}</td>
           <td>{{objShiftAllocation.branchName}}</td>
           <td>{{objShiftAllocation.departmentName}}</td>
           <td>{{objShiftAllocation.designationName}}</td>
           <td>{{objShiftAllocation.validFrom}}</td>
           <td>{{objShiftAllocation.validTo}}</td>
           <td class=" td-actions text-center">
	          <security:authorize access="hasRole('${form_code}_${modify}')">
		        <span>
	         		<i class="fa fa-pencil text-success text" data-ng-click="editRow(objShiftAllocation.schemeId,objShiftAllocation.employeeId,objShiftAllocation.validFrom,objShiftAllocation.validTo)"></i>
	        	</span>
		        </security:authorize>
		        <security:authorize access="hasRole('${form_code}_${delete}')">
		        <span>
	         		<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objShiftAllocation,$index)"></i>
	        	</span>
		        </security:authorize>
		   </td>
          </tr>
 		</tbody>
        </table>
			<div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div>
								<button type="button"
									class="btn btn-success btn-sm margin-bottom-10 margin-left-2"
									ng-click="applyLeavesToEmployees(displayedCollection)">Apply
									Leaves To Employees</button>
			<!-- </div> -->
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>