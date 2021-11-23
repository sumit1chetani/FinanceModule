<style>
table.dataTable thead .sorting:after {
	content: "";
}

select {
	-webkit-appearance: none;
	padding: 0;
	text-indent: 8px;
	padding: 0 !important;
}

.input-group-addon {
	display: none !important;
}

.form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control
	{
	background-color: white !important;
	background:white !important;
	border: 0px !important;
}

.b-grey {
	border: 0px !important;
}
</style>

<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="jvSwapAcctForm" class="form-horizontal">
				<div class="row book-widget-row">

					<div class="col-sm-12">
						<fieldset ng-disabled="view">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Presentation Date</label>
									<div class="col-md-7 inputGroupContainer">
										<div class="input-group input-append date" id="presentDate">
				         					<input type="text" class="form-control " name="presentDate" id="txtpresentDate" ng-model="presentation.presentDate" placeholder='dd/mm/yyyy' readonly />
				         					<span class="input-group-addon add-on">
				         					 <span class="glyphicon glyphicon-calendar"></span>
				        					 </span>
			        					</div>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque No</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="chqNo" name="chqNo" placeholder=""
											ng-model="presentation.chqNo" readonly>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque Recived Date</label>
									<div class="col-md-7 inputGroupContainer">
										<div class="input-group input-append date" id="chqRcvdDate">
				         					<input type="text" class="form-control "  readonly name="chqRcvdDate" id="txtchqRcvdDate" ng-model="presentation.chqRcvdDate" />
				         					<span class="input-group-addon add-on">
				         					 <span class="glyphicon glyphicon-calendar"></span>
				        					 </span>
				        					</div>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset ng-disabled="view">

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer</label>
									<div class="col-md-7">
										<selectivity disabled = "true" list="customerList" property="presentation.customerCode" id="txtCustomerName" ></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque Date</label>
									<div class="col-md-7 inputGroupContainer">
										<div class="input-group input-append date" id="chqDate">
				         					<input type="text" class="form-control " readonly name="chqDate" id="txtchqDate" ng-model="presentation.chqDate" placeholder='dd/mm/yyyy' />
				         					<span class="input-group-addon add-on">
				         					 <span class="glyphicon glyphicon-calendar"></span>
				        					 </span>
				        					</div>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Drawn Bank</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="drwnBank" name="drwnBank" placeholder=""
											ng-model="presentation.drwnBank" readonly>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset ng-disabled="view">

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Company</label>
									<div class="col-md-7">
										<selectivity list="companyList" property="presentation.companyCode" id="companyName" object="comapny" disabled = true></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque Amount</label>
									<div class="col-md-7">
										<input class="form-control input-sm"
											name="chqAmnt" type="number" readonly
											data-ng-model="presentation.chqAmnt" ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" />
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Deposit Bank</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="depositBank" name="depositBank" placeholder=""
											ng-model="presentation.depositBank" readonly>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
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
