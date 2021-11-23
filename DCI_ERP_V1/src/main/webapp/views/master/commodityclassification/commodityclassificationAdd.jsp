<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="commodityclassificationForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
						
<!-- 	<div class="form-group">
									<label class="col-md-4 control-label">Classification Code <span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">


										<input type="text" class="form-control input-sm"
											id="classificationCode"  validation="required"
											friendly-name="Classification Code" form-name="commodityclassificationForm"
											name="classificationCode" ng-model="commodityclassification.classificationCode">

									</div>
								</div>	 -->	
									<div class="form-group">
								<label class="col-md-4 control-label">Classification Code<span
									style="color: red;">*</span></label>
								<div class="col-md-3" ng-if="!isEdit">

									<input type="text" class="form-control input-sm"  
										id="classificationCode" name="classificationCode" maxlength="10"
										ng-model="commodityclassification.classificationCode" validation="required"
										friendly-name=" Code"
										form-name="commodityclassificationForm" />
								</div>
								<div class="col-md-3" ng-if="isEdit">

									<input type="text" class="form-control input-sm"  
										id="classificationCode" name="classificationCode" maxlength="10"
										ng-model="commodityclassification.classificationCode" validation="required"
										friendly-name=" Code"
										form-name="commodityclassificationForm" disabled/>
								</div>
							</div>
								
							<div class="form-group">
									<label class="col-md-4 control-label">Description <span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">


										<textarea type="text" class="form-control input-sm"
											id="description"  validation="required"
											friendly-name="Description" form-name="commodityclassificationForm"
											name="description" ng-model="commodityclassification.description">
</textarea>
									</div>
								</div>
	</fieldset>
	
						</div>
					</div>

				</div>
				<!-- /row -->
				<br>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit"
								ng-click="save(commodityclassificationForm,commodityclassification)">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" ng-if="isEdit" type="submit"
								ng-click="update(commodityclassificationForm,commodityclassification)">
								<i class="fa fa-save"></i> Update
							</button>
						<button class="btn btn-info" type="button" data-ng-click="reset()"">
								<i class="fa fa-undo"></i> Reset
							</button>

<!-- 							<button class="btn btn-info" ng-click="reset1()" ng-if="isEdit"> -->
<!-- 								<i class="fa fa-reply"></i> Reset -->
<!-- 							</button> -->

							<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel</button>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

