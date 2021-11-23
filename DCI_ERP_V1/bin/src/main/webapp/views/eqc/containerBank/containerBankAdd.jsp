<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="containerBankForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group">
									<label class="col-md-4 control-label">Container Type<span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">
										    
										    <selectivity list="conTypeList" ng-model="containerBankobj.cntrType"
										    friendly-name="cntrType"  validation="required"
											property="containerBankobj.cntrType" id="cntrType" name="cntrType" 
											form-name="containerBankForm"></selectivity>

									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">Container Number<span
										style="color: red;">*</span></label>
									<div class="col-md-5">
										
		          						<input type="text" class="form-control input-sm"
											friendly-name="containerNo" form-name="containerBankForm" ng-disabled="isEdit"
											id="containerNo" maxlength="11" validation="required" data-ng-blur="validateContainer(containerBankobj.containerNo)"
											name="containerNo" ng-model="containerBankobj.containerNo">
		          						
									</div>
								</div>
								
								
								<div class="form-group">
									
									<label class="col-md-4 control-label">Tare Weight<span
										style="color: red;"></span></label>
									<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="tareweight" form-name="containerBankForm"
											id="tareweight" maxlength="20" validation="numeric"
											name="tareweight" ng-model="containerBankobj.tareweight">

									</div>
								</div>
								
								<div class="form-group">
									
									<label class="col-md-4 control-label">Gross Weight<span
										style="color: red;"></span></label>
									<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="grossweight" form-name="containerBankForm"
											id="grossweight" maxlength="20" validation="numeric"
											name="grossweight" ng-model="containerBankobj.grossweight">

									</div>
								</div>

							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>

								<div class="form-group">
									
									<label class="col-md-4 control-label">Pay Load<span
										style="color: red;"></span></label>
									<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="payLoad" form-name="containerBankForm"
											id="payLoad" maxlength="20" validation="numeric"
											name="payLoad" ng-model="containerBankobj.payLoad">

									</div>
								</div>
								
								<div class="form-group">
									
									<label class="col-md-4 control-label">Service<span
										style="color: red;"></span></label>
									<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="service" form-name="containerBankForm"
											id="service" maxlength="20" 
											name="service" ng-model="containerBankobj.service">

									</div>
								</div>
								
									<div class="form-group">
									<label class="col-md-4 control-label">Port<span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">

											<div class="col-md-7" >
										<selectivity list="portList1" ng-model="containerBankobj.port"
										    friendly-name="port"
											property="containerBankobj.port" id="port" name="port" validation="required"
											form-name="containerBankForm"></selectivity>
									</div>

									</div>
								</div>


                               <div class="form-group">
									
									<label class="col-md-4 control-label">Is Soc</label>
									<div class="col-md-5 inputGroupContainer">

										<div class="checkbox">
										<label> <input type="checkbox"  
											class="checkbox style-0" ng-model="containerBankobj.soc"
											name="soc"> <span></span>
										</label>
									</div>

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
								ng-click="save(containerBankForm,containerBankobj)">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" ng-if="isEdit" type="submit"
								ng-click="update(containerBankForm,containerBankobj)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="reset" ng-if="!isEdit" ng-click="reset()">
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

