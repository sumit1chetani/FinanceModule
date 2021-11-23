<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
<%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-10" style="width:100%">
   <div class="table-responsive ">
    <table class="table table-striped b-t b-light table-hover dataTable no-footer" style="border:0px solid Red">
     <thead class="dataTables-Main-Head">
      <tr>
<!--         <th class="width_1" style="border:0px solid Red"> -->
<!--         <label class="i-checks m-b-none"> -->
<!--          <input type="checkbox" name="post[]"> -->
<!--          <i></i> -->
<!--         </label> -->
<!--        </th> -->
      <th class="sorting width_20" st-sort="containerTypeId">Credit Group Code</th> 
       <th class="sorting width_20" st-sort="containerType">Credit Group Name</th>
       <th class="sorting width_20" st-sort="containerGroupId">Credit Lmt Amt</th>
       <th class="sorting width_20" st-sort="containerDescription">Credit Lmt Days</th>
       <th>Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objItem in displayedCollection">
<!--       <td class="width_1 text-center"><label class="i-checks m-b-none"> -->
<!-- 	          <input type="checkbox" name="selectedTypes[]"  ng-model="objTranslationItem.check"> -->
<!-- 	          <i></i> -->
<!-- 	          </label> -->
<!-- 	          </td> -->
<!--        <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i> -->
<!--        </label></td> -->
        <td>{{objItem.groupId}}</td>
       <td>{{objItem.groupName}}</td>
       <td>{{objItem.creditLmtAmt}}</td>
       <td>{{objItem.creditLmtDays}}</td>
       
        <td class="width_05 td-actions text-center">
          <security:authorize access="hasRole('${form_code}_${modify}')">
         <span>
         <i class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
         data-ng-click="editRow(objItem.groupId)"></i>
        </span>
        </security:authorize> 
        <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
         data-ng-click="deleteRow(objItem.groupId)"></i>
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