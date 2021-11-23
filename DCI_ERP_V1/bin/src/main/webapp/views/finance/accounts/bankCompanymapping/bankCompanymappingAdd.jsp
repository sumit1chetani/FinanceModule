<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
      <div class="widget-body">
       <form class="form-horizontal" id="cashBankcomPaymentForm" name=cashBankcomPaymentForm novalidate method="post">
        <div class="row">
         <div class="col-sm-12">
		     <div class="col-sm-4">
		     	<div class="form-group" ng-if="edit">
			        <label class="col-md-5 control-label">Voucher No</label>
			        <div class="col-md-7">				       
				        <input type="text" class="form-control  bg-color-none b-none" id="voucherNo" name="Voucher No" ng-model="cashbankpaymentModelData.cbVoucherNo" ng-disabled="true" />				        
			        </div>
		       	</div>
		       <div class="form-group">
			        <label class="col-md-5 control-label">Organization Name<span style="color:red;"> *</span></label>
			        <div class="col-md-7">				       
				        <selectivity list="companyList" property="bankcompanyData.companyName"  ng-model="bankcompanyData.companyName" 
								        id="companyCode" name="organizationName" object="company" validation="required" 
								        friendly-name="	companyName" form-name = "cashBankcomPaymentForm"></selectivity>					        
			        </div>
		       	</div> 
		      <!--  	<div class="col-sm-4">
		    
		     	<div class="form-group" id="cashaccountgroup">
			        <label class="col-md-5 control-label">Bank Acct</label>
			        <div class="col-md-7">
			           <selectivity list="cashAccountList" id="companyCode" name="Cash Acct Name" 
				        property="bankcompanyData.companyName" ng-model="bankcompanyData.companyName" 
				         friendly-name="Cash Acct" form-name = "cashBankcomPaymentForm" object="acctList"></selectivity>
			        </div>
			          
		     	</div> -->
		       	
		     	
		       	<div class="form-group">
				        <label class="col-md-5 control-label">Branch</label>
				        <div class="col-md-7">
					         <input type="text" class="form-control input-sm" name="branch" ng-model="bankcompanyData.branch"
				          	 id="AcctName"  friendly-name="Branch"/>
				        </div>
		    </div>
			       
		     	 <div class="form-group">
				        <label class="col-md-5 control-label" ng-if="bankcompanyData.paymentType=='bank'">Bank Short Code</label>
				        <div class="col-md-7" ng-if="bankcompanyData.paymentType=='bank'">
					         <input type="text" class="form-control input-sm" name="bankshort" ng-model="bankcompanyData.bankshort"
				          	 id="bankshort" friendly-name="bankshort"/>
				        </div>
		    </div>
			       
		      <div class="form-group">
				        <label class="col-md-5 control-label" ng-if="bankcompanyData.paymentType=='cash'">Cash Short Code</label>
				        <div class="col-md-7" ng-if="bankcompanyData.paymentType=='cash'">
					         <input type="text" class="form-control input-sm" name="bankshort" ng-model="bankcompanyData.bankshort"
				          	 id="bankshort" friendly-name="bankshort"/>
				        </div>
		    </div>
		      
		      
		     	
		     	 
		    </div>
		    
		    
		    
		    <div class="col-sm-4">
		    
		    
		    <div class="form-group" id="paymentType">
			        <label class="col-md-5 control-label">Payment Type</label>
			        <div class="col-md-7">
			           <selectivity list="pmtTypeList" id="paymentType" name="Payment type" 
				        property="bankcompanyData.paymentType" ng-model="bankcompanyData.paymentType" 
				         friendly-name="Payment type" form-name = "cashBankcomPaymentForm" object="acctList"></selectivity>
			        </div>
			          
		     	</div>
			
		     	<div class="form-group" id="cashaccountgroup" ng-if="bankcompanyData.paymentType=='bank'">
			        <label class="col-md-5 control-label" ng-if="bankcompanyData.paymentType=='bank'">Bank Acct</label>
			        <div class="col-md-7" ng-if="bankcompanyData.paymentType=='bank'">
			           <selectivity list="cashAccountList" id="accountName" name="Cash Acct Name" 
				        property="bankcompanyData.accountName" ng-model="bankcompanyData.accountName" 
				         friendly-name="Cash Acct" form-name = "cashBankcomPaymentForm" object="acctList"></selectivity>
			        </div>
			          
		     	</div>
		     	
		     	<div class="form-group" id="cashaccountgroup" ng-if="bankcompanyData.paymentType=='cash'">
			        <label class="col-md-5 control-label" ng-if="bankcompanyData.paymentType=='cash'">Cash Acct</label>
			        <div class="col-md-7" ng-if="bankcompanyData.paymentType=='cash'">
			           <selectivity list="cashbankAccountList" id="accountName" name="Cash Acct Name" 
				        property="bankcompanyData.accountName" ng-model="bankcompanyData.accountName" 
				         friendly-name="Cash Acct" form-name = "cashBankcomPaymentForm" object="acctList"></selectivity>
			        </div>
			          
		     	</div>
			
			
	
		    </div>
		    
		    
		    
		    
		    <div class="col-sm-4">
				        <label class="col-md-4 control-label" ng-if="bankcompanyData.paymentType=='bank'">Bank Acct Name</label>
				        <div class="col-md-7" ng-if="bankcompanyData.paymentType=='bank'">
					         <input type="text" class="form-control input-sm" name="accountHeadName" ng-model="bankcompanyData.accountHeadName"
				          	 id="accountHeadName" friendly-name="accountHeadName"/>
				        </div>
		    </div>
			           
		    
		    <div class="col-sm-4">
				        <label class="col-md-4 control-label" ng-if="bankcompanyData.paymentType=='cash'">Cash Acct Name</label>
				        <div class="col-md-7" ng-if="bankcompanyData.paymentType=='cash'">
					         <input type="text" class="form-control input-sm" name="accountHeadName" ng-model="bankcompanyData.accountHeadName"
				          	 id="accountHeadName" friendly-name="accountHeadName"/>
				        </div>
		    </div>
			       
			       
		    <div class="col-sm-4">
		     <div class="form-group">
						<label class="col-md-4 control-label"> Active </label>
						<div class="col-md-3">
							<div class="checkbox">
								<label class="i-checks">
								<input type="checkbox"	 class="checkbox style-0" ng-true-value="'Y'"	ng-false-value="'N'"	
								name="Active" ng-model="bankcompanyData.acctHeadStatus" checked />
									<i></i> </label>
							</div>
						</div>
					</div>
		    
		      
		    </div>
		    
		    
		    <div class="col-sm-4">
		     <div class="form-group">
						<label class="col-md-4 control-label"> Cash Bank Payment/Receipt </label>
						<div class="col-md-3">
							<div class="checkbox">
								<label class="i-checks">
								<input type="checkbox"	 class="checkbox style-0" ng-true-value="'Y'"	ng-false-value="'N'"	
								name="cashbankPayment" ng-model="bankcompanyData.cashbankPayment" checked />
									<i></i> </label>
							</div>
						</div>
					</div>
		    
		      
		    </div>
	    </div> <!-- /col-sm-12 -->
	    <!-- /col-md-12 -->
	    
	    
		</div> <!-- /row -->
		 <div class="form-actions">
         <div class="row">
       	 <div class="col-md-12">
          		<button class="btn btn-success" type="button" ng-if="bankcompanyData.edit==false" ng-click="onSubmit(cashBankcomPaymentForm,bankcompanyData)" >
		          <i class="fa fa-save"></i>
		          Save
		         </button>
		         <button class="btn btn-success"  type="button" ng-if="bankcompanyData.edit==true" ng-click="onSubmit(cashBankcomPaymentForm,bankcompanyData)"><i class="fa fa-save"></i>
		         Update
		           </button>
		        <button class="btn btn-danger"  type="button" class="btn btn-success" ng-click="cancel()">
		        <i class="fa fa-close"></i>
		        Cancel
		       </button>
          </div>
          </div>
          </div>
       </form>
      </div>
      <!-- end widget content -->
     </div>
     <!-- end widget div -->
    </div>  <!-- /standard-datatable-widget -->
   </article>
   <!-- WIDGET END -->
  </div>
 </section>
</div>
