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
          <tr >
          <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
          <th class="sorting width_12" data-st-sort="companyId">Proceedings</th>
											<th class="sorting width_12" data-st-sort="branch">Proceeding
												Reason</th>
											<th class="sorting width_15" data-st-sort="holiday">Proceeding
												Date</th>
											<th class="sorting width_12" data-st-sort="date">Employee ID
											</th>
											<th class="sorting width_5" data-st-sort="date">Action
											</th>
          </tr>
         </thead>
        <tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="disciplinaryCollection in displayedCollection">
											<td>{{disciplinaryCollection.proceedings}}</td>
											<td>{{disciplinaryCollection.reason}}</td>
											<td>{{disciplinaryCollection.proceedings_date}}</td>
											<td>{{disciplinaryCollection.employeename}}</td>

											<td>
													<access="hasRole('${form_code}_${modify}')">
													<span> <i class="fa  fa-pencil text-success text"
														data-ng-click="editRow(disciplinaryCollection.disciplinary_proceedings_sk)"></i>
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
</div> 