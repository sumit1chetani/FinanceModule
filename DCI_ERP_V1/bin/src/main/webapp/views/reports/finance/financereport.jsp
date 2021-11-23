<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<head>
<style>
.main_head {
	background-color: #7E7EB8 !important;
	color: white;
	padding: 10px 15px;
	border-bottom: 1px solid transparent;
	border-radius: 2px 2px 0 0;
}

.data-table {
	margin-bottom: 7px !important;
}
</style>
</head>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" name="financeSearchForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-12 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> Company <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="companyList"
											ng-model="financereport.company"
											property="financereport.company" id="company"
											object="company" name="company"></selectivity>

										<!--  <select id="txtCompanyCode" multiple="multiple" name="multiselect[]" ng-model="companyCodes"
											 ng-options="option.id as option.text for option in companyList" data-dropdownmultiselect>    
											   <option data-ng-repeat="option in companyList" value="{{getOptionId(option)}}" 
											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
											</select> -->
									</div>
								</div>
							</fieldset>
						</div>

						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">From
										Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<div class="input-group input-append date" id="pl_fromDate">
											<input type="text" class="form-control input-sm"
												placeholder="dd/mm/yyyy" ng-model="financereport.fromDate"
												name="fromDate" id="fromDate"> <span
												class="input-group-addon add-on"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">To
										Date <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<div class="input-group input-append date" id="pl_toDate">
											<input type="text" class="form-control input-sm"
												placeholder="dd/mm/yyyy" ng-model="financereport.toDate"
												name="toDate" id="toDate"> <span
												class="input-group-addon add-on"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
							</fieldset>
						</div>

						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Financial
										Year <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="lastyearList"
											property="financereport.financeyear" id="mlo_id"
											ng-model="financereport.financeyear" name="financeyear_id"></selectivity>


									</div>
								</div>
							</fieldset>
						</div>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<div id="excel"></div>
							<security:authorize access="hasRole('${form_code}_${export}')">
								<button class="btn btn-primary" ng-click="exportPLExcel()">
									<i class="fa fa-search"></i>Export Excel
								</button>
							</security:authorize>
							<button class="btn btn-info" type="reset" class="btn btn-success">
								<i class="fa fa-undo"></i>Reset
							</button>
							<div class="excel"></div>
						</div>
					</div>
				</div>


			</form>
		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
</div>
<!-- /wrapper-md -->



