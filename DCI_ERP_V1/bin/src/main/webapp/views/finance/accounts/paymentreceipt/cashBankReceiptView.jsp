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
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
		
	<div class="panel panel-default panel-default-form" ng-class="{view : isView}">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel-body">
			<form class="form-horizontal" name="cashBankReceiptForm" role="form">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="col-sm-4 col-md-4 col-lg-4">
									<fieldset>
										<div class="form-group">
									        <label class="col-md-5 control-label">  Receipt Voucher No</label>
									        <div class="col-md-7">				       
										        <input type="text" class="form-control bg-color-none b-none" id="voucherNo1" 
										        name="Voucher No" ng-model="objCBReceipt.voucherNo1" ng-disabled="true" />				        
									        </div>
								       	</div>
										
									<%-- 	<div class="form-group">
									        <label class="col-md-5 control-label"><spring:message
			              			code="label.company.name"></spring:message><span style="color:red;"> *</span></label>
									        <div class="col-md-7">
										        <!-- <input type="hidden" class="form-control input-sm" data-ng-model="objCBReceipt.companyCode" value="" /> 
					             				<label class="form-control input-sm" ng-bind="objCBReceipt.compLocationName"></label> -->
					             				 <selectivity list="companyList" property="objCBReceipt.companyCode"  ng-model="objCBReceipt.companyCode" 
											        id="cmbCompanyName" name="		<spring:message
			              			code="label.company.name"></spring:message>" object="company" validation="required" 
											        friendly-name="<spring:message
			              			code="label.company.name"></spring:message>"   disabled="isDisabled"></selectivity>	
									        </div>
								       	</div> --%>
								       	
								       	<div class="form-group">
									        <label class="col-md-5 control-label">Company Name</label>
									        <div class="col-md-7">				       
										        <input type="text" class="form-control bg-color-none b-none" id="compLocationName" 
										        name="compLocationName" ng-model="objCBReceipt.compLocationName" ng-disabled="true" />				        
									        </div>
								       	</div>
										<div class="form-group">
					    					<label class="col-md-5 control-label">Type Of Receipt<span style="color:red;"> *</span></label>
										    <div class="col-md-7 inputGroupContainer">
										   		<selectivity list="typeList" property="objCBReceipt.paymentMode" ng-model="objCBReceipt.paymentMode" 
										   		validation="required" friendly-name="Type Of Payment" id="pmt_id" name="Payment Type" disabled="true"
										   		form-name="cashBankReceiptForm" readonly></selectivity>
										   	</div>
										</div>
					       				<div class="form-group"  ng-if="pmtTypeShow">
					   						<label class="col-md-5 control-label">Bank Acct<span style="color: red;"> *</span></label>
									       	<div class="col-md-7 inputGroupContainer">
												<selectivity list="bankList" id="bankAcc_id" name="Bank Acct" 
												property="objCBReceipt.bankAcc" ng-model="objCBReceipt.bankAcc" object="bankacctobj" disabled="true"
												validation="required" friendly-name="Bank Acct" form-name="cashBankReceiptForm" readonly></selectivity>
												
										   	</div>
									   	</div>
									   	<div class="form-group"  ng-if="!(pmtTypeShow)">
					   						<label class="col-md-5 control-label">Cash Acct<span style="color: red;"> *</span></label>
									       	<div class="col-md-7 inputGroupContainer">
												<selectivity  list="cashList" id="cashAcc_id" name="Cash Acct" 
												property="objCBReceipt.cashAcc" ng-model="objCBReceipt.cashAcc" object="cashacctobj" disabled="true"
												validation="required" friendly-name="Cash Acct"  form-name="cashBankReceiptForm" readonly></selectivity>
										   	</div>
									   	</div>
									</fieldset>
								</div>
						   		<div class="col-sm-4 col-md-4 col-lg-4">
									<fieldset>
					 					<!-- <div class="form-group">
											<label class="col-md-5 control-label"> Currency<span style="color: red;"> *</span></label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" name="Currency" ng-model="objCBReceipt.currency" readonly/>
											</div>
										</div> -->
										
										<div class="form-group">
			      							<label for="inputPassword" class="control-label col-md-5">Receipt Date</label>
			    							<div class="col-md-7">
			   									<!-- <div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="receipt_date" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Receipt Date" 
																	data-ng-model="objCBReceipt.cbReceiptDate" validation="date_euro_long|required" 
																	friendly-name="Receipt Date" readonly/>
																	<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
															</div>
														</a>
													</div>
												</div>	 -->
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Receipt Date" 
																	data-ng-model="objCBReceipt.cbReceiptDate" validation="date_euro_long|required" 
																	friendly-name="Receipt Date" readonly/>
			    							</div>
					       				</div>
										<!-- <div class="form-group">
											<label class="col-md-5 control-label"> Exchange Rate<span style="color: red;">*</span></label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" id="exgRate" required name="Exchange Rate" ng-model="objCBReceipt.exchangeRate"  readonly
												/>
											</div>
										</div> -->
										<!-- <div class="form-group">
											<label class="col-md-5 control-label"> Received From </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" name="Received From" ng-model="objCBReceipt.receivedFrom" readonly/>
												<selectivity list="receivedFromList" id="receivedFrom" name="Received From" 
									        	property="objCBReceipt.receivedFrom" ng-model="objCBReceipt.receivedFrom" 
									        	validation="required" friendly-name="Received From" form-name="cashBankReceiptForm"></selectivity>
											</div>
										</div> -->
										<div class="form-group">
											<label class="col-md-5 control-label"> Amount <span style="color: red;">*</span>
											</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" ng-model="objCBReceipt.bcAmountHdr|number:2"
													name="Amount USD"  readonly
													ng-pattern-restrict="^[0-9.]*$"  />
											</div>
										</div>
										
										  <div class="form-group">
									        <label class="col-md-5 control-label">Receipt From<span style="color:red;"> *</span></label>
									        <div class="col-md-7">
										        <!-- <input type="hidden" class="form-control input-sm" data-ng-model="objCBReceipt.companyCode" value="" /> 
					             				<label class="form-control input-sm" ng-bind="objCBReceipt.compLocationName"></label> -->
					             				 <!-- <selectivity list=receiptList property="objCBReceipt.receiptfrom"  ng-model="objCBReceipt.receiptfrom" 
											        id="receiptfrom" name="receiptfrom" object="receiptfrom" validation="required" 
											        friendly-name="receiptfrom" form-name = "cashBankReceiptForm"></selectivity>	 -->
											         <input type="text" class="form-control bg-color-none b-none" id="receiptfrom" 
										        name="ReceiptFrom" ng-model="objCBReceipt.receiptfrom" ng-disabled="true" />		
									        </div>
								       	</div>
								      
								       	<div class="form-group">
												<label class="col-md-5 control-label">Fund Type </label>
												<div class="col-md-7">
													<selectivity list="costList" id="costCenter"
														name="costCenter" form-name="cashBankReceiptForm"
														property="objCBReceipt.costCenter"
														ng-model="objCBReceipt.costCenter"
														friendly-name="Costcenter" disabled="true" ></selectivity>
												</div>
											</div>
								       	
								       	 	<div class="form-group">
			 							<label for="inputPassword" class="control-label col-md-5">Approval Note</label>
										<div class="col-md-7">
											<div class="input-group">
			 									<textarea rows="2" cols="30" class="form-control" name="Approval Note"  disabled="true"
			 									ng-model="objCBReceipt.approvenote" friendly-name="Approval Note">
			 									</textarea>
			   								</div>
										</div>
									</div>
								       	
								       	
					       			</fieldset>
								</div>
								<div class="col-sm-4 col-md-4 col-lg-4">
									<div class="form-group" ng-if="pmtTypeShow">
										<label class="col-md-5 control-label"> Cheque/DD/UTR Ref No</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm" name="Cheque No" ng-model="objCBReceipt.chequeNO" readonly/>
										</div>
									</div>
									<div class="form-group"  ng-if="pmtTypeShow">
			 							<label for="inputPassword" class="control-label col-md-5">Cheque/DD/UTR Date 
</label>
										<div class="col-md-7">
											<!-- <div class='input-group date datetimepick'>
													<div class="dropdown">
														<a class="dropdown-toggle" id="cheque_date" role="button"
															data-toggle="dropdown" data-target="#" href="#">
															<div class="input-group">
																<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Cheque Date" 
																	data-ng-model="objCBReceipt.chequeDate" readonly>
																	<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
																
															</div>
														</a>
													</div>
												</div>	 -->
												<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Cheque Date" 
																	data-ng-model="objCBReceipt.chequeDate" readonly>									
										</div>
									</div>
									
									
									
										
									
									<div class="form-group">
			 							<label for="inputPassword" class="control-label col-md-5">Narration</label>
										<div class="col-md-7">
											
			 									<textarea rows="2" cols="30" class="form-control" name="Narration" 
			 									ng-model="objCBReceipt.narration" friendly-name="Narration" readonly>
			 									</textarea>
			   								
										</div>
									</div>
								</div>
					 		</div>
						</div>
						<div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
						    <table class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
						      <thead>
						        <tr>
						          <th colspan=1 class="width_1"></th>
						          <!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
						       <th colspan=1 class="width_10 text-center">Nature of Receipt</th>
						          <th colspan=1 class="width_13 text-center">Account Head <span style="color:red;"> *</span></th>
<!-- 						          <th colspan=1 class="width_10 text-center" ng-if= "objCBReceipt.receiptfrom!='Others' ">Ledger Name</th>
 -->						          
						        						          <th colspan=1 class="width_10 text-center" >Ledger Name</th>
						        
						        
						        <!--   <th colspan=1 class="width_10 text-center">Invoice Details</th>
						          <th colspan=1 class="width_10 text-center">Invoice No</th>
						          <th colspan=1 class="width_8 text-center">Currency<span style="color:red;"> *</span></th>
						          <th colspan=1 class="width_13 text-center">Exchange Rate</th> -->
<!-- 						          <th colspan=1 class="width_8 text-center">BC Amt</th>
 -->						          <th colspan=1 class="width_8 text-center">Amount</th>
						          <th colspan=1 class="width_1 visible-left">Pending List</th>
						        </tr>
						      </thead>
						      <tbody ng-repeat="(trIndex, row) in objCBReceipt.cshBankDetail" ng-controller="tableCtrl">
							      <tr>
								  	<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select"><i></i></label></td>
									
							      <td class="padding-both-side-2">
							           <div class="row">
								            <div class="col-xs-9">
									           <!--  <select class="form-control input-sm" id="acctName{{trIndex}}" ng-model="row.acctName" name="acctName"
									            data-ng-options="r.accountHeadCode as r.accountHeadName  for r in accountList"
									             ng-change="fetchCurrExgRateForDetailList(row,row.acctName,trIndex,accountList)">
									               <option value="">--Select--</option>
									            </select> -->
									            <selectivity  list="receiptList" ng-model="row.receipt"  disabled="true"
							              		property="row.receipt"  id="receipt{{trIndex}}" name="{{ 'receipt' + $index }}"  
							              		 friendly-name="{{ 'Row ' + $index + ' (Receipt Name on Detail table)'}}" 
						           				form-name="cashBankReceiptForm"></selectivity>
								       		 </div>
							        	</div>
							      	</td>
							      	<td class="padding-both-side-2">
							           <div class="row">
								            <div class="col-xs-12">
									            <selectivity class="selectivity-results-container2 " list="accountList" ng-model="row.acctName" 
							              		property="row.acctName"  id="acctName{{trIndex}}" name="{{ 'acctName' + $index }}"  disabled="true"
							              		validation="required" friendly-name="{{ 'Row ' + $index + ' (Account Name on Detail table)'}}" 
						           				form-name="cashBankReceiptForm" ></selectivity>
								       		 </div>
							        	</div>
							      	</td>
							      	
							      		<td  class="padding-both-side-2">
							           <div class="row">
								            <div class="col-xs-12">								            	
									             <selectivity list="subAccountCodeList" ng-model="row.subAccountCode"  disabled="true"
							              		property="row.subAccountCode"  id="txtSubAccountCode{{trIndex}}" name="{{ 'subAccountCode' + $index }}"></selectivity>
								       		 </div>
							        	</div>
							      	</td>
							    <!--     <td  class="padding-both-side-2">
								       	<div class="row">
								            <div class="col-xs-12">
								            	<label class="btn text-center margin-auto" data-ng-click="showReceiptPriceDialogView(row,row.subAccountCode,trIndex)">
							           			<i class="fa fa-expand"></i></label>
								        	</div>
								       	</div>
							        </td>
							        <td class="padding-both-side-2">
							        	<div class="row">
						            		<div class="col-xs-12">
						            			<input type="text" class="form-control input-sm" 
					 								name="Invoice No" ng-model="row.genInvoiceNo" ng-disabled="true" />
						            		</div>
						            	</div>
						            </td>
							       	<td>
								       	<div class="row">
									        <div class="col-xs-12" ng-if="!row.isInvoiceNo">
									           <input type="text" class="form-control input-sm" id="currency{{trIndex}}" ng-model="row.currency"  name="currency">
									      	</div>
									      	<div class="col-xs-12" ng-if="row.isInvoiceNo">
									           <input type="text" class="form-control input-sm" id="currency{{trIndex}}" ng-model="row.currency"  name="currency" ng-disabled="true" />
									      	</div>
								      	</div>
							      	</td>
							        <td>
								        <div class="row">
									        <div class="col-xs-12" ng-if="!row.isInvoiceNo">
									           <input type="text" class="form-control input-sm" id="exgRate{{trIndex}}" ng-model="row.exgRate" name="exgRate" 
									           data-ng-change="onChangeNumber('exgRate'+trIndex,row.exgRate)" />
									     	</div>
									        <div class="col-xs-12" ng-if="row.isInvoiceNo">
									           <input type="text" class="form-control input-sm" id="exgRate{{trIndex}}" ng-model="row.exgRate" name="exgRate" 
									           data-ng-change="onChangeNumber('exgRate'+trIndex,row.exgRate)" ng-disabled="true" />
									     	</div>
								      	</div>
							      	</td>
							       	<td>
									    <div class="row">
									    	<div class="col-xs-12" ng-if="!row.isInvoiceNo">
									           <input type="text" class="form-control input-sm"  id="amount{{trIndex}}" ng-model="row.bcamount" name="bcamount"
									            ng-keyup="BCtoTCAmountCalculationForPartyAccountDetTbl(row.bcamount,trIndex,row)" />
									      	</div>
									    	<div class="col-xs-12" ng-if="row.isInvoiceNo">
									           <input type="text" class="form-control input-sm"  id="amount{{trIndex}}" ng-model="row.bcamount" name="bcamount"
									            ng-keyup="BCtoTCAmountCalculationForPartyAccountDetTbl(row.bcamount,trIndex,row)" ng-disabled="true" />
									      	</div>
									    </div>
							      	</td>
							       	<td>
								       <div class="row">
								           	<div class="col-xs-12" ng-if="!row.isInvoiceNo">
									           	<input type="text" class="form-control input-sm" id="amountUsd{{trIndex}}" ng-model="row.tcamount"  name="tcamount"
									            	ng-keyup="TCtoBCAmountCalculationForPartyAccountDetTbl(row.tcamount,trIndex,row)" ng-disabled="true" />
								      		</div>
								           	<div class="col-xs-12" ng-if="row.isInvoiceNo">
									           	<input type="text" class="form-control input-sm" id="amountUsd{{trIndex}}" ng-model="row.tcamount"  name="tcamount"
									            	ng-keyup="TCtoBCAmountCalculationForPartyAccountDetTbl(row.tcamount,trIndex,row)" ng-disabled="true" />
								      		</div>
								       </div>
							      	</td>
							      	 <td class="visible-left">
						            	<input type="hidden" ng-model="row.invoiceReceiptList" />
						            </td> -->
						            
						            	<td>
								       <div class="row">
								           	<div class="col-xs-12" ng-if="!row.isInvoiceNo">
									           	<input type="text" class="form-control input-sm text-right" id="amountUsd{{trIndex}}" ng-model="row.tcamount|number:2"  name="tcamount"
									            	ng-keyup="TCtoBCAmountCalculationForPartyAccountDetTbl(row.tcamount,trIndex,row)" ng-disabled="true" />
								      		</div>
								           	<div class="col-xs-12" ng-if="row.isInvoiceNo">
									           	<input type="text" class="form-control input-sm" id="amountUsd{{trIndex}}" ng-model="row.tcamount"  name="tcamount"
									            	ng-keyup="TCtoBCAmountCalculationForPartyAccountDetTbl(row.tcamount,trIndex,row)" ng-disabled="true" />
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
											           <selectivity class="selectivity-results-container1" 
											           list="employeeList" property="row.employeeCode" disabled="true" ng-model="row.employeeCode" id="employeeCode{{trIndex}}" ></selectivity>
											     </div>
											</div>								
											
											<div class="col-sm-4" ng-if="row.isDepartment">
												<label class="col-md-3 control-label"> Students</label>
												<div class="col-md-9">
											           <selectivity class="selectivity-results-container1" disabled="true" list="studentList" property="row.departmentCode" id="departmentCode{{trIndex}}" ></selectivity>
											     </div>
											</div>
											<div class="col-sm-4" ng-if="row.isLocation">
												<label class="col-md-3 control-label"> Location</label>
												<div class="col-md-9">
											    	<selectivity class="selectivity-results-container1" disabled="true" list="countryList" property="row.countryCode" id="countryCode{{trIndex}}" disabled="true"></selectivity>
											    </div>
											</div>
											<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCustomer">
												<label class="col-md-3 control-label"> Customer</label>
												<div class="col-md-9">
											    	<selectivity class="selectivity-results-container1" disabled="true" list="customerList" property="row.customerCode" id="customerCode{{trIndex}}" disabled="true"></selectivity>
											    </div>
											</div>
											<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isSupplier">
												<label class="col-md-3 control-label"> Supplier</label>
												<div class="col-md-9">
											    	<selectivity class="selectivity-results-container1" disabled="true" list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}" disabled="true"></selectivity>
											    </div>
											</div>
											<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isDesignation">
												<label class="col-md-3 control-label"> Designation</label>
												<div class="col-md-9">
											             <selectivity class="selectivity-results-container1" disabled="true" list="designationList" property="row.designationCode" id="designationCode{{trIndex}}" disabled="true"></selectivity>
											     </div>
											</div>
											<div class="col-sm-4" style="padding-top: 10px;" disabled="true" ng-if="row.isCostCenter">
												<label class="col-md-3 control-label"> CostCtr</label>
												<div class="col-md-9">
												
												 	<selectivity class="selectivity-results-container1" disabled="true" list="costCenterList" property="row.costCenter" ng-model="row.costCenter" id="costCenter{{trIndex}}" ></selectivity>
											             <!-- <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/> -->
											     </div>
											</div>
											<div class="col-sm-4" style="padding-top: 10px;" disabled="true" ng-if="row.isCompany">
												<label class="col-md-3 control-label"><sapn style = "color:red">*</sapn></label>
												<div class="col-md-9">
											    	<selectivity class="selectivity-results-container1" disabled="true" list="companyList" property="row.companyCode" id="companyCode{{trIndex}}" disabled="true"></selectivity>
											    </div>
											</div>
											<div class="col-sm-4" style="padding-top: 10px;" disabled="true" ng-if="row.isPatient">
												<label class="col-md-3 control-label">Patient</label>
												<div class="col-md-9">
													<selectivity class="selectivity-results-container1" disabled="true" list="patientList" property="row.patientCode" id="patientId{{trIndex}}" disabled="true"></selectivity>											        
											     </div>
											</div>									
										</div>
								    </td> 		             	
						       </tr> 
							     
						     </tbody>
						   </table>
						   <!-- <div class="padding-right-5 padding-bottom-5">
						         <button ng-click="addCBRcptDtlRow(objCBReceipt.cshBankDetail)" class="btn btn-sm btn-info" tooltip="Add Row" type="button">
						          <i class="fa fa-plus"></i>
						         </button>
						         <button ng-click="removeCBRcptRow(objCBReceipt.cshBankDetail)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
						          <i class="fa  fa-trash-o"></i>
						         </button>
						   </div> --> <!-- /addRow and /removeRow -->
						   <div class="row">
								<div class="col-sm-12 col-md-12 col-lg-12">
							      	<div class="form-group pull-right">
										<!-- <label class="col-md-3 control-label"> Total BC Amt</label>
										<div class="col-md-3">
											<input type="text" class="form-control input-sm" ng-model="cbRcptDtlTotalAmt.totalBCAmount" readonly
											name="BC Total">
										</div> -->
										<label class = "col-md-3 control-label"> Total Amount</label>
										<div class="col-md-4">
											<input type="text" class="form-control input-sm" ng-model="cbRcptDtlTotalAmt.totalTCAmount" readonly
											name="TC Total"> 										</div>
									</div>
								</div>
							</div>
							
						</div> <!-- table-responsive -->
						
			  			
		     				<div class="content">
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-danger" 
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i> Cancel
											</button>
										</div>
									</div>
								</div> <!-- /form-actions -->
							</div>
									    
						</form>
				</div> <!-- /widget-body -->								
			</div> <!-- /content -->			
		</div>  <!-- /standard-datatable-widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>