<style>
 table.dataTable thead .sorting:after { 
   content: ""; 
 } 
 select{ 
 -webkit-appearance: none; 
   padding: 0; 
  text-indent: 8px; 
   padding : 0 !important; 
 } 
 .input-group-addon{ 
 display:none !important; 
 }
 .form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control 


 { 
  background-color:white !important; 
  border:0px !important; 
 } 
 .b-grey{ 
 border:0px !important;
}
</style>

<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb inline-block padding-left-10">
    <li>
      <a>Finance</a>
    </li>
    <li>
      <a x-ui-sref="app.finance.transaction.creditnotehdr.list">Transactions</a>
    </li>
    <li>
     <a x-ui-sref="app.finance.transaction.creditnotehdr.list">Cash  Payment</a>
    </li>
    <li>
     <a x-ui-sref="#">View</a>
    </li>
   </ol>
  </div>
  <div class="panel-body">
   <form name="cashbankpaymentForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
     <div class="col-sm-12">
     <fieldset ng-disabled="viewDisable">
	     <div class="col-sm-4">
	     <!-- cashbankpaymentModelData.cbVoucherNo -->
	     	<div class="form-group" data-ng-if="isView">
		        <label class="col-md-5 control-label">Voucher No </label>
		        <div class="col-md-7">		          	
			          <input type="text" class="form-control input-sm" name="Voucher No" id="txtVoucherNo"
			          ng-model="cashbankpaymentModelData.cbVoucherNo"  />			          
			        
		        </div>
	     	</div>
	     	<div class="form-group">
		        <label class="col-md-5 control-label">Payment Date </label>
		        <div class="col-md-7">
		          	<div class="input-group input-append date" id="cashbankPmt_Date">
			          <input type="text" class="form-control input-sm" name="PaymentDate" id="txtCashbankPmtDate"
			          ng-model="cashbankpaymentModelData.cashbankPmtDate"  />
			          <span class="input-group-addon add-on">
			           <span class="glyphicon glyphicon-calendar"></span>
			          </span>
			        </div>
		        </div>
	     	</div>
	     	<div class="form-group ">
		        <label class="col-md-5 control-label">Company </label>
		        <div class="col-md-7">
		            <input type="text" class="form-control input-sm" name="cmbCompanyName" id="cmbCompanyName"
			          ng-model="cashbankpaymentModelData.companyName"  />
		        </div>
	       	</div>
	      <!-- 	<div class="form-group">
		        <label class="col-md-5 control-label">Payment Type </label>
		        <div class="col-md-7 ">
			        <input type="text" class="form-control input-sm" ng-model="cashbankpaymentModelData.pmtType"
			         id="pmtType" >
		        </div>
	       	</div> -->
	        	<!-- <div class="form-group" id="bankaccountgroup" ng-if="cashbankpaymentModelData.pmtType=='bank'"> 
		        <label class="col-md-5 control-label">Bank Acct </label>
		        <div class="col-md-7">
			        <input class="form-control input-sm" ng-model="cashbankpaymentModelData.accountName"
			         id="accountbankName" ng-options="bankAcc.id as bankAcc.text for bankAcc in bankAccountList"></input>
		        </div>
	     	</div> --> 
	     	 <div class="form-group" id="cashaccountgroup" ng-if="cashbankpaymentModelData.pmtType=='cash'"> 
		        <label class="col-md-5 control-label">Cash Acct </label>
		        <div class="col-md-7">
			        <input class="form-control input-sm" ng-model="cashbankpaymentModelData.accountName"
			         id="account Name" ng-options="cashAcc.id as cashAcc.text for cashAcc in cashAccountList"></input>
		        </div>
	     </div>
	    </div>
	    
	    <div class="col-sm-4">

	     	<div class="form-group">
		        <label class="col-md-5 control-label">Currency </label>
		        <div class="col-md-7">
		        	<input type="text" class="form-control input-sm" id="currencyCode" name="currencyCode"
		        	ng-model="cashbankpaymentModelData.acctCurrency"   />
		        </div>
	       	</div>
	       	<div class="form-group">
		        <label class="col-md-5 control-label">Exchange Rate </label>
		        <div class="col-md-7">
		         	<input type="text" class="form-control input-sm" id="exgRate" name="exgRate"
		         	ng-model="cashbankpaymentModelData.exchangeRate"  />
		        </div>
	       	</div>
	     	<div class="form-group" >
		        <label class="col-md-5 control-label">Paid To</label>
		        <div class="col-md-7">
		        	<input type="text" class="form-control input-sm" id="paidTo" name="paidTo"
		        	ng-model="cashbankpaymentModelData.paidTo"   />
		        </div>
	       	</div>

			 <div class="form-group">
		        <label class="col-md-5 control-label">TC Amount </label>
		        <div class="col-md-7">
		         	<input type="text" class="form-control input-sm" id="tcAmount" name="tcAmount" data-ng-model="cashbankpaymentModelData.tcAmountHdr1" 
		         	  />
		        </div>
		    </div>
		    
	    </div>
	    <div class="col-sm-4">
	    	<div class="form-group"  ng-if="pmtTypeGroup.show">
		        <label class="col-md-5 control-label">Cheque No</label>
		        <div class="col-md-7">
		        	<input type="text" class="form-control input-sm" id="chequeNo" name="chequeNo"
		        	ng-model="cashbankpaymentModelData.chequeNo" />
		        </div>
	       	</div>
	       	<div class="form-group"  ng-show="pmtTypeGroup.show">
		        <label class="col-md-5 control-label">Cheque Date</label>
		        <div class="col-md-7">
		       		 <div class="input-group input-append date" id="cheque_Date">
			          <input type="text" class="form-control input-sm" name="ReceiptDate" id="txtChequeDate"
			          ng-model="cashbankpaymentModelData.chequeDate" placeholder='dd/mm/yyyy' />
<!-- 			          <span class="input-group-addon add-on"> -->
<!-- 			           <span class="glyphicon glyphicon-calendar"></span> -->
<!-- 			          </span> -->
			        </div>
		        </div>
	     	</div>
	     	
	     	<div class="form-group" >
		        <label class="col-md-5 control-label">Narration </label>
		        <div class="col-md-7">
		        	<input type="text" cols="5" rows="2" class="form-control input-sm" id="narration" name="narration"
		        	ng-model="cashbankpaymentModelData.narration"  ></input>
		        </div>
	       	</div>
	       	
		   <div class="form-group">
		        <label class="col-md-5 control-label">BC Amount({{companyCurrency}}) </label>
		        <div class="col-md-7">
		        	<input type="text" class="form-control input-sm" id="bcAmount" name="bcAmount"
		        	data-ng-model="cashbankpaymentModelData.bcAmountHdr1" />
		        </div>
	       	</div>
		    
	    </div>
	    </fieldset>
	    
	    <div class="col-sm-4">
	    
	     <div class="form-group" ng-if="isDownload">
						        <label class="col-md-5 control-label bold">Attached Files</label>
						        <div class="col-md-7">
                                                          
                                                          
                                     <span class="btn btn-primary" 
										ng-click="downloadFiles(cashbankpaymentModelData.cbVoucherNo)" >
										Downlod
									</span>

									<a id="downLoad" href="" download></a>
									
									
									
		        				 </div>
					       </div>
					       </div>
	    
    </div>
   </div>
    <div class="table-responsive clear">
      <table class="table table-striped b-t b-light">
        <thead>
          <tr>
            <!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
              <th colspan=1 class="width_13 text-center">Company</th> 
            <th colspan=1 class="width_13 text-center">Account Name</th>
            <th colspan=1 class="width_10 text-center">Sub Account Code</th>
            <th colspan=1 class="width_10 text-center">Short Detail</th>
            <th colspan=1 class="width_8 text-center">Currency</th>
            <th colspan=1 class="width_13 text-center">Exchange Rate</th>
            <th colspan=1 class="width_8 text-center">TC Amt</th>
            <th colspan=1 class=" width_8 text-center">BC Amt({{companyCurrency}})</th>
            <th colspan=1 class="width_1"></th>
          </tr>
        </thead>
        <!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->
        <tbody ng-repeat="(trIndex, row) in cashbankpaymentModelData.cbptables">
        
        	<tr>
        	<td class="padding-both-side-2">
	            	<div class="row">
	            		<div class="col-xs-12">
							<input type="text" class="form-control input-sm" ng-model="row.companyName" id="company{{trIndex}}" ng-disabled="viewDisable"
							name="CompanyName{{trIndex}}" 
							>
							<!-- <input type="text" class="form-control input-sm" data-ng-model="row.accountHeadName" ng-disabled="true" /> -->
	        			</div>
	        		</div>
	        	</td>
	            <td class="padding-both-side-2">
	            	<div class="row">
	            		<div class="col-xs-12">
							<input type="text" class="form-control input-sm" ng-model="row.accountHeadName" id="account{{trIndex}}" ng-disabled="viewDisable"
							name="AccountName{{trIndex}}" 
							>
							<!-- <input type="text" class="form-control input-sm" data-ng-model="row.accountHeadName" ng-disabled="true" /> -->
	        			</div>
	        		</div>
	        	</td>
	        	<!-- Sub Account Code -->
	        	<td class="padding-both-side-2">
	            	<div class="row">
	            		<div class="col-xs-12">
		              		<input type="text" class="form-control input-sm" ng-model="row.subAccountName" id="subAccount{{trIndex}}"
							ng-disabled="viewDisable">
							<!-- <input type="text" class="form-control input-sm" data-ng-model="row.subAccountName" ng-disabled="true" /> -->
	        			</div>
	        		</div>
	        	</td>
	        	<!-- code changed for Auto suggestion text box -->
		        <td class="padding-both-side-2">
		        	<div class="row">
	            		<div class="col-xs-12">
		              		 <input type="text" class="form-control input-sm" 
 								name="pmtOrderNo" ng-model="row.cbpdtlPmtOrderNo"
 								 name="shortDetail{{trIndex}}"
								 ng-disabled="viewDisable"/>
	        			</div>
	        		</div>
	        	</td>
	          	<td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	            			<input type="text" class="form-control input-sm" id="cbpdtlCurrencyCode{{trIndex}}"
	            			ng-model="row.cbpdtlCurrencyCode"   name="currency{{trIndex}}"
							 ng-disabled="viewDisable"></selectivity>
	              		</div>
	              	</div>
	            </td>
	            <td>
	            	<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm" id="cbpdtlExgRate{{trIndex}}" 
	         	  			data-ng-model="row.cbpdtlExgRate" name="cbpdtlExgRate{{trIndex}}"
							 ng-disabled="viewDisable"/>
	              		</div>
	              	</div>
	            </td>
	            
	             <td>
		           	<div class="row">
		           		<div class="col-xs-12">
		        	  		<input type="text" class="form-control input-sm" name="cbpDtlTcAmount" data-ng-model="row.cbpDtlTcAmount1"
		        	  		
							  name="cbpDtlTcAmount{{trIndex}}"
							ng-disabled="viewDisable"/>
		             	</div>
		            </div>
	            </td>
	            
	            <td>
		           	<div class="row">
		           		<div class="col-xs-12">
		        	  		<input type="text" class="form-control input-sm" name="cbpDtlBcAmount" data-ng-model="row.cbpDtlBcAmount1"
		        	  		 
							 name="cbpDtlBcAmount{{trIndex}}"
							 ng-disabled="viewDisable"/>
		             	</div>
		            </div>
	            </td>
	           
	           </tr>
	           <tr>
		        	<td colspan="12">
			        	<div class="col-sm-12">
			        	<fieldset ng-disabled="viewDisable">
			        	<!-- Attributes list -->
			        	<!-- <div class="col-sm-3" >
			        	<label class="col-md-5 control-label"> Attriutes </label>
			        	</div> -->
			        	<div class="col-sm-2 padding-top-5" ng-if="row.isVessel && row.isVesselMan">
							<label class="col-md-5 control-label"> Vessel
								
							</label>
							<div class="col-md-7">
						         <!--   <select class="form-control input-sm" id="vesselName{{trIndex}}" ng-model="row.vesselCode" ng-options="ves.id as ves.text for ves in vesselList">
								   </select> -->
								
										
<!-- 										<input type="text" class="form-control input-sm" name="vesselCode" ng-model="row.vesselCode" id="vesselCode{{trIndex}}" required readonly/>
 -->										<label ng-bind="row.vesselCode"></label>
										<!-- <select  list ="vesselList" ng-model="row.vesselCode" ng-options="vessel.vesselCode as vessel.vesselCode for vessel in vesselList" id="vesselCode{{trIndex}}" disabled>
				            		  	<option value="">select</option>
				            			</select> -->
									
						     </div>
						</div>
			        	<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && row.isVoyageMan">
							<label class="col-md-5 control-label"> Voyage
								
							</label>
							
						              <!-- <select class="form-control input-sm" id="voyageName{{trIndex}}" ng-model="row.voyageCode" ng-options="voy.id as voy.text for voy in voyageList">
								 		</select> -->
								 		<div class="col-md-7">
										
										<!-- <input type="text" class="form-control input-sm" name="voyageCode" ng-model="row.voyageCode" id="voyageCode{{trIndex}}" required readonly/> -->
										<label ng-bind="row.voyageCode"></label>
									<!-- <select  list ="voyageList" ng-model="row.voyageCode" ng-options="voyage.voyageCode as voyage.voyageCode for voyage in voyageList" id="voyageCode{{trIndex}}" disabled>
				            		  <option value="">select</option>
				            			</select> -->
									 </div>
								
							
						     </div>
						
			        	
						<div class="col-sm-2 padding-top-5" ng-if="row.isService && row.isServiceMan" >
							<label class="col-md-5 control-label"> Service
								
							</label>
							<div class="col-md-7">
						             <!-- <select class="form-control input-sm" id="sectorCode{{trIndex}}" ng-model="row.sectorCode" ng-options="sec.id as sec.text for sec in sectorList">
								 	 </select> -->
								 	  <label ng-bind="row.sectorCode"></label>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee && row.isEmployeeMan" >
							<label class="col-md-5 control-label"> Employee
								
							</label>
							<div class="col-md-7">
						         <!--   <select class="form-control input-sm" id="employeeCode{{trIndex}}" ng-model="row.employeeCode" ng-options="emp.id as emp.text for emp in employeeList">
								   </select> -->
								   <label ng-bind="row.employeeCode"></label>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isPort && row.isPortMan">
							<label class="col-md-5 control-label"> Port
								
							</label>
							<div class="col-md-7">
						           <!-- <select class="form-control input-sm" id="portCode{{trIndex}}" ng-model="row.portCode" ng-options="port.id as port.text for port in portList">
								   </select> --> <label ng-bind="row.portCode"></label>
						     </div>
						</div>
						<!-- 
						<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
							<label class="col-md-5 control-label"> Port.Seq
								
							</label>
							<div class="col-md-7">
						          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
						     </div>
						</div> -->
						
						<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment && row.isDepartmentMan">
							<label class="col-md-5 control-label"> Department
								
							</label>
							 <div class="col-md-7">
						          <!--  <select class="form-control input-sm" id="departmentCode{{trIndex}}" ng-model="row.departmentCode" ng-options="dep.id as dep.text for dep in departmentList">
								   </select> -->
								   								   <label ng-bind="row.departmentCode"></label>
								   
						     </div>
						     
						</div>
						
						<div class="col-sm-2 padding-top-5" ng-if="row.isAgent && row.isAgentMan">
							<label class="col-md-5 control-label"> Agent
								
							</label>
							<div class="col-md-7">
						          <!--  <select class="form-control input-sm" id="agentCode{{trIndex}}" ng-model="row.agentCode" ng-options="agent.id as agent.text for agent in agentList">
								   </select> -->
								   <label ng-bind="row.agentCode"></label>
						     </div>
						</div>
						
						<!-- <div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label"> Location
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="countryCode{{trIndex}}" ng-model="row.countryCode" ng-options="country.id as country.text for country in countryList">
								 	 </select>
						     </div>
						</div> -->
						<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer && row.isCustomerMan">
							<label class="col-md-5 control-label"> Customer
								
							</label>
							<div class="col-md-7">
						            <!--  <select class="form-control input-sm" id="customerCode{{trIndex}}" ng-model="row.customerCode" ng-options="cus.id as cus.text for cus in customerList">
								 	 </select> -->
								 	   <label ng-bind="row.customerCode"></label>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier && row.isSupplierMan">
							<label class="col-md-5 control-label"> Supplier
								
							</label>
							<div class="col-md-7">
						             <!-- <select class="form-control input-sm" id="supplierCode{{trIndex}}" ng-model="row.supplierCode" ng-options="sup.id as sup.text for sup in supplierList">
								 	 </select> -->
								 	   <label ng-bind="row.supplierCode"></label>
						     </div>
						</div>
						<!-- <div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label"> Designation
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="designationCode{{trIndex}}" ng-model="row.designationCode" ng-options="desig.id as desig.text for desig in designationList">
								 	 </select>
								 	  <label ng-bind="row.designationCode"></label>
						     </div>
						</div> -->
						<!-- <div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label"> CostCtr
								
							</label>
							<div class="col-md-7">
						             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/>
						     </div>
						</div> -->
						<!-- <div class="col-sm-2 padding-top-5" ng-if="row.isCompany && row.isCompanyMan" >
							<label class="col-md-5 control-label"> Company
								
							</label>
							<div class="col-md-7">
						             <select class="form-control input-sm" id="companyName{{trIndex}}" ng-model="row.companyName" ng-options="company.id as company.text for company in companyList">
								 	 </select>
								 	  <label ng-bind="row.companyCode"></label>
						     </div>
						</div> -->
						<!-- <div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label">Qty(MT)GO</label>
							<div class="col-md-7">
						             <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO"/>
						     </div>
						</div>
						<div class="col-sm-2 padding-top-5" >
							<label class="col-md-5 control-label">Qty(MT)FO</label>
							<div class="col-md-7">
						             <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO"/>
						     </div>
						</div> -->
						</fieldset>
						</div>
				    </td>  		             	
		       </tr>
      	</tbody>
      </table>
      <div class="row">
		<div class="col-sm-12">
		<fieldset ng-disabled="viewDisable">
			<div class="form-group pull-right">
		       
		        <label class="col-md-3 control-label">Total TC Amt</label>
		        <div class="col-md-3">
		         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="cashbankpaymentModelData.tcAmountHdr1"
	         	  			 step="0.01" disabled />
		        </div>
		        
		         <label class="col-md-3 control-label">Total BC Amt</label>
		        <div class="col-md-3">
		         	<input type="text" class="form-control input-sm" name="totalBCAmount" data-ng-model="cashbankpaymentModelData.bcAmountHdr1"
	         	  			 step="0.01" disabled />
		        </div>
	       </div>
	       </fieldset>
		</div>
	</div>
	 <div class="row">
	     <div class="col-sm-12 col-md-12 col-lg-12">
	      <div class="content">
	      	<div class="form-actions">
	        <div class="row">
	         <div class="col-md-12">
	          <button class="btn btn-danger" ng-if="paymentTable==false" ng-click="cancel()" type="button">
	           <i class="fa fa-close"></i>
	           Cancel
	          </button>
	           <button class="btn btn-success" ng-if="paymentTable==false" ng-click="printPaymentVoucherDiv(cashbankpaymentModelData.cbVoucherNo)"  type="button">
	        	  Print
	          </button>
	          <button class="btn btn-danger" ng-if="paymentTable==true" ng-click="cancel1()" type="button">
	           <i class="fa fa-close"></i>
	           Cancel
	          </button>
	         </div>
	        </div>
	       </div>
	      </div>
	     </div>
	    </div>
      
	</div>    <!-- /table-responsive -->
	 
   </form>
  </div>
 </div>
</div>