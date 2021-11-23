<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!-- #MAIN CONTENT -->
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
									title="<spring:message code='title.widget.reset'></spring:message>">
										<i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body no-padding">
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								data-st-table="displayedCollection"
								data-st-safe-src="rowCollection">
								<div class="dt-toolbar">
<%-- 									<%@include file="/views/layout/toolbar-header.tpl.jsp"%>
 --%>								</div>
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class="sorting width_13" st-sort="stockverificationno">Name</th>
											<th class="sorting width_13" st-sort="stockverificationDate">Email</th>
											<th class="sorting width_13" st-sort="locationName">SkillSet</th>
											<th class="sorting width_13" st-sort="verifyName">Yr Of
												Exp</th>
											<th class="width_5 table-heading text-center">Download</th>
											<th class="width_5 table-heading text-center">Action</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="row in displayedCollection">
											<!-- <td cs-select="row" class="text-center"></td> -->
											<td>{{row.name}}</td>
											<td>{{row.email}}</td>
											<td>{{row.skillset}}</td>
											<td>{{row.yrexp}}</td>
											<td class="text-center"><a id="tbPdfExport{{$index}}" stype="display:none"
												href="{{row.resume_url}}" download=""><button
														class="btn btn-success" type="button"
														data-ng-click="downloadfile()">Download</button></a></td>
											<td class="text-center"><%-- <security:authorize
												access="hasRole('${form_code}_${modify}')">
													<span data-ng-if="!row.status"> <i
														class="fa  fa-pencil text-success text"
														data-ng-click="editRow()"></i>
													</span>
												</security:authorize>  --%>
												<security:authorize
													access="hasRole('${form_code}_${delete}')">
													<span data-ng-if="!row.status"> <i
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(row.resume_id,$index)"></i>
													</span>
												</security:authorize> <%-- <security:authorize
													access="hasRole('${form_code}_${view}')">
													<span data-ng-if="row.status"> <i
														class="fa fa-eye text-success-dker text"
														data-ng-click="viewRow(row.resume_id,$index)"></i>
													</span>
												</security:authorize> --%></td>
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