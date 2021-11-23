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

.ui-dialog  {

    width: 100% !important;
    left: 0% !important;
}

</style>
<script> 
$("div#generalLeddialog").dialog ({
	  autoOpen : false
	  
	});

$(document).ready(function() {
	  //Fixing jQuery Click Events for the iPad
	  var ua = navigator.userAgent,
	    event = (ua.match(/iPad/i)) ? "touchstart" : "click";
	  if ($('.table').length > 0) {
	    $('.table .header').on(event, function() {
	      $(this).toggleClass("active", "").nextUntil('.header').css('display', function(i, v) {
	        return this.style.display === 'table-row' ? 'none' : 'table-row';
	      });
	    });
	  }
	})

</script>
<security:authentication var="user" property="principal" />

		<div class="breadcrumb-wrapper ng-scope">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="trialBalanceForm" class="form-horizontal">
						<div class="row">
							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="!test">
								<fieldset>
									<%-- <div class="form-group">
										<input type="hidden" id="companyCode"
											value="${user.companyCode}"> <label
											class="col-md-5 control-label"> Company <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											 <selectivity list="companyList" property="generalLedger.companyCode" id="companyCode" object="companyCode"></selectivity> 

											
										</div>
									</div> --%>
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="test">
								<fieldset>
									<div class="form-group">
										<input type="hidden" id="companyCode"
											value="${user.companyCode}"> <label
											class="col-md-5 control-label"> Company <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											 <selectivity list="companyList" property="generalLedger.companyCode" id="companyCode" object="companyCode"></selectivity> 

											
										</div>
									</div>
								</fieldset>
							</div>


							<div class="col-sm-12 col-md-4 col-lg-4" ng-show="!test">
								<fieldset>
									<!-- <div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">From
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="gl_fromDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="generalLedger.fromDate"
													name="fromDate" id="fromDate" > <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div> -->
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4" ng-show="test">
								<fieldset>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">From
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="gl_fromDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="generalLedger.fromDate"
													name="fromDate" id="fromDate" > <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar"></span>
												</span>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4" ng-show="!test">
								<fieldset>
									<!-- <div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">To
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="gl_toDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="generalLedger.toDate"
													name="toDate" id="toDate" date-disabled="true" disabled> <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar" ></span>
												</span>
											</div>
										</div>
									</div> -->
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4" ng-show="test">
								<fieldset>
									<div class="form-group">
										<label for="inputPassword" class="control-label col-md-5">
											Date <span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<div class="input-group input-append date" id="gl_toDate">
												<input type="text" class="form-control input-sm"
													placeholder="dd/mm/yyyy" ng-model="generalLedger.toDate"
													name="toDate" id="toDate" > <span
													class="input-group-addon add-on"> <span
													class="glyphicon glyphicon-calendar" ></span>
												</span>
											</div>
										</div>
									</div>
								</fieldset>
							</div>
							
							
							<div class="col-sm-12 col-md-4 col-lg-4"  ng-if="!test">
								<fieldset>
									
									<!-- <div class="form-group"  >
										<label class="col-md-5 control-label"> Group Code </label>
										
										<div class="col-md-7">
											<select id="txtGroupCode" multiple="multiple"
												name="multiselect[]" ng-model="generalLedger.objGroupCodes"
												ng-options="option.text for option in groupHeadList"  disabled="true"
												data-dropdownmultiselect>
											
											</select>
										</div>
									</div> -->
									
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="test" >
								<fieldset>
									
									<div class="form-group"  >
										<label class="col-md-5 control-label"> Group Code</label>
										
										<div class="col-md-7">
											<select id="txtGroupCode" multiple="multiple"
												name="multiselect[]" ng-model="generalLedger.objGroupCodes"
												ng-options="option.text for option in groupHeadList"  
												data-dropdownmultiselect>
											
											</select>
										</div>
									</div>
									
								</fieldset>
							</div>


							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="!test">
								<fieldset>
									<!-- <div class="form-group" ng-if="!test">
										<label class="col-md-5 control-label"> Sub  group</label>
										<div class="col-md-7">
											<selectivity list="subGroupList1" disabled="sub"
												property="generalLedger.subGroupCode" id="subGroupCode"
												object="subGroupCode" ></selectivity>
										</div>
									</div> -->
									
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="test">
								<fieldset>
									<div class="form-group" >
										<label class="col-md-5 control-label"> Sub  group</label>
										<div class="col-md-7">
											<selectivity list="subGroupList" disabled="sub"
												property="generalLedger.subGroupCode" id="subGroupCode"
												object="subGroupCode" ></selectivity>
										</div>
									</div>
									
								</fieldset>
							</div>
							

							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="!test">
								<fieldset>
									<!-- <div class="form-group">
										<label class="col-md-5 control-label"> Main Account </label>
										<div class="col-md-7">
											<selectivity list="accountHeadList"  disabled="main"
												property="generalLedger.mainAccountCode"
												id="accountHeadCode" object="accountHeadCode"></selectivity>
										</div>
									</div> -->
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="test">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Main Account </label>
										<div class="col-md-7">
											<selectivity list="accountHeadList"  disabled="main"
												property="generalLedger.mainAccountCode"
												id="accountHeadCode" object="accountHeadCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>

							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="!test">
								<fieldset>
									<!-- <div class="form-group">
										<label class="col-md-5 control-label"> Sub Account </label>
										<div class="col-md-7">
											<selectivity list="subAccountCodeList" 
												property="generalLedger.subAccountCode" id="subAccountCode"
												object="subAccountCode"></selectivity>
										</div>
									</div> -->
								</fieldset>
							</div>
							<div class="col-sm-12 col-md-4 col-lg-4" ng-if="test">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Sub Account </label>
										<div class="col-md-7">
											<selectivity list="subAccountCodeList" 
												property="generalLedger.subAccountCode" id="subAccountCode"
												object="subAccountCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
						
						<!-- Form Action -->
						<a id="GLExport" stype="display:none"
							href="filePath/GeneralLedger.xlsx" download="GeneralLedger.xlsx"></a>
						<!-- Form Action -->
						<div class="form-actions">
							<div class="row" ng-if="!test">
							
								 <div class="col-md-12 " >
									<%-- <security:authorize access="hasRole('${form_code}_${view}')">
										<button type="button" class="btn btn-success" 
											ng-click="viewGeneralLedgerReport()">
											<i class="fa fa-search"></i>View Report
										</button>
									</security:authorize> --%>

								<security:authorize access="hasRole('${form_code}_${export}')">
										<button type="button" class="btn btn-primary" type="button"
											ng-click="exportGeneralLedgerExcelOP1()">
											<i class="fa fa-search"></i>Export Excel
										</button>
									</security:authorize>

										 <security:authorize access="hasRole('${form_code}_${export}')">
										<button type="button" class="btn btn-primary"
											ng-click="exportGeneralLedgerExcel1()">
											<i class="fa fa-search"></i>Export Excel By Account Head
										</button>
									</security:authorize>

									<security:authorize access="hasRole('${form_code}_${export}')">
										<button type="button" class="btn btn-primary"
											ng-click="exportTransactionLevelExcel1()">
											<i class="fa fa-search"></i>Export Excel OP with Transaction
										</button>
									</security:authorize>

									<!-- <button type="button" class="btn btn-info" type="reset"
										class="btn btn-success"   ng-click="formreset()">
										<i class="fa fa-undo"></i>Reset
									</button> -->
								</div> 
							</div>
							<div class="row" >
								<div class="col-md-12 " >
									<security:authorize access="hasRole('${form_code}_${view}')">
										<button type="button" class="btn btn-success" 
											ng-click="viewGeneralLedgerReport()">
											<i class="fa fa-search"></i>View Report
										</button>
									</security:authorize>

									<security:authorize access="hasRole('${form_code}_${export}')">
										<button type="button" class="btn btn-primary" type="button"
											ng-click="exportGeneralLedgerExcelOP()">
											<i class="fa fa-search"></i>Export Excel
										</button>
									</security:authorize>

									<security:authorize access="hasRole('${form_code}_${export}')">
										<button type="button" class="btn btn-primary"
											ng-click="exportGeneralLedgerExcel()">
											<i class="fa fa-search"></i>Export Excel By Account Head
										</button>
									</security:authorize>

									<security:authorize access="hasRole('${form_code}_${export}')">
										<button type="button" class="btn btn-primary"
											ng-click="exportTransactionLevelExcel()">
											<i class="fa fa-search"></i>Export Excel OP with Transaction
										</button>
									</security:authorize>

									
									<button type="button" class="btn btn-primary" type="button"
											ng-click="exportGeneralLedgerExcelOP1()">
											<i class="fa fa-search"></i>Export Excel
										</button>
								</div>
							</div>
						
						<br>
						
					 
  <div class="panel panel-default">
    
    
      <div class="panel-body">
   	<table class="table table-bordered" width="100%" role="grid">
					<thead class="dataTables-Main-Head">
						<tr class="active ">					 
							<th colspan=2 class="borderclass">Sub Group Head Code</th>
							<th colspan=2 class="borderclass">Sub Group Head Name</th>
							 <th colspan=2 class="borderclass">TC Debit</th>
							<th colspan=2 class="borderclass">TC Credit</th>
							<th colspan=1 class="borderclass">BC Debit-{{currencCode}}</th>
							<th colspan=1 class="borderclass">BC Credit- {{currencCode}}</th>
							<th colspan=1 class="borderclass">TC Balance</th>
							<th colspan=1 class="borderclass">BC Balance {{$scope.currencCode}}</th>
						</tr>
					</thead>
					<tr ng-repeat-start="objTranslationItem in geneSubgroupData">
						<td colspan=2 class="borderclass"><span class="tool-tip-span">{{objTranslationItem.subGroupCode}}</span>
						</td>
						<td colspan=2 class="borderclass"><span class="tool-tip-span">{{objTranslationItem.subGroupName}}</span>
						</td>
				 
						<td colspan=2 class="borderclass"><span class="tool-tip-span">{{objTranslationItem.tcDebit}}</span>
						</td>
						<td colspan=2 class="borderclass"><span class="tool-tip-span">{{objTranslationItem.tcCredit}}</span>
						</td>
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTranslationItem.bcDebit}}</span>
						</td>
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTranslationItem.bcCredit}}</span>
						</td>
								<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTranslationItem.currentTCBalance}}</span>
						</td>
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTranslationItem.currentBalance}}</span>
						</td>	
						 
					</tr>
				  

				  
					<tr class="active" 
						ng-repeat-start="(tIndex, objTransrowItem) in objTranslationItem.lGeneralLedgerAHList">
						<th></th>
						<th colspan=2 class="borderclass">Acct Head Code</th>
						<th colspan=2 class="borderclass">Acct Head Name</th>
						<th colspan=1 class="borderclass">TC Debit</th>
						<th colspan=1 class="borderclass">TC Credit</th>
						<th colspan=1 class="borderclass">BC Debit</th>
						<th colspan=1 class="borderclass">BC Credit</th>
						<th colspan=1 class="borderclass">TC Balance</th>
						<th colspan=1 class="borderclass">BC Balance</th>
						<th colspan=1 class="borderclass">Actions</th> 

					</tr>
					<tr>
					    <td> 
					    
					      <button id="plus{{tIndex}}" style="display: none" ng-click="doubleshowTable(tIndex,objTransrowItem.accountHeadCode,'plus',objTransrowItem.showaccounthead,objTranslationItem.lGeneralLedgerAHList)" class="btn btn-primary" type="button" tooltip="Add">
         <i class="fa fa-plus"></i>
        </button>
         <button id="minus{{tIndex}}" style="display: block" ng-click="doubleshowTable(tIndex,objTransrowItem.accountHeadCode,'minus',objTransrowItem.showaccounthead,objTranslationItem.lGeneralLedgerAHList)" class="btn btn-primary" type="button"   tooltip="Add">
         <i class="fa fa-minus"></i>
        </button>
					    </td>
						<td colspan=2 class="borderclass">{{objTransrowItem.accountHeadCode}}</td>
						<td colspan=2 class="borderclass">{{objTransrowItem.accountHeadName}}</td>
						<td colspan=1 class="borderclass">{{objTransrowItem.tcDebit}}</td>
						<td colspan=1 class="borderclass">{{objTransrowItem.tcCredit}}</td>
					 
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTransrowItem.bcDebit}}</span>
							<br> <span>{{objTransrowItem.address}}</span></td>
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTransrowItem.bcCredit}}</span>
						</td>
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTransrowItem.currentTCBalance}}</span>
						</td>
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTransrowItem.currentBalance}}</span>
						</td>
						<td>
						<button class="btn btn-info" type="button" ng-click="exportGeneralLedgerExcelAccountHead(objTransrowItem.accountHeadCode)" tooltip="File Upload">
         <i class="fa fa-file-excel-o"></i>  
        </button></td>
					 
					</tr>
					
				 	<tr class="active"
										ng-show="objTransrowItem.showaccounthead==objTransrowItem.accountHeadCode"
										ng-hide="objTransrowItem.showaccounthead!=objTransrowItem.accountHeadCode">
						<th class="borderclass">Voucher No</th>
						<th class="borderclass">Ledger Dt</th>
						<th class="borderclass">Party Inv No</th>
						<th class="borderclass">SA Name</th>
						<th class="borderclass">Currency</th>
						<th class="borderclass">Ex-Rate</th>
						<th class="borderclass">TC Debit</th>
						<th class="borderclass">TC Credit</th>
						<th class="borderclass">BC Debit</th>
						<th class="borderclass">BC Credit</th>
						<th class="borderclass">Status</th>
						<th class="borderclass">Allocated t</th>
						
					</tr>
					<tr  ng-hide="objTransrowItem.showaccounthead!=objTransrowItem.accountHeadCode"
										ng-show="objTransrowItem.showaccounthead==objTransrowItem.accountHeadCode" ng-repeat="objTranshandsonItem in objTransrowItem.lGeneralLedgerTransactionList"
						>
						<td class="width_20 borderclass"><span
							class="tool-tip-span">{{objTranshandsonItem.transactionNo}}</span></td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.ledgerDate}}</span>
						</td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.partyInvoiceNo}}</span>
						</td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.subAccountName}}</span>
						</td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{
								objTranshandsonItem.currency}}</span></td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.exchangeRate}}</span>
						</td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.tcDebit}}</span>
						</td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.tcCredit}}</span>
						</td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.bcDebit}}</span>
						</td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.bcCredit}}</span>
						</td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.allocationStatus}}</span>
						</td>
						<td class="width_6 borderclass"><span class="tool-tip-span">{{objTranshandsonItem.allocatedTo}}</span>
						</td>
					</tr>
 

					<tr ng-repeat-end></tr>
					<tr ng-repeat-end></tr>
					<tr ng-repeat-end></tr>
				</table>
       
   
  </div>
</div>

 


					</form>
				</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel-default -->
			<br> <br> <br> <br> <br> <br> <br>
			<br>
			<br> <br> <br> <br> <br> <br> <br>
			<br>
		</div>

	
	
	<div id="generalLeddialog" class="modal">

<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting" st-sort="jobNo">Voucher No</th>
							<th class="sorting" st-sort="jobDt">Ledger DATE</th>
							<th class="sorting" st-sort="custName">Party Invoice No</th>
							<th class="sorting" st-sort="aolName">SA Name</th>
							<th class="sorting" st-sort="aodName">Currency</th>
							<th class="sorting" st-sort="originName">Ex-Rate</th>
							<th class="sorting" st-sort="destinationName">TC Debit</th>
							<th class="sorting" st-sort="createdBy">BC Debit</th>
							<th class="sorting" st-sort="createdOn">Status</th>
							<th class="sorting" st-sort="modifiedBy">Allocated to</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="booking in displayedCollection">
					        <td>{{test}}</td>
							<td>{{booking.jobDt}}</td>
							<td>{{booking.custName}}</td>
							<td>{{booking.aolName}}</td>
							<td>{{booking.aodName}}</td>
							<td>{{booking.originName}}</td>
							<td>{{booking.destinationName}}</td>
							<td>{{booking.createdBy}}</td>
							<td>{{booking.createdOn}}</td>
							<td>{{booking.modifiedBy}}</td>
							
						</tr>
						<tr x-ng-show="showEmptyLabel">
							<td colspan="6" class="text-center">No Records Found</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
 <!-- <button class="btn btn-info" type="button" ng-click="uploadbulkAttachedFileUpload()">OK</button> -->
 <button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
  
  
</div>