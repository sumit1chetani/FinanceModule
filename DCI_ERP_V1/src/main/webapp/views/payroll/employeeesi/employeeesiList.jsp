

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

	<div class="panel panel-default panel-default-list" st-persist="empESITable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<br>
			  <form class="form-horizontal" name="employeesiform" role="form" > 
     	<div class="row">
     	<div class="col-sm-12 col-md-12 col-lg-12 ">
				<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label class="col-md-5 control-label" > Organization
						</label>
						<div class="col-md-5">
						<!--  <select  class="form-control journalVoucher-textBox" ng-model="esiGeneration.companyId" ng-options="master.companyId as master.companyName for master in companyList"
							 ng-change="getBranchList(esiGeneration.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" ng-if="!isAuthorized" data-valid-method="submit" disabled>
							 <option value=""> --Select--</option>
								 </select>
								 
								  <select  class="form-control journalVoucher-textBox" ng-model="esiGeneration.companyId" ng-options="master.companyId as master.companyName for master in companyList"
							 ng-change="getBranchList(esiGeneration.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" ng-if="isAuthorized" data-valid-method="submit" >
							 <option value=""> --Select--</option>
								 </select> -->
								 
								<!--  <selectivity  list=companyList property="esiGeneration.companyId" ng-model="esiGeneration.companyId"
								 								id="companyId"  name="companyId" form-name = "employeesiform" 
	        												validation="required" friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
				        		
				        		<input type="text" class="form-control input-sm" ng-model="esiGeneration.companyName" message-id="companyId" 
        						data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="companyList.length == 1" readonly> 
						 -->
						 <selectivity list="companyList"
										property="esiGeneration.companyId" id="companyId"
										object="companyId"></selectivity></div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Branch
						</label>
						<div class="col-md-5">
						<!-- <select  class="form-control journalVoucher-textBox" ng-model="esiGeneration.branchId" ng-options="master.branchId as master.branchName for master in branchList"
														  ng-change="getDepartment(esiGeneration.branchId)"   name="Branch Id" data-validator="required" data-message-id="branchId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
							<selectivity  list=branchList property="esiGeneration.branchId" ng-model="esiGeneration.branchId" id="branchId"  name="branchId" form-name = "employeesiform" validation="required" friendly-name="Branch Name" ng-if="branchList.length > 1"></selectivity>
						           						
						           						 <input type="text" class="form-control input-sm" ng-model="esiGeneration.branchName" message-id="branchId" 
        										data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0" readonly>     	 	 
			        	</div>
					</div>
										
					</div>
			
			
			<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
					<label class="col-md-5 control-label" > Department
					</label>
					<div class="col-md-5">
					<!-- <select  class="form-control journalVoucher-textBox" ng-model="esiGeneration.departmentId" ng-options="master.departmentId as master.departmentName for master in departmentList"
				 		name="Department Name" ng-change="getEmployeeList(esiGeneration.departmentId)"  data-validator="required" data-message-id="departmentId" data-valid-method="submit">
											        <option value=""> --Select--</option>
						</select> -->
						 <selectivity  list=departmentList property="esiGeneration.departmentId" ng-model="esiGeneration.departmentId" id="departmentId"  name="departmentId" form-name = "employeesiform"></selectivity>
					</div>
					</div>
										<div class="form-group">
												<label class="col-md-5 control-label">Month And Year
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
													<!-- <select  class="form-control journalVoucher-textBox"ng-model="esiGeneration.monthYear" ng-options="master.monthYear as master.monthValue for master in monthYearList"
														  name="Employee No" data-validator="required" data-message-id="monthYear" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
													        <selectivity  list=monthYearList property="esiGeneration.monthYear" ng-model="esiGeneration.monthYear" id="monthYear"  name="monthYear" form-name = "employeesiform" 
	        													validation="required" friendly-name="Month Year"></selectivity>
												</div>
										</div>
		
				</div>
			
					<div class="form-group">
						<div class="row">
									<label class="col-md-5 control-label" >
									</label>
									<div class="col-md-5" >
										<button class="btn btn-success" type="button" data-ng-click="submit(employeesiform)">
												Submit
										</button>
									</div>	
									</div>		
						</div>
				</div>
			
			</div>
					
			</form>
		 <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
		   
		     <%--  <div class="dt-toolbar">
		       <%@include file="/views/layout/toolbar-header.tpl.jsp"%>		       
		       </div> --%>
		       
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		          <tr>
		           <th class="sorting width_15" st-sort="employeeId">Employee Id</th>
		           <th class="sorting width_15" st-sort="employeeName">Employee Name</th>
		           <th class="sorting width_15" st-sort="days">No of Days for which wages paid/payable during the month</th>
		             <th class="sorting width_15" st-sort="wages">Total Monthly Wages</th>
		        	</tr>
		          <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="esiGeneration in displayedCollection">
           
			<td>{{esiGeneration.employeeId}}</td>
			<td>{{esiGeneration.employeeName}}</td>
			<td>{{esiGeneration.days}}</td>
			<td>{{esiGeneration.wages}}</td>
			
		  </tr>
         </tbody>
		        </table>
		   </div>
		        <div class="form-actions">
					<div class="row">
							<div class="col-md-12">
							
						<!-- 	
								<button class="btn btn-success" class="btn btn-success" type="button"  data-ng-show="esiGeneration.Show"   ng-click="exportXl(esiGeneration.monthYear)">
									  <i class="fa fa-save"></i>
									       Export
						        </button> -->
						        
						        
						        	<button class="btn btn-primary" type="button" data-ng-click="exportXl(esiGeneration.monthYear)"   data-ng-show="esiGeneration.Show">
								        <span class="fa fa-file-excel-o"></span> Export Excel
								         <a id="Export" stype="display:none"
											href="filePath/Employeeesi.xls" download="employeeesi.xls"></a>																						
								       </button>
								
										<div id="btnRowDivId"> </div>
								</div>
					</div>
			 </div>
	       </div>
	      </div>
     </div>
   </article>
  </div>
 </section>
</div>