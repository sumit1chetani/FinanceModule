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
     <thead class="dataTables-Main-Head">
          <tr >
          <!--  <th class="width_1 text-center table-heading"><label class="i-checks m-b-none">
             <input type="checkbox">
             <i></i>
            </label></th> -->
                      <th class="sorting width_3" st-sort="branchCode">Shift Code </th>
                      <th class="sorting width_3" st-sort="branchCode">Shift Name </th>
                      <th class="sorting width_3" st-sort="branchCode">Start Time </th>
                      <th class="sorting width_3" st-sort="branchCode">End Time </th>
                      <th class="sorting width_3" st-sort="branchCode">Thershold Time </th>
                      <th class="sorting width_3" st-sort="branchCode">Break Start Time </th>
                       <th class="sorting width_3" st-sort="branchCode">Break End Time </th>
                       <th class="sorting width_3" st-sort="branchCode">Action </th>
           
          </tr>
         </thead>
       <tbody class="dataTables-Main-Body">
          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objShiftMaster in displayedCollection">
<!--           <td class="text-center" cs-select="objShiftMaster"></td> -->
           <td>{{objShiftMaster.shiftCode}}</td>
           <td>{{objShiftMaster.shiftName}}</td>
           <td>{{objShiftMaster.startTime}}</td>
           <td>{{objShiftMaster.endTime}}</td>
           <td>{{objShiftMaster.thresholdTime}}</td>
           <td>{{objShiftMaster.breakStartTime}}</td>
           <td>{{objShiftMaster.breakEndTime}}</td>
           <td class=" td-actions text-center">
		        <span>
	         		<i class="fa  fa-pencil text-success text" data-ng-click="editRow(objShiftMaster.shiftId)"></i>
	        	</span>
		        <span>
	         		<i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objShiftMaster.shiftId,$index)"></i>
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
	<a class="btn btn-success" href="tempdoc/Sample_Shift.xls" class="control-label">Download sample excel file</a>
   <button class="btn btn-info" type="button" ng-click="uploadShift()">OK</button>
   <button class="btn btn-danger" ng-click="closeFileDialog()">Cancel</button>
  </div>
 </script>