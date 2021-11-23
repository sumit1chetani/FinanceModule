<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" name="profitLossSearchForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> Company <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="companyList" property="cashflow.company"
											id="company" object="companyCode"></selectivity>
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
										<div class="input-group input-append date"
											id="cashflow_fromDate">
											<input type="text" class="form-control input-sm"
												placeholder="dd/mm/yyyy" ng-model="pl.fromDate"
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
										<div class="input-group input-append date"
											id="cashflow_toDate">
											<input type="text" class="form-control input-sm"
												placeholder="dd/mm/yyyy" ng-model="pl.toDate" name="toDate"
												id="toDate"> <span class="input-group-addon add-on">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
							</fieldset>
						</div>
					</div>
				</div>
				<a id="PLExport" stype="display:none"
					href="filePath/ProfitAndLoss.xls" download="ProfitAndLoss.xls"></a>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<security:authorize access="hasRole('${form_code}_${view}')">
								<button class="btn btn-success" ng-click="viewProfitLoss()">
									<i class="fa fa-search"></i>View Report
								</button>
							</security:authorize>
							<security:authorize access="hasRole('${form_code}_${export}')">
								<button class="btn btn-primary" ng-click="exportPLExcel()">
									<i class="fa fa-search"></i>Export Excel
								</button>
							</security:authorize>
							<button class="btn btn-info" type="reset" class="btn btn-success">
								<i class="fa fa-undo"></i>Reset
							</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
						<table class="table table-striped">
							<tr>
								<td colspan=3>
									<h2>
										<b>Consolidated Cash Flow Statement</b>
									</h2>
								<td>
							</tr>
							<tr>
								<td>Particulars
								<td>
								<td>{{currYear}}
								<td>
								<td>{{prevYear}}
								<td>
							</tr>


							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>

							<tr>
								<td colspan=3>
									<h2>
										<b>OPERATING ACTIVITIES:</b>
									</h2>
								<td>
							</tr>
							<tr>
								<td>Profit for the Year</td>
								<td></td>
								<td></td>
							</tr>


							<tr>
								<td>Adjustements for:</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>~ Depreciation on Vessels and Equipment</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>~ Depreciation on Investment properties</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>~ Provision for Employees' end of service benefit</td>
								<td></td>
								<td></td>
							</tr>
							
							
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>



