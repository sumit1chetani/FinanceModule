<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
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
	       <th class="sorting" st-sort="puchaseInvoiceNo">Sales
									Invoice No</th>
								<th class="sorting" st-sort="puchaseInvoiceDate">Sales
									Invoice Date</th>
								<th class="sorting" st-sort="supplier">Job No</th>
								<th class="sorting" st-sort="description">Party</th>
								<th class="sorting" st-sort="Reverse">POL</th>
								<th class="sorting" st-sort="createdBy">POD</th>
								<th class="sorting" st-sort="createdBy">Total Amount</th>
								<th class="sorting" st-sort="createdBy">Created By</th>
								<th class="sorting" st-sort="createdBy">Created Date</th>
	       <th class="text-center">Action</th>
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="purchaseInvoiceList in displayedCollection">
	       <td class="">
	        <label>
	         
	         <i></i>
	        </label>

	       <!--  <td><a ng-click="view(purchaseInvoiceList.salesSNo)"> <span
										tooltip="{{purchaseInvoiceList.puchaseInvoiceNo}}"
										class="tool-tip-span font-blue">{{purchaseInvoiceList.puchaseInvoiceNo}}</span>
										
								</a></td> -->
								 <td class="sorting ">{{purchaseInvoiceList.puchaseInvoiceNo}}</td>
								<td class="sorting ">{{purchaseInvoiceList.puchaseInvoiceDate}}</td>
								<td class="sorting ">{{purchaseInvoiceList.jobName}}</td>
								<td class="sorting ">{{purchaseInvoiceList.party}}</td>
								<td class="sorting ">{{purchaseInvoiceList.polName}}</td>
								<td class="sorting ">{{purchaseInvoiceList.podName}}</td>
								<td class="sorting ">{{purchaseInvoiceList.totalAmount}}</td>
								<td class="sorting ">{{purchaseInvoiceList.createdBy}}</td>
								<td class="sorting ">{{purchaseInvoiceList.createdOn}}</td>
	       <td class=" td-actions text-center">
									<span> <i
										class="fa  fa-pencil text-success text" data-toggle="tooltip" title="Edit"
										data-ng-click="saveDraft(purchaseInvoiceList.salesSNo)"></i>
									</span>
	       </td>
	      </tr>
	     </tbody>
	    </table>
	   </div>
	   <footer class="panel-footer panel-footer-list">
	    <%@include file="/views/templates/panel-footer.jsp"%>
	   </footer>
	   <div class="form-actions">
		<div class="row">
			<div class="col-md-12">
				<button  class="btn btn-danger" ng-click="backToList()" type="button">Back To List</button>
		   	</div>
		</div>
   	</div>
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