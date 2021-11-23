<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="branchMasterForm">
								<div class="row">
			     <div class="col-sm-12 col-md-12 col-lg-6 ">
			     	<fieldset>
			     			     	
			     		<input type="hidden" class="form-control input-sm" name="ref_doctor_id"  
			     			ng-model="RefDoctorMasterData.ref_doctor_id" 
		         		 	valid-method="submit" message-id="ref_doctor_id" id="ref_doctor_id" >
		         		 	
					 	 	<div class="form-group">
								<label class="col-md-4 control-label">Employee No<spring:message code="label.asterisk.symbol"></spring:message></label>
					 			<div class="col-md-5">
		        					<label class="col-md-12 control-label">{{loantype.employeeId}}</label>
									
								</div>
						  </div>
						  
						   <div class="form-group">
								<label class="col-md-4 control-label">Employee Name<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-5">
						 		<label class="col-md-12 control-label">{{loantype.employeeName}}</label>
						 		</div>
						  	</div>
							  
						   <div class="form-group">
								<label class="col-md-4 control-label">Loan Type Name<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-5">
						 		<label class="col-md-12 control-label">{{loantype.loanTypeName}}</label>
		        				</div>
						  </div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Interest Type<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-5">
						 			<label class="col-md-12 control-label">{{loantype.flatOrDiminishing}}</label>
		        				</div>
						  	</div>
						  	
						  	<div class="form-group">
								<label class="col-md-4 control-label">Interest Rate<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-5">
						 		<label class="col-md-12 control-label">{{loantype.interestRate}}</label>
		        				
								</div>
						  	</div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Loan Amount<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-5">
						 		<label class="col-md-12 control-label">{{loantype.amount}}</label>
							
						</div>
						  </div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Total Installment<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-5">
						 			<label class="col-md-12 control-label">{{loantype.numberOfInstalments}}</label>
							</div>
						  </div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Monthly Deduction<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-5">
						 		<label class="col-md-12 control-label">{{loantype.deductionAmount}}</label>
							
							</div>
						  </div>
						<div class="form-group">
								<label class="col-md-4 control-label">Deduct From<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-5">
						 			<label class="col-md-12 control-label">{{loantype.deductFromDisplay}}</label>
						 	</div>
								
								
						  </div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Status<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-5">
						 			<select class="form-control" ng-model="loantype.status">
										   				 <option value="">--Select--</option>
										   				 <option value="1">Pending</option>
										   					<option value="2">Approved</option>
										   				   <option value="3">Reject</option>
										   				   <option value="4">Closed</option>
									</select>
						 		</div>
								
								</div>
			     	 </fieldset>
			     </div>
		     	
			     <div class="col-sm-12 col-md-12 col-lg-6">
			     
			     	<fieldset>
                    <div id="" ng-show="loantype.flatOrDiminishing=='Flat'">
                    <table style="width: 70%;" class="table table-striped b-dark">
			     <tbody class="b-l b-r b-b">
			     <tr><th class="b-r">Principal</th><td>{{loantype.amount}}</td>
			     </tr>
			     <tr><th class="b-r">Interest Rate</th><td>{{loantype.interestRate}}</td>
			     </tr>
			     <tr><th class="b-r">Num of Months</th><td>{{loantype.numberOfInstalments}}</td>
			     </tr>
			     <tr><th></th><td></td>
			     </tr>
			     <tr><th class="b-r">Total Interest</th><td>{{loantype.totalInterest}}</td>
			     </tr>
			     
			     <tr><th class="b-r">Payable</th><td>{{loantype.payable}}</td>
			     </tr>
			     
			     <tr><th  class="b-r">Monthly Payable</th><td>{{loantype.deductionAmount}}</td>
			     </tr>
			     </tbody>
			     </table>
                  
                    </div>
                    
                    <div ng-show="loantype.flatOrDiminishing=='Diminishing'" style="max-height:450px;overflow:auto;">
                    <table style="width: 98%;" class="table table-striped b-dark">
                    <thead>
                    <tr>
                    <th>MONTH</th>
                    <th>AMOUNT</th>
                    <th>EMI</th>
                    <th>INTEREST</th>
                    <th>PRINCIPAL</th>
                    <th>O/S</th>
                    </tr>
                    </thead>
			     <tbody class="b-l b-r b-b">
			     <tr ng-repeat ="emiList in diminishingEMIList">
			     <td>{{emiList.month}}</td>
			     <td>{{emiList.amount}}</td>
			     <td>{{emiList.emi}}</td>
			     <td>{{emiList.interest}}</td>
			     <td>{{emiList.principal}}</td>
			     <td>{{emiList.outStanding}}</td>
			     </tr>
			     </tbody>
			     </table>
                 
                    </div>
			     	</fieldset>
			     </div>
			  </div>
			  
			  <!-- Form field end -->	
			  
			  
			  <!-- Button Action Div Start-->											
		  
				<div class="form-actions">
			      <div class="row">
				       <div class="col-md-12">
				      		 <button class="btn btn-success"  type="button" data-ng-click="update()">
									        <i class="fa fa-save"></i>
									       Submit
									       </button>
											
											<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
								            	<i class="fa fa-close"></i>
								           		Cancel
								           </button>
		             	</div>
			      </div>
			     </div>
			     
			 <!-- Button Action Div End-->
		</form><!-- Form end -->
      </div>
    </div>
     <!-- end widget div -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
  
  
  
  
  
  
  
  
  
  
  
  
  