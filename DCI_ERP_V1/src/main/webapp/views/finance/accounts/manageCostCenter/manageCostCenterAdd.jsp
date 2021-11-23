<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="manageCostCenterAdd">
        <div class="row">
        
         <div class="col-sm-12 col-md-10 col-lg-10">
          <fieldset>
          
          <div class="form-group">
					        				<label class="col-md-6 control-label"> <%-- <spring:message
			              			code="label.company.name"></spring:message> --%>Organization Name <span style="color: red;">*</span></label>
					        				<div class="col-md-3">
						        				<selectivity list="companyList" property="manageCostCenter.companyId" id="hospital"
						        				ng-model="manageCostCenter.companyId" name="hospital" form-name = "manageCostCenterAdd"
						        				validation="required" friendly-name="<spring:message
			              			code="label.company.name"></spring:message>"></selectivity>
											</div>
										</div>
           
           
										 
         
            <div class="form-group">
            <label class="col-md-6 control-label">
           Fund Center Code
           <span style="color: red;">*</span>
            </label>
             <div class="col-md-3">
           
           <input type="text" class="form-control input-sm" 
              data-ng-model="manageCostCenter.costCenterCode" name="costCenterCode"  data-message-id="costCenterCode" validation="required" friendly-name="Cost Center Code" form-name = "manageCostCenterAdd" maxlength="30"/>
            </div>
           </div>
            <div class="form-group">
            <label class="col-md-6 control-label">
           	Fund Center Name
             <span style="color: red;">*</span>
            </label>
            <div class="col-md-3">
          <input type="text" class="form-control input-sm" 
              data-ng-model="manageCostCenter.costCenterName" name="costCenterName"  data-message-id="costCenterName" validation="required" friendly-name="Cost Center Name" form-name = "manageCostCenterAdd" maxlength="30" />
            </div>
           </div>
           
             <div class="form-group">
            <label class="col-md-6 control-label">
             Fund Center Description
           </label>
            <div class="col-md-3">
             <input type="text" class="form-control input-sm" 
              data-ng-model="manageCostCenter.costCenterDescription" name="costCenterDescription" maxlength="50"/>
            </div>
           </div>
         
             <div class="form-group">
            <label class="col-md-6 control-label">
           Status
            
            </label>
            <div class="col-md-6">
             <div class="checkbox">
              <label>
               <input type="checkbox" class="checkbox style-0"  
                ng-model="manageCostCenter.status"  name="status">
               <span></span>
              </label>
             </div>
            </div></div>
          
           </fieldset></div></div>
             <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-click="submit(manageCostCenterAdd)" data-ng-if="!manageCostCenter.isEdit" >
            <i class="fa fa-save"></i>
            Save
           </button>
          <button class="btn btn-success"  type="button" data-ng-click="update(manageCostCenterAdd)"
					data-ng-if="manageCostCenter.isEdit" >
        <i class="fa fa-save"></i>
       Update
       </button>
         <button class="btn btn-info" type="reset" class="btn btn-success" ng-click="reset()" ng-if="!manageCostCenter.isEdit">
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