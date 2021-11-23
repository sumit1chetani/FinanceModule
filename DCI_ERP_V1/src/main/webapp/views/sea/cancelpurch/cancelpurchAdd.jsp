<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
.selectivity-backdrop {
background: transparent;
position: relative;
z-index: 9998;
top: 0;
right: 0;
bottom: 0;
left: 0;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
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
       <form class="form-horizontal" name="PurchaseOrderForm">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
         <div class="col-md-6">
         <fieldset ng-disabled="true">
         		<div class="form-group">
        				<label class="col-md-3 control-label"> Purchase Order No
        				</label>
        				<div class="col-md-7">
							<input type="text" class="form-control input-sm" data-ng-model="purchaseOrder.purchaseOrderNum">
						</div>
						</div>
						
						<div class="form-group">
				            <label class="col-md-3 control-label"> Purchase For </label>
				            <div class="col-md-7">
				            <select class="form-control input-sm deselect" id="purchaseFor" name="purchaseFor" data-ng-model="purchaseOrder.purchaseFor"
							        	data-ng-options="ac.id as ac.text for ac in purchaseForList">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div>
						
						<div class="form-group">
	        				<label class="col-md-3 control-label"> Organization <spring:message
	              			code="label.asterisk.symbol"></spring:message></label>
	        				<div class="col-md-7">
	        				 <select class="form-control input-sm deselect" id="hospital" name="hospital" data-ng-model="purchaseOrder.companyId"
							        	data-ng-options="ac.id as ac.text for ac in hospitalList">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
						</div>
						</div>
						
						<div class="form-group">
	        				<label class="col-md-3 control-label"> Destination Location </label>
	        				<div class="col-md-7">
	        				<select class="form-control input-sm deselect" id="location" name="location" data-ng-model="purchaseOrder.locationId"
							        	data-ng-options="ac.id as ac.text for ac in addressList" ng-change="loadDestAddress()">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
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
				            <label class="col-md-3 control-label"> Terms & Conditions
				            </label>
				            <div class="col-md-7">
				             <textarea disbaled class="text-left form-control input-sm" data-ng-model="purchaseOrder.termsCondition" rows="4" cols="20" style="resize: none" disabled> </textarea>
				            </div>
			            </div>
						
        			</fieldset>
        	</div>
        	
        	<div class="col-md-6">
        	<fieldset >
        		<div class="form-group">
        				<label class="col-md-4 control-label"> PO Date </label>
        				<div class="col-md-7">
							<div class='input-group date datetimepick col-md-12'>
					            <div class="dropdown">
					             <a data-toggle="dropdown" class="dropdown-toggle" id="curDate" role="button"
					              data-target="#" href="#">
					              <div class="input-group">
					               <input type="text" class="form-control"
					                placeholder="dd/mm/yyyy" name="currentDate"
					                data-validator="required" data-valid-method="submit"
					                data-message-id="currentDate"
					                data-ng-model="purchaseOrder.purchaseOrderDate"  disabled><span
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
				            <select class="form-control input-sm deselect" id="purchaseType" name="purchaseType" data-ng-model="purchaseOrder.purchaseType"
							        	data-ng-options="ac.id as ac.text for ac in purchaseTypeList" disabled>
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div>
						
						<div class="form-group">
			      				<label class="col-md-4 control-label"> Status
			      				</label>
			      				<div class="col-md-7">
			      				<select class="form-control input-sm" id="Status" name="Status" data-ng-model="purchaseOrder.statusId"
							        	data-ng-options="ac.id as ac.text for ac in statusList" disabled >
							          	<option value="" selected="selected">--Select--</option>
						     </select>
															</div>
						</div>
						
						<div class="form-group">
	        				<label class="col-md-4 control-label"> Vendor <spring:message
	              			code="label.asterisk.symbol"></spring:message></label>
	        				<div class="col-md-7">
	        				<select class="form-control input-sm deselect" id="Vendor" name="Vendor" data-ng-model="vendor"
							        	data-ng-options="ac as ac.text for ac in vendorList" ng-change="loadVendorAddress()" disabled >
							          	<option value="" selected="selected" >--Select--</option>
						     </select>
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
				            <label class="col-md-4 control-label "> Remarks
				            </label>
				            <div class="col-md-7">
				             <textarea class="text-left form-control input-sm" data-ng-model="purchaseOrder.remarks" rows="4" cols="20" style="resize: none" > </textarea>
				            </div>
			            </div>
			         </fieldset>   
        		</div>
        		
        		<div class="col-sm-12 col-md-12 col-lg-12" ng-if="purchaseOrder.purchaseTypeName != 'Rate Contract'"><br>
        		<div role="content">
			      <div class="widget-body no-padding">
			       <div style="min-width:70%; overflow-x:scroll"
			        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
			        data-st-table="displayedCollectionItem"
			        data-st-safe-src="rowCollectionItem">

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
			           <th class="sorting width_14" data-st-sort="purchaseItemName">Item Code-Item Name</th>
			           <th class="sorting width_6" data-st-sort="edd">EDD</th>
			           <th class="sorting width_6" data-st-sort="uom">Vendor UOM</th>
			           <th class="sorting width_5" data-st-sort="quantity">Vendor Qty</th>
			           <th class="sorting width_7" data-st-sort="unitPrice">Unit Price</th>
			           <th class="sorting width_8">Old Unit Price</th>
			           <th class="sorting width_8" data-st-sort="price">Price</th>
			           <th class="sorting width_8" data-st-sort="discount">Discount</th>
			           <th class="sorting width_8" data-st-sort="total">Sub Total</th>
			           <th class="sorting width_7" data-st-sort="tax">Tax</th>
			           <!-- <th class="sorting width_7" data-st-sort="purchaseStatus">Status</th> -->
			           <!-- <th class="sorting width_10" data-st-sort="">Item Description</th> -->
			           <!-- <th class="sorting width_7" data-st-sort="">Vendor Item Name</th> -->
			           <!--  <th class="sorting width_7" data-st-sort="">Delivery Lead Time</th> -->
			            <%-- <th class="width_8 table-heading text-center"><spring:message code="label.action"></spring:message></th> --%>
			          </tr>
			         </thead>
			         <tbody class="dataTables-Main-Body">
			          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="departmentCollections in displayedCollectionItem"
			          ng-hide="departmentCollections.edit == '2'">
			         <!--   <td >
			           <label class="i-checks m-b-none">
			             <input type="checkbox" ng-model="departmentCollections.isSelected">
			             <i></i>
			            </label></td> -->
			           <td>{{departmentCollections.purchaseItemName}}</td>
			           <td>{{departmentCollections.edd}}</td>
			           <td>{{departmentCollections.uomName}}</td>
			           <td style="text-align: right;">{{departmentCollections.quantity}}</td>
			           <td style="text-align: right;">{{departmentCollections.unitPrice}}</td>
			           <td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
			           <td ng-init="calculateTaxDiscount(departmentCollections)" style="text-align: right;">{{departmentCollections.price}}</td>
			           <td style="text-align: right;">{{departmentCollections.discount}}</td>
			           <td style="text-align: right;">{{departmentCollections.total}}</td>
			           <td style="text-align: right;">{{departmentCollections.tax}}</td>
			          <!--  <td>{{departmentCollections.purchaseStatus}}</td> -->
			            <!-- <td>{{departmentCollections.purchaseItemDesc}}</td> -->
			           <!-- <td>{{departmentCollections.vendorName}}</td> -->
			           <!--  <td>{{departmentCollections.deliveryLeadTime}}</td> -->
			            <!-- <td class=" td-actions text-center">
					        <span>
					         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(departmentCollections)"></i>
					        </span>
					        <span>
					         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(departmentCollections)"></i>
					        </span>
			       </td> -->
			          </tr>
			         </tbody>
			        </table>
<!-- 			        <div class="dt-toolbar-footer" -->
<!-- 			         data-smart-include="views/layout/toolbar-footer.tpl"></div> -->
			       </div>
			      </div>
			      <!-- end widget content -->
			     </div><br>
			     </div>
				
				<div class="col-md-12" ng-if="purchaseOrder.purchaseTypeName != 'Rate Contract'">
        			<div class="form-group">
        				<label class="col-md-1 control-label"> SubTotal :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.subTotal" readonly style="text-align: right;padding-right: 0;padding-left: 0;">
						</div>
        				<label class="col-md-1 control-label"> Discount :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalDiscount" readonly style="text-align: right;padding-right: 0;padding-left: 0;">
						</div>
        				<label class="col-md-1 control-label"> Tax :</label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalTax" readonly style="text-align: right;padding-right: 0;padding-left: 0;">
						</div>
						<label class="col-md-1 control-label"> Freight </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.freight" readonly style="text-align: right;padding-right: 0;padding-left: 0;">
						</div>
						<label class="col-md-1 control-label"> Total :</label>
        				<div class="col-md-2">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalAmount" readonly style="text-align: right;padding-right: 0;padding-left: 0;">
						</div>
					</div>
        		</div>
        		
        		<div class="col-sm-12 col-md-12 col-lg-12" ng-if="purchaseOrder.purchaseTypeName == 'Rate Contract'"
        		style="overflow-x: hidden;">		
        		<tabset justified="true" class="tab-container">
			        <tab heading="Order Status" >
		        		<div role="content">
					      <div class="widget-body no-padding">
					       <div style="min-width:70%; overflow-x:scroll"
					        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-corner-all"
					        data-st-table="displayedCollectionItem"
					        data-st-safe-src="rowCollectionItem">
					        <table id="dt_basic"
					         class="table table-striped table-bordered table-hover dataTable no-footer"
					         role="grid" aria-describedby="dt_basic_info">
					         <thead class="dataTables-Main-Head">
					          <tr>
					           <th class="width_1 table-heading text-center">
					            <label class="i-checks m-b-none">
					             <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(rowCollectionItem,selectedAll)">
					             <i></i>
					            </label>
					           </th>
					           <th class="sorting width_14" >Item Code-Item Name</th>
					           <th class="sorting width_6" >EDD</th>
					           <th class="sorting width_6" >Vendor UOM</th>
					           <th class="sorting width_5" >Vendor Qty</th>
					           <th class="sorting width_7"  style="padding: 0 !important;line-height: 34px;">Unit Price</th>
					           <th class="sorting width_8">Old Unit Price</th>
					           <th class="sorting width_8" >Price</th>
					            <th class="sorting width_10" >Discount Type</th>
					           <th class="sorting width_8"  style="padding: 0 !important;line-height: 34px;">Discount</th>
					            <th class="sorting width_7" >Tax Type</th>
					           <th class="sorting width_7" >Tax</th>
					           <th class="sorting width_8" >Total</th>
					          </tr>
					         </thead>
					         <tbody class="dataTables-Main-Body">
					          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="departmentCollections in displayedCollectionItem"
					          ng-hide="departmentCollections.edit == '2'">
					           <td >
					           <label class="i-checks m-b-none">
					             <input type="checkbox" ng-model="departmentCollections.isSelected">
					             <i></i>
					            </label></td>
					           <td>{{departmentCollections.purchaseItemName}}</td>
					           <td>{{departmentCollections.edd}}</td>
					           <td>{{departmentCollections.uomName}}</td>
					           <td ng-init="calculateTaxDiscount(departmentCollections)">{{departmentCollections.quantity}}</td>
					           <td  style="text-align: right;">{{departmentCollections.unitPrice}}</td>
					           <td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
					           <td  style="text-align: right;">{{departmentCollections.price}}</td>
					           <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td>
					           <td  style="text-align: right;">{{departmentCollections.discount}}</td>
					           <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxType}}</td>
					           <td  style="text-align: right;">{{departmentCollections.tax}}</td>
					           <td  style="text-align: right;">{{departmentCollections.finalTotal}}</td>
					          <!--  <td>{{departmentCollections.purchaseStatus}}</td> -->
					          </tr>
					         </tbody>
					        </table>
					       </div>
					       <div class="form-group padding-top-20">
		        				<label class="col-md-1 control-label"> SubTotal </label>
		        				<div class="col-md-1">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.subTotal" readonly  style="text-align: right;padding-right: 0;padding-left: 0;">
								</div>
		        				<label class="col-md-1 control-label"> Discount </label>
		        				<div class="col-md-1">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalDiscount" readonly  style="text-align: right;padding-right: 0;padding-left: 0;">
								</div>
		        				<label class="col-md-1 control-label"> Tax </label>
		        				<div class="col-md-1">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalTax" readonly  style="text-align: right;padding-right: 0;padding-left: 0;">
								</div>
								<label class="col-md-1 control-label"> Freight </label>
		        				<div class="col-md-1">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.freight" readonly style="text-align: right;padding-right: 0;padding-left: 0;">
								</div>
								<label class="col-md-1 control-label"> Total </label>
		        				<div class="col-md-2">
									<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalAmount" readonly  style="text-align: right;padding-left: 0;padding-right: 0;">
								</div>
							</div>
					      </div> <!-- /WIDGET-BODY -->
					     </div>
			    </tab>
        		<tab heading="Delivery Schedule">
	        		<div  data-st-table="displayedCollectionDeliveryItem"
				        data-st-safe-src="rowCollectionDeliveryItem">
											
							<table class="table table-striped table-bordered table-hover dataTable no-footer">
								 <thead class="dataTables-Main-Head">
							          <tr>
							           <th class="width_1 table-heading text-center">
							            <label class="i-checks m-b-none">
							             <input type="checkbox" ng-model="selectedAll" ng-change="checkAllDelivery(rowCollectionDeliveryItem,selectedAll)">
							             <i></i>
							            </label>
							           </th>
							           <th class="sorting width_7">Item Name</th>
							           <th class="sorting width_10" >Delivery Schedule</th>
							            <th class="sorting width_8">Quantity</th>
							          </tr>
							     </thead>
								<tbody >
									<tr data-ng-repeat="departmentCollectionsDelivery in displayedCollectionDeliveryItem"
									ng-hide="departmentCollectionsDelivery.edit == '2'" >
										<td><label class="i-checks m-b-none"> <input
												type="checkbox" data-ng-model="departmentCollectionsDelivery.isSelected">
												<i></i>
												</label>
										</td>
										<td class="width_15">
											 <!-- <selectivity list="itemList" property="departmentCollectionsDelivery.itemId" id="item"></selectivity> -->
											 <select class="form-control input-sm" id="item" name="item" data-ng-model="departmentCollectionsDelivery.itemId"
							        	data-ng-options="ac.id as ac.text for ac in itemList" disabled>
							          	<option value="" selected="selected">--Select--</option>
						     				</select>
										</td>
										<!-- id="purchaseOrderDeliveryDate$index" -->
										<td class="width_10">
										<input type="text" ng-model="departmentCollectionsDelivery.purchaseOrderDeliveryDate" class="control-label" 
											placeholder="0" readonly>
										</td>
										<td class="width_15">
											<input type="text" ng-model="departmentCollectionsDelivery.quantity" class="control-label" placeholder="0" readonly>
										</td>
									</tr>
								</tbody>
							</table>
																				
						</div>
        		 </tab>
			       </tabset>	
        	 </div>
        			
        	 </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            class="btn btn-success"
            data-ng-click="save()"
            >
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
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