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
        <label class="col-md-6 control-label">Company  </label>
        <div class="col-md-4">
        <select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" >
        <option value="">--select--</option>
               
              </select>           
              
        </div>
       </div>
         
              <div class="form-group">
        <label class="col-md-6 control-label">Branch  </label>
        <div class="col-md-4">
        <select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" >
        <option value="">--select--</option>
               
              </select>           
              
        </div>
       </div>
        <div class="form-group">
        <label class="col-md-6 control-label">Department  </label>
        <div class="col-md-4">
        <select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" >
        <option value="">--select--</option>
               
              </select>           
              
        </div>
       </div>
        <div class="form-group">
        <label class="col-md-6 control-label">Employee  </label>
        <div class="col-md-4">
        <select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode">
        <option value="">--select--</option>
               
              </select>           
              
        </div>
       </div>
         <div class="form-group">
        <label class="col-md-6 control-label">Head Name  </label>
        <div class="col-md-4">
        <select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" >
        <option value="">--select--</option>
               
              </select>           
              
        </div>
       </div>
           <div class="form-group">
            <label class="col-md-6 control-label">
           Amount
            </label>
            <div class="col-md-4">
             <input type="text" class="form-control input-sm" name="Max. Limit"
              data-ng-model="maxLmt" />
            </div></div>
                
           
             
           </fieldset></div></div>
             <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="add" data-ng-if="!isEdit == true">
            <i class="fa fa-save"></i>
            Save
           </button>
          <button class="btn btn-success"  type="button" data-ng-click="update()"
												data-ng-if="isEdit == true" >
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