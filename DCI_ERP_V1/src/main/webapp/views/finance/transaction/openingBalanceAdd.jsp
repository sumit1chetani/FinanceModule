<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="openingBalanceForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-6 control-label"> Invoice No <!-- <span
									style="color: red;">*</span> -->
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" 
										ng-model="openingBalance.invoiceNo" name="Invoice No"
										 form-name="openingBalanceForm"
										friendly-name="Invoice No">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 control-label"> Invoice Date<!-- <span
									style="color: red;">*</span> -->
								</label>
								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="openingBalance.invoiceDate"
											name="invoiceDate" id="invoiceDate" form-name="openingBalanceForm"
											friendly-name="Invoice Date" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 control-label">BC Amount<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="number" class="form-control input-sm"
										 form-name="openingBalanceForm" validation="required"
										friendly-name="BC Amount" ng-model="openingBalance.bcAmount"
										name="Branch name" />

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">TC Amount<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="number" class="form-control input-sm" 
										 form-name="openingBalanceForm" validation="required"
										friendly-name="TC Amount" ng-model="openingBalance.tcAmount"
										name="TC Amount" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 control-label"> Currency<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="currencyList"
										property="openingBalance.currency" id="Currency"
										ng-model="openingBalance.currency" name="Currency"
										form-name="openingBalanceForm" validation="required"
										friendly-name="Currency"></selectivity>

								</div>
							</div>
				
							<div class="form-group">
								<label class="col-md-6 control-label">Exchange Rate<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="number" class="form-control input-sm" maxlength=10
										 form-name="openingBalanceForm" validation="required"
										friendly-name="Exchange Rate" ng-model="openingBalance.exchangeRate"
										name="Exchange Rate" />
								</div>
							</div>
							
							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> Mlo Code<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										 form-name="openingBalanceForm" validation="required"
										friendly-name="Mlo Code" ng-model="openingBalance.mloCode"
										 name="MloCode" />
								</div>
							</div>
							 -->

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
						<div class="form-group">
								<label class="col-md-4 control-label"> Customer/Vendor<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="customerList" 
										property="openingBalance.customer" id="customer"
										ng-model="openingBalance.customer" name="customer"
										form-name="openingBalanceForm" validation="required"
										friendly-name="Customer"></selectivity>
								</div>
							</div>
                           <div class="form-group">
								<label class="col-md-4 control-label"> Organization<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="companyList" 
										property="openingBalance.companyId" id="Company"
										ng-model="openingBalance.companyId" name="Organization"
										form-name="openingBalanceForm" validation="required"
										friendly-name="Company"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Account Head<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="cbpdtlAcctHeadList" 
										property="openingBalance.accountHead" id="accountHead"
										ng-model="openingBalance.accountHead" name="accountHead"
										form-name="openingBalanceForm" validation="required"
										friendly-name="Company"></selectivity>
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Sub Account Code<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<selectivity list="subAccountCodeList" disabled="isEdit"
										property="openingBalance.subAccount" id="subAccount"
										ng-model="openingBalance.subAccount" name="subAccount"
										form-name="openingBalanceForm" 
										friendly-name="Company"></selectivity>
								</div>
							</div> -->
							<div class="form-group" >
								<label class="col-md-4 control-label">Sundry Status<span
									style="color: red;">*</span></label>
								<div class="radio radio-inline">
									<label class="i-checks" style="line-height: 35px;"> <input type="radio" class=""
									form-name="openingBalanceForm"	 validation="required" name="sundryStatus" value="C" ng-model="openingBalance.sundryStatus">
										<i></i> Credit
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
											form-name="openingBalanceForm"	 validation="required"  name="sundryStatus" value="D" ng-model="openingBalanceForm.sundryStatus">
										<i></i> Debit
									</label>
								</div>
							</div>

							
						</fieldset>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!isEdit" class="btn btn-success"
								ng-click="save(openingBalanceForm,openingBalanceForm)">
								<i class="fa fa-save"></i> Save

							</button>
							<button class="btn btn-success" type="button"
								ng-if="isEdit" class="btn btn-success"
								ng-click="update(openingBalanceForm,openingBalanceForm)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset(openingBalanceForm)">
								<i class="fa fa-undo"></i> Reset
							</button>
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

