<style>
.level_class2 {
	background: #6ca5ee;
	color: #fff;
	font-size: 15px;
	font-weight: bold;
}

.level_class1, .level_class1:hover {
	background: #e58b90;
	color: #fff;
	font-size: 15px;
	font-weight: bold;
}

.level_class3 {
	background: #79c07c;
	color: #fff;
	font-size: 15px;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">

					<form class="form-horizontal" name="coreBySectorForm">
						<div class="row">
							<div class="col-sm-12 col-md-3 col-lg-3">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Company </label>
										<div class="col-md-7">
											<selectivity list="companyList"
												property="coreBySector.company"
												ng-model="coreBySector.company" id="company"
												object="company" name="company" friendly-name="Company"
												form-name="coreBySectorForm"> </selectivity>
										</div>
									</div>

									<div class="form-group">
										<label class="col-md-5 control-label"> Report Type </label>
										<div class="col-md-7">
											<div class="radio radio-inline  p-l-0"
												ng-init="coreBySector.portType='C'">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0" ng_model="coreBySector.reportType"
													value="C"> <i></i> Customer
												</label>
											</div>
											<div class="radio  radio-inline" style="margin-left: -19px;">
												<label class="i-checks"> <input type="radio"
													class="radiobox style-0" ng_model="coreBySector.reportType"
													value="P"> <i></i> Payer
												</label>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-3 col-lg-3">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Year <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="yearList" property="coreBySector.year"
												id="year" ng-model="coreBySector.year" object="year"
												validation="required" name="year" friendly-name="Year"
												form-name="coreBySectorForm"> </selectivity>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Cumulative </label>
										<div class="col-md-7">
											<div class="checkbox">
												<label class="i-checks"> <input type="checkbox"
													id="cumulative" class="checkbox style-0" name="cumulative"
													ng-model="coreBySector.cumulative"> <i></i>
												</label>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-6 col-lg-6">
								<fieldset>
									<div class="row">
										<div class="col-sm-12 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label"> Week <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<selectivity list="weekList" property="coreBySector.week"
														id="week" ng-model="coreBySector.week" object="week"
														validation="required" name="week" friendly-name="Week"
														form-name="coreBySectorForm"> </selectivity>
												</div>
											</div>
										</div>
										<div class="col-sm-12 col-md-6 col-lg-6">
											<label class="col-md-5 control-label">
												{{weekEndDate}} </label>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12 col-md-3 col-lg-3">
											<div class="form-group">
												<label class="col-md-9 control-label"> Slot </label>
											</div>
										</div>
										<div class="col-sm-9">
											<div class="form-group">
												<div class="col-md-12" style="padding-left: 0px;">
													<div class="radio radio-inline  p-l-0"
														ng-init="coreBySector.portType='1'" >
														<label class="i-checks"> <input type="radio"
															class="radiobox style-0" ng_model="coreBySector.sfpl"
															value="1"> <i></i> SFPL
														</label>
													</div>
													<div class="radio  radio-inline  p-l-0">
														<label class="i-checks"> <input type="radio"
															class="radiobox style-0" ng_model="coreBySector.sfpl"
															value="2"> <i></i> Non SFPL
														</label>
													</div>
													<div class="radio  radio-inline  p-l-0">
														<label class="i-checks"> <input type="radio"
															class="radiobox style-0" ng_model="coreBySector.sfpl"
															value=""> <i></i> Both
														</label>
													</div>
												</div>
											</div>
										</div>
									</div>

								</fieldset>
							</div>
						</div>

						<div class="form-actions">
							<div class="row">
								<div class="col-md-12 ">
									<button class="btn btn-success" type="button"
										ng-click="search(coreBySectorForm)">CORG by Sector</button>
									<security:authorize access="hasRole('${form_code}_${export}')">
									<button id="exportXl" class="btn btn-primary"
										data-ng-click="excel();" type="button">
										<i class="fa fa-print"></i> Export Excel
									</button>
									</security:authorize>
									<button class="btn btn-success" type="button"
										ng-click="search1(coreBySectorForm)">CORG by
										Sector-Volume,Weight&Profit</button>

									<!-- 		<button class="btn btn-success" type="button" 
											ng-click="excel()">
										Excel Export					
														</button> -->

								</div>
							</div>
						</div>

						<div class="panel panel-default panel-default-list"
							st-table="displayedCollection" st-safe-src="rowCollection">
							<%-- <div
			class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold">
			 <%@include file="/views/templates/panel-header-no-breadcrumb.jsp"%>
		</div> --%>
							<div class="panel-body float-left padding-0" style="width: 100%;">
								<div class="table-responsive ">
									<table
										class="table table-striped table-hover dataTable no-footer">
										<thead class="dataTables-Main-Head">
											<th class="width_10" data-ng-repeat="column in headerlist">{{column}}
											</th>
										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="column1 in displayedCollection track by $index">
												<td ng-if="$index==0"
													ng-repeat="detail in column1 track by $index ">{{detail}}</td>
												<td ng-if="$index==1"
													ng-repeat="detail in column1 track by $index ">{{detail}}</td>
												<td ng-if="$index!=0 && $index!=1" class="text-right"
													ng-repeat="detail in column1 track by $index ">{{detail}}</td>
											</tr>
										</tbody>
									</table>
								</div>
								<footer class="panel-footer panel-footer-list">
									<%-- <%@include file="/views/templates/panel-footer-static.jsp"%> --%>
								</footer>
							</div>
						</div>


					</form>

				</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel-default -->
		</div>
	</div>
</div>