<style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}
a{
color:white;
}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" name="empmasterForm" novalidate>
    <div class="row">
     <div class="col-sm-12 col-md-12">
      <tabset justified="true" class="tab-container" Customer="true"> <tab style="background-color:#3d89c5 !important" heading="Profile Picture">
      <div class="col-sm-12 col-md-12 col-lg-12">
       <div class="row ">
        <div class="col-sm-12 col-md-6 col-lg-6">
         <fieldset>
          <div class="form-group">
           <label class="control-label col-md-6 col-lg-6">
            Upload
            <span style="color: red;">*</span>
           </label>
           <div class="col-md-6" style="border: 0px solid red">
            <input type="file" class="form-control btn-primary" name="uplFile" onchange="angular.element(this).scope().selectFile(this)" />
           </div>
          </div>
         </fieldset>
        </div>
        <div class="col-sm-12 col-md-6 col-lg-6">
         <fieldset>
          <div class="form-group">
           <label class="control-label col-md-6 col-lg-6">
            Profile Picture
            <span style="color: red;">*</span>
           </label>
           <div class="col-md-6" style="border: 0px solid red">
            <img ng-src="{{empmasterData.profileImg}}" class="img-responsive">
           </div>
          </div>
         </fieldset>
        </div>
       </div>
      </div>
      <div class="row">
       <div class="col-md-12 form-actions" style="border: 0; background: white;">
        <button class="btn btn-success" id="update" data-ng-click="save()" type="submit">
         <i class="fa fa-save"></i>
         Update
        </button>
        <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
         <i class="fa fa-close"></i>
         Cancel
        </button>
       </div>
      </div>
      </tab> <tab style="background-color:#3d89c5 !important;" heading="Change Password">
      <div class="col-sm-12 col-md-12 col-lg-12">
       <div class="col-sm-12 col-md-6 col-lg-6">
        <fieldset>
        
        <div class="form-group">
          <label for="inputPassword" class="control-label col-md-6 col-lg-6">
           Old Password
           <span style="color: red;">*</span>
          </label>
          <label class="col-md-1 control-label"></label>
          <div class="col-md-6">
           <input type="password" class="form-control text-left" ng-model="empmasterData.olpwd" id="olpwd" name="olpwd" maxlength="50" />
          </div>
         </div>
        </fieldset>
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