

<style>
.ngdialog.ngdialog-theme-default .ngdialog-content {
	max-width: 100%;
	width: 530px;
	position: center;
	top: 20%;
	left: 0px;
	margin-top: -50px;
}

select {
	-webkit-appearance: none;
	padding: 0;
	text-indent: 8px;
	padding: 0 !important;
}
</style>

<div class="padding-0" style="width: 89%; margin-left: 6%;">
	<div class="panel panel-default padding-0"
		style="margin-top: 0%; margin-left: -32px; margin-right: -26px;">
		<div align="center" class="panel-heading font-bold"
			style="color: white">WORKSHOP SERVICE LOG</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="col-md-6"></div>
					<div class="wrapper-md">
						<div class="panel panel-default panel-default-list"
							st-table="displayedCollection" st-safe-src="SummaryList">
							<div class="panel-body float-left padding-0" style="width: 100%;">
								<div class="table-responsive ">
									<table
										class="table table-striped table-hover dataTable no-footer">
										<thead class="dataTables-Main-Head">
										<div align="center" class="panel-heading font-bold " style="color: blue">{{SummaryList.truck}}</div>
											
											<tr>

												<th class=" width_3" st-sort="status">Status</th>

												<th class=" width_5" st-sort="approvedDate">
													Date</th>


											</tr>
										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="summary in SummaryList">

												<td>{{summary.status}}</td>

												<td>{{summary.approvedDate}}</td>




											</tr>
											<tr x-ng-show="showEmptyLabel">
												<td colspan="6" class="text-center">No Records Found</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">

						<button class="btn btn-danger" type="reset"
							class="btn btn-success" ng-click="closeThisDialog('button')">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>