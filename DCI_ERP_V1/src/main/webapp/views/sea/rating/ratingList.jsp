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
          <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox"> <i></i>
           </label></th> -->
           <th class="sorting width_10" data-st-sort="grnNo">GRN No</th>
           <th class="sorting width_10" data-st-sort="date">GRN Date</th>
           <th class="sorting width_10" data-st-sort="reqNo">Requisition No</th>
           <th class="sorting width_10" data-st-sort="poNo">Purchase Order</th>
           <th class="sorting width_10" data-st-sort="qty">Quantity</th>
           <th class="sorting width_10" data-st-sort="status">Status</th>
           <th class="width_6 text-center table-heading"><spring:message code="label.action">Action</spring:message></th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
           ng-repeat="vendorRatingsList in displayedCollection">
          <!--  <td class="text-center" cs-select="objVesselSectorItem"></td> -->
           <td>{{vendorRatingsList.grnNo}}</td>
           <td>{{vendorRatingsList.date}}</td>
           <td>{{vendorRatingsList.reqNo}}</td>
           <td>{{vendorRatingsList.poNo}}</td>
           <td>{{vendorRatingsList.qty}}</td>
           <td>{{vendorRatingsList.status}}</td>
           <td class=" td-actions text-center">
           <security:authorize access="hasRole('${form_code}_${modify}')">
           <span> <i
             class="fa  fa-pencil text-success text" data-ng-click="editRow(departmentCollections)"></i>
           </span> 
           </security:authorize>
           <security:authorize access="hasRole('${form_code}_${delete}')">
           <span> <i class="fa fa-trash-o text-danger-dker text"
             data-ng-click="deleteRow(departmentCollections)"></i>
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