<style>
.custom-col-md-6 {
	padding-right: 0px;
	padding-left: 0px;
}

.custom-col-md-3 {
	padding-right: 25px;
}

 table.dataTable thead .sorting:after { 
   content: ""; 
 } 
 select{ 
 -webkit-appearance: none; 
   padding: 0; 
  text-indent: 8px; 
   padding : 0 !important; 
 } 
 .input-group-addon{ 
 display:none !important; 
 }
 .form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control { 
  background-color:white !important; 
  border:0px !important; 
 } 
 .b-grey{ 
 border:0px !important;
}
.form-label-control{
line-height: 35px;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="panel-body">
  <div class="modal-header"> GeneralInvoice View </div>
			<form name="generalInvoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
						<input type="hidden" ng-model="generalinvoice.ExchangeRateFrom" id="ExchangeRateFrom" /> 
						<input type="hidden" ng-model="generalinvoice.ExchangeRateTo" id="ExchangeRateTo" /> 
						<input type="hidden" ng-model="generalinvoice.currencyValue" id="currencyValue" /> 
						<input type="hidden" ng-model="generalinvoice.fraction" id="fraction" />

					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Company</label>
									<div class="col-md-7">
										<input type="hidden" ng-model="generalinvoice.companyCode" id="txtCompany" ng-disabled="true" />
								 		<label class="form-label-control" ng-bind="generalinvoice.companyName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
	      							<label for="inputPassword" class="control-label col-md-5 bold">Invoice Date</label>
	    							<div class="col-md-7">
	   									<div class="input-group input-append date" id="invoice_date">								          
								          <label class="form-label-control" ng-bind="generalinvoice.invoiceDate"></label>
								        </div>   									
	    							</div>
			       				</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">BL Related</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm" ng-if="generalinvoice.blRelated=='Y'" value="Yes" ng-disabled="true" />
										<input type="text" class="form-control input-sm" ng-if="generalinvoice.blRelated=='N'" value="No" ng-disabled="true" />
										
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Customer</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.customerName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Payer</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.mloName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4" id="blcheck">
								<div class="form-group">
									<label class="col-md-5 control-label bold">BL</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.bl"></label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Currency</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.currencyName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Exchange Rate</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.exchangeRate"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Subject</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.subject"></label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Vessel</label>
									<div class="col-md-7">
							 			<label class="form-label-control" ng-bind="generalinvoice.vesselName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Voyage</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.voyage"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Service</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.serviceName"></label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Units</label>
									<div class="col-md-7">
										<div class="row">
											<div class="col-md-6 custom-col-md-6 pull-left ">
												<label class="col-md-3 custom-col-md-3 control-label">20'</label>
												<label class="form-label-control" ng-bind="generalinvoice.unit20"></label>
											</div>
											<div class="col-md-6 custom-col-md-6 pull-left">
												<label class="col-md-3 custom-col-md-3 control-label">40'</label>
												<label class="form-label-control" ng-bind="generalinvoice.unit40"></label>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">POL</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.pol"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">POD</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.pod"></label>
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
								<th colspan=1 class="width_2 text-center visible-left">Sl No</th>
								<th colspan=1 class="width_13 text-center">Account Head</th>								
								<th colspan=1 class="width_13 text-center">Sub Accout Code</th>
								<th colspan=1 class="width_13 text-center">Narration</th>
								<th colspan=1 class="width_10 text-center">TC Amount</th>
								<th colspan=1 class=" width_10 text-center">BC Amount({{companyCurrency}})</th>								
							</tr>
						</thead>
						
						<tbody ng-repeat="(trIndex, row) in generalinvoice.giDtl" ng-controller="GItableViewCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{$index}}"><i></i></label></td>
								<td class="visible-left"><label ng-model="row.slNo" id="slNo{{$index}}" ng-bind="row.slNo"></label></td>
								
								<td>
								 <input type="hidden"  id="txtSubGroupCode{{$index}}"  ng-model="row.accountHead" />
								 <label class="form-label-control" ng-bind="row.accountHeadName"></label>
								 </td>
								<td>
								 <input type="hidden" ng-model="row.subAccountCode" />
								  <label class="form-label-control" ng-bind="row.subAccountName"></label>
								 </td>
								<td>
									<label class="form-label-control" ng-bind="row.narration"></label>
								</td>
								
								<td>
									<label class="form-label-control" ng-bind="row.tcAmount"></label>
								</td>
								<td>
									<label class="form-label-control" ng-bind="row.bcAmount"></label>
								</td>
							</tr>
							 <tr>
						        	<td colspan="12">
							        	<div class="col-sm-12">
							        	<fieldset ng-disabled="viewDisable">
							        	<!-- Attributes list -->
							        	
							        	<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage">
											<label class="col-md-5 control-label bold"> Voyage
												
											</label>
											<div class="col-md-7">
								 				<label class="form-label-control" ng-bind="row.voyageCode"></label>
										     </div>
										</div>
							        	<div class="col-sm-2 padding-top-5" ng-if="row.isVessel">
											<label class="col-md-5 control-label bold"> Vessel
												
											</label>
											<div class="col-md-7">
								 				<label class="form-label-control" ng-bind="row.vesselName"></label>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService">
											<label class="col-md-5 control-label bold"> Service
											</label>
											<div class="col-md-7">
								 				<label class="form-label-control" ng-bind="row.sectorName"></label>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
											<label class="col-md-5 control-label bold"> Employee
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="employeeCode{{trIndex}}" ng-model="row.employeeCode" ng-options="emp.id as emp.text for emp in employeeList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort">
											<label class="col-md-5 control-label bold"> Port
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="portCode{{trIndex}}" ng-model="row.portCode" ng-options="port.id as port.text for port in portList">
								 				</select>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
											<label class="col-md-5 control-label bold"> Port.Seq
												
											</label>
											<div class="col-md-7">
										          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
											<label class="col-md-5 control-label bold"> Department
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="departmentCode{{trIndex}}" ng-model="row.departmentCode" ng-options="dep.id as dep.text for dep in departmentList">
								 				</select>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
											<label class="col-md-5 control-label bold"> Agent
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="agentCode{{trIndex}}" ng-model="row.agentCode" ng-options="agent.id as agent.text for agent in agentList">
								 				</select>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
											<label class="col-md-5 control-label bold"> Location
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="countryCode{{trIndex}}" ng-model="row.countryCode" ng-options="country.id as country.text for country in countryList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
											<label class="col-md-5 control-label bold"> Customer
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="customerCode{{trIndex}}" ng-model="row.customerCode" ng-options="cus.id as cus.text for cus in customerList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
											<label class="col-md-5 control-label bold"> Supplier
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="supplierCode{{trIndex}}" ng-model="row.supplierCode" ng-options="sup.id as sup.text for sup in supplierList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
											<label class="col-md-5 control-label bold"> Designation
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="designationCode{{trIndex}}" ng-model="row.designationCode" ng-options="desig.id as desig.text for desig in designationList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
											<label class="col-md-5 control-label bold"> CostCtr
												
											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCompany">
											<label class="col-md-5 control-label bold"> Company
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="companyCode{{trIndex}}" ng-model="row.companyCode" ng-options="company.id as company.text for company in companyList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
											<label class="col-md-5 control-label bold">Qty(MT)GO</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO"/>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
											<label class="col-md-5 control-label bold">Qty(MT)FO</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO"/>
										     </div>
										</div>
										</fieldset>
										</div>
								    </td> 		             	
						       </tr>
						</tbody>
					</table>
					<div class="padding-right-5">
						<div class="col-md-12">
						<fieldset ng-disabled="viewDisable">
							<div class="form-group">
								<label class="col-md-2 col-md-offset-6 control-label">Total</label>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm"
										id="TxtTotalTcAmt" name="totalTcAmt"
										ng-model="generalinvoice.TotalTCamount" readonly>
								</div>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm"
										id="TxtTotalBcAmt" name="totalBcAmt"
										ng-model="generalinvoice.TotalBCamount" readonly>
								</div>
							</div>
						</fieldset>
						</div>
					</div>
				</div>

				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-danger" ng-if="generalInvoiceTable!=true" ng-click="cancel()" type="button">
								<i class="fa fa-close"></i> Cancel
							</button>
							<button class="btn btn-success" ng-if="generalInvoiceTable!=true" ng-click="printGeneralInvoiceDiv(generalinvoice.invoiceNo)"  type="button">
				        	  Print
				          	</button> 
               <button class="btn btn-danger" ng-if="generalInvoiceTable==true" ng-click="cancel1()" type="button">
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
