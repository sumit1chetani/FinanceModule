<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list" st-persist="emptyRepoTable" 
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<div class="table-responsive ">
				<table id="dt_basic"
					class="table table-striped table-bordered table-hover dataTable no-footer"
					role="grid" aria-describedby="dt_basic_info">
					<thead class="dataTables-Main-Head">
						<tr>
							<!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
							<th class="sorting width_2 text-center table-heading" st-sort="erNo">ER NO</th>
							<th class="sorting width_2 text-center table-heading" st-sort="voyage">Vessel</th>
							<th class="sorting width_2 text-center table-heading" st-sort="voyage">Voyage</th>
							<th class="sorting width_2 text-center table-heading" st-sort="pol">POL</th>
							<th class="sorting width_2 text-center table-heading" st-sort="pod">POD</th>
							<th class="sorting width_2 text-center table-heading" st-sort="exDate">Er Date</th>
							<th class="sorting width_2 text-center table-heading" st-sort="agent">Agent</th>
							<th class="sorting width_2 text-center table-heading" st-sort="">Action</th>
							
</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection in displayedCollection">
							<!-- <td class="">
            <label class="i-checks m-b-none">
             <input type="checkbox" name="post[]">
             <i></i>
            </label>
           </td> -->
					
							<td class="text-center" >{{collection.erNo}}</td>
							<td class="text-center" >{{collection.vessel}}</td>
							<td class="text-center" >{{collection.voyage}}</td>
							<td class="text-center" >{{collection.pol}}</td>
							<td class="text-center" >{{collection.pod}}</td>
							<td class="text-center" >{{collection.exDate}}</td>
							<td class="text-center" >{{collection.agent}}</td>
							<td class=" td-actions text-center">
							 <i class="fa  fa-eye text-success text" style = "font-size: 15px;" data-toggle="tooltip" title="View"
										data-ng-click="viewRow(collection.erNo)"></i>	
						<%-- 	<security:authorize
									access="hasRole('${form_code}_${modify}')"> --%>
									<span> <i class="fa  fa-pencil text-success text"
										data-ng-click="editRow(collection.erNo)"></i>
									</span>
								<%-- </security:authorize> --%> <%-- <security:authorize access="hasRole('${form_code}_${delete}')"> --%>
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(collection.erNo)"></i>
									</span>
								<%-- </security:authorize> --%></td>
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