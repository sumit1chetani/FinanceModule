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
       <th class="sorting width_8 padding-both-side-5" st-sort="companyName">Company</th>
       <th class="sorting width_12 padding-both-side-5" st-sort="voucherNo">Voucher No</th>
       <th class="sorting width_12 padding-both-side-5" st-sort="voucherDate">Voucher Date</th>
       <th class="sorting width_15 padding-both-side-5" st-sort="paidTo">Sub Account Code</th>
       <th class="sorting width_7 padding-both-side-5" st-sort="tcAmount">Tc Amount</th>
       <th class="sorting width_7 padding-both-side-5" st-sort="bcAmount">Bc Amount</th>
      </tr>
      
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objPaymentInformationItem) in displayedCollection">
       <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="objPaymentInformationItem.select" id="select{{trIndex}}" ng-change="calculateBCAmountForTDS(objPaymentInformationItem)"><i></i></label></td>
       <td tooltip="{{objPaymentInformationItem.companyName}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.companyName">
       </td>
       <td tooltip="{{objPaymentInformationItem.voucherNo}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.voucherNo">
       </td>
       <td tooltip="{{objPaymentInformationItem.voucherDate}}" class="tool-tip-span padding-both-side-2" ng-bind="objPaymentInformationItem.voucherDate">
       </td>
       <td tooltip="{{objPaymentInformationItem.paidTo}}" class="tool-tip-span" ng-bind="objPaymentInformationItem.paidTo">
       </td>
       <td  tooltip="{{objPaymentInformationItem.tcAmount}}" class="tool-tip-span" ng-bind="objPaymentInformationItem.tcAmount">
       </td>
       <td  tooltip="{{objPaymentInformationItem.bcAmount}}" class="tool-tip-span" ng-bind="objPaymentInformationItem.bcAmount">
       </td>

      </tr>
     </tbody>
    </table>
   </div>
  
 	<div class="row"><br></div>
    <div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="form-group pull-right">
								
								<label class="col-md-3 control-label"> Total TC Amount</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										ng-model="totalTCAmount" readonly
										name="TC Total">
								</div>
								
								<label class="col-md-3 control-label"> Total BC Amount</label>
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
					<button class="btn btn-success" ng-if="unmapflagTDS == true" ng-click="unmapTDS(objTranslationItem.receiptcode)" type="button">UnMap</button>
	   					<button class="btn btn-success" ng-click="saveTDSDtl(displayedCollection)" type="button">submit</button>
	   				
	   					<button class="btn btn-danger" ng-click="cancelng()" type="button">Cancel</button>
	   				</div>
	   			</div>
	</div>
  </div>
  <footer class="panel-footer">
   </footer>
</div>


<script type="text/ng-template" id="unmapPaymentTDS">

<div class="modal-header"> Are you sure you want to unmap invoices?  </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="UnMapConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>