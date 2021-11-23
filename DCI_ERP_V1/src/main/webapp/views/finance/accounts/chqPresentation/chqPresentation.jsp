




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

     <div role="content">
      <div class="widget-body no-padding">
       <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">
         <div class="dt-toolbar">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>		</div>
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
       <!-- <th class="width_1 text-center table-heading">
        <label class="i-checks m-b-none">
         <input type="checkbox">
         <i></i>
        </label>
       </th> -->
       <th class="sorting width_10" st-sort="prCode">Present Code</th>
       <th class="sorting width_10" st-sort="presentDate">Present Date</th>
       <th class="sorting width_22" st-sort="companyName"><spring:message
			              			code="label.company.name"></spring:message></th>
       <th class="sorting width_22" st-sort="customerName">Customer</th>
       <th class="sorting width_15" st-sort="chqNo">Cheque No</th>
       <th class="sorting width_10" st-sort="chqDate">Cheque Date</th>
       <th class="sorting width_9" st-sort="chqAmnt">Amount</th>
       <th class="width_5 text-center table-heading">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPresentationList in displayedCollection">
      <!--  <td class="text-center" cs-select="objPresentationList"></td> -->
       <td class="width_8" ng-bind="objPresentationList.prCode"></td>
       <td class="width_8" ng-bind="objPresentationList.presentDate">
       </td>
        <td class="width_22" ng-bind="objPresentationList.companyName"></td>
       <td class="width_22" ng-bind="objPresentationList.customerName"></td>
       <td class="width_15" ng-bind="objPresentationList.chqNo"></td>
       <td class="width_8" ng-bind="objPresentationList.chqDate">
       </td>
       <td class="width_9 text-right" ng-bind="objPresentationList.chqAmnt">
       </td>
       <td class="td-actions text-center">
       <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
         <i class="fa  fa-pencil text-success text" data-ng-click="editPresentation(objPresentationList.prCode)" tooltip="Edit"></i>
        </span>
         </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPresentationList.prCode,$index)" tooltip="Delete"></i>
        </span>
        </security:authorize> 
       </td>
      </tr>
     </tbody>
    </table>
   <!--  <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div> -->
         
         

<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
       </div>
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