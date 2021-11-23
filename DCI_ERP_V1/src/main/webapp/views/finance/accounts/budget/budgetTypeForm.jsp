<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
				    <div role="content">
				      <div class="widget-body">
				      <form class="form-horizontal" name="budgetTypeForm" novalidate method="post">
				      	<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
						     <div class="col-sm-6">
						     	<div class="form-group">
			        				<label class="col-md-4 control-label"> Budget Type <spring:message
			              			code="label.asterisk.symbol"></spring:message></label>
			        				<div class="col-md-7">
				        				<input type="text" name="miscTxt" class="form-control input-sm" ng-model="budgetType.budget_type" 
				        				validation="required" friendly-name="Budget Type" ng-disabled="edit"/>
									</div>
								</div>
						    </div>
						    <div class="col-sm-6">
						    	<div class="form-group">
	       							<label class="col-md-4 control-label">Expenses</label>
			      				    <div class="col-md-5 inputGroupContainer">
			      				    	<!--  <select id="txtJVPartner" multiple="multiple" name="multiselect[]" ng-model="jvAgreementModelData.jvPartner"
											 ng-options="option.name for option in jvPartnerList" data-dropdownmultiselect>    
											   <option data-ng-repeat="option in jvPartnerList" value="{{getOptionId(option)}}" 
											   ng-selected="isOptionSelected(option)" data-ng-bind-template="{{option.name}}"></option>
											</select> -->
											
										 <select id="txtExpenses" multiple="multiple"  name="txtExp" ng-model="budgetType.expCodes"
											 data-dropdownmultiselect>    
											<option ng-repeat="obj in expenseList" value="{{obj.id}}">{{obj.text}}</option>
										</select> 	
									</div>
								</div>	
						    </div>
					    
					    
		
					    <div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
						     <div class="col-sm-6">
						     	<!-- <div class="form-group">
			        				<label class="col-md-4 control-label"> Amount </label>
			        				<div class="col-md-7">
				        				<input type="text" name="amountTxt" class="form-control input-sm" ng-model="budgetType.amount" 
				        				validation="required" friendly-name="Amount" />
									</div>
								</div> -->
						    </div>
				</div>
				        </div><!-- /row -->
				        
				        <div class="form-actions">
				         <div class="row">
				          <div class="col-md-12">
						           <div class="content">
						      	<div class="form-actions">
						        <div class="row">
						         <div class="col-md-12">
						          <button class="btn btn-success" type="button" ng-if="!edit" ng-click="validate()" >
						           <i class="fa fa-save"></i>
						           Save
						          </button>
						          <button class="btn btn-success" type="button" ng-if="edit" ng-click="validate()">
						           <i class="fa fa-save"></i>
						           Update
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