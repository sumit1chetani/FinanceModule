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
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
          <tr >
          
                      <th class="sorting width_20" st-sort="branchCode">Scheme Name </th>
                      <th class="sorting width_20" st-sort="branchCode">Validity From </th>
                      <th class="sorting width_20" st-sort="branchCode">Validity To </th>
                       <th class="sorting width_20" st-sort="branchCode">Action</th>
                      
           
          </tr>
         </thead>
       <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objShiftSchemeMaster in displayedCollection">

           <td>{{objShiftSchemeMaster.schemeName}}</td>
           <td>{{objShiftSchemeMaster.validityFrom}}</td>
           <td>{{objShiftSchemeMaster.validityTo}}</td>
           <td class=" td-actions text-center">
		        <span>
	         		<i class="fa  fa-pencil text-success text" data-ng-click="editRow(objShiftSchemeMaster.schemeName)"></i>
	        	</span>
		        <span>
	         		<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objShiftSchemeMaster.schemeId,objShiftSchemeMaster.schemeName,$index)"></i>
	        	</span>
		   </td>
          </tr>
		</tbody>
	       </td>
	      </tr>
	     </tbody>
    </table>
           <div class="dt-toolbar-footer" data-smart-include="views/layout/toolbar-footer.tpl"></div>
  </div>
  <!-- end widget content -->
 </div>
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
	<a class="btn btn-success" href="tempdoc/Sample_ShiftScheme_Upload_File.xls" class="control-label">Download sample excel file</a>	
   <button class="btn btn-info" type="button" ng-click="uploadShiftScheme()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>