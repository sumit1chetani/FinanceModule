<style>
.hideByDefault{
    display: none;
}
#showdiv:hover {
  color: red;
  background-color: yellow;
}

</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

	<div class="panel panel-default panel-default-list" st-persist="ptslabGenerationTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		<br><br>
		<form class="form-horizontal" name="ptslabgenerationForm" role="form">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12 ">
					<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label class="col-md-5 control-label"> Organization <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list=companyList property="ptslabList.companyId"
									ng-model="ptslabList.companyId" id="companyId" name="companyId"
									form-name="ptslabgenerationForm" validation="required"
									friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>
								<input type="text" class="form-control input-sm"
									ng-model="ptslabList.companyName" message-id="companyId"
									data-validator="required" data-valid-method="submit"
									name="Hospital Name" ng-if="companyList.length == 1" readonly>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-5 control-label"> Branch <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list=branchList property="ptslabList.branchId"
									ng-model="ptslabList.branchId" id="branchId" name="branchId"
									form-name="ptslabgenerationForm" validation="required"
									friendly-name="Branch Name" ng-if="branchList.length > 1"></selectivity>

								<input type="text" class="form-control input-sm"
									ng-model="ptslabList.branchName" message-id="branchId"
									data-validator="required" data-valid-method="submit"
									name="Hospital Name"
									ng-if="branchList.length == 1 || branchList.length == 0 "
									readonly>
							</div>
						</div>
					</div>


					<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label class="col-md-5 control-label"> Department </label>
							<div class="col-md-5">
								<selectivity list=departmentList
									property="ptslabList.departmentId"
									ng-model="ptslabList.departmentId" id="departmentId"
									name="departmentId" form-name="ptslabgenerationForm"></selectivity>

							</div>
						</div>
						<div class="form-group">
							<label class="col-md-5 control-label"> Financial Year <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list=financialYearList
									property="ptslabList.financialYear"
									ng-model="ptslabList.financialYear" id="financialYear"
									name="financialYear" form-name="ptslabgenerationForm"
									validation="required" friendly-name="Financial Year"></selectivity>

							</div>
						</div>

					</div>
					<div class="form-group">
						<div class="row">
							<label class="col-md-5 control-label"> </label>
							<div class="col-md-5">
								<button class="btn btn-success" type="button"
									ng-click="validate(ptslabgenerationForm)">Show List</button>
								<button class="btn btn-success" type="button"
									data-ng-click="fileUpload()">Import</button>
								
									<button class="btn btn-success" type="button"
										data-ng-click="exportExcel()">Export</button>
									<div id="btnRowDivId"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<div
				class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
				st-table="displayedCollection" st-safe-src="rowCollection">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead class="dataTables-Main-Head">
						<tr>
							<!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
							<th class="sorting width_10" st-sort="employeeId">Employee
								ID</th>
							<th class="sorting width_10" st-sort="employeeName">Employee
								Name</th>
							<th class="sorting width_5" st-sort="head"
								ng-repeat="head in headlablist">{{head.monthValue}}</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="ptslabList in displayedCollection">

							<td>{{ptslabList.employeeId}}</td>
							<td>{{ptslabList.employeeName}}</td>
							<td ng-if="$index != ptslabList.dateList.length-1"
								ng-repeat="val in ptslabList.dateList">{{val.amount}}</td>
							<td ng-if="ptslabList.dateList.length-1 == $index"
								ng-repeat="val in ptslabList.dateList"><input type="number"
								min="0" ng-model="val.amount"></td>
						</tr>
					</tbody>
				</table>

				<footer class="panel-footer panel-footer-list">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>
			</div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						<button class="btn btn-success" type="button"
							data-ng-click="update()" class="btn btn-success">
							Update</button>

					</div>

				</div>


			</div>
		</div>
		<!-- end widget content -->
	</div>
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
	<a href="tempdoc/Sample_Employee_PT_Slab_Upload_File.xlsx" class="control-label">Download sample excel file</a>	
   <button class="btn btn-info" type="button" ng-click="uploadPTSlab()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>