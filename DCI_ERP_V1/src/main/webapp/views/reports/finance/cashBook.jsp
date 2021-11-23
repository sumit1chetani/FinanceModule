<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	
	<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" name="cashBankForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label class="col-md-5 control-label"> Company <span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="companyList"
											property="CashBook.companyCode" id="companyCode"
											object="companyCode"></selectivity>



										<!-- <select id="txtCompanyCode" multiple="multiple" name="multiselect[]" ng-model="CashBook.objCompanyCodes"
										 ng-options="option.text for option in companyList" data-dropdownmultiselect>    
										   <option data-ng-repeat="option in companyList" value="{{getOptionId(option)}}" 
										   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
										</select> -->
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label"> Cash Account Code<span
										style="color: red;">*</span>
										 </label>
									<div class="col-md-7">
										<selectivity list="accountList"
											property="CashBook.accountCode"
											ng-model="CashBook.accountCode" name="accountCode"
											form-name="cashBankForm" friendly-name="Account Code"
											id="accountCode"></selectivity>
									</div>
								</div>
							</fieldset>

						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">
									From Date 
									<span style="color: red;">*</span>
									</label>
									<!-- <ng-bs3-datepicker data-ng-model="CashBook.fromDate" name="fromDate" id="fromDate"/> -->
									<div class="input-group input-append date" id="cb_fromDate">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="CashBook.fromDate"
											name="fromDate" id="fromDate"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
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
										<!-- <ng-bs3-datepicker data-ng-model="CashBook.toDate" name="toDate" id="toDate"/> -->
										<div class="input-group input-append date" id="cb_toDate">
											<input type="text" class="form-control input-sm"
												placeholder="dd/mm/yyyy" ng-model="CashBook.toDate"
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
									<label  class="control-label col-md-5">Voucher No<span style="color: red;"></span>
									</label>
									<div class="col-md-5" style="padding-left: 3px;">
									<input type="text" class="form-control input-sm" 
										 form-name="cashBankForm"
										 ng-model="CashBook.transactionNo"
										name="trasactionNo" />
								</div>
								</div>
							</fieldset>
						</div>
						
					<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label  class="control-label col-md-5">Narration<span style="color: red;"></span>
									</label>
									<div class="col-md-5">
									<input type="text" class="form-control input-sm" 
										form-name="cashBankForm"
										ng-model="CashBook.narration"
										name="Narration" />
								</div>
								</div>
							</fieldset>
						</div>
						
						<!-- <div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">
									<label  class="control-label col-md-5">Amount<span style="color: red;"></span>
									</label>
									<div class="col-md-5">
									<input type="number" class="form-control input-sm" 
									    form-name="cashBankForm"
										ng-model="CashBook.amount"
										name="Amount" />
								</div>
								</div>
							</fieldset>
						</div> -->
					</div>
				</div>
				<br>
				<a id="CBExport" stype="display:none" href="filePath/cashBook.xls"
					download="cashBook.xls"></a>	
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<security:authorize access="hasRole('${form_code}_${view}')">
								<button class="btn btn-success" type="button" ng-click="getCashReport(CashBook)">
									<i class="fa fa-search"></i>View Report
								</button>
								</security:authorize>
								<security:authorize access="hasRole('${form_code}_${export}')">
								<button class="btn btn-primary" type="button" ng-click="exportCashBook(CashBook)">
									<i class="fa fa-search"></i>Export Excel
								</button>
								</security:authorize>
							
							<!--  <button class="btn btn-info" type="reset" class="btn btn-success">
		            <i class="fa fa-undo"></i>Reset
		           </button> -->
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10"
						id="jqgrid">
						<table id="cashBookMainGrid"></table>
						<div id="cashBookPage"></div>
					</div>
				</div>
			</form>
		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
</div>
<!-- /wrapper-md -->



