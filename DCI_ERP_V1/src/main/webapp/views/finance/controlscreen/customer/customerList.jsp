<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive " style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting width_2" st-sort="servicePartnerCode">Code</th>
							<th class="sorting width_8" st-sort="servicePartnerName">Name</th>
							<th class="sorting width_5" st-sort="servicePartnerLedgerName">Ledger
								Name</th>
							<th class="sorting width_3" st-sort="region">Region</th>

							<th class="sorting width_3" st-sort="cityName">City Code</th>
							<th class="sorting width_3" st-sort="country">Type</th>
							<th class="sorting width_3" st-sort="branchName">Branch</th>
							<th class="sorting width_4" st-sort="modifiedBy">Modified By</th>
							<th class="sorting width_3" st-sort="modifiedDate">Modified Date</th>
							<th class="sorting width_3" st-sort="active">Active</th>

							<th class="sorting width_2 text-center table-heading">Action</th>
						</tr>
					</thead>

					</thead>


					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
							<td class="sorting"><security:authorize
								access="hasRole('${form_code}_${view}')">
								<a ng-click="view(objItem.servicePartnerId)"> <span
									tooltip="{{objItem.servicePartnerId}}"
									class="tool-tip-span font-blue">{{objItem.servicePartnerCode}}</span>
							</security:authorize> </a></td>
							
							<!-- <td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerCode}}">{{objItem.servicePartnerCode}}</td> -->
							<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerName}}">{{objItem.servicePartnerName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerLedgerName}}">{{objItem.servicePartnerLedgerName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.region}}">{{objItem.region}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.cityName}}">{{objItem.cityName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.defaultTypeName}}">{{objItem.defaultTypeName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.branchName}}">{{objItem.branchName}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.modifiedBy}}">{{objItem.modifiedBy}}</td>
							<td class="">{{objItem.modifiedDate}}</td>
							<td class="">{{objItem.active}}</td>

							<td class="td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span class="edit-button  padding-right-5" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(objItem.servicePartnerId)"
										tooltip="Edit Row"> <i
										class="fa  fa-pencil text-success text"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span class="delete-button" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(objItem.servicePartnerId)"
										tooltip="Delete Row"> <i
										class="fa fa-trash-o text-danger-dker tex"></i>
									</span>
								</security:authorize></td>
						</tr>
					</tbody>


				</table>
			
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
			</div>
		</div>
		<!-- end widget content -->
	</div>
</div>
