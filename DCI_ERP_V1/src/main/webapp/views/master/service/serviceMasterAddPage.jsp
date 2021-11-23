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
								<label class="col-md-4 control-label"> Service Code <span
									style="color: red;">*</span>
								</label> <label class="col-md-1 control-label"
									data-ng-if="serviceMaster.isEdit">{{serviceMaster.sectorCode}}</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										data-ng-model="serviceMaster.sectorCode"
										data-ng-if="!serviceMaster.isEdit" validation="required"
										friendly-name="Service Code" name="sectorCode"
										typeahead-min-length='1'
										typeahead="r.sectorCode as r.sectorCode for r in serviceList | filter:$viewValue | limitTo:10"
										id="sectorCode" />
								</div>
							</div>
							
						<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">Controlled By<span
									style="color: red;">*</span> </label>
								<div class="col-md-5 inputGroupContainer">
									<selectivity list="branchList"
										property="serviceMaster.companyCode" id="companyCode"
										ng-model="serviceMaster.companyCode" name="companyCode"
										form-name="serviceMasterForm" validation="required"
										friendly-name="Controlled By"></selectivity>
								</div>
							</div> -->
							
							
							
								<div class="form-group">
								<label class="col-md-4 control-label">Vessel Operator </label>
								<div class="col-md-5 inputGroupContainer">
									<selectivity list="vesselOperList"
										property="serviceMaster.vesselOperator" id="vesselOperator"
										ng-model="serviceMaster.vesselOperator" name="vesselOperator"
										form-name="serviceMasterForm" 
										friendly-name="Vessel Operator"></selectivity>
								</div>
							</div>
							
						<div class="form-group">
								<label class="col-md-4 control-label">Average transit time for full voyage  (Days and Hrs)</label>
									<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										id="avgtrans" name="avgtrans"  
										ng-model="serviceMaster.avgtrans" 
										friendly-name="avgtrans"
										form-name="Vessel Operator" />
								</div>
							</div>
							
						</fieldset>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Service Name <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										data-ng-model="serviceMaster.sectorName" name="sectorName"
										validation="required" friendly-name="Service Name"
										id="sectorName" typeahead-min-length='1'
										typeahead="r.sectorName as r.sectorName for r in serviceList | filter:$viewValue | limitTo:10" />

								
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">Active</label>

								<div class="col-md-5">
									<div class="radio radio-inline">
										<label class="i-checks"> <input type="radio"
											class="radiobox style-0" checked="checked" name="isActive"
											data-ng_model="serviceMaster.isActive" value="Y" checked="checked">
											<i></i> Yes
										</label>
									</div>
									<div class="radio  radio-inline">
										<label class="i-checks"> <input type="radio"
											class="radiobox style-0" data-ng_model="serviceMaster.isActive"
											value="N" checked="checked" name="isActive"> <i></i>
											No
										</label>
									</div>
								</div>






							</div>
							
							
									<div class="form-group">
								<label class="col-md-4 control-label"> Sailing frequency (Days)</label>
									<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										id="sailingfreq" name="sailingfreq"  
										ng-model="serviceMaster.sailingfreq" 
										friendly-name="sailingfreq"
										form-name="Vessel Operator" />
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
							<button class="btn btn-success ng-scope" type="button"
								class="btn btn-success" data-ng-if="!serviceMaster.isEdit"
								data-ng-click="save(serviceMasterForm,serviceMaster)">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success ng-scope" type="button"
								class="btn btn-success" data-ng-if="serviceMaster.isEdit"
								data-ng-click="update(serviceMasterForm,serviceMaster)">
								<i class="fa fa-save"></i> Update
							</button>

							<!-- <button class="btn btn-info" type="button"
								data-ng-if="!serviceMaster.isEdit" data-ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-primary" type="button"
								data-ng-if="serviceMaster.isEdit" data-ng-click="reset1()">
								<i class="fa fa-undo"></i> Reset
							</button> -->

							<button class="btn btn-danger" data-ng-click="cancel()" type="button">
								<i class="fa fa-close"></i>Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>