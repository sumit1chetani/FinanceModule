<!-- #MAIN CONTENT -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="content">
 <!-- widget grid -->
 <section data-widget-grid id="widget-grid">
  <div class="row">
   <article class="col-sm-12">
    <div data-jarvis-widget id="standard-datatable-widget">
     <header>
      <span class="widget-icon">
       <i class="fa fa-table"></i>
      </span>
       <span><state-breadcrumbs></state-breadcrumbs>  </span>
       <div class="widget-toolbar">
            <!-- add: non-hidden - to disable auto hide -->
            <div>
				<span>
					<span class="button-icon" data-reset-widgets rel="tooltip" title="reset"
                          data-placement="bottom"
                          >
						<i class="fa fa-refresh"></i>
					</span>
				</span>
            </div>
        </div>
     </header>
<div class="row">
        <div class="form-actions">
         <button class="btn btn-success" type="submit" data-ng-click="showEmployeeReportList(EmployeeMasterData)"
          class="btn btn-success">Generate
        <%--   <spring:message code="label.availing.leave.generate"></spring:message> --%>
         </button>
                <!-- <label>Employee Id</label>
       <input type='checkbox' id="empId" ng-model="emp.empId" ng-change="empIdchange(emp.empId)"> -->
         
		</div><br><br><input type="hidden" value="${form_code}" id="formCode" />
		<div class="form-group" style=" margin-top: -30px; ">
		<label>Employee Id</label>
       <input type='checkbox' id="empId" ng-model="emp.empId" ng-change="empIdchange(emp.empId)">
       </div>
       <div class="form-group" style=" margin-top:-36px; margin-left: 8%; ">
       <label>DOJ</label>
       <input type='checkbox' id="doj" ng-model="emp.doj" ng-change="dojchange(emp.doj)">
       </div>
       
       <div class="form-group" style=" margin-top:-36px; margin-left: 12%; ">
       <label>Gross Salary</label>
       <input type='checkbox' id="fixedGross" ng-model="emp.fixedGross" ng-change="fixedGrosschange(emp.fixedGross)">
       </div>
       
       <div class="form-group" style=" margin-top:-36px; margin-left: 20%; ">
       <label>Marital Status</label>
       <input type='checkbox' id="maritalStatus" ng-model="emp.marriedStatus" ng-change="maritalStatuschange(emp.marriedStatus)">
       </div>
       
       <div class="form-group" style=" margin-top:-36px; margin-left: 28%; ">
       <label>Mother Tongue</label>
       <input type='checkbox' id="motherTongue" ng-model="emp.motherTongue" ng-change="motherTonguechange(emp.motherTongue)">
       </div>
       
       <div class="form-group" style=" margin-top:-36px; margin-left: 37%; ">
       <label>Nationality</label>
       <input type='checkbox' id="nationality" ng-model="emp.nationality" ng-change="nationalitychange(emp.nationality)">
       </div>
       
       <div class="form-group" style=" margin-top:-36px; margin-left: 44%; ">
       <label>Language Known</label>
       <input type='checkbox' id="languages" ng-model="emp.languages" ng-change="languageschange(emp.languages)">
       </div>
       
       <div class="form-group" style=" margin-top:-36px; margin-left: 54%; ">
       <label>Grade</label>
       <input type='checkbox' id="languages" ng-model="emp.gradeName" ng-change="gradechange(emp.gradeName)">
       </div>
       
       <div class="form-group" style=" margin-top:-36px; margin-left: 59%; ">
       <label>Bank Name</label>
       <input type='checkbox' id="languages" ng-model="emp.bankName" ng-change="bankNamechange(emp.bankName)">
       </div>
       
       <div class="form-group" style=" margin-top:-36px; margin-left: 66%; ">
       <label>Telephone Limit(Monthly)</label>
       <input type='checkbox' id="languages" ng-model="emp.telephoneLimit" ng-change="telephoneLimitchange(emp.telephoneLimit)">
       </div>
       
       <div class="form-group" style=" margin-top:-36px; margin-left: 80%; ">
       <label>Medical Limit(Annual)</label>
       <input type='checkbox' id="languages" ng-model="emp.medicalLimit" ng-change="medicalLimitchange(emp.medicalLimit)">
       </div>
                     
       </div>
       

					<div role="content">
						<div class="widget-body no-padding">
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								data-st-table="displayedCollection" 
								data-st-safe-src=rowCollection>
								<!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th class=" width_10" st-sort="" ng-show="empID">Employee Id</th>
											<th class="width_12" st-sort="">Employee Name</th>
											<th class="width_15" st-sort="">Hospital Name</th>
											<th class="width_10" st-sort="">Branch Name</th>
											<th class="width_15" st-sort="">Department Name</th>
											<th class="width_15" st-sort="">Designation Name</th>
											<th class="width_10" st-sort="">DOB</th>
											<th class="width_10" st-sort="">Reporting Manager</th>
											<th class="width_10" st-sort="">Year of Experience</th>
											<th class=" width_10" st-sort="" ng-show="dateoj">DOJ</th>
											<th class=" width_10" st-sort="" ng-show="grossPay">Gross Salary</th>
											<th class=" width_10" st-sort="" ng-show="maritalStatus">Marital Status</th>
											<th class=" width_10" st-sort="" ng-show="motherTongue">Mother Tongue</th>
											<th class=" width_10" st-sort="" ng-show="nationality">Nationality</th>
											<th class=" width_10" st-sort="" ng-show="languages">Language Known</th>
											<th class=" width_10" st-sort="" ng-show="gradeName">Grade</th>
											<th class=" width_10" st-sort="" ng-show="bankName">Bank Name</th>
											<th class=" width_10" st-sort="" ng-show="telephoneLimit">Telephone Limit(Monthly)</th>
											<th class=" width_10" st-sort="" ng-show="medicalLimit">Medical Limit(Annual)</th>
																																												

										</tr>

									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											data-ng-repeat="empShift in displayedCollection">

											<td ng-show="empID">{{empShift.empId}}</td>
											<td>{{empShift.firstName}}</td>
											<td>{{empShift.companyName}}</td>
											<td>{{empShift.branchName}}</td>
											<td>{{empShift.departmentCode}}</td>
											<td>{{empShift.designationName}}</td>
											<td>{{empShift.dob}}</td>
											<td>{{empShift.reportManagerName}}</td>
											<td>{{empShift.experienceYear}}</td>
											<td ng-show="dateoj">{{empShift.doj}}</td>
											<td ng-show="grossPay">{{empShift.fixedGross}}</td>
											<td ng-show="maritalStatus">{{empShift.marriedStatus}}</td>
											<td ng-show="motherTongue">{{empShift.motherTongue}}</td>
											<td ng-show="nationality">{{empShift.nationality}}</td>
											<td ng-show="languages">{{empShift.languages}}</td>
											<td ng-show="gradeName">{{empShift.gradeName}}</td>
											<td ng-show="bankName">{{empShift.bankName}}</td>											
											<td ng-show="telephoneLimit">{{empShift.telephoneLimit}}</td>
											<td ng-show="medicalLimit">{{empShift.medicalLimit}}</td>																							
										</tr>
									</tbody>
								</table>
								<div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div>
							</div>
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
</div>




