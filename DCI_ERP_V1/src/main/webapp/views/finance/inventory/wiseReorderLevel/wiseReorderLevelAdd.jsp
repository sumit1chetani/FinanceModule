<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i></span> <span><state-breadcrumbs></state-breadcrumbs>
						</span>
						<div class="widget-toolbar">
							<div>
								<span> <span class="button-icon" data-placement="bottom"
									data-reset-widgets rel="tooltip"
									title="<spring:message code='title.widget.reset'></spring:message>">
										<i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="itemWiseVendorMappingAddForm" novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-md-6 ">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label"> <spring:message
															code="label.manageitem.itemType"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<select class="form-control"
															name="itemTypeId" id="itemTypeId"
															data-ng-model="manageItemObj.itemTypeId"
															data-ng-change="onchangeItemCategoryList(manageItemObj.itemTypeId)" validation="required" friendly-name="Item Type"
															data-ng-options="obj.defTableId as obj.value for obj in itemTypeList">
															<option value="" selected="selected">Select</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"><spring:message
															code="label.manageitem.itemName"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="itemName" id="itemName" 
															data-ng-model="manageItemObj.itemName"
 															validation="required" friendly-name="Item Name">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"><spring:message
															code="label.manageitem.itemDescription"></spring:message>
													</label>
													<div class="col-md-7">
														<textarea class="form-control input-sm" rows="2" cols="25"
															name="<spring:message code="label.itemDescription"></spring:message>"
															data-ng-model="manageItemObj.itemDescription"
															style="resize: none"></textarea>
													</div>
												</div>
											</fieldset>
										</div>
										<div class="col-sm-6 col-md-3 col-lg-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label"><spring:message
															code="label.manageitem.partNo"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="itemCode" id="itemCode" 
															data-ng-model="manageItemObj.itemCode" validation="required" friendly-name="Item Code">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> <spring:message
															code="label.manageitem.itemCategory"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<select class="form-control"
															name="itemCategoryId" id="itemCategoryId"
															data-ng-model="manageItemObj.itemCategoryId" validation="required" friendly-name="Item Category"
															data-ng-options="objCatgory.id  as objCatgory.text for objCatgory in categoryList"
															data-ng-change="getSpecification(manageItemObj.itemCategoryId)">
															<option value="" selected="selected">Select</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> <spring:message
															code="label.manageitem.salable"></spring:message></label>
													<div class="col-md-6">
														<div class="checkbox">
															<label> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="manageItemObj.saleable"> <span></span>
															</label>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> <spring:message
															code="label.manageitem.purchasable"></spring:message></label>
													<div class="col-md-6">
														<div class="checkbox">
															<label> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="manageItemObj.purchaseable"> <span></span>
															</label>
														</div>
													</div>
												</div>

											</fieldset>
										</div>
									</div>
								</div>
								<tabset>
								<tab heading="Information"> <br>
								<div class="row">
								<div data-ng-show="manageItemObj.saleable">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>
												<div class="form-group" style="padding-left: 110px">
													<label class="bold"><spring:message
															code="label.manageItem.sales"></spring:message></label>
												</div>
											</fieldset>
										</div>
									</div>
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-3 control-label"> <spring:message
														code="label.manageitem.costingMethod"></spring:message></label>
												<div class="col-md-7">
													<select class="form-control"
														name="<spring:message code="label.costingMethod"></spring:message>"
														data-message-id="Department Name"
														data-ng-model="manageItemObj.costingId"
														data-ng-options="obj.defTableId as obj.value for obj in costingList"
														data-validator="required" data-valid-method="submit">
														<option value="" selected="selected">Select</option>

													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label"><spring:message
														code="label.manageitem.warranty"></spring:message></label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm text-right"
														name="warranty"
														id="warranty" 
														data-ng-model="manageItemObj.warranty" placeholder=0
														 validation="numeric" friendly-name="Warranty">
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-3 control-label"><spring:message
														code="label.manageitem.costPrice"></spring:message></label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm text-right"
														name="costPrice"
														id="costPrice" 
														data-ng-model="manageItemObj.costPrice" placeholder=0.00
												 validation="numeric" friendly-name="Cost Price">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label"> <spring:message
														code="label.manageitem.leadTime"></spring:message></label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm text-right"
														name="leadTime"
														id="leadTime" 
														data-ng-model="manageItemObj.leadTime" placeholder=0.00
												 validation="numeric" friendly-name="Lead Time">
												</div>
											</div>
										</div>
									</div>
									</div>
									<div data-ng-show="manageItemObj.purchaseable">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>
												<div class="form-group padder-v" style="padding-left: 110px">
													<label class="bold"><spring:message
															code="label.manageItem.purchase"></spring:message></label>
												</div>
											</fieldset>
										</div>
									</div>
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-3 control-label"> <spring:message
														code="label.manageitem.purchaseMethod"></spring:message></label>
												<div class="col-md-7">
													<select class="form-control"
														name="<spring:message code="label.purchaseMethod"></spring:message>"
														data-message-id="Department Name"
														data-ng-model="manageItemObj.purchaseId"
														data-ng-options="obj.defTableId as obj.value for obj in purchaseList"
														data-validator="required" data-valid-method="submit">
														<option value="" selected="selected">Select</option>

													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label"> <spring:message
														code="label.manageitem.purchaseUOM"></spring:message></label>
												<div class="col-md-7">
													<select class="form-control"
														name="<spring:message code="label.purchaseUOM"></spring:message>"
														data-message-id="Department Name"
														data-ng-model="manageItemObj.uomId"
														data-ng-options="   objUom.uomId   as objUom.uom for objUom in uomList"
														data-validator="required" data-valid-method="submit">
														<option value="" selected="selected">Select</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label"><spring:message
														code="label.manageitem.minimumQty"></spring:message></label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm text-right"
														name="minQuantity"
														id="minQuantity"  placeholder=0.00  validation="numeric" friendly-name="Minimum Quantity"
														data-ng-model="manageItemObj.minQuantity"
														>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-3 control-label"> <spring:message
														code="label.manageitem.purchaseRequisition"></spring:message></label>
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
												<label class="col-md-3 control-label"> <spring:message
														code="label.manageitem.purchaseLevel"></spring:message></label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm text-right"
													 	placeholder=0 id="reorderLevel" name="reorderLevel"  validation="numeric" friendly-name="Reorder Level"
														data-ng-model="manageItemObj.reorderLevel">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-3 control-label"><spring:message
														code="label.manageitem.maximumQty"></spring:message></label>
												<div class="col-md-7">
													<input type="text" class="form-control input-sm text-right"
														name="maxQuantity"
														id="maxQuantity" data-ng-model="manageItemObj.maxQuantity"
														 placeholder=0 validation="numeric" friendly-name="Maximum Quantity"
														>
												</div>
											</div>
										</div>
									</div>
									</div>
								</div>
								</tab> 
								<tab heading="Specification"><br>
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
								</tab> 
								<tab heading="Vendor"> <br>
									<div class="" data-ng-repeat="(tIndex, table) in manageItemObj.tables"> 
									<div style=" height: 250px; overflow-y: auto;">
										<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>
												<th class="width_1 table-heading text-center"><label class="i-checks m-b-none">
									             <input type="checkbox"> <i></i>
									           </label></th>
												<th class="text-center table-heading padding-both-side-2 width_7">Vendor</th>
												<th class="text-center table-heading padding-both-side-2 width_7">Vendor
													Item Name</th>
												<th class="text-center table-heading padding-both-side-2 width_7">Vendor
													Item Code</th>
												<th class="text-center table-heading padding-both-side-2 width_7">Minimum
													Quantity</th>
												<th class="text-center table-heading padding-both-side-2 width_7">Vendor
													Uom</th>
												<th class="text-center table-heading padding-both-side-2 width_7">Delivery
													Lead Time</th>
												<th class="text-center table-heading padding-both-side-2 width_7">Pricing
													Type</th>

											</tr>
										</thead>
										<tbody data-ng-repeat="(trIndex, row) in table.row">
											<tr>
												<td><label class="i-checks m-b-none"> <input
														type="checkbox" data-ng-model="row.tableId"><i></i></label></td>
												<td class="padding-both-side-2"><select
													class="form-control" data-ng-model="row.entityId"
													data-ng-options="obj.entityId as obj.entityName for obj in entityList">
														<option value="" selected="selected">Select</option>
												</select></td>
												<td class="padding-both-side-2"><input type="text"
													class="form-control input-sm" id="vendorProductCode"
													data-ng-model="row.vendorItemName"></td>

												<td class="padding-both-side-2"><input type="text"
													class="form-control input-sm" id="vendorProductCode"
													data-ng-model="row.vendorItemCode"></td>
												<td class="padding-both-side-2"><input type="text"
													class="form-control input-sm text-right" id="vendorProductCode" placeholder=0
													data-ng-pattern="/[0-9]+(\.[0-9][0-9]?)?/"
													data-ng-model="row.vendorMinimumQuantity"></td>
												<td class="padding-both-side-2">
												<select class="form-control"
														name="uomName"
														data-ng-model="row.vendorUom"
														data-ng-options="objUom.uomId   as objUom.uom for objUom in uomList"
														data-validator="required" data-valid-method="submit">
														<option value="" selected="selected">Select</option>
													</select>
												
												</td>
												<td class="padding-both-side-2">
													<div class="form-group">
												<div class="col-md-8">
													<input type="text" class="form-control input-sm text-right"
													 	placeholder=0 id="vendorLeadTime" name="vendorLeadTime"  validation="numeric" friendly-name="Reorder Level"
														data-ng-model="row.vendorLeadTime">
														</div>
														<label class="control-label">Days</label>
												</div>
												</td>
												<td class="padding-both-side-2"><select
													class="form-control" data-ng-model="row.pricingType"
													data-ng-options="obj.defTableId as obj.value for obj in pricingTypeList">
														<option value="" selected="selected">Select</option>

												</select></td>
											</tr>
										</tbody>
									</table>
									</div>
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
											<div class="form-group"  >
												<label class="col-md-3 control-label"><spring:message
														code="label.manageitem.inventoryValuation"></spring:message></label>
												<div class="col-md-7" data-ng-show="InventoryNone">
													<select class="form-control"
														name="<spring:message code="label.inventoryValuation"></spring:message>"
														data-ng-model="manageItemObj.inventoryValuationId"
														data-ng-options="obj.defTableId as obj.value for obj in inventoryValuvationList"
														data-validator="required" data-valid-method="submit">
														<option value="" selected="selected">Select</option>

													</select>
												</div>
												<div class="col-md-7" data-ng-show="InventoryNone1">
													<select class="form-control"
														name="<spring:message code="label.inventoryValuation"></spring:message>"
														data-ng-model="manageItemObj.inventoryValuationId"
														data-ng-options="obj.defTableId as obj.value for obj in inventoryValuvationList"
														data-validator="required" data-valid-method="submit" data-ng-disabled=true>
														<option value="" selected="selected">Select</option>

													</select>
												</div>
												
											</div>

											<div class="form-group" ng-hide="outgoing">
												<label class="col-md-3 control-label"><spring:message
														code="label.manageitem.incoming"></spring:message></label>
												<div class="col-md-7">
													<label>{{manageItemObj.incoming}}</label>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-3 control-label"><spring:message
														code="label.manageitem.issueMethod"></spring:message></label>
												<div class="col-md-7">
													<select class="form-control"
														name="<spring:message code="label.issueMethod"></spring:message>"
														data-ng-model="manageItemObj.issueId"
														data-ng-options="obj.defTableId as obj.value for obj in issueList"
														data-validator="required" data-valid-method="submit">
														<option value="" selected="selected">Select</option>

													</select>
												</div>
											</div>
											<div class="form-group" ng-hide="outgoing">
												<label class="col-md-3 control-label"><spring:message
														code="label.manageitem.outgoing"></spring:message></label>
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
																				<th class="sorting width_5"><spring:message
																						code="label.manageitem.location"></spring:message>
																				</th>
																				<th class="sorting width_5" data-st-sort="itemName"><spring:message
																						code="label.manageitem.quantityOnLocation"></spring:message>
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
								</tab> 
								<tab heading="GRN Attribute"><br>
								<div class="row">
	        			<div class="col-sm-12 col-md-12 col-lg-12">
	        				<div class="col-sm-6 col-md-6 col-lg-6">
	        					<div class="form-group">
			             			<label class="col-md-4 control-label">Batch No</label>
			             				<div class="col-md-7">
			              					<div class="checkbox">
			               						<label>  <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="manageItemObj.isBatch">
			                				<span></span>
			               						</label>
			              					</div>
			             				</div>
			            		</div>
			            		<div class="form-group">
			             			<label class="col-md-4 control-label">MRP</label>
			             				<div class="col-md-7">
			              					<div class="checkbox">
			               						<label> <input type="checkbox" class="checkbox style-0"
			                						data-ng-model="manageItemObj.isMrp">
			                				<span></span>
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
			               						<label> <input type="checkbox" class="checkbox style-0"
			                						data-ng-model="manageItemObj.isExpiry">
			                				<span></span>
			               						</label>
			              					</div>
			             				</div>
			            		</div>
			            		<div class="form-group">
			             			<label class="col-md-4 control-label">Manufacture Details</label>
			             				<div class="col-md-7">
			              					<div class="checkbox">
			               						<label> <input type="checkbox" class="checkbox style-0"
			                						data-ng-model="manageItemObj.isManfactureDetails" >
			                				<span></span>
			               						</label>
			              					</div>
			             				</div>
			            		</div>
	        				</div>
	        			</div>
	        			</div>
	        		</tab>
								</tabset>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">


											<button class="btn btn-success"
												data-ng-if="manageItemObjValidate.isEdit" type="submit"
												data-ng-click="submit(itemWiseReorderLevelAddForm,manageItemObj)">
												<i class="fa fa-save"></i>
												<spring:message code="label.save"></spring:message>
											</button>

											<button class="btn btn-success"
												data-ng-if="!manageItemObjValidate.isEdit" type="submit"
												data-ng-click="update(manageItemObj)">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>
											<button class="btn btn-info ng-scope" type="submit"
												data-ng-click="reset(itemWiseReorderLevelAddForm)"
												class="btn btn-success">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancelItem()">
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