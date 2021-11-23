<%-- <style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
	</div>
	<tabset justified="true" class="tab-container"> <tab
		heading="{{tabs[0].title}}">
	<div class="panel-body">
		<form class="form-horizontal" method="POST" name="CustomerMasterForm"
			novalidate>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-6">
					<fieldset>
						<div class="form-group" ng-if="CustomerMasterEditData.conIdEdit">
							<label class="col-md-4 control-label"> Customer ID <span
								style="color: red;"></span>
							</label>
							<div class="col-md-5">
								<label class="col-md-6 control-label text-left"
									ng-if="CustomerMasterEditData.isEdit">{{CustomerMasterData.customerCode}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Customer Name <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm text-uppercase"
									id="txtCustomerName" name="Customer Name"
									ng-model="CustomerMasterData.customerName" maxlength="100"
									validation="required" friendly-name="Customer Name"
									form-name="CustomerMasterForm"
									typeahead="ac.customerName as ac.customerName for ac in customerTypeHeadList| filter:$viewValue |limitTo:10 | concatCustomerName:$viewValue"
									typeahead-min-length='1'
									typeahead-input-formatter="fetchSelectedCustomerName($model,CustomerMasterData)"
									ng-disabled="disabled" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4"> Address <span
								style="color: red;">*</span> <!-- <span class="error" ng-show="CustomerMasterData.address.$error.maxlength">
                                                              Too long!</span>    -->
							</label>
							<div class="col-md-5">
								<textarea data-ng-model="CustomerMasterData.address"
									id="address" name="Address"
									class="form-control custom-scroll width_100 textareath"
									rows="3" maxlength="200" friendly-name="Address"
									validation="required" ng-disabled="disabled">
			            </textarea>



							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Area <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" id="area"
									name="area" ng-model="CustomerMasterData.area"
									friendly-name="Area" maxlength="50" validation="required"
									ng-disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Country <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list="countryList"
									data-ng-model="CustomerMasterData.countryName"
									property="CustomerMasterData.countryName" id="countryName"
									object="countryName" name="countryName" validation="required"
									friendly-name="Country Name" form-name="CustomerMasterForm"
									disabled="disabled"></selectivity>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Fax No </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="Fax No"
									" ng-model="CustomerMasterData.faxNo" id="faxNo" maxlength="40"
									ng-disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Email </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="Email"
									ng-model="CustomerMasterData.email" id="email" maxlength="50"
									ng-disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Currency <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list="currencyList"
									ng-model="CustomerMasterData.currency"
									property="CustomerMasterData.currency" id="currency"
									object="currency" name="currency" validation="required"
									friendly-name="Currency Name" form-name="CustomerMasterForm"
									disabled="disabled"></selectivity>
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-4 control-label"> Sales Person </label>
							<div class="col-md-5">
								<selectivity list="payerList"
									ng-model="CustomerMasterData.salesPerson"
									property="CustomerMasterData.salesPerson" id="salesPerson"
									object="salesPerson" name="salesPerson" disabled="disabled"></selectivity>
							</div>
						</div>



						<!--     <div class="form-group">
       <label class="col-md-4 control-label"> Booking Contact Person </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Booking Contact Person" ng-model="CustomerMasterData.bookingCntctPrsn" id="bookingCntctPrsn" maxlength="100" ng-disabled="disabled"">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Pricing/Sales Contact Person </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Pricing/Sales Contact Person" ng-disabled="disabled" ng-model="CustomerMasterData.pricingCntctPrsn" id="pricingCntctPrsn" maxlength="100">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Operations Contact Person </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Operations Contact Person" ng-disabled="disabled" ng-model="CustomerMasterData.operationsCntctPrsn" maxlength="100"
         id="operationsCntctPrsn">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Finance Contact Person </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Finance Contact Person" ng-disabled="disabled" ng-model="CustomerMasterData.financeCntctPrsn" id="financeCntctPrsn" maxlength="100">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label">Tel Number </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Tel Number" ng-model="CustomerMasterData.teleNumber" id="teleNumber" maxlength="20" ng-disabled="disabled">
       </div>
      </div> -->

						<div class="form-group">
							<label class="col-md-4 control-label">Finance Attn </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									name="Tel Number" ng-model="CustomerMasterData.financeAttn"
									id="teleNumber" maxlength="20" ng-disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Type </label>
							<div class="col-md-7">
								<div class="checkbox">
									<!--  <label class="i-checks checkbox-inline">
          <input type="checkbox" class="checkbox style-0" name="shipper" ng-model="CustomerMasterData.shipper" ng-disabled="disabled">
          <i></i>
          Shipper
         </label> -->
									<label class="i-checks checkbox-inline"> <input
										type="checkbox" class="checkbox style-0" name="consignee"
										ng-model="CustomerMasterData.consignee" ng-disabled="disabled">
										<i></i> Consignee
									</label>
									<!--  <label class="i-checks checkbox-inline">
          <input type="checkbox" class="checkbox style-0" name="notifyParty" ng-model="CustomerMasterData.notifyParty" ng-disabled="disabled">
          <i></i>
          Notify Party
         </label>
         <label class="i-checks checkbox-inline" style="margin-left: 0px">
          <input type="checkbox" class="checkbox style-0" name="agreementParty" ng-model="CustomerMasterData.agreementParty" ng-disabled="disabled">
          <i></i>
          Agreement Party
         </label>
         <label class="i-checks checkbox-inline" style="margin-left: 0px;">
          <input type="checkbox" class="checkbox style-0" name="jVPartner" ng-model="CustomerMasterData.jVPartner" ng-disabled="disabled">
          <i></i>
          JV Partner
         </label> -->
									<!--                 <label class="i-checks checkbox-inline" style="margin-left: 0px;">
            <input type="checkbox" class="checkbox style-0"  name="subSlot" ng-model="CustomerMasterData.subSlot">
            <i></i>Sub Slot
           </label> -->
								</div>
							</div>
						</div>
						<div class="form-group" ng-if="CustomerMasterData.jVPartner">
							<label class="col-md-4 control-label"> JV Type <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" name="ShareofRVC"
									ng-true-value="'ShareofRVC'" ng-false-value="''"
									ng-model="CustomerMasterData.shareOfRVC" ng-disabled="disabled">
									<i></i> Share of RVC
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" name="SlotSwap"
									ng-true-value="'SlotSwap'" ng-false-value="''"
									ng-disabled="disabled" ng-model="CustomerMasterData.slotSwap">
									<i></i> Slot Swap
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" name="CRSS"
									ng-true-value="'CRSS'" ng-false-value="''"
									ng-disabled="disabled"
									ng-model="CustomerMasterData.costRevenueSpaceShare"> <i></i>
									Cost / Revenue / Space Sharing
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" name="DeadFreight"
									ng-true-value="'DeadFreight'" ng-false-value="''"
									ng-disabled="disabled"
									ng-model="CustomerMasterData.deadFreight"> <i></i> Dead
									Freight
								</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Payment Center <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list="paymentCenterList" disabled="disabled"
									ng-model="CustomerMasterData.paymentCenter"
									property="CustomerMasterData.paymentCenter" id="paymentCenter"
									object="paymentCenter" name="paymentCenter"
									friendly-name="Payment Center" validation="required"
									form-name="CustomerMasterForm"></selectivity>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Active </label>
							<div class="col-md-5">
								<div class="checkbox">
									<label class="i-checks"> <input type="checkbox"
										class="checkbox style-0" ng-disabled="disabled" name="active"
										ng-model="CustomerMasterData.active" ng-true-value="'Y'"
										ng-false-value="'N'"> <i></i>
									</label>
								</div>
							</div>
						</div>
						<!--    <div class="form-group">
       <label class="col-md-4 control-label">Slot Operator </label>
       <div class="col-md-5">
        <div class="checkbox">
         <label class="i-checks">
          <input type="checkbox" class="checkbox style-0" ng-disabled="disabled" name="slotOperator" ng-model="CustomerMasterData.slotOperator" ng-true-value="'Y'" ng-false-value="'N'">
          <i></i>
         </label>
        </div>
       </div>
      </div> -->
						<div class="form-group">
							<label class="col-md-4 control-label">Email </label>
							<div class="col-md-7">
								<label class="i-checks checkbox-inline"> <input
									type="checkbox" name="booking"
									ng-model="CustomerMasterData.emailBooking" ng-true-value="'B'"
									ng-disabled="disabled" ng-false-value="''"> <i></i>
									Booking
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="pricing"
									ng-model="CustomerMasterData.emailPricing" ng-true-value="'P'"
									ng-disabled="disabled" ng-false-value="''"> <i></i>
									Pricing/Sales
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="operations"
									ng-model="CustomerMasterData.emailOperations"
									ng-true-value="'O'" ng-disabled="disabled" ng-false-value="''">
									<i></i> Operations
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="finance"
									ng-model="CustomerMasterData.emailFinance" ng-true-value="'F'"
									ng-disabled="disabled" ng-false-value="''"> <i></i>
									Finance
								</label>
							</div>
						</div>
						<!--   <div class="form-group">
       <label class="col-md-4 control-label">BL Related </label>
       <div class="col-md-5">
        <label class="i-checks">
         <input type="checkbox" name="blRelated" ng-model="CustomerMasterData.blRelated" ng-true-value="'Y'" ng-disabled="disabled" ng-false-value="'N'">
         <i></i>
        </label>
       </div>
      </div> -->
						<div class="form-group">
							<label class="col-md-4 control-label">City </label>
							<div class="col-md-5">
								<selectivity list="portList" ng-model="CustomerMasterData.city"
									property="CustomerMasterData.city" disabled="disabled"
									id="city" object="city" name="city" friendly-name="City  Name"
									form-name="CustomerMasterForm"></selectivity>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Attached File
								Format </label>
							<div class="col-md-5">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.attachFileGroup"
										ng-disabled="disabled" value="P" name="attachFileGroup"
										checked="checked"> <i></i> PDF
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.attachFileGroup"
										ng-disabled="disabled" value="E" name="attachFileGroup"
										checked="checked"> <i></i> EDI
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="CustomerMasterData.attachFileGroup"
										ng-disabled="disabled" value="H" name="attachFileGroup"
										checked="checked"> <i></i> HTML
									</label>
								</div>
							</div>
						</div>
						<!--     <div class="form-group">
       <label class="col-md-4 control-label">Is Vessel Operator? </label>
       <div class="col-md-5">
        <div class="radio radio-inline" style="padding-left: 0px;">
         <label class="i-checks">
          <input type="radio" class="radiobox style-0" name="isVesselGrp" ng-disabled="disabled" ng_model="CustomerMasterData.isVesselGrp" value="Y">
          <i></i>
          Yes
         </label>
        </div>
        <div class="radio  radio-inline">
         <label class="i-checks">
          <input type="radio" class="radiobox style-0" name="isVesselGrp" ng-disabled="disabled" ng_model="CustomerMasterData.isVesselGrp" value="N" checked="checked" name="gear">
          <i></i>
          No
         </label>
        </div>
       </div>
      </div> -->



					</fieldset>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-6">
					<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label"> Customer ShortName
								<span style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm text-uppercase"
									name="Customer Short Name"
									ng-model="CustomerMasterData.customerShortName"
									message-id="customerShortName" id="txtCustomerShortName"
									validation="required" friendly-name="Customer Short Name"
									form-name="CustomerMasterForm" maxlength="50"
									ng-disabled="disabled"
									typeahead="r.id as r.id for r in customerShortNameList| filter:$viewValue |limitTo:10 | concatCustomerShortName:$viewValue"
									typeahead-min-length='1' />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Address1 </label>
							<div class="col-md-5">


								<textarea data-ng-model="CustomerMasterData.address1"
									id="address1" name="Address1"
									class="form-control custom-scroll width_100 textareath"
									rows="2" maxlength="200" friendly-name="Address1"
									ng-disabled="disabled">
			            </textarea>


								<!--    
       <textarea data-ng-model="CustomerMasterData.address1" id="address1" name="Address1" class="custom-scroll width_100 textareath" rows="3"
         friendly-name="Address1" maxlength="200" ng-disabled="disabled" >
	            </textarea>
			             -->
							</div>
						</div>
						<!--  <selectivity list="typeofCustomerList" property="CustomerMasterData.typeofCustomer" id="typeofCustomer_id" disabled="true"></selectivity> -->
						<!--   <input type="hidden" class="text-right form-control input-sm pull-right"  id="typeofCustomer_id" value="Customer" disabled> -->
						<div class="form-group">
							<label class="col-md-4 control-label">Tel Office No </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									ng-disabled="disabled" name="Tel Office No"
									ng-model="CustomerMasterData.telOfficeNum" id="telOfficeNum"
									maxlength="40">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Telex No </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									ng-disabled="disabled" name="Telex No"
									ng-model="CustomerMasterData.telexNum" id="telexNum"
									maxlength="20">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Cr-Limit(USD) <span
								style="color: red;">*</span></label>
							<div class="col-md-5">
								<input type="text" text-align="right" placeholder="0.00"
									class="text-right form-control input-sm pull-right"
									name="Cr-Limit(USD)" ng-model="CustomerMasterData.crLimit"
									id="crLimit" ng-disabled="disabled" validation="required"
									friendly-name="Cr-Limit(USD)"
									ng-pattern-restrict="^\d+(?:\.\d{0,2})?$">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Exchange Rate </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm text-right"
									ng-disabled="disabled" name="Exchange Rate"
									ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
									ng-model="CustomerMasterData.exchangeRate" id="exchangeRate">
							</div>
						</div>
						<!--  <div class="form-group">
       <label class="col-md-4 control-label"> Booking Contact Person Email </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Booking Contact Person Email" ng-model="CustomerMasterData.bookingCntctPrsnEmail"
         maxlength="500" id="bookingCntctPrsnEmail">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Pricing/Sales Contact Person Email </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Pricing/Sales Contact Person Email" ng-model="CustomerMasterData.pricingCntctPrsnEmail"
         maxlength="500" id="pricingCntctPrsnEmail">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Operations Contact Person Email </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Operations Contact Person Email" ng-model="CustomerMasterData.operationsCntctPrsnEmail"
         id="operationsCntctPrsnEmail" validator="email" valid-method="submit" message-id="operationsCntctPrsnEmail" maxlength="500">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Finance Contact Person Email </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Finance Contact Person Email" ng-model="CustomerMasterData.financeCntctPrsnEmail"
         id="financeCntctPrsnEmail" validator="email" valid-method="submit" maxlength="500" message-id="financeCntctPrsnEmail">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Fax Num </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Fax No" id="faxNum" ng-model="CustomerMasterData.faxNum" maxlength="20">
       </div>
      </div> -->

						<div class="form-group">
							<label class="col-md-4 control-label"> Invoice Email Id </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="Fax No"
									ng-disabled="disabled" id="faxNum"
									ng-model="CustomerMasterData.invoiceEmailId" maxlength="500">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Customer Category
								<span style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<!--      <selectivity list="customerCategoryList" property="CustomerMasterData.customer_category" id="customer_category_id"></selectivity> -->
								<selectivity list="customerCategoryList" disabled="disabled"
									ng-model="CustomerMasterData.customer_category"
									property="CustomerMasterData.customer_category"
									id="customer_category" object="customer_category"
									validation="required" name="customer_category"
									friendly-name="Customer Category"
									form-name="CustomerMasterForm"></selectivity>
							</div>
						</div>
						<!--   <div class="form-group">
       <label class="col-md-4 control-label">SubSlot </label>
       <div class="col-md-5">
        <div class="checkbox">
         <label class="i-checks">
          <input type="checkbox" class="checkbox style-0" ng-disabled="disabled" name="subSlot" ng-model="CustomerMasterData.subSlot" ng-true-value="'Y'" ng-false-value="'N'">
          <i></i>
         </label>
        </div>
       </div>
      </div> -->
						<!--   <div class="form-group">
       <label class="col-md-4 control-label">Credit Customer Type </label>
       <div class="col-md-5">
        <div class="checkbox">
         <label class="i-checks">
          <input type="checkbox" name="creditCustType" ng-disabled="disabled" ng-model="CustomerMasterData.creditCustType" ng-true-value="'Y'" ng-false-value="'N'">
          <i></i>
         </label>
        </div>
       </div>
      </div> -->
						<div class="form-group">
							<label class="col-md-4 control-label">Type Of Customer </label>
							<div class="col-md-7">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="CustomerMasterData.typeOfCustGrp" value="C"
										name="typeOfCustGrp" checked="checked"> <i></i> Credit
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="CustomerMasterData.typeOfCustGrp" value="P"
										name="typeOfCustGrp" checked="checked"> <i></i> Prior
										Loading
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="CustomerMasterData.typeOfCustGrp" value="D"
										name="typeOfCustGrp" checked="checked"> <i></i>
										Deposit Check
									</label>
								</div>
							</div>
						</div>
						<div class="form-group"
							ng-if="CustomerMasterData.typeOfCustGrp=='C'">
							<div class="col-md-6">
								<label class="col-md-7 control-label"> Credit Amount <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="text-right form-control input-sm"
										ng-disabled="disabled" placeholder="0.00" name="Credit Amount"
										ng-model="CustomerMasterData.creditLimitAmt">
								</div>
							</div>
							<div class="col-md-6">
								<label class="col-md-7 control-label"> Credit Days <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="text-right form-control input-sm"
										ng-disabled="disabled" placeholder="0.00" name="Credit Days"
										ng-model="CustomerMasterData.creditLimitDays">
								</div>
							</div>
						</div>
						<div class="form-group"
							ng-if="CustomerMasterData.typeOfCustGrp=='D'">
							<label class="col-md-4 control-label"> Deposit Amount <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00" name="Deposit Amount"
									ng-model="CustomerMasterData.depositAmt"
									message-id="depositAmt" id="depositAmt" validator="required"
									ng-disabled="disabled" valid-method="submit">
							</div>
						</div>
						<!-- <div class="form-group">
       <label class="col-md-4 control-label">Company Type </label>
       <div class="col-md-7">
        <div class="radio radio-inline" style="padding-left: 0px;">
         <label class="i-checks">
          <input type="radio" class="radiobox style-0" ng-disabled="disabled" ng_model="CustomerMasterData.companyTypeGrp" value="MLO" name="companyTypeGrp" checked="checked">
          <i></i>
          MLO
         </label>
        </div>
        <div class="radio radio-inline">
         <label class="i-checks">
          <input type="radio" class="radiobox style-0"  ng-disabled="disabled" ng_model="CustomerMasterData.companyTypeGrp" value="NVOCC" name="companyTypeGrp" checked="checked">
          <i></i>
          NVOCC
         </label>
        </div>
        <div class="radio radio-inline">
         <label class="i-checks">
          <input type="radio" class="radiobox style-0" ng-disabled="disabled" ng_model="CustomerMasterData.companyTypeGrp" value="JV" name="Company TypeGrp" checked="checked">
          <i></i>
          JV
         </label>
         <div class="radio radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0" ng-disabled="disabled" ng_model="CustomerMasterData.companyTypeGrp" value="AGENT" name="companyTypeGrp" checked="checked">
           <i></i>
           AGENT
          </label>
         </div>
        </div>
       </div>
      </div> -->
						<div class="form-group "
							ng-if="CustomerMasterData.companyTypeGrp=='NVOCC'">
							<label class="col-md-4 control-label"> Category <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list="categoryWiseList"
									property="CustomerMasterData.categoryWise"
									ng-disabled="disabled" id="categoryWise"
									friendly-name="Category" form-name="CustomerMasterForm">
							</div>
							<!--    <div class="col-md-5">
	          <selectivity list="categoryWiseList" property="CustomerMasterData.categoryWise" id="categoryWise"
	             validation="required" friendly-name= "Customer Category" form-name = "CustomerMasterForm" >
	              </div> -->
						</div>
						<!--  <div class="form-group">
       <label class="col-md-4 control-label"> Controlling Agent </label>
       <div class="col-md-5">
        <selectivity list="controllingAgentList" property="CustomerMasterData.controllingAgent" disabled="disabled" id="controllingAgent" friendly-name="Customer Category"
         form-name="CustomerMasterForm">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Related Party </label>
       <div class="col-md-5">
        <label class="i-checks">
         <input type="checkbox" class="checkbox style-0" name="relatedParty" ng-disabled="disabled" ng-model="CustomerMasterData.relatedParty" ng-true-value="'Y'" ng-false-value="'N'">
         <i></i>
        </label>
       </div>
      </div> -->

						<div class="form-group">
							<label class="col-md-4 control-label">Bank Name </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="bankName"
									ng-disabled="disabled" friendly-name="Bank Name"
									ng-model="CustomerMasterData.bankName"
									form-name="CustomerMasterForm">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Bank Account Number

							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									name="accountNumber" ng-disabled="disabled"
									friendly-name="Bank Account Number"
									ng-model="CustomerMasterData.accountNumber"
									form-name="CustomerMasterForm">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">RTGS </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="bankRTGS"
									ng-disabled="disabled" friendly-name="Bank RTGS"
									ng-model="CustomerMasterData.bankRTGS"
									form-name="CustomerMasterForm">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Customer VAT </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="vatNum"
									friendly-name="VAT" ng-disabled="disabled"
									ng-model="CustomerMasterData.vatNum"
									form-name="CustomerMasterForm">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Trade Regn No </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="cinNum"
									friendly-name="CIN" ng-disabled="disabled"
									ng-model="CustomerMasterData.cinNum"
									form-name="CustomerMasterForm">
							</div>
						</div>



					</fieldset>
				</div>
			</div>
			<!--  <div class="wrapper-md">
    <div class="panel panel-default">
     <section widget-grid id="widget-grid">
      <div class="row ">
       <article class="col-sm-12">
        <div>
         <div class="" st-table="displayedCollection" st-safe-src="rowCollection">
          <div class="widget-body no-padding ">
           <div class=" ">
            <table class="table table-striped b-t b-light table-hover dataTable no-footer">
             <thead class="dataTables-Main-Head">
              <tr>
               <th class="width_1 text-center">Select</th>
               <th class="width_1 text-center">S.No</th>
               <th class="width_20 text-center">POL</th>
               <th class="width_20 text-center">POD</th>
               <th class="width_30 text-center">Payer</th>
               <th class="width_5 text-center">Email Id</th>
              </tr>
             </thead>
             <tbody class="dataTables-Main-Body">
              <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="customerVoyage in displayedCollection track by $index">
               <td class="width_1 text-center">
                <label class="i-checks m-b-none">
                 <input type="checkbox" name="post[]" ng-model="customerVoyage.checked" class="bulk-delete">
                 <i></i>
                </label>
               </td>
               <td class="width_1 text-center">{{$index+1}}</td>
               <td class="width_20">
                <div class="col-md-6" style="width: 100%">
                 <selectivity list="portList" property="customerVoyage.polCode" id="polCode{{$index}}" 
                  ng-model="customerVoyage.polCode" name ="polCode{{$index}}" validation="required"
          friendly-name="{{ 'Row' + $index + '(POL)'}}" form-name = "CustomerMasterForm"></selectivity>
                </div>
               </td>
               <td class="width_20">
                <div class="col-md-6" style="width: 100%">
                <selectivity list="portList" property="customerVoyage.podCode" id="podCode{{$index}}" 
                  ng-model="customerVoyage.podCode" name ="podCode{{$index}}" validation="required"
          friendly-name="{{ 'Row' + $index + '(POD)'}}" form-name = "CustomerMasterForm"></selectivity>
                 
                </div>
               </td>
               <td class="width_20">
                <div class="col-md-6" style="width: 100%">
                 <selectivity list="payerList" ng-model="customerVoyage.payerCode" property="customerVoyage.payerCode" id="payerCode{{$index}}" name ="payerCode{{$index}}" validation="required"
										friendly-name="{{ 'Row' + $index + '(Payer)'}}" form-name = "CustomerMasterForm"></selectivity>
                </div>
               </td>
               <td class="width_20  text-center">
                <input type="text" class="form-control input-sm" name="Email" ng-model="customerVoyage.email" validator="email" valid-method="submit"
                 message-id="email"  maxlength="500">
               </td>
              </tr>
             </tbody>
            </table>
            <table class="odd table-hover ">
             <tfoot>
              <tr>
               <td class="width_100">
                <button data-ng-click="addRow()" class="btn btn-primary" type="button">
                 <i class="fa fa-plus"></i>
                 Add Row
                </button>
                <button ng-click="deleteAll(displayedCollection)" class="btn btn-danger" type="button">
                 <i class="fa fa-trash-o"></i>
                 Delete Row
                </button>
               </td>
              </tr>
             </tfoot>
            </table>
           </div>
          </div>
         </div>
        </div>
       </article>
      </div>
     </section>
    </div>
   </div> -->
			<br>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<!-- <button class="btn btn-success btn-sm" data-ng-click="saveData(CustomerMasterForm,CustomerMasterData)">
	        <i class="fa fa-save"></i> Save
	       </button> -->
						<button class="btn btn-success"
							ng-if="!CustomerMasterEditData.conIdEdit"
							ng-click=saveData(CustomerMasterForm,CustomerMasterData,displayedCollection)
							type="button">
							<i class="fa fa-save"></i> Save And Continue
						</button>
						<button class="btn btn-success"
							ng-if="CustomerMasterEditData.conIdEdit"
							ng-click=saveData(CustomerMasterForm,CustomerMasterData,displayedCollection)
							type="button">
							<i class="fa fa-save"></i> Update
						</button>
						<button class="btn btn-danger" type="reset"
							class="btn btn-success" ng-click="cancel()">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</div>
		</form>
		<!--  </div>
	</div>
	</div> -->
	</div>
	</tab> <tab heading="{{tabs[1].title}}" active="tabs[1].active">
	<div class="panel-body" ng-hide="isShow">
		<form class="form-horizontal ng-pristine ng-pending" method="POST"
			name="CustCommForm" method="post" novalidate>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-6">
					<div class="row">
						<fieldset ng-disabled="customComm.isLead == 'true'">


							<div class="form-group">
								<label class="col-md-4 control-label"> Managing Director
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="subject"
										id="subject" ng-model="customComm.subject" maxlength="50">
								</div>
							</div>
							<!--  <div class="form-group">
        <label class="col-md-4 control-label">
         Turn Over
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" ng-model="customComm.referral" name="referral" message-id="referral" id="referral"
          typeahead="r.text as r.text for r in referralList| filter:$viewValue |limitTo:10" typeahead-min-length='1' maxlength="50" />
          <input type="text" class="form-control input-sm"  ng-model="customComm.referral" name="referral" message-id="referral"
	          id="referral"   validator="required"   valid-method="submit"/>
        </div>
       </div> -->
							<div class="form-group">
								<label class="col-md-4 control-label"> Booking Contact
									Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Booking Contact Person"
										ng-model="customComm.bookingCntctPrsn" id="bookingCntctPrsn"
										maxlength="100"">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Pricing/Sales
									Contact Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Pricing/Sales Contact Person"
										ng-model="customComm.pricingCntctPrsn" id="pricingCntctPrsn"
										maxlength="100">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Operations
									Contact Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Operations Contact Person"
										ng-model="customComm.operationsCntctPrsn" maxlength="100"
										id="operationsCntctPrsn">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Finance Contact
									Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Finance Contact Person"
										ng-model="customComm.financeCntctPrsn" id="financeCntctPrsn"
										maxlength="100">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Tel Number </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Tel Number" ng-model="customComm.teleNumber"
										id="teleNumber" maxlength="20">
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-6">
					<div class="row">
						<fieldset ng-disabled="customComm.isLead == 'true'">
							<div class="form-group">
								<label class="col-md-4 control-label">Turn Over </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										ng-model="customComm.assignedTo" name="assignedTo"
										id="assignedTo" maxlength="50" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Booking Contact
									Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Booking Contact Person Email"
										ng-model="customComm.bookingCntctPrsnEmail" maxlength="500"
										id="bookingCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Pricing/Sales
									Contact Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Pricing/Sales Contact Person Email"
										ng-model="customComm.pricingCntctPrsnEmail" maxlength="500"
										id="pricingCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Operations
									Contact Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Operations Contact Person Email"
										ng-model="customComm.operationsCntctPrsnEmail"
										id="operationsCntctPrsnEmail" validator="email"
										valid-method="submit" message-id="operationsCntctPrsnEmail"
										maxlength="500">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Finance Contact
									Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Finance Contact Person Email"
										ng-model="customComm.financeCntctPrsnEmail"
										id="financeCntctPrsnEmail" validator="email"
										valid-method="submit" maxlength="500"
										message-id="financeCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Fax Num </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="Fax No"
										id="faxNum" ng-model="customComm.faxNum" maxlength="20">
								</div>
							</div>
						</fieldset>
					</div>
				</div>
			</div>
		</form>
		<div class="form-actions" ng-show="!isShow"
			ng-hide="customComm.isLead == 'true'">
			<div class="row">
				<div class="col-md-12">
					<button ng-model="add" class="btn btn-success" type="submit"
						ng-click="submitDetail(customComm)" class="btn btn-success">
						<i class="fa fa-save"></i> Save
					</button>
					<button class="btn btn-danger" type="reset" class="btn btn-success"
						ng-click="cancelCustomDetail()">
						<i class="fa fa-close"></i> Cancel
					</button>
				</div>
			</div>
		</div>
		<div class="form-actions" ng-show="customComm.isLead == 'true'">
			<div class="row">
				<div class="col-md-12">
					<button ng-model="add" class="btn btn-danger" type="submit"
						ng-click="cancelCustomDetail()" class="btn btn-success">
						<i class="fa fa-arrow-left"></i> Back To Lists
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="panel-body" ng-hide="!isShow">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<fieldset>
					<div class="wrapper-md">
						<div class="panel panel-default">
							<section widget-grid id="widget-grid">
								<div class="row ">
									<article class="col-sm-12">
										<div>
											<div class="" st-table="displayedCollectionFollowup"
												st-safe-src="rowCollectionFollowup">
												<div class="widget-body no-padding ">
													<div class=" " style="min-width: 100%; overflow-x: scroll;">
														<table
															class="table table-striped b-t b-light table-hover dataTable no-footer">
															<thead class="dataTables-Main-Head">
																<tr>

																	<th class="width_5 text-center">Managing Director</th>
																	<th class="width_5 text-center">Turn Over</th>
																	<th class="width_5 text-center">Booking Contact
																		Person</th>
																	<th class="width_10 text-center">Pricing/Sales
																		Contact Person</th>
																	<th class="width_20 text-center">Operations
																		Contact Person</th>
																	<th class="width_20 text-center">Finance Contact
																		Person</th>
																	<th class="width_20 text-center">Tel Number</th>
																	<th class="width_5 text-center">Booking Contact
																		Person Email</th>
																	<th class="width_10 text-center">Pricing/Sales
																		Contact Person Email</th>
																	<th class="width_20 text-center">Operations
																		Contact Person Email</th>
																	<th class="width_20 text-center">Finance Contact
																		Person Email</th>
																	<th class="width_20 text-center">Fax Num</th>
																	<th class="text-center  width_5">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	ng-repeat="customComm in displayedCollectionFollowup track by $index">

																	<td class="width_20 text-center">{{customComm.subject}}</td>
																	<td class="width_20 text-center">{{customComm.assignedTo}}</td>
																	<td class="width_20 text-center">{{customComm.bookingCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.pricingCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.operationsCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.financeCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.teleNumber}}</td>
																	<td class="width_20 text-center">{{customComm.bookingCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.pricingCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.operationsCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.financeCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.faxNum}}</td>

																	<td class="td-actions text-center width_5">
																		<div ng-hide="customComm.isLead == 'true'">
																			<span> <i
																				class="fa  fa-pencil text-success text"
																				data-ng-click="editFollowRow(customComm,$index)"></i>
																			</span> <span> <i
																				class="fa fa-trash-o text-danger-dker text"
																				data-ng-click="deleteFollow(customComm.customId,customComm.customCommId)"></i>
																			</span>
																		</div>
																		<div ng-show="customComm.isLead == 'true'">
																			<span> <i class="fa fa-eye text-success text"
																				data-ng-click="editFollowRow(customComm,$index)"></i>
																			</span>
																		</div>
																	</td>
																</tr>
															</tbody>
														</table>
														
													</div>
													<table class="odd table-hover ">
															<tfoot>
																<tr>
																	<td class="width_100">
																		<button data-ng-click="addFollowUpRow()"
																			class="btn btn-primary" type="button">
																			<i class="fa fa-plus"></i> Add FollowUp
																		</button>
																	</td>
																</tr>
															</tfoot>
														</table>
												</div>
											</div>
										</div>
									</article>
								</div>
							</section>
						</div>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
	<div class="form-actions" ng-show="isShow">
		<div class="row">
			<div class="col-md-12">
				<button ng-model="add" class="btn btn-danger" type="submit"
					ng-click="cancel()" class="btn btn-success">
					<i class="fa fa-arrow-left"></i> Back To Lists
				</button>
			</div>
		</div>
	</div>
	</tab> </tabset>
</div>
<!-- <div class="row">
 <div class="col-sm-12 col-md-12 col-lg-12">
  <span class="padding-left-10">
   <a class="btn btn-primary btn-sm" data-ng-click="algorithmView()"> Algorithm </a>
  </span>
 </div>
</div> -->
</div>
<!-- /wrapper-md -->
<script type="text/ng-template" id="algorithmModal">
<div class="modal-header"> Customer Master Algorithm </div>
<div class="row">
<div class="width_90 m-n-auto">
	<iframe title='Customer Master Algorithm' class=''
        width='625' height='500' src='assets/algorithm_Docs/Customer_Master_Algorithm.pdf'
         allowfullscreen='true' frameborder='0' align="center"></iframe>
</div>
</div>
<div class="modal-footer">
	<button class="btn btn-danger" ng-click="closeHelpDialog()">Close</button>
</div>
</script>
 --%>
 
 
 
<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<tabset justified="true" class="tab-container"> <tab
		heading="{{tabs[0].title}}">
		
		
		<input type="hidden" value="${form_code}" id="form_code_id">
		<form name="servicePartnerForm" method="post" class="form-horizontal"
			novalidate>
			<div class="panel-body">
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Service Partner
								Code <span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.servicePartnerCode" maxlength=6
									data-ng-model="servicePartner.servicePartnerCode"
									name="ServicePartnerCode" validation="required"
									friendly-name="ServicePartnerCode" />

							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Service Partner
								Name <span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.servicePartnerName"maxlength=250
									data-ng-model="servicePartner.servicePartnerName"
									name="ServicePartnerName" validation="required"
									friendly-name="ServicePartnerName" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Branch <span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="branchList" property="servicePartner.branch"
									data-ng-model="servicePartner.branch" name="branch"
									validation="required" form-name="servicePartnerForm"
									friendly-name="branch"> </selectivity>

							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Service Partner
								Ledger Name <span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.servicePartnerLedgerName"maxlength=255
									data-ng-model="servicePartner.servicePartnerLedgerName"
									name="Service Partner Ledger Name" validation="required"
									friendly-name="Service Partner Ledger Name" />
							</div>
						</div>
					</div>
                     <div class="col-md-4">
									<label class="col-md-5 control-label"> Sales Person 
									</label>
									<div class="col-md-7">
										<selectivity list="serviceList" property="servicePartner.salesPerson"
											ng-model="servicePartner.salesPerson" name="salesPerson" 
											friendly-name="Sales Person" form-name="servicePartnerForm"></selectivity>
									</div>
								</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Credit Days Offered</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.creditDaysOffered"
									data-ng-model="servicePartner.creditDaysOffered"
									name="credit Days Offered" friendly-name="Credit Days Offered" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Active</label>
							<div class="col-md-7">
							
								<label class="i-checks m-b-none checkbox"> <input
									type="checkbox" property="servicePartner.active" name="Active"maxlength=255
									data-ng-model="servicePartner.active" friendly-name="Active"/><i></i>
								</label>
							
							
							</div>
						</div>
					</div>


				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Address</label>
							<div class="col-md-7">
								<textarea class="form-control input-sm"
									property="servicePartner.address"
									ng-model="servicePartner.address" name="Address"
									friendly-name="Address" rows="2"></textarea>


							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">City<span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="cityList" property="servicePartner.city"
									data-ng-model="servicePartner.city" name="City"
									validation="required" form-name="servicePartnerForm"
									friendly-name="City"> </selectivity>

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Region</label>
							<div class="col-md-7">
								<selectivity list="regionList" property="servicePartner.region"
									data-ng-model="servicePartner.region"
									name="servicePartner.region" form-name="servicePartnerForm"
									friendly-name="servicePartner.region"> </selectivity>

							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4"></div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Country</label>
							<div class="col-md-7">
								<selectivity list="countryList"
									property="servicePartner.country"
									data-ng-model="servicePartner.country" name="Country"
									form-name="servicePartnerForm" friendly-name="Country">
								</selectivity>

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">ZipCode</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.zipCode"maxlength=6
									data-ng-model="servicePartner.zipCode" name="ZipCode"
									friendly-name="ZipCode" />
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Person To Contact</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.personToContact"maxlength=250
									data-ng-model="servicePartner.personToContact"
									name="Person To Contact" friendly-name="Person To Contact" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Designation</label>
							<div class="col-md-7">

								<input type="text" class="form-control input-sm"
									property="servicePartner.designation" maxlength=250
									data-ng-model="servicePartner.designation" name="Designation"
									friendly-name="Designation" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Email ID</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.emailId"maxlength=50
									data-ng-model="servicePartner.emailId" name="Email"
									friendly-name="Email" />
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">LandLine No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.landLineNo" maxlength=15
									data-ng-model="servicePartner.landLineNo" name="LandLine No"
									friendly-name="LandLine No" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Mobile No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.mobileNo"maxlength=20
									data-ng-model="servicePartner.mobileNo" name="Mobile No"
									friendly-name="Mobile No" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Skype ID</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.skypeId"maxlength=50
									data-ng-model="servicePartner.skypeId" name="Skype ID"
									friendly-name="Skype ID" />
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">WebSite</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.webSite"maxlength=50
									data-ng-model="servicePartner.webSite" name="WebSite"
									friendly-name="WebSite" />
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Service Partner
								Description</label>
							<div class="col-md-7">
								<textarea class="form-control input-sm"maxlength=250
									property="servicePartner.servicePartnerDescription"
									ng-model="servicePartner.servicePartnerDescription"
									name="Service Partner
								Description"
									friendly-name="Service Partner
								Description" rows="2"></textarea>

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">PAN No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.pANNo"maxlength=50
									data-ng-model="servicePartner.pANNo" name="PAN No"
									friendly-name="PAN No" />
							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">


					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Default Type<span
								style="color: red;">*</span></label>
							<div class="col-md-7">
								<selectivity list="defaultTypeList"
									property="servicePartner.defaultType"
									data-ng-model="servicePartner.defaultType"
									validation="required" name="Default Type"
									form-name="servicePartnerForm" friendly-name="Default Type">
								</selectivity>

							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Partner
								Classification</label>
							<div class="col-md-7">
								<selectivity list="classificationList"
									property="servicePartner.partnerClassification"
									data-ng-model="servicePartner.partnerClassification"
									name="partnerClassification" form-name="servicePartnerForm"
									"> </selectivity>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">GSTN State Code<span style="color: red;">*</span>
							</label>
							<div class="col-md-7">
								<selectivity list="gstnStateList"
									property="servicePartner.gSTNStateCode"
									data-ng-model="servicePartner.gSTNStateCode"validation="required"
									name="GSTN State Code" form-name="servicePartnerForm"
									friendly-name="GSTN State Code"> </selectivity>

							</div>
						</div>
					</div>
				</div>
				<div class="row pl2pc pr10pc">


					<div class="col-md-4"></div>

					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Exemption Under</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.exemptionUnder"
									data-ng-model="servicePartner.exemptionUnder"
									name="Exemption Under" friendly-name="Exemption Under" />
							</div>
						</div>
					</div>
					
					<div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">GSTN No</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.gSTNNo"maxlength=15
									data-ng-model="servicePartner.gSTNNo" name="GSTN No"
									friendly-name="GSTN No" />
							</div>
						</div>
					</div><!-- <div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Credit Amount</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.creditAmt"
									data-ng-model="servicePartner.creditAmt"
									name="creditAmt" friendly-name="creditAmt" />
							</div>
						</div>
					</div><div class="col-md-4">
						<div class="form-group">
							<label class="col-md-5 control-label">Credit Days</label>
							<div class="col-md-7">
								<input type="text" class="form-control input-sm"
									property="servicePartner.creditDays"
									data-ng-model="servicePartner.creditDays"
									name="creditDays" friendly-name="creditDays" />
							</div>
						</div> -->
					</div>
				</div>

			</div>

			<div class="panel-body float-left padding-0" style="width: 100%;">
				<div class="table-responsive" style="overflow: hidden;">
					<header id="btntoggle" data-role="heading"
						style="margin-bottom: 0px !important; color: black"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a style="color: black;">Service Partner Type</a>
						</div>
					</header>
				</div>
			</div>


			<div data-role="content" class="form-horizontal panel"
				data-collapse="isCollapsed">
				<ul class="dragList row list-unstyled">
					<li data-ng-repeat="column in servicePartnerType"
						class="col-md-4 col-sm-4 col-lg-4">
						<div class="row">
							<label class="control-label col-md-8" style="width: 61%">{{column.title}}
							</label>
							<div class="col-md-4">
								<label class="i-checks m-b-none checkbox"> <input
									type="checkbox" hidden="column.id"
									data-ng-model="column.visible" /><i></i>
								</label>
							</div>

						</div>


					</li>

				</ul>
			</div>

			<div class="table-responsive">
				<table class="table table-striped b-t b-light">
					<thead>
						<tr>
						<th class="sorting width_1">Select</th>
							<th class="sorting width_2">Contact Name</th>
							<th class="sorting width_3">Designation</th>
							<th class="sorting width_3">Email</th>

							<th class="sorting width_2 text-center table-heading">Landline
								No</th>

							<th class="sorting width_2 text-center table-heading">Skype
							</th>
							<th class="sorting width_2 text-center table-heading">City</th>
							<th class="sorting width_2 text-center table-heading">Remarks
							</th>


						</tr>
					</thead>

					<tbody ng-repeat="($index,row) in servicePartnerTable">
						<tr>
							<td><label class="i-checks m-b-none"> <input
								
									type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
							
							<td>
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm"maxlength=250
											data-ng-model="row.contactName" name="ContactName{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(ContactName)'}}" />
									</div>
								</div>
							</td>


							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm"maxlength=250
											data-ng-model="row.keyDesignation" name="Designation{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Narration)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm"maxlength=50
											data-ng-model="row.keyLandLineNo" name="LandLineNo{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(LandLineNo)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm" maxlength=50 
											data-ng-model="row.keyMobileNo" name="MobileNo{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(MobileNo)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm" maxlength=50
											data-ng-model="row.keySkypeId" name="Skype{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Skype)'}}" />
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									<selectivity list="cityList" property="row.keyCityId"
									data-ng-model="row.keyCityId"name="city{{trIndex}}"
									 form-name="servicePartnerForm"
									friendly-name="{{ 'Row' + $index + '(city)'}}" > </selectivity>
										
									</div>
								</div>
							</td>
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
										<input type="text" class="form-control input-sm"maxlength=500
											data-ng-model="row.remarks" name="remarks{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(remarks)'}}" />
									</div>
								</div>
							</td>

						</tr>
					</tbody>

				</table>
				<div class="padding-right-5" id="AddOrRmvebtn">
					<button ng-click="addCredRow()" class="btn btn-sm btn-info"
						tooltip="Add Row" ng-disabled="" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeCredRow()" class="btn btn-sm btn-danger"
						type="button" tooltip="Delete">
						<i class="fa  fa-trash-o"></i>
					</button>
				</div>
<div class="panel-body float-left padding-0" ng-if="isEdit" style="width: 100%;">
				
					<header id="btntoggle" data-role="heading"
						style="margin-bottom: 0px !important; color: black"
						class="btn btn-default col-sm-12 col-md-12 col-lg-12"
						data-ng-click="isCollapsed = !isCollapsed">
						<div class="row">
							<a style="color: black;">Sales Person</a>
						</div>
					</header>
				
			</div>
			
	
<table class="table table-striped b-t b-light" ng-if="isEdit">
					<thead>
						<tr>
							

							<!-- <th class="sorting width_6">Customer Id </th> -->
							<th class="sorting width_3">Sales Person </span></th>
							<th class="sorting width_4">From Date </span></th>
							<th class="sorting width_3 text-center table-heading">To Date</th>
                       </tr>
					</thead>

					<tbody ng-repeat="($index,row) in salesTable">
						<tr>
							
							<!-- <td>
								<div class="row">
									<div class="col-xs-12">
										<input type="text"  class="form-control input-sm"
											data-ng-model="row.servicePartnerId" disable=true name="servicePartnerId{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(customerID)'}}" disabled/>
									</div>
								</div>
							</td> -->

                          
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									<!-- <selectivity list="serviceList"
											data-ng-model="row.salesPersonEmp" name="salesPersonEmp{{trIndex}}" 
											friendly-name="{{ 'Row' + $index + '(salesPersonEmp)'}} form-name="servicePartnerForm"></selectivity> -->
											<input type="text"  class="form-control input-sm" name="salesPerson{{trIndex}}"
											data-ng-model="row.salesPerson" disabled  />
										
									</div>
								</div>
							</td>
							
							
							 <td class="width_10">
								<div class="row">
									<div class="col-xs-10">
										
											<ng-bs3-datepicker
											data-ng-model="row.createdDate" name="ToDate{{trIndex}}"
											form-name="servicePartnerForm"
											friendly-name="{{ 'Row' + $index + '(ToDate)'}}" disabled/>
											
									</div>
								</div>
							</td> 
							
							<td class="width_10">
								<div class="row">
									<div class="col-xs-12">
									
										<ng-bs3-datepicker
											data-ng-model="row.toDate" name="ToDate{{trIndex}}"
											form-name="servicePartnerForm"
											friendly-name="{{ 'Row' + $index + '(ToDate)'}}" disabled />
									</div>
								</div>
							</td>
					
						</tr>
					</tbody>
	          
				</table>

				<br /> <br />
	                     <div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" ng-if="!isEdit"
								ng-click="save(servicePartnerForm)">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" ng-if="isEdit" type="submit" 
								ng-click="update(servicePartnerForm)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="reset" ng-click="reset()" ng-if="!isEdit">
								<i class="fa fa-undo"></i> Reset
							</button>
							
							<button class="btn btn-info" ng-click="reset()" ng-if="isEdit">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel</button>

						</div>
					</div>
				</div>
			</div>

		</form>
		
		
		</tab>
		<!-- kyc -->
       	
		 <tab heading="{{tabs[1].title}}" active="tabs[1].active">
	<div class="panel-body" ng-hide="isShow">
		<form class="form-horizontal ng-pristine ng-pending" method="POST"
			name="CustCommForm" method="post" novalidate>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-6">
					<div class="row">
						<fieldset ng-disabled="customComm.isLead == 'true'">


							<div class="form-group">
								<label class="col-md-4 control-label"> Managing Director
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="subject"
										id="subject" ng-model="customComm.subject" maxlength="50">
								</div>
							</div>
							<!--  <div class="form-group">
        <label class="col-md-4 control-label">
         Turn Over
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="form-control input-sm" ng-model="customComm.referral" name="referral" message-id="referral" id="referral"
          typeahead="r.text as r.text for r in referralList| filter:$viewValue |limitTo:10" typeahead-min-length='1' maxlength="50" />
          <input type="text" class="form-control input-sm"  ng-model="customComm.referral" name="referral" message-id="referral"
	          id="referral"   validator="required"   valid-method="submit"/>
        </div>
       </div> -->
							<div class="form-group">
								<label class="col-md-4 control-label"> Booking Contact
									Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Booking Contact Person"
										ng-model="customComm.bookingCntctPrsn" id="bookingCntctPrsn"
										maxlength="100"">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Pricing/Sales
									Contact Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Pricing/Sales Contact Person"
										ng-model="customComm.pricingCntctPrsn" id="pricingCntctPrsn"
										maxlength="100">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Operations
									Contact Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Operations Contact Person"
										ng-model="customComm.operationsCntctPrsn" maxlength="100"
										id="operationsCntctPrsn">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Finance Contact
									Person </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Finance Contact Person"
										ng-model="customComm.financeCntctPrsn" id="financeCntctPrsn"
										maxlength="100">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Tel Number </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Tel Number" ng-model="customComm.teleNumber"
										id="teleNumber" maxlength="20">
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-6">
					<div class="row">
						<fieldset ng-disabled="customComm.isLead == 'true'">
							<div class="form-group">
								<label class="col-md-4 control-label">Turn Over </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										ng-model="customComm.assignedTo" name="assignedTo"
										id="assignedTo" maxlength="50" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Booking Contact
									Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Booking Contact Person Email"
										ng-model="customComm.bookingCntctPrsnEmail" maxlength="500"
										id="bookingCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Pricing/Sales
									Contact Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Pricing/Sales Contact Person Email"
										ng-model="customComm.pricingCntctPrsnEmail" maxlength="500"
										id="pricingCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Operations
									Contact Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Operations Contact Person Email"
										ng-model="customComm.operationsCntctPrsnEmail" maxlength="500"
										id="operationsCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Finance Contact
									Person Email </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="Finance Contact Person Email"
										ng-model="customComm.financeCntctPrsnEmail" maxlength="500"
										id="financeCntctPrsnEmail">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Fax Number </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="Fax No"
										id="faxNum" ng-model="customComm.faxNum" maxlength="20">
								</div>
							</div>
						</fieldset>
					</div>
				</div>
			</div>
		</form>
		<div class="form-actions" ng-show="!isShow"
			ng-hide="customComm.isLead == 'true'">
			<div class="row">
				<div class="col-md-12">
					<button ng-model="add" class="btn btn-success" type="button"
						ng-click="submitDetail(customComm)" class="btn btn-success">
						<i class="fa fa-save"></i> Save
					</button>
					<button class="btn btn-danger" type="reset" class="btn btn-success"
						ng-click="cancelCustomDetail()">
						<i class="fa fa-close"></i> Cancel
					</button>
				</div>
			</div>
		</div>
		<div class="form-actions" ng-show="customComm.isLead == 'true'">
			<div class="row">
				<div class="col-md-12">
					<button ng-model="add" class="btn btn-danger" type="button"
						ng-click="cancelCustomDetail()" class="btn btn-success">
						<i class="fa fa-arrow-left"></i> Back To Lists
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="panel-body" ng-hide="!isShow">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<fieldset>
					<div class="wrapper-md">
						<div class="panel panel-default">
							<section widget-grid id="widget-grid">
								<div class="row ">
									<article class="col-sm-12">
										<div>
											<div class="" st-table="displayedCollectionFollowup"
												st-safe-src="rowCollectionFollowup">
												<div class="widget-body no-padding ">
													<div class=" " style="min-width: 100%; overflow-x: scroll;">
														<table
															class="table table-striped b-t b-light table-hover dataTable no-footer">
															<thead class="dataTables-Main-Head">
																<tr>

																	<th class="width_5 text-center">Managing Director</th>
																	<th class="width_5 text-center">Turn Over</th>
																	<th class="width_5 text-center">Booking Contact
																		Person</th>
																	<th class="width_10 text-center">Pricing/Sales
																		Contact Person</th>
																	<th class="width_20 text-center">Operations
																		Contact Person</th>
																	<th class="width_20 text-center">Finance Contact
																		Person</th>
																	<th class="width_20 text-center">Tel Number</th>
																	<th class="width_5 text-center">Booking Contact
																		Person Email</th>
																	<th class="width_10 text-center">Pricing/Sales
																		Contact Person Email</th>
																	<th class="width_20 text-center">Operations
																		Contact Person Email</th>
																	<th class="width_20 text-center">Finance Contact
																		Person Email</th>
																	<th class="width_20 text-center">Fax Num</th>
																	<th class="text-center  width_5">Action</th>
																</tr>
															</thead>
															<tbody class="dataTables-Main-Body">
																<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
																	ng-repeat="customComm in displayedCollectionFollowup track by $index">

																	<td class="width_20 text-center">{{customComm.subject}}</td>
																	<td class="width_20 text-center">{{customComm.assignedTo}}</td>
																	<td class="width_20 text-center">{{customComm.bookingCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.pricingCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.operationsCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.financeCntctPrsn}}</td>
																	<td class="width_20 text-center">{{customComm.teleNumber}}</td>
																	<td class="width_20 text-center">{{customComm.bookingCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.pricingCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.operationsCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.financeCntctPrsnEmail}}</td>
																	<td class="width_20 text-center">{{customComm.faxNum}}</td>

																	<td class="td-actions text-center width_5">
																		<div ng-hide="customComm.isLead == 'true'">
																			<span> <i
																				class="fa  fa-pencil text-success text"
																				data-ng-click="editFollowRow(customComm,$index)"></i>
																			</span> <span> <i
																				class="fa fa-trash-o text-danger-dker text"
																				data-ng-click="deleteFollow(customComm.customId,customComm.customCommId)"></i>
																			</span>
																		</div>
																		<div ng-show="customComm.isLead == 'true'">
																			<span> <i class="fa fa-eye text-success text"
																				data-ng-click="editFollowRow(customComm,$index)"></i>
																			</span>
																		</div>
																	</td>
																</tr>
															</tbody>
														</table>
														
													</div>
													<table class="odd table-hover ">
															<tfoot>
																<tr>
																	<td class="width_100">
																		<button data-ng-click="addFollowUpRow()"
																			class="btn btn-primary" type="button">
																			<i class="fa fa-plus"></i> Add FollowUp
																		</button>
																	</td>
																</tr>
															</tfoot>
														</table>
												</div>
											</div>
										</div>
									</article>
								</div>
							</section>
						</div>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
	<div class="form-actions" ng-show="isShow">
		<div class="row">
			<div class="col-md-12">
				<button ng-model="add" class="btn btn-danger" type="submit"
					ng-click="cancel()" class="btn btn-success">
					<i class="fa fa-arrow-left"></i> Back To Lists
				</button>
			</div>
		</div>
	</div>
	</tab>
	
		</tabset>
		
	</div>

		
	</div>

 
 
 