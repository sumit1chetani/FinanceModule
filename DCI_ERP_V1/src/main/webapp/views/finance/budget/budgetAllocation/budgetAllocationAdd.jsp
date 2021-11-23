<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}
</style>
<security:authentication var="user" property="principal" />

		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="budgetAllocationForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<div class="col-sm-12">
								<div class="col-sm-6">

									<div class="form-group">
										<label class="col-md-4 control-label  vessel-text">Company
											Name <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="companyList" property="budgetData.companyCode"
												id="companyCode"></selectivity>
										</div>
									</div>

									<div class="form-group " ng-if="!edit">
										<label class="col-md-4 control-label">Budget Type<span
											style="color: red;"> *</span></label>
										<div class="col-md-7">
											<selectivity list="expenseList"
												property="budgetData.expense_type" name = "cmbAccountName"
												ng-model="budgetData.expense_type" id="cmbAccountName"
												validation="required" friendly-name="Expenses"></selectivity>
										</div>
									</div>
									<div class="form-group " ng-if="edit">
										<label class="col-md-4 control-label">Budget Type<span
											style="color: red;"> *</span></label>
										<div class="col-md-7">
											<input type="text" ng-model="budgetData.expense_type" class="form-control input-sm"
												readonly />
										</div>
									</div>








								</div>
								<div class="col-sm-6">


									<div class="form-group">
										<label class="col-md-4 control-label"> Financial Year
											<span
											style="color: red;"> *</span>
										</label>
										<div class="col-md-7">
											<selectivity list="finYearList" name="finTxt"
												property="budgetData.financial_year" id="hospital"
												ng-model="budgetData.financial_year"
												form-name="budgetAllocationForm" validation="required"
												friendly-name="Financial Year"></selectivity>
										</div>
									</div>


									<div class="form-group">
										<label class="col-md-4 control-label"> Status <span
											style="color: red;"> *</span></label>
										<div class="col-md-7">
											<selectivity list="statusList" name="statusTxt"
												property="budgetData.status" id="hospital"
												ng-model="budgetData.status"
												form-name="budgetAllocationForm" validation="required"
												friendly-name="Status"></selectivity>
										</div>
									</div>

								</div>
							</div>
						</div>
						<div class="col-sm-12"
							data-ng-if="budgetData.expense_type == 'Admin'">
							<div class="col-sm-6" id="leftDivAd"></div>
							<div class="col-sm-6" id="rightDivAd"></div>
						</div>

						<div class="col-sm-12"
							data-ng-if="budgetData.expense_type == 'Operational'">
							<div class="col-sm-6" id="leftDivOp"></div>
							<div class="col-sm-6" id="rightDivOp"></div>
						</div>
						<!-- /table-responsive -->






						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="content">
									<div class="form-actions">
										<div class="row">
											<div class="col-md-12">


												<button class="btn btn-success" type="button" ng-if="!edit"
													ng-click="validate()">
													<i class="fa fa-save"></i> Save
												</button>
												<button class="btn btn-success" type="button" ng-if="edit"
													ng-click="validate()">
													<i class="fa fa-save"></i> Update
												</button>
												<button type="button" class="btn btn-info"
													ng-click="reset()">
													<i class="fa fa-undo"></i> Reset
													<spring:message code="label.reset"></spring:message>
												</button>
												<button class="btn btn-danger" ng-click="cancel()"
													type="button">
													<i class="fa fa-close"></i> Cancel
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>

			</div>
		</div>