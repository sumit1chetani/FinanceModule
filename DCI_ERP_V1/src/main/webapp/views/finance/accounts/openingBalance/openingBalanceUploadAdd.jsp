<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
					
					
					<div class="form-group col-sm-12 col-md-12 col-lg-12 ">
											<div class="row">
												<label class="col-md-5 control-label"> </label>
												<div class="col-md-5">
												
		        <br>												
					<!-- <button class="btn btn-success"  type="button"
								ng-click="fileUpload()">
								<i class="fa fa-upload"></i> Upload
					</button> -->
												</div>
											</div>
										</div>
		<br>
					
		<div class="panel-body">
			<form class="form-horizontal" name="openingBalanceForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
						
						<div class="form-group">
								<label class="col-md-6 control-label"> Organization<span
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
			        <label class="col-md-6 control-label">Financial Year</label>
			        <div class="col-md-5">
			           <selectivity list="
pmtTypeList" id="finYear" name="finYear" 
				        property="openingBalance.finYear" ng-model="openingBalance.finYear" 
				         friendly-name="finYear" form-name = "cashBankcomPaymentForm" object="acctList"></selectivity>
			        </div>
			          
</div>
<div class="form-group">
								<label class="col-md-6 control-label"> Ledger<span
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
								<label class="col-md-6 control-label"> Invoice No 
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" 
										ng-model="openingBalance.invoiceNo" name="Invoice No"
										form-name="openingBalanceForm"
										friendly-name="Invoice No">
								</div>
							</div> -->

							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> Invoice Date
								</label>
								<div class="col-md-5">
							<a class="dropdown-toggle" id="to_date" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="Invoice Date"
																		data-valid-method="submit" data-message-id="Invoice Date"
																		data-ng-model="openingBalance.invoiceDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="openingBalance.invoiceDate"
																	data-on-set-time="openingBalance.invoiceDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#to_date',startView:'day', minView:'day'}" />
															</ul> 
								</div>
							</div> -->
							
							
							
							<!-- <div class="form-group ">
								<label class="col-md-6 control-label">Invoice Date <span
									style="color: red">*</span></label>
								<div class="col-md-5 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="openingBalance.invoiceDate"
										id="to_date" name="Invoice Date"
										data-ng-change="checkDatesCL(openingBalance.invoiceDate)"
										friendly-name="Valid From" validation="required" />
								</div>
								</div> -->
							
							
							
							
							
							
							
							
							
							<!-- <div class="form-group">
								<label class="col-md-6 control-label"> Currency<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" maxlength=10
										 form-name="openingBalanceForm" validation="required"
										friendly-name="Currency" ng-model="openingBalance.currency"
										name="Exchange Rate" />
								

								</div>
							</div> -->

							<div class="form-group">
								<label class="col-md-6 control-label">Amount<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="number" class="form-control input-sm"
										 form-name="openingBalanceForm" validation="required"
										friendly-name=" Amount" ng-model="openingBalance.bcAmount"
										name="Branch name" />

								</div>
							</div>
						<!-- 	<div class="form-group">
								<label class="col-md-6 control-label">TC Amount<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="number" class="form-control input-sm" 
										 form-name="openingBalanceForm" validation="required"
										friendly-name="TC Amount" ng-model="openingBalance.tcAmount"
										name="TC Amount" />
								</div>
							</div> -->

							
				
					
							<div class="form-group" >
								<label class="col-md-6 control-label">Balance</label>
								<div class="radio radio-inline">
									<label class="i-checks" style="line-height: 35px;"> <input type="radio" class=""
									form-name="openingBalanceForm"	 validation="required" name="sundryStatus" value="C" checked ng-model="openingBalance.sundryStatus">
										<i></i> Credit
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio" class=""
											form-name="openingBalanceForm"	 validation="required"  name="sundryStatus" value="D" checked ng-model="openingBalanceForm.sundryStatus">
										<i></i> Debit
									</label>
								</div>
							</div>
				 <div class="form-group"  ng-if="openingBalance.accountHead=='10050016' || openingBalance.accountHead=='20090001'">
								<label class="col-md-6 control-label" ng-if="openingBalance.accountHead=='10050016' || openingBalance.accountHead=='20090001'"> Customer/Vendor
								</label>
								<div class="col-md-5"  ng-if="openingBalance.accountHead=='10050016' || openingBalance.accountHead=='20090001'">
									<selectivity list="customerList" 
										property="openingBalance.customer" id="customer"
										ng-model="openingBalance.customer" name="customer"
										form-name="openingBalanceForm" 
										friendly-name="Customer"></selectivity>
								</div>
							</div>
							
							
							
							
							
							
							
						
							
							<!-- <div class="form-group">
								<label class="col-md-6 control-label">Exchange Rate<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="number" class="form-control input-sm" maxlength=10
										 form-name="openingBalanceForm" validation="required"
										friendly-name="Exchange Rate" ng-model="openingBalance.exchangeRate"
										name="Exchange Rate" />
								</div>
							</div> -->
							
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
					<!-- <div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
						<div class="form-group">
								<label class="col-md-4 control-label"> Customer<span
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
								<label class="col-md-4 control-label"> Company<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="companyList" 
										property="openingBalance.companyId" id="Company"
										ng-model="openingBalance.companyId" name="Company"
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
							<div class="form-group">
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
							</div>
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
					</div> -->
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

<a id="sampleDownload" style="display: none"
										href="/tempdoc/SampleOpeningBalance.xlsx" download="SampleOpeningBalance.xlsx"></a>

<script type="text/ng-template" id="fileGenModal">
<div class="model-header">File Upload </div>
		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-12">
					<input type="file" class="form-control btn-primary" name="excelfile"
            		onchange="angular.element(this).scope().uploadContainerExcel(this)" accept=".xls,.xlsx" />
            		
				</div>
			</div> 
		</div>
		<div class="model-footer" style="padding-left:9%;padding-top:8%">
			<button class="btn btn-success" type="button" ng-click="uploadContainer()">OK</button>
			<button class="btn btn-danger" ng-click="closeUpload()">Cancel</button>
			<button class="btn btn-info" type="button"  ng-click="downloadFile()">Download Sample</button>
		</div>
</script>