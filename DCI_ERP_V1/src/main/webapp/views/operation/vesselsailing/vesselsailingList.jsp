<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-persist="vesselSailingTable" st-table="displayedCollection"
		st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive" style="border: 1px solid #CCC;">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							<!-- <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></th> -->
       							
       
							<th class="sorting width_20" st-sort="vessel">Vessel</th>
							<th class="sorting width_15" st-sort="vessel">Mode</th>
       							<th class="sorting width_20" st-sort="vessel">Carrier</th>
							<th class="sorting width_15" st-sort="sail_Date">Sail Date</th>
							<th class="sorting width_20" st-sort="voyage">Voyage</th>
							<th class="sorting width_20" st-sort="port">Port</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objdepartmentItem in displayedCollection">
							<!-- <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i>
       </label></td> -->
							<td class="sorting"><a
								ng-click="View(objdepartmentItem.vesselSailingId)"> <span
									tooltip="{{objdepartmentItem.vesselSailingId}}"
									class="tool-tip-span font-blue">
										{{objdepartmentItem.vessel}}</span></a></td>
							<!-- <td>{{objdepartmentItem.deptCode}}</td> -->
														<td>{{objdepartmentItem.mode}}</td>
														<td>{{objdepartmentItem.carrier}}</td>
							
							<td>{{objdepartmentItem.sail_Date}}</td>
							<td>{{objdepartmentItem.voyage}}</td>
							<td>{{objdepartmentItem.port}}</td>
							<td class=" td-actions text-center">
								<%--         <security:authorize access="hasRole('${form_code}_${export}')">
         <span>
          <i class="fa  fa-download text-primary text"data-toggle="tooltip" title="Export Manifest"
          data-ng-click="exportManifest(objdepartmentItem)"></i>
         </span>
        </security:authorize> --%> <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa  fa-pencil text-success text"
										data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(objdepartmentItem.vesselSailingId)"></i>
									</span>
								</security:authorize> <security:authorize access="hasRole('${form_code}_${delete}')">
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(objdepartmentItem.vesselSailingId,$index)"></i>
									</span>
								</security:authorize> <span class="fa fa-file-excel-o" style="color:blue" title="Export TDR"
								data-ng-click="getReport(objdepartmentItem)"></span> <a
								id="vesselsailingsave" stype="display:none"
								href="filePath/VesselSailling.xlsx" download="TDR_REPORT.xlsx"></a>
								<span> <i class="fa  fa-print text-success text"
									title="TDR Print"
									data-ng-click="printsailingportDiv(objdepartmentItem.voyage,objdepartmentItem.port)"></i>
							</span>
							<!-- <span> <i class="icon-envelope red"
									title="Send Mail"
									data-ng-click="sendMail(objdepartmentItem)"></i>
							</span> -->
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