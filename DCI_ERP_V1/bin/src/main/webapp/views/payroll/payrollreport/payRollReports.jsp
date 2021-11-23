
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
  
  <div class="panel-body">
					<form name="payrollReportForm" class="form-horizontal" novalidate>
						<div class="row book-widget-row">
									<div class="col-sm-12 col-md-12 col-lg-12">


										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Organization
													<span style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<!-- <input type="text" class="form-control"
								              	name="kmc"
								                data-ng-model="payrollreport.companyName" readonly > -->
													<!-- <selectivity list="companyList" ng-model="payrollreport.companyId"
														property="payrollreport.companyId" id="companyId" object="companyId"  name="companyId" validation="required"
			        				 friendly-name="Company" form-name = "payrollReportForm"></selectivity> -->
 <selectivity list="companyList"
										property="payrollreport.companyId" id="companyId"
										object="companyId"></selectivity>
													<!-- <selectivity list=companyList
														property="payrollreport.companyId"
														ng-model="payrollreport.companyId" id="companyId"
														name="companyId" form-name="payrollReportForm"
														validation="required" friendly-name="Hospital Name"
														ng-if="companyList.length > 1"></selectivity>

													<input type="text" class="form-control input-sm"
														ng-model="payrollreport.companyName"
														message-id="companyId" data-validator="required"
														data-valid-method="submit" name="Hospital Name"
														ng-if="companyList.length == 1" readonly>
 -->
 

													<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrollreport.companyId" ng-options="master.companyId as master.companyName for master in companyList"
														  ng-change="getBranchList(payrollreport.companyId)"   name="Employee No" data-validator="required" data-message-id="companyId" ng-if="isAuthorized" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Month <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<selectivity list="monthList"
														ng-model="payrollreport.month"
														property="payrollreport.month" id="month" object="month"
														name="month" validation="required" friendly-name="month"
														form-name="payrollReportForm"></selectivity>
												</div>

											</div>
										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label">Branch <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<selectivity list="branchList"
														ng-model="payrollreport.branchId"
														property="payrollreport.branchId" id="branchId"
														object="branchId" name="branchId" validation="required"
														friendly-name="Branch" form-name="payrollReportForm"
														ng-if="branchList.length > 1"></selectivity>

													<input type="text" class="form-control input-sm"
														ng-model="payrollreport.branchName" message-id="branchId"
														name="Hospital Name"
														ng-if="branchList.length == 1 || branchList.length == 0"
														readonly>

												</div>
											</div>
											<div class="form-group">
												<label class="col-md-5 control-label">Year <span
													style="color: red;">*</span>
												</label>
												<div class="col-md-7">
													<!-- <select class="form-control" ng-model="payrollreport.year" data-valid-method="submit">
						           					<option value=""> --Select--</option>
										   				 <option value="2015">2015</option>
										   				 <option value="2016">2016</option>
										   				 <option value="2017">2017</option>
										   				 <option value="2018">2018</option>
										   				 <option value="2019">2019</option>
										   				 <option value="2020">2020</option>
													</select> -->

													<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrollreport.year" ng-options="master.payslipYear as master.payslipYear for master in payRollYearList"
														   name="Year" data-validator="required" data-message-id="year" data-valid-method="submit" >
													        <option value=""> --Select--</option>
													        </select> -->

													<selectivity list="payRollYearList"
														ng-model="payrollreport.year"
														property="payrollreport.year" id="year" object="year"
														name="year" validation="required" friendly-name="Year"
														form-name="payrollReportForm"></selectivity>
												</div>
											</div>

										</div>
										<div class="col-sm-4 col-md-4 col-lg-4">
											<div class="form-group">
												<label class="col-md-5 control-label"> Department </label>
												<div class="col-md-7">
													<!-- <select  class="form-control journalVoucher-textBox" ng-model="payrollreport.departmentId" ng-options="master.departmentId as master.departmentName for master in departmentList"
												    name="Department Name" data-validator="required" data-message-id="departmentId" data-valid-method="submit">
											        <option value=""> --Select--</option>    </select>-->
													<selectivity list="departmentList"
														ng-model="payrollreport.departmentId"
														property="payrollreport.departmentId" id="departmentId"
														name="departmentId" friendly-name="Department"
														form-name="payrollReportForm"></selectivity>
												</div>
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="row">
											<label class="col-md-5 control-label"> </label>
											<div class="col-md-5">
												<button class="btn btn-success" type="button"
													data-ng-click="getPayrollList()" class="btn btn-success">
													Show Payroll List</button>
												<!-- <button class="btn btn-success" type="button"
													data-ng-click="exportExcel()" class="btn btn-success">
													Export</button> -->
													
													
													
												 <button class="btn btn-primary" type="button" data-ng-click="exportExcel()"   >
								        <span class="fa fa-file-excel-o"></span> Export 
								         <a id="Export" stype="display:none"
											href="filePath/PayrollReport.xls" download="PayrollReport.xls"></a>																						
								       </button>
													
													
												<div id="btnRowDivId"></div>
											</div>
										</div>
									</div>

								</div>
							</form>
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">

				
								<!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info" style="display: block;overflow-x: auto; white-space: nowrap;">
									<thead class="dataTables-Main-Head">
										<tr>
											<th colspan="1" style="text-align: center;"></th>
											<th colspan="12" style="text-align: center;">Earning</th>
											<th colspan="1" style="text-align: center;"></th>
											<th colspan="12" style="text-align: center;">Deduction</th>
											<th colspan="7" style="text-align: center;">Other</th>
											<th colspan="1" style="text-align: center;"></th>
										</tr>
										<tr>
											<!-- <th st-sort="employeeId">Employee ID</th> -->
											<th st-sort="employeeName">Employee Name</th>
											<th st-sort="BASIC">BASIC</th>
											<th st-sort="DA">DA</th>
											<th st-sort="HRA">HRA</th>
											<th st-sort="CONVE">CONVE</th>
											<th st-sort="CONS">CONS</th>											
											<th st-sort="SPL">SPL</th>
											<th st-sort="TA">TA</th>	
											<th st-sort="PI">PI</th>	
											<th st-sort="OT">OT</th>	
											<th st-sort="ARR">ARR</th>	
											<th st-sort="TS_05">TS_05</th>	
											
											<th st-sort="OTEAR">Other Earnings</th>
											<th st-sort="GROSS">Gross Pay</th>
											<th st-sort="PFSEL">PFSEL</th>
											<th st-sort="MEDIC">MEDIC</th>
											<th st-sort="WF">WF</th>
											<th st-sort="EPF">EPF</th>
											<th st-sort="ESI">ESI</th>
											<th st-sort="EDLI">EDLI</th>
											<th st-sort="EPS">EPS</th>
											<th st-sort="ADMC">ADMC</th>
											<th st-sort="Trans">Trans</th>
											<th st-sort="PTS">PTS</th>
											<th st-sort="OTDED">OTDED</th>
											<th st-sort="TOTDE">Total Deduction</th>
											
											<th st-sort="PT">PT</th>
											<th st-sort="TDS">Tax</th>
											<th st-sort="Tele">Tele</th>
											<th st-sort="US">US</th>
											<th st-sort="AD">AD</th>
											<th st-sort="TR1">Train.Fee</th>
											<th st-sort="avail">Leave Balance</th>
											<th st-sort="OTD">Others</th>
											<th st-sort="NET">Net Pay</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="payRollList in displayedCollection">

											<!--             <td>{{payRollList.employeeId}}</td> -->											
											<td>{{payRollList.employeeName}}</td>
											<td>{{payRollList.BASIC}}</td>
											<td>{{payRollList.DA}}</td>
											<td>{{payRollList.HRA}}</td>
											<td>{{payRollList.CONVE}}</td>
											<td>{{payRollList.CONS}}</td>
											<td>{{payRollList.SPL}}</td>
											<td>{{payRollList.TA}}</td>
											<td>{{payRollList.PI}}</td>
											<td>{{payRollList.OT}}</td>
											<td>{{payRollList.ARR}}</td>
											<td>{{payRollList.TS_05}}</td>
											
											<td>{{payRollList.OTEAR}}</td>
											<td>{{payRollList.GROSS}}</td>
											<td>{{payRollList.PFSEL}}</td>
											<td>{{payRollList.MEDIC}}</td>
											<td>{{payRollList.WF}}</td>
											<td>{{payRollList.EPF}}</td>
											<td>{{payRollList.ESI}}</td>
											<td>{{payRollList.EDLI}}</td>
											<td>{{payRollList.EPS}}</td>
											<td>{{payRollList.ADMC}}</td>
											<td>{{payRollList.Trans}}</td>
											<td>{{payRollList.PTS}}</td>
											<td>{{payRollList.OTDED}}</td>
											<td ng-if="payRollList.TOTDE != null">{{payRollList.TOTDE + payRollList.lopAmount}}</td>
											<td ng-if="payRollList.TOTDE == null">{{payRollList.lopAmount}}</td>											
											
											<td>{{payRollList.PT}}</td>
											<td>{{payRollList.TDS}}</td>
											<td>{{payRollList.Tele}}</td>
											<td>{{payRollList.US}}</td>
											<td>{{payRollList.AD}}</td>
											<td>{{payRollList.TR1}}</td>
											<td>{{payRollList.avail}}</td>
											<td>{{payRollList.OTD}}</td>
											<td>{{payRollList.NET}}</td>
										</tr>
									</tbody>
								</table>
									<footer class="panel-footer panel-footer-list">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>
							</div>
						</div>
					</div>
					<!-- end widget content -->
				</div>
				<!-- end widget div -->

				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>