<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="breadcrumb-wrapper ng-scope">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<%-- 				<jsp:useBean id="date" class="java.util.Date" />
 --%>
				<fmt:formatDate value="${date}" pattern="yyyy" var="currentYear" />
				<div class="panel-body">
					<form name="sailingsReportForm" class="form-horizontal">
						<div class="row book-widget-row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="col-sm-12 col-md-3 col-lg-3">
									<fieldset>
										<div class="form-group">
											<label class="col-md-5 control-label">Company</label>
											<div class="col-md-7">
												<selectivity list="companyList"
													property="sailingsReport.companyCode" id="companyCode"
													object="companyCode"> </selectivity>


											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">Customer</label>
											<div class="col-md-7">

												<select id="pod" multiple="multiple" name="pod"
													ng-model="deliveryorder.lpod"
													ng-options="option.text for option in podList"
													data-dropdownmultiselect>
													<option data-ng-repeat="option in podList"
														value="{{getpodId(option)}}"
														data-ng-bind-template="{{option.text}}"></option>
												</select> <select id="txtCustomerCode" multiple="multiple"
													name="multiselect[]" ng-model="sailingsReport.mlo"
													ng-options="option.text for option in mloList"
													data-dropdownmultiselect>
													<option data-ng-repeat="option in mloList"
														value="{{getOptionId(option)}}"
														ng-selected="isOptionSelected(option)"
														data-ng-bind-template="{{option.text}}"></option>
												</select>
											</div>
										</div>
									</fieldset>
								</div>
								<div class="col-sm-12 col-md-3 col-lg-3">
									<fieldset>
										<div class="form-group">
											<label class="col-md-5 control-label">Sector</label>
											<div class="col-md-7">
												<selectivity list="sectorList"
													property="sailingsReport.sectorName" id="sectorName">
												</selectivity>


											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">Top</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm width_55"
													data-ng-model="sailingsReport.top" allow-only-numbers>
											</div>
										</div>
									</fieldset>
								</div>
								<div class="col-sm-12 col-md-3 col-lg-3">
									<fieldset>
										<div class="form-group">R
											<label class="col-md-5 control-label">Vessel</label>
											<div class="col-md-7">
												<selectivity list="vesselist"
													property="sailingsReport.vessel" id="vessel">
												</selectivity>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-5 control-label">Previous Year</label>
											<div class="col-md-7 p-t-8">
												<label class="i-checks m-b-none"><input
													type="checkBox" class="form-control input-sm width_55"
													data-ng-model="sailingsReport.previousYear"> <i></i></label>
											</div>
										</div>
									</fieldset>
								</div>
								<div class="col-sm-12 col-md-3 col-lg-3">
									<fieldset>
										<div class="form-group">
											<label class="col-md-5 control-label">Voyage</label>
											<div class="col-md-7">
												<selectivity list="voyageList"
													property="sailingsReport.voyage" id="voyage">
												</selectivity>


											</div>
										</div>
									</fieldset>
									<fieldset>
										<div class="form-group">
											<label class="col-md-5 control-label">Year</label>
											<div class="col-md-7">
												<selectivity list="yearList " property="sailingsReport.year"
													id="year"> </selectivity>


											</div>
										</div>
									</fieldset>
								</div>
							</div>
							<a id="custAnalysisExport" style="display: none"
								href="filePath/Customer_Analysis_Report.xlsx"
								download="Customer_Analysis_Report.xlsx"></a>
						</div>
						<div class="form-actions ">
							<div class="row">
								<div class="col-md-12 ">
									<security:authorize access="hasRole('${form_code}_${view}')">
										<button class="btn btn-success"
											data-ng-click="viewTrialBalanceReport()">
											<i class="fa fa-search"></i>View Report
										</button>
									</security:authorize>
									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											data-ng-click="exportTBExcel()">
											<i class="fa fa-download"> </i>Export Excel
										</button>
									</security:authorize>
									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											data-ng-click="rateAgainstExcel()">
											<i class="fa fa-download"> </i> RATES AGAINST LOADING AVGS
										</button>
									</security:authorize>

									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											data-ng-click="rateJvAgainstExcel()">
											<i class="fa fa-download"> </i> RATES AND JV AGAINST LOADING
											AVGS
										</button>
									</security:authorize>


									<div class="test"></div>
									<br>
									<button class="btn btn-info" type="button"
										class="btn btn-success" data-ng-click="formreset()">
										<i class="fa fa-undo"></i>Reset
									</button>
								</div>
							</div>
						</div>
						<div class="col-md-12 pt-t-8">
							<div class="col-md-6"
								style="font-size: 14px; padding: 0; color: red;">
								<span> * On Selection of Previous year will show records
									for all the Customers. Selection criteria will be ignored.</span><br>

							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- /panel-default -->
		</div>
	</div>
</div>
<!-- /panel-body -->
<div class="wrapper-md" data-ng-if="rowCollection.length !== 0">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb padding-left-0">
				<li><a>Customer Analysis Report</a></li>
			</ol>
		</div>
		<div class="panel-body" st-table="displayedCollection"
			st-safe-src="rowCollection">
			<div class="widget-body no-padding ">
				<div class="table-responsive ">
					<table
						class="table table-striped b-t b-light table-hover dataTable no-footer ">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="width_12 text-center">Customer</th>
								<th class="width_12 text-center">TEUS - <c:out
										value="${currentYear}" /></th>
								<th data-ng-if="sailingsReport.previousYear == true"
									class="width_12 text-center">TEUS - <c:out
										value="${currentYear-1}" /></th>
								<th class="width_12 text-center">Revenue - <c:out
										value="${currentYear}" /></th>
								<th data-ng-if="sailingsReport.previousYear == true"
									class="width_12 text-center">Revenue - <c:out
										value="${currentYear-1}" /></th>
								<th class="width_12 text-center">Revenue/TEUS - <c:out
										value="${currentYear}" /></th>
								<th data-ng-if="sailingsReport.previousYear == true"
									class="width_12 text-center">Revenue/TEUS - <c:out
										value="${currentYear-1}" /></th>
							</tr>
						</thead>
						<tbody
							data-ng-repeat="objCustomerAnalysis in displayedCollection ">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
								<td data-ng-bind="objCustomerAnalysis.customer"></td>
								<td class="text-right"
									data-ng-bind="objCustomerAnalysis.teus2016"></td>
								<td data-ng-if="sailingsReport.previousYear == true"
									class="text-right" data-ng-bind="objCustomerAnalysis.teus2015"></td>
								<td class="text-right">{{ objCustomerAnalysis.rev2016 |
									number:2}}</td>
								<td data-ng-if="sailingsReport.previousYear == true"
									class="text-right">{{objCustomerAnalysis.rev2015 |
									number:2}}</td>
								<td class="text-right"
									data-ng-bind="objCustomerAnalysis.rev_per_teus2016"></td>
								<td data-ng-if="sailingsReport.previousYear == true"
									class="text-right"
									data-ng-bind="objCustomerAnalysis.rev_per_teus2015"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<footer class="panel-footer">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>
			</div>
		</div>
	</div>
</div>