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
     
     	<div class="col-sm-12 col-md-12 col-lg-12 ">
				<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label class="col-md-5 control-label" > Organization
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="companyList" property="otherincomeList.companyId" 
										                id="companyId" ng-model="otherincomeList.companyId"
										               name="companyId" form-name="reimbursememtReqAddForm" ng-if="companyList.length > 1"
										               validation="required" friendly-name="Hospital">
										               </selectivity>
					
							</div>
							<div class="col-md-5" >	 
							<input type="text" class="form-control input-sm" ng-model="otherincomeList.companyName" message-id="companyName" 
        							 name="Hospital Name" ng-if="companyList.length == 1" readonly>
						
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Branch
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="branchList" property="otherincomeList.branchId" 
										                id="branchId" ng-model="otherincomeList.branchId"
										               name="branchId" form-name="reimbursememtReqAddForm" ng-if="branchList.length > 1"
										               validation="required" friendly-name="Branch">
										         </selectivity>
						
													        <input type="text" class="form-control input-sm" ng-model="otherincomeList.branchName" message-id="branchName" 
        							 name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0" readonly>
			                       	 	
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Financial Year
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="financialYearList" property="otherincomeList.financialYearId" 
										                id="financialYear" ng-model="otherincomeList.financialYearId" data-ng-if="!nscinterest.isEdit"
										               name="financialYear" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="Financial Year">
										         </selectivity>
					
					<selectivity list="financialYearList" property="otherincomeList.financialYearId" 
										                id="financialYear" ng-model="otherincomeList.financialYearId" data-ng-if="nscinterest.isEdit"
										               name="financialYear" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="Financial Year">
										         </selectivity>
			
			                       	 	
						</div>
					</div>
					</div>
			
			
			<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
					<label class="col-md-5 control-label" > Department
					<span style="color: red;">*</span>	 
					</label>
					<div class="col-md-5">
					<selectivity list="departmentList" property="otherincomeList.departmentId" 
										                id="departmentId" ng-model="otherincomeList.departmentId"
										               name="departmentId" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="Department">
										         </selectivity>
										         
				
					</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Employee Name
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="employeeList" property="otherincomeList.employeeId" 
										                id="employeeId" ng-model="otherincomeList.employeeId"
										               name="employeeId" form-name="reimbursememtReqAddForm"
										               validation="required" friendly-name="Employee Name">
										         </selectivity>
						</div>
						</div>
					
		
			</div>
			
					<div class="form-group">
						<div class="row">
									<label class="col-md-5 control-label" >
									</label>	 
									<div class="col-md-5">
										<button class="btn btn-success" type="button" data-ng-click="submit(reimbursememtReqAddForm)">
												Submit
										</button>
									</div>	
									
						</div>
				</div>
			
			</div>
					</div>	
			</form>
							
	
	       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
		       <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div>
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <th class="sorting width_15" st-sort="otherIncomeHeadId">Other Income Head Id</th>
		           <th class="sorting width_15" st-sort="otherIncomeHeadName">Other Income Head Name</th>
		           <th class="sorting width_20" st-sort="amount">Amount</th>
		           
		          </tr>
		         </thead>
		          <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="otherincomeList in displayedCollection">
           
			<td>{{otherincomeList.otherIncomeHeadId}}</td>
			<td>{{otherincomeList.otherIncomeHeadName}}</td>
			<td><input type="text" ng-pattern-restrict="^[0-9-]*$" ng-model="otherincomeList.amount"></td>
		
			
		
          </tr>
         </tbody>
		        </table>
		  <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div> 
      									 </div>
		        <div class="form-actions">
					<div class="row">
							<div class="col-md-12">
								
								<button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="add" data-ng-if="otherincomeList.isEdit" ng-click="update()">
									  <i class="fa fa-save"></i>
									       Update
						        </button>
									  
								
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