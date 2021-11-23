<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="js/vendor/signaturepad/jquery.signaturepad.js"></script>
<style>
table.dataTable thead .sorting:after {
  content: "";
}

.input-group-addon{
display:none !important;
}
.form-control
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
	<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body"  id="generatePdf">
	   		<form name="creditNoteForm" class="form-horizontal" novalidate>
			    <div class="row book-widget-row" >
			     	<div class="col-sm-12">
				    	<div class="col-sm-4">
					     	<div class="form-group">
						        <label class="col-md-5 control-label bold">Credit Note Date</label>
						        <div class="col-md-7">
									<div class="input-group input-append date" id="cn_date" >
										<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
												ng-model="creditnoteAcctData.creditNoteDate" name="Date" id="creditNoteDate" readonly />
										
												
								     </div>
								</div>
					     	</div>
					     	<div class="form-group ">
						        <label class="col-md-5 control-label bold">Customer/Supplier</label>
						        <div class="col-md-7">							     
									<label class="form-label-control" ng-bind="creditnoteAcctData.mloName"></label>				
						        </div>
					       	</div>
					       	<div class="form-group">
						        <label class="col-md-5 control-label bold">Job Order</label>
						        <div class="col-md-7">
						       
												<input type="text" class="form-control input-sm" id="jobOrder" name="jobOrder"
						          ng-model="creditnoteAcctData.jobOrderName" required ng-disabled="true" readonly />
						        </div>
					     	</div>
					       	
					      	<!-- <div class="form-group">
						        <label class="col-md-5 control-label bold">Invoice Number</label>
						        <div class="col-md-7 ">
							         	<input type="text" class="form-control input-sm" 
												ng-model="creditnoteAcctData.invoiceNo" name="Date" id="invoiceNo" readonly>
						        </div>
					       	</div> -->
				    	</div>
					    <div class="col-sm-4">
					    <div class="form-group">
						        <label class="col-md-5 control-label bold">Invoice No</label>
						        <div class="col-md-7">
						         <!--  <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
												ng-model="creditnoteAcctData.creditNoteDate" name="Date" id="creditNoteDate" readonly /> -->
												<input type="text" class="form-control input-sm" id="invoiceDate" name="invoiceDate"
						          ng-model="creditnoteAcctData.invoiceNo" required ng-disabled="true" readonly />
						        </div>
					     	</div>
					    	<div class="form-group">
						        <label class="col-md-5 control-label bold">Invoice Date</label>
						        <div class="col-md-7">
						         <!--  <input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"
												ng-model="creditnoteAcctData.creditNoteDate" name="Date" id="creditNoteDate" readonly /> -->
												<input type="text" class="form-control input-sm" id="invoiceDate" name="invoiceDate"
						          ng-model="creditnoteAcctData.invoiceDate" required ng-disabled="true" readonly />
						        </div>
					     	</div>
					     	<!-- <div class="form-group ">
						        <label class="col-md-5 control-label bold">Currency</label>
						        <div class="col-md-7">
						        	<input type="text" class="form-control input-sm" id="currencyCode" name="currencyCode"
						        	ng-model="creditnoteAcctData.currencyCode"  required  readonly/>
						        </div>
					       	</div> -->
					       	
					       	
				
					    </div>
				    <div class="col-sm-4">
				    	<div class="form-group">
					        <label class="col-md-5 control-label bold">Company</label>
					        <div class="col-md-7">
			
					        	<input type="hidden" class="form-control" id="companyCode" name="companyCode" data-ng-model="creditnoteAcctData.companyCode" />
					         	<input type="text" class="form-control input-sm" id="company" name="company" data-ng-model="creditnoteAcctData.company" readonly />
					        </div>
				       </div>
				       <div class="form-group">
					        <label class="col-md-5 control-label bold">Narration</label>
					        <div class="col-md-7">
					         	<input type="text" class="form-control input-sm" id="narration" name="narration" data-ng-model="creditnoteAcctData.narration" required  readonly/>
					        </div>
				       </div>
				       
				       <!--  <div class="form-group">
						        <label class="col-md-5 control-label bold">Attached Files</label>
						        <div class="col-md-7">
						         	<span data-ng-if="creditnoteAcctData.filePath !== null "  title="Download" class="tool-tip-span font-blue padding-right-5 ng-scope ">
		      				   			<i class="fa fa-download text-dark text" style="color: #10DA10;"></i>
		      				   			
		      				   			<button class="btn btn-info input-sm" id="download1" type="button" ng-click="downloadFiles(creditnoteAcctData.filePath)" data-toggle="tooltip" title="Download File">
											Download
										</button>
		        					</span>
		        				 </div>
					       </div>
				         <a id="fileExport" class="link"
             href="{{creditnoteAcctData.filePath}}" download></a> -->
				       
				    </div>
			   		</div>
			   </div> <!-- /row -->
			    <div class="table-responsive clear">
			      <table class="table table-striped b-t b-light">
			        <thead>
			          <tr>
			            <th colspan=1 class="width_13 text-center">Charge Head</th>
			            <th colspan=1 class="width_10 text-center">Sac No</th>
			           <th colspan=1 class="width_10 text-center">Exchange Rate</th>
								<th colspan=1 class="width_10 text-center">Currency</th>
			            <!-- <th colspan=1 class=" width_10 text-center">Amount (INR)</th> -->
			            <th colspan=1 class="width_10 text-center">Amount</th>
			            <th colspan=1 class="width_1"></th>
			          </tr>
			        </thead>
			        <tbody ng-repeat="(trIndex, row) in creditnoteAcctData.credittables" ng-controller="tableViewCtrl">
			        	<tr>
				            <td>
				            	<div class="row">
				            		<div class="col-xs-12">
				            			<input type="text" class="form-control input-sm" id="crdtlAccountHead{{trIndex}}" name="crdtlAccountHead" data-ng-model="row.crdtlAccountHead" readonly/>
				            			
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
				            		
				            			<input type="text" class="form-control input-sm" id="exchangeRate{{$trIndex}}" name="exchangeRate" ng-model="row.exchangeRate" required  readonly/>
				            		
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
				            <!-- <td align="right">
				            	<div class="row" >
				            		<div class="col-xs-12">
				         	  			<input type="text" class="form-control input-sm text-right" name="tcamount" data-ng-model="row.tcamount"
				         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="amountCalculation(row.tcamount,trIndex,row)" required  readonly/>
				              		</div>
				              	</div>
				            </td> -->
				            <td align="right">
					           	<div class="row">
					           		<div class="col-xs-12">
					        	  	<input type="text" class="form-control input-sm text-right" name="bcamount" data-ng-model="row.bcamount" required readonly/>
					             	</div>
					            </div>
				            </td>
			     		</tr>  
			     		<!-- IGST -->	
									<tr ng-if="row.igstsh != null && row.igstsh != ''">
										

										<td style="text-align: right;">
										    <!-- <div class="row">
												<div class="col-xs-12"> -->
													{{row.igstsh}}
											    <!-- <input type="text" class="form-control input-sm text-right"
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
										<td style="text-align:right;">
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
										

										<td style="text-align: right;">
										    <div class="row">
												<div class="col-xs-12">
													{{row.cgstsh}}
											    <!-- <input type="text" class="form-control input-sm text-right"
														id="cgstsh{{trIndex}}" ng-model="row.cgstsh"
														name="cgstsh"form-name="purchaseInvoiceForm" disabled> -->
												</div>
											</div></td>
											<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="cgstnam{{trIndex}}" ng-model="row.cgstnam"
														name="igstnam" disabled>
												</div>
											</div>
										</td> -->	
										<td style="text-align:right;">
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
										

										<td style="text-align: right;">
										    <div class="row">
												<div class="col-xs-12">
													{{row.sgstsh}}
											    <!-- <input type="text" class="form-control input-sm text-right"
														id="sgstsh{{trIndex}}" ng-model="row.sgstsh"
														name="sgstsh"form-name="purchaseInvoiceForm" disabled> -->
												</div>
											</div></td>
											<!-- <td>
											<div class="row">
												<div class="col-xs-12">
													<input type="text" class="form-control input-sm "
														id="sgstnam{{trIndex}}" ng-model="row.sgstnam"
														name="sgstnam" disabled>
												</div>
											</div>
										</td>	 -->
										<td style="text-align:right;">
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
			     		 <!-- <tr>
				        	<td colspan="12">
					        	<div class="col-sm-12">
					        	
					        	<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage">
									<label class="col-md-5 control-label bold"> Job Order No.
									</label>
									<div class="col-md-7">
										
										<input type="text" class="form-control input-sm" name="voyageCode" ng-model="row.voyageCode" id="voyageCode{{trIndex}}" required readonly/>
										<label ng-bind="row.voyageName"></label>
									<select  list ="voyageList" ng-model="row.voyageCode" ng-options="voyage.voyageCode as voyage.voyageCode for voyage in voyageList" id="voyageCode{{trIndex}}" disabled>
				            		  <option value="">select</option>
				            			</select>
									 </div>
								
								</div>
					        	<div class="col-sm-2 padding-top-5" >
									<label class="col-md-5 control-label bold"> Mode
										
									</label>
										<div class="col-md-7">
										
										<input type="text" class="form-control input-sm" name="vesselCode" ng-model="row.vesselCode" id="vesselCode{{trIndex}}" required readonly/>
										<label ng-bind="row.vesselName"></label>
										<select  list ="vesselList" ng-model="row.vesselCode" ng-options="vessel.vesselCode as vessel.vesselCode for vessel in vesselList" id="vesselCode{{trIndex}}" disabled>
				            		  	<option value="">select</option>
				            			</select>
									</div>
								</div>
								<div class="col-sm-2 padding-top-5" ng-if="row.isService">
									<label class="col-md-5 control-label bold"> Service
										
									</label>
									<div class="col-md-7">
									
										<input type="text" class="form-control input-sm" name="sectorCode" ng-model="row.sectorCode" id="sectorCode{{trIndex}}" required readonly/>
										<label ng-bind="row.sectorName"></label>
										<select  list ="sectorList" ng-model="row.sectorCode" ng-options="sector.sectorCode as sector.sectorCode for sector in sectorList" id="sectorCode{{trIndex}}" disabled>
				            		  	<option value="">select</option>
				            			</select>
								    </div>
								</div>
								<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
									<label class="col-md-5 control-label bold"> Employee
										
									</label>
									<div class="col-md-7">
									
											<input type="text" class="form-control input-sm" name="employeeCode" ng-model="row.employeeCode" id="employeeCode{{trIndex}}" required readonly/>
											
										<select  list ="employeeList" ng-model="row.employeeCode" ng-options="employee.employeeCode as employee.employeeCode for employee in employeeList" id="employeeCode{{trIndex}}" disabled>
				            		  	<option value="">select</option>
				            			</select>
									 </div>
								</div>
								<div class="col-sm-2 padding-top-5" ng-if="row.isPort">
									<label class="col-md-5 control-label bold"> Port
										
									</label>
									<div class="col-md-7">
											<input type="text" class="form-control input-sm" name="portCode"  ng-model="row.portCode" id="portCode{{trIndex}}" required readonly/>
										<select  list ="portList" ng-model="row.portCode" ng-options="port.portCode as port.portCode for port in portList" id="portCode{{trIndex}}" disabled>
				            		  	<option value="">select</option>
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
										<input type="text" class="form-control input-sm" name="departmentCode"  ng-model="row.departmentCode" id="departmentCode{{trIndex}}" required readonly/>
										<select  list ="departmentList" ng-model="row.departmentCode" ng-options="department.departmentCode as department.departmentCode for department in departmentList" id="departmentCode{{trIndex}}" disabled>
				            		  	<option value="">select</option>
				            			</select>
									</div>
								</div>
								
								<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
									<label class="col-md-5 control-label bold"> Agent
										
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" name="agentCode"  ng-model="row.agentCode" id="agentCode{{trIndex}}" required readonly/>
										<select  list ="agentList" ng-model="row.agentCode" ng-options="agent.agentCode as agent.agentCode for agent in agentList" id="agentCode{{trIndex}}" disabled>
				            		  	<option value="">select</option>
				            			</select>
				            		 </div>
								</div>
								
								<div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
									<label class="col-md-5 control-label bold"> Location
										
									</label>
									<div class="col-md-7">
												<input type="text" class="form-control input-sm" name="countryCode"  ng-model="row.countryCode" id="countryCode{{trIndex}}" required readonly/>
											<select  list ="countryList" ng-model="row.countryCode" ng-options="country.countryCode as country.countryCode for country in countryList" id="countryCode{{trIndex}}" disabled>
				            		  			<option value="">select</option>
				            				</select>
								           
								     </div>
								</div>
								<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
									<label class="col-md-5 control-label bold"> Customer
										
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" name="customerCode"  ng-model="row.customerCode" id="customerCode{{trIndex}}" required readonly/>
											<select  list ="customerList" ng-model="row.customerCode" ng-options="customer.customerCode as customer.customerCode for customer in customerList" id="customerCode{{trIndex}}" disabled>
				            		  			<option value="">select</option>
				            				</select>
								   </div>
								</div>
								<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
									<label class="col-md-5 control-label bold"> Supplier
										
									</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm" name="supplierCode"  ng-model="row.supplierCode" id="supplierCode{{trIndex}}" required readonly/>
											<select  list ="supplierList" ng-model="row.supplierCode" ng-options="supplier.supplierCode as supplier.supplierCode for supplier in supplierList" id="supplierCode{{trIndex}}" disabled>
				            		  			<option value="">select</option>
				            				</select>
								   	</div>
								</div>
								<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
									<label class="col-md-5 control-label bold"> Designation
										
									</label>
									<div class="col-md-7">
											<input type="text" class="form-control input-sm" name="designationCode"  ng-model="row.designationCode" id="designationCode{{trIndex}}" required readonly/>
											 <select  list ="designationList" ng-model="row.designationCode" ng-options="designation.designationCode as designation.designationCode for designation in designationList" id="designationCode{{trIndex}}" disabled>
				            		  			<option value="">select</option>
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
											<input type="text" class="form-control input-sm" name="companyCode"  ng-model="row.companyCode" id="companyCode{{trIndex}}" required readonly/>
											 <select  list ="companyList" ng-model="row.companyCode" ng-options="company.companyCode as company.companyCode for company in companyList" id="companyCode{{trIndex}}" disabled>
				            		  			<option value="">select</option>
				            				</select>
								     </div>
								</div>
								<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
									<label class="col-md-5 control-label bold">Qty(MT)GO</label>
									<div class="col-md-7">
								             <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO" readonly/>
								     </div>
								</div>
								<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
									<label class="col-md-5 control-label bold">Qty(MT)FO</label>
									<div class="col-md-7">
								             <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO" readonly/>
								     </div>
								</div>
								</div>
						    </td> 		             	
				       </tr>  -->
			      	</tbody>
			      </table>
				</div>    <!-- /table-responsive -->
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
				<!-- <div class="row">
					<div class="col-sm-12">
						<div class="form-group pull-right">
					        <label class="col-md-3 control-label">Total Tc Amt ({{creditnoteAcctData.currencyCode}})</label>
					        <div class="col-md-3">
					         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="creditnoteAcctData.totalTCAmount"
				         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
					        </div>
					        <label class="col-md-3 control-label">Total Bc Amt ({{creditnoteAcctData.companyCurrency}})</label>
					        <div class="col-md-3">
					         	<input type="text" class="form-control input-sm" name="totalBCAmount" data-ng-model="creditnoteAcctData.totalBCAmount"
				         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
					        </div>
				       </div>
					</div>
				</div> -->
				<!-- <div class="row">
					<div class="col-sm-12">
						<div class="col-sm-4" >
							<div class="form-group"  >
								<label class="col-md-5 control-label bold">Approve</label>
							 	<div class="col-sm-6">
							 	<div class="checkbox">
						          <label class="i-checks">
						           <input type="checkbox" class="checkbox style-0" id="approvedCheck"  ng-click="approvedCheck()" ng-model="checkboxModel.value1"  ng-true-value="'YES'" ng-false-value="'NO'" name="approved"  ng-click="approvedCheck()">
						           <i></i>
						          </label>
						         </div>
						     </div>
						 	</div>
					 	</div>
					 	<div class="col-sm-4">
						 	<div class="form-group">
						 		<label class="col-md-5 control-label">Reject</label>
						          <div class="col-sm-6">
							          <div class="checkbox">
							          <label class="i-checks">
							           <input type="checkbox" class="checkbox style-0" id="rejectCheck" name="rejected"  ng-click="rejectedCheck()" ng-model="checkboxModel.value2"   ng-true-value="'YES'" ng-false-value="'NO'" ng-click="rejectedCheck()">
							           <i></i>
							          </label>
							         </div>
						         </div>
						 	</div>
					 	</div>
				 	</div>
				</div> -->
					
				 <div class="row">
					<div class="col-sm-12">
					<div class="col-sm-6">
						<!-- <div class="form-group" id="drawSign">
						 <label class="col-md-2 control-label"  style="margin-top:6%;" data-ng-if="!isreject">Signature</label>
						  <label class="col-md-2 control-label"  style="margin-top:6%;" data-ng-if="isreject">Remarks</label>
						 	<div class="col-md-7">
								<div  class="sigPad">
									<ul class="sigNav">
								     	<li class="drawIt"><a href="#draw-it" class="current" style="display:none" >Approved</a></li>
								     	 <li class="clearButton"><a href="#clear" style="display:none">Clear</a></li>
								   	</ul>
							    <div class="sig">
								     <canvas class="pad" id="signCanvas" width="350"  height="55" style="border: 2px solid #333;"></canvas>
								     <a href="" ng-click="clear()" data-ng-if="pending" style="text-decoration: underline;">
				        	  	Clear
				          		</a>
								      <input type="hidden" name="output" class="output" id="output">
							    </div>
							    </div>
							   </div>
					  		</div> -->
					</div>
					</div>
				</div>
	
				<!-- <div class="row">
					<div class="col-sm-12">
					 <div class="col-sm-6" id="approvalDiv">
					 <label class="col-md-2 control-label"   data-ng-if="isApproval">Signature</label>
					<label class="col-md-2 control-label"   data-ng-if="!isApproval && !pending">Remarks</label>
					<div class="col-md-7">
					 <div class="form-group" id="signedSig">
						<div class="sigPad" ng-if="!pending" >
				    	<div class="sigWrapper">
				      	<div class="signed"></div>
				      	  <canvas class="pad"  width="350"  height="55" style="border: 2px solid #333;" ></canvas>
						</div>
				   		</div>
				  	</div>
						
					 </div>
					 </div>
					</div>
				</div> -->	 <!-- /row -->
	
				<div class="row">
			     <div class="col-sm-12 col-md-12 col-lg-12">
			      <div class="content">
			      	<div class="form-actions">
			        <div class="row">
			         <div class="col-md-12">
			     	<button class="btn btn-danger" ng-if="creditTable!=true" ng-click="cancel()" type="button">
			       	 Cancel
			          </button>
			       	<button class="btn btn-success" ng-click="save()" data-ng-if="pending" type="button">
			        	  Submit
			          </button>
			          	<button class="btn btn-success" ng-click="savePartial()" data-ng-if="pendingPartial" type="button">
			        	  Submit
			          </button>
			          <button class="btn btn-success" ng-if="creditTable!=true" ng-click="printDiv(creditnoteAcctData.creditNoteCode)"  type="button">
			        	  Print
			          </button>
             <button class="btn btn-danger" ng-if="creditTable==true" ng-click="cancel1()" type="button">
            Cancel
             </button>
			   		 </div>
			        </div>
			       </div>
			      </div>
			     </div>
	    		</div> <!-- /row -->
	   		</form>
	    </div> <!-- /panel-body -->
	</div> <!-- /panel-default-form -->
</div> <!-- /wrapper-md -->