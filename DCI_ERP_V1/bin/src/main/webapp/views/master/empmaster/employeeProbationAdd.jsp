<style>
.ngdialog-content {
	width: 75% !important;
	bottom: 105px !important;
}
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div class="panel panel-default panel-default-form">
					<%@include file="/views/templates/panel-header-form.jsp"%>
					<div class="panel-body">
						<div class="widget-body">
							<form class="form-horizontal" name="frmProbation" novalidate
								method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<!--   <fieldset> -->
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-4 control-label">From<span
													style="color: red;">*</span></label>
												<div class="col-md-5">
													<ng-bs3-datepicker
														data-ng-model="EmployeeMasterDataProbation.frmProbation"
														id="Probation From" name=" Probation From "
														form-name="toForm" friendly-name="Probation From" />

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Extend<span
													style="color: red;">*</span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="extend" data-message-id="extend"
														validation="required" friendly-name="Extend"
														ng-model="EmployeeMasterDataProbation.extend">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label"> Break if any
												</label>
												<div class="col-md-5">
													<div class="checkbox">
														<label> <input type="checkbox"
															class="checkbox style-0"
															ng-model="EmployeeMasterDataProbation.breakAny"
															name="break"> <span></span>
														</label>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-4 control-label">To<span
													style="color: red;">*</span></label>
												<div class="col-md-5">
													<ng-bs3-datepicker
														data-ng-model="EmployeeMasterDataProbation.toProbation"
														id="Probation To" name=" Probation To " form-name="toForm"
														friendly-name="Probation To" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Duration <span
													style="color: red;">*</span></label>

												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="duration" data-message-id="duration"
														validation="required" friendly-name="Duration"
														ng-model="EmployeeMasterDataProbation.duration">
												</div>
											</div>
										</div>
										<!--     </fieldset> -->
									</div>
									<div class="col-sm-12 col-md-12 col-lg-12"
										ng-if="EmployeeMasterDataProbation.breakAny">
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-4 control-label">From</label>
												<div class="col-md-6">
													<div class='input-group date datetimepick'>
														<div class="dropdown" style="margin-top: -18px;">
															<a class="dropdown-toggle" id="frmBreakPro" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="From"
																		data-message-id="From"
																		data-ng-model="EmployeeMasterDataProbation.frmBreakPro"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>

															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="EmployeeMasterDataProbation.frmBreakPro"
																	data-on-set-time="EmployeeMasterDataProbation.frmBreakPro = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#frmBreakPro',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-4 control-label">To</label>
												<div class="col-md-6">
													<div class='input-group date datetimepick'>
														<div class="dropdown" style="margin-top: -18px;">
															<a class="dropdown-toggle" id="toBreakPro" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="To"
																		data-message-id="To"
																		data-ng-model="EmployeeMasterDataProbation.toBreakPro"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>

															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="EmployeeMasterDataProbation.toBreakPro"
																	data-on-set-time="EmployeeMasterDataProbation.toBreakPro = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#toBreakPro',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-4 control-label">Duration</label>

												<div class="col-md-5 inputGroupContainer"
													style="padding-top: 7px;">
													<input type="text" class="form-control input-sm"
														name="duration" data-message-id="duration"
														ng-model="EmployeeMasterDataProbation.breakDuration">
												</div>
											</div>
										</div>
									</div>
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-4 control-label">Completion Of
													Probation </label>

												<div class="col-md-5">
													<div class='input-group date datetimepick'>
														<div class="dropdown" style="margin-top: -18px;">
															<a class="dropdown-toggle" id="completion" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="completion"
																		data-message-id="completion"
																		data-ng-model="EmployeeMasterDataProbation.completion"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>

															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="EmployeeMasterDataProbation.completion"
																	data-on-set-time="EmployeeMasterDataProbation.completion = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#completion',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button"
											data-ng-click="validateProbation(EmployeeMasterDataProbation,frmProbation)"
											data-ng-if="!isEdit">
											<i class="fa fa-save"></i> Save
										</button>
										<button class="btn btn-success" type="button"
											data-ng-click="validateProbation(EmployeeMasterDataProbation,frmProbation);"
											data-ng-if="isEdit == true">
											<i class="fa fa-save"></i> Update
										</button>
										<button class="btn btn-danger" type="button"
											data-ng-click="cancelEmployeeProbation();">
											<i class="fa fa-close"></i>
										</button>
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

