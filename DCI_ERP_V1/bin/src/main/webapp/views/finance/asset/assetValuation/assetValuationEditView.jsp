<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
	      <span class="widget-icon"> <i class="fa fa-table"></i></span>
	      <h2> Asset Valuation Edit </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="assetValPopup">
        <div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
        	<div class="form-group">
      			<label class="col-md-6 control-label">Amount Appreciated
      			</label>
      			<div class="col-md-6">
					<input type="text" class="form-control input-sm" data-ng-model="assetValCData.amtaggr1" readonly />
				</div>
        	</div>
        	<div class="form-group">
      			<label class="col-md-6 control-label">Amount Depreciated
      			</label>
      			<div class="col-md-6">
					<input type="text" class="form-control input-sm" data-ng-model="assetValCData.amtdep1" readonly />
				</div>
        	</div>
        	<div class="form-group">
      			<label class="col-md-6 control-label">Factor
      			</label>
      			<div class="col-md-6">
					<input type="text" class="form-control input-sm" data-ng-model="assetValCData.aggressiveFactor1" />
				</div>
        	</div>
        	<div class="form-group">
      			<label class="col-md-6 control-label">Current Value
      			</label>
      			<div class="col-md-6">
					<input type="text" class="form-control input-sm" data-ng-model="assetValCData.currValue1" readonly />
				</div>
        	</div>
        	<div class="form-group">
      			<label class="col-md-6 control-label">After Valuation
      			</label>
      			<div class="col-md-6">
					<input type="text" class="form-control input-sm" data-ng-model="assetValCData.afterValuation1" readonly />
				</div>
        	</div>
        	
          </fieldset>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="saveDtls()" data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="saveDtls()"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-info" type="button"
            data-ng-click="resetDtls(assetValCData)">
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