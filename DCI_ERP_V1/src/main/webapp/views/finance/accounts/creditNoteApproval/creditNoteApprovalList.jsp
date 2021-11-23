
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

        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
        <thead class="dataTables-Main-Head">
        	<tr>
	           <!-- <th class="width_1 text-center table-heading">
	            <label class="i-checks m-b-none">
	             <input type="checkbox">
	             <i></i>
	            </label>
	           </th> -->
	           <th class="sorting width_10" data-st-sort="objCreditNoteListItem.creditNoteCode">Credit Code</th>
	           <th class="sorting width_10" data-st-sort="objCreditNoteListItem.creditNoteDate">Date</th>
	           <th class="sorting width_15" data-st-sort="objCreditNoteListItem.accountName">Account Head</th>
	           <th class="sorting width_10" data-st-sort="objCreditNoteListItem.invoiceNo">Invoice No</th>
	           <th class="sorting width_20" data-st-sort="objCreditNoteListItem.company">Company</th>
	           <th class="sorting width_7" data-st-sort="objCreditNoteListItem.creditAmount">Amount</th>
	           <th class="sorting width_10" data-st-sort="objCreditNoteListItem.creditAmountUSD">Amount USD</th>           
	           <th class="sorting width_7" data-st-sort="objCreditNoteListItem.approveStatus">Status</th>     
	           <th class="width_6 text-center table-heading"><spring:message code="label.action"></spring:message></th>
        	</tr>
        </thead>
		<tbody class="dataTables-Main-Body">
	    	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCreditNoteListItem in displayedCollection">
		      	<!-- <td class="width_1" cs-select="objCreditNoteListItem"></td> -->
		       	<!-- <td class="width_1"> <label class="i-checks m-b-none">
		       		<input type="checkbox" ng-model="objCreditNoteListItem.select" id="select{{trIndex}}"><i></i></label></td> -->
		       	<td class="width_15" ng-bind="objCreditNoteListItem.creditNoteCode"></td>
		       	<td class="width_10" ng-bind="objCreditNoteListItem.creditNoteDate"></td>
		       	<td class="width_10">
		        	<span tooltip="{{objCreditNoteListItem.mloName}}" class="tool-tip-span text-wrap" ng-bind="objCreditNoteListItem.accountName"></span>
		       	</td>
		       	<td class="width_10" ng-bind="objCreditNoteListItem.invoiceNo">
		       	</td>
		       	<td class="width_15">
		       		<span tooltip="{{objCreditNoteListItem.company}}" class="tool-tip-span text-wrap" ng-bind="objCreditNoteListItem.company"></span>
		       	</td>
		       <td class="width_15 text-left" ng-bind="objCreditNoteListItem.creditAmount"></td>
		       <td class="width_15 text-left" ng-bind="objCreditNoteListItem.creditAmountUSD"></td>
		       <td class="width_4" ng-bind="objCreditNoteListItem.approveStatus"></td>
		
		       <td class="td-actions text-center">
		         <security:authorize access="hasRole('${form_code}_${modify}')">
		        <span class="width_15" ng-if="objCreditNoteListItem.approveStatus != 'Approved' && objCreditNoteListItem.approveStatus != 'Rejected'">
		         <i class="fa fa-pencil text-success text" data-ng-click="editApprovalRow(objCreditNoteListItem)" tooltip="Edit"></i>
		        </span>
		        </security:authorize>
		         <security:authorize access="hasRole('${form_code}_${modify}')">
		        <span class="width_10" ng-if="objCreditNoteListItem.approveStatus != 'Approved' && objCreditNoteListItem.approveStatus != 'Rejected'">
		         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteApprovalRow(objCreditNoteListItem,$index)" tooltip="Delete"></i>
		        </span>
		        </security:authorize>
		       </td>
	    	</tr>
	     </tbody>
        </table>
<!--         <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div>
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