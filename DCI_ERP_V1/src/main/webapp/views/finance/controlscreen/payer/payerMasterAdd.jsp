<style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li{background-color:#3B8A8A;}
.ngdialog-content{
	width: 50% !important;
  	bottom: 160px !important;
  	margin: 0 auto !important;
}


.table {
 height: 40px !important;
}

.contDiv {
 width: 100%;
 padding: auto;
 margin: auto;
 height: 400px;
}

.heaaderDiv {
 width: 100%;
 overflow: auto;
 height: 400px;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
	<%@include file="/views/templates/panel-header-form.jsp"%>
		<!-- <div class="panel-heading panel-heading-form font-bold">
		   	<ol class="breadcrumb inline-block padding-left-0">
		    <li>
		     <a>Master</a>
		    </li>
		    <li>
		     <a x-ui-sref="app.finance.controlscreen">Control Screen</a>
		    </li>
		    <li>
		     <a x-ui-sref="app.finance.controlscreen.customer">Payer List</a>
		    </li>
		    <li>
		     <a x-ui-sref="app.finance.controlscreen.customer-add">Add</a>
		    </li>
		   	</ol> -->
	 	</div>
		<tabset justified="true" class="tab-container">
   			<tab heading="{{tabs[0].title}}">
				<div class="panel-body">
				  <form name="customerMasterForm" class="form-horizontal" novalidate>
				    <div class="row">
				     <div class="col-sm-12 col-md-12 col-lg-6">
				      <fieldset>
				        <div class="form-group" ng-if="customerMasterEditData.conIdEdit">
				          <label class="col-md-4 control-label">Payer ID<span style="color: red;"></span></label>
				          <div class="col-md-5">
				           <label class="col-md-6 control-label" ng-if="customerMasterEditData.isEdit" ng-bind="CustomerMasterData.customerCode"></label>
				          </div>
				         </div>
					       <div class="form-group">
					        <label class="col-md-4 control-label">
					         Payer Name
					         <span style="color: red;">*</span>
					        </label>
					        <div class="col-md-5">
					         <!-- <input type="text" class="form-control input-sm" name="Customer Name" data-ng-model="CustomerMasterData.customerName"
					         id="customerName"  name = "customerName" friendly-name="Customer Name" validation="required" > -->
					         
							<input type="text" class="form-control input-sm" id="txtCustomerName" name="Payer Name"  
							ng-model="CustomerMasterData.customerName" 
								validation="required" friendly-name="Payer Name" form-name="customerMasterForm"
								typeahead="ac.customerName as ac.customerName for ac in payerTypeHeadList| filter:$viewValue |limitTo:10 | concatPayerName: $viewValue"  
								typeahead-min-length='1' typeahead-input-formatter="fetchSelectedPayerName($model,CustomerMasterData)" maxlength="100"/>
					        </div>
					       </div>
				 			<div class="form-group">
				           <label  class="control-label col-md-4">Address
				            <span style="color: red;">*</span>
				            </label>
				           <div class="col-md-5">
				                   <textarea data-ng-model="CustomerMasterData.address" id="address"  name="Address" 
				            		class="custom-scroll width_100 textareath" rows="2"  
				            		friendly-name="Address"  validation="required" maxlength="200"></textarea>
				           </div>
				          </div>
				         <div class="form-group">
				        <label class="col-md-4 control-label">
				         Area
				           <span style="color: red;">*</span>
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Area" id="area"  name="area" ng-model="CustomerMasterData.area"
				        friendly-name="Area" validation="required" maxlength="50" />
				        </div>
				       </div>
				       <div class="form-group">
					        <label class="col-md-4 control-label">
					         Payment Country
					           <span style="color: red;">*</span>
					        </label>
					        <div class="col-md-5">
					             <selectivity list="countryList" id="countryName" name="countryName" data-ng-model="CustomerMasterData.countryName"
					             property="CustomerMasterData.countryName" object="countryName" validation="required" friendly-name="Country Name" form-name="customerMasterForm" maxlength="50"></selectivity> 
					        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">
				         Fax No
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Fax No" ng-model="CustomerMasterData.faxNo"
				         id="faxNo" maxlength="20"/>
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">
				         Email
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Email" ng-model="CustomerMasterData.email" id="email" maxlength="500"/>
				        </div>
				       </div>
				       <div class="form-group">
					        <label class="col-md-4 control-label">Currency<span style="color: red;">*</span></label>
					        <div class="col-md-5">
					    		<selectivity list="currencyList" ng-model="CustomerMasterData.currency"
					             property="CustomerMasterData.currency" id="currency"  object="currency"  name="currency"
					             validation="required" friendly-name="Currency" form-name="customerMasterForm"></selectivity> 
					        </div>
				       </div>		 
                  <div class="form-group">
               <label class="col-md-4 control-label">Sales Person</label>
                <div class="col-md-5">
                 <input type="text" class="form-control input-sm"
             ng-model="CustomerMasterData.salesPerson" id="salesPerson" />
            </div>
            <!--    <selectivity list="employeeList" ng-model="CustomerMasterData.salesPerson"
                  property="CustomerMasterData.salesPerson" id="salesPerson"  object="salesPerson"  name="salesPerson"
                   form-name="customerMasterForm"></selectivity>  -->
                 </div>
            		
				       <div class="form-group">
				        <label class="col-md-4 control-label">
				         Booking Contact Person
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Booking Contact Person" 
				         ng-model="CustomerMasterData.bookingCntctPrsn" id="bookingCntctPrsn" maxlength="100"/>
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">
				         Pricing/Sales Contact Person
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Pricing/Sales Contact Person" 
				         ng-model="CustomerMasterData.pricingCntctPrsn" id="pricingCntctPrsn" maxlength="100"/>
				        </div>
				       </div>
				
				       <div class="form-group">
				        <label class="col-md-4 control-label">
				         Operations Contact Person
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Operations Contact Person" 
				         ng-model="CustomerMasterData.operationsCntctPrsn" id="operationsCntctPrsn" maxlength="100"/>
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">
				         Finance Contact Person
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Finance Contact Person" 
				         ng-model="CustomerMasterData.financeCntctPrsn" id="financeCntctPrsn" maxlength="100"/>
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">Tel Number
				         </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Tel Number"  
				         ng-model="CustomerMasterData.teleNumber"  id="teleNumber" maxlength="20" />
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">Type
				         </label>
				        <div class="col-md-7">
				           <div class="checkbox">
				          <label class="i-checks checkbox-inline">
				           <input type="checkbox" class="checkbox style-0"  name="shipper" ng-model="CustomerMasterData.shipper" />
				           <i></i>Shipper
				          </label>
				
				
				          <label class="i-checks checkbox-inline">
				           <input type="checkbox" class="checkbox style-0"  name="consignee" ng-model="CustomerMasterData.consignee" />
				           <i></i>Consignee
				          </label>
				
				
				          <label class="i-checks checkbox-inline">
				           <input type="checkbox" class="checkbox style-0"  name="notifyParty" ng-model="CustomerMasterData.notifyParty" />
				           <i></i>Notify Party
				          </label>
				
				             <label class="i-checks checkbox-inline">
				           <input type="checkbox" class="checkbox style-0"  name="agreementParty"  ng-model="CustomerMasterData.agreementParty" />
				           <i></i>Agreement Party
				          </label>
				             <label class="i-checks checkbox-inline" style="margin-left: 0px;">
				           <input type="checkbox" class="checkbox style-0"  name="jVPartner" ng-model="CustomerMasterData.jVPartner" />
				           <i></i>JV Partner
				          </label>
				        </div>
				       </div>
				       </div>
				
				       <div class="form-group" ng-if="CustomerMasterData.jVPartner">
				        <label class="col-md-4 control-label"> JV Type
				         <span style="color: red;">*</span>
				         </label>
				        <div class="col-md-5">
				         <label class="i-checks checkbox-inline">
				           <input type="checkbox" class="checkbox style-0"  name="ShareofRVC"  ng-true-value="'ShareofRVC'" ng-false-value="''" ng-model="CustomerMasterData.shareOfRVC" />
				           <i></i>Share of RVC
				          </label>
				           <label class="i-checks checkbox-inline">
				           <input type="checkbox" class="checkbox style-0"  name="SlotSwap" ng-true-value="'SlotSwap'" ng-false-value="''" ng-model="CustomerMasterData.slotSwap" />
				           <i></i>Slot Swap
				          </label>
				           <label class="i-checks checkbox-inline">
				           <input type="checkbox" class="checkbox style-0"  name="CRSS" ng-true-value="'CRSS'"  ng-false-value="''" ng-model="CustomerMasterData.costRevenueSpaceShare" />
				           <i></i>Cost / Revenue / Space Sharing
				          </label>
				           <label class="i-checks checkbox-inline">
				           <input type="checkbox" class="checkbox style-0"  name="DeadFreight" ng-true-value="'DeadFreight'" ng-false-value="''" ng-model="CustomerMasterData.deadFreight" />
				           <i></i>Dead Freight
				          </label>
				        </div>
				       </div>
				
				       <div class="form-group">
				        <label class="col-md-4 control-label">Payment Center
				         <span style="color: red;">*</span>
				         </label>
				        <div class="col-md-5">      
				            <selectivity list="paymentCenterList" ng-model="CustomerMasterData.paymentCenter"
				             property="CustomerMasterData.paymentCenter" id="paymentCenter"  object="paymentCenter"  name="paymentCenter"
				            validation = "required" friendly-name="Payment Center" form-name="customerMasterForm"></selectivity> 
				        </div>
				       </div>
				 	   <div class="form-group">
				        <label class="col-md-4 control-label">Active
				         </label>
				        <div class="col-md-5">
				           <div class="checkbox">
				          <label class="i-checks">
				           <input type="checkbox" class="checkbox style-0"  name="active" ng-model="CustomerMasterData.active"
				            ng-true-value="'Y'" ng-false-value="'N'">
				           <i></i>
				          </label>
				         </div>
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">Slot Operator
				         </label>
				        <div class="col-md-5">
				         <div class="checkbox">
				          <label class="i-checks">
				           <input type="checkbox" class="checkbox style-0"  name="slotOperator" ng-model="CustomerMasterData.slotOperator"
				            ng-true-value="'Y'" ng-false-value="'N'">
				           <i></i>
				          </label>
				         </div>
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">Email
				         </label>
				        <div class="col-md-7">
				         <label class="i-checks checkbox-inline">
				         <input type="checkbox"  name="booking"  ng-model="CustomerMasterData.emailBooking" ng-true-value="'B'"  ng-false-value="''">
				         <i></i>Booking</label>
				         <label class="i-checks checkbox-inline">
				         <input type="checkbox"  name="pricing"  ng-model="CustomerMasterData.emailPricing" ng-true-value="'P'" ng-false-value="''">
				         <i></i>Pricing/Sales</label>
				         <label class="i-checks checkbox-inline">
				         <input type="checkbox"  name="operations"  ng-model="CustomerMasterData.emailOperations"  ng-true-value="'O'" ng-false-value="''">
				         <i></i>Operations</label>
				         <label class="i-checks checkbox-inline">
				         <input type="checkbox"  name="finance"  ng-model="CustomerMasterData.emailFinance" ng-true-value="'F'" ng-false-value="''">
				         <i></i>Finance</label>
				        </div>
				       </div>
						<div class="form-group">
				        <label class="col-md-4 control-label">BL Related
				         </label>
				        <div class="col-md-5">
				         <label class="i-checks">
				         <input type="checkbox"  name="blRelated"  ng-model="CustomerMasterData.blRelated" ng-true-value="'Y'" ng-false-value="'N'" />
				         <i></i></label>
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">Related Party
				         </label>
				        <div class="col-md-5">
				         <label class="i-checks">
				         <input type="checkbox"  name="relatedParty"  ng-model="CustomerMasterData.relatedParty" ng-true-value="'Y'" ng-false-value="'N'" />
				         <i></i></label>
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">City
				         </label>
				        <div class="col-md-5">    
				              <selectivity list="portList" ng-model="CustomerMasterData.city"
				             property="CustomerMasterData.city" id="city"  object="city"  name="city"
				              friendly-name="City  Name" form-name="customerMasterForm"></selectivity> 
				        </div>
				       </div>
 	

				      </fieldset>
				     </div>
				     <div class="col-sm-12 col-md-12 col-lg-6">
				      <fieldset>
				      
				      <div class="form-group" ng-if="customerMasterEditData.conIdEdit">
        <label class="col-md-4 control-label">
        </label>
        <div class="col-md-5">
        </div>
       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">Payer ShortName
				         <span style="color: red;">*</span>
				        </label>
				        <div class="col-md-5">
				   			<input type="text" class="form-control input-sm" name="Customer Short Name" ng-model="CustomerMasterData.customerShortName"
					          id="customerName" validator="required" maxlength="50"
				               typeahead="r.id as r.id for r in customerShortNameList| filter:$viewValue |limitTo:10 | concatPayerShortName: $viewValue"  typeahead-min-length='1'  />
				        </div>
				       </div>
				       <div class="form-group">
				        <label class="col-md-4 control-label">Address1
				        <!--  <span style="color: red;">*</span> -->
				        </label>
				        <div class="col-md-5">
				             <textarea data-ng-model="CustomerMasterData.address1" id="address1"  name="Address1" 
				            class="custom-scroll width_100 textareath" rows="2"  friendly-name="Address1"  maxlength="200">
				            </textarea>
				        </div>
				       </div>
				       <!--  <selectivity list="typeofCustomerList" property="CustomerMasterData.typeofCustomer" id="typeofCustomer_id" disabled="true"></selectivity> -->
				        <input type="hidden" class="text-right form-control input-sm pull-right"  id="typeofCustomer_id" value="PAYER" disabled />
				
				   		<div class="form-group">
				        <label class="col-md-4 control-label">Tel Office No
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Tel Office No"  ng-model="CustomerMasterData.telOfficeNum" id="telOfficeNum" maxlength="40" />
				        </div>
				       </div>
				          		<div class="form-group">
				        <label class="col-md-4 control-label">Telex No
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Telex No"  ng-model="CustomerMasterData.telexNum" id="telexNum" maxlength="20"/>
				        </div>
				       </div>
				
				          		<div class="form-group">
				        <label class="col-md-4 control-label">Cr-Limit(USD)
				        </label>
				        <div class="col-md-5">
				         <input type="text" text-align="right" placeholder="0.00"  class="text-right form-control input-sm pull-right" 
				         name="Cr-Limit(USD)"  ng-model="CustomerMasterData.crLimit" id="crLimit" />
				        </div>
				       </div>
				
				        		<div class="form-group">
				        <label class="col-md-4 control-label">Exchange Rate
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm text-right" name="Exchange Rate"  
				         ng-model="CustomerMasterData.exchangeRate"  id="exchangeRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"/>
				        </div>
				       </div>
				
				        <div class="form-group">
				        <label class="col-md-4 control-label">
				         Booking Contact Person Email
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Booking Contact Person Email" 
				         ng-model="CustomerMasterData.bookingCntctPrsnEmail" id="bookingCntctPrsnEmail" maxlength="100" />
				        </div>
				       </div>
				
				        <div class="form-group">
				        <label class="col-md-4 control-label">
				         Pricing/Sales Contact Person Email
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Pricing/Sales Contact Person Email" 
				         ng-model="CustomerMasterData.pricingCntctPrsnEmail" id="pricingCntctPrsnEmail" maxlength="100"/>
				        </div>
				       </div>
				
				            <div class="form-group">
				        <label class="col-md-4 control-label">
				         Operations Contact Person Email
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Operations Contact Person Email" ng-model="CustomerMasterData.operationsCntctPrsnEmail" id="operationsCntctPrsnEmail"
				         validator="email" maxlength="100"/>
				        </div>
				       </div>
				        <div class="form-group">
				        <label class="col-md-4 control-label">
				         Finance Contact Person Email
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Finance Contact Person Email" 
				         ng-model="CustomerMasterData.financeCntctPrsnEmail" id="financeCntctPrsnEmail"  maxlength="700"/>
				        </div>
				       </div>
			<!-- 	data-ng-change= "checkEmails();" -->
				            <div class="form-group">
				        <label class="col-md-4 control-label">
				        Fax Num
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="form-control input-sm" name="Fax No" id="faxNum" ng-model="CustomerMasterData.faxNum" maxlength="20"/>
				        </div>
				       </div>
				
				            <!-- <div class="form-group">
				        <label class="col-md-4 control-label">
				        Payer Category
				          
				        </label>
				        <div class="col-md-5">
		                       <selectivity list="customerCategoryList" ng-model="CustomerMasterData.customer_category"
					             property="CustomerMasterData.customer_category" id="customer_category"  object="customer_category"  
					             name="customer_category" friendly-name="Payment Category" form-name="customerMasterForm"></selectivity> 
				
				        </div>
				       </div> -->
				
				        <div class="form-group">
				        <label class="col-md-4 control-label">Credit Payer Type
				         </label>
				        <div class="col-md-5">
				          <div class="checkbox">
				          <label class="i-checks">
				         <input type="checkbox"  name="creditCustType"  ng-model="CustomerMasterData.creditCustType" ng-true-value="'Y'" ng-false-value="'N'" >
				         <i></i></label>
				        </div>
				       </div>
				       </div>
				     <div class="form-group">
				        <label class="col-md-4 control-label">Type Of Payer
				        </label>
				        <div class="col-md-7">
				          <div class="radio radio-inline" style="padding-left: 0px;">
				           <label class="i-checks">
				           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.typeOfCustGrp" value="C" name="typeOfCustGrp"
				            checked="checked"  >
				           <i></i>Credit
				          </label>
				          </div>
				          <div class="radio radio-inline">
				          <label class="i-checks">
				           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.typeOfCustGrp" value="P" name="typeOfCustGrp"
				            checked="checked" >
				           <i></i>Prior Loading
				          </label>
				          </div>
				          <div class="radio radio-inline">
				          <label class="i-checks">
				           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.typeOfCustGrp" value="D" name="typeOfCustGrp"
				            checked="checked" >
				           <i></i>Deposit Cheque
				          </label>
				          </div>
				        </div>
				       </div>
                 <div class="form-group" ng-if="CustomerMasterData.typeOfCustGrp=='C' || CustomerMasterData.typeOfCustGrp=='D'">
       <div class="col-md-6">
        <label class="col-md-7 control-label">
         Credit Amount
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
        <input type="text" class="form-control input-sm" id="creditLimitAmt" name="creditLimitAmt"  
       ng-model="CustomerMasterData.creditLimitAmt" 
        validation="required" friendly-name="Credit Amount" form-name="customerMasterForm" placeholder="0.00"
        >
        
         <!-- <input type="text" class="text-right form-control input-sm"  form-name="customerMasterForm" friendly-name="Credit Amount" id="creditLimitAmt" validator="required" placeholder="0.00" name="Credit Amount" ng-model="CustomerMasterData.creditLimitAmt"> -->
        </div>
       </div>
       <div class="col-md-6">
        <label class="col-md-7 control-label">
         Credit Days
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
        <input type="text" class="form-control input-sm" id="creditLimitDays" name="creditLimitDays"  
       ng-model="CustomerMasterData.creditLimitDays" 
        validation="required" friendly-name="Credit Days" form-name="customerMasterForm" placeholder="0"
        >
        
         <!-- <input type="text" class="text-right form-control input-sm"  form-name="customerMasterForm" friendly-name="Credit Days" id="creditLimitDays" validator="required" placeholder="0" name="Credit Days" ng-model="CustomerMasterData.creditLimitDays"> -->
        </div>
       </div>
      </div>
				        <div class="form-group" ng-if="CustomerMasterData.typeOfCustGrp=='D'">
				        <label class="col-md-4 control-label">
				       Deposit Amount
				           <span style="color: red;">*</span>
				        </label>
				        <div class="col-md-5">
				         <input type="text" class="text-right form-control input-sm" placeholder="0.00" 
				         name="Deposit Amount" ng-model="CustomerMasterData.depositAmt"
				         friendly-name="Deposit Amount" id="depositAmt" validation="required" />
				        </div>
				       </div>
				
				           <div class="form-group">
				        <label class="col-md-4 control-label">Payer Type
				
				        </label>
				        <div class="col-md-7">
				         <div class="radio radio-inline" style="padding-left: 0px;">
				           <label class="i-checks">
				           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.companyTypeGrp" value="MLO" name="companyTypeGrp"
				            checked="checked" />
				           <i></i>MLO
				          </label>
				          </div>
				          <div class="radio radio-inline">
				           <label class="i-checks">
				           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.companyTypeGrp" value="NVOCC" name="companyTypeGrp"
				            checked="checked" />
				           <i></i>NVOCC
				          </label>
				          </div>
				          <div class="radio radio-inline">
				          <label class="i-checks">
				           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.companyTypeGrp" value="JV" name="Company TypeGrp"
				            checked="checked" />
				          <i></i>JV
				          </label>
				          <div class="radio radio-inline">
				            <label class="i-checks">
				           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.companyTypeGrp" value="AGENT" name="companyTypeGrp"
				            checked="checked" />
				           <i></i>AGENT
				          </label>
				          </div>
				          </div>
				        </div>
				       </div> 
				       <div class="form-group" ng-if="CustomerMasterData.companyTypeGrp=='NVOCC'">
				        <label class="col-md-4 control-label">
				        Category 
				           <span style="color: red;">*</span>
				        </label>
				        <div class="col-md-5">
				        <selectivity list="categoryWiseList" ng-model="CustomerMasterData.categoryWise"
					             property="CustomerMasterData.categoryWise" id="categoryWise"  object="categoryWise"  
					             name="categoryWise" friendly-name="Customer Category" form-name="customerMasterForm"></selectivity>
				          
				              </div>
				       </div>
				
				        
				       <div class="form-group">
				        <label class="col-md-4 control-label">  Controlling Agent
				         </label>
				       <div class="col-md-5">
				 			<selectivity list="controllingAgentList" property="CustomerMasterData.controllingAgent" id="controllingAgent"  
				 			friendly-name="Customer Category" form-name="customerMasterForm" >
				        </div></div>
				
        
             <div class="form-group">
            <label class="col-md-4 control-label">Is Vessel Operator?
            </label>
            <div class="col-md-5">
             <div class="radio radio-inline" style="padding-left: 0px;">
              <label class="i-checks">
               <input type="radio" class="radiobox style-0"  name="isVesselGrp" ng_model="CustomerMasterData.isVesselGrp" value="Y" />
               <i></i>
               Yes
              </label>
             </div>
             <div class="radio  radio-inline">
              <label class="i-checks">
               <input type="radio" class="radiobox style-0" name="isVesselGrp" ng_model="CustomerMasterData.isVesselGrp" value="N" checked="checked"
                name="gear" />
               <i></i>
               No
              </label>
             </div>
            </div>
           </div>
           
                      <div class="form-group">
            <label class="col-md-4 control-label">Attached File Format</label>
            <div class="col-md-5">
             <div class="radio radio-inline" style="padding-left: 0px;">
              <label class="i-checks">
               <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.attachFileGroup" value="PDF" name="attachFileGroup"
                checked="checked"  >
                <i></i>PDF
              </label>
              </div>
              <!-- <div class="radio radio-inline">
         <label class="i-checks">
                 <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.attachFileGroup" value="EDI" name="attachFileGroup"
                 checked="checked" >
                 <i></i>EDI
                </label>
              </div> --><div class="radio radio-inline">
              <label class="i-checks">
               <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.attachFileGroup" value="HTML" name="attachFileGroup"
                checked="checked" >
                <i></i>HTML
              </label>
              </div>
            </div>
            
           </div>
           
				      </fieldset>
				     </div>
            <div class="wrapper-md"  ng-if="customerMasterEditData.isEdit">
    <div class="panel panel-default">
     <section widget-grid id="widget-grid">
      <div class="row ">
       <article class="col-sm-12">
        <div>
         <div class="" st-table="displayedCollection" st-safe-src="ConnectedCustomerData">
          <div class="widget-body no-padding ">
          <div>
           <!-- <div class=" " style="overflow: scroll;overflow-x: scroll;overflow-y: scroll ; height: 260px; width: 100%"> -->                  
            <table class="table table-striped table-hover dataTable no-footer ">
                          
             <thead class="dataTables-Main-Head" >
              <tr>
               <th class="width_10 text-center">Customer Code</th>
               <th class="width_15 text-center">Customer Short Name</th>
               <th class="width_15 text-center">Currency</th>
               <th class="width_15 text-center">Country Name</th>
                   <th class="width_15 text-center">Pol</th>
                       <th class="width_15 text-center">Pod</th>
              </tr>
             </thead>
  <tbody class="dataTables-Main-Body"  >
           <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCustomerItem in displayedCollection"  ng-if=" displayedCollection.length > 0">
            <td class="sorting width_10 text-center">{{objCustomerItem.customerCode}}</td>
            <td class="sorting width_15 text-center">{{objCustomerItem.customerName}}</td>
            <td class="sorting width_15 text-center">{{objCustomerItem.currency}}</td>
            <td class="sorting width_5 text-center">{{objCustomerItem.countryName}}</td>
                   <td class="sorting width_15 text-center">{{objCustomerItem.pol}}</td>
            <td class="sorting width_5 text-center">{{objCustomerItem.pod}}</td>
   
           </tr>
          </tbody>
          <tbody class="dataTables-Main-Body"  ng-if=" displayedCollection.length == 0" >
         <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"  >       <tr>
    <td><B>No Customers Mapped for the selected payer</B></td>
    </tr>
           </tbody>
            </table>

           </div>
          </div>
         </div>
        </div>
       </article>
      </div>
     </section>
    </div>
   </div>
				    </div>
				    <br>
				    <div class="form-actions">
				     <div class="row">
				      <div class="col-md-12">
				        <!-- <button class="btn btn-success btn-sm" data-ng-click="saveData(customerMasterForm,CustomerMasterData)">
				        <i class="fa fa-save"></i> Save
				       </button> -->
				       <button class="btn btn-success"   ng-if="!customerMasterEditData.conIdEdit" ng-click=saveData(customerMasterForm,CustomerMasterData) type="button">
				        <i class="fa fa-save"></i> Save
				       </button>
				 
				       <button class="btn btn-success"  ng-if="customerMasterEditData.conIdEdit"  ng-click= saveData(customerMasterForm,CustomerMasterData) type="button" >
				        <i class="fa fa-save"></i>
				        Update 
				       </button> 
				
				        <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
				        <i class="fa fa-close"></i>
				        Cancel
				       </button>
				      		</div>
				     	</div>
				    	</div>
				  	</form>
				</div>
			</tab>
		</tabset>
	</div>
	<div class="row">
	 	<div class="col-sm-12 col-md-12 col-lg-12">
	        <span class ="padding-left-10">
		 		<a class="btn btn-primary btn-sm" data-ng-click="algorithmView()"> Algorithm </a>	         	
	        </span>
	       </div>
	 </div> 

<script type="text/ng-template" id="algorithmModal">
<div class="modal-header"> JV Tariff Algorithm </div>
<div class="row">
<div class="width_90 m-n-auto">
	<iframe title='JV Tariff Algorithm' class='' 
        width='625' height='500' src='assets/algorithm_Docs/Payer_Algorithm.pdf'
         allowfullscreen='true' frameborder='0' align="center"></iframe>
</div>
</div>
<div class="modal-footer">
	<button class="btn btn-danger" ng-click="closeHelpDialog()">Close</button>
</div>
</script> 