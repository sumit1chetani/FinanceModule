<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.text-wrap{white-space:nowrap;}
.text-wrap-amtusd{  padding: 8px 5px 8px 5px !important;}
</style>
<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
  
   <%@include file="/views/templates/panel-header.jsp"%>
     <div class="form-body form-horizontal">
			<%-- <div class="row m-t-sm">
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
			</div> --%>
	 	</div> 
   <input type="hidden" value="${form_code}" id="form_code_id">
  </div>
  <div class="panel-body float-left padding-10" style="width: 100%;">
  <div class="row" st-table="displayedCollection"
							st-safe-src="rowCollection">
   <div class="table-responsive" style=" border: 1px solid #CCC;">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
     <thead style="background-color: #e2e2e2;">
     <tr>
        <!-- <th class="width_1"><label class="i-checks m-b-none"> <input type="checkbox" name="post[]"> <i></i> 
        </label></th>  -->

       <th class="sorting width_10" st-sort="debitNoteNo">Dr Code</th>
       <th class="sorting width_10" st-sort="debitNoteDate">Date</th>
       <th class="sorting width_10" st-sort="mloName">Customer/Supplier</th>
       <th class="sorting width_10" st-sort="invoiceNo">Inv No</th>
       <!-- <th class="sorting width_15" st-sort="location">Location</th> -->
       <th class="sorting width_10" st-sort="companyName">Company</th>
       <!-- <th class="sorting width_10 text-wrap" st-sort="amount">TC Amount</th> -->
       <th class="sorting width_10 text-wrap text-wrap-amtusd" st-sort="amountUSD">Amount</th>
       <th class="sorting width_10" st-sort="users">Users</th>
       <th class= "width_5" >Action</th>
      </tr>
      </thead>

     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objDebitNoteItem in displayedCollection">
<!--     <td class="width_1" cs-select="objDebitNoteItem"></td> 
 -->        <!-- <td class="width_1 text-center"><label class="i-checks m-b-none"> 
	          <input type="checkbox" name="selectedTypes[]"  ng-model="objDebitNoteItem .check"> 
	          <i></i> 
 	          </label> 
 	          </td>  -->
<!--  		<td class="width_10" ng-bind="objDebitNoteItem.debitNoteNo"></td>
 -->      <td>


	     	<a ng-click="view(objDebitNoteItem.debitNoteNo)">
	             <span tooltip="{{objDebitNoteItem.debitNoteNo}}" class="tool-tip-span font-blue" ng-bind="objDebitNoteItem.debitNoteNo"></span>
	     </a>
	        <span ng-if="objDebitNoteItem.urIsView=='f'">
	        	<span tooltip="{{objDebitNoteItem.debitNoteNo}}" class="tool-tip-span" ng-bind="objDebitNoteItem.debitNoteNo"></span>
	        </span>
       </td>
       <td class="width_10" ng-bind="objDebitNoteItem.debitNoteDate"></td>
       <td class="width_10">
        <span tooltip="{{objDebitNoteItem.mloName}}" class="tool-tip-span text-wrap" ng-bind="objDebitNoteItem.mloName"></span>
       </td>
       <td class="width_10" ng-bind="objDebitNoteItem.invoiceNo">
       </td>
       <!-- <td class="width_15" ng-bind="objDebitNoteItem.location"></td> -->
       <td class="width_10">
        	<span tooltip="{{objDebitNoteItem.companyName}}" class="tool-tip-span text-wrap" ng-bind="objDebitNoteItem.companyName"></span>
       </td>
       <!-- <td class="width_10" ng-bind="objDebitNoteItem.amount1"></td> -->
       <td class="width_10" ng-bind="objDebitNoteItem.amountUSD1"></td>
        <td class="width_10" ng-bind="objDebitNoteItem.createdBy"></td>
       <td class="td-actions text-center">
	        <security:authorize access="hasRole('${form_code}_${modify}')">
		        <span ng-if="objDebitNoteItem.urIsEdit=='true'">
		         <i class="fa  fa-pencil text-success text" 
		         data-ng-click="editRowBtn(objDebitNoteItem.debitNoteNo)" tooltip="Edit"></i>
		        </span>
	        </security:authorize>
	        
	        <security:authorize access="hasRole('${form_code}_${delete}')">
		        <span ng-if="objDebitNoteItem.urIsDelete=='true'">
		         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objDebitNoteItem.debitNoteNo,$index)" tooltip="Delete"></i>
		        </span>
	        </security:authorize>
     		<security:authorize access="hasRole('${form_code}_${print}')">   
				    &nbsp;&nbsp;<span ng-click="printDebitNoteDiv(objDebitNoteItem.debitNoteNo)" 
					id="{{objDebitNoteItem.invoiceNo}}"
					class=" glyphicon glyphicon-print " data-toggle="tooltip" title="Print"
					style="cursor: pointer; color: gray;"></span>
		 	 </security:authorize>  
		  <%--  <security:authorize access="hasRole('${form_code}_${send_mail}')">
		 	
			   <span><i class="icon-envelope red" data-ng-click="sendDebitNoteMail(objDebitNoteItem.debitNoteNo,objDebitNoteItem.invoiceNo)"></i></span>
			</security:authorize> --%>
       </td>
      </tr>
     </tbody>
    </table>
   </div>
  
      <footer class="panel-footer panel-footer-list" style="padding:0px;">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer>
  </div>
   </div>
  <!-- end widget content -->
 </div>
</div>
  <script type="text/ng-template" id="debitNoteMail">
<div class="modal-header"> Are you sure to send Email? </div>
<div class="row">
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="SendConfirm()">OK</button>
	<button class="btn btn-danger" ng-click="closeDialog()">Cancel</button>
</div>
 </script>