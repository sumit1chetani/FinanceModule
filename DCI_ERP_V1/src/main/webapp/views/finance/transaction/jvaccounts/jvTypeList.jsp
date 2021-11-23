<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <div>

   <%@include file="/views/templates/panel-header.jsp"%>
  </div><!-- /panel-heading -->
  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_20" st-sort="">JV Type No</th>
       <th class="sorting width_20" st-sort="">JV Type Name</th>
       <th class="sorting width_20" st-sort="">Type</th>
       <th>Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objJVTypeListItem in displayedCollection">
       <td class="width_1" cs-select="objJVTypeListItem.select"></td>
       <td class="width_20" ng-bind="objJVTypeListItem.jvTypeCode"></td>
       <td class="width_20" ng-bind="objJVTypeListItem.jvTypeName"></td>
       <td class="width_20" ng-bind="objJVTypeListItem.jvType"></td>
       <!-- <td class="width_30" ng-bind="objJVTypeListItem.serviceCode"></td> -->
      
       <td class="td-actions text-center">
          <security:authorize access="hasRole('${form_code}_${modify}')">
       <span>
       		<i class="fa fa-pencil text-success text" data-ng-click="editRowBtn(objJVTypeListItem.jvTypeCode)" tooltip="Edit"></i>
       </span>
        </security:authorize>
           <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objJVTypeListItem.jvTypeCode,$index)" tooltip="Delete"></i>
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
 <script type="text/ng-template" id="JVTypeDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeJVTypeDialog()">Cancel</button>
</div>
 </script>