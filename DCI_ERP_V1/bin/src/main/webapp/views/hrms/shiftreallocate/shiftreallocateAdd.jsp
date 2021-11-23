<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="shiftReAllocationAddForm"
        role="form" >
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
          <div class="col-sm-6 col-md-6 col-lg-6">
           <fieldset>
            <div class="form-group">
             <label class="col-md-6 control-label"> Organization</label>
             <div class="col-md-4">
              <selectivity list="companyList" property="shiftAllocationobj.companyId" 
                id="companyId" ng-model="shiftAllocationobj.companyId" 
               name="companyId" form-name="shiftAllocationAddForm"
               validation="required" friendly-name="Department"
               disabled="disable"></selectivity>
             </div>
            </div>
            <div class="form-group" id="departmentNameValue" ng-if="!shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label"> Department
              <spring:message
               code="label.asterisk.symbol"></spring:message></label>
             <div class="col-md-4">
             <selectivity list="departmentList" property="shiftReAllocationobj.departmentId" 
                id="departmentId" ng-model="shiftReAllocationobj.departmentId"
               name="departmentId" form-name="shiftReAllocationAddForm"
               validation="required" friendly-name="Department"></selectivity>
             </div>
            </div>
            <div class="form-group" id="departmentNameReadOnly" ng-if="shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label"> Department
              </label>
             <div class="col-md-4">
              <input type="text" class="form-control input-sm"
               name="departmentName" id="departmentName"
               ng-model="shiftReAllocationobj.departmentName" readonly>
             </div>
            </div>
            <div class="form-group" id="employeeName" ng-if="!shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label"> Employee
             <%--  <spring:message
               code="label.asterisk.symbol"></spring:message> --%></label>
             <div class="col-md-4">
             <selectivity list="employeeList" property="shiftReAllocationobj.employeeId" 
                id="employeeId" ng-model="shiftReAllocationobj.employeeId"
               name="employeeId" form-name="shiftReAllocationAddForm"
               validation="required" friendly-name="Employee"
               ></selectivity>
             </div>
            </div>
            <div class="form-group" id="employeeNameReadOnly" ng-if="shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label"> Employee
              </label>
             <div class="col-md-4">
              <input type="text" class="form-control"
               name="Employee" id="employeeName"
               ng-model="shiftReAllocationobj.employeeName" readonly>
             </div>
            </div>
            <%-- <div class="form-group" id="designationName" ng-if="!shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label"> Designation
              <spring:message
               code="label.asterisk.symbol"></spring:message></label>
             <div class="col-md-4">
             <selectivity list="designationList" property="shiftReAllocationobj.designationId" 
                id="designationId" ng-model="shiftReAllocationobj.designationId"
               name="designationId" form-name="shiftReAllocationAddForm"
               validation="required" friendly-name="Designation"></selectivity>
             </div>
            </div> --%>
            <!-- <div class="form-group" id="designationNameReadOnly" ng-if="shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label"> Designation
              </label>
             <div class="col-md-4">s
              <input type="text" class="form-control input-sm"
               name="designationName" id="designationName"
               ng-model="shiftReAllocationobj.designationName" readonly>
             </div>
            </div> -->
           </fieldset>
          </div>
          <div class="col-sm-4 col-md-4 col-lg-4">
           <fieldset>
           	<div class="form-group" id="branchName" ng-if="!shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label"> Branch
             </label>
             <div class="col-md-5">
             <selectivity list="branchList" property="shiftReAllocationobj.branchId" 
                id="branchId" ng-model="shiftReAllocationobj.branchId"
               name="branchId" form-name="shiftReAllocationAddForm"
               validation="required" friendly-name="Branch"></selectivity>
             </div>
            </div>
            <div class="form-group" id="branchNameReadOnly" ng-if="shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label"> Branch
             </label>
             <div class="col-md-6">
              <input type="text" class="form-control input-sm"
               name="branchName" id="branchName"
               ng-model="shiftReAllocationobj.branchName" readonly>
             </div>
            </div>
          <!--   <div class="form-group" id="fromDateValue" ng-if="!shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label">From Date<spring:message code="label.asterisk.symbol"></spring:message></label>
             <div class="col-md-6">
              <div class='input-group date datetimepick'>
            <div class="dropdown">
             <a class="dropdown-toggle" id="frmDate" role="button"
              data-toggle="dropdown" data-target="#" href="#">
              <div class="input-group">
               <input type="text" class="form-control"
                placeholder="dd/mm/yyyy" name="From Date"
                validation="required" friendly-name="From Date"
                data-ng-model="shiftReAllocationobj.fromDate"><span
                class="input-group-addon"><i
                class="glyphicon glyphicon-calendar"></i></span>
              </div>
             </a>
             <ul class="dropdown-menu" role="menu"
              aria-labelledby="dLabel">
              <datetimepicker data-ng-model="shiftReAllocationobj.fromDate"
               data-on-set-time="shiftReAllocationobj.fromDate = onDateSet(newDate)"
               data-datetimepicker-config="{ dropdownSelector: '#frmDate',startView:'day', minView:'day'}" />
             </ul>
            </div>
           </div>
             </div>
            </div> -->
            
            
            
            <div class="form-group">
								<label class="col-md-6 control-label">From Date<span
									style="color: red;">*</span></label>

								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="shiftReAllocationobj.fromDate"
										id="fromDate" name="fromDate" form-name="fromDate" friendly-name="fromDate"
										validation="required" />
								</div>
							</div>
	    
          <!--   <div class="form-group" id="fromDateReadOnly" ng-if="shiftReAllocationValidateData.isEdit">
             <label class="col-md-6 control-label">From Date<spring:message code="label.asterisk.symbol"></spring:message></label>
             <div class="col-md-6">
                <div class='input-group date datetimepick'>
            <div class="dropdown">
             <a class="dropdown-toggle" id="fmDate" role="button"
              data-toggle="dropdown" data-target="#" href="#">
              <div class="input-group">
               <input type="text" class="form-control"
                placeholder="dd/mm/yyyy" name="fromDate"
                data-ng-model="shiftReAllocationobj.fromDate" readonly><span
                class="input-group-addon"><i
                class="glyphicon glyphicon-calendar"></i></span>
              </div>
             </a>
             <ul class="dropdown-menu" role="menu"
              aria-labelledby="dLabel">
              <datetimepicker data-ng-model="shiftReAllocationobj.fromDate"
               data-on-set-time="shiftReAllocationobj.fromDate = onDateSet(newDate)"
               data-datetimepicker-config="{ dropdownSelector: '#fmDate',startView:'day', minView:'day'}" />
             </ul>
            </div>
           </div>
             </div>
            </div> -->
           <!--  <div class="form-group">
             <label class="col-md-6 control-label">To Date<spring:message code="label.asterisk.symbol"></spring:message></label>
             <div class="col-md-6">
               <div class='input-group date datetimepick'>
            <div class="dropdown">
             <a class="dropdown-toggle" id="tDate" role="button"
              data-toggle="dropdown" data-target="#" href="#">
              <div class="input-group">
               <input type="text" class="form-control"
                placeholder="dd/mm/yyyy" name="To Date"
                validation="required" friendly-name="To Date"
                data-message-id="toDate"
                data-ng-model="shiftReAllocationobj.toDate"><span
                class="input-group-addon"><i
                class="glyphicon glyphicon-calendar"></i></span>
              </div>
             </a>
             <ul class="dropdown-menu" role="menu"
              aria-labelledby="dLabel">
              <datetimepicker data-ng-model="shiftReAllocationobj.toDate"
               data-on-set-time="shiftReAllocationobj.toDate = onDateSet(newDate)"
               data-datetimepicker-config="{ dropdownSelector: '#tDate',startView:'day', minView:'day'}" />
             </ul>
            </div>
           </div>
             </div>
            </div> -->
            
             
            <div class="form-group">
								<label class="col-md-6 control-label">To Date<span
									style="color: red;">*</span></label>

								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="shiftReAllocationobj.toDate"
										id="toDate" name="toDate" form-name="toDate" friendly-name="toDate"
										validation="required" />
								</div>
							</div>
          <!--   <div class="form-group" >
				<label class="col-md-6 control-label"> Shift <spring:message
               code="label.asterisk.symbol"></spring:message></label>
				<div class="col-md-6">
				 <select class="form-control" id="shifid" name="Shift Name"
				 validation="required" friendly-name="Shift"
				 ng-model="shiftReAllocationobj.shiftCode" 				 				 
				 ng-options="st.shiftCode as st.shiftName for st in shiftNameList">
				 <option value="" selected="selected">Select</option>
				 </select>
				</div>
			</div>
			 -->
			
			 	<div class="form-group" id="shiftCode" >
             <label class="col-md-6 control-label"> Shift
             </label>
             <div class="col-md-5">
             <selectivity list="shiftNameList" property="shiftReAllocationobj.shiftCode" 
                id="shiftCode" ng-model="shiftReAllocationobj.shiftCode"
               name="shiftCode" form-name="shiftReAllocationAddForm"
               validation="required" friendly-name="shiftCode"></selectivity>
             </div>
            </div>
        
           </fieldset>
          </div>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success"
            ng-if="!shiftReAllocationValidateData.isEdit" type="button"
            ng-click="save(shiftReAllocationAddForm, shiftReAllocationobj,shiftReAllocationValidateData)">
            <i class="fa fa-save"></i> Save
           </button>
           <button class="btn btn-success"
            ng-if="shiftReAllocationValidateData.isEdit" type="button"
            ng-click="save(shiftReAllocationAddForm, shiftReAllocationobj,shiftReAllocationValidateData)">
            <i class="fa fa-save"></i> Update
           </button>
           <button class="btn btn-info ng-scope" type="button"
            ng-click="reset()" class="btn btn-success">
            <i class="fa fa-undo"></i> Reset
           </button>
           <button class="btn btn-danger" type="button"
            ng-click="cancel()" class="btn btn-success">
            <i class="fa fa-close"></i> Cancel
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
</div>
</div>
</div>