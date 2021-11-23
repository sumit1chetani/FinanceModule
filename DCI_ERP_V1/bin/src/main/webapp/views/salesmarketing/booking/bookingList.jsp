<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="wrapper-md">
			<style>
button.btn.btn-success.help-button {
	position: absolute;
	right: 700px;
	background-color: #ff0000c4 !important;
}
</style>
			<div class="panel panel-default panel-default-form ">
				<div class="panel-body">
					<form name="bookingListForm" method="post" class="form-horizontal"
						novalidate>
						<div class="row pl2pc pr10pc">

							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer</label>
									<div class="col-md-7">
										<selectivity list="customerList" ng-model="booking.customer"
											property="booking.customer" id="customer" name="customer"
											form-name="bookingListForm" friendly-name="customer"></selectivity>

									</div>
								</div>
							</div>
							
														<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel</label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="booking.vessel"
										validation="required" friendly-name="vessel"
											property="booking.vessel" id="vessel" name="vessel"
											form-name="bookingListForm" ></selectivity>

									</div>
								</div>
							</div>
							
														<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="booking.voyage"
											property="booking.voyage" id="voyage" name="voyage"
											form-name="bookingListForm" friendly-name="voyage"></selectivity>

									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">POL </label>
									<div class="col-md-7">
										<selectivity list="polList" ng-model="booking.pol"
											property="booking.pol" id="pol" name="pol"
											form-name="bookingListForm" friendly-name="pol"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">POD </label>
									<div class="col-md-7">
										<selectivity list="podList" ng-model="booking.pod"
											property="booking.pod" id="pod" name="pod"
											form-name="bookingListForm" friendly-name="pod"></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking No </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											name="bookingNo" id="bookingNo" ng-model="booking.bookingNo"
											friendly-name="bookingNoss" />
									</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">CRO Status </label>
									<div class="col-md-7">
										<selectivity list="statusList" ng-model="booking.status"
											property="booking.status" id="status" name="status"
											form-name="bookingListForm" friendly-name="status"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">BL Status </label>
									<div class="col-md-7">
										<selectivity list="statusList" ng-model="booking.blStatus"
											property="booking.blStatus" id="status" name="blStatus"
											form-name="bookingListForm" friendly-name="blStatus"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Invoice Status </label>
									<div class="col-md-7">
										<selectivity list="statusList"
											ng-model="booking.invoiceStatus"
											property="booking.invoiceStatus" id="invoiceStatus"
											name="invoiceStatus" form-name="bookingListForm"
											friendly-name="invoiceStatus"></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 i-checks m-b-none"
										style="padding-left: 119px; padding-top: 6px;"> <input
										type="checkbox" ng-model="booking.checked"
										id="select{{trIndex}}" ng-change="check(booking.checked)">
										<i></i></label> <label class="col-md-5 control-label"
										style="padding-right: 80px;">Cancelled </label>

								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-3" ng-if="booking.checked == true">
									<div class="form-group">
										<label class="col-md-5 control-label">From Date<span
											style="color: red;"></span>
										</label>
										<div class="col-md-7">
											<ng-bs3-datepicker data-ng-model="booking.fromDate"
												id="fromDate" name="fromDate" form-name="bookingListForm"
												friendly-name="fromDate" />
										</div>
									</div>
								</div>
								<div class="col-md-3" ng-if="booking.checked == true">
									<div class="form-group">
										<label class="col-md-5 control-label">To Date </label>
										<div class="col-md-7">
											<ng-bs3-datepicker data-ng-model="booking.toDate" id="toDate"
												name="toDate" form-name="bookingListForm"
												friendly-name="toDate" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /row -->
						<div class="form-actions text-center">
							<div class="row ">
								<div class="col-md-offset-3 col-md-5">
									<!-- <button class="btn btn-success help-button" type="button" data-ng-click="tdsHelpVideo('BookingVideo.mp4','BookingVideo')">
<i class="fa fa-video-camera"></i>
Help Video
</button> -->
									<button class="btn btn-success help-button" type="button"
										data-ng-click="tdsHelpVideo('BookingVideo.mp4','BookingVideo')">
										<i class="fa fa-video-camera"></i> Help Video
									</button>

									<button class="btn btn-success" type="button"
										ng-click="getBookingList()">
										<i class="fa fa-search"></i> Search
									</button>
									<button class="btn btn-info" type="button"
										data-ng-click="reset(containerReportForm)">
										<i class="fa fa-undo"></i> Reset
									</button>
									<button class="btn btn-primary" type="button"
										data-ng-click="exportExcel()">
										<span class="fa fa-file-excel-o"> Export Excel with
											details</span> <a id="Export" stype="display:none"
											href="filePath/BookingDetails.xls"
											download="BookingDetails.xls"></a>


									</button>

									<button class="btn btn-primary" type="button"
										data-ng-click="exportExcel1()">
										<span class="fa fa-file-excel-o"> Export Excel</span> <a
											id="newExport" stype="display:none"
											href="filePath/Booking.xls" download="Booking.xls"></a>


									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<%-- <%@include file="/views/templates/panel-header.jsp"%>
--%>
		<div class="panel-body float-left padding-0" style="width: 100%">
			
		<div class="panel-body float-left padding-0" style="width: 100%">
			<div class="table-responsive" style="border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head"
						style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting" st-sort="bookingNo">Booking</th>
							<th class="sorting" st-sort="bookingDate">Booking Date</th>
							<th class="sorting" st-sort="customer">Customer</th>
							<th class="sorting" st-sort="quotation">Quotation No</th>
							<th class="sorting" st-sort="vessel">Vessel</th>
							<th class="sorting" st-sort="voyage">Voyage</th>
							<th class="sorting" st-sort="pol">POL</th>
							<th class="sorting" st-sort="pod">POD</th>
							
							<th ng-if="!checked1" class="sorting" st-sort="croStatus">CRO
								Status</th>
							<th ng-if="!checked1" class="sorting" st-sort="croStatus">BL
								Status</th>
							<th ng-if="!checked1" class="sorting" st-sort="croStatus">Invoice
								Status</th>
							<th ng-if="checked1" class="sorting" st-sort="croStatus">Cancel
								Remarks</th>
							<th ng-if="checked1" class="sorting" st-sort="croStatus">Cancel
								By</th>
							<th ng-if="checked1" class="sorting" st-sort="croStatus">Cancel
								Date</th>


							<th class="text-center">Action </th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="booking in displayedCollection">


							<td><a ng-click="viewBooking(booking.bookingNo)"> <span
									tooltip="{{booking.bookingNo}}" class="tool-tip-span font-blue">{{booking.bookingNo}}</span>
							</a> <span ng-if="booking.urIsView=='f'"> <span
									tooltip="{{booking.bookingNo}}" class="tool-tip-span">{{booking.bookingNo}}</span>
							</span></td>
							<!-- <td>{{booking.bookingNo}}</td> -->
							<td>{{booking.bookingDate}}</td>
							<td>{{booking.customer}}</td>
							<td>{{booking.quotation}}</td>
							<td>{{booking.vessel}}</td>
							<td>{{booking.voyage}}</td>
							<td>{{booking.pol}}</td>
							<td>{{booking.pod}}</td>
							
							<td ng-if="!checked1">{{booking.croStatus}}</td>
							<td ng-if="!checked1">{{booking.blStatus}}</td>
							<td ng-if="!checked1">{{booking.invoiceStatus}}</td>
							<td ng-if="checked1">{{booking.cancel_remarks}}</td>
							<td ng-if="checked1">{{booking.cancel_by}}</td>
							<td ng-if="checked1">{{booking.cancel_dt}}</td>
							<td class="td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span
										ng-if="booking.croStatus=='Pending' && (booking.cancel_by == null || booking.cancel_by == '')">
										<i class="fa fa-share-square text-success text"
										data-toggle="tooltip" title="Issue CRO"
										data-ng-click="createCRO(booking.bookingNo)"></i>
									</span>&nbsp;&nbsp; 
</security:authorize> <security:authorize access="hasRole('${form_code}_${modify}')">
									<span
										ng-if="booking.cancel_by == null || booking.cancel_by == ''">
										<i class="fa fa-close text-danger-dker text"
										aria-hidden="true" data-toggle="tooltip"
										title="Cancel Booking"
										data-ng-click="cancelBooking(booking.bookingNo)"></i>
									</span>&nbsp;&nbsp; 
</security:authorize> <security:authorize access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										data-ng-click="editBooking(booking.bookingNo,booking.croStatus,booking.cancelValue)"></i>
									</span>&nbsp;&nbsp; 
</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-toggle="tooltip" title="Delete"
										data-ng-click="deleteBooking(booking.bookingNo)"></i>
									</span>&nbsp;&nbsp; 
</security:authorize>
<span> <i class="fa fa-expand"
										data-toggle="tooltip" title="Allocated Containers"
										data-ng-click="viewContainers(booking)"></i>
									</span>&nbsp;&nbsp; 
 

</td>
						</tr>
						<tr x-ng-show="showEmptyLabel">
							<td colspan="6" class="text-center">No Records Found</td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer" style="padding: 0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div>
</div>

<script type="text/ng-template" id="deliveryOrderpop"> 
<div class="model-header"></div>
<legend>Cancel Booking</legend>
<form class="" method="POST" name="bookingListFormNew" novalidate>

<div class="col-sm-12 col-md-12 col-lg-12 ">


<div class="col-sm-6 col-md-6 col-lg-6 ">
<div class="form-group">
<label class="control-label">Booking Cancel Reason</label>
<textarea class="form-control" type="text" name="bookingcancelreason" 
id="bookingcancelreason" ng-model="booking.bookingcancelreason" form-name="bookingListFormNew" style="margin-top: 0px;margin-bottom: 0px;height: 120px;width: 220%;"></textarea>
</div>
</div>	

</div>
<div class="model-footer" style="padding-left:35%;padding-top:17%">
<button type="button" class="btn btn-success"
ng-click="saveData(bookingListFormNew)">Confirm Cancel Booking</button>
<button class="btn btn-danger" ng-click="closeUpload()">Cancel</button>
</div>
</div>
</form
</div>



</script>