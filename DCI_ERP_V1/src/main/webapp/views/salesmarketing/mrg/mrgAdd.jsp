<style>
.ui-select-bootstrap .pull-left {
	float: left !important;
}

.ngdialog-content {
	width: 50% !important;
	bottom: 160px !important;
	margin: 0 auto !important;
}
input.check-box-style {
	margin-left: 90px;
	width: 40px;
	height: 22px;
}
.borderclass {
	border: 2px solid !important;
	border-color: #aaa !important;
}
</style>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="mrgForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>

							<div class="form-group" ng-if="edit">
								<label class="col-md-5 control-label" style="padding-top: 10px;">MRG
									No <span style="color: red">*</span>
								</label>
								<div class="col-md-7" style="padding-top: 15px;">
									<label style="padding-left: 14px;">{{mrg.mrgNo}}</label>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Service <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="servicePartnerTypelist"
										property="mrg.serviceType" id="serviceType"
										name="serviceType" ng-model="mrg.serviceType"
										object="serviceType" friendly-name="service"
										validation="required" form-name="mrgForm"
										></selectivity>
										
								</div>
								</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Customer <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="customerDropList"
										property="mrg.customer" id="customer"
										name="customer" ng-model="mrg.customer"
										object="customer" friendly-name="Customer"
										form-name="mrgForm"
										></selectivity>
							</div>
							</div>
							
							
							
							
							<div class="form-group ">
								<label class="col-md-5 control-label">POL <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="portList" property="mrg.pol" id="pol"
										name="pol" ng-model="mrg.pol" object="pol"
										friendly-name="pol" validation="required"
										form-name="mrgForm"></selectivity>
								</div>
							</div>
							
					<div class="form-group" >
									<label class="col-md-5 control-label"> POT </label>
									<div class="col-md-7">
										<selectivity list="portList" ng-model="mrg.pot"
											validation="required" friendly-name="pot"
											property="mrg.pot" id="pot" name="pot"
											form-name="salesreportform"></selectivity>
									</div>
						</div> 
					<div class="form-group ">
								<label class="col-md-5 control-label">FPOD <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="portList" property="mrg.pod" id="pod"
										name="pod" ng-model="mrg.pod" object="pod"
										friendly-name="pod" validation="required"
										form-name="mrgForm"></selectivity>
								</div>
							</div>
							
						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						<!-- <div class="form-group " ng-if = "mrg.rejectedRemarks !=null">
								<label class="col-md-5 control-label" >Rejected Remarks<span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
								<textarea type="text" class="form-control input-sm"
										name="cargoDesc" form-name="mrgForm"
										class="custom-scroll width_250 resize-none" rows="2"  disabled="disabled"
										ng-model="mrg.rejectedRemarks">
															</textarea>
									
								</div>
							</div>  -->
								<div class="form-group ">
								<label class="col-md-5 control-label">Valid From <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker data-ng-model="mrg.mrgDate"
										id="mrgDate" name="mrgDate"
										data-ng-change="checkDatesCL(mrg.mrgDate)"
										friendly-name="Valid From" validation="required" />
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Valid Till <span
									style="color: red">*</span></label>
								<div class="col-md-7 ">
									<ng-bs3-datepicker ng-disabled="createQuote"
										data-ng-model="mrg.validTill" id="validTill"
										name="validTill"
										data-ng-change="checkDatesCL(mrg.validTill)"
										friendly-name="Valid From" validation="required" />
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Contract Type<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="contractTypeList"
										property="mrg.contractType" id="contractType"
										name="contractType" ng-model="mrg.contractType"
										object="contractType" friendly-name="contractType"
										form-name="mrgForm"
										></selectivity>
							</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Carrier <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="carrierList" ng-model="mrg.carrier"
										 property="mrg.carrier"
										id="carrier" 
										friendly-name="Carrier"
										form-name="mrgForm"></selectivity>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
							
				<div class="form-group ">
								<label class="col-md-5 control-label">Currency<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="currencyList"
										property="mrg.currencyName" id="currencyName"
										name="currencyName" ng-model="mrg.currencyName"
										object="currencyName" friendly-name="currencyName"
										validation="required" form-name="mrgForm"></selectivity>
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Origin</label>
								<div class="col-md-7">
									<selectivity list="portList" property="mrg.origin" id="origin"
										name="origin" ng-model="mrg.origin" object="origin"
										friendly-name="origin" 
					
					
										form-name="mrgForm"></selectivity>
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Destination </label>
								<div class="col-md-7">
									<selectivity list="portList" property="mrg.destination1" id="origin"
										name="destination" ng-model="mrg.destination1" object="destination"
										friendly-name="destination" 
										form-name="mrgForm"></selectivity>
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Commodity <span
									style="color: red">*</span></label>
								<div class="col-md-7">	
												
										<!-- <input type="text" class="form-control input-sm"
										name="commodity" 
										property="quotation.commodity" id="commodity" ng-model="quotation.commodity"
										friendly-name="commodity" /> -->
										
										<!-- <selectivity list="commodityList"
										property="quotation.commodity" id="commodity"
										name="commodity" ng-model="quotation.commodity"
										object="commodity" friendly-name="Commodity"
										form-name="quotationForm" validation="required"
										></selectivity> -->
										<div class="col-md-15 "
										class="selectivity-input example-input selectivity-slot voyage_sel">
									<select id="commodityL" multiple="multiple" name="commodityL"
									friendly-name="commodityL"  form-name="mrgForm"
										ng-model="mrg.commodityL" validation="required"
										ng-options="option.text for option in commodityList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in commodityList" 
											value="{{getOptionId(option)}}"
											data-ng-bind-template="{{option.commodityL}}"></option>
									</select>										
										 
									</div>
							</div>
							
							</div>
							
						</fieldset>
					</div>

				</div>
								<br>
								<br>
				<br>
				<!-- <div>
				
					<tabset justified="true" class="tab-container">
						<tab  heading="Feeder Cost" style="background:#228B22;font-weight: bold;">		
							<div>
								<div class="panel-body" style="width: 50%;float: center; position:relative; left: 1%;">
									<div class="table-responsive">
										<div st-table="displayedCollection10" st-safe-src="rowCollection10">
										<table class="table table-striped table-hover dataTable no-footer">
											<thead>
											<tr>
												<th  class="borderclass">Charge Type</th>
												<th  class="borderclass">Container Type</th>
												<th  class="borderclass">Rate</th>
											</tr>
											</thead>
											<tbody ng-repeat="blCharge in feederRateList">
												<tr>
												  	<td  class="borderclass"><b>{{blCharge.chargeTypeName}}</b></td>
													<td  class="borderclass"><b>{{blCharge.conType}}</b></td>
													<td  class="borderclass"  ><b>{{blCharge.quotedRate}}</b></td>
												</tr>
											</tbody>
										</table>
									</div>
									<br>
							</div>
						</div>
					</div>
					</tab></tabset>
					
				</div> -->
				
				<div>
					<tabset justified="true" class="tab-container"> <tab
						heading="Freight Charges"
						style="background:#5F9EA0;  ">
						<div>
					<table class="table table-striped b-t b-light">
						<tr>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_13 text-center">Charge Heads <span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_9 text-center">Unit <span
								style="color: red">*</span></th>
							<!-- <th colspan=1 class=" width_8 text-center">Qty <span
								style="color: red">*</span></th> -->
							<th colspan=1 class="width_10 text-center">Currency <span
									style="color: red">*</span></th>
							<!-- 	<th colspan=1 class=" width_10 text-center">Payment Method <span
								style="color: red">*</span></th> -->
							<th colspan=1 class=" width_6 text-center">Transaction Type <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_14 text-center">Buy/Sell Party <span
								style="color: red">*</span></th>
							<th colspan=1 class="width_10 text-center">MRG Rate<span
								style="color: red">*</span></th>
							<!-- <th colspan=1 class=" width_16 text-center">Notes <span
								style="color: red"></span></th> -->
						</tr>
						<tbody ng-repeat="(trIndex, row) in mrg.mrgDtl"
							ng-controller="mrgdetailtableCtrl">
							<tr>
								<td>
									<label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"
										ng-disabled="row.disabled"> <i></i>
									</label>
								</td>
								<td class=" width_9">
									<selectivity list="chargeHeadList"
										property="row.chargeHeads" id="chargeHeads{{trIndex}}" ng-model="row.chargeHeads"
										 validation="required"
										name="chargeHeads{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(ChargeHeads)'}}"
										form-name="mrgForm" >
									</selectivity>
								</td>
								<td class=" width_9">
										<selectivity list="UnitList"
										property="row.unit" id="unit"
										name="unit" ng-model="row.unit"
										object="unit" friendly-name="{{ 'Row' + ($index+1) + '(Unit)'}}"
										validation="required" form-name="mrgForm"
										></selectivity>
								</td>
								<!-- <td class=" width_9" >
										<input type="text" class="form-control input-sm text-right"
										name="qty" 
										property="row.qty" id="qty{{trIndex}}" ng-model="row.qty"
										friendly-name="{{ 'Row' + ($index+1) + '(Qty)'}}" />
								</td> -->	
								<td class=" width_10" >
										<selectivity list="currencyList"
										property="row.currency" id="currency{{trIndex}}" ng-model="row.currency"
										 validation="required"
										name="currency{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Currency)'}}"
										form-name="mrgForm" >
										</selectivity>
								</td>
								<td class=" width_10">
										<selectivity list="transactionTypeList"
										property="row.transactionType" id="transactionType{{trIndex}}" ng-model="row.transactionType"
										 validation="required"
										name="transactionType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Transaction Type)'}}"
										form-name="mrgForm" >
										</selectivity>
								</td>									
								<td class=" width_10">
										<selectivity list="serviceParnrDropList"
										property="row.buySell" id="buySell{{trIndex}}" ng-model="row.buySell"
										 validation="required"
										name="buySell{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Buy Sell)'}}"
										form-name="mrgForm" >
										</selectivity>
								</td>							
								<td class=" width_5" >
										<input type="text" class="form-control input-sm text-right"
										name="Qty" 
										property="row.rate" id="rate{{trIndex}}" ng-model="row.rate"
										friendly-name="{{ 'Row' + ($index+1) + '(rate)'}}" />
								</td>										
								<!-- <td class=" width_10"  style="padding-left: -56px;">
										<textarea  type="text" class="form-control input-sm"
										name="note" class="custom-scroll width_250 resize-none" rows="3"
										property="row.note" id="note{{trIndex}}" ng-model="row.note"
										friendly-name="{{ 'Row' + ($index+1) + '(note)'}}">
										</textarea>
								</td> -->
							</tr>
						</tbody>
					</table>

					<button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button>
					<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button>
				</div><br><br>
							<div>
						<table class="table table-striped b-t b-light">
							<tr>
								<th colspan=1 class="width_1 "><label
									class="i-checks m-b-none"> <input type="checkbox"
										ng-click="checkAllFreeDays()" ng-model="quotation.checkAllFreeDays"> <i></i>
								</label></th> 
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span>
								</th>
								<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POL Free Days<span
									style="color: red;"> </span>
								</th>	
								<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POD Free Days<span
									style="color: red;"> </span>
								</th>								 
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POL Free Days<span
									style="color: red;"> </span>
								</th>	
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POD Free Days<span
									style="color: red;"> </span>
								</th>		
							</tr>
							<tbody ng-repeat="(trIndex1, row) in mrg.mrgDtlorigin"
								ng-controller="mrgdetailtableCtrl">
								<tr>
									<td>
										<label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex1}}">
											<i></i>
										</label>
									</td>
 									<td class=" width_9">
											<selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"  
											name="conType{{trIndex1}}" >
											</selectivity>
									</td>
									<td class=" width_9">
										<input type="text"  onkeypress="return event.charCode >= 48 && event.charCode <= 57"
										class="form-control input-sm text-right" name="freeDays"
										property="row.polFreeDays" id="polFreeDays{{trIndex}}"
										ng-model="row.polFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pol LD FreeDays)'}}"/>
									</td>
									<td class=" width_9">
										<input type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
										class="form-control input-sm text-right" name="freeDays"
										property="row.podFreeDays" id="podFreeDays{{trIndex1}}"
										ng-model="row.podFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pod LD FreeDays)'}}"/>
									</td>
									<td class=" width_9">
										<input type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
										class="form-control input-sm text-right" name="freeDays"
										property="row.polGRFreeDays" id="polGRFreeDays{{trIndex}}"
										ng-model="row.polGRFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pol GR FreeDays)'}}"/>
								 	</td>
									<td class=" width_9">
										<input type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
										class="form-control input-sm text-right" name="freeDays"
										property="row.podGRFreeDays" id="podGRFreeDays{{trIndex1}}"
										ng-model="row.podGRFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pod GR FreeDays)'}}"/>
									</td>
								</tr>
							</tbody>
						</table>
						<button ng-click="addRowFreeDays()" class="btn btn-sm btn-info"
							ng-disabled="subForm.$invalid" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRowFreeDays()" class="btn btn-sm btn-danger"
							ng-disabled="userForm{{$index}}.$invalid" type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>
					<br><br>
							<!-- <div>
						<table class="table table-striped b-t b-light">
							<tr>
								<th colspan=1 class="width_1 ">
									<label class="i-checks m-b-none"> 
										<input type="checkbox"
										ng-click="checkAllFreeDays1()" ng-model="quotation.checkAllFreeDays1"> <i></i>
									</label>
								</th>
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span>
								</th>								 
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POL Free Days<span
									style="color: red;"> </span>
								</th>	
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POD Free Days<span
									style="color: red;"> </span>
								</th>			

							</tr>
							<tbody ng-repeat="(trIndex1, row) in mrg.mrgDtldestination"
								ng-controller="mrgdetailtableCtrl">
								<tr>								
									<td>
										<label class="i-checks m-b-none"> 
											<input type="checkbox" ng-model="row.select" id="section{{trIndex1}}"><i></i>
										</label>
									</td> 
									<td class=" width_9">
										<selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"  
											name="conType{{trIndex1}}" >
										</selectivity>
									</td>
								</tr>
							</tbody>
						</table>

						<button ng-click="addRowGroundFreeDays()" class="btn btn-sm btn-info"
							ng-disabled="subForm.$invalid" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRowGroundFreeDays()" class="btn btn-sm btn-danger"
							ng-disabled="userForm{{$index}}.$invalid" type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div>	 -->				
					</tab></tabset>
					
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="content">
							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-success" type="button" ng-if="!edit" ng-disabled="check"
											ng-click="Submit(mrgForm,mrg)" id="mrgsave">
											<i class="fa fa-save"></i> Save
										</button>
										<button class="btn btn-success" type="button" ng-if="edit"
											ng-click="submitupdate(mrgForm,mrg)">
											<i class="fa fa-save"></i> Update
										</button>
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



