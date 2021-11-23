<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
     <form class="form-horizontal" name="designationAddForm" role="form"  novalidate method="post">
      <div class="row">
       <div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
        <fieldset>
         <div class="form-group">
          <label class="col-md-4 control-label">
           Designation Name
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-5">
           <input type="text" class="text-left form-control input-sm" ng-model="designationData.desgnName" name="desgnName" typeahead="r.desgnName for r in desgnList | filter:$viewValue | limitTo:10" typeahead-min-length="1" validation="required" friendly-name="Designation Name">
          </div>
         </div>
         <div class="form-group">
          <label class="col-md-4 control-label" ng-if="!designationValidateData.isEdit" >
           Remarks
          </label>
            <div class="col-md-5">
            <textarea  ng-model="designationData.desgnDesc" ng-if="!designationValidateData.isEdit"  class="form-control input-sm resize-none" rows="2" ></textarea>
           </div>
         </div>
            <div class="form-group">
          <label class="col-md-4 control-label">
           Active
          </label>
       <div class="col-md-5">
         <div class="checkbox">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" checked="checked" ng-true-value = "'Y'" ng-false-value = "'N'" name="isActive" ng-model="designationData.isActive">
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
         <button class="btn btn-success" ng-if="!designationValidateData.isEdit" ng-click="save(designationAddForm,designationData,designationValidateData)">
          <i class="fa fa-save"></i>
          Save
         </button>
         <button class="btn btn-success"
            ng-if="designationValidateData.isEdit" ng-click="update(designationAddForm,designationData,designationValidateData)">
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
