<!-- #MAIN CONTENT -->
<style>
#standard-datatable-widget>div>div>form>div:nth-child(1)>fieldset>div:nth-child(4)>div>selectivity>div.selectivity-dropdown>div
	{
	width: 164px !important;
	overflow: auto;
}

#standard-datatable-widget>div>div>form>div:nth-child(1)>fieldset>div:nth-child(5)>div>selectivity>div.selectivity-dropdown>div
	{
	width: 164px !important;
	overflow: auto;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
						<div class="widget-toolbar">
							<!-- add: non-hidden - to disable auto hide -->
							<div>
								<span> <span class="button-icon" data-reset-widgets
									rel="tooltip"
									title="reset"
									data-placement="bottom"> <i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="employeeMasterReportForm" role="form"
								ng-submit="#" novalidate>
								<div class="col-sm-12 col-md-4 col-lg-4">
									<fieldset>

										<div class="form-group">
											<label class="col-md-6 control-label">Organization
												Name <span style="color: red">*</span>
											</label> <input type="hidden" value="${form_code}" id="formCode" />
											<div class="col-md-6 inputGroupContainer">
												<selectivity list="companyList"
													property="EmployeeMasterReportData.companyCode"
													ng-model="EmployeeMasterReportData.companyCode"
													name="companyCode"></selectivity>

											</div>
										</div>
										<div class="form-group ">
											<label class="col-md-6 control-label">Branch <span
												style="color: red">*</span></label>
											<div class="col-md-6">
											<selectivity list="branchList"
													property="EmployeeMasterReportData.branch"
													ng-model="EmployeeMasterReportData.branch"
													name="Branch Name"></selectivity>
											

											</div>
										</div>
										<div class="form-group ">
											<label class="col-md-6 control-label">Department</label>
											<div class="col-md-6">
												<selectivity list="departmentList"
													property="EmployeeMasterReportData.departmentCode"
													ng-change="getReportManager();"
													ng-model="EmployeeMasterReportData.departmentCode"
													name="department"></selectivity>

											</div>
										</div>



									</fieldset>
								</div>
								<div class="col-sm-12 col-md-4 col-lg-4">
									<fieldset>

										<div class="form-group ">
											<label class="col-md-6 control-label">Designation</label>
											<div class="col-md-6">
												<selectivity list="designationList"
													property="EmployeeMasterReportData.designation"
													ng-model="EmployeeMasterReportData.designation"
													name="designation"></selectivity>

											</div>
										</div>
										<div class="form-group ">
											<label class="col-md-6 control-label">Division</label>
											<div class="col-md-6">
												<selectivity list="divisionList"
													property="EmployeeMasterReportData.division"
													ng-model="EmployeeMasterReportData.division"
													name="division"></selectivity>

											</div>
										</div>
										<div class="form-group">
											<label class="col-md-6 control-label"> Employee Name
											</label>

											<div class="col-md-6">
												<select class="form-control journalVoucher-textBox"
													ng-model="EmployeeMasterReportData.reportMangrId"
													ng-options="emp.reportMangrId as emp.reportManagerName for emp in reportToManagerList"
													data-message-id="reportMangrId" id="reportMangrId"
													name="reportMangrId" friendly-name="Reporting Manager"
													ng_change="getReportManager(EmployeeMasterReportData.branch);">
													<option value="">Select</option>
												</select>
											</div>

										</div>
										<div class="form-group">
											<label class="col-md-6 control-label">DOB</label>
											<div class="col-md-6">
												<div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="dob" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control"
																	placeholder="dd-mm-yyyy" name="Date of Birth"
																	data-validator="required" data-valid-method="submit"
																	data-message-id="Date of Birth"
																	data-ng-model="EmployeeMasterReportData.dob"><span
																	class="input-group-addon"><i
																	class="glyphicon glyphicon-calendar"></i></span>
															</div>
														</a>
														<ul class="dropdown-menu" role="menu"
															aria-labelledby="dLabel">
															<datetimepicker
																data-ng-model="EmployeeMasterReportData.dob"
																data-on-set-time="EmployeeMasterReportData.dob = onDateSet(newDate)"
																data-datetimepicker-config="{ dropdownSelector: '#dob',startView:'day', minView:'day'}" />
														</ul>
													</div>
												</div>
											</div>
										</div>


									</fieldset>

								</div>
								<div class="col-sm-12 col-md-12 col-lg-4">
									<fieldset>

										<div class="form-group ">
											<label class="col-md-5 control-label">Blood Group</label>
											<div class="col-md-6">
												<selectivity list="bloodgroupList"
													property="EmployeeMasterReportData.bloodGrp"
													ng-model="EmployeeMasterReportData.bloodGrp"
													name="bloodGrp"></selectivity>

											</div>
										</div>

										<div class="form-group">
											<label class="col-md-5 control-label">Marital Status</label>
											<div class="radio radio-inline">

												<label class="i-checks"> <input type="radio"
													class="" name="marritalStatus" ng-value="true"
													ng-model="EmployeeMasterReportData.marritalStatus">
													<i></i> Married
												</label>
											</div>
											<div class="radio radio-inline">
												<label class="i-checks"> <input type="radio"
													class="" name="marritalStatus" ng-value="false"
													ng-model="EmployeeMasterReportData.marritalStatus">
													<i></i> UnMarried
												</label>

											</div>
										</div>
										
										<div class="form-group">
											<label class="col-md-5 control-label">ESI Applicable</label>
											<div class="radio radio-inline">

												<label class="i-checks"> <input type="radio"
													class="" name="esiApp" ng-value="true"
													ng-model="EmployeeMasterReportData.esiApp"> 
													<i></i>	Yes
												</label>
											</div>
											<div class="radio radio-inline" style="position: relative; left: 22px;">
												<label class="i-checks"> <input type="radio"
													class="" name="esiApp" ng-value="false"
													ng-model="EmployeeMasterReportData.esiApp">
													 <i></i>No
												</label>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">PF Applicable </label>
											<div class="radio radio-inline">

												<label class="i-checks"> <input type="radio"
													class="" name="pfApp" ng-value="true"
													ng-model="EmployeeMasterReportData.pfApp"> <i></i>
													Yes
												</label>
											</div>
											<div class="radio radio-inline" style="position: relative; left: 22px;">
												<label class="i-checks"> <input type="radio"
													class="" name="pfApp" ng-value="false"
													ng-model="EmployeeMasterReportData.pfApp"> <i></i>
													No
												</label>
											</div>
										</div>
									</fieldset>
								</div>

								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>

											<label class="col-md-2 control-label">Physical
												Handicap </label> <label class="col-md-1 control-label"> <input
												type="checkbox" class="checkbox style-0" name="operationAdd"
												data-ng-model="EmployeeMasterReportData.isActiveSight">
												<span>Sight</span>
											</label> <label class="col-md-1 control-label"> <input
												type="checkbox" class="checkbox style-0" name="operationAdd"
												data-ng-model="EmployeeMasterReportData.isActiveDumb">
												<span>Dumb</span>
											</label> <label class="col-md-1 control-label"> <input
												type="checkbox" class="checkbox style-0" name="operationAdd"
												data-ng-model="EmployeeMasterReportData.isActiveHearing">
												<span>Hearing</span>
											</label> <label class="col-md-1 control-label"> <input
												type="checkbox" class="checkbox style-0" name="operationAdd"
												data-ng-model="EmployeeMasterReportData.isActiveHand">
												<span>Hand</span>
											</label> <label class="col-md-1 control-label"> <input
												type="checkbox" class="checkbox style-0" name="operationAdd"
												data-ng-model="EmployeeMasterReportData.isActiveFeet">
												<span>Feet</span>
											</label> <label class="col-md-2 control-label">Status</label>
											<div class="col-md-2">
												<selectivity list="astatus"
													property="EmployeeMasterReportData.astatus"
													ng-model="EmployeeMasterReportData.astatus" name="astatus"></selectivity>

											</div>

										</fieldset>
									</div>
								</div>

								<div class="row">
									<div
										class="col-sm-12 col-md-12 col-lg-12 padding-top-20 padding-bottom-15">
										<fieldset>
											<div class="col-sm-12 col-md-4 col-lg-4 col-md-offset-4">
												<!-- <button class="btn btn-success" ng-click="showEmployeeReport()">Submit</button> -->
												<button class="btn btn-success col-md-offset-2"
													type="button"
													ng-click="showEmployeeReportList(EmployeeMasterReportData)"
													class="btn btn-success">Generate
<%-- 													<spring:message code="label.availing.leave.generate"></spring:message>
 --%>												</button>

												<security:authorize	access="hasRole('${form_code}_${export}')">
												<button class="btn btn-primary"
												ng-click="exportExcel(employeeMasterReportForm)">
												<i class="fa fa-download"> </i> Export Excel
											</button>

											<a id="empDtlExport" href="" download=""></a>
											
													<!-- <span ng-click="">
														<a id="sPdfExport" href=""
														class="btn btn-sm btn-primary"> Export</a>
													</span> -->
												</security:authorize>
												<button data-ng-click="reset()" class="btn btn-info"
													type="button">
													<i class="fa fa-undo"></i>Reset
												</button>


											</div>
										</fieldset>
									</div>
								</div>
 

								<div role="content" data-ng-if="tableGenValue">
									<div class="widget-body no-padding">
										<div
											class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
											data-st-table="displayedCollection"
											data-st-safe-src=rowCollection>
												
											<button class="btn btn-primary" type="button" style="color: #090c0c !important !important;background-color: #e42525;border-color: #f4f4f4;margin-left: 44%;"
												data-toggle="collapse" data-target="#collapseExample"
												aria-expanded="false" aria-controls="collapseExample">
												Report Header</button>

											<div class="collapse" id="collapseExample">
												<div class="panel-body float-left padding-0"
													style="width: 100%; border-top: none;">
													<div class="table-responsive" style="overflow: hidden;">
														<div data-role="content" class="form-horizontal panel"
															data-collapse="isCollapsed">
															<ul class="dragList row list-unstyled">
																<li class="col-md-3 col-sm-3 col-lg-3">
																	<div class="row">
																		<label class="control-label col-md-8"
																			style="width: 61%">SELECT ALL :</label>
																		<div class="col-md-4" style="padding-left: 36px;">
																			<label class="i-checks m-b-none checkbox"> <input
																				type="checkbox" data-ng-click="selectAll(selectall)"
																				data-ng-model="selectall" /><i
																				style="margin-left: -12px;"></i>
																			</label>
																		</div>
																	</div>
																</li>
																<li data-ng-repeat="column in employeeReportHeaderList"
																	class="col-sm-3 col-md-3 col-lg-3">
																	<div class="row" data-ng-drag="column.isDraggable"
																		data-ng-drop="column.isDraggable"
																		data-ng-drop-success="onDropComplete($index, $data,$event)"
																		data-ng-drag-data="column" style="width: 100%">
																		<label class="control-label col-md-8">{{column.title}}
																			:</label>
																		<div class="col-md-4">
																			<label class="i-checks m-b-none checkbox"> <input
																				type="checkbox"
																				data-ng-click="getSelectedColumn(column)"
																				data-ng-model="column.visible"
																				data-ng-disabled="column.isDefault" /><i></i>
																			</label>
																		</div>
																	</div>
																</li>
																<li class="col-md-3 col-sm-3 col-lg-3 last-child"
																	data-ng-drop="true"
																	data-ng-drop-success="onDropComplete($index, $data,$event)">
																	<div class="row">
																		<div class="col-md-4">
																			<label class="i-checks m-b-none checkbox"> </label>
																		</div>
																	</div>
																</li>
															</ul>
														</div>
													</div>
												</div>

											</div>
											
											
											
											<div class="dt-toolbar"
												data-smart-include="views/layout/toolbar-header.tpl"></div>

											<div class="col-sm-12 col-md-12 col-lg-12 padding-bottom-10"
												style="overflow-x: scroll;">

												<table class="table table-bordered">

													<thead>
														<th class="width_6"
															data-ng-repeat="column in employeeReportHeaderList"
															data-ng-class={hide:(!column.visible)}>{{column.title}}</th>
													</thead>


													<tbody>
														<tr ng-repeat="dailyReport in displayedCollection">
															<td class="width_6 padding-number-align text-center "
																data-ng-repeat="column in employeeReportHeaderList"
																data-ng-class={hide:(!column.visible)}><span>{{dailyReport[column.id]}}</span>

															</td>
														</tr>
													</tbody>
												</table>
												<div class="dt-toolbar-footer"
													data-smart-include="views/layout/toolbar-footer.tpl"></div>

											</div>
										</div>
										<!-- end widget content -->
									</div>

								</div>
								
							</form>


						</div>
					</div>
					</div>
			</article>
		</div>
	</section>
</div>