<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id" />
    <div class="panel panel-default">
   <div class="panel-body float-left padding-0">
    <div class="table-responsive ">
     <table class="table table-striped table-hover dataTable no-footer">
      <thead class="dataTables-Main-Head">
       <tr>
        <th class="width_1">
        </th>
        <th class="sorting" st-sort="puchaseInvoiceNo">Allocation No</th>
        <!-- <th class="sorting" st-sort="jvNo">Journal No</th> -->
        <th class="sorting" st-sort="partyInvoiceNo">Party Invoice No.</th>
        <th class="sorting" st-sort="puchaseInvoiceDate">Date</th>
        <th class="sorting" st-sort="supplier">Supplier</th>
        <th class="sorting" st-sort="description">Description</th>
        <th class="sorting" st-sort="createdBy">Created By</th>
        <th class="text-center">Action</th>
       </tr>
      </thead>
      <tbody class="dataTables-Main-Body">
       <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPuInvHdrLstBean in displayedCollection">
        <td class="">
         <label class="i-checks m-b-none">
          <input type="checkbox" name="post[]">
          <i></i>
         </label>
         <td><span>
        <a ng-click="view(objPuInvHdrLstBean.puchaseInvoiceNo)">
    <span tooltip="{{objPuInvHdrLstBean.puchaseInvoiceNo}}" class="tool-tip-span font-blue">{{objPuInvHdrLstBean.puchaseInvoiceNo}}</span>
          </a></span>
          
        </td>
        <!-- <td>
         <span>
        <a ng-click="printJournalVoucherDiv(objPuInvHdrLstBean.jvNo)">
    <span tooltip="{{objPuInvHdrLstBean.jvNo}}" class="tool-tip-span font-blue">{{objPuInvHdrLstBean.jvNo}}</span>
          </a></span>
          
        </td> -->
        <td class="sorting ">{{objPuInvHdrLstBean.partyInvoiceNo}}</td>
        <td class="sorting ">{{objPuInvHdrLstBean.puchaseInvoiceDate}}</td>        
        <td class="sorting ">{{objPuInvHdrLstBean.supplierName}}</td>
        <td class="sorting ">{{objPuInvHdrLstBean.description}}</td>
        <td class="sorting ">{{objPuInvHdrLstBean.createdBy}}</td>
        <td class=" td-actions text-center">
         <%-- <security:authorize access="hasRole('${form_code}_${modify}')">
          <span ng-if="objPuInvHdrLstBean.puchaseInvoiceNo.indexOf('PIA') > -1">
           <i class="fa  fa-pencil text-success text" data-ng-click="editPIARow(objPuInvHdrLstBean.puchaseInvoiceNo,$index)"></i>
          </span>
         </security:authorize> --%>
        <security:authorize access="hasRole('${form_code}_${modify}')">
          <span ng-if="objPuInvHdrLstBean.puchaseInvoiceNo.indexOf('PDA') > -1">
           <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objPuInvHdrLstBean.puchaseInvoiceNo,$index)"></i>
          </span>
         </security:authorize> 
         
         <%-- <security:authorize access="hasRole('${form_code}_${modify}')">
          <span ng-if="objPuInvHdrLstBean.urIsEdit=='true'">
           <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objPuInvHdrLstBean.puchaseInvoiceNo,$index)"></i>
          </span>
         </security:authorize>
         <security:authorize access="hasRole('${form_code}_${delete}')">
          <span ng-if="objPuInvHdrLstBean.urIsDelete=='true'">
           <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPuInvHdrLstBean.puchaseInvoiceNo,$index)"></i>
          </span>
         </security:authorize> --%>
        </td>
       </tr>
      </tbody>
     </table>
    </div>
    <footer class="panel-footer panel-footer-list">
     <%@include file="/views/templates/panel-footer.jsp"%>
    </footer>
   </div> <!-- /panel-body -->
  </div>
 </div>
</div>
 <script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
 <div class="col-lg-12">
  <div class="col-lg-12">
   <!--<input type="file"  class="form-control btn-primary" id="file" name="file">-->
   <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadPIFile(this)"  accept=".xls,.xlsx,.xlsm" />
  </div>
 </div> 
</div>
<div class="modal-footer">
 <button class="btn btn-info" type="button" ng-click="uploadPIStatement()">OK</button>
 <button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>
 