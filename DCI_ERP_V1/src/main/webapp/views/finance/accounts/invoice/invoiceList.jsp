

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
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
	     <thead class="dataTables-Main-Head">
	      <tr role="row">
	       <!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
	       <th class="sorting width_15" st-sort="invoiceNo">Invoice No</th>
	       <th class="sorting width_10" st-sort="invoiceDate">Invoice Date</th>
	       <th class="sorting width_30" st-sort="customer">Customer</th>
	       <th class="sorting width_10" st-sort="amount">Invoice Amount</th>
	       <th class="sorting width_10" st-sort="receivedStatus">Received Status</th>	       
	       <th class="width_10 text-center table-heading">Action</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">
	       <!-- <td cs-select="objTranslationItem" class="text-center"></td> -->
	       <td class="width_15">
	         <span tooltip="{{objTranslationItem.invoiceNo}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceNo"></span>
	       </td>
	       <td class="width_10">
	        <span tooltip="{{objTranslationItem.invoiceDate}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceDate"></span>
	       </td>
	       <td class="width_30">
	        <span tooltip="{{objTranslationItem.customer}}" class="tool-tip-span" ng-bind="objTranslationItem.customer"></span>
	       </td>
	       <td class="width_10 text-right">
	        <span tooltip="{{objTranslationItem.amount}}" class="tool-tip-span" ng-bind="objTranslationItem.amount|number:2"></span>
	       </td>
	       <td class="width_10" tooltip="{{objTranslationItem.receivedStatus}}" ng-bind="objTranslationItem.receivedStatus"></td>
	       <td class="width_10 td-actions text-center">
	      	<security:authorize access="hasRole('${form_code}_${modify}')">
	      	<span ng-if="objTranslationItem.receivedStatus != 'Partially Received' && objTranslationItem.receivedStatus != 'Received'">
	         <i class="fa fa-pencil text-success text" data-ng-click="editRowBtn(objTranslationItem.invoiceNo,$index)" tooltip="Edit"></i>
	        </span>
	        </security:authorize>
	       <%-- <security:authorize access="hasRole('${form_code}_${delete}')">
	        <span ng-if="objTranslationItem.receivedStatus != 'Partially Received' && objTranslationItem
	        .receivedtatus != 'Received'">
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objTranslationItem.invoiceNo,$index)" tooltip="Delete"></i>
	        </span>
	        </security:authorize> --%>
	     <!--    <span>
	         <i class="fa fa-print text-dark text" data-ng-click="printGIRow(objTranslationItem.invoiceNo)"></i>
	        </span> -->
	        
	         <span>
			         	<i class="fa fa-print text-dark text" title="Print" data-ng-click="printPaymentVoucherDiv(objTranslationItem.invoiceNo)"></i>
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
