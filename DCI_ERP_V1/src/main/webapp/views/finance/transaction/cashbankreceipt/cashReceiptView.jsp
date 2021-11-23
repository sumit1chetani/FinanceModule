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
<div class="breadcrumb-wrapper ng-scope">
		
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
									<label for="inputPassword" class="control-label col-md-5 bold">Date <span style="color: red;"></span></label>
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
								<!-- <div class="form-group">
									<label class="col-md-5 control-label bold">Type Of Payment <span style="color: red;">*</span></label>
									<div class="col-md-7 inputGroupContainer">
										<selectivity list="typeList" property="objCBReceipt.paymentMode" id="pmt_id" name="pmt_id"
										ng-model="objCBReceipt.paymentMode" validation="required"
										friendly-name="Payment Type" form-name="cashBankReceiptForm"></selectivity>
										<input type="text" class="form-control input-sm" ng-model="objCBReceipt.paymentMode" ng-disabled="true" />
									</div>
								</div> -->
								<div class="form-group" ng-if="show">
									<label class="col-md-5 control-label bold">Bank A/c <span style="color: red;"></span></label>
									<div class="col-md-7 inputGroupContainer">
										<!-- <selectivity list="bankList" property="objCBReceipt.bankAcc" id="bankAcc_id" name ="bankAcc_id"
										ng-model="objCBReceipt.bankAcc" validation="required"
										friendly-name="Bank Account" form-name="cashBankReceiptForm"></selectivity> -->
										<input type="text" ng-model="objCBReceipt.accountName" ng-disabled="true" />
									</div>
								</div>
								
								
								<div class="form-group" ng-if="!show">
									<label class="col-md-5 control-label bold">Cash A/c <span style="color: red;"></span></label>
									<div class="col-md-7 inputGroupContainer">
										<!-- <selectivity list="cashList" property="objCBReceipt.cashAcc" id="cashAcc_id" name="cashAcc_id"
										ng-model="objCBReceipt.accountName" validation="required"
										friendly-name="Cash Account" form-name="cashBankReceiptForm"></selectivity> -->
										<input type="text" class="form-control input-sm" ng-model="objCBReceipt.accountName" ng-disabled="true" />
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset >
								<div class="form-group" ng-disabled="isView">
									<label class="col-md-5 control-label bold"> Currency <span
										style="color: red;"> </span>
									</label>
									<div class="col-md-7">
										<!-- <input type="text" class="form-control input-sm" name="Currency" ng-model="objCBReceipt.currency" 
										validation="required" friendly-name="Currency" readonly /> -->
										<input type="text" class="form-control input-sm" ng-model="objCBReceipt.acctCurrency" ng-disabled="true" />
									</div>
								</div>
								<div class="form-group" ng-disabled="isView">
									<label class="col-md-5 control-label bold"> Exchange Rate <span style="color: red;"></span></label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" name="Exchange Rate" 
										ng-model="objCBReceipt.exchangeRate" validation="required" />
										
									</div>
								</div>

								<div class="form-group" ng-disabled="isView">
									<label class="col-md-5 control-label bold"> TC Amount <span style="color: red;"></span>
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" ng-model="objCBReceipt.tcAmountHdr1" 
										name="Amount USD" />
									</div>
								</div>

								<div class="form-group" ng-disabled="isView">
									<label class="col-md-5 control-label bold"> Received From  <span style="color: red;"></span></label>
									<div class="col-md-7">
										<!-- <selectivity list="customerList" property="objCBReceipt.receivedFrom" id="receivedFrom" name="receivedFrom"
										ng-model="objCBReceipt.receivedFrom" validation="required"
										friendly-name="Received From" form-name="cashBankReceiptForm"></selectivity> -->
										<input type="text" class="form-control input-sm" name="Received From" 
										ng-model="objCBReceipt.receivedFrom" />
									</div>
								</div>
								<div class="form-group" ng-if="isDownload">
									<label class="col-md-5 control-label bold">Attached
										Files</label>
									<div class="col-md-7">
										<!-- <span data-ng-if="objCBReceipt.filePath !== null "  title="Download" class="tool-tip-span font-blue padding-right-5 ng-scope "> -->
										<!-- <i class="fa fa-download text-dark text" style="color: #10DA10;"></i> -->

											
											
											 <span class="btn btn-primary" 
										ng-click="downloadFiles(objCBReceipt.voucherNo)" >
										Downlod
									</span>

									<a id="downLoad" href="" download></a>
									</div>
								</div>
							</fieldset>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4">
							<fieldset ng-disabled="isView">
							<div class="form-group" ng-show="show">
								<label class="col-md-5 control-label bold"> Cheque No</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="Cheque No" ng-model="objCBReceipt.chequeNO" />
								</div>
							</div>
							<div class="form-group" ng-show="show">
								<label for="inputPassword" class="control-label col-md-5 bold">Cheque
									Date</label>
								<div class="col-md-7">
									<div class="input-group input-append date" id="cheque_date">
										<input type="text" class="form-control input-sm"
											name="Cheque Date" id="txtChequeDate"
											ng-model="objCBReceipt.chequeDate" placeholder='dd/mm/yyyy' />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label bold"> BC Amount({{companyCurrency}})<span
									style="color: red;"></span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" ng-model="objCBReceipt.bcAmountHdr1" name="Amount" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5 bold">Narration <span style="color: red;"></span></label>
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
								<th  ng-hide="hide" colspan=1 class="width_15 text-center">Sub Group <span style="color: red;"></span></th>
								<th colspan=1 class="width_15 text-center">Company <span style="color: red;"></span></th>
								<th colspan=1 class="width_15 text-center">Account Name <span style="color: red;"></span></th>
								<th colspan=1 class="width_10 text-center">Sub Account Code</th>
								<th colspan=1 class="width_15 text-center">Short Details <span style="color: red;"></span></th>
								<th colspan=1 class="width_5 text-center">Currency<span style="color: red;"></span></th>
								<th colspan=1 class="width_7 text-center">Ex. Rate<span style="color: red;"></span></th>
								<th colspan=1 class="width_8 text-center">TC Amt<span style="color: red;"></span></th>
								<th colspan=1 class="width_8 text-center">BC Amt({{companyCurrency}})<span style="color: red;"></span></th>
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
											<input type="text" class="form-control input-sm" id="amountUsd{{trIndex}}" ng-model="row.tcamount1" name="tcamount{{trIndex}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" id="amount{{trIndex}}" ng-model="row.bcamount1" name="bcamount{{trIndex}}"  />
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
			        	<div class="col-sm-2 padding-top-5" ng-if="row.isVessel && row.isVesselMan">
							<label class="col-md-5 control-label"> Vessel
								
							</label>
							<div class="col-md-7">
						         <!--   <select class="form-control input-sm" id="vesselName{{trIndex}}" ng-model="row.vesselCode" ng-options="ves.id as ves.text for ves in vesselList">
								   </select> -->
								
										
<!-- 										<input type="text" class="form-control input-sm" name="vesselCode" ng-model="row.vesselCode" id="vesselCode{{trIndex}}" required readonly/>
 -->										<label ng-bind="row.vesselCode"></label>
										<!-- <select  list ="vesselList" ng-model="row.vesselCode" ng-options="vessel.vesselCode as vessel.vesselCode for vessel in vesselList" id="vesselCode{{trIndex}}" disabled>
				            		  	<option value="">select</option>
				            			</select> -->
									
						     </div>
						</div>
			        	<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && row.isVoyageMan">
							<label class="col-md-5 control-label"> Voyage
								
							</label>
							
						              <!-- <select class="form-control input-sm" id="voyageName{{trIndex}}" ng-model="row.voyageCode" ng-options="voy.id as voy.text for voy in voyageList">
								 		</select> -->
								 		<div class="col-md-7">
										
										<!-- <input type="text" class="form-control input-sm" name="voyageCode" ng-model="row.voyageCode" id="voyageCode{{trIndex}}" required readonly/> -->
										<label ng-bind="row.voyageCode"></label>
									<!-- <select  list ="voyageList" ng-model="row.voyageCode" ng-options="voyage.voyageCode as voyage.voyageCode for voyage in voyageList" id="voyageCode{{trIndex}}" disabled>
				            		  <option value="">select</option>
				            			</select> -->
									 </div>
								
							
						     </div>
						
			        	
						<div class="col-sm-2 padding-top-5" ng-if="row.isService && row.isServiceMan" >
							<label class="col-md-5 control-label"> Service
								
							</label>
							<div class="col-md-7">
						             <!-- <select class="form-control input-sm" id="sectorCode{{trIndex}}" ng-model="row.sectorCode" ng-options="sec.id as sec.text for sec in sectorList">
								 	 </select> -->
								 	  <label ng-bind="row.sectorCode"></label>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee && row.isEmployeeMan" >
							<label class="col-md-5 control-label"> Employee
								
							</label>
							<div class="col-md-7">
						         <!--   <select class="form-control input-sm" id="employeeCode{{trIndex}}" ng-model="row.employeeCode" ng-options="emp.id as emp.text for emp in employeeList">
								   </select> -->
								   <label ng-bind="row.employeeCode"></label>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isPort && row.isPortMan">
							<label class="col-md-5 control-label"> Port
								
							</label>
							<div class="col-md-7">
						           <!-- <select class="form-control input-sm" id="portCode{{trIndex}}" ng-model="row.portCode" ng-options="port.id as port.text for port in portList">
								   </select> --> <label ng-bind="row.portCode"></label>
						     </div>
						</div>
						<!-- 
						<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
							<label class="col-md-5 control-label"> Port.Seq
								
							</label>
							<div class="col-md-7">
						          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
						     </div>
						</div> -->
						
						<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment && row.isDepartmentMan">
							<label class="col-md-5 control-label"> Department
								
							</label>
							 <div class="col-md-7">
						          <!--  <select class="form-control input-sm" id="departmentCode{{trIndex}}" ng-model="row.departmentCode" ng-options="dep.id as dep.text for dep in departmentList">
								   </select> -->
								   								   <label ng-bind="row.departmentCode"></label>
								   
						     </div>
						     
						</div>
						
						<div class="col-sm-2 padding-top-5" ng-if="row.isAgent && row.isAgentMan">
							<label class="col-md-5 control-label"> Agent
								
							</label>
							<div class="col-md-7">
						          <!--  <select class="form-control input-sm" id="agentCode{{trIndex}}" ng-model="row.agentCode" ng-options="agent.id as agent.text for agent in agentList">
								   </select> -->
								   <label ng-bind="row.agentCode"></label>
						     </div>
						</div>
						
						<!-- <div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label"> Location
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="countryCode{{trIndex}}" ng-model="row.countryCode" ng-options="country.id as country.text for country in countryList">
								 	 </select>
						     </div>
						</div> -->
						<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer && row.isCustomerMan">
							<label class="col-md-5 control-label"> Customer
								
							</label>
							<div class="col-md-7">
						            <!--  <select class="form-control input-sm" id="customerCode{{trIndex}}" ng-model="row.customerCode" ng-options="cus.id as cus.text for cus in customerList">
								 	 </select> -->
								 	   <label ng-bind="row.customerCode"></label>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier && row.isSupplierMan">
							<label class="col-md-5 control-label"> Supplier
								
							</label>
							<div class="col-md-7">
						             <!-- <select class="form-control input-sm" id="supplierCode{{trIndex}}" ng-model="row.supplierCode" ng-options="sup.id as sup.text for sup in supplierList">
								 	 </select> -->
								 	   <label ng-bind="row.supplierCode"></label>
						     </div>
						</div>
						<!-- <div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label"> Designation
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="designationCode{{trIndex}}" ng-model="row.designationCode" ng-options="desig.id as desig.text for desig in designationList">
								 	 </select>
								 	  <label ng-bind="row.designationCode"></label>
						     </div>
						</div> -->
						<!-- <div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label"> CostCtr
								
							</label>
							<div class="col-md-7">
						             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/>
						     </div>
						</div> -->
						<!-- <div class="col-sm-2 padding-top-5" ng-if="row.isCompany && row.isCompanyMan" >
							<label class="col-md-5 control-label"> Company
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="companyName{{trIndex}}" ng-model="row.companyName" ng-options="company.id as company.text for company in companyList">
								 	 </select>
								 	  <label ng-bind="row.companyCode"></label>
						     </div>
						</div> -->
						<!-- <div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label">Qty(MT)GO</label>
							<div class="col-md-7">
						             <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO"/>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label">Qty(MT)FO</label>
							<div class="col-md-7">
						             <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO"/>
						     </div>
						</div> -->
						
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
										ng-model="objCBReceipt.tcAmountHdr1" readonly
										name="TC Total">
								</div>
								
								<label class="col-md-3 control-label"> Total BC Amt ({{companyCurrency}})</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										ng-model="objCBReceipt.bcAmountHdr1" readonly
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
											<button class="btn btn-success" ng-hide="isView" type="button"
												ng-click="submit(cashBankReceiptForm)" ng-if="!edit && receiptTable==false"
												class="btn btn-success">
												<i class="fa fa-plus"></i> Save
											</button>
											<button class="btn btn-success" type="button"
												ng-click="submit(cashBankReceiptForm)" ng-if="edit && receiptTable==false" type="button"
												type="submit">
												<i class="fa fa-save"></i> Update
											</button>
											<button class="btn btn-danger" class="btn btn-success" ng-if="receiptTable==false" type="button"
												ng-click="cancel()">
												<i class="fa fa-close"></i> Cancel
											</button>
											 <button class="btn btn-success"  ng-if="isView && receiptTable==false"
												 ng-click="printReceiptVoucherDiv(objCBReceipt.voucherNo)"  
												 type="button">
									        	  Print
									         </button>
									         <button class="btn btn-danger" ng-if="receiptTable==true" class="btn btn-success" type="button"
												ng-click="cancel1()">
												<i class="fa fa-close"></i> Cancel
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