<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="customerList">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body float-left padding-0" style="width:100%">
			<div class="table-responsive ">
				<table
					class="table table-striped b-t b-light table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							
							<th class="sorting width_15" st-sort="eirNo">EIR No.
								</th>
							<th class="sorting width_15" st-sort="containerNo">ContainerNo.
								</th>
							<th class="sorting width_15" st-sort="eirDate">EIR Date
								</th>
							<th class="sorting width_10" st-sort="vesselName">Vessel Name 
								</th>
							<th class="sorting width_15" st-sort="voyageNo">Voyage</th>
							<th class="sorting width_5">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="consig in displayedCollection">
							
							<td><a ng-click="viewRow(consig)"> <security:authorize access="hasRole('${form_code}_${view}')"> <span
									tooltip="{{consig.eirNo}}" class="tool-tip-span font-blue">{{consig.eirNo}}</span></security:authorize>
							</a></td>
							
							<td>{{consig.containerNo}}
							</td>
							<td>{{consig.eirDate}}</td>
							<td>{{consig.vesselName}}</td>
							<td>{{consig.voyageNo}}</td>
							<td class="td-actions text-center">
							<security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa  fa-pencil text-success text"
										data-ng-click="editRow(consig)"></i>
									</span>
									</security:authorize>
								<security:authorize
									access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa  fa-trash text-danger text"
										data-ng-click="deleteRow(consig)"></i>
									</span>
								</security:authorize></td>
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