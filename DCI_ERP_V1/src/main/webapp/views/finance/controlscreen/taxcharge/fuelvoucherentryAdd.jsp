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
								<div class="form-group">
									<label class="col-md-4 control-label"> Entry No.<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="txtAcctHeadName" name="entryno"
											ng-model="fuelmodel.entryno" validation="required"
											friendly-name="Entry No" form-name="fuelvoucherentryForm" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Date</label>
									<div class="col-md-5 inputGroupContainer">


										<div class="input-group input-append date">
											<input type="text" class="form-control input-sm" id="date"
												name="date" ng-model="fuelmodel.date" validation="required"
												friendly-name="date" /> <span
												class="input-group-addon add-on"><span
												class="glyphicon glyphicon-calendar"></span></span>
										</div>

									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">To<span
										style="color: red;">*</span></label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="txtAcctHeadName" name="toname"
											ng-model="fuelmodel.toname" validation="required"
											friendly-name="To" form-name="fuelvoucherentryForm" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label"> Fuel Type </label>
									<div class="col-md-2">
										<selectivity list="fueltype" id="fueltype"
											property="fuelmodel.fueltype" name="fueltype"
											ng-model="fuelmodel.fueltype"></selectivity>
									</div>
									<label class="col-md-1 control-label"> Liters </label>
									<div class="col-md-2">
										<input type="text" class="form-control input-sm" id="liters"
											name="liters" ng-model="fuelmodel.liters"
											validation="required" friendly-name="Liters"
											form-name="fuelvoucherentryForm" />
									</div>

								</div>
								<!-- <div class="form-group">
									<label class="col-md-5 control-label"> Status <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="payStatus"
											property="transportFeeobj.statusId" id="payStatus"
											ng-model="transportFeeobj.statusId" name="payStatus"
											form-name="transportFreeManagementForm" validation="required"
											friendly-name="Status"></selectivity>
									</div>
								</div> -->
								<div class="form-group">
									<label class="col-md-4 control-label">Please Fuel Truck
										No. </label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm" id="truckno"
											name="truckno" ng-model="fuelmodel.truckno"
											validation="required" friendly-name="Please Fuel Truck No."
											form-name="fuelvoucherentryForm" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Road Consignment
										No. </label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="consignmentno" name="consignmentno"
											ng-model="fuelmodel.consignmentno" validation="required"
											friendly-name="Consignment No"
											form-name="fuelvoucherentryForm" />
									</div>
								</div>


							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">Destination </label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="destination" name="destination"
											ng-model="fuelmodel.destination" validation="required"
											friendly-name="Destination" form-name="fuelvoucherentryForm" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Authorised By. </label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="authorisedby" name="authorisedby"
											ng-model="fuelmodel.authorisedby" validation="required"
											friendly-name="Authorised By."
											form-name="fuelvoucherentryForm" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Signature </label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="signature" name="signature"
											ng-model="fuelmodel.signature" validation="required"
											friendly-name="Signature" form-name="fuelvoucherentryForm" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Driver's Name </label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="driversname" name="driversname"
											ng-model="fuelmodel.driversname" validation="required"
											friendly-name="Drivers Name" form-name="fuelvoucherentryForm" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Driver's
										Signature </label>
									<div class="col-md-5">

										<input type="text" class="form-control input-sm"
											id="txtAcctHeadName" name="driverssignature"
											ng-model="fuelmodel.driverssignature" validation="required"
											friendly-name="Drivers Signature"
											form-name="fuelvoucherentryForm" />
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
							<button class="btn btn-success" ng-if="edit"
								ng-click="validate(fuelvoucherentryForm)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success"
								ng-click="validate(fuelvoucherentryForm)" ng-if="!edit"
								type="submit">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" ng-if="edit" type="reset"
								ng-click="reset()">
								<i class="fa fa-reply"></i> Reset
							</button>


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

