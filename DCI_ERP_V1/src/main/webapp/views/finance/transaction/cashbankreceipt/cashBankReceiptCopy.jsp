<style>
.view input, .view textarea, .view .input-group-addon, .view .selectivity-single-select
	{
	border: 0px !important;
	resize: none !important;
}

.view .selectivity-single-select {
	background: none !important;
}

.view .input-group-addon {
	display: none !important;
}

.view input, .view selectivity, .view textarea {
	background: none !important;
	pointer-events: none !important;
	cursor: none !important;
}
</style>
<div class="wrapper-md">

	<div class="panel panel-default panel-default-form"
		ng-class="{view : isView}">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<!-- <div class="col-sm-2" style="    margin-left: 87%;margin-top: -51px;position: absolute;">
			<a class="" style="font-size: 37px;" data-ng-click="tdsHelpVideo('TDS_Help_Video.mp4','TDS Help Video')">  
	 		<img alt="GST" src="/img/tdsVideo.png" height="50px;" width="50px" style="height: 35px;width: 35px;border-radius: 6px;
		 		margin-top: -8px;">		 	</a>
		 	<a class="" style="font-size: 37px;" data-ng-click="tdsHelpVideo('GST_Flow_Corrected.mp4','GST Flow Help Video')">  
		 		<img alt="GST" src="/img/gstVideo.png" height="50px;" width="50px" style="height: 35px;width: 35px;border-radius: 6px;
		 		margin-top: -8px;">
		 	</a>
		 	</div> -->
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" name="cashBankReceiptForm" role="form">
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset ng-disabled="isView">

								<div class="form-group" ng-if="isView">
									<label for="inputPassword" class="control-label col-md-5">Voucher
										No</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											name="Voucher No" id="txtVoucherNo"
											ng-model="objCBReceipt.voucherNo" placeholder='dd/mm/yyyy' />
									</div>
								</div>
								<!-- <div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Date <span style="color: red;">*</span></label>
									<div class="col-md-7">
										<div class="input-group input-append date" id="receipt_date">
											<input type="text" class="form-control input-sm"
												name="ReceiptDate" id="txtReceiptDate"
												ng-model="objCBReceipt.cbReceiptDate"
												placeholder='dd/mm/yyyy'  friendly-name="Receipt Date" validation="required" ng-disabled="disabled"/> <span
												class="input-group-addon add-on"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div> -->
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Date
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<!-- 										<div class="input-group  date" id="receipt_date"> -->
										<!-- 											<input type="text" class="form-control input-sm" -->
										<!-- 												name="ReceiptDate" id="txtReceiptDate" -->
										<!-- 												ng-model="objCBReceipt.cbReceiptDate" -->
										<!-- 												placeholder='dd/mm/yyyy'  friendly-name="Receipt Date" validation="required" /> <span -->
										<!-- 												class="input-group-addon add-on"> <span -->
										<!-- 												class="glyphicon glyphicon-calendar"></span> -->
										<!-- 											</span> -->
										<!-- 										</div> -->
										<ng-bs3-datepicker data-ng-model="objCBReceipt.cbReceiptDate"
											id="cbReceiptDate" name="cbReceiptDate"
											form-name="cashBankReceiptForm"
											data-ng-change="checkDatesCL(objCBReceipt.cbReceiptDate)"
											friendly-name="CbReceipt Date" validation="required" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label">Company <span
										style="color: red;"> *</span></label>
									<div class="col-md-7">
										<selectivity ng-if="edit" disabled="edit" list="companyList"
											property="objCBReceipt.companyCode" name="companyCode"
											ng-model="objCBReceipt.companyCode" validation="required"
											friendly-name="Company" form-name="cashBankReceiptForm"></selectivity>
									</div>
									<div class="col-md-7">
										<selectivity ng-if="!edit" list="companyList"
											property="objCBReceipt.companyCode" name="companyCode"
											ng-model="objCBReceipt.companyCode" validation="required"
											friendly-name="Company" form-name="cashBankReceiptForm"></selectivity>
									</div>
								</div>
								<!-- 	 <div class="form-group">
									<label class="col-md-5 control-label">Type Of Payment <span style="color: red;">*</span></label>
									<div class="col-md-7 inputGroupContainer">
										<selectivity list="typeList" property="objCBReceipt.paymentMode" id="pmt_id" name="pmt_id"
										ng-model="objCBReceipt.paymentMode" validation="required"
										friendly-name="Payment Type" form-name="cashBankReceiptForm"></selectivity>
									</div>
								</div> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Bank Account<span
										style="color: red;">*</span></label>
									<div class="col-md-7 inputGroupContainer">
										<selectivity list="bankList" property="objCBReceipt.bankAcc"
											id="bankAcc_id" name="bankAcc_id"
											ng-model="objCBReceipt.bankAcc" validation="required"
											friendly-name="Bank Account" form-name="cashBankReceiptForm"></selectivity>
									</div>
								</div>









								<div class="form-group" align="center">
									<label class="col-md-5 control-label">File Upload </label>
									<div class="col-md-7">
										<div class="input-group">
											<input type="file" class="form-control btn-primary"
												class="form-control input-sm" name="excelfile"
												onchange="angular.element(this).scope().uploadFile(this)" />

											<span class="input-group-btn ">
												<button class="btn btn-info input-sm" type="button"
													ng-click="adduploadfiles()" data-toggle="tooltip"
													title="Add File">Upload</button>
											</span>
										</div>
									</div>
								</div>




								<div class=""
									ng-repeat="(tIndex, filelist) in objCBReceipt.files">
									<a id="tbnewExport{{tIndex}}" style="display: none"
										href="{{filelist.filepath}}/{{filelist.filename}}"
										download="{{filelist.filename}}"></a>
									<div ng-if="filelist.objCBReceipt!=''">
										{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)"
											style="color: green">{{filelist.filename}}</a>
									</div>

									<div ng-if="filelist.objCBReceipt==''">
										{{tIndex+1}} ) <a style="color: green">{{filelist.filename}}</a>
										<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)"
											data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>
										</button>
									</div>

								</div>













								<!-- <div class="form-group" ng-if="!show">
									<label class="col-md-5 control-label">Cash A/c <span style="color: red;">*</span></label>
									<div class="col-md-7 inputGroupContainer">
										<selectivity list="cashList" property="objCBReceipt.cashAcc" id="cashAcc_id" name="cashAcc_id"
										ng-model="objCBReceipt.cashAcc" validation="required"
										friendly-name="Cash Account" form-name="cashBankReceiptForm"></selectivity>
									</div>
								</div>  -->
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset ng-disabled="isView">
								<div class="form-group">
									<label class="col-md-5 control-label"> Currency<span
										style="color: red;"> *</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											name="Currency" ng-model="objCBReceipt.currency"
											validation="required" friendly-name="Currency" readonly />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label"> Exchange Rate <span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											name="Exchange Rate"
											ng-blur="calculateExchageRateHdr(objCBReceipt.exchangeRate)"
											ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
											ng-model="objCBReceipt.exchangeRate" validation="required"
											friendly-name="Exchange Rate">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-5 control-label"> TC Amount <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="objCBReceipt.tcAmountHdr" name="Amount USD"
											ng-keyup="tcToBcHdrAmtCalculation(objCBReceipt.tcAmountHdr)"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
											step="0.01" friendly-name="TC Amount" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-5 control-label"> Received From <span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<!-- <selectivity list="customerList" property="objCBReceipt.receivedFrom" id="receivedFrom" name="receivedFrom"
										ng-model="objCBReceipt.receivedFrom" validation="required"
										friendly-name="Received From" form-name="cashBankReceiptForm"></selectivity> -->
										<input type="text" class="form-control input-sm"
											name="Received From" ng-model="objCBReceipt.receivedFrom"
											validation="required" friendly-name="Received From">
									</div>
								</div>

								<!-- <div class="form-group">
									<label class="col-md-5 control-label">PDC BR</label>
									<div class="col-md-7">
										<selectivity list="rowCollection" property="receiptCode"
											id="receiptNo"></selectivity>

									</div>
								</div> -->
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset ng-disabled="isView">
								<div class="form-group" ng-show="show">
									<label class="col-md-5 control-label"> Cheque No</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											name="Cheque No" ng-model="objCBReceipt.chequeNO" />
									</div>
								</div>
								<div class="form-group" ng-show="show">
									<label for="inputPassword" class="control-label col-md-5">Cheque
										Date</label>
									<div class="col-md-7">
										<div class="input-group input-append date" id="cheque_date">
											<input type="text" class="form-control input-sm"
												name="Cheque Date" id="txtChequeDate"
												ng-model="objCBReceipt.chequeDate" placeholder='dd/mm/yyyy' />
											<span class="input-group-addon add-on"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label"> BC
										Amount<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right"
											ng-model="objCBReceipt.bcAmountHdr" name="bcAmountHdr"
											ng-blur="bcToTcHdrAmtCalculation(objCBReceipt.bcAmountHdr)"
											id="bcAmountHdr"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
											step="0.01" friendly-name="BC Amount">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Narration
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<div class="input-group">
											<textarea rows="2" cols="30" class="form-control"
												name="Narration" ng-model="objCBReceipt.narration"
												validation="required" friendly-name="Narration">
 									</textarea>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
						<!-- /col-sm-4 col-md-4 col-lg-4 -->
					</div>
					<!-- /col-sm-12 col-md-12 col-lg-12 -->
				</div>
				<!-- /book-widget-row -->
				<div class="table-responsive clear" ng-class="{view : isView}">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th ng-hide="hide" colspan=1 class="width_15 text-center">Sub
									Group <span style="color: red;">*</span>
								</th>
								<th colspan=1 class="width_15 text-center">Company <span
									style="color: red;">*</span></th>
								<th colspan=1 class="width_15 text-center">Account Name <span
									style="color: red;">*</span></th>
								<th colspan=1 class="width_10 text-center">Sub Account Code</th>
								<th colspan=1 class="width_15 text-center">Short Details <span
									style="color: red;">*</span></th>
								<th colspan=1 class="width_5 text-center">Currency<span
									style="color: red;">*</span></th>
								<th colspan=1 class="width_7 text-center">Ex-Rate<span
									style="color: red;">*</span></th>
								<th colspan=1 class="width_8 text-center">TC Amount<span
									style="color: red;">*</span></th>
								<th colspan=1 class="width_8 text-center">BC
									Amount<span style="color: red;">*</span>
								</th>
								<th colspan=1 class="width_1"></th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in objCBReceipt.cshBankDetail"
							ng-controller="tableCtrlCR">

							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select"><i></i></label></td>
								<td ng-hide="hide" class="">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="subgroupList" property="row.subgroupcode"
												id="subgroupName{{trIndex}}" ng-model="row.acctName"
												validation="required" name="subgroupName{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Sub Group Head)'}}"
												form-name="cashBankReceiptForm"></selectivity>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="companyList" property="row.companyCode"
												id="companyCode{{trIndex}}" ng-model="row.companyCode"
												validation="required" name="{{ 'Company' + $index }}"
												friendly-name="{{ 'Row' + $index + '(Company)'}}"
												form-name="cashBankReceiptForm"></selectivity>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="accountList" property="row.acctName"
												id="acctName{{trIndex}}" ng-model="row.acctName"
												validation="required" name="{{ 'accountHead' + $index }}"
												friendly-name="{{ 'Row' + $index + '(Account Head)'}}"
												form-name="cashBankReceiptForm"></selectivity>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12"
											ng-if="!row.isSubAccountCode && !income">

											<selectivity list="row.subAccountCodeList"
												property="row.subAccountCode"
												id="txtSubAccountCode{{trIndex}}"
												ng-model="row.subAccountCode"
												name="txtSubAccountCode{{trIndex}}"
												disabled="!row.isSubAccountCode"></selectivity>


										</div>

										<div class="col-xs-12" ng-if="row.isSubAccountCode && !income">

											<selectivity list="row.subAccountCodeList"
												property="row.subAccountCode"
												id="txtSubAccountCode{{trIndex}}"
												ng-model="row.subAccountCode" validation="required"
												name="txtSubAccountCode{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Sub Account Code)'}}"
												form-name="cashBankReceiptForm"></selectivity>


										</div>
										<div class="col-xs-12" ng-if="row.isSubAccountCode && income">

											<selectivity list="row.subAccountCodeList"
												property="row.subAccountCode"
												id="txtSubAccountCode{{trIndex}}"
												ng-model="row.subAccountCode"
												name="txtSubAccountCode{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Sub Account Code)'}}"
												form-name="cashBankReceiptForm"></selectivity>


										</div>
									</div>
								</td>

								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<div class="col-xs-9 pull-left">
												<input type="text" class="form-control input-sm"
													id="shortDetail{{trIndex}}" ng-model="row.shortDetail"
													validation="required" name="{{ 'shortDetail' + $index }}"
													friendly-name="{{ 'Row' + $index + '(Short Detail)'}}" />
											</div>
											<div class="col-xs-3 pull-left">
												<label class="line-height-30 cursor-pointer"
													ng-if="row.isTradeDebtors &&  !isView"
													data-ng-click="showReceiptInvoicePopup(trIndex,row,'cashbankReceipt')">
													<i class="fa fa-expand"></i>
												</label>
											</div>
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"
												id="currency{{trIndex}}" ng-model="row.currency" name="currency"
												friendly-name="{{ 'Row' + $index + '(Currency)'}}" validation="required" readonly> -->
											<div class="row">
												<div class="col-xs-12" ng-if="row.isCurrencyBlocked">
													<selectivity list="currencyList" property="row.currency"
														id="currency{{trIndex}}" object="currency"
														name="currency{{trIndex}}" validation="required"
														friendly-name="{{ 'Row' + $index + '(Currency)'}}"
														ng-model="row.currency" property="row.currency"
														form-name="cashBankReceiptForm"
														disabled="row.isCurrencyBlocked"></selectivity>
												</div>
												<div class="col-xs-12" ng-if="!row.isCurrencyBlocked">
													<selectivity list="currencyList" property="row.currency"
														id="currency{{trIndex}}" object="currency"
														name="currency{{trIndex}}" validation="required"
														friendly-name="{{ 'Row' + $index + '(Currency)'}}"
														ng-model="row.currency" property="row.currency"
														form-name="cashBankReceiptForm"></selectivity>
												</div>

											</div>
                                        <input type="hidden" class="form-control input-sm"
												id="invoice{{trIndex}}" ng-model="row.invoiceNo"
												name="invoice{{trIndex}}" readonly /> 
											
											
											<input type="hidden" class="form-control input-sm"
												id="txtFromCurrency{{trIndex}}" ng-model="row.fromCurrency"
												name="From Currency{{trIndex}}" readonly /> <input
												type="hidden" class="form-control input-sm"
												id="txtToCurrency{{trIndex}}" ng-model="row.toCurrency"
												name="To Currency{{trIndex}}" readonly />
										</div>
									</div>
								</td>
								<td>
									<div class="row" ng-if="row.isExDisable">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												id="exgRate{{trIndex}}" ng-model="row.exgRate"
												name="exgRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
												ng-blur="calculationExchangeRateOnDtlTable(row.exgRate,trIndex,row)"
												friendly-name="{{ 'Row' + $index + '(Exchange Rate)'}}"
												validation="required" >
										</div>
									</div>

									<div class="row" ng-if="!row.isExDisable">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												id="exgRate{{trIndex}}" ng-model="row.exgRate"
												name="exgRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
												ng-blur="calculationExchangeRateOnDtlTable(row.exgRate,trIndex,row)"
												friendly-name="{{ 'Row' + $index + '(Exchange Rate)'}}"
												validation="required">
										</div>
									</div>
								</td>
								<td>
									<div class="row" ng-if="row.isTCDisable">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												id="amountUsd{{trIndex}}" ng-model="row.tcamount"
												name="tcamount{{trIndex}}"
												ng-keyup="TCtoBCAmountCalculationForPartyAccountDetTbl(row.tcamount,trIndex,row)"
												friendly-name="{{ 'Row' + $index + '(TC Amount)'}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
												step="0.01" readonly>
										</div>
									</div>
									<div class="row" ng-if="!row.isTCDisable">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												id="amountUsd{{trIndex}}" ng-model="row.tcamount"
												name="tcamount{{trIndex}}"
												ng-keyup="TCtoBCAmountCalculationForPartyAccountDetTbl(row.tcamount,trIndex,row)"
												friendly-name="{{ 'Row' + $index + '(TC Amount)'}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
												step="0.01">
										</div>
									</div>
								</td>
								<td>
									<div class="row" ng-if="row.isBCDisable">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												id="amount{{trIndex}}" ng-model="row.bcamount"
												name="bcamount{{trIndex}}"
												ng-blur="BCtoTCAmountCalculationForPartyAccountDetTbl(row.bcamount,trIndex,row)"
												friendly-name="{{ 'Row' + $index + '(BC Amount)'}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
												step="0.01" readonly>
										</div>
									</div>
									<div class="row" ng-if="!row.isBCDisable">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												id="amount{{trIndex}}" ng-model="row.bcamount"
												name="bcamount{{trIndex}}"
												ng-blur="BCtoTCAmountCalculationForPartyAccountDetTbl(row.bcamount,trIndex,row)"
												friendly-name="{{ 'Row' + $index + '(BC Amount)'}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
												step="0.01">
										</div>
									</div>
								</td>

							</tr>
							<tr>
								<td colspan="12">
									<div class="col-sm-12">
										<!-- Attributes list -->
										<!-- <div class="col-sm-3" >
							        	<label class="col-md-5 control-label"> Attriutes </label>
							        	</div> -->
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && !row.isVoyageMan">
											<label class="col-md-4 control-label"> Job Order No.

											</label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}" ng-model="row.voyageCode"
													validation="required" name="txtSubAccountCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && row.isVoyageMan">
											<label class="col-md-4 control-label"> Job Order No. </label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}" ng-model="row.voyageCode"
													validation="required" name="txtSubAccountCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>


										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && !row.isVesselMan">
											<label class="col-md-5 control-label"> Mode </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}" ng-model="row.vesselCode"
													validation="required" name="vesselCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
													form-name="cashBankReceiptForm">
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label">  Mode  </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}" ng-model="row.vesselCode"
													validation="required" name="vesselCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>
										<!-- 		<div class="col-sm-2 padding-top-5" ng-if="row.isService && !row.isServiceMan">
											<label class="col-md-5 control-label"> Service

											</label>
											<div class="col-md-7">
										             <selectivity list="sectorList" property="row.sectorCode" id="sectorCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService && row.isServiceMan">
											<label class="col-md-5 control-label"> Service

											</label>
											<div class="col-md-7">
									             <selectivity list="sectorList"
														property="row.sectorCode"
														id="sectorCode{{trIndex}}"
														ng-model="row.sectorCode" validation="required"
														name="sectorCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Service)'}}"
														form-name="cashBankReceiptForm"
														>
													</selectivity>
										     </div>
										</div> -->
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isEmployee && !row.isEmployeeMan">
											<label class="col-md-5 control-label"> Employee </label>
											<div class="col-md-7">
												<selectivity list="employeeList" property="row.employeeCode"
													id="employeeCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isEmployee && row.isEmployeeMan">
											<label class="col-md-5 control-label"> Employee </label>
											<div class="col-md-7">
												<selectivity list="employeeList" property="row.isEmployee"
													id="employeeCode{{trIndex}}" ng-model="row.employeeCode"
													validation="required" name="employeeCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Employee)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isPort && !row.isPortMan">
											<label class="col-md-5 control-label"> Port </label>
											<div class="col-md-7">
												<selectivity list="portList" property="row.portCode"
													id="portCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isPort && row.isPortMan">
											<label class="col-md-5 control-label"> Port </label>
											<div class="col-md-7">
												<selectivity list="portList" property="row.portCode"
													id="portCode{{trIndex}}" ng-model="row.portCode"
													validation="required" name="portCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Port)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isPortSequence && !row.isPortSequenceMan">
											<label class="col-md-5 control-label"> Port.Seq </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="PortSequence{{trIndex}}" ng-model="row.portSequence"
													name="PortSequence" />
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isPortSequence && row.isPortSequenceMan">
											<label class="col-md-5 control-label"> Port.Seq </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="PortSequence{{trIndex}}" ng-model="row.portSequence"
													name="PortSequence" validation="required"
													friendly-name="{{ 'Row' + $index + '(Port Seq)'}}" />
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isDepartment && !row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department </label>
											<div class="col-md-7">
												<selectivity list="departmentList"
													property="row.departmentCode"
													id="departmentCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isDepartment && row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department </label>
											<div class="col-md-7">
												<selectivity list="departmentList"
													property="row.departmentCode"
													id="departmentCode{{trIndex}}"
													ng-model="row.departmentCode" validation="required"
													name="departmentCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Department)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isAgent && !row.isAgentMan">
											<label class="col-md-5 control-label"> Agent </label>
											<div class="col-md-7">
												<selectivity list="agentList" property="row.agentCode"
													id="agentCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isAgent && row.isAgentMan">
											<label class="col-md-5 control-label"> Agent </label>
											<div class="col-md-7">
												<selectivity list="agentList" property="row.agentCode"
													id="agentCode{{trIndex}}" ng-model="row.agentCode"
													validation="required" name="agentCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Agent)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isLocation && !row.isLocationMan">
											<label class="col-md-5 control-label"> Location </label>
											<div class="col-md-7">
												<selectivity list="countryList" property="row.countryCode"
													id="countryCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isLocation && row.isLocationMan">
											<label class="col-md-5 control-label"> Location </label>
											<div class="col-md-7">
												<selectivity list="countryList" property="row.countryCode"
													id="countryCode{{trIndex}}" ng-model="row.countryCode"
													validation="required" name="countryCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Location)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isCustomer && !row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer </label>
											<div class="col-md-7">
												<selectivity list="customerList" property="row.customerCode"
													id="customerCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isCustomer && row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer </label>
											<div class="col-md-7">
												<selectivity list="customerList" property="row.customerCode"
													id="customerCode{{trIndex}}" ng-model="row.customerCode"
													validation="required" name="customerCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Customer)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isSupplier && !row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier </label>
											<div class="col-md-7">
												<selectivity list="supplierList" property="row.supplierCode"
													id="supplierCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isSupplier && row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier </label>
											<div class="col-md-7">
												<selectivity list="supplierList" property="row.supplierCode"
													id="supplierCode{{trIndex}}" ng-model="row.supplierCode"
													validation="required" name="supplierCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Supplier)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isDesignation && !row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation </label>
											<div class="col-md-7">
												<selectivity list="designationList"
													property="row.designationCode"
													id="designationCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isDesignation && row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation </label>
											<div class="col-md-7">
												<selectivity list="designationList"
													property="row.designationCode"
													id="designationCode{{trIndex}}"
													ng-model="row.designationCode" validation="required"
													name="designationCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Designation)'}}"
													form-name="cashBankReceiptForm">
												</selectivity>
											</div>
										</div>


										<div class="col-sm-2 padding-top-5"
											ng-if="row.isCostCenter && !row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="CostCenter{{trIndex}}" ng-model="row.costCenter"
													name="CostCenter{{trIndex}}" />
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isCostCenter && row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="CostCenter{{trIndex}}" ng-model="row.costCenter"
													name="CostCenter{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Designation)'}}" />
											</div>
										</div>
										<!--  commented for inter-company transaction -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
											<label class="col-md-5 control-label">Qty(MT)GO</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="QuantityGO{{trIndex}}" ng-model="row.quantityGO"
													name="QuantityGO" />
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
											<label class="col-md-5 control-label">Qty(MT)FO</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="QuantityFO{{trIndex}}" ng-model="row.quantityFO"
													name="QuantityFO" />
											</div>
										</div>
									</div>
								</td>
							</tr>

						</tbody>
					</table>
					<div class="padding-right-5 padding-bottom-5">
						<button ng-click="addCBRcptDtlRow(objCBReceipt.cshBankDetail)"
							class="btn btn-sm btn-info" tooltip="Add Row" type="button"
							ng-hide="isView">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCBRcptRow(objCBReceipt.cshBankDetail)"
							class="btn btn-sm btn-danger" type="button" tooltip="Delete"
							ng-hide="isView">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<!-- /addRow and /removeRow -->
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="form-group pull-right">

								<label class="col-md-3 control-label"> Balance TC Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm text-right"
										ng-model="cbRcptDtlTotalAmt.balTCAmount" placeholder="0.0" readonly
										name="TC Total">
								</div>

								<label class="col-md-3 control-label"> Balance BC
									Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm text-right"
										ng-model="cbRcptDtlTotalAmt.balBCAmount" placeholder="0.0" readonly
										name="BC Total">
								</div>
                                
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="form-group pull-right">

								<label class="col-md-3 control-label" style="padding-left: 44px;"> Total TC Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm text-right" placeholder="0.0"
										ng-model="cbRcptDtlTotalAmt.totalTCAmount" readonly
										name="TC Total">
								</div>

								<label class="col-md-3 control-label"> Total BC
									Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm text-right" placeholder="0.0"
										ng-model="cbRcptDtlTotalAmt.totalBCAmount" readonly
										name="BC Total">
								</div>
                                
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="content">
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button id="addBtn" class="btn btn-success"   type="button"
												ng-click="submit(cashBankReceiptForm)"
												class="btn btn-success">
												<i class="fa fa-save"></i> Save
											</button>
													<!-- <button id="updateBtn" class="btn btn-success"
												ng-click="submit(cashBankReceiptForm)" ng-if="edit"
												type="submit">
												<i class="fa fa-save"></i> Update
											</button>-->
											<button class="btn btn-danger" ng-click="cancel()" type="button">
												<i class="fa fa-close"></i> Cancel
											</button>
											<!-- ng-if="receipt==false
											<button class="btn btn-success"  ng-if="!edit"
												ng-click="submitDraft(cashBankReceiptForm)">
												<i class="fa fa-save"></i> Save as Draft
											</button>  -->
										</div>
									</div>
								</div>
								<!-- /form-actions -->
							</div>
						</div>
					</div>
				</div>
				<!-- table-responsive -->
			</form>
		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
</div>
<!-- /wrapper-md -->