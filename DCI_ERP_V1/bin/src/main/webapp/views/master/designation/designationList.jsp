<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body float-left padding-0" style="width:100%">
			<div class="table-responsive ">
			
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="sorting width_50" st-sort="desgnCode">Designation
								Code</th>
							<th class="sorting width_50" st-sort="desgnName">Designation
								Name</th>
							<th class="sorting width_30" st-sort="isActive">Active</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objdesignationItem in displayedCollection">
							<td><a ng-click="view(objdesignationItem.desgnCode)"> 
							  <security:authorize access="hasRole('${form_code}_${view}')"> 
							<span
									tooltip="{{objdesignationItem.desgnCode}}"
									class="tool-tip-span font-blue">{{objdesignationItem.desgnCode}}
									</span>
									 </security:authorize> 
							</a></td>
							<td>{{objdesignationItem.desgnName}}</td>
							<td>{{objdesignationItem.isActive}}</td>
							<td class=" td-actions text-center">
							     <security:authorize access="hasRole('${form_code}_${modify}')"> 
								<span> <i class="fa  fa-pencil text-success text"
									data-ng-click="editRow(objdesignationItem.desgnCode,$index)"></i>
							</span>  </security:authorize> 
							 <security:authorize
									access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(objdesignationItem.desgnCode,$index)"></i>
									</span>
								</security:authorize>
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





