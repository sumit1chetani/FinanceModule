<div class="breadcrumb-wrapper ng-scope">
 <div class="panel panel-default panel-default-form">
  <div class="panel-heading panel-heading-form font-bold">
   <ol class="breadcrumb padding-left-0">
    <li>
     <a1>Finance</a1>
    </li>
    <li>
     <a1>Transaction</a1>
    </li>
    <li>
     <a1 x-ui-sref="app.finance.transaction.journalvoucher.list">Journal Voucher</a1>
    </li>
    <li ng-if="!journalVoucher.isEdit">
     <a1 x-ui-sref="'app.finance.transaction.journalvoucher.add">Add</a1>
    </li>
    <li ng-if="journalVoucher.isEdit">
     <a1 x-ui-sref="app.finance.transaction.journalvoucher.edit">Edit</a1>
    </li>
   </ol>
  </div>
  <input type="hidden" value="${form_code}" id="form_code_id">
  <div class="panel-body">
   <form class="form-horizontal" name="journalVoucherForm" >
    <div class="row book-widget-row">
     <div class="col-sm-12 col-md-12 col-lg-12">
     	<div class="col-sm-4 col-md-4 col-lg-4">
	 		<div class="form-group">
	       		<label for="inputPassword" class="control-label col-md-6">JV Number</label>
	       		<div class="col-md-6">
	       			<label for="inputPassword" ng-model="journalVoucher.jvNumber" class=" form-control">{{journalVoucher.jvNumber}}</label>
	       		</div>
	      	</div>
	    </div>
	    <div class="col-sm-4 col-msd-4 col-lg-4">
	    	<div class="form-group">
	        	<label for="inputPassword" class="control-label col-md-6">JV Date<span style="color: red;">*</span></label>
		        <div class="col-md-6">
		         <!--  <div class='input-group date ' id="datetimepick"> -->
	                 <!-- <input type="text" class="form-control" ng-model="journalVoucher.dataOfIssue" placeholder="dd/mm/yyyy" id="dataOfIssue" 
	                     value="{{journalVoucher.dataOfIssue}}" validator="required" message-id="JV Date" valid-method="submit" name="dataOfIssue"/> -->
	                  <%-- <input type="text" class="form-control calendar" ng-model="journalVoucher.dataOfIssue" id="dataOfIssue" name="data Of Issue" 
						friendly-name="JV Date" validation="required" placeholder="dd/mm/yyyy" ng-change="checkDates(journalVoucher.dataOfIssue) />
	                  <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span> --%>
	                   <ng-bs3-datepicker data-ng-model="journalVoucher.dataOfIssue" id="dataOfIssue" name="dataOfIssue"
       data-ng-change="checkDatesCL(journalVoucher.dataOfIssue)" friendly-name="From Date" validation="required" disabled/>
       <ng-bs3-datepicker data-ng-model="journalVoucher.dataOfIssue" id="dataOfIssue" name="dataOfIssue" form-name="journalVoucherForm"
       data-ng-change="checkDatesCL(journalVoucher.dataOfIssue)" 
        friendly-name="JV Date" validation="required" disabled/>
	             <!--  </div> -->
		        </div>
	       	</div>
	    </div>
	    <div class="col-sm-4 col-msd-4 col-lg-4">
	    	<div class="form-group">
		       	<label for="inputPassword" class="control-label col-md-6 col-lg-6">Narration<span style="color: red;">*</span></label>
		       	<div class="col-md-6">
			      <!--   <textarea id="txtNarration" ng-model="journalVoucher.narration" name="Narration" friendly-name="Narration" validation="required" 
			        class="custom-scroll width_100" rows="1"></textarea> -->
			        
			        
			        	<textarea rows="1" cols="60" class="form-control input-sm" id="txtNarration" name="Narration"
						 ng-model="journalVoucher.narration" 
						 friendly-name="Narration" validation="required"></textarea>
			        
			        
			        
		       	</div>
	      	</div>
	    </div>
	    <div class="col-sm-4 col-md-4 col-lg-4">
	    	 <!--  <div class="form-group">
		      	<label for="inputPassword" class="control-label col-md-6">Company<span style="color: red;">*</span></label>
		      	<div class="col-md-6">
		      		<selectivity name="company Code" id="companyCode" list="companyList" ng-model="journalVoucher.company" property="journalVoucher.company" 
		      		 validation="required" friendly-name="Company" form-name="journalVoucherForm"></selectivity>
		      	</div>
		     </div> -->
	    </div>
     </div> <!-- /col-sm-12 -->
   </div> <!-- /row -->
        
       <div class="table-responsive clear">
          <table class="table table-striped b-t b-light">
	          <thead>
		          <tr>
			          <th class="width_1 text-center padding-both-side-2"></th>
			          <!-- <th class="text-center padding-both-side-2">Sub Group</th> -->
			          <th class="width_10 text-center padding-both-side-2">Company<span style="color: red;">*</span></th>
			          <th class="width_10 text-center padding-both-side-2">Account Head<span style="color: red;">*</span></th>
			          <th class="width_10 text-center padding-both-side-2">Sub Account Code</th>
			          <th class="width_10 text-center padding-both-side-2">Narration<span style="color: red;">*</span></th>
			          <th class="width_6 text-center padding-both-side-2">Cur<span style="color: red;">*</span></th>
			          <th class="width_6 text-center padding-both-side-2">Rate<span style="color: red;">*</span></th>
			          <th class="width_6 text-center padding-both-side-2">TC Debit<span style="color: red;">*</span></th>
			          <th class="width_6 text-center padding-both-side-2">BC Debit<span style="color: red;">*</span></th>
			          <th class="width_6 text-center padding-both-side-2">TC Credit<span style="color: red;">*</span></th>
			          <th class="width_6 text-center padding-both-side-2">BC Credit<span style="color: red;">*</span></th>
		          </tr>
	          </thead>
	          <!-- <tbody ng-repeat="(trIndex, row) in table.row" ng-controller="tableCtrl"> -->
	          <tbody ng-repeat="(trIndex, row) in journalVoucher.tables" ng-controller="tableCtrlJV">	          
		          <tr>
		          	<td class="padding-both-side-2">
		            	<label class="i-checks m-b`-none"> <input type="checkbox" ng-model="row.select" id="select{{trIndex}}" /><i></i></label>						
		            </td>
		            <td class="padding-both-side-2">
		            	<selectivity  list="companyList" property="row.companyCode" id="companyCode{{trIndex}}" ng-model="row.companyCode"
		            	name="companyCode{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Company)'}}" form-name="journalVoucherForm"></selectivity>
		            	<!-- <selectivity ng-if="!isEdit" list="companyList" property="row.companyCode" id="companyCode{{trIndex}}" ng-model="row.companyCode"
		            	name="companyCode{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Company)'}}" form-name="journalVoucherForm"></selectivity> -->
		            </td>
		          <!--   <td class="padding-both-side-2">
		            	<selectivity  list="accountHeadList" property="row.accountCode" ng-model="row.accountCode" id="txtAccountCode{{trIndex}}"
		            	 name="AccountCode{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name="journalVoucherForm"></selectivity>
		                  
	            		
		              		<selectivity list="accountHeadList" property="row.accountCode" id="txtAccountCode{{trIndex}}" 
		              		ng-model="row.accountCode" name ="AccountCode{{trIndex}}" validation="required"
										friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "journalVoucherForm"></selectivity>
	        			
	        				            </td>
	        		 -->
	        		       <td>
	            	<div class="row">
	            		<div class="col-xs-12">
		              		<selectivity list="accountHeadList" property="row.accountCode" id="txtAccountCode{{trIndex}}" 
		              		ng-model="row.accountCode" name ="AccountCode{{trIndex}}" validation="required"
										friendly-name="{{ 'Row' + $index + '(Account Head)'}}" form-name = "journalVoucherForm"></selectivity>
	        			</div>
	        		</div>
	        	</td>
					<td>
						<div class="col-xs-12" ng-if="!row.isSubAccountCode">
		            		<selectivity list="row.subAccountCodeList"
								property="row.subAccountCode"
								id="txtSubAccountCode{{trIndex}}"
								ng-model="row.subAccountCode"
								name="txtSubAccountCode{{trIndex}}"
								friendly-name="{{ 'Row' + $index + '(Sub Account Code)'}}"
								form-name="journalVoucherForm"
								disabled="!row.isSubAccountCode">
							</selectivity>
							</div>
						   <div class="col-xs-12" ng-if="row.isSubAccountCode">
							<selectivity list="row.subAccountCodeList"
								property="row.subAccountCode"
								id="txtSubAccountCode{{trIndex}}"
								ng-model="row.subAccountCode" validation="required"
								name="txtSubAccountCode{{trIndex}}"
								friendly-name="{{ 'Row' + $index + '(Sub Account Code)'}}"
								form-name="journalVoucherForm"
								>
							</selectivity>
						</div>
					</td>
					<td class="padding-both-side-2">
		            	<input type="text" class="form-control input-sm journalVoucher-textBox" ng-model="row.narration"
		            	name="narration{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Narration)'}}">
		            </td>
		            <td class="padding-both-side-2">
		            	<!-- <input type="text" class="form-control input-sm journalVoucher-textBox" ng-model="row.currency"
		            	name="currency{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + 'Currency'}}" readonly> -->
		             	<div class="row">
				            <div class="col-xs-12" ng-if="row.isCurrencyBlocked">
				            	  <selectivity list="currencyList" property="row.currency" id="currency{{trIndex}}" object="currency" 
				            	  name="currency{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" 
				            	  ng-model="row.currency" property="row.currency" form-name="journalVoucherForm"
								  disabled="row.isCurrencyBlocked" disabled="true"></selectivity>
		           			</div>
		           			<div class="col-xs-12" ng-if="!row.isCurrencyBlocked" >
				            	  <selectivity list="currencyList" property="row.currency" id="currency{{trIndex}}" object="currency" 
				            	  name="currency{{trIndex}}" validation="required" friendly-name="{{ 'Row' + $index + '(Currency)'}}" 
				            	  ng-model="row.currency" property="row.currency" form-name="journalVoucherForm" disabled="true"></selectivity>
		           			</div>
		           		
				        </div>
		             	
		            </td>
		            <td class="padding-both-side-2">
		            <input type="hidden" class="form-control input-sm text-right" id="txtFromCurrency{{trIndex}}" ng-model="row.fromCurrency"  
								           		 name="From Currency{{trIndex}}" readonly />
		           		 <input type="hidden" class="form-control input-sm" id="txtToCurrency{{trIndex}}" ng-model="row.toCurrency"  
		           		 name="To Currency{{trIndex}}" readonly ng-pattern-restrict="^\d+(?:\.\d{0,3})?$"/>		             
                      <input type="text" class="form-control input-sm journalVoucher-textBox text-right" ng-model="row.exchangeRate" name="exrate{{trIndex}}"
		              ng-change="calculationExchangeRateForDebit(row.exchangeRate,trIndex,row)"
		              validation="required" friendly-name="{{ 'Row' + $index + '(Exchange rate)'}}" ng-pattern-restrict="^\d+(?:\.\d{0,3})?$" readonly>
		            </td>
		            <td class="padding-both-side-2">
		            	<input type="text" class="form-control input-sm journalVoucher-textBox text-right" ng-model="row.tcDebitAmount" ng-keyup="numberCheck(row)" ng-change="TCtoBCAmountCalculationForPartyAccountDetTbl(row.tcDebitAmount,trIndex,row)"
		            	name="tcDebitAmount{{trIndex}}" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Debit Should be 2 digit|required" friendly-name="{{ 'Row' + $index + '(TC Debit Amount)'}}">
		            </td>
		            <td class="padding-both-side-2">
		            	<input type="text" class="form-control input-sm journalVoucher-textBox text-right" ng-model="row.bcDebitAmount" ng-keyup="numberCheck(row)" ng-blur="BCtoTCAmountCalculationForPartyAccountDetTbl(row.bcDebitAmount,trIndex,row)"
		            	name="bcDebitAmount{{trIndex}}" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC Debit(USD) Should be 2 digit|required" friendly-name="{{ 'Row' + $index + '(BC Debit Amount)'}}">
		            </td>
		            <td class="padding-both-side-2">
		            	<input type="text" class="form-control input-sm  journalVoucher-textBox text-right" ng-model="row.tcCreditAmount" ng-keyup="numberCheck(row)" ng-change="TCtoBCAmountCalculation(row.tcCreditAmount,trIndex,row)"
		            	name="tcCreditAmount{{trIndex}}" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=TC Credit Should be 2 digit|required" friendly-name="{{ 'Row' + $index + '(TC Credit Amount)'}}">
		            </td>
		            <td class="padding-both-side-2">
		            	<input type="text" class="form-control input-sm journalVoucher-textBox text-right" ng-model="row.bcCreditAmount" ng-keyup="numberCheck(row)" ng-blur="BCtoTCAmountCalculation(row.bcCreditAmount,trIndex,row)"
		            	name="bcCreditAmount{{trIndex}}" validation="pattern=/^[0-9-]+(\.[0-9-]{1,2})?$/:alt=BC credit(USD) Should be 2 digit|required" friendly-name="{{ 'Row' + $index + '(BC Credit Amount)'}}">
		            </td>
		          </tr>
		          <!-- Attributes list -->
		          <tr>
						        	<td colspan="12">
							        	<div class="col-sm-12">
							        	<!-- Attributes list -->
							        	<!-- <div class="col-sm-3" >
							        	<label class="col-md-5 control-label"> Attriutes </label>
							        	</div> -->
							        	 
							        	<div class="col-sm-2 padding-top-5" ng-if="row.isVessel && !row.isVesselMan">
											<label class="col-md-5 control-label"> 	Vessel

											</label>
											<div class="col-md-7">
										           <selectivity list="vesselList" property="row.vesselCode" id="vesselCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isVessel && row.isVesselMan">
											<label class="col-md-5 control-label"> Vessel

											</label>
											<div class="col-md-7">
										          <selectivity list="vesselList"
															property="row.vesselCode"
															id="vesselCode{{trIndex}}"
															ng-model="row.vesselCode" validation="required"
															name="vesselCode{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
															form-name="journalVoucherForm"
															>
														</selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && !row.isVoyageMan">
											<label class="col-md-4 control-label"> Voyage

											</label>
											<div class="col-md-8">
										              <selectivity list="voyageList" property="row.voyageCode" id="voyageCode{{trIndex}}"></selectivity>
										     </div>
										</div> 
										 <div class="col-sm-2 padding-top-5" ng-if="row.isVoyage && row.isVoyageMan">
											<label class="col-md-4 control-label"> Voyage

											</label>
											<div class="col-md-8">
										              <selectivity list="voyageList"
															property="row.voyageCode"
															id="voyageCode{{trIndex}}"
															ng-model="row.voyageCode" validation="required"
															name="txtSubAccountCode{{trIndex}}"
															friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
															form-name="journalVoucherForm"
															>
														</selectivity>
										     </div>
										     
										    
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService && !row.isServiceMan">
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
														form-name="journalVoucherForm"
														>
													</selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee && !row.isEmployeeMan">
											<label class="col-md-5 control-label"> Employee

											</label>
											<div class="col-md-7">
										           <selectivity list="employeeList" property="row.employeeCode" id="employeeCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee && row.isEmployeeMan">
											<label class="col-md-5 control-label"> Employee

											</label>
											<div class="col-md-7">
										           <selectivity list="employeeList"
														property="row.isEmployee"
														id="employeeCode{{trIndex}}"
														ng-model="row.employeeCode" validation="required"
														name="employeeCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Employee)'}}"
														form-name="journalVoucherForm"
														>
													</selectivity>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort && !row.isPortMan">
											<label class="col-md-5 control-label">Port

											</label>
											<div class="col-md-7">
										           <selectivity list="portList" property="row.portCode" id="portCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort && row.isPortMan">
											<label class="col-md-5 control-label"> Port

											</label>
											<div class="col-md-7">
										           <selectivity list="portList"
														property="row.portCode"
														id="portCode{{trIndex}}"
														ng-model="row.portCode" validation="required"
														name="portCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Port)'}}"
														form-name="journalVoucherForm"
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
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence && row.isPortSequenceMan">
											<label class="col-md-5 control-label"> Port.Seq

											</label>
											<div class="col-md-7">
										          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" 
										          ng-model="row.portSequence" name="PortSequence" validation="required" friendly-name="{{ 'Row' + $index + '(Port Seq)'}}"/>
										     </div>
										</div> -->

										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment && !row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department

											</label>
											<div class="col-md-7">
										           <selectivity list="departmentList" property="row.departmentCode" id="departmentCode{{trIndex}}"></selectivity>
										     </div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment && row.isDepartmentMan">
											<label class="col-md-5 control-label"> Department

											</label>
											<div class="col-md-7">
										           <selectivity list="departmentList"
														property="row.departmentCode"
														id="departmentCode{{trIndex}}"
														ng-model="row.departmentCode" validation="required"
														name="departmentCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Department)'}}"
														form-name="journalVoucherForm"
														>
													</selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent && !row.isAgentMan">
											<label class="col-md-5 control-label"> Agent

											</label>
											<div class="col-md-7">
										           <selectivity list="agentList" property="row.agentCode" id="agentCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent && row.isAgentMan">
											<label class="col-md-5 control-label"> Agent

											</label>
											<div class="col-md-7">
										           <selectivity list="agentList"
														property="row.agentCode"
														id="agentCode{{trIndex}}"
														ng-model="row.agentCode" validation="required"
														name="agentCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Agent)'}}"
														form-name="journalVoucherForm"
														>
													</selectivity>
										     </div>
										</div>

										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation && !row.isLocationMan">
											<label class="col-md-5 control-label"> Location

											</label>
											<div class="col-md-7">
										             <selectivity list="countryList" property="row.countryCode" id="countryCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation && row.isLocationMan">
											<label class="col-md-5 control-label"> Location

											</label>
											<div class="col-md-7">
										             <selectivity list="countryList"
														property="row.countryCode"
														id="countryCode{{trIndex}}"
														ng-model="row.countryCode" validation="required"
														name="countryCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Location)'}}"
														form-name="journalVoucherForm"
														>
													</selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer && !row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer

											</label>
											<div class="col-md-7">
										             <selectivity list="customerList" property="row.customerCode" id="customerCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer && row.isCustomerMan">
											<label class="col-md-5 control-label"> Customer

											</label>
											<div class="col-md-7">
										              <selectivity list="customerList"
														property="row.customerCode"
														id="customerCode{{trIndex}}"
														ng-model="row.customerCode" validation="required"
														name="customerCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Customer)'}}"
														form-name="journalVoucherForm"
														>
													</selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier && !row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier

											</label>
											<div class="col-md-7">
										             <selectivity list="supplierList" property="row.supplierCode" id="supplierCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier && row.isSupplierMan">
											<label class="col-md-5 control-label"> Supplier

											</label>
											<div class="col-md-7">
										             <selectivity list="supplierList"
														property="row.supplierCode"
														id="supplierCode{{trIndex}}"
														ng-model="row.supplierCode" validation="required"
														name="supplierCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Supplier)'}}"
														form-name="journalVoucherForm"
														>
													</selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation && !row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation

											</label>
											<div class="col-md-7">
										             <selectivity list="designationList" property="row.designationCode" id="designationCode{{trIndex}}"></selectivity>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation && row.isDesignationMan">
											<label class="col-md-5 control-label"> Designation

											</label>
											<div class="col-md-7">
										             <selectivity list="designationList"
														property="row.designationCode"
														id="designationCode{{trIndex}}"
														ng-model="row.designationCode" validation="required"
														name="designationCode{{trIndex}}"
														friendly-name="{{ 'Row' + $index + '(Designation)'}}"
														form-name="journalVoucherForm"
														>
													</selectivity>
										     </div>
										</div>
										
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter && !row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr

											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter{{trIndex}}"/>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter && row.isCostCenterMan">
											<label class="col-md-5 control-label"> CostCtr

											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" 
										             ng-model="row.costCenter" name="CostCenter{{trIndex}}" friendly-name="{{ 'Row' + $index + '(Designation)'}}"/>
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
	         <button ng-click="addRow(journalVoucher.tables)" class="btn btn-sm btn-info" type="button">
	         <i class="fa fa-plus"></i></button>
	         <button ng-click="removeRow(journalVoucher.tables)" class="btn btn-sm btn-danger" type="button">
	         <i class="fa fa-trash-o"></i></button>
         </div>
        <div class="row">
	        <div class="col-sm-12">
	        	<div class="form-group pull-right">
		          <label class="col-md-4 control-label">Total </label>		         
		         <div class="col-md-2" id="totals">
		         	<input type="text" class="form-control input-sm text-right" id="totaltcDebit" ng-model="totaltcDebit" readonly>
		         </div>
		         <div class="col-md-2" id="totals">
		         	<input type="text" class="form-control input-sm text-right" id="totalbcDebit" ng-model="totalbcDebit" readonly>
		         </div>
		         <div class="col-md-2" id="totals">
		          <input type="text" class="form-control input-sm text-right" id="totaltcCredit" ng-model="totaltcCredit" readonly>
		         </div>
		         <div class="col-md-2" id="totals">
		          <input type="text" class="form-control input-sm text-right" id="totalbcCredit" ng-model="totalbcCredit" readonly>
		         </div>
		       </div>
	        </div> <!-- /col-sm-12 -->
        </div> <!-- /row -->
        
         <div class="row">
          <div class="col-md-12">
          	<div class="form-actions">
	          <!--   <button ng-model="add" class="btn btn-success ng-scope" type="button" class="btn btn-success"
	            	 ng-if="!isEdit"    ng-if="!viewDisable" 
	        		ng-click="onSubmit(journalVoucherForm,journalVoucher)">
	        		<i class="fa fa-save"></i>Save
	       		</button> -->
	            <button ng-model="add" class="btn btn-success ng-scope" type="button" class="btn btn-success" 
	        		ng-click="update(journalVoucherForm,journalVoucher)">
	        		<i class="fa fa-save"></i>
	        		Update
	       		</button>
	       	<!-- 	   <button ng-model="add" class="btn btn-success ng-scope" type="button" class="btn btn-success" 
	            	 ng-if="viewDisable"
	        		ng-click="onSubmit(journalVoucherForm,journalVoucher)" disabled="disabled">
	        		<i class="fa fa-save"></i>
	        		Save
	       		</button> -->
	           	<button class="btn btn-danger" ng-click="cancel()" type="button"><i class="fa fa-close"></i>
	            Cancel
	           	</button>
	           	
	    <!--        	ng-if = "draft == false" -->
	           
           	</div> <!-- /form-actions -->
          </div> <!-- /col-sm-12 -->
         </div> <!-- /row -->        
       </div> <!-- /table-responsive -->     
   </form>
  </div>
 </div>
</div>
<script type="text/ng-template" id="helpDialogBox"> 
  <div class="padding-0">
 <div class="panel panel-default padding-0">
  <div class="panel-heading font-bold">Help</div>
  <div class="panel-body">
  
   <div class="row book-widget-row">
   
    <div class="col-sm-12 col-md-4 col-lg-4">
      
         <div class="form-group">
        
        <label class="col-md-6 control-label">SubGroup Type</label>
        <div class="col-md-6">
        <select id="journalVoucherSubGrpTpe" class="form-control journalVoucher-textBox" ng-model="objHelpPopoup.subGrop" name="columnName" style="width: 77px;">
        <option value="">--select--</option>
               <option value="V">Vessel Related</option>
               <option value="Q">Vessel Quantity Related</option>
               <option value="B">Business Associate</option>
               <option value="G">General</option>
               <option value="E">Employee Related</option>
              </select>
       </div>
       </div> 
       
    </div>
       <div class="col-sm-12 col-md-4 col-lg-4">
     
            <div class="form-group">
        <label class="col-md-6">Sub Group</label>
        <div class="col-md-6">
          <select class="form-control journalVoucher-textBox"    ng-model="objHelpPopoup.subGropType" name="columnName" id="subGropType"  data-ng-options=" r.subGropTypeCode as r.subGropType for r in subGropList"  
               style="width: 77px;" >
               <option value="" selected="selected">Select</option>
              </select>
       </div>
       </div>
       </div>
        <div class="col-sm-12 col-md-4 col-lg-4">
     
            <div class="form-group">
        <label class="col-md-6">Account Head Name</label>
        <div class="col-md-6">
         <select class="form-control journalVoucher-textBox" ng-model="objHelpPopoup.accountCode" name="columnName" style="width: 77px;"
               data-ng-options="r.accountCode as r.journalAccountHead for r in accountList">
               <option value="" selected="selected">Select</option>
              </select>
       </div>
       </div>
      </div>

      <div class="col-md-12">
   
      <fieldset>
      <button class="btn btn-success" ng-click="save(objHelpPopoup)" type="button">
            <i class="fa fa-save"></i>
            Submit
           </button>
      </fieldset>
    
     </div>
    </div>
<br>
   <div> <div class="panel panel-default panel-default-list" st-table="displayedCollectionHelp" st-safe-src="rowCollectionHelp">
  
  <div class="panel-body padding-0">
   <div class="table-responsive ">
    <table class="table table-striped table-hover dataTable no-footer">
     <thead class="dataTables-Main-Head">
      <tr>
       <th class="sorting" st-sort="subGrop">SubGroup Type</th>
       <th class="sorting" st-sort="subGropType">subGrop</th>
       <th class="sorting" st-sort="journalAccountHead">Account Head Name</th>
      
      </tr>
     </thead>
     <tbody class="dataTables-Main-Body">
      <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="journalVoucherHelpDatas in displayedCollectionHelp">
      
       <td><span class="tool-tip-span" ng-if="displayedCollection[$index].subGrop != displayedCollection[$index-1].subGrop ">{{journalVoucherHelpDatas.subGrop}}</span></td>
       <td><span class="tool-tip-span" ng-if="displayedCollection[$index].subGropType !=displayedCollection[$index-1].subGropType ">{{journalVoucherHelpDatas.subGropType}}</span></td>
      
       <td><span class="tool-tip-span" ng-if="displayedCollection[$index].journalAccountHead !=displayedCollection[$index-1].journalAccountHead ">{{journalVoucherHelpDatas.journalAccountHead}}</span>
       </td>
      
      </tr>
     </tbody>
    </table>
   </div>
  </div>
 </div></div>
   <div class="form-actions">
    <div class="row">
     <div class="col-md-12">
     
      <button class="btn btn-danger" type="reset" class="btn btn-success" ng-click="closeThisDialog('button')">
       <i class="fa fa-close"></i>
       Close
      </button>
     </div>
    </div>
   </div>
  </div>
 </div>
</div>




</script>