<style>
.myform-group {
	margin-left: 0px;
	margin-bottom: 0px;
}
.ngdialog-content {
	width: 90% !important;
}
</style>

<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="content" style="padding: 0px;margin-top: -70px;">
 	<section data-widget-grid id="widget-grid">
  		<div class="row">
   			<article class="col-sm-12">
    			<div data-jarvis-widget id="standard-datatable-widget">
 					<header class="ngdialog-header">
      					<span class="widget-icon"> <i class="fa fa-table"></i>
      					</span>
      				<h2>
       					<spring:message code="label.itemwisevendor.itemWiseVendor"></spring:message>
      				</h2>
     				</header>     
     			<div role="content" style="padding-left: 0px;">
      				<div class="widget-body">
       					<form class="form-horizontal" name="itemWiseVendorAddForm">
							 <div class="col-sm-12 col-md-12 col-lg-12">
				         		<div class="col-sm-6 col-md-6 col-lg-6">
				          			<fieldset>
				          				<div class="form-group">
							             	<label class="col-md-6 control-label">Vendor<spring:message code="label.asterisk.symbol"></spring:message></label>
							             		<div class="col-md-4">
									              	<select class="form-control" name="vendorId"
									               		data-ng-model="itemWiseVendorObj.vendorId" validation="required" friendly-name="Vendor"
									               		data-ng-options="obj.vendorId as obj.vendorName for obj in vendorList">
									               		<option value="" selected="selected">Select</option>
									              	</select>
							             		</div>
							            </div>
							            <div class="form-group">
							             	<label class="col-md-6 control-label">Vendor Item Code<spring:message code="label.asterisk.symbol"></spring:message></label>
							             	<div class="col-md-4">
							              		<input type="text" class="form-control input-sm" 
							               			name="vendorItemCode" id="vendorItemCode" validation="required" friendly-name="Vendor Item Code"
							               			data-ng-model="itemWiseVendorObj.vendorItemCode"
							               			data-validator="required" data-valid-method="submit">
							             	</div>
							            </div>
							            <div class="form-group">
							             	<label class="col-md-6 control-label"><spring:message code="label.itemwisevendor.vendorUOM"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
							             	<div class="col-md-4">
							             		<select class="form-control" name="uomId" id="uomId"
														data-ng-model="itemWiseVendorObj.uomId" validation="required" friendly-name="Vendor UOM"
														data-ng-options="objUom.uomId as objUom.uomName for objUom in vendorUOMList"
														data-validator="required" data-valid-method="submit">
														<option value="" selected="selected">Select</option>
												</select>
							             	</div>
							            </div>
							            <div class="form-group">
							             	<label class="col-md-6 control-label"><spring:message code="label.manageitem.deliveryLeadTime"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
							             		<div class="col-md-4">
									              	<input type="text" class="form-control input-sm" 
								               			name="deliveryLeadTime" id="deliveryLeadTime" validation="required" friendly-name="Delivery Lead Time"
								               			data-ng-model="itemWiseVendorObj.deliveryLeadTime"
								               			data-validator="required" data-valid-method="submit">
							             		</div>
							             		<label class="control-label">Days</label>
								        </div>
				          		</fieldset>
				         	</div>
						    <div class="col-sm-6 col-md-6 col-lg-6">
						        <fieldset>
				           			<div class="form-group">
						             	<label class="col-md-6 control-label">Vendor Item Name<spring:message code="label.asterisk.symbol"></spring:message></label>
						             		<div class="col-md-4">
								              	<input type="text" class="form-control input-sm" 
							               			name="vendorItemName" id="vendorItemName" validation="required" friendly-name="Vendor Item Name"
							               			data-ng-model="itemWiseVendorObj.vendorItemName"
							               			data-validator="required" data-valid-method="submit">
						             		</div>
							        </div>
							        <div class="form-group">
						             	<label class="col-md-6 control-label"><spring:message code="label.manageitem.minimumQty"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
						             	<div class="col-md-4">
						              		<input type="text" class="form-control input-sm" 
						               			name="minimumQty" id="minimumQty" validation="required" friendly-name="Minimum Quantity"
						               			data-ng-model="itemWiseVendorObj.minimumQty"
						               			data-validator="required" data-valid-method="submit">
						             	</div>
							       </div>
							       <div class="form-group">
						             	<label class="col-md-6 control-label"> <spring:message code="label.itemwisevendor.pricingType"></spring:message><spring:message code="label.asterisk.symbol"></spring:message></label>
						             		<div class="col-md-4">
								              	<select class="form-control" name="pricingTypeId" id="pricingTypeId" validation="required" friendly-name="Pricing Type"
								               		data-ng-model="itemWiseVendorObj.pricingTypeId" data-ng-options="obj.pricingTypeId as obj.pricingTypeName for obj in pricingTypeList"
								               		data-validator="required" data-valid-method="submit">
								               		<option value="" selected="selected">Select</option>
								              	</select>
						             		</div>
						            </div>
				           	</fieldset>
				          </div>
				        </div>       
       					</form>
      				</div>
     			</div><br>
     			<!-- end widget content -->
			     <div class="form-actions">
			      <div class="row">
			       <div class="col-md-12">
			        <button class="btn btn-success" type="submit"
			         data-ng-click="submit(itemWiseVendorAddForm,itemWiseVendorObj)"
			         data-ng-if="!isEditVendor" class="btn btn-success">
			         <i class="fa fa-save"></i>
			         <spring:message code="label.save"></spring:message>
			        </button>
			        <button class="btn btn-success" type="submit"
			         data-ng-click="validateUpdateVendor(itemWiseVendorAddForm,itemWiseVendorObj)"
			         data-ng-if="isEditVendor==true" class="btn btn-success">
			         <i class="fa fa-save"></i>
			         <spring:message code="label.update"></spring:message>
			        </button>
			        <button class="btn btn-info" type="button"
			         data-ng-click="reset(itemWiseVendorAddForm)">
			         <i class="fa fa-undo"></i>
			         <spring:message code="label.reset"></spring:message>
			        </button>
			        <button class="btn btn-danger" type="reset"
			         class="btn btn-success" ng-click="cancel()">
			         <i class="fa fa-close"></i>
			         <spring:message code="label.cancel"></spring:message>
			        </button>
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