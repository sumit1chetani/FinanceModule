<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"  st-table="displayedCollection" st-safe-src="rowCollection">
	<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body float-left padding-0" style="width:100%">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
						   <th class="width_05"><label class="i-checks m-b-none"><input type="checkbox" name="post[]"><i></i></label></th>
						   <th class="sorting width_5" st-sort="assetcode" ng-show="true">Asset Code</th>
						   <th class="sorting width_5" st-sort="assetname" ng-show="true">Asset Name</th>
						   <th class="sorting width_5" st-sort="location" ng-show="false">Location</th>
					       <th class="sorting width_5" st-sort="locationname" ng-show="true">Location Name</th>
						   <th class="sorting width_5" st-sort="suppliercode" ng-show="false">SupplierCode</th>
					       <th class="sorting width_5" st-sort="suppliername" ng-show="true">Supplier Name</th>
					       <th class="sorting width_5" st-sort="description" ng-show="false">Description</th>
						   <th class="sorting width_5" st-sort="acctheadcode" ng-show="false">AcctHeadCode</th>
						   <th class="sorting width_5" st-sort="acctheadname" ng-show="true">Acct Head Name</th>
						   <th class="sorting width_5" st-sort="purchasevalue" ng-show="false">PurchaseValue</th>
						   <th class="sorting width_5" st-sort="purchasedate" ng-show="true">Purchase Date</th>
						   <th class="sorting width_5" st-sort="depreciationtype" ng-show="false">DepreciationType</th>
						   <th class="sorting width_5" st-sort="value" ng-show="false">Value</th>
						   <th class="width_05">Action</th>
						</tr>
					</thead> 
					<tbody class="dataTables-Main-Body">          
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="AssetCollections in displayedCollection"  >
							<td class="width_1">
							<label class="i-checks m-b-none"><input type="checkbox" name="post[]" ng-model="AssetCollections.selected" ><i></i></label>
							</td>           
							<td ng-show="true">{{AssetCollections.assetcode}}</td>
							<td ng-show="true">{{AssetCollections.assetname}}</td>
							<td ng-show="false">{{AssetCollections.location}}</td>
							<td ng-show="true">{{AssetCollections.locationname}}</td>
							<td ng-show="false">{{AssetCollections.suppliercode}}</td>
							<td ng-show="true">{{AssetCollections.suppliername}}</td>
							<td ng-show="false">{{AssetCollections.description}}</td>
							<td ng-show="false">{{AssetCollections.acctheadcode}}</td>
							<td ng-show="true">{{AssetCollections.acctheadname}}</td>
							<td ng-show="false">{{AssetCollections.purchasevalue}}</td>
							<td ng-show="true">{{AssetCollections.purchasedate}}</td>
							<td ng-show="false">{{AssetCollections.depreciationtype}}</td>
							<td ng-show="false">{{AssetCollections.value}}</td>
							<td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span>
          <i class="fa  fa-pencil text-success text" data-ng-click="editedRow(AssetCollections.assetcode,$index)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(AssetCollections.assetcode,$index)"></i>
         </span>
        </security:authorize>
       </td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>
</div>

