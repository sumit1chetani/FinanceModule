<style type="text/css">
.textareath {
	resize: vertical;
	max-height: 100px;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 40px !important;
	margin: 2 auto !important;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
	</div>
	<div class="panel-body">
		<form class="form-horizontal" method="POST"
			name="jobOrderForm" novalidate>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<fieldset>
						
						<div class="form-group">
							<label class="control-label col-md-4">You Want to proceed . <span
								style="color: red;"></span>

							</label>
							
						</div>
 

					</fieldset>
				</div>
				 
			</div>

			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						<button class="btn btn-success"
							ng-click=allowSaveJob(joborder)
							type="button">
							<i class="fa fa-save"></i> Yes
						</button>

						<button class="btn btn-danger" type="reset"
											class="btn btn-success" ng-click="close()">
											<i class="fa fa-close"></i> No
										</button>
					</div>
				</div>
			</div>
		</form>

	</div>
</div>

