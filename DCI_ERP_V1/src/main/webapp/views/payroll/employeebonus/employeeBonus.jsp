
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-persist="empBonusTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
  <div class="panel-body float-left padding-0" style="width: 100%;">
  <br>
   <form class="form-horizontal" name="employeeBonusForm" role="form" > 
     	<div class="row">
     	<fieldset>
     	<div class="col-sm-12 col-md-12 col-lg-12 ">
				<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
						<label class="col-md-5 control-label" > Organization
						</label>
						<div class="col-md-5">
						<!--  <selectivity  list=companyList property="employeebonus.companyId" ng-model="employeebonus.companyId"
								 								id="companyId"  name="companyId" form-name = "employeeBonusForm" 
	        												validation="required" friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
				        							
				     											<input type="text" class="form-control input-sm" ng-model="employeebonus.companyName" message-id="companyId" 
        															data-validator="required" data-valid-method="submit" name="Hospital Name" ng-if="companyList.length == 1" readonly>      
					 -->
					 <selectivity list="companyList"
										property="employeebonus.companyId" id="companyId"
										object="companyId"></selectivity>	</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Branch
						</label>
						<div class="col-md-5">
							<selectivity  list=branchList property="employeebonus.branchId" ng-model="employeebonus.branchId" id="branchId"  name="branchId" form-name = "employeeBonusForm" validation="required" friendly-name="Branch Name" ng-if="branchList.length > 1 "></selectivity> 											        
							 
							 <input type="text" class="form-control input-sm" ng-model="employeebonus.branchName" message-id="branchId" 
        										data-validator="required" data-valid-method="submit" name="Branch Name" ng-if="branchList.length == 1 || branchList.length == 0 " readonly>     	 	 						        
						</div>
					</div>
					
					</div>
			
			
			<div class="col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
					<label class="col-md-5 control-label" > Department
					</label>
					<div class="col-md-5">
					 <selectivity  list=departmentList property="employeebonus.departmentId" ng-model="employeebonus.departmentId" id="departmentId"  name="departmentId" form-name = "employeeBonusForm"></selectivity> 
						
					</div>
					</div>
					<div class="form-group">
						<label class="col-md-5 control-label" > Month Year
						<span style="color: red;">*</span>	 
						</label>
						<div class="col-md-5">
							<selectivity  list=financialYearList property="employeebonus.financialYear" ng-model="employeebonus.financialYear"
								 id="financialYear"  name="financialYear" form-name = "employeeBonusForm"
	        							validation="required" friendly-name="Month Year"></selectivity> 
			                       	 	
						</div>
						</div>
					
		
			</div>
			
			<div class="form-group">
						<div class="row">
								<label class="col-md-5 control-label">
												</label>
									<div class="col-md-5">
										<button class="btn btn-success" type="button" data-ng-click="getBonusList(employeeBonusForm)">
												Submit
										</button>
									</div>	
									</div>	
					</div>	
			
			</div>
			</div>
			</form>
		 <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all" st-table="displayedCollection" st-safe-src="rowCollection">
		       <!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
	
		      
		        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		           <th class="sorting width_10" st-sort="employeeId">Employee No</th>
		           <th class="sorting width_10" st-sort="employeeName">Employee Name</th>
		           <th class="sorting width_20" st-sort="declaredAmount">Declared Amount</th>
		           <th class="sorting width_10" st-sort="paidAmount">Paid Amount</th>
		            <th class="sorting width_10" st-sort="">Action</th>
		          </tr>
		         </thead>
		          <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="employeeBonusList in displayedCollection">
           
			<td>{{employeeBonusList.employeeId}}</td>
			<td>{{employeeBonusList.employeeName}}</td>
			<td><input type="text" ng-blur="checkAmount(employeeBonusList.declaredAmount,employeeBonusList.paidAmount,employeeBonusList.employeeId)" ng-pattern-restrict="^[0-9.]*$" ng-model="employeeBonusList.declaredAmount"></td>
			
			<td>{{employeeBonusList.paidAmount}}</td>
			
		 <td class=" td-actions text-center">
		 
		 <%--  <security:authorize access="hasRole('F0011_D')"> --%>
		 <button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="view" ng-hide="employeeBonusList.paidAmount===0" ng-click="bonusSummary(employeeBonusList.bonusId)">
									  <i class="fa fa-eye"></i>
									       View
						        </button>
						       <%--  </security:authorize>
						        
		 <security:authorize access="hasRole('F0011_D')">		 --%>		        
		<button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="pay" ng-hide="employeeBonusList.checkPayAmount===employeeBonusList.paidAmount" ng-click="bonusPay(employeeBonusList.bonusId)">
									  <i class="fa fa-inr"></i>
									       Pay
						        </button>
		 
       </td>
          </tr>
         </tbody>
		        </table>
				<footer class="panel-footer panel-footer-list">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>		       </div>
		        <div class="form-actions">
					<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" class="btn btn-success" type="button"  data-ng-model="add" data-ng-if="employeebonus.isEdit" ng-click="updateBonusList()">
									  <i class="fa fa-save"></i>
									       Update
						        </button>
								</div>
					</div>
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