<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<!-- <div class="panel-heading panel-heading-form font-bold"> -->
		<div class="panel panel-default panel-default-form ">
			<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		<div role="content">
						<form class="form-horizontal" name="leaveDeclarationAddForm"
							role="form" method="post" novalidate>
							<div class="widget-body no-padding">


								<!-- <div class="widget-body"> -->

								<!-- <div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">

										<fieldset>
								
											
											 <div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-6 control-label">Organization Name<span style="color:red;">*</span>
													</label>
													<div class="col-md-4">
													
														 <selectivity list="companyList"
															property="leaveDeclareObj.companyId" id="companyId"
															ng-model="leaveDeclareObj.companyId"  name="companyId" ng-disabled="checked"
															form-name="leaveDeclarationAddForm" 
															friendly-name="companyName"
															></selectivity>
														
														
													</div>
												</div>
											</div> 
											 <div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-3 control-label">Grade<span style="color:red;">*</span>
													</label>
													<div class="col-md-4">
													
														 <selectivity list="gradeList"
															property="leaveDeclareObj.gradeId" id="gradeId"
															ng-model="leaveDeclareObj.gradeId" ng-change="change(leaveDeclareObj)"  name="gradeId" ng-disabled="checked"
															form-name="leaveDeclarationAddForm" 
															friendly-name="Grade"
															></selectivity>
														
														
													</div>
												</div>
											</div> 
											<div class="col-sm-6 col-md-6 col-lg-6">
									<div class="form-group ">
									<label class="col-md-3 control-label">Branch <span
										style="color: red;">*</span></label>
									<div class="col-md-4">
										<selectivity list="branchList"
											property="leaveDeclareObj.branchCode" id="branchCode"
											ng-model="leaveDeclareObj.branchCode" ng-change="change(leaveDeclareObj)" 
											friendly-name="Branch Name" name="Branch Name"
											form-name="frmProfile" validation="required"></selectivity>

									</div>
								</div>
								</div>

										</fieldset>
									</div>
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-6 control-label">Years<span style="color:red;">*</span>
												</label>
												<div class="col-md-4">
													<select class="form-control input-sm"
														ng-model="leaveDeclareObj.year" ng-disabled="checked"
														ng-change="change(leaveDeclareObj)" name="Year"
														data-message-id="year" validation="required"
														friendly-name="Years">

														<option value="">--Select--</option>
														<option value="2020">2020</option>
														<option value="2019">2019</option>
														<option value="2018">2018</option>
														<option value="2017">2017</option>
														<option value="2016">2016</option>
														<option value="2015">2015</option>
														<option value="2014">2014</option>
														<option value="2013">2013</option>
														<option value="2012">2012</option>
													</select>
												</div>
											</div>
										</div>
										
									</div>

								</div> -->
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">

										<fieldset>
							
											
											 <div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-6 control-label">Organization Name<span style="color:red;">*</span>
													</label>
													<div class="col-md-4">
													
														 <selectivity list="companyList"
															property="leaveDeclareObj.companyName" id="companyName"
															ng-model="leaveDeclareObj.companyName"  name="companyName" ng-disabled="checked"
															form-name="leaveDeclarationAddForm" 
															friendly-name="Grade"
															></selectivity>
														
														
													</div>
												</div>
											</div> 
											 <!-- <div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-3 control-label">Grade
													</label>
													<div class="col-md-4">
													
														 <selectivity list="gradeList"
															property="leaveDeclareObj.gradeId" id="gradeId"
															ng-model="leaveDeclareObj.gradeId" ng-change="change(leaveDeclareObj)"  name="gradeId" ng-disabled="checked"
															form-name="leaveDeclarationAddForm" 
															friendly-name="Grade"
															></selectivity>
														
														
													</div>
												</div>
											</div>  -->
											<div class="col-sm-6 col-md-6 col-lg-6">
									<div class="form-group ">
									<label class="col-md-3 control-label">Branch <span
										style="color: red;">*</span></label>
									<div class="col-md-4">
										<selectivity list="branchList"
											property="leaveDeclareObj.branch"
											ng-model="leaveDeclareObj.branch" ng-change="change(leaveDeclareObj)" 
											friendly-name="Branch Name" name="Branch Name"
											form-name="frmProfile" validation="required"></selectivity>

									</div>
								</div>
								</div>

										</fieldset>
									</div>
									
									
										<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">

										<fieldset>
							
											
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-6 control-label">Year<span style="color:red;">*</span>
												</label>
												<div class="col-md-4">
													<select class="form-control input-sm"
														ng-model="leaveDeclareObj.year" ng-disabled="checked"
														ng-change="change(leaveDeclareObj)" name="Year"
														data-message-id="year" validation="required"
														friendly-name="Years">

														<option value="">--Select--</option>
														<option value="2020">2020</option>
														<option value="2019">2019</option>
														
													</select>
												</div>
											</div>
										</div>
										
									
										

										</fieldset>
									</div>
									

								</div>

								<!--  </div> -->
								<div class="table-responsive" style="border: 0px solid Red">
									<table class="table table-striped b-t b-light">
										<thead>
											<tr>

												<th colspan=1 class="width_13 text-center">Leave Type</th>
												<th colspan=1 class=" width_10 text-center">Quarterly Maximum</th>
												<th colspan=1 class="width_10 text-center">Yearly Maximum</th>



											</tr>
										</thead>
										<tr ng-repeat="row in gradeTypeList">
											<td style="text-align: center"><input type="text"
												ng-model="row.leaveType" readonly /></td>
											<td style="text-align: center"><input type="text"
												ng-model="row.leavemonth" ng-pattern-restrict="{{numExp}}"
												validation="numeric|required"
												friendly-name="QuarterlyMaximum" name="QuarterlyMaximum"
												form-name="leaveDeclarationAddForm" /></td>
											<td style="text-align: center"><input type="text"
												ng-model="row.leaveyear" ng-pattern-restrict="{{numExp}}"
												validation="numeric|required" friendly-name="yearlyMaximum"
												name="yearlyMaximum" form-name="leaveDeclarationAddForm" />
											</td>

										</tr>

									</table>

								</div>


								<div class="form-actions">
									<div class="row">
										<div class="col-md-12" id="NoView">
										<button class="btn btn-success" type="button"
												data-ng-click="save(leaveDeclareObj,leaveDeclarationAddForm)"
												data-ng-if="!leaveDeclareObj.isEdit">
												<i class="fa fa-save"></i>
Save											</button>
											<button class="btn btn-success" type="button"
												data-ng-click="update(leaveDeclareObj,leaveDeclarationAddForm);"
												data-ng-if="leaveDeclareObj.isEdit">
												<i class="fa fa-save"></i>
Update											</button>
											<button class="btn btn-info ng-scope" type="submit"
												class="btn btn-success"
												ng-click="reset(leaveDeclarationAddForm)">
												<i class="fa fa-undo"></i>
Reset											</button>
										
										
										
										
										
										<button class="btn btn-danger" type="button"
												class="btn btn-success" data-ng-click="cancel()">
												<i class="fa fa-close"></i>
												Cancel
											</button>
										</div>


									</div>
								</div>

							</div>
							</div>
						</form>
					</div>
						</form>
					</div>
	</div>
</div>

