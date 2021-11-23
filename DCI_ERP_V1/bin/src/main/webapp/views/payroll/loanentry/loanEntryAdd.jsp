<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="loanEntryForm">
				<div class="row">
			     <div class="col-sm-12 col-md-12 col-lg-6 ">
			     	<fieldset>
			     			     	
			     		<input type="hidden" class="form-control input-sm" name="ref_doctor_id"  
			     			ng-model="RefDoctorMasterData.ref_doctor_id" 
		         		 	valid-method="submit" message-id="ref_doctor_id" id="ref_doctor_id" >
		         		 	
					 	 	<div class="form-group">
								<label class="col-md-4 control-label">Employee No<spring:message code="label.asterisk.symbol"></spring:message></label>
					 			<div class="col-md-6">
		        					<!-- <select  class="form-control journalVoucher-textBox" ng-model="loantype.employeeId" ng-options="master.employeeId as master.employeeId for master in employeeList"
												data-ng-if="!loantype.isEdit"   ng-change="getEmployeeName(loantype.employeeId)"   name="Employee No" data-validator="required" data-message-id="employeeId" data-valid-method="submit" >
											        <option value=""> --Select--</option>
									</select> -->
									<input type="text" class="form-control"
					               name="employeeId" data-ng-if="!loantype.isEdit"
					               ng-model="loantype.employeeId" ng-change="getEmployeeName(loantype.employeeId)" validation="required" friendly-name="Employee No">
									<input type="text" class="form-control input-sm" data-ng-if="loantype.isEdit"   ng-model="loantype.employeeId" name="Employee No" data-validator="required" data-message-id="amount" data-valid-method="submit" readonly>
								</div>
						  </div>
						  
						   <div class="form-group">
								<label class="col-md-4 control-label">Employee Name</label>
						 		<div class="col-md-6">
		        				 <input type="text" class="form-control"
					               name="employeeName"
					               ng-model="loantype.employeeName" readonly>
								</div>
						  	</div>
							  
						   <div class="form-group">
								<label class="col-md-4 control-label">Loan Type<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-6">
						 		<selectivity list="loanTypeList" property="loantype.loanTypeId"  
										                id="loanTypeId" ng-model="loantype.loanTypeId" form-name="loanEntryForm"
										               name="loanTypeId" validation="required" friendly-name="Loan Type">
										         </selectivity>
		        					<!-- <select  class="form-control journalVoucher-textBox" ng-model="loantype.loanTypeId" ng-options="payroll.loanTypeId as payroll.loanTypeName for payroll in loanTypeList"
												  name="Loan Type" data-validator="required" data-message-id="loanTypeId" data-valid-method="submit" ng-change="getLoanTypeEntries(loantype.loanTypeId)">
											        <option value=""> --Select--</option>
											    </select> -->
								</div>
						  </div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Interest Type</label>
						 		<div class="col-md-6">
		        				 <input type="text" class="form-control"
					               name="employeeName"
					               ng-model="loantype.flatOrDiminishing" readonly>
								</div>
						  	</div>
						  	
						  	<div class="form-group">
								<label class="col-md-4 control-label">Interest Rate</label>
						 		<div class="col-md-6">
		        				 <input type="text" class="form-control"
					               name="employeeName"
					               ng-model="loantype.interestRate" readonly>
								</div>
						  	</div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Loan Amount<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-6">
							<input type="text" class="form-control input-sm" ng-model="loantype.amount"  name="Loan Amount"  ng-change="getEMICalculation()" validation="required" friendly-name="Amount" phonenumbers-only>
						</div>
						  </div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Total Installment<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-6">
							<input type="text" class="form-control input-sm" ng-model="loantype.numberOfInstalments" name="Total Installment" validation="required" friendly-name="Total Installment" ng-change="getEMICalculation()" data-valid-method="submit" phonenumbers-only>
							</div>
						  </div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Monthly Deduction<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-6">
							<input type="number" class="form-control input-sm" ng-model="loantype.deductionAmount" name="Monthly Deduction" validation="required" friendly-name="Monthly Deduction" readonly>
							</div>
						  </div>
						<div class="form-group">
								<label class="col-md-4 control-label">Deduct From<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-3">
						 		<selectivity list="monthList" property="loantype.month"  
										                id="month" ng-model="loantype.month" form-name="loanEntryForm" validation="required" friendly-name="Deduct Month" name="month" >
										         </selectivity>
		        					<!-- <select  class="form-control journalVoucher-textBox" ng-model="loantype.month"
												  name="Deduct From" data-validator="required" data-message-id="deductFrom" data-valid-method="submit" >
											         <option value=""> --Month--</option>
											         <option value="01">01</option>
											         <option value="02">02</option>
											         <option value="03">03</option>
											         <option value="04">04</option>
											         <option value="05">05</option>
											         <option value="06">06</option>
											         <option value="07">07</option>
											         <option value="08">08</option>
											         <option value="09">09</option>
											         <option value="10">10</option>
											         <option value="11">11</option>
											         <option value="12">12</option>
									</select> -->
								</div>
								
								<div class="col-md-3">
								<selectivity list="yearList" property="loantype.year"  
										                id="year" ng-model="loantype.year" form-name="loanEntryForm" validation="required" friendly-name="Deduct Year" name="year" >
										         </selectivity>
		        					<!-- <select  class="form-control journalVoucher-textBox" ng-model="loantype.year"
												  name="Deduct From" data-validator="required" data-message-id="deductFrom" data-valid-method="submit" >
											         <option value=""> --Year--</option>
											         <option value="2015">2015</option>
											         <option value="2016">2016</option>
											         <option value="2017">2017</option>
											         <option value="2018">2018</option>
									</select> -->
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
                    <!-- <p><strong>Principal:</strong>{{loantype.amount}}</p>
                    <p><strong>Interest Rate:</strong>{{loantype.interestRate}}</p>
                    <p><strong>Num of Months:</strong>{{loantype.numberOfIntstalments}}</p>
                    <br>
                    <br>
                    <p><strong>Total Interest:</strong>{{loantype.totalInterest}}</p>
                    <p><strong>Payable:</strong>{{loantype.payable}}</p>
                    <p><strong>Monthly Payable:</strong>{{loantype.deductionAmount}}</p> -->
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
			     <td>{{emiList.amount.toFixed(2)}}</td>
			     <td>{{emiList.emi.toFixed(2)}}</td>
			     <td>{{emiList.interest.toFixed(2)}}</td>
			     <td>{{emiList.principal.toFixed(2)}}</td>
			     <td>{{emiList.outStanding.toFixed(2)}}</td>
			     </tr>
			     </tbody>
			     </table>
                    <!-- <p><strong>Principal:</strong>{{loantype.amount}}</p>
                    <p><strong>Interest Rate:</strong>{{loantype.interestRate}}</p>
                    <p><strong>Num of Months:</strong>{{loantype.noOfIntstallments}}</p>
                    <br>
                    <br>
                    <p><strong>Total Interest:</strong>{{loantype.totalInterest}}</p>
                    <p><strong>Payable:</strong>{{loantype.payable}}</p>
                    <p><strong>Monthly Payable:</strong>{{loantype.deductionAmount}}</p> -->
                    </div>
			     	</fieldset>
			     </div>
			  </div>
			  
			  <!-- Form field end -->	
			  
			  
			  <!-- Button Action Div Start-->											
		  
				<div class="form-actions">
			      <div class="row">
				       <div class="col-md-12">
				      		<button class="btn btn-success" type="button" data-ng-click="submit(loanEntryForm)"
								 data-ng-if="!loantype.isEdit">
								<i class="fa fa-save"></i> Save
							</button>
             				<button class="btn btn-success" type="submit" data-ng-click="update(loanEntryForm)"
								 data-ng-if="loantype.isEdit">
								<i class="fa fa-save"></i> Update
							</button>
				           	<button class="btn btn-info ng-scope" type="button" 
				           		class="btn btn-success" ng-click="reset()">
								<i class="fa fa-undo"></i> Reset
							</button>
							<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
				          		<i class="fa fa-close"></i> Cancel
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
  
  
  
  
  
  
  
  
  
  
  
  
  