<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <div class="panel-heading panel-heading-list padding-right-0 padding-left-0">

   <%@include file="/views/templates/panel-header.jsp"%>
    <input type="hidden" value="${form_code}" id="form_code_id">
  </div><!-- /panel-heading -->
  <div class="panel panel-default">
		
  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_15" st-sort="objCashBankPmtListItem.cbVoucherNo">Voucher No</th>
       <th class="sorting width_10" st-sort="objCashBankPmtListItem.cashbankPmtDate">Voucher Dt</th>
       <th class="sorting width_30" st-sort="objCashBankPmtListItem.accountName">Bank Account Name</th>
       <th class="sorting width_30" st-sort="objCashBankPmtListItem.accountName">Narration</th>
       <th class="sorting width_10 text-wrap" st-sort="objCashBankPmtListItem.bcAmountHdr">BC Amt</th>
       <th class="sorting width_10 text-wrap text-wrap-amtusd" st-sort="objCashBankPmtListItem.tcAmountHdr">TC Amt</th>
       <th>Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCashBankPmtListItem in displayedCollection">
       <td class="width_1" cs-select="objCashBankPmtListItem"></td>
<!--        <td class="width_20" ng-bind="objCashBankPmtListItem.cbVoucherNo"></td> -->
       <td class="width_15">{{objCashBankPmtListItem.draftNo}}</span>
		         
       </td>
       <td class="width_15" ng-bind="objCashBankPmtListItem.cashbankPmtDate"></td>
       <td class="width_15">
        <span tooltip="{{objCashBankPmtListItem.accountName}}" class="tool-tip-span text-wrap" ng-bind="objCashBankPmtListItem.accountName"></span>
       </td>
       <td class="width_15">
        <span tooltip="{{objCashBankPmtListItem.narration}}" class="tool-tip-span text-wrap" ng-bind="objCashBankPmtListItem.narration"></span>
       </td>
       <td class="width_10  text-right" ng-bind="objCashBankPmtListItem.bcAmountHdr"></td>
       <td class="width_10  text-right" ng-bind="objCashBankPmtListItem.tcAmountHdr"></td>
       <td class="width_10 td-actions text-center">
  <i class="fa  fa-pencil text-success text" data-ng-click="editRowBtn(objCashBankPmtListItem.draftNo)" tooltip="Edit"></i>
           <!--  <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteCBRcptRow(objCashBankPmtListItem.draftNo)" tooltip="Delete"></i> -->
        </td>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
 </div>
</div>
</div>
 <script type="text/ng-template" id="cbpaymentDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeCBPDialog()">Cancel</button>
</div>
 </script>
