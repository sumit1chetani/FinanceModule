<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
				    <div role="content">
				      <div class="widget-body">
				      <form class="form-horizontal" id="budgetForm" name="budgetDefinitionForm" novalidate method="post">
				      	<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
						     <div class="col-sm-6">
						     	<div class="form-group">
			        				<label class="col-md-4 control-label"> 
			        				Organization Name
			        				</label>
			        				<div class="col-md-7">
				        				<selectivity list="companyList" name="organizationTxt" property="budgetData.company" id="hospital"
				        				ng-model="budgetData.company" form-name = "budgetDefinitionForm"
				        				validation="required" friendly-name="companyName"></selectivity>
									</div>
								</div>
						     	<!-- <div class="form-group " ng-if="!edit">
							        <label class="col-md-4 control-label">Expenses<span style="color:red;"> *</span></label>
							        <div class="col-md-7">								       					
								        <selectivity list="expenseList" name="expensTxt" property="budgetData.expense_type"  ng-model="budgetData.expense_type" 
								        id="cmbAccountName" object="accounts" validation="required" 
								        friendly-name="Expenses" form-name = "budgetDefinitionForm"></selectivity>								        
							        </div>
						       	</div>
						       	<div class="form-group " ng-if="edit">
							        <label class="col-md-4 control-label">Expenses<span style="color:red;"> *</span></label>
							        <div class="col-md-7">	
							        	<input type="text" class="form-control input-sm" ng-model="budgetData.expense_type" readonly />							       					
							        </div>
						       	</div> -->
						       	<div class="form-group " >
							      <label class="col-md-4 control-label"> Budget Type </label>
			        				<div class="col-md-7">
				        				<selectivity list="budgetTypeList" name="budgettype" property="budgetData.budgetType" id="budgettype"
				        				ng-model="budgetData.budgetType" form-name = "budgetDefinitionForm"
				        				validation="required" friendly-name="Budget Type"></selectivity>
									</div>
						       	</div> 
						       	
						       	<div class="form-group">
						       	<label class="col-md-4 control-label">Capex </label>
			        				
													 	<div class="checkbox"> 
															<label> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="capex"
																ng-change="capex1(capex)"
																data-ng-true-value="true" data-ng-false-value="false">
															 <span></span>
															</label>
														</div> 
															<label class="col-md-4 control-label">Revex </label>
			        				
													<div class="checkbox"> 
															<label> <input type="checkbox"
																class="checkbox style-0"
																data-ng-model="revex"																
																ng-change="revex1(revex)"
																data-ng-true-value="true" data-ng-false-value="false"> <span></span>
															</label>
														 </div> 
													</div>
													
						       	<div class="form-group">
			        				<label class="col-md-4 control-label"> Name Of The Project</label>
			        				<div class="col-md-7">	
							        	<input type="text" class="form-control input-sm" ng-model="budgetData.projectName"  />							       					
							        </div>
									</div> 
						    </div>
						    <div class="col-sm-6">
						    	<div class="form-group">
			        				<label class="col-md-4 control-label"> Financial Year </label>
			        				<div class="col-md-7">
				        				<selectivity list="finYearList" name="finTxt"  property="budgetData.financial_year" id="hospital"
				        				ng-model="budgetData.financial_year" form-name = "budgetDefinitionForm" 
				        				validation="required" friendly-name="Financial Year"></selectivity>
									</div>
								</div>
						     	<%-- <div class="form-group">
			        				<label class="col-md-4 control-label"> Status <spring:message
			              			code="label.asterisk.symbol"></spring:message></label>
			        				<div class="col-md-7">
				        				<selectivity list="statusList" name="statusTxt" property="budgetData.status" id="hospital"
				        				ng-model="budgetData.status" form-name = "budgetDefinitionForm"
				        				validation="required" friendly-name="Status"></selectivity>
									</div>
								</div> --%>
							<div class="form-group" ng-if="capexNo">
			        				<label class="col-md-4 control-label"> Capex No </label>
			        				<div class="col-md-7">	
							        	<input type="text" class="form-control input-sm" 
							        	ng-model="budgetData.capexno"  />							       					
							        </div>
									</div> 
									<div class="form-group" ng-if ="!capexNo">
			        				<label class="col-md-4 control-label"> Revex No </label>
			        				<div class="col-md-7">	
							        	<input type="text" class="form-control input-sm" 
							        	ng-model="budgetData.capexno"  />							       					
							        </div>
									</div> 
									<div class="form-group">
			        				<label class="col-md-4 control-label"> Fund Type </label>
			        				<div class="col-md-7">
				        				<selectivity list="costList" name="costCenter"  property="budgetData.costCenter" id="hospital"
				        				ng-model="budgetData.costCenter" form-name = "budgetDefinitionForm" 
				        				validation="required" friendly-name="costCenter"></selectivity>
									</div>
								</div>
						     	<div class="form-group">
			        				<label class="col-md-4 control-label"> Amount </label>
			        				<div class="col-md-7">
				        				<input type="text" name="amountTxt" class="form-control input-sm" ng-model="budgetData.amount" 
				        				validation="required" friendly-name="Amount" />
									</div>
								</div>
						 
						    </div>
					    </div>
						<!-- <div class="col-md-12" data-ng-if="budgetData.expense_type == 'Admin'">
							 <div class="col-sm-6" id="leftDivAd">
						    </div>
						    <div class="col-sm-6" id="rightDivAd">
						    </div>
						</div> -->
						
						<!-- <div class="col-md-12" data-ng-if="budgetData.expense_type == 'Operational'">
							 <div class="col-sm-6" id="leftDivOp">
						    </div>
						    <div class="col-sm-6" id="rightDivOp">
						    </div>
						</div> -->
				
				        </div> <!-- /row -->
				        <div class="form-actions">
				         <div class="row">
				          <div class="col-md-12">
						           <div class="content">
						      	<div class="form-actions">
						        <div class="row">
						         <div class="col-md-12">
						          <button class="btn btn-success" type="button" ng-if="!edit" ng-click="save()" >
						           <i class="fa fa-save"></i>
						           Save
						          </button>
						          <button class="btn btn-success" type="button" ng-if="edit" ng-click="update()">
						           <i class="fa fa-update"></i>
						           Update
						          </button>
						          <button type="button" class="btn btn-info"
						            ng-click="reset()" >
						            <i class="fa fa-undo"></i>
						            Reset
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
