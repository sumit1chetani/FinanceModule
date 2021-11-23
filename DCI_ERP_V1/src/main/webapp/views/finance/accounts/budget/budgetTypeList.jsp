

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-persist="loanEntryTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0" style="width: 100%;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
        	<tr>
	          <!--  <th class="width_1 text-center table-heading">
	            <label class="i-checks m-b-none">
	             <input type="checkbox">
	             <i></i>
	            </label>
	           </th> -->
	            <!-- <th class="sorting width_10" data-st-sort="budget_allocation_id">Allocation Id</th> -->
	           <th class="sorting width_10"st-sort="budget_type">Budget Type</th>
	           <th class="sorting width_10" st-sort="expenses">Expenses</th>
	            <!--  <th class="sorting width_10" >Amount</th>-->
	           <th class="width_6 text-center table-heading">Action</th>  
        	</tr>
        </thead>		       	        
		<tbody class="dataTables-Main-Body">
	    	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objListItem in displayedCollection">
		       	<td class="width_10" ng-bind="objListItem.budget_type"></td>
		       	<td class="width_10" ng-bind="objListItem.expenses"></td>
				       	<!-- <td class="width_10" ng-bind="objListItem.amount"></td>-->
		       <td class="td-actions text-center">
<%-- 		       <security:authorize access="hasRole('${form_code}_${modify}')">
 --%>			         <i class="fa fa-pencil text-success text" data-ng-click="edit(objListItem.budget_type_id)" tooltip="Edit"></i>
<%-- 		       </security:authorize>
 --%>		        <%-- <security:authorize access="hasRole('${form_code}_${view}')">
			         <span ng-if="objListItem.status == 'Approved'">
			         	<i class="fa  fa-list-alt text-dark text" data-ng-click="viewAllocation(objListItem.budget_allocation_id)" tooltip="View"></i>
			         </span>
		        </security:authorize>
		        <security:authorize access="hasRole('${form_code}_${delete}')">
			        <span class="width_10" ng-if="objListItem.status != 'Approved'">
			         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteAllocation(objListItem.budget_allocation_id,$index)" tooltip="Delete"></i>
			        </span>
		        </security:authorize> --%>
		       </td>
	    	</tr>
	     </tbody>
        </table>
     <!--    <div class="dt-toolbar-footer"
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