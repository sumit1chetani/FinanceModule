<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
						</span> <span> <state-breadcrumbs> </state-breadcrumbs>
						</span>
					</header>
					<div role="content">
						<div class="widget-body">
							<div
								class="dataTables_wrapper for-inline dt-bootstrap no-footer ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">
								<form class="form-horizontal" name="separationAddForm"
									role="form">
									<div class="row">
										<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
											<fieldset>
												<div class="col-sm-6 col-md-6 col-lg-6">
													<div class="form-group">
														<label class="col-md-5 control-label"><spring:message
																code="label.employeeNo"></spring:message> </label>
														<div class="col-md-5">
															<input type="text" class="form-control input-sm"
																name="empId" ng-model="separationObj.empId"
																form_name="separationAddForm" readonly>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-5 control-label"><spring:message
																code="label.companyName"></spring:message> </label>
														<div class="col-md-5">
															<input type="text" class="form-control input-sm"
																name="company" ng-model="separationObj.company"
																form_name="separationAddForm" readonly>

														</div>
													</div>
													<div class="form-group">
														<label class="col-md-5 control-label"><spring:message
																code="label.department"></spring:message> </label>
														<div class="col-md-5">
															<input type="text" class="form-control input-sm"
																name="department" ng-model="separationObj.department"
																form_name="separationAddForm" readonly>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-5 control-label">Reporting
															Manager </label>
														<div class="col-md-5">
															<input type="text" class="form-control input-sm"
																name="department"
																ng-model="separationObj.reportingManagerName"
																form_name="separationAddForm" readonly>
														</div>
													</div>
												

													<div class="form-group">
														<label class="col-md-5 control-label">Date Of
															Resignation </label>
														<div class="col-md-5">
															<div class='input-group date datetimepick'>
																<div class="dropdown">
																	<a class="dropdown-toggle" id="validityFrom"
																		role="button" data-toggle="dropdown" data-target="#"
																		href="#">
																		<div class="input-group">
																			<input type="text" class="form-control"
																				placeholder="dd/mm/yyyy" readonly
																				friendly-name="Date of Resignation"
																				ng-model="separationObj.dateOfResignation"
																				property="separationObj.dateOfResignation"
																				form_name="separationAddForm"
																				name="dateOfResignation" id="dateOfResignation"
																				validation="required"><span
																				class="input-group-addon"><i
																				class="glyphicon glyphicon-calendar"></i></span>
																		</div>
																	</a>
																</div>
															</div>
														</div>
													</div>

												</div>
												<div class="col-sm-6 col-md-6 col-lg-6">
													<div class="form-group">

														<label class="col-md-5 control-label"><spring:message
																code="label.employeeName"></spring:message> </label>
														<div class="col-md-5">
															<input type="text" class="form-control input-sm"
																name="employeeName" ng-model="separationObj.empName"
																form_name="separationAddForm" readonly>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-5 control-label"><spring:message
																code="label.branch"></spring:message> </label>
														<div class="col-md-5">
															<input type="text" class="form-control input-sm"
																name="branch" ng-model="separationObj.branch"
																form_name="separationAddForm" readonly>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-5 control-label"><spring:message
																code="label.grade"></spring:message> <span
															style="color: red;">*</span> </label>
														<div class="col-md-5">
															<input type="text" class="form-control input-sm"
																name="grade" ng-model="separationObj.grade"
																form_name="separationAddForm" readonly>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-5 control-label"> Approval Status <span style="color: red;">*</span></label>
														<div class="col-md-5">
															<select class="form-control input-sm" name="party" form_name="separationAddForm" 
																ng-model="separationObj.approvalstatus" ng-disabled="separationObj.approvalstatus=='Approved'">
																<option value="Approved">Approved</option>
																<option value="Rejected">Rejected</option>
																<option value="Cancelled">Cancelled</option>
															</select>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-5 control-label">Notice <span
															style="color: red;">*</span>
														</label>
														<div class="col-md-5">
															<input type="text" disabled="freeze"
																class="form-control input-sm" name="grade" readonly
																ng-model="separationObj.notice"
																form_name="separationAddForm">
														</div>
													</div>
												</div>
											</fieldset>
										</div>
										<div class="col-sm-12 col-md-11 col-lg-11 margin-left-6-2">
											<br>
											<br>
											<br>
											<div class="form-group">
												<label class="col-md-3 control-label">Reason <span
													style="color: red;">*</span><span style="color: red;"></span></label>
												<div class="col-md-5">
													<textarea id="reason" rows="3" cols="35"
														class="form-control input-sm" style="resize: none"
														ng-model="separationObj.reason"
														form_name="separationAddForm" readonly
														property="separationObj.reason" name="reason" id="reason"
														validation="required" friendly-name="Reason"
														disabled="freeze"></textarea>
												</div>
											</div>
										</div>
										
										<div class="col-sm-12 col-md-11 col-lg-11 margin-left-6-2">
											<br>
											<br>
											<br>
											<div class="form-group">
												<label class="col-md-3 control-label">Approver Comments <span style="color: red;">*</span></label>
												<div class="col-md-5">
													<textarea id="reason" rows="3" cols="35"
														class="form-control input-sm" style="resize: none"
														ng-model="separationObj.approvercomments"
														form_name="separationAddForm"
														property="separationObj.approvercomments" name="reason" id="approvercomments"
														validation="required" friendly-name="Reason"
														></textarea>
												</div>
											</div>
										</div>
									</div>

									<div class="form-actions">
										<div class="row">
											<div class="col-md-12">
												<button class="btn btn-success"
													class="btn btn-success" type="button" data-ng-model="add"
													ng-click="approveSeparation(separationObj.separation_id,separationObj.approvalstatus,separationObj.approvercomments)">
													<i class="fa fa-save"></i> Update
												</button>
												<button class="btn btn-danger" type="button"
													class="btn btn-success" ng-click="cancel()">
													<i class="fa fa-close"></i> Cancel
												</button>
											</div>
										</div>
									</div>
								</form>
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