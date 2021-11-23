<div class="wrapper-md">
	<form class="form-horizontal" name="cbpManualAllocationForm" novalidate
		method="post">
		<div class="panel panel-default">
			<div class="panel-heading font-bold">Manual Allocation</div>
			<div class="form-body form-horizontal">
				<div class="row m-t-sm">
					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label  vessel-text">Company</label>
								<div class="col-md-6">
									<selectivity list="companyList"
										property="manualAllocation.companyCode" id="companyCode"
										validation="required" ng-model="manualAllocation.companyCode"
										name="companyCode" friendly-name="Company"
										form-name="cbpManualAllocationForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label  vessel-text">Supplier</label>
								<div class="col-md-6">
									<selectivity list="supllierList"
										property="manualAllocation.supplierCode" id="supplierCode"
										validation="required" ng-model="manualAllocation.supplierCode"
										name="supplierCode" friendly-name="Supplier"
										form-name="cbpManualAllocationForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label">Payment</label>
								<div class="col-md-6">
									<selectivity list="receiptList"
										property="manualAllocation.receiptCode" id="receiptNo"
										validation="required" form-name="cbpManualAllocationForm"
										ng-model="manualAllocation.receiptCode"
										friendly-name="Payment" name="receiptNo"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<div class="form-group hidden-group">
							<label class="col-md-5 control-label"> TC
								Amount</label>
							<div class="col-md-6">
								<input type="text" data-ng-model="balanceAmountTC" readonly
									class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
							</div>
						</div>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4 ">
						<div class="form-group hidden-group">
							<label class="col-md-5 control-label"> BC Amount</label>
							<div class="col-md-6">
								<input type="text"
									data-ng-model="manualAllocation.balanceAmount" readonly
									class="form-control input-sm ng-pristine ng-valid ng-touched"></input>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>

		<div class="panel-body float-left padding-0"
			st-table="displayedCollection" st-safe-src="rowCollection">
			<div class="table-responsive">

				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer"
					width="100%" role="grid" aria-describedby="dt_basic_info">
					<thead class="dataTables-Main-Head">
						<tr role="row">
							<th class="width_1"></th>
							<th class="sorting width_10 padding-both-side-5"
								st-sort="Supplier">Supplier</th>
							<!-- <th class="sorting width_3 padding-both-side-8" st-sort="DueDt">Due
								Dt</th>
							<th class="sorting width_5 padding-both-side-5"
								st-sort="PartyInvno">Party Inv no.</th>
							<th class="sorting width_7 padding-both-side-8"
								st-sort="PartyInvDt">Party Inv Dt</th> -->
							<th class="sorting width_7 padding-both-side-5" st-sort="InvNo">Inv
								No.</th>
						    <th class="sorting width_7 padding-both-side-5" st-sort="InvNo">Purchase Inv
								No.</th>
							<th class="sorting width_7 padding-both-side-8" st-sort="InvDt">Inv
								Dt.</th>
							<th class="sorting width_3 padding-both-side-5">Cur</th>
							<th class="sorting width_3 padding-both-side-5">Ex-Rt</th>
							<th class="sorting width_5 padding-both-side-5"
								st-sort="InvAmount">Inv TC Amt</th>
							<th class="sorting width_5 padding-both-side-5"
								st-sort="InvAmount">Inv BC Amt</th>
							<!-- <th class="sorting width_5 padding-both-side-5"
								st-sort="PayableAmount">Payable BC Amt</th> -->
							<th class="sorting width_7 padding-both-side-5"
								st-sort="PayAmount">Pay TC Amt</th>
							<th class="sorting width_7 padding-both-side-5"
								st-sort="PayAmount">Pay BC Amt</th>
						</tr>

					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="(trIndex, objPaymentInformationItem) in displayedCollection">
							<td><label class="width_1 i-checks m-b-none"> <input
									type="checkbox" data-ng-model="objPaymentInformationItem.select"
									id="select{{trIndex}}"
									data-ng-change="calculateTotalAmountForIA(trIndex)"><i></i></label></td>
							<td tooltip="{{objPaymentInformationItem.supplierName}}"
								class="width_10 tool-tip-span padding-both-side-2"
								data-ng-bind="objPaymentInformationItem.supplierName"></td>
							<!-- <td tooltip="{{objPaymentInformationItem.dueDate}}"
								class="width_8 tool-tip-span padding-both-side-2"
								data-ng-bind="objPaymentInformationItem.dueDate"></td>
							<td tooltip="{{objPaymentInformationItem.partyInvoiceNo}}"
								class="width_5 tool-tip-span padding-both-side-2"
								data-ng-bind="objPaymentInformationItem.partyInvoiceNo"></td>
							<td tooltip="{{objPaymentInformationItem.partyInvoiceDate}}"
								class="width_8 tool-tip-span padding-both-side-2"
								data-ng-bind="objPaymentInformationItem.partyInvoiceDate"></td> -->
							<td tooltip="{{objPaymentInformationItem.refNo}}"
								class="width_7 tool-tip-span padding-both-side-2"
								data-ng-bind="objPaymentInformationItem.refNo"></td>
							<td tooltip="{{objPaymentInformationItem.invoiceNumber}}"
								class="width_7 tool-tip-span padding-both-side-2"
								data-ng-bind="objPaymentInformationItem.invoiceNumber"></td>
									<input type="hidden" data-ng-bind="objPaymentInformationItem.invoiceNumber">
							<td tooltip="{{objPaymentInformationItem.invoiceDt}}"
								class="width_8 tool-tip-span padding-both-side-2"
								data-ng-bind="objPaymentInformationItem.invoiceDt"></td>
							<td tooltip="{{objPaymentInformationItem.currencyName}}"
								class="width_3 tool-tip-span"
								data-ng-bind="objPaymentInformationItem.currencyName"></td>
							<td tooltip="{{objPaymentInformationItem.exchangeRate}}"
								class="width_3 tool-tip-span"
								data-ng-bind="objPaymentInformationItem.exchangeRate"></td>
							<td tooltip="{{objPaymentInformationItem.tcAmount}}"
								class="width_5 tool-tip-span"
								data-ng-bind="objPaymentInformationItem.tcAmount"></td>
							<td tooltip="{{objPaymentInformationItem.bcAmount}}"
								class="width_5 tool-tip-span"
								data-ng-bind="objPaymentInformationItem.bcAmount"></td>
							<!-- <td tooltip="{{objPaymentInformationItem.pendingAmount}}"
								class="width_5 tool-tip-span"
								data-ng-bind="objPaymentInformationItem.pendingAmount"></td> -->
							<td class="width_7"><input type="text"
								class="form-control input-sm input-remarks padding-both-side-2"
								name="payTCAmount{{trIndex}}" id="payTCAmount{{trIndex}}"
								data-ng-model="objPaymentInformationItem.payTCAmount"
								data-ng-keyup="calculateBCAmount(objPaymentInformationItem,trIndex)" />
							</td>
							<td class="width_7"><input type="text"
								class="form-control input-sm input-remarks padding-both-side-2"
								name="payAmount{{trIndex}}" id="payAmount{{trIndex}}"
								data-ng-model="objPaymentInformationItem.payTCAmount"
								data-ng-keyup="calculateTCAmount(objPaymentInformationItem,trIndex)" />
							</td>

						</tr>
					</tbody>
				</table>
			</div>
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="form-group pull-right">



						<label class="col-md-3 control-label"> Total TC Amt</label>
						<div class="col-md-3">
							<input type="text" class="form-control input-sm"
								data-ng-model="totalTCAmount" readonly name="TC Total">
						</div>

						<label class="col-md-3 control-label"> Total BC Amt</label>
						<div class="col-md-3">
							<input type="text" class="form-control input-sm"
								data-ng-model="totalTCAmount" readonly name="BC Total">
						</div>

					</div>
				</div>
			</div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-success"
							data-ng-click="allocateInvoice(displayedCollection)" type="button">Allocate
							Invoices</button>

						<button class="btn btn-danger" data-ng-click="cancel()" type="button">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>