<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<div class="panel panel-default">
			<div class="form-body form-horizontal">
				<div class="row m-t-sm">
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1 table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
           <th class="sorting width_8" data-st-sort="purchaseOrderNum">Purchase Order No</th>
           <th class="sorting width_7" data-st-sort="purchaseOrderDate">Purchase Order Date</th>
           <th class="sorting width_10" data-st-sort="reqType">Request Type</th>
           <th class="sorting width_12" data-st-sort="vendorName">Vendor</th>
           <th class="sorting width_12" data-st-sort="purchaseTypeName">Purchase Type</th>
           <th class="sorting width_7" data-st-sort="purchaseStatus">Status</th>
           <th class="width_8 text-center table-heading">Action</th>
          </tr>
         </thead>
		<tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="collections in displayedCollection">
<!--            <td cs-select="collections"></td> -->
            <td>{{collections.purchaseOrderNum}}</td>
            <td>{{collections.purchaseOrderDate}}</td>
            <td>{{collections.reqType}}</td>
            <td>{{collections.vendorName}}</td>
            <td>{{collections.purchaseTypeName}}</td>
            <td>{{collections.purchaseStatus}}</td>
            <td class=" td-actions text-center">
        <span ng-if="collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Partially Recieved' && collections.purchaseStatus != 'Recieved'">
         <i class="fa  fa-check text-success text" data-ng-click="editRow(collections)"></i>
        </span>
        <span ng-if="collections.purchaseStatus == 'Approved' || collections.purchaseStatus == 'Partially Recieved' || collections.purchaseStatus == 'Recieved'">
         <i class="fa fa-list-alt text-dark text" data-ng-click="viewRow(collections)"></i>
        </span>
        <span ng-if="collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Partially Recieved' && collections.purchaseStatus != 'Recieved'">
         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(collections)"></i>
        </span>
       </td>
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