<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="cityForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">

						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> City Code<span
									style="color: red;">*</span></label>
								<div class="col-md-3">

									<input type="text" class="form-control input-sm"
										id="code" name="code" maxlength="6"
										ng-model="city.code" validation="required"
										friendly-name=" city Code"
										form-name="cityForm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> City Name<span
									style="color: red;">*</span></label>
								<div class="col-md-3">

									<input type="text" class="form-control input-sm"
										id="name1" name="name1" maxlength="250"
										ng-model="city.name" validation="required"
										friendly-name="City Name" form-name="cityForm" />
								</div>
							</div>
							
								<div class="form-group">
								<label class="col-md-4 control-label"> Zip/Postal Code<span
									style="color: red;"></span></label>
								<div class="col-md-3">

									<input type="text" class="form-control input-sm"
										id="pin" name="pin" maxlength="6"
										ng-model="city.pin" 
										form-name="cityForm" />
								</div>
							</div>
							<div class="form-group">
								
								<label class="col-md-4 control-label"> State Code<span
									style="color: red;">*</span></label>
									<div class="col-md-3">
									<selectivity list="stateList" id="state"
										name=state
										property="city.state"
										ng-model="city.state" validation="required"
										friendly-name="State Code"
										form-name="cityForm"></selectivity>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-6 control-label"><spring:message
										code="label.country"></spring:message> <spring:message
										code="label.asterisk.symbol"></spring:message> </label>
								<div class="col-md-6 inputGroupContainer">
									<selectivity list="changetypeList"
										property="port.changetype" id="changetype"
										ng-model="port.changetype" name="changetype"
										form-name="cityForm" validation="required"
										friendly-name="Country"></selectivity>
								</div>
							</div> -->

							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Description </label>
								<div class="col-md-3">
									<textarea ng-model="city.description"
										name="description" maxlength="255"
										class="custom-scroll width_100 resize-none" rows="3">
		          						</textarea>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Active</label>
								<div class="col-md-3">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											id="isActive" class="checkbox style-0" name="isActive"
											ng-model="city.isActive" /> <i></i>
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
						<div class="col-md-11">
							<button class="btn btn-success" ng-if="edit" type="button"
								ng-click="validate(cityForm)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success"
								ng-click="validate(cityForm)"
								ng-if="!edit" type="button">
								<i class="fa fa-save"></i> Update
							</button>

							<button class="btn btn-info" ng-if="edit" type="reset"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
								<button class="btn btn-info" ng-if="!edit" type="reset"
								ng-click="reset()">
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
	</div>
</div>
