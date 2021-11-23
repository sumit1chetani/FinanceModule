<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="shiftAllocationAddForm">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12 col-lg-offset-2">
          <fieldset>
           <div class="form-group">
            <label class="bold" ng-if="!isEdit"><spring:message
              code="label.searchBy"></spring:message></label>
           </div>
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12">
          <div class="col-sm-6 col-md-6 col-lg-6">
           <fieldset>
            <div class="form-group">
             <label class="col-md-6 control-label">Organization name
             </label>
<%--              <input type="hidden" value="${form_code}" id="formCode"/>
 --%>             <div class="col-md-4">
<!--               <input type="text" class="form-control input-sm" -->
<%--                name="<spring:message code="label.shiftAllocation.companyName"></spring:message>" --%>
<!--                ng-model="shiftAllocationobj.companyName" readonly> -->
               
               <selectivity list="companyList" property="shiftAllocationobj.companyId" 
                id="companyId" ng-model="shiftAllocationobj.companyId" 
               name="companyId" form-name="shiftAllocationAddForm"
               validation="required" friendly-name="Department"
               disabled="disable"></selectivity>
             </div>
            </div>
            <div class="form-group" id="departmentName" >
             <label class="col-md-6 control-label">Department Name
             </label>
             <div class="col-md-4">
             <selectivity list="departmentList" property="shiftAllocationobj.departmentId" 
											                id="departmentId" ng-model="shiftAllocationobj.departmentId" 
											               name="departmentId" form-name="shiftAllocationAddForm"
											               validation="required" friendly-name="Department"
											               ></selectivity>
             
             </div>
            </div>
            
           </fieldset>
          </div>
          <div class="col-sm-6 col-md-6 col-lg-6">
           <fieldset>
            <div class="form-group" id="branchName">
             <label class="col-md-4 control-label">Branch Name
             </label>
             <div class="col-md-4">
<!--         <input type="text" class="form-control input-sm" ng-model="shiftAllocationobj.branchName"  > 
 -->              <selectivity list="branchList" property="shiftAllocationobj.branchId" 
											                id="branchId" ng-model="shiftAllocationobj.branchId" 
											               name="branchId" form-name="shiftAllocationAddForm"
											               validation="required" friendly-name="Branch Name"
											               ></selectivity>
           
             </div>
            </div>
            
          </div>
          <div class="col-sm-6 col-md-6 col-lg-6">
           <div class="form-group" id="employeeNo" ng-if="!isEdit">
            <label class="col-md-6 control-label"> Employee Number
            </label>
            <div class="col-md-4">
            <selectivity list="employeeList" property="shiftAllocationobj.employeeId" 
											                id="employeeId" ng-model="shiftAllocationobj.employeeId" 
											               name="employeeId" form-name="shiftAllocationAddForm"
											               friendly-name="Employee"
											               ></selectivity>
            
            </div>
           </div>
          
          </div>
          <!-- <div class="col-sm-4 col-md-4 col-lg-4">
           <div class="form-group">
            <label class="col-md-7 control-label bold"><spring:message
              code="label.shiftDefinitionDate"></spring:message></label>
           </div>           </div> -->
           
          
           <div class="form-group" >
            <label class="col-md-3 control-label"> Validity Form<span style="color:red;">*</span>
            </label>
            
            <div class="col-md-3">
            <ng-bs3-datepicker data-ng-model="shiftAllocationobj.validityFrom"
										id="validityFrom" name="validityFrom" form-name="validityFrom" friendly-name="validityFrom"
										validation="required" />
            
           </div> 
            </div>
           <div class="form-group">
            <label class="col-md-6 control-label"> Validity To<span style="color:red;">*</span>
            </label>
            <div class="col-md-3">
              <ng-bs3-datepicker data-ng-model="shiftAllocationobj.validityTo"
										id="validityTo" name="validityTo" form-name="validityTo" friendly-name="validityTo"
										validation="required" />
            </div>
           </div>
           <div class="form-group" >
            <label class="col-md-6 control-label">Scheme Name<span style="color:red;">*</span>
            </label>
            <div class="col-md-3">
            <selectivity list="schemeList" property="shiftAllocationobj.shiftId" 
											                id="shiftId" ng-model="shiftAllocationobj.shiftId" 
											               name="shiftId" form-name="shiftAllocationAddForm"
											               validation="required" friendly-name="Scheme Name"
											               ></selectivity>
            
            </div>
           </div>
                                </fieldset>
                    </div>
           
          </div>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success"
            ng-if="!isEdit" type="button"
            ng-click="save(shiftAllocationAddForm, shiftAllocationobj,shiftAllocationValidateData)">
            <i class="fa fa-save"></i>
            save
           </button>
           <button class="btn btn-success"
            ng-if="isEdit" type="button"
            ng-click="save(shiftAllocationAddForm, shiftAllocationobj,shiftMasterValidateData)">
            <i class="fa fa-save"></i>
            update
           </button>
           <button class="btn btn-info ng-scope" type="button"
            ng-click="reset()" class="btn btn-success">
            <i class="fa fa-undo"></i>
            reset
           </button>
           <button class="btn btn-danger" type="button"
            ng-click="cancel()" class="btn btn-success">
            <i class="fa fa-close"></i>
           cancel
           </button>
          </div>
         </div>
        </div>
       </form>
      </div>
     </div>
						</form>
					</div>
	</div>
</div>

