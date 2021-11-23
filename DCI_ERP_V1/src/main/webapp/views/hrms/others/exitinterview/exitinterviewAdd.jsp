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
th {
     text-align: center !important; 
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
													<label class="col-md-6 control-label">Organization<span
														style="color: red;">*</span><span style="color: red;"></span></label>
														<input type="hidden" value="${form_code}" id="formCode"/>
													<div class="col-md-6 inputGroupContainer">
														<selectivity list="hospitalList"
															property="exitinterview.hospitalId" id="hospitalId"
															name="hospitalId" friendly-name="Hospital Name"
															form-name="exitInterviewForm" disabled="disable"
															ng-model="exitinterview.hospitalId" validation="required">
														</selectivity>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-6 control-label">Branch <span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-6">
														<selectivity list="branchList"
															property="exitinterview.branchId" id="branchId"
															name="branchId" friendly-name="Branch Name"
															form-name="exitInterviewForm"
															ng-model="exitinterview.branchId" validation="required">
														</selectivity>
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="col-md-3 control-label">Department <span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-6">
														<selectivity list="departmentList"
															property="exitinterview.departmentId" id="departmentId"
															name="departmentId" friendly-name="Department Name"
															form-name="exitInterviewForm"
															ng-model="exitinterview.departmentId"
															validation="required"> </selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label">Employee Name<span
														style="color: red;">*</span><span style="color: red;"></span></label>
													<div class="col-md-6">
														<selectivity list="employeeList"
															property="exitinterview.employeeId" id="employeeId"
															name="employeeId" friendly-name="Employee Name"
															form-name="exitInterviewForm"
															ng-model="exitinterview.employeeId" validation="required">
														</selectivity>
													</div>
												</div>
											</div>
											<br> <br> <br>
											<table class="productsTable" width="80%" height="70%"
												cellspacing="2px;" ng-if="rowCollection.length >=1">
												<tr>
												<th  align="center">Question Description<span
														style="color: red;">*</span><span style="color: red;"></span> </th>
												<th  align="center">Answer<span
														style="color: red;">*</span><span style="color: red;"></span></th>
														</tr>
														<tbody data-ng-repeat="questions in rowCollection">
												<tr>
													<td width="50%">{{questions.questionDesc}}</td>
													<td class="ephoneFree tableHeader" width="50%"
														align="center"><textarea rows="5" cols="85" ng-model="questions.answer"></textarea></td>
												</tr>
												</tbody>
											</table>
											
										</fieldset>
									</div>
								</div>
								<br> <br> <br>
									<span ng-show="questionDetailsError" style="margin-left: 500px;">
											No Template Quesitons Available For this Employee
											</span>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" type="button"
												ng-if="!disciplinaryObj.edit" class="btn btn-success"
												data-ng-click="submit(exitInterviewForm,exitinterview)">
												<i class="fa fa-save"></i> Save
											</button>
											<button class="btn btn-success" type="button"
												ng-if="disciplinaryObj.edit" class="btn btn-success"
												data-ng-click="submit(exitInterviewForm,exitinterview)">
												<i class="fa fa-undo"></i> Update
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