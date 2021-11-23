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
      
       <div class="form-group">
        <label class="col-md-4 control-label ">Approval Creation For </label>
        <div class="checkbox">
												<label> <input type="checkbox"
													class="checkbox style-0" ng-model="companyMaster.status"
													data-ng-true-value="'Y'" data-ng-false-value="'N'">
													<span></span> </label>
											</div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label ">Final Approval Name </label>
        </div>
     
         <div class="form-group">
        <label class="col-md-4 control-label"><spring:message
			              			code="label.company.name"></spring:message> </label>
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
     
     
     
   
         

 
      </fieldset>
     </div>
     
     
     
     
     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>
          
          <div class="form-group"></div>
          <div class="form-group"></div>
          <div class="form-group"></div>
          <div class="form-group"></div>
          <div class="form-group"></div>
          <div class="form-group">
        <label class="col-md-4 control-label">Branch Name </label>
        <div class="col-md-6 inputGroupContainer">
        <select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" style="width:269px;">
        <option value="">--select--</option>
               
              </select>           
              
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label">Employee No </label>
        <div class="col-md-6 inputGroupContainer">
        <select  class="form-control journalVoucher-textBox" ng-model="branchMaster.companyCode" name="companyCode" style="width:269px;">
        <option value="">--select--</option>
               
              </select>           
              
        </div>
       </div>
      
       
     
     
      
       
         
    
      
      
      
      </fieldset>
     </div>
    </div>
    <!-- end roow -->
    <div class="row">
    		  <div class="col-sm-12 col-md-12 col-lg-12" style="border:0px solid red">
    		  
    		    <div class="form-group">
        			<label class="col-md-5 col-md-offset-2">Applicable Companies </label>
       		 	
      				 </div>
       				<div class="form-group" style="border:0px solid red">
       				
       					<div class="col-md-5 col-md-offset-3" style="border:0px solid red">
            	 	<input type="checkbox" value="">Tolani Shipping Company Ltd 
              
        				</div>
      				 </div>
      				  <div class="form-group ">
        			<label class="col-md-5 col-md-offset-2">Applicable Branches </label>
       		 	
      				 </div>
      				 
      				   <div class="form-group">
      		  
       	 			<div class="col-md-7 col-md-offset-3" >
        			 <textarea rows="3" cols="70"> </textarea>
        			 <!-- <input type="text" class="form-control input-sm"ng-model="branchMaster.branchName" id="branchName" /> -->
       		 	</div>
      		 </div>
    		  
    		   <div class="form-group ">
        			<label class="col-md-5 col-md-offset-2">Applicable Departments </label>
       		 	
      				 </div>
      				 
      				   <div class="form-group">
      		  
       	 			<div class="col-md-7 col-md-offset-3" >
        			 <textarea rows="3" cols="70"> </textarea>
        			 <!-- <input type="text" class="form-control input-sm"ng-model="branchMaster.branchName" id="branchName" /> -->
       		 	</div>
      		 </div>
    		  <div class="form-group ">
        			<label class="col-md-5 col-md-offset-2">Applicable Employee </label>
       		 	
      				 </div>
      				 
      				   <div class="form-group">
      		  
       	 			<div class="col-md-7 col-md-offset-3" >
        			 <textarea rows="3" cols="70"> </textarea>
        			 <!-- <input type="text" class="form-control input-sm"ng-model="branchMaster.branchName" id="branchName" /> -->
       		 	</div>
      		 </div>
    		
    		  </div>
    
    </div>
    
  
    <div class="form-actions" style="border:0px solid red">
       <div class="row">
        <div class="col-md-12">
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
   
   
   
   