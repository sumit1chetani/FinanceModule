<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
  
  <div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_5" st-sort="invoiceno">Invoice No</th>
       <th class="sorting width_5" st-sort="invoicedt">Invoice Date</th>
       <th class="sorting width_10" st-sort="vessel">Vessel</th>
       <th class="sorting width_10" st-sort="voyage">Voyage</th>
       <th class="sorting width_30" st-sort="payer">Payer</th>
       <th class="sorting width_30" st-sort="mlo">MLO</th>
       <th >Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">
       <td cs-select="objTranslationItem"></td>
       <td>
         <span tooltip="{{objTranslationItem.invoice}}" class="tool-tip-span" ng-bind="objTranslationItem.invoice"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.invoiceDt}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceDt"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.vessel}}" class="tool-tip-span" ng-bind="objTranslationItem.vessel"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.voyage}}" class="tool-tip-span" ng-bind="objTranslationItem.voyage"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.customer}}" class="tool-tip-span" ng-bind="objTranslationItem.customer"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.mlo}}" class="tool-tip-span" ng-bind="objTranslationItem.mlo"></span>
       </td>
       <td class="td-actions text-center">
       <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
         <i class="fa fa-pencil text-success text" data-ng-click="editRowBtn(objTranslationItem.InvoiceNo)" tooltip="Edit"></i>
        </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objTranslationItem.InvoiceNo,$index)" tooltip="Delete"></i>
        </span>
        </security:authorize>
       </td>
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