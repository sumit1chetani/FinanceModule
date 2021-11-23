<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list" st-persist="permissionReqTable"
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
<!-- <th class="width_1"></th>				 -->
<th class="sorting width_15" st-sort="designation">Employee Name</th>
										<th class="sorting width_15" st-sort="designation">ID</th>

										<th class="sorting width_15" st-sort="designation">Permission Date</th>
										<th class="sorting width_15" st-sort="" >Hours From</th>
										<th class="sorting width_15" st-sort="" >Hours To</th>
										<th class="sorting width_15" st-sort="">Request Date</th>
										<th class="sorting width_15" st-sort="">Reason</th>
										<th class="sorting width_15" st-sort="">Status</th>
           <th class="width_5 text-center table-heading"><%-- <spring:message code="label.action"></spring:message> --%>Action</th>
									</tr>
								</thead>
								<tbody class="dataTables-Main-Body">
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" data-ng-repeat="permissionrequest in displayedCollection">
<!-- 										<td data-cs-select="designation"></td> -->
										<td>{{permissionrequest.employeeno}}</td>
										
								<td>{{permissionrequest.permissionrequestid}}</td>
										
										<td>{{permissionrequest.permissiondate}}</td>
										<td>{{permissionrequest.hoursfrom}}</td>
										<td>{{permissionrequest.hoursto}}</td>
										<td>{{permissionrequest.requesteddate}}</td>
										<td>{{permissionrequest.reason}}</td>
										<td>{{permissionrequest.status}}</td>

										<td class=" td-actions text-center">
										<security:authorize access="hasRole('${form_code}_${modify}')">
										<span><i class="fa  fa-pencil text-success text" data-ng-click="editRow(permissionrequest)"></i></span>
										</security:authorize>
										<security:authorize access="hasRole('${form_code}_${delete}')">
										<span>
										<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(permissionrequest,$index)"></i>
										</span>
										</security:authorize>
										</td>
									</tr>
								</tbody>
							</table>
			<div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div>
								<!-- <button type="button"
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