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
			<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="trialBalanceForm" class="form-horizontal">
						<div class="row">
							
							
							<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<!-- <button class="btn btn-success" type="button" ng-if="!edit"
											ng-click="submit(quotationForm,quotation)" id="quotationsave">
											<i class="fa fa-save"></i> Save
										</button>
										<button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submitupdate(quotationForm,quotation)">
											<i class="fa fa-save"></i> Update
										</button> -->
										<button class="btn btn-info" type="button" ng-click="exportGeneralLedgerExcelAccountHead()" tooltip="File Upload">
        								 <i class="fa fa-file-excel-o"></i>  Export Excel
        								</button>
										<button class="btn btn-danger" ng-click="backpage()"
											type="button">
											<i class="fa fa-close"></i> Back
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
						
						<br>
						
					 
  <div class="panel panel-default">
    
    
      <div class="panel-body">
      
   	<table class="table table-bordered" width="100%" role="grid">
					<thead class="dataTables-Main-Head">
						<tr class="active ">					 
							<th colspan=2 class="borderclass">Acct Head Code</th>
						<th colspan=2 class="borderclass">Acct Head Name</th>
						<th colspan=2 class="borderclass">TC Debit</th>
						<th colspan=2 class="borderclass">TC Credit</th>
						<th colspan=2 class="borderclass">BC Debit</th>
						<th colspan=1 class="borderclass">BC Credit</th>
						<th colspan=1 class="borderclass">TC Balance</th>
						<th colspan=1 class="borderclass">BC Balance</th>
						
						</tr>
					</thead>
					
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat-start="objTranshandsonItem in displayedCollection">
						<td colspan=2 class="borderclass">{{objTranshandsonItem.accountHeadCode}}</td>
						<td colspan=2 class="borderclass">{{objTranshandsonItem.accountHeadName}}</td>
						<td colspan=2 class="borderclass">{{objTranshandsonItem.tcDebit}}</td>
						<td colspan=2 class="borderclass">{{objTranshandsonItem.tcCredit}}</td>
					 
						<td colspan=2 class="borderclass"><span class="tool-tip-span">{{objTranshandsonItem.bcDebit}}</span>
							<br> <span>{{objTranshandsonItem.address}}</span></td>
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTranshandsonItem.bcCredit}}</span>
						</td>
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTranshandsonItem.currentTCBalance}}</span>
						</td>
						<td colspan=1 class="borderclass"><span class="tool-tip-span">{{objTranshandsonItem.currentBalance}}</span>
						</td>
						
						 
					</tr>
				  

				  
					<tr class="active" >
						
						<th colspan=2 class="borderclass">Voucher No</th>
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
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objTranshandsonItem in objTranshandsonItem.lGeneralLedgerTransactionList">
					   
						<td  colspan=2 class="width_20 borderclass"><span
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
				</table>
       
   
  </div>
</div>

 


					</form>
				</div>
				
			</div>
			
		</div>

	
	
	