<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->   
 <%@include file="/views/templates/panel-header.jsp"%>
  <!-- </div> -->
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead>
     <tr>
<!--        <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i> -->
<!--        </label></th> -->
       <th class="sorting width_15" st-sort="groupHeadCode">Item Name</th>
       <th class="sorting width_15" st-sort="subGroupAcctCode">Item Catagory</th>
        <th class="sorting width_15" st-sort="subGroupAcctCode">Item Description</th>
         <th class="sorting width_15" st-sort="subGroupAcctCode">Item Type</th>
          <th class="sorting width_15" st-sort="subGroupAcctCode">Item Code</th>
       <th class="sorting width_15">Action</th>
      </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objManageItem in displayedCollection">
      
<!--        <td class=""><a ng-click="view(objGroupHeadItem.taxId)"> -->
<!-- 		             <span tooltip="{{objGroupHeadItem.taxCode}}" class="tool-tip-span font-blue">{{objManageItem.itemName}}</span> -->
<!-- 		         </a></td> -->
		         <td>{{objManageItem.itemName}}</td>
           <td>{{objManageItem.itemCategory}}</td>
           <td>{{objManageItem.itemDescription}}</td>
           <td>{{objManageItem.itemType}}</td>
           <td>{{objManageItem.itemCode}}</td>
<!--        <td class="sorting">{{objGroupHeadItem.truckno}}</td> -->
<!--        <td class="sorting">{{objGroupHeadItem.destination}}</td> -->
<!--        <td class="sorting">{{objGroupHeadItem.driversname}}</td> -->
       
       <td class=" td-actions text-center">
        <%-- <security:authorize access="hasRole('${form_code}_${modify}')"> --%>
         <span>
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objManageItem)"></i>
         </span>
        <%-- </security:authorize> --%>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objManageItem,$index)"></i>
         </span>
        </security:authorize>
       <%--  <security:authorize access="hasRole('${form_code}_${print}')"> --%>
          <%--  </security:authorize> --%>
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