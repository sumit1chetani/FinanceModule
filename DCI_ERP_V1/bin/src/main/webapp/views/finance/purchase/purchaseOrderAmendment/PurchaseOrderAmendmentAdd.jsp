<style>
.main_container{
overflow:auto;
}
.datetimepicker{
width:auto;
}
.padding-0{
  padding: 0 !important;line-height: 34px;
}
.sorting:after{
  display : none !important;
} 
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" >
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="PurchaseOrderAmendment" novalidate method="post">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
         <fieldset>
         <div class="col-md-6">
         <fieldset ng-disabled="true">
         	<%-- 	<div class="form-group">
        				<label class="col-md-5 control-label"> Purchase Order No
        				<spring:message
              			code="label.asterisk.symbol"></spring:message></label>
        				<div class="col-md-4">
							<input type="text" class="form-control input-sm">
						</div>
						</div> --%>
						
						<div class="form-group">
				            <label class="col-md-3 control-label"> Purchase For </label>
				            <div class="col-md-7">
				            <select class="form-control input-sm" id="purchaseFor" name="purchaseFor" 
				            data-ng-model="purchaseOrder.purchaseFor"
							        	data-ng-options="ac.id as ac.text for ac in purchaseForList"
							        	validation="required" friendly-name="Purchase For">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div>
						
						<div class="form-group">
	        				<label class="col-md-3 control-label"> Hospital <spring:message
	              			code="label.asterisk.symbol"></spring:message></label>
	        				<div class="col-md-7">
	        				<selectivity list="hospitalList" property="purchaseOrder.companyId" id="hospital"
	        				ng-model="purchaseOrder.companyId" name="hospital" form-name = "PurchaseOrderForm"
	        				validation="required" friendly-name="Hospital"></selectivity>
	        				 <!-- <select class="form-control input-sm" id="hospital" name="hospital" data-ng-model="purchaseOrder.companyId"
							        	data-ng-options="ac.id as ac.text for ac in hospitalList">
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
						</div>
						</div>
						
						<div class="form-group">
	        				<label class="col-md-3 control-label"> Destination Location </label>
	        				<div class="col-md-7">
	        				<selectivity list="addressList" property="purchaseOrder.locationId" 
	        				ng-model="purchaseOrder.locationId" name="destination" form-name = "PurchaseOrderForm" 
	        				validation="required" friendly-name="Destination"
	        				id="location" object="location" ></selectivity>
	        				<!-- <select class="form-control input-sm" id="location" name="location" data-ng-model="location"
							        	data-ng-options="ac as ac.text for ac in destinationList" ng-change="loadDestAddress()">
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
								</div>
						</div>
						
						<div class="form-group">
				            <label class="col-md-3 control-label"> Destination Address
				            </label>
				            <div class="col-md-7">
						        <div class="col-md-12 no-padding">
						         	<textarea class="text-left form-control input-sm" rows="2" cols="15" 
						         	style="resize: none"
						         	 readonly="" ng-model="purchaseData.desAddress"> </textarea>
						        </div>
						     <div class="col-md-12 no-padding">
						      <div class="col-md-5 no-padding padding-top-5">
							<input type="text" class="form-control input-sm ng-pristine" placeholder="city" 
							ng-model="purchaseData.desCity"  readonly="">
						      </div>
						      <div class="col-md-4 no-padding padding-left-5 padding-top-5">
						      	<input type="text" class="form-control input-sm " placeholder="state" 
						      	ng-model="purchaseData.desState" readonly="">
						      </div>
						      <div class="col-md-3 no-padding padding-left-5 padding-top-5">
						      	<input type="text" class="form-control input-sm" placeholder="zip"
						      	 ng-model="purchaseData.desZipcode" readonly="">
						      </div>
						     </div>
						     <div class="col-md-12 no-padding padding-top-5">
						         		<input type="text" class="form-control input-sm" placeholder="country" 
										             	ng-model="purchaseData.desCountry" readonly>
						        </div>
						       </div>
			            </div>
						<div class="form-group">
				            <label class="col-md-3 control-label "> Terms & Conditions
				            </label>
				            <div class="col-md-7">
				             <textarea class="text-left form-control input-sm " name="disabled"
				             ng-model="purchaseOrder.termsCondition" rows="4" cols="20" style="resize: none"
				             validation="max_len:500|required" friendly-name="Terms & Conditions" > </textarea>
				            </div>
			            </div>
			            </fieldset>
        			
        	</div>
        	
        	<div class="col-md-6">
        	<fieldset ng-disabled="true">
        		<div class="form-group">
        				<label class="col-md-4 control-label"> PO Date </label>
        				<div class="col-md-7">
							<div class='input-group datetimepick col-md-12'>
					            <div class="dropdown">
					             <a class="dropdown-toggle" id="curDate" role="button"
					              data-toggle="dropdown" data-target="#" href="#">
					              <div class="input-group">
					               <input type="text" class="form-control"
					                placeholder="dd/mm/yyyy" name="currentDate"
					                validation="date_euro_long|required" 
					                friendly-name="Purchase Order Date"
					                data-ng-model="purchaseOrder.purchaseOrderDate"><span
					                class="input-group-addon"><i
					                class="glyphicon glyphicon-calendar"></i></span>
					              </div>
					             </a>
					             <ul class="dropdown-menu" role="menu"
					              aria-labelledby="dLabel">
					              <datetimepicker data-ng-model="purchaseOrder.purchaseOrderDate"
					               data-on-set-time="purchaseOrder.purchaseOrderDate = onDateSet(newDate)"
					               data-datetimepicker-config="{ dropdownSelector: '#curDate',startView:'day', minView:'day'}" />
					             </ul>
					            </div>
					           </div> 
						</div>
						</div>
						
						<div class="form-group">
				            <label class="col-md-4 control-label"> Purchase Type </label>
				            <div class="col-md-7">
				            <select class="form-control input-sm" id="purchaseType" name="purchaseType" data-ng-model="purchaseOrder.purchaseType"
							        	data-ng-options="ac.id as ac.text for ac in purchaseTypeList" disabled>
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div>
			             
			             <div class="form-group">
			      				<label class="col-md-4 control-label"> Status
			      				</label>
			      				<div class="col-md-7">
			      				<!-- <label>A</label> -->
			      				
			      				<select class="form-control input-sm " id="Status" name="Status" data-ng-model="purchaseOrder.statusId"
							        	data-ng-options="ac.id as ac.text for ac in statusList" disabled>
							          	<option value="" selected="selected">--Select--</option>
						     </select>
															</div>
						</div>
						
						<div class="form-group">
	        				<label class="col-md-4 control-label"> Vendor <spring:message
	              			code="label.asterisk.symbol"></spring:message></label>
	        				<div class="col-md-7">
	        				<selectivity list="vendorList" ng-model="purchaseOrder.vendorId"
	        				property="purchaseOrder.vendorId" id="vendor"  object="vendor"  name="vendor"
	        				validation="required" friendly-name="vendor" form-name = "PurchaseOrderForm"></selectivity> 
	        			<!-- 	<select class="form-control input-sm" id="Vendor" name="Vendor" data-ng-model="vendor"
							        	data-ng-options="ac as ac.text for ac in vendorList" ng-change="loadVendorAddress()">
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
						     							</div>
						</div>
						
						
						<div class="form-group">
				            <label class="col-md-4 control-label"> Vendor Address
				            </label>
				             <div class="col-md-7">
						        <div class="col-md-12 no-padding">
						         	<textarea class="text-left form-control input-sm" rows="2" cols="15"  style="resize: none" readonly ng-model="purchaseData.desAddress1"> </textarea>
						        </div>
						     <div class="col-md-12 no-padding">
						      <div class="col-md-5 no-padding padding-top-5">
							<input type="text" class="form-control input-sm" placeholder="city" readonly  ng-model="purchaseData.desCity1">
						      </div>
						      <div class="col-md-4 no-padding padding-left-5 padding-top-5">
						      <input type="text" class="form-control input-sm" placeholder="state" ng-model="purchaseData.desState1" readonly>
						      </div>
						      <div class="col-md-3 no-padding padding-left-5 padding-top-5">
						      	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="purchaseData.desZipcode1" readonly>
						      </div>
						     </div>
						     <div class="col-md-12 no-padding padding-top-5">
						         	<input type="text" class="form-control input-sm" placeholder="country" ng-model="purchaseData.desCountry1" readonly>
						        </div>
						       </div>
			            </div>
			            <div class="form-group">
				            <label class="col-md-4 control-label"> Remarks
				            </label>
				            <div class="col-md-7">
				             <textarea class="text-left form-control input-sm" name="remarks"
				             data-ng-model="purchaseOrder.remarks" rows="4" cols="20" style="resize: none"
				              > </textarea>
				            </div>
			            </div>
			        </fieldset>    
        		</div>
        		
        	
        		
        		
        		<div class="col-sm-12 col-md-12 col-lg-12"><br>
        		<div role="content">
			      <div class="widget-body no-padding">
			       <div
			        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
			        data-st-table="displayedCollectionItem"
			        data-st-safe-src="rowCollectionItem">
<!-- 			        <div class="dt-toolbar" -->
<!-- 			         data-smart-include="views/layout/toolbar-header.tpl"></div> -->
						
			        <table id="dt_basic"
			         class="table table-striped table-bordered table-hover dataTable no-footer"
			         role="grid" aria-describedby="dt_basic_info">
			         <thead class="dataTables-Main-Head">
			          <tr>
			           <!-- <th class="width_1 table-heading text-center">
			            <label class="i-checks m-b-none">
			             <input type="checkbox">
			             <i></i>
			            </label>
			           </th> -->
			           <th class="sorting width_14" >Item Code-Item Name</th>
			           <th class="sorting width_6" >EDD</th>
			           <th class="sorting width_6" >UOM</th>
			           <th class="sorting width_5" >Qty</th>
			           <th class="sorting width_7"  style="padding: 0 !important;line-height: 34px;">Unit Price</th>
			           <th class="sorting width_8" >Price</th>
			           <th class="sorting width_10" >Discount Type</th>
			           <th class="sorting width_8"  style="padding: 0 !important;line-height: 34px;">Discount</th>
			           <th class="sorting width_7" >Tax Type</th>
			           <th class="sorting width_7" >Tax</th>
			           <th class="sorting width_8" >Total</th>
			          <!--  <th class="sorting width_8" >pending Qty</th> -->
			          </tr>
			         </thead>
			         <tbody class="dataTables-Main-Body">
			          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="departmentCollections in displayedCollectionItem"
			          ng-hide="departmentCollections.edit == '2'">
			           <!-- <td ng-init="display = departmentCollections.quantity == departmentCollections.pendingQnty ? false : true ">
			           <label class="i-checks m-b-none" ng-hide='display' >
			             <input type="checkbox" ng-model="departmentCollections.isSelected">
			             <i></i>
			            </label></td> -->
			           <td>{{departmentCollections.purchaseItemName}}</td>
			           <td>{{departmentCollections.edd}}</td>
			           <td>{{departmentCollections.uomName}}</td>
			           <td>
			           	<input type="text" style="text-align: right;" ng-model="departmentCollections.quantity" 
			           		ng-blur="calculateTaxDiscount(departmentCollections)" 
			           		placeholder="0" style="width:40px;" ng-init="calculateTaxDiscount(departmentCollections)" 
			           		name="{{ 'quantity' + $index }}"
			           		validation="required" friendly-name="{{ 'Row' + $index + '(Quantity)'}}" 
			           		ng-disabled="departmentCollections.pendingQnty == '0'">
			           
			           </td>
			           <td  style="text-align: right;">{{departmentCollections.unitPrice}}</td>
			           <td  style="text-align: right;">{{departmentCollections.price}}</td>
                       <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td>
			           <td  style="text-align: right;">{{departmentCollections.discount}}</td>
			           <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxType}}</td>
			           <td  style="text-align: right;">{{departmentCollections.tax}}</td>
			           <td  style="text-align: right;">{{departmentCollections.finalTotal}}</td>
			          <!--  <td  style="text-align: right;">{{departmentCollections.pendingQnty}}</td> -->
			           <!-- <td>{{departmentCollections.purchaseStatus}}</td> -->
			            <!-- <td>{{departmentCollections.purchaseItemDesc}}</td> -->
			           <!-- <td>{{departmentCollections.vendorName}}</td> -->
			           <!--  <td>{{departmentCollections.deliveryLeadTime}}</td> -->
			          </tr>
			         </tbody>
			        </table>
			       </div>
			      </div>
			      <!-- end widget content -->
			     </div>
			     </div>
				
				<div class="col-md-12" style="margin-top: 10px;">
        			<div class="form-group">
        				<label class="col-md-1 control-label"> SubTotal :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.subTotal" readonly  style="text-align: right;padding-right: 0;">
						</div>
        				<label class="col-md-1 control-label"> Discount :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalDiscount" readonly  style="text-align: right;padding-right: 0;">
						</div>
        				<label class="col-md-1 control-label"> Tax :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalTax" readonly  style="text-align: right;padding-right: 0;">
						</div>
						<label class="col-md-1 control-label"> Freight </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.freight"  placeholder="0" style="text-align: right;padding-right: 0;">
						</div>
						<label class="col-md-1 control-label"> Total :</label>
        				<div class="col-md-2">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalAmount" readonly  style="text-align: right;padding-right: 0;">
						</div>
					</div>
        		</div>
        		<!-- <div class="padding-left-10 padding-top-5" id="AddOrRmveMeritbtn">
			           <button ng-click="addPurchaseRow()" class="btn btn-sm btn-primary" tooltip="Add" ng-disabled="" type="button">
			            <i class="fa fa-plus"></i>
			           </button>
			           <button ng-click="removePurchaseRow()" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
			            <i class="fa  fa-trash-o"></i>
			           </button>
			      </div> -->
        			
        	 </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            class="btn btn-success"
            data-ng-click="validate(PurchaseOrderForm,purchaseOrder)"
            
            data-ng-if="!isEdit">
           <i class="fa fa-save"></i>
				Request For Approval
           </button>
           <!-- data-ng-click="save(PurchaseOrderForm,purchaseOrder)" -->
           <button class="btn btn-success" type="button"
            class="btn btn-success" id="update"
            data-ng-click="validate(PurchaseOrderForm,purchaseOrder);"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
				Update
           </button>
           <button class="btn btn-info" type="button"
            class="btn btn-success" data-ng-hide="isEdit == true"
            data-ng-click="reset(PurchaseOrderForm);">
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