
		<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="containerTypeTable"
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
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
						<tr>
							<th class="sorting width_7" st-sort="containertype">Container Type</th>
							<th class="sorting width_10" st-sort="material">Material</th>
							<th class="sorting width_10" st-sort="containerkind">Container Kind</th>
							<th class="sorting width_10" st-sort="tareweight">Tare Weight</th>
							<th class="sorting width_10" st-sort="maxcapacity">Max Capacity</th>
							<th class="sorting width_10" st-sort="isocode">ISO Code</th>
							<th class="sorting width_10" st-sort="isocode">Active</th>
							<th class="sorting width_5 text-center table-heading">Action</th>
						</tr>
					</thead>

					</thead>


					<tbody class="dataTables-Main-Body">

						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
							
							 <td><a ng-click="view(objItem.containertype)">
		             <span tooltip="{{objItem.containertype}}" class="tool-tip-span font-blue">{{objItem.containertype}}</span>
		         </a>
       </td>
       	<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerName}}">{{objItem.material}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.servicePartnerLedgerName}}">{{objItem.containerkind}}</td>
							<td class="" data-toggle="tooltip"
												title="{{objItem.region}}">{{objItem.tareweight}}</td>
												<td class="" data-toggle="tooltip"
												title="{{objItem.region}}">{{objItem.maxcapacity}}</td>
												<td class="" data-toggle="tooltip"
												title="{{objItem.region}}">{{objItem.isocode}}</td>
												<td class="" data-toggle="tooltip"
												title="{{objItem.region}}">{{objItem.active}}</td>
												
							<td class="td-actions text-center">
									<span class="edit-button  padding-right-5"
										data-ng-click="editRow(objItem.containertype)"
										tooltip="Edit Row"> <i
										class="fa  fa-pencil text-success text"></i>
									</span>
								
									<span class="delete-button"
										data-ng-click="deleteRow(objItem.containertype)"
										tooltip="Delete Row"> <i
										class="fa fa-trash-o text-danger-dker tex"></i>
									</span>
							</td>
						</tr>
					</tbody>


				</table>
			
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
		</div>
		<!-- end widget content -->
	</div>
</div>
