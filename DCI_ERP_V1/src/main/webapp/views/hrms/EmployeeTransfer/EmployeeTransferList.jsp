<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
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
							<form class="form-horizontal" name="employeeTransferAddForm" novalidate>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>
												<center>
													<b>Source Details</b>
												</center>
												<br>
												<div class="form-group">
													<label class="col-md-4 control-label"> Employee
														Name 
													</label>
													<div class="col-md-6">
														<selectivity list="employeeList"
															property="employeeTransferobj.employeeId"
															id="employeeId"
															ng-model="employeeTransferobj.employeeId"
															name="employeeId" form-name="employeeTransferAddForm"
															validation="required" friendly-name="Employee Name">
														</selectivity>
														<input type="hidden" ng-model="employeeTransferobj.employmentDate" class="form-control journalVoucher-textBox" />
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Company
														Name 
													</label>
													<div class="col-md-6">
														<input type="text" class="form-control"
															name="companyName"
															ng-model="employeeTransferobj.companyName" readonly>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Branch Name
													</label>
													<div class="col-md-6">
													<input type="text" class="form-control"
															name="branchName"
															ng-model="employeeTransferobj.branchName" readonly>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Department
														Name 
													</label>
													<div class="col-md-6">
													<input type="text" class="form-control"
															name="departmentName"
															ng-model="employeeTransferobj.departmentName" readonly>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Transfer Current Charges
													</label>
													<div class="col-md-6">
														<selectivity list="employeeChargesList"
															property="employeeTransferobj.chargeemployeeId" id="chargeemployeeId"
															ng-model="employeeTransferobj.chargeemployeeId"
															name="chargeemployeeId" form-name="employeeTransferAddForm"
															validation="required" object="transferEmployee"
															friendly-name="TransferCurrent Charges"></selectivity>
													</div>
												</div>
											</fieldset>
										</div>

										<div class="col-sm-6 col-md-6 col-lg-6">
											<fieldset>
												<center>
													<b>Transfer Details</b>
												</center>
												<br>
												<div class="form-group">
													<label class="col-md-4 control-label"> Branch Name
													</label>
													<div class="col-md-6">
														<selectivity list="branchList"
															property="employeeTransferobj.branchId"
															id="branchId" object="branch"
															ng-model="employeeTransferobj.branchId"
															name="branchId" form-name="employeeTransferAddForm"
															validation="required" friendly-name="Branch Name"></selectivity>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Department
														Name 
													</label>
													<div class="col-md-6">
														<selectivity list="departmentList"
															property="employeeTransferobj.departmentId"
															id="departmentId" object="department"
															ng-model="employeeTransferobj.departmentId"
															name="departmentId" form-name="employeeTransferAddForm"
															validation="required" friendly-name="Department Name"></selectivity>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Designation
													</label>
													<div class="col-md-6">
														<selectivity list="designationList"
															property="employeeTransferobj.designationId"
															id="designationId" object="designation"
															ng-model="employeeTransferobj.designationId"
															name="designationId" form-name="employeeTransferAddForm"
															validation="required" friendly-name="Designation Name"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Division </label>
													<div class="col-md-6">
														<selectivity list="divisionList"
															property="employeeTransferobj.divisionId"
															id="divisionId" object="division"
															ng-model="employeeTransferobj.divisionId"
															name="divisionId" form-name="employeeTransferAddForm"
															validation="required" friendly-name="Division Name"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Grade </label>
													<div class="col-md-6">
														<selectivity list="gradeList"
															property="employeeTransferobj.gradeId"
															id="gradeId" object="grade"
															ng-model="employeeTransferobj.gradeId"
															name="gradeId" form-name="employeeTransferAddForm"
															validation="required" friendly-name="Grade Name"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label"> Reporting
														Authority 
													</label>
													<div class="col-md-6">
														<selectivity list="reportToManagerLists"
															property="employeeTransferobj.reportMangrId"
															id="reportMangrId" object="reportingAuthority"
															ng-model="employeeTransferobj.reportMangrId"
															name="reportMangrId" form-name="employeeTransferAddForm"
															validation="required" friendly-name="Reporting Authority"></selectivity>
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-4 control-label"> Report To Designation </label>
													<div class="col-md-6">
														<selectivity list="reportToDesigList" property="employeeTransferobj.reportDesigId"
															id="reportDesigId" object="reportDesignation"
															ng-model="employeeTransferobj.reportDesigId"
															name="reportDesigId" form-name="employeeTransferAddForm" validation="required"
															friendly-name="Reporting Designation"></selectivity>
													</div>
												</div>
											</fieldset>
										</div>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success"
												ng-if="!shiftReAllocationValidateData.isEdit" type="button"
												ng-click="saveTransfer(employeeTransferAddForm,employeeTransferobj)">
												<i class="fa fa-save"></i> Save
											</button>
											<button class="btn btn-success"
												ng-if="shiftReAllocationValidateData.isEdit" type="button"
												ng-click="save(shiftReAllocationAddForm, shiftReAllocationobj,shiftReAllocationValidateData)">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-info ng-scope" type="button"
												ng-click="reset()" class="btn btn-success">
												<i class="fa fa-undo"></i> Reset
											</button>
											<button class="btn btn-danger" type="button"
												ng-click="cancel()" class="btn btn-success">
												<i class="fa fa-close"></i> Cancel
											</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>