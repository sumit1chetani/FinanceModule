<%-- <style>
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
					 <div class="col-sm-4 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-5 control-label  vessel-text">Debit Code</label>
								<div class="col-md-7">
									<selectivity list="debitNoteList" property="debitCode"  
									ng-model="debitCode" 
								        id="debitCode"></selectivity>	
								</div>
							</div>
						</fieldset>
					</div> 
					<div class="col-sm-8 col-md-8 col-lg-8">
						<!-- <button class="btn btn-primary" type="button"
							data-ng-click="copyPayment();">
							Copy Payment
						</button>	 -->				
						<button class="btn btn-success" type="button"
							data-ng-click="reversePayment();">
							Reverse Payment
						</button>
					</div>
				</div>			
			</div>
		</div>  --%>
		
		
		
		
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
							<label class="col-md-5 control-label  vessel-text">Debit Code.</label>
							<div class="col-md-6">
<selectivity list="debitNoteList" property="debitCode"  
									ng-model="debitCode" 
								        id="debitCode"></selectivity>								</div>
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
						data-ng-click="reversePayment();">
					Reverse Payment
 
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
           <th class="sorting width_10" data-st-sort="debitNoteNo">Debit Code</th>
           <th class="sorting width_10" data-st-sort="debitNoteDate">Date</th>
           <th class="sorting width_10" data-st-sort="acctName">Vendor/Customer Name</th>
           <th class="sorting width_10" data-st-sort="invoiceNo">Invoice No</th>
           <th class="sorting width_10" data-st-sort=company"">Organization</th>
           <th class="sorting width_10" data-st-sort="amount">Amount</th>
<!--            <th class="sorting width_10" data-st-sort="amountUSD">Amount USD</th>
 -->           <th class="width_6 text-center table-heading">Action</th>
          </tr>
         </thead>
		 <tbody class="dataTables-Main-Body">
	      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objDebitNoteItem in displayedCollection">
	       <!-- <td class="width_1" cs-select="objDebitNoteItem"></td> -->
	       <td class="width_10" ng-bind="objDebitNoteItem.debitNoteNo"></td>
	       <td class="width_10" ng-bind="objDebitNoteItem.debitNoteDate"></td>
	       <td class="width_10">
	        <span tooltip="{{objDebitNoteItem.acctName}}" class="tool-tip-span text-wrap" ng-bind="objDebitNoteItem.acctName"></span>
	       </td>
	       <td class="width_10" ng-bind="objDebitNoteItem.invoiceNo">
	       </td>
	       
	       <td class="width_20">
	        	<span tooltip="{{objDebitNoteItem.company}}" class="tool-tip-span text-wrap" ng-bind="objDebitNoteItem.company"></span>
	       </td>
	       <td class="width_10 text-right" ng-bind="objDebitNoteItem.amount|number:2"></td>
<!-- 	       <td class="width_10 text-left" ng-bind="objDebitNoteItem.amountUSD"></td>
 -->	       <td class="td-actions text-center">
	         <%--  <security:authorize access="hasRole('${form_code}_${modify}')">
	        <span>
	         <i class="fa  fa-pencil text-success text" data-ng-click="editDebitNoteRow(objDebitNoteItem)" tooltip="Edit"></i>
	        </span>
	        </security:authorize>  --%>
				       	<span>
				       		<i class="fa  fa-list-alt text-dark text" data-ng-click="viewDebitNoteRow(objDebitNoteItem,$index)" tooltip="Edit"></i>
				       	</span>
	        <span>
	         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteDebitNoteRow(objDebitNoteItem,$index)" tooltip="Delete"></i>
	        </span>
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