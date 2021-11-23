

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list"st-persist="advanceReportTable" 
  st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body">
					<form name="payrollReportForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
							<div class="col-sm-12">

								<div class="col-sm-6">

									<label class="col-md-4 control-label">Month and Year<span
										style="color: red;">*</span></label>

									<div class="form-group">
										<div class="col-md-3">
											<selectivity list="monthList" property="advance.month"
												id="month" ng-model="advance.month" form-name="advanceForm"
												validation="required" friendly-name="Deduct Month"
												name="month"> </selectivity>

										</div>

										<div class="col-md-3">
											<selectivity list="yearList" property="advance.year"
												id="year" ng-model="advance.year" form-name="advanceForm"
												validation="required" friendly-name="Deduct Year"
												name="year"> </selectivity>

										</div>
										
										<button class="btn btn-success" type="button" style="left: 50%;"
											data-ng-click="submit()">Submit</button>
									
									</div>


									

								</div>

							</div>
					</div>
  <div class="panel-body float-left padding-0" style="width: 100%;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead class="dataTables-Main-Head">
          <tr >
          <th class="sorting width_20" st-sort="advanceCode">Advance Code</th>
							<th class="sorting width_20" st-sort="employeeCode">Employee Code</th>
							<th class="sorting width_20" st-sort="employeeName">Employee Name</th>
							<th class="sorting width_20" st-sort="amount">Advance Amount</th>
							<th class="sorting width_20" st-sort="numberOfInstallments">Total Installments</th>
							<th class="sorting width_20" st-sort="paidAmount">Paid Amount</th>
							<th class="sorting width_20" st-sort="installmentPaid">Installments Paid</th>
							<th class="sorting width_20" st-sort="balanceAmount">Balance Amount</th>
							<th class="sorting width_20" st-sort="balanceIns">Balance Installment</th>
							<th class="sorting width_20" st-sort="installmentAmount">Installment Amount</th>
							<th class="sorting width_20" st-sort="narration">Narration</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="payRollList in displayedCollection">

							<!--             <td>{{payRollList.employeeId}}</td> -->
							<td>{{payRollList.advanceCode}}</td>
							<td>{{payRollList.employeeCode}}</td>
							<td>{{payRollList.employeeName}}</td>
							<td style="text-align: right;">{{payRollList.amount}}</td>
							<td>{{payRollList.numberOfInstallments}}</td>
							<td style="text-align: right;">{{payRollList.paidAmount}}</td>
							<td>{{payRollList.installmentPaid}}</td>
							<td style="text-align: right;">{{payRollList.balanceAmount}}</td>
							<td>{{payRollList.balanceIns}}</td>
							<td style="text-align: right;">{{payRollList.installmentAmount}}</td>
							<td>{{payRollList.narration}}</td>
						</tr>
					</tbody>
    </table>
     <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
  <!-- end widget content -->
 </div>
</div> 