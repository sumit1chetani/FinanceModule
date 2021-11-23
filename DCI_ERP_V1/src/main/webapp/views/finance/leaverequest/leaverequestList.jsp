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
				<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="sorting width_7" st-sort="leaveType">Leave Type</th>
											<th class="sorting width_15" st-sort="empName">Employee
												Name</th>
											<th class="sorting width_10" st-sort="fromDate">From Date</th>
											<th class="sorting width_10" st-sort="ToDate">To Date</th>
											<th class="sorting width_7" st-sort="noofDays">No of Days</th>
											<th class="sorting width_9" st-sort="leaveReason">Leave Reason</th>
											<!-- <th class="sorting width_8" st-sort="alternativeEmployeeName">Alt.
												Employee Name</th> -->
											<!-- <th class="sorting width_10" st-sort="approvalType">Approval
												Type</th> -->
											<th class="sorting width_8" st-sort="status">Status</th>
											
											<th class="sorting width_8" st-sort="status">Approved By</th>
							<!-- 				<th class="sorting width_10" st-sort="cancelRequest">Leave
												Cancellation Applied</th> -->
												
									<!-- 	<th class="sorting width_8" st-sort="">Created by
 												</th> 
 											<th class="sorting width_8" st-sort="">Created on 
 												</th>  -->
 											<!-- <th class="sorting width_8" st-sort="">Modified by
 												</th> 
 											<th class="sorting width_8" st-sort="">Modified on 
 												</th>  -->
											<th class="width_6">Action</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="leaveObj in displayedCollection">
											<td>{{leaveObj.leaveType}}</td>
											<td>{{leaveObj.empName}}</td>
											<td>{{leaveObj.fromDate}}</td>
											<td>{{leaveObj.toDate}}</td>
											<td>{{leaveObj.noOfDays}}</td>
											<td>{{leaveObj.leaveReason}}</td>
										<!-- 	<td>{{leaveObj.alternativeEmployeeName}}</td> -->
											
<!-- 											<td>{{leaveObj.Created by}}</td> -->
<!-- 											<td>{{leaveObj.Created on}}</td> -->
<!-- 											<td>{{leaveObj.Modified by}}</td> -->
<!-- 											<td>{{leaveObj.Modified on}}</td> -->
									<!-- 		<td><span
												ng-if="leaveObj.alternateEmpStatus == 0 && leaveObj.approvalType == 1 || leaveObj.alternateEmpStatus == 2 && leaveObj.approvalType == 2 
		         			|| leaveObj.alternateEmpStatus == 2 && leaveObj.action == 1 && leaveObj.finalEmpStatus==1 && leaveObj.cancelRequest==true || leaveObj.alternateEmpStatus == 2 && leaveObj.action == 0 && leaveObj.finalEmpStatus==0 && leaveObj.cancelRequest==true 
		         			|| leaveObj.alternateEmpStatus == 2 && leaveObj.action == 1 && leaveObj.finalEmpStatus==0 && leaveObj.cancelRequest==true">Alt.
													Employee Approval</span> <span
												ng-if="leaveObj.alternateEmpStatus == 0 && leaveObj.approvalType == 2 || leaveObj.alternateEmpStatus==1 && leaveObj.action == 0  && leaveObj.approvalType == 2 || leaveObj.action == 2 && leaveObj.finalEmpStatus==0 || leaveObj.action == 2 && leaveObj.finalEmpStatus==1 && leaveObj.cancelRequest==true || leaveObj.action == 2 && leaveObj.finalEmpStatus==0 && leaveObj.cancelRequest==true">Reporting
													Person Approval</span> <span
												ng-if="leaveObj.action == 1 && leaveObj.approvalType == 3 || leaveObj.finalEmpStatus == 2 && leaveObj.approvalType == 3 || leaveObj.action == 2 && leaveObj.finalEmpStatus==2 && leaveObj.cancelRequest==true">Final
													Level Approval</span></td> -->
									<!-- 		<td><span
												ng-if="leaveObj.alternateEmpStatus == 0 || leaveObj.alternateEmpStatus == 2">
													<span
													ng-if="leaveObj.alternateEmpStatus == 0 && leaveObj.approvalType == 1">Pending</span> <span
													ng-if="leaveObj.alternateEmpStatus == 1 && leaveObj.approvalType == 2">Agreed</span>
													<span
													ng-if="leaveObj.alternateEmpStatus == 2 && leaveObj.approvalType == 2"><span
														ng-if="leaveObj.cancelRequest==false">Disagreed</span><span
														ng-if="leaveObj.cancelRequest==true">Cancelled</span></span>
											</span> <span
												ng-if="leaveObj.alternateEmpStatus == 0 && leaveObj.approvalType == 2 || leaveObj.alternateEmpStatus==1 && leaveObj.action == 0 || leaveObj.action == 2">
													<span
													ng-if="leaveObj.action == 0 && leaveObj.approvalType == 2">Pending</span> <span
													ng-if="leaveObj.action == 1 && leaveObj.approvalType == 3">Approved</span> <span
													ng-if="leaveObj.action == 2 && leaveObj.approvalType == 3"><span
														ng-if="leaveObj.cancelRequest==false">Rejected</span><span
														ng-if="leaveObj.cancelRequest==true">Cancelled</span></span>
											</span> <span ng-if="leaveObj.action == 1"> <span
													ng-if="leaveObj.finalEmpStatus == 0 && leaveObj.approvalType == 3">Pending</span> <span
													ng-if="leaveObj.finalEmpStatus == 1 && leaveObj.approvalType == 3">Approved</span> <span
													ng-if="leaveObj.finalEmpStatus == 2 && leaveObj.approvalType == 3"><span
														ng-if="leaveObj.cancelRequest==false">Rejected</span><span
														ng-if="leaveObj.cancelRequest==true">Cancelled</span></span>
											</span></td> -->
											<!-- <td align="center"><input type="checkbox"
												checked="checked" ng-model="leaveObj.cancelRequest"
												disabled="disabled"></td> -->
										<!-- 	<td>{{leaveObj.created_by}}</td> </td> 
 											<td>{{leaveObj.created_on}}</td> -->   
  										<!-- 	<td>{{leaveObj.modified_by}}</td>  
   											<td>{{leaveObj.modified_on}}</td>   -->
												<td>
			                <span ng-if="leaveObj.status == '0'">Pending</span>
			                <span ng-if="leaveObj.status == '1'">Approved</span>
			                <span ng-if="leaveObj.status == '2'">Cancelled</span>
			             </td>
			             
			             
			             <td>{{leaveObj.approvedBy}}</td>
											<td class=" td-actions text-center"><span
												ng-if="leaveObj.leaveDeduct==false"> <security:authorize
														access="hasRole('${form_code}_${modify}')">
														<span> <i class="fa  fa-pencil text-success text"
															data-ng-click="editRow(leaveObj)"></i>
														</span>
													</security:authorize> <security:authorize
														access="hasRole('${form_code}_${delete}')">
														<span> <i
															class="fa fa-trash-o text-danger-dker text"
															data-ng-click="deleteRow(leaveObj)"></i>
														</span>
													</security:authorize> 
													<security:authorize
												access="hasRole('${form_code}_${print}')"> 
													
													<span
													ng-if="leaveObj.alternateEmpStatus == 1 && leaveObj.approvalType == 2 || leaveObj.action == 1 && leaveObj.approvalType == 3 || leaveObj.finalEmpStatus == 1 && leaveObj.approvalType == 3"
													title="Cancel Leave Request"> <i
														class="fa fa-close text-info text"
														data-ng-click="cancelLeave(leaveObj)"></i>
												</span> 
												
											</security:authorize> 
												<span
													title="View ML Leave Request"> <i
														class="fa fa-eye text-primary text"
														data-ng-click="viewLeave(leaveObj)"></i>
												</span>


											</span></td>
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
	