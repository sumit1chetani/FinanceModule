

<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
 
 <div class="panel-body float-left padding-0" style="width: 100%;">

<br>

     <div role="content">
       <div class="form-body form-horizontal">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="col-sm-4 col-md-4 col-lg-4">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Receipt Voucher No</label>
							<div class="col-md-6">
								<selectivity list="rowCollection" property="receiptCode" id="receiptNo"></selectivity>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="col-sm-8 col-md-8 col-lg-8">
					<!-- <button class="btn btn-primary" type="button"
						data-ng-click="copyReceipt();">
						Copy Receipt
					</button> -->
				
					<button class="btn btn-success" type="button"
						data-ng-click="reverseReceipt();">
						Reverse Receipt
					</button>
				</div>
			</div>
		
		</div>
	  </div> 
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        st-table="displayedCollection" st-safe-src="rowCollection">
        <!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
        <div class="dt-toolbar">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>		</div>
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
          <!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
            <th class="sorting width_8" st-sort="voucherNo">Organization
           </th>
           <th class="sorting width_8" st-sort="voucherNo">Voucher Number
           </th>
           <th class="sorting width_10" st-sort="cbReceiptDate">Voucher Date
           </th>
         <!--   <th class="sorting width_10" st-sort="invoiceNo">Invoice No
           </th> -->
          <!--  <th class="sorting width_10" st-sort="subaccountname">Sub Account Name
           </th> -->
           <th class="sorting width_10" st-sort="accountName">Bank/Cash
           </th>
            <th class="sorting width_5 " st-sort="bcAmountHdr">Amount</th>
<!-- 	       <th class="sorting width_5 " st-sort="objCashBankRCptListItem.reverseCb">Is Reverse</th>
 -->           <th class="width_5 table-heading text-center">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCashBankRCptListItem in displayedCollection">
	       <!-- <td class="width_1" cs-select="objCashBankRCptListItem"></td> -->
	     <td class="width_10" ng-bind="objCashBankRCptListItem.companyName"></td>
	     
	       <td class="width_8"><span
								> <a
									href="#/dci/hospital/accounts/paymentreceipt/view/{{objCashBankRCptListItem.voucherNo}}">
										<span tooltip="{{objCashBankRCptListItem.voucherNo}}"
										class="tool-tip-span font-blue"
										ng-bind="objCashBankRCptListItem.voucherNo"> </span>
								</a>
							</span></td>
	      
	       <td class="width_10" ng-bind="objCashBankRCptListItem.cbReceiptDate"></td>
<!-- 	       <td class="width_10" ng-bind="objCashBankRCptListItem.invoices"></td>
 -->	      
<!--   <td class="width_10" ng-bind="objCashBankRCptListItem.subaccountname"></td>
 -->	       <td class="width_10">
	        <span tooltip="{{objCashBankRCptListItem.accountName}}" class="tool-tip-span text-wrap" ng-bind="objCashBankRCptListItem.accountName"></span>
	       </td>
	        <td class="width_5" ng-bind="objCashBankRCptListItem.bcAmountHdr"></td>
<!-- 	       <td class="width_5" ng-bind="objCashBankRCptListItem.referenceNo"></td>
 -->	       <td class="width_5 td-actions text-center">
	          <security:authorize access="hasRole('${form_code}_${view}')">
		        <span class="">
		         <i class="fa  fa-list-alt text-dark text" data-ng-click="viewCBRcptRow(objCashBankRCptListItem)"></i>
		        </span>
		        </security:authorize>
	         <security:authorize access="hasRole('${form_code}_${delete}')">
	        <span>
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteCBRcptRow(objCashBankRCptListItem.voucherNo, $index)" tooltip="Delete"></i>
	        </span>
	        </security:authorize>
	         <span>
	         <i class="fa fa-print text-success text" data-ng-click="printReceiptVoucherDiv(objCashBankRCptListItem.voucherNo)"></i>
	        </span>
	        <!--    <span>
	         <i class="fa  fa-print text-success text" data-ng-click="printReceiptVoucherDivoff(objCashBankRCptListItem.voucherNo)"></i>
	        </span> -->
	        
	        <span>
	         <i class="fa fa-print text-success text" data-ng-click="payerReceipt(objCashBankRCptListItem.voucherNo)"></i>
	        </span>
	        
	       </td>
	      </tr>
	     </tbody>
        </table>
<!--         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->   
 
<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
 
     </div>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
