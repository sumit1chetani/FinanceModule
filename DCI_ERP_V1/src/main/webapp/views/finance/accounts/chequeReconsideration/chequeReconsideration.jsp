<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
.padding-0 {
	padding: 0 !important;
	line-height: 34px;
}

.sorting:after {
	display: none !important;
}

#standard-datatable-widget > div > div.widget-body > form > div.row > div:nth-child(3) > fieldset > div > div > selectivity > div.selectivity-dropdown
{	width: 88% !important;
}
#standard-datatable-widget > div > div.widget-body > form > div.row > div:nth-child(3) > fieldset > div > div > selectivity > div.selectivity-dropdown > div
{
overflow-x: visible}
</style>
<div id="content">
	<!-- widget grid -->
	<section data-widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div data-jarvis-widget id="standard-datatable-widget">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
						<div class="widget-toolbar">
							<div>
								<span> <span class="button-icon" data-placement="bottom"
									data-reset-widgets rel="tooltip"
									title="<spring:message code='title.widget.reset'></spring:message>">
										<i class="fa fa-refresh"></i>
								</span>
								</span>
							</div>
						</div>
					</header>
					<div role="content">
						<div class="widget-body">
							<form class="form-horizontal" name="chequeReconsolationAddForm" novalidate method="post">
								<div class="row">
									<div class="col-sm-12 col-md-4">
										<fieldset>
											<div class="form-group">
												<label class="col-md-5 control-label">From Date<spring:message code="label.asterisk.symbol"></spring:message></label>
												<div class="col-md-7">
													<div class='input-group date datetimepick col-md-12'>
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="fromDate" role="button" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="fromdate" 
																		validation="required" id="fromdate"
																		friendly-name="From Date"
																		data-ng-model="reconsidate.fromdate">
																	<span class="input-group-addon"> <i
																		class="glyphicon glyphicon-calendar"></i>
																	</span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="reconsidate.fromdate"
																	data-on-set-time="reconsidate.fromdate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#fromDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
										</fieldset>
									</div>
									<div class="col-sm-12 col-md-4">
										<fieldset>
											<div class="form-group">
												<label class="col-md-5 control-label">To Date <spring:message code="label.asterisk.symbol"></spring:message></label>
												<div class="col-md-7">
													<div class='input-group date datetimepick col-md-12'>
														<div class="dropdown">
															<a data-toggle="dropdown" class="dropdown-toggle"
																id="toDate" role="button" data-target="#" href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy" name="todate"
																		validation="required" id="todate"
																		friendly-name="To Date"
																		data-ng-model="reconsidate.todate">
																	<span class="input-group-addon"> <i
																		class="glyphicon glyphicon-calendar"></i>
																	</span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel">
																<datetimepicker
																	data-ng-model="reconsidate.todate"
																	data-on-set-time="reconsidate.todate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#toDate',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</div>
											</div>
										</fieldset>
									</div>
									<div class="col-sm-12 col-md-4">
										<fieldset>
											<div class="form-group">
												<label class="col-md-5 control-label">Bank Account<spring:message
														code="label.asterisk.symbol"></spring:message>
												</label>
												<div class="col-md-6">
													<selectivity list="bankList" property="reconsidate.bankAccount" id="bankAccount"
														ng-model="reconsidate.bankAccount" name="bankAccount"
														form-name="chequeReconsolationAddForm" validation="required"
														friendly-name="Bank Account"></selectivity>
												</div>
											</div>
										</fieldset>
									</div>
									<div></div>
								</div>
								<div class="form-actions">
									<div class="row">
										<div class="col-md-12">
											<button class="btn btn-primary" type="button" id="reportBtn"
												ng-click="showDifferences(chequeReconsolationAddForm,reconsidate);">Show
												Differences</button>
											<button class="btn btn-info" type="button" id="reportBtn"
												ng-click="showReconillation(chequeReconsolationAddForm,reconsidate);">Show
												Reconcile Records</button>
										</div>
									</div>
								</div>
								<div class="row" ng-show="table=='difference'" ng-if="rowCollectionItem.length>0">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<br>
										<div role="content">
											<div class="widget-body no-padding">
												<div class="" data-st-table="displayedCollectionItem" data-st-safe-src="rowCollectionItem">
													<table id="dt_basic"
														class="table table-striped table-bordered table-hover dataTable no-footer"
														role="grid" aria-describedby="dt_basic_info">
														<thead class="dataTables-Main-Head">
															<tr>
																<th class="sorting width_7"></th>
																<th class="sorting width_7">Bank Date</th>
																<th class="sorting width_7 ">Opening Balance</th>
																<th class="sorting width_7 ">Voucher No</th>
																<th class="sorting width_7 ">Book Cheque Date</th>
																<th class="sorting width_7 ">Book Cheque No</th>
																<th class="sorting width_7 ">Book Debit Amt</th>
																<th class="sorting width_7 ">Book Credit Amt</th>
																<th class="sorting width_7 ">Closing Balance</th>
															</tr>
															<tr ng-repeat="(trIndex, row) in reconsidate.differentrecli">
																<td colspan=1 class="width_1"><label
																	class="i-checks m-b-none"> <input
																		type="checkbox" ng-model="row.select"
																		id="section{{trIndex}}"><i></i></label></td>
																<td colspan=1 class="width_1">
																	<div class="row">
																		<div class='input-group date datetimepick col-md-12'>
																			<div class="dropdown">
																				<a data-toggle="dropdown" class="dropdown-toggle"
																					ng-attr-id="{{ 'bankDate-' + $index }}"
																					role="button" data-target="#" href="#">
																					<div class="input-group">
																						<input type="text" class="form-control"
																							placeholder="dd/mm/yyyy" name="eddDate"
																							data-validator="required"
																							data-valid-method="submit"
																							data-message-id="EddDate"
																							data-ng-model="row.bankDate"> <span
																							class="input-group-addon"> <i
																							class="glyphicon glyphicon-calendar"></i>
																						</span>
																					</div>
																				</a>
																				<ul class="dropdown-menu" role="menu"
																					aria-labelledby="dLabel">
																					<datetimepicker data-ng-model="row.bankDate"
																						data-on-set-time="row.bankDate = onDateSet(newDate)"
																						data-datetimepicker-config="{ dropdownSelector: '{{ '#bankDate-' + $index }}'
																							,startView:'day', minView:'day'}" />
																				</ul>
																			</div>
																		</div>
																</td>
																<td colspan=1 class="width_1 text-right">{{row.openingBalance}}
																</td>
																<td colspan=1 class="width_1">{{row.transactionNo}}
																</td>
																<td colspan=1 class="width_1">{{row.bookChequeDate}}
																</td>
																<td colspan=1 class="width_1">{{row.bookChequeNo}}
																</td>
																<td colspan=1 class="width_1 text-right">{{row.bookDebitAmount}}
																</td>
																<td colspan=1 class="width_1 text-right">{{row.bookCreditAmount}}
																</td>
																<td colspan=1 class="width_1 text-right">{{row.closingBalance}}
																</td>
															</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12 col-md-4">
											<fieldset>
												<div class="form-group">
													<label class="col-md-5 control-label">Remarks<spring:message
															code="label.asterisk.symbol"></spring:message>
													</label>
													<div class="col-md-6">
														<br>
														<textarea id="remarks" name="remarks"
															ng-model="reconsidate.remarks"
															class="form-control input-sm" maxlength="25"></textarea>
													</div>
												</div>
											</fieldset>
										</div>
										<div class="col-sm-12 col-md-8">
											<fieldset>
												<div class="form-group">
													<label class="col-md-8 control-label"> </label>
													<div class="col-md-4">
														<br>
														<button class="btn btn-success" type="button"
															id="reportBtn" ng-click="saveReconcileData(reconsidate);">Reconcile</button>
													</div>
												</div>
											</fieldset>
										</div>
									</div>
								</div>
								<div class="row" ng-show="table=='reconcilat'" ng-if="reconsidate.differentrecli.length>0">
									<div class="col-sm-12 col-md-12 col-lg-12">
										<br>
										<div role="content">
											<div class="widget-body no-padding">
												<div
													class=" form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
													data-st-table="displayedCollection"
													data-st-safe-src="differentrecli">
													<table id="dt_basic"
														class="table table-striped table-bordered table-hover dataTable no-footer"
														role="grid" aria-describedby="dt_basic_info">
														<thead class="dataTables-Main-Head">
															<tr>
																<th class="sorting width_7" data-st-sort="">Opening
																	Balance</th>
																<th class="sorting width_7" data-st-sort="">Transaction
																	No</th>
																<th class="sorting width_7" data-st-sort="">Book
																	Cheque Date</th>
																<th class="sorting width_7" data-st-sort="">Book
																	Cheque No</th>
																<th class="sorting width_7" data-st-sort="">Book
																	Debit Amt</th>
																<th class="sorting width_7" data-st-sort="">Book
																	Credit Amt</th>
																<th class="sorting width_7" data-st-sort="">Closing
																	Balance</th>
																<th class="sorting width_7" data-st-sort="">Bank
																	Date</th>
															</tr>
															<tr ng-repeat="(trIndex, row) in reconsidate.differentrecli">
																<td colspan=1 class="width_1">{{row.openingBalance}}
																</td>
																<td colspan=1 class="width_1">{{row.transactionNo}}
																</td>
																<td colspan=1 class="width_1">{{row.bookChequeDate}}
																</td>
																<td colspan=1 class="width_1">{{row.bookChequeNo}}
																</td>
																<td colspan=1 class="width_1">{{row.bookDebitAmount}}
																</td>
																<td colspan=1 class="width_1">{{row.bookCreditAmount}}
																</td>
																<td colspan=1 class="width_1">{{row.closingBalance}}
																</td>
																<td colspan=1 class="width_1">{{row.bankDate}}
																</td>
															</tr>
													</table>
												</div>
											</div>
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