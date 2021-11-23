<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0310_D')" var="isDelete" /> --%>
<%-- <security:authorize access="hasRole('F0310_A')" var="isAdd" /> --%>

<div id="content">
	<!-- widget grid -->
	<section widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
					</header>
					<div role="content">
						<div class="widget-body no-padding">
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">
								<!--   <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->

								<div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
								</div>
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<!-- <th class="width_1"></th> -->
											<th class="sorting width_10" st-sort="employeeId">Employee
												No</th>
											<th class="sorting width_10" st-sort="employeeName">Employee
												Name</th>
											<th class="sorting width_15" st-sort="reimbusementName">Reimbursement
												Type</th>
											<th class="sorting width_10" st-sort="description">Description</th>
											<th class="sorting width_10" st-sort="paymentMode">Payment
												Mode</th>
											<th class="sorting width_10" st-sort="amount">Amount</th>
											<th class="sorting width_10" st-sort="status">Status</th>
											<th class="sorting width_10" st-sort="document">Document</th>
											<th class="width_2 table-heading">Action</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="reimburseMentList in displayedCollection">
											<!-- <td cs-select="objVesselMasterItem"></td> -->
											<td>{{reimburseMentList.employeeId}}</td>
											<td>{{reimburseMentList.employeeName}}</td>
											<td>{{reimburseMentList.reimbusementName}}</td>
											<td>{{reimburseMentList.description}}</td>
											<td>{{reimburseMentList.paymentMode}}</td>
											<td>{{reimburseMentList.amount}}</td>
											<td><span ng-if="reimburseMentList.status == '1'">Pending</span>
												<span ng-if="reimburseMentList.status == '2'">Approved</span>
												<span ng-if="reimburseMentList.status == '3'">Rejected</span>
												<span ng-if="reimburseMentList.status == '4'">Closed</span>
											</td>
											<td><a id="tbPdfExport{{$index}}" stype="display:none"
												href="{{reimburseMentList.fileName}}" download=""><button
														class="btn btn-success" type="button"
														data-ng-click="downloadfile()">Download</button></a></td>
											<td class=" td-actions text-center"><security:authorize
													access="hasRole('${form_code}_${modify}')">
													<span> <i class="fa  fa-pencil text-success text"
														ng-if="reimburseMentList.status == '1'"
														data-ng-click="editRow(reimburseMentList.reimbursementId)"></i>
													</span>
												</security:authorize> <security:authorize
													access="hasRole('${form_code}_${delete}')">
													<span> <i
														class="fa fa-trash-o text-danger-dker text"
														ng-if="reimburseMentList.status == '1'"
														data-ng-click="deleteRow(reimburseMentList.reimbursementId)"></i>
													</span>
												</security:authorize></td>
										</tr>
									</tbody>
								</table>
								<div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div>
							</div>
						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>