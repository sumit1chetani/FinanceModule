

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>

	<div class="panel panel-default panel-default-list" st-persist="generationTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<br>
			  <form class="form-horizontal" name="payrollgenertaionForm" role="form" > 
     	<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Organization
												<span style="color: red;">*</span>	 
												</label>
												<div class="col-md-7">
												<!-- 	<selectivity  list=companyList property="payrollgeneration.companyId" ng-model="payrollgeneration.companyId"
								 								id="companyId"  name="companyId" form-name = "payrollgenertaionForm" 
	        												validation="required" friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
				        							
				     											<input type="text" class="form-control input-sm" ng-model="payrollgeneration.companyName" message-id="companyId" 
        															data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="companyList.length == 1" readonly> 
			                       	 	 --> <selectivity list="companyList"
										property="payrollgeneration.companyId" id="companyId"
										object="companyId"></selectivity>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Name
													
												</label>
												<div class="col-md-7">
						           						 <selectivity  list=employeeList property="payrollgeneration.employeeId" ng-model="payrollgeneration.employeeId" id="employeeId"  name="employeeId" form-name = "payrollgenertaionForm" ></selectivity> 
												 <br><p style="color:red;">Only eligible employees are listed based on the selected Month & Year</p>
												</div>
												
												
											</div>
											
										
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label" >Branch
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
						           						<selectivity  list=branchList property="payrollgeneration.branchId" ng-model="payrollgeneration.branchId" id="branchId"  name="branchId" form-name = "payrollgenertaionForm" validation="required" friendly-name="Branch Name" ng-if="branchList.length > 1"></selectivity>
						           						 <input type="text" class="form-control input-sm" ng-model="payrollgeneration.branchName" message-id="branchId" 
        										data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0 " readonly>     	 	 
			                       	 	
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Month And Year
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													 <selectivity  list=monthYearList property="payrollgeneration.monthYear" ng-model="payrollgeneration.monthYear" id="monthYear"  name="monthYear" form-name = "payrollgenertaionForm" 
	        													validation="required" friendly-name="Month Year"></selectivity>
													</div>
												
											</div>
											<div class="form-group">
											
										</div>
											
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
												</label>
												<div class="col-md-7">
						           					 <selectivity  list=departmentList property="payrollgeneration.departmentId" ng-model="payrollgeneration.departmentId" id="departmentId"  name="departmentId" form-name = "payrollgenertaionForm"></selectivity> 
												</div>
											</div>
											
										
								</div>
										
									</div>
									<div class="row">
										<label class="col-md-4 control-label">
												</label>
										<div class="col-md-5">
											<button class="btn btn-success" type="button" data-ng-click="save(payrollgenertaionForm)"
												class="btn btn-success" >
												Generate
											</button>
											<button class="btn btn-primary" type="button" data-ng-click=""
												class="btn btn-primary" >
												Payroll to JV
											</button>
											<button class="btn btn-primary" type="button" data-ng-click=""
												class="btn btn-primary" >
												Payroll to Payment
											</button>
											<button class="btn btn-primary" type="button" data-ng-click=""
												class="btn btn-primary" >
												Advise to Bank
											</button>											
										</div>
									</div>
								</div>
							
							
						       
								<div class="row" data-ng-if="payrollgeneration.isGenerate" >
									<div class="col-sm-12 col-md-12 col-lg-12 panel-body" style="font-size: 20px;color: blue">
									<!-- <label ng-if="!payrollgeneration.isExists" > <b>For the following employees don't have their pay component entries. Please create pay component entries then generate salary.
									</b></label> -->
									<label ng-if="payrollgeneration.isExists" > <b>Payroll is already generated for the following employees
									</b></label>
								</div>	
								</div><br><br>
								</form>
							<div data-ng-if="payrollgeneration.isGenerate">	
							<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection1" data-ng-if="payrollgeneration.isGenerate">
							<div class="dt-toolbar">
		      			<%-- 			 <%@include file="/views/layout/toolbar-header.tpl.jsp"%>		       
		       			 --%>	</div>
						    
						     <!--    <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
						        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
						         <thead class="dataTables-Main-Head">
						          <tr>
						           <th st-sort="employeeId">EmployeeId</th>
						           <th st-sort="firstName">EmployeeName</th>
						         
						         </tr>
						    	</thead>
								<tbody class="dataTables-Main-Body">
						          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="empPayComList in displayedCollection">
						         	<td>{{empPayComList.employeeId}}</td>
						           	<!-- <td ng-if="!payrollgeneration.isExists">{{empPayComList.firstName}}</td> -->
						           	<td ng-if="payrollgeneration.isExists">{{empPayComList.employeeName}}</td>
						           	
									</tr>
						         </tbody>
												         
						        </table>
						        <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
						       
						      <%--  <div class="col-sm-12 col-md-12 col-lg-12 panel-body" style="font-size: 20px;color: blue">
									<label  > <b>For the following employees don't have their payroll flag.
									</b></label>
								</div>	
								
								<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection2">
							<div class="dt-toolbar">
		      						 <%@include file="/views/layout/toolbar-header.tpl.jsp"%>		       
		       				</div>
						    
						     <!--    <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
						        <table id="dt_basic2" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
						         <thead class="dataTables-Main-Head">
						          <tr>
						           <th st-sort="employeeId">Employee Id</th>
						           <th st-sort="firstName">Employee Name</th>
						         
						         </tr>
						    	</thead>
								<tbody class="dataTables-Main-Body">
						          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="empPayComList2 in displayedCollection">
						         	<td>{{empPayComList2.employeeId}}</td>
						           	<td>{{empPayComList2.firstName}}</td>
						           	
									</tr>
						         </tbody>
												         
						        </table>
						        <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
						       </div> --%>
							</div>
							<div class="row" data-ng-if="payrollgeneration.isGenerate1" >
									<div class="col-sm-12 col-md-12 col-lg-12 panel-body" style="font-size: 20px;color: blue">
									<label ng-if="payrollgeneration.isnonExists" > <b>For the following employees don't have their pay component entries. Please create pay component entries then generate salary.
									</b></label>
									<!-- <label ng-if="payrollgeneration.isExists" > <b>Payroll is already generated for the following employees
									</b></label> -->
								</div>	
								</div>
							<div data-ng-if="payrollgeneration.isGenerate1">	
							<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection" data-ng-if="payrollgeneration.isGenerate">
							<div class="dt-toolbar">
		      				<%-- 		 <%@include file="/views/layout/toolbar-header.tpl.jsp"%>		       
		       			 --%>	</div>
						    
						     <!--    <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
						        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
						         <thead class="dataTables-Main-Head">
						          <tr>
						           <th st-sort="employeeId">EmployeeId</th>
						           <th st-sort="firstName">EmployeeName</th>
						         
						         </tr>
						    	</thead>
								<tbody class="dataTables-Main-Body">
						          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="empPayComList in displayedCollection">
						         	<td>{{empPayComList.empId}}</td>
						           	<td ng-if="payrollgeneration.isnonExists">{{empPayComList.firstName}}</td>
						           	<!-- <td ng-if="payrollgeneration.isExists">{{empPayComList.employeeName}}</td> -->
						           	
									</tr>
						         </tbody>
												         
						        </table>
						       		        <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
						       
							</div>
							</div>
						</div>
						
						
						
						
  </div>
  <!-- end widget content -->
 </div>
 
<!--  
</div> 
 -->














<%-- 


<!-- #MAIN CONTENT -->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

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
						<form class="form-horizontal" name="payrollgenertaionForm" role="form" >
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Organization
												<span style="color: red;">*</span>	 
												</label>
												<div class="col-md-7">
													<selectivity  list=companyList property="payrollgeneration.companyId" ng-model="payrollgeneration.companyId"
								 								id="companyId"  name="companyId" form-name = "payrollgenertaionForm" 
	        												validation="required" friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
				        							
				     											<input type="text" class="form-control input-sm" ng-model="payrollgeneration.companyName" message-id="companyId" 
        															data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="companyList.length == 1" readonly> 
			                       	 	
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Employee Name
													
												</label>
												<div class="col-md-7">
						           						 <selectivity  list=employeeList property="payrollgeneration.employeeId" ng-model="payrollgeneration.employeeId" id="employeeId"  name="employeeId" form-name = "payrollgenertaionForm" ></selectivity> 
												 <br><p style="color:red;">Only eligible employees are listed based on the selected Month & Year</p>
												</div>
												
												
											</div>
											
										
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label" >Branch
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
						           						<selectivity  list=branchList property="payrollgeneration.branchId" ng-model="payrollgeneration.branchId" id="branchId"  name="branchId" form-name = "payrollgenertaionForm" validation="required" friendly-name="Branch Name" ng-if="branchList.length > 1"></selectivity>
						           						 <input type="text" class="form-control input-sm" ng-model="payrollgeneration.branchName" message-id="branchId" 
        										data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0 " readonly>     	 	 
			                       	 	
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Month And Year
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													 <selectivity  list=monthYearList property="payrollgeneration.monthYear" ng-model="payrollgeneration.monthYear" id="monthYear"  name="monthYear" form-name = "payrollgenertaionForm" 
	        													validation="required" friendly-name="Month Year"></selectivity>
													</div>
												
											</div>
											<div class="form-group">
											
										</div>
											
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
												</label>
												<div class="col-md-7">
						           					 <selectivity  list=departmentList property="payrollgeneration.departmentId" ng-model="payrollgeneration.departmentId" id="departmentId"  name="departmentId" form-name = "payrollgenertaionForm"></selectivity> 
												</div>
											</div>
											
										
								</div>
										
									</div>
									<div class="row">
										<label class="col-md-4 control-label">
												</label>
										<div class="col-md-5">
											<button class="btn btn-success" type="button" data-ng-click="save(payrollgenertaionForm)"
												class="btn btn-success" >
												Generate
											</button>
											<button class="btn btn-primary" type="button" data-ng-click=""
												class="btn btn-primary" >
												Payroll to JV
											</button>
											<button class="btn btn-primary" type="button" data-ng-click=""
												class="btn btn-primary" >
												Payroll to Payment
											</button>
											<button class="btn btn-primary" type="button" data-ng-click=""
												class="btn btn-primary" >
												Advise to Bank
											</button>											
										</div>
									</div>
								</div>
							
							
						       
								<div class="row" data-ng-if="payrollgeneration.isGenerate" >
									<div class="col-sm-12 col-md-12 col-lg-12 panel-body" style="font-size: 20px;color: blue">
									<!-- <label ng-if="!payrollgeneration.isExists" > <b>For the following employees don't have their pay component entries. Please create pay component entries then generate salary.
									</b></label> -->
									<label ng-if="payrollgeneration.isExists" > <b>Payroll is already generated for the following employees
									</b></label>
								</div>	
								</div>
								</form>
							<div data-ng-if="payrollgeneration.isGenerate">	
							<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection1" data-ng-if="payrollgeneration.isGenerate">
							<div class="dt-toolbar">
		      						 <%@include file="/views/layout/toolbar-header.tpl.jsp"%>		       
		       				</div>
						    
						     <!--    <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
						        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
						         <thead class="dataTables-Main-Head">
						          <tr>
						           <th st-sort="employeeId">EmployeeId</th>
						           <th st-sort="firstName">EmployeeName</th>
						         
						         </tr>
						    	</thead>
								<tbody class="dataTables-Main-Body">
						          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="empPayComList in displayedCollection">
						         	<td>{{empPayComList.employeeId}}</td>
						           	<!-- <td ng-if="!payrollgeneration.isExists">{{empPayComList.firstName}}</td> -->
						           	<td ng-if="payrollgeneration.isExists">{{empPayComList.employeeName}}</td>
						           	
									</tr>
						         </tbody>
												         
						        </table>
						        <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
						       </div>
						       
						       <div class="col-sm-12 col-md-12 col-lg-12 panel-body" style="font-size: 20px;color: blue">
									<label  > <b>For the following employees don't have their payroll flag.
									</b></label>
								</div>	
								
								<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection2">
							<div class="dt-toolbar">
		      						 <%@include file="/views/layout/toolbar-header.tpl.jsp"%>		       
		       				</div>
						    
						     <!--    <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
						        <table id="dt_basic2" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
						         <thead class="dataTables-Main-Head">
						          <tr>
						           <th st-sort="employeeId">Employee Id</th>
						           <th st-sort="firstName">Employee Name</th>
						         
						         </tr>
						    	</thead>
								<tbody class="dataTables-Main-Body">
						          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="empPayComList2 in displayedCollection">
						         	<td>{{empPayComList2.employeeId}}</td>
						           	<td>{{empPayComList2.firstName}}</td>
						           	
									</tr>
						         </tbody>
												         
						        </table>
						        <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
						       </div>
							</div>
							<div class="row" data-ng-if="payrollgeneration.isGenerate1" >
									<div class="col-sm-12 col-md-12 col-lg-12 panel-body" style="font-size: 20px;color: blue">
									<label ng-if="payrollgeneration.isnonExists" > <b>For the following employees don't have their pay component entries. Please create pay component entries then generate salary.
									</b></label>
									<!-- <label ng-if="payrollgeneration.isExists" > <b>Payroll is already generated for the following employees
									</b></label> -->
								</div>	
								</div>
							<div data-ng-if="payrollgeneration.isGenerate1">	
							<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection" data-ng-if="payrollgeneration.isGenerate">
							<div class="dt-toolbar">
		      						 <%@include file="/views/layout/toolbar-header.tpl.jsp"%>		       
		       				</div>
						    
						     <!--    <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
						        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
						         <thead class="dataTables-Main-Head">
						          <tr>
						           <th st-sort="employeeId">EmployeeId</th>
						           <th st-sort="firstName">EmployeeName</th>
						         
						         </tr>
						    	</thead>
								<tbody class="dataTables-Main-Body">
						          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="empPayComList in displayedCollection">
						         	<td>{{empPayComList.employeeId}}</td>
						           	<td ng-if="payrollgeneration.isnonExists">{{empPayComList.firstName}}</td>
						           	<!-- <td ng-if="payrollgeneration.isExists">{{empPayComList.employeeName}}</td> -->
						           	
									</tr>
						         </tbody>
												         
						        </table>
						        <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
						       </div>
						       
							</div>
							</div>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div> --%>


	</div>





