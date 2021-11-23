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
   <form class="form-horizontal" name="empTaxParamForm">
    <div class="row">

<div class="col-sm-12 col-md-12 col-lg-12">
        <!-- 1st roww -->  
      <div class="col-sm-6 col-md-6 col-lg-6">
      
        <div class="form-group">
		<label class="col-md-5 control-label"> Company</label>
		<div class="col-md-5">
		<selectivity list="companyList" property="empTaxParam.companyId" 
										                id="companyId" ng-model="empTaxParam.companyId"
										               name="companyId" form-name="empTaxParamForm" ng-if="!empTaxParam.isEdit"
										               validation="required" friendly-name="Hospital">
										               </selectivity>
										           <input type="text" class="form-control input-sm" ng-model="empTaxParam.companyId" message-id="companyId" 
        							 name="Hospital Name" ng-if="companyList.length == 1 & !empTaxParam.isEdit"  readonly> 
        							 
        <input type="text" class="form-control input-sm" data-ng-model="empTaxParam.companyName" name="Active"  ng-if="empTaxParam.isEdit" readonly />  
		</div>
		</div>
		
        <div class="form-group">
        <label class="col-md-5 control-label">Department</label>
        <div class="col-md-5 inputGroupContainer">
        <!-- <select  class="form-control journalVoucher-textBox" ng-model="empTaxParam.departmentId" ng-options="master.departmentId as master.departmentName for master in departmentList"
												  ng-change="getEmployeeList(empTaxParam.departmentId)"  name="Department Name" data-validator="required" data-message-id="departmentId" data-valid-method="submit">
											        <option value=""> --Select--</option>
											    </select>  -->
											    <selectivity list="departmentList" property="empTaxParam.departmentId" 
										                id="departmentId" ng-model="empTaxParam.departmentId"
										               name="departmentId" form-name="empTaxParamForm"
										               validation="required" friendly-name="Department" ng-if="!empTaxParam.isEdit">
										         </selectivity>
										         
		<input type="text" class="form-control input-sm" data-ng-model="empTaxParam.departmentName" 
		name="Active"  ng-if="empTaxParam.isEdit" readonly />       
										         
		    <!-- <select  class="form-control journalVoucher-textBox" data-ng-model="empTaxParam.departmentId" data-ng-options="master.departmentId as master.departmentName for master in departmentList"
		id="department" data-ng-if="!empTaxParam.isEdit" name="Department Name" data-ng-change="getEmployeeChange(empTaxParam.departmentId)"  data-validator="required" data-message-id="departmentId" data-valid-method="submit">
									        <option value=""> --Select--</option>
		</select> -->
		</div>
			<!-- <div class="col-md-5">
		<select  class="form-control journalVoucher-textBox" data-ng-model="empTaxParam.departmentId" data-ng-options="master.departmentId as master.departmentName for master in departmentList"
		 data-ng-if="empTaxParam.isEdit" name="Department Name" data-ng-change="getEmployeeChange(empTaxParam.departmentId)"  data-validator="required" data-message-id="departmentId" data-valid-method="submit" disabled>
									        <option value=""> --Select--</option>
		</select>   
        </div> -->
        </div>
       
        <div class="form-group">
        <label class="col-md-5 control-label">Tax Payer Type</label>
        <div class="col-md-5 inputGroupContainer">
        <selectivity list="payerTypeList" property="empTaxParam.taxPayerTypeId" 
										                id="taxPayerTypeId" ng-model="empTaxParam.taxPayerTypeId"
										               form-name="empTaxParamForm"  name="taxPayerTypeId"
										               validation="required" friendly-name="Tax Payer Type">
										         </selectivity>
       
        </div>
        </div>
       
        <div class="form-group">
        <label class="col-md-5 control-label">Living In Metro</label>
        <div class="col-md-5 input-sm">       
        <input type="checkbox"
		data-ng-model="empTaxParam.livingInMetro" 
		name="Active" data-validator="required" data-message-id="status" data-valid-method="submit" />       
        </div>
        </div>
       
       </div>

  <div class="col-sm-6 col-md-6 col-lg-6">         
        
         <div class="form-group">
		<label class="col-md-5 control-label"> Branch</label>
		<div class="col-md-5">
<!-- 		<input type="text" class="form-control" name="kmc" value="" data-ng-model="empTaxParam.branchName" readonly> -->
		<selectivity list="branchList" property="empTaxParam.branchId" 
										                id="branchId" ng-model="empTaxParam.branchId"
										               name="branchId" form-name="empTaxParamForm" ng-if="!empTaxParam.isEdit"
										               validation="required" friendly-name="Branch">
										         </selectivity>
										         <!-- <input type="text" class="form-control input-sm" ng-model="empTaxParam.branchId" message-id="branchId" 
        							 name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0" readonly> -->
        							 
        							 <input type="text" class="form-control input-sm" data-ng-model="empTaxParam.branchName" name="Active"  ng-if="empTaxParam.isEdit" readonly /> 
		<!-- <select  class="form-control journalVoucher-textBox" ng-model="empTaxParam.branchId" ng-options="master.branchId as master.branchName for master in branchList"
		  ng-change="getDepartmentChange(empTaxParam.branchId)"    data-ng-if="!empTaxParam.isEdit" name="Branch Id" data-validator="required" data-message-id="branchId" data-valid-method="submit" >
	        <option value=""> --Select--</option>
	        </select>
       <select  class="form-control journalVoucher-textBox" ng-model="empTaxParam.branchId" ng-options="master.branchId as master.branchName for master in branchList"
	  ng-change="getDepartmentChange(empTaxParam.branchId)"  data-ng-if="empTaxParam.isEdit"   name="Branch Id" data-validator="required" data-message-id="branchId" data-valid-method="submit" disabled>
        <option value=""> --Select--</option>
        </select> -->
		</div>
		</div>
        
        <div class="form-group">
        <label class="col-md-5 control-label">Employee No</label>
         
        
        <div class="col-md-5" >
     <selectivity list="employeeList" property="empTaxParam.employeeId"  id="employeeId" ng-model="empTaxParam.employeeId"
	name="employeeId" form-name="empTaxParamForm" validation="required" friendly-name="Employee Name" ng-if="!empTaxParam.isEdit">
										               
										         </selectivity>
		<input type="text" class="form-control input-sm" data-ng-model="empTaxParam.employeeName" name="Active"  ng-if="empTaxParam.isEdit" readonly /> 
										         
		 
			                       	 	
    </div>
	
        
        </div>
        
        <div class="form-group">
        <label class="col-md-5 control-label">PH Type</label>
        <div class="col-md-5 inputGroupContainer">
        <selectivity list="phTypeList" property="empTaxParam.phType" 
										                id="phType" ng-model="empTaxParam.phType"
										               name="phType" form-name="empTaxParamForm"
										               validation="required" friendly-name="PH Type">
										         </selectivity>
        
        </div>
        </div>
       
        <div class="form-group">
        <label class="col-md-5 control-label">Is Self Occupied House </label>
        <div class="col-md-5 input-sm">
         <label></label><input type="checkbox"
		 data-ng-model="empTaxParam.selfOccupiedHouse" 
		name="selfOccupiedHouse" data-validator="required" data-message-id="status" data-valid-method="submit" /> 
		</label>												  
        </div>
        </div>
        
        </div>
    </div>
 </div> 
     <div class="form-actions">
     <div class="row">
      <div class="col-md-35">
       <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-click="submit(empTaxParamForm)" data-ng-if="!empTaxParam.isEdit" >
            <i class="fa fa-save"></i>
            Save
           </button>
          <button class="btn btn-success"  type="button" data-ng-click="update(empTaxParamForm)"
												data-ng-if="empTaxParam.isEdit" >
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
   </form>
   </div>
   </div>
   </div>
   </article>
   </div>
   </section>
   </div>
   
   
   
   