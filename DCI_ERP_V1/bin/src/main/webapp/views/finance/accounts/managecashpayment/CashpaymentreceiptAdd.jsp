<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="accountHeadForm">
				<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>
												<div class="form-group" ng-if="isEdit">
													<label class="col-md-4 control-label"> Code
														</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															ng-model="accountHeadData.accountHeadCode" readonly>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label">
														Name <span style="color: red;">*</span>
													</label>
													<div class="col-md-7 inputGroupContainer">
														<!-- <selectivity list="subGroupHeadList"
															property="accountHeadData.subGroupAccountCode"
															id="txtSubGroup"
															ng-model="accountHeadData.subGroupAccountCode"
															name="subGrp" form-name="accountHeadForm"
															validation="required" 
															disabled = "accountHeadData.edit"
															friendly-name="Sub Group Code"></selectivity> -->
															<input type="text" class="form-control input-sm"
															name="subGrpAcctName"
															ng-model="accountHeadData.subGroupAccountCode"
															id="txtAcctName" validation="required"
															friendly-name=" Name" />
													</div>
												</div>
												<!-- div class="form-group">
													<label class="col-md-4 control-label">Account Head
														Name<span style="color: red;">*</span>
													</label>
													<div class="col-md-7">
														<input type="text" class="form-control input-sm"
															name="subGrpAcctName"
															ng-model="accountHeadData.accountHeadName"
															id="txtAcctName" validation="required"
															friendly-name="Account Head Name" />
													</div>
												</div> -->
												<!-- <div class="form-group">
													<label class="col-md-4 control-label"> Active </label>
													<div class="col-md-3">
														<div class="checkbox">
															<label class="i-checks"> <input type="checkbox"
																id="isActive" class="checkbox style-0" name="Active"
																ng-model="accountHeadData.acctHeadStatus" value="true"
																checked="checked" /> <i></i>
															</label>
														</div>
													</div>
												</div> -->
											</fieldset>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>
												<!-- <div class="form-group">
													<label class="col-md-4 control-label"> Type </label>
													<div class="col-md-7">
														<select class="form-control input-sm" name="type"
															ng-model="accountHeadData.type" validation="required"
															friendly-name="Account Head Type">
															<option value="">--Select--</option>
															<option value="A">Administrative Related</option>
															<option value="P">Operations Related</option>
															<option value="S">Staff Related</option>
															<option value="R">Student Related</option>
															<option value="O">Others</option>
														</select>
													</div>
												</div> -->







												<div class="form-group">
													<label for="inputPassword" class="control-label col-md-4">
														 Description <!-- <span style="color: red;">*</span> -->
													</label>
													<div class="col-md-7">
														<textarea ng-model="accountHeadData.description"
															name="description"
															class="custom-scroll width_100 resize-none padding-top-5 padding-left-10"
															rows="2" validation="optional"
															friendly-name="Account Head Description">
		            </textarea>
													</div>
												</div>
												<!-- <div class="form-group">
													<label for="inputPassword" class="control-label col-md-4">Currency
														<span style="color: red;"></span>
													</label>
													<div class="col-md-7">

														<selectivity list="currencyList"
															property="accountHeadData.currencyCode"
															id="txtcurrencyCode"
															ng-model="accountHeadData.currencyCode" name="currCode"
															form-name="accountHeadForm" friendly-name="Currency Code"></selectivity>
													</div>
												</div> -->
											</fieldset>
										</div>
									</div>
									<div class="col-sm-12">
										<label class="col-md-2 control-label" >Type : <span style = "color:red";>*</span></label>
										<div class="form-group">
					             		<label class="col-md-2 control-label"> </label>
							              		<div class="checkbox">
							               			
							             	</div>
							             	<label class="col-md-2 control-label"> Payment</label>
							              		<div class="checkbox">
							               			<label> 
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="accountHeadData.ispayment" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
							                			<span></span>
							               			</label>
							             	</div>
							             	<label class="col-md-2 control-label"> Receipt</label>
							              		<div class="checkbox">
							               			<label> 
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="accountHeadData.isreceipt" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
							                			<span></span>
							               			</label>
							             	</div>
							             	
							             	</div>
										
									</div>
								
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												ng-if="accountHeadData.edit==false"
												ng-click="onSubmit(accountHeadForm,accountHeadData)">
												<i class="fa fa-save"></i> Save
											</button>
											<button class="btn btn-success" type="button"
												ng-if="accountHeadData.edit==true"
												ng-click="onSubmit(accountHeadForm,accountHeadData)">
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