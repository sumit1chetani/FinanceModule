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
    			<form name="bankbookForm" class="form-horizontal">
									<div class="row">
										<div class="col-sm-12 col-md-4 col-lg-4">
											<fieldset>
												<div class="form-group">
													<label class="col-md-5 control-label"> Organization <span
														style="color: red;">*</span>
													</label>
													<div class="col-md-7">
														<selectivity list="companyList"
															property="generalLedger.companyCode"
															data-ng-model="generalLedger.companyCode" id="companyCode"
															object="companyCode" name="companyCode"></selectivity>
													</div>
												</div>
												
												
												
											<div class="form-group">
			        <label class="col-md-5 control-label">Payment Type<span style="color:red;"> *</span></label>
			  			
			         <div class="col-md-7 "  >
			  			<selectivity list="pmtTypeList" property="generalLedger.pmtType"  ng-model="generalLedger.pmtType" 
								        id="pmtType" name="Payment Type" object="pmttypeobj" validation="required" 
								        friendly-name="Payment Type" form-name = "bankbookForm"></selectivity>	
			        </div>
		       	</div>
											</fieldset>
										</div>
										
										
										<%-- 
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
										
						 <div class="form-group">
									<label class="col-md-5 control-label"> Company </label>
									<div class="col-md-6">
										<select id="companyCode" multiple="multiple" name="companyCode"
											ng-model="generalLedger.companyCodes"
											ng-options="option.text for option in companyList"
											friendly-name="companyCode" data-dropdownmultiselect>
											<option data-ng-repeat="option in companyList"
												value="{{getOptionId(option)}}"
												ng-selected="isOptionSelected(option)"
												data-ng-bind-template="{{option.text}}"></option>
										</select>
									</div>
								</div> 
								
								
		      	<div class="form-group">
			        <label class="col-md-5 control-label"><spring:message
			              			code="label.company.name"></spring:message><span style="color:red;"> *</span></label>
			        <div class="col-md-7">				       
				        <selectivity list="companyList" property="cashbankpaymentModelData.companyName"  ng-model="cashbankpaymentModelData.companyName" 
						  id="companyName" name="companyName"<spring:message
			              			code="label.company.name"></spring:message> object="company" validation="required" 
								        friendly-name="	<spring:message
			              			code="label.company.name"></spring:message>" form-name = "cashBankPaymentForm"></selectivity>	
		<selectivity  list="companyList" property="cashbankpaymentModelData.companyName" ng-model="cashbankpaymentModelData.companyName" 
         id="companyName" form-name="sailingsReportForm" name="companyName" validation="required" friendly-name="From Vessel" ></selectivity>					        
			        </div>
		       	</div>
								</fieldset>
							</div>
 --%>

										<div class="col-sm-12 col-md-4 col-lg-4">
											<fieldset>
											<div class="form-group ">
								<label class="col-md-5 control-label">From Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="generalLedger.fromDate"
										id="fromDate" name="From Date"
										data-ng-change="checkDatesCL(generalLedger.fromDate)"
										friendly-name="From Date" validation="required" />
								</div>
								</div>
											<!-- 	<div class="form-group">
													<label for="inputPassword" class="control-label col-md-5">From
														Date <span style="color: red;">*</span>
													</label>
													<div class="col-md-7">
														<div class='input-group date datetimepick'
															style="width: 85%;">
															<div class="dropdown">
																<a class="dropdown-toggle" id="tb_fromDate"
																	role="button" data-toggle="dropdown" data-target="#"
																	href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="From Date"
																			id="fromDate" data-ng-model="generalLedger.fromDate">
																		<span class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="generalLedger.fromDate"
																		data-on-set-time="generalLedger.fromDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#tb_fromDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div>
 -->


											</fieldset>
										</div>

										<div class="col-sm-12 col-md-4 col-lg-4">
											<fieldset>

<div class="form-group ">
								<label class="col-md-5 control-label">To Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="generalLedger.toDate"
										id="toDate" name="From Date"
										data-ng-change="checkDatesCL(generalLedger.toDate)"
										friendly-name="From Date" validation="required" />
								</div>
								</div>


												<!-- <div class="form-group">
													<label for="inputPassword" class="control-label col-md-5">To
														Date <span style="color: red;">*</span>
													</label>
													<div class="col-md-7">
														<div class='input-group date datetimepick'
															style="width: 69%;">
															<div class="dropdown">
																<a class="dropdown-toggle" id="tb_toDate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="To Date" id="toDate"
																			data-ng-model="generalLedger.toDate"> <span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="generalLedger.toDate"
																		data-on-set-time="generalLedger.toDate = onDateSet(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#tb_toDate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
													</div>
												</div> -->


											</fieldset>
										</div>

<!-- 										<div class="col-sm-12 col-md-4 col-lg-4"> -->
<!-- 											<fieldset> -->
<!-- 												<div class="form-group"> -->
<!-- 													<label class="col-md-5 control-label"> Sub Group </label> -->
<!-- 													<div class="col-md-7"> -->

<!-- 														<selectivity list="subGroupList" -->
<!-- 															property="generalLedger.subGroupCode" id="subGroupCode" -->
<!-- 															object="subGroupCode"></selectivity> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</fieldset> -->
<!-- 										</div> -->
<!-- 										<div class="col-sm-12 col-md-4 col-lg-4"> -->
<!-- 											<fieldset> -->
<!-- 												<div class="form-group"> -->
<!-- 													<label class="col-md-5 control-label"> Account Head -->
<!-- 													</label> -->
<!-- 													<div class="col-md-7"> -->

<!-- 														<selectivity list="accountHeadList" -->
<!-- 															property="generalLedger.acctHeadId" id="acctHeadId" -->
<!-- 															object="acctHeadId"></selectivity> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</fieldset> -->
<!-- 										</div> -->

<!-- 										<div class="col-sm-12 col-md-4 col-lg-4"> -->
<!-- 											<fieldset> -->
<!-- 												<div class="form-group"> -->
<!-- 													<label class="col-md-5 control-label"> Sub Account</label> -->
<!-- 													<div class="col-md-6"> -->

<!-- 														<selectivity list="subAccountList" -->
<!-- 															property="generalLedger.subAccountFilterId" -->
<!-- 															id="subAccountFilterId" object="subAccountFilterId" -->
<!-- 															name="subAccountFilterId"></selectivity> -->
<!-- 													</div> -->
<!-- 												</div> -->
<!-- 											</fieldset> -->
<!-- 										</div> -->
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
												  <button type="button" class="btn btn-success"
									ng-click="inventoryList()">
									<i class="fa fa-search"></i>View Report
								</button>
												<%-- </security:authorize> --%>

												<a id="GLExport" style="display: none"
													href="tempdoc/DayBook.xlsx" download="DayBook.xlsx"></a>
												<%-- <security:authorize
													access="hasRole('${form_code}_${export}')">
													<button class="btn btn-primary" ng-click="exportExcel()">
														<i class="fa fa-download"> </i>Export Excel
													</button>
												</security:authorize> --%>
												<%-- 
									<a id="TrialBalanceReport" style="display: none"
										href="tempdoc/TrialBalanceReport.xls"
										download="TrialBalanceReport.xls"></a>
									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											ng-click="exportExcelReport()">
											<i class="fa fa-download"> </i>Export Excel(New)
										</button>
									</security:authorize>
									
									<a id="TBExportWithPlain" style="display: none"
										href="tempdoc/TrialBalanceWithPlain.xls"
										download="TrialBalanceWithPlain.xls"></a>
									<security:authorize access="hasRole('${form_code}_${export}')">
										<button class="btn btn-primary"
											ng-click="exportExcelWithPlain()">
											<i class="fa fa-download"> </i>Export Excel(Plain)
										</button>
									</security:authorize> --%>
												<!-- <button class="btn btn-info" type="reset"
													class="btn btn-success" ng-click="formreset()">
													<i class="fa fa-undo"> </i>Reset
												</button> -->
											</div>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-xs-12">
											<div id="jqgrid">
												<table id="bankbookGrid"></table>
												<div id="bankbookdiv"></div>
											</div>
										</div>
									</div>
									
									<div class="row">
									<div class="col-xs-5 col-xs-offset-9 padding-top-5">
										<div class="form-group">
											<label class="col-md-3 control-label">Total Balance</label>
											<div class="col-md-3">
												<input type="text" class="text-right form-control input-sm"
													data-ng-model="cashbook.totQty|number:2" id="totalQty"
													readonly="readonly">
											</div>
										</div>
									</div>
								</div>
								</form>

							</div>
							<!-- /panel-body -->
						</div>
						<!-- /panel-default -->
						<br> <br> <br> <br> <br> <br> <br>
						<br> <br> <br> <br> <br> <br> <br>
						<br> <br>
					</div>

				</div>
			</article>
		</div>
	</section>
</div>