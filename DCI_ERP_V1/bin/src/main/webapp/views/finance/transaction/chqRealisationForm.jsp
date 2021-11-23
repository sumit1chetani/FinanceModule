<style>
.custom-col-md-6{padding-right: 0px;padding-left: 0px;}
.custom-col-md-3{padding-right:25px;}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="chqRealisation" class="form-horizontal">
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
							<div class="form-group">
									<label class="col-md-5 control-label">Realised Date</label>
									<div class="col-md-7">
<ng-bs3-datepicker data-ng-model="realisation.realisedDate" id="realisedDate1" name="realisedDate" form-name="chqRealisation"
       data-ng-change="checkDatesCL(realisation.realisedDate)" 
        friendly-name="Realised Date" validation="required"/>
									</div>
								</div>

							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque No</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="chqNoId" name="chqNo" placeholder=""
											ng-model="realisation.chqNo">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque Status</label>
									<div class="col-md-7">
										<selectivity list="statusList" property="realisation.status" id="statusId" object="customer"></selectivity>
									</div>
								</div>
							</div>

						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Presentation</label>
									<div class="col-md-7">
										<selectivity list="presentationList" property="realisation.prCode" id="presentId" object="presentation" ng-if="!isEdit"></selectivity>
										<input type="text" class="form-control input-sm" id="presentId" name="presentCode" ng-model="realisation.prCode" ng-if="isEdit" readonly />
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer</label>
									<div class="col-md-7">
											<input type="text" class="form-control input-sm"
											id="customerId" name="customerName" placeholder=""
											ng-model="realisation.customerName">
									</div>
								</div>
							</div>

						</fieldset>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit"
								ng-click="onSubmit()">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button" ng-if="isEdit"
								ng-click="onSubmit()">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>
	</div>
</div>
