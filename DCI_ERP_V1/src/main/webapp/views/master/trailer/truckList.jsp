<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  <!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->   
   <%@include file="/views/templates/panel-header.jsp"%>
  <!-- </div> -->
  <div class="panel-body float-left padding-0" style="width: 100%;">
   <div class="table-responsive ">
   <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
								<th class="sorting width_2" st-sort="truckNo">Truck No.</th>
								<th class="sorting width_3" st-sort="permitExpiry">Permit Expiry
									</th>
								<th class="sorting width_3" st-sort="insuranceExpiry">Insurance Expiry</th>
								<th class="sorting width_3" st-sort="weightBear">Weight Bear(Kg)</th>
								<th class="sorting width_3" st-sort="status">Status</th>
								<th class="sorting width_2">Action</th>
							</tr>
						</thead>

						<tbody>
							<tr class="asset" ng-repeat="objItem in rowCollection">
								<td class="sorting width_5">{{objItem.truckNo}}</td>
								<td class="sorting width_10">{{objItem.permitExpiryDate}}</td>
								<td class="sorting width_10">{{objItem.insuranceExpiry}}</td>
								<td class="sorting width_10">{{objItem.weightBear}}</td>
								<td class="sorting width_10">{{objItem.status}}</td>
								<td class="td-actions text-center width_1"><span
									class="edit-button  padding-right-5"
									data-ng-click="editRow(objItem)" tooltip="Edit Row">
										<i class="fa  fa-pencil text-success text"></i>
								</span> <span class="delete-button"
									data-ng-click="deleteRow(objItem)"
									tooltip="Delete Row"> <i
										class="fa fa-trash-o text-danger-dker tex"></i>
								</span></td>

							</tr>
						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>
</section>





