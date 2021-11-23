
<style>
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<security:authentication var="user" property="principal" />
<input type="hidden" value="${form_code}" id="form_code_id">
<input type="hidden" value="${user.userId}" id="dumm">
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<form class="form-horizontal" name="manageCustomerAddForm">
			<div class="row">
				<br>
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="col-sm-6 col-md-6 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Name of Customer <span
									style="color: red;"> *</span>
								</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="manageName" id="entityName"
										data-ng-model="manageCustomerObj.entityName"
										validation="required" friendly-name="companyName"
										form-name="manageCustomerAddForm"
										ng-blur="checkCustomerName(manageCustomerObj.entityName,manageCustomerObj.entityId)" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Address</label>
								<div class="col-md-7">
									<div class=" no-padding">
										<textarea class="text-left form-control input-sm"
											ng-model="manageCustomerObj.locationAddress" rows="2"
											cols="15" placeholder="Street" style="resize: none"
											maxlength="200"> </textarea>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-7 col-md-offset-4 no-padding padding-top-5">
									<selectivity list="mainCityList"
										property="manageCustomerObj.cityId" id=cityId"></selectivity>
								</div>
		
								 <div class=" col-md-offset-4 no-padding padding-top-5">
									<div class="col-md-5 no-padding padding-top-5">
										<input type="hidden" class="form-control input-sm"
											placeholder="State" ng-model="manageCustomerObj.desStateCode" />
										<input type="text" class="form-control input-sm"
											placeholder="State" ng-model="manageCustomerObj.desState" />
									</div>
									<div class="col-md-5 padding-top-5">
										<input type="text" class="form-control input-sm"
											placeholder="Zip" ng-model="manageCustomerObj.desZipcode" />
									</div>
								</div>

								<div class="col-md-7 col-md-offset-4  no-padding padding-top-5">
									<input type="hidden" class="form-control input-sm"
										placeholder="Country"
										ng-model="manageCustomerObj.desCountryCode" /> <input
										type="text" class="form-control input-sm"
										placeholder="Country" ng-model="manageCustomerObj.desCountry" />
								</div>
							</div>
							<!-- <div class="form-group">
						             	<label class="col-md-4 control-label">TIN Number</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="TINNumber" id="TINNumber"
						               			data-ng-model="manageCustomerObj.tinNumber" ng-keyup="isNumericValidation(this.TINNumber)" 
						               			maxlength="50" numbers-only />
						             	</div>
						            </div> -->

							<div class="form-group">
								<label class="col-md-4 control-label">PAN </label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="PANNumber" id="PANNumber"
										data-ng-model="manageCustomerObj.panNumber" maxlength="10" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">GST</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="CSTNumber" id="CSTNumber"
										data-ng-model="manageCustomerObj.cstNumber" maxlength="50" />
								</div>
							</div>

							<!-- 							      	<div class="col-sm-6 col-md-6 col-lg-6">
 -->
							<div class="form-group">
								<label class="col-md-4 control-label"> Payment Term</label>
								<div class="col-md-7">
									<input type="text" class="form-control pull-left"
										data-ng-model="manageCustomerObj.custPaymentTerm" numbers-only />
									<!-- <select class="form-control" data-ng-model="manageCustomerObj.custPaymentTerm" 
										           data-ng-options="ci.paymentId as ci.paymentTerms for ci in paymentList">
													            <option value="" selected="selected">Select</option>
													      </select> -->
								</div>
								<!-- 							             		 <span class="pull-left line-height-30">Days</span>
 -->
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Credit Limit</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="creditLimit" id="manageName" data-message-id="Name"
										data-ng-model="manageCustomerObj.creditLimit"
										data-validator="required" data-valid-method="submit">
								</div>
							</div>
							<!-- 		          					</div>
 -->
							<div class="form-group">
								<label class="col-md-4 control-label"> Active</label>
								<div class="col-md-7">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0"
											data-ng-model="manageCustomerObj.isActive"
											data-ng-true-value="'Y'" data-ng-false-value="'N'" /> <span></span>
										</label>
									</div>
								</div>
							</div>
							<div class="form-group visible-left">
								<label class="col-md-4 control-label"> Is Customer</label>
								<div class="col-md-7">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0"
											data-ng-model="manageCustomerObj.isCustomer"
											data-ng-true-value="'Y'" data-ng-false-value="'N'" /> <span></span>
										</label>
									</div>
								</div>
							</div>


							<!-- <div class="form-group">
					             		<label class="col-md-4 control-label"> Is Vendor</label>
					             			<div class="col-md-7">
							              		<div class="checkbox">
							               			<label> 
							               				<input type="checkbox" class="checkbox style-0" data-ng-model="manageCustomerObj.isVendor"  ng-disabled="edit" data-ng-true-value="'Y'" data-ng-false-value="'N'" />
							                			<span></span>
							               			</label>
							              		</div>
							             	</div>
					            	</div> -->


						</fieldset>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Contact Person </label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="contactPerson" id="contactPerson"
										data-ng-model="manageCustomerObj.contactPerson" maxlength="50" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Job Position</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm"
										name="jobPosition" id="jobPosition"
										data-ng-model="manageCustomerObj.jobPosition" maxlength="30" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Mobile</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="mobile"
										id="mobile" data-ng-model="manageCustomerObj.mobile"
										phonenumbers-only maxlength="10" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Phone</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="phone"
										id="phone" data-ng-model="manageCustomerObj.phoneNo"
										phonenumbers-only maxlength="10" /> <span
										ng-show='manageCustomerAddForm.$invalid'> phone must be
										valid. </span>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Fax</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="fax"
										id="fax" data-ng-model="manageCustomerObj.fax"
										data-validator="required" data-valid-method="submit"
										maxlength="20" phonenumbers-only />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Website</label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="website"
										id="website" data-ng-model="manageCustomerObj.website"
										placeholder='www.yourwebsite.com' data-validator="required"
										data-valid-method="submit" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Email</label>
								<div class="col-md-7">
									<input type="email" class="form-control input-sm" name="email"
										id="email" data-ng-model="manageCustomerObj.email"
										placeholder='your@email.com'
										ng-change="$scope.emailValidation(manageCustomerObj.email)"
										maxlength="50" />

								</div>
							</div>
							<!-- <div class="form-group">
						             	<label class="col-md-4 control-label">PAN Number</label>
						             	<div class="col-md-7">
						              		<input type="text" class="form-control input-sm" 
						               			name="PANNumber" id="PANNumber"
						               			data-ng-model="manageCustomerObj.panNumber"  maxlength="10" />
						             	</div>
						            </div> -->
							<div class="form-group">
								<label class="col-md-4 control-label"> Is Others</label>
								<div class="col-md-7">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0"
											data-ng-model="manageCustomerObj.isOthers" ng-disabled="edit"
											data-ng-true-value="'Y'" data-ng-false-value="'N'" /> <span></span>
										</label>
									</div>
								</div>
							</div>

							<div class="form-group ">
								<label class="col-md-4 control-label"> College</label>
								<div class="col-md-7">
									<div class="checkbox">
										<label> <input type="checkbox"
											class="checkbox style-0"
											data-ng-model="manageCustomerObj.isCollege"
											data-ng-true-value="'Y'" data-ng-false-value="'N'" /> <span></span>
										</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
			</div>
			<br>
			<!-- tabset - start -->
			<%-- <tabset>
        			 	<!-- /Address tab -->
        				<tab heading="Address">
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
        							<div class="col-sm-6 col-md-6 col-lg-6">
        								<div class="form-group">
							             	<label class="col-md-4 control-label"><spring:message code="label.entity.customerLocation"></spring:message></label>
						             		<div class="col-md-7">
						             			<selectivity list="locationList" property="manageCustomerObj.customerLocation" id="customerLocation"></selectivity>
						             		</div>
								        </div>
        								<div class="form-group">
							            	<label class="col-md-4 control-label"> Billing Address</label>
								            <div class="col-md-7">
									            <div class="col-md-12 no-padding">
									             	<textarea class="text-left form-control input-sm" ng-model="manageCustomerObj.billingAddress" rows="2" cols="15" style="resize: none"  maxlength="250"> </textarea>
									            </div>
										        <div class="col-md-12 no-padding">
											        <div class="col-md-5 no-padding padding-top-5">
														<selectivity list="billingCityList" property="manageCustomerObj.customerAddressobj[2].citybillingId" id="txtCitybillingId"></selectivity>
											        </div>
											        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
											        	<input type="hidden" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateCodeBilling" />
										             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateNameBilling" />
											        </div>
											        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
											        	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="manageEntityObj.pincodeBilling" />
											        </div>
										        </div>
										        <div class="col-md-12 no-padding padding-top-5">
									             	<input type="hidden" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryCodeBilling" />
										            <input type="text" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryNameBilling" />	
									            </div>
								            </div>
							            </div>	
	        							
							           
        							</div>
        							<div class="col-sm-6 col-md-6 col-lg-6">
        								<div class="form-group">
							            	<label class="col-md-4 control-label"> Shipping Address</label>
								            <div class="col-md-7">
									            <div class="col-md-12 no-padding">
									             	<textarea class="text-left form-control input-sm" ng-model="manageCustomerObj.shipAddress" rows="2" cols="15" style="resize: none"  maxlength="250"> </textarea>
									            </div>
										        <div class="col-md-12 no-padding">
											        <div class="col-md-5 no-padding padding-top-5">
														<selectivity list="shippingCityList" property="manageCustomerObj.customerAddressobj[0].cityAddressId" id=txtCityAddressId></selectivity>
											        </div>
											        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
											        	<input type="hidden" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateCodeAddress">
											             <input type="text" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateNameAddress">
											        </div>
											        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
											        	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="manageEntityObj.pincodeAddress" />
											        </div>
										        </div>
										        <div class="col-md-12 no-padding padding-top-5">
									             	<input type="hidden" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryCodeAddress" />
											             	<input type="text" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryNameAddress" />
									            </div>
								            </div>
							            </div>		        							
							             
							           <div class="form-group">
							            	<label class="col-md-4 control-label"> Delivery Address</label>
								            <div class="col-md-7">
									            <div class="col-md-12 no-padding">
									             	<textarea class="text-left form-control input-sm" ng-model="manageCustomerObj.deliveryAddress" rows="2" cols="15" style="resize: none"  maxlength="250"> </textarea>
									            </div>
										        <div class="col-md-12 no-padding">
											        <div class="col-md-5 no-padding padding-top-5">
														<selectivity list="deliveryCityList" property="manageCustomerObj.customerAddressobj[1].citydeliveryId" id=txtCitydeliveryId></selectivity>
											        </div>
											        <div class="col-md-4 no-padding padding-left-5 padding-top-5">
											        	<input type="hidden" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateCodedelivery">
										             	<input type="text" class="form-control input-sm" placeholder="state" ng-model="manageEntityObj.stateNamedelivery">
											        </div>
											        <div class="col-md-3 no-padding padding-left-5 padding-top-5">
											        	<input type="text" class="form-control input-sm" placeholder="zip" ng-model="manageEntityObj.pincodedelivery" />
											        </div>
										        </div>
										        <div class="col-md-12 no-padding padding-top-5">
									             	<input type="hidden" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryCodedelivery" />
										            <input type="text" class="form-control input-sm" placeholder="country" ng-model="manageEntityObj.countryNamedelivery" />
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
									           <th class="sorting" st-sort="contactName"> Name </th>
									           <th class="sorting" st-sort="email">Email </th>
									           <th class="sorting" st-sort="mobile">Mobile </th>
									        
									           <th class="sorting" st-sort="phone">Phone </th>
									           <th class="text-center table-heading"><spring:message code="label.action"></spring:message></th>
									          </tr>
									         </thead>
									         <tbody class="dataTables-Main-Body" ng-repeat="objEntityAddress in manageCustomerObj.customerContactobj">
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
										    <button class="btn btn-sm btn-primary" ng-click="addNewContactDialog()" type="button">
									         <i class="fa fa-plus"></i>
									     	</button>	
									     	<button ng-click="deleteAddressRow(manageCustomerObj.customerContactobj)"
															class="btn btn-sm btn-danger" type="button"
															tooltip="Delete">
															<i class="fa  fa-trash-o"></i>
														</button>
									     	<!--  <button class="btn btn-sm btn-primary" ng-click="addNewContactDialog()">
									         <i class="fa fa-plus"></i>
									     	</button>	 -->						          
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
						               				name="locationActivity"
						               				ng-model="manageCustomerObj.internalNotes"
						               				style="resize: none"></textarea>
						             		</div>
								       </div>
					      			</fieldset>
				      			</div>
				     		</div>
        				</tab>
        				<tab heading="Sales" id="salesTab">
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
		          					<div class="col-sm-6 col-md-6 col-lg-6">
		           						<fieldset>
								            <div class="form-group">
								             	<label class="col-md-4 control-label">Responsible Person<span style="color:red;">*</span></label>
								             		<div class="col-md-7">
								             		<selectivity list="employeeList" property="manageCustomerObj.responsiblePersonSales" name="responsiblePersonSales" ng-model="manageCustomerObj.responsiblePersonSales"  validation="required" friendly-name="Responsible Person" form-name = "manageCustomerAddForm"></selectivity>
								             		</div>
									        </div>
									        
		           						</fieldset>
		          					</div>
		          					<div class="col-sm-6 col-md-6 col-lg-6">
		          						<div class="form-group">
							             	<label class="col-md-4 control-label">Delivery Method<span style="color:red;">*</span></label>
							             		<div class="col-md-4">
									              	<select class="form-control" name="deliveryMethod" 
									              		data-ng-model="manageCustomerObj.deliveryMethod"
									               		validation="required" friendly-name="Delivery Method" form-name = "manageCustomerAddForm">
									               		<option value="">Select</option>
									               		<option value="inPerson">In Person</option>
									               		<option value="courier">Courier</option>
									              	</select>
							             		</div>
								        </div>
		          					</div>
		         				</div>		         				
        					</div>
        				</tab>
        				<tab heading="Accounting"><br>
        					<div class="row">
        						<div class="col-sm-12 col-md-12 col-lg-12">
	        						<div class="col-sm-6 col-md-6 col-lg-6">
	        							<fieldset>
	        								<div class="form-group">
								           		<label class="bold">Customer</label>
								           </div>
	        							</fieldset>
	        						</div>
	        					</div>
        						<div class="col-sm-12 col-md-12 col-lg-12">
		          					<div class="col-sm-6 col-md-6 col-lg-6">
		           						<fieldset>
								            <div class="form-group">
								             	<label class="col-md-4 control-label">Account Receivable</label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="manageName"
								               			data-message-id="Name"
								               			data-ng-model="entityObj.accountReceivable" 
								               			>
								             	</div>
								            </div>
									        <div class="form-group">
								             	<label class="col-md-4 control-label">Total Receivable</label>
								             	<div class="col-md-7">
								              		<input type="text" class="form-control input-sm" 
								               			name="totalReceivable"
								               			data-message-id="Name"
								               			data-ng-model="entityObj.totalReceivable" 
								               			>
								             	</div>
								            </div>
		           						</fieldset>
		          					</div>
		          					<div class="col-sm-6 col-md-6 col-lg-6">
	          							<div class="form-group">
							             	<label class="col-md-4 control-label"> Customer Payment Term</label>
							             		<div class="col-md-6">
										           <input type="text" class="form-control pull-left" data-ng-model="manageCustomerObj.custPaymentTerm" numbers-only />
										           <!-- <select class="form-control" data-ng-model="manageCustomerObj.custPaymentTerm" 
										           data-ng-options="ci.paymentId as ci.paymentTerms for ci in paymentList">
													            <option value="" selected="selected">Select</option>
													      </select> --> 
							             		</div>
							             		 <span class="pull-left line-height-30">Days</span>
								        </div>
								  		<div class="form-group">
							             	<label class="col-md-4 control-label">Credit Limit</label>
							             	<div class="col-md-7">
							              		<input type="text" class="form-control input-sm" 
							               			name="creditLimit" id="manageName"
							               			data-message-id="Name"
							               			data-ng-model="manageCustomerObj.creditLimit" 
							               			data-validator="required" data-valid-method="submit">
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
								            <!-- <label class="i-checks m-b-none">
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
								          <tr data-ng-class="$index % 2 == 0? 'even' : 'odd'" ng-repeat="objEntityAccount in manageCustomerObj.customerBankobj">           
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
									     	<button ng-click="deleteBankRow(manageCustomerObj.customerBankobj)"
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
					<button class="btn btn-success" ng-if="!edit" type="submit"
						ng-click="save(manageCustomerAddForm)">
						<i class="fa fa-save"></i>Save
					</button>
					<button class="btn btn-success" ng-if="edit" type="submit"
						ng-click="save(manageCustomerAddForm)">
						<i class="fa fa-save"></i> Update
					</button>
					<button class="btn btn-info ng-scope" type="submit"
						ng-click="reset(manageCustomerAddForm)" class="btn btn-success">
						<i class="fa fa-undo"></i>Reset
					</button>
					<button class="btn btn-danger" type="button"
						class="btn btn-success" ng-click="cancel()">
						<i class="fa fa-close"></i>Cancel
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