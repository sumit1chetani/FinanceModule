<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="containerSequenceMasterForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-6 control-label"> ContainerSequence Code <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=6
										ng-model="containerSequenceMaster.containerSequenceCode" name="containerSequenceCode"
										validation="required" form-name="containerSequenceMasterForm"
										friendly-name="ContainerSequence Code" ng-disabled="true">
								</div>
							</div>

							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> ContainerSequence Short Name<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										validation="required" form-name="containerSequenceMasterForm"
										friendly-name="ContainerSequence Name"
										ng-model="containerSequenceMaster.containerSequenceShortName" name="containerSequenceShortName" ng-disabled="true"/>
								</div>
							</div>



							<div class="form-group">
								<label class="col-md-6 control-label">Company<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="companylist"
										property="containerSequenceMaster.company" id="companyId"
										ng-model="containerSequenceMaster.company" name="company"
										form-name="containerSequenceMasterForm" validation="required"
										friendly-name="Company" ng-disabled="true"></selectivity>

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">State<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="statelist" property="containerSequenceMaster.state"
										id="state_id" ng-model="containerSequenceMaster.state" name="state"
										form-name="containerSequenceMasterForm" validation="required"
										friendly-name="State" ng-disabled="true"></selectivity>

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Currency<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="currencyList"
										property="containerSequenceMaster.currencyId" id="currency"
										ng-model="containerSequenceMaster.currencyId" name="currency"
										form-name="containerSequenceMasterForm" validation="required"
										friendly-name="currency"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Country<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<selectivity list="countryList" property="containerSequenceMaster.country"
										id="countryId" ng-model="containerSequenceMaster.country" name="country"
										form-name="containerSequenceMasterForm" friendly-name="country" ng-disabled="true"></selectivity>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-6 control-label"> </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=100
										 form-name="containerSequenceMasterForm"
										friendly-name="ContainerSequence Name" ng-model="containerSequenceMaster.address1"
										name="ContainerSequence name" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=100
										 form-name="containerSequenceMasterForm"
										friendly-name="ContainerSequence Name" ng-model="containerSequenceMaster.address2"
										name="ContainerSequence name" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">City<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="cityList"
										property="containerSequenceMaster.cityId" id="city"
										ng-model="containerSequenceMaster.cityId" name="city"
										form-name="containerSequenceMasterForm" validation="required"
										friendly-name="City"></selectivity>
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-6 control-label"> Zip/Postal Code
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=10
										 form-name="containerSequenceMasterForm"
										friendly-name="Pin Code" ng-model="containerSequenceMaster.pinCode"
										ng-pattern-restrict="^[0-9]*$" name="pincode" />
								</div>
							</div> -->


						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-6 control-label"> ContainerSequence Location<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=250
										validation="required" form-name="containerSequenceMasterForm"
										friendly-name="ContainerSequence Location" ng-model="containerSequenceMaster.containerSequenceLocation"
										name="containerSequenceLocation" ng-disabled="true"/>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> Email Address<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" 
										validation="required" form-name="containerSequenceMasterForm"
										friendly-name="Email Address" ng-model="containerSequenceMaster.eMail"
										name="eMail" ng-disabled="true"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Address </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=250
										form-name="containerSequenceMasterForm" friendly-name="Address"
										ng-model="containerSequenceMaster.address" name="address" ng-disabled="true"/>

								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Phone No
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=15
										 form-name="containerSequenceMasterForm"
										friendly-name="Phone" ng-model="containerSequenceMaster.phoneNumber"
										name="Phone" ng-pattern-restrict="^[0-9]*$" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Fax No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=15
										form-name="containerSequenceMasterForm" friendly-name="Fax No"
										ng-model="containerSequenceMaster.faxNo" name=faxNo
										ng-pattern-restrict="^[0-9]*$" ng-disabled="true"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Person InCharge </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=100
										form-name="containerSequenceMasterForm" friendly-name="Person InCharge"
										ng-model="containerSequenceMaster.personIncharge" name="personIncharge" ng-disabled="true"/>

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> PAN No 
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=50
										ng-model="containerSequenceMaster.panNo" name="PAN No"
										form-name="containerSequenceMasterForm"
										friendly-name="PAN No">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">GSTN State Code <span
									style="color: red;"></span> </label>
								<div class="col-md-5">
									<selectivity list="gstnStateList"
										property="containerSequenceMaster.gstnCode" id="GSTN State Code"
										ng-model="containerSequenceMaster.gstnCode" name="GSTN State Code" 
										form-name="containerSequenceMasterForm" friendly-name="GSTN State Code"></selectivity>

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> GSTN No 
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=15
										ng-model="containerSequenceMaster.gstnNo" name="City"
										form-name="containerSequenceMasterForm"
										friendly-name="City" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Service Tax No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=50
										ng-model="containerSequenceMaster.serviceTaxNo" name="Service Tax No"
										 form-name="containerSequenceMasterForm"
										friendly-name="Service Tax No" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Licence No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=100
										ng-model="containerSequenceMaster.licenceNo" name="Licence No"
										 form-name="containerSequenceMasterForm"
										friendly-name="Licence No" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Active </label>
								<div class="col-md-5">
									<div class="checkbox">
										<label> <input class="checkbox style-0"
											type="checkbox" name="active"
											ng-model="containerSequenceMaster.isActive"> <span></span>
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Default UOM <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="uomList"
										property="containerSequenceMaster.uom" id="Default UOM"
										ng-model="containerSequenceMaster.uom" name="Default UOM"
										validation="required" form-name="containerSequenceMasterForm"
										friendly-name="Default UOM"></selectivity>

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Logo In Documents
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="logoPathList"
										property="containerSequenceMaster.logoPath" id="Logo In Documents"
										ng-model="containerSequenceMaster.logoPath" name="Logo In Documents"
										validation="required" form-name="containerSequenceMasterForm"
										friendly-name="Logo In Documents"></selectivity>

								</div>
							</div> -->
						</fieldset>
					</div>
				</div>
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

