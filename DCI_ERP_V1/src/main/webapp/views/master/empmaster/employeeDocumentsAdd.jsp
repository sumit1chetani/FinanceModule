<style>


.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
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
							<form class="form-horizontal" name="frmDocument" novalidate
								method="post">
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<fieldset>
										
										<div class="form-group">
												<label class="col-md-4 control-label">Document Type
												</label>
												<div class="col-md-5">
													<select class="form-control input-sm"
														ng-model="EmployeeMasterDataDoc.docType" 
														name="docType"
														data-message-id="docType" 
														friendly-name="docType">

														<option value="">--Select--</option>
														<option value="AADHAR CARD">AADHAR CARD</option>
														<option value="DEGREE CERTIFICATE">DEGREE CERTIFICATE</option>
															<option value="DRIVING LICENSE">DRIVING LICENSE</option>
														<option value="EMIRATES ID">EMIRATES ID</option>
															<option value="LABOUR CARD">LABOUR CARD</option>
														<option value="MEDICAL INSURENCE CARD">MEDICAL INSURENCE CARD</option>
															<option value="PAN CARD(INDIA)">PAN CARD(INDIA)</option>
														<option value="PORT PASS">PORT PASS</option>
														<option value="TEMPORARY/PROJECT/VISIT VISA">TEMPORARY/PROJECT/VISIT VISA</option>
															<option value="VISA">VISA</option>
														<option value="VOTERS ID">VOTERS ID</option>
														<option value="WPS NUMBER">WPS NUMBER</option>
														<option value="PASSPORT">PASSPORT</option>
														
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4 control-label">Document Number
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-5 inputGroupContainer">
													<input type="text" class="form-control input-sm"
														name="Document Name" data-message-id="docName"
														maxlength="50" validation="required"
														friendly-name="Document Name"
														ng-model="EmployeeMasterDataDoc.docName">
												</div>
											</div>
											
											<div class="form-group ">
									<label class="col-md-4 control-label">Issued Country </label>
									<div class="col-md-5">
										<selectivity list="countryList"
											property="EmployeeMasterDataDoc.issuecountry"
											ng-model="EmployeeMasterDataDoc.issuecountry"
											friendly-name="Country Name" name="Country Name"
											form-name="frmProfile" ></selectivity>

									</div>
								</div>
<div class="form-group">
									<label class="col-md-4 control-label">Issue/Signed Date</label>
									<div class="col-md-5">
										<ng-bs3-datepicker
											data-ng-model="EmployeeMasterDataDoc.issueDate"
											id="issueDate" name="Issue Date" form-name="toForm"
										friendly-name="issue Date" />
									</div> 

								</div> 
 <div class="form-group">
									<label class="col-md-4 control-label">Expiry Date</label>
									<div class="col-md-5">
										<ng-bs3-datepicker
											data-ng-model="EmployeeMasterDataDoc.expiryDate"
											id="expiryDate" name="Expiry Date" form-name="toForm"
										friendly-name="expiry Date" />
									</div> 

								</div> 
											<div class="form-group ">
												<label class="col-md-4 control-label">Comments<span
													style="color: red;"></span></label>
												<div class="col-md-5">
													<textarea ng-model="EmployeeMasterDataDoc.description"
														maxlength="200" name="Description"
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
															id="fileUpload"
															onchange="angular.element(this).scope().uploadDocument(this)" />
														<br>
													</div>
													<br>
													<button class="btn btn" type="button"
														ng-click="uploadDocumentFiles()">Upload</button>
												</div>
											</div>
										</fieldset>
									</div>
								</div>
									<div class="row" align="center">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												data-ng-click="validateDocument(EmployeeMasterDataDoc,frmDocument)"
												data-ng-if="!ispop7Edit">
												<i class="fa fa-save"></i> Save
											</button>
											<button class="btn btn-success" type="button"
												data-ng-click="validateDocument(EmployeeMasterDataDoc,frmDocument);"
												data-ng-if="ispop7Edit == true">
												<i class="fa fa-save"></i> Update
											</button>
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

