<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="containerLeaseAgreementTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		 <style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			 <div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							
							<th class="sorting width_10" st-sort="agreementRefNo">Agreement No.</th>
							<th class="sorting width_20" st-sort="agreementParty"> Lessor/Owner</th>
							<th class="sorting width_20" st-sort="agreementParty">Lessee</th>
							<th class="sorting width_10" st-sort="agreementRefNo">Lease Agreement No.</th>
							<th class="sorting width_10" st-sort="agreementType">Agreement Type</th>
							<th class="sorting width_10" st-sort="currency">Currency</th>
							<th class="sorting width_10" st-sort="fromDate">From Date</th>
		                    <th class="sorting width_10" st-sort="toDate">To Date</th>
							<th class="sorting width_10 text-center table-heading " >Action</th>	
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection">
	
							<td><a ng-click="View(item.agreementRefNo)">
		             <span tooltip="{{item.agreementRefNo}}" class="tool-tip-span font-blue">{{item.agreementRefNo}}</span></a></td>
							<td class="sorting" data-toggle="tooltip" title="{{item.agreementParty}}">{{item.agreementParty}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.leaseAgreementParty}}">{{item.leaseAgreementParty}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.partyAgreementNo}}">{{item.partyAgreementNo}}</td>
                             <td class="sorting" data-toggle="tooltip" title="{{item.agreementType}}">{{item.agreementType}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.currency}}">{{item.currency}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.fromDate}}">{{item.fromDate}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{item.toDate}}">{{item.toDate}}</td>
												
							<td class=" td-actions text-center"> <%-- <security:authorize
									access="hasRole('${form_code}_${modify}')"> --%>
									<span> <i class="fa fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(item.agreementRefNo)"></i>
									</span>
<%-- 								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
 --%>									<span> <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(item.agreementRefNo)"></i>
									</span>
								 <%-- </security:authorize> --%></td> 
						</tr>
					</tbody> 

				</table>
			</div> 
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>