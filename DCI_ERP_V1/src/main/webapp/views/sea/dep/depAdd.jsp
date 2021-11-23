<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
		
							<form class="form-horizontal" name="storeToPurchaseAddForm" novalidate method="post">
								<div class="row" ng-init="requisitionStatus();">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
										<div class="col-md-6">
											 <div class="form-group" ng-show="isEdit">
												<label class="col-md-4 control-label"> Requisition
													No 
												</label> <label class="col-md-1 control-label"></label>
												<div class="col-md-7 control-label">
													<input type="text" class="form-control input-sm"
														name="sourceStore" id="sourceStore" 
														ng-model="storeToPurchaseData.requisitionNumber"
														ng-show="!isEdit">

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Requested Date</label>
												<div class="col-md-7">
													<!-- <div class='input-group date datetimepick col-md-12'>
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="requisitionDate" role="button" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="requisitionDate" readonly
																		data-ng-model="storeToPurchaseData.requisitionDate">
																	<span class="input-group-addon" readonly> <i
																		class="glyphicon glyphicon-calendar"></i>
																	</span>
																</div>
															</a>
														

														</div>
													</div> -->
													<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="storeToPurchaseData.requisitionDate"
										id="requisitionDate" name="requisitionDate"
										data-ng-change="checkDatesCL(storeToPurchaseData.requisitionDate)"
										friendly-name="Valid From" validation="required" />
												</div>
											</div>

											<div class="form-group">
												<label class="col-md-4 control-label"> Requested
													Location <span style="color: red;">*</span></label>
												<div class="col-md-7">

													<selectivity list="parentLocationList"
														property="storeToPurchaseData.destinationLocation" ng-model="storeToPurchaseData.destinationLocation"
														name="destinationLocation" form-name="storeToPurchaseAddForm"
														validation="required" friendly-name="Requested Location"
														id="destinationLocation"></selectivity>

												</div>
											</div>

										</div>
									<div class="col-md-6">
										<div class="form-group">
											<label class="col-md-4 control-label"> Requested By <span style="color: red;">*</span></label>
											<div class="col-md-7">
												<selectivity list="employeeList"  ng-model="storeToPurchaseData.employeeId"
														name="employeeId" form-name="storeToPurchaseAddForm"
														validation="required" friendly-name="Requested By"
													property="storeToPurchaseData.employeeId" id="employeeId"></selectivity>
											</div>
										</div>

										<div class="form-group">
					        				<label class="col-md-4 control-label"> <%-- <spring:message
			              			code="label.company.name"></spring:message> --%>Organization Name</label>
					        				<div class="col-md-7">
						        				<selectivity list="companyList" property="storeToPurchaseData.companyId" id="hospital"
						        				ng-model="storeToPurchaseData.companyId" name="hospital" form-name = "storeToPurchaseAddForm"
						        				validation="required" friendly-name=""></selectivity>
											</div>
										</div>
									</div>
									</fieldset>
									</div>
									
									
									
									<div class="row">
										<div class=" col-sm-12" data-ng-repeat="(trIndex, table) in storeToPurchaseData.tables">
											<div class="row padding-top-15">
												<div class="col-md-12">
													<table class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
														<thead>
															<tr>
																<th class="width_1 text-center table-heading">
														            <label class="i-checks m-b-none">
														             <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(storeToPurchaseData.tables,selectedAll)">
														             <i></i>
														            </label>
													           </th>
																<th class="sorting text-center padding-both-side-2">Item
																	Code-Item
																	Name <span style="color: red;">*</span></th>

																
																<th class="sorting text-center padding-both-side-2">Item
																	Category</th>
																<th class="sorting text-center padding-both-side-2">UoM</th>
																<th class="sorting text-center padding-both-side-2">Quantity <span style="color: red;">*</span></th>
																<th class="sorting text-center padding-both-side-2">EDD <span style="color: red;">*</span></th>
															</tr>
														</thead>
														<tbody
															ng-repeat="(trIndex, storeTableRow) in table.storeTableRow"
															ng-controller="parentCtrl">
															<tr>
																<td><label class="i-checks m-b-none"> <input
																		type="checkbox" data-ng-model="storeTableRow.isselect" id="section{{trIndex}}"><i></i></label></td>
																<td class="width_15">
																	<div class="row">
																		<div class="col-xs-12">
																			<selectivity list="itemList"
																				property="storeTableRow.itemId" ng-model="storeTableRow.itemId"
																				name="{{ 'Item' + trIndex }}"
																				form-name="storeToPurchaseAddForm"
																				validation="required"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Item Code)'}}"
																				id="itemId{{trIndex}}"></selectivity>
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
																				form-name="storeToPurchaseAddForm"
																				validation="required" placeholder="0" ng-pattern-restrict="{{numExp}}"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Quantity)'}}"
																				id="quantity{{trIndex}}" />
																		</div>
																	</div>
																</td>
																<td class="width_10">
																	<div class="row">
																		<div class="input-group date datetimepick col-md-12">
																			<div class="dropdown">
																				<a class="dropdown-toggle" id="eddDate{{trIndex}}" role="button"
																					data-toggle="dropdown" data-target="#" href="#">
																					<div class="input-group">
																						<!-- <input type="text" class="form-control"
																							placeholder="dd/mm/yyyy"
																							name="{{ 'eddDate' + trIndex }}"
																							id="{{ 'eddDate' + trIndex }}"
																							friendly-name="{{ 'Row' + (trIndex+1) + 'EDD Date'}}"
		       																				validation="required"
																							data-ng-model="storeTableRow.eddDate"> <span
																							class="input-group-addon"> <i
																							class="glyphicon glyphicon-calendar"></i>
																						</span> -->
																						
																						<div class="col-md-11 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="storeTableRow.eddDate"
										id="{{ 'eddDate' + trIndex }}"	name="{{ 'eddDate' + trIndex }} "	
										friendly-name="{{ 'Row' + (trIndex+1) + 'EDD Date'}}"
										data-ng-change="checkDatesCL(storeTableRow.eddDate)"
										 validation="required" />
								</div>
																					</div>
																				</a>
																				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel" style="top:-100px;">
																					<datetimepicker data-ng-model="storeTableRow.eddDate"
																						data-on-set-time="storeTableRow.eddDate = onDateSet(newDate)"
																						data-datetimepicker-config="{ dropdownSelector: '#eddDate{{trIndex}}',startView:'day', minView:'day'}" />
																				</ul>
																			</div>
																		</div>
																	</div>
																</td>
																
															</tr>
														</tbody>
													</table>
													<div class="padding-right-5" id="AddOrRmveMeritbtn" ng-if="storeToPurchaseData.requisitionStatus==68">
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
													</div>
												</div>
											</div>
										</div>
									</div>
								   </div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												data-ng-model="add" class="btn btn-success"
												data-ng-click="save(storeToPurchaseAddForm,storeToPurchaseData)"
												data-ng-if="!isEdit">
												<i class="fa fa-save">Request for Approval</i> 
											</button>
											<button class="btn btn-success" type="button"
												class="btn btn-success"
												data-ng-click="update(storeToPurchaseAddForm,storeToPurchaseData)"
												data-ng-if="isEdit"
												ng-show="storeToPurchaseData.requisitionStatus==68">
												<i class="fa fa-save"></i>
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success" ng-show="storeToPurchaseData.requisitionStatus==68"
												data-ng-click="reset(storeToPurchaseAddForm);">
												<i class="fa fa-undo">Reset</i>
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close">Cancel</i>
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