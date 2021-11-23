<style>
.table>tbody+tbody {
	border-top: none;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">

		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">

			<form class="form-horizontal" novalidate
				name="customerAnalysisReportForm">

				<div class="row book-widget-row">
					<div class="col-sm-12">
						<div class="col-sm-12">
							<div class="form-group">
								<label class="col-md-5 control-label">Company<span
									style="color: red;">*</span></label>
								<div class="col-md-3" style="height: 10px;">

									<select id="company" multiple="multiple" name="company"
										ng-model="customerAnalysis.company"
										ng-options="option.text for option in companyList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in companyList"
											value="{{getcustomer(option)}}"
											data-ng-bind-template="{{option.text}}"></option>
									</select>



								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">

							<button class="btn btn-primary"
								ng-click="excel(customerAnalysis.company)">
								<i class="fa fa-download"> </i> Export Excel
							</button>

							<a id="customerAnalysisExport" href="" download=""></a>

						</div>
					</div>
				</div>

			</form>

		</div>
		<!-- /panel-body -->
	</div>
	<br> <br> <br> <br> <br> <br> <br> <br>
	<br> <br> <br> <br> <br> <br> <br>

	<!-- /panel-default -->
</div>

