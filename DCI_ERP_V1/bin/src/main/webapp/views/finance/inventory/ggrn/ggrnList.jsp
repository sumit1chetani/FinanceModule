<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!-- #MAIN CONTENT -->
<div class="wrapper-md">
    <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   	<%@include file="/views/templates/panel-header.jsp"%>
     <div class="panel panel-default">
      <div  class="panel-body">
       <div class="table-responsive">
        
       <table class="table table-striped table-hover dataTable no-footer">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox"> <i></i>
           </label></th>
           <th class="sorting width_10" data-st-sort="">GRN No</th>
           <th class="sorting width_10" data-st-sort="">GRN Date</th>
           <th class="sorting width_10" data-st-sort="">Supplier</th>
           <th class="sorting width_10" data-st-sort="">Purchase Order</th>
           <th class="sorting width_10" data-st-sort="">Requisition</th>
           <th class="width_6 text-center table-heading">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
           ng-repeat="objGrnList in displayedCollection">
           <td class="width_1"><label class="i-checks m-b-none"> <input type="checkbox"
             name="post[]"> <i></i>
           </label></td>
           <td class="" ng-bind="objGrnList.grnCode"></td>
           <td class="" ng-bind="objGrnList.grnDate"></td>
           <td class="" ng-bind="objGrnList.vendorName">{{}}</td>
           <td class="" ng-bind="objGrnList.poNo">{{}}</td>
           <td class="" ng-bind="objGrnList.poRequisition"></td>
           <td class=" td-actions text-center">
		          <span>
		             <i class="fa fa-list-alt text-dark text"
		             data-ng-click="editRowBtn(objGrnList.grnCode)"></i>
		          </span>
	          <%--  <security:authorize access="hasRole('F0033_D')">
	           <span> <i class="fa fa-trash-o text-danger-dker text"
	             data-ng-click="deleteRow(objGrnList.grnCode,$index)"></i>
	           </span>
	           </security:authorize> --%>
           </td>
          </tr>
         </tbody>
        </table>
       </div>
        <footer class="panel-footer">
	    <%@include file="/views/templates/panel-footer-static.jsp"%>
	   </footer>
      </div> <!-- /panel-body -->	
    </div>  <!-- /panel panel-default -->
   </div> <!-- /panel-default-list -->   
</div><!-- /wrapper-md -->