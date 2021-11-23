<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>

							<div class="form-group" ng-if="edit">
								<label class="col-md-5 control-label" style="padding-top: 10px;">Quotation
									No <span style="color: red">*</span>
								</label>
								<div class="col-md-7" style="padding-top: 15px;">
									<label style="padding-left: 14px;">{{quotation.quotationNo}}</label>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Customer <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="customerDropList1"
										property="quotation.customer" id="customer" name="customer"
										ng-model="quotation.customer" object="customer"
										friendly-name="Customer" validation="required"
										form-name="quotationForm" disabled="true"></selectivity>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label"> Customer Category
									<span style="color: red;">*</span>
								</label>
								<div class="col-md-7">

									<selectivity list="CustList" disabled="true"
										ng-model="quotation.custcategory"
										property="quotation.custcategory" id="custcategory"
										object="custcategory" validation="required"
										name="custcategory" friendly-name="Customer Category"
										form-name="CustomerMasterForm" disabled="true"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Address<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<textarea type="text" class="form-control input-sm"
										name="address" form-name="quotationForm"
										class="custom-scroll width_250 resize-none" rows="3"
										ng-model="quotation.address" disabled="true">
															</textarea>
								</div>
							</div>
							
								<div class="form-group ">
								<label class="col-md-5 control-label">Special<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="SpecialList" ng-model="quotation.special"
										 property="quotation.special"
										id="special" object="special" name="special" disabled="true"
										friendly-name="special"
										form-name="quotationForm"></selectivity>
															
								</div>
							</div>
							<div class="form-group "  ng-hide ="true";>
								<label class="col-md-5 control-label">Detention Tariff Type <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<selectivity list="tariffList" ng-model="quotation.detentionTariffType"
										 property="quotation.detentionTariffType"
										id="detentionTariffType" 
										friendly-name="detentionTariffType"
										form-name="quotationForm" disabled="true"></selectivity>
								</div>
							</div> 
						</fieldset>
					</div>
					
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Quotation Date <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker data-ng-model="quotation.quotationDate"
										id="quotationDate" name="QuotationDate"
										data-ng-change="checkDatesCL(quotation.quotationDate)"
										friendly-name="Valid From" validation="required"
										disabled="true" />
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Quote Valid Date<span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker data-ng-model="quotation.validTill"
										id="validTill" name="validTill"
										data-ng-change="checkDatesCL(quotation.validTill)"
										friendly-name="Valid From" validation="required"
										disabled="true" />
								</div>
							</div>

							<div class="form-group ">
								<label class="col-md-5 control-label">POL <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="polList" property="quotation.pol" id="pol"
										name="pol" ng-model="quotation.pol" object="pol"
										friendly-name="pol" validation="required"
										form-name="quotationForm" disabled="true"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">FPOD <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="portList" property="quotation.pod" id="pod"
										name="pod" ng-model="quotation.pod" object="pod"
										friendly-name="pod" validation="required"
										form-name="quotationForm" disabled="true"></selectivity>
								</div>
							</div>
							<div class="form-group">

								<label class="col-md-5 control-label">Status <span
									style="color: red"></span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="status"
										property="quotation.status" id="origin"
										ng-model="quotation.status" friendly-name="status"
										disabled="true" />
								</div>

							</div>

<div class="form-group ">
								<label class="col-md-5 control-label">Cargo Type<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="cargoType" ng-model="quotation.cargoType"
										 property="quotation.cargoType"
										id="cargoType" disabled="true"
										friendly-name="cargoType"
										form-name="quotationForm"></selectivity>
															
								</div>
							</div>


						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
                 <!-- third column -->
                 	
					<!-- 		<div class="form-group ">
								<label class="col-md-5 control-label">Agent<span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="employeeList"
										property="quotation.agent" id="agent"
										name="agent" ng-model="quotation.agent"
										object="agent" friendly-name="agent"
										 form-name="quotationForm"
										></selectivity>
							</div>
							</div> -->
							
								<!-- <div class="form-group ">
								<label class="col-md-5 control-label">Status<span
									style="color: red"></span></label>
								<div class="col-md-7">
										<input type="text" class="form-control input-sm"
										name="Status" 
										property="quotation.Status" id="origin" ng-model="quotation.Status"
										friendly-name="Status" />
							</div>
							</div> -->
							<div class="form-group ">
								<label class="col-md-5 control-label">Currency<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="currencyList"
										property="quotation.currencyName" id="currencyName"
										name="currencyName" ng-model="quotation.currencyName"
										object="currencyName" friendly-name="currencyName"
										validation="required" form-name="quotationForm"
										disabled="true"></selectivity>
								</div>
							</div>
							<div class="form-group ">

								<label class="col-md-5 control-label">Origin <span
									style="color: red"></span></label>
								<div class="col-md-7">
									<input type="text" class="form-control input-sm" name="origin"
										property="quotation.origin" id="origin"
										ng-model="quotation.origin" friendly-name="origin"
										disabled="true" />
								</div>

							</div>

							<div class="form-group ">
								<label class="col-md-5 control-label">Freight Terms<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="shipmentTermlist"
										property="quotation.freight" id="freight" name="freight"
										ng-model="quotation.freight" object="freight"
										friendly-name="freight" validation="required"
										form-name="quotationForm" disabled="true"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Other Charges<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<selectivity list="shipmentTermlist"
										property="quotation.otCharge" id="otCharge" name="otCharge"
										ng-model="quotation.otCharge" object="otCharge"
										friendly-name="otCharge" validation="required"
										form-name="quotationForm" disabled="true"></selectivity>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Approved By<span
									style="color: red"></span></label>
								<div class="col-md-7">
								<label style="padding-left: 14px;">{{quotation.approvedBy}}</label>
									
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Approved Date<span
									style="color: red"></span></label>
								<div class="col-md-7">
								<label style="padding-left: 14px;">{{quotation.approvedDate}}</label>
									
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Approved Remarks<span
									style="color: red"></span></label>
								<div class="col-md-7">
								<label style="padding-left: 14px;">{{quotation.approveRemarks}}</label>
									
							</div>
							</div>
							
						<!-- 	<div class="form-group ">
							
								<label class="col-md-5 control-label">Free Days<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<label style="padding-left: 14px;">{{quotation.freeDays}}</label>
						
							</div> -->
							
							<!-- 	<div class="form-group ">
							
								<label class="col-md-5 control-label">Free Days<span
									style="color: red"></span></label>
								<div class="col-md-7">
										<input type="text" class="form-control input-sm"
										name="origin" 
										property="quotation.freeDays" id="origin" ng-model="quotation.freeDays"
										friendly-name="origin" disabled="true" />
							</div>
							
							</div> -->
							
							
							
						</fieldset>
					</div>


				</div>

<br>
				<div>
				<tabset justified="true" class="tab-container"> <tab
						heading="Freight Charges & Local Charges"
						style="background:#5F9EA0;  ">
					<div>
						<table class="table table-striped b-t b-light">
							<tr>
								<th colspan=1 class="width_1 text-center"></th>

								<th colspan=1 class=" width_8 text-center">Charge Type<span
									style="color: red">*</span></th>
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red">*</span></th>
								<th colspan=1 class="width_8 text-center">Tariff<span
									style="color: red">*</span></th>
									<th colspan=1 class="width_8 text-center">Currency<span
									style="color: red"></span></th>
								<th colspan=1 class=" width_8 text-center">Quoted Rate<span
									style="color: red">*</span></th>
								<th colspan=1 class="width_8 text-center">Hazardous<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_8 text-center">Is OOG<span
									style="color: red;"> </span></th>
																	 
							</tr>
							<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
								ng-controller="quotationtableCtrl">
								<tr>
									<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex}}" disabled="true" >
											<i></i>
									</label></td>
										<td class=" width_9"><selectivity list="chargeTypeList"
											property="row.chargeType" id="chargeType{{trIndex}}"
											ng-model="row.chargeType" validation="required"
											name="chargeType{{trIndex}}"
											friendly-name="{{ 'Row' + ($index+1) + '(chargeType)'}}"
											form-name="quotationForm" disabled="true"></selectivity></td>
			                    <!--   <td style="text-align:center">{{row.chargeType}}</td>	 -->
						<td style="text-align:center">{{row.conType}}</td>	
												<td style="text-align:center">{{row.tariff}}</td>	
											<td style="text-align:center">{{row.localCurrency}}</td>

														<td style="text-align:center">{{row.quotedRate}}</td>		

									<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row.hazardous"
												id="hazardous" name="hazardous{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(hazardous)'}}" disabled="true" >


										</div>
									</td>
									<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row.oog" id="oog"
												name="oog{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(oog)'}}" disabled="true" >


										</div>
									</td>
									 
								</tr>
							</tbody>
						</table>						
					</div>
					<br><br>
					<div>
						<table class="table table-striped b-t b-light">
							<tr>

								 
 
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span></th>
								 
									<th colspan=1 class="width_8 text-center">POL Free Days<span
									style="color: red;"> </span></th>	
								<th colspan=1 class="width_8 text-center">POD Free Days<span
									style="color: red;"> </span></th>			

							</tr>
							<tbody ng-repeat="(trIndex1, row) in quotation.quotationFreeDaysDtl"
								ng-controller="quotationtableCtrl">
								<tr>
									 
 
									<td class=" width_9"><selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"    disabled="true"
											name="conType{{trIndex1}}" ></selectivity></td>
									  
									 
									
									 

									
										<td class=" width_9"><input type="text"  disabled="true"
										class="form-control input-sm text-right" name="freeDays"
										property="row.polFreeDays" id="polFreeDays{{trIndex}}"
										ng-model="row.polFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pol FreeDays)'}}"
										 /></td>
										 <td class=" width_9"><input type="text"  disabled="true"
										class="form-control input-sm text-right" name="freeDays"
										property="row.podFreeDays" id="podFreeDays{{trIndex1}}"
										ng-model="row.podFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pod FreeDays)'}}"
										 /></td>
								</tr>
							</tbody>
						</table>

						 
					</div>
					</tab></tabset>
<!-- 					<table class="table table-striped b-t b-light">
						<tr>
							<th colspan=1 class="width_1 text-center"></th>
							
							<th colspan=1 class=" width_9 text-center">Charge Type<span
								style="color: red">*</span></th>
								<th colspan=1 class="width_13 text-center">Container Type<span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_8 text-center">Quoted Rate<span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_9 text-center">No. of Containers<span
								style="color: red">*</span></th>
							<th colspan=1 class="width_1 text-center">Hazardous<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_1 text-center">Is Empty<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_1 text-center">Is OOG<span
									style="color: red;"> </span></th>
						
							<th colspan=1 class=" width_8 text-center">Tariff<span
								style="color: red">*</span></th>
							<th colspan=1 class="width_1 text-center">Charge Details<span
								style="color: red">*</span></th>
								
						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"> <i></i>
								</label></td>
								
										
										<td class=" width_9">
										<selectivity list="chargeTypeList"
										property="row.chargeType" id="chargeType{{trIndex}}" ng-model="row.chargeType"
										 validation="required"
										name="chargeType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(chargeType)'}}"
										form-name="quotationForm" disabled="true" ></selectivity>
										</td>
										<td class=" width_9"><selectivity list="conTypeList"
										property="row.conType" id="conType{{trIndex}}" ng-model="row.conType"
										 validation="required"
										name="conType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
										form-name="quotationForm" disabled="true"></selectivity></td>
										  	<td class=" width_9" ><input type="text" class="form-control input-sm text-right"
										name="quotedRate" 
										property="row.quotedRate" id="quotedRate{{trIndex}}" ng-model="row.quotedRate"
										friendly-name="{{ 'Row' + ($index+1) + '(quotedRate)'}}" 
										ng-keyup="Calculation(trIndex,row)" disabled="true"
										/>
										</td>
										
												<td class="width_1" align="center">
									<div class="row">

										<input type="checkbox" data-ng-model="row.hazardous"
											id="hazardous" name="hazardous{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(hazardous)'}}" disabled="true">


									</div>
								</td>
								<td class="width_1" align="center">
									<div class="row">

										<input type="checkbox" data-ng-model="row.empty"
											id="empty" name="empty{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(empty)'}}">


									</div>
								</td>
									<td class="width_1" align="center">
									<div class="row">

										<input type="checkbox" data-ng-model="row.oog"
											id="oog" name="oog{{trIndex}}"
											friendly-name="{{ 'Row' + $index + '(oog)'}}" disabled="true">


									</div>
								</td>
							
										
										<td class=" width_9" ><input type="text" class="form-control input-sm text-right"
										name="c" 
										property="row.noOfBox" id="noOfBox{{trIndex}}" ng-model="row.noOfBox"
										friendly-name="{{ 'Row' + ($index+1) + '(noOfBox)'}}"
										ng-keyup="Calculation(trIndex,row)"
										 />
										</td>
					      
										
										<td class=" width_9" ><input type="text" class="form-control input-sm text-right"
										name="tariff" 
										property="row.tariff" id="tariff{{trIndex}}" ng-model="row.tariff"
										friendly-name="{{ 'Row' + ($index+1) + '(tariff)'}}" disabled="true" />
										</td>
								
								<td class=" width_5" >
							  					<div class="col-xs-3 pull-left">
												<label class="line-height-30 cursor-pointer"
												
													data-ng-click="showPopup()">
													<i class="fa fa-expand"></i>
												</label>
											</div>
								</td>
								<td class=" width_10" ><selectivity list="currencylist"
										property="row.currency" id="currency{{trIndex}}" ng-model="row.currency"
										 validation="required"
										name="currency{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Currency)'}}"
										form-name="quotationForm" ></selectivity></td>
											<td class=" width_10" style="padding-left: 32px;"><selectivity list="PaymentMethodList"
										property="row.paymentMethod" id="paymentMethod{{trIndex}}" ng-model="row.paymentMethod"
										 validation="required"
										name="paymentMethod{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(PaymentMethod)'}}"
										form-name="quotationForm" ></selectivity></td>
														<td class=" width_10"><selectivity list="transactionTypeList"
										property="row.transactionType" id="transactionType{{trIndex}}" ng-model="row.transactionType"
										 validation="required"
										name="transactionType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Transaction Type)'}}"
										form-name="quotationForm" ></selectivity></td>
										
													<td class=" width_10"><selectivity list="serviceParnrDropList"
										property="row.buySell" id="buySell{{trIndex}}" ng-model="row.buySell"
										 validation="required"
										name="buySell{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Buy Sell)'}}"
										form-name="quotationForm" ></selectivity></td>
										
										<td class=" width_10"  style="padding-left: -56px;">
										<textarea  type="text" class="form-control input-sm"
															name="note"   
															class="custom-scroll width_250 resize-none" rows="3"
															property="row.note" id="note{{trIndex}}" ng-model="row.note"
										                   friendly-name="{{ 'Row' + ($index+1) + '(note)'}}">
															</textarea>
							</tr>
						</tbody>
					</table>

 -->					<!-- <button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button> -->
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<!-- <button class="btn btn-success" type="button" ng-if="!edit"
											ng-click="submit(quotationForm,quotation)" id="quotationsave">
											<i class="fa fa-save"></i> Save
										</button> -->
										<!-- <button class="btn btn-success" type="button" ng-if="edit"
											ng-click="approve(quotation.quotationNo)">
											<i class=""></i> Approve
										</button> -->
										<!-- <button class="btn btn-success" type="button" ng-if="edit"
											ng-click="reject(quotation.quotationNo)">
											<i class=""></i> Reject
										</button> -->
									<!-- 	<button class="btn btn-info" ng-click="copyView(quotation.quotationNo)"
											type="button">
											<i class="fa fa-copy"></i> Copy
										</button> -->
										<button class="btn btn-danger" ng-click="cancelDraft()"
											type="button">
											<i class="fa fa-close"></i> Back
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
<script type="text/ng-template" id="algorithmModal">
<div class="modal-header"> Quotation Algorithm </div>
<div class="row">
<div class="width_90 m-n-auto">
	<iframe title='Quotation Algorithm' class='' 
        width='625' height='500' src='assets/algorithm_Docs/Quotation_Algorithm.pdf'
         allowfullscreen='true' frameborder='0' align="center"></iframe>
</div>
</div>
<div class="modal-footer">
	<button class="btn btn-danger" ng-click="closeHelpDialog()">Close</button>
</div>
</script>
