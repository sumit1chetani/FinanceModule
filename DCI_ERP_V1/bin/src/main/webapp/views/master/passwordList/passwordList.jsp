

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
						<th class="sorting width_3" st-sort="branchCode">Employee Id</th>
						<th class="sorting width_6" st-sort="branchName">Name</th>
						<th class="sorting width_6" st-sort="company">Password</th>
						
					</tr>
				</thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="objBranchListItem in displayedCollection">
						<td class="sorting">{{objBranchListItem.userId}}</td>						
						<td class="wrapping" data-toggle="tooltip"
							title="{{objBranchListItem.branchName}}">{{objBranchListItem.username}}</td>
						<td class="wrapping" data-toggle="tooltip"
							title="{{objBranchListItem.company}}">{{objBranchListItem.password}}</td>
						
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
