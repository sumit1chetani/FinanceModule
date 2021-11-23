<!-- #MAIN CONTENT -->
<div>
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" >
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs>  </span>
					</header>
					<div role="content">
						<div class="widget-body">
       <form class="form-horizontal" name="taxSectionForm" >
        <div class="row">
        
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
           <div class="form-group">
            <label class="col-md-6 control-label">
             Tax Section Code
             <span style="color: red;">*</span>
            </label>
            <div class="col-md-3">
            <input type="text" class="form-control input-sm" name="Tax Section Code" ng-if="!taxSection.isEdit"
              ng-model="taxSection.taxSectionCode" validation="required" friendly-name="Tax Section Code" />
              <input type="text" class="form-control input-sm" name="Tax Section Code" ng-if="taxSection.isEdit"
              ng-model="taxSection.taxSectionCode" validation="required" friendly-name="Tax Section Code" readonly />
            </div>
           </div>
         
            <div class="form-group">
            <label class="col-md-6 control-label">
            Description 
           
            </label>
            <div class="col-md-3">
             <input type="text" class="form-control input-sm" 
              data-ng-model="taxSection.taxSectionDescription" name="Description"  data-message-id="taxSectionDescription" />
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-6 control-label">
            Max. Limit
            <span style="color: red;">*</span>
            </label>
            <div class="col-md-3">
            <input type="text" class="form-control input-sm" name="Max.Limit"
              ng-model="taxSection.taxSectionMaxLimit" validation="required" friendly-name="Max.Limit" />
            </div></div>
                    <div class="form-group">
            <label class="col-md-6 control-label">
           Display Order
            
            </label>
            <div class="col-md-3">
             <input type="text" class="form-control input-sm" name="Display Order"
              data-ng-model="taxSection.displayOrder" />
            </div></div>
             <div class="form-group">
            <label class="col-md-6 control-label">
            Active
            
            </label>
            <div class="col-md-6">
             <div class="checkbox">
              <label>
               <input type="checkbox" class="checkbox style-0"  
                ng-model="taxSection.taxSectionStatus"  name="active">
               <span></span>
              </label>
             </div>
            </div></div>
          
           </fieldset></div></div>
             <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-click="submit(taxSectionForm)" data-ng-if="!taxSection.isEdit" >
            <i class="fa fa-save"></i>
            Save
           </button>
          <button class="btn btn-success"  type="button" data-ng-click="update(taxSectionForm)"
												data-ng-if="taxSection.isEdit" >
        <i class="fa fa-save"></i>
       Update
       </button>
         <button class="btn btn-info" type="reset" class="btn btn-success" ng-click="reset()">
        <i class="fa fa-undo"></i>
        Reset
       </button> 
       <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
        <i class="fa fa-close"></i>
       Cancel
       </button>
          </div>
         </div>
        </div>
           </form></div>
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