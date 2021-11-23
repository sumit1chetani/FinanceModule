<style>
.custom-col-md-6 {
	padding-right: 0px;
	padding-left: 0px;
}

.custom-col-md-3 {
	padding-right: 25px;
}
</style>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="purchaseInvoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<input type="hidden" ng-model="purchaseinvoice.ExchangeRateFrom"
						id="ExchangeRateFrom" /> <input type="hidden"
						ng-model="purchaseinvoice.ExchangeRateTo" id="ExchangeRateTo" /> <input
						type="hidden" ng-model="purchaseinvoice.currencyValue"
						id="currencyValue" /> <input type="hidden"
						ng-model="purchaseinvoice.fraction" id="fraction" />

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Company<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
									<selectivity list="bankList"
											ng-model="purchaseinvoice.bank" validation="required" friendly-name="Bank"
											property="purchaseinvoice.bank" id="Bank"
											 name="Bank" form-name="purchaseInvoiceForm"></selectivity>
										<!-- <selectivity  list="company"
											property="purchaseinvoice.companyCode" name="companyCode"
											ng-model="purchaseinvoice.companyCode" 
											friendly-name="Company" form-name="purchaseInvoiceForm"></selectivity> -->
									</div>
									
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Invoice
										Date<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="purchaseinvoice.invoiceDt"
											id="invoiceDt" name="invoiceDt"
											form-name="purchaseInvoiceForm"
											data-ng-change="checkDatesCL(purchaseInvoice.invoiceDt)"
											friendly-name="Invoice Date" validation="required" />
										
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Currency<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="currencyList"
											property="purchaseinvoice.currencyHdr" id="currencyHdr"
											name="currencyHdr" ng-model="purchaseinvoice.currencyHdr"
											validation="required" friendly-name="currency"
											form-name="purchaseInvoiceForm"></selectivity>
                                	</div>
								</div>
							</div>
							
							<!-- <div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Mode<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity  list="modeList"
											property="purchaseInvoice.mode" name="mode"
											ng-model="purchaseInvoice.mode" validation="required"
											friendly-name="Mode" form-name="purchaseInvoiceForm"></selectivity>
									</div>
									
								</div>
							</div> -->
						</fieldset>
					</div>
<div class="col-sm-12">
						<fieldset>
 <div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="purchaseinvoice.vessel"
											 friendly-name="vessel"
											property="purchaseinvoice.vessel" id="vessel" name="vessel" disabled="isEdit"
											form-name="purchaseInvoiceForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage<span
										style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="purchaseinvoice.voyage"
											 friendly-name="Voyage"
											property="purchaseinvoice.voyage" id="Voyage" name="Voyage" disabled="isEdit"
											form-name="purchaseInvoiceForm"></selectivity>
									</div>
								</div>
							</div>
							
							
						</fieldset>
					</div>
					
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Supplier<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="customerList"
											property="purchaseinvoice.customer" id="customer"
											name="customer" ng-model="purchaseinvoice.customer"
											validation="required" friendly-name="Customer"
											form-name="purchaseInvoiceForm"></selectivity>
                                	</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Party Invoice no.<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
									<input type="text" class="form-control input-sm" ng-model="purchaseinvoice.partyInvNo" 
										name="partyInvNo" validation="required" friendly-name="partyInvNo">
									<!-- <input type="text" class="form-control input-sm" ng-model="purchaseinvoice.partyInvNo" 
										name="Party Invoice No."  > -->
										<!-- <selectivity list="bankList"
											ng-model="purchaseinvoice.bank" validation="required" friendly-name="Bank"
											property="purchaseinvoice.bank" id="Bank"
											 name="Bank" form-name="purchaseInvoiceForm"></selectivity> -->
									</div>
								</div>
							</div>
						     
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Ex-Rate <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
									<input type="text" class="form-control input-sm" ng-model="purchaseinvoice.exRate" ng-blur="checkExRate()"
										name="exRate" validation="required" friendly-name="Ex-Rate">
										
									</div>
								</div>
							</div>
						
							
						</fieldset>
					</div>

					
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks</label>
									<div class="col-md-7">
										<textarea rows="2" cols="4"
											class="form-control resize-vertical" name="remarks"
											ng-model="purchaseinvoice.remarks">
           									</textarea>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Narration </label>
									<div class="col-md-7">
									<textarea rows="2" cols="4"
										class="form-control resize-vertical" name="narration"
										ng-model="purchaseinvoice.narration">
           									</textarea>
           									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Vendor Invoice
										Date<span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="purchaseinvoice.vendorInvoiceDate"
											id="vendorInvoiceDate" name="vendorInvoiceDate"
											form-name="purchaseInvoiceForm"
											
											friendly-name="Vendor Invoice Date" validation="required" />
										
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group" ng-if="Edit">
									<label class="col-md-5 control-label">Invoice No</label>
									<div class="col-md-7">
										<input type="text" class="form-control" name="invoiceNo"
												ng-model="purchaseinvoice.invoiceNo" disabled> </>
									</div>
									
								</div>
							</div>
						<!-- 	<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Job Related</label>
									<div class="col-md-7">
										<input type="checkbox" name="triprelated" id="tripRelated"
											ng-model="purchaseInvoice.tripRelated">

									</div>
								</div>
							</div> -->
						</fieldset>
					</div>
					<!-- <div class="col-sm-12">
						<fieldset>
							
							<div class="col-md-4" ng-if="purchaseInvoice.tripRelated && purchaseInvoice.mode==1 ">
								<div class="form-group">
									<label class="col-md-5 control-label">Job<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="jobOrderList"
											property="purchaseInvoice.jobOrderNo" id="jobOrderNo"
											name="jobOrderNo" ng-model="purchaseInvoice.jobOrderNo"
											validation="required" friendly-name="jobOrderNo"
											form-name="purchaseInvoiceForm"></selectivity>


									</div>
								</div>
							</div>

                            <div class="col-md-4" ng-if="purchaseInvoice.tripRelated && purchaseInvoice.mode==1">
								<div class="form-group">
									<label class="col-md-5 control-label">POL</label>
									<div class="col-md-7">
											<selectivity list="PorthdrList" property="purchaseInvoice.Pol"
											id="Pol"></selectivity>
										<input type="text" class="form-control input-sm" id="pol"
											name="pol" disabled="disabled" ng-model="purchaseInvoice.pol" />

									</div>
								</div>
							</div>
							<div class="col-md-4" ng-if="purchaseInvoice.tripRelated && purchaseInvoice.mode==1 ">
								<div class="form-group">
									<label class="col-md-5 control-label">POD</label>
									<div class="col-md-7">
												<selectivity list="PorthdrList" property="purchaseInvoice.Pod"
											id="Pod"></selectivity>
										<input type="text" class="form-control input-sm" id="pod"
											name="pod" disabled="disabled" ng-model="purchaseInvoice.pod" />

									</div>
								</div>
							</div>

						</fieldset>
					</div>
					 -->
					<!-- <div class="col-sm-12">
						<fieldset>
							
							<div class="col-md-4" ng-if="purchaseInvoice.tripRelated && purchaseInvoice.mode==2 ">
								<div class="form-group">
									<label class="col-md-5 control-label">Job<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="seaJobOrderList"
											property="purchaseInvoice.airJobOrderNo" id="airJobOrderNo"
											name="airJobOrderNo" ng-model="purchaseInvoice.airJobOrderNo"
											validation="required" friendly-name="JobOrderNo"
											form-name="purchaseInvoiceForm"></selectivity>


									</div>
								</div>
							</div>

                           <div class="col-md-4" ng-if="purchaseInvoice.tripRelated && purchaseInvoice.mode==2">
								<div class="form-group">
									<label class="col-md-5 control-label">AOL</label>
									<div class="col-md-7">
											<selectivity list="PorthdrList" property="purchaseInvoice.Pol"
											id="Pol"></selectivity>
										<input type="text" class="form-control input-sm" id="aol"
											name="aol" disabled="disabled" ng-model="purchaseInvoice.aol" />

									</div>
								</div>
							</div>
							<div class="col-md-4" ng-if="purchaseInvoice.tripRelated && purchaseInvoice.mode==2 ">
								<div class="form-group">
									<label class="col-md-5 control-label">AOD</label>
									<div class="col-md-7">
												<selectivity list="PorthdrList" property="purchaseInvoice.Pod"
											id="Pod"></selectivity>
										<input type="text" class="form-control input-sm" id="aod"
											name="aod" disabled="disabled" ng-model="purchaseInvoice.aod" />



									</div>
								</div>
							</div>

							


						</fieldset>
					</div> -->
				</div>


				<div class="table-responsive">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
										
										<th colspan=1 class="width_12 text-center">Company<span
										style="color: red;">*</span></th>
										<th colspan=1 class="width_13 text-center">Acct Heads<span
										style="color: red;">*</span></th>
                                        <th colspan=1 class="width_8 text-center">SAC No</th>
										
										<th colspan=1 class=" width_8 text-center">Currency<span style="color: red;">*</span></th>
										<th colspan=1 class=" width_8 text-center">Ex-Rate<span style="color: red;">*</span></th>
										<th colspan=1 class=" width_8 text-center">TC Amount <span style="color: red;">*</span></th>
										<th colspan=1 class=" width_8 text-center">BC Amount <span style="color: red;">*</span></th>
										 <th colspan=1 class=" width_8 text-center" ng-if="!Edit">Total Tax %</th> 
										  <th colspan=1 class=" width_8 text-center" ng-if="Edit">Total Tax Amount</th> 
									    <!-- <th colspan=1 class=" width_8 text-center">Tax Type</th> -->
										<!-- <th colspan=1 class=" width_8 text-center">Tax Amount</th> -->
							</tr>
						</thead>

						<tbody ng-repeat="(trIndex, row) in purchaseinvoice.gidtl" ng-controller="GItableCtrl">
							<tr>
										<td><label class="i-checks m-b-none"> <input
												type="checkbox" ng-model="row.select"><i></i></label></td>

                                <td>
										    <div class="row">
												<div class="col-xs-12">
													
											    <selectivity list="bankList"
											             ng-model="row.company" 
											                  property="row.company" id="company{{trIndex}}" 
											              object="company" name="company{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Company)'}}" form-name="purchaseInvoiceForm"></selectivity>
												</div>
											</div></td>
											
											
										<td>
										    <div class="row">
												<div class="col-xs-12">
													
											    <selectivity list="chargeHeadList"
											             ng-model="row.chargeHead" 
											                  property="row.chargeHead" id="chargeHead{{trIndex}}" 
											              object="chargeHead" name="chargeHead{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Charge Heads)'}}" form-name="purchaseInvoiceForm"></selectivity>
												</div>
											</div></td>
											<td>
											<div class="row">
												<div class="col-xs-12">
												<div  class="col-xs-9 pull-left">
													<input type="text" class="form-control input-sm "
														id="sacNo{{trIndex}}" ng-model="row.sacNo"
														name="sacNo" >
												</div>
											
											<div class="col-xs-3 pull-left" ng-if="checking">
												<label class="line-height-30 cursor-pointer"
													
													data-ng-click="showContainerPopup(trIndex,row)">
													<i class="fa fa-expand"></i>
												</label>
											</div></div></div>
										</td>	
										<td>
											<div class="row">
												<div class="col-xs-12"> 
													<selectivity list="currencyList"
											             ng-model="row.currencyDtl" 
											                  property="row.currencyDtl" id="currencyDtl{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}"	
											              object="currencyDtl" name="currencyDtl{{trIndex}}" 
														 form-name="purchaseInvoiceForm"></selectivity>
												</div>
											</div>
										</td>
										
										<td>
											<div class="row">
												<div class="col-xs-12"> 
													<input type="text" class="form-control input-sm text-right"
														id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate" ng-blur="CheckExRateDtl(row.currencyDtl,trIndex,row)"
														name="exchangeRate" validation="required"  ng-keyup="calculateAmountTctoBc(purchaseinvoice.customer,purchaseinvoice.bank,row.chargeHead,row.rate,row.exchangeRate,$index,row)" friendly-name="{{ 'Row' + $index + '(Ex-Rate)'}}"
														 form-name="purchaseInvoiceForm">
												</div> 
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="rate{{trIndex}}" ng-model="row.rate"
														name="rate" validation="required"
														 ng-keyup="calculateAmountTctoBc(purchaseinvoice.customer,purchaseinvoice.bank,row.chargeHead,row.rate,row.exchangeRate,$index,row)"
														friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" >
												</div>
											</div>
										</td>
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="amount{{trIndex}}" ng-model="row.amount"
														name="amount"  validation="required"
														 ng-keyup="calculateAmount(purchaseinvoice.customer,purchaseinvoice.bank,row.chargeHead,row.amount,$index,row)"
														friendly-name="{{ 'Row' + $index + '(BC Amount)'}}" >
												</div>
											</div>
										</td>
										<td style="text-align:right;">
											<div class="row">
											<div class="col-xs-12" ng-if="!Edit" >
													<input type="text" class="form-control input-sm text-right"
														id="ttlPrct{{trIndex}}" ng-model="row.ttlPrct"
														name="ttlPrct" 
														 ng-blur="calculateAmountprct(row.ttlPrct,row.amount,$index,row)"
														friendly-name="{{ 'Row' + $index + '(Amount)'}}" >
												</div>
												<div class="col-xs-12" ng-if="Edit" >
													<input type="text" class="form-control input-sm text-right"
														id="taxAmount{{trIndex}}" ng-model="row.taxAmount"
														name="taxAmount" 
														 ng-blur="calculateAmountprct(row.ttlPrct,row.amount,$index,row)"
														friendly-name="{{ 'Row' + $index + '(Amount)'}}" disabled>
												</div>
											</div>
										</td>
								<!-- <td>
											<div class="row">
												<div class="col-xs-12" align="center">
													<button type="button" ng-click="showTax(purchaseinvoice.customer,purchaseinvoice.bank,row.chargeHead)">View
												    </button>
												</div>
											</div>
										</td> -->
										<!--  <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="taxAmount{{trIndex}}" ng-model="row.taxAmount"
														name="taxAmount" 
														friendly-name="{{ 'Row' + $index + '(Tax Amount)'}}" disabled>
												</div>
											</div>
										</td>  -->
									</tr>
									
									
								<!-- IGST -->	
									<tr ng-hide="igst">
										<td></td>

										<td style="text-align: right;">
										    <!-- <div class="row">
												<div class="col-xs-12"> -->
													{{row.igstsh}}
											    <!-- <input type="text" class="form-control input-sm text-right"
														id="igstsh{{trIndex}}" ng-model="row.igstsh"
														name="igstsh"form-name="purchaseInvoiceForm" disabled> -->
												<!-- </div>
											</div> -->
											</td>
											<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="igstnam{{trIndex}}" ng-model="row.igstnam"
														name="igstnam" disabled>
												</div>
											</div>
										</td> -->	
										<td style="text-align:right;">
											<div class="row">
												<div class="col-xs-12">
												{{row.igstper}}
													<!-- <input type="text" class="form-control input-sm text-right"
														id="igstper{{trIndex}}" ng-model="row.igstper"
														 form-name="purchaseInvoiceForm" > -->
												</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="igstper{{trIndex}}" ng-model="row.igstamt"
														form-name="purchaseInvoiceForm" disabled>
												</div>
											</div>
										</td>

									</tr>
									
									<!-- CGST -->
									<tr ng-hide="cgst">
										<td></td>

										<td style="text-align: right;">
										    <div class="row">
												<div class="col-xs-12">
													{{row.cgstsh}}
											    <!-- <input type="text" class="form-control input-sm text-right"
														id="cgstsh{{trIndex}}" ng-model="row.cgstsh"
														name="cgstsh"form-name="purchaseInvoiceForm" disabled> -->
												</div>
											</div></td>
											<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="cgstnam{{trIndex}}" ng-model="row.cgstnam"
														name="igstnam" disabled>
												</div>
											</div>
										</td> -->	
										<td style="text-align:right;">
											<div class="row">
												<div class="col-xs-12">
												{{row.cgstper}}
													<!-- <input type="text" class="form-control input-sm text-right"
														id="cgstper{{trIndex}}" ng-model="row.cgstper"
														 form-name="purchaseInvoiceForm" > -->
												</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="cgstper{{trIndex}}" ng-model="row.cgstamt"
														form-name="purchaseInvoiceForm" disabled>
												</div>
											</div>
										</td>

									</tr>
									
									<!-- SGST -->
									<tr ng-hide="sgst">
										<td></td>

										<td style="text-align: right;">
										    <div class="row">
												<div class="col-xs-12">
													{{row.sgstsh}}
											    <!-- <input type="text" class="form-control input-sm text-right"
														id="sgstsh{{trIndex}}" ng-model="row.sgstsh"
														name="sgstsh"form-name="purchaseInvoiceForm" disabled> -->
												</div>
											</div></td>
											<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="sgstnam{{trIndex}}" ng-model="row.sgstnam"
														name="sgstnam" disabled>
												</div>
											</div>
										</td>	 -->
										<td style="text-align:right;">
											<div class="row">
												<div class="col-xs-12">
												{{row.sgstper}}
													<!-- <input type="text" class="form-control input-sm text-right"
														id="sgstper{{trIndex}}" ng-model="row.sgstper"
														 form-name="purchaseInvoiceForm" > -->
												</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="sgstper{{trIndex}}" ng-model="row.sgstamt"
														form-name="purchaseInvoiceForm" disabled>
												</div>
											</div>
										</td>

									</tr>
									<tr>
								<td colspan="12">
									<div class="col-sm-12">
										<!-- Attributes list -->
										<!-- <div class="col-sm-3" >
							        	<label class="col-md-5 control-label"> Attriutes </label>
							        	</div> -->
										
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && !row.isVesselMan">
											<label class="col-md-5 control-label"> Vessel </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label"> Vessel </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}" ng-model="row.vesselCode"
													validation="required" name="vesselCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && !row.isVoyageMan">
											<label class="col-md-4 control-label"> Voyage </label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && row.isVoyageMan">
											<label class="col-md-4 control-label"> Voyage </label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}" ng-model="row.voyageCode"
													validation="required" name="txtSubAccountCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>


										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isService && !row.isServiceMan">
											<label class="col-md-5 control-label"> Service </label>
											<div class="col-md-7">
												<selectivity list="sectorList" property="row.sectorCode"
													id="sectorCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isService && row.isServiceMan">
											<label class="col-md-5 control-label"> Service </label>
											<div class="col-md-7">
												<selectivity list="sectorList" property="row.sectorCode"
													id="sectorCode{{trIndex}}" ng-model="row.sectorCode"
													validation="required" name="sectorCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Service)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isEmployee && !row.isEmployeeMan">
											<label class="col-md-5 control-label"> Employee </label>
											<div class="col-md-7">
												<selectivity list="employeeList" property="row.employeeCode"
													id="employeeCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isEmployee && row.isEmployeeMan">
											<label class="col-md-5 control-label"> Employee </label>
											<div class="col-md-7">
												<selectivity list="employeeList" property="row.isEmployee"
													id="employeeCode{{trIndex}}" ng-model="row.employeeCode"
													validation="required" name="employeeCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Employee)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isPort && !row.isPortMan">
											<label class="col-md-5 control-label"> Port</label>
											<div class="col-md-7">
												<selectivity list="portList" property="row.portCode"
													id="portCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isPort && row.isPortMan">
											<label class="col-md-5 control-label"> Port </label>
											<div class="col-md-7">
												<selectivity list="portList" property="row.portCode"
													id="portCode{{trIndex}}" ng-model="row.portCode"
													validation="required" name="portCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Port)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>

							<!-- 			<div class="col-sm-2 padding-top-5"
											ng-if="row.isPortSequence && !row.isPortSequenceMan">
											<label class="col-md-5 control-label"> Port.Seq </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="PortSequence{{trIndex}}" ng-model="row.portSequence"
													name="PortSequence" />
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isPortSequence && row.isPortSequenceMan">
											<label class="col-md-5 control-label"> Port.Seq </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="PortSequence{{trIndex}}" ng-model="row.portSequence"
													name="PortSequence" validation="required"
													friendly-name="{{ 'Row' + $index + '(Port Seq)'}}" />
											</div>
										</div> -->

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isDepartment && !row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department </label>
											<div class="col-md-7">
												<selectivity list="departmentList"
													property="row.departmentCode"
													id="departmentCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isDepartment && row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department </label>
											<div class="col-md-7">
												<selectivity list="departmentList"
													property="row.departmentCode"
													id="departmentCode{{trIndex}}"
													ng-model="row.departmentCode" 
													name="departmentCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Department)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isAgent && !row.isAgentMan">
											<label class="col-md-5 control-label"> Agent </label>
											<div class="col-md-7">
												<selectivity list="agentList" property="row.agentCode"
													id="agentCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isAgent && row.isAgentMan">
											<label class="col-md-5 control-label"> Agent </label>
											<div class="col-md-7">
												<selectivity list="agentList" property="row.agentCode"
													id="agentCode{{trIndex}}" ng-model="row.agentCode"
													validation="required" name="agentCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Agent)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isLocation && !row.isLocationMan">
											<label class="col-md-5 control-label"> Location </label>
											<div class="col-md-7">
												<selectivity list="countryList" property="row.countryCode"
													id="countryCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isLocation && row.isLocationMan">
											<label class="col-md-5 control-label"> Location </label>
											<div class="col-md-7">
												<selectivity list="countryList" property="row.countryCode"
													id="countryCode{{trIndex}}" ng-model="row.countryCode"
													validation="required" name="countryCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Location)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isCustomer && !row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer </label>
											<div class="col-md-7">
												<selectivity list="customerList" property="row.customerCode"
													id="customerCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isCustomer && row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer </label>
											<div class="col-md-7">
												<selectivity list="customerList" property="row.customerCode"
													id="customerCode{{trIndex}}" ng-model="row.customerCode"
													validation="required" name="customerCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Customer)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isSupplier && !row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier </label>
											<div class="col-md-7">
												<selectivity list="supplierList" property="row.supplierCode"
													id="supplierCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isSupplier && row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier </label>
											<div class="col-md-7">
												<selectivity list="supplierList" property="row.supplierCode"
													id="supplierCode{{trIndex}}" ng-model="row.supplierCode"
													validation="required" name="supplierCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Supplier)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isDesignation && !row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation </label>
											<div class="col-md-7">
												<selectivity list="designationList"
													property="row.designationCode"
													id="designationCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isDesignation && row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation </label>
											<div class="col-md-7">
												<selectivity list="designationList"
													property="row.designationCode"
													id="designationCode{{trIndex}}"
													ng-model="row.designationCode"
													name="designationCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Designation)'}}"
													form-name="cashbankpaymentForm">
												</selectivity>
											</div>
										</div>


										<div class="col-sm-2 padding-top-5"
											ng-if="row.isCostCenter && !row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="CostCenter{{trIndex}}" ng-model="row.costCenter"
													name="CostCenter{{trIndex}}" />
											</div>
										</div>

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isCostCenter && row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="CostCenter{{trIndex}}" ng-model="row.costCenter"
													name="CostCenter{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Designation)'}}" />
											</div>
										</div>
										<!--  commented for inter-company transaction -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isAsset">
											<label class="col-md-5 control-label"> Asset </label>
											<div class="col-md-7">
												<selectivity list="row.assetList" property="row.assetCode"
													id="assetCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
											<label class="col-md-5 control-label">Qty(MT)GO</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="QuantityGO{{trIndex}}" ng-model="row.quantityGO"
													name="QuantityGO" />
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
											<label class="col-md-5 control-label">Qty(MT)FO</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="QuantityFO{{trIndex}}" ng-model="row.quantityFO"
													name="QuantityFO" />
											</div>
										</div>
										<div class="col-sm-2 padding-top-5 padding-both-side-2"
											ng-if="row.isFromDate">
											<label class="col-md-3 control-label padding-both-side-1">Fm
												Dt</label>
											<div class="col-md-9 padding-both-side-5">
												<div class="input-group input-append date"
													id="fromDate{{trIndex}}">
													<input type="text" class="form-control input-sm"
														name="txtfromDate{{trIndex}}" id="txtfromDate{{trIndex}}"
														ng-model="row.fromDate" placeholder='dd/mm/yyyy' /> <span
														class="input-group-addon add-on"> <span
														class="glyphicon glyphicon-calendar"></span>
													</span>
												</div>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5 padding-both-side-2"
											ng-if="row.isToDate">
											<label class="col-md-3 control-label padding-both-side-1">To
												Dt</label>
											<div class="col-md-9 padding-both-side-5">
												<div class="input-group input-append date"
													id="toDate{{trIndex}}">
													<input type="text" class="form-control input-sm"
														name="txttoDate{{trIndex}}" id="txttoDate{{trIndex}}"
														ng-model="row.toDate" placeholder='dd/mm/yyyy' /> <span
														class="input-group-addon add-on"> <span
														class="glyphicon glyphicon-calendar"></span>
													</span>
												</div>
											</div>
										</div>
									</div>
								</td>
							</tr>
									
									
									<!-- <div class="panel panel-default panel-default-list"
		st-table="displayedCollection1" st-safe-src="rowCollection1">
									<div ng-if="dummy">
									<tr ng-repeat="(trIndex1, row1)in displayedCollection1">

										<td>
										    <div class="row">
												<div class="col-xs-12">
													
											    <input type="text" class="form-control input-sm "
														ng-model="row1.pTaxShort"
														name="sacNo" disabled>
												</div>
											</div></td>
											<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														 ng-model="row1.pTaxName"
														name="sacNo" disabled>
												</div>
											</div>
										</td>	
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														 ng-model="row1.ptaxprct"
														name="sacNo" disabled>
												</div>
											</div>
										</td> -
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														ng-model="row1.sacNo"
														name="sacNo" disabled>
												</div>
											</div>
										</td>
												
									</tr>
									</div>
									</div> -->
									
									
									
									
									<tr>
										<td colspan="12">
									<div class="col-sm-12">
										<!-- Attributes list -->
										
										<div class="col-sm-2 padding-top-5" ng-if="purchaseinvoice.mode==1 && row.isHBL">
											<label class="col-md-4 control-label"> HBL </label>
											<div class="col-md-8">
												<selectivity list="hblList" property="row.hbl" ng-model="row.hbl"
													id="hbl{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="purchaseinvoice.mode==1 && row.isMBL">
											<label class="col-md-4 control-label" > MBL </label>
											<div class="col-md-8">
												<selectivity list="mblList" property="row.mbl"
													id="voyageCode{{trIndex}}" ng-model="row.mbl"
													 name="mbl{{trIndex}}" >
												</selectivity>
											</div>


										</div>
										<div class="col-sm-2 padding-top-5" ng-if="purchaseinvoice.mode==2 && row.isHAWB">
											<label class="col-md-5 control-label"> HAWB </label>
											<div class="col-md-7">
												<selectivity list="hawbList" property="row.hawb"
													id="hawb{{trIndex}}" ng-model="row.hawb"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="purchaseinvoice.mode==2 && row.isMAWB">
											<label class="col-md-5 control-label"> MAWB </label>
											<div class="col-md-7">
												<selectivity list="mawbList" property="row.mawb"
													id="mawb{{trIndex}}" ng-model="row.mawb"
													name="mawb{{trIndex}}">
												</selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="purchaseInvoice.mode==2 && row.isFlightNo">
											<label class="col-md-5 control-label"> Flight No </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													ng-model="row.flightNo" name="flightNo{{trIndex}}" >
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="purchaseinvoice.mode==1 && row.isVessel">
											<label class="col-md-5 control-label"> Vessel & Voyage </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
														ng-model="row.vessel"
														name="vessel{{trIndex}}">
											</div>
										</div>	
										<div class="col-sm-2 padding-top-5" ng-if="purchaseinvoice.mode==1 && row.isContainerNo">
											<label class="col-md-5 control-label"> Container No </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
														ng-model="row.containerNo"
														name="containerNo{{trIndex}}">
											</div>
										</div>
										</div>
								</td>
										
									</tr>

						</tbody>

					</table>
                  <br><br><br><br><br><br><br>
					<div class="padding-right-5">
						<div class="col-md-4">
							<button ng-click="addRow(purchaseinvoice.gidtl)"
								class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
								type="button">
								<i class="fa fa-plus"></i>
							</button>
							<button ng-click="removeRow(purchaseinvoice.gidtl)"
								class="btn btn-sm btn-danger" type="button" tooltip="Delete">
								<i class="fa  fa-trash-o"></i>
							</button>
						</div>
						<div class="col-md-8" >
									<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total </label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right"
												ng-model="purchaseinvoice.totalAmount" readonly 
												placeholder="0.0">
										</div>

									</div>
								</div>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!Edit"
								ng-click="onSubmit(purchaseInvoiceForm,purchaseinvoice)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button"
								ng-if="Edit"
								ng-click="onSubmit(purchaseInvoiceForm,purchaseInvoice)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
							<button class="btn btn-success" type="button"
								ng-if="!Edit"
								ng-click="print(purchaseInvoiceForm,purchaseinvoice)">
								<i class="fa fa-print"></i>Print Preview
							</button>
						</div>
					</div>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>
	</div>
</div>
