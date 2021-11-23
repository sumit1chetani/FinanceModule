
<style type="text/css">
.nav-justified>li, .nav-tabs.nav-justified>li {
	background-color: #3B8A8A;
}

.textareath {
	resize: vertical;
	max-height: 124px;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
		<div class="wrapper-md">
			<div class="panel panel-default panel-default-form">
				<%@include file="/views/templates/panel-header-form.jsp"%>
		 <input type="hidden" value="${form_code}" id="form_code_id" /> 
					<div role="content">
   		<form class="form-horizontal" name="budgetReportForm" >
	      <div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 panel-body">
						<div class="col-md-4">
						
				          	<div class="form-group">
								<label class="col-md-4 control-label  vessel-text">Company
											Name <span style="color: red;">*</span>
										</label>
								<div class="col-md-6">
									<selectivity list="companyList" property="budget.companyId" ng-model="budget.companyId"  name="companyId" validation="required"  friendly-name="<spring:message
			              			code="label.company.name"></spring:message>" form-name = "budgetReportForm" ></selectivity>
								
								</div>
							</div>

		          		</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Financial Year
									<span style="color: red;">*</span>	 
								</label>
								<div class="col-md-6">
									<selectivity list="finYearList" property="budget.financialyear" ng-model="budget.financialyear" name="financialyear" validation="required" friendly-name="Financial Year" form-name = "budgetReportForm" ></selectivity>
									

								</div>
							</div>
						</div>
		          		<div class="col-md-4">
			          		<div class="form-group">
								<div class="col-md-12">
			            			<button class ="btn btn-success" type="button" data-ng-click="submit(budgetReportForm);">Submit</button>
	            				</div>
            				</div>
		          		</div>
		          </div>
				</div>

		      <div class="row">
					<div class="padding-left-5 padding-top-5" id="jqgrid">
						<div id="inventGrid">
			  				<table id="budgetOverviewGrid"></table>
			  				<div id="budgetOverviewPage"></div>
		  				</div>
					</div>
			  </div>

			<!--   <div class="row">
			  		<div class="col-xs-5 col-xs-offset-9 padding-top-5">
		          	<div class="form-group">
						<label class="col-md-3 control-label">Total Qty</label>
						<div class="col-md-3">
							<input type="text" class="form-control input-sm" data-ng-model="inventoryModel.totQty" id="totalQty" readonly="readonly">
						</div>
					</div>
					</div>
        	</div> -->
   		 </form>
      <!-- end widget content -->
     <!-- end widget div -->
    </div>

			</div>
		</div>