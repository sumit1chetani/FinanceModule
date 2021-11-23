<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 	<div class="panel panel-default panel-default-list"  st-table="displayedCollection" st-safe-src="rowCollection">
    <%@include file="/views/templates/panel-header.jsp"%>
			<div class="panel-body float-left padding-0" style="width:100%">
				<div class="table-responsive ">
 					<table class="table table-striped table-hover dataTable no-footer">
    					 <thead class="dataTables-Main-Head">
          					<tr>
<!-- 	           				    <th class="width_1"> -->
<!-- 		            				<label class="i-checks m-b-none"> -->
<!-- 			            				<input type="checkbox" name="post[]" > -->
<!-- 			             				<i></i> -->
<!-- 		          				    </label> -->
<!-- 	                            </th> -->
	           					<th class="sorting width_10" st-sort="vendorNatureCode" ng-show="true">Relation Code</th>
	           					<th class="sorting width_25" st-sort="vendorName" ng-show="true">Vendor</th>
	       
                                <th class="sorting width_10" st-sort="tdsNatureType" ng-show="true">Type</th>
                                <th class="sorting width_25" st-sort="description" ng-show="true">Description</th>
	           					<th class="width_05 text-center">Action</th>
          					</tr>
                         </thead>
                         
                         <tbody class="dataTables-Main-Body">
                         <security:authorize
								access="hasRole('${form_code}_${view}')">
</security:authorize>          					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="vendorNature in displayedCollection" data-ng-click="CheckboxSelect($index)" >
<!--           					
	<td class="width_1"> -->
<!--         							<label class="i-checks m-b-none"> -->
<!-- 	         							<input type="checkbox" name="post[]"> -->
<!-- 	        							<i></i> -->
<!--         							</label> -->
<!--       						    </td>           						 -->
          						<td>{{vendorNature.vendorNatureCode}}</td>
          						<td>{{vendorNature.vendorName}}</td>
                                 <td>{{vendorNature.tdsNatureType}}</td>
                                 <td>{{vendorNature.description}}</td>
   						         <td class="width_05 td-actions text-center">
                    <security:authorize access="hasRole('${form_code}_${modify}')">
	          						<span>
	              						<i class="fa  fa-pencil text-success text" data-ng-click="edit(vendorNature.vendorNatureCode)"></i>
	             					</span>
                   </security:authorize>
                   <security:authorize access="hasRole('${form_code}_${delete}')">
	            					<span>
	              						<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteTdsNature(vendorNature.vendorNatureCode,$index)"></i>
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