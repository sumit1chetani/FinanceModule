<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0" style="width:100%">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></th>
       <th class="sorting width_10" st-sort="vendorNatureCode" ng-show="true">Vendor/FBT</th>
       <th class="sorting width_10" st-sort="vendorName" ng-show="true">Tax No.</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Amount</th>
       <th class="sorting width_10" st-sort="tdsNatureType" ng-show="true">Amount(USD)</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Cash/Bank</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Currency</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Rate</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Amount</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Amount(USD)</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Chq.No.</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Chq.Dt.</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Narration</th>
       <th class="sorting width_10" st-sort="tdsNature" ng-show="true">Paid To</th>
      </tr>
     </thead> 
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="taxPayment in displayedCollection" data-ng-click="CheckboxSelect({{$index}})">
       <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></td>
       <td>{{taxPayment.vendorName}}</td>
       <td>{{taxPayment.taxNo}}</td>
       <td>{{taxPayment.taxorderAmount}}</td>
       <td>{{taxPayment.taxorderAmountUsd}}</td>
        
       <td><selectivity  list="acctHeadList" property="taxPayment.cashBankAcctCode" id="cashBankAcctCode" name="cashBankAcctCode"  ></selectivity></td>
       <td><input type="text" class="form-control input-sm" name="currencyCode" ng-model="tdsTax.currencyCode" valid-method="submit" message-id="currencyCode" id="currencyCode"></td>
       <td><input type="text" class="form-control input-sm" name="exchangeRate" ng-model="tdsTax.exchangeRate" valid-method="submit" message-id="exchangeRate" id="exchangeRate"></td>
       <td><input type="text" class="form-control input-sm" name="cashBankAmount" ng-model="tdsTax.cashBankAmount" valid-method="submit" message-id="cashBankAmount" id="cashBankAmount"></td>
       <td><input type="text" class="form-control input-sm" name="cashBankAmountUsd" ng-model="tdsTax.cashBankAmountUsd" valid-method="submit" message-id="cashBankAmountUsd" id="cashBankAmountUsd"></td>
       <td><input type="text" class="form-control input-sm" name="chequeNo" ng-model="tdsTax.chequeNo" valid-method="submit" message-id="chequeNo" id="chequeNo"></td>
       <td><input type="text" class="form-control input-sm" name="chequeDate" ng-model="tdsTax.chequeDate" valid-method="submit" message-id="chequeDate" id="chequeDate"></td>
       <td><input type="text" class="form-control input-sm" name="narration" ng-model="tdsTax.narration" valid-method="submit" message-id="narration" id="narration"></td>
       <td><input type="text" class="form-control input-sm" name="paidTo" ng-model="tdsTax.paidTo" valid-method="submit" message-id="paidTo" id="paidTo"></td>
       
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer.jsp"%>
   </footer>
  </div>
 </div>
</div>