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
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-0">
		<br>
		<form class="form-horizontal" name="gradesalarylistForm"
								role="form" method="post" novalidate>
								<div class="row">
									<fieldset>
										<div class="col-sm-12 col-md-12 col-lg-12 ">
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-5 control-label"> Organization
														<span style="color: red;">*</span>
													</label>
													<div class="col-md-5">
														<!-- <selectivity list="companyList"
															property="gradePayComponenet.companyId" id="companyId"
															name="companyId" ng-if="companyList.length > 1"
															data-ng-model="gradePayComponenet.companyId"
															form-name="gradesalarylistForm" validation="required"
															friendly-name="Hospital"> </selectivity>
														<input type="text" class="form-control input-sm"
															ng-model="gradePayComponenet.companyName"
															form-name="gradesalarylistForm" validation="required"
															friendly-name="Hospital Name" name="Hospital Name"
															ng-if="companyList.length ==1" readonly>
													 -->
													 <selectivity list="companyList"
										property="gradePayComponenet.companyId" id="companyId"
										object="companyId"></selectivity></div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-6">
												<div class="form-group">
													<label class="col-md-5 control-label"> Grade <span
														style="color: red;">*</span></label>
													<div class="col-md-5">
														<selectivity list="gradeList"
															property="gradePayComponenet.gradeId" id="Grade Name"
															name="Grade" data-ng-model="gradePayComponenet.gradeId"
															form-name="gradesalarylistForm" validation="required"
															friendly-name="Grade"> </selectivity>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="row">
													<div class="col-sm-12 col-md-12 col-lg-12 ">
														<div class="col-md-5" style="margin-left: 49%;">
															<button class="btn btn-success" type="button"
																data-ng-click="submit1(gradePayComponenet,gradesalarylistForm)">
																Submit</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</fieldset>
								</div>
							</form>

							<div
								class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
								st-table="displayedCollection" st-safe-src="rowCollection">
							
								<!--  <div class="dt-toolbar" data-smart-include="views/layout/toolbar-header.tpl"></div> -->
								<table id="dt_basic"
									class="table table-striped table-bordered table-hover dataTable no-footer"
									role="grid" aria-describedby="dt_basic_info">
									<thead class="dataTables-Main-Head">
										<tr>
											<th st-sort="fromdate">Fromdate</th>
											<th st-sort="BASIC">BASIC</th>
											<th st-sort="HRA">HRA</th>
											<th st-sort="DA">DA</th>
											<th st-sort="CONVE">CONVE</th>
											<th st-sort="SPL">SPL</th>
											<th st-sort="CONS">CONS</th>
											<th st-sort="OTEAR">Other Earnings</th>
											<th st-sort="GROSS">Gross Pay</th>
											<th st-sort="MEDIC">MEDIC</th>
											<th st-sort="PFSEL">PFSEL</th>
											<th st-sort="WF">WF</th>
											<!-- <th st-sort="NET">Net Pay</th> -->
											<th st-sort="">Action</th>
										</tr>
									</thead>
									<tbody class="dataTables-Main-Body">
										<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
											ng-repeat="gradeComponentList in displayedCollection">
											<td>{{gradeComponentList.fromdate}}</td>
											<td>{{gradeComponentList.BASIC}}</td>
											<td>{{gradeComponentList.HRA}}</td>
											<td>{{gradeComponentList.DA}}</td>
											<td>{{gradeComponentList.CONVE}}</td>
											<td>{{gradeComponentList.SPL}}</td>
											<td>{{gradeComponentList.CONS}}</td>
											<td>{{gradeComponentList.OTEAR}}</td>
											<td>{{gradeComponentList.GROSS}}</td>
											<td>{{gradeComponentList.MEDIC}}</td>
											<td>{{gradeComponentList.PFSEL}}</td>
											<td>{{gradeComponentList.WF}}</td>
											<!-- <td>{{gradeComponentList.NET}}</td> -->
											<td class=" td-actions text-center"><security:authorize
													access="hasRole('${form_code}_${modify}')">
													<span> <i
														ng-if="gradeComponentList.fromdate==gradePayComponenet.largeDateValue"
														class="fa  fa-pencil text-success text"
														data-ng-click="editRow(gradeComponentList.employeeId,gradeComponentList.fromdate)"></i>
													</span>
												</security:authorize> <security:authorize
													access="hasRole('${form_code}_${delete}')">
													<span> <i
														ng-if="gradeComponentList.fromdate==gradePayComponenet.largeDateValue"
														class="fa fa-trash-o text-danger-dker text"
														data-ng-click="deleteRow(gradeComponentList.employeeId,gradeComponentList.fromdate)"></i>
													</span>
												</security:authorize></td>
										</tr>
									</tbody>
								</table>
									<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
							</div>
						</div>
					</div>
				</div>
				<!-- end widget -->
			</article>
			<!-- WIDGET END -->
		</div>
	</section>
</div>