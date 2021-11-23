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
						
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Mode<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
										<!-- <selectivity list="quotationnoList" ng-model="bookingData.quotationno" disabled="isEdit"
											validation="required" friendly-name="quotationno"
											property="bookingData.quotationno" id="quotationno" name="quotationno" 
											form-name="bookingForm"></selectivity> -->
											<selectivity list="modeList"
										property="bookingData.mode" id="mode"
										name="mode" ng-model="bookingData.mode"
										 friendly-name="Mode" 
										validation="required" form-name="bookingForm"
										></selectivity>
									</div>
								</div>
							</div>
						
								
									<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Booking Date </label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="bookingData.bookingDate"
											id="bookingDate" name="bookingDate" form-name="bookingForm"
											disabled friendly-name="Booking Date" validation="required" disabled="isEdit"/>

									</div>
								</div>
							</div>
								<div class="col-md-4">
							 <div class="form-group ">
								<label class="col-md-5 control-label">Service <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="servicePartnerTypelist"
										property="bookingData.service" id="service"
										name="service" ng-model="bookingData.service"
										  friendly-name="service"
								          form-name="bookingForm" disabled="true"
										></selectivity>
										
								</div>
								</div>
								<!-- <div class="form-group">
									<label class="col-md-5 control-label">Vessel<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
										<selectivity list="vesselList" ng-model="bookingData.vessel"
											validation="required" friendly-name="vessel"
											property="bookingData.vessel" id="vessel" name="vessel" disabled="isEdit"
											form-name="bookingForm"></selectivity>
									</div>
								</div> -->
							</div>
									</fieldset>
								</div>
								<div class="col-sm-12">
						<fieldset>
						
						<div class="col-md-4">
									<div class="form-group">
									<label class="col-md-5 control-label">Carrier <span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<selectivity list="carrierList" ng-model="bookingData.carrier"
										 property="bookingData.carrier"
										id="carrier" 
										friendly-name="Carrier"
										form-name="bookingForm"></selectivity>
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
											property="bookingData.vessel" id="vessel" name="vessel" disabled="isEdit"
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
											property="bookingData.voyage" id="Voyage" name="Voyage" disabled="isEdit"
											form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
								
									</fieldset>
								</div>
							<div class="col-sm-12">
						       <fieldset>
								
						<div class="col-md-4" ng-if="bookingData.mode==4">
								<div class="form-group ">
								<label class="col-md-5 control-label">POT </label>
								<div class="col-md-7">
										<selectivity list="portList"
										property="bookingData.pot" id="pot"
										name="pot" ng-model="bookingData.pot"
										object="pot" friendly-name="pot"
										form-name="bookingForm"
										></selectivity>
										
								</div>
								</div>
								</div>
								
									
									<div class="col-md-4" ng-if="bookingData.mode==4">
								
								<div class="form-group ">
								<label class="col-md-5 control-label">FPOD </label>
								<div class="col-md-7">
										<selectivity list="portList"
										property="bookingData.fpod" id="fpod"
										name="fpod" ng-model="bookingData.fpod"
										object="fpod" friendly-name="fpod"
										form-name="bookingForm"
										></selectivity>
										
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
										<selectivity list="customerDropList" ng-model="bookingData.customer"
											validation="required" friendly-name="customer"
											property="bookingData.customer" id="customer" name="customer"
											form-name="bookingForm"></selectivity>
									</div>
									
								</div>
							
							</div>
							
								
								
								
							<div class="col-md-4"><div class="form-group">
									<label class="col-md-5 control-label">POL<span
										style="color: red;">*</span></label>
									<div class="col-md-7" >
										<selectivity list="portList1" ng-model="bookingData.pol"
											validation="required" friendly-name="Pol"
											property="bookingData.pol" id="pol" name="pol" 
											form-name="bookingForm"></selectivity>
									</div>
								<!-- 	<div class="col-md-7" ng-if="bookViaQt">
										<label class="col-md-5 control-label">{{bookingData.pol}}</label>
									</div> -->
								</div>
								
							</div>
							<div class="col-md-4">
							<div class="form-group">
								
									<label class="col-md-5 control-label">POD<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7" >
										<selectivity list="portList1" ng-model="bookingData.pod" 
											validation="required" friendly-name="pod" 
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
								<div class="form-group ">
								<label class="col-md-5 control-label">Quotation<span
										style="color: red;">*</span>
									</label>
<div class="col-md-7">
										<selectivity list="quotationnoList" ng-model="bookingData.quotationno" disabled="isEdit"
											validation="required" friendly-name="quotationno"
											property="bookingData.quotationno" id="quotationno" name="quotationno" 
											form-name="bookingForm"></selectivity>
									



								</div>
								</div>
							
								</div>
							
							 <div class="col-md-4">
							<div class="form-group ">
							
								<label class="col-md-5 control-label">Origin <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="portList"
										property="bookingData.origin" id="origin"
										name="origin" ng-model="bookingData.origin"
										 friendly-name="Quotation Type"
										 form-name="bookingForm"
										></selectivity>
							</div>
							
							</div>
								
							</div>
							<div class="col-md-4">
							<div class="form-group">
									<label class="col-md-5 control-label">Destination<span
										style="color: red;"></span></label>
									<div class="col-md-7">
										<selectivity list="portList" ng-model="bookingData.destination" disabled="value"
											 friendly-name="FPOD" property="bookingData.destination" 
											id="fpod" name="fpod" form-name="bookingForm"></selectivity>
									</div>
								</div>
								
							</div>
							
							<div class="col-md-4">
							
							<div class="form-group ">
							
								<label class="col-md-5 control-label">Pickup Point <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="pickupList"
										property="bookingData.picPoint" id="picPoint"
										name="picPoint" ng-model="bookingData.picPoint"
										object="picPoint" friendly-name="picPoint"
										 form-name="bookingForm"
										></selectivity>
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
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Consignee </label>
									<div class="col-md-7">
										<selectivity list="consigneeDropList"
											ng-model="bookingData.consignee" friendly-name="consignee"
											property="bookingData.consignee" id="consignee" disabled="value"
											name="consignee" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							
						</fieldset>
					</div><div class="col-sm-12">
						       <fieldset>
								
						<div class="col-md-4">
								<div class="form-group ">
								<label class="col-md-5 control-label">Commodity <span
									style="color: red">*</span></label>
								<div class="col-md-7">					
										<!-- <input type="text" class="form-control input-sm"
										name="commodity" 
										property="bookingData.commodity" id="commodity" ng-model="bookingData.commodity"
										friendly-name="commodity" /> -->
										
										<!-- <selectivity list="commodityList"
										property="bookingData.commodity" id="commodity"
										name="commodity" ng-model="bookingData.commodity"
										object="commodity" friendly-name="Commodity"
										form-name="bookingForm"
										></selectivity> -->
										<div class="col-md-15 "
										class="selectivity-input example-input selectivity-slot voyage_sel">
									<!-- <select id="commodityL" multiple="multiple" name="commodity"
									friendly-name="commodity"  form-name="bookingDataForm"
										ng-model="bookingData.commodity" validation="required"
										ng-options="option.text for option in commodityList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in commodityList" 
											value="{{getOptionId(option)}}"
											data-ng-bind-template="{{option.commodity}}"></option>
									</select> -->
									<select id="commodityL" multiple="multiple" name="commodityL"
									friendly-name="commodityL"  form-name="bookingDataForm"
										ng-model="bookingData.commodityL" validation="required"
										ng-options="option.text for option in commodityList"
										data-dropdownmultiselect>
										<option data-ng-repeat="option in commodityList" 
											value="{{getOptionId(option)}}"
											data-ng-bind-template="{{option.commodityL}}"></option>
									</select>										
										 
									</div>
										
										
							</div>
								</div>
								</div>
								
									
									<div class="col-md-4">
								
								<div class="form-group ">
								<label class="col-md-5 control-label">Currency <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="currencylist"
										property="bookingData.currency" id="currency"
										name="currency" ng-model="bookingData.currency"
										 friendly-name="Currency"
										validation="required" form-name="bookingForm"
										></selectivity>
										
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
								
								
							
									    
						</fieldset>
						</div>
						
						
						<div class="col-sm-12">
						       <fieldset>
							
							<div class="col-md-4">
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Sales Type <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="salesTypeList"
										property="bookingData.salesType" id="salesType"
										name="salesType" ng-model="bookingData.salesTypee"
										 friendly-name="Sales Type"
									  form-name="bookingForm"
										></selectivity>
							</div>
							</div>
							
							</div>
							
								<div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-5 control-label">Nominated By <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="nominatedDropList"
										property="bookingData.nominatedBy" id="nominatedBy"
										name="nominatedBy" ng-model="bookingData.nominatedBy"
									
										 form-name="bookingForm"
										></selectivity>
							</div>
							</div>
								</div>
								
									<div class="col-md-4">
								<div class="form-group ">
								<label class="col-md-5 control-label">Sales Person <span
									style="color: red"></span></label>
								<div class="col-md-7">
										<selectivity list="employeeList"
										property="bookingData.salesPerson" id="salesPerson"
										name="salesPerson" ng-model="bookingData.salesPerson"
									friendly-name="salesPerson"
										 form-name="bookingForm"
										></selectivity>
							</div>
							</div>
									</div>
									
									
											</fieldset>
								</div>
								
								
								
							
							
					
						
					<div class="col-sm-12">
						<fieldset>
							
							<div class="col-md-4">
								<div class="form-group ">
								<label class="col-md-5 control-label">Branch <span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="branchList"
										property="bookingData.branch" id="branch"
										name="branch" ng-model="bookingData.branch"
										 friendly-name="Branch"
										validation="required" form-name="bookingForm"></selectivity>
										
								</div>
								</div>
							</div>
							
							<div class="col-md-4">
							
								<div class="form-group ">
								<label class="col-md-5 control-label">Contract Type<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="contractTypeList"
										property="bookingData.contractType" id="contractType"
										name="contractType" ng-model="bookingData.contractType"
										 friendly-name="contractType"
										form-name="bookingForm" disabled="true"
										></selectivity>
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
										<selectivity list="shipperDropList" ng-model="bookingData.shipper"
											friendly-name="shipper" property="bookingData.shipper" disabled="value"
											id="shipper" name="shipper" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							<!-- <div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-5 control-label">Special <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<selectivity list="SpecialList" ng-model="bookingData.special"
										 property="bookingData.special"
										id="special" 
										friendly-name="Special"
										form-name="bookingForm"></selectivity>
								</div>
							</div></div> -->
							
					
							 <div class="col-md-4">
							<div class="form-group ">
								<label class="col-md-5 control-label">Cargo Type <span
									style="color: red"></span></label>
								<div class="col-md-7" style="margin-top: 6px;">
									<selectivity list="cargoType" ng-model="bookingData.cargoType"
										 property="bookingData.cargoType"
										id="cargoType" 
										friendly-name="Cargo Type"
										form-name="bookingForm"></selectivity>
								</div>
							</div></div> 
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Notify Party </label>
									<div class="col-md-7">
										<selectivity list="notifyPartyList"
											ng-model="bookingData.notifyParty"
											friendly-name="Notify Party" disabled="notifyParty"
											property="bookingData.notifyParty" id="notifyParty"
											name="notifyParty" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div>
							
						</fieldset>
					</div>
<div class="col-sm-12">
						<fieldset>
						
							
						<!-- 	<div class="col-md-4">
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
							</div> -->
						</fieldset>
						</div>

					<div class="col-sm-12">
						<fieldset>
							
<!-- 
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
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Consignee </label>
									<div class="col-md-7">
										<selectivity list="consigneeDropList"
											ng-model="bookingData.consignee" friendly-name="consignee"
											property="bookingData.consignee" id="consignee" disabled="value"
											name="consignee" form-name="bookingForm"></selectivity>
									</div>
								</div>
							</div> -->
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Freight Terms
									</label>
									<div class="col-md-7">
										<selectivity list="TermList" ng-model="bookingData.term"
											friendly-name="term" property="bookingData.term"  disabled="value"
											disabled id="term" name="term"  form-name="bookingForm"></selectivity>
									</div>
									
								</div>
							</div>
							
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
							
							</div> 
							
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
							
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>
						
							
	 
						</fieldset>
					</div>
					
					 
				</div>
<tabset justified="true" class="tab-container"> <tab
						heading="Container Type &
									Quantity"
						style=" background: #a8ccce;">
				<div class="table-responsive clear" style="height:265px;">
					<table class="table table-striped b-t b-light">
						<thead>
						<!-- 	<tr>
								<th colspan="13" class="text-center"></th>
							</tr> -->
							<tr>
								<th colspan=1 class="width_5"  >Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th> 
								<th colspan=1 class="width_10 text-center">Container Type</th>
								<th colspan=1 class="width_10 text-center">No. Of
									Containers</th>
								<th colspan=1 class="width_10 text-center">Commodity<span
										style="color: red;">*</span></th>
								<!-- <th colspan=1 class="width_10 text-center">Free Days</th> -->
								<th colspan=1 class="width_10 text-center">Hazardous<span
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
				<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="row1.select" id="section{{trIndex}}"><i></i></label></td> 
								<td>
									<div class="row">
										<div class="col-xs-10">
										
										<selectivity list="conTypeList"
											property="row1.cntrType" 
											ng-model="row1.cntrType"  
											name="cntrTypeBx{{trIndex}}" ></selectivity>
											
										</div>
									</div>
								</td>
									  <!--  <input type="text" class="form-control input-sm" 
												id="cntrTypeBx{{trIndex}}" ng-model="row1.cntrType"
												name="cntrTypeBx{{trIndex}}" validation="required"  
												friendly-name="{{ 'Row' + $index+1 + '(cntr Type)'}}"/>  -->
								
								<td>
									<div class="row">
										<div class="col-xs-10">
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
									<!-- <td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" 
												id="freeDays{{trIndex}}" ng-model="row1.freeDays"
												name="freeDays{{trIndex}}"   
												friendly-name="{{ 'Row' + $index + '(freeDays)'}}" 
												form-name="bookingForm"/>
										</div>
									</div>
								</td> -->
								<td class="width_1" align="center">
										<div class="row">

											<input type="checkbox" data-ng-model="row1.hazardous"
												id="hazardous{{trIndex}}" name="hazardous{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(hazardous)'}}" >


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
						<button ng-click="addRow1()" class="btn btn-sm btn-info"
							  type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRow1()" class="btn btn-sm btn-danger"
							  type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
					 
					<br>
<br>
<br>
 
				</div>
				</tab>
				<tab
						heading="Quotation Freight Details" 
						style="background: #a8ccce;" ng-show ="quotationdetailtab">
<div class="table-responsive clear">
			<div>
					<table class="table table-striped b-t b-light">
						<tr>
<!-- 							<th colspan=1 class="width_1 text-center"></th>
 -->							
 								<th colspan=1 class="width_7">Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec1(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th> 
 
  <th colspan=1 class="width_17 text-center">Charge Heads <span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_12 text-center">Unit <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_7 text-center">Container Type <span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_6 text-center">Qty <span
								style="color: red">*</span></th>
							<th colspan=1 class="width_8 text-center">Rate<span
								style="color: red">*</span></th>
							<th colspan=1 class="width_10 text-center">Currency <span
									style="color: red">*</span></th>
							<!-- 	<th colspan=1 class=" width_10 text-center">Payment Method <span
								style="color: red">*</span></th> -->
							<th colspan=1 class=" width_6 text-center">Transaction Type <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_16 text-center">Buy/Sell Party <span
								style="color: red">*</span></th>
								<th colspan=1 class=" width_8 text-center">Notes <span
								style="color: red"></span></th>
						</tr>
						<tbody ng-repeat="(trIndex, row) in bookingData.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"
										ng-disabled="true"> <i></i>
								</label></td>
								<td class=" width_9"><selectivity list="chargeHeadList" 
										property="row.chargeHeads" id="chargeHeads{{trIndex}}" ng-model="row.chargeHeads"
										 validation="required"
										name="chargeHeads{{trIndex}}" 
										friendly-name="{{ 'Row' + ($index+1) + '(ChargeHeads)'}}"
										form-name="bookingForm" ></selectivity></td>
								<td class=" width_9">
										<selectivity list="UnitList"
										property="row.unit" id="unit" 
										name="unit" ng-model="row.unit"
									    friendly-name="{{ 'Row' + ($index+1) + '(Unit)'}}"
										validation="required" form-name="bookingForm"
										></selectivity>
										</td>
											<td crlass="width_7"><selectivity list="conTypeList"
											property="row.conType"   
											ng-model="row.conType"      friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
											name="conType{{trIndex1}}" ></selectivity></td>
						<td class=" width_6" ><input type="text" class="form-control input-sm text-right"
										name="qty" 
										property="row.qty" id="qty{{trIndex}}" ng-model="row.qty" 
										friendly-name="{{ 'Row' + ($index+1) + '(Qty)'}}" />
										</td>
								
								<td class=" width_8" ><input type="text" class="form-control input-sm text-right"
										name="rate" 
										property="row.rate" id="rate{{trIndex}}" ng-model="row.rate" 
										friendly-name="{{ 'Row' + ($index+1) + '(rate)'}}" />
								</td>
								<td class=" width_10" ><selectivity list="currencylist" 
										property="row.currency" id="currency{{trIndex}}" ng-model="row.currency"
										 validation="required"
										name="currency{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Currency)'}}"
										form-name="bookingForm" ></selectivity></td>
											
										<!-- 	<td class=" width_10" style="padding-left: 32px;"><selectivity list="PaymentMethodList"
										property="row.paymentMethod" id="paymentMethod{{trIndex}}" ng-model="row.paymentMethod"
										 validation="required"
										name="paymentMethod{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(PaymentMethod)'}}"
										form-name="bookingForm" ></selectivity></td>
										 -->
										<td class=" width_8"><selectivity list="transactionTypeList" 
										property="row.transactionType" id="transactionType{{trIndex}}" ng-model="row.transactionType"
										 validation="required"
										name="transactionType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Transaction Type)'}}"
										form-name="bookingForm" ></selectivity></td>
										
													<td class=" width_12"><selectivity list="serviceParnrDropList" 
										property="row.buySell" id="buySell{{trIndex}}" ng-model="row.buySell"
										 validation="required"
										name="buySell{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(Buy Sell)'}}"
										form-name="bookingForm" ></selectivity></td>
										
										<td class=" width_8"  style="padding-left: -56px;">
										<textarea  type="text" class="form-control input-sm"
															name="note"   
															class="custom-scroll width_250 resize-none" rows="3" 
															property="row.note" id="note{{trIndex}}" ng-model="row.note"
										                   friendly-name="{{ 'Row' + ($index+1) + '(note)'}}">
															</textarea>
							</tr>
						</tbody>
					</table>

						 
					</div>
					<br>
<br>
<br>
 
				</div>
</tab>

<!-- <tab heading="Additional Charges" style="background: #a8ccce;"  >
						
						<div class="table-responsive clear">
			<div>
						<table class="table table-striped b-t b-light">
							<tr>
							
							<th colspan=1 class="width_1 "> Select</th>
							
																<th colspan=1 class="width_3"  >Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec3(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th> 
								
								
								<th colspan=1 class=" width_6 text-center">Charge Type<span
									style="color: red"></span></th>
									<th colspan=1 class="width_6 text-center">Currency<span
									style="color: red"></span></th>
								<th colspan=1 class=" width_6 text-center"> Rate<span
									style="color: red"></span></th>
								 	

							</tr>
							<tbody ng-repeat="(trIndex, row) in bookingData.additionalChargesList" >
								<tr>
								<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex}}">
											<i></i>
									</label></td>

									<td class=" width_4"><selectivity list="chargeHeadList"
											property="row.chargeType" id="chargeType{{trIndex}}"
											ng-model="row.chargeType" validation="required"  
											name="chargeType{{trIndex}}"
											friendly-name="{{ 'Row' + ($index+1) + '(chargeType)'}}"
											 ></selectivity></td>
									<td class=" width_4"><selectivity list="currencyList"
											property="row.currency" 
											ng-model="row.currency"   
											name="currency{{trIndex}}"></selectivity></td>
									<td class=" width_4"><input type="text"
										class="form-control input-sm text-right" name="rate"
										property="row.rate" id="rate{{trIndex}}"
										ng-model="row.rate"  
										friendly-name="{{ 'Row' + ($index+1) + '(rate)'}}"
										 /></td>
 								</tr>
							</tbody>
						</table>
							<button ng-click="addRow()" class="btn btn-sm btn-info"
							  type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRow()" class="btn btn-sm btn-danger"
							  type="button">
							<i class="fa  fa-trash-o"></i>
						</button>
						 
					</div>
					<br>
<br>
<br>
 
				</div>
						</tab> -->
						<tab
heading="Local Charges" ng-if="bookingData.mode=='4'">
<div class="table-responsive clear">
<div class="wrapper-md">

<div class="row padding-top-10">
<div class="col-sm-12">
<div>
<tabset justified="true" class="tab-container"> <tab
heading="Freight/Origin/Destination Charges"
style="background:#5F9EA0; ">
<div>
<table class="table table-striped b-t b-light">
<thead>
<tr>
<th colspan=1 class="width_1">Select</th>

<th colspan=1 class="width_15 text-center">Surcharge<span
style="color: red;"> </span></th>

<!-- <th colspan=1 class="width_10 text-center">Charge Type<span
style="color: red;"> </span></th> -->
<th colspan=1 class="width_3 text-center">UOM</th>
<th colspan=1 class="width_5 text-center"
>Container Type<span
style="color: red;"> </span></th>

<th colspan=1 class="width_5 text-center">Hazardous<span
style="color: red;"> </span></th>
<th colspan=1 class="width_5 text-center">OOG Cargo<span
style="color: red;"> </span></th>
<th colspan=1 class="width_5 text-center">Currency<span
style="color: red;"> *</span></th>
<th colspan=1 class="width_5 text-center">Tax(%)<span
style="color: red;"> </span></th>
<th colspan=1 class="width_5 text-center">Quoted Rate<span
style="color: red;">*</span></th>
<th colspan=1 class="width_5 text-center">Quantity<span
style="color: red;">*</span></th>

<th colspan=1 class="width_10 text-center">Remarks<span
style="color: red;"></span></th>
</tr>
</thead>
<tbody ng-repeat="(trIndex, row) in bookingData.addchargeData track by trIndex">
<tr>
<td><label class="i-checks m-b-none"> <input
type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>



<td class="width_10">


<selectivity list="chargeHeadList" property="row.surcharge"
id="surcharge{{trIndex}}" data-ng-model="row.surcharge"
name="surcharge{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(surcharge)'}}"
form-name="surcharge"></selectivity>

</td>
<!-- <td class="width_10">


<selectivity list="contTypeList" property="row.chargeType"
id="chargeType{{trIndex}}" data-ng-model="row.chargeType"
name="chargeType{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(chargeType)'}}"
></selectivity>
</td> -->
<td class="width_10">


<selectivity list="UnitList" property="row.uom"
id="uom{{trIndex}}" data-ng-model="row.uom"
name="uom{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(uom)'}}"
></selectivity>
</td>

<td class="width_5">
<div class="row">
<div class="col-xs-12">

<selectivity list="conTypeList"
property="row.conType" id="conType{{trIndex}}"
data-ng-model="row.conType"
name="conType{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(conType)'}}"
form-name="localForm"></selectivity>

</div>
</div>
</td>


<td class="width_5" align="center">
<div class="row">

<input type="checkbox" data-ng-model="row.hazardous"
id="hazardous" name="hazardous{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(hazardous)'}}">


</div>
</td>


<td class="width_5" align="center">
<div class="row">

<input type="checkbox" data-ng-model="row.oog" id="oog"
name="oog{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(oog)'}}">


</div>
</td>


<td class="width_10">
<div class="row">
<div class="col-xs-12">
<selectivity list="currencylist" property="row.addchrgcurrency"
id="addchrgcurrency{{trIndex}}" data-ng-model="row.addchrgcurrency"
name="addchrgcurrency{{trIndex}}" validation="required"
friendly-name="{{ 'Row' + $index + '(addchrgcurrency)'}}"
></selectivity>
</div>
</div>
</td>
<td class="width_5">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
maxlength=255 data-ng-model="row.addchrgtax"
name="addchrgtax{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(addchrgtax)'}}" />
</div>
</div>
</td>
<td class="width_5">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
maxlength=255 data-ng-model="row.bookingRate"
name="bookingRate{{trIndex}}"

friendly-name="{{ 'Row' + $index + '(bookingRate)'}}" />
</div>
</div>
</td>

<td class="width_5">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
maxlength=255 data-ng-model="row.bookingqty"
name="bookingqty{{trIndex}}" validation="required"

friendly-name="{{ 'Row' + $index + '(bookingqty)'}}" />
</div>
</div>
</td>

<td class="width_10">
<div class="row">
<div class="col-xs-16">
<input type="text" class="form-control input-sm"
data-ng-model="row.bookremarks"
name="bookremarks{{trIndex}}"
friendly-name="{{ 'Row' + $index + '(bookremarks)'}}" />
</div>
</div>
</td>



</tr>


</tbody>
</table>

<button ng-click="addAdditionalRow()" class="btn btn-sm btn-info"
ng-disabled="subForm.$invalid" type="button">
<i class="fa fa-plus"></i>
</button>
<button ng-click="removequoRow()" class="btn btn-sm btn-danger"
ng-disabled="userForm{{$index}}.$invalid" type="button">
<i class="fa fa-trash-o"></i>
</button>
</div>
<br><br>

</tab></tabset>
</div>
</div>


</div>
</div>
<br>
<br>
<br>

</div>
</tab>


</tabset>


<br><br>
							<div>
						<table class="table table-striped b-t b-light" ng-if=bookingData.mode!="5">
							<tr>

								<!-- <th colspan=1 class="width_1 "><label
									class="i-checks m-b-none"> <input type="checkbox"
										ng-click="checkAllFreeDays()" ng-model="quotation.checkAllFreeDays"> <i></i>
								</label></th> -->
 
 
 								
 
								<th colspan=1 class="width_8 text-center">Container Type<span
									style="color: red"></span></th>
								 
									<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POL Free Days<span
									style="color: red;"> </span></th>
									<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POL Free Days<span
									style="color: red;"> </span></th>	
									<th colspan=1 class="width_8 text-center">Liner Detention (LD) - POD Free Days<span
									style="color: red;"> </span></th>	
								<th colspan=1 class="width_8 text-center">Ground Rent (GR) - POD Free Days<span
									style="color: red;"> </span></th>		
										

							</tr>
							<tbody ng-repeat="(trIndex1, row) in bookingData.quotationFreeDaysDtl"
								ng-controller="quotationtableCtrl">
								<tr>
								
								<!-- 	<td><label class="i-checks m-b-none"> <input
											type="checkbox" ng-model="row.select" id="section{{trIndex1}}">
											<i></i>
									</label></td> -->
 
									<td class=" width_9"><selectivity list="conTypeList"  disabled="true"
											property="row.conType" 
											ng-model="row.conType"  
											name="conType{{trIndex1}}" ></selectivity></td>
									  
									 <td class=" width_9"><input type="text" disabled="true"
										class="form-control input-sm text-right" name="freeDays"
										property="row.polFreeDays" id="polFreeDays{{trIndex}}"
										ng-model="row.polFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pol FreeDays)'}}"
										 /></td>
										 <td class=" width_9"><input type="text" disabled="true"
										class="form-control input-sm text-right" name="freeDays"
										property="row.polFreeDays1" id="polFreeDays1{{trIndex1}}"
										ng-model="row.polFreeDays1"
										friendly-name="{{ 'Row' + ($index+1) + '(Pol FreeDays1)'}}"
										 /></td>
										 <td class=" width_9"><input type="text"  disabled="true"
										class="form-control input-sm text-right" name="freeDays"
										property="row.podFreeDays" id="podFreeDays{{trIndex2}}"
										ng-model="row.podFreeDays"
										friendly-name="{{ 'Row' + ($index+1) + '(Pod FreeDays)'}}"
										 /></td>
										 <td class=" width_9"><input type="text"  disabled="true"
										class="form-control input-sm text-right" name="freeDays"
										property="row.podFreeDays1" id="podFreeDays1{{trIndex3}}"
										ng-model="row.podFreeDays1"
										friendly-name="{{ 'Row' + ($index+1) + '(Pod FreeDays)'}}"
										 /></td>
								</tr>
							</tbody>
						</table>

						<!-- <button ng-click="addRowFreeDays()" class="btn btn-sm btn-info"
							ng-disabled="subForm.$invalid" type="button">
							<i class="fa fa-plus"></i>
						</button>
						<button ng-click="removeRowFreeDays()" class="btn btn-sm btn-danger"
							ng-disabled="userForm{{$index}}.$invalid" type="button">
							<i class="fa  fa-trash-o"></i>
						</button> -->
					</div>
					<br><br>

			</div>
			<!-- <div class="panel-body" ng-if="bookViaQt">
							<form name="bookingForm" class="form-horizontal"  method="post" novalidate>
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
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation </label>
									<div class="col-md-7" ng-if="bookViaQt">
										<label class="control-label"><b>{{bookingData.quotation}}</b></label>
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

																				<input type="text" class="form-control input-sm text-right"
																					ng-model="bookingData.destination" name="destination"
																					id="destination" form-name="bookingForm"
																					friendly-name="destination" />
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
									<label class="col-md-5 control-label"> Freight Terms2
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
																<th colspan=1 class="width_1"></th>
								<th colspan=1 class="width_13 text-center">Container Type</th>
								<th colspan=1 class="width_10 text-center">No. Of
									Containers</th>
								<th colspan=1 class="width_10 text-center">Commodity</th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in bookingData.boxData track by trIndex">
							<tr>
																<td><label class="i-checks m-b-none"> <input
																		type="checkbox" ng-model="row1.select" id="section{{trIndex}}"><i></i></label></td>
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
				
			</div> -->
			</tab> <tab heading="Routing"  ng-if="false" ng-click="checkBookingT/S()" >
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
						<button class="btn btn-success" type="button" ng-if="!isEdit" 
							ng-click="saveBooking(bookingForm)">
							<i class="fa fa-save"></i> Save
						</button>
						<button class="btn btn-success" type="button" ng-if="isEdit && bookingData.status=='Pending'" 
							ng-click="saveBooking(bookingForm,booking)">
							<i class="fa fa-save"></i> Update
						</button>
						<button class="btn btn-info" type="button" ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button>
						<button class="btn btn-danger" ng-click="cancel()" type="button">
							<i class="fa fa-close"></i> Back
						</button>
					</div>
				</div>
			</div>
			<br><br><br>
		</form>
	</div>
</div>