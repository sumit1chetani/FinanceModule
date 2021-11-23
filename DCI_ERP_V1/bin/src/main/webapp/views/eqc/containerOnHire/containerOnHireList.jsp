<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
}

.ngdialog-overlay {
	
}

.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 66%;
	position: absolute;
	top: 20%;
	left: 17%;
	margin: 0 auto;
}

.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="containerOnHireTable"
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
			<div class="table-responsive" style="border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>

							<th class="sorting width_27" st-sort="onHireRefNo">On-Hire Ref. No.</th>
							<th class="sorting width_27" st-sort="releaseRefNo">Release Ref. No.</th>
							
						<th class="sorting width_27" st-sort="refNo">Reference No.</th>
							
							<th class="sorting width_30" st-sort="agreementParty">Agreement
								Party</th>
							<th class="sorting width_27" st-sort="leasingParty">Leasing
								Party</th>
							<th class="sorting width_30" st-sort="leaseAgreementNo">
								Agreement Ref. No.</th>
							<th class="sorting width_18" st-sort="leaseType">Lease Type</th>
							<th class="sorting width_18" st-sort="port">Port</th>
							<th class="sorting width_27" st-sort="noOfContainer">No of
								Containers</th>
							<th class="sorting width_18" st-sort="date">Date</th>
							<th class="width_17 text-center table-heading">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection">

							<td class="" data-toggle="tooltip" title="{{item.onHireRefNo}}"><a ng-click="view(item.onHireRefNo)"> <span
									tooltip="{{item.onHireRefNo}}"
									class="tool-tip-span font-blue ">{{item.onHireRefNo}}</span></a></td>
							<td ng-if="item.onHireRefNo==='' || item.onHireRefNo===null">
								<a ng-click="editCro(item.releaseRefNo )"> <span
									tooltip="{{item.releaseRefNo}}"
									class="tool-tip-span font-blue ">{{item.releaseRefNo}}</span>
							</a>
							</td>
							<td ng-if="item.onHireRefNo !='' && item.onHireRefNo !=null">
								{{item.releaseRefNo}}</td>
								
							<td class="sorting" data-toggle="tooltip"
								title="{{item.refNo}}">{{item.refNo}}</td>

							<td class="sorting" data-toggle="tooltip"
								title="{{item.agreementParty}}">{{item.agreementParty}}</td>
							<td class="sorting" data-toggle="tooltip"
								title="{{item.leasingParty}}">{{item.leasingParty}}</td>
							<td class="sorting" data-toggle="tooltip"
								title="{{item.leaseAgreementNo}}">{{item.leaseAgreementNo}}</td>
							<td class="sorting" data-toggle="tooltip"
								title="{{item.leaseType}}">{{item.leaseType}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.port}}">{{item.port}}</td>
							<td class="sorting" data-toggle="tooltip"
								title="{{item.noOfContainer}}">{{item.noOfContainer}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.date}}">{{item.date
								| date: 'dd/MM/yyyy'}}</td>
							<td class=" td-actions text-center"
								ng-show="item.onHireRefNo !='' && item.onHireRefNo !=null">
<%-- 								<security:authorize access="hasRole('${form_code}_${modify}')">
 --%>									<span> <i class="fa fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(item.onHireRefNo)"></i>
									</span>
<%-- 								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
 --%>									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(item.onHireRefNo)"></i>
									</span>
<!-- 									<span> <i class="fa fa-eye text-success text" -->
<!-- 										data-toggle="tooltip" title="view Container's" -->
<!-- 										data-ng-click="view(item.onHireRefNo)"></i> -->
<!-- 									</span> -->
<%-- 								</security:authorize>
 --%>							</td>

							<td class=" td-actions text-center"
								ng-show="item.onHireRefNo==='' || item.onHireRefNo===null">
							</td>

						</tr>
					</tbody>

				</table>
			</div>
			<footer class="panel-footer panel-footer-list" style="padding: 0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>
