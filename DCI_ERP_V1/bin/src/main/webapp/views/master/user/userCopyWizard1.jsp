<br>
<div class="row book-widget-row">
 <div class="col-md-4 ">
  <div class="form-group">
   <label class="col-md-4 control-label">
    User
    <span style="color: red;">*</span>
   </label>
   <div class="col-md-8 input-sm">
    <!-- <select ng-model="userCompanyMapped" class="form-control input-sm" ng-change="splitCompanies(userCompanyMapped)"
     ng-options="objUser as objUser.userName for objUser in userList"></select> -->
     <selectivity list="userList"  property="companyMapped1.userId" ng-model="companyMapped1.userId" id="userId" name="userId"></selectivity>
   </div>
  </div>
   
  
 </div>
 <div class="col-md-4">
  <div class="form-group">
   <label class="col-md-4 control-label">
    From Company
    <span style="color: red;">*</span>
   </label>
   <div class="col-md-8">
   <!--  <select ng-model="companyMapped1" class="form-control input-sm"
     ng-options="objCompany as objCompany.companyName for objCompany in companyCodesMapped"></select> -->
     <selectivity list="companyList" ng-model="companyMapped1.fromCompany" property="companyMapped1.fromCompany" id="fromCompany" name="fromCompany"></selectivity>
   </div>
  </div>
 </div>
 <div class="col-md-4 ">
  <div class="form-group">
   <label class="col-md-4 control-label">
    To Company
    <span style="color: red;">*</span>
   </label>
   <div class="col-md-8">
    <!-- <select ng-model="companyMapped2" class="form-control input-sm"
     ng-options="objCompany as objCompany.companyName for objCompany in companyCodesNotMapped"></select> -->
     <selectivity list="companyList" ng-model="companyMapped1.toCompany" property="companyMapped1.toCompany" id="toCompany" name="toCompany"></selectivity>
   </div>
  </div>
 </div>
</div>
