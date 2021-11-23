<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection"  st-persist="usermasterTable" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-10">
			<div class="table-responsive" style=" border: 1px solid #CCC;">

       				        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">

									<thead class="dataTables-Main-Head">
										<tr>
											<!-- <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox"> <i></i>
           </label></th> -->
											<th class="sorting width_8" st-sort="requisitionNumber">Requisition
												No</th>
											<th class="sorting width_8" st-sort="requisitionNumber">PR
												Request No</th>
											<th class="sorting width_8" st-sort="requisitionNumber">Request
												Type</th>
											<th class="sorting width_8" st-sort="employeeName">Requested
												By</th>
											<th class="sorting width_8" st-sort="requisitionDate">Requested
												Date</th>
											<th class="sorting width_8" st-sort="designationName">Job
												Title</th>
											<th class="sorting width_8" st-sort="sourceLocationName">Source
												Location</th>
											<th class="sorting width_8" st-sort="destinationLocationName">Destination
												Location</th>
											<!--  <th class="sorting width_8" st-sort="prRequestNo">PR Request Number</th> -->
											<th class="sorting width_8" st-sort="requisitionStatusName">Status</th>
											<th class="width_2 text-center table-heading">Action</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="objStoreToStore in displayedCollection">
											<!-- <td cs-select="" class="text-center"></td> -->
											<td>{{objStoreToStore.requisitionNumber}}</td>
											<td>{{objStoreToStore.prRequestNo}}</td>
											<td>{{objStoreToStore.requestTypeName}}</td>
											<td>{{objStoreToStore.employeeName}}</td>
											<td>{{objStoreToStore.requisitionDate}}</td>
											<td>{{objStoreToStore.designationName}}</td>
											<td>{{objStoreToStore.sourceLocationName}}</td>
											<td>{{objStoreToStore.destinationLocationName}}</td>
											<!--  <td>{{objStoreToStore.prRequestNo}}</td> -->
											<td>{{objStoreToStore.requisitionStatusName}}</td>
											<td class=" td-actions text-center">
													<span> <i class="fa  fa-pencil text-success text"
														data-ng-click="editRow(objStoreToStore.purchaseRequisitionId,objStoreToStore.requisitionStatusName)"></i>
													</span>
												
													<span> <i
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(objStoreToStore.purchaseRequisitionId,$index)"></i>
													</span>
												
													<span> <i class="fa fa-print text-dark text"
														title='Print' data-ng-click="printRow(objStoreToStore)"></i>
													</span>
											 <%--   <security:authorize access="hasRole('${form_code}_${delete}')"> --%>
												<span> <i class="fa  fa-list-alt text-dark text"
													title="Approve"
													data-ng-click="approve(objStoreToStore,objStoreToStore.requisitionStatusName)"></i>
											</span> <span> <i class="fa  fa-list-alt text-dark text"
													title="Issue" style="color: red"
													data-ng-click="issue(objStoreToStore.purchaseRequisitionId,objStoreToStore.requisitionStatusName)"></i>
											</span> <%--  </security:authorize> --%></td>
										</tr>
									</tbody>
								</table>

						</div>
						<footer class="panel-footer panel-footer-list" style="padding:0px;">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>

