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
		       
		  <!--  <button class="btn btn-primary" ng-click="approvePaymentInformation(parameterCollection.paymentOrderNo,parameterCollection.status)" 
		    type="button">Approved List </button>
		        -->
		        
		        <button class="btn btn-success" type="button"
									data-ng-click="viewDraft();">View Draft Records</button>
   					     
		       </div>
		       <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
		         <thead class="dataTables-Main-Head">
		          <tr>
		          <th class="width_1 table-heading" >
		           <label style="margin-left: 20%;" class="i-checks m-b-none">
             <input type="checkbox" ng-model="selectedAll" ng-change="checkAll(displayedCollection,selectedAll)">
             <i></i>
            </label>
            </th>
		           <th class="sorting width_15" st-sort="paymentOrderNo">Payment Order No</th>
		           <th class="sorting width_15" st-sort="paymentOrderDate">Date</th>
		          	<th class="sorting width_15" st-sort="supplierName">Supplier</th>
		          	<th class="sorting width_15" st-sort="status">Status</th>
		         	 <th class="sorting width_15" st-sort="action">Action</th>
		          </tr>
		         </thead>
		       	   <tbody class="dataTables-Main-Body">
		          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="parameterCollection in displayedCollection">
		            	<td >
		            	<label class="i-checks m-b-none">
				  <input type="checkbox"  ng-model="parameterCollection.select" ng-change="checkAllPurchaseDisabled(parameterCollection.paymentOrderNo)">
				   <i></i>
				</label>
				</td>
				
					 <td>{{parameterCollection.paymentOrderNo}}</td>
					<td>{{parameterCollection.paymentOrderDate}}</td>
					<td>{{parameterCollection.supplierName}}</td>
					<td>{{parameterCollection.status}}</td>
					<td class=" td-actions text-center">
			         	   <security:authorize access="hasRole('${form_code}_${modify}')"> 
			         	 <span>
				         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(parameterCollection.paymentOrderNo,parameterCollection.status)"></i>
				        </span>
				        </security:authorize>
				           <security:authorize access="hasRole('${form_code}_${delete}')"> 
				       	<span>
				         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(parameterCollection.paymentOrderNo,parameterCollection.status)"></i>
				        </span>
				       </security:authorize>
				       </td>
		          </tr>
         		</tbody>
		        </table>
<!-- 		         <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
 -->	     
 
<footer class="panel-footer panel-footer-list">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
    </div>
	          <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					 <security:authorize access="hasRole('${form_code}_${approve}')">
   					<button class="btn btn-danger" ng-click="approvePaymentInformation(parameterCollection.paymentOrderNo,parameterCollection.status)"  type="button">Approve</button>
   					</security:authorize>
   					
   					  <!--  <button class="btn btn-primary" type="button" data-ng-click="exportExcel()">
        <span class="fa fa-file-excel-o"> Export Excel</span>
         <a id="pendingExport" stype="display:none"
					href="filePath/PayamentInformation.xls" download="PayamentInformation.xls"></a>
					
					
       </button> -->
   				</div></div></div>
	        
	       </div>
	      </div>
     </div>
   </article>
  </div>
 </section>
</div>