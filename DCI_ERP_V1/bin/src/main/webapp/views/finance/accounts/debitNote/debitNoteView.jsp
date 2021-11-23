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
	       	<form class="form-horizontal" name="debitNoteForm" novalidate method="post">
			    <div class="row">
			      <div class="col-sm-12">
				     <div class="col-lg-4 col-sm-4 col-md-4">
				     	<div class="form-group">
					        <label class="col-md-5 control-label">Debit Note Date</label>
					        <div class="col-md-7">	
					        
					        <label class="col-md-5 control-label">{{debitNoteMasterData.debitNoteDate}}</label>				          	
<!-- 					          
<!-- 								</div>
 -->					        </div>
				     	</div>
				     	<div class="form-group ">
					        <label class="col-md-5 control-label">Vendor/Customer Name</label>
					        <div class="col-md-7">
					         <selectivity list="accountHeadList" property="debitNoteMasterData.acctHeadName" 
						      ng-model="debitNoteMasterData.acctHeadName"
						      id="txtacctHeadName"   disabled='true'  ></selectivity>
					           </div>
				       	</div>
				       	
				      	<div class="form-group">
					        <label class="col-md-5 control-label">Invoice/Payment Receipt Number</label>
					        <div class="col-md-7 ">
					         <label class="col-md-5 control-label">{{debitNoteMasterData.invoiceNo}}</label>					         					         	
					        </div>
				       	</div>
			
				    </div>
				    <div class="col-lg-4 col-sm-4 col-md-4">
				  		<div class="form-group">
					        <label class="col-md-5 control-label">Invoice Date</label>
					        <div class="col-md-7">
					         <label class="col-md-5 control-label">{{debitNoteMasterData.invoiceDate}}</label>					        
					        </div>
				     	</div>
				     	<!-- <div class="form-group ">
					        <label class="col-md-5 control-label">Currency</label>
					        <div class="col-md-7">
					         <label class="col-md-5 control-label">{{debitNoteMasterData.currencyCode}}</label>				         
					        
					        </div>
				       	</div>
				       	<div class="form-group">
					        <label class="col-md-5 control-label">Exchange Rate</label>
					        <div class="col-md-7">
					         <label class="col-md-5 control-label">{{debitNoteMasterData.exchangeRate}}</label>
					         	
					        </div> -->
				       </div>			
				    </div>
				    <div class="col-lg-4 col-sm-4 col-md-4">
				    	<div class="form-group">					     			        
					        <div class="col-md-7">					         	
					        </div>
				       </div>
				       <div class="form-group">
					        <label class="col-md-5 control-label">Narration</label>
					        <div class="col-md-7">
					         <label class="col-md-5 control-label">{{debitNoteMasterData.narration}}</label>					         
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
				            
				            <th colspan=1 class="sorting width_13 text-center">Account Head</th>
				           	<th colspan=1 class="sorting width_13 text-center">Sub Account</th>
				            <!-- <th colspan=1 class="width_10 text-center">Description</th> -->
<!-- 				            <th colspan=1 class="sorting width_10 text-center">Narration</th>
 -->				            <th colspan=1 class="sorting width_10 text-center"> Amount</th>
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
				              		validation="required" friendly-name="{{ 'Row ' + $index + ' (Payment Name on Detail table)'}}" 
			           				form-name="debitNoteForm" disabled='true' ></selectivity>
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
			           									form-name="debitNoteForm"  disabled='true'></selectivity>							              		
					        			</div>
					        		</div>
					        	</td>
								<td>
									<div class="row">
					            		<div class="col-xs-12">
					            		<selectivity list="dtlSubAcctList" property="row.subAcctCode" 
					            			ng-model="row.subAcctCode" id="subAcctCode{{$index}}" object="subaccountobj"
					            			name="{{ 'subAcctCode' + $index }}"  disabled='true'></selectivity>						            			
					            		</div>
					        		</div>
				           		</td>						       
					          	<!-- <td class="width_10">
					          		<div class="row" >
					            		<div class="col-xs-12">
					         	  			<input type="text" class="form-control input-sm" name="narration" data-ng-model="row.dtlNarration" required ng-disabled="true"/>
					         	  		</div>
					              	</div>
					            </td> -->
					            <td>
					            	<div class="row" >
					            		<div class="col-xs-12">
					         	  			<input type="text" class="form-control input-sm text-right" name="amount" data-ng-model="row.amount|number:2"
					         	  			 ng-pattern="/^(\d)+$/" ng-keyup="amountCalculation(row.amount,trIndex,row)" 
					         	  			name="{{ ' Amount' + $index }}" friendly-name="{{ 'Row ' + $index + ' (BC Amt on Detail table)'}}"  
					         	  			numbers-only validation="required" ng-disabled="true" />
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
										    	<selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}" disabled='true'></selectivity>
										    </div>
										</div>
										<div class="col-sm-4" ng-if="row.isDepartment">
											<label class="col-md-3 control-label"> Students</label>
											<div class="col-md-9">
										    	<selectivity list="studentList" 
										    	disabled = "true"
										    	property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
										    </div>
										</div>
										<div class="col-sm-4" ng-if="row.isLocation">
											<label class="col-md-3 control-label"> Location
												
											</label>
											<div class="col-md-9">
										             <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}" disabled='true'></selectivity>
										     </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCustomer">
											<label class="col-md-3 control-label"> Customer
												
											</label>
											<div class="col-md-9">
										             <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}" disabled='true'></selectivity>
										     </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isSupplier">
											<label class="col-md-3 control-label"> Supplier
												
											</label>
											<div class="col-md-9">
										    	<selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}" disabled='true'></selectivity>
										    </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isDesignation">
											<label class="col-md-3 control-label"> Designation</label>
											<div class="col-md-9">
										             <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}" disabled='true'></selectivity>
										     </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCostCenter">
											<label class="col-md-3 control-label"> CostCtr</label>
											<div class="col-md-9">
											<selectivity class="selectivity-results-container1" list="costCenterList" property="row.costCenter" ng-model="row.costCenter" id="costCenter{{trIndex}}" disabled='true'></selectivity>
										           <!--   <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/> -->
										     </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isCompany">
											<label class="col-md-3 control-label"> Company Name</label>
											<div class="col-md-9">
										    	<selectivity list="companyList" property="row.companyCode" id="companyCode{{trIndex}}"></selectivity>
										    </div>
										</div>
										<div class="col-sm-4" style="padding-top: 10px;" ng-if="row.isPatient">
											<label class="col-md-3 control-label">Patient</label>
											<div class="col-md-9">
												<selectivity list="patientList" property="row.patientCode" id="patientId{{trIndex}}" disabled='true'></selectivity>											        
										     </div>
										</div>									
									</div>
							    </		             	
					       </tr> 
				      	</tbody>
				      </table>				    
					</div>    <!-- /table-responsive -->
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group pull-right">
							<br><br>
						        <label class="col-md-5 control-label">Total Amount</label>
						        <div class="col-md-5">
						         	<input type="text" class="form-control input-sm text-right" name="totalBCAmount" data-ng-model="debitnoteDtlTotalAmt.totalBCAmount|number:2"
					         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
						        </div>
						        <!-- <label class="col-md-5 control-label">Total TC Amt</label>
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