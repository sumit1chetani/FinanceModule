<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-0">
		<br>
			<form class="form-horizontal" name="salaryfixationListForm"
				role="form">
				<div class="row">
									<fieldset>
										<div class="col-sm-12 col-md-12 col-lg-12 ">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-5 control-label"> Organization <span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<!-- <selectivity list=companyList
															property="employeePaycomponenet.companyId"
															ng-model="employeePaycomponenet.companyId" id="companyId"
															name="companyId" form-name="salaryfixationListForm"
															validation="required" friendly-name="Hospital Name"
															ng-if="companyList.length > 1"> </selectivity>
														<input type="text" class="form-control input-sm"
															ng-model="employeePaycomponenet.companyName"
															message-id="companyId" validation="required"
															friendly-name="Hospital Name" name="Hospital Name"
															ng-if="companyList.length == 1" > -->
															<selectivity list="companyList"
										property="employeePaycomponenet.companyId" id="companyId"
										object="companyId"></selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label"> Branch <span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<selectivity list=branchList
															property="employeePaycomponenet.branchId"
															ng-model="employeePaycomponenet.branchId" id="branchId"
															name="branchId" form-name=salaryfixationListForm
															validation="required" friendly-name="Branch Name"
															ng-if="branchList.length > 1"> </selectivity>
														<input type="text" class="form-control input-sm"
															ng-model="employeePaycomponenet.branchName"
															message-id="branchId" data-validator="required"
															data-valid-method="submit" name="Hospital Name"
															ng-if="branchList.length == 1 || branchList.length == 0 "
															readonly>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-5 control-label"> Department <span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<selectivity list="departmentList"
															property="employeePaycomponenet.departmentId"
															id="Department Name" name="Department Name"
															data-ng-model="employeePaycomponenet.departmentId"
															form-name="salaryfixationListForm" validation="required"
															friendly-name="Department"> </selectivity>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-5 control-label"> Employee <span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<selectivity list="employeeList"
															property="employeePaycomponenet.employeeId"
															id="employeeId" name="employeeId"
															data-ng-model="employeePaycomponenet.employeeId"
															form-name="salaryfixationListForm" validation="required"
															friendly-name="Employee"> </selectivity>
													</div>
												</div>
											</div>
										</div>
										<br>
										<br>
										<br>
										<div class="form-group">
											<div class="row">
												<label class="col-md-5 control-label"> </label>
												<div class="col-md-5">
													<button class="btn btn-success" type="button"
														data-ng-click="submit(salaryfixationListForm,employeePaycomponenet)"
														class="btn btn-success">Show</button>
													<button class="btn btn-success" type="button"
														data-ng-click="fileUpload()" class="btn btn-success">
														Import</button>
													<div id="btnRowDivId"></div>
												</div>
											</div>
										</div>
									</fieldset>
								</div>
							</form>
<br>
<br>
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">
		
								<!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th st-sort="payComponentId">From Date</th>
											<th st-sort="payComponentName">BASIC</th>
											<th st-sort="payComponentName">DA</th>
											<th st-sort="payComponentName">HRA</th>
											<th st-sort="payComponentName">CONVE</th>
											<!-- <th st-sort="payComponentName">PFCOM</th> -->
											<th st-sort="payComponentName">SPL</th>
											<th st-sort="payComponentName">CONS</th>
											<th st-sort="payComponentName">Other Earnings</th>											
											<th st-sort="payComponentName">Gross Pay</th>
											<th st-sort="payComponentName">MEDIC</th>
											<th st-sort="payComponentName">PFSEL</th>
											<th st-sort="payComponentName">WF</th>
											<!-- <th st-sort="payComponentName">Net Pay</th> -->
											<th st-sort="">Action</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="empPayComList in displayedCollection">
											<td>{{empPayComList.fromdate}}</td>
											<td>{{empPayComList.BASIC}}</td>
											<td>{{empPayComList.DA}}</td>
											<td>{{empPayComList.HRA}}</td>
											<td>{{empPayComList.CONVE}}</td>
											<!-- <td>{{empPayComList.PFCOM}}</td> -->
											<td>{{empPayComList.SPL}}</td>
											<td>{{empPayComList.CONS}}</td>
											<td>{{empPayComList.OTEAR}}</td>										
											<td>{{empPayComList.GROSS}}</td>
											<td>{{empPayComList.MEDIC}}</td>
											<td>{{empPayComList.PFSEL}}</td>
											<td>{{empPayComList.WF}}</td>
											<!-- <td>{{empPayComList.NET}}</td> -->
											<td class=" td-actions text-center">
													<span> <i
														
														class="fa  fa-pencil text-success text"
														data-ng-click="editRow(empPayComList.employeeId,empPayComList.fromdate)"></i>
													</span>
										
													<span> <i
													
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(empPayComList.employeeId,empPayComList.fromdate)"></i>
													</span>
													<span> <i    class="fa  fa-eye text-success text-center" ng-if="empPayComList.checkALreadyCreated == false"
														data-ng-click="viewRow(empPayComList.employeeId,empPayComList.fromdate)"></i>
													</span>
											</td>
										</tr>
									</tbody>
								</table>
								<div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div>
							</div>
						</div>
					</div>
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>

<!-- ng-if="empPayComList.fromdate==employeePaycomponenet.largeDateValue -->
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
 <button class="btn btn-info" type="button" ng-click="exportSampleExcel()">DownloadSample</button>
   <button class="btn btn-info" type="button" ng-click="uploadSalary()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
	<div id="btnRowDivIdsamp"> </div>
	</div>
  </div>
 </script>
