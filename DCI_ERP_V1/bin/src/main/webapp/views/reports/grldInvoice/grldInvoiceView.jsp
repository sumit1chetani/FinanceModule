<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-0">
				<li><a>Reports</a></li>
				<li><a x-ui-sref="app.master.general">GR & LD Invoice</a></li>
				<li><a>View</a></li>
			</ol>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="grldInvoiceForm" novalidate
				method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Invoice NO </label>
								<div class="col-md-5">	
								<label class="col-md-5 control-label">{{grldinvoiceData.invoiceNo}}</label>									
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Invoice Date </label>
								<div class="col-md-5">
                            	<label class="col-md-5 control-label">{{grldinvoiceData.invoiceDate}}</label>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Customer <span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
								<label class="col-md-5 control-label">{{grldinvoiceData.customer}}</label>
								</div>
							</div><div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									bank Account <span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
								<label class="col-md-5 control-label">{{grldinvoiceData.bankDtl}}</label>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Mode <span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
								<label class="col-md-5 control-label">{{grldinvoiceData.mode}}</label>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-md-4 control-label">Intra
									State</label>
								<div class="col-md-5">
									<div class="checkbox">
										<label class="i-checks"> <input type="checkbox"
											class="checkbox style-0" checked="checked"
											ng-true-value="'Y'" ng-false-value="'N'" name="intraState"
											ng-model="grldinvoiceData.intraState"> <i></i>
										</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Vessel <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
								<label class="col-md-5 control-label">{{grldinvoiceData.vessel}}</label>								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Voyage<span
									style="color: red;">*</span></label>
								<div class="col-md-5">	
							    <label class="col-md-5 control-label">{{grldinvoiceData.voyage}}</label>								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> POL <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">								
								<label class="col-md-5 control-label">{{grldinvoiceData.pol}}</label>								
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> POD <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
								<label class="col-md-5 control-label">{{grldinvoiceData.pod}}</label>
								
								</div>
								</div>
								<div class="form-group">
								<label class="col-md-4 control-label"> Carrier <!-- <span
									style="color: red;">*</span> -->
								</label>
								<div class="col-md-5">
								<label class="col-md-5 control-label">{{grldinvoiceData.carrier}}</label>
								
								</div>
								</div>
								
								<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Service Type <span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
								<label class="col-md-5 control-label">{{grldinvoiceData.type}}</label>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				<br>
				
				<div class="table-responsive clear" ng-class="{view : isView}">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
						        <th colspan=1 class="width_1"></th> 
								<th ng-hide="hide" colspan=1 class="width_10 text-center">Container Type</th>
								<th colspan=1 class="width_15 text-center">Container Number</th>
								<th colspan=1 class="width_20 text-center">Discharge Date</th>
								<th colspan=1 class="width_20 text-center">Release Date</th>
							    <th colspan=1 class="width_20 text-center">Return Date</th>
								<th colspan=1 class="width_10 text-center">GR Days</th>
							    <th colspan=1 class="width_10 text-center">GR Free Days</th>
								<th colspan=1 class="width_10 text-center">GR Amount</th>
								<th colspan=1 class="width_10 text-center">LD Days</th>
								<th colspan=1 class="width_15 text-center">LD Free Days</th>
								<th colspan=1 class="width_15 text-center">GR Amount</th>								
								<th colspan=1 class="width_1"></th> 
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in grldinvoiceData.grldInvoiceDetail"ng-controller=invoicetableCtrl	>

							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select"><i></i></label></td> 
								<td ng-hide="hide" class="">
									<div class="row">																			
											<selectivity list="containerTypeList"
										property="row.containerType" id="containerType"
										ng-model="row.containerType" name="containerType"
										form-name="grldInvoiceForm" friendly-name="containerType" disabled="true"></selectivity>										
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="containerNo" id="containerNo"
											ng-model="row.containerNo" disabled="true">
										</div>
									</div>
								</td>
								
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group input-append date" id="dischargeDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'	data-ng-model="row.dischargeDate" disabled="true" />
									</div>
									</div>
									</div>
								</td>
								
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<div class="input-group input-append date" id="releaseDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'	data-ng-model="row.releaseDate" disabled="true" />
									</div>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12"><div class="input-group input-append date" id="returnDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'	data-ng-model="row.returnDate" disabled="true" />
									</div>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="grDays" id="grDays"
											ng-model="row.grDays" disabled="true" >
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="grFreeDays" id="grFreeDays"
											ng-model="row.grFreeDays" disabled="true" >
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="grAmount" id="grAmount"
											ng-model="row.grAmount" disabled="true" >
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="ldDays" id="ldDays"
											ng-model="row.ldDays" disabled="true">
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="ldFreeDays" id="ldFreeDays"
											ng-model="row.ldFreeDays" disabled="true">
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="ldAmount" id="ldAmount"
											ng-model="row.ldAmount" disabled="true">
										</div>
									</div>
								</td>								
							</tr>	
					</table>
				
				</div>				
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Total </label>
								<div class="col-md-7">
								<label class="col-md-5 control-label">{{grldinvoiceData.totalpercentage}}</label>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> CGST(%) </label>
								<div class="col-md-7">
								<label class="col-md-5 control-label">{{grldinvoiceData.cgstpercentage}}</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> SGST(%) </label>
								<div class="col-md-7">
								<label class="col-md-5 control-label">{{grldinvoiceData.sgstpercentage}}</label>
								</div>
							</div>
								<div class="form-group">
								<label class="col-md-4 control-label"> IGST(%) </label>
								<div class="col-md-7">
							     <label class="col-md-5 control-label">{{grldinvoiceData.igstpercentage}}</label>
								</div>
							</div>							
								<div class="form-group">
								<label class="col-md-4 control-label"> Grand Total</label>
								<div class="col-md-7">
								<label class="col-md-5 control-label">{{grldinvoiceData.grandtotalpercentage}}</label>
								</div>
							</div>
							
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Total(Rounded) </label>
								<div class="col-md-7">
								<label class="col-md-5 control-label">{{grldinvoiceData.total}}</label>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> CGST </label>
								<div class="col-md-7">
								<label class="col-md-5 control-label">{{grldinvoiceData.cgst}}</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> SGST</label>
								<div class="col-md-7">
								<label class="col-md-5 control-label">{{grldinvoiceData.sgst}}</label>
								</div>
							</div>
								<div class="form-group">
								<label class="col-md-4 control-label"> IGST </label>
								<div class="col-md-7">
								<label class="col-md-5 control-label">{{grldinvoiceData.igst}}</label>
								</div>
							</div>
							
								<div class="form-group">
								<label class="col-md-4 control-label"> Grand Total(Rounded)</label>
								<div class="col-md-7">								
								<label class="col-md-5 control-label">{{grldinvoiceData.grandtotal}}</label>
								</div>
							</div>
						</fieldset>
						
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" type="reset" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
