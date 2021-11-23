<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

	<style>
.table>tbody>tr>td, .table>tfoot>tr>td {
    padding: 6px 2px;
    font-size: 12px;

</style>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body padding-10">
		
		<div class="col-sm-12 col-md-12 col-lg-12">
						<!-- 		<div class="col-sm-12 col-md-3 col-lg-3 ">
		
		    <div class="form-group">
        <label class="col-md-5 control-label">JV No</label>
        <div class="col-md-7">
     <div id="jvCode" class="selectivity-input example-input selectivity-slot jvCode" ><input type="text" class="input-sm selectivity-single-select-input" nextvalue="validFromDate"></div>     
        </div>
       </div> 
       </div> -->
       <div class="col-sm-12">
						<fieldset>
<div class="col-md-3">
								<div class="form-group">
									<label class="col-md-5 control-label">Mode</label>
									<div class="col-md-7">
										<selectivity list="modeList" ng-model="joborder.mode"
											property="joborder.mode" id="mode" name="mode"
											form-name="jobOrderForm" friendly-name="mode"></selectivity>

									</div>
								</div>
							</div>
							<div class="col-md-3">
							<div class="form-group">
									<label class="col-md-5 control-label">Carrier</label>
									<div class="col-md-7">
										<selectivity list="carrierList" ng-model="joborder.carrier"
											property="joborder.carrier" id="carrier" name="carrier"
											form-name="jobOrderForm" friendly-name="carrier"></selectivity>

									</div>
								</div>
								
							</div>
							<div class="col-md-3">
								
								<div class="form-group">
									<label class="col-md-5 control-label">POL</label>
									<div class="col-md-7">
										<selectivity list="portList" ng-model="joborder.aolName"
											validation="required" friendly-name="aolName"
											property="joborder.aolName" id="aolName" name="aolName"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
							</div>



							<div class="col-md-3">
								
								<div class="form-group">
									<label class="col-md-5 control-label">POD</label>
									<div class="col-md-7">
										<selectivity list="portList" ng-model="joborder.aodName"
											validation="required" friendly-name="aodName"
											property="joborder.aodName" id="aodName" name="aodName"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
							</div>
							</fieldset></div>
							<div class="col-sm-12">
						<fieldset><br>
							<div class="col-md-3">
								
								<div class="form-group">
									<label class="col-md-5 control-label">T/S</label>
									<div class="col-md-7">
										<selectivity list="tsStatusList" ng-model="joborder.bookingStatus"
											validation="required" friendly-name="pol"
											property="joborder.bookingStatus" id="bookingStatus" name="bookingStatus"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
							</div>
							
							
							<div class="col-md-3">
								
								<div class="form-group">
									<label class="col-md-5 control-label">Gate Out Status</label>
									<div class="col-md-7">
										<selectivity list="gateOutStatusList" ng-model="joborder.gateoutStatus"
											validation="required" friendly-name="gateoutStatus"
											property="joborder.gateoutStatus" id="port" name="gateoutStatus"
											form-name="jobOrderForm"></selectivity>
									</div>
								</div>
							</div>

<div class="col-md-3">
							<div class="form-group">
								<label class="col-md-5 control-label">Status</label>
								<div class="col-md-7">
									<selectivity list="jobStatusList"
											property="joborder.status1" id="status1"
											ng-model="joborder.status1" name="status1"
											validation="required"
											friendly-name="Status"
											form-name="jobOrderForm"></selectivity>

								</div>
							</div>
						</div>
						
						 <div class="col-sm-3">
						
							<div class="form-group">
								<label class="col-md-5 control-label">JO Status</label>
								<div class="col-md-7">
									<selectivity list="joStatusList"
											property="joborder.jostatus" id="jostatus"
											ng-model="joborder.jostatus" name="jostatus"
											validation="required"
											friendly-name="joStatus"
											form-name="jobOrderForm"></selectivity>

								</div>
							</div>
							
							
							
					</div>
						
						</fieldset></div>
						<div class="col-sm-12">
						<fieldset><br>
					
					 
						 <div class="col-sm-3 ">

							<div class="form-group">
								<label class="col-md-5 control-label">BCG Status</label>
								<div class="col-md-7">
												<selectivity list="bcgStatusList"
											property="joborder.statusbl" id="statusbl"
											ng-model="joborder.statusbl" name="statusbl"
											validation="required"
											friendly-name="statusbl"
											form-name="jobOrderForm"></selectivity>
											

								</div>
							</div>
							
							
						</div> 
						</fieldset>
						</div>
						
				<div class="row ">
							<div class="col-md-12 ">
							<br>
							<div class="col-md-12" style ="text-align:center;">									
								
										<button class="btn btn-success" type="button"
									ng-click="getSearchList(joborder)">
									<i class="fa fa-search"></i> Search
								</button>
								<button class="btn btn-info" type="button"
									data-ng-click="reset()">
									<i class="fa fa-undo"></i> Reset
								</button>
								
								           <button class="btn btn-primary" data-ng-click="exportExcelnew()">
										<span class="fa fa-file-excel-o"> </span> Export to Excel <a
											id="joborder" stype="display:none"
											href="filePath/Sea Job Order.xlsx"
											download="Sea Job Order.xlsx"></a>
								</button>
           						
								
								
                             </div>

							</div>
						</div>
						
						
						
						
						
						<!-- <div class="col-sm-6 col-md-3 col-lg-3">
							        
           <button class="btn btn-primary"
            data-ng-click="excel();" ng-if="showExcelButton"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button>
          <a id="exportXl" href="" download=""></a>
						</div>
					 -->	<%-- 	<div class="col-sm-12 col-md-9 col-lg-9 ">
				<button class="btn btn-primary" type="button"
					data-ng-click="copyJournalVoucher(jvcode);">
					Copy JV
				</button>
				<button class="btn btn-primary" type="button"
					data-ng-click="bulk(jvcode1,jvCode2 );">
					Bulk Print
				</button>
				<security:authorize access="hasRole('${form_code}_${approve}')">
					<button class="btn btn-primary" type="button"
						data-ng-click="reverseJV();">
						Reverse JV
					</button>
				</security:authorize>
				
			<button class="btn btn-info" type="button"
					data-ng-click="viewDraft();">
					View Draft Lists
			</button>
			</div> --%>
					</div>
					<br>	<br><br>	<br>
			<div class="table-responsive" style="border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>       						
							<th class="sorting" st-sort="modeName">Mode</th>
							<th class="sorting" st-sort="jobNo">JOB NO</th>
       						<th class="sorting" st-sort="bookingId">BOOKING NO</th>
       						<th class="sorting" st-sort="gateoutNo">QUOTATION NO</th>
       						<th class="sorting" st-sort="gateoutNo">GATE OUT NO</th>
       						<th class="sorting" st-sort="customer">CUSTOMER</th>
       						<th class="sorting" st-sort="vessel">Vessel</th>
							<th class="sorting" st-sort="voyage">Voyage</th>
							<th class="sorting" st-sort="lolName">POL</th>
							<th class="sorting" st-sort="lodName">POD</th>
														<th class="sorting" st-sort="createBy">CREATED BY</th>
							
							<th class="sorting" st-sort="create">CREATED DATE</th>
							<th class="sorting" st-sort="modifiedBy">MODIFIED BY</th>
							<th class="sorting" st-sort="modifiedOn">MODIFIED DATE</th>
														<th class="sorting" st-sort="status">Status</th>
							
<!-- 							<th class="sorting" st-sort="modify">MODIFIED DATE</th>
 -->							
							<!-- <th class="sorting" st-sort="jobDt">JOB DATE</th>
							<th class="sorting" st-sort="conType">ORIGIN</th>
							<th class="sorting" st-sort="conType">DESTINATION</th>
							<th class="sorting" st-sort="status">CREATED BY</th>
							<th class="sorting" st-sort="status">CREATED DATE</th>
							<th class="sorting" st-sort="status">MODIFIED BY</th>
							<th class="sorting" st-sort="status">MODIFIED DATE</th>
							<th class="sorting" st-sort="status">Status</th> -->
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

<%-- 							<td>  <security:authorize access="hasRole('${form_code}_${view}')"><span>{{booking.jobNo}}</span></security:authorize></a> </td>
 --%>							<td>{{booking.modeName}}</td><td><a data-ng-click="viewJob(booking.jobId)">  <security:authorize access="hasRole('${form_code}_${view}')"><span class="tool-tip-span font-blue">{{booking.jobNo}}</span></security:authorize></a> </td>
					
 		<td><a data-ng-click="viewBooking(booking.bookingId)">  <security:authorize access="hasRole('${form_code}_${view}')"><span class="tool-tip-span font-blue">{{booking.bookingId}}</span></security:authorize></a> </td>
							<td>{{booking.quoteNo}}</td>
							<td>{{booking.gateoutNo}}</td>
							<td>{{booking.custName}}</td>
						        <td>{{booking.vessel}}</td>
							<td>{{booking.voyage}}</td>
							<td>{{booking.aolName}}</td>
							<td>{{booking.aodName}}</td>
														<td>{{booking.createdBy}}</td>
							
								<td>{{booking.create}}</td><td>{{booking.modifedBy}}</td>
							<td>{{booking.modify}}</td>
																<td>{{booking.invStatus}}</td>
								
<!-- 									<td>{{booking.modify}}</td>
 --> 							<!-- <td>{{booking.jobDt}}</td>
							<td>{{booking.originName}}</td>
							<td>{{booking.destinationName}}</td>
							<td>{{booking.createdBy}}</td>
							<td>{{booking.createdOn}}</td>
							<td>{{booking.modifiedBy}}</td>
							<td>{{booking.modifiedOn}}</td>
							<td>{{booking.status}}</td> -->
							
							 
							<td class="td-actions text-center"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span  ng-if="booking.jobNo != null && booking.invStatus=='Pending'"> <i
										class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editBooking(booking.jobId)"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span ng-if=" booking.invStatus=='Pending'"> <i
										class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteJob(booking.jobId)"></i>
									</span>
								</security:authorize>
								
								 <security:authorize access="hasRole('${form_code}_${print}')">
								<span> <i class="fa  fa-print text-success text" data-toggle="tooltip" title="Print"
										data-ng-click="print1(booking.jobId)"></i>
									</span>
									</security:authorize>
						</tr>
						<tr x-ng-show="showEmptyLabel">
							<td colspan="6" class="text-center">No Records Found</td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
				
  
			
			</footer>
		</div>
	</div>
</div>
