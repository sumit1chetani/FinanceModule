<style>
.line-height-23 {
	line-height: 22.8px !important;
}
</style>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="tdsNatureForm" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
								<div class="form-group" ng-if="isEdit==true">
									<label class="col-md-4 control-label">TDS Code</label>
									<div class="col-md-5 inputGroupContainer">
										<!--          <input type="text" class="form-control input-sm" name="tdsTaxCode" ng-model="tdsTax.tdsTaxCode" readonly>
 -->
										<label class="col-md-4 control-label">
											{{tdsTax.tdsTaxCode}}</label>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>

								<div class="form-group" ng-if="isEdit==false">
									<label class="col-md-4 control-label">Company<span
										style="color: red;">*</span></label>
									<div class="col-md-5">
										<selectivity list="branchList" ng-model="tdsTax.branch"
											validation="required" friendly-name="Branch"
											property="tdsTax.branch" id="Branch" name="Branch"
											form-name="tdsNatureForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group" ng-if="isEdit==true">
									<label class="col-md-4 control-label">Company<span
										style="color: red;">*</span></label>
									<div class="col-md-5">
										<selectivity list="branchList" ng-model="tdsTax.branch"
											validation="required" friendly-name="Bank"
											property="tdsTax.branch" id="Branch" name="Branch"
											form-name="tdsNatureForm" disabled="true"></selectivity>
									</div>
								</div>


								<div class="form-group" ng-if="isEdit==false">
									<label class="col-md-4 control-label">Vendor <span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">
										<selectivity list="vendorList" ng-model="tdsTax.vendorCode"
											property="tdsTax.vendorCode" id="vendorCode"
											name="vendorCode" validation="required"
											friendly-name="Vendor" form-name="tdsNatureForm"></selectivity>
									</div>
								</div>
								<div class="form-group" ng-if="isEdit==true">
									<label class="col-md-4 control-label">Vendor <span
										style="color: red;">*</span></label>
									<div class="col-md-5 inputGroupContainer">
										<selectivity list="vendorList" ng-model="tdsTax.vendorCode"
											property="tdsTax.vendorCode" id="vendorCode"
											name="vendorCode" validation="required"
											friendly-name="Vendor" form-name="tdsNatureForm"
											disabled="true"></selectivity>
									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">Type
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-5">
									<select class="form-control input-sm" name="tdsNatureType" ng-model="tdsTax.tdsNatureType" validation="required" friendly-name="Type" >
									<option value="" selected="selected">Select</option>
             							<option value="COMPANY" >COMPANY</option>
             							<option value="INDIVIDUAL" >INDIVIDUAL</option>
		   										</select>
										<!-- <input type="text" class="form-control input-sm"
											id="tdsNatureType" name="tdsNatureType"
											ng-model="tdsTax.tdsNatureType" validation="required"
											friendly-name="Type"  /> -->
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">Currency
										<span style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="currencyList"
											property="tdsTax.currencyCode" ng-model="tdsTax.currencyCode"
											id="currencyCode" name="currencyCode"
											object="tempDropDownObj" validation="required"
											friendly-name="Currency" form-name="tdsNatureForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group" ng-if="isEdit==false">
									<label class="col-md-4 control-label">Invoice No<span
										style="color: red;">*</span></label>
									<div class="col-md-5">
										<selectivity list="invoiceList" ng-model="tdsTax.invNo"
											validation="required" friendly-name="Invoice No"
											property="tdsTax.invNo" id="invNo" name="InvoiceNo"
											form-name="tdsNatureForm"></selectivity>
									</div>
								</div>
								
								<div class="form-group" ng-if="isEdit==true">
									<label class="col-md-4 control-label">Invoice No<span
										style="color: red;">*</span></label>
									<div class="col-md-5">
										<selectivity list="invoiceList" ng-model="tdsTax.invNo"
											validation="required" friendly-name="Invoice No"
											property="tdsTax.invNo" id="invNo" name="InvoiceNo"
											form-name="tdsNatureForm" disabled="true"></selectivity>
									</div>
								</div>

							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>

								<div class="form-group" ng-if="isEdit==false">
									<label class="col-md-4 control-label"> Nature <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="tdsNatureList"
											property="tdsTax.tdsNatureCode" id="tdsNatureCode"
											ng-model="tdsTax.tdsNatureCode" name="tdsNatureCode"
											validation="required" friendly-name="Nature"
											form-name="tdsNatureForm"></selectivity>
									</div>
								</div>

								<div class="form-group" ng-if="isEdit==true">
									<label class="col-md-4 control-label"> Nature <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="tdsNatureList"
											property="tdsTax.tdsNatureCode" id="tdsNatureCode"
											ng-model="tdsTax.tdsNatureCode" name="tdsNatureCode"
											validation="required" friendly-name="Nature"
											form-name="tdsNatureForm"></selectivity>
									</div>
								</div>

								<!--       <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Date <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <div class='input-group date datetimepick'>
                                 <input type="text" class="form-control" ng-model="tdsTax.date" placeholder="dd/mm/yyyy" id="date" name="date"
                                   value="{{tdsTax.date}}" validation="required" friendly-name="Date" form-name="tdsNatureForm"/> <span class="input-group-addon"> <span
                                   class="glyphicon glyphicon-calendar"> </span>
                                  </span>
         </div>
         </div>
        </div> -->
								<div class="form-group">
									<label class="control-label col-md-4">Date <span
										style="color: red;">*</span></label>
									<div class="col-md-5">

										<ng-bs3-datepicker data-ng-model="tdsTax.date" id="date"
											name="date" form-name="tdsNatureForm"
											data-ng-change="checkDatesCL(tdsTax.date)"
											friendly-name="Date" validation="required" />
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-4">Exchange
										Rate <span style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm text-right"
											id="exchangeRate" name="exchangeRate"
											ng-model="tdsTax.exchangeRate" validation="required"
											friendly-name="Exchange Rate"
											ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" />
									</div>
								</div>

							</fieldset>
						</div>
					</div>
				</div>
				<!-- /row -->
				<div class="row">

					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-6 col-md-6 col-lg-5">
							<fieldset>
								<div class="form-group">
									<label class="col-md-7 control-label line-height-23 bold">Particulars
									</label>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label line-height-23 ">Value
										of Purchase(s) </label>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label line-height-23 ">Amount
										Paid/Credit </label>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label line-height-23 ">Add
										TDS(I-Tax) </label>
								</div>
								<!-- <div class="form-group">
									<label class="col-md-5 control-label line-height-23 ">Surcharge
									</label>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label line-height-23 ">TDS+Surcharge<span
										style="color: red;">*</span></label>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label line-height-23 ">Edu.Cess</label>
								</div> -->
								<!-- <div class="form-group">
									<label class="col-md-5 control-label "> Account Head <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-5">
										<selectivity list="accountHeadList"
											property="tdsTax.accountHeadCode" id="accountHeadCode"
											name="accountHeadCode" ng-model="tdsTax.accountHeadCode"
											validation="required" friendly-name="Account Head"
											form-name="tdsNatureForm" disabled="true"></selectivity>
									</div>
								</div> -->

							</fieldset>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-2">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label bold">Rate </label>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<label class="col-md-4 control-label line-height-23 ">&nbsp;
										</label>
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-8">
										<label class="col-md-4 control-label line-height-23 ">&nbsp;
										</label>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="tdsTaxRate" ng-model="tdsTax.tdsTaxRate"
											validation="required" friendly-name="TDS Tax Rate"
											id="tdsTaxRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
											readonly />
									</div>
								</div>
								<!-- <div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="surchargeExRate" ng-model="tdsTax.surchargeExRate"
											validation="required" friendly-name="Surcharge"
											id="surchargeExRate"
											ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<label class="col-md-4 control-label line-height-23 ">
											&nbsp;</label>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="eduCessExRate" ng-model="tdsTax.eduCessExRate"
											validation="required" friendly-name="Edu.cess"
											id="eduCessExRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
											readonly />
									</div>
								</div> -->
								<div class="form-group">
									<div class="col-md-8">
										<label class="col-md-4 control-label line-height-23 ">
											&nbsp;</label>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-8 control-label bold">Net TDS </label>
								</div>
							</fieldset>
						</div>

						<div class="col-sm-6 col-md-6 col-lg-2">
							<fieldset>
								<div class="form-group">
									<label class="col-md-6 control-label bold">Amount</label>
								</div>

								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="purchaseAmountLocal"
											ng-model="tdsTax.purchaseAmountLocal"
											friendly-name="Purchase Amount Local"
											id="purchaseAmountLocal" ng-keyup="calculatingTax();"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.001" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="creditAmountLocal" ng-model="tdsTax.creditAmountLocal"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Credit Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="Credit Amount Local"
											id="creditAmountLocal" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="tdsTaxAmountLocal" ng-model="tdsTax.tdsTaxAmountLocal"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TDS Tax Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="TDS Tax Amount Local"
											id="tdsTaxAmountLocal" readonly />
									</div>
								</div>
								<!-- <div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="surchargeAmountLocal"
											ng-model="tdsTax.surchargeAmountLocal"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Surcharge Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="Surcharge Amount Local"
											id="surchargeAmountLocal" readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="tdsSurchargeAmtLocal"
											ng-model="tdsTax.tdsSurchargeAmtLocal"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="TDS Surcharge Amount Local"
											id="tdsSurchargeAmtLocal" readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="eduCessAmtLocal" ng-model="tdsTax.eduCessAmtLocal"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 3 digit|required"
											step="0.01" friendly-name="Edu.cess Amount Local"
											id="eduCessAmtLocal" readonly />
									</div>
								</div> -->
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="tdsNetAmtLocal" ng-model="tdsTax.tdsNetAmtLocal"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="TDS Net Amount Local"
											id="tdsNetAmtLocal" readonly />
									</div>
								</div>
							</fieldset>
						</div>
						<!-- <div class="col-sm-6 col-md-6 col-lg-2">
							<fieldset>
								<div class="form-group">
									<label class="col-md-7 control-label bold">Amount(USD)
									</label>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="purchaseAmountUsd" ng-model="tdsTax.purchaseAmountUsd"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="Purchase Amount USD"
											id="purchaseAmountUsd" readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="creditAmountUsd" ng-model="tdsTax.creditAmountUsd"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="Credit Amount USD"
											id="creditAmountUsd" readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="tdsTaxAmountUsd" ng-model="tdsTax.tdsTaxAmountUsd"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="TDS Tax Amount USD"
											id="tdsTaxAmountUsd" readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="surchargeAmountUsd"
											ng-model="tdsTax.surchargeAmountUsd"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="Surcharge Amount USD"
											id="surchargeAmountUsd" readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="tdsSurcharegeAmtUsd"
											ng-model="tdsTax.tdsSurchargeAmtUsd"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="TDS Surcharge Amount USD"
											id="individualTax" readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="eduCessAmtUsd" ng-model="tdsTax.eduCessAmtUsd"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="Edu.cess Amount USD"
											id="eduCessAmtUsd" readonly />
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-8">
										<input type="text" class="form-control input-sm text-right"
											name="tdsNetAmtUsd" ng-model="tdsTax.tdsNetAmtUsd"
											validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Purchase Amount Local Should be 2 digit|required"
											step="0.01" friendly-name="TDS Net Amount USD"
											id="tdsNetAmtUsd" readonly />
									</div>
								</div>

							</fieldset>
						</div> -->
					</div>
				</div>
				<!-- Row End -->
				<br>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit" type="button"
								ng-click="submit(tdsNatureForm)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" ng-if="isEdit" type="button"
								ng-click="update(tdsNatureForm)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" ng-if="!isEdit" type="reset"
								ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="button"
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
