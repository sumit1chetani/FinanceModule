<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%><div
	class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body float-left padding-0">
			<div class="table-responsive ">

				<div class="panel-body">
					<form class="form-horizontal" novalidate>
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<fieldset>	
								</fieldset>
							</div>
						</div>
						
					</form>
				</div>

				<table
					class="table table-striped b-t b-light table-hover dataTable no-footer"
					style="border: 0px solid Red">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="width_1" style="border: 0px solid Red"><label
								class="i-checks m-b-none"> <input type="checkbox"
									name="post[]"> <i></i>
							</label></th>
							<th class="width_3 sorting text-center" st-sort="origin">GRLD NO</th>
							<th class="width_3 sorting text-center" st-sort="orgin">Orgin</th>
							<th class="width_3 sorting text-center" st-sort="port">Port Name</th>
							<th class="width_3 sorting text-center" st-sort="freightElement">Freight Element</th>
							<th class="width_3 sorting text-center" st-sort="fromDate">From Date </th>
							<th class="width_3 sorting text-center" st-sort="toDate">To Date</th>
							<th class="width_3 sorting text-center" st-sort="serviceType">Imp/Exp</th>
							<th class="width_3 sorting text-center" st-sort="customer">Customer Name</th>
							<th class="width_3 text-center">Action</th>
							<!-- <th>Change</th> -->


						</tr>
					</thead>
					<tbody>
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection"
							class="bunker_type_cls">
							<td class="width_1"><label class="i-checks m-b-none">
									<input type="checkbox" name="post[]"> <i></i>
							</label></td>	
							<td class="width_10 sorting text-center">{{objItem.grldId}}</td>													
							<td class="width_10 sorting text-center">{{objItem.orgin}}</td>
							<td class="width_10 sorting text-center">{{objItem.port}}</td>
							<td class="width_10 sorting text-center">{{objItem.freightElement}}</td>
							<td class="width_10 sorting text-center">{{objItem.fromDate}}</td>
							<td class="width_12 sorting text-center">{{objItem.toDate}}</td>
							<td class="width_10 sorting text-center">{{objItem.serviceType}}</td>
							<td class="width_3 sorting text-center">{{objItem.customer}}</td>

							<td class=" td-actions text-center">
<%-- 							<security:authorize	access="hasRole('${form_code}_${modify}')">
 --%>									<span> <i class="fa  fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										data-ng-click="editedRow(objItem.grldId,$index)"></i>
									</span>
<%-- 								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
 --%>									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(objItem.grldId,$index)"></i>
									</span>
<%-- 								</security:authorize>
 --%>								</td>
						</tr>
						<tr x-ng-show="showEmptyLabel">
							<td colspan="6">No Records Found</td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer">


				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>
</div>
