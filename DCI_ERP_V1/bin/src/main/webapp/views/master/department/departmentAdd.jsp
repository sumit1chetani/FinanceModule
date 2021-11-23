<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
     <form class="form-horizontal" name="departmentAddForm" role="form" novalidate method="post">
      <div class="row">
       <div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
        <fieldset>
        <div class="form-group" ng-if="departmentValidateData.deptCodeEdit" >
            <label class="col-md-4 control-label">Department Code<span
             style="color: red;"></span></label> 
             <div class="col-md-5">
             <label
             class="col-md-6 control-label"
             ng-if="departmentValidateData.isEdit">{{departmentData.deptCode}}</label></div>
           </div>
         <div class="form-group">
          <label class="col-md-4 control-label">
           Department Name
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-5" ng-class="{'show-error':departmentAddForm.deptName.$error.required && submitted">
           <input type="text" class="text-left form-control input-sm" ng-model="departmentData.deptName" name="deptName" typeahead="r.deptName for r in deptList | filter:$viewValue | limitTo:10" typeahead_min_length="1"  validation="required" friendly-name=" Department Name">
          </div>
         </div>
         <div class="form-group">
          <label class="col-md-4 control-label">
           Department Head
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-5">
           
             <selectivity list="employeeList" property="departmentData.deptHead" id="deptHead" ng-model="departmentData.deptHead"
               name="deptHead" form-name="departmentAddForm"
               validation="required" friendly-name="Department Head"></selectivity>
          </div>
         </div> 
          <div class="form-group">
          <label class="col-md-4 control-label" ng-if="!departmentValidateData.isEdit" >
           Remarks
          </label>
          <div class="col-md-5">
            <textarea  ng-model="departmentData.deptDesc" ng-if="!departmentValidateData.isEdit"  class="form-control input-sm resize-none" rows="2" ></textarea>
           </div>
         </div>
            <div class="form-group">
          <label class="col-md-4 control-label">
           Active
          </label>
              <div class="col-md-5">
         <div class="checkbox">
          <label class="i-checks">
             <input type="checkbox" class="checkbox style-0" ng-true-value = "'Y'" ng-false-value = "'N'" name="isActive" ng-model="departmentData.isActive">
           <i></i>
          </label>
         </div>
        </div>
         </div>
         
         
        </fieldset>
       </div>
      </div>
      <div class="form-actions">
       <div class="row">
        <div class="col-md-12">
         <button class="btn btn-success" ng-if="!departmentValidateData.isEdit" type="button"  ng-click="save(departmentAddForm,departmentData,departmentValidateData)">
          <i class="fa fa-save"></i>
          Save
         </button>
         <button class="btn btn-success"
            ng-if="departmentValidateData.isEdit" type="button" ng-click="update(departmentAddForm,departmentData,departmentValidateData)">
            <i class="fa fa-save"></i> Update
           </button>
         <button class="btn btn-danger" ng-click="cancel()" type="button">
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
 </div>
</div>
