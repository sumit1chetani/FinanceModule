<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list"  st-persist="earningTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
      <div class="panel-body padding-0">      
       <div class="table-responsive">
        <table id="dt_basic" class="table table-striped b-t b-light table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="sorting width_15" st-sort="payComponentId">Earning/Deduction Code</th>
           <th class="sorting width_15" st-sort="payComponentName">Earning/Deduction Name</th>
           <th class="sorting width_15" st-sort="payComponentType">Earning/Deduction Type</th>
           <th class="sorting width_15" st-sort="status">Active</th>
            <th class="sorting width_15" st-sort="">Action</th>
         </tr>
        </thead>
          <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="earningDeduction in displayedCollection">
           	<td>{{earningDeduction.payComponentId}}</td>
			<td>{{earningDeduction.payComponentName}}</td>
			<td>{{earningDeduction.type}}</td>
		<!-- 	<td>
             	 <span ng-if="earningDeduction.payComponentType == '1'"><spring:message code="label.earningmaster.earning"></spring:message></span>
                 <span ng-if="earningDeduction.payComponentType == '2'"><spring:message code="label.earningmaster.deduction"></spring:message></span>
                 <span ng-if="earningDeduction.payComponentType == '3'">Calculated</span>
             </td> -->
			<td><input type="checkbox" checked="checked" ng-model="earningDeduction.status" disabled="disabled"></td>
			
			     <td class=" td-actions text-center">
				        <span>
				         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(earningDeduction.payComponentId)" ng-if="earningDeduction.payComponentType != '3' && earningDeduction.payComponentId!='BASIC' && earningDeduction.payComponentId!= 'PTS' && earningDeduction.payComponentId!= 'ARR'" ></i>
				        </span>
				        <span>
				         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(earningDeduction.payComponentId,earningDeduction.permanant)" ng-if="earningDeduction.permanant != true"></i>
				        </span>
				       </td>
          </tr>
         </tbody>
        </table>
       </div>
			<footer class="panel-footer panel-footer-list">
				<%@include file="/views/templates/panel-footer-static.jsp"%>
			</footer>
      </div>
      <div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
						</div>
					</div>
				</div>
		<!-- end widget content -->
	</div>
	</div>
	