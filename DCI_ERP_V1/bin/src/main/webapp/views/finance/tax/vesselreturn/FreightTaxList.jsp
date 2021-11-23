<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
                             
	           					<th class="sorting width_10" st-sort="freightTaxCode" ng-show="true">Freight Code</th>
	           					<th class="sorting width_25" st-sort="vesselName" ng-show="true">Vessel</th>
                                <th class="sorting width_25" st-sort="voyageNo" ng-show="true">Voyage</th>
                                <th class="sorting width_25" st-sort="portCode" ng-show="true">Port</th>
	           					<th class="sorting width_10" st-sort="tdsNature" ng-show="true">Net Amount(Local)</th>
                                <th class="sorting width_10" st-sort="tdsNatureType" ng-show="true">Net Amount(USD)</th>
	           					<th class="width_05 text-center">Action</th>
          					</tr>
                         </thead>
                         <tbody class="dataTables-Main-Body">
          					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="freightTax in displayedCollection" data-ng-click="CheckboxSelect({{$index}})" >
          						<td class="width_1">
        							<label class="i-checks m-b-none">
	         							<input type="checkbox" name="post[]">
	        							<i></i>
        							</label>
      						    </td>         						
          						<td>{{freightTax.freightTaxCode}}</td>
          						<td>{{freightTax.vesselCode}}</td>
                                 <td>{{freightTax.voyageNo}}</td>
          						<td>{{freightTax.portCode}}</td>
                                 <td>{{freightTax.netTaxPayableAmtLocal}}</td>
                                 <td>{{freightTax.netTaxPayableAmtUsd}}</td>
   						         <td class="width_05 td-actions text-center">
                   <security:authorize access="hasRole('${form_code}_${modify}')">
	          						<span>
	              						<i class="fa  fa-pencil text-success text" data-ng-click="edit(freightTax.freightTaxCode)"></i>
	             					</span>
                   </security:authorize>
                     <security:authorize access="hasRole('${form_code}_${delete}')">
	            					<span>
	              						<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteFreightTax(freightTax.freightTaxCode,$index)"></i>
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