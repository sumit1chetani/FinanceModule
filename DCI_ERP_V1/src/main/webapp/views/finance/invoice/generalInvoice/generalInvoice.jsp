<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id">
   <div class="panel panel-default">
	   <%-- <div class="form-body form-horizontal">
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-12 col-lg-12">					
					<div class="col-sm-3 col-md-3 col-lg-3">
						<fieldset>
							<div class="form-group">
							<security:authorize access="hasRole('${form_code}_${print}')">								
								<button class="btn btn-primary" type="button" data-ng-click="bulkPrint(rowCollection);">
									Bulk Print
								</button>
								</security:authorize>
							</div>
						</fieldset>				
					</div>
				</div>
			</div>
	 	</div>  --%>
	  <div class="panel-body float-left padding-10" style="width:100%" st-table="displayedCollection" st-safe-src="rowCollection">
	   <div class="table-responsive" style=" border: 1px solid #CCC;">
	    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
	     <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
	      <tr role="row">
	       <th class="sorting width_15" st-sort="invoiceNo">Invoice No</th>
	       <th class="sorting width_15" st-sort="invoiceDt">Invoice Date</th>
	       <th class="sorting width_29" st-sort="CustomerName">Customer</th>
	            <th class="sorting width_29" st-sort="createdOn">Amount</th>  
	       <th class="sorting width_29" st-sort="createdBy">Created By</th>
	       <th class="sorting width_29" st-sort="createdOn">Created On</th>  
	  
	      </tr>
	     </thead>
	     <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objTranslationItem in displayedCollection">
	      
	       <td><span>
	       <a ng-click="view(objTranslationItem.invoiceNo)">
			 <span tooltip="{{objTranslationItem.invoiceNo}}" class="tool-tip-span font-blue">{{objTranslationItem.invoiceNo}}</span>
	         </a></span>
	         
	       </td>
	       
	       <td>
	        <span tooltip="{{objTranslationItem.invoiceDt}}" class="tool-tip-span" ng-bind="objTranslationItem.invoiceDt"></span>
	       </td>
	       <td>
	        <span tooltip="{{objTranslationItem.CustomerName}}" class="tool-tip-span" ng-bind="objTranslationItem.CustomerName"></span>
	       </td>
	           <td>
	        <span tooltip="{{objTranslationItem.TotalBCamount}}" class="tool-tip-span" ng-bind="objTranslationItem.TotalBCamount"></span>
	       </td>
	       <td>
	        <span tooltip="{{objTranslationItem.createdBy}}" class="tool-tip-span" ng-bind="objTranslationItem.createdBy"></span>
	       </td>
	       <td>
	        <span tooltip="{{objTranslationItem.createdOn}}" class="tool-tip-span" ng-bind="objTranslationItem.createdOn"></span>
	       </td>
	        
	      </tr>
	     </tbody>
	    </table>
	   </div>
	  
	  <footer class="panel-footer" style="padding:0px;">
	    <%@include file="/views/templates/panel-footer-static.jsp"%>
	   </footer>
	  </div>
  </div>
 </div>
</div>
<script type="text/ng-template" id="generalInvoiceDeleteModal">

<div class="modal-header"> Are you sure to delete? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="DeleteConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeGeneralInvoiceDeleteDialog()">Cancel</button>
</div>
 </script>