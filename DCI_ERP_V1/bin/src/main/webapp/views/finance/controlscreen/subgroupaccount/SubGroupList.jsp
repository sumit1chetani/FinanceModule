<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-10" style="width: 100%;">
   <div class="table-responsive" style=" border: 1px solid #CCC;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
      <tr>
<!--        <th class="width_1"> -->
<!--        <label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i> -->
<!--        </label> -->
<!--        </th> -->
       <th class="sorting width_10" st-sort="subGroupCode">Group Code</th>
       <th class="sorting" st-sort="subGroupName">Group Name</th>
       <th class="sorting" st-sort="grpHeadCode">Category</th>
       <th class="text-center">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objSubGrpAcctBean in displayedCollection">
<!--        <td class=""> -->
<!--         <label class="i-checks m-b-none"> -->
<!--          <input type="checkbox" name="post[]"> -->
<!--          <i></i> -->
<!--         </label> -->
<!--        </td> -->
<!--        <td class="">{{objSubGrpAcctBean.subGroupCode}}</td> -->
       <td><a ng-click="view(objSubGrpAcctBean.subGroupCode)">
		            <security:authorize access="hasRole('${form_code}_${view}')">	  <span tooltip="{{objSubGrpAcctBean.subGroupCode}}" class="tool-tip-span font-blue">{{objSubGrpAcctBean.subGroupCode}}</span>
		        </security:authorize> </a>
       </td>
       <td class="sorting ">{{objSubGrpAcctBean.subGroupName}}</td>
       <td class="sorting ">{{objSubGrpAcctBean.grpHeadCode}}</td>
       <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span>
          <i class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
          data-ng-click="editRow(objSubGrpAcctBean,$index)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
          data-ng-click="deleteRow(objSubGrpAcctBean.subGroupCode,$index)"></i>
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