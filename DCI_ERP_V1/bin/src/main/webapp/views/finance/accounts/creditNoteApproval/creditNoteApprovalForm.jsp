<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="purchaseInvoiceForm">
				<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
						     <div class="col-sm-4">
						     	<div class="form-group" data-ng-if="edit">
							        <label class="col-md-5 control-label">Credit Note No</label>
							        <div class="col-md-7">
							          <input type="text" class="form-control input-sm" id="txtCreditNoteCode" name="Credit Note No"
							          data-ng-model="creditnoteAcctData.creditNoteCode"  data-ng-disabled="true" />
							        </div>
						     	</div>
						     	<div class="form-group">
							        <label class="col-md-5 control-label">Credit Note Date<span style="color:red;"> *</span></label>
							        <div class="col-md-7">
							        		<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Credit Note Date"
											 validation="date_euro_long|required" friendly-name="Credit Note Date" 
											data-ng-model="creditnoteAcctData.creditNoteDate" data-ng-disabled="true" />
									</div>
						     	</div>
						     	<div class="form-group ">
							        <label class="col-md-5 control-label">Vendor / Customer Name<span style="color:red;"> *</span></label>
							        <div class="col-md-7">
							        	<select class="form-control" ng-model="creditnoteAcctData.accountName" id="cmbAccountName" name="Account Head" 
							        	ng-options="ac.id as ac.text for ac in acctHeadList" ng-disabled="true"></select>
							        	<!-- <input type="text" class="form-control" ng-model="creditnoteAcctData.acctName" id="cmbAccountName" name="Account Head" ng-disabled="true"  />
							        	<input type="hidden" class="form-control" ng-model="creditnoteAcctData.accountName" id="cmbAccountName" name="Account Head" ng-disabled="true"  /> -->
								        <!-- <selectivity list="acctHeadList" property="creditnoteAcctData.accountName"  ng-model="creditnoteAcctData.accountName" 
								        id="cmbAccountName" name="Account Head" object="accounts" validation="required" 
								        friendly-name="Account Head" form-name = "creditNoteForm"></selectivity> -->								        
							        </div>
						       	</div>
						      	<div class="form-group">
							        <label class="col-md-5 control-label">Invoice Number<span style="color:red;"> *</span></label>
							        <div class="col-md-7 ">
							        	<!-- <select class="form-control" ng-model="creditnoteAcctData.invoiceNo" id="txtInvoiceNo" name="Invoice Number" 
							        	ng-options="inv.id as inv.text for inv in invoiceNoList" object="invoices"></select> -->
							        	<input type="text" class="form-control" ng-model="creditnoteAcctData.invoiceNo" id="invoiceNo" name="Invoice Number" ng-disabled="true" />							        	 								         				
							         	<!-- <selectivity list="invoiceNoList"  ng-model="creditnoteAcctData.invoiceNo" 
							         	property="creditnoteAcctData.invoiceNo" id="invoiceNo" name="Invoice Number" object="invoices"
							         	 validation="required" friendly-name="Invoice Number" form-name = "creditNoteForm"></selectivity> -->	
							        </div>
						       	</div>
						    </div>
						    <div class="col-sm-4">
						    	<div class="form-group">
							        <label class="col-md-5 control-label">Invoice Date</label>
							        <div class="col-md-7">
							          <input type="text" class="form-control input-sm" id="invoiceDate" name="invoiceDate"
							          data-ng-model="creditnoteAcctData.invoiceDate" data-ng-disabled="true" />
							        </div>
						     	</div>
						     	<div class="form-group ">
							        <label class="col-md-5 control-label">Currency</label>
							        <div class="col-md-7">
							        	<input type="text" class="form-control input-sm" id="currencyCode" name="currencyCode"
							        	data-ng-model="creditnoteAcctData.currencyCode" ng-disabled="true"  />
							        </div>
						       	</div>
						       	<div class="form-group">
							        <label class="col-md-5 control-label">Exchange Rate</label>
							        <div class="col-md-7">
							         	<input type="text" class="form-control input-sm" id="exgRate" name="exgRate"
							         	data-ng-model="creditnoteAcctData.exchangeRate" ng-disabled="true"  />
							        </div>
						       </div>
					
						    </div>
						    <div class="col-sm-4">
						    	<div class="form-group">
							        <label class="col-md-5 control-label">Hospital</label>
							        <div class="col-md-7">
							         	<input type="hidden" class="form-control input-sm" data-ng-model="creditnoteAcctData.companyCode" value="" />
					             		<label class="form-control input-sm" ng-bind="creditnoteAcctData.company" ng-disabled="true"></label>
							        </div>
						       </div>
						       <div class="form-group">
							        <label class="col-md-5 control-label">Narration</label>
							        <div class="col-md-7">
							         	<input type="text" class="form-control input-sm" id="narration" name="narration" 
							         	data-ng-model="creditnoteAcctData.narration" ng-disabled="true"  />
							        </div>
						       </div>
						        <div class="form-group">
							        <label class="col-md-5 control-label">Status</label>
							        <div class="col-md-7">
							         	<select class="form-control" data-ng-model="creditnoteAcctData.approveStatus" id="txtStatus"name="Status">
							         		<option value="Pending">Pending</option>
							         		<option value="Approved">Approved</option>
							         		<option value="Rejected">Rejected</option>
							         	</select>
							        </div>
						       </div>
						    </div>
					    </div>
						<div class="col-md-12">
						     <div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
						     
							      <table class="table table-striped table-bordered table-hover dataTable  b-t b-light" >
							        <thead class="dataTables-Main-Head">
							          <tr>
							            <th colspan=1 class="sorting width_1"></th>
							            <th colspan=1 class="sorting width_13 text-center">Account Head</th>
							            <th colspan=1 class="sorting width_10 text-center">Sub Account</th>
							            <th colspan=1 class="sorting width_10 text-center">Narration</th>
							            <th colspan=1 class="sorting width_10 text-center">BC Amt</th>
							            <th colspan=1 class="sorting width_10 text-center">TC Amt</th>
							            <th colspan=1 class="sorting width_1"></th>
							          </tr>
							        </thead>
							        <tbody data-ng-repeat="(trIndex, row) in creditnoteAcctData.credittables" data-ng-controller="tableCtrl">
							        	<tr>
								            <td><label class="i-checks m-b-none"> <input type="checkbox" data-ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								            <td>
								            	<div class="row">
								            		<div class="col-xs-12">							            		
									              		<!-- <selectivity list="crdtlAcctHeadList" ng-model="row.crdtlAccountHead" property="row.crdtlAccountHead" 
									              		id="accountHeadCode{{trIndex}}" object="accHead"
									              		name="{{ 'crdtlAccountHead' + $index }}" >
			           									</selectivity> -->
			           									
			           									<select class="form-control" ng-model="row.crdtlAccountHead" id="accountHeadCode{{trIndex}}" name="{{ 'crdtlAccountHead' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in crdtlAcctHeadList" ng-disabled="true">
								        				</select> 
								        			</div>
								        		</div>
								        	</td>
								        	<td>
												<div class="row">
								            		<div class="col-xs-12">					            		
								            			<!-- <selectivity list="dtlSubAcctList" ng-model="row.subAcctCode"  property="row.subAcctCode" 
								            			id="txtSubAcctCode{{$index}}" object="subacctobj"
								            			name="{{ 'subAcctCode' + $index }}">
								            			</selectivity> -->
								            			<select class="form-control" ng-model="row.subAcctCode" id="txtSubAcctCode{{$index}}" name="{{ 'subAcctCode' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in dtlSubAcctList" ng-disabled="true">
								        				</select> 
								            		</div>
								        		</div>
							           		</td>
								          	<td class="width_10">
								          		<div class="row" >
								            		<div class="col-xs-12">
								         	  			<input type="text" class="form-control input-sm" name="narration" data-ng-model="row.narration" 
														ng-disabled="true" />
								              		</div>
								              	</div>
								            </td>
								            <td>
								            	<div class="row" >
								            		<div class="col-xs-12">
								         	  			<input type="text" class="form-control input-sm" name="bcamount" 
								         	  			data-ng-model="row.bcamount" ng-disabled="true"/>
								              		</div>
								              	</div>
								            </td>
								            <td>
									           	<div class="row">
									           		<div class="col-xs-12">
									        	  	<input type="text" class="form-control input-sm" name="tcamount" data-ng-model="row.tcamount" 
									        	  	ng-disabled="true" />
									             	</div>
									            </div>
								            </td>
								            
							     		</tr>
							     		<tr>
								        	<td colspan="12">
									        	<div class="col-sm-12">							        	
													<div class="col-sm-4" ng-if="row.isEmployee">
														<label class="col-md-3 control-label"> Employee</label>
														<div class="col-md-9">
													    	<!-- <selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity> -->
													    	<select class="form-control" ng-model="row.employeeCode" id="employeeCode{{trIndex}}" name="{{ 'employeeCode' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in employeeList" ng-disabled="true">
								        					</select> 
													    </div>
													</div>
													<div class="col-sm-4" ng-if="row.isDepartment">
														<label class="col-md-3 control-label"> Department</label>
														<div class="col-md-9">
													    	<!-- <selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity> -->
													    	<select class="form-control" ng-model="row.departmentCode" id="departmentCode{{trIndex}}" name="{{ 'departmentCode' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in departmentList" ng-disabled="true">
								        					</select> 
													    </div>
													</div>
													<div class="col-sm-4" ng-if="row.isLocation">
														<label class="col-md-3 control-label"> Location
															
														</label>
														<div class="col-md-9">
													       <!-- <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity> -->
													       <select class="form-control" ng-model="row.countryCode" id="countryCode{{trIndex}}" name="{{ 'countryCode' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in countryList" ng-disabled="true">
								        					</select> 
													     </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCustomer">
														<label class="col-md-3 control-label"> Customer
															
														</label>
														<div class="col-md-9">
													        <!-- <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity> -->
													        <select class="form-control" ng-model="row.customerCode" id="customerCode{{trIndex}}" name="{{ 'customerCode' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in customerList" ng-disabled="true">
								        					</select>
													     </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isSupplier">
														<label class="col-md-3 control-label"> Supplier
															
														</label>
														<div class="col-md-9">
													    	<!-- <selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity> -->
													    	<select class="form-control" ng-model="row.supplierCode" id="supplierCode{{trIndex}}" name="{{ 'supplierCode' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in supplierList" ng-disabled="true">
								        					</select>
													    </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isDesignation">
														<label class="col-md-3 control-label"> Designation</label>
														<div class="col-md-9">
													    	<!-- <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity> -->
													    	<select class="form-control" ng-model="row.designationCode" id="designationCode{{trIndex}}" name="{{ 'designationCode' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in designationList" ng-disabled="true">
								        					</select>
													    </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCostCenter">
														<label class="col-md-3 control-label"> CostCtr</label>
														<div class="col-md-9">
															
														 <select class="form-control" ng-model="row.costCenter" id="costCenter{{trIndex}}" name="{{ 'costCenter' + $index }}" 
								        					ng-options="ac.costCenter as ac.text for ac in costCenterList" ng-disabled="true">
								        					</select>
													    	<!-- <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter" ng-disabled="true" />  -->
													    </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCompany">
														<label class="col-md-3 control-label"> <spring:message
			              			code="label.company.name"></spring:message></label>
														<div class="col-md-9">
													    	<!-- <selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"></selectivity> -->
													    	<select class="form-control" ng-model="row.companyCode" id="companyCode{{trIndex}}" name="{{ 'companyCode' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in companyList" ng-disabled="true">
								        					</select>
													    </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;"ng-if="row.isPatient">
														<label class="col-md-3 control-label">Patient</label>
														<div class="col-md-9">
															<!-- <selectivity list="patientList" property="row.patientCode" id="patientId{{trIndex}}"></selectivity> -->
															<select class="form-control" ng-model="row.patientCode" id="patientId{{trIndex}}" name="{{ 'patientCode' + $index }}" 
								        					ng-options="ac.id as ac.text for ac in patientList" ng-disabled="true">
								        					</select>											        
													     </div>
													</div>									
												</div>
										    </td> 		             	
								       </tr> 
							      	</tbody>
							      </table>
							</div>    <!-- /table-responsive -->
						</div>
				
						<div class="col-sm-12">
							<div class="form-group pull-right">
								<label class="col-md-3 control-label">Total TC Amt</label>
						        <div class="col-md-3">
						         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="creditnoteDtlTotalAmt.totalTCAmount"
					         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
						        </div>
						        <label class="col-md-3 control-label">Total BC Amt</label>
						        <div class="col-md-3">
						         	<input type="text" class="form-control input-sm" name="totalBCAmount" data-ng-model="creditnoteDtlTotalAmt.totalBCAmount"
					         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
						        </div>	        
					       </div>
						</div>
				
				        </div> <!-- /row -->
				        <div class="form-actions">
				         <div class="row">
				          <div class="col-md-12">
						           <div class="content">
						      	<div class="form-actions">
						        <div class="row">
						         <div class="col-md-12">
						          <button class="btn btn-success" type="button" ng-if="edit" ng-click="updateapproval(creditnoteAcctData)" >
						           <i class="fa fa-save"></i> Approve
						          </button>
						          
						          <button class="btn btn-danger" ng-click="cancel()" type="button">
						           <i class="fa fa-close"></i>
						           Cancel
						          </button>
						         </div>
						        </div>
						       </div>
						      </div>
				          </div>
				         </div>
				        </div>
				      </form>
				      </div> <!-- /widget-body -->
				      <!-- end widget content -->
					</div> <!-- role="content" -->
	     		</div> <!-- /standard-datatable-widget -->
			</article>
  		</div> <!-- /padding-top-10 -->
 	</section>
</div>
