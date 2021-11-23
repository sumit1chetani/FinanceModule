<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">

	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">

		<%@include file="/views/templates/panel-header.jsp"%>
<div class="panel-body padding-10">

		<div class="row pl2pc pr10pc">
<div class="col-md-3">
								<div class="form-group ">
								<label  class="col-md-5 control-label">Mode 
								</label>
								<div class="col-md-7">

									<selectivity list="modeList"
										property="quotation.mode" id="mode"
										name="mode" ng-model="quotation.mode"
										object="mode" friendly-name="Mode"
										 form-name="quotationForm"
										></selectivity>

</div>

								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Carrier</label>
									<div class="col-md-7">
										<selectivity list="carrierList" ng-model="quotation.carrier"
											property="quotation.carrier" id="carrier" name="carrier"
											form-name="quotationForm" friendly-name="carrier"></selectivity>

									</div>
								</div>
							</div>
							
														<div class="col-md-3">
								<div class="form-group ">
								<label class="col-md-2 control-label">POL</label>
								<div class="col-md-7">
										<selectivity list="polList"
										property="quotation.polCode" id="polCode"
										name="polCode" ng-model="quotation.polCode"
										object="polCode" friendly-name="POL"
										validation="required" form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							</div>
							
														<div class="col-md-3">
								<div class="form-group ">
								<label class="col-md-2 control-label">POD </label>
								<div class="col-md-7">
										<selectivity list="potList"
										property="quotation.podCode" id="podCode"
										name="podCode" ng-model="quotation.podCode"
										object="podCode" friendly-name="POD"
										validation="required" form-name="quotationForm"
										></selectivity>
							</div>
							</div>
							</div><br><br><br>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer</label>
									<div class="col-md-7">
										<selectivity list="customerDropList" ng-model="quotation.customer"
											property="quotation.customer" id="customer" name="customer"
											form-name="quotationForm" friendly-name="customer"></selectivity>

									</div>
								</div>
							</div>
							
							<div class="col-md-3">
								<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5">Valid From
									 
								</label>
								<div class="col-md-7">
									<ng-bs3-datepicker data-ng-model="quotation.fromDate"
										id="fromDate" name="fromDate" form-name="fromDate" friendly-name="fromDate"
										/>
								</div>
								
							</div>
							</div>
							<div class="col-md-3">
								<div class="form-group ">
								<label class="col-md-4 control-label">Valid To </label>
								<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="quotation.toDate"
										id="toDate" name="toDate" form-name="toDate" friendly-name="toDate" />
							</div>
							</div>
							</div>
<div class="col-md-3">
								<div class="form-group">
								<label class="col-md-2 control-label">Status</label>
								<div class="col-md-7">
									<selectivity list="jobStatusList"
											property="quotation.status" id="status"
											ng-model="quotation.status" name="status"
											validation="required"
											friendly-name="Status"
											form-name="quotationForm"></selectivity>

								</div>
							</div>
							</div>
							<br><br><br>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking No </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											name="bookingNo" id="bookingNo" ng-model="quotation.bookingNo"
											friendly-name="bookingNoss" />
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">CRO Status </label>
									<div class="col-md-7">
										<selectivity list="CROStatus" ng-model="quotation.croStatus"
											property="quotation.croStatus" id="status" name="croStatus"
											form-name="bookingListForm" friendly-name="croStatus"></selectivity>
									</div>
								</div>
							</div>
							<!-- 
							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">BL Status </label>
									<div class="col-md-7">
										<selectivity list="statusList" ng-model="booking.blStatus"
											property="booking.blStatus" id="status" name="blStatus"
											form-name="bookingListForm" friendly-name="blStatus"></selectivity>
									</div>
								</div>
							</div> --><!-- 
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
							</div> -->

<!-- 							<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 i-checks m-b-none"
										style="padding-left: 119px; padding-top: 6px;"> <input
										type="checkbox" ng-model="booking.checked"
										id="select{{trIndex}}" ng-change="check(booking.checked)">
										<i></i></label> <label class="col-md-5 control-label"
										style="padding-right: 80px;">Cancelled </label>

								</div>
							</div> -->
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
						<!-- 		<div class="col-sm-12 col-md-3 col-lg-3 ">
		
		    <div class="form-group">
        <label class="col-md-5 control-label">JV No</label>
        <div class="col-md-7">
     <div id="jvCode" class="selectivity-input example-input selectivity-slot jvCode" ><input type="text" class="input-sm selectivity-single-select-input" nextvalue="validFromDate"></div>     
        </div>
       </div> 
       </div> -->
						<br><br><br>
					<div align="center">
					<button type="button" class="btn btn-success"
									ng-click="viewGeneralLedgerReportNew(quotation)">
									<i class="fa fa-search"></i>View Report
								</button>
								
								 <button class="btn btn-primary" data-ng-click="exportExcelnew(quotation)">
										<span class="fa fa-file-excel-o"> </span> Export to Excel <a
											id="quotation" stype="display:none"
											href="filePath/Sea Quotation.xlsx"
											download="Sea Quotation.xlsx"></a>
								</button>
           						
								</div>
								
								
								
					<%-- <div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<security:authorize access="hasRole('${form_code}_${view}')">
								<button type="button" class="btn btn-success"
									ng-click="viewGeneralLedgerReportNew(quotation)">
									<i class="fa fa-search"></i>View Report
								</button>
							<%-- </security:authorize>
							
							  <button type="button" class="btn btn-success" 
												 ng-click="printgeneralLedger()"  
												 type="button">
									        	   Print
									         </button>
					
									         

							<security:authorize access="hasRole('${form_code}_${export}')">
								<button type="button" class="btn btn-primary" type="button"
									ng-click="exportGeneralLedgerExcelOP()">
									<i class="fa fa-search"></i>Export Excel
								</button>
							</security:authorize>

							<security:authorize access="hasRole('${form_code}_${export}')">
								<button type="button" class="btn btn-primary"
									ng-click="exportGeneralLedgerExcel()">
									<i class="fa fa-search"></i>Export Excel By Account Head
								</button>
							</security:authorize>

							<security:authorize access="hasRole('${form_code}_${export}')">
								<button type="button" class="btn btn-primary"
									ng-click="exportTransactionLevelExcel()">
									<i class="fa fa-search"></i>Export Excel OP with Transaction
								</button>
							</security:authorize>

							<button type="button" class="btn btn-info" type="reset"
								class="btn btn-success" ng-click="formreset()">
								<i class="fa fa-undo"></i>Reset
							</button> 
						</div>
					</div>
				</div> --%>
					<br>	<br><br><BR><br><br>	<br>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive" style=" border: 1px solid #CCC;">

				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting" st-sort="quotationNo">Quotation</th>
							<th class="sorting" st-sort="quotationDate">Quotation
								Date</th>
						<th class="sorting" st-sort="mode">Mode</th>
								
							<th class="sorting" st-sort="custName">Customer</th>
							<th class="sorting" st-sort="aolName">POL</th>
							<th class="sorting" st-sort="aodName">POD</th>
							<th class="sorting" st-sort="originName">Origin</th>
							<th class="sorting" st-sort="destinationName">Destination</th>
							<th class="sorting" st-sort="createdBy">Created
								By</th>
							<th class="sorting" st-sort="createdOn">Created
								Date</th>
								<!-- <th class="sorting" st-sort="modifiedBy">Modified
								By</th>
							<th class="sorting" st-sort="modifiedOn">Modified
								Date</th> -->
								<th class="sorting" st-sort="status">Status
								</th>
							<!-- <th class="sorting width_20" st-sort="tripNo">Trip No</th> -->
							<th class="text-center">Action</th>

						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="row in displayedCollection">
							<td class="sorting"><a ng-click="viewQuot(row.quotationId)"> <security:authorize
										access="hasRole('${form_code}_${view}')">

										<span tooltip="{{row.quotation}}"
											class="tool-tip-span font-blue">{{row.quotationNo}}</span>
									</security:authorize></a></td>
							<td class="sorting">{{row.quotationDate}}</td>

							<td class="sorting">{{row.modeName}}</td>
							<td class="sorting">{{row.custName}}</td>
							<td class="sorting">{{row.aolName}}</td>
							<td class="sorting">{{row.aodName}}</td>
							<td class="sorting">{{row.originName}}</td>
							<td class="sorting">{{row.destinationName}}</td>
							<td class="sorting">{{row.createdBy}}</td>
							<td class="sorting">{{row.createdOn}}</td>
							<!-- <td class="sorting">{{row.modifiedBy}}</td>
							<td class="sorting">{{row.modifiedOn}}</td> -->
														<td class="sorting">{{row.status}}</td>
							
							<!-- 	<td class="sorting">{{row.tripNo}}</td> -->

							<td class=" td-actions text-center"><security:authorize
									access="hasRole('F0234_${modify}')">
									<security:authorize access="hasRole('F0234_${approve}')">
									<span ng-if="row.status!='Pending'"> <i class="fa  fa-eye text-success text"
						data-toggle="tooltip" title="View" data-ng-click="approveRow(row.quotationId)"></i>
									</span></security:authorize>
									
									<span><i ng-if="row.status=='Pending'" class="fa fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editQuot(row.quotationId)"></i>
									</span>
									<security:authorize access="hasRole('F0234_${approve}')"><span ng-if="row.status=='Pending'"> <i class="fa fa-check  text"
						data-toggle="tooltip" title="Approve" data-ng-click="approveRow(row.quotationId)"></i>
									</span></security:authorize>
									
								</security:authorize> 
								<security:authorize access="hasRole('${form_code}_${add}')" var="isAdd" >
								<span><i  class="fa fa-plus" data-toggle="tooltip" title="save As"
										data-ng-click="editQuot1(row.quotationId)"></i>
									</span></security:authorize>
								<security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i ng-if="row.status=='Pending'" class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteQ(row.quotationId,row.quotationNo)"></i>
									</span>
								</security:authorize> 
								
								<%-- <security:authorize access="hasRole('${form_code}_${approve}')">
									<span> <i class="fa fa-trash-o text-warning text"
										data-ng-click="approveRow(row.quotation)"></i>
									</span>
								</security:authorize> --%>
								<security:authorize access="hasRole('${form_code}_${print}')">
								<span>
								 <i class="fa  fa-print text-success text" data-toggle="tooltip" title="Print"
										data-ng-click="printQuot(row.quotationId)"></i>
									</span>
									</security:authorize>
									<security:authorize access="hasRole('${form_code}_${print}')">
										<span> <i class="fa  fa-envelope text-success text" data-toggle="tooltip" title="Email"
										data-ng-click="mailview(row.quotationId)"></i>
									</span>
									</security:authorize>
									</td>
									
						</tr>
					</tbody>

				</table>
			</div>
			<footer class="panel-footer panel-footer-list" style="padding:0px">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>