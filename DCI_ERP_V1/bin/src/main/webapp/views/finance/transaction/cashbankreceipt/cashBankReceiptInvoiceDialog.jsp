 <style>
 .ngdialog-overlay{
 
 }
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	    max-width: 100%;
    width: 85%;
    position: absolute;
    top: 20%;
    left: 7%;
    margin: 0 auto;
}
</style>
<div class="wrapper-md">
	
<div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
   <div align="center" ng-if="isFileUpload">
		<div class="row">
			<div class="col-md-12">
				<fieldset class="width_65 b-a">
					<legend class="width_40 b-a m-b-sm">File Upload</legend>
					<div class="form-group">
						<div class="col-md-7">
							<input type="file" class="form-control btn-primary input-sm" name="excelfile" onchange="angular.element(this).scope().uploadAgentReceiptFile(this)"  accept=".xls,.xlsx,.xlsm" />
							
						</div>
						<div class="col-md-5">
							<button class="btn btn-success btn-sm bold" ng-click="uploadAgencyReceiptInvoicePopup()" type="button">
							<i class="fa fa-upload"></i> Upload</button>
							<a class="btn btn-info btn-sm bold" href="assets/finance/AGENCY_Receipts.xlsx">
							<i class="fa fa-download"></i> Download Sample</a>							  
						</div>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
   <div class="row padding-top-10">
   <div class="col-sm-12">
		   <div class="table-responsive" >
		  
		    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
		     <thead class="dataTables-Main-Head">     	
		      <tr role="row">
		       <th class="width_1"></th>
		       <th class="sorting width_9" st-sort="transno">Invoice No</th>
		       <th class="sorting width_10" st-sort="bookcheque">Invoice Amt</th>
		       <th class="sorting width_9" st-sort="chequedt">Currency</th>
		       <!-- <th class="sorting width_9" st-sort="chequedt">Ex-Rate</th> -->
		       <th class="sorting width_9" st-sort="chequedt">Received Amt</th>
		       <th class="sorting width_9" st-sort="bookdr">Balance Amt</th>
		       <th class="sorting width_9" st-sort="bookcr">Paid TC Amt</th>
		       <th class="sorting width_9" st-sort="bookcr">Paid BC Amt</th>
		      </tr>
		     </thead>
		     <tbody class="dataTables-Main-Body">
		      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objTranslationItem) in displayedCollection">
		       <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="objTranslationItem.select" id="select{{trIndex}}" ng-change="calculateTotalAmountForIA(displayedCollection)"><i></i></label></td>
		       <td>
		         <span tooltip="{{objTranslationItem.invoiceNo}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceNo"></span>
		       </td>
		        <td class="tool-tip-span text-right">
		        <span tooltip="{{objTranslationItem.invoiceAmount}}" ng-bind="objTranslationItem.invoiceAmount"></span>
		       </td>
		       <td>
		        <span tooltip="{{objTranslationItem.currencyCode}}" class="tool-tip-span" ng-bind="objTranslationItem.currencyCode"></span>
		       </td>
		       <!-- <td class="tool-tip-span text-right">
		        <span tooltip="{{objTranslationItem.exchangeRate}}" ng-bind="objTranslationItem.exchangeRate"></span>
		       </td> -->
		       <td class="tool-tip-span text-right" >
		        <span tooltip="{{objTranslationItem.receivedAmount}}"  ng-bind="objTranslationItem.receivedAmount"></span>
		       </td>
		       <td class="tool-tip-span text-right" >
		        <span tooltip="{{objTranslationItem.balanceAmount}}" ng-bind="objTranslationItem.balanceAmount"></span>
		       </td>
		       <td>
		        <input type="text" class="form-control input-sm input-remarks text-right" name="paidTCAmount{{trIndex}}" id="paidTCAmount{{trIndex}}" data-ng-change = checkamt(objTranslationItem.invoiceAmount,objTranslationItem.paidTCAmount)  ng-model="objTranslationItem.paidTCAmount" ng-keyup= "calculateBCAmountForIA(objTranslationItem)" />
		       </td>
		       <td>
		        <input type="text" class="form-control input-sm input-remarks text-right" name="paidBCAmount{{trIndex}}" id="paidBCAmount{{trIndex}}" data-ng-change = checkamt(objTranslationItem.invoiceAmount,objTranslationItem.paidBCAmount)  ng-model="objTranslationItem.paidBCAmount" ng-keyup= "calculateTCAmountForIA(objTranslationItem)" />
		       </td>
		      </tr>
		     </tbody>
		    </table>
		   </div>
  
		 
		</div>
	</div>
		<div class="row"><br></div>
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="form-group pull-right">
					
					<label class="col-md-3 control-label"> Total TC Amt</label>
					<div class="col-md-3">
						<input type="text" class="form-control input-sm text-right"
							ng-model="totalTCAmount" readonly
							name="TC Total">
					</div>
					
					<label class="col-md-3 control-label"> Total BC Amt</label>
					<div class="col-md-3">
						<input type="text" class="form-control input-sm text-right"
							ng-model="totalBCAmount" readonly
							name="BC Total">
					</div>
					
				</div>
			</div>
		</div>
		
		
	 <div align="center">
		<div class="row">
			<div class="col-md-12">
				<div class="form-group ">
				  <!-- <label>T{{displayedCollection.receiptcode}}</label> --> 
					<button class="btn btn-success" ng-if="unmapflag == true" ng-click="unmap(objTranslationItem.receiptcode)" type="button">UnMap</button>
					<button class="btn btn-success" ng-click="saveInvoiceDtl(displayedCollection)" type="button">Submit</button>
					<button class="btn btn-danger" ng-click="cancelng()" type="button">Cancel</button>
				</div>
				
  			</div>
  		</div>
	</div>
	
	<div class="row"><br></div>
	
  </div>
  <footer class="panel-footer">
   </footer>
</div>


  <script type="text/ng-template" id="unmap">

<div class="modal-header"> Are you sure you want to unmap invoices?  </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="UnMapConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
