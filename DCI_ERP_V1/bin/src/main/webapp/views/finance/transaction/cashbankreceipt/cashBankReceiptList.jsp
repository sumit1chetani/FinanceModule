<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="wrapper-md">
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
							<label class="col-md-5 control-label  vessel-text">Receipt</label>
							<div class="col-md-6">
								<selectivity list="rowCollection" property="receiptCode" id="receiptNo"></selectivity>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="col-sm-12 col-md-9 col-lg-9 ">
					<button class="btn btn-primary" type="button"
						data-ng-click="copyReceipt();">
						Copy Receipt
					</button>
<%-- 					<security:authorize access="hasRole('${form_code}_${approve}')">
 --%>					<button class="btn btn-success" type="button"
						data-ng-click="reverseReceipt();">
						Reverse Receipt
					</button>
				<%-- 	</security:authorize> --%>
					<button class="btn btn-info" type="button"
						data-ng-click="invoiceAllocation();">
						Invoice Allocation
					</button>
						<button class="btn btn-info" type="button"
						data-ng-click="getCBRcptListdraft();">
						View Draft Lists
					</button>
				</div>
			</div>
		</div>
	
<div class="table-responsive" style=" border: 1px solid #CCC;">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_15" st-sort="voucherNo">Voucher No</th>
       <th class="sorting width_10" st-sort="cbReceiptDate">Voucher Dt</th>
       <th class="sorting width_30" st-sort="accountName">Bank/Cash</th>
       <th class="sorting width_20" st-sort="receivedFrom">Customer</th>
       <th class="sorting width_10" st-sort="cbReceiptDate">Cheque No</th>
        <th class="sorting width_10" st-sort="reversedFor">Reversed For</th>
       <th class="sorting width_10" st-sort="tcAmt">TC Amount</th>
       <th class="sorting width_10" st-sort="bcAmt">BC Amount</th>
       <th class="sorting width_10" st-sort="createdBy">Users</th>
       <th class="sorting width_10" st-sort="invoiceMap">Invoice Dtls</th>
       <th>Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCashBankRCptListItem in displayedCollection">
       <td class="width_1" cs-select="objCashBankRCptListItem"></td>
       <td class="width_20" >
        <span>
       	<a ng-click="view(objCashBankRCptListItem.voucherNo)">
	     <span tooltip="{{objCashBankRCptListItem.voucherNo}}" class="tool-tip-span font-blue" ng-bind="objCashBankRCptListItem.voucherNo">
	     </span></a></span>
	  <!--     <span ng-if="objCashBankRCptListItem.urIsView=='f'">
	      <span tooltip="{{objCashBankRCptListItem.voucherNo}}" class="tool-tip-span" ng-bind="objCashBankRCptListItem.voucherNo">
	      </span>
	      </span> -->
       </td>
       <td class="width_15" ng-bind="objCashBankRCptListItem.cbReceiptDate"></td>
       <td class="width_15">
        <span tooltip="{{objCashBankRCptListItem.accountName}}" class="tool-tip-span text-wrap" ng-bind="objCashBankRCptListItem.accountName"></span>
       </td>
       <td class="width_15">
        <span tooltip="{{objCashBankRCptListItem.receivedFrom}}" class="tool-tip-span text-wrap" ng-bind="objCashBankRCptListItem.receivedFrom"></span>
       </td>
        <td class="width_15" ng-bind="objCashBankRCptListItem.chequeNO"></td>
            <td class="width_15" ng-bind="objCashBankRCptListItem.reversedFor"></td>
        <td class="width_15" ng-bind="objCashBankRCptListItem.tcamount"></td>
        <td class="width_15" ng-bind="objCashBankRCptListItem.bcamount"></td>
        <td class="width_15" ng-bind="objCashBankRCptListItem.createdBy"></td>
        <td class="width_15" ng-bind="objCashBankRCptListItem.invoiceMap"></td>
       <td class="width_10 td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${print}')">
          <span data-ng-click="print(objCashBankRCptListItem.voucherNo)"
								id="{{objCashBankRCptListItem.voucherNo}}" title="Print"
								class=" glyphicon glyphicon-print " data-toggle="tooltip" title="Print"
								style="cursor: pointer; color: gray;"></span>
								</security:authorize>
       <security:authorize access="hasRole('${form_code}_${modify}')">
       <span > 
         <i class="fa  fa-pencil text-success text" data-ng-click="editRowBtn(objCashBankRCptListItem.voucherNo)" tooltip="Edit"></i>
        </span>
           </security:authorize>
         <security:authorize access="hasRole('${form_code}_${delete}')">
         <span >
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteCBRcptRow(objCashBankRCptListItem.voucherNo)" tooltip="Delete"></i>
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
 <script type="text/ng-template" id="cbReceiptDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeCBRcptDialog()">Cancel</button>
</div>
 </script>