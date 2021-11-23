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
                    <div class="col-sm-4 col-md-4">
                       <div class="form-group">
                          <label class="col-md-6 control-label">Company<span style="color: red;">*</span>
                          </label>
                          <div class="col-md-6">
                          <selectivity list="companyList"
															property="generalLedger.companyCode"
															data-ng-model="generalLedger.companyCode" id="companyCode"
															object="companyCode" name="companyCode"></selectivity>
                             <%-- <selectivity list="companyList" property="generalLedger.companyCode"  ng-model="generalLedger.companyCode" 
								        id="companyCode" name="<spring:message
			              			code="label.company.name"></spring:message>" object="company" validation="required" 
								        friendly-name="	<spring:message
			              			code="label.company.name"></spring:message>" form-name = "cashBankcomPaymentForm"></selectivity> --%>					        
                          </div>
                        </div>
                     </div>
                      <div class="col-sm-4 col-md-4">
                       <!-- div class="form-group">
    							<label for="inputPassword" class="control-label col-md-5">From Date<span style="color: red;">*</span></label>
  							<div class="col-md-7">
 									<a class="dropdown-toggle" id="fromDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="From Date"
																		data-valid-method="submit" data-message-id="From Date"
																		data-ng-model="generalLedger.fromDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="generalLedger.fromDate"
																	data-on-set-time="generalLedger.fromDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#fromDate',startView:'day', minView:'day'}" />
															</ul>  	
					        <ng-bs3-datepicker data-ng-model="bankReconcile.fromDate" id="fromDate" name="fromDate" name="fromdate"
       data-ng-change="checkDatesCL(bankReconcile.fromDate)" 
        friendly-name="From Date"/>								
  							</div>
       				</div> -->
       				<div class="form-group ">
								<label class="col-md-4 control-label">From Date <span
									style="color: red">*</span></label>
								<div class="col-md-6 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="generalLedger.fromDate"
										id="fromDate" name="From Date"
										data-ng-change="checkDatesCL(generalLedger.fromDate)"
										friendly-name="From Date" validation="required" />
								</div>
								</div>
                     </div>
                     
                     
                     <div class="col-sm-4 col-md-4">
                       <!-- <div class="form-group">
    							<label for="inputPassword" class="control-label col-md-5">To Date<span style="color: red;">*</span></label>
  							<div class="col-md-7">
 									<a class="dropdown-toggle" id="fromDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="To Date"
																		data-valid-method="submit" data-message-id="To Date"
																		data-ng-model="generalLedger.toDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="generalLedger.toDate"
																	data-on-set-time="generalLedger.toDate = onDateSet(newDate)" 
																	data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
															</ul>  	
					        <ng-bs3-datepicker data-ng-model="bankReconcile.fromDate" id="fromDate" name="fromDate" name="fromdate"
       data-ng-change="checkDatesCL(bankReconcile.fromDate)" 
        friendly-name="From Date"/>								
  							</div>
  							<div class="col-md-7">
 									<a class="dropdown-toggle" id="toDate" role="button"
																data-toggle="dropdown" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="From Date"
																		data-valid-method="submit" data-message-id="From Date"
																		data-ng-model="generalLedger.toDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="generalLedger.toDate"
																	data-on-set-time="generalLedger.toDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
															</ul>  	
					        <ng-bs3-datepicker data-ng-model="bankReconcile.fromDate" id="fromDate" name="fromDate" name="fromdate"
       data-ng-change="checkDatesCL(bankReconcile.fromDate)" 
        friendly-name="From Date"/>								
  							</div>
       				</div> -->
       				
       				
       				<div class="form-group ">
								<label class="col-md-4 control-label">To Date <span
									style="color: red">*</span></label>
								<div class="col-md-6 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="generalLedger.toDate"
										id="toDate" name="From Date"
										data-ng-change="checkDatesCL(generalLedger.toDate)"
										friendly-name="From Date" validation="required" />
								</div>
								</div>
                     </div>
                     <!-- <div class="col-sm-4 col-md-4">
                      <div class="form-group">
                        <label class="col-md-6 control-label">Cost Center
                        </label>
                        <div class="col-md-6">
                           <selectivity list="costList" id="costCenter"
														name="costCenter" form-name="trialBalanceForm"
														property="generalLedger.costCenter"
														ng-model="generalLedger.costCenter"
														friendly-name="Costcenter"  ></selectivity>
                        </div>
                      </div>
                     </div> -->
                    
                    <br>
                    <br>
                     <br>
                    <br>
                    
                    <a id="GLExport" stype="display:none"
					href="tempdoc/DayBook.xlsx" download="DayBook.xlsx"></a>
                    <div class="form-group">
						<div class="row">
                      <div class="col-md-5 col-md-offset-5">
                       <button type="button" class="btn btn-success"
									ng-click="inventoryList()">
									<i class="fa fa-search"></i>View Report
								</button>
								
								<!-- <button type="button" class="btn btn-primary"
									ng-click="exportGeneralLedgerExcel()">
									<i class="fa fa-search"></i>Export Excel
								</button>
                         -->
                        
                        
                      </div>
                    </div>
                    </div>
                      </fieldset>
                      </div>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="cashbookForm">

								<div class="row">
									<div class="padding-left-5 padding-top-5" id="jqgrid">
										<div id="cashbookJqGrid">
											<table id="cashBookGrid"></table>
											<div id="cashbookdiv"></div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-5 col-xs-offset-9 padding-top-5">
										<div class="form-group">
											<label class="col-md-3 control-label">Total Balance</label>
											<div class="col-md-3">
												<input type="text" class="form-control input-sm"
													data-ng-model="cashbook.totQty" id="totalQty"
													readonly="readonly">
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>