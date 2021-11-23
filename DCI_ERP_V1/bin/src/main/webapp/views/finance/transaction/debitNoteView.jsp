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
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<div class="panel-heading panel-heading-form font-bold">
			<ol class="breadcrumb inline-block padding-left-10">
				<li><a>Finance</a></li>
				<li><a x-ui-sref="app.finance.transaction">Transaction</a></li>
				<li><a x-ui-sref="app.finance.transaction.debitnote">Debit
						Note</a></li>
				<li><a x-ui-sref="app.finance.transaction.debitnoteform">View</a>
				</li>
			</ol>
		</div>
		<div class="panel-body">
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
							<!-- <div class="form-group ">
								<label class="col-md-5 control-label bold">Payer</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" id="acctHeadName" name="acctHeadName"  ng-model="DebitNoteMasterData.acctHeadName" ng-disabled="true" />
								</div>
							</div> -->
							<div class="form-group">
								<label class="col-md-5 control-label bold">Invoice Number</label>
								<div class="col-md-7 ">
									<input type="text" class="form-control input-sm"
										id="acctHeadName" name="acctHeadName"
										ng-model="DebitNoteMasterData.invoiceNo"  ng-disabled="true" />	
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-5 control-label bold">Customer/Supplier</label>
								<div class="col-md-7 ">
									<input type="text" class="form-control input-sm"
										id="acctHeadName" name="acctHeadName"
										ng-model="DebitNoteMasterData.accountHeadCode"  ng-disabled="true"/>	
								</div>
							</div>
							
								<!-- <div class="form-group">
								<label class="col-md-5 control-label bold">Exchange Rate</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="exchangeRate" name="exchangeRate"
										ng-model="DebitNoteMasterData.exchangeRate"  ng-disabled="true"/>
								</div>
							</div> -->

						</div>
						<div class="col-lg-4 col-sm-4 col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label bold">Invoice Date</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="invoiceDate" name="invoiceDate" ng-model="DebitNoteMasterData.debitNoteDate"  ng-disabled="true" />
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
							<!-- <div class="form-group ">
								<label class="col-md-5 control-label bold">Currency</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="currencyCode" name="currencyCode"
										ng-model="DebitNoteMasterData.currencyCode"  ng-disabled="true" />
								</div>
							</div> -->
							
							
							 <!-- <div class="form-group">
						        <label class="col-md-5 control-label bold">Attached Files</label>
						        <div class="col-md-7">
						         	<span data-ng-if="creditnoteAcctData.filePath !== null "  title="Download" class="tool-tip-span font-blue padding-right-5 ng-scope ">
		      				   			<i class="fa fa-download text-dark text" style="color: #10DA10;"></i>
		      				   			
		      				   			
		      				   			<button class="btn btn-info input-sm" id="download1" type="button" ng-click="downloadFiles(DebitNoteMasterData.filePath)" data-toggle="tooltip" title="Download File">
											Download
										</button>
		        					</span>
		        				 </div>
					       </div>
				         <a id="fileExport" class="link"
             href="{{DebitNoteMasterData.filePath}}" download></a> -->
						<!-- 	<div class="form-group">
								<label class="col-md-5 control-label bold">Exchange Rate</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										id="exchangeRate" name="exchangeRate"
										ng-model="DebitNoteMasterData.exchangeRate"  ng-disabled="true"/>
								</div>
							</div> -->

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
								<th colspan=1 class="width_13 text-center">Charge Head</th>
								<th colspan=1 class="width_10 text-center">Sac No</th>
								<th colspan=1 class="width_10 text-center">Exchange Rate</th>
								<th colspan=1 class="width_10 text-center">Currency</th>
								<!-- <th colspan=1 class="width_10 text-center">Amount (INR)</th> -->
								<th colspan=1 class=" width_10 text-center">Amount</th>
								
								<th colspan=1 class="width_1"></th>
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex, row) in DebitNoteMasterData.debittables"  ng-controller="tableViewCtrl">
							<tr>
								<td>
							
									<div class="row">
										<div class="col-xs-12">
										   <input type="text" class="form-control input-sm"  id="drdtlAccountHead{{$index}}" name="drdtlAccountHead{{$index}}"
										ng-model="row.drdtlAccountHead" ng-disabled="true"/>
										</div>
									</div>
								</td>
								<td>
								<div class="row">
				            		<div class="col-xs-12">
				            		
				            			<input type="text" class="form-control input-sm" id="sacNo{{$trIndex}}" name="sacNo" ng-model="row.sacNo" required  readonly/>
				            		
				            		</div>
				        		</div>
			           		</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
										
											<input type="text" class="form-control input-sm"  id="exchangeRate{{$trIndex}}" name="exchangeRate"
											ng-model="row.exchangeRate" ng-disabled="true"/>
										</div>
									</div>
								</td>											
								<td class="width_10">
				          		<div class="row" >
				            		<div class="col-xs-12">
				         	  			<input type="text" class="form-control input-sm" name="currency" data-ng-model="row.currency" required readonly/>
				              		</div>
				              	</div>
				            </td>
								
								<!-- <td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" ng-disabled="true"
												name="tcAmount" data-ng-model="row.tcAmount" />
										</div>
									</div>
								</td> -->
								
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												name="bcAmount" data-ng-model="row.bcAmount"											
												ng-disabled="true" />
										</div>
									</div>
								</td>
							</tr>
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
							<!-- <tr>
								<td colspan="12">
									<div class="col-sm-12">
									<fieldset ng-disabled="viewDisable">
										Attributes list
										<div class="col-sm-3" >
							        	<label class="col-md-5 control-label"> Attriutes </label>
							        	</div>
							        		<div class="col-sm-2 padding-top-5" >
									<label class="col-md-5 control-label bold"> Job Order No.
									</label>
									<div class="col-md-7">
										
										<input type="text" class="form-control input-sm" name="voyageCode" ng-model="row.voyageCode" id="voyageCode{{trIndex}}" required readonly/>
										<label class="form-label-control" ng-bind="row.voyageName"></label>
									<select  list ="voyageList" ng-model="row.voyageCode" ng-options="voyage.voyageCode as voyage.voyageCode for voyage in voyageList" id="voyageCode{{trIndex}}" disabled>
				            		  <option value="">select</option>
				            			</select>
									 </div>
								
								</div>
										<div class="col-sm-2 padding-top-5" >
											<label class="col-md-5 control-label bold"> Trip </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="voyageCode{{trIndex}}" ng-model="row.voyageCode"
													ng-options="voy.id as voy.text for voy in voyageList">
												</select>
												<input type="text" class="form-control input-sm"  id="voyageCode{{trIndex}}" name="voyageCode{{trIndex}}"
												ng-model="row.voyageCode" ng-disabled="true"/>
												<label class="form-label-control" ng-bind="row.voyageName"></label>
											</div>
										</div>
										
										<div class="col-sm-2 padding-top-5" >
											<label class="col-md-5 control-label bold"> Mode </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="vesselCode{{trIndex}}" ng-model="row.vesselCode"
													ng-options="ves.id as ves.text for ves in vesselList">
												</select>
												<label class="form-label-control" ng-bind="row.vesselName"></label>
											</div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService">
											<label class="col-md-5 control-label bold"> Service </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="sectorCode{{trIndex}}" ng-model="row.sectorCode"
													ng-options="sec.id as sec.text for sec in sectorList">
												</select>
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
													ng-options="dep.id as dep.text for dep in departmentList"disabled="true">
												</select>
											</div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
											<label class="col-md-5 control-label"> Agent </label>
											<div class="col-md-7">
												<select class="form-control input-sm"
													id="agentCode{{trIndex}}" ng-model="row.agentCode"
													ng-options="agent.id as agent.text for agent in agentList" >
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
													ng-options="sup.id as sup.text for sup in supplierList"disabled="true">
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
							</tr> -->
						</tbody>
					</table>
				</div>
				<!-- /table-responsive -->
				<div class="col-md-12">
					<div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total Amount</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right ng-pristine ng-untouched ng-valid" ng-model="debitnoteDtlTotalAmt.totalBCAmount" readonly="" name="totalBCAmount"  placeholder="0.0">
										</div>

									</div>
									<!-- <div class="form-group" style="float: right;">
										<label class="col-md-6 control-label">Total Amount(INR)</label>
								
										<div class="col-md-6">
											<input type="text" class="form-control input-sm text-right ng-pristine ng-untouched ng-valid" ng-model="DebitNoteMasterData.totalTCAmount" readonly="" name="totalTCAmount" placeholder="0.0">
										</div>

									</div> -->
								<div class="form-group" style="float: right;">
								
									<label class="col-md-6 control-label">Total Tax Amount</label>

									<div class="col-md-6">
										<input type="text" class="form-control input-sm text-right ng-pristine ng-untouched ng-valid" ng-model="debitnoteDtlTotalAmt.totaltaxAmount" readonly="" name="totaltaxAmount" placeholder="0.0">
									</div>

								</div>
								
								
							</div>

				<!-- <div class="row">
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
				</div> -->

				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
									<button class="btn btn-danger"  ng-if="debitNoteTable==true" ng-click="cancel1()"
											type="button">
											<i class="fa fa-close"></i> Cancel
										</button>
										<button class="btn btn-danger"  ng-if="debitNoteTable==false" ng-click="cancel()"
											type="button">
											<i class="fa fa-close"></i> Cancel
										</button>
         
										<button class="btn btn-success" ng-if="debitNoteTable==false" ng-click="printDebitNoteDiv(DebitNoteMasterData.debitNoteNo)"  type="button">
							        	  Print
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

