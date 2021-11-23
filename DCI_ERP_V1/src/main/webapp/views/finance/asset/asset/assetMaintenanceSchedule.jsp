<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -100px;
}
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget"
     data-widget-color="sttropaz">
     <header class="ngdialog-header">
      <span class="widget-icon"> <i class="fa fa-table"></i>
      </span>
      <h2>
       <spring:message code="label.maintain.history"></spring:message>
      </h2>
     </header>
     <div role="content">
      <div class="widget-body">
       <form class="form-horizontal" name="maintainScheduleForm">
        <div class="row">
         <div class="col-sm-10 col-md-5"><br>
          <fieldset style=" margin-left: 78px; ">           
          <div class="form-group">
			<label class="col-md-6 control-label">Maintenance Schedule Date<span
			style="color: red;"></span></label>
			<div class="col-md-4">
			<div class='input-group date datetimepick'>
			<div class="dropdown" style=" margin-bottom: -8px; ">
			<a class="dropdown-toggle" id="maintenanceScheduleDate" role="button"
			data-toggle="dropdown" data-target="#" href="#">
			<div class="input-group" style=" margin-top: -16px; ">
			<input type="text" class="form-control"
			placeholder="dd/mm/yyyy" name="Maintenance Schedule Date"									
			data-ng-model="assetMasterData.maintenanceScheduleDate" style=" width: 116px; "><span
			class="input-group-addon"><i
			class="glyphicon glyphicon-calendar"></i></span>
			</div>
			</a>
			<ul class="dropdown-menu" role="menu"
			aria-labelledby="dLabel">
			<datetimepicker data-ng-model="assetMasterData.maintenanceScheduleDate"
			data-on-set-time="assetMasterData.maintenanceScheduleDate = onDateSet(newDate)"
			data-datetimepicker-config="{ dropdownSelector: '#maintenanceScheduleDate',startView:'day', minView:'day'}" />
			</ul>
			</div>
			</div>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-6 control-label">Maintenance Actual Date<span
			style="color: red;"></span></label>
			<div class="col-md-4">
			<div class='input-group date datetimepick'>
			<div class="dropdown" style=" margin-bottom: -22px; ">
			<a class="dropdown-toggle" id="maintenanceActualDate" role="button"
			data-toggle="dropdown" data-target="#" href="#">
			<div class="input-group" style=" margin-top: -16px; ">
			<input type="text" class="form-control"
			placeholder="dd/mm/yyyy" name="Maintenance Actual Date"									
			data-ng-model="assetMasterData.maintenanceActualDate" style=" width: 116px; "><span
			class="input-group-addon"><i
			class="glyphicon glyphicon-calendar"></i></span>
			</div>
			</a>
			<ul class="dropdown-menu" role="menu"
			aria-labelledby="dLabel">
			<datetimepicker data-ng-model="assetMasterData.maintenanceActualDate"
			data-on-set-time="assetMasterData.maintenanceActualDate = onDateSet(newDate)"
			data-datetimepicker-config="{ dropdownSelector: '#maintenanceActualDate',startView:'day', minView:'day'}" />
			</ul>
			</div>
			</div>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-md-6 control-label">Next Schedule Date<span
			style="color: red;"></span></label>
			<div class="col-md-4">
			<div class='input-group date datetimepick'>
			<div class="dropdown">
			<a class="dropdown-toggle" id="nextScheduleDate" role="button"
			data-toggle="dropdown" data-target="#" href="#">
			<div class="input-group" style=" margin-top: -16px; ">
			<input type="text" class="form-control"
			placeholder="dd/mm/yyyy" name="Next Schedule Date"									
			data-ng-model="assetMasterData.nextScheduleDate" style=" width: 116px; "><span
			class="input-group-addon"><i
			class="glyphicon glyphicon-calendar"></i></span>
			</div>
			</a>
			<ul class="dropdown-menu" role="menu"
			aria-labelledby="dLabel">
			<datetimepicker data-ng-model="assetMasterData.nextScheduleDate"
			data-on-set-time="assetMasterData.nextScheduleDate = onDateSet(newDate)"
			data-datetimepicker-config="{ dropdownSelector: '#nextScheduleDate',startView:'day', minView:'day'}" />
			</ul>
			</div>
			</div>
			</div>
		</div>
		 </fieldset>
        </div>
	         
		<div class="col-sm-10 col-md-5"><br>
        <fieldset>       
        
        <div class="form-group">
		<label class="col-md-6 control-label">
		 <spring:message code="label.maintain.by"></spring:message>						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="<spring:message code="label.maintain.by"></spring:message>"
			data-ng-model="assetMasterData.maintainBy">
		 </div>
		</div>
		<br>
		<div class="form-group">
		<label class="col-md-6 control-label">
		 <spring:message code="label.maintain.type"></spring:message>						  					
		</label>
		  <div class="col-md-6">
			<input type="text" class="form-control input-sm" 
			name="<spring:message code="label.maintain.type"></spring:message>"
			data-ng-model="assetMasterData.maintenanceType">
		 </div>
		</div>
            <br> 							
		 <div class="form-group">
		   <label class="col-md-6 control-label">
			<spring:message code="label.note"></spring:message>						  					
		   </label>
			<div class="col-md-6">						   												   						
			<textarea class="form-control input-sm" style="resize: none;width: 150px;"
            name="<spring:message code="label.note"></spring:message>"
            data-ng-model="assetMasterData.scheduleNote"></textarea>						   						
			</div>
		</div>						   				            								  									
									
			</fieldset>
         </div>
         
        </div>
        <div class="form-actions">
         <div class="row">
          <div class="col-md-12">
           <button class="btn btn-success" type="button"
            data-ng-click="save(maintainScheduleForm)" data-ng-if="!isEdit">
            <i class="fa fa-save"></i>
            <spring:message code="label.save"></spring:message>
           </button>
           <button class="btn btn-success" type="button"
            data-ng-click="update(maintainScheduleForm);"
            data-ng-if="isEdit == true">
            <i class="fa fa-save"></i>
            <spring:message code="label.update"></spring:message>
           </button>
           <button class="btn btn-info" type="button"
            data-ng-click="reset(maintainScheduleForm)">
            <i class="fa fa-undo"></i>
            <spring:message code="label.reset"></spring:message>
           </button>
           <button class="btn btn-danger" type="button"
            data-ng-click="cancelpop();">
            <i class="fa fa-close"></i>
            <spring:message code="label.cancel"></spring:message>
           </button>
          </div>
         </div>
        </div>
       </form>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>