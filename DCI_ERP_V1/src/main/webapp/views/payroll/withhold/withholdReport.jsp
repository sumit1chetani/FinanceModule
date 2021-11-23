<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>
  
  <div class="panel-body">
					<form name="AdvanceReport" class="form-horizontal" novalidate>
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">


										<div class="col-sm-12 col-md-12 col-lg-5">
								<label class="col-md-4 control-label">Month and Year<spring:message code="label.asterisk.symbol"></spring:message></label>

											<div class="form-group">
												<div class="col-md-3">
													<selectivity list="monthList" property="advance.month"
														id="month" ng-model="advance.month"
														form-name="advanceForm" validation="required"
														friendly-name="Deduct Month" name="month">
													</selectivity>

												</div>

												<div class="col-md-3">
													<selectivity list="yearList" property="advance.year"
														id="year" ng-model="advance.year" form-name="advanceForm"
														validation="required" friendly-name="Deduct Year"
														name="year"> </selectivity>

												</div>
												
											</div>

										</div>
										<div class="col-sm-6 col-md-6 col-lg-5">
												<label class="col-md-3 control-label">Status:</label>
										
										
												<div class="col-md-3">
												
													<selectivity list="statusList" property="advance.status"
														id="year" ng-model="advance.status" form-name="advanceForm"
														validation="required" friendly-name="Satus "
														name="year"> </selectivity>

												</div>
										<button class="btn btn-success" type="button" data-ng-click="submit()">
								Submit
							</button>
										</div>

									</div>

								</div>


<br>
<br>
								<div
									class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
									st-table="displayedCollection" st-safe-src="rowCollection">
								<%-- 	<div class="dt-toolbar">
		<%@include file="/views/templates/panel-header.jsp"%>
									</div> --%>

									<!-- <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->

									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										aria-describedby="dt_basic_info">
										<thead>
											<tr>

												<th st-sort="withHoldCode"> Code</th>
												<th st-sort="employee">Employee Code</th>
												<th st-sort="employeeName">Employee Name</th>
												<th st-sort="withholdDate">Withhold Date</th>
												<th st-sort="withholdFrom">Withhold From</th>
												<th st-sort="withholdTo">Withhold Till</th>
												

											</tr>

										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="loanlist in displayedCollection">

												<td>{{loanlist.withHoldCode}}</td>
												<td>{{loanlist.employee}}</td>
												<td>{{loanlist.employeeName}}</td>
												<td >{{loanlist.withholdDate| date:'dd/MM/yyyy'}}</td>
												<td>{{loanlist.withholdFrom | date:'MM/yyyy'}}</td>
												<td>{{loanlist.withholdTo | date:'MM/yyyy'}}</td>
												
											</tr>
										</tbody>
									</table>
  <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
								</div>
								<br>
								
								<div class="row">
									<div class="col-sm-12 col-md-12 col-lg-12">

										<div class="col-sm-5 col-md-5 col-lg-5">
										</div>
									<div class="col-sm-6 col-md-6 col-lg-6">
										
										<button class="btn btn-success" type="button" ng-if="expor" data-ng-click="exportExcel()">
								Export
							</button>
							<div id="btnRowDivId"></div>
										</div>

									</div>

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
