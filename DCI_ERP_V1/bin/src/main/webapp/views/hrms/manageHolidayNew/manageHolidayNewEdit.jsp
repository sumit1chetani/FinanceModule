<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div role="content">
		
				<div role="content">
		
						<div class="widget-body">
							<form class="form-horizontal" name="holidayMasterForm">
								<div class="row">

									<div class="col-sm-12 col-md-10 col-lg-10">
										<fieldset>
											<div class="form-group">
												<label class="col-md-6 control-label"><%-- <spring:message
														code="label.companyName"></spring:message> --%> Organization Name <spring:message
														code="label.asterisk.symbol"></spring:message> </label>
												
												<div class="col-md-6 inputGroupContainer">
												
										               				
														 <selectivity list="companyList"
															property="holidayMaster.companyId" id="companyId"
															ng-model="holidayMaster.companyId"  name="companyId" 
															form-name="holidayMasterForm" 
															friendly-name="Hospital Name"
															></selectivity>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-md-6 control-label">Branch Name </label>
												<div class="col-md-6 inputGroupContainer">
										               <selectivity list="branchList" property="holidayMaster.branch" 
											                id="branch" ng-model="holidayMaster.branch" 
											               name="branch" form-name="holidayMasterForm"
											               validation="required" friendly-name="BranchId"
											              ></selectivity>
												</div>
											</div>

											<!-- <div class="form-group">
												<label class="col-md-6 control-label">Holiday Date
												</label>
												<div class="col-md-6">
													<div class='input-group date datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="dat"
																role="button" data-toggle="dropdown" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="Date"
																		data-validator="required" data-valid-method="submit"
																		data-message-id="Date"  name="Holiday date" validation="required" form-name="holidayMasterForm" friendly-name="Holiday Date"
																		data-ng-model="holidayMaster.date"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="holidayMaster.date" 
																	data-on-set-time="holidayMaster.date = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#dat',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div> -->
											  <div class="form-group">
								<label class="col-md-6 control-label">Holiday Date<span
									style="color: red;">*</span></label>

								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="holidayMaster.date"
										id="date" name="date" form-name="date" friendly-name="date"
										validation="required" />
								</div>
							</div>
											
											<div class="form-group">
												<label class="col-md-6 control-label"> Holiday Name
												</label>
												<div class="col-md-6 inputGroupContainer">
													<!-- <div class="checkbox"> -->

													<input type="text" class="col-md-5 form-control input-sm"
														name="Holiday Name"
														 validation="required"
														  form-name="holidayMasterForm" friendly-name="Holiday Name"
														data-ng-model="holidayMaster.holidayName"
														data-message-id="holidayName" data-validator="required"
														data-valid-method="submit"> <span></span>

													<!-- </div> -->
												</div>
											</div>

										</fieldset>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
										
											<button class="btn btn-success" type="button"
												data-ng-click="update(holidayMasterForm)"
												data-ng-if="isEdit == true">
												<i class="fa fa-save"></i>
											Update
											</button>
											<button class="btn btn-info" type="button"
												class="btn btn-success" ng-click="reset()">
												<i class="fa fa-undo"></i>
												Reset
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i>
												Cancel
											</button>
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- end widget content -->
					</div>
	</div>
	</div>
</div>
