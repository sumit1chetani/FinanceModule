

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



     <div role="content">
      <div class="widget-body no-padding">
       <div
        class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
        data-st-table="displayedCollection"
        data-st-safe-src="rowCollection">
         <div class="dt-toolbar">
<%-- 		<%@include file="/views/templates/panel-header-form.jsp"%>		
 --%>		</div>
        <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead>
     <tr>
       <!-- <th class="width_1 text-center table-heading">
        <label class="i-checks m-b-none">
         <input type="checkbox">
         <i></i>
        </label>
       </th> -->
       <th class="sorting width_10" st-sort="bankCode">Bank Code</th>
       <th class="sorting width_20" st-sort="companyName">Organization</th>
       <th class="sorting width_30" st-sort="accountHeadName">Bank Account Head Name</th>
              <th class="sorting width_20" st-sort="bankshort">Bank Short Code</th>
       
              <th class="sorting width_20" st-sort="branch">Branch</th>
       
       <th class="text-center table-heading width_10">Action</th>
      </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objGroupHeadItem in displayedCollection">
       <!-- <td data-cs-select="objGroupHeadItem" class="text-center"></td> -->
        <td class="sorting">{{objGroupHeadItem.bankCode}}</td>
       <td class="">{{objGroupHeadItem.companyName}}</td>
       <td class="sorting">{{objGroupHeadItem.accountHeadName}}</td>
              <td class="sorting">{{objGroupHeadItem.bankshort}}</td>
       
              <td class="sorting">{{objGroupHeadItem.branch}}</td>
       

       <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
         <!-- <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objGroupHeadItem,$index)"></i> -->
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objGroupHeadItem.bankCode,$index)"></i>
        </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objGroupHeadItem.bankCode)"></i>
        </span>
        
        </security:authorize>
       </td> 
      </tr>
     </tbody>

    </table>
       <!--  <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div> -->
         
         

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