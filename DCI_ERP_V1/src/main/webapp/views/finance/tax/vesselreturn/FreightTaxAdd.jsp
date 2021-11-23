<style>
.line-height-23 {
 line-height: 22.8px !important;
}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
   <form class="form-horizontal" name="tdsNatureForm" novalidate>
    <div class="row">
    <div class="col-sm-12 col-md-12 col-lg-12">
       <div class="col-sm-6 col-md-6 col-lg-6">
     <fieldset>
     <div class="form-group" ng-if="isEdit==true">
         <label class="col-md-4 control-label">Freight Tax Code</label>
         <div class="col-md-5 inputGroupContainer">
         <input type="text" class="form-control input-sm" name="freightTaxCode" ng-model="freightTax.freightTaxCode" readonly>
       <!--  <label class="col-md-4 control-label"> {{freightTax.natureCode}}</label> -->
         </div>
        </div>
     </fieldset>
        </div>
    </div>
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="col-sm-6 col-md-6 col-lg-6">
       <fieldset>
       
        <div class="form-group">
         <label class="col-md-4 control-label">Vessel <span style="color: red;">*</span></label>
         <div class="col-md-5 inputGroupContainer">
          <selectivity  list="vesselList" property="freightTax.vesselCode" ng-model="freightTax.vesselCode" id="vesselCode" name="vesselCode" validation="required" friendly-name="Vessel" form-name="tdsNatureForm" ></selectivity>
         </div>
        </div>
        
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Port <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <selectivity  list="portList" property="freightTax.portName" ng-model="freightTax.portName" id="portName" name="portName" validation="required" friendly-name="Port" form-name="tdsNatureForm" ></selectivity>
         </div>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Arrival Date </label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm" name="arrivalDate" ng-model="freightTax.arrivalDate"  valid-method="submit" message-id="arrivalDate" id="arrivalDate" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Currency <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <selectivity  list="currencyList" property="freightTax.currencyCode" ng-model="freightTax.currencyCode" id="currencyCode"  object="tempDropDownObj" name="currencyCode" validation="required" friendly-name="Currency" form-name="tdsNatureForm"></selectivity>
         </div>
        </div>
       
       </fieldset>
      </div>
      <div class="col-sm-6 col-md-6 col-lg-6">
       <fieldset>
       
        <div class="form-group">
         <label class="col-md-4 control-label"> Voyage <span style="color: red;">*</span>
         </label>
         <div class="col-md-5">
          <selectivity  list="voyageList" property="freightTax.voyageNo" ng-model="freightTax.voyageNo" id="voyageNo" name="voyageNo" validation="required" friendly-name="Voyage" form-name="tdsNatureForm" ></selectivity>
         </div>
        </div>
         <div class="form-group">        
         <div class="col-md-8">
         <label class="col-md-4 control-label line-height-23 ">&nbsp; </label>
         </div>
        </div>
                 
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4"> Departure Date <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm" name="departureDate" ng-model="freightTax.departureDate" valid-method="submit" message-id="departureDate" id="departureDate" readonly="readonly">
         </div>
         <!-- <div class="col-md-5">
          <div class='input-group date datetimepick'>
                                 <input type="text" class="form-control" ng-model="freightTax.date" placeholder="dd/mm/yyyy" id="date"
                                   value="{{freightTax.date}}" /> <span class="input-group-addon"> <span
                                   class="glyphicon glyphicon-calendar"> </span>
                                  </span>
         </div>
         </div> -->
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-4">Exchange Rate <span style="color: red;">*</span></label>
         <div class="col-md-5">
          <input type="text" class="form-control input-sm text-right" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" name="exchangeRate" ng-model="freightTax.exchangeRate" validation="required" valid-method="submit" message-id="exchangeRate" id="exchangeRate" readonly="readonly">
         </div>
        </div>
        
       </fieldset>
      </div>
     </div>
    </div>
    <!-- /row -->
    <div class="row">
    
     <div class="col-sm-12 col-md-12 col-lg-12">
     <div class="col-sm-6 col-md-6 col-lg-2">
       <fieldset>
       </fieldset>
       </div>
     <div class="col-sm-6 col-md-6 col-lg-5">
       <fieldset>
       
       <div class="form-group ">
         <label class="col-md-7 control-label line-height-23 bold">Particulars</label>
        </div>
        <div class="form-group ">
         <label class="col-md-7 control-label line-height-23 text-left ">a)Freight Prepaid</label>
        </div>
       <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">b)Freight payable at destination</label>
        </div>
       <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">c)Freight collected on imports </label>
        </div>
       <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">d)THC Collection if any</label>
        </div>
         <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">e)Haulage Collection if any</label>
        </div>
       <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">f)Bunker Adjustment Factor Collections</label>
        </div>
       <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">g)Total (a) + (b) + (c) + (d) + (e) + (f)</label>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-2 text-left " style="width:33%">Income @</label>
         <div class="col-md-1" style="width:10%;padding:0px">
          <input type="text" class="form-control input-sm text-right" name="incomePercOfGrosRate" ng-model="freightTax.incomePercOfGrosRate"  validation="required" valid-method="submit" message-id="incomePercOfGrosRate" id="incomePercOfGrosRate" ng-keyup="calculatingTotal();">
         </div>
          <label for="inputPassword" class="control-label col-md-3 text-left " style="width:38%">% of the gross amount </label>
        </div>
        
       <div class="form-group">
         <label for="inputPassword" class="control-label col-md-3 text-left " style="width:33%">Tax payable @</label>
         <div class="col-md-1" style="width:10%;padding:0px">
          <input type="text" class="form-control input-sm text-right" name="taxPayablePercRate" ng-model="freightTax.taxPayablePercRate" validation="required" valid-method="submit" message-id="taxPayablePercRate" id="taxPayablePercRate" ng-keyup="calculatingTotal();">
         </div>
          <label for="inputPassword" class="control-label col-md-2 text-left " style="width:22%"> % on above</label>
        </div>
        <div class="form-group">
         <label for="inputPassword" class="control-label col-md-3 text-left " style="width:33%">Surcharge if any @</label>
         <div class="col-md-1" style="width:10%;padding:0px">
          <input type="text" class="form-control input-sm text-right " name="surchargePercRate" ng-model="freightTax.surchargePercRate"   message-id="surchargePercRate" id="surchargePercRate" ng-keyup="calculatingTotal();">
         </div>
          <label for="inputPassword" class="control-label col-md-1 text-left " style="width:3%"> % </label>
        </div>
         <div class="form-group">
         <label for="inputPassword" class="control-label col-md-3 text-left " style="width:33%">Educational Cess @</label>
         <div class="col-md-1" style="width:10%;padding:0px">
          <input type="text" class="form-control input-sm text-right" name="educationalCessPercRate" ng-model="freightTax.educationalCessPercRate"  message-id="educationalCessPercRate" id="educationalCessPercRate" ng-keyup="calculatingTotal();">
         </div>
          <label for="inputPassword" class="control-label col-md-1 text-left " style="width:3%"> % </label>
        </div>        
         <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">Gross Tax</label>
        </div>
         <div class="form-group">
         <label class="col-md-9 control-label line-height-23 text-left ">Net Tax Payable (Round off to nearest Rupee)</label>
        </div>
         <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">Advance Tax Paid</label>
        </div>
         <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">Final Tax Paid</label>
        </div>
         <div class="form-group">
         <label class="col-md-7 control-label line-height-23 text-left ">Refund Due if any</label>
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
          <input type="text" class="form-control input-sm text-right" name="prepaidAmtLocal" ng-model="freightTax.prepaidAmtLocal" id="prepaidAmtLocal" ng-keyup="calculatingTotal();" 
           validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Prepaid Amount Local Should be 2 digit|required"  step="0.01" friendly-name="Prepaid Amount Local">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="payableAtDestAmtLocal" ng-model="freightTax.payableAtDestAmtLocal" validation="pattern=/^[0-9-]+(\.[0-9-]{1,})?$/:alt=Payable At Destination Amount Local Should be 2 digit|required"  step="0.01" friendly-name="Payable At Destination Amount Local" id="payableAtDestAmtLocal" ng-keyup="calculatingTotal();">
         </div>
        </div>
        <div class="form-group">        
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="collectedOnImportAmtLocal" ng-model="freightTax.collectedOnImportAmtLocal" validation="pattern=/^[0-9-]+(\.[0-9-]{1,})?$/:alt=Collected on Imports Amount Local Should be 2 digit|required"  step="0.01" friendly-name="Collected on Imports Amount Local" id="collectedOnImportAmtLocal" ng-keyup="calculatingTotal();">
         </div>
        </div>        
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="thcAmtLocal" ng-model="freightTax.thcAmtLocal" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=THC Collection Amount Local Should be 2 digit|required"  step="0.01" friendly-name="THC Collection Amount Local" id="thcAmtLocal" ng-keyup="calculatingTotal();">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="haulageAmtLocal" ng-model="freightTax.haulageAmtLocal" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Haulage Amount Local Should be 2 digit|required"  step="0.01" friendly-name="Haulage Amount Local" id="haulageAmtLocal" ng-keyup="calculatingTotal();">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="bunkerAdjustAmtLocal" ng-model="freightTax.bunkerAdjustAmtLocal" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Bunker Adjustment Amount Local Should be 2 digit|required"  step="0.01" friendly-name="Bunker Adjustment Amount Local" ng-keyup="calculatingTotal();">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="totalAmtLocal" ng-model="freightTax.totalAmtLocal" validation="required" valid-method="submit" message-id="totalAmtLocal" id="totalAmtLocal" readonly="readonly">
         </div>
        </div> 
        <div class="form-group">
         <div class="col-md-8">
          
          <input type="text" class="form-control input-sm text-right" name="incomePercOfGrosAmtLocal" ng-model="freightTax.incomePercOfGrosAmtLocal" validation="required" valid-method="submit" message-id="incomePercOfGrosAmtLocal" id="incomePercOfGrosAmtLocal" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="taxPayablePercAmtLocal" ng-model="freightTax.taxPayablePercAmtLocal" validation="required" valid-method="submit" message-id="taxPayablePercAmtLocal" id="taxPayablePercAmtLocal" readonly="readonly" >
         </div>
        </div>
        <div class="form-group">        
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="surchargePercAmtLocal" ng-model="freightTax.surchargePercAmtLocal" validation="required" valid-method="submit" message-id="surchargePercAmtLocal" id="surchargePercAmtLocal" readonly="readonly">
         </div>
        </div>        
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="educationalCessLocal" ng-model="freightTax.educationalCessLocal" validation="required" valid-method="submit" message-id="educationalCessLocal" id="educationalCessLocal" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="grossTaxAmtLocal" ng-model="freightTax.grossTaxAmtLocal" validation="required" valid-method="submit" message-id="grossTaxAmtLocal" id="grossTaxAmtLocal" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="netTaxPayableAmtLocal" ng-model="freightTax.netTaxPayableAmtLocal" validation="required" valid-method="submit" message-id="netTaxPayableAmtLocal" id="netTaxPayableAmtLocal" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="advanceTaxPaidAmtLocal" ng-model="freightTax.advanceTaxPaidAmtLocal" validation="required" valid-method="submit" message-id="advanceTaxPaidAmtLocal" id="advanceTaxPaidAmtLocal" ng-keyup="calculatingTotal();">
         </div>
        </div> 
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="finalTaxPaidAmtLocal" ng-model="freightTax.finalTaxPaidAmtLocal" validation="required" valid-method="submit" message-id="finalTaxPaidAmtLocal" id="finalTaxPaidAmtLocal" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="tdsNetAmtLocal" ng-model="freightTax.refundAmtLocal" validation="required" valid-method="submit" message-id="refundAmtLocal" id="refundAmtLocal" readonly="readonly">
         </div>
        </div> 
       </fieldset>
      </div>
      <div class="col-sm-6 col-md-6 col-lg-2">
       <fieldset>
         <div class="form-group">
         <label class="col-md-7 control-label bold">Amount(USD) </label>
        </div>
         <div class="form-group">        
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="prepaidAmtUsd" ng-model="freightTax.prepaidAmtUsd" validation="required" valid-method="submit" message-id="prepaidAmtUsd" id="prepaidAmtUsd" readonly="readonly">
         </div>
        </div>        
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="payableAtDestAmtUsd" ng-model="freightTax.payableAtDestAmtUsd" validation="required" valid-method="submit" message-id="payableAtDestAmtUsd" id="payableAtDestAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
           <input type="text" class="form-control input-sm text-right" name="collectedOnImportAmtUsd" ng-model="freightTax.collectedOnImportAmtUsd" validation="required" valid-method="submit" message-id="collectedOnImportAmtUsd" id="collectedOnImportAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">        
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name=thcAmtUsd ng-model="freightTax.thcAmtUsd" validation="required" valid-method="submit" message-id="thcAmtUsd" id="thcAmtUsd" readonly="readonly">
         </div>
        </div>        
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="haulageAmtUsd" ng-model="freightTax.haulageAmtUsd" validation="required" valid-method="submit" message-id="individualTax" id="individualTax" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="bunkerAdjustAmtUsd" ng-model="freightTax.bunkerAdjustAmtUsd" validation="required" valid-method="submit" message-id="bunkerAdjustAmtUsd" id="bunkerAdjustAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="totalAmtUsd" ng-model="freightTax.totalAmtUsd" validation="required" valid-method="submit" message-id="totalAmtUsd" id="totalAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">        
         <div class="col-md-8">
         <input type="text" class="form-control input-sm text-right" name="incomePercOfGrosAmtUsd" ng-model="freightTax.incomePercOfGrosAmtUsd" validation="required" valid-method="submit" message-id="incomePercOfGrosAmtUsd" id="incomePercOfGrosAmtUsd" readonly="readonly">
          
         </div>
        </div>        
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="taxPayablePercAmtUsd" ng-model="freightTax.taxPayablePercAmtUsd" validation="required" valid-method="submit" message-id="taxPayablePercAmtUsd" id="taxPayablePercAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
           <input type="text" class="form-control input-sm text-right" name="surchargePercAmtUsd" ng-model="freightTax.surchargePercAmtUsd" validation="required" valid-method="submit" message-id="surchargePercAmtUsd" id="surchargePercAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">        
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name=educationalCessUsd ng-model="freightTax.educationalCessUsd" validation="required" valid-method="submit" message-id="educationalCessUsd" id="educationalCessUsd" readonly="readonly">
         </div>
        </div>        
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="grossTaxAmtUsd" ng-model="freightTax.grossTaxAmtUsd" validation="required" valid-method="submit" message-id="grossTaxAmtUsd" id="grossTaxAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="netTaxPayableAmtUsd" ng-model="freightTax.netTaxPayableAmtUsd" validation="required" valid-method="submit" message-id="netTaxPayableAmtUsd" id="netTaxPayableAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="advanceTaxPaidAmtUsd" ng-model="freightTax.advanceTaxPaidAmtUsd" validation="required" valid-method="submit" message-id="advanceTaxPaidAmtUsd" id="advanceTaxPaidAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="finalTaxPaidAmtUsd" ng-model="freightTax.finalTaxPaidAmtUsd" validation="required" valid-method="submit" message-id="finalTaxPaidAmtUsd" id="finalTaxPaidAmtUsd" readonly="readonly">
         </div>
        </div>
        <div class="form-group">
         <div class="col-md-8">
          <input type="text" class="form-control input-sm text-right" name="refundAmtUsd" ng-model="freightTax.refundAmtUsd" validation="required" valid-method="submit" message-id="refundAmtUsd" id="refundAmtUsd" readonly="readonly">
         </div>
        </div>
       </fieldset>
      </div>
     </div>
    </div>
    <!-- Row End -->
    <br>
    <div class="form-actions">
     <div class="row">
      <div class="col-md-12">
       <button class="btn btn-success" ng-if="!isEdit" type="button" ng-click="submit(tdsNatureForm)">
        <i class="fa fa-save"></i> Save
       </button>
       <button class="btn btn-success" ng-if="isEdit" type="button" ng-click="update(tdsNatureForm)">
        <i class="fa fa-save"></i> Update
       </button>
       <button class="btn btn-info" ng-if="!isEdit" type="reset" ng-click="reset()">
        <i class="fa fa-undo"></i> Reset
       </button>
       <button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
        <i class="fa fa-close"></i> Cancel
       </button>
      </div>
     </div>
    </div>
   </form>
  </div>
 </div>
</div>
