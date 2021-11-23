

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
<style>
	table {width:100%; table-layout: fixed;}
table td {word-wrap:break-word;}

</style>

 <div class="panel panel-default panel-default-list" st-persist="loanEntryTable" 
 st-table="displayedCollection" st-safe-src="rowCollection">
  <%@include file="/views/templates/panel-header.jsp"%>
  <div class="panel-body float-left padding-0" style="width: 100%;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <!-- <th class="width_1 text-center table-heading"><label class="i-checks m-b-none"><input type="checkbox" ><i></i>
       </label></th> -->
      <th class="sorting width_15" st-sort="fromdate">From Date</th>      
       <th class="sorting width_15" st-sort="todate">To Date</th>
        <th class="sorting width_15" st-sort="companyName">Company Code</th>
     	<th class="sorting width_8" style="text-align:center"
										 type="button">Action</th>
      </tr>
     </thead>
      <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" data-ng-repeat="accountingYearClose in displayedCollection">
           <!-- <td data-cs-select="designation"></td> -->
           <td>{{accountingYearClose.fromdate}}</td>      
           <td>{{accountingYearClose.todate}}</td>
           <td>{{accountingYearClose.companyName}}</td>
          <!--  <td><input type="checkbox" checked="checked" ng-model="manageCostCenter.status" disabled="disabled"></td>  -->
        <td class=" td-actions text-center">
        
            <security:authorize access="hasRole('${form_code}_${modify}')">
	        <span>
	         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(accountingYearClose.closingAccountId)"></i>
	        </span>
	        </security:authorize>
	         <security:authorize access="hasRole('${form_code}_${delete}')">
	        <span>
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(accountingYearClose.closingAccountId)"></i>
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