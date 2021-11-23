<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<style>
.dropdown-menu>li>a {
	padding: 5px 36px;
}

.form-control {
	border: 1px solid #DDD;
	border-radius: 7px;
	box-shadow: none;
	height: 42px;
	padding: 8px 12px 9px 12px;
}
</style>
<security:authentication var="user" property="principal" />

		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="trialBalanceForm" class="form-horizontal">
						<div class="row">
							<%-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<input type="hidden" id="companyCode"
											value="${user.companyCode}"> <label
											class="col-md-5 control-label"> Company <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											 <selectivity list="companyList" property="tdsReport.companyCode" id="companyCode" object="companyCode"></selectivity> 

										</div>
									</div>
								</fieldset>
							</div> --%>


							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">From
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="gl_fromDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="tdsReport.fromDate"
													name="fromDate" id="fromDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">To
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="gl_toDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="tdsReport.toDate"
													name="toDate" id="toDate"> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
								</fieldset>
							</div>

							<!-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Group Code </label>
										<div class="col-md-7">
											<select id="txtGroupCode" multiple="multiple"
												name="multiselect[]" ng-model="tdsReport.objGroupCodes"
												ng-options="option.text for option in groupHeadList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in companyList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>
										</div>
									</div>
								</fieldset>
							</div> -->


							<!-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Sub group </label>
										<div class="col-md-7">
											<selectivity list="subGroupList"
												property="tdsReport.subGroupCode" id="subGroupCode"
												object="subGroupCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div> -->

							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Main Account </label>
										<div class="col-md-7">
											<!-- <selectivity list="accountHeadList"
												property="tdsReport.mainAccountCode"
												id="accountHeadCode" object="accountHeadCode"></selectivity> -->
												<input name="mainaccount" size="25" readonly value="&nbsp;&nbsp;&nbsp;20020023 - Withholding Tax" style="height:40px; width:200px;">
										</div>
									</div>
								</fieldset>
							</div><br><br><br>

							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Customer </label>
										<div class="col-md-7">
											<selectivity list="subAccountCodeList"
												property="tdsReport.subAccountCode" id="subAccountCode"
												object="subAccountCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
						<!-- <a id="GLExport" stype="display:none"
							href="filePath/TdsReport.xlsx" download="TdsReport.xlsx"></a> -->
						<!-- Form Action -->
						<div class="form-actions">
							<div class="row">
								<div class="col-md-12 ">
									<%-- <security:authorize access="hasRole('${form_code}_${view}')"> --%>
										<button class="btn btn-success"
											ng-click="viewTdsReportReport()">
											<i class="fa fa-search"></i>View Report
										</button>
									<%-- </security:authorize> --%>

									<%-- <security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											ng-click="exportTdsReportExcelOP()">
											<i class="fa fa-search"></i>Export Excel
										</button>
									</security:authorize>

									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											ng-click="exportTdsReportExcel()">
											<i class="fa fa-search"></i>Export Excel By Account Head
										</button>
									</security:authorize>

									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											ng-click="exportTransactionLevelExcel()">
											<i class="fa fa-search"></i>Export Excel OP with Transaction
										</button>
									</security:authorize> --%>

									<button class="btn btn-info" type="reset"
										class="btn btn-success" ng-click="formreset()">
										<i class="fa fa-undo"></i>Reset
									</button>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-12">
								<div id="jqgrid">
									<table id="tdsReportGrid"></table>
									<div id="tdsReportPage"></div>
								</div>
							</div>
						</div>


					</form>
				</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel-default -->
			<br> <br> <br> <br> <br> <br> <br>
			<br>
			<br> <br> <br> <br> <br> <br> <br>
			<br>
		</div>

	