<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="leaveTypeForm"
        >
        <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
          <div class="col-md-12">
           <fieldset>
           
           
            <div class="form-group col-md-6 col-md-6">
             <label class="col-md-6 control-label">  
                        Leave Code
             <spring:message
               code='label.asterisk.symbol'></spring:message>
             </label>
             <div class="col-md-5	">
              <input type="text" class="form-control input-sm"
               maxlength="25"
               name="<spring:message code='label.leave.name'></spring:message>"
               message-id="leaveTypeName"
               data-ng-model="leaveType.leaveTypeName"
               data-validator="required" data-valid-method="submit">
             </div>
            </div>
            <div class="form-group col-md-6 col-md-6">
             <label class="col-md-4 control-label" > <%-- <spring:message
               code='label.leave.code'></spring:message> --%>
            Leave Name
                <spring:message
               code='label.asterisk.symbol'></spring:message>
             </label>
             <div class="col-md-5">
              <input type="text" class="form-control input-sm"
               data-ng-disabled="isEdit" maxlength="5"
               name="<spring:message code='label.leave.code'></spring:message>"
               message-id="leaveTypeShortName"
               data-ng-model="leaveType.shortName"
               data-validator="required" data-valid-method="submit">
             </div>
            </div>
          
           </fieldset>
          </div>
          <div class="col-sm-6 col-md-6 col-lg-6">
          <div class="form-group" >
									<label class="col-md-6 control-label"> Branch </label>
									<div class="col-md-5">
										<select id="branch" multiple="multiple" name="branch"
											ng-model="leaveType.branch"
											ng-options="option.text for option in branchList"
											friendly-name="branch" data-dropdownmultiselect>
											<option data-ng-repeat="option in branchList"
												value="{{getOptionId(option)}}"
												ng-selected="isOptionSelected(option)"
												data-ng-bind-template="{{option.text}}"></option>
										</select>
									</div>
								</div>
								</div>
            
            <!-- <div class="col-sm-7 col-md-7 col-lg-7">
													<div class="form-group">
														<label class="col-md-5 control-label">Years<span style="color:red">*</span>
														</label>
														<div class="col-md-4">
															<select class="form-control input-sm" ng-model="leaveType.year" name="Year"
																data-message-id="year"validation="required" friendly-name="Year">
																<option value="">--Select--</option>
																<option value="2020">2020</option>
																<option value="2019">2019</option>
																<option value="2018">2018</option>
																<option value="2017">2017</option>
																<option value="2016">2016</option>
																<option value="2015">2015</option>
																<option value="2014">2014</option>
																<option value="2013">2013</option>
																<option value="2012">2012</option>
															</select>
														</div>
													</div>
												</div> -->
												       <!--      <div class="col-sm-7 col-md-7 col-lg-7">
												
												<div class="form-group">
													<label class="col-md-5 control-label">Employee Name</label>
													<div class="col-md-4">
														<selectivity list="employeeList"
															property="leaveType.empId" id="empId" name="empId"
															friendly-name="Employee Name" form-name="attendanceAddForm"
															ng-model="leaveType.empId" validation="required"> </selectivity>
													</div>
												</div>
												</div> -->
          <div class="col-md-12">
           <fieldset>
            <div class="form-group col-md-8 col-md-8">
                         <div class="col-md-8 control-label"
              style="padding-top: 0px; width: 64.5%;">
              <div class="checkbox"> 
                <label> <input type="checkbox"
                class="checkbox style-0"
                data-ng-model="leaveType.canCarryForward"
                data-ng-click="leaveType.carryForwardLimit='';"
                name="<spring:message code='label.has.carry.forward'></spring:message>">
                <span></span>
               </label>
              </div>
             </div>
                <div class="col-md-4 control-label-left">
                <label> <%-- <spring:message
               code='label.has.carry.forward'></spring:message> --%>
               Has Carry Forwarded
             </label>
            </div>
            </div>
            <div class="form-group col-md-6 col-md-6"
             data-ng-if="leaveType.canCarryForward">
             <label class="col-md-4 control-label">Carry Forward Limit 
             </label>
             <div class="col-md-4">
              <input type="text" class="form-control input-sm text-right" placeholder="0"
               name="<spring:message code='label.carry.forward.limit'></spring:message>"
               data-message-id="carryForwardLimit"
               data-ng-model="leaveType.carryForwardLimit"
               data-validator="required" data-valid-method="submit">
             </div>
            </div>
           </fieldset>
          </div>
          <div class="col-sm-12">
      <fieldset>
     
               <div class="form-group col-md-8 col-md-8">
             <div class="col-md-8 control-label"
              style="padding-top: 0px; width: 64.5%;">
              <div class="checkbox"> 
               <label> <input type="checkbox"
                class="checkbox style-0" name="encashable"
                data-ng-model="leaveType.encashable"> <span></span>
               </label>
              </div>
             </div>
             <div class="col-md-4 control-label-left">
              <label> Encashable(Y/N)
              </label>
             </div>
            </div>
            </fieldset>
            </div>
            
             <div class="col-sm-12">
      <fieldset>
     
               <div class="form-group col-md-8 col-md-8">
             <div class="col-md-8 control-label"
              style="padding-top: 0px; width: 64.5%;">
              <div class="checkbox"> 
             <label> <input type="checkbox"
                class="checkbox style-0"
                name="<spring:message code='label.applicable.under.probation.period'></spring:message>"
                data-ng-model="leaveType.applicableUnderProbation"
                data-ng-click="leaveType.maxDaysUnderProbation='';">
                <span></span>
               </label>
              </div>
             </div>
             <label class="col-md-4 control-label-left"> Applicable under Probation Period
             </label>
            </div>
            <div class="form-group col-md-4 col-md-4"
             data-ng-if="leaveType.applicableUnderProbation">
             <label class="col-md-4 control-label">Max Days Allowed 
             </label>
             <div class="col-md-4">
              <input type="text" class="form-control input-sm" placeholder="0.00"
               name="MaxDaysAllowed"
               message-id="maxDaysUnderProbation"
               data-ng-model="leaveType.maxDaysUnderProbation" 
               ng-change="checkNoOfDays(leaveType.maxDaysUnderProbation)"
               validation="required" data-valid-method="submit">
             </div>
            </div>
           </fieldset>
          </div>
         <!--  <div class="col-md-12">
           <fieldset>
            <div class="form-group col-md-8 col-md-8">
             <div class="col-md-8 control-label"
              style="padding-top: 0px; width: 64.5%;">
              <div class="checkbox">
               <label> <input type="checkbox"
                class="checkbox style-0"
                name="Sick Leave"
                data-ng-click="leaveType.maternityLeave = false;leaveType.maxDaysMedicalLeave = '';male=false;both=false"
                data-ng-model="leaveType.medical"> <span></span>
               </label>
              </div>
             </div>
             <label class="col-md-4 control-label-left"> Sick Leave
             </label>
            </div>
            <div class="form-group col-md-4 col-md-4"
             data-ng-if="leaveType.medical">
             <label class="col-md-5 control-label"> SL Max Days per Request
             </label>
             <div class="col-md-4">
              <input type="text" class="form-control input-sm" placeholder="0.00"
               name="SL Max Days per Request"
               message-id="maxDaysMedicalLeave"
               data-ng-model="leaveType.maxDaysMedicalLeave"
               ng-change="checkmaxDaysMedicalLeave(leaveType.maxDaysMedicalLeave)" 
               validation="required">
               
             </div>
            </div>
           </fieldset>
          </div> -->
          <%-- <div class="col-md-12">
           <fieldset>
            <div class="form-group col-md-8 col-md-8">
             <div class="col-md-8 control-label"
              style="padding-top: 0px; width: 64.5%;">
              <div class="checkbox">
               <label> <input type="checkbox"
                class="checkbox style-0"
                name="<spring:message code='label.maternity.leave'></spring:message>"
                data-ng-click="maternityChange(leaveType.maternityLeave);"
                data-ng-model="leaveType.maternityLeave"> <span></span>
               </label>
              </div>
             </div>
             <label class="col-md-4 control-label-left"> Maternity Leave
             </label>
            </div>
            <div class="form-group col-md-4 col-md-4"
             data-ng-if="leaveType.maternityLeave">
             <label class="col-md-5 control-label"> ML Max Days per Request
             </label>
             <div class="col-md-4">
              <input type="text" class="form-control input-sm" placeholder="0"
               name="ML Max Days per Request"
               message-id="maxDaysMaternityLeave"
               data-ng-model="leaveType.maxDaysMaternityLeave"
                ng-change="checkmaxDaysMaternityLeave(leaveType.maxDaysMaternityLeave)" 
               validation="required" data-valid-method="submit">
             </div>
            </div>
           </fieldset>
          </div> --%>
         
           <div class="col-md-12">
            <fieldset>
            <div class="form-group col-md-8 col-md-8">
             <div class="col-md-8 control-label"
              style="padding-top: 0px; width: 64.5%;">
              <div class="checkbox">
               <label> <input type="checkbox"
                class="checkbox style-0" name="active"
                data-ng-model="leaveType.status"> <span></span>
               </label>
              </div>
             </div>
             <label class="col-md-3 control-label-left">Active
             </label>
            </fieldset>
           </div>
 <div class="col-md-12">
           <div class="col-md-6">
            <fieldset>
             <div class="col-md-6 col-md-offset-5 control-label-left">
              <div class="radio radio-inline">
               <label class="i-checks"> <input type="radio" 
                data-ng-model="leaveType.gender" value="0" name="gender" ng-disabled="both"
                class="ng-pristine ng-untouched ng-valid"> 
                <i></i>
                Both
               </label>
              </div>
              <div class="radio radio-inline">
               <label class="i-checks"> <input type="radio"
                data-ng-model="leaveType.gender" value="1" name="gender" ng-disabled="male"
                class="ng-pristine ng-untouched ng-valid"> 
                <i></i>
                Male
               </label>
              </div>
              <div class="radio radio-inline">
               <label class="i-checks"> <input type="radio"
                data-ng-model="leaveType.gender" value="2" name="gender"
                class="ng-pristine ng-untouched ng-valid"> 
                <i></i>
                Female
               </label>
              </div>
             </div>
            </fieldset>
           </div>


          </div>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="save(leaveTypeForm)"data-ng-if="isEdit == false" ">
            <i class="fa fa-save"></i>
            Save
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="update(leaveTypeForm);"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            Update
           </button>
           <button class="btn btn-info" type="button"
            data-ng-click="reset(leaveTypeForm)">
            <i class="fa fa-undo"></i>
            Reset
           </button>
           <button class="btn btn-danger" type="button"
            data-ng-click="cancel();">
            <i class="fa fa-close"></i>
            Cancel
           </button>
          </div>
         </div>
        </div>
       </form>
      </div>
     </div>
						</form>
					</div>
	</div>
</div>

