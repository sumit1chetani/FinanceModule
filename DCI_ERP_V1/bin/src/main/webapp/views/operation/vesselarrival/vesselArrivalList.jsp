<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="vesselArrivalTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
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
										property="vesselArrival.vessel" id="vessel"
										ng-model="vesselArrival.vessel" name="vessel"
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
										property="vesselArrival.voyage" id="voyage"
										ng-model="vesselArrival.voyage" name="voyage"
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
										property="vesselArrival.port" id="port"
										ng-model="vesselArrival.port" name="port"
										friendly-name="P.O.D"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
								<div class="col-md-6">
									<button class="btn btn-success" type="button" ng-if="!isEdit"
								ng-click="search(vesselArrival.vessel,vesselArrival.voyage,vesselArrival.port)">
								<i class="fa fa-search"></i> Search
							</button>
								</div>
								<div class="col-md-6" style="padding-left: 0px;">
									<button class="btn btn-danger" type="button" ng-if="!isEdit"
								ng-click="reset()">
								<i class="fa fa-refresh"></i>Reset
							</button>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
		
		
		
		
		
		
			<div class="table-responsive" style=" border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
						<tr>
							<th class="sorting width_10" st-sort="vessel">Vessel Name </th>
							<th class="sorting width_10" st-sort="voyage">Voyage Name</th>
							<th class="sorting width_10" st-sort="port">Port Name</th>
							<!-- <th class="sorting width_10" st-sort="terminal">Terminal Name</th> -->
							<th class="sorting width_10" st-sort="arrivalDate">Arrival Date</th>
							<th class="width_8" >Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="vesselArrival in displayedCollection">
							<td><a ng-click="edit(vesselArrival.rowId)"> <span
								tooltip="{{vesselArrival.rowId}}"
								class="tool-tip-span font-blue"> {{vesselArrival.vessel}}  </td>
							<td>{{vesselArrival.voyage}}</td>
							<td>{{vesselArrival.port}}</td>
							<!-- <td>{{vesselArrival.terminal}}</td> -->
							<td>{{vesselArrival.arrivalDate}}</td>
							<td>
<!-- 							 <span> <i class="fa  fa-eye text-success text"  data-toggle="tooltip" title="View" -->
<!-- 										data-ng-click="edit(vesselArrival.rowId)"></i> </span> -->
							 <!-- <span><i class="fa fa-pencil text-success text"   data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(vesselArrival.rowId)"></i> </span> -->
										
							 <span><i class="fa fa-trash-o text-danger-dker text"  data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(vesselArrival.rowId)"></i> </span>			
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
	</div>
</div>
