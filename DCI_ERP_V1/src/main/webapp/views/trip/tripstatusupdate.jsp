<style>
.level_class2 {
	background: #6ca5ee;
	color: #fff;
	font-size: 15px;
	font-weight: bold;
}

.level_class1, .level_class1:hover {
	background: #e58b90;
	color: #fff;
	font-size: 15px;
	font-weight: bold;
}

.level_class3 {
	background: #79c07c;
	color: #fff;
	font-size: 15px;
}


</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">

					<form class="form-horizontal" name="TripForm">


						<div class="row book-widget-row">
							<br/>

							<div class="col-sm-12 col-md-6 ol-lg-6" >
								<fieldset>

									
										<div class="form-group-label-left">
									<label class="col-md-5 col-md-offset-1  control-label">Trip<span
										style="color: red;">*</span></label>
									<div class="col-md-6 inputGroupContainer">
										<selectivity list="tripList" id="tripId" name="tripId"
											property="trip.tripId" ng-model="trip.tripId"
											object="tripId" validation="required"
											friendly-name="Trip" form-name="TripForm"></selectivity>
									</div>
								</div>

								</fieldset>
							</div>
							
							<div class="col-sm-12 col-md-6 ol-lg-6" >
								<fieldset>

									
<!-- 										<div class="form-group-label-left"> -->
<!-- 										<div class="col-md-12 form-group-label-left" style="float: left;"> -->
<!-- 									<label class="col-md-6 control-label"> Status Date and Time <span -->
<!-- 										style="color: red;">*</span> -->
<!-- 									</label> -->
<!-- 									<div class="col-md-6 control-label text-left inputGroupContainer"> -->
<!-- 										<ng-bs3-datepicker property="trip.statusDate" name="statusDate" -->
<!-- 										 form-name="TripForm" friendly-name="Status Date and Time"  -->
<!-- 											id="statusDate"  ng-model="trip.statusDate" validation="required"/> -->
<!-- 											</div> -->
											
<!-- 										</div> -->
<!-- 								</div> -->



									<div class="form-group-label-left">
										<div class="col-md-12 form-group-label-left"
											style="float: left;">
											<label class="col-md-6 control-label"> Status Date
												and Time <span style="color: red;">*</span>
											</label>
											<div
												class="col-md-6 control-label text-left inputGroupContainer">
												<!-- <div class="form-group">
													<div class='input-group date' id='datetimepicker1'>
														<input type='text' class="form-control" 
															property="trip.statusDate" name="statusDate" 
															 form-name="TripForm" friendly-name="Status Date and Time" 
															id="statusDate"  ng-model="trip.statusDate" validation="required"/> <span
															class="input-group-addon"> <span
															class="glyphicon glyphicon-calendar"></span>
														</span>
													</div>
												</div> -->
												<div class="col-md-11">
													<div class="input-group input-append date">
														<input type="text" class="form-control input-sm"
															id="statusDate" name="statusDate" ng-model="trip.statusDate"
															validation="required" friendly-name="Status Date and Time" /> <span
															class="input-group-addon add-on"><span
															class="glyphicon glyphicon-calendar"></span></span>
													</div>

												</div>

											</div>
									</div>


								</fieldset>
							</div>

					</div>
							<br>
							<br>
							
						 <div class="row book-widget-row" >
						<div class="col-sm-12 col-md-6 ol-lg-6" ng-if="!technicalDiv">
								<fieldset>
								<div class="col-md-12 form-group-label-left" >
									<label class="col-md-6 control-label"> Technical Status <span
										style="color: red;"></span>
									</label>
									<div class="col-md-6 control-label text-left" >
										<div class="radio radio-inline" style="padding-left: 0px;"
											>
<!-- 											<span ><img src="/img/drive.jpg" width="200" height="150"> </span>
 -->											<label class="i-checks"> <input type="radio" ng-change="techStatus(trip.technicalStatusId,TripForm)"
												class="radiobox style-0" ng-model="trip.technicalStatusId" ng-disabled="isDrive" 
												name="technicalStatus" value="12" /> <i></i> Drive
											</label>
											
											
										</div>

										<div class="radio radio-inline" >
<!-- 										<span style="margin-left: 93px;"><img src="/img/rest.jpg" width="200" height="150"></span>
 -->											<label class="i-checks"> <input type="radio" ng-change="techStatus(trip.technicalStatusId,TripForm)"
												class="radiobox style-0" ng-model="trip.technicalStatusId" ng-disabled="isRest"
												name="technicalStatus" value="13" /> <i></i> Rest 
											</label>	
										</div>

										<div class="radio radio-inline" style="margin-left:0%">
<!-- 										<span style="margin-left: 93px;"><img src="/img/TechnicalProblems.png" width="200" height="150"></span>
 -->											<label class="i-checks"> <input type="radio" ng-change="techStatus(trip.technicalStatusId,TripForm)"
												class="radiobox style-0" ng-model="trip.technicalStatusId" ng-disabled="technicaDisable"
												name="technicalStatus" value="14" /> <i></i> Technical Problem
											</label>
										</div>
									</div>
									</div>
									</fieldset>
								</div>
								
						<!-- 	<div class="col-sm-12 col-md-4 ol-lg-4">
								<fieldset>

									
										<div class="form-group-label-left">
									<label class="col-md-3 col-md-offset-1  control-label">Technical Status<span
										style="color: red;">*</span></label>
									<div class="col-md-7 inputGroupContainer">
										<selectivity list="technicalStatusList" id="statusId" name="statusId"
											property="trip.technicalStatusId" ng-model="trip.technicalStatusId"
											object="technicalStatusId" validation="required"
											friendly-name="Technical Status " form-name="TripForm"></selectivity>
									</div>
								</div>

								</fieldset>
							</div> -->
							<div class="col-sm-12 col-md-6 ol-lg-6" ng-if="tripStatusDiv">
								<fieldset>

									
										<div class="form-group-label-left">
										<div class="col-md-12 form-group-label-left" >
									<label class="col-md-6 control-label"> Trip Status <span
										style="color: red;"></span>
									</label>
									<div class="col-md-6 control-label text-left">
										<div class="radio radio-inline" style="padding-left: 0px;" ng-repeat="tripStatus in tripStatusList">
											
											<label class="i-checks"> <input type="radio" 
												class="radiobox style-0" ng-model="trip.tripStatusId"  ng-change="techStatus(trip.tripStatusId,TripForm)"
												name="tripStatus" value="{{tripStatus.id}}" /> <i></i> {{tripStatus.text}}
											</label>
											</div>
											</div>
											
										</div>
								</div>

								</fieldset>
							</div>
							</div>

						
												<div class="form-actions" style="margin-bottom: 100px;">
							<!-- <div class="row">
								<div class="col-md-12 ">
									<button class="btn btn-success" type="submit" tooltip="Update"
										ng-click="updateStatus(dailyLoadingReportForm,dailyLoadingReport)">
										<i class="fa fa-save"></i> Update Status
									</button>
								</div>
							</div> -->
						</div>

					</form>
</div>
				</div>
			</div>
		</div>
	</div>
</div>