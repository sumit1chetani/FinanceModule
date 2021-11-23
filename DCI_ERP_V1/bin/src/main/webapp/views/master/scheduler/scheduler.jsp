

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>

	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body float-left padding-10" style="width: 100%;">
		<div class="table-responsive" style=" border: 1px solid #CCC;">
			<table class="table table-striped table-hover dataTable no-footer">
				<thead class="dataTables-Main-Head">
				<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
					<tr>
							<th class="sorting width_20" st-sort="schedId">Scheduler Id</th>
							<th class="sorting width_20" st-sort="taskName">Task Name</th>
							<th class="sorting width_20" st-sort="nextRunTime">Next Run
								Time</th>
							<th class="sorting width_20" st-sort="lastRunTime">Last Run
								TIme</th>
							<th class="sorting width_20" st-sort="status">Status</th>
<%-- 							<security:authorize access="hasRole('${form_code}_${add}')"> --%>
							<th class="sorting width_15 text-center">Action</th>
<%-- 							</security:authorize> --%>
						</tr>
				<tbody class="dataTables-Main-Body" ng-repeat="objSchedulerItem in displayedCollection">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
							<td>{{objSchedulerItem.schedId}}</td>
							<td>{{objSchedulerItem.taskName}}</td>
							<td>{{objSchedulerItem.nextRunTime}}</td>
							<td>{{objSchedulerItem.lastRunTime}}</td>
							<td>{{objSchedulerItem.status}}</td>
<%-- 							<security:authorize access="hasRole('${form_code}_${add}')"> --%>
							<td><a ng-click="execute(objSchedulerItem)"> <span
									 class="tool-tip-span font-blue"><font
										color="blue">Execute Now</font></span></a></td>
						</tr>
				</tbody>
			</table>
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>
