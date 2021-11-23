<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
 <div class="breadcrumb-wrapper ng-scope">

<div class="panel panel-default panel-default-list" st-persist="dischargeTable"
		st-table="displayedCollection1" st-safe-src="rowCollection1">
				<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body padding-10">
		
		<div class="row" style="padding-bottom:2%;">
				<br>
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Vessel</label>
								<div class="col-md-8">
									<selectivity list="vesselList"
										property="discharge.vessel" id="vessel"
										ng-model="discharge.vessel" name="vessel"
										friendly-name="Vessel"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">Voyage</label>
								<div class="col-md-8">
								<selectivity list="voyageList"
										property="discharge.voyage" id="voyage"
										ng-model="discharge.voyage" name="voyage"
										friendly-name="Voyage"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label">P.O.D</label>
								<div class="col-md-8">
									<selectivity list="portList"
										property="discharge.port" id="port"
										ng-model="discharge.port" name="port"
										friendly-name="P.O.D"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<div class="col-md-4">
									<button class="btn btn-success" type="button" ng-if="!isEdit"
								ng-click="search(discharge.vessel,discharge.voyage,discharge.port)">
								<i class="fa fa-search"></i> Search
							</button>
								</div>
								<div class="col-md-4" style="padding-left: 13px;">
									<button class="btn btn-danger" type="button" ng-if="!isEdit"
								ng-click="reset()">
								<i class="fa fa-refresh"></i>Reset
							</button>
								</div>
							<!-- 	<div class="col-md-4" style="padding-left: 0px;">
									<button class="btn btn-primary" type="button" 
								ng-click="exportExcel()">
								<i class="fa fa-file-excel-o"></i>Export Excel
								<a id="Export" stype="display:none" href="filePath/Discharge.xls" download="Discharge.xls"></a>
							</button>
								</div> -->
							</div>
						</fieldset>
					</div>
				</div>
			<div class="table-responsive" style=" border: 1px solid #CCC;">
	
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting width_6" st-sort="vessel">Vessel </th>
							<th class="sorting width_6" st-sort="voyage">Voyage </th>
							<th class="sorting width_6" st-sort="voyage">Port </th>
							<!-- <th class="sorting width_9" st-sort="bookingNum">Booking No. </th>
							<th class="sorting width_8" st-sort="blNumber">B/L No.</th> 
							<th class="sorting width_8" st-sort="customerName">Customer</th>
							<th class="sorting width_10" st-sort="containerNumber">Container No.</th>-->
							<!-- <th class="sorting width_7" st-sort="terminal">Terminal</th> -->
							<th class="sorting width_8" st-sort="dischargeDate">Discharge Date</th>
							<th class="sorting width_6" st-sort="isTransit">Is Transit</th>
							<th class="sorting width_5 text-center table-heading" >Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="discharge in displayedCollection1">
							<td> {{discharge.vessel}}  </td>
							<td>{{discharge.voyage}}</td>
							<td>{{discharge.port}}</td>
							<!-- <td> {{discharge.bookingNum}}  </td>
							<td>{{discharge.blNumber}}</td>
							<td>{{discharge.customerName}}</td>
							<td>{{discharge.containerNumber}}</td> -->
							<!-- <td>{{discharge.terminal}}</td> -->
							<td>{{discharge.dischargeDate}}</td> 
							<td>{{discharge.transitShow}} <!-- <label class="i-checks">
												<input type="checkbox"
											message-id="isTransit" id="isTransit"
											class="checkbox style-0" name="isTransit"
											ng-model="discharge.isTransit" disabled="disabled"><i></i></label> --></td>
					
								<td class=" td-actions text-center"> 
								<security:authorize access="hasRole('${form_code}_${view}')"> 
									<span> <i class="fa fa-eye text-success text" data-toggle="tooltip" title="View"
										data-ng-click="viewRow(discharge.vesselArrivalId,discharge.isTransit)"></i>
									</span>
								 </security:authorize>  
								<%-- <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(discharge.vesselArrivalId,discharge.isTransit)"></i>
									</span>
								</security:authorize>  --%>
								<security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span ng-if="isSuccess"> <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(discharge.dischargeId)"></i>
									</span>
								 </security:authorize>
								<%--  <security:authorize access="hasRole('${form_code}_${delete}')">  --%>
									<!-- <span> <i class="fa fa-file-excel-o" data-toggle="tooltip" title="Export Excel"
										data-ng-click="exportExcelNew(discharge.vesselArrivalId,discharge.isTransit)"></i>
										
									</span> -->
									 <a id="Export" stype="display:none" href="filePath/Discharge.xlsx" download="Discharge.xlsx"></a>
								<%--  </security:authorize> --%>
								 </td> 
           		
						</tr>
						
						<tr x-ng-show="showEmptyLabel">
							<td colspan="6" class="text-center">No Records Found</td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer"  style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
	</div></div>