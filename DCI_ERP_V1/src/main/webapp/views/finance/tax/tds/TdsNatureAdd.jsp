<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" name="tdsNatureForm" novalidate>
    <div class="row">
    <div class="col-sm-12 col-md-12 col-lg-12">
       <div class="col-sm-6 col-md-6 col-lg-6">
     <fieldset>
     <div class="form-group" ng-if="isEdit==true">
         <label class="col-md-4 control-label">Nature Code</label>
         <div class="col-md-5 inputGroupContainer">
         <input type="text" class="form-control input-sm" name="natureCode" ng-model="tdsNature.natureCode" readonly>
       <!--  <label class="col-md-4 control-label"> {{tdsNature.natureCode}}</label> -->
         </div>
        </div>
     </fieldset>
        </div>
    </div>
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="col-sm-6 col-md-6 col-lg-6">
       <fieldset>
       
        <div class="form-group">
         <label class="col-md-4 control-label">Nature <span style="color: red;">*</span></label>
         <div class="col-md-5 inputGroupContainer">
          <input type="text" class="form-control input-sm" name="nature" ng-model="tdsNature.nature" validator="required" valid-method="submit" message-id="nature" id="nature" >
         </div>
        </div>
           <div class="form-group">
         <label class="col-md-4 control-label "> Account Head <span style="color: red;">*</span>
         </label>
         <div class="col-md-5">
          <selectivity  list="accountHeadList" property="tdsNature.accountHeadCode" id="accountHeadCode" name="accountHeadCode" ng-model="tdsNature.accountHeadCode" friendly-name="Account Head" ></selectivity>
         </div>
        </div>
        
        <div class="form-group">
         <label class="col-md-12 control-label text-center bold">Company</label>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Tax(%) <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm" name="companyTax" ng-model="tdsNature.companyTax" validator="required" valid-method="submit" message-id="companyTax" id="companyTax">
         </div>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Surcharge(%) <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm" name="companySurcharge" ng-model="tdsNature.companySurcharge" validator="required" valid-method="submit" message-id="companySurcharge" id="companySurcharge" >
         </div>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Edu Cess(%) <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm" name="companyEduCess" ng-model="tdsNature.companyEduCess" validator="required" valid-method="submit" message-id="companyEduCess" id="companyEduCess" >
         </div>
        </div>
       </fieldset>
      </div>
      <div class="col-sm-6 col-md-6 col-lg-6">
       <fieldset>
        <div class="form-group">
         <label class="col-md-4 control-label"> Section <span style="color: red;">*</span>
         </label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm" name="section" ng-model="tdsNature.section" validator="required" valid-method="submit" message-id="section" id="section">
         </div>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-12 text-center bold">Individual </label>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Tax(%) <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm" name="individualTax" ng-model="tdsNature.individualTax" validator="required" valid-method="submit" message-id="individualTax" id="individualTax">
         </div>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Surcharge(%) <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm" name="individualSurcharge" ng-model="tdsNature.individualSurcharge" validator="required" valid-method="submit" message-id="individualSurcharge" id="individualSurcharge">
         </div>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Edu Cess(%) <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm" name="individualEduCess" ng-model="tdsNature.individualEduCess" validator="required" valid-method="submit" message-id="individualEduCess" id="individualEduCess">
         </div>
        </div>
       </fieldset>
      </div>
     </div>
    </div>
    <!-- /row -->
    <br>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" ng-if="!isEdit" type="button" ng-click="submit(tdsNatureForm)">
        <i class="fa fa-save"></i> Save
       </button>
       <button class="btn btn-success" ng-if="isEdit" type="button" ng-click="update()">
        <i class="fa fa-save"></i> Update
       </button>
       <button class="btn btn-info" ng-if="!isEdit" type="reset" ng-click="reset()">
        <i class="fa fa-undo"></i> Reset
       </button>
       <button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
        <i class="fa fa-close"></i> Cancel
       </button>
      </div>
     </div>
    </div>
   </form>
  </div>
 </div>
</div>
