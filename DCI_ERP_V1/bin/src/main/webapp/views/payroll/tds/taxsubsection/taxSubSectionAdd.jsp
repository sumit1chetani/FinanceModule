<!-- #MAIN CONTENT -->
<div>
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" >
					<header >
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs>  </span>
					</header>
					<div role="content">
						<div class="widget-body">
       <form class="form-horizontal" name="taxSubSectionForm" >
        <div class="row">
        
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
           <div class="form-group">
            <label class="col-md-6 control-label">
             Sub Section Code
             <span style="color: red;">*</span>
            </label>
            <div class="col-md-3">
            <input type="text" class="form-control input-sm" name="Tax Section Code" ng-if="!taxSubSection.isEdit"
              ng-model="taxSubSection.taxSubSectionCode" validation="required" friendly-name="Sub Section Code" />
              <input type="text" class="form-control input-sm" name="Tax Section Code" ng-if="taxSubSection.isEdit"
              ng-model="taxSubSection.taxSubSectionCode" validation="required" friendly-name="Sub Section Code" readonly />
            </div>
           </div>
         
            <div class="form-group">
            <label class="col-md-6 control-label">
            Description 
           
            </label>
            <div class="col-md-3">
            <input type="text" class="form-control input-sm" name="Description"
              ng-model="taxSubSection.taxSubSectionDescription" validation="required" friendly-name="Description" />
            </div>
           </div>
            <div class="form-group">
	            <label class="col-md-6 control-label">
	           Tax Section Code
	            
	            </label>
	            <div class="col-md-3">
	            	 <select class="form-control" data-ng-model="taxSubSection.taxSectionCode" data-ng-if="!taxSubSection.isEdit" ng-options="master.taxSectionCode as master.taxSectionCode for master in taxSectionList">
			       <option value=""> --Select--</option>
					</select>
	                <input type="text" class="form-control input-sm" 
              data-ng-model="taxSubSection.taxSectionCode" data-ng-if="taxSubSection.isEdit" name="Tax Section Code" validation="required" friendly-name="Tax Section Code" readonly>
            </div>
	            </div>
          
            <div class="form-group">
            <label class="col-md-6 control-label">
            Max. Limit
            
            </label>
            <div class="col-md-3">
             <input type="text" class="form-control input-sm" name="Max. Limit"
              data-ng-model="taxSubSection.taxSubSectionMaxLimit" />
            </div></div>
                    <div class="form-group">
            <label class="col-md-6 control-label">
           Display Order
            
            </label>
            <div class="col-md-3">
            <input type="text" class="form-control input-sm" name="Display Order"
              ng-model="taxSubSection.displayOrder" validation="required" friendly-name="Display Order" />
            </div></div>
          <div class="form-group">
            <label class="col-md-6 control-label">
           Is Computed
            
            </label>
            <div class="col-md-6">
             <div class="checkbox">
              <label>
               <input type="checkbox" class="checkbox style-0"  
                ng-model="taxSubSection.computed"  name="Is Computed"   data-ng-true-value="true" data-ng-false-value="false" readonly>
               <span></span>
              </label>
             </div>
            </div></div>
             <div class="form-group">
            <label class="col-md-6 control-label">
            Active
            
            </label>
            <div class="col-md-6">
             <div class="checkbox">
              <label>
               <input type="checkbox" class="checkbox style-0"  
                ng-model="taxSubSection.taxSubSectionStatus"  name="active"   data-ng-true-value="true" data-ng-false-value="false">
               <span></span>
              </label>
             </div>
            </div></div>
          
           </fieldset></div></div>
             <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="add" data-ng-if="!taxSubSection.isEdit == true">
            <i class="fa fa-save"></i>
            Save
           </button>
          <button class="btn btn-success"  type="button" data-ng-click="update(taxSubSectionForm)"
												data-ng-if="taxSubSection.isEdit == true" >
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