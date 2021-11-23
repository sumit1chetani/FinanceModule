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
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;"> 
						<tr>
							<th class="sorting width_5" st-sort="mblNo">MBL No</th>
							<th class="sorting width_4" st-sort="mblDocNo">MBL Doc No</th>
							<th class="sorting width_4" st-sort="mblDocDate">MBL Doc
								Date</th>
							<th class="sorting width_3" st-sort="liner">Customer</th>
							<th class="sorting width_3" st-sort="liner">Booking</th>
							<th class="sorting width_3" st-sort="liner">Vessel</th>
							<th class="sorting width_3" st-sort="liner">Voyage</th>
							<th class="sorting width_2" st-sort="pol">POL</th>
							<th class="sorting width_3" st-sort="pod">POD</th>
							<th class="sorting width_3" st-sort="origin">Origin</th>
							<th class="sorting width_3" st-sort="destination">Destination</th>
							<th class="sorting width_3" st-sort="modifiedBy">Modified By</th>
							<th class="sorting width_3" st-sort="modifiedDate">Mofied
								Date</th>

							<th class="sorting width_2 text-center table-heading">Action</th>
						</tr>
					</thead>

					</thead>


					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
							<td><a data-ng-click="viewRow(objItem.mblNo)"> <security:authorize
										access="hasRole('${form_code}_${view}')">
										<span tooltip="{{objItem.mblCode}}"
											class="tool-tip-span font-blue">{{objItem.mblCode}}</span>
									</security:authorize></a></td>
							<td class="" data-toggle="tooltip" title="{{objItem.mblDocNo}}">{{objItem.mblDocNo}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.mblDocDate}}">{{objItem.mblDocDate}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.customer}}">{{objItem.customerCode}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.customer}}">{{objItem.booking}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.customer}}">{{objItem.vessel}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.customer}}">{{objItem.voyage}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.polCode}}">{{objItem.polCode}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.podCode}}">{{objItem.podCode}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.originCode}}">{{objItem.originCode}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.destionationCode}}">{{objItem.destionationCode}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.modifedBy}}">{{objItem.modifedBy}}</td>
							<td class="">{{objItem.modifedDate}}</td>

							<td class="td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span class="edit-button  padding-right-5" 
data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(objItem.mblNo)"
										tooltip="Edit Row"> <i
										class="fa  fa-pencil text-success text"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span class="delete-button" 
data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(objItem.mblNo)"
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
