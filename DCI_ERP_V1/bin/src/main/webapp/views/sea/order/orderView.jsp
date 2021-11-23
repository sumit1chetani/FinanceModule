<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span> <state-breadcrumbs></state-breadcrumbs>
						</span>
						<div class="widget-toolbar">
							<div>
								<span> <span class="button-icon" data-reset-widgets
									rel="tooltip"
									title="<spring:message code="title.widget.reset"></spring:message>"
									data-placement="bottom"> <i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="storeToStoreAddForm">
								<div class="row">
									<div class="col-sm-10 col-md-5">
										<fieldset>
											<div class="form-group" ng-show="isEdit">
												<label class="col-md-6 control-label"> Requisition
													No </label> <label class="col-md-1 control-label">{{storeApprovalData.requisitionNumber}}</label>
												<div class="col-md-6">
													<input type="text" class="form-control input-sm"
														name="sourceStore" id="sourceStore"
														ng-model="storeApprovalData.requisitionNumber"
														ng-show="!isEdit">

												</div>
											</div>
											<div class="form-group" ng-show="isEdit">
												<label class="col-md-6 control-label">Requested Date</label>
												<label class="col-md-1 control-label">{{storeApprovalData.requisitionDate}}</label>
												<div class="col-md-6">
													<div class='input-group date datetimepick col-md-12'>
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="reqdate" role="button" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="Requisition Date"
																		data-validator="required" data-valid-method="submit"
																		data-message-id="ReqDate" ng-show="!isEdit"
																		data-ng-model="storeApprovalData.requisitionDate">
																	<!-- <span
																		class="input-group-addon"> <i
																		class="glyphicon glyphicon-calendar"></i>
																	</span> -->
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="storeApprovalData.requisitionDate"
																	data-on-set-time="storeApprovalData.requisitionDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#reqdate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group" ng-show="isEdit">
												<label class="col-md-6 control-label"> Status </label> <label
													class="col-md-1 control-label">{{storeApprovalData.requisitionStatusName}}</label>
												<div class="col-md-6">
													<select class="form-control" name="status"
														ng-model="storeApprovalData.requisitionStatus"
														data-ng-options="sTOp.requisitionStatus as sTOp.requisitionStatusName for sTOp in statusList "
														data-message-id="Status" data-validator="required"
														ng-show="!isEdit" data-valid-method="submit" required>
														<option value="">Select</option>

													</select>
												</div>
											</div>

											<div class="form-group" ng-show="isEdit">
												<label class="col-md-6 control-label">Approved Date</label>
												<label class="col-md-1 control-label">{{storeApprovalData.approvedDate}}</label>
												<div class="col-md-6">
													<div class='input-group date datetimepick col-md-12'>
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="reqdate" role="button" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="Requisition Date"
																		data-validator="required" data-valid-method="submit"
																		data-message-id="approvedDate" ng-show="!isEdit"
																		data-ng-model="storeApprovalData.approvedDate">
																	<!-- <span
																		class="input-group-addon"> <i
																		class="glyphicon glyphicon-calendar"></i>
																	</span> -->
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="storeApprovalData.approvedDate"
																	data-on-set-time="storeApprovalData.approvedDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#reqdate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>

										</fieldset>
									</div>
									<div class="col-sm-10 col-md-5">


										<div class="form-group" ng-show="isEdit">
											<label class="col-md-6 control-label"> Approved By </label> <label
												class="col-md-1 control-label">{{storeApprovalData.employeeName}}</label>
											<div class="col-md-6">

												<select class="form-control input-sm"
													data-ng-model="storeApprovalData.employeeId"
													ng-show="!isEdit"
													data-ng-options="sTOs.employeeId as sTOs.employeeName for sTOs in employeeList "
													data-ng-change="onChangeJobTittle(storeApprovalData.employeeId)"
													data-message-id="Requested by" data-validator="required"
													data-valid-method="submit">
													<option value="">Select</option>
												</select>
											</div>
										</div>
										<div class="form-group" ng-show="isEdit">
											<label class="col-md-6 control-label">Reason</label> <label
												class="col-md-1 control-label">{{storeApprovalData.remarks}}</label>
											<div class="col-md-6">
												<textarea type="text" class="form-control input-sm" rows="2"
													cols="25"
													name="<spring:message code="label.locationActivity"></spring:message>"
													ng-show="!isEdit" ng-model="storeApprovalData.remarks"
													style="resize: none"></textarea>
											</div>
										</div>
									</div>
									<div class="row">
										<div class=" col-sm-12"
											data-ng-repeat="(trIndex, table) in storeApprovalData.tables">
											<div class="row padding-top-15">
												<div class="col-md-12">
													<table
														class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">

														<thead>
															<tr>

																<th class="sorting text-center padding-both-side-2">Item
																	Code-Item Name</th>
																<th class="sorting text-center padding-both-side-2">Item
																	Category</th>
																<th class="sorting text-center padding-both-side-2">UoM</th>
																<th class="sorting text-center padding-both-side-2">Quantity</th>
																<th class="sorting text-center padding-both-side-2">EDD</th>


															</tr>
														</thead>
														<tbody
															ng-repeat="(trIndex, storeTableRow) in table.storeTableRow">
															<tr>
																<td class="width_10" ng-show="isEdit">
																	<div class="row">
																		<div class="col-xs-12">

																			<label class="col-md-8 control-label">{{storeTableRow.itemName}}</label>

																		</div>
																	</div>
																</td>

																<td class="width_10" ng-show="isEdit">
																	<div class="row">
																		<div class="col-xs-12">

																			<label class="col-md-8 control-label">{{storeTableRow.itemCategoryName}}</label>
																		</div>
																	</div>
																</td>
																<td class="width_10" ng-show="isEdit">
																	<div class="row">
																		<div class="col-xs-12">

																			<label class="col-md-8 control-label">{{storeTableRow.uomName}}</label>
																		</div>
																	</div>
																</td>

																<td class="width_10" ng-show="isEdit">
																	<div class="row">
																		<div class="col-xs-12">

																			<label class="col-md-8 control-label">{{storeTableRow.quantity}}</label>
																		</div>
																	</div>
																</td>

																<td class="width_10" ng-show="isEdit">
																	<div class="row">
																		<div class="col-xs-12">
																			<label class="col-md-8 control-label">{{storeTableRow.eddDate}}</label>
																		</div>
																	</div>
																</td>

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
												class="btn btn-success" data-ng-click="cancel();">
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