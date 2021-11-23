<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="advanceForm">
								<div class="row">
			     <div class="col-sm-12 col-md-12 col-lg-6 ">
			     	<fieldset>
			     	<div class="form-group" ng-if="advance.isEdit">
												<label class="col-md-4 control-label"> Advance Code</label>
												<div class="col-md-6">
													<input type="text" class="text-left form-control input-sm"
														ng-model="advance.advanceCode" name="code" friendly-name="code"
														disabled>
												</div>
											</div>
        		 	
					 	 	<div class="form-group">
								<label class="col-md-4 control-label">Employee <span style="color: red;">*</span>
</label>
					 			<div class="col-md-6">
					 			<selectivity list="employeeList"
															property="advance.employee"
															id="employeeName" name="employee"
															data-ng-model="advance.employee"
															form-name="advanceForm" validation="required"
															friendly-name="Employee" disabled="advance.isEdit"> </selectivity>
								</div>
						  </div>
						  
						   <!-- <div class="form-group">
								<label class="col-md-4 control-label">Employee Code</label>
						 		<div class="col-md-6">
		        				 <input type="text" class="form-control"
					               name="employeeCode"
					               ng-model="advance.employeeCode" readonly>
								</div>
						  	</div>
							  
						   <div class="form-group">
								<label class="col-md-4 control-label">Designation</label>
						 		<div class="col-md-6">
						 		<input type="text" class="form-control"
					               name="designation"
					               ng-model="advance.designation" readonly>
								</div>
						  </div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Joining Date</label>
						 		<div class="col-md-6">
		        				 <input type="text" class="form-control"
					               name="joinDate"
					               ng-model="advance.joinDate | date:'dd/MM/yyyy'" readonly>
								</div>
						  	</div>
						  	
						  	<div class="form-group">
								<label class="col-md-4 control-label">No. of Years Working</label>
						 		<div class="col-md-6">
		        				 <input type="text" class="form-control"
					               name="workingYear"
					               ng-model="advance.workingYear" readonly>
								</div>
						  	</div> -->
						  <div class="form-group">
								<label class="col-md-4 control-label">Advance Description</label>
						 		<div class="col-md-6">
						 		<textarea class="form-control input-sm" rows="4" cols="50"
														ng-model="advance.description" name="description"
														id="description" style="resize: none" name="description" friendly-name="Description">
				     </textarea>
<!-- 							<input type="text" class="form-control input-sm" ng-model="advance.description"  name="Advance Description" friendly-name="Advance Description">
 -->						</div>
						  </div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Advance Amount<span style="color: red;">*</span>
</label>
						 		<div class="col-md-6">
						 									<input type="text" class="form-control" ng-if="advance.isEdit== true"   ng-model="advance.amount" name="Advance Amount" ng-pattern-restrict="^[0-9.]*$" validation="required" friendly-name="Advance Amount"  disabled="true">
						 		
							<input type="text" class="form-control" ng-if="advance.isEdit== false"  ng-model="advance.amount" name="Advance Amount" ng-pattern-restrict="^[0-9.]*$" validation="required" friendly-name="Advance Amount" >
							
							</div>
						  </div>
						  		         		 	
					<!--  	 	<div class="form-group">
								<label class="col-md-4 control-label">Disbursement Date</label>
					 			<div class="col-md-6">
					 			<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown">
																<a class="dropdown-toggle" id="disbursementdate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group">
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="Disbursement Date"
																			validation="required" friendly-name="Disbursement Date"
																			id="disbursementdate"
																			data-ng-model="advance.disbursementDate"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker
																		data-ng-model="advance.disbursementDate"
																		data-on-set-time="advance.disbursementDate= onDateSet(newDate); onFrmDateChg(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#disbursementdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
														</div>
						  </div> -->
						  
						  
						  
						  
						  
					  
						<div class="form-group">
								<label class="col-md-4 control-label">Disbursement Date<span
									style="color: red;">*</span></label>

								<div class="col-md-6">
									<ng-bs3-datepicker data-ng-model="advance.disbursementDate"
										id="Disbursementdate" name="Disbursement Date" form-name="advanceForm" friendly-name="Disbursement Date"
										validation="required" />
								</div>
							</div>  
						  
						   <div class="form-group">
								<label class="col-md-4 control-label">Opening Balance<span style="color: red;">*</span>
</label>
						 		<div class="col-md-6">
						 		<input type="text" class="form-control"  ng-if="advance.isEdit== true" ng-change="openBalance()"
					               name="openingBalance" ng-pattern-restrict="^[0-9.]*$"
					               ng-model="advance.openingBalance" validation="required" friendly-name="Open Balance" disabled="true" >
		        				 <input type="text" class="form-control"  ng-if="advance.isEdit== false" ng-change="openBalance()"
					               name="openingBalance" ng-pattern-restrict="^[0-9.]*$"
					               ng-model="advance.openingBalance" validation="required" friendly-name="Open Balance" >
					                
					               	 
								</div>
						  	</div>
						  
			     	 </fieldset>
			     </div>
		     	
		     	<div class="col-sm-12 col-md-12 col-lg-6">
		     	<fieldset>


							  
						   <div class="form-group">
								<label class="col-md-4 control-label">No. of Installments Paid</label>
						 		<div class="col-md-6">
						 		  <input type="text" class="form-control"
					               ng-if="advance.isEdit== true" name="installmentPaid"
					               ng-model="advance.installmentPaid" disabled >
						 		<input type="text" class="form-control" ng-if="advance.isEdit== false"
					               name="installmentPaid"
					               ng-model="advance.installmentPaid" >
					               
					             
								</div>
						  </div>
						  
						  <div class="form-group">
								<label class="col-md-4 control-label">Recovery Type<span style="color: red;">*</span>
</label>
						 		<div class="col-md-6">
						 		
		        				 <selectivity list="recoveryList" property="advance.recoverytype"  
										                id="type" ng-model="advance.recoverytype" form-name="advanceForm" validation="required" friendly-name="Recovery Type" name="Recovery Type" disabled="advance.isEdit" >
										         </selectivity>
								</div>
						  	</div>
						  	
						  	<div class="form-group">
								<label class="col-md-4 control-label">Installments Amount</label>
						 		<div class="col-md-6">
		        				 <input type="text" class="form-control"
					               name="Installment Amount"
					               ng-model="advance.installmentAmount"> 
								</div>
						  	</div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Deduct From<span style="color: red;">*</span>
</label>
						 		<div class="col-md-3">
						 		<selectivity list="monthList" property="advance.month"  
										                id="month" ng-model="advance.month" form-name="advanceForm" validation="required" friendly-name="Deduct Month" name="month" disabled="advance.isEdit">
										         </selectivity>
		
								</div>
								
								<div class="col-md-3">
								<selectivity list="yearList" property="advance.year"  
										                id="year" ng-model="advance.year" form-name="advanceForm" validation="required" friendly-name="Deduct Year" name="year" disabled="advance.isEdit" >
										         </selectivity>

								</div>
						  </div>
						  <div class="form-group">
								<label class="col-md-4 control-label">Total Installments</label>
						 		<div class="col-md-6">
						 									<input type="text" class="form-control"  ng-if="advance.isEdit== true" ng-model="advance.numberOfInstallments"  ng-pattern-restrict="^[0-9]*$"name="Total Installment" disabled friendly-name="Total Installment"  >
						 		
							<input type="text" class="form-control" ng-if="advance.isEdit== false" ng-model="advance.numberOfInstallments"  ng-pattern-restrict="^[0-9]*$"name="Total Installment" friendly-name="Total Installment" >
						
							</div>
						  </div>
						    <div class="form-group" ng-if="advance.isEdit== true">
								<label class="col-md-4 control-label">Balance Advance Amount:</label>
						 		<div class="col-md-6">
<!-- 						 		<label class="col-md-4 control-label">{{advance.balanceAmount}}</label>
 -->							<input type="text" class="form-control" ng-if="advance.isEdit== true" ng-model="advance.balanceAmount" name="Balance Amount" disabled friendly-name="Advance Amount"  > 
							</div>
						  </div>
			     	 </fieldset>
		     	</div>
			     
			  </div>
			  
			  <!-- Form field end -->	
			  
			  
			  <!-- Button Action Div Start-->											
		  
				<div class="form-actions">
			      <div class="row">
				       <div class="col-md-12">
				      		<button class="btn btn-success" type="button" data-ng-click="submit(advanceForm)"
								 data-ng-if="!advance.isEdit">
								<i class="fa fa-save"></i> Save
							</button>
             				<button class="btn btn-success" type="submit" data-ng-click="update(advanceForm)"
								 data-ng-if="advance.isEdit">
								<i class="fa fa-save"></i> Update
							</button>
				           	<button class="btn btn-info ng-scope" type="button" 
				           		class="btn btn-success" ng-click="reset()">
								<i class="fa fa-undo"></i>Reset
							</button>
							<button class="btn btn-danger" type="button" class="btn btn-success" ng-click="cancel()">
				          		<i class="fa fa-close"></i>Cancel
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
  