<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="branchMasterForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group" >
								<label class="col-md-6 control-label"> Ledger Date<span
									style="color: red;">*</span>
								</label>
									<div class="col-md-5">
								<div class="input-group input-append date" id="branchMaster_ledgerDate">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="branchMaster.ledgerDate"
											name="ledgerDate" id="ledgerDate"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
																</div>
								
								</div>
							</div>
							<!-- 			<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5">From
									Date <span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<div class="input-group input-append date" id="gl_fromDate">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="generalLedger.fromDate"
											name="fromDate" id="fromDate"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div> -->

							<div class="form-group">
								<label class="col-md-6 control-label">Account Head<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										validation="required" form-name="branchMasterForm"
										friendly-name="Branch Name"
										ng-model="branchMaster.accountHead" name="branchShortName" />
								</div>
							</div>



							<div class="form-group">
								<label class="col-md-6 control-label">Particulars<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										validation="required" form-name="branchMasterForm"
										friendly-name="Branch Name"
										ng-model="branchMaster.particulars" name="branchShortName" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Debit
								</label>
								<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										validation="required" form-name="branchMasterForm"
										friendly-name="Branch Name"
										ng-model="branchMaster.debit" name="branchShortName" />


								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-6 control-label">Currency<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="currencyList"
										property="branchMaster.currencyId" id="currency"
										ng-model="branchMaster.currencyId" name="currency"
										form-name="branchMasterForm" validation="required"
										friendly-name="currency"></selectivity>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-6 control-label">Credit<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
										<input type="text" class="form-control input-sm"
										validation="required" form-name="branchMasterForm"
										friendly-name="Branch Name"
										ng-model="branchMaster.credit" name="branchShortName" />		</div>
							</div>
								 <div class="form-group">
								<label class="col-md-6 control-label">Company
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=50
										ng-model="branchMaster.company" name="PAN No"
										form-name="branchMasterForm"
										friendly-name="PAN No">
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=100
										 form-name="branchMasterForm"
										friendly-name="Branch Name" ng-model="branchMaster.address1"
										name="Branch name" />

								</div>
							</div> -->
							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=100
										 form-name="branchMasterForm"
										friendly-name="Branch Name" ng-model="branchMaster.address2"
										name="Branch name" />

								</div>
							</div> -->
							<!-- <div class="form-group">
								<label class="col-md-6 control-label">City<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="cityList"
										property="branchMaster.cityId" id="city"
										ng-model="branchMaster.cityId" name="city"
										form-name="branchMasterForm" validation="required"
										friendly-name="City"></selectivity>
								</div>
							</div> -->


							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> Zip/Postal Code
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=10
										 form-name="branchMasterForm"
										friendly-name="Pin Code" ng-model="branchMaster.pinCode"
										ng-pattern-restrict="^[0-9]*$" name="pincode" />
								</div>
							</div> -->


						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-6 control-label"> Financial Year<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=250
										validation="required" form-name="branchMasterForm"
										friendly-name="Branch Name" ng-model="branchMaster.year"
										name="branchName" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Sub Group<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=250
										validation="required" form-name="branchMasterForm"
										friendly-name="Branch Name" ng-model="branchMaster.subGroup"
										name="branchName" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Currency </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=250
										form-name="branchMasterForm" friendly-name="Address"
										ng-model="branchMaster.currency" name="address" />

								</div>
							</div>
							
							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Phone No
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=15
										 form-name="branchMasterForm"
										friendly-name="Phone" ng-model="branchMaster.phoneNumber"
										name="Phone" ng-pattern-restrict="^[0-9]*$" />
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-6 control-label">Local Debit </label>
								<div class="col-md-5">
						<input type="text" class="form-control input-sm" maxlength=250
										form-name="branchMasterForm" friendly-name="Address"
										ng-model="branchMaster.localDebit" name="address" />

							
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Local Credit </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=100
										form-name="branchMasterForm" friendly-name="Person InCharge"
										ng-model="branchMaster.localCredit" name="personIncharge" />

								</div>
							</div>
								<div class="form-group">
								<label class="col-md-6 control-label">Sl NO </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=100
										form-name="branchMasterForm" friendly-name="Person InCharge"
										ng-model="branchMaster.slno" name="personIncharge" />

								</div>
							</div>
						
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">GSTN State Code <span
									style="color: red;"></span> </label>
								<div class="col-md-5">
									<selectivity list="gstnStateList"
										property="branchMaster.gstnCode" id="GSTN State Code"
										ng-model="branchMaster.gstnCode" name="GSTN State Code" 
										form-name="branchMasterForm" friendly-name="GSTN State Code"></selectivity>

								</div>
							</div> -->

							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> GSTN No 
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=15
										ng-model="branchMaster.gstnNo" name="City"
										form-name="branchMasterForm"
										friendly-name="City" />
								</div>
							</div> -->
							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Service Tax No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=50
										ng-model="branchMaster.serviceTaxNo" name="Service Tax No"
										 form-name="branchMasterForm"
										friendly-name="Service Tax No" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Licence No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"maxlength=100
										ng-model="branchMaster.licenceNo" name="Licence No"
										 form-name="branchMasterForm"
										friendly-name="Licence No" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Active </label>
								<div class="col-md-5">
									<div class="checkbox">
										<label> <input class="checkbox style-0"
											type="checkbox" name="active"
											ng-model="branchMaster.isActive"> <span></span>
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
										property="branchMaster.uom" id="Default UOM"
										ng-model="branchMaster.uom" name="Default UOM"
										validation="required" form-name="branchMasterForm"
										friendly-name="Default UOM"></selectivity>

								</div>
							</div> -->
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Logo In Documents
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="logoPathList"
										property="branchMaster.logoPath" id="Logo In Documents"
										ng-model="branchMaster.logoPath" name="Logo In Documents"
										validation="required" form-name="branchMasterForm"
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
								ng-click="save(branchMasterForm,branchMaster)">
								<i class="fa fa-save"></i> Save

							</button>
							<button class="btn btn-success" type="button" ng-if="isEdit"
								class="btn btn-success"
								ng-click="update(branchMasterForm,branchMaster)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset()">
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

