<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-heading panel-heading-form font-bold">
 

</div>
		<div class="panel-body float-left padding-0" style="width: 100%;" >
			<div class="table-responsive ">
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
						
     <tr>
     							<th class="sorting width_2" st-sort="itemName">Item Name</th>
     							<th class="sorting width_2" st-sort="warrenty">Warranty Till</th>
								<th class="sorting width_2" st-sort="lifetime">Approximate Lifetime</th>
								<th class="sorting width_3" st-sort="remainder">Replacement Reminder</th>
								<th class="sorting width_3" st-sort="replacementValue">Replacement Value</th>
								<!-- <th class="sorting width_3">Action</th> -->
								<th class="width_2 text-center table-heading">Action</th>
							</tr>
						</thead>
						
					</thead>
					
					
					<tbody class="dataTables-Main-Body">
					
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objItem in displayedCollection">
										<td class="sorting"><a ng-click="view(objItem.replacementId)">
								
								<security:authorize access="hasRole('${form_code}_${view}')"> 
								 <span tooltip="{{objItem.itemName}}" class="tool-tip-span font-blue">{{objItem.itemName}}</span>
								 </security:authorize>
								  </a></td>
								<!-- <td class="">{{objItem.itemName}}</td> -->
								<td class="">{{objItem.warrenty}}</td>
								<td class="">{{objItem.lifetime}}</td>
								<td class="">{{objItem.remainder}}</td>
								<td class="">{{objItem.replacementValue}}</td>
								
								<td class="td-actions text-center">
								<security:authorize access="hasRole('${form_code}_${modify}')"> 
								<span
									class="edit-button  padding-right-5"
									data-ng-click="editRow(objItem.replacementId)" tooltip="Edit Row">
										<i class="fa  fa-pencil text-success text"></i>
								</span>
								</security:authorize>
								<security:authorize access="hasRole('${form_code}_${delete}')"> 
								 <span class="delete-button" data-ng-click="deleteRow(objItem.replacementId,$index)"
									
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
 





