<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="countryForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">

						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Country <span
									style="color: red;">*</span></label>
								<div class="col-md-3">

									<input type="text" class="form-control input-sm"
										id="code" name="code" maxlength="6"
										ng-model="country.code" validation="required"
										friendly-name=" port Code"
										form-name="countryForm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Country Name<span
									style="color: red;">*</span></label>
								<div class="col-md-3">

									<input type="text" class="form-control input-sm"
										id="name" name="name" maxlength="250"
										ng-model="country.name" validation="required"
										friendly-name="name" form-name="countryForm" />
								</div>
							</div>
							<div class="form-group">
								
								<label class="col-md-4 control-label"> Region Code<span
									style="color: red;">*</span></label>
									<div class="col-md-3">
									<selectivity list="regionList" id="city"
										name=city
										property="country.region"
										ng-model="country.region" validation="required"
										friendly-name="city"
										form-name="countryForm"></selectivity>
								</div>
							</div>
								
							
							

							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Description </label>
								<div class="col-md-3">
									<textarea ng-model="country.description"
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
											id="active" class="checkbox style-0" name="isActive"
											ng-model="country.isActive" /> <i></i>
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
								ng-click="validate(countryForm)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success"
								ng-click="validate(countryForm)"
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
