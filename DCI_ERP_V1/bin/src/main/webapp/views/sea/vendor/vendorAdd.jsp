<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
     	<div role="content">
      		<div class="widget-body">
       			<form class="form-horizontal" id="manageCustomerAddForm" name="manageCustomerAddForm" novalidate method="post">
        			<div class="row">
         				<div class="col-sm-12 col-md-12 col-lg-12">
          					<div class="col-sm-6 col-md-6 col-lg-6">
           						<fieldset>
						            <div class="form-group">
						             	<label class="col-md-4 control-label">Vendor Name
						             	<span style="color:red;"> *</span>
						             	</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="manageName" id="entityName"
						               			data-ng-model="manageVendorObj.entityName" ng-blur="checkVendorName(manageVendorObj.entityName,manageVendorObj.entityId)"
						               			validation="required" friendly-name="Vendor Name" />
						             	</div>
						            </div>
						            <div class="form-group">
						            	<label class="col-md-4 control-label"> Store Address <span style="color:red;"> *</span></label>
							            <div class="col-md-7">
								            <div class="col-md-12 no-padding">
								             	<textarea class="text-left form-control input-sm" id="locationAddress" name="locationAddress" ng-model="manageVendorObj.locationAddress" rows="2" cols="15" placeholder="Street" style="resize: none" validation="required" friendly-name="Street"> </textarea>
								            </div>
									        <div class="col-md-12 no-padding">
										        <!-- <div class="col-md-5 no-padding padding-top-5">
													<selectivity list="mainCityList" property="manageVendorObj.cityId" name="txtCity" id=cityIds" ng-model="manageVendorObj.cityId"
													 validation="required" friendly-name="City" form-name = "manageCustomerAddForm"></selectivity>
										        </div> -->
										        <!-- <div class="col-md-4 no-padding padding-left-5 padding-top-5">
										        	<input type="hidden" class="form-control input-sm" placeholder="State" ng-model="manageVendorObj.desStateCode" />
							             			<input type="text" class="form-control input-sm" placeholder="State" ng-model="manageVendorObj.desState" readonly />
										        </div> -->
										        

									        </div>
									        <!-- <div class="col-md-12 no-padding padding-top-5">
								             	<input type="hidden" class="form-control input-sm" placeholder="Country" ng-model="manageVendorObj.desCountryCode" />
							             		<input type="text" class="form-control input-sm" placeholder="Country" ng-model="manageVendorObj.desCountry" readonly />
								            </div> -->
							            </div>
						            </div>
						         <!--    <div class="form-group">
							            <label class="col-md-4 control-label">Currency <span style="color:red;"> *</span></label>
							            <div class="col-md-7">
											<selectivity list="currencyList"  name="currencyCode" 
											property="manageVendorObj.currencyCode" ng-model="manageVendorObj.currencyCode" 
											validation="required" friendly-name="Currency" form-name ="manageCustomerAddForm" id="currencyCode" ></selectivity>
							            </div>
							         </div> -->
						            <!-- <div class="form-group">
						             	<label class="col-md-4 control-label">TIN Number</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="TINNumber" id="TINNumber"
						               			data-ng-model="manageVendorObj.tinNumber"  
						               			maxlength="50"  />
						             	</div>
						            </div> -->
						            <!-- <div class="form-group">
						             	<label class="col-md-4 control-label">CST Number</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="CSTNumber" id="CSTNumber" ng-keyup="isNumericValidation(this.TINNumber)"
						               			data-ng-model="manageVendorObj.cstNumber"  maxlength="50" />
						             	</div>
							      	</div> -->
							      	 <div class="form-group">
						             	<label class="col-md-4 control-label">PAN Number</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="PanNymber" id="PANNumber"
						               			data-ng-model="manageVendorObj.panNumber" 
						               			data-validator="required" data-valid-method="submit" maxlength="10" />
						             	</div>
						            </div>
							      	  <div class="form-group">
						             	<label class="col-md-4 control-label">GST  <span style="color:red;"> *</span></label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="GSTNumber" id="GSTNumber" ng-keyup="isNumericValidation(this.GSTNumber)"
						               			data-ng-model="manageVendorObj.gstNumber"  maxlength="50" />
						             	</div>
							      	</div>
							      	<div class="form-group">
					             		<label class="col-md-4 control-label"> Active</label>
					             			<div class="col-md-7">
							              		<div class="checkbox">
							               			<label> 
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="manageVendorObj.isActive" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
					            	</div>
					            <!-- 	<div class="form-group">
					             		<label class="col-md-4 control-label"> Is Customer</label>
					             			<div class="col-md-7">
							              		<div class="checkbox">
							               			<label> 
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="manageVendorObj.isCustomer" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
					            	</div> -->
					            	<div class="form-group visible-left">
					             		<label class="col-md-4 control-label "> Is Vendor</label>
					             			<div class="col-md-7">
							              		<div class="checkbox">
							               			<label> 
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="manageVendorObj.isVendor"  ng-disabled="edit" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
					            	</div>
           						</fieldset>
          					</div>
			          		<div class="col-sm-6 col-md-6 col-lg-6">
			           			<fieldset>
					            	<div class="form-group">
						             	<label class="col-md-4 control-label">Contact Person</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name=" contactPerson"id="contactPerson"
						               			data-ng-model="manageVendorObj.contactPerson"
						               			data-validator="required" data-valid-method="submit">
						             	</div>
						            </div>
						            <div class="form-group">
						             	<label class="col-md-4 control-label">Job Position</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="jobposition" id="jobPosition"
						               			data-ng-model="manageVendorObj.jobPosition"
						               			data-validator="required" data-valid-method="submit">
						             	</div>
						            </div>
						            <div class="form-group">
						             	<label class="col-md-4 control-label">Mobile</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="mpbile" id="mobile"
						               			data-ng-model="manageVendorObj.mobile" ng-blur="validateMobileNo(manageVendorObj.mobile)"
						               			maxlength="10"  phonenumbers-only />
						             	</div>
						            </div>
						            <div class="form-group">
						             	<label class="col-md-4 control-label">Phone</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="phone" id="phone"
						               			data-ng-model="manageVendorObj.phoneNo" ng-blur="validatePhoneNo(manageVendorObj.phoneNo)"
						               			maxlength="8" phonenumbers-only />
						               			<span ng-show='manageCustomerAddForm.$invalid'>
										        phone must be valid.
										      </span>	
						             	</div>
						            </div>
						            <div class="form-group">
						             	<label class="col-md-4 control-label">Fax</label>
<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="fax" id="fax"
						               			data-ng-model="manageVendorObj.fax" 
						               			data-validator="required" data-valid-method="submit" maxlength="20" phonenumbers-only />
						             	</div>						             
						            </div>
						            <div class="form-group">
						             	<label class="col-md-4 control-label">Website</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="website" id="website"
						               			data-ng-model="manageVendorObj.website" placeholder='www.yourwebsite.com' 
						               			data-validator="required" data-valid-method="submit" />
						             	</div>
						            </div>
						            <div class="form-group">
						             	<label class="col-md-4 control-label">Email<span style="color:red;"> *</span></label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="email" id="email" data-ng-model="manageVendorObj.email"  
						               			placeholder='your@email.com' validation="required"
						               			friendly-name="Email" />		
						             	</div>
						            </div>
						           <!--  <div class="form-group">
						             	<label class="col-md-4 control-label">PAN Number</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="PanNymber" id="PANNumber"
						               			data-ng-model="manageVendorObj.panNumber" 
						               			data-validator="required" data-valid-method="submit" maxlength="10" />
						             	</div>
						            </div> -->
						            <div class="form-group ">
					             		<label class="col-md-4 control-label">Vendor</label>
					             			<div class="col-md-7">
							              		<div class="checkbox">
							               			<label> 
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="manageVendorObj.isCollege" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
					            	</div>
						       <!--      <div class="form-group">
					             		<label class="col-md-4 control-label"> Is Others</label>
					             			<div class="col-md-7">
							              		<div class="checkbox">
							               			<label> 
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="manageVendorObj.isOthers" ng-disabled="edit" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
					            	</div> -->
	           					</fieldset>
	          				</div>
         				</div>
        			</div><br>
        			<!-- tabset - start -->
        			
        			<tabset>
        			
        			
        			<tab heading="Accounting"><br>
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12">
	        						<div class="col-sm-6 col-md-6 col-lg-6">
	        							<fieldset>
	        								<div class="form-group">
								           		<label class="bold">

Supplier</label>
								           </div>
	        							</fieldset>
	        						</div>
	        					</div>
        						<div class="col-sm-12 col-md-12 col-lg-12">
		          					<div class="col-sm-6 col-md-6 col-lg-6">
		           						<fieldset>
		           							<div class="form-group">
							             	<label class="col-md-4 control-label"> Supplier Payment Term
Days</label>
							             		<div class="col-md-6">
										           <input type="text" class="form-control pull-left" data-ng-model="manageVendorObj.vendorPaymentTerm" numbers-only />
										           <!-- <select class="form-control" data-ng-model="manageCustomerObj.custPaymentTerm" 
										           data-ng-options="ci.paymentId as ci.paymentTerms for ci in paymentList">
													            <option value="" selected="selected">Select</option>
													      </select> --> 
							             		</div>
							             		 <span class="pull-left line-height-30">Days</span>
							             		<!-- <div class="col-md-7">
								           			<select class="form-control" data-ng-model="manageVendorObj.vendorPaymentTerm" 
								           				data-ng-options="ci.paymentId as ci.paymentTerms for ci in paymentList">
											            <option value="" selected="selected">Select</option>
											      	</select> 
							             		</div> -->
								        </div>
								            <div class="form-group">
								             	<label class="col-md-4 control-label">Account Receivable</label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="Account Receivable" id="manageName"
								               			data-message-id="Name"
								               			data-ng-model="entityObj.accountReceivable" 
								               			data-validator="required" data-valid-method="submit">
								             	</div>
								            </div>
									        <div class="form-group">
								             	<label class="col-md-4 control-label">Account Payable</label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="Account Payable" id="manageName"
								               			data-message-id="Name"
								               			data-ng-model="entityObj.totalReceivable" 
								               			data-validator="required" data-valid-method="submit">
								             	</div>
								            </div>
		           						</fieldset>
		          					</div>
		          					<div class="col-sm-6 col-md-6 col-lg-6">
	          						
								  		<div class="form-group">
							             	<label class="col-md-4 control-label">Credit Limits</label>
							             	<div class="col-md-7">
							              		<input type="text" class="form-control input-sm" 
							               			name="manageName" id="manageName"
							               			data-message-id="Name"
							               			data-ng-model="manageVendorObj.vendorCreditLimit" 
							               			data-validator="required" data-valid-method="submit" phonenumbers-only>
							             	</div>
							            </div>
		          					</div>
		         				</div>
        					</div>
        					<div class="row">
        						<div class="col-sm-12">
								     			
							       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
							        data-st-table="displayedCollection1"
							        data-st-safe-src="rowCollection1">
							        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
								         <thead class="dataTables-Main-Head">
								          <tr>
								           <th class="width_1 text-center table-heading">
								          <!--   <label class="i-checks m-b-none">
								             <input type="checkbox">
								             <i></i>
								            </label> -->
								           </th>
								           <th class="sorting width_5" st-sort="bankName">Bank Name </th>
								           <th class="sorting width_5" st-sort="accountType">Account Type </th>
								           <th class="sorting width_5" st-sort="accountNo">Account No </th>
								           <th class="sorting width_5" st-sort="address">Address </th>
								           <th class="sorting width_5" st-sort="ifscCode">IFSC Code </th>
<!-- 								           <th class="width_5 text-center table-heading">Action</th>
 -->								          </tr>
								         </thead>
								         <tbody class="dataTables-Main-Body">
								          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objEntityAccount in manageVendorObj.customerBankobj">           
								           <td>
								          <label class="i-checks m-b-none"> 
												<input type="checkbox" data-ng-model="objEntityAccount.select"><i></i></label>  
										</td>
								           <td>{{objEntityAccount.bankName}}</td>
								           <td>{{objEntityAccount.accountType}}</td>
								           <td>{{objEntityAccount.accountNo}}</td>
								           <td>{{objEntityAccount.bankDetAddress}}</td>
								           <td>{{objEntityAccount.ifscCode}}</td>
								          <!-- <td class=" td-actions text-center">
									        <span>
									         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objEntityAccount)"></i>
									        </span>
									        <span>
									         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objEntityAccount)"></i>
									        </span>
								       	 </td> -->
								          </tr>
								         </tbody>
								        </table>
								        <div class="padding-left-10 padding-top-5" id="AddOrRmveMeritbtn">
										    <button class="btn btn-sm btn-primary" ng-click="addNewAccountingDialog()" type="button">
									         <i class="fa fa-plus"></i>
									     	</button>	
									     	<button ng-click="deleteBankRow()"
															class="btn btn-sm btn-danger" type="button"
															tooltip="Delete">
															<i class="fa  fa-trash-o"></i>
														</button>
									     								
									     								          
								      	</div>
								 
								</div>
        					</div>
        					</div>
        				</tab>
        			
        			<tab heading="Contact">
        					<div class="row">
						  		<div class="col-sm-12 padding-top-10">								     			
							       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
							        data-st-table="displayedCollection1" data-st-safe-src="rowCollection1">							        
								        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
									         <thead class="dataTables-Main-Head">
									          <tr>
									           <th class=" text-center table-heading">
									           <!--  <label class="i-checks m-b-none">
									             <input type="checkbox">
									             <i></i>
									            </label> -->
									           </th>
									           
									           
									           <th class="sorting" st-sort="contactName">Name </th>
									           <th class="sorting" st-sort="email">Email </th>
									           <th class="sorting" st-sort="mobile">Mobile </th>
									        
									           <th class="sorting" st-sort="phone">Phone </th>
<!-- 									           <th class="text-center table-heading">Action</th>
 -->									          </tr>
									         </thead>
									         <tbody class="dataTables-Main-Body" ng-repeat="objEntityAddress in manageVendorObj.customerContactobj">
									          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" >           
									          <td><label class="i-checks m-b-none"> 
												<input type="checkbox" data-ng-model="objEntityAddress.select"><i></i></label></td>         
									           <td>{{objEntityAddress.contactName}}</td>
								               <td>{{objEntityAddress.email}}</td>
									           <td>{{objEntityAddress.mobile}}</td> 												          
									           <td>{{objEntityAddress.phone}}</td>
									          <!-- <td class=" td-actions text-center">
										        <span>
										         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objEntityAddress)"></i>
										        </span>
										        <span>
										         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objEntityAddress)"></i>
										        </span>
									       	 </td> -->
									          </tr>
									         </tbody>
									    </table>
									    <div class="padding-left-10 padding-top-5" id="AddOrRmveMeritbtn">
										    <button class="btn btn-sm btn-primary" ng-click="addNewContactDialog()"  type="button">
									         <i class="fa fa-plus"></i>
									     	</button>		
									     		<button ng-click="deleteAddressRow()"
															class="btn btn-sm btn-danger" type="button"
															tooltip="Delete">
															<i class="fa  fa-trash-o"></i>
														</button>
									     							          
								      	</div>							        
							       </div>
								</div>											  
								 		
        					</div>
        				</tab>
        				
        				<tab heading="Internal Notes">
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
        							<fieldset>
				      					<div class="form-group">
						             		<div class="col-md-12">
						             			<textarea type="text" class="form-control input-sm"
						               				rows="4" cols="25" placeholder="Put an Internal Note..."
						               				name=".internalNotes"
						               				ng-model="manageVendorObj.internalNotes"
						               				style="resize: none"></textarea>
						             		</div>
								       </div>
					      			</fieldset>
				      			</div>
				     		</div>
        				</tab>
        				
        				
        					
        			</tabset>
        			<%--  <tabset>
        			 	<!-- /Address tab -->
        				<tab heading="Address">
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
        							<div class="col-sm-6 col-md-6 col-lg-6">
        								<div class="form-group">
							             	<label class="col-md-4 control-label">Vendor Location
							             	<!-- <span style="color:red;"> *</span> -->	</label>
							             		<div class="col-md-7">
							             			<selectivity list="locationList" property="manageVendorObj.vendorLocation" id="vendorLocation" 
							             				name="vendorLocation" ng-model="manageVendorObj.vendorLocation" 
							             				 friendly-name="Vendor Location" form-name = "manageCustomerAddForm"></selectivity>
							             		</div>
								        </div>
	        							<div class="form-group">
							            	<label class="col-md-4 control-label"> Billing Address</label>
								            <div class="col-md-7">
									            <div class="col-md-12 no-padding">
									             	<textarea class="text-left form-control input-sm" ng-model="manageVendorObj.billingAddress" rows="2" cols="15" style="resize: none"> </textarea>
									            </div>
										        <div class="col-md-12 no-padding">
											        <div class="col-md-5 no-padding padding-top-5">
														<selectivity list="billingCityList" ng-model="manageVendorObj.customerAddressobj[2].citybillingId" property="manageVendorObj.customerAddressobj[2].citybillingId" ></selectivity>
											        </div>
											        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
											        	<input type="hidden" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateCodeBilling" />
										             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateNameBilling" readonly />
											        </div>
											        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
											        	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="manageEntityObj.pincodeBilling" readonly />
											        </div>
										        </div>
										        <div class="col-md-12 no-padding padding-top-5">
									             	<input type="hidden" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryCodeBilling" />
										            <input type="text" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryNameBilling" readonly />	
									            </div>
								            </div>
							            </div>		
							           
        							</div>
        							<div class="col-sm-6 col-md-6 col-lg-6">
        								<div class="form-group">
							            	<label class="col-md-4 control-label"> Shipping Address</label>
								            <div class="col-md-7">
									            <div class="col-md-12 no-padding">
									             	<textarea class="text-left form-control input-sm" ng-model="manageVendorObj.shipAddress" rows="2" cols="15" style="resize: none"> </textarea>
									            </div>
										        <div class="col-md-12 no-padding">
											        <div class="col-md-5 no-padding padding-top-5">
														<selectivity list="shippingCityList" ng-model="manageVendorObj.customerAddressobj[0].cityAddressId" property="manageVendorObj.customerAddressobj[0].cityAddressId" id=txtCityAddressId></selectivity>
											        </div>
											        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
											        	<input type="hidden" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateCodeAddress">
											             <input type="text" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateNameAddress" readonly>
											        </div>
											        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
											        	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="manageEntityObj.pincodeAddress" readonly />
											        </div>
										        </div>
										        <div class="col-md-12 no-padding padding-top-5">
									             	<input type="hidden" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryCodeAddress" />
											             	<input type="text" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryNameAddress" readonly />
									            </div>
								            </div>
							            </div>		        							
							             
							           <div class="form-group">
							            	<label class="col-md-4 control-label"> Delivery Address</label>
								            <div class="col-md-7">
									            <div class="col-md-12 no-padding">
									             	<textarea class="text-left form-control input-sm" ng-model="manageVendorObj.deliveryAddress" rows="2" cols="15" style="resize: none"> </textarea>
									            </div>
										        <div class="col-md-12 no-padding">
											        <div class="col-md-5 no-padding padding-top-5">
														<selectivity list="deliveryCityList"  ng-model="manageVendorObj.customerAddressobj[1].citydeliveryId" property="manageVendorObj.customerAddressobj[1].citydeliveryId" id=txtCitydeliveryId></selectivity>
											        </div>
											        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
											        	<input type="hidden" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateCodedelivery">
										             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateNamedelivery" readonly>
											        </div>
											        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
											        	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="manageEntityObj.pincodedelivery" readonly />
											        </div>
										        </div>
										        <div class="col-md-12 no-padding padding-top-5">
									             	<input type="hidden" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryCodedelivery" />
										            <input type="text" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryNamedelivery" readonly />
									            </div>
								            </div>
							            </div>
        								<div class="form-group">
						             		<label class="col-md-4 control-label"> <spring:message code="label.entity.companyAddress"></spring:message></label>
					             			<div class="col-md-7">
							              		<div class="checkbox">
							               			<label> 
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="entityObj.companyAddress" data-ng-true-value="'Y'" data-ng-false-value="'N'">
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
						            	</div>
        							</div>
        						</div>
        					</div>        					
        				</tab>
        				<!-- /Address tab -->
        				<tab heading="Contact">
        					<div class="row">
						  		<div class="col-sm-12 padding-top-10">								     			
							       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
							        data-st-table="displayedCollection1" data-st-safe-src="rowCollection1">							        
								        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
									         <thead class="dataTables-Main-Head">
									          <tr>
									           <th class=" text-center table-heading">
									           <!--  <label class="i-checks m-b-none">
									             <input type="checkbox">
									             <i></i>
									            </label> -->
									           </th>
									           <th class="sorting" st-sort="contactName">Name </th>
									           <th class="sorting" st-sort="email">Email </th>
									           <th class="sorting" st-sort="mobile">Mobile </th>
									        
									           <th class="sorting" st-sort="phone">Phone </th>
									           <th class="text-center table-heading"><spring:message code="label.action"></spring:message></th>
									          </tr>
									         </thead>
									         <tbody class="dataTables-Main-Body" ng-repeat="objEntityAddress in manageVendorObj.customerContactobj">
									          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" >           
									          <td><label class="i-checks m-b-none"> 
												<input type="checkbox" data-ng-model="objEntityAddress.select"><i></i></label></td>         
									           <td>{{objEntityAddress.contactName}}</td>
								               <td>{{objEntityAddress.email}}</td>
									           <td>{{objEntityAddress.mobile}}</td> 												          
									           <td>{{objEntityAddress.phone}}</td>
									          <!-- <td class=" td-actions text-center">
										        <span>
										         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objEntityAddress)"></i>
										        </span>
										        <span>
										         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objEntityAddress)"></i>
										        </span>
									       	 </td> -->
									          </tr>
									         </tbody>
									    </table>
									    <div class="padding-left-10 padding-top-5" id="AddOrRmveMeritbtn">
										    <button class="btn btn-sm btn-primary" ng-click="addNewContactDialog()"  type="button">
									         <i class="fa fa-plus"></i>
									     	</button>		
									     		<button ng-click="deleteAddressRow()"
															class="btn btn-sm btn-danger" type="button"
															tooltip="Delete">
															<i class="fa  fa-trash-o"></i>
														</button>
									     							          
								      	</div>							        
							       </div>
								</div>											  
								 		
        					</div>
        				</tab>
        				<!-- <tab heading="Internal Notes">
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
        							<fieldset>
				      					<div class="form-group">
						             		<div class="col-md-12">
						             			<textarea type="text" class="form-control input-sm"
						               				rows="4" cols="25" placeholder="Put an Internal Note..."
						               				name=".internalNotes"
						               				ng-model="manageVendorObj.internalNotes"
						               				style="resize: none"></textarea>
						             		</div>
								       </div>
					      			</fieldset>
				      			</div>
				     		</div>
        				</tab>
        				<tab heading="Purchase" id="purchaseTab">
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
		          					<div class="col-sm-6 col-md-6 col-lg-6">
		           						<fieldset>
								            <div class="form-group">
								             	<label class="col-md-4 control-label">Responsible Person <span style="color:red;"> *</span></label>
								             		<div class="col-md-7">
									             		<selectivity list="employeeList" property="manageVendorObj.responsiblePersonPurchase" id="responsiblePersonPurchase"
									        				ng-model="manageVendorObj.responsiblePersonPurchase" name="responsiblePersonPurchase" form-name = "manageCustomerAddForm"
									        				validation="required" friendly-name="Responsible Person In Pursche Tab"></selectivity>
								             		</div>
									        </div>
									        
		           						</fieldset>
		          					</div>
		          					<div class="col-sm-6 col-md-6 col-lg-6">
		          						<div class="form-group">
							             	<label class="col-md-4 control-label">Delivery Method</label>
							             		<div class="col-md-6">
									              	<select class="form-control" name="deliveryMethod" id="deliveryMethod"
									              		data-ng-model="manageVendorObj.deliveryMethod" validation="required" friendly-name="Delivery Method in Purchase Tab">
									               		<option value="">Select</option>
									               		<option value="inPerson">In Person</option>
									               		<option value="courier">Courier</option>
									              	</select>
							             		</div>
								        </div>
		          					</div>
		         				</div>		         				
        					</div>
        				</tab> -->
        				<tab heading="Accounting"><br>
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12">
	        						<div class="col-sm-6 col-md-6 col-lg-6">
	        							<fieldset>
	        								<div class="form-group">
								           		<label class="bold">

Supplier</label>
								           </div>
	        							</fieldset>
	        						</div>
	        					</div>
        						<div class="col-sm-12 col-md-12 col-lg-12">
		          					<div class="col-sm-6 col-md-6 col-lg-6">
		           						<fieldset>
		           							<div class="form-group">
							             	<label class="col-md-4 control-label"> Supplier Payment Term
Days</label>
							             		<div class="col-md-6">
										           <input type="text" class="form-control pull-left" data-ng-model="manageVendorObj.vendorPaymentTerm" numbers-only />
										           <!-- <select class="form-control" data-ng-model="manageCustomerObj.custPaymentTerm" 
										           data-ng-options="ci.paymentId as ci.paymentTerms for ci in paymentList">
													            <option value="" selected="selected">Select</option>
													      </select> --> 
							             		</div>
							             		 <span class="pull-left line-height-30">Days</span>
							             		<!-- <div class="col-md-7">
								           			<select class="form-control" data-ng-model="manageVendorObj.vendorPaymentTerm" 
								           				data-ng-options="ci.paymentId as ci.paymentTerms for ci in paymentList">
											            <option value="" selected="selected">Select</option>
											      	</select> 
							             		</div> -->
								        </div>
								            <div class="form-group">
								             	<label class="col-md-4 control-label"><spring:message code="label.entity.accountReceivable"></spring:message></label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="<spring:message code="label.manageName"></spring:message>" id="manageName"
								               			data-message-id="Name"
								               			data-ng-model="entityObj.accountReceivable" 
								               			data-validator="required" data-valid-method="submit">
								             	</div>
								            </div>
									        <div class="form-group">
								             	<label class="col-md-4 control-label"><spring:message code="label.entity.totalReceivable"></spring:message></label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="<spring:message code="label.manageName"></spring:message>" id="manageName"
								               			data-message-id="Name"
								               			data-ng-model="entityObj.totalReceivable" 
								               			data-validator="required" data-valid-method="submit">
								             	</div>
								            </div>
		           						</fieldset>
		          					</div>
		          					<div class="col-sm-6 col-md-6 col-lg-6">
	          						
								  		<div class="form-group">
							             	<label class="col-md-4 control-label">Credit Limits</label>
							             	<div class="col-md-7">
							              		<input type="text" class="form-control input-sm" 
							               			name="manageName" id="manageName"
							               			data-message-id="Name"
							               			data-ng-model="manageVendorObj.vendorCreditLimit" 
							               			data-validator="required" data-valid-method="submit" phonenumbers-only>
							             	</div>
							            </div>
		          					</div>
		         				</div>
        					</div>
        					<div class="row">
        						<div class="col-sm-12">
								     			
							       <div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
							        data-st-table="displayedCollection1"
							        data-st-safe-src="rowCollection1">
							        <table id="dt_basic" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid" aria-describedby="dt_basic_info">
								         <thead class="dataTables-Main-Head">
								          <tr>
								           <th class="width_1 text-center table-heading">
								          <!--   <label class="i-checks m-b-none">
								             <input type="checkbox">
								             <i></i>
								            </label> -->
								           </th>
								           <th class="sorting width_5" st-sort="bankName">Bank Name </th>
								           <th class="sorting width_5" st-sort="accountType">Account Type </th>
								           <th class="sorting width_5" st-sort="accountNo">Account No </th>
								           <th class="sorting width_5" st-sort="address">Address </th>
								           <th class="sorting width_5" st-sort="ifscCode">IFSC Code </th>
								           <th class="width_5 text-center table-heading"><spring:message code="label.action"></spring:message></th>
								          </tr>
								         </thead>
								         <tbody class="dataTables-Main-Body">
								          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objEntityAccount in manageVendorObj.customerBankobj">           
								           <td>
								          <label class="i-checks m-b-none"> 
												<input type="checkbox" data-ng-model="objEntityAccount.select"><i></i></label>  
										</td>
								           <td>{{objEntityAccount.bankName}}</td>
								           <td>{{objEntityAccount.accountType}}</td>
								           <td>{{objEntityAccount.accountNo}}</td>
								           <td>{{objEntityAccount.bankDetAddress}}</td>
								           <td>{{objEntityAccount.ifscCode}}</td>
								          <!-- <td class=" td-actions text-center">
									        <span>
									         <i class="fa  fa-pencil text-success text" data-ng-click="editRow(objEntityAccount)"></i>
									        </span>
									        <span>
									         <i class="fa fa-trash-o text-danger-dker text" data-ng-click="deleteRow(objEntityAccount)"></i>
									        </span>
								       	 </td> -->
								          </tr>
								         </tbody>
								        </table>
								        <div class="padding-left-10 padding-top-5" id="AddOrRmveMeritbtn">
										    <button class="btn btn-sm btn-primary" ng-click="addNewAccountingDialog()" type="button">
									         <i class="fa fa-plus"></i>
									     	</button>	
									     	<button ng-click="deleteBankRow()"
															class="btn btn-sm btn-danger" type="button"
															tooltip="Delete">
															<i class="fa  fa-trash-o"></i>
														</button>
									     								
									     								          
								      	</div>
								 
								</div>
        					</div>
        					</div>
        				</tab>
					</tabset>  --%>
					</form>
					<!-- /tabset - end -->
        			<div class="form-actions">
         				<div class="row">
          					<div class="col-md-12">
           						<button class="btn btn-success"
            						ng-if="!edit" type="button"
            						ng-click="validate(manageCustomerAddForm)">
            						<i class="fa fa-save"></i>
Save    						
</button>
					           <button class="btn btn-success"
					            ng-if="edit" type="button"
					            ng-click="validate(manageCustomerAddForm)">
					            <i class="fa fa-save"></i>Update
					           </button>
					           <button class="btn btn-info ng-scope" type="button"
					            ng-click="reset()" class="btn btn-success">
					            <i class="fa fa-undo"></i>Reset
					           </button>
					           <button class="btn btn-danger" type="button"
					            class="btn btn-success" ng-click="cancel()">Cancel
					            <i class="fa fa-close"></i>
					           </button>
          					</div>
         				</div>
        			</div>
       		
      		</div>
     	</div>
    </div>
   </article>
  </div>
 </section>
</div>