<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="phcinvoiceForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<div class="col-sm-12">
								<div class="col-sm-3">
									<div class="form-group">
										<label class="col-md-4 control-label p-l-0"> Company <span
											style="color: red;">*</span>
										</label>
										<div class="col-md-8">
											<selectivity list="companyList"
												ng-model="phcinvoiceObj.companyCode"
												property="phcinvoiceObj.companyCode" id="company_id"
												object="company" name="company_id" validation="required"
												friendly-name="Company" form-name="phcinvoiceForm"
												disabled=true></selectivity>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Pol </label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.pol}}</label>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">BL No. </label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.blNo}}</label>
										</div>
									</div>
									<!-- <div class="form-group ">
										<label class="col-md-4 control-label">Fee Type</label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.feeType}}</label>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">TC Amt</label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.totalTCFee}}</label>

										</div>
									</div> -->

								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<label class="col-md-4 control-label">Inv Date</label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.invoiceDate}}</label>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Pot </label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.pot}}</label>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Currency</label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.currencyCode}}</label>
										</div>
									</div>


									<!-- <div class="form-group ">
										<label class="col-md-4 control-label">Rate</label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.feeRate}}</label>

										</div>
									</div>

									<div class="form-group ">
										<label class="col-md-4 control-label">BC Amt<span
											class="padding-right-10" style="color: red;"></span></label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.totalBCFee}}</label>


										</div>
									</div>
 -->


								</div>
								<div class="col-sm-3">
									<div class="form-group ">
										<label class="col-md-4 control-label">Vessel <span
											style="color: red;"> *</span></label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.vessel}}</label>
										</div>
									</div>

									<div class="form-group ">
										<label class="col-md-4 control-label">Pod <span
											style="color: red;"> *</span></label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.pod}}</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-4 control-label">Ex Rate<span
											style="color: red;"> *</span></label>
										<div class="col-md-8">
											<input type="text" class="form-control input-sm"
												id="exchangeRate" name="exchangeRate" validation="required"
												friendly-name="Exchange Rate"
												data-ng-model="phcinvoiceObj.exchangeRate"
												data-ng-change="exchageratePHChdr(phcinvoiceObj.exchangeRate)" />
										</div>
									</div>
									<!-- <div class="form-group">
										<label class="col-md-4 control-label">No of Bill<span
											class="padding-right-10" style="color: red;"></span></label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.noOfBill}}</label>
										</div>
									</div> -->

								</div>
								<div class="col-sm-3">
									<div class="form-group ">
										<label class="col-md-4 control-label">Voyage <span
											style="color: red;"> *</span></label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.voyage}}</label>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label p-l-0">Customer </label>
										<div class="col-md-8">
											<label class="padding-top-5">{{phcinvoiceObj.customer}}</label>
										</div>
									</div>
									<div class="form-group ">
										<label class="col-md-4 control-label">Leg </label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.flag}}</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="col-sm-3">
									<div class="form-group ">
										<label class="col-md-4 control-label">Shipment</label>
										<div class="col-md-8">
											<label class="control-label">{{phcinvoiceObj.shipment}}</label>
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="form-group">
										<label class="col-md-4 control-label">Payer <span
											style="color: red;"> *</span></label>
										<div class="col-md-7" data-ng-if="phcinvoiceObj.pod !== 'PSA'">
											<span data-ng-if="!allPayer"> <selectivity
													list="acctHeadList" property="phcinvoiceObj.accountName"
													id="accountName" object="accounts" name="accounts"
													ng-model="phcinvoiceObj.accountName" validation="required"
													friendly-name="Payer" form-name="phcinvoiceForm"></selectivity>
											</span> <span data-ng-if="allPayer"> <ui-select
													ng-model="phcinvoiceObj.accountName" ng-disabled="disabled"
													appendToBody="true"> <ui-select-match
													placeholder="Select a payer...">{{$select.selected.text}}</ui-select-match>
												<ui-select-choices
													repeat="mlo.id as mlo in acctHeadList | propsFilter: {id: $select.search,text: $select.search, payerAddrs : $select.search,payerCountry: $select.search} | limitTo: display_limit"
													buffered-scroll="increaseLimit();">
												<div class="col-md-12 col-sm-12 col-lg-12 pt-lr-0">
													<div class="col-md-4 pull-left pt-lr-1"
														ng-bind-html="mlo.text | highlight: $select.search"></div>
													<div class="col-md-4 pull-left pt-lr-1"
														ng-bind-html="mlo.payerAddrs | highlight: $select.search"></div>
													<div class="col-md-4 pull-left pt-lr-1"
														ng-bind-html="mlo.payerCountry | highlight: $select.search"></div>
												</div>
												</ui-select-choices>
												<div></div>

												</ui-select>
											</span>

										</div>
										<div class="col-md-8" data-ng-if="phcinvoiceObj.pod === 'PSA'">
											<label>{{phcinvoiceObj.acctName}}</label>
										</div>
									</div>
								</div>
								<div class="col-sm-3" data-ng-if="phcinvoiceObj.pod !== 'PSA'">
									<div class="form-group">
										<label class="col-md-4 control-label"> All Payer </label>
										<div class="col-md-7">
											<label class="i-checks m-b-none" style="padding-top: 5px;">
												<input data-ng-click="getPayerDtlList(checkAllPayer)"
												type="checkbox" data-ng-model="checkAllPayer"><i></i>
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="">
								<table class="table table-striped b-t b-light">
									<thead>
										<tr>
											<th colspan=1 class="width_1"></th>
											<th colspan=1 class="width_13 text-center">Account Head<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">Service<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">Con. Type<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">Rate<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">No of Con.<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">TC Amt<span
												style="color: red;"> *</span></th>
											<th colspan=1 class=" width_10 text-center">BC
												Amt({{companyCurrency}})<span style="color: red;"> *</span>
											</th>
											<th colspan=1 class="width_1"></th>
										</tr>
									</thead>
									<tbody
										data-ng-repeat="(trIndex, row) in phcinvoiceObj.credittables"
										data-ng-controller="tablePhcCalcCtrl">
										<tr>
											<td><label class="i-checks m-b-none"> <input
													type="checkbox" data-ng-model="row.select"
													id="section{{trIndex}}"
													data-ng-click="tcAmountCalculation(row.select,trIndex)"><i></i></label></td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<selectivity list="crdtlAcctHeadList"
															property="row.crdtlAccountHead"
															id="crdtlAccountHead{{trIndex}}" object="accHead"
															ng-model="row.crdtlAccountHead"
															name="accountHeadCode{{trIndex}}" validation="required"
															friendly-name="{{ 'Row' + $index + '(Account Head)'}}"
															form-name="phcinvoiceForm"></selectivity>
													</div>
												</div>
											</td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<selectivity list="serviceList" property="row.service"
															id="service{{trIndex}}" object="service"
															ng-model="row.service" name="service{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Service)'}}"
															form-name="phcinvoiceForm" disabled=true></selectivity>
													</div>
												</div>
											</td>

											<td>
												<div class="row">
													<div class="col-xs-12">
														<selectivity list="containerList" property="row.conType"
															id="conType{{trIndex}}" object="conType"
															ng-model="row.conType" name="conType{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(ConType)'}}"
															form-name="phcinvoiceForm" disabled=true></selectivity>
													</div>
												</div>
											</td>
											<td class="width_10">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="form-control input-sm"
															name="conRate" data-ng-model="row.conRate"
															name="conRate{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Rate)'}}" disabled />
													</div>
												</div>
											</td>

											<td class="width_10">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="form-control input-sm"
															name="noOfCon" data-ng-model="row.noOfCon"
															data-ng-keyup="rateCalculation(row.noOfCon,trIndex,row)"
															name="noOfCon{{trIndex}}"
															data-friendly-name="{{ 'Row' + $index + '(No Of Con)'}}"
															disabled />
													</div>
												</div>
											</td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<span data-ng-if="row.select !== 'false'"> <input
															type="text" class="form-control input-sm" name="tcamount"
															data-ng-model="row.tcamount"
															data-ng-keyup="bcamountCalculation(row.tcamount,trIndex,row)"
															name="tcAmount{{trIndex}}" validation="numeric|required"
															data-ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01"
															friendly-name="{{ 'Row' + $index + '(TC Amount)'}}"
															disabled />
														</span> <span data-ng-if="row.select === 'false'"><input
															type="text" class="form-control input-sm" name="tcamount"
															data-ng-model="row.tcamount" disabled /></span>
													</div>
												</div>
											</td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<span data-ng-if="row.select !== 'false'"> <input
															type="text" class="form-control input-sm"
															data-ng-model="row.bcamount"
															data-ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01"
															data-ng-keyup="tcamountCalculation(row.bcamount,trIndex,row)"
															name="bcamount{{trIndex}}" validation="numeric|required"
															data-ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/"
															friendly-name="{{ 'Row' + $index + '(BC Amount)'}}"
															disabled />
														</span> <span data-ng-if="row.select === 'false'"> <input
															type="text" class="form-control input-sm"
															data-ng-model="row.bcamount" name="bcamount{{trIndex}}"
															disabled />
														</span>
													</div>
												</div>
											</td>

										</tr>
									</tbody>
								</table>
								<!-- <div class="padding-right-5" id="AddOrRmvebtn">
								<button ng-click="addCredRow(phcinvoiceObj.credittables)"
									class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
									type="button">
									<i class="fa fa-plus"></i>
								</button>-->
								<button
									data-ng-click="removeCredRow(phcinvoiceObj.credittables)"
									class="btn btn-sm btn-danger" type="button">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div>
							<div class="table-responsive clear">
								<table class="table table-striped b-t b-light">
									<thead>
										<tr>
											<th colspan=1 class="width_1"></th>
											<th colspan=3 class="width_34 text-center">Fee Type</th>
											<th colspan=1 class="width_10 text-center">Rate</th>
											<th colspan=1 class="width_10 text-center">No of Bl.</th>
											<th colspan=1 class="width_10 text-center">TC Amt</th>
											<th colspan=1 class=" width_10 text-center">BC Amt
												({{creditnoteAcctData.companyCurrency}})</th>
											<th colspan=1 class="width_1"></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td></td>
											<td colspan=3>
												<div class="row">
													<div class="col-xs-12">
														<label class="form-control input-sm b-none text-center"><span
															data-ng-if="phcinvoiceObj.feeType == '' ">-</span> <span
															data-ng-if="phcinvoiceObj.feeType !== '' ">{{phcinvoiceObj.feeType}}</span>
														</label>
													</div>
												</div>
											</td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<label class="form-control input-sm b-none"
															data-ng-bind="phcinvoiceObj.feeRate"></label>
													</div>
												</div>
											</td>

											<td>
												<div class="row">
													<div class="col-xs-12">
														<label class="form-control input-sm b-none"
															data-ng-bind="phcinvoiceObj.noOfBill"></label>
													</div>
												</div>
											</td>
											<td class="width_10">
												<div class="row">
													<div class="col-xs-12">
														<label class="form-control input-sm b-none"
															data-ng-bind="phcinvoiceObj.totalTCFee"></label>
													</div>
												</div>
											</td>

											<td class="width_10">
												<div class="row">
													<div class="col-xs-12">
														<label class="form-control input-sm b-none"
															data-ng-bind="phcinvoiceObj.totalBCFee"></label>
													</div>
												</div>
											</td>
											<td></td>

										</tr>
									</tbody>
								</table>
							</div>


							<div class="">
								<table class="table table-striped b-t b-light">
									<thead>
										<tr>
											<th colspan=1 class="width_1"></th>
											<th colspan=1 class="width_13 text-center">Account Head<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">Service<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">Con. Type<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">Rate<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">No of Con.<span
												style="color: red;"> *</span></th>
											<th colspan=1 class="width_10 text-center">TC Amt<span
												style="color: red;"> *</span></th>
											<th colspan=1 class=" width_10 text-center">BC
												Amt({{companyCurrency}})<span style="color: red;"> *</span>
											</th>
											<th colspan=1 class="width_1"></th>
										</tr>
									</thead>
									<tbody
										data-ng-repeat="(trIndex, row1) in phcinvoiceObj.doorOpenTable"
										data-ng-controller="tablePhcCalcCtrl">
										<tr>
											<td><label class="i-checks m-b-none"> <input
													type="checkbox" data-ng-model="row1.select"
													id="section{{trIndex}}"
													data-ng-click="tcAmountCalculationDO(row1.select,trIndex)"><i></i></label></td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<selectivity list="crdtlAcctHeadList"
															property="row1.crdtlAccountHead"
															id="crdtlAccountHead{{trIndex}}" object="accHead"
															ng-model="row1.crdtlAccountHead"
															name="accountHeadCode{{trIndex}}" validation="required"
															friendly-name="{{ 'Row' + $index + '(Account Head)'}}"
															form-name="phcinvoiceForm" disabled></selectivity>
													</div>
												</div>
											</td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<selectivity list="serviceList" property="row1.service"
															id="service{{trIndex}}" object="service"
															ng-model="row1.service" name="service{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Service)'}}"
															form-name="phcinvoiceForm" disabled ></selectivity>
													</div>
												</div>
											</td>

											<td>
												<div class="row">
													<div class="col-xs-12">
														<selectivity list="containerList" property="row1.conType"
															id="conType{{trIndex}}" object="conType"
															ng-model="row1.conType" name="conType{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(ConType)'}}"
															form-name="phcinvoiceForm" disabled></selectivity>
													</div>
												</div>
											</td>
											<td class="width_10">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="form-control input-sm"
															name="conRate" data-ng-model="row1.conRate"
															name="conRate{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Rate)'}}" disabled />
													</div>
												</div>
											</td>

											<td class="width_10">
												<div class="row">
													<div class="col-xs-12">
														<input type="text" class="form-control input-sm"
															name="noOfCon" data-ng-model="row1.noOfCon"
															data-ng-keyup="rateCalculation(row1.noOfCon,trIndex,row1)"
															name="noOfCon{{trIndex}}"
															data-friendly-name="{{ 'Row' + $index + '(No Of Con)'}}"
															disabled />
													</div>
												</div>
											</td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<span data-ng-if="row.select !== 'false'"> <input
															type="text" class="form-control input-sm" name="tcamount"
															data-ng-model="row1.tcamount"
															data-ng-keyup="bcamountCalculation(row1.tcamount,trIndex,row1)"
															name="tcAmount{{trIndex}}" validation="numeric|required"
															data-ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01"
															friendly-name="{{ 'Row' + $index + '(TC Amount)'}}"
															disabled />
														</span> <span data-ng-if="row1.select === 'false'"><input
															type="text" class="form-control input-sm" name="tcamount"
															data-ng-model="row1.tcamount" disabled /></span>
													</div>
												</div>
											</td>
											<td>
												<div class="row">
													<div class="col-xs-12">
														<span data-ng-if="row1.select !== 'false'"> <input
															type="text" class="form-control input-sm"
															data-ng-model="row1.bcamount"
															data-ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01"
															data-ng-keyup="tcamountCalculation(row1.bcamount,trIndex,row1)"
															name="bcamount{{trIndex}}" validation="numeric|required"
															data-ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/"
															friendly-name="{{ 'Row' + $index + '(BC Amount)'}}"
															disabled />
														</span> <span data-ng-if="row1.select === 'false'"> <input
															type="text" class="form-control input-sm"
															data-ng-model="row1.bcamount" name="bcamount{{trIndex}}"
															disabled />
														</span>
													</div>
												</div>
											</td>

										</tr>
									</tbody>
								</table>
								<!-- <div class="padding-right-5" id="AddOrRmvebtn">
								<button ng-click="addCredRow(phcinvoiceObj.credittables)"
									class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled=""
									type="button">
									<i class="fa fa-plus"></i>
								</button>-->
								<button
									data-ng-click="removeDoRow(phcinvoiceObj.doorOpenTable)"
									class="btn btn-sm btn-danger" type="button">
									<i class="fa  fa-trash-o"></i>
								</button>
							</div>


							<!-- /table-responsive -->
							<div class="row">
								<div class="col-sm-12">
									<div class="form-group pull-right">

										<label class="col-md-3 control-label">Total TC Amt</label>
										<div class="col-md-3">
											<input type="text" class="form-control input-sm"
												name="totalTCAmount"
												data-ng-model="phcinvoiceObj.totalTCAmount"
												data-ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01"
												disabled />
										</div>

										<label class="col-md-3 control-label">Total BC Amt</label>
										<div class="col-md-3">
											<input type="text" class="form-control input-sm"
												name="totalBCAmount"
												data-ng-model="phcinvoiceObj.totalBCAmount"
												data-ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01"
												disabled />
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
													<button id="saveInvoice" class="btn btn-success"
														type="button" data-ng-click="submit()">
														<i class="fa fa-save"></i> Generate PHC
													</button>
													<button class="btn btn-danger"
														data-ng-click="cancelTopendingList()" type="button">
														<i class="fa fa-arrow-left"></i> Cancel
													</button>
												</div>
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
	</div>
</div>