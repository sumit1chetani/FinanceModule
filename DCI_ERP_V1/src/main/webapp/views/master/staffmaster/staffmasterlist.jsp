<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->   
   <%@include file="/views/templates/panel-header.jsp"%>
  <!-- </div> -->
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <!-- <div class="table-responsive "> -->
   
 <style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>
			<table class="table table-striped table-hover dataTable no-footer">
				<thead class="dataTables-Main-Head">
					<tr>
						<th class="sorting width_4">IAHS EMP CODE </th>
						<th class="sorting width_4">TRMS EMP CODE</th>
						<th class="sorting width_4">Action</th> 
				</thead>
				<tbody class="dataTables-Main-Body">
					<tr class="route" data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="staff in displayedCollection track by $index">

						<td class="wrapping ">{{staff.iahsempcode}}</td>
						<td class="wrapping ">{{staff.trmsempcode}}</td>
					    <td class="wrapping">
	     
	        <security:authorize access="hasRole('${form_code}_${delete}')">
	        <span  class="width_4">
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(staff.iahsempcode)" tooltip="Delete"></i>
	        </span>
	        </security:authorize>
	       </td>
				</tbody>
			</table>
			<!--  </div> -->
    <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
   
 
	   
  </div>
  </div>
 </div>
