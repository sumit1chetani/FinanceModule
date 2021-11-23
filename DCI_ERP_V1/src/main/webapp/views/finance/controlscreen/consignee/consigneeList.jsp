<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="customerList">
<%@include file="/views/templates/panel-header.jsp"%>
<div class="panel-body float-left padding-0" style="width: 100%;">
<div class="table-responsive ">
<table class="table table-striped b-t b-light table-hover dataTable no-footer">
<thead class="dataTables-Main-Head">
<tr>
<!-- <th class="width_1"> -->
<!-- <label class="i-checks m-b-none">
<input type="checkbox" name="post[]">
<i></i>
</label> -->
</th>
<th class="sorting width_4" st-sort="customerCode">Customer Code</th>
<th class="sorting width_4" st-sort="acctHead">Account Head Code</th>
<th class="sorting width_10" st-sort="customerName">Customer Name</th>
<th class="sorting width_4" st-sort="customerShortName">Customer Short Name</th>
<th class="sorting width_4" st-sort="countryName">Country Name</th>
<th class="sorting width_4" st-sort="paymentCenter">Payment Center</th>
<!-- <th class="sorting width_3" st-sort="isVesselGrp">Is Vessel Operator</th>
 --><th class="sorting width_3" st-sort="active">Active</th>
<th class="text-center  width_2" >Action</th>
</tr>
<!-- <tr>

<th>
<input st-search="customerCode" placeholder="Customer Code" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="acctHead" placeholder="Account Head Code" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="customerName" placeholder="Customer Name" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="customerShortName" placeholder="Customer Short Name" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="countryName" placeholder="Country Name" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="paymentCenter" placeholder="Payment Center" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="isVesselGrp" placeholder="Is Vessel Operator" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="active" placeholder="Active" class="input-sm form-control" type="search" />
</th>
<th></th>
</tr> -->
</thead>
<tbody class="dataTables-Main-Body">
<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCustomerItem in displayedCollection" >
<!-- <td class="width_1"> -->
<!-- <label class="i-checks m-b-none"> -->
<!-- <input type="checkbox" name="post[]"> -->
<!-- <i></i> -->
<!-- </label> -->
<!-- </td> -->
		    <td ng-if="isAgent==false && objCustomerItem.active=='YES'">
                          <a ng-click= "viewRow(objCustomerItem,$index)">
                          
                  <security:authorize access="hasRole('${form_code}_${view}')">         
	             <span tooltip="{{objCustomerItem.customerCode}}" class="tool-tip-span font-blue" ng-bind="objCustomerItem.customerCode"></span>
	       </security:authorize> </a>
         </td>
         <td ng-if="isAgent==false && objCustomerItem.active=='NO'">
                          <a ng-click= "viewRow(objCustomerItem,$index)">
	              <security:authorize access="hasRole('${form_code}_${view}')"><span tooltip="{{objCustomerItem.customerCode}}" class="tool-tip-span font-red" ng-bind="objCustomerItem.customerCode"></span>
	       </security:authorize> </a>
         </td>
		       <td ng-if="isAgent==true && objCustomerItem.active=='YES'"
           class="sorting width_15">{{objCustomerItem.customerCode}}</td>
           <td ng-if="isAgent==true && objCustomerItem.active=='NO'"
           class="sorting width_15" style="color:#FF0000;">{{objCustomerItem.customerCode}}</td>
<!-- <td class="sorting width_3"><a href="" ng-click="viewRow(objCustomerItem,$index)"><u>{{objCustomerItem.customerCode}}</u></a></td> -->
<td ng-if="objCustomerItem.active=='YES'" class="sorting width_10 ">{{objCustomerItem.acctHead}}</td>
<td ng-if="objCustomerItem.active=='NO'" class="sorting width_10 " style="color:#FF0000;">{{objCustomerItem.acctHead}}</td>
<td ng-if="objCustomerItem.active=='YES'" class="sorting width_10 ">{{objCustomerItem.customerName}}</td>
<td ng-if="objCustomerItem.active=='NO'" class="sorting width_10 " style="color:#FF0000;">{{objCustomerItem.customerName}}</td>
<td ng-if="objCustomerItem.active=='YES'" class="sorting width_4">{{objCustomerItem.customerShortName}}</td>
<td ng-if="objCustomerItem.active=='NO'" class="sorting width_4" style="color:#FF0000;">{{objCustomerItem.customerShortName}}</td>
<td ng-if="objCustomerItem.active=='YES'" class="sorting width_4">{{objCustomerItem.countryName}}</td>
<td ng-if="objCustomerItem.active=='NO'" class="sorting width_4" style="color:#FF0000;">{{objCustomerItem.countryName}}</td>
<td ng-if="objCustomerItem.active=='YES'" class="sorting width_4">{{objCustomerItem.paymentCenter}}</td>
<td ng-if="objCustomerItem.active=='NO'" class="sorting width_4" style="color:#FF0000;">{{objCustomerItem.paymentCenter}}</td>
<!-- <td ng-if="objCustomerItem.active=='YES'"class="sorting width_3">{{objCustomerItem.isVesselGrp}}</td>
<td ng-if="objCustomerItem.active=='NO'" class="sorting width_3" style="color:#FF0000;">{{objCustomerItem.isVesselGrp}}</td> -->
<td ng-if="objCustomerItem.active=='YES'" class="sorting width_3">{{objCustomerItem.active}}</td>
<td ng-if="objCustomerItem.active=='NO'" class="sorting width_3" style="color:#FF0000;">{{objCustomerItem.active}}</td>
<td class=" td-actions text-center">
<security:authorize access="hasRole('${form_code}_${modify}')">
<span>
<i class="fa  fa-pencil text-success text" data-ng-click="editRow(objCustomerItem,$index)"></i>
</span>
</security:authorize>
<security:authorize access="hasRole('${form_code}_${delete}')">
<span>
<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteCustomer(objCustomerItem.customerCode,$index)"></i>
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
<!-- end widget content -->
</div>
</div>