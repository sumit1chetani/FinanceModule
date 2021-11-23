<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list" st-persist="containerStatusSequenceTable"
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
							
							<th class="sorting width_30" st-sort="sequence">CMS Code</th>
							
							<th class="sorting width_30" st-sort="sequenceS">Possible Sequence</th>
		                    
							<th class="sorting width_10" >Action</th>	
						</tr>
					</thead>
					<tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="item in displayedCollection">
	
							<td class="sorting" data-toggle="tooltip"
												title="{{item.sequence}}"><a ng-click="viewRow(item.sequence)"> <span
									tooltip="{{item.sequence}}"
									class="tool-tip-span font-blue ">{{item.sequence}}</span></a></td>
												
							<td class="" data-toggle="tooltip"
												title="{{item.direction}}">{{item.sequenceS}}</td>
												
							
							<td class=" td-actions text-center"> <security:authorize
									access="hasRole('${form_code}_${modify}')">
									<span> <i class="fa fa-eye text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="editRow(item.sequence)"></i>
									</span>
								</security:authorize>  <security:authorize access="hasRole('${form_code}_${delete}')"> 
									<span> <i class="fa fa-trash-o text-danger-dker text" data-toggle="tooltip" title="Delete"
										data-ng-click="deleteRow(item.sequence)"></i>
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