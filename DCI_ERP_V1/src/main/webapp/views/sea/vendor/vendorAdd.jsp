<div class="wrapper-md">
	<div class="panel panel-default panel-default-form">
		  <%@include file="/views/templates/panel-header-form.jsp"%>  
		<div class="panel-body">
			<div role="content">
				<div class="widget-body">
					<form class="form-horizontal" id="manageCustomerAddForm"
						name="manageCustomerAddForm" novalidate method="post">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12">
								<div class="col-sm-6 col-md-6 col-lg-6">
									<fieldset>
										<div class="form-group">
											<label class="col-md-4 control-label">Vendor Name <span
												style="color: red;"> *</span>
											</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="manageName" id="entityName"
													data-ng-model="manageVendorObj.entityName"
													ng-blur="checkVendorName(manageVendorObj.entityName,manageVendorObj.entityId)"
													validation="required" friendly-name="Vendor Name" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Contact Person</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name=" contactPerson" id="contactPerson"
													data-ng-model="manageVendorObj.contactPerson"
													data-validator="required" data-valid-method="submit">
											</div>
										</div>
									
										<div class="form-group">
											<label class="col-md-4 control-label">PAN Number</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="PanNymber" id="PANNumber"
													data-ng-model="manageVendorObj.panNumber"
													data-validator="required" data-valid-method="submit"
													maxlength="10" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">GST </label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="GSTNumber" id="GSTNumber"
													ng-keyup="isNumericValidation(this.GSTNumber)"
													data-ng-model="manageVendorObj.gstNumber" maxlength="50" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label"> Address
											<!-- 	<span style="color: red;"> *</span> -->
											</label>
											<div class="col-md-7">
												<div class=" no-padding">
													<textarea class="text-left form-control input-sm"
														id="locationAddress" name="locationAddress"
														ng-model="manageVendorObj.locationAddress" rows="2"
														cols="15" placeholder="Street" style="resize: none"
														friendly-name="Street"> </textarea>
												</div>
												
											</div>
										</div>
										
										<div class="form-group visible-left">
											<label class="col-md-4 control-label "> Is Vendor</label>
											<div class="col-md-7">
												<div class="checkbox">
													<label> <input type="checkbox"
														class="checkbox style-0"
														data-ng-model="manageVendorObj.isVendor"
														ng-disabled="edit" data-ng-true-value="'Y'"
														data-ng-false-value="'N'" /> <span></span>
													</label>
												</div>
											</div>
										</div>
									</fieldset>
								</div>
								<div class="col-sm-6 col-md-6 col-lg-6">
									<fieldset>
									 
										<div class="form-group">
											<label class="col-md-4 control-label">Mobile</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="mpbile" id="mobile"
													data-ng-model="manageVendorObj.mobile"
													ng-blur="validateMobileNo(manageVendorObj.mobile)"
													maxlength="10" phonenumbers-only />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Phone</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="phone" id="phone"
													data-ng-model="manageVendorObj.phoneNo"
													ng-blur="validatePhoneNo(manageVendorObj.phoneNo)"
													maxlength="8" phonenumbers-only /> <span
													ng-show='manageCustomerAddForm.$invalid'> phone must
													be valid. </span>
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Fax</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm" name="fax"
													id="fax" data-ng-model="manageVendorObj.fax"
													data-validator="required" data-valid-method="submit"
													maxlength="20" phonenumbers-only />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Website</label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="website" id="website"
													data-ng-model="manageVendorObj.website"
													placeholder='www.yourwebsite.com' data-validator="required"
													data-valid-method="submit" />
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-4 control-label">Email
											<!-- <span style="color: red;"> *</span> --></label>
											<div class="col-md-7">
												<input type="text" class="form-control input-sm"
													name="email" id="email"
													data-ng-model="manageVendorObj.email"
													placeholder='your@email.com' 
													friendly-name="Email" />
											</div>
										</div>
										  
									</fieldset>
								</div>
								
								<!-- second row start -->
						
						<div class="col-sm-12 col-md-12 col-lg-12"><hr>
							<div class="col-sm-6 col-md-6 col-lg-6"> 
							<fieldset>
									<div class="form-group">
										<label class="col-md-4 control-label"> Payment Term (In Days)
											</label>
										<div class="col-md-6">
											<input type="text" class="form-control input-sm"
												data-ng-model="manageVendorObj.vendorPaymentTerm" 
												numbers-only placeholder="In Days" /> 
										</div>
										<span class="pull-left line-height-30">Days</span>
									</div>	 
									</fieldset>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
							<fieldset>
									<div class="form-group">
										<label class="col-md-4 control-label">Credit Limits</label>
										<div class="col-md-7">
											<input type="text" class="form-control input-sm"
												name="manageName" id="manageName" data-message-id="Name"
												data-ng-model="manageVendorObj.vendorCreditLimit"
												data-validator="required" data-valid-method="submit"
												phonenumbers-only />
										</div>
									</div>		
									</fieldset>							
								</div>
						</div>
								
							</div>
						</div>

						
						
						<!-- data tables start-->											
								<div class="dataTables_wrapper form-inline dt-bootstrap no-footer ui-jqgrid ui-corner-all"
									data-st-table="displayedCollection1"
									data-st-safe-src="rowCollection1">
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr>
												<th class="width_1 text-center table-heading">
													<!--   <label class="i-checks m-b-none">
								             <input type="checkbox">
								             <i></i>
								            </label> -->
												</th>
												<th class="sorting width_5" st-sort="bankName">Bank
													Name</th>
												<th class="sorting width_5" st-sort="accountType">Account
													Type</th>
												<th class="sorting width_5" st-sort="accountNo">Account
													No</th>
												<th class="sorting width_5" st-sort="address">Address</th>
												<th class="sorting width_5" st-sort="ifscCode">IFSC
													Code</th>
												<!-- 								           <th class="width_5 text-center table-heading">Action</th>
 -->
											</tr>
										</thead>
										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="objEntityAccount in manageVendorObj.customerBankobj">
												<td><label class="i-checks m-b-none"> <input
														type="checkbox" data-ng-model="objEntityAccount.select"><i></i></label>
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
									<div class="padding-left-10 padding-top-5"
										id="AddOrRmveMeritbtn">
										<button class="btn btn-sm btn-primary"
											ng-click="addNewAccountingDialog()" type="button">
											<i class="fa fa-plus"></i>
										</button>
										<button ng-click="deleteBankRow()"
											class="btn btn-sm btn-danger" type="button" tooltip="Delete">
											<i class="fa  fa-trash-o"></i>
										</button>
									</div>

								</div>							
						<!-- tabset - start -->				
					 
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12 padding-top-10">
								<fieldset>
									<div class="form-group">
										<div class="col-md-12">
											<textarea type="text" class="form-control input-sm" rows="2"
												cols="45" placeholder="Put an Internal Note..."
												name=".internalNotes"
												ng-model="manageVendorObj.internalNotes"
												style="resize: none"></textarea>
										</div>
									</div>
								</fieldset>
							</div>
						</div>
					 
					
					</form>
					<!-- /tabset - end -->
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-success" ng-if="!edit" type="button"
									ng-click="validate(manageCustomerAddForm)">
									<i class="fa fa-save"></i> Save
								</button>
								<button class="btn btn-success" ng-if="edit" type="button"
									ng-click="validate(manageCustomerAddForm)">
									<i class="fa fa-save"></i>Update
								</button>
								<button class="btn btn-info ng-scope" type="button"
									ng-click="reset()" class="btn btn-success">
									<i class="fa fa-undo"></i>Reset
								</button>
								<button class="btn btn-danger" type="button"
									class="btn btn-success" ng-click="cancel()">
									Cancel <i class="fa fa-close"></i>
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