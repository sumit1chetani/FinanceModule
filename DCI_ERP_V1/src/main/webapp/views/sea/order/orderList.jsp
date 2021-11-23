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

        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
          <!--  <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
          <!--  <th class="sorting width_8" st-sort="requisitionNumber">Requisition No</th> -->
           <th class="sorting width_10" st-sort="employee">Requested By</th>
         <!--   <th class="sorting width_10" st-sort="requisitionDate">Requested Date</th> -->
           <!-- <th class="sorting width_10" st-sort="designationName">Job Title</th> -->
           <th class="sorting width_8" st-sort="companyId">Source Location</th>
           <!--    <th class="sorting width_8" st-sort="destinationLocationName">Destination Location</th> -->
               <th class="sorting width_8" st-sort="flag">Status</th>
           <th class="width_2 text-center table-heading">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="storeApprovalData in displayedCollection">
           <!-- <td cs-select="" class="text-center"></td> -->
         <!--   <td>{{storeApprovalData.requisitionNumber}}</td> -->
           <td>{{storeApprovalData.employee}}</td>
          <!--  <td>{{storeApprovalData.requisitionDate}}</td> -->
           <!-- <td>{{storeApprovalData.designationName}}</td> -->
           <td>{{storeApprovalData.companyId}}</td>
           <!-- <td>{{storeApprovalData.destinationLocationName}}</td> -->
           <td >{{storeApprovalData.flag}}</td>

           <td class=" td-actions text-center">
             
        <span  class="width_10"> <i
													class="fa fa-eye"
													data-ng-click="Reject(storeApprovalData.rowId)"
													title="Reject
													"></i>
											</span>
            <span class="width_10"> <i
													class="fa  fa-list-alt text-dark text"
													data-ng-click="Publish(storeApprovalData.rowId)"
													title="Publish
													"></i>
											</span>
            
              <%-- <security:authorize access="hasRole('${form_code}_${delete}')">
	            <span>
	             <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(storeApprovalData.purchaseRequisitionId,$index)"></i>
	            </span>
            </security:authorize> --%>
           </td>
          </tr>
         </tbody>
        </table>
      <footer class="panel-footer panel-footer-list" style="padding:0px;">
					<%@include file="/views/templates/panel-footer-static.jsp"%>
				</footer>
       </div>
      </div>
     </div>
    </div>
   </article>
  </div>
 </section>
</div>