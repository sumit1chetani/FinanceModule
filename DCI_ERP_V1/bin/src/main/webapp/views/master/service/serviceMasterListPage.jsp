<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="serviceMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body float-left padding-0" style="width: 100%;">

			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
						<tr>
							<!-- <th class="width_1">
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label>
       </th> -->
							<th class="sorting width_10" st-sort="sectorCode">Service Code</th>
							<th class="sorting width_10" st-sort="sectorName">Service Name</th>
							<!-- <th class="sorting width_10" st-sort="companyName">Controlled By</th> -->
						   <th class="sorting width_10" st-sort="vendorName">Vessel  Operator</th>
							<th class="sorting width_10" st-sort="sailingfreq">Sailing Frequency</th>
						   <th class="sorting width_10" st-sort="avgtrans">TT Time</th>
							
							<!-- <th class="sorting" st-sort="operationSince">Operation Since</th> -->
							<th class="width_5">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objServiceMasterItem in displayedCollection">
							<!-- <td class="">
        <label class="i-checks m-b-none">
         <input type="checkbox" name="post[]">
         <i></i>
        </label>
       </td> -->

							<td><a ng-click="view(objServiceMasterItem.sectorCode)">
									<span tooltip="{{objServiceMasterItem.sectorCode}}"
									class="tool-tip-span font-blue">{{objServiceMasterItem.sectorCode}}</span>
							</a></td>

							<td>{{objServiceMasterItem.sectorName}}</td>
							<!-- <td>{{objServiceMasterItem.companyName}}</td> -->
							<td>{{objServiceMasterItem.vendorName}}</td>
							<td>{{objServiceMasterItem.sailingfreq}}</td>
							<td>{{objServiceMasterItem.avgtrans}}</td>
							<!-- <td>{{objServiceMasterItem.operationSince}}</td> -->
							<td class=" td-actions text-left"><security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa  fa-pencil text-success text"
										data-ng-click="editRow(objServiceMasterItem.sectorCode,$index)"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(objServiceMasterItem.sectorCode,$index)"></i>
									</span>
								</security:authorize></td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>

			</footer>
		</div>
		<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						
						
						</div>
					</div>
				</div>
	</div>
	<div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						
						
						</div>
					</div>
				</div>
</div>
