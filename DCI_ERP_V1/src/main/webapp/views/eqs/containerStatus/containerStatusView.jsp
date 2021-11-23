<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="containerStatusMasterForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-6 control-label"> ContainerStatus Code <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=6
										ng-model="containerStatusMaster.containerStatusCode" name="containerStatusCode"
										validation="required" form-name="containerStatusMasterForm"
										friendly-name="ContainerStatus Code" ng-disabled="true">
								</div>
							</div>


<div class="form-group">
									<label class="col-md-6 control-label"> Created By</label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedBy" ng-model="surchargeData.modifiedBy:" > -->
										<label class="col-md-12 control-label"
											style="text-align: left;">{{containerStatusMaster.createdBy}}</label>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-6 control-label">Created Date</label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedDate" ng-model="surchargeData.modifiedDate" > -->
										<label class="col-md-12 control-label"
											style="text-align: left;">{{containerStatusMaster.createdDate}}</label>
									</div>
								</div>



							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> ContainerStatus Short Name<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										validation="required" form-name="containerStatusMasterForm"
										friendly-name="ContainerStatus Name"
										ng-model="containerStatusMaster.containerStatusShortName" name="containerStatusShortName" ng-disabled="true"/>
								</div>
							</div>



							<div class="form-group">
								<label class="col-md-6 control-label">Company<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="companylist"
										property="containerStatusMaster.company" id="companyId"
										ng-model="containerStatusMaster.company" name="company"
										form-name="containerStatusMasterForm" validation="required"
										friendly-name="Company" ng-disabled="true"></selectivity>

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">State<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="statelist" property="containerStatusMaster.state"
										id="state_id" ng-model="containerStatusMaster.state" name="state"
										form-name="containerStatusMasterForm" validation="required"
										friendly-name="State" ng-disabled="true"></selectivity>

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Currency<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="currencyList"
										property="containerStatusMaster.currencyId" id="currency"
										ng-model="containerStatusMaster.currencyId" name="currency"
										form-name="containerStatusMasterForm" validation="required"
										friendly-name="currency"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Country<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<selectivity list="countryList" property="containerStatusMaster.country"
										id="countryId" ng-model="containerStatusMaster.country" name="country"
										form-name="containerStatusMasterForm" friendly-name="country" ng-disabled="true"></selectivity>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-6 control-label"> </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=100
										 form-name="containerStatusMasterForm"
										friendly-name="ContainerStatus Name" ng-model="containerStatusMaster.address1"
										name="ContainerStatus name" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=100
										 form-name="containerStatusMasterForm"
										friendly-name="ContainerStatus Name" ng-model="containerStatusMaster.address2"
										name="ContainerStatus name" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">City<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="cityList"
										property="containerStatusMaster.cityId" id="city"
										ng-model="containerStatusMaster.cityId" name="city"
										form-name="containerStatusMasterForm" validation="required"
										friendly-name="City"></selectivity>
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-6 control-label"> Zip/Postal Code
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=10
										 form-name="containerStatusMasterForm"
										friendly-name="Pin Code" ng-model="containerStatusMaster.pinCode"
										ng-pattern-restrict="^[0-9]*$" name="pincode" />
								</div>
							</div> -->


						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-6 control-label"> ContainerStatus Description<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=250
										validation="required" form-name="containerStatusMasterForm"
										friendly-name="ContainerStatus Description" ng-model="containerStatusMaster.containerStatusDescription"
										name="containerStatusDescription" ng-disabled="true"/>
								</div>
							</div>
							
							<div class="form-group">
									<label class="col-md-6 control-label"> Modified By</label>
									<div class="col-md-5">
										<label class="col-md-12 control-label"
											style="text-align: left;">{{containerStatusMaster.modifiedBy}}</label>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-6 control-label">Modified Date</label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedDate" ng-model="surchargeData.modifiedDate" > -->
										<label class="col-md-12 control-label"
											style="text-align: left;">{{containerStatusMaster.modifiedDate}}</label>
									</div>
								</div>
							
							
							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> Email Address<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" 
										validation="required" form-name="containerStatusMasterForm"
										friendly-name="Email Address" ng-model="containerStatusMaster.eMail"
										name="eMail" ng-disabled="true"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Address </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=250
										form-name="containerStatusMasterForm" friendly-name="Address"
										ng-model="containerStatusMaster.address" name="address" ng-disabled="true"/>

								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Phone No
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=15
										 form-name="containerStatusMasterForm"
										friendly-name="Phone" ng-model="containerStatusMaster.phoneNumber"
										name="Phone" ng-pattern-restrict="^[0-9]*$" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Fax No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=15
										form-name="containerStatusMasterForm" friendly-name="Fax No"
										ng-model="containerStatusMaster.faxNo" name=faxNo
										ng-pattern-restrict="^[0-9]*$" ng-disabled="true"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Person InCharge </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=100
										form-name="containerStatusMasterForm" friendly-name="Person InCharge"
										ng-model="containerStatusMaster.personIncharge" name="personIncharge" ng-disabled="true"/>

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> PAN No 
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=50
										ng-model="containerStatusMaster.panNo" name="PAN No"
										form-name="containerStatusMasterForm"
										friendly-name="PAN No">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">GSTN State Code <span
									style="color: red;"></span> </label>
								<div class="col-md-5">
									<selectivity list="gstnStateList"
										property="containerStatusMaster.gstnCode" id="GSTN State Code"
										ng-model="containerStatusMaster.gstnCode" name="GSTN State Code" 
										form-name="containerStatusMasterForm" friendly-name="GSTN State Code"></selectivity>

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> GSTN No 
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=15
										ng-model="containerStatusMaster.gstnNo" name="City"
										form-name="containerStatusMasterForm"
										friendly-name="City" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Service Tax No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=50
										ng-model="containerStatusMaster.serviceTaxNo" name="Service Tax No"
										 form-name="containerStatusMasterForm"
										friendly-name="Service Tax No" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Licence No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=100
										ng-model="containerStatusMaster.licenceNo" name="Licence No"
										 form-name="containerStatusMasterForm"
										friendly-name="Licence No" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Active </label>
								<div class="col-md-5">
									<div class="checkbox">
										<label> <input class="checkbox style-0"
											type="checkbox" name="active"
											ng-model="containerStatusMaster.isActive"> <span></span>
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
										property="containerStatusMaster.uom" id="Default UOM"
										ng-model="containerStatusMaster.uom" name="Default UOM"
										validation="required" form-name="containerStatusMasterForm"
										friendly-name="Default UOM"></selectivity>

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Logo In Documents
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="logoPathList"
										property="containerStatusMaster.logoPath" id="Logo In Documents"
										ng-model="containerStatusMaster.logoPath" name="Logo In Documents"
										validation="required" form-name="containerStatusMasterForm"
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

