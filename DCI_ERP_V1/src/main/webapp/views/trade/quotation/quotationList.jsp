<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="panel panel-default panel-default-list"
	st-table="displayedCollection" st-safe-src="rowCollection">
	<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
	<%@include file="/views/templates/panel-header.jsp"%>
	<!-- </div> -->
	<div class="wrapper-md">
		<style>
button.btn.btn-success.help-button {
	position: absolute;
	right: 700px;
	background-color: #ff0000c4 !important;
}
</style>

		<div class="panel panel-default panel-default-form ">
			<%--  <div class="panel panel-default panel-default-form ">
		<%@include file="/views/layout/panel-header-form.jsp"%> --%>
			<div class="panel-body">
				<form name="userLogForm" method="post" class="form-horizontal"
					novalidate>
					<div class="row pl2pc pr10pc">

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Customer</label>
								<div class="col-md-7">
									<selectivity list="custmerList" ng-model="quotation.customer"
										property="quotation.customer" id="customer" name="customer"
										form-name="quotationForm" friendly-name="customer"></selectivity>

								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">POL</label>
								<div class="col-md-7">
									<selectivity list="portList" property="quotation.pol" id="pol"
										ng-model="quotation.pol" name="pol" form-name="quotationForm"
										friendly-name="pol"></selectivity>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">FPOD</label>
								<div class="col-md-7">
									<selectivity list="portList" property="quotation.pod" id="pod"
										ng-model="quotation.pod" name="pod" form-name="quotationForm"
										friendly-name="pod"></selectivity>
								</div>
							</div>
						</div>

					</div>
					<div class="row pl2pc pr10pc">

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Customer Category</label>
								<div class="col-md-7">
									<selectivity list="custCatList"
										ng-model="quotation.custcategory"
										property="quotation.custcategory" id="custcategory"
										name="custcategory" form-name="quotationForm"
										friendly-name="custcategory"></selectivity>

								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Valid From</label>
								<div class="col-md-7">
									<ng-bs3-datepicker data-ng-model="quotation.validFrom"
										id="validFrom" name="validFrom" friendly-name="validFrom" />
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Valid To</label>
								<div class="col-md-7">
									<ng-bs3-datepicker data-ng-model="quotation.validTo"
										id="validTo" name="validTo" friendly-name="validTo" />
								</div>
							</div>
						</div>

					</div>
					<div class="row pl2pc pr10pc">
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Status</label>
								<div class="col-md-7">
									<selectivity list="statusList" property="quotation.status"
										id="status" ng-model="quotation.status" name="status"
										form-name="quotationForm" friendly-name="status"></selectivity>
								</div>
							</div>
						</div>

					</div>
					<!-- /row -->
					<div class="form-actions text-center">
						<div class="row ">

							<div class="col-md-offset-3 col-md-5">
								<button class="btn btn-success help-button" type="button"
									data-ng-click="tdsHelpVideo('QuotationVideo.mp4','QuotationVideo')">
									<i class="fa fa-video-camera"></i> Help Video
								</button>

								<button class="btn btn-success" type="button"
									ng-click="getList(quotation)">
									<i class="fa fa-search"></i> Search
								</button>
								<button class="btn btn-info" type="button"
									data-ng-click="reset()">
									<i class="fa fa-undo"></i> Reset
								</button>
								<button class="btn btn-primary" type="button"
									data-ng-click="exportExcel()">
									<span class="fa fa-file-excel-o"></span>Export Excel <a
										id="Export" stype="display:none" href="filePath/Quotation.xls"
										download="Quotation.xls"></a>


								</button>
							</div>

						</div>

					</div>
				</form>
			</div>
		</div>
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer"
					role="grid" aria-describedby="dt_basic_info">
					<thead class="dataTables-Main-Head">
						<tr>
							<!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
							<th class="sorting width_8" st-sort="quotationNo">Quotation
								No</th>
							<th class="sorting width_8" st-sort="quotationDate">Quotation
								Date</th>
							<th class="sorting width_8" st-sort="validTill">Quote Valid
								Date</th>
							<th class="sorting width_8" st-sort="customer">Customer</th>
							<!-- <th class="width_2 text-center table-heading">Cntr.Dropoff</th> -->
							<th class="sorting width_2 text-center table-heading"
								st-sort="origin">Origin</th>
							<th class="sorting width_2 text-center table-heading"
								st-sort="pol">POL</th>
							<th class="sorting width_2 text-center table-heading"
								st-sort="pod">FPOD</th>
							<th class="sorting width_2 text-center table-heading"
								st-sort="status">Is Valid</th>
							<th class="sorting width_2 text-center table-heading"
								st-sort="user">Submitted By</th>
							<th class="sorting width_2 text-center table-heading"
								st-sort="location">Location</th>
							<th class="sorting width_2 text-center table-heading"
								st-sort="status1">Approval Status</th>
							<th class="sorting width_2 text-center table-heading"
								st-sort="bookingStatus">Status</th>
							<th class=" width_2 text-center table-heading">Action</th>

						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection in rowCollection">
							<!-- <td class="">
            <label class="i-checks m-b-none">
             <input type="checkbox" name="post[]">
             <i></i>
            </label>
           </td> -->

							<td class="sorting" st-sort="">{{collection.quotationNo}}</td>
							<td class="sorting" st-sort="">{{collection.quotationDate}}</td>
							<td class="sorting" st-sort="">{{collection.validTill}}</td>
							<td class="sorting" st-sort="">{{collection.customer}}</td>


							<!-- <td class="width_2 text-center table-heading">{{collection.dropoff}}</td> -->
							<td class="width_2 text-center table-heading">{{collection.origin}}</td>
							<td class="width_2 text-center table-heading">{{collection.pol}}</td>
							<td class="width_2 text-center table-heading">{{collection.pod}}</td>
							<td class="width_2 text-center table-heading">{{collection.status}}</td>
							<td class="width_2 text-center table-heading">{{collection.user}}</td>
							<td class="width_2 text-center table-heading">{{collection.location}}</td>
							<td class="width_2 text-center table-heading">{{collection.status1}}</td>
							<td class="width_2 text-center table-heading"><a
								ng-click="viewAllBookingByQuotation(collection.quotationNo,collection.bookingStatus)">
									<span tooltip="{{collection.bookingStatus}}"
									class="tool-tip-span font-blue">
										{{collection.bookingStatus}}</span>
							</a></td>
							<!-- <td class="width_2 text-center table-heading" ng-if="collection.bookingStatus == 'NOT ALLOTTED'">
							 
									{{collection.bookingStatus}} </td> -->
							<td class=" td-actions text-center"><span
								ng-if="collection.status1=='Approved'"> <i
									class="fa  fa-share-square text-success text"
									data-toggle="tooltip" title="Issue Booking"
									data-ng-click="addBooking(collection.quotationNo)"></i>
							</span> &nbsp <%--<security:authorize
									access="hasRole('${form_code}_${modify}')"> --%> <span>
									<i class="fa  fa-pencil text-success text"
									data-toggle="tooltip" title="Edit"
									data-ng-click="editRow(collection.quotationNo,collection.status1,collection.quotationcount,collection.approvedBy)"></i>
							</span>&nbsp <%--</security:authorize>  --%> <security:authorize
									access="hasRole('${form_code}_${delete}')">
									<span ng-if="collection.status1!='Approved'"> <i
										class="fa fa-trash-o text-danger-dker text"
										data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(collection.quotationNo,collection.status1)"></i>
									</span>&nbsp
								</security:authorize> <%-- <security:authorize access="hasRole('${form_code}_${approve}')"> --%>
								<span> <i class="fa  fa-print text-success text"
									data-toggle="tooltip" title="Print"
									data-ng-click="quotationPrint(collection.quotationNo)"></i>
							</span>&nbsp <span> <i class="fa  fa-eye text-success text"
									data-ng-click="approveRow1(collection.quotationNo,collection.allowOtherPorts,collection.quotationcreated)"
									title="View"></i>
							</span>&nbsp <%-- 	</security:authorize> --%> <security:authorize
									access="hasRole('${form_code}_${export}')">
									<span ng-if="collection.status1=='Pending'"> <i
										class="fa fa-check  text" data-toggle="tooltip"
										title="Approve"
										data-ng-click="approveRow(collection.quotationNo)"></i>
									</span>
								&nbsp
								  </security:authorize> <security:authorize
									access="hasRole('${form_code}_${export}')">
									<span> <i class="glyphicon glyphicon-edit text-primary"
										data-toggle="tooltip" title="Extend QuotationDate"
										data-ng-click="extendquotation(collection.quotationNo,collection.validTill)"></i>
									</span>
								&nbsp
								  </security:authorize></td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>


<script type="text/ng-template" id="fileGenModal">
	<div class="modal-header" style="background-color:#F9F9F9;"> <b>Booking Details</b> </div>
		<div class="row">
			<div class="col-lg-12">
				<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer" >
					<thead class="dataTables-Main-Head">
						<tr>
							<!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
 							<th class="sorting width_8"  >Booking No</th>
							<th class="sorting width_8"  >Booking Date</th>
<th class="sorting width_8" >Quotation No</th>
							 

						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection in bookingDtls">
						 

							<td class="sorting"  >
	<a ng-click="editBooking(collection.bookingNo)"> <span
									tooltip="{{collection.bookingNo}}"
									class="tool-tip-span font-blue">
{{collection.bookingNo}}</span></a></td>
							<td class="sorting"  >{{collection.bookingDate}}</td>
						 <td class="sorting"  >{{collection.quotation}}</td>
							 
						</tr>
					</tbody>
				</table>
			</div>
			</div> 
		</div>
		<div class="modal-footer" style="background-color:#F9F9F9;">
			<div style="margin-right:45%">
			 
			<button class="btn btn-danger" ng-click="genCancel()"><i class="fa fa-close"></i> Cancel</button></div>
		</div>
<br>
 </script>