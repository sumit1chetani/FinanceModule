<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="containerStatusMasterForm">
				<div class="row">
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>

							<div class="form-group">
								<label class="col-md-3 control-label"> Code <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" maxlength=10
										ng-model="containerStatusMaster.containerStatusCode" name="containerStatusCode"
										validation="required" form-name="containerStatusMasterForm"
										friendly-name="ContainerStatus Code" placeholder="Container Status Code">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label"> Depot </label>
								<div class="col-md-3">
								
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="depot" id="depot"
											class="checkbox style-0" name="depot"
											ng-model="containerStatusMaster.depot"> <i></i>
										</label>
									</div>
								</div>
										</div>
									<div class="form-group">
									<label class="col-md-3 control-label"> Shipper </label>
									<div class="col-md-3">
																
								
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="shipper" id="depot"
											class="checkbox style-0" name="shipper"
											ng-model="containerStatusMaster.shipper"> <i></i>
										</label>
									</div>
								</div>
								</div>
								
							
							
							
							
						
								
 

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
						<div class="form-group">
						<label class="col-md-3 control-label">Sub Code <span
									style="color: red;"></span>
								</label>
								<div class="col-md-6">

									<selectivity list="subCodeList"
										property="containerStatusMaster.subCode" id="subCode"
										ng-model="containerStatusMaster.subCode" name="subCode"
										friendly-name="subCode " form-name="containerStatusMasterForm"></selectivity>
								</div>
							
						</div>
						<div class="form-group">
						<label class="col-md-3 control-label"> Customer </label>
						<div class="col-md-3">
								
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="customer" id="depot"
											class="checkbox style-0" name="customer"
											ng-model="containerStatusMaster.customer"> <i></i>
										</label>
									</div>
						</div>
						</div>
						<div class="form-group">
						<label class="col-md-3 control-label"> Consignee </label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="consignee" id="depot"
											class="checkbox style-0" name="consignee"
											ng-model="containerStatusMaster.consignee"> <i></i>
										</label>
									</div>
								</div>
								</div>
						</fieldset>
						</div>
					<div class="col-sm-12 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-3 control-label"> Description<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" maxlength=250
										validation="required" form-name="containerStatusMasterForm"
										friendly-name="ContainerStatus Description" ng-model="containerStatusMaster.containerStatusDescription"
										name="containerStatusDescription" placeholder="Container Status Description"/>
								</div>
							</div>
									<div class="form-group">
								<label class="col-md-3 control-label"> Vessel </label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="vessel" id="vessel"
											class="checkbox style-0" name="vessel"
											ng-model="containerStatusMaster.vessel"> <i></i>
										</label>
									</div>
								</div>
								
								<label class="col-md-3 control-label"> Voyage </label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="voyage" id="depot"
											class="checkbox style-0" name="voyage"
											ng-model="containerStatusMaster.voyage"> <i></i>
										</label>
									</div>
								</div>
								
									<label class="col-md-3 control-label"> POL </label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="pol" id="depot"
											class="checkbox style-0" name="pol"
											ng-model="containerStatusMaster.pol"> <i></i>
										</label>
									</div>
								</div>
								<label class="col-md-3 control-label"> POD </label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											message-id="pod" id="depot"
											class="checkbox style-0" name="pod"
											ng-model="containerStatusMaster.pod"> <i></i>
										</label>
									</div>
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
										name="eMail" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Address </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=250
										form-name="containerStatusMasterForm" friendly-name="Address"
										ng-model="containerStatusMaster.address" name="address" />

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
										ng-pattern-restrict="^[0-9]*$" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Person InCharge </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=100
										form-name="containerStatusMasterForm" friendly-name="Person InCharge"
										ng-model="containerStatusMaster.personIncharge" name="personIncharge" />

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
							<button class="btn btn-success" type="button" ng-if="!isEdit"
								class="btn btn-success"
								ng-click="save(containerStatusMasterForm,containerStatusMaster)">
								<i class="fa fa-save"></i> Save

							</button>
							<button class="btn btn-success" type="button" ng-if="isEdit"
								class="btn btn-success"
								ng-click="update(containerStatusMasterForm,containerStatusMaster)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset(containerStatusMasterForm,containerStatusMaster)">
								<i class="fa fa-undo"></i> Reset
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

