
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
							<div class="form-group">
								<label class="col-md-4 control-label"><b> DO Number </b></label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"
										name="doNumber" id="doNumber"
										ng-model="deliveryorder.doNumber"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
										<label class="control-label">{{deliveryorder.doNumber}}</label>
								</div>
								
							</div>
							
							<div class="form-group" >
								<label class="col-md-4 control-label"><b> BL No.</b></label>
								<div class="col-md-5">
									<label class="control-label">{{deliveryorder.blNo}}</label>
									
								</div>
							</div>
							<div class="form-group" >
								<label class="col-md-4 control-label"><b> Mode</b></label>
								<div class="col-md-5">
									<label class="control-label">{{deliveryorder.modeName}}</label>
									
								</div>
							</div>
							<div class="form-group" >
								<label class="col-md-4 control-label"><b>Carrier</b></label>
								<div class="col-md-5">
									<label class="control-label">{{deliveryorder.carrier}}</label>
									
								</div>
							</div>
							<div class="form-group" >
								<label class="col-md-4 control-label"><b>Pod</b></label>
								<div class="col-md-5">
									<label class="control-label">{{deliveryorder.podName}}</label>
									
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Shipping Agent </b></label>
								<div class="col-md-5">
									<!-- <selectivity list="agentList"
										property="deliveryorder.shippingAgent" id="shippingAgent"
										ng-model="deliveryorder.shippingAgent" name="shippingAgent"
										form-name="deliveryorderForm" ></selectivity> -->
										<label class="control-label">{{deliveryorder.shippingAgentName}}</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Arrival Date </b></label>
								<div class="col-md-5">
									<label class="control-label">{{deliveryorder.arrivalDate}}</label>	
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b>BL Status </b></label>
								<div class="col-md-5">
									
										<label class="control-label">{{deliveryorder.status}}</label>	
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Freight Term</b> </label>
								<div class="col-md-5">
								<label class="control-label">{{deliveryorder.freightName}}</label>	
									
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Remarks</b> </label>
								<div class="col-md-5">
									
										<label class="control-label">{{deliveryorder.remarks}}</label>	
								</div>
							</div>
							
							<div class="form-group" >
								<label class="col-md-4 control-label"> <b>DO Recipient</b> </label>
								<div class="col-md-5">
									
										<label class="control-label">{{deliveryorder.doRecipient}}</label>	
										
								</div>
								
								
							</div>
							
							
							

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
						<div class="form-group">
										<label class="col-md-4 control-label"><b>NOC</b></label>
										<div class="col-md-2" >
										<label class="control-label">{{deliveryorder.nocView}}</label>  
								</div>
								</div>
								
						
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Date </b></label>
								<div class="col-md-5">
									
									<label class="control-label">{{deliveryorder.currenctDate}}</label>	
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Vessel<b/></label>
								<div class="col-md-5">
								<label class="control-label">{{deliveryorder.vessel}}</label>	
									
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Clearance Port </b></label>
								<div class="col-md-5">
								
								<label class="control-label">{{deliveryorder.clearencePort}} - {{deliveryorder.dischargePortName}}</label>	
									
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Consignee </b></label>
								<div class="col-md-5">
								<label class="control-label">{{deliveryorder.consigneeName}}</label>	
									
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"> <b>Total Weight(Kgs)</b>
								</label>
								<div class="col-md-5">
								
								<label class="control-label">{{deliveryorder.totWt}}</label>	
									
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Weight </b></label>
								<div class="col-md-5">
								<label class="control-label">{{deliveryorder.weigth}}</label>	
									
								</div>
							</div>
							

							<div class="form-group">
								<label class="col-md-4 control-label"><b> DO To </b></label>
								<div class="col-md-5">
								
										<label class="control-label">{{deliveryorder.dotoName}}</label>	
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> TRN No </b></label>
								<div class="col-md-5">
								<label class="control-label">{{deliveryorder.trnNo}}</label>	
									
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b>MRN No</b></label>
								<div class="col-md-5">
								<label class="control-label">{{deliveryorder.mrnNumber}}</label>
									
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b>Rotation No</b></label>
								<div class="col-md-5">
								<label class="control-label">{{deliveryorder.rotationNo}}</label>
									
								</div>
							</div>
							
							


							
							

							



						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
						<div class="form-group" ng-if="noccheck" >
								<label class="col-md-4 control-label"><b> NOC </b></label>
								<div class="col-md-5">
									<label class="control-label">{{deliveryorder.noc}}</label>	
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Agent DO </b></label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm" name="agentdo"
										id="agentdo" ng-model="deliveryorder.agentdo"
										form-name="deliveryorderForm" /> -->
										
										<label class="control-label">{{deliveryorder.agentdo}}</label>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Voyage </b><span
									style="color: red;"></span></label>
								<div class="col-md-5">
									
										
										<label class="control-label">{{deliveryorder.voyage}}</label>	
								</div>
							</div>
							

							<div class="form-group">
								<label class="col-md-4 control-label"><b> Discharge Port
									(FPOD)</b></label>
								<div class="col-md-5">
									
									<label class="control-label">{{deliveryorder.dischargePort}} - {{deliveryorder.dischargePortName}}</label>	
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b> BL Type</b> </label>
								<div class="col-md-5">
								
								<label class="control-label">{{deliveryorder.blType}}</label>	
									
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Total Quantity </b></label>
								<div class="col-md-5">
									
									<label class="control-label">{{deliveryorder.totQty}}</label>	
								</div>
							</div>






							<!-- <div class="form-group">
								<label class="col-md-4 control-label"><b> Packages Type </b></label>
								<div class="col-md-5">
									
									<label class="control-label">{{deliveryorder.packageType}}</label>	
								</div>
							</div> -->
							


							<div class="form-group">
								<label class="col-md-4 control-label"><b> DO Address </b></label>
								<div class="col-md-5">
									
									
									<label class="control-label" style="text-align: left;">{{deliveryorder.doAddress}}</label>	
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-4 control-label"><b> Goods Description</b>
								</label>
								<div class="col-md-5">
									
									<label class="control-label" style="text-align: left;">{{deliveryorder.goods}}</label>
								</div>
							</div>
							
							
						</fieldset>
					</div>
					<!-- <div class="col-sm-12 col-md-12 col-lg-12">
						<div class="form-group">
							<label class="col-md-2 control-label">Customer Bill Type
							</label>
							<div class="col-md-7">
								<label class="i-checks checkbox-inline"> <input
									type="checkbox" name="doimport"
									ng-model="deliveryorder.doimport" ng-disabled="disabled">
									<i></i> Import
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="reexport"
									ng-model="deliveryorder.reexport" ng-disabled="disabled">
									<i></i> Re-Export
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="transit" ng-model="deliveryorder.transit"
									ng-disabled="disabled"> <i></i> Transit
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="tempadmission"
									ng-model="deliveryorder.tempadmission" ng-disabled="disabled">
									<i></i> Temp Admission
								</label><label class="i-checks checkbox-inline"> <input
									type="checkbox" name="fz" ng-model="deliveryorder.fz"
									ng-disabled="disabled"> <i></i> FZ B/E
								</label><label class="i-checks checkbox-inline"> <input
									type="checkbox" name="dfsa" ng-model="deliveryorder.dfsa"
									ng-disabled="disabled"> <i></i> DFSA B/E
								</label>
							</div>
						</div>
					</div> -->

					<!-- <div class="col-sm-12 col-md-12 col-lg-12">
						<div class="form-group">
							<label class="col-md-2 control-label">Payment Method </label>
							<div class="col-md-7">
								<label class="i-checks checkbox-inline"> <input
									type="checkbox" name="cdrcash" ng-model="deliveryorder.cdrcash"
									ng-disabled="disabled"> <i></i> CDR Cash
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="cdr" ng-model="deliveryorder.cdr"
									ng-disabled="disabled"> <i></i> CDR
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="deposit" ng-model="deliveryorder.deposit"
									ng-disabled="disabled"> <i></i> Deposit
								</label> <label class="i-checks checkbox-inline"> <input
									type="checkbox" name="credit" ng-model="deliveryorder.credit"
									ng-disabled="disabled"> <i></i> Credit
								</label><label class="i-checks checkbox-inline"> <input
									type="checkbox" name="stang" ng-model="deliveryorder.stang"
									ng-disabled="disabled"> <i></i> Stan.G.
								</label><label class="i-checks checkbox-inline"> <input
									type="checkbox" name="bankg" ng-model="deliveryorder.bankg"
									ng-disabled="disabled"> <i></i> Bank.G.
								</label><label class="i-checks checkbox-inline"> <input
									type="checkbox" name="fit" ng-model="deliveryorder.fit"
									ng-disabled="disabled"> <i></i> FIT
								</label><label class="i-checks checkbox-inline"> <input
									type="checkbox" name="other" ng-model="deliveryorder.other"
									ng-disabled="disabled"> <i></i> Other
								</label>
							</div>
						</div>
					</div> -->
				</div>



				<div class="table-responsive clear">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_10 ">Containers</th>
								<th colspan=1 class="width_10 ">Type</th>
								<th colspan=1 class="width_5 ">SOC</th>
								<th colspan=1 class="width_10 ">Seal No</th>
								<th colspan=1 class="width_10 ">TW</th>
								<th colspan=1 class="width_10 ">GW</th>
								<th colspan=1 class="width_10 ">Net</th>
								<th colspan=1 class="width_10 ">DO Free Days</th>
								<th colspan=1 class="width_10 ">DO Valid Date</th>

							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in deliveryorder.deliverDtl">
							<tr>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											 <!-- <selectivity list="containerList" property="row.container"
												id="container_id" data-ng-model="row.container" disabled="isEdit"
												name="container{{trIndex}}" form-name="deliveryorderForm"></selectivity>  -->
												 <label class="control-label">{{row.containerNumber}}</label> 
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.type"
												name="type{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(type)'}}"
												ng-disabled="true" /> -->
												
												<label class="control-label">{{row.type}}</label>
										</div>
									</div>
								</td>
								<td class="width_5">
								<div class="row">
										<div class="col-xs-12">
										<label class="control-label">{{row.soc}}</label>
										
														<!-- <label class="i-checks">
														
														<input type="checkbox"
													name="soc" id="soc" ng-model="row.soc" disabled="true"><i></i></label> -->
												</div></div></td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.sealNo"
												name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}"
												ng-disabled="true" /> -->
												
												<label class="control-label">{{row.sealNo}}</label>
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.tw" name="tw{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(tw)'}}"
												ng-disabled="true" /> -->
												
												<label class="control-label">{{row.tw}}</label>
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.gw" name="gw{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(gw)'}}"
												ng-disabled="true" /> -->
												
												<label class="control-label">{{row.gw}}</label>
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											<!-- <input type="text" class="form-control input-sm"
												maxlength=255 data-ng-model="row.net" name="net{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(net)'}}"
												ng-disabled="true" /> -->
												
												
												<label class="control-label">{{row.net}}</label>
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											
												
												<label class="control-label">{{row.freedays}}</label>
										</div>
									</div>
								</td>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
											
												<label class="control-label">{{row.doValiddate}}</label>
										</div>
									</div>
								</td>







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
