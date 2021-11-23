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
	background: white !important;
	background-color: white !important;
	border: 0px !important;
}

.b-grey {
	border: 0px !important;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- #MAIN CONTENT -->

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
							<form class="form-horizontal" name="ondutyrequestForm" novalidate
								method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="col-md-6">
												<div class="form-group" ng-if="edit">
													<label class="col-md-4 control-label">Stock
														Transfer No</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="AssetCode" ng-model="StockTransfor.stockId"
															readonly>
													</div>
												</div>



												<div class="form-group">
													<label class="col-md-4 control-label">Transfer Date<span style = "color:red">*</span></label>
													<div class="col-md-7">
														<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="fromdate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="fromdate"
																			validation="date_euro_long|required"
																			friendly-name="Transfer Date"
																			data-ng-model="StockTransfor.date" readonly><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<!--  <ul class="dropdown-menu" role="menu"
												              aria-labelledby="dLabel">
												              <datetimepicker data-ng-model="StockTransfor.date"
												               data-on-set-time="StockTransfor.date = onDateSet(newDate)"
												               data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
												             </ul> -->
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Transfer
														Type<span style = "color:red">*</span>
													</label>
													<!-- 	<div class="col-md-7">
														<selectivity list="issueList"
															property="StockTransfor.issueType"
															ng-model="StockTransfor.status" id="issueType"
															name="issueType" validation="required"
															friendly-name="issueType" form-name="ondutyrequestForm"></selectivity>
													</div> -->
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="issueType" ng-model="StockTransfor.issueTypeName"
															readonly>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Company Name <span style = "color:red">*</span></label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="AssetCode" ng-model="StockTransfor.companyName"
															readonly>
													</div>
													<!-- <div class="col-md-7" ng-if="!edit">
							        				<input type="text" class="form-control input-sm"
														name="AssetCode" ng-model="StockTransfor.companyName" readonly>
												</div> -->
												</div>


												<%-- <div class="form-group">
													<label class="col-md-4 control-label">
														Transportation Type<spring:message
															code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-7">
														<selectivity list="Transportation"
															property="StockTransfor.transportType" id=""
															ng-model="StockTransfor.transportType"
															name="transportType" form-name="ondutyrequestForm"
															validation="required" friendly-name="Transportation Type"
															disabled="true"></selectivity>


														<!-- <select class="form-control input-sm"
														ng-model="StockTransfor.transportType"
														name="Hospital Name" id="type"
														ng-change="transportationonchange(StockTransfor.transportType)"
														 data-valid-method="submit"
														data-message-id="Transportation Type" ng-options="c.id as c.name for c in Transportation">
														<option value="">Select</option>

													</select> -->
													</div>
												</div> --%>

												<div class="form-group" id="personname"
													style="display: none;">
													<label class="col-md-4 control-label">Person Name</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="Requisition Date"
															ng-model="StockTransfor.personName" id="personName"
															readonly>


													</div>
												</div>

												<div class="form-group" id="servicename"
													style="display: none;">
													<label class="col-md-4 control-label">Service Name</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm" readonly
															name="AssetCode" ng-model="StockTransfor.serviceName">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Source
														Location</label>
													<div class="col-md-7">

														<input type="text" class="form-control input-sm"
															name="Source Location"
															ng-model="StockTransfor.sourceLocName" id="sourceLocName"
															readonly>

													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Destination
														Location</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="Destination Location"
															ng-model="StockTransfor.destLocName" id="destLocName"
															readonly>

													</div>
												</div>
											</div>
											<div class="col-md-6">

												<div class="form-group" ng-if="materialIssueflag">
													<label class="col-md-4 control-label"> Requisition
														No <span style = "color:red">*</span>
													</label>
													<div class="col-md-7">
														<!-- <selectivity list="RequisitionList" property="StockTransfor.requisition" id=""
	        				ng-model="StockTransfor.requisition" name="requisition" form-name = "ondutyrequestForm"
	        				validation="required" friendly-name="Requisition No"></selectivity> -->


														<select class="form-control input-sm"
															ng-model="StockTransfor.requisition"
															name="Requisition Location" data-valid-method="submit"
															ng-change="requistiononchange(StockTransfor.requisition)"
															data-message-id="Requisition Id" ng-disabled="true"
															ng-options="c.id as c.text for c in RequisitionList">
															<option value="">Select</option>

														</select>


													</div>
												</div>

												<div class="form-group" ng-if="materialIssueflag">
													<label class="col-md-4 control-label">Requisition
														Date</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="Requisition Date"
															ng-model="StockTransfor.requisitionDate"
															id="requisitiondate" readonly>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Requested By</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="Requisition Date"
															ng-model="StockTransfor.requisitionBy" id="requisitionBy"
															readonly>



													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Delivery
														Method <span style = "color:red">*</span>
													</label>
													<div class="col-md-7">
														<selectivity list="Delivery"
															property="StockTransfor.deliveryMet" id=""
															ng-model="StockTransfor.deliveryMet" name="deliveryMet"
															form-name="ondutyrequestForm" validation="required"
															friendly-name="Delivery Method" disabled="true"></selectivity>

														<!-- 	<select class="form-control input-sm"
														ng-model="StockTransfor.deliveryMet"
														name="Requisition Location"
														data-valid-method="submit"
														data-message-id="Delivery Method"
														ng-options="c.id as c.name for c in Delivery">
														<option value="">Select</option>

													</select>
													 -->
													</div>
												</div>




												<div class="form-group">
													<label class="col-md-4 control-label"> Status </label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="Requisition Date" ng-model="StockTransfor.status"
															id="requisitionBy" readonly>
													</div>
												</div>
												<div class="form-group">

													<label class="col-md-4 control-label"> Issue Slip<label />
													</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															ng-model="StockTransfor.issueSlip" name="Issue Slip"
															id="issueSlip" readonly />
													</div>
												</div>

											</div>
										</fieldset>
									</div>
								</div>

								<br> <br>

								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<br>
										<div role="content">
											<div class="widget-body no-padding">
												<div
													class=" form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
													data-st-table="displayedCollection"
													data-st-safe-src="rowCollection">
													<!-- 			        <div class="dt-toolbar" -->
													<!-- 			         data-smart-include="views/layout/toolbar-header.tpl"></div> -->

													<table id="dt_basic"
														class="table table-striped table-bordered table-hover dataTable no-footer"
														role="grid" aria-describedby="dt_basic_info">
														<thead class="dataTables-Main-Head">
															<tr>
																<th class="width_1 text-center table-heading">
																	<!-- <label class="i-checks m-b-none">
		            												 <input type="checkbox">
		           													  <i></i>
		           												 </label> -->
																</th>
																<th class="sorting width_10" data-st-sort="">Item
																	Code - Item Name</th>

																<th class="sorting width_10" data-st-sort=""
																	data-ng-if="!materialIssueflag">Requisition
																	Number</th>

																<!-- <th class="sorting width_7" data-st-sort="">Item Name</th> -->
																<th class="sorting width_10" data-st-sort="">Item
																	Description</th>

																<th class="sorting width_7" data-st-sort="">Unit Of
																	Measurement</th>
																<th class="sorting width_7" data-st-sort="">PR
																	 Original Quantity</th>
																	<th class="sorting width_7" data-st-sort="">PR
																	Quantity</th>
																<th class="sorting width_7" data-st-sort="">Quantity</th>
																<!--  <th class="table-heading width_5" >Batch No</th> -->
															</tr>
															<tr
																ng-repeat="(trIndex, row) in StockTransfor.rowCollection"
																ng-controller="stockTransferItemCtrl">
																<td colspan=1 class="width_1"></td>
																<td colspan=1 class="width_1"
																	data-ng-if="materialIssueflag"><selectivity
																		list="ItemList" property="row.itemCode" id=""
																		ng-model="row.itemCode" name="{{ 'Item' + trIndex }}"
																		form-name="ondutyrequestForm" validation="required"
																		friendly-name="{{ 'Row' + (trIndex+1) + '(Item Code)'}}"
																		disabled="true"></selectivity> <!-- <select
												class="form-control input-sm" ng-model="row.itemCode"
												name="Destination Location"
												ng-options="c.id as c.name for c in ItemList"
												ng-change="itemCodeChange(row.itemCode,row)">
													<option value="">Select</option>

											</select> --></td>
																<td colspan=1 class="width_1"
																	data-ng-if="!materialIssueflag"><span>{{row.itemName}}</span>
																	<!-- <select
												
												class="form-control input-sm" ng-model="row.itemCode"
												name="Destination Location"
												ng-options="c.id as c.name for c in ItemList"
												ng-change="itemCodeChange(row.itemCode,row)">
													<option value="">Select</option>

											</select> --></td>

																<!-- <td colspan=1 class="width_1"><input type="text"
												ng-model="row.itemName" class="form-control input-sm"></td> -->

																<td colspan=1 class="width_1" ng-if="!materialIssueflag"><input
																	type="text" ng-model="row.requestNumber"
																	class="form-control input-sm"
																	name="{{ 'requestNumber' + trIndex  }}"
																	validation="required"
																	friendly-name="{{ 'Row' + (trIndex+1) + '(requestNumber)'}}"
																	readonly></td>
																<td colspan=1 class="width_1" title={{row.itemDesc}}><input
																	type="text" ng-model="row.itemDesc"
																	class="form-control input-sm"
																	name="{{ 'Item Description' + trIndex  }}"
																	friendly-name="{{ 'Row' + (trIndex+1) + '(Item Description)'}}"
																	readonly></td>
																<td colspan=1 class="width_1"><input type="text"
																	ng-model="row.uom" class="form-control input-sm"
																	readonly></td>

																<td colspan=1 class="width_1"><input type="text"
																	ng-model="row.originalQty" class="form-control input-sm"
																	name="{{ 'originalQty' + trIndex  }}"
																	validation="required"
																	friendly-name="{{ 'Row' + (trIndex+1) + '(PRBalanceQuantity)'}}"
																	ng-pattern-restrict="^[0-9.]*$" readonly></td>
																<td colspan=1 class="width_1"><input type="text"
																	ng-model="row.prquantity" class="form-control input-sm"
																	name="{{ 'prquantity' + trIndex  }}"
																	validation="required"
																	friendly-name="{{ 'Row' + (trIndex+1) + '(PRQuantity)'}}"
																	ng-pattern-restrict="^[0-9.]*$" readonly></td>

																<td colspan=1 class="width_1"><input type="text"
																	ng-model="row.quantity" class="form-control input-sm"
																	name="{{ 'quatity' + trIndex  }}" validation="required"
																	ng-pattern-restrict="^[0-9.]*$"
																	friendly-name="{{ 'Row' + (trIndex+1) + '(Quantity)'}}"
																	readonly></td>
																<!-- <td class="width_5" ng-show="row.batchNoExist==true">
												<label class="col-xs-12" data-ng-click="getBatchDetailsView(trIndex,row.itemCode)">
													<span class="fa fa-plus"></span>
												</label>
											</td> -->

															</tr>
													</table>


												</div>

											</div>
										</div>
									</div>
								</div>


								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<%-- <button class="btn btn-success" type="button"
												ng-if="!edit"
												data-ng-click="save(ondutyrequestForm,StockTransfor)">
												<i class="fa fa-save"></i>
												<spring:message code="label.save"></spring:message>
											</button>
											<button class="btn btn-success" type="button"
												ng-if="edit"
												data-ng-click="update(ondutyrequestForm,StockTransfor);" ng-hide="status=='Approved'">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>
											<button class="btn btn-info" type="button"
												ng-if="!edit" data-ng-click="reset();" >
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-info" type="button"
												ng-if="edit" data-ng-click="reset1();">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button> --%>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel1();">
												<i class="fa fa-close"></i>Cancel
											</button>
											<!-- <button class="btn btn-danger" type="button"
class="btn btn-success" data-ng-click="back();">
<i class="fa fa-backward"></i> Back
</button> -->
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