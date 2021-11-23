<style>
table.dataTable thead .sorting:after {
  content: "";
}
.main_container{
	overflow:auto;
}

#cmbAccountName > div.selectivity-dropdown > div{
 width: 207px !important;
 overflow: auto !important;
}
#invoiceNo > div.selectivity-dropdown > div{
 width: 207px !important;
 overflow: auto !important;
}
.selectivity-results-container{
 	 width: 223px !important;
    overflow: auto ;

}
.selectivity-results-container2 > div.selectivity-dropdown > div{
 	width: 220px !important;
    overflow: auto !important ;
}
.selectivity-results-container1 > div.selectivity-dropdown > div{
    width: 220px !important;
    overflow: auto ;

}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
				      <form class="form-horizontal" name="creditNoteForm" novalidate method="post">
				      	<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
						     <div class="col-sm-4">
						     	<div class="form-group" data-ng-if="edit">
							        <label class="col-md-5 control-label">Credit Note No</label>
							        <div class="col-md-7">
							        <label class="col-md-5 control-label">{{creditnoteAcctData.creditNoteCode}}</label>
							        </div>
						     	</div>
						     	<div class="form-group">
							        <label class="col-md-5 control-label">Credit Note Date</label>
							        <div class="col-md-7">							        
							          <label class="col-md-5 control-label">{{creditnoteAcctData.creditNoteDate}}</label>
							        			          	
							        </div>
						     	</div>
						     	<div class="form-group ">
							        <label class="col-md-5 control-label">Vendor/Customer Name</label>
							        <div class="col-md-7">	
							          <selectivity list="acctHeadList" property="creditnoteAcctData.accountName"  ng-model="creditnoteAcctData.accountName" 
								        id="cmbAccountName" name="Account Head" object="accounts" validation="required" 
								        friendly-name="Account Head" form-name = "creditNoteForm" disabled='true'></selectivity>  							        
							        </div>
						       	</div>
						      	<div class="form-group">
							        <label class="col-md-5 control-label">Invoice/Payment Receipt Number</label>
							        <div class="col-md-7 ">	
							        <label class="col-md-9 control-label">{{creditnoteAcctData.invoiceNo}}</label> 
							         </div>
						       	</div>
						    </div>
						    <div class="col-sm-4">
						    	<div class="form-group">
							        <label class="col-md-5 control-label">Invoice Date</label>
							        <div class="col-md-7">
							         <label class="col-md-5 control-label">{{creditnoteAcctData.invoiceDate}}</label>							        
							        </div>
						     	</div>
						     	<!-- <div class="form-group ">
							        <label class="col-md-5 control-label">Currency</label>
							        <div class="col-md-7">
							        <label class="col-md-5 control-label">{{creditnoteAcctData.currencyCode}}</label>
							        </div>
						       	</div> -->
						       	<!-- <div class="form-group">
							        <label class="col-md-5 control-label">Exchange Rate</label>
							        <div class="col-md-7">
							        <label class="col-md-5 control-label">{{creditnoteAcctData.exchangeRate}}</label>							        
							        </div>
						       </div> -->
					
						    </div>
						    <div class="col-sm-4">
						    	<div class="form-group">							      
							        <div class="col-md-7">
							       </div>
						       </div>
						       <div class="form-group">
							        <label class="col-md-5 control-label">Narration</label>
							        <div class="col-md-7">
							        <label class="col-md-5 control-label">{{creditnoteAcctData.narration}}</label>
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
							           <th colspan=1 class="sorting width_13 text-center">Nature of Payement</th>
							            
							            <th colspan=1 class="sorting width_13 text-center">Account Head</th>
							            <th colspan=1 class="sorting width_13 text-center">Sub Account</th>
<!-- 							            <th colspan=1 class="sorting width_10 text-center">Narration</th>
 -->							            <th colspan=1 class="sorting width_10 text-center"> Amount</th>
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
			           				form-name="creditNoteForm" disabled='true' ></selectivity>
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
			           									validation="required" form-name="creditNoteForm" disabled='true'>
			           									</selectivity>								            		
								        			</div>
								        		</div>
								        	</td>
								        	<td>
												<div class="row">
								            		<div class="col-xs-12">	
								            		<selectivity class="selectivity-results-container2" list="dtlSubAcctList" ng-model="row.subAcctCode"  property="row.subAcctCode" disabled='true'
								            			id="txtSubAcctCode{{$index}}" object="subacctobj"
								            			name="{{ 'subAcctCode' + $index }}">
								            			</selectivity>
								            		 </div>
								        		</div>
							           		</td>
								          	<!-- <td class="width_10">
								          		<div class="row" >
								            		<div class="col-xs-12">
								         	  			<input type="text" class="form-control input-sm" name="narration"  ng-disabled="true" data-ng-model="row.narration" required />
								              		</div>
								              	</div>
								            </td> -->
								            <td>
								            	<div class="row" >
								            		<div class="col-xs-12">
								         	  			<input type="text" class="form-control input-sm text-right" name="bcamount" 
								         	  			data-ng-model="row.bcamount|number:2" ng-pattern-restrict="^[0-9.]*$"  								         	  			
								         	  			ng-keyup="amountBCtoTCcalculation(row.bcamount,trIndex,row)" 
								         	  			friendly-name="{{ 'Row ' + $index + ' (BC Amt on Detail table)'}}" ng-disabled="true" validation="required" />
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
													    	<selectivity class="selectivity-results-container1" list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}" disabled='true'></selectivity>
													    </div>
													</div>
													<div class="col-sm-4"  ng-if="row.isDepartment">
														<label class="col-md-3 control-label"> Students</label>
														<div class="col-md-9">
													    	<selectivity class="selectivity-results-container1" 
													    	disabled = "true"
													    	list="studentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
													    </div>
													</div>
													<div  class="col-sm-4" ng-if="row.isLocation">
														<label class="col-md-3 control-label"> Location
															
														</label>
														<div class="col-md-9">
													             <selectivity class="selectivity-results-container1" list="countryList" property="row.countryCode" id="countryCode{{trIndex}}" disabled='true'></selectivity>
													     </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCustomer">
														<label class="col-md-3 control-label"> Customer
															
														</label>
														<div class="col-md-9">
													             <selectivity class="selectivity-results-container1" list="customerList" property="row.customerCode" id="customerCode{{trIndex}}" disabled='true'></selectivity>
													     </div>
													</div>
													<div class="col-sm-4"  style="padding-top: 10px;" ng-if="row.isSupplier">
														<label class="col-md-3 control-label"> Supplier
														</label>
														<div class="col-md-9">
													    	<selectivity class="selectivity-results-container1" list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}" disabled='true'></selectivity>
													    </div>
													</div>
													<div  class="col-sm-4"  style="padding-top: 10px;" ng-if="row.isDesignation">
														<label class="col-md-3 control-label"> Designation</label>
														<div class="col-md-9">
													             <selectivity class="selectivity-results-container1" list="designationList" property="row.designationCode" id="designationCode{{trIndex}}" disabled='true'></selectivity>
													     </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCostCenter">
														<label class="col-md-3 control-label"> CostCtr</label>
														<div class="col-md-9">
														<selectivity class="selectivity-results-container1" list="costCenterList" property="row.costCenter" ng-model="row.costCenter" id="costCenter{{trIndex}}" disabled='true'></selectivity>
													            <!--  <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/> -->
													     </div>
													</div>
													<div  class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCompany">
														<label class="col-md-3 control-label"> Company Name</label>
														<div class="col-md-9">
													    	<selectivity class="selectivity-results-container1" list="companyList" property="row.companyCode" id="companyCode{{trIndex}}" disabled='true'></selectivity>
													    </div>
													</div>
													<div class="col-sm-4" style="padding-top: 10px;"  ng-if="row.isPatient">
														<label class="col-md-3 control-label">Patient</label>
														<div class="col-md-9">
															<selectivity class="selectivity-results-container1" list="patientList" property="row.patientCode" id="patientId{{trIndex}}" disabled='true'></selectivity>											        
													     </div>
													</div>									
												</div>
										    </td>		             	
								       </tr> 
							      	</tbody>
							      </table>
							</div>   
						</div>
				
						<div class="col-sm-12">
							<div class="form-group pull-right">
							<br><br>
								<!-- <label class="col-md-3 control-label">Total TC Amt</label>
						        <div class="col-md-3">
						         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="creditnoteDtlTotalAmt.totalTCAmount"
					         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
						        </div> -->
						        <label class="col-md-5 control-label">Total  Amount</label>
						        <div class="col-md-5">
						         	<input type="text" class="form-control input-sm text-right" name="totalBCAmount" data-ng-model="creditnoteDtlTotalAmt.totalBCAmount|number:2"
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