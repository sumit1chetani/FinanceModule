<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="trucktrailerForm" novalidate
				method="POST">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">


						<fieldset>							
							<div class="form-group">
								<label class="col-md-4 control-label">Truck  :</label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{trucktrailermodel.truckName}}</label>								
							</div>
							<!-- 	<div class="form-group">
								<label class="col-md-4 control-label">Truck Plate No :</label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{truckdrivermodel.trucklicenseNo}}</label>								
							</div> -->
							<div class="form-group">
								<label class="col-md-4 control-label">Trailer :</label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{trucktrailermodel.trailerName}}</label>								
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">From Date :</label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{trucktrailermodel.fromDate}}</label>								
							</div>						
							
							<div class="form-group">
								<label class="col-md-4 control-label">To Date :</label> <label
									class="col-md-5 control-label" 
									style="text-align: left">{{trucktrailermodel.toDate}}</label>								
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

