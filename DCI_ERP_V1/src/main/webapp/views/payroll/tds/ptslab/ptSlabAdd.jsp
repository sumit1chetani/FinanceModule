<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
 <!-- widget grid -->
 <section widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz" data-widget-editbutton="false" data-widget-deletebutton="false">
      <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
           <form class="form-horizontal" name="vesselMasterForm" role="form" ng-submit="#" novalidate>
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-6" style="margin-top:15px;">
          <div class="form-group">
        <label class="col-md-4 control-label"><spring:message
			              			code="label.company.name"></spring:message>  <span style="color: red;">*</span></label>
        
        <div class="col-md-5 inputGroupContainer">
         <select  class="form-control journalVoucher-textBox" ng-if="ptSlab.isAuthorize" ng-model="ptSlab.companyId" ng-options="master.companyId as master.companyName for master in companyList"
														  ng-change="getBranchList(ptSlab.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select>
			   
			   <input type="text" class="form-control input-sm" ng-if="!ptSlab.isAuthorize" ng-model="ptSlab.companyName" readonly/>                      	 	
			                       	 	
       </div>
       </div>
       	<div class="form-group">
        <label class="col-md-4 control-label">
        Range From
          <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input
          type="text"class="form-control input-sm"ng-model="ptSlab.rangeFrom" />
        
        </div></div>
        	  <div class="form-group">
        <label class="col-md-4 control-label">
        Charge
          <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input
          type="text"class="form-control input-sm"ng-model="ptSlab.charge"/>
        
        </div></div>
       </div>
     	
     	<div class="col-sm-12 col-md-12 col-lg-6"style="margin-top:15px;" >
	  	<div class="form-group">
        <label class="col-md-4 control-label">Branch  <span style="color: red;">*</span></label>
        
        <div class="col-md-5 inputGroupContainer">
     <select  class="form-control journalVoucher-textBox" ng-model="ptSlab.branchId" ng-options="master.branchId as master.branchName for master in branchList"
												ng-if="!ptSlab.isEdit"		  ng-change="getDepartment(ptSlab.branchId)"   name="Branch Id" data-validator="required" data-message-id="branchId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select>
	<input type="text" class="form-control input-sm" ng-if="ptSlab.isEdit" ng-model="ptSlab.branchName" readonly/>  
			                       	 	
        </div>
       </div>
       
       	<div class="form-group">
        <label class="col-md-4 control-label">
        Range To
          <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input
          type="text"class="form-control input-sm"ng-model="ptSlab.rangeTo" />
        
        </div></div>
        
        	<div class="form-group">
				<label class="col-md-4 control-label">Financial Year
					 <span style="color: red;">*</span>
				</label>
			<div class="col-md-5">
				<select  class="form-control journalVoucher-textBox" ng-model="ptSlab.financialYear" ng-options="master.financialYear as master.financialYear for master in financialYearList"
					data-ng-if="!ptSlab.isEdit"   name="Financial Year" data-validator="required" data-message-id="financialYear" data-valid-method="submit" >
					<option value=""> --Select--</option>
				</select>	
				<input type="text" class="form-control input-sm" ng-if="ptSlab.isEdit" ng-model="ptSlab.financialYear" readonly/>  
			</div>
		</div>
     
		</div>
		
	
       </form>
    
       </div>
       
        <div class="form-actions" style="border:0px solid red">
       <div class="row">
        <div class="col-md-12">
         <button class="btn btn-success"  type="submit" data-ng-click="submit(designationForm)" data-ng-if="!ptSlab.isEdit">
          <i class="fa fa-save"></i>
          Save 
         </button>
         <button class="btn btn-success"
            type="submit" data-ng-if="ptSlab.isEdit" data-ng-click="update(designationForm)">
            <i class="fa fa-save"></i> Update
           </button>
        <button   class="btn btn-info"  type="button" data-ng-click="reset(designationForm)" >
       											 <i class="fa fa-undo"></i>
    										   Reset
     										  </button>
         <button class="btn btn-danger" data-ng-click="cancel();"type="button">
                 <i class="fa fa-close"></i>
                 Cancel
                </button>
        </div>
       </div>
      </div>
      
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
