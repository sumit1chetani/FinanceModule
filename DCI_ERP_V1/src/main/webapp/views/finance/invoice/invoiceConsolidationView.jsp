<div class="bg-light lter b-b wrapper-md">
	<div class="row">
		<div class="col-sm-12 col-xs-12 col-md-12">
			<ol class="breadcrumb padding-left-0">
				<li><a> Finance </a></li>
				<li><a>Invoice</a></li>
				<li><a>Invoice Consolidation View</a></li>
			</ol>
		</div>
	</div>
</div>
<div class="wrapper-md">
	<div class="panel panel-default">
		<div class="panel-heading font-bold">Invoice Consolidation View</div>
		<!-- <div class="form-body form-horizontal">
				<div class="row m-t-sm">
	   <div class="col-sm-12 col-md-4 col-lg-6 ">
          <fieldset>
           <div class="form-group">
            <label class="col-md-5 control-label  vessel-text">Date</label>
            <div class="col-md-4">
	             <bootstrapdatetimepicker  property="totalInvoiceConsObj.currentDate" id="fromDate_id"></bootstrapdatetimepicker>
            </div>
           </div>
           
           <div class="form-group">
            <label class="col-md-5 control-label">Company</label>
            <div class="col-md-4 padding-bottom-10">
				<label    class="control-label"></label>

			</div>
           </div>
           
             
          </fieldset>
         </div>
         <div class="col-sm-12 col-md-4 col-lg-6">
          <fieldset>
          <div class="form-group">
            <label class="col-md-4 control-label">Voyage</label>
             <div class="col-md-4 padding-bottom-10">
				<label    class="control-label">{{totalInvoiceConsObj.voyageId}}</label>

			</div>
			</div>
            <div class="form-group">
            <label class="col-md-4 control-label">Payer</label>
             <div class="col-md-4 padding-bottom-10">
				<label    class="control-label">{{totalInvoiceConsObj.customerName}}</label>

			</div>
           </div>
           
           
          </fieldset>
         </div>
         
</div>
			</div> -->
			
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		
		<div class="panel-body float-left padding-0">
			<div class="table-responsive ">
				<table id="dt_basic"
								class="table table-striped table-bordered table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head">
									<tr>
										<th class="width_1"><label class="i-checks m-b-none">
											<input type="checkbox" name="post[]"> <i></i>
										</label></th>
										<th class="sorting width_15" st-sort="invoiceNo">Customer
											Name</th>
											<th class="sorting width_15" st-sort="voyageId">Invoice No.
											</th>
											<th class="sorting width_15" st-sort="vesselName">Invoice Date
											</th>
										<th class="sorting width_15" st-sort="companyName">Currency
										</th>
										<th class="sorting width_15" st-sort="companyName">Rate
										</th>
										<th class="sorting width_15" st-sort="companyName">Amount(Local)
										</th>
										<th class="sorting width_15" st-sort="companyName">Amount USD
										</th>
									</tr>
									
								</thead>
								<tbody>
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
										ng-repeat="objTranslationItem in displayedCollection">
									<td class=""><label class="i-checks m-b-none"> <input
									type="checkbox" name="post[]"> <i></i>
									</label></td>
										<td>{{objTranslationItem.customerName}}</td>
										<td>{{objTranslationItem.invoiceNo}}</td>
										<td>{{objTranslationItem.invoiceDate}}</td>
										<td>{{objTranslationItem.currency}}</td>
										<td>{{objTranslationItem.rate}}</td>
										<td>{{objTranslationItem.amountAED}}</td>
										<td>{{objTranslationItem.amountUSD}}</td>
										
									</tr>
									<tr>
									<td></td><td></td><td></td><td></td><td></td><td class="wpr-text-bold">Total</td><td>{{totalInvoiceConsObj.totAmountAED}}</td><td>{{totalInvoiceConsObj.totAountUSD}}</td>
									<tr>
								</tbody>
							</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>
	<div align="center">
				<div class="row panel-body m-t-sm">
					<div class="col-md-12 ">
						
						<button class="btn btn-success" type="button"
							data-ng-click="generateInvoice();">
							<i class="fa "></i> Consolidate
						</button>
						
					</div>
				</div>
			</div>
	</div>
</div>
</div>