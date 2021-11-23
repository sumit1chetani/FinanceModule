	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" name="profitLossSearchForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
 <input type="hidden" value="${user.departmentName}" id="departmentName">	
						<div class="col-sm-3">
							<fieldset>

								<div class="form-group">
									<label class="col-md-5 control-label"> Company <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="companyList"
											property="arAgewise.companyCode" id="companyCode" name="companyCode"
											object="companyCode"></selectivity>
									</div>
								</div>

							</fieldset>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">Date
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<div class="input-group input-append date" id="ar_fromDate">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="arAgewise.fromDate"
											name="fromDate" id="fromDate"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">Type
								</label>
								<div class="col-md-7">
									<selectivity list="typeList" property="arAgewise.type"
										data-ng-model="arAgewise.type" name="type" friendly-name="Type">
									</selectivity>
								</div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">Customer
								</label>
								<div class="col-md-7">
									<selectivity list="customerList"
										property="arAgewise.srvcPrtnrBin"
										data-ng-model="arAgewise.srvcPrtnrBin" name="srvcPrtnrBin"
										friendly-name="Customer"> </selectivity>
								</div>
							</div>
						</div>
					</div>

					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-3">
							<fieldset>


								<div class="form-group">
									<label class="col-md-5 control-label"> Sales Person </label>
									<div class="col-md-7">
										<selectivity list="employeeList" validation="required"
											property="arAgewise.salesPersonCode"
											data-ng-model="arAgewise.salesPersonCode" name="salesPersonCode"
											friendly-name="Sales Person"> </selectivity>
									</div>
								</div>

							</fieldset>
						</div>
					</div>

				</div>

				<div class="form-actions">
					<security:authorize access="hasRole('${form_code}_${view}')">
						<button type="button" class="btn btn-success"
							ng-click="viewARReceivableAgewise()">
							<i class="fa fa-search"></i>View
						</button>
						<!-- <button  type="button" class="btn btn-success" ng-click="viewARReceivableAgewiseSecondary()">
				            	<i class="fa fa-search"></i>View Format 2
				            </button>
				            <button  type="button" class="btn btn-success" ng-click="viewARReceivableAgewiseFormat3()">
				            	<i class="fa fa-search"></i>View Agewise by Acct Manager
				            </button> -->
					</security:authorize>
					<security:authorize access="hasRole('${form_code}_${export}')">
						<!-- <button  type="button" class="btn btn-primary" ng-click="exportARReceivableAgewise()">
		            			<i class="fa fa-search"></i>Export
		       				</button> -->
						<!-- <button type="button" class="btn btn-primary"
							ng-click="exportAPPayableAgewise()">
							<i class="fa fa-search" type="button"></i>Export
						</button> -->
 <button class="btn btn-primary" data-ng-click="exportAPPayableAgewise()">
										<span class="fa fa-file-excel-o"> </span> Export to Excel <a
											id="ARReceivableExport" stype="display:none"
											></a>
								</button>
						<!-- <button  type="button" class="btn btn-primary" ng-click="exportARReceivableAgewiseSecondary()">
		            			<i class="fa fa-search"></i>Export Format 2
		       				</button>
		       				
		       				<button  type="button" class="btn btn-primary" ng-click="exportARReceivableAgewiseFormat3()">
		            			<i class="fa fa-search"></i>Export Agewise by Acct Manager
		       				</button> -->
					</security:authorize>
					<button type="button" class="btn btn-info" ng-click="reset()">
						<i class="fa fa-undo"></i>Reset
					</button>
					<!-- <button class="btn btn-success"   ng-click="receivableEntry()">
				            	<i class="fa "></i>SOA Projection
				            </button> -->
				</div>
				<a id="ARReceivableExport" stype="display:none"
					href=""
					download=""></a>
				<div class="row" ng-show="isPrimary!=dummy">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10"
						id="jqgrid">
						<table id="arAgewiseReportGrid"></table>
						<div id="arAgewiseReportGridPage"></div>
					</div>
				</div>
				<div class="row" ng-show="isPrimary==dummy">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10"
						id="jqgrid">
						<table id="arAgewiseReportGridTcAmount"></table>
						<div id="arAgewiseReportGridPageTcAmount"></div>
					</div>
				</div>

				<!--   <div class="row" ng-if = "isSecondary">
		       		<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10" id="jqgrid1">
						<table id="arAgewiseReportSecondaryGrid"></table>
						<div id="arAgewiseReportSecondaryGridPage"></div>
					</div>	
		       </div>
		       
		       <div class="row" ng-if = "isFormat3">
		       		<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10" id="jqgrid1">
						<table id="arAgewiseReportFormat3Grid"></table>
						<div id="arAgewiseReportFormat3GridPage"></div>
					</div>	
		       </div> -->
			</form>
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
</div>
<!-- /wrapper-md -->



