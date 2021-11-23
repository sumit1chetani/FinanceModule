<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <input type="hidden" value="${form_code}" id="form_code_id" />
    <div class="panel panel-default">
	  <div class="panel-body float-left padding-0">
	   <div class="table-responsive ">
	    <table class="table table-striped table-hover dataTable no-footer">
	     <thead class="dataTables-Main-Head">
	      <tr>
	       <th class="width_1">
	       </th>
	       <th class="sorting" st-sort="puchaseInvoiceNo"> Draft Invoice No</th>
	       <th class="sorting" st-sort="puchaseInvoiceDate">Date</th>
	       <th class="sorting" st-sort="supplier">Supplier</th>
	       <th class="sorting" st-sort="description">Description</th>
	       <th class="text-center">Action</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objPuInvHdrLstBean in displayedCollection">
	       <td class="">
	        <label class="i-checks m-b-none">
	         <input type="checkbox" name="post[]">
	         <i></i>
	        </label>
	<!--         <td><span ng-if="objPuInvHdrLstBean.urIsView=='t'">
	       <a ng-click="view(objPuInvHdrLstBean.puchaseInvoiceNo)">
			 <span tooltip="{{objPuInvHdrLstBean.puchaseInvoiceNo}}" class="tool-tip-span font-blue">{{objPuInvHdrLstBean.puchaseInvoiceNo}}</span>
	         </a></span>
	         <span ng-if="objPuInvHdrLstBean.urIsView=='f'">
	         <span tooltip="{{objPuInvHdrLstBean.puchaseInvoiceNo}}" class="tool-tip-span">{{objPuInvHdrLstBean.puchaseInvoiceNo}}</span>
	         </span>
	       </td> -->
	        <td class="sorting ">{{objPuInvHdrLstBean.purchaseDraftNo}}</td>
	       <td class="sorting ">{{objPuInvHdrLstBean.puchaseInvoiceDate}}</td>
	       <td class="sorting ">{{objPuInvHdrLstBean.supplier}}</td>
	       <td class="sorting ">{{objPuInvHdrLstBean.description}}</td>
	       <td class=" td-actions text-center">
	          <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objPuInvHdrLstBean.purchaseDraftNo,$index)"></i>
	         <span ng-if="objPuInvHdrLstBean.urIsDelete=='true'">
	          <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objPuInvHdrLstBean.puchaseInvoiceNo,$index)"></i>
	         </span>
	       </td>
	      </tr>
	     </tbody>
	    </table>
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