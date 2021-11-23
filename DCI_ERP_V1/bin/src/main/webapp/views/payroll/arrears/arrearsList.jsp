<!-- #MAIN CONTENT -->
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%-- <security:authorize access="hasRole('F0299_UP')" var="isUpload" /> --%>
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
							
							<form class="form-horizontal" name="arrearsForm" role="form" >
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										
											
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization
												<span style="color: red;"></span>	 
												</label>
												<div class="col-md-5">
						           						<selectivity  list=companyList property="arrears.companyId" ng-model="arrears.companyId"
								 								id="companyId"  name="companyId" form-name = "arrearsForm" 
	        												validation="required" friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
				        							
				     											<input type="text" class="form-control input-sm" ng-model="arrears.companyName" message-id="companyId" 
        															data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="companyList.length == 1" readonly> 
			                       	 			
												</div>
										</div>							
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
												</label>
												<div class="col-md-5">
						           				<selectivity  list=departmentList property="arrears.departmentId" ng-model="arrears.departmentId" id="departmentId"  name="departmentId" form-name = "arrearsForm" ></selectivity> 
											  	</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-6">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch
													 <span style="color: red;"></span>
												</label>
												<div class="col-md-5">
						           					<selectivity  list=branchList property="arrears.branchId" ng-model="arrears.branchId" id="branchId"  name="branchId" form-name = "arrearsForm"
	        												validation="required" friendly-name="Branch Name" ng-if="branchList.length > 1" ></selectivity> 
													       
													        <input type="text" class="form-control input-sm" ng-model="arrears.branchName" message-id="branchId" 
        										data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0 " readonly>     	 	 
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Month And Year
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
						           					<selectivity  list=monthYearList property="loplist.monthYear" ng-model="loplist.monthYear" id="monthYear"  name="monthYear" form-name = "arrearsForm" 
	        													validation="required" friendly-name="Month Year"></selectivity>
												</div>
											</div>
										
										</div>
									
										<div class="form-group">
											<div class="row">
											<label class="col-md-5 control-label">
												</label>
												<div class="col-md-5">
											<button class="btn btn-success" type="button" data-ng-click="getarrears(arrearsForm)"
												class="btn btn-success">Show List</button>
											<security:authorize access="hasRole('${form_code}_${export}')"> <button class="btn btn-success" type="button" data-ng-click="exportExcel(arrearsForm)"
												class="btn btn-success">
												Export
											</button></security:authorize>
											<button class="btn btn-success" type="button" data-ng-click="fileUpload()"
												class="btn btn-success" >
												Import
											</button>
												<button class="btn btn-success" type="button" data-ng-click="updatePayComponent()"
												class="btn btn-success" >
												Post
											</button>
											<div id="btnRowDivId"> </div>
										</div>
										</div>
									</div>
								</div>
									</div>
								
					</form>	
					 	
		<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
        <!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
      <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div>
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
          <th class="sorting width_15" st-sort="employeeId">Employee ID</th>
          <th class="sorting width_15" st-sort="employeeName">Employee Name</th>
           <th class="sorting width_15" st-sort="monthYear">Month Year</th>
         
           <th class="sorting width_15" st-sort="charges">Amount</th>
           
         </tr>
    	</thead>
           <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="emparrears in displayedCollection">
          
            <td>{{emparrears.employeeId}}</td>
           	<td>{{emparrears.employeeName}}</td>
           	<td>{{emparrears.monthYear}}</td>
			<td><input type="text"  ng-model="emparrears.amount" ></td>
			
		 </tr>
         </tbody>
        </table>
            <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div> 
        </div>
        <br><div class="form-actions">
       								<div class="row">
										
												<div class="col-md-12">
											<button data-ng-if="arrears.isEdit" class="btn btn-success" type="button" data-ng-click="updatearrears()"
												class="btn btn-success" >
												Update
											</button>
											</div>
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
	<a href="tempdoc/Sample_Employee_Arrear_Salary_File.xlsx" class="control-label">Download sample excel file</a>	
   <button class="btn btn-info" type="button" ng-click="uploadArrearCharge()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>
