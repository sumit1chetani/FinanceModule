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
			<form name="invoiceForOwnerForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<input type="hidden" ng-model="invoiceForOwner.ExchangeRateFrom"
						id="ExchangeRateFrom" /> <input type="hidden"
						ng-model="invoiceForOwner.ExchangeRateTo" id="ExchangeRateTo" /> <input
						type="hidden" ng-model="invoiceForOwner.currencyValue"
						id="currencyValue" /> <input type="hidden"
						ng-model="invoiceForOwner.fraction" id="fraction" />

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Company<span style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity ng-if = "invoiceForOwner.isEdit" disabled ="invoiceForOwner.isEdit" list="companyList" property="invoiceForOwner.CompanyCode" name="companyCode" ng-model="invoiceForOwner.CompanyCode"
										 validation="required" friendly-name="Company" form-name = "invoiceForOwnerForm"></selectivity>
									</div>
									<div class="col-md-7">
										<selectivity ng-if ="!invoiceForOwner.isEdit" list="companyList" property="invoiceForOwner.CompanyCode" name="companyCode" ng-model="invoiceForOwner.CompanyCode"
										 validation="required" friendly-name="Company" form-name = "invoiceForOwnerForm"></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
	      							<label for="inputPassword" class="control-label col-md-5">Invoice Date<span style="color: red;">*</span></label>
	    							<div class="col-md-7">
	   									<div class="input-group input-append date" id="invoice_date">
								          <input type="text" class="form-control input-sm" name="Invoice Date" id="txtInvoiceDate" 
								          ng-model="invoiceForOwner.InvoiceDate" placeholder='dd/mm/yyyy' 
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
										ng-model="invoiceForOwner.BlRelated">
									</label>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span style="color: red;"></span></label>
									<div class="col-md-7">
										<selectivity list="VesselhdrList"
											property="invoiceForOwner.VesselName" id="VesselName" ng-model="invoiceForOwner.VesselName"
											name="VesselName" ></selectivity>
											<!-- validation="required" friendly-name="Vessel" form-name = "invoiceForOwnerForm"  -->
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage<span style="color: red;"></span></label>
									<div class="col-md-7">

										<selectivity list="voyagehdrList" property="invoiceForOwner.Voyage" ng-model="invoiceForOwner.Voyage"
										name ="Voyage" id="Voyage" ></selectivity>
										<!-- validation="required" friendly-name="Voyage" form-name = "invoiceForOwnerForm" -->

									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL</label>
									<div class="col-md-7">
										<selectivity list="PorthdrList" property="invoiceForOwner.Pol"
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
										<selectivity list="customerhdrList" property="invoiceForOwner.CustomerName" id="customer" name="customer" ng-model="invoiceForOwner.CustomerName"
										 validation="required" friendly-name="Customer" form-name = "invoiceForOwnerForm"></selectivity>


									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Payer</label>
									<div class="col-md-7">
									  <ui-select ng-model="invoiceForOwner.MloName" ng-disabled="disabled"  appendToBody="true">
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
										<!-- <selectivity list="mloList" property="invoiceForOwner.MloName" id="Mlo" object="MloName"
										 name="Mlo" ng-model="invoiceForOwner.MloName"
										 validation="required" friendly-name="Payer" form-name = "invoiceForOwnerForm"></selectivity> -->
									</div>
								</div>
							</div>


							<div class="col-md-4" id="blcheck">
								<div class="form-group" ng-if='invoiceForOwner.BlRelated'>
									<label class="col-md-5 control-label">BL</label>
									<div class="col-md-7">

										<selectivity list="blList" property="invoiceForOwner.bl" name="bl"
										validation="required" friendly-name="BL No." form-name = "invoiceForOwnerForm"
											id="bl" ng-model="invoiceForOwner.bl" object="bl"></selectivity>

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
									<div class="col-md-7" ng-if="isFeederCompanyCurrency">
										<!-- <input type="text" class="form-control input-sm" ng-model="invoiceForOwner.CurrencyName" 
										id="CurrencyName" name="Currency" ng-model="invoiceForOwner.CurrencyName"
										 validation="required" friendly-name="Currency" form-name = "invoiceForOwnerForm" /> -->
										 <selectivity list="currencyList" property="invoiceForOwner.CurrencyName" name="Currency"  
											id="CurrencyName" object="currency" validation="required" friendly-name="Currency" form-name = "invoiceForOwnerForm"
											ng-model="invoiceForOwner.CurrencyName" disabled="isFeederCompanyCurrency"></selectivity>
									</div>
									<div class="col-md-7" ng-if="!isFeederCompanyCurrency">
										<selectivity list="currencyList" property="invoiceForOwner.CurrencyName" name="Currency"  
											id="CurrencyName" object="currency" validation="required" friendly-name="Currency" form-name = "invoiceForOwnerForm"
											ng-model="invoiceForOwner.CurrencyName"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Exchange Rate <span style="color: red;">*</span></label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm text-right" name="exchangerate"
											ng-model="invoiceForOwner.ExchangeRate" id="exchangerate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
											ng-blur="exchagerateGIhdr(invoiceForOwner.ExchangeRate)" 
											friendly-name="Exchange Rate" validation="required"/>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Subject</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" id="subject"
											ng-model="invoiceForOwner.Subject"  name="subject">
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
													ng-model="invoiceForOwner.Unit20" />
											</div>
											<div class="col-md-6 custom-col-md-6 pull-left">
												<label class="col-md-3 custom-col-md-3 control-label">40'</label>
												<input type="text" class="col-md-5 input-sm" id="unit40"
													ng-model="invoiceForOwner.Unit40" />
											</div>
										</div>
									</div>
								</div>
							</div>

							

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POD</label>
									<div class="col-md-7">
										<selectivity list="PorthdrList" property="invoiceForOwner.Pod"
											id="Pod"></selectivity>



									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Service</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											id="ServiceName" ng-model="invoiceForOwner.ServiceName" readonly>


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
						
						<tbody ng-repeat="(trIndex, row) in invoiceForOwner.detailList" ng-controller="GItableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{$index}}"><i></i></label></td>
								<td class="visible-left"><label ng-model="row.slNo" id="slNo{{$index}}" ng-bind="row.slNo"></label></td>
								<!-- <td><selectivity list="subGroupList"
									property="row.subGroupCode" id="txtSubGroupCode{{$index}}"></selectivity></td> -->
								<td><selectivity list="AccountHeadList"	property="row.accountHead" id="accountHead{{$index}}"  
								ng-model="row.accountHead" form-name = "invoiceForOwnerForm"
								 name="{{ 'accountHead' + $index }}" validation="required" friendly-name="{{ 'Row' + $index + '(Account Head)'}}" ></selectivity></td>
								<td ng-if="!row.isSubAccountCode"><selectivity list="row.subAccountCodeList"
										property="row.subAccountCode" id="txtSubAccountCode{{$index}}"  disabled = "!row.isSubAccountCode"></selectivity></td>
								<td ng-if="row.isSubAccountCode"><selectivity list="row.subAccountCodeList"
										property="row.subAccountCode" id="txtSubAccountCode{{$index}}"  name="{{ 'SubAccount' + $index }}" ng-model = "row.subAccountCode" form-name = "invoiceForOwnerForm" validation="required" friendly-name="{{ 'Row' + $index + '(Sub Account)'}}"></selectivity></td>
								<td><input class="form-control input-sm" type="text" ng-model="row.narration" id="narration{{$index}}"
								name="narration{{$index}}" validation="required" friendly-name="{{ 'Row' + $index + '(Narration)'}}"></td>
								
								<td><input class="form-control input-sm text-right" type="text"
									ng-model="row.tcAmount" id="TCamount{{$index}}"  step="0.01" ng-keyup="calculateTCtoBCAmount(row.tcAmount,$index,row)" 
									name="TCamount{{$index}}" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"  step="0.01" friendly-name="{{ 'Row' + $index + '(TCamount)'}}">
								</td>
								<td><input class="form-control input-sm text-right" type="text"
									ng-model="row.bcAmount" id="BCamount{{$index}}" step="0.01" ng-keyup="calculateBCtoTCAmount(row.bcAmount,$index,row)"
									name="BCamount{{$index}}" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"  step="0.01" friendly-name="{{ 'Row' + $index + '(BCamount)'}}" >
								</td>
							</tr>
							
							
							
							 <tr>
						        	<td colspan="12">
							        	<div class="col-sm-12">
							        	<!-- Attributes list -->
							        	<!-- <div class="col-sm-3" >
							        	<label class="col-md-5 control-label"> Attriutes </label>
							        	</div> -->
							        	 <div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && !row.isVoyageMan">
											<label class="col-md-4 control-label"> Voyage

											</label>
											<div class="col-md-8">
										              <selectivity list="voyageList" property="row.voyageCode" id="voyageCode{{trIndex}}"></selectivity>
										     </div>
										</div> 
										 <div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && row.isVoyageMan">
											<label class="col-md-4 control-label"> Voyage

											</label>
											<div class="col-md-8">
										              <selectivity list="voyageList"
															property="row.voyageCode"
															id="voyageCode{{trIndex}}"
															ng-model="row.voyageCode" validation="required"
															name="txtSubAccountCode{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
															form-name="invoiceForOwnerForm"
															>
														</selectivity>
										     </div>
										     
										    
										</div>
							        	<div class="col-sm-2 padding-top-5" ng-if="row.isVessel && !row.isVesselMan">
											<label class="col-md-5 control-label"> Vessel

											</label>
											<div class="col-md-7">
										           <selectivity list="vesselList" property="row.vesselCode" id="vesselCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label"> Vessel

											</label>
											<div class="col-md-7">
										          <selectivity list="vesselList"
															property="row.vesselCode"
															id="vesselCode{{trIndex}}"
															ng-model="row.vesselCode" validation="required"
															name="vesselCode{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
															form-name="invoiceForOwnerForm"
															>
														</selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService && !row.isServiceMan">
											<label class="col-md-5 control-label"> Service

											</label>
											<div class="col-md-7">
										             <selectivity list="sectorList" property="row.sectorCode" id="sectorCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService && row.isServiceMan">
											<label class="col-md-5 control-label"> Service

											</label>
											<div class="col-md-7">
									             <selectivity list="sectorList"
														property="row.sectorCode"
														id="sectorCode{{trIndex}}"
														ng-model="row.sectorCode" validation="required"
														name="sectorCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Service)'}}"
														form-name="invoiceForOwnerForm"
														>
													</selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee && !row.isEmployeeMan">
											<label class="col-md-5 control-label"> Employee

											</label>
											<div class="col-md-7">
										           <selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee && row.isEmployeeMan">
											<label class="col-md-5 control-label"> Employee

											</label>
											<div class="col-md-7">
										           <selectivity list="employeeList"
														property="row.isEmployee"
														id="employeeCode{{trIndex}}"
														ng-model="row.employeeCode" validation="required"
														name="employeeCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Employee)'}}"
														form-name="invoiceForOwnerForm"
														>
													</selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort && !row.isPortMan">
											<label class="col-md-5 control-label"> Port

											</label>
											<div class="col-md-7">
										           <selectivity list="portList" property="row.portCode" id="portCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort && row.isPortMan">
											<label class="col-md-5 control-label"> Port

											</label>
											<div class="col-md-7">
										           <selectivity list="portList"
														property="row.portCode"
														id="portCode{{trIndex}}"
														ng-model="row.portCode" validation="required"
														name="portCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Port)'}}"
														form-name="invoiceForOwnerForm"
														>
													</selectivity>
										     </div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence && !row.isPortSequenceMan">
											<label class="col-md-5 control-label"> Port.Seq

											</label>
											<div class="col-md-7">
										          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence && row.isPortSequenceMan">
											<label class="col-md-5 control-label"> Port.Seq

											</label>
											<div class="col-md-7">
										          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" 
										          ng-model="row.portSequence" name="PortSequence" validation="required" friendly-name="{{ 'Row' + $index + '(Port Seq)'}}"/>
										     </div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment && !row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department

											</label>
											<div class="col-md-7">
										           <selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
										     </div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment && row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department

											</label>
											<div class="col-md-7">
										           <selectivity list="departmentList"
														property="row.departmentCode"
														id="departmentCode{{trIndex}}"
														ng-model="row.departmentCode" validation="required"
														name="departmentCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Department)'}}"
														form-name="invoiceForOwnerForm"
														>
													</selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent && !row.isAgentMan">
											<label class="col-md-5 control-label"> Agent

											</label>
											<div class="col-md-7">
										           <selectivity list="agentList" property="row.agentCode" id="agentCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent && row.isAgentMan">
											<label class="col-md-5 control-label"> Agent

											</label>
											<div class="col-md-7">
										           <selectivity list="agentList"
														property="row.agentCode"
														id="agentCode{{trIndex}}"
														ng-model="row.agentCode" validation="required"
														name="agentCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Agent)'}}"
														form-name="invoiceForOwnerForm"
														>
													</selectivity>
										     </div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation && !row.isLocationMan">
											<label class="col-md-5 control-label"> Location

											</label>
											<div class="col-md-7">
										             <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation && row.isLocationMan">
											<label class="col-md-5 control-label"> Location

											</label>
											<div class="col-md-7">
										             <selectivity list="countryList"
														property="row.countryCode"
														id="countryCode{{trIndex}}"
														ng-model="row.countryCode" validation="required"
														name="countryCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Location)'}}"
														form-name="invoiceForOwnerForm"
														>
													</selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer && !row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer

											</label>
											<div class="col-md-7">
										             <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer && row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer

											</label>
											<div class="col-md-7">
										              <selectivity list="customerList"
														property="row.customerCode"
														id="customerCode{{trIndex}}"
														ng-model="row.customerCode" validation="required"
														name="customerCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Customer)'}}"
														form-name="invoiceForOwnerForm"
														>
													</selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier && !row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier

											</label>
											<div class="col-md-7">
										             <selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier && row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier

											</label>
											<div class="col-md-7">
										             <selectivity list="supplierList"
														property="row.supplierCode"
														id="supplierCode{{trIndex}}"
														ng-model="row.supplierCode" validation="required"
														name="supplierCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Supplier)'}}"
														form-name="invoiceForOwnerForm"
														>
													</selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation && !row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation

											</label>
											<div class="col-md-7">
										             <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation && row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation

											</label>
											<div class="col-md-7">
										             <selectivity list="designationList"
														property="row.designationCode"
														id="designationCode{{trIndex}}"
														ng-model="row.designationCode" validation="required"
														name="designationCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Designation)'}}"
														form-name="invoiceForOwnerForm"
														>
													</selectivity>
										     </div>
										</div>
										
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter && !row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr

											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter{{trIndex}}"/>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter && row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr

											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" 
										             ng-model="row.costCenter" name="CostCenter{{trIndex}}" friendly-name="{{ 'Row' + $index + '(Designation)'}}"/>
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
							<button ng-click="addRow(invoiceForOwner.detailList)" class="btn btn-sm btn-info"
								tooltip="Add Row" ng-disabled="" type="button">
								<i class="fa fa-plus"></i>
							</button>
							<button ng-click="removeRow(invoiceForOwner.detailList)" class="btn btn-sm btn-danger"
								type="button" tooltip="Delete">
								<i class="fa  fa-trash-o"></i>
							</button>
						</div>
						<div class="col-md-8">
							<div class="form-group">
								<label class="col-md-6 control-label">Total</label>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm text-right"
										id="TxtTotalTcAmt" name="totalTcAmt"
										ng-model="invoiceForOwner.TotalTCamount" readonly>
								</div>
								<div class="col-md-3">
									<input type="text" class="form-control input-sm text-right"
										id="TxtTotalBcAmt" name="totalBcAmt"
										ng-model="invoiceForOwner.TotalBCamount" readonly>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!invoiceForOwner.isEdit" ng-click="onSubmit(invoiceForOwnerForm,invoiceForOwner)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button"
								ng-if="invoiceForOwner.isEdit" ng-click="onSubmit(invoiceForOwnerForm,invoiceForOwner)">
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
