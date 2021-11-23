<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>


 <div class="panel-body float-left padding-0" style="width: 100%;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead class="dataTables-Main-Head">
         	<tr>
											
											
											<th class="sorting width_15">Department Name</th>
											<th class="sorting width_15">Attendance Date</th>

											<th class="sorting width_7 text-center">Action</th>
											
										</tr>
         </thead>

									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="collection in displayedCollection">
										
										    <td>{{collection.departmentName}}</td>
											<td>{{collection.attendanceDate}}</td>
											<td class=" td-actions text-center"><security:authorize access="hasRole('${form_code}_${modify}')"> <span> <i
													class="fa  fa-pencil text-success text"
													data-ng-click="editRowDoc(collection)"></i>
													
											</span></security:authorize> <!-- <span> <i class="fa fa-trash-o text-danger-dker text"
													data-ng-click="deleteRowDoc(collection)"></i>
											</span> --></td>
										</tr>
									</tbody>
    </table>
    <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
    </footer>
  </div>
  <!-- end widget content -->
 </div>