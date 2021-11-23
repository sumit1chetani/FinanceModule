<style>
.brk {
	width: 120px;
	display: block;
	word-break: break-all;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<!-- <div class="panel-heading panel-heading-form font-bold"> -->
	<div class="panel panel-default panel-default-list"
		st-table="displayedCollection"  st-persist="usermasterTable" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%>

		<div class="panel-body padding-10">
			<div class="table-responsive" style=" border: 1px solid #CCC;">

         <!-- Bulk Upload -->
          <span><button class="btn btn-success" type="button"
            class="btn btn-success"
            data-ng-click="fileUpload()">
           			Import
           </button></span>  
        </div>
        <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
         aria-describedby="dt_basic_info">
         <thead class="dataTables-Main-Head">
          <tr>
           <!-- <th class="width_1 text-center table-heading">
            <label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
           <th class="sorting width_13" st-sort="designation">Stock Transfer No</th>
         <!--   <th class="sorting width_13" st-sort="">Transportation Type</th> -->
            <th class="sorting width_13" st-sort="">Request Type</th>
           <th class="sorting width_13" st-sort="">Requisition Number</th>
           <th class="sorting width_13" st-sort="designation">Source Location</th>
           <th class="sorting width_13" st-sort="">Destination Location</th>
           <th class="sorting width_13" st-sort="">Delivery Method</th>
           <!--  <th class="sorting width_13" st-sort="">Description</th> -->
           <th class="sorting width_13" st-sort="">Status</th>
           <th class="width_05 text-center table-heading">Action</th>
          </tr>
         </thead>
         <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
           data-ng-repeat="row in displayedCollection">
           <!-- <td data-cs-select="row" class="text-center"></td> -->
           <td>{{row.stockId}}</td>
        <!--    <td>{{row.transportPort}}</td>   -->        
         
         <td>{{row.reqType}}</td> 
            <td>{{row.requisitionNumber}}</td>          
           <td>{{row.sourceLocName}}</td>
           <td>{{row.destLocName}}</td>
           <td>{{row.deliveryMethod}}</td>
            <!--  <td>{{row.description}}</td> -->
           <td>{{row.status}}</td>
           <td class=" td-actions text-center">
         <%--   <security:authorize access="hasRole('${form_code}_${modify}')"> --%>
           <span ng-if="row.status == 'Pending'"> <i
             class="fa  fa-pencil text-success text" data-ng-click="editRow(row)"></i>
           </span>
             <span ng-if="row.status  != 'Pending'"> <i
             class="fa  fa-eye text-success text" data-ng-click="viewRow(row)"></i>
           </span>
<%--            </security:authorize>
 --%>           
<%--  <security:authorize access="hasRole('${form_code}_${delete}')">
 --%>           <span ng-if="row.status == 'Pending'"> <i class="fa fa-trash-o text-danger-dker text"
             data-ng-click="deleteRow(row)"></i>
           </span>
<%--            </security:authorize>
 --%>               <%--< security:authorize access="hasRole('${form_code}_${print}')"> --%>
   	                               <span>
								 <i class="fa  fa-print text-success text" 
								ng-click="print(row.id)"></i>
									</span>
							
 

								<%-- </security:authorize> --%>
           </td>
          </tr>
         </tbody>
        </table>
        <footer class="panel-footer panel-footer-list">
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

<script type="text/ng-template" id="fileModal">
 <div class="modal-header"> File Upload</div>
  <div class="row">
   <div class="col-lg-12">
    <div class="col-lg-12">
     <input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
    </div>
   </div> 
  </div>
  <div class="modal-footer">
	<a class="btn btn-success" href="tempdoc/Material_Issue.xlsx" class="control-label">Download sample excel file</a>	
   <button class="btn btn-info" type="button" ng-click="uploadMaterialIssueRecord()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>
 
 <script type="text/ng-template" id="modalDialogId6">
	
	<div class="padding-0">
 <div class="panel panel-default padding-0">
  <div class="panel-heading font-bold">ERROR</div>
  <div class="panel-body">
   <div style = "color:red;">Failed To Upload</div>
   <div>
    <label id="id"> {{value}}</label>
   
               
   </div>
   <div class="form-actions">
    <div class="row">
    
     <div class="col-md-12">
       <button class="btn btn-danger" ng-click="closeFileDialog()">OK</button>
     </div>
    </div>
   </div>
  </div>
 </div>
</div>
	
</script>