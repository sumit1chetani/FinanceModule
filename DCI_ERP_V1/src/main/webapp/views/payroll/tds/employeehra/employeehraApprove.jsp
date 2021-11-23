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
						<span><state-breadcrumbs></state-breadcrumbs>  </span>
					</header>
					<div role="content">
						<div class="widget-body">
							<div class="dataTables_wrapper for-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
							<form class="form-horizontal" name="reimbursememtApprovalEditForm" role="form" >
								<div class="row">
									<fieldset>
									<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label"> <spring:message
			              			code="label.company.name"></spring:message>
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label">{{employeehra.companyName}}
													 
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{employeehra.departmentName}}
													
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Month and Year
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
												<label class="col-md-12 control-label"> {{employeehra.monthYear}}</label>
						           				</div>
											</div>
										
										<div class="form-group">
												<label class="col-md-5 control-label">Status
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           				<select class="form-control" ng-model="employeehra.hraStatus">
										   				 <option value="">--Select--</option>
										   				 <option value="1">Pending</option>
										   					<option value="2">Approved</option>
										   				   <option value="3">Reject</option>
										   				   <option value="4">Closed</option>
														</select>
												</div>
										</div>
											
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{employeehra.branchName}}
													
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Name
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{employeehra.employeeName}}
													
												</label>
												</div>
											</div>
										
											<div class="form-group">
												<label class="col-md-5 control-label"> Amount Of Rent Paid
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{employeehra.rentPaid}}
													 
													</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> Document 
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
											<a
												id="tbPdfExport" stype="display:none"
												href="{{employeehra.fileName}}" download=""><button
														class="btn btn-success" type="button"
														data-ng-click="downloadfile()" style=margin-left:69%;">
														Download</button></a>
														
												</div>
											</div>
											
										</div>
								</div>
								</fieldset> 
								</div>
								
							<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
									   <button class="btn btn-success"  type="button" class="btn btn-success" ng-click="approvesubmit()">
				          					Submit
				            			</button>
				            			   <button class="btn btn-success"  type="button" class="btn btn-success" ng-click="cancel()">
				          					Cancel
				            			</button>
										</div>
									</div>
								</div>
							</form>
							</div>
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