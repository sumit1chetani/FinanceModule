<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"  st-table="displayedCollection" st-safe-src="rowCollection">
	<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body float-left padding-0" style="width:100%">
			 <div class="table-responsive" style=" border: 1px solid #CCC;">
			
 <style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;"><br/>
						<tr>
							<!-- <th class="width_1"><label class="i-checks m-b-none"><input type="checkbox" name="post[]" ><i></i></label></th> -->
							<th class="sorting width_1" st-sort="companycode" ng-show="true">Company Code</th>
							<th class="sorting width_2" st-sort="companyname" ng-show="true">Organization Name</th>
							<th class="sorting width_3" st-sort="location" ng-show="false">Country</th>
							<th class="sorting width_3" st-sort="address" ng-show="true">Address</th>
						    <th class="sorting width_1" st-sort="phoneno" ng-show="true">Telephone Number</th>
							<th class="sorting" st-sort="faxno" ng-show="false">Fax No</th>
							<th class="sorting width_2" st-sort="email" ng-show="true">Email </th>
							<th class="sorting width_1" st-sort="personincharge" ng-show="true">Person Incharge</th>
							<th class="sorting width_2" st-sort="relationship" ng-show="false">Relationship</th>
							<th class="sorting width_3" st-sort="intercompgroup" ng-show="false">Inter Company Group</th>
							<th class="width_1">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="CompanyDetailsCollections in displayedCollection" data-ng-click="" >
							<!-- <td class="width_1">
							<label class="i-checks m-b-none"><input type="checkbox" name="post[]" ng-model="CompanyDetailsCollections.selected" ><i></i></label>
							</td> -->
							 <td class=""><a ng-click="view(CompanyDetailsCollections.companycode)">
							 <security:authorize access="hasRole('${form_code}_${view}')"> 
		             <span tooltip="{{CompanyDetailsCollections.companycode}}" class="tool-tip-span font-blue">{{CompanyDetailsCollections.companycode}}</span>
		         </security:authorize> 
		         </a></td>
<!-- 							<td ng-show="true">{{CompanyDetailsCollections.companycode}}</td> -->
							<td ng-show="true">{{CompanyDetailsCollections.companyname}}</td>
							<td ng-show="false">{{CompanyDetailsCollections.location}}</td>
							<td ng-show="true">{{CompanyDetailsCollections.address}}</td>
						    <td ng-show="true">{{CompanyDetailsCollections.phoneno}}</td>
							<td ng-show="false">{{CompanyDetailsCollections.faxno}}</td>
						    <td ng-show="true">{{CompanyDetailsCollections.email}}</td>
							<td ng-show="true">{{CompanyDetailsCollections.personincharge}}</td>
							<td ng-show="false">{{CompanyDetailsCollections.relationship}}</td>
							<td ng-show="false">{{CompanyDetailsCollections.intercompgroup}}</td>
							<td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span>
          <i class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
          data-ng-click="editedRow(CompanyDetailsCollections.companycode,$index)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
          <i class="fa fa-trash-o text-danger-dker text"  data-toggle="tooltip" title="Delete"
          data-ng-click="deleteRow(CompanyDetailsCollections.companycode,$index)"></i>
         </span>
        </security:authorize>
       </td>
						</tr>
					</tbody>
				</table>
			 </div> 
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
			<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>
</div>