

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
        <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <!-- <th class="width_1 text-center table-heading">
        <label class="i-checks m-b-none">
         <input type="checkbox">
         <i></i>
        </label>
       </th> -->
       <th class="sorting" st-sort="puchaseInvoiceNo">Invoice No</th>
              <th class="sorting" st-sort="grnNumber">Grn No</th>
       
       <th class="sorting" st-sort="puchaseInvoiceDate">Date</th>
       <th class="sorting" st-sort="supplier">Supplier</th>
       <th class="sorting" st-sort="description">Description</th>
       <th class="sorting" st-sort="amount">Amount</th>
       <th class="sorting" st-sort="paymentStatus">Payment Status</th>
       
       <th class="width_10 text-center table-heading">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPuInvHdrLstBean in displayedCollection">
       <!-- <td class="text-center" data-cs-select="objPuInvHdrLstBean"></td> -->
       <td class="">{{objPuInvHdrLstBean.puchaseInvoiceNo}}</td>
              <td class="">{{objPuInvHdrLstBean.grnNumber}}</td>
       
       <td class="sorting ">{{objPuInvHdrLstBean.puchaseInvoiceDate}}</td>
       <td class="sorting ">{{objPuInvHdrLstBean.supplier}}</td>
       <td class="sorting ">{{objPuInvHdrLstBean.description}}</td>
       <td class="sorting text-right">{{objPuInvHdrLstBean.amount|number:2}}</td>
       <td class="sorting ">{{objPuInvHdrLstBean.paymentStatus}}</td>       
       <td class=" td-actions text-center">
<%--         <security:authorize access="hasRole('${form_code}_${modify}')">
 --%>        <span ng-if="objPuInvHdrLstBean.paymentStatus != 'Part Paid' && objPuInvHdrLstBean.paymentStatus != 'Fully Paid'">
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objPuInvHdrLstBean.puchaseInvoiceNo,$index)"></i>
        </span>
<%--          </security:authorize>
 --%>      <%--    <security:authorize access="hasRole('${form_code}_${delete}')">
        <span ng-if="objPuInvHdrLstBean.paymentStatus != 'Part Paid' && objPuInvHdrLstBean.paymentStatus != 'Fully Paid'">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPuInvHdrLstBean.puchaseInvoiceNo,$index)"></i>
        </span>
        </security:authorize> --%>
        <span>
         <i class="fa  fa-print text-success text" title="Print"  data-ng-click="printPIRow(objPuInvHdrLstBean.puchaseInvoiceNo)"></i>
        </span>
        
        
       </td>
      </tr>
     </tbody>
    </table>
        <!-- <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div>
       </div> -->
       
         <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
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
<script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
	 <button <a class="btn btn-success" href="tempdoc/PurchaseInvoiceSample.xlsx" class="control-label">Download sample excel file</a>	</button>
   <button class="btn btn-info" type="button" ng-click="uploadPIN()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>