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

		<div class="panel-body padding-0">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead class="dataTables-Main-Head">
          <tr >
          <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
           <th class="sorting width_3" st-sort="branchCode">Company Name </th>
           <th class="sorting width_3" st-sort="branchName">Branch Name</th>
           <th class="sorting width_8" st-sort="address">Department Name</th>
           <th class="sorting width_2" st-sort="phoneNumber">Designation Number</th>
           <th class="sorting width_2" st-sort="isActive">Employee Id</th>
           <th class="width_2 text-center table-heading">Employee Name</th>
                      <th class="width_2 text-center table-heading">Shift Name</th>
                      <th class="width_2 text-center table-heading">From Date</th>
                      <th class="width_2 text-center table-heading">To Date</th>
                                 <th class="width_2 text-center table-heading">Action</th>
           
          </tr>
         </thead>
        <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objShiftReAllocation in displayedCollection">
<!--            <td cs-select="objReShiftAllocation"></td> -->
           <td>{{objShiftReAllocation.companyName}}</td>
           <td>{{objShiftReAllocation.branchName}}</td>
           <td>{{objShiftReAllocation.departmentName}}</td>
           <td>{{objShiftReAllocation.designationName}}</td>
           <td>{{objShiftReAllocation.employeeId}}</td>
           <td>{{objShiftReAllocation.employeeName}}</td>
           <td>{{objShiftReAllocation.shiftName}}</td>
           <td>{{objShiftReAllocation.fromDate}}</td>
           <td>{{objShiftReAllocation.toDate}}</td>
           <td class=" td-actions text-center">
           <security:authorize access="hasRole('${form_code}_${modify}')"> 
	        <span>
	         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objShiftReAllocation.employeeId,objShiftReAllocation.fromDate,objShiftReAllocation.toDate)"></i>
	        </span>
	        </security:authorize>
<%-- 	        <security:authorize access="hasRole('${form_code}_${delete}')"> --%>
<!-- 	        <span> -->
<!-- 	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objShiftReAllocation.employeeId,objShiftReAllocation.shiftCode,$index)"></i> -->
<!-- 	        </span> -->
<%-- 	        </security:authorize> --%>
		   </td>
          </tr>
 		</tbody>
    </table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						</div>
					</div>
				</div>
		<!-- end widget content -->
	</div>
	</div>
	