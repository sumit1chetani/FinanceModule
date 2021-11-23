<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list" st-persist="commidityListTable"
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
			<table class="table table-striped table-hover dataTable no-footer">
			
				<thead class="dataTables-Main-Head">
					<tr>

						<th class="sorting width_2" st-sort="commodityCode">Commodity
							Code</th>
<!-- 						<th class="sorting width_2" st-sort="classification">Classification</th>
 -->						<th class="sorting width_2" st-sort="commodity">Commodity</th>
						<th class="sorting width_2" st-sort="classificationCode">Hazardous</th>
						<th class="sorting width_2" st-sort="commodityCode">UNNo.</th>
						<th class="sorting width_2" st-sort="classificationCode">Flash Point</th>

						<th class="width_2 text-center table-heading">Action</th>
					</tr>

				</thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="collection in displayedCollection">

						<td><a ng-click="view(collection.commodityCode)"> <span
								tooltip="{{collection.commodityCode}}"
								class="tool-tip-span font-blue">{{collection.commodityCode}}</span>
						</a></td>
<!-- 						<td>{{collection.classification}}</td>
 -->						<td>{{collection.commodity}}</td>
						<td><input type="checkbox"
												class="checkbox style-0" 
												ng-true-value="'Y'" ng-false-value="'N'" name="hazardous"
												ng-model="collection.hazardous" disabled="true"> </td>
						<td>{{collection.unno}}</td>
						<td>{{collection.flashPoint}}</td>


						<td class=" td-actions text-center"><security:authorize
								access="hasRole('${form_code}_${modify}')">
								<span> <i class="fa  fa-pencil text-success text"
									data-ng-click="editRow(collection.commodityCode)"></i>
								</span>
							</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
								<span> <i class="fa fa-trash-o text-danger-dker text"
									data-ng-click="deleteRow(collection.commodityCode)"></i>
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