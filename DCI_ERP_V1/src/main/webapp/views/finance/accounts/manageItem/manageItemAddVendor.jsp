<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">   
     			<div role="content" style="padding-left: 0px;">
      				<div class="widget-body">
       					<form class="form-horizontal" name="itemWiseVendorAddForm">
							 <div class="col-sm-12 col-md-12 col-lg-12">
				         		<div class="col-sm-6 col-md-6 col-lg-6">
				          			<fieldset>
				          				<div class="form-group">
							             	<label class="col-md-6 control-label"> Item Type </label>
							             		<div class="col-md-4">
									              	<select class="form-control" name="costingMethod" data-message-id="Department Name"
									               		data-ng-model="manageItemObj.costingMethod"
									               		data-validator="required" data-valid-method="submit">
									               		<option value="" selected="selected">Select</option>
									              	</select>
							             		</div>
								        </div>
							            <div class="form-group">
							             	<label class="col-md-6 control-label">Vendor ProductCode</label>
							             	<div class="col-md-4">
							              		<input type="text" class="form-control input-sm" 
							               			name="vendorProductCode" id="vendorProductCode"
							               			data-ng-model="itemWiseVendorObj.vendorProductCode"
							               			data-validator="required" data-valid-method="submit">
							             	</div>
							            </div>
							            <div class="form-group">
							             	<label class="col-md-6 control-label">UOM</label>
							             	<div class="col-md-4">
							              		<input type="text" class="form-control input-sm" 
							               			name="vendorUOM" id="vendorUOM"
							               			data-ng-model="itemWiseVendorObj.vendorUOM"
							               			data-validator="required" data-valid-method="submit">
							             	</div>
							            </div>
							            <div class="form-group">
							             	<label class="col-md-6 control-label"> </label>
							             		<div class="col-md-4">
									              	<input type="text" class="form-control input-sm" 
								               			name="deliveryLeadTime" id="deliveryLeadTime"
								               			data-ng-model="itemWiseVendorObj.deliveryLeadTime"
								               			data-validator="required" data-valid-method="submit">
							             		</div>
								        </div>
				          		</fieldset>
				         	</div>
						    <div class="col-sm-6 col-md-6 col-lg-6">
						        <fieldset>
				           			<div class="form-group">
						             	<label class="col-md-6 control-label"> </label>
						             		<div class="col-md-4">
								              	<input type="text" class="form-control input-sm" 
							               			name="vendorProductName" id="vendorProductName"
							               			data-ng-model="itemWiseVendorObj.vendorProductName"
							               			data-validator="required" data-valid-method="submit">
						             		</div>
							        </div>
							        <div class="form-group">
						             	<label class="col-md-6 control-label"></label>
						             	<div class="col-md-4">
						              		<input type="text" class="form-control input-sm" 
						               			name="minimumQty" id="minimumQty"
						               			data-ng-model="itemWiseVendorObj.minimumQty"
						               			data-validator="required" data-valid-method="submit">
						             	</div>
							       </div>
							       <div class="form-group">
						             	<label class="col-md-6 control-label"> <spring:message code="label.itemwisevendor.pricingType"></spring:message></label>
						             		<div class="col-md-4">
								              	<select class="form-control" name="pricingType" 						               data-message-id="Department Name"
								               		data-ng-model="itemWiseVendorObj.pricingType" ng-init="itemWiseVendorObj.pricingType==''"
								               		data-validator="required" data-valid-method="submit">
								               		<option value="" selected="selected">Select</option>
								               		<option value="Quotation">Quotation</option>
								               		<option value="Rate Contract">Rate Contract</option>
								               		<option value="Consignment">Consignment</option>
								              	</select>
						             		</div>
						            </div>
							       <%-- <div class="form-group">
						             	<label class="col-md-6 control-label"> <spring:message code="label.manageitem.priceList"></spring:message></label>
					             		<div class="col-md-4">
							              	<input type="text" class="form-control input-sm" 
						               			name="<spring:message code="label.priceList"></spring:message>" id="priceList"
						               			data-ng-model="itemWiseVendorObj.priceList"
						               			data-validator="required" data-valid-method="submit">
					             		</div>
								  </div> --%>
				           	</fieldset>
				          </div>
				        </div>       
       					</form>
      				</div>
     			</div><br>
			     <div class="row" ng-show="itemWiseVendorObj.pricingType=='Rate Contract'">
			      <div class="col-sm-12 col-md-12">
			       <div class="well" st-table="displayedCollection1"
			        st-safe-src="rowCollection1">
			        <div class="row">
			         <div class="col-sm-12 col-md-12 col-lg-12">
			          <div ng-repeat="(tIndex, table) in itemWiseVendor.rateContract">
			           <div class="row padding-top-15">
			            <div class="col-md-12">
			             <table class="table table-striped b-t b-light">
			              <thead>
			               <tr style="background-color: #eee;">
				             <th class="width_5"></th>
				            	<th style="text-align: center;" class="width_30">Quantity</th>
				            	<th style="text-align: center;" class="width_30">Unit Price</th>
				            </tr>
			              </thead>
			              <tbody ng-repeat="(triIndex, row) in table.row">
			               		<tr>
					                <td><label class="i-checks m-b-none"> <input
					                  type="checkbox" ng-model="row.select"
					                  id="section{{triIndex}}"><i></i></label></td>
					                <td class="padding-both-side-2">
						             	<input type="text" class="form-control input-sm" 
					               			id="company"
					               			data-ng-model="row.quantity">
									</td>
						             <td class="padding-both-side-2">
						             	<input type="text" class="form-control input-sm" 
					               			id="unitPrice"
					               			data-ng-model="row.unitPrice">
									</td>
			               			</tr>
			             		</tbody>
			           	 </table>
			             <div class="padding-right-5">
					              <button ng-click="addRow(table)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
					               <i class="fa fa-plus"></i>
					              </button>
					              <button ng-click="removeRow(table)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
					              		<i class="fa  fa-trash-o"></i>
					              </button>
			            			<div>
			            		</div>
			       		  </div>
			            </div>
			           </div>
			          </div>
			         </div>
			        </div>
			       </div>
			      </div>
			     </div>
     			<!-- end widget content -->
			     <div class="form-actions">
			      <div class="row">
			       <div class="col-md-12">
			        <button class="btn btn-success" type="button"
			         data-ng-click="save(testmasterForm,testMaster)"
			         data-ng-if="!testMaster.isEdit" class="btn btn-success">
			         <i class="fa fa-save"></i>
Save			        </button>
			        <button class="btn btn-success" type="button"
			         data-ng-click="update(testmasterForm,testMaster)"
			         data-ng-if="testMaster.isEdit" class="btn btn-success">
			         <i class="fa fa-save"></i>
Update			        </button>
			        <button class="btn btn-info" type="button"
			         data-ng-click="reset(testmasterForm)">
			         <i class="fa fa-undo"></i>
Reset			        </button>
			        <button class="btn btn-danger" type="button"
			         class="btn btn-success" ng-click="cancel()">
			         <i class="fa fa-close"></i>
Cancell			        </button>
			        <br> <br>
			       </div>
			      </div>
			     </div>
     <!-- end widget div -->
    		</div>
    <!-- end widget -->
   	</article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>