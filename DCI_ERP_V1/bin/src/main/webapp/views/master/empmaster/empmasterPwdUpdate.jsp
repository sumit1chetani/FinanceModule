<style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form"> 
  <div class="panel-body">
   <form class="form-horizontal" name="empmasterForm" novalidate>
    <div class="row">
     <div class="col-sm-12 col-md-12">
      <tabset justified="true" class="tab-container" Customer="true">   <tab heading="Change Password">
      <div class="col-sm-12 col-md-12 col-lg-12">
       <div class="col-sm-12 col-md-6 col-lg-6">
        <fieldset>
         <div class="form-group" data-ng-if="!visibility">
		   <label class="control-label" style="color: red; font-size:18px;">
		    Your password is expired. Please update new password to continue.
		   </label>
		 </div>
         <div class="form-group">
          <label for="inputPassword" class="control-label col-md-6 col-lg-6">
           New Password
           <span style="color: red;">*</span>
          </label>
          <label class="col-md-1 control-label"></label>
          <div class="col-md-6">
           <input type="password" class="form-control text-left" ng-model="empmasterData.newpswd" id="newpswd" name="newpswd" maxlength="50" />
          </div>
         </div>
        </fieldset>
        <fieldset>
         <div class="form-group">
          <label for="inputPassword" class="control-label col-md-6 col-lg-6">
           Re Type Password
           <span style="color: red;">*</span>
          </label>
          <label class="col-md-1 control-label"></label>
          <div class="col-md-6">
           <input type="password" class="form-control text-left" ng-model="empmasterData.confrmPwd" id="confrmPwd" name="confrmPwd" maxlength="50" />
          </div>
         </div>
        </fieldset>
       </div>
      </div>
      <div class="row">
       <div class="col-md-12 form-actions" style="border: 0; background: white;">
        <button class="btn btn-success" id="update" data-ng-click="changePassword()" type="submit">
         <i class="fa fa-save"></i>
         Change Password
        </button>
        <button class="btn btn-danger" type="reset" class="btn btn-success" data-ng-click="cancel()">
         <i class="fa fa-close"></i>
         Cancel
        </button>
       </div>
      </div>
      </tab> </tabset>
     </div>
    </div>
   </form>
  </div>
 </div>
</div>