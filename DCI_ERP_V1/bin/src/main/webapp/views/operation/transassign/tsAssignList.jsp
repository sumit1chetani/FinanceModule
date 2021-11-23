<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">

	<style>
.icontable table, .icontable th, .icontable td {
	border: 1px solid #a0adaf;
	font-size: 13px !important;
}
</style>

	<div class="panel panel-default panel-default-list"
		st-persist="dischargeTable" st-table="displayedCollection1"
		st-safe-src="rowCollection1">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body padding-10">

			<div class="row" style="padding-bottom: 2%;">
				<br>
				<div class="col-sm-3 col-md-3 col-lg-3">
					<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label">Ex-Vessel</label>
							<div class="col-md-8">
								<selectivity list="vesselList" property="tsAssignList.vesselSearch"
									id="vesselSearch" ng-model="tsAssignList.vesselSearch" name="vesselSearch"
									friendly-name="Vessel"></selectivity>
							</div>
						</div>
					</fieldset>
				</div>

				<div class="col-sm-3 col-md-3 col-lg-3">
					<fieldset>

						<div class="form-group">
							<label class="col-md-4 control-label">Ex-Voyage</label>
							<div class="col-md-8">
								<selectivity list="voyageList" property="tsAssignList.voyageSearch"
									id="voyageSearch" ng-model="tsAssignList.voyageSearch" name="voyageSearch"
									friendly-name="Voyage"></selectivity>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="col-sm-3 col-md-3 col-lg-3">
					<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label">P.O.T</label>
							<div class="col-md-8">
								<selectivity list="potList" property="tsAssignList.potSearch" id="potSearch"
									ng-model="tsAssignList.potSearch" name="potSearch" friendly-name="P.O.T"></selectivity>
							</div>
						</div>
					</fieldset>
				</div>

				<div class="col-sm-3 col-md-3 col-lg-3">
					<fieldset>
						<div class="form-group">
							<div class="col-md-4">
								<button class="btn btn-success" type="button" 
									ng-click="searchAssignedList()">
									<i class="fa fa-search"></i> Search
								</button>
							</div>
							<div class="col-md-4" style="padding-left: 13px;">
								<button class="btn btn-info" type="button"  
									ng-click="reset()">
									<i class="fa fa-refresh"></i>Reset
								</button>
							</div>
							 <div class="col-md-4" style="padding-left: 13px;">
								<button class="btn btn-danger" type="button"  
									ng-click="cancel()">
									<i class="fa fa-close"></i></i>Cancel
								</button>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
			<div class="table-responsive" style="border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head"
						style="background-color: #e2e2e2;">
						<tr>
						    <th class="sorting width_8" st-sort="bookingno">Booking No.</th>
							<th class="sorting width_10" st-sort="vesselName">Ex-Vessel</th>
							<th class="sorting width_10" st-sort="voyageName">Ex-Voyage</th>
							<th class="sorting width_10" st-sort="assignvessel">Assigned-Vessel</th>
							<th class="sorting width_10" st-sort="assignvoyage">Assigned-Voyage</th>
							<th class="sorting width_6" st-sort="pol">POL </th>
							<th class="sorting width_5" st-sort="pot">POT</th>
							<th class="sorting width_6" st-sort="fpod">POD</th>
							<th class="sorting width_8" st-sort="assignedBy">Assigned By</th>
							<th class="sorting width_8" st-sort="assignedDate1">Assigned Date</th>
							<!-- <th class="width_3 text-center">Action</th> -->
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection1">
							<td>{{item.bookingno}}</td>
							<td>{{item.vesselName}}</td>
							<td>{{item.voyageName}}</td>
							<td>{{item.assignvessel}}</td>
 							<td>{{item.assignvoyage}}</td>
							<td>{{item.pol}}</td>
							<td>{{item.pot}}</td>
 							<td>{{item.fpod}}</td>
							<td>{{item.assignedBy}}</td>
							<td>{{item.assignedDate}}</td>

							<%-- <td class=" td-actions text-center">
								<table class="icontable" style="width: 100%;">
									<tr>
										<td><security:authorize
												access="hasRole('${form_code}_${view}')">
												<span> <i class="fa fa-eye text-success text"
													data-toggle="tooltip" title="View"
													data-ng-click="viewRow(item.vesselArrivalId,item.isTransit)"></i>
												</span>
											</security:authorize></td>

										<td><security:authorize
												access="hasRole('${form_code}_${modify}')">
												<span> <i class="fa fa-pencil text-success text"
													data-toggle="tooltip" title="Edit"
													data-ng-click="editRow(item.vesselArrivalId,item.isTransit)"></i>
												</span>
											</security:authorize></td>

										<td><security:authorize
												access="hasRole('${form_code}_${delete}')">
												<span> <i class="fa fa-trash-o text-danger-dker text"
													data-toggle="tooltip" title="Delete"
													data-ng-click="deleteRow(item.itemId)"></i>
												</span>
											</security:authorize></td>
											
											<td><span> <i class="fa fa-file-excel-o"
												data-toggle="tooltip" title="Export Excel"
												data-ng-click="exportExcelNew(item.vesselArrivalId,item.isTransit)"></i>
												
												<a id="Export" stype="display:none"
											href="filePath/Discharge.xlsx"
											download="Discharge.xlsx"></a>

										</span></td>


									</tr>

									<tr>

										 

									</tr>

								</table>

							</td> --%>

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