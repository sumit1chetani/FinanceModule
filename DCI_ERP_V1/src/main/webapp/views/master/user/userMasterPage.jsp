<style type="text/css">
/* .panel-body {
	padding-left: 0px;
	padding-right: 0px;
} */
.property-head-code {
	font-size: 14px;
}

.property-head-name {
	font-size: 9px;
}

table ,tr td{
    border:1px solid red
}
tbody {
    display:block;
    height:250px;
    overflow-y:scroll
}
thead, tbody tr {
    display:table;
    width:100%;
    table-layout:fixed;/* even columns width , fix width of table too*/
}
thead {
    width: calc( 100% - 1em )/* scrollbar is average 1em/16px width, remove it from thead width */
}
table {
    width:100px;
}

</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form ">
  <%@include file="/views/templates/panel-header-form.jsp"%>
     <input type="hidden" value="${form_code}" id="form_code_id" /> 
  <div class="panel-body">
   <form class="form-horizontal" name="userMasterForm" role="form">
    <!-- Show Copy Wizard 1 -->
   <div class="row " ng-hide="showCopyWizard">
     <div class="col-md-4">
     <fieldset>
      <div class="form-group">
      
       <label class="col-md-4 control-label">
        User
        <span style="color: red;">*</span>
       </label>
      <div class="col-md-8" > 
     <!-- <div class="col-md-8 no-padding padding-top-5 padding-left-5" > -->
         <selectivity list="userList"  property="user.userId" id="userId"></selectivity>
       
         
        <!-- <select ng-model="user" class="form-control input-sm" ng-change="getUserPermissions()" ng-options="objUser as objUser.userName for objUser in userList"></select> -->
       </div>
      </div>
      </fieldset>
     </div>
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-4 control-label">Organization</label>
       <div class="col-md-8">
       <!--  <select ng-model="company" class="form-control input-sm" ng-change="getUserPermissions()"
         ng-options="objCompany as objCompany.companyLocation for objCompany in companyList"></select> -->
         
           <selectivity list="companyList"  property="company.companyCode"></selectivity> 
         
       </div>
      </div>
     </div>
     <!-- mode -->
     <!--  <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-4 control-label">Mode</label>
       <div class="col-md-8">
<selectivity list="modeList" ng-model="grldinvoiceData.mode"
											validation="required" friendly-name="Mode"
											property="grldinvoiceData.mode" id="mode" name="mode"
											form-name="deliveryorderForm"></selectivity>
										
										 		<div class="col-md-8 "
										class="selectivity-input example-input selectivity-slot voyage_sel">
									<select id="modeid" multiple="multiple" name="modeid"
									friendly-name="mode"  form-name="userMasterForm"
										ng-model="user.modeid" validation="required"
										ng-options="option.text for option in modeList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in modeList" 
											value="{{getOptionId(option)}}"
											data-ng-bind-template="{{option.modeid}}"></option>
									</select>										
       </div>
      </div>
     </div> -->
     <!-- end !st Div -->
     <div class="col-md-4">
      <div class="form-group">
       <label class="col-md-4 control-label">Module</label>
       <div class="col-md-8">
       <!--  <select ng-model="module" class="form-control input-sm" ng-change="getUserPermissions()"
         ng-options="objModule as objModule.moduleName for objModule in moduleList"></select> -->
         
       <selectivity list="moduleList"  property="module.moduleCode"></selectivity>
       </div>
      </div>
     </div>
    <!--  <fieldset>
      <div class="form-group">
      
       <label class="col-md-4 control-label">
        Form Name
        <span style="color: red;">*</span>
       </label>
      <div class="col-md-8" > 
     <div class="col-md-8 no-padding padding-top-5 padding-left-5" >
         <selectivity list="formNList"  property="formN.formcode" id="formcode"></selectivity>
        <br>
        <br>
        <br>
         
        <select ng-model="user" class="form-control input-sm" ng-change="getUserPermissions()" ng-options="objUser as objUser.userName for objUser in userList"></select>
       </div>
      </div>
      </fieldset>   -->   
      
   	<div class="form-group " >
                 <label class="col-md-1 control-label">Form Name<span
                 style="color: red">*</span></label>
                  <div class="col-md-2">
                     <selectivity list="userFormList"
                           property="form.formName" id="formName" name="formName"
                        ng-model="form.formName" object="formName"
                     friendly-name="formName" validation="required"
                    form-name="formName"></selectivity>
                   </div>
             </div>     

     <!-- end 2nd Div -->
    </div>
    <!-- User & Copy -->
    <!-- Show Copy Wizard -->
    <div class="row" data-ng-show="showCopyWizard">
     <div class="col-md-3"></div>
     <div class="col-md-3 text-center">
      <fieldset>
       <div class="form-group">
        <input type="radio" name="copyWizardType" ng-model="copyWizardType" value="1" />
        Company
       </div>
      </fieldset>
     </div>
     <div class="col-md-3  text-center">
      <fieldset>
       <div class="form-group">
        <input type="radio" name="copyWizardType" ng-model="copyWizardType" value="2" />
        User
       </div>
      </fieldset>
     </div>
     <div class="col-md-3"></div>
    </div>
   <div ng-show="showCopyWizard1&&showCopyWizard">
     <%@include file="userCopyWizard1.jsp"%>
    </div>
    <div ng-show="showCopyWizard2&&showCopyWizard">
     <%@include file="userCopyWizard2.jsp"%>
    </div> 
    <!-- end div row -->
    <!-- Button -->
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" type="submit" ng-click="saveUserPermissions()" ng-hide="showCopyWizard">
        <i class="fa fa-save"></i>
        Save
       </button>
       <button class="btn btn-info" type="submit" ng-click="getUserPermissions()" ng-hide="showCopyWizard">
        <i class="fa fa-refresh"></i>
        Refresh
       </button>
 <button class="btn btn-primary" id="exportXl"  type="submit" ng-click="excel()" ng-hide="showCopyWizard">
        <i class="fa fa-save"></i>
        Export
       </button>
       <button class="btn btn-primary" id="exportXl"  type="submit" ng-click="excelCompanyWise()" ng-hide="showCopyWizard">
        <i class="fa fa-save"></i>
        Export Company Wise
       </button>
       <button class="btn btn-success" type="submit" ng-show="showCopyWizard1&&showCopyWizard" ng-click="insertCompanyToCompany()">
        <i class="fa fa-save"></i>
        Copy
       </button>
       <button class="btn btn-success" type="submit" ng-show="showCopyWizard2&&showCopyWizard" ng-click="insertUserToUser()">
        <i class="fa fa-save"></i>
        Copy
       </button>
       <button class="btn btn-danger" type="button" ng-click="toggleCopyWizard()">
        <i class="fa fa-copy"></i>
        {{showCopyText}}
       </button>
       <button class="btn btn-primary" id="exportXl"  type="submit" ng-click="excelRightsFormWise()" ng-hide="showCopyWizard">
        <i class="fa fa-save"></i>
        Export Form Wise
       </button>       

       
      </div>
     </div>
    </div>
<div class="excelexport"></div>
   <br>
   <br>
   <div style="width: 100%; class="table-responsive " ng-show="formList.length > 0 && !showCopyWizard">
    <table class="table table-striped  b table-bordered table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th class="text-center width_15" >Form Name</th>
       <th class="text-center">#</th>
       <th class="text-center" ng-repeat="objProperty in propertyList">
        <small class="property-head-name">{{objProperty.propertyName}}</small>
        <small class="property-head-code">{{objProperty.propertyCode}}</small>
       </th>
      </tr>
      <tr>
       <th class="text-center"></th>
       <th class="text-center">
        <input type="checkbox" ng-change="changePropertyAll()" ng-model="propertyAll">
       </th>
       <th class="text-center" ng-repeat="objProperty in propertyList">
        <input type="checkbox" ng-change="changePropertyMod(objProperty.enabled,$index)" ng-model="objProperty.enabled">
       </th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objFormMasterBean in formList">
       <td class="width_15">{{objFormMasterBean.formName}}</td>
       <td class="text-center" ng-hide="objFormMasterBean.parentForm">
        <input type="checkbox" ng-change="changePropertyRow(objFormMasterBean,objFormMasterBean.propertyRow)" ng-model="objFormMasterBean.propertyRow">
       </td>
       <td class="text-center" ng-repeat="objFormProperty in objFormMasterBean.lFormPropertyBean">
        <input type="checkbox" ng-model="objFormProperty.enabled" ng-disabled="objFormProperty.available!=1">
       </td>
      </tr>
     </tbody>
    </table>
   </div>
      </form>
  </div>
 </div>
</div>