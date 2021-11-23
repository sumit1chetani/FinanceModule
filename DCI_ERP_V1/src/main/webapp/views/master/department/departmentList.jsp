<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead>
      <tr>
       <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></th>
       <th class="sorting width_25" st-sort="deptCode">Department Code</th>
       <th class="sorting width_25" st-sort="deptName">Department Name</th>
       <th class="sorting width_25" st-sort="deptHead">Department Head</th>
       <th class="sorting width_25" st-sort="isActive">Active</th>
       <th class="text-center">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objdepartmentItem in displayedCollection">
       <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></td>
       <td>{{objdepartmentItem.deptCode}}</td>
       <td>{{objdepartmentItem.deptName}}</td>
        <td>{{objdepartmentItem.deptHead}}</td>
       <td>{{objdepartmentItem.isActive}}</td>
        <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span>
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objdepartmentItem.deptCode,$index)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objdepartmentItem.deptCode,$index)"></i>
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