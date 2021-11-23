<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  
  <div class="panel-body">
    <form name="bankReconciliationForm" class="form-horizontal" >
    <div class="row book-widget-row">


		<div class="col-sm-12">
			<fieldset>
				<!-- <div class="col-md-4">
					<div class="form-group">
    							<label for="inputPassword" class="control-label col-md-5">From Date<span style="color: red;">*</span></label>
  							<div class="col-md-7">
 									<div class="input-group input-append date" id="from_date">
					          <input type="text" class="form-control input-sm" name="fromdate" id="fromdate" 
					          ng-model="bankReconcile.fromDate" placeholder='dd/mm/yyyy'/>
					          <span class="input-group-addon add-on">
					           <span class="glyphicon glyphicon-calendar"></span>
					          </span>
					        </div>   	
					        <ng-bs3-datepicker data-ng-model="bankReconcile.fromDate" id="fromDate" name="fromDate" name="fromdate"
       data-ng-change="checkDatesCL(bankReconcile.fromDate)" 
        friendly-name="From Date"/>								
  							</div>
       				</div>
				</div> -->
				
				
				<div class="form-group">
								<label class="col-md-5 control-label">From Date<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<ng-bs3-datepicker
										data-ng-model="bankReconcile.fromDate"
										id="from_date" name="fromDate"
										form-name="bankReconciliationForm"
										data-ng-change="checkDatesCL(bankReconcile.fromDate)"
										friendly-name="From Date" validation="required" />
								</div>
							</div>
				
				<!-- <div class="col-md-4">
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
					            <ng-bs3-datepicker data-ng-model="bankReconcile.toDate" id="toDate" name="toDate" name="todate"
       data-ng-change="checkDatesCL(bankReconcile.toDate)" 
        friendly-name="To Date"/>						
  							</div>
       				</div>
				</div> -->
				
				<div class="form-group">
								<label class="col-md-5 control-label">To Date<span
									style="color: red;"> *</span></label>
								<div class="col-md-7">
									<ng-bs3-datepicker
										data-ng-model="bankReconcile.toDate"
										id="to_date" name="toDate"
										form-name="bankReconciliationForm"
										data-ng-change="checkDatesCL(bankReconcile.toDate)"
										friendly-name="To Date" validation="required" />
								</div>
							</div>
				
				<div class="col-md-4">
					<div class="form-group">
						<label class="col-md-5 control-label">Bank<span style="color: red;">*</span></label>
						<div class="col-md-7">
							<!-- <select class="form-control input-sm input-sm" id="bankcode" name="bankcode"
								ng-model="bankReconcile.bankCode"
								data-ng-options="r.bankCode as r.bankName for r in BankList">
								<option value="" selected="selected">Select</option>
							</select> -->
							<!-- <selectivity list="BankList" property="bankReconcile.bankCode"
							id="bankcode" name="bankcode"></selectivity> -->
							<!-- <selectivity list="BankList"  ng-model="bankReconcile.bankCode" name="bankcode" 
										property="bankReconcile.bankCode" id="bankcode" validation="required" friendly-name="Bank" ></selectivity> -->
							<selectivity list="BankList" property="bankReconcile.bankCode"
							id="bankCode" name="bankCode"></selectivity>
						</div>
					</div>
				</div>
			</fieldset>
		</div>
	</div>

		<div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<!-- <input type="file" class="form-control btn-primary" name="excelfile" ng-model="excelfile" accept=".xls,.xlsx,.xlsm" />
           			<button class="btn btn-primary" type="button" onclick="angular.element(excelfile).scope().uploadFile(excelfile)" >Upload Statement</button> -->
           			 <%--  access="hasRole('${form_code}_${upload}')">  
           			<button class="btn btn-primary" type="button" ng-click="openFileModal()" >Upload Statement</button>
           			  <a id="tbPdfExport" stype="display:none" href="assets/docs/New_Bank_Statement.xlsx" download="New_Bank_Statement.xlsx"></a>  --%>
					<%--  access="hasRole('${form_code}_${view}')"><button class="btn btn-info" type="button" ng-click="getDiffernceList()">Show Differences</button>--%>
					<button class="btn btn-info" ng-click="getReconcileList()" type="button">Show Records</button>
					<button class="btn btn-danger" ng-click="getReconcileListNew()" type="button">Show Reconciled Records</button>
					<button class="btn btn-danger" ng-click="getReconcileListdraft()" type="button">Show Draft Records</button>
				</div>
			</div>
		</div>
	</form>
  </div>
  	<div class="panel panel-default panel-default-list" st-table="displayedCollection" st-safe-src="rowCollection">
		<%@include file="/views/templates/panel-header.jsp"%><div class="panel-body float-left padding-0" style="width:100%;"><div class="table-responsive"><table id="dt_basic"  class="table table-striped table-bordered table-hover dataTable no-footer"  role="grid" aria-describedby="dt_basic_info">
     <thead class="dataTables-Main-Head">     	
      <tr role="row">
         <th class=""  st-sort="supplier" >Customer/Supplier</th>
       <!-- <th class="sorting width_10">Cheque No.</th> -->
       <th class="sorting"  st-sort="Date1" >Cheque Dt</th>
        <th class="sorting"  st-sort="transactionNo" >Voucher No</th>
       <th class="sorting"  st-sort="transactionType" >Voucher Type</th>
       <th class="sorting" st-sort="narration" >Narration </th>
       <th class="sorting"  st-sort="doctype" >Doc Type</th>
       <th class="sorting" st-sort="Date2" >Doc Date</th>
       <th class="sorting"  st-sort="creditamount"  ng-if="!isUsdBank">Credit </th>
       <th class="sorting"  st-sort="debitamount" ng-if="!isUsdBank">Debit </th>
       <th class="sorting"  st-sort="creditamount" ng-if="isUsdBank">Bc Credit </th>
       <th class="sorting"  st-sort="debitamount" ng-if="isUsdBank">Bc Debit </th>
        <th class="sorting"  st-sort="tcCreditAmount" ng-if="isUsdBank">Tc Credit </th>
          <th class="sorting"  st-sort="tcDebitAmount" ng-if="isUsdBank">Tc Debit </th>
       <th class="sorting"  st-sort="Date3" >Bank Date</th>
       <th class="sorting"  st-sort="remarks" >Remarks</th>
        <th class="sorting">Action</th>
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="(trIndex, objTranslationItem) in displayedCollection">
       <td style="background-color: lightsalmon"> 
         <span tooltip="{{objTranslationItem.supplier}}" class="tool-tip-span" ng-bind="objTranslationItem.supplier"></span>
       </td>
        <!-- <td style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.chqNo}}" class="tool-tip-span" ng-bind="objTranslationItem.chqNo"></span>
       </td> -->
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
       <td align ="right" style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.creditamount|number:2}}" class="tool-tip-span" ng-bind="objTranslationItem.creditamount1"></span>
       </td>
        <td align ="right" style="background-color: lightsalmon">
        <span tooltip="{{objTranslationItem.debitamount|number:2}}" class="tool-tip-span" ng-bind="objTranslationItem.debitamount1"></span>
       </td>
       <td  style="background-color: lightsalmon" ng-if="isUsdBank"><span tooltip="{{objTranslationItem.tcCreditAmount|number:2}}" 
       class="tool-tip-span" ng-bind="objTranslationItem.tcCreditAmount"></span></td>
              <td  style="background-color: lightsalmon" ng-if="isUsdBank"><span tooltip="{{objTranslationItem.tcDebitAmount|number:2}}" class="tool-tip-span" ng-bind="objTranslationItem.tcDebitAmount"></span></td>
       
        <td style="background-color: lightsalmon" ng-if="isReco">
                <ng-bs3-datepicker data-ng-model="objTranslationItem.bank_date" ng-change="calculateTotal(rowCollection)" name="Bank_date{{trIndex}}" id="bank_date{{trIndex}}" /> 
        
       </td>
       <td style="background-color: lightsalmon" ng-if="!isReco">
               <span tooltip="{{objTranslationItem.bank_date}}" class="tool-tip-span" ng-bind="objTranslationItem.bank_date">
        
       </td>
        <td style="background-color: lightsalmon" ng-if="isReco">
        <!-- <div class="input-group input-append date" id="bankDate{{trIndex}}">
          <input type="text" class="form-control input-sm" name="subValidTo"  style=" width: 90px; " id="bankDate{{trIndex}}" ng-model="bankReconcile.bankDate" placeholder='dd/mm/yyyy' />
          <span class="input-group-addon add-on">
           <span class="glyphicon glyphicon-calendar"></span>
          </span>
         </div> -->
                  <input type="text" class="form-control input-sm input-remarks" name="remarks{{trIndex}}" id="remarks{{trIndex}}"   ng-model="objTranslationItem.remarks" />
         
        </td>
        
        
        <td style="background-color: lightsalmon" ng-if="!isReco">
               <span tooltip="{{objTranslationItem.remarks}}" class="tool-tip-span" ng-bind="objTranslationItem.remarks">
         
        </td>
        <td>
        <span> <i
										class="fa fa-trash-o text-danger-dker text"
										data-ng-click="excludedEntry(objTranslationItem,rowCollection,trIndex)"></i>
									</span>
									</td>
        <!-- td class="remarks-td">
       </td> -->
       <!-- <td ng-if="isReconcileList" >
        <span tooltip="{{objTranslationItem.remarks}}" class="tool-tip-span"  ng-if="isReconcileList" ng-bind="objTranslationItem.remarks"></span>
        </td> -->
      </tr>
     </tbody>
    </table>
     <!--  <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
   <div class="col-md-4"><label>Balance as per bank </label>      
   <div class="col-md-4"> <label>Balance as per book  </label>        <span tooltip="{{bankBalance.balanceAsPerBook}}" class="tool-tip-span" ng-bind="bankBalance.balanceAsPerBook"></span>
   <div class="col-md-4"> <label>Difference    </label>     <span tooltip="{{bankBalance.difference}}" class="tool-tip-span" ng-bind="bankBalance.difference"></span>
    </div></div></div>
   </div> -->
  <div class="row" ng-if="!isUsdBank">
		<div class="col-sm-12" style=" margin-top: 32px;">
			<div class="form-group pull-right">
		       <div class="col-sm-4">
	       			<div class="form-group">
				        <label class="col-md-5 control-label">Balance as per bank</label>
				        <div class="col-md-7">
				          <input type="text" class="form-control input-sm  text-right" ng-change="getdifference(bankBalance)" 
				          name="balanceAsPerBank{{trIndex}}" id="balanceAsPerBank{{trIndex}}"
				             ng-model="bankBalance.balanceAsPerBank| number : 2" disabled /> 
				        </div>
			        </div>
		        
		        
		         </div>
		        
		         <div class="col-sm-4">
			         <div class="form-group">
				         <label class="col-md-5 control-label">Balance as per book</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="balanceAsPerBook" 
				         	data-ng-model="bankBalance.balanceAsPerBook| number : 2"
			         	  			 step="0.01"  disabled/>
				        </div>
			        </div>
			        
		        </div>
		          <div class="col-sm-4">
			         <div class="form-group">
				         <label class="col-md-5 control-label">Difference</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="difference" data-ng-model="bankBalance.difference| number : 2"
			         	  			step="0.01" disabled />
				        </div>
			        </div>
			        
		        </div>
		         
		  </div>
	     </div>
	     </div>
	     
	     <div class="row" ng-if="isUsdBank">
		<div class="col-sm-12" style=" margin-top: 32px;">
			<div class="form-group pull-right">
			
			  <div class="col-sm-3">
	       			<div class="form-group">
				        <label class="col-md-5 control-label">Balance as per bank usd</label>
				        <div class="col-md-7">
				          <input type="text" class="form-control input-sm  text-right" ng-change="getdifference(bankBalance)" name="balanceAsPerBankUsd{{trIndex}}" id="balanceAsPerBank{{trIndex}}"   ng-model="bankBalance.balanceAsPerBankUsd" disabled /> 
				        </div>
			        </div>
		        
		        
		         </div>
		         
		         
		       <div class="col-sm-3">
	       			<div class="form-group">
				        <label class="col-md-5 control-label">Balance as per bank</label>
				        <div class="col-md-7">
				          <input type="text" class="form-control input-sm  text-right" ng-change="getdifference(bankBalance)" name="balanceAsPerBank{{trIndex}}" id="balanceAsPerBank{{trIndex}}"   ng-model="bankBalance.balanceAsPerBank" disabled /> 
				        </div>
			        </div>
		        
		        
		         </div>
		        
		         <div class="col-sm-3">
			         <div class="form-group">
				         <label class="col-md-5 control-label">Balance as per book</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="balanceAsPerBook" data-ng-model="bankBalance.balanceAsPerBook| number : 2"
			         	  			 step="0.01"  disabled/>
				        </div>
			        </div>
			        
		        </div>
		          <div class="col-sm-3">
			         <div class="form-group">
				         <label class="col-md-5 control-label">Difference</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="difference" data-ng-model="bankBalance.difference| number : 2"
			         	  			step="0.01" disabled />
				        </div>
			        </div>
			        
		        </div>
		         
		  </div>
	     </div>
	     </div>
	     </div>
	    
	</div>
	
	
	
	<div class="row" ng-if="isReco">
		<div class="col-md-12" style=" margin-top: 32px;">
			<div class="form-group pull-right">
	
	<div class="col-md-6">
			         <div class="form-group">
				         <label class="col-md-5 control-label">Unreconciled Receipts</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="differenceReceipt" data-ng-model="bankBalance.differenceReceipt| number : 2"
			         	  			step="0.01" disabled />
				        </div>
			        </div>
			        
		        </div>
		         <div class="col-md-6">
			         <div class="form-group">
				         <label class="col-md-6 control-label">Unreconciled Payments</label>
				        <div class="col-md-6">
				         	<input type="text" class="form-control input-sm text-right" name="differencePayment" data-ng-model="bankBalance.differencePayment| number : 2"
			         	  			step="0.01" disabled />
				        </div>
			        </div>
			        
		        </div>
	</div></div></div>
	
	
	<div class="row" ng-if="!isReco">
		<div class="col-md-12" style=" margin-top: 32px;">
			<div class="form-group pull-right">
	
	
	<div class="col-md-6">
			         <div class="form-group">
				         <label class="col-md-5 control-label">Reconciled Receipts</label>
				        <div class="col-md-7">
				         	<input type="text" class="form-control input-sm text-right" name="differenceReceipt" data-ng-model="bankBalance.differenceReceipt| number : 2"
			         	  			step="0.01" disabled />
				        </div>
			        </div>
			        
		        </div>
		         <div class="col-md-6">
			         <div class="form-group">
				         <label class="col-md-6 control-label">Reconciled Payments</label>
				        <div class="col-md-6">
				         	<input type="text" class="form-control input-sm text-right" name="differencePayment" data-ng-model="bankBalance.differencePayment| number : 2"
			         	  			step="0.01" disabled />
				        </div>
			        </div>
			        
		        </div>
		        
		      
	</div></div></div>
	
  <%-- <footer class="panel-footer">
    <%@include file="/views/templates/panel-footer-static.jsp"%>
   </footer> --%>
   <div class="form-actions">
			<div class="row">
				<div class="col-md-12">
					<%--  access="hasRole('${form_code}_${add}')"> --%>
   					<button class="btn btn-success" ng-if="isReco" ng-click="reconcileRecords(rowCollection)" type="button">Reconcile</button>
   				  <button class="btn btn-success"  id="exportXl1"  ng-if="isReco" ng-click="exportExcel1(rowCollection)"  type="button">Export to Excel</button>
   					<button class="btn btn-success"    ng-if="isReco" ng-click="print1(rowCollection)"  type="button">Print</button>
		        
   				
   					<!-- -->
   				<%-- 	 access="hasRole('${form_code}_${add}')"> --%>
   					<button class="btn btn-success"  ng-if="isRecoDraft" ng-click="reconcileRecordsDraft(rowCollection)"  type="button">Reconcile To Draft</button>
   					<button class="btn btn-success"  id="exportXl"  ng-if="!isReco" ng-click="exportExcel(rowCollection)"  type="button">Export to Excel</button>
   					<button class="btn btn-success"    ng-if="!isReco" ng-click="print(rowCollection)"  type="button">Print</button>

   					</div>  
   					
		
   			   </div>
   			   
   			   
   			   </div>
  </div>
 </div>
</div>

 
 <script type="text/ng-template" id="fileModal">

<div class="modal-header"> File Upload</div>
<div class="row">
	<div class="col-lg-12">
		<div class="col-lg-12">
			<!--<input type="file"  class="form-control btn-primary" id="file" name="file">-->
			<input type="file" class="form-control btn-primary"  name="excelfile" onchange="angular.element(this).scope().uploadFile(this)"  accept=".xls,.xlsx,.xlsm" />
		</div>
	</div> 
</div>
<div class="modal-footer">
<button class="btn btn-info" <a ng-click="downloadFile()">Download sample file </a></button>

	<button class="btn btn-info" type="button" ng-click="uploadBankStatement()">OK</button>
	<button class="btn btn-danger" ng-click="closeThisDialog()">Cancel</button>
  

</div>
 </script>
 
<style>
.remarks-td{
	  padding: 0px 0px !important;
}
.input-remarks{
	height: 28px !important;
}
</style> 