<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		 <style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>
		<div class="panel-body float-left padding-10" style="width: 100%;">
			<div class="table-responsive" style=" border: 1px solid #CCC;"> 
				<table class="table table-striped table-hover dataTable no-footer">
					<thead class="dataTables-Main-Head">
					<thead style="background-color: #e2e2e2;">
						<tr>
							<!--        <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i> -->
							<!--        </label></th> -->
							<th class="sorting width_30" st-sort="code">Code</th>
							<th class="sorting width_35" st-sort="name"> Name</th>
													<th class="sorting width_35" st-sort="description"> Description</th>
						
														<th class="sorting width_30" st-sort="crtdBy">Created By</th>
														<th class="sorting width_30" st-sort="crtdDate">Created Date</th>
														<th class="sorting width_30" st-sort="mdyBy">Modified By</th>
														<th class="sorting width_30" st-sort="mdyDate">Modified Date</th>
																			<th class="sorting width_30" st-sort="isActive">Active</th>
							
							<th class="sorting width_30">Action</th>
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="objGroupHeadItem in displayedCollection">
							 <td class="sorting">
							 
							 <a ng-click="view(objGroupHeadItem.chargeHeadGroupid)">
							 <security:authorize access="hasRole('${form_code}_${view}')"> 
		             <span tooltip="{{objGroupHeadItem.code}}" class="tool-tip-span font-blue">{{objGroupHeadItem.code}}</span>
		        </security:authorize>
		         </a>
       </td> 
							
							<td class="" data-toggle="tooltip"
												title="{{objGroupHeadItem.name}}">{{objGroupHeadItem.name}}</td>
										<td class="" data-toggle="tooltip"
												title="{{objGroupHeadItem.name}}">{{objGroupHeadItem.description}}</td>
												<td class="sorting" data-toggle="tooltip"
												title="{{objGroupHeadItem.crtdBy}}">{{objGroupHeadItem.crtdBy}}</td>
												<td class="sorting" data-toggle="tooltip"
												title="{{objGroupHeadItem.crtdDate}}">{{objGroupHeadItem.crtdDate}}</td>
												<td class="sorting" data-toggle="tooltip"
												title="{{objGroupHeadItem.mdyBy}}">{{objGroupHeadItem.mdyBy}}</td>
<td class="sorting" data-toggle="tooltip"
												title="{{objGroupHeadItem.mdyDate}}">{{objGroupHeadItem.mdyDate}}</td>
												<td class="sorting" data-toggle="tooltip"
												title="False" ng-if="objGroupHeadItem.isStstus=='f'">False</td>
												<td class="sorting" data-toggle="tooltip"
												title="True" ng-if="objGroupHeadItem.isStstus=='t'">True</td>
							<td class=" td-actions text-center"> <security:authorize
									access="hasRole('${form_code}_${modify}')"> 
									<span> <i class="fa fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(objGroupHeadItem.chargeHeadGroupid)"></i>
									</span>
								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(objGroupHeadItem.chargeHeadGroupid)"></i>
									</span>
								 </security:authorize></td> 
						</tr>
					</tbody>

				</table>
			 </div> 
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>