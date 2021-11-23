


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
								<label class="col-md-5 control-label  vessel-text">Voucher No</label>
								<div class="col-md-7">
									<selectivity list="rowCollection" property="paymentCode"  ng-model="txtPaymentCode" 
								        id="txtCbVoucherNo"></selectivity>	
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-8 col-md-8 col-lg-8">
						<!-- <button class="btn btn-primary" type="button"
							data-ng-click="copyPayment();">
							Copy Payment
						</button>	 -->				
						<button class="btn btn-success" type="button"
							data-ng-click="reversePayment();">
							Reverse Payment
						</button>
					</div>
				</div>			
			</div>
		</div> 
		
      <div class="widget-body no-padding">
      
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        st-table="displayedCollection" st-safe-src="rowCollection">
        
        <div class="dt-toolbar">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>		</div>
        <table id="dt_basic" class="table table-layout-fixed table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
	      <tr>
	       <!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">  <input type="checkbox"> <i></i> </label>
           </th> -->
	       <th class="sorting width_25 text-center" st-sort="objCashBankPmtListItem.cbVoucherNo">Voucher No</th>
	       <th class="sorting width_15 text-center" st-sort="objCashBankPmtListItem.cashbankPmtDate">Voucher Date</th>
	       <th class="sorting width_25 text-center" st-sort="objCashBankPmtListItem.invoices">Sub Account Name</th> 
  	     <!--   <th class="sorting width_25 text-center" st-sort="objCashBankPmtListItem.invoices">Bank/Cash</th> -->   
 	       <th class="sorting width_25 text-center" st-sort="objCashBankPmtListItem.accountName">Bank/Cash Account Name</th>
	       <th class="sorting width_12 text-center" st-sort="objCashBankPmtListItem.bcAmountHdr">Amount</th>
<!-- 	       <th class="sorting width_15 text-center" st-sort="objCashBankPmtListItem.reverseCb">Is Reverse</th>
 -->	       <th class="width_10 text-center table-heading">Action</th>
	      </tr>
	     </thead>
         <tbody class="dataTables-Main-Body">
	     	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCashBankPmtListItem in displayedCollection">
		       	<!-- <td class="width_1 text-center" cs-select="objCashBankPmtListItem"></td> -->
<!-- 		       	<td class="width_25" ng-bind="objCashBankPmtListItem.cbVoucherNo" data-ng-click="viewCBPmtRow(objCashBankPmtListItem.cbVoucherNo)"></td>
 -->		       	
 
    	<td> 
		       	<a data-ng-click="viewCBPmtRow(objCashBankPmtListItem.cbVoucherNo)" class="width_25" ng-bind="objCashBankPmtListItem.cbVoucherNo" > 
		       	<span tooltip="{{objCashBankPmtListItem.cbVoucherNo}}" class="tool-tip-span font-blue">{{objCashBankPmtListItem.cbVoucherNo}}</span> 
		       	</a> 
		       	</td>
 
 <td class="width_10" ng-bind="objCashBankPmtListItem.cashbankPmtDate"></td>
<!-- 		       	<td class="width_25 text-breakword" ng-bind="objCashBankPmtListItem.pmtType"></td>
 -->  		       	<td class="width_25 text-breakword" ng-bind="objCashBankPmtListItem.subAccountName"></td>
 		       	<td class="user-image" style="min-width: 85%;" data-toggle="tooltip" title="{{objCashBankPmtListItem.accountName}}" ng-bind="objCashBankPmtListItem.accountName"></td>
		       	<td class="width_12 text-right" ng-bind="objCashBankPmtListItem.bcAmountHdr|number:2"></td>
<!-- 		       	<td class="width_10" ng-bind="objCashBankPmtListItem.reverseCb"></td>
 -->		       	<td class="width_15 td-actions text-center">
		<!--        	 <td class="">
		     x
</td> -->
			      <%--   <security:authorize access="hasRole('${form_code}_${modify}')">
				       	<span>
				       		<i class="fa  fa-pencil text-success text" data-ng-click="editCBPmtRow(objCashBankPmtListItem.cbVoucherNo)" tooltip="Edit"></i>
				       	</span>
			       	</security:authorize> --%>
<%-- 			       	 <security:authorize access="hasRole('${form_code}_${view}')">
 --%>				       	<span>
				       		<i class="fa  fa-list-alt text-dark text" data-ng-click="viewCBPmtRow(objCashBankPmtListItem.cbVoucherNo)" tooltip="Edit"></i>
				       	</span>
<%-- 			       	</security:authorize>
 --%>		        	<%--  <security:authorize access="hasRole('${form_code}_${delete}')">
				        <span>
				        <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteCBPmtRow(objCashBankPmtListItem,$index)" tooltip="Delete"></i>
				        </span>
			        </security:authorize>  --%>
			         <span>
			         	<i class="" title="Print" 
			         	data-ng-click=""></i>
			        </span> 
			        
			           <span>
			         	<i class="fa  fa-print text-success text" title="Print" 
			         	 data-ng-click="printPaymentVoucherDiv(objCashBankPmtListItem.cbVoucherNo)"></i>
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
 </div> <!-- /dataTables_wrapper -->
      </div> <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>