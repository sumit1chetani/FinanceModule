<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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

.ui-jqgrid tr.myfootrow td {
    font-weight: bold;
    overflow: hidden;
    white-space:nowrap;
    height: 21px;
    padding: 0 2px 0 2px;
    border-top-width: 1px;
    border-top-color: inherit;
    border-top-style: solid;
}

   .ui-jqgrid-hdiv {
	  display:none !important;  
}  

.ui-jqgrid,
.ui-jqgrid-view,
.ui-jqgrid-hdiv,
.ui-jqgrid-bdiv,
.ui-jqgrid-pager
{
width: 100% !important;
}


</style>
<security:authentication var="user" property="principal" />

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form" st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="trialBalanceForm" class="form-horizontal">
				<div class="row">

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>

							
							<div class="form-group">
								<label class="col-md-5 control-label">Organization<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<selectivity list="companyList"
										property="generalLedger.companyCode"
										ng-model="generalLedger.companyCode" id="companyCode"
										name="organizationName"
										object="company" validation="required"
										friendly-name="	companyName"
										form-name="cashBankcomPaymentForm"></selectivity>
								</div>
							</div>
							
							<!-- <div class="form-group">
								<label class="col-md-5 control-label">Sub Group<span
									style="color: red;"> </span></label>
								<div class="col-md-7">
									<selectivity list="subGroupList"
												property="generalLedger.subGroupId" id="subGroupId"
												object="subGroupId"></selectivity>
								</div>
							</div> -->
							
								<div class="form-group">
								<label class="col-md-5 control-label">Account Head<span
									style="color: red;"> </span></label>
								<div class="col-md-7">
									<selectivity list="accountHeadList"
												property="generalLedger.acctHeadId" id="acctHeadId"
												object="acctHeadId"></selectivity>
								</div>
							</div>
							
							<!-- <div class="form-group">
								<label class="col-md-5 control-label">Fund Type<span
									style="color: red;"></span></label>
								<div class="col-md-7">
									<selectivity list="costList" id="costCenter" name="costCenter"
										form-name="trialBalanceForm"
										property="generalLedger.costCenter"
										ng-model="generalLedger.costCenter" friendly-name="Costcenter"
										validation="required"></selectivity>
								</div>
							</div> -->

							



						</fieldset>
					</div>


					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>

							
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5">From
									Date <span style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<div class="input-group input-append date" id="gl_fromDate">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="generalLedger.fromDate"
											name="fromDate" id="fromDate"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
	
							</div>
							
							
						<!-- 	<div class="form-group">
								<label class="col-md-5 control-label">Account Head<span
									style="color: red;"> </span></label>
								<div class="col-md-7">
									<selectivity list="accountHeadList"
												property="generalLedger.acctHeadId" id="acctHeadId"
												object="acctHeadId"></selectivity>
								</div>
							</div> -->

<div class="form-group">
								<label class="col-md-5 control-label">Fund Type<span
									style="color: red;"></span></label>
								<div class="col-md-7">
									<selectivity list="costList" id="costCenter" name="costCenter"
										form-name="trialBalanceForm"
										property="generalLedger.costCenter"
										ng-model="generalLedger.costCenter" friendly-name="Costcenter"
										validation="required"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
						
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">To
									Date <span style="color: red;">*</span>
								</label>
								<div class="col-md-6">
									<div class="input-group input-append date" id="gl_toDate">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy" ng-model="generalLedger.toDate"
											name="toDate" id="toDate"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>

                            <div class="form-group">
								<label class="col-md-4 control-label">Sub Account<span
									style="color: red;"> </span></label>
								<div class="col-md-6">
									<selectivity list="subAccountList"
												property="generalLedger.subAccountFilterId" id="subAccountFilterId"
												object="subAccountFilterId"></selectivity>
								</div>
							</div> 
							
							<!-- <div class="form-group">
								<label class="col-md-5 control-label">Fund Type<span
									style="color: red;"></span></label>
								<div class="col-md-7">
									<selectivity list="costList" id="costCenter" name="costCenter"
										form-name="trialBalanceForm"
										property="generalLedger.costCenter"
										ng-model="generalLedger.costCenter" friendly-name="Costcenter"
										validation="required"></selectivity>
								</div>
							</div> -->

						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset></fieldset>
					</div>

					<!-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label">Group Code </label>
										<div class="col-md-7">
										
											<selectivity list="GroupList"
												property="generalLedger.groupCode" id="groupCode"
												object="groupCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>

							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Sub Group </label>
										<div class="col-md-7">
										
											<selectivity list="subGroupList"
												property="generalLedger.subGroupCode" id="subGroupCode"
												object="subGroupCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>
							

							<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label">Main Account</label>
										<div class="col-md-7">
										
											<selectivity list="mainaccountlist"
												property="generalLedger.mainAccountCode" id="mainAccountCode"
												object="mainAccountCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div> -->

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
							<button type="button" class="btn btn-success"
								ng-click="viewGeneralLedgerReport()">
								<i class="fa fa-search"></i>View Report
							</button>
							<!-- 		
							  <button type="button" class="btn btn-success" 
												 ng-click="printgeneralLedger()"  
												 type="button">
									        	   Print
									         </button> -->



							<!-- 	<button type="button" class="btn btn-primary" type="button"
									ng-click="exportGeneralLedgerExcelOP()">
									<i class="fa fa-search"></i>Export Excel
								</button>  -->
<a id="GLExport" stype="display:none"
					href="filePath/GeneralLedger.xls" download="GeneralLedger.xls"></a>
							<button type="button" class="btn btn-primary"
								ng-click="exportGeneralLedgerExcel()">
								<i class="fa fa-search"></i>Export Excel
							</button>

							<security:authorize access="hasRole('${form_code}_${export}')">
								<button type="button" class="btn btn-primary"
									ng-click="exportTransactionLevelExcel()">
									<i class="fa fa-search"></i>Export Excel OP with Transaction
								</button>
							</security:authorize>
							<button class="btn btn-primary" ng-click="exportPDF()" type = "button">
										<i class="fa fa-file-excel-o"> </i> Export PDF<a
											id="exportPDF" stype="display:none"
											href="filePath/GeneralLedger.pdf"
											download="GeneralLedger.pdf"></a>
									</button>

							<button type="button" class="btn btn-info" type="reset"
								class="btn btn-success" ng-click="formreset()">
								<i class="fa fa-undo"></i>Reset
							</button>
						</div>
					</div>
				</div>
				<br>
						 				
				  <div class="row">
					<div class="col-xs-12">
					<table class='ui-jqgrid hidden' id='gl_op_header'>	
						<tr style='height: 20px; font-size: 11px;white-space: nowrap;height: 21px; border : 1px solid #F3F0EF;font-weight: bold;background-color: #c3e3ef69;'>
							 <td style='width: 292px; border : 1px solid #F3F0EF;'>&nbsp;Date</td>
							 <td style='width: 287px;border : 1px solid #F3F0EF;'>&nbsp;Particulars</td>
							 <td style='width: 300px;border : 1px solid #F3F0EF;'>&nbsp;Transaction No</td>
							 <td style='width: 300px; text-align : right;border : 1px solid #F3F0EF;'>Debit&nbsp;</td>
							 <td style='width: 300px; text-align : right;font-weight: bold;'>Credit&nbsp;</td>
						</tr>
						<tr style='height: 20px; font-size: 11px;white-space: nowrap;height: 21px; border : 1px solid #F3F0EF;font-weight: bold;'>
							 <td style='width: 292px; border : 1px solid #F3F0EF;'>&nbsp;{{generalLedger.fromDate | date:'dd/MM/yyyy' }}</td>
							 <td style='width: 287px;border : 1px solid #F3F0EF;'>&nbsp;Opening Balance</td>
							 <td style='width: 300px;'></td> 
							 <td style='width: 300px;border : 1px solid #F3F0EF;text-align : right;'>{{ generalLedger.opbaldr | number : 2 }}&nbsp;</td>
							 <td style='width: 300px;border : 1px solid #F3F0EF;text-align : right;'>{{ generalLedger.opbalcr | number : 2 }}&nbsp;</td>
						</tr>
						<tr ng-repeat="(trIndex, row)  in displayedCollection" style="height: 20px; font-size: 11px;white-space: nowrap;height: 21px; border : 1px solid #F3F0EF;"> 
							<td style="width: 292px; border : 1px solid #F3F0EF;">&nbsp;{{row.ledgerDate |  date:'dd/MM/yyyy' }}</td>
							<td style='width: 287px;border : 1px solid #F3F0EF;'>&nbsp;{{row.accountHeadName}}</td>
							<td style='width: 300px;border : 1px solid #F3F0EF;'>&nbsp;{{row.transactionNo}}</td>
							<td style='width: 300px; text-align : right;border : 1px solid #F3F0EF;'>&nbsp;{{row.bcCredit |number:2}}&nbsp;</td>
							<td style='width: 300px; text-align : right;'>{{row.bcDebit |number:2}}&nbsp;</td>
						</tr>						
						<tr style='height: 20px; font-size: 11px;white-space: nowrap;height: 21px; border : 1px solid #F3F0EF;font-weight: bold;'>
							 <td style='width: 292px; border : 1px solid #F3F0EF;'></td>
							 <td style='width: 287px;border : 1px solid #F3F0EF;'>&nbsp;Current Total</td> 
							 <td style='width: 300px; border : 1px solid #F3F0EF;'></td>
							 <td style='width: 300px; text-align : right;border : 1px solid #F3F0EF;font-weight: bold;'>{{generalLedger.currentdr | number :2}}&nbsp;</td> 
							 <td style='width: 300px; text-align : right;font-weight: bold;'>{{generalLedger.currentcr | number :2}}&nbsp;</td>
						</tr>						
						<tr style='height: 20px; font-size: 11px;white-space: nowrap;height: 21px; border : 1px solid #F3F0EF;font-weight: bold;'>
							 <td style='width: 292px; border : 1px solid #F3F0EF;'></td>
							 <td style='width: 287px;border : 1px solid #F3F0EF;'>&nbsp;Closing Balance</td>
							 <td style='width: 300px; border : 1px solid #F3F0EF;'></td>
							 <td style='width: 300px;font-weight: bold;text-align : right;'>{{generalLedger.clbaldr  |number:2}}&nbsp;</td> 
							 <td style='width: 300px;border : 1px solid #F3F0EF;text-align : right;'>{{generalLedger.clbalcr  |number:2}}&nbsp;</td>
						</tr>						
						<tr style='height: 20px; font-size: 11px;white-space: nowrap;height: 21px; border : 1px solid #F3F0EF;font-weight: bold;'> 
							 <td style='width: 287px;'></td> 
							 <td style='width: 287px;border : 1px solid #F3F0EF;'>&nbsp;Total</td> 
							 <td colspan = "2" style='width: 300px;text-align : right;'>{{generalLedger.finaldr | number : 2}}&nbsp;</td>
							 <td style='width: 300px;border : 1px solid #F3F0EF;text-align : right;'>{{generalLedger.finalcr | number : 2}}&nbsp;</td>
						</tr>													 
						</tbody>
					</table>
										
					     <div id="jqgrid">
					  		<div id="gl_header">
					  		
					  		</div>
						  <table id="generalLedgerGrid" class="hidden"></table>							
							<div id="generalLedgerPage" class="hidden"></div>  
						</div>    
					</div>
				</div>  
				
				<div style="padding-left: 52%;" ng-if="generalLedger.datatrue">
					<div class="col-sm-12 col-md-4 col-lg-4"
						style="width: 51%; padding-right: -6%; left: 194px;">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label"
									style="font-size: 11px; font-weight: 500;"> Opening
									Balance </label>
								<div class="col-md-7"
									style="font-size: 11px; padding-top: 7px; font-weight: 500;">{{generalLedger.opbal}}</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4"
						style="padding-right: 0px; padding-left: 0px; width: 300px; left: 98px;">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label"
									style="font-size: 11px; font-weight: 500;"> Closing
									Balance </label>
								<div class="col-md-7"
									style="font-size: 11px; padding-top: 7px; font-weight: 500;">{{generalLedger.clbal}}</div>
							</div>
						</fieldset>
					</div>
				</div>
				
			</form>
		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
	<br> <br> <br> <br> <br> <br> <br> <br>
	<br> <br> <br> <br> <br> <br> <br> <br>
</div>
</div>
</article>
</div>
</section>
</div>
