
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md">
	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form name="deliveryorderForm" class="form-horizontal" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							 <div class="form-group " ng-if="isEdit">
								<label class="col-md-4 control-label"> DO No. </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="doNumber" id="doNumber"
										ng-model="deliveryorder.doNumber"
										form-name="deliveryorderForm" ng-disabled="true" />
								</div>
								
							</div> 
						 <!-- <div class="form-group">
										<label class="col-md-1 control-label">NOC</label>
										<div class="col-md-2" style=" padding-top: 6px;">
										<input type="checkbox" name="nocCheck" id="nocCheck" ng-model="deliveryorder.nocCheck"  ng-click="nocCheck(deliveryorder.nocCheck)" form-name="deliveryorderForm"><i></i>
								</div>
								</div> -->
							 <div class="form-group" ng-if="!isEdit">
								<label class="col-md-4 control-label"> Mode<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									
										<selectivity list="modeList" ng-model="deliveryorder.mode"
											validation="required" friendly-name="Mode"
											property="deliveryorder.mode" id="mode" name="mode" 
											form-name="deliveryorderForm"></selectivity>
										
								</div>
								<div class="form-group">
										<label class="col-md-1 control-label">NOC</label>
										<div class="col-md-2" style=" padding-top: 6px;">
										<input type="checkbox" name="nocCheck" id="nocCheck" ng-model="deliveryorder.nocCheck"  ng-click="nocCheck(deliveryorder.nocCheck)" form-name="deliveryorderForm"><i></i>
								</div>
								</div>
							</div>
						 
							<div class="form-group" ng-if="isEdit">
								<label class="col-md-4 control-label"> Mode<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
<input type="text" class="form-control input-sm"
										name="mode" id="modeName"
										ng-model="deliveryorder.modeName"
										form-name="deliveryorderForm" ng-disabled="true" />									
										<!-- <selectivity list="modeList" ng-model="deliveryorder.mode"
											validation="required" friendly-name="Mode"
											property="deliveryorder.mode" id="mode" name="mode" disabled="true"
											form-name="deliveryorderForm"></selectivity> -->
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Vessel <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<selectivity list="vesselList" property="deliveryorder.vessel"
										id="vessel" ng-model="deliveryorder.vessel" name="vessel"
										validation="required" friendly-name="Vessel" 
										form-name="deliveryorderForm"></selectivity>
								</div>
							</div>
							
							
							
							<div class="form-group" ng-if="isEdit">
								<label class="col-md-4 control-label"> BL No.<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="blNoNew" id="blNoNew"
										ng-model="deliveryorder.blNoNew"
										form-name="deliveryorderForm" ng-disabled="true" />
								</div>
							</div>
							
							 <!-- <div class="form-group">
								<label class="col-md-4 control-label"> BL No. <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<selectivity list="blnoList" property="deliveryorder.blNo"
										id="blNo" ng-model="deliveryorder.blNo" name="blNo"
										validation="required" friendly-name="Bl NO" disabled="isEdit"
										form-name="deliveryorderForm"></selectivity>
								</div>
							</div>  -->
							 
							<div class="form-group" ng-if="!isEdit">
								<label class="col-md-4 control-label"> BL No.<span
									style="color: red;">*</span> </label>
								<div class="col-md-5">
									
										
										<selectivity list="blList"
										property="deliveryorder.blNo" id="blNo"
										ng-model="deliveryorder.blNo" name="blNo"
										form-name="deliveryorderForm" ></selectivity>
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Arrival Date </label>
								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="deliveryorder.arrivalDate"
										id="arrivalDate" name="arrivalDate"
										form-name="deliveryorderForm" ng-disabled="true" />
								</div>
							</div>
							
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">BL Status </label>
								<div class="col-md-5">
									
										
										<input type="text" class="form-control input-sm"
										name="status" id="status"
										ng-model="deliveryorder.status"
										form-name="deliveryorderForm" ng-disabled="true" />
								</div>
							</div> -->
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Freight Term </label>
								<div class="col-md-5">
									<selectivity list="termList" property="deliveryorder.viewfreight"
									validation="required" validation="required"
									data-ng-model="deliveryorder.viewfreight" name="Term" form-name="deliveryorderForm"
									friendly-name="Term" > </selectivity>
									<!-- <input type="text" class="form-control input-sm"
										name="viewfreight" id="viewfreight"
										ng-model="deliveryorder.viewfreight"
										form-name="deliveryorderForm" disabled="true"/> -->
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Remarks </label>
								<div class="col-md-5">
									
										<textarea type="text" class="form-control input-sm" 
										name="doRecipient" " form-name="deliveryorderForm"
										class="custom-scroll width_250 resize-none" rows="4"
										ng-model="deliveryorder.remarks">
									</textarea>
								</div>
							</div>
							
							<div class="form-group" ng-if="!isEdit">
								<label class="col-md-4 control-label"> DO Recipient </label>
								<div class="col-md-5">
									
										
										<textarea type="text" class="form-control input-sm" ng-disabled="check"
										name="doRecipient" " form-name="deliveryorderForm"
										class="custom-scroll width_250 resize-none" rows="3"
										ng-model="deliveryorder.doRecipient" >
									</textarea>
								</div>
								
								<label class="i-checks" style="    padding-top: 28px;padding-left: 28px;"><input type="checkbox"
													name="doCheck" id="doCheck" ng-model="deliveryorder.doCheck" ng-click="checkDoRecipient(deliveryorder.doCheck)"><i></i></label>
							</div>
							<div class="form-group" ng-if="isEdit">
								<label class="col-md-4 control-label"> DO Recipient </label>
								<div class="col-md-5">
									
										
										<textarea type="text" class="form-control input-sm" ng-disabled="check"
										name="doRecipient" " form-name="deliveryorderForm"
										class="custom-scroll width_250 resize-none" rows="3"
										ng-model="deliveryorder.doRecipient" ng-disabled="true" >
									</textarea>
								</div>
								
								
							</div>
							

							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> MRN </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="mrn"
										id="mrn" ng-model="deliveryorder.mrn"
										form-name="deliveryorderForm" />
								</div>
							</div> -->


							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Quantity </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="quantity" id="quantity"
										ng-model="deliveryorder.quantity"
										form-name="deliveryorderForm" />
								</div>
							</div> -->
							
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Do Valid Date </label>
								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="deliveryorder.doVaildDate"
										id="doVaildDate" name="doVaildDate"
										form-name="deliveryorderForm" />
								</div>
							</div> -->
							
							

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
						
						<div class="form-group" ng-if="noccheck">
								<label class="col-md-4 control-label"> NOC </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="noc" id="noc"
										ng-model="deliveryorder.noc"
										form-name="deliveryorderForm" >
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Date </label>
								<div class="col-md-5">
									<ng-bs3-datepicker data-ng-model="deliveryorder.currenctDate"
										id="currenctDate" name="currenctDate"
										form-name="deliveryorderForm" ng-disabled="true" />
								</div>
							</div>
							
							
							


<div class="form-group">
								<label class="col-md-4 control-label"> Voyage <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<selectivity list="voyageList" property="deliveryorder.voyage"
										id="voyage" ng-model="deliveryorder.voyage" name="voyage"
										validation="required" friendly-name="Voyage" 
										form-name="deliveryorderForm"></selectivity>
								</div>
							</div>
<div class="form-group">
								<label class="col-md-4 control-label"> Agent DO </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="agentdo"
										id="agentdo" ng-model="deliveryorder.agentdo"
										form-name="deliveryorderForm" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Clearance Port </label>
								<div class="col-md-5">
									<selectivity list="fpodList"
										property="deliveryorder.clearencePort" id="clearencePort"
										ng-model="deliveryorder.clearencePort" name="clearencePort"
										form-name="deliveryorderForm" disabled="true"></selectivity>
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label"> Consignee </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"
										name="consignee" id="consignee"
										ng-model="deliveryorder.consignee"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
										<selectivity list="consigneeList"
										property="deliveryorder.consignee" id="consignee" name="consignee"
										ng-model="deliveryorder.consignee" object="consignee"
										friendly-name="consignee" validation="required"
										form-name="deliveryorderForm" ng-disabled="true"  ></selectivity>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Total Weight(Kgs)
								</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="totWt"
										id="totWt" ng-model="deliveryorder.totWt"
										form-name="deliveryorderForm" ng-disabled="true" />
								</div>
							</div>
							
							


							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Weight </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="weigth"
										id="weigth" ng-model="deliveryorder.weigth"
										form-name="deliveryorderForm" ng-disabled="true" />
								</div>
							</div> -->
							
							<div class="form-group">
								<label class="col-md-4 control-label"> DO To </label>
								<div class="col-md-5">
									<selectivity list="donamesList" property="deliveryorder.doto"
										id="doto" ng-model="deliveryorder.doto" name="doto"
										form-name="deliveryorderForm"></selectivity>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> TRN No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="trnNo"
										id="trnNo" ng-model="deliveryorder.trnNo"
										form-name="deliveryorderForm"  />
								</div>
							</div>
							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> MRN No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="mrnNumber"
										id="mrnNumberde" ng-model="deliveryorder.mrnNumber"
										form-name="deliveryorderForm" ng-disabled="true" />
								</div>
							</div> -->
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Rotation No </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="rotationNo"
										id="mrnNumberde" ng-model="deliveryorder.rotationNo"
										form-name="deliveryorderForm" />
								</div>
							</div>
							
							

							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Rotation Number </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="rotationNumber" id="rotationNumber"
										ng-model="deliveryorder.rotationNumber"
										form-name="deliveryorderForm" />
								</div>
							</div> -->
							<!-- <div class="form-group">
								<label class="col-md-4 control-label">Volume</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="volume"
										id="volume" ng-model="deliveryorder.volume"
										form-name="deliveryorderForm" />
								</div>
							</div> -->



						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							
							
							<div class="form-group" ng-if="deliveryorder.mode==4 && !isEdit">
								<label class="col-md-4 control-label"> Carrier <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<selectivity list="carrierList" ng-model="deliveryorder.carrier"
											friendly-name="carrier" 
											property="deliveryorder.carrier" id="carrier" name="carrier" validation="required"
											form-name="deliveryorderForm"></selectivity>
								</div>
							</div>
							<div class="form-group" ng-if="deliveryorder.mode==4 && isEdit" >
								<label class="col-md-4 control-label"> Carrier <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="carrier" id="carrier"
										ng-model="deliveryorder.carrier" disabled="true"
										form-name="deliveryorderForm" >
								</div>
							</div>
							<div class="form-group" ng-if="deliveryorder.mode!=4 && !isEdit">
								<label class="col-md-4 control-label"> Carrier</label>
								<div class="col-md-5">
									<selectivity list="carrierList" ng-model="deliveryorder.carrier"
											friendly-name="carrier" 
											property="deliveryorder.carrier" id="carrier" name="carrier" 
											form-name="deliveryorderForm"></selectivity>
								</div>
							</div>
							<div class="form-group" ng-if="deliveryorder.mode!=4 && isEdit">
								<label class="col-md-4 control-label"> Carrier</label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="carrier" id="carrier"
										ng-model="deliveryorder.carrier" disabled="true"
										form-name="deliveryorderForm" >
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-4 control-label">POD <span
									style="color: red">*</span></label>
								<div class="col-md-5">
										<selectivity list="portList"
										property="deliveryorder.pod" id="pod"
										name="pod" ng-model="deliveryorder.pod"
										object="pod" friendly-name="POD"
										validation="required" form-name="deliveryorderForm"
										></selectivity>
							</div>
							</div>
<div class="form-group">
								<label class="col-md-4 control-label"> Shipping Agent </label>
								<div class="col-md-5">
									<selectivity list="agentList"
										property="deliveryorder.shippingAgent" id="shippingAgent"
										ng-model="deliveryorder.shippingAgent" name="shippingAgent"
										form-name="deliveryorderForm" ></selectivity>
								</div>
							</div>
							

							<div class="form-group">
								<label class="col-md-4 control-label"> Discharge Port
									(FPOD)</label>
								<div class="col-md-5">
									<selectivity list="fpodList"
										property="deliveryorder.dischargePort" id="dischargePort"
										ng-model="deliveryorder.dischargePort" name="dischargePort"
										form-name="deliveryorderForm" disabled="true"></selectivity>
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label"> BL Type </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="blType" id="blType"
										ng-model="deliveryorder.blType"
										form-name="deliveryorderForm" disabled="true" />
								</div>
							</div>
								
								<div class="form-group">
								<label class="col-md-4 control-label"> Total No.of Containers </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm" name="totQty"
										id="totQty" ng-model="deliveryorder.totQty"
										form-name="deliveryorderForm" ng-disabled="true" />
								</div>
							</div>
							
								

							<!-- <div class="form-group">
								<label class="col-md-4 control-label"> Packages Type </label>
								<div class="col-md-5">
									<input type="text" class="form-control input-sm"
										name="packageType" id="packageType"
										ng-model="deliveryorder.packageType"
										form-name="deliveryorderForm" />
								</div>
							</div> -->
							


							<div class="form-group">
								<label class="col-md-4 control-label"> DO Address </label>
								<div class="col-md-5">
									<textarea type="text" class="form-control input-sm"
										name="doAddress" form-name="deliveryorderForm"
										class="custom-scroll width_250 resize-none" rows="3"
										ng-model="deliveryorder.doAddress" ng-disabled ="addressDO">
									</textarea>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> Goods Description
								</label>
								<div class="col-md-5">
									<textarea type="text" class="form-control input-sm"
										name="goods" form-name="deliveryorderForm"
										class="custom-scroll width_250 resize-none" rows="3"
										ng-model="deliveryorder.goods" ng-disabled="true">
									</textarea>
								</div>
							</div>


						</fieldset>
					</div>
					
				</div>



				<div class="table-responsive clear">
				
				<div class="col-md-3">
									<h3 style="margin-left: 5px;">Container Detail</h3>
									</div>
									<div class="col-md-4">
									<div class="form-group">
									<label class="col-md-5 control-label">DO Valid Date	</label>
									<div class="col-md-7">
									<div class="input-group  input-append date">
									<!-- <input type="text" class="form-control input-sm"
												id="validDate" name="validDate" 
											ng-model="deliveryorder.validDate"   
												friendly-name="validDate" /> <span
												class="input-group-addon add-on"><span
												form-name="deliveryorderForm" class="glyphicon glyphicon-calendar"></span></span> -->
												
												<ng-bs3-datepicker data-ng-model="deliveryorder.validDate"
										id="validDate" name="validDate"
										form-name="deliveryorderForm" />
								
										</div>
										</div>
									</div>
								</div>
								<button class="btn btn-info ng-scope"  type="button" 
								ng-click="apply(deliveryorder.validDate)">
								<i class="fa fa-exchange"></i> Apply
							</button>
							
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_10 text-center">Containers</th>
								<th colspan=1 class="width_10 text-center">Type</th>
								<th colspan=1 class="width_5 text-center">SOC</th>
								<th colspan=1 class="width_10 text-center">Seal No.</th>
								<th colspan=1 class="width_10 text-center">TW</th>
								<th colspan=1 class="width_10 text-center">GW</th>
								<th colspan=1 class="width_10 text-center">Net</th>
								<th colspan=1 class="width_10 text-center">LD Free Days</th>
								<th colspan=1 class="width_10 text-center">DO Valid Date</th>

							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in deliveryorder.deliverDtl">
							<tr>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<selectivity ng-if=deliveryorder.mode!="5"  list="containerList" property="row.container"
												id="container_id" data-ng-model="row.container" disabled="isEdit"
												name="container{{trIndex}}" form-name="deliveryorderForm"></selectivity>
												<input ng-if=deliveryorder.mode=="5" type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.container"
												name="type{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(container)'}}"
												ng-disabled="true" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.type"
												name="type{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(type)'}}"
												ng-disabled="true" />
										</div>
									</div>
								</td>
								<td class="width_5">
								<div class="row" style=" padding-left: 36px;">
										<div class="col-xs-12">
														<label class="i-checks"><input type="checkbox"
													name="soc" id="soc" ng-model="row.soc" disabled="true"><i></i></label>
												</div></div></td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.sealNo"
												name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}"
												ng-disabled="true" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.tw" name="tw{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(tw)'}}"
												ng-disabled="true" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.gw" name="gw{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(gw)'}}"
												ng-disabled="true" />
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.net" name="net{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(net)'}}"
												ng-disabled="true" />
										</div>
									</div>
								</td>
								
								<td class="width_10"><div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.freedays" name="net{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(net)'}}"
												ng-disabled="true" />
										</div>
									</div></td>
								
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											
												 
												 <ng-bs3-datepicker data-ng-model="row.doValiddate" friendly-name="{{ 'Row' + $index + '(doValiddate)'}}"
										 name="doValiddate{{trIndex}}"
										form-name="deliveryorderForm" />
										</div>
									</div>
								</td>







							</tr>
						</tbody>
					

					</table>

					<br> <br> <br>


				</div>


				<div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit" ng-disabled="checkSaveButtonDisable"
								class="btn btn-success"
								ng-click="save(deliveryorderForm,deliveryorder)">
								<i class="fa fa-save"></i> Save
							</button>
							<button class="btn btn-success" type="button" ng-if="isEdit"
								class="btn btn-success"
								ng-click="update(deliveryorderForm,deliveryorder)">
								<i class="fa fa-save"></i> Update
							</button>
							<button class="btn btn-success" type="button" ng-if="isEdit"
								class="btn btn-success"
								ng-click="print(deliveryorderForm,deliveryorder)">
								<i class="fa fa-print"></i> Print
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
