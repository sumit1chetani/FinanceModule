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
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting width_3" st-sort="hblNo">HBL No</th>
							<th class="sorting width_3" st-sort="hblDocNo">HBL Doc No</th>
							<th class="sorting width_2" st-sort="hblDocDate">HBL Doc
								Date</th>

							<th class="sorting width_3" st-sort="jobCode">Job No</th>
							<!-- <th class="sorting width_3" st-sort="customerCode">MBL No</th> -->
							<th class="sorting width_3" st-sort="customerCode">Customer</th>

							<th class="sorting width_2" st-sort="polCode">POL</th>

							<th class="sorting width_2" st-sort="podCode">POD</th>
							<th class="sorting width_3" st-sort="destination">Destination</th>
							<!-- <th class="sorting width_3" st-sort="modifedBy">Modified By</th>
							<th class="sorting width_3" st-sort="modifedDate">Modified On</th> -->

							<th class="sorting width_1 text-center table-heading">Action</th>
						</tr>
					</thead>

					</thead>


					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
							<td><a data-ng-click="viewRow(objItem.hblNo)"> <security:authorize
										access="hasRole('${form_code}_${view}')">
										<span tooltip="{{objItem.hblCode}}"
											class="tool-tip-span font-blue">{{objItem.hblCode}}</span>
									</security:authorize></a></td>
							<td class="text-wrapping" data-toggle="tooltip" title="{{objItem.hblDocNo}}">{{objItem.hblDocNo}}</td>
							<td class="text-wrapping" data-toggle="tooltip" title="{{objItem.hblDocDate}}">{{objItem.hblDocDate}}</td>
							<td class="text-wrapping" data-toggle="tooltip" title="{{objItem.jobCode}}">{{objItem.jobCode}}</td>
							<!-- <td class="" data-toggle="tooltip" title="{{objItem.mblCode}}">{{objItem.mblCode}}</td> -->

							<td class="" data-toggle="tooltip" title="{{objItem.customerCode}}">{{objItem.customerCode}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.polCode}}">{{objItem.polCode}}</td>
							<td class="" data-toggle="tooltip" title="{{objItem.podCode}}">{{objItem.podCode}}</td>
							<td class="" data-toggle="tooltip"
								title="{{objItem.destinationCode}}">{{objItem.destionationCode}}</td>
							<!-- <td class="" data-toggle="tooltip" title="{{objItem.modifedBy}}">{{objItem.modifedBy}}</td>
							<td class="">{{objItem.modifedDate}}</td> -->

							<td class="td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span class="edit-button  padding-right-5" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(objItem.hblNo)" tooltip="Edit Row">
										<i class="fa  fa-pencil text-success text"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span class="delete-button" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(objItem.hblNo)" tooltip="Delete Row">
										<i class="fa fa-trash-o text-danger-dker tex"></i>
									</span>
								</security:authorize>
									<!-- <span> <i class="fa  fa-print text-success text"  data-toggle="tooltip"  title="Print HBL"
										data-ng-click="printRow(objItem.hblNo)"></i>
									</span>
									<span> <i class="fa  fa-print text-success text" data-toggle="tooltip"  title="Print LoadList"
										data-ng-click="printLoad(objItem.mblNo)"></i>
									</span> 
										<span> <i class="fa  fa-print text-success text" data-toggle="tooltip"  title="Print Manifest"
										data-ng-click="printRowManifest(objItem.hblNo)"></i>
									</span>
									<span> <i class="fa  fa-print text-success text" data-toggle="tooltip"  title="Print BookingConfirmation"
										data-ng-click="printBooking(objItem.hblNo)"></i>
									</span> -->
								</td>
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
