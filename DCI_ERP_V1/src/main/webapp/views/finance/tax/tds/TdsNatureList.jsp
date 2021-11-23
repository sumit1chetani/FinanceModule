<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 	<div class="panel panel-default panel-default-list"  st-table="displayedCollection" st-safe-src="rowCollection">
    <%@include file="/views/templates/panel-header.jsp"%>
			<div class="panel-body float-left padding-10" style="width:100%">
				<div class="table-responsive" style=" border: 1px solid #CCC;">
 					<table class="table table-striped table-hover dataTable no-footer">
    					 <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
          					<tr>
<!-- 	           				    <th class="width_1"> -->
<!-- 		            				<label class="i-checks m-b-none"> -->
<!-- 			            				<input type="checkbox" name="post[]" > -->
<!-- 			             				<i></i> -->
<!-- 		          				    </label> -->
<!-- 	                            </th> -->
	           					<!-- <th class="sorting width_4" st-sort="natureCode" ng-show="true">Nature Code</th> -->
	           					<th class="sorting width_4" st-sort="nature" ng-show="true">Nature</th>
	           					<th class="sorting width_4" st-sort="accountHeadCode" ng-show="true">Account Head</th>
	           					<th class="sorting width_4" st-sort="section" ng-show="true">Section</th>
	           					<th class="sorting width_4" st-sort="companyTax" ng-show="true">Company Tax(%)</th>
	           					<!-- <th class="sorting width_3" st-sort="companySurcharge" ng-show="true">Comp.Surcharge(%)</th>
	           					<th class="sorting width_5" st-sort="companyEduCess" ng-show="true">Comp.Edu cess(%)</th> -->
	           					<th class="sorting width_3" st-sort="individualTax" ng-show="true">Individual Tax(%)</th>
	           					<!-- <th class="sorting width_3" st-sort="individualSurcharge" ng-show="true">Indv.Surcharge(%)</th>
	           					<th class="sorting width_5" st-sort="individualEduCess" ng-show="true">Indv.Edu cess(%)</th> -->
	           					<th class="width_05 text-center">Action</th>
          					</tr>
                         </thead>
                         <tbody class="dataTables-Main-Body">
          					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="tdsNature in displayedCollection" data-ng-click="CheckboxSelect({{$index}})" >
<!--           						<td class="width_1"> -->
<!--         							<label class="i-checks m-b-none"> -->
<!-- 	         							<input type="checkbox" name="post[]"> -->
<!-- 	        							<i></i> -->
<!--         							</label> -->
<!--       						    </td>           						 -->
          						<!-- <td>{{tdsNature.natureCode}}</td> -->
          						<td>{{tdsNature.nature}}</td>
          						<td>{{tdsNature.accountHeadCode}}</td>
          						<td>{{tdsNature.section}}</td>
          						<td>{{tdsNature.companyTax}}</td>
          						<!-- <td>{{tdsNature.companySurcharge}}</td>
          						<td>{{tdsNature.companyEduCess}}</td> -->
          						<td>{{tdsNature.individualTax}}</td>
          						<!-- <td>{{tdsNature.individualSurcharge}}</td>
          						<td>{{tdsNature.individualEduCess}}</td> -->
          						<td class="width_05 td-actions text-center">
                  <security:authorize access="hasRole('${form_code}_${modify}')">
	          						<span>
	              						<i class="fa  fa-pencil text-success text" 	data-toggle="tooltip" title="Edit"
	              						data-ng-click="edit(tdsNature.natureCode)"></i>
	             					</span>
                   </security:authorize>
                     <security:authorize access="hasRole('${form_code}_${delete}')">
	            					<span>
	              						<i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
	              						data-ng-click="deleteTdsNature(tdsNature.natureCode,$index)"></i>
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