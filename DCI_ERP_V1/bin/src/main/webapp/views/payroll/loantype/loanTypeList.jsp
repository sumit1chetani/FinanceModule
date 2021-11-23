
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive " style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
											<tr>
												<!--  <th class="width_1"></th> -->
												<th class="sorting width_10" st-sort="loanTypeId">Loan
													Type ID</th>
												<th class="sorting width_10" st-sort="loanTypeName">Loan
													Type </th>
												<th class="sorting width_10" st-sort="interestRate">Interest
													Rate</th>
												<th class="sorting width_10" st-sort="flatOrDiminishing">Flat
													/ Diminishing</th>
												<th class="sorting width_10" st-sort="status">Status</th>
												<th class="sorting width_10" st-sort="">Action</th>
											</tr>

										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="loantypeitem in displayedCollection">

												<td>{{loantypeitem.loanTypeId}}</td>
												<td>{{loantypeitem.loanTypeName}}</td>
												<td>{{loantypeitem.interestRate}}</td>
																		<td>{{loantypeitem.fod}}</td>
											<%-- 	<td><span ng-if="loantypeitem.flatOrDiminishing == '0'">
														- </span> <span ng-if="loantypeitem.flatOrDiminishing == '1'"><spring:message
															code="label.loantype.flat"></spring:message></span> <span
													ng-if="loantypeitem.flatOrDiminishing == '2'"><spring:message
															code="label.loantype.diminishing"></spring:message></span></td> --%>
												<td><input type="checkbox" checked="checked"
													disabled="disabled" ng-model="loantypeitem.status">
												</td>
												<td class=" td-actions text-left">
														<span> <i class="fa fa-pencil text-success text"
															data-ng-click="editRow(loantypeitem.loanTypeId)"></i>
														</span>
											
														<span> <i
															class="fa fa-trash-o text-danger-dker text"
															data-ng-click="deleteRow(loantypeitem.loanTypeId)"></i>
														</span>
													</td>
											</tr>
										</tbody>
									</table>
								
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
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
