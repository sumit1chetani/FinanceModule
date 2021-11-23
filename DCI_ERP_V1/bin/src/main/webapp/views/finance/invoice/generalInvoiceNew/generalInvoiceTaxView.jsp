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
<!-- <div class="wrapper-md">
	
<div class="panel-body float-left padding-0" st-table="displayedCollection" st-safe-src="rowCollection">
	<form name="purchaseInvoiceDueDateForm" class="form-horizontal" novalidate>	
		<div class="row">
	  		<div class="col-sm-12">
				<div class="table-responsive clear" ng-class="{view : isView}">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_1"></th>
									<th colspan=1  class="width_3 text-center">Tax Type Code</th>
									<th colspan=1 class="width_40 text-center">Tax Type Name</th>
									<th colspan=1 class="width_40 text-center">Tax %</th>
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="purchaseInvoiceList in displayedCollection">

								
								<td class="sorting ">{{purchaseInvoiceList.puchaseInvoiceDate}}</td>
								<td class="sorting ">{{purchaseInvoiceList.jobName}}</td>
								<td class="sorting ">{{purchaseInvoiceList.party}}</td>

							</tr>
						</tbody>
						</table>
						
						
					</div>		 
			</div>
		</div> /row
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
</div> -->

<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		
			<div class="panel panel-default">
			<div class="form-body form-horizontal">
				<div class="row m-t-sm"></div>
			</div>
			<div class="panel-body float-left padding-0" style="width: 100%">
				<div class="table-responsive ">
					<table class="table table-striped table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr>

								<th >Tax Type Code</th>
								<th>Tax Type Name</th>
								<th>Tax%</th>					
							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="purchaseInvoiceList in displayedCollection">

								<td class="sorting ">{{purchaseInvoiceList.pTaxShort}}</td>
								<td class="sorting ">{{purchaseInvoiceList.pTaxName}}</td>
								<td class="sorting ">{{purchaseInvoiceList.ptaxprct}}</td>
								

							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">
			<div class="col-md-12" align="center">
				
				<button class="btn btn-danger" ng-click="cancelng()" type="button">Cancel</button>
 			</div>
 		</div>
			</div>
			<!-- /panel-body -->
		</div>
	</div>
</div>