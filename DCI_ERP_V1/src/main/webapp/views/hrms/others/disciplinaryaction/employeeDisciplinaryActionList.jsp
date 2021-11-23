<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs></span>
						<div class="widget-toolbar">
							<div>
								<span> <span class="button-icon" data-placement="bottom"
									data-reset-widgets rel="tooltip"
									title="reset">
										<i class="fa fa-refresh"></i>
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
 --%>								
 
 		<%@include file="/views/templates/panel-header.jsp"%>
 
 </div>
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>

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
											<td>{{disciplinaryCollection.employeeId}}</td>

											<td><security:authorize
													access="hasRole('${form_code}_${modify}')">
													<span> <i class="fa  fa-pencil text-success text"
														data-ng-click="editRow(disciplinaryCollection.disciplinary_proceedings_sk)"></i>
													</span>
												</security:authorize> <security:authorize
													access="hasRole('${form_code}_${delete}')">
													<span data-ng-if="!row.status"> <i
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(disciplinaryCollection.disciplinary_proceedings_sk,$index)"></i>
													</span>
												</security:authorize> </td>
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