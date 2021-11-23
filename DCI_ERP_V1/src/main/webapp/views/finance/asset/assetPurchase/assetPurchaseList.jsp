<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
    <input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body float-left padding-0" style="width:100%">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th class="width_1">
       </th>
       <th class="sorting" st-sort="date">Asset pur No.</th>
       <th class="sorting" st-sort="supplier">Asset Name</th>
       <th class="sorting" st-sort="description">Supplier</th>
       <th class="sorting" st-sort="description">Company</th>
       <th class="sorting" st-sort="description">Amount</th>
<!--        <th class="text-center">Action</th>
 -->      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPurchaseAssetBean in displayedCollection">
       <td class="">
        <!-- <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label> -->
       
       <td class="sorting ">{{objPurchaseAssetBean.assetPurchaseNo}}</td>
       <td class="sorting ">{{objPurchaseAssetBean.assetName}}</td>
        <td class="sorting ">{{objPurchaseAssetBean.supplierName}}</td>
         <td class="sorting ">{{objPurchaseAssetBean.companyName}}</td>
         <td class="sorting ">{{objPurchaseAssetBean.bcAmount}}</td>
       <%-- <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span ng-if="objPuInvHdrLstBean.urIsEdit=='true'">
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objPuInvHdrLstBean.puchaseInvoiceNo,$index)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span ng-if="objPuInvHdrLstBean.urIsDelete=='true'">
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPuInvHdrLstBean.puchaseInvoiceNo,$index)"></i>
         </span>
        </security:authorize>
       </td> --%>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer.jsp"%>
   </footer>
  </div>
 </div>
</div>