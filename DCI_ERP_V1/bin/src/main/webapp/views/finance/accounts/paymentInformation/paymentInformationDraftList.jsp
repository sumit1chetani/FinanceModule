<!-- #MAIN CONTENT -->
<%-- <style type="text/css">
</style>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div id="content">
	<!-- widget grid -->
	<section widget-grid id="widget-grid">
		<div class="row">
			<article class="col-sm-12">
				<div jarvis-widget id="standard-datatable-widget"
					data-widget-color="sttropaz" data-widget-editbutton="false"
					data-widget-deletebutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span> <span><state-breadcrumbs></state-breadcrumbs> </span>
					</header> --%>
					
					
					
					<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
					
					
					<div role="content">
						<div class="widget-body no-padding">
							<div
								class="table table-striped table-bordered table-hover dataTable no-footer"
								role="grid" aria-describedby="dt_basic_info"
								st-table="displayedCollection" st-safe-src="rowCollection">
								<div style="min-width: 100%; overflow-x: scroll">
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info"
										style="min-width: 180%;">
										<thead class="dataTables-Main-Head">
											<tr>
												<th class="width_1 table-heading"><label
													style="margin-left: 20%;" class="i-checks m-b-none">
														<input type="checkbox" ng-model="selectedAll"
														ng-change="checkAll(displayedCollection,selectedAll)">
														<i></i>
												</label></th>
												<th colspan="1" class="sorting width_5" st-sort="entityName">Supplier</th>
												<th colspan="1" class="sorting width_5" st-sort="entityName">Ref Invoice</th>
												
												<th colspan="1" class="sorting width_5"
													st-sort="paymentOrderNo">PO No</th>
												<th colspan="1" class="sorting width_5"
													st-sort="paymentOrderDate">Date</th>
												<th colspan="1" class="sorting width_5" st-sort="currency">Currency</th>
												<th colspan="1" class="sorting width_5" st-sort="action">Rate</th>
												<th colspan="1" class="sorting width_5" st-sort="poTcamt">Amount
													</th>
												<!-- <th colspan="1" class="sorting width_5" st-sort="poBcamt">BC
													Amount</th> -->
												<th class="sorting width_8" st-sort="companyCode"><spring:message
														code="label.company.name"></spring:message></th>
												<th colspan="1" class="sorting width_8" st-sort="acctHead">Account</th>
												<th colspan="1" class="sorting width_5" st-sort="status">Currency</th>
												<th colspan="1" class="sorting width_5"
													st-sort="cashPayExRate">Rate</th>
												<th colspan="1" class="sorting width_5"
													st-sort="cashPayBcAmt">Amount</th>
										<!-- 		<th colspan="1" class="sorting width_5"
													st-sort="cashPayTcAmt">TC Amount</th> -->
												<th colspan="1" class="sorting width_5" st-sort="chequeId">Chq.No</th>
												<th colspan="1" class="sorting width_5"
													st-sort="chequeDate">Cheque Date</th>
											</tr>
										</thead>
										<tbody data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="(trIndex, parameterCollection)  in displayedCollection"
											ng-controller="tableCtrl">
											<tr>
												<td><label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="parameterCollection.select">
														<i></i>
												</label></td>
												<td>{{parameterCollection.entityName}}</td>
												<td>{{parameterCollection.invoiceref}}</td>
												<td>{{parameterCollection.paymentOrderNo}}</td>
												<td>{{parameterCollection.paymentOrderDate}}</td>
												<td>{{parameterCollection.currency}}</td>
												<td>{{parameterCollection.exRate}}</td>
												<td>{{parameterCollection.poTcamt}}</td>
<!-- 												<td>{{parameterCollection.poBcamt}}</td>
 -->												<td><selectivity list="companyList"
														ng-model="parameterCollection.companyCode"
														property="parameterCollection.companyCode"
														id="companyCodeId{{trIndex}}"></selectivity></td>
												<td><selectivity list="cahbankList"
														ng-model="parameterCollection.acctHead"
														property="parameterCollection.acctHead"
														id="acctHeadId{{trIndex}}"></selectivity></td>
												<td>{{parameterCollection.cashPaycurrency}}</td>
												<td>{{parameterCollection.cashPayExRate}}</td>
												<td><input type="text"
													ng-model="parameterCollection.cashPayBcAmt" disabled></td>
												<!-- <td><input type="text"
													ng-model="parameterCollection.cashPayTcAmt" disabled>
												</td> -->
												<td><selectivity list="chequeList"
														ng-model="parameterCollection.chequeId"
														property="parameterCollection.chequeId"
														id="chequeId{{trIndex}}" disabled="isCheque"></selectivity></td>
												<td>
													<div class="input-group date datetimepick col-md-12">
														<div class="dropdown">
															<a class="dropdown-toggle" id="chequeDate{{trIndex}}"
																role="button" data-toggle="dropdown" data-target="#"
																href="#">
																<div class="input-group">
																	<input type="text" class="form-control"
																		placeholder="dd/mm/yyyy"
																		name="{{ 'chequeDate' + trIndex }}"
																		id="{{ 'chequeDate' + trIndex }}"
																		data-ng-model="parameterCollection.chequeDate"
																		> <span
																		class="input-group-addon"> <i
																		class="glyphicon glyphicon-calendar"></i>
																	</span>
																</div>
															</a>
															<ul class="dropdown-menu" role="menu"
																aria-labelledby="dLabel" ng-if="!isCheque">
																<datetimepicker
																	data-ng-model="parameterCollection.chequeDate"
																	data-on-set-time="parameterCollection.chequeDate = onDateSet(newDate)"
																	data-datetimepicker-config="{ dropdownSelector: '#chequeDate{{trIndex}}',startView:'day', minView:'day'}" />
															</ul>
														</div>
													</div>
												</td>

											</tr>
										</tbody>
									</table>
								</div>
								<div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div>
							</div>
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										
											<button class="btn btn-primary" ng-click="generatePayment()"
												type="button">Generate Bank Payment</button>
												
												
											<button class="btn btn-danger" ng-click="cancel()"
												type="button">Cancel</button>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>