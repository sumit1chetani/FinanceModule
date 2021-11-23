<!-- #MAIN CONTENT -->
<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
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
   <form class="form-horizontal" name="branchMasterForm">
    <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>
        <!-- Comapny Name -->
         <div class="form-group">
       	 		<label class="col-md-4 control-label"><spring:message
			              			code="label.company.name"></spring:message></label>
       			 <div class="col-md-6 inputGroupContainer">
        		<select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" style="width:269px;">
       			 <option value="">--select--</option>
               
             	 </select>           
              
        	</div>
       </div>
       <div class="form-group">
       	 		<label class="col-md-4 control-label">Department Name </label>
       			 <div class="col-md-6 inputGroupContainer">
        		<select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" style="width:269px;">
       			 <option value="">--select--</option>
               
             	 </select>           
              
        	</div>
       </div>
      
       <div class="form-group">
       	 		<label class="col-md-4 control-label">Purpose Of Singnature </label>
       			 <div class="col-md-6 inputGroupContainer">
        		<select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" style="width:269px;">
       			 <option value="">--select--</option>
               
             	 </select>           
              
        	</div>
       </div>


 
      </fieldset>
     </div>
     
     
     
     
     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>
        
       <!-- Branch Name -->
     <div class="form-group">
       	 		<label class="col-md-4 control-label">Branch Name </label>
       			 <div class="col-md-6 inputGroupContainer">
        		<select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" style="width:269px;">
       			 <option value="">--select--</option>
               
             	 </select>           
              
        	</div>
       </div>
      <div class="form-group">
       	 		<label class="col-md-4 control-label">Employee Name </label>
       			 <div class="col-md-6 inputGroupContainer">
        		<select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" style="width:269px;">
       			 <option value="">--select--</option>
               
             	 </select>           
              
        	</div>
       </div>
       <div class="form-group">
       	 		<label class="col-md-4 control-label">Authorizer </label>
       			 <div class="col-md-6 inputGroupContainer">
        		<select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" style="width:269px;">
       			 <option value="">--select--</option>
               
             	 </select>           
              
        	</div>
       </div>

       
       
      
      
      
      </fieldset>
     </div>
     
     		 <div class="col-sm-12 col-md-12 col-lg-12" style="border:0px solid red">
                     
        <div class="col-md-6">
		      
		       <div>
		       	 <label class="col-md-4 control-label">
		    		Upload Singnature
		        	</label>
		       		 <div class="col-md-4">
		          <input type="text" class="form-control input-sm" ng-model="branchMaster.sectorName" name="sector Name"/> 
		         </div>
		       </div>
<!-- 		       <div class="col-md-2"> -->
		      		<button class="btn btn-success "  type="submit">
		    		 <i class="fa fa-save"></i>Browse
		     	 </button>
<!-- 		     	 </div> -->
		      
		      </div>
      			</div>
    </div>
  
     <div class="form-actions">
     <div class="row">
      <div class="col-md-35">
       <button class="btn btn-success"  type="submit">
          <i class="fa fa-save"></i>
          Save
         </button>
         <button class="btn btn-success"
            ng-if="containerValidateData.isEdit" type="submit">
            <i class="fa fa-save"></i> Update
           </button>
        <button   class="btn btn-info"  type="button" data-ng-click="reset(designationForm)" >
       											 <i class="fa fa-undo"></i>
    										    <spring:message code="label.reset">Reset</spring:message>
     										  </button>
         <button class="btn btn-danger" data-ng-click="cancel();"type="button">
                 <i class="fa fa-close"></i>
                 Cancel
                </button>
      </div>
     </div>
    </div>
   </form>
   </div>
   </div>
   </div>
   </article>
   </div>
   </section>
   </div>
   
   
   
   