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
  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_10" st-sort="">Pr Code</th>
       <th class="sorting width_10" st-sort="">Pr Date</th>
       <th class="sorting width_25" st-sort="">Company</th>
       <th class="sorting width_25" st-sort="">Customer</th>
       <th class="sorting width_10" st-sort="">Chq No</th>
       <th class="sorting width_10" st-sort="">Chq Date</th>
       <th class="sorting width_10" st-sort="">Amnt</th>
       <th>Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPresentationList in displayedCollection">
       <td class="width_1" cs-select="objPresentationList"></td>
       
       <td><span ng-if="objPresentationList.urIsView=='t'">
       <a ng-click="view(objPresentationList.prCode)">
		 <span tooltip="{{objPresentationList.prCode}}" class="tool-tip-span font-blue">{{objPresentationList.prCode}}</span>
         </a></span>
         <span ng-if="objPresentationList.urIsView=='f'">
         <span tooltip="{{objPresentationList.prCode}}" class="tool-tip-span">{{objPresentationList.prCode}}</span>
         </span>
       </td>
       <td class="width_9" ng-bind="objPresentationList.presentDate">
       </td>
        <td class="width_28" ng-bind="objPresentationList.companyName"></td>
       <td class="width_25" ng-bind="objPresentationList.customerName"></td>
       <td class="width_10" ng-bind="objPresentationList.chqNo"></td>
       <td class="width_9" ng-bind="objPresentationList.chqDate">
       </td>
       <td class="width_9 text-right" ng-bind="objPresentationList.chqAmnt">
       </td>
       <td class="td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span ng-if="objPresentationList.urIsEdit=='t'">
         <i class="fa  fa-pencil text-success text" data-ng-click="editpr(objPresentationList.prCode)" tooltip="Edit"></i>
        </span>
         </security:authorize>
          <security:authorize access="hasRole('${form_code}_${delete}')">
        <span ng-if="objPresentationList.urIsDelete=='t'">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPresentationList.prCode,$index)" tooltip="Delete"></i>
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