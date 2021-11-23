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
       <!-- <th class="sorting width_10" st-sort="dNo">Id</th> -->
       <th class="sorting width_30" st-sort="fromPort">From Location</th>
       <th class="sorting width_30" st-sort="toPort">To Location</th>
       <th class="sorting width_30" st-sort="disMiles">Distance (Kms)</th>
        <th class="text-center">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objDistanceItem in displayedCollection">
       <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></td>
      <!--  <td>{{objDistanceItem.dNo}}</td> -->
       <td><a ng-click="view(objDistanceItem.dNo)">
       <security:authorize access="hasRole('${form_code}_${view}')"> 
		             <span tooltip="{{objDistanceItem.fromPort}}" class="tool-tip-span font-blue">{{objDistanceItem.fromPort}}</span>
		          </security:authorize>
		         </a>
		         
       </td>
       <td>{{objDistanceItem.toPort}}</td>
       <td>{{objDistanceItem.disMiles}}</td>
       	<td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
         <span>
          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objDistanceItem.dNo,$index)"></i>
         </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
         <span>
          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objDistanceItem.dNo,$index)"></i>
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