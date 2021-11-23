<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/blitzer/jquery-ui.css"
	type="text/css" />
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="breadcrumb-wrapper ng-scope">
 			<div class="panel panel-default panel-default-form">

  				 <%@include file="/views/templates/panel-header-form.jsp"%>
    	<input type="hidden" value="${form_code}" id="form_code_id">
  				<div class="panel-body">
    			<form name="trialBalanceForm" class="form-horizontal" >
    			<div class="row">
    			
    						<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Type
										</label>
										<div class="col-md-7">
											<selectivity list="CategoryList" property="categoryType" id="categoryType" object="categoryType"></selectivity>
										</div>
									</div>
									<div class="form-group">
						            <label class="col-md-5 control-label">From Date</label>
						            <div class="col-md-7">
							             <div class="input-group input-append date" id="soaFromDate">
								          <input type="text" class="form-control input-sm" name="From Date" id="txtFromDate"
								          data-ng-model="soa.fromDate" placeholder='dd/mm/yyyy' />
								          <span class="input-group-addon add-on">
								           <span class="glyphicon glyphicon-calendar"></span>
								          </span>
								        </div>
						            </div>
						           </div>

									
								</fieldset>
							</div>
							
					     	<div class="col-sm-12 col-md-4 col-lg-4" >
								<fieldset>
									<div class="form-group" ng-if="!isPayementCentre">
										<label class="col-md-5 control-label"> Company
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
										<selectivity list="companyList" ng-model="soa.companyCode"
					             property="soa.companyCode" id="companyCode"  object="companyCode"  name="companyCode"
					             validation="required" friendly-name="Company" form-name="trialBalanceForm"></selectivity>
											<!-- <selectivity list="companyList" property="soa.companyCode" id="companyCode" object="companyCode" validation="required" friendly-name="Company" form-name="trialBalanceForm"></selectivity> -->
										</div>
									</div>
									<div class="form-group">
						            <label class="col-md-5 control-label">To Date</label>
						            <div class="col-md-7">
							             <div class="input-group input-append date" id="soaToDate">
								          <input type="text" class="form-control input-sm" name="To Date" id="txtToDate"
								          data-ng-model="soa.toDate" placeholder='dd/mm/yyyy' />
								          <span class="input-group-addon add-on">
								           <span class="glyphicon glyphicon-calendar"></span>
								          </span>
								        </div>
						            </div>
						           </div>
						          
								</fieldset>
							</div>
<!-- 							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="isPayementCentre"> -->
<!-- 								<fieldset> -->
<!-- 									<div class="form-group"> -->
<!-- 										<label class="col-md-5 control-label"> Payment centre -->
<!-- 											<span style="color: red;">*</span> -->
<!-- 										</label> -->
<!-- 										<div class="col-md-7"> -->
<!-- 										<selectivity list="paymentList" ng-model="soa.paymentCode" -->
<!-- 					             property="soa.paymentCode" id="paymentCode"  object="paymentCode"  name="paymentCode" -->
<!-- 					             validation="required" friendly-name="Payment centre" form-name="trialBalanceForm"></selectivity> -->
<!-- 											<selectivity list="paymentList" property="soa.paymentCode" id="paymentCode" object="paymentCode" validation="required" friendly-name="Payment Centre" form-name="trialBalanceForm"></selectivity> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</fieldset> -->
<!-- 							</div> -->
					     	
						
						<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
								<div class="form-group">
										<label class="col-md-5 control-label"> Mode
										<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="modeList" ng-model="soa.mode" property="soa.mode" id="mode" object="mode" name="mode"
											validation="required" friendly-name="Mode" form-name="trialBalanceForm"></selectivity>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-5 control-label"> Customer
										</label>
										<div class="col-md-7">
											<selectivity list="customerList" property="soa.customerCode" id="customerCode" object="customerCode"></selectivity>
										</div>
									</div>
									
									 <div class="form-group">
										<label class="col-md-5 control-label"> Invoice Amount </label>
										<div class="col-md-7">
											<div class="checkbox">
												<label class="i-checks"> <input type="checkbox"
												id="isActive" class="checkbox style-0" name="Active"
												ng-model="soa.isInvoiceAmount" /> <i></i>
											</label>
											</div>
										</div>
									</div>
								</fieldset>
<!-- 								<fieldset> -->
<!-- 									<div class="form-group"> -->
<!-- 										<label class="col-md-5 control-label"> Payer -->
<!-- 										</label> -->
<!-- 										<div class="col-md-7"> -->
<!-- 											<selectivity list="payerList" property="soa.payerCode" id="subAccountCode" object="subAccountCode"></selectivity> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</fieldset> -->
						
									</fieldset>
									</div>
						<!-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
								<div class="form-group">
									<div class="col-md-3"></div>
									<div class="col-md-1">
										<div class="checkbox">
											<label class="i-checks"> <input type="checkbox"
												id="isActive" class="checkbox style-0" name="Active"
												ng-model="soa.isInvoiceAmount" /> <i></i>
											</label>
										</div>
									</div>
									<label class="col-md-4 control-label"> Invoice Amount </label>
									
								</div>
								</fieldset>
						</div> -->
				</div>
					
							<a id="SOACustomerExport" stype="display:none"
							href="filePath/SOA.xls" download="SOA.xls"></a>
						<!-- Form Action -->
						<div class="form-actions">
					         <div class="row">
						          <div class="col-md-12 ">
						          <security:authorize access="hasRole('${form_code}_${view}')">
           							<button  type="button" class="btn btn-success" ng-click="viewsoaCustomerReport(trialBalanceForm)">
            								<i class="fa fa-search"></i>View Report
           							</button>
           							<button  type="button" class="btn btn-success" ng-click="viewsoaConsolidated()">
            								<i class="fa fa-search"></i>View Consolidated
           							</button>
           							</security:authorize>
           							<security:authorize access="hasRole('${form_code}_${export}')">
           							<button  type="button"class="btn btn-primary" ng-click="exportsoaCustomerExcel(trialBalanceForm)">
            								Export Excel
           							</button>
           							<button  type="button" class="btn btn-primary" ng-click="exportsoaConsolidatedExcel()">
            								Export Consolidated Excel
           							</button>
           							</security:authorize>
           							<security:authorize access="hasRole('${form_code}_${print}')">
           							<button  type="button" class="btn btn-primary" ng-click="ViewBulkMailDiv(trialBalanceForm)">
            								Bulk Print
           							</button>
           							</security:authorize>
           							
           							<button  type="button" class="btn btn-primary" ng-click="sendBulkMail()">
            								Bulk Mail
           							</button>
           							<button  type="button" class="btn btn-primary" ng-click="sendSOA(trialBalanceForm)">
            								Send SOA
           							</button>
<!--            							<button class="btn btn-primary" ng-click="viewsoaConsolidatedIws()"> -->
<!--             								SOA with Ex-Voyage -->
<!--            							</button> -->
						           <button class="btn btn-info" type="reset" class="btn btn-success" ng-click="formreset()">
						            <i class="fa fa-undo"></i>Reset
						           </button>
         						 </div>
        						 </div>
       					</div>
         				<br>
         				<div class="row" ng-if ="isBulkMail">
         					<div class="col-sm-12 col-md-4 col-lg-4" >
								<fieldset>
									<div class="form-group" >
										<label class="col-md-5 control-label"> Invoice Type
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="invoiceTypeList" property="objsoa.invoiceType" id="invoiceType" object="invoiceType"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>
							
							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group" ng-if="isPayerselected">
										<label class="col-md-5 control-label"> Invoice
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											 <select id="txtInvoice" multiple="multiple" name="multiselect[]" ng-model="objsoa.bulkInvoice"
											 ng-options="option.text for option in invoiceList" data-dropdownmultiselect>    
											   <option data-ng-repeat="option in invoiceList" value="{{getOptionId(option)}}" 
											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.text}}"></option>
											</select>
										</div>
									</div>
								</fieldset>
							</div>
							
         					<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<button class="btn btn-success" ng-click="bulkPrint()">
            								Bulk Print
           								</button>
									</div>
								</fieldset>
							</div>
							
							
         				</div>
         				<div class="row">
         					<div class="col-xs-12">
         				 		<div id="jqgrid" ng-if =!isConsolidated>
									<table id="soaCustomerGrid"></table>
									<div id="soaCustomerPage"></div>
								</div>
							</div>
         				</div>	
         				
         				<div class="row">
         					<div class="col-xs-12">
         				 		<div id="jqgrid1" ng-if ="isConsolidated && !soa.isInvoiceAmount">
									<table id="soaConsolidatedGrid"></table>
									<div id="soaConsolidatedPage"></div>
								</div>
							</div>
         				</div>
         				
         				<div class="row">
         					<div class="col-xs-12">
         				 		<div id="jqgrid1" ng-if ="isConsolidated && soa.isInvoiceAmount" >
									<table id="soaConsolidatedGridinv"></table>
									<div id="soaConsolidatedPageinv"></div>
								</div>
							</div>
         				</div>
					     	

					</form>
				</div> <!-- /panel-body -->
			</div> <!-- /panel-default -->
		</div>
	</div>
</div>