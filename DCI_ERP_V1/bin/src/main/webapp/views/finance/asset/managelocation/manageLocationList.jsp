<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div class="wrapper-md">
	 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-hover dataTable no-footer">
				      <thead class="dataTables-Main-Head">
				          <tr>
				           <th class="width_1 text-center table-heading">
				           	<label class="i-checks m-b-none">
				             <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(displayedCollection,selectedAll)">
							 <i></i>
				           	</label>
				           </th>
				           <th class="sorting width_5" st-sort="No">Asset Location</th>
				           <th class="sorting width_5" st-sort="Name">Asset Type</th>
				           <th class="sorting width_5" st-sort="Date">Asset InCharge</th>
				           <th class="sorting width_3 text-center" st-sort="Date">Is Active</th>
				           <th class="sorting width_5 text-center table-heading" st-sort="Action">Action</th>
				          </tr>
				      </thead>
				      <tbody class="dataTables-Main-Body">
				          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objManageLocation in displayedCollection">				          
					          <td class="text-center">
						           <div class="checkbox">
						           	<label class="i-checks m-b-none">
									  <input type="checkbox" ng-model="objManageLocation.select" ng-change="checkSelected(objManageLocation.select,objManageLocation.locationId)"><i></i>
									</label>
									</div>
					           </td>	
					           <td ng-bind="objManageLocation.manageName"></td>
					           <td ng-bind="objManageLocation.locationType"></td>
					           <td ng-bind="objManageLocation.locationIncharge"></td>
					           <td class="text-center" data-ng-if="objManageLocation.isActive=='t'">
						           <div class="checkbox">
						           	<label>
									  <input type="checkbox" checked="checked" disabled="disabled">
									<span></span>
									</label>
									</div>
					           </td>
					           <td class="text-center" data-ng-if="objManageLocation.isActive!='t'">
					           		<div class="checkbox">
						           	<label class="i-checks">
									  <input type="checkbox" disabled="disabled">
										<i></i>
									</label>
									</div>
					           </td>
					           <td class=" td-actions text-center">
							        <span>
						         		<i class="fa  fa-pencil text-success text" data-ng-click="editRow(objManageLocation)"></i>
						        	</span>
							        <span>
						         		<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objManageLocation.locationId)"></i>
						        	</span>
							   </td>
				          </tr>
				        </tbody>
				     </table>
				</div> <!-- /table-responsive -->
		<footer class="panel-footer">
			<%@include file="/views/templates/panel-footer-static.jsp"%>
		</footer>
     </div> <!-- /panel-body -->	
    </div>  <!-- /panel panel-default -->
   </div> <!-- /panel-default-list -->
</div><!-- /wrapper-md -->