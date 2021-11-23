<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div id="content">
 <!-- widget grid -->
 <section widget-grid id="widget-grid">
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
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
	     <div role="content">
	      <div class="widget-body no-padding">
	       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
	        
		       <!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
		       <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		       </div>
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		         <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
			             <input type="checkbox"> <i></i>
			       </label></th>	 -->	           
		           <th class="sorting width_10" st-sort="salesOrderNo">SO Code </th>
		           <th class="sorting width_10" st-sort="salesOrderDate">SO Date </th>
		           <th class="sorting width_10" st-sort="employeeName">Sales Person</th>
		            <!-- <th class="sorting width_10" st-sort="fromDate">Delivery Address</th> -->
		             <th class="sorting width_10" st-sort="customerName">Customer Name</th>
		             <th class="sorting width_10" st-sort="contactPerson">Contact Person</th>
		             <th class="sorting width_10 " st-sort="netAmount">Amount</th>
		              <th class="sorting width_10" st-sort="contactPerson">Status</th>
		         
		           <th class="width_3 text-center table-heading"><spring:message code="label.action"></spring:message> </th>
		          </tr>
		         </thead>
		           <tbody class="dataTables-Main-Body">
		             <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="salesOrder in displayedCollection">
		         	<!-- <td class="text-center" cs-select="objVesselMasterItem"></td> -->
		         		<td>{{salesOrder.salesOrderNo}} </td>
		         		<td>{{salesOrder.salesOrderDate}}</td>
		         		<td>{{salesOrder.employeeName}}</td>
		         		<td>{{salesOrder.customerName}}</td>
		         		<td>{{salesOrder.contactPerson}}</td>
		         		<td class="text-align-right">{{salesOrder.netAmount}}</td>
		         		<td>{{salesOrder.status}}</td>
			          <td class=" td-actions text-center">
			          <security:authorize access="hasRole('${form_code}_${modify}')">
				        <span>
				         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(salesOrder)"></i>
				        </span>
				        </security:authorize>
				        <security:authorize access="hasRole('${form_code}_${delete}')">
				        <span>
				         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteSalesOrder(salesOrder,$index)"></i>
				        </span>
				        </security:authorize>
				       </td>
				     </tr>
		         </tbody>
		        </table>
		         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
	        </div>
	        
	       </div>
	      </div>
     </div>
   </article>
  </div>
 </section>
</div>