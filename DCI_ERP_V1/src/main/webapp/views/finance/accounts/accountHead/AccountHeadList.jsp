

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
         <div class="row">
       	 <div class="col-md-12">
         
        <button class="btn btn-primary" type="button" data-ng-click="exportExcel()">
        <span class="fa fa-file-excel-o"> Export Excel</span>
         <a id="budgetExport" stype="display:none"
		href="filePath/AccountHeadReport.xls" download="AccountHeadReport.xls"></a>
       </button>
		       <!--  <button class="btn btn-danger"  type="button" class="btn btn-success" ng-click="cancel()">
		        <i class="fa fa-close"></i>
		        Cancel
		       </button> -->
          </div>
          </div>
          </div>
		 
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
       
        <th class="sorting width_30" st-sort="accountHeadCode">Account Head Code</th>
       <th class="sorting width_30" st-sort="accountHeadName">Account Head Name</th>
       
       <th class="sorting width_20" st-sort="subGroupAccountCode">Sub Group <!-- Account --> Code</th>
              <th class="sorting width_20" st-sort="subname">Sub Group <!-- Account --> Name</th>
       
      <!--  <th class="sorting width_30" st-sort="accountHeadCode">Account Head Code</th>
       <th class="sorting width_30" st-sort="accountHeadName">Account Head Name</th> -->
       <th class="text-center table-heading width_10">Action</th>
      </tr>
      </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objGroupHeadItem in displayedCollection">
       <!-- <td data-cs-select="objGroupHeadItem" class="text-center"></td> -->
       
        <td class="">{{objGroupHeadItem.accountHeadCode}}</td>
       <td class="sorting text-capitalize">{{objGroupHeadItem.accountHeadName | lowercase}}</td>
       
        <td class="sorting ">{{objGroupHeadItem.subGroupAccountCode}}</td>
                <td class="sorting text-capitalize">{{objGroupHeadItem.subname | lowercase}}</td>
        
      <!--  <td class="">{{objGroupHeadItem.accountHeadCode}}</td>
       <td class="sorting">{{objGroupHeadItem.accountHeadName}}</td> -->

       <td class=" td-actions text-center">
        <security:authorize access="hasRole('${form_code}_${modify}')">
        <span>
         <!-- <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objGroupHeadItem,$index)"></i> -->
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objGroupHeadItem.accountHeadCode,$index)"></i>
        </span>
        </security:authorize>
        <security:authorize access="hasRole('${form_code}_${delete}')">
        <span>
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objGroupHeadItem.accountHeadCode,$index)"></i>
        </span>
        </security:authorize>
       </td>
      </tr>
     </tbody>

    </table>
        <!-- <div class="dt-toolbar-footer"
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