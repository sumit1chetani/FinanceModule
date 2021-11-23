<style>
table.dataTable thead .sorting:after {
	content: "";
}

.main_container {
	overflow: auto;
}

.datetimepicker {
	width: auto;
}

select {
	-webkit-appearance: none;
	padding: 0;
	text-indent: 8px;
	padding: 0 !important;
}

.input-group-addon {
	display: none !important;
}

.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
	{
	background-color: white !important;
	border: 0px !important;
}

.b-grey {
	border: 0px !important;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- #MAIN CONTENT -->
<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
						<div class="widget-toolbar">
							<div>
								<span> <span class="button-icon" data-placement="bottom"
									data-reset-widgets rel="tooltip"
									title="<spring:message code='title.widget.reset'></spring:message>">
										<i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="assetTransferForm" novalidate
								method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6">
											<fieldset>

												<div class="form-group">
													<label class="col-md-3 control-label">Asset
														Transfer No</label>
													<div class="col-md-7">
														<input type="hidden" id="stockId" class="form-control"
															ng-model="assetTransferObjView.assetTransferNo" value=""
															ng-disabled="true" /> <input type="text" id="stockId"
															class="form-control"
															ng-model="assetTransferObjView.assetTransferNo" value=""
															ng-disabled="true" />
													</div>
												</div>




												<div class="form-group">
													<label class="col-md-3 control-label">Transfer Date
													</label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<input type="text" class="form-control"
																placeholder="dd/mm/yyyy" name="From Date"
																data-ng-model="assetTransferObjView.transferDate"
																ng-disabled="true" />
														</div>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label">Source
														Location</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															ng-model="assetTransferObjView.sourceLocName"
															ng-disabled="true">

													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Destination
														Location</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															ng-model="assetTransferObjView.destLocName"
															ng-disabled="true">

													</div>
												</div>
											</fieldset>
										</div>
										<div class="col-sm-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label"> Transfer No
													</label>
													<div class="col-md-7">
														<input type="hidden" id="transferNo" class="form-control"
															ng-model="assetTransferObjView.requisition" value=""
															ng-disabled="true" /> <input type="text" id="transferNo"
															class="form-control"
															ng-model="assetTransferObjView.requisition" value=""
															ng-disabled="true" />
													</div>
												</div>


												<div class="form-group">
													<label class="col-md-3 control-label">Requisition
														Date</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="AssetCode"
															ng-model="assetTransferObjView.requisitionDate"
															id="requisitiondate" ng-disabled="true">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Received By</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name=receiviedBy
															ng-model="assetTransferObjView.receiviedBy"
															id="receiviedBy" ng-disabled="true">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label ">Received
														Note</label>
													<div class="col-md-7">
														<textarea rows=2 class="form-control input-sm resize-none"
															name="reason" ng-model="assetTransferObjView.reason"
															id="reason" ng-disabled="true">
														</textarea>
													</div>
												</div>

						</fieldset>
										</div>
									</div>
								</div>
								<br> <br> <br>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-3">
											<div class="form-group">
												<label class="col-md-4 control-label">Item Name</label>
												<div class="col-md-8">
													<input type="text" class="form-control input-sm"
														name="ItemName" ng-model="assetTransferObjView.itemName"
														id="requestedby" ng-disabled="true">
												</div>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label class="col-md-5 control-label">Item Category</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="AssetCode"
														ng-model="assetTransferObjView.itemCategory"
														id="itemCategory" ng-disabled="true">
												</div>
											</div>
										</div>
										<div class="col-sm-3">
											<div class="form-group">
												<label class="col-md-6 control-label">Requested
													Quanity</label>
												<div class="col-md-4">
													<input type="text" class="form-control text-right input-sm"
														name="AssetCode"
														ng-model="assetTransferObjView.requisitionquantity"
														id="quantity" ng-disabled="true">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-6 control-label">Transfer
													Quanity</label>
												<div class="col-md-4">
													<input type="text" class="form-control text-right input-sm"
														name="AssetCode"
														ng-model="assetTransferObjView.transferquantity"
														id="quantity" ng-disabled="true">
												</div>
											</div>
										</div>

									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<br>
										<div role="content">
											<div class="widget-body no-padding">
												<div class="dt-bootstrap no-footer ui-jqgrid ui-corner-all"
													data-st-table="displayedCollection"
													data-st-safe-src="assetTransferObjView.rowCollection">
													<table id="dt_basic"
														class="table table-striped table-bordered table-hover dataTable no-footer"
														role="grid" aria-describedby="dt_basic_info">
														<thead class="dataTables-Main-Head">
															<tr>
																<th class="width_1 table-heading text-center"><label
																	class="i-checks m-b-none"> <input
																		type="checkbox"> <i></i>
																</label></th>
																<th class="table-heading width_7">Asset Track No</th>
																<th class="table-heading width_7">Asset Name</th>
																<th class="table-heading width_7">Serial No</th>
																<th class="table-heading width_7">Asset Location</th>
																<th class="table-heading width_7">Responsible</th>
																<th class="table-heading width_7">Asset User</th>
															</tr>
														</thead>
														<tbody>
															<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																ng-repeat="objAssetRequistion in displayedCollection">

																<td><label class="i-checks m-b-none"><input
																		data-ng-change="onCount(objAssetRequistion.assetTrackConfirm)"
																		type="checkbox"
																		data-ng-model="objAssetRequistion.assetTrackConfirm">
																		<i></i></label></td>
																<td>{{objAssetRequistion.assettrackNo}}</td>
																<td>{{objAssetRequistion.assettrackName}}</td>
																<td>{{objAssetRequistion.serialNo}}</td>
																<td>{{objAssetRequistion.asstlocation}}</td>
																<td>{{objAssetRequistion.resAsset}}</td>
																<td>{{objAssetRequistion.user}}</td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel1();">
												<i class="fa fa-close"></i>
												<spring:message code="label.cancel"></spring:message>
											</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>
