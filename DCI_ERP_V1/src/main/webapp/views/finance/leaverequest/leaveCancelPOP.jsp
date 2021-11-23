<style>
<!--
.ngdialog-content{
width: 50% !important;
bottom:105px !important;
}
-->
</style>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div>
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz">
					<header class="ngdialog-header">
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<h2>
							Leave Cancel Confirmation
						</h2>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="cancelConfirmationForm" novalidate method="post">
								<div class="row">

									<div class="col-sm-12 col-md-10 col-lg-10">
										<fieldset>
											

											<div class="form-group">
												<label class="col-md-6 control-label"> Cancel From Date 
												</label>
												<div class="col-md-6">
													<div class='input-group date datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="fromDate"
																role="button" data-toggle="dropdown" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="From Date"
																		validation="required" friendly-name="Cancel From Date"
																		form-name="cancelConfirmationForm"
																		data-ng-model="leaveCancel.fromDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="leaveCancel.fromDate"
																	data-on-set-time="leaveCancel.fromDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#fromDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-6 control-label"> Cancel To Date
												</label>
												<div class="col-md-6">
													<div class='input-group date datetimepick'>
														<div class="dropdown">
															<a class="dropdown-toggle" id="toDate"
																role="button" data-toggle="dropdown" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="To Date"
																		validation="required" friendly-name="Cancel To Date"
																		form-name="cancelConfirmationForm"
																		data-ng-model="leaveCancel.toDate"><span
																		class="input-group-addon"><i
																		class="glyphicon glyphicon-calendar"></i></span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker data-ng-model="leaveCancel.toDate"
																	data-on-set-time="leaveCancel.toDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
										</fieldset>
									</div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-success" class="btn btn-success"
												type="button"
												ng-click="cancellationLeave(cancelConfirmationForm)">
												<i class="fa fa-check"></i>
												OK
											</button>
											<button class="btn btn-danger" type="button"
												class="btn btn-success" ng-click="cancel()">
												<i class="fa fa-close"></i>
												Cancel
											</button>
										</div>
									</div>
								</div>
							</form>
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