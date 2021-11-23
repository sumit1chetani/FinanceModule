<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
						<div class="col-sm-12 col-md-3 col-lg-3 ">

							<div class="form-group">
								<label class="col-md-2 control-label">Branch</label>
								<div class="col-md-7">
									<selectivity list="branchList" ng-model="joborder.branch"
											property="joborder.branch" name="branch"
											validation="required" friendly-name=BRANCH
											form-name="jobOrderForm" ></selectivity>

								</div>
							</div>
							
							
						</div>
						<div class="col-sm-12 col-md-3 col-lg-3 ">
							<div class="form-group">
								<label class="col-md-2 control-label">Status</label>
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
				
						<div class="col-sm-6 col-md-3 col-lg-3">
							        
           <button class="btn btn-primary"
            data-ng-click="excel();" ng-if="showExcelButton"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button>
          <a id="exportXl" href="" download=""></a>
						</div>
						<%-- 	<div class="col-sm-12 col-md-9 col-lg-9 ">
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
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting" st-sort="jobNo">JOB NO</th>
							<th class="sorting" st-sort="jobDt">JOB DATE</th>
							<th class="sorting" st-sort="custName">CUSTOMER</th>
							<th class="sorting" st-sort="aolName">AOL</th>
							<th class="sorting" st-sort="aodName">AOD</th>
							<th class="sorting" st-sort="originName">ORIGIN</th>
							<th class="sorting" st-sort="destinationName">DESTINATION</th>
							<th class="sorting" st-sort="createdBy">CREATED BY</th>
							<th class="sorting" st-sort="createdOn">CREATED DATE</th>
							<th class="sorting" st-sort="modifiedBy">MODIFIED BY</th>
							<th class="sorting" st-sort="modifiedOn">MODIFIED BY</th>
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

							<td><a data-ng-click="viewJob(booking.jobId)">  <security:authorize access="hasRole('${form_code}_${view}')"><span class="tool-tip-span font-blue">{{booking.jobNo}}</span></security:authorize></a> </td>
							<td>{{booking.jobDt}}</td>
							<td>{{booking.custName}}</td>
							<td>{{booking.aolName}}</td>
							<td>{{booking.aodName}}</td>
							<td>{{booking.originName}}</td>
							<td>{{booking.destinationName}}</td>
							<td>{{booking.createdBy}}</td>
							<td>{{booking.createdOn}}</td>
							<td>{{booking.modifiedBy}}</td>
							<td>{{booking.modifiedOn}}</td>
							<td>{{booking.status}}</td> 
							<td class="td-actions text-center">
							
                                  <security:authorize access="hasRole('${form_code}_${modify}')">
									<span> <i
										class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editJob(booking.jobId)"></i>
									</span>
 								</security:authorize> 
								<security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i
										class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteJob(booking.jobId)"></i>
									</span></security:authorize>
									<security:authorize access="hasRole('${form_code}_${print}')">
										<span> <i class="fa  fa-print text-success text" data-toggle="tooltip" title="Print"
										data-ng-click="print(booking.jobId)"></i>
									</span>
									</security:authorize> 
								</td>
						</tr>
						<tr x-ng-show="showEmptyLabel">
							<td colspan="6" class="text-center">No Records Found</td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
				<div style="text-align:center;">
          
          <!--  <button class="btn btn-primary"
            data-ng-click="excel();" ng-if="showExcelButton"
           type="button">
           <i class="fa fa-print"></i> Export Excel
          </button> -->
          <a id="exportXl" href="" download=""></a>
			</div>
			</footer>
		</div>
	</div>
</div>
