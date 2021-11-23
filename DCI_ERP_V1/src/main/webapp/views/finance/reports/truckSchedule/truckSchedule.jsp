<script>
	//$(window).click(function() {
	/* $(".selectivity-backdrop").css("z-index", "10000000");  */

	/* if ($('.selectivity-backdrop').css('display') == 'block') {
		$("#ngdialog1").css("z-index", "10000");
		$(".selectivity-backdrop").css("z-index", "1000");
	}else{
		$("#ngdialog1").css("z-index", "10000");
		$(".selectivity-backdrop").css("z-index", "1000");
	} */
	//});
	/*  $(document).ready(function() { 
    $('#demo3').click(function() { 
    	alert("SSSS");
    	$.blockUI({ css: { 
            border: 'none', 
            padding: '15px', 
            backgroundColor: '#000', 
            '-webkit-border-radius': '10px', 
            '-moz-border-radius': '10px', 
            opacity: .5, 
            color: '#fff' 
        } }); 
 
    }); 
});   */
</script>
<style>
.calbody {
	margin: 40px 10px;
	padding: 0;
}
/* .ngdialog{
 z-index: 9999 !important;
} */
.defcalClass {
	max-width: 80%;
	margin: 0 auto;
	height: 100%;
}

.modCalClass {
	width: 60%;
	height: auto;
	margin-left: 0% !important;
	height: 100%;
	z-index: 10;
	
}
.defcalClass > .fc-toolbar{
   padding: 1%;
    background: linear-gradient(to right, rgba(182, 7, 25, 0.61), rgb(3, 45, 144));
    border-radius: 3px 3px 3px 3px;
}
.defcalClass > .fc-toolbar > .fc-center > h2{
 color: #fff;
 margin-top: 6%;
}
.modCalClass:HOVER{
/* background-color: black;
  z-index:5 !important; */
}

.fc-event-container>a:HOVER {
	color: #fff !important;
}

.fc-list-item-title>a:HOVER {
	color: #27378b !important;
}

.ngdialog-content>.wrapper-md {
	padding: 0px !important;
	background-color: none !important;
}

.accTruckEvt>.wrapper-md {
	width: 50% !important;
	position: absolute;
	margin-top: -100%;
}

.modTrkEvt>.wrapper-md {
	width: 100% !important;
	position: absolute;
	margin-top: 3%;
	margin-left: 60%;
	
	-webkit-animation-name: example;  /* Safari 4.0 - 8.0 */
    -webkit-animation-duration: 1s;  /* Safari 4.0 - 8.0 */    
    -webkit-animation-fill-mode: alternate; /* Safari 4.0 - 8.0 */
    animation-name: example;
    animation-duration: 1s;    
    animation-fill-mode: alternate;
	
}
@keyframes example {
    from {left: -30%;}
    to {left: 3%;}
}
.fc-license-message{
display: none;
}
.trCal > .panel > .panel-body > .row > .col-sm-12 > .trWidth{
 width: 100% !important;
 padding-right: 0px;
}

.trCal > .panel > .panel-body > .form-group > .trCalStartlbl{
width: 36.2%;
} 
.trCal > .panel > .panel-body > .form-group > .trCalStDt{
width: 40%;
}
.pln-hisy{
 display: none;
}
.ptCalHdRem{
 display: none;
}
.drvSelStyl{
    height: 30px !important;
    width: 103%;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="wrapper-md">

	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
			<form class="form-horizontal" name="TripForm" novalidate
				method="POST">
				<div class="panel-body">




					<div class="panel-body">
						<div class="row pl2pc pr10pc"
							style="padding-left: 0px; margin-left: -40px;">
							<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-5 control-label">Truck</label>
									<div class="col-md-7">
										<selectivity list="truckSelectivity"
											property="truckListselected"
											data-ng-model="truckListselected"
											form-name="dailyVehicleReportForm" friendly-name="Table Name">
										</selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<button class="btn btn-success" type="button"
										ng-click="searchTruck()">
										<i class="fa fa-search"></i> Search
									</button>
									
								</div>
							</div>

						</div>
					</div>
					<div class="accTruckEvt" >
						<div class="wrapper-md truckAddClass">



						<div style="width: 35%">
							<div class="panel panel-default panel-default-form"
								style="height: 31px">
								<div class="panel-heading panel-heading-form font-bold"
									style="height: 115%; width: 91.5%; margin-left: 4%;">
									<a>Add Trip </a> <a ng-click="cancel()"
										style="float: right; margin-right: 10px; margin-top: 1px; color: #dc3d3d;">
										<i class="fa fa-close"></i>
									</a>

								</div>
							</div>
							<div ng-include="'/views/trip/tripadd.jsp'"></div>
						</div>



						<!-- <div class="panel panel-default panel-default-form">
								<div class="panel-heading panel-heading-form font-bold">
								<div class="panel panel-default panel-default-form" style="height: 31px">
									<div class="panel-heading panel-heading-form font-bold" style="height: 35px">
									<a>Add Trip </a>
									<a ng-click='cancel()' style=' float: right; margin-right: 10px; margin-top: 1px; color: #dc3d3d; '> <i class='fa fa-close'></i> </a>
									
									</div>
								</div>
								<div class="panel-body">

									<marquee style="color: #FF4500; font-weight: 400;"
										onmouseover="this.stop();" onmouseout="this.start();"
										scrolldelay="100">
										<span style="color: red">Note : Trip Start Date should
											match with the time frame set in Truck Trailer Mapping.</span>
									</marquee>


									<div class="row">
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="col-sm-12 col-md-12 col-lg-12">
												<fieldset>
													<div class="form-group">
														<label for="inputPassword" class="control-label col-md-4">
															Trip Start Date<span style="color: red;">*</span>
														</label>
														<div class="col-md-7 inputGroupContainer">
															<ng-bs3-datepicker id="tripcalId" class="tripCalClass"
																data-ng-model="trip.tripStartDate" name="tripStartDate"
																form-name="TripForm" friendly-name="Trip Start Date"
																validation="required" />
																
																<ng-bs3-datepicker  date-format="DD/MM/YYYY" selector="form-control" 
																id="tripcalId2" class="tripCalClass"
																ng-model="trip.tripStartDate" name="tripStartDate"
																form-name="TripForm" friendly-name="Trip Start Date"
																validation="required" />
																
																
														</div>
													</div>

													<div class="form-group">
														<label class="col-md-4 control-label">Truck<span
															style="color: red;">*</span></label>
														<div class="col-md-7 inputGroupContainer">
															<selectivity list="truckList" class="truckClass"
																id="truckId" name="truckId" property="trip.truckId"
																ng-model="trip.truckId" object="getSubGroup"
																validation="required" friendly-name="Truck"
																form-name="TripForm"></selectivity>
														</div>
													</div>



													<div class="form-group">
														<label class="col-md-4 control-label">Trailer No<span
															style="color: red;">*</span><span style="color: red;"></span></label>
														<div class="col-md-7">
															<selectivity list="trailerList" id="trailerId"
																class="trailClass" name="trailerId"
																property="trip.trailerId" ng-model="trip.trailerId"
																object="truckId" validation="required"
																friendly-name="Trailer" form-name="TripForm"></selectivity>
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-md-4 control-label">Trip No<span
															style="color: red;">*</span><span style="color: red;"></span></label>
														<div class="col-md-7">
															<input type="text" class="form-control input-sm"
																id="tripNo" name="Trip No" ng-model="trip.tripNo"
																disabled="disabled" validation="required"
																friendly-name="Trip No" form-name="TripForm" />
														</div>
													</div>
													
													<div class="form-group">
														<label for="inputPassword" class="control-label col-md-4">Driver<span
															style="color: red;"></span></label>
														<div class="col-md-7">
															<selectivity list="driverList" property="trip.driverId"
																class="driverClass" id="driverId" name="driverId"
																form-name="TripForm" ng-model="trip.driverId"
																friendly-name="Driver"></selectivity>
														</div>
													</div>
													
													<div class="form-group">
														<label class="col-md-4 control-label"> From
															Location<span style="color: red;">*</span><span
															style="color: red;"></span>
														</label>
														<div class="col-md-7">
															<selectivity list="portList" property="trip.fromLocation"
																class="fromLocClass" id="fromLocation"
																name="fromLocation" form-name="TripForm"
																ng-model="trip.fromLocation" validation="required"
																friendly-name="From Location"></selectivity>

														</div>
													</div>
													
													<div class="form-group">
														<label for="inputPassword" class="control-label col-md-4">To
															Location<span style="color: red;">*</span>
														</label>
														<div class="col-md-7">
															<selectivity list="portList" property="trip.toLocation"
																class="toLocClass" id="toLocation" name="toLocation"
																form-name="TripForm" ng-model="trip.toLocation"
																validation="required" friendly-name="To Location"></selectivity>
														</div>
													</div>
													
													<div class="form-group">
														<label for="inputPassword" class="control-label col-md-4">ETD
															(From Location)<span style="color: red;">*</span>
														</label>
														<div class="col-md-7">
															<ng-bs3-datepicker  date-format="DD/MM/YYYY" selector="form-control" data-ng-model="trip.etd" name="etd"
																id="etdCalId" form-name="TripForm" friendly-name="ETD"
																class="etdCalClass" validation="required" />

														</div>
													</div>


													<div class="form-group">
														<label for="inputPassword" class="control-label col-md-4">ETA
															(To Location)<span style="color: red;">*</span>
														</label>

														<div class="col-md-7">
															<ng-bs3-datepicker  date-format="DD/MM/YYYY" selector="form-control"  data-ng-model="trip.eta" name="eta"
																form-name="TripForm" friendly-name="ETA" id="etaId"
																class="etaClass" validation="required" />
														</div>
													</div>

												</fieldset>
											</div>
										</div>
									</div>
									<br>



									<div class="form-actions">
										<div class="row">
											<div class="col-md-12">
												<button class="btn btn-success" ng-if="!isEdit"
													ng-click="save(trip,TripForm)">
													<i class="fa fa-save"></i> Save
												</button>
												<button class="btn btn-success" ng-if="isEdit"
													ng-click="update(trip,TripForm)"
													ng-if="accountHeadData.edit" type="submit">
													<i class="fa fa-save"></i> Update
												</button>

												<button class="btn btn-info" ng-if="!accountHeadData.edit"
													ng-click="reset()">
													<i class="fa fa-reply"></i> Reset
												</button>


												<button class="btn btn-danger" class="btn btn-success"
													ng-click="cancel()">
													<i class="fa fa-close"></i> Cancel
												</button>


											</div>
										</div>
									</div>


								</div>
							</div> -->
						</div>



					</div>
					<div class="calSep" style="height: 0%;" >
					<div class="calbody">
						<div class="defcalClass"
						 id='calendar'></div>
					</div>
					</div>
					<br /> <br /> <br /> <br />

				


			</div>
			</form>
	</div>

</div>
