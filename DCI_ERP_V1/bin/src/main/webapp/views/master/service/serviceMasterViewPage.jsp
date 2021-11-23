<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="serviceMasterForm" novalidate
				method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"> <b>Service Code</b> <span
										style="color: red;"></span>
									</label> <label class="col-md-1 control-label"
										data-ng-if="serviceMaster.isEdit">{{serviceMaster.sectorCode}}</label>
									<!-- <div class="col-md-5">
									<input type="text" class="form-control input-sm"
										data-ng-model="serviceMaster.sectorCode"
										data-ng-if="!serviceMaster.isEdit" validation="required"
										friendly-name="Service Code" name="sectorCode"
										typeahead-min-length='1'
										typeahead="r.sectorCode as r.sectorCode for r in serviceList | filter:$viewValue | limitTo:10"
										id="sectorCode" />
								</div> -->
								</div>
								
							<!-- 	<div class="form-group">
									<label class="col-md-4 control-label"><b>Controlled By</b>
									</label>
									<div class="col-md-5 inputGroupContainer">
										<label class="control-label">{{serviceMaster.branchName}}</label>
										
										
										<selectivity list="branchList"
											property="serviceMaster.companyCode" id="companyCode"
											disabled="true" ng-model="serviceMaster.companyCode"
											name="companyCode" form-name="serviceMasterForm"
											validation="required" friendly-name="Company Location"></selectivity>
									</div>
								</div> -->
								


	<div class="form-group">
									<label class="col-md-4 control-label"><b>Vessel Operator</b>
									</label>
									<div class="col-md-5 inputGroupContainer">
										<label class="control-label">{{serviceMaster.vendorName}}</label>
										
										
										<!-- <selectivity list="branchList"
											property="serviceMaster.companyCode" id="companyCode"
											disabled="true" ng-model="serviceMaster.companyCode"
											name="companyCode" form-name="serviceMasterForm"
											validation="required" friendly-name="Company Location"></selectivity> -->
									</div>
								</div>
								
								
								
								
								<div class="form-group">
									<label class="col-md-4 control-label"><b>Sailing frequency (Days)</b>
									</label>
									<div class="col-md-5 inputGroupContainer">
										<label class="control-label">{{serviceMaster.sailingfreq}}</label>
										
										
										<!-- <selectivity list="branchList"
											property="serviceMaster.companyCode" id="companyCode"
											disabled="true" ng-model="serviceMaster.companyCode"
											name="companyCode" form-name="serviceMasterForm"
											validation="required" friendly-name="Company Location"></selectivity> -->
									</div>
								</div>
								
								
								
									
								
								
								<div class="form-group">
									<label class="col-md-4 control-label"> <b>Created By</b></label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedBy" ng-model="surchargeData.modifiedBy:" > -->
										<label class="control-label"
											style="text-align: left;">{{serviceMaster.createdBy}}</label>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"><b>Created Date</b></label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedDate" ng-model="surchargeData.modifiedDate" > -->
										<label class="control-label"
											style="text-align: left;">{{serviceMaster.createdDate}}</label>
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label"><b> Service Name</b> <span
										style="color: red;"></span>
									</label>
									<div class="col-md-5">
									
									<label class="control-label"
										data-ng-if="serviceMaster.isEdit">{{serviceMaster.sectorName}}</label>
										
										
								<div class="form-group">
									<label class="col-md-4 control-label"><b>Active</b></label>

									<div class="col-md-5">
									<label class="control-label" data-ng-if="serviceMaster.isActive=='Y'">Yes</label>
									<label class="control-label" data-ng-if="serviceMaster.isActive=='N'">No</label>
									
										<!-- <div class="radio radio-inline">
											<label class="i-checks"> <input type="radio"
												class="radiobox style-0" checked="checked" name="isActive"
												data-ng_model="serviceMaster.isActive" value="Y"
												checked="checked" disabled> <i></i> Yes
											</label>
										</div>
										<div class="radio  radio-inline">
											<label class="i-checks"> <input type="radio"
												class="radiobox style-0"
												data-ng_model="serviceMaster.isActive" value="N"
												checked="checked" name="isActive" disabled> <i></i> No
											</label>
										</div> -->
									</div>






								</div>
								

								
								
								<div class="form-group">
									<label class="col-md-4 control-label"><b>Average transit time for full voyage (Days and Hrs)</b>
									</label>
									<div class="col-md-5 inputGroupContainer">
										<label class="control-label">{{serviceMaster.avgtrans}}</label>
										
										
										<!-- <selectivity list="branchList"
											property="serviceMaster.companyCode" id="companyCode"
											disabled="true" ng-model="serviceMaster.companyCode"
											name="companyCode" form-name="serviceMasterForm"
											validation="required" friendly-name="Company Location"></selectivity> -->
									</div>
								</div>
								
								
								
								<div class="form-group">
									<label class="col-md-4 control-label"> <b>Modified By</b></label>
									<div class="col-md-5">
										<label class="control-label"
											style="text-align: left;">{{serviceMaster.modifiedBy}}</label>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label"><b>Modified Date</b></label>
									<div class="col-md-5">
										<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedDate" ng-model="surchargeData.modifiedDate" > -->
										<label class="control-label"
											style="text-align: left;">{{serviceMaster.modifiedDate}}</label>
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
							<!-- <button class="btn btn-success ng-scope" type="button"
								class="btn btn-success" data-ng-if="!serviceMaster.isEdit"
								data-ng-click="save(serviceMasterForm,serviceMaster)">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success ng-scope" type="button"
								class="btn btn-success" data-ng-if="serviceMaster.isEdit"
								data-ng-click="update(serviceMasterForm,serviceMaster)">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" type="button"
								data-ng-if="!serviceMaster.isEdit" data-ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-primary" type="button"
								data-ng-if="serviceMaster.isEdit" data-ng-click="reset1()">
								<i class="fa fa-undo"></i> Reset
							</button> -->

							<button class="btn btn-danger" data-ng-click="cancel()"
								type="button">
								<i class="fa fa-close"></i>Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>