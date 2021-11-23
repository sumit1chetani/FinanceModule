<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0093_AU')" var="isApprove" /> --%>
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom">
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body no-padding">
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">
        <!-- <div class="dt-toolbar"
         data-smart-include="views/layout/toolbar-header.tpl"></div> -->
         <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		</div>
      <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
        <thead class="dataTables-Main-Head">
        	<tr>
	           <!-- <th class="width_1 text-center table-heading">
	            <label class="i-checks m-b-none">
	             <input type="checkbox">
	             <i></i>
	            </label>
	           </th> -->
	           <!--  <th class="sorting width_10" data-st-sort="budget_allocation_id">Allocation Id</th> -->
	           <th class="sorting width_10" data-st-sort="budget_allocation_id"><spring:message
			              			code="label.company.name"></spring:message></th>
	           <th class="sorting width_10" data-st-sort="budget_allocation_id">Financial Year</th>
	           <th class="sorting width_10" data-st-sort="budget_allocation_id">Expense Type</th>
	          <!--  <th class="sorting width_10" data-st-sort="budget_allocation_id">Misc Expenses</th>
	           <th class="sorting width_10" data-st-sort="budget_allocation_id">Salaries</th>
	           <th class="sorting width_10" data-st-sort="budget_allocation_id">Communication</th>
	           <th class="sorting width_10" data-st-sort="budget_allocation_id">Travel & Entertainment</th>           
	           <th class="sorting width_4" data-st-sort="budget_allocation_id">Prof. Fees</th>     
	           <th class="sorting width_10" data-st-sort="budget_allocation_id">Maintanance</th>
	           <th class="sorting width_10" data-st-sort="budget_allocation_id">Asset Purchase</th>
	           <th class="sorting width_10" data-st-sort="budget_allocation_id">Supplier Payment</th>  -->          
	           <th class="sorting width_4" data-st-sort="budget_allocation_id">Status</th>    
	           <th class="width_6 text-center table-heading"><spring:message code="label.action"></spring:message></th>
        	</tr>
        </thead>
        
		<tbody class="dataTables-Main-Body">
	    	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objListItem in displayedCollection">
		      	<!-- <td class="width_1" cs-select="objListItem"></td> -->
		       	<!-- <td class="width_1"> <label class="i-checks m-b-none">
		       		<input type="checkbox" ng-model="objListItem.select" id="select{{trIndex}}"><i></i></label></td> -->
		       <!-- 	<td class="width_15" ng-bind="objListItem.budget_allocation_id"></td> -->
		       	<td class="width_10" ng-bind="objListItem.companyName"></td>
		       	<td class="width_10" ng-bind="objListItem.financial_year"></td>
		       	<td class="width_15">
		       		<span tooltip="{{objListItem.expense_type}}" class="tool-tip-span text-wrap" ng-bind="objListItem.expense_type"></span>
		       	</td>
		      <!--  <td class="width_15 text-right" ng-bind="objListItem.misc_expenses"></td>
		       <td class="tool-tip-span text-wrap" ng-bind="objListItem.salaries"></td>
		       <td class="width_15 text-right" ng-bind="objListItem.communication"></td>
		       <td class="width_15 text-right" ng-bind="objListItem.travel_entertainment"></td>
		       <td class="width_15 text-right" ng-bind="objListItem.prof_fees"></td>
		       <td class="width_15 text-right" ng-bind="objListItem.maintanance"></td>
		        <td class="width_15 text-right" ng-bind="objListItem.asset_purchase"></td>
		       <td class="width_15 text-right" ng-bind="objListItem.supplier_payment"></td> -->
		       <td class="width_4" ng-bind="objListItem.status"></td>
		
		       <td class="td-actions text-center">
		       <security:authorize access="hasRole('${form_code}_${modify}')">
			      	<span class="width_15" ng-if="objListItem.status != 'Approved'">             
			         <i class="fa fa-pencil text-success text" data-ng-click="editAllocation(objListItem.budget_allocation_id)" tooltip="Edit"></i>
			        </span>
		        </security:authorize>
		         <security:authorize access="hasRole('${form_code}_${view}')">
			         <span ng-if="objListItem.status == 'Approved'">
			         	<i class="fa  fa-list-alt text-dark text" data-ng-click="viewAllocation(objListItem.budget_allocation_id)" tooltip="View"></i>
			         </span>
		        </security:authorize>
		        <security:authorize access="hasRole('${form_code}_${delete}')">
			        <span class="width_10" ng-if="objListItem.status != 'Approved'">
			         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteAllocation(objListItem.budget_allocation_id,$index)" tooltip="Delete"></i>
			        </span>
		        </security:authorize>
		       </td>
	    	</tr>
	     </tbody>
        </table>
        <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div>
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