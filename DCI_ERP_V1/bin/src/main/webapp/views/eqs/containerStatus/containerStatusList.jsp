

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<style>
table {
	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>

	<div class="panel panel-default panel-default-list" st-persist="containerStatusTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
		<div class="panel-body float-left padding-10" style="width: 100%;">
		<div class="table-responsive" style=" border: 1px solid #CCC;">
			<table class="table table-striped table-hover dataTable no-footer">
				<thead class="dataTables-Main-Head">
				<thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
					<tr>
						<!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
						<th class="sorting width_2" st-sort="containerStatusCode">Code
						</th>
						<!-- <th class="sorting width_6" st-sort="containerStatusName">ContainerStatus Short Name</th> -->
						<th class="sorting width_4" st-sort="containerStatusDescription">Description</th>
												<th class="sorting width_2" st-sort="containerStatusDescription">Depot</th>	
												<th class="sorting width_2" st-sort="containerStatusDescription">Customer</th>	
												<th class="sorting width_2" st-sort="containerStatusDescription">Shipper</th>	
												<th class="sorting width_2" st-sort="containerStatusDescription">Consignee</th>	
												<th class="sorting width_2" st-sort="containerStatusDescription">Vessel</th>	
												<th class="sorting width_2" st-sort="containerStatusDescription">Voyage</th>	
												<th class="sorting width_2" st-sort="containerStatusDescription">POL</th>	
												<th class="sorting width_2" st-sort="containerStatusDescription">POD</th>	
							
						
											
						<th class="width_2 text-center table-heading">Action</th>
					</tr>
				</thead>
				<tbody class="dataTables-Main-Body">
					<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
						ng-repeat="objContainerStatusListItem in displayedCollection">
						<td class="sorting">
<%-- 						<security:authorize
								access="hasRole('${form_code}_${view}')">
 --%>								<a ng-click="view(objContainerStatusListItem.containerStatusCode)"> <span
									tooltip="{{objContainerStatusListItem.containerStatusCode}}"
									class="tool-tip-span font-blue">{{objContainerStatusListItem.containerStatusCode}}</span>
<%-- 							</security:authorize> 
 --%>							</a></td>						
						<td class="wrapping" data-toggle="tooltip"
							title="{{objContainerStatusListItem.containerStatusDescription}}">{{objContainerStatusListItem.containerStatusDescription}}</td>
						
						<td class="sorting" data-toggle="tooltip"
												title="{{objContainerStatusListItem.depot}}">
												<label class="i-checks">
												<input type="checkbox"
											message-id="depot" id="depot"
											class="checkbox style-0" name="depot"
											ng-model="objContainerStatusListItem.depot" disabled="disabled"><i></i></label>
												</td> 
												<td class="sorting" data-toggle="tooltip"
												title="{{objContainerStatusListItem.customer}}">
												<label class="i-checks">
												<input type="checkbox"
											message-id="customer" id="customer"
											class="checkbox style-0" name="customer"
											ng-model="objContainerStatusListItem.customer" disabled="disabled"><i></i></label>
												</td> 
												<td class="sorting" data-toggle="tooltip"
												title="{{objContainerStatusListItem.shipper}}">
												<label class="i-checks">
												<input type="checkbox"
											message-id="shipper" id="shipper"
											class="checkbox style-0" name="shipper"
											ng-model="objContainerStatusListItem.shipper" disabled="disabled"><i></i></label>
												</td> 
												<td class="sorting" data-toggle="tooltip"
												title="{{objContainerStatusListItem.consignee}}">
												<label class="i-checks">
												<input type="checkbox"
											message-id="consignee" id="consignee"
											class="checkbox style-0" name="consignee"
											ng-model="objContainerStatusListItem.consignee" disabled="disabled"><i></i></label>
												</td> 
												<td class="sorting" data-toggle="tooltip"
												title="{{objContainerStatusListItem.vessel}}">
												<label class="i-checks">
												<input type="checkbox"
											message-id="vessel" id="vessel"
											class="checkbox style-0" name="vessel"
											ng-model="objContainerStatusListItem.vessel" disabled="disabled"><i></i></label>
												</td> 
												<td class="sorting" data-toggle="tooltip"
												title="{{objContainerStatusListItem.voyage}}">
												<label class="i-checks">
												<input type="checkbox"
											message-id="voyage" id="voyage"
											class="checkbox style-0" name="voyage"
											ng-model="objContainerStatusListItem.voyage" disabled="disabled"><i></i></label>
												</td> 
												<td class="sorting" data-toggle="tooltip"
												title="{{objContainerStatusListItem.pol}}">
												<label class="i-checks">
												<input type="checkbox"
											message-id="pol" id="pol"
											class="checkbox style-0" name="pol"
											ng-model="objContainerStatusListItem.pol" disabled="disabled"><i></i></label>
												</td> 
												<td class="sorting" data-toggle="tooltip"
												title="{{objContainerStatusListItem.pod}}">
												<label class="i-checks">
												<input type="checkbox"
											message-id="pod" id="pod"
											class="checkbox style-0" name="pod"
											ng-model="objContainerStatusListItem.pod" disabled="disabled"><i></i></label>
												</td> 
						
						
						
						
						<!-- <td class="wrapping" data-toggle="tooltip"
							title="{{objContainerStatusListItem.containerStatusShortName}}">{{objContainerStatusListItem.containerStatusShortName}}</td>	 -->
						
						<td class="td-actions text-center">
<%-- 						<security:authorize access="hasRole('${form_code}_${modify}')">
 --%>								<span class="width_15"> <i
									class="fa fa-pencil text-success text" data-toggle="tooltip" title="Edit"
									data-ng-click="editRow(objContainerStatusListItem.containerStatusCode)"
									tooltip="Edit"></i>
								</span>
<%-- 							</security:authorize> 
<%--  --%>							
<%-- <security:authorize access="hasRole('${form_code}_${delete}')">
 --%> 							<span class="width_10"> <i
									class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
									data-ng-click="deleteRow(objContainerStatusListItem.containerStatusCode,$index)"
									tooltip="Delete"></i>
								</span>
<%-- 							</security:authorize>
 --%>							</td>
					</tr>
				</tbody>
			</table>
			<footer class="panel-footer panel-footer-list" style="padding:0px;">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
		</div>
		<!-- end widget content -->
	</div>
</div>
