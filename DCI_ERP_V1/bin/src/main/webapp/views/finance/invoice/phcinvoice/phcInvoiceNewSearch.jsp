<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
	</div>
	<div class="panel body">
		<form class="form-horizontal" name="phcInvoiceForm" role="form"
			novalidate>
			<div class="row book-widget-row">
				<br />
				<div class="col-sm-12 col-md-5 ol-lg-4">
					<fieldset>

						<div class="form-group form-group-label-left">
							<label class="col-md-4 col-md-offset-1 control-label ">Vessel</label>
							<div class="col-md-6">
								<selectivity list="vesselList"
									property="phcInvoiceSearch.vessel" id="vessel_code"></selectivity>
							</div>
						</div>

						<div class="form-group form-group-label-left">
							<label class="col-md-4 col-md-offset-1 control-label ">Voyage</label>
							<div class="col-md-6">
								<div id="voyage_select"
									class="selectivity-input example-input selectivity-slot voyage_sel">
									<selectivity list="voyageList"
										property="phcInvoiceSearch.voyage" id="voyage_id"></selectivity>
								</div>
							</div>
						</div>

						<div class="form-group form-group-label-left">
							<div class="row">
								<fieldset>

									<label class="col-md-5 control-label">POL</label>
									<div class="col-md-2" style="width: 19.66% !important"
										class="selectivity-input example-input selectivity-slot voyage_sel">
										<selectivity list="portList" property="phcInvoiceSearch.pol"
											id="POL"></selectivity>
									</div>



									<label class="col-md-1 control-label">POD</label>
									<div class="col-md-2" style="width: 19.66% !important">
										<selectivity list="portList" property="phcInvoiceSearch.pod"
											id="POD"></selectivity>
									</div>


								</fieldset>
							</div>
						</div>

						<div class="form-group form-group-label-left">

							<label class="col-md-4 col-md-offset-1 control-label ">Customer</label>
							<div class="col-md-6">
								<selectivity list="customerList"
									property="phcInvoiceSearch.customerCode" id="mlo_short_name"></selectivity>
							</div>
						</div>

						<div class="form-group form-group-label-left">
							<label class="col-md-4 col-md-offset-1 control-label">Bl
								No </label>
							<div class="col-md-6">
								<selectivity list="blList" property="phcinvoice.blNo" id="blNo">
							</div>
						</div>


						<div class="form-group form-group-label-left">
							<label class="col-md-4 col-md-offset-1 control-label">Payer
							</label>
							<div class="col-md-6">
								<selectivity list="payerList" property="phcinvoice.payer"
									id="payer">
							</div>
						</div>

					</fieldset>
				</div>


				<div class="col-sm-12 col-md-5 ol-lg-4">
					<fieldset>
						<div class="form-group form-group-label-left">
							<label class="col-md-4 col-md-offset-1 control-label ">Company</label>
							 <label class="  control-label">{{company}} </label> 
						</div>
						<div class="form-group form-group-label-left">
							<label class="col-md-4 col-md-offset-1 control-label ">Service</label>
							 <label class="  control-label">{{service}}</label>
						</div>
						<div class="form-group form-group-label-left">
							<label class="col-md-4 col-md-offset-1 control-label ">Activity</label>
							 <label class="  control-label">{{activity}}</label> 
						</div>

					</fieldset>
				</div>

			</div>

			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-success" type="button"
							data-ng-click="searchInvoiceDtl()">
							<i class="fa fa-search"></i> Search
						</button>
						<security:authorize access="hasRole('${form_code}_${view}')">
							<button class="btn btn-success" type="submit"
								data-ng-click="viewPhcPendingList()">View</button>
						</security:authorize>
						<button class="btn btn-info" type="button" data-ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button>
						<button class="btn btn-info" type="button" data-ng-click="exceptionList()">
							<i class="glyphicon glyphicon-list"></i> Exception List
						</button>
					</div>
				</div>
			</div>
		</form>

	</div>

	<div class="panel panel-default">
		<div class="form-body form-horizontal">
			<div class="row" align="left">
				<div class="col-md-12 ">
					<button class="btn btn-primary" type="button"
						data-ng-click="bulkPrint(rowCollection);">Bulk Print</button>
					<button class="btn btn-primary" type="button"
						data-ng-click="bulkPHCInvoiceMail(rowCollection);">Bulk
						Mail</button>
				</div>
			</div>
		</div>

		<div class="panel-body" st-table="displayedCollection"
			st-safe-src="rowCollection">
			<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer"
					width="100%" role="grid" aria-describedby="dt_basic_info">
					<thead class="dataTables-Main-Head">
						<tr role="row">
							<th class="width_1"></th>
							<th class="sorting text-center width_8">Invoice
								No</th>
							<th class="sorting text-center width_10">Date</th>
							<th class="sorting text-center width_10">Vessel</th>
							<th class="sorting text-center width_10">Voyage</th>
							<th class="sorting text-center width_10">BL No.</th>
							<th class="sorting text-center width_15">Payer</th>
							<th class="sorting text-center width_15">Cust.</th>
							<th class="width_15 text-center">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							data-ng-repeat="objListItem in displayedCollection">
							<td class="width_1"><label class="i-checks m-b-none">
									<input type="checkbox" data-ng-model="objListItem.select"
									id="select{{trIndex}}"><i></i>
							</label></td>

							<td class="width_8"><span> <a
									data-ng-click="viewPHCInvoice(objListItem.phcinvoiceCode)"> <span
										class="tool-tip-span font-blue"
										data-ng-bind="objListItem.phcinvoiceCode"></span>
								</a></span></td>
							<td class="width_10" data-ng-bind="objListItem.phcinvoiceDate"></td>
							<td class="width_10" data-ng-bind="objListItem.vesselName"></td>

							<td class="width_10" data-ng-bind="objListItem.voyage"></td>

							<td class="width_10" data-ng-bind="objListItem.blNo"></td>
							<td class="width_15" data-ng-bind="objListItem.accountName"></td>
							<td class="width_15" data-ng-bind="objListItem.mloName"></td>
							<td class="width_15"><select class="input-sm"
								data-ng-model="objListItem.printList" id="printSelect{{$index}}">
									<option value="both">Both</option>
									<option value="usd">USD</option>
									<option value="local">Local</option>
							</select> <span class="cursor-pointer padding-left-10 font-blue"><i
									class="icon-envelope red text-success"
									data-ng-click="sendPHCInvoiceMail(objListItem.phcinvoiceCode,objListItem.printList)"></i></span>
								<span
								data-ng-click="printPHCInvoice(objListItem.phcinvoiceCode,objListItem.printList)"
								id="{{objListItem.phcinvoiceCode}}"
								class=" glyphicon glyphicon-print cursor-pointer font-grey padding-left-10"></span>
								 <security:authorize access="hasRole('${form_code}_${delete}')">
								<span class="cursor-pointer  padding-left-10"> <i
									class="fa fa-trash-o text-danger-dker text"
									data-ng-click="deletePHCInvoice(objListItem.phcinvoiceCode,$index)"></i>
							</span></security:authorize></td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- /panel-body -->
	</div>
</div>
<script type="text/ng-template" id="invoiceMail">
<div class="modal-header"> Are you sure to send Email? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="SendConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>
 <script type="text/ng-template" id="exceptionListTemplate">
<style>
.ngdialog-content{
width: 81% !important;
  bottom: 160px !important;
  margin: 0 auto !important;
}
</style>

<div class="modal-header"><h3>{{headerName}}</h3> </div>
<div class="row">
<div class="width_97 m-n-auto">
	<div class="panel-body jarvis-content col-sm-12 col-md-12 col-lg-12">
			<div class="widget-body no-padding ">
				<h4>PSA Direct  Slot Billing</h4>
				<div class="table-responsive ">
					<table id="dt_basic"
						class="table table-striped table-bordered table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="width_1 text-center">IFX1</th>
								<th class="width_1 text-center">AGI</th>
								<th class="width_1 text-center">CISC</th>
								<th class="width_1 text-center">IFX2</th>
								<th class="width_1 text-center">SCS</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							<td class="bold"><ul data-ng-repeat="sectra in ifxSector"><li>{{sectra}}</li></ul></td>
							<td class="bold"><ul data-ng-repeat="sectrb in agiSector"><li>{{sectrb}}</li></ul></td>
							<td class="bold"><ul data-ng-repeat="sectrc in ciscSector"><li>{{sectrc}}</li></ul></td>
							<td class="bold"><ul data-ng-repeat="sectrd in ifx2Sector"><li>{{sectrd}}</li></ul></td>
							<td class="bold"><ul data-ng-repeat="sectre in scsSector"><li>{{sectre}}</li></ul></td>
							</tr>
						</tbody>
					</table>
				</div>
			<h4>DF</h4>
				<div class="table-responsive ">
					<table id="dt_basic"
						class="table table-striped table-bordered table-hover dataTable no-footer">
						<thead class="dataTables-Main-Head">
							<tr>
								<th class="width_1 text-center">IFX1</th>
								<th class="width_1 text-center">AGI</th>
								<th class="width_1 text-center">CISC</th>
								<th class="width_1 text-center">IFX2</th>
							</tr>
						</thead>
						<tbody>
							<tr>
							<td class="bold"><ul><li>CMA</li><li>ZIM</li><li>LOGEXPEDITOR</li><li>CULL</li></ul></td>
							<td class="bold"><ul><li>KMTC</li></ul></td>
							<td class="bold"><ul><li>BLPL</li><li>HEUNG A</li></ul></td>
							<td class="bold"><ul><li>BLPL</li></ul></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>	
</div>
</div>
<div class="modal-footer">
	<button class="btn btn-danger" ng-click="closeHelpDialog()">Close</button>
</div>
 </script> 