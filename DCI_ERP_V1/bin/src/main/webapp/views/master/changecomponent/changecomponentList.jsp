<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		 <style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>
		<div class="panel-body float-left padding-0" style="width: 100%;">
			<!-- <div class="table-responsive "> -->
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead>
						<tr>
							<!--        <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i> -->
							<!--        </label></th> -->
							<th class="sorting width_30" st-sort="groupHeadCode">Charge
								Code</th>
							<th class="sorting width_35" st-sort="subGroupAcctCode">Charge
								Name</th>
							<th class="sorting width_30" st-sort="subGrpAcctName">Charge
								Type</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objGroupHeadItem in displayedCollection">
							 <td class="sorting">
							 <security:authorize access="hasRole('${form_code}_${view}')"> 
							 <a ng-click="view(objGroupHeadItem.chargeComponentid)">
		             <span tooltip="{{objGroupHeadItem.chargeCode}}" class="tool-tip-span font-blue">{{objGroupHeadItem.chargeCode}}</span>
		        </security:authorize>
		         </a>
       </td> 
							
							<td class="" data-toggle="tooltip"
												title="{{objGroupHeadItem.chargeName}}">{{objGroupHeadItem.chargeName}}</td>
							<td class="sorting" data-toggle="tooltip"
												title="{{objGroupHeadItem.chargeTypeid}}">{{objGroupHeadItem.chargeTypeid}}</td>

							<td class=" td-actions text-center"> <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa fa-pencil text-success text"
										data-ng-click="editRow(objGroupHeadItem.chargeComponentid)"></i>
									</span>
								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text"
										data-ng-click="deleteRow(objGroupHeadItem.chargeComponentid)"></i>
									</span>
								 </security:authorize></td> 
						</tr>
					</tbody>

				</table>
			<!-- </div> -->
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>