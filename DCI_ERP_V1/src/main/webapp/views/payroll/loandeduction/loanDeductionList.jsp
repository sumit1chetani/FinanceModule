

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>

	<div class="panel panel-default panel-default-list" st-persist="loanDeductionTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<br>
			<div class="col-sm-12 col-md-12 col-lg-12">
				<!-- <div class="col-sm-6 col-md-6 col-lg-5">
											<div class="form-group">
												<label class="col-md-5 control-label">Month
													 <span style="color: red;">*</span>
												</label>
												<div class="col-md-5">
												<selectivity list="monthList" ng-model="deduction.month"
														property="deduction.month" id="month" object="month"  name="month" validation="required"
			        				 friendly-name="Month" form-name = "vesselMasterForm"></selectivity>-->
				<!-- <select class="form-control" ng-model="deduction.month">
										   				 <option value="">--Select--</option>
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
				<!-- </div>
											</div>	
											
											
										</div>-->

				<div class="col-sm-6 col-md-6 col-lg-5">

					<div class="form-group">
						<label class="col-md-5 control-label">Month & Year <span
							style="color: red;">*</span>
						</label>
						<div class="col-md-5">
							<!--  <selectivity list="financialYearList" property="deduction.year" 
										                id="year" ng-model="deduction.year"
										               name="year" form-name="vesselMasterForm"
										               validation="required" friendly-name="Year">
										         </selectivity>-->

							<selectivity list=monthYear property="deduction.monthYear"
								ng-model="deduction.monthYear" id="monthYear" name="monthYear"
								form-name="payrollgenertaionForm" validation="required"
								friendly-name="Month Year"></selectivity>
							<!-- <select class="form-control" ng-model="deduction.year">
										   				 <option value="">--Select--</option>
										   				 <option value="2015">2015</option>
										   					<option value="2016">2016</option>
										   				   <option value="2017">2017</option>
										   				   <option value="2018">2018</option>
													</select> -->
						</div>
					</div>

				</div>
			</div>
			<br> <br> <br> <br>
			<table class="table table-striped table-hover dataTable no-footer">
				<thead class="dataTables-Main-Head">
				<thead class="dataTables-Main-Head">
					<tr>
					  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> 
						<th class="sorting width_12" st-sort="employeeId">Employee Id</th>
						<th class="sorting width_15" st-sort="employeeName">Employee
							Name</th>
						<!-- <th class="sorting width_15" st-sort="loanTypeId">Loan Type Id</th>-->
						<th class="sorting width_15" st-sort="loanTypeName">Loan Type</th>
						<th class="sorting width_15" st-sort="">Instalment</th>
						<th class="sorting width_15" st-sort="deductionAmount">Deduction
							Amount</th>
					</tr>
				</thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="loanlist in displayedCollection">
						<td><label class="i-checks m-b-none"> <input
								type="checkbox" ng-model="loanlist.checkbox"> <i></i>
						</label></td>
						<td>{{loanlist.empId}}</td>
						<td>{{loanlist.employeeName}}</td>
						<td>{{loanlist.loanTypeId}} - {{loanlist.loanTypeName}}</td>
						<td>{{loanlist.currentEmiNo}} / {{loanlist.totalEmi}}</td>
						<td>{{loanlist.deductionAmount}}</td>
					</tr>
				</tbody>
			</table>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
		<div class="form-group">
			<div class="row">
				<label class="col-md-6 control-label"> </label>
				<div class="col-md-6">


					<button class="btn btn-success" type="button"
						data-ng-click="deductLoan()" class="btn btn-success"
						ng-if="deduction.isTobededucted">Deduct</button>

				</div>
			</div>
		</div>
	</div>
</div>