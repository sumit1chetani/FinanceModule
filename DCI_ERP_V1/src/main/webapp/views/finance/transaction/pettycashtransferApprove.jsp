<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="lrowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id" />

		<div class="panel-body float-left padding-0" style="width:100%">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="sorting width_35" st-sort="transferFrom">Transfer
								From</th>

							<th class="sorting width_35" st-sort="transferDate">Transfer
								Date</th>
							<th class="sorting width_35" st-sort="amount">Amount</th>

							<th class="sorting width_35" st-sort="amount">Transfer Status</th>

							<th class="sorting width_35">Select</th>


						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objpettyCashBean in displayedCollection">
							<td class="sorting">{{objpettyCashBean.transferFrom}}</td>
							<td class="sorting">{{objpettyCashBean.transferDate}}</td>

							<td class="sorting">{{objpettyCashBean.amount}}</td>
							<td class="sorting">{{objpettyCashBean.status}}</td>

							<td ng-if='objpettyCashBean.status=="Pending"'><label
								class="i-checks m-b-none"> <input type="checkbox"
									ng-model="objpettyCashBean.check"><i></i></label></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="col-md-12">
				<div class="content">
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" type="button"
									ng-click="approvePettyCash(lrowCollection)">
									<i class="fa fa-save"></i> Accept
								</button>

								<button class="btn btn-danger"
									ng-click="rejectPettyCash(lrowCollection)" type="button">
									<i class="fa fa-close"></i> Reject
								</button>
							</div>
						</div>
					</div>
				</div>

			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer.jsp"%>
			</footer>
		</div>
	</div>
</div>
