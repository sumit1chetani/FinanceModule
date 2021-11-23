<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="millageForm" 
				>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
						
								<div class="form-group">
									<label class="col-md-4 control-label">Trip</label>
									<div class="col-md-5 inputGroupContainer">

										<selectivity list="tripTypeList" id="tripId"
										name="tripId"
										property="millage.tripId"
										ng-model="millage.tripId" validation="required"
										friendly-name="tripId" disabled = "true"
										form-name="millageForm"></selectivity>

									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">
										Trailer </label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											friendly-name="Trailer" form-name="millageForm"
											id="trailer" maxlength="10" validation="required"
											name="trailer" ng-model="millage.trailer" disabled>

									</div>
		          						
									</div>
									<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">
										From Location </label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											friendly-name="From Location" form-name="millageForm"
											id="fromLocation" disabled
											name="fromLocation" ng-model="millage.fromLocation" disabled>

									</div>
		          						
									</div>
									
									<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">
										No. of days</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											friendly-name="noofdays" form-name="millageForm"
											id="noofdays" maxlength="10" validation="required"
											name="noofdays" ng-model="millage.noofdays" disabled>

									</div>
		          						
									</div>
								</div>

						
					
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>

								<div class="form-group">
									
									<label class="col-md-4 control-label">Truck </label>
									<div class="col-md-5 inputGroupContainer">

										<input type="text" class="form-control input-sm"
											friendly-name="truckName" form-name="millageForm"
											id="truckName"  disabled
											name="truckName" ng-model="millage.truckName">

									</div>
								</div>

                               <div class="form-group">
									
									<label class="col-md-4 control-label">Driver </label>
									<div class="col-md-5 inputGroupContainer">

<!-- 										<input type="text" class="form-control input-sm" -->
<!-- 											friendly-name="driver" form-name="millageForm" -->
<!-- 											id="driver"  -->
<!-- 											name="driver" ng-model="millage.driver" disabled> -->
											
											
											<textarea ng-model="millage.driverName" name="driverName"
											friendly-name="driverName" form-name="millageForm"
											id="driver" maxlength="250"
											class="form-control input-sm" rows="3" style="resize: none;" disabled>
		          						</textarea>

									</div>
								</div>

									<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">
										To Location </label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											friendly-name="To Location" form-name="millageForm"
											id="toLocation" 
											name="toLocation" ng-model="millage.toLocation" disabled>

									</div>
		          						
									</div>
									<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">
										Mileage Amount(KSH)</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm"
											friendly-name="Milage Amount" form-name="millageForm"
											id="milageAmount" placeholder = "0" disabled
											name="milageAmount" ng-model="millage.milageAmount">

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

