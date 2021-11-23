
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-10">
				<li><a>Finance</a></li>
				<li><a>Invoice </a></li>
				<li><a x-ui-sref="">Invoice Reverse View </a></li>

			</ol>
		</div>

		<div class="panel panel-default">

			<div class="panel-body">
				<form class="form-horizontal" name="billAddForm" role="form">
					<div class="row book-widget-row">
						<div class="col-sm-12 col-md-4 col-lg-4">
							<fieldset>
								<div class="form-group">

									<label class="col-md-6 control-label">Location </label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.locationName"> </label>



								</div>


								<div class="form-group">
									<label class="col-md-6 control-label">Invoice No </label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.invoiceno"> </label>

								</div>

								<div class="form-group">
									<label class="col-md-6 control-label">Vessel</label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.vessel"> </label>
								</div>
								<div class="form-group">
									<label class="col-md-6 control-label">Voyage </label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.voyage"> </label>
								</div>







							</fieldset>
						</div>
						<div class="col-sm-12 col-md-4 col-lg-4">
							<fieldset>
							

								<div class="form-group">
									<label class="col-md-6 control-label">Date </label> <label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.invoiceDate"> </label>

								</div>



								<div class="form-group">
									<label class="col-md-6 control-label">Cust.</label><label
										class="col-md-6 text-left control-label"
										ng-bind="viewInvoiceHeader.customer"> </label> </label>


								</div>
								<div class="form-group">
									<label class="col-md-6 control-label">Payer </label>  <label
										class="col-md-6 text-left control-label" 
										ng-bind="viewInvoiceHeader.agent">

								</div>


							</fieldset>
						</div>



					</div>

					<div class="table-responsive">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan="1" class="width_1">Sl.No</th>
									<th colspan="1" class="width_20">Account Head</th>
									<!-- <th colspan="1" class="width_20">Surcharge</th> -->
									<th colspan="1" class="width_10">Amount (Local)</th>
									<th colspan="1" class="width_10">Amount (USD)</th>
								</tr>
							</thead>
							<tbody>
							<tr ng-repeat="objItem in viewInvoiceHeaderDtl">



								<td class="sorting width_10" ng-bind="objItem.slNo"></td>
								<td class="sorting width_250" ng-bind="objItem.accountHead"></td>
								<!-- <td class="sorting width_250" ng-bind="objItem.surid"></td> -->
								<td class="sorting width_15" ng-bind="objItem.amountaed"></td>
								<td class="sorting width_15" ng-bind="objItem.amountusd"></td>


</tr>
							
							</tbody>					
	


</table>
						<div class="col-md-12">
							<div class="form-group">
								<label class="col-md-6 control-label">Total</label>
								<div class="col-md-2  control-label"
									ng-bind="viewInvoiceHeader.strTotalAED"></div>
								<div class="col-md-2  control-label"
									ng-bind="viewInvoiceHeader.strTotalUSD"></div>
							</div>
						</div>
					</div>


					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" type="button" ng-click="reverseInvoice(viewInvoiceHeader.invoiceno)">
									<i class="fa fa-undo"></i> Reverse Invoice
								</button>
								<button class="btn btn-danger" ng-click="cancel()" type="button">
									<i class="fa fa-close"></i> Cancel
								</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

   <script type="text/ng-template" id="invoiceReverse">

<div class="modal-header"> Are you sure to reverse Invoice? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="ReverseConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 
 