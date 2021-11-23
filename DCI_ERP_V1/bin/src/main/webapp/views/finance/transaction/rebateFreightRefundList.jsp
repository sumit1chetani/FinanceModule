<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<security:authorize access="hasRole('F0311_S')" var="isSearch" />
<security:authorize access="hasRole('F0311_A')" var="isAdd" />
<div class="wrapper-md">
 	<div class="panel panel-default panel-default-list"  st-table="displayedCollection" st-safe-src="rowCollection">
    <%@include file="/views/templates/panel-header.jsp"%>
			<div class="panel-body float-left padding-0">
				<div class="table-responsive ">
 					<table class="table table-striped table-hover dataTable no-footer">
    					 <thead class="dataTables-Main-Head">
          					<tr>
	           				    <th class="width_1">
		            				<label class="i-checks m-b-none">
			            				<input type="checkbox" name="post[]" >
			             				<i></i>
		          				    </label>
	                            </th>
	           					<th class="sorting width_05" st-sort="rebateRefundId" ng-show="true">Rebate Code</th>
	           					<th class="sorting width_4" st-sort="customerName" ng-show="true">Customer</th>
	           					<th class="sorting width_05" st-sort="fromDate" ng-show="true">From Date</th>
	          				    <th class="sorting width_05" st-sort="toDate" ng-show="true">To Date</th>
	       	  					<th class="sorting width_05" st-sort="portsExcluded" ng-show="true">Ports Excluded</th>
                              <th class="sorting width_10" st-sort="invoicesExcluded" ng-show="true">Invoices Excluded</th>
                              <th class="sorting width_10" st-sort="oneOffRate" ng-show="true">One Off Rate</th>
                              <th class="sorting width_10" st-sort="oneOffSailings" ng-show="true">One Off Sailing</th>
                              <th class="sorting width_5" st-sort="rebateApproved" ng-show="true">Approved</th>
	           					<th class="width_05 text-center">Action</th>
          					</tr>
                         </thead>
                         <tbody class="dataTables-Main-Body">
          					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="vesselInfo in displayedCollection" data-ng-click="CheckboxSelect({{$index}})" >
          						<td class="width_1">
        							<label class="i-checks m-b-none">
	         							<input type="checkbox" name="post[]" ng-model="vesselInfo.selected" >
	        							<i></i>
        							</label>
      						    </td>                            	
          						<td ng-show="true">{{vesselInfo.rebateRefundId}}</td>
          						<td ng-show="true">{{vesselInfo.customerName}}</td>
          						<td ng-show="true" >{{vesselInfo.fromDate}}</td>
          						<td ng-show="true" >{{vesselInfo.toDate}}</td>
           						<td ng-show="true" >{{vesselInfo.portsExcluded}}</td>    
                                <td ng-show="true">{{vesselInfo.invoicesExcluded}}</td>   
                                 <td ng-show="true">{{vesselInfo.oneOffRate}}</td>   
                                  <td ng-show="true">{{vesselInfo.oneOffSailings}}</td>   
                                   <td ng-show="true">{{vesselInfo.rebateApproved}}</td>        						
          						<td class="width_05 td-actions text-center">
                 <security:authorize access="hasRole('F0311_M')">
	          						<span>
	              						<i class="fa  fa-pencil text-success text" data-ng-click="edit(vesselInfo.vesselInfoId)"></i>
	             					</span>
                   </security:authorize>
                    <security:authorize access="hasRole('F0311_D')">
	            					<span>
	              						<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(vesselInfo.vesselInfoId,$index)"></i>
	             					</span>
                   </security:authorize>
          						</td>
                             </tr>
                         </tbody>
                    </table>
                </div>
                        <footer class="panel-footer panel-footer-list">
         					<%@include file="/views/templates/panel-footer.jsp"%>
        				</footer>
 			</div>
	</div>
</div>