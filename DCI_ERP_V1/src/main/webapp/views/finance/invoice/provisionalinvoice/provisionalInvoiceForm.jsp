<style>
.custom-col-md-6 {
	padding-right: 0px;
	padding-left: 0px;
}

.custom-col-md-3 {
	padding-right: 25px;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form name="provisionalInvoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<input type="hidden" ng-model="provisionalinvoice.ExchangeRateFrom"
						id="ExchangeRateFrom" /> <input type="hidden"
						ng-model="provisionalinvoice.ExchangeRateTo" id="ExchangeRateTo" /> <input
						type="hidden" ng-model="provisionalinvoice.currencyValue"
						id="currencyValue" /> <input type="hidden"
						ng-model="provisionalinvoice.fraction" id="fraction" />

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Company<span style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity ng-if = "provisionalinvoice.isEdit" disabled ="provisionalinvoice.isEdit" list="companyList" property="provisionalinvoice.CompanyCode" name="companyCode" ng-model="provisionalinvoice.CompanyCode"
										 validation="required" friendly-name="Company" form-name = "provisionalInvoiceForm"></selectivity>
									</div>
									<div class="col-md-7">
										<selectivity ng-if ="!provisionalinvoice.isEdit" list="companyList" property="provisionalinvoice.CompanyCode" name="companyCode" ng-model="provisionalinvoice.CompanyCode"
										 validation="required" friendly-name="Company" form-name = "provisionalInvoiceForm"></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
	      							<label for="inputPassword" class="control-label col-md-5">Invoice Date<span style="color: red;">*</span></label>
	    							<div class="col-md-7">
	   									<div class="input-group input-append date" id="invoice_date">
								          <input type="text" class="form-control input-sm" name="Invoice Date" id="txtInvoiceDate" 
								          ng-model="provisionalinvoice.InvoiceDate" placeholder='dd/mm/yyyy' 
								          friendly-name="Invoice Date" validation="required" />
								          <span class="input-group-addon add-on">
								           <span class="glyphicon glyphicon-calendar"></span>
								          </span>
								        </div>   									
	    							</div>
			       				</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">BL Related</label> <label
										class="col-md-1 control-label"> <input type="checkbox"
										name="blrelated" id="blrelated"
										ng-model="provisionalinvoice.BlRelated" ng-change="blCheck(provisionalinvoice.BlRelated)">
									</label>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="VesselhdrList"
											property="provisionalinvoice.VesselName" id="VesselName" ng-model="provisionalinvoice.VesselName"
											name="VesselName" validation="required" friendly-name="Vessel" form-name = "provisionalInvoiceForm" ></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage<span style="color: red;">*</span></label>
									<div class="col-md-7">

										<selectivity list="voyagehdrList" property="provisionalinvoice.Voyage" ng-model="provisionalinvoice.Voyage"
										name ="Voyage" id="Voyage" validation="required" friendly-name="Voyage" form-name = "provisionalInvoiceForm" 
										></selectivity>

									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL</label>
									<div class="col-md-7">
										<selectivity list="PorthdrList" property="provisionalinvoice.Pol"
											id="Pol"></selectivity>



									</div>
								</div>
							</div>

							
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer<span style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="customerhdrList" property="provisionalinvoice.CustomerName" id="customer" name="customer" ng-model="provisionalinvoice.CustomerName"
										 validation="required" friendly-name="Customer" form-name = "provisionalInvoiceForm"></selectivity>


									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Payer<span style="color: red;">*</span></label>
									<div class="col-md-7">
									  <ui-select ng-model="provisionalinvoice.MloName" ng-disabled="disabled"  appendToBody="true">
	         	 						<ui-select-match placeholder="Select a payer...">{{$select.selected.text}}</ui-select-match>
									    <ui-select-choices repeat="mlo.id as mlo in mloList | propsFilter: {id: $select.search,text: $select.search, Pol: $select.search,Pod: $select.search,payerAddress:$select.search} | limitTo: display_limit" buffered-scroll="increaseLimit();">
									      <div class="col-md-12 col-sm-12 col-lg-12 pt-lr-0">
									      <div class="col-md-4 pull-left pt-lr-1" ng-bind-html="mlo.text | highlight: $select.search"></div>
									      <div class="col-md-2 pull-left pt-lr-1" ng-bind-html="mlo.Pol | highlight: $select.search"></div>
									      <div class="col-md-2 pull-left pt-lr-1" ng-bind-html="mlo.Pod | highlight: $select.search"></div>
									       <div class="col-md-4  pull-left pt-lr-1" ng-bind-html="mlo.payerAddress | highlight: $select.search"></div>
									      </div>
										</ui-select-choices>
										    <div></div>
									  </ui-select>
										<!-- <selectivity list="mloList" property="provisionalinvoice.MloName" id="Mlo" object="MloName"
										 name="Mlo" ng-model="provisionalinvoice.MloName"
										 validation="required" friendly-name="Payer" form-name = "provisionalInvoiceForm"></selectivity> -->
									</div>
								</div>
							</div>


							<div class="col-md-4" id="blcheck">
								<div class="form-group">
									<label class="col-md-5 control-label">BL</label>
									<div class="col-md-7">

										<selectivity list="blList" property="provisionalinvoice.bl"
											id="bl" ng-model="provisionalinvoice.bl" object="bl"></selectivity>

									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Currency<span style="color: red;">*</span></label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" ng-model="provisionalinvoice.CurrencyName" 
										id="CurrencyName" name="Currency" ng-model="provisionalinvoice.CurrencyName"
										 validation="required" friendly-name="Currency" form-name = "provisionalInvoiceForm" readonly>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Exchange Rate <span style="color: red;">*</span></label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" name="exchangerate"
											ng-model="provisionalinvoice.ExchangeRate" id=exchangerate" friendly-name="Exchange Rate" validation="required"/>
									</div>
								</div>
							</div>


							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Subject</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" id="subject"
											ng-model="provisionalinvoice.Subject"  name="subject">
									</div>
								</div>
							</div>

						</fieldset>
					</div>


					


					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Units</label>
									<div class="col-md-7">
										<div class="row">
											<div class="col-md-6 custom-col-md-6 pull-left ">
												<label class="col-md-3 custom-col-md-3 control-label">20'</label>
												<input type="text" class="col-md-5 input-sm" id="unit20"
													ng-model="provisionalinvoice.Unit20" />
											</div>
											<div class="col-md-6 custom-col-md-6 pull-left">
												<label class="col-md-3 custom-col-md-3 control-label">40'</label>
												<input type="text" class="col-md-5 input-sm" id="unit40"
													ng-model="provisionalinvoice.Unit40" />
											</div>
										</div>
									</div>
								</div>
							</div>

							

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POD</label>
									<div class="col-md-7">
										<selectivity list="PorthdrList" property="provisionalinvoice.Pod"
											id="Pod"></selectivity>



									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Service</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="ServiceName" ng-model="provisionalinvoice.ServiceName" readonly>


									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>


				<div class="table-responsive">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<!-- <th colspan=1 class="width_13 text-center">Sub Group</th> -->
								<th colspan=1 class="width_2 text-center visible-left">Sl No</th>
								<th colspan=1 class="width_13 text-center">Account Head<span style="color: red;">*</span></th>								
								<th colspan=1 class="width_13 text-center">Sub Accout Code</th>
								<th colspan=1 class="width_13 text-center">Narration<span style="color: red;">*</span></th>
								<th colspan=1 class="width_10 text-center">TC Amount<span style="color: red;">*</span></th>
								<th colspan=1 class=" width_10 text-center">BC Amount({{companyCurrency}})<span style="color: red;">*</span></th>								
							</tr>
						</thead>
						
						<tbody ng-repeat="(trIndex, row) in provisionalinvoice.priDtl" ng-controller="priTableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{$index}}"><i></i></label></td>
								<td class="visible-left"><label ng-model="row.slNo" id="slNo{{$index}}" ng-bind="row.slNo"></label></td>
								<!-- <td><selectivity list="subGroupList"
									property="row.subGroupCode" id="txtSubGroupCode{{$index}}"></selectivity></td> -->
								<td><selectivity list="AccountHeadList"	property="row.accountHead" id="accountHead{{$index}}"  
								ng-model="row.accountHead" form-name = "provisionalInvoiceForm"
								 name="{{ 'accountHead' + $index }}" validation="required" friendly-name="{{ 'Row' + $index + '(Account Head)'}}" ></selectivity></td>
								<td><selectivity list="row.subAccountCodeList"
										property="row.subAccountCode" id="txtSubAccountCode{{$index}}"  disabled = "!row.isSubAccountCode"></selectivity></td>
								<td><input class="form-control input-sm" type="text" ng-model="row.narration" id="narration{{$index}}"
								name="narration{{$index}}" validation="required" friendly-name="{{ 'Row' + $index + '(Narration)'}}"></td>
								
								<td><input class="form-control input-sm" type="text"
									ng-model="row.tcAmount" id="TCamount{{$index}}"  step="0.01" ng-keyup="calculateTCtoBCAmount(row.tcAmount,$index,row)" 
									name="TCamount{{$index}}" validation="numeric|required" friendly-name="{{ 'Row' + $index + '(TCamount)'}}">
								</td>
								<td><input class="form-control input-sm" type="text"
									ng-model="row.bcAmount" id="BCamount{{$index}}" step="0.01" ng-keyup="calculateBCtoTCAmount(row.bcAmount,$index,row)"
									name="BCamount{{$index}}" validation="numeric|required" friendly-name="{{ 'Row' + $index + '(BCamount)'}}" >
								</td>
							</tr>
							
							
							
							 <tr>
						        	<td colspan="12">
							        	<div class="col-sm-12">
							        	<!-- Attributes list -->
							        	<!-- <div class="col-sm-3" >
							        	<label class="col-md-5 control-label"> Attriutes </label>
							        	</div> -->
							        	<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage">
											<label class="col-md-5 control-label"> Voyage
												
											</label>
											<div class="col-md-7">
										              <selectivity list="voyageList" property="row.voyageCode" id="voyageCode{{trIndex}}"></selectivity>
										     </div>
										</div>
							        	<div class="col-sm-2 padding-top-5" ng-if="row.isVessel">
											<label class="col-md-5 control-label"> Vessel
												
											</label>
											<div class="col-md-7">
										           <selectivity list="vesselList" property="row.vesselCode" id="vesselCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService">
											<label class="col-md-5 control-label"> Service
												
											</label>
											<div class="col-md-7">
										             <selectivity list="sectorList" property="row.sectorCode" id="sectorCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
											<label class="col-md-5 control-label"> Employee
												
											</label>
											<div class="col-md-7">
										           <selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort">
											<label class="col-md-5 control-label"> Port
												
											</label>
											<div class="col-md-7">
										           <selectivity list="portList" property="row.portCode" id="portCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
											<label class="col-md-5 control-label"> Port.Seq
												
											</label>
											<div class="col-md-7">
										          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
											<label class="col-md-5 control-label"> Department
												
											</label>
											<div class="col-md-7">
										           <selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
											<label class="col-md-5 control-label"> Agent
												
											</label>
											<div class="col-md-7">
										           <selectivity list="agentList" property="row.agentCode" id="agentCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
											<label class="col-md-5 control-label"> Location
												
											</label>
											<div class="col-md-7">
										             <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
											<label class="col-md-5 control-label"> Customer
												
											</label>
											<div class="col-md-7">
										             <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
											<label class="col-md-5 control-label"> Supplier
												
											</label>
											<div class="col-md-7">
										             <selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
											<label class="col-md-5 control-label"> Designation
												
											</label>
											<div class="col-md-7">
										             <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
											<label class="col-md-5 control-label"> CostCtr
												
											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCompany">
											<label class="col-md-5 control-label"> Company
												
											</label>
											<div class="col-md-7">
										             <selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
											<label class="col-md-5 control-label">Qty(MT)GO</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO"/>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
											<label class="col-md-5 control-label">Qty(MT)FO</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO"/>
										     </div>
										</div>
										</div>
								    </td> 		             	
						       </tr>
						       
						</tbody>

					</table>

					<div class="padding-right-5">
						<div class="col-md-4">
							<button ng-click="addRow(provisionalinvoice.priDtl)" class="btn btn-sm btn-info"
								tooltip="Add Row" ng-disabled="" type="button">
								<i class="fa fa-plus"></i>
							</button>
							<button ng-click="removeRow(provisionalinvoice.priDtl)" class="btn btn-sm btn-danger"
								type="button" tooltip="Delete">
								<i class="fa  fa-trash-o"></i>
							</button>
						</div>
						<div class="col-md-8">
							<div class="form-group">
								<label class="col-md-6 control-label">Total</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										id="TxtTotalTcAmt" name="totalTcAmt"
										ng-model="provisionalinvoice.TotalTCamount" readonly>
								</div>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm"
										id="TxtTotalBcAmt" name="totalBcAmt"
										ng-model="provisionalinvoice.TotalBCamount" readonly>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!provisionalinvoice.isEdit" ng-click="onSubmit(provisionalInvoiceForm,provisionalinvoice)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button"
								ng-if="provisionalinvoice.isEdit" ng-click="onSubmit(provisionalInvoiceForm,provisionalinvoice)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-danger" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>
	</div>
</div>
