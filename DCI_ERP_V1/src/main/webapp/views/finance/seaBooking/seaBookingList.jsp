<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body padding-10">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="sorting" st-sort="bookingNo">Booking No</th>
							<th class="sorting" st-sort="bookingDate">Booking Date</th>
							<th class="sorting" st-sort="mloName">Customer</th>
							<th class="sorting" st-sort="lolName">LOL</th>
							<th class="sorting" st-sort="lodName">LOD</th>
							<th class="sorting" st-sort="conType">Con.Quantity</th>
							<th class="sorting" st-sort="conType">Quotation No</th>
							<th class="sorting" st-sort="status">Status</th>
							<th class="text-center">ACTION</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="booking in displayedCollection">
							<!-- <td class=""><label class="i-checks m-b-none"> <input
									type="checkbox" name="post[]" data-ng-model="objItem.isSelect">
									<i></i>
							</label></td> -->

							<td><a data-ng-click="viewBooking(booking.bookingId)">  <security:authorize access="hasRole('${form_code}_${view}')"><span tooltip="{{booking.status}}" class="tool-tip-span font-blue">{{booking.bookingNo}}</span></security:authorize></a> </td>
							<td>{{booking.bookingDate}}</td>
							<td>{{booking.mloName}}</td>
							<td>{{booking.lolName}}</td>
							<td>{{booking.lodName}}</td>
							<td>{{booking.conType}}</td>
							<td>{{booking.quotationNo}}</td>
							<td><a ng-click="viewAllocatedTrips(booking.bookingId)">
								  <security:authorize access="hasRole('${form_code}_${view}')">	<span tooltip="{{booking.status}}" class="tool-tip-span font-blue">{{booking.status}}</span>
								  </security:authorize> </a></td>
							<td class="td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i
										class="fa  fa-pencil text-success text"
										data-ng-click="editBooking(booking.bookingId,booking.status)"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i
										class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteBooking(booking.bookingId)"></i>
									</span>
								</security:authorize></td>
						</tr>
						<tr x-ng-show="showEmptyLabel">
							<td colspan="6" class="text-center">No Records Found</td>
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
