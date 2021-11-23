


<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 
 <div class="panel-body float-left padding-0" style="width: 100%;">
   		<form class="form-horizontal" name="budgetReportForm" >
	      <div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12 panel-body">
						<div class="col-md-4">
				          	<div class="form-group">
								<label class="col-md-5 control-label">Organization Name<span style="color: red;">*</span></label>
								<div class="col-md-6">
									<selectivity list="companyList" property="budget.companyId" ng-model="budget.companyId"  name="organizationId" validation="required"  friendly-name="<spring:message
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
									<selectivity list="financeList" property="budget.financialyear" ng-model="budget.financialyear" name="financialyear" validation="required" friendly-name="Financial Year" form-name = "budgetReportForm" ></selectivity>
									

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

		    <!--   <div class="row">
					<div class="padding-left-5 padding-top-5" id="jqgrid">
						<div id="inventGrid">
			  				<table id="budgetOverviewGrid"></table>
			  				<div id="budgetOverviewPage"></div>
		  				</div>
					</div>
			  </div> -->
 <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="budgetList">
         <div class="dt-toolbar">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>		    
		</div>
 <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
        <thead class="dataTables-Main-Head">
        	<tr>
	           
	           <th class="sorting width_8" data-st-sort="financialyear">Financial Year</th>
	           <th class="sorting width_4" data-st-sort="companyName">Organization</th>	             
	           <th class="sorting width_8" data-st-sort="budgetTypeName">Budget Type</th>   
	           <th class="sorting width_15" data-st-sort="projectName">Project Name</th>  
	           <th class="sorting width_15" data-st-sort="costCenterName"> Fund Type</th>    
	           <th class="sorting width_6 text-center table-heading" data-st-sort="capexNo">Capex/Revex No</th>  
	           <th class="sorting width_6 text-center table-heading" data-st-sort="budgetAmt">Budget Amount</th>
	             <th class="sorting width_6 text-center table-heading" data-st-sort="utilizedAmt">Utilized Amount</th>
	               <th class="sorting width_6 text-center table-heading" data-st-sort="balanceAmt">Balance Amount</th>
        	</tr>
        </thead>
        
		<tbody class="dataTables-Main-Body">
	    	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objListItem in displayedCollection">
	    	<td>{{objListItem.financialyear}}</td>
	    	<td>{{objListItem.companyName}}</td>
	    	<td>{{objListItem.budgetTypeName}}</td>
	    	<td>{{objListItem.projectName}}</td>
	    	<td>{{objListItem.costCenterName}}</td>
	    	<td>{{objListItem.capexNo}}</td>
	    	<td align ="right">{{objListItem.budgetAmt|number:2}}</td>
	    	<td align ="right">{{objListItem.utilizedAmt|number:2}}</td>
	    	<td align ="right">{{objListItem.balanceAmt|number:2}}</td>
	    	</tr>
	    	</tbody>
	    	</table>
	    	
<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
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
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>