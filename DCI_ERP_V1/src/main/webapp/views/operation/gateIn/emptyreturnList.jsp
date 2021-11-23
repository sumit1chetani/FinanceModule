<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

   
	<div class="panel panel-default panel-default-list" st-persist="gateInTable" st-table="displayedCollection" st-safe-src="rowCollection" >
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
							<th class="sorting width_2 text-center" st-sort="gateInNo">Gate  No</th>
							<th class="sorting width_2 text-center" st-sort="gateInNo">Gate OUT No</th>
							<th class="sorting width_2 text-center" st-sort="bookingNo">Booking No.</th>
							<th class="sorting width_2 text-center" st-sort="customerName">Customer</th>
							<th class="sorting width_2 text-center" st-sort="returnDate">Gate IN Date</th>
							<th class="sorting width_2 text-center" ng-hide="true">state</th>
							<th class="sorting width_2 text-center" st-sort="createdBy">Creted By</th>
							<th class="sorting width_2 text-center" st-sort="createdDate">Created Date</th>
							<th class="sorting width_2 text-center" st-sort="modifiedBy">Modified By</th>
							<th class="sorting width_2 text-center" st-sort="modifiedDate">Modified Date</th>
							<th class=" width_2 text-center" >Actions</th>
                      </tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="collection in displayedCollection">
							
							<td class="text-center"><a ng-click="viewRow(collection.gateInNo)">
		             <span tooltip="{{collection.gateInNo}}" class="tool-tip-span font-blue">{{collection.gateInNo}}</span></a></td>
							<td ng-if="collection.gateInNo==='' || collection.gateInNo===null">  <a> 
		             			<span tooltip="{{collection.gateOutNo}}" class="tool-tip-span font-blue ">{{collection.gateOutNo}}</span>
		        				 </a> </td> 
		       				 <td ng-if="collection.gateInNo !='' && collection.gateInNo !=null"> {{collection.gateOutNo}} </td>
 							<td class="text-center">{{collection.bookingNo}}</td>
							<td class="text-center">{{collection.customerName}}</td>
							<td class="text-center">{{collection.returnDate}}</td>
							<td class="text-center" ng-hide="true">{{collection.shipmentStatus}}</td>
							
							<td class="text-center" >{{collection.createdBy}}</td>
							<td class="text-center" >{{collection.createdDate}}</td>
							<td class="text-center">{{collection.modifiedBy}}</td>
							<td class="text-center"> {{collection.modifiedDate}}</td>
							
							<td class=" td-actions text-center"  ><%-- <security:authorize
									access="hasRole('${form_code}_${modify}')"> --%>
									<span> <i class="fa  fa-pencil text-success text"
										data-ng-click="Approval(collection,collection.gateInNo,collection.shipmentStatus)"></i>
									</span>
								<%-- </security:authorize>  --%>
							
						</tr>
					</tbody>
				</table>
			</div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
			 
		</div>
		
	</div>
	
	
		
 
 