<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 -->	
 	
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
										<div class="col-sm-12 col-md-4 col-lg-4">
											<fieldset>
												<div class="form-group">
													<label class="col-md-5 control-label"> Organization <span
														style="color: red;">*</span>
													</label>
													<div class="col-md-7">
														<selectivity list="companyList"
															property="trialBalance.companyCode"
															data-ng-model="trialBalance.companyCode" id="companyCode"
															object="companyCode" name="organization"></selectivity>
													</div>
												</div>
												
																<div class="form-group">
						<label class="col-md-5 control-label">Fund Type<span
							style="color: red;"></span></label>
						<div class="col-md-7">
							<selectivity list="costList" id="costCenter" name="costCenter"
								form-name="trialBalanceForm" property="trialBalance.costCenter"
								ng-model="generalLedger.costCenter" friendly-name="Costcenter"
								validation="required"></selectivity>
						</div>
					</div>
										

												<div class="form-group" data-ng-if="trialBalance.isGenerate">
					             		<label class="col-md-5 control-label"> Opening Balance</label>
					             			<div class="col-md-6">
							              		<div class="checkbox">
							               			<label> 
  							               				<input type="checkbox" name = "openingBalance"  data-ng-model="trialBalance.opnchk" data-ng-true-value="'Y'" data-ng-false-value="'N'"   ng-click = "ShowHideColumn()"/>
<!--  							                			  							               				<input type="checkbox"   name = "openingBalance"  data-ng-model="trialBalance.opnchk"    ng-click = "ShowHideColumn()">
 --> 							                			
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
					            	</div>
					            	
					            	
					            	
					            	
					            	
<!-- 					            	<button id="btn-show-all-children" type="button">Expand All</button>
 -->					            	
					            <!-- 	<button type="button" ng-click="ShowHideColumn1(allExpanded = !allExpanded)">
                        <span ng-bind="allExpanded ? '-' : '+'"></span>
                    </button> -->
                    
<!--                                 <button class="btn btn-primary" class="collapse" ng-click="isThingsCollapsed = !isThingsCollapsed">Collapse/Expand</button>
 -->                    
					            	
					            	
					            	
<!-- 					            	      <button class="k-button" ng-click="ShowHideColumn1()">Expand All</button>
 -->					            	
					            	
					            	
					            	
					            	
					            	
					            	<!-- <div class="form-group" data-ng-if="trialBalance.isGenerate">
					             		<label class="col-md-5 control-label"> Balance</label>
					             			<div class="col-md-6">
							              		<div class="checkbox">
							               			<label> 
  							               				<input type="checkbox" name = "currentBalance"  data-ng-model="trialBalance.opnbal" data-ng-true-value="'Y'" data-ng-false-value="'N'"   ng-click = "Showbalance()"/>
 							                			  							               				<input type="checkbox"   name = "openingBalance"  data-ng-model="trialBalance.opnchk"    ng-click = "ShowHideColumn()">
 							                			
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
					            	</div> -->
					            	
											</fieldset>
											
										
										</div>
										
										<%-- 
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
										
						 <div class="form-group">
									<label class="col-md-5 control-label"> Company </label>
									<div class="col-md-6">
										<select id="companyCode" multiple="multiple" name="companyCode"
											ng-model="trialBalance.companyCodes"
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
									
									
									<div class="form-group" data-ng-if="trialBalance.isGenerate">
					             		<label class="col-md-5 control-label">Transaction</label>
					             			<div class="col-md-6">
							              		<div class="checkbox">
							               			<label> 
  							               				<input type="checkbox" name = "debitAmount"  data-ng-model="trialBalance.opndeb" data-ng-true-value="'Y'" data-ng-false-value="'N'"   ng-click = "Showdebit()"/>
							                			<span></span>
							               			</label>
							              		</div>
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
																			id="fromDate" data-ng-model="trialBalance.fromDate">
																		<span class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="trialBalance.fromDate"
																		data-on-set-time="trialBalance.fromDate = onDateSet(newDate)"
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

<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">To
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-6">
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
									
							

<!-- <div class="form-group" data-ng-if="trialBalance.isGenerate">
					             		<label class="col-md-5 control-label"> Credit</label>
					             			<div class="col-md-6">
							              		<div class="checkbox">
							               			<label> 
  							               				<input type="checkbox" name = "creditAmount"  data-ng-model="trialBalance.opncre" data-ng-true-value="'Y'" data-ng-false-value="'N'"   ng-click = "Showcredit()"/>
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
					            	</div> -->
	
	<div class="form-group" data-ng-if="trialBalance.isGenerate">
					             		<label class="col-md-5 control-label"> Balance</label>
					             			<div class="col-md-6">
							              		<div class="checkbox">
							               			<label> 
  							               				<input type="checkbox" name = "currentBalance"  data-ng-model="trialBalance.opnbal" data-ng-true-value="'Y'" data-ng-false-value="'N'"   ng-click = "Showbalance()"/>
<!--  							                			  							               				<input type="checkbox"   name = "openingBalance"  data-ng-model="trialBalance.opnchk"    ng-click = "ShowHideColumn()">
 --> 							                			
							                			<span></span>
							               			</label>
							              		</div>
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
																			data-ng-model="trialBalance.toDate"> <span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker data-ng-model="trialBalance.toDate"
																		data-on-set-time="trialBalance.toDate = onDateSet(newDate)"
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
<!-- 															property="trialBalance.subGroupCode" id="subGroupCode" -->
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
<!-- 															property="trialBalance.acctHeadId" id="acctHeadId" -->
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
<!-- 															property="trialBalance.subAccountFilterId" -->
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
												<button class="btn btn-success" ng-click="submit()">
													<i class="fa fa-search"> </i>View Report
												</button>
												<%-- </security:authorize> --%>

												<a id="TBExport" style="display: none"
													href="filePath/TrialBalance.xls" download="TrialBalance.xls"></a>
												<security:authorize
													access="hasRole('${form_code}_${export}')">
													<button class="btn btn-primary" ng-click="exportExcel()">
														<i class="fa fa-download"> </i>Export Excel
													</button>
												</security:authorize>
												
												<button class="btn btn-primary" ng-click="exportPDF()" type = "button">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="exportPDF" stype="display:none"
											href="filePath/TrialBalance.pdf"
											download="TrialBalance.pdf"></a>
									</button>
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
										    <div collapse="isThingsCollapsed">
										
											<div id="jqgrid">
												<table id="trialBalanceGrid" ></table>
												<div id="trialBalancePage"></div>
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

