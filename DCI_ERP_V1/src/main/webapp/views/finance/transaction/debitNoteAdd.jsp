<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-10">
				<li><a1>Finance</a1></li>
				<li><a1 x-ui-sref="app.finance.transaction">Transaction</a1></li>
				<li><a1 x-ui-sref="app.finance.transaction.debitnote">Debit
						Note</a1></li>
				<li><a1 x-ui-sref="app.finance.transaction.debitnoteform">Add</a1>
				</li>
			</ol>
		</div>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="DebitNoteForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<div class="col-lg-4 col-sm-4 col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"> Company <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<selectivity ng-if="edit" disabled="edit" list="companyList"
										ng-model="DebitNoteMasterData.companyCode"
										property="DebitNoteMasterData.companyCode" id="company_id"
										object="company" name="company_id" validation="required"
										friendly-name="Company" form-name="DebitNoteForm"></selectivity>
								</div>
								<div class="col-md-7">
									<selectivity ng-if="!edit" list="companyList"
										ng-model="DebitNoteMasterData.companyCode"
										property="DebitNoteMasterData.companyCode" id="company_id"
										object="company" name="company_id" validation="required"
										friendly-name="Company" form-name="DebitNoteForm"></selectivity>
								</div>
							</div>
                            <div class="form-group">
								<label class="col-md-5 control-label">Invoice Number <span
									style="color: red;">*</span></label>
								<div class="col-md-7 ">
									<selectivity list="invoiceNoList"
										property="DebitNoteMasterData.invoiceNo" id="txtinvoiceNo"
										object="invoices" ng-model="DebitNoteMasterData.invoiceNo"
										name="invoices" validation="required" friendly-name="Invoice"
										form-name="DebitNoteForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Narration <span
									style="color: red;">*</span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" id="narration"
										name="narration" data-ng-model="DebitNoteMasterData.narration"
										validation="required" friendly-name="Narration" />
								</div>
							</div> 



							

							<!-- <div class="form-group">
								<label class="col-md-5 control-label">Exchange Rate <span
									style="color: red;">*</span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm text-right"
										id="exchangeRate" name="exchangeRate"
										ng-model="DebitNoteMasterData.exchangeRate"
										validation="required" friendly-name="Exchange Rate"
										ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" />
								</div>
							</div> -->



						</div>
						<div class="col-lg-4 col-sm-4 col-md-4">

							<div class="form-group">
								<label class="col-md-5 control-label">Debit Note Date <span
									style="color: red;">*</span></label>
								<div class="col-md-7">
								
								<ng-bs3-datepicker
												data-ng-model="DebitNoteMasterData.debitNoteDate"
												id="debitNoteDate" name="debitNoteDate"
												form-name="DebitNoteForm"
												data-ng-change="checkDatesCL(DebitNoteMasterData.debitNoteDate)"
												friendly-name="DebitNote Date" validation="required" />
									<!-- <div class="input-group input-append date" id="dn_date">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy"
											ng-model="DebitNoteMasterData.debitNoteDate"
											id="debitNoteDate" name="debitNoteDate" validation="required"
											friendly-name="Debit note date"  data-ng-change="checkDatesCL(DebitNoteMasterData.debitNoteDate)"> <span
											class="input-group-addon add-on"> <span
											class="glyphicon glyphicon-calendar"></span>
										</span>
									</div> -->
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-5 control-label">Invoice Date</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="invoiceDate" name="invoiceDate"
										ng-model="DebitNoteMasterData.invoiceDate" required
										ng-disabled="true" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Job Order No</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="invoiceDate" name="invoiceDate"
										ng-model="DebitNoteMasterData.jobOrder" 
										ng-disabled="true" />
								</div>
							</div>
							

							<!-- <div class="form-group">
								<label class="col-md-5 control-label">Vessel</label>
								<div class="col-md-7 ">
									<input type="text" class="form-control input-sm" id="vessel"
										name="vessel" ng-model="vessel" ng-disabled="true" />
								</div>
							</div> -->
						</div>
						
						
						<div class="col-lg-4 col-sm-4 col-md-4">

                          <div class="form-group">
								<label class="col-md-5 control-label">Mode</label>
								<div class="col-md-7 ">
										<selectivity list="modeList" property="DebitNoteMasterData.mode" ng-model="DebitNoteMasterData.mode" id="mode_id" name="mode" object="mode" 
												friendly-name="Mode" form-name="DebitNoteForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Customer</label>
								<div class="col-md-7 ">
									<input type="text" class="form-control input-sm" id="customer"
										name="customer" ng-model="DebitNoteMasterData.customerName" ng-disabled="true" />
								</div>
							</div>
							<!-- <div class="form-group">
				<label class="col-md-5 control-label">Voyage</label>
				<div class="col-md-7 ">
					 <selectivity list="voyageList" property="voyage" id="txtvoyage" object="voyage"
			        name="account" ng-model="voyage"></selectivity>
				</div>
			</div> -->
							<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Currency <span
									style="color: red;">*</span></label>
								<div class="col-md-7">
								<selectivity list="currencyList"
											property="DebitNoteMasterData.currencyCode" id="currencyCode"
											name="currencyCode" ng-model="DebitNoteMasterData.currencyCode"
											validation="required" friendly-name="currency"></selectivity>
								</div>
							</div> -->
							
							<!-- <div class="form-group"  align="center">							
							<label class="col-md-5 control-label">File Upload </label>
								<div class="col-md-7">
								<div class="input-group">
								 <input type="file" class="form-control btn-primary" class="form-control input-sm" name="excelfile"
								  onchange="angular.element(this).scope().uploadFile(this)" />
								  
								  	<span class="input-group-btn ">
										<button class="btn btn-info input-sm" type="button"
											ng-click="adduploadfiles()" data-toggle="tooltip" title="Add File">
											Upload
										</button>
									</span>
									</div>
								</div>
							</div> -->
				
					<div class="col-sm-4 col-md-4 col-lg-4">
						<div class="" ng-repeat="(tIndex, filelist) in DebitNoteMasterData.files">
								<a id="tbnewExport{{tIndex}}" style="display: none"
											href="{{filelist.filepath}}/{{filelist.filename}}"
											download="{{filelist.filename}}"></a>
											<div ng-if="filelist.DebitNoteMasterData!=''">
											{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)" style="color:green">{{filelist.filename}}</a>
											</div>
											
											<div ng-if="filelist.DebitNoteMasterData==''">
											{{tIndex+1}} ) <a style="color:green">{{filelist.filename}}</a>
											<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)" data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>
										</button>
											</div>
							
							</div>
					</div>
							<!-- 	<div class="form-group ">
								<label class="col-md-5 control-label">Payer <span
									style="color: red;">*</span></label>
								<div class="col-md-7">
									<selectivity list="accountHeadList"
										property="DebitNoteMasterData.acctHeadName"
										id="txtacctHeadName" object="account" name="account"
										ng-model="DebitNoteMasterData.acctHeadName"
										validation="required" friendly-name="Customer"
										form-name="DebitNoteForm" disabled="true"></selectivity>
								</div>
							</div> -->


						<!-- 	<div class="form-group">
								<label class="col-md-5 control-label">BL No.</label>
								<div class="col-md-7 ">
									<input type="text" class="form-control input-sm"
										id="acctHeadName" name="acctHeadName" ng-model="blNo"
										ng-disabled="true" />
								</div>
							</div> -->


						</div>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<!-- <th colspan=1 class="width_1"></th> -->
								<th colspan=1 class="width_13 text-center">Charge Head <span
									style="color: red;">*</span></th>
									<th colspan=1 class="width_10 text-center">Sac No</th>
										<th colspan=1 class="width_10 text-center">Exchange Rate</th>
								<th colspan=1 class="width_10 text-center">Currency</th>
															
							
								<!-- <th colspan=1 class="width_10 text-center">Amount (INR)<span
									style="color: red;">*</span></th> -->
								<th colspan=1 class=" width_10 text-center">Amount <span style="color: red;">*</span>
								</th>
								<th colspan=1 class="width_1"></th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row) in DebitNoteMasterData.debittables"
							ng-controller="tableCtrl">
							<tr>
								<!-- <td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td> -->
								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="crdtlAcctHeadList"
												property="row.drdtlAccountHead"
												id="drdtlAccountHead{{trIndex}}" object="accHead"
												ng-model="row.drdtlAccountHead"
												name="drdtlAccountHead{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(Account Head)'}}"
												form-name="DebitNoteForm" disabled="true"></selectivity>
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="sacNo" data-ng-model="row.sacNo"
												name="sacNo{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(sacNo)'}}"
												disabled="true" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="exchangeRate" data-ng-model="row.exchangeRate"
												name="exchangeRate{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(exchangeRate)'}}"
												disabled="true" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="currency" data-ng-model="row.currency"
												name="currency{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(currency)'}}"
												disabled="true" />
										</div>
									</div>
								</td>
								<!-- <td>
									<div class="row" ng-if="!row.isSubAccountCode">
										<div class="col-xs-12">
											<selectivity list="row.subAccountCodeList"
												property="row.subAcctCode" id="subAcctCode{{$index}}"
												disabled="!row.isSubAccountCode"></selectivity>
										</div>
									</div>
									<div class="col-xs-12" ng-if="row.isSubAccountCode">
										<selectivity list="row.subAccountCodeList"
											property="row.subAcctCode" id="subAcctCode{{$index}}"
											form-name="DebitNoteForm" ng-model="row.subAcctCode"
											name="{{ 'SubAccount' + $index }}" validation="required"
											friendly-name="{{ 'Row' + $index + '(Sub Account)'}}"></selectivity>
									</div>
								</td> -->

								<!-- <td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												data-ng-model="row.dtlNarration" name="Narrtion{{trIndex}}"
												validation="required"
												friendly-name="{{ 'Row' + $index + '(Narration)'}}" />
										</div>
									</div>
								</td> -->
								<!-- <td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												data-ng-model="row.tcAmount" step="0.01"
												ng-keyup="bcamountCalculation(row.currency,row.tcAmount,trIndex,row,row.cgstper,row.igstper,row.sgstper,row.exchangeRate)"
												name="TcAmount{{trIndex}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
												friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" />
										</div>
									</div>
								</td> -->
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												data-ng-model="row.bcAmount"
												ng-keyup="tcamountCalculation(row.currency,row.bcAmount,trIndex,row,row.cgstper,row.igstper,row.sgstper,row.exchangeRate)"
												name="BcAmount{{trIndex}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
												friendly-name="{{ 'Row' + $index + '(BC Amount)'}}" />
										</div>
									</div>
								</td>
							</tr>
							<!-- IGST -->	
									<tr ng-if="row.igstsh != null && row.igstsh != ''">
										

										<td style="text-align: right;">
										   
													{{row.igstsh}}
											   
											</td>
											
										<td style="text-align:right;">
											<div class="row">
												<div class="col-xs-12">
												{{row.igstper}}
												</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="igstper{{trIndex}}" ng-model="row.igstamt"
														form-name="DebitNoteForm" disabled>
												</div>
											</div>
										</td>

									</tr>
									
									<!-- CGST -->
									<tr ng-if="row.cgstsh != null && row.cgstsh != ''">
										

										<td style="text-align: right;">
										    <div class="row">
												<div class="col-xs-12">
													{{row.cgstsh}}
											  
												</div>
											</div></td>
											
										<td style="text-align:right;">
											<div class="row">
												<div class="col-xs-12">
												{{row.cgstper}}
													</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="cgstper{{trIndex}}" ng-model="row.cgstamt"
														form-name="DebitNoteForm" disabled>
												</div>
											</div>
										</td>

									</tr>
									
									<!-- SGST -->
									<tr ng-if="row.sgstsh != null && row.sgstsh != ''">
										

										<td style="text-align: right;">
										    <div class="row">
												<div class="col-xs-12">
													{{row.sgstsh}}
												</div>
											</div></td>
											
										<td style="text-align:right;">
											<div class="row">
												<div class="col-xs-12">
												{{row.sgstper}}
													
												</div>
											</div>
										</td>
								
										<td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm text-right"
														id="sgstper{{trIndex}}" ng-model="row.sgstamt"
														form-name="DebitNoteForm" disabled>
												</div>
											</div>
										</td>

									</tr>
							<tr>
								<td colspan="12">
									<div class="col-sm-12">

										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && !row.isVoyageMan">
											<label class="col-md-5 control-label"> Job Order No. </label>
											<div class="col-md-7">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && row.isVoyageMan">
											<label class="col-md-4 control-label"> Job Order No. </label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}" ng-model="row.voyageCode"
													validation="required" name="txtSubAccountCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
													form-name="DebitNoteForm"> </selectivity>
											</div>


										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && !row.isVesselMan">
											<label class="col-md-5 control-label"> Truck </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label">  Truck  </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}" ng-model="row.vesselCode"
													validation="required" name="vesselCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
													form-name="DebitNoteForm"> </selectivity>
											</div>
										</div>
									<!-- 	<div class="col-sm-2 padding-top-5"
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
													form-name="DebitNoteForm"> </selectivity>
											</div>
										</div> -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
											<label class="col-md-5 control-label"> Employee </label>
											<div class="col-md-7">
												<selectivity list="employeeList" property="row.employeeCode"
													id="employeeCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<!-- <div class="col-sm-2 padding-top-5" ng-if="row.isPort">
											<label class="col-md-5 control-label"> Port </label>
											<div class="col-md-7">
												<selectivity list="portList" property="row.portCode"
													id="portCode{{trIndex}}"></selectivity>
											</div>
										</div> -->

									<!-- 	<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
											<label class="col-md-5 control-label"> Port.Seq </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="PortSequence{{trIndex}}" ng-model="row.portSequence"
													name="PortSequence" />
											</div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
											<label class="col-md-5 control-label"> Department </label>
											<div class="col-md-7">
												<selectivity list="departmentList"
													property="row.departmentCode"
													id="departmentCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
											<label class="col-md-5 control-label"> Agent </label>
											<div class="col-md-7">
												<selectivity list="agentList" property="row.agentCode"
													id="agentCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
											<label class="col-md-5 control-label"> Location </label>
											<div class="col-md-7">
												<selectivity list="countryList" property="row.countryCode"
													id="countryCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
											<label class="col-md-5 control-label"> Customer </label>
											<div class="col-md-7">
												<selectivity list="customerList" property="row.customerCode"
													id="customerCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
											<label class="col-md-5 control-label"> Supplier </label>
											<div class="col-md-7">
												<selectivity list="supplierList" property="row.supplierCode"
													id="supplierCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
											<label class="col-md-5 control-label"> Designation </label>
											<div class="col-md-7">
												<selectivity list="designationList"
													property="row.designationCode"
													id="designationCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
											<label class="col-md-5 control-label"> CostCtr </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="CostCenter{{trIndex}}" ng-model="row.costCenter"
													name="CostCenter" />
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCompany">
											<label class="col-md-5 control-label"> Company </label>
											<div class="col-md-7">
												<selectivity list="companyList" property="row.companyCode"
													id="companyCode{{trIndex}}"></selectivity>
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
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<!-- <div class="padding-right-5" id="AddOrRmvebtn">
						<button type="button" ng-click="addCredRow(DebitNoteMasterData.debittables)"
							class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
							>
							<i class="fa fa-plus"></i>
						</button>
						<button type="button" ng-click="removeCredRow(DebitNoteMasterData.debittables)"
							class="btn btn-sm btn-danger" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div> -->
					<!-- /padding-right-5 - /AddOrRmvebtn -->
				</div>
				<!-- /table-responsive -->

				<!-- <div class="row">
					<div class="col-sm-12">
						<div class="form-group pull-right">
							<label class="col-md-3 control-label">Total BC Amt</label>
							<div class="col-md-3">
								<input type="text" class="form-control input-sm text-right"
									name="totalBCAmount"
									data-ng-model="debitnoteDtlTotalAmt.totalBCAmount"
									nng-pattern-restrict="^\d+(?:\.\d{0,3})?$" disabled />
							</div>
							<label class="col-md-3 control-label">Total TC Amt</label>
							<div class="col-md-3">
								<input type="text" class="form-control input-sm text-right"
									name="totalTCAmount"
									data-ng-model="debitnoteDtlTotalAmt.totalTCAmount"
									ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" disabled />
							</div>
						</div>
					</div>
				</div> -->
				<div class="col-md-12">
					<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total Amount</label>
								
										
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right ng-pristine ng-untouched ng-valid" ng-model="debitnoteDtlTotalAmt.totalTCAmount" readonly="" name="totalTCAmount" placeholder="0.0">
										</div>

									</div>
									<!-- <div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total Amount(INR)</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right ng-pristine ng-untouched ng-valid" ng-model="debitnoteDtlTotalAmt.totalBCAmount" readonly="" name="totalBCAmount"  placeholder="0.0">
										</div>

									</div> -->
								<div class="form-group" style="float: right;">
								
									<label class="col-md-6 control-label">Total Tax Amount</label>

									<div class="col-md-6">
										<input type="text" class="form-control input-sm text-right ng-pristine ng-untouched ng-valid" ng-model="debitnoteDtlTotalAmt.totaltaxAmount" readonly="" name="totaltaxAmount" placeholder="0.0">
									</div>

								</div>
								
								
							</div>

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button" ng-if="!edit"
											ng-click="submit(DebitNoteForm)">
											<!-- ng-click="onSubmit(DebitNoteForm,DebitNoteMasterData)" -->
											<i class="fa fa-save"></i> Save
										</button>
										<button type="button" class="btn btn-success" ng-if="edit"
											ng-click="submit(DebitNoteForm)">
											<i class="fa fa-save"></i> Update
										</button>
										<button class="btn btn-danger" ng-click="cancel()"
											type="button">
											<i class="fa fa-close"></i> Cancel
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
