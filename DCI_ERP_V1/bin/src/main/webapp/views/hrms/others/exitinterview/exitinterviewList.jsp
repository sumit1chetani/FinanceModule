
<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
						</span> <span class="ui-separator"></span> <span><state-breadcrumbs></state-breadcrumbs>
						</span>
						<div class="widget-toolbar">
							<!-- add: non-hidden - to disable auto hide -->
							<div>
								<span> <span id="refresh"
									class="button-icon jarviswidget-toggle-btn" data-reset-widgets
									rel="tooltip"
									title="Warning! This will reset all your widget settings."
									data-placement="bottom"> <i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<input type="hidden" value="${form_code}" id="form_code" />
						<div class="widget-body no-padding">
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">
								<div class="dt-toolbar">
<%-- 									<%@include file="/views/layout/toolbar-header.tpl.jsp"%>
 --%>								</div>
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>

											<th class="sorting width_12" data-st-sort="companyId">Employee ID</th>
											<th class="sorting width_12" data-st-sort="companyId">Designation</th>
												<th class="sorting width_12" data-st-sort="companyId">Approval Status</th>
											<th class="sorting width_15" data-st-sort="holiday">Status
											</th>
											<th class="sorting width_12" data-st-sort="date">Action
											</th>
										</tr>
									</thead>

									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="disciplinaryCollection in displayedCollection">
											<td>{{disciplinaryCollection.first_name}}</td>
											<td>{{disciplinaryCollection.designation_name}}</td>
											<td>{{disciplinaryCollection.approval_status}}</td>
											<td>{{disciplinaryCollection.status}}</td>
											<td>
												<security:authorize
													access="hasRole('${form_code}_${delete}')">
													<span data-ng-if="disciplinaryCollection.approval_status!='Approved'"> <i
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(disciplinaryCollection.exitid,$index)"></i>
													</span>
												</security:authorize>
												<security:authorize
													access="hasRole('${form_code}_${view}')">
													<span  data-ng-if="disciplinaryCollection.approval_status=='Approved'"> <i class="fa  fa-list-alt text-dark text"
														data-ng-click="view(disciplinaryCollection.exitid)"></i>
													</span>
												</security:authorize></td>
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
