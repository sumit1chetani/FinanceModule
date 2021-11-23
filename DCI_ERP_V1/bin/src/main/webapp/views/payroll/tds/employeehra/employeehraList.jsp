<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%-- 
<security:authorize access="hasRole('F0336_A')" var="isAdd" />
<security:authorize access="hasRole('F0336_D')" var="isDelete" /> --%>
<!-- #MAIN CONTENT -->
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
						<div class="widget-toolbar">
							<!-- add: non-hidden - to disable auto hide -->
							<div>
								<span> <span class="button-icon" data-reset-widgets
									rel="tooltip"
									title="<spring:message code="title.widget.reset"></spring:message>"
									data-placement="bottom"> <i
										class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body no-padding">
							<form class="form-horizontal" name="vesselMasterForm" role="form"
								ng-submit="#" novalidate>
								<div
									class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
									st-table="displayedCollection" st-safe-src="rowCollection">
									<!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
									<div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
									</div>
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>
												<!-- <th class="width_1"></th> -->
												<th class="sorting width_10" st-sort="employeeId">Employee No</th>
												<th class="sorting width_10" st-sort="employeeName">Employee Name</th>
												<th class="sorting width_10" st-sort="rentPaid">Amount Of Rent
													Paid</th>
												<th class="sorting width_10" st-sort="monthYearDisplay">Month And Year</th>
												<th class="sorting width_10" st-sort="hraStatus">Status</th>
												<th class="sorting width_10" st-sort="">View Details</th>
												<th class="sorting width_10" st-sort="">Action</th>

											</tr>

										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-model="tableSelection[$index]"
												ng-repeat="employeehrdCollection in displayedCollection">
												<!--  <td cs-select="objVesselMasterItem"></td> -->
												<td>{{employeehrdCollection.employeeId}}</td>
												<td>{{employeehrdCollection.employeeName}}</td>
												<td>{{employeehrdCollection.rentPaid}}</td>
												<td>{{employeehrdCollection.monthYearDisplay}}</td>
												<td><span
													ng-if="employeehrdCollection.hraStatus == '1'">Pending</span>
													<span ng-if="employeehrdCollection.hraStatus == '2'">Approved</span>
													<span ng-if="employeehrdCollection.hraStatus == '3'">Rejected</span>
													<span ng-if="employeehrdCollection.hraStatus == '4'">Closed</span>
												</td>
												<td><a id="tbPdfExport{{$index}}" stype="display:none"
													href="{{employeehrdCollection.fileName}}" download="">
														<button class="btn btn-success" type="button"
															data-ng-click="downloadfile()">Download</button>
												</a></td>
												<td class=" td-actions text-center"
													ng-if="employeehrdCollection.hraStatus=='1'"><security:authorize
														access="hasRole('${form_code}_${modify}')">
														<span> <i class="fa  fa-pencil text-success text"
															data-ng-click="editRow(employeehrdCollection.employeeId,employeehrdCollection.monthYear)"></i>
														</span>
													</security:authorize>  <security:authorize
															access="hasRole('${form_code}_${delete}')"><span>
															<i class="fa fa-trash-o text-danger-dker text"
																data-ng-click="deleteRow(employeehrdCollection.employeeId,employeehrdCollection.monthYear)"></i>
														</span></security:authorize>
												 <span> <a href=""
														data-ng-click="approve(employeehrdCollection.employeeId,employeehrdCollection.monthYear);">Approve</a>
														<!-- <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="view" ng-click="approve(employeehrdCollection.employeeId,employeehrdCollection.monthYear)" style= "margin-left: 10%";>
									 
									       Approve
		</button> -->
												</span></td>
											</tr>
										</tbody>
									</table>
									<div class="dt-toolbar-footer"
										data-smart-include="views/layout/toolbar-footer.tpl"></div>
								</div>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>
