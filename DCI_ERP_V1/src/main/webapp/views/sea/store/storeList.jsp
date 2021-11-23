

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
        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label>
           </th> -->
           <th class="sorting width_8" st-sort="requisitionNumber">Requisition No</th>
           <th class="sorting width_10" st-sort="employeeName">Requested By</th>
           <th class="sorting width_10" st-sort="requisitionDate">Requested Date</th>
           <th class="sorting width_10" st-sort="designationName">Job Title</th>
           <th class="sorting width_8" st-sort="sourceLocationName">Source Location</th>
              <th class="sorting width_8" st-sort="destinationLocationName">Destination Location</th>
           <th class="width_2 text-center table-heading">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objStoreToStore in displayedCollection">
           <!-- <td cs-select="" class="text-center"></td> -->
           <td>{{objStoreToStore.requisitionNumber}}</td>
           <td>{{objStoreToStore.employeeName}}</td>
           <td>{{objStoreToStore.requisitionDate}}</td>
           <td>{{objStoreToStore.designationName}}</td>
           <td>{{objStoreToStore.sourceLocationName}}</td>
           <td>{{objStoreToStore.destinationLocationName}}</td>
           <td class=" td-actions text-center">
            <span>
             <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objStoreToStore.purchaseRequisitionId)"></i>
            </span>
            <span>
             <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objStoreToStore.purchaseRequisitionId,$index)"></i>
            </span>
           </td>
          </tr>
         </tbody>
        </table>
        <footer class="panel-footer panel-footer-list">
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