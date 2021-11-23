<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">  
   <ol class="breadcrumb inline-block padding-left-10">
    <li>
      <a>Finance</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.transaction">Transaction</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.transaction.paymentorder">Payment Order</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.transaction.paymentorderform">Add</a>
    </li>
   </ol>
  </div>
  <div class="panel-body">
   <form name="PaymentOrderForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
     <div class="col-sm-12">
	     <div class="col-sm-6">
	     	<div class="form-group">
		        <label class="col-md-5 control-label">Supplier</label>
		        <div class="col-md-7">		      
			        <select class="form-control input-sm" id="supplierName" name="supplierName" ng-model="PaymentOrderMasterData.supplierName"
			        ng-options="ac.supplierCode as ac.supplierName for ac in supplierList" ng-change="getInvoiceNo(PaymentOrderMasterData.supplierName)" required>
			        <option value="" selected="selected">--Select--</option>
			        </select>       	
		        </div>
	     	</div>
	     	<div class="form-group">
		        <label class="col-md-5 control-label">Order No.</label>
		        
		        <div class="col-md-7">
		          <input type="text" class="form-control input-sm" id="orderNo" name="orderNo"
		          ng-model="PaymentOrderMasterData.orderNo" required ng-disabled="true" />
		          		          
		        </div>
	     	</div>
	     	<div class="form-group">
		        <label class="col-md-5 control-label">Date</label>
		        <div class="col-md-7">
		          <input type="text" class="form-control input-sm" id="date" name="date"
		          ng-model="PaymentOrderMasterData.date" required ng-disabled="true" />
		          		          
		        </div>
	     	</div>
	     	<div class="form-group ">
		        <label class="col-md-5 control-label">Amount</label>
		        <div class="col-md-7">
		        	<input type="text" class="form-control input-sm" id="amount" name="amount" 
		        	ng-model="PaymentOrderMasterData.amount"  ng-disabled="true" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Amount Should be 2 digit|required"  step="0.001"/>		        			        	
		        	 <!-- <input type="text" class="form-control input-sm" name="currency"  ng-model="DebitNoteMasterData.currency"  required> -->
		        </div>
	       	</div>
	       	
	       	<div class="form-group ">
		        <label class="col-md-5 control-label">Amount (USD)</label>
		        <div class="col-md-7">
		        	<input type="text" class="form-control input-sm" id="amountUSD" name="amountUSD" 
		        	ng-model="PaymentOrderMasterData.amountUSD"  ng-disabled="true" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Amount(USD) Should be 2 digit|required"  step="0.001"/>		        			        			        	 
		        </div>
	       	</div>
	       	
	       	<div class="form-group">
		        <label class="col-md-5 control-label">Cash / Bank</label>
		        <div class="col-md-7">		      
			        <select class="form-control input-sm" id="cashBank" name="cashBank" ng-model="PaymentOrderMasterData.cashbank"
			        ng-options="ac.cashBank as ac.cashBankrName for ac in cashBankList" ng-change="getInvoiceNo(PaymentOrderMasterData.cashBankName)" required>
			        <option value="" selected="selected">--Select--</option>
			        </select>       	
		        </div>
	     	</div>
	     	
	    </div>
	    <div class="col-sm-6">	     	
	     	<div class="form-group ">
		        <label class="col-md-5 control-label">Currency</label>
		        <div class="col-md-7">
		        	<input type="text" class="form-control input-sm" id="currencyCode" name="currencyCode" 
		        	ng-model="PaymentOrderMaster.currencyCode" />		        			        	
		        	 <!-- <input type="text" class="form-control input-sm" name="currency"  ng-model="DebitNoteMasterData.currency"  required> -->
		        </div>
	       	</div>
	       	<div class="form-group">
		        <label class="col-md-5 control-label">Exchange Rate</label>
		        <div class="col-md-7">
		         	<input type="text" class="form-control input-sm text-right" id="exchangeRate" name="exchangeRate"
		         	ng-model="PaymentOrderMaster.exchangeRate" required ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"/>		         	
		         	 <!-- <input type="text" class="form-control input-sm" name="exchangeRate"  ng-model="DebitNoteMasterData.exchangeRate"  required> --> 
		        </div>
	       </div>
	       <div class="form-group">
		        <label class="col-md-5 control-label">Amount</label>
		        <div class="col-md-7">
		         	<input type="text" class="form-control input-sm text-right" id="amountBc" name="amountBc" data-ng-model="PaymentOrderMaster.companyName" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Amount Should be 2 digit|required"  step="0.01" required />
		         			         	
		        </div>
	       </div>
	       <div class="form-group">
		        <label class="col-md-5 control-label">Amount (USD)</label>
		        <div class="col-md-7">
		         	<input type="text" class="form-control input-sm text-right" id="amountTc" name="amountTc" data-ng-model="PaymentOrderMaster.narration" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=Amount(USD) Should be 2 digit|required"  step="0.01" required />		         	
		        </div>
	       </div>
	       
	       <div class="form-group">
		        <label class="col-md-5 control-label">Cheque No</label>
		        <div class="col-md-7">
		         	<input type="text" class="form-control input-sm" id="cheqNo" name="cheqNo" data-ng-model="PaymentOrderMaster.cheqNo" required />		         	
		        </div>
	       </div>
	       
	       <div class="form-group">
		        <label class="col-md-5 control-label">Chq Date</label>
		        <div class="col-md-7">
		          	<div class="input-group">		                
		                <input type="text" id="chequeDate" name="Cheque Date" data-ng-model="PaymentOrderMaster.chequeDate" class="form-control" placeholder="DD/MM/YYYY" 
						 show-button-bar="false" datepicker-popup="dd/MM/yyyy" is-open="showedvalidPaymentOrderDate" datepicker-options="dateOptions"  
		              close-text="Close" ng-disabled="true" value="" validator="required" valid-method="submit" message-id="chequeDate"  />
		                
		              <span class="input-group-btn">
		               <button type="button" class="btn btn-default " ng-click="showPaymentOrderDate($event,'showedvalidPaymentOrderDate')">
		                <i class="glyphicon glyphicon-calendar"></i>
		               </button>
		              </span>
		            </div>
		        </div>
	     	</div>
	       
	       
	    </div>
    </div>
   </div>     		
	
	 <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="content">
      	<div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-success" type="button" ng-if="!PaymentOrderMaster.edit" ng-click="submit(DebitNoteForm)" ng-if="!PaymentOrderMaster.edit"><!-- ng-click="onSubmit(DebitNoteForm,DebitNoteMasterData)" -->
           <i class="fa fa-save"></i>
           Save
          </button>
          <button class="btn btn-success" type="button" ng-if="PaymentOrderMaster.edit" ng-click="submit(DebitNoteForm)">
           <i class="fa fa-save"></i>
           Update
          </button>
          <button class="btn btn-danger" ng-click="cancel()" type="button">
           <i class="fa fa-close"></i>
           Cancel
          </button>
         </div>
        </div>
       </div>
      </div>
     </div>
    </div>
   </form>
  </div>
 </div>
</div>