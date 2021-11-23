<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">

				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="chequeDepoCollForm" class="form-horizontal">
						<div class="row">
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Company <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<!-- <selectivity list="companyList" property="generalLedger.companyCode" id="companyCode" object="companyCode"></selectivity> -->

											<select id="txtCompanyCode" multiple="multiple"
												name="multiselect[]" ng-model="companyCode"
												ng-options="option.text for option in companyList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in companyList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>

										</div>
									</div>
								</fieldset>
							</div>
							<!-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Service </label>
										<div class="col-md-7">
											        <selectivity list="serviceList" property="chequeDepoObj.service" id="service" object="service"></selectivity>
											<select id="txtservice" multiple="multiple"
												name="multiselect[]" ng-model="service"
												ng-options="option.text for option in serviceList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in serviceList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>
										</div>
									</div>

								</fieldset>
							</div> -->


							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Customer Type </label>
										<div class="col-md-7">
											<!--          <selectivity list="creditCategorylist" property="chequeDepoObj.customerType" id="customerType" object="customerType"></selectivity> -->
											<select id="txtCustomerType" multiple="multiple"
												name="multiselect[]" ng-model="customerType"
												ng-options="option.id as option.text for option in creditCategorylist"
												data-dropdownmultiselect>
												<option
													data-ng-repeat="option.id as option.text for option in creditCategorylist"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>
										</div>
									</div>

								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Payment Centre
										</label>
										<div class="col-md-7">
											<select id="txtpaymentCenter" multiple="multiple"
												name="multiselect[]" ng-model="paymentCenter"
												ng-options="option.text for option in paymentList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in paymentList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>
											<!-- <selectivity list="paymentList" property="chequeDepoObj.paymentCenter" id="paymentCenter" object="paymentCenter"></selectivity> -->
										</div>
									</div>

								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Customer </label>
										<div class="col-md-7">
											<!-- <selectivity list="payerList" property="chequeDepoObj.payerCode" id="subAccountCode" object="subAccountCode"></selectivity> -->
											<select id="txtpayerCode" multiple="multiple"
												name="multiselect[]" ng-model="payerCode"
												ng-options="option.text for option in payerList"
												data-dropdownmultiselect>
												<option data-ng-repeat="option in payerList"
													value="{{getOptionId(option)}}"
													ng-selected="isOptionSelected(option)"
													data-ng-bind-template="{{option.text}}"></option>
											</select>
										</div>
									</div>
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Country </label>
										<div class="col-md-6">
											<!-- <selectivity list="payerList" property="chequeDepoObj.payerCode" id="subAccountCode" object="subAccountCode"></selectivity> -->
											<selectivity list="countryList"
												ng-model="chequeDepoObj.countyCode"
												property="chequeDepoObj.countryCode" id="countryCode"
												object="countryCode" name="countyCode"
												friendly-name="Country"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>


						</div>
						<!-- /row -->
						<a id="ChqDepoCollecExport" stype="display:none"
							href="filePath/ChqDepositCollection.xls"
							download="ChqDepositCollection.xls"></a>
						<!-- Form Action -->
						<div class="form-actions">
							<div class="row">
								<div class="col-md-12 ">
								<security:authorize access="hasRole('${form_code}_${view}')">
									<button class="btn btn-success"
										ng-click="viewChqDepoCollReport()">
										<i class="fa fa-search"></i>View Report
									</button>
									</security:authorize>
									<security:authorize access="hasRole('${form_code}_${export}')">
									<button class="btn btn-primary"
										ng-click="exportChqDepoCollExcel()">Export Excel</button>
										</security:authorize>
									<button class="btn btn-info" type="reset"
										class="btn btn-success" ng-click="formreset()">
										<i class="fa fa-undo"></i>Reset
									</button>
								</div>
							</div>
						</div>
						<div class="row" st-table="displayedCollection"
							st-safe-src="rowCollection">
							<div
								class="table-responsive col-sm-12 col-md-12 col-lg-12 m-t-sm">
								<fieldset class="width_100">
									<table
										class="table table-striped b-t b-light table-hover dataTable no-footer">
										<thead class="dataTables-Main-Head">
											<tr>
												<th class="width_10 text-center">Cust Code</th>
												<th class="width_20 text-center">Cust Name</th>
												<th class="width_10 text-center">Cust Type</th>
												<th class="width_10 text-center">Credit Amt</th>

												<th class="width_10 text-center">Credit days</th>
												<th class="width_10 text-center">PDC in HAND</th>
												<th class="width_10 text-center">Total</th>
												<th class="width_10 text-center">0-15</th>
												<th class="width_10 text-center">16-30</th>
												<th class="width_10 text-center">31-45</th>
												<th class="width_10 text-center">46-60</th>
												<th class="width_10 text-center">Abv 60</th>
												<th class="width_15 text-center">Payment Centre</th>
												<th class="width_15 text-center">Country</th>

<!-- 												<th class="width_15 text-center">Action</th>
 -->											</tr>
											<tr>
												<th><input st-search="payerCode"
													placeholder="PayerCode" class="input-sm form-control"
													type="search" /></th>
												<th><input st-search="payerName"
													placeholder="PayerName" class="input-sm form-control"
													type="search" /></th>
												<th><input st-search="customerType"
													placeholder="CustomerType" class="input-sm form-control"
													type="search" /></th>
												<th><input st-search="payerCreditLimit"
													placeholder="PayerCreditLimit"
													class="input-sm form-control" type="search" /></th>

												<th><input st-search="creditDays"
													placeholder="CreditDays" class="input-sm form-control"
													type="search" /></th>
												<th><input st-search="pdcamount"
													placeholder="pdcamount" class="input-sm form-control"
													type="search" /></th>
												<th><input st-search="balance" placeholder="Balance"
													class="input-sm form-control" type="search" /></th>
												<th><input st-search="below15days"
													placeholder="below15days" class="input-sm form-control"
													type="search" /></th>
												<th><input st-search="days30" placeholder="days30"
													class="input-sm form-control" type="search" /></th>
												<th><input st-search="days30to45"
													placeholder="Days30to45" class="input-sm form-control"
													type="search" /></th>
												<th><input st-search="days45to60"
													placeholder="Days45to60" class="input-sm form-control"
													type="search" /></th>
												<th><input st-search="days60andabove"
													placeholder="days60andabove" class="input-sm form-control"
													type="search" /></th>
												<th><input st-search="country" placeholder="country"
													class="input-sm form-control" type="search" /></th>
												<th><input st-search="countryName"
													placeholder="countryName" class="input-sm form-control"
													type="search" /></th>
												<th></th>
											</tr>

										</thead>
										<tbody>
											<tr data-ng-repeat="reportObj in displayedCollection">

												<td st-search="mlocode" class="width_10 text-left"><span
													ng-bind="reportObj.payerCode"></span></td>
												<td class="width_20 padding-number-align text-left"><span
													ng-bind="reportObj.payerName"></span></td>
												<td class="width_10 padding-number-align text-left"><span
													ng-bind="reportObj.customerType"></span></td>
												<td class="width_10 padding-number-align text-right"><span
													ng-bind="reportObj.payerCreditLimit"></span></td>
												<td class="width_10 padding-number-align text-right"><span
													ng-bind="reportObj.creditDays"></span></td>
												<td class="width_10 padding-number-align text-right"><span 
													ng-bind="reportObj.pdcamount" > <a
													ng-click="view(reportObj.pdcamount)"> <span
														tooltip="{{reportObj.pdcamount}}"
														class="tool-tip-span font-blue">{{reportObj.pdcamount}}</span>
												</a></span>
												
												
												<span ng-if="displayedCollection.urIsView=='f'"> <span
														tooltip="{{reportObj.pdcamount}}"
														class="tool-tip-span">{{reportObj.pdcamount}}</span>
												</span>
												
												</td>


												<td ng-if="reportObj.payerCreditLimit <= reportObj.balance"
													class="width_10 padding-number-align text-right"><span
													class="font-red" ng-bind="reportObj.balance"></span></td>
												<td ng-if="reportObj.payerCreditLimit > reportObj.balance"
													class="width_10 padding-number-align text-right"><span
													class="font-green" ng-bind="reportObj.balance"></span></td>
												<td class="width_10 padding-number-align text-right"><span
													class="font-green" ng-bind="reportObj.below15days"></span>
												</td>
												<td class="width_10 padding-number-align text-right"><span
													class="font-green" ng-bind="reportObj.days30"></span></td>
												<td ng-if="reportObj.days30to45 == 0"
													class="width_10 padding-number-align text-right"><span
													class="font-green" ng-bind="reportObj.days30to45"></span></td>
												<td ng-if="reportObj.days30to45 != 0"
													class="width_10 padding-number-align text-right"><span
													class="font-red" ng-bind="reportObj.days30to45"></span></td>
												<td ng-if="reportObj.days45to60 != 0"
													class="width_10 padding-number-align text-right"><span
													class="font-red" ng-bind="reportObj.days45to60"></span></td>
												<td ng-if="reportObj.days45to60 == 0"
													class="width_10 padding-number-align text-right"><span
													class="font-green" ng-bind="reportObj.days45to60"></span></td>
												<td ng-if="reportObj.days60andabove != 0"
													class="width_10 padding-number-align text-right"><span
													class="font-red" ng-bind="reportObj.days60andabove"></span>
												</td>
												<td ng-if="reportObj.days60andabove == 0"
													class="width_10 padding-number-align text-right"><span
													class="font-green" ng-bind="reportObj.days60andabove"></span>
												</td>
												<td class="width_15 padding-number-align text-center"><span
													class="font-green" ng-bind="reportObj.country"></span></td>
												<td class="width_15 padding-number-align text-center"><span
													ng-bind="reportObj.countryName"></span></td>
												<!-- <td class=" td-actions text-center"><span> <i
														class="icon-envelope red"
														data-ng-click="sendSOA(reportObj)"
														style="cursor: pointer; color: gray;"></i>
												</span> <span> <i class="fa fa-eye  text"
														data-ng-click="preview(reportObj)"
														style="cursor: pointer; color: black;"></i>
												</span></td> -->

											</tr>


										</tbody>
									</table>
								</fieldset>
							</div>
							<!-- /table-respensive -->

							<footer class="panel-footer">
								<%@include file="/views/templates/panel-footer-static.jsp"%>
							</footer>
						</div>
					</form>
				</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel-default -->
		</div>
	</div>
</div>