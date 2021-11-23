<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-10">
				<!-- <li><a>Accounts</a></li>
				<li><a >Transactions</a>
				</li> -->
				<li><a1>
						Bank Payment</a1></li>
				<li><a1 x-ui-sref="#">Add</a1></li>
			</ol>
			<!-- <div class="col-sm-2" style="    margin-left: 87%;margin-top: -44px;position: absolute;">
			<a class="" style="font-size: 37px;" data-ng-click="tdsHelpVideo('TDS_Help_Video.mp4','TDS Help Video')">  
	<img alt="GST" src="/img/tdsVideo.png" height="50px;" width="50px" style="height: 35px;width: 35px;border-radius: 6px;
		 		margin-top: -8px;">		 	</a>
		 	<a class="" style="font-size: 37px;" data-ng-click="tdsHelpVideo('GST_Flow_Corrected.mp4','GST Flow Help Video')">  
		 		<img alt="GST" src="/img/gstVideo.png" height="50px;" width="50px" style="height: 35px;width: 35px;border-radius: 6px;
		 		margin-top: -8px;">
		 	</a>
		 	</div> -->
		</div>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
		
		 			         	
		
			<form name="cashbankpaymentForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<div class="col-sm-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Payment Date<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<ng-bs3-datepicker
										data-ng-model="cashbankpaymentModelData.cashbankPmtDate"
										id="cashbankPmtDate" name="cashbankPmtDate"
										form-name="cashbankpaymentForm"
										data-ng-change="checkDatesCL(cashbankpaymentModelData.cashbankPmtDate)"
										friendly-name="Payment Date" validation="required" />
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Company<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<selectivity ng-if="edit" disabled="edit" list="companyList"
										property="cashbankpaymentModelData.companyName"
										id="cmbCompanyName" form-name="cashbankpaymentForm"
										validation="required" friendly-name="Company"
										name="cmbCompanyName"
										ng-model="cashbankpaymentModelData.companyName"></selectivity>
								</div>
								<div class="col-md-7">
									<selectivity ng-if="!edit" list="companyList"
										property="cashbankpaymentModelData.companyName"
										id="cmbCompanyName" form-name="cashbankpaymentForm"
										validation="required" friendly-name="Company"
										name="cmbCompanyName"
										ng-model="cashbankpaymentModelData.companyName"></selectivity>
								</div>
							</div>
							 <!-- <div class="form-group">
								<label class="col-md-5 control-label">Payment Type<span
									style="color: red;"> *</span></label>
								<div class="col-md-7 ">
									<selectivity list="pmtTypeList"
										property="cashbankpaymentModelData.pmtType" id="pmtType"
										validation="required" friendly-name="Payment Type"
										form-name="cashbankpaymentForm" name="pmtType"
										ng-model="cashbankpaymentModelData.pmtType"></selectivity>
								</div>
							</div>  -->
							<div class="form-group" id="bankaccountgroup"
								ng-if="pmtTypeGroup.show">
								<label class="col-md-5 control-label">Bank Account<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<selectivity list="bankAccountList"
										property="cashbankpaymentModelData.accountName"
										form-name="cashbankpaymentForm" id="accountbankName"
										object="acctList" validation="required"
										friendly-name="Bank Account" name="accountbankName"
										ng-model="cashbankpaymentModelData.accountName"></selectivity>
								</div>
							</div>
							
					
							<div class="form-group"  align="center">							
							<label class="col-md-5 control-label">File Upload </label>
								<div class="col-md-7">
								<div class="input-group">
								 <input type="file" class="form-control btn-primary" class="form-control input-sm" name="excelfile"
								  onchange="angular.element(this).scope().uploadFile(this)" />
								  
								  	<span class="input-group-btn ">
										<button class="btn btn-info input-sm" type="button"
											ng-click="adduploadfiles()" data-toggle="tooltip" title="Add File">
											Upload
										</button>
									</span>
									</div>
								</div>
							</div>
							
							
							<div class="col-sm-4 col-md-4 col-lg-4">
						<div class="" ng-repeat="(tIndex, filelist) in cashbankpaymentModelData.files">
								<a id="tbnewExport{{tIndex}}" style="display: none"
											href="{{filelist.filepath}}/{{filelist.filename}}"
											download="{{filelist.filename}}"></a>
											<div ng-if="filelist.cashbankpaymentModelData!=''">
											{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)" style="color:green">{{filelist.filename}}</a>
											</div>
											
											<div ng-if="filelist.cashbankpaymentModelData==''">
											{{tIndex+1}} ) <a style="color:green">{{filelist.filename}}</a>
											<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)" data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>
										</button>
											</div>
							
							</div>
					</div>
					<br>
				
							<div class="form-group" id="cashaccountgroup"
								ng-if="!(pmtTypeGroup.show)">
								<label class="col-md-5 control-label">Cash Acct<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<selectivity list="cashAccountList"
										property="cashbankpaymentModelData.accountName"
										form-name="cashbankpaymentForm" id="account	Name"
										object="acctList" validation="required"
										friendly-name="Cash Account" name="accountcashName"
										ng-model="cashbankpaymentModelData.accountName"></selectivity>
								</div>
							</div>
						</div>
						<div class="col-sm-4">

							<div class="form-group">
								<label class="col-md-5 control-label">Currency<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
								
									<input type="text" class="form-control input-sm "
										property="cashbankpaymentModelData.currencyCode"
										id="currencyCode" name="currencyCode"
										ng-model="cashbankpaymentModelData.currencyCode"
										 friendly-name="Currency"
										disabled=isCurrency form-name="cashbankpaymentForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Exchange Rate<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm text-right"
										id="exgRate" name="exgRate"
										ng-blur="exchageratehdr(cashbankpaymentModelData.exchangeRate)"
										ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
										ng-model="cashbankpaymentModelData.exchangeRate"
										validation="required" friendly-name="Exchange Rate" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Paid To <span
									style="color: red;">*</span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" id="paidTo"
										name="paidTo" ng-model="cashbankpaymentModelData.paidTo"
										validation="required" friendly-name="Paid to" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">TC Amount<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm text-right"
										id="tcAmount" name="tcAmount"
										ng-model="cashbankpaymentModelData.tcAmountHdr"
										ng-keyup="tcToBcHdrAmtCalculation(cashbankpaymentModelData.tcAmountHdr)"
										validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
										step="0.01" friendly-name="TC Amount" />
								</div>
							</div>

						</div>
						<div class="col-sm-4">
							<div class="form-group" ng-if="pmtTypeGroup.show">
								<label class="col-md-5 control-label">Cheque No<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" id="chequeNo"
										name="chequeNo" ng-model="cashbankpaymentModelData.chequeNo"
										validation="required" friendly-name="Cheque No"
										form-name="cashbankpaymentForm" />
								</div>
							</div>
							<div class="form-group" ng-show="pmtTypeGroup.show">
								<label class="col-md-5 control-label">Cheque Date</label>
								<div class="col-md-7">
									<div class="input-group input-append date" id="cheque_Date">
										<input type="text" class="form-control input-sm"
											name="ReceiptDate" id="txtChequeDate"
											ng-model="cashbankpaymentModelData.chequeDate"
											placeholder='dd/mm/yyyy' /> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">Narration<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<input type="text" cols="5" rows="2"
										class="form-control input-sm" id="narration" name="narration"
										ng-model="cashbankpaymentModelData.narration"
										validation="required" friendly-name="Narration"></input>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">BC
									Amount<span style="color: red;"> *</span>
								</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm text-right"
										id="bcAmount" name="bcAmount"
										ng-model="cashbankpaymentModelData.bcAmountHdr"
										ng-blur="bcToTcHdrAmtCalculation(cashbankpaymentModelData.bcAmountHdr)"
										validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
										step="0.01" friendly-name="BC Amount" />
								</div>
							</div>

						</div>
					</div>
				</div>

				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_13 text-center">Company<span
									style="color: red;"> *</span></th>
								<th colspan=1 class="width_15 text-center">Account Name<span
									style="color: red;"> *</span></th>
								<th colspan=1 class="width_13 text-center">Sub Account Code</th>
								<th colspan=1 class="width_13 text-center">Short Detail<span
									style="color: red;"> *</span></th>
								<th colspan=1 class="width_8 text-center">Currency<span
									style="color: red;"> *</span></th>
								<th colspan=1 class="width_8 text-center">Ex-Rate<span
									style="color: red;"> *</span></th>
								<th colspan=1 class="width_10 text-center">TC Amount<span
									style="color: red;"> *</span></th>
								<th colspan=1 class=" width_10 text-center">BC
									Amount<span style="color: red;"> *</span>
								</th>
								<th colspan=1 class="width_1"></th>
							</tr>
						</thead>
						<!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->
						<tbody
							ng-repeat="(trIndex, row) in cashbankpaymentModelData.cbptables"
							ng-controller="tableCtrlCP">

							<tr ng-if = "row.cbpdtlPmtOrderNo!='TDS'">
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td class="padding-both-side-2"><selectivity
										list="companyList" property="row.companyCode"
										id="companyCode{{trIndex}}" ng-model="row.companyCode"
										validation="required" name="companyCode{{trIndex}}"
										friendly-name="{{ 'Row' + $index + '(Company)'}}"
										form-name="cashbankpaymentForm"></selectivity></td>

								<td class="padding-both-side-2"><selectivity
										list="cbpdtlAcctHeadList" property="row.cbpdtlAccountHead"
										id="account{{trIndex}}" ng-model="row.cbpdtlAccountHead"
										validation="required" name="AccountName{{trIndex}}"
										friendly-name="{{ 'Row' + $index + '(Account Name)'}}"
										form-name="cashbankpaymentForm"></selectivity></td>
								<!-- Sub Account Code -->
								<td class="padding-both-side-2">
									<div class="col-xs-12" ng-if="!row.isSubAccountCode && !row.isSubAccountCodeTDS">
										<selectivity list="row.subAccountCodeList"
											property="row.cbdtlsubAccountCode"
											id="txtSubAccountCode{{trIndex}}"
											ng-model="row.cbdtlsubAccountCode"
											name="txtSubAccountCode{{trIndex}}"
											disabled="!row.isSubAccountCode"> </selectivity>
									</div>

									<div class="col-xs-12" ng-if="row.isSubAccountCode">
										<selectivity list="row.subAccountCodeList"
											property="row.cbdtlsubAccountCode"
											id="txtSubAccountCode{{trIndex}}"
											ng-model="row.cbdtlsubAccountCode" validation="required"
											name="txtSubAccountCode{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Sub Account Code)'}}"
											form-name="cashbankpaymentForm"> </selectivity>
									</div>
									<div class="col-xs-12" ng-if="row.isSubAccountCodeTDS && !row.isSubAccountCode">
										<selectivity list="row.subAccountCodeList"
											property="row.cbdtlsubAccountCode"
											id="txtSubAccountCode{{trIndex}}"
											ng-model="row.cbdtlsubAccountCode" 
											name="txtSubAccountCode{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Sub Account Code)'}}"
											form-name="cashbankpaymentForm"> </selectivity>
									</div>
								</td>
								<!-- code changed for Auto suggestion text box -->
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<div class="col-xs-9 pull-left">
												<input type="text" class="form-control input-sm"
													name="pmtOrderNo" ng-model="row.cbpdtlPmtOrderNo"
													validation="required" name="shortDetail{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Short Detail)'}}"
													form-name="cashbankpaymentForm" id="pmtOrderNo"
													typeahead="ac.id as ac.id for ac in row.pmtOrderNoList| filter:$viewValue |limitTo:10"
													typeahead-min-length='1' />
											</div>
											<div class="col-xs-3 pull-left">
												<label class="line-height-30 cursor-pointer"
													ng-if="row.isTradeCreditors &&  !isView"
													data-ng-click="showPaymentInvoicePopup(trIndex,row)">
													<i class="fa fa-expand"></i>
												</label>
											</div>
											<div class="col-xs-3 pull-left">
												<label class="line-height-30 cursor-pointer"
													ng-if="row.isTDS"
													data-ng-click="showTDSPopup(trIndex,row)">
													<i class="fa fa-expand"></i>
												</label>
											</div>
										</div>
									</div>
								</td>
								<td class="width_10">
									<!-- <input type="text" class="form-control input-sm" id="cbpdtlCurrencyCode{{trIndex}}"
	            			ng-model="row.cbpdtlCurrencyCode" validation="required"  name="currency{{trIndex}}"
							friendly-name="{{ 'Row' + $index + '(Currency)'}}" readonly></selectivity> -->
                                    <input type="hidden" class="form-control input-sm"
												id="invoice{{trIndex}}" ng-model="row.invoiceNo"
												name="invoice{{trIndex}}" readonly />
									<div class="row">
										<div class="col-xs-12" ng-if="row.isCurrencyBlocked">
											<selectivity list="currencyList"
												property="row.cbpdtlCurrencyCode" id="currency{{trIndex}}"
												object="currency" name="currency{{trIndex}}"
												validation="required"
												friendly-name="{{ 'Row' + $index + '(Currency)'}}"
												ng-model="row.cbpdtlCurrencyCode"
												property="row.cbpdtlCurrencyCode"
												form-name="cashbankpaymentForm"
												disabled="row.isCurrencyBlocked"></selectivity>
										</div>
										<div class="col-xs-12" ng-if="!row.isCurrencyBlocked">
											<selectivity list="currencyList"
												property="row.cbpdtlCurrencyCode" id="currency{{trIndex}}"
												object="currency" name="currency{{trIndex}}"
												validation="required"
												friendly-name="{{ 'Row' + $index + '(Currency)'}}"
												ng-model="row.cbpdtlCurrencyCode"
												form-name="cashbankpaymentForm"></selectivity>
										</div>

									</div>

								</td>
								<td><input type="text"
									class="form-control input-sm text-right"
									id="cbpdtlExgRate{{trIndex}}"
									ng-keyup="amountCalculationexchange(row.cbpdtlExgRate,trIndex,row)"
									data-ng-model="row.cbpdtlExgRate" validation="required"
									name="cbpdtlExgRate{{trIndex}}"
									friendly-name="{{ 'Row' + $index + '(Exchange Rate)'}}"
									ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" /></td>
                                
                                <td ng-if="row.isTDS"><input type="text"
									class="form-control input-sm text-right" name="cbpDtlTcAmount"
									data-ng-model="row.cbpDtlTcAmount"
									ng-keyup="tcToBcAmountCalculation(row.cbpDtlTcAmount,trIndex,row)"
									validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
									step="0.01" name="cbpDtlTcAmount{{trIndex}}"
									friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" disabled="true"/></td>

								<td ng-if="row.isTDS"><input type="text"
									class="form-control input-sm text-right" name="cbpDtlBcAmount"
									data-ng-model="row.cbpDtlBcAmount"
									ng-blur="bcToTcAmountCalculation(row.cbpDtlBcAmount,trIndex,row)"
									validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
									step="0.01" name="cbpDtlBcAmount{{trIndex}}"
									friendly-name="{{ 'Row' + $index + '(BC Amount)'}}" disabled="true"/></td>
								
								<td ng-if="!row.isTDS"><input type="text"
									class="form-control input-sm text-right" name="cbpDtlTcAmount"
									data-ng-model="row.cbpDtlTcAmount"
									ng-keyup="tcToBcAmountCalculation(row.cbpDtlTcAmount,trIndex,row)"
									validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
									step="0.01" name="cbpDtlTcAmount{{trIndex}}"
									friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" /></td>

								<td ng-if="!row.isTDS"><input type="text"
									class="form-control input-sm text-right" name="cbpDtlBcAmount"
									data-ng-model="row.cbpDtlBcAmount"
									ng-blur="bcToTcAmountCalculation(row.cbpDtlBcAmount,trIndex,row)"
									validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
									step="0.01" name="cbpDtlBcAmount{{trIndex}}"
									friendly-name="{{ 'Row' + $index + '(BC Amount)'}}" /></td>

							</tr>
							
							
							
							
							<tr ng-if = "row.cbpdtlPmtOrderNo=='TDS'">
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td class="padding-both-side-2"><selectivity
										list="companyList" property="row.companyCode"
										id="companyCode{{trIndex}}" ng-model="row.companyCode"
										validation="required" name="companyCode{{trIndex}}"
										friendly-name="{{ 'Row' + $index + '(Company)'}}"
										form-name="cashbankpaymentForm" disabled="true"></selectivity></td>

								<td class="padding-both-side-2"><selectivity
										list="cbpdtlAcctHeadList" property="row.cbpdtlAccountHead"
										id="account{{trIndex}}" ng-model="row.cbpdtlAccountHead"
										validation="required" name="AccountName{{trIndex}}"
										friendly-name="{{ 'Row' + $index + '(Account Name)'}}"
										form-name="cashbankpaymentForm" disabled="true"></selectivity></td>
								<!-- Sub Account Code -->
								<td class="padding-both-side-2">
									<div class="col-xs-12" ng-if="!row.isSubAccountCode">
										<selectivity list="row.subAccountCodeList"
											property="row.cbdtlsubAccountCode"
											id="txtSubAccountCode{{trIndex}}"
											ng-model="row.cbdtlsubAccountCode"
											name="txtSubAccountCode{{trIndex}}"
											disabled="!row.isSubAccountCode" disabled="true"> </selectivity>
									</div>

									<div class="col-xs-12" ng-if="row.isSubAccountCode">
										<selectivity list="row.subAccountCodeList"
											property="row.cbdtlsubAccountCode"
											id="txtSubAccountCode{{trIndex}}"
											ng-model="row.cbdtlsubAccountCode" validation="required"
											name="txtSubAccountCode{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Sub Account Code)'}}"
											form-name="cashbankpaymentForm" disabled="true"> </selectivity>
									</div>
								</td>
								<!-- code changed for Auto suggestion text box -->
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<div class="col-xs-9 pull-left">
												<input type="text" class="form-control input-sm"
													name="pmtOrderNo" ng-model="row.cbpdtlPmtOrderNo"
													validation="required" name="shortDetail{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Short Detail)'}}"
													form-name="cashbankpaymentForm" id="pmtOrderNo"
													typeahead="ac.id as ac.id for ac in row.pmtOrderNoList| filter:$viewValue |limitTo:10"
													typeahead-min-length='1' readonly/>
											</div>
										</div>
									</div>
								</td>
								<td class="width_10">
									<!-- <input type="text" class="form-control input-sm" id="cbpdtlCurrencyCode{{trIndex}}"
	            			ng-model="row.cbpdtlCurrencyCode" validation="required"  name="currency{{trIndex}}"
							friendly-name="{{ 'Row' + $index + '(Currency)'}}" readonly></selectivity> -->
                                    <input type="hidden" class="form-control input-sm"
												id="invoice{{trIndex}}" ng-model="row.invoiceNo"
												name="invoice{{trIndex}}" readonly />
									<div class="row">
										<div class="col-xs-12" ng-if="row.isCurrencyBlocked">
											<selectivity list="currencyList"
												property="row.cbpdtlCurrencyCode" id="currency{{trIndex}}"
												object="currency" name="currency{{trIndex}}"
												validation="required"
												friendly-name="{{ 'Row' + $index + '(Currency)'}}"
												ng-model="row.cbpdtlCurrencyCode"
												property="row.cbpdtlCurrencyCode"
												form-name="cashbankpaymentForm"
												disabled="row.isCurrencyBlocked" disabled="true"></selectivity>
										</div>
										<div class="col-xs-12" ng-if="!row.isCurrencyBlocked">
											<selectivity list="currencyList"
												property="row.cbpdtlCurrencyCode" id="currency{{trIndex}}"
												object="currency" name="currency{{trIndex}}"
												validation="required"
												friendly-name="{{ 'Row' + $index + '(Currency)'}}"
												ng-model="row.cbpdtlCurrencyCode"
												form-name="cashbankpaymentForm" disabled="true"></selectivity>
										</div>

									</div>

								</td>
								<td><input type="text"
									class="form-control input-sm text-right"
									id="cbpdtlExgRate{{trIndex}}"
									ng-keyup="amountCalculationexchange(row.cbpdtlExgRate,trIndex,row)"
									data-ng-model="row.cbpdtlExgRate" validation="required"
									name="cbpdtlExgRate{{trIndex}}"
									friendly-name="{{ 'Row' + $index + '(Exchange Rate)'}}"
									ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" readonly/></td>

								<td><input type="text"
									class="form-control input-sm text-right" name="cbpDtlTcAmount"
									data-ng-model="row.cbpDtlTcAmount"
									ng-keyup="tcToBcAmountCalculation(row.cbpDtlTcAmount,trIndex,row)"
									validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
									step="0.01" name="cbpDtlTcAmount{{trIndex}}"
									friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" readonly/></td>

								<td><input type="text"
									class="form-control input-sm text-right" name="cbpDtlBcAmount"
									data-ng-model="row.cbpDtlBcAmount"
									ng-blur="bcToTcAmountCalculation(row.cbpDtlBcAmount,trIndex,row)"
									validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
									step="0.01" name="cbpDtlBcAmount{{trIndex}}"
									friendly-name="{{ 'Row' + $index + '(BC Amount)'}}" readonly/></td>

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
											<label class="col-md-4 control-label"> Job Order No. </label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}"></selectivity>
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
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>


										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && !row.isVesselMan">
											<label class="col-md-5 control-label"> Mode </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label"> Mode </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}" ng-model="row.vesselCode"
													validation="required" name="vesselCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>
										<!-- <div class="col-sm-2 padding-top-5"
											ng-if="row.isService && !row.isServiceMan">
											<label class="col-md-5 control-label"> Service </label>
											<div class="col-md-7">
												<selectivity list="sectorList" property="row.sectorCode"
													id="sectorCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isService && row.isServiceMan">
											<label class="col-md-5 control-label"> Service </label>
											<div class="col-md-7">
												<selectivity list="sectorList" property="row.sectorCode"
													id="sectorCode{{trIndex}}" ng-model="row.sectorCode"
													validation="required" name="sectorCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Service)'}}"
													form-name="cashbankpaymentForm">
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
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isPort && !row.isPortMan">
											<label class="col-md-5 control-label"> Port</label>
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
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>

							<!-- 			<div class="col-sm-2 padding-top-5"
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
										</div> -->

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
													form-name="cashbankpaymentForm">
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
													form-name="cashbankpaymentForm">
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
													form-name="cashbankpaymentForm">
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
													form-name="cashbankpaymentForm">
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
													form-name="cashbankpaymentForm">
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
													form-name="cashbankpaymentForm">
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
										<div class="col-sm-2 padding-top-5" ng-if="row.isAsset">
											<label class="col-md-5 control-label"> Asset </label>
											<div class="col-md-7">
												<selectivity list="row.assetList" property="row.assetCode"
													id="assetCode{{trIndex}}"></selectivity>
											</div>
										</div>
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
										<div class="col-sm-2 padding-top-5 padding-both-side-2"
											ng-if="row.isFromDate">
											<label class="col-md-3 control-label padding-both-side-1">Fm
												Dt</label>
											<div class="col-md-9 padding-both-side-5">
												<div class="input-group input-append date"
													id="fromDate{{trIndex}}">
													<input type="text" class="form-control input-sm"
														name="txtfromDate{{trIndex}}" id="txtfromDate{{trIndex}}"
														ng-model="row.fromDate" placeholder='dd/mm/yyyy' /> <span
														class="input-group-addon add-on"> <span
														class="glyphicon glyphicon-calendar"></span>
													</span>
												</div>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5 padding-both-side-2"
											ng-if="row.isToDate">
											<label class="col-md-3 control-label padding-both-side-1">To
												Dt</label>
											<div class="col-md-9 padding-both-side-5">
												<div class="input-group input-append date"
													id="toDate{{trIndex}}">
													<input type="text" class="form-control input-sm"
														name="txttoDate{{trIndex}}" id="txttoDate{{trIndex}}"
														ng-model="row.toDate" placeholder='dd/mm/yyyy' /> <span
														class="input-group-addon add-on"> <span
														class="glyphicon glyphicon-calendar"></span>
													</span>
												</div>
											</div>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addCBPmtRow(cashbankpaymentModelData.cbptables)"
							class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
							type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button
							ng-click="removeCBPmtRow(cashbankpaymentModelData.cbptables)"
							class="btn btn-sm btn-danger" type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<!-- /padding-right-5 - /AddOrRmvebtn -->
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group pull-right">

								<label class="col-md-3 control-label">Balance TC Amt</label>
								<div class="col-md-3" >
									<input type="text" class="form-control input-sm text-right"
										name="balTCAmount"
										data-ng-model="cbpmtDtlTotalAmt.balTCAmount" placeholder="0.0"
										ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
								</div>

								<label class="col-md-3 control-label">Balance BC Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm text-right"
										name="balBCAmount"
										data-ng-model="cbpmtDtlTotalAmt.balBCAmount" placeholder="0.0"
										ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group pull-right">

								<label class="col-md-3 control-label" style="padding-left: 44px;">Total TC Amt</label>
								<div class="col-md-3" >
									<input type="text" class="form-control input-sm text-right"
										name="totalTCAmount"
										data-ng-model="cbpmtDtlTotalAmt.totalTCAmount" placeholder="0.0"
										ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
								</div>

								<label class="col-md-3 control-label">Total BC Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm text-right"
										name="totalBCAmount"
										data-ng-model="cbpmtDtlTotalAmt.totalBCAmount" placeholder="0.0"
										ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
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
											<button class="btn btn-success" type="button"  type="button"
												ng-click="submit(cashbankpaymentForm)">
												<i class="fa fa-save"></i> Save
											</button>
											<!-- <button class="btn btn-success" type="button" ng-if="edit" ng-click="submit(cashbankpaymentForm)" >
	                                        <i class="fa fa-save"></i>
	                                        Update
	                                       </button> -->
											<!-- <button class="btn btn-danger" ng-click="cancel()" ng-if="!pmtTypeGroup.show"
												type="button">
												<i class="fa fa-close"></i> Cancel test
											</button>
											-->
											<button class="btn btn-danger" ng-click="cancel()" ng-if="pmtTypeGroup.show"
												type="button">
												<i class="fa fa-close"></i> Cancel
											</button>
											<!--    ng-if="draft==false"
											<button class="btn btn-success" ng-if="!edit"
												ng-click="submitDraft(cashbankpaymentForm)">
												<i class="fa fa-save"></i> Save as Draft
											</button>  -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- /table-responsive -->

			</form>
		</div>
	</div>
</div>