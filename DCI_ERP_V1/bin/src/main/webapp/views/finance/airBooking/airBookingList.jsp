<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body padding-0">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<th class="sorting" st-sort="bookingNo">BOOKING NO</th>
							<th class="sorting" st-sort="bookingDate">BOOKING DATE</th>
							<th class="sorting" st-sort="mloName">CUSTOMER</th>
							<th class="sorting" st-sort="lolName">AOL</th>
							<th class="sorting" st-sort="lodName">AOD</th>
							<th class="sorting" st-sort="conType">ORIGIN</th>
							<th class="sorting" st-sort="conType">DESTINATION</th>
							<th class="sorting" st-sort="status">CREATED BY</th>
							<th class="sorting" st-sort="status">CREATED DATE</th>
							<th class="sorting" st-sort="status">MODIFIED BY</th>
							<th class="sorting" st-sort="status">MODIFIED BY</th>
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

							<td><a data-ng-click="viewBooking(booking.bookingId)">  <security:authorize access="hasRole('${form_code}_${view}')"><span class="tool-tip-span font-blue">{{booking.bookingNo}}</span></security:authorize></a> </td>
							<td>{{booking.bookingDt}}</td>
							<td>{{booking.custName}}</td>
							<td>{{booking.aolName}}</td>
							<td>{{booking.aodName}}</td>
							<td>{{booking.originName}}</td>
							<td>{{booking.destinationName}}</td>
							<td>{{booking.createdBy}}</td>
							<td>{{booking.createdOn}}</td>
							<td>{{booking.modifiedBy}}</td>
							<td>{{booking.modifiedOn}}</td>
							 
							<td class="td-actions text-center">
							
<%-- 							<SECURITY:AUTHORIZE	ACCESS="HASROLE('${FORM_CODE}_${MODIFY}')"> --%>
									<span> <i
										class="fa  fa-pencil text-success text"
										data-ng-click="editBooking(booking.bookingId)"></i>
									</span>
<%-- 								</security:authorize>  --%>
								<security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i
										class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteBooking(booking.bookingId)"></i>
									</span>
									
										<span> <i class="fa  fa-print text-success text"
										data-ng-click="print(booking.bookingId)"></i>
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
