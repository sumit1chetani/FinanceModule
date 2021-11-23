
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
	   <%@include file="/views/templates/panel-header.jsp"%>
	<div class="panel-body float-left padding-10" style="width: 100%;">
	   <div class="table-responsive" style=" border: 1px solid #CCC;">
	    <table class="table table-striped table-hover dataTable no-footer">
	     <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
	      <tr>
<!-- 	       <th class="width_1"> -->
<!-- 	        <label class="i-checks m-b-none"> -->
<!-- 	         <input type="checkbox" name="post[]"> -->
<!-- 	         <i></i> -->
<!-- 	        </label> -->
<!-- 	       </th> -->
	       <th class="sorting width_20" st-sort="exchangeRateCode">Exchange Rate Code</th>
	       <th class="sorting width_20" st-sort="currencyCode">Currency</th>
	       <th class="sorting width_20" st-sort="exchangeRateDate">Date</th>
	       <th class="sorting width_20" st-sort="exchangeRateValue">Value</th>
	       <th class="text-center">Action</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="lExchangeRateBean in displayedCollection">
<!-- 	       <td class=""> -->
<!-- 	        <label class="i-checks m-b-none"> -->
<!-- 	         <input type="checkbox" name="post[]"> -->
<!-- 	         <i></i> -->
<!-- 	        </label> -->
<!-- 	       </td> -->
	       <td >{{lExchangeRateBean.exchangeRateCode}}</td>
	       <td>{{lExchangeRateBean.currencyCode}}</td>
	       <td class="text-right">{{lExchangeRateBean.exchangeRateDate}}</td>
	       <td class="text-right">{{lExchangeRateBean.exchangeRateValue}}</td>
			<td class=" td-actions text-center">
<%--         <security:authorize access="hasRole('${form_code}_${modify}')">
 --%>         <span>
          <i class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
          data-ng-click="editRow(lExchangeRateBean.exchangeRateCode,$index)"></i>
         </span>
<%--         </security:authorize>
 --%>        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete" 
          data-ng-click="deleteRow(lExchangeRateBean.exchangeRateCode,$index)"></i>
         </span>
        </security:authorize>
       </td>
	      </tr>
	     </tbody>
	    </table>
	   </div>
	   <footer class="panel-footer panel-footer-list" style="padding:0px;">
	    <%@include file="/views/templates/panel-footer.jsp"%>
	   </footer>
	  </div> 
	</div>
</div>