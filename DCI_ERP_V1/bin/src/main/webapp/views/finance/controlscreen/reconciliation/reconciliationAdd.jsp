<style type="text/css">
.selectivity-placeholder {
	padding-left: 20px;
}

.selectivity-single-select-input {
	background: none !important;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body form-horizontal">
			<form name="spcaReportForm" method="post" class="form-horizontal"
				novalidate>
				<div class="row">
					<div class="col-sm-5">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label ">Account Head</label>
								<div class="col-md-7">
								<input type="text" class="form-control input-sm"  disabled
											ng-model="reconciliation.accountCode" placeholder='dd/mm/yyyy' /> 
									<!-- <selectivity list="vesselList" property="spcaReport.vessel"
										ng-model="spcaReport.vessel" id="vessel" name="vessel"
										object="vessel" form-name="spcaReportForm"
										validation="required" friendly-name="Vessel"></selectivity> -->
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-5 control-label ">Voyage</label>
								<div class="col-md-7">
								<input type="text" class="form-control input-sm" disabled
											ng-model="reconciliation.voyage"  /> 
									<!-- <selectivity list="voyageList" property="spcaReport.voyageNo"
										ng-model="spcaReport.voyageNo" id="voyageNo" name="voyageNo"
										form-name="spcaReportForm" validation="required"
										friendly-name="Voyage"></selectivity> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Port</label>
								<div class="col-md-7 control-label">
									<input type="text" class="form-control input-sm" disabled
											ng-model="reconciliation.port" /> 
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Exchange Rate</label>
								<div class="col-md-7 control-label">
								<input type="text" class="form-control input-sm" disabled
											ng-model="reconciliation.daExchangeRate"/> 
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">TC Amount</label>
								<div class="col-md-7 control-label">
								<input type="text" class="form-control input-sm" disabled
											ng-model="reconciliation.daTCAmt" /> 
								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-5">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label ">BC Amount</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" disabled
											ng-model="reconciliation.daBCAmt"/> 
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-5 control-label ">Approved Exchange Rate</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" disabled
											ng-model="reconciliation.vpaExchangeRate"/> 
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Approved TC Amount</label>
								<div class="col-md-7 control-label">
								<input type="text" class="form-control input-sm" disabled
											ng-model="reconciliation.vpaTCAmt" /> 
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Approved BC Amount</label>
								<div class="col-md-7 control-label">
								<input type="text" class="form-control input-sm" disabled
											ng-model="reconciliation.vpaBCAmt"/> 
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Remarks</label>
								<div class="col-md-7 control-label">
									<input type="text" class="form-control input-sm"
										ng-model="reconciliation.remarks" name="remarks"
										form-name="spcaReportForm"
										friendly-name="Remarks">
								</div>
							</div>

						</fieldset>
					</div>
				</div>
				<div class="row form-actions">
					<div class="col-md-12 text-center">
						<button ng-model="add" class="btn btn-success" type="button"
							ng-if="arrEdit!=true" class="btn btn-success"
							ng-click="save();">
							<i class="fa fa-plus"></i> Save
						</button>
						<button ng-model="add" class="btn btn-success" type="button"
							ng-if="arrEdit==true" class="btn btn-success"
							ng-click="update(spcaReportForm);">
							<i class="fa fa-plus"></i> Update
						</button>
						<button class="btn btn-danger" type="reset"
							class="btn btn-success" ng-click="cancel()">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
