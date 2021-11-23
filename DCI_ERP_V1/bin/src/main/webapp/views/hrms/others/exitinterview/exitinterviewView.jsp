<!-- #MAIN CONTENT -->
<style>

table.productsTable {
    border-width: 1px;
    border-spacing: 2px;
    border-style: outset;
    border-color: gray;
    border-collapse: separate;
    background-color: white;
    margin-left: 138px;
    height: 90px;
}

table.productsTable td {
    border-width: 1px;
    padding: 1px;
    border-style: inset;
    border-color: gray;
    background-color: white;
    -moz-border-radius: ;
}

</style>
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
						</span> <span><state-breadcrumbs></state-breadcrumbs></span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="exitInterviewForm"
								role="form" ng-submit="#" novalidate>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">

										<fieldset>
											<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-6 control-label"><spring:message
			              			code="label.company.name"></spring:message> <span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-4">
														<selectivity
															property="exitinterview.company_name" id="company_name"
															name="company_name"
															form-name="exitInterviewForm"
															ng-model="exitinterview.company_name" readonly>
														</selectivity>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-6 control-label">Branch <span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-4">
														<selectivity 
															property="exitinterview.branch_name" id="branch_name"
															name="branch_name"
															ng-model="exitinterview.branch_name">
														</selectivity>
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-3 control-label">Department <span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-4">
														<selectivity
															property="exitinterview.department_name" id="department_name"
															name="department_name"
															ng-model="exitinterview.department_name"
															> </selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Employee Name<span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-4">
														<selectivity
															property="exitinterview.employee_name" id="employee_name"
															name="employee_name"
															form-name="exitInterviewForm"
															ng-model="exitinterview.employee_name">
														</selectivity>
													</div>
												</div>
											</div>
											<br> <br> <br>
											<table class="productsTable" width="80%" height="70%"
												cellspacing="2px;" data-ng-repeat="exitinterview in rowCollection">
												<tr>
													<td width="50%">{{exitinterview.questionDesc}}</td>
													<td class="ephoneFree tableHeader" width="50%"
														align="center"><textarea rows="5" cols="85" ng-model="exitinterview.answer" readonly></textarea></td>
												</tr>
											</table>
											
										</fieldset>
									</div>
								</div>
								<br> <br> <br>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-danger" type="button"
												class="btn btn-success" ng-click="exitinterviewcancel()">
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