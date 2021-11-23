<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
/* .remarks-td{
	  padding: 0px 0px !important;
}
.input-remarks{
	height: 30px !important;
} */

<style>
.table>tbody>tr>td, .table>tfoot>tr>td {
    padding: 6px 2px;
    font-size: 12px;

</style>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <%@include file="/views/templates/panel-header-form.jsp"%>
  <div class="panel-body">
    <form name="bankReconciliationForm" class="form-horizontal" >
  <!--   <div class="row book-widget-row">


		<div class="col-sm-12">
			<fieldset>
				<div class="col-md-4">
					<div class="form-group">
    							<label for="inputPassword" class="control-label col-md-5">From Date gippppa<span style="color: red;">*</span></label>
  							<div class="col-md-7">
 									<div class="input-group input-append date" id="from_date">
					          <input type="text" class="form-control input-sm" name="fromdate" id="fromdate" 
					          ng-model="bankReconcile.fromDate" placeholder='dd/mm/yyyy'/>
					          <span class="input-group-addon add-on">
					           <span class="glyphicon glyphicon-calendar"></span>
					          </span>
					        </div>   									
  							</div>
       				</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
    							<label for="inputPassword" class="control-label col-md-5">To Date<span style="color: red;">*</span></label>
  							<div class="col-md-7">
 									<div class="input-group input-append date" id="to_date">
					          <input type="text" class="form-control input-sm" name="todate" id="todate" 
					          ng-model="bankReconcile.toDate" placeholder='dd/mm/yyyy'/>
					          <span class="input-group-addon add-on">
					           <span class="glyphicon glyphicon-calendar"></span>
					          </span>
					        </div>   									
  							</div>
       				</div>
				</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Bank</label>
						<div class="col-md-7">
							<select class="form-control input-sm input-sm" id="bankcode" name="bankcode"
								ng-model="bankReconcile.bankCode"
								data-ng-options="r.bankCode as r.bankName for r in BankList">
								<option value="" selected="selected">Select</option>
							</select>
							<selectivity list="BankList" property="bankReconcile.bankCode"
							id="bankcode" name="bankcode"></selectivity>
						</div>
					</div>
				</div>
			</fieldset>
		</div>
	</div> -->

	<%-- 	<div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<!-- <input type="file" class="form-control btn-primary" name="excelfile" ng-model="excelfile" accept=".xls,.xlsx,.xlsm" />
           			<button class="btn btn-primary" type="button" onclick="angular.element(excelfile).scope().uploadFile(excelfile)" >Upload Statement</button> -->
           			 <security:authorize access="hasRole('${form_code}_${upload}')">  
           			<button class="btn btn-primary" type="button" ng-click="openFileModal()" >Upload Statement</button> </security:authorize>
					<security:authorize access="hasRole('${form_code}_${view}')"><button class="btn btn-info" type="button" ng-click="getDiffernceList()">Show Differences</button></security:authorize>
					<security:authorize access="hasRole('${form_code}_${view}')"><button class="btn btn-danger" ng-click="getReconcileList()" type="button">Show Reconciled Records</button></security:authorize>
					<security:authorize access="hasRole('${form_code}_${view}')"><button class="btn btn-danger" ng-click="getReconcileListdraft()" type="button">Show Draft Records</button></security:authorize>
				</div>
			</div>
		</div> --%>
	</form>
  </div>
  
  <div class="panel-body float-left padding-0">
   <div class="table-responsive" >
   <!-- <table class="table table-striped table-bordered table-hover dataTable no-footer">
   	<thead class="dataTables-Main-Head">
   		<tr role="row">
     	  <th class="width_52" >Book Statement</th>
     	   <th class="	width_47" >Bank Statement</th>
     	</tr>
   	</thead>
   </table> -->
    <!-- <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">     	
      <tr role="row">
             <th class="sorting width_9" >Bank Account Code</th>
      
       <th class="sorting width_9" >Trans No</th>
       <th class="sorting width_14" >Cheque No.</th>
       <th class="sorting width_9">Cheque Dt</th>
       <th class="sorting width_9" >Dr Amount</th>
       <th class="sorting width_9" >Cr Amount</th>
       <th class="sorting width_14" >Cheque No.</th>
       <th class="sorting width_9" >Date</th>
       <th class="sorting width_9" >With drawl</th>
       <th class="sorting width_9" >Deposits</th>
       <th class="sorting width_20" >Remarks</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objTranslationItem) in rowCollectionDraft">
             <td>
         <span tooltip="{{objTranslationItem.bank_account_code}}" class="tool-tip-span" ng-bind="objTranslationItem.bank_account_code"></span>
       </td>
       <td>
         <span tooltip="{{objTranslationItem.transaction_no}}" class="tool-tip-span" ng-bind="objTranslationItem.transaction_no"></span>
       </td>
        <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.book_cheque_no}}" class="tool-tip-span" ng-bind="objTranslationItem.book_cheque_no"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.book_cheque_date}}" class="tool-tip-span" ng-bind="objTranslationItem.book_cheque_date"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.book_debit_amt}}" class="tool-tip-span" ng-bind="objTranslationItem.book_debit_amt"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.book_credit_amt}}" class="tool-tip-span" ng-bind="objTranslationItem.book_credit_amt"></span>
       </td>
       <td style="background-color: orange">
        <span tooltip="{{objTranslationItem.bank_cheque_no}}" class="tool-tip-span" ng-bind="objTranslationItem.bank_cheque_no"></span>
       </td>
       <td style="background-color: orange">
        <span tooltip="{{objTranslationItem.bank_date}}" class="tool-tip-span" ng-bind="objTranslationItem.bank_date"></span>
       </td>
       <td style="background-color: orange">
        <span tooltip="{{objTranslationItem.bank_debit_amt}}" class="tool-tip-span" ng-bind="objTranslationItem.bank_debit_amt"></span>
       </td>
        <td style="background-color: orange">
        <span tooltip="{{objTranslationItem.bank_credit_amt}}" class="tool-tip-span" ng-bind="objTranslationItem.bank_credit_amt"></span>
       </td>
       <td>
        <span tooltip="{{objTranslationItem.remarks}}" class="tool-tip-span"   ng-bind="objTranslationItem.remarks"></span>
        </td>
      </tr>
     </tbody>
    </table> -->
    
    <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" width="100%" role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">     	
      <tr role="row">
         <th class="sorting width_4">Customer/Supplier</th>
       <th class="sorting width_5">Cheque No.</th>
       <th class="sorting width_5">Cheque Dt</th>
        <th class="sorting width_3">Voucher No</th>
       <th class="sorting width_2">Transaction Type</th>
       <th class="sorting width_2">Description </th>
       <th class="sorting width_5">Doc Type</th>
       <th class="sorting width_6">Doc Date</th>
       <th class="sorting width_3">Credit Amount</th>
       <th class="sorting width_3">Debit Amount</th>
       <th class="sorting width_20">Bank Date</th>
       <th class="sorting width_5">Remarks</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objTranslationItem) in rowCollectionDraft">
       <td style="background-color: lightsalmon"> 
         <span tooltip="{{objTranslationItem.supplier}}" class="tool-tip-span" ng-bind="objTranslationItem.supplier"></span>
       </td>
        <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.chqNo}}" class="tool-tip-span" ng-bind="objTranslationItem.chqNo"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.chqDt}}" class="tool-tip-span" ng-bind="objTranslationItem.chqDt"></span>
       </td>
        <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.transactionNo}}" class="tool-tip-span" ng-bind="objTranslationItem.transactionNo"></span>
        </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.transactionType}}" class="tool-tip-span" ng-bind="objTranslationItem.transactionType"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.narration}}" class="tool-tip-span" ng-bind="objTranslationItem.narration"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.doctype}}" class="tool-tip-span" ng-bind="objTranslationItem.doctype"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.docdate}}" class="tool-tip-span" ng-bind="objTranslationItem.docdate"></span>
       </td>
       <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.creditamount}}" class="tool-tip-span" ng-bind="objTranslationItem.creditamount"></span>
       </td>
        <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.debitamount}}" class="tool-tip-span" ng-bind="objTranslationItem.debitamount"></span>
       </td>
        <td style="background-color: lightsalmon">
        <ng-bs3-datepicker data-ng-model="objTranslationItem.bank_date" ng-change="calculateTotal(rowCollection)" name="Bank_date{{trIndex}}" id="bank_date{{trIndex}}" /> 
        <!-- <div class="input-group input-append date" id="bankDate{{trIndex}}">
          <input type="text" class="form-control input-sm" name="subValidTo"  style=" width: 90px; " id="bankDate{{trIndex}}" ng-model="bankReconcile.bankDate" placeholder='dd/mm/yyyy' />
          <span class="input-group-addon add-on">
           <span class="glyphicon glyphicon-calendar"></span>
          </span>
         </div> -->
        </td>
        <td class="remarks-td">
         <input type="text" class="form-control input-sm input-remarks" name="remarks{{trIndex}}" id="remarks{{trIndex}}"   ng-model="objTranslationItem.remarks" />
       </td>
       <!-- <td ng-if="isReconcileList" >
        <span tooltip="{{objTranslationItem.remarks}}" class="tool-tip-span"  ng-if="isReconcileList" ng-bind="objTranslationItem.remarks"></span>
        </td> -->
      </tr>
     </tbody>
    </table>
   </div>
  <div class="form-actions">
			<div class="row">
				<div class="col-md-12">	
   					<button class="btn btn-danger" ng-click="cancel()" type="button">Cancel</button>   								   
   					<button class="btn btn-danger" ng-click="reconcileRecords(rowCollectionDraft)" type="button">Reconcile</button>   						
   					</div>  				  			   
   			   </div> 
  <%-- <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer> --%>
<%--    <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<security:authorize access="hasRole('${form_code}_${add}')">
   					<button class="btn btn-danger" ng-click="reconcileRecords(rowCollection)" ng-if="!isReconcileList" type="button">Reconcile</button>
   					</security:authorize>
   					<security:authorize access="hasRole('${form_code}_${add}')">
   					<button class="btn btn-danger" ng-click="reconcileRecordsDraft(rowCollection)" ng-if="!isReconcileList" type="button">Reconcile To Draft</button>
   					</security:authorize>
   					</div>  
		
   			   </div>
   			   
   			   </div> --%>
  </div>
 </div>
</div>

 <script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-12">
			<!--<input type="file"  class="form-control btn-primary" id="file" name="file">-->
			<input type="file" class="form-control btn-primary" name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
		</div>
	</div> 
</div>
<div class="modal-footer">
	<button class="btn btn-info" type="button" ng-click="uploadBankStatement()">OK</button>
	<button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
</div>
 </script>