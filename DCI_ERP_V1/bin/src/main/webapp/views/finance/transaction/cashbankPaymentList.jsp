
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  

   <%@include file="/views/templates/panel-header.jsp"%>
    <input type="hidden" value="${form_code}" id="form_code_id">
  <!-- /panel-heading -->
  <div class="panel panel-default">
		<div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-3 col-lg-3 ">
						<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Payment</label>
							<div class="col-md-6">
								<selectivity list="rowCollection" property="paymentCode" id="paymentCode"></selectivity>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="col-sm-12 col-md-9 col-lg-9 ">
					<button type="button" class="btn btn-primary" type="button"
						data-ng-click="copyPayment();">
						Copy Payment
					</button>
					<%-- <security:authorize access="hasRole('${form_code}_${approve}')"> --%>
						<button type="button" class="btn btn-success" type="button"
							data-ng-click="reversePayment();">
							Reverse Payment
						</button>
					<%-- </security:authorize> --%>
					<!-- <button class="btn btn-success" type="button"
						data-ng-click="prepaidExpenseAutoJV();">
						Prepaid Expense
					</button>  -->
					<button type="button" class="btn btn-info" 
						data-ng-click="getCBRcptListdraft();">
						View Draft Lists
					</button>
				<a href="#/{{tenantId}}/transaction/cashbankpaymenthdr/manualAllocation" class="btn btn-info" role="button" data-ng-click="manualAllocation();">Manual Allocation</a>
			<!-- 	<button type="button" class="btn btn-info" type="button"
						data-ng-click="unallocatedAdvance();">
						Unallocated Advance
					</button> -->
			</div>
		</div>
	</div>
   <div class="table-responsive" style=" border: 1px solid #CCC;">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
      <tr role="row">
     <!--   <th class="width_1"></th> -->
       <th class="sorting width_15" st-sort="cbVoucherNo">Voucher No</th>
       <th class="sorting width_10" st-sort="cashbankPmtDate">Voucher Dt</th>
       <th class="sorting width_20" st-sort="accountName">Bank Account Name</th>
       <th class="sorting width_20" st-sort="paidTo">Vendor</th>
       <th class="sorting width_30" st-sort="narration">Narration</th>
       <th class="sorting width_30" st-sort="chequeNo">Cheque No</th>
       <th class="sorting width_10 text-wrap" st-sort="bcAmountHdr">BC Amt</th>
       <th class="sorting width_10 text-wrap text-wrap-amtusd" st-sort="tcAmountHdr">TC Amt</th>
       <th class="sorting width_10 text-wrap" st-sort="users">Users</th>
       <th class="sorting width_10 text-wrap" st-sort="invoiceMap">Invoice Dtls</th>
       <th class="">Action</th>
       <!-- <th>Action</th> -->
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCashBankPmtListItem in displayedCollection">
     <!--   <td class="width_1" cs-select="objCashBankPmtListItem"></td> -->
<!--        <td class="width_20" ng-bind="objCashBankPmtListItem.cbVoucherNo"></td> -->
       <td><span>
       <a ng-click="view(objCashBankPmtListItem.cbVoucherNo)">
		             <span tooltip="{{objCashBankPmtListItem.cbVoucherNo}}" class="tool-tip-span font-blue">{{objCashBankPmtListItem.cbVoucherNo}}</span>
		         </a></span>
		        <!--  <span ng-if="objCashBankPmtListItem.urIsView=='f'">
		         <span tooltip="{{objCashBankPmtListItem.cbVoucherNo}}" class="tool-tip-span">{{objCashBankPmtListItem.cbVoucherNo}}</span>
		         </span> -->
       </td>
       <td class="width_15" ng-bind="objCashBankPmtListItem.cashbankPmtDate"></td>
       <td class="width_15">
        <span tooltip="{{objCashBankPmtListItem.accountName}}" class="tool-tip-span text-wrap" ng-bind="objCashBankPmtListItem.accountName"></span>
       </td>
       <td class="width_15">
        <span tooltip="{{objCashBankPmtListItem.paidTo}}" class="tool-tip-span text-wrap" ng-bind="objCashBankPmtListItem.paidTo"></span>
       </td>
       <td class="width_15">
        <span tooltip="{{objCashBankPmtListItem.narration}}" class="tool-tip-span text-wrap" ng-bind="objCashBankPmtListItem.narration"></span>
       </td>
       <td class="width_15">
        <span tooltip="{{objCashBankPmtListItem.chequeNo}}" class="tool-tip-span text-wrap" ng-bind="objCashBankPmtListItem.chequeNo"></span>
       </td>
       <td class="width_10  text-right" ng-bind="objCashBankPmtListItem.bcAmountHdr1"></td>
       <td class="width_10  text-right" ng-bind="objCashBankPmtListItem.tcAmountHdr1"></td>
       <td class="width_10  text-right" ng-bind="objCashBankPmtListItem.createdBy"></td>
       <td class="width_10  text-right" ng-bind="objCashBankPmtListItem.invoiceMap"></td>
       <td class="width_10 td-actions text-center">
	    <security:authorize access="hasRole('${form_code}_${print}')">
          <span data-ng-click="printPaymentVoucherDiv(objCashBankPmtListItem.cbVoucherNo)"
								id="{{objCashBankPmtListItem.cbVoucherNo}}" title="Print"
								class=" glyphicon glyphicon-print " data-toggle="tooltip" title="Print"
								style="cursor: pointer; color: gray;"></span>
								</security:authorize>
        <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
          <i class="fa  fa-pencil text-success text" data-ng-click="editRowBtn(objCashBankPmtListItem.cbVoucherNo)"></i>
         </span>
        </security:authorize>
         <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objCashBankPmtListItem.cbVoucherNo)"></i>
         </span>
        </security:authorize>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer" style="padding:0px;">
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
