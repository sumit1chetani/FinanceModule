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
		
		
		
		
		<div class="panel-body float-left padding-0" style="width: 100%;">
<%-- 			     <security:authorize access="hasRole('${form_code}_${add}')"/>
 --%>		
			<!-- <div class="table-responsive "> -->
			<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
								  <thead class="dataTables-Main-Head">
          <tr>
<!--            <th class="width_1 text-center table-heading"> -->
<!--             <label class="i-checks m-b-none"> -->
<!--              <input type="checkbox"> -->
<!--              <i></i> -->
<!--             </label> -->
<!--            </th> -->
           <th class="sorting width_15" data-st-sort="shortName"><%-- <spring:message code="label.leave.code"></spring:message> --%>Leave Type code	 </th>
           <th class="sorting width_15" data-st-sort="leaveTypeName"><%-- <spring:message code="label.leave.name"></spring:message> --%>Leave Type	</th>
           <th class="sorting width_15" data-st-sort="canCarryForward">Carry Forward</th>
           <th class="sorting width_15" data-st-sort="carryForwardLimit">	Carry Forward Limit</th>
           <th class="sorting width_15" data-st-sort="status">Active</th>
           <th class=sorting width_15" data-st-sort="action">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" data-ng-repeat="leaveType in displayedCollection">
<!--            <td cs-select="leaveType" class="text-center"></td> -->
			<td>{{leaveType.shortName}}</td>
			<td>{{leaveType.leaveTypeName}}</td>
			<td data-ng-if="leaveType.canCarryForward">
						<input type="checkbox" checked="checked" disabled="disabled">
			</td>
			<td data-ng-if="!leaveType.canCarryForward">
						<input type="checkbox" disabled="disabled">
			</td> 
			<td>{{leaveType.carryForwardLimit}}</td>
			<td data-ng-if="leaveType.status">
						<input type="checkbox" checked="checked" disabled="disabled">
			</td>
			<td data-ng-if="!leaveType.status" >
						<input type="checkbox" disabled="disabled">
			</td>
			  <td class=" td-actions text-center">
			  <access="hasRole('${form_code}_${modify}')">
		        <span>
		         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(leaveType)"></i>
		        </span>
		     	<access="hasRole('${form_code}_${delete}')">
			        <span>
			         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(leaveType)"></i>
			        </span>
       </td>
          </tr>
         </tbody>
								</table>
			<div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div>
<!-- 								<button type="button"
									class="btn btn-success btn-sm margin-bottom-10 margin-left-2"
									ng-click="applyLeavesToEmployees(displayedCollection)">Apply
									Leaves To Employees</button> -->
			<!-- </div> -->
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
		
	
	</div>
</div>