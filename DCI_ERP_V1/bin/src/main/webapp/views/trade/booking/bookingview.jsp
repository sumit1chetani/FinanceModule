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
			<div class="panel-body">
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

									<div class="col-md-7">
										<label class="col-md-5 control-label">{{bookingData.pol}}</label>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POD<span
										style="color: red;">*</span>
									</label>
									<div class="col-md-7">
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

									<div class="col-md-7">
										<label class="col-md-5 control-label">{{bookingData.customerName}}-{{bookingData.customerName}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation </label>

									<div class="col-md-7">
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
										<label class="col-md-5 control-label text-left">{{bookingData.freeDays}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Freight Terms </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label text-left">{{frightTerms}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> Other Charges </label>
									<div class="col-md-7" ng-if="!bookViaQt">
										<label class="col-md-5 control-label text-left">{{otherCharge}}</label>


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
										<label class="col-md-5 control-label text-left">{{bookingData.notifyName}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Type </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label text-left">{{bookingType}}</label>

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label text-left">{{bookingData.remarks}}</label>

									</div>
								</div>
							</div>
						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Cancel By
									</label>

									<div class="col-md-7">
										<label class="col-md-5 control-label">{{bookingData.cancel_by}}</label>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Cancel
										Date </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{bookingData.cancel_dt}}</label>
									</div>

								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking Cancel
										Remarks </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{bookingData.bookingcancelreason}}</label>

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
								<td style="text-align: center">{{row1.cntrType}}</td>
								<td style="text-align: center">{{row1.noOfBox}}</td>
								<td style="text-align: center">{{row1.commodityName}}</td>





							</tr>
						</tbody>
					</table>

				</div>


			</div>

			</tab> 
			<tab heading="Routing" ng-if="isEdit" ng-click="checkBookingT/S()">
			<div class="panel-body">
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">POL </label> <label
										class="col-md-5 control-label">{{bookingData.pol}}</label>

								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label"> POD </label>
									<div class="col-md-7">
										<selectivity list="rPodList" ng-model="bookingData.rPod"
											friendly-name="Routing Pod" property="bookingData.rPod"
											id="rpod" name="rpod" form-name="bookingForm" disabled="true"></selectivity>
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
												form-name="bookingForm" disabled="true"></selectivity>
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
												form-name="bookingForm" disabled="true"></selectivity>
										</div>
									</div>
								</td>

								<td>
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="row2.rVesselList" property="row2.vessel"
												id="vesselRt{{trIndex1}}" ng-model="row2.vessel"
												name="vesselRt{{trIndex1}}"
												friendly-name="{{ 'Row' + $index + '(Vessel)'}}"
												form-name="bookingForm" disabled="true"></selectivity>
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
												form-name="bookingForm" disabled="true"
												friendly-name="{{ 'Row' + $index + '(ETA)'}}" />
										</div>
									</div>
								</td>

							</tr>
						</tbody>
					</table>
					<!-- /padding-right-5 - /AddOrRmvebtn -->
				</div>
				<br> <br> <br>
			</div>
			</tab> 
			<tab heading="CRO" ng-if="isEdit" ng-click="checkBookingCRO()">
			
					<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>


							<div class="form-group ">
								<label class="col-md-5 control-label">Customer <span
									style="color: red">*</span></label>
								<div class="col-md-7" style="margin-top: 2%;">
									<!-- <selectivity list="customerDropList"
										property="quotation.customer" id="customer" name="customer"
										ng-model="quotation.customer" object="customer"
										friendly-name="Customer" validation="required"
										form-name="quotationForm"></selectivity> -->
												<span >{{quotation.customer}}</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">CRO Date<span
									style="color: red">*</span></label>
								<div class="col-md-7" style="margin-top: 2%;">
									<!-- <ng-bs3-datepicker
										data-ng-model="quotation.croDate" id="croDate" name="croDate"
										property="quotation.croDate"
										friendly-name="{{ 'Row' + ($index+1) + '(croDate)'}}" /> -->
											<span>{{quotation.croDate}}</span>
								</div>
							</div>







						</fieldset>
					</div>

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Booking No<span
									style="color: red">*</span></label>
								<div class="col-md-7" style="margin-top: 2%;">
									<!-- <selectivity list="bookingNoList"
										property="quotation.bookingNo" id="bookingNo" name="bookingNo"
										ng-model="quotation.bookingNo" object="bookingNo"
										friendly-name="bookingNo" validation="required"
										form-name="quotationForm"></selectivity> -->
											<span >{{quotation.bookingNo}}</span>
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Depot<span
									style="color: red">*</span></label>
								<div class="col-md-7" style="margin-top: 2%;">
								<!-- 	<selectivity list="depotList"
										property="quotation.depot" id="depot{{trIndex}}"
										ng-model="quotation.depot" validation="required"
										name="depot{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(depot)'}}"
										form-name="quotationForm"></selectivity> -->
										<span>{{quotation.depot}}</span>
								</div>
							</div>






							<!-- 		<div class="form-group ">
								<label class="col-md-5 control-label">Cont.Drop Off Mode<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<selectivity list="dropoffList"
										property="quotation.dropoff" id="dropoff"
										name="dropoff" ng-model="quotation.dropoff"
										object="dropoff" friendly-name="dropoff"
										validation="required" form-name="quotationForm"></selectivity>
										
								</div>
								</div> -->



						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<!-- third column -->

							


						</fieldset>
					</div>


				</div>

				<br>
				<div class="row">
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
						<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_9 text-center">Container Type<span
								style="color: red">*</span></th>
								<!-- <th colspan=1 class="width_9 text-center">Container Number<span
								style="color: red">*</span></th> -->
							<th colspan=1 class=" width_9 text-center">Quantity<span
								style="color: red">*</span></th>
							 <th colspan=1 class="width_9 text-center"></th>

						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr >
							<td class=" width_1"></td>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}">
										<i></i>
								</label></td>
								<td class=" width_9">
								<!-- <selectivity list="conTypeList"
										property="row.conType" id="conType{{trIndex}}"
										ng-model="row.conType" validation="required"
										name="conType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
										form-name="quotationForm"></selectivity> -->
										<span>{{row.conType}}</span>
										</td>
										
										<!-- <td class=" width_9"><selectivity list="containerNoList"
										property="row.conNumber" id="conNumber{{trIndex}}"
										ng-model="row.conNumber" validation="required"
										name="conType{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(conType)'}}"
										form-name="quotationForm"></selectivity></td> -->
										
										
								<td class=" width_9">
								<!-- <input type="text"
									class="form-control input-sm text-right" name="quantity"
									property="row.quantity" id="quantity{{trIndex}}"
									ng-model="row.quantity"
									friendly-name="{{ 'Row' + ($index+1) + '(quantity)'}}" /> -->
									<span>{{row.quantity}}</span>
									</td>
								<td class=" width_9"></td>
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>

					
				</div>

                 	<div class="row">
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
						<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_9 text-center">Seal No From</th>
							<th colspan=1 class=" width_9 text-center">Seal No To</th>
							<th colspan=1 class=" width_9 text-center">Count</th>
							 <th colspan=1 class="width_9 text-center"></th>
								
						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.sealDtl"
							ng-controller="quotationtableCtrl">
							<tr>
							<td class=" width_1"></td>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}">
										<i></i>
								</label></td>
								<td class=" width_9">
								<!-- <input type="text"
									class="form-control input-sm text-right" name="sealFrom"
									property="row.sealFrom" id="sealFrom{{trIndex}}"
									ng-model="row.sealFrom"
									friendly-name="{{ 'Row' + ($index+1) + '(sealFrom)'}}" /> -->
									<span>{{row.sealFrom}}</span>
									</td>
								<td class=" width_9"><!-- <input type="text"
									class="form-control input-sm text-right" name="sealTo"
									property="row.sealTo" id="quantity{{trIndex}}"
									ng-model="row.sealTo"
									friendly-name="{{ 'Row' + ($index+1) + '(sealTo)'}}" /> -->
											<span>{{row.sealTo}}</span>
									</td>
									<td class=" width_9">
									<!-- <input type="text"
									class="form-control input-sm text-right" name="count"
									property="row.count" id="count{{trIndex}}"
									ng-model="row.count"
									friendly-name="{{ 'Row' + ($index+1) + '(count)'}}" /> -->
									<span>{{row.count}}</span>
									
									</td>
								<td class=" width_9"></td>
								
										
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>

					
				</div>

				<!-- detail -->

				
			</form>
		</div>
			
			</tab>
			<tab heading="GATE In & Out " ng-if="isEdit" ng-click="checkBookingGate()">
			<tabset>
			<tab  heading="GATE Out " ng-if="isEdit" ng-click="checkBookingGateOut()">
					<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
						
						<div class="form-group" ng-if="!edit">
								<label class="col-md-5 control-label">Gate Out No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.gateOutNo1}}
								</label>
								
								</div>
							</div>
							
							
							<div class="form-group" ng-if="edit">
								<label class="col-md-5 control-label">Gate Out No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.gateOutNo}}
								</label>
								
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Type<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.type}}
								</label>
								
								</div>
							</div>

							<div class="form-group" ng-if="quotation.type=='Export'">
								<label class="col-md-5 control-label">C.R.O. No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.croNo}}
								</label>
							
								</div>
							</div>
							
								<div class="form-group" ng-if="quotation.type=='Import'">
								<label class="col-md-5 control-label">D.O. No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<label class="control-label" align="left" >{{quotation.doNo}}
								</label>
							
								</div>
							</div>
							

						</fieldset>
					</div>
						

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Customer<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.customername}}
								</label>
							
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Depot<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<label class="control-label" align="left" >{{quotation.depot}}
								</label>
								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Booking No<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.bookingNo}}								</label>
					
								</div>
							</div>
							



						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<!-- third column -->
							
								<div class="form-group " ng-if="quotation.type=='Export'">
								<label class="col-md-5 control-label">CRO Count<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.countTotal}}
								</label>
				
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Gate Out Date<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<div class="input-group  input-append date">
									<label class="control-label" align="left" >{{quotation.releaseDate}}
								</label>
									
										</div>
								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Truck No<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.truckNo}}
								</label>
							
								</div>
							</div>

							


						</fieldset>
					</div>


				</div>
					<br>
			

				<br>
				<div class="row">
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
						<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_9 text-center">Container Type<span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_9 text-center">Container No<span
								style="color: red">*</span></th>
								<!-- <th colspan=1 class=" width_9 text-center">Seal No</th> -->
							 <th colspan=1 class="width_9 text-center"></th>

						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr >
							<td class=" width_1"></td>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}" disabled="true">
										<i></i>
								</label></td>
							  <td style="text-align:center">{{row.conType}}</td>
								
				 <!--  <td style="text-align:center">{{row.containerNo}}</td> -->
				  
				  
						 	<td class=" width_9"><!-- <selectivity list="conNoList"
										property="row.containerNo" id="containerNo{{trIndex}}"
										ng-model="row.containerNo" validation="required"
										name="containerNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
										form-name="quotationForm" disabled="true"></selectivity> -->
												<label class="control-label" align="left" >{{row.containerNo}}
							
										</td>  
										
											<!-- <td class=" width_9">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
											     property="row.sealNo" id="sealNo{{trIndex}}"
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}"  form-name="quotationForm"/>
										</div>
									</div>
								</td> -->
									
									
								<td class=" width_9"></td>
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>

				<!-- 	<button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button> -->
				<!-- 	<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button> -->
				</div>

                 	

				<!-- detail -->

				
			</form>
		</div>
			
			
			
			</tab>
				
				<tab  heading="GATE In " ng-if="isEdit" ng-click="checkBookingGateIn()">
						<div class="panel-body">
			<form name="gateInForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							
								<div class="form-group" hidden=true>
									<label class="col-md-5 control-label">Service</label>

									<div class="col-md-7">
										<div class="radio radio-inline" >
											<label class="i-checks"> <input type="radio"
												class="radiobox style-0"   name="service"
												ng_model="gateIn.service" value="COC"
												checked="checked"> <i></i> COC
											</label>
										</div>
										<div class="radio  radio-inline">
											<label class="i-checks"> <input type="radio"
												class="radiobox style-0" ng_model="gateIn.service"
												value="SOC"   name="service"> <i></i>
											SOC
											</label>
										</div>
				
									</div>
								</div>
						
						
						<div class="form-group "  ng-if="gateIn.service=='COC'">
                 <label class="col-md-5 control-label">Type<span
                 style="color: red">*</span></label>
                  <div class="col-md-7">
                    <!--  <selectivity list="typeList"
                           property="gateIn.type" id="type" name="type"
                        ng-model="gateIn.type" object="type"
                     friendly-name="type" validation="required"
                    form-name="gateInForm" value="true"></selectivity> -->
                   <label class="control-label" align="left" >{{gateIn.type}}</label>
                    
                   </div>
             </div>


						
							<div class="form-group" ng-if="!isEdit">
								<label class="col-md-5 control-label">Gate IN No<span
									style="color: red">*</span></label>
						 	<div class="col-md-7">
									<!--	<input type="text"
									class="form-control input-sm text-left" name="gateInNoMaxCnt"
									property="gateIn.gateInNoMaxCnt" id="gateInNoMaxCnt"
									ng-model="gateIn.gateInNoMaxCnt"
									friendly-name="gateInNoMaxCnt" disabled="true" /> -->
									   <label class="control-label" align="left" >{{gateIn.gateInNoMaxCnt}}</label>
								</div>
							</div>
							
							<div class="form-group" ng-if="isEdit">
								<label class="col-md-5 control-label">Gate IN No<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
								<!-- 	<input type="text"
									class="form-control input-sm text-left" name="gateInNo"
									property="gateIn.gateInNo" id="gateInNo"
									ng-model="gateIn.gateInNo"
									friendly-name="gateInNo" disabled="true" /> -->
							  <label class="control-label" align="left" >{{gateIn.gateInNo}}</label>		
									
								</div>
								
								
							</div>
						
				       		<div class="form-group"  ng-if="gateIn.service=='SOC'">
								<label class="col-md-5 control-label" >Booking No<span
									style="color: red;">*</span>
								</label>
		                     <div class="col-md-7">
									<!-- <selectivity list="bookingNoList"
										property="gateIn.bookingNo" id="bookingNo"
										ng-model="gateIn.bookingNo" name="bookingNo"
										validation="required" friendly-name="bookingNo"
										form-name="gateInForm" ></selectivity>   -->
								  <label class="control-label" align="left" >{{gateIn.bookingNo}}</label>		
										
										
	                                 </div>
                            </div>
							
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
								<div class="form-group"  ng-if="gateIn.type=='Export' && gateIn.service=='COC'">
								<label class="col-md-5 control-label" >Gate Out No<span
									style="color: red;">*</span>
								</label>
		                     <div class="col-md-7">
							<!-- 		<selectivity list="gateOutList"
										property="gateIn.gateOutNo" id="gateOutNo"
										ng-model="gateIn.gateOutNo" name="gateOutNo"
										validation="required" friendly-name="gateOutNo"
										form-name="gateInForm" disabled="isEdit" ></selectivity>   -->
									 <label class="control-label" align="left" >{{gateIn.gateOutNo}}</label>
	                                 </div>
                            </div>
           
           			<div class="form-group"  ng-if="gateIn.type=='Import'  && gateIn.service=='COC'">
								<label class="col-md-5 control-label" >DO No<span
									style="color: red;">*</span>
								</label>
		                   <div class="col-md-7">
								<!-- 	<selectivity list="doNoList"
										property="gateIn.doNo" id="doNo"
										ng-model="gateIn.doNo" name="doNo"
										validation="required" friendly-name="doNo"
										form-name="gateInForm" disabled="isEdit" >
									</selectivity>   -->
									 <label class="control-label" align="left" >{{gateIn.doNo}}</label>
	                            
	                                      </div>
                                 </div>
              
              
              
								<div class="form-group"  ng-if="gateIn.service=='SOC'">
								<label class="col-md-5 control-label"> Depot<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<!-- <selectivity list="depotListSOC"
										property="gateIn.depot" id="depot"
										ng-model="gateIn.depot" name="depot"
										validation="required" friendly-name="depot"
										form-name="gateInForm"></selectivity> -->
										 <label class="control-label" align="left" >{{gateIn.depot}}</label>
	                            
								</div>
							</div>
							
								<div class="form-group"  ng-if="gateIn.service=='COC'">
								<label class="col-md-5 control-label"> Depot<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<!-- <selectivity list="depotList"
										property="gateIn.depot" id="depot"
										ng-model="gateIn.depot" name="depot"
										validation="required" friendly-name="depot"
										form-name="gateInForm" disabled="true"></selectivity> -->
							 <label class="control-label" align="left" >{{gateIn.depot}}</label>
	                            
								</div>
							</div>
							   
										
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						 <fieldset>
						 <div class="form-group">
								<label class="col-md-5 control-label">Gate IN Date<span
									style="color: red;">*</span></label>
								<div class="col-md-7">
								<div class="input-group  input-append date">
									<!-- <input type="text" class="form-control input-sm"
												id="returnDate" name="returnDate" 
											ng-model="gateIn.returnDate" validation="required"  
												friendly-name="returnDate" /> <span
												class="input-group-addon add-on"><span
												form-name="gateInForm" class="glyphicon glyphicon-calendar"></span></span> -->
											 <label class="control-label" align="left" >{{gateIn.returnDate}}</label>
	                        	
												</div>
							<!-- 	<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="gateIn.returnDate" id="returnDate"
										name="returnDate"  ng-model="gateIn.returnDate"  friendly-name="returnDate"
										form-name="gateInForm"  />
										</div> -->
								</div>
							</div>	
							  <div class="form-group" ng-if="!isEdit">
								<label class="col-md-5 control-label">Customer<span
									style="color: red;">*</span>
								</label>
	                               	<div class="col-md-7">
							<!-- 		<selectivity list="customerList"
										property="gateIn.customer" id="customer"
										ng-model="gateIn.customer" name="customer"
										validation="required" friendly-name="customer"
										form-name="gateInForm" disabled="true"></selectivity> -->
									 <label class="control-label" align="left" >{{gateIn.customer}}</label>
	                        			
                                 	</div>
                             </div>
                               <div class="form-group" ng-if="isEdit">
								<label class="col-md-5 control-label">Customer<span
									style="color: red;">*</span>
								</label>
	                               	<div class="col-md-7">
									<!-- <selectivity list="customerList1"
										property="gateIn.customer" id="customer"
										ng-model="gateIn.customer" name="customer"
										validation="required" friendly-name="customer"
										form-name="gateInForm" disabled="true"></selectivity> -->
									 <label class="control-label" align="left" >{{gateIn.customer}}</label>
	                        			
                                 	</div>
                             </div>
							</fieldset>
					</div>
				</div>
				
				
				<div class="table-responsive clear" ng-if="gateIn.service=='COC'">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<!-- <th colspan=1 class="width_1" ng-if="!isEdit">Select</th> -->
								 <th colspan=1 class="width_15 text-center" ng-if="!isEdit">Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_15 text-center">Container Type<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_20 text-center">Container No<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Seal No<span
									style="color: red;"></span></th>
						     <th colspan=1 class="width_15 text-center">Load<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(trIndex,row) in gateIn.containerDtl">
							<!-- 	<td ng-if="!isEdit"><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								-->
									 
									<td class="width_15" align = "center" ng-if="!isEdit">
									<div class="row">
						  	<input type="checkbox" data-ng-model="row.select" id="section" name="section{{trIndex}}" 
						  	friendly-name="{{ 'Row' + $index + '(select)'}}" >
									</div>
								</td>
								<td> 
									<div class="row">
										<div class="col-xs-12">

									<!-- 		<selectivity list="containerTypeList"
												property="row.containerType" id="containerType{{trIndex}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="gateInForm" ></selectivity> -->
 <label class="control-label" align="left" >{{row.containerType}}</label>
	                        		
										</div>
									</div>
								</td>

		                        <td>
									<div class="row">
										<div class="col-xs-12">

									<!-- 		<selectivity list="containerNoList"
												property="row.containerNo" id="containerNo{{trIndex}}"
												data-ng-model="row.containerNo"
												name="containerNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerNo)'}}"
												form-name="gateInForm" ></selectivity> -->
 				<label class="control-label" align="left" >{{row.containerNo}}</label>
										</div>
									</div>
								</td>
							<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
									<!-- 		<input type="text" class="form-control input-sm" maxlength=15
											     property="row.sealNo" id="sealNo{{trIndex}}"
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}" /> -->
									 <label class="control-label" align="left" >{{row.sealNo}}</label>	
										</div>
									</div>
								</td>
									<td class="width_15" align = "center">
									<div class="row">
						      	<input type="checkbox" data-ng-model="row.emptyOrLoad" id="emptyOrLoad" name="emptyOrLoad{{trIndex}}" 
						     	friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}" >	
									</div>
								</td>
				
				
							</tr>
						</tbody>
					
					</table>
				<!-- 	<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
				
						<button ng-click="removeRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div> -->
					<br> <br> <br>
				</div>
				
				<div class="table-responsive clear" ng-if="gateIn.service=='SOC'">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_15 text-center">Container Type<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_20 text-center">Container No<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Seal No<span
									style="color: red;"></span></th>
						     <th colspan=1 class="width_15 text-center">Load<span
									style="color: red;"></span></th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(trIndex,row) in gateIn.containerDtlsoc">
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td>
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="containerTypeList"
												property="row.containerType" id="containerType{{trIndex}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="gateInForm"></selectivity>

										</div>
									</div>
								</td>

		                        <td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
												data-ng-model="row.containerNo" name="containerNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerNo)'}}" />

										<!-- 	<input type="text"
									   class="form-control input-sm text-left" name="containerNo"
									   property="gateIn.containerNo" id="containerNo"
									    ng-model="gateIn.containerNo"
									    friendly-name="containerNo" /> -->

										</div>
									</div>
								</td>
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}" />
										</div>
									</div>
								</td>
								
									<td class="width_15" align = "center">
									<div class="row">
									<!-- 	
									
											<input type="checkbox" class="form-control input-sm" 
												data-ng-model="row.emptyOrLoad" name="emptyOrLoad{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}" /></label> -->
												
						  	<input type="checkbox" data-ng-model="row.emptyOrLoad" id="emptyOrLoad" name="emptyOrLoad{{trIndex}}" 
						  	friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}" >
										
									
									</div>
								</td>
				
							</tr>
						</tbody>
					
					</table>
					
					<br> <br> <br>
				</div>
				
				
			</form>
		</div>
				
				</tab>
			</tabset>
			</tab>
				<tab heading="Shipping Instruction" ng-if="isEdit" ng-click="checkBookingShippingInstruction()">
							<div class="row">

												
					
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4" ng-if="isEdit">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking No.</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.bookingNo}}</label>
									</div>

								</div>
							</div>

						</fieldset>
					</div>
					
						
					<div class="col-sm-12">
						<fieldset>
						
						<div class="col-md-4">
						<div class="form-group">
									<label class="col-md-5 control-label">Vsl.Voyage </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.vslVoyage}}</label>
									</div>
</div>
								</div>
								<div class="col-md-4">
						<div class="form-group">
									<label class="col-md-5 control-label">Customer </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.client}}</label>
									</div>
</div>
								</div>
								<div class="col-md-4">
							<div class="form-group">
									<label class="col-md-5 control-label">REF </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.ref}}</label>
									</div>
</div>
								</div>
						
						</fieldset>
						</div>
					
				<div class="col-md-12">
									<fieldset>
									
								<div class="col-md-4">	
<div class="form-group">
									<label class="col-md-5 control-label">P.O.L </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.pol}}</label>
									</div>
</div>
								</div>
								<div class="col-md-4">
<div class="form-group">
									<label class="col-md-5 control-label">P.O.D </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.pod}}</label>
									</div>

								</div>
								</div>
								<div class="col-md-4">
						<div class="form-group">
									<label class="col-md-5 control-label">F.P.O.D </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.fpod}}</label>
									</div>

								</div>
						</div>
									</fieldset>
			</div>
					<div class="col-md-12">
					<fieldset>
					
					<div class="col-md-4">
						<!-- 	<label class="control-label">Display Vessel <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="disvessel"
								friendly-name="disvessel" ng-model="blNoData.disvessel" name="disvessel"
								form-name="blForm"> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Display Vessel  </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disvessel}}</label>
									</div>

								</div>
						</div>
						<div class="col-md-4">
						
								<div class="form-group">
									<label class="col-md-5 control-label">Display Voyage </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disvoyage}}</label>
									</div>

								</div>
						</div>
						<div class="col-md-4">
					
								<div class="form-group">
									<label class="col-md-5 control-label">Display P.O.R </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disPor}}</label>
									</div>

								</div>
						</div>
					
					</fieldset>
					</div>
					
						<div class="col-md-12">
						<fieldset>
						<div class="col-md-4">
							<!-- <label class="control-label">Display P.O.L <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPol"
								friendly-name="disPol" ng-model="blNoData.disPol" name="disPol"
								form-name="blForm"> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Display P.O.L </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disPol}}</label>
									</div>

								</div>
						</div>
						<div class="col-md-4">
						<!-- 	<label class="control-label">Display P.O.D <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPod"
								friendly-name="disPod" ng-model="blNoData.disPod" name="disPod"
								form-name="blForm"> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Display P.O.D </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disPod}}</label>
									</div>

								</div>
						</div>
						<div class="col-md-4">
							<!-- <label class="control-label">Display F.P.O.D <span
								style="color: red;"></span></label> <input class="form-control"
								type="text" placeholder="" class="form-control" id="disFpod"
								friendly-name="disFpod" ng-model="blNoData.disFpod" name="disFpod"
								form-name="blForm"> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Display F.P.O.D </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disFpod}}</label>
									</div>

								</div>
						</div>
						
					</fieldset>
					</div>
					<div class="col-md-12">
						<fieldset>
						<div class="col-md-4" >
							<!-- <label class="control-label">Delivery Agent <span
								style="color: red;">*</span></label>
							<selectivity list="vendorList" property="blNoData.deliveryAgent"
								id="deliveryAgent" ng-model="blNoData.deliveryAgent" name="deliveryAgent"
								friendly-name="deliveryAgent" form-name="blForm" validation="required"></selectivity> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Delivery Agent </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.deliveryAgent}}</label>
									</div>

								</div>
								
						</div>
						<div class="col-md-4">
							<!-- <label class="control-label">Remarks</label>
							<textarea class="form-control" type="text" name="remarks"
								id="remarks" ng-model="blNoData.remarks" placeholder="Remarks">	 </textarea> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Remarks </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.remarks}}</label>
									</div>

								</div>
						</div>
						
						<div class="col-md-4"  ng-hide ="true";>
							<!-- <label class="control-label">Detention Tariff Type</label>
							<selectivity list="tariffList" property="blNoData.detentionTariffType"
								id="detentionTariffType" ng-model="blNoData.detentionTariffType" name="detentionTariffType"
								friendly-name="detentionTariffType" form-name="blForm"  disabled = "true"> -->
								<div class="form-group">
									<label class="col-md-5 control-label">Detention Tariff Type </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.detentionTariffType}}</label>
									</div>

								</div>
						</div>
							
						
						</fieldset>
						</div>
						<div  class="col-md-12">
						<fieldset>
						<div class="col-md-4">
						<!-- 	<label class="control-label">P.O.D.1 <span
								style="color: red;"></span></label>
							<selectivity list="portlist" property="blNoData.pod1" id="pod1"
								ng-model="blNoData.pod1" name="pod1" form-name="blForm"
								friendly-name="POD1" disabled="true"></selectivity> -->
								<div class="form-group">
									<label class="col-md-5 control-label">P.O.D.1 </label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.pod1}}</label>
									</div>

								</div>
						</div>
						</fieldset>
						</div>
			
				<br> <br>
				<div class="col-md-12"
					style="border: 1px solid rgba(0, 0, 0, 0.22); margin-top: 2%;">
					<br>
					<tabset justified="true" class="tab-container"> <tab
						heading="Names " style="background:#5F9EA0;  ">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<fieldset>
									<!-- <div class="col-md-12">
										<label class="control-label">Messers</label> <input
											class="form-control" type="text" name="messers" id="messers"
											ng-model="blNoData.messers" placeholder="Messers">

									</div> -->

									<!-- <div class="col-md-6">
										<label class="control-label">Shippers<span
							style="color: red;">*</span></label>

										<selectivity list="customerList" property="blNoData.shipperId"
											id="shipperId" ng-model="blNoData.shipperId" name="shipperId"
											form-name="blForm" validation ="required" friendly-name="Shippers"></selectivity>
											
											<div class="form-group">
									<label class="col-md-5 control-label">Shippers</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.shipperId}}</label>
									</div>

								</div>
											
											
									</div> -->

<div class="col-md-6">
												<label class="control-label" ><b>Shippers</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.shipperId}}</span>
												<!-- <selectivity list="customerList"
													property="blNoData.shipperId" id="shipperId"
													ng-model="blNoData.shipperId" name="shipperId"
													form-name="blForm" validation="required"
													friendly-name="Shippers"></selectivity> -->
											</div>
											
									<!-- <div class="col-md-6">
										<label class="control-label">Cnee<span
							style="color: red;">*</span></label>
										<selectivity list="customerList" property="blNoData.cneeId"
											id="cneeId" ng-model="blNoData.cneeId" name="cneeId"
											form-name="blForm" validation="required" friendly-name="Cnee"></selectivity>
											<div class="form-group">
									<label class="col-md-5 control-label">Cnee</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.cneeId}}</label>
									</div>

								</div>

									</div> -->
<div class="col-md-6">
												<label class="control-label" ><b>Cnee</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.cneeId}}</span>
												<!-- <selectivity list="customerList"
													property="blNoData.shipperId" id="shipperId"
													ng-model="blNoData.shipperId" name="shipperId"
													form-name="blForm" validation="required"
													friendly-name="Shippers"></selectivity> -->
											</div>



									<!-- <div class="col-md-6">
										<label class="control-label">Shippers Dtls</label>
										<textarea class="form-control" type="text" name="shipper"
											id="shipper" ng-model="blNoData.shipper"
											placeholder="Shippers">
											<div class="form-group">
									<label class="col-md-5 control-label">Shippers Dtls</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.shipper}}</label>
									</div>

								</div>
                            

									</div> -->

<div class="col-md-6">
												<label class="control-label" ><b>Shippers Dtls</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.shipper}}</span>
											</div>

<!-- 
									<div class="col-md-6">
										<label class="control-label">Cnee Dtls</label>
										<textarea class="form-control" type="text" name="cnee"
											id="cnee" ng-model="blNoData.cnee" placeholder="Cnee">
											<div class="form-group">
									<label class="col-md-5 control-label">Cnee Dtls</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.cnee}}</label>
									</div>

								</div>

									</div> -->

<div class="col-md-6">
												<label class="control-label" ><b>Cnee Dtls</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.cnee}}</span>
											</div>
											
											
									<!-- <div class="col-md-6">
										<label class="control-label">Notify1</label>
										<selectivity list="customerList" property="blNoData.notify1Id"
											id="notify1Id" ng-model="blNoData.notify1Id" name="notify1Id"
											form-name="blForm"></selectivity>
<div class="form-group">
									<label class="col-md-5 control-label">Notify1</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.notify1Id}}</label>
									</div>

								</div>
									</div> -->
									
									<div class="col-md-6">
												<label class="control-label" ><b>Notify1</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.notify1Id}}</span>
											</div>
									
									
									<!-- <div class="col-md-6">
										<label class="control-label">Notify2</label>
										<selectivity list="customerList" property="blNoData.notify2Id"
											id="notify2Id" ng-model="blNoData.notify2Id" name="notify2Id"
											form-name="blForm"></selectivity>
											<div class="form-group">
									<label class="col-md-5 control-label">Notify2</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.notify2Id}}</label>
									</div>
											
									</div>
</div> -->

<div class="col-md-6">
												<label class="control-label" ><b>Notify2</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.notify2Id}}</span>
											</div>
									

									<!-- <div class="col-md-6">
										<label class="control-label">Notify1 Dtls</label>
										<textarea class="form-control" type="text" name="notify1"
											id="notify1" ng-model="blNoData.notify1"
											placeholder="Notify1">
											<div class="form-group">
									<label class="col-md-5 control-label">Notify1 Dtls</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.notify1}}</label>
									</div>
											
									</div>
                            </textarea>

									</div> -->
									<div class="col-md-6">
												<label class="control-label" ><b>Notify1 Dtls</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.notify1}}</span>
											</div>
									
									<!-- <div class="col-md-6">
										<label class="control-label">Notify2 Dtls</label>
										<textarea class="form-control" type="text" name="notify2"
											id="notify2" ng-model="blNoData.notify2"
											placeholder="Notify2">
											<div class="form-group">
									<label class="col-md-5 control-label">Notify2 Dtls</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.notify2}}</label>
									</div>
											
									</div>
                        

									</div> -->
<div class="col-md-6">
												<label class="control-label" ><b>Notify2 Dtls</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.notify2}}</span>
											</div>
											
									<!-- <div class="col-md-6">
										<label class="control-label">Forwarder</label>
										<selectivity list="customerList"
											property="blNoData.forwarderId" id="forwarderId"
											ng-model="blNoData.forwarderId" name="forwarderId"
											form-name="blForm"></selectivity>
											<div class="form-group">
									<label class="col-md-5 control-label">Forwarder</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.forwarderId}}</label>
									</div>
											
									</div>

									</div> -->
<div class="col-md-6">
												<label class="control-label" ><b>Forwarder</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.forwarderId}}</span>
											</div>






									<!-- <div class="col-md-6">
										<label class="control-label">Forwarder Dtls</label>
										<textarea class="form-control" type="text" name="forwarder"
											id="forwarder" ng-model="blNoData.forwarder"
											placeholder="Forwarder">
											<div class="form-group">
									<label class="col-md-5 control-label">Forwarder Dtls</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.forwarder}}</label>
									</div>
											
									</div>
                           


									</div> -->
									<div class="col-md-6">
												<label class="control-label" ><b>Forwarder Dtls</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.forwarder}}</span>
											</div>
								</fieldset>
							</div>

						</div>
						<br>

						<!--  </div>
	</div>
	</div> -->
					</div>
					</tab> <!--  --> <tab heading="Containers" style="background:#5F9EA0">
					<div class="col-md-12">
						<div class="table-responsive ">
							<div class="panel-body" style="width: 166%;">

								<div class="row" id="items">


									<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												<th colspan=1 class="width_2">Select</th>
												<th colspan=1 class="width_9 text-center">Cntr No <span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_5 text-center">Type<span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_3 text-center">SOC<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">Seal No <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">NW (KG)<span
													style="color: red;"></span></th>
												<th colspan=1 class="width_7 text-center">GW (KG)<span
													style="color: red;">*</span></th>
												<th colspan=1 class="width_6 text-center">CBM <span
													style="color: red;"></span></th>
											
												<th colspan=1 class="width_7 text-center">Package <span
													style="color: red;"></span></th>
												<th colspan=1 class="width_6 text-center">No of
													Packages <span style="color: red;">*</span>
												</th>
												<th colspan=1 class="width_12 text-center">Commodity</th>
												<th colspan=1 class="width_4 text-center">is OOG</th>
												<th colspan=1 class="width_5 text-center">Hazardous</th>
												<th colspan=1 class="width_5 text-center">OWS</th>
												<th colspan=1 class="width_7 text-center">Marks</th>
												<th colspan=1 class="width_8 text-center">UN Code</th>
												<th colspan=1 class="width_8 text-center">IMCO Class</th>
												
												

											</tr>
										</thead>
										<tbody
											ng-repeat="(trIndex, blcntrDtl) in blNoData.blcntrDtlList track by trIndex"
										>
											<tr>
												<td><label class="i-checks m-b-none"> <input
														type="checkbox" ng-model="blcntrDtl.select"><i></i></label></td>
												
												<td class="text-center"><!-- <selectivity
														list="containerList" property="blcntrDtl.cntrNo"
														id="cntrNo" ng-model="blcntrDtl.cntrNo" name="cntrNo"
														form-name="blForm" validation="required" disabled ="true"
														friendly-name="Contaier No"></selectivity>  -->
														<span>{{blcntrDtl.containernumber}}</span>
														
										<label class="col-md-5 control-label">{{blcntrDtl.forwarder}}</label>
												</td>
												<td class="text-center"><!-- <selectivity
														list="containerTypeList" property="blcntrDtl.type"
														id="type" ng-model="blcntrDtl.type" name="type"
														friendly-name="Con Type" form-name="blForm"
														validation="required"></selectivity> -->
															{{blcntrDtl.type}}
														</td>
														<td class="text-center">
														<!-- <label class="i-checks"><input type="checkbox"
													name="soc" id="soc" ng-model="blcntrDtl.soc" disabled="true"><i></i></label>-->
															{{blcntrDtl.soc}}
												</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" form-name="blForm" 
													friendly-name="Seal No" name="sealNo" id="sealNo"
													ng-model="blcntrDtl.sealNo" placeholder="Seal No"> -->
														{{blcntrDtl.sealNo}}</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" form-name="blForm" friendly-name="tw" name="tw"
													id="tw" ng-model="blcntrDtl.tw" placeholder="Net Weight" 
													data-ng-keyup="calcWeight(blcntrDtl,$index)"> -->
														{{blcntrDtl.tw}}</td>
												<td class="text-center"><!-- <input class="form-control"
													type="text" form-name="blForm" friendly-name="gw" name="gw"
													id="gw" ng-model="blcntrDtl.gw" validation="required"
													placeholder="Gross Weight"
													data-ng-keyup="calcWeight(blcntrDtl,$index)"> -->	
													{{blcntrDtl.gw}}</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" form-name="blForm" friendly-name="cb" name="cb"
													id="cb" ng-model="blcntrDtl.cb" placeholder="CBM"
													data-ng-keyup="calcWeight(blcntrDtl,$index)"> -->
														{{blcntrDtl.cb}}</td>
												
												<td class="text-center">
												<!-- <selectivity list="packageList"
														property="blcntrDtl.packageType" id="packageType"
														ng-model="blcntrDtl.packageType" name="packageType"
														form-name="blForm" friendly-name="Package Type"
														friendly-name="Package Type"></selectivity> -->
															{{blcntrDtl.packageType}}
														</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" name="noo" id="noo"
													ng-model="blcntrDtl.noOfPckgs" form-name="blForm"
													friendly-name="No Of Package" placeholder="No Of Package"
													form-name="blForm" validation="required" data-ng-keyup="calcWeight(blcntrDtl,$index)"> -->
													{{blcntrDtl.noOfPckgs}}
													</td>
												<td class="text-center">
												<!-- <input class="form-control"
													type="text" name="g" id="g" ng-model="blcntrDtl.goods"
													placeholder="Goods Desc"> -->
														{{blcntrDtl.goods}}</td>
												<td class="text-center"><input type="checkbox"
													name="iso" id="iso" ng-model="blcntrDtl.iso"><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="hazardous" id="hazardous" ng-model="blcntrDtl.hazardous"><i></i>
												</td>
												<td class="text-center"><input type="checkbox"
													name="ows" id="ows" ng-model="blcntrDtl.ows"><i></i>
												</td>
												<td class="text-center"><!-- <input class="form-control"
													type="text" name="mar" id="mar" ng-model="blcntrDtl.marks"
													placeholder="MARKS"> -->
														{{blcntrDtl.marks}}
													</td>
													<td class="text-center"><!-- <input class="form-control"
													type="text" name="unCode" id="unCode" ng-model="blcntrDtl.unCode"
													placeholder="UN CODE"> -->
														{{blcntrDtl.unCode}}
													</td>
													
													<td class="text-center"><!-- <input class="form-control"
													type="text" name="imcoCharge" id="imcoCharge" ng-model="blcntrDtl.imcoCharge"
													placeholder="IMCO"> -->
													{{blcntrDtl.imcoCharge}}
													</td>
											 
												

											</tr>
											<tr>
												<td></td>
												<td colspan="12">
													<table class="table table-striped b-t b-light">
														<tr>
															<th class="width_2 text-center subTable-brs">Charge
																Code</th>
															<th class="width_2 text-center subTable-brs">Currency</th>
															<th class="width_2 text-center subTable-brs">Rate</th>
															<th class="width_2 text-center subTable-brs">Terms</th>
															<!-- 												<th class="width_6 text-center subTable-brs">Real Amount</th>
 -->
															
														</tr>
														<tr
															ng-repeat="(bTrIndex, blcntrinnerDtl) in blcntrDtl.chargeList track by bTrIndex">
															<td class="subTable-brs text-center">
															<!-- <selectivity
																	list="surchargeList"
																	property="blcntrinnerDtl.chargeCode" id="chargeCode"
																	ng-model="blcntrinnerDtl.chargeCode" name="chargeCode"> -->
																	{{blcntrinnerDtl.chargeCode}}
																	</td>
															<td class="subTable-brs text-center">
															<!-- <selectivity
																	list="currencyList" property="blcntrinnerDtl.currency"
																	id="currency" ng-model="blcntrinnerDtl.currency"
																	name="currency">-->
																	{{blcntrinnerDtl.currency}}
																	</td>
															<td class="subTable-brs"><!--<input class="form-control"
																type="text" name="unitRate" id="unitRate"
																ng-model="blcntrinnerDtl.unitRate" placeholder=" Rate"> -->
																	{{blcntrinnerDtl.unitRate}}
																</td>
																<td class="subTable-brs">
																<!-- <selectivity
																	list="termsOfPayment" property="blcntrinnerDtl.terms"
																	id="terms" ng-model="blcntrinnerDtl.terms" name="terms"
																	form-name="blForm" friendly-name="Terms Of Payment"></selectivity> -->
																		{{blcntrinnerDtl.terms}}
																	</td>
															<!-- 												<td class="subTable-brs"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blcntrinnerDtl.realAmount"  placeholder="Real Amount"></td>
 -->
															
														</tr>
													</table>
												</td>

											</tr>
										</tbody>
									</table>
								
									<!-- <button type="button" class="btn btn-sm btn-danger" ng-disabled="blCreatedorNot"	
										ng-click="removecntrDtl(blNoData.blcntrDtlList)" >
										<i class="fa fa-minus"></i>
									</button>
									
									<br>
					       			<button type="button" class="btn btn-success" 
					       			ng-disabled="blCreatedorNot"					       			
										ng-click="swapContainer(blNoData)">Add Containers
									</button>
																							
						       		<button type="button" class="btn btn-success"  ng-disabled="blCreatedorNot"	
										ng-click="swapContainerGateOut(blNoData)">Add Other Containers
									</button> -->
																							       	
									<div class="padding-right-5">										
									<div class="col-md-4"></div>
									</div>


								</div>
								<br>



							</div>
						</div>
					</div>
					</tab> <tab heading="Goods" style="background:#5F9EA0		">
					<div class="panel-body">

						<div class="row">
							<div class="col-md-12">
							<!-- 	<label class="control-label">Main Commodity</label> <input
									class="form-control" type="text" name="maincom" id="maincom"
									ng-model="blNoData.maincom" placeholder="Main Commodity"> -->
									<div class="form-group">
									<label class="col-md-5 control-label">Main Commodity</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.maincom}}</label>
									</div>
											
									</div>

							</div>
							<div class="col-md-2">
							<!-- 	<label class="control-label">NO OF PKGS</label> <input
									class="form-control" type="text" name="pkgs" id="pkgs"
									ng-model="blNoData.pkgs" placeholder="PKGS"
									validation="numeric"> -->
									<div class="form-group">
									<label class="col-md-5 control-label">NO OF PKGS</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.pkgs}}</label>
									</div>
											
									</div>

							</div>

							<div class="col-md-3">
								<!-- <label class="control-label">N.WGT</label> <input
									class="form-control" type="text" name="n_wgt" id="n_wgt"
									ng-model="blNoData.n_wgt" placeholder="N.WGT"
									validation="numeric"> -->
									<div class="form-group">
									<label class="col-md-5 control-label">N.WGT</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.n_wgt}}</label>
									</div>
											
									</div>

							</div>

						

							<div class="col-md-3">
								<!-- <label class="control-label">G.WGT</label> <input
									class="form-control" type="text" name="g_wgt" id="g_wgt"
									ng-model="blNoData.g_wgt" placeholder="G.WGT"
									validation="numeric"> -->
									<div class="form-group">
									<label class="col-md-5 control-label">G.WGT</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.g_wgt}}</label>
									</div>
											
									</div>

							</div>


							<div class="col-md-2">
								<!-- <label class="control-label">CBM</label> <input
									class="form-control" type="text" name="cbm" id="cbm"
									ng-model="blNoData.cbm" placeholder="CBM" validation="numeric"> -->
									<div class="form-group">
									<label class="col-md-5 control-label">CBM</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.cbm}}</label>
									</div>
											
									</div>

							</div>

							<div class="col-md-6">
								<!-- <label class="control-label">Goods</label>
								<textarea class="form-control" type="text" name="goods"
									id="goods" ng-model="blNoData.goods" placeholder="Goods"> -->
									<div class="form-group">
									<label class="col-md-5 control-label">Goods</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.goods}}</label>
									</div>
											
									</div>
                   

							</div>

							<div class="col-md-6">
						<!-- 		<label class="control-label">Marks</label>
								<textarea class="form-control" type="text" name="marks"
									id="marks" ng-model="blNoData.marks" placeholder="Marks"> -->
									<div class="form-group">
									<label class="col-md-5 control-label">Marks</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.marks}}</label>
									</div>
											
									</div>
                   

							</div>
						</div>
						<br>

					</div>
					</tab>  </tabset>
					<br>
				</div>

			</div>
				
				</tab>
			<tab heading="BL" ng-if="isEdit" ng-click="checkBookingBL()">
			<div class="panel-body">
			<label hidden="true">{{voyage}}</label>
			<label hidden="true">{{BLnumber}}</label>
				<div class="row book-widget-row">
					<div class="col-md-12">
<div class="form-group">
								<label class="col-md-5 control-label"><b>BL No</b></label>
								<div class="col-md-3">
									<label class="col-md-5 control-label"><b>{{BLnumber}}</b></label>
								</div>

							</div>
						<div class="col-md-12"
							style="border: 1px solid rgba(0, 0, 0, 0.22);">
							<br>

<div class="col-md-6">

							<div class="form-group">
								<label class="col-md-5 control-label"></b>ShipmentOrder No</b></label>
								<div class="col-md-7">
									<label class="col-md-5 control-label">{{blNoData.jobNo}}</label>
								</div>

							</div>
</div>

<div class="col-md-6">
							<div class="col-md-5" ng-if="isEdit">
								<label class="col-md-5 control-label">BL TYPE:</label>
								<div class="col-md-7">
									<label class="col-md-5 control-label">{{bltype}}</label>
								</div>


							</div>
							</div>
							<br>

						</div>
						<div class="col-md-12"
							style="border: 1px solid rgba(0, 0, 0, 0.22); margin-top: 2%;">
							<div class="col-md-6" style="margin-top: 1%; margin-bottom: 1%;">

								<div class="form-group">
									<label class="col-md-5 control-label"><b>Place of
											Issue</b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.issuePlace}}</label>
									</div>

								</div>
<div class="form-group">
									<label class="col-md-5 control-label"><b>Date of Issue </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.issueDate}}</label>
									</div>

								</div>

<div class="form-group">
									<label class="col-md-5 control-label"><b>Vsl.Voyage </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.vslVoyage}}</label>
									</div>

								</div>
								
								
							</div>
							<br>
							<div class="col-md-6" style="margin-top: 1%; margin-bottom: 1%;">

<div class="form-group">
									<label class="col-md-5 control-label"><b>Receipt at</b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.receiptAt}}</label>
									</div>

								</div>

<div class="form-group">
									<label class="col-md-5 control-label"><b>P.O.L </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.pol}}</label>
									</div>

								</div>
<div class="form-group">
									<label class="col-md-5 control-label"><b>P.O.D </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.pod}}</label>
									</div>

								</div>		
								
								

							</div>
							<br>
							<div class="col-md-6" style="margin-top: 1%; margin-bottom: 1%;">


								<!--  <div class="col-md-4">
                <label class="control-label">P.O.T  <span style="color: red;"></span></label>
               <selectivity list="portlist" property="blNoData.pot" id="pot" ng-model="blNoData.pot"
               name="pot" form-name="blForm" 
                friendly-name="POT"></selectivity>                            </div> -->
<div class="form-group">
									<label class="col-md-5 control-label"><b>F.P.O.D </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.fpod}}</label>
									</div>

								</div>		
								
								<!-- 
								<div class="col-md-4">
									<label class="control-label">F.P.O.D <span
										style="color: red;"></span></label>
									<selectivity list="portlist" property="blNoData.fpod" id="fpod"
										ng-model="blNoData.fpod" name="fpod" form-name="blForm"
										friendly-name="FPOD" disabled="true"></selectivity>
								</div> -->
								<div class="form-group">
									<label class="col-md-5 control-label"><b>Shipment Term </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.terms}}</label>
									</div>

								</div>	
								
								<!-- <div class="col-md-4">
									<label class="control-label">Shipment Terms <span
										style="color: red;">*</span></label>
									<selectivity list="termsOfPayment" property="blNoData.terms"
								id="terms" ng-model="blNoData.terms" name="terms"
								form-name="blForm" validation="required"
								friendly-name="Terms Of Payment"></selectivity>
									<span>{{blNoData.terms}}</span>

								</div> -->
										<div class="form-group">
									<label class="col-md-5 control-label"><b>No.Bls </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.noBls}}</label>
									</div>

								</div>	
								<!-- <div class="col-md-4">
									<label class="control-label">No.Bls <span
										style="color: red;">*</span></label>
									<input type="number"
								placeholder="No.Bls" class="form-control" id="noBls"
								friendly-name="No.Bls" ng-model="blNoData.noBls" name="noBls"
								form-name="blForm" validation="required">
									<span>{{blNoData.noBls}}</span>

								</div> -->

							</div>
							<br>
							<div class="col-md-6" style="margin-top: 1%; margin-bottom: 1%;">
							
								<div class="form-group">
									<label class="col-md-5 control-label"><b>Display Vessel </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disvessel}}</label>
									</div>

								</div>	
							
								<!-- <div class="col-md-4">
									<label class="control-label">Display Vessel <span
										style="color: red;"></span></label>
									 <input class="form-control"
								type="text" placeholder="" class="form-control" id="disvessel"
								friendly-name="disvessel" ng-model="blNoData.disvessel" name="disvessel"
								form-name="blForm">
									<span>{{blNoData.disvessel}}</span>

								</div> -->
								<div class="form-group">
									<label class="col-md-5 control-label"><b>Display Voyage </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disvoyage}}</label>
									</div>

								</div>	
								
								<!-- <div class="col-md-4">
									<label class="control-label">Display Voyage <span
										style="color: red;"></span></label>
									 <input class="form-control"
								type="text" placeholder="" class="form-control" id="disvoyage"
								friendly-name="disvoyage" ng-model="blNoData.disvoyage" name="disvoyage"
								form-name="blForm">
									<span>{{blNoData.disvoyage}}</span>
								</div> -->
										<div class="form-group">
									<label class="col-md-5 control-label"><b>Display P.O.R  </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disPor}}</label>
									</div>

								</div>	
								</div>
								
								
								<!-- <div class="col-md-4">
									<label class="control-label">Display P.O.R <span
										style="color: red;"></span></label>
									<input class="form-control"
								type="text" placeholder="" class="form-control" id="disPor"
								friendly-name="disPor" ng-model="blNoData.disPor" name="disPor"
								form-name="blForm">
									<span>{{blNoData.disPor}}</span>

								</div> -->
							</div>
							<br>
							<div class="col-md-12"
							style="border: 1px solid rgba(0, 0, 0, 0.22); margin-top: 2%;">
							<div class="col-md-6" style="margin-top: 1%; margin-bottom: 1%;">
							
										<div class="form-group">
									<label class="col-md-5 control-label"><b>Display P.O.L </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disPol}}</label>
									</div>

								</div>	
								
								<!-- <div class="col-md-4">
									<label class="control-label">Display P.O.L <span
										style="color: red;"></span></label>
									<input class="form-control"
								type="text" placeholder="" class="form-control" id="disPol"
								friendly-name="disPol" ng-model="blNoData.disPol" name="disPol"
								form-name="blForm">
									<span>{{blNoData.disPol}}</span>
								</div> -->
								
											<div class="form-group">
									<label class="col-md-5 control-label"><b>Display P.O.D </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disPod}}</label>
									</div>

								</div>	
								<!-- <div class="col-md-4">
									<label class="control-label">Display P.O.D <span
										style="color: red;"></span></label>
									 <input class="form-control"
								type="text" placeholder="" class="form-control" id="disPod"
								friendly-name="disPod" ng-model="blNoData.disPod" name="disPod"
								form-name="blForm">
									<span>{{blNoData.disPod}}</span>
								</div> -->
								
										<div class="form-group">
									<label class="col-md-5 control-label"><b>Display F.P.O.D </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.disFpod}}</label>
									</div>

								</div>	
								<!-- <div class="col-md-4">
									<label class="control-label">Display F.P.O.D <span
										style="color: red;"></span></label>
									<input class="form-control"
								type="text" placeholder="" class="form-control" id="disFpod"
								friendly-name="disFpod" ng-model="blNoData.disFpod" name="disFpod"
								form-name="blForm">
									<span>{{blNoData.disFpod}}</span>
								</div> -->
							</div>
							<br>
							<div class="col-md-6" style="margin-top: 1%; margin-bottom: 1%;">

<div class="form-group">
									<label class="col-md-5 control-label"><b>Customer </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.client}}</label>
									</div>

								</div>	

								<!-- <div class="col-md-4" ng-if="!isEdit">
									<label class="control-label">Customer <span
										style="color: red;">*</span></label>
									<selectivity list="customerList" property="blNoData.client"
								id="client" ng-model="blNoData.client" name="client"
								friendly-name="Client" form-name="blForm" validation="required"></selectivity>
									<span>{{blNoData.client}}</span>
								</div> -->
							
								
								<!-- <div class="col-md-4" ng-if="isEdit">
									<label class="control-label">Customer <span
										style="color: red;">*</span></label>
									<selectivity list="customerList1" property="blNoData.client"
								id="client" ng-model="blNoData.client" name="client"
								friendly-name="Client" form-name="blForm" validation="required"></selectivity>
									<span>{{blNoData.client}}</span>
								</div> -->
								<!--  <div class="col-md-4">
                <label class="control-label">Payer  <span style="color: red;"></span></label>
                   <selectivity list="payerList" property="blNoData.payer" id="payer" ng-model="blNoData.payer"
               name="payer"    form-name="blForm"   ></selectivity>   
              </div> -->
              	
								
<div class="form-group">
									<label class="col-md-5 control-label"><b>On Board </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.onBoard}}</label>
									</div>

								</div>
								<!-- <div class="col-md-4">
									<label class="control-label">On Board <span
										style="color: red;"></span></label>
											<ng-bs3-datepicker data-ng-model="blNoData.onBoard" id="onBoard"
								friendly-name="On Board"  name="onBoard" disabled ="true"
								form-name="blForm" />
									<span>{{blNoData.onBoard}}</span>
								</div>
 -->
 <div class="form-group">
									<label class="col-md-5 control-label"><b> Remarks </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.remarks}}</label>
									</div>

								</div>
								<!-- <div class="col-md-4">
									<label class="control-label">Remarks</label>
									 <input
								class="form-control" type="text" placeholder="Remarks"
								class="form-control" id="remarks" ng-model="blNoData.remarks"
								name="remarks">
									<span>{{blNoData.remarks}}</span>
								</div> -->
							</div>
							
							<div class="col-md-6" style="margin-top: 1%; margin-bottom: 1%;">
							
							 <div class="form-group">
									<label class="col-md-5 control-label"><b> REF </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.ref}}</label>
									</div>

								</div>
							
								<!-- <div class="col-md-4">
									<label class="control-label">REF <span
										style="color: red;"></span></label>
									<input class="form-control"
								type="text" placeholder="REF" class="form-control" id="ref"
								friendly-name="Ref" ng-model="blNoData.ref" name="ref"
								form-name="blForm">
									<span>{{blNoData.ref}}</span>
								</div> -->
 <div class="form-group">
									<label class="col-md-5 control-label"><b> Other Bl No  </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.otherblno}}</label>
									</div>

								</div>
								<!-- <div class="col-md-4">
									<label class="control-label">Other Bl No </label>
									<input class="form-control"
								type="text" class="form-control" id="otherblno"
								 ng-model="blNoData.otherblno" name="otherblno"
								form-name="blForm">
									<span>{{blNoData.otherblno}}</span>
								</div> -->
</div>
								<div class="col-md-6" style="padding-top: 27px;">
									<label class="i-checks m-b-none" style="padding-left: 12px;"><b>Multi
										Model </b><input type="checkbox" id="multimodel" name="multimodel"
										ng-model="blNoData.multimodel" form-name="blForm"> <i
										style="margin-left: 20px;"></i>


									</label> <label class="i-checks m-b-none" style="padding-left: 12px;"><b>RFS</b>
										<input type="checkbox" id="multimodel" name="multimodel"
										ng-model="blNoData.rfs" form-name="blForm"> <i
										style="margin-left: 20px;"></i>

									</label> <label class="i-checks m-b-none" style="padding-left: 8px;"><b>Detention</b>
										Tariff <input type="checkbox" id="detentionTariff"
										name="detentionTariff" ng-model="blNoData.detentionTariff"
										form-name="blForm"> <i style="margin-left: 20px;"></i>

									</label>
								</div>



								<!-- <div class="col-md-4" style="padding-top: 30px;">
								 <label
								  class="i-checks m-b-none">BL Release
									<input type="checkbox" id="blrelease" name ="blrelease" ng-model="blNoData.blrelease" form-name="blForm"><i style="margin-left: 20px;"></i>
							</label>  
						</div>
						
						</div>
						
					<div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
						<div class="col-md-4">
							<label class="control-label">BL Release Remarks  </label>
									<textarea class="form-control" type="text" name="blreleaseremeraks" ng-disabled="blNoData.blrelease ===false "
											id="blreleaseremeraks" ng-model="blNoData.blreleaseremeraks" ></textarea>
						</div>
						</div>	
						
					<br> -->
								<!--   <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
    
</div>
 <br> -->
								<!-- <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
            <div class="col-md-4">
                <label class="control-label">M.Voyage</label>
                 <selectivity list="vesselVoyageList" property="blNoData.mVoyage" id="mVoyage" ng-model="blNoData.mVoyage"
               name="mVoyage" form-name="blForm" 
                 ></selectivity> 
               
                </div>
              
             
              <div class="col-md-4">
                  <label class="control-label">Load Type  <span style="color: red;">*</span></label>  
                  
                  <selectivity list="load" property="blNoData.loadType" id="loadType" ng-model="blNoData.loadType"
               name="loadType"friendly-name="Load Type"
                form-name="blForm" validation="required" ></selectivity>
        
                </div>
<div class="col-md-4">
                  <label class="control-label">Shipment Type  <span style="color: red;">*</span></label> 
                   <selectivity list="serviceList" property="blNoData.service" id="service" ng-model="blNoData.service"
               name="service"  friendly-name="Shipment Type"
                form-name="blForm" validation="required" ></selectivity>
                
               
 </div>
 
</div> -->
								<!-- 
 <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

  
          <div class="col-md-4">
                  <label class="control-label">Agent</label>
                <selectivity list="agentList" property="blNoData.agent" id="agent" ng-model="blNoData.agent"
               name="agent" form-name="blForm" 
                friendly-name="Load Type"></selectivity>        
                  
              </div>
 </div>
             <br> -->
								<!-- <div class="col-md-12" style="margin-top: 1%; margin-bottom: 2%;">
             
             

           <div class="col-md-4">
                <label class="control-label">Shipment  <span style="color: red;">*</span></label>
                   <selectivity list="shipmentList" property="blNoData.shipment" id="shipment" ng-model="blNoData.shipment"
               name="shipment"    form-name="blForm" validation="required" friendly-name="Shipment"></selectivity>   
              </div>
               
             <div class="col-md-4">
                <label class="control-label">Status</label>
                <selectivity list="statusList" property="blNoData.status" id="status" ng-model="blNoData.status"
               name="status" form-name="blForm" 
                friendly-name="Staus"></selectivity>
                  </div>
                  <div class="col-md-4">
                      <label class="control-label" style="margin-top: 8%;">Released</label>                 
                    <input  type="checkbox" id="released"  ng-model="blNoData.released" name="released">       
       </div>
             </div> -->
								<br>

								<!--  <div class="col-md-12" style="margin-top: 1%; margin-bottom: 2%;">
             

          
               
                   
             </div> -->


							

							<div class="col-md-6" style="margin-top: 1%; margin-bottom: 1%;">
							
							<div class="form-group">
									<label class="col-md-5 control-label"><b> Delivery Agent  </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.deliveryAgent}}</label>
									</div>

								</div>
							
								<!-- <div class="col-md-4">
									<label class="control-label">Delivery Agent <span
										style="color: red;">*</span></label>
									<selectivity list="vendorList" property="blNoData.deliveryAgent"
								id="deliveryAgent" ng-model="blNoData.deliveryAgent" name="deliveryAgent"
								friendly-name="deliveryAgent" form-name="blForm" validation="required"></selectivity>
									<span>{{blNoData.deliveryAgent}}</span>

								</div> -->
								
								<div class="form-group">
									<label class="col-md-5 control-label"><b>P.O.D.1 </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.pod1}}</label>
									</div>

								</div>
								
								<!-- <div class="col-md-4">
									<label class="control-label">P.O.D.1 <span
										style="color: red;"></span></label>
										<selectivity list="portlist" property="blNoData.pod1" id="pod1"
								ng-model="blNoData.pod1" name="pod1" form-name="blForm"
								friendly-name="POD1" disabled="true"></selectivity>
									<span>{{blNoData.pod1}}</span>
								</div> -->

								


							</div>
							<div class="col-md-6" style="margin-top: 1%; margin-bottom: 1%;">
							
							<div class="form-group">
									<label class="col-md-5 control-label"><b> Detention Tariff Type </b></label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{blNoData.detentionTariffType}}</label>
									</div>

								</div>
								
								
								<div class="form-group">
									<label class="col-md-5 control-label"><b> Retain
										OnBoard </b></label>
									<div class="col-md-7">
									<!-- 	<label class="col-md-5 control-label">{{blNoData.detentionTariffType}}</label> -->
										<input type="checkbox" id="rob" name="rob"
										ng-model="blNoData.rob" form-name="blForm" ng-disabled="true">
									</div>

								</div>
								
								<!-- <div class="col-md-7" style="padding-top: 27px;" ng-if="isEdit">
									<label class="i-checks m-b-none" style="padding-left: 12px;"><b>Retain
										OnBoard </b><input type="checkbox" id="rob" name="rob"
										ng-model="blNoData.rob" form-name="blForm" ng-disabled="true">
										<i style="margin-left: 20px;"></i>


									</label>

</div> -->
								</div>
								</div>
								<!-- <div class="col-md-4" ng-hide="true";>

									<label class="control-label">Detention Tariff Type</label>
									<selectivity list="tariffList" property="blNoData.detentionTariffType"
								id="detentionTariffType" ng-model="blNoData.detentionTariffType" name="detentionTariffType"
								friendly-name="detentionTariffType" form-name="blForm"  disabled = "true">
									<span>{{blNoData.detentionTariffType}}</span>
								</div>
							</div> -->


						</div>
						<br> <br>
						<div class="col-md-12"
							style="border: 1px solid rgba(0, 0, 0, 0.22); margin-top: 2%;">
							<br>
							<tabset justified="true" class="tab-container"> <tab
								heading="Names " style="background:#5F9EA0;  ">
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12">
										<fieldset>
											<!-- 	 <div class="col-md-12">
              <label class="control-label">Messers</label>
              <input class="form-control" type="text"  name="messers" id="messers" ng-model="blNoData.messers" placeholder="Messers">

            </div> -->

											<div class="col-md-6">
												<label class="control-label" ><b>Shippers</b><span
													style="color: red;">*</span></label>	<br>
					<span>{{blNoData.shipperId}}</span>
												<!-- <selectivity list="customerList"
													property="blNoData.shipperId" id="shipperId"
													ng-model="blNoData.shipperId" name="shipperId"
													form-name="blForm" validation="required"
													friendly-name="Shippers"></selectivity> -->
											</div>

											<div class="col-md-6">
											
												<label class="control-label"><b>Cnee</b><span
													style="color: red;">*</span></label>	<br><br>
																		<span>{{blNoData.cneeId}}</span>
													
												<!-- <selectivity list="customerList" property="blNoData.cneeId"
													id="cneeId" ng-model="blNoData.cneeId" name="cneeId"
													form-name="blForm" validation="required"
													friendly-name="Cnee"></selectivity> -->

											</div>

											<div class="col-md-6">
											<label class="control-label"><b>Shippers Dtls</b><span
													style="color: red;">*</span></label>
													<br><br>
																		<span>{{blNoData.shipper}}</span>
												<!-- <label class="control-label">Shippers Dtls</label>
												<textarea class="form-control" type="text" name="shipper"
													id="shipper" ng-model="blNoData.shipper"
													placeholder="Shippers"> -->
                            </textarea>

											</div>

											<div class="col-md-6">
												<label class="control-label"><b>Cnee Dtls</b></label>
												<br><br>
																		<span>{{blNoData.cnee}}</span>
												<!-- <textarea class="form-control" type="text" name="cnee"
													id="cnee" ng-model="blNoData.cnee" placeholder="Cnee">
                            </textarea> -->

											</div>

											<div class="col-md-6">
												<label class="control-label"><b>Notify1</b></label>
												
												<br><br>
																		<span>{{blNoData.notify1Id}}</span>
																		
												<!-- <selectivity list="customerList"
													property="blNoData.notify1Id" id="notify1Id"
													ng-model="blNoData.notify1Id" name="notify1Id"
													form-name="blForm"></selectivity> -->

											</div>
											<div class="col-md-6">
												<label class="control-label"><b>Notify2</b></label>
												<br><br>
																		<span>{{blNoData.notify2Id}}</span>
												<!-- <selectivity list="customerList"
													property="blNoData.notify2Id" id="notify2Id"
													ng-model="blNoData.notify2Id" name="notify2Id"
													form-name="blForm"></selectivity> -->
											</div>

											<div class="col-md-6">
												<label class="control-label"><b>Notify1 Dtls</b></label>
												<br><br>
																		<span>{{blNoData.notify1}}</span>
												<!-- <textarea class="form-control" type="text" name="notify1"
													id="notify1" ng-model="blNoData.notify1"
													placeholder="Notify1">
                            </textarea> -->

											</div>
											<div class="col-md-6">
												<label class="control-label"><b>Notify2 Dtls</b></label>
												<br><br>
																		<span>{{blNoData.notify2}}</span>
												<!-- 
												<textarea class="form-control" type="text" name="notify2"
													id="notify2" ng-model="blNoData.notify2"
													placeholder="Notify2">
                            </textarea> -->

											</div>
											<div class="col-md-6">
												<label class="control-label"><b>Forwarder</b></label>
													<br><br>
																		<span>{{blNoData.forwarderId}}</span>
												<!-- <selectivity list="customerList"
													property="blNoData.forwarderId" id="forwarderId"
													ng-model="blNoData.forwarderId" name="forwarderId"
													form-name="blForm"></selectivity> -->

											</div>

											<div class="col-md-6">
												<label class="control-label"><b>Forwarder Dtls</b></label>
												<br><br>
																		<span>{{blNoData.forwarder}}</span>
												<!-- 
												<textarea class="form-control" type="text" name="forwarder"
													id="forwarder" ng-model="blNoData.forwarder"
													placeholder="Forwarder">
                           	 			</textarea> -->
											</div>
										</fieldset>
									</div>

								</div>
								<br>

								<!--  </div>
	</div>
	</div> -->
							</div>
							</tab> <tab heading="Goods" style="background:#5F9EA0		">
							<div class="panel-body">

								<div class="row">
									<div class="col-md-12">
										<label class="control-label"><b>Main Commodity</b></label> 
										<br><br>
																		<span>{{blNoData.maincom}}</span>
									<!-- 	<input
											class="form-control" type="text" name="maincom" id="maincom"
											ng-model="blNoData.maincom" placeholder="Main Com"> -->

									</div>

									<!--  <div class="col-md-2">
              <label class="control-label">T.WGT</label>
              <input class="form-control" type="text" name="t_wgt" id="t_wgt" ng-model="blNoData.t_wgt"  placeholder="T.WGT" validation="numeric">

            </div> -->

									<div class="col-md-2">
										<label class="control-label"><b>NO OF PKGS</b></label> 
										<br><br>
																		<span>{{blNoData.pkgs}}</span>
										<!-- <input
											class="form-control" type="text" name="pkgs" id="pkgs"
											ng-model="blNoData.pkgs" placeholder="PKGS"
											validation="numeric"> -->

									</div>

									<div class="col-md-2">
										<label class="control-label"><b>N.WGT</b></label> 
										<br><br> <span>{{blNoData.n_wgt}}</span>
										<!-- <input
											class="form-control" type="text" name="n_wgt" id="n_wgt"
											ng-model="blNoData.n_wgt" placeholder="N.WGT"
											validation="numeric">
 -->
									</div>

									<div class="col-md-3" style="padding-top: 30px;">
										<label class="i-checks m-b-none"><b>Print N.WGT </b>
											
										<input
											type="checkbox" id="checkNetWgt" name="checkNetWgt"
											ng-model="blNoData.checkNetWgt" form-name="blForm"><i
											style="margin-left: 20px;"></i>
										</label>
									</div>

									<div class="col-md-2">
										<label class="control-label"><b>G.WGT</b></label>
												<br><br> <span>{{blNoData.g_wgt}}</span>
										<!--  <input
											class="form-control" type="text" name="g_wgt" id="g_wgt"
											ng-model="blNoData.g_wgt" placeholder="G.WGT"
											validation="numeric"> -->

									</div>


									<div class="col-md-2">
										<label class="control-label"><b>CBM</b></label> 
										<br><br> <span>{{blNoData.cbm}}</span>
										<!-- <input
											class="form-control" type="text" name="cbm" id="cbm"
											ng-model="blNoData.cbm" placeholder="CBM"
											validation="numeric"> -->

									</div>



									<div class="col-md-6">
										<label class="control-label"><b>Goods</b></label>
													<br><br> <span>{{blNoData.goods}}</span>
										<!-- <textarea class="form-control" type="text" name="goods"
											id="goods" ng-model="blNoData.goods" placeholder="Goods">
                      </textarea> -->

									</div>

									<div class="col-md-6">
										<label class="control-label"><b>Marks</b></label>
											<br><br> <span>{{blNoData.marks}}</span>
										<!-- <textarea class="form-control" type="text" name="marks"
											id="marks" ng-model="blNoData.marks" placeholder="Marks">
                      </textarea> -->

									</div>
								</div>
								<br>

							</div>
							</tab> <tab heading="Containers" style="background:#5F9EA0">
							<div class="col-md-12">
								<div class="table-responsive ">
									<div class="panel-body" style="width: 166%;">

										<div class="row" id="items">


											<table class="table table-striped b-t b-light">
												<thead>
													<tr>
														<th colspan=1 class="width_2">select</th>
														<th colspan=1 class="width_9 text-center">Cntr No <span
															style="color: red;">*</span></th>
														<th colspan=1 class="width_5 text-center">Type <span
															style="color: red;">*</span></th>
														<th colspan=1 class="width_3 text-center">SOC <span
															style="color: red;"></span></th>
														<th colspan=1 class="width_7 text-center">Seal No <span
															style="color: red;">*</span></th>
														<th colspan=1 class="width_7 text-center">NW (KG)<span
															style="color: red;"></span></th>
														<th colspan=1 class="width_7 text-center">GW (KG)<span
															style="color: red;">*</span></th>
														<th colspan=1 class="width_6 text-center">CBM <span
															style="color: red;"></span></th>
														<th colspan=1 class="width_6 text-center">Check Digit
															<span style="color: red;"></span>
														</th>
														<!-- <th colspan=1 class="width_6 text-center">Net <span style="color: red;"></span></th> -->
														<!-- <th colspan=1 class="width_6 text-center">FLE <span style="color: red;"></span></th>
									<th colspan=1 class="width_6 text-center">SOC <span style="color: red;"></span></th> -->
														<th colspan=1 class="width_7 text-center">Package <span
															style="color: red;"></span></th>
														<th colspan=1 class="width_6 text-center">No of
															Packages <span style="color: red;">*</span>
														</th>
														<th colspan=1 class="width_12 text-center">Commodity</th>
														<th colspan=1 class="width_4 text-center">is OOG</th>
														<th colspan=1 class="width_5 text-center">Hazardous</th>
														<th colspan=1 class="width_5 text-center">OWS</th>
														<th colspan=1 class="width_7 text-center">Marks</th>
														<th colspan=1 class="width_8 text-center">UN Code</th>
														<th colspan=1 class="width_8 text-center">IMCO Charge</th>
														<!-- <th colspan=1 class="width_6 text-center">POL Term <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">POD Term <span style="color: red;">*</span></th> -->
														<!-- <th colspan=1 class="width_4 text-center">Action</th> -->

													</tr>
												</thead>
												<tbody
													ng-repeat="(trIndex, blcntrDtl) in blNoData.blcntrDtlList">
													<tr>
													
													
												<td><label class="i-checks m-b-none"> <input
																type="checkbox" ng-model="blcntrDtl.select"><i></i></label></td>
														<td colspan=1 class="widtd_9 text-center">{{blcntrDtl.cntrNo}}</td>
														<td colspan=1 class="widtd_5 text-center">{{blcntrDtl.type}} </td>
														<td class="text-center"><label class="i-checks"><input
																type="checkbox" name="soc" id="soc"
																ng-model="blcntrDtl.soc" disabled="true"><i></i></label>
														</td>
														<td colspan=1 class="widtd_7 text-center">{{blcntrDtl.sealNo}}</td>
														<td colspan=1 class="widtd_7 text-center">{{blcntrDtl.tw}}</td>
														<td colspan=1 class="widtd_7 text-center">{{blcntrDtl.gw}}</td>
														<td colspan=1 class="widtd_6 text-center">{{blcntrDtl.cb}}</td>
														<td colspan=1 class="widtd_6 text-center">{{checkdigit}}
															
														</td>
														<!-- <td colspan=1 class="widtd_6 text-center">Net <span style="color: red;"></span></td> -->
														<!-- <td colspan=1 class="widtd_6 text-center">FLE <span style="color: red;"></span></td>
									<td colspan=1 class="widtd_6 text-center">SOC <span style="color: red;"></span></td> -->
														<td colspan=1 class="widtd_7 text-center">{{blcntrDtl.packageType}} <span
															style="color: red;"></span></td>
														<td colspan=1 class="widtd_6 text-center">{{blcntrDtl.noOfPckgs}} 
														</td>
														<td colspan=1 class="widtd_12 text-center">{{blcntrDtl.goods}}</td>
														<td colspan=1 class="widtd_4 text-center">{{blcntrDtl.iso}}</td>
														<td colspan=1 class="widtd_5 text-center">{{blcntrDtl.hazardous}}</td>
														<td colspan=1 class="widtd_5 text-center">{{blcntrDtl.ows}}</td>
														<td colspan=1 class="widtd_7 text-center">{{blcntrDtl.marks}}</td>
														<td colspan=1 class="widtd_8 text-center">{{blcntrDtl.unCode}}</td>
														<td colspan=1 class="widtd_8 text-center">{{imcoCharge}}</td>
														<!-- <td colspan=1 class="widtd_6 text-center">POL Term <span style="color: red;">*</span></td>
									<td colspan=1 class="widtd_6 text-center">POD Term <span style="color: red;">*</span></td> -->
														
													
														
														<!-- <td class="text-center"><selectivity
																list="containerList" property="blcntrDtl.cntrNo"
																id="cntrNo{{trIndex}}" ng-model="blcntrDtl.cntrNo"
																name="cntrNo{{trIndex}}" form-name="blForm"
																validation="required"
																friendly-name="{{ 'Row' + (trIndex+1) + '(Container No)'}}"
																disabled="true"></selectivity> 				
									<selectivity list="containerList" property="blcntrDtl.cntrNo" id="cntrNo" ng-model="blcntrDtl.cntrNo"
               name="cntrNo"  form-name="blForm" validation="required" friendly-name="Contaier No"></selectivity>
														</td>
														<td class="text-center"><selectivity
																list="containerTypeList" property="blcntrDtl.type"
																id="type{{trIndex}}" name="type{{trIndex}}"
																ng-model="blcntrDtl.type" validation="required"
																validation="required" form-name="blForm"
																friendly-name="{{ 'Row' + (trIndex+1) + '(Container Type)'}}"></selectivity>
														</td> -->
														<!-- <td class="text-center"><label class="i-checks"><input
																type="checkbox" name="soc" id="soc"
																ng-model="blcntrDtl.soc" disabled="true"><i></i></label>
														</td> -->
														<!-- <td class="text-center"><input class="form-control"
															type="text" form-name="blForm" validation="required"
															friendly-name="{{ 'Row' + (trIndex+1) + '(Seal No)'}}"
															name="sealNo{{trIndex}}" id="sealNo{{trIndex}}"
															ng-model="blcntrDtl.sealNo" placeholder="Seal No"></td> -->
														<!-- <td class="text-center"><input class="form-control"
															type="text" form-name="blForm" friendly-name="tw"
															name="tw{{trIndex}}" id="tw{{trIndex}}"
															ng-model="blcntrDtl.tw"></td>
														<td class="text-center"><input class="form-control"
															type="text" form-name="blForm" validation="required"
															friendly-name="{{ 'Row' + (trIndex+1) + '(GW)'}}"
															name="gw{{trIndex}}" id="gw{{trIndex}}"
															ng-model="blcntrDtl.gw"></td>
														<td class="text-center"><input class="form-control"
															type="text" form-name="blForm" friendly-name="cb"
															name="cb{{trIndex}}" id="cb{{trIndex}}"
															ng-model="blcntrDtl.cb"></td> -->
													<!-- 	<td class="text-center"><input class="form-control"
															type="text" name="checkdigit" form-name="blForm"
															id="checkdigit{{trIndex}}"
															ng-model="blcntrDtl.checkdigit"></td> -->
														<!--<td class="text-center"><input class="form-control" type="text" name="net" form-name="blForm"    id="net{{trIndex}}" ng-model="blcntrDtl.net"  ></td>
									 <td class="text-center">
									 <selectivity list="fleList" property="blcntrDtl.fle" id="fle" ng-model="blcntrDtl.fle" validation="required"
               name="fle" form-name="blForm" 
                friendly-name="FLE"></selectivity>
									 </td>
									<td class="text-center">
									   <selectivity list="socList" property="blcntrDtl.so" id="SOC" ng-model="blcntrDtl.so" validation="required"
               name="SOC" form-name="blForm" 
                friendly-name="SOC"></selectivity>
									 </td> -->
														<!-- <td class="text-center"><selectivity
																list="packageList" property="blcntrDtl.packageType"
																id="packageType{{trIndex}}"
																ng-model="blcntrDtl.packageType" name="packageType"
																form-name="blForm" friendly-name="Package Type"
																friendly-name="Package Type"></selectivity></td> -->
												<!-- 		<td class="text-center"><input class="form-control"
															type="text" name="noo{{trIndex}}" id="noo{{trIndex}}"
															ng-model="blcntrDtl.noOfPckgs" validation="required"
															form-name="blForm"
															friendly-name="{{ 'Row' + (trIndex+1) + '(No Of Package)'}}"
															placeholder="NoO"></td>
														<td class="text-center"><input class="form-control"
															type="text" name="g{{trIndex}}" id="g{{trIndex}}"
															ng-model="blcntrDtl.goods"></td> -->
														<!-- <td class="text-center"><input type="checkbox"
															name="iso" id="iso{{trIndex}}" ng-model="blcntrDtl.iso"
															disabled="true"><i></i></td>
														<td class="text-center"><input type="checkbox"
															name="hazardous" id="hazardous{{trIndex}}"
															ng-model="blcntrDtl.hazardous" disabled="true"><i></i>
														</td>
														<td class="text-center"><input type="checkbox"
															name="ows" id="ows{{trIndex}}" ng-model="blcntrDtl.ows"
															disabled="true"><i></i></td> -->
														<!-- <td class="text-center"><input class="form-control"
															type="text" name="mar{{trIndex}}" id="mar{{trIndex}}"
															ng-model="blcntrDtl.marks" placeholder="MARKS"></td> -->
														<!-- <td class="text-center"><input class="form-control"
															type="text" name="unCode" id="unCode"
															ng-model="blcntrDtl.unCode" placeholder="UN CODE"></td> -->

														<!-- <td class="text-center"><input class="form-control"
															type="text" name="imcoCharge" id="imcoCharge"
															ng-model="blcntrDtl.imcoCharge" placeholder="IMCO"></td> -->
														<!-- <td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.polTer" id="polTer" ng-model="blcntrDtl.polTer"
          form-name="blForm" validation="required" friendly-name="POL Term"     name="polTer"   ></selectivity>	</td>
                 <td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.podTer" id="podTer" ng-model="blcntrDtl.podTer"
         form-name="blForm" validation="required" friendly-name="POD Term"      name="podTer"   ></selectivity>	</td> -->
														<!-- <td class="text-center">
															<button ng-click="addinnercntrDtl(blcntrDtl)"
																class="btn btn-info" tooltip="Add Row" type="button">
																<i class="fa fa-plus"></i>
															</button>
														</td> -->

													</tr>
													<tr>
														<td></td>
														<td colspan="12">
															<table class="table table-striped b-t b-light">
																<tr>
																	<th class="width_2 text-center subTable-brs">Charge
																		Code</th>
																	<th class="width_2 text-center subTable-brs">Currency</th>
																	<th class="width_2 text-center subTable-brs">Rate</th>
																	<!-- 												<th class="width_6 text-center subTable-brs">MEA Rate</th>
 -->
																	<!-- <th class="width_6 text-center subTable-brs">WG Rate</th>
												<th class="width_8 text-center subTable-brs">From Place</th>
												<th class="width_8 text-center subTable-brs">To Place</th>
												<th class="width_6 text-center subTable-brs">Min Rate</th> -->
																	<th class="width_2 text-center subTable-brs">Terms</th>
																	<!-- 												<th class="width_6 text-center subTable-brs">Real Amount</th>
 --><!-- 
																	<th class="width_2 text-center subTable-brs">Action</th> -->
																</tr>
																<tr
																	ng-repeat="(bTrIndex, blcntrinnerDtl) in blcntrDtl.chargeList track by bTrIndex">
																	<td class="subTable-brs text-center">
																	
																<!-- 	<selectivity
																			list="CntrsurchargeList"
																			property="blcntrinnerDtl.chargeCode" id="chargeCode"
																			ng-model="blcntrinnerDtl.chargeCode"
																			name="chargeCode"> -->
																			{{blcntrinnerDtl.chargeCode}}
																			
																			</td>
																	<td class="subTable-brs text-center">
																	<!-- <selectivity
																			list="currencyList"
																			property="blcntrinnerDtl.currency" id="currency"
																			ng-model="blcntrinnerDtl.currency" name="currency"> -->
																					{{blcntrinnerDtl.currency}}
																			</td>
																	<td class="subTable-brs">
																	<!-- <input
																		class="form-control" type="text" name="unitRate"
																		id="unitRate" ng-model="blcntrinnerDtl.unitRate"
																		placeholder=" Rate"> -->
																			{{blcntrinnerDtl.unitRate}}
																		</td>
																	<!-- <td class="subTable-brs"><input class="form-control" type="text" name="meaRate" id="meaRate" ng-model="blcntrinnerDtl.meaRate"  placeholder="MEA Rate"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="wgRate" id="wgRate" ng-model="blcntrinnerDtl.wgRate"  placeholder="WG Rate"></td>
												<td class="subTable-brs">  <selectivity list="portlist" property="blcntrinnerDtl.fromPlace" id="fromPlace" ng-model="blcntrinnerDtl.fromPlace"
               name="fromPlace" form-name="blForm" 
                friendly-name="From Place"> </td>
												<td class="subTable-brs"><selectivity list="portlist" property="blcntrinnerDtl.toPlace" id="toPlace" ng-model="blcntrinnerDtl.toPlace"
               name="toPlace" form-name="blForm" 
                friendly-name="To Place"> </td>
												<td class="subTable-brs"><input class="form-control" type="text" name="minRate" id="minRate" ng-model="blcntrinnerDtl.minRate"  placeholder="Min Rate"></td> -->
																	<td class="subTable-brs">
															<!-- 		<selectivity
																			list="termsOfPayment" property="blcntrinnerDtl.terms"
																			id="terms" ng-model="blcntrinnerDtl.terms"
																			name="terms" form-name="blForm"
																			friendly-name="Terms Of Payment"></selectivity> -->
																				{{blcntrinnerDtl.terms}}
																			</td>
																	<!-- 												<td class="subTable-brs"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blcntrinnerDtl.realAmount"  placeholder="Real Amount"></td>
 -->
																	<!-- <td class="subTable-brs"><button
																			ng-click="deleteinnercntrDtl(blcntrDtl,bTrIndex)"
																			class="btn btn-sm btn-danger" type="button"
																			tooltip="Delete">
																			<i class="fa  fa-trash-o"></i>
																		</button></td> -->
																</tr>
															</table>
														</td>

													</tr>
												</tbody>
											</table>
											<!-- <button type="button" class="btn btn-sm btn-success "
										ng-click="addcntrDtl()">
										<i class="fa fa-plus"></i>
									</button>
									<button type="button" class="btn btn-sm btn-danger"
										ng-click="removecntrDtl(blNoData.blcntrDtlList)">
										<i class="fa fa-minus"></i>
									</button> -->

											<div class="padding-right-5">
												<div class="col-md-4"></div>
											</div>


										</div>
										<br>



									</div>
								</div>
							</div>
							</tab> <!-- <tab heading="Package" style="background:#5F9EA0">
 <div class="col-md-12">
	 <div class="table-responsive ">
	<div class="panel-body" style="width: 220%;">
		 
			<div class="row" id="items">
			
			 <div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_2">select</th>
									<th colspan=1 class="width_6 text-center">Cntr No<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Type<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Seal No<span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center"> TW<span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center"> GW<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> CB<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Net<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> FLE<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> SOC<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Package<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> No of Packages<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Goods<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">is OOG</th>
									<th colspan=1 class="width_6 text-center">Marks</th>
									<th colspan=1 class="width_6 text-center">POL Term<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">POD Term<span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center">Action</th>

								</tr>
							</thead>
							<tbody ng-repeat="(trIndex1, blpckDtl) in blNoData.blpckDtlList">
								<tr>
<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="blpckDtl.select"><i></i></label></td>
					 <td class="text-center">
					 <selectivity list="containerList" property="blpckDtl.cntrNo" id="cntrNo" ng-model="blpckDtl.cntrNo"
               name="cntrNo" form-name="blForm" validation="required"  
                friendly-name="Cntr No"></selectivity>
                 <selectivity list="containerList" property="blpckDtl.cntrNo" id="cntrNo" ng-model="blpckDtl.cntrNo"
               name="cntrNo" form-name="blForm" validation="required"  
                friendly-name="Cntr No"></selectivity>
                	</td>
                 <td class="text-center">
    <selectivity list="containerTypeList" property="blpckDtl.type" id="type" ng-model="blpckDtl.type"
               name="type"  form-name="blForm" validation="required"   
                friendly-name="Container Type"></selectivity>	</td>
 									<td class="text-center"><input class="form-control" type="text" name="sealNo" id="sealNo" ng-model="blpckDtl.sealNo"  form-name="blForm" validation="required" friendly-name="Seal No" placeholder="Seal No"></td>
									<td class="text-center"><input class="form-control" type="text" name="tw" id="tw" ng-model="blpckDtl.tw"  form-name="blForm" validation="required|numeric" friendly-name="TW" placeholder="TW"></td>
									<td class="text-center"><input class="form-control" type="text" name="gw" id="gw" ng-model="blpckDtl.gw"  form-name="blForm" validation="required|numeric" friendly-name="GW" placeholder="GW"></td>
									<td class="text-center"><input class="form-control" type="text" name="cb" id="cb" ng-model="blpckDtl.cb" form-name="blForm" validation="required|numeric" friendly-name="CB" placeholder="CB"></td>
									<td class="text-center"><input class="form-control" type="text" name="net" id="net" ng-model="blpckDtl.net"  form-name="blForm" validation="required|numeric" friendly-name="NET" placeholder="NET"></td>
									<td class="text-center"> <selectivity list="fleList" property="blpckDtl.fle" id="fle" ng-model="blpckDtl.fle" validation="required"
               name="fle" form-name="blForm" 
                friendly-name="FLE"></selectivity></td>
									<td class="text-center">
									 <selectivity list="socList" property="blpckDtl.so" id="SOC" ng-model="blpckDtl.so" validation="required"
               name="SOC" form-name="blForm" 
                friendly-name="SOC"></selectivity>
									 </td>
										 <td class="text-center">
    <selectivity list="packageList" property="blpckDtl.packageType" form-name="blForm" id="packageType" ng-model="blpckDtl.packageType"
               name="packageType"  
                friendly-name="Package Type"></selectivity>	</td>
 									<td class="text-center"><input class="form-control" type="text" name="no" id="no" ng-model="blpckDtl.noOfPckgs"  form-name="blForm" validation="required" friendly-name="No of Package"    placeholder="NO"></td>
									<td class="text-center"><input class="form-control" type="text" name="g" id="g" ng-model="blpckDtl.goods"   validation="required"></td>
									<td class="text-center"> <input type="checkbox" name="iso" id="iso" ng-model="blpckDtl.iso"><i></i> </td>
									<td class="text-center"><input class="form-control" type="text" name="mar" id="mar" ng-model="blpckDtl.marks"  placeholder="MARKS"></td>
								<td class="text-center">
    <selectivity list="termsOfPayment" property="blpckDtl.polTer" id="polTer" ng-model="blpckDtl.polTer"
               name="polTer"  form-name="blForm" validation="required" friendly-name="Pol Term"    ></selectivity>	</td>
                 <td class="text-center">
    <selectivity list="termsOfPayment" property="blpckDtl.podTer" id="podTer" ng-model="blpckDtl.podTer"
               name="podTer"  form-name="blForm"  validation="required" friendly-name="Pod Term"   ></selectivity>	</td>
<td>
									<button ng-click="addinnerpckDtl(blpckDtl)" class="btn btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button></i> </td>					
									
								</tr>
								<tr  >
									<td></td>
									<td colspan="15">
										<table class="table table-striped b-t b-light">
											<tr>
												<th class="width_2 text-center subTable-brs"> HSCode<span style="color: red;">*</span></th>
												<th class="width_8 text-center subTable-brs"> Package Type<span style="color: red;">*</span></th>
												<th class="width_6 text-center subTable-brs"> No of Packages<span style="color: red;">*</span></th>
												<th class="width_6 text-center subTable-brs"> GW<span style="color: red;">*</span></th>
												<th class="width_6 text-center subTable-brs">Goods</th>
												<th class="width_3 text-center subTable-brs">Action</th>
											</tr>
											<tr ng-repeat="($index, blpckinnerDtl) in blpckDtl.packageList track by $index">
												 
												<td class="subTable-brs text-center"><input class="form-control" type="text" name="hsCode" id="hsCode" ng-model="blpckinnerDtl.hsCode"  form-name="blForm" validation="required" friendly-name="HSCode"   placeholder="HSCode"></td>
												<td class="subTable-brs text-center">
    <selectivity list="packageList" property="blpckinnerDtl.packageType" id="packageType" ng-model="blpckinnerDtl.packageType"  name="packageType"     form-name="blForm" validation="required"  friendly-name="Package Type"></selectivity>	</td>
                
 												<td class="subTable-brs"><input class="form-control" type="text" name="noofPcks" id="noofPcks" ng-model="blpckinnerDtl.noofPcks" form-name="blForm" validation="required" friendly-name="No of Packages"    placeholder="No of Packages"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="gw_" id="gw_" ng-model="blpckinnerDtl.gw_"  form-name="blForm" validation="required" friendly-name="GW"   placeholder="GW"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="goods" id="goods" ng-model="blpckinnerDtl.goods"  placeholder="Goods"></td>
									
										<td class="subTable-brs"><button ng-click="deleteinnerpckDtl(blpckDtl,$index)"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button></td>
											</tr>
										</table>
									</td>
									
								</tr>
							</tbody>
						</table>
				  <button type="button" class="btn btn-sm btn-success" ng-click="addpckDtl()"><i class="fa fa-plus"></i></button>
									  <button type="button" class="btn btn-sm btn-danger" ng-click="removepckDtl(blNoData.blpckDtlList)"><i class="fa fa-minus"></i></button>
						
						<div class="padding-right-5">
							<div class="col-md-4">
								
								
							</div>
						</div>
					</div>
			
			</div>
			<br>
			 
	 
	</div>
	</div>
	</div>
	</tab>  --> <tab heading="BL Charges" style="background:#5F9EA0">
							<div class="col-md-12">
								<div class="table-responsive ">
									<div class="panel-body">

										<div class="row" id="items">

											<div class="table-responsive clear">
												<table class="table table-striped b-t b-light">
													<thead>
														<tr>
															<th colspan=1 class="width_1"></th>
															<th colspan=1 class="width_4">Seq<span
																style="color: red;">*</span></th>
															<th colspan=1 class="width_6 text-center">Charges
																Code<span style="color: red;">*</span>
															</th>
															<th colspan=1 class="width_6 text-center">Currency <span
																style="color: red;">*</span></th>
															<th colspan=1 class="width_6 text-center">Qty <span
																style="color: red;">*</span></th>
															<th colspan=1 class="width_4 text-center">Rate<span
																style="color: red;">*</span>
															</th>
															<th colspan=1 class="width_4 text-center">Amount<span
																style="color: red;">*</span>
															</th>
															<th colspan=1 class="width_6 text-center">PayAt <span
																style="color: red;"></span></th>
															<th colspan=1 class="width_6 text-center">Terms<span
																style="color: red;"></span>
															</th>
															<!-- <th colspan=1 class="width_6 text-center"> From Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> To Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Invoice Amount<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Real Amount<span style="color: red;">*</span></th> -->


														</tr>
													</thead>
													<tbody
														ng-repeat="(trIndex1, blCharge) in blNoData.blCharges">
														<tr>
															<td><label class="i-checks m-b-none"> <input
																	type="checkbox" ng-model="blCharge.select"><i></i></label></td>

															<td><!-- <input class="form-control" type="text"
																name="seq" id="seq" ng-model="blCharge.seq"
																form-name="blForm" form-name="blForm"
																validation="required" friendly-name="Sequence"> -->
																{{blCharge.seq}}</td>
															<td class="text-center">
															<!-- <selectivity
																	list="BlsurchargeList" property="blCharge.chargeCode"
																	id="chargeCode" ng-model="blCharge.chargeCode"
																	name="chargeCode" form-name="blForm"
																	validation="required" friendly-name="Charge Code"> -->
																		{{"blCharge.chargeCode"}}</td>
																	</td>
															<td class="text-center">
															<!-- <selectivity
																	list="currencyList" property="blCharge.currency"
																	id="currency" ng-model="blCharge.currency"
																	name="currency" form-name="blForm"
																	validation="required" friendly-name="Currency"> -->
																		{{blCharge.currency}}
																	</td>
															<td class="text-center">
														<!-- 	<input class="form-control"
																type="text" name="qty" id="qty" ng-model="blCharge.qty"
																form-name="blForm" validation="required"
																friendly-name="Qty"> -->
																		{{blCharge.qty}}
																</td>
															<td class="text-center">
															<!-- <input class="form-control"
																type="text" name="rate" id="rate"
																ng-model="blCharge.rate" form-name="blForm"
																validation="required" friendly-name="Rate"> -->
																		{{blCharge.rate}}
																</td>
															<td class="text-center">
															<!-- <input class="form-control"
																type="text" name="amount" id="amount"
																ng-model="blCharge.amount" form-name="blForm"
																validation="required" friendly-name="Amount"> -->
																				{{blCharge.amount}}
																</td>
															<td class="text-center">
															<!-- <selectivity list="portlist"
																	property="blCharge.payAt" id="payAt"
																	ng-model="blCharge.payAt" name="payAt"
																	form-name="blForm" friendly-name="PayAt"></selectivity> -->
																			{{blCharge.payAt}}
																	</td>
															<td class="text-center">
															<!-- <selectivity
																	list="termsOfPayment" property="blCharge.terms"
																	id="terms" ng-model="blCharge.terms" name="terms"
																	form-name="blForm" friendly-name="Terms"></selectivity> -->
																		{{blCharge.terms}}
																	</td>
															<!-- 	<td class="text-center"><selectivity list="portlist" property="blCharge.fromPlace" id="fromPlace" ng-model="blCharge.fromPlace"
               name="fromPlace" form-name="blForm" validation="required"  friendly-name="From Place"  ></td>
									<td class="text-center"><selectivity list="portlist" property="blCharge.toPlace" id="toPlace" ng-model="blCharge.toPlace"
               name="toPlace" form-name="blForm" form-name="blForm" validation="required"  friendly-name="To Place" ></td>
										 <td class="text-center"><input class="form-control" type="text" name="invAmount" id="invAmount" ng-model="blCharge.invAmount"  form-name="blForm" validation="required"  friendly-name="Invoice Amount" ></td>
 									<td class="text-center"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blCharge.realAmount" form-name="blForm" validation="required"  friendly-name="Real Amount"></td>
									  -->


														</tr>
														<tr>
															<td></td>


														</tr>
													</tbody>
												</table>
												<!-- <button type="button" class="btn btn-sm btn-success"
													ng-click="addcharges()">
													<i class="fa fa-plus"></i>
												</button>
												<button type="button" class="btn btn-sm btn-danger"
													ng-click="removepckCharge(blNoData.blCharges)">
													<i class="fa fa-minus"></i>
												</button>
 -->
												<div class="padding-right-5">
													<div class="col-md-4"></div>
												</div>
											</div>

										</div>
										<br>


									</div>
								</div>
							</div>
							</tab> </tabset>
						</div>
						
					</div>
		
			<br>
			
	</div>
</tab>
			<tab heading="onBoard" ng-if="isEdit" ng-click="checkOnBoard(voyage)">
					<div class="panel-body">
			<form name="onBoardForm" class="form-horizontal" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Vessel </label>
								<div class="col-md-5">{{onBoard.vessel}}</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Port  </label>
								<div class="col-md-5">{{onBoard.port}}</div>
							</div>
							<label hidden="true">{{portfromonboard}}</label>

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6">
						<fieldset>


							<div class="form-group">
								<label class="col-md-4 control-label">Voyage </label>
								<div class="col-md-5">{{onBoard.voyage}}</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label">Date </label>
								<div class="col-md-5">{{onBoard.onBoardDate}}</div>
							</div>
						</fieldset>
					</div>
				</div>

				<div class="panel-body">
						<div class="table-responsive"  id="Containerdetail">
							<div class="col-md-12" style="width: 130%;">

								<div class="row" id="items">
								<table class="table table-striped b-t b-light">
										<thead>
											<tr>
												<th colspan=1 class="width_1">Select</th>
								<th colspan=1 class="width_1 text-center">SL No</th>
								<th colspan=1 class="width_5 text-center">BL No</th>
								<th colspan=1 class="width_5 text-center">Booking No</th>
								<th colspan=1 class="width_5 text-center">Customer Name</th>
						<!-- 		<th colspan=1 class="width_10 text-center">Customer Type</th> -->
								<th colspan=1 class="width_5 text-center">Container Type</th>
								<th colspan=1 class="width_5 text-center">Container No</th>
								<th colspan=1 class="width_5 text-center">SOC</th>
								<th colspan=1 class="width_12 text-center">OnBoard Date</th>
								<th colspan=1 class="width_5 text-center">Slot Operator</th>
								<th colspan=1 class="width_5 text-center">Seal No</th>
								<th colspan=1 class="width_5 text-center">Package Type</th>
								<th colspan=1 class="width_5 text-center">No Of Pkgs</th>
								<th colspan=1 class="width_5 text-center">Pod</th>
									<th colspan=1 class="width_1 text-center">T/s Leg</th>
											</tr>
										</thead>
										<tbody ng-repeat="(trIndex,row) in onBoard.containerDtl">
											<tr>
												<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td style="text-align:center">{{row.slno}}</td>
								<td style="text-align:center">{{row.blNo}}</td>
								<td style="text-align:center">{{row.bookingNo}}</td>
								<td style="text-align:center">{{row.customerName}}</td>
								<!-- <td style="text-align:center">{{row.customerType}}</td> -->
								<td style="text-align:center">{{row.containerType}}</td>
								<td style="text-align:center">{{row.containerNo}}</td>
										<td class="text-center">
														<label class="i-checks"><input type="checkbox"
													name="soc" id="soc" ng-model="row.soc" disabled="true"><i></i></label>
												</td>
								<td style="text-align:center">
								
								<!-- <input type="text" class="form-control input-sm"
										name="onboardStatusDate" 
										property="row.onboardStatusDate" ng-model="row.onboardStatusDate"  disabled="disabled" />
								 -->
								 {{row.onboardStatusDate}}
								
								</td>
								<td style="text-align:center"><selectivity list="slotList" disabled="true" 
										property="row.slotOperator" id="slotOperator{{trIndex}}" ng-model="row.slotOperator"
										name="slotOperator{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(slotOperator)'}}" ></selectivity></td>
								<td style="text-align:center">{{row.sealNo}}</td>
								<td style="text-align:center">{{row.packgeType}}</td>
								<td style="text-align:center">{{row.noOfPkgs}}</td>
								<td style="text-align:center">{{row.pod}}</td>
								<td style="text-align:center">{{row.leg}}</td>
										</tbody>
									</table>
								</div>
								<br>



							</div>
						</div>
					</div>
					<div class="table-responsive" style="width: 29%;">
								<table class="table table-striped b-t b-light">
										<thead>
											<tr>
								<th colspan=1 class="width_1 text-center">Container Type</th>
								<th colspan=1 class="width_5 text-center">Count</th>
				
											</tr>
										</thead>
										<tbody ng-repeat="(trIndex,row) in onBoard.count">
											<tr>
								<td style="text-align:center">{{row.containerCount}}</td>
								<td style="text-align:center">{{row.containerTypeCount}}</td>

										</tbody>
									</table>
								<br>


							</div>
							<!-- <div class="col-md-12" style="padding-left: 47%;">
							<button class="btn btn-danger" type="reset"
								class="btn btn-success" ng-click="cancel()">
								<i class="fa fa-close"></i> Cancel
							</button>
							</div> -->
			

			</form>
		</div>
			
			
			
			
			</tab>


<!-- <tab heading="General Invoice" ng-if="isEdit" ng-click="checkBookinggeneralInv(BLnumber)">
<div class="panel-body">
			<form name="generalInvoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
						<input type="hidden" ng-model="generalinvoice.ExchangeRateFrom" id="ExchangeRateFrom" /> 
						<input type="hidden" ng-model="generalinvoice.ExchangeRateTo" id="ExchangeRateTo" /> 
						<input type="hidden" ng-model="generalinvoice.currencyValue" id="currencyValue" /> 
						<input type="hidden" ng-model="generalinvoice.fraction" id="fraction" />

					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Company</label>
									<div class="col-md-7">
										<input type="hidden" ng-model="generalinvoice.companyCode" id="txtCompany" ng-disabled="true" />
								 		<label class="form-label-control" ng-bind="generalinvoice.companyName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
	      							<label for="inputPassword" class="control-label col-md-5 bold">Invoice Date</label>
	    							<div class="col-md-7">
	   									<div class="input-group input-append date" id="invoice_date">								          
								          <label class="form-label-control" ng-bind="generalinvoice.invoiceDate"></label>
								        </div>   									
	    							</div>
			       				</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">BL Related</label>
									<div class="col-md-5">
										<input type="text" class="form-control input-sm" ng-if="generalinvoice.blRelated=='Y'" value="Yes" ng-disabled="true" />
										<input type="text" class="form-control input-sm" ng-if="generalinvoice.blRelated=='N'" value="No" ng-disabled="true" />
										
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Customer</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.customerName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Payer</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.mloName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4" id="blcheck">
								<div class="form-group">
									<label class="col-md-5 control-label bold">BL</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.bl"></label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Currency</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.currencyName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Exchange Rate</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.exchangeRate"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Subject</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.subject"></label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Vessel</label>
									<div class="col-md-7">
							 			<label class="form-label-control" ng-bind="generalinvoice.vesselName"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Voyage</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.voyage"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Service</label>
									<div class="col-md-7">
										<label class="form-label-control" ng-bind="generalinvoice.serviceName"></label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset ng-disabled="viewDisable">
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Units</label>
									<div class="col-md-7">
										<div class="row">
											<div class="col-md-6 custom-col-md-6 pull-left ">
												<label class="col-md-3 custom-col-md-3 control-label">20'</label>
												<label class="form-label-control" ng-bind="generalinvoice.unit20"></label>
											</div>
											<div class="col-md-6 custom-col-md-6 pull-left">
												<label class="col-md-3 custom-col-md-3 control-label">40'</label>
												<label class="form-label-control" ng-bind="generalinvoice.unit40"></label>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">POL</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.pol"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">POD</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.pod"></label>
									</div>
								</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">Quotation Number</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.QuotationNumber"></label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
							<div class="form-group">
							<label class="col-md-5 control-label bold">Attached Files</label>
							<div class="" ng-repeat="(tIndex, filelist) in generalinvoice.files">
							<a id="tbnewExport{{tIndex}}" style="display: none"
											href="{{filelist.filepath}}/{{filelist.filename}}"
											download="{{filelist.filename}}"></a>

											{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)" style="color:green">{{filelist.filename}}</a>
											<br>
							
							</div>
							</div>
							</div>
							
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label bold">FPOD</label>
									<div class="col-md-7">
								 		<label class="form-label-control" ng-bind="generalinvoice.fpod"></label>
									</div>
								</div>
							</div>
							
							
							   <div class="col-sm-4 col-md-4 col-lg-4">
							<div class="form-group">							
							<label class="control-label col-md-4 bold">File Upload </label>
								<div class="col-md-3">
								<div class="input-group">
								 <input type="file" class="form-control btn-primary" class="form-control input-sm" name="excelfile"
								  onchange="angular.element(this).scope().uploadFile(this)" />
								  
								  	<span class="input-group-btn ">
										<button class="btn btn-info input-sm" type="button"
											ng-click="adduploadfiles()" data-toggle="tooltip" title="Add File">
											<i class="fa fa-plus"></i>
										</button>
									</span>
									</div>
								</div>
							</div>
							</div>
				<div class="col-sm-4 col-md-4 col-lg-4">
						<div class="form-group" ng-repeat="(tIndex, filelist) in generalinvoice.fileuploadlist">
								<a id="tbnewExport{{tIndex}}" style="display: block"
											href="filePath/{{generalinvoice.invoiceNo}}/{{filelist.filename}}"
											download="{{filelist.filename}}"></a>
											<div ng-if="filelist.viewInvoiceHeader==''">
											{{tIndex+1}} ) <a ng-click="downloadNewFile(tIndex)" style="color:green" > {{filelist.filename}}</a>
											</div>
											
											<div ng-if="viewInvoiceHeader==''">
											{{tIndex+1}} ) <a style="color:green">{{filelist.filename}}</a>
											<button class="btn btn-default input-sm" type="button"
											ng-click="deleteuploadfiles(filelist.filename)" data-toggle="tooltip" title="Delete file">
											<i class="fa fa-trash"></i>
										</button>
											</div>
							
							</div>
							
							<button class="btn btn-success"type="button"  style="margin-left:180px;"  ng-if = "isuploadcheck"
							  ng-click="upload(generalinvoice.invoiceNo)" ><i class="fa fa-save"></i> Upload</button>
							
					</div>
						 
						</fieldset>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th colspan=1 class="width_2 text-center visible-left">Sl No</th>
								<th colspan=1 class="width_13 text-center">Account Head</th>								
								<th colspan=1 class="width_13 text-center">Sub Accout Code</th>
								<th colspan=1 class="width_13 text-center">Narration</th>
								<th colspan=1 class="width_10 text-center">TC Amount</th>
								<th colspan=1 class=" width_10 text-center">BC Amount({{companyCurrency}})</th>								
							</tr>
						</thead>
						
						<tbody ng-repeat="(trIndex, row) in generalinvoice.giDtl" ng-controller="GItableViewCtrl">
							<tr>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{$index}}"><i></i></label></td>
								<td class="visible-left"><label ng-model="row.slNo" id="slNo{{$index}}" ng-bind="row.slNo"></label></td>
								
								<td>
								 <input type="hidden"  id="txtSubGroupCode{{$index}}"  ng-model="row.accountHead" />
								 <label class="form-label-control" ng-bind="row.accountHeadName"></label>
								 </td>
								<td>
								 <input type="hidden" ng-model="row.subAccountCode" />
								  <label class="form-label-control" ng-bind="row.subAccountName"></label>
								 </td>
								<td>
									<label class="form-label-control" ng-bind="row.narration"></label>
								</td>
								
								<td>
									<label class="form-label-control" ng-bind="row.tcAmount"></label>
								</td>
								<td>
									<label class="form-label-control" ng-bind="row.bcAmount"></label>
								</td>
							</tr>
							 <tr>
						        	<td colspan="12">
							        	<div class="col-sm-12">
							        	<fieldset ng-disabled="viewDisable">
							        	Attributes list
							        	
							        	<div class="col-sm-2 padding-top-5" ng-if="row.isVoyage">
											<label class="col-md-5 control-label bold"> Voyage
												
											</label>
											<div class="col-md-7">
								 				<label class="form-label-control" ng-bind="row.voyageCode"></label>
										     </div>
										</div>
							        	<div class="col-sm-2 padding-top-5" ng-if="row.isVessel">
											<label class="col-md-5 control-label bold"> Vessel
												
											</label>
											<div class="col-md-7">
								 				<label class="form-label-control" ng-bind="row.vesselName"></label>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isService">
											<label class="col-md-5 control-label bold"> Service
											</label>
											<div class="col-md-7">
								 				<label class="form-label-control" ng-bind="row.sectorName"></label>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isEmployee">
											<label class="col-md-5 control-label bold"> Employee
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="employeeCode{{trIndex}}" ng-model="row.employeeCode" ng-options="emp.id as emp.text for emp in employeeList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isPort">
											<label class="col-md-5 control-label bold"> Port
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="portCode{{trIndex}}" ng-model="row.portCode" ng-options="port.id as port.text for port in portList">
								 				</select>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isPortSequence">
											<label class="col-md-5 control-label bold"> Port.Seq
												
											</label>
											<div class="col-md-7">
										          <input type="text" class="form-control input-sm"  id="PortSequence{{trIndex}}" ng-model="row.portSequence" name="PortSequence"/>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isDepartment">
											<label class="col-md-5 control-label bold"> Department
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="departmentCode{{trIndex}}" ng-model="row.departmentCode" ng-options="dep.id as dep.text for dep in departmentList">
								 				</select>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isAgent">
											<label class="col-md-5 control-label bold"> Agent
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="agentCode{{trIndex}}" ng-model="row.agentCode" ng-options="agent.id as agent.text for agent in agentList">
								 				</select>
										     </div>
										</div>
										
										<div class="col-sm-2 padding-top-5" ng-if="row.isLocation">
											<label class="col-md-5 control-label bold"> Location
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="countryCode{{trIndex}}" ng-model="row.countryCode" ng-options="country.id as country.text for country in countryList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCustomer">
											<label class="col-md-5 control-label bold"> Customer
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="customerCode{{trIndex}}" ng-model="row.customerCode" ng-options="cus.id as cus.text for cus in customerList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isSupplier">
											<label class="col-md-5 control-label bold"> Supplier
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="supplierCode{{trIndex}}" ng-model="row.supplierCode" ng-options="sup.id as sup.text for sup in supplierList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isDesignation">
											<label class="col-md-5 control-label bold"> Designation
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="designationCode{{trIndex}}" ng-model="row.designationCode" ng-options="desig.id as desig.text for desig in designationList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCostCenter">
											<label class="col-md-5 control-label bold"> CostCtr
												
											</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="CostCenter{{trIndex}}" ng-model="row.costCenter" name="CostCenter"/>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isCompany">
											<label class="col-md-5 control-label bold"> Company
												
											</label>
											<div class="col-md-7">
										        <select class="form-control input-sm" id="companyCode{{trIndex}}" ng-model="row.companyCode" ng-options="company.id as company.text for company in companyList">
								 				</select>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityGO">
											<label class="col-md-5 control-label bold">Qty(MT)GO</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="QuantityGO{{trIndex}}" ng-model="row.quantityGO" name="QuantityGO"/>
										     </div>
										</div>
										<div class="col-sm-2 padding-top-5" ng-if="row.isQuantityFO">
											<label class="col-md-5 control-label bold">Qty(MT)FO</label>
											<div class="col-md-7">
										             <input type="text" class="form-control input-sm"  id="QuantityFO{{trIndex}}" ng-model="row.quantityFO" name="QuantityFO"/>
										     </div>
										</div>
										</fieldset>
										</div>
								    </td> 		             	
						       </tr>
						<tr ng-if="generalinvoice.companyCode=='C0001'">
								<td><label class="i-checks m-b-none">  </td>
								<td class="visible-left"><label ng-model="row.slNo" id="slNo{{$index}}" ng-bind="row.slNo"></label></td>
								
								<td colspan=2><b>VAT ACCOUNT:</b>
 								 <label class="form-label-control" ng-bind="row.vatAccount"></label>
								 </td>
								<td >
								<b> VAT TYPE:</b>
								  <label class="form-label-control" ng-bind="row.vattype"></label>
								 </td>
								 
								
								<td><b> VAT TC AMOUNT:</b>
									<label class="form-label-control" ng-bind="row.vattcamount"></label>
								</td>
								<td><b> VAT BC AMOUNT:</b>
									<label class="form-label-control" ng-bind="row.vatbcamount"></label>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="padding-right-5">
						<div class="col-md-12">
						<fieldset ng-disabled="viewDisable">
							<div class="form-group">
								<label class="col-md-2 col-md-offset-6 control-label">Total</label>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm"
										id="TxtTotalTcAmt" name="totalTcAmt"
										ng-model="generalinvoice.TotalTCamount" readonly>
								</div>
								<div class="col-md-2">
									<input type="text" class="form-control input-sm"
										id="TxtTotalBcAmt" name="totalBcAmt"
										ng-model="generalinvoice.TotalBCamount" readonly>
								</div>
							</div>
						</fieldset>
						</div>
					</div>
				</div>

				
				sub table Ends
			</form>
		</div>
</tab> -->
<tab heading="Freight Invoice" ng-if="isEdit" ng-click="checkBookingFreightInv(BLnumber)">
		<div class="panel-body">
			<form name="invoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Invoice No.</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label"><b>{{invoiceData.invoiceNo}}</b></label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Bl No.</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{invoiceData.blNo}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Bill
										Date </label>
									<div class="col-md-7">
										<!-- <ng-bs3-datepicker data-ng-model="invoiceData.billDate"
											id="billDate" name="billDate" form-name="invoiceForm"
											disabled friendly-name="Bill Date" /> -->
												<label class="col-md-5 control-label">{{invoiceData.billDate}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.customerName}}</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.vesselName}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.voyageName}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking No. </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.bookingNo}}</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation No.</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.quotation}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Exchange Rate</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.exchangeRate}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Currency </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.currency}}</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Agent Name</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.agentName}}</label>
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
									Charges</th>
							</tr>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th colspan=1 class="width_13 text-center">Container No.</th>
								<th colspan=1 class="width_13 text-center">Container Type</th>
								<th colspan=1 class="width_13 text-center">Type Of Charge</th>
								<th colspan=1 class="width_10 text-center">Quantity</th>
								<th colspan=1 class="width_10 text-center">Rate</th>
								<th colspan=1 class="width_10 text-center">Amount</th>
								<th colspan=1 class="width_10 text-center">Amount TC</th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in invoiceData.chargesDetails track by trIndex">
							<tr>
								<td></td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.containerNo}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.containerTypeName}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.chargeTypeName}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.quantity}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.rate}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.amount}}</label>
										</div>
									</div>
								</td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<label class="control-label">{{row1.tcAmount}}</label>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<!-- /padding-right-5 - /AddOrRmvebtn -->
				</div>
				<div class="col-sm-12">
					<fieldset>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"> </label>
								<div class="col-md-7"></div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5">Total
								</label>
								<div class="col-md-7">
									<label class="control-label">{{invoiceData.total}}</label>
									<!-- 									<input type="text" class="form-control input-sm text-right" -->
									<!-- 										data-ng-model="invoiceData.total" id="total" name="total" -->
									<!-- 										disabled /> -->
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Grand Total </label>
								<div class="col-md-7">
									<label class="control-label">{{invoiceData.grandTotal}}</label>
									<!-- 									<input type="text" class="form-control input-sm text-right" -->
									<!-- 										ng-model="invoiceData.grandTotal" disabled name=" grandTotal" -->
									<!-- 										id="grandTotal" /> -->
								</div>
							</div>
						</div>
					</fieldset>
				</div>
				<!-- sub table Ends -->
			</form>
		</div>

</tab>
 <!-- <tab heading="Provisional Invoice" ng-if="isEdit" ng-click="checkBookingFreightInv(BLnumber)"> 

		<div class="panel-body">
			<form name="invoiceForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
										<input type="hidden" ng-model="invoiceData.ExchangeRateFrom"
											id="ExchangeRateFrom" /> <input type="hidden"
											ng-model="invoiceData.ExchangeRateTo" id="ExchangeRateTo" /> <input
											type="hidden" ng-model="invoiceData.currencyValue"
											id="currencyValue" /> <input type="hidden"
											ng-model="invoiceData.fraction" id="fraction" />


					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Invoice No.</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label"><b>{{invoiceData.invoiceNo}}</b></label>
									</div>
								</div>
							</div>

						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Bl No.</label>
									<div class="col-md-7">
										<label class="col-md-5 control-label">{{invoiceData.blNo}}</label>
																				<selectivity list="pendingBlList" property="invoiceData.blNo"
																					id="blNo" name="blNo" ng-model="invoiceData.blNo"
																					validation="required" friendly-name="BL No."
																					form-name="invoiceForm"></selectivity>
									</div>
								</div>
							</div>


							<div class="col-md-4">
								<div class="form-group">
									<label for="inputPassword" class="control-label col-md-5">Bill
										Date </label>
									<div class="col-md-7">
										<ng-bs3-datepicker data-ng-model="invoiceData.billDate"
											id="billDate" name="billDate" form-name="invoiceForm"
											disabled friendly-name="Bill Date" />

									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Customer </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.customerName}}</label>
																				<input type="text" class="form-control "
																					ng-model="invoiceData.customerName" disabled
																					name=" customerType" id="customerType"
																					friendly-name="Customer"   />
									</div>
								</div>
							</div>


						</fieldset>
					</div>


					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.vesselName}}</label>
																				<input type="text" class="form-control input-sm text-right"
																					ng-model="invoiceData.vesselName" disabled name=" Vessel"
																					id="Vessel" friendly-name="Vessel"   />
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.voyageName}}</label>
																				<input type="text" class="form-control input-sm text-right"
																					ng-model="invoiceData.voyageName" disabled name=" Voyage"
																					id="Voyage" friendly-name="Voyage"  />
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Booking No. </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.bookingNo}}</label>
																				<input type="text" class="form-control input-sm text-right"
																					ng-model="invoiceData.bookingNo" disabled name=" bookingNo"
																					id="bookingNo" friendly-name="bookingNo" />
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Quotation No.</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.quotation}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Exchange Rate</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.exchangeRate}}</label>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Currency </label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.currency}}</label>
									</div>
								</div>
							</div>
						</fieldset>
					</div>
					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<div class="form-group">
									<label class="col-md-5 control-label">Agent Name</label>
									<div class="col-md-7">
										<label class="control-label">{{invoiceData.agentName}}</label>
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
									Charges</th>
							</tr>
							<tr>
								<th colspan=1 class="width_1"></th>
								<th colspan=1 class="width_10">Related To</th>
								<th colspan=1 class="width_13 text-center">Container No.</th>
								<th colspan=1 class="width_13 text-center">Type Of Charge</th>
								<th colspan=1 class="width_10 text-center">Quantity</th>
								<th colspan=1 class="width_10 text-center">Rate</th>
								<th colspan=1 class="width_10 text-center">Amount</th>
								<th colspan=1 class="width_10 text-center">Amount TC</th>
							</tr>
						</thead>
						<tbody
							ng-repeat="(trIndex, row1) in invoiceData.chargesDetails track by trIndex">
							<tr>
								<td></td>
								<td class="text-center">
									<div class="row">
										<div class="col-xs-12">
											<selectivity list="relatedToList" property="row1.relatedTo"
												id="relatedTo{{trIndex}}" ng-model="row1.relatedTo"
												name="realtedTo{{trIndex}}" disabled="true"
												friendly-name="{{ 'Row' + trIndex + '(Related To)'}}"
												form-name="provisionalInvoiceForm"></selectivity>
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="containerNo{{trIndex}}" disabled=disabled
												ng-model="row1.containerNo" name="containerNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(No Of Box)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="noOfBoxBx{{trIndex}}" disabled
												ng-model="row1.chargeTypeName" name="crgname{{trIndex}}"
												validation="required"
												friendly-name="{{ 'Row' + $index + '(No Of Box)'}}" />
										</div>
									</div>
								</td>

								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="quantity{{trIndex}}" ng-model="row1.quantity"
												name="quantity{{trIndex}}" validation="required" disabled
												friendly-name="{{ 'Row' + $index + '(quantity)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="rate{{trIndex}}" disabled ng-model="row1.rate"
												name="rate{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(Rate)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="amount{{trIndex}}" disabled ng-model="row1.amount"
												name="amount{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(Amount)'}}" />
										</div>
									</div>
								</td>
								<td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm"
												id="tcAmount{{trIndex}}" disabled ng-model="row1.tcAmount"
												name="tcAmount{{trIndex}}" validation="required"
												friendly-name="{{ 'Row' + $index + '(TC Amount)'}}" />
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					/padding-right-5 - /AddOrRmvebtn
				</div>
				<div class="col-sm-12">
					<fieldset>

						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label"> </label>
								<div class="col-md-7"></div>
							</div>
						</div>


						<div class="col-md-4">
							<div class="form-group">
								<label for="inputPassword" class="control-label col-md-5">Total
								</label>
								<div class="col-md-7">
									<label class="control-label">{{invoiceData.total}}</label>
																		<input type="text" class="form-control input-sm text-right"
																			data-ng-model="invoiceData.total" id="total" name="total"
																			disabled />

								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="col-md-5 control-label">Grand Total </label>
								<div class="col-md-7">
									<label class="control-label">{{invoiceData.grandTotal}}</label>
																		<input type="text" class="form-control input-sm text-right"
																			ng-model="invoiceData.grandTotal" disabled name=" grandTotal"
																			id="grandTotal" />
								</div>
							</div>
						</div>


					</fieldset>
				</div>
				sub table Ends
			</form>
		</div>

</tab> -->
<tab heading="Discharge" ng-if="isEdit" ng-click="checkDischarge(voyage,portfromonboard)">
		<div class="panel-body">
			<form name="vessselArrivalForm" class="form-horizontal">
				<div class="row">


					<div class="col-sm-12">
						<fieldset>
							<div class="col-md-4">
								<!-- vessel -->
								<div class="form-group">
									<label class="col-md-5 control-label">Vessel</label>
									<div class="col-md-7">
									<label class="control-label" align="left" >{{discharge.vessel}}
								</label>
									
									</div>
								</div>
								
							</div>

							<div class="col-md-4">
								<!-- voyage -->
								<div class="form-group">
									<label class="col-md-5 control-label">Voyage</label>
									<div class="col-md-7">
											<label class="control-label" align="left" >{{discharge.voyage}}
								</label>
										
									</div>
								</div>
							</div>


							<div class="col-md-4">
								<!-- port -->
								<div class="form-group">
									<label class="col-md-5 control-label">Port</label>
									<div class="col-md-7">
										<label class="control-label" align="left" >{{discharge.port}}
								</label>
									<!-- 	<selectivity list="portList" ng-model="discharge.port"
											validation="required" friendly-name="port"
											property="discharge.port" id="port" name="port"  disabled="isEdit"
											form-name="vessselArrivalForm"></selectivity> -->
									</div>
								</div>
							</div>

						</fieldset>
					</div>

					<div class="col-sm-12">
						<fieldset>

							<div class="col-md-4">
								<!-- terminal -->
								<div class="form-group">
									<label class="col-md-5 control-label">Terminal Name</label>
									<div class="col-md-7">
									<label class="control-label" align="left" >{{discharge.terminal}}
								</label>
									<!-- 	<selectivity list="terminalList" ng-model="discharge.terminal"
											validation="required" friendly-name="Terminal"
											property="discharge.terminal" id="terminal" name="terminal"  disabled="isEdit"
											form-name="vessselArrivalForm"></selectivity> -->
									</div>
								</div>
							</div>



							<div class="col-md-4">
								<!-- Arrival date -->
								<div class="form-group">
									<label class="col-md-5 control-label">Arrival Date</label>
									<div class="col-md-7">
										<div class="input-group  input-append date">
											<label class="control-label" align="left" >{{discharge.arrivalDate}}
								</label>
										<!-- <input type="text" class="form-control input-sm"
												id="arrivalDate" name="arrivalDate"
												ng-model="discharge.arrivalDate" validation="required"  disabled="disabled"
												friendly-name="arrivalDate" /> <span
												class="input-group-addon add-on"><span
												form-name="vessselArrivalForm" class="glyphicon glyphicon-calendar"></span></span> -->
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<!-- Discharge Date -->
								<div class="form-group">
									<label class="col-md-5 control-label">Discharge Date</label>
									<div class="col-md-7">
										<div class="input-group  input-append date">
											<label class="control-label" align="left" >{{discharge.dischargeDate}}
								</label>
										<!-- 	<input type="text" class="form-control input-sm"
												id="dischargeDate" name="dischargeDate" 
											ng-model="discharge.dischargeDate" validation="required"  
												friendly-name="dischargeDate" ng-disabled="isEdit"/> <span
												class="input-group-addon add-on"><span
												form-name="vessselArrivalForm" class="glyphicon glyphicon-calendar"></span></span> -->
										</div>
									</div>
								</div>
							</div>
						</fieldset>
					</div>


				</div>
				<!-- <div class="form-actions">
					<div class="row">
						<div class="col-md-12 ">
							<button class="btn btn-success" ng-click="viewDetail()">
								<i class="fa fa-eye	"> </i>Show
							</button>

							<button class="btn btn-primary" ng-click="print(rowCollection)">
								<i class=""> </i> Arrival Notice
							</button>
							<button class="btn btn-primary" ng-click="manifest()">
								<i class=""> </i> Manifest
							</button>
						</div>
					</div>
				</div> -->
				<br>
				<div class="breadcrumb-wrapper ng-scope">

					<div class="table-responsive" style="border: 1px solid #CCC;">
						<div class="panel panel-default panel-default-list"
							st-table="displayedCollection" st-safe-src="rowCollectionView">
							<div class="panel-body float-left padding-0" style="width: 100%;">
								<div class="table-responsive">
									<br>
									<h3 style="margin-left: 5px;">Discharge Container Detail</h3>
									<table id="dt_basic"
										class="table table-striped table-bordered table-hover dataTable no-footer"
										role="grid" aria-describedby="dt_basic_info">
										<thead class="dataTables-Main-Head">
											<tr role="row">
												<!-- <th class="width_1"><input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"></th> -->
									<!-- <th class="width_1 text-center"><label
								  		class="i-checks m-b-none"></label> </th> -->
								  		<th class="sorting width_3">SL No</th>
												<th class="sorting width_6">Booking No</th>
												<th class="sorting width_6">B/L No</th>
												<th class="sorting width_8">Customer</th>
												<th class="sorting width_8">Container Number</th>
												<th class="sorting width_8">Discharge Date</th>
												<th class="sorting width_7">Container Type</th>
												 <th class="sorting width_4">SOC</th>
												<th class="width_5 text-center">Is Transit<label
								  					class="i-checks m-b-none"></label> </th>
												
												<!-- 			<th class="sorting width_5">Is Transit</th>
												<th class="width_5" ng-if="isEdit">Action</th>
 -->

											</tr>
										</thead>

										<tbody class="dataTables-Main-Body">
											<tr data-ng-class="$index % 2 == 0? 'even' : 'odd'"
												ng-repeat="(trIndex, listitems) in displayedCollection">
												<!-- <td class="width_1 text-center"><label
													class="i-checks m-b-none"> <input type="checkbox"
														ng-disabled="listitems.disabled" name="selectedTypes[]"
														ng-model="listitems.select1"> <i></i>
												</label></td> -->

                                        		 <td style="background-color: lightsalmon" class="sorting" data-toggle="tooltip">{{$index+1}}</td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.bookingNum}}" class="tool-tip-span"
													ng-bind="listitems.bookingNum"></span></td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.blNumber}}" class="tool-tip-span"
													ng-bind="listitems.blNumber"></span></td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.customerName}}" class="tool-tip-span"
													ng-bind="listitems.customerName"></span></td>

												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.containerNumber}}"
													class="tool-tip-span" ng-bind="listitems.containerNumber"></span>
												</td>
												<td style="background-color: lightsalmon">
												<input type="text" class="form-control input-sm"
										name="dischargeStatusDate" 
										property="listitems.dischargeStatusDate" ng-model="listitems.dischargeStatusDate"  disabled="disabled" />
												<!-- <div class="input-group  input-append date"  ng-disabled="isEdit">
										<bootstrapdatetimepicker  	property="listitems.dischargeStatusDate" id="dischargeStatusDate"
										name="dischargeStatusDate"  ng-model="listitems.dischargeStatusDate"  friendly-name="dischargeStatusDate"
										form-name="vessselArrivalForm"  ng-disabled="isEdit" />
										</div> --></td>
												<td style="background-color: lightsalmon"><span
													tooltip="{{listitems.containerType}}" class="tool-tip-span"
													ng-bind="listitems.containerType"></span></td>
													<td style="background-color: lightsalmon"><input
													type="checkbox" class="checkbox style-0" name="soc"
													ng-model="listitems.soc"  disabled="true">
												</td>
												<td style="background-color: lightsalmon"><input disabled
													type="checkbox" class="checkbox style-0" name="isTransit"
													ng-model="listitems.isTransit"  >
												</td>
												
												
<!-- 												<td style="background-color: lightsalmon" ng-if="isEdit">
 -->												<!-- 	<button ng-click="removeRow(listitems)"
														class="btn btn-sm btn-danger" type="button" tooltip="Undo">
														<i class="fa fa-undo"></i>
													</button> -->
													
												<!-- 	<button ng-click="deleteRow(listitems.dischargeDtlId)"
														class="btn btn-sm btn-danger" type="button" tooltip="Delete">
														<i class="fa fa-trash-o "></i>
													</button> -->
													
						
									
				<!-- 
												</td> -->

										</tbody>
									</table>

								</div>

							</div>
						</div>

					</div>
				</div>





				

			</form>

		</div>



</tab>
<tab heading="Delivery Order" ng-if="isEdit" ng-click="checkdeliveryOrder(BLnumber)">
		<div class="panel-body">
			<form name="deliveryorderForm" class="form-horizontal" novalidate>
				<div class="row">
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> DO Number </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"
										name="doNumber" id="doNumber"
										ng-model="deliveryorder.doNumber"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
							<label class="control-label">{{deliveryorder.doNumber}}</label>
									<label hidden="true">{{deliveryOrderNum}}</label>	
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Vessel <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
							<!-- 		<selectivity list="vesselList" property="deliveryorder.vessel"
										id="vessel" ng-model="deliveryorder.vessel" name="vessel"
										validation="required" friendly-name="Vessel" disabled="isEdit"
										form-name="deliveryorderForm"></selectivity> -->
										<label class="control-label">{{deliveryorder.vessel}}</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Shipping Agent </label>
								<div class="col-md-5">
									<!-- <selectivity list="agentList"
										property="deliveryorder.shippingAgent" id="shippingAgent"
										ng-model="deliveryorder.shippingAgent" name="shippingAgent"
										form-name="deliveryorderForm" ></selectivity> -->
									<label class="control-label">{{deliveryorder.shippingAgent}}</label>
							
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Arrival Date </label>
								<div class="col-md-5">
									<!-- <ng-bs3-datepicker data-ng-model="deliveryorder.arrivalDate"
										id="arrivalDate" name="arrivalDate"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
								<label class="control-label">{{deliveryorder.arrivalDate}}</label>
							
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Total Weight(Kgs)
								</label>
								<div class="col-md-5">
							<!-- 		<input type="text" class="form-control input-sm" name="totWt"
										id="totWt" ng-model="deliveryorder.totWt"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
									<label class="control-label">{{deliveryorder.totWt}}</label>	
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Goods Description
								</label>
								<div class="col-md-5">
									<!-- <textarea type="text" class="form-control input-sm"
										name="goods" form-name="deliveryorderForm"
										class="custom-scroll width_250 resize-none" rows="3"
										ng-model="deliveryorder.goods" ng-disabled="true">
									</textarea> -->
									<label class="control-label">{{deliveryorder.goods}}</label>	
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

						</fieldset>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-4">
						<fieldset>
							<div class="form-group">
								<label class="col-md-4 control-label"> Date </label>
								<div class="col-md-5">
									<!-- <ng-bs3-datepicker data-ng-model="deliveryorder.currenctDate"
										id="currenctDate" name="currenctDate"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
										<label class="control-label">{{deliveryorder.currenctDate}}</label>	
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Voyage <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
								<!-- 	<selectivity list="voyageList" property="deliveryorder.voyage"
										id="voyage" ng-model="deliveryorder.voyage" name="voyage"
										validation="required" friendly-name="Voyage" disabled="isEdit"
										form-name="deliveryorderForm"></selectivity> -->
											<label class="control-label">{{deliveryorder.voyage}}</label>			
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Clearance Port </label>
								<div class="col-md-5">
									<!-- <selectivity list="fpodList"
										property="deliveryorder.clearencePort" id="clearencePort"
										ng-model="deliveryorder.clearencePort" name="clearencePort"
										form-name="deliveryorderForm" disabled="true"></selectivity> -->
									<label class="control-label">{{deliveryorder.clearencePort}}</label>			
							
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label"> Consignee </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"
										name="consignee" id="consignee"
										ng-model="deliveryorder.consignee"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
									<label class="control-label">{{deliveryorder.consignee}}</label>			
								
										
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Total Quantity </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm" name="totQty"
										id="totQty" ng-model="deliveryorder.totQty"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
								<label class="control-label">{{deliveryorder.totQty}}</label>			
								
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label"> Weight </label>
								<div class="col-md-5">
								<!-- 	<input type="text" class="form-control input-sm" name="weigth"
										id="weigth" ng-model="deliveryorder.weigth"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
								<label class="control-label">{{deliveryorder.weigth}}</label>			
								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> Remarks </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm" name="remarks"
										id="remarks" ng-model="deliveryorder.remarks"
										form-name="deliveryorderForm" ng-disabled="true" /> -->
								<label class="control-label">{{deliveryorder.remarks}}</label>			
								
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
							<div class="form-group">
								<label class="col-md-4 control-label"> Agent DO </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm" name="agentdo"
										id="agentdo" ng-model="deliveryorder.agentdo"
										form-name="deliveryorderForm" /> -->
								<label class="control-label">{{deliveryorder.agentdo}}</label>			
								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> BL No. <span
									style="color: red;">*</span></label>
								<div class="col-md-5">
									<!-- <selectivity list="blnoList" property="deliveryorder.blNo"
										id="blNo" ng-model="deliveryorder.blNo" name="blNo"
										validation="required" friendly-name="Bl NO" disabled="isEdit"
										form-name="deliveryorderForm"></selectivity> -->
								<label class="control-label">{{deliveryorder.blNo}}</label>			
								
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"> Discharge Port
									(FPOD)</label>
								<div class="col-md-5">
									<!-- <selectivity list="fpodList"
										property="deliveryorder.dischargePort" id="dischargePort"
										ng-model="deliveryorder.dischargePort" name="dischargePort"
										form-name="deliveryorderForm" disabled="true"></selectivity> -->
								<label class="control-label">{{deliveryorder.dischargePort}}</label>			
								
								</div>
							</div>






							<div class="form-group">
								<label class="col-md-4 control-label"> Packages Type </label>
								<div class="col-md-5">
									<!-- <input type="text" class="form-control input-sm"
										name="packageType" id="packageType"
										ng-model="deliveryorder.packageType"
										form-name="deliveryorderForm" /> -->
											<label class="control-label">{{deliveryorder.packageType}}</label>	
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label"> DO To </label>
								<div class="col-md-5">
									<!-- <selectivity list="donamesList" property="deliveryorder.doto"
										id="doto" ng-model="deliveryorder.doto" name="doto"
										form-name="deliveryorderForm"></selectivity> -->
								<label class="control-label">{{deliveryorder.doto}}</label>			
								
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label"> DO Address </label>
								<div class="col-md-5">
								<!-- 	<textarea type="text" class="form-control input-sm"
										name="doAddress" form-name="deliveryorderForm"
										class="custom-scroll width_250 resize-none" rows="3"
										ng-model="deliveryorder.doAddress">
									</textarea> -->
								<label class="control-label">{{deliveryorder.doAddress}}</label>			
							
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
								<th colspan=1 class="width_10 text-center">Containers</th>
								<th colspan=1 class="width_10 text-center">Type</th>
								<th colspan=1 class="width_5 text-center">SOC</th>
								<th colspan=1 class="width_10 text-center">Seal No</th>
								<th colspan=1 class="width_10 text-center">TW</th>
								<th colspan=1 class="width_10 text-center">GW</th>
								<th colspan=1 class="width_10 text-center">Net</th>

							</tr>
						</thead>
						<tbody ng-repeat="(trIndex,row) in deliveryorder.deliverDtl">
							<tr>
								<td class="width_10">
									<div class="row">
										<div class="col-xs-12">
										<!-- 	<selectivity list="containerList" property="row.container"
												id="container_id" data-ng-model="row.container" disabled="isEdit"
												name="container{{trIndex}}" form-name="deliveryorderForm"></selectivity>
										 -->
										 <label class="control-label">{{row.container}}</label>			
							
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
								<div class="row" style=" padding-left: 36px;">
										<div class="col-xs-12">
														<label class="i-checks"><input type="checkbox"
													name="soc" id="soc" ng-model="row.soc" disabled="true"><i></i></label>
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
										<!-- 	<input type="text" class="form-control input-sm"
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







							</tr>
						</tbody>
						<!-- <tbody ng-repeat="(trIndex, row) in cbptable.cbpTblRow"> -->

					</table>

					<br> <br> <br>


				</div>


				<!-- <div class="form-actions">
					<div class="row">
						<div class="col-md-12">
							<button class="btn btn-success" type="button" ng-if="!isEdit"
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
				</div> -->




			</form>
		</div>

</tab>
			<tab heading="GATE In & Out " ng-if="isEdit" ng-click="checkBookingGateDO()">
			<tabset>
			<tab  heading="GATE Out " ng-if="isEdit" ng-click="checkBookingGateOutDO()">
					<div class="panel-body">
			<form name="quotationForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
						
						<div class="form-group" ng-if="!edit">
								<label class="col-md-5 control-label">Gate Out No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.gateOutNo1}}
								</label>
								
								</div>
							</div>
							
							
							<div class="form-group" ng-if="edit">
								<label class="col-md-5 control-label">Gate Out No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.gateOutNo}}
								</label>
								
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Type<span
									style="color: red">*</span></label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.type}}
								</label>
								
								</div>
							</div>

							<div class="form-group" ng-if="quotation.type=='Export'">
								<label class="col-md-5 control-label">C.R.O. No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.croNo}}
								</label>
							
								</div>
							</div>
							
								<div class="form-group" ng-if="quotation.type=='Import'">
								<label class="col-md-5 control-label">D.O. No<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<label class="control-label" align="left" >{{quotation.doNo}}
								</label>
							
								</div>
							</div>
							

						</fieldset>
					</div>
						

					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<div class="form-group ">
								<label class="col-md-5 control-label">Customer<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<label class="control-label" align="left" >{{quotation.customername}}
								</label>
							
								</div>
							</div>
							<div class="form-group ">
								<label class="col-md-5 control-label">Depot<span
									style="color: red">*</span></label>
								<div class="col-md-7">
										<label class="control-label" align="left" >{{quotation.depot}}
								</label>
								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Booking No<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.bookingNo}}								</label>
					
								</div>
							</div>
							



						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							<!-- third column -->
							
								<div class="form-group " ng-if="quotation.type=='Export'">
								<label class="col-md-5 control-label">CRO Count<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.countTotal}}
								</label>
				
								</div>
							</div>
							
							<div class="form-group ">
								<label class="col-md-5 control-label">Gate Out Date<span
									style="color: red">*</span></label>
								<div class="col-md-7">
								<div class="input-group  input-append date">
									<label class="control-label" align="left" >{{quotation.releaseDate}}
								</label>
									
										</div>
								
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-5 control-label">Truck No<span
									style="color: red"></span></label>
								<div class="col-md-7">
									<label class="control-label" align="left" >{{quotation.truckNo}}
								</label>
							
								</div>
							</div>

							


						</fieldset>
					</div>


				</div>
					<br>
			

				<br>
				<div class="row">
					<table class="table table-striped b-t b-light" style="width: 100%;">
				
						<tr style="background-color: #dae8f6;">
						<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_1 text-center"></th>
							<th colspan=1 class="width_9 text-center">Container Type<span
								style="color: red">*</span></th>
							<th colspan=1 class=" width_9 text-center">Container No<span
								style="color: red">*</span></th>
								<!-- <th colspan=1 class=" width_9 text-center">Seal No</th> -->
							 <th colspan=1 class="width_9 text-center"></th>

						</tr>
						<tbody ng-repeat="(trIndex, row) in quotation.quotationDtl"
							ng-controller="quotationtableCtrl">
							<tr >
							<td class=" width_1"></td>
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}" disabled="true">
										<i></i>
								</label></td>
							  <td style="text-align:center">{{row.conType}}</td>
								
				 <!--  <td style="text-align:center">{{row.containerNo}}</td> -->
				  
				  
						 	<td class=" width_9"><!-- <selectivity list="conNoList"
										property="row.containerNo" id="containerNo{{trIndex}}"
										ng-model="row.containerNo" validation="required"
										name="containerNo{{trIndex}}"
										friendly-name="{{ 'Row' + ($index+1) + '(containerNo)'}}"
										form-name="quotationForm" disabled="true"></selectivity> -->
												<label class="control-label" align="left" >{{row.containerNo}}
							
										</td>  
										
											<!-- <td class=" width_9">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
											     property="row.sealNo" id="sealNo{{trIndex}}"
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}"  form-name="quotationForm"/>
										</div>
									</div>
								</td> -->
									
									
								<td class=" width_9"></td>
								</tr>

							<!-- detail -->

							

						</tbody>
					</table>

				<!-- 	<button ng-click="addRow()" class="btn btn-sm btn-info"
						ng-disabled="subForm.$invalid" type="button">
						<i class="fa fa-plus"></i>
					</button> -->
				<!-- 	<button ng-click="removeRow()" class="btn btn-sm btn-danger"
						ng-disabled="userForm{{$index}}.$invalid" type="button">
						<i class="fa  fa-trash-o"></i>
					</button> -->
				</div>

                 	

				<!-- detail -->

				
			</form>
		</div>
			
			
			
			</tab>
				
				<tab  heading="GATE In " ng-if="isEdit" ng-click="checkBookingGateInDO()">
						<div class="panel-body">
			<form name="gateInForm" class="form-horizontal" novalidate>
				<div class="row book-widget-row">
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
							
								<div class="form-group" hidden=true>
									<label class="col-md-5 control-label">Service</label>

									<div class="col-md-7">
										<div class="radio radio-inline" >
											<label class="i-checks"> <input type="radio"
												class="radiobox style-0"   name="service"
												ng_model="gateIn.service" value="COC"
												checked="checked"> <i></i> COC
											</label>
										</div>
										<div class="radio  radio-inline">
											<label class="i-checks"> <input type="radio"
												class="radiobox style-0" ng_model="gateIn.service"
												value="SOC"   name="service"> <i></i>
											SOC
											</label>
										</div>
				
									</div>
								</div>
						
						
						<div class="form-group "  ng-if="gateIn.service=='COC'">
                 <label class="col-md-5 control-label">Type<span
                 style="color: red">*</span></label>
                  <div class="col-md-7">
                    <!--  <selectivity list="typeList"
                           property="gateIn.type" id="type" name="type"
                        ng-model="gateIn.type" object="type"
                     friendly-name="type" validation="required"
                    form-name="gateInForm" value="true"></selectivity> -->
                   <label class="control-label" align="left" >{{gateIn.type}}</label>
                    
                   </div>
             </div>


						
							<div class="form-group" ng-if="!isEdit">
								<label class="col-md-5 control-label">Gate IN No<span
									style="color: red">*</span></label>
						 	<div class="col-md-7">
									<!--	<input type="text"
									class="form-control input-sm text-left" name="gateInNoMaxCnt"
									property="gateIn.gateInNoMaxCnt" id="gateInNoMaxCnt"
									ng-model="gateIn.gateInNoMaxCnt"
									friendly-name="gateInNoMaxCnt" disabled="true" /> -->
									   <label class="control-label" align="left" >{{gateIn.gateInNoMaxCnt}}</label>
								</div>
							</div>
							
							<div class="form-group" ng-if="isEdit">
								<label class="col-md-5 control-label">Gate IN No<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
								<!-- 	<input type="text"
									class="form-control input-sm text-left" name="gateInNo"
									property="gateIn.gateInNo" id="gateInNo"
									ng-model="gateIn.gateInNo"
									friendly-name="gateInNo" disabled="true" /> -->
							  <label class="control-label" align="left" >{{gateIn.gateInNo}}</label>		
									
								</div>
								
								
							</div>
						
				       		<div class="form-group"  ng-if="gateIn.service=='SOC'">
								<label class="col-md-5 control-label" >Booking No<span
									style="color: red;">*</span>
								</label>
		                     <div class="col-md-7">
									<!-- <selectivity list="bookingNoList"
										property="gateIn.bookingNo" id="bookingNo"
										ng-model="gateIn.bookingNo" name="bookingNo"
										validation="required" friendly-name="bookingNo"
										form-name="gateInForm" ></selectivity>   -->
								  <label class="control-label" align="left" >{{gateIn.bookingNo}}</label>		
										
										
	                                 </div>
                            </div>
							
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						<fieldset>
						
								<div class="form-group"  ng-if="gateIn.type=='Export' && gateIn.service=='COC'">
								<label class="col-md-5 control-label" >Gate Out No<span
									style="color: red;">*</span>
								</label>
		                     <div class="col-md-7">
							<!-- 		<selectivity list="gateOutList"
										property="gateIn.gateOutNo" id="gateOutNo"
										ng-model="gateIn.gateOutNo" name="gateOutNo"
										validation="required" friendly-name="gateOutNo"
										form-name="gateInForm" disabled="isEdit" ></selectivity>   -->
									 <label class="control-label" align="left" >{{gateIn.gateOutNo}}</label>
	                                 </div>
                            </div>
           
           			<div class="form-group"  ng-if="gateIn.type=='Import'  && gateIn.service=='COC'">
								<label class="col-md-5 control-label" >DO No<span
									style="color: red;">*</span>
								</label>
		                   <div class="col-md-7">
								<!-- 	<selectivity list="doNoList"
										property="gateIn.doNo" id="doNo"
										ng-model="gateIn.doNo" name="doNo"
										validation="required" friendly-name="doNo"
										form-name="gateInForm" disabled="isEdit" >
									</selectivity>   -->
									 <label class="control-label" align="left" >{{gateIn.doNo}}</label>
	                            
	                                      </div>
                                 </div>
              
              
              
								<div class="form-group"  ng-if="gateIn.service=='SOC'">
								<label class="col-md-5 control-label"> Depot<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<!-- <selectivity list="depotListSOC"
										property="gateIn.depot" id="depot"
										ng-model="gateIn.depot" name="depot"
										validation="required" friendly-name="depot"
										form-name="gateInForm"></selectivity> -->
										 <label class="control-label" align="left" >{{gateIn.depot}}</label>
	                            
								</div>
							</div>
							
								<div class="form-group"  ng-if="gateIn.service=='COC'">
								<label class="col-md-5 control-label"> Depot<span
									style="color: red;">*</span>
								</label>
								<div class="col-md-7">
									<!-- <selectivity list="depotList"
										property="gateIn.depot" id="depot"
										ng-model="gateIn.depot" name="depot"
										validation="required" friendly-name="depot"
										form-name="gateInForm" disabled="true"></selectivity> -->
							 <label class="control-label" align="left" >{{gateIn.depot}}</label>
	                            
								</div>
							</div>
							   
										
						</fieldset>
					</div>
					<div class="col-sm-12 col-md-4 col-lg-4">
						 <fieldset>
						 <div class="form-group">
								<label class="col-md-5 control-label">Gate IN Date<span
									style="color: red;">*</span></label>
								<div class="col-md-7">
								<div class="input-group  input-append date">
									<!-- <input type="text" class="form-control input-sm"
												id="returnDate" name="returnDate" 
											ng-model="gateIn.returnDate" validation="required"  
												friendly-name="returnDate" /> <span
												class="input-group-addon add-on"><span
												form-name="gateInForm" class="glyphicon glyphicon-calendar"></span></span> -->
											 <label class="control-label" align="left" >{{gateIn.returnDate}}</label>
	                        	
												</div>
							<!-- 	<div class="input-group  input-append date">
										<bootstrapdatetimepicker  	property="gateIn.returnDate" id="returnDate"
										name="returnDate"  ng-model="gateIn.returnDate"  friendly-name="returnDate"
										form-name="gateInForm"  />
										</div> -->
								</div>
							</div>	
							  <div class="form-group" ng-if="!isEdit">
								<label class="col-md-5 control-label">Customer<span
									style="color: red;">*</span>
								</label>
	                               	<div class="col-md-7">
							<!-- 		<selectivity list="customerList"
										property="gateIn.customer" id="customer"
										ng-model="gateIn.customer" name="customer"
										validation="required" friendly-name="customer"
										form-name="gateInForm" disabled="true"></selectivity> -->
									 <label class="control-label" align="left" >{{gateIn.customer}}</label>
	                        			
                                 	</div>
                             </div>
                               <div class="form-group" ng-if="isEdit">
								<label class="col-md-5 control-label">Customer<span
									style="color: red;">*</span>
								</label>
	                               	<div class="col-md-7">
									<!-- <selectivity list="customerList1"
										property="gateIn.customer" id="customer"
										ng-model="gateIn.customer" name="customer"
										validation="required" friendly-name="customer"
										form-name="gateInForm" disabled="true"></selectivity> -->
									 <label class="control-label" align="left" >{{gateIn.customer}}</label>
	                        			
                                 	</div>
                             </div>
							</fieldset>
					</div>
				</div>
				
				
				<div class="table-responsive clear" ng-if="gateIn.service=='COC'">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<!-- <th colspan=1 class="width_1" ng-if="!isEdit">Select</th> -->
								 <th colspan=1 class="width_15 text-center" ng-if="!isEdit">Select<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectallRec(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_15 text-center">Container Type<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_20 text-center">Container No<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Seal No<span
									style="color: red;"></span></th>
						     <th colspan=1 class="width_15 text-center">Load<label
								  class="i-checks m-b-none">
									<input type="checkbox" ng-model="selection"
									data-ng-click="selectall(selection)"><i style="margin-left: -15px;"></i>
							</label><span
									style="color: red;"></span></th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(trIndex,row) in gateIn.containerDtl">
							<!-- 	<td ng-if="!isEdit"><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								-->
									 
									<td class="width_15" align = "center" ng-if="!isEdit">
									<div class="row">
						  	<input type="checkbox" data-ng-model="row.select" id="section" name="section{{trIndex}}" 
						  	friendly-name="{{ 'Row' + $index + '(select)'}}" >
									</div>
								</td>
								<td> 
									<div class="row">
										<div class="col-xs-12">

									<!-- 		<selectivity list="containerTypeList"
												property="row.containerType" id="containerType{{trIndex}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="gateInForm" ></selectivity> -->
 <label class="control-label" align="left" >{{row.containerType}}</label>
	                        		
										</div>
									</div>
								</td>

		                        <td>
									<div class="row">
										<div class="col-xs-12">

									<!-- 		<selectivity list="containerNoList"
												property="row.containerNo" id="containerNo{{trIndex}}"
												data-ng-model="row.containerNo"
												name="containerNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerNo)'}}"
												form-name="gateInForm" ></selectivity> -->
 				<label class="control-label" align="left" >{{row.containerNo}}</label>
										</div>
									</div>
								</td>
							<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
									<!-- 		<input type="text" class="form-control input-sm" maxlength=15
											     property="row.sealNo" id="sealNo{{trIndex}}"
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}" /> -->
									 <label class="control-label" align="left" >{{row.sealNo}}</label>	
										</div>
									</div>
								</td>
									<td class="width_15" align = "center">
									<div class="row">
						      	<input type="checkbox" data-ng-model="row.emptyOrLoad" id="emptyOrLoad" name="emptyOrLoad{{trIndex}}" 
						     	friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}" >	
									</div>
								</td>
				
				
							</tr>
						</tbody>
					
					</table>
				<!-- 	<div class="padding-right-5" id="AddOrRmvebtn">
						<button ng-click="addRow()" class="btn btn-sm btn-info"
							tooltip="Add Row" ng-disabled="" type="button">
							<i class="fa fa-plus"></i>
						</button>
				
						<button ng-click="removeRow()" class="btn btn-sm btn-danger"
							type="button" tooltip="Delete">
							<i class="fa  fa-trash-o"></i>
						</button>
					</div> -->
					<br> <br> <br>
				</div>
				
				<div class="table-responsive clear" ng-if="gateIn.service=='SOC'">
					<table class="table table-striped b-t b-light">
						<thead>
							<tr>
								<th colspan=1 class="width_1">Select</th>
								<!-- <th colspan=1 class="width_10 text-center">Sub Group</th> -->
								<th colspan=1 class="width_15 text-center">Container Type<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_20 text-center">Container No<span
									style="color: red;"> </span></th>
								<th colspan=1 class="width_15 text-center">Seal No<span
									style="color: red;"></span></th>
						     <th colspan=1 class="width_15 text-center">Load<span
									style="color: red;"></span></th>

							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="(trIndex,row) in gateIn.containerDtlsoc">
								<td><label class="i-checks m-b-none"> <input
										type="checkbox" ng-model="row.select" id="section{{trIndex}}"><i></i></label></td>
								<td>
									<div class="row">
										<div class="col-xs-12">

											<selectivity list="containerTypeList"
												property="row.containerType" id="containerType{{trIndex}}"
												data-ng-model="row.containerType"
												name="containerType{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerType)'}}"
												form-name="gateInForm"></selectivity>

										</div>
									</div>
								</td>

		                        <td>
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
												data-ng-model="row.containerNo" name="containerNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(containerNo)'}}" />

										<!-- 	<input type="text"
									   class="form-control input-sm text-left" name="containerNo"
									   property="gateIn.containerNo" id="containerNo"
									    ng-model="gateIn.containerNo"
									    friendly-name="containerNo" /> -->

										</div>
									</div>
								</td>
								<td class="width_15">
									<div class="row">
										<div class="col-xs-12">
											<input type="text" class="form-control input-sm" maxlength=15
												data-ng-model="row.sealNo" name="sealNo{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(sealNo)'}}" />
										</div>
									</div>
								</td>
								
									<td class="width_15" align = "center">
									<div class="row">
									<!-- 	
									
											<input type="checkbox" class="form-control input-sm" 
												data-ng-model="row.emptyOrLoad" name="emptyOrLoad{{trIndex}}"
												friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}" /></label> -->
												
						  	<input type="checkbox" data-ng-model="row.emptyOrLoad" id="emptyOrLoad" name="emptyOrLoad{{trIndex}}" 
						  	friendly-name="{{ 'Row' + $index + '(emptyOrLoad)'}}" >
										
									
									</div>
								</td>
				
							</tr>
						</tbody>
					
					</table>
					
					<br> <br> <br>
				</div>
				
				
			</form>
		</div>
				
				</tab>
			</tabset>
			</tab>


</div>



</tabset>
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
<br>
<br>
<br>
</form>
</div>
</div>
