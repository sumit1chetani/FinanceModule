<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
						<tr>
							<th class="sorting" st-sort="locationName">Location Name</th>

							<th class="sorting" st-sort="shortName">Short Name</th>
							
														<th class="sorting" st-sort="countryName">Country Name</th>
							

							<th class="sorting" st-sort="landMark">LandMark</th>
							
								<th class="sorting" st-sort="type">Type</th>
							
							<th class="sorting" st-sort="description">Description</th>
							<th class="sorting" st-sort="latitude">Latitude</th>
							<th class="sorting" st-sort="longitude">Longitude</th>
							<!-- 								<th>Distance</th>
 -->
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<tr class="route"
							ng-repeat="location in displayedCollection track by $index">
							<td class="wrapping" data-toggle="tooltip"
												title="{{location.locationName}}">{{location.locationName}}</td>
							<td class="wrapping" data-toggle="tooltip"
												title="{{location.shortName}}">{{location.shortName}}</td>
												
												<td class="wrapping" data-toggle="tooltip"
												title="{{location.shortName}}">{{location.countryName}}</td>
												

							<td class="wrapping" data-toggle="tooltip"
												title="{{location.landMark}}">{{location.landMark}}</td>
												
																			<td>{{location.type}}</td>
												
												
							<td class="wrapping" data-toggle="tooltip"
												title="{{location.description}}">{{location.description}}</td>
												
							<td>{{location.latitude}}</td>
							<td>{{location.longitude}}</td>
							<!-- 								<td>{{stopping.distance}}</td>
 -->
							<td class="td-actions text-center width_1">
							<security:authorize access="hasRole('${form_code}_${modify}')"> 
							<span
								class="edit-button  padding-right-5"
								data-ng-click="editRow(location.locationId)" tooltip="Edit Row"> <i
									class="fa  fa-pencil text-success text"></i>
							</span>
							</security:authorize>
							<security:authorize access="hasRole('${form_code}_${delete}')"> 
							 <span class="delete-button" data-ng-click="deleteRow(location.locationId)"
								tooltip="Delete Row"> <i
									class="fa fa-trash-o text-danger-dker tex"></i>
							</span>
							</security:authorize>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>