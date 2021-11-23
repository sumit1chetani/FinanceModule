<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
   <%@include file="/views/templates/panel-header.jsp"%>
   <input type="hidden" value="${form_code}" id="form_code_id">
   <div class="panel panel-default">
	  <div class="panel-body padding-10">
		
						<div class="col-sm-2">
							<fieldset>
								<div class="form-group">
									<button class="btn btn-primary" type="button"
										data-ng-click="bulkMail(rowCollection);">Bulk Mail</button>
								</div>
							</fieldset>
						</div>

					</div>
					
	  <div class="panel-body float-left padding-10" style="width:100%" st-table="displayedCollection" st-safe-src="rowCollection">
	   <div class="table-responsive" style=" border: 1px solid #CCC;">
	    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
	     <thead class="dataTables-Main-Head" style="background-color: #e2e2e2;">
	      <tr role="row">
	      <th class="width_1"><label
								class="i-checks m-b-none"> <input type="checkbox"
									name="selectAll" ng-model="invView.selAll" ng-click="viewSelectAll()">
									<i></i>
							</label></th>
	       <th class="sorting" st-sort="invoiceNo">Invoice No</th>
	       <th class="sorting" st-sort="invoiceDt">BL No.</th>
	       <th class="sorting" st-sort="CustomerName">Quotation No.</th>
	       <th class="sorting" st-sort="createdOn">Invoice Date</th>  
	       <th class="sorting" st-sort="createdBy">Agent</th>
	       <th class="sorting" st-sort="createdOn">Customer</th>
	       <th class="sorting" st-sort="createdOn">Vessel/Voyage</th>
	       <th class="sorting" st-sort="createdOn">Created By</th>
	       <th class="sorting" st-sort="createdOn">Total Amt</th>
	       <th class="sorting" st-sort="createdOn">Print</th>  
	       
	       
	       
	       
	  
	      </tr>
	     </thead>
	     
	     <tbody class="dataTables-Main-Body">
						<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
							ng-repeat="inv in displayedCollection">
							
							<td class="width_1 text-center"><label
								class="i-checks m-b-none"> <input type="checkbox"
									name="selectedTypes[]" ng-model="inv.check">
									<i></i>
							</label></td>
							
							<td class="sorting "><a ng-click="viewInvoice(inv.invoiceNo)" >
									<span tooltip="{{inv.invoiceNo}}"
									class="tool-tip-span font-blue">{{inv.invoiceNo}}</span>
							</a></td>
							<td>{{inv.blNo}}</td>
							<td class="sorting ">
								<a
									href="#/mbk/seaQuotation/view?QuotHdId={{inv.quotationNo}}" target="_blank">
										<span tooltip="{{inv.quotation}}"
										class="tool-tip-span font-blue" 
										ng-bind="inv.quotation"> </span>
								</a>
									
									</td>
							<td>{{inv.createdOn}}</td>
							<td>{{inv.agentName}}</td>
							<td>{{inv.customerName}}</td>
							<td>{{inv.vesselName}}</td>
<!-- 							<td>{{inv.voyage}}</td> -->
							<td>{{inv.createdBy}}</td>
							<td>{{inv.totalTcAmt}}</td>
							  <td>
								<select  ng-model="inv[0].printList" id ="printSelect{{$index}}" ng-init="inv[0].printList = 'local'">
									<option value="both" >Both</option>
									<option value="usd">USD</option>
									<option value="local">Local</option>
							</select>
								
								</td>
							<td class="td-actions text-center">
							
<!-- 							<span> <i -->
<!-- 									class="fa  fa-print text-success text" -->
<!-- 									data-ng-click="printInvoice(inv.invoiceNo)"></i> -->
<!-- 							</span> -->
							
						<span> <i
									class="fa  fa-print text-success text"
									data-ng-click="clickInvoiceFunction(inv.invoiceNo,inv[0].printList)" id="{{inv[0].invoiceNo}}"></i>
							</span>
							
							 <span class="padding-both-side-2"><i
									class="fa fa-envelope red"
									data-ng-click="sendMail(inv.invoiceNo)"
									style="cursor: pointer; color: gray;"></i></span>
									
									
								<!-- <span class="padding-both-side-2"><i
									class="fa  fa-pencil text-success text"
									data-ng-click="datechangeinv(inv.invoiceNo,inv)"
									style="cursor: pointer; color: green;"></i></span> -->
									
									 </td>
							
						</tr>
						<tr x-ng-show="showEmptyLabel">
							<td colspan="6" class="text-center">No Records Found</td>
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