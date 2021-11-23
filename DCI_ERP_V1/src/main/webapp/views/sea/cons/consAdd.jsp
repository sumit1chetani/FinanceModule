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
         <fieldset>
         <div class="col-md-6">
        
         	<%-- 	<div class="form-group">
        				<label class="col-md-5 control-label"> Purchase Order No
        				<spring:message
              			code="label.asterisk.symbol"></spring:message></label>
        				<div class="col-md-4">
							<input type="text" class="form-control input-sm">
						</div>
						</div> --%>
						
						<div class="form-group">
				            <label class="col-md-3 control-label"> Purchase For <spring:message code="label.asterisk.symbol"></spring:message> </label>
				            <div class="col-md-7">
				            <select class="form-control input-sm" id="purchaseFor" name="purchaseFor" data-ng-model="purchaseOrder.purchaseFor"
							        	data-ng-options="ac.id as ac.text for ac in purchaseForList" validation="required" friendly-name="Purchase For">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div>
						<div class="form-group">
			      				<label class="col-md-3 control-label"> Status
			      				</label>
			      				<div class="col-md-7">
			      				<label style="margin-top: 7px;margin-bottom: 0px;">Pending</label>
			      				
			      				<!-- <select class="form-control input-sm hide" id="Status" name="Status" data-ng-model="purchaseOrder.statusId"
							        	data-ng-options="ac.id as ac.text for ac in statusList" disabled>
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
															</div>
						</div>
						<div class="form-group">
	        				<label class="col-md-3 control-label"> Organization Name <spring:message
	              			code="label.asterisk.symbol"></spring:message></label>
	        				<div class="col-md-7">
	        				<selectivity list="hospitalList" property="purchaseOrder.companyId" ng-model="purchaseOrder.companyId" id="companyId" name="companyId" validation="required" friendly-name="Hospital" form-name = "PurchaseOrderForm"></selectivity>
	        				 <!-- <select class="form-control input-sm" id="hospital" name="hospital" data-ng-model="purchaseOrder.companyId"
							        	data-ng-options="ac.id as ac.text for ac in hospitalList">
							          	<option value="" selected="selected">--Select--</option>
						     </select> -->
						</div>
						</div>
						<div class="form-group">
	        				<label class="col-md-3 control-label"> Destination Location<spring:message code="label.asterisk.symbol"></spring:message></label>
	        				<div class="col-md-7">
	        				<selectivity list="addressList" property="purchaseOrder.locationId" id="locationId" name="locationId" ng-model="purchaseOrder.locationId" validation="required" friendly-name="Destination Location" form-name = "PurchaseOrderForm"></selectivity>
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
				            <label class="col-md-3 control-label"> Terms & Conditions
				            </label>
				            <div class="col-md-7">
				             <textarea class="text-left form-control input-sm " 
				             data-ng-model="purchaseOrder.termsCondition" rows="4" cols="20" 
				             style="resize: none"> </textarea>
				            </div>
			            </div>
					</div>
					
        	<div class="col-md-6">
        		<div class="form-group">
        				<label class="col-md-4 control-label"> PO Date </label>
        				<div class="col-md-7">
							<div class='input-group date width_100 datetimepick'>
					            <div class="dropdown">
					             <a class="dropdown-toggle" id="curDate" role="button"
					              data-toggle="dropdown" data-target="#" href="#">
					              <div class="input-group">
					               <input type="text" class="form-control"
					                placeholder="dd/mm/yyyy" name="currentDate"
					                data-validator="required" data-valid-method="submit"
					                data-message-id="currentDate"
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
				            <label class="col-md-4 control-label"> Consignment Transfer Number<spring:message code="label.asterisk.symbol"></spring:message></label>
				            <div class="col-md-7">
				            <selectivity list="conTransNoList" ng-model="purchaseOrder.conTransNo" property="purchaseOrder.conTransNo" id="conTransNo" name="conTransNo" object="contransfer" friendly-name="Consignment Transfer Number" form-name = "PurchaseOrderForm" validation="required" ng-if="!isEdit"></selectivity>
				            <selectivity list="conTransNoList" ng-model="purchaseOrder.conTransNo" property="purchaseOrder.conTransNo" id="conTransNo" name="conTransNo" object="contransfer" friendly-name="Consignment Transfer Number" form-name = "PurchaseOrderForm" validation="required" disabled="true" ng-if="isEdit"></selectivity>
				            </div>
			             </div>
						<div class="form-group">
	        				<label class="col-md-4 control-label"> Vendor <spring:message
	              			code="label.asterisk.symbol"></spring:message></label>
	        				<div class="col-md-7">
	        				<selectivity list="vendorList" property="purchaseOrder.vendorId" ng-model="purchaseOrder.vendorId" id="vendorId" ng-if="!isEdit"
	        					name="vendorId" object="vendor" friendly-name="Vendor" validation="required" form-name = "PurchaseOrderForm"></selectivity>
	        					<selectivity list="vendorList" property="purchaseOrder.vendorId" ng-model="purchaseOrder.vendorId" id="vendorId" disabled="true" ng-if="isEdit"
	        					name="vendorId" object="vendor" friendly-name="Vendor" validation="required" form-name = "PurchaseOrderForm"></selectivity>
						     							</div>
						</div>
						
						
						
<!-- 					<div class="form-group" ng-show="venAddress == true"> -->
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
				             <textarea class="text-left form-control input-sm" data-ng-model="purchaseOrder.remarks" rows="4" cols="20" style="resize: none"> </textarea>
				            </div>
				         </div> 
				         
				         <div class="form-group">
					            <label class="col-md-4 control-label"> Payment Terms
					            </label>
					            <div class="col-md-5">
					             <input class="text-right form-control input-sm" ng-model="purchaseOrder.paymentTerms" ng-pattern-restrict="{{numExp}}" />
					            </div>
					             <span class="pull-left line-height-30">Days</span>
					        </div>	  
        		</div>
        		</fieldset>
        		<div class="col-sm-12 col-md-12 col-lg-12"><br>
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
			             <input type="checkbox"  ng-model="selectedAll" ng-change="checkAllItem(rowCollectionItem,selectedAll)">
			             <i></i>
			            </label>
			           </th>
			           <th class="sorting width_14">Item Code-Item Name</th>
			           <th class="sorting width_10" >Purchase Quote Number</th>
			           <th class="sorting width_6" >EDD</th>
			           <th class="sorting width_6" >Vendor UOM</th>
			           <th class="sorting width_8" >Consignment Qty</th>
			           <th class="sorting width_7"  style="padding: 0 !important;line-height: 34px;">Unit Price</th>
			           <th class="sorting width_8">Old Unit Price</th>
			           <th class="sorting width_8" >Price</th>
			            <th class="sorting width_10" >Discount Type</th>
			           <th class="sorting width_8"  style="padding: 0 !important;line-height: 34px;">Discount</th>
			           <th class="sorting width_7" >Tax Type</th>
			           <th class="sorting width_7" >Tax</th>
			           <th class="sorting width_5" >Total</th>
			          </tr>
			         </thead>
			         <tbody class="dataTables-Main-Body">
			          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-controller="parentCtrl" ng-repeat="departmentCollections in displayedCollectionItem"
			          ng-hide="departmentCollections.edit == '2'">
			           <td >
			           <label class="i-checks m-b-none">
			             <input type="checkbox" ng-model="departmentCollections.select">
			             <i></i>
			            </label></td>
			           <td>{{departmentCollections.purchaseItemName}}</td>
			             <td>{{departmentCollections.purchaseQuoteId}}</td>
			           <td>{{departmentCollections.edd}}</td>
			           <td style="text-align: right;">{{departmentCollections.uomName}}</td>
			           <td><input type="text" ng-model="departmentCollections.quantity"  ng-pattern-restrict="{{numExp}}" ng-keyup="validateQty(departmentCollections.quantity,$index,departmentCollections.duplicateQuantity);"
			           		maxlength="5" placeholder="0" style="width:40px;text-align: right;" ng-init="calculateTaxDiscount(departmentCollections)" disabled="true" 
			           		name="{{ 'quantity' + $index }}" validation="required" friendly-name="{{ 'Row' + $index + '(Quantity)'}}"
			           		style="text-align: right;"></td>
			           <!-- <td><input type="text" ng-model="departmentCollections.quantity" readonly
			           		style="width:40px;text-align: right;"></td> -->
			           <td  style="text-align: right;">{{departmentCollections.unitPrice}}</td>
			           <td style="text-align: right;">{{departmentCollections.oldUnitPrice}}</td>
			           <td  style="text-align: right;">{{departmentCollections.price}}</td>
			           <td  style="text-align: right;">{{departmentCollections.quoteTaxDetail.discountType}}</td>
			           <td  style="text-align: right;">{{departmentCollections.discount}}</td>
			           <td style="text-align: right;">{{departmentCollections.quoteTaxDetail.taxCode}}</td>
			           <td  style="text-align: right;">{{departmentCollections.tax}}</td>
			           <td  style="text-align: right;">{{departmentCollections.finalTotal}}</td>
			             <!--  <td  style="text-align: right;">{{departmentCollections.total}}</td> -->
			           <!-- <td  style="text-align: right;">{{departmentCollections.purchaseStatus}}</td> -->
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
				
				<div class="col-md-12">
        			<div class="form-group">
        				<label class="col-md-1 control-label" style="left:1.4%"> SubTotal </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.subTotal" readonly style="width: 110%;">
						</div>
        				<label class="col-md-1 control-label" style="left:1.4%"> Discount </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalDiscount" readonly>
						</div>
        				<label class="col-md-1 control-label" style="left:1.4%"> Tax </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalTax" readonly>
						</div>
						<label class="col-md-1 control-label" style="left:1.4%"> Freight </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.freight" ng-pattern-restrict="^[0-9.]*$"/>
						</div>
						<label class="col-md-1 control-label" style="left:1.4%"> Total </label>
        				<div class="col-md-1">
							<input type="text" class="form-control input-sm"  ng-model="purchaseOrder.totalAmount" readonly style="width: 110%;">
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
           	Request for Approval
           </button>
           <button class="btn btn-success" type="button"
            class="btn btn-success" id="update"
            data-ng-click="validate(PurchaseOrderForm,purchaseOrder);"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            Update
           </button>
           <button class="btn btn-info" type="button"
            class="btn btn-success" data-ng-hide="isEdit == true"
            data-ng-click="reset();">
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