

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
	<div class="panel panel-default panel-default-list" st-persist="empMasterTable"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>
 
 <div class="panel-body float-left padding-0" style="width: 100%;">
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer"
     role="grid" aria-describedby="dt_basic_info" >
     <thead>
      <tr>
       <!-- <th class="width_1 text-center table-heading"><label class="i-checks m-b-none"><input type="checkbox" ><i></i>
       </label></th> -->
      <th class="sorting width_15" st-sort="organisationName">Organization Name</th>      
       <th class="sorting width_15" st-sort="costCenterCode">Cost Center Code</th>
        <th class="sorting width_15" st-sort="costCenterName">Cost Center Name</th>
       <th class="sorting width_15" st-sort="costCenterDescription">Description</th>
       <th class="sorting width_15" st-sort="status">Status</th>
     	<th class="sorting width_8">Action</th>
      </tr>
     </thead>
      <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" data-ng-repeat="manageCostCenter in displayedCollection">
           <!-- <td data-cs-select="designation"></td> -->
           <td>{{manageCostCenter.companyId}}</td>      
           <td>{{manageCostCenter.costCenterCode}}</td>
           <td>{{manageCostCenter.costCenterName}}</td>
           <td>{{manageCostCenter.costCenterDescription}}</td>
           <td><input type="checkbox" checked="checked" ng-model="manageCostCenter.status" disabled="disabled"></td> 
        <td class=" td-actions text-center">
            <security:authorize access="hasRole('${form_code}_${modify}')">
	        <span>
	         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(manageCostCenter.costCenterId)"></i>
	        </span>
	        </security:authorize>
	         <security:authorize access="hasRole('${form_code}_${delete}')">
	        <span>
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(manageCostCenter.costCenterId)"></i>
	        </span>
	        </security:authorize>
	       </td>
          </tr>
     </tbody>
    </table>
<!--   <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->     
   <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
   </div>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>