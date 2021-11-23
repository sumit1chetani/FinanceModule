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

		<div class="panel-body padding-0">
			<div class="table-responsive ">
				<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="width_1 text-center table-heading"><label
												class="i-checks m-b-none"> <input type="checkbox"
													ng-model="selectedAll"
													ng-change="checkAll(displayedCollection,selectedAll)">
													<i></i>
											</label></th>
											<th class="sorting width_10" data-st-sort="companyName">Organization Name</th>
											<th class="sorting width_10" data-st-sort="gradeName">Branch</th>
											<th class="sorting width_10" data-st-sort="year">Year</th>
											<th class="sorting width_10" data-st-sort="year">Action</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="leaveCollection in displayedCollection">
											<td ng-if="leaveCollection.appliedstatus!='Applied'"
												class="text-center"><input type="checkbox"
												ng-model="leaveCollection.select"></td>
											<td ng-if="leaveCollection.appliedstatus=='Applied'"
												class="text-center"><input type="checkbox"
												ng-model="leaveCollection.select"hidden></td>
											<td>{{leaveCollection.companyName}}</td>
											<td>{{leaveCollection.branch}}</td>
											<td>{{leaveCollection.yearValue}}</td>
											
											  <td class=" td-actions text-center">
													<access="hasRole('${form_code}_${modify}')">
													<span> <i class="fa  fa-pencil text-success text"
														data-ng-click="editRow(leaveCollection)"></i>
													</span>
													<access="hasRole('${form_code}_${delete}')">
													<span> <i
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(leaveCollection,$index)"></i>
													</span>
												</td> 
										</tr>
									</tbody>
								</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						</div>
					</div>
				</div>
		<!-- end widget content -->
	</div>
	</div>
	