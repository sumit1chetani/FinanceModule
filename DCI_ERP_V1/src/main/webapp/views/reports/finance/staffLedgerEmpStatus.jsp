<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
<%--     <%@include file="/views/templates/panel-header.jsp"%>  --%>
	<br>
	<div class="col-md-12">			
		<div class="col-md-3 pull-left">
		<span ng-if="staff.status == 'Y'">
			<h5 class="font-bold">Status : Active</h5>
		</span>
		<span ng-if="staff.status == 'N'">
			<h5 class="font-bold">Status : Inactive</h5>
		</span>
		<span ng-if="staff.status == 'A'">
			<h5 class="font-bold">Status : All</h5>
		</span>
		</div>
		<div class="col-md-3 pull-right">
			<input type="text"    st-search="" class="form-control input-sm p-tb-5 bg-white rounded padder" placeholder="Search">
		</div>
</div>
	
<div class="col-md-12 ">
  <input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body padding-0">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th class="sorting width_25" st-sort="employeeName">Employee Name</th>
       <th class="sorting width_15" st-sort="department">Department</th>
       <th class="sorting width_20" st-sort="position">Position</th>
       <th class="sorting width_20" st-sort="companyName">Company</th>
       <!-- <th class="text-center width_10">Current Status</th> -->
       <th class="text-center width_10">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
		<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(index, objStaffLedger) in displayedCollection">
			 <td>{{objStaffLedger.employeeName}}</td>
			 <td>{{objStaffLedger.department}}</td>
			 <td>{{objStaffLedger.position}}</td>
			 <td>{{objStaffLedger.companyName}}</td>
			 <!-- <td style="text-align:center;">
			 	<span ng-if="objStaffLedger.status == 'Y'">
			 		Active
			 	</span>
			 	<span ng-if="objStaffLedger.status == 'N'">
			 		Inactive
			 	</span>												
			  </td>	 -->
			 <td style="text-align:center;">
			 <button class="btn btn-success btn-xs" type="reset" ng-click="btnaction(objStaffLedger.status,objStaffLedger.employeeCode)">Change Status</button>
			 	<!-- <span ng-if="objStaffLedger.status == 'Y'">
			 		<button class="btn btn-success btn-xs" type="reset" ng-click="btnaction(objStaffLedger.status,objStaffLedger.employeeCode)">Change status</button>
			 	</span>
			 	<span ng-if="objStaffLedger.status == 'N'">
			 		<button class="btn btn-success btn-xs" type="reset" ng-click="btnaction(objStaffLedger.status,objStaffLedger.employeeCode)">Change status</button>
			 	</span> -->
				<!-- <label class="i-checks m-b-none">
         			<input type="checkbox" ng-false-value = "'N'" ng-true-value = "'Y'" data-ng-model="objStaffLedger.status" data-ng-click="checkBoxVal(index,objStaffLedger.status)">
					<i></i>
       	 		</label> --> 
			  </td>			     	
		</tr>
	</tbody>
    </table>
   </div>
   <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  </div>
 </div>

<div class="form-actions">
	<div class="row">
		<div class="col-md-12 "> <br>
			<button class="btn btn-danger" ng-click="cancelfrm()">
				<i class="fa fa-close"></i>
	 				Cancel
			</button>
        </div>
	</div>
</div>
<br>
</div> 

<%-- <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
  									<input type="hidden" value="${form_code}" id="form_code_id">
  				<div class="panel-body">
    			<form name="trialBalanceForm" class="form-horizontal" >
    			<div class="row text-center">
					     	<!-- <div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Company
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="companyList" property="staffLedger.companyCode" id="companyCode" object="companyCode"></selectivity>
										</div>
									</div>
								</fieldset>
							</div>							
						<div class="col-sm-12 col-md-4 col-lg-4">
								<fieldset>
									<div class="form-group">
										<label class="col-md-5 control-label"> Active</label>
										<div class="col-md-7">											
											<label class="i-checks">
												<input type="checkbox" class="checkbox style-0" checked="checked" ng-false-value = "'N'" ng-true-value = "'Y'" name="isActive" id="isActive" ng-model="staffLedger.isActive">
											<i></i></label>
										</div>
									</div>
								</fieldset>
						</div> -->
						
				</div>
				<div class="form-actions" style="text">
    				<div class="row">
    				<div class="col-md-3"><br></div>
    					<div class="col-md-6">
							<table class="table table-striped  b table-bordered table-hover dataTable no-footer" >
								<thead class="dataTables-Main-Head">
			      					<tr>
								       <th class="text-center width_25"> User Name </th>
								       <th class="text-center width_25"> Status </th>
			      					</tr>
			     				</thead>
			    				 <tbody class="dataTables-Main-Body">
			     						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(index, objStaffLedger) in staffLedger">
			     							<td>
			     								{{objStaffLedger.employeeName}}
			     							</td>
			     							<td>
<!-- 			     							<input type="checkbox" class="checkbox style-0" checked="checked" ng-false-value = "'N'" ng-true-value = "'Y'" name="isActive" id="isActive" ng-model="staffLedger.isActive">
 -->			     								
 												<!-- <span ng-if='objStaffLedger.status == "Y"'>
 													<input type="checkbox" ng-false-value = "'N'" ng-true-value = "'Y'" name="staffLedger.employeeCode" id="staffLedger.employeeCode" ng-model="staffLedger.status" cheched=true>
 												</span>
 												<span ng-if='objStaffLedger.status == "N"'>
 													<input type="checkbox" ng-false-value = "'N'" ng-true-value = "'Y'" name="staffLedger.employeeCode" id="staffLedger.employeeCode" ng-model="staffLedger.status" cheched=false>
 												</span> -->
 												 <input type="checkbox" ng-false-value = "'N'" ng-true-value = "'Y'" data-ng-model="objStaffLedger.status" data-ng-click="checkBoxVal(index,objStaffLedger.status)">
																				<i></i>
			     							</td>			     	
			     						</tr>
			     				</tbody>
							</table>
						</div>
						<div class="col-md-3"><br></div>
					</div>
				</div>

						<!-- Form Action -->
						<div class="form-actions">
					         <div class="row">
						          <div class="col-md-12 ">
						          	
						          	<button class="btn btn-success" class="btn btn-success" ng-click="savefrm()">
						            Save
						           </button>
           					
           							<button class="btn btn-success" class="btn btn-success" ng-click="canclefrm()">
						            Cancle
						           </button>
						           
         						 </div>
        						 </div>
       					</div>
         				<br>
					</form>
				</div> <!-- /panel-body -->
			</div> <!-- /panel-default -->
		</div>
	</div>
</div> --%>
