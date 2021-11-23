<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div class="panel panel-default panel-default-form">
					<%@include file="/views/templates/panel-header-form.jsp"%>
					<div class="panel-body">
						<div class="widget-body">
							<form class="form-horizontal" name="frmDocument" novalidate
								method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
											<div class="form-group">
												<label class="col-md-4 control-label">Document Name
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Document Name" data-message-id="docName"
														maxlength="50" validation="required"
														friendly-name="Document Name" disabled
														ng-model="EmployeeMasterDataDoc.docName">
												</div>
											</div>

											<div class="form-group ">
												<label class="col-md-4 control-label">Description<span
													style="color: red;"></span></label>
												<div class="col-md-5">
													<textarea ng-model="EmployeeMasterDataDoc.description"
														maxlength="200" name="Description" disabled
														class="form-control input-sm resize-none" rows="4">
	        										 </textarea>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Upload
													Document</label>
												<div class="col-md-5 inputGroupContainer">
													<div class="input-group">
														<div id="image-holder"></div>
														<input type="file" class="form-control" name="uploadDoc"
															ng-model="EmployeeMasterDataDoc.uploadDoc"
															id="fileUpload" disabled
															onchange="angular.element(this).scope().uploadDocument(this)" />
														<br>
													</div>
													<br>
													<button class="btn btn" type="button" disabled
														ng-click="uploadDocumentFiles();">Upload</button>
												</div>
											</div>
										</fieldset>
									</div>
								</div>
									<div class="row" align="center">
										<div class="col-md-12">
											
											<button class="btn btn-danger" type="button"
												data-ng-click="cancelEmployeeDocument();">
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
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>

