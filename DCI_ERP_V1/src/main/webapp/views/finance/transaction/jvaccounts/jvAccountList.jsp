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
       <th class="sorting width_15" st-sort="jVAccountCode">JV Account Code</th>
       <th class="sorting width_15" st-sort="jvAccountDate">JV Account Date</th>
       <th class="sorting width_15" st-sort="vesselName">Vessel Name</th>
       <th class="sorting width_15" st-sort="voyageCode">Voyage Code</th>
       <th class="sorting width_30" st-sort="vendorName">Vendor Name</th>
       <th >Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">
       <td cs-select="objTranslationItem"></td>
       <td>
       	 <a href="#/transaction/jvaccounts/jvaccounting/view/{{objTranslationItem.jVAccountCode}}">
         <span tooltip="{{objTranslationItem.jVAccountCode}}" class="tool-tip-span" ng-bind="objTranslationItem.jVAccountCode">
         </span></a>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.jvAccountDate}}" class="tool-tip-span" ng-bind="objTranslationItem.jvAccountDate"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.vesselName}}" class="tool-tip-span" ng-bind="objTranslationItem.vesselName"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.voyageCode}}" class="tool-tip-span" ng-bind="objTranslationItem.voyageCode"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.vendorName}}" class="tool-tip-span" ng-bind="objTranslationItem.vendorName"></span>
       </td>
       <td class="td-actions text-center">
         <security:authorize access="hasRole('${form_code}_${modify}')">
        <span >
         <i class="fa fa-pencil text-success text" data-ng-click="edit(objTranslationItem.jVAccountCode)" tooltip="Edit">
         </i>
        </span>
         </security:authorize>
         <security:authorize access="hasRole('${form_code}_${delete}')">
        <span class ="padding-left-10">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteJVAccount(objTranslationItem.jVAccountCode)" tooltip="Delete"></i>
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

 <script type="text/ng-template" id="JVAccountDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeJVAccountDialog()">Cancel</button>
</div>
 </script>