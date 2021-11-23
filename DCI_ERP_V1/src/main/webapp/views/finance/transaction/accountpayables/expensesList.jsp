<div class="wrapper-md">
 <div class="panel panel-default panel-default-list"  st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0">
<div class="table-responsive ">
	<table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
          <tr>
            <th class="width_05">
            <label class="i-checks m-b-none">
            <input type="checkbox" name="post[]" >
             <i></i>
           </label>
       </th>
           <th class="sorting width_3" st-sort="exTypeName" ng-show="true">Expenses Type</th>
           <th class="sorting width_3" st-sort ="exDesc" ng-show="true">Expenses Description</th>
           <th class="width_05 text-center">Action</th>
           
          </tr>
          </thead>
          <tbody>
          	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objExpenses in displayedCollection">
          		<td class=" "><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
	       		</label></td>
          		<td>{{objExpenses.exTypeName}}</td>
          		<td>{{objExpenses.exDesc}}</td>
                <td class="width_05 td-actions text-center">
                  <span>
                      <i class="fa  fa-pencil text-success text" data-ng-click="edit(objExpenses)"></i>
                    </span>
                   <span>
                      <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objExpenses,$index)"></i>
                    </span>
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