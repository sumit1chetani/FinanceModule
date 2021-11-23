<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->   
   <%@include file="/views/templates/panel-header.jsp"%>
  <!-- </div> -->
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <div class="table-responsive ">
   <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head"><tr>
								<th class="sorting width_8" st-sort="truckNo">Truck Model</th>
								<th class="sorting width_8" st-sort="licensePlate">Plate No.</th>
								<th class="sorting width_8" st-sort="weightBear">Registration No.(VIN)</th>
								
								<!-- <th class="sorting width_3" st-sort="permitExpiry">Driver Name
									</th> -->
								<th class="sorting width_3" st-sort="insuranceExpiry">Year Model</th>
								
<!-- 								<th class="sorting width_3" st-sort="weightBear">Location</th>
 --><!-- 								<th class="sorting width_3" st-sort="status">Status</th> -->
                          <th class="sorting width_8" st-sort="isActive">Status</th>
								<th class="sorting width_3">Action</th>
							</tr>
						</thead>

						<tbody>
							<tr class="asset" ng-repeat="objItem in displayedCollection">
								<td class="sorting"><a ng-click="view(objItem)">
								
								<security:authorize access="hasRole('${form_code}_${view}')"> 
								 <span tooltip="{{objItem.model}}" class="tool-tip-span font-blue">{{objItem.model}}</span>
								 </security:authorize>
								  </a></td>
								
								 <td class="sorting"><a ng-click="view(objItem)">								
											 <span tooltip="{{objItem.model}}" class="tool-tip-span font-blue">{{objItem.licensePlate}}</span>
								  </a></td>
								  
									<!-- <td class="sorting width_10">{{objItem.licensePlate}}</td> -->
																	<td class="sorting width_10">{{objItem.truckRegNo}}</td>
									
<!-- 								<td class="sorting width_10">{{objItem.currentDriver}}</td>
 -->								<td class="sorting width_10">{{objItem.modelYear}}</td>
<!-- 								<td class="sorting width_10">{{objItem.location}}</td>
 --><!-- 								<td class="sorting width_10">{{objItem.status}}</td> -->
                             
                             
                             <td class="sorting width_10">
                              <div ng-if="objItem.isActive">
                              Active  
                              </div>
                               <div  ng-if="!objItem.isActive ">
                              In Active  
                              </div>
                               </td>
<!--                               <td ng-if ="objItem.isActive != 'true'"class="sorting width_10"></td> -->
                             <!-- <input type="checkbox" checked="checked"
								disabled="disabled" ng-model="objItem.isActive"> -->
								
								
								<td class="td-actions text-center width_1">
								<security:authorize access="hasRole('${form_code}_${modify}')"> 
								<span
									class="edit-button  padding-right-5"
									data-ng-click="editRow(objItem)" tooltip="Edit Row">
										<i class="fa  fa-pencil text-success text"></i>
								</span> 
								</security:authorize>
								<security:authorize access="hasRole('${form_code}_${delete}')"> 
								<span class="delete-button"
									data-ng-click="deleteRow(objItem)"
									tooltip="Delete Row"> <i
										class="fa fa-trash-o text-danger-dker tex"></i>
								</span>
								</security:authorize></td>

							</tr>
						</tbody>
					</table>

				</div>
					<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
			<div class="col-md-1">
			<span class="padding-left-10" style=" margin-left: auto;">
		 		<a class="btn btn-success btn-sm" data-ng-click="helpVideo('Add truck','Truck Help')">  Help video</a>	         	
		    </span>
		   
	   </div>
				
			</div>
		</div>
	</div>





