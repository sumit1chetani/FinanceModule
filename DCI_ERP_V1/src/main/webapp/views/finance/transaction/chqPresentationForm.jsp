<style>
.custom-col-md-6{padding-right: 0px;padding-left: 0px;}
.custom-col-md-3{padding-right:25px;}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="jvSwapAcctForm" class="form-horizontal">
				<div class="row book-widget-row">

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Presentation Date</label>
									
<!-- 										<div class="input-group input-append date" id="presentDate"> -->
<!-- 				         					<input type="text" class="form-control " name="presentDate" id="txtpresentDate" ng-model="presentation.presentDate" placeholder='dd/mm/yyyy' /> -->
<!-- 				         					<span class="input-group-addon add-on"> -->
<!-- 				         					 <span class="glyphicon glyphicon-calendar"></span> -->
<!-- 				        					 </span> -->
<!-- 			        					</div> -->
<ng-bs3-datepicker data-ng-model="presentation.presentDate" id="presentDate1" name="presentDate" form-name="jvSwapAcctForm"
       data-ng-change="checkDatesCL(presentation.presentDate)" 
        friendly-name="Present Date" validation="required"/>
									
								</div>

							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque No</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="chqNo" name="chqNo" placeholder=""
											ng-model="presentation.chqNo">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque Recived Date</label>
									<div class="col-md-7 inputGroupContainer">
										<div class="input-group input-append date" id="chqRcvdDate">
				         					<input type="text" class="form-control " name="chqRcvdDate" id="txtchqRcvdDate" ng-model="presentation.chqRcvdDate" placeholder='dd/mm/yyyy' />
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
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer</label>
									<div class="col-md-7">
										<selectivity list="payerList" property="presentation.customerCode" id="txtCustomerName" ></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque Date</label>
									<div class="col-md-7 inputGroupContainer">
										<div class="input-group input-append date" id="chqDate">
				         					<input type="text" class="form-control " name="chqDate" id="txtchqDate" ng-model="presentation.chqDate" placeholder='dd/mm/yyyy' />
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
											ng-model="presentation.drwnBank">
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Company</label>
									<div class="col-md-7">
										<selectivity ng-if="isEdit" disabled="isEdit" list="companyList" property="presentation.companyCode" id="companyName" object="comapny"></selectivity>
									</div>
									<div class="col-md-7">
										<selectivity ng-if="!isEdit" list="companyList" property="presentation.companyCode" id="companyName" object="comapny"></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Cheque Amount</label>
									<div class="col-md-7">
										<input class="form-control input-sm"
											name="chqAmnt" type="number"
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
											ng-model="presentation.depositBank">
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
