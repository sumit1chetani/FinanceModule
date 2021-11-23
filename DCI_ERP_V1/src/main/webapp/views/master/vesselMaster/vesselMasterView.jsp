<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="vesselmasterForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label"> Vessel Code <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=6
										ng-model="vesselMasterAdd.vesselCode" name="vesselCode"
										validation="required" form-name="vesselmasterForm"
										friendly-name="Vessel Code" ng-disabled="true">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Vessel Flag<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=6
										ng-model="vesselMasterAdd.vesselFlag" name="vesselFlag"
										validation="required" form-name="componentMasterForm"
										friendly-name="vesselFlag" ng-disabled="true">
								</div>						
									</div>
									
									<div class="form-group">
								<label class="col-md-4 control-label">Net Tonnage
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="netTonnage"
										ng-model="vesselMasterAdd.netTonnage" 
										friendly-name="netTonnage" ng-disabled="true"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">Main Line Service</label>
								<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										ng-model="vesselMasterAdd.mainLineService" name="mainLineService"
										friendly-name="Main Line Service"
										form-name="vesselmasterForm" ng-disabled="true"/>
								</div>
							</div>
										</fieldset>
					</div>

<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							
<div class="form-group">
								<label class="col-md-4 control-label">Vessel Name<span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="vesselName"
										ng-model="vesselMasterAdd.vesselName"
										friendly-name="Vessel Name" form-name="vesselmasterForm" ng-disabled="true"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">Gross Tonnage</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="grossTonnage"
										ng-model="vesselMasterAdd.grossTonnage"
										friendly-name="grossTonnage" ng-disabled="true"/>
								</div>
							</div>

		<div class="form-group">
								<label class="col-md-4 control-label">Call Sign
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="callSign"
										ng-model="vesselMasterAdd.callSign"
										friendly-name="callSign" ng-disabled="true" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Vessel Owner
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="vesselOwner"
										ng-model="vesselMasterAdd.vesselOwner"
										friendly-name="vesselOwner" ng-disabled="true"/>
								</div>
							</div>

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

