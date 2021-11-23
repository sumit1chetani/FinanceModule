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
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a data-toggle="dropdown" class="dropdown-toggle"
																	id="reqdate" role="button" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="assetDate"
																			data-ng-model="assetPurchaseRequisitionObj.purchaseAssetrequisitionDate" readonly>
																		<span class="input-group-addon"> <i
																			class="glyphicon glyphicon-calendar"></i>
																		</span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="assetPurchaseRequisitionObj.purchaseAssetrequisitionDate"
																		data-on-set-time="assetPurchaseRequisitionObj.purchaseAssetrequisitionDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#reqdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Requisition
														Location <spring:message
															code="label.asterisk.symbol"></spring:message> </label>
													<div class="col-md-7">

														<selectivity list="destLocationList"
															property="assetPurchaseRequisitionObj.destinationLocation"
															data-ng-model="assetPurchaseRequisitionObj.destinationLocation"
															name="destinationLocation" form-name = "assetPurchaseRequisitionForm" 
	        												validation="required" friendly-name="Requisition Location"
															id="destinationLocation"></selectivity>
													</div>
												</div>
										</div>
										<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-4 control-label"> Requested By <spring:message
															code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<selectivity list="employeeList"
															property="assetPurchaseRequisitionObj.employeeId" id="employeeId"
															data-ng-model="assetPurchaseRequisitionObj.employeeId"
															name="employeeId" form-name = "assetPurchaseRequisitionForm" 
	        												validation="required" friendly-name="Requested By"
															></selectivity>
													</div>
												</div>
												<div class="form-group">
					        				<label class="col-md-4 control-label"> Hospital <spring:message
					              			code="label.asterisk.symbol"></spring:message></label>
					        				<div class="col-md-7">
						        				<selectivity list="companyList" property="assetPurchaseRequisitionObj.companyId" id="companyId"
						        				ng-model="assetPurchaseRequisitionObj.companyId" name="companyId" form-name = "assetPurchaseRequisitionForm"
						        				validation="required" friendly-name="Hospital"></selectivity>
											</div>
										</div>
												
										</div>
										</fieldset>
									
										<div class="col-sm-12 col-md-12 col-lg-12">
											<br>
											<div role="content">
												<div class="widget-body no-padding">
													<div class="" data-ng-repeat="(tIndex, table) in assetPurchaseRequisitionObj.tables"> 
														<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
																<tr>
																	<th class="width_1 text-center table-heading"><label
																		class="i-checks m-b-none"> <input
																			type="checkbox"> <i></i>
																	</label></th>
																	<th class="sorting width_6 text-center" >Asset Name <spring:message
															code="label.asterisk.symbol"></spring:message></th>
																	<th class="sorting width_5 text-center" >Asset
																		Category</th> 
																	<th class="sorting width_5 text-center" >UOM</th>
																	<th class="sorting width_2 text-center" >Quantity <spring:message
															code="label.asterisk.symbol"></spring:message></th>
																	<th class="sorting width_5 text-center" >EDD  <spring:message
															code="label.asterisk.symbol"></spring:message></th>
																</tr>
															</thead>
															<tbody data-ng-repeat="(trIndex, row) in table.row">
																<tr>
																	<td><label class="i-checks m-b-none"> <input
																			type="checkbox" data-ng-model="row.tableId"><i></i></label></td>
																	<td class="padding-both-side-2"><selectivity
																			list="ItemList" property="row.itemId"
																			id="itemId{{trIndex}}"
																			data-ng-model="row.itemId"
															 form-name = "assetPurchaseRequisitionForm" 
															 friendly-name="{{ 'Row' + (trIndex+1) + '(Asset)'}}"
	        												validation="required" 
	        												name="{{ 'itemId' + trIndex }}"
																			></selectivity></td>
																	<td class="padding-both-side-2"><input type="text"
																		class="form-control input-sm"
																		data-ng-model="row.itemCategoryName" readonly></td>
																	<td class="padding-both-side-2"><input type="text"
																		class="form-control input-sm"
																		data-ng-model="row.uomName" readonly></td>
																	<td class="padding-both-side-2"><input type="text"
																		class="form-control input-sm text-right "
																		data-ng-model="row.quantity" validation="numeric|required"
															friendly-name="{{ 'Row' + (trIndex+1) + 'Quantity'}}"
															id="quantity{{trIndex}}" name="{{ 'quantity' + trIndex }}"
															data-ng-keyup="onChangeNumber(trIndex,row.quantity)" maxlength="5"
															></td>
																	<td class="padding-both-side-2"><div
																			class='input-group date datetimepick col-md-12'>
																			<div class="dropdown">
																				<a data-toggle="dropdown" class="dropdown-toggle"
																					id="edddate{{trIndex}}" role="button" data-target="#" href="#">
																					<div class="input-group">
																						<input type="text" class="form-control"
																							placeholder="dd/mm/yyyy"
																							name="{{ 'assetDate' + trIndex }}"
																							friendly-name="{{ 'Row' + (trIndex+1) + 'EDD Date'}}"
	        																				validation="required"
																							data-ng-model="row.eddDate"> <span
																							class="input-group-addon"> <i
																							class="glyphicon glyphicon-calendar"></i>
																						</span>
																					</div>
																				</a>
																				<ul class="dropdown-menu" role="menu"
																					aria-labelledby="dLabel">
																					<datetimepicker data-ng-model="row.eddDate"
																						data-on-set-time="row.eddDate = onDateSet(newDate)"
																						data-datetimepicker-config="{ dropdownSelector: '#edddate{{trIndex}}',startView:'day', minView:'day'}" />
																				</ul>
																			</div>
																		</div></td>
																</tr>
															</tbody>
														</table>
													<button data-ng-click="addRow(table)" class="btn btn-primary"
										type="button">
										<i class="fa fa-plus"></i> 
									</button>
									<button data-ng-click="removeRowForm(table)"
										class="btn btn-danger" type="button">
										<i class="fa fa-trash-o"></i> 
									</button>
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
											<button class="btn btn-success" type="button"
												class="btn btn-success"
												data-ng-click="submit(assetPurchaseRequisitionObj)"
												data-ng-if="!isEdit">
												<i class="fa fa-save"></i>
												Request Approval
											</button>
											<button class="btn btn-success" type="button"
												class="btn btn-success" id="update"
												data-ng-click="submit(assetPurchaseRequisitionObj);"
												data-ng-if="isEdit">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>
											<button class="btn btn-info" type="reset"
												class="btn btn-success"
												data-ng-if="isEdit"
												data-ng-click="reset();">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i>
												<spring:message code="label.cancel"></spring:message>
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