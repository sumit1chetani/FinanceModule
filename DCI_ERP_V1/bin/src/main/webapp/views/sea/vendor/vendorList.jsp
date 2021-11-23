<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<!-- <div class="panel-heading panel-heading-list padding-right-0 padding-left-0 float-left font-bold"> -->
		<%@include file="/views/templates/panel-header.jsp"%>
		<!-- </div> -->
		<style>
table {


	width: 100%;
	table-layout: fixed;
}

table td {
	word-wrap: break-word;
}
</style>
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox"> <i></i>
           </label></th> -->
           <th class="sorting width_5" st-sort="entityName">Entity Name</th>
           <th class="sorting width_5" st-sort="contactPerson">Contact Person</th>
           <th class="sorting width_5" st-sort="jobPosition">Job Position</th>
<!--            <th class="sorting width_5" st-sort="tinNumber">Tin Number</th>
           <th class="sorting width_5" st-sort="cstNumber">CST Number</th> -->
           <th class="sorting width_5" st-sort="panNumber">PAN Number</th>
           <th class="width_5 text-center table-heading">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
           ng-repeat="objSupplierListItem in displayedCollection">
           <!-- <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox"
             ng-model="objSupplierListItem.select" id="select{{trIndex}}"><i></i></label></td> -->
           <td class="width_15" ng-bind="objSupplierListItem.entityName"></td>
           <td class="width_10" ng-bind="objSupplierListItem.contactPerson"></td>
           <td class="width_10" ng-bind="objSupplierListItem.jobPosition"></td>
         <!--   <td class="width_10" ng-bind="objSupplierListItem.tinNumber"></td>
           <td class="width_15" ng-bind="objSupplierListItem.cstNumber"></td> -->
           <td class="width_15 text-right" ng-bind="objSupplierListItem.panNumber"></td>
           <!-- <td class="width_30" ng-bind="objCreditNoteListItem.approveStatus">
	       </td> -->
           <td class="td-actions text-center">
<%--            <security:authorize access="hasRole('${form_code}_${modify}')">
 --%>            <span class="width_15"> 
             <i class="fa fa-pencil text-success text"
             data-ng-click="editRowBtn(objSupplierListItem.entityId)" tooltip="Edit"></i>
           </span>
<%--            </security:authorize>
 --%>	       
 
<%--   <security:authorize access="hasRole('${form_code}_${delete}')"> 
 --%>           <span class="width_10"> <i
             class="fa fa-trash-o text-danger-dker text"
             data-ng-click="deleteRow(objSupplierListItem.entityId,$index)" tooltip="Delete"></i>
           </span> 
<%--            </security:authorize>
 --%>           </td>
          </tr>
         </tbody>
        </table>
        	<footer class="panel-footer panel-footer-list" style="padding:0px;">
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
<!-- label.decease=Disease -->