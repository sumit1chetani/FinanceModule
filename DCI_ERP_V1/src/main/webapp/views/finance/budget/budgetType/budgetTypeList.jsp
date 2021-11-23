<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	
	<style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		
		<%@include file="/views/templates/panel-header.jsp"%>
		
		<div class="panel-body ">
			<div class="table-responsive ">
				<table
					class="table table-striped b-t b-light table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
	         
	           <th class="sorting width_10" >Budget Type</th>
	           <th class="sorting width_10" >Expenses</th>
	           <th class="sorting width_5">Action</th>
        	</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objListItem in displayedCollection">
		       	<td class="width_10" ng-bind="objListItem.budget_type"></td>
		       	<td class="width_10" ng-bind="objListItem.expenses"></td>
		
		       <td class="td-actions text-center">
		       <security:authorize access="hasRole('${form_code}_${modify}')">
			         <i class="fa fa-pencil text-success text" data-ng-click="edit(objListItem.budget_type_id)" tooltip="Edit"></i>
		       </security:authorize>
		        <%-- <security:authorize access="hasRole('${form_code}_${view}')">
			         <span ng-if="objListItem.status == 'Approved'">
			         	<i class="fa  fa-list-alt text-dark text" data-ng-click="viewAllocation(objListItem.budget_allocation_id)" tooltip="View"></i>
			         </span>
		        </security:authorize>
		        <security:authorize access="hasRole('${form_code}_${delete}')">
			        <span class="width_10" ng-if="objListItem.status != 'Approved'">
			         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteAllocation(objListItem.budget_allocation_id,$index)" tooltip="Delete"></i>
			        </span>
		        </security:authorize> --%>
		       </td>
	    	</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>