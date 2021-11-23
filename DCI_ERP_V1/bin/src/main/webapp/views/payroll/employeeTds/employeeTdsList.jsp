

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-persist="empTDsTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
  <div class="panel-body float-left padding-0" style="width: 100%;">
  <br>
  <form class="form-horizontal" name="employeeTdsForm" role="form" >
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization
												<span style="color: red;">*</span>	 
												</label>
												<div class="col-md-5">
						           						<!-- 	<selectivity  list=companyList property="employeeTds.companyId" ng-model="employeeTds.companyId" id="companyId"  name="companyId" form-name = "employeeTdsForm" 
	        													validation="required" friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
				        							
				     											<input type="text" class="form-control input-sm" ng-model="employeeTds.companyName" message-id="companyId" 
        															data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="companyList.length == 1" readonly> 
			                       	 	 -->
			                       	 	  <selectivity list="companyList"
										property="employeeTds.companyId" id="companyId"
										object="companyId"></selectivity>
												</div>
										</div>							
											<div class="form-group">
												<label class="col-md-5 control-label">Month and Year
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
														  <selectivity  list=monthYearList property="employeeTds.monthYear" ng-model="employeeTds.monthYear" id="monthYear"  name="monthYear" form-name = "employeeTdsForm" 
	        													validation="required" friendly-name="Month Year"></selectivity>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           				  <selectivity  list=branchList property="employeeTds.branchId" ng-model="employeeTds.branchId" id="branchId"  name="branchId" form-name = "employeeTdsForm"
	        													validation="required" friendly-name="Branch Name" ng-if="branchList.length > 1"></selectivity> 
	        									
	        										 <input type="text" class="form-control input-sm" ng-model="employeeTds.branchName" message-id="branchId" 
        												data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0 " readonly>     	 	 
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
												</label>
												<div class="col-md-5">
						           					<selectivity  list=departmentList property="employeeTds.departmentId" ng-model="employeeTds.departmentId" id="departmentId"  name="departmentId" form-name = "employeeTdsForm"></selectivity> 
											    
												</div>
											</div>
										</div>
										
										<div class="form-group">
											<div class="row">
												<label class="col-md-5 control-label">
													
												</label>
												<div class="col-md-5">
											<button class="btn btn-success" type="button" data-ng-click="getemployeeTds(employeeTdsForm)"
												class="btn btn-success" >
												Show List
											</button>
										<!-- 	<button class="btn btn-success" type="button" data-ng-click="exportExcel(employeeTdsForm)"
												class="btn btn-success" >
												Export
											</button> -->
											<button class="btn btn-primary" type="button" data-ng-click="exportExcel(employeeTdsForm)"  >
								        <span class="fa fa-file-excel-o"></span> Export Excel
								         <a id="Export" stype="display:none"
											href="filePath/EmployeeTds.xls" download="EmployeeTds.xls"></a>																						
								       </button>
											
											
											
											
											<button class="btn btn-success" type="button" data-ng-click="fileUpload()"
												class="btn btn-success" >
												Import
											</button>
											
										<div id="btnRowDivId"> </div>
										</div>
									</div>
								</div>
									</div>
								</div>
					</form>	
  
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead class="dataTables-Main-Head">
          <tr >
          <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
                <th class="sorting width_20" st-sort="employeeId">Employee ID</th>
          <th class="sorting width_20" st-sort="employeeName">Employee Name</th>
          <th class="sorting width_20" st-sort="monthYear">Month Year</th>
           <th class="sorting width_20" st-sort="estimatedTds">Estimated Tds</th>
            <th class="sorting width_20" st-sort="actualTds">Actual Tds</th>
          </tr>
         </thead>
        <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="empemployeeTds in displayedCollection">
          	<td>{{empemployeeTds.employeeId}}</td>
           	<td>{{empemployeeTds.employeeName}}</td>
			<td>{{empemployeeTds.monthYear}}</td>
			<td><input type="text" ng-pattern-restrict="^[0-9.]*$"  maxlength="7" ng-model="empemployeeTds.estimatedTds"></td>
			<td><input type="text" ng-pattern-restrict="^[0-9.]*$"  maxlength="7"  ng-model="empemployeeTds.actualTds"></td>
		 </tr>
         </tbody>
    </table>
     <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
          <br>
         <div class="form-actions">
											<div class="row">
									
												<div class="col-md-12">
											<button class="btn btn-success" type="button" data-ng-click="updateemployeeTds()"
												class="btn btn-success" >
												Post it
											</button>
											
										</div>
									</div>
								</div>
  </div>
  <!-- end widget content -->
 </div>
</div> 


<script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
	<a href="assets/docs/Sample_Employee_Tds_Upload_File.xlsx" class="control-label">Download sample excel file</a>	
   <button class="btn btn-info" type="button" ng-click="uploadTds()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>