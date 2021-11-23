<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
							<form class="form-horizontal" name="manageItemAddForm" novalidate>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-md-6 ">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label"> Item Type <span style="color:red";>*</span></label>
													<div class="col-md-7">
														<%--  <select class="form-control"
															name="<spring:message code="label.itemType"></spring:message>"
															data-ng-model="manageItemObj.itemTypeId"
															data-ng-change="onchangeItemCategoryList(manageItemObj.itemTypeId)"
															data-ng-options="obj.defTableId as obj.text for obj in itemTypeList" validation="required" id= "obj.value" friendly-name="Item Type">
															<option value="" selected="selected">Select</option>
														</select> --%>
														<selectivity list="itemTypeList" 
											               property="manageItemObj.itemTypeId" id="itemTypeId"
											               data-ng-model="manageItemObj.itemTypeId"  data-ng-change="onchangeItemCategoryList(manageItemObj.itemTypeId)"
											               name="itemTypeId" form-name = "manageItemAddForm" 
											                     validation="required"
											                      friendly-name="Item Type"></selectivity> 
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Item Name <span style="color:red";>*</span></label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"  maxlength="30"
															name="Item Name"
															id="itemName" data-ng-model="manageItemObj.itemName" ng-blur="checkItemName(manageItemObj.itemName)"
															validation="required" friendly-name="ItemName">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Item Description
													</label>
													<div class="col-md-7">
														<textarea class="form-control input-sm" rows="2" cols="25" maxlength="50"
															name="Item Description"
															data-ng-model="manageItemObj.itemDescription"
															style="resize: none"></textarea>
													</div>
												</div>
														<div class="form-group">
													<label class="col-md-3 control-label"><label>
															Default Rate</label>
													</label>
													<div class="col-md-7">
														<input class="form-control input-sm" rows="2" cols="25" maxlength="50"
															name="manageItemObj.defaultrate"
															data-ng-model="manageItemObj.defaultrate"
															style="resize: none"/>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"><label>
															Opening Quantity</label>
													</label>
													<div class="col-md-7">
														<input class="form-control input-sm"  style="text-align: right;"
															name="manageItemObj.openingQty"
															data-ng-model="manageItemObj.openingQty"
															ng-pattern-restrict="^[0-9.]*$"
															/>
													</div>
												</div>
											</fieldset>
										</div>
										<div class="col-sm-6 col-md-3 col-lg-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label">Item Code<span style="color:red";>*</span></label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="itemCode" id="itemCode" ng-blur="checkItemCode(manageItemObj.itemCode)"
															data-ng-model="manageItemObj.itemCode" maxlength="10"
															validation="required" friendly-name="itemCode">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Item Category  
															<span style="color:red";>*</span>
															</label>
													<div class="col-md-7">
											              <selectivity list="categoryList" ng-if="!manageItemObj.isEditCate"
											               property="manageItemObj.itemCategoryId" id="itemCategoryId"
											               data-ng-model="manageItemObj.itemCategoryId" 
											               name="itemCategoryId" form-name = "manageItemAddForm" disabled="true"
											                     validation="required" friendly-name="Item Category"></selectivity>
											              <selectivity list="categoryList" ng-if="manageItemObj.isEditCate"
											               property="manageItemObj.itemCategoryId" id="itemCategoryId"
											               data-ng-model="manageItemObj.itemCategoryId" 
											               name="itemCategoryId" form-name = "manageItemAddForm" 
											                     validation="required" friendly-name="Item Category"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Saleable
<%-- 															<spring:message code="label.asterisk.symbol"> </spring:message> --%>
															</label>
													<div class="col-md-2">
														<div class="checkbox">
															<label> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="manageItemObj.saleable"> <span></span>
															</label>
														</div>
													</div>
														<label  class="col-md-2" style="height: 15px;margin-top: 8px;"> Purchaseable
<%-- 															<spring:message code="label.asterisk.symbol"> </spring:message> --%>
															</label>
															
															<!-- 
													<div class="col-md-6"> 
														<div class="checkbox"> -->
															<label style="margin-top: 5px;"> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="manageItemObj.purchaseable"> <span></span>
															</label>
														<!-- </div>
													</div>  -->
												</div>
												<%-- <div class="form-group">
													<label class="col-md-3 control-label"> <spring:message
															code="label.manageitem.purchasable"></spring:message>
															<spring:message code="label.asterisk.symbol"> </spring:message>
															</label>
													<div class="col-md-6">
														<div class="checkbox">
															<label> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="manageItemObj.purchaseable"> <span></span>
															</label>
														</div>
													</div>
												</div> --%>
														<div class="form-group">
													<label class="col-md-3 control-label"> <label>
															 Auto Issue</label>
<%-- 															<spring:message code="label.asterisk.symbol"> </spring:message> --%>
															</label>
													<div class="col-md-2">
														<div class="checkbox">
															<label> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="manageItemObj.isAutoIssue"> <span></span>
															</label>
														</div>
													</div>
													
													
													<label class="col-md-2" style="height: 15px;margin-top: 8px;">Service Type
<%-- 															<spring:message code="label.asterisk.symbol"> </spring:message> --%>
															</label>
															
															<!-- 
													<div class="col-md-6"> 
														<div class="checkbox"> -->
															<label style="margin-top: 10px;">
															 <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="manageItemObj.isServiceType"> <span></span>
															</label>
														<!-- </div>
													</div>  -->
												</div>
													
													
													
													
													
													
													
													
													
													
													
													
													<%-- <div class="form-group">
													<label class="col-md-3 control-label">Tax<spring:message
															code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="tax" id="tax" 
															data-ng-model="manageItemObj.tax" maxlength="10"
															validation="required" friendly-name="tax">
													</div>
												</div> --%>
												<div class="form-group">
													<label class="col-md-3 control-label" style="color: black">
															Tax (%) :</label>
													
												<!-- 	<div class="col-md-7">
														<input class="form-control input-sm" rows="2" cols="25" maxlength="50"
															name="manageItemObj.tax"
															data-ng-model="manageItemObj.tax"
															style="resize: none"/> -->
													</div>
												</div>
															<label class="col-md-7 control-label"> CGST: </label>
        				                            <div class="col-md-1">
							                       <input type="text" class="form-control input-sm"  ng-model="manageItemObj.cgst" style="text-align: right;padding-right: 0;">
						                         </div>
						                         <label class="col-md-1 control-label"> SGST: </label>
        				                            <div class="col-md-1">
							                       <input type="text" class="form-control input-sm"  ng-model="manageItemObj.sgst" style="text-align: right;padding-right: 0;">
						                         </div>
						                         <label class="col-md-1 control-label"> IGST: </label>
        				                            <div class="col-md-1">
							                       <input type="text" class="form-control input-sm"  ng-model="manageItemObj.igst" style="text-align: right;padding-right: 0;">
						                         </div>
											</fieldset>
										</div>
									</div>
								</div>
								<tabset> <tab heading="Information"> <br>
								<div class="row">
									<div data-ng-show="manageItemObj.saleable">
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<fieldset>
													<div class="form-group" style="padding-left: 110px">
														<label class="bold">Sales</label>
													</div>
												</fieldset>
											</div>
										</div>
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-3 control-label"> Costing Method <span style="color:red";> * </span></label>
													<div class="col-md-7">
														<select class="form-control" ng-if="manageItemObj.saleable"
															name="Costing Method"
															data-message-id="Costing Method"
															data-ng-model="manageItemObj.costingId"
															data-ng-options="obj.defTableId as obj.text for obj in costingList" validation="required"  friendly-name="Costing Method">
															<option value="" selected="selected">Select</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Warranty <span style="color:red";> * </span></label>
													<div class="col-md-7">
														<input type="text"ng-if="manageItemObj.saleable"
															class="form-control input-sm text-right" name="warranty"
															id="warranty" data-ng-model="manageItemObj.warranty"
															placeholder=0  validation="required" friendly-name="Warranty"
															phonenumbers-only>
													</div>
													<span class="pull-left line-height-30">Days</span>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-3 control-label">Cost Price <span style="color:red";> *</span></label>
													<div class="col-md-7">
														<input type="text" ng-if="manageItemObj.saleable"
															class="form-control input-sm text-right" name="costPrice"
															id="costPrice" data-ng-model="manageItemObj.costPrice"
															ng-change="checkCostPriceDigits(manageItemObj.costPrice)"
															 placeholder=0.00  validation="required" friendly-name="Cost Price">
													</div>
													 <span class="pull-left line-height-30">Rs</span> 
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Lead Time <span style="color:red";> * </span></label>
													<div class="col-md-7">
														<input type="text" ng-if="manageItemObj.saleable"
															class="form-control input-sm text-right" name="leadTime"
															id="leadTime" data-ng-model="manageItemObj.leadTime"
														    placeholder=0  validation="required"  friendly-name="Lead Time"
															phonenumbers-only>
													</div>
													<span class="pull-left line-height-30">Days</span>
												</div>
											</div>
										</div>
									</div>
									<div data-ng-show="manageItemObj.purchaseable">
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<fieldset>
													<div class="form-group padder-v"
														style="padding-left: 110px">
														<label class="bold">Purchase</label>
													</div>
												</fieldset>
											</div>
										</div>
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-3 control-label"> Purchase Method</label>
													<div class="col-md-7">
														<select class="form-control" ng-if="manageItemObj.purchaseable"
															name="purchaseMethod"
															data-message-id="Department Name"
															data-ng-model="manageItemObj.purchaseId"
															data-ng-options="obj.id as obj.text for obj in purchaseList"
															 friendly-name="Purchase Method" 
															 form-name = "manageItemAddForm"
															 data-valid-method="submit">
															<option value="" selected="selected">Select</option>

														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Purchase UOM <span style="color:red";> * </span></label>
													<div class="col-md-7">
														<select class="form-control" ng-if="manageItemObj.purchaseable"
															name="purchaseable"
															data-message-id="Department Name"
															data-ng-model="manageItemObj.uomId" ng-change="getUOMCategoryBasedList(manageItemObj.uomId)"
															data-ng-options="objUom.id as objUom.text for objUom in uomCategoryList"
															validation="required"  friendly-name="Purchase UOM" 
															data-valid-method="submit"
															form-name = "manageItemAddForm" >
															<option value="" selected="selected">Select</option>
														</select>
													</div>
												</div>
												
												
												<div class="form-group">
													<label class="col-md-3 control-label"> Alternate UOM</label>
													<div class="col-md-7">
														<select class="form-control" ng-if="manageItemObj.purchaseable"
															name="alt qty" data-message-id="altuom"
															data-ng-model="manageItemObj.altuom"
															data-ng-options="objUom.id as objUom.text for objUom in uomCategoryList"
															validation="required"  friendly-name="Alternate UOM" 
															data-valid-method="submit"
															form-name = "manageItemAddForm" >
															<option value="" selected="selected">Select</option>
														</select>
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-md-3 control-label">Alternate Quantity</label>
													<div class="col-md-7">
														<input type="text"
															class="form-control input-sm text-right"
															name="altQty" id="altQty"
															data-ng-model="manageItemObj.altqty" placeholder=0
															 phonenumbers-only>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Minimum Quantity</label>
													<div class="col-md-7">
														<input type="text"
															class="form-control input-sm text-right"
															name="minQuantity" id="minQuantity" placeholder=0
															data-ng-model="manageItemObj.minQuantity" phonenumbers-only>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-3 control-label"> Purchase Requisition
													</label>
													<div class="col-md-7">
														<div class="checkbox">
															<label> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="manageItemObj.requestable"> <span></span>
															</label>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> Reorder Level 
															 <span style = "color:red";> *</span>
															</label>
													<div class="col-md-7" data-ng-if="manageItemObj.purchaseable">
														<input type="text"
															class="form-control input-sm text-right" placeholder=0
															id="reorderLevel" name="reorderLevel"
															
															data-ng-model="manageItemObj.reorderLevel" phonenumbers-only>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Maximum Quantity</label>
													<div class="col-md-7">
														<input type="text"
															class="form-control input-sm text-right"
															name="maxQuantity" id="maxQuantity"
															data-ng-model="manageItemObj.maxQuantity" placeholder=0
															 phonenumbers-only>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								</tab> <tab heading="Specification"> <br>
								<div class="row">
									<div class="col-lg-12">
										<div ng-repeat="(trsindex,row) in specificationDetails">
											<div class="col-sm-10 col-md-5">
												<fieldset>
													<input type="hidden" class="form-control input-sm"
														data-ng-model="manageItemObj.specificationList[trsindex].attributevalue"
														data-valid-method="submit">
													<div class="form-group">
														<label class="col-md-6 control-label">{{row.labelName}}
														</label>
														<div class="col-md-6" ng-if="row.typeinput == 'Text'">
															<input type="text" class="form-control input-sm"
																data-ng-model="manageItemObj.specificationList[trsindex].attributevalue"
																data-valid-method="submit">
														</div>
														<div class="col-md-6" ng-if="row.typeinput == 'DropDown'">
															<select class="form-control input-sm"
																data-ng-model="manageItemObj.specificationList[trsindex].attributevalue">
																<option value="">Select</option>
																<option
																	ng-repeat="(trsdindex,defaultvalue) in row.defaultvalue"
																	value={{defaultvalue}}>{{defaultvalue}}</option>
															</select>

														</div>
														<div class="col-md-6" ng-if="row.typeinput == 'Text Area'">
															<textarea class="form-control input-sm"
																data-ng-model="manageItemObj.specificationList[trsindex].attributevalue"></textarea>
														</div>
														<div class="col-md-6" ng-if="row.typeinput == 'CheckBox'"
															ng-repeat="(trsdindex,defaultvalue) in row.defaultvalue">


															<input type="checkbox" id="checkbox{{trsdindex}}"
																data-ng-model="attributevalue[trsdindex]"
																data-valid-method="submit" value={{defaultvalue}}
																ng-click="checkdata(attributevalue[trsdindex],trsindex,trsdindex,defaultvalue)">{{defaultvalue}}
														</div>
														<div class="col-md-6"
															ng-if="row.typeinput == 'Radio Button'"
															ng-repeat="(trsdindex,defaultvalue) in row.defaultvalue">
															<input type="radio"
																data-ng-model="manageItemObj.specificationList[trsindex].attributevalue"
																value="{{defaultvalue}}"> {{defaultvalue}}
														</div>
														<div class="col-md-6" ng-if="row.typeinput == 'Number'">
															<input type="Number" class="form-control input-sm"
																data-ng-model="manageItemObj.specificationList[trsindex].attributevalue"
																data-valid-method="submit">
														</div>
													</div>
												</fieldset>
											</div>
										</div>
									</div>
								</div>
								</tab> <tab heading="Vendor"> <br>

								<div class=""
									data-ng-repeat="(tIndex, table) in manageItemObj.tables">
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>
									            <th class="width_1 table-heading text-center">
									            <label class="i-checks m-b-none">
									             <input type="checkbox"  ng-model="selectedAll" ng-change="checkAllVendor(manageItemObj.tables,selectedAll)">
									             <i></i>
									            </label>
									           </th>
												<th
													class="text-center table-heading padding-both-side-2 width_7">Vendor</th>
												<th
													class="text-center table-heading padding-both-side-2 width_7">Vendor
													Item Name</th>
												<th
													class="text-center table-heading padding-both-side-2 width_7">Vendor
													Item Code</th>
												<th
													class="text-center table-heading padding-both-side-2 width_7">Minimum
													Quantity</th>
												<th
													class="text-center table-heading padding-both-side-2 width_7">Vendor
													Uom</th>
												<th
													class="text-center table-heading padding-both-side-2 width_7">Delivery
													Lead Time</th>
												<th
													class="text-center table-heading padding-both-side-2 width_7">Pricing
													Type</th>

											</tr>
										</thead>
										<tbody data-ng-repeat="(trIndex, row) in table.row" ng-controller="parentCtrl">
											<tr>
												<td class="width_1 text-center">
									           <label class="i-checks m-b-none">
									             <input type="checkbox" ng-model="row.tableId">
									             <i style="left: -5px !important;"></i>
									            </label></td>
												<td class="padding-both-side-2"><!-- <select
													class="form-control" data-ng-model="row.entityId"
													data-ng-options="obj.entityId as obj.entityName for obj in entityList">
														<option value="" selected="selected">Select</option>
												</select> -->
												<selectivity list="entityList" class="grid-small-select"
															property="row.entityId"
															></selectivity>
												</td>
												<td class="padding-both-side-2"><input type="text"
													class="form-control input-sm" id="vendorProductCode"
													data-ng-model="row.vendorItemName"></td>

												<td class="padding-both-side-2"><input type="text"
													class="form-control input-sm" id="vendorProductCode"
													data-ng-model="row.vendorItemCode"></td>
												<td class="padding-both-side-2"><input type="text"
													class="form-control input-sm text-right"
													id="vendorProductCode" placeholder=0
													data-ng-model="row.vendorMinimumQuantity" phonenumbers-only></td>
												<td class="padding-both-side-2"><select
													class="form-control" name="uomName"
													data-ng-model="row.vendorUom"
													data-ng-options="objUom.id as objUom.text for objUom in uomList"
													data-validator="required" data-valid-method="submit">
														<option value="" selected="selected">Select</option>
												</select></td>
												<td class="padding-both-side-2">
													<!-- <input type="text"
													class="form-control input-sm text-right" id="vendorLeadTime" placeholder=0
													data-ng-model="row.vendorLeadTime"> -->
													<div class="form-group">
														<div class="col-md-8">
															<input type="text"
																class="form-control input-sm text-right" placeholder=0
																id="vendorLeadTime" name="vendorLeadTime"
																 friendly-name="Reorder Level"
																data-ng-model="row.vendorLeadTime" phonenumbers-only>
														</div>
														<label class="control-label">Days</label>
													</div>
												</td>

												<td class="padding-both-side-2"><select
													class="form-control" data-ng-model="row.pricingType"
													data-ng-options="obj.id as obj.text for obj in pricingTypeList">
														<option value="" selected="selected">Select</option>

												</select></td>


											</tr>
										</tbody>
									</table>
									<button data-ng-click="addRow(table)" class="btn btn-primary"
										type="button">
										<i class="fa fa-plus"></i> Add Row
									</button>
									<button data-ng-click="removeRowForm(table)"
										class="btn btn-danger" type="button">
										<i class="fa fa-trash-o"></i> Delete Row
									</button>


								</div>

								</tab> <tab heading="Inventory"> <br>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-3 control-label">Inventory Valuation<span style="color:red";>*</span></label>
												<div class="col-md-7" data-ng-show="InventoryNone">
													<select class="form-control"
														name="inventoryValuation"
														data-ng-model="manageItemObj.inventoryValuationId"
														data-ng-options="obj.id as obj.text for obj in inventoryValuvationList"
														validation="required" friendly-name="Inventory Valuvation in Inventory tab">
														<option value="" selected="selected">Select</option>
													</select>
												</div>
												<div class="col-md-7" data-ng-show="InventoryNone1">
													<select class="form-control"
														name="inventoryValuation"
														data-ng-model="manageItemObj.inventoryValuationId"
														data-ng-options="obj.id as obj.text for obj in inventoryValuvationList"
														data-ng-disabled=true>
														<option value="" selected="selected">Select</option>

													</select>
												</div>

											</div>

											<div class="form-group" ng-hide="outgoing">
												<label class="col-md-3 control-label">Incoming Quantity</label>
												<div class="col-md-7">
													<label>{{manageItemObj.incoming}}</label>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-3 control-label">Issue Method <span style="color:red";>*</span></label>
												<div class="col-md-7">
													<select class="form-control"
														name="issueMethod"
														data-ng-model="manageItemObj.issueId"
														data-ng-options="obj.id as obj.text for obj in issueList"
														 validation="required" friendly-name="Issue Method in Inventory tab">
														<option value="" selected="selected">Select</option>

													</select>
												</div>
											</div>
											<div class="form-group" ng-hide="outgoing">
												<label class="col-md-3 control-label">Outgoing Quantity</label>
												<div class="col-md-7">
													<label>{{manageItemObj.outgoing}}</label>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row" ng-hide="outgoing">
									<div id="content">
										<section data-widget-grid id="widget-grid">
											<div class="row">
												<article class="col-sm-12">
													<div data-jarvis-widget id="standard-datatable-widget">
														<header>
															<div class="widget-toolbar"></div>
														</header>
														<div role="content">
															<div class="widget-body no-padding">
																<div
																	class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
																	data-st-table="displayedCollection1"
																	data-st-safe-src="rowCollection1">
																	<table id="dt_basic"
																		class="table table-striped table-bordered table-hover dataTable no-footer"
																		role="grid" aria-describedby="dt_basic_info">
																		<thead class="dataTables-Main-Head">
																			<tr>
																				<th class="width_1 text-center table-heading"><label
																					class="i-checks m-b-none"> <input
																						type="checkbox"> <i></i>
																				</label></th>
																				<th class="sorting width_5">Location
																				</th>
																				<th class="sorting width_5" data-st-sort="itemName"> Quantity On Location
																				</th>

																			</tr>
																		</thead>
																		<tbody class="dataTables-Main-Body">
																			<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																				data-ng-repeat="objManageItemCategory in displayedCollection1">
																				<td data-cs-select="objManageItemCategory"></td>
																				<td>{{objManageItemCategory.locationName}}</td>
																				<td>{{objManageItemCategory.qty}}</td>
																			</tr>
																		</tbody>
																	</table>
																	<div class="dt-toolbar-footer"
																		data-smart-include="views/layout/toolbar-footer.tpl"></div>
																</div>
															</div>
															<!-- end widget content -->
														</div>
														<!-- end widget div -->
													</div>
													<!-- end widget -->
												</article>
												<!-- WIDGET END -->
											</div>
											<br>
										</section>
									</div>
								</div>
								<div class="row">
									<div class="padding-left-50 padding-top-5" id="jqgrid">
										<div id="inventGrid">
											<table id="grid"></table>
											<div id="inventorypage"></div>
										</div>
									</div>
								</div>
								</tab> <!-- <tab heading="GRN Attribute"> <br>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-4 control-label">Batch No</label>
												<div class="col-md-7">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="manageItemObj.isBatch"> <span></span>
														</label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">MRP</label>
												<div class="col-md-7">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="manageItemObj.isMrp"> <span></span>
														</label>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-4 control-label">Expiry Date</label>
												<div class="col-md-7">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="manageItemObj.isExpiry"><span></span>
														</label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Manufacture
													Details</label>
												<div class="col-md-7">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="manageItemObj.isManfactureDetails">
															<span></span>
														</label>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								</tab>  -->
								<tab heading="GRN Attribute"> <br>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="col-sm-4 col-md-4 col-lg-4 form-group">
												<div class="col-md-2">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="manageItemObj.isBatch"> <span></span>
														</label>
													</div>
												</div>
												<label class="col-md-7 control-label">Batch No</label>
											</div>
											
											
											
											<div class="col-sm-3 col-md-3 col-lg-3 form-group">
												<div class="col-md-2">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="manageItemObj.isMrp"> <span></span>
														</label>
													</div>
												</div>
												<label class="col-md-3 control-label">MRP</label>
											</div>
										</div>
										
										
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="col-sm-4 col-md-4 col-lg-4 form-group">
												<div class="col-md-2">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="manageItemObj.isExpiry"><span></span>
														</label>
													</div>
												</div>
												<label class="col-md-9 control-label">Expiry Date</label>
											</div>
											
											
											<div class="col-sm-6 col-md-6 col-lg-6 form-group">
												<div class="col-md-2">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															data-ng-model="manageItemObj.isManfactureDetails">
															<span></span>
														</label>
													</div>
												</div>
                                              <label class="col-md-12 control-label" style="
                                              margin-top: -22px;
                                                 margin-left: 27px;
                                          ">Manufacture Details</label>											
                                          </div>
										</div>
									</div>
								</div>
								</tab> 
								<tab heading="Consumption Pattern" ng-show=consumPattern> <br>
									<div class="form-group">
									<label class="col-md-2 control-label"> Rate of Consumption </label>
									<div class="col-md-6">
										<div class="radio">
											<label class="i-checks"> <input type="radio"
												class="radiobox style-0" checked="checked" name="wardType"
												id="thirty" ng_model="manageItemObj.rdoDays" data-ng-change="onValueChange(manageItemObj.rdoDays)" value="30"
												data-ng-true-value="'YES'" data-ng-false-value="'NO'">
												<i></i> 30 Days
											</label> <label class="i-checks"> <input type="radio"
												class="radiobox style-0" checked="checked" name="wardType"
												id="sixty" ng_model="manageItemObj.rdoDays" value="60" data-ng-change="onValueChange(manageItemObj.rdoDays)"
												data-ng-true-value="'NO'" data-ng-false-value="'YES'">
												<i></i> 60 Days
											</label> <label class="i-checks"> <input type="radio"
												class="radiobox style-0" checked="checked" name="wardType"
												id="ninty" ng_model="manageItemObj.rdoDays" value="90" data-ng-change="onValueChange(manageItemObj.rdoDays)"
												data-ng-true-value="'NO'" data-ng-false-value="'YES'">
												<i></i> 90 Days
											</label>
										</div>
									</div>
									</div>
									<div class="row">
										<highchart id="chart" config="chartConfig" style="width:1156px;height:400px;"></highchart>
										<!-- style="width:1156px;height:400px;" -->
									</div>
								</tab>
						</tabset>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success"
												data-ng-if="manageItemObjValidate.isEdit" type="button"
												data-ng-click="submit(manageItemAddForm,manageItemObj)">
												<i class="fa fa-save"></i>
												Save
											</button>
											<button class="btn btn-success"
												data-ng-if="!manageItemObjValidate.isEdit" type="button"
												data-ng-click="update(manageItemObj)">
												<i class="fa fa-save"></i>
Update											</button>
											<button class="btn btn-info ng-scope" type="button"
												data-ng-click="reset()"
												class="btn btn-success">
												<i class="fa fa-undo"></i>
Reset											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancelItem()">
												<i class="fa fa-close"></i>
Cancel											</button>
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