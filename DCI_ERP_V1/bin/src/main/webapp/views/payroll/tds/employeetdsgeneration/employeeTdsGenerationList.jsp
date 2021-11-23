<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div id="content">
 <!-- widget grid -->
 <section widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div jarvis-widget id="standard-datatable-widget" data-widget-color="sttropaz" data-widget-editbutton="false" data-widget-deletebutton="false">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
      <span><state-breadcrumbs></state-breadcrumbs>  </span>
     </header>
     	<div role="content">
      <div class="widget-body"> 
      <form class="form-horizontal" name="reimbursememtReqAddForm" role="form" > 
     	<div class="row">
     	<fieldset>
     	<div class="col-sm-12 col-md-12 col-lg-12 ">
				<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label class="col-md-5 control-label" > Company
							<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						 <select  class="form-control journalVoucher-textBox" ng-model="tdsGeneration.companyId" ng-options="master.companyId as master.companyName for master in companyList"
							 ng-change="getBranchList(tdsGeneration.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" ng-if="!isAuthorized" data-valid-method="submit" disabled>
							 <option value=""> --Select--</option>
								 </select>
								 
								  <select  class="form-control journalVoucher-textBox" ng-model="tdsGeneration.companyId" ng-options="master.companyId as master.companyName for master in companyList"
							 ng-change="getBranchList(tdsGeneration.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" ng-if="isAuthorized" data-valid-method="submit" >
							 <option value=""> --Select--</option>
								 </select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Branch
							<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<select  class="form-control journalVoucher-textBox" ng-model="tdsGeneration.branchId" ng-options="master.branchId as master.branchName for master in branchList"
														  ng-change="getDepartment(tdsGeneration.branchId)"   name="Branch Id" data-validator="required" data-message-id="branchId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select>
			                       	 	
						</div>
					</div>
										<div class="form-group">
												<label class="col-md-5 control-label">Month And Year
													<span style="color: red;">*</span>	 
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
												
												<select  class="form-control journalVoucher-textBox"ng-model="tdsGeneration.monthYear" ng-options="master.monthYear as master.monthValue for master in monthYearList"
														  name="Employee No" data-validator="required" data-message-id="monthYear" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select>
												
												</div>
												
											</div>
					</div>
			
			
			<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
					<label class="col-md-5 control-label" > Department
					</label>
					<div class="col-md-5">
					<select  class="form-control journalVoucher-textBox" ng-model="tdsGeneration.departmentId" ng-options="master.departmentId as master.departmentName for master in departmentList"
				 		name="Department Name" ng-change="getEmployeeList(tdsGeneration.departmentId)"  data-validator="required" data-message-id="departmentId" data-valid-method="submit">
											        <option value=""> --Select--</option>
						</select>
					</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Employee Name
						</label>
						<div class="col-md-5">
								<select  class="form-control journalVoucher-textBox" ng-model="tdsGeneration.employeeId" ng-options="master.employeeId as master.employeeName for master in employeeList"
						    ng-change="getEmployeeId(tdsGeneration.employeeId)"  name="Employee No" data-validator="required" data-message-id="employeeId" data-valid-method="submit" >
							<option value=""> --Select--</option>
							</select>												        
						</div>
						</div>
			</div>
			</div>
					<div class="form-group">
						<div class="row">
									<label class="col-md-5 control-label" >
						</label>
									<div class="col-md-5">
										<button class="btn btn-success" type="button" data-ng-click="submit()">
												Submit
										</button>
									</div>	
									
						</div>
				</div>
			</fieldset>
			</div>
					
			</form>
							
		</div>
		
		</div>
     
	     <div role="content">
	      <div class="widget-body no-padding">
	       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
		       <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div>
		      
		       <!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		          <tr>
		           <th class="sorting width_15" st-sort="employeeId">Employee Id</th>
		           <th class="sorting width_15" st-sort="employeeName">Employee Name</th>
		           <th class="sorting width_20" st-sort="amount">amount</th>
		          </tr>
		          <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="tdsGeneration in displayedCollection">
           
			<td>{{tdsGeneration.employeeId}}</td>
			<td>{{tdsGeneration.employeeName}}</td>
			<td><input type="number" min="0" ng-model="tdsGeneration.amount"></td>
		
		
          </tr>
         </tbody>
		        </table>
		   
		        <div class="form-actions">
					<div class="row">
							<div class="col-md-12">
								 <security:authorize access="hasRole('F0338_M')">
							
								<button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="add" data-ng-if="tdsGeneration.isEdit" ng-click="updateTdsGenerationList()">
									  <i class="fa fa-save"></i>
									       Update
						        </button>
									</security:authorize>         
								
								</div>
					</div>
			 </div>
	        <!--  <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>  -->
	        </div>
	       </div>
	      </div>
     </div>
   </article>
  </div>
 </section>
</div>