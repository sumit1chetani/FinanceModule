
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
     <thead class="dataTables-Main-Head">
      <tr>
       <!-- <th class="width_1 text-center table-heading"><label class="i-checks m-b-none"><input type="checkbox" ><i></i>
       </label></th> -->
       <th class="sorting width_15" st-sort="fyId">Financial Year</th>
       <th class="sorting width_30" st-sort="companyName">Organization</th>
       <th class="sorting width_15" st-sort="fyFrom">Start Date</th>
       <th class="sorting width_15" st-sort="fyTo">End Date</th>
       <!-- <th class="sorting width_15" st-sort="finyearShortId">Financial Short Id</th> -->
       <th class="sorting width_8">Action</th>
      </tr>
     </thead>
      <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" data-ng-repeat="financialYear in displayedCollection">
           <!-- <td data-cs-select="designation"></td> -->
           <td>{{financialYear.fyId}}</td>
           <td>{{financialYear.companyName}}</td>
           <td>{{financialYear.fyFrom}}</td>
           <td>{{financialYear.fyTo}}</td>
           <!-- <td>{{financialYear.fyShortId}}</td> -->

            <td class=" td-actions text-center">
<%--             <security:authorize access="hasRole('${form_code}_${modify}')">
 --%>	        <span>
	         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(financialYear.fyShortId,$index)"></i>
	        </span>
<%-- 	        </security:authorize>
 --%>	       
<%--    <security:authorize access="hasRole('${form_code}_${delete}')">
 --%>	        <span>
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(financialYear.fyShortId,$index)"></i>
	        </span>
<%-- 	        </security:authorize>
 --%>	       </td>
          </tr>
     </tbody>
    </table>
    <footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
       </div>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    <!-- end widget -->
   <!-- WIDGET END -->
