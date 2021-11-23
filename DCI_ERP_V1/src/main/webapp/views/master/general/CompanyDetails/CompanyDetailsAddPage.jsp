<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb inline-block padding-left-0">
    <li>
     <a>Master</a>
    </li>
    <li>
     <a x-ui-sref="app.master.general">General</a>
    </li>
    <li>
     <a x-ui-sref="app.master.general.companydetails">Company Details</a>
    </li>
    <li>
     <a ng-if="!CompanyDetailsMasterData.edit">Add</a>
          <a ng-if="CompanyDetailsMasterData.edit">Edit</a>
     
    </li>
   </ol>
  </div>
  <div class="panel-body">
   <form class="form-horizontal" name="CompanyDetailsMasterForm" novalidate method="post">
    <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>
       <div class="form-group" ng-if="CompanyDetailsMasterData.edit">
        <label class="col-md-4 control-label">
         Company Code
         <span style="color: red;">*</span>
        </label>
        <label class="col-md-1 control-label">{{CompanyDetailsMasterData.companycode}}</label>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label">
         Organization Name
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="OrganizationName"
          ng-model="CompanyDetailsMasterData.companyname" id="comName" validation="required" friendly-name="Company Name"
          typeahead-min-length='1' typeahead="r.companyname for r in companynameList | filter:$viewValue | limitTo:10">
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label">
         Location
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="Location" ng-model="CompanyDetailsMasterData.location"
          id="location" validation="required" friendly-name="Location" typeahead-min-length='1'
          typeahead="r.location for r in companynameList | filter:$viewValue | limitTo:10">
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-4">
         Address
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <textarea ng-model="CompanyDetailsMasterData.address" name="Address" class="form-control input-sm resize-none"
          validation="required" friendly-name="Address" id="address"></textarea>
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label">
         Telephone Number
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="Telephone Number"
          ng-model="CompanyDetailsMasterData.phoneno" validation="required" friendly-name="Telephone Number" id="phoneno"
          style="text-align: right;">
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label">
         Currency
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <selectivity list="currencyList" property="CompanyDetailsMasterData.currencyCode" name="currencyCode"
          ng-model="CompanyDetailsMasterData.currencyCode" form-name="CompanyDetailsMasterForm" validation="required"
          friendly-name="Currency" id="currencyCode"></selectivity>
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="col-md-4 control-label">Is Active</label>
        <div class="col-md-5">
         <div class="checkbox">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" checked="checked" ng-true-value="'Y'" ng-false-value="'N'" name="isOperation"
            ng-model="CompanyDetailsMasterData.isOperation">
           <i></i>
          </label>
         </div>
        </div>
       </div>
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>
       <div class="form-group">
        <label class="col-md-4 control-label">
         Short Name
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text"  type="text" class="form-control input-sm" name="shortName" ng-model="CompanyDetailsMasterData.shortName"
          validation="required" friendly-name="Short Name" id="shortName">
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label">
         Fax Number
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="Fax Number" ng-model="CompanyDetailsMasterData.faxno"
          validation="required" friendly-name="Fax Number" id="faxno" style="text-align: right;">
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label">
         Email
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="email" class="form-control input-sm" name="Email" ng-model="CompanyDetailsMasterData.email"
          validation="required|email" friendly-name="Email" id="email"  />
        </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label">
         Person Incharge
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" name="Person Incharge"
          ng-model="CompanyDetailsMasterData.personincharge" validation="required" friendly-name="Person Incharge"
          id="personincharge">
        </div>
       </div>
<!--        <div class="form-group"> -->
<!--         <label class="col-md-4 control-label"> -->
<!--          Relationship -->
<!--          <span style="color: red;">*</span> -->
<!--         </label> -->
<!--         <div class="col-md-5"> -->
<!--          <input type="text" class="form-control input-sm" name="Relationship" -->
<!--           ng-model="CompanyDetailsMasterData.relationship" validation="required" friendly-name="Relationship" -->
<!--           id="relationship"> -->
<!--         </div> -->
<!--        </div> -->
<!--        <div class="form-group"> -->
<!--         <label class="col-md-4 control-label">Inter Company Group</label> -->
<!--         <div class="col-md-5"> -->
<!--          <div class="radio radio-inline"> -->
<!--           <label class="i-checks"> -->
<!--            <input type="radio" class="radiobox style-0" ng_model="CompanyDetailsMasterData.intercompgroup" value="Y" -->
<!--             name="intercompgroup" checked="checked"> -->
<!--            <i></i> -->
<!--            Yes -->
<!--           </label> -->
<!--          </div> -->
<!--          <div class="radio  radio-inline"> -->
<!--           <label class="i-checks"> -->
<!--            <input type="radio" class="radiobox style-0" ng_model="CompanyDetailsMasterData.intercompgroup" value="N" -->
<!--             name="intercompgroup" checked="checked"> -->
<!--            <i></i> -->
<!--            No -->
<!--           </label> -->
<!--          </div> -->
<!--         </div> -->
<!--        </div> -->
      </fieldset>
     </div>
    </div>
    <br>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" type="button" ng-click="save(CompanyDetailsMasterForm,CompanyDetailsMasterData)"
        ng-if="!CompanyDetailsMasterData.edit">
        <i class="fa fa-save"></i>
        Save
       </button>
      
       <button class="btn btn-success" type="button" ng-if="CompanyDetailsMasterData.edit"
        ng-click="update(CompanyDetailsMasterForm,CompanyDetailsMasterData)">
        <i class="fa fa-save"></i>
        Update
       </button>
       	<button class="btn btn-info" type="button"  ng-if="!CompanyDetailsMasterData.edit"   ng-click="reset()">
		        					<i class="fa fa-undo"></i>
		        					Reset
	       						</button>
              
                  <button class="btn btn-info" type="button"  ng-if="CompanyDetailsMasterData.edit"   ng-click="reset1()">
               <i class="fa fa-undo"></i>
               Reset
              </button>
       <button class="btn btn-danger" type="reset"  ng-click="cancel()">
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
