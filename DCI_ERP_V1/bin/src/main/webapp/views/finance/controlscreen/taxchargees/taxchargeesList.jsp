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
       <th class="sorting width_15" st-sort="groupHeadCode">Tax Code</th>
       <th class="sorting width_15" st-sort="subGroupAcctCode">Tax Name</th>
        <th class="sorting width_15" st-sort="subGroupAcctCode">From Date</th>
         <th class="sorting width_15" st-sort="subGroupAcctCode">To Date</th>
          <th class="sorting width_15" st-sort="subGroupAcctCode">Tax Percentage</th>
        <th class="sorting width_15" st-sort="subGroupAcctCode">Active</th>
       <th class="sorting width_15">Action</th>
      </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objGroupHeadItem in displayedCollection">
      
       <td class=""><a ng-click="view(objGroupHeadItem.taxId)"> <security:authorize access="hasRole('${form_code}_${view}')">	
		             <span tooltip="{{objGroupHeadItem.taxCode}}" class="tool-tip-span font-blue">{{objGroupHeadItem.taxCode}}</span>
		        </security:authorize> </a></td>
       <td class="">{{objGroupHeadItem.taxName}}</td>
       <td class="">{{objGroupHeadItem.fromDate}}</td>
       <td class="">{{objGroupHeadItem.toDate}}</td>
       <td class="">{{objGroupHeadItem.taxPercentage}}</td>
        <td class="">{{objGroupHeadItem.isactive}}</td>
<!--        <td class="sorting">{{objGroupHeadItem.truckno}}</td> -->
<!--        <td class="sorting">{{objGroupHeadItem.destination}}</td> -->
<!--        <td class="sorting">{{objGroupHeadItem.driversname}}</td> -->
       
       <td class=" td-actions text-center">
        <%-- <security:authorize access="hasRole('${form_code}_${modify}')"> --%>
          <security:authorize access="hasRole('${form_code}_${modify}')">	<span>
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objGroupHeadItem.taxId)"></i>
         </span></security:authorize>
        <%-- </security:authorize> --%>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objGroupHeadItem)"></i>
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