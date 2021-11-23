
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
.ngdialog.ngdialog-theme-plain .ngdialog-content {
	max-width: 100%;
	width: 850px;
	position: center;
	top: 10%;
	left: 0px;
	margin-top: -40px;
	position: center;
	top: 10%;
	left: 0px;
}
</style>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					<header class="ngdialog-header">
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<h2>PaySlip Report Bulk Mail</h2>
					</header>
					<div role="content">
						<div class="widget-body">
							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection"
								st-safe-src="paySlipReport.mailsend">
								<form class="form-horizontal" name="paySlipReportMailForm"
									novalidate method="post">


									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>
												<th class="width_1 text-center table-heading"><label
													class="i-checks m-b-none"> <input type="checkbox"
														ng-model="checkFull" ng-change="checkAll(checkFull)"> <i></i>
												</label></th>
												<th class="sorting width_12" st-sort="mailAdress">Email
													Address</th>
											</tr>
										</thead>
										<tbody>
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="paySlipReport in displayedCollection">
												<!-- <td cs-select="leaveObj"></td> -->
												<td class="text-center">r
													<div class="checkbox">
														<label class="i-checks m-b-none"> <input
															type="checkbox" ng-model="paySlipReport.select"><i
															style="left: 6px;"></i>
														</label>
													</div>
												</td>
												<td>{{paySlipReport.email}}</td>
											</tr>
										</tbody>
									</table>



									<!-- 									<div class="row">
										<div class="col-sm-12 col-md-12 col-lg-12">
											<div class="col-sm-10 col-md-10 col-lg-10">
												<div class="form-group">
													<label class="col-md-4 control-label"> Email
														Address </label>
													<div class="col-md-5">
														<input class="form-control input-sm" name="emailAddress"
															ng-model="paySlipReport.emailAddress"
															validation="required" placeholder='your@email.com'
															friendly-name="Email Address" />
													</div>
												</div>
											</div>
										</div>
										/col-sm-12 col-md-12 col-lg-12
									</div> -->
									<!-- /row -->
									<div class="form-actions">
										<div class="row">
											<div class="col-md-12">
												<button class="btn btn-primary" type="button"
													data-ng-click="emailPaySlipReport(paySlipReport)">
													<i class="fa fa-envelope-o"></i> Email
												</button>
												<button class="btn btn-danger" type="button"
													data-ng-click="cancelEmail()">Cancel</button>
											</div>
										</div>
									</div>
								</form>
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