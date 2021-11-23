<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		 <style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<!-- <div class="table-responsive "> -->
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead class="dataTables-Main-Head">
						<tr>
							<!--            <th class="width_1 table-heading"><label class="i-checks m-b-none"> -->
							<!--              <input type="checkbox" name="post[]"> -->
							<!--              <i></i> -->
							<!--             </label></th> -->
<!-- 							<th class="sorting width_20" st-sort="companyId">Company</th> -->
							<th class="sorting width_2" st-sort="gradeName">Grade</th>
							<th class="sorting width_2" st-sort="description">Discription</th>
							<th class="sorting width_2" st-sort="status">Active</th>
							<th class="width_2 text-center table-heading">Action</th>
						</tr>

					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="gradeCollections in displayedCollection">
							<!--            <td cs-select="gradeCollections"></td> -->
<!-- 							<td>{{gradeCollections.companyId}}</td> -->
							<td>{{gradeCollections.gradeName}}</td>
							<td>{{gradeCollections.description}}</td>
							<td><input type="checkbox" checked="checked"
								disabled="disabled" ng-model="gradeCollections.status">
							</td>
							<td class=" td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa  fa-pencil text-success text"
										data-ng-click="editRow(gradeCollections)"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(gradeCollections)"></i>
									</span>
								</security:authorize></td>
						</tr>
					</tbody>
				</table>
			<!-- </div> -->
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>