<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
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
							<!-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Company
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="companyList" property="trialBalance.companyCode" id="companyCode" object="companyCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div> -->

							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<input type="hidden" id="companyCode"
										value="${user.companyCode}">
									<div class="form-group">
										<label class="col-md-5 control-label"> Company <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="companyList" ng-model="trialBalance.companyCode" property="trialBalance.companyCode" id="companyCode" object="companyCode"  name="companyCode"></selectivity>



											<!-- <select id="txtCompanyCode" multiple="multiple"
												name="multiselect[]" ng-model="companyCodes"
												ng-options="option.id as option.text for option in companyList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in companyList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select> -->
										</div>
									</div>
								</fieldset>
							</div>


							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">From
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="tb_fromDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="trialBalance.fromDate"
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
											<div class="input-group input-append date" id="tb_toDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="trialBalance.toDate"
													name="toDate" id="toDate"> <span
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
										<label class="col-md-5 control-label"> Sub Group </label>
										<div class="col-md-7">
										
											<selectivity list="subGroupList"
												property="trialBalance.subGroupCode" id="subGroupCode"
												object="subGroupCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>
							<!-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<div class="col-md-3"></div>
										<div class="col-md-1">
											<div class="checkbox">
												<label class="i-checks"> <input type="checkbox"
													id="isActive" class="checkbox style-0" name="Active"
													ng-model="isRelatedParty" /> <i></i>
												</label>
											</div>
										</div>
										<label class="col-md-4 control-label"> Related Party </label>

									</div>
								</fieldset>
							</div> -->
						</div>



						

						<!-- Form Action -->
						<div class="form-actions">
							<div class="row">
								<div class="col-md-12 ">
									<%-- <security:authorize access="hasRole('${form_code}_${view}')" type="button"> --%>
										<button class="btn btn-success" ng-click="submit()">
											<i class="fa fa-search"> </i>View Report
										</button>
									<%-- </security:authorize> --%>
									<a id="TBExport" style="display: none"
										href="filePath/TrialBalance.xls" download="TrialBalance.xls"></a>
									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary" ng-click="exportExcel()">
											<i class="fa fa-download"> </i>Export Excel
										</button>
									</security:authorize>
									
									<a id="TrialBalanceReport" style="display: none"
										href="filePath/TrialBalanceReport.xls"
										download="TrialBalanceReport.xls"></a>
									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											ng-click="exportExcelReport()">
											<i class="fa fa-download"> </i>Export Excel(New)
										</button>
									</security:authorize>
									
									<a id="TBExportWithPlain" style="display: none"
										href="filePath/TrialBalanceWithPlain.xls"
										download="TrialBalanceWithPlain.xls"></a>
									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											ng-click="exportExcelWithPlain()">
											<i class="fa fa-download"> </i>Export Excel(Plain)
										</button>
									</security:authorize>
									<button class="btn btn-info" type="reset"
										class="btn btn-success" ng-click="formreset()">
										<i class="fa fa-undo"> </i>Reset
									</button>
								</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-12">
								<div id="jqgrid">
									<table id="trialBalanceGrid"></table>
									<div id="trialBalancePage"></div>
								</div>
							</div>
						</div>
					</form>
			
				</div> <!-- /panel-body -->
			</div> <!-- /panel-default -->
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
		</div>
	