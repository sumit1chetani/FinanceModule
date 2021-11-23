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
				    
	       	<form class="form-horizontal" name="debitNoteForm" novalidate method="post">
			    <div class="row">
			      <div class="col-sm-12">
				     <div class="col-lg-4 col-sm-4 col-md-4">
				     	<div class="form-group">
					        <label class="col-md-5 control-label">Debit Note Date<span style="color:red;"> *</span></label>
					        <div class="col-md-7">					          	
<!-- 					            <div class='input-group date datetimepick'>
 -->									<div class="dropdown">
										<a class="dropdown-toggle" id="debitNoteDate" role="button"
											data-toggle="dropdown" data-target="#" href="#">
											<div class="input-group">
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Debit Note Date" 
													data-ng-model="debitNoteMasterData.debitNoteDate"  id="txtDebitNoteDate"
													 validation="required" friendly-name="Debit Note Date"/>
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
												
											</div>
										</a>										    
										<ul class="dropdown-menu" role="menu"
											aria-labelledby="dLabel">
											<datetimepicker data-ng-model="debitNoteMasterData.debitNoteDate" data-on-set-time="debitNoteMasterData.debitNoteDate = onDateSet(newDate)"
												data-datetimepicker-config="{ dropdownSelector: '#debitNoteDate',startView:'day', minView:'day'}" />
										</ul>
									</div>
<!-- 								</div>
 -->					        </div>
				     	</div>
				     	<div class="form-group ">
					        <label class="col-md-5 control-label">Vendor/Customer Name<span style="color:red;"> *</span></label>
					        <div class="col-md-7">
						      <selectivity list="accountHeadList" property="debitNoteMasterData.acctHeadName" 
						      ng-model="debitNoteMasterData.acctHeadName"
						      id="txtacctHeadName" name="Account Head" object="account" validation="required" 
								        friendly-name="Account Head" form-name = "debitNoteForm"></selectivity>
					        </div>
				       	</div>
				       	
				 <!--      	<div class="form-group">
					        <label class="col-md-5 control-label">Invoice Number<span style="color:red;"> *</span></label>
					        <div class="col-md-7 ">
					         		<selectivity list="invoiceNoList" ng-model="debitNoteMasterData.invoiceNo" property="debitNoteMasterData.invoiceNo" 
					         		id="txtinvoiceNo" name="Invoice No" object="invoices" validation="required" 
								        friendly-name="Invoice Number" form-name = "debitNoteForm"></selectivity>				         	
					        </div>
				       	</div> -->
			
				    </div>
				    <div class="col-lg-4 col-sm-4 col-md-4">
				  		<div class="form-group">
					        <label class="col-md-5 control-label">Invoice Date</label>
					        <div class="col-md-7">
					          <input type="text" class="form-control input-sm" id="invoiceDate" name="invoiceDate"
					          ng-model="debitNoteMasterData.invoiceDate" required ng-disabled="true" />
					        </div>
				     	</div>
				     	
				     	     	<div class="form-group">
					        <label class="col-md-5 control-label">Invoice /Payment Receipt Number<span style="color:red;"> *</span></label>
					        <div class="col-md-7 ">
					         		<selectivity list="invoiceNoList" ng-model="debitNoteMasterData.invoiceNo" property="debitNoteMasterData.invoiceNo" 
					         		id="txtinvoiceNo" name="Invoice No" object="invoices" validation="required" 
								        friendly-name="Invoice Number" form-name = "debitNoteForm"></selectivity>				         	
					        </div>
				       	</div>
				     	<!-- <div class="form-group ">
					        <label class="col-md-5 control-label">Currency</label>
					        <div class="col-md-7">
					        	<input type="text" class="form-control input-sm" id="currencyCode" name="currencyCode"
					        	ng-model="debitNoteMasterData.currencyCode"  required />
					        </div>
				       	</div> -->
				       	<!-- <div class="form-group">
					        <label class="col-md-5 control-label">Exchange Rate</label>
					        <div class="col-md-7">
					         	<input type="text" class="form-control input-sm" id="exchangeRate" name="exchangeRate"
					         	ng-model="debitNoteMasterData.exchangeRate" numbers-only required />
					        </div>
				       </div>	 -->		
				    </div>
				    <div class="col-lg-4 col-sm-4 col-md-4">
				    	<div class="form-group">
					        <!-- <label class="col-md-5 control-label">Company</label>	 -->				        
					        <div class="col-md-7">
					         	<!-- <input type="hidden" class="form-control input-sm" data-ng-model="debitNoteMasterData.companyCode" value="" />
					            <label class="form-control input-sm" ng-bind="debitNoteMasterData.company"></label> -->
					        </div>
				       </div>
				       <div class="form-group">
					        <label class="col-md-5 control-label">Narration</label>
					        <div class="col-md-7">
					         	<input type="text" class="form-control input-sm" id="narration" name="narration" data-ng-model="debitNoteMasterData.narration" required maxlength="50" />
					        </div>
				       </div>
				    </div>
			    </div>	
			    <div class="col-md-12">
		       		<div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
					 <table class="table table-striped table-bordered table-hover dataTable  b-t b-light">
				        <thead class="dataTables-Main-Head">
				          <tr>
				            <th colspan=1 class="sorting width_1"></th>
				           <th colspan=1 class="sorting width_13 text-center">Nature of Payment</th>
				            <th colspan=1 class="sorting width_13 text-center">Account Head<span style="color:red;"> *</span></th>
				           	<th colspan=1 class="sorting width_13 text-center">Ledger Code</th>
				            <!-- <th colspan=1 class="width_10 text-center">Description</th> -->
<!-- 				            <th colspan=1 class="sorting width_10 text-center">Narration</th>
 -->				            <th colspan=1 class="sorting width_10 text-center"> Amount<span style="color:red;"> *</span></th>
<!-- 				            <th colspan=1 class="sorting width_10 text-center">TC Amount</th>
 -->				            <th colspan=1 class="sorting width_1"></th>
				          </tr>
				        </thead>
				        <tbody ng-repeat="(trIndex, row) in debitNoteMasterData.debittables" ng-controller="tableCtrl">
				        	<tr>
					            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
					           
					           
					           <td>
								            	<div class="row">
								            		<div class="col-xs-12">							            		
									              		<selectivity list="paymentList" ng-model="row.cbpdtlpaymentreceipt" 
				              		property="row.cbpdtlpaymentreceipt"  id="account{{trIndex}}" name="{{ 'cbpdtlpaymentreceipt' + $index }}"  
				              		 friendly-name="{{ 'Row ' + $index + ' (Payment Name on Detail table)'}}" 
			           				form-name="debitNoteForm" ></selectivity>
								        			</div>
								        		</div>
								        	</td>
					           
					           
					           
					            <td>
					            	<div class="row">
					            		<div class="col-xs-12" id="accountHead">
						              		<selectivity list="drdtlAcctHeadList" property="row.drdtlAccountHead" class="testSelectivity"
						              		ng-model="row.drdtlAccountHead" id="accountHeadCode{{trIndex}}" object="accHead" 
						              		name="{{ 'drdtlAccountHead' + $index }}"  validation="required" 
			           									friendly-name="{{ 'Row ' + ($index+1) + ' (Account Head on Detail table)'}}" 
			           									form-name="debitNoteForm"></selectivity>
					        			</div>
					        		</div>
					        	</td>
								<td>
									<div class="row">
					            		<div class="col-xs-12">
					            			<selectivity list="dtlSubAcctList" property="row.subAcctCode" 
					            			ng-model="row.subAcctCode" id="subAcctCode{{$index}}" object="subaccountobj"
					            			name="{{ 'subAcctCode' + $index }}"></selectivity>
					            		</div>
					        		</div>
				           		</td>						       
					          	<!-- <td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12">
					         	  			<input type="text" class="form-control input-sm" name="narration" data-ng-model="row.dtlNarration" required />
					         	  		</div>
					              	</div>
					            </td> -->
					             <td>
					            	<div class="row" >
					            		<div class="col-xs-12">
					         	  			<input type="text" class="form-control input-sm" name="amount" data-ng-model="row.amount"
					         	  			 ng-pattern="/^(\d)+$/" ng-keyup="amountCalculation(row.amount,trIndex,row)" 
					         	  			name="{{ ' Amount' + $index }}" friendly-name="{{ 'Row ' + $index + ' (BC Amt on Detail table)'}}"  
					         	  			numbers-only validation="required"  />
					              		</div>
					              	</div>
					            </td> 
					            <!-- <td>
					           	 <div class="row" >
					            		<div class="col-xs-12">
					         	  			<input type="text" class="form-control input-sm" name="amountUSD" data-ng-model="row.amountUSD" ng-disabled="true" />
					         	  		</div>
					              	</div>
					            </td> -->
					           
				     		</tr>
				     		<tr>
					        	<td colspan="12">
						        	<div class="col-sm-12">							        	
										<div class="col-sm-4" ng-if="row.isEmployee">
											<label class="col-md-3 control-label"> Employee</label>
											<div class="col-md-9">
										    	<selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
										    </div>
										</div>
										<div class="col-sm-4" ng-if="row.isDepartment">
											<label class="col-md-3 control-label"> Students</label>
											<div class="col-md-9">
										    	<selectivity list="studentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
										    </div>
										</div>
										<div class="col-sm-4" ng-if="row.isLocation">
											<label class="col-md-3 control-label"> Location
												
											</label>
											<div class="col-md-9">
										             <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCustomer">
											<label class="col-md-3 control-label"> Customer
												
											</label>
											<div class="col-md-9">
										             <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isSupplier">
											<label class="col-md-3 control-label"> Supplier
												
											</label>
											<div class="col-md-9">
										    	<selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
										    </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isDesignation">
											<label class="col-md-3 control-label"> Designation</label>
											<div class="col-md-9">
										             <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCostCenter">
											<label class="col-md-3 control-label"> CostCtr</label>
											<div class="col-md-9">
											<selectivity class="selectivity-results-container1" list="costCenterList" property="row.costCenter" ng-model="row.costCenter" id="costCenter{{trIndex}}"></selectivity>
										           <!--   <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/> -->
										     </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCompany">
											<label class="col-md-3 control-label"> <spring:message
			              			code="label.company.name"></spring:message></label>
											<div class="col-md-9">
										    	<selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"></selectivity>
										    </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isPatient">
											<label class="col-md-3 control-label">Patient</label>
											<div class="col-md-9">
												<selectivity list="patientList" property="row.patientCode" id="patientId{{trIndex}}"></selectivity>											        
										     </div>
										</div>									
									</div>
							    </td> 		             	
					       </tr> 
				      	</tbody>
				      </table>
				      <div class="padding-right-5" id="AddOrRmvebtn">
				           <button ng-click="addCredRow(debitNoteMasterData.debittables)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
				            <i class="fa fa-plus"></i>
				           </button>
				           <button ng-click="removeCredRow(debitNoteMasterData.debittables)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
				            <i class="fa  fa-trash-o"></i>
				           </button>
				      </div> <!-- /padding-right-5 - /AddOrRmvebtn -->
					</div>    <!-- /table-responsive -->
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group pull-right">
							<br><br>
						        <label class="col-md-5 control-label">Total  Amt</label>
						        <div class="col-md-5">
						         	<input type="text" class="form-control input-sm" name="totalBCAmount" data-ng-model="debitnoteDtlTotalAmt.totalBCAmount"
					         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
						        </div>
						       <!--  <label class="col-md-3 control-label">Total TC Amt</label>
						        <div class="col-md-3">
						         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="debitnoteDtlTotalAmt.totalTCAmount"
					         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
						        </div> -->
					       </div>
						</div>
					</div>
		       	</div>
			</div> <!-- /row -->
		       	<div class="form-actions">
			        <div class="row">
				         <div class="col-md-12">
				          <button class="btn btn-success" type="button" class="btn btn-success" data-ng-click="validate(debitNoteForm,debitNoteMasterData)" data-ng-if="!edit">
				           	<i class="fa fa-save"></i>Save
				          </button>
				          <button class="btn btn-success" type="button" class="btn btn-success" id="update" data-ng-click="validate(debitNoteForm,debitNoteMasterData)" data-ng-if="edit">
				           <i class="fa fa-save"></i>Update
				          </button>
				          <button class="btn btn-info" type="button" class="btn btn-success" data-ng-click="reset(debitNoteForm);">
				           <i class="fa fa-undo"></i>Reset
				          </button>
				          <button class="btn btn-danger" type="button" class="btn btn-success" data-ng-click="cancel();">
				           <i class="fa fa-close"></i>Cancel
				          </button>
				         </div>
			        </div>
		       	</div>
	       	</form>
	      </div>
	      <!-- end widget content -->
	     </div>
     <!-- end widget div -->
    </div> <!--/standard-datatable-widget --> <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div> <!-- padding-top-10 -->
 </section>
</div>