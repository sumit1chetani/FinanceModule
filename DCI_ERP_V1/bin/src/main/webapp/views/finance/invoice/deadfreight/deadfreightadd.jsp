<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal"
				ng-submit="save(deadfreight,deadfreightvalidation)">
				<div class="row">
					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<fieldset>
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Customer</label>
								<div class="col-md-7">
									<selectivity list="customerList"
										property="deadfreight.customerName" id="customerName">
								</div>
							</div>
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">DF
									Quotation No </label>
								<div class="col-md-7">
									<selectivity list="dfQuotationList"
										property="deadfreight.dfQuotationNo" id="dfQuotationNo">
								</div>
							</div>
						</fieldset>
					</div>


					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<fieldset>
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Vessel
								</label>
								<div class="col-md-7">
									<selectivity list="vesselList"
										property="deadfreight.vesselName" id="vesselName">
								</div>
							</div>
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Slot
									A/c </label>
								<div class="col-md-7">
									<selectivity list="slotList" property="deadfreight.slotName"
										id="slotName">
								</div>
							</div>
						</fieldset>
					</div>


					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<fieldset>
							<div class="form-group form-group-label-left">
								<label class="col-md-4 col-md-offset-1 control-label">Voyage
								</label>
								<div class="col-md-7">
									<selectivity list="voyageList"
										property="deadfreight.voyageName" id="voyageName">
								</div>
							</div>

						</fieldset>
					</div>

				</div>
			</form>
		</div>
	</div>
</div>
