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
           <!-- <th class="width_1 table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
           <th class="sorting width_8" data-st-sort="purchaseOrderNum">PO No</th>
           <th class="sorting width_7" data-st-sort="purchaseOrderDate">PO Date</th>
           <th class="sorting width_12" data-st-sort="vendorName">Vendor</th>
           <th class="sorting width_12" data-st-sort="purchaseTypeName">Purchase Type</th>
           <th class="sorting width_7" data-st-sort="purchaseStatus">Status</th>
           <th class="width_8 text-center table-heading"><spring:message code="label.action">Action</spring:message></th>
          </tr>
         </thead>
		<tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="collections in displayedCollection">
<!--            <td cs-select="collections"></td> -->
            <td>{{collections.purchaseOrderNum}}</td>
            <td>{{collections.purchaseOrderDate}}</td>
            <td>{{collections.vendorName}}</td>
            <td>{{collections.purchaseTypeName}}</td>
            <td>{{collections.purchaseStatus}}</td>
            <td class=" td-actions text-center">
         <security:authorize access="hasRole('${form_code}_${modify}')">    
        <span ng-if="collections.purchaseStatus != 'Cancelled'">
         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(collections)"></i>
        </span>
        </security:authorize>
         <security:authorize access="hasRole('${form_code}_${view}')">    
        <span ng-if="collections.purchaseStatus == 'Cancelled'">
         <i class="fa fa-list-alt text-dark text" data-ng-click="viewRow(collections)"></i>
        </span>
        </security:authorize>
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