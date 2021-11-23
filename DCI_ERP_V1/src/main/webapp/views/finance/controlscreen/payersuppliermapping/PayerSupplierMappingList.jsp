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
   <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_20" st-sort="objListItem.payerAcctCode">Payer Acct Code</th>
       <th class="sorting width_30" st-sort="objListItem.payerName">Payer Name</th>
       <th class="sorting width_20" st-sort="objListItem.supplierAcctCode">Supplier Acct Code</th>
       <th class="sorting width_30 text-wrap" st-sort="objListItem.supplierName">Supplier Name</th>       
       <!-- <th>Action</th> -->
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objListItem in displayedCollection">
       <td class="width_1" cs-select="objListItem"></td>
       
       <td class="width_20" ng-bind="objListItem.payerAcctCode"></td>
       <td class="width_30">
        <span tooltip="{{objListItem.payerName}}" class="tool-tip-span text-wrap" ng-bind="objListItem.payerName"></span>
       </td>
       <td class="width_20" ng-bind="objListItem.supplierAcctCode"></td>
       <td class="width_30">
       	<span tooltip="{{objListItem.supplierName}}" class="tool-tip-span text-wrap" ng-bind="objListItem.supplierName"></span>
       </td>
       <%-- <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
          <span ng-if="objListItem.urIsEdit=='true'">
          <i class="fa  fa-pencil text-success text" data-ng-click="editRowBtn(objListItem.cbVoucherNo)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span ng-if="objListItem.urIsDelete=='true'">
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objListItem.cbVoucherNo)"></i>
         </span>
        </security:authorize>
       </td> --%>
      </tr>
     </tbody>
    </table>
   </div>
   <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
 </div>
</div>
 