
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
						</span>
						<state-breadcrumbs></state-breadcrumbs>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="staffCircularForm">
								<div class="row">
									<!-- <div class="col-sm-12 col-md-12 col-lg-12">
										<div class="form-group">
											<label class="col-md-5 control-label">Standard<span
												style="color: red;">*</span></label>
											<div class="col-md-2">
												<input type="text" class="form-control input-sm"
													name="Standard" validation="required"
													friendly-name="Standard" form-name="staffCircularForm"
													ng-model="homework.selectclass">
											</div>
											
										</div> -->
									<!-- <div class="form-group">
											<label class="col-md-5 control-label">Section<span
												style="color: red;">*</span></label>
											<div class="col-md-2">
												<input type="section" class="form-control input-sm"
													name="section" validation="required"
													friendly-name="Section" form-name="staffCircularForm"
													ng-model="homework.section">
											</div>
										</div>

 -->

                                    		<div class="form-group">
												<label class="col-md-5 control-label">From Date<span
													style="color: red;">*</span></label>
												<div class="col-md-2">
													<div class="input-group date datetimepick col-md-12">
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="date" role="button" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" form-name="staffCircularForm"
																		name="Date" validation="required" friendly-name="Date" 
																		data-ng-model="staffCircular.fromDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="staffCircular.fromDate"
																	data-on-set-time="staffCircular.fromDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#date',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
													<div class="form-group">
												<label class="col-md-5 control-label">To Date<span
													style="color: red;">*</span></label>
												<div class="col-md-2">
													<div class="input-group date datetimepick col-md-12">
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="date" role="button" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" form-name="staffCircularForm"
																		name="Date" validation="required" friendly-name="Date" 
																		data-ng-model="staffCircular.toDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="staffCircular.toDate"
																	data-on-set-time="staffCircular.toDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#date',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
									<div class="form-group">
										<label class="col-md-5 control-label">Division</label>
										<div class="col-md-2">
											<select id="division" multiple="multiple"
												name="multiselect[]" ng-model="staffCircular.division"
												form-name="staffCircularForm" friendly-name="division"
												ng-options="option.text for option in divisionList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in divisionList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>

										</div>

									</div>


									<div class="form-group">
										<label class="col-md-5 control-label">Department </label>
										<div class="col-md-2">
											<select id="department" multiple="multiple"
												name="multiselect[]" ng-model="staffCircular.department"
												form-name="staffCircularForm"
												friendly-name="departmentId"
												ng-options="option.text for option in departmentList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in departmentList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>

										</div>

									</div>
									<!-- <div class="form-group">

										<label class="col-md-5 control-label">Designation </label>
										<div class="col-md-2">
											<select id="designation" multiple="multiple"
												name="multiselect[]"
												ng-model="staffCircular.designation"
												form-name="staffCircularForm"
												friendly-name="designation"
												ng-options="option.text for option in designationList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in designationList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>

										</div>
									</div>



									<div class="form-group">
										<label class="col-md-5 control-label">Grade</label>
										<div class="col-md-2">
											<select id="grade" multiple="multiple" name="multiselect[]"
												ng-model="staffCircular.grade"
												form-name="staffCircularForm" friendly-name="gradeId"
												ng-options="option.text for option in gradeList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in gradeList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>

										</div>

									</div> -->

									

								</div>
									<div class="form-group">
									<label class="col-md-5 control-label">Tittle<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-2">
										<input type="text" id="notificationContent"
											name="notificationContent"
											class="form-control input-sm resize-none"
											validation="required" friendly-name="notificationContent"
											form-name="staffCircularForm"
											ng-model="staffCircular.title"
											maxlength="400">
														
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-5 control-label">Content<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-2">
										<textarea id="notificationContent" rows="5" cols="45"
											name="notificationContent"
											class="form-control input-sm resize-none"
											validation="required" friendly-name="notificationContent"
											form-name="staffCircularForm"
											ng-model="staffCircular.notificationContent"
											maxlength="400">
														 </textarea>
									</div>
								</div>
								<!-- 	<div class="form-group">
									<label class="col-md-5 control-label">Remarks </label>
									<div class="col-md-2">
										<textarea id="reason" rows="4" cols="35" name="remarks"
											class="form-control input-sm resize-none"
											form-name="staffCircularForm"
											 ng-model="staffCircular.remarks" maxlength="250">
										</textarea>
									</div>
								</div> -->


								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">

											<button class="btn btn-success" class="btn btn-success"
												style="" type="button"
												data-ng-click="submit(staffCircularForm)"
												data-ng-if="!edit">
												<i class="fa fa-save"></i> Save
											</button>

										<!-- 	<button class="btn btn-success" class="btn btn-success"
												style="" type="button"
												data-ng-click="submitPublish(staffCircularForm)"
												data-ng-if="!edit">
												<i class="fa fa-save"></i> Save And Send
											</button> -->
											<button class="btn btn-success" class="btn btn-success"
												style="" type="button"
												data-ng-click="update(staffCircularForm)"
												data-ng-if="edit">
												<i class="fa fa-save"></i> Update
											</button>
										<!-- 	<button class="btn btn-success" class="btn btn-success"
												style="" type="button"
												data-ng-click="updatePublish(staffCircularForm)"
												data-ng-if="edit">
												<i class="fa fa-save"></i> Update And Send
											</button> -->
											<button class="btn btn-info" type="submit"
												ng-click="reset(staffCircularForm)">
												<i class="fa fa-undo"></i> Reset
												<spring:message code="label.reset"></spring:message>
											</button>
											<button class="btn btn-danger" type="reset"
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i> Cancel
											</button>
										</div>
									</div>
								</div>
							</form>
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
</div>

