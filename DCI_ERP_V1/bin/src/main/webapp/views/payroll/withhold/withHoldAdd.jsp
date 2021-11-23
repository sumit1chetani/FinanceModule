<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="advanceForm">
				<div class="row">
			     <div class="col-sm-12 col-md-12 col-lg-6 ">
			     	<fieldset>
			     	<!-- <div class="form-group" ng-if="isEdit">
												<label class="col-md-4 control-label"> WithHold  Code</label>
												<div class="col-md-6">
													<input type="text" class="text-left form-control input-sm"
														ng-model="withhold.withHoldCode" name="code" friendly-name="code"
														disabled>
												</div>
											</div> -->
        		 	
					 	 	<div class="form-group">
								<label class="col-md-4 control-label">Employee<spring:message code="label.asterisk.symbol"></spring:message></label>
								
								
					 			<div class="col-md-6" >
					 			
					 			<label class="col-md-6 control-label"
										ng-if="isEdit">{{withhold.employee}}</label>
					 			<selectivity  list="employeelist" 
															property="withhold.employee"
															id="employeeName" name="employee"
															data-ng-model="withhold.employee"
															form-name="advanceForm" validation="required"
															friendly-name="Employee" ng-if="!isEdit" > </selectivity>
								</div>
						  </div>
						  
					
						
						 		  <div class="form-group">
								<label class="col-md-4 control-label">Withhold From<spring:message code="label.asterisk.symbol"></spring:message></label>
						 		
						 		
						 		<div class="col-md-3" >
						 
						 		
						 		
						 		<selectivity list="monthList"  property="withhold.fromMonth"  
										                id="frommonth" ng-model="withhold.fromMonth" form-name="advanceForm" validation="required" friendly-name="With Hold From Month " name="fromMonth"  >
										         </selectivity>
		
								</div>
								
								<div class="col-md-3">
								<selectivity list="yearList" property="withhold.fromYear"   
										                id="fromyear" ng-model="withhold.fromYear" form-name="advanceForm" validation="required" friendly-name="With Hold From Year" name="fromYear"  >
										         </selectivity>

								</div>
						  </div>
						  		         		 	
					 	 	
						  
						  
						  
			     	 </fieldset>
			     </div>
		     	
		     	<div class="col-sm-12 col-md-12 col-lg-6">
		     	<fieldset>

<!-- <div class="form-group">
								<label class="col-md-4 control-label">Withhold Date<spring:message code="label.asterisk.symbol"></spring:message></label>
					 			<div class="col-md-6">
					 			<div class='input-group date datetimepick col-md-12'>
															<div class="dropdown" >
																<a class="dropdown-toggle" id="withholddate" role="button"
																	data-toggle="dropdown" data-target="#" href="#">
																	<div class="input-group" >
																		<input type="text" class="form-control"
																			placeholder="dd/mm/yyyy" name="WithHoldDate" form-name="advanceForm"
																			validation="required" friendly-name="WithHold Date"
																			id="WithHolddate"
																			data-ng-model="withhold.withholdDate"><span
																			class="input-group-addon"><i
																			class="glyphicon glyphicon-calendar"></i></span>
																	</div>
																</a>
																<ul class="dropdown-menu" role="menu"
																	aria-labelledby="dLabel">
																	<datetimepicker 
																		data-ng-model="withhold.withholddate" 
																		data-on-set-time="withhold.withholdDate= onDateSet(newDate); onFrmDateChg(newDate)"
																		data-datetimepicker-config="{ dropdownSelector: '#disbursementdate',startView:'day', minView:'day'}" />
																</ul>
															</div>
														</div>
														</div>
						  </div>

							   -->
					
				  <div class="form-group">
								<label class="col-md-4 control-label">Withhold Date<span
									style="color: red;">*</span></label>

								<div class="col-md-6">
									<ng-bs3-datepicker data-ng-model="withhold.withholdDate"
										id="withholdDate" name="withholdDate" form-name="advanceForm" friendly-name="withholdDate"
										validation="required" />
								</div>
							</div> 

							  
				
						
						<div class="form-group">
								<label class="col-md-4 control-label">Withhold Till</label>
						 		<div class="col-md-3">
						 		<selectivity list="monthList" property="withhold.tillMonth"  
										                id="month" ng-model="withhold.tillMonth" form-name="advanceForm"  name="tillMonth" >
										         </selectivity>
		
								</div>
								
								<div class="col-md-3">
								<selectivity list="yearList" property="withhold.tillYear"  
										                id="toyear1" ng-model="withhold.tillYear" form-name="advanceForm"  name="year" >
										         </selectivity>

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
								 data-ng-if="!isEdit">
								<i class="fa fa-save"></i> Save
							</button>
             				<button class="btn btn-success" type="submit" data-ng-click="update(advanceForm)"
								 data-ng-if="isEdit">
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
  