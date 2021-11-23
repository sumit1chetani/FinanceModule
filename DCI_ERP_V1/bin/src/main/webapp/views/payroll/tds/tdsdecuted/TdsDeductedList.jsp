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
							
							<form class="form-horizontal" name="employeeTdsForm" role="form" >
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">
										
											
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization
												<span style="color: red;">*</span>	 
												</label>
												<div class="col-md-7" >
												<selectivity list="companyList" property="employeeTds.companyId" 
										                id="companyId" ng-model="employeeTds.companyId"
										               name="companyId" form-name="employeeTdsForm" ng-if="companyList.length > 1"
										               validation="required" friendly-name="Hospital">
										               </selectivity>
						           						  <!-- <select  class="form-control journalVoucher-textBox" ng-model="employeeTds.companyId" ng-options="master.companyId as master.companyName for master in companyList"
														  ng-change="getBranchList(employeeTds.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" data-valid-method="submit" ng-if="!isAuthorized" disabled>
													        <option value=""> --Select--</option>
													        </select> -->
								                </div>
								                	
								                	<div class="col-md-7" >
												 <input type="text" class="form-control input-sm" ng-model="employeeTds.companyName" message-id="companyId" 
        							 name="Hospital Name" ng-if="companyList.length == 1" readonly>
								               <!-- <select  class="form-control journalVoucher-textBox" ng-model="employeeTds.companyId" ng-options="master.companyId as master.companyName for master in companyList"
														  ng-change="getBranchList(employeeTds.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" data-valid-method="submit" ng-if="isAuthorized" >
													        <option value=""> --Select--</option>
													        </select> -->
			                       	 	
			                       	 	
												</div>
										</div>							
											<div class="form-group">
												<label class="col-md-5 control-label">Month
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
												<selectivity list="monthList" property="employeeTds.month" 
										                id="month" ng-model="employeeTds.month"
										               name="month" form-name="employeeTdsForm"
										               validation="required" friendly-name="Month">
										         </selectivity>
												<!-- <select class="form-control" ng-model="employeeTds.month" data-valid-method="submit">
												<option value=""> --Select--</option>
						           					 <option value="01">January</option>
										   				 <option value="02">February</option>
										   				 <option value="03">March</option>
										   				 <option value="04">April</option>
										   				 <option value="05">May</option>
										   				 <option value="06">June</option>
										   				 <option value="07">July</option>
										   				 <option value="08">August</option>
										   				 <option value="09">September</option>
										   				 <option value="10">October</option>
										   				 <option value="11">November</option>
										   				 <option value="12">December</option>
			                       	 				</select> -->
												</div>
												
											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
												<selectivity list="branchList" property="employeeTds.branchId" 
										                id="branchId" ng-model="employeeTds.branchId"
										               name="branchId" form-name="employeeTdsForm" ng-if="branchList.length > 1"
										               validation="required" friendly-name="Branch">
										         </selectivity>
										         <input type="text" class="form-control input-sm" ng-model="employeeTds.branchName" message-id="branchId" 
        							 name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0" readonly>
						           					<!-- <input type="text" class="form-control"
								              	name="kmc"
								                data-ng-model="employeeTds.companyName" readonly> -->
								               <!--  <select  class="form-control journalVoucher-textBox" ng-model="employeeTds.branchId" ng-options="master.branchId as master.branchName for master in branchList"
														  ng-change="getDepartment(employeeTds.branchId)"   name="Branch Id" data-validator="required" data-message-id="branchId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Year
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
												<selectivity list="yearList" property="employeeTds.year" 
										                id="year" ng-model="employeeTds.year"
										               name="year" form-name="employeeTdsForm"
										               validation="required" friendly-name="Year">
										         </selectivity>
						           					<!-- <select class="form-control" ng-model="employeeTds.year" data-valid-method="submit">
						           					<option value=""> --Select--</option>
										   				 <option value="2015">2015</option>
										   				 <option value="2016">2016</option>
										   				 <option value="2017">2017</option>
										   				 <option value="2018">2018</option>
										   				 <option value="2019">2019</option>
										   				 <option value="2020">2020</option>
													</select> -->
												</div>
											</div>
										
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Department
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
												<selectivity list="departmentList" property="employeeTds.departmentId" 
										                id="departmentId" ng-model="employeeTds.departmentId"
										               name="departmentId" form-name="employeeTdsForm"
										               validation="required" friendly-name="Department">
										         </selectivity>
						           					<!-- <select  class="form-control journalVoucher-textBox" ng-model="employeeTds.departmentId" ng-options="master.departmentId as master.departmentName for master in departmentList"
												    name="Department Name" data-validator="required" data-message-id="departmentId" data-valid-method="submit">
											        <option value=""> --Select--</option>
											    </select> -->
												</div>
											</div>
								       </div>
										<div class="form-group">
											<div class="row">
											
									
											
										<label class="col-md-5 control-label">
													
												</label>
												<div class="col-md-5" style="margin-left: 46%;">
											<button class="btn btn-success" type="button" data-ng-click="getemployeeTds(employeeTdsForm)"
												class="btn btn-success" >
												Show Tds List
											</button>
											</div>
											
										</div>
									</div>
								</div>
									</div>
								</div>
					</form>	
					 <form class="form-horizontal" name="employeeTdsUpdateForm" role="form" >		
		<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
      <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div> 
     
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
          <th st-sort="employeeId">Employee ID</th>
          <th st-sort="employeeName">Employee Name</th>
        	<th st-sort="amount">TDS</th>
       
         </tr>
    	</thead>
           <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="empemployeeTds in displayedCollection">
          
            <td>{{empemployeeTds.employeeId}}</td>
           	<td>{{empemployeeTds.employeeName}}</td>
			<td>{{empemployeeTds.amount}}</td>
		 </tr>
         </tbody>
        </table>
       
     
    <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
       </div>
       <br>
      
        </form>
		</div>
		</div>
						<!-- end widget content -->
				
					<!-- end widget div -->
				
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>


