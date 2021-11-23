<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
	      <span class="widget-icon"> <i class="fa fa-table"></i></span>
	      <h2> Add Product Details </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="subGroupAccountForm">
        <div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
          <div class="form-group">
        		<label class="col-md-6 control-label"> Item Code </label>
        		<div class="col-md-6">
					<input type="text" class="form-control input-sm">
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-6 control-label"> Item Name </label>
        		<div class="col-md-6">
					<input type="text" class="form-control input-sm">
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-6 control-label"> Item Category </label>
        		<div class="col-md-6">
					<select class="form-control input-sm">
					  <option value="">Select</option>
					</select>
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-6 control-label"> Item Description </label>
        		<div class="col-md-6" style="border:0px solid red;	width: 185px; ">
					<textarea class="form-control input-sm" name="Address" id="Address" maxlength="150" data-ng-model="RefHospitalMasterData.address" message-id="Address" validator="required"></textarea>         
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-6 control-label"> Quantity </label>
        		<div class="col-md-6">
					<input type="text" class="form-control input-sm" ng-pattern-restrict="{{numExp}}">
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-6 control-label"> Unit of Measure </label>
        		<div class="col-md-6">
					<select class="form-control input-sm">
					  <option value="">Select</option>
					</select>
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-6 control-label"> Destination Location </label>
        		<div class="col-md-6">
					<input type="text" class="form-control input-sm">
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-6 control-label"> EDD </label>
        		<div class="col-md-6">
					<input type="text" class="form-control input-sm">
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-6 control-label"> Status </label>
        		<div class="col-md-6">
					<select class="form-control input-sm">
					  <option value="">Select</option>
					  <option value="">Received</option>
					  <option value="">Verified</option>
					</select>
				</div>
        	</div>
          </fieldset>
         </div>
        </div>
        <div class="form-actions">
	         <div class="row">
	          <div class="col-md-12">
		           <button class="btn btn-success" type="button"
		            data-ng-click="save(subGroupAccountForm)" data-ng-if="!isEdit">
		            <i class="fa fa-save"></i>
		            <spring:message code="label.save"></spring:message>
		           </button>
		           <button class="btn btn-success" type="button"
		            data-ng-click="update(subGroupAccountForm);"
		            data-ng-if="isEdit == true">
		            <i class="fa fa-save"></i>
		            <spring:message code="label.update"></spring:message>
		           </button>
		           <button class="btn btn-info" type="button"
		            data-ng-click="reset(subGroupAccountForm)">
		            <i class="fa fa-undo"></i>
		            <spring:message code="label.reset"></spring:message>
		           </button>
		           <button class="btn btn-danger" type="button"
		            data-ng-click="ngcancel();">
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