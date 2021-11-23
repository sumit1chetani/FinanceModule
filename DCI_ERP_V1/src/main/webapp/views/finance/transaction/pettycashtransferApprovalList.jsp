<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id" />

		<div class="panel-body float-left padding-0" style="width:100%">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="sorting width_35" st-sort="transferFrom">Transfer
								From</th>
							<th class="sorting width_35" st-sort="transferTo">Transfer
								To</th>
							<th class="sorting width_35" st-sort="transferDate">Transfer
								Date</th>
							<th class="sorting width_35" st-sort="amount">Amount</th>

							<th class="sorting width_35">Action</th>


						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objpettyCashBean in displayedCollection">
							<td class="sorting">{{objpettyCashBean.transferFrom}}</td>
							<td class="sorting">{{objpettyCashBean.transferTo}}</td>
							<td class="sorting">{{objpettyCashBean.transferDate}}</td>

							<td class="sorting">{{objpettyCashBean.amount}}</td>
							<td class="td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span class="width_15"
										data-ng-if="objpettyCashBean.status =='Pending' ">
										<i class="fa fa-pencil text-success text"
										data-ng-click="editRow(objpettyCashBean.interCompanyPettyCashId)"
										tooltip="Edit"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span class="width_15"
										ng-if="objpettyCashBean.status == 'Pending'"> <i
										class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(objpettyCashBean.interCompanyPettyCashId,$index)"
										tooltip="Delete"></i>
									</span>
								</security:authorize></td>
						</tr>
					</tbody>
				</table>
			</div>


			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer.jsp"%>
			</footer>
		</div>
	</div>
</div>
</div>