<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
	      <span class="widget-icon">
	       <i class="fa fa-table"></i>
	      </span>
  		  <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     
     <div class="row book-widget-row" style="padding-bottom: 12px;" ng-init="init()">
		<form class="form-horizontal" name="advanceForm">
		
			<!-- Form field start -->		
		      <div class="row">
			     <div class="col-sm-12 col-md-12 col-lg-6 ">
			     	<fieldset>
        		 	
					 	 	<div class="form-group">
								<label class="col-md-4 control-label">Employee Name<spring:message code="label.asterisk.symbol"></spring:message></label>
					 			<div class="col-md-6">
					 			<label class="col-md-12 control-label">{{advance.employeeName}}</label>
								</div>
						  </div>
						  
						   <div class="form-group">
								<label class="col-md-4 control-label">Employee Code</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.employeeCode}}</label>
								</div>
						  	</div>
							  
						   <div class="form-group">
								<label class="col-md-4 control-label">Designation</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.designation}}</label>
								</div>
						  </div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Joining Date</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.joinDate | date:'dd/MM/yyyy'}}</label>
								</div>
						  	</div>
						  	
						  	<div class="form-group">
								<label class="col-md-4 control-label">No. of Years Working</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.workingYear}}</label>
								</div>
						  	</div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Advance Description</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.description}}</label>
					</div>
						  </div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Advance Amount<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.amount"}}</label>
							</div>
						  </div>
						  
			     	 </fieldset>
			     </div>
		     	
		     	<div class="col-sm-12 col-md-12 col-lg-6">
		     	<fieldset>

		         		 	
					 	 	<div class="form-group">
								<label class="col-md-4 control-label">Disbursement Date</label>
					 			<div class="col-md-6">
					 			<label class="col-md-12 control-label">{{advance.disbursementdate}}</label>
								</div>
						  </div>
						  
						   <div class="form-group">
								<label class="col-md-4 control-label">Opening Balance</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.openingBalance}}</label>
								</div>
						  	</div>
							  
						   <div class="form-group">
								<label class="col-md-4 control-label">No. of Installments Paid</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.installmentPaid}}</label>
								</div>
						  </div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Recovery Type</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.type}}</label>
								</div>
						  	</div>
						  	
						  	<div class="form-group">
								<label class="col-md-4 control-label">Installments Amount</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.installmentAmount}}</label>
								</div>
						  	</div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Repayment start Date</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{advance.startDate}}</label>
							</div>
						  </div>
						  <div class="form-group">
								<label class="col-md-4 control-label">No. of Installments</label>
						 		<div class="col-md-6">
						 		<label class="col-md-12 control-label">{{loantype.numberOfInstallments}}</label>
							</div>
						  </div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Status<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		<div class="col-md-6">
						 			<select class="form-control" ng-model="advance.status">
										   				 <option value="">--Select--</option>
										   				 <option value="1">Pending</option>
										   					<option value="2">Approved</option>
										   				   <option value="3">Reject</option>
									</select>
						 		</div>
								
								</div>
						  
			     	 </fieldset>
		     	</div>
			     <!-- <div class="col-sm-12 col-md-12 col-lg-6">
			     
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
                    <p><strong>Principal:</strong>{{loantype.amount}}</p>
                    <p><strong>Interest Rate:</strong>{{loantype.interestRate}}</p>
                    <p><strong>Num of Months:</strong>{{loantype.numberOfIntstalments}}</p>
                    <br>
                    <br>
                    <p><strong>Total Interest:</strong>{{loantype.totalInterest}}</p>
                    <p><strong>Payable:</strong>{{loantype.payable}}</p>
                    <p><strong>Monthly Payable:</strong>{{loantype.deductionAmount}}</p>
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
                    <p><strong>Principal:</strong>{{loantype.amount}}</p>
                    <p><strong>Interest Rate:</strong>{{loantype.interestRate}}</p>
                    <p><strong>Num of Months:</strong>{{loantype.noOfIntstallments}}</p>
                    <br>
                    <br>
                    <p><strong>Total Interest:</strong>{{loantype.totalInterest}}</p>
                    <p><strong>Payable:</strong>{{loantype.payable}}</p>
                    <p><strong>Monthly Payable:</strong>{{loantype.deductionAmount}}</p>
                    </div>
			     	</fieldset>
			     </div> -->
			  </div>
			  
			  <!-- Form field end -->	
			  
			  
			  <!-- Button Action Div Start-->											
		  
				<div class="form-actions">
			      <div class="row">
				       <div class="col-md-12">
				      		
             				<button class="btn btn-success" type="submit" data-ng-click="update()"
								 data-ng-if="loantype.isEdit">
								<i class="fa fa-save"></i> Submit
							</button>
				           	
							<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
				          		<i class="fa fa-close"></i> <spring:message code="label.cancel"></spring:message>
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
  