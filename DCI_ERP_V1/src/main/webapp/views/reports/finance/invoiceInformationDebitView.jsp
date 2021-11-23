<style>
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
 .form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control 


 { 
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
		<div class="panel-heading panel-heading-form font-bold">
			
		</div>
		<div class="panel-body">
  <div class="modal-header"> DebitNote View </div>
			<form name="DebitNoteForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12">
					<fieldset ng-disabled="viewDisable">
						<div class="col-lg-4 col-sm-4 col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label bold">Debit Note Date</label>
								<div class="col-md-7">
									<div class="input-group input-append date" id="cn_date">
										<input type="text" class="form-control input-sm"
											placeholder="dd/mm/yyyy"
											ng-model="DebitNoteMasterData.debitNoteDate" name="Date"
											id="debitNoteDate" ng-disabled="true"> 
										</span>
									</div>									
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label bold">Payer</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" id="acctHeadName" name="acctHeadName"  ng-model="DebitNoteMasterData.acctHeadName" ng-disabled="true" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label bold">Invoice Number</label>
								<div class="col-md-7 ">
									<input type="text" class="form-control input-sm"
										id="acctHeadName" name="acctHeadName"
										ng-model="DebitNoteMasterData.invoiceNo"  ng-disabled="true" />	
								</div>
							</div>

						</div>
						<div class="col-lg-4 col-sm-4 col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label bold">Invoice Date</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="invoiceDate" name="invoiceDate" ng-model="DebitNoteMasterData.invoiceDate"  ng-disabled="true" />
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label bold">Currency</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="currencyCode" name="currencyCode"
										ng-model="DebitNoteMasterData.currencyCode"  ng-disabled="true" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label bold">Exchange Rate</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="exchangeRate" name="exchangeRate"
										ng-model="DebitNoteMasterData.exchangeRate"  ng-disabled="true"/>
								</div>
							</div>

						</div>
						<div class="col-lg-4 col-sm-4 col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label bold">Company</label> 
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="companyName" name="companyName"
										data-ng-model="DebitNoteMasterData.companyName"  ng-disabled="true"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label bold">Narration</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" id="narration"
										name="narration" data-ng-model="DebitNoteMasterData.narration" ng-disabled="true"  />
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
								<th colspan=1 class="width_13 text-center">Account Head</th>
								<th colspan=1 class="width_13 text-center">Sub Account</th>
								<!-- <th colspan=1 class="width_10 text-center">Description</th> -->
								<th colspan=1 class="width_10 text-center">Narration</th>
								<th colspan=1 class="width_10 text-center">TC Amt({{DebitNoteMasterData.currencyCode}})</th>
								<th colspan=1 class=" width_10 text-center">BC Amt({{DebitNoteMasterData.companyCurrency}})</th>
								
								<th colspan=1 class="width_1"></th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in DebitNoteMasterData.debittables"  ng-controller="tableViewCtrl">
							<tr>
								<td>
							
									<div class="row">
										<div class="col-xs-12">
										   <input type="text" class="form-control input-sm"  id="AcctCode{{$index}}" name="AcctCode{{$index}}"
										ng-model="row.accountHeadName" ng-disabled="true"/>
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
										
											<input type="text" class="form-control input-sm"  id="subAcctCode{{$index}}" name="AcctCode{{$index}}"
											ng-model="row.subAcctName" ng-disabled="true"/>
										</div>
									</div>
								</td>											
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="narration" data-ng-model="row.dtlNarration" ng-disabled="true" />
										</div>
									</div>
								</td>
								
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" ng-disabled="true"
												name="bcAmount" data-ng-model="row.bcAmount" />
										</div>
									</div>
								</td>
								
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="tcAmount" data-ng-model="row.tcAmount"											
												ng-disabled="true" />
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="12">
									<div class="col-sm-12">
									<fieldset ng-disabled="viewDisable">
										<!-- Attributes list -->
										<!-- <div class="col-sm-3" >
							        	<label class="col-md-5 control-label"> Attriutes </label>
							        	</div> -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage">
											<label class="col-md-5 control-label bold"> Voyage </label>
											<div class="col-md-7">
												<!-- <select class="form-control input-sm"
													id="voyageCode{{trIndex}}" ng-model="row.voyageCode"
													ng-options="voy.id as voy.text for voy in voyageList">
												</select> -->
												<!-- <input type="text" class="form-control input-sm"  id="voyageCode{{trIndex}}" name="voyageCode{{trIndex}}"
												ng-model="row.voyageCode" ng-disabled="true"/> -->
												<label class="form-label-control" ng-bind="row.voyageCode"></label>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isVessel">
											<label class="col-md-5 control-label bold"> Vessel </label>
											<div class="col-md-7">
												<!-- <select class="form-control input-sm"
													id="vesselCode{{trIndex}}" ng-model="row.vesselCode"
													ng-options="ves.id as ves.text for ves in vesselList">
												</select> -->
												<label class="form-label-control" ng-bind="row.vesselName"></label>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService">
											<label class="col-md-5 control-label bold"> Service </label>
											<div class="col-md-7">
												<!-- <select class="form-control input-sm"
													id="sectorCode{{trIndex}}" ng-model="row.sectorCode"
													ng-options="sec.id as sec.text for sec in sectorList">
												</select> -->
												<label class="form-label-control" ng-bind="row.sectorName"></label>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
											<label class="col-md-5 control-label"> Employee </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="employeeCode{{trIndex}}" ng-model="row.employeeCode"
													ng-options="emp.id as emp.text for emp in employeeList">
												</select>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort">
											<label class="col-md-5 control-label"> Port </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="portCode{{trIndex}}" ng-model="row.portCode"
													ng-options="port.id as port.text for port in portList">
												</select>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
											<label class="col-md-5 control-label"> Port.Seq </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													id="PortSequence{{trIndex}}" ng-model="row.portSequence"
													name="PortSequence" />
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
											<label class="col-md-5 control-label"> Department </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="departmentCode{{trIndex}}"
													ng-model="row.departmentCode"
													ng-options="dep.id as dep.text for dep in departmentList">
												</select>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
											<label class="col-md-5 control-label"> Agent </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="agentCode{{trIndex}}" ng-model="row.agentCode"
													ng-options="agent.id as agent.text for agent in agentList">
												</select>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
											<label class="col-md-5 control-label"> Location </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="countryCode{{trIndex}}" ng-model="row.countryCode"
													ng-options="country.id as country.text for country in countryList">
												</select>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
											<label class="col-md-5 control-label"> Customer </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="customerCode{{trIndex}}" ng-model="row.customerCode"
													ng-options="cus.id as cus.text for cus in customerList">
												</select>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
											<label class="col-md-5 control-label"> Supplier </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="supplierCode{{trIndex}}" ng-model="row.supplierCode"
													ng-options="sup.id as sup.text for sup in supplierList">
												</select>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
											<label class="col-md-5 control-label"> Designation </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="designationCode{{trIndex}}"
													ng-model="row.designationCode"
													ng-options="desig.id as desig.text for desig in designationList">
												</select>
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
												<select class="form-control input-sm"
													id="companyCode{{trIndex}}" ng-model="row.companyCode"
													ng-options="company.id as company.text for company in companyList">
												</select>
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
										</fieldset>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- /table-responsive -->

				<div class="row">
					<div class="col-sm-12">
						<div class="form-group pull-right">
							
							<label class="col-md-3 control-label">Total TC Amt({{DebitNoteMasterData.currencyCode}})</label>
							<div class="col-md-3">
								<input type="text" class="form-control input-sm"
									name="totalTCAmount"
									data-ng-model="debitnoteDtlTotalAmt.totalTCAmount"
									ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
							</div>
							
							<label class="col-md-3 control-label">Total BC Amt({{DebitNoteMasterData.companyCurrency}})</label>
							<div class="col-md-3">
								<input type="text" class="form-control input-sm"
									name="totalBCAmount"
									data-ng-model="debitnoteDtlTotalAmt.totalBCAmount"
									ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
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
										
          <button class="btn btn-danger" ng-if="debitNoteTable==true" ng-click="cancel1()"
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

