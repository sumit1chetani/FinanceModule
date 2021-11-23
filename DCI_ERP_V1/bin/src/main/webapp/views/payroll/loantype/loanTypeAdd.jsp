
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list">
		<%-- <%@include file="/views/templates/panel-header-form.jsp"%>  --%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<form name="loantypeMasterForm" method="post" class="form-horizontal"
			novalidate>

			<div class="panel-body">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12"
						style="position: center;">
						<fieldset>
						<br>
							<div class="form-group">
								<label class="col-md-6">Loan Type Id <span
									style="color: red; '">*</span> <%--  <spring:message code="label.loantype.loanTypeId"></spring:message> 
         <spring:message code="label.asterisk.symbol"></spring:message> --%>
								</label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm"
										ng-if="!loanMaster.isEdit" name="loanId"
										ng-model="loanMaster.loanTypeId" maxlength="5"
										validation="required" friendly-name="LoanId"> <input
										type="text" class="form-control input-sm"
										ng-if="loanMaster.isEdit" name="loanId"
										ng-model="loanMaster.loanTypeId" maxlength="5"
										validation="required" friendly-name="loanId" readonly>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 "> Loan Type </label>
								<div class="col-md-6">
									<input type="text" class="form-control input-sm"
										name="loanName" ng-model="loanMaster.loanTypeName"
										validation="required" friendly-name="Loan Name" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 ">Flat / Diminishing</label>
								<div class="col-md-6">
									<selectivity list="flatOrDiminishing"
										property="loanMaster.flatId" id="flatId"
										ng-model="loanMaster.flatId" name="flatId"
										form-name="loantypeMasterForm" validation="required"
										friendly-name="Flat/Diminishing"> </selectivity>
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-6 ">Interest Rate </label>
								<div class="col-md-6">
									<input type="number" class="form-control input-sm"
										name="interestRate" ng-model="loanMaster.interestRate" min="0"
										validation="required" friendly-name="Interest Rate"
										ng-min="loanMaster.interestRate" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Active </label>
								<div class="col-md-6">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0" ng-model="loanMaster.status">
											<span></span>
										</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
			</div>
		</form>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-12 ">

					<button class="btn btn-success" type="button"
						ng-if="!loanMaster.isEdit" ng-click="save(loantypeMasterForm)"
						class="btn btn-success">
						<i class="fa fa-save"></i> Save
					</button>
					<button class="btn btn-success" type="button"
						ng-if="loanMaster.isEdit" class="btn btn-success"
						ng-click="update(loantypeMasterForm)">
						<i class="fa fa-save"></i> Update
					</button>
					<button type="reset" class="btn btn-info"
						ng-click="reset(loantypeMasterForm)" ng-if="!loanMaster.isEdit">
						<i class="fa fa-undo"></i> Reset
					</button>
					<button class="btn btn-danger" type="reset" class="btn btn-success"
						ng-click="cancel()">
						<i class="fa fa-close"></i> Cancel
					</button>


				</div>
			</div>
			<div class="form-actions">
				<div class="row"></div>
			</div>
			<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
			<br /> <br /> <br /> <br /> <br /> <br /> <br />
		</div>
	</div>

	</form>
</div>
</div>