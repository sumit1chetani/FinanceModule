<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
	      <span class="widget-icon"> <i class="fa fa-table"></i></span>
	      <h2> Quality Check Details </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="grnQcPopup">
        <div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
        	<div class="form-group">
      			<label class="col-md-4 control-label">Item
      			<spring:message code="label.asterisk.symbol"></spring:message></label>
      			<div class="col-md-8">
					<input type="text" class="form-control input-sm" data-ng-model="grnQCData.dtlItemDesc" name="dtlItemDes" friendly-name="Item" form-name = "grnQcPopup" readonly />
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-4 control-label">Sample Qty<spring:message code="label.asterisk.symbol"></spring:message></label>
        		<div class="col-md-8">
					<input type="text" id="retailPrice" class="form-control input-sm " data-ng-model="grnQCData.sampleQty" ng-blur="qcamountChange(grnQCData.sampleQty)"
					 validation="required" ng-pattern-restrict="^[0-9.]*$"  name="sampleQty" friendly-name="Sample Qty" form-name ="grnQcPopup"
					style="text-align: right;" />
				</div>
        	</div>

        	<div class="form-group">
        		<label class="col-md-4 control-label">Status<spring:message code="label.asterisk.symbol"></spring:message></label>
        		<div class="col-md-8">
					<select class="form-control input-sm" data-ng-model="grnQCData.qcStatus"  
					 validation="required" name="qcStatus" friendly-name="Status" form-name = "grnQcPopup">
						<option value>Select</option>
						<option value=146>Pass</option>
						<option value=148>Fail</option>
					</select>
				</div>
        	</div>
        	<div class="form-group">
        		<label class="col-md-4 control-label">Remarks</label>
        		<div class="col-md-8" style="border:0px solid red;	width: 222px; ">
					<textarea class="form-control input-sm" name="Address" id="Address" maxlength="150" data-ng-model="grnQCData.qcRemarks"  style="min-width:222px"></textarea>
				</div>
        	</div>
          </fieldset>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="saveQCDtls(grnQCData,grnQcPopup)" data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="saveQCDtls(grnQCData,grnQcPopup)"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-info" type="button"
            data-ng-click="resetdetail()" >
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