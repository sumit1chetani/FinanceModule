<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  

   <%@include file="/views/templates/panel-header.jsp"%>
  <!-- /panel-heading -->
  <div class="panel-body" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_10" st-sort="">Realised Date</th>
       <th class="sorting width_10" st-sort="">Presentation</th>
       <th class="sorting width_10" st-sort="">Present Date</th>
       <th class="sorting width_10" st-sort="">Customer</th>
       <th class="sorting width_10" st-sort="">Cheque No</th>
       <th class="sorting width_10" st-sort="">Status</th>
       <th>Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPresentationList in displayedCollection">
       <td class="width_1" cs-select="objPresentationList"></td>
       <td class="width_10" ng-bind="objPresentationList.realisedDate"></td>
        <td class="width_10" ng-bind="objPresentationList.prCode"></td>
       <td class="width_10" ng-bind="objPresentationList.presentDate"></td>
       <td class="width_24" ng-bind="objPresentationList.customerName"></td>
       <td class="width_10" ng-bind="objPresentationList.chqNo"></td>
       <td class="width_10" ng-bind="objPresentationList.status">
       </td>
       <td class="td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
         <i class="fa  fa-pencil text-success text" data-ng-click="editSwapAcc(objPresentationList.prCode)" tooltip="Edit"></i>
        </span>
          </security:authorize>
      <%--     <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPresentationList.prCode,$index)" tooltip="Delete"></i>
        </span>
        </security:authorize> --%>
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