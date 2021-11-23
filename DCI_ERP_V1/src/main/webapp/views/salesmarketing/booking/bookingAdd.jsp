<style>
.custom-col-md-6 {
	padding-right: 0px;
	padding-left: 0px;
}

.custom-col-md-3 {
	padding-right: 25px;
}
</style>
<div class="breadcrumb-wrapper ng-scope">
	<div class="panel panel-default panel-default-form">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<input type="hidden" value="${form_code}" id="form_code_id">
		<form name="bookingForm" class="form-horizontal" novalidate>
			<tabset justified="true" class="tab-container"> <tab
				heading="General">
			<div class="panel-body" ng-if="!bookViaQt">
				<!-- 			<form name="bookingForm" class="form-horizontal"  method="post" novalidate> -->
				<div class="row book-widget-row" >
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4" ng-if="isEdit">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking No.</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{bookingData.bookingNo}}</label>
									</div>

								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Booking Date </label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="bookingData.bookingDate"
											id="bookingDate" name="bookingDate" form-name="bookingForm"
											disabled friendly-name="Booking Date" validation="required" disabled="value"/>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="bookingData.vessel"
											validation="required" friendly-name="vessel"
											property="bookingData.vessel" id="vessel" name="vessel" disabled="value"
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="bookingData.voyage"
											validation="required" friendly-name="Voyage"
											property="bookingData.voyage" id="Voyage" name="Voyage" disabled="value"
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

                    <div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Leg<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="LegType" ng-model="bookingData.leg"
											validation="required" friendly-name="leg"
											property="bookingData.leg" id="leg" name="leg" 
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4"><div class="form-group">
									<label class="col-md-5 control-label">POL<span
										style="color: red;">*</span></label>
									<div class="col-md-7" ng-if="!bookViaQt">
										<selectivity list="polList" ng-model="bookingData.pol"
											validation="required" friendly-name="Pol"
											property="bookingData.pol" id="pol" name="pol" disabled="value"
											form-name="bookingForm"></selectivity>
									</div>
									<div class="col-md-7" ng-if="bookViaQt">
										<label class="col-md-5 control-label">{{bookingData.pol}}</label>
									</div>
								</div>
								
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
								
									<label class="col-md-5 control-label">POD<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7" >
										<selectivity list="podList" ng-model="bookingData.pod" 
											validation="required" friendly-name="pod" disabled="value"
											property="bookingData.pod" id="pod" name="pod"
											form-name="bookingForm" validation="required"></selectivity>
									</div>
<!-- 									<div class="col-md-7" ng-if="bookViaQt"> -->
<!-- 										<label class="col-md-5 control-label">{{bookingData.pod}}</label> -->
<!-- 									</div> -->
								</div>
							</div>
						</fieldset>
						</div>
					<div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Type </label>
									<div class="col-md-7">
										<selectivity list="bookingTypeList"
											ng-model="bookingData.bookingType"
											friendly-name="Booking Type" disabled="value"
											property="bookingData.bookingType" id="bookingType"
											name="bookingType" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>

							<div class="col-md-4">
							<div class="form-group">
									<label class="col-md-5 control-label">POD 1 </label>
									<div class="col-md-7">
										<selectivity list="rPodList" ng-model="bookingData.pod1" disabled="legCheck"
											friendly-name="pod1" disabled="value"
											property="bookingData.pod1" id="pod1" name="pod1"
											form-name="bookingForm" ></selectivity>
									</div>
								</div>
								
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Final Destination<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<selectivity list="rPodList" ng-model="bookingData.destination" disabled="value"
											 friendly-name="FPOD" property="bookingData.destination" 
											id="fpod" name="fpod" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
						</fieldset>
					</div>



					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Customer <span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7" ng-if="!bookViaQt">
										<selectivity list="mloList" ng-model="bookingData.customer"
											validation="required" friendly-name="customer"
											property="bookingData.customer" id="customer" name="customer" disabled="value"
											form-name="bookingForm"></selectivity>
									</div>
									<div class="col-md-7" ng-if="bookViaQt">
										<label class="col-md-5 control-label">{{bookingData.customer}}-{{bookingData.customerName}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-5 control-label">Special <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<selectivity list="SpecialList" ng-model="bookingData.special"
										 property="bookingData.special"
										id="special" 
										friendly-name="Special"
										form-name="quotationForm"></selectivity>
								</div>
							</div></div>
							
					
							 <div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-5 control-label">Cargo Type <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<selectivity list="cargoTypeList" ng-model="bookingData.cargoType"
										 property="bookingData.cargoType"
										id="cargoType" 
										friendly-name="Cargo Type"
										form-name="quotationForm"></selectivity>
								</div>
							</div></div> 
							
						</fieldset>
					</div>
<div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation </label>
									<div class="col-md-7" ng-if="!bookViaQt">
										<selectivity list="quotationList"
											ng-model="bookingData.quotation"
											property="bookingData.quotation" name="quotation" disabled="value"
											id="quotation" form-name="bookingForm"
											friendly-name="quotation"></selectivity>
									</div>
									<div class="col-md-7" ng-if="bookViaQt">
										<label class="col-md-5 control-label">{{bookingData.quotation}}</label>
									</div>
								</div>
							</div> 
							 <div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Quotation
										Validity Date </label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="bookingData.quotationDate"
											id="quotationDate" name="quotationDate" 
											form-name="bookingForm" disabled
											friendly-name="Quotation Date" />

									</div>
								</div>
							</div> 
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Pre-Carriage By </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											ng-model="bookingData.carriageBy" name="carriageBy"
											property="bookingData.carriageBy" 
											id="carriageBy"  ng-disabled="value" form-name="bookingForm" 
											friendly-name="Pre_Carriage By" />
									</div>
								</div>
							</div>
						</fieldset>
						</div>

					<div class="col-sm-12">
						<fieldset>
							

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Shipper </label>
									<div class="col-md-7">
										<selectivity list="shipperList" ng-model="bookingData.shipper"
											friendly-name="shipper" property="bookingData.shipper" disabled="value"
											id="shipper" name="shipper" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Consignee </label>
									<div class="col-md-7">
										<selectivity list="consigneeList"
											ng-model="bookingData.consignee" friendly-name="consignee"
											property="bookingData.consignee" id="consignee" disabled="value"
											name="consignee" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Notify Party </label>
									<div class="col-md-7">
										<selectivity list="notifyPartyList"
											ng-model="bookingData.notifyParty"
											friendly-name="Notify Party" disabled="value"
											property="bookingData.notifyParty" id="notifyParty"
											name="notifyParty" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<!-- <div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Free Days </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label text-left">{{bookingData.freeDays}}</label>
									</div>
								</div>
							</div> -->
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Freight Terms
									</label>
									<div class="col-md-7" ng-if="!bookViaQt" >
										<selectivity list="freightList" ng-model="bookingData.freight"
											friendly-name="freight" property="bookingData.freight"  disabled="value"
											disabled id="freight" name="freight"  form-name="bookingForm"></selectivity>
									</div>
									<div class="col-md-7" ng-if="bookViaQt">
										<selectivity list="freightList" ng-model="bookingData.freight"
											friendly-name="freight" property="bookingData.freight"  disabled="value"
											disabled disabled id="freight" name="freight"
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Other Charges </label>
									<div class="col-md-7" ng-if="!bookViaQt">
										<selectivity list="otherChargeList" disabled
											ng-model="bookingData.otCharge" friendly-name="Other Charge"
											property="bookingData.otCharge" disabled="value" id="otCharge" name="otCharge"  
											form-name="bookingForm"></selectivity>
									</div>
									<div class="col-md-7" ng-if="bookViaQt">
										<selectivity list="otherChargeList" disabled
											ng-model="bookingData.otCharge" friendly-name="Other Charge"  
											property="bookingData.otCharge" disabled="value" id="otCharge" name="otCharge" 
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-5 control-label"  > Payer <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<selectivity list="mloList" ng-model="bookingData.payerName" property="bookingData.payerName"
										id="payerName" friendly-name="payerName" form-name="bookingForm"  ></selectivity>
								</div>
							</div> 
							</div> 
							<!-- <div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-5 control-label"  ng-hide ="true";>Detention Tariff Type <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<selectivity list="tariffList" ng-model="bookingData.detentionTariffType"
										 property="bookingData.detentionTariffType"
										id="detentionTariffType" 
										friendly-name="detentionTariffType"
										form-name="bookingForm" disabled="true" ></selectivity>
								</div>
							</div> 
							</div> -->
							
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
						
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks </label>
									<div class="col-md-7">
										<textarea
											class="form-control input-sm resize-none ng-valid ng-scope ng-dirty ng-valid-parse ng-touched"
											id = "remarks" name="remarks" form-name="bookingForm" rows="3" 
											ng-model="bookingData.remarks" ng-disabled="value" friendly-name="remarks">
															</textarea>
									</div>
								</div>
							</div>
							
							
							<!-- <div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-5 control-label">SOC<span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="bookingData.soc" id="soc" 
											ng-change="loadAllPorts(bookingData.soc)">
											<i></i>
									</label>
								</div>
							</div>
							</div> -->
							
						</fieldset>
					</div>
				</div>
<tabset justified="true" class="tab-container"> <tab
						heading="Container Type &
									Quantity"
						style=" background: #a8ccce;">
				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
						<!-- 	<tr>
								<th colspan="13" class="text-center"></th>
							</tr> -->
							<tr>
								<!-- 								<th colspan=1 class="width_1"></th> -->
								<th colspan=1 class="width_13 text-center">Container Type</th>
								<th colspan=1 class="width_10 text-center">No. Of
									Containers</th>
								<th colspan=1 class="width_10 text-center">Commodity<span
										style="color: red;">*</span></th>
								<th colspan=1 class="width_10 text-center">Free Days</th>
								<th colspan=1 class="width_8 text-center">Hazardous<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_8 text-center">Is OOG<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_8 text-center">SOC<span
									style="color: red;"> </span></th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in bookingData.boxData track by trIndex">
							<tr>
								<!-- 								<td><label class="i-checks m-b-none"> <input -->
								<!-- 										type="checkbox" ng-model="row1.select" id="section{{trIndex}}"><i></i></label></td> -->
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" disabled
												id="cntrTypeBx{{trIndex}}" ng-model="row1.cntrType"
												name="cntrTypeBx{{trIndex}}" validation="required"  disabled="value"
												friendly-name="{{ 'Row' + $index+1 + '(cntr Type)'}}"/>
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="noOfBoxBx{{trIndex}}" ng-model="row1.noOfBox"
												name="box{{trIndex}}" validation="required|number"  
												friendly-name="{{ 'Row' + $index + '(No Of Box)'}}" 
												form-name="bookingForm" ng-disabled="value"/>
										</div>
									</div>
								</td>

								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="commodityList" property="row1.commodity"
												id="commodityBx{{trIndex}}" ng-model="row1.commodity"
												name="commodityBx{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Commodity)'}}"
												form-name="bookingForm" disabled="value" ></selectivity>
										</div>
									</div>
								</td>
									<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" disabled
												id="freeDays{{trIndex}}" ng-model="row1.freeDays"
												name="freeDays{{trIndex}}"   
												friendly-name="{{ 'Row' + $index + '(freeDays)'}}" 
												form-name="bookingForm" disabled="value"/>
										</div>
									</div>
								</td>
								<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row1.hazardous"
												id="hazardous{{trIndex}}" name="hazardous{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(hazardous)'}}">


										</div>
									</td>
									<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row1.isOog" id="isOog"
												name="isOog{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(isOog)'}}">


										</div>
									</td>
									<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row1.isSoc" id="isSoc"
												name="isSoc{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(isSoc)'}}">


										</div>
									</td>
							</tr>
						</tbody>
					</table>
					 
					<br>
<br>
<br>
 
				</div>
				</tab>
				<tab
						heading="Quotation Details"
						style="background: #a8ccce;" ng-show ="quotationdetailtab">
<div class="table-responsive clear">
			<div>
						<table class="table table-striped b-t b-light">
							<tr>

							 

								<th colspan=1 class=" width_8 text-center">Charge Type<span
									style="color: red"></span></th>
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span></th>
								<th colspan=1 class="width_8 text-center">Tariff<span
									style="color: red"></span></th>
									<th colspan=1 class="width_8 text-center">Currency<span
									style="color: red"></span></th>
								<th colspan=1 class=" width_8 text-center">Quoted Rate<span
									style="color: red"></span></th>
								<th colspan=1 class="width_8 text-center">Hazardous<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_8 text-center">Is OOG<span
									style="color: red;"> </span></th>
							<!-- 		<th colspan=1 class="width_8 text-center">Free Days<span
									style="color: red;"> </span></th>	 -->
										<th colspan=1 class="width_8 text-center">PayAt<span
									style="color: red;">*</span></th>	

							</tr>
							<tbody ng-repeat="(trIndex, row) in bookingData.quotationDtl"
								ng-controller="quotationtableCtrl">
								<tr>

									<td class=" width_9"><selectivity list="chargeTypeList"
											property="row.chargeType" id="chargeType{{trIndex}}"
											ng-model="row.chargeType" validation="required" disabled="true"
											name="chargeType{{trIndex}}"
											friendly-name="{{ 'Row' + ($index+1) + '(chargeType)'}}"
											 ></selectivity></td>
									<td class=" width_9"><selectivity list="conTypeList"
											property="row.conType" 
											ng-model="row.conType"   disabled="true"
											name="conType{{trIndex}}" ></selectivity></td>
									<td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="tariff"
										property="row.tariff" id="tariff{{trIndex}}"
										ng-model="row.tariff" disabled
										friendly-name="{{ 'Row' + ($index+1) + '(tariff)'}}"
										disabled="true" /></td>
										<td class=" width_9"><selectivity list="currencyList"
											property="row.localCurrency" 
											ng-model="row.localCurrency"   disabled="true"
											name="localCurrency{{trIndex}}"></selectivity></td>
									<td class=" width_9"><input type="text"
										class="form-control input-sm text-right" name="quotedRate"
										property="row.quotedRate" id="quotedRate{{trIndex}}"
										ng-model="row.quotedRate" disabled
										friendly-name="{{ 'Row' + ($index+1) + '(quotedRate)'}}" /></td>

									<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row.hazardous"
												id="hazardous" name="hazardous{{trIndex}}" disabled
												friendly-name="{{ 'Row' + $index + '(hazardous)'}}">


										</div>
									</td>
									<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row.oog" id="oog"
												name="oog{{trIndex}}" disabled
												friendly-name="{{ 'Row' + $index + '(oog)'}}">


										</div>
									</td>
										<!-- <td class=" width_9"><input type="text" disabled
										class="form-control input-sm text-right" name="freeDays"
										property="row.freeDays" id="freeDays{{trIndex}}"
										ng-model="row.freeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(freeDays)'}}"
										 /></td> -->
										 	<td class=" width_9"><selectivity list="rPodList"
											property="row.payAt" id="payAt{{trIndex}}"
											ng-model="row.payAt" validation="required"  
											name="payAt{{trIndex}}"  
											friendly-name="{{ 'Row' + ($index+1) + '(Pay At)'}}"
											 ></selectivity></td>
								</tr>
							</tbody>
						</table>

						 
					</div>
					<br>
<br>
<br>
 
				</div>
</tab></tabset>

			</div>
			<div class="panel-body" ng-if="bookViaQt">
				<!-- 			<form name="bookingForm" class="form-horizontal"  method="post" novalidate> -->
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4" ng-if="isEdit">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking No.</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{bookingData.bookingNo}}</label>
									</div>

								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>

                                        <div class="form-group" ng-if="edit">
								<label class="col-md-5 control-label" style="padding-top: 10px;">Quotation
									 <span style="color: red">*</span>
								</label>
								<div class="col-md-7" style="padding-top: 15px;">
									<label style="padding-left: 14px;">{{booking.quotationNo}}</label>
								</div>
							</div>
							<!-- <div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation </label>
									<div class="col-md-7" ng-if="bookViaQt">
										<label class="control-label"><b>{{bookingData.quotation}}</b></label>
									</div>
								</div>
							</div> -->
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Customer </label>
									<div class="col-md-7" ng-if="bookViaQt">
										<label class="control-label"><b>{{bookingData.customer}}-{{bookingData.customerName}}</b></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Booking Date </label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="bookingData.bookingDate"
											id="bookingDate" name="bookingDate" form-name="bookingForm"
											disabled friendly-name="Booking Date" validation="required" />

									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL</label>
									<div class="col-md-7" ng-if="bookViaQt">
										<label class="control-label"><b>{{bookingData.pol}}</b></label>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POD </label>
									<div class="col-md-7" ng-if="bookViaQt">
										<label class="control-label"><b>{{bookingData.pod}}</b></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Final Destination<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<selectivity list="rPodList" ng-model="bookingData.destination"
											friendly-name="FPOD" property="bookingData.destination"
											id="fpod" name="fpod" form-name="bookingForm"></selectivity>

										<!-- 										<input type="text" class="form-control input-sm text-right" -->
										<!-- 											ng-model="bookingData.destination" name="destination" -->
										<!-- 											id="destination" form-name="bookingForm" -->
										<!-- 											friendly-name="destination" /> -->
									</div>
								</div>
							</div>
						</fieldset>
					</div>



					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="bookingData.vessel"
											validation="required" friendly-name="vessel"
											property="bookingData.vessel" id="vessel" name="vessel"
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<selectivity list="voyageList" ng-model="bookingData.voyage"
											validation="required" friendly-name="Voyage"
											property="bookingData.voyage" id="Voyage" name="Voyage"
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Quotation
										Validity Date </label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="bookingData.quotationDate"
											id="quotationDate" name="quotationDate"
											form-name="bookingForm" disabled
											friendly-name="Quotation Date" />

									</div>
								</div>
							</div>
						</fieldset>
					</div>


					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Pre-Carriage By </label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											ng-model="bookingData.carriageBy" name="carriageBy"
											id="carriageBy" form-name="bookingForm"
											friendly-name="Pre_Carriage By" />
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Shipper </label>
									<div class="col-md-7">
										<selectivity list="shipperList" ng-model="bookingData.shipper"
											friendly-name="shipper" property="bookingData.shipper"
											id="shipper" name="shipper" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Consignee </label>
									<div class="col-md-7">
										<selectivity list="consigneeList"
											ng-model="bookingData.consignee" friendly-name="consignee"
											property="bookingData.consignee" id="consignee"
											name="consignee" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Free Days </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label text-left">{{bookingData.freeDays}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Freight Terms
									</label>
									<div class="col-md-7" ng-if="bookViaQt">
										<selectivity list="freightList" ng-model="bookingData.freight"
											friendly-name="freight" property="bookingData.freight"
											id="freight" name="freight" disabled="true"
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Other Charges </label>
									<div class="col-md-7" ng-if="bookViaQt">
										<selectivity list="otherChargeList" disabled="true"
											ng-model="bookingData.otCharge" friendly-name="Other Charge"
											property="bookingData.otCharge" id="otCharge" name="otCharge"
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Notify Party </label>
									<div class="col-md-7">
										<selectivity list="notifyPartyList"
											ng-model="bookingData.notifyParty"
											friendly-name="Notify Party"
											property="bookingData.notifyParty" id="notifyParty"
											name="notifyParty" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Type </label>
									<div class="col-md-7">
										<selectivity list="bookingTypeList"
											ng-model="bookingData.bookingType"
											friendly-name="Booking Type"
											property="bookingData.bookingType" id="bookingType"
											name="bookingType" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks1 </label>
									<div class="col-md-7">
										<textarea
											class="form-control input-sm resize-none ng-valid ng-scope ng-dirty ng-valid-parse ng-touched"
											name="remarks" form-name="bookingForm" rows="3"
											ng-model="bookingData.remarks">
															</textarea>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>
				
				<div class="table-responsive clear" style="padding-bottom: 100px;">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan="13" class="text-center">Container Type &
									Quantity</th>
							</tr>
							<tr>
								<!-- 								<th colspan=1 class="width_1"></th> -->
								<th colspan=1 class="width_13 text-center">Container Type</th>
								<th colspan=1 class="width_10 text-center">No. Of
									Containers</th>
								<th colspan=1 class="width_10 text-center">Commodity</th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in bookingData.boxData track by trIndex">
							<tr>
								<!-- 								<td><label class="i-checks m-b-none"> <input -->
								<!-- 										type="checkbox" ng-model="row1.select" id="section{{trIndex}}"><i></i></label></td> -->
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" disabled
												id="cntrTypeBx{{trIndex}}" ng-model="row1.cntrType"
												name="cntrTypeBx{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index+1 + '(cntr Type)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="noOfBoxBx{{trIndex}}" ng-model="row1.noOfBox"
												name="box{{trIndex}}" validation="required|number"
												friendly-name="{{ 'Row' + $index+1 + '(No Of Box)'}}" />
										</div>
									</div>
								</td>

								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="commodityList" property="row1.commodity"
												id="commodity{{trIndex}}" ng-model="row1.commodity"
												name="commodityBx{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(Commodity)'}}"
												form-name="bookingForm"></selectivity>
										</div>
									</div>
								</td>

							</tr>
						</tbody>
					</table>
				</div>
				
			</div>
			</tab> <tab heading="Routing"  ng-if="isEdit" ng-click="checkBookingT/S()" >
			<div class="panel-body">
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<fieldset>
							<!-- <div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">LICD </label>
									<div class="col-md-7">
										<selectivity list="licdList" ng-model="bookingData.rLicd"
											friendly-name="LICD" property="bookingData.rLicd" id="rLICD"
											name="rLICD" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div> -->
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL </label>
									<label class="col-md-5 control-label">{{bookingData.pol}}</label>
									<!-- <div class="col-md-7">
										<selectivity list="rPolList" ng-model="bookingData.rPol"
											friendly-name="Routing POL" property="bookingData.rPol"
											id="rpol" name="rpol" form-name="bookingForm"></selectivity>
									</div> -->
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> POD </label>
									<div class="col-md-7">
										<selectivity list="rPodList" ng-model="bookingData.rPod"
											friendly-name="Routing Pod" property="bookingData.rPod"
											id="rpod" name="rpod" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

				<!-- 	<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">DICD </label>
									<div class="col-md-7">
										<selectivity list="dicdList" ng-model="bookingData.rDicd"
											friendly-name="DICD" property="bookingData.rDicd" id="dicd"
											name="dicd" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>

						</fieldset>
					</div>
 -->
				</div>

				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan="13" class="text-center">Routing</th>
							</tr>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th colspan=1 class="width_13 text-center">From Port</th>
								<th colspan=1 class="width_10 text-center">To Port</th>
								<!-- <th colspan=1 class="width_10 text-center">Through Slot</th> -->
								<th colspan=1 class="width_10 text-center">Vessel</th>
								<th colspan=1 class="width_10 text-center">Voyage</th>
								<th colspan=1 class="width_10 text-center">ETA</th>
								<!-- <th colspan=1 class="width_10 text-center">ETD</th>
								<th colspan=1 class="width_10 text-center">Status</th> -->
							</tr>
						</thead>
						<tbody ng-controller="routingtableCtrl"
							ng-repeat="(trIndex1, row2) in bookingData.routingData track by trIndex1">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row2.selectRt"
										id="rtSelect{{trIndex1}}"><i></i></label></td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="fromPortList" property="row2.fromPort"
												id="fromPortRt{{trIndex1}}" ng-model="row2.fromPort"
												name="fromPortRt{{trIndex1}}"
												friendly-name="{{ 'Row' + $index + '(From Port )'}}"
												form-name="bookingForm"></selectivity>
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="toPortList" property="row2.toPort"
												id="toPortRt{{trIndex1}}" ng-model="row2.toPort"
												name="toPortRt{{trIndex1}}"
												friendly-name="{{ 'Row' + $index + '(To Port )'}}"
												form-name="bookingForm"></selectivity>
										</div>
									</div>
								</td>
								<!-- <td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="rThSlotList" property="row2.throughSlot"
												id="thSlotRt{{trIndex1}}" ng-model="row2.throughSlot"
												name="thSlotRt{{trIndex1}}"
												friendly-name="{{ 'Row' + $index + '(Through Slot)'}}"
												form-name="bookingForm"></selectivity>
										</div>
									</div>
								</td> -->
								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="row2.rVesselList" property="row2.vessel"
												id="vesselRt{{trIndex1}}" ng-model="row2.vessel"
												name="vesselRt{{trIndex1}}"
												friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
												form-name="bookingForm"></selectivity>
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="row2.rVoyageList" property="row2.voyage"
												id="voyageRt{{trIndex1}}" ng-model="row2.voyage"
												name="voyageRt{{trIndex1}}"
												friendly-name="{{ 'Row' + $index + '(Voyage)'}}"
												form-name="bookingForm"></selectivity>
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<ng-bs3-datepicker data-ng-model="row2.eta"
												id="etaRt{{trIndex1}}" name="etaRt{{trIndex1}}"
												form-name="bookingForm"
												friendly-name="{{ 'Row' + $index + '(ETA)'}}" disabled="true"/>
										</div>
									</div>
								</td>
								<!-- <td>
									<div class="row">
										<div class="col-xs-12">
											<ng-bs3-datepicker data-ng-model="row2.etd"
												id="etd{{trIndex1}}" name="etd{{trIndex1}}"
												form-name="bookingForm"
												friendly-name="{{ 'Row' + $index + '(ETD)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="statusList" property="row2.status"
												id="statusRt{{trIndex1}}" ng-model="row2.status"
												name="statusRt{{trIndex1}}"
												friendly-name="{{ 'Row' + $index + '(status)'}}"
												form-name="bookingForm"></selectivity>
										</div>
									</div>
								</td> -->
							</tr>
						</tbody>
					</table>
			<!-- 		<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addRtRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRtRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div> -->
					<!-- /padding-right-5 - /AddOrRmvebtn -->
				</div>
				<br> <br> <br>
				<!-- <div class="row book-widget-row">
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Switch Agent </label>
									<div class="col-md-7">
										<selectivity list="rSwitchAgentList"
											ng-model="bookingData.rSwitchAgent"
											friendly-name="Switch Agent"
											property="bookingData.rSwitchAgent" id="vessel"
											name="rSwitchAgent" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Switch Port </label>
									<div class="col-md-7">
										<selectivity list="rSwitchPortList"
											ng-model="bookingData.rSwitchPort"
											friendly-name="Switch Port"
											property="bookingData.rSwitchPort" id="rSwitchPort"
											name="rSwitchPort" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
						</fieldset>
					</div>

				</div> -->


			</div>
			</tab> </tabset>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12">
						<button class="btn btn-success" type="button" ng-if="!isEdit" ng-disabled="check"
							ng-click="saveBooking(bookingForm)">
							<i class="fa fa-save"></i> Save
						</button>
						<button class="btn btn-success" type="button" ng-if="isEdit" ng-disabled="check"
							ng-click="saveBooking(bookingForm,booking)">
							<i class="fa fa-save"></i> Update
						</button>
						<button class="btn btn-info" type="button" ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button>
						<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Cancel
						</button>
					</div>
				</div>
			</div>
			<br><br><br>
		</form>
	</div>
</div>