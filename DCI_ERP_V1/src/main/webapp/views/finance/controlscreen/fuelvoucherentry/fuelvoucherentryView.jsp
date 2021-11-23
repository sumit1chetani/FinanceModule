<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">

		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="fuelvoucherentryForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group" ng-if="edit">
									<label class="col-md-4 control-label"> Voucher No.
									</label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="txtAcctHeadName" name="entryNo" 
											ng-model="fuelmodel.entryNo" validation="required"
											friendly-name="Entry No" form-name="fuelvoucherentryForm" disabled="true"/>
									</div>
								</div>
								<div class="form-group" ng-if="!edit">
									<label class="col-md-4 control-label"> Voucher No.
									</label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="txtAcctHeadName" name="entryNo" 
											ng-model="fuelmodel.entryNo" validation="required"
											friendly-name="Entry No" form-name="fuelvoucherentryForm" disabled="true"/>
									</div>
								</div>									
								<div class="form-group">
									<label class="col-md-4 control-label">Voucher Date</label>

									<div class="col-md-5">
										<ng-bs3-datepicker data-ng-model="fuelmodel.date" id="date"
											name="date" form-name="toForm" friendly-name="date"
											validation="required" disabled="true"/>
									</div>
								</div>
								<div class="form-group">
								<label class="col-md-4 control-label">Trip</label>
								<div class="col-md-5 inputGroupContainer">
									<selectivity list="tripTypeList" id="tripType"
										name="tripType"
										property="fuelmodel.tripType"
										ng-model="fuelmodel.tripType" validation="required"
										friendly-name="tripType"
										form-name="fuelvoucherentryForm" disabled="true"></selectivity>
								</div>
							</div>	
								<div class="form-group">
									<label class="col-md-4 control-label">LOL
									</label>
									<div class="col-md-5">										
										<input type="text" class="form-control input-sm"
											id="locationName" name="locationName"
											ng-model="fuelmodel.locationName" validation="required"
											friendly-name="Location Name" form-name="fuelvoucherentryForm" disabled="true"/>
										
									</div>
								</div>	
								<div class="form-group">
									<label class="col-md-4 control-label">LOD</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											id="destination" name="destination"
											ng-model="fuelmodel.destination" validation="required"
											friendly-name="Destination" form-name="fuelvoucherentryForm" disabled="true"/>
									</div>
								</div>			
							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>	
							<div class="form-group">
									<label class="col-md-4 control-label">Truck</label>
									<div class="col-md-5">
										 <input type="text" class="form-control input-sm" id="truckNo"
											name="truckNo" ng-model="fuelmodel.truckNo"
											validation="required" friendly-name="Truck No."
											form-name="fuelvoucherentryForm" disabled="true"/>					
											
									</div>
								</div>								
								<div class="form-group">
									<label class="col-md-4 control-label">Driver's Name</label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="driversName" name="driversName"
											ng-model="fuelmodel.driversName" validation="required"
											friendly-name="Drivers Name" form-name="fuelvoucherentryForm" disabled="true"/>
									</div>
								</div>		
								
								<div class="form-group">
									<label class="col-md-4 control-label"> Fuel Type</label>
									<div class="col-md-2">
										<selectivity list="fuelList" id="fuelType" disabled="true"
											property="fuelmodel.fuelType" name="fuelType"
											ng-model="fuelmodel.fuelType" friendly-name="Fuel Type" form-name="fuelvoucherentryForm"></selectivity>
									</div>
									<label class="col-md-1 control-label">Units</label>
									<div class="col-md-2">
										<input type="text" class="form-control input-sm" id="liters"
											name="liters" ng-model="fuelmodel.liters" 
											validation="required" friendly-name="Liters"
											form-name="fuelvoucherentryForm" maxlength="15" disabled="true"/>
									</div>

								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Supplier</label>
									<div class="col-md-5">				
											
									<selectivity list="localtionList" id="vendorCode"
										name="vendorCode"
										property="fuelmodel.vendorCode"
										ng-model="fuelmodel.vendorCode" validation="required"
										friendly-name="Supplier"
										form-name="fuelvoucherentryForm" disabled="true"></selectivity> 
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Filling Location </label>
									<div class="col-md-5">											
											<textarea ng-model="fuelmodel.fillingLocation"
											name="fillingLocation"
											class="custom-scroll width_100 resize-none" rows="3" disabled="true">
		          						</textarea>
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
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>			
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>



<%-- <div class="wrapper-md">
	<div class="panel panel-default panel-default-form">

		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="fuelvoucherentryForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">Voucher No.</label> <label
										class="col-md-5 control-label" style="text-align: left">{{fuelmodel.entryNo}}</label>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Date</label> <label
										class="col-md-5 control-label" style="text-align: left">{{fuelmodel.date}}</label>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Trip<span
										style="color: red;"> </span></label> <label
										class="col-md-4 control-label text-left"></label>
									<div class="col-md-5 inputGroupContainer">
										<selectivity list="tripTypeList" id="tripType" name="tripType"
											property="fuelmodel.tripType" ng-model="fuelmodel.tripType"
											validation="required" friendly-name="tripType"
											form-name="fuelvoucherentryForm" disabled="true"></selectivity>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">LOL<span
										style="color: red;"> </span></label> <label
										class="col-md-5 control-label" style="text-align: left">{{fuelmodel.locationName}}</label>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">LOD<span
										style="color: red;"> </span></label> <label
										class="col-md-5 control-label" style="text-align: left">{{fuelmodel.destination}}</label>
								</div>

							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">Truck<span
									style="color: red;"> </span></label> <label
										class="col-md-5 control-label" style="text-align: left">{{fuelmodel.truckNo}}</label>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Driver's Name<span
									style="color: red;"> </span> </label> <label
										class="col-md-5 control-label" style="text-align: left">{{fuelmodel.driversName}}</label>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Supplier <span
									style="color: red;"> </span></label> <label
										class="col-md-5 control-label" style="text-align: left">{{fuelmodel.vendorName}}</label>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label"> Fuel Type </label>
									<div class="col-md-2">
										<selectivity list="fuelList" id="fuelType" disabled="true"
											property="fuelmodel.fuelType" name="fuelType"
											ng-model="fuelmodel.fuelType" friendly-name="Fuel Type" ></selectivity>
									</div>
									<label class="col-md-1 control-label">Units <span
									style="color: red;"> </span></label> <label
										class="col-md-5 control-label" style="text-align: left">{{fuelmodel.liters}}</label>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">
										Filling Location </label>
									<div class="col-md-5">
										<textarea ng-model="fuelmodel.fillingLocation"
											name="fillingLocation"
											class="custom-scroll width_100 resize-none" rows="3"
											disabled="true">
		            </textarea>
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

							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>


						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

 --%>