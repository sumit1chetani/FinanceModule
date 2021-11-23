 
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		 
		<div >
			<form class="form-horizontal" name="Stackusageform" novalidate
				method="post">
					<div class="panel panel-default panel-default-list"
					st-table="displayedCollection" st-safe-src="rowCollection"
					 >
					<%@include file="/views/templates/panel-header.jsp"%>
					<div class="panel-body">
						<div class="table-responsive" style=" border: 1px solid #CCC;">
							<table
								class="table table-striped b-t b-light table-hover dataTable no-footer">
								<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
									<tr>

										<th class="width_12" st-sort="fromdate">From Date</th>
										<th class="width_12" st-sort="todate">To Date</th>
										<th class="width_12" st-sort="location">Location</th>
										<th class="width_12" st-sort="location">Mode</th> 
										<th class="width_5">Action</th>

									</tr>
								</thead>
								<tbody ng-repeat="data in displayedCollection">
									<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'">
 										<td class="width_12"><span
											tooltip="{{data.fromdate}}" class="tool-tip-span">
												{{data.fromdate}}</span></td>
										<td class="width_12"><span tooltip="{{data.todate}}"
											class="tool-tip-span"> {{data.todate}}</span></td>
										<td class="width_12"><span tooltip="{{data.rotationNo}}"
											class="tool-tip-span"> {{data.location}}</span></td>
										<td class="width_12"><span tooltip="{{data.rotationNo}}"
											class="tool-tip-span"> {{data.modeName}}</span></td>	
										 	<td class="width_5"> <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(data.slNo)"></i>
									</span>
								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(data.slNo)"></i>
									</span>
								 </security:authorize></td> 
									</tr>
								</tbody>


							</table>


						</div>
						<table>
						</table>
						<footer class="panel-footer" style="padding:0px;">
							<%@include file="/views/templates/panel-footer-static.jsp"%>
						</footer>

					</div>
				</div>
			 
			</form>
		</div>
	</div>
</div> 