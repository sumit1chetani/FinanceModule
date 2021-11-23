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
									<div class="col-sm-4 col-md-4 col-lg-4">
										<div class="form-group">
											<label class="col-md-6 control-label"> From Date</label>
												<div class="input-group input-append date" id="fromDate">
											        <ng-bs3-datepicker placeholder='dd/mm/yyyy' data-ng-model="grldinvoiceData.fromDate" />
										</div>
										</div>
									</div>

									<div class="col-sm-4 col-md-4 col-lg-4">
										<div class="form-group">
											<label class="col-md-6 control-label"> To Date</label>
											<div class="input-group input-append date" id="toDate">
					                        <ng-bs3-datepicker placeholder='dd/mm/yyyy' data-ng-model="grldinvoiceData.toDate" />
											</div>
										</div>
									</div>
									
									<div class="col-sm-4 col-md-4 col-lg-4">
										<div class="form-group">
											<label class="col-md-6 control-label"> </label>
											<button class="btn btn-success" type="button"
										data-ng-click="search();">
										<i class="fa fa-search"></i> Search
									</button>
										</div>
									</div>

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
							<th class="width_5 sorting text-center" st-sort="departureId">Invoice NO</th>
							<th class="width_3 sorting text-center" st-sort="departureId">Invoice Date</th>
							<th class="width_3 sorting text-center" st-sort="vesselName1">Vessel</th>
							<th class="width_3 sorting text-center" st-sort="voyageId1">Voyage</th>
							<th class="width_3 sorting text-center" st-sort="portCode">Agreement Party</th>
							<th class="width_2 sorting text-center" st-sort="portCode">POL</th>
							<th class="width_2 sorting text-center" st-sort="portCode">POD</th>
							<th class="width_3 sorting text-center" st-sort="portCode">Container</th>
							<th class="width_3 sorting text-center" st-sort="portCode">Is Reversed</th>
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
							<td class="sorting width_15 text-left"><a ng-click="view(objItem.invoiceNo)"> <span
									tooltip="{{objItem.invoiceNo}}" class="tool-tip-span font-blue">{{objItem.invoiceNo}}</span>
							</a></td>
							<td class="sorting width_9 text-center">{{objItem.invoiceDate}}</td>
							<td class="sorting width_8 text-center">{{objItem.vessel}}</td>
							<td class="sorting width_9 text-center">{{objItem.voyage}}</td>
							<td class="sorting width_9 text-center">{{objItem.customer}}</td>
							<td class="sorting width_8 text-center">{{objItem.pol}}</td>
							<td class="sorting width_8 text-center">{{objItem.pod}}</td>
							<td class="sorting width_9 text-center">{{objItem.bunkerQuo}}</td>
							<td class="sorting width_9 text-center">{{objItem.bunkerQuo}}</td>
							<td class=" td-actions text-center">
							<%-- <security:authorize	access="hasRole('${form_code}_${modify}')"> --%>
									<span> <i class="fa  fa-pencil text-success text"
										data-ng-click="editedRow(objItem.invoiceNo,$index)"></i>
									</span>
									               				 <i class="fa  fa-print text-primary text" title="print" data-ng-click="print(objItem.invoiceNo,$index)"></i>
			 					 </span>
									<span> <i class="fa  fa-eye text-success text"
						data-toggle="tooltip" title="View" data-ng-click="view(objItem.invoiceNo,$index)"></i>
									</span>
							<%-- 	</security:authorize>  --%>
								<%-- <security:authorize access="hasRole('${form_code}_${delete}')"> --%>
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(objItem.invoiceNo,$index)"></i>
									</span>
							<%-- 	</security:authorize>  --%>								
								</td>
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
