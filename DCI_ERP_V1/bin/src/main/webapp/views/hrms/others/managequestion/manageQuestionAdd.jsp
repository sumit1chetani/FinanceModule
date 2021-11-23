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
							<form class="form-horizontal" name="QuestionMasterForm">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="panel-body col-md-6 col-md-offset-3">
											<fieldset>
												<div class="form-group">
													<label class="col-md-4 control-label">Question ID <span
														style="color: red;">*</span></label>
													<div class="col-md-4">
														<input type="text" class="form-control input-sm"
															name="question_id" validation="required"
															friendly-name="Question ID"
															form-name="QuestionMasterForm"
															ng-model="question.question_id" readonly>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label">Question
														Description <span style="color: red;">*</span>
													</label>
													<div class="col-md-4">
														<textarea id="reason" rows="3" cols="35"
															name="question_desc" class="form-control input-sm"
															style="resize: none" validation="required"
															friendly-name="Question Description"
															form-name="QuestionMasterForm"
															ng-model="question.question_desc">
														 </textarea>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">Active<span
														style="color: red;">*</span></label>
													<div class="col-md-1">
														<div class="checkbox">
															<label> <input class="checkbox style-0"
																type="checkbox" name="Active" ng-model="question.status"
																form-name="QuestionMasterForm"> <span></span></label>
														</div>
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
												class="btn btn-success"
												ng-click="submit(QuestionMasterForm,question)" ng-if="questionObj.edit">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-success" type="button"
												class="btn btn-success" ng-click="submit(QuestionMasterForm,question)"
												ng-if="!questionObj.edit">
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