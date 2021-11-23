<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
table.dataTable thead .sorting:after {
  content: "";
}
.main_container{
	overflow:auto;
}
</style>
<div id="content">
	<section data-widget-grid id="widget-grid">
		<div class="padding-top-10">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					 <header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
						<div class="widget-toolbar">
							<!-- add: non-hidden - to disable auto hide -->
							<div>
								<span> <span class="button-icon" data-reset-widgets
									rel="tooltip"
									title="<spring:message code="title.widget.reset"></spring:message>"
									data-placement="bottom"> <i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
				    <div role="content">
				      <div class="widget-body">
				      <form class="form-horizontal" name="budgetAllocationForm" novalidate method="post">
				      	<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
						     <div class="col-sm-6">
						     	<div class="form-group">
			        				<label class="col-md-4 control-label"> <spring:message
			              			code="label.company.name"></spring:message> <spring:message
			              			code="label.asterisk.symbol"></spring:message></label>
			        				<div class="col-md-7">
			        					<input type="text" class="form-control input-sm" ng-model="budgetData.companyName" readonly />
				        				<!-- <selectivity list="companyList" property="budgetData.company" id="hospital" disabled="disabled"
				        				ng-model="budgetData.company" name="hospital" form-name = "budgetAllocationForm"
				        				validation="required" friendly-name="Company"></selectivity> -->
									</div>
								</div>
						     	<div class="form-group ">
							        <label class="col-md-4 control-label">Expenses<span style="color:red;"> *</span></label>
							        <div class="col-md-7">	
							        	<input type="text" class="form-control input-sm" ng-model="budgetData.expense_type" readonly />							       					
								       <!--  <selectivity list="expenseList" property="budgetData.expense_type"  ng-model="budgetData.expense_type" 
								        id="cmbAccountName" name="Account Head" object="accounts" validation="required" 
								        friendly-name="Expenses" form-name = "budgetAllocationForm"></selectivity>	 -->							        
							        </div>
						       	</div>
						    </div>
						    <div class="col-sm-6">
						    	<div class="form-group">
			        				<label class="col-md-4 control-label"> Financial Year <spring:message
			              			code="label.asterisk.symbol"></spring:message></label>
			        				<div class="col-md-7">
			        					<input type="text" class="form-control input-sm" ng-model="budgetData.financial_year" readonly />	
				        				<!-- <selectivity list="finYearList" property="budgetData.financial_year" id="hospital"
				        				ng-model="budgetData.financial_year" name="hospital" form-name = "budgetAllocationForm" 
				        				validation="required" friendly-name="Financial Year"></selectivity> -->
									</div>
								</div>
						     	<div class="form-group">
			        				<label class="col-md-4 control-label"> Status <spring:message
			              			code="label.asterisk.symbol"></spring:message></label>
			        				<div class="col-md-7">
				        				<selectivity list="statusList" property="budgetData.status" id="hospital"
				        				ng-model="budgetData.status" name="hospital" form-name = "budgetAllocationForm"
				        				validation="required" friendly-name="Status"></selectivity>
									</div>
								</div>
						    </div>
					    </div>
					    
					    <div class="col-md-12" data-ng-if="budgetData.expense_type == 'Admin'">
							 <div class="col-sm-6" id="leftDivAd">
						    </div>
						    <div class="col-sm-6" id="rightDivAd">
						    </div>
						</div>
						
						<div class="col-md-12" data-ng-if="budgetData.expense_type == 'Operational'">
							 <div class="col-sm-6" id="leftDivOp">
						    </div>
						    <div class="col-sm-6" id="rightDivOp">
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
				      </form>
				      </div> <!-- /widget-body -->
				      <!-- end widget content -->
					</div> <!-- role="content" -->
	     		</div> <!-- /standard-datatable-widget -->
			</article>
  		</div> <!-- /padding-top-10 -->
 	</section>
</div>