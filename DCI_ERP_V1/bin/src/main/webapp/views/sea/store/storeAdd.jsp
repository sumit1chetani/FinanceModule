<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
	table.dataTable thead .sorting:after {
		content: "";
	}
	
	#sourceLocation > div{
		max-width:309px !important;
	}

	#sourceLocation > div > div{
		width:309px !important;
		overflow:auto;
	}
	
	#destinationLocation > div{
		max-width:309px !important;
	}

	#destinationLocation > div > div{
		width:309px !important;
		overflow:auto;
	}

</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
							<form class="form-horizontal" name="storeToStoreAddForm"
								novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="col-md-6">
												<div class="form-group" ng-show="isEdit">
													<label class="col-md-3 control-label"> Requisition
														No <span style="color:red">*</span>
													</label> <label class="col-md-1 control-label">{{storeToStoreData.requisitionNumber}}</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="requisitionNumber" readonly
															ng-model="storeToStoreData.requisitionNumber"
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
																		<input type="text" class="form-control" readonly
																			placeholder="dd/mm/yyyy" name="requisitionDate"
																			data-ng-model="storeToStoreData.requisitionDate">
																		<span class="input-group-addon"> <i
																			class="glyphicon glyphicon-calendar"></i>
																		</span>
																	</div>
																</a>
																<!-- <ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="storeToStoreData.requisitionDate"
																		data-on-set-time="storeToStoreData.requisitionDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#requisitionDate',startView:'day', minView:'day'}" />
																</ul> -->
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Source
														Location <span style="color: red;">*</span></label>
													<div class="col-md-7">
														<selectivity list="parentLocationList"
															property="storeToStoreData.sourceLocation"
															ng-model="storeToStoreData.sourceLocation" 
															name="sourceLocation" form-name="storeToStoreAddForm"
															validation="required" friendly-name="Source Location" data-ng-if="!isEdit"
															id="sourceLocation"></selectivity>
																<selectivity list="parentLocationList"
															property="storeToStoreData.sourceLocation"
															ng-model="storeToStoreData.sourceLocation" 
															name="sourceLocation" form-name="storeToStoreAddForm"
															validation="required" friendly-name="Source Location" disabled="true" data-ng-if="isEdit"
															id="sourceLocation"></selectivity>

													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label"> Destination Location <span style="color: red;">*</span></label>
													<div class="col-md-7">
														
														
															<selectivity list="parentLocationList"
															property="storeToStoreData.destinationLocation"
															name="destinationLocation"
															form-name="storeToStoreAddForm"
															ng-model="storeToStoreData.destinationLocation"
															validation="required"
															friendly-name="Destination Location"
															id="destinationLocation" ></selectivity>
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-4 control-label"> Requested By
													</label>
													<div class="col-md-7">
														<selectivity list="employeeList"
															property="storeToStoreData.employeeId" id="employeeId"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Job Title</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="designationName"
															ng-model="storeToStoreData.designationName"
															readonly="readonly">
													</div>
												</div>

												<div class="form-group">
							        				<label class="col-md-4 control-label"> <%-- <spring:message
			              			code="label.company.name"></spring:message> --%> Organization Name <span style="color:red">*</span></label>
							        				<div class="col-md-7">
								        				<selectivity list="companyList" property="storeToStoreData.companyId" id="hospital"
								        				ng-model="storeToStoreData.companyId" name="hospital" form-name = "storeToStoreAddForm"
								        				validation="required" friendly-name = "Company Name"></selectivity>
													</div>
												</div>
											</div>

										</fieldset>
									</div>
									<div class="row">
										<div class=" col-sm-12"
											data-ng-repeat="(trIndex, table) in storeToStoreData.tables">
											<div class="row padding-top-15">
												<div class="col-md-12">
													<table
														class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
														<thead>
															<tr>
																<th class="width_1 text-center table-heading">
		            											<label class="i-checks m-b-none">
		            												 <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(storeToStoreData.tables,selectedAll)">
		           													  <i></i>
		           												 </label>
	          													 </th>
																<th class="sorting text-center padding-both-side-2">Item Code-Item Name <span style="color: red;">*</span></th>
																<th class="sorting text-center padding-both-side-2">Item Category</th>
																<th class="sorting text-center padding-both-side-2">UoM</th>
																<th class="sorting text-center padding-both-side-2">Physical Qty</th>
																<th class="sorting text-center padding-both-side-2">Qty <span style="color: red;">*</span></th>
																<th class="sorting text-center padding-both-side-2">EDD <span style="color: red;">*</span></th>
															</tr>
														</thead>
														<tbody ng-repeat="(trIndex, storeTableRow) in table.storeTableRow" ng-controller="parentCtrl">
															<tr>
																<td>
																	<label class="i-checks m-b-none"> 
																		<input type="checkbox" data-ng-model="storeTableRow.select" id="section{{trIndex}}"><i></i></label>
																</td>
																<td class="width_15">
																	<div class="row">
																		<div class="col-xs-12">
																			<selectivity list="itemList" 
																				property="storeTableRow.itemId"
																				ng-model="storeTableRow.itemId"
																				name="{{ 'Item' + trIndex }}"
																				form-name="storeToStoreAddForm"
																				validation="required"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Item Code)'}}"
																				id="itemId{{trIndex}}"></selectivity>
																				
																			<!-- 	<selectivity list="itemList" ng-if="!isEdit"
																				property="storeTableRow.itemId"
																				ng-model="storeTableRow.itemId"
																				name="{{ 'Item' + trIndex }}"
																				form-name="storeToStoreAddForm"
																				validation="required"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Item Code)'}}"
																				id="itemId{{trIndex}}"></selectivity>
																				
																					<selectivity list="itemList" ng-if="isEdit && storeTableRow.physicalQty==0"
																				property="storeTableRow.itemId"
																				ng-model="storeTableRow.itemId"
																				name="{{ 'Item' + trIndex }}"
																				form-name="storeToStoreAddForm"
																				validation="required" disabled="true"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Item Code)'}}"
																				id="itemId{{trIndex}}"></selectivity> -->
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
																				data-ng-model="storeTableRow.physicalQty"
																				name="{{ 'physicalQty' + trIndex }}"
																				form-name="storeToStoreAddForm"
																				validation="required" placeholder="0"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(physicalQty)'}}"
																				id="quantity{{trIndex}}" ng-pattern-restrict="{{numExp}}" 
																				ng-disabled="storeTableRow.itemCategoryType!=51 || isEdit" />
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
																				form-name="storeToStoreAddForm" ng-blur="checkQuantity()";
																				validation="required" placeholder="0" 
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Quantity)'}}" 
																				id="quantity{{trIndex}}" ng-pattern-restrict="{{numExp}}" />
																				
																				
																				<!-- <input type="text"
																				class="form-control input-sm text-right"
																				data-ng-model="storeTableRow.quantity"
																				name="{{ 'quantity' + trIndex }}"
																				form-name="storeToStoreAddForm" ng-blur="checkQuantity()";
																				validation="required" placeholder="0" ng-if="isEdit && storeTableRow.physicalQty > 0"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Quantity)'}}" 
																				id="quantity{{trIndex}}" ng-pattern-restrict="{{numExp}}" />
																				<input type="text"
																				class="form-control input-sm text-right"
																				data-ng-model="storeTableRow.quantity"
																				name="{{ 'quantity' + trIndex }}"
																				form-name="storeToStoreAddForm" ng-blur="checkQuantity()";
																				validation="required" placeholder="0"
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Quantity)'}}" ng-if="!isEdit"
																				id="quantity{{trIndex}}" ng-pattern-restrict="{{numExp}}" /> -->
																		</div>
																	</div>
																</td>
																<td class="width_10">
																	<div class="row">
																		<div class="col-md-11">
																			<div class="dropdown">
																				
																					<div >
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
																						
																						<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="storeTableRow.eddDate"
											id="{{ 'eddDate' + trIndex }}" name="EOD Date"
										data-ng-change="checkDatesCL(storeTableRow.eddDate)" 
										friendly-name="EOD Date" validation="required" />
																						
																					</div>
																				</a>
																				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
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
													<div class="padding-right-5">
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
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												data-ng-model="add" class="btn btn-success"
												data-ng-click="save(storeToStoreAddForm,storeToStoreData)"
												data-ng-if="!isEdit">
												<i class="fa fa-save"></i>
Save											</button>
											<button class="btn btn-success" type="button"
												class="btn btn-success"
												data-ng-click="update(storeToStoreAddForm,storeToStoreData)"
												data-ng-if="isEdit">
												<i class="fa fa-save"></i>Update
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success"
												data-ng-click="reset(storeToStoreAddForm);">
												<i class="fa fa-undo"></i>Reset
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel();">
												<i class="fa fa-close"></i>Cancel
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

