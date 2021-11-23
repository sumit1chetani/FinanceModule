
<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
 
 <div class="panel-body float-left padding-0" style="width: 100%;">

						<div class="widget-body no-padding">
						<div class="panel-body">
					<form class="form-horizontal" novalidate>
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<fieldset>
									

									<div class="col-sm-4 col-md-4 col-lg-4">
										<div class="form-group">
											<label class="col-md-6 control-label">Organization</label>
											<div class="col-md-5">
									
										<selectivity list="companyList"
														ng-model="paymentorder.companyCode"
														property="paymentorder.companyCode"
														id="companyCodeId{{trIndex}}"></selectivity>
								</div>
										</div>
									</div>
									
									<div class="col-sm-4 col-md-4 col-lg-4">
										<div class="form-group">
											<label class="col-md-6 control-label"> </label>
											<button class="btn btn-success" type="button"
										data-ng-click="search(paymentorder.companyCode);">
										<i class="fa fa-search"></i> Search
									</button>
										</div>
									</div>

								</fieldset>
							</div>
						</div>
						
					</form>
				</div>
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
												<th colspan="1" class="sorting width_2" st-sort="entityName">Supplier</th>
												<th colspan="1" class="sorting width_2"
													st-sort="paymentOrderNo">PO No</th>
												<th colspan="1" class="sorting width_5"
													st-sort="paymentOrderDate">Date</th>
<!-- 												<th colspan="1" class="sorting width_5" st-sort="currency">Currency</th>
 -->												
<!--  <th colspan="1" class="sorting width_5" st-sort="exRate">Rate</th>
 -->										<!-- 		<th colspan="1" class="sorting width_5" st-sort="poTcamt">TC
													Amount</th> -->
												<th class="sorting width_3" st-sort="poBcamt">
													Amount</th>
												<th class="sorting width_3" st-sort="companyCode">Organization Name</th>
												<th  class="sorting width_3" st-sort="acctHead">Account</th>
<!-- 												<th colspan="1" class="sorting width_5" st-sort="cashPaycurrency">Currency</th>
 -->												<!-- <th colspan="1" class="sorting width_5"
													st-sort="cashPayExRate">Rate</th> -->
												<!-- <th colspan="1" class="sorting width_5"
													st-sort="cashPayBcAmt">BC Amount</th>
												<th colspan="1" class="sorting width_5"
													st-sort="cashPayTcAmt">TC Amount</th> -->
<!-- 												<th colspan="1" class="sorting width_5" st-sort="chequeId">Chq.No</th>
												<th colspan="1" class="sorting width_5"
													st-sort="chequeDate">Cheque Date</th> -->
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
												<td>{{parameterCollection.paymentOrderNo}}</td>
												<td>{{parameterCollection.paymentOrderDate}}</td>
<!-- 												<td>{{parameterCollection.currency}}</td>
 -->												
<!--  <td>{{parameterCollection.exRate}}</td>
 --><!-- 												<td>{{parameterCollection.poTcamt}}</td>
 -->												<td align ="right">{{parameterCollection.poBcamt|number:2}}</td>
												<td><selectivity list="companyList"
														ng-model="parameterCollection.companyCode"
														property="parameterCollection.companyCode"
														id="companyCodeId{{trIndex}}"></selectivity></td>
												<td><selectivity list="cahbankList"
														ng-model="parameterCollection.acctHead"
														property="parameterCollection.acctHead"
														id="acctHeadId{{trIndex}}"></selectivity></td>
<!-- 												<td>{{parameterCollection.cashPaycurrency}}</td>
 -->												
<!--  <td>{{parameterCollection.cashPayExRate}}</td>
 -->											
												<!-- <td><input type="text"
													ng-model="parameterCollection.cashPayBcAmt" disabled></td>
												<td><input type="text"
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
								<!-- <div class="dt-toolbar-footer"
									data-smart-include="views/layout/toolbar-footer.tpl"></div> -->
									
									<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
							</div>
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<%-- <security:authorize
											access="hasRole('${form_code}_${approve}')"> --%>
											<button class="btn btn-danger" ng-click="generatePayment()"
												type="button">Generate Payment</button>
<%-- 										</security:authorize>
 --%>									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
</div>