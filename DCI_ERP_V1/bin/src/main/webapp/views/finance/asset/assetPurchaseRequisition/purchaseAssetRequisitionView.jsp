<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="assetPurchaseRequisitionForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-4 control-label">Requisition
														Date</label>
													<div class="col-md-7 padding-top-6">
														{{assetPurchaseRequisitionObj.purchaseAssetrequisitionDate}}
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Requisition
														Location </label>
													<div class="col-md-7 padding-top-6">
														{{assetPurchaseRequisitionObj.destinationLocation}}</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-4 control-label"> Requested By
													</label>
													<div class="col-md-7 padding-top-6">
														{{assetPurchaseRequisitionObj.employeeId}}</div>
												</div>
											</div>
										</fieldset>

										<div class="col-sm-12 col-md-12 col-lg-12">
											<br>
											<div role="content">
												<div class="widget-body no-padding">
													<div class=""
														data-ng-repeat="(tIndex, table) in assetPurchaseRequisitionObj.tables">
														<table id="dt_basic"
															class="table table-striped table-bordered table-hover dataTable no-footer"
															role="grid" aria-describedby="dt_basic_info">
															<thead class="dataTables-Main-Head">
																<tr>
																	<th class="table-heading width_6 text-center">Asset
																		Name</th>
																	<th class="table-heading width_5 text-center">Asset
																		Category</th>
																	<th class="table-heading width_5 text-center">UOM</th>
																	<th class="table-heading width_2 text-center">Quantity</th>
																	<th class="table-heading width_5 text-center">EDD</th>
																</tr>
															</thead>
															<tbody data-ng-repeat="(trIndex, row) in table.row">
																<tr>
																	<td class="padding-both-side-2"><span
																		data-ng-hide=true> <selectivity list="ItemList"
																				property="row.itemId" id="itemId{{trIndex}}"
																				disabled=true></selectivity>
																	</span> {{row.itemName}}
																	<td class="padding-both-side-2">
																		{{row.itemCategoryName}}</td>
																	<td class="padding-both-side-2">{{row.uomName}}</td>
																	<td class="padding-both-side-2 text-right" >{{row.quantity}}</td>
																	<td class="padding-both-side-2">{{row.eddDate}}</td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
												<!-- end widget content -->
											</div>
											<br>
										</div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i> Back To List
											</button>
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>