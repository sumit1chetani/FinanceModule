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
						           					<label class="col-md-12 control-label">{{reimbursementApproval.companyName}}
													 
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{reimbursementApproval.departmentName}}
													
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Reimbursement Type
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{reimbursementApproval.reimbusementName}}
													
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Currency
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{reimbursementApproval.currencyName}}
													
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Remarks
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
												<label class="col-md-12 control-label"> {{reimbursementApproval.description}}</label>
						           				</div>
											</div>
										
											
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{reimbursementApproval.branchName}}
													
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Name
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{reimbursementApproval.employeeName}}
													
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">PaymentMode
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{reimbursementApproval.paymentMode}}
													
												</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Amount
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{reimbursementApproval.amount}}
													 
													</label>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Status
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<label class="col-md-12 control-label"> {{reimbursementApproval.status}}</label>
												</div>
										</div>
											
										</div>
								</div>
								</fieldset> 
								</div>
								
							<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
									   <button class="btn btn-success"  type="button" class="btn btn-success" ng-click="cancel()">
				          					Ok
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