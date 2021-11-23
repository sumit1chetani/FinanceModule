<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
				      <form class="form-horizontal" name="creditNoteForm" novalidate method="post">
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
						     	<!-- <div class="form-group">
							        <label class="col-md-5 control-label">Credit Note Date<span style="color:red;"> *</span></label>
							        <div class="col-md-7">
							          	<div class='input-group date datetimepick'>
											<div class="dropdown">
												<a class="dropdown-toggle" id="txtCreditNoteDate" role="button"
													data-toggle="dropdown" data-target="#" href="#">
													<div class="input-group">
														<input type="text" class="form-control" name="Credit Note Date"
														data-ng-model="creditnoteAcctData.creditNoteDate" placeholder="dd/mm/yyyy"
														 validation="date_euro_long|required" friendly-name="Credit Note Date" />
															<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
														
													</div>
												</a>
												<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
													<datetimepicker data-ng-model="creditnoteAcctData.creditNoteDate" data-on-set-time="creditnoteAcctData.creditNoteDate = onDateSet(newDate)"
														data-datetimepicker-config="{ dropdownSelector: '#txtCreditNoteDate',startView:'day', minView:'day'}" />
												</ul>
											</div>
										</div>			          	
							        </div>
						     	</div> -->
						     	
						     		<div class="form-group ">
								<label class="col-md-5 control-label">Credit Note Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker
										ng-disabled="createQuote" data-ng-model="creditnoteAcctData.creditNoteDate"
										id="txtCreditNoteDate" name="Credit Note Date"
										data-ng-change="checkDatesCL(creditnoteAcctData.creditNoteDate)"
										friendly-name="Credit Note Date" validation="required" />
								</div>
								</div>
						     	<div class="form-group ">
							        <label class="col-md-5 control-label">Vendor/Customer Name<span style="color:red;">*</span></label>
							        <div class="col-md-7">								       					
								        <selectivity list="acctHeadList" property="creditnoteAcctData.accountName"  ng-model="creditnoteAcctData.accountName" 
								        id="cmbAccountName" name="Account Head" object="accounts" validation="required" 
								        friendly-name="Account Head" form-name = "creditNoteForm"></selectivity>								        
							        </div>
						       	</div>
						      <!-- 	<div class="form-group">
							        <label class="col-md-5 control-label">Invoice Number<span style="color:red;"> *</span></label>
							        <div class="col-md-7 ">							         				
							        <ui-select ng-model="creditnoteAcctData.invoiceNo" ng-disabled="disabled"  appendToBody="true">
         	 						<ui-select-match placeholder="Select an Invoice...">{{$select.selected.text}}</ui-select-match>
								    <ui-select-choices repeat="mlo.id as mlo in invoiceNoList | propsFilter: {text: $select.search,entityName: $select.search, invoiceDate: $select.search} " >
									      <div class="col-md-12 col-sm-12 col-lg-12 pt-lr-0">
									      <div class="col-md-2 pull-left pt-lr-1" ng-bind-html="mlo.entityName | highlight: $select.search"></div>
									      <div class="col-md-8 pull-left pt-lr-1" ng-bind-html="mlo.text | highlight: $select.search"></div>
									      <div class="col-md-2 pull-left pt-lr-1" ng-bind-html="mlo.invoiceDate | highlight: $select.search"></div>
								      </div>
									</ui-select-choices>
									    <div></div>
								  </ui-select>	
									  <selectivity list="invoiceNoList" property="creditnoteAcctData.invoiceNo"  
									  		ng-model="creditnoteAcctData.invoiceNo" 
									        id="invoiceNo" name="Invoice No" validation="required" 
									        friendly-name="Invoice Number" form-name = "creditNoteForm">
									 </selectivity>
							        </div>
						       	</div> -->
						    </div>
						    <div class="col-sm-4">
						    	<div class="form-group">
							        <label class="col-md-5 control-label">Invoice Date</label>
							        <div class="col-md-7">
							          <input type="text" class="form-control input-sm" id="invoiceDate" name="invoiceDate"
							          data-ng-model="creditnoteAcctData.invoiceDate" required ng-disabled="true" />
							        </div>
						     	</div>
						     	<!-- <div class="form-group ">
							        <label class="col-md-5 control-label">Currency</label>
							        <div class="col-md-7">
							        	<input type="text" class="form-control input-sm" id="currencyCode" name="currencyCode"
							        	data-ng-model="creditnoteAcctData.currencyCode"  required />
							        </div>
						       	</div> -->
						       	<!-- <div class="form-group">
							        <label class="col-md-5 control-label">Exchange Rate</label>
							        <div class="col-md-7">
							         	<input type="text" class="form-control input-sm" id="exgRate" name="exgRate"
							         	data-ng-model="creditnoteAcctData.exchangeRate" required />
							        </div>
						       </div> -->
						       	<div class="form-group">
							        <label class="col-md-5 control-label">Invoice/Payment Receipt Number<span style="color:red;"> *</span></label>
							        <div class="col-md-7 ">							         				
							        <!-- <ui-select ng-model="creditnoteAcctData.invoiceNo" ng-disabled="disabled"  appendToBody="true">
         	 						<ui-select-match placeholder="Select an Invoice...">{{$select.selected.text}}</ui-select-match>
								    <ui-select-choices repeat="mlo.id as mlo in invoiceNoList | propsFilter: {text: $select.search,entityName: $select.search, invoiceDate: $select.search} " >
									      <div class="col-md-12 col-sm-12 col-lg-12 pt-lr-0">
									      <div class="col-md-2 pull-left pt-lr-1" ng-bind-html="mlo.entityName | highlight: $select.search"></div>
									      <div class="col-md-8 pull-left pt-lr-1" ng-bind-html="mlo.text | highlight: $select.search"></div>
									      <div class="col-md-2 pull-left pt-lr-1" ng-bind-html="mlo.invoiceDate | highlight: $select.search"></div>
								      </div>
									</ui-select-choices>
									    <div></div>
								  </ui-select> -->	
									  <selectivity list="invoiceNoList" property="creditnoteAcctData.invoiceNo"  
									  		ng-model="creditnoteAcctData.invoiceNo" 
									        id="invoiceNo" name="Invoice No" validation="required" 
									        friendly-name="Invoice Number" form-name = "creditNoteForm">
									 </selectivity>
							        </div>
						       	</div>
					
						    </div>
						    <div class="col-sm-4">
						    	<div class="form-group">
							        <!-- <label class="col-md-5 control-label">Company</label> -->
							        <div class="col-md-7">
<!-- 							         	<input type="hidden" class="form-control input-sm" data-ng-model="creditnoteAcctData.companyCode" value="" />
<!--  					             		<label class="form-control input-sm" ng-bind="creditnoteAcctData.company"></label>
 -->							        </div>
						       </div>
						       <div class="form-group">
							        <label class="col-md-5 control-label">Narration</label>
							        <div class="col-md-7">
							         	<input type="text" class="form-control input-sm" id="narration" name="narration" data-ng-model="creditnoteAcctData.narration" required maxlength="100" />
							        </div>
						       </div>
						    </div>
					    </div>
					    
					    <br>
					    <br>
					    <br>
						<div class="col-md-12">
							<div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">						     
								<table class="table table-striped table-bordered table-hover dataTable  b-t b-light" >
							    	<thead class="dataTables-Main-Head">
							          <tr>
							            <th colspan=1 class="sorting width_1"></th>
							           <th colspan="1" class="sorting width_13 text-center"> Nature of Payment </th>
							            <th colspan=1 class="sorting width_13 text-center">Account Head<span style="color:red;"> *</span></th>
							            <th colspan=1 class="sorting width_13 text-center">Ledger Code</th>
<!-- 							            <th colspan=1 class="sorting width_10 text-center">Narration</th>
 -->							            <th colspan=1 class="sorting width_10 text-center"> Amount<span style="color:red;"> *</span></th>
<!-- 							            <th colspan=1 class="sorting width_10 text-center">TC Amt</th>
 -->							            <th colspan=1 class="sorting width_1"></th>
							          </tr>
							        </thead>
							        <tbody data-ng-repeat="(trIndex, row) in creditnoteAcctData.credittables" data-ng-controller="tableCtrl">
							        	<tr>
								            <td><label class="i-checks m-b-none"> <input type="checkbox" data-ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								          
								           <td>
								            	<div class="row">
								            		<div class="col-xs-12">							            		
									              		<selectivity list="paymentList" ng-model="row.cbpdtlpaymentreceipt" 
				              		property="row.cbpdtlpaymentreceipt"  id="account{{trIndex}}" name="{{ 'cbpdtlpaymentreceipt' + $index }}"  
				              		validation="required" friendly-name="{{ 'Row ' + $index + ' (Payment Name on Detail table)'}}" 
			           				form-name="creditNoteForm" ></selectivity>
								        			</div>
								        		</div>
								        	</td>
								          
								            <td>
								            	<div class="row">
								            		<div class="col-xs-12">							            		
									              		<selectivity  list="crdtlAcctHeadList" id="accountHeadCode{{trIndex}}" 
									              		name="{{ 'crdtlAccountHead' + $index }}" 
									              		ng-model="row.crdtlAccountHead" property="row.crdtlAccountHead"  object="accHead"									              		 
			           									friendly-name="{{ 'Row' + $index + '(Account Head on Detail table)'}}" 
			           									 form-name="creditNoteForm">
			           									</selectivity>
								        			</div>
								        		</div>
								        	</td>
								        	<td>
												<div class="row">
								            		<div class="col-xs-12">					            		
								            			<selectivity list="dtlSubAcctList" ng-model="row.subAcctCode"  property="row.subAcctCode" 
								            			id="txtSubAcctCode{{$index}}" object="subacctobj"
								            			name="{{ 'subAcctCode' + $index }}">
								            			</selectivity>
								            		</div>
								        		</div>
							           		</td>
								          	<!-- <td class="width_10">
								          		<div class="row" >
								            		<div class="col-xs-12">
								         	  			<input type="text" class="form-control input-sm" name="narration" data-ng-model="row.narration" required />
								              		</div>
								              	</div>
								            </td> -->
								            <td>
								            	<div class="row" >
								            		<div class="col-xs-12 ">
								         	  			<input type="text"  class="form-control input-sm" name="bcamount" 
								         	  			data-ng-model="row.bcamount" ng-pattern-restrict="^[0-9.]*$"  								         	  			
								         	  			ng-keyup="amountBCtoTCcalculation(row.bcamount,trIndex,row)" 
								         	  			friendly-name="{{ 'Row ' + $index + ' (BC Amt on Detail table)'}}"  validation="required" />
								              		</div>
								              	</div>
								            </td>
								            <!-- <td>
									           	<div class="row">
									           		<div class="col-xs-12">
									        	  	<input type="text" class="form-control input-sm" name="tcamount" data-ng-model="row.tcamount" 
									        	  	ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" 
									        	  	ng-keyup="amountTCtoBCcalculation(row.tcamount,trIndex,row)" ng-disabled="true" required />
									             	</div>
									            </div>
								            </td> -->
								            
							     		</tr>
							     		<tr>
								        	<td colspan="12">
									        	<div class="col-sm-12">							        	
													<div  class="col-sm-4" ng-if="row.isEmployee">
														<label class="col-md-3 control-label"> Employee</label>
														<div class="col-md-9">
													    	<selectivity class="selectivity-results-container1" list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
													    </div>
													</div>
													<div class="col-sm-4"  ng-if="row.isDepartment">
														<label class="col-md-3 control-label"> Students</label>
														<div class="col-md-9">
													    	<selectivity class="selectivity-results-container1" list="studentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
													    </div>
													</div>
													<div  class="col-sm-4" ng-if="row.isLocation">
														<label class="col-md-3 control-label"> Location
															
														</label>
														<div class="col-md-9">
													             <selectivity class="selectivity-results-container1" list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
													     </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCustomer">
														<label class="col-md-3 control-label"> Customer
															
														</label>
														<div class="col-md-9">
													             <selectivity class="selectivity-results-container1" list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
													     </div>
													</div>
													<div class="col-sm-4"  style="padding-top: 10px;" ng-if="row.isSupplier">
														<label class="col-md-3 control-label"> Supplier
														</label>
														<div class="col-md-9">
													    	<selectivity class="selectivity-results-container1" list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
													    </div>
													</div>
													<div  class="col-sm-4"  style="padding-top: 10px;" ng-if="row.isDesignation">
														<label class="col-md-3 control-label"> Designation</label>
														<div class="col-md-9">
													             <selectivity class="selectivity-results-container1" list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
													     </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCostCenter">
														<label class="col-md-3 control-label"> CostCtr</label>
														<div class="col-md-9">
														<selectivity class="selectivity-results-container1" list="costCenterList" property="row.costCenter" ng-model="row.costCenter" id="costCenter{{trIndex}}"></selectivity>
													            <!--  <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/> -->
													     </div>
													</div>
													<div  class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCompany">
														<label class="col-md-3 control-label"> Company Name</label>
														<div class="col-md-9">
													    	<selectivity class="selectivity-results-container1" list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"></selectivity>
													    </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;"  ng-if="row.isPatient">
														<label class="col-md-3 control-label">Patient</label>
														<div class="col-md-9">
															<selectivity class="selectivity-results-container1" list="patientList" property="row.patientCode" id="patientId{{trIndex}}"></selectivity>											        
													     </div>
													</div>									
												</div>
										    </td> 		             	
								       </tr> 
							      	</tbody>
							      </table>
							    
								<div class="padding-right-5" id="AddOrRmvebtn">
						           <button ng-click="addCredRow(creditnoteAcctData.credittables)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
						            <i class="fa fa-plus"></i>
						           </button>
						           <button ng-click="removeCredRow(creditnoteAcctData.credittables)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
						            <i class="fa  fa-trash-o"></i>
						           </button>
						      	</div> <!-- /padding-right-5 - /AddOrRmvebtn -->
							</div>    <!-- /table-responsive -->
						</div>
				<br><br>
						<div class="col-sm-12">
							<div class="form-group pull-right">
								<!-- <label class="col-md-3 control-label">Total TC Amt</label>
						        <div class="col-md-3">
						         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="creditnoteDtlTotalAmt.totalTCAmount"
					         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
						        </div> -->
						        <br><br>
						        <label class="col-md-5 control-label">Total  Amount</label>
						        <div class="col-md-5">
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
						          <button class="btn btn-success" type="button" ng-if="!edit" ng-click="validate(creditNoteForm,creditnoteAcctData)" >
						           <i class="fa fa-save"></i>
						           Save
						          </button>
						          <button class="btn btn-success" type="button" ng-if="edit" ng-click="validate(creditNoteForm,creditnoteAcctData)">
						           <i class="fa fa-save"></i>
						           Update
						          </button>
						          <button type="button" class="btn btn-info"
						            ng-click="reset(creditNoteForm,creditnoteAcctData)"  ng-disabled="!isEditChanged()">
						            <i class="fa fa-undo"></i>Reset
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