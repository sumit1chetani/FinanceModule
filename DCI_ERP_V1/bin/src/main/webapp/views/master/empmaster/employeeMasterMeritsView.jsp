<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="meritsForm" novalidate
								method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="form-group">
												<label class="col-md-4 control-label">Award Name <span
													style="color: red;">*</span></label>
												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Award Name" data-message-id="awardName"
														validation="required" friendly-name="Award Name"
														maxlength="50" disabled
														ng-model="EmployeeMasterDataMerit.awardName">
												</div>
											</div>


											<div class="form-group">
												<label class="col-md-4 control-label">Scholarship
													Name<span style="color: red;"></span>
												</label>
												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="scholarshipName" maxlength="50" disabled
														ng-model="EmployeeMasterDataMerit.scholarshipName">
												</div>
											</div>

											<div class="form-group ">
												<label class="col-md-4 control-label">Description<span
													style="color: red;"></span></label>
												<div class="col-md-5">
													<textarea ng-model="EmployeeMasterDataMerit.meritDesc"
														name="meritDesc" class="form-control input-sm resize-none"
														rows="4" disabled>
	        										 </textarea>
												</div>
											</div>
										</fieldset>
									</div>
								</div>
								
									<div class="row" align="center">
										<div class="col-md-12">
											
											<button class="btn btn-danger" type="button"
												data-ng-click="cancelEmployeeMerit();">
												<i class="fa fa-close"></i> Cancel
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
				</div>
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>

