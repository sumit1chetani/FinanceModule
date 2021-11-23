

<style>
.onGoingHdCls>.panel-heading {
	border-color: #eff2f7;
	background: #fff;
	background: #ddd;
	color: #767676;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">



	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<br>


		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default onGoingHdCls">
					<div class="panel-heading" style="height: 37px;">
						<h3 class="panel-title" style="margin-top: 8px;">Completed
							Trip</h3>
						<div class="actions pull-right List">

							<i data-fullscreen-widget class="fa fa-expand"></i> <i
								data-widget-toggle class="fa fa-chevron-down"></i>

						</div>
					</div>

					<div class="panel-body">


						<div class="panel panel-default panel-default-list"
							st-table="displayedCollection" st-safe-src="rowCollection">
							<%-- 		<%@include file="/views/templates/panel-header.jsp"%>
 --%>
							<div class="panel-body padding-0">
								<div class="table-responsive ">

									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>

												<th class="sorting" st-sort="shortName">Trip</th>

												<th class="sorting" st-sort="countryName">Truck</th>
												<th class="sorting" st-sort="countryName">From Location</th>
												<th class="sorting" st-sort="countryName">To Location</th>

												<th class="sorting" st-sort="landMark">Revenue</th>

												<th class="sorting" st-sort="type">Cost</th>

												<th class="sorting" st-sort="description">P&L</th>


											</tr>
										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="completedTrip in displayedCollection">

												<td>{{completedTrip.tripNo}}</td>
												<td>{{completedTrip.truck}}</td>
												<td>{{completedTrip.fromLocation}}</td>
												<td>{{completedTrip.toLocation}}</td>
												<td>{{completedTrip.revenue}}</td>
												<td>{{completedTrip.cost}}</td>
												<td>{{completedTrip.pl}}</td>

											</tr>
										</tbody>
									</table>
								</div>
								<footer class="panel-footer">
									<%@include file="/views/templates/panel-footer-static.jsp"%>
								</footer>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

		<br>

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default onGoingHdCls">
					<div class="panel-heading" style="height: 37px;">
						<h3 class="panel-title" style="margin-top: 8px;">On Going
							Trip</h3>
						<div class="actions pull-right List">

							<i data-fullscreen-widget class="fa fa-expand"></i> <i
								data-widget-toggle class="fa fa-chevron-down"></i>

						</div>
					</div>

					<div class="panel-body">


						<div class="panel panel-default panel-default-list"
							st-table="displayedCollection1" st-safe-src="rowCollection1">
							<%-- 		<%@include file="/views/templates/panel-header.jsp"%>
 --%>
							<div class="panel-body padding-0">
								<div class="table-responsive ">

									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>

												<th class="sorting" st-sort="shortName">Trip</th>

												<th class="sorting" st-sort="countryName">Truck</th>
												<th class="sorting" st-sort="countryName">From Location</th>
												<th class="sorting" st-sort="countryName">To Location</th>

												<th class="sorting" st-sort="landMark">Revenue</th>

												<th class="sorting" st-sort="type">Cost</th>

												<th class="sorting" st-sort="description">P&L</th>


											</tr>
										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="ongoingtrip in displayedCollection1">

												<td>{{ongoingtrip.tripNo}}</td>
												<td>{{ongoingtrip.truck}}</td>
												<td>{{ongoingtrip.fromLocation}}</td>
												<td>{{ongoingtrip.toLocation}}</td>
												<td>{{ongoingtrip.revenue}}</td>
												<td>{{ongoingtrip.cost}}</td>
												<td>{{ongoingtrip.pl}}</td>

											</tr>
										</tbody>
									</table>
								</div>
								<footer class="panel-footer">
									<%@include file="/views/templates/panel-footer-static.jsp"%>
								</footer>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

		<div class="form-actions">
			<div class="row">
				<div class="col-md-12 ">

					<button class="btn btn-danger" ng-click="cancel()" type="button">
						<i class="fa fa-close"></i> Cancel
					</button>

				</div>
			</div>
		</div>
		<!-- end widget content -->
	</div>
</div>