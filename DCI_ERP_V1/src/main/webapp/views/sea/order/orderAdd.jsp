<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
.selectivity-backdrop {
background: transparent;
position: relative;
z-index: 9998;
top: 0;
right: 0;
bottom: 0;
left: 0;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="storeApprovalForm" novalidate
								method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="col-md-6">
												<div class="form-group" ng-show="isEdit">
													<label class="col-md-3 control-label"> Requisition
														No </label> <label class="col-md-1" style="margin-top:6px;">{{storeApprovalData.requisitionNumber}}</label>
													 <div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="sourceStore" id="sourceStore"
															ng-model="storeApprovalData.requisitionNumber"
															ng-show="!isEdit">

													</div> 
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Requested
														Date</label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a data-toggle="dropdown" class="dropdown-toggle"
																	id="requisitionDate" role="button" data-target="#"
																	href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy"
																			data-ng-model="storeApprovalData.requisitionDate" disabled>
																		<span class="input-group-addon"> <i
																			class="glyphicon glyphicon-calendar"></i>
																		</span>
																	</div>
																</a>
																<!-- <ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="storeApprovalData.requisitionDate"
																		data-on-set-time="storeApprovalData.requisitionDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#requisitionDate',startView:'day', minView:'day'}" disabled/>
																</ul> -->
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Status <spring:message
															code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<!-- <select class="form-control" name="status" id="status"
															ng-model="storeApprovalData.requisitionStatus"
															data-ng-options="sTOp.requisitionStatus as sTOp.requisitionStatusName for sTOp in statusList"
															name="status" validation="required"
															friendly-name="Status">
															<option value="">Select</option>
														</select> -->
														<selectivity list="statusList" property="storeApprovalData.requisitionStatus" id="requisitionStatus"
								        					ng-model="storeApprovalData.requisitionStatus" name="requisitionStatus" form-name="storeApprovalForm"
								        					validation="required" friendly-name="Status"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Approved Date
														<spring:message code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a data-toggle="dropdown" class="dropdown-toggle"
																	id="approvedDate" role="button" data-target="#"
																	href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="approvedDate"
																			validation="date_euro_long|required"
																			friendly-name="Approved Date"
																			data-ng-model="storeApprovalData.approvedDate">
																		<span class="input-group-addon"> <i
																			class="glyphicon glyphicon-calendar"></i>
																		</span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="storeApprovalData.approvedDate"
																		data-on-set-time="storeApprovalData.approvedDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#approvedDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-6">

												<div class="form-group">
													<label class="col-md-3 control-label"> Requested By
													</label>
													<div class="col-md-7">

														<input type="text" class="form-control input-sm"
															name="employeeName" id="employeeName"
															ng-model="storeApprovalData.employeeName"
															readonly="readonly">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Approved By
													</label>
													<div class="col-md-7">
														<!-- 	<selectivity list="employeeList"
													property="storeApprovalData.employeeId" id="employeeId"></selectivity>
													 -->
														<input type="text" class="form-control input-sm"
															name="approvedId" id="approvedId"
															ng-model="storeApprovalData.approvedId"
															readonly="readonly">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Reason </label>
													<div class="col-md-7">
														<textarea type="text" class="form-control input-sm"
															rows="2" cols="25" name="remarks" 
															
															ng-model="storeApprovalData.remarks" style="resize: none"></textarea>
													</div>
												</div>
											</div>
										</fieldset>
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
																<!-- <th colspan=1 class="sorting width_1"></th> -->
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
															ng-repeat="(trIndex, storeTableRow) in table.storeTableRow"
															ng-controller="parentCtrl">
															<tr>
																<!-- <td><label class="i-checks m-b-none"> <input
																		type="checkbox"
																		data-ng-model="storeTableRow.section[$index]"
																		id="section{{trIndex}}"><i></i></label></td> -->
																<td class="width_15">
																	<div class="row">
																		<div class="col-xs-12">

																			<!-- <selectivity list="itemList"
																				property="storeTableRow.itemId"
																				id="itemId{{trIndex}}"></selectivity> -->

																			<!-- <input type="hidden" data-ng-model="storeTableRow.itemId"
																				name="itemId" 
																				id="itemId{{trIndex}}" readonly="readonly"
																				class="form-control input-sm text"> -->
																				
																				<input type="text" data-ng-model="storeTableRow.text" name="itemNames"  
																				id="itemName{{trIndex}}" readonly="readonly" class="form-control input-sm text">

																		</div>
																	</div>
																</td>



																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input type="text" class="form-control input-sm"
																				data-ng-model="storeTableRow.itemCategoryName"
																				readonly="readonly" />
																		</div>
																	</div>
																</td>
																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input type="text" class="form-control input-sm"
																				data-ng-model="storeTableRow.uomName"
																				readonly="readonly" />
																		</div>
																	</div>
																</td>

																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input type="text"
																				class="form-control input-sm text-right"
																				data-ng-model="storeTableRow.quantity"
																				name="{{ 'quantity' + trIndex }}"
																				form-name="storeApprovalForm" validation="required"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Quantity)'}}"
																				id="quantity{{trIndex}}" readonly="readonly"/>
																		</div>
																	</div>
																</td>

																<td class="width_10">
																	<div class="row">
																		<div class='input-group date datetimepick col-md-12'>
																			<div class="dropdown">
																				<a data-toggle="dropdown" class="dropdown-toggle"
																					ng-attr-id="{{ 'eddDate-' + $index }}"
																					role="button" data-target="#" href="#">
																					<div class="input-group">
																						<input type="text" class="form-control"
																							placeholder="dd/mm/yyyy" name="eddDate"
																							validation="date_euro_long|required"
																							friendly-name="Edd Date"
																							data-ng-model="storeTableRow.eddDate" readonly="readonly"> <span
																							class="input-group-addon"> <i
																							class="glyphicon glyphicon-calendar"></i>
																						</span>
																					</div>
																				</a>
																		<!-- 		<ul class="dropdown-menu" role="menu"
																					aria-labelledby="dLabel">
																					<datetimepicker
																						data-ng-model="storeTableRow.eddDate"
																						data-on-set-time="storeTableRow.eddDate = onDateSet(newDate)"
																						data-datetimepicker-config="{ dropdownSelector: '{{ '#eddDate-' + $index }}'
																,startView:'day', minView:'day'}" />
																				</ul> -->
																			</div>
																		</div>
																	</div>
																</td>

															</tr>
														</tbody>
													</table>
													<!-- <div class="padding-right-5" id="AddOrRmveMeritbtn">
														<button ng-click="addRow(table)"
															class="btn btn-sm btn-info" tooltip="Add Row"
															ng-disabled="" type="button">
															<i class="fa fa-plus"></i>
														</button>
														<button ng-click="removeRow(table)"
															class="btn btn-sm btn-danger" type="button"
															tooltip="Delete">
															<i class="fa  fa-trash-o"></i>
														</button>
													</div> -->
												</div>
											</div>
										</div>
									</div>

								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">

											<button class="btn btn-success" type="button"
												class="btn btn-success"
												data-ng-click="save(storeApprovalForm,storeApprovalData)"
												data-ng-if="isEdit">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success"
												data-ng-click="reset(storeApprovalForm);">
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
					</div>
				</div>
			</article>
		</div>
	</section>
</div>