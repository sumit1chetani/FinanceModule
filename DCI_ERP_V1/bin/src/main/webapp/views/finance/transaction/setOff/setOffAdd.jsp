<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="col-sm-12">
					<div class="col-sm-6">
						<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text"> Customer Company</label>
							<div class="col-md-6">
								<selectivity list="companyList" property="objSetOff.companyCode" id="companyCode" ></selectivity>
							</div>
						</div>
					</fieldset>
						<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">Customer</label>
							<div class="col-md-6">
								<selectivity list="customerList" property="objSetOff.customerCode" id="customerCode" ></selectivity>
							</div>
						</div>
					</fieldset>
						
					</div>
					
					<div class="col-sm-6">
						<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text"> Supplier Company</label>
							<div class="col-md-6">
								<selectivity list="companyList" property="objSetOff.suppliercompanyCode" id="suppliercompanyCode" ></selectivity>
							</div>
						</div>
					</fieldset>
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label  vessel-text">Supplier</label>
								<div class="col-md-6">
									<selectivity list="customerList1"
										property="objSetOff.supplierCode" id="supplierCode"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-6">
						<fieldset>
						<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Set Off
										Date 
									</label>
									<div class="col-md-6">
										<ng-bs3-datepicker data-ng-model="objSetOff.setOffDate"
											name="setofDate" form-name="objSetOffForm"
											data-ng-change="checkDatesCL(objSetOff.setOffDate)"
											friendly-name="set off Date" />
									</div>
								</div>
					</fieldset>
					</div>

				</div>
			
			</div>
		</div>
	</div>

	<div class="row">
		<div class="panel-body float-left padding-0">
			<div class="col-md-6">
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr role="row">
								<th>Customer Invoices</th>
							</tr>
						</thead>
					</table>
					<table id="dt_basic"
						class="table table-striped table-bordered table-hover dataTable no-footer"
						width="100%" role="grid" aria-describedby="dt_basic_info">
						<thead class="dataTables-Main-Head">
							<tr role="row">
								<th class="width_1"></th>

								<th class="sorting width_8 padding-both-side-2">Inv No</th>
								<th class="sorting width_4 padding-both-side-2">Cur</th>
								<th class="sorting width_5 padding-both-side-2">Ex-Rt</th>
								<th class="sorting width_9 padding-both-side-2">Bal Amt</th>
								<th class="sorting width_12 padding-both-side-2">TC Amt</th>
								<th class="sorting width_12 padding-both-side-2">BC Amt</th>
							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="(trIndex, objpendingCustomerInvoice) in pendingCustomerInvoices">
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="objpendingCustomerInvoice.select"
										id="select{{trIndex}}"
										ng-change="calculateCustomerTotalAmountForIA();"><i></i></label></td>
								<td><span tooltip="{{objpendingCustomerInvoice.invoiceNo}}"
									class="tool-tip-span"
									ng-bind="objpendingCustomerInvoice.invoiceNo"></span></td>
								<td><span
									tooltip="{{objpendingCustomerInvoice.currencyCode}}"
									class="tool-tip-span"
									ng-bind="objpendingCustomerInvoice.currencyCode"></span></td>
								<td><span
									tooltip="{{objpendingCustomerInvoice.exchangeRate}}"
									class="tool-tip-span"
									ng-bind="objpendingCustomerInvoice.exchangeRate"></span></td>
								<td><span
									tooltip="{{objpendingCustomerInvoice.balanceAmount}}"
									class="tool-tip-span"
									ng-bind="objpendingCustomerInvoice.balanceAmount"></span></td>
									<td><input type="text"
									class="form-control input-sm input-remarks"
									name="paidTCAmount{{trIndex}}" id="paidTCAmount{{trIndex}}"
									ng-model="objpendingCustomerInvoice.paidTCAmount"
									ng-keyup="calculateCustomerBCAmountForIA(objpendingCustomerInvoice)" />
								</td>
								<td><input type="text"
									class="form-control input-sm input-remarks"
									name="paidBCAmount{{trIndex}}" id="paidBCAmount{{trIndex}}"
									ng-model="objpendingCustomerInvoice.paidBCAmount"
									ng-keyup="calculateCustomerTCAmountForIA(objpendingCustomerInvoice)" />
								</td>
				
							</tr>
						</tbody>
					</table>
				</div>

				<br>
				<!--  <div class="form-group hidden-group">
		<label class="col-md-5 control-label">Disputed revenue(Customer)</label>
		<div class="col-md-6">
			<input type="text" data-ng-model="objSetOff.payerDisputedRevenue"
			class="form-control input-sm ng-pristine ng-valid ng-touched" ng-keyup="calculateCustomerTotalAmountForIA();"></input>
		</div>
	</div> -->


			</div>
			<div class="col-md-6">
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr role="row">
								<th>Supplier Invoices</th>
							</tr>
						</thead>
					</table>
					<table id="dt_basic"
						class="table table-striped table-bordered table-hover dataTable no-footer"
						width="100%" role="grid" aria-describedby="dt_basic_info">
						<thead class="dataTables-Main-Head">
							<tr role="row">
								<th class="width_1"></th>

								<th class="sorting width_8 padding-both-side-2">Inv No</th>
								<th class="sorting width_4 padding-both-side-2">Cur</th>
								<th class="sorting width_5 padding-both-side-2">Ex-Rt</th>
								<th class="sorting width_9 padding-both-side-2">Bal Amt</th>
								<th class="sorting width_12 padding-both-side-2">TC Amt</th>
								<th class="sorting width_12 padding-both-side-2">BC Amt</th>
							</tr>
						</thead>
						<tbody class="dataTables-Main-Body">
							<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
								ng-repeat="(trIndex, objpendingSupplierInvoice) in pendingSupplierInvoices">
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="objpendingSupplierInvoice.select"
										id="select{{trIndex}}"
										ng-change="calculateSupplierTotalAmountForIA()"><i></i></label></td>
								<td><span tooltip="{{objpendingSupplierInvoice.refNo}}"
									class="tool-tip-span" ng-bind="objpendingSupplierInvoice.refNo"></span>
								</td>

								<td><span
									tooltip="{{objpendingSupplierInvoice.currencyName}}"
									class="tool-tip-span"
									ng-bind="objpendingSupplierInvoice.currencyName"></span></td>
								<td><span
									tooltip="{{objpendingSupplierInvoice.exchangeRate}}"
									class="tool-tip-span"
									ng-bind="objpendingSupplierInvoice.exchangeRate"></span></td>

								<td><span tooltip="{{objpendingSupplierInvoice.payAmount}}"
									class="tool-tip-span"
									ng-bind="objpendingSupplierInvoice.payAmount"></span></td>
								<td><input type="text"
									class="form-control input-sm input-remarks"
									name="tcAmount{{trIndex}}" id="tcAmount{{trIndex}}"
									ng-model="objpendingSupplierInvoice.tcAmount"
									ng-keyup="calculateSupplierBCAmountForIA(objpendingSupplierInvoice)" />
								</td>
								<td><input type="text"
									class="form-control input-sm input-remarks"
									name="bcAmount{{trIndex}}" id="bcAmount{{trIndex}}"
									ng-model="objpendingSupplierInvoice.bcAmount"
									ng-keyup="calculateSupplierTCAmountForIA(objpendingSupplierInvoice)" />
								</td>
							</tr>
						</tbody>
					</table>
				</div>


				<br>
				<div class="form-group hidden-group">
					<div class="col-md-6">
						<selectivity list="accountList" property="objSetOff.accountCode"
							id="accountCode"></selectivity>
					</div>
					<div class="col-md-6">
						<input type="text"
							data-ng-model="objSetOff.supplierDisputedRevenue"
							class="form-control input-sm ng-pristine ng-valid ng-touched"
							ng-keyup="calculateSupplierTotalAmountForIA();"></input>
					</div>
				</div>

			</div>


		</div>
	</div>

	<br>
	<div class="row">
		<div class="col-sm-12 col-md-12 col-lg-12">
			<div class="form-group">

				<label class="col-md-3 control-label"> Customer's Total</label>
				<div class="col-md-3">
					<input type="text" class="form-control input-sm"
						ng-model="totalCustomerBCAmount" readonly name="BC Total">
				</div>

				<label class="col-md-3 control-label"> Supplier's Total</label>
				<div class="col-md-3">
					<input type="text" class="form-control input-sm"
						ng-model="totalSupplierBCAmount" readonly name="BC Total">
				</div>

			</div>
		</div>
	</div>

	<div class="form-actions">
		<div class="row">
			<div class="col-md-12">
				<button class="btn btn-success"
					ng-click="setOff(displayedCollection)" type="button">Set
					off</button>

				<button class="btn btn-danger" ng-click="cancel()" type="button">Cancel</button>
			</div>
		</div>
	</div>
</div>
