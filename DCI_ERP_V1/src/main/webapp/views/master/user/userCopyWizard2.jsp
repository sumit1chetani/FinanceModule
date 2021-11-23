<br>
<div class="row book-widget-row">
 <div class="col-md-4">
  <div class="form-group">
   <label class="col-md-4 control-label">
    Company
    <span style="color: red;">*</span>
   </label>
   <div class="col-md-8">
   <selectivity list="companyList" data-ng-model="toggleUser.companyCodeWz2" property="toggleUser.companyCodeWz2" id="companyCodeWz2"
         object="companyCodeWz2" name="companyCodeWz2" ></selectivity>
    <!-- <select ng-model="companyCodeWz2" class="form-control input-sm" ng-change="getUsers(companyCodeWz2)"
     ng-options="objCompany.companyCode as objCompany.companyLocation for objCompany in companyList"></select> -->
    <!--  <selectivity list="companyList" ng-model="companyCodeWz2"  ng-change="getUsers(companyCodeWz2)" ></selectivity> -->
   </div>
  </div>
 </div>
 <div class="col-md-4">
  <div class="form-group">
   <label class="col-md-4 control-label">
    From User
    <span style="color: red;">*</span>
   </label>
   <div class="col-md-8">
   <selectivity list="userListWz2" data-ng-model="toggleUser.userId1" property="toggleUser.userId1" id="userId1"
         object="userId1" name="userId1" ></selectivity>
    <!-- <select ng-model="userMapped1" class="form-control input-sm" ng-options="objUser as objUser.userName for objUser in userListWz2"></select> -->
    <!-- <selectivity list="userList"  ng-model="user.userId1"></selectivity> -->
   </div>
   
  </div>
 </div>
 <div class="col-md-4">
  <div class="form-group">
   <label class="col-md-4 control-label">
    To User
    <span style="color: red;">*</span>
   </label>
   <div class="col-md-8">
   <selectivity list="userListWz2" data-ng-model="toggleUser.userId2" property="toggleUser.userId2" id="userId2"
         object="userId2" name="userId2" ></selectivity>
   <!--  <select ng-model="userMapped2" class="form-control input-sm" ng-options="objUser as objUser.userName for objUser in userListWz2"></select> -->
    <!-- <selectivity list="userListWz2" ng-model="user.userId2"></selectivity> -->
   </div>
  </div>
 </div>
</div>