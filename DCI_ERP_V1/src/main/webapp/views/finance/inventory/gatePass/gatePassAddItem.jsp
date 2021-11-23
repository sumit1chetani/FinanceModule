<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz">
     <header class="ngdialog-header">
	      <span class="widget-icon"> <i class="fa fa-table"></i></span>
	      <h2 data-ng-if="isEdit == false">Add Gate Pass Item</h2>
	        <h2 data-ng-if="isEdit == true">Edit Gate Pass Item</h2>
     </header>
     <div role="content">
      <div class="widget-body"> --%>
      
      
      <div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
       <form class="form-horizontal" name="gatePassItemForm">
        <div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
          
          <div class="form-group" >
			   <label class="col-md-4 control-label">Item Name</label>
			   	<div class="col-md-8">
					
				
				<!-- <selectivity list="itemList" 
															ng-model="gatePassAddItem.itemname"
															property="gatePassAddItem.itemname"
															id="item" object="itemObj"
															name="item" validation="required"
															friendly-name="item"
															form-name="gatePassItemForm"></selectivity> -->
															<input type="text" ng-model="gatePassAddItem.itemname"  property="gatePassAddItem.itemname" 
	           		 class="form-control input-sm text-right" name="quantity"
	           		 form-name = "gatePassItemForm" 
				        				validation="required" friendly-name="gatePassItemForm" phonenumbers-only/>
			</div></div>
					<!-- <div class="form-group"  >
			   <label class="col-md-4 control-label">UOM</label>
			   	<div class="col-md-8">
					<selectivity list="uomCategoryList"  id="uom" validation="required"
				    	ng-model="gatePassAddItem.uom" name="uom" form-name = "gatePassItemForm"
				    
				    		friendly-name="uom"></selectivity>
				    		<selectivity list="uomCategoryList"
															ng-model="gatePassAddItem.uom"
															property="gatePassAddItem.uom"
															id="uom" object="uomObj"
															name="uom" 
															friendly-name="uom" disabled = "true"
															form-name="gatePassItemForm"></selectivity>
				</div>
			</div>	 -->		
           <%-- <div class="form-group">
	            <label class="col-md-6 control-label"> Item Name<spring:message
			              			code="label.asterisk.symbol"></spring:message> </label>
	            <div class="col-md-6">
					<input type="text" class="form-control input-sm" ng-model="gatePassAddItem.itemname" name="itemname" form-name = "gatePassItemForm"
				        				validation="required" friendly-name="Item Name" >
				</div>
           </div> --%>
          <%--  <div class="form-group">
				<label class="col-md-6 control-label"> S.No/Batch No <spring:message
			              			code="label.asterisk.symbol"></spring:message></label>
				<div class="col-md-6">
					<input type="text" class="form-control input-sm" ng-model="gatePassAddItem.serialno"  name="serialno" form-name = "gatePassItemForm"
				        				validation="required" friendly-name="S.No/Batch No" >
				</div>
			</div> --%>
			<div class="form-group">
	           	<label class="col-md-4 control-label">Available Quantity </label>
	           	<div class="col-md-8">
	           		<input type="text" ng-model="gatePassAddItem.availQuantity"  property="gatePassAddItem.availQuantity" 
	           		 class="form-control input-sm text-right" name="availQuantity"
	           		 disabled = "true"
	           		 form-name = "gatePassItemForm" friendly-name="availQuantity" phonenumbers-only/>
	           	</div>
           </div>
			<div class="form-group">
	           	<label class="col-md-4 control-label"> Quantity </label>
	           	<div class="col-md-8">
	           		<input type="text" ng-model="gatePassAddItem.quantity"  property="gatePassAddItem.quantity" 
	           		 class="form-control input-sm text-right" name="quantity"
	           		 form-name = "gatePassItemForm" 
				        				validation="required" friendly-name="Quantity" phonenumbers-only/>
	           	</div>
           </div>
          <!--  <div class="form-group">
			   <label class="col-md-4 control-label">Alternate UOM</label>
			   	<div class="col-md-8">
					<selectivity list="uomCategoryList" property="gatePassAddItem.altuom" id="altuom" 
				    	ng-model="gatePassAddItem.altuom" name="altuom" form-name = "gatePassItemForm"
				    	
				    		friendly-name=" Alternate UOM"></selectivity>
				</div>
			</div> -->	
			<div class="form-group">
	           	<label class="col-md-4 control-label">Alternate Quantity </label>
	           	<div class="col-md-8">
	           		<input type="text" ng-model="gatePassAddItem.altquantity"  class="form-control input-sm text-right" name="altquantity" form-name = "gatePassItemForm"
				        				friendly-name="Alternate Quantity" phonenumbers-only/>
	           	</div>
           </div>
           
		<div class="form-group">
			<label class="col-md-4 control-label"> Approximate Value </label>
				<div class="col-md-8">
					<input type="text" class="form-control input-sm text-right" ng-model="gatePassAddItem.value" name="value" data-message-id="gatePassName" data-valid-method="save" ng-pattern-restrict="{{numExp}}">
				</div>
		</div>
		<div class="form-group">
			<label class="col-md-4 control-label">Description</label>
				<div class="col-md-8">
					<input type="text" class="form-control input-sm text-left" ng-model="gatePassAddItem.description1" name="description" data-message-id="description" data-valid-method="save">
				</div>
		</div>
      </fieldset>
    </div>
  	</div>
	<div class="form-actions">
   <div class="row">
      <div class="col-md-12">
         <button class="btn btn-success" type="button" data-ng-if="!isItemEdit" ng-click="saveAddItem(gatePassItemForm,gatePassAddItem)"  class="btn btn-success">
	          <i class="fa fa-save"></i>Save
         </button>
         <button class="btn btn-success" type="button" data-ng-if="isItemEdit == true" class="btn btn-success" ng-click="updateAddItem(gatePassItemForm,gatePassAddItem,editRowIndex)">
	          <i class="fa fa-save"></i>Update
         </button>
         <button type="reset" class="btn btn-info" ng-click="resetAddItem(gatePassAddItem)">
	          <i class="fa fa-undo"></i>Reset
         </button>
         <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancelAddItem()">
	          <i class="fa fa-close"></i>Cancel
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