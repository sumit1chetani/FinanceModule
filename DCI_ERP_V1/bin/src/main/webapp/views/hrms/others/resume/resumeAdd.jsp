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
							<form class="form-horizontal" name="resumeForm" id="resumeForm"
								novalidate>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="panel-body col-md-6 col-md-offset-3">
											<fieldset>
												<div class="form-group">
													<label class="col-md-4 control-label">Name <span
														style="color: red;">*</span></label>
													<div class="col-md-4">
														<input type="text" class="form-control input-sm"
															name="resumeName" id="resumeName" validation="required"
															maxlength="50" friendly-name="Name"
															ng-model="resume.name"
															ng-pattern-restrict="^[a-zA-Z.']*$" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Email <span
														style="color: red;">*</span></label>
													<div class="col-md-4">
														<input type="text" class="form-control input-sm"
															name="emailId" validation="required"
															friendly-name="Email" id="emailId" maxlength="100"
															ng-model="resume.email" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Skill Set <span
														style="color: red;">*</span></label>
													<div class="col-md-4">
														<input type="text" class="form-control input-sm"
															name="skillset" validation="required"
															friendly-name="SkillSet" id="skillset" maxlength="200"
															ng-model="resume.skillset" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Years Of Exp
														<span style="color: red;">*</span>
													</label>
													<div class="col-md-4">

														<input type="text"
															class="form-control input-sm text-right" name="yrexp"
															validation="required" maxlength="2"
															ng-pattern-restrict="^[0-9a-zA-Z.]*$"
															friendly-name="Years Of Exp" id="yrexp"
															ng-change="checkYrExp(resume.yrexp)"
															ng-model="resume.yrexp" />
													</div>
													<span class="pull-left line-height-30">Years</span>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Upload Resume
														<span style="color: red;">*</span>
													</label></label>
													<div class="col-md-4 inputGroupContainer">
														<div class="input-group">
															<div id="image-holder"></div>
															<input type="file" class="form-control"
																name="uploadPhoto" ng-model="resume.uploadPhoto"
																id="uploadPhoto" validation="required"
																friendly-name="Upload Photo"
																onchange="angular.element(this).scope().uploadFile(this)"
																accept=".docx,.xls,.png,.jpg,.pdf" /> <br>
														</div>
														<br>
														<button class="btn btn" type="button"
															ng-click="uploadProfile()">Upload</button>
													</div>
												</div>

											</fieldset>
										</div>

									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												class="btn btn-success" ng-click="update(resumeForm,resume)"
												ng-if="isEdit">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-success" type="submit"
												class="btn btn-success" ng-click="save()" ng-if="!isEdit">
												<i class="fa fa-save"></i> Save
											</button>

											<button class="btn btn-info ng-scope" type="submit"
												class="btn btn-success" ng-click="reset()">
												<i class="fa fa-undo"></i> Reset
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