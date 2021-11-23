<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>
       Add Asset Maintenance
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="assetMaintenanceForm" novalidate method="post">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
          <fieldset>
           <div class="form-group">
            <label class="col-md-5 control-label"> Maintenance Type Code<span style="color: red;">*</span>
            </label>
            <div class="col-md-6">
             <input type="text" class="form-control input-sm" ng-model="assetMaintenance.assetCode" name="assetCode" data-message-id="assetCode"  validator="required"  data-valid-method="save" >
		     </div>
           </div>

		<div class="form-group">
            <label class="col-md-5 control-label"> Maintenance Type Name
            </label>
            <div class="col-md-6">
             <input type="text" class="form-control input-sm" ng-model="assetMaintenance.assetName" name="assetName" data-message-id="assetName"   data-valid-method="save" >
		     </div>
           </div>
           <div class="form-group">
            <label class="col-md-5 control-label"> Description
            </label>
            <div class="col-md-6">
             <textarea class="form-control input-sm" ng-model="assetMaintenance.description" name="description" data-message-id="description"  data-valid-method="save" >
		     </textarea></div>
           </div>
           
           <div class="form-group">
       								<label class="col-md-5 control-label">Is Active</label>
        							<div class="col-md-6">	
        								<div class="checkbox">
            								<label>
		             							<input class="checkbox style-0" type="checkbox" ng-model="assetMaintenance.active"><span></span>
		           							</label> 	
              			 				</div>
									</div>
       							</div>
          </fieldset>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           
           <button class="btn btn-success" type="submit" ng-if="!isEdit" data-ng-click="save(assetMaintenanceForm)">
								<i class="fa fa-save"></i> <spring:message code="label.save"></spring:message>
							</button>
							<button class="btn btn-success" type="submit" ng-if="isEdit" data-ng-click="update(assetMaintenanceForm)">
								<i class="fa fa-save"></i> <spring:message code="label.update"></spring:message>
							</button>
             			 	<button class="btn btn-info ng-scope" type="button" 
				           		class="btn btn-success" ng-click="reset(assetMaintenanceForm)">
								<i class="fa fa-undo"></i> <spring:message code="label.reset"></spring:message>
							</button>
							<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
				          		<i class="fa fa-close"></i> <spring:message code="label.cancel"></spring:message>
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