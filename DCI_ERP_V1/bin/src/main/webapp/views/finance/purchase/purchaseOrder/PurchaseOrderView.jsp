<style>
.main_container{
overflow:auto;
}
.datetimepicker{
width:auto;
}
select{
-webkit-appearance: none;
  padding: 0;
  text-indent: 8px;
  padding : 0 !important;
}
.input-group-addon{
display:none !important;
}
.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
{
 background-color:white !important;
 border:0px !important;
}
.b-grey{
border:0px !important;
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
       <form class="form-horizontal" name="PurchaseOrderForm">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
         <div class="col-md-6">
         <fieldset ng-disabled="true">
         	<div class="form-group">
        				<label class="col-md-5 control-label"> Purchase Order No
        				</label>
        				<div class="col-md-4">
							<input type="text" class="form-control input-sm" data-ng-model="purchaseOrder.purchaseOrderNum">
						</div>
						</div>
						
						<div class="form-group">
				            <label class="col-md-5 control-label"> Purchase For </label>
				            <div class="col-md-4">
				            <select class="form-control input-sm" id="purchaseFor" name="purchaseFor" data-ng-model="purchaseOrder.purchaseFor"
							        	data-ng-options="ac.id as ac.text for ac in purchaseForList">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div>
						
						<div class="form-group">
	        				<label class="col-md-5 control-label"> Hospital </label>
	        				<div class="col-md-4">
	        				 <select class="form-control input-sm" id="hospital" name="hospital" data-ng-model="purchaseOrder.companyId"
							        	data-ng-options="ac.id as ac.text for ac in hospitalList">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
						</div>
						</div>
						
						<div class="form-group">
	        				<label class="col-md-5 control-label"> Destination Location </label>
	        				<div class="col-md-4">
	        				<select class="form-control input-sm" id="location" name="location" data-ng-model="purchaseOrder.locationId"
							        	data-ng-options="ac.id as ac.text for ac in addressList" ng-change="loadDestAddress()">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
								</div>
						</div>
						
						<div class="form-group">
				            <label class="col-md-5 control-label"> Destination Address
				            </label>
				            <div class="col-md-6">
				             <div class="col-md-12 b b-grey no-padding">
				             <label class="col-md-12 control-label" style="text-align:left !important"> {{purchaseData.desAddress}}, {{purchaseData.desCity}} , {{purchaseData.desState}},{{purchaseData.desZipcode}} , {{purchaseData.desCountry}}.</label>
				            </div>
				            </div>
			            </div>
						
        			</fieldset>
        	</div>
        	
        	<div class="col-md-6">
        	<fieldset ng-disabled="true">
        		<div class="form-group">
        				<label class="col-md-3 control-label"> PO Date </label>
        				<div class="col-md-4">
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
				            <label class="col-md-3 control-label"> Purchase Type </label>
				            <div class="col-md-4">
				            <select class="form-control input-sm" id="purchaseType" name="purchaseType" data-ng-model="purchaseOrder.purchaseType"
							        	data-ng-options="ac.id as ac.text for ac in purchaseTypeList" disabled>
							          	<option value="" selected="selected">--Select--</option>
						     </select>
				            </div>
			             </div>
						
						<div class="form-group">
			      				<label class="col-md-3 control-label"> Status
			      				</label>
			      				<div class="col-md-4">
			      				<select class="form-control input-sm" id="Status" name="Status" data-ng-model="purchaseOrder.statusId"
							        	data-ng-options="ac.id as ac.text for ac in statusList" disabled>
							          	<option value="" selected="selected">--Select--</option>
						     </select>
															</div>
						</div>
						
						<div class="form-group">
	        				<label class="col-md-3 control-label"> Vendor </label>
	        				<div class="col-md-4">
	        				<select class="form-control input-sm" id="Vendor" name="Vendor" data-ng-model="vendor"
							        	data-ng-options="ac as ac.text for ac in vendorList" ng-change="loadVendorAddress()">
							          	<option value="" selected="selected">--Select--</option>
						     </select>
						     							</div>
						</div>
						
						
						<div class="form-group">
				            <label class="col-md-3 control-label"> Vendor Address
				            </label>
				            <div class="col-md-6">
				             <div class="col-md-12 b b-grey no-padding">
				             <label class="col-md-12 control-label" style="text-align:left !important"> {{purchaseData.desAddress1}}, {{purchaseData.desCity1}} , {{purchaseData.desState1}},{{purchaseData.desZipcode1}} , {{purchaseData.desCountry1}}.</label>
				            </div>
				            </div>
			            </div>
			        </fieldset>    
        		</div>
        		
        		<div class="col-md-12">
         			<fieldset>
						<div class="form-group">
				            <label class="col-md-2 control-label margin-left-4-2"> Terms & Conditions
				            </label>
				            <label class="col-md-9 control-label" style="text-align:left;">{{purchaseOrder.termsCondition}}</label>
			            </div>
		            
						<div class="form-group">
				            <label class="col-md-2 control-label margin-left-4-2"> Remarks
				            </label>
				             <label class="col-md-9 control-label" style="text-align:left;">{{purchaseOrder.remarks}}</label>
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
			        <table id="dt_basic"
			         class="table table-striped table-bordered table-hover dataTable no-footer"
			         role="grid" aria-describedby="dt_basic_info">
			         <thead class="dataTables-Main-Head">
			          <tr>
			           <th class="sorting width_10" >Item Code-Item Name</th>
			           <th class="sorting width_6" >EDD</th>
			           <th class="sorting width_6" >UOM</th>
			           <th class="sorting width_5" >Qty</th>
			           <th class="sorting width_7" >Unit Price</th>
			           <th class="sorting width_8" >Price</th>
			           <th class="sorting width_8" >Discount</th>
			           <th class="sorting width_8" >Total</th>
			           <th class="sorting width_7" >Tax</th>
			           <th class="sorting width_8" >Final Total</th>
			           <th class="sorting width_7" >Status</th>
			           <!-- <th class="sorting width_10" data-st-sort="">Item Description</th> -->
			           <!-- <th class="sorting width_7" data-st-sort="">Vendor Item Name</th> -->
			           <!--  <th class="sorting width_7" data-st-sort="">Delivery Lead Time</th> -->
			            <%-- <th class="width_8 table-heading text-center"><spring:message code="label.action"></spring:message></th> --%>
			          </tr>
			         </thead>
			         <tbody class="dataTables-Main-Body">
			          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="departmentCollections in displayedCollectionItem"
			          ng-hide="departmentCollections.edit == '2'">
			           <td>{{departmentCollections.purchaseItemName}}</td>
			           <td>{{departmentCollections.edd}}</td>
			           <td>{{departmentCollections.uomName}}</td>
			           <td ng-init="calculateTaxDiscount(departmentCollections)"  style="text-align: right;">{{departmentCollections.quantity}}</td>
			           <td  style="text-align: right;">{{departmentCollections.unitPrice}}</td>
			           <td  style="text-align: right;">{{departmentCollections.price}}</td>
			           <td  style="text-align: right;">{{departmentCollections.discount}}</td>
			           <td  style="text-align: right;">{{departmentCollections.total}}</td>
			           <td  style="text-align: right;">{{departmentCollections.tax}}</td>
			           <td  style="text-align: right;">{{departmentCollections.finalTotal}}</td>
			           <td>{{departmentCollections.purchaseStatus}}</td>
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
				
				<div class="col-md-11">
        			<div class="form-group">
        				<label class="col-md-1 control-label"> SubTotal :</label>
        				<label class="col-md-1 control-label">{{purchaseOrder.subTotal}}</label>
        				<label class="col-md-1 control-label"> Discount :</label>
        				<label class="col-md-1 control-label">{{purchaseOrder.totalDiscount}}</label>
        				<label class="col-md-1 control-label"> Tax :</label>
        				<label class="col-md-1 control-label">{{purchaseOrder.totalTax}}</label>
						<label class="col-md-1 control-label"> Freight :</label>
        				<label  class="col-md-1 control-label">{{purchaseOrder.freight}}</label>
						<label class="col-md-1 control-label"> Total :</label>
        				<label class="col-md-1 control-label">{{purchaseOrder.totalAmount}}</label>
					</div>
        		</div>
        			
        	 </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
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