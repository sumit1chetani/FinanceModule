<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->   
   <%@include file="/views/templates/panel-header.jsp"%>
  <!-- </div> -->
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead>
     <tr>
<!--        <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i> -->
<!--        </label></th> -->
       <th class="sorting width_15" st-sort="groupHeadCode">Voucher No</th>
       <th class="sorting width_20" st-sort="subGroupAcctCode">Voucher Dt</th>
       <th class="sorting width_15" st-sort="subGrpAcctName">Bank Account Name</th>
        <th class="sorting width_15" st-sort="groupHeadCode">Narration</th>
       <th class="sorting width_20" st-sort="subGroupAcctCode">BC Amt</th>
       <th class="sorting width_15" st-sort="subGrpAcctName">TC Amt</th>
       <th class="text-center">Action</th>
      </tr>
      </thead>
       <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCashBankPmtListItem in displayedCollection">
       
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
          <security:authorize access="hasRole('${form_code}_${modify}')">
         <span>
        <i class="fa  fa-pencil text-success text" data-ng-click="editRowBtn(objCashBankPmtListItem.draftNo)" tooltip="Edit"></i>
           <!--  <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteCBRcptRow(objCashBankPmtListItem.draftNo)" tooltip="Delete"></i> -->
       </span>
       </security:authorize>
          <span data-ng-click="print(objCashBankPmtListItem.draftNo)"
								id="{{objCashBankPmtListItem.draftNo}}" title="Print"
								class=" glyphicon glyphicon-print "
								style="cursor: pointer; color: gray;"></span>
        </td>
      </tr>
     </tbody>
     
    </table>
   </div>
      <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  <!-- end widget content -->
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