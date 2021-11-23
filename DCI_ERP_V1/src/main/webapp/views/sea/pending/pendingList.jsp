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
	         class="table table-striped table-bordered table-hover dataTable no-footer"
	         role="grid" aria-describedby="dt_basic_info">
	         <thead class="dataTables-Main-Head">
	          <tr>
	           <!-- <th class="width_1 table-heading" style="padding: 9px 9px !important;">
	            <label class="i-checks m-b-none">
	             <input type="checkbox">
	             <i></i>
	            </label>
	           </th> -->
	           <th class="sorting width_8 " data-st-sort="purchaseOrderNum" 
	           style="padding-left: 8px !important;padding-right: 0px !important;">Purchase Order No</th>
	           <th class="sorting width_9 " data-st-sort="purchaseOrderDate" 
	           style="padding-left: 5px !important;padding-right: 0px !important;">Purchase Order Date</th>
	           <th class="sorting width_12" data-st-sort="vendorName">Vendor</th>
	           <th class="sorting width_12" data-st-sort="purchaseTypeName">Purchase Type</th>
	           <th class="sorting width_7" data-st-sort="purchaseStatus">Status</th>
	           <th class="sorting width_12" data-st-sort="detailItemName">Item Name</th>
	           <th class="sorting width_5" data-st-sort="detailQuantity">Quantity</th>
	           <%-- <th class="width_8 text-center table-heading"><spring:message code="label.action"></spring:message></th> --%>
	          </tr>
	         </thead>
			<tbody class="dataTables-Main-Body">
	          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="collections in displayedCollection">
	           <!-- <td cs-select="collections" ></td> -->
	            <td>{{collections.purchaseOrderNum}}</td>
	            <td>{{collections.purchaseOrderDate}}</td>
	            <td>{{collections.vendorName}}</td>
	            <td>{{collections.purchaseTypeName}}</td>
	            <td>{{collections.purchaseStatus}}</td>
	            <td>{{collections.detailItemName}}</td>
	            <td>{{collections.detailQuantity}}</td>
	           <%--  <td class=" td-actions text-center">
	          <security:authorize access="hasRole('F0021_M')">   
	        <span ng-if="collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' && collections.purchaseStatus !='Cancelled' ">
	         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(collections)"></i>
	        </span>
	        </security:authorize>
	         <security:authorize access="hasRole('F0021_V')">
	        <span ng-if="collections.purchaseStatus == 'Approved' || collections.purchaseStatus == 'Rejected' ||  collections.purchaseStatus == 'Cancelled' ">
	         <i class="fa  fa-list-alt text-dark text" data-ng-click="viewRow(collections)"></i>
	        </span>
	        </security:authorize>
	         <security:authorize access="hasRole('F0021_D')">
	        <span ng-if="collections.purchaseStatus != 'Approved' && collections.purchaseStatus != 'Rejected' && collections.purchaseStatus !='Cancelled'">
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(collections)"></i>
	        </span>
	        </security:authorize>
	       </td> --%>
	          </tr>
	         </tbody>
	        </table>
	        <footer class="panel-footer panel-footer-list" style="padding:0px;">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>
	       </div>
	      </div>
	     </div>
	      <!-- end widget content -->
       </div>
       </form>
    </div>
    </div>
     <!-- end widget div -->
    </div>
    <!-- end widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>