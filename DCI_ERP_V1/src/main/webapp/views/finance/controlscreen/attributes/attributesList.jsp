<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body float-left padding-0">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="width_1"><label class="i-checks m-b-none">
									<input type="checkbox" name="post[]"> <i></i>
							</label></th>
							<th class="sorting width_50" st-sort="attributename">Attribute Name</th>
							<th class="sorting width_50" st-sort="attributename">Attribute Value</th>
							 <th class="width_25">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objAttribute in displayedCollection">
							<td class=""><label class="i-checks m-b-none"> <input
									type="checkbox" name="post[]"> <i></i>
							</label></td>
							<td class="sorting  width_50" ng-bind="objAttribute.attributeName"></td>
							<td class="sorting  width_50" ng-bind="objAttribute.attributeValue"></td>
							 <td class="td-actions text-center">
						        <span >
						         <i class="fa fa-pencil text-success text" data-ng-click="edit(objAttribute)" tooltip="Edit">
						         </i>
						        </span>
						        <span class ="padding-left-10">
						         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="delete(objAttribute)" tooltip="Delete"></i>
						        </span>
						      </td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer.jsp"%>
			</footer>
		</div>
	</div>
</div>