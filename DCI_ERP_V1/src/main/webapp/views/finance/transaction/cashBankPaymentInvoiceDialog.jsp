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
   <div class="table-responsive" >
  
   <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">     	
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_12 padding-both-side-5" st-sort="Supplier">Supplier</th>
       <!-- <th class="sorting width_8 padding-both-side-5" st-sort="DueDt">Due Dt</th> -->
       <th class="sorting width_8 padding-both-side-5" st-sort="PartyInvno"> Inv No</th>
              <th class="sorting width_8 padding-both-side-5" st-sort="PartyInvno"> Ref No</th>
       
       <th class="sorting width_9 padding-both-side-5" st-sort="PartyInvDt"> Inv Dt</th>
       <!-- <th class="sorting width_9 padding-both-side-5" st-sort="InvNo">Inv No.</th>
       <th class="sorting width_8 padding-both-side-5" st-sort="InvDt">Inv Dt.</th> -->
       <th class="sorting width_4 padding-both-side-5" >Cur</th>
       <th class="sorting width_7 padding-both-side-5" st-sort="InvAmount">Inv TC Amt</th>
       <th class="sorting width_7 padding-both-side-5" st-sort="InvAmount">Inv BC Amt</th>
      <!--  <th class="sorting width_7 padding-both-side-5" st-sort="InvAmount">Paid Amt</th>
       <th class="sorting width_7 padding-both-side-5" st-sort="PayableAmount">Payable Amt</th> -->
       <th class="sorting width_10 padding-both-side-5" st-sort="PayAmount">Pay Amt</th>
      </tr>
      
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objPaymentInformationItem) in displayedCollection">
       <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="objPaymentInformationItem.select" id="select{{trIndex}}" ng-change="calculateBCAmountForIA(objPaymentInformationItem)"><i></i></label></td>
       <td tooltip="{{objPaymentInformationItem.shortName}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.shortName">
       </td>
       <!-- <td tooltip="{{objPaymentInformationItem.dueDate}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.dueDate">
       </td> -->
        <td tooltip="{{objPaymentInformationItem.refNo}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.refNo">
       </td>
               <td tooltip="{{objPaymentInformationItem.invoiceNumber}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.invoiceNumber">
       
<!--             <input type="hidden" ng-bind="objPaymentInformationItem.invoiceNumber"> -->
       
       <td 
        tooltip="{{objPaymentInformationItem.invoiceDt}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.invoiceDt">
       </td>
       <!-- <td tooltip="{{objPaymentInformationItem.invoiceNo}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.invoiceNo">
       </td>
       <td  tooltip="{{objPaymentInformationItem.invoiceDate}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.invoiceDate">
       </td> -->
       <td tooltip="{{objPaymentInformationItem.currency}}" class="tool-tip-span" ng-bind="objPaymentInformationItem.currencyName">
       </td>
       <td  tooltip="{{objPaymentInformationItem.tcAmount}}" class="tool-tip-span" ng-bind="objPaymentInformationItem.tcAmount">
       </td>
       <td  tooltip="{{objPaymentInformationItem.bcAmount}}" class="tool-tip-span" ng-bind="objPaymentInformationItem.bcAmount">
       </td>
       <!-- <td  tooltip="{{objPaymentInformationItem.paidAmount}}" class="tool-tip-span" ng-bind="objPaymentInformationItem.paidAmount">
       </td>
       <td  tooltip="{{objPaymentInformationItem.pendingAmount}}" class="tool-tip-span" ng-bind="objPaymentInformationItem.pendingAmount">
       </td> -->
        <td >
        <input type="text" class="form-control input-sm input-remarks padding-both-side-2" name="payAmount{{trIndex}}" id="payAmount{{trIndex}}"   ng-model="objPaymentInformationItem.payAmount" />
       </td>
      </tr>
     </tbody>
    </table>
   </div>
  
 	<div class="row"><br></div>
    <div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="form-group pull-right">
								
								<label class="col-md-3 control-label"> Total TC Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										ng-model="totalTCAmount" readonly
										name="TC Total">
								</div>
								
								<label class="col-md-3 control-label"> Total BC Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										ng-model="totalBCAmount" readonly
										name="BC Total">
								</div>
								
							</div>
						</div>
	</div>
	
	 <div align="center">
				<div class="row">
					<div class="col-md-12">
					<button class="btn btn-success" ng-if="unmapflag == true" ng-click="unmap(objTranslationItem.receiptcode)" type="button">UnMap</button>
	   					<button class="btn btn-success" ng-click="saveInvoiceDtl(displayedCollection)" type="button">submit</button>
	   				
	   					<button class="btn btn-danger" ng-click="cancelng()" type="button">Cancel</button>
	   				</div>
	   			</div>
	</div>
  </div>
  <footer class="panel-footer">
   </footer>
</div>


  <script type="text/ng-template" id="unmapPayment">

<div class="modal-header"> Are you sure you want to unmap invoices?  </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="UnMapConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>