
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="manageLocationAddForm" novalidate
				method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<fieldset>
							<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-4 control-label">Asset Location <span
										class="font-red">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											name="manageName" id="manageName"
											data-ng-model="manageLocationObj.manageName"
											validation="required" friendly-name="Asset Location"
											ng-blur="checkLocationName(manageLocationObj.manageName)">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"> Asset Type <span
										class="font-red">*</span>
									</label>
									<div class="col-md-7">
										<select class="form-control" name="Location Type" 
											validation="required" friendly-name="Asset Type"
											data-ng-model="manageLocationObj.lid"
											ng-options="msto.id as msto.text for msto in locationTypeList">
											<option value="">Select</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Asset Parent
										Location</label>
									<div class="col-md-7">
										<select class="form-control" name="Asset Parent Location"
											data-ng-model="manageLocationObj.pid"
											ng-options="mst.id as mst.text for mst in parentLocationList">
											<option value="">Select</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Asset InCharge <span
										class="font-red">*</span>
									</label>
									<div class="col-md-7">
										<select class="form-control" name="empId" id="empId"
											data-ng-model="manageLocationObj.empId" validation="required"
											friendly-name="Asset InCharge"
											ng-options="msto.empId as msto.locationIncharge for msto in inChargeList">
											<option value="">Select</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">is Active</label>
									<div class="col-md-7">
										<div class="checkbox">
											<label> <input type="checkbox"
												class="checkbox style-0"
												data-ng-model="manageLocationObj.isActive"
												data-ng-true-value="'t'" data-ng-false-value="'N'">
												<span></span>
											</label>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Scrap Location</label>
									<div class="col-md-7">
										<div class="checkbox">
											<label> <input type="checkbox"
												class="checkbox style-0"
												data-ng-model="manageLocationObj.scrapLocation"
												data-ng-true-value="'t'" data-ng-false-value="'N'">
												<span></span>
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="col-md-4 control-label">Asset Activity</label>
									<div class="col-md-7">
										<textarea type="text" class="form-control input-sm" rows="2"
											cols="25" name="Asset Activity"
											ng-model="manageLocationObj.locationActivity"
											style="resize: none"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Use Parent
										Address <span
										class="font-red">*</span></label>
									<div class="col-md-7">
										<div class="checkbox">
											<label> <input type="checkbox"
												class="checkbox style-0"
												data-ng-model="manageLocationObj.isParentAddress"
												data-ng-true-value="'t'"
												ng-click="getParentAddress(manageLocationObj.isParentAddress,manageLocationObj.pid)"
												data-ng-false-value="'N'"> <span></span>
											</label>
										</div>
									</div>
								</div>
								<div class="form-group" id="parentAddress">
									<label class="col-md-4 control-label">Asset Address</label>
									<div class="col-md-7">
										<textarea class="text-left form-control input-sm" rows="2"
											cols="15" data-ng-model="manageLocationObj.address"
											validation="required" friendly-name="Asset Address"
											style="resize: none" id="address" name="address"> 
		               						 </textarea>
										<div class="form-group"></div>
										<div class="col-md-5 no-padding padding-top-5 padding-left-5">
											<select class="form-control"
												data-ng-model="manageLocationObj.cityId" placeholder="city"
												id="cityId" name="cityId"
												ng-options="msto.cityId as msto.city for msto in cityList"
												validation="required" friendly-name="City"
												ng-change="country(manageLocationObj.cityId)">
												<option value="" disabled selected>City</option>
											</select>
										</div>
										<div class="col-md-4 no-padding padding-left-5 padding-top-5">
											<input type="text" class="form-control input-sm"
												placeholder="State" ng-model="manageLocationObj.state">
										</div>
										<div
											class="col-md-3 no-padding padding-left-5 padding-top-5 padding-right-3">
											<input type="text" class="form-control input-sm"
												placeholder="zip" ng-model="manageLocationObj.zipCode">
										</div>
										<div class="form-group"></div>
										<div
											class="col-md-12 no-padding padding-top-5 padding-left-5 padding-right-3">
											<input type="text" class="form-control input-sm"
												placeholder="country" ng-model="manageLocationObj.country"
												readonly>
										</div>
									</div>
								</div>
								<div class="form-group" id="parentAddressReadonly">
									<label class="col-md-4 control-label">Asset Address</label>
									<div class="col-md-7">
										<textarea class="text-left form-control input-sm" rows="2"
											cols="15" data-ng-model="manageLocationObj.address"
											style="resize: none" readonly> 
			                </textarea>
										<div class="form-group"></div>
										<div class="col-md-5 no-padding padding-top-5 padding-left-5">
											<div class="col-md-5 no-padding padding-top-5">
												<input type="text" class="form-control"
													ng-model="manageLocationObj.city" readonly>
											</div>
										</div>
										<div class="col-md-4 no-padding padding-left-5 padding-top-5">
											<input type="text" class="form-control input-sm"
													ng-model="manageLocationObj.state" readonly>
										</div>
										<div
											class="col-md-3 no-padding padding-left-5 padding-top-5 padding-right-3">
											<input type="text" class="form-control input-sm"
													ng-model="manageLocationObj.zipCode" readonly>
										</div>
										<div class="form-group"></div>
										<div
											class="col-md-12 no-padding padding-top-5 padding-left-5 padding-right-3">
											<input type="text" class="form-control input-sm"
												ng-model="manageLocationObj.country" readonly>
										</div>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>


				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" data-ng-if="!isEdit"
								type="submit"
								ng-click="validate(manageLocationAddForm,manageLocationObj)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" data-ng-if="isEdit==true"
								type="submit"
								ng-click="validate(manageLocationAddForm,manageLocationObj)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info ng-scope" type="submit"
								ng-click="reset(manageLocationAddForm)" class="btn btn-success">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="button"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- panel-body -->
	</div>
	<!-- /panel-default -->
</div>
<!-- /wrapper-md -->