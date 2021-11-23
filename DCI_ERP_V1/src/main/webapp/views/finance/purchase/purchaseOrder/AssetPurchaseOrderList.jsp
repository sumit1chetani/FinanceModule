<!-- #MAIN CONTENT -->
<style>
.datetimepicker{
width:326px;
}
</style>
<div class="wrapper-md">
  <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  	<%@include file="/views/templates/panel-header.jsp"%>
   <div class="panel panel-default">
    <div class="panel-body">     
    	<input type="hidden" value="${form_code}" id="form_code_id">   
      <div class="table-responsive">
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer"role="grid" 
        	aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <th class="width_1 table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th>
           <th class="sorting width_8" data-st-sort="purchaseOrderNum">Purchase Order No</th>
           <th class="sorting width_7" data-st-sort="purchaseOrderDate">Purchase Order Date</th>
           <th class="sorting width_12" data-st-sort="vendorName">Vendor</th>
           <th class="sorting width_12" data-st-sort="purchaseTypeName">Purchase Type</th>
           <th class="sorting width_7" data-st-sort="purchaseStatus">Status</th>
           <th class="width_8 text-center table-heading">Action</th>
          </tr>
         </thead>
		<tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="collections in displayedCollection">
           <td cs-select="collections"></td>
            <td ng-bind="collections.purchaseOrderNum">{{}}</td>
            <td ng-bind="collections.purchaseOrderDate"></td>
            <td ng-bind="collections.vendorName"></td>
            <td ng-bind="collections.purchaseTypeName"></td>
            <td ng-bind="collections.purchaseStatus"></td>
            <td class=" td-actions text-center">
	          	<security:authorize access="hasRole('${form_code}_${modify}')">   
			        <span ng-if="collections.isEdit==true && collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' 
			        && collections.purchaseStatus !='Cancelled' && collections.purchaseStatus != 'Recommend'">
			         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(collections)"></i>
			        </span>
		      	</security:authorize>
	         	<security:authorize access="hasRole('${form_code}_${view}')">
		         	<span ng-if="collections.isView==true">
			        <span ng-if="collections.purchaseStatus == 'Approved' || collections.purchaseStatus == 'Rejected' ||  
			        collections.purchaseStatus == 'Cancelled' || collections.purchaseStatus == 'Recommend' ">
			         <i class="fa  fa-list-alt text-dark text" data-ng-click="viewRow(collections)"></i>
			        </span></span>
		        </security:authorize>
		        <security:authorize access="hasRole('${form_code}_${delete}')">
			        <span ng-if="collections.isDelete==true && collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' 
			        && collections.purchaseStatus !='Cancelled' && collections.purchaseStatus != 'Recommend' ">
			         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(collections)"></i>
			        </span>
		        </security:authorize>
		        <security:authorize access="hasRole('${form_code}_${print}')">
			        <span ng-if="collections.isPrint==true">
			         <i class="fa fa-print text-dark text" data-ng-click="printRow(collections)"></i>
			        </span>
			    </security:authorize>
	       </td>
          </tr>
         </tbody>
        </table>        
      </div> <!-- /table-responsive -->
      <footer class="panel-footer">
	  	<%@include file="/views/templates/panel-footer-static.jsp"%>
	  </footer>
    </div> <!-- /panel-body -->
   </div> <!-- /panel panel-default -->
  </div> <!-- /panel panel-default-list -->
</div> <!-- /wrapper-md -->