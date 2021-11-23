<style type="text/css">

.nav-justified>li, .nav-tabs.nav-justified>li{background-color:#3B8A8A;}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
<div class="panel-heading panel-heading-form font-bold">
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
     <a x-ui-sref="app.finance.controlscreen.customer-add">View</a>
    </li>
   </ol>
  </div>
<tabset justified="true" class="tab-container">
          <tab heading="{{tabs[0].title}}">
  <div class="panel-body">
      <form class="form-horizontal" name="CustomerMasterForm"  >

      <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-6">
     <div class="form-group" ng-if="CustomerMasterEditData.conIdEdit">
          <label class="col-md-4 control-label">Payer ID:<span style="color: red;"></span></label>
          <div class="col-md-5">
           <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.customerCode}}</label>
          </div>
         </div>
         <div class="form-group">
        <label class="col-md-4 control-label">
        </label>
        <div class="col-md-5">
        </div>
       </div>
	       
     </div>

     <div class="col-sm-12 col-md-12 col-lg-6">
     <div class="form-group">
	        <label class="col-md-4 control-label">
	         Payer Name:
	        </label>
	        <div class="col-md-5">
	         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.customerName}}</label>
	        </div>
	       </div>
      <div class="form-group">
        <label class="col-md-4 control-label">Payer ShortName
        </label>
        <div class="col-md-5">
 	<label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.customerShortName}}</label>
        </div>
       </div>
     </div>
     </div>


      <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
     <div class="wrapper-md" >
 <div class="panel panel-default">
  <section widget-grid id="widget-grid">
   <div class="row ">
    <article class="col-sm-12">
     <div>
      <div class="" st-table="" st-safe-src="">
       <div class="widget-body no-padding ">
        <div class=" ">
         <table class="table table-striped b-t b-light table-hover dataTable no-footer">
          <thead class="dataTables-Main-Head">
           <tr>
            <th class="width_20 text-center" background="red" colspan="7">Payer Ranking</th>
           </tr>
            </thead>
            <tbody>
 			<tr>
            <th class="width_20 text-center info" colspan="2">Teus</th>
            <th class="width_20 text-center danger" colspan="2" >Income</th>
            <th class="width_20 text-center success" colspan="2">Outstanding Amount</th>
            <th class="width_20 text-center success">Outstanding More Than 30 days</th>
           </tr>
           <tr>
            <th class="width_10 text-center info" >Rank</th>
            <th class="width_10 text-center info" >Total</th>
             <th class="width_10 text-center danger" >Rank</th>
            <th class="width_10 text-center danger" >Total(USD)</th>
             <th class="width_10 text-center success"  >Rank</th>
            <th class="width_10 text-center success" >Total(USD)</th>
            <th class="width_10 text-center success" >Total(USD)</th>
           </tr>
             <tr>
            <th class="width_10 text-center info" >{{CustomerMasterData.customerTeusRank}}</th>
            <th class="width_10 text-center info" >{{CustomerMasterData.customerTeus}}</th>
             <th class="width_10 text-center danger" >{{CustomerMasterData.customerRank}}</th>
            <th class="width_10 text-center danger" >{{CustomerMasterData.customerAmount}}</th>
             <th class="width_10 text-center success" >{{CustomerMasterData.customerOutRank}}</th>
            <th class="width_10 text-center success" >{{CustomerMasterData.customerOutAmount}}</th>
            <th class="width_10 text-center success" >{{CustomerMasterData.outstandingLocal}}</th>
           </tr>
             <tr>
            <th class="width_10 text-center" colspan="1">Credit Rating</th>
            <th class="width_90 text-left"colspan="6" >{{CustomerMasterData.crediRating}}(Total Billed Amount/Outstanding Amount)</th>

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
     </div>

    <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>


 			<div class="form-group">
           <label  class="control-label col-md-4">Address
            </label>
           <div class="col-md-5">
           <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.address}}</label>
           </div>
          </div>
         <div class="form-group">
        <label class="col-md-4 control-label">
         Area
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.area}}</label>
        </div>
       </div>
         <div class="form-group">
        <label class="col-md-4 control-label">
         Payment Country
        </label>
        <div class="col-md-5">
        <selectivity list="countryList" property="CustomerMasterData.countryName" id="country_id" disabled="true"></selectivity>
        </div>
       </div>

       <div class="form-group">
        <label class="col-md-4 control-label">
         Fax No:
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.faxNo}}</label>
        </div>
       </div>

       <div class="form-group">
        <label class="col-md-4 control-label">
         Email:
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.email}}</label>
        </div>
       </div>


         <div class="form-group">
        <label class="col-md-4 control-label">
         Currency
        </label>
        <div class="col-md-5">
 		<selectivity list="currencyList" property="CustomerMasterData.currency" id="currency_id" disabled="true"></selectivity>
        </div>
       </div>
       

         <div class="form-group">
        <label class="col-md-4 control-label">
         Sales Person
        </label>
        <div class="col-md-5">
    <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.salesPerson}}</label>
        </div>
       </div>

            <div class="form-group">
        <label class="col-md-4 control-label">
         Booking Contact Person:
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.bookingCntctPrsn}}</label>
        </div>
       </div>

            <div class="form-group">
        <label class="col-md-4 control-label">
         Pricing/Sales Contact Person:
        </label>
        <div class="col-md-5">
        <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.pricingCntctPrsn}}</label>
        </div>
       </div>

            <div class="form-group">
        <label class="col-md-4 control-label">
         Operations Contact Person:
        </label>
        <div class="col-md-5">
          <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.operationsCntctPrsn}}</label>
        </div>
       </div>
            <div class="form-group">
        <label class="col-md-4 control-label">
         Finance Contact Person:
        </label>
        <div class="col-md-5">
          <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.financeCntctPrsn}}</label>
        </div>
       </div>

         <div class="form-group">
        <label class="col-md-4 control-label">Tel Number:
         </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.teleNumber}}</label>
        </div>
       </div>
          <div class="form-group">
        <label class="col-md-4 control-label">Type:
         </label>
        <div class="col-md-6">
           <div class="checkbox">
          <label class="i-checks checkbox-inline">
           <input type="checkbox" class="checkbox style-0"   onclick="return false" name="shipper" ng-model="CustomerMasterData.shipper">
           <i></i>Shipper
          </label>


          <label class="i-checks checkbox-inline">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="consignee" ng-model="CustomerMasterData.consignee">
           <i></i>Consignee
          </label>


          <label class="i-checks checkbox-inline">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="notifyParty" ng-model="CustomerMasterData.notifyParty">
           <i></i>Notify Party
          </label>

             <label class="i-checks checkbox-inline" style="margin-left: 0px;">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="agreementParty"  ng-model="CustomerMasterData.agreementParty">
           <i></i>Agreement Party
          </label>
             <label class="i-checks checkbox-inline">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="jVPartner" ng-model="CustomerMasterData.jVPartner">
           <i></i>JV Partner
          </label>
        </div>
       </div>
       </div>

            <div class="form-group" ng-if="CustomerMasterData.jVPartner">
        <label class="col-md-4 control-label"> JV Type:
         </label>
        <div class="col-md-5">
         <label class="i-checks checkbox-inline">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="ShareofRVC"  ng-true-value="'ShareofRVC'" ng-false-value="''" ng-model="CustomerMasterData.shareOfRVC">
           <i></i>Share of RVC
          </label>
           <label class="i-checks checkbox-inline">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="SlotSwap" ng-true-value="'SlotSwap'" ng-false-value="''" ng-model="CustomerMasterData.slotSwap">
           <i></i>Slot Swap
          </label>
           <label class="i-checks checkbox-inline">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="CRSS" ng-true-value="'CRSS'"  ng-false-value="''" ng-model="CustomerMasterData.costRevenueSpaceShare">
           <i></i>Cost / Revenue / Space Sharing
          </label>
           <label class="i-checks checkbox-inline">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="DeadFreight" ng-true-value="'DeadFreight'" ng-false-value="''" ng-model="CustomerMasterData.deadFreight">
           <i></i>Dead Freight
          </label>
        </div>
       </div>

         <div class="form-group">
        <label class="col-md-4 control-label">Payment Center:
         </label>
        <div class="col-md-5">
         <selectivity list="paymentCenterList" property="CustomerMasterData.paymentCenter" id="paymentCenter_id" disabled="true"></selectivity>
        </div>
       </div>

 		<div class="form-group">
        <label class="col-md-4 control-label">Active:
         </label>
        <div class="col-md-5">
           <div class="checkbox">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" onclick="return false"  name="active" onclick="return false" ng-model="CustomerMasterData.active"
            ng-true-value="'Y'" ng-false-value="'N'">
           <i></i>
          </label>
         </div>
        </div>
       </div>
       		<div class="form-group">
        <label class="col-md-4 control-label">Slot Operator:
         </label>
        <div class="col-md-5">
         <div class="checkbox">
          <label class="i-checks">
           <input type="checkbox" class="checkbox style-0" onclick="return false" name="slotOperator" ng-model="CustomerMasterData.slotOperator"
            ng-true-value="'Y'" ng-false-value="'N'">
           <i></i>
          </label>
         </div>
        </div>
       </div>
         <div class="form-group">
        <label class="col-md-4 control-label">Email:
         </label>
        <div class="col-md-8">
         <label class="i-checks checkbox-inline">
         <input type="checkbox"  name="booking" onclick="return false" ng-model="CustomerMasterData.emailBooking" ng-true-value="'B'"  ng-false-value="''">
         <i></i>Booking</label>
         <label class="i-checks checkbox-inline">
         <input type="checkbox"  name="pricing" onclick="return false" ng-model="CustomerMasterData.emailPricing" ng-true-value="'P'" ng-false-value="''">
         <i></i>Pricing/Sales</label>
         <label class="i-checks checkbox-inline">
         <input type="checkbox"  name="operations" onclick="return false" ng-model="CustomerMasterData.emailOperations"  ng-true-value="'O'" ng-false-value="''">
         <i></i>Operations</label>
         <label class="i-checks checkbox-inline">
         <input type="checkbox"  name="finance" onclick="return false" ng-model="CustomerMasterData.emailFinance" ng-true-value="'F'" ng-false-value="''">
         <i></i>Finance</label>
        </div>
       </div>
	<div class="form-group">
        <label class="col-md-4 control-label">BL Related:
         </label>
        <div class="col-md-5">
         <label class="i-checks">
         <input type="checkbox"  name="blRelated" onclick="return false" ng-model="CustomerMasterData.blRelated" ng-true-value="'Y'" ng-false-value="'N'">
         <i></i></label>
        </div>
       </div>
       	<div class="form-group">
        <label class="col-md-4 control-label"> Related Party:
         </label>
        <div class="col-md-5">
         <label class="i-checks">
         <input type="checkbox"  name="relatedParty" onclick="return false" ng-model="CustomerMasterData.relatedParty" ng-true-value="'Y'" ng-false-value="'N'">
         <i></i></label>
        </div>
       </div>

       	<div class="form-group">
        <label class="col-md-4 control-label">City:
         </label>
        <div class="col-md-5">
         <selectivity list="portList" property="CustomerMasterData.city" id="city_id" disabled="true"></selectivity>
        </div>
       </div>

         <div class="form-group">
        <label class="col-md-4 control-label">Attached File Format:

        </label>
        <div class="col-md-5">
         <div class="radio radio-inline" style="padding-left: 0px;">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0"  ng_model="CustomerMasterData.attachFileGroup" value="PDF" name="attachFileGroup"
            checked="checked"  >
            <i></i>PDF
          </label>
          </div><div class="radio radio-inline">
 <label class="i-checks">
           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.attachFileGroup" value="EDI" name="attachFileGroup"
            checked="checked" >
            <i></i>EDI
          </label>
          </div><div class="radio radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.attachFileGroup" value="HTML" name="attachFileGroup"
            checked="checked" >
            <i></i>HTML
          </label>
          </div>
        </div>
       </div>

         <div class="form-group">
        <label class="col-md-4 control-label">Is Vessel Operator?
        </label>
        <div class="col-md-5">
         <div class="radio radio-inline" style="padding-left: 0px;">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0"  name="isVesselGrp" ng_model="CustomerMasterData.isVesselGrp" value="Y">
           <i></i>
           Yes
          </label>
         </div>
         <div class="radio  radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0" name="isVesselGrp" ng_model="CustomerMasterData.isVesselGrp" value="N" checked="checked"
            name="gear">
           <i></i>
           No
          </label>
         </div>
        </div>
       </div>
      </fieldset>
     </div>


     <div class="col-sm-12 col-md-12 col-lg-6">
      <fieldset>
         <div class="form-group">
        <label class="col-md-4 control-label">Address1:
        </label>
        <div class="col-md-5">
        <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.address1}}</label>
        </div>
       </div>

        <div class="form-group">
        <label class="col-md-4 control-label">Type CUSTOMER/PAYER:
        </label>
        <div class="col-md-5">
        <selectivity list="typeofCustomerList" property="CustomerMasterData.typeofCustomer" id="typeofCustomer_id" disabled="true"></selectivity>
        </div>
       </div>  

   		<div class="form-group">
        <label class="col-md-4 control-label">Tel Office No:
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.telOfficeNum}}</label>
        </div>
       </div>
          		<div class="form-group">
        <label class="col-md-4 control-label">Telex No:
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.telexNum}}</label>
        </div>
       </div>

          		<div class="form-group">
        <label class="col-md-4 control-label">Cr-Limit(USD):
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.crLimit}}</label>
        </div>
       </div>

        		<div class="form-group">
        <label class="col-md-4 control-label">Exchange Rate:
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.exchangeRate}}</label>
        </div>
       </div>

        <div class="form-group">
        <label class="col-md-4 control-label">
         Booking Contact Person Email:
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.bookingCntctPrsnEmail}}</label>
        </div>
       </div>

        <div class="form-group">
        <label class="col-md-4 control-label">
         Pricing/Sales Contact Person Email:
        </label>
        <div class="col-md-5">
                <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.pricingCntctPrsnEmail}}</label>
        </div>
       </div>

            <div class="form-group">
        <label class="col-md-4 control-label">
         Operations Contact Person Email:
        </label>
        <div class="col-md-5">
         <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.operationsCntctPrsnEmail}}</label>
        </div>
       </div>
       <!--  <div class="form-group">
        <label class="col-md-4 control-label">
         Finance Contact Person Email:
        </label>
        <div class="col-md-5">
         <textarea class="col-md-12 control-label" rows=3 style="text-align: left;resize:none">{{CustomerMasterData.financeCntctPrsnEmail}}</textarea>
        </div>
       </div> -->
       
       <div class="form-group">
           <label  class="control-label col-md-4">Finance Contact Person Email:
            </label>
           <div class="col-md-5">
           <textarea class="col-md-12 control-label" style="text-align: left;width:350px; " disabled="disabled">{{CustomerMasterData.financeCntctPrsnEmail}}</textarea>
           </div>
          </div>

            <div class="form-group">
        <label class="col-md-4 control-label">
        Fax Num:
        </label>
        <div class="col-md-5">
        <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.faxNum}}</label>
        </div>
       </div>

            <div class="form-group">
        <label class="col-md-4 control-label">
        Payer Category:
        </label>
        <div class="col-md-5">
         <selectivity list="customerCategoryList" property="CustomerMasterData.customer_category" id="customer_category_id" disabled="true"></selectivity>

        </div>
       </div>

<div class="form-group">
        <label class="col-md-4 control-label">Credit Payer Type:
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
        <label class="col-md-4 control-label">Type Of Payer:
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
           <i></i>Deposit Check
          </label>
          </div>
        </div>
       </div>
        
                        <div class="form-group" ng-if="CustomerMasterData.typeOfCustGrp=='C' || CustomerMasterData.typeOfCustGrp=='D'">
       <div class="col-md-6">
        <label class="col-md-7 control-label">
         Credit Amount
         
        </label>
        <div class="col-md-5">
         <input type="text" class="text-right form-control input-sm" placeholder="0.00" name="Credit Amount" ng-model="CustomerMasterData.creditLimitAmt">
        </div>
       </div>
       <div class="col-md-6">
        <label class="col-md-7 control-label">
         Credit Days
         <span style="color: red;">*</span>
        </label>
        <div class="col-md-5">
         <input type="text" class="text-right form-control input-sm" placeholder="0" name="Credit Days" ng-model="CustomerMasterData.creditLimitDays">
        </div>
       </div>
      </div>
<div class="form-group" ng-if="CustomerMasterData.typeOfCustGrp=='D'">
        <label class="col-md-4 control-label">
       Deposit Amount:
        </label>
        <div class="col-md-5">
        <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.depositAmt}}</label>
        </div>
       </div>
           <div class="form-group">
        <label class="col-md-4 control-label">Payer Type:

        </label>
        <div class="col-md-7">
         <div class="radio radio-inline" style="padding-left: 0px;">
           <label class="i-checks">
           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.companyTypeGrp" value="MLO" name="companyTypeGrp"
            checked="checked"  >
           <i></i>MLO
          </label>
          </div>
          <div class="radio radio-inline">
           <label class="i-checks">
           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.companyTypeGrp" value="NVOCC" name="companyTypeGrp"
            checked="checked" >
           <i></i>NVOCC
          </label>
          </div>
          <div class="radio radio-inline">
          <label class="i-checks">
           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.companyTypeGrp" value="JV" name="Company TypeGrp"
            checked="checked" >
          <i></i>JV
          </label>
          <div class="radio radio-inline">
            <label class="i-checks">
           <input type="radio" class="radiobox style-0" ng_model="CustomerMasterData.companyTypeGrp" value="AGENT" name="companyTypeGrp"
            checked="checked" >
           <i></i>AGENT
          </label>
          </div>
          </div>
        </div>
       </div>
  <div class="form-group" ng-if="CustomerMasterData.companyTypeGrp=='NVOCC'">
        <label class="col-md-4 control-label">
        Category :
        </label>
        <div class="col-md-5">
         <selectivity list="categoryWiseList" property="CustomerMasterData.categoryWise" id="categoryWise_id" disabled="true"></selectivity>
              </div>
       </div>
       <div class="form-group">
        <label class="col-md-4 control-label">  Controlling Agent
         </label>
       <div class="col-md-5">
		<selectivity list="controllingAgentList" property="CustomerMasterData.controllingAgent" id="controllingAgent_id" disabled="true"></selectivity>
        </div>
        </div>
                      <div class="form-group">
        <label class="col-md-4 control-label">  Modified By
         </label>
            <div class="col-md-4">
                <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.modifiedBy}}</label>
        </div>
        </div>
               <div class="form-group">
        <label class="col-md-4 control-label">  Modified Date
         </label>
                 <div class="col-md-4">
                <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.modifiedDate}}</label>
        </div>
        </div>
                   <div class="form-group">
        <label class="col-md-4 control-label"> Created By
         </label>
            <div class="col-md-4">
                <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.createdBy}}</label>
        </div>
        </div>
               <div class="form-group">
        <label class="col-md-4 control-label">  Created Date
         </label>
                 <div class="col-md-4">
                <label class="col-md-12 control-label" style="text-align: left;">{{CustomerMasterData.createdDate}}</label>
        </div>
        </div>

      </fieldset>
     </div>
    </div>

    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
        <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="cancel()">
        <i class="fa fa-arrow-left"></i>
        Back To Lists
       </button>


      		</div>
     	</div>
    	</div>
  	</form>
</div>
 </tab>
        </tabset>
</div>
</div>


