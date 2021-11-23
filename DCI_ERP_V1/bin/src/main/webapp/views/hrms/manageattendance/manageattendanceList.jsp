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
											
											<th class="sorting width_10" st-sort="employeeName">Employee Name</th>
											<th class="sorting width_7" st-sort="branch">Branch</th>
											<%-- <th class="sorting width_10" st-sort="designation"><spring:message code="label.manpower.designation"></spring:message></th> --%>
											<th class="sorting width_10" st-sort="department">Department</th>
											<%-- <th class="sorting width_6" st-sort="grade"><spring:message code="label.grade"></spring:message></th> --%>
											<th class="sorting width_10" st-sort="indate">Attendance
												Date</th>
						<th class="sorting width_10" st-sort="attendanceId">Attendance ID</th>
												
											<%-- <th class="sorting width_10" st-sort="indate"><spring:message code="label.manual.from.date"></spring:message></th> --%>
											<%-- <th class="sorting width_8" st-sort="outdate"><spring:message code="label.manual.to.date"></spring:message></th> --%>
											<th class="sorting width_8" st-sort="intime">In Time</th>
											<th class="sorting width_8" st-sort="outtime">Out Time</th>
											<th class="sorting width_7" st-sort="shift">Shift</th>
											<th class="sorting width_7" st-sort="action">Action</th>
										</tr>
         </thead>
        <tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="attendance in displayedCollection">
											<!-- 											<td data-cs-select="designation"></td> -->
											<td>{{attendance.employeeName}}</td>
											<td>{{attendance.branchName}}</td>
											<td>{{attendance.departmentCode}}</td>
											<td>{{attendance.attendanceDate}}</td>
										<td>{{attendance.attendanceId}}</td>
											
											<td>{{attendance.inTime}}</td>
											<td>{{attendance.outTime}}</td>
											<td>{{attendance.shiftName}}</td>

											<td>
													<access="hasRole('${form_code}_${modify}')">
													<span> <i class="fa  fa-pencil text-success text"
														data-ng-click="editRow(attendance)"></i>
													</span>
													<access="hasRole('${form_code}_${delete}')">
													<span data-ng-if="!row.status"> <i
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(disciplinaryCollection.disciplinary_proceedings_sk,$index)"></i>
													</span>
												</td>
										</tr>
									</tbody>
    </table>
    <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
    </footer>
  </div>
  <!-- end widget content -->
 </div>