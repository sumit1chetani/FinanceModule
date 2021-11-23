<style type="text/css">
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
		<form class="form-horizontal" method="POST" name="ConsigneeMasterForm"
			novalidate>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-6">
					<fieldset>
						<div class="form-group" ng-if="ConsigneeMasterEditData.conIdEdit">
							<label class="col-md-4 control-label"> Consignee ID <span
								style="color: red;"></span>
							</label>
							<div class="col-md-5">
								<label class="col-md-6 control-label text-left"
									ng-if="ConsigneeMasterEditData.isEdit">{{ConsigneeMasterData.ConsigneeCode}}</label>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Consignee Name <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm text-uppercase"
									id="txtConsigneeName" name="Consignee Name"
									ng-model="ConsigneeMasterData.ConsigneeName" maxlength="100"
									validation="required" friendly-name="Consignee Name"
									form-name="ConsigneeMasterForm"
									typeahead="ac.ConsigneeName as ac.ConsigneeName for ac in ConsigneeTypeHeadList| filter:$viewValue |limitTo:10 | concatConsigneeName:$viewValue"
									typeahead-min-length='1'
									typeahead-input-formatter="fetchSelectedConsigneeName($model,ConsigneeMasterData)"
									ng-disabled="disabled" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4"> Address <span
								style="color: red;">*</span> <!-- <span class="error" ng-show="ConsigneeMasterData.address.$error.maxlength">
                                                              Too long!</span>    -->
							</label>
							<div class="col-md-5">
								<textarea data-ng-model="ConsigneeMasterData.address"
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
									name="area" ng-model="ConsigneeMasterData.area"
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
									data-ng-model="ConsigneeMasterData.countryName"
									property="ConsigneeMasterData.countryName" id="countryName"
									object="countryName" name="countryName" validation="required"
									friendly-name="Country Name" form-name="ConsigneeMasterForm"
									disabled="disabled"></selectivity>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Fax No </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="Fax No"
									" ng-model="ConsigneeMasterData.faxNo" id="faxNo" maxlength="40"
									ng-disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Email </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="Email"
									ng-model="ConsigneeMasterData.email" id="email" maxlength="50"
									ng-disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Currency <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list="currencyList"
									ng-model="ConsigneeMasterData.currency"
									property="ConsigneeMasterData.currency" id="currency"
									object="currency" name="currency" validation="required"
									friendly-name="Currency Name" form-name="ConsigneeMasterForm"
									disabled="disabled"></selectivity>
							</div>
						</div>


						<div class="form-group">
							<label class="col-md-4 control-label"> Sales Person </label>
							<div class="col-md-5">
								<selectivity list="payerList"
									ng-model="ConsigneeMasterData.salesPerson"
									property="ConsigneeMasterData.salesPerson" id="salesPerson"
									object="salesPerson" name="salesPerson" disabled="disabled"></selectivity>
							</div>
						</div>



						<!--     <div class="form-group">
       <label class="col-md-4 control-label"> Booking Contact Person </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Booking Contact Person" ng-model="ConsigneeMasterData.bookingCntctPrsn" id="bookingCntctPrsn" maxlength="100" ng-disabled="disabled"">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Pricing/Sales Contact Person </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Pricing/Sales Contact Person" ng-disabled="disabled" ng-model="ConsigneeMasterData.pricingCntctPrsn" id="pricingCntctPrsn" maxlength="100">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Operations Contact Person </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Operations Contact Person" ng-disabled="disabled" ng-model="ConsigneeMasterData.operationsCntctPrsn" maxlength="100"
         id="operationsCntctPrsn">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Finance Contact Person </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Finance Contact Person" ng-disabled="disabled" ng-model="ConsigneeMasterData.financeCntctPrsn" id="financeCntctPrsn" maxlength="100">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label">Tel Number </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" name="Tel Number" ng-model="ConsigneeMasterData.teleNumber" id="teleNumber" maxlength="20" ng-disabled="disabled">
       </div>
      </div> -->

						<div class="form-group">
							<label class="col-md-4 control-label">Finance Attn </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									name="Tel Number" ng-model="ConsigneeMasterData.financeAttn"
									id="teleNumber" maxlength="20" ng-disabled="disabled">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Type </label>
							<div class="col-md-7">
								<div class="checkbox">
									<!--  <label class="i-checks checkbox-inline">
          <input type="checkbox" class="checkbox style-0" name="shipper" ng-model="ConsigneeMasterData.shipper" ng-disabled="disabled">
          <i></i>
          Shipper
         </label> -->
									<label class="i-checks checkbox-inline"> <input
										type="checkbox" class="checkbox style-0" name="consignee"
										ng-model="ConsigneeMasterData.consignee" ng-disabled="disabled">
										<i></i> Consignee
									</label>
									<!--  <label class="i-checks checkbox-inline">
          <input type="checkbox" class="checkbox style-0" name="notifyParty" ng-model="ConsigneeMasterData.notifyParty" ng-disabled="disabled">
          <i></i>
          Notify Party
         </label>
         <label class="i-checks checkbox-inline" style="margin-left: 0px">
          <input type="checkbox" class="checkbox style-0" name="agreementParty" ng-model="ConsigneeMasterData.agreementParty" ng-disabled="disabled">
          <i></i>
          Agreement Party
         </label>
         <label class="i-checks checkbox-inline" style="margin-left: 0px;">
          <input type="checkbox" class="checkbox style-0" name="jVPartner" ng-model="ConsigneeMasterData.jVPartner" ng-disabled="disabled">
          <i></i>
          JV Partner
         </label> -->
									<!--                 <label class="i-checks checkbox-inline" style="margin-left: 0px;">
            <input type="checkbox" class="checkbox style-0"  name="subSlot" ng-model="ConsigneeMasterData.subSlot">
            <i></i>Sub Slot
           </label> -->
								</div>
							</div>
						</div>
						<div class="form-group" ng-if="ConsigneeMasterData.jVPartner">
							<label class="col-md-4 control-label"> JV Type <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" name="ShareofRVC"
									ng-true-value="'ShareofRVC'" ng-false-value="''"
									ng-model="ConsigneeMasterData.shareOfRVC" ng-disabled="disabled">
									<i></i> Share of RVC
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" name="SlotSwap"
									ng-true-value="'SlotSwap'" ng-false-value="''"
									ng-disabled="disabled" ng-model="ConsigneeMasterData.slotSwap">
									<i></i> Slot Swap
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" name="CRSS"
									ng-true-value="'CRSS'" ng-false-value="''"
									ng-disabled="disabled"
									ng-model="ConsigneeMasterData.costRevenueSpaceShare"> <i></i>
									Cost / Revenue / Space Sharing
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" class="checkbox style-0" name="DeadFreight"
									ng-true-value="'DeadFreight'" ng-false-value="''"
									ng-disabled="disabled"
									ng-model="ConsigneeMasterData.deadFreight"> <i></i> Dead
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
									ng-model="ConsigneeMasterData.paymentCenter"
									property="ConsigneeMasterData.paymentCenter" id="paymentCenter"
									object="paymentCenter" name="paymentCenter"
									friendly-name="Payment Center" validation="required"
									form-name="ConsigneeMasterForm"></selectivity>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Active </label>
							<div class="col-md-5">
								<div class="checkbox">
									<label class="i-checks"> <input type="checkbox"
										class="checkbox style-0" ng-disabled="disabled" name="active"
										ng-model="ConsigneeMasterData.active" ng-true-value="'Y'"
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
          <input type="checkbox" class="checkbox style-0" ng-disabled="disabled" name="slotOperator" ng-model="ConsigneeMasterData.slotOperator" ng-true-value="'Y'" ng-false-value="'N'">
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
									ng-model="ConsigneeMasterData.emailBooking" ng-true-value="'B'"
									ng-disabled="disabled" ng-false-value="''"> <i></i>
									Booking
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="pricing"
									ng-model="ConsigneeMasterData.emailPricing" ng-true-value="'P'"
									ng-disabled="disabled" ng-false-value="''"> <i></i>
									Pricing/Sales
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="operations"
									ng-model="ConsigneeMasterData.emailOperations"
									ng-true-value="'O'" ng-disabled="disabled" ng-false-value="''">
									<i></i> Operations
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="finance"
									ng-model="ConsigneeMasterData.emailFinance" ng-true-value="'F'"
									ng-disabled="disabled" ng-false-value="''"> <i></i>
									Finance
								</label>
							</div>
						</div>
						<!--   <div class="form-group">
       <label class="col-md-4 control-label">BL Related </label>
       <div class="col-md-5">
        <label class="i-checks">
         <input type="checkbox" name="blRelated" ng-model="ConsigneeMasterData.blRelated" ng-true-value="'Y'" ng-disabled="disabled" ng-false-value="'N'">
         <i></i>
        </label>
       </div>
      </div> -->
						<div class="form-group">
							<label class="col-md-4 control-label">City </label>
							<div class="col-md-5">
								<selectivity list="portList" ng-model="ConsigneeMasterData.city"
									property="ConsigneeMasterData.city" disabled="disabled"
									id="city" object="city" name="city" friendly-name="City  Name"
									form-name="ConsigneeMasterForm"></selectivity>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Attached File
								Format </label>
							<div class="col-md-5">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="ConsigneeMasterData.attachFileGroup"
										ng-disabled="disabled" value="P" name="attachFileGroup"
										checked="checked"> <i></i> PDF
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="ConsigneeMasterData.attachFileGroup"
										ng-disabled="disabled" value="E" name="attachFileGroup"
										checked="checked"> <i></i> EDI
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0"
										ng_model="ConsigneeMasterData.attachFileGroup"
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
          <input type="radio" class="radiobox style-0" name="isVesselGrp" ng-disabled="disabled" ng_model="ConsigneeMasterData.isVesselGrp" value="Y">
          <i></i>
          Yes
         </label>
        </div>
        <div class="radio  radio-inline">
         <label class="i-checks">
          <input type="radio" class="radiobox style-0" name="isVesselGrp" ng-disabled="disabled" ng_model="ConsigneeMasterData.isVesselGrp" value="N" checked="checked" name="gear">
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
							<label class="col-md-4 control-label"> Consignee ShortName
								<span style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm text-uppercase"
									name="Consignee Short Name"
									ng-model="ConsigneeMasterData.ConsigneeShortName"
									message-id="ConsigneeShortName" id="txtConsigneeShortName"
									validation="required" friendly-name="Consignee Short Name"
									form-name="ConsigneeMasterForm" maxlength="50"
									ng-disabled="disabled"
									typeahead="r.id as r.id for r in ConsigneeShortNameList| filter:$viewValue |limitTo:10 | concatConsigneeShortName:$viewValue"
									typeahead-min-length='1' />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Address1 </label>
							<div class="col-md-5">


								<textarea data-ng-model="ConsigneeMasterData.address1"
									id="address1" name="Address1"
									class="form-control custom-scroll width_100 textareath"
									rows="2" maxlength="200" friendly-name="Address1"
									ng-disabled="disabled">
			            </textarea>


								<!--    
       <textarea data-ng-model="ConsigneeMasterData.address1" id="address1" name="Address1" class="custom-scroll width_100 textareath" rows="3"
         friendly-name="Address1" maxlength="200" ng-disabled="disabled" >
	            </textarea>
			             -->
							</div>
						</div>
						<!--  <selectivity list="typeofConsigneeList" property="ConsigneeMasterData.typeofConsignee" id="typeofConsignee_id" disabled="true"></selectivity> -->
						<!--   <input type="hidden" class="text-right form-control input-sm pull-right"  id="typeofConsignee_id" value="Consignee" disabled> -->
						<div class="form-group">
							<label class="col-md-4 control-label">Tel Office No </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									ng-disabled="disabled" name="Tel Office No"
									ng-model="ConsigneeMasterData.telOfficeNum" id="telOfficeNum"
									maxlength="40">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Telex No </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									ng-disabled="disabled" name="Telex No"
									ng-model="ConsigneeMasterData.telexNum" id="telexNum"
									maxlength="20">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Cr-Limit(USD) <span
								style="color: red;">*</span></label>
							<div class="col-md-5">
								<input type="text" text-align="right" placeholder="0.00"
									class="text-right form-control input-sm pull-right"
									name="Cr-Limit(USD)" ng-model="ConsigneeMasterData.crLimit"
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
									ng-model="ConsigneeMasterData.exchangeRate" id="exchangeRate">
							</div>
						</div>
						<!--  <div class="form-group">
       <label class="col-md-4 control-label"> Booking Contact Person Email </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Booking Contact Person Email" ng-model="ConsigneeMasterData.bookingCntctPrsnEmail"
         maxlength="500" id="bookingCntctPrsnEmail">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Pricing/Sales Contact Person Email </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Pricing/Sales Contact Person Email" ng-model="ConsigneeMasterData.pricingCntctPrsnEmail"
         maxlength="500" id="pricingCntctPrsnEmail">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Operations Contact Person Email </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Operations Contact Person Email" ng-model="ConsigneeMasterData.operationsCntctPrsnEmail"
         id="operationsCntctPrsnEmail" validator="email" valid-method="submit" message-id="operationsCntctPrsnEmail" maxlength="500">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Finance Contact Person Email </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Finance Contact Person Email" ng-model="ConsigneeMasterData.financeCntctPrsnEmail"
         id="financeCntctPrsnEmail" validator="email" valid-method="submit" maxlength="500" message-id="financeCntctPrsnEmail">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Fax Num </label>
       <div class="col-md-5">
        <input type="text" class="form-control input-sm" ng-disabled="disabled" name="Fax No" id="faxNum" ng-model="ConsigneeMasterData.faxNum" maxlength="20">
       </div>
      </div> -->

						<div class="form-group">
							<label class="col-md-4 control-label"> Invoice Email Id </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="Fax No"
									ng-disabled="disabled" id="faxNum"
									ng-model="ConsigneeMasterData.invoiceEmailId" maxlength="500">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label"> Consignee Category
								<span style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<!--      <selectivity list="ConsigneeCategoryList" property="ConsigneeMasterData.Consignee_category" id="Consignee_category_id"></selectivity> -->
								<selectivity list="ConsigneeCategoryList" disabled="disabled"
									ng-model="ConsigneeMasterData.Consignee_category"
									property="ConsigneeMasterData.Consignee_category"
									id="Consignee_category" object="Consignee_category"
									validation="required" name="Consignee_category"
									friendly-name="Consignee Category"
									form-name="ConsigneeMasterForm"></selectivity>
							</div>
						</div>
						<!--   <div class="form-group">
       <label class="col-md-4 control-label">SubSlot </label>
       <div class="col-md-5">
        <div class="checkbox">
         <label class="i-checks">
          <input type="checkbox" class="checkbox style-0" ng-disabled="disabled" name="subSlot" ng-model="ConsigneeMasterData.subSlot" ng-true-value="'Y'" ng-false-value="'N'">
          <i></i>
         </label>
        </div>
       </div>
      </div> -->
						<!--   <div class="form-group">
       <label class="col-md-4 control-label">Credit Consignee Type </label>
       <div class="col-md-5">
        <div class="checkbox">
         <label class="i-checks">
          <input type="checkbox" name="creditCustType" ng-disabled="disabled" ng-model="ConsigneeMasterData.creditCustType" ng-true-value="'Y'" ng-false-value="'N'">
          <i></i>
         </label>
        </div>
       </div>
      </div> -->
						<div class="form-group">
							<label class="col-md-4 control-label">Type Of Consignee </label>
							<div class="col-md-7">
								<div class="radio radio-inline" style="padding-left: 0px;">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="ConsigneeMasterData.typeOfCustGrp" value="C"
										name="typeOfCustGrp" checked="checked"> <i></i> Credit
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="ConsigneeMasterData.typeOfCustGrp" value="P"
										name="typeOfCustGrp" checked="checked"> <i></i> Prior
										Loading
									</label>
								</div>
								<div class="radio radio-inline">
									<label class="i-checks"> <input type="radio"
										class="radiobox style-0" ng-disabled="disabled"
										ng_model="ConsigneeMasterData.typeOfCustGrp" value="D"
										name="typeOfCustGrp" checked="checked"> <i></i>
										Deposit Check
									</label>
								</div>
							</div>
						</div>
						<div class="form-group"
							ng-if="ConsigneeMasterData.typeOfCustGrp=='C'">
							<div class="col-md-6">
								<label class="col-md-7 control-label"> Credit Amount <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="text-right form-control input-sm"
										ng-disabled="disabled" placeholder="0.00" name="Credit Amount"
										ng-model="ConsigneeMasterData.creditLimitAmt">
								</div>
							</div>
							<div class="col-md-6">
								<label class="col-md-7 control-label"> Credit Days <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<input type="text" class="text-right form-control input-sm"
										ng-disabled="disabled" placeholder="0.00" name="Credit Days"
										ng-model="ConsigneeMasterData.creditLimitDays">
								</div>
							</div>
						</div>
						<div class="form-group"
							ng-if="ConsigneeMasterData.typeOfCustGrp=='D'">
							<label class="col-md-4 control-label"> Deposit Amount <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<input type="text" class="text-right form-control input-sm"
									placeholder="0.00" name="Deposit Amount"
									ng-model="ConsigneeMasterData.depositAmt"
									message-id="depositAmt" id="depositAmt" validator="required"
									ng-disabled="disabled" valid-method="submit">
							</div>
						</div>
						<!-- <div class="form-group">
       <label class="col-md-4 control-label">Company Type </label>
       <div class="col-md-7">
        <div class="radio radio-inline" style="padding-left: 0px;">
         <label class="i-checks">
          <input type="radio" class="radiobox style-0" ng-disabled="disabled" ng_model="ConsigneeMasterData.companyTypeGrp" value="MLO" name="companyTypeGrp" checked="checked">
          <i></i>
          MLO
         </label>
        </div>
        <div class="radio radio-inline">
         <label class="i-checks">
          <input type="radio" class="radiobox style-0"  ng-disabled="disabled" ng_model="ConsigneeMasterData.companyTypeGrp" value="NVOCC" name="companyTypeGrp" checked="checked">
          <i></i>
          NVOCC
         </label>
        </div>
        <div class="radio radio-inline">
         <label class="i-checks">
          <input type="radio" class="radiobox style-0" ng-disabled="disabled" ng_model="ConsigneeMasterData.companyTypeGrp" value="JV" name="Company TypeGrp" checked="checked">
          <i></i>
          JV
         </label>
         <div class="radio radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0" ng-disabled="disabled" ng_model="ConsigneeMasterData.companyTypeGrp" value="AGENT" name="companyTypeGrp" checked="checked">
           <i></i>
           AGENT
          </label>
         </div>
        </div>
       </div>
      </div> -->
						<div class="form-group "
							ng-if="ConsigneeMasterData.companyTypeGrp=='NVOCC'">
							<label class="col-md-4 control-label"> Category <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list="categoryWiseList"
									property="ConsigneeMasterData.categoryWise"
									ng-disabled="disabled" id="categoryWise"
									friendly-name="Category" form-name="ConsigneeMasterForm">
							</div>
							<!--    <div class="col-md-5">
	          <selectivity list="categoryWiseList" property="ConsigneeMasterData.categoryWise" id="categoryWise"
	             validation="required" friendly-name= "Consignee Category" form-name = "ConsigneeMasterForm" >
	              </div> -->
						</div>
						<!--  <div class="form-group">
       <label class="col-md-4 control-label"> Controlling Agent </label>
       <div class="col-md-5">
        <selectivity list="controllingAgentList" property="ConsigneeMasterData.controllingAgent" disabled="disabled" id="controllingAgent" friendly-name="Consignee Category"
         form-name="ConsigneeMasterForm">
       </div>
      </div>
      <div class="form-group">
       <label class="col-md-4 control-label"> Related Party </label>
       <div class="col-md-5">
        <label class="i-checks">
         <input type="checkbox" class="checkbox style-0" name="relatedParty" ng-disabled="disabled" ng-model="ConsigneeMasterData.relatedParty" ng-true-value="'Y'" ng-false-value="'N'">
         <i></i>
        </label>
       </div>
      </div> -->

						<div class="form-group">
							<label class="col-md-4 control-label">Bank Name </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="bankName"
									ng-disabled="disabled" friendly-name="Bank Name"
									ng-model="ConsigneeMasterData.bankName"
									form-name="ConsigneeMasterForm">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Bank Account Number

							</label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm"
									name="accountNumber" ng-disabled="disabled"
									friendly-name="Bank Account Number"
									ng-model="ConsigneeMasterData.accountNumber"
									form-name="ConsigneeMasterForm">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">RTGS </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="bankRTGS"
									ng-disabled="disabled" friendly-name="Bank RTGS"
									ng-model="ConsigneeMasterData.bankRTGS"
									form-name="ConsigneeMasterForm">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label">Consignee VAT </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="vatNum"
									friendly-name="VAT" ng-disabled="disabled"
									ng-model="ConsigneeMasterData.vatNum"
									form-name="ConsigneeMasterForm">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Trade Regn No </label>
							<div class="col-md-5">
								<input type="text" class="form-control input-sm" name="cinNum"
									friendly-name="CIN" ng-disabled="disabled"
									ng-model="ConsigneeMasterData.cinNum"
									form-name="ConsigneeMasterForm">
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
              <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="ConsigneeVoyage in displayedCollection track by $index">
               <td class="width_1 text-center">
                <label class="i-checks m-b-none">
                 <input type="checkbox" name="post[]" ng-model="ConsigneeVoyage.checked" class="bulk-delete">
                 <i></i>
                </label>
               </td>
               <td class="width_1 text-center">{{$index+1}}</td>
               <td class="width_20">
                <div class="col-md-6" style="width: 100%">
                 <selectivity list="portList" property="ConsigneeVoyage.polCode" id="polCode{{$index}}" 
                  ng-model="ConsigneeVoyage.polCode" name ="polCode{{$index}}" validation="required"
          friendly-name="{{ 'Row' + $index + '(POL)'}}" form-name = "ConsigneeMasterForm"></selectivity>
                </div>
               </td>
               <td class="width_20">
                <div class="col-md-6" style="width: 100%">
                <selectivity list="portList" property="ConsigneeVoyage.podCode" id="podCode{{$index}}" 
                  ng-model="ConsigneeVoyage.podCode" name ="podCode{{$index}}" validation="required"
          friendly-name="{{ 'Row' + $index + '(POD)'}}" form-name = "ConsigneeMasterForm"></selectivity>
                 
                </div>
               </td>
               <td class="width_20">
                <div class="col-md-6" style="width: 100%">
                 <selectivity list="payerList" ng-model="ConsigneeVoyage.payerCode" property="ConsigneeVoyage.payerCode" id="payerCode{{$index}}" name ="payerCode{{$index}}" validation="required"
										friendly-name="{{ 'Row' + $index + '(Payer)'}}" form-name = "ConsigneeMasterForm"></selectivity>
                </div>
               </td>
               <td class="width_20  text-center">
                <input type="text" class="form-control input-sm" name="Email" ng-model="ConsigneeVoyage.email" validator="email" valid-method="submit"
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
						<!-- <button class="btn btn-success btn-sm" data-ng-click="saveData(ConsigneeMasterForm,ConsigneeMasterData)">
	        <i class="fa fa-save"></i> Save
	       </button> -->
						<button class="btn btn-success"
							ng-if="!ConsigneeMasterEditData.conIdEdit"
							ng-click=saveData(ConsigneeMasterForm,ConsigneeMasterData,displayedCollection)
							type="button">
							<i class="fa fa-save"></i> Save And Continue
						</button>
						<button class="btn btn-success"
							ng-if="ConsigneeMasterEditData.conIdEdit"
							ng-click=saveData(ConsigneeMasterForm,ConsigneeMasterData,displayedCollection)
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
<div class="modal-header"> Consignee Master Algorithm </div>
<div class="row">
<div class="width_90 m-n-auto">
	<iframe title='Consignee Master Algorithm' class=''
        width='625' height='500' src='assets/algorithm_Docs/Customer_Master_Algorithm.pdf'
         allowfullscreen='true' frameborder='0' align="center"></iframe>
</div>
</div>
<div class="modal-footer">
	<button class="btn btn-danger" ng-click="closeHelpDialog()">Close</button>
</div>
</script>
