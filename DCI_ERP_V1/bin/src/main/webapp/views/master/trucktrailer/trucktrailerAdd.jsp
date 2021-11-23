<style>
.fc-license-message{
 display: none;
}
#truckTrailMapScheduler {
 
 width: 100% !important;
}
#truckTrailMapScheduler > .fc-toolbar{
    padding: 1%;
    background: linear-gradient(to right, rgba(182, 7, 25, 0.61), rgb(3, 45, 144));
    border-radius: 3px 3px 3px 3px;
}
#truckTrailMapScheduler > .fc-toolbar >.fc-center > h2{
 color: #fff;
  margin-top: 6%;
}


   #dp .scheduler_default_cellparent, .scheduler_default_cell.scheduler_default_cell_business.scheduler_default_cellparent {
        background: #f3f3f3;
}
.schClass > daypilot-scheduler > #dp > div:first-child > div:first-child > div:last-child{
display: none;
}
.scheduler_default_event_inner{
     background: #5cb85c;
    color: #fff;
}
.scheduler_default_timeheader_float_inner{
   padding-top: 0.5%;
   font-size: 20px;
   color: #072e90;
}
.scheduler_default_event_hover{
background-color: #46bde2;
}
.scheduler_default_corner_inner, .scheduler_default_timeheader_float{
 background-color: #c6616f;
     border: 1px solid #ca78d2;
}
.scheduler_default_timeheadercol_inner{
    background: #c5c2c2;
    border: 1px solid #ca78d2;
    color: #072e90;
}
.scheduler_default_timeheadergroup_inner{
padding-top: 0.5%;
    font-size: 20px;
    color: #fff;
    border: 1px solid #ca78d2;
        background: linear-gradient(to right, rgba(182, 7, 25, 0.61), rgb(3, 45, 144));
}
.scheduler_default_rowheader_inner{
     color: #072e90;
}
.scheduler_default_shadow_inner {
    background-color: #ffff;
  }



/* .fc-view-container > .fc-view > table >  .fc-body > tr > .fc-time-area > .fc-scroller-clip > .fc-scroller >
.fc-scroller-canvas > .fc-content > .fc-rows > table > tbody > tr > .fc-widget-content > div > 
.fc-event-container > a {
cursor: auto;
} */
</style>
<%-- 
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">

	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body"> --%>
		<div class="wrapper-md">
	<div class="panel panel-default panel-default-form" id="trkTrailAddId">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>			
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="trucktrailerForm"
				
				novalidate>
				  <marquee style="color: #FF4500;font-weight: 400;" 
ng-if="count>0"  scrolldelay="100" 
  ><span style="color :red">Note : Truck Trailer Mapping Used in Plan Trip.</span></marquee>
				
				
				
				<div class="row">
				<%-- <div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>			
		</div>
		<div class="panel-body">
			<form  class="form-horizontal" name="manuForm"  novalidate method="POST">
				<div class="row"> --%>
					<div class="col-sm-12 col-md-12 col-lg-6 col-lg-offset-3">
						<fieldset>
						<div class="form-group"  >
								<label class="col-md-4 control-label"> Truck <span style="color: red;">*</span></label>
								<div class="col-md-6 inputGroupContainer" id="trkSelList">
									<selectivity list="truckList"   ng-model="trucktrailermodel.truckId" name="truckId" form-name="trucktrailerForm"
										disabled="count>0"  property="trucktrailermodel.truckId" id="truckId" ng-disabled="count>0" validation="required" friendly-name="Truck" ></selectivity>
								</div>
							</div>
							
<div class="form-group">
								<label class="col-md-4 control-label"> Trailer <span style="color: red;">*</span></label>
								<div class="col-md-6 inputGroupContainer">
									<selectivity list="trailerList"  ng-model="trucktrailermodel.trailerId" name="trailerId" form-name="trucktrailerForm"
										disabled="count>0" property="trucktrailermodel.trailerId" id="trailerId" validation="required" friendly-name="Truck" ></selectivity>
								</div>
							</div>
						
							
<!--  <div class="form-group" ng-if=isEdit>
								<label class="col-md-4 control-label"> Location <span style="color: red;">*</span></label>
								<div class="col-md-6 inputGroupContainer">
									<selectivity list="locationList"  ng-model="trucktrailermodel.locationId" name="locationId" form-name="trucktrailerForm"
										property="trucktrailermodel.locationId" id="locationId" validation="required" friendly-name="Location" ></selectivity>
								</div>
							</div>  -->
				<div class="form-group" >
			                <label class="col-md-4 control-label"> From Date <span style="color: red;">*</span></label>
			                <div class="col-md-6" >
 			                  
<ng-bs3-datepicker data-ng-model="trucktrailermodel.fromDate"  id="fromDate" name="fromDate" form-name="trucktrailerForm"
       data-ng-change="checkDatesCL(trucktrailermodel.fromDate)" 
        friendly-name="From Date" ng-disabled="count>0" validation="required"/>
			                </div>
			              </div>
			         

					<div class="form-group">
			               			                <label class="col-md-4 control-label">To Date <span style="color: red;">*</span></label>

			                <div class="col-md-6">
 			                  
<ng-bs3-datepicker data-ng-model="trucktrailermodel.toDate" id="toDate" name="toDate" form-name="toForm"
       data-ng-change="checkDatesCL(trucktrailermodel.toDate)" 
        friendly-name="To Date"  validation="required"/>
			                </div>
			              </div>
			               
							

						</fieldset>
					</div>
				</div>


				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
						 
					   <button   class="btn btn-success" ng-if="!isEdit"  ng-click="validate(trucktrailerForm)"><i class="fa fa-save"></i> Save</button>
      
       <button   class="btn btn-success" ng-if="isEdit" type="submit" ng-click="validate(trucktrailerForm)" ><i class="fa fa-save"></i> Update</button>
       	<button class="btn btn-info" ng-if="!isEdit"
								type="reset" ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-info" ng-if="isEdit"
								type="reset" ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
				
				<br/><br/>
				
				
				<!-- <div  ng-controller="DemoCtrl" class="schClass" ng-show="showShedr" >
				
				<div style="margin-left: 90%" >
				<button type="button" ng-click="gotoPrevYear()" style="position: absolute;margin-top: 45px;z-index: 1;"
					class="fc-prev-button fc-button fc-state-default fc-corner-left">
					<span class="fc-icon fc-icon-left-single-arrow" style="padding:3px"></span>
				</button>&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" ng-click="gotoNextYear()" style="position: absolute;margin-top: 45px;z-index: 1;margin-left: 4%;"
					class="fc-next-button fc-button fc-state-default fc-corner-right">
					<span class="fc-icon fc-icon-right-single-arrow" style="padding:3px"></span>
				</button>
				</div>
				<br/>
				 <daypilot-scheduler id="dp" daypilot-config="config" daypilot-events="events" update="true" ></daypilot-scheduler>
                 </div> -->
                 <br/>
                 <br/>
				
				
				
				</form>
		 </div>
      </div>
      </div>