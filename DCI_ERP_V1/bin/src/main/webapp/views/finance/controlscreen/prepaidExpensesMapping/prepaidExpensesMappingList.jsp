<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->   
   <%@include file="/views/templates/panel-header.jsp"%>
  <!-- </div> -->
  <div class="panel-body float-left padding-0">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead>
     <tr>
       <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></th>
       <th class="sorting width_15">Prepaid Expenses Code</th>
       <th class="sorting width_30">Prepaid Expenses Name</th>
       <th class="sorting width_15">Expenses Code</th>
       <th class="sorting width_30">Expenses Name</th>
      </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objGroupHeadItem in displayedCollection">
       <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></td>
       <td class="">{{objGroupHeadItem.preExpCode}}</td>
       <td class="sorting">{{objGroupHeadItem.preExpName}}</td>
        <td class="">{{objGroupHeadItem.expCode}}</td>
       <td class="sorting">{{objGroupHeadItem.expName}}</td>
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