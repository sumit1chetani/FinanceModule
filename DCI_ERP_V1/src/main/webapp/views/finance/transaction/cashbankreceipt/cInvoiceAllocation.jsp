<div class="wrapper-md">
	<div class="panel panel-default">
		<div class="panel-heading font-bold">Invoice Allocation</div>
		<div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Company</label>
							<div class="col-md-6">
								<selectivity list="companyList"
									property="invoiceAllocation.companyCode" id="companyCode"
									></selectivity>
							</div>
						</div>
					</fieldset>
				</div>
				
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Inv Company</label>
							<div class="col-md-6">
								<selectivity list="companyList"
									property="invoiceAllocation.invcompanyCode" id="invcompanyCode"
									></selectivity>
							</div>
						</div>
					</fieldset>
				</div>
				
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Customer</label>
							<div class="col-md-6">
								<selectivity list="customerList"
									property="invoiceAllocation.customerCode" id="customerCode"
									></selectivity>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label">Receipt</label>
							<div class="col-md-6">
								<selectivity list="receiptList"
									property="invoiceAllocation.receiptCode" id="receiptNo"></selectivity>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<div class="form-group hidden-group">
							<label class="col-md-5 control-label">Advance TC Amount({{currencyCode}})</label>
							<div class="col-md-6">
								<input type="text" data-ng-model="balanceAmountTC" readonly
								class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
							</div>
						</div>
				</div>
				
				<div class="col-sm-12 col-md-4 col-lg-4 ">
					<div class="form-group hidden-group">
							<label class="col-md-5 control-label">Advance Amount(USD)</label>
							<div class="col-md-6">
								<input type="text" data-ng-model="invoiceAllocation.balanceAmount" readonly
								class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
							</div>
						</div>
				</div>
				
				
			</div>
		</div>
	</div>
	
	 <div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
   <div class="table-responsive" >
  
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">     	
      <tr role="row">
       <th class="width_1"></th>
       <th class="sorting width_9" st-sort="transno">Invoice No</th>
       <th class="sorting width_14" st-sort="bookcheque">Invoice Amt</th>
       <th class="sorting width_9" st-sort="chequedt">Currency</th>
       <th class="sorting width_9" st-sort="chequedt">Ex-Rate</th>
       <th class="sorting width_9" st-sort="chequedt">Received Amt</th>
       <th class="sorting width_9" st-sort="bookdr">Balance Amt</th>
       <th class="sorting width_9" st-sort="bookcr">Paid TC Amt</th>
       <th class="sorting width_9" st-sort="bookcr">Paid BC Amt</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objTranslationItem) in displayedCollection">
       <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="objTranslationItem.select" id="select{{trIndex}}" ng-change="calculateTotalAmountForIA()"><i></i></label></td>
       <td>
         <span tooltip="{{objTranslationItem.invoiceNo}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceNo"></span>
       </td>
        <td>
        <span tooltip="{{objTranslationItem.invoiceAmount}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceAmount"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.currencyCode}}" class="tool-tip-span" ng-bind="objTranslationItem.currencyCode"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.exchangeRate}}" class="tool-tip-span" ng-bind="objTranslationItem.exchangeRate"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.receivedAmount}}" class="tool-tip-span" ng-bind="objTranslationItem.receivedAmount"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.balanceAmount}}" class="tool-tip-span" ng-bind="objTranslationItem.balanceAmount"></span>
       </td>
       <td>
        <input type="text" class="form-control input-sm input-remarks" name="paidTCAmount{{trIndex}}" id="paidTCAmount{{trIndex}}"   ng-model="objTranslationItem.paidTCAmount" ng-keyup= "calculateBCAmountForIA(objTranslationItem)" />
       </td>
       <td>
        <input type="text" class="form-control input-sm input-remarks" name="paidBCAmount{{trIndex}}" id="paidBCAmount{{trIndex}}"   ng-model="objTranslationItem.paidBCAmount" ng-keyup= "calculateTCAmountForIA(objTranslationItem)" />
       </td>
      </tr>
     </tbody>
    </table>
   </div>
  
  
 
   <div class="row"><br></div>
    <div class="row">
    					<div class="form-group pull-right">
						<div class="col-sm-12 col-md-12 col-lg-12">
   								<label class="col-md-7 control-label"> Exchange Gain/Loss</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										ng-model="exchangeLoss" 
										name="Exchange Loss">
								</div>
						</div>
						</div>
	</div>
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
   <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   					<button class="btn btn-success" id="allocateInvoice" ng-click="allocateInvoice(displayedCollection)" type="button">Allocate Invoices</button>
   				
   					<button class="btn btn-danger" ng-click="cancel()" type="button">Cancel</button>
   				</div>
   			</div>
   	</div>
  </div>
</div>