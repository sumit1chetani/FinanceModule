<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap {
	white-space: nowrap;
}

.text-wrap-amtusd {
	padding: 8px 5px 8px 5px !important;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list">
		<div
			class="panel-heading panel-heading-list padding-right-0 padding-left-0">

			<%-- <%@include file="/views/templates/panel-header.jsp"%> --%>
			<div
				class="panel-heading panel-heading-list padding-right-0 padding-left-0">
				<div class="row  m-n">
					<div
						class="col-md-6 padding-right-0 padding-left-0 header-with-breadcrumb font-bold">
						<state-breadcrumbs ng-hide="hideBreadcrumb"></state-breadcrumbs>
					</div>
				</div>
			</div>
		</div>
		<!-- /panel-heading -->
		<input type="hidden" value="${form_code}" id="form_code_id"> <input
			type="hidden" value="${pendingRowCollection}" id="form_code_id">
		<div class="panel-body" st-table="pendingDisplayedCollection"
			st-safe-src="pendingRowCollection">
			<div
				class="panel-heading panel-heading-list padding-right-0 padding-left-0">
				<div class="row  m-n">
					<div class="col-md-6  p-l-0">
						<div class="col-md-6 text-right padding-right-0">
							<div class="row">
								<input type="text" st-search=""
									class="form-control input-sm p-tb-14 bg-white rounded padder"
									placeholder="Search">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer"
					width="100%" role="grid" aria-describedby="dt_basic_info">
					<thead class="dataTables-Main-Head">
						<tr role="row">
							<!-- <th class="width_1"></th> -->
							<th class="text-center width_8" >Bl No</th>
							<th class="text-center width_10" >Loading
								Id</th>
							<th class="text-center width_10" >Vessel</th>
							<th class="text-center width_10" >Voyage</th>
							<th class="text-center width_10" >Service</th>
							<th class="text-center width_15" >Pol</th>
							<th class="text-center width_15" >Pod</th>
							<th class="text-center width_15" >Fpod</th>
							<th class="text-center width_15" >Customer</th>
							<th class="text-center width_15" >Sailing Date</th>
							<th class="text-center width_15" >Leg</th>
							<th class="text-center width_15" >Shipment</th>
							<th class="text-center width_35" >BL Remarks</th>
							<th class="text-center width_15" >Status</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="objListItem in pendingDisplayedCollection">
							<td class="width_8"><span><span class="tool-tip-span font-blue" style="cursor:pointer"
										data-ng-bind="objListItem.blNo" data-ng-click="getPendingPhCDetails(objListItem)"></span> <!-- <a
									href="#/invoice/phcinvoicenew/confirm/{{objListItem.blNo}}/{{objListItem.flag}}/{{objListItem.bookdtlid}}/{{objListItem.slNo}}">
										<span class="tool-tip-span font-blue"
										data-ng-bind="objListItem.blNo"></span>
								</a> --></span></td>
							<td class="text-center" data-ng-bind="objListItem.loadingNo"></td>
							<td class="text-center" data-ng-bind="objListItem.vesselName"></td>

							<td class="text-center" data-ng-bind="objListItem.voyageId"></td>

							<td class="text-center" data-ng-bind="objListItem.sectorName"></td>
							<td class="text-center" data-ng-bind="objListItem.pol"></td>
							<td class="text-center" data-ng-bind="objListItem.pod"></td>
							<td class="text-center" data-ng-bind="objListItem.fpod"></td>
							<td class="text-center" data-ng-bind="objListItem.customer"></td>
							<td class="text-center" data-ng-bind="objListItem.sailingDate"></td>
							<td class="text-center" data-ng-bind="objListItem.leg"></td>
							<td class="text-center" data-ng-bind="objListItem.shipment"></td>
							<td class="text-center" data-ng-bind="objListItem.remarks"></td>
							<!-- <td class="text-center" data-ng-bind="objListItem.slNo"></td> -->
							<td class="text-center" ><span data-ng-if="objListItem.available" style="color: green;">Ready To Invoice</span>
							<span data-ng-if="!objListItem.available" style="color: red";>In-Bound/Out-Bound Detail Not available </span>
							</td>	
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
<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="content">
									<div class="form-actions">
										<div class="row">
											<div class="col-md-12">
												<button class="btn btn-danger"
													data-ng-click="cancel()" type="button">
													<i class="fa fa-arrow-left"></i> Back
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
