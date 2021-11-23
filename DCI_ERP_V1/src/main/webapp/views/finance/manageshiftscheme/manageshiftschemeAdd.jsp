<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div>
		
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="shiftSchemeMasterAddForm" novalidate method="post">
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
          <div class="col-sm-5 col-md-5 col-lg-5">
           <fieldset>
            <div class="form-group" id="schemeName">
             <label class="col-md-6 control-label"> Scheme Name
             </label>
             <div class="col-md-5">
              <input type="text" class="form-control input-sm"
               name="schemeName" id="schemeName" 
               data-ng-model="shiftSchemeMasterobj.schemeName"
               validation="required" friendly-name="Scheme Name" maxlength="50">
             </div>
            </div>
            <div class="form-group" id="schemeNameReadOnly">
             <label class="col-md-6 control-label"> Scheme Name
             </label>
             <div class="col-md-5">
              <input type="text" disabled  class="form-control input-sm"
               name="schemeName"
               data-ng-model="shiftSchemeMasterobj.schemeName"
               >
             
             </div>
            </div>
           </fieldset>
          </div>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12"
          style="padding-left: 98px;">
          <fieldset>
           <div class="form-group">
            <label class="bold">Shift Scheme validity Period
           </div>
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12">
          <!-- <div class="col-sm-5 col-md-5 col-lg-5">
           <div class="form-group">
            <label class="col-md-6 control-label">Validity From</label>
            <div class="col-md-5">
          <div class='input-group date datetimepick'>
            <div class="dropdown">
             <a class="dropdown-toggle" id="validityFrom" role="button"
              data-toggle="dropdown" data-target="#" href="#">
              <div class="input-group">
               <input type="text" class="form-control"
                placeholder="dd/mm/yyyy" name="validityFrom"
                validation="required" friendly-name="Validity From"
                id="validityFrom"
                data-ng-model="shiftSchemeMasterobj.validityFrom"><span
                class="input-group-addon"><i
                class="glyphicon glyphicon-calendar"></i></span>
              </div>
             </a>
             <ul class="dropdown-menu" role="menu"
              aria-labelledby="dLabel">
              <datetimepicker data-ng-model="shiftSchemeMasterobj.validityFrom"
               data-on-set-time="shiftSchemeMasterobj.validityFrom = onDateSet(newDate)"
               data-datetimepicker-config="{ dropdownSelector: '#validityFrom',startView:'day', minView:'day'}" />
             </ul>
            </div>
           </div>
            </div>
           </div>
          </div> -->
          
          <div class="form-group">
								<label class="col-md-3 control-label">Validity From<span
									style="color: red;">*</span></label>

								<div class="col-md-2">
									<ng-bs3-datepicker data-ng-model="shiftSchemeMasterobj.validityFrom"
										id="validityFrom" name="validityFrom" form-name="validityFrom" friendly-name="validityFrom"
										validation="required" />
								</div>
							</div>
          <!-- <div class="col-sm-6 col-md-6 col-lg-6">
           <div class="form-group">
            <label class="col-md-6 control-label">Validity To</label>
            <div class="col-md-4">
             <div class='input-group date datetimepick'>
            <div class="dropdown">
             <a class="dropdown-toggle" id="validityTo" role="button"
              data-toggle="dropdown" data-target="#" href="#">
              <div class="input-group">
               <input type="text" class="form-control"
                placeholder="dd/mm/yyyy" name="validityTo" id="validityTo"
                validation="required" friendly-name="Validity To"
                data-ng-model="shiftSchemeMasterobj.validityTo"><span
                class="input-group-addon"><i
                class="glyphicon glyphicon-calendar"></i></span>
              </div>
             </a>
             <ul class="dropdown-menu" role="menu"
              aria-labelledby="dLabel">
              <datetimepicker data-ng-model="shiftSchemeMasterobj.validityTo"
               data-on-set-time="shiftSchemeMasterobj.validityTo = onDateSet(newDate)"
               data-datetimepicker-config="{ dropdownSelector: '#validityTo',startView:'day', minView:'day'}" />
             </ul>
            </div>
           </div> 
            </div>
           </div>
          </div> -->
          
             
          <div class="form-group">
								<label class="col-md-3 control-label">Validity To<span
									style="color: red;">*</span></label>

								<div class="col-md-2">
									<ng-bs3-datepicker data-ng-model="shiftSchemeMasterobj.validityTo"
										id="validityTo" name="validityTo" form-name="validityTo" friendly-name="validityTo"
										validation="required" />
								</div>
							</div>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12"
          style="padding-left: 98px;">
          <fieldset>
           <div class="form-group">
            <label class="bold">Shift Scheme Definition</label>
           </div>
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12"
          style="padding-left: 80px;">
          <fieldset>
           <div class="form-group">
            <label class="col-md-1 control-label">Days</label>
            <div class="col-md-2" style="width: 13%;">
             <input type="text" class="form-control input-sm"
              name="sunday"
              data-message-id="sunday" readonly
              data-ng-model="shiftSchemeMasterobj.sunday"
              data-validator="required" data-valid-method="submit">
            </div>
            <div class="col-md-2" style="width: 13%;">
             <input type="text" class="form-control input-sm"
              name="monday"
              data-message-id="monday" readonly
              data-ng-model="shiftSchemeMasterobj.monday"
              data-validator="required" data-valid-method="submit">
            </div>
            <div class="col-md-2" style="width: 13%;">
             <input type="text" class="form-control input-sm"
              name="tuesday"
              data-message-id="tuesday" readonly
              data-ng-model="shiftSchemeMasterobj.tuesday"
              data-validator="required" data-valid-method="submit">
            </div>
            <div class="col-md-2" style="width: 13%;">
             <input type="text" class="form-control input-sm"
              name="wednesday"
              data-message-id="wednesday" readonly
              data-ng-model="shiftSchemeMasterobj.wednesday"
              data-validator="required" data-valid-method="submit">
            </div>
            <div class="col-md-2" style="width: 13%;">
             <input type="text" class="form-control input-sm"
              name="thursday"
              data-message-id="thursday" readonly
              data-ng-model="shiftSchemeMasterobj.thursday"
              data-validator="required" data-valid-method="submit">
            </div>
            <div class="col-md-2" style="width: 13%;">
             <input type="text" class="form-control input-sm"
              name=friday
              data-message-id="friday" readonly
              data-ng-model="shiftSchemeMasterobj.friday"
              data-validator="required" data-valid-method="submit">
            </div>
            <div class="col-md-2" style="width: 13%;">
             <input type="text" class="form-control input-sm"
              name="saturday"
              data-message-id="saturday" readonly
              data-ng-model="shiftSchemeMasterobj.saturday"
              data-validator="required" data-valid-method="submit">
            </div>
           </div>
           <div class="form-group">
            <label class="col-md-1 control-label">Shift Name
            </label>
            <div class="col-md-2" style="width: 13%;">
             <%-- <select class="form-control"
              name="<spring:message code="label.shiftSchemeMaster.sundayCompany"></spring:message>"
             validation="required" friendly-name="Sunday Shift Name"
              data-ng-model="shiftSchemeMasterobj.sundayCompany"
              ng-options="shiftNameValues.shiftCode as shiftNameValues.shiftName  for shiftNameValues in shiftNameList">
              <option value="" selected="selected">Select</option>
             </select> --%>
             <selectivity list="shiftNameList" property="shiftSchemeMasterobj.sundayCompany"
					ng-model="shiftSchemeMasterobj.sundayCompany" form-name="shiftSchemeMasterAddForm" 
					validation="required" friendly-name="Sunday Shift Name"
					name="sundayCompany" id="sundayCompany"></selectivity>
            </div>
            <div class="col-md-2" style="width: 13%;">
             <%-- <select class="form-control"
              name="<spring:message code="label.shiftSchemeMaster.mondayCompany"></spring:message>"
               validation="required" friendly-name="Monday Shift Name"
              ng-model="shiftSchemeMasterobj.mondayCompany"
              ng-options="shiftNameValues.shiftCode as shiftNameValues.shiftName  for shiftNameValues in shiftNameList">
              <option value="" selected="selected">Select</option>
             </select> --%>
             <selectivity list="shiftNameList" property="shiftSchemeMasterobj.mondayCompany"
					ng-model="shiftSchemeMasterobj.mondayCompany" form-name="shiftSchemeMasterAddForm" 
					validation="required" friendly-name="Monday Shift Name"
					name="mondayCompany" id="mondayCompany"></selectivity>
            </div>
            <div class="col-md-2" style="width: 13%;">
             <%-- <select class="form-control"
              name="<spring:message code="label.shiftSchemeMaster.tuesdayCompany"></spring:message>"
			   validation="required" friendly-name="Tuesday Shift Name"
              ng-model="shiftSchemeMasterobj.tuesdayCompany"
              ng-options="shiftNameValues.shiftCode as shiftNameValues.shiftName  for shiftNameValues in shiftNameList">
              <option value="" selected="selected">Select</option>
             </select> --%>
             <selectivity list="shiftNameList" property="shiftSchemeMasterobj.tuesdayCompany"
					ng-model="shiftSchemeMasterobj.tuesdayCompany" form-name="shiftSchemeMasterAddForm" 
					validation="required" friendly-name="Tuesday Shift Name"
					name="tuesdayCompany" id="tuesdayCompany"></selectivity>
            </div>
            <div class="col-md-2" style="width: 13%;">
             <%-- <select class="form-control"
              name="<spring:message code="label.shiftSchemeMaster.wednesdayCompany"></spring:message>"
              validation="required" friendly-name="Wednesday Shift Name"
              ng-model="shiftSchemeMasterobj.wednesdayCompany"
              ng-options="shiftNameValues.shiftCode as shiftNameValues.shiftName  for shiftNameValues in shiftNameList">
              <option value="" selected="selected">Select</option>
             </select> --%>
             <selectivity list="shiftNameList" property="shiftSchemeMasterobj.wednesdayCompany"
					ng-model="shiftSchemeMasterobj.wednesdayCompany" form-name="shiftSchemeMasterAddForm" 
					validation="required" friendly-name="Wednesday Shift Name"
					name="wednesdayCompany" id="wednesdayCompany"></selectivity>
            </div>
            <div class="col-md-2" style="width: 13%;">
             <%-- <select class="form-control"
              name="<spring:message code="label.shiftSchemeMaster.thursdayCompany"></spring:message>"
              validation="required" friendly-name="Thursday Shift Name"
              ng-model="shiftSchemeMasterobj.thursdayCompany"
              ng-options="shiftNameValues.shiftCode as shiftNameValues.shiftName  for shiftNameValues in shiftNameList">
              <option value="" selected="selected">Select</option>
             </select> --%>
             <selectivity list="shiftNameList" property="shiftSchemeMasterobj.thursdayCompany"
					ng-model="shiftSchemeMasterobj.thursdayCompany" form-name="shiftSchemeMasterAddForm" 
					validation="required" friendly-name="Thursday Shift Name"
					name="thursdayCompany" id="thursdayCompany"></selectivity>
            </div>
            <div class="col-md-2" style="width: 13%;">
             <%-- <select class="form-control"
              name="<spring:message code="label.shiftSchemeMaster.fridayCompany"></spring:message>"
              validation="required" friendly-name="Friday Shift Name"
              ng-model="shiftSchemeMasterobj.fridayCompany"
              ng-options="shiftNameValues.shiftCode as shiftNameValues.shiftName  for shiftNameValues in shiftNameList">
              <option value="" selected="selected">Select</option>
             </select> --%>
             <selectivity list="shiftNameList" property="shiftSchemeMasterobj.fridayCompany"
					ng-model="shiftSchemeMasterobj.fridayCompany" form-name="shiftSchemeMasterAddForm" 
					validation="required" friendly-name="Friday Shift Name"
					name="fridayCompany" id="fridayCompany"></selectivity>
            </div>
            <div class="col-md-2" style="width: 13%;">
             <%-- <select class="form-control"
              name="<spring:message code="label.shiftSchemeMaster.saturdayCompany"></spring:message>"
              validation="required" friendly-name="Saturday Shift Name"
              ng-model="shiftSchemeMasterobj.saturdayCompany"
              ng-options="shiftNameValues.shiftCode as shiftNameValues.shiftName  for shiftNameValues in shiftNameList">
              <option value="" selected="selected">Select</option>
             </select> --%>
             <selectivity list="shiftNameList" property="shiftSchemeMasterobj.saturdayCompany"
					ng-model="shiftSchemeMasterobj.saturdayCompany" form-name="shiftSchemeMasterAddForm" 
					validation="required" friendly-name="Saturday Shift Name"
					name="saturdayCompany" id="saturdayCompany"></selectivity>
            </div>
           </div>
          </fieldset>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="submit"
            ng-if="!isEdit"
            ng-click="validate(shiftSchemeMasterAddForm,shiftSchemeMasterobj)">
            <i class="fa fa-save"></i>
        Save
           </button>
           <button class="btn btn-success" type="submit"
            ng-if="isEdit==true"
            ng-click="validate(shiftSchemeMasterAddForm,shiftSchemeMasterobj)">
            <i class="fa fa-save"></i>
            Update
           </button>
           <button class="btn btn-info ng-scope" type="submit"
            data-ng-click="reset(shiftSchemeMasterAddForm)"
            class="btn btn-success">
            <i class="fa fa-undo"></i>
Reset           </button>
           <button class="btn btn-danger" type="button"
            class="btn btn-success" data-ng-click="cancel()">
            <i class="fa fa-close"></i>
Cancel           </button>
          </div>
         </div>
        </div>
        <br>
        <br>
        <div class="col-sm-12 col-md-12 col-lg-12"
         style="padding-left: 78px;">
         <fieldset>
          <div class="form-group">
           <label>Shift Scheme for Employees witha validity and types of shifts in a week can be saved.</label>
          </div>
         </fieldset>
        </div>
        <div class="col-sm-12 col-md-12 col-lg-12"
         style="padding-left: 78px;">
         <fieldset>
          <div class="form-group">
           <label>Shift scheme can be allocated to Employees through shift Allocation.</label>
          </div>
         </fieldset>
        </div>
       </form>
      </div>
     </div>
    </div>
   </article>
  </div>
 </section>
 </div>

