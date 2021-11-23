<style>
.level_class2 {
	background: #6ca5ee;
	color: #fff;
	font-size: 15px;
	font-weight: bold;
}

.level_class1, .level_class1:hover {
	background: #e58b90;
	color: #fff;
	font-size: 15px;
	font-weight: bold;
}

.level_class3 {
	background: #79c07c;
	color: #fff;
	font-size: 15px;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">

					<form class="form-horizontal" name="finalloadingSummaryList">


						<div class="row book-widget-row">
							<br />

							<div class="col-sm-12 col-md-6 ol-lg-4">
								<fieldset>

									<div class="form-group form-group-label-left">
										<label class="col-md-3 col-md-offset-1 control-label ">Voyage
										</label>
										<div class="col-md-7">
											<input type="text" ng-model="report.voyage"
												class="form-control">

										</div>
									</div>
 
									<div class="form-group form-group-label-left">

										<label class="col-md-3 col-md-offset-1 control-label ">Customer</label>
										<div class="col-md-7">
											<selectivity list="customerList" property="report.customer"
												id="mlo_short_name"></selectivity>
										</div>
									</div>

								</fieldset>
							</div>


							<div class="col-sm-12 col-md-6 ol-lg-4">
								<fieldset>



									<div class="form-group">
										<label for="inputPassword"
											class="control-label col-md-3 col-md-offset-1">From
											Date </label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="tb_fromDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="report.fromDate"
													name="fromDate" id="fromDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>

									<div class="form-group">
										<label for="inputPassword"
											class="control-label col-md-3 col-md-offset-1">To
											Date </label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="tb_toDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="report.toDate"
													name="toDate" id="toDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>




								</fieldset>
							</div>

						</div>

						<div class="excel"></div>

						<div class="form-actions">
							<div class="row">
								<div class="col-md-12 ">
								 
									<button class="btn btn-primary"
										ng-click="exportExcel(report)">
										<i class="fa fa-download"> </i> Export Excel
									</button>
								 
									<button class="btn btn-info" type="button"
										class="btn btn-success" ng-click="formreset()">
										<i class="fa fa-undo"> </i>Reset
									</button>
									
								</div>
							</div>
						</div>
					</form>

				</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel-default -->
		</div>
	</div>
</div>