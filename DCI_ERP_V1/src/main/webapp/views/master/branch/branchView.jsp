<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form class="form-horizontal" name="branchMasterForm">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>


							<div class="form-group">
								<label class="col-md-6 control-label"> Branch Code <span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm" maxlength=6
										ng-model="branchMaster.branchCode" name="Branch Code"
										validation="required" form-name="branchMasterForm"
										friendly-name="Branch Code" disabled> -->
										
								<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.branchCode}}</label>				
										
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 control-label"> Branch Name<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm" maxlength=250
										validation="required" form-name="branchMasterForm"
										friendly-name="Branch Name" ng-model="branchMaster.branchName"
										name="Branch name" disabled/> -->
							<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.branchName}}</label>				
										
										
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 control-label">Company<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <selectivity list="companyList"
										property="branchMaster.companyId" id="Company"
										ng-model="branchMaster.companyId" name="Company"
										form-name="branchMasterForm" validation="required"
										friendly-name="Company" disabled ="true"></selectivity> -->
							<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.companyName}}</label>				

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Currency<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <selectivity list="currencyList"
										property="branchMaster.currencyId" id="currency"
										ng-model="branchMaster.currencyId" name="currency"
										form-name="branchMasterForm" validation="required"
										friendly-name="currency" disabled ="true"></selectivity> -->
						<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.currencyName}}</label>				
										
										
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-6 control-label"> Branch Address
								</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"maxlength=100
										 form-name="branchMasterForm"
										friendly-name="Branch Name" ng-model="branchMaster.address"
										name="Branch name" disabled/> -->
										
							<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.address}}</label>				
										

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"maxlength=100
										 form-name="branchMasterForm"
										friendly-name="Branch Name" ng-model="branchMaster.address1"
										name="Branch name" disabled/> -->
										
								<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.address1}}</label>				
										

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"maxlength=100
										 form-name="branchMasterForm"
										friendly-name="Branch Name" ng-model="branchMaster.address2"
										name="Branch name" disabled/> -->
				<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.address2}}</label>				
										
										

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">City<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <selectivity list="cityList"
										property="branchMaster.cityId" id="city"
										ng-model="branchMaster.cityId" name="city"
										form-name="branchMasterForm" 
										friendly-name="city" disabled ="true"></selectivity> -->
								
					<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.cityName}}</label>				
								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label">Country<span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <selectivity list="countryList"
										property="branchMaster.countryId" id="country"
										ng-model="branchMaster.countryId" name="country"
										form-name="branchMasterForm" 
										friendly-name="country" disabled ="true"></selectivity> -->
										
				<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.countryName}}</label>				
										
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-6 control-label"> Zip/Postal Code
								</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"maxlength=10
										 form-name="branchMasterForm"
										friendly-name="Pin Code" ng-model="branchMaster.pinCode"
										ng-pattern-restrict="^[0-9]*$" name="pincode" disabled/> -->
						<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.pinCode}}</label>				
										
										
								</div>
							</div>
							

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Phone No
								</label>
								<div class="col-md-5">
								<!-- 	<input type="text" class="form-control input-sm"maxlength=15
										 form-name="branchMasterForm"
										friendly-name="Phone" ng-model="branchMaster.phoneNumber"
										name="Phone" ng-pattern-restrict="^[0-9]*$" disabled/> -->
							<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.phoneNumber}}</label>				
										
										
								</div>
							</div>
                            <div class="form-group">
								<label class="col-md-4 control-label"> Fax No
								</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"maxlength=15
										 form-name="branchMasterForm"
										friendly-name="Phone" ng-model="branchMaster.faxNo"
										name="Phone" ng-pattern-restrict="^[0-9]*$" disabled/> -->
							<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.faxNo}}</label>				
										
										
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> PAN No 
								</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"maxlength=50
										ng-model="branchMaster.panNo" name="PAN No"
										form-name="branchMasterForm"
										friendly-name="PAN No" disabled> -->
										
					<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.panNo}}</label>				
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">GSTN State Code <span
									style="color: red;"></span> </label>
								<div class="col-md-5">
									<!-- <selectivity list="gstnStateList"
										property="branchMaster.gstnCode" id="GSTN State Code"
										ng-model="branchMaster.gstnCode" name="GSTN State Code" validation="required"
										form-name="branchMasterForm" friendly-name="GSTN State Code" disabled ="true"></selectivity> -->
										
						<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.stateName}}</label>				
										
										

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> GSTN No 
								</label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"maxlength=15
										ng-model="branchMaster.gstnNo" name="City"
										form-name="branchMasterForm"
										friendly-name="City" disabled/> -->
										
					<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.gstnNo}}</label>				
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Service Tax No </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"maxlength=50
										ng-model="branchMaster.serviceTaxNo" name="Service Tax No"
										 form-name="branchMasterForm"
										friendly-name="Service Tax No" disabled/> -->
										
								<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.serviceTaxNo}}</label>				
										

								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Licence No </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"maxlength=100
										ng-model="branchMaster.licenceNo" name="Licence No"
										 form-name="branchMasterForm"
										friendly-name="Licence No" disabled/>
 -->
 
 					<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.licenceNo}}</label>				
 
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Active </label>
								<div class="col-md-5">
									<div class="checkbox">
										<label> <input class="checkbox style-0"
											type="checkbox" name="active"
											ng-model="branchMaster.isActive" disabled> <span></span>
										</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Default UOM <span
									style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <selectivity list="uomList"
										property="branchMaster.uom" id="Default UOM"
										ng-model="branchMaster.uom" name="Default UOM"
										validation="required" form-name="branchMasterForm"
										friendly-name="Default UOM" disabled ="true"></selectivity>
 -->
 
  					<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.uom1}}</label>				
 
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Logo In Documents
									<span style="color: red;"></span>
								</label>
								<div class="col-md-5">
									<!-- <selectivity list="logoPathList"
										property="branchMaster.logoPath" id="Logo In Documents"
										ng-model="branchMaster.logoPath" name="Logo In Documents"
										validation="required" form-name="branchMasterForm"
										friendly-name="Logo In Documents" disabled ="true"></selectivity> -->
										
			  					<label style="padding-top: 9px;padding-left: 10px;">{{branchMaster.logopath1}}</label>				
										
										

								</div>
							</div>
							<!-- <div class="form-group"  align="center" ng-if="file">
								<img src="{{branchMaster.photo}}" class="thumb-image"
											style="max-height: 206px; width: 478px;">	
							<div></div>					
							<label class="col-md-5 control-label"style="left: -147px;">File Upload </label>
								<div class="col-md-7"style="padding-right:257px">
								<div class="input-group">
								 <span class="btn btn-success fileinput-button"> 
        <i class="glyphicon glyphicon-plus"></i>
        <span>Select files...</span>
       
        <input id="fileupload" type="file" onchange="angular.element(this).scope().uploadFile(this)" accept=".xls,.png,.jpg">
                         </span>
								
									</div>
								</div>
							</div> -->
						</fieldset>
					</div>
				</div>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
<!-- 								<th colspan=1 class="width_1"></th>
 -->								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_15 text-center">Bank Name<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_20 text-center">Bank Address<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Account No</th>
								<th colspan=1 class="width_15 text-center">SWIFT Code<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">IFSC Code<span
									style="color: red;"> </span></th>

								<th colspan=1 class="width_15 text-center">IBAN No<span
									style="color: red;"> </span></th>

								<th colspan=1 class="width_15">Active</th>
							</tr>
						</thead>
						<tbody ng-repeat="($index,row) in branchBank">
							<tr>
							<!-- 	<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td> -->
								<td>
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"maxlength=100
												data-ng-model="row.bankName" name="ContactName{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(ContactName)'}}" readonly/> -->
										
				  					<label style="padding-top: 9px;padding-left: 10px;">{{row.bankName}}</label>				
										
										
										</div>
									</div>
								</td>


								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"maxlength=255
												data-ng-model="row.bankAddress"
												name="Designation{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Narration)'}}" readonly/> -->
												
								<label style="padding-top: 9px;padding-left: 10px;">{{row.bankAddress}}</label>				
												
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"maxlength=50
												data-ng-model="row.accountNo" name="Designation{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Narration)'}}" readonly/> -->
																	<label style="padding-top: 9px;padding-left: 10px;">{{row.accountNo}}</label>				
												
												
										</div>
									</div>
								</td>
									<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"maxlength=50
												data-ng-model="row.shiftCard" name="Skype{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Skype)'}}" readonly/> -->
									<label style="padding-top: 9px;padding-left: 10px;">{{row.shiftCard}}</label>				
										
										
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"maxlength=50
												data-ng-model="row.ifscCode" name="MobileNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(MobileNo)'}}" readonly/> -->
												
					<label style="padding-top: 9px;padding-left: 10px;">{{row.ifscCode}}</label>				
												
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"maxlength=50
												data-ng-model="row.ibanNo" name="Skype{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Skype)'}}" readonly/> -->
												
												<label style="padding-top: 9px;padding-left: 10px;">{{row.ibanNo}}</label>				
												
										</div>
									</div>
								</td>
							


								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.bankActive"
										id="section{{trIndex}}" disabled><i></i></label></td>
								<td>
							</tr>
						</tbody>
						<!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->

					</table>
					
					<br> <br> <br>
				</div>
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

