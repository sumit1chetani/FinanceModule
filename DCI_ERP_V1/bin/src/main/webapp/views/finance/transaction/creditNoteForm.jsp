
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="creditNoteForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<div class="col-sm-4">

							<div class="form-group">
								<label class="col-md-5 control-label"> Company <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<selectivity ng-if="edit" disabled="edit" list="companyList"
										ng-model="creditnoteAcctData.companyCode"
										property="creditnoteAcctData.companyCode" id="company_id"
										object="company" name="company_id" validation="required"
										friendly-name="Company" form-name="creditNoteForm"></selectivity>
								</div>
								<div class="col-md-7">
									<selectivity ng-if="!edit" list="companyList"
										ng-model="creditnoteAcctData.companyCode"
										property="creditnoteAcctData.companyCode" id="company_id"
										object="company" name="company_id" validation="required"
										friendly-name="Company" form-name="creditNoteForm"></selectivity>
								</div>
							</div>


							<div class="form-group ">
								<label class="col-md-5 control-label">Customer <span
									style="color: red;"> *</span></label>

								<div class="col-md-7">
									<selectivity list="customerList"
										property="creditnoteAcctData.accountName" id="cmbAccountName"
										object="accounts" name="accounts"
										ng-model="creditnoteAcctData.accountName"
										validation="required" friendly-name="Customer"
										form-name="creditNoteForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Narration <span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" id="narration"
										name="narration" data-ng-model="creditnoteAcctData.narration"
										validation="required" friendly-name="Narration" />
								</div>
							</div>
							

							<!-- <div class="form-group ">
										<label class="col-md-5 control-label">Currency<span
											style="color: red;"> *</span></label>
										<div class="col-md-7">
											
												<selectivity list="currencyList"
											property="creditnoteAcctData.currencyCode" id="currencyCode"
											name="currencyCode" ng-model="creditnoteAcctData.currencyCode"
											validation="required" friendly-name="currency"></selectivity>
										</div>
									</div> -->

						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Credit Note Date<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<!-- 					<div class="input-group input-append date" id="cn_date" > -->
									<!-- 						<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" validation="required" friendly-name="Credit Note Date"  -->
									<!-- 								ng-model="creditnoteAcctData.creditNoteDate" name="Date" id="creditNoteDate"> -->
									<!--  									 <span class="input-group-addon add-on"> -->
									<!--                   								<span class="glyphicon glyphicon-calendar"></span> -->
									<!--        								 </span> -->
									<!-- 				     </div> -->
									<ng-bs3-datepicker
										data-ng-model="creditnoteAcctData.creditNoteDate"
										id="creditNoteDate" name="creditNoteDate"
										form-name="creditNoteForm"
										data-ng-change="checkDatesCL(creditnoteAcctData.creditNoteDate)"
										friendly-name="CreditNote Date" validation="required" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-5 control-label">Invoice Number<span
									style="color: red;"> *</span></label>
								<div class="col-md-7 ">
									<selectivity list="invoiceNoList"
										property="creditnoteAcctData.invoiceNo"
										ng-model="creditnoteAcctData.invoiceNo" id="invoiceNo"
										name="invoiceNo" object="invoices" validation="required"
										friendly-name="Invoice" form-name="creditNoteForm"></selectivity>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-5 control-label">Job Order<span
									style="color: red;">
									</span></label>
								<div class="col-md-7 ">
									<selectivity list="jobList" property="creditnoteAcctData.jobOrder"
										ng-model="creditnoteAcctData.jobOrder" id="jobOrder_id" name="jobOrder"
										object="jobOrder"   friendly-name="JobOrder"
										form-name="creditNoteForm" disabled="true"></selectivity>
								</div>
							</div>


							<!-- <div class="form-group">
										<label class="col-md-5 control-label text-right">Exchange
											Rate<span style="color: red;"> *</span>
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm text-right"
												id="exgRate" name="exgRate" validation="required"
												friendly-name="Exchange Rate"
												ng-model="creditnoteAcctData.exchangeRate"
												ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" />
										</div>
									</div> -->

						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Mode<span
									style="color: red;"></span></label>
								<div class="col-md-7 ">
									<selectivity list="modeList" property="creditnoteAcctData.mode"
										ng-model="creditnoteAcctData.mode" id="mode_id" name="mode"
										object="mode"   friendly-name="Mode"
										form-name="creditNoteForm"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Invoice Date</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="invoiceDate" name="invoiceDate" validation="required"
										friendly-name="Invoice Date"
										ng-model="creditnoteAcctData.invoiceDate" ng-disabled="true" />
								</div>
							</div>



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

							<!-- <div class="col-sm-4 col-md-4 col-lg-4">
						<div class="" ng-repeat="(tIndex, filelist) in creditnoteAcctData.files">
								<a id="tbnewExport{{tIndex}}" style="display: none"
											href="{{filelist.filepath}}/{{filelist.filename}}"
											download="{{filelist.filename}}"></a>
											<div ng-if="filelist.creditnoteAcctData!=''">
											{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)" style="color:green">{{filelist.filename}}</a>
											</div>
											
											<div ng-if="filelist.creditnoteAcctData==''">
											{{tIndex+1}} ) <a style="color:green">{{filelist.filename}}</a>
											<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)" data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>
										</button>
											</div>
							
							</div>
					</div> -->
						</div>
					</div>
				</div>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th colspan=1 class="width_13 text-center">Charge Head<span
									style="color: red;"> *</span></th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Account</th> -->
								<th colspan=1 class="width_10 text-center">Sac No</th>
								<th colspan=1 class="width_10 text-center">Exchange Rate</th>
								<th colspan=1 class="width_10 text-center">Currency</th>
								<!-- <th colspan=1 class="width_10 text-center">Narration<span
											style="color: red;"> *</span></th> -->
								<!-- <th colspan=1 class="width_10 text-center">Amount (INR)<span
									style="color: red;"> *</span></th> -->
								<th colspan=1 class=" width_10 text-center">Amount<span
									style="color: red;"> *</span>
								</th>
								<th colspan=1 class="width_1"></th>
							</tr>

						</thead>
						<tbody
							ng-repeat="(trIndex, row) in creditnoteAcctData.credittables"
							ng-controller="tableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="crdtlAcctHeadList"
												property="row.crdtlAccountHead"
												id="accountHeadCode{{trIndex}}" object="accHead"
												ng-model="row.crdtlAccountHead"
												name="accountHeadCode{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(Account Head)'}}"
												form-name="creditNoteForm" disabled="true"></selectivity>
										</div>
									</div>
								</td>
								<!-- <td>
											<div class="row">
												<div class="col-xs-12" ng-if="!row.isSubAccountCode">
													<selectivity list="row.subAccountCodeList"
														ng-model="row.subAcctCode" property="row.subAcctCode"
														id="txtSubAccountCode{{$index}}"
														disabled="!row.isSubAccountCode"></selectivity>
												</div>
												<div class="col-xs-12" ng-if="row.isSubAccountCode">
													<selectivity list="row.subAccountCodeList"
														property="row.subAcctCode"
														id="txtSubAccountCode{{$index}}"
														form-name="creditNoteForm" ng-model="row.subAcctCode"
														name="{{ 'SubAccount' + $index }}" validation="required"
														friendly-name="{{ 'Row' + $index + '(Sub Account)'}}"></selectivity>
												</div>
											</div>
										</td> -->
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
								<!-- <td class="width_10">
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm"
														name="narration" data-ng-model="row.narration"
														name="narration{{trIndex}}" validation="required"
														friendly-name="{{ 'Row' + $index + '(Narration)'}}" />
												</div>
											</div>
										</td> -->
								<!-- <td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												name="tcamount" data-ng-model="row.tcamount"
												ng-keyup="bcamountCalculation(row.currency,row.tcamount,trIndex,row,row.cgstper,row.igstper,row.sgstper,row.exchangeRate)"
												name="tcAmount{{trIndex}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"
												friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" />
										</div>
									</div>
								</td> -->
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm text-right"
												data-ng-model="row.bcamount" step="0.01"
												ng-keyup="tcamountCalculation(row.currency,row.bcamount,trIndex,row,row.cgstper,row.igstper,row.sgstper,row.exchangeRate)"
												name="bcamount{{trIndex}}"
												validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"
												friendly-name="{{ 'Row' + $index + '(BC Amount)'}}" />
										</div>
									</div>
								</td>

							</tr>

							<!-- IGST -->
							<tr ng-if="row.igstsh != null && row.igstsh != ''">
								<td></td>

								<td style="text-align: right;">
									<!-- <div class="row">
												<div class="col-xs-12"> --> {{row.igstsh}} <!-- <input type="text" class="form-control input-sm text-right"
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
								<td style="text-align: right;">
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
												form-name="creditNoteForm" disabled>
										</div>
									</div>
								</td>

							</tr>

							<!-- CGST -->
							<tr ng-if="row.cgstsh != null && row.cgstsh != ''">
								<td></td>

								<td style="text-align: right;">
									<div class="row">
										<div class="col-xs-12">
											{{row.cgstsh}}
											<!-- <input type="text" class="form-control input-sm text-right"
														id="cgstsh{{trIndex}}" ng-model="row.cgstsh"
														name="cgstsh"form-name="purchaseInvoiceForm" disabled> -->
										</div>
									</div>
								</td>
								<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="cgstnam{{trIndex}}" ng-model="row.cgstnam"
														name="igstnam" disabled>
												</div>
											</div>
										</td> -->
								<td style="text-align: right;">
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
												form-name="creditNoteForm" disabled>
										</div>
									</div>
								</td>

							</tr>

							<!-- SGST -->
							<tr ng-if="row.sgstsh != null && row.sgstsh != ''">
								<td></td>

								<td style="text-align: right;">
									<div class="row">
										<div class="col-xs-12">
											{{row.sgstsh}}
											<!-- <input type="text" class="form-control input-sm text-right"
														id="sgstsh{{trIndex}}" ng-model="row.sgstsh"
														name="sgstsh"form-name="purchaseInvoiceForm" disabled> -->
										</div>
									</div>
								</td>
								<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="sgstnam{{trIndex}}" ng-model="row.sgstnam"
														name="sgstnam" disabled>
												</div>
											</div>
										</td>	 -->
								<td style="text-align: right;">
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
												form-name="creditNoteForm" disabled>
										</div>
									</div>
								</td>

							</tr>


							<tr>


								<td colspan="12">
									<div class="col-sm-12">
										<!-- Attributes list
												 <div class="col-sm-3" >
	        	<label class="col-md-5 control-label"> Attriutes </label>
	        	</div>   -->
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && !row.isVoyageMan">
											<label class="col-md-4 control-label"> Job Order No.
											</label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVoyage && row.isVoyageMan">
											<label class="col-md-4 control-label"> Job Order No.
											</label>
											<div class="col-md-8">
												<selectivity list="voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}" ng-model="row.voyageCode"
													validation="required" name="txtSubAccountCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
													form-name="creditNoteForm"> </selectivity>
											</div>


										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && !row.isVesselMan">
											<label class="col-md-5 control-label"> Mode </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label"> Mode </label>
											<div class="col-md-7">
												<selectivity list="vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}" ng-model="row.vesselCode"
													validation="required" name="vesselCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
													form-name="creditNoteForm"> </selectivity>
											</div>
										</div>
										<!-- 		<div class="col-sm-2 padding-top-5"
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
															form-name="creditNoteForm"> </selectivity>
													</div>
												</div>  -->
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
													form-name="creditNoteForm"> </selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5"
											ng-if="row.isPort && !row.isPortMan">
											<label class="col-md-5 control-label"> Port </label>
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
													form-name="creditNoteForm"> </selectivity>
											</div>
										</div>

										<!-- 	<div class="col-sm-2 padding-top-5"
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
													ng-model="row.departmentCode" validation="required"
													name="departmentCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Department)'}}"
													form-name="creditNoteForm"> </selectivity>
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
													form-name="creditNoteForm"> </selectivity>
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
													form-name="creditNoteForm"> </selectivity>
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
													form-name="creditNoteForm"> </selectivity>
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
													form-name="creditNoteForm"> </selectivity>
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
													ng-model="row.designationCode" validation="required"
													name="designationCode{{trIndex}}"
													friendly-name="{{ 'Row' + $index + '(Designation)'}}"
													form-name="creditNoteForm"> </selectivity>
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
					<br> <br> <br> <br> <br> <br>
					<!-- <div class="padding-right-5" id="AddOrRmvebtn">
								<button ng-click="addCredRow(creditnoteAcctData.credittables)"
									class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
									type="button">
									<i class="fa fa-plus"></i>
								</button> -->
								<button
									ng-click="removeCredRow(creditnoteAcctData.credittables)"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div> 
					<!-- /padding-right-5 - /AddOrRmvebtn -->
				</div>
				<!-- /table-responsive -->

				<div class="row">
					<!-- <div class="col-sm-12 col-md-12 col-lg-12">
						<div class="form-group pull-right">

							<div class="col-md-3"></div>
							<div class="col-md-9">
							
								<div class="col-md-3">
									<label class="col-md-1 control-label">Total Tax Amt</label>
									<div class="col-md-2">
										<input type="text" class="form-control input-sm text-right"
											name="totaltaxAmount"
											data-ng-model="creditnoteAcctData.totaltaxAmount"
											ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
									</div>

								</div>


								<div class="col-md-3">
									<label class="col-md-1 control-label">Total TC Amt</label>
									<div class="col-md-2">
										<input type="text" class="form-control input-sm text-right"
											name="totalTCAmount"
											data-ng-model="creditnoteAcctData.totalTCAmount"
											ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
									</div>

								</div>


								<div class="col-md-3">
									<label class="col-md-1 control-label">Total BC Amt</label>
									<div class="col-md-2">
										<input type="text" class="form-control input-sm text-right"
											name="totalBCAmount"
											data-ng-model="creditnoteAcctData.totalBCAmount"
											ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
									</div>

								</div>
							</div>


						</div>
					</div> -->
					<div class="col-md-12">
					<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total Amount</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right ng-pristine ng-untouched ng-valid" ng-model="creditnoteAcctData.totalBCAmount" readonly="" name="totalBCAmount"  placeholder="0.0">
										</div>

									</div>
									<!-- <div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total Amount(INR)</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right ng-pristine ng-untouched ng-valid" ng-model="creditnoteAcctData.totalTCAmount" readonly="" name="totalTCAmount" placeholder="0.0">
										</div>

									</div> -->
								<div class="form-group" style="float: right;">
								
									<label class="col-md-6 control-label">Total Tax Amount</label>

									<div class="col-md-6">
										<input type="text" class="form-control input-sm text-right ng-pristine ng-untouched ng-valid" ng-model="creditnoteAcctData.totaltaxAmount" readonly="" name="totaltaxAmount" placeholder="0.0">
									</div>

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
											ng-click="submit()">
											<i class="fa fa-save"></i> Save
										</button>
										<button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submit()">
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