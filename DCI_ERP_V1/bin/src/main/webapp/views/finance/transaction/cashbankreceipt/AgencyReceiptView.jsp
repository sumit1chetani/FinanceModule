<style>
.view input,
.view textarea,
.view .input-group-addon,
.view .selectivity-single-select
{
  border:0px !important;
  resize:none !important;
}
.view .selectivity-single-select{
	background: none !important;
}
.view .input-group-addon
{
	display:none !important;
}
/* fieldset:disabled input,
fieldset:disabled selectivity,
fieldset:disabled textarea{
background:none !important;
pointer-events:none !important;
cursor:none !important;
} */
.view input,
.view selectivity,
.view textarea
{
background:none !important;
pointer-events:none !important;
cursor:none !important;
}

</style>
<div class="wrapper-md">
		
	<div class="panel panel-default panel-default-form" ng-class="{view : isView}">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" name="cashBankReceiptForm" role="form">
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset ng-disabled="isView">
								
								<div class="form-group" ng-if="isView">
									<label for="inputPassword" class="control-label col-md-5 bold">Voucher No</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"  name="Voucher No" id="txtVoucherNo"
											ng-model="objCBReceipt.voucherNo" placeholder='dd/mm/yyyy' /> 
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5 bold">Date <span style="color: red;">*</span></label>
									<div class="col-md-7">
										<div class="input-group input-append date" id="receipt_date">
											<input type="text" class="form-control input-sm"
												name="ReceiptDate" id="txtReceiptDate"
												ng-model="objCBReceipt.cbReceiptDate"
												placeholder='dd/mm/yyyy'  friendly-name="Receipt Date" validation="required"/> <span
												class="input-group-addon add-on"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label bold">Company </label>
										<div class="col-md-7">
											<!-- <selectivity ng-if="edit" disabled="edit" list="companyList"
												property="objCBReceipt.companyCode" name="companyCode"
												ng-model="objCBReceipt.companyCode" validation="required"
												friendly-name="Company" form-name="cashBankReceiptForm"></selectivity> -->
											<input type="text" class="form-control input-sm" ng-model="objCBReceipt.companyName" ng-disabled="true" />
										</div>								
											
								</div>
								
								<div class="form-group">
									<label class="col-md-5 control-label bold">Agent </label>
										<div class="col-md-7">
											
											<input type="text" class="form-control input-sm" ng-model="objCBReceipt.subAccountName" ng-disabled="true" />
										</div>								
											
								</div>
								
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset ng-disabled="isView">
								<div class="form-group">
									<label class="col-md-5 control-label bold"> Currency <span
										style="color: red;"> *</span>
									</label>
									<div class="col-md-7">
										<!-- <input type="text" class="form-control input-sm" name="Currency" ng-model="objCBReceipt.currency" 
										validation="required" friendly-name="Currency" readonly /> -->
										<input type="text" class="form-control input-sm" ng-model="objCBReceipt.acctCurrency" ng-disabled="true" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-5 control-label bold"> Exchange Rate <span style="color: red;">*</span></label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" name="Exchange Rate" 
										ng-model="objCBReceipt.exchangeRate" validation="required" />
										
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-5 control-label bold"> TC Amount <span style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" ng-model="objCBReceipt.tcAmountHdr" 
										name="Amount USD" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-5 control-label bold"> Received From  <span style="color: red;">*</span></label>
									<div class="col-md-7">
										<!-- <selectivity list="customerList" property="objCBReceipt.receivedFrom" id="receivedFrom" name="receivedFrom"
										ng-model="objCBReceipt.receivedFrom" validation="required"
										friendly-name="Received From" form-name="cashBankReceiptForm"></selectivity> -->
										<input type="text" class="form-control input-sm" name="Received From" 
										ng-model="objCBReceipt.receivedFrom" />
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset ng-disabled="isView">
							<div class="form-group">
								<label class="col-md-5 control-label bold"> BC Amount({{companyCurrency}})<span
									style="color: red;">*</span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" ng-model="objCBReceipt.bcAmountHdr" name="Amount" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5 bold">Narration <span style="color: red;">*</span></label>
								<div class="col-md-7">
									<div class="input-group">
										<textarea rows="2" cols="30" class="form-control" name="Narration" ng-model="objCBReceipt.narration">
 									</textarea>
									</div>
								</div>
							</div>
							</fieldset>
						</div>
						<!-- /col-sm-4 col-md-4 col-lg-4 -->
					</div>
					<!-- /col-sm-12 col-md-12 col-lg-12 -->
				</div>
				<!-- /book-widget-row -->
				<div class="table-responsive clear" ng-class="{view : isView}">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th  ng-hide="hide" colspan=1 class="width_15 text-center">Sub Group <span style="color: red;">*</span></th>
								<th colspan=1 class="width_15 text-center">Company <span style="color: red;">*</span></th>
								<th colspan=1 class="width_15 text-center">Account Name <span style="color: red;">*</span></th>
								<th colspan=1 class="width_10 text-center">Sub Account Code</th>
								<th colspan=1 class="width_15 text-center">Short Details <span style="color: red;">*</span></th>
								<th colspan=1 class="width_5 text-center">Currency<span style="color: red;">*</span></th>
								<th colspan=1 class="width_7 text-center">Ex. Rate<span style="color: red;">*</span></th>
								<th colspan=1 class="width_8 text-center">TC Amt<span style="color: red;">*</span></th>
								<th colspan=1 class="width_8 text-center">BC Amt({{companyCurrency}})<span style="color: red;">*</span></th>
								<th colspan=1 class="width_1"></th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in objCBReceipt.cshBankDetail" ng-controller="tableViewCtrl">
							
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select"><i></i></label></td>
								 <td ng-hide="hide" class="">
						           <div class="row">
							            <div class="col-xs-12">
								        	<!-- <selectivity  list="subgroupList" property="row.subgroupcode" id="subgroupName{{trIndex}}"
								        	ng-model="row.acctName" validation="required"  name="subgroupName{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(Sub Group Head)'}}" form-name="cashBankReceiptForm"></selectivity>
											 -->
											<input type="text" ng-model="row.subgroupcode" />
							       		 </div>
						        	</div>
						      	</td> 
						      	<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											
											<!-- <selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"
											ng-model="row.companyCode" validation="required"  name="{{ 'Company' + $index }}" 
											friendly-name="{{ 'Row' + $index + '(Company)'}}" form-name="cashBankReceiptForm"></selectivity> -->
											
											<input type="text" ng-model="row.companyName" />
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<!-- <selectivity list="accountList" property="row.acctName" id="acctName{{trIndex}}"
											ng-model="row.acctName" validation="required"  name="{{ 'accountHead' + $index }}" 
											friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name="cashBankReceiptForm"></selectivity> -->
											<label class="" ng-bind="row.acctName"></label>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">

											<!-- <selectivity list="row.subAccountCodeList"
												property="row.subAccountCode"
												id="txtSubAccountCode{{trIndex}}" disabled = "!row.isSubAccountCode"></selectivity> -->
												
												<label class="" ng-bind="row.subAccountName"></label>
										</div>
									</div>
								</td>
								<td class="padding-both-side-2">
									<div class="row">
										<div class="col-xs-12">
											<div class="col-xs-9 pull-left">
											<input type="text" class="form-control input-sm"
												id="shortDetail{{trIndex}}" ng-model="row.shortDetail" validation="required"  
												name="{{ 'shortDetail' + $index }}"  friendly-name="{{ 'Row' + $index + '(Short Detail)'}}"/>
											</div>
											 <div class="col-xs-3 pull-left">
											<label class="line-height-30 cursor-pointer" ng-if="row.isTradeDebtors &&  !isView" data-ng-click="showReceiptInvoicePopup(trIndex,row)">
							           		<i class="fa fa-expand"></i></label>
							           		</div>
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"
												id="currency{{trIndex}}" ng-model="row.currency" name="currency"
												friendly-name="{{ 'Row' + $index + '(Currency)'}}" validation="required" readonly> -->
											<!-- <selectivity list="currencyList" property="row.currency"  ng-model="row.currency"
											name="Currency{{trIndex}}"  id="currency{{trIndex}}" validation="required"
											object="currency" friendly-name="{{ 'Row' + $index + '(Currency)'}}"  form-name = "cashBankReceiptForm" ></selectivity> -->
											
											<input type="text" ng-model="row.currency" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="exgRate{{trIndex}}" ng-model="row.exgRate" name="exgRate" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" id="amountUsd{{trIndex}}" ng-model="row.tcamount" name="tcamount{{trIndex}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" id="amount{{trIndex}}" ng-model="row.bcamount" name="bcamount{{trIndex}}"  />
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="12">
									<div class="col-sm-12">
										<!-- Attributes list -->
										<!-- <div class="col-sm-3" >
							        	<label class="col-md-5 control-label bold"> Attriutes </label>
							        	</div> -->
			        					<div class="col-sm-2 padding-top-5" ng-if="row.isVessel">
											<label class="col-md-5 control-label bold"> Vessel </label>
											<div class="col-md-7">
												<!-- <selectivity list="row.vesselList" property="row.vesselCode"
													id="vesselCode{{trIndex}}"></selectivity> -->
												
												<input type="text" class="form-control input-sm" ng-model="row.vesselName" />	
													
											</div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage">
											<label class="col-md-5 control-label bold"> Voyage </label>
											<div class="col-md-7">
												<!-- <selectivity list="row.voyageList" property="row.voyageCode"
													id="voyageCode{{trIndex}}"></selectivity> -->
													
												<input type="text" class="form-control input-sm" ng-model="row.voyageCode" />
											</div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isService">
											<label class="col-md-5 control-label bold"> Service </label>
											<div class="col-md-7">
												<!-- <selectivity list="sectorList" property="row.sectorCode"
													id="sectorCode{{trIndex}}"></selectivity> -->													
												<input type="text" class="form-control input-sm" ng-model="row.sectorName" />
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
											<label class="col-md-5 control-label bold"> Employee </label>
											<div class="col-md-7">
												<selectivity list="employeeList" property="row.employeeCode"
													id="employeeCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort">
											<label class="col-md-5 control-label bold"> Port </label>
											<div class="col-md-7">
												<selectivity list="portList" property="row.portCode"
													id="portCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
											<label class="col-md-5 control-label bold"> Port.Seq </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="PortSequence{{trIndex}}" ng-model="row.portSequence"
													name="PortSequence" />
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
											<label class="col-md-5 control-label bold"> Department </label>
											<div class="col-md-7">
												<selectivity list="departmentList"
													property="row.departmentCode"
													id="departmentCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
											<label class="col-md-5 control-label bold"> Agent </label>
											<div class="col-md-7">
												<selectivity list="agentList" property="row.agentCode"
													id="agentCode{{trIndex}}"></selectivity>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
											<label class="col-md-5 control-label bold"> Location </label>
											<div class="col-md-7">
												<selectivity list="countryList" property="row.countryCode"
													id="countryCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
											<label class="col-md-5 control-label bold"> Customer </label>
											<div class="col-md-7">
												<selectivity list="customerList" property="row.customerCode"
													id="customerCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
											<label class="col-md-5 control-label bold"> Supplier </label>
											<div class="col-md-7">
												<selectivity list="supplierList" property="row.supplierCode"
													id="supplierCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
											<label class="col-md-5 control-label bold"> Designation </label>
											<div class="col-md-7">
												<selectivity list="designationList"
													property="row.designationCode"
													id="designationCode{{trIndex}}"></selectivity>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
											<label class="col-md-5 control-label bold"> CostCtr </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="CostCenter{{trIndex}}" ng-model="row.costCenter"
													name="CostCenter" />
											</div>
										</div>
										<!-- Commented for inter-company transaction -->
										<!-- <div class="col-sm-2 padding-top-5" ng-if="row.isCompany">
											<label class="col-md-5 control-label bold"> Company </label>
											<div class="col-md-7">
												<selectivity list="companyList" property="row.companyCode"
													id="companyCode{{trIndex}}"></selectivity>
											</div>
										</div> -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
											<label class="col-md-5 control-label bold">Qty(MT)GO</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="QuantityGO{{trIndex}}" ng-model="row.quantityGO"
													name="QuantityGO" />
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
											<label class="col-md-5 control-label bold">Qty(MT)FO</label>
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
					<div class="padding-right-5 padding-bottom-5">
						<button ng-click="addCBRcptDtlRow(objCBReceipt.cshBankDetail)"
							class="btn btn-sm btn-info" tooltip="Add Row" type="button" ng-hide="isView">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCBRcptRow(objCBReceipt.cshBankDetail)"
							class="btn btn-sm btn-danger" type="button" tooltip="Delete" ng-hide="isView">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<!-- /addRow and /removeRow -->
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12">
							<div class="form-group pull-right">
								
								<label class="col-md-3 control-label"> Total TC Amt</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										ng-model="cbRcptDtlTotalAmt.totalTCAmount" readonly
										name="TC Total">
								</div>
								
								<label class="col-md-3 control-label"> Total BC Amt ({{companyCurrency}})</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										ng-model="cbRcptDtlTotalAmt.totalBCAmount" readonly
										name="BC Total">
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
											<button class="btn btn-success" ng-hide="isView"
												ng-click="submit(cashBankReceiptForm)" ng-if="!edit"
												class="btn btn-success">
												<i class="fa fa-plus"></i> Save
											</button>
											<button class="btn btn-success"
												ng-click="submit(cashBankReceiptForm)" ng-if="edit"
												type="submit">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-danger" class="btn btn-success"
												ng-click="cancelAgencyReceipt()">
												<i class="fa fa-close"></i> Cancel
											</button>
											 <button class="btn btn-success"  ng-if="isView"
												 ng-click="printReceiptVoucherDiv(objCBReceipt.voucherNo)"  
												 type="button">
									        	  Print
									         </button>
										</div>
									</div>
								</div>
								<!-- /form-actions -->
							</div>
						</div>
					</div>
				</div>
				<!-- table-responsive -->
			</form>
		</div>
		<!-- /panel-body -->
	</div>
	<!-- /panel-default -->
</div>
<!-- /wrapper-md -->