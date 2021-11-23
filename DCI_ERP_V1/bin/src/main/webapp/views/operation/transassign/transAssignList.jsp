<style>
.toggleBlock-currsor {
	cursor: pointer;
}

#otherBlock table>tbody>tr>td {
	padding: 2px !important;
}
 
.bootstrap-datetimepicker-widget {
	z-index: 10000 !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">

		<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>

<tabset justified="true" class="tab-container">
				<tab heading="T/S Assign">
				
<div class="panel panel-default panel-default-list" st-persist="ff"
						st-table="list" st-safe-src="booking">
<%@include file="/views/templates/panel-header.jsp"%>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-12 col-md-offset-4">
				<button class="btn btn-primary" type="button" class="btn btn-info"
						ng-click="tsAssignListPage()">
						<i class="fa fa-th-list"></i>T/S Assigned List
					</button>
					<button class="btn btn-success" type="button" class="btn btn-info"
						ng-click="assignedList()">
						<i class="fa fa-th-list"></i>Assigned List to Roll Over
					</button>
				</div>
			</div>
			</div>
			



			<div class="panel-body">

				<div class="panel-body padding-0">
					<div class="table-responsive ">
						<table
							class="table table-striped table-bordered table-hover dataTable no-footer"
							role="grid" aria-describedby="dt_basic_info">
							<thead class="dataTables-Main-Head">
								<tr>
				 
									<th class="sorting txtUpperCs"style="width:16%;"  st-sort="bookingNo">Booking No</th>
									<th class="sorting txtUpperCs" style="width:16%;"  st-sort="vesselRouting">Vessel</th>
									<th class="sorting txtUpperCs"style="width:16%;"   st-sort="voyageRouting">Voyage</th>
									<th class="sorting txtUpperCs" style="width:11%;"  st-sort="pol">POL</th>
									<th class="sorting txtUpperCs" style="width:11%;"  st-sort="fromPort">POT</th>
									<th class="sorting txtUpperCs" style="width:11%;"  st-sort="eta1">ETA</th>
									
									<th class="sorting txtUpperCs" style="width:11%;"  st-sort="toPort">POD</th>
							
 									<th class="text-center txtUpperCs">Action</th>
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="item in list">

 

                                     <td class="sorting"><a ng-click="viewBookinghyp(item.bookingNo)"> <span
										 tooltip="{{item.bookingNo}}" class="tool-tip-span font-blue">{{item.bookingNo}}</span></a>
									 </td>
									<td class="txtUpperCs"><span>{{item.vesselRouting}}</span></td>
									<td class="txtUpperCs"><span>{{item.voyageRouting}}</span></td>
									<td class="txtUpperCs"><span>{{item.pol}}</span></td>
									<td class="txtUpperCs"><span>{{item.fromPort}}</span></td>
									<td class="txtUpperCs"><span>{{item.eta}}</span></td>
									
									<td class="txtUpperCs"><span>{{item.toPort}}</span></td>
									<td class=" text-center td-actions">
										<button class="btn btn-info" type="button"
											class="btn btn-info"
											ng-click="assign(item)">
											<i class="fa fa-exchange"></i>Assign
										</button>
								 
									
									
										 
										
									</td>

								</tr>
								<tr x-ng-show="showEmptyLabel">
									<td colspan="6" class="text-center">No Records Found</td>
								</tr>
							</tbody>
						</table>
					</div>
					<footer class="panel-footer panel-footer-list"
						style="padding: 0px;">
						<%@include file="/views/templates/panel-footer-static.jsp"%>
					</footer>
				</div>
			</div>
			</div>
			</tab>
			
			 
				<tab heading="ICD Assign">
				<div class="panel panel-default panel-default-list" st-persist="icdAssignTable" st-table="itemList" st-safe-src="icdPendingList">
	<%@include file="/views/templates/panel-header.jsp"%>
				<div class="panel-body">

				<div class="panel-body padding-0">
					<div class="table-responsive ">
						<table
							class="table table-striped table-bordered table-hover dataTable no-footer"
							role="grid" aria-describedby="dt_basic_info">
							<thead class="dataTables-Main-Head">
								<tr>
				 
									<th class="sorting txtUpperCs"style="width:16%;"  st-sort="bookingNo">Booking No</th>
									<th class="sorting txtUpperCs" style="width:16%;"  st-sort="vesselRouting">Vessel</th>
									<th class="sorting txtUpperCs"style="width:16%;"   st-sort="voyageRouting">Voyage</th>
									<th class="sorting txtUpperCs" style="width:11%;"  st-sort="pol">POL</th>
									<th class="sorting txtUpperCs" style="width:11%;"  st-sort="fromPort">POD</th>
									<th class="sorting txtUpperCs" style="width:11%;"  st-sort="toPort">Destination</th>
							
 									<th class="text-center txtUpperCs">Action</th>
								</tr>
							</thead>
							<tbody class="dataTables-Main-Body">
								<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
									ng-repeat="item in itemList">

 

                                     <td class="sorting"><a ng-click="viewBookinghyp(item.bookingNo)"> <span
										 tooltip="{{item.bookingNo}}" class="tool-tip-span font-blue">{{item.bookingNo}}</span></a>
									 </td>
									<td class="txtUpperCs"><span>{{item.vesselRouting}}</span></td>
									<td class="txtUpperCs"><span>{{item.voyageRouting}}</span></td>
									<td class="txtUpperCs"><span>{{item.pol}}</span></td>
									<td class="txtUpperCs"><span>{{item.toPort}}</span></td>
									<td class="txtUpperCs"><span>{{item.destination}}</span></td>
									<td class=" text-center td-actions">
										 
										
										<button class="btn btn-info" type="button" data-toggle="tooltip" title="Assgin InterModel"
										data-ng-click="assignInterModel(item)"> 
								       <span >
										<i class="fa fa-share-square"
										></i>ICD Assign 
									</span>
									</button>
									</td>

								</tr>
								<tr x-ng-show="showEmptyLabel">
									<td colspan="6" class="text-center">No Records Found</td>
								</tr>
							</tbody>
						</table>
					</div>
					<footer class="panel-footer panel-footer-list"
						style="padding: 0px;">
						<%@include file="/views/templates/panel-footer-static.jsp"%>
					</footer>
				</div>
			</div></div>
				</tab>
				</tabset>
				 
			
		</div>
	</div>
 
 