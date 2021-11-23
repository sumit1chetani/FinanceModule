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
      <form class="form-horizontal" name=empTdsDeclarationForm role="form" > 
     	<div class="row">
     	<div class="col-sm-12 col-md-12 col-lg-12 ">
				<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label class="col-md-5 control-label" > Organization
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="companyList" property="tdsDeclarationList.companyId" 
										                id="companyId" ng-model="tdsDeclarationList.companyId"
										               name="companyId" form-name="empTdsDeclarationForm" ng-if="companyList.length > 1"
										               validation="required" friendly-name="Hospital">
										               </selectivity>
						
								 </div>
								<div class="col-md-5">
							<input type="text" class="form-control input-sm" ng-model="tdsDeclarationList.companyName" message-id="companyId" 
        							 name="Hospital Name" ng-if="companyList.length == 1" readonly>
								
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Branch
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="branchList" property="tdsDeclarationList.branchId" 
										                id="branchId" ng-model="tdsDeclarationList.branchId"
										               name="branchId" form-name="empTdsDeclarationForm" ng-if="branchList.length > 1"
										               validation="required" friendly-name="Branch">
										         </selectivity>
										         <input type="text" class="form-control input-sm" ng-model="tdsDeclarationList.branchName" message-id="branchId" 
        							 name="Branch Name" ng-if="branchList.length == 1 || branchList.length == 0" readonly> 
						
			                       	 	
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Financial Year
						<span style="color: red;">*</span>	 
						</label>
						
					<div class="col-md-5" > 
					<selectivity  list=financialYearList property="tdsDeclarationList.financialYear" ng-model="tdsDeclarationList.financialYear"
								 id="financialYear"  name="financialYear" form-name = "empTdsDeclarationForm"
	        							validation="required" friendly-name="Financial Year"></selectivity> 
					</div>
					</div>
					</div>
			
			
			<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
					<label class="col-md-5 control-label" > Department
					<span style="color: red;">*</span>	 
					</label>
					<div class="col-md-5">
					<selectivity list="departmentList" property="tdsDeclarationList.departmentId" 
										                id="departmentId" ng-model="tdsDeclarationList.departmentId"
										               name="departmentId" form-name="empTdsDeclarationForm"
										               validation="required" friendly-name="Department">
										         </selectivity>
										        
				
					</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Employee Name
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="employeeList" property="tdsDeclarationList.employeeId" 
										                id="employeeId" ng-model="tdsDeclarationList.employeeId"
										               name="employeeId" form-name="empTdsDeclarationForm"
										               validation="required" friendly-name="Employee Name">
										         </selectivity>
															        
						</div>
						</div>
						
						<div class="form-group">
						<label class="col-md-5 control-label" > Tax Section Code
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="taxsectionList" property="tdsDeclarationList.taxSectionCode" 
										                id="taxSectionCode" ng-model="tdsDeclarationList.taxSectionCode"
										               name="taxSectionCode" form-name="empTdsDeclarationForm"
										               validation="required" friendly-name="Tax Section Code">
										         </selectivity>
							
							</select>												        
						</div>
						</div>
					
		
			</div>
								<div class="form-group">
											<div class="row">
												<label class="col-md-5 control-label">
													
												</label>
												<div class="col-md-5" style="margin-left: 46%;">
											<button class="btn btn-success" type="button" data-ng-click="getTDSDeclarationList(empTdsDeclarationForm)">
											
												Show
											</button>
											
											
										
										</div>
									</div>
								</div>
					<!-- div class="form-group">
						<div class="row">
									<label class="col-md-5 control-label" >
								</label>
									<div class="col-md-5">
										<button class="btn btn-success" type="button" data-ng-click="getTDSDeclarationList(empTdsDeclarationForm)">
												Submit
										</button>
									</div>	
									
						</div>
				</div> -->
				</div>
			</div>
					
			</form>
							
		
	       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
		     <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div>
		    
		      <!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         
		          <tr>
		           <th class="sorting width_10" st-sort="taxSectionCode">Tax Section Name</th>
		           <th class="sorting width_10" st-sort="taxSubSectionCode">Tax Sub Section Name</th>
		           <th class="sorting width_15" st-sort="taxSubSectionDescription">Tax SubSection Description</th>
		            <th class="sorting width_10" st-sort="actualAmount">Actual Amount</th>
		           <th class="sorting width_10" st-sort="limited">Limited</th>
		          <th class="sorting width_20" st-sort="">Action</th> 
		          </tr>
		         
		          <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-controller="parentCtrl" ng-repeat="tdsDeclarationList in displayedCollection">
           
			<td>{{tdsDeclarationList.taxSectionCode}}</td>
			<td>{{tdsDeclarationList.taxSubSectionCode}}</td>
			<td>{{tdsDeclarationList.taxSubSectionDescription}}</td>
			<td><input type="number" min="0" ng-model="tdsDeclarationList.actualAmount" ng-keyup="validateActualAmount(tdsDeclarationList.actualAmount,tdsDeclarationList.limited,$index);"></td>
			<td>{{tdsDeclarationList.limited}}</td>
			
		 <td class=" td-actions text-center">
		 <input type="file" name="filepathUrl" ng-model="tdsDeclarationList.filepathUrl" class="form-control" onchange="angular.element(this).scope().uploadDocFile(this)"
           			  accept=".docx,.xls,.png,.jpg,.pdf" style=" width: 50%; margin-right:50%"/> <br> 
		 	<security:authorize access="hasRole('${form_code}_${upload}')"> <button class="btn btn-success" type="button" ng-click="uploadDocument(tdsDeclarationList.taxSubSectionCode,tdsDeclarationList.taxSectionCode)" style=" margin-left:31%; margin-top:-17%; ">
											  <i ></i>
											     Upload
						  </button></security:authorize>
	 	</td> 
          </tr>
         </tbody>
		        </table>
		     <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div> 
		     </div>
		     <br>
		        <div class="form-actions">
					<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="add" ng-click="updateTdsActualList()">
									
									 
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