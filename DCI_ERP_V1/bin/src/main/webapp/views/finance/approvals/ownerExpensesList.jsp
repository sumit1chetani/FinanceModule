<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id" />
    <div class="panel panel-default">
	  <div class="panel-body float-left padding-0">
	   <div class="table-responsive ">
	    <table class="table table-striped table-hover dataTable no-footer">
	     <thead class="dataTables-Main-Head">
	      <tr>
	       <th class="width_1">
	       </th>
	       <th class="sorting" st-sort="daCode">DA No</th>
	       <th class="sorting" st-sort="daDate"> DA Date</th>
	       <th class="sorting" st-sort="pcnNo">PCN No</th>
	       <th class="sorting" st-sort="vessel">Vessel</th>
	       <th class="sorting" st-sort="vesselOwnerName">Vessel Owner</th>
	       <th class="sorting" st-sort="vesselOwnerName">Description</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" 
	      ng-repeat="objDAbean in displayedCollection">
	       <td class="">
	        <label class="i-checks m-b-none">
	         <input type="checkbox" name="post[]" ng-model="objDAbean.select">
	         <i></i>
	        </label>
	        <td><span >
	       <a>
			 <span tooltip="{{objDAbean.daCode}}">{{objDAbean.daCode}}</span>
	         </a></span>
	       </td>
	       <td class="sorting ">{{objDAbean.daDate}}</td>
	       <td class="sorting "><a ng-click="printDiv(objDAbean.pcnNo)">
	       <span tooltip="{{objDAbean.pcnNo}}" class="tool-tip-span font-blue">{{objDAbean.pcnNo}}</span></a></td>
	       <td class="sorting ">{{objDAbean.vessel}}</td>
	       <td class="sorting ">{{objDAbean.vesselOwnerName}}</td>
	       <td class="sorting ">{{objDAbean.hdrDescription}}</td>
	      </tr>
	     </tbody>
	    </table>
	    <div class="excels"> </div>
	   </div>
	   <footer class="panel-footer panel-footer-list">
	    <%@include file="/views/templates/panel-footer.jsp"%>
	   </footer>
	  </div> <!-- /panel-body -->
  </div>
 </div>
</div>
 <script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-12">
			<!--<input type="file"  class="form-control btn-primary" id="file" name="file">-->
			<input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadPIFile(this)"  accept=".xls,.xlsx,.xlsm" />
		</div>
	</div> 
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="uploadPIStatement()">OK</button>
	<button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>