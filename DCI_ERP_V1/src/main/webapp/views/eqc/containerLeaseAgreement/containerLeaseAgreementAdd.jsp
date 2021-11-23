
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<style>
	.dropdown-menu {
    min-width: 235px !important;
}
	</style>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="LeaseAgreementForm" class="form-horizontal" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label">Lessor/Owner<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="agreementParty"
										property="leaseAgreement.agreementParty" id="agreementParty"
										ng-model="leaseAgreement.agreementParty" name="agreementParty"
										validation="required" friendly-name="agreementParty" validaton="required"
										form-name="LeaseAgreementForm" required></selectivity>
								</div>
							</div>
							<!-- 
							<div class="form-group">
								<label class="col-md-4 control-label">Agreement Date<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" data-ng-model="leaseAgreement.agreementDate" 
										id="agreementDate" name="agreementDate" form-name="LeaseAgreementForm" 
										friendly-name="agreementDate" validaton="required" />
								</div>
							</div>
							 -->
							 
							  <div class="form-group">
        <label class="col-md-4 control-label">
        Agreement Date
        
        </label>
        <label class="col-md-1 control-label">{{leaseAgreement.agreementDate}}</label>
       </div>
							 
			
							<div class="form-group">
								<label class="col-md-4 control-label">Agreement Type <span
									style="color: red;">*</span>
								</label>
								<div class="col-md-5">
									<selectivity list="agreementType"
										property="leaseAgreement.agreementType" id="agreementType"
										ng-model="leaseAgreement.agreementType" name="agreementType"
										validation="required" friendly-name="agreementType" validaton="required"
										form-name="LeaseAgreementForm" required></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">Currency
								</label>
								<div class="col-md-5">
									<selectivity list="currency"
										property="leaseAgreement.currency" id="currency"
										ng-model="leaseAgreement.currency" name="currency"
										 friendly-name="currency"
										form-name="LeaseAgreementForm" ></selectivity>
								</div>
							</div>
						
						<div class="form-group">
								<label class="col-md-4 control-label">Lessee
								</label>
								<div class="col-md-5">
									<selectivity list="leasingParty"
										property="leaseAgreement.leaseAgreementParty" id="leaseAgreementParty"
										ng-model="leaseAgreement.leaseAgreementParty" name="leaseAgreementParty"
										 friendly-name="leaseAgreementParty"
										form-name="LeaseAgreementForm" ></selectivity>
								</div>
							</div>
							
							

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>

							<div class="form-group">
								<label class="col-md-4 control-label"> Agreement No. <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="agreementRefNo" id="agreementRefNo"
										ng-model="leaseAgreement.agreementRefNo" disabled="disabled"
										friendly-name="agreementRefNo" validaton="required" form-name="LeaseAgreementForm"/>
								</div>
							</div>
						<div class="form-group">
								<label class="col-md-4 control-label">From Date<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="leaseAgreement.fromDate" 
										id="fromDate" name="fromDate" form-name="LeaseAgreementForm" 
										friendly-name="fromDate" validaton="required" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label">To Date<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="leaseAgreement.toDate"
										id="toDate_id" name="toDate_id" form-name="LeaseAgreementForm" 
										friendly-name="toDate" validaton="required"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label">Lease Agreement No.
								</label>
								<div class="col-md-5">
								<input type="text" class="form-control input-sm"
										name="partyAgreementNo" id="partyAgreementNo"
										ng-model="leaseAgreement.partyAgreementNo"  
										friendly-name="partyAgreementNo" form-name="LeaseAgreementForm"/>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-4 control-label">Lease Terms
								</label>
								<div class="col-md-5">
								<textarea class="form-control input-sm" name="leaseterms"
													id="leaseterms" maxlength="150"
													data-ng-model="leaseAgreement.leaseterms"
													style="resize: none" friendly-name="Address During Leave"
													form-name="LeaseAgreementForm"></textarea>
								<!-- <input type="text" class="form-control input-sm"
										name="leaseterms" id="leaseterms"
										ng-model="leaseAgreement.leaseterms"  
										friendly-name="leaseterms" form-name="LeaseAgreementForm"/> -->
								</div>
							</div>
							
							
							
							
							
						</fieldset>
					</div>
				</div>
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_8 text-center">Country<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_8 text-center">Port<span
									style="color: red;"> </span></th>
								
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_10 text-center">No. of Containers<span
									style="color: red;"> </span></th>
									
									<th colspan=1 class="width_8 text-center">Free Days<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_8 text-center">Rental<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_8 text-center">Pick-up Charge<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_8 text-center">Drop-off Charge<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_8 text-center">Replacement Value<span
									style="color: red;"> </span></th>
									<!-- <th colspan=1 class="width_8 text-center">Handle Charge<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_8 text-center">Tax<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_10 text-center">P.U.Credit<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_10 text-center">D.O.Credit<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_10 text-center">D.I Charge<span
									style="color: red;"> </span></th> -->
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in leaseAgreement.leaseAgreementDtl" >
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								
									<td class="width_15">
									<div class="row ">
										<div class="col-xs-12 datetimepicker_country">
											<select id="country{{trIndex}}" multiple="multiple" name="country{{trIndex}}"
											data-ng-model="row.country"
											ng-options="option.text for option in countrylist"
											friendly-name="{{ 'Row' + $index + '(country)'}}" ng-change="countryport(row, trIndex)" data-dropdownmultiselect>
											<option data-ng-repeat="option in countrylist"
												value="{{getOptionId(option)}}"
												ng-selected="isOptionSelected(option)"
												data-ng-bind-template="{{option.text}}" ></option>
												
										</select>
											

										</div>
									</div>
								</td>
									<td class="width_15">
									<div class="row">
										<div class="col-xs-12 datetimepicker_port "  >

											<!-- <selectivity list="port"
												property="row.port"
												id="port{{trIndex}}"
												data-ng-model="row.port"
												name="port{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(port)'}}"
												form-name="LeaseAgreementForm"></selectivity> -->
												
												<select id="port{{trIndex}}" multiple="multiple" name="port{{trIndex}}"
											data-ng-model="row.port"
											ng-options="option.text for option in row.portList"
											friendly-name="{{ 'Row' + $index + '(port)'}}"  data-dropdownmultiselect>
											<option data-ng-repeat="option in row.portList"
												value="{{getOptionId(option)}}"
												ng-selected="isOptionSelected(option)"
												data-ng-bind-template="{{option.text}}" ></option>
												
										</select>

										</div>
									</div>
								</td>
								<!-- <td class="width_15">
									<div class="row">
										<div class="col-xs-12 datetimepicker_returnport "  >

											<selectivity list="port"
												property="row.port"
												id="port{{trIndex}}"
												data-ng-model="row.port"
												name="port{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(port)'}}"
												form-name="LeaseAgreementForm"></selectivity>
												
												<select id="returnport{{trIndex}}" multiple="multiple" name="returnport{{trIndex}}"
											data-ng-model="row.returnport"
											ng-options="option.text for option in row.portList"
											friendly-name="{{ 'Row' + $index + '(returnport)'}}"  data-dropdownmultiselect>
											<option data-ng-repeat="option in row.portList"
												value="{{getOptionId(option)}}"
												ng-selected="isOptionSelected(option)"
												data-ng-bind-template="{{option.text}}" ></option>
												
										</select>

										</div>
									</div>
								</td> -->
								
								
								<td class="width_12">
									<div class="row">
										<div class="col-xs-10">

											<selectivity list="containerType"
												property="row.containerType"
												id="containerType{{trIndex}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="containerOffHireForm"></selectivity>

										</div>
									</div>
								</td>

								<td class="width_12">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.noOfContainer"
												name="noOfContainer{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(noOfContainer)'}}" />
										</div>
									</div>
								</td>
								
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.freedays" name="freedays{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(freedays)'}}" />
										</div>
									</div>
								</td>
								<td class="width_12">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.rental" name="rental{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(rental)'}}" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.pickupCharge" name="pickupCharge{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(pickupCharge)'}}" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.dropupCharge" name="dropupCharge{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(dropupCharge)'}}" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.replacementValue" name="replacementValue{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(replacementValue)'}}" />
										</div>
									</div>
								</td>
								
								<!-- <td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.handleCharge" name="handleCharge{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(handleCharge)'}}" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.tax" name="tax{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(tax)'}}" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.puCredit" name="puCredit{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(puCredit)'}}" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.doCredit" name="doCredit{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(doCredit)'}}" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.diCharge" name="diCharge{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(diCharge)'}}" />
										</div>
									</div>
								</td> -->
							</tr>
						</tbody>
						<!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->

					</table><br><br><br><br>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addCredRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCredRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br> <br> <br>
				</div>
				
				
			
				
				<div class="table-responsive clear" style="padding-bottom:4%;">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>
								<th colspan=1 class="width_15 text-center">Off-hire Location</th>
								<th colspan=1 class="width_20 text-center">Quota</th>
							
							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in leaseAgreement.leaseAgreementdtlNew">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td class="width_20">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="leaseport"
										property="row.leaseport" id="leaseport{{trIndex}}"
										data-ng-model="row.leaseport" name="leaseport{{trIndex}}"
										friendly-name="{{ 'Row' + $trindex + '(leaseport)'}}"
										form-name="containerOffHireForm"></selectivity>
										</div>
									</div>
								</td>								
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=50
												data-ng-model="row.quota" name="quota{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(quota)'}}" />
										</div>
									</div>
								</td>
								
								
								
								
								
							</tr>
						</tbody>
						<!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->

					</table><br><br><br>
					<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addCredRow1()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeCredRow1()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br> <br> <br>
				</div>
				
				
				
				
				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button"
								ng-if="!isEdit" class="btn btn-success"
								ng-click="save(containerOffHireForm,leaseAgreement)">
								<i class="fa fa-save"></i> Save

							</button>
							<button class="btn btn-success" type="button"
								ng-if="isEdit" class="btn btn-success"
								ng-click="update(containerOffHireForm,leaseAgreement)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-info" type="button"
								data-ng-click="reset(containerOffHireForm)">
								<i class="fa fa-undo"></i> Reset
							</button>
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
