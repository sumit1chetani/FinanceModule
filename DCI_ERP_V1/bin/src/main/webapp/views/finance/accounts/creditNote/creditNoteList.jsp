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
			<div class="row m-t-sm">
				<div class="col-sm-12 col-md-3 col-lg-3 ">
						<fieldset>
						<div class="form-group">
							<label class="col-md-5 control-label  vessel-text">CN No.</label>
							<div class="col-md-6">
								<selectivity list="reverseList" property="creditNoteNo" id="creditNoteNo"></selectivity>
							</div>
						</div>
					</fieldset>
				</div>
								<br>
				
				<div class="col-sm-12 col-md-9 col-lg-9 ">
					<!-- <button class="btn btn-primary" type="button"
						data-ng-click="copyReceipt();">
						Copy Receipt
					</button> -->
					<%-- <security:authorize access="hasRole('${form_code}_${approve}')"> --%>
					<button class="btn btn-success" type="button"
						data-ng-click="reverse();">
						Reverse 
					</button>
					
					<%-- </security:authorize> --%>
					<!-- <button class="btn btn-info" type="button"
						data-ng-click="invoiceAllocation();">
						Invoice Allocation
					</button> -->
						<!-- <button class="btn btn-info" type="button"
						data-ng-click="getCBRcptListdraft();">
						View Draft Lists
					</button> -->
				</div>
			</div>
			</div>
     <div role="content">
      <div class="widget-body no-padding">
      
        <!-- <div class="dt-toolbar"
         data-smart-include="views/layout/toolbar-header.tpl"></div> -->
       <%--   <div class="dt-toolbar">
		<%@include file="/views/templates/panel-header-form.jsp"%>		
		</div> --%>
      <table id="dt_basic"
         class="table table-striped table-bordered table-hover dataTable no-footer"
         role="grid" aria-describedby="dt_basic_info">
        <thead class="dataTables-Main-Head">
        	<tr>
	           <!-- <th class="width_1 text-center table-heading">
	            <label class="i-checks m-b-none">
	             <input type="checkbox">
	             <i></i>
	            </label>
	           </th> -->
	           <th class="sorting width_10" data-st-sort="creditNoteCode">Credit Code</th>
	           <th class="sorting width_10" data-st-sort="creditNoteDate">Date</th>
	           <th class="sorting width_10" data-st-sort="accountName">Account Head</th>
	           <th class="sorting width_10" data-st-sort="invoiceNo">Invoice No</th>
	           <th class="sorting width_10" data-st-sort="company">Organization</th>
	           <th class="sorting width_10" data-st-sort="creditAmount">Amount</th>
<!-- 	           <th class="sorting width_10" data-st-sort="creditAmountUSD">Amount USD</th>           
 -->	           <th class="sorting width_4" data-st-sort="approveStatus">Status</th>     
	           <th class="width_6 text-center table-heading">Action</th>
        	</tr>
        </thead>
		<tbody class="dataTables-Main-Body">
	    	<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objCreditNoteListItem in displayedCollection">
		      	<!-- <td class="width_1" cs-select="objCreditNoteListItem"></td> -->
		       	<!-- <td class="width_1"> <label class="i-checks m-b-none">
		       		<input type="checkbox" ng-model="objCreditNoteListItem.select" id="select{{trIndex}}"><i></i></label></td> -->
		       	<td class="width_15" ng-bind="objCreditNoteListItem.creditNoteCode"></td>
		       	<td class="width_10" ng-bind="objCreditNoteListItem.creditNoteDate"></td>
		       	<td class="width_10">
		        	<span tooltip="{{objCreditNoteListItem.mloName}}" class="tool-tip-span text-wrap" ng-bind="objCreditNoteListItem.accountName"></span>
		       	</td>
		       	<td class="width_10" ng-bind="objCreditNoteListItem.invoiceNo">
		       	</td>
		       	<td class="width_15">
		       		<span tooltip="{{objCreditNoteListItem.company}}" class="tool-tip-span text-wrap" ng-bind="objCreditNoteListItem.company"></span>
		       	</td>
		       <td class="width_15 text-right" ng-bind="objCreditNoteListItem.creditAmount|number:2"></td>
<!-- 		       <td class="width_15 text-right" ng-bind="objCreditNoteListItem.creditAmountUSD"></td>
 -->		       <td class="width_4" ng-bind="objCreditNoteListItem.approveStatus"></td>
		
		       <td class="td-actions text-center">
		       <%-- <security:authorize access="hasRole('${form_code}_${modify}')">
			      	<span class="width_15" ng-if="objCreditNoteListItem.approveStatus != 'Approved' && objCreditNoteListItem.approveStatus != 'Rejected'">             
			         <i class="fa fa-pencil text-success text" data-ng-click="editCreditNoteRow(objCreditNoteListItem)" tooltip="Edit"></i>
			        </span>
		        </security:authorize> --%>
		        <security:authorize access="hasRole('${form_code}_${view}')">
				       	<span class="width_10" ng-if="objCreditNoteListItem.approveStatus != 'Approved' && objCreditNoteListItem.approveStatus != 'Rejected'">
				       		<i class="fa  fa-list-alt text-dark text" data-ng-click="viewCreditNoteRow(objCreditNoteListItem,$index)" tooltip="Edit"></i>
				       	</span>
			       	</security:authorize>
		        <security:authorize access="hasRole('${form_code}_${delete}')">
			        <span class="width_10" ng-if="objCreditNoteListItem.approveStatus != 'Approved' && objCreditNoteListItem.approveStatus != 'Rejected'">
			         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteCreditNoteRow(objCreditNoteListItem,$index)" tooltip="Delete"></i>
			        </span>
		        </security:authorize>
		       </td>
	    	</tr>
	     </tbody>
        </table>
       <!--  <div class="dt-toolbar-footer"
         data-smart-include="views/layout/toolbar-footer.tpl"></div> -->
         
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