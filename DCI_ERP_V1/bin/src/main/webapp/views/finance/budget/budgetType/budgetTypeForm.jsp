
<style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}
</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
				<input type="hidden" value="${form_code}" id="form_code_id">
				<div class="panel-body">
					<form name="budgetTypeForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<div class="col-sm-12">
								<div class="col-sm-6">


									<div class="form-group">
			        				<label class="col-md-6 control-label"> Budget Type <span style="color: red;">*</span></label>
			        				
			        				
			        				<div class="col-md-6">
											<input type="text" class="form-control input-sm"
												friendly-name="Budget Type" validation="required"
												 ng-model="budgetType.budget_type" maxlength="250"
												name="budget_type" id="budget_type" ng-disabled="edit"/>
										</div>
				        				
									</div>
									</div>
									<div class="col-sm-6">
									<div class="form-group">
	       							<label class="col-md-6 control-label">Expenses</label>
			      				    <div class="col-md-6 ">
			      				    
											
										<select id="txtExpenses" multiple="multiple"  name="txtExp" ng-model="budgetType.expCodes"
											 data-dropdownmultiselect>    
											<option ng-repeat="obj in expenseList" value="{{obj.id}}">{{obj.text}}</option>
										</select> 
									</div>
								</div>	
							


									


</div>
				</div>					
						</div>

						<!-- /table-responsive -->






						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
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
					</form>
				</div>

			</div>
		</div>
	</div>
</div>