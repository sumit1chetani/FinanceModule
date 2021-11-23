<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>


			<!-- <ol class="breadcrumb inline-block padding-left-0">
				<li><a>Finance</a></li>
				<li><a x-ui-sref="app.master.controlscreen">Control Screen</a>
				</li>
				<li><a x-ui-sref="app.finance.controlscreen.subgroupaccount">Account
						Head</a></li>
				<li><a
					x-ui-sref="app.finance.controlscreen.locationForm">Add</a></li>
			</ol> -->
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="locationForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">Location Name <span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">


										<input type="text" class="form-control input-sm"
											id="locationName" maxlength="40" validation="required"
											friendly-name="Location Name" form-name="locationForm"
											name="locationName" ng-model="location.locationName">

									</div>
								</div>

								
								
								<div class="form-group">
									<label class="col-md-4 control-label">Country<span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">
										<selectivity list="countryList" id="countryId"
												property="location.countryId"
												ng-model="location.countryId" friendly-name="Country"
												form-name="locationForm" validation="required"
												name="countryId"></selectivity>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Latitude</label>
									<div class="col-md-5 inputGroupContainer">


										<input type="text" class="form-control input-sm" id="latitude"
											friendly-name="Latitude" form-name="locationForm" placeholder="0.347596"
											
											maxlength="35" name="latitude" ng-model="location.latitude">

									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">
										Description </label>
									<div class="col-md-5">
										<textarea ng-model="location.description" name="description"
											friendly-name="Description" form-name="locationForm"
											id="description" maxlength="250"
											class="form-control input-sm" rows="3" style="resize: none;">
		          						</textarea>
		          						
									</div>
								</div>

							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>

								<div class="form-group">
									
									<label class="col-md-4 control-label">Short Name <span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="Short Name" form-name="locationForm"
											id="shortName" maxlength="6" validation="required"
											name="shortName" ng-model="location.shortName">

									</div>
								</div>



								<div class="form-group">
									<label class="col-md-4 control-label"> Type<span
										style="color: red;"> *</span>
									</label>
									<div class="col-md-5">

										<selectivity list="typeList" id="type" name="type"
											property="location.type" ng-model="location.type"
											validation="required" friendly-name="Type"
											form-name="locationForm" form-name="locationForm"></selectivity>

									</div>
								</div>


								<div class="form-group">
									<label class="col-md-4 control-label">Longitude</label>
									<div class="col-md-5 inputGroupContainer">


										<input type="text" class="form-control input-sm"
											friendly-name="Longitude" form-name="locationForm" placeholder="32.582520"
											id="longitude" maxlength="35" name="longitude"
											ng-model="location.longitude">

									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-4 control-label">LandMark</label>
									<div class="col-md-5 inputGroupContainer">


										<input type="text" class="form-control input-sm" id="landMark"
											friendly-name="LandMark" form-name="locationForm"
											maxlength="100" name="landMark" ng-model="location.landMark">

									</div>
								</div>
								
								
								
								


							</fieldset>
						</div>
					</div>

				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit"
								ng-click="validate(location,locationForm)">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" ng-if="isEdit" type="submit"
								ng-click="validate(location,locationForm)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="reset" ng-click="reset()"
								ng-if="!isEdit">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-info" ng-click="reset1()" ng-if="isEdit">
								<i class="fa fa-reply"></i> Reset
							</button>

							<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel</button>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

