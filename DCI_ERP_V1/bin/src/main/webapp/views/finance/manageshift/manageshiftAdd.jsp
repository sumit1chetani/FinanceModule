<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
	<div role="content">
      		<div class="widget-body">
       			<form class="form-horizontal" name="shiftMasterAddForm" novalidate method="post">
        			<div class="row">
         				<div class="col-sm-12 col-md-12 col-lg-12">
          					<div class="col-sm-6 col-md-6 col-lg-6">
           						<fieldset>
<!-- 						            <div class="form-group" ng-if="!shiftMasterValidateData.isEdit" id="shiftValue">
 -->						          <div class="form-group" ng-if="!shiftMasterValidateData.isEdit" id="shiftValue">
						            
						             	<label class="col-md-6 control-label">Shift Code </label>
						             	<div class="col-md-4">
						              		<input type="text" class="form-control input-sm" 
						               			name="shiftCode" id="shiftCode"
						               			data-message-id="Shift Code"
						               			data-ng-model="shiftMasterobj.shiftCode"
						               			validation="required" friendly-name="Shift Code">
						             	</div>
						            </div>
						            <div class="form-group" ng-if="shiftMasterValidateData.isEdit" id="shiftCodeReadOnly">
						             	<label class="col-md-6 control-label">Shift Code </label>
						             	<div class="col-md-4">
						              		<input type="text" class="form-control input-sm"
						               			name="shiftCode"
						               			data-message-id="Shift Code"
						               			data-ng-model="shiftMasterobj.shiftCode"
						               			validation="required" friendly-name="Shift Code"
						               			>
						             	</div>
						            </div>
					<!-- 	            <div class="form-group">
						             	<label class="col-md-6 control-label">Threshold Time</label>
						             		<div class="col-md-4">
								             	<div class="dropdown">
								               		<a class="dropdown-toggle" id="thresholdTimeValidate" role="button"
								               		
								                		data-toggle="dropdown" data-target="#" href="#">
										             <div class="input-group">
										                 <input type="text" class="form-control" placeholder="hh:mm" name="thresholdTime" id="thresholdTime"
										                 	validation="required" friendly-name="Threshold Time"
										                 	data-message-id="thresholdTime" 
										                  	data-ng-model="shiftMasterobj.thresholdTime"><span
										                  	class="input-group-addon"><i
										                  	class="glyphicon glyphicon-time"></i></span>
										             </div>
								               		</a>
									               <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
									                	<datetimepicker data-ng-model="shiftMasterobj.thresholdTime" data-on-set-time="shiftMasterobj.thresholdTime = onTimeSet(newDate)"
									                 		data-datetimepicker-config="{ dropdownSelector: '#thresholdTimeValidate',startView:'hour', minView:'minute'}" />
									               </ul>
								            	</div>
						             		</div>
						            </div>
						            
						             -->
						            
						            
						            
						            
								<div class="form-group">
									<label class="col-md-6 control-label">Threshold Time<span
										style="color: red;"> *</span></label>
									<div class="col-md-4 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="thresholdTime" name="thresholdTime" 
           ng-model="shiftMasterobj.thresholdTime" validation="required" friendly-name="thresholdTime"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>
						            <div class="form-group">
						             	<label class="col-md-6 control-label">Shift Description</label>
						             		<div class="col-md-4">
						             			<textarea type="text" class="form-control input-sm"
						               				rows="2" cols="25" maxlength="50"
						               				name="description"
						               				ng-model="shiftMasterobj.description"
						               				style="resize: none"></textarea>
						             	</div>
						           </div>
           					</fieldset>
          				</div>
			          	<div class="col-sm-6 col-md-6 col-lg-6">
			           		<fieldset>
					            <div class="form-group" ng-if="!shiftMasterValidateData.isEdit" id="shiftNameValue">
					             	<label class="col-md-4 control-label"> Shift Name</label>
					             		<div class="col-md-4">
					              			<input type="text" class="form-control input-sm"
					               				name="shiftName" id="shiftName"
					               				data-message-id="Shift Name" validation="required" friendly-name="Shift Name"
					               				ng-model="shiftMasterobj.shiftName">
					             		</div>
					            </div>
					            <div class="form-group" ng-if="shiftMasterValidateData.isEdit" id="shiftNameReadOnly">
						             <label class="col-md-4 control-label">Shift Name</label>
					             		<div class="col-md-4">
					              			<input type="text" class="form-control input-sm"
					               				name="shiftName"
					               				data-message-id="Shift Name" validation="required" friendly-name="Shift Name"
					               				ng-model="shiftMasterobj.shiftName">
					             		</div>
					            </div>
					            <div class="form-group" ng-if="!shiftMasterValidateData.isEdit">
					             	<label class="col-md-4 control-label">Effective Date </label>
					             	   <div class="col-md-4">
					               			<div class='input-group date datetimepick'>
					            				<div class="dropdown">
					             					<a class="dropdown-toggle" id="effectFromDateValidate" role="button" data-toggle="dropdown" data-target="#" href="#">
					              						<div class="input-group">
											               <input type="text" class="form-control"
											                	placeholder="dd/mm/yyyy" name="effectFromDate" id="effectFromDate"
											                	validation="date_euro_long|required" friendly-name="Effective Date"
											                	data-message-id="effectFromDate"
											                	data-ng-model="shiftMasterobj.effectFromDate"><span
											                	class="input-group-addon"><i
											                	class="glyphicon glyphicon-calendar"></i></span>
											            </div>
					             					</a>
					             					<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
					              						<datetimepicker data-ng-model="shiftMasterobj.effectFromDate"
					               							data-on-set-time="shiftMasterobj.effectFromDate= onDateSet(newDate)"
					               							data-datetimepicker-config="{ dropdownSelector: '#effectFromDateValidate',startView:'day', minView:'day'}" />
					             					</ul>
					            				</div>
					           				</div>
					             	</div>
					          </div>
					          <div class="form-group" ng-if="shiftMasterValidateData.isEdit">
					             	<label class="col-md-4 control-label">Effective Date </label>
					             	   <div class="col-md-4">
					               			<div class='input-group date datetimepick'>
					            				<div class="dropdown">
					             					<a class="dropdown-toggle" id="effectFromDateValidate" role="button" data-toggle="dropdown" data-target="#" href="#">
					              						<div class="input-group">
											               <input type="text" class="form-control"
											                	placeholder="dd/mm/yyyy" name="effectFromDate" id="effectFromDate"
											                	validation="required" friendly-name="Effective Date"
											                	data-message-id="effectFromDate"
											                	data-ng-model="shiftMasterobj.effectFromDate" disabled><span
											                	class="input-group-addon"><i
											                	class="glyphicon glyphicon-calendar"></i></span>
											            </div>
					             					</a>
					            				</div>
					           				</div>
					             	</div>
					          </div>
			            <div class="form-group">
			             <label class="col-md-6 control-label"> <%-- <spring:message
			               code="label.nightShift"></spring:message> --%>
			               Ninght Shift
			             </label>
			             <div class="col-md-6">
			              <div class="checkbox">
			               <label> <input type="checkbox"
			                class="checkbox style-0"
			                data-ng-model="shiftMasterobj.nightShift" ng-click="time()"
			                data-ng-true-value="'Y'" data-ng-false-value="'N'">
			                <span></span>
			               </label>
			              </div>
			             </div>
			            </div>
			           </fieldset>
			          </div>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12"
          style="padding-left: 245px;">
          <fieldset>
           <div class="form-group">
            <label class="bold">Shift Time</label>
           </div>
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12">
          <div class="col-sm-6 col-md-6 col-lg-6">
           <fieldset>
           <!--  <div class="form-group">
             <label class="col-md-6 control-label"> Start Time
             </label>
             <div class="col-md-4">
             <div class="dropdown">
               <a class="dropdown-toggle" id="startTimeValidate" role="button"
                data-toggle="dropdown" data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="hh:mm" name="startTime" id="startTime"
                 validation="required" friendly-name="Start Time"
                 data-message-id="startTime" 
                  data-ng-model="shiftMasterobj.startTime"><span
                  class="input-group-addon"><i
                  class="glyphicon glyphicon-time"></i></span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu"
                aria-labelledby="dLabel">
                <datetimepicker data-ng-model="shiftMasterobj.startTime" data-on-set-time="shiftMasterobj.startTime = onTimeSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#startTimeValidate',startView:'hour', minView:'minute'}" />
               </ul>
              </div>
             </div>
            </div> --><div class="form-group">
									<label class="col-md-6 control-label">Start Time<span
										style="color: red;"> *</span></label>
									<div class="col-md-4 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="startTime" name="startTime" 
           ng-model="shiftMasterobj.startTime" validation="required" friendly-name="startTime"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>
            
           </fieldset>
          </div>
          <div class="col-sm-6 col-md-6 col-lg-6">
           <fieldset>
           <!--  <div class="form-group">
             <label class="col-md-4 control-label"> End Time
             </label>
             <div class="col-md-4">
                 <div class="dropdown">
               <a class="dropdown-toggle" id="endTimeValidate" role="button"
                data-toggle="dropdown" data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="hh:mm" name="endTime" id="endTime" 
                 validation="required" friendly-name="End Time"
                 data-message-id="endTime" 
                  data-ng-model="shiftMasterobj.endTime"><span
                  class="input-group-addon"><i
                  class="glyphicon glyphicon-time"></i></span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu"
                aria-labelledby="dLabel">
                <datetimepicker data-ng-model="shiftMasterobj.endTime" data-on-set-time="shiftMasterobj.endTime = onTimeSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#endTimeValidate',startView:'hour', minView:'minute'}" />
               </ul>
              </div>
             </div>
            </div> -->
            
            <div class="form-group">
									<label class="col-md-4 control-label">End Time<span
										style="color: red;"> *</span></label>
									<div class="col-md-4 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="endTime" name="endTime" 
           ng-model="shiftMasterobj.endTime" validation="required" friendly-name="endTime"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>
           </fieldset>
          </div>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12"
          style="padding-left: 245px;">
          <fieldset>
           <div class="form-group">
            <label class="bold">Break Time</label>
           </div>
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12">
          <div class="col-sm-6 col-md-6 col-lg-6">
           <fieldset>
          <!--   <div class="form-group">
             <label class="col-md-6 control-label">Start Time
             </label>
             <div class="col-md-4">
                     <div class="dropdown">
               <a class="dropdown-toggle" id="breakStartTimeValidate" role="button"
                data-toggle="dropdown" data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="hh:mm" name="breakStartTime" id="breakStartTime" 
                 validation="required" friendly-name="Break Start Time"
                 data-message-id="breakStartTime" 
                  data-ng-model="shiftMasterobj.breakStartTime"><span
                  class="input-group-addon"><i
                  class="glyphicon glyphicon-time"></i></span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu"
                aria-labelledby="dLabel">
                <datetimepicker data-ng-model="shiftMasterobj.breakStartTime" data-on-set-time="shiftMasterobj.breakStartTime = onTimeSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#breakStartTimeValidate',startView:'hour', minView:'minute'}" />
               </ul>
              </div>
             </div>
            </div> -->
            
            
              <div class="form-group">
									<label class="col-md-6 control-label">Start Time<span
										style="color: red;"> *</span></label>
									<div class="col-md-4 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="breakStartTime" name="breakStartTime" 
           ng-model="shiftMasterobj.breakStartTime" validation="required" friendly-name="breakStartTime"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>
           </fieldset>
          </div>
          <div class="col-sm-6 col-md-6 col-lg-6">
           <fieldset>
           <!--  <div class="form-group">
             <label class="col-md-4 control-label"> End Time
             </label>
             <div class="col-md-4">
                <div class="dropdown">
               <a class="dropdown-toggle" id="breakEndTimeValidate" role="button"
                data-toggle="dropdown" data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="hh:mm" name="breakEndTime" id="breakEndTime"
                 validation="required" friendly-name="Break End Time"
                 data-message-id="breakEndTime" 
                  data-ng-model="shiftMasterobj.breakEndTime"><span
                  class="input-group-addon"><i
                  class="glyphicon glyphicon-time"></i></span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu"
                aria-labelledby="dLabel">
                <datetimepicker data-ng-model="shiftMasterobj.breakEndTime" data-on-set-time="shiftMasterobj.breakEndTime = onTimeSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#breakEndTimeValidate',startView:'hour', minView:'minute'}" />
               </ul>
              </div>
             </div>
            </div> -->
            
            <div class="form-group">
									<label class="col-md-4 control-label">End Time<span
										style="color: red;"> *</span></label>
									<div class="col-md-4 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="breakEndTime" name="breakEndTime" 
           ng-model="shiftMasterobj.breakEndTime" validation="required" friendly-name="breakEndTime"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>
           </fieldset>
          </div>
         </div>
         <div class="col-sm-12 col-md-12 col-lg-12">
          <div class="col-sm-6 col-md-6 col-lg-6">
           <fieldset>
            <div class="form-group">
             <label class="col-md-6 control-label"> Minimum Working Hours Half day
             </label>
             <div class="col-md-4">
              <input type="text" class="form-control input-sm text-right"
               		name="minimumWorkingHoursHalfDay"
               		ng-model="shiftMasterobj.halfDay" validation="required" friendly-name="Min. Working Hours" 
               		placeholder="0.00" message-id="minworkhalfday" ng-pattern-restrict="^[0-9.]*$" maxlength="5">
             </div>
            </div>
          <!--   <div class="form-group">
             <label class="col-md-6 control-label">Late After
             </label>
             <div class="col-md-4">
             <div class="dropdown">
               <a class="dropdown-toggle" id="lateAfterValidate" role="button"
                data-toggle="dropdown" data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="hh:mms" name="lateAfter" id="lateAfter"
                 validation="required" friendly-name="Late After"
                 data-message-id="lateAfter" 
                  data-ng-model="shiftMasterobj.lateAfter"><span
                  class="input-group-addon"><i
                  class="glyphicon glyphicon-time"></i></span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu"
                aria-labelledby="dLabel">
                <datetimepicker data-ng-model="shiftMasterobj.lateAfter" data-on-set-time="shiftMasterobj.lateAfter = onTimeSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#lateAfterValidate',startView:'hour', minView:'minute'}" />
               </ul>
              </div>
             </div>
            </div> -->
            
            <div class="form-group">
									<label class="col-md-6 control-label">Late After<span
										style="color: red;"> *</span></label>
									<div class="col-md-4 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="lateAfter" name="lateAfter" 
           ng-model="shiftMasterobj.lateAfter" validation="required" friendly-name="lateAfter"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>
          <!--   <div class="form-group">
             <label class="col-md-6 control-label">No Of Time Allow
             <div class="col-md-4">
              <input type="text"
               class="form-control input-sm text-right"
               name="noOfTimeAllowed"
               data-message-id="No Of Time Allowed" id="noOfTimeAllowed"
               ng-model="shiftMasterobj.noOfTimeAllowed" placeholder="0"
               data-message-id="No of Time Allowed" maxlength="1"
               validation="numeric|required" friendly-name="No. Of Time Allowed">
             </div>
            </div> -->
            
             <div class="form-group">
             <label class="col-md-6 control-label"> No Of Time Allow
             </label>
             <div class="col-md-4">
              <input type="text" class="form-control input-sm text-right"
               		name="noOfTimeAllowed"
               		ng-model="shiftMasterobj.noOfTimeAllowed" validation="required" friendly-name="No. Of Time Allowed" 
               		placeholder="0" message-id="noOfTimeAllowed" ng-pattern-restrict="^[0-9.]*$" maxlength="5">
             </div>
            </div>
            
            
           </fieldset>
          </div>
          <div class="col-sm-6 col-md-6 col-lg-6">
           <fieldset>
           <!--  <div class="form-group">
             <label class="col-md-4 control-label">Min Working Hour Full day
             <div class="col-md-4">
              <input type="text"
               class="form-control input-sm text-right" message-id="minwrkfullday"
               name="minimumWorkingHoursFullDay"
               ng-model="shiftMasterobj.fullDay" placeholder="0.00" 
               validation="required" friendly-name="Min. Working Hours Full Day" ng-pattern-restrict="^[0-9.]*$" maxlength="5">
             </div>
            </div> -->
            
             <div class="form-group">
             <label class="col-md-4 control-label"> Minimum Working Hours Full day
             </label>
             <div class="col-md-4">
              <input type="text" class="form-control input-sm text-right"
               		name="minimumWorkingHoursFullDay"
               		ng-model="shiftMasterobj.fullDay" validation="required" friendly-name="Min. Working Hours Full Day" 
               		placeholder="0.00" message-id="minwrkfullday" ng-pattern-restrict="^[0-9.]*$" maxlength="5">
             </div>
            </div>
           <!--  <div class="form-group">
             <label class="col-md-4 control-label">Early Exit
             <div class="col-md-4">
            <div class="dropdown">
               <a class="dropdown-toggle" id="earlyExitValidate" role="button"
                data-toggle="dropdown" data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="hh:mm" name="earlyExit" id="earlyExit"
                 validation="required" friendly-name="Early Exit"
                 data-message-id="earlyExit" 
                  data-ng-model="shiftMasterobj.earlyExit"><span
                  class="input-group-addon"><i
                  class="glyphicon glyphicon-time"></i></span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu"
                aria-labelledby="dLabel">
                <datetimepicker data-ng-model="shiftMasterobj.earlyExit" data-on-set-time="shiftMasterobj.earlyExit = onTimeSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: '#earlyExitValidate',startView:'hour', minView:'minute'}" />
               </ul>
              </div>
             </div>
            </div> -->
            
            
            <!-- <div class="form-group">
             <label class="col-md-4 control-label">Early Exit
             </label>
             <div class="col-md-4">
             <div class="dropdown">
               <a class="dropdown-toggle" id="earlyExitValidate" role="button"
                data-toggle="dropdown" data-target="#" href="#">
                <div class="input-group">
                 <input type="text" class="form-control" placeholder="hh:mms" name="earlyExit" id="earlyExit"
                 validation="required" friendly-name="Early Exitr"
                 data-message-id="earlyExit" 
                  data-ng-model="shiftMasterobj.earlyExit"><span
                  class="input-group-addon"><i
                  class="glyphicon glyphicon-time"></i></span>
                </div>
               </a>
               <ul class="dropdown-menu" role="menu"
                aria-labelledby="dLabel">
                <datetimepicker data-ng-model="shiftMasterobj.earlyExit" data-on-set-time="shiftMasterobj.earlyExit = onTimeSet(newDate)"
                 data-datetimepicker-config="{ dropdownSelector: 'earlyExitValidate',startView:'hour', minView:'minute'}" />
               </ul>
              </div>
             </div>
            </div>  -->
            
             <div class="form-group">
									<label class="col-md-4 control-label">Early Exit<span
										style="color: red;"> *</span></label>
									<div class="col-md-4 inputGroupContainer">


			<div class="input-group input-append date">
          <input type="text" class="form-control input-sm" 
           id="earlyExit" name="earlyExit" 
           ng-model="shiftMasterobj.earlyExit" validation="required" friendly-name="earlyExit"/> <span
           class="input-group-addon add-on"><span
           class="glyphicon glyphicon-time"></span></span>
         </div>

									</div>
								</div>
           </fieldset>
          </div>
         </div>
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success"
            ng-if="!shiftMasterValidateData.isEdit" type="submit"
            ng-click="save(shiftMasterobj,shiftMasterAddForm)">
            <i class="fa fa-save"></i>
            SAVE
           </button>
           <button class="btn btn-success"
            ng-if="shiftMasterValidateData.isEdit" type="submit"
            ng-click="save(shiftMasterobj,shiftMasterAddForm)">
            <i class="fa fa-save"></i>
            UPDATE
           </button>
           <button class="btn btn-info ng-scope" type="submit"
            ng-click="reset(shiftMasterAddForm)" class="btn btn-success">
            <i class="fa fa-undo"></i>
          Reset
           </button>
           <button class="btn btn-danger" type="button"
            class="btn btn-success" ng-click="cancel()">
            <i class="fa fa-close"></i>
            Cancel
           </button>
          </div>
         </div>
        </div>
        <br>
        <br>
        <div class="col-sm-12 col-md-12 col-lg-12"
         style="padding-left: 150px;">
         <fieldset>
          <div class="form-group">
           <label>shift Saved here to shall be allocated to Employees through shift Scheme</label>
          </div>
         </fieldset>
        </div>
       </form>
      </div>
     </div>
     </div>
</div>
