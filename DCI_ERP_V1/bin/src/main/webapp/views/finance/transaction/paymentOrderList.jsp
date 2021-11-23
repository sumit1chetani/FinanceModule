<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
  <input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body float-left padding-10" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive" style=" border: 1px solid #CCC;">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head" >
     <thead style="background-color: #e2e2e2;">
     <tr>
       <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></th>
            
       <th class="sorting width_10 padding-both-side-5" st-sort="supplierName">Supplier</th>
       <th class="sorting width_7 padding-both-side-5" st-sort="paymentOrderNo">PO No.</th>
       <th class="sorting width_8 padding-both-side-5" st-sort="paymentOrderDate">Date</th>
       <th class=" width_4 padding-both-side-5" st-sort="pocurrency">cur</th>
       <th class=" width_4 padding-both-side-5" st-sort="poexchangeRate">Rate</th>
       <th class=" width_5 padding-both-side-5" st-sort="paymentOrderTCAmount">TC Amt</th>
       <th class=" width_5 padding-both-side-5" st-sort="paymentOrderBCAmount">BC Amt</th>
       <th class=" width_17 padding-both-side-5" st-sort="companyCode">Company</th>
       <th class=" width_17 padding-both-side-5" st-sort="accountHeadCode">Acct</th>
       <th class=" width_5 padding-both-side-5" st-sort="currency">Cur</th>
       <th class=" width_5 padding-both-side-5" st-sort="exchangeRate">Rate</th>
       <th class=" width_8 padding-both-side-5" st-sort="paidAmountTC">TC Amt</th>
       <th class=" width_8 padding-both-side-5" st-sort="paidAmountBC">BC Amt</th>
       <th class=" width_5 padding-both-side-5" st-sort="chequeNo">Chq.No</th>       
       <th class=" width_15 padding-both-side-5" st-sort="chequeDate">Chq.Dt</th>
       
      </tr>
      </thead>
    <tbody class="dataTables-Main-Body" ng-repeat="(trIndex,objPaymentOrderItem) in displayedCollection"  ng-controller="tableCtrl">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"    ><!-- ng-controller="paymentOrderSelectivity" -->
       <td><label class="i-checks m-b-none"> <input type="checkbox" ng-if="!isReconcileList" ng-model="objPaymentOrderItem.select" id="select{{trIndex}}"><i></i></label></td>
       <td class="width_10">
        <span tooltip="{{objPaymentOrderItem.supplierName}}" class="tool-tip-span text-wrap" ng-bind="objPaymentOrderItem.supplierName"></span>
       </td>
       <td class="width_7 padding-both-side-2" ng-bind="objPaymentOrderItem.paymentOrderNo"></td>
       <td class="width_8 padding-both-side-2" ng-bind="objPaymentOrderItem.paymentOrderDate"></td>
       <td class="width_4 padding-both-side-2" ng-bind="objPaymentOrderItem.pocurrency"></td>
       <td class="width_4 padding-both-side-2 " ng-bind="objPaymentOrderItem.poexchangeRate"></td>
       <td class="width_5 padding-both-side-2 " ng-bind="objPaymentOrderItem.paymentOrderTCAmount"></td>
       <td class="width_5 padding-both-side-2 " ng-bind="objPaymentOrderItem.paymentOrderBCAmount"></td>
       
	   <td class="width_17 inputGroupContainer">
		 <selectivity list="companyList"
		property="objPaymentOrderItem.companyCode" id="txtCompanyCode" name="companyCode"
		ng-model="objPaymentOrderItem.companyCode"></selectivity>
	   </td>
	   
	   <td class="width_17 inputGroupContainer">
		 <selectivity list="acctHeadList"
		property="objPaymentOrderItem.accountHeadCode" id="txtAcctHead{{trIndex}}" name="acctHead{{trIndex}}"
		ng-model="objPaymentOrderItem.accountHeadCode"></selectivity>
		
	   </td>
	   
	   <td class="width_5 padding-both-side-2 inputGroupContainer">
       	<input  type="text" class="form-control input-sm" name="currency" id="currency{{trIndex}}" ng-model="objPaymentOrderItem.currency">
       </td>
       <td class="width_5 padding-both-side-2 inputGroupContainer">
       	<input  type="text" class="form-control input-sm text-right" name="rate" id="exchangeRate{{trIndex}}" ng-model="objPaymentOrderItem.exchangeRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$">
       </td>
       <td class="width_8 padding-both-side-2 inputGroupContainer">
       	<input  type="text" class="form-control input-sm text-right" name="amountTC" id="paidAmountTC{{trIndex}}" ng-model="objPaymentOrderItem.paidAmountTC" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit"  step="0.01">
       </td>
       <td class="width_8 padding-both-side-2 inputGroupContainer">
       	<input  type="text" class="form-control input-sm text-right" name="amountBC" id="paidAmountBC{{trIndex}}" ng-model="objPaymentOrderItem.paidAmountBC" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit"  step="0.01">
       </td>
       <td class="width_5 padding-both-side-2 inputGroupContainer">
       	<input  type="text" class="form-control input-sm" name="chequeNo" id="chequeNo{{trIndex}}" ng-model="objPaymentOrderItem.chequeNo">
       </td>
       <td class="width_15 padding-left-10 input-group date" >  
		 <div class="input-group input-append date" id="chequeDate{{trIndex}}">
          <input type="text" class="form-control input-sm" name="subValidTo"  style=" width: 90px; " id="chequeDateVal{{trIndex}}" ng-model="objPaymentOrderItem.chequeDate" placeholder='dd/mm/yyyy' />
          <span class="input-group-addon add-on">
           <span class="glyphicon glyphicon-calendar"></span>
          </span>
         </div>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
      <footer class="panel-footer panel-footer-list" style="padding:0px;">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
    <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<security:authorize access="hasRole('${form_code}_${add}')">
   					<button class="btn btn-success" ng-click="generatePayment(displayedCollection)"  type="button">Generate Payment</button>
   					</security:authorize>
   	</div></div></div>
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div>