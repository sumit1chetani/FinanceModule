<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz" >
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2 ng-if=!isEdit><spring:message code="label.add.labdepartment"></spring:message> </h2>
       <h2 ng-if=isEdit><spring:message code="label.Edit.labdepartment"></spring:message> </h2>
     </header>
     <div role="content">
      <div class="widget-body">
              <form class="form-horizontal" name="departmentMasterForm" novalidate method="post">
        <div class="row">
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
           <div class="form-group">
            <label class="col-md-6 control-label"> <spring:message code="label.department.code"></spring:message>
            <spring:message code="label.asterisk.symbol"></spring:message></label>
            <div class="col-md-6">
            <input type="text" class="form-control input-sm"
              name="departmentCode"  validation="required" friendly-name="Department Code"
              ng-model="departmentMaster.departmentCode">
            </div>
           </div>

           <div class="form-group">
            <label class="col-md-6 control-label"> <spring:message code="label.department.name"></spring:message>
              <spring:message code="label.asterisk.symbol"></spring:message>
            </label>
            <div class="col-md-6">
            <input type="text" class="form-control input-sm"
              name="departmentName"
              ng-model="departmentMaster.departmentName"
              validation="required" friendly-name="Department Name" />
           <!--   <input type="text" class="form-control input-sm"
              name="Department Name"
              ng-model="departmentMaster.departmentName"
              data-validator="required" data-message-id="departmentName"
              data-valid-method="submit" /> -->
            </div>
           </div>

           <div class="form-group">
            <label class="col-md-6 control-label"> <spring:message code="label.description"></spring:message> </th>
            </label>
            <div class="col-md-6">
             <input type="text" class="form-control input-sm"
              name="description" ng-model="departmentMaster.description"
               />
            </div>
           </div>
           <div class="form-group">
				<label class="col-md-6 control-label"><spring:message code="label.maindepart"></spring:message>
					<span style="color: red;">*</span>
				</label>
				<div class="col-md-6">
				<selectivity list="departmentList" property="departmentMaster.deptId" id="deptId"
				 ng-model="departmentMaster.deptId"
               name="departmentId" form-name="departmentMasterForm"
               validation="required" friendly-name="Main Department"></selectivity>
				</div>	
			</div>
           <div class="form-group">
            <label class="col-md-6 control-label"> <spring:message code="label.is.active"></spring:message>
            </label>
            <div class="col-md-6">
             <div class="checkbox">
              <label> <input type="checkbox"
               class="checkbox style-0"
               ng-model="departmentMaster.status"
               > <span></span>
              </label>
             </div>
            </div>
           </div>
			 <div class="form-group">
            <label class="col-md-6 control-label"> <spring:message code="label.remarks"></spring:message>
            </label>
            <div class="col-md-6">
              <textarea class="form-control input-sm resize-none" rows="2" name="remarks"
                 data-ng-model="departmentMaster.remarks"></textarea>  
            </div>
           </div>
          </fieldset>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" class="btn btn-success"
            type="button" data-ng-if="!isEdit == true"
            ng-click="validate(departmentMasterForm)">
            <i class="fa fa-save"></i> <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="validate(departmentMasterForm)"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>  <spring:message code="label.update"></spring:message>
           </button>
           <button type="reset"
            class="btn btn-info" ng-click="reset(departmentMasterForm)">
            <i class="fa fa-undo"></i>  <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="reset"
            class="btn btn-success" ng-click="cancel()">
            <i class="fa fa-close"></i>  <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
         </div>
        </div>
       </form>
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