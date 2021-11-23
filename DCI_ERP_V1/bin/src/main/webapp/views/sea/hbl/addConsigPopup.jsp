<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 80% !important;
	bottom: 100px !important;
	margin: 0 auto !important;
}
@media screen and (min-width: 676px) {
        .modal-dialog {
          max-width: 1000px; /* New width for default modal */
        }
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
						<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Customer
								Code <span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.consigCode" maxlength=6
									data-ng-model="servicePartner.consigCode"
									name="ServicePartnerCode" validation="required"
									friendly-name="ServicePartnerCode" />

							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Customer
								Name <span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.consigName" maxlength=250
									data-ng-model="servicePartner.consigName"
									name="ServicePartnerName" validation="required"
									friendly-name="ServicePartnerName" />
							</div>
						</div>
					</div>
						<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">City<span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="cityList" property="servicePartner.cty"
									data-ng-model="servicePartner.cty" name="Cty"
									validation="required" form-name="servicePartnerForm"
									friendly-name="Cty"> </selectivity>

							</div>
						</div>
					</div>

					</fieldset>
				</div>
				 
			</div>

			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						<button class="btn btn-success"
							ng-click=allowSaveConsig(servicePartner)
							type="button">
							<i class="fa fa-save"></i> Save
						</button>

						<button class="btn btn-danger" type="reset"
											class="btn btn-success" ng-click="close()">
											<i class="fa fa-close"></i> Cancel
										</button>
					</div>
				</div>
			</div>
		</form>

	</div>
</div>

