<style>

.i-checks input[disabled]+i:before, fieldset[disabled] .i-checks input+i:before {
    background-color: #23b7e5;
}
</style>

<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="wrapper-md">
    <div class="panel panel-default panel-default-form">
      <%@include file="/views/templates/panel-header-form.jsp"%>
      <input type="hidden" value="F0403" id="form_code_id">
      <%-- ${form_code} --%>
      <div class="panel-body">
       <form name="purchaseInvoiceForm" class="form-horizontal" novalidate>
        <div class="row book-widget-row">
       <div class="col-sm-12 col-md-4 col-lg-4">
        <fieldset>
         <div class="form-group">
          <label class="col-md-5 control-label"> Company
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-7" >
           <selectivity ng-if="edit" disabled="edit" list="companyList" ng-model="purchaseInvoiceData.company" property="purchaseInvoiceData.company"
           id="company_id" object="company" name="company_id"
           validation="required" friendly-name="Company" form-name = "purchaseInvoiceForm"></selectivity>
          </div>
          <div class="col-md-7" >
           <selectivity ng-if="!edit" list="companyList" ng-model="purchaseInvoiceData.company" property="purchaseInvoiceData.company"
           id="company_id" object="company" name="company_id"
           validation="required" friendly-name="Company" form-name = "purchaseInvoiceForm"></selectivity>
          </div>
         </div>
         <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5">Invoice Date
                    <span style="color: red;">*</span></label>
                    <div class="col-md-7">
                      <div class="input-group input-append date" id="pi_date">
                         <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                         ng-model="purchaseInvoiceData.puchaseInvoiceDate" name="Date" id="purchase_invoice_date"
                         validation="required" friendly-name="Invoice Date" ng-blur="datevalidation(purchaseInvoiceData.puchaseInvoiceDate)" readonly>
                       <span class="input-group-addon add-on">
                                <span class="glyphicon glyphicon-calendar"></span>
                             </span>
                      </div>
                    </div>
                  </div>
                  <div class="form-group">
          <label class="col-md-5 control-label"> Agent
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-7">
              <selectivity list="supplierList" property="purchaseInvoiceData.supplier" ng-model="purchaseInvoiceData.supplier"  id="supplier_id" name="supplier_id"
           object="supplier" validation="required" friendly-name="supplier" form-name = "purchaseInvoiceForm"></selectivity>
          </div>
         </div>
                  <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5">Description</label>
                   <div class="col-md-7">
                    <textarea rows="2" cols="4" class="form-control resize-vertical" name="Description" ng-model="purchaseInvoiceData.description">
                    </textarea>
                   </div>
                  </div>
        </fieldset>
       </div>
           <div class="col-sm-12 col-md-4 col-lg-4">
        <fieldset>
         <div class="form-group">
          <label class="col-md-5 control-label"> Party Invoice No
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-7">
           <input type="text" class="form-control input-sm" ng-model="purchaseInvoiceData.partyInvoiceNo"
           name="Party Invoice No" validation="required" friendly-name="Party Invoice No" >
          </div>
         </div>
         <div class="form-group">
                    <label for="inputPassword" class="control-label col-md-5">Party Invoice Date
                    <span style="color: red;">*</span></label>
                    <div class="col-md-7">
                      <div class="input-group input-append date" id="party_date">
                         <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
                          ng-model="purchaseInvoiceData.partyInvoiceDate" name="Party Invoice Date" id="party_invoice_date"
                          validation="required" friendly-name="Party Invoice Date">
                          <span class="input-group-addon add-on">
                                <span class="glyphicon glyphicon-calendar"></span>
                             </span>
                                </div>
                    </div>
                  </div>
         <div class="form-group">
          <label class="col-md-5 control-label"> Currency
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-7">
           <!-- <input type="text" class="form-control input-sm" readonly ng-model="purchaseInvoiceData.currency"
            name="Currency" validation="required" friendly-name="Currency"> -->
           <selectivity list="currencyList" property="purchaseInvoiceData.currency" name="Currency"  
           id="currency" object="currency" validation="required" friendly-name="Currency" form-name = "purchaseInvoiceForm"
           ng-model="purchaseInvoiceData.currency" disabled="true"></selectivity>
          </div>
         </div>
         <div class="form-group">
          <label class="col-md-5 control-label"> TC Amount
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-7">
           <input type="text" class="form-control input-sm text-right" ng-model="purchaseInvoiceData.tcAmount"
            name="TC Amount" ng-keyup="amountLocalCalculation(purchaseInvoiceData.tcAmount)"
            friendly-name="TC Amount" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"  step="0.01" ng-blur="exchageratehdr(purchaseInvoiceData.exchangeRate)">
          </div>
         </div>
                 </fieldset>
       </div>
           <div class="col-sm-12 col-md-4 col-lg-4">
           <div class="form-group">
          <label class="col-md-5 control-label"> Purchase Order No
          </label>
          <div class="col-md-7">
           <!-- <select class="form-control input-sm" name="Purchase No" ng-model="purchaseInvoiceData.purchaseOrderNo"
           data-ng-options="r.purchaseOrderNo as r.purchaseOrderNo for r in purchaseOrderList" ng-change="getPurchaseCur(purchaseInvoiceData.purchaseOrderNo)">
            <option value="" selected="selected">--Select--</option>
           </select> -->

           <selectivity list="purchaseOrderList" property="purchaseInvoiceData.purchaseOrderNo" id="purchaseOrder_id" object="purchaseOrder"></selectivity>

          </div>
         </div>

           <!--  <div class="form-group" ng-if="!purchaseInvoiceData.isDueDate"> -->
                    <label for="inputPassword" class="control-label col-md-5">Due Date</label>
                    <div class="col-md-7">
                      <div class="input-group input-append date" id="du_date">
                         <input type="text" class="form-control input-sm" name="Due Date"
                         placeholder="dd/mm/yyyy" id="due_date"
                         ng-model="purchaseInvoiceData.dueDate" validation="required" friendly-name="Due Date" >
                         <span class="input-group-addon add-on">
                                <span class="glyphicon glyphicon-calendar"></span>
                             </span>
                                </div>
                    </div>
                  <!-- </div> -->
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  <div class="form-group">
           <label class="col-md-5 control-label"> Exchange Rate
            <span style="color: red;">*</span>
           </label>
           <div class="col-md-7">
            <input type="text" class="form-control input-sm text-right"  ng-model="purchaseInvoiceData.exchangeRate"
             name="Exchange Rate" validation="required" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" friendly-name="Exchange Rate" ng-blur="exchageratehdr(purchaseInvoiceData.exchangeRate)">
           </div>
         </div>
         
         <div class="form-group">
          <label class="col-md-5 control-label"> BC Amount({{companyCurrency}})
           <span style="color: red;">*</span>
          </label>
          <div class="col-md-7">
           <input type="text" class="form-control input-sm text-right" ng-model="purchaseInvoiceData.bcAmount"
            name="Amount" ng-blur="amountCalculation(purchaseInvoiceData.bcAmount)" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"  step="0.01" friendly-name="BC Amount" ng-blur="exchageratehdr(purchaseInvoiceData.exchangeRate)" >
          </div>
         </div>

       </div>
      </div>
      <div class="table-responsive clear">
           <table class="table table-striped b-t b-light">
             <thead>
               <tr>
                 <th colspan=1 class="width_1"></th>
                 <th colspan=1  class="width_10 text-center">Company<span style="color: red;">*</span></th>
                 <th colspan=1  class="width_13 text-center">Account Name<span style="color: red;">*</span></th>
                 <th colspan=1  class="width_13 text-center">Voyage</th>
                 <th colspan=1  class="width_10 text-center">Port</th>
                 <th colspan=1  class="width_10 text-center">Est Amt</th>
                 <th colspan=1  class="width_10 text-center">Partial Alloc</th>
                 <th colspan=1 class=" width_5 text-center">Currency<span style="color: red;">*</span></th>
                 <th colspan=1 class=" width_7 text-center">Rate<span style="color: red;">*</span></th>
                 <th colspan=1 class="width_10 text-center">TC Amt<span style="color: red;">*</span></th>
                 <th colspan=1 class="width_10 text-center">BC Amt ({{companyCurrency}})<span style="color: red;">*</span></th>
                 <th colspan=1 class="width_10 text-center">Balance Provision Amt ({{companyCurrency}})</th>
               </tr>
             </thead>
             <tbody ng-repeat="(trIndex, row) in purchaseInvoiceData.purchaseInvoiceDetail" ng-controller="tableCtrl">
              <tr>
           <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
         <!-- <td>
          <selectivity list="subGrpList" property="row.subGrpCode" id="subGroupCode{{trIndex}}" object="subGroup"></selectivity>
         </td> -->
         <td>
	         <div ng-if="row.isFrmDraft=='YESDRT'">
	         	<selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"
	          ng-model="row.companyCode" name ="companyCode{{trIndex}}" validation="required"
	          friendly-name="{{ 'Row' + $index + '(Company)'}}" form-name = "purchaseInvoiceForm" disabled="true"></selectivity>
	         </div>
	          <div ng-if="row.isFrmDraft!='YESDRT'">
	          	<selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"
	          ng-model="row.companyCode" name ="companyCode{{trIndex}}" validation="required"
	          friendly-name="{{ 'Row' + $index + '(Company)'}}" form-name = "purchaseInvoiceForm" ></selectivity>
	          </div>
         </td>

         <td>
	         <div ng-if="row.isFrmDraft=='YESDRT'">
	         	 <selectivity list="accountList" property="row.accountHeadCode" id="accountHeadCode{{trIndex}}" object="account"
	          ng-model="row.accountHeadCode" name ="accountHeadCode{{trIndex}}" validation="required"
	          friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "purchaseInvoiceForm" disabled="true"></selectivity>
	         </div>
	         <div ng-if="row.isFrmDraft!='YESDRT'">
	          <selectivity list="accountList" property="row.accountHeadCode" id="accountHeadCode{{trIndex}}" object="account"
	          ng-model="row.accountHeadCode" name ="accountHeadCode{{trIndex}}" validation="required"
	          friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "purchaseInvoiceForm"></selectivity>
	          </div>
         </td>
         <td>
	         <div ng-if="row.isFrmDraft=='YESDRT'">
	         	<selectivity list="voyageList" property="row.voyageCode" id="voyageCode{{trIndex}}" disabled="true"></selectivity>
	         </div>
	         <div ng-if="row.isFrmDraft!='YESDRT'">
	         	<selectivity list="voyageList" property="row.voyageCode" id="voyageCode{{trIndex}}" ></selectivity>
	         </div>          
         </td>

         <td>
	         <div ng-if="row.isFrmDraft=='YESDRT'">
	          <selectivity list="row.portList" property="row.portCode" id="portCode{{trIndex}}" disabled="true"></selectivity>
	          </div>
	          <div ng-if="row.isFrmDraft!='YESDRT'">
	          <selectivity list="row.portList" property="row.portCode" id="portCode{{trIndex}}" ></selectivity>
	          </div>
         </td>
         
         <td> <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm" ng-model="row.estAmount" id="estAmount{{trIndex}}" ng-model="row.estAmount"  name="estAmount{{trIndex}}" readonly><!-- readonly -->
                 </div>
                </div>
               </td>
               <td class="text-center">
        <!--   <selectivity list="approveList" property="row.status" id="status{{trIndex}}" name ="status{{trIndex}}" validation="required" ng-model="row.status"
          friendly-name="{{ 'Row' + $index + '(Status)'}}" form-name = "purchaseInvoiceForm"></selectivity> -->
          
          
          
<!--           <label class="i-checks m-b-none"> <input type="checkbox" ng-click="setStatus(row)" ng-model="row.allocType" id="allocType{{trIndex}}" disabled="true"><i></i></label>
 -->          
          
<!--           <td class="text-center" ng-if="purchaseInvoiceData.puchaseInvoiceNo.indexOf('PDA') !== -1">
 -->		          <span ng-if="row.status == 'P'">
		          	<label class="i-checks m-b-none"> <input type="checkbox" disabled checked><i></i></label>
		          </span>
		          <span ng-if="row.status == 'A'">
		          	<label class="i-checks m-b-none"> <input type="checkbox" disabled><i></i></label>
		          </span>
<!-- 	           </td>
 -->          
          
          
         </td>
               <td>
                 <div class="row">
                    <div class="col-xs-12">
                      <!-- <input type="text" class="form-control input-sm" id="currency{{trIndex}}" ng-model="row.currency"  name="currency{{trIndex}}"
                      validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" readonly> -->
                       <selectivity list="currencyList" property="row.currency" id="currency{{trIndex}}" object="currency" name="currency{{trIndex}}"
                      validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" ng-model="row.currency" property="row.currency"></selectivity>
                 </div>
                </div>
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm text-right" id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"  
                      ng-blur="amountCalculationexchange(row.exchangeRate,trIndex,row)"  ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
                      name="exchangeRate{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Exchange rate)'}}">
                      
                       <input type="hidden" class="form-control input-sm text-right" id="txtFromCurrency{{trIndex}}" ng-model="row.fromCurrency"  
		           		 name="From Currency{{trIndex}}" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" readonly />
		           	   <input type="hidden" class="form-control input-sm text-right" id="txtToCurrency{{trIndex}}" ng-model="row.toCurrency"  
		           		 name="To Currency{{trIndex}}" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" readonly />
                 </div>
                </div>
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                      <input type="text" class="form-control input-sm text-right" id="tcAmount{{trIndex}}" ng-model="row.tcAmount"  name="tcAmount{{trIndex}}"
                      ng-keyup="amountCalculationTCTable(row.tcAmount,trIndex,row)" 
                      validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be in 2 decimal places|required"  step="0.01" friendly-name="{{ 'Row' + $index + '(TC Amount)'}}">
                 </div>
                </div>
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                     <input type="text" class="form-control input-sm text-right"  id="bcAmount{{trIndex}}" ng-model="row.bcAmount" name="bcAmount{{trIndex}}"
                      ng-blur="amountCalculationBCTable(row.bcAmount,trIndex,row)"
                      validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Amount Should be in 2 decimal places|required"  step="0.01" friendly-name="{{ 'Row' + $index + '(BC Amount)'}}">
                </div>
                </div>
               </td>
               <td> <div class="row">
                    <div class="col-xs-12">
                     <input type="text" class="form-control input-sm text-right"  id="balanceAmount{{trIndex}}" ng-model="row.balanceAmount" name="balanceAmount{{trIndex}}"
                       validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Balance Provision Amount Should be in 2 decimal places|required"  step="0.01" friendly-name="{{ 'Row' + $index + '(Balance Amount)'}}">
                </div>
                </div>
               </td>

             </tr>

           </tbody>
           </table>
           <div class="padding-right-5">
             <div class="col-md-4">
                   <button ng-click="addRow(purchaseInvoiceData.purchaseInvoiceDetail)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
                   <i class="fa fa-plus"></i>
                  </button>
                  <button ng-click="removeRow(purchaseInvoiceData.purchaseInvoiceDetail)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
                   <i class="fa  fa-trash-o"></i>
                  </button>
                </div>
                <div class="col-md-8">
          <div class="form-group">
          <label class="col-md-6 control-label">Total
          </label>
          <div class="col-md-3">
           <input type="text" class="form-control input-sm text-right" ng-model="totalTCAmount" readonly
           name="TC Total" placeholder="0.0">
          </div>

          <div class="col-md-3">
           <input type="text" class="form-control input-sm text-right" ng-model="totalBCAmount" readonly
           name="BC Total" placeholder="0.0">
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

             <button class="btn btn-success"
             ng-click="onSubmit(purchaseInvoiceForm,purchaseInvoiceData,'update')">
              <i class="fa fa-save"></i> Update
             </button>
             
             <security:authorize access="hasRole('F0403_${approve}')">
             <button class="btn btn-success" id="approveBtn" ng-if="purchaseInvoiceData.puchaseInvoiceNo.indexOf('PDA') !== -1"
              class="btn btn-success" ng-click="onSubmit(purchaseInvoiceForm,purchaseInvoiceData,'approve')">
              Approve
             </button>
             </security:authorize>
             
             <!-- approve(purchaseInvoiceData.puchaseInvoiceNo) -->
             <button class="btn btn-danger"
              class="btn btn-success" ng-click="cancel()">
              <i class="fa fa-close"></i> Cancel
             </button>
             
<%--              <security:authorize access="hasRole('F0403_${approve}')">
             <button class="btn btn-success" ng-if="purchaseInvoiceData.puchaseInvoiceNo.indexOf('PDA') !== -1"
              class="btn btn-success" ng-click="approve(purchaseInvoiceData.puchaseInvoiceNo)">
              Approve
             </button>
             
             <button class="btn btn-danger" ng-if="purchaseInvoiceData.puchaseInvoiceNo.indexOf('PDA') !== -1"
              class="btn btn-success" ng-click="reject(purchaseInvoiceData.puchaseInvoiceNo)">
              <i class="fa fa-close"></i> Reject
             </button>
             </security:authorize> --%>
             
            </div>
           </div>
          </div><!-- /form-actions -->
         </div>
        </div>
       </div>
           </div> <!-- /table-responsive -->
     </form>
    </div> <!-- /panel-body -->
   </div> <!-- /panel-default -->
  </div>
 </div>
</div>