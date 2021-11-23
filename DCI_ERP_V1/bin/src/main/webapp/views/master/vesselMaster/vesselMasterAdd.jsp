
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="vesselmasterForm" class="form-horizontal" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group" ng-if="!isEdit">
								<label class="col-md-4 control-label">Vessel Code<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="vesselCode" id="vesselCode" placeholder="Vessel Code"
										ng-model="vesselMasterAdd.vesselCode"
										friendly-name="Vessel Code" form-name="vesselmasterForm" validation="required"/>
								</div>
							</div>
							<div class="form-group" ng-if="isEdit">
								<label class="col-md-4 control-label">Vessel Code<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
								<label class="control-label" align="left">{{vesselMasterAdd.vesselCode}}
								</label>
									<!-- <input type="text" class="form-control input-sm"
										name="vesselCode" id="vesselCode" placeholder="Vessel Code"
										ng-model="vesselMasterAdd.vesselCode" disabled
										friendly-name="Vessel Code" form-name="vesselmasterForm" validation="required"/> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Vessel Flag</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="vesselFlag" id="vesselFlag" placeholder="Vessel Flag"
										ng-model="vesselMasterAdd.vesselFlag"
										friendly-name="vesselFlag"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Net Tonnage
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="netTonnage" id="netTonnage" placeholder="Net Tonnage"
										ng-model="vesselMasterAdd.netTonnage" onkeypress="if (isNaN( String.fromCharCode(event.keyCode))) return false;"
										friendly-name="netTonnage"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">Main Line Service</label>
								<div class="col-md-5">
									<selectivity list="mainLineServiceList"
										property="vesselMasterAdd.mainLineService" id="mainLineService"
										ng-model="vesselMasterAdd.mainLineService" name="mainLineService"
										friendly-name="Main Line Service"
										form-name="vesselmasterForm"></selectivity>
								</div>
							</div>
							
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Nationality<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="nationalitYList"
										property="vesselMasterAdd.nationalitYList" id="nationalitYList"
										ng-model="vesselMasterAdd.nationalitYList" name="nationalitYList"
										validation="required" friendly-name="nationalitYList"
										form-name="vesselmasterForm" required></selectivity>
								</div>
							</div> -->
						

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Vessel Name<span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="vesselName" id="vesselName" placeholder="Vessel Name"
										ng-model="vesselMasterAdd.vesselName"
										friendly-name="Vessel Name" form-name="vesselmasterForm" validation="required"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Gross Tonnage</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="grossTonnage" id="grossTonnage" placeholder="Gross Tonnage"
										ng-model="vesselMasterAdd.grossTonnage" onkeypress="if ( isNaN( String.fromCharCode(event.keyCode) )) return false;"
										friendly-name="grossTonnage"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Call Sign
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="callSign" id="callSign" placeholder="Call Sign"
										ng-model="vesselMasterAdd.callSign"
										friendly-name="callSign" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Vessel Owner
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="vesselOwner" id="vesselOwner" placeholder="Vessel Owner"
										ng-model="vesselMasterAdd.vesselOwner"
										friendly-name="vesselOwner"/>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
			
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!isEdit" class="btn btn-success"
								ng-click="save(vesselmasterForm,vesselMasterAdd)">
								<i class="fa fa-save"></i> Save

							</button>
							<button class="btn btn-success" type="button"
								ng-if="isEdit" class="btn btn-success"
								ng-click="update(vesselmasterForm,vesselMasterAdd)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset(vesselMasterAdd)">
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