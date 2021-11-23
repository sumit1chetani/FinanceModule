

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
						<!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
						<th class="sorting width_3" st-sort="containerSequenceCode">ContainerSequence Code
						</th>
						<!-- <th class="sorting width_6" st-sort="containerSequenceName">ContainerSequence Short Name</th> -->
						<th class="sorting width_6" st-sort="containerSequenceLocation">ContainerSequence Location</th>						
						<th class="width_2 text-center table-heading">Action</th>
					</tr>
				</thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="objContainerSequenceListItem in displayedCollection">
						<td class="sorting"><security:authorize
								access="hasRole('${form_code}_${view}')">
								<a ng-click="view(objContainerSequenceListItem.containerSequenceCode)"> <span
									tooltip="{{objContainerSequenceListItem.containerSequenceCode}}"
									class="tool-tip-span font-blue">{{objContainerSequenceListItem.containerSequenceCode}}</span>
							</security:authorize> </a></td>						
						<td class="wrapping" data-toggle="tooltip"
							title="{{objContainerSequenceListItem.containerSequenceLocation}}">{{objContainerSequenceListItem.containerSequenceLocation}}</td>
						<!-- <td class="wrapping" data-toggle="tooltip"
							title="{{objContainerSequenceListItem.containerSequenceShortName}}">{{objContainerSequenceListItem.containerSequenceShortName}}</td>	 -->
						
						<td class="td-actions text-center"><security:authorize
								access="hasRole('${form_code}_${modify}')">
								<span class="width_15"> <i
									class="fa fa-pencil text-success text" data-toggle="tooltip" title="Edit"
									data-ng-click="editRow(objContainerSequenceListItem.containerSequenceCode)"
									tooltip="Edit"></i>
								</span>
							</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
								<span class="width_10"> <i
									class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
									data-ng-click="deleteRow(objContainerSequenceListItem.containerSequenceCode,$index)"
									tooltip="Delete"></i>
								</span>
							</security:authorize></td>
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
