<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!-- #MAIN CONTENT -->
<script src="js/app/payroll/tds/handson/handsontable.full.js"></script>
<script src="js/app/payroll/tds/handson/handsontable.full.css"></script>
 <style>
.handsontable col.rowHeader {
    width: 150px;
}
</style> 


<div id="content">
	<!-- widget grid -->
	<section widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<span><state-breadcrumbs></state-breadcrumbs>  </span>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="payrollReportForm" role="form" >
							<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										
											
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization
												<span style="color: red;">*</span>	 
												</label>
												<div class="col-md-7">
													 <selectivity  list=companyList property="TdsBean.companyId" ng-model="TdsBean.companyId"
								 								id="companyId"  name="companyId" form-name = "payrollgenertaionForm" 
	        												validation="required" friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
				        							
				        								<input type="text" class="form-control input-sm" ng-model="TdsBean.companyName" message-id="companyId" 
        															data-validator="required" data-valid-method="submit" name="H" ng-if="companyList.length == 1" readonly> 
										               
										            
								               </div>
								             
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Name
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
												<selectivity list="employeeList" property="TdsBean.employeeId" 
										                id="employeeId" ng-model="TdsBean.employeeId"
										               name="employeeId" form-name="payrollReportForm"
										               validation="required" friendly-name="Employee Name">
										         </selectivity>
						           					
												</div>
											</div>
											
										
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7" ng-if="branchList.length > 1">
												<selectivity list="branchList" property="TdsBean.branchId" 
										                id="branchId" ng-model="TdsBean.branchId"
										               name="branchId" form-name="payrollReportForm"
										               validation="required" friendly-name="Branch">
										         </selectivity>
										         </div>
										         <div class="col-md-7" ng-if="branchList.length == 1 || branchList.length == 0">
										         <input type="text" class="form-control input-sm" ng-model="TdsBean.branchName" message-id="branchName" 
        							 				name="Hospital Name" readonly>
						           				
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Financial Year
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<selectivity  list=financialYearList property="TdsBean.financialYear" ng-model="TdsBean.financialYear"
								 						id="financialYear"  name="financialYear" form-name = "payrollReportForm"
	        											validation="required" friendly-name="Financial Year"></selectivity>
												
												</div>
												
											</div>
												
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
												<selectivity list="departmentList" property="TdsBean.departmentId" 
										                id="departmentId" ng-model="TdsBean.departmentId"
										               name="departmentId" form-name="payrollReportForm"
										               validation="required" friendly-name="Department">
										         </selectivity>
						           			
												</div>
											</div>
	           <div class="form-group">
               <label class="col-md-5 control-label">
                TDS based on
                <span style="color: red;">*</span>
               </label>
               <div class="col-md-4">
                <label>
                 <input type="checkbox" class="checkbox style-0" data-ng-model="TdsBean.declared" id = "declared"  ng-change="checkdecalare(TdsBean.declared)">
                 <span></span>
                </label>
                <label class="control-label">
                 Declared
                </label>
               </div>
               <div class="col-md-3" style="padding-left: 6px;">
                <label>
                 <input type="checkbox" class="checkbox style-0" data-ng-model="TdsBean.actual"  id = actual ng-change="checkactuval(TdsBean.actual)">
                 <span></span>
                </label>
                <label class="control-label">
                 Actual
                </label>
               </div>
              </div>
								</div>
										
									</div>
								</div>
								
				<div class="form-actions">
			      <div class="row">
				       <div class="col-md-12">
				      	 <button class="btn btn-success" type="submit" id = "showButton" class="btn btn-success" data-ng-click = "focusHandson(payrollReportForm)">
				      	 Show </button>
		             	</div>
		            	   
			      </div>
			     </div>
 
<div id="result"><h1>
Data is getting loaded
This will take few seconds...
</h1>
</div>


 <!--    handsontable -->
   <div class="well book-widget-well" id ="handsonGrid" >
     <div class="row">

     <h1>Tax Calculation</h1>
      <div class="col-sm-12 col-md-12 col-lg-12">
         <div>
       <div id="employeeTDS" class="handsontable"></div>
      </div>
     </div>
     </div>
    </div> 
    </form>
	     			</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
	
		<script type="text/javascript">
  $("#loader").hide();
  $("#result").show();
</script>	
</div>
