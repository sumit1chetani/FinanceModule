
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
	<div class="panel panel-default panel-default-list" st-persist="lopListTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
	<%-- 	<%@include file="/views/templates/panel-header.jsp"%> --%>
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		<br><br>		<form class="form-horizontal" name="lopListForm" role="form">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">


					<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label class="col-md-5 control-label"> Organization <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list=companyList property="loplist.companyId"
									ng-model="loplist.companyId" id="companyId" name="companyId"
									form-name="lopListForm" validation="required"
									friendly-name="Hospital Name" ng-if="companyList.length > 1"></selectivity>

								<input type="text" class="form-control input-sm"
									ng-model="loplist.companyName" message-id="companyId"
									data-validator="required" data-valid-method="submit"
									name="Hospital Name" ng-if="companyList.length == 1" readonly>

							</div>
						</div>
						<div class="form-group">
							<label class="col-md-5 control-label"> Department </label>
							<div class="col-md-5">
								<selectivity list=departmentList property="loplist.departmentId"
									ng-model="loplist.departmentId" id="departmentId"
									name="departmentId" form-name="lopListForm"></selectivity>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="form-group">
							<label class="col-md-5 control-label">Branch <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list=branchList property="loplist.branchId"
									ng-model="loplist.branchId" id="branchId" name="branchId"
									form-name="lopListForm" validation="required"
									friendly-name="Branch Name" ng-if="branchList.length > 1"></selectivity>

								<input type="text" class="form-control input-sm"
									ng-model="loplist.branchName" message-id="branchId"
									data-validator="required" data-valid-method="submit"
									name="Hospital Name"
									ng-if="branchList.length == 1 || branchList.length == 0 "
									readonly>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-5 control-label">Month and Year <span
								style="color: red;">*</span>
							</label>
							<div class="col-md-5">
								<selectivity list=monthYearList property="loplist.monthYear"
									ng-model="loplist.monthYear" id="monthYear" name="monthYear"
									form-name="lopListForm" validation="required"
									friendly-name="Month Year"></selectivity>
							</div>
						</div>

					</div>

					<div class="form-group">
						<div class="row">
							<label class="col-md-5 control-label"> </label>
							<div class="col-md-5">
								<button class="btn btn-success" type="button"
									data-ng-click="getLOPList(lopListForm,loplist)" class="btn btn-success">
									Show List</button>
								<security:authorize access="hasRole('${form_code}_${export}')">
									<button class="btn btn-success" type="button"
										data-ng-click="exportExcel(lopListForm)"
										class="btn btn-success">Export</button>
								</security:authorize>
							<!-- 	<button class="btn btn-success" type="button"
									data-ng-click="fileUpload()" class="btn btn-success">
									Import</button> -->
								<div id="btnRowDivId"></div>
							</div>
						</div>
					</div>
				</div>
			</div>


		</form>
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<table class="table table-striped table-hover dataTable no-footer">
				<thead class="dataTables-Main-Head">
				<thead class="dataTables-Main-Head">
					<tr>
						<!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
						<th class="sorting width_20" st-sort="empId">Employee ID</th>
						<th class="sorting width_20" st-sort="employeeName">Employee Name</th>
						<th class="sorting width_20" st-sort="monthYear">Month Year</th>
						<th class="sorting width_20" st-sort="days">Days</th>
					</tr>
				</thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="empLopList in displayedCollection">

						<td>{{empLopList.employeeId}}</td>
						<td>{{empLopList.employeeName}}</td>
						<td>{{empLopList.monthYear}}</td>
						<td><input type="text" ng-pattern-restrict="^[0-9.]*$"
							ng-model="empLopList.days"
							ng-blur="checkPercentageValue(empLopList.monthYear,empLopList.days,$index)"></td>
					</tr>
				</tbody>
			</table>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						<button data-ng-if="loplist.isEdit" class="btn btn-success"
							type="button" data-ng-click="updateLOPList()"
							class="btn btn-success">Update</button>

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
	<a class="btn btn-success" href="tempdoc/Sample_Employee_Lop_Upload_File.xlsx" class="control-label">Download sample excel file</a>	
   <button class="btn btn-info" type="button" ng-click="uploadLop()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>