 <!-- #MAIN CONTENT -->
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
 <%-- <security:authorize access="hasRole('F0335_D')" var="isDelete" />
<security:authorize access="hasRole('F0335_A')" var="isAdd" /> --%>
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
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="<spring:message code="title.widget.reset"></spring:message>"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
     <div role="content">
      <div class="widget-body"> 
      <form class="form-horizontal" name="reimbursememtReqAddForm" role="form" > 
      <div class="row">
     	<fieldset>
     	<div class="col-sm-12 col-md-12 col-lg-12 ">
				<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label class="col-md-5 control-label" > Organization
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="companyList" property="empTaxParam.companyId" 
										                id="companyId" ng-model="empTaxParam.companyId"
										               name="companyId" form-name="reimbursememtReqAddForm" ng-if="companyList.length > 1"
										               validation="required" friendly-name="Hospital">
										               </selectivity>
						 <!-- <select  class="form-control journalVoucher-textBox" ng-model="empTaxParam.companyId" ng-options="master.companyId as master.companyName for master in companyList"
							 ng-change="getBranchChange(empTaxParam.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" data-valid-method="submit" ng-if="!isAuthorized" disabled>
							 <option value=""> --Select--</option>
								 </select> -->
								  <input type="text" class="form-control input-sm" ng-model="empTaxParam.companyName" message-id="companyId" 
        							 name="Hospital Name" ng-if="companyList.length == 1" readonly>
			                       	 	
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Branch
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						 <selectivity list="branchList" property="empTaxParam.branchId" 
										                id="branchId" ng-model="empTaxParam.branchId"
										               name="branchId" form-name="reimbursememtReqAddForm" ng-if="branchList.length > 1"
										               validation="required" friendly-name="Branch">
										         </selectivity>
										         <input type="text" class="form-control input-sm" ng-model="empTaxParam.branchName" message-id="branchId" 
        							 name="Hospital Name" ng-if="branchList.length == 1 || branchList.length == 0" readonly> 
						<!-- <select  class="form-control journalVoucher-textBox" ng-model="empTaxParam.branchId" ng-options="master.branchId as master.branchName for master in branchList"
														  ng-change="getDepartmentChange(empTaxParam.branchId)"   name="Branch Id" data-validator="required" data-message-id="branchId" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->
			                       	 	
						</div>
					</div>
					
					</div>
			
			
			<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
					<label class="col-md-5 control-label" > Department
					<span style="color: red;">*</span>	 
					</label>
					<div class="col-md-5">
					<selectivity list="departmentList" property="empTaxParam.departmentId" 
										                id="departmentId" ng-model="empTaxParam.departmentId"
										         form-name="reimbursememtReqAddForm"      name="departmentId" validation="required" friendly-name="Department Name">
										         </selectivity>
						<!-- <select  class="form-control journalVoucher-textBox" ng-model="empTaxParam.departmentId" ng-options="master.departmentId as master.departmentName for master in departmentList"
				 		name="Department Name" ng-change="getEmployeeChange(empTaxParam.departmentId)"  data-validator="required" data-message-id="departmentId" data-valid-method="submit">
											        <option value=""> --Select--</option>
						</select> -->
					</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Employee
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
						<selectivity list="employeeList" property="empTaxParam.employeeId" 
										                id="employeeId" ng-model="empTaxParam.employeeId"
										            form-name="reimbursememtReqAddForm"   name="employeeId" validation="required" friendly-name="Employee Name">
										         </selectivity>
							<!-- <select  class="form-control journalVoucher-textBox" ng-model="empTaxParam.employeeId" ng-options="master.employeeId as master.employeeName for master in employeeList"
						    ng-change="getEmployeeId(empTaxParam.employeeId)"  name="Employee No" data-validator="required" data-message-id="employeeId" data-valid-method="submit" >
							<option value=""> --Select--</option>
							</select> -->											        
						</div>
						</div>
					
		
			</div>
			</div>
					
			
				<div class="form-group">
						<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12 ">
									<div class="col-md-5"  style="margin-left: 49%;">
										<button class="btn btn-success" type="button" data-ng-click="getList(reimbursememtReqAddForm)"
		class="btn btn-success" >
		Show Employee Tax Parameter	
		</button>
									</div>	
									</div>		
						</div>
				</div>
			</fieldset>
			</div>
		</form>		
       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection" data-ng-if="empTaxParam.isShowList">
        <!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
        
         <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
		       </div>
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
          <tr>
           <th class="sorting width_15" st-sort="employeeId">Employee No</th>
           <th class="sorting width_15" st-sort="gender">Gender</th>
           <th class="sorting width_15" st-sort="taxPayerTypeName">Tax Payer Type</th>
           <th class="sorting width_15" st-sort="phType">PH Type</th>
           <th class="sorting width_15" st-sort="livingInMetro">Is Living In Metro</th>
           <th class="sorting width_15" st-sort="selfOccupiedHouse">Is Self Occupied House</th>
           <th class="sorting width_15" >Action</th>
          </tr>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="employeetaxListCollection in displayedCollection">
			<td>{{employeetaxListCollection.employeeId}}</td>
			<td><span ng-if="employeetaxListCollection.gender== 'F'"><spring:message code="label.female"></spring:message></span>
			<span ng-if="employeetaxListCollection.gender=='M'"><spring:message code="label.male"></spring:message></span></td>
			<td>{{employeetaxListCollection.taxPayerTypeName}}</td>
			<td><span ng-if="employeetaxListCollection.phType == '1'"><spring:message code="label.emptaxparam.normal"></spring:message></span>
                 <span ng-if="employeetaxListCollection.phType == '2'"><spring:message code="label.emptaxparam.phyhand"></spring:message></span>
                 <span ng-if="employeetaxListCollection.phType == '3'"><spring:message code="label.emptaxparam.severe"></spring:message></span></td>
			<td><input type="checkbox" checked="checked" ng-model="employeetaxListCollection.livingInMetro" disabled="disabled"></td>
			<td><input type="checkbox" checked="checked" ng-model="employeetaxListCollection.selfOccupiedHouse" disabled="disabled"></td>
		
		 <td class=" td-actions text-center">
        <span>
        <security:authorize access="hasRole('${form_code}_${modify}')">   
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(employeetaxListCollection.employeeId)"></i>
         </security:authorize>
        </span>
        <span>
       <security:authorize access="hasRole('${form_code}_${delete}')">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(employeetaxListCollection.employeeId)"></i>
         </security:authorize>
        </span>
       </td>
          </tr>
         </tbody>
        </table>
        <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
       </div>
      </div>
    
    <!-- end widget -->
    
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
