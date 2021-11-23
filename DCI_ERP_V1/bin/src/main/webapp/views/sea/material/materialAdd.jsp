<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
								<form class="form-horizontal" name="consignmentRequestForm" novalidate method="post">
								<div class="row" ng-init="requisitionStatus();">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
										<div class="col-md-6">
											<div class="form-group"
												ng-show="isEdit">
												<label class="col-md-4 control-label"> Requisition
													No <span style="color:red";> *</span>
												</label> <label class="col-md-7" style="margin-top: 2%;">{{consignmentRequestData.requisitionNumber}}</label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm"
														name="requisitionNumber" readonly
														ng-model="consignmentRequestData.requisitionNumber"
														ng-show="!isEdit">

												</div>
											</div>
											<div class="form-group">
					        				<label class="col-md-4 control-label"> <%-- <spring:message
			              			code="label.company.name"></spring:message> --%>Organization Name <span style="color:red";> *</span></label>
					        				<div class="col-md-7">
						        				<selectivity list="companyList" 
						        				  property="consignmentRequestData.companyId" id="hospital"
						        				ng-model="consignmentRequestData.companyId" name="hospital" form-name = "consignmentRequestForm"
						        				validation="required" friendly-name="<spring:message
			              			code="label.company.name"></spring:message>"></selectivity>
											</div>
										</div>
										<div class="form-group">
												<label class="col-md-4 control-label"> Request Type  <span style="color: red;">*</span>
												</label>
											 	<div class="col-md-7">
													<selectivity list="requestTypeList" 
													  ng-model="consignmentRequestData.requestType" property="consignmentRequestData.requestType" id="requestType" object="requestType"  name="requestType" validation="required" friendly-name="Reques tType" form-name = "consignmentRequestForm"></selectivity>
												</div>
												</div> 
											<!-- <div class="form-group">
												<label class="col-md-4 control-label">Requested Date</label>
												<div class="col-md-7">
													<div class='input-group date datetimepick col-md-12'>
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="requisitionDate" role="button" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																	 
																		placeholder="dd/mm/yyyy" name="requisitionDate" readonly
																		data-ng-model="consignmentRequestData.requisitionDate">
																	<span class="input-group-addon"> <i
																		class="glyphicon glyphicon-calendar"></i>
																	</span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="consignmentRequestData.requisitionDate"
																	data-on-set-time="consignmentRequestData.requisitionDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#requisitionDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div> -->
											
												<div class="form-group ">
								<label class="col-md-4 control-label">Requested Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="consignmentRequestData.requisitionDate"
										id="requisitionDate" name="requisitionDate"
										data-ng-change="checkDatesCL(consignmentRequestData.requisitionDate)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
											<div class="form-group">
												<label class="col-md-4 control-label"> Source Location <span style="color: red;">*</span>
												</label>
											 	<div class="col-md-7">
													<selectivity list="parentLocationList" 
													  
													ng-model="consignmentRequestData.sourceLocation" property="consignmentRequestData.sourceLocation" id="sourceLocation" object="sourceLocation"  name="sourceLocation" validation="required" friendly-name="Source Store" form-name = "consignmentRequestForm"></selectivity>
												</div>
												</div>

												<div class="form-group">
											<label class="col-md-4 control-label"> Destination Location <span style="color: red;">*</span></label>
											<div class="col-md-7">

												 <selectivity list="parentLocationList"  
												 ng-model="consignmentRequestData.destinationLocation" property="consignmentRequestData.destinationLocation" id="destinationLocation" object="destinationLocation"  name="destinationLocation" validation="required" friendly-name="Destination Store" form-name = "consignmentRequestForm"></selectivity>

											</div>
										</div>
										
											

									</div>
									<div class="col-md-6">
									<div class="form-group">
											<label class="col-md-4 control-label"> Cost Center <span style="color: red;">*</span></label>
											<div class="col-md-7">

												 <selectivity list="costList"  
												 ng-model="consignmentRequestData.costcenter" property="consignmentRequestData.costcenter" id="costcenter" object="costcenter"  name="costcenter" validation="required" friendly-name="Cost Center" form-name = "consignmentRequestForm"></selectivity>

											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Requested By </label>
											<div class="col-md-7">
												 <selectivity list="employeeList"  
												 property="consignmentRequestData.employeeId" id="employeeId"></selectivity>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Job Title</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="designationName"
													 
													ng-model="consignmentRequestData.designationName"
													readonly="readonly">
											</div>
										</div>
										
										
										<div class="form-group">
					        				<label class="col-md-4 control-label">PR Request No</label>
					        				<div class="col-md-7">
					        				<input type="text" class="form-control input-sm text-left"
					        				 
																				data-ng-model="consignmentRequestData.prReqNo" name="prReqNo"
																				form-name="consignmentRequestForm" ng_blur = "checkDuplicate(consignmentRequestData.prReqNo,consignmentRequestData.requisitionNumber)";
																				id="prReqNo" friendly-name="PR Request Number"/>
											</div>
										</div>
																			
										<!-- <div class="form-group">
					        				<label class="col-md-4 control-label">Request Date</label>
					        				<div class="col-md-7">
					        				<div class='input-group date datetimepick col-md-12'>
											<div class="dropdown">
												<a class="dropdown-toggle" id="fromdate" role="button"
													data-toggle="dropdown" data-target="#" href="#">
													<div class="input-group">
														<input type="text" class="form-control"
															placeholder="dd/mm/yyyy" name="reqDate"
															friendly-name="reqDate"
															 
															data-ng-model="consignmentRequestData.reqDate"><span
															class="input-group-addon"><i
															class="glyphicon glyphicon-calendar"></i></span>
													</div>
												</a>
												<ul class="dropdown-menu" role="menu"
													aria-labelledby="dLabel">
													<datetimepicker data-ng-model="consignmentRequestData.reqDate"
													 
														data-on-set-time="consignmentRequestData.reqDate = onDateSet(newDate)"
														data-datetimepicker-config="{ dropdownSelector: '#fromdate',startView:'day', minView:'day'}" />
												</ul>
											</div>
										</div>
											</div>
										</div> -->
										
										<div class="form-group ">
								<label class="col-md-4 control-label">Request Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="consignmentRequestData.reqDate"
										id="fromdate" name="reqDate"
										data-ng-change="checkDatesCL(consignmentRequestData.reqDate)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div>
									</div>
									</fieldset>
									</div>

									<div class="row">
										<div class=" col-sm-12" data-ng-repeat="(trIndex, table) in consignmentRequestData.tables">
											<div class="row padding-top-15">
												<div class="col-md-12">
													<table class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">

														<thead>
															<tr>
																<th class="width_1 text-center table-heading">
														            <label class="i-checks m-b-none">
														             <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(selectedAll)">
														             <i></i>
														            </label>
													           </th>
																<th class="sorting text-center padding-both-side-2">Item
																	Code-Item Name <span style="color: red;">*</span></th>
																<th class="sorting text-center padding-both-side-2">Item
																	Category</th>
																		<th class="sorting text-center padding-both-side-2">UoM</th>
																		<th class="sorting text-center padding-both-side-2">Item Description</th>
																		<th class="sorting text-center padding-both-side-2">Available Qty</th>
<!-- 																		<th class="sorting text-center padding-both-side-2">Avl.Quantity</th>
 -->																<th class="sorting text-center padding-both-side-2">Quantity <span style="color: red;">*</span></th>
<!-- 																<th class="sorting text-center padding-both-side-2">EDD <span style="color: red;">*</span></th>
 -->																
 																			<th class="sorting text-center padding-both-side-2">Alternate UOM </th>
 																			<th class="sorting text-center padding-both-side-2">Alternate Qty  </th>
 																				<th class="sorting text-center padding-both-side-2">EDD</th>
 

															</tr>
														</thead>
														<tbody
															ng-repeat="(trIndex, consignmentReqRow) in table.consignmentReqRow" ng-controller="parentCtrl" >
															<tr>
																<td><label class="i-checks m-b-none"> <input
																		type="checkbox" data-ng-model="consignmentReqRow.section"><i></i></label></td>
																<td class="width_15">
																	<div class="row">
																		<div class="col-xs-12">
																			<selectivity list="itemList"
																				property="consignmentReqRow.itemId"
																				name="{{ 'Item' + trIndex }}"
																				ng-model="consignmentReqRow.itemId"
																				id="itemId{{trIndex}}" validation="required"
																				 
																				friendly-name="{{ 'Row' + (trIndex+1) + '(Item Code)'}}"
																				form-name="consignmentRequestForm"></selectivity>
																		</div>
																	</div>
																</td>
																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input type="text" class="form-control input-sm"
																				data-ng-model="consignmentReqRow.itemCategoryName"
																				readonly="readonly" />
																		</div>
																	</div>
																</td>
															
																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input type="text" class="form-control input-sm"
																				data-ng-model="consignmentReqRow.uomName"
																				readonly="readonly" />
																		</div>
																	</div>
																</td>
																	 <td class="width_10">
																	<div class="row">
																		<div class="col-xs-12"  title={{consignmentReqRow.itemdescription}}>
																			<input type="text" class="form-control input-sm text-right"
																				
																				data-ng-model="consignmentReqRow.itemdescription" name="{{ 'itemdescription' + trIndex }}"
																				form-name="consignmentRequestForm" maxlength="250"
																				id="itemdescription{{trIndex}}" friendly-name="{{ 'Row' + (trIndex+1) + '(ItemDescription)'}}" 
																				/>
																		</div>
																	</div>
																</td> 
																	<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input type="text" class="form-control input-sm"
																				data-ng-model="consignmentReqRow.availQuantity"id="availQuantity{{trIndex}}"
																				readonly="readonly" />
																		</div>
																	</div>
																</td>
																
																<!--  <td class="width_10">
																	<div class="row">
																		<div class="col-xs-12"  title={{consignmentReqRow.availQuantity}}>
																			<input type="text" class="form-control input-sm text-right"
																				
																				data-ng-model="consignmentReqRow.availQuantity" name="{{ 'availQuantity' + trIndex }}"
																				form-name="consignmentRequestForm"
																				id="availQuantity{{trIndex}}" friendly-name="{{ 'Row' + (trIndex+1) + 'availQuantity}}" 
																				disabled/>
																		</div>
																	</div>
																</td> -->
																
																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input type="text" class="form-control input-sm text-right"
																				data-ng-model="consignmentReqRow.quantity" name="{{ 'quantity' + trIndex }}"
																				placeholder="0" ng-pattern-restrict="^[0-9.]*$"	 form-name="consignmentRequestForm"
																				id="quantity{{trIndex}}" friendly-name="{{ 'Row' + (trIndex+1) + '(Quantity)'}}" 
																				validation="required" />
																		</div>
																	</div>
																</td>
																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
												 							<!-- <input type="text" class="form-control input-sm"
																				data-ng-model="consignmentReqRow.altuomName"
																				readonly="readonly" /> -->
																				<selectivity list="uomCategoryList" 
																				property="consignmentReqRow.altuom" 
																				name="{{ 'altuom' + trIndex }}" 
																				ng-model="consignmentReqRow.altuom" 
																				id="altuom{{trIndex}}" 
																				 
																				friendly-name="{{ 'Row' + (trIndex+1) + '(altuom)'}}" 
																				form-name = "consignmentRequestForm"></selectivity>
																		
																				</div>
																	</div>
																</td>
																<td class="width_10">
																	<div class="row">
																		<div class="col-xs-12">
																			<input type="text" class="form-control input-sm text-right"
																				data-ng-model="consignmentReqRow.altqty" name="{{ 'altqty' + trIndex }}"
																				placeholder="0" ng-pattern-restrict="^[0-9.]*$"	 form-name="consignmentRequestForm"
																				id="altqty{{trIndex}}"  friendly-name="{{ 'Row' + (trIndex+1) + '(altqty)'}}" 
																			/>
																		</div>
																	</div>
																</td>
																<td class="width_10">
																<div class="row">
																	<div class='input-group date datetimepick col-md-12'>
																		<!-- <div class="dropdown">
																				<a class="dropdown-toggle" id="eddDate{{trIndex}}" role="button"
																					data-toggle="dropdown" data-target="#" href="#">
																					<div class="input-group">
																						<input type="text" class="form-control"
																							placeholder="dd/mm/yyyy"
																							name="{{ 'eddDate' + trIndex }}"
																							id="{{ 'eddDate' + trIndex }}"
																							friendly-name="{{ 'Row' + (trIndex+1) + 'EDD Date'}}"
		       																				
																							data-ng-model="consignmentReqRow.eddDate"> <span
																							class="input-group-addon"> <i
																							class="glyphicon glyphicon-calendar"></i>
																						</span>
																					</div>
																				</a>
																				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel" style="top:-100px;">
																					<datetimepicker data-ng-model="consignmentReqRow.eddDate"
																						data-on-set-time="consignmentReqRow.eddDate = onDateSet(newDate)"
																						data-datetimepicker-config="{ dropdownSelector: '#eddDate{{trIndex}}',startView:'day', minView:'day'}" />
																				</ul>
																			</div> -->
																			
																			<div class="form-group ">
							
								<div class="col-md-11 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="consignmentReqRow.eddDate"
										id="{{ 'eddDate' + trIndex }}"	name="{{ 'eddDate' + trIndex }} "	
										friendly-name="{{ 'Row' + (trIndex+1) + 'EDD Date'}}"
										data-ng-change="checkDatesCL(consignmentReqRow.eddDate)"
										 validation="required" />
								</div>
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
  								<!--  <div >   -->
  									<%-- <button class="btn btn-success" type="button" data-ng-if="disableSave" disabled
										data-ng-model="add" class="btn btn-success"
										data-ng-click="validate(consignmentRequestForm,consignmentRequestData)" data-ng-if="!isEdit" >
										<i class="fa fa-save" >444</i>
										<spring:message code="label.save"></spring:message>
									</button> --%>
								<!-- 	</div> -->
  								<!-- 	 <div ng-if="!disableSave">  -->
 									<button class="btn btn-success" type="button"  
										data-ng-model="add" class="btn btn-success"
										data-ng-click="validate(consignmentRequestForm,consignmentRequestData)" data-ng-if="!isEdit">
										<i class="fa fa-save"></i>
										Save
									</button>
								<!-- 	</div>  -->
									<button class="btn btn-success" type="button"
										class="btn btn-success" 
										data-ng-click="validate(consignmentRequestForm,consignmentRequestData)" data-ng-if="isEdit">
										<i class="fa fa-save"></i>
										Update
									</button>
									<button class="btn btn-info" type="button"
										class="btn btn-success" ng-show="consignmentRequestData.requisitionStatus==68"
										data-ng-click="reset(consignmentRequestForm);">
										<i class="fa fa-undo"></i>
										Reset
									</button>
									<button class="btn btn-danger" type="button"
										class="btn btn-success" data-ng-click="cancel();">
										<i class="fa fa-close"></i>
										Cancel
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

