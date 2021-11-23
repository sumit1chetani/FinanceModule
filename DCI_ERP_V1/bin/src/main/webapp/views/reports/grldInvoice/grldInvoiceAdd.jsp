<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-0">
				<li><a>Reports</a></li>
				<li><a x-ui-sref="app.master.general">GR & LD Invoice</a></li>
				<li><a>Add</a></li>
			</ol>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" name="grldInvoiceForm" novalidate
				method="post">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group" ng-if="grldinvoiceData.edit">
								<label class="col-md-4 control-label"> Invoice NO </label>
								<div class="col-md-5">
									<input type="text"class="form-control input-sm text-left" name="invoiceNoMaxCnt"	property="grldinvoiceData.invoiceNo" id="invoiceNo"
									ng-model="grldinvoiceData.invoiceNo"	friendly-name="invoiceNo" disabled="true" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Invoice Date </label>
								<div class="col-md-7">

									<div class="input-group input-append date" id="fromDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'
											data-ng-model="grldinvoiceData.invoiceDate" id="invoiceDate"property="grldinvoiceData.invoiceDate"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Customer <span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="customerList"
										property="grldinvoiceData.customer" id="customer" validation="required"
										ng-model="grldinvoiceData.customer" name="customer"
										form-name="grldInvoiceForm" friendly-name="customer"></selectivity>
								</div>
							</div><div class="form-group">
								<label for="inputPassword" class="control-label col-md-4">
									Bank Account <span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="bankAcctList"
										property="grldinvoiceData.bankDtl" id="bankDtl" validation="required"
										ng-model="grldinvoiceData.bankDtl" name="bankDtl"
										form-name="grldInvoiceForm" friendly-name="bankDtl"></selectivity>
								</div>
							</div>
							
							
							<div class="form-group" >
								<label class="col-md-4 control-label"> Mode<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									
										<selectivity list="modeList" ng-model="grldinvoiceData.mode"
											validation="required" friendly-name="Mode"
											property="grldinvoiceData.mode" id="mode" name="mode"
											form-name="deliveryorderForm"></selectivity>
										
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
									<selectivity list="vesselList"
										property="grldinvoiceData.vessel" id="vessel"
										ng-model="grldinvoiceData.vessel" name="vessel" validation="required"
										form-name="grldInvoiceForm" friendly-name="vessel"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Voyage<span
									style="color: red;">*</span></label>
								<div class="col-md-5">									
									<selectivity list="voyageList"
										property="grldinvoiceData.voyage" id="voyage"  validation="required"
										ng-model="grldinvoiceData.voyage" name="voyage"
										form-name="grldInvoiceForm" friendly-name="voyage"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> POL <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="polList" property="grldinvoiceData.pol"
										id="pol" ng-model="grldinvoiceData.pol" name="pol" validation="required"
										form-name="grldInvoiceForm" friendly-name="pol"></selectivity>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> POD <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="podList" property="grldinvoiceData.pod" validation="required"
										id="pod" ng-model="grldinvoiceData.pod" name="pod"
										form-name="grldInvoiceForm" friendly-name="pod"></selectivity>
								</div></div>
								
								
									<div class="form-group" ng-if="grldinvoiceData.mode==4">
								<label for="inputPassword" class="control-label col-md-4">
									Carrier <span style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="carrierList"
										property="grldinvoiceData.carrier" id="carrier" 
										ng-model="grldinvoiceData.carrier" name="carrier"
										form-name="grldInvoiceForm" friendly-name="carrier"></selectivity>
								</div>
							</div>
							
								<div class="form-group" ng-if="grldinvoiceData.mode!=4">
								<label for="inputPassword" class="control-label col-md-4">
									Carrier 
								</label>
								<div class="col-md-5">
									<selectivity list="carrierList"
										property="grldinvoiceData.carrier" id="carrier" 
										ng-model="grldinvoiceData.carrier" name="carrier"
										form-name="grldInvoiceForm" friendly-name="carrier"></selectivity>
								</div>
							</div>
								
							<div class="form-group">
								<label class="col-md-4 control-label"> Service Type <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="typeList" property="grldinvoiceData.type" validation="required"
										id="type" ng-model="grldinvoiceData.type" name="type" 	
										
										form-name="grldInvoiceForm" friendly-name="type"></selectivity>
								</div>
							
							</div>
							
						</fieldset>
					</div>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-primary btn-small" type="button"
								ng-click="search(grldInvoiceForm,grldinvoiceData)"
								ng-if="!grldinvoiceData.edit">
								 Search
							</button>

							
						</div>
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
								<th colspan=1 class="width_20 text-center" ng-if="grldinvoiceData.val">Discharge Date</th>
								<th colspan=1 class="width_20 text-center" ng-if="grldinvoiceData.val1">OnBoard Date</th>
								
								<th colspan=1 class="width_20 text-center">Release Date</th>
							    <th colspan=1 class="width_20 text-center">Return Date</th>
								<th colspan=1 class="width_10 text-center">GR Days</th>
							    <th colspan=1 class="width_10 text-center">GR Free Days</th>
								<th colspan=1 class="width_10 text-center">GR Amount</th>
								<th colspan=1 class="width_10 text-center">LD Days</th>
								<th colspan=1 class="width_15 text-center">LD Free Days</th>
								<th colspan=1 class="width_15 text-center">LD Amount</th>								
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
											ng-model="row.containerNo" disabled>
										</div>
									</div>
								</td>
								
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
										<div class="input-group input-append date" id="dischargeDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'	data-ng-model="row.dischargeDate" disabled/>
									</div>
									</div>
									</div>
								</td>
								
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<div class="input-group input-append date" id="releaseDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'	data-ng-model="row.releaseDate" />
									</div>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12"><div class="input-group input-append date" id="returnDate">
										<ng-bs3-datepicker placeholder='dd/mm/yyyy'	data-ng-model="row.returnDate" />
									</div>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="grDays" id="grDays"
											ng-model="row.grDays" disabled="true">
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="grFreeDays" id="grFreeDays"
											ng-model="row.grFreeDays" disabled="true">
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<input class="form-control"	type="text" name="grAmount" id="grAmount"
											ng-model="row.grAmount" disabled="true">
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
					 <div class="padding-right-5" id="AddOrRmvebtn">
           <button ng-click="addgrldRow(grldinvoiceData.grldInvoiceDetail)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
            <i class="fa fa-plus"></i>	
           </button>
           <button ng-click="removegrldRow(grldinvoiceData.grldInvoiceDetail)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
            <i class="fa  fa-trash-o"></i>
           </button>
      </div>
				
				</div>
				
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">						
							<button class="btn btn-primary btn-small" type="button"
								ng-click="totalAmountCalculation()"
								ng-if="!grldinvoiceData.edit" id="calculate">
								 Calculate
							</button>
							
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Total </label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="total"	property="grldinvoiceData.totalpercentage" id="totalpercentage"
									ng-model="grldinvoiceData.totalpercentage"	friendly-name="totalpercentage" disabled="true"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> CGST(%) </label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="cgstpercentage"	property="grldinvoiceData.cgstpercentage" id="cgstpercentage"
									ng-model="grldinvoiceData.cgstpercentage"	friendly-name="cgstpercentage" disabled="true" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> SGST(%) </label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="sgstpercentage"	property="grldinvoiceData.sgstpercentage" id="sgstpercentage"
									ng-model="grldinvoiceData.sgstpercentage"	friendly-name="sgst" disabled="true"  />
								</div>
							</div>
								<div class="form-group">
								<label class="col-md-4 control-label"> IGST(%) </label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="igstpercentage"	property="grldinvoiceData.igstpercentage" id="igstpercentage"
									ng-model="grldinvoiceData.igstpercentage"	friendly-name="igstpercentage"  disabled="true"/>
								</div>
							</div>							
								<div class="form-group">
								<label class="col-md-4 control-label"> Grand Total</label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="grandtotalpercentage"	property="grldinvoiceData.grandtotalpercentage" id="grandtotalpercentage"
									ng-model="grldinvoiceData.grandtotalpercentage"	friendly-name="grandtotalpercentage"  disabled="true"/>
								</div>
							</div>
							
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Total(Rounded) </label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="total"	property="grldinvoiceData.total" id="total"
									ng-model="grldinvoiceData.total"	friendly-name="total" disabled="true" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> CGST </label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="cgst"	property="grldinvoiceData.cgst" id="cgst"
									ng-model="grldinvoiceData.cgst"	friendly-name="cgst" disabled="true" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> SGST</label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="sgst"	property="grldinvoiceData.sgst" id="sgst"
									ng-model="grldinvoiceData.sgst"	friendly-name="sgst" disabled="true" />
								</div>
							</div>
								<div class="form-group">
								<label class="col-md-4 control-label"> IGST </label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="igst"	property="grldinvoiceData.igst" id="igst"
									ng-model="grldinvoiceData.igst"	friendly-name="igst"  disabled="true"/>
								</div>
							</div>
							
								<div class="form-group">
								<label class="col-md-4 control-label"> Grand Total(Rounded)</label>
								<div class="col-md-7">
									<input type="text"class="form-control input-sm text-left" name="grandtotal"	property="grldinvoiceData.grandtotal" id="grandtotal"
									ng-model="grldinvoiceData.grandtotal"	friendly-name="grandtotal"  disabled="true"/>
								</div>
							</div>
							
						</fieldset>
					</div>
				</div>
				
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-click="save(grldInvoiceForm,grldinvoiceData)"
								ng-if="!grldinvoiceData.edit">
								<i class="fa fa-save"></i> Save
							</button>

							<button class="btn btn-success" type="button"
								ng-if="grldinvoiceData.edit"
								ng-click="update(grldInvoiceForm,grldinvoiceData)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								ng-if="!grldinvoiceData.edit" ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>

							<button class="btn btn-info" type="button"
								ng-if="grldinvoiceData.edit" ng-click="reset1()">
								<i class="fa fa-undo"></i> Reset
							</button>
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
