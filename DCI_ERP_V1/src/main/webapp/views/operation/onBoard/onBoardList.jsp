<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="onBoardTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
<br><br><br>
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
							
														
							
						</div><br><br>
						<div align="center">
					<button type="button" class="btn btn-success"
									ng-click="viewGeneralLedgerReportNew(quotation)">
									<i class="fa fa-search"></i>Search
								</button></div><br>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive" style="border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting width_30" st-sort="onBoardId">OnBoard ID</th>
							<th class="sorting width_35" st-sort="vessel">Vessel Name</th>
							<th class="sorting width_30" st-sort="voyage">Voyage</th>
							<th class="sorting width_30" st-sort="port">POL</th>
							<!-- <th class="sorting width_30" st-sort="onBoardDate">OnBoard Date</th> -->
<!-- 							<th class="sorting width_30" st-sort="bookingNo">Booking No</th>
 -->							<th class="sorting width_30" st-sort="userId">Created By</th>
							<th class="sorting width_30" text-center table-heading>Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection">

							<td class="" data-toggle="tooltip" title="{{item.onBoardId}}"><a ng-click="view(item.onBoardId)"> <span
								tooltip="{{item.onBoardId}}"
								class="tool-tip-span font-blue">{{item.onBoardId}}</span></a></td>
							<td class="sorting" data-toggle="tooltip" title="{{item.vessel}}">{{item.vessel}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.voyage}}">{{item.voyage}}</td>
							<td class="sorting" data-toggle="tooltip" title="{{item.pol}}">{{item.port}}</td>
							<!-- <td class="sorting" data-toggle="tooltip" title="{{item.onBoardDate}}">{{item.onBoardDate}}</td> -->
<!-- 							<td class="sorting" data-toggle="tooltip" title="{{item.bookingNo}}">{{item.bookingNo}}</td>
 -->							<td class="sorting" data-toggle="tooltip" title="{{item.userId}}">{{item.created_by}}</td>

							<td class=" td-actions text-center"> 
								<button id="exportXl" class="btn btn-primary" data-ng-click="Export(item.onBoardId)" type="button" title="Excel Export">
									<i class="fa fa-file-excel-o"></i> Export
								</button>
							 <a id="tbExcelExport" style="display:none" ng-href={{filePath}} download={{fileName}}></a>
								<security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(item.onBoardId)"></i>
									</span>
								</security:authorize>
							</td>
								
						</tr>
					</tbody>

				</table>
			</div>
			<footer class="panel-footer panel-footer-list" style="padding: 0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>