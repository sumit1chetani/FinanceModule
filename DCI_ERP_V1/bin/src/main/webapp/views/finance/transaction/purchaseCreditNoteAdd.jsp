<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<div class="wrapper-md">
 			<div class="panel panel-default panel-default-form">
  				<%@include file="/views/templates/panel-header-form.jsp"%>
<input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body">
   <form name="purchaseCreditNoteForm" class="form-horizontal" novalidate>
    <div class="row book-widget-row">
     <div class="col-sm-12">
	     <div class="col-sm-4">
	          	<input type="hidden"  id="creditNoteCode">
	          	
	       	<div class="form-group">
				<label class="col-md-5 control-label"> Company
					<span style="color: red;">*</span>
				</label>
				<div class="col-md-7">
					<selectivity ng-if="edit" disabled="edit" list="companyList" ng-model="creditnoteAcctData.companyCode" property="creditnoteAcctData.companyCode" 
					id="company_id" object="company" name="company_id"
					validation="required" friendly-name="Company" form-name = "purchaseCreditNoteForm"></selectivity>
				</div>
				<div class="col-md-7">
					<selectivity ng-if="!edit" list="companyList" ng-model="creditnoteAcctData.companyCode" property="creditnoteAcctData.companyCode" 
					id="company_id" object="company" name="company_id"
					validation="required" friendly-name="Company" form-name = "purchaseCreditNoteForm"></selectivity>
				</div>
			</div>
	     	
	      	<div class="form-group">
		        <label class="col-md-5 control-label">Invoice Number</label>
		        <div class="col-md-7 ">
		         	 <!--  <selectivity list="invoiceNoList" property="creditnoteAcctData.invoiceNo" ng-model="creditnoteAcctData.invoiceNo" id="invoiceNo" name ="invoiceNo"
		         	object="invoices" validation="required" friendly-name="Invoice" form-name = "purchaseCreditNoteForm"></selectivity>  -->
		         	  <selectivity list="invoiceNoList" property="creditnoteAcctData.invoiceNo" id="invoiceNo" object="invoiceNo" name="invoiceNo"
			        ng-model="creditnoteAcctData.invoiceNo" ></selectivity> 
		         <!-- 	<input type="text" class="form-control input-sm" id=Invoice name="Invoice"
		        	ng-model="creditnoteAcctData.invoiceNo"  validation="required" friendly-name="Invoice Number" /> -->
		        </div>
	       	</div>
	       	
	     	<div class="form-group ">
		        <label class="col-md-5 control-label">Currency<span style="color:red;">*</span></label>
		        <div class="col-md-7" >
		        	<!-- <input type="text" class="form-control input-sm" id="currencyCode" name="currencyCode"
		        	ng-model="creditnoteAcctData.currencyCode"   friendly-name="Currency "
		        	ng-if = "companyCode != 'C0002'"    /> -->
		        	 <!-- <selectivity list="currencyList" property="row.currency" id="currency{{trIndex}}" object="currency" 
								            	  name="currency{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" 
								            	  ng-model="row.currency" property="row.currency" form-name="purchaseInvoiceForm"
												  disabled="row.isCurrencyBlocked"></selectivity> -->
		        	  <selectivity list="currencyList" property="creditnoteAcctData.currencyCode" name="Currency"  
					id="currency" object="currency"  friendly-name="Currency" form-name = "purchaseCreditNoteForm"
					ng-model="creditnoteAcctData.currencyCode" ></selectivity>
		        </div>
	       	</div>  
	       	
	        	<!-- <div class="form-group">
										<label class="col-md-5 control-label"> Currency
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<selectivity list="currencyList" property="creditnoteAcctData.currencyCode" name="Currency"  
											id="currency"  validation="required" friendly-name="Currency" form-name = "purchaseCreditNoteForm"
											ng-model="creditnoteAcctData.currencyCode" disabled></selectivity>
											</div>
									</div>  -->
									
		<!-- 		<div class="form-group">
										<label class="col-md-5 control-label"> Currency
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7" ng-if="isCurrencyBlocked">
											<input type="text" class="form-control input-sm" readonly ng-model="purchaseInvoiceData.currency"
												name="Currency" validation="required" friendly-name="Currency">
											<selectivity list="currencyList" property="creditnoteAcctData.currencyCode" name="Currency"  
											id="currency" object="currency" validation="required" friendly-name="Currency" form-name = "purchaseCreditNoteForm"
											ng-model="creditnoteAcctData.currencyCode" disabled="isCurrencyBlocked" disabled></selectivity>
										</div>
										<div class="col-md-7" ng-if="!isCurrencyBlocked">
											<selectivity list="currencyList" property="creditnoteAcctData.currencyCode" name="Currency"  
											id="currency" object="currency" validation="required" friendly-name="Currency" form-name = "purchaseCreditNoteForm"
											ng-model="creditnoteAcctData.currencyCode" disabled></selectivity>
										</div>
									</div>	 -->				
	       	
	        <!-- <div class="form-group ">
		        <label class="col-md-5 control-label">Voyage </label>
		        <div class="col-md-7">
			          <selectivity list="voyageListt" property="creditnoteAcctData.voyageId" id="voyageId" object="voyageId" name="voyageId"
			        ng-model="creditnoteAcctData.voyageId" ></selectivity>
		        </div>
	       	</div> -->
	       	
	       	   	
	       	
	    </div>
	    <div class="col-sm-4">
	    		<div class="form-group">
		        <label class="col-md-5 control-label">Credit Note Date<span style="color:red;"> *</span></label>
		        <div class="col-md-7">
		        <ng-bs3-datepicker data-ng-model="creditnoteAcctData.creditNoteDate" id="creditNoteDate" name="creditNoteDate" form-name="purchaseCreditNoteForm"
       data-ng-change="checkDatesCL(creditnoteAcctData.creditNoteDate)" 
        friendly-name="creditNote Date" validation="required"/>
<!-- 					<div class="input-group input-append date" id="cn_date" > -->
<!-- 						<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy" validation="required" friendly-name="Credit Note Date"  -->
<!-- 								ng-model="creditnoteAcctData.creditNoteDate" name="Date" id="creditNoteDate"> -->
<!--  									 <span class="input-group-addon add-on"> -->
<!--                   								<span class="glyphicon glyphicon-calendar"></span> -->
<!--        								 </span> -->
<!-- 				     </div> -->
				</div>
	     	</div>
	     	
	    	<div class="form-group">
		        <label class="col-md-5 control-label">Invoice Date</label>
		        <div class="col-md-7">
		        	<div class="input-group input-append date" id="inv_date" >
						<input type="text" class="form-control input-sm" placeholder="dd/mm/yyyy"  
								ng-model="creditnoteAcctData.invoiceDate" name="Date" id="invoiceDate">
 									 <span class="input-group-addon add-on">
                  								<span class="glyphicon glyphicon-calendar"></span>
       								 </span>
				     </div>
		         <!--  <input type="text" class="form-control input-sm" id="invoiceDate" name="invoiceDate" validation="required" friendly-name="Invoice Date"
		          ng-model="creditnoteAcctData.invoiceDate" ng-disabled="true" /> -->
		        </div>
	     	</div>
	     	
	       <!-- 	<div class="form-group">
		        <label class="col-md-5 control-label">Exchange Rate<span style="color:red;"> *</span></label>
		        <div class="col-md-7">
		         	<input type="text" class="form-control input-sm text-right" id="exgRate" name="exgRate" validation="required" friendly-name="Exchange Rate"
		          ng-keyup="calcbcamount(creditnoteAcctData.exchangeRate)" 	ng-model="creditnoteAcctData.exchangeRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"/>
		        </div>
	       </div> -->
	       
	       	<div class="form-group">
											<label class="col-md-5 control-label"> Exchange Rate
												<span style="color: red;">*</span>
											</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm text-right"  ng-model="creditnoteAcctData.exchangeRate" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
													name="Exchange Rate" validation="required" friendly-name="Exchange Rate" ng-blur="exchageratehdr(creditnoteAcctData.exchangeRate)">
											</div>
									</div>
									<div class="form-group">
					<label class="col-md-5 control-label"> TC Amount
						<span style="color: red;">*</span>
					</label>
					<div class="col-md-7">
						<input type="text" class="form-control input-sm text-right" ng-model="creditnoteAcctData.tcAmount"
							name="TC Amount" ng-keyup="amountLocalCalculation(creditnoteAcctData.tcAmount)"
							validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"  step="0.001" friendly-name="TC Amount" >
					</div>
				</div>
									
			   
	    
	       
	    </div>
	    <div class="col-sm-4">
	    	<div class="form-group ">
		        <label class="col-md-5 control-label">Supplier	<span style="color:red;"> *</span></label>
		        <div class="col-md-7">
			        <selectivity list="supplierList" property="creditnoteAcctData.accountName" id="cmbAccountName" object="accounts" name="accounts"
			        ng-model="creditnoteAcctData.accountName" validation="required" friendly-name="Customer" form-name = "purchaseCreditNoteForm"></selectivity>
		        </div>
	       	</div>
	       	
	       <div class="form-group">
		        <label class="col-md-5 control-label">Narration <span style="color:red;"> *</span></label>
		        <div class="col-md-7">
		         	<input type="text" class="form-control input-sm" id="narration" name="narration" data-ng-model="creditnoteAcctData.narration" 
		         	validation="required" friendly-name="Narration" />
		        </div>
	       </div>
	       
	       <!--  <div class="form-group">
		        <label class="col-md-5 control-label">Credit Note Number  <span style="color:red;"> *</span></label>
		        <div class="col-md-7">
		         	<input type="text" class="form-control input-sm" id="creditNoteNo" name="creditNoteNo" data-ng-model="creditnoteAcctData.creditNoteNo" 
		         	validation="required" friendly-name="Credit Note Number" />
		        </div>
	       </div> -->
	       <div class="form-group">
										<label class="col-md-5 control-label"> BC Amount
											<span style="color: red;">*</span>
										</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm text-right" ng-model="creditnoteAcctData.bcAmount"
												name="Amount" ng-blur="amountCalculation(creditnoteAcctData.bcAmount)" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"  step="0.001" friendly-name="BC Amount" >
										</div>
									</div>						
	       
	       
	    
									
	    </div>
    </div>
   </div>
    <div class="table-responsive clear">
      <table class="table table-striped b-t b-light">
        <thead>
          <tr>
            <th colspan=1 class="width_1"></th>
             <th colspan=1 class="width_13 text-center">Company<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_13 text-zcenter">Account Head<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_10 text-center">Sub Account</th>
            <th colspan=1 class="width_10 text-center">Narration<span style="color:red;"> *</span></th>
             <th colspan=1 class=" width_8 text-center">Currency<span style="color: red;">*</span></th>
			  <th colspan=1 class=" width_8 text-center">Ex-Rate<span style="color: red;">*</span></th>
            <th colspan=1 class="width_10 text-center">TC Amount<span style="color:red;"> *</span></th>
            <th colspan=1 class=" width_10 text-center">BC Amount<span style="color:red;"> *</span></th>
            <th colspan=1 class="width_1"></th>
          </tr>
        </thead>
        <tbody ng-repeat="(trIndex, row) in creditnoteAcctData.credittables" ng-controller="tableCtrl">
        	<tr>
	            <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
	               <td class="width_10">
		           	<div class="row">
	            <div class="col-xs-25">
					<selectivity ng-if="edit" disabled="edit" list="companyDtlList"  property="row.company_id_dtl" 
					id="company_id_dtl"  ng-model="row.company_id_dtl"	name ="company_id_dtl{{trIndex}}" validation="required" friendly-name=" dtl Company" form-name = "purchaseCreditNoteForm"></selectivity>
				</div>
				<div class="col-xs-25">
					<selectivity ng-if="!edit" list="companyDtlList"   property="row.company_id_dtl" 
					id="company_id_dtl"  ng-model="row.company_id_dtl"  name ="company_id_dtl{{trIndex}}"
					validation="required" friendly-name="dtl Company" form-name = "purchaseCreditNoteForm"></selectivity>
				</div>
				</div>
				</td>
	            <td>
	            	<div class="row">
	            		<div class="col-xs-20">
		              		<selectivity list="crdtlAcctHeadList" property="row.crdtlAccountHead" id="accountHeadCode{{trIndex}}" object="accHead"
		              		ng-model="row.crdtlAccountHead" name ="accountHeadCode{{trIndex}}" validation="required"
										friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "purchaseCreditNoteForm"></selectivity>
	        			</div>
	        		</div>
	        	</td>
	        	<td>
					<div class="row" ng-if = "!row.isSubAccountCode">
	            		<div class="col-xs-12">
	            		<selectivity list="row.subAccountCodeList" property="row.subAcctCode" id="subAcctCode{{$index}}" disabled = "!row.isSubAccountCode"></selectivity>
	            		</div>
	        		</div>
	        		<div class="row" ng-if = "row.isSubAccountCode">
	            		<div class="col-xs-12">
	            		<selectivity list="row.subAccountCodeList" property="row.subAcctCode" id="subAcctCode{{$index}}" name = "subAcctCode{{$index}}" ng-model="row.subAcctCode" validation="required"
										friendly-name="{{ 'Row' + $index + '(Sub Account Code)'}}" form-name = "purchaseCreditNoteForm"></selectivity>
	            		</div>
	        		</div>
           		</td>
	          	<td class="width_10">
	          		<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm" name="narration" data-ng-model="row.narration" 
	         	  			name ="narration{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Narration)'}}" />
	              		</div>
	              	</div>
	            </td>
	            
	              <td>
							         	<div class="row">
								            <div class="col-xs-25" ng-if="row.isCurrencyBlocked">
								            	  <selectivity list="currencyList" property="row.currency" id="currency{{trIndex}}" object="currency" 
								            	  name="currency{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" 
								            	  ng-model="row.currency" property="row.currency" form-name="purchaseInvoiceForm"
												  disabled="row.isCurrencyBlocked"></selectivity>
						           			</div>
						           			<div class="col-xs-25" ng-if="!row.isCurrencyBlocked">
								            	  <selectivity list="currencyList" property="row.currency" id="currency{{trIndex}}" object="currency" 
								            	  name="currency{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" 
								            	  ng-model="row.currency" property="row.currency" form-name="purchaseInvoiceForm"></selectivity>
						           			</div>
						           		
								        </div>
							        </td>
							        
							        <td> <div class="row">
								            <div class="col-xs-12">
									             <input type="text" class="form-control input-sm text-right" id="exchangeRate{{trIndex}}" ng-model="row.exchangeRate"  
									              ng-blur="amountCalculationexchange(row.exchangeRate,trIndex,row)" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"
									             name="exchangeRate{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Exchange rate)'}}">
									             
									              <input type="hidden" class="form-control input-sm text-right" id="txtFromCurrency{{trIndex}}" ng-model="row.fromCurrency"  
								           		 name="From Currency{{trIndex}}" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" readonly />
								           		 <input type="hidden" class="form-control input-sm text-right" id="txtToCurrency{{trIndex}}" ng-model="row.toCurrency"  
								           		 name="To Currency{{trIndex}}" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" readonly />
									        </div>
								        </div>
							        </td>
	         
	         <td> <div class="row">
								            <div class="col-xs-12">
									             <input type="text" class="form-control input-sm text-right" id="tcAmount{{trIndex}}" ng-model="row.tcAmount"  name="tcAmount{{trIndex}}"
									             ng-keyup="amountCalculationTCTable(row.tcAmount,trIndex,row)"
									             validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"  step="0.001" friendly-name="{{ 'Row' + $index + '(TC Amount)'}}">
									        </div>
								        </div>
							        </td>
							        <td> <div class="row">
							            	<div class="col-xs-12">
								             <input type="text" class="form-control input-sm text-right"  id="bcAmount{{trIndex}}" ng-model="row.bcAmount" name="bcAmount{{trIndex}}"
								              ng-blur="amountCalculationBCTable(row.bcAmount,trIndex,row)"
								              validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"  step="0.001" friendly-name="{{ 'Row' + $index + '(BC Amount)'}}">
								      		</div>
								        </div>
							        </td>
	         
	          <!--   <td>
		           	<div class="row">
		           		<div class="col-xs-12">
		        	  	<input type="text" class="form-control input-sm text-right" name="tcamount" data-ng-model="row.tcamount" 
		        	  	ng-keyup="bcamountCalculation(row.tcamount,trIndex,row)"
						name ="tcAmount{{trIndex}}"   friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" ng-pattern-restrict="^\d+(?:\.\d{0,2})?$" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Amount Should be 2 digit|required"  step="0.01" />
		             	</div>
		            </div>
	            </td>
	            <td>
	            	<div class="row" >
	            		<div class="col-xs-12">
	         	  			<input type="text" class="form-control input-sm text-right" data-ng-model="row.bcamount"
	         	  			 ng-keyup="tcamountCalculation(row.bcamount,trIndex,row)" 
							name ="bcamount{{trIndex}}" friendly-name="{{ 'Row' + $index + '(BC Amount)'}}"  ng-pattern-restrict="^\d+(?:\.\d{0,2})?$" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Amount Should be 2 digit|required"  step="0.01" />
	              		</div>
	              	</div>
	            </td> -->
	            
     		</tr>     		
     		 <tr>
	        	<td colspan="12">
		        	<div class="col-sm-12">
		        	 
											 <div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && !row.isVoyageMan">
											<label class="col-md-4 control-label"> Trip

											</label>
											<div class="col-md-8">
										              <selectivity list="voyageList"
															property="row.voyageCode"
															id="voyageCode{{trIndex}}"
															ng-model="row.voyageCode" 
															name="voyageCode{{trIndex}}"
															
															>
														</selectivity>
										     </div>
										     
										    
										</div> 
										<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && row.isVoyageMan">
											<label class="col-md-4 control-label"> Trip

											</label>
											<div class="col-md-8">
										              <selectivity list="voyageList"
															property="row.voyageCode"
															id="voyageCode{{trIndex}}"
															ng-model="row.voyageCode" validation="required"
															name="voyageCode{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
															form-name="purchaseCreditNoteForm"
															
															>
														</selectivity>
										     </div>
										     
										    
										</div> 
							
										<div class="col-sm-2 padding-top-5" ng-if="row.isVessel && !row.isVesselMan">
											<label class="col-md-5 control-label"> Truck

											</label>
											<div class="col-md-7">
										          <selectivity list="vesselList"
															property="row.vesselCode"
															id="vesselCode{{trIndex}}"
															ng-model="row.vesselCode" 
															name="vesselCode{{trIndex}}"
															
															>
														</selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label"> Truck

											</label>
											<div class="col-md-7">
										          <selectivity list="vesselList"
															property="row.vesselCode"
															id="vesselCode{{trIndex}}"
															ng-model="row.vesselCode" validation="required"
															name="vesselCode{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
															form-name="purchaseCreditNoteForm"
															
															>
														</selectivity>
										     </div>
										</div>
							<!-- 			<div class="col-sm-2 padding-top-5" ng-if="row.isService && !row.isServiceMan">
											<label class="col-md-5 control-label"> Service

											</label>
											<div class="col-md-7">
										             <selectivity list="sectorList" property="row.sectorCode" id="sectorCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService && row.isServiceMan">
											<label class="col-md-5 control-label"> Service

											</label>
											<div class="col-md-7">
									             <selectivity list="sectorList"
														property="row.sectorCode"
														id="sectorCode{{trIndex}}"
														ng-model="row.sectorCode" validation="required"
														name="sectorCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Service)'}}"
														form-name="purchaseCreditNoteForm"
														>
													</selectivity>
										     </div>
										</div>
					 -->
<!-- 					
				<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee && !row.isEmployeeMan">
											<label class="col-md-5 control-label"> Employee

											</label>
											<div class="col-md-7">
										           <selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
										     </div>
										</div>  -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee ">
											<label class="col-md-5 control-label"> Employee

											</label>
											<div class="col-md-7">
										           <selectivity list="employeeList"
														property="row.isEmployee"
														id="employeeCode{{trIndex}}"
														ng-model="row.employeeCode" validation="required"
														name="employeeCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Employee)'}}"
														form-name="purchaseCreditNoteForm"
														>
													</selectivity>
										     </div>
										</div>
										<!--  <div class="col-sm-2 padding-top-5" ng-if="row.isPort && !row.isPortMan">
											<label class="col-md-5 control-label"> Location

											</label>
											<div class="col-md-7">
										           <selectivity list="portList" property="row.portCode" id="portCode{{trIndex}}"></selectivity>
										     </div>
										</div> 
										 -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort">
											<label class="col-md-5 control-label"> Port

											</label>
											<div class="col-md-7">
										           <selectivity list="portList"
														property="row.portCode"
														id="portCode{{trIndex}}"
														ng-model="row.portCode" validation="required"
														name="portCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Port)'}}"
														form-name="purchaseCreditNoteForm"
														>
													</selectivity>
										     </div>
										</div>
					
							<!-- 			<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence && !row.isPortSequenceMan">
											<label class="col-md-5 control-label"> Port.Seq

											</label>
											<div class="col-md-7">
										          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
										     </div>
										</div> -->
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
											<label class="col-md-5 control-label"> Port.Seq

											</label>
											<div class="col-md-7">
										          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" 
										          ng-model="row.portSequence" name="PortSequence" validation="required" friendly-name="{{ 'Row' + $index + '(Port Seq)'}}" form-name="purchaseCreditNoteForm"/>
										     </div>
										</div>

						<!-- 				<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment && !row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department

											</label>
											<div class="col-md-7">
										           <selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment ">
											<label class="col-md-5 control-label"> Department

											</label>
											<div class="col-md-7">
										           <selectivity list="departmentList"
														property="row.departmentCode"
														id="departmentCode{{trIndex}}"
														ng-model="row.departmentCode" validation="required"
														name="departmentCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Department)'}}"
														form-name="purchaseCreditNoteForm"
														>
													</selectivity>
										     </div>
										</div>
								<!-- 		
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent && !row.isAgentMan">
											<label class="col-md-5 control-label"> Agent

											</label>
											<div class="col-md-7">
										           <selectivity list="agentList" property="row.agentCode" id="agentCode{{trIndex}}" ></selectivity>
										     </div>
										</div> -->
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent ">
											<label class="col-md-5 control-label"> Agent

											</label>
											<div class="col-md-7">
										           <selectivity list="agentList"
														property="row.agentCode"
														id="agentCode{{trIndex}}"
														ng-model="row.agentCode" validation="required"
														name="agentCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Agent)'}}"
														form-name="purchaseCreditNoteForm"
														>
													</selectivity>
										     </div>
										</div>

					<!-- 					<div class="col-sm-2 padding-top-5" ng-if="row.isLocation && !row.isLocationMan">
											<label class="col-md-5 control-label"> Location

											</label>
											<div class="col-md-7">
										             <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										 -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation ">
											<label class="col-md-5 control-label"> Location

											</label>
											<div class="col-md-7">
										             <selectivity list="countryList"
														property="row.countryCode"
														id="countryCode{{trIndex}}"
														ng-model="row.countryCode" validation="required"
														name="countryCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Location)'}}"
														form-name="purchaseCreditNoteForm"
														>
													</selectivity>
										     </div>
										</div>
										
							<!-- 			<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer && !row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer

											</label>
											<div class="col-md-7">
										             <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer ">
											<label class="col-md-5 control-label"> Customer

											</label>
											<div class="col-md-7">
										              <selectivity list="customerList"
														property="row.customerCode"
														id="customerCode{{trIndex}}"
														ng-model="row.customerCode" validation="required"
														name="customerCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Customer)'}}"
														form-name="purchaseCreditNoteForm"
														>
													</selectivity>
										     </div>
										</div>
										
						<!-- 				<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier && !row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier

											</label>
											<div class="col-md-7">
										             <selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
											<label class="col-md-5 control-label"> Supplier

											</label>
											<div class="col-md-7">
										             <selectivity list="supplierList"
														property="row.supplierCode"
														id="supplierCode{{trIndex}}"
														ng-model="row.supplierCode" validation="required"
														name="supplierCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Supplier)'}}"
													form-name="purchaseCreditNoteForm"
														>
													</selectivity>
										     </div>
										</div>
										
								<!-- 		<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation && !row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation

											</label>
											<div class="col-md-7">
										             <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
										     </div>
										</div> -->
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation ">
											<label class="col-md-5 control-label"> Designation

											</label>
											<div class="col-md-7">
										             <selectivity list="designationList"
														property="row.designationCode"
														id="designationCode{{trIndex}}"
														ng-model="row.designationCode" validation="required"
														name="designationCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Designation)'}}"
														form-name="purchaseCreditNoteForm"
														>
													</selectivity>
										     </div>
										</div>
										
								<!-- 		
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter && !row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr

											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter{{trIndex}}"/>
										     </div>
										</div> -->
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter ">
											<label class="col-md-5 control-label"> CostCtr

											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" 
										             ng-model="row.costCenter" name="CostCenter{{trIndex}}" friendly-name="{{ 'Row' + $index + '(Designation)'}}" form-name="purchaseCreditNoteForm"/>
										     </div>
										</div>
										<!--  commented for inter-company transaction -->
										<div class="col-sm-2 padding-top-5" ng-if="row.isAsset">
							           <label class="col-md-5 control-label"> Asset
							
							           </label>
							           <div class="col-md-7">
							                       <selectivity list="row.assetList" property="row.assetCode" id="assetCode{{trIndex}}"></selectivity>
							               </div>
							          </div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
											<label class="col-md-5 control-label">Qty(MT)GO</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO"/>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
											<label class="col-md-5 control-label">Qty(MT)FO</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO"/>
										     </div>
										</div>
					</div>
			    </td> 		             	
	       </tr> 
      	</tbody>
      </table>
      <div class="padding-right-5" id="AddOrRmvebtn">
           <button ng-click="addCredRow(creditnoteAcctData.credittables)" class="btn btn-sm btn-info" tooltip="Add Row" ng-disabled="" type="button">
            <i class="fa fa-plus"></i>
           </button>  
           <button ng-click="removeCredRow(creditnoteAcctData.credittables)" class="btn btn-sm btn-danger" type="button" tooltip="Delete">
            <i class="fa  fa-trash-o"></i>
           </button>
      </div> <!-- /padding-right-5 - /AddOrRmvebtn -->
	</div>    <!-- /table-responsive -->
	<div class="row">
		<div class="col-md-12">
										<div class="col-sm-12">
										<div class="form-group pull-right">
										 <label class="col-md-3 control-label">Total TC Amount</label>
										<div class="col-md-3">
											<input type="text" class="form-control input-sm text-right" ng-model="totalTCAmount" readonly
											name="TC Total" placeholder="0.0">
										</div>

										  
		         <label class="col-md-3 control-label">Total BC Amount</label>
		        <div class="col-md-3">
											<input type="text" class="form-control input-sm text-right" ng-model="totalBCAmount" readonly
											name="BC Total" placeholder="0.0">
										</div>

									</div>
								</div>
	<!-- 	<div class="col-sm-12">
			<div class="form-group pull-right">
		       
		        <label class="col-md-3 control-label">Total TC Amt</label>
		        <div class="col-md-3">
		         	<input type="text" class="form-control input-sm" name="totalTCAmount" data-ng-model="creditnoteAcctData.totalTCAmount"
	         	  		ng-pattern-restrict="^\d+(?:\.\d{0,2})?$"	  step="0.01" disabled />
		        </div>
		        
		         <label class="col-md-3 control-label">Total BC Amt</label>
		        <div class="col-md-3">
		         	<input type="text" class="form-control input-sm" name="totalBCAmount" data-ng-model="creditnoteAcctData.totalBCAmount"
	         	  		ng-pattern-restrict="^\d+(?:\.\d{0,2})?$"	  step="0.01" disabled />
		        </div>
	       </div>
		</div> -->
	</div>
	</div>
	 <div class="row">
     <div class="col-sm-12 col-md-12 col-lg-12">
      <div class="content">
      	<div class="form-actions">
        <div class="row">
         <div class="col-md-12">
          <button class="btn btn-success" type="button" ng-if="!edit" ng-click="submit()" >
           <i class="fa fa-save"></i>
           Save
          </button>
          <button class="btn btn-success" type="button" ng-if="edit" ng-click="submit()">
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
</div>
</div>