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
							<form class="form-horizontal" name="assetPurchaseApprovalViewForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
									<fieldset>
										<div class="col-md-6">
													<div class="form-group">
											<label class="col-md-4 control-label">  Asset Requisition No </label>
													<div class="col-md-7" data-ng-if="!isView">
														<input type="text" class="form-control input-sm" 
													 data-ng-model="assetApproval.purchaseAssetrequisitionNo" readonly>
													</div>
													<div class="col-md-7 padding-top-6" data-ng-if="isView">
														{{assetApproval.purchaseAssetrequisitionNo}}
													</div>
													</div>
													
												<div class="form-group">
													<label class="col-md-4 control-label">Requisition
														Date</label>
													<div class="col-md-7" data-ng-if="!isView">
														<input type="text" class="form-control input-sm" 
													 data-ng-model="assetApproval.purchaseAssetrequisitionDate" readonly>
													</div>
													<div class="col-md-7 padding-top-6" data-ng-if="isView">
														{{assetApproval.purchaseAssetrequisitionDate}}
													
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Approve
														Date</label>
												<div class="col-md-7" data-ng-if="!isView">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a data-toggle="dropdown" class="dropdown-toggle"
																	id="reqdate" role="button" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="assetDate"
																			data-ng-model="assetApproval.approveDate">
																		<span class="input-group-addon"> <i
																			class="glyphicon glyphicon-calendar"></i>
																		</span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="assetApproval.approveDate"
																		data-on-set-time="assetApproval.approveDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#reqdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
													<div class="col-md-7 padding-top-6" data-ng-if="isView">
														{{assetApproval.approveDate}}
													</div>
												</div>
												
													<div class="form-group">
													<label class="col-md-4 control-label"> Status  <spring:message
															code="label.asterisk.symbol"></spring:message>  </label>
													<div class="col-md-7" data-ng-if="!isView">
													<select class="form-control" name="status"
														data-ng-model="assetApproval.assetApprovalStatusId"
														data-ng-options="obj.requisitionStatus as obj.requisitionStatusName for obj in statusList "
														name="status" validation="required" friendly-name="Status">
														<option value="">Select</option>
													</select>
													</div>
													<div class="col-md-7 padding-top-6" data-ng-if="isView">
													{{statusName}}
													</div>
												</div>
											
										</div>
										<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-4 control-label"> Requested By
													</label>
													<div class="col-md-7" data-ng-if="!isView">
													<input type="text" class="form-control input-sm" 
													 data-ng-model="assetApproval.employeeName" readonly>
													</div>
													<div class="col-md-7 padding-top-6" data-ng-if="isView">
													{{assetApproval.employeeName}}
													</div>
													</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Requisition
														Location</label>
													<div class="col-md-7" data-ng-if="!isView">
														<input type="text" class="form-control input-sm" 
													 data-ng-model="assetApproval.designationLocationName" readonly>
													</div>
													<div class="col-md-7 padding-top-6" data-ng-if="isView">
													{{assetApproval.designationLocationName}}
														
													</div>
													</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Approved By <spring:message
															code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7" data-ng-if="!isView">
														<selectivity list="employeeList"
															property="assetApproval.validatedBy" id="validatedBy"
															data-ng-model="assetApproval.validatedBy"
															name="validatedBy" form-name = "assetPurchaseApprovalViewForm" 
	        												validation="required" friendly-name="Approved By"
															></selectivity>
															</div>
													<div class="col-md-7 padding-top-6" data-ng-if="isView">
														{{employeeName}}
											</div>
											
												</div>		
												</div>
											</fieldset>
										</div>
										<div class="col-sm-12 col-md-12 col-lg-12">
											<br>
											<div role="content">
												<div class="widget-body no-padding">
													<div class="" data-ng-repeat="(tIndex, table) in assetApproval.tables"> 
														<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_1 text-center table-heading"><label
																		class="i-checks m-b-none"> <input
																			type="checkbox"> <i></i>
																	</label></th>
																	<th class="table-heading width_6 text-center" >Asset
																		Name</th>
																	<th class="table-heading width_5 text-center" >Asset
																		Category</th> 
																	<th class="table-heading width_5 text-center" >UOM</th>
																	<th class="table-heading width_2 text-center" >Quantity</th>
																	<th class="table-heading width_5 text-center" >EDD</th>
																</tr>
															</thead>
															<tbody data-ng-repeat="(trIndex, row) in table.row">
																<tr data-ng-if="!isView">
																	<td><label class="i-checks m-b-none"> <input
																			type="checkbox" data-ng-model="row.tableId"><i></i></label></td>
																	<td class="padding-both-side-2"><input type="text" class="form-control input-sm" 
													 data-ng-model="row.itemName" readonly></td>
																	<td class="padding-both-side-2"><input type="text"
																		class="form-control input-sm"
																		data-ng-model="row.itemCategoryName" readonly></td>
																	<td class="padding-both-side-2"><input type="text"
																		class="form-control input-sm"
																		data-ng-model="row.uomName" readonly></td>
																	<td class="padding-both-side-2"><input type="text"
																		class="form-control input-sm text-right" readonly
																		data-ng-model="row.quantity"></td>
																	<td class="padding-both-side-2"><input type="text" class="form-control input-sm" 
													 data-ng-model="row.eddDate" readonly></td>
																</tr>
																<tr data-ng-if="isView">
																	<td></td>
																	<td class="padding-both-side-2">
																	{{row.itemName}}
																	</td>
																	<td class="padding-both-side-2">
																	{{row.itemCategoryName}}
																	</td>
																	<td class="padding-both-side-2">
																	{{row.uomName}}
																	</td>
																	<td class="padding-both-side-2 text-right">
																	{{row.quantity}}
																	</td>
																	<td class="padding-both-side-2">
																	{{row.eddDate}}
																	
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
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12" data-ng-if="!isView">
											<button class="btn btn-success" type="button"
												class="btn btn-success"
												data-ng-click="submit(assetApproval)"
												>
												<i class="fa fa-save"></i>
											Confirm Approve
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success"
												 data-ng-click="reset(assetRequisitionForm);">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i>
												<spring:message code="label.cancel"></spring:message>
											</button>
										</div>
										<div class="col-md-12" data-ng-if="isView">
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i>
												Back To List
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