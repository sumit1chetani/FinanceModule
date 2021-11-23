<!-- <style> 
#main {
  width: 200px;
  height: 200px;
  border: 1px solid #c3c3c3;
  display: flex;
  flex-wrap: wrap;
}


</style> -->

<div id ="main">
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
       <form class="form-horizontal" id="cashBankPaymentForm" name="cashBankPaymentForm" novalidate method="post">
        <div class="row">
         <div class="col-sm-12">
		     <div class="col-sm-4">
		     	<div class="form-group" ng-if="edit">
			        <label class="col-md-5 control-label">Voucher No</label>
			        <div class="col-md-7">				       
				        <input type="text" class="form-control  bg-color-none b-none" id="cbVoucherNo1" name="Voucher No" ng-model="cashbankpaymentModelData.cbVoucherNo1" ng-disabled="true" />				        
			        </div>
		       	</div>
		       	
		       	
		       	
		      	<div class="form-group">
			        <label class="col-md-5 control-label">Organization Name<span style="color:red;"> *</span></label>
			      <%--   <div class="col-md-7">				       
				        <selectivity list="companyList" property="cashbankpaymentModelData.companyName"  ng-model="cashbankpaymentModelData.companyName" 
						  id="companyName" name="companyName"<spring:message
			              			code="label.company.name"></spring:message> object="company" validation="required" 
								        friendly-name="	<spring:message
			              			code="label.company.name"></spring:message>" form-name = "cashBankPaymentForm"></selectivity>	
		<selectivity  list="companyList" property="cashbankpaymentModelData.companyName" ng-model="cashbankpaymentModelData.companyName" 
         id="companyName" form-name="sailingsReportForm" name="companyName" validation="required" friendly-name="From Vessel" ></selectivity>					        
			        </div> --%>
			        
			         <label class="col-md-7" style="margin-top:1%;"><span>{{cashbankpaymentModelData.company1}}</span></label>
		       	</div>
		       	
		     <%--   	<div class="form-group">
			        <label class="col-md-5 control-label"><spring:message
			              			code="label.company.name"></spring:message><span style="color:red;"> *</span></label>
			        <div class="col-md-7">				       
				        <selectivity list="companyList" property="cashbankpaymentModelData.companyName"  ng-model="cashbankpaymentModelData.companyName" 
								        id="cmbCompanyName" name="<spring:message
			              			code="label.company.name"></spring:message>" object="company" validation="required" 
								        friendly-name="	<spring:message
			              			code="label.company.name"></spring:message>" form-name = "cashBankPaymentForm"></selectivity>					        
			        </div>
		       	</div> --%>
		     <!-- 	<div class="form-group">
			        <label class="col-md-5 control-label">Payment Date<span style="color:red;"> *</span></label>
			        <div class="col-md-7">
							<div class="dropdown">
								<a class="dropdown-toggle" id="cashbankPmt_Date" role="button"
									data-toggle="dropdown" data-target="#" href="#">
									<div class="input-group">
										<input type="text" class="form-control" placeholder="dd/mm/yyyy" 
											name="Payment Date" validation="date_euro_long|required" 
											friendly-name="Payment Date" data-ng-model="cashbankpaymentModelData.cashbankPmtDate">
											<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
										
									</div>
								</a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dLabel">
									<datetimepicker data-ng-model="cashbankpaymentModelData.cashbankPmtDate" data-on-set-time="cashbankpaymentModelData.cashbankPmtDate = onDateSet(newDate)"
										data-datetimepicker-config="{ dropdownSelector: '#cashbankPmt_Date',startView:'day', minView:'day'}" />
								</ul>
							</div>
			        </div>
		     	</div> -->
		     	
		     	
		      	<div class="form-group">
			        <label class="col-md-5 control-label">Payment Type<span style="color:red;"> *</span></label>
			        <div class="col-md-7 " >
			  		<!-- 	<selectivity list="pmtTypeList" property="cashbankpaymentModelData.pmtType"  ng-model="cashbankpaymentModelData.pmtType" 
								        id="pmtType" name="Payment Type" object="pmttypeobj" validation="required" 
								        friendly-name="Payment Type" form-name = "cashBankPaymentForm" disab></selectivity>	
			        </div>
			         <div class="col-md-7 "  ng-if="edit">
			  			<selectivity list="pmtTypeList" property="cashbankpaymentModelData.pmtType"  ng-model="cashbankpaymentModelData.pmtType" 
								        id="pmtType" name="Payment Type" object="pmttypeobj" validation="required" 
								        friendly-name="Payment Type" form-name = "cashBankPaymentForm" disabled="true"></selectivity>	 -->
								        <label class="col-md-2 control-label"><span>{{cashbankpaymentModelData.pmtType}}</span></label>
			        </div>
		       	</div>
		       	<div class="form-group" id="bankaccountgroup" ng-if="pmtTypeShow">
			        <label class="col-md-5 control-label">Bank Acct<span style="color:red;"> *</span></label>
			         	<!-- <selectivity  list="bankAccountList" id="accountName" name="Bank Acct Name" 
				        property="cashbankpaymentModelData.accountName" ng-model="cashbankpaymentModelData.accountName" 
				        validation="required" friendly-name="Bank Acct" form-name = "cashBankPaymentForm" object="acctList"></selectivity>
			        </div>
			         <div class="col-md-7"  ng-if="edit">
			         	<selectivity  list="bankAccountList" id="accountName" name="Bank Acct Name" 
				        property="cashbankpaymentModelData.accountName" ng-model="cashbankpaymentModelData.accountName" 
				        validation="required" friendly-name="Bank Acct" form-name = "cashBankPaymentForm" object="acctList" disabled="true"></selectivity> -->
			             <label  class="col-md-7" style="margin-top:1%;"><span>{{cashbankpaymentModelData.acctheadName}}</span></label>
			  
		     	</div>
		     	<div class="form-group" id="cashaccountgroup" ng-if="!pmtTypeShow">
			        <label class="col-md-5 control-label">Cash Acct<span style="color:red;"> *</span></label>
			           <!-- <selectivity list="cashAccountList" id="accountName" name="Cash Acct Name" 
				        property="cashbankpaymentModelData.accountName" ng-model="cashbankpaymentModelData.accountName" 
				        validation="required" friendly-name="Cash Acct" form-name = "cashBankPaymentForm" object="acctList"></selectivity>
			        </div>
			          <div class="col-md-7" ng-if="edit">
				          <selectivity list="cashAccountList" id="accountName" name="Cash Acct Name" 
					        property="cashbankpaymentModelData.accountName" ng-model="cashbankpaymentModelData.accountName" 
					        validation="required" friendly-name="Cash Acct" form-name = "cashBankPaymentForm" object="acctList" disabled="true"></selectivity> -->
			          <label class="col-md-6 control-label"><span>{{cashbankpaymentModelData.accountName}}</span></label>
			  
		     	</div>
		     	
		     	<div class="form-group" >
			        <label class="col-md-5 control-label">Cash Denomination</label>
			        <div class="col-md-7">
			        	<!-- <input type="text" class="form-control input-sm" id="cashdenomination" name="cashdenomination"
			        	data-ng-model="cashbankpaymentModelData.cashdenomination" /> -->
			        	 <label class="col-md-2 control-label"><span>{{cashbankpaymentModelData.cashdenomination}}</span></label>
			  
			        </div>
		       	</div>
		    </div>
		    
		    
		    
		    <div class="col-sm-4">
		    
		    
		    
		    	<div class="form-group">
												<label class="col-md-5 control-label"> Fund Type</label>
												<div class="col-md-7">
													<!-- <selectivity list="costList" id="costCenter"
														name="costCenter" form-name="cashBankPaymentForm"
														property="cashbankpaymentModelData.costCenter"
														ng-model="cashbankpaymentModelData.costCenter"
														friendly-name="Costcenter" validation="required" ></selectivity> -->
														 <label class="col-md-7" style="margin-top:1%;"><span>{{cashbankpaymentModelData.costName}}</span></label>		  
												</div>
											</div>
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
			<!-- <div class="form-group">
			        <label class="col-md-5 control-label">Currency</label>
			        <div class="col-md-7">
			        	<input type="text" class="form-control input-sm" id="currencyCode" name="currencyCode"
			        	ng-model="cashbankpaymentModelData.currencyCode" readonly required/>
			        					 <label class="col-md-2 control-label"><span>{{cashbankpaymentModelData.currencyCode}}</span></label>		  
										
			        </div>
		       	</div> -->
		       <!-- 	<div class="form-group">
			        <label class="col-md-5 control-label">Exchange Rate</label>
			         <div class="col-md-7" >
			         <input type="text" class="form-control input-sm" id="exgRate" name="exgRate"
			         	ng-model="cashbankpaymentModelData.exchangeRate"  data-ng-change="onChangeNumber('exgRate',cashbankpaymentModelData.exchangeRate)" required  readonly/>
			         </div>
		       	</div> -->
		     	<div class="form-group" >
			        <label class="col-md-5 control-label">Paid To</label>
			        <div class="col-md-7">
			        	<!-- <input type="text" class="form-control input-sm" id="paidTo" name="paidTo"
			        	data-ng-model="cashbankpaymentModelData.paidTo" /> -->
			        			 <label class="col-md-2 control-label"><span>{{cashbankpaymentModelData.paidTo}}</span></label>		  
				
			        </div>
		       	</div>
	
	
	
	
		    	<div class="form-group">
			        <label class="col-md-5 control-label">Amount<span style="color:red;"> *</span></label>
			        <div class="col-md-7" >
			        	<!-- <input type="text" class="form-control input-sm" id="bcAmount" name="bcAmount"
			        	data-ng-model="cashbankpaymentModelData.bcAmountHdr" 
			        	ng-pattern-restrict="^[0-9.]*$" />
			        </div>
			         <div class="col-md-7" ng-if="edit">
			        	
			        	<input type="text" ng-if="isPo" class="form-control input-sm" id="bcAmount" name="bcAmount"
			        	data-ng-model="cashbankpaymentModelData.bcAmountHdr" 
			        	ng-pattern-restrict="^[0-9.]*$" disabled />
			        	
			        	<input type="text" ng-if="!isPo" class="form-control input-sm" id="bcAmount" name="bcAmount"
			        	data-ng-model="cashbankpaymentModelData.bcAmountHdr" 
			        	ng-pattern-restrict="^[0-9.]*$" /> -->
			        			 <label align ="right" class="col-md-2 control-label"><span>{{cashbankpaymentModelData.bcAmountHdr|number:2}}</span></label>		  
				
			         </div>
		       	</div>
		       	
		       		     	<div class="form-group" >
			        <label class="col-md-5 control-label">Approval Note</label>
			     <!--    <div class="col-md-7">
			        	<textarea type="text" cols="45" rows="5" class="form-control input-sm" id="approvenote" 
			        	name="approvenote"
			        	ng-model="cashbankpaymentModelData.approvenote"  friendly-name="Approval Note"></textarea>
			        </div> -->
			        								 <label class="col-md-2 control-label"><span>{{cashbankpaymentModelData.approvenote}}</span></label>		  
			        
		       	</div>
		    </div>
		    <div class="col-sm-4">
		    
		    
		    	<div class="form-group">
			        <label class="col-md-5 control-label">Payment Date<span style="color:red;"> *</span></label>
			        <div class="col-md-7">
							<!-- <div class="dropdown">
								<a class="dropdown-toggle" id="cashbankPmt_Date" role="button"
									data-toggle="dropdown" data-target="#" href="#">
									<div class="input-group">
										<input type="text" class="form-control" placeholder="dd/mm/yyyy" 
											name="Payment Date" validation="date_euro_long|required" 
											friendly-name="Payment Date" data-ng-model="cashbankpaymentModelData.cashbankPmtDate">
											<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
										
									</div>
								</a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dLabel">
									<datetimepicker data-ng-model="cashbankpaymentModelData.cashbankPmtDate" data-on-set-time="cashbankpaymentModelData.cashbankPmtDate = onDateSet(newDate)"
										data-datetimepicker-config="{ dropdownSelector: '#cashbankPmt_Date',startView:'day', minView:'day'}" disabled = "true" />
								</ul>
							</div> -->
								 <label class="col-md-2 control-label"><span>{{cashbankpaymentModelData.cashbankPmtDate}}</span></label>		  
				
			        </div>
		     	</div>
		    	<div class="form-group" ng-if="pmtTypeShow">
			        <label class="col-md-5 control-label">Cheque No</label>
			        <div class="col-md-7">
			        	<!-- <selectivity list="chequeList" id="chequeNo" name="chequeNo" 
				        	property="cashbankpaymentModelData.chequeNo" ng-model="cashbankpaymentModelData.chequeNo"></selectivity>
			         </div>
			        
			         <div class="col-md-7"  ng-if="edit">
			        	<selectivity list="chequeEditList" id="chequeNo" name="chequeNo" 
				        	property="cashbankpaymentModelData.chequeNo" ng-model="cashbankpaymentModelData.chequeNo"></selectivity> -->
			        	 <label class="col-md-2 control-label"><span>{{cashbankpaymentModelData.chequeNo}}</span></label>		  
				
			        </div>
		       	</div>
		       	<div class="form-group"  ng-if="pmtTypeShow">
			        <label class="col-md-5 control-label">Cheque Date</label>
			        <div class="col-md-7">
							<!-- <div class="dropdown">
								<a class="dropdown-toggle" id="cheque_Date" role="button"
									data-toggle="dropdown" data-target="#" href="#">
									<div class="input-group">
										<input type="text" class="form-control" placeholder="dd/mm/yyyy" name="Credit Note Date" 
											data-ng-model="cashbankpaymentModelData.chequeDate">
											<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>											
										
									</div>
								</a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dLabel">
									<datetimepicker data-ng-model="cashbankpaymentModelData.chequeDate" data-on-set-time="cashbankpaymentModelData.chequeDate = onDateSet(newDate)"
										data-datetimepicker-config="{ dropdownSelector: '#cheque_Date',startView:'day', minView:'day'}" />
								</ul>
							</div> -->
							<label class="col-md-2 control-label"><span>{{cashbankpaymentModelData.chequeDate}}</span></label>		  
				
			        </div>
		     	</div>
			    <!-- <div class="form-group">
			        <label class="col-md-5 control-label">TC Amt<span style="color:red;"> *</span></label>
			        <div class="col-md-7">
			         	<input type="text" class="form-control input-sm" id="tcAmount" name="tcAmount" data-ng-model="cashbankpaymentModelData.tcAmountHdr" validation="required" friendly-name="TC Amt" data-ng-change="onChangeNumber('tcAmount',cashbankpaymentModelData.tcAmountHdr)"/>
			        </div>
			    </div> -->
			    <div class="form-group" >
			        <label class="col-md-5 control-label">Narration</label>
			        <div class="col-md-7">
			        	<!-- <textarea type="text" cols="5" rows="2" class="form-control input-sm" id="narration" name="narration"
			        	ng-model="cashbankpaymentModelData.narration"  friendly-name="Narration"></textarea> -->
			        	<label  class="col-md-7" style="margin-top:1%;"><span>{{cashbankpaymentModelData.narration}}</span></label>		  
				
			        </div>
		       	</div>
		    </div>
	    </div> <!-- /col-sm-12 -->
	    <div class="col-md-12">
        	<div class="table table-striped table-bordered table-hover dataTable  b-t b-light b-a">
				<table class="table table-striped table-bordered table-hover dataTable  b-t b-light">
				<thead class="dataTables-Main-Head">
		          <tr>
		            <th colspan="1" class="sorting width_1"></th>
		            <th colspan="1" class="visible-left sorting width_5 text-center">CB Pmt Dtl Id</th>
		          <th colspan="1" class="sorting width_13 text-center">Nature of Payment</th> 
		             <th colspan="1" class="sorting width_13 text-center">Account Head<span style="color:red;"> *</span></th> 
		             <th colspan="1" class="sorting width_13 text-center">Ledger Name	</th>
		         <!--    <th colspan="1" class="sorting width_8 text-center">Invoice Dtls</th> -->
<!-- 		            <th colspan="1" class="sorting width_10">Payment Order Number</th>
 -->		            
<!--  <th colspan="1" class="sorting width_8 text-center">Currency<span style="color:red;"> *</span></th>
 --><!-- 		            <th colspan="1" class="sorting width_10 text-center">Ex. Rate</th>
 -->		            <th colspan="1" class="sorting width_8 text-center">Amount</th>
<!-- 		            <th colspan="1" class="sorting width_8 text-center">TC Amt</th>
 -->		            <th colspan="1" class="sorting width_8 text-center visible-left">Pending Inv List</th>		
		            
		          </tr>
		        </thead>
		        <!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->
		        <tbody ng-repeat="(trIndex, row) in cashbankpaymentModelData.cbptables" ng-controller="tableCtrl">
		      <tr>
			            <td><label class="i-checks m-b-none"> <input type="checkbox" 
			            ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
			            <td class="visible-left"><div class="row"><div class="col-xs-12">
			            	<input type="text" class="form-control" id="cashBankPmtDtlId" ng-model="row.cashBankPmtDtlId" value="" />
			            </div></div></td>
			            
			            
			            <td class="padding-both-side-2">
			            	<div class="row">
			            		<div class="col-xs-12">
				            		<div class="col-xs-12" ng-if="!row.isInvoiceNo">
				            			<selectivity list="paymentList" ng-model="row.cbpdtlpaymentHead" disabled="true"
				              		property="row.cbpdtlpaymentHead"  id="account{{trIndex}}" name="{{ 'cbpdtlAccountHead' + $index }}"  
				              		 friendly-name="{{ 'Row ' + $index + ' (Payment Name on Detail table)'}}" 
			           				form-name="cashBankPaymentForm" ></selectivity>
				            		</div>
				            		<div class="col-xs-12" ng-if="row.isInvoiceNo">
				            			<selectivity list="paymentList" ng-model="row.cbpdtlpaymentHead"  disabled="true"
				              		property="row.cbpdtlpaymentHead"  id="account{{trIndex}}" name="{{ 'cbpdtlpaymentHead' + $index }}"  
				              		friendly-name="{{ 'Row ' + $index + ' (Paayment Name on Detail table)'}}" 
			           				form-name="cashBankPaymentForm" disabled="true"></selectivity>
				            		</div>
				              	
			        			</div>
			        		</div>
			        	</td>
			            
			            
			            <td class="padding-both-side-2">
			            	<div class="row">
			            		<div class="col-xs-12">
				            		<div class="col-xs-12" ng-if="!row.isInvoiceNo">
				            			<selectivity list="cbpdtlAcctHeadList" ng-model="row.cbpdtlAccountHead" 
				              		property="row.cbpdtlAccountHead"  id="account{{trIndex}}" name="{{ 'cbpdtlAccountHead' + $index }}"  
				              		validation="required" friendly-name="{{ 'Row ' + $index + ' (Account Name on Detail table)'}}" 
			           				form-name="cashBankPaymentForm" disabled="true"></selectivity>
				            		</div>
				            		<div class="col-xs-12" ng-if="row.isInvoiceNo">
				            			<selectivity list="cbpdtlAcctHeadList" ng-model="row.cbpdtlAccountHead" 
				              		property="row.cbpdtlAccountHead"  id="account{{trIndex}}" name="{{ 'cbpdtlAccountHead' + $index }}"  
				              		validation="required" friendly-name="{{ 'Row ' + $index + ' (Account Name on Detail table)'}}" 
			           				form-name="cashBankPaymentForm" disabled="true"></selectivity>
				            		</div>
				              	
			        			</div>
			        		</div>
			        	</td>
			        	<!-- Sub Account Code -->
			        	<td class="padding-both-side-2">
			            	<div class="row">
			            		<div class="col-xs-12" ng-if="!row.isInvoiceNo">
			            				<selectivity list="subAccountCodeList1" ng-model="row.cbdtlsubAccountCode" 
				              		property="row.cbdtlsubAccountCode" id="subAccount{{trIndex}}" 
				              		name="{{ 'cbdtlsubAccountCode' + $index }}"  
				              		friendly-name="{{ 'Row ' + $index + ' ( Sub Account Code on Detail table)'}}" 
				              		form-name="cashBankPaymentForm" disabled="true"></selectivity>	
			              		</div>
			            	
			            	
			            		<div class="col-xs-12"  ng-if="row.isInvoiceNo">
				              		<selectivity list="subAccountCodeList1" ng-model="row.cbdtlsubAccountCode" 
				              		property="row.cbdtlsubAccountCode" id="subAccount{{trIndex}}" 
				              		name="{{ 'cbdtlsubAccountCode' + $index }}" 
				              		friendly-name="{{ 'Row ' + $index + ' ( Sub Account Code on Detail table)'}}" 
				              		form-name="cashBankPaymentForm" disabled="true"></selectivity>				              		
			        			</div>
			        			
			        		</div>
			        	</td>
			        	<!-- code changed for Auto suggestion text box -->
				   <!--      <td class="padding-both-side-2">
				        	<div class="row">
			            		<div class="col-xs-12">
				              		 <label class="btn text-center margin-auto" data-ng-click="showPaymentPriceDialog(cashbankpaymentForm,row.cbdtlsubAccountCode,trIndex)">
							           <i class="fa fa-expand"></i></label>							         	
							         <input type="text" class="form-control input-sm" 
		 								name="pmtOrderNo" ng-model="row.cbpdtlPmtOrderNo" />
				              		 <input type="text" class="form-control input-sm" 
		 								name="pmtOrderNo" ng-model="row.cbpdtlPmtOrderNo"
										id="pmtOrderNo" typeahead="ac.pmtOrderNo as ac.pmtOrderNo for ac in pmtOrderNoList| filter:$viewValue |limitTo:10"  
		 								typeahead-min-length='1'   typeahead-input-formatter="formatLabel($model,row)"/>
			        			</div>
			        		</div>
			        	</td> -->
			        	<!-- <td class="padding-both-side-2">
				        	<div class="row">
			            		<div class="col-xs-12">
			            			<input type="text" class="form-control input-sm" 
		 								name="Invoice No" ng-model="row.purInvoiceNo" ng-disabled="true" />
			            		</div>
			            	</div>
			            </td> -->
			          	<!-- <td class="width_10">
			          		<div class="row" >
			            		<div class="col-xs-12" ng-if="!row.isInvoiceNo">
			            			INR
			              		</div>
			              		<div class="col-xs-12" ng-if="row.isInvoiceNo">
			              			<input type="text" class="form-control input-sm" 
		 								name="Currency" ng-model="row.cbpdtlCurrencyCode" ng-disabled="true" />
			              		</div>
			              	</div>
			            </td> -->
			           <!--  <td>
			            	<div class="row">
				            	<div class="col-xs-12" ng-if="!row.isInvoiceNo">
				            	<input type="text" class="form-control input-sm" id="cbpdtlExgRate{{trIndex}}" name="cbpdtlExgRate" data-ng-model="row.cbpdtlExgRate" data-ng-change="onChangeNumber('cbpdtlExgRate'+trIndex,row.cbpdtlExgRate)" required />	
				            	</div>
			            		<div class="col-xs-12" ng-if="row.isInvoiceNo">
			         	  			<input type="text" class="form-control input-sm" id="cbpdtlExgRate{{trIndex}}" name="cbpdtlExgRate" data-ng-model="row.cbpdtlExgRate" data-ng-change="onChangeNumber('cbpdtlExgRate'+trIndex,row.cbpdtlExgRate)" ng-disabled="true" required />
			              		</div>
			              	</div>
			            </td> -->
			            <td>
				           	<div class="row">
				           		<div class="col-xs-12" ng-if="!row.isInvoiceNo">
				        	  		<input type="text"  class="form-control input-sm text-right " name="cbpDtlBcAmount" data-ng-model="row.cbpDtlBcAmount|number:2"
				        	  		ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="bcToTcAmountCalculation(row.cbpDtlBcAmount,trIndex,row)" disabled="true" required />
				             	</div>
				             	<div class="col-xs-12" ng-if="row.isInvoiceNo">
				             		<input type="text" class="form-control input-sm" name="cbpDtlBcAmount" data-ng-model="row.cbpDtlBcAmount"
				        	  		ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="bcToTcAmountCalculation(row.cbpDtlBcAmount,trIndex,row)" ng-disabled="true" required />
				             	</div>
				            </div>
			            </td>
			            <!-- <td>
				           	<div class="row">
				           		<div class="col-xs-12" ng-if="!row.isInvoiceNo">
				        	  		<input type="text" class="form-control input-sm" name="cbpDtlTcAmount" data-ng-model="row.cbpDtlTcAmount"
				        	  		ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="tcToBcAmountCalculation(row.cbpDtlTcAmount,trIndex,row)" required />
				             	</div>
				           		<div class="col-xs-12" ng-if="row.isInvoiceNo">
				        	  		<input type="text" class="form-control input-sm" name="cbpDtlTcAmount" data-ng-model="row.cbpDtlTcAmount"
				        	  		ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" ng-keyup="tcToBcAmountCalculation(row.cbpDtlTcAmount,trIndex,row)" ng-disabled="true" required />
				             	</div>
				            </div>
			            </td> -->
			            <td class="visible-left">
			            	<input type="hidden" ng-model="row.invoicePaymentList" />
			            </td>
			           </tr>
			           <tr>
			        	<td colspan="12">
				        	<div class="col-sm-12">							        	
								<div class="col-md-4" ng-if="row.isEmployee">
									<label class="col-md-3 control-label"> Employee</label>
									<div class="col-md-9">
								    	<selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isDepartment">
									<label class="col-md-3 control-label"> Dept</label>
									<div class="col-md-9">
								    	<selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isLocation">
									<label class="col-md-3 control-label"> Students</label>
									<div class="col-md-9">
								    	<selectivity list="studentList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isCustomer" style="padding-top: 10px;" >
									<label class="col-md-3 control-label"> Customer</label>
									<div class="col-md-9">
								    	<selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isSupplier"  style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Supplier</label>
									<div class="col-md-9">
								    	<selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isDesignation"  style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Designation</label>
									<div class="col-md-9">
								             <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
								     </div>
								</div>
								<div class="col-md-4" ng-if="row.isCostCenter "  style="padding-top: 10px;">
									<label class="col-md-3 control-label">  Fund Type</label>
									<div class="col-md-9">
										<selectivity list="costCenterList" ng-model="row.costCenter" property="row.costCenter" id="costCenterId{{trIndex}}"  disabled="true"  ></selectivity>
										
								    	
								    </div>
								</div>
								<div class="col-md-4">
									<label class="col-md-3 control-label"> Project</label>
									<div class="col-md-9">
								    	<selectivity list="budgetTypeList" property="row.budgetDefnId" id="budgetDefnId{{trIndex}}"   disabled="true"></selectivity>
								    </div>
								</div>
								<div class="col-md-4" ng-if="row.isCompany"  style="padding-top: 10px;">
									<label class="col-md-3 control-label"> Company Name</label>
									<div class="col-md-9">
								    	<selectivity list="companyList" ng-model="row.companyCode" property="row.companyCode" id="companyCode{{trIndex}}"></selectivity>
								    </div>
								</div>
								
																	
							</div>
					    </td> 		             	
			       </tr> 
		      	</tbody>
		      </table>
			   <!--   <div class="padding-right-5" id="AddOrRmvebtn">
			      
			      
			           <button ng-click="addCBPmtRow(cashbankpaymentModelData.cbptables)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
			            <i class="fa fa-plus"></i>
			           </button>
			           <button ng-click="removeCBPmtRow(cashbankpaymentModelData.cbptables)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
			            <i class="fa  fa-trash-o"></i>
			           </button>
			     </div> --> <!-- /padding-right-5 - /AddOrRmvebtn -->
			     <div class="row">
					<div class="col-sm-12">
						<div class="form-group pull-right">
					        <label class="col-md-3 control-label">Total Amount</label>
					        <div class="col-md-6">
					         	<input type="text" class="text-right form-control input-sm " name="totalBCAmount" data-ng-model="cbpmtDtlTotalAmt.totalBCAmount|number:2"
				         	  			ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
					        </div>
<!-- 					        <label class="col-md-3 control-label">Total TC Amt</label>
 -->					       <!--  <div class="col-md-3">
					         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="cbpmtDtlTotalAmt.totalTCAmount"
				         	  			 ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" step="0.01" disabled />
					        </div> -->
				       </div>
					</div>
				</div>
		 	</div>    <!-- /table-responsive -->
		 	<div class="form-actions">
		     	      
		      <!--     <button class="btn btn-success" type="button" ng-if="!edit" data-ng-click="validate(cashbankpaymentForm,cashbankpaymentModelData)" >
		           <i class="fa fa-save"></i>
		           Save
		          </button>
		          <button class="btn btn-success" type="button" ng-if="edit" data-ng-click="validate(cashbankpaymentForm,cashbankpaymentModelData)" >
		           <i class="fa fa-save"></i>
		           Update
		          </button> -->
		          <button class="btn btn-danger" data-ng-click="cancel()" type="button">
		           <i class="fa fa-close"></i>
		           Cancel
		          </button>
		     
		 	</div>
		</div><!-- /col-md-12 -->
		</div> <!-- /row -->
       
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
</div>