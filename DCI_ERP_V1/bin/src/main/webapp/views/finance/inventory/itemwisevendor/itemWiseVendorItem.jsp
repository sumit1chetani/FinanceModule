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
													<label class="col-md-3 control-label"><spring:message code="label.manageitem.itemName"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
													<div class="col-md-7">
														<select class="form-control"
															name="itemId" id="itemId" validation="required" friendly-name="Item Name"
															data-ng-model="itemWiseVendorMappingObj.itemId" 
															validation="required" friendly-name="Item Name" ng-change="getItemValues(itemWiseVendorMappingObj.itemId)"
															data-ng-options="obj.itemId as obj.itemName for obj in itemNameList">
															<option value="" selected="selected">Select</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> <spring:message code="label.manageitem.itemType"></spring:message></label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="itemTypeName" id="itemTypeName" 
															data-ng-model="itemWiseVendorMappingObj.itemTypeName" readonly>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"><spring:message
															code="label.manageitem.itemDescription"></spring:message>
													</label>
													<div class="col-md-7">
														<textarea class="form-control input-sm" rows="2" cols="25"
															name="<spring:message code="label.itemDescription"></spring:message>"
															data-ng-model="itemWiseVendorMappingObj.itemDescription" readonly
															style="resize: none"></textarea>
													</div>
												</div>
											</fieldset>
										</div>
										<div class="col-sm-6 col-md-3 col-lg-6">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label"><spring:message
															code="label.manageitem.partNo"></spring:message></label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="itemCode" id="itemCode" 
															data-ng-model="itemWiseVendorMappingObj.itemCode" readonly>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label"> <spring:message
															code="label.manageitem.itemCategory"></spring:message></label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="itemCategoryName" id="itemCategoryName" 
															data-ng-model="itemWiseVendorMappingObj.itemCategoryName" readonly>
													</div>
												</div>
											</fieldset>
										</div>
									</div>
								</div>
								<div class="row">
			        				<div id="content">
									 	<section data-widget-grid id="widget-grid">
									  		<div class="row">
									   			<article class="col-sm-12">
									    			<div data-jarvis-widget id="standard-datatable-widget">
												     <div role="content">
												      <div class="widget-body no-padding">
												       <div
												        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
												        data-st-table="displayedCollectionVendor"
												        data-st-safe-src="rowCollectionVendor">
												         <div class="padding-left-10 padding-top-5">
													           <button ng-click="addNewRow()" class="btn btn-sm btn-primary" tooltip="Add" ng-disabled="" type="button">
													            <i class="fa fa-plus"></i>
													           </button>
													           <button ng-click="removeRow()" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
													            <i class="fa  fa-trash-o"></i>
													           </button>
													      </div>
												        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
													         <thead class="dataTables-Main-Head">
													          <tr>
													           <th class="width_1 text-center table-heading">
													            <label class="i-checks m-b-none">
													             <input type="checkbox">
													             <i></i>
													            </label>
													           </th>
													           <th class="sorting width_5" st-sort="vendorItemCode">Vendor Item Code</th>
													           <th class="sorting width_5" st-sort="vendorItemName">Vendor Item Name</th>
													           <th class="sorting width_5" st-sort="uomName">Vendor UOM</th>
													           <th class="sorting width_5" st-sort="minimumQty">Minimum Quantity</th>
													           <th class="sorting width_5" st-sort="deliveryLeadTime">Delivery Lead Time</th>
													           <th class="sorting width_5" st-sort="pricingTypeName">Pricing Type</th>
													           <th class="width_5 text-center table-heading"><spring:message code="label.action"></spring:message></th>
													          </tr>
													         </thead>
													         <tbody class="dataTables-Main-Body">
													          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItemWiseVendorMapping in displayedCollectionVendor">           
													          <td cs-select="objItemWiseVendorMapping" class="text-center"></td>        
													           <td>{{objItemWiseVendorMapping.vendorItemCode}}</td>
													           <td>{{objItemWiseVendorMapping.vendorItemName}}</td>
													           <td>{{objItemWiseVendorMapping.uomName}}</td>
													           <td>{{objItemWiseVendorMapping.minimumQty}}</td> 
													           <td>{{objItemWiseVendorMapping.deliveryLeadTime}}</td>
													           <td>{{objItemWiseVendorMapping.pricingTypeName}}</td>            
													          <td class=" td-actions text-center">
														        <span>
														         <i class="fa  fa-pencil text-success text" data-ng-click="editRowVendor(objItemWiseVendorMapping.itemVendorId)"></i>
														        </span>
														        <span>
														         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRowVendor(objItemWiseVendorMapping.itemVendorId,$index)"></i>
														        </span>
													       	 </td>
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
									 	</section>
									</div>
			        				</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success"
												data-ng-if="!isEdit" type="submit"
												data-ng-click="validate(itemWiseVendorMappingAddForm,itemWiseVendorMappingObj,objItemWiseVendorMapping)">
												<i class="fa fa-save"></i>
												<spring:message code="label.save"></spring:message>
											</button>

											<button class="btn btn-success"
												data-ng-if="isEdit==true" type="submit"
												data-ng-click="validate(itemWiseVendorMappingAddForm,itemWiseVendorMappingObj,objItemWiseVendorMapping)">
												<i class="fa fa-save"></i>
												<spring:message code="label.update"></spring:message>
											</button>
											<button class="btn btn-info ng-scope" type="submit"
												data-ng-click="reset(itemWiseVendorMappingAddForm)"
												class="btn btn-success">
												<i class="fa fa-undo"></i>
												<spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancelVendor()">
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