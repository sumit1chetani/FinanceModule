<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_15" st-sort="InvoiceNo">Invoice No</th>
       <th class="sorting width_12" st-sort="InvoiceDate">Invoice Date</th>
       <th class="sorting width_25" st-sort="customer">Customer</th>
       <th class="sorting width_25" st-sort="mlo">Payer</th>
       <th class="sorting width_12" st-sort="blrelated">BL Related</th>
       <th class="width_15">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPRInvoiceListItem in displayedCollection">
       <td cs-select="objPRInvoiceListItem"></td>
       
       <td class="width_15">
       <span ng-if="objPRInvoiceListItem.urIsView=='true'">       
       <a ng-click="view(objPRInvoiceListItem.InvoiceNo)">
       
		 <span tooltip="{{objPRInvoiceListItem.InvoiceNo}}" class="tool-tip-span font-blue" ng-bind="objPRInvoiceListItem.InvoiceNo"></span>
         </a></span>
         <span ng-if="objPRInvoiceListItem.urIsView=='false'">
         	<span tooltip="{{objPRInvoiceListItem.InvoiceNo}}" class="tool-tip-span" ng-bind="objPRInvoiceListItem.InvoiceNo"></span>
         </span>
       </td>
       <!-- <td>
         <span tooltip="{{objPRInvoiceListItem.InvoiceNo}}" class="tool-tip-span" ng-bind="objPRInvoiceListItem.InvoiceNo"></span>
       </td> -->
       <td class="width_12">
        <span tooltip="{{objPRInvoiceListItem.InvoiceDate}}" class="tool-tip-span" ng-bind="objPRInvoiceListItem.InvoiceDate"></span>
       </td>
       <td class="width_25">
        <span tooltip="{{objPRInvoiceListItem.CustomerName}}" class="tool-tip-span" ng-bind="objPRInvoiceListItem.CustomerName"></span>
       </td>
       <td class="width_25">
        <span tooltip="{{objPRInvoiceListItem.MloName}}" class="tool-tip-span" ng-bind="objPRInvoiceListItem.MloName"></span>
       </td>
       <td class="width_12">
        <span tooltip="{{objPRInvoiceListItem.BlRelated}}" class="tool-tip-span" ng-bind="objPRInvoiceListItem.BlRelated"></span>
       </td>
       <td class="width_15 td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <!-- <span class="padding-both-side-2" ng-if="objPRInvoiceListItem.urIsEdit=='true'">
         <i class="fa fa-pencil text-success text" data-ng-click="editRowBtn(objPRInvoiceListItem.InvoiceNo)" tooltip="Edit"></i>
        </span> -->
        </security:authorize>
         <security:authorize access="hasRole('${form_code}_${delete}')">
       <!-- <span class="padding-both-side-2" ng-if="objPRInvoiceListItem.urIsDelete=='true'">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPRInvoiceListItem.InvoiceNo)" tooltip="Delete"></i>
        </span> -->
        </security:authorize>
           			   <security:authorize access="hasRole('${form_code}_${print}')">  
							    &nbsp;&nbsp;<span ng-click="printProvisionalInvoiceDiv(objPRInvoiceListItem.InvoiceNo)" 
								id="{{objPRInvoiceListItem.InvoiceNo}}"
								class=" glyphicon glyphicon-print "
								style="cursor: pointer; color: gray;"></span>
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
<script type="text/ng-template" id="generalInvoiceDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeGeneralInvoiceDeleteDialog()">Cancel</button>
</div>
 </script>