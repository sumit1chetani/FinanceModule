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
   <form class="form-horizontal" name="employeehraAddForm">
    <div class="row">
    
     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>
      
       <div class="form-group">
        <label class="col-md-4 control-label">Organization  <span style="color: red;">*</span></label>
        <div class="col-md-6 inputGroupContainer" ng-if="!employeehra.isEdit">
        	<selectivity  list=companyList property="employeehra.companyId" ng-model="employeehra.companyId" id="companyId"  name="companyId" form-name = "employeehraAddForm" 
	        													validation="required" friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
			<input type="text" class="form-control input-sm" ng-model="employeehra.companyName" message-id="companyId" 
        															data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="companyList.length == 1" readonly> 
												     
        </div>
        <div class="col-md-6 inputGroupContainer" ng-if="employeehra.isEdit">
        	<input type="text" class="form-control input-sm" ng-model="employeehra.companyName" readonly> 
		 </div>
       </div>
     	<div class="form-group">
        <label class="col-md-4 control-label">Department  <span style="color: red;">*</span></label>
        <div class="col-md-6 inputGroupContainer">
     	<selectivity  list=departmentList property="employeehra.departmentId" ng-model="employeehra.departmentId" id="departmentId"  name="departmentId" form-name = "employeehraAddForm" validation="required" data-ng-if="!employeehra.isEdit" friendly-name="Department Name"></selectivity>     
         
         <input type="text" class="form-control input-sm" name="Department Name"
			ng-if="employeehra.isEdit" ng-model="employeehra.departmentName" readonly>   
			   
        </div>
       </div>
         <div class="form-group">
        <label class="col-md-4 control-label">Financial Year
         <span style="color: red;">*</span> </label>
        <div class="col-md-6 inputGroupContainer">
    		 <selectivity  list=financialYearList  property="employeehra.financialYear" ng-model="employeehra.financialYear" id="financialYear"  name="financialYear" form-name = "employeehraAddForm" 
	        		validation="required" data-ng-if="!employeehra.isEdit" friendly-name="Month Year"></selectivity> 
	        		
                    <input type="text" class="form-control input-sm" name="Financial Year"
			ng-if="employeehra.isEdit" ng-model="employeehra.monthYear" disabled>   
			   
        </div>
       </div>
     
        <div class="form-group">
        <label class="col-md-4 control-label">
        Amount Of Rent Paid
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-6">
         <input
          type="text"
          class="form-control input-sm"  name="rentPaid"
          ng-model="employeehra.rentPaid"
         id="rentPaid" validation="required" friendly-name="Amount Of Rent Paid" phonenumbers-only/>
        </div>
       </div>
     </fieldset>
     </div>
     
     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>
         <div class="form-group">
        <label class="col-md-4 control-label">Branch   <span style="color: red;">*</span></label>
        <div class="col-md-6 inputGroupContainer" ng-if="!employeehra.isEdit">
       		<selectivity  list=branchList property="employeehra.branchId" ng-model="employeehra.branchId" id="branchId"  name="branchId" form-name = "employeehraAddForm"
	       validation="required" friendly-name="Branch Name" ng-if="branchList.length > 1 && !employeehra.isEdit"></selectivity> 
	       
	        <input type="text" class="form-control input-sm" name="Branch Name"
			 ng-model="employeehra.branchName" ng-if="branchList.length == 1" readonly>  
	   	</div>
	   	 <div class="col-md-6 inputGroupContainer" ng-if="employeehra.isEdit">
       		
	        <input type="text" class="form-control input-sm" name="Branch Name"
			 ng-model="employeehra.branchName" readonly>  
	   	</div>
       </div>
       
          <div class="form-group">
        <label class="col-md-4 control-label">Employee Name  <span style="color: red;">*</span> </label>
        <div class="col-md-6 inputGroupContainer">
    			<selectivity  list=employeeList property="employeehra.employeeId" ng-model="employeehra.employeeId" id="employeeId"  name="employeeId" form-name = employeehraAddForm validation="required" data-ng-if="!employeehra.isEdit" friendly-name="Employee Name"></selectivity>
                
                 <input type="text" class="form-control input-sm" name="Employee Name"
			ng-if="employeehra.isEdit" ng-model="employeehra.employeeName" readonly>
			      
        </div>
       </div>
     
      <div class="form-group">
        <label class="col-md-4 control-label">Month  <span style="color: red;">*</span></label>
        <div class="col-md-6 inputGroupContainer">
         <selectivity list="monthList" ng-model="employeehra.month"
														property="employeehra.month" id="month"  name="month" validation="required"
			        				 friendly-name="Month" form-name = "employeehraAddForm" ng-if="!employeehra.isEdit" ></selectivity>
			        				 
			
		<selectivity list="monthList" ng-model="employeehra.month" property="employeehra.month" id="month"   name="month" validation="required"
		friendly-name="Month" form-name = "employeehraAddForm" ng-if="employeehra.isEdit" disabled='true' ></selectivity> 
		</div>
       </div>
       
          <div class="form-group">
        <label class="col-md-4 control-label">
       	Attachment
         
        </label>
        <div class="col-md-4">
         <input type="file" name="joinDocUpload" ng-model="employeehra.joinDocUpload" class="form-control" onchange="angular.element(this).scope().uploadDocFile(this)"
           			  accept=".docx,.xls,.png,.jpg,.pdf" style=" width: 182px; "/> <br> 
        </div>
        <button class="btn btn" type="button" ng-click="uploadDocument()">Upload</button>
       </div>
      </fieldset>
     </div>
    </div>
  
    <div class="form-actions" style="border:0px solid red">
       <div class="row">
        <div class="col-md-12">
         <button class="btn btn-success"  type="button" ng-click="submit(employeehraAddForm)" ng-if="!employeehra.isEdit">
          <i class="fa fa-save"></i>
          Save
         </button>
         <button class="btn btn-success"
            ng-if="employeehra.isEdit" type="button" ng-if="employeehra.isEdit" ng-click="update(employeehraAddForm)">
            <i class="fa fa-save"></i> Update
           </button>
        <button   class="btn btn-info"  type="button" data-ng-click="reset(employeehraAddForm)" ng-if="!employeehra.isEdit">
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
   
   
   
   