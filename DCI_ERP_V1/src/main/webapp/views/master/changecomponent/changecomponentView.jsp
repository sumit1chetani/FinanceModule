<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="chargeComponentForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">

						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Charge Code</label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm"
										id="changeCode" name="changeCode" maxlength="20"
										ng-model="chargeComponent.chargeCode" validation="required"
										friendly-name="Account Head Name"
										form-name="chargeComponentForm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Charge Name</label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm"
										id="chargeName" name="chargeName" maxlength="100"
										ng-model="chargeComponent.chargeName" validation="required"
										friendly-name="chargeName" form-name="chargeComponentForm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Charge Type</label> <label
									class="col-md-4 control-label text-left"></label>
								<div class="col-md-5 inputGroupContainer">
									<selectivity list="changetypeList" id="chargeType"
										name="changetype"
										property="chargeComponent.chargeType"
										ng-model="chargeComponent.chargeType" validation="required"
										friendly-name="chargeType"
										form-name="chargeComponentForm"></selectivity>
								</div>
							</div>	

							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Description </label>
								<div class="col-md-5">
									<textarea ng-model="chargeComponent.chargeComponentdescription"
										name="chargeComponentdescription" maxlength="250"
										class="custom-scroll width_100 resize-none" rows="3">
		          						</textarea>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Active </label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											id="active" class="checkbox style-0" name="isActive"
											ng-model="chargeComponent.isActive" /> <i></i>
										</label>
									</div>
								</div>
							</div>
						</fieldset>

					</div>

				</div>
				<!-- /row -->
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



<%-- <div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="chargeComponentForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">

						<fieldset>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Charge Code<span
									style="color: red;">*</span></label>
								<div class="col-md-5">

									<input type="text" class="form-control input-sm"
										id="changeCode" name="changeCode"
										ng-model="chargeComponent.changeCode" validation="required"
										friendly-name="Account Head Name"
										form-name="chargeComponentForm" />
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Charge Code<span
									style="color: red;">*</span></label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{chargeComponent.chargeCode}}</label>								
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Charge Name<span
									style="color: red;">*</span></label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{chargeComponent.chargeName}}</label>								
							</div>	
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Charge Type<span
									style="color: red;">*</span></label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{chargeComponent.chargeType}}</label>								
							</div>	 -->						
							 <div class="form-group">
								<label class="col-md-4 control-label">Charge Type<span
									style="color: red;">*</span></label> <label
									class="col-md-4 control-label text-left"></label>
								<div class="col-md-5 inputGroupContainer">
									<selectivity list="chargeTypeList" id="chargeType"
										name="chargeTypeid"
										property="chargeComponent.chargeTypeid"
										ng-model="chargeComponent.chargeTypeid" validation="required"
										friendly-name="chargeType"
										form-name="chargeComponentForm"  disabled="true"></selectivity>
								</div>
							</div> 						

							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Description </label>
								<div class="col-md-5">
									<textarea ng-model="chargeComponent.chargeComponentdescription"
										name="chargeComponentdescription"
										class="custom-scroll width_100 resize-none" rows="3"  disabled="true">
		          						</textarea>
								</div>
							</div>

							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Active </label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											id="active" class="checkbox style-0" name="active"
											ng-model="chargeComponent.active" /> <i></i>
										</label>
									</div>
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Active</label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{chargeComponent.isActive}}</label>								
							</div>	
						</fieldset>

					</div>

				</div>
				<!-- /row -->
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
 --%>
