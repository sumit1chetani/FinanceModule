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
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
        	<tr>
	           <!-- <th class="width_1 text-center table-heading">
	            <label class="i-checks m-b-none">
	             <input type="checkbox">
	             <i></i>
	            </label>
	           </th> -->
	            <!-- <th class="sorting width_10" data-st-sort="budget_allocation_id">Allocation Id</th> -->
	           <th class="sorting width_10" data-st-sort="organizationName">Organization Name</th>
	           <th class="sorting width_8" data-st-sort="financial_year">Financial Year</th>
	           <th class="sorting width_4" data-st-sort="budgetTypeName">Budget Type</th>	             
	           <th class="sorting width_8" data-st-sort="capexno">Capex No</th>   
	           <th class="sorting width_15" data-st-sort="projectName">Name Of The Project</th>  
	           <th class="sorting width_15" data-st-sort="status">Status</th>    
	           <th class="width_6 text-center table-heading">Action</th>
        	</tr>
        </thead>
        
		<tbody class="dataTables-Main-Body">
	    	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objListItem in displayedCollection">
		      	<!-- <td class="width_1" cs-select="objListItem"></td> -->
		       	<!-- <td class="width_1"> <label class="i-checks m-b-none">
		       		<input type="checkbox" ng-model="objListItem.select" id="select{{trIndex}}"><i></i></label></td> -->
		       	<!-- <td class="width_15" ng-bind="objListItem.budget_allocation_id"></td> -->
		       	<td class="width_10" ng-bind="objListItem.companyName"></td>
		       	<td class="width_10" ng-bind="objListItem.financial_year"></td>
		       	<td class="width_15" ng-bind="objListItem.budgetTypeName">
		       	</td>
		<!--  	<td class="width_15" ng-bind="objListItem.budgetDefinitionId">
		       	</td> -->
		       <td class="width_4" ng-bind="objListItem.capexno"></td>
		
		       <td class="width_4" ng-bind="objListItem.projectName"></td>
		       <td class="width_4" ng-bind="objListItem.status"></td>
		       <td class="td-actions text-center">
		   <%--  <security:authorize access="hasRole('${form_code}_${modify}')">   --%>
<%-- 			        <security:authorize access="hasRole('${form_code}_${modify}')"> 
 --%>			      	<span class="width_15" ng-if="objListItem.status != 'Approved'">             
			         <i class="fa fa-pencil text-success text" data-ng-click="editbudgetdefinition(objListItem.budgetDefinitionId)" tooltip="Edit"></i>
			        </span>
<%-- 		        </security:authorize> 
 --%>		       
<%--  <security:authorize access="hasRole('${form_code}_${view}')"> 
 --%>			         <span >
			         	<i class="fa fa-eye text-success text" data-ng-click="view(objListItem.budgetDefinitionId)"  title = "view" tooltip="View"></i>
			         </span>
<%-- 		        </security:authorize> 
 --%>		        <security:authorize access="hasRole('${form_code}_${delete}')"> 
			        <span class="width_10" ng-if="objListItem.status != 'Approved'">
			         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteAllocation(objListItem.budgetDefinitionId,$index)" tooltip="Delete"></i>
			        </span>
		        </security:authorize> 
		       </td>
	    	</tr>
	     </tbody>
        </table>


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