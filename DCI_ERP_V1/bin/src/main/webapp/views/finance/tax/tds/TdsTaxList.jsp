<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 	<div class="panel panel-default panel-default-list"  st-table="displayedCollection" st-safe-src="rowCollection">
    <%@include file="/views/templates/panel-header.jsp"%>
			<div class="panel-body float-left padding-10" style="width:100%">
				<div class="table-responsive" style=" border: 1px solid #CCC;">
 					<table class="table table-striped table-hover dataTable no-footer">
    					 <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;" >
          					<tr>
<!-- 	           				    <th class="width_1"> -->
<!-- 		            				<label class="i-checks m-b-none"> -->
<!-- 			            				<input type="checkbox" name="post[]" > -->
<!-- 			             				<i></i> -->
<!-- 		          				    </label> -->
<!-- 	                            </th> -->
	           					<th class="sorting width_25" st-sort="branch" ng-show="true">Company</th>
	           					<th class="sorting width_25" st-sort="tdsNature" ng-show="true">Nature</th>
	           					<th class="sorting width_25" st-sort="vendorName" ng-show="true">Vendor Name</th>
	           					<th class="sorting width_20" st-sort="invNo" ng-show="true">Invoice No</th>
	           					<th class="sorting width_25" st-sort="tdsNetAmtLocal" ng-show="true">TDS Amount</th>
	           					<!-- <th class="sorting width_10" st-sort="tdsNetAmtLocal" ng-show="true">Tds Amount(Local)</th>
                                <th class="sorting width_10" st-sort="tdsNetAmtUsd" ng-show="true">Tds Amount(USD)</th> -->
	           					<th class="width_05 text-center">Action</th>
          					</tr>
                         </thead>
                         <tbody class="dataTables-Main-Body">
          					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="vendorNature in displayedCollection" data-ng-click="CheckboxSelect({{$index}})" >
<!--           						<td class="width_1"> -->
<!--         							<label class="i-checks m-b-none"> -->
<!-- 	         							<input type="checkbox" name="post[]"> -->
<!-- 	        							<i></i> -->
<!--         							</label> -->
<!--       						    </td>         						 -->
          						<td>{{vendorNature.branch}}</td>
          						<td>{{vendorNature.tdsNature}}</td>
          						<td>{{vendorNature.vendorName}}</td>
          						<td>{{vendorNature.invNo}}</td>
          						<td>{{vendorNature.tdsNetAmtLocal}}</td>
          						<!-- <td>{{vendorNature.tdsNetAmtLocal}}</td>
                                 <td>{{vendorNature.tdsNetAmtUsd}}</td> -->
   						         <td class="width_05 td-actions text-center">
                   <security:authorize access="hasRole('${form_code}_${modify}')">
	          						<span>
	              						<i class="fa  fa-pencil text-success text" 	data-toggle="tooltip" title="Edit"
	              						data-ng-click="edit(vendorNature.tdsTaxCode)"></i>
	             					</span>
                   </security:authorize>
                    <security:authorize access="hasRole('${form_code}_${delete}')">
	            					<span>
	              						<i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
	              						data-ng-click="deleteTdsNature(vendorNature.tdsTaxCode,$index)"></i>
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