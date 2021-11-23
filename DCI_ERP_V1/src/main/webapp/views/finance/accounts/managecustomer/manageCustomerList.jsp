
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
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
          <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
           <th class="sorting width_5" st-sort="entityName">Entity Name </th>
           <th class="sorting width_5" st-sort="contactPerson">Contact Person </th>
           <th class="sorting width_5" st-sort="jobPosition">Job Position </th>
<!--            <th class="sorting width_5" st-sort="tinNumber">TIN Number </th> -->
           <th class="sorting width_5" st-sort="cstNumber">GST Number </th>
           <th class="sorting width_5" st-sort="panNumber">PAN Number </th>
           <th class="width_5 text-center table-heading">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCustomerListItem in displayedCollection" ng-if="objCustomerListItem.isCustomer">
	       <!-- <td class="width_1" cs-select="objCreditNoteListItem"></td> -->
	    <!--    <td class="width_1"> <label class="i-checks m-b-none"> -->
	       <!-- <input type="checkbox" ng-model="objCustomerListItem.select" id="select{{trIndex}}"><i></i></label></td> -->
	       <td class="width_15" ng-bind="objCustomerListItem.entityName"></td>
	       <td class="width_10" ng-bind="objCustomerListItem.contactPerson"></td>
	       <td class="width_10" ng-bind="objCustomerListItem.jobPosition">	        
	       </td>
<!-- 	       <td class="width_10" ng-bind="objCustomerListItem.tinNumber"> -->
<!-- 	       </td> -->
	       <td class="width_15" ng-bind="objCustomerListItem.cstNumber">
	       </td>
	       <td class="width_15 text-right" ng-bind="objCustomerListItem.panNumber"></td>
	       <!-- <td class="width_30" ng-bind="objCreditNoteListItem.approveStatus">
	       </td> -->
	
	       <td class="td-actions text-center">
<%-- 	       <security:authorize access="hasRole('${form_code}_${modify}')">
 --%>	        <span class="width_15">
	         <i class="fa fa-pencil text-success text" data-ng-click="editRowBtn(objCustomerListItem.entityId)" tooltip="Edit"></i>
	        </span>
<%-- 	        </security:authorize>
 --%>	       
<%--   <security:authorize access="hasRole('${form_code}_${delete}')">
 --%>	        <span  class="width_10">
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objCustomerListItem.entityId,$index)" tooltip="Delete"></i>
	        </span>
<%-- 	        </security:authorize>
 --%>	       </td>
	      </tr>
	     </tbody>
        </table>
<!--         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->     
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