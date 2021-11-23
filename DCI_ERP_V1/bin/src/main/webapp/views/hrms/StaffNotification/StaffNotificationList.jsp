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
		<%@include file="/views/templates/panel-header.jsp"%>
								</div>
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
										

                                        <th class="sorting width_7" data-st-sort="divisionName">Division
												</th>
																						
										<th class="sorting width_7" data-st-sort="departmentName">Department
												</th>
												<th class="sorting width_7" data-st-sort="designationName">Designation
												</th>
											<th class="sorting width_7" data-st-sort="gradeName">Grade
												</th>
											<th class="sorting width_7" data-st-sort="reportingToName">Reporting To
											</th>
												
											<th class="sorting width_10" data-st-sort="email">Notification
											</th>
											<th class="sorting width_10" data-st-sort="action">Created Date
											</th>
											<th class="sorting width_7" data-st-sort="salution">Created By
											</th>
											<th class="sorting width_7" data-st-sort="salution">Status
											</th>
											<th class="sorting width_7" data-st-sort="action">Action
											</th>
										</tr>
									</thead>

									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="educationnotification in displayedCollection">
																						<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.divisionName}}">{{educationnotification.divisionName}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.departmentName}}">{{educationnotification.departmentName}}</td>

																					<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.designationName}}">{{educationnotification.designationName}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.gradeName}}">{{educationnotification.gradeName}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.reportingToName}}">{{educationnotification.reportingToName}}</td>
											<td class="wrapping" data-toggle="tooltip"
												title="{{educationnotification.notificationContent}}">{{educationnotification.notificationContent}}</td>
							                <td>{{educationnotification.createdDate}}</td>
											<td>{{educationnotification.credtedBy}}</td>
											
										   <td>{{educationnotification.status}}</td>
                                               
											<td class=" td-actions text-center">
												<span ng-if="educationnotification.status=='Pending'"> <i
													class="fa  fa-pencil text-success text"
													data-ng-click="editRow(educationnotification.staffNotificationId,$index)"></i>
											</span> <span ng-if="educationnotification.status=='Pending'"> <i
													class="fa fa-trash-o text-danger-dker text"
													data-ng-click="deleteRow(educationnotification.staffNotificationId,$index)"></i>
											</span> <span  ng-if="educationnotification.status=='Pending'" class="width_10"> <i
													class="fa  fa-list-alt text-dark text"
													data-ng-click="Publish(educationnotification.staffNotificationId)"
													title="Send
													"></i>
											</span>
											<span  ng-if="educationnotification.status=='Pending'" class="width_10"> <i
													class="fa fa-eye"
													data-ng-click="Publishflag(educationnotification.staffNotificationId)"
													title="Publish
													"></i>
											</span>
											<span  ng-if="educationnotification.status=='Pending'" class="width_10"> <i
													class="fa fa-eye" style="color: red;"
													data-ng-click="unPublishflag(educationnotification.staffNotificationId)"
													title="unPublish
													"></i>
											</span>
											</td>							</tr>
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

