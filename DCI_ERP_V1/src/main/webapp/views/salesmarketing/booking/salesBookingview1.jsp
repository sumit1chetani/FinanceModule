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
		<!-- 		<div -->
		<!-- 			style="width: 30%; position: absolute; margin-top: -40px; margin-left: 80%;"> -->
		<!-- 			<label style="color: #e25d5d; float: left;">Quick Links -->
		<!-- 				&nbsp;&nbsp; </label> -->
		<!-- 			<!--  <select ng-change="quickLinkMethd(joborder.jobId,qukLinkVal)" ng-init="qukLinkVal='Select'" ng-model="qukLinkVal"> -->
		<!-- 		 <option value="Select">Select</option> -->
		<!-- 		  <option value="HBL">HBL</option> -->
		<!-- 		  <option value="MBL">MBL</option> -->
		<!-- 		  <option value="Delivery Order">Delivery Order</option> -->
		<!-- 		  <option value="Sales Invoice">Sales Invoice</option> -->
		<!-- 		  <option value="Purchase Invoice">Purchase Invoice</option> -->
		<!-- 		</select> -->
		<!-- 			<selectivity style="float: left;" list="qlList" -->
		<!-- 				ng-init="qlList='Select'" ng-model="qukLinkVal" -->
		<!-- 				property="qukLinkVal" name="qukLinkVal" friendly-name="qukLinkVal"></selectivity> -->
		<!-- 		</div> -->
		<input type="hidden" value="${form_code}" id="form_code_id">
		<form name="bookingForm" class="form-horizontal" novalidate>
			<tabset justified="true" class="tab-container"> <tab
				heading="General">
			<div class="panel-body" >
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
									<label class="col-md-5 control-label">{{bookingData.bookingDate}}</label>
								
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Mode<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
									<label class="col-md-5 control-label">{{bookingData.modeName}}</label>
									
									</div>
								</div>
							</div><div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel<span
										style="color: red;">*</span></label>
									<div class="col-md-7">
									<label class="col-md-5 control-label">{{bookingData.vessel}}</label>
									
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
									<label class="col-md-5 control-label">{{bookingData.voyage}}</label>
									
									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL<span
										style="color: red;">*</span></label>
									
									<div class="col-md-7" >
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
												<label class="col-md-5 control-label">{{bookingData.pod}}</label>
									</div>
<!-- 									<div class="col-md-7" ng-if="bookViaQt"> -->
<!-- 										<label class="col-md-5 control-label">{{bookingData.pod}}</label> -->
<!-- 									</div> -->
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Final Destination<span
										style="color: red;"></span></label>
									<div class="col-md-7">
													<label class="col-md-5 control-label">{{bookingData.destination}}</label>
								
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
								
									<div class="col-md-7" >
										<label class="col-md-5 control-label">{{bookingData.customerName}}-{{bookingData.customerName}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation </label>
								
									<div class="col-md-7" >
										<label class="col-md-5 control-label">{{bookingData.quotation}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="control-label col-md-5">Quotation
										Validity Date </label>
									<div class="col-md-7">
									<label class="col-md-5 control-label">{{bookingData.quotationDate}}</label>
										

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
									<label class="col-md-5 control-label">{{bookingData.carriageBy}}</label>
										
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Shipper </label>
									<div class="col-md-7">
									<label class="col-md-5 control-label">{{bookingData.shipperName}}</label>
									
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Consignee </label>
									<div class="col-md-7">
									<label class="col-md-5 control-label">{{bookingData.consigneeName}}</label>
									
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
										<label class="col-md-5 control-label text-left" >{{bookingData.freeDays}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Freight Terms
									</label>
									<div class="col-md-7">
									<label class="col-md-5 control-label text-left" >{{frightTerms}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Other Charges </label>
									<div class="col-md-7" ng-if="!bookViaQt">
										<label class="col-md-5 control-label text-left" >{{otherCharge}}</label>
										
						
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
									<label class="col-md-5 control-label text-left" >{{bookingData.notifyName}}</label>
									
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Type </label>
									<div class="col-md-7">
									<label class="col-md-5 control-label text-left" >{{bookingType}}</label>
									
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks </label>
									<div class="col-md-7">
									<label class="col-md-5 control-label text-left" >{{bookingData.remarks}}</label>
							
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Cancel By </label>
									
									<div class="col-md-7" >
										<label class="col-md-5 control-label">{{bookingData.cancel_by}}</label>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Cancel Date   
									</label>
									<div class="col-md-7" >
												<label class="col-md-5 control-label">{{bookingData.cancel_dt}}</label>
									</div>
 
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Cancel Remarks  </label>
									<div class="col-md-7">
													<label class="col-md-5 control-label">{{bookingData.bookingcancelreason}}</label>
								
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>
						<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Payer  </label>
									<div class="col-md-7">
									<label class="col-md-5 control-label">{{bookingData.payer}}</label>
								
									</div>
								</div>
							</div>
						</fieldset>
					</div>
				</div>

				<div class="table-responsive clear">
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
								<!-- 
																		type="checkbox" ng-model="row1.select" id="section{{trIndex}}"><i></i></label></td> -->
<td style="text-align:center">{{row1.cntrType}}</td>	
<td style="text-align:center">{{row1.noOfBox}}</td>								
<td style="text-align:center">{{row1.commodityName}}</td>								
					
								

							

							</tr>
						</tbody>
					</table>
					<!-- 					<div class="padding-right-5" id="AddOrRmvebtn"> -->
					<!-- 						<button ng-click="addBxRow()" class="btn btn-sm btn-info" -->
					<!-- 							tooltip="Add Row" ng-disabled="" type="button"> -->
					<!-- 							<i class="fa fa-plus"></i> -->
					<!-- 						</button> -->
					<!-- 						<button ng-click="removeBxRow()" class="btn btn-sm btn-danger" -->
					<!-- 							type="button" tooltip="Delete"> -->
					<!-- 							<i class="fa  fa-trash-o"></i> -->
					<!-- 						</button> -->
					<!-- 					</div> -->
					<!-- /padding-right-5 - /AddOrRmvebtn -->
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
											id="rpod" name="rpod" form-name="bookingForm"  disabled="true"></selectivity>
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
												form-name="bookingForm"  disabled="true"></selectivity>
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
												form-name="bookingForm"  disabled="true"></selectivity>
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
												form-name="bookingForm"  disabled="true"></selectivity>
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
												form-name="bookingForm"  disabled="true"
												friendly-name="{{ 'Row' + $index + '(ETA)'}}" />
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
					<!-- 	<button class="btn btn-success" type="button" ng-if="!isEdit" ng-disabled="check"
							ng-click="saveBooking(bookingForm)">
							<i class="fa fa-save"></i> Save
						</button>
						<button class="btn btn-success" type="button" ng-if="isEdit"
							ng-click="saveBooking(bookingForm)">
							<i class="fa fa-save"></i> Update
						</button>
						<button class="btn btn-info" type="button" ng-click="reset()">
							<i class="fa fa-undo"></i> Reset
						</button> -->
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
