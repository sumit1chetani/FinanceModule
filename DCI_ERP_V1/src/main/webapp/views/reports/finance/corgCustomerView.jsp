 <style>
 .ngdialog-overlay{
 
 }
 .ngdialog{
    z-index: 1000;
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
<div class="breadcrumb-wrapper ng-scope">
	
<div class="panel-body float-left padding-10" st-table="displayedCollection" st-safe-src="rowCollection1">
	<form name="purchaseInvoiceDueDateForm" class="form-horizontal" novalidate>	
		<div class="row">
	  		<div class="col-sm-12">
				 <div class="table-responsive ">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">
      <tr role="row">
									<th colspan=1  class="width_20 text-center">Customer</th>
									<th colspan=1 class="width_20 text-center">Payer</th>
									<th colspan=1 class="width_20 text-center">Invoice</th>
									<th colspan=1 class="width_20 text-center">Invoice Date</th>
									<th colspan=1 class="width_25 text-center">Invoice Amount</th> 
									<th colspan=1 class="width_25 text-center">Paid</th> 
									<th colspan=1 class="width_25 text-center">Balance</th> 
								</tr>
							</thead>
       <tbody class="tr-tbody"  data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="(trIndex, row) in displayedCollection">
								<tr ng-show="row.invoiceDt=='Total'">
								<td class = "body"></td>
								<td class="text-right body"></td>
								<td class="text-right body"></td>
								<td class="text-left body">{{row.invoiceDt}}</td>
								<td class="text-right body">{{row.invoiceAmt}}</td>
								<td class="text-right body">{{row.paid}}</td>
								<td class="text-right body">{{row.balance}}</td></tr>
								
								  <tr ng-hide="row.invoiceDt=='Total'">
								<td class="text-left body">{{row.mloName}}</td>
								<td class="text-left body">{{row.payer}}</td>
								<td class ="text-left body">{{row.invoiceNo}}</td>
								<td class="text-left body">{{row.invoiceDt}}</td>
								<td class="text-right body">{{row.invoiceAmt}}</td>
								<td class="text-right body">{{row.paid}}</td>
								<td class="text-right body">{{row.balance}}</td>
								</tr>
								
							</tbody>
						</table>
						
						<!-- /addRow and /removeRow -->
						
					</div>	
					<footer class="panel-footer">
    	<%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>	 
			</div>
		</div> <!-- /row -->
		<div class="row">
			<div class="col-md-12" align="center">
				<button class="btn btn-danger" ng-click="cancelng()" type="button">Cancel</button>
 			</div>
 		</div>
	</form>
	<div class="row"><br></div>
  </div>
  <footer class="panel-footer">
   </footer>
</div>