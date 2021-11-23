 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="customerList">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0">
   <div class="table-responsive ">
         <table class="table table-striped b-t b-light table-hover dataTable no-footer">
          <thead class="dataTables-Main-Head">
           <tr>
<!--             <th class="width_1"> -->
             <!-- <label class="i-checks m-b-none">
              <input type="checkbox" name="post[]">
              <i></i>
             </label> -->
            </th>
            <th class="sorting width_5" st-sort="customerCode">Payer Code</th>
             <th class="sorting width_5" st-sort="acctCode">Payer Account Head Code</th>
            <th class="sorting width_15" st-sort="customerName">Payer Name</th>
            <th class="sorting width_15" st-sort="customerShortName">Payer Short Name</th>
            <th class="sorting width_15" st-sort="countryName">Payment Country</th>
            <th class="sorting width_5" st-sort="countryName">Active</th>
            <th class="text-center  width_5" >Action</th>
           </tr>
           <tr>

<th>
<input st-search="customerCode" placeholder="Payer Code" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="acctCode" placeholder="Payer Account Head Code" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="customerName" placeholder="Payer Name" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="customerShortName" placeholder="Payer Short Name" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="countryName" placeholder="Payment Country" class="input-sm form-control" type="search" />
</th>
<th>
<input st-search="active" placeholder="Active" class="input-sm form-control" type="search" />
</th>
<th></th>
</tr>
          </thead>
          <tbody class="dataTables-Main-Body">
           <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCustomerItem in displayedCollection" >
<!--             <td class="width_1"> -->
<!--              <label class="i-checks m-b-none"> -->
<!--               <input type="checkbox" name="post[]"> -->
<!--               <i></i> -->
<!--              </label> -->
<!--             </td> -->
            
             <!-- <td><span ng-if = "isAgent==true"><b>{{objCustomerItem.customerCode}}</b><
             </span>
             <span ng-if = "isAgent==false"><a href="" ng-click="viewRow(objCustomerItem,$index)"><u>{{objCustomerItem.customerCode}}</u></a>
			</span>
		    </td> -->
		    
		    <td ng-if="isAgent==false && objCustomerItem.active=='YES'">
                          <a ng-click= "viewRow(objCustomerItem,$index)">
	             <span tooltip="{{objCustomerItem.customerCode}}" class="tool-tip-span font-blue" ng-bind="objCustomerItem.customerCode"></span>
	        </a>
         </td>
         <td ng-if="isAgent==false && objCustomerItem.active=='NO'">
                          <a ng-click= "viewRow(objCustomerItem,$index)">
	             <span tooltip="{{objCustomerItem.customerCode}}" class="tool-tip-span font-red" ng-bind="objCustomerItem.customerCode"></span>
	        </a>
         </td>
		       <td ng-if="isAgent==true && objCustomerItem.active=='YES'"
           class="sorting width_15">{{objCustomerItem.customerCode}}</td>
           <td ng-if="isAgent==true && objCustomerItem.active=='NO'"
           class="sorting width_15" style="color:#FF0000;">{{objCustomerItem.customerCode}}</td>
        
            <td ng-if="objCustomerItem.active=='YES'" class="sorting width_5" >{{objCustomerItem.acctCode}}</td>
            <td ng-if="objCustomerItem.active=='NO'" class="sorting width_5"  style="color:#FF0000;" >{{objCustomerItem.acctCode}}</td>
            <td ng-if="objCustomerItem.active=='YES'" class="sorting width_15">{{objCustomerItem.customerName}}</td>
            <td ng-if="objCustomerItem.active=='NO'" class="sorting width_15"  style="color:#FF0000;">{{objCustomerItem.customerName}}</td>
            <td ng-if="objCustomerItem.active=='YES'" class="sorting width_5">{{objCustomerItem.customerShortName}}</td>
            <td ng-if="objCustomerItem.active=='NO'" class="sorting width_5"  style="color:#FF0000;">{{objCustomerItem.customerShortName}}</td>
            <td ng-if="objCustomerItem.active=='YES'" class="sorting width_5">{{objCustomerItem.countryName}}</td>
            <td ng-if="objCustomerItem.active=='NO'" class="sorting width_5"  style="color:#FF0000;">{{objCustomerItem.countryName}}</td>
            <td ng-if="objCustomerItem.active=='YES'" class="sorting width_5">{{objCustomerItem.active}}</td>
            <td ng-if="objCustomerItem.active=='NO'" class="sorting width_5"  style="color:#FF0000;">{{objCustomerItem.active}}</td>
            <td class="td-actions text-center width_5" >
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